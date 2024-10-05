/*    */ package com.vladsch.flexmark.util.sequence;
/*    */ 
/*    */ import com.vladsch.flexmark.util.sequence.builder.RichSequenceBuilder;
/*    */ import com.vladsch.flexmark.util.sequence.mappers.CharMapper;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RichSequenceImpl
/*    */   extends IRichSequenceBase<RichSequence>
/*    */   implements RichSequence
/*    */ {
/*    */   final CharSequence charSequence;
/*    */   
/*    */   private RichSequenceImpl(CharSequence paramCharSequence) {
/* 18 */     super((paramCharSequence instanceof String) ? paramCharSequence.hashCode() : 0);
/* 19 */     this.charSequence = paramCharSequence;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public RichSequence[] emptyArray() {
/* 25 */     return EMPTY_ARRAY;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public RichSequence nullSequence() {
/* 31 */     return NULL;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public RichSequence sequenceOf(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 37 */     return of(paramCharSequence, paramInt1, paramInt2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public <B extends com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder<B, RichSequence>> B getBuilder() {
/* 43 */     return (B)RichSequenceBuilder.emptyBuilder();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public RichSequence subSequence(int paramInt1, int paramInt2) {
/* 49 */     SequenceUtils.validateStartEnd(paramInt1, paramInt2, length());
/* 50 */     if (paramInt1 == 0 && paramInt2 == this.charSequence.length()) return this; 
/* 51 */     return create(this.charSequence, paramInt1, paramInt2);
/*    */   }
/*    */ 
/*    */   
/*    */   public int length() {
/* 56 */     return this.charSequence.length();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public char charAt(int paramInt) {
/* 62 */     return ((paramInt = this.charSequence.charAt(paramInt)) == 0) ? '�' : paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public RichSequence toMapped(CharMapper paramCharMapper) {
/* 68 */     return MappedRichSequence.mappedOf(paramCharMapper, this);
/*    */   }
/*    */   
/*    */   static RichSequence create(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 72 */     if (paramCharSequence instanceof RichSequence) return ((RichSequence)paramCharSequence).subSequence(paramInt1, paramInt2); 
/* 73 */     if (paramCharSequence != null) {
/* 74 */       if (paramInt1 == 0 && paramInt2 == paramCharSequence.length()) return new RichSequenceImpl(paramCharSequence); 
/* 75 */       return new RichSequenceImpl(paramCharSequence.subSequence(paramInt1, paramInt2));
/* 76 */     }  return NULL;
/*    */   }
/*    */   
/*    */   @Deprecated
/*    */   public static RichSequence of(CharSequence paramCharSequence) {
/* 81 */     return RichSequence.of(paramCharSequence, 0, paramCharSequence.length());
/*    */   }
/*    */   
/*    */   @Deprecated
/*    */   public static RichSequence of(CharSequence paramCharSequence, int paramInt) {
/* 86 */     return RichSequence.of(paramCharSequence, paramInt, paramCharSequence.length());
/*    */   }
/*    */   
/*    */   @Deprecated
/*    */   public static RichSequence of(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 91 */     return RichSequence.of(paramCharSequence, paramInt1, paramInt2);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\RichSequenceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */