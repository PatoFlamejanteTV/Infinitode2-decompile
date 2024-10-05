/*     */ package com.d.l;
/*     */ 
/*     */ import com.d.d.c;
/*     */ import com.d.m.f;
/*     */ import java.awt.Image;
/*     */ import java.awt.image.BufferedImage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class a
/*     */   implements c
/*     */ {
/*  30 */   private static final c a = new b((byte)0);
/*     */   
/*     */   public static c a(Image paramImage) {
/*  33 */     if (paramImage == null) {
/*  34 */       return a;
/*     */     }
/*     */     
/*  37 */     if (paramImage instanceof BufferedImage) {
/*  38 */       paramImage = f.a((BufferedImage)paramImage);
/*     */     } else {
/*  40 */       paramImage = f.a(paramImage, 2);
/*     */     } 
/*  42 */     return new a((BufferedImage)paramImage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class a
/*     */     extends a
/*     */   {
/*     */     private BufferedImage a;
/*     */ 
/*     */ 
/*     */     
/*     */     public a(BufferedImage param1BufferedImage) {
/*  56 */       this.a = param1BufferedImage;
/*     */     }
/*     */     
/*     */     public final int a() {
/*  60 */       return this.a.getWidth(null);
/*     */     }
/*     */     
/*     */     public final int b() {
/*  64 */       return this.a.getHeight(null);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void a(int param1Int1, int param1Int2) {
/*  72 */       if (param1Int1 > 0 || param1Int2 > 0) {
/*  73 */         int i = a();
/*  74 */         int j = b();
/*  75 */         param1Int1 = param1Int1;
/*  76 */         param1Int2 = param1Int2;
/*     */         
/*  78 */         if (param1Int1 == -1) {
/*  79 */           param1Int1 = (int)(i * param1Int2 / j);
/*     */         }
/*     */         
/*  82 */         if (param1Int2 == -1) {
/*  83 */           param1Int2 = (int)(j * param1Int1 / i);
/*     */         }
/*     */         
/*  86 */         if (i != param1Int1 || j != param1Int2)
/*  87 */           this.a = f.a(this.a, param1Int1, param1Int2); 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   static class b extends a {
/*     */     static {
/*  94 */       f.a(1, 1);
/*     */     }
/*     */     public final int a() {
/*  97 */       return 0;
/*     */     }
/*     */     private b() {}
/*     */     public final int b() {
/* 101 */       return 0;
/*     */     }
/*     */     
/*     */     public final void a(int param1Int1, int param1Int2) {}
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\l\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */