/*     */ package org.a.c.h.f.a;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Point;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.Raster;
/*     */ import java.awt.image.WritableRaster;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.k;
/*     */ import org.a.c.h.a.a;
/*     */ import org.a.c.h.a.b.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class j
/*     */   extends v
/*     */ {
/*  57 */   private f a = null;
/*  58 */   private a b = null;
/*     */   
/*     */   private k c;
/*     */   
/*     */   private e d;
/*     */   
/*     */   private int f;
/*     */   
/*     */   private int[] g;
/*     */   
/*     */   private f h;
/*     */   
/*     */   private u[] i;
/*     */   
/*     */   public j() {
/*  73 */     this.e = new a();
/*  74 */     this.e.a((b)org.a.c.b.j.aC);
/*     */ 
/*     */     
/*  77 */     this.e.a((b)k.a);
/*  78 */     this.e.a((b)k.a);
/*  79 */     this.e.a((b)k.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j(a parama) {
/*  88 */     this.e = parama;
/*  89 */     this.a = f.a(this.e.a(2));
/*  90 */     this.b = a.a(this.e.a(3));
/*     */     
/*  92 */     if (this.e.b() > 4)
/*     */     {
/*  94 */       this.c = new k((d)this.e.a(4));
/*     */     }
/*  96 */     d();
/*     */     
/*     */     int i;
/*     */     
/* 100 */     float[] arrayOfFloat = new float[i = b()];
/* 101 */     for (byte b = 0; b < i; b++)
/*     */     {
/* 103 */       arrayOfFloat[b] = 1.0F;
/*     */     }
/* 105 */     this.d = new e(arrayOfFloat, this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void d() {
/* 112 */     if (this.c == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 118 */     List<String> list = g();
/* 119 */     this.f = list.size();
/*     */ 
/*     */     
/* 122 */     this.g = new int[this.f];
/* 123 */     for (byte b1 = 0; b1 < this.f; b1++)
/*     */     {
/* 125 */       this.g[b1] = -1;
/*     */     }
/*     */     
/* 128 */     if (this.c.b() != null) {
/*     */       
/* 130 */       List<String> list1 = this.c.b().b();
/*     */ 
/*     */       
/* 133 */       for (byte b = 0; b < this.f; b++)
/*     */       {
/* 135 */         this.g[b] = list1.indexOf(list.get(b));
/*     */       }
/*     */ 
/*     */       
/* 139 */       this.h = this.c.b().a();
/*     */     } 
/*     */ 
/*     */     
/* 143 */     this.i = new u[this.f];
/*     */ 
/*     */     
/* 146 */     Map<String, u> map = this.c.a();
/*     */ 
/*     */     
/* 149 */     for (byte b2 = 0; b2 < this.f; b2++) {
/*     */       
/* 151 */       String str = list.get(b2);
/*     */       u u1;
/* 153 */       if ((u1 = map.get(str)) != null) {
/*     */ 
/*     */         
/* 156 */         this.i[b2] = u1;
/*     */ 
/*     */ 
/*     */         
/* 160 */         if (!e())
/*     */         {
/* 162 */           this.g[b2] = -1;
/*     */         
/*     */         }
/*     */       }
/*     */       else {
/*     */         
/* 168 */         this.i[b2] = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final BufferedImage a(WritableRaster paramWritableRaster) {
/* 176 */     if (this.c != null)
/*     */     {
/* 178 */       return b(paramWritableRaster);
/*     */     }
/*     */ 
/*     */     
/* 182 */     return c(paramWritableRaster);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private BufferedImage b(WritableRaster paramWritableRaster) {
/* 191 */     int i = paramWritableRaster.getWidth();
/* 192 */     int m = paramWritableRaster.getHeight();
/*     */     
/*     */     BufferedImage bufferedImage;
/* 195 */     WritableRaster writableRaster = (bufferedImage = new BufferedImage(i, m, 1)).getRaster();
/*     */     
/*     */     Graphics2D graphics2D;
/*     */     
/* 199 */     (graphics2D = bufferedImage.createGraphics()).setBackground(Color.WHITE);
/* 200 */     graphics2D.clearRect(0, 0, i, m);
/* 201 */     graphics2D.dispose();
/*     */ 
/*     */     
/* 204 */     for (byte b = 0; b < this.f; b++) {
/*     */       f f1;
/*     */       
/* 207 */       if (this.g[b] >= 0) {
/*     */ 
/*     */         
/* 210 */         f1 = this.h;
/*     */       } else {
/* 212 */         if (this.i[b] == null)
/*     */         {
/*     */ 
/*     */           
/* 216 */           return c(paramWritableRaster);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 221 */         f1 = this.i[b];
/*     */       } 
/*     */ 
/*     */       
/* 225 */       WritableRaster writableRaster1 = Raster.createBandedRaster(0, i, m, f1
/* 226 */           .b(), new Point(0, 0));
/*     */       
/* 228 */       int[] arrayOfInt3 = new int[this.f];
/* 229 */       int[] arrayOfInt4 = new int[f1.b()];
/* 230 */       boolean bool = (this.g[b] >= 0) ? true : false;
/* 231 */       int n = this.g[b];
/* 232 */       for (byte b2 = 0; b2 < m; b2++) {
/*     */         
/* 234 */         for (byte b3 = 0; b3 < i; b3++) {
/*     */           
/* 236 */           paramWritableRaster.getPixel(b3, b2, arrayOfInt3);
/* 237 */           if (bool) {
/*     */ 
/*     */             
/* 240 */             arrayOfInt4[n] = arrayOfInt3[b];
/*     */           
/*     */           }
/*     */           else {
/*     */             
/* 245 */             arrayOfInt4[0] = arrayOfInt3[b];
/*     */           } 
/* 247 */           writableRaster1.setPixel(b3, b2, arrayOfInt4);
/*     */         } 
/*     */       } 
/*     */       
/*     */       BufferedImage bufferedImage1;
/*     */       
/* 253 */       WritableRaster writableRaster2 = (bufferedImage1 = f1.a(writableRaster1)).getRaster();
/*     */ 
/*     */       
/* 256 */       int[] arrayOfInt1 = new int[3];
/* 257 */       int[] arrayOfInt2 = new int[3];
/* 258 */       for (byte b1 = 0; b1 < m; b1++) {
/*     */         
/* 260 */         for (byte b3 = 0; b3 < i; b3++) {
/*     */           
/* 262 */           writableRaster2.getPixel(b3, b1, arrayOfInt1);
/* 263 */           writableRaster.getPixel(b3, b1, arrayOfInt2);
/*     */ 
/*     */           
/* 266 */           arrayOfInt1[0] = arrayOfInt1[0] * arrayOfInt2[0] >> 8;
/* 267 */           arrayOfInt1[1] = arrayOfInt1[1] * arrayOfInt2[1] >> 8;
/* 268 */           arrayOfInt1[2] = arrayOfInt1[2] * arrayOfInt2[2] >> 8;
/*     */           
/* 270 */           writableRaster.setPixel(b3, b1, arrayOfInt1);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 275 */     return bufferedImage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private BufferedImage c(WritableRaster paramWritableRaster) {
/* 284 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*     */ 
/*     */     
/* 287 */     int i = paramWritableRaster.getWidth();
/* 288 */     int m = paramWritableRaster.getHeight();
/*     */ 
/*     */     
/*     */     BufferedImage bufferedImage;
/*     */     
/* 293 */     WritableRaster writableRaster = (bufferedImage = new BufferedImage(i, m, 1)).getRaster();
/* 294 */     int[] arrayOfInt = new int[3];
/*     */     int n;
/* 296 */     float[] arrayOfFloat = new float[n = g().size()];
/* 297 */     for (byte b = 0; b < m; b++) {
/*     */       
/* 299 */       for (byte b1 = 0; b1 < i; b1++) {
/*     */         
/* 301 */         paramWritableRaster.getPixel(b1, b, arrayOfFloat);
/*     */         
/* 303 */         String str = Float.toString(arrayOfFloat[0]);
/* 304 */         for (byte b2 = 1; b2 < n; b2++)
/*     */         {
/* 306 */           str = str + "#" + Float.toString(arrayOfFloat[b2]);
/*     */         }
/*     */         int[] arrayOfInt1;
/* 309 */         if ((arrayOfInt1 = (int[])hashMap.get(str)) != null) {
/*     */           
/* 311 */           writableRaster.setPixel(b1, b, arrayOfInt1);
/*     */         }
/*     */         else {
/*     */           
/* 315 */           for (byte b3 = 0; b3 < n; b3++)
/*     */           {
/* 317 */             arrayOfFloat[b3] = arrayOfFloat[b3] / 255.0F;
/*     */           }
/*     */           
/* 320 */           float[] arrayOfFloat1 = this.b.a(arrayOfFloat);
/*     */ 
/*     */           
/* 323 */           arrayOfFloat1 = this.a.a(arrayOfFloat1);
/*     */           
/* 325 */           for (byte b4 = 0; b4 < 3; b4++)
/*     */           {
/*     */             
/* 328 */             arrayOfInt[b4] = (int)(arrayOfFloat1[b4] * 255.0F);
/*     */           }
/*     */           
/* 331 */           hashMap.put(str, arrayOfInt.clone());
/*     */           
/* 333 */           writableRaster.setPixel(b1, b, arrayOfInt);
/*     */         } 
/*     */       } 
/* 336 */     }  return bufferedImage;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final float[] a(float[] paramArrayOffloat) {
/* 342 */     if (this.c != null)
/*     */     {
/* 344 */       return b(paramArrayOffloat);
/*     */     }
/*     */ 
/*     */     
/* 348 */     return c(paramArrayOffloat);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private float[] b(float[] paramArrayOffloat) {
/* 354 */     float[] arrayOfFloat = { 1.0F, 1.0F, 1.0F };
/*     */ 
/*     */     
/* 357 */     for (byte b = 0; b < this.f; b++) {
/*     */       f f1;
/*     */       
/* 360 */       if (this.g[b] >= 0) {
/*     */ 
/*     */         
/* 363 */         f1 = this.h;
/*     */       } else {
/* 365 */         if (this.i[b] == null)
/*     */         {
/*     */ 
/*     */           
/* 369 */           return c(paramArrayOffloat);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 374 */         f1 = this.i[b];
/*     */       } 
/*     */ 
/*     */       
/* 378 */       boolean bool = (this.g[b] >= 0) ? true : false;
/* 379 */       float[] arrayOfFloat2 = new float[f1.b()];
/* 380 */       int i = this.g[b];
/*     */       
/* 382 */       if (bool) {
/*     */ 
/*     */         
/* 385 */         arrayOfFloat2[i] = paramArrayOffloat[b];
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 390 */         arrayOfFloat2[0] = paramArrayOffloat[b];
/*     */       } 
/*     */ 
/*     */       
/* 394 */       float[] arrayOfFloat1 = f1.a(arrayOfFloat2);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 399 */       arrayOfFloat[0] = arrayOfFloat[0] * arrayOfFloat1[0];
/* 400 */       arrayOfFloat[1] = arrayOfFloat[1] * arrayOfFloat1[1];
/* 401 */       arrayOfFloat[2] = arrayOfFloat[2] * arrayOfFloat1[2];
/*     */     } 
/*     */     
/* 404 */     return arrayOfFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float[] c(float[] paramArrayOffloat) {
/* 411 */     paramArrayOffloat = this.b.a(paramArrayOffloat);
/*     */ 
/*     */     
/* 414 */     return this.a.a(paramArrayOffloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean e() {
/* 423 */     return (this.c != null && this.c.c());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a() {
/* 429 */     return org.a.c.b.j.aC.a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int b() {
/* 435 */     return g().size();
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
/*     */   public final e c() {
/* 453 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> g() {
/*     */     a a1;
/* 463 */     return a.c(a1 = (a)this.e.a(1));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */     StringBuilder stringBuilder;
/* 573 */     (stringBuilder = new StringBuilder(a())).append('{');
/* 574 */     for (String str : g()) {
/*     */       
/* 576 */       stringBuilder.append('"');
/* 577 */       stringBuilder.append(str);
/* 578 */       stringBuilder.append("\" ");
/*     */     } 
/* 580 */     stringBuilder.append(this.a.a());
/* 581 */     stringBuilder.append(' ');
/* 582 */     stringBuilder.append(this.b);
/* 583 */     stringBuilder.append(' ');
/* 584 */     if (this.c != null)
/*     */     {
/* 586 */       stringBuilder.append(this.c);
/*     */     }
/* 588 */     stringBuilder.append('}');
/* 589 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\f\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */