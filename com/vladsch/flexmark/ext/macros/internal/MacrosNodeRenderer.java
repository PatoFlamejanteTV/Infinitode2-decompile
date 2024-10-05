/*     */ package com.vladsch.flexmark.ext.macros.internal;
/*     */ import com.vladsch.flexmark.ext.macros.MacroDefinitionBlock;
/*     */ import com.vladsch.flexmark.ext.macros.MacroReference;
/*     */ import com.vladsch.flexmark.ext.macros.MacrosExtension;
/*     */ import com.vladsch.flexmark.html.HtmlRenderer;
/*     */ import com.vladsch.flexmark.html.HtmlWriter;
/*     */ import com.vladsch.flexmark.html.renderer.AttributablePart;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*     */ import com.vladsch.flexmark.html.renderer.RenderingPhase;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.NodeVisitor;
/*     */ import com.vladsch.flexmark.util.ast.VisitHandler;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class MacrosNodeRenderer implements PhasedNodeRenderer {
/*     */   private final MacrosOptions options;
/*     */   final MacroDefinitionRepository repository;
/*     */   private final boolean recheckUndefinedReferences;
/*     */   
/*     */   public MacrosNodeRenderer(DataHolder paramDataHolder) {
/*  26 */     this.options = new MacrosOptions(paramDataHolder);
/*  27 */     this.repository = (MacroDefinitionRepository)MacrosExtension.MACRO_DEFINITIONS.get(paramDataHolder);
/*  28 */     this.recheckUndefinedReferences = ((Boolean)HtmlRenderer.RECHECK_UNDEFINED_REFERENCES.get(paramDataHolder)).booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*     */     HashSet<NodeRenderingHandler> hashSet;
/*  35 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(MacroReference.class, this::render));
/*  36 */     hashSet.add(new NodeRenderingHandler(MacroDefinitionBlock.class, this::render));
/*     */     
/*  38 */     return (Set)hashSet;
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<RenderingPhase> getRenderingPhases() {
/*     */     HashSet<RenderingPhase> hashSet;
/*  44 */     (hashSet = new HashSet<>()).add(RenderingPhase.BODY_TOP);
/*     */     
/*  46 */     return hashSet;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderDocument(NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter, Document paramDocument, RenderingPhase paramRenderingPhase) {
/*  51 */     if (paramRenderingPhase == RenderingPhase.BODY_TOP && 
/*  52 */       this.recheckUndefinedReferences) {
/*     */       
/*  54 */       boolean[] arrayOfBoolean = { false };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       NodeVisitor nodeVisitor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  69 */       (nodeVisitor = new NodeVisitor(new VisitHandler[] { new VisitHandler(MacroReference.class, paramMacroReference -> { MacroDefinitionBlock macroDefinitionBlock; if (!paramMacroReference.isDefined() && (macroDefinitionBlock = paramMacroReference.getMacroDefinitionBlock(this.repository)) != null) { this.repository.addMacrosReference(macroDefinitionBlock, paramMacroReference); paramMacroReference.setMacroDefinitionBlock(macroDefinitionBlock); paramArrayOfboolean[0] = true; }  }) })).visit((Node)paramDocument);
/*  70 */       if (arrayOfBoolean[0]) {
/*  71 */         this.repository.resolveMacrosOrdinals();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void render(MacroReference paramMacroReference, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*     */     MacroDefinitionBlock macroDefinitionBlock;
/*  80 */     if ((macroDefinitionBlock = (MacroDefinitionBlock)this.repository.get(this.repository.normalizeKey((CharSequence)paramMacroReference.getText()))) != null) {
/*  81 */       if (macroDefinitionBlock.hasChildren() && !macroDefinitionBlock.isInExpansion()) {
/*     */         try {
/*  83 */           macroDefinitionBlock.setInExpansion(true);
/*     */           Node node;
/*  85 */           if (node = macroDefinitionBlock.getFirstChild() instanceof com.vladsch.flexmark.ast.Paragraph && node == macroDefinitionBlock.getLastChild()) {
/*     */             
/*  87 */             if (this.options.sourceWrapMacroReferences) {
/*  88 */               paramHtmlWriter.srcPos(paramMacroReference.getChars()).withAttr(AttributablePart.NODE_POSITION).tag("span");
/*  89 */               paramNodeRendererContext.renderChildren(node);
/*  90 */               paramHtmlWriter.tag("/span");
/*     */             } else {
/*  92 */               paramNodeRendererContext.renderChildren(node);
/*     */             }
/*     */           
/*  95 */           } else if (this.options.sourceWrapMacroReferences) {
/*  96 */             ((HtmlWriter)((HtmlWriter)paramHtmlWriter.srcPos(paramMacroReference.getChars()).withAttr(AttributablePart.NODE_POSITION).tag("div")).indent()).line();
/*  97 */             paramNodeRendererContext.renderChildren((Node)macroDefinitionBlock);
/*  98 */             ((HtmlWriter)paramHtmlWriter.unIndent()).tag("/div");
/*     */           } else {
/* 100 */             paramNodeRendererContext.renderChildren((Node)macroDefinitionBlock);
/*     */           } 
/*     */         } finally {
/*     */           
/* 104 */           macroDefinitionBlock.setInExpansion(false);
/*     */         } 
/*     */       }
/*     */     } else {
/* 108 */       paramHtmlWriter.text((CharSequence)paramMacroReference.getChars());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(MacroDefinitionBlock paramMacroDefinitionBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {}
/*     */ 
/*     */   
/*     */   public static class Factory
/*     */     implements NodeRendererFactory
/*     */   {
/*     */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 120 */       return (NodeRenderer)new MacrosNodeRenderer(param1DataHolder);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\macros\internal\MacrosNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */