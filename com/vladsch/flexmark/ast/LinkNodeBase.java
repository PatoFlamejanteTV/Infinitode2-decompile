/*     */ package com.vladsch.flexmark.ast;
/*     */ 
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ 
/*     */ public abstract class LinkNodeBase extends Node {
/*   7 */   protected BasedSequence urlOpeningMarker = BasedSequence.NULL;
/*   8 */   protected BasedSequence url = BasedSequence.NULL;
/*   9 */   protected BasedSequence pageRef = BasedSequence.NULL;
/*  10 */   protected BasedSequence anchorMarker = BasedSequence.NULL;
/*  11 */   protected BasedSequence anchorRef = BasedSequence.NULL;
/*  12 */   protected BasedSequence urlClosingMarker = BasedSequence.NULL;
/*  13 */   protected BasedSequence titleOpeningMarker = BasedSequence.NULL;
/*  14 */   protected BasedSequence title = BasedSequence.NULL;
/*  15 */   protected BasedSequence titleClosingMarker = BasedSequence.NULL;
/*     */ 
/*     */   
/*     */   public LinkNodeBase() {}
/*     */   
/*     */   public LinkNodeBase(BasedSequence paramBasedSequence) {
/*  21 */     super(paramBasedSequence);
/*     */   }
/*     */   
/*     */   public void setTitleChars(BasedSequence paramBasedSequence) {
/*  25 */     if (paramBasedSequence != null && paramBasedSequence != BasedSequence.NULL) {
/*  26 */       int i = paramBasedSequence.length();
/*  27 */       this.titleOpeningMarker = paramBasedSequence.subSequence(0, 1);
/*  28 */       this.title = paramBasedSequence.subSequence(1, i - 1);
/*  29 */       this.titleClosingMarker = paramBasedSequence.subSequence(i - 1, i); return;
/*     */     } 
/*  31 */     this.titleOpeningMarker = BasedSequence.NULL;
/*  32 */     this.title = BasedSequence.NULL;
/*  33 */     this.titleClosingMarker = BasedSequence.NULL;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUrlChars(BasedSequence paramBasedSequence) {
/*  38 */     if (paramBasedSequence != null && paramBasedSequence != BasedSequence.NULL) {
/*     */       
/*  40 */       if (paramBasedSequence.startsWith("<") && paramBasedSequence.endsWith(">")) {
/*  41 */         this.urlOpeningMarker = paramBasedSequence.subSequence(0, 1);
/*  42 */         this.url = paramBasedSequence.subSequence(1, paramBasedSequence.length() - 1);
/*  43 */         this.urlClosingMarker = (BasedSequence)paramBasedSequence.subSequence(paramBasedSequence.length() - 1);
/*     */       } else {
/*  45 */         this.url = paramBasedSequence;
/*     */       } 
/*     */       
/*     */       int i;
/*     */       
/*  50 */       if ((i = this.url.indexOf('#')) < 0) {
/*  51 */         this.pageRef = this.url;
/*     */       } else {
/*  53 */         this.pageRef = this.url.subSequence(0, i);
/*  54 */         this.anchorMarker = this.url.subSequence(i, i + 1);
/*  55 */         this.anchorRef = (BasedSequence)this.url.subSequence(i + 1); return;
/*     */       } 
/*     */     } else {
/*  58 */       this.urlOpeningMarker = BasedSequence.NULL;
/*  59 */       this.url = BasedSequence.NULL;
/*  60 */       this.urlClosingMarker = BasedSequence.NULL;
/*     */     } 
/*     */   }
/*     */   
/*     */   public BasedSequence getPageRef() {
/*  65 */     return this.pageRef;
/*     */   }
/*     */   
/*     */   public void setPageRef(BasedSequence paramBasedSequence) {
/*  69 */     this.pageRef = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getAnchorMarker() {
/*  73 */     return this.anchorMarker;
/*     */   }
/*     */   
/*     */   public void setAnchorMarker(BasedSequence paramBasedSequence) {
/*  77 */     this.anchorMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getAnchorRef() {
/*  81 */     return this.anchorRef;
/*     */   }
/*     */   
/*     */   public void setAnchorRef(BasedSequence paramBasedSequence) {
/*  85 */     this.anchorRef = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getUrl() {
/*  89 */     return this.url;
/*     */   }
/*     */   
/*     */   public BasedSequence getTitle() {
/*  93 */     return this.title;
/*     */   }
/*     */   
/*     */   public BasedSequence getUrlOpeningMarker() {
/*  97 */     return this.urlOpeningMarker;
/*     */   }
/*     */   
/*     */   public void setUrlOpeningMarker(BasedSequence paramBasedSequence) {
/* 101 */     this.urlOpeningMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public void setUrl(BasedSequence paramBasedSequence) {
/* 105 */     this.url = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getUrlClosingMarker() {
/* 109 */     return this.urlClosingMarker;
/*     */   }
/*     */   
/*     */   public void setUrlClosingMarker(BasedSequence paramBasedSequence) {
/* 113 */     this.urlClosingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getTitleOpeningMarker() {
/* 117 */     return this.titleOpeningMarker;
/*     */   }
/*     */   
/*     */   public void setTitleOpeningMarker(BasedSequence paramBasedSequence) {
/* 121 */     this.titleOpeningMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public void setTitle(BasedSequence paramBasedSequence) {
/* 125 */     this.title = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getTitleClosingMarker() {
/* 129 */     return this.titleClosingMarker;
/*     */   }
/*     */   
/*     */   public void setTitleClosingMarker(BasedSequence paramBasedSequence) {
/* 133 */     this.titleClosingMarker = paramBasedSequence;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\LinkNodeBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */