/*    */ package com.vladsch.flexmark.util.format.options;
/*    */ 
/*    */ public enum ElementAlignment {
/*  4 */   NONE,
/*  5 */   LEFT_ALIGN,
/*  6 */   RIGHT_ALIGN;
/*    */ 
/*    */   
/*    */   public final boolean isNoChange() {
/* 10 */     return (this == NONE);
/*    */   }
/*    */   
/*    */   public final boolean isRight() {
/* 14 */     return (this == RIGHT_ALIGN);
/*    */   }
/*    */   
/*    */   public final boolean isLeft() {
/* 18 */     return (this == LEFT_ALIGN);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\options\ElementAlignment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */