/*    */ package com.vladsch.flexmark.ext.emoji.internal;
/*    */ import com.vladsch.flexmark.ext.emoji.Emoji;
/*    */ import com.vladsch.flexmark.html.HtmlWriter;
/*    */ import com.vladsch.flexmark.html.renderer.LinkType;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*    */ import com.vladsch.flexmark.html.renderer.ResolvedLink;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class EmojiNodeRenderer implements NodeRenderer {
/*    */   public EmojiNodeRenderer(DataHolder paramDataHolder) {
/* 16 */     this.myOptions = new EmojiOptions(paramDataHolder);
/*    */   }
/*    */   final EmojiOptions myOptions;
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 22 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(Emoji.class, this::render));
/* 23 */     return (Set)hashSet;
/*    */   }
/*    */ 
/*    */   
/*    */   private void render(Emoji paramEmoji, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*    */     EmojiResolvedShortcut emojiResolvedShortcut;
/* 29 */     if ((emojiResolvedShortcut = EmojiResolvedShortcut.getEmojiText(paramEmoji, this.myOptions.useShortcutType, this.myOptions.useImageType, this.myOptions.rootImagePath)).emoji == null || emojiResolvedShortcut.emojiText == null) {
/*    */       
/* 31 */       paramHtmlWriter.text(":");
/* 32 */       paramNodeRendererContext.renderChildren((Node)paramEmoji);
/* 33 */       paramHtmlWriter.text(":"); return;
/*    */     } 
/* 35 */     if (emojiResolvedShortcut.isUnicode) {
/* 36 */       paramHtmlWriter.text(emojiResolvedShortcut.emojiText); return;
/*    */     } 
/* 38 */     ResolvedLink resolvedLink = paramNodeRendererContext.resolveLink(LinkType.IMAGE, emojiResolvedShortcut.emojiText, null);
/*    */     
/* 40 */     paramHtmlWriter.attr("src", resolvedLink.getUrl());
/* 41 */     paramHtmlWriter.attr("alt", emojiResolvedShortcut.alt);
/* 42 */     if (!this.myOptions.attrImageSize.isEmpty()) ((HtmlWriter)paramHtmlWriter.attr("height", this.myOptions.attrImageSize)).attr("width", this.myOptions.attrImageSize); 
/* 43 */     if (!this.myOptions.attrAlign.isEmpty()) paramHtmlWriter.attr("align", this.myOptions.attrAlign); 
/* 44 */     if (!this.myOptions.attrImageClass.isEmpty()) paramHtmlWriter.attr("class", this.myOptions.attrImageClass); 
/* 45 */     paramHtmlWriter.withAttr(resolvedLink);
/* 46 */     paramHtmlWriter.tagVoid("img");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 55 */       return new EmojiNodeRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\emoji\internal\EmojiNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */