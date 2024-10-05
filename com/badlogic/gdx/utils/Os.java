/*    */ package com.badlogic.gdx.utils;
/*    */ 
/*    */ public enum Os
/*    */ {
/*  5 */   Windows, Linux, MacOsX, Android, IOS;
/*    */   
/*    */   public final String getJniPlatform() {
/*  8 */     if (this == Windows) return "win32"; 
/*  9 */     if (this == Linux) return "linux"; 
/* 10 */     if (this == MacOsX) return "mac"; 
/* 11 */     return "";
/*    */   }
/*    */   
/*    */   public final String getLibPrefix() {
/* 15 */     if (this == Linux || this == Android || this == MacOsX) {
/* 16 */       return "lib";
/*    */     }
/* 18 */     return "";
/*    */   }
/*    */   
/*    */   public final String getLibExtension() {
/* 22 */     if (this == Windows) return "dll"; 
/* 23 */     if (this == Linux) return "so"; 
/* 24 */     if (this == MacOsX) return "dylib"; 
/* 25 */     if (this == Android) return "so"; 
/* 26 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\Os.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */