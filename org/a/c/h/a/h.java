/*     */ package org.a.c.h.a;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import org.a.b.h.a;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.f;
/*     */ import org.a.c.b.l;
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
/*     */ public final class h
/*     */   implements c
/*     */ {
/*  45 */   public static final h a = new h(612.0F, 792.0F);
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
/*     */   private final a b;
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
/*     */   public h() {
/*  80 */     this(0.0F, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public h(float paramFloat1, float paramFloat2) {
/*  91 */     this(0.0F, 0.0F, paramFloat1, paramFloat2);
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
/*     */   public h(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 104 */     this.b = new a();
/* 105 */     this.b.a((b)new f(paramFloat1));
/* 106 */     this.b.a((b)new f(paramFloat2));
/* 107 */     this.b.a((b)new f(paramFloat1 + paramFloat3));
/* 108 */     this.b.a((b)new f(paramFloat2 + paramFloat4));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public h(a parama) {
/* 118 */     this.b = new a();
/* 119 */     this.b.a((b)new f(parama.a()));
/* 120 */     this.b.a((b)new f(parama.b()));
/* 121 */     this.b.a((b)new f(parama.c()));
/* 122 */     this.b.a((b)new f(parama.d()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public h(a parama) {
/* 132 */     float[] arrayOfFloat = Arrays.copyOf(parama.d(), 4);
/* 133 */     this.b = new a();
/*     */     
/* 135 */     this.b.a((b)new f(Math.min(arrayOfFloat[0], arrayOfFloat[2])));
/* 136 */     this.b.a((b)new f(Math.min(arrayOfFloat[1], arrayOfFloat[3])));
/* 137 */     this.b.a((b)new f(Math.max(arrayOfFloat[0], arrayOfFloat[2])));
/* 138 */     this.b.a((b)new f(Math.max(arrayOfFloat[1], arrayOfFloat[3])));
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
/*     */   public final h a() {
/*     */     h h1;
/* 169 */     (h1 = new h()).c(h());
/* 170 */     h1.d(i());
/* 171 */     return h1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final a b() {
/* 181 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float c() {
/* 191 */     return ((l)this.b.b(0)).a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(float paramFloat) {
/* 201 */     this.b.b(0, (b)new f(paramFloat));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float d() {
/* 211 */     return ((l)this.b.b(1)).a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(float paramFloat) {
/* 221 */     this.b.b(1, (b)new f(paramFloat));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float e() {
/* 231 */     return ((l)this.b.b(2)).a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void c(float paramFloat) {
/* 241 */     this.b.b(2, (b)new f(paramFloat));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float g() {
/* 251 */     return ((l)this.b.b(3)).a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void d(float paramFloat) {
/* 261 */     this.b.b(3, (b)new f(paramFloat));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float h() {
/* 272 */     return e() - c();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float i() {
/* 283 */     return g() - d();
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
/*     */   public final b f() {
/* 323 */     return (b)this.b;
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
/*     */   public final String toString() {
/* 355 */     return "[" + c() + "," + d() + "," + 
/* 356 */       e() + "," + g() + "]";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */