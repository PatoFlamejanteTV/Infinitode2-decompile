/*     */ package org.a.c.h.f.a;
/*     */ 
/*     */ import com.a.a.a.am;
/*     */ import java.awt.color.CMMException;
/*     */ import java.awt.color.ColorSpace;
/*     */ import java.awt.color.ICC_ColorSpace;
/*     */ import java.awt.color.ICC_Profile;
/*     */ import java.awt.color.ProfileDataException;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.WritableRaster;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.StringTokenizer;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.g;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.m;
/*     */ import org.a.c.b.p;
/*     */ import org.a.c.h.a.c;
/*     */ import org.a.c.h.a.g;
/*     */ import org.a.c.h.a.i;
/*     */ import org.a.c.h.b;
/*     */ import org.a.c.h.j;
/*     */ import org.a.c.i.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class o
/*     */   extends a
/*     */ {
/*  60 */   private static final a a = c.a(o.class);
/*     */   
/*     */   private final i b;
/*  63 */   private int c = -1;
/*     */   
/*     */   private f d;
/*     */   
/*     */   private ICC_ColorSpace f;
/*     */   
/*     */   private e g;
/*     */   
/*     */   private boolean h = false;
/*     */   
/*     */   private boolean i = false;
/*     */   private static final boolean j;
/*     */   
/*     */   static {
/*  77 */     String str = System.getProperty("sun.java2d.cmm");
/*  78 */     j = (!h() || "sun.java2d.cmm.kcms.KcmsServiceProvider".equals(str));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public o(b paramb) {
/*  87 */     this.e = new a();
/*  88 */     this.e.a((b)j.bz);
/*  89 */     this.b = new i(paramb);
/*  90 */     this.e.a((c)this.b);
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
/*     */   @Deprecated
/*     */   private o(a parama) {
/* 107 */     a(parama);
/* 108 */     this
/* 109 */       .i = (System.getProperty("org.apache.pdfbox.rendering.UseAlternateInsteadOfICCColorSpace") != null);
/* 110 */     this.e = parama;
/* 111 */     this.b = new i((p)parama.a(1));
/* 112 */     e();
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
/*     */   public static o a(a parama, j paramj) {
/* 126 */     a(parama);
/* 127 */     b b = parama.b(1);
/* 128 */     m m = null;
/* 129 */     if (b instanceof m)
/*     */     {
/* 131 */       m = (m)b;
/*     */     }
/* 133 */     if (m != null && paramj != null && paramj.b() != null) {
/*     */       f f1;
/*     */       
/* 136 */       if ((f1 = paramj.b().b(m)) != null && f1 instanceof o)
/*     */       {
/* 138 */         return (o)f1;
/*     */       }
/*     */     } 
/* 141 */     o o1 = new o(parama);
/* 142 */     if (m != null && paramj != null && paramj.b() != null)
/*     */     {
/* 144 */       paramj.b().a(m, o1);
/*     */     }
/* 146 */     return o1;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void a(a parama) {
/* 151 */     if (parama.b() < 2)
/*     */     {
/* 153 */       throw new IOException("ICCBased colorspace array must have two elements");
/*     */     }
/* 155 */     if (!(parama.a(1) instanceof p))
/*     */     {
/* 157 */       throw new IOException("ICCBased colorspace array must have a stream as second element");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a() {
/* 164 */     return j.bz.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final i d() {
/* 173 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void e() {
/* 181 */     if (this.i) {
/*     */       
/*     */       try {
/*     */         
/* 185 */         a((Exception)null);
/*     */         
/*     */         return;
/* 188 */       } catch (IOException iOException) {
/*     */         
/* 190 */         (new StringBuilder("Error initializing alternate color space: ")).append(iOException.getLocalizedMessage());
/*     */       } 
/*     */     }
/* 193 */     g g = null;
/*     */     
/*     */     try {
/* 196 */       g = this.b.c();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 201 */       synchronized (a) {
/*     */         ICC_Profile iCC_Profile;
/*     */         
/* 204 */         if (a(iCC_Profile = ICC_Profile.getInstance((InputStream)g))) {
/*     */           
/* 206 */           this.h = true;
/* 207 */           this.f = (ICC_ColorSpace)ColorSpace.getInstance(1000);
/* 208 */           this.f.getProfile();
/*     */         }
/*     */         else {
/*     */           
/* 212 */           iCC_Profile = b(iCC_Profile);
/* 213 */           this.f = new ICC_ColorSpace(iCC_Profile);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 218 */         float[] arrayOfFloat = new float[b()];
/* 219 */         for (byte b = 0; b < b(); b++)
/*     */         {
/* 221 */           arrayOfFloat[b] = Math.max(0.0F, a(b).a());
/*     */         }
/* 223 */         this.g = new e(arrayOfFloat, this);
/*     */         
/* 225 */         if (j) {
/*     */         
/*     */         } else {
/*     */         
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/* 241 */     } catch (ProfileDataException profileDataException) {
/*     */       
/* 243 */       a(profileDataException);
/*     */       return;
/* 245 */     } catch (CMMException cMMException) {
/*     */       
/* 247 */       a(cMMException);
/*     */       return;
/* 249 */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       
/* 251 */       a(illegalArgumentException);
/*     */       return;
/* 253 */     } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/*     */       
/* 255 */       a(arrayIndexOutOfBoundsException);
/*     */       return;
/* 257 */     } catch (IOException iOException) {
/*     */       
/* 259 */       a(iOException);
/*     */       
/*     */       return;
/*     */     } finally {
/* 263 */       am.a((Closeable)g);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(Exception paramException) {
/* 269 */     this.f = null;
/* 270 */     this.d = g();
/* 271 */     if (this.d.equals(m.a))
/*     */     {
/* 273 */       this.h = true;
/*     */     }
/* 275 */     if (paramException != null)
/*     */     {
/* 277 */       (new StringBuilder("Can't read embedded ICC profile (")).append(paramException.getLocalizedMessage()).append("), using alternate color space: ")
/* 278 */         .append(this.d.a());
/*     */     }
/* 280 */     this.g = this.d.c();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean a(ICC_Profile paramICC_Profile) {
/* 288 */     byte[] arrayOfByte = Arrays.copyOfRange(paramICC_Profile.getData(1751474532), 52, 59);
/*     */     
/*     */     String str;
/* 291 */     return (str = (new String(arrayOfByte, a.a)).trim()).equals("sRGB");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ICC_Profile b(ICC_Profile paramICC_Profile) {
/* 298 */     if (paramICC_Profile.getProfileClass() != 1) {
/*     */       byte[] arrayOfByte;
/*     */ 
/*     */       
/* 302 */       if ((arrayOfByte = paramICC_Profile.getData())[64] == 0) {
/*     */ 
/*     */         
/* 305 */         a(1835955314, arrayOfByte, 12);
/* 306 */         return ICC_Profile.getInstance(arrayOfByte);
/*     */       } 
/*     */     } 
/* 309 */     return paramICC_Profile;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void a(int paramInt1, byte[] paramArrayOfbyte, int paramInt2) {
/* 314 */     paramArrayOfbyte[12] = 109;
/* 315 */     paramArrayOfbyte[13] = 110;
/* 316 */     paramArrayOfbyte[14] = 116;
/* 317 */     paramArrayOfbyte[15] = 114;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final float[] a(float[] paramArrayOffloat) {
/* 323 */     if (this.h)
/*     */     {
/* 325 */       return paramArrayOffloat;
/*     */     }
/* 327 */     if (this.f != null)
/*     */     {
/*     */ 
/*     */       
/* 331 */       return this.f.toRGB(a(this.f, paramArrayOffloat));
/*     */     }
/*     */ 
/*     */     
/* 335 */     return this.d.a(paramArrayOffloat);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static float[] a(ICC_ColorSpace paramICC_ColorSpace, float[] paramArrayOffloat) {
/* 341 */     float[] arrayOfFloat = new float[paramArrayOffloat.length];
/* 342 */     for (byte b = 0; b < paramArrayOffloat.length; b++) {
/*     */       
/* 344 */       float f1 = paramICC_ColorSpace.getMinValue(b);
/* 345 */       float f2 = paramICC_ColorSpace.getMaxValue(b);
/* 346 */       arrayOfFloat[b] = (paramArrayOffloat[b] < f1) ? f1 : ((paramArrayOffloat[b] > f2) ? f2 : paramArrayOffloat[b]);
/*     */     } 
/* 348 */     return arrayOfFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final BufferedImage a(WritableRaster paramWritableRaster) {
/* 354 */     if (this.f != null)
/*     */     {
/* 356 */       return a(paramWritableRaster, this.f);
/*     */     }
/*     */ 
/*     */     
/* 360 */     return this.d.a(paramWritableRaster);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int b() {
/* 367 */     if (this.c < 0)
/*     */     {
/* 369 */       this.c = this.b.a().j(j.co);
/*     */     }
/* 371 */     return this.c;
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
/*     */   public final e c() {
/* 397 */     return this.g;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private f g() {
/*     */     j j;
/*     */     a a1;
/*     */     b b;
/* 410 */     if ((b = this.b.a().a(j.g)) == null) {
/*     */       
/* 412 */       a1 = new a();
/*     */       
/*     */       int k;
/* 415 */       switch (k = b()) {
/*     */         
/*     */         case 1:
/* 418 */           j = j.aB;
/*     */           break;
/*     */         case 3:
/* 421 */           j = j.aD;
/*     */           break;
/*     */         case 4:
/* 424 */           j = j.aA;
/*     */           break;
/*     */         default:
/* 427 */           throw new IOException("Unknown color space number of components:" + j);
/*     */       } 
/* 429 */       a1.a((b)j);
/*     */ 
/*     */     
/*     */     }
/* 433 */     else if (j instanceof a) {
/*     */       
/* 435 */       a1 = (a)j;
/*     */     }
/* 437 */     else if (j instanceof j) {
/*     */ 
/*     */       
/* 440 */       (a1 = new a()).a((b)j);
/*     */     }
/*     */     else {
/*     */       
/* 444 */       throw new IOException("Error: expected COSArray or COSName and not " + j
/* 445 */           .getClass().getName());
/*     */     } 
/*     */     
/* 448 */     return f.a((b)a1);
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
/*     */   private g a(int paramInt) {
/*     */     a a1;
/* 461 */     if ((a1 = (a)this.b.a().a(j.db)) == null || a1.b() < b() << 1)
/*     */     {
/* 463 */       return new g();
/*     */     }
/* 465 */     return new g(a1, paramInt);
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
/*     */   public final String toString() {
/* 570 */     return a() + "{numberOfComponents: " + b() + "}";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean h() {
/* 576 */     String str = System.getProperty("java.specification.version");
/* 577 */     StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
/*     */     
/*     */     try {
/* 580 */       int j = Integer.parseInt(stringTokenizer.nextToken());
/* 581 */       int k = 0;
/* 582 */       if (stringTokenizer.hasMoreTokens())
/*     */       {
/* 584 */         k = Integer.parseInt(stringTokenizer.nextToken());
/*     */       }
/* 586 */       return (j > 1 || (j == 1 && k >= 8));
/*     */     }
/* 588 */     catch (NumberFormatException numberFormatException) {
/*     */ 
/*     */       
/* 591 */       return true;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\f\a\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */