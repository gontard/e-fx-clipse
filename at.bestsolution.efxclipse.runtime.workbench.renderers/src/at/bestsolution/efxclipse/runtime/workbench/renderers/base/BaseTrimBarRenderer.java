package at.bestsolution.efxclipse.runtime.workbench.renderers.base;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimElement;

import at.bestsolution.efxclipse.runtime.workbench.renderers.widgets.WTrimBar;
import at.bestsolution.efxclipse.runtime.workbench.renderers.widgets.WWidget;

@SuppressWarnings("restriction")
public abstract class BaseTrimBarRenderer<N> extends BaseRenderer<MTrimBar, WTrimBar<N>> {

	@Override
	public void processContent(MTrimBar element) {
		WTrimBar<N> trimBar = getWidget(element);
		for( MTrimElement e : element.getChildren() ) {
			WWidget<MTrimElement> trimElementWidget = engineCreateWidget(e);
			if( trimElementWidget != null ) {
				trimBar.addChild(trimElementWidget);
			}
		}
	}

	@Override
	public void childRendered(MTrimBar parentElement, MUIElement element) {
		// TODO Auto-generated method stub
	}
}