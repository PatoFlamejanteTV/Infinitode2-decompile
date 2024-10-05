/*     */ package com.a.a.c.m;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class r
/*     */ {
/*  14 */   public static final r a = new b();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class b
/*     */     extends r
/*     */     implements Serializable
/*     */   {
/*     */     public final String a(String param1String) {
/*  24 */       return param1String;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static r a(String paramString1, String paramString2) {
/*  41 */     boolean bool1 = (paramString1 != null && !paramString1.isEmpty()) ? true : false;
/*  42 */     boolean bool2 = (paramString2 != null && !paramString2.isEmpty()) ? true : false;
/*     */     
/*  44 */     if (bool1) {
/*  45 */       if (bool2) {
/*  46 */         return new s(paramString1, paramString2);
/*     */       }
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
/*  63 */       return new t(paramString1);
/*     */     } 
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
/*  77 */     if (bool2) {
/*  78 */       return new u(paramString2);
/*     */     }
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
/*  92 */     return a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static r a(r paramr1, r paramr2) {
/* 101 */     return new a(paramr1, paramr2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String a(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class a
/*     */     extends r
/*     */     implements Serializable
/*     */   {
/*     */     private r b;
/*     */ 
/*     */     
/*     */     private r c;
/*     */ 
/*     */ 
/*     */     
/*     */     public a(r param1r1, r param1r2) {
/* 124 */       this.b = param1r1;
/* 125 */       this.c = param1r2;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String a(String param1String) {
/* 130 */       return this.b.a(this.c.a(param1String));
/*     */     }
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
/*     */     public final String toString() {
/* 143 */       return "[ChainedTransformer(" + this.b + ", " + this.c + ")]";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\r.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */