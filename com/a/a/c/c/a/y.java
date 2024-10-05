/*     */ package com.a.a.c.c.a;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.c.u;
/*     */ import com.a.a.c.c.v;
/*     */ import com.a.a.c.e;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i;
/*     */ import com.a.a.c.k;
/*     */ import java.util.BitSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class y
/*     */ {
/*     */   private l a;
/*     */   private g b;
/*     */   private s c;
/*     */   private Object[] d;
/*     */   private int e;
/*     */   private int f;
/*     */   private BitSet g;
/*     */   private x h;
/*     */   private Object i;
/*     */   
/*     */   public y(l paraml, g paramg, int paramInt, s params) {
/*  87 */     this.a = paraml;
/*  88 */     this.b = paramg;
/*  89 */     this.e = paramInt;
/*  90 */     this.c = params;
/*  91 */     this.d = new Object[paramInt];
/*  92 */     if (paramInt < 32) {
/*  93 */       this.g = null; return;
/*     */     } 
/*  95 */     this.g = new BitSet();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object[] a(v[] paramArrayOfv) {
/* 151 */     if (this.e > 0) {
/* 152 */       if (this.g == null) {
/* 153 */         int i = this.f;
/*     */         byte b;
/*     */         int j;
/* 156 */         for (b = 0, j = this.d.length; b < j; b++, i >>= 1) {
/* 157 */           if ((i & 0x1) == 0) {
/* 158 */             this.d[b] = a(paramArrayOfv[b]);
/*     */           }
/*     */         } 
/*     */       } else {
/* 162 */         int i = this.d.length;
/* 163 */         for (int j = 0; (j = this.g.nextClearBit(j)) < i; j++) {
/* 164 */           this.d[j] = a(paramArrayOfv[j]);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 169 */     if (this.b.a(i.l)) {
/* 170 */       for (byte b = 0; b < paramArrayOfv.length; b++) {
/* 171 */         if (this.d[b] == null) {
/* 172 */           v v1 = paramArrayOfv[b];
/* 173 */           this.b.a((c)v1, "Null value for creator property '%s' (index %d); `DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES` enabled", new Object[] { v1
/*     */                 
/* 175 */                 .a(), Integer.valueOf(paramArrayOfv[b].h()) });
/*     */         } 
/*     */       } 
/*     */     }
/* 179 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Object a(v paramv) {
/*     */     Object object;
/* 186 */     if ((object = paramv.i()) != null) {
/* 187 */       return this.b.a(paramv.i(), (c)paramv, null);
/*     */     }
/*     */ 
/*     */     
/* 191 */     if (paramv.t()) {
/* 192 */       this.b.a((c)paramv, "Missing required creator property '%s' (index %d)", new Object[] { paramv
/* 193 */             .a(), Integer.valueOf(paramv.h()) });
/*     */     }
/* 195 */     if (this.b.a(i.k)) {
/* 196 */       this.b.a((c)paramv, "Missing creator property '%s' (index %d); `DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES` enabled", new Object[] { paramv
/*     */             
/* 198 */             .a(), Integer.valueOf(paramv.h()) });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 204 */       if ((object = paramv.r().b(this.b)) != null) {
/* 205 */         return object;
/*     */       }
/*     */       
/*     */       k k;
/*     */       
/* 210 */       return (k = paramv.p()).b(this.b);
/* 211 */     } catch (e e) {
/*     */       j j;
/*     */       
/* 214 */       if ((j = paramv.e()) != null) {
/* 215 */         e.a(j.h(), paramv.a());
/*     */       }
/* 217 */       throw e;
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
/*     */   
/*     */   public final boolean a(String paramString) {
/* 235 */     if (this.c != null && paramString.equals(this.c.a.b())) {
/* 236 */       this.i = this.c.a(this.a, this.b);
/* 237 */       return true;
/*     */     } 
/* 239 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(g paramg, Object paramObject) {
/* 247 */     if (this.c != null) {
/* 248 */       v v; if (this.i != null) {
/*     */         z z;
/* 250 */         (z = paramg.a(this.i, this.c.b, this.c.c)).a(paramObject);
/*     */ 
/*     */         
/* 253 */         if ((v = this.c.d) != null) {
/* 254 */           return v.b(paramObject, this.i);
/*     */         }
/*     */       } else {
/*     */         
/* 258 */         v.a(this.c, paramObject);
/*     */       } 
/*     */     } 
/* 261 */     return paramObject;
/*     */   }
/*     */   protected final x a() {
/* 264 */     return this.h;
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
/*     */   public final boolean a(v paramv, Object paramObject) {
/* 278 */     int i = paramv.h();
/* 279 */     this.d[i] = paramObject;
/* 280 */     if (this.g == null) {
/*     */       int j;
/* 282 */       i = (j = this.f) | 1 << i;
/*     */       
/* 284 */       this.f = i;
/* 285 */       if (j != i && --this.e <= 0)
/*     */       {
/* 287 */         return (this.c == null || this.i != null);
/*     */       
/*     */       }
/*     */     }
/* 291 */     else if (!this.g.get(i)) {
/* 292 */       this.g.set(i);
/* 293 */       this.e--;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 298 */     return false;
/*     */   }
/*     */   
/*     */   public final void b(v paramv, Object paramObject) {
/* 302 */     this.h = new x.c(this.h, paramObject, paramv);
/*     */   }
/*     */   
/*     */   public final void a(u paramu, String paramString, Object paramObject) {
/* 306 */     this.h = new x.a(this.h, paramObject, paramu, paramString);
/*     */   }
/*     */   
/*     */   public final void a(Object paramObject1, Object paramObject2) {
/* 310 */     this.h = new x.b(this.h, paramObject2, paramObject1);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\y.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */