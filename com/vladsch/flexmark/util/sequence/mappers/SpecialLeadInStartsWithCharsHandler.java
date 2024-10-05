/*    */ package com.vladsch.flexmark.util.sequence.mappers;
/*    */ 
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.function.Consumer;
/*    */ 
/*    */ 
/*    */ public class SpecialLeadInStartsWithCharsHandler
/*    */   implements SpecialLeadInHandler
/*    */ {
/*    */   final CharPredicate predicate;
/*    */   
/*    */   protected SpecialLeadInStartsWithCharsHandler(CharPredicate paramCharPredicate) {
/* 15 */     this.predicate = paramCharPredicate;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean escape(BasedSequence paramBasedSequence, DataHolder paramDataHolder, Consumer<CharSequence> paramConsumer) {
/* 31 */     if (paramBasedSequence.length() > 0 && this.predicate.test(paramBasedSequence.charAt(0))) {
/* 32 */       paramConsumer.accept("\\");
/* 33 */       paramConsumer.accept(paramBasedSequence);
/* 34 */       return true;
/*    */     } 
/* 36 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean unEscape(BasedSequence paramBasedSequence, DataHolder paramDataHolder, Consumer<CharSequence> paramConsumer) {
/* 52 */     if (paramBasedSequence.length() >= 2 && paramBasedSequence.charAt(0) == '\\' && this.predicate.test(paramBasedSequence.charAt(1))) {
/* 53 */       paramConsumer.accept(paramBasedSequence.subSequence(1));
/* 54 */       return true;
/*    */     } 
/* 56 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public static SpecialLeadInStartsWithCharsHandler create(char paramChar) {
/* 61 */     return new SpecialLeadInStartsWithCharsHandler(CharPredicate.anyOf(new char[] { paramChar }));
/*    */   }
/*    */ 
/*    */   
/*    */   public static SpecialLeadInStartsWithCharsHandler create(CharSequence paramCharSequence) {
/* 66 */     return new SpecialLeadInStartsWithCharsHandler(CharPredicate.anyOf(paramCharSequence));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\mappers\SpecialLeadInStartsWithCharsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */