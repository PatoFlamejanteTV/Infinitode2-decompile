/*     */ package com.a.a.b.d;
/*     */ 
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.b.l;
/*     */ import java.util.HashSet;
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
/*     */ public final class b
/*     */ {
/*     */   private Object a;
/*     */   private String b;
/*     */   private String c;
/*     */   private HashSet<String> d;
/*     */   
/*     */   private b(Object paramObject) {
/*  37 */     this.a = paramObject;
/*     */   }
/*     */   
/*     */   public static b a(l paraml) {
/*  41 */     return new b(paraml);
/*     */   }
/*     */   
/*     */   public static b a(h paramh) {
/*  45 */     return new b(paramh);
/*     */   }
/*     */   
/*     */   public final b a() {
/*  49 */     return new b(this.a);
/*     */   }
/*     */   
/*     */   public final void b() {
/*  53 */     this.b = null;
/*  54 */     this.c = null;
/*  55 */     this.d = null;
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
/*     */   public final Object c() {
/*  73 */     return this.a;
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
/*     */   public final boolean a(String paramString) {
/*  90 */     if (this.b == null) {
/*  91 */       this.b = paramString;
/*  92 */       return false;
/*     */     } 
/*  94 */     if (paramString.equals(this.b)) {
/*  95 */       return true;
/*     */     }
/*  97 */     if (this.c == null) {
/*  98 */       this.c = paramString;
/*  99 */       return false;
/*     */     } 
/* 101 */     if (paramString.equals(this.c)) {
/* 102 */       return true;
/*     */     }
/* 104 */     if (this.d == null) {
/* 105 */       this.d = new HashSet<>(16);
/* 106 */       this.d.add(this.b);
/* 107 */       this.d.add(this.c);
/*     */     } 
/* 109 */     return !this.d.add(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\d\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */