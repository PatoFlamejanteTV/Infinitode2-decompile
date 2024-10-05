/*    */ package com.vladsch.flexmark.ext.aside.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.aside.AsideBlock;
/*    */ import com.vladsch.flexmark.formatter.FormatterUtils;
/*    */ import com.vladsch.flexmark.formatter.MarkdownWriter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterContext;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.formatter.NodeFormattingHandler;
/*    */ import com.vladsch.flexmark.util.ast.BlockQuoteLike;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class AsideNodeFormatter
/*    */   implements NodeFormatter
/*    */ {
/*    */   public AsideNodeFormatter(DataHolder paramDataHolder) {}
/*    */   
/*    */   public Set<Class<?>> getNodeClasses() {
/* 21 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public char getBlockQuoteLikePrefixChar() {
/* 26 */     return '|';
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<NodeFormattingHandler<?>> getNodeFormattingHandlers() {
/*    */     HashSet<NodeFormattingHandler> hashSet;
/* 34 */     (hashSet = new HashSet<>()).add(new NodeFormattingHandler(AsideBlock.class, this::render));
/* 35 */     return (Set)hashSet;
/*    */   }
/*    */   
/*    */   private void render(AsideBlock paramAsideBlock, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 39 */     FormatterUtils.renderBlockQuoteLike((BlockQuoteLike)paramAsideBlock, paramNodeFormatterContext, paramMarkdownWriter);
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements NodeFormatterFactory
/*    */   {
/*    */     public NodeFormatter create(DataHolder param1DataHolder) {
/* 46 */       return new AsideNodeFormatter(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\aside\internal\AsideNodeFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */