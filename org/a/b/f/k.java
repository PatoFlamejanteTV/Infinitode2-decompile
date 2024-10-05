/*     */ package org.a.b.f;
/*     */ 
/*     */ import java.awt.geom.GeneralPath;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class k
/*     */ {
/*     */   private short a;
/*     */   private short b;
/*     */   private short c;
/*     */   private short d;
/*     */   private short e;
/*  37 */   private i f = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(p paramp, ak paramak, int paramInt) {
/*     */     short s;
/*  49 */     this.e = paramak.d();
/*  50 */     this.a = paramak.d();
/*  51 */     this.b = paramak.d();
/*  52 */     this.c = paramak.d();
/*  53 */     this.d = paramak.d();
/*     */ 
/*     */     
/*  56 */     if (this.e >= 0) {
/*     */ 
/*     */       
/*  59 */       s = (short)(paramInt - this.a);
/*  60 */       this.f = new j(this.e, paramak, s);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  65 */     this.f = new h(paramak, s);
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
/*     */ 
/*     */   
/*     */   public final l a() {
/* 107 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final GeneralPath b() {
/* 116 */     return (new m(this.f)).a();
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
/*     */   public final short c() {
/* 143 */     return this.d;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */