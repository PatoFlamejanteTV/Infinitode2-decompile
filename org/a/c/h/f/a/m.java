/*     */ package org.a.c.h.f.a;
/*     */ 
/*     */ import java.awt.color.ColorSpace;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.WritableRaster;
/*     */ import org.a.c.b.j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class m
/*     */   extends h
/*     */ {
/*  36 */   public static final m a = new m();
/*     */   
/*  38 */   private final e b = new e(new float[] { 0.0F, 0.0F, 0.0F }, this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private volatile ColorSpace c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void d() {
/*  51 */     if (this.c != null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  56 */     synchronized (this) {
/*     */ 
/*     */       
/*  59 */       if (this.c != null) {
/*     */         return;
/*     */       }
/*     */       
/*  63 */       this.c = ColorSpace.getInstance(1000);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  68 */       this.c.toRGB(new float[] { 0.0F, 0.0F, 0.0F, 0.0F });
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final String a() {
/*  75 */     return j.aD.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int b() {
/*  84 */     return 3;
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
/*  96 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final float[] a(float[] paramArrayOffloat) {
/* 102 */     return paramArrayOffloat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final BufferedImage a(WritableRaster paramWritableRaster) {
/* 108 */     d();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     BufferedImage bufferedImage;
/*     */ 
/*     */ 
/*     */     
/* 117 */     (bufferedImage = new BufferedImage(paramWritableRaster.getWidth(), paramWritableRaster.getHeight(), 1)).setData(paramWritableRaster);
/* 118 */     return bufferedImage;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\f\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */