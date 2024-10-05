/*     */ package com.a.a.b;
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
/*     */ public class m
/*     */   extends d
/*     */ {
/*     */   protected j a;
/*     */   
/*     */   protected m(String paramString, j paramj, Throwable paramThrowable) {
/*  25 */     super(paramString, paramThrowable);
/*  26 */     this.a = paramj;
/*     */   }
/*     */   
/*     */   protected m(String paramString) {
/*  30 */     super(paramString);
/*     */   }
/*     */   
/*     */   protected m(String paramString, j paramj) {
/*  34 */     this(paramString, paramj, null);
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
/*     */ 
/*     */   
/*     */   public final j a() {
/*  52 */     return this.a;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String b() {
/*  73 */     return super.getMessage();
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
/*     */   
/*     */   public Object c() {
/*  90 */     return null;
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
/*     */   protected String e() {
/* 105 */     return null;
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
/*     */   public String getMessage() {
/*     */     String str1;
/* 121 */     if ((str1 = super.getMessage()) == null) {
/* 122 */       str1 = "N/A";
/*     */     }
/* 124 */     j j1 = a();
/* 125 */     String str2 = e();
/*     */     
/* 127 */     if (j1 != null || str2 != null) {
/*     */       StringBuilder stringBuilder;
/* 129 */       (stringBuilder = new StringBuilder(100)).append(str1);
/* 130 */       if (str2 != null) {
/* 131 */         stringBuilder.append(str2);
/*     */       }
/* 133 */       if (j1 != null) {
/* 134 */         stringBuilder.append('\n');
/* 135 */         stringBuilder.append(" at ");
/* 136 */         stringBuilder.append(j1.toString());
/*     */       } 
/* 138 */       str1 = stringBuilder.toString();
/*     */     } 
/* 140 */     return str1;
/*     */   }
/*     */   public String toString() {
/* 143 */     return getClass().getName() + ": " + getMessage();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */