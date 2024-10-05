/*    */ package com.a.a.c.c.b;
/*    */ 
/*    */ import com.a.a.c.g;
/*    */ import com.a.a.c.k;
/*    */ import java.nio.ByteBuffer;
/*    */ import java.util.HashSet;
/*    */ import java.util.UUID;
/*    */ import java.util.concurrent.atomic.AtomicBoolean;
/*    */ import java.util.concurrent.atomic.AtomicInteger;
/*    */ import java.util.concurrent.atomic.AtomicLong;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class r
/*    */ {
/* 17 */   private static final HashSet<String> a = new HashSet<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static {
/*    */     Class[] arrayOfClass;
/*    */     byte b;
/* 29 */     for (arrayOfClass = arrayOfClass = new Class[] { UUID.class, AtomicBoolean.class, AtomicInteger.class, AtomicLong.class, StackTraceElement.class, ByteBuffer.class, Void.class }, b = 0; b < 7; ) { Class clazz = arrayOfClass[b]; a.add(clazz.getName()); b++; }
/* 30 */      for (arrayOfClass = q.g(), b = 0; b < 14; ) { Class clazz = arrayOfClass[b]; a.add(clazz.getName()); b++; }
/*    */   
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
/*    */ 
/*    */ 
/*    */   
/*    */   public static k<?> a(g paramg, Class<?> paramClass, String paramString) {
/* 50 */     if (a.contains(paramString)) {
/*    */       q<?> q;
/* 52 */       if ((q = q.a(paramClass)) != null) {
/* 53 */         return q;
/*    */       }
/* 55 */       if (paramClass == UUID.class) {
/* 56 */         return new ap();
/*    */       }
/* 58 */       if (paramClass == StackTraceElement.class) {
/* 59 */         return ac.d(paramg);
/*    */       }
/* 61 */       if (paramClass == AtomicBoolean.class) {
/* 62 */         return new b();
/*    */       }
/* 64 */       if (paramClass == AtomicInteger.class) {
/* 65 */         return new c();
/*    */       }
/* 67 */       if (paramClass == AtomicLong.class) {
/* 68 */         return new d();
/*    */       }
/* 70 */       if (paramClass == ByteBuffer.class) {
/* 71 */         return new g();
/*    */       }
/* 73 */       if (paramClass == Void.class) {
/* 74 */         return w.a;
/*    */       }
/*    */     } 
/* 77 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\r.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */