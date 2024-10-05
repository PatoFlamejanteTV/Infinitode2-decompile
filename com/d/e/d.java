/*     */ package com.d.e;
/*     */ 
/*     */ import com.d.i.ab;
/*     */ import com.d.i.c;
/*     */ import com.d.i.f;
/*     */ import com.d.i.r;
/*     */ import com.d.i.u;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Shape;
/*     */ import java.util.Iterator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class d
/*     */ {
/*     */   public final void a(com.d.c.f.d paramd, Shape paramShape, t paramt, List<f> paramList1, List<f> paramList2, h paramh) {
/*  50 */     if (paramt.j()) {
/*  51 */       b(paramd, paramShape, paramt, paramList1, paramList2, paramh); return;
/*     */     } 
/*  53 */     a(paramd, paramShape, paramt, paramt.f(), paramList1, paramList2, paramh);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean a(com.d.c.f.d paramd, Shape paramShape, f paramf) {
/*  59 */     return a(paramd, paramShape, paramf, paramf);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(com.d.c.f.d paramd, Shape paramShape, t paramt, List<f> paramList1, List<f> paramList2, h paramh) {
/*     */     List<?> list;
/*     */     r r;
/*  68 */     for (Iterator<?> iterator = (list = (r = (r)paramt.f()).l()).iterator(); iterator.hasNext();) {
/*  69 */       if ((f = (f)iterator.next()).a(paramd, paramShape)) {
/*  70 */         if (f instanceof r) {
/*  71 */           paramList2.add(f); continue;
/*     */         } 
/*     */         c c;
/*  74 */         if ((c = (c)f).v()) {
/*  75 */           if (a(paramd, paramShape, f))
/*  76 */             paramList2.add(f); 
/*     */           continue;
/*     */         } 
/*  79 */         a(paramd, paramShape, paramt, (f)c, paramList1, paramList2, paramh);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean a(Shape paramShape, f paramf) {
/*  87 */     if (paramShape == null) {
/*  88 */       return true;
/*     */     }
/*     */     y y;
/*  91 */     if ((y = paramf.at()) == null) {
/*  92 */       return false;
/*     */     }
/*  94 */     Rectangle rectangle = y.a();
/*  95 */     return paramShape.intersects(rectangle);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(com.d.c.f.d paramd, Shape paramShape, t paramt, f paramf, List<f> paramList1, List<f> paramList2, h paramh) {
/* 101 */     if (paramt != paramf.af()) {
/*     */       return;
/*     */     }
/*     */     
/* 105 */     boolean bool = paramf instanceof c;
/*     */     
/* 107 */     int i = 0;
/* 108 */     int j = 0;
/* 109 */     int k = 0;
/* 110 */     int m = 0;
/* 111 */     if (bool) {
/* 112 */       i = paramList1.size();
/* 113 */       j = paramList2.size();
/*     */       
/* 115 */       k = paramh.a().size();
/* 116 */       m = paramh.b().size();
/*     */     } 
/*     */     
/* 119 */     if (paramf instanceof u) {
/* 120 */       if (a(paramShape, paramf) || (paramf
/* 121 */         .at() == null && paramf.a(paramd, paramShape))) {
/* 122 */         paramList2.add(paramf);
/* 123 */         ((u)paramf).a(paramList2, paramt);
/*     */       } 
/*     */     } else {
/* 126 */       boolean bool1 = a(paramShape, paramf);
/*     */       
/* 128 */       if ((paramf.Z() == null || !(paramf instanceof c)) && (
/* 129 */         bool1 || (paramf
/* 130 */         .at() == null && paramf.a(paramd, paramShape)))) {
/* 131 */         paramList1.add(paramf); com.d.f.d d1;
/* 132 */         if (paramf.a().q() && paramd instanceof ab && (
/*     */           
/* 134 */           d1 = (com.d.f.d)paramf).m()) {
/* 135 */           d1.d((ab)paramd);
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 141 */       if ((paramf.at() == null || bool1) && (
/* 142 */         paramf.Z() == null || paramf == paramt.f())) {
/* 143 */         for (byte b = 0; b < paramf.V(); b++) {
/* 144 */           f f1 = paramf.k(b);
/* 145 */           a(paramd, paramShape, paramt, f1, paramList1, paramList2, paramh);
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 151 */     a(paramd, paramf, paramList1, paramList2, paramh, bool, i, j, k, m);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(com.d.c.f.d paramd, f paramf, List<f> paramList1, List<f> paramList2, h paramh, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*     */     c c;
/* 161 */     if (paramBoolean && paramd instanceof ab && (
/*     */       
/* 163 */       c = (c)paramf).P()) {
/* 164 */       int i = paramList1.size();
/* 165 */       if (paramInt1 != i) {
/* 166 */         e e = new e(paramInt1, i);
/* 167 */         paramh.a().add(paramInt3, new f(c, e));
/*     */       } 
/*     */       
/* 170 */       i = paramList2.size();
/* 171 */       if (paramInt2 != i) {
/* 172 */         e e = new e(paramInt2, i);
/* 173 */         paramh.b().add(paramInt4, new f(c, e));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a(com.d.c.f.d paramd, Shape paramShape, f paramf1, f paramf2) {
/* 182 */     if (paramf2 instanceof u) {
/* 183 */       if (paramf2.a(paramd, paramShape)) {
/* 184 */         return true;
/*     */       }
/*     */     } else {
/* 187 */       if ((paramf2.Z() == null || !(paramf2 instanceof c)) && 
/* 188 */         paramf2.a(paramd, paramShape)) {
/* 189 */         return true;
/*     */       }
/*     */ 
/*     */       
/* 193 */       if (paramf2.Z() == null || paramf2 == paramf1) {
/* 194 */         for (byte b = 0; b < paramf2.V(); b++) {
/* 195 */           f f1 = paramf2.k(b);
/*     */           boolean bool;
/* 197 */           if (bool = a(paramd, paramShape, paramf1, f1)) {
/* 198 */             return true;
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 204 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\e\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */