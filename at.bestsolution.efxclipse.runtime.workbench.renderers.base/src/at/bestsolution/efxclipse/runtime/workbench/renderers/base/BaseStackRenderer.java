/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package at.bestsolution.efxclipse.runtime.workbench.renderers.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MContext;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPlaceholder;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

import at.bestsolution.efxclipse.runtime.workbench.base.rendering.AbstractRenderer;
import at.bestsolution.efxclipse.runtime.workbench.base.rendering.RendererFactory;
import at.bestsolution.efxclipse.runtime.workbench.renderers.base.widget.WCallback;
import at.bestsolution.efxclipse.runtime.workbench.renderers.base.widget.WLayoutedWidget;
import at.bestsolution.efxclipse.runtime.workbench.renderers.base.widget.WPlaceholderWidget;
import at.bestsolution.efxclipse.runtime.workbench.renderers.base.widget.WStack;
import at.bestsolution.efxclipse.runtime.workbench.renderers.base.widget.WStack.WStackItem;

@SuppressWarnings("restriction")
public abstract class BaseStackRenderer<N, I, IC> extends BaseRenderer<MPartStack, WStack<N, I, IC>> {
	// private static final String MAP_ITEM_KEY = "fx.rendering.stackitem";
	
	@Inject
	RendererFactory factory;
	
	@Inject
	MApplication application;
	
	boolean inLazyInit;
	
	@PostConstruct
	void init(IEventBroker eventBroker) {
		eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_CHILDREN, new EventHandler() {

			@Override
			public void handleEvent(Event event) {
				Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
				if (changedObj instanceof MPartStack) {
					MPartStack parent = (MPartStack) changedObj;
					if (BaseStackRenderer.this == parent.getRenderer()) {
						String eventType = (String) event.getProperty(UIEvents.EventTags.TYPE); 
						
						if (UIEvents.EventTypes.ADD.equals(eventType)) {
							MUIElement element = (MUIElement) event.getProperty(UIEvents.EventTags.NEW_VALUE);
							handleChildAddition(parent, (MStackElement) element);
						} else if (UIEvents.EventTypes.REMOVE.equals(eventType)) {
							MUIElement element = (MUIElement) event.getProperty(UIEvents.EventTags.OLD_VALUE);
							handleChildRemove(parent, (MStackElement) element);
						}
					}
				}
			}
		});
		eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_SELECTEDELEMENT, new EventHandler() {

			@Override
			public void handleEvent(Event event) {
				Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
				if (changedObj instanceof MPartStack) {
					MPartStack parent = (MPartStack) changedObj;
					if (BaseStackRenderer.this == parent.getRenderer()) {
						String eventType = (String) event.getProperty(UIEvents.EventTags.TYPE);
						if (UIEvents.EventTypes.SET.equals(eventType)) {
							MUIElement newValue = (MUIElement) event.getProperty(UIEvents.EventTags.NEW_VALUE);
							MUIElement oldValue = (MUIElement) event.getProperty(UIEvents.EventTags.OLD_VALUE);
							handleSelectedElement(parent, (MStackElement) oldValue, (MStackElement) newValue);
						}
					}
				}
			}
		});
		eventBroker.subscribe(UIEvents.UIElement.TOPIC_VISIBLE, new EventHandler() {
			
			@Override
			public void handleEvent(Event event) {
				MUIElement changedObj = (MUIElement) event.getProperty(UIEvents.EventTags.ELEMENT);
				if( changedObj.isToBeRendered() ) {
					MUIElement parent = changedObj.getParent();
					if( parent != null ) {
						if( BaseStackRenderer.this == parent.getRenderer() ) {
							MPartStack stack = (MPartStack) parent;
							String eventType = (String) event.getProperty(UIEvents.EventTags.TYPE);
							if (UIEvents.EventTypes.SET.equals(eventType)) {
								Boolean newValue = (Boolean) event.getProperty(UIEvents.EventTags.NEW_VALUE);
								if( newValue.booleanValue() ) {
									//TODO Is childRendered not dangerous to call here??
									childRendered(stack, changedObj);
								} else {
									hideChild(stack, changedObj);
								}
							}
						}	
					}
				}
			}
		});
	}

	MPart getPart(MUIElement element) {
		if( element instanceof MPlaceholder ) {
			return (MPart) ((MPlaceholder) element).getRef();
		} else if (element instanceof MElementContainer<?>) {
			@SuppressWarnings("unchecked")
			MElementContainer<MUIElement> container = (MElementContainer<MUIElement>) element;
			element = container.getSelectedElement();
			if ((element == null) && !container.getChildren().isEmpty()) {
				element = container.getChildren().get(0);
			}
			return getPart(element);
		} else {
			return (MPart) element;
		}
	}
	
	@Override
	protected void initWidget(final MPartStack element, final WStack<N, I, IC> widget) {
		super.initWidget(element, widget);
		widget.setMouseSelectedItemCallback(new WCallback<WStackItem<I, IC>, Void>() {

			@Override
			public Void call(WStackItem<I, IC> param) {
				if (param.getDomElement() != null) {
					activatationJob(element,getPart(param.getDomElement()),true);
				}

				return null;
			}
		});
		widget.setKeySelectedItemCallback(new WCallback<WStackItem<I, IC>, Void>() {

			@Override
			public Void call(WStackItem<I, IC> param) {
				if (param.getDomElement() != null) {
					activatationJob(element,getPart(param.getDomElement()),false);
				}

				return null;
			}
		});
		
		widget.registerActivationCallback(new WCallback<Boolean, Void>() {
			
			@Override
			public Void call(Boolean param) {
				if( param.booleanValue() && element.getSelectedElement() != null ) {
					activatationJob(element,getPart(element.getSelectedElement()), true);
				}
				return null;
			}
		});
	}
	
	private void activatationJob(MPartStack stackToActivate, final MPart p, final boolean focus) {
		if( shouldActivate(stackToActivate) ) {
			activate(p, focus);	
		}
	}

	private boolean shouldActivate(MPartStack stackToActivate) {
		if (inContentProcessing(stackToActivate)) {
			return false;
		}
		
		if (application != null) {
			IEclipseContext applicationContext = application.getContext();
			IEclipseContext activeChild = applicationContext
					.getActiveChild();
			if (activeChild == null
					|| activeChild.get(MWindow.class) != application
							.getSelectedElement()
					|| application.getSelectedElement() != modelService
							.getTopLevelWindowFor(stackToActivate)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void doProcessContent(MPartStack element) {
		WStack<N, I, IC> stack = getWidget(element);
		List<WStackItem<I, IC>> items = new ArrayList<WStackItem<I, IC>>();
		WStackItem<I, IC> initalItem = null;

		for (MStackElement e : element.getChildren()) {
			// Precreate the rendering context for the subitem
			AbstractRenderer<MStackElement, ?> renderer = factory.getRenderer(e);
			if (renderer != null && e.isToBeRendered() && e.isVisible() ) {
				WStackItem<I, IC> item = createStackItem(stack, e, renderer);
				items.add(item);

				if (e == element.getSelectedElement()) {
					initalItem = item;
				}
			}
		}

		if (!items.isEmpty()) {
			if (initalItem == null || items.size() == 1 || items.get(0) == initalItem) {
				stack.addItems(items);
			} else {
				stack.addItem(initalItem);
				if (items.get(items.size() - 1) == initalItem) {
					stack.addItems(0, items.subList(0, items.size() - 1));
				} else {
					int idx = items.indexOf(initalItem);
					stack.addItems(0, items.subList(0, idx));
					stack.addItems(items.subList(idx + 1, items.size()));
				}

			}
		}

		stack.selectItem(stack.getItems().indexOf(initalItem));
	}

	private WStackItem<I, IC> createStackItem(WStack<N, I, IC> stack, final MStackElement e, AbstractRenderer<MStackElement, ?> renderer) {
		IEclipseContext context = renderer.setupRenderingContext(e);
		WStackItem<I, IC> item = ContextInjectionFactory.make(stack.getStackItemClass(), context);
		item.setDomElement(e);
		item.setInitCallback(new WCallback<WStackItem<I, IC>, IC>() {

			@SuppressWarnings("unchecked")
			@Override
			public IC call(WStackItem<I, IC> param) {
				inLazyInit = true;
				try {
					WLayoutedWidget<MStackElement> widget = engineCreateWidget(e);
					if (widget != null) {
						return (IC) widget.getStaticLayoutNode();
					}
					return null;					
				} finally {
					inLazyInit = false;
				}
			}
		});
		item.setOnCloseCallback(new WCallback<WStack.WStackItem<I, IC>, Boolean>() {

			@Override
			public Boolean call(WStackItem<I, IC> param) {
				return ! handleStackItemClose(e, param);
			}
		});

		return item;
	}

	void handleChildAddition(MPartStack parent, MStackElement element) {
		if( element.isToBeRendered() && element.isVisible() ) {
			int idx = getRenderedIndex(parent, element);

			AbstractRenderer<MStackElement, ?> renderer = factory.getRenderer(element);
			WStack<N, I, IC> stack = getWidget(parent);
			WStackItem<I, IC> item = createStackItem(getWidget(parent), element, renderer);

			stack.addItems(idx, Collections.singletonList(item));
		}
	}

	void handleChildRemove(MPartStack parent, MStackElement element) {
		if( element.isToBeRendered() && element.isVisible() ) {
			hideChild(parent, element);
		}
	}

	void handleSelectedElement(MPartStack parent, MStackElement oldElement, MStackElement newElement) {
		WStack<N, I, IC> stack = getWidget(parent);
		int idx = 0;
		for( WStackItem<I, IC> i : stack.getItems() ) {
			if( i.getDomElement() == newElement ) {
				stack.selectItem(idx);
				showElementRecursive(newElement);
				break;
			}
			idx++;
		}
	}

	boolean handleStackItemClose(MStackElement e, WStackItem<I, IC> item) {
		MPart part = getPart(e);
		if( ! part.isCloseable() ) {
			return false;
		}
		
		IEclipseContext partContext = part.getContext();
		IEclipseContext parentContext = getContextForParent(part);
		// a part may not have a context if it hasn't been rendered
		IEclipseContext context = partContext == null ? parentContext : partContext;
		// Allow closes to be 'canceled'
		EPartService partService = (EPartService) context
				.get(EPartService.class.getName());
		if (partService.savePart(part, true)) {
			partService.hidePart(part);
			return true;
		}
		// the user has canceled out of the save operation, so don't close the
		// part
		return false;
		
	}
	
	@Override
	public void childRendered(MPartStack parentElement, MUIElement element) {
		if( inLazyInit || inContentProcessing(parentElement) || ! element.isVisible() ) {
			return;
		}

		WStack<N, I, IC> stack = getWidget(parentElement);
		for( WStackItem<I, IC> i : stack.getItems() ) {
			if( i.getDomElement() == element ) {
				return;
			}
		}
		
		int idx = getRenderedIndex(parentElement, element);
		AbstractRenderer<MStackElement, ?> renderer = factory.getRenderer(element);
		stack.addItems(idx, Collections.singletonList(createStackItem(stack, (MStackElement)element, renderer)));
	}
	
	@Override
	public void hideChild(MPartStack container, MUIElement changedObj) {
		WStack<N, I, IC> stack = getWidget(container);
		if( stack == null ) {
			return;
		}
		
		WStackItem<I, IC> item = null;
		
		for( WStackItem<I, IC> i : stack.getItems() ) {
			if( i.getDomElement() == changedObj ) {
				item = i;
				break;
			}
		}
		
		if( item != null ) {
			List<WStackItem<I, IC>> l = Collections.singletonList(item);
			stack.removeItems(l); 
		}
	}
	
	private void showElementRecursive(MUIElement element) {
		if( ! element.isToBeRendered() ) {
			return;
		}
		
		if (element instanceof MPlaceholder && element.getWidget() != null) {
			MPlaceholder ph = (MPlaceholder) element;
			MUIElement ref = ph.getRef();
			
			if( ref.getCurSharedRef() != ph ) {
				ref.setCurSharedRef(ph);
				WPlaceholderWidget placeholder = (WPlaceholderWidget) ph.getWidget();
				@SuppressWarnings("unchecked")
				WLayoutedWidget<MUIElement> content = (WLayoutedWidget<MUIElement>) ref.getWidget();
				placeholder.setContent(content);
			}
			
			element = ref;
		}
		
		if (element instanceof MContext) {
			IEclipseContext context = ((MContext) element).getContext();
			if (context != null) {
				IEclipseContext newParentContext = modelService.getContainingContext(element);
				if (context.getParent() != newParentContext) {
					context.setParent(newParentContext);
				}
			}
		}
		
		// Currently not supported in the model but will very likely be in future
		if (element instanceof MElementContainer<?>) {
			MElementContainer<?> container = (MElementContainer<?>) element;
			List<MUIElement> kids = new ArrayList<MUIElement>(
					container.getChildren());
			for (MUIElement childElement : kids) {
				showElementRecursive(childElement);
			}
		}
	}
}