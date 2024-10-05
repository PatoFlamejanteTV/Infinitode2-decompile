/*    */ package com.vladsch.flexmark.util.sequence.mappers;
/*    */ 
/*    */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*    */ 
/*    */ 
/*    */ public class SpaceMapper
/*    */ {
/*  8 */   public static final CharMapper toNonBreakSpace = new ToNonBreakSpace();
/*  9 */   public static final CharMapper fromNonBreakSpace = new FromNonBreakSpace();
/*    */   
/*    */   public static boolean areEquivalent(char paramChar1, char paramChar2) {
/* 12 */     return (paramChar1 == paramChar2 || (paramChar1 == ' ' && paramChar2 == ' ') || (paramChar2 == ' ' && paramChar1 == ' '));
/*    */   }
/*    */   
/*    */   public static CharMapper toSpaces(CharPredicate paramCharPredicate) {
/* 16 */     return new FromPredicate(paramCharPredicate);
/*    */   }
/*    */ 
/*    */   
/*    */   private static class FromNonBreakSpace
/*    */     implements CharMapper
/*    */   {
/*    */     public char map(char param1Char) {
/* 24 */       return (param1Char == ' ') ? ' ' : param1Char;
/*    */     }
/*    */   }
/*    */   
/*    */   private static class FromPredicate implements CharMapper {
/*    */     final CharPredicate myPredicate;
/*    */     
/*    */     FromPredicate(CharPredicate param1CharPredicate) {
/* 32 */       this.myPredicate = param1CharPredicate;
/*    */     }
/*    */ 
/*    */     
/*    */     public char map(char param1Char) {
/* 37 */       return this.myPredicate.test(param1Char) ? ' ' : param1Char;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   private static class ToNonBreakSpace
/*    */     implements CharMapper
/*    */   {
/*    */     public char map(char param1Char) {
/* 46 */       return (param1Char == ' ') ? ' ' : param1Char;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\mappers\SpaceMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */