/*    */ package com.vladsch.flexmark.util.sequence.mappers;
/*    */ import java.util.Objects;
/*    */ 
/*    */ public interface CharMapper {
/*    */   static {
/*  6 */     IDENTITY = (paramChar -> paramChar);
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
/*    */   public static final CharMapper IDENTITY;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default CharMapper compose(CharMapper paramCharMapper) {
/* 29 */     Objects.requireNonNull(paramCharMapper);
/* 30 */     return (paramCharMapper == IDENTITY) ? this : (paramChar -> map(paramCharMapper.map(paramChar)));
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
/*    */   default CharMapper andThen(CharMapper paramCharMapper) {
/* 46 */     Objects.requireNonNull(paramCharMapper);
/* 47 */     return (paramCharMapper == IDENTITY) ? this : (paramChar -> paramCharMapper.map(map(paramChar)));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static CharMapper identity() {
/* 56 */     return IDENTITY;
/*    */   }
/*    */   
/*    */   char map(char paramChar);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\mappers\CharMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */