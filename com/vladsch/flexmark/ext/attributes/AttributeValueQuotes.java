/*    */ package com.vladsch.flexmark.ext.attributes;
/*    */ 
/*    */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*    */ import com.vladsch.flexmark.util.sequence.SequenceUtils;
/*    */ 
/*    */ 
/*    */ public enum AttributeValueQuotes
/*    */ {
/*  9 */   AS_IS,
/* 10 */   NO_QUOTES_SINGLE_PREFERRED,
/* 11 */   NO_QUOTES_DOUBLE_PREFERRED,
/* 12 */   SINGLE_PREFERRED,
/* 13 */   DOUBLE_PREFERRED,
/* 14 */   SINGLE_QUOTES,
/* 15 */   DOUBLE_QUOTES; static final CharPredicate P_SPACES_OR_QUOTES;
/*    */   
/*    */   static {
/* 18 */     P_SPACES_OR_QUOTES = CharPredicate.anyOf(" \t\n'\"");
/* 19 */     P_SINGLE_QUOTES = CharPredicate.anyOf("'");
/* 20 */     P_DOUBLE_QUOTES = CharPredicate.anyOf("\"");
/*    */   }
/*    */   static final CharPredicate P_SINGLE_QUOTES; static final CharPredicate P_DOUBLE_QUOTES;
/*    */   public final String quotesFor(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 24 */     switch (this) {
/*    */       case NO_QUOTES_SINGLE_PREFERRED:
/* 26 */         if (!SequenceUtils.containsAny(paramCharSequence1, P_SPACES_OR_QUOTES))
/* 27 */           return ""; 
/* 28 */         if (!SequenceUtils.containsAny(paramCharSequence1, P_SINGLE_QUOTES) || SequenceUtils.containsAny(paramCharSequence1, P_DOUBLE_QUOTES)) {
/* 29 */           return "'";
/*    */         }
/* 31 */         return "\"";
/*    */       
/*    */       case NO_QUOTES_DOUBLE_PREFERRED:
/* 34 */         if (!SequenceUtils.containsAny(paramCharSequence1, P_SPACES_OR_QUOTES))
/* 35 */           return ""; 
/* 36 */         if (!SequenceUtils.containsAny(paramCharSequence1, P_DOUBLE_QUOTES) || SequenceUtils.containsAny(paramCharSequence1, P_SINGLE_QUOTES)) {
/* 37 */           return "\"";
/*    */         }
/* 39 */         return "'";
/*    */       
/*    */       case SINGLE_PREFERRED:
/* 42 */         if (!SequenceUtils.containsAny(paramCharSequence1, P_SINGLE_QUOTES) || SequenceUtils.containsAny(paramCharSequence1, P_DOUBLE_QUOTES)) {
/* 43 */           return "'";
/*    */         }
/* 45 */         return "\"";
/*    */       
/*    */       case DOUBLE_PREFERRED:
/* 48 */         if (!SequenceUtils.containsAny(paramCharSequence1, P_DOUBLE_QUOTES) || SequenceUtils.containsAny(paramCharSequence1, P_SINGLE_QUOTES)) {
/* 49 */           return "\"";
/*    */         }
/* 51 */         return "'";
/*    */       
/*    */       case SINGLE_QUOTES:
/* 54 */         return "'";
/*    */       
/*    */       case DOUBLE_QUOTES:
/* 57 */         return "\"";
/*    */     } 
/*    */ 
/*    */     
/* 61 */     return paramCharSequence2.toString();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\attributes\AttributeValueQuotes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */