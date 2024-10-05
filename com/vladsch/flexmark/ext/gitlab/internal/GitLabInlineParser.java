/*     */ package com.vladsch.flexmark.ext.gitlab.internal;
/*     */ 
/*     */ import com.vladsch.flexmark.ast.Text;
/*     */ import com.vladsch.flexmark.ext.gitlab.GitLabDel;
/*     */ import com.vladsch.flexmark.ext.gitlab.GitLabInline;
/*     */ import com.vladsch.flexmark.ext.gitlab.GitLabIns;
/*     */ import com.vladsch.flexmark.parser.InlineParser;
/*     */ import com.vladsch.flexmark.parser.InlineParserExtension;
/*     */ import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
/*     */ import com.vladsch.flexmark.parser.LightInlineParser;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class GitLabInlineParser
/*     */   implements InlineParserExtension
/*     */ {
/*     */   private final List<GitLabInline> openInlines;
/*     */   private final GitLabOptions options;
/*     */   
/*     */   public GitLabInlineParser(LightInlineParser paramLightInlineParser) {
/*  25 */     this.openInlines = new ArrayList<>();
/*  26 */     this.options = new GitLabOptions((DataHolder)paramLightInlineParser.getDocument());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void finalizeDocument(InlineParser paramInlineParser) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void finalizeBlock(InlineParser paramInlineParser) {
/*  37 */     for (int i = this.openInlines.size(); i-- > 0; ) {
/*  38 */       GitLabInline gitLabInline = this.openInlines.get(i);
/*  39 */       Text text = new Text(gitLabInline.getChars());
/*  40 */       gitLabInline.insertBefore((Node)text);
/*  41 */       gitLabInline.unlink();
/*     */     } 
/*     */     
/*  44 */     this.openInlines.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean parse(LightInlineParser paramLightInlineParser) {
/*  49 */     char c1 = paramLightInlineParser.peek();
/*  50 */     char c2 = paramLightInlineParser.peek(1);
/*  51 */     if ((c1 == '{' || c1 == '[') && ((this.options.insParser && c2 == '+') || (this.options.delParser && c2 == '-'))) {
/*     */       
/*  53 */       BasedSequence basedSequence = (BasedSequence)paramLightInlineParser.getInput().subSequence(paramLightInlineParser.getIndex());
/*     */       
/*  55 */       c1 = (c2 == '+') ? new GitLabIns(basedSequence.subSequence(0, 2)) : new GitLabDel(basedSequence.subSequence(0, 2));
/*  56 */       paramLightInlineParser.flushTextNode();
/*  57 */       paramLightInlineParser.getBlock().appendChild(c1);
/*  58 */       this.openInlines.add(c1);
/*  59 */       paramLightInlineParser.setIndex(paramLightInlineParser.getIndex() + 2);
/*  60 */       return true;
/*     */     } 
/*     */     
/*  63 */     if (((this.options.insParser && c1 == '+') || (this.options.delParser && c1 == '-')) && (c2 == ']' || c2 == '}')) {
/*     */       
/*  65 */       BasedSequence basedSequence2 = (BasedSequence)paramLightInlineParser.getInput().subSequence(paramLightInlineParser.getIndex());
/*     */       String str;
/*  67 */       BasedSequence basedSequence1 = BasedSequence.of(str = (String)((c2 == ']') ? ((c1 == '+') ? "[+" : "[-") : ((c1 == '+') ? "{+" : "{-")));
/*     */       
/*  69 */       for (int i = this.openInlines.size(); i-- > 0;) {
/*     */ 
/*     */         
/*  72 */         if ((basedSequence = (gitLabInline = this.openInlines.get(i)).getChars()).equals(basedSequence1)) {
/*     */           
/*  74 */           paramLightInlineParser.setIndex(paramLightInlineParser.getIndex() + 2);
/*  75 */           basedSequence1 = basedSequence2.subSequence(0, 2);
/*  76 */           gitLabInline.setOpeningMarker(basedSequence);
/*  77 */           gitLabInline.setClosingMarker(basedSequence1);
/*  78 */           gitLabInline.setText(basedSequence.baseSubSequence(basedSequence.getEndOffset(), basedSequence1.getStartOffset()));
/*     */           
/*  80 */           paramLightInlineParser.flushTextNode();
/*  81 */           Node node = paramLightInlineParser.getBlock().getLastChild();
/*  82 */           paramLightInlineParser.moveNodes((Node)gitLabInline, node);
/*     */ 
/*     */ 
/*     */           
/*  86 */           if (i == 0) {
/*  87 */             this.openInlines.clear();
/*     */           } else {
/*  89 */             this.openInlines.subList(i, this.openInlines.size()).clear();
/*     */           } 
/*     */           
/*  92 */           return true;
/*     */         } 
/*     */       } 
/*     */     } 
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     implements InlineParserExtensionFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/* 103 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public CharSequence getCharacters() {
/* 109 */       return "{[-+";
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/* 115 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public InlineParserExtension apply(LightInlineParser param1LightInlineParser) {
/* 121 */       return new GitLabInlineParser(param1LightInlineParser);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean affectsGlobalScope() {
/* 126 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gitlab\internal\GitLabInlineParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */