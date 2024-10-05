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
/*     */ public final class p
/*     */   extends an
/*     */ {
/*     */   private k[] c;
/*     */   private ak d;
/*     */   private t e;
/*     */   private int f;
/*  40 */   private int g = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   p(ap paramap) {
/*  54 */     super(paramap);
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
/*  67 */     this.e = paramap.q();
/*  68 */     this.f = paramap.w();
/*     */     
/*  70 */     if (this.f < 5000)
/*     */     {
/*     */       
/*  73 */       this.c = new k[this.f];
/*     */     }
/*     */ 
/*     */     
/*  77 */     this.d = paramak;
/*  78 */     this.a = true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k a(int paramInt) {
/* 154 */     if (paramInt < 0 || paramInt >= this.f)
/*     */     {
/* 156 */       return null;
/*     */     }
/*     */     
/* 159 */     if (this.c != null && this.c[paramInt] != null)
/*     */     {
/* 161 */       return this.c[paramInt];
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 166 */     synchronized (this.d) {
/*     */       long[] arrayOfLong;
/*     */ 
/*     */ 
/*     */       
/* 171 */       if ((arrayOfLong = this.e.a())[paramInt] == arrayOfLong[paramInt + 1])
/*     */       {
/*     */         
/* 174 */         return null;
/*     */       }
/*     */ 
/*     */       
/* 178 */       long l = this.d.e();
/*     */       
/* 180 */       this.d.a(D() + arrayOfLong[paramInt]);
/*     */       
/* 182 */       k k1 = b(paramInt);
/*     */ 
/*     */       
/* 185 */       this.d.a(l);
/*     */       
/* 187 */       if (this.c != null && this.c[paramInt] == null && this.g < 100) {
/*     */         
/* 189 */         this.c[paramInt] = k1;
/* 190 */         this.g++;
/*     */       } 
/*     */       
/* 193 */       return k1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private k b(int paramInt) {
/* 199 */     k k1 = new k();
/*     */     s s;
/* 201 */     paramInt = ((s = this.b.p()) == null) ? 0 : s.b(paramInt);
/* 202 */     k1.a(this, this.d, paramInt);
/*     */     
/* 204 */     if (k1.a().b())
/*     */     {
/* 206 */       k1.a().a();
/*     */     }
/* 208 */     return k1;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */