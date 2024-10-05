/*     */ package org.a.c.h.f.c;
/*     */ 
/*     */ import java.awt.color.ColorSpace;
/*     */ import java.awt.color.ICC_ColorSpace;
/*     */ import java.awt.color.ICC_Profile;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.WritableRaster;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.zip.Deflater;
/*     */ import java.util.zip.DeflaterOutputStream;
/*     */ import javax.imageio.stream.MemoryCacheImageOutputStream;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.i;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.c.l;
/*     */ import org.a.c.c.m;
/*     */ import org.a.c.h.a.c;
/*     */ import org.a.c.h.b;
/*     */ import org.a.c.h.f.a.f;
/*     */ import org.a.c.h.f.a.g;
/*     */ import org.a.c.h.f.a.i;
/*     */ import org.a.c.h.f.a.m;
/*     */ import org.a.c.h.f.a.o;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class a
/*     */ {
/*     */   private static boolean a = true;
/*     */   
/*     */   public static b a(b paramb, BufferedImage paramBufferedImage) {
/*     */     b b1;
/*  82 */     if ((paramBufferedImage.getType() == 10 && paramBufferedImage.getColorModel().getPixelSize() <= 8) || (paramBufferedImage
/*  83 */       .getType() == 12 && paramBufferedImage.getColorModel().getPixelSize() == 1))
/*     */     {
/*  85 */       return a(paramBufferedImage, paramb);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  90 */     if (a) {
/*     */       b b2;
/*     */       
/*  93 */       if ((b2 = (new a(paramb, paramBufferedImage)).a()) != null) {
/*     */         
/*  95 */         if (b2.e() == m.a && b2
/*  96 */           .d() < 16 && paramBufferedImage
/*  97 */           .getWidth() * paramBufferedImage.getHeight() <= 2500) {
/*     */ 
/*     */ 
/*     */           
/* 101 */           if ((b1 = b(paramBufferedImage, paramb)).b().n() < b2
/* 102 */             .b().n()) {
/*     */             
/* 104 */             b2.b().close();
/* 105 */             return b1;
/*     */           } 
/*     */ 
/*     */           
/* 109 */           b1.b().close();
/*     */         } 
/*     */         
/* 112 */         return b2;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 117 */     return b(paramBufferedImage, (b)b1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static b a(BufferedImage paramBufferedImage, b paramb) {
/* 125 */     int i = paramBufferedImage.getHeight();
/*     */     
/* 127 */     int j, arrayOfInt[] = new int[j = paramBufferedImage.getWidth()];
/* 128 */     int k = paramBufferedImage.getColorModel().getPixelSize();
/* 129 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((j * k / 8 + ((j * k % 8 != 0) ? 1 : 0)) * i);
/* 130 */     MemoryCacheImageOutputStream memoryCacheImageOutputStream = new MemoryCacheImageOutputStream(byteArrayOutputStream);
/* 131 */     for (byte b1 = 0; b1 < i; b1++) {
/*     */       int[] arrayOfInt1; int n; byte b2;
/* 133 */       for (n = (arrayOfInt1 = paramBufferedImage.getRGB(0, b1, j, 1, arrayOfInt, 0, j)).length, b2 = 0; b2 < n; ) { int i1 = arrayOfInt1[b2];
/*     */         
/* 135 */         memoryCacheImageOutputStream.writeBits((i1 & 0xFF), k);
/*     */         b2++; }
/*     */       
/*     */       int m;
/* 139 */       if ((m = memoryCacheImageOutputStream.getBitOffset()) != 0)
/*     */       {
/* 141 */         memoryCacheImageOutputStream.writeBits(0L, 8 - m);
/*     */       }
/*     */     } 
/* 144 */     memoryCacheImageOutputStream.flush();
/* 145 */     memoryCacheImageOutputStream.close();
/* 146 */     return b(paramb, byteArrayOutputStream.toByteArray(), paramBufferedImage
/* 147 */         .getWidth(), paramBufferedImage.getHeight(), k, (f)i.a);
/*     */   }
/*     */   
/*     */   private static b b(BufferedImage paramBufferedImage, b paramb) {
/*     */     byte[] arrayOfByte2;
/* 152 */     int i = paramBufferedImage.getHeight();
/*     */     
/* 154 */     int j, arrayOfInt[] = new int[j = paramBufferedImage.getWidth()];
/*     */     
/* 156 */     m m = m.a;
/* 157 */     byte[] arrayOfByte1 = new byte[j * i * 3];
/* 158 */     byte b1 = 0;
/* 159 */     byte b2 = 0;
/* 160 */     byte b3 = 7;
/*     */     int k;
/* 162 */     byte b4 = ((k = paramBufferedImage.getTransparency()) == 2) ? 1 : 8;
/*     */     
/* 164 */     if (k != 1) {
/*     */       
/* 166 */       arrayOfByte2 = new byte[(j * b4 / 8 + ((j * b4 % 8 != 0) ? 1 : 0)) * i];
/*     */     }
/*     */     else {
/*     */       
/* 170 */       arrayOfByte2 = new byte[0];
/*     */     } 
/* 172 */     for (byte b6 = 0; b6 < i; b6++) {
/*     */       int[] arrayOfInt1; int n; byte b7;
/* 174 */       for (n = (arrayOfInt1 = paramBufferedImage.getRGB(0, b6, j, 1, arrayOfInt, 0, j)).length, b7 = 0; b7 < n; ) { int i1 = arrayOfInt1[b7];
/*     */         
/* 176 */         arrayOfByte1[b1++] = (byte)(i1 >> 16);
/* 177 */         arrayOfByte1[b1++] = (byte)(i1 >> 8);
/* 178 */         arrayOfByte1[b1++] = (byte)i1;
/* 179 */         if (k != 1)
/*     */         {
/*     */ 
/*     */           
/* 183 */           if (k == 2) {
/*     */ 
/*     */             
/* 186 */             arrayOfByte2[b2] = (byte)(arrayOfByte2[b2] | (i1 >> 24 & 0x1) << b3);
/* 187 */             if (--b3 < 0)
/*     */             {
/* 189 */               b3 = 7;
/* 190 */               b2++;
/*     */             }
/*     */           
/*     */           }
/*     */           else {
/*     */             
/* 196 */             arrayOfByte2[b2++] = (byte)(i1 >>> 24);
/*     */           } 
/*     */         }
/*     */         
/*     */         b7++; }
/*     */       
/* 202 */       if (k == 2 && b3 != 7) {
/*     */         
/* 204 */         b3 = 7;
/* 205 */         b2++;
/*     */       } 
/*     */     } 
/* 208 */     b b5 = b(paramb, arrayOfByte1, paramBufferedImage
/* 209 */         .getWidth(), paramBufferedImage.getHeight(), 8, (f)m);
/* 210 */     if (k != 1) {
/*     */       
/* 212 */       b b7 = b(paramb, arrayOfByte2, paramBufferedImage
/* 213 */           .getWidth(), paramBufferedImage.getHeight(), b4, (f)i.a);
/* 214 */       b5.b().a(j.ds, (c)b7);
/*     */     } 
/* 216 */     return b5;
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
/*     */   private static b b(b paramb, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, f paramf) {
/* 236 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfbyte.length / 2);
/*     */     
/*     */     l l;
/* 239 */     (l = m.a.a(j.bc)).b(new ByteArrayInputStream(paramArrayOfbyte), byteArrayOutputStream, new d());
/*     */     
/* 241 */     ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
/* 242 */     return new b(paramb, byteArrayInputStream, (b)j.bc, paramInt1, paramInt2, paramInt3, paramf);
/*     */   }
/*     */ 
/*     */   
/*     */   static class a
/*     */   {
/*     */     private final b a;
/*     */     
/*     */     private final BufferedImage b;
/*     */     
/*     */     private final int c;
/*     */     
/*     */     private final int d;
/*     */     
/*     */     private final int e;
/*     */     
/*     */     private final int f;
/*     */     
/*     */     private final int g;
/*     */     
/*     */     private final int h;
/*     */     
/*     */     private final byte[] i;
/*     */     
/*     */     private final byte[] j;
/*     */     private final byte[] k;
/*     */     private final byte[] l;
/*     */     private final byte[] m;
/*     */     private int n;
/*     */     private boolean o;
/*     */     private byte[] p;
/*     */     private byte[] q;
/*     */     private byte[] r;
/*     */     private byte[] s;
/*     */     private byte[] t;
/*     */     
/*     */     a(b param1b, BufferedImage param1BufferedImage) {
/* 279 */       this.a = param1b;
/* 280 */       this.b = param1BufferedImage;
/*     */ 
/*     */       
/* 283 */       this.c = param1BufferedImage.getColorModel().getNumComponents();
/* 284 */       this.d = param1BufferedImage.getRaster().getTransferType();
/* 285 */       this.e = (this.d == 2 || this.d == 1) ? 2 : 1;
/*     */ 
/*     */ 
/*     */       
/* 289 */       this.f = param1BufferedImage.getColorModel().getNumColorComponents() * this.e;
/*     */       
/* 291 */       this.g = param1BufferedImage.getHeight();
/* 292 */       this.h = param1BufferedImage.getWidth();
/* 293 */       this.n = param1BufferedImage.getType();
/* 294 */       this
/* 295 */         .o = (param1BufferedImage.getColorModel().getNumComponents() != param1BufferedImage.getColorModel().getNumColorComponents());
/* 296 */       this.p = this.o ? new byte[this.h * this.g * this.e] : null;
/*     */ 
/*     */       
/* 299 */       int i = this.h * this.f + 1;
/* 300 */       this.i = new byte[i];
/* 301 */       this.j = new byte[i];
/* 302 */       this.k = new byte[i];
/* 303 */       this.l = new byte[i];
/* 304 */       this.m = new byte[i];
/*     */ 
/*     */       
/* 307 */       this.i[0] = 0;
/* 308 */       this.j[0] = 1;
/* 309 */       this.k[0] = 2;
/* 310 */       this.l[0] = 3;
/* 311 */       this.m[0] = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 318 */       this.q = new byte[this.f];
/* 319 */       this.r = new byte[this.f];
/* 320 */       this.s = new byte[this.f];
/* 321 */       this.t = new byte[this.f];
/*     */     }
/*     */ 
/*     */     
/*     */     final b a() {
/*     */       int i;
/*     */       short[] arrayOfShort1;
/*     */       byte[] arrayOfByte1;
/*     */       int[] arrayOfInt1;
/*     */       short[] arrayOfShort2;
/*     */       byte[] arrayOfByte2;
/*     */       int[] arrayOfInt2;
/* 333 */       WritableRaster writableRaster = this.b.getRaster();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 341 */       switch (this.n) {
/*     */ 
/*     */         
/*     */         case 0:
/* 345 */           switch (writableRaster.getTransferType()) {
/*     */             
/*     */             case 1:
/* 348 */               i = this.c;
/* 349 */               arrayOfShort1 = new short[this.h * i];
/* 350 */               arrayOfShort2 = new short[this.h * i];
/*     */               break;
/*     */             case 0:
/* 353 */               i = this.c;
/* 354 */               arrayOfByte1 = new byte[this.h * i];
/* 355 */               arrayOfByte2 = new byte[this.h * i];
/*     */               break;
/*     */           } 
/* 358 */           return null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 5:
/*     */         case 6:
/* 366 */           i = this.c;
/* 367 */           arrayOfByte1 = new byte[this.h * i];
/* 368 */           arrayOfByte2 = new byte[this.h * i];
/*     */           break;
/*     */ 
/*     */ 
/*     */         
/*     */         case 1:
/*     */         case 2:
/*     */         case 4:
/* 376 */           i = 1;
/* 377 */           arrayOfInt1 = new int[this.h];
/* 378 */           arrayOfInt2 = new int[this.h];
/*     */           break;
/*     */ 
/*     */ 
/*     */         
/*     */         default:
/* 384 */           return null;
/*     */       } 
/*     */       
/* 387 */       int j = this.h * i;
/*     */ 
/*     */       
/* 390 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this.g * this.h * this.f / 2);
/*     */       
/* 392 */       Deflater deflater = new Deflater(l.a());
/* 393 */       DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
/*     */       
/* 395 */       int k = 0;
/*     */       
/* 397 */       for (byte b1 = 0; b1 < this.g; b1++) {
/*     */         byte[] arrayOfByte3, arrayOfByte4; int[] arrayOfInt3, arrayOfInt4; short[] arrayOfShort3, arrayOfShort4;
/* 399 */         writableRaster.getDataElements(0, b1, this.h, 1, arrayOfInt2);
/*     */ 
/*     */         
/* 402 */         byte b2 = 1;
/* 403 */         Arrays.fill(this.q, (byte)0);
/* 404 */         Arrays.fill(this.r, (byte)0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 413 */         if (arrayOfInt2 instanceof byte[]) {
/*     */           
/* 415 */           arrayOfByte3 = (byte[])arrayOfInt2;
/* 416 */           arrayOfByte4 = (byte[])arrayOfInt1;
/* 417 */           arrayOfInt3 = (int[])(arrayOfInt4 = null);
/* 418 */           arrayOfShort3 = (short[])(arrayOfShort4 = null);
/*     */         }
/* 420 */         else if (arrayOfInt2 instanceof int[]) {
/*     */           
/* 422 */           arrayOfInt3 = arrayOfInt2;
/* 423 */           arrayOfInt4 = arrayOfInt1;
/* 424 */           arrayOfShort3 = (short[])(arrayOfShort4 = null);
/* 425 */           arrayOfByte3 = (byte[])(arrayOfByte4 = null);
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 430 */           arrayOfShort3 = (short[])arrayOfInt2;
/* 431 */           arrayOfShort4 = (short[])arrayOfInt1;
/* 432 */           arrayOfInt3 = (int[])(arrayOfInt4 = null);
/* 433 */           arrayOfByte3 = (byte[])(arrayOfByte4 = null);
/*     */         } 
/*     */         
/* 436 */         for (int m = 0; m < j; 
/* 437 */           m += i, k += this.e) {
/*     */ 
/*     */           
/* 440 */           if (arrayOfByte3 != null) {
/*     */             
/* 442 */             a(arrayOfByte3, m, this.t, this.p, k);
/*     */             
/* 444 */             a(arrayOfByte4, m, this.s, (byte[])null, 0);
/*     */           }
/* 446 */           else if (arrayOfInt3 != null) {
/*     */             
/* 448 */             a(arrayOfInt3, m, this.t, this.p, k);
/*     */             
/* 450 */             a(arrayOfInt4, m, this.s, (byte[])null, 0);
/*     */           
/*     */           }
/*     */           else {
/*     */             
/* 455 */             a(arrayOfShort3, m, this.t, this.p, k);
/* 456 */             a(arrayOfShort4, m, this.s, (byte[])null, 0);
/*     */           } 
/*     */ 
/*     */           
/* 460 */           int n = this.t.length;
/* 461 */           for (byte b3 = 0; b3 < n; b3++) {
/*     */             
/* 463 */             int i1 = this.t[b3] & 0xFF;
/* 464 */             int i2 = this.q[b3] & 0xFF;
/* 465 */             int i3 = this.s[b3] & 0xFF;
/* 466 */             int i4 = this.r[b3] & 0xFF;
/* 467 */             this.i[b2] = (byte)i1;
/* 468 */             this.j[b2] = a(i1, i2);
/* 469 */             this.k[b2] = b(i1, i3);
/* 470 */             this.l[b2] = a(i1, i2, i3);
/* 471 */             this.m[b2] = a(i1, i2, i3, i4);
/* 472 */             b2++;
/*     */           } 
/*     */ 
/*     */           
/* 476 */           System.arraycopy(this.t, 0, this.q, 0, this.f);
/* 477 */           System.arraycopy(this.s, 0, this.r, 0, this.f);
/*     */         } 
/*     */         
/* 480 */         byte[] arrayOfByte5 = b();
/*     */ 
/*     */         
/* 483 */         deflaterOutputStream.write(arrayOfByte5, 0, arrayOfByte5.length);
/*     */ 
/*     */         
/* 486 */         int[] arrayOfInt5 = arrayOfInt1;
/* 487 */         arrayOfInt1 = arrayOfInt2;
/* 488 */         arrayOfInt2 = arrayOfInt5;
/*     */       } 
/* 490 */       deflaterOutputStream.close();
/* 491 */       deflater.end();
/*     */       
/* 493 */       return a(byteArrayOutputStream, this.e << 3);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void a(int[] param1ArrayOfint, int param1Int1, byte[] param1ArrayOfbyte1, byte[] param1ArrayOfbyte2, int param1Int2) {
/*     */       int i;
/* 500 */       param1Int1 = (byte)(i = param1ArrayOfint[param1Int1]);
/* 501 */       byte b1 = (byte)(i >> 8);
/* 502 */       byte b2 = (byte)(i >> 16);
/*     */       
/* 504 */       switch (this.n) {
/*     */         
/*     */         case 4:
/* 507 */           param1ArrayOfbyte1[0] = param1Int1;
/* 508 */           param1ArrayOfbyte1[1] = b1;
/* 509 */           param1ArrayOfbyte1[2] = b2;
/*     */           return;
/*     */         case 2:
/* 512 */           param1ArrayOfbyte1[0] = b2;
/* 513 */           param1ArrayOfbyte1[1] = b1;
/* 514 */           param1ArrayOfbyte1[2] = param1Int1;
/* 515 */           if (param1ArrayOfbyte2 != null) {
/*     */             
/* 517 */             i = (byte)(i >>> 24);
/* 518 */             param1ArrayOfbyte2[param1Int2] = i; return;
/*     */           } 
/*     */           break;
/*     */         case 1:
/* 522 */           param1ArrayOfbyte1[0] = b2;
/* 523 */           param1ArrayOfbyte1[1] = b1;
/* 524 */           param1ArrayOfbyte1[2] = param1Int1;
/*     */           break;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private static void a(byte[] param1ArrayOfbyte1, int param1Int1, byte[] param1ArrayOfbyte2, byte[] param1ArrayOfbyte3, int param1Int2) {
/* 532 */       System.arraycopy(param1ArrayOfbyte1, param1Int1, param1ArrayOfbyte2, 0, param1ArrayOfbyte2.length);
/* 533 */       if (param1ArrayOfbyte3 != null)
/*     */       {
/* 535 */         param1ArrayOfbyte3[param1Int2] = param1ArrayOfbyte1[param1Int1 + param1ArrayOfbyte2.length];
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private static void a(short[] param1ArrayOfshort, int param1Int1, byte[] param1ArrayOfbyte1, byte[] param1ArrayOfbyte2, int param1Int2) {
/* 542 */       param1Int1 = param1Int1; short s;
/* 543 */       for (s = 0; s < param1ArrayOfbyte1.length; s += 2) {
/*     */         
/* 545 */         short s1 = param1ArrayOfshort[param1Int1++];
/* 546 */         param1ArrayOfbyte1[s] = (byte)(s1 >> 8);
/* 547 */         param1ArrayOfbyte1[s + 1] = (byte)s1;
/*     */       } 
/* 549 */       if (param1ArrayOfbyte2 != null) {
/*     */         
/* 551 */         s = param1ArrayOfshort[param1Int1];
/* 552 */         param1ArrayOfbyte2[param1Int2] = (byte)(s >> 8);
/* 553 */         param1ArrayOfbyte2[param1Int2 + 1] = (byte)s;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private b a(ByteArrayOutputStream param1ByteArrayOutputStream, int param1Int) {
/* 560 */       int i = this.b.getHeight();
/* 561 */       int j = this.b.getWidth();
/*     */       
/*     */       ColorSpace colorSpace;
/* 564 */       o o = (o)(((colorSpace = this.b.getColorModel().getColorSpace()).getType() != 9) ? m.a : g.a);
/*     */ 
/*     */ 
/*     */       
/* 568 */       if (colorSpace instanceof ICC_ColorSpace) {
/*     */         ICC_Profile iCC_Profile;
/*     */ 
/*     */         
/* 572 */         if ((iCC_Profile = ((ICC_ColorSpace)colorSpace).getProfile()) != ICC_Profile.getInstance(1000)) {
/*     */           OutputStream outputStream;
/*     */ 
/*     */ 
/*     */           
/* 577 */           (outputStream = (o = new o(this.a)).d().a(j.bc)).write(iCC_Profile.getData());
/* 578 */           outputStream.close();
/* 579 */           o.d().a().a(j.co, colorSpace
/* 580 */               .getNumComponents());
/* 581 */           o.d().a().a(j.g, 
/* 582 */               (colorSpace.getType() == 9) ? (b)j.aA : (b)j.aD);
/*     */ 
/*     */           
/* 585 */           o = o;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 590 */       b b1 = new b(this.a, new ByteArrayInputStream(param1ByteArrayOutputStream.toByteArray()), (b)j.bc, j, i, param1Int, (f)o);
/*     */       
/*     */       d d;
/*     */       
/* 594 */       (d = new d()).a(j.z, (b)i.a(param1Int));
/* 595 */       d.a(j.cT, (b)i.a(15L));
/* 596 */       d.a(j.ad, (b)i.a(j));
/* 597 */       d.a(j.ab, (b)i.a(colorSpace.getNumComponents()));
/* 598 */       b1.b().a(j.ar, (b)d);
/*     */       
/* 600 */       if (this.b.getTransparency() != 1) {
/*     */         
/* 602 */         b b2 = a.a(this.a, this.p, this.b
/* 603 */             .getWidth(), this.b.getHeight(), 8 * this.e, (f)i.a);
/* 604 */         b1.b().a(j.ds, (c)b2);
/*     */       } 
/* 606 */       return b1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private byte[] b() {
/* 620 */       byte[] arrayOfByte = this.i;
/* 621 */       long l1 = a(this.i);
/* 622 */       long l2 = a(this.j);
/* 623 */       long l3 = a(this.k);
/* 624 */       long l4 = a(this.l);
/* 625 */       long l5 = a(this.m);
/* 626 */       if (l1 > l2) {
/*     */         
/* 628 */         arrayOfByte = this.j;
/* 629 */         l1 = l2;
/*     */       } 
/* 631 */       if (l1 > l3) {
/*     */         
/* 633 */         arrayOfByte = this.k;
/* 634 */         l1 = l3;
/*     */       } 
/* 636 */       if (l1 > l4) {
/*     */         
/* 638 */         arrayOfByte = this.l;
/* 639 */         l1 = l4;
/*     */       } 
/* 641 */       if (l1 > l5)
/*     */       {
/* 643 */         arrayOfByte = this.m;
/*     */       }
/* 645 */       return arrayOfByte;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static byte a(int param1Int1, int param1Int2) {
/* 653 */       return (byte)((param1Int1 & 0xFF) - (param1Int2 & 0xFF));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private static byte b(int param1Int1, int param1Int2) {
/* 659 */       return a(param1Int1, param1Int2);
/*     */     }
/*     */ 
/*     */     
/*     */     private static byte a(int param1Int1, int param1Int2, int param1Int3) {
/* 664 */       return (byte)(param1Int1 - (param1Int3 + param1Int2) / 2);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private static byte a(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 670 */       int i, j = Math.abs((i = param1Int2 + param1Int3 - param1Int4) - param1Int2);
/* 671 */       int k = Math.abs(i - param1Int3);
/* 672 */       i = Math.abs(i - param1Int4);
/*     */       
/* 674 */       if (j <= k && j <= i) {
/*     */         
/* 676 */         param1Int2 = param1Int2;
/*     */       }
/* 678 */       else if (k <= i) {
/*     */         
/* 680 */         param1Int2 = param1Int3;
/*     */       }
/*     */       else {
/*     */         
/* 684 */         param1Int2 = param1Int4;
/*     */       } 
/*     */ 
/*     */       
/* 688 */       return (byte)(param1Int1 = param1Int1 - param1Int2);
/*     */     }
/*     */ 
/*     */     
/*     */     private static long a(byte[] param1ArrayOfbyte) {
/* 693 */       long l = 0L; int i; byte b1;
/* 694 */       for (i = (param1ArrayOfbyte = param1ArrayOfbyte).length, b1 = 0; b1 < i; ) { byte b2 = param1ArrayOfbyte[b1];
/*     */ 
/*     */         
/* 697 */         l += Math.abs(b2); b1++; }
/*     */       
/* 699 */       return l;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\f\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */