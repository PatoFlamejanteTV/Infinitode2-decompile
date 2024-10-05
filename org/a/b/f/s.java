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
/*     */ public final class s
/*     */   extends an
/*     */ {
/*     */   private int[] c;
/*     */   private short[] d;
/*     */   private short[] e;
/*     */   private int f;
/*     */   
/*     */   s(ap paramap) {
/*  40 */     super(paramap);
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
/*     */   public final void a(ap paramap, ak paramak) {
/*  52 */     r r = paramap.o();
/*  53 */     this.f = r.j();
/*  54 */     int i = paramap.w();
/*     */     
/*  56 */     boolean bool = false;
/*  57 */     this.c = new int[this.f];
/*  58 */     this.d = new short[this.f]; int j;
/*  59 */     for (j = 0; j < this.f; j++) {
/*     */       
/*  61 */       this.c[j] = paramak.c();
/*  62 */       this.d[j] = paramak.d();
/*  63 */       bool += true;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  69 */     if ((j = i - this.f) < 0)
/*     */     {
/*  71 */       j = i;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  76 */     this.e = new short[j];
/*     */     
/*  78 */     if (bool < C())
/*     */     {
/*  80 */       for (i = 0; i < j; i++) {
/*     */         
/*  82 */         if (bool < C()) {
/*     */           
/*  84 */           this.e[i] = paramak.d();
/*  85 */           bool += true;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*  90 */     this.a = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a(int paramInt) {
/* 100 */     if (paramInt < this.f)
/*     */     {
/* 102 */       return this.c[paramInt];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 108 */     return this.c[this.c.length - 1];
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
/* 119 */     if (paramInt < this.f)
/*     */     {
/* 121 */       return this.d[paramInt];
/*     */     }
/*     */ 
/*     */     
/* 125 */     return this.e[paramInt - this.f];
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */