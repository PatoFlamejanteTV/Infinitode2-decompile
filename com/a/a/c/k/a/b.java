/*     */ package com.a.a.c.k.a;
/*     */ 
/*     */ import com.a.a.b.f.a;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.k.b.d;
/*     */ import com.a.a.c.k.e;
/*     */ import com.a.a.c.l;
/*     */ import com.a.a.c.m.r;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.z;
/*     */ import java.util.Set;
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
/*     */ public final class b
/*     */   extends d
/*     */ {
/*     */   private d a;
/*     */   
/*     */   public b(d paramd) {
/*  65 */     super(paramd, (m)null);
/*  66 */     this.a = paramd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private b(d paramd, Set<String> paramSet1, Set<String> paramSet2) {
/*  74 */     super(paramd, paramSet1, paramSet2);
/*  75 */     this.a = paramd;
/*     */   }
/*     */ 
/*     */   
/*     */   private b(d paramd, m paramm, Object paramObject) {
/*  80 */     super(paramd, paramm, paramObject);
/*  81 */     this.a = paramd;
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
/*     */   public final o<Object> a(r paramr) {
/*  95 */     return this.a.a(paramr);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean c() {
/* 100 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final d a(m paramm) {
/* 106 */     return this.a.a(paramm);
/*     */   }
/*     */ 
/*     */   
/*     */   public final d a(Object paramObject) {
/* 111 */     return new b(this, this.g, paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   private b b(Set<String> paramSet1, Set<String> paramSet2) {
/* 116 */     return new b(this, paramSet1, paramSet2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final d a(e[] paramArrayOfe1, e[] paramArrayOfe2) {
/* 124 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final d d() {
/* 130 */     return this;
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
/*     */   public final void a(Object paramObject, h paramh, aa paramaa, i parami) {
/* 148 */     if (this.g != null) {
/* 149 */       b(paramObject, paramh, paramaa, parami);
/*     */       return;
/*     */     } 
/* 152 */     a a = a(parami, paramObject, o.d);
/* 153 */     parami.a(paramh, a);
/* 154 */     paramh.a(paramObject);
/* 155 */     d(paramObject, paramh, paramaa);
/* 156 */     parami.b(paramh, a);
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
/*     */   public final void a(Object paramObject, h paramh, aa paramaa) {
/* 168 */     if (paramaa.a(z.r) && 
/* 169 */       b(paramaa)) {
/* 170 */       d(paramObject, paramh, paramaa);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 177 */     paramh.b(paramObject);
/* 178 */     d(paramObject, paramh, paramaa);
/* 179 */     paramh.h();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean b(aa paramaa) {
/*     */     e[] arrayOfE;
/* 190 */     if (this.d != null && paramaa.e() != null) {
/* 191 */       arrayOfE = this.d;
/*     */     } else {
/* 193 */       arrayOfE = this.c;
/*     */     } 
/* 195 */     return (arrayOfE.length == 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void d(Object paramObject, h paramh, aa paramaa) {
/*     */     e[] arrayOfE;
/* 202 */     if (this.d != null && paramaa.e() != null) {
/* 203 */       arrayOfE = this.d;
/*     */     } else {
/* 205 */       arrayOfE = this.c;
/*     */     } 
/*     */     
/* 208 */     byte b1 = 0;
/*     */     try {
/* 210 */       for (int i = arrayOfE.length; b1 < i; b1++) {
/*     */         e e;
/* 212 */         if ((e = arrayOfE[b1]) == null) {
/* 213 */           paramh.k();
/*     */         } else {
/* 215 */           e.b(paramObject, paramh, paramaa);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/* 222 */     } catch (Exception exception) {
/* 223 */       a(paramaa, exception, paramObject, arrayOfE[b1].a()); return;
/* 224 */     } catch (StackOverflowError stackOverflowError) {
/*     */       l l;
/* 226 */       (l = l.a(paramh, "Infinite recursion (StackOverflowError)", stackOverflowError)).a(paramObject, arrayOfE[b1].a());
/* 227 */       throw l;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 238 */     return "BeanAsArraySerializer for " + a().getName();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */