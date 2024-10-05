/*    */ package com.vladsch.flexmark.ext.escaped.character.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.escaped.character.EscapedCharacter;
/*    */ import com.vladsch.flexmark.html.HtmlWriter;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class EscapedCharacterNodeRenderer
/*    */   implements NodeRenderer
/*    */ {
/*    */   private final EscapedCharacterOptions options;
/*    */   
/*    */   public EscapedCharacterNodeRenderer(DataHolder paramDataHolder) {
/* 19 */     this.options = new EscapedCharacterOptions(paramDataHolder);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 25 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(EscapedCharacter.class, this::render));
/*    */     
/* 27 */     return (Set)hashSet;
/*    */   }
/*    */   
/*    */   private void render(EscapedCharacter paramEscapedCharacter, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 31 */     paramHtmlWriter.text(paramEscapedCharacter.getChars().unescape());
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 38 */       return new EscapedCharacterNodeRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\escaped\character\internal\EscapedCharacterNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */