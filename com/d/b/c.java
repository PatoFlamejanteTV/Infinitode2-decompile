/*     */ package com.d.b;
/*     */ 
/*     */ import com.d.c.b.c;
/*     */ import com.d.c.e.d;
/*     */ import com.d.d.s;
/*     */ import com.d.i.a.r;
/*     */ import com.d.j.b;
/*     */ import com.d.l.b;
/*     */ import com.d.m.l;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.logging.Level;
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
/*     */ public final class c
/*     */   implements c
/*     */ {
/*     */   private s a;
/*  54 */   private final LinkedHashMap<String, r> b = new d(this, 16, 0.75F, true);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private com.d.c.d.c c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public c(s params) {
/*  66 */     this.a = params;
/*  67 */     this.c = new com.d.c.d.c(new e(this));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final r a(Reader paramReader, b paramb) {
/*     */     try {
/*  76 */       return this.c.a(paramb.a(), paramb.c(), paramReader);
/*  77 */     } catch (IOException iOException) {
/*  78 */       l.a(Level.WARNING, "Couldn't parse stylesheet at URI " + paramb.a() + ": " + iOException.getMessage(), iOException);
/*  79 */       return new r(paramb.a(), paramb.c());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private r b(b paramb) {
/*     */     b b1;
/*  88 */     if ((b1 = this.a.a(paramb.a())) == null) {
/*  89 */       return null;
/*     */     }
/*     */     
/*     */     Reader reader;
/*  93 */     if ((reader = b1.b()) == null) {
/*  94 */       return null;
/*     */     }
/*     */     
/*     */     try {
/*  98 */       return a(reader, paramb);
/*     */     } finally {
/*     */       try {
/* 101 */         reader.close();
/* 102 */       } catch (IOException iOException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final d a(int paramInt, String paramString) {
/* 109 */     return this.c.a(2, paramString);
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
/*     */   @Deprecated
/*     */   private void a(String paramString, r paramr) {
/* 122 */     this.b.put(paramString, paramr);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public final boolean a(String paramString) {
/* 133 */     return this.b.containsKey(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   private r c(String paramString) {
/* 145 */     return this.b.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public final Object b(String paramString) {
/* 156 */     return this.b.remove(paramString);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public final void a() {
/* 161 */     this.b.clear();
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
/*     */   public final r a(b paramb) {
/* 173 */     l.e("Requesting stylesheet: " + paramb.a());
/*     */     
/*     */     r r;
/* 176 */     if ((r = c(paramb.a())) == null && !a(paramb.a())) {
/* 177 */       r = b(paramb);
/* 178 */       a(paramb.a(), r);
/*     */     } 
/* 180 */     return r;
/*     */   }
/*     */   
/*     */   public final void a(s params) {
/* 184 */     this.a = params;
/*     */   }
/*     */   
/*     */   public final void a(boolean paramBoolean) {
/* 188 */     this.c.a(paramBoolean);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\b\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */