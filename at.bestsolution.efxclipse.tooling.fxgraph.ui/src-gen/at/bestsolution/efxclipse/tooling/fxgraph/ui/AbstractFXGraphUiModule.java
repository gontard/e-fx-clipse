
/*
 * generated by Xtext
 */
package at.bestsolution.efxclipse.tooling.fxgraph.ui;

import org.eclipse.xtext.ui.DefaultUiModule;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Manual modifications go to {at.bestsolution.efxclipse.tooling.fxgraph.ui.FXGraphUiModule}
 */
@SuppressWarnings("all")
public abstract class AbstractFXGraphUiModule extends DefaultUiModule {
	
	public AbstractFXGraphUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	
	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public com.google.inject.Provider<org.eclipse.xtext.resource.containers.IAllContainersState> provideIAllContainersState() {
		return org.eclipse.xtext.ui.shared.Access.getJavaProjectsState();
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper> bindIProposalConflictHelper() {
		return org.eclipse.xtext.ui.editor.contentassist.antlr.AntlrProposalConflictHelper.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public void configureHighlightingLexer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING)).to(at.bestsolution.efxclipse.tooling.fxgraph.parser.antlr.internal.InternalFXGraphLexer.class);
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public void configureHighlightingTokenDefProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.ITokenDefProvider.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING)).to(org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider.class);
	}

	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	public void configureIResourceDescriptionsBuilderScope(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE)).to(org.eclipse.xtext.builder.clustering.CurrentDescriptions.ResourceSetAware.class);
	}

	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	public Class<? extends org.eclipse.xtext.ui.editor.IXtextEditorCallback> bindIXtextEditorCallback() {
		return org.eclipse.xtext.builder.nature.NatureAddingEditorCallback.class;
	}

	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	public void configureIResourceDescriptionsPersisted(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.builder.impl.PersistentDataAwareDirtyResource.PERSISTED_DESCRIPTIONS)).to(org.eclipse.xtext.builder.builderState.IBuilderState.class);
	}

	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	public Class<? extends org.eclipse.xtext.ui.editor.DocumentBasedDirtyResource> bindDocumentBasedDirtyResource() {
		return org.eclipse.xtext.builder.impl.PersistentDataAwareDirtyResource.class;
	}

	// contributed by org.eclipse.xtext.generator.generator.GeneratorFragment
	public Class<? extends org.eclipse.xtext.builder.IXtextBuilderParticipant> bindIXtextBuilderParticipant() {
		return org.eclipse.xtext.builder.JavaProjectBasedBuilderParticipant.class;
	}

	// contributed by org.eclipse.xtext.generator.generator.GeneratorFragment
	public org.eclipse.core.resources.IWorkspaceRoot bindIWorkspaceRootToInstance() {
		return org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot();
	}

	// contributed by org.eclipse.xtext.ui.generator.labeling.LabelProviderFragment
	public Class<? extends org.eclipse.jface.viewers.ILabelProvider> bindILabelProvider() {
		return at.bestsolution.efxclipse.tooling.fxgraph.ui.labeling.FXGraphLabelProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.labeling.LabelProviderFragment
	public void configureResourceUIServiceLabelProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.jface.viewers.ILabelProvider.class).annotatedWith(org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider.class).to(at.bestsolution.efxclipse.tooling.fxgraph.ui.labeling.FXGraphDescriptionLabelProvider.class);
	}

	// contributed by org.eclipse.xtext.ui.generator.outline.OutlineTreeProviderFragment
	public Class<? extends org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider> bindIOutlineTreeProvider() {
		return at.bestsolution.efxclipse.tooling.fxgraph.ui.outline.FXGraphOutlineTreeProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.outline.OutlineTreeProviderFragment
	public Class<? extends org.eclipse.xtext.ui.editor.outline.impl.IOutlineTreeStructureProvider> bindIOutlineTreeStructureProvider() {
		return at.bestsolution.efxclipse.tooling.fxgraph.ui.outline.FXGraphOutlineTreeProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.quickfix.QuickfixProviderFragment
	public Class<? extends org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider> bindIssueResolutionProvider() {
		return at.bestsolution.efxclipse.tooling.fxgraph.ui.quickfix.FXGraphQuickfixProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.contentAssist.JavaBasedContentAssistFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider> bindIContentProposalProvider() {
		return at.bestsolution.efxclipse.tooling.fxgraph.ui.contentassist.FXGraphProposalProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext.Factory> bindContentAssistContext$Factory() {
		return org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser> bindIContentAssistParser() {
		return at.bestsolution.efxclipse.tooling.fxgraph.ui.contentassist.antlr.FXGraphParser.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public void configureContentAssistLexerProvider(com.google.inject.Binder binder) {
		binder.bind(at.bestsolution.efxclipse.tooling.fxgraph.ui.contentassist.antlr.internal.InternalFXGraphLexer.class).toProvider(org.eclipse.xtext.parser.antlr.LexerProvider.create(at.bestsolution.efxclipse.tooling.fxgraph.ui.contentassist.antlr.internal.InternalFXGraphLexer.class));
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public void configureContentAssistLexer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.CONTENT_ASSIST)).to(at.bestsolution.efxclipse.tooling.fxgraph.ui.contentassist.antlr.internal.InternalFXGraphLexer.class);
	}

	// contributed by org.eclipse.xtext.generator.types.TypesGeneratorFragment
	public java.lang.ClassLoader bindClassLoaderToInstance() {
		return getClass().getClassLoader();
	}

	// contributed by org.eclipse.xtext.generator.types.TypesGeneratorFragment
	public Class<? extends org.eclipse.xtext.common.types.access.IJvmTypeProvider.Factory> bindIJvmTypeProvider$Factory() {
		return org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory.class;
	}

	// contributed by org.eclipse.xtext.generator.types.TypesGeneratorFragment
	public Class<? extends org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider> bindAbstractTypeScopeProvider() {
		return org.eclipse.xtext.common.types.xtext.ui.JdtBasedSimpleTypeScopeProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.types.TypesGeneratorFragment
	public Class<? extends org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider> bindITypesProposalProvider() {
		return org.eclipse.xtext.common.types.xtext.ui.JdtTypesProposalProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.types.TypesGeneratorFragment
	public Class<? extends org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider> bindIJavaProjectProvider() {
		return org.eclipse.xtext.common.types.xtext.ui.XtextResourceSetBasedProjectProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.types.TypesGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper> bindIHyperlinkHelper() {
		return org.eclipse.xtext.common.types.xtext.ui.TypeAwareHyperlinkHelper.class;
	}

	// contributed by org.eclipse.xtext.generator.types.TypesGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher> bindPrefixMatcher() {
		return org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		return org.eclipse.xtext.xbase.ui.syntaxcoloring.XbaseTokenToAttributeIdMapper.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider.ReferenceProposalCreator> bindAbstractJavaBasedContentProposalProvider$ReferenceProposalCreator() {
		return org.eclipse.xtext.xbase.ui.contentassist.XbaseReferenceProposalCreator.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.jface.text.contentassist.IContentAssistProcessor> bindIContentAssistProcessor() {
		return org.eclipse.xtext.ui.editor.contentassist.RepeatedContentAssistProcessor.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return org.eclipse.xtext.xbase.ui.highlighting.XbaseHighlightingCalculator.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return org.eclipse.xtext.xbase.ui.hover.XbaseHoverProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.findrefs.FindReferenceQueryDataFactory> bindFindReferenceQueryDataFactory() {
		return org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JvmModelFindReferenceQueryDataFactory.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator> bindIDependentElementsCalculator() {
		return org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelDependentElementsCalculator.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.refactoring.impl.RefactoringReferenceQueryDataFactory> bindRefactoringReferenceQueryDataFactory() {
		return org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelFindRefsQueryDataFactory.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.refactoring.IReferenceUpdater> bindIReferenceUpdater() {
		return org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelReferenceUpdater.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.refactoring.IRenameStrategy.Provider> bindIRenameStrategy$Provider() {
		return at.bestsolution.efxclipse.tooling.fxgraph.ui.refactoring.FXGraphRenameStrategy.Provider.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.refactoring.impl.RefactoringResourceSetProvider> bindRefactoringResourceSetProvider() {
		return org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelRefactoringResourceSetProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment
	public com.google.inject.Provider<org.eclipse.xtext.ui.codetemplates.ui.preferences.TemplatesLanguageConfiguration> provideTemplatesLanguageConfiguration() {
		return org.eclipse.xtext.ui.codetemplates.ui.AccessibleCodetemplatesActivator.getTemplatesLanguageConfigurationProvider();
	}

	// contributed by org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment
	public com.google.inject.Provider<org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistry> provideLanguageRegistry() {
		return org.eclipse.xtext.ui.codetemplates.ui.AccessibleCodetemplatesActivator.getLanguageRegistry();
	}

	// contributed by org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment
	@org.eclipse.xtext.service.SingletonBinding(eager=true)	public Class<? extends org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistrar> bindLanguageRegistrar() {
		return org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistrar.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.templates.XtextTemplatePreferencePage> bindXtextTemplatePreferencePage() {
		return org.eclipse.xtext.ui.codetemplates.ui.preferences.AdvancedTemplatesPreferencePage.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.codetemplates.ui.partialEditing.IPartialContentAssistParser> bindIPartialContentAssistParser() {
		return at.bestsolution.efxclipse.tooling.fxgraph.ui.contentassist.antlr.PartialFXGraphContentAssistParser.class;
	}


}
