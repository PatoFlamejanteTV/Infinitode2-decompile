/*    */ package com.vladsch.flexmark.util.sequence;
/*    */ 
/*    */ public class ReplacedTextRegion {
/*    */   private final Range base;
/*    */   private final Range original;
/*    */   private final Range replaced;
/*    */   
/*    */   public ReplacedTextRegion(Range paramRange1, Range paramRange2, Range paramRange3) {
/*  9 */     this.base = paramRange1;
/* 10 */     this.original = paramRange2;
/* 11 */     this.replaced = paramRange3;
/*    */   }
/*    */   
/*    */   public Range getBaseRange() {
/* 15 */     return this.base;
/*    */   }
/*    */   
/*    */   public Range getOriginalRange() {
/* 19 */     return this.original;
/*    */   }
/*    */   
/*    */   public Range getReplacedRange() {
/* 23 */     return this.replaced;
/*    */   }
/*    */   
/*    */   public boolean containsReplacedIndex(int paramInt) {
/* 27 */     return this.replaced.contains(paramInt);
/*    */   }
/*    */   
/*    */   public boolean containsBaseIndex(int paramInt) {
/* 31 */     return this.base.contains(paramInt);
/*    */   }
/*    */   
/*    */   public boolean containsOriginalIndex(int paramInt) {
/* 35 */     return this.original.contains(paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\ReplacedTextRegion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */