/*     */ package com.vladsch.flexmark.ast;
/*     */ 
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.DoNotDecorate;
/*     */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.List;
/*     */ 
/*     */ public class FencedCodeBlock
/*     */   extends Block
/*     */   implements DoNotDecorate {
/*     */   private int fenceIndent;
/*  13 */   private BasedSequence openingMarker = BasedSequence.NULL;
/*  14 */   private BasedSequence info = BasedSequence.NULL;
/*  15 */   private BasedSequence attributes = BasedSequence.NULL;
/*  16 */   private BasedSequence closingMarker = BasedSequence.NULL;
/*     */ 
/*     */   
/*     */   public void getAstExtra(StringBuilder paramStringBuilder) {
/*  20 */     BasedSequence basedSequence = getContentChars();
/*  21 */     int i = getContentLines().size();
/*  22 */     segmentSpanChars(paramStringBuilder, this.openingMarker, "open");
/*  23 */     segmentSpanChars(paramStringBuilder, this.info, "info");
/*  24 */     segmentSpanChars(paramStringBuilder, this.attributes, "attributes");
/*  25 */     segmentSpan(paramStringBuilder, basedSequence, "content");
/*  26 */     paramStringBuilder.append(" lines[").append(i).append("]");
/*  27 */     segmentSpanChars(paramStringBuilder, this.closingMarker, "close");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence[] getSegments() {
/*  33 */     return new BasedSequence[] { this.openingMarker, this.info, this.attributes, getContentChars(), this.closingMarker };
/*     */   }
/*     */ 
/*     */   
/*     */   public FencedCodeBlock() {}
/*     */   
/*     */   public FencedCodeBlock(BasedSequence paramBasedSequence) {
/*  40 */     super(paramBasedSequence);
/*     */   }
/*     */   
/*     */   public FencedCodeBlock(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, List<BasedSequence> paramList, BasedSequence paramBasedSequence4) {
/*  44 */     super(paramBasedSequence1, paramList);
/*  45 */     this.openingMarker = paramBasedSequence2;
/*  46 */     this.info = paramBasedSequence3;
/*  47 */     this.closingMarker = paramBasedSequence4;
/*     */   }
/*     */   
/*     */   public BasedSequence getOpeningMarker() {
/*  51 */     return this.openingMarker;
/*     */   }
/*     */   
/*     */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/*  55 */     this.openingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public void setInfo(BasedSequence paramBasedSequence) {
/*  59 */     this.info = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getClosingMarker() {
/*  63 */     return this.closingMarker;
/*     */   }
/*     */   
/*     */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/*  67 */     this.closingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getOpeningFence() {
/*  71 */     return this.openingMarker;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence getInfo() {
/*  79 */     return this.info;
/*     */   }
/*     */   
/*     */   public BasedSequence getAttributes() {
/*  83 */     return this.attributes;
/*     */   }
/*     */   
/*     */   public void setAttributes(BasedSequence paramBasedSequence) {
/*  87 */     this.attributes = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getInfoDelimitedByAny(CharPredicate paramCharPredicate) {
/*  91 */     BasedSequence basedSequence = BasedSequence.NULL;
/*  92 */     if (this.info.isNotNull() && !this.info.isBlank()) {
/*     */       int i;
/*  94 */       if ((i = this.info.indexOfAny(paramCharPredicate)) == -1) {
/*  95 */         basedSequence = this.info;
/*     */       } else {
/*  97 */         basedSequence = this.info.subSequence(0, i);
/*     */       } 
/*     */     } 
/* 100 */     return basedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getClosingFence() {
/* 104 */     return this.closingMarker;
/*     */   }
/*     */   
/*     */   public int getFenceLength() {
/* 108 */     return getInfo().length();
/*     */   }
/*     */   
/*     */   public int getFenceIndent() {
/* 112 */     return this.fenceIndent;
/*     */   }
/*     */   
/*     */   public void setFenceIndent(int paramInt) {
/* 116 */     this.fenceIndent = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\FencedCodeBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */