/*    */ package com.google.common.base;
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
/*    */ @ElementTypesAreNonnullByDefault
/*    */ abstract class CommonPattern
/*    */ {
/*    */   public abstract CommonMatcher matcher(CharSequence paramCharSequence);
/*    */   
/*    */   public abstract String pattern();
/*    */   
/*    */   public abstract int flags();
/*    */   
/*    */   public abstract String toString();
/*    */   
/*    */   public static CommonPattern compile(String paramString) {
/* 38 */     return Platform.compilePattern(paramString);
/*    */   }
/*    */   
/*    */   public static boolean isPcreLike() {
/* 42 */     return Platform.patternCompilerIsPcreLike();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\CommonPattern.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */