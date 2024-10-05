/*    */ package com.vladsch.flexmark.ext.emoji.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.emoji.Emoji;
/*    */ import com.vladsch.flexmark.formatter.MarkdownWriter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterContext;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.formatter.NodeFormattingHandler;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EmojiNodeFormatter
/*    */   implements NodeFormatter
/*    */ {
/*    */   public EmojiNodeFormatter(DataHolder paramDataHolder) {}
/*    */   
/*    */   public Set<Class<?>> getNodeClasses() {
/* 21 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<NodeFormattingHandler<?>> getNodeFormattingHandlers() {
/*    */     HashSet<NodeFormattingHandler> hashSet;
/* 29 */     (hashSet = new HashSet<>()).add(new NodeFormattingHandler(Emoji.class, this::render));
/* 30 */     return (Set)hashSet;
/*    */   }
/*    */   
/*    */   void render(Emoji paramEmoji, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 34 */     paramMarkdownWriter.append((CharSequence)paramEmoji.getOpeningMarker());
/* 35 */     paramMarkdownWriter.appendNonTranslating((CharSequence)paramEmoji.getText());
/* 36 */     paramMarkdownWriter.append((CharSequence)paramEmoji.getClosingMarker());
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements NodeFormatterFactory
/*    */   {
/*    */     public NodeFormatter create(DataHolder param1DataHolder) {
/* 43 */       return new EmojiNodeFormatter(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\emoji\internal\EmojiNodeFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */