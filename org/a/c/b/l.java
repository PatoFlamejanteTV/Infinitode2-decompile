/*     */ package org.a.c.b;
/*     */ 
/*     */ import java.io.IOException;
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
/*     */ public abstract class l
/*     */   extends b
/*     */ {
/*     */   static {
/*     */   
/*     */   }
/*     */   
/*     */   public static l a(String paramString) {
/*  80 */     if (paramString.length() == 1) {
/*     */       
/*  82 */       char c = paramString.charAt(0);
/*  83 */       if ('0' <= c && c <= '9')
/*     */       {
/*  85 */         return i.a((c - 48));
/*     */       }
/*  87 */       if (c == '-' || c == '.')
/*     */       {
/*     */         
/*  90 */         return i.a;
/*     */       }
/*     */ 
/*     */       
/*  94 */       throw new IOException("Not a number: " + paramString);
/*     */     } 
/*     */     
/*  97 */     if (paramString.indexOf('.') == -1 && paramString.toLowerCase().indexOf('e') == -1) {
/*     */       
/*     */       try {
/*     */         
/* 101 */         if (paramString.charAt(0) == '+')
/*     */         {
/* 103 */           return i.a(Long.parseLong(paramString.substring(1)));
/*     */         }
/* 105 */         return i.a(Long.parseLong(paramString));
/*     */       }
/* 107 */       catch (NumberFormatException numberFormatException) {
/*     */ 
/*     */         
/* 110 */         return new f(paramString);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 115 */     return new f(paramString);
/*     */   }
/*     */   
/*     */   public abstract long b();
/*     */   
/*     */   public abstract int c();
/*     */   
/*     */   public abstract float a();
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\b\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */