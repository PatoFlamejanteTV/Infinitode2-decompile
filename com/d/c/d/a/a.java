/*     */ package com.d.c.d.a;
/*     */ 
/*     */ import com.d.c.a.c;
/*     */ import com.d.c.d.b;
/*     */ import com.d.c.d.d;
/*     */ import com.d.c.d.j;
/*     */ import com.d.i.v;
/*     */ import java.util.ArrayList;
/*     */ import java.util.BitSet;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class a
/*     */   implements m
/*     */ {
/*     */   public final List a(com.d.c.a.a parama, List paramList, int paramInt, boolean paramBoolean) {
/*  35 */     return a(parama, paramList, paramInt, paramBoolean, true);
/*     */   }
/*     */   
/*     */   protected static void a(com.d.c.a.a parama, int paramInt1, int paramInt2) {
/*  39 */     if (paramInt1 != paramInt2) {
/*  40 */       throw new b("Found " + paramInt2 + " value(s) for " + parama + " when " + paramInt1 + " value(s) were expected", -1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected static void a(com.d.c.a.a parama, int paramInt1, int paramInt2, int paramInt3) {
/*  46 */     if (paramInt3 < paramInt1 || paramInt3 > paramInt2) {
/*  47 */       throw new b("Found " + paramInt3 + " value(s) for " + parama + " when between " + paramInt1 + " and " + paramInt2 + " value(s) were expected", -1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected static void a(com.d.c.a.a parama, d paramd) {
/*  53 */     if (paramd.a() != 21) {
/*  54 */       throw new b("Value for " + parama + " must be an identifier", -1);
/*     */     }
/*     */   }
/*     */   
/*     */   protected static void b(com.d.c.a.a parama, d paramd) {
/*     */     short s;
/*  60 */     if ((s = paramd.a()) != 21 && s != 20) {
/*  61 */       throw new b("Value for " + parama + " must be an identifier or a URI", -1);
/*     */     }
/*     */   }
/*     */   
/*     */   protected static void c(com.d.c.a.a parama, d paramd) {
/*     */     short s;
/*  67 */     if ((s = paramd.a()) != 21 && s != 25) {
/*  68 */       throw new b("Value for " + parama + " must be an identifier or a color", -1);
/*     */     }
/*     */   }
/*     */   
/*     */   protected static void d(com.d.c.a.a parama, d paramd) {
/*     */     short s;
/*  74 */     if (((s = paramd.a()) != 21 && s != 1) || (s == 1 && 
/*     */ 
/*     */       
/*  77 */       (int)paramd.b() != 
/*  78 */       Math.round(paramd.b()))) {
/*  79 */       throw new b("Value for " + parama + " must be an identifier or an integer", -1);
/*     */     }
/*     */   }
/*     */   
/*     */   protected static void e(com.d.c.a.a parama, d paramd) {
/*     */     short s;
/*  85 */     if ((s = paramd.a()) != 1 || (s == 1 && 
/*     */       
/*  87 */       (int)paramd.b() != 
/*  88 */       Math.round(paramd.b()))) {
/*  89 */       throw new b("Value for " + parama + " must be an integer", -1);
/*     */     }
/*     */   }
/*     */   
/*     */   protected final void f(com.d.c.a.a parama, d paramd) {
/*     */     short s;
/*  95 */     if ((s = paramd.a()) != 21 && !a(paramd)) {
/*  96 */       throw new b("Value for " + parama + " must be an identifier or a length", -1);
/*     */     }
/*     */   }
/*     */   
/*     */   protected static void g(com.d.c.a.a parama, d paramd) {
/*     */     short s;
/* 102 */     if ((s = paramd.a()) != 21 && s != 1) {
/* 103 */       throw new b("Value for " + parama + " must be an identifier or a length", -1);
/*     */     }
/*     */   }
/*     */   
/*     */   protected final void h(com.d.c.a.a parama, d paramd) {
/*     */     short s;
/* 109 */     if ((s = paramd.a()) != 21 && !a(paramd) && s != 2) {
/* 110 */       throw new b("Value for " + parama + " must be an identifier, length, or percentage", -1);
/*     */     }
/*     */   }
/*     */   
/*     */   protected final void i(com.d.c.a.a parama, d paramd) {
/* 115 */     short s = paramd.a();
/* 116 */     if (!a(paramd) && s != 2) {
/* 117 */       throw new b("Value for " + parama + " must be a length or percentage", -1);
/*     */     }
/*     */   }
/*     */   
/*     */   protected final void j(com.d.c.a.a parama, d paramd) {
/* 122 */     if (!a(paramd)) {
/* 123 */       throw new b("Value for " + parama + " must be a length", -1);
/*     */     }
/*     */   }
/*     */   
/*     */   protected static void k(com.d.c.a.a parama, d paramd) {
/* 128 */     if (paramd.a() != 1) {
/* 129 */       throw new b("Value for " + parama + " must be a number", -1);
/*     */     }
/*     */   }
/*     */   
/*     */   protected static void l(com.d.c.a.a parama, d paramd) {
/* 134 */     if (paramd.a() != 11 && paramd
/* 135 */       .a() != 12 && paramd
/* 136 */       .a() != 13) {
/* 137 */       throw new b("Value for " + parama + "must be an angle (degrees, radians or grads)", -1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void m(com.d.c.a.a parama, d paramd) {
/*     */     short s;
/* 149 */     if ((s = paramd.a()) != 19 && s != 21) {
/* 150 */       throw new b("Value for " + parama + " must be an identifier or string", -1);
/*     */     }
/*     */   }
/*     */   
/*     */   protected final void n(com.d.c.a.a parama, d paramd) {
/*     */     short s;
/* 156 */     if ((s = paramd.a()) != 21 && 
/* 157 */       !a(paramd) && s != 2 && s != 1)
/*     */     {
/*     */       
/* 160 */       throw new b("Value for " + parama + " must be an identifier, length, or percentage", -1);
/*     */     }
/*     */   }
/*     */   
/*     */   protected static boolean a(d paramd) {
/*     */     short s;
/* 166 */     if ((s = paramd.a()) == 3 || s == 4 || s == 5 || s == 8 || s == 6 || s == 7 || s == 9 || s == 10 || (s == 1 && paramd
/*     */ 
/*     */ 
/*     */       
/* 170 */       .b() == 0.0F)) return true; 
/*     */     return false;
/*     */   }
/*     */   protected static void a(com.d.c.a.a parama, BitSet paramBitSet, c paramc) {
/* 174 */     if (!paramBitSet.get(paramc.a)) {
/* 175 */       throw new b("Ident " + paramc + " is an invalid or unsupported value for " + parama, -1);
/*     */     }
/*     */   }
/*     */   
/*     */   protected static c b(d paramd) {
/*     */     c c;
/* 181 */     if ((c = c.b(paramd.c())) == null) {
/* 182 */       throw new b("Value " + paramd.c() + " is not a recognized identifier", -1);
/*     */     }
/* 184 */     ((j)paramd).a(c);
/* 185 */     return c;
/*     */   }
/*     */   
/*     */   protected static v a(v paramv, com.d.c.a.a parama) {
/* 189 */     return new v(parama, paramv.e(), paramv.f(), paramv.g());
/*     */   }
/*     */   
/*     */   protected static void a(d paramd, boolean paramBoolean) {
/* 193 */     if (paramd.e() == 0 && !paramBoolean) {
/* 194 */       throw new b("Invalid use of inherit", -1);
/*     */     }
/*     */   }
/*     */   
/*     */   protected final List a(com.d.c.a.a[] paramArrayOfa, List<d> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/* 199 */     if (paramList.size() == 1) {
/*     */       d d;
/* 201 */       a(d = paramList.get(0), paramBoolean2);
/* 202 */       if (d.e() == 0) {
/* 203 */         ArrayList<v> arrayList = new ArrayList(paramArrayOfa.length);
/* 204 */         for (byte b = 0; b < paramArrayOfa.length; b++) {
/* 205 */           arrayList.add(new v(paramArrayOfa[b], d, paramBoolean1, paramInt));
/*     */         }
/*     */         
/* 208 */         return arrayList;
/*     */       } 
/*     */     } 
/*     */     
/* 212 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\d\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */