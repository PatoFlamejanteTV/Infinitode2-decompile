/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.c.a.v;
/*     */ import com.a.a.c.c.a.y;
/*     */ import com.a.a.c.c.k;
/*     */ import com.a.a.c.c.v;
/*     */ import com.a.a.c.c.x;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.f.k;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.l;
/*     */ import com.a.a.c.l.f;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.q;
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
/*     */ final class p
/*     */   extends ae<Object>
/*     */   implements k
/*     */ {
/*     */   private j a;
/*     */   private k b;
/*     */   private k<?> c;
/*     */   private x d;
/*     */   private v[] e;
/*     */   private boolean f;
/*     */   private transient v g;
/*     */   
/*     */   public p(Class<?> paramClass, k paramk, j paramj, x paramx, v[] paramArrayOfv) {
/*  51 */     super(paramClass);
/*  52 */     this.b = paramk;
/*  53 */     this.f = true;
/*     */     
/*  55 */     this.a = (paramj.a(String.class) || paramj.a(CharSequence.class)) ? null : paramj;
/*     */     
/*  57 */     this.c = null;
/*  58 */     this.d = paramx;
/*  59 */     this.e = paramArrayOfv;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public p(Class<?> paramClass, k paramk) {
/*  67 */     super(paramClass);
/*  68 */     this.b = paramk;
/*  69 */     this.f = false;
/*  70 */     this.a = null;
/*  71 */     this.c = null;
/*  72 */     this.d = null;
/*  73 */     this.e = null;
/*     */   }
/*     */ 
/*     */   
/*     */   private p(p paramp, k<?> paramk) {
/*  78 */     super(paramp.s);
/*  79 */     this.a = paramp.a;
/*  80 */     this.b = paramp.b;
/*  81 */     this.f = paramp.f;
/*  82 */     this.d = paramp.d;
/*  83 */     this.e = paramp.e;
/*     */     
/*  85 */     this.c = paramk;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k<?> a(g paramg, c paramc) {
/*  96 */     if (this.c == null && this.a != null && this.e == null) {
/*  97 */       return new p(this, paramg
/*  98 */           .a(this.a, paramc));
/*     */     }
/* 100 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Boolean a(f paramf) {
/* 105 */     return Boolean.FALSE;
/*     */   }
/*     */ 
/*     */   
/*     */   public final f b() {
/* 110 */     return f.i;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean c() {
/* 115 */     return true;
/*     */   }
/*     */   public final x i() {
/* 118 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg) {
/*     */     Object object;
/* 127 */     if (this.c != null) {
/* 128 */       object = this.c.a(paraml, paramg);
/*     */     
/*     */     }
/* 131 */     else if (this.f) {
/*     */ 
/*     */       
/* 134 */       if (this.e != null) {
/* 135 */         if (!paraml.q()) {
/* 136 */           j j1 = e(paramg);
/* 137 */           paramg.a(j1, "Input mismatch reading Enum %s: properties-based `@JsonCreator` (%s) expects JSON Object (JsonToken.START_OBJECT), got JsonToken.%s", new Object[] {
/*     */                 
/* 139 */                 i.b(j1), this.b, paraml.k() });
/*     */         } 
/* 141 */         if (this.g == null) {
/* 142 */           this.g = v.a(paramg, this.d, this.e, paramg
/* 143 */               .a(q.v));
/*     */         }
/* 145 */         paraml.g();
/* 146 */         return a(paraml, paramg, this.g);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*     */       o o;
/*     */ 
/*     */ 
/*     */       
/*     */       boolean bool;
/*     */ 
/*     */       
/* 158 */       if (bool = ((o = paraml.k()) == o.d && paramg.a(i.q)) ? true : false) {
/* 159 */         o = paraml.g();
/*     */       }
/* 161 */       if (o == null || !o.g()) {
/*     */         
/* 163 */         object = "";
/* 164 */         paraml.j();
/*     */       } else {
/* 166 */         object = paraml.R();
/*     */       } 
/* 168 */       if (bool && 
/* 169 */         paraml.g() != o.e) {
/* 170 */         j(paramg);
/*     */       }
/*     */     } else {
/*     */       
/* 174 */       paraml.j();
/*     */       try {
/* 176 */         return this.b.g();
/* 177 */       } catch (Exception exception2) {
/* 178 */         Exception exception1; Throwable throwable = i.e(exception1 = null);
/* 179 */         return paramg.a(this.s, null, throwable);
/*     */       } 
/*     */     } 
/*     */     try {
/* 183 */       return this.b.a(this.s, new Object[] { object });
/* 184 */     } catch (Exception exception2) {
/*     */       Exception exception1; Throwable throwable;
/* 186 */       if (throwable = i.e(exception1 = null) instanceof IllegalArgumentException)
/*     */       {
/* 188 */         if (paramg.a(i.w)) {
/* 189 */           return null;
/*     */         }
/*     */       }
/*     */ 
/*     */       
/* 194 */       return paramg.a(this.s, object, throwable);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg, e parame) {
/* 200 */     if (this.c == null) {
/* 201 */       return a(paraml, paramg);
/*     */     }
/* 203 */     return parame.d(paraml, paramg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object a(l paraml, g paramg, v paramv) {
/* 210 */     y y = paramv.a(paraml, paramg, null);
/*     */     
/* 212 */     o o = paraml.k();
/* 213 */     for (; o == o.f; o1 = paraml.g()) {
/* 214 */       o o1; String str = paraml.v();
/* 215 */       paraml.g();
/*     */       
/* 217 */       v v1 = paramv.a(str);
/* 218 */       if (!y.a(str) || v1 != null)
/*     */       {
/*     */         
/* 221 */         if (v1 != null) {
/* 222 */           y.a(v1, a(paraml, paramg, v1));
/*     */         }
/*     */         else {
/*     */           
/* 226 */           paraml.j();
/*     */         }  } 
/* 228 */     }  return paramv.a(paramg, y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object a(l paraml, g paramg, v paramv) {
/*     */     try {
/* 237 */       return paramv.a(paraml, paramg);
/* 238 */     } catch (Exception exception) {
/* 239 */       return a(exception, a(), paramv.a(), paramg);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Object a(Throwable paramThrowable, Object paramObject, String paramString, g paramg) {
/* 246 */     throw l.a(a(paramThrowable, paramg), paramObject, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Throwable a(Throwable paramThrowable, g paramg) {
/* 253 */     i.a(paramThrowable = i.d(paramThrowable));
/* 254 */     boolean bool = (paramg == null || paramg.a(i.o)) ? true : false;
/*     */     
/* 256 */     if (paramThrowable instanceof IOException) {
/* 257 */       if (!bool || !(paramThrowable instanceof com.a.a.b.d)) {
/* 258 */         throw (IOException)paramThrowable;
/*     */       }
/* 260 */     } else if (!bool) {
/* 261 */       i.b(paramThrowable);
/*     */     } 
/* 263 */     return paramThrowable;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */