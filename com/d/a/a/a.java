/*    */ package com.d.a.a;
/*    */ 
/*    */ import com.b.a.c.b;
/*    */ import com.b.a.c.c;
/*    */ import com.d.a.a;
/*    */ import com.d.m.l;
/*    */ import java.util.logging.Level;
/*    */ 
/*    */ public final class a
/*    */   implements a
/*    */ {
/* 12 */   private com.b.a.c.a a = new com.b.a.c.a(8);
/* 13 */   private com.b.a.c.a b = new com.b.a.c.a(16);
/*    */ 
/*    */   
/*    */   public final String a(String paramString) {
/* 17 */     return c.a(paramString, 2);
/*    */   }
/*    */ 
/*    */   
/*    */   public final String b(String paramString) {
/*    */     try {
/* 23 */       return this.a.a(paramString);
/* 24 */     } catch (b b) {
/* 25 */       l.c(Level.WARNING, "Exception while shaping text", (Throwable)b);
/* 26 */       return paramString;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public final String c(String paramString) {
/*    */     try {
/* 33 */       return this.b.a(paramString);
/* 34 */     } catch (b b) {
/* 35 */       l.c(Level.WARNING, "Exception while deshaping text", (Throwable)b);
/* 36 */       return paramString;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean b() {
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\a\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */