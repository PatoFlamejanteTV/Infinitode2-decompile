/*     */ package org.a.c.h.f.a;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ public final class c
/*     */   extends b
/*     */ {
/*  35 */   private final e f = new e(new float[] { 0.0F }, this);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  40 */   private final Map<Float, float[]> g = (Map)new HashMap<Float, float>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public c() {
/*  47 */     super(j.K);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public c(a parama) {
/*  57 */     super(parama);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a() {
/*  63 */     return j.K.a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int b() {
/*  69 */     return 1;
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
/*     */   public final e c() {
/*  81 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final float[] a(float[] paramArrayOffloat) {
/*     */     float f;
/*  88 */     if (this.b == 1.0F && this.c == 1.0F && this.d == 1.0F) {
/*     */       
/*  90 */       f = paramArrayOffloat[0];
/*     */       float[] arrayOfFloat2;
/*  92 */       if ((arrayOfFloat2 = this.g.get(Float.valueOf(f))) != null)
/*     */       {
/*  94 */         return (float[])arrayOfFloat2.clone();
/*     */       }
/*  96 */       float f1 = d();
/*     */       
/*  98 */       float[] arrayOfFloat1 = a(f1 = (float)Math.pow(f, f1), f1, f1);
/*  99 */       this.g.put(Float.valueOf(f), arrayOfFloat1.clone());
/* 100 */       return arrayOfFloat1;
/*     */     } 
/*     */ 
/*     */     
/* 104 */     return new float[] { f[0], f[0], f[0] };
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
/*     */   private float d() {
/* 116 */     float f = 1.0F;
/*     */     l l;
/* 118 */     if ((l = (l)this.a.a(j.bu)) != null)
/*     */     {
/* 120 */       f = l.a();
/*     */     }
/* 122 */     return f;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\f\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */