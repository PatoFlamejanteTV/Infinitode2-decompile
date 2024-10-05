/*     */ package com.d.i.b;
/*     */ import com.d.c.f.d;
/*     */ import com.d.d.b;
/*     */ import com.d.e.t;
/*     */ import com.d.f.f;
/*     */ import com.d.f.j;
/*     */ import com.d.i.ab;
/*     */ import com.d.i.c;
/*     */ import com.d.i.f;
/*     */ import com.d.i.u;
/*     */ import com.d.i.y;
/*     */ import com.d.i.z;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Shape;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ 
/*     */ public final class a {
/*  20 */   private List<b> a = null;
/*  21 */   private List<b> b = null;
/*  22 */   private List<f> c = null;
/*  23 */   private List<b> d = null;
/*  24 */   private List<b> e = null;
/*     */   
/*     */   private boolean f = false;
/*     */   private boolean g = false;
/*     */   
/*     */   private void a(b paramb) {
/*  30 */     if (this.a == null) {
/*  31 */       this.a = new ArrayList<>();
/*     */     }
/*  33 */     this.a.add(paramb);
/*     */   }
/*     */   
/*     */   private void b(b paramb) {
/*  37 */     if (this.b == null) {
/*  38 */       this.b = new ArrayList<>();
/*     */     }
/*  40 */     this.b.add(paramb);
/*     */   }
/*     */   
/*     */   private void a(f paramf) {
/*  44 */     if (this.c == null) {
/*  45 */       this.c = new ArrayList<>();
/*     */     }
/*  47 */     this.c.add(paramf);
/*     */   }
/*     */   
/*     */   private void c(b paramb) {
/*  51 */     if (this.d == null) {
/*  52 */       this.d = new ArrayList<>();
/*     */     }
/*  54 */     this.d.add(paramb);
/*     */     
/*  56 */     if (!(paramb instanceof y) && !(paramb instanceof z))
/*     */     {
/*  58 */       this.g = true;
/*     */     }
/*     */   }
/*     */   
/*     */   private void d(b paramb) {
/*  63 */     if (this.e == null) {
/*  64 */       this.e = new ArrayList<>();
/*     */     }
/*  66 */     this.e.add(paramb);
/*     */     
/*  68 */     if (!(paramb instanceof y) && !(paramb instanceof z))
/*     */     {
/*  70 */       this.f = true;
/*     */     }
/*     */   }
/*     */   
/*     */   private void a(y paramy) {
/*  75 */     a((b)paramy);
/*  76 */     b((b)paramy);
/*  77 */     c((b)paramy);
/*  78 */     d((b)paramy);
/*     */   }
/*     */   
/*     */   private void a(z paramz) {
/*  82 */     a((b)paramz);
/*  83 */     b((b)paramz);
/*  84 */     c((b)paramz);
/*  85 */     d((b)paramz);
/*     */   }
/*     */   
/*     */   public final List<b> a() {
/*  89 */     return (this.a == null) ? Collections.emptyList() : this.a;
/*     */   }
/*     */   
/*     */   public final List<b> b() {
/*  93 */     return (this.b == null) ? Collections.emptyList() : this.b;
/*     */   }
/*     */   
/*     */   public final List<f> c() {
/*  97 */     return (this.c == null) ? Collections.emptyList() : this.c;
/*     */   }
/*     */   
/*     */   public final List<b> d() {
/* 101 */     return this.g ? this.d : Collections.emptyList();
/*     */   }
/*     */   
/*     */   public final List<b> e() {
/* 105 */     return this.f ? this.e : Collections.emptyList();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a(f paramf, Shape paramShape) {
/* 112 */     a((b)paramf);
/*     */     
/* 114 */     if (paramf instanceof c) {
/*     */       c c;
/*     */       
/* 117 */       if ((c = (c)paramf).E() != null) {
/* 118 */         c((b)c);
/*     */       }
/*     */       
/* 121 */       if (c.u()) {
/* 122 */         d((b)c);
/*     */       }
/*     */     } 
/*     */     
/* 126 */     if (paramf instanceof f && ((f)paramf)
/* 127 */       .o()) {
/* 128 */       a((f)paramf);
/*     */     }
/*     */     
/* 131 */     if (paramShape != null) {
/* 132 */       a(new y(paramShape));
/* 133 */       return true;
/*     */     } 
/*     */     
/* 136 */     return false;
/*     */   }
/*     */   
/*     */   public final void a(ab paramab, t paramt) {
/* 140 */     if (!paramt.j())
/*     */     {
/*     */       
/* 143 */       a(paramab, paramt, paramt.f());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(ab paramab, t paramt, f paramf) {
/* 153 */     if (paramt != paramf.af()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 158 */     if (paramf instanceof u) {
/* 159 */       a(paramt, (u)paramf); return;
/*     */     } 
/* 161 */     Rectangle rectangle = null;
/* 162 */     boolean bool = false;
/*     */     
/* 164 */     if (paramf.Z() == null || paramt
/* 165 */       .f() == paramf || !(paramf instanceof c)) {
/*     */ 
/*     */       
/* 168 */       if (paramab instanceof ab && paramf instanceof c) {
/*     */         c c;
/*     */ 
/*     */ 
/*     */         
/* 173 */         if ((c = (c)paramf).P())
/*     */         {
/* 175 */           rectangle = c.k((d)paramab);
/*     */         }
/*     */       } 
/*     */       
/* 179 */       bool = a(paramf, rectangle);
/*     */     } 
/*     */     
/* 182 */     if (!(paramf instanceof j) || (
/* 183 */       !((j)paramf).q() && !((j)paramf).p()) || 
/* 184 */       !((j)paramf).f().m() || (paramf
/* 185 */       .Z() != null && paramf != paramt.f()) || !(paramab instanceof ab))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 191 */       if (paramf.Z() == null || paramf == paramt.f()) {
/* 192 */         for (byte b = 0; b < paramf.V(); b++) {
/* 193 */           f f1 = paramf.k(b);
/* 194 */           a(paramab, paramt, f1);
/*     */         } 
/*     */       }
/*     */     }
/*     */     
/* 199 */     if (bool) {
/* 200 */       a(new z(null));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(t paramt, u paramu) {
/* 206 */     b((b)paramu);
/*     */ 
/*     */     
/* 209 */     paramu.a(this.b, paramt);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\i\b\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */