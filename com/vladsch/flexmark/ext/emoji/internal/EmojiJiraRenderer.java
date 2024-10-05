/*    */ package com.vladsch.flexmark.ext.emoji.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.emoji.Emoji;
/*    */ import com.vladsch.flexmark.html.HtmlWriter;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class EmojiJiraRenderer implements NodeRenderer {
/*    */   public static final HashMap<String, String> shortCutMap;
/*    */   
/*    */   static {
/* 19 */     (shortCutMap = new HashMap<>()).put("smile", ":)");
/* 20 */     shortCutMap.put("frowning", ":(");
/* 21 */     shortCutMap.put("stuck_out_tongue", ":P");
/* 22 */     shortCutMap.put("grinning", ":D");
/* 23 */     shortCutMap.put("wink", ";)");
/* 24 */     shortCutMap.put("thumbsup", "(y)");
/* 25 */     shortCutMap.put("thumbsdown", "(n)");
/* 26 */     shortCutMap.put("information_source", "(i)");
/* 27 */     shortCutMap.put("white_check_mark", "(/)");
/* 28 */     shortCutMap.put("x", "(x)");
/* 29 */     shortCutMap.put("warning", "(!)");
/* 30 */     shortCutMap.put("heavy_plus_sign", "(+)");
/* 31 */     shortCutMap.put("heavy_minus_sign", "(-)");
/* 32 */     shortCutMap.put("question", "(?)");
/* 33 */     shortCutMap.put("bulb", "(on)");
/* 34 */     shortCutMap.put("star", "(*)");
/* 35 */     shortCutMap.put("triangular_flag_on_post", "(flag)");
/* 36 */     shortCutMap.put("crossed_flags", "(flagoff)");
/*    */   }
/*    */ 
/*    */   
/*    */   public EmojiJiraRenderer(DataHolder paramDataHolder) {}
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 44 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(Emoji.class, this::render));
/* 45 */     return (Set)hashSet;
/*    */   }
/*    */   
/*    */   private void render(Emoji paramEmoji, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 49 */     Emoji emoji = paramEmoji;
/*    */     String str;
/* 51 */     if ((str = shortCutMap.get(emoji.getText().toString())) == null) {
/*    */       
/* 53 */       paramHtmlWriter.text(":");
/* 54 */       paramNodeRendererContext.renderChildren((Node)paramEmoji);
/* 55 */       paramHtmlWriter.text(":"); return;
/*    */     } 
/* 57 */     paramHtmlWriter.raw(str);
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 65 */       return new EmojiJiraRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\emoji\internal\EmojiJiraRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */