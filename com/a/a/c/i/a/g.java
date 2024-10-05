/*     */ package com.a.a.c.i.a;
/*     */ 
/*     */ import com.a.a.a.af;
/*     */ import com.a.a.b.g.k;
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.i;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.m.ac;
/*     */ import com.a.a.c.q;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class g
/*     */   extends a
/*     */ {
/*     */   private af.a g;
/*  32 */   private String h = (this.c == null) ? 
/*  33 */     String.format("missing type id property '%s'", new Object[] { this.e
/*  34 */       }) : String.format("missing type id property '%s' (for POJO property '%s')", new Object[] { this.e, this.c.a() });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public g(j paramj1, com.a.a.c.i.g paramg, String paramString, boolean paramBoolean, j paramj2, af.a parama) {
/*  52 */     super(paramj1, paramg, paramString, paramBoolean, paramj2);
/*  53 */     this.g = parama;
/*     */   }
/*     */   
/*     */   public g(g paramg, c paramc) {
/*  57 */     super(paramg, paramc);
/*  58 */     this.g = paramg.g;
/*     */   }
/*     */ 
/*     */   
/*     */   public e a(c paramc) {
/*  63 */     return (paramc == this.c) ? this : new g(this, paramc);
/*     */   }
/*     */   
/*     */   public final af.a a() {
/*  67 */     return this.g;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object a(l paraml, com.a.a.c.g paramg) {
/*     */     Object object;
/*  77 */     if (paraml.T() && (
/*     */       
/*  79 */       object = paraml.V()) != null) {
/*  80 */       return a(paraml, paramg, object);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  86 */     if ((object = paraml.k()) == o.b) {
/*  87 */       object = paraml.g();
/*  88 */     } else if (object != o.f) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  96 */       return b(paraml, paramg, (ac)null, this.h);
/*     */     } 
/*     */     
/*  99 */     ac ac = null;
/* 100 */     boolean bool = paramg.a(q.v);
/*     */     
/* 102 */     for (; object == o.f; object = paraml.g()) {
/* 103 */       object = paraml.v();
/* 104 */       paraml.g();
/* 105 */       if (object.equals(this.e) || (bool && object
/* 106 */         .equalsIgnoreCase(this.e))) {
/*     */         String str;
/*     */         
/* 109 */         if ((str = paraml.R()) != null) {
/* 110 */           return a(paraml, paramg, ac, str);
/*     */         }
/*     */       } 
/* 113 */       if (ac == null) {
/* 114 */         ac = paramg.a(paraml);
/*     */       }
/* 116 */       ac.a((String)object);
/* 117 */       ac.b(paraml);
/*     */     } 
/* 119 */     return b(paraml, paramg, ac, this.h);
/*     */   }
/*     */ 
/*     */   
/*     */   protected final Object a(l paraml, com.a.a.c.g paramg, ac paramac, String paramString) {
/*     */     k k;
/* 125 */     k<Object> k1 = a(paramg, paramString);
/* 126 */     if (this.f) {
/* 127 */       if (paramac == null) {
/* 128 */         paramac = paramg.a(paraml);
/*     */       }
/* 130 */       paramac.a(paraml.v());
/* 131 */       paramac.b(paramString);
/*     */     } 
/* 133 */     if (paramac != null) {
/*     */ 
/*     */       
/* 136 */       paraml.t();
/* 137 */       k = k.a(false, paramac.c(paraml), paraml);
/*     */     } 
/* 139 */     if (k.k() != o.c)
/*     */     {
/* 141 */       k.g();
/*     */     }
/*     */     
/* 144 */     return k1.a((l)k, paramg);
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
/*     */   protected final Object b(l paraml, com.a.a.c.g paramg, ac paramac, String paramString) {
/* 162 */     if (!e()) {
/*     */       Object object;
/*     */       
/* 165 */       if ((object = e.a(paraml, paramg, this.b)) != null) {
/* 166 */         return object;
/*     */       }
/*     */       
/* 169 */       if (paraml.p()) {
/* 170 */         return super.d(paraml, paramg);
/*     */       }
/* 172 */       if (paraml.a(o.h) && 
/* 173 */         paramg.a(i.s) && (
/*     */         
/* 175 */         object = paraml.w().trim()).isEmpty()) {
/* 176 */         return null;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*     */     k k;
/*     */ 
/*     */     
/* 184 */     if ((k = a(paramg)) == null) {
/*     */       j j;
/* 186 */       if ((j = b(paramg, paramString)) == null)
/*     */       {
/* 188 */         return null;
/*     */       }
/*     */       
/* 191 */       k = paramg.a(j, this.c);
/*     */     } 
/* 193 */     if (paramac != null) {
/* 194 */       paramac.j();
/*     */ 
/*     */       
/* 197 */       (paraml = paramac.c(paraml)).g();
/*     */     } 
/* 199 */     return k.a(paraml, paramg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object d(l paraml, com.a.a.c.g paramg) {
/* 210 */     if (paraml.a(o.d)) {
/* 211 */       return b(paraml, paramg);
/*     */     }
/* 213 */     return a(paraml, paramg);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\i\a\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */