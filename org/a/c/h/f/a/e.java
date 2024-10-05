/*     */ package org.a.c.h.f.a;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.j;
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
/*     */ 
/*     */ public final class e
/*     */ {
/*     */   private final float[] a;
/*     */   private final j b;
/*     */   private final f c;
/*     */   
/*     */   public e(a parama, f paramf) {
/*  48 */     if (parama.b() > 0 && parama.b(parama.b() - 1) instanceof j) {
/*     */ 
/*     */       
/*  51 */       this.a = new float[parama.b() - 1];
/*  52 */       for (byte b = 0; b < parama.b() - 1; b++)
/*     */       {
/*  54 */         this.a[b] = ((l)parama.b(b)).a();
/*     */       }
/*     */ 
/*     */       
/*  58 */       this.b = (j)parama.b(parama.b() - 1);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  63 */       this.a = new float[parama.b()];
/*  64 */       for (byte b = 0; b < parama.b(); b++)
/*     */       {
/*  66 */         this.a[b] = ((l)parama.b(b)).a();
/*     */       }
/*  68 */       this.b = null;
/*     */     } 
/*  70 */     this.c = paramf;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e(float[] paramArrayOffloat, f paramf) {
/*  80 */     this.a = (float[])paramArrayOffloat.clone();
/*  81 */     this.b = null;
/*  82 */     this.c = paramf;
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
/*     */   public final float[] a() {
/* 116 */     if (this.c instanceof t || this.c == null)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 121 */       return (float[])this.a.clone();
/*     */     }
/*     */     
/* 124 */     return Arrays.copyOf(this.a, this.c.b());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final j b() {
/* 133 */     return this.b;
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
/*     */   public final f c() {
/* 183 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 189 */     return "PDColor{components=" + Arrays.toString(this.a) + ", patternName=" + this.b + "}";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\f\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */