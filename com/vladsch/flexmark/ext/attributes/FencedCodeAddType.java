/*    */ package com.vladsch.flexmark.ext.attributes;
/*    */ 
/*    */ public enum FencedCodeAddType {
/*  4 */   ADD_TO_PRE_CODE(true, true),
/*  5 */   ADD_TO_PRE(true, false),
/*  6 */   ADD_TO_CODE(false, true);
/*    */   
/*    */   public final boolean addToPre;
/*    */   
/*    */   public final boolean addToCode;
/*    */   
/*    */   FencedCodeAddType(boolean paramBoolean1, boolean paramBoolean2) {
/* 13 */     this.addToPre = paramBoolean1;
/* 14 */     this.addToCode = paramBoolean2;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\attributes\FencedCodeAddType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */