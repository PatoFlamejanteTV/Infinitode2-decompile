/*     */ package com.d.h;
/*     */ 
/*     */ import com.d.d.c;
/*     */ import com.d.m.l;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
/*     */ import java.util.logging.Level;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.imageio.ImageReader;
/*     */ import javax.imageio.stream.ImageInputStream;
/*     */ import org.a.c.h.f.c.b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class i
/*     */   implements c
/*     */ {
/*     */   private byte[] a;
/*     */   private final String b;
/*     */   private float c;
/*     */   private float d;
/*     */   private final boolean e;
/*     */   private b f;
/*     */   
/*     */   public i(byte[] paramArrayOfbyte, String paramString) {
/*     */     ImageInputStream imageInputStream;
/*  29 */     this.a = paramArrayOfbyte;
/*  30 */     this.b = paramString;
/*     */     
/*  32 */     paramArrayOfbyte = null;
/*  33 */     ImageReader imageReader = null;
/*     */ 
/*     */     
/*     */     try {
/*     */       Iterator<ImageReader> iterator;
/*     */ 
/*     */       
/*  40 */       if ((iterator = ImageIO.getImageReaders(imageInputStream = ImageIO.createImageInputStream(new ByteArrayInputStream(this.a)))).hasNext()) {
/*     */         
/*  42 */         (imageReader = iterator.next()).setInput(imageInputStream);
/*  43 */         this.c = imageReader.getWidth(0);
/*  44 */         this.d = imageReader.getHeight(0);
/*     */         
/*  46 */         paramString = imageReader.getFormatName();
/*     */         
/*  48 */         this
/*     */           
/*  50 */           .e = (paramString.equalsIgnoreCase("jpeg") || paramString.equalsIgnoreCase("jpg") || paramString.equalsIgnoreCase("jfif"));
/*     */       } else {
/*  52 */         l.e(Level.WARNING, "Unrecognized image format for: " + paramString);
/*     */         
/*  54 */         throw new IOException("Unrecognized Image format");
/*     */       } 
/*     */     } finally {
/*  57 */       if (imageInputStream != null)
/*  58 */         imageInputStream.close(); 
/*  59 */       if (imageReader != null) {
/*  60 */         imageReader.dispose();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public i(byte[] paramArrayOfbyte, String paramString, float paramFloat1, float paramFloat2, boolean paramBoolean, b paramb) {
/*  66 */     this.a = paramArrayOfbyte;
/*  67 */     this.b = paramString;
/*  68 */     this.c = paramFloat1;
/*  69 */     this.d = paramFloat2;
/*  70 */     this.e = paramBoolean;
/*  71 */     this.f = paramb;
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
/*     */   public final int a() {
/*  89 */     return (int)this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int b() {
/*  94 */     return (int)this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(int paramInt1, int paramInt2) {
/*     */     float f1, f2;
/* 101 */     if (paramInt1 != -1) {
/* 102 */       f1 = paramInt1;
/*     */       
/* 104 */       if (paramInt2 == -1 && this.c != 0.0F) {
/*     */         
/* 106 */         f2 = (int)(f1 / this.c * this.d);
/*     */       } else {
/* 108 */         f2 = f2;
/*     */       } 
/* 110 */     } else if (f2 != -1) {
/* 111 */       f2 = f2;
/*     */       
/* 113 */       if (this.d != 0.0F) {
/*     */         
/* 115 */         f1 = (int)(f2 / this.d * this.c);
/*     */       } else {
/* 117 */         f1 = 0.0F;
/*     */       } 
/*     */     } else {
/* 120 */       f1 = this.c;
/* 121 */       f2 = this.d;
/*     */     } 
/*     */ 
/*     */     
/* 125 */     this.c = f1;
/* 126 */     this.d = f2;
/*     */   }
/*     */   
/*     */   public final byte[] c() {
/* 130 */     return this.a;
/*     */   }
/*     */   
/*     */   public final void d() {
/* 134 */     this.a = null;
/*     */   }
/*     */   
/*     */   public final b e() {
/* 138 */     return this.f;
/*     */   }
/*     */   
/*     */   public final void a(b paramb) {
/* 142 */     this.f = paramb;
/*     */   }
/*     */   
/*     */   public final String f() {
/* 146 */     return this.b;
/*     */   }
/*     */   
/*     */   public final boolean g() {
/* 150 */     return this.e;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\h\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */