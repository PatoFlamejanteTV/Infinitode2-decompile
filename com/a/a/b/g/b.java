/*    */ package com.a.a.b.g;
/*    */ 
/*    */ import java.lang.ref.SoftReference;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class b
/*    */ {
/*    */   private static final p a;
/*    */   
/*    */   static {
/* 38 */     boolean bool = false;
/*    */     try {
/* 40 */       bool = "true".equals(System.getProperty("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers"));
/* 41 */     } catch (SecurityException securityException) {}
/*    */     
/* 43 */     a = bool ? p.a() : null;
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
/* 57 */   private static ThreadLocal<SoftReference<a>> b = new ThreadLocal<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static a a() {
/*    */     SoftReference<a> softReference;
/*    */     a a;
/* 70 */     if ((a = (a)(((softReference = b.get()) == null) ? null : softReference.get())) == null) {
/* 71 */       a = new a();
/* 72 */       if (a != null) {
/* 73 */         softReference = a.a(a);
/*    */       } else {
/* 75 */         softReference = new SoftReference<>(a);
/*    */       } 
/* 77 */       b.set(softReference);
/*    */     } 
/* 79 */     return a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\g\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */