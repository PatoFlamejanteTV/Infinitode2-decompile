/*    */ package com.vladsch.flexmark.util.sequence.mappers;
/*    */ 
/*    */ public class ChangeCase {
/*  4 */   public static final CharMapper toUpperCase = new ToUpperCase();
/*  5 */   public static final CharMapper toLowerCase = new ToLowerCase();
/*    */ 
/*    */   
/*    */   private static class ToLowerCase
/*    */     implements CharMapper
/*    */   {
/*    */     public char map(char param1Char) {
/* 12 */       return Character.isUpperCase(param1Char) ? Character.toLowerCase(param1Char) : param1Char;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   private static class ToUpperCase
/*    */     implements CharMapper
/*    */   {
/*    */     public char map(char param1Char) {
/* 21 */       return Character.isLowerCase(param1Char) ? Character.toUpperCase(param1Char) : param1Char;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\mappers\ChangeCase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */