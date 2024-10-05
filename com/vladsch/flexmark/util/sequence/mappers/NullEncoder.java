/*    */ package com.vladsch.flexmark.util.sequence.mappers;
/*    */ 
/*    */ 
/*    */ public class NullEncoder
/*    */ {
/*  6 */   public static final CharMapper encodeNull = new EncodeNull();
/*  7 */   public static final CharMapper decodeNull = new DecodeNull();
/*    */ 
/*    */   
/*    */   private static class DecodeNull
/*    */     implements CharMapper
/*    */   {
/*    */     public char map(char param1Char) {
/* 14 */       return (param1Char == '�') ? Character.MIN_VALUE : param1Char;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   private static class EncodeNull
/*    */     implements CharMapper
/*    */   {
/*    */     public char map(char param1Char) {
/* 23 */       return (param1Char == '\000') ? '�' : param1Char;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\mappers\NullEncoder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */