/*     */ package com.a.a.c.i.a;
/*     */ 
/*     */ import com.a.a.a.af;
/*     */ import com.a.a.b.g.k;
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.i.g;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.m.ac;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class i
/*     */   extends r
/*     */   implements Serializable
/*     */ {
/*     */   public i(j paramj1, g paramg, String paramString, boolean paramBoolean, j paramj2) {
/*  32 */     super(paramj1, paramg, paramString, paramBoolean, paramj2);
/*     */   }
/*     */   
/*     */   private i(i parami, c paramc) {
/*  36 */     super(parami, paramc);
/*     */   }
/*     */ 
/*     */   
/*     */   public final e a(c paramc) {
/*  41 */     return (paramc == this.c) ? this : new i(this, paramc);
/*     */   }
/*     */   
/*     */   public final af.a a() {
/*  45 */     return af.a.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg) {
/*  52 */     return e(paraml, paramg);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object b(l paraml, g paramg) {
/*  57 */     return e(paraml, paramg);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object c(l paraml, g paramg) {
/*  62 */     return e(paraml, paramg);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object d(l paraml, g paramg) {
/*  67 */     return e(paraml, paramg);
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
/*     */   private Object e(l paraml, g paramg) {
/*     */     k k;
/*     */     Object object1;
/*  85 */     if (paraml.T() && (
/*     */       
/*  87 */       object1 = paraml.V()) != null) {
/*  88 */       return a(paraml, paramg, object1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  93 */     if ((object1 = paraml.k()) == o.b) {
/*     */       
/*  95 */       if (paraml.g() != o.f) {
/*  96 */         paramg.a(h(), o.f, "need JSON String that contains type id (for subtype of " + 
/*  97 */             g() + ")", new Object[0]);
/*     */       }
/*  99 */     } else if (object1 != o.f) {
/* 100 */       paramg.a(h(), o.b, "need JSON Object to contain As.WRAPPER_OBJECT type information for class " + 
/* 101 */           g(), new Object[0]);
/*     */     } 
/* 103 */     object1 = paraml.w();
/* 104 */     k<Object> k1 = a(paramg, (String)object1);
/* 105 */     paraml.g();
/*     */ 
/*     */     
/* 108 */     if (this.f && paraml.a(o.b)) {
/*     */       ac ac;
/*     */       
/* 111 */       (ac = paramg.a(paraml)).i();
/* 112 */       ac.a(this.e);
/* 113 */       ac.b((String)object1);
/*     */ 
/*     */       
/* 116 */       paraml.t();
/*     */       
/* 118 */       (k = k.a(false, ac.c(paraml), paraml)).g();
/*     */     } 
/*     */     
/* 121 */     Object object2 = k1.a((l)k, paramg);
/*     */     
/* 123 */     if (k.g() != o.c) {
/* 124 */       paramg.a(h(), o.c, "expected closing END_OBJECT after type information and deserialized value", new Object[0]);
/*     */     }
/*     */     
/* 127 */     return object2;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\i\a\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */