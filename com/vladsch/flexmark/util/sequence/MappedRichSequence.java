/*    */ package com.vladsch.flexmark.util.sequence;
/*    */ 
/*    */ import com.vladsch.flexmark.util.sequence.builder.RichSequenceBuilder;
/*    */ import com.vladsch.flexmark.util.sequence.mappers.CharMapper;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MappedRichSequence
/*    */   extends IRichSequenceBase<RichSequence>
/*    */   implements MappedSequence<RichSequence>, RichSequence
/*    */ {
/*    */   private final CharMapper mapper;
/*    */   private final RichSequence base;
/*    */   
/*    */   private MappedRichSequence(CharMapper paramCharMapper, RichSequence paramRichSequence) {
/* 17 */     super(0);
/*    */     
/* 19 */     this.base = paramRichSequence;
/* 20 */     this.mapper = paramCharMapper;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CharMapper getCharMapper() {
/* 26 */     return this.mapper;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public RichSequence getCharSequence() {
/* 32 */     return this.base;
/*    */   }
/*    */ 
/*    */   
/*    */   public char charAt(int paramInt) {
/* 37 */     return this.mapper.map(this.base.charAt(paramInt));
/*    */   }
/*    */   
/*    */   public RichSequence getBaseSequence() {
/* 41 */     return this.base;
/*    */   }
/*    */ 
/*    */   
/*    */   public int length() {
/* 46 */     return this.base.length();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public RichSequence[] emptyArray() {
/* 52 */     return this.base.emptyArray();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public RichSequence nullSequence() {
/* 58 */     return this.base.nullSequence();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public RichSequence sequenceOf(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 64 */     if (paramCharSequence instanceof MappedRichSequence)
/* 65 */       return (paramInt1 == 0 && paramInt2 == paramCharSequence.length()) ? (RichSequence)paramCharSequence : ((RichSequence)paramCharSequence).subSequence(paramInt1, paramInt2).toMapped(this.mapper); 
/* 66 */     return new MappedRichSequence(this.mapper, this.base.sequenceOf(paramCharSequence, paramInt1, paramInt2));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public <B extends com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder<B, RichSequence>> B getBuilder() {
/* 72 */     return (B)RichSequenceBuilder.emptyBuilder();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public RichSequence toMapped(CharMapper paramCharMapper) {
/* 78 */     return (paramCharMapper == CharMapper.IDENTITY) ? this : new MappedRichSequence(this.mapper.andThen(paramCharMapper), this.base);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public RichSequence subSequence(int paramInt1, int paramInt2) {
/*    */     RichSequence richSequence;
/* 85 */     return ((richSequence = this.base.subSequence(paramInt1, paramInt2)) == this.base) ? this : new MappedRichSequence(this.mapper, richSequence);
/*    */   }
/*    */   
/*    */   public static RichSequence mappedOf(CharMapper paramCharMapper, RichSequence paramRichSequence) {
/* 89 */     return mappedOf(paramCharMapper, paramRichSequence, 0, paramRichSequence.length());
/*    */   }
/*    */   
/*    */   public static RichSequence mappedOf(CharMapper paramCharMapper, RichSequence paramRichSequence, int paramInt) {
/* 93 */     return mappedOf(paramCharMapper, paramRichSequence, paramInt, paramRichSequence.length());
/*    */   }
/*    */   
/*    */   public static RichSequence mappedOf(CharMapper paramCharMapper, RichSequence paramRichSequence, int paramInt1, int paramInt2) {
/* 97 */     if (paramRichSequence instanceof MappedRichSequence) return (paramInt1 == 0 && paramInt2 == paramRichSequence.length()) ? paramRichSequence.toMapped(paramCharMapper) : paramRichSequence.subSequence(paramInt1, paramInt2).toMapped(paramCharMapper); 
/* 98 */     return new MappedRichSequence(paramCharMapper, paramRichSequence.subSequence(paramInt1, paramInt2));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\MappedRichSequence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */