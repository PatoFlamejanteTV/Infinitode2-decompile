/*    */ package com.a.a.b;
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
/*    */ public enum e
/*    */ {
/* 19 */   a("UTF-8", false, 8),
/* 20 */   b("UTF-16BE", true, 16),
/* 21 */   c("UTF-16LE", false, 16),
/* 22 */   d("UTF-32BE", true, 32),
/* 23 */   e("UTF-32LE", false, 32);
/*    */ 
/*    */   
/*    */   private final String f;
/*    */   
/*    */   private final boolean g;
/*    */   
/*    */   private final int h;
/*    */ 
/*    */   
/*    */   e(String paramString1, boolean paramBoolean, int paramInt1) {
/* 34 */     this.f = paramString1;
/* 35 */     this.g = paramBoolean;
/* 36 */     this.h = paramInt1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final String a() {
/* 44 */     return this.f;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean b() {
/* 54 */     return this.g;
/*    */   } public final int c() {
/* 56 */     return this.h;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */