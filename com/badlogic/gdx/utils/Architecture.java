/*    */ package com.badlogic.gdx.utils;
/*    */ 
/*    */ public enum Architecture {
/*  4 */   x86, ARM, RISCV, LOONGARCH;
/*    */   
/*    */   public final String toSuffix() {
/*  7 */     if (this == x86) return ""; 
/*  8 */     return name().toLowerCase();
/*    */   }
/*    */   
/*    */   public enum Bitness {
/* 12 */     _32, _64, _128;
/*    */     
/*    */     public final String toSuffix() {
/* 15 */       if (this == _32) return ""; 
/* 16 */       return name().substring(1);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\Architecture.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */