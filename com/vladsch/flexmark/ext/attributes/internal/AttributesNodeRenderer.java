/*    */ package com.vladsch.flexmark.ext.attributes.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.TextBase;
/*    */ import com.vladsch.flexmark.ext.attributes.AttributesNode;
/*    */ import com.vladsch.flexmark.html.HtmlWriter;
/*    */ import com.vladsch.flexmark.html.renderer.AttributablePart;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.html.Attributes;
/*    */ import com.vladsch.flexmark.util.html.MutableAttributes;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class AttributesNodeRenderer implements NodeRenderer {
/*    */   private final AttributesOptions myOptions;
/*    */   
/*    */   public AttributesNodeRenderer(DataHolder paramDataHolder) {
/* 21 */     this.myOptions = new AttributesOptions(paramDataHolder);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 28 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(AttributesNode.class, (paramAttributesNode, paramNodeRendererContext, paramHtmlWriter) -> {
/*    */           
/*    */           }));
/* 31 */     hashSet.add(new NodeRenderingHandler(TextBase.class, (paramTextBase, paramNodeRendererContext, paramHtmlWriter) -> {
/*    */             MutableAttributes mutableAttributes;
/*    */             
/*    */             if (this.myOptions.assignTextAttributes && !(mutableAttributes = paramNodeRendererContext.extendRenderingNodeAttributes(AttributablePart.NODE, null)).isEmpty()) {
/*    */               ((HtmlWriter)paramHtmlWriter.setAttributes((Attributes)mutableAttributes)).withAttr().tag("span");
/*    */               
/*    */               paramNodeRendererContext.delegateRender();
/*    */               
/*    */               paramHtmlWriter.closeTag("span");
/*    */               return;
/*    */             } 
/*    */             paramNodeRendererContext.delegateRender();
/*    */           }));
/* 44 */     return (Set)hashSet;
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 51 */       return new AttributesNodeRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\attributes\internal\AttributesNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */