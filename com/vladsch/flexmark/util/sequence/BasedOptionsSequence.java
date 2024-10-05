/*    */ package com.vladsch.flexmark.util.sequence;
/*    */ 
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.DataKeyBase;
/*    */ import com.vladsch.flexmark.util.misc.BitFieldSet;
/*    */ import java.util.stream.IntStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class BasedOptionsSequence
/*    */   implements BasedOptionsHolder, CharSequence
/*    */ {
/*    */   private final CharSequence chars;
/*    */   private final int optionFlags;
/*    */   private final DataHolder options;
/*    */   
/*    */   private BasedOptionsSequence(CharSequence paramCharSequence, int paramInt, DataHolder paramDataHolder) {
/* 22 */     this.chars = paramCharSequence;
/* 23 */     this.optionFlags = paramInt & (((paramDataHolder == null || SEGMENTED_STATS.get(paramDataHolder) == null) ? F_COLLECT_SEGMENTED_STATS : 0) ^ 0xFFFFFFFF);
/* 24 */     this.options = paramDataHolder;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int getOptionFlags() {
/* 29 */     return this.optionFlags;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean allOptions(int paramInt) {
/* 34 */     return ((this.optionFlags & paramInt) == paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean anyOptions(int paramInt) {
/* 39 */     return ((this.optionFlags & paramInt) != 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public final <T> T getOption(DataKeyBase<T> paramDataKeyBase) {
/* 44 */     return (T)paramDataKeyBase.get(this.options);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final DataHolder getOptions() {
/* 50 */     return this.options;
/*    */   }
/*    */   
/*    */   public final int length() {
/* 54 */     return this.chars.length();
/*    */   }
/*    */   public final char charAt(int paramInt) {
/* 57 */     return this.chars.charAt(paramInt);
/*    */   }
/*    */   public final CharSequence subSequence(int paramInt1, int paramInt2) {
/* 60 */     return this.chars.subSequence(paramInt1, paramInt2);
/*    */   }
/*    */   public final String toString() {
/* 63 */     return this.chars.toString();
/*    */   }
/*    */   public final IntStream chars() {
/* 66 */     return this.chars.chars();
/*    */   }
/*    */   public final IntStream codePoints() {
/* 69 */     return this.chars.codePoints();
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean equals(Object paramObject) {
/* 74 */     return this.chars.equals(paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public final int hashCode() {
/* 79 */     return this.chars.hashCode();
/*    */   }
/*    */   
/*    */   public static BasedOptionsSequence of(CharSequence paramCharSequence, BitFieldSet<BasedOptionsHolder.Options> paramBitFieldSet) {
/* 83 */     return new BasedOptionsSequence(paramCharSequence, paramBitFieldSet.toInt(), null);
/*    */   }
/*    */   
/*    */   public static BasedOptionsSequence of(CharSequence paramCharSequence, int paramInt) {
/* 87 */     return new BasedOptionsSequence(paramCharSequence, paramInt, null);
/*    */   }
/*    */   
/*    */   public static BasedOptionsSequence of(CharSequence paramCharSequence, BitFieldSet<BasedOptionsHolder.Options> paramBitFieldSet, DataHolder paramDataHolder) {
/* 91 */     return new BasedOptionsSequence(paramCharSequence, paramBitFieldSet.toInt(), paramDataHolder);
/*    */   }
/*    */   
/*    */   public static BasedOptionsSequence of(CharSequence paramCharSequence, int paramInt, DataHolder paramDataHolder) {
/* 95 */     return new BasedOptionsSequence(paramCharSequence, paramInt, paramDataHolder);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\BasedOptionsSequence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */