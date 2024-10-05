/*     */ package com.vladsch.flexmark.util.ast;
/*     */ 
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.SegmentedSequence;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public abstract class ContentNode
/*     */   extends Node
/*     */   implements Content {
/*  11 */   protected List<BasedSequence> lineSegments = BasedSequence.EMPTY_LIST;
/*     */ 
/*     */   
/*     */   public ContentNode() {}
/*     */ 
/*     */   
/*     */   public ContentNode(BasedSequence paramBasedSequence) {
/*  18 */     super(paramBasedSequence);
/*     */   }
/*     */   
/*     */   public ContentNode(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/*  22 */     super(paramBasedSequence);
/*  23 */     this.lineSegments = paramList;
/*     */   }
/*     */   
/*     */   public ContentNode(List<BasedSequence> paramList) {
/*  27 */     this(getSpanningChars(paramList), paramList);
/*     */   }
/*     */   
/*     */   public ContentNode(BlockContent paramBlockContent) {
/*  31 */     this(paramBlockContent.getSpanningChars(), paramBlockContent.getLines());
/*     */   }
/*     */   
/*     */   public void setContent(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/*  35 */     setChars(paramBasedSequence);
/*  36 */     this.lineSegments = paramList;
/*     */   }
/*     */   
/*     */   public void setContent(List<BasedSequence> paramList) {
/*  40 */     this.lineSegments = paramList;
/*  41 */     setChars(getSpanningChars());
/*     */   }
/*     */   
/*     */   public void setContent(BlockContent paramBlockContent) {
/*  45 */     setChars(paramBlockContent.getSpanningChars());
/*  46 */     this.lineSegments = paramBlockContent.getLines();
/*     */   }
/*     */ 
/*     */   
/*     */   public BasedSequence getSpanningChars() {
/*  51 */     return getSpanningChars(this.lineSegments);
/*     */   }
/*     */   
/*     */   private static BasedSequence getSpanningChars(List<BasedSequence> paramList) {
/*  55 */     return paramList.isEmpty() ? BasedSequence.NULL : ((BasedSequence)paramList.get(0)).baseSubSequence(((BasedSequence)paramList.get(0)).getStartOffset(), ((BasedSequence)paramList.get(paramList.size() - 1)).getEndOffset());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLineCount() {
/*  60 */     return this.lineSegments.size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence getLineChars(int paramInt) {
/*  66 */     return this.lineSegments.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<BasedSequence> getContentLines() {
/*  72 */     return this.lineSegments;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<BasedSequence> getContentLines(int paramInt1, int paramInt2) {
/*  78 */     return this.lineSegments.subList(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence getContentChars() {
/*  84 */     return this.lineSegments.isEmpty() ? BasedSequence.NULL : SegmentedSequence.create(this.lineSegments.get(0), this.lineSegments);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence getContentChars(int paramInt1, int paramInt2) {
/*  90 */     return this.lineSegments.isEmpty() ? BasedSequence.NULL : SegmentedSequence.create(this.lineSegments.get(0), getContentLines(paramInt1, paramInt2));
/*     */   }
/*     */   
/*     */   public void setContentLines(List<BasedSequence> paramList) {
/*  94 */     this.lineSegments = paramList;
/*     */   }
/*     */   
/*     */   public void setContentLine(int paramInt, BasedSequence paramBasedSequence) {
/*     */     ArrayList<BasedSequence> arrayList;
/*  99 */     (arrayList = new ArrayList<>(this.lineSegments)).set(paramInt, paramBasedSequence);
/* 100 */     this.lineSegments = arrayList;
/* 101 */     setCharsFromContent();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\ContentNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */