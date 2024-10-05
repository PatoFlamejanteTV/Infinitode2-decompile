/*     */ package com.a.a.b.b;
/*     */ 
/*     */ import com.a.a.b.g.m;
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.m;
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
/*     */ public abstract class b
/*     */   extends m
/*     */ {
/*     */   private transient l c;
/*     */   protected m b;
/*     */   
/*     */   protected b(l paraml, String paramString) {
/*  30 */     super(paramString, (paraml == null) ? null : paraml.e());
/*  31 */     this.c = paraml;
/*     */   }
/*     */   
/*     */   protected b(l paraml, String paramString, Throwable paramThrowable) {
/*  35 */     super(paramString, (paraml == null) ? null : paraml.e(), paramThrowable);
/*  36 */     this.c = paraml;
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
/*     */   public l d() {
/*  81 */     return this.c;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessage() {
/* 109 */     String str = super.getMessage();
/* 110 */     if (this.b != null) {
/* 111 */       throw null;
/*     */     }
/* 113 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\b\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */