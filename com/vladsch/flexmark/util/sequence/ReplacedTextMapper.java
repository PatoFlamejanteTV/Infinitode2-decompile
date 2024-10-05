/*     */ package com.vladsch.flexmark.util.sequence;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReplacedTextMapper
/*     */ {
/*     */   private ReplacedTextMapper parent;
/*     */   private BasedSequence original;
/*  20 */   private ArrayList<ReplacedTextRegion> regions = new ArrayList<>();
/*  21 */   private ArrayList<BasedSequence> replacedSegments = new ArrayList<>();
/*  22 */   private int replacedLength = 0;
/*  23 */   private BasedSequence replacedSequence = null;
/*     */   
/*     */   public ReplacedTextMapper(BasedSequence paramBasedSequence) {
/*  26 */     this.original = paramBasedSequence;
/*  27 */     this.parent = null;
/*     */   }
/*     */   
/*     */   private ReplacedTextMapper(ReplacedTextMapper paramReplacedTextMapper) {
/*  31 */     this.parent = paramReplacedTextMapper.parent;
/*  32 */     this.original = paramReplacedTextMapper.original;
/*  33 */     this.regions = paramReplacedTextMapper.regions;
/*  34 */     this.replacedSegments = paramReplacedTextMapper.replacedSegments;
/*  35 */     this.replacedLength = paramReplacedTextMapper.replacedLength;
/*  36 */     this.replacedSequence = paramReplacedTextMapper.getReplacedSequence();
/*     */   }
/*     */   
/*     */   public void startNestedReplacement(BasedSequence paramBasedSequence) {
/*  40 */     assert paramBasedSequence.equals(getReplacedSequence());
/*     */ 
/*     */     
/*  43 */     this.parent = new ReplacedTextMapper(this);
/*  44 */     this.original = paramBasedSequence;
/*  45 */     this.regions = new ArrayList<>();
/*  46 */     this.replacedSegments = new ArrayList<>();
/*  47 */     this.replacedLength = 0;
/*  48 */     this.replacedSequence = null;
/*     */   }
/*     */   
/*     */   public boolean isModified() {
/*  52 */     return (this.replacedLength > 0);
/*     */   }
/*     */   
/*     */   public boolean isFinalized() {
/*  56 */     return (this.replacedSequence != null);
/*     */   }
/*     */   
/*     */   private void finalizeMods() {
/*  60 */     if (this.replacedSequence == null) {
/*  61 */       this.replacedSequence = this.replacedSegments.isEmpty() ? BasedSequence.NULL : SegmentedSequence.create(this.original, this.replacedSegments);
/*     */     }
/*     */   }
/*     */   
/*     */   public ReplacedTextMapper getParent() {
/*  66 */     return this.parent;
/*     */   }
/*     */   
/*     */   public void addReplacedText(int paramInt1, int paramInt2, BasedSequence paramBasedSequence) {
/*  70 */     if (isFinalized()) throw new IllegalStateException("Cannot modify finalized ReplacedTextMapper");
/*     */     
/*  72 */     this.regions.add(new ReplacedTextRegion(this.original.subSequence(paramInt1, paramInt2).getSourceRange(), Range.of(paramInt1, paramInt2), Range.of(this.replacedLength, this.replacedLength + paramBasedSequence.length())));
/*  73 */     this.replacedLength += paramBasedSequence.length();
/*  74 */     this.replacedSegments.add(paramBasedSequence);
/*     */   }
/*     */   
/*     */   public void addOriginalText(int paramInt1, int paramInt2) {
/*  78 */     if (isFinalized()) throw new IllegalStateException("Cannot modify finalized ReplacedTextMapper");
/*     */     
/*  80 */     if (paramInt1 < paramInt2) {
/*  81 */       BasedSequence basedSequence = this.original.subSequence(paramInt1, paramInt2);
/*  82 */       this.regions.add(new ReplacedTextRegion(basedSequence.getSourceRange(), Range.of(paramInt1, paramInt2), Range.of(this.replacedLength, this.replacedLength + basedSequence.length())));
/*  83 */       this.replacedLength += basedSequence.length();
/*  84 */       this.replacedSegments.add(basedSequence);
/*     */     } 
/*     */   }
/*     */   
/*     */   public ArrayList<ReplacedTextRegion> getRegions() {
/*  89 */     finalizeMods();
/*  90 */     return this.regions;
/*     */   }
/*     */   
/*     */   public ArrayList<BasedSequence> getReplacedSegments() {
/*  94 */     finalizeMods();
/*  95 */     return this.replacedSegments;
/*     */   }
/*     */   
/*     */   public BasedSequence getReplacedSequence() {
/*  99 */     finalizeMods();
/* 100 */     return this.replacedSequence;
/*     */   }
/*     */   
/*     */   public int getReplacedLength() {
/* 104 */     finalizeMods();
/* 105 */     return this.replacedLength;
/*     */   }
/*     */   
/*     */   private int parentOriginalOffset(int paramInt) {
/* 109 */     return (this.parent != null) ? this.parent.originalOffset(paramInt) : paramInt;
/*     */   }
/*     */   
/*     */   public int originalOffset(int paramInt) {
/* 113 */     finalizeMods();
/*     */     
/* 115 */     if (this.regions.isEmpty()) return parentOriginalOffset(paramInt); 
/* 116 */     if (paramInt == this.replacedLength) return parentOriginalOffset(this.original.length());
/*     */     
/* 118 */     int i = paramInt;
/*     */     
/* 120 */     for (Iterator<ReplacedTextRegion> iterator = this.regions.iterator(); iterator.hasNext();) {
/* 121 */       if ((replacedTextRegion = iterator.next()).containsReplacedIndex(paramInt)) {
/*     */         
/* 123 */         if ((i = replacedTextRegion.getOriginalRange().getStart() + paramInt - replacedTextRegion.getReplacedRange().getStart()) > replacedTextRegion.getOriginalRange().getEnd()) {
/* 124 */           i = replacedTextRegion.getOriginalRange().getEnd();
/*     */         }
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 130 */     return parentOriginalOffset(i);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\ReplacedTextMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */