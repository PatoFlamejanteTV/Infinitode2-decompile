/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.c.k;
/*     */ import com.a.a.c.c.l;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.l.f;
/*     */ import com.a.a.c.p;
/*     */ import java.util.AbstractMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ public final class v
/*     */   extends i<Map.Entry<Object, Object>>
/*     */   implements k
/*     */ {
/*     */   private p a;
/*     */   private k<Object> f;
/*     */   private e g;
/*     */   
/*     */   public v(j paramj, p paramp, k<Object> paramk, e parame) {
/*  59 */     super(paramj);
/*  60 */     if (paramj.w() != 2) {
/*  61 */       throw new IllegalArgumentException("Missing generic type information for " + paramj);
/*     */     }
/*  63 */     this.a = paramp;
/*  64 */     this.f = paramk;
/*  65 */     this.g = parame;
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
/*     */   private v(v paramv, p paramp, k<Object> paramk, e parame) {
/*  84 */     super(paramv);
/*  85 */     this.a = paramp;
/*  86 */     this.f = paramk;
/*  87 */     this.g = parame;
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
/*     */   private v a(p paramp, e parame, k<?> paramk) {
/*  99 */     if (this.a == paramp && this.f == paramk && this.g == parame)
/*     */     {
/* 101 */       return this;
/*     */     }
/* 103 */     return new v(this, paramp, (k)paramk, parame);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final f b() {
/* 110 */     return f.c;
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
/*     */   public final k<?> a(g paramg, c paramc) {
/*     */     p p1;
/* 128 */     if ((p1 = this.a) == null) {
/* 129 */       p1 = paramg.b(this.b.a(0), paramc);
/*     */     }
/* 131 */     else if (p1 instanceof l) {
/* 132 */       p1 = ((l)p1).a();
/*     */     } 
/*     */     
/* 135 */     k<Object> k1 = this.f;
/* 136 */     k1 = (k)a(paramg, paramc, k1);
/* 137 */     j j = this.b.a(1);
/* 138 */     if (k1 == null) {
/* 139 */       k1 = paramg.a(j, paramc);
/*     */     } else {
/* 141 */       k1 = paramg.b(k1, paramc, j);
/*     */     } 
/*     */     e e1;
/* 144 */     if ((e1 = this.g) != null) {
/* 145 */       e1 = e1.a(paramc);
/*     */     }
/* 147 */     return a(p1, e1, k1);
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
/*     */   public final k<Object> g() {
/* 163 */     return this.f;
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
/*     */   private Map.Entry<Object, Object> c(l paraml, g paramg) {
/*     */     o o2;
/* 181 */     if ((o2 = paraml.k()) == o.b) {
/* 182 */       o2 = paraml.g();
/* 183 */     } else if (o2 != o.f && o2 != o.c) {
/*     */       
/* 185 */       if (o2 == o.d) {
/* 186 */         return d(paraml, paramg);
/*     */       }
/* 188 */       return (Map.Entry<Object, Object>)paramg.a(e(paramg), paraml);
/*     */     } 
/* 190 */     if (o2 != o.f) {
/* 191 */       if (o2 == o.c) {
/* 192 */         return (Map.Entry<Object, Object>)paramg.a(this, "Cannot deserialize a Map.Entry out of empty JSON Object", new Object[0]);
/*     */       }
/*     */       
/* 195 */       return (Map.Entry<Object, Object>)paramg.a(a(), paraml);
/*     */     } 
/*     */     
/* 198 */     p p1 = this.a;
/* 199 */     k<Object> k1 = this.f;
/* 200 */     e e1 = this.g;
/*     */     
/* 202 */     String str = paraml.v();
/* 203 */     Object object1 = p1.a(str, paramg);
/* 204 */     Object object2 = null;
/*     */     
/* 206 */     o o1 = paraml.g();
/*     */     
/*     */     try {
/* 209 */       if (o1 == o.m) {
/* 210 */         object2 = k1.a(paramg);
/* 211 */       } else if (e1 == null) {
/* 212 */         object2 = k1.a(paraml, paramg);
/*     */       } else {
/* 214 */         object2 = k1.a(paraml, paramg, e1);
/*     */       } 
/* 216 */     } catch (Exception exception) {
/* 217 */       a(paramg, exception, Map.Entry.class, str);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 222 */     if ((o1 = paraml.g()) != o.c) {
/* 223 */       if (o1 == o.f) {
/* 224 */         paramg.a(this, "Problem binding JSON into Map.Entry: more than one entry in JSON (second field: '%s')", new Object[] { paraml
/*     */               
/* 226 */               .v() });
/*     */       } else {
/*     */         
/* 229 */         paramg.a(this, "Problem binding JSON into Map.Entry: unexpected content after JSON Object entry: " + o1, new Object[0]);
/*     */       } 
/*     */       
/* 232 */       return null;
/*     */     } 
/* 234 */     return new AbstractMap.SimpleEntry<>(object1, object2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map.Entry<Object, Object> j() {
/* 241 */     throw new IllegalStateException("Cannot update Map.Entry values");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg, e parame) {
/* 250 */     return parame.a(paraml, paramg);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\v.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */