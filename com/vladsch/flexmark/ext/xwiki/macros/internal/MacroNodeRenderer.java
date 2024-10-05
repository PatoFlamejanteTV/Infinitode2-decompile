/*    */ package com.vladsch.flexmark.ext.xwiki.macros.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.xwiki.macros.Macro;
/*    */ import com.vladsch.flexmark.ext.xwiki.macros.MacroAttribute;
/*    */ import com.vladsch.flexmark.ext.xwiki.macros.MacroBlock;
/*    */ import com.vladsch.flexmark.ext.xwiki.macros.MacroClose;
/*    */ import com.vladsch.flexmark.html.HtmlWriter;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class MacroNodeRenderer
/*    */   implements NodeRenderer {
/*    */   private final MacroOptions options;
/*    */   
/*    */   public MacroNodeRenderer(DataHolder paramDataHolder) {
/* 23 */     this.options = new MacroOptions(paramDataHolder);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 29 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(Macro.class, this::render));
/* 30 */     hashSet.add(new NodeRenderingHandler(MacroAttribute.class, this::render));
/* 31 */     hashSet.add(new NodeRenderingHandler(MacroClose.class, this::render));
/* 32 */     hashSet.add(new NodeRenderingHandler(MacroBlock.class, this::render));
/* 33 */     return (Set)hashSet;
/*    */   }
/*    */   
/*    */   private void render(Macro paramMacro, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 37 */     if (this.options.enableRendering) {
/* 38 */       paramHtmlWriter.text((CharSequence)Node.spanningChars(new BasedSequence[] { paramMacro.getOpeningMarker(), paramMacro.getClosingMarker() }));
/* 39 */       paramNodeRendererContext.renderChildren((Node)paramMacro);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private void render(MacroAttribute paramMacroAttribute, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {}
/*    */ 
/*    */   
/*    */   private void render(MacroClose paramMacroClose, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 48 */     if (this.options.enableRendering) paramHtmlWriter.text((CharSequence)Node.spanningChars(new BasedSequence[] { paramMacroClose.getOpeningMarker(), paramMacroClose.getClosingMarker() })); 
/*    */   }
/*    */   
/*    */   private void render(MacroBlock paramMacroBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 52 */     if (this.options.enableRendering) paramNodeRendererContext.renderChildren((Node)paramMacroBlock); 
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 59 */       return new MacroNodeRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\xwiki\macros\internal\MacroNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */