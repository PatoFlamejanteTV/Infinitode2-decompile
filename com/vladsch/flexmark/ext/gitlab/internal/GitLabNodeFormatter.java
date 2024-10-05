/*    */ package com.vladsch.flexmark.ext.gitlab.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.gitlab.GitLabBlockQuote;
/*    */ import com.vladsch.flexmark.formatter.MarkdownWriter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterContext;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.formatter.NodeFormattingHandler;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import java.util.Collections;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ public class GitLabNodeFormatter
/*    */   implements NodeFormatter
/*    */ {
/*    */   public GitLabNodeFormatter(DataHolder paramDataHolder) {}
/*    */   
/*    */   public Set<NodeFormattingHandler<?>> getNodeFormattingHandlers() {
/* 22 */     return new HashSet<>(Collections.singletonList(new NodeFormattingHandler(GitLabBlockQuote.class, this::render)));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<Class<?>> getNodeClasses() {
/* 30 */     return new HashSet<>(Collections.singletonList(GitLabBlockQuote.class));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void render(GitLabBlockQuote paramGitLabBlockQuote, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 36 */     ((MarkdownWriter)paramMarkdownWriter.append(">>>")).line();
/* 37 */     paramNodeFormatterContext.renderChildren((Node)paramGitLabBlockQuote);
/* 38 */     ((MarkdownWriter)paramMarkdownWriter.append(">>>")).line();
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements NodeFormatterFactory
/*    */   {
/*    */     public NodeFormatter create(DataHolder param1DataHolder) {
/* 45 */       return new GitLabNodeFormatter(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gitlab\internal\GitLabNodeFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */