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
/*     */ public class a
/*     */   extends r
/*     */   implements Serializable
/*     */ {
/*     */   public a(j paramj1, g paramg, String paramString, boolean paramBoolean, j paramj2) {
/*  32 */     super(paramj1, paramg, paramString, paramBoolean, paramj2);
/*     */   }
/*     */   
/*     */   public a(a parama, c paramc) {
/*  36 */     super(parama, paramc);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public e a(c paramc) {
/*  42 */     return (paramc == this.c) ? this : new a(this, paramc);
/*     */   }
/*     */   
/*     */   public af.a a() {
/*  46 */     return af.a.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object b(l paraml, g paramg) {
/*  53 */     return e(paraml, paramg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object a(l paraml, g paramg) {
/*  61 */     return e(paraml, paramg);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object c(l paraml, g paramg) {
/*  66 */     return e(paraml, paramg);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object d(l paraml, g paramg) {
/*  71 */     return e(paraml, paramg);
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
/*  89 */     if (paraml.T() && (
/*     */       
/*  91 */       object1 = paraml.V()) != null) {
/*  92 */       return a(paraml, paramg, object1);
/*     */     }
/*     */     
/*  95 */     boolean bool = paraml.p();
/*  96 */     String str = f(paraml, paramg);
/*  97 */     k<Object> k1 = a(paramg, str);
/*     */     
/*  99 */     if (this.f && 
/*     */ 
/*     */ 
/*     */       
/* 103 */       !f() && paraml
/* 104 */       .a(o.b)) {
/*     */       ac ac;
/*     */       
/* 107 */       (ac = paramg.a(paraml)).i();
/* 108 */       ac.a(this.e);
/* 109 */       ac.b(str);
/*     */ 
/*     */       
/* 112 */       paraml.t();
/*     */       
/* 114 */       (k = k.a(false, ac.c(paraml), paraml)).g();
/*     */     } 
/*     */     
/* 117 */     if (bool && k.k() == o.e) {
/* 118 */       return k1.a(paramg);
/*     */     }
/* 120 */     Object object2 = k1.a((l)k, paramg);
/*     */     
/* 122 */     if (bool && k.g() != o.e) {
/* 123 */       paramg.a(h(), o.e, "expected closing END_ARRAY after type information and deserialized value", new Object[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 130 */     return object2;
/*     */   }
/*     */   
/*     */   private String f(l paraml, g paramg) {
/*     */     String str;
/* 135 */     if (!paraml.p()) {
/*     */ 
/*     */       
/* 138 */       if (this.d != null) {
/* 139 */         return this.a.a();
/*     */       }
/* 141 */       paramg.a(h(), o.d, "need JSON Array to contain As.WRAPPER_ARRAY type information for class " + 
/* 142 */           g(), new Object[0]);
/* 143 */       return null;
/*     */     } 
/*     */     
/*     */     o o;
/* 147 */     if ((o = paraml.g()) == o.h) {
/* 148 */       str = paraml.w();
/* 149 */       paraml.g();
/* 150 */       return str;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 164 */     str.a(h(), o.h, "need JSON String that contains type id (for subtype of %s)", new Object[] {
/* 165 */           g() });
/* 166 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean f() {
/* 173 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\i\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */