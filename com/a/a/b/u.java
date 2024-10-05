/*    */ package com.a.a.b;
/*    */ 
/*    */ import com.a.a.b.g.h;
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
/*    */ public enum u
/*    */   implements h
/*    */ {
/* 24 */   a(false),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 34 */   b(false);
/*    */ 
/*    */   
/*    */   private final boolean c;
/*    */ 
/*    */   
/*    */   private final int d;
/*    */ 
/*    */ 
/*    */   
/*    */   u(boolean paramBoolean) {
/* 45 */     this.c = false;
/* 46 */     this.d = 1 << ordinal();
/*    */   }
/*    */   
/*    */   public final boolean a() {
/* 50 */     return this.c;
/*    */   } public final boolean a(int paramInt) {
/* 52 */     return ((paramInt & this.d) != 0);
/*    */   } public final int b() {
/* 54 */     return this.d;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\\\u.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */