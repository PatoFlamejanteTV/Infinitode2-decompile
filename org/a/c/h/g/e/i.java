/*     */ package org.a.c.h.g.e;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.a.c.a.a.a;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.l;
/*     */ import org.a.c.b.m;
/*     */ import org.a.c.b.s;
/*     */ import org.a.c.f.g;
/*     */ import org.a.c.h.e.u;
/*     */ import org.a.c.h.f.a.e;
/*     */ import org.a.c.h.f.a.f;
/*     */ import org.a.c.h.f.a.g;
/*     */ import org.a.c.h.f.a.m;
/*     */ import org.a.c.h.g;
/*     */ import org.a.c.h.g.b.q;
/*     */ import org.a.c.h.j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class i
/*     */ {
/*     */   private final j a;
/*     */   private j b;
/*     */   private u c;
/*  63 */   private float d = 12.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private e e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   i(s params, j paramj) {
/*  75 */     if (params == null)
/*     */     {
/*  77 */       throw new IllegalArgumentException("/DA is a required entry");
/*     */     }
/*     */     
/*  80 */     if (paramj == null)
/*     */     {
/*  82 */       throw new IllegalArgumentException("/DR is a required entry");
/*     */     }
/*     */     
/*  85 */     this.a = paramj;
/*  86 */     a(params.c());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(byte[] paramArrayOfbyte) {
/*  97 */     ArrayList<b> arrayList = new ArrayList();
/*     */     g g;
/*  99 */     Object object = (g = new g(paramArrayOfbyte)).r();
/* 100 */     while (object != null) {
/*     */       
/* 102 */       if (object instanceof m) {
/*     */         
/* 104 */         arrayList.add(((m)object).a());
/*     */       }
/* 106 */       else if (object instanceof a) {
/*     */         
/* 108 */         a((a)object, arrayList);
/* 109 */         arrayList = new ArrayList<b>();
/*     */       }
/*     */       else {
/*     */         
/* 113 */         arrayList.add((b)object);
/*     */       } 
/* 115 */       object = g.r();
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
/*     */   private void a(a parama, List<b> paramList) {
/* 128 */     String str = parama.a();
/*     */     
/* 130 */     if ("Tf".equals(str)) {
/*     */       
/* 132 */       a(paramList); return;
/*     */     } 
/* 134 */     if ("g".equals(str)) {
/*     */       
/* 136 */       b(paramList); return;
/*     */     } 
/* 138 */     if ("rg".equals(str)) {
/*     */       
/* 140 */       b(paramList); return;
/*     */     } 
/* 142 */     if ("k".equals(str))
/*     */     {
/* 144 */       b(paramList);
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
/*     */   private void a(List<b> paramList) {
/* 156 */     if (paramList.size() < 2)
/*     */     {
/* 158 */       throw new IOException("Missing operands for set font operator " + Arrays.toString(paramList.toArray()));
/*     */     }
/*     */     
/* 161 */     b b2 = paramList.get(0);
/* 162 */     b b1 = paramList.get(1);
/* 163 */     if (!(b2 instanceof j)) {
/*     */       return;
/*     */     }
/*     */     
/* 167 */     if (!(b1 instanceof l)) {
/*     */       return;
/*     */     }
/*     */     
/* 171 */     j j1 = (j)b2;
/*     */     
/* 173 */     u u1 = this.a.a(j1);
/* 174 */     float f = ((l)b1).a();
/*     */ 
/*     */     
/* 177 */     if (u1 == null)
/*     */     {
/* 179 */       throw new IOException("Could not find font: /" + j1.a());
/*     */     }
/* 181 */     a(j1);
/* 182 */     a(u1);
/* 183 */     a(f);
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
/*     */   private void b(List<b> paramList) {
/*     */     org.a.c.h.f.a.i i1;
/*     */     m m;
/*     */     g g;
/* 198 */     switch (paramList.size()) {
/*     */       
/*     */       case 1:
/* 201 */         i1 = org.a.c.h.f.a.i.a;
/*     */         break;
/*     */       case 3:
/* 204 */         m = m.a;
/*     */         break;
/*     */       case 4:
/* 207 */         g = g.a;
/*     */         break;
/*     */       default:
/* 210 */         throw new IOException("Missing operands for set non stroking color operator " + Arrays.toString(paramList.toArray()));
/*     */     } 
/*     */     a a;
/* 213 */     (a = new a()).c(paramList);
/* 214 */     a(new e(a, (f)g));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final j a() {
/* 224 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(j paramj) {
/* 234 */     this.b = paramj;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final u b() {
/* 242 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(u paramu) {
/* 252 */     this.c = paramu;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float c() {
/* 260 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(float paramFloat) {
/* 270 */     this.d = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private e d() {
/* 278 */     return this.e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(e parame) {
/* 288 */     this.e = parame;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void a(g paramg, float paramFloat) {
/*     */     float f;
/* 297 */     if ((f = c()) == 0.0F)
/*     */     {
/* 299 */       f = paramFloat;
/*     */     }
/* 301 */     paramg.a(b(), f);
/*     */     
/* 303 */     if (d() != null)
/*     */     {
/* 305 */       paramg.b(d());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void a(q paramq) {
/*     */     j j1;
/* 317 */     if ((j1 = paramq.e()) == null) {
/*     */       
/* 319 */       j1 = new j();
/* 320 */       paramq.a(j1);
/*     */     } 
/*     */     
/* 323 */     if (j1.a(this.b) == null)
/*     */     {
/* 325 */       j1.a(this.b, b());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\g\e\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */