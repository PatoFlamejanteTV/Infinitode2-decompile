/*     */ package com.b.a.a;
/*     */ 
/*     */ import java.security.AccessController;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class d
/*     */ {
/*     */   private static volatile ClassLoader a;
/*     */   
/*     */   private static class a
/*     */     extends ClassLoader
/*     */   {
/*     */     a() {
/*  37 */       super(Object.class.getClassLoader());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ClassLoader a() {
/*  51 */     if (a == null) {
/*  52 */       synchronized (d.class) {
/*  53 */         if (a == null) {
/*     */           ClassLoader classLoader;
/*  55 */           if (System.getSecurityManager() != null) {
/*  56 */             classLoader = AccessController.<ClassLoader>doPrivileged(new e());
/*     */ 
/*     */           
/*     */           }
/*     */           else {
/*     */ 
/*     */             
/*  63 */             classLoader = new a();
/*     */           } 
/*  65 */           a = classLoader;
/*     */         } 
/*     */       } 
/*     */     }
/*  69 */     return a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ClassLoader a(Class<?> paramClass) {
/*     */     ClassLoader classLoader;
/*  80 */     if ((classLoader = paramClass.getClassLoader()) == null) {
/*  81 */       classLoader = b();
/*     */     }
/*  83 */     return classLoader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ClassLoader b() {
/*     */     ClassLoader classLoader;
/*  92 */     if ((classLoader = Thread.currentThread().getContextClassLoader()) == null && (
/*     */       
/*  94 */       classLoader = ClassLoader.getSystemClassLoader()) == null)
/*     */     {
/*     */ 
/*     */       
/*  98 */       classLoader = a();
/*     */     }
/*     */     
/* 101 */     return classLoader;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\b\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */