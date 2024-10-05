/*     */ package org.a.b.f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ar
/*     */   extends an
/*     */ {
/*     */   private int[] c;
/*     */   private short[] d;
/*     */   private short[] e;
/*     */   private int f;
/*     */   
/*     */   ar(ap paramap) {
/*  46 */     super(paramap);
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
/*     */   public final void a(ap paramap, ak paramak) {
/*  59 */     aq aq = paramap.s();
/*  60 */     this.f = aq.c();
/*  61 */     int i = paramap.w();
/*     */     
/*  63 */     boolean bool = false;
/*  64 */     this.c = new int[this.f];
/*  65 */     this.d = new short[this.f]; int j;
/*  66 */     for (j = 0; j < this.f; j++) {
/*     */       
/*  68 */       this.c[j] = paramak.c();
/*  69 */       this.d[j] = paramak.d();
/*  70 */       bool += true;
/*     */     } 
/*     */     
/*  73 */     if (bool < C()) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  78 */       if ((j = i - this.f) < 0)
/*     */       {
/*  80 */         j = i;
/*     */       }
/*     */       
/*  83 */       this.e = new short[j];
/*  84 */       for (i = 0; i < j; i++) {
/*     */         
/*  86 */         if (bool < C()) {
/*     */           
/*  88 */           this.e[i] = paramak.d();
/*  89 */           bool += true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  94 */     this.a = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a(int paramInt) {
/* 104 */     if (paramInt < this.f)
/*     */     {
/* 106 */       return this.d[paramInt];
/*     */     }
/*     */ 
/*     */     
/* 110 */     return this.e[paramInt - this.f];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int b(int paramInt) {
/* 121 */     if (paramInt < this.f)
/*     */     {
/* 123 */       return this.c[paramInt];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 129 */     return this.c[this.c.length - 1];
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */