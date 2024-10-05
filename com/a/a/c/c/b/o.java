/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.c.a.q;
/*     */ import com.a.a.c.c.k;
/*     */ import com.a.a.c.c.s;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.l;
/*     */ import com.a.a.c.l.f;
/*     */ import com.a.a.c.m.a;
/*     */ import java.util.EnumSet;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class o
/*     */   extends ae<EnumSet<?>>
/*     */   implements k
/*     */ {
/*     */   private j a;
/*     */   private k<Enum<?>> b;
/*     */   private s c;
/*     */   private boolean d;
/*     */   private Boolean e;
/*     */   
/*     */   public o(j paramj, k<?> paramk) {
/*  68 */     super(EnumSet.class);
/*  69 */     this.a = paramj;
/*     */     
/*  71 */     if (!paramj.h()) {
/*  72 */       throw new IllegalArgumentException("Type " + paramj + " not Java Enum type");
/*     */     }
/*  74 */     this.b = (k)paramk;
/*  75 */     this.e = null;
/*  76 */     this.c = null;
/*  77 */     this.d = false;
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
/*     */   private o(o paramo, k<?> paramk, s params, Boolean paramBoolean) {
/*  96 */     super(paramo);
/*  97 */     this.a = paramo.a;
/*  98 */     this.b = (k)paramk;
/*  99 */     this.c = params;
/* 100 */     this.d = q.a(params);
/* 101 */     this.e = paramBoolean;
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
/*     */   private o a(k<?> paramk, s params, Boolean paramBoolean) {
/* 121 */     if (Objects.equals(this.e, paramBoolean) && this.b == paramk && this.c == paramk) {
/* 122 */       return this;
/*     */     }
/* 124 */     return new o(this, paramk, params, paramBoolean);
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
/*     */   public final boolean c() {
/* 140 */     if (this.a.A() != null) {
/* 141 */       return false;
/*     */     }
/* 143 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final f b() {
/* 148 */     return f.b;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Boolean a(f paramf) {
/* 153 */     return Boolean.TRUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object c(g paramg) {
/* 158 */     return g();
/*     */   }
/*     */ 
/*     */   
/*     */   public final a e() {
/* 163 */     return a.c;
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
/*     */   public final k<?> a(g paramg, c paramc) {
/* 179 */     Boolean bool = a(paramg, paramc, EnumSet.class, l.a.a);
/*     */     
/*     */     k<Enum<?>> k1;
/* 182 */     if ((k1 = this.b) == null) {
/* 183 */       k1 = paramg.a(this.a, paramc);
/*     */     } else {
/* 185 */       k1 = paramg.b(k1, paramc, this.a);
/*     */     } 
/* 187 */     return a(k1, b(paramg, paramc, k1), bool);
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
/*     */   private EnumSet<?> c(l paraml, g paramg) {
/* 199 */     EnumSet enumSet = g();
/*     */     
/* 201 */     if (!paraml.p()) {
/* 202 */       return c(paraml, paramg, enumSet);
/*     */     }
/* 204 */     return b(paraml, paramg, enumSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private EnumSet<?> a(l paraml, g paramg, EnumSet<?> paramEnumSet) {
/* 212 */     if (!paraml.p()) {
/* 213 */       return c(paraml, paramg, paramEnumSet);
/*     */     }
/* 215 */     return b(paraml, paramg, paramEnumSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private EnumSet<?> b(l paraml, g paramg, EnumSet<Enum> paramEnumSet) {
/*     */     try {
/*     */       com.a.a.b.o o1;
/* 225 */       while ((o1 = paraml.g()) != com.a.a.b.o.e) {
/*     */         Enum enum_;
/*     */ 
/*     */ 
/*     */         
/* 230 */         if (o1 == com.a.a.b.o.m)
/* 231 */         { if (!this.d)
/*     */           
/*     */           { 
/* 234 */             enum_ = (Enum)this.c.a(paramg); } else { continue; }
/*     */            }
/* 236 */         else { enum_ = (Enum)this.b.a(paraml, paramg); }
/*     */         
/* 238 */         if (enum_ != null) {
/* 239 */           paramEnumSet.add(enum_);
/*     */         }
/*     */       } 
/* 242 */     } catch (Exception exception2) {
/* 243 */       Exception exception1; throw l.a(exception1 = null, paramEnumSet, paramEnumSet.size());
/*     */     } 
/* 245 */     return paramEnumSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg, e parame) {
/* 253 */     return parame.b(paraml, paramg);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private EnumSet g() {
/* 259 */     return EnumSet.noneOf(this.a.b());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private EnumSet<?> c(l paraml, g paramg, EnumSet<Enum> paramEnumSet) {
/*     */     boolean bool;
/* 271 */     if (!(bool = (this.e == Boolean.TRUE || (this.e == null && paramg.a(i.p))) ? true : false)) {
/* 272 */       return (EnumSet)paramg.a(EnumSet.class, paraml);
/*     */     }
/*     */     
/* 275 */     if (paraml.a(com.a.a.b.o.m)) {
/* 276 */       return (EnumSet)paramg.a(this.a, paraml);
/*     */     }
/*     */     try {
/*     */       Enum enum_;
/* 280 */       if ((enum_ = (Enum)this.b.a(paraml, paramg)) != null) {
/* 281 */         paramEnumSet.add(enum_);
/*     */       }
/* 283 */     } catch (Exception exception) {
/* 284 */       throw l.a(paraml = null, paramEnumSet, paramEnumSet.size());
/*     */     } 
/* 286 */     return paramEnumSet;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */