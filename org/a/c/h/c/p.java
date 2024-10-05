/*      */ package org.a.c.h.c;
/*      */ 
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.math.BigInteger;
/*      */ import java.nio.charset.Charset;
/*      */ import java.security.GeneralSecurityException;
/*      */ import java.security.MessageDigest;
/*      */ import java.security.NoSuchAlgorithmException;
/*      */ import java.security.SecureRandom;
/*      */ import java.util.Arrays;
/*      */ import javax.crypto.Cipher;
/*      */ import javax.crypto.spec.IvParameterSpec;
/*      */ import javax.crypto.spec.SecretKeySpec;
/*      */ import org.a.a.a.a;
/*      */ import org.a.a.a.c;
/*      */ import org.a.c.b.a;
/*      */ import org.a.c.b.b;
/*      */ import org.a.c.b.j;
/*      */ import org.a.c.b.s;
/*      */ import org.a.c.h.b;
/*      */ import org.a.c.i.a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class p
/*      */   extends k
/*      */ {
/*   54 */   private static final a c = c.a(p.class);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*   60 */     o.class;
/*      */   }
/*      */   
/*   63 */   private static final byte[] d = new byte[] { 40, -65, 78, 94, 78, 117, -118, 65, 100, 0, 78, 86, -1, -6, 1, 8, 46, 46, 0, -74, -48, 104, 62, Byte.MIN_VALUE, 47, 12, -87, -2, 100, 83, 105, 122 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   75 */   private static final String[] e = new String[] { "SHA-256", "SHA-384", "SHA-512" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private o f;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int c() {
/*  108 */     if (this.a == 40)
/*      */     {
/*  110 */       return 1;
/*      */     }
/*  112 */     if (this.a == 128 && this.f.d())
/*      */     {
/*  114 */       return 4;
/*      */     }
/*  116 */     if (this.a == 256)
/*      */     {
/*  118 */       return 5;
/*      */     }
/*      */     
/*  121 */     return 2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int a(int paramInt) {
/*  135 */     if (paramInt < 2 && !this.f.a().l())
/*      */     {
/*  137 */       return 2;
/*      */     }
/*  139 */     if (paramInt == 5)
/*      */     {
/*      */       
/*  142 */       return 6;
/*      */     }
/*  144 */     if (paramInt == 4)
/*      */     {
/*  146 */       return 4;
/*      */     }
/*  148 */     if (paramInt == 2 || paramInt == 3 || this.f.a().l())
/*      */     {
/*  150 */       return 3;
/*      */     }
/*  152 */     return 4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(d paramd, a parama, a parama1) {
/*      */     byte[] arrayOfByte2;
/*  172 */     if (!(parama1 instanceof n))
/*      */     {
/*  174 */       throw new IOException("Decryption material is not compatible with the document");
/*      */     }
/*      */ 
/*      */     
/*  178 */     if (paramd.c() >= 4) {
/*  179 */       b(paramd.o());
/*  180 */       a(paramd.o());
/*      */     } 
/*  182 */     a(paramd.l());
/*      */     
/*      */     String str;
/*      */     
/*  186 */     if ((str = (parama1 = parama1).a()) == null)
/*      */     {
/*  188 */       str = "";
/*      */     }
/*      */     
/*  191 */     int i = paramd.k();
/*  192 */     int j = paramd.e();
/*  193 */     boolean bool = (paramd.c() == 1) ? true : (paramd.d() / 8);
/*      */     
/*  195 */     byte[] arrayOfByte1 = a(parama);
/*      */ 
/*      */     
/*  198 */     boolean bool1 = paramd.l();
/*      */     
/*  200 */     byte[] arrayOfByte3 = paramd.h();
/*  201 */     byte[] arrayOfByte4 = paramd.g();
/*  202 */     byte[] arrayOfByte5 = null, arrayOfByte6 = null;
/*      */     
/*  204 */     Charset charset = a.d;
/*  205 */     if (j == 6 || j == 5) {
/*      */       
/*  207 */       charset = a.f;
/*  208 */       arrayOfByte5 = paramd.j();
/*  209 */       arrayOfByte6 = paramd.i();
/*      */     } 
/*      */     
/*  212 */     if (j == 6)
/*      */     {
/*  214 */       str = j.a(str);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  219 */     if (a(str.getBytes(charset), arrayOfByte3, arrayOfByte4, i, arrayOfByte1, j, bool, bool1)) {
/*      */ 
/*      */ 
/*      */       
/*  223 */       j j1 = j.d();
/*  224 */       a(j1);
/*      */ 
/*      */       
/*  227 */       if (j == 6 || j == 5) {
/*      */         
/*  229 */         arrayOfByte2 = str.getBytes(charset);
/*      */       }
/*      */       else {
/*      */         
/*  233 */         arrayOfByte2 = a(arrayOfByte2.getBytes(charset), arrayOfByte4, j, bool);
/*      */       } 
/*      */ 
/*      */       
/*  237 */       this
/*  238 */         .b = a(arrayOfByte2, arrayOfByte4, arrayOfByte3, arrayOfByte6, arrayOfByte5, i, arrayOfByte1, j, bool, bool1, true);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*  247 */     else if (b(arrayOfByte2.getBytes(charset), arrayOfByte3, arrayOfByte4, i, arrayOfByte1, j, bool, bool1)) {
/*      */       j j1;
/*      */ 
/*      */ 
/*      */       
/*  252 */       (j1 = new j(i)).k();
/*  253 */       a(j1);
/*      */       
/*  255 */       this
/*  256 */         .b = a(arrayOfByte2
/*  257 */           .getBytes(charset), arrayOfByte4, arrayOfByte3, arrayOfByte6, arrayOfByte5, i, arrayOfByte1, j, bool, bool1, false);
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  267 */       throw new b("Cannot decrypt PDF, the password is incorrect");
/*      */     } 
/*      */     
/*  270 */     if (j == 6 || j == 5)
/*      */     {
/*  272 */       a(paramd, i, bool1);
/*      */     }
/*      */     
/*  275 */     if (paramd.c() == 4 || paramd.c() == 5) {
/*      */       c c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  282 */       if ((c = paramd.m()) != null) {
/*      */         
/*  284 */         j j1 = c.b();
/*  285 */         b((j.d.equals(j1) || j.e
/*  286 */             .equals(j1)));
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static byte[] a(a parama) {
/*      */     byte[] arrayOfByte;
/*  296 */     if (parama != null && parama.b() > 0) {
/*      */       s s;
/*      */       
/*  299 */       arrayOfByte = (s = (s)parama.a(0)).c();
/*      */     }
/*      */     else {
/*      */       
/*  303 */       arrayOfByte = new byte[0];
/*      */     } 
/*  305 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(d paramd, int paramInt, boolean paramBoolean) {
/*      */     try {
/*      */       Cipher cipher;
/*  317 */       (cipher = Cipher.getInstance("AES/ECB/NoPadding")).init(2, new SecretKeySpec(this.b, "AES"));
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       int i;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       byte[] arrayOfByte;
/*      */ 
/*      */ 
/*      */       
/*  331 */       if ((i = (arrayOfByte = cipher.doFinal(paramd.p()))[0] & 0xFF | (arrayOfByte[1] & 0xFF) << 8 | (arrayOfByte[2] & 0xFF) << 16 | (arrayOfByte[3] & 0xFF) << 24) != paramInt)
/*      */       {
/*  333 */         (new StringBuilder("Verification of permissions failed (")).append(String.format("%08X", new Object[] { Integer.valueOf(i) })).append(" != ")
/*  334 */           .append(String.format("%08X", new Object[] { Integer.valueOf(paramInt) })).append(")");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       return;
/*  342 */     } catch (GeneralSecurityException generalSecurityException) {
/*      */       
/*  344 */       d();
/*  345 */       throw new IOException(generalSecurityException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(b paramb) {
/*      */     d d;
/*  360 */     if ((d = paramb.d()) == null)
/*      */     {
/*  362 */       d = new d();
/*      */     }
/*  364 */     int i = c();
/*  365 */     int j = a(i);
/*  366 */     d.a("Standard");
/*  367 */     d.a(i);
/*  368 */     if (i != 4 && i != 5)
/*      */     {
/*      */       
/*  371 */       d.q();
/*      */     }
/*  373 */     d.c(j);
/*  374 */     d.b(this.a);
/*      */     
/*  376 */     String str1 = this.f.b();
/*  377 */     String str2 = this.f.c();
/*  378 */     if (str1 == null)
/*      */     {
/*  380 */       str1 = "";
/*      */     }
/*  382 */     if (str2 == null)
/*      */     {
/*  384 */       str2 = "";
/*      */     }
/*      */ 
/*      */     
/*  388 */     if (str1.isEmpty())
/*      */     {
/*  390 */       str1 = str2;
/*      */     }
/*      */     
/*  393 */     int m = this.f.a().f();
/*      */     
/*  395 */     d.d(m);
/*      */     
/*  397 */     int n = this.a / 8;
/*      */     
/*  399 */     if (j == 6) {
/*      */ 
/*      */       
/*  402 */       str1 = j.b(str1);
/*  403 */       str2 = j.b(str2);
/*  404 */       a(str1, str2, d, m);
/*      */     }
/*      */     else {
/*      */       
/*  408 */       a(str1, str2, d, m, paramb, j, n);
/*      */     } 
/*      */ 
/*      */     
/*  412 */     paramb.a(d);
/*  413 */     paramb.a().b(d.b());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(String paramString1, String paramString2, d paramd, int paramInt) {
/*      */     try {
/*  422 */       SecureRandom secureRandom = new SecureRandom();
/*  423 */       Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
/*      */ 
/*      */       
/*  426 */       this.b = new byte[32];
/*  427 */       secureRandom.nextBytes(this.b);
/*      */ 
/*      */       
/*  430 */       byte[] arrayOfByte3 = b(paramString2.getBytes(a.f));
/*  431 */       byte[] arrayOfByte4 = new byte[8];
/*  432 */       byte[] arrayOfByte5 = new byte[8];
/*  433 */       secureRandom.nextBytes(arrayOfByte4);
/*  434 */       secureRandom.nextBytes(arrayOfByte5);
/*      */       
/*      */       byte[] arrayOfByte6;
/*  437 */       arrayOfByte4 = d(arrayOfByte6 = b(a(arrayOfByte3, arrayOfByte4), arrayOfByte3, (byte[])null), arrayOfByte4, arrayOfByte5);
/*      */ 
/*      */       
/*  440 */       arrayOfByte3 = b(a(arrayOfByte3, arrayOfByte5), arrayOfByte3, (byte[])null);
/*      */       
/*  442 */       cipher.init(1, new SecretKeySpec(arrayOfByte3, "AES"), new IvParameterSpec(new byte[16]));
/*      */       
/*  444 */       arrayOfByte3 = cipher.doFinal(this.b);
/*      */ 
/*      */       
/*  447 */       byte[] arrayOfByte1 = b(paramString1.getBytes(a.f));
/*  448 */       arrayOfByte5 = new byte[8];
/*  449 */       arrayOfByte6 = new byte[8];
/*  450 */       secureRandom.nextBytes(arrayOfByte5);
/*  451 */       secureRandom.nextBytes(arrayOfByte6);
/*      */       
/*      */       byte[] arrayOfByte7;
/*  454 */       arrayOfByte5 = d(arrayOfByte7 = b(d(arrayOfByte1, arrayOfByte5, arrayOfByte4), arrayOfByte1, arrayOfByte4), arrayOfByte5, arrayOfByte6);
/*      */ 
/*      */       
/*  457 */       arrayOfByte1 = b(d(arrayOfByte1, arrayOfByte6, arrayOfByte4), arrayOfByte1, arrayOfByte4);
/*      */       
/*  459 */       cipher.init(1, new SecretKeySpec(arrayOfByte1, "AES"), new IvParameterSpec(new byte[16]));
/*      */       
/*  461 */       arrayOfByte1 = cipher.doFinal(this.b);
/*      */ 
/*      */       
/*  464 */       paramd.b(arrayOfByte4);
/*  465 */       paramd.d(arrayOfByte3);
/*  466 */       paramd.a(arrayOfByte5);
/*  467 */       paramd.c(arrayOfByte1);
/*      */       
/*  469 */       a(paramd, j.e);
/*      */ 
/*      */ 
/*      */       
/*  473 */       (arrayOfByte1 = new byte[16])[0] = (byte)paramInt;
/*  474 */       arrayOfByte1[1] = (byte)(paramInt >>> 8);
/*  475 */       arrayOfByte1[2] = (byte)(paramInt >>> 16);
/*  476 */       arrayOfByte1[3] = (byte)(paramInt >>> 24);
/*  477 */       arrayOfByte1[4] = -1;
/*  478 */       arrayOfByte1[5] = -1;
/*  479 */       arrayOfByte1[6] = -1;
/*  480 */       arrayOfByte1[7] = -1;
/*  481 */       arrayOfByte1[8] = 84;
/*  482 */       arrayOfByte1[9] = 97;
/*  483 */       arrayOfByte1[10] = 100;
/*  484 */       arrayOfByte1[11] = 98;
/*  485 */       for (byte b = 12; b <= 15; b++)
/*      */       {
/*  487 */         arrayOfByte1[b] = (byte)secureRandom.nextInt();
/*      */       }
/*      */       
/*  490 */       cipher.init(1, new SecretKeySpec(this.b, "AES"), new IvParameterSpec(new byte[16]));
/*      */ 
/*      */       
/*  493 */       byte[] arrayOfByte2 = cipher.doFinal(arrayOfByte1);
/*      */       
/*  495 */       paramd.e(arrayOfByte2);
/*      */       return;
/*  497 */     } catch (GeneralSecurityException generalSecurityException) {
/*      */       
/*  499 */       d();
/*  500 */       throw new IOException(generalSecurityException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(String paramString1, String paramString2, d paramd, int paramInt1, b paramb, int paramInt2, int paramInt3) {
/*      */     a a1;
/*  512 */     if ((a1 = paramb.a().e()) == null || a1.b() < 2) {
/*      */       
/*  514 */       MessageDigest messageDigest = j.a();
/*  515 */       BigInteger bigInteger = BigInteger.valueOf(System.currentTimeMillis());
/*  516 */       messageDigest.update(bigInteger.toByteArray());
/*  517 */       messageDigest.update(paramString1.getBytes(a.d));
/*  518 */       messageDigest.update(paramString2.getBytes(a.d));
/*  519 */       messageDigest.update(paramb.a().toString().getBytes(a.d));
/*      */       
/*  521 */       byte[] arrayOfByte = messageDigest.digest(toString().getBytes(a.d));
/*  522 */       s s1 = new s(arrayOfByte);
/*      */ 
/*      */       
/*  525 */       (a1 = new a()).a((b)s1);
/*  526 */       a1.a((b)s1);
/*  527 */       paramb.a().a(a1);
/*      */     } 
/*      */     
/*  530 */     s s = (s)a1.a(0);
/*      */     
/*  532 */     byte[] arrayOfByte1 = b(paramString1
/*  533 */         .getBytes(a.d), paramString2
/*  534 */         .getBytes(a.d), paramInt2, paramInt3);
/*      */     
/*  536 */     byte[] arrayOfByte2 = a(paramString2
/*  537 */         .getBytes(a.d), arrayOfByte1, paramInt1, s
/*  538 */         .c(), paramInt2, paramInt3, true);
/*      */     
/*  540 */     this.b = a(paramString2.getBytes(a.d), arrayOfByte1, (byte[])null, (byte[])null, (byte[])null, paramInt1, s
/*  541 */         .c(), paramInt2, paramInt3, true, false);
/*      */     
/*  543 */     paramd.a(arrayOfByte1);
/*  544 */     paramd.b(arrayOfByte2);
/*      */     
/*  546 */     if (paramInt2 == 4)
/*      */     {
/*  548 */       a(paramd, j.d);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(d paramd, j paramj) {
/*      */     c c;
/*  555 */     (c = new c()).a(paramj);
/*  556 */     c.a(this.a);
/*  557 */     paramd.a(c);
/*  558 */     paramd.a(j.du);
/*  559 */     paramd.b(j.du);
/*  560 */     b(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3, int paramInt1, byte[] paramArrayOfbyte4, int paramInt2, int paramInt3, boolean paramBoolean) {
/*      */     byte[] arrayOfByte;
/*  583 */     if (paramInt2 == 6 || paramInt2 == 5) {
/*      */       
/*  585 */       paramArrayOfbyte1 = b(paramArrayOfbyte1);
/*      */       
/*  587 */       arrayOfByte = new byte[32];
/*  588 */       paramArrayOfbyte4 = new byte[8];
/*  589 */       System.arraycopy(paramArrayOfbyte3, 0, arrayOfByte, 0, 32);
/*  590 */       System.arraycopy(paramArrayOfbyte3, 32, paramArrayOfbyte4, 0, 8);
/*      */ 
/*      */       
/*  593 */       if (paramInt2 == 5) {
/*      */         
/*  595 */         paramArrayOfbyte1 = c(paramArrayOfbyte1, paramArrayOfbyte4, paramArrayOfbyte2);
/*      */       }
/*      */       else {
/*      */         
/*  599 */         paramArrayOfbyte1 = a(paramArrayOfbyte1, paramArrayOfbyte4, paramArrayOfbyte2);
/*      */       } 
/*      */       
/*  602 */       return Arrays.equals(paramArrayOfbyte1, arrayOfByte);
/*      */     } 
/*      */ 
/*      */     
/*  606 */     paramArrayOfbyte1 = a(paramArrayOfbyte1, paramArrayOfbyte3, paramInt2, paramInt3);
/*  607 */     return b(paramArrayOfbyte1, paramArrayOfbyte2, paramArrayOfbyte3, arrayOfByte, paramArrayOfbyte4, paramInt2, paramInt3, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt1, int paramInt2) {
/*  627 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  628 */     paramArrayOfbyte1 = a(paramArrayOfbyte1, paramInt1, paramInt2);
/*      */     
/*  630 */     if (paramInt1 == 2) {
/*      */       
/*  632 */       a(paramArrayOfbyte1, paramArrayOfbyte2, byteArrayOutputStream);
/*      */     }
/*  634 */     else if (paramInt1 == 3 || paramInt1 == 4) {
/*      */       
/*  636 */       byte[] arrayOfByte1 = new byte[paramArrayOfbyte1.length];
/*  637 */       byte[] arrayOfByte2 = new byte[paramArrayOfbyte2.length];
/*  638 */       System.arraycopy(paramArrayOfbyte2, 0, arrayOfByte2, 0, paramArrayOfbyte2.length);
/*      */       
/*  640 */       for (byte b = 19; b >= 0; b--) {
/*      */         
/*  642 */         System.arraycopy(paramArrayOfbyte1, 0, arrayOfByte1, 0, paramArrayOfbyte1.length);
/*  643 */         for (byte b1 = 0; b1 < arrayOfByte1.length; b1++)
/*      */         {
/*  645 */           arrayOfByte1[b1] = (byte)(arrayOfByte1[b1] ^ (byte)b);
/*      */         }
/*  647 */         byteArrayOutputStream.reset();
/*  648 */         a(arrayOfByte1, arrayOfByte2, byteArrayOutputStream);
/*  649 */         arrayOfByte2 = byteArrayOutputStream.toByteArray();
/*      */       } 
/*      */     } 
/*  652 */     return byteArrayOutputStream.toByteArray();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3, byte[] paramArrayOfbyte4, byte[] paramArrayOfbyte5, int paramInt1, byte[] paramArrayOfbyte6, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2) {
/*  679 */     if (paramInt2 == 6 || paramInt2 == 5)
/*      */     {
/*  681 */       return a(paramArrayOfbyte1, paramBoolean2, paramArrayOfbyte2, paramArrayOfbyte3, paramArrayOfbyte4, paramArrayOfbyte5, paramInt2);
/*      */     }
/*      */ 
/*      */     
/*  685 */     return a(paramArrayOfbyte1, paramArrayOfbyte2, paramInt1, paramArrayOfbyte6, paramBoolean1, paramInt3, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt1, byte[] paramArrayOfbyte3, boolean paramBoolean, int paramInt2, int paramInt3) {
/*  695 */     paramArrayOfbyte1 = a(paramArrayOfbyte1);
/*      */     
/*      */     MessageDigest messageDigest;
/*  698 */     (messageDigest = j.a()).update(paramArrayOfbyte1);
/*      */     
/*  700 */     messageDigest.update(paramArrayOfbyte2);
/*      */     
/*  702 */     messageDigest.update((byte)paramInt1);
/*  703 */     messageDigest.update((byte)(paramInt1 >>> 8));
/*  704 */     messageDigest.update((byte)(paramInt1 >>> 16));
/*  705 */     messageDigest.update((byte)(paramInt1 >>> 24));
/*      */     
/*  707 */     messageDigest.update(paramArrayOfbyte3);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  712 */     if (paramInt3 == 4 && !paramBoolean)
/*      */     {
/*  714 */       messageDigest.update(new byte[] { -1, -1, -1, -1 });
/*      */     }
/*  716 */     paramArrayOfbyte1 = messageDigest.digest();
/*      */     
/*  718 */     if (paramInt3 == 3 || paramInt3 == 4)
/*      */     {
/*  720 */       for (byte b = 0; b < 50; b++) {
/*      */         
/*  722 */         messageDigest.update(paramArrayOfbyte1, 0, paramInt2);
/*  723 */         paramArrayOfbyte1 = messageDigest.digest();
/*      */       } 
/*      */     }
/*      */     
/*  727 */     paramArrayOfbyte2 = new byte[paramInt2];
/*  728 */     System.arraycopy(paramArrayOfbyte1, 0, paramArrayOfbyte2, 0, paramInt2);
/*  729 */     return paramArrayOfbyte2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private byte[] a(byte[] paramArrayOfbyte1, boolean paramBoolean, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3, byte[] paramArrayOfbyte4, byte[] paramArrayOfbyte5, int paramInt) {
/*      */     byte[] arrayOfByte;
/*  738 */     if (paramBoolean) {
/*      */       
/*  740 */       byte[] arrayOfByte1 = new byte[8];
/*  741 */       System.arraycopy(paramArrayOfbyte2, 40, arrayOfByte1, 0, 8);
/*      */       
/*  743 */       if (paramInt == 5) {
/*      */         
/*  745 */         paramArrayOfbyte1 = c(paramArrayOfbyte1, arrayOfByte1, paramArrayOfbyte3);
/*      */       }
/*      */       else {
/*      */         
/*  749 */         paramArrayOfbyte1 = a(paramArrayOfbyte1, arrayOfByte1, paramArrayOfbyte3);
/*      */       } 
/*      */       
/*  752 */       arrayOfByte = paramArrayOfbyte4;
/*      */     }
/*      */     else {
/*      */       
/*  756 */       byte[] arrayOfByte1 = new byte[8];
/*  757 */       System.arraycopy(paramArrayOfbyte3, 40, arrayOfByte1, 0, 8);
/*      */       
/*  759 */       if (paramInt == 5) {
/*      */         
/*  761 */         paramArrayOfbyte1 = c(paramArrayOfbyte1, arrayOfByte1, (byte[])null);
/*      */       }
/*      */       else {
/*      */         
/*  765 */         paramArrayOfbyte1 = a(paramArrayOfbyte1, arrayOfByte1, (byte[])null);
/*      */       } 
/*      */       
/*  768 */       arrayOfByte = paramArrayOfbyte5;
/*      */     } 
/*      */     
/*      */     try {
/*      */       Cipher cipher;
/*  773 */       (cipher = Cipher.getInstance("AES/CBC/NoPadding")).init(2, new SecretKeySpec(paramArrayOfbyte1, "AES"), new IvParameterSpec(new byte[16]));
/*  774 */       return cipher.doFinal(arrayOfByte);
/*      */     }
/*  776 */     catch (GeneralSecurityException generalSecurityException) {
/*      */       
/*  778 */       d();
/*  779 */       throw new IOException(generalSecurityException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt1, byte[] paramArrayOfbyte3, int paramInt2, int paramInt3, boolean paramBoolean) {
/*  802 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  803 */     paramArrayOfbyte1 = a(paramArrayOfbyte1, paramArrayOfbyte2, (byte[])null, (byte[])null, (byte[])null, paramInt1, paramArrayOfbyte3, paramInt2, paramInt3, paramBoolean, true);
/*      */ 
/*      */     
/*  806 */     if (paramInt2 == 2) {
/*      */       
/*  808 */       a(paramArrayOfbyte1, d, byteArrayOutputStream);
/*      */     }
/*  810 */     else if (paramInt2 == 3 || paramInt2 == 4) {
/*      */       MessageDigest messageDigest;
/*      */       
/*  813 */       (messageDigest = j.a()).update(d);
/*      */       
/*  815 */       messageDigest.update(paramArrayOfbyte3);
/*  816 */       byteArrayOutputStream.write(messageDigest.digest());
/*      */       
/*  818 */       byte[] arrayOfByte1 = new byte[paramArrayOfbyte1.length];
/*  819 */       for (paramInt1 = 0; paramInt1 < 20; paramInt1++) {
/*      */         
/*  821 */         System.arraycopy(paramArrayOfbyte1, 0, arrayOfByte1, 0, arrayOfByte1.length);
/*  822 */         for (byte b = 0; b < arrayOfByte1.length; b++)
/*      */         {
/*  824 */           arrayOfByte1[b] = (byte)(arrayOfByte1[b] ^ paramInt1);
/*      */         }
/*  826 */         ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
/*  827 */         byteArrayOutputStream.reset();
/*  828 */         a(arrayOfByte1, byteArrayInputStream, byteArrayOutputStream);
/*      */       } 
/*      */       
/*  831 */       byte[] arrayOfByte2 = new byte[32];
/*  832 */       System.arraycopy(byteArrayOutputStream.toByteArray(), 0, arrayOfByte2, 0, 16);
/*  833 */       System.arraycopy(d, 0, arrayOfByte2, 16, 16);
/*  834 */       byteArrayOutputStream.reset();
/*  835 */       byteArrayOutputStream.write(arrayOfByte2);
/*      */     } 
/*  837 */     return byteArrayOutputStream.toByteArray();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private byte[] b(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt1, int paramInt2) {
/*  855 */     if (paramInt1 == 2 && paramInt2 != 5)
/*      */     {
/*  857 */       throw new IOException("Expected length=5 actual=" + paramInt2);
/*      */     }
/*      */     
/*  860 */     paramArrayOfbyte1 = a(paramArrayOfbyte1, paramInt1, paramInt2);
/*  861 */     paramArrayOfbyte2 = a(paramArrayOfbyte2);
/*      */     
/*  863 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  864 */     a(paramArrayOfbyte1, new ByteArrayInputStream(paramArrayOfbyte2), byteArrayOutputStream);
/*      */     
/*  866 */     if (paramInt1 == 3 || paramInt1 == 4) {
/*      */       
/*  868 */       paramArrayOfbyte2 = new byte[paramArrayOfbyte1.length];
/*  869 */       for (paramInt1 = 1; paramInt1 < 20; paramInt1++) {
/*      */         
/*  871 */         System.arraycopy(paramArrayOfbyte1, 0, paramArrayOfbyte2, 0, paramArrayOfbyte1.length);
/*  872 */         for (byte b = 0; b < paramArrayOfbyte2.length; b++)
/*      */         {
/*  874 */           paramArrayOfbyte2[b] = (byte)(paramArrayOfbyte2[b] ^ (byte)paramInt1);
/*      */         }
/*  876 */         ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
/*  877 */         byteArrayOutputStream.reset();
/*  878 */         a(paramArrayOfbyte2, byteArrayInputStream, byteArrayOutputStream);
/*      */       } 
/*      */     } 
/*      */     
/*  882 */     return byteArrayOutputStream.toByteArray();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private byte[] a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*      */     MessageDigest messageDigest;
/*  889 */     paramArrayOfbyte = (messageDigest = j.a()).digest(a(paramArrayOfbyte));
/*  890 */     if (paramInt1 == 3 || paramInt1 == 4)
/*      */     {
/*  892 */       for (paramInt1 = 0; paramInt1 < 50; paramInt1++) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  897 */         messageDigest.update(paramArrayOfbyte, 0, paramInt2);
/*  898 */         paramArrayOfbyte = messageDigest.digest();
/*      */       } 
/*      */     }
/*  901 */     byte[] arrayOfByte = new byte[paramInt2];
/*  902 */     System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 0, paramInt2);
/*  903 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static byte[] a(byte[] paramArrayOfbyte) {
/*  916 */     byte[] arrayOfByte = new byte[d.length];
/*  917 */     int i = Math.min(paramArrayOfbyte.length, arrayOfByte.length);
/*  918 */     System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 0, i);
/*  919 */     System.arraycopy(d, 0, arrayOfByte, i, d.length - i);
/*      */     
/*  921 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean b(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3, int paramInt1, byte[] paramArrayOfbyte4, int paramInt2, int paramInt3, boolean paramBoolean) {
/*  944 */     switch (paramInt2) {
/*      */       
/*      */       case 2:
/*      */       case 3:
/*      */       case 4:
/*  949 */         return c(paramArrayOfbyte1, paramArrayOfbyte2, paramArrayOfbyte3, paramInt1, paramArrayOfbyte4, paramInt2, paramInt3, paramBoolean);
/*      */       
/*      */       case 5:
/*      */       case 6:
/*  953 */         return a(paramArrayOfbyte1, paramArrayOfbyte2, paramInt2);
/*      */     } 
/*  955 */     throw new IOException("Unknown Encryption Revision " + paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean c(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3, int paramInt1, byte[] paramArrayOfbyte4, int paramInt2, int paramInt3, boolean paramBoolean) {
/*  963 */     paramArrayOfbyte1 = a(paramArrayOfbyte1, paramArrayOfbyte3, paramInt1, paramArrayOfbyte4, paramInt2, paramInt3, paramBoolean);
/*      */     
/*  965 */     if (paramInt2 == 2)
/*      */     {
/*  967 */       return Arrays.equals(paramArrayOfbyte2, paramArrayOfbyte1);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  972 */     return Arrays.equals(Arrays.copyOf(paramArrayOfbyte2, 16), Arrays.copyOf(paramArrayOfbyte1, 16));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt) {
/*  978 */     paramArrayOfbyte1 = b(paramArrayOfbyte1);
/*  979 */     byte[] arrayOfByte1 = new byte[32];
/*  980 */     byte[] arrayOfByte2 = new byte[8];
/*  981 */     System.arraycopy(paramArrayOfbyte2, 0, arrayOfByte1, 0, 32);
/*  982 */     System.arraycopy(paramArrayOfbyte2, 32, arrayOfByte2, 0, 8);
/*      */ 
/*      */     
/*  985 */     if (paramInt == 5) {
/*      */       
/*  987 */       paramArrayOfbyte1 = c(paramArrayOfbyte1, arrayOfByte2, (byte[])null);
/*      */     }
/*      */     else {
/*      */       
/*  991 */       paramArrayOfbyte1 = a(paramArrayOfbyte1, arrayOfByte2, (byte[])null);
/*      */     } 
/*      */     
/*  994 */     return Arrays.equals(paramArrayOfbyte1, arrayOfByte1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3) {
/*      */     byte[] arrayOfByte;
/* 1057 */     if (paramArrayOfbyte3 == null) {
/*      */       
/* 1059 */       arrayOfByte = new byte[0];
/*      */     } else {
/* 1061 */       if (paramArrayOfbyte3.length < 48)
/*      */       {
/* 1063 */         throw new IOException("Bad U length");
/*      */       }
/* 1065 */       if (paramArrayOfbyte3.length > 48) {
/*      */ 
/*      */         
/* 1068 */         arrayOfByte = new byte[48];
/* 1069 */         System.arraycopy(paramArrayOfbyte3, 0, arrayOfByte, 0, 48);
/*      */       }
/*      */       else {
/*      */         
/* 1073 */         arrayOfByte = paramArrayOfbyte3;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1078 */     return b(paramArrayOfbyte2 = d(paramArrayOfbyte1 = b(paramArrayOfbyte1), paramArrayOfbyte2, arrayOfByte), paramArrayOfbyte1, arrayOfByte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static byte[] b(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3) {
/*      */     // Byte code:
/*      */     //   0: ldc 'SHA-256'
/*      */     //   2: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/MessageDigest;
/*      */     //   5: dup
/*      */     //   6: astore_3
/*      */     //   7: aload_0
/*      */     //   8: invokevirtual digest : ([B)[B
/*      */     //   11: astore_0
/*      */     //   12: aconst_null
/*      */     //   13: astore #4
/*      */     //   15: iconst_0
/*      */     //   16: istore #5
/*      */     //   18: iload #5
/*      */     //   20: bipush #64
/*      */     //   22: if_icmplt -> 44
/*      */     //   25: aload #4
/*      */     //   27: dup
/*      */     //   28: arraylength
/*      */     //   29: iconst_1
/*      */     //   30: isub
/*      */     //   31: baload
/*      */     //   32: sipush #255
/*      */     //   35: iand
/*      */     //   36: iload #5
/*      */     //   38: bipush #32
/*      */     //   40: isub
/*      */     //   41: if_icmple -> 305
/*      */     //   44: aload_2
/*      */     //   45: ifnull -> 72
/*      */     //   48: aload_2
/*      */     //   49: arraylength
/*      */     //   50: bipush #48
/*      */     //   52: if_icmplt -> 72
/*      */     //   55: bipush #64
/*      */     //   57: aload_1
/*      */     //   58: arraylength
/*      */     //   59: aload_0
/*      */     //   60: arraylength
/*      */     //   61: iadd
/*      */     //   62: bipush #48
/*      */     //   64: iadd
/*      */     //   65: imul
/*      */     //   66: newarray byte
/*      */     //   68: astore_3
/*      */     //   69: goto -> 83
/*      */     //   72: bipush #64
/*      */     //   74: aload_1
/*      */     //   75: arraylength
/*      */     //   76: aload_0
/*      */     //   77: arraylength
/*      */     //   78: iadd
/*      */     //   79: imul
/*      */     //   80: newarray byte
/*      */     //   82: astore_3
/*      */     //   83: iconst_0
/*      */     //   84: istore #4
/*      */     //   86: iconst_0
/*      */     //   87: istore #6
/*      */     //   89: iload #6
/*      */     //   91: bipush #64
/*      */     //   93: if_icmpge -> 160
/*      */     //   96: aload_1
/*      */     //   97: iconst_0
/*      */     //   98: aload_3
/*      */     //   99: iload #4
/*      */     //   101: aload_1
/*      */     //   102: arraylength
/*      */     //   103: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
/*      */     //   106: iload #4
/*      */     //   108: aload_1
/*      */     //   109: arraylength
/*      */     //   110: iadd
/*      */     //   111: istore #4
/*      */     //   113: aload_0
/*      */     //   114: iconst_0
/*      */     //   115: aload_3
/*      */     //   116: iload #4
/*      */     //   118: aload_0
/*      */     //   119: arraylength
/*      */     //   120: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
/*      */     //   123: iload #4
/*      */     //   125: aload_0
/*      */     //   126: arraylength
/*      */     //   127: iadd
/*      */     //   128: istore #4
/*      */     //   130: aload_2
/*      */     //   131: ifnull -> 154
/*      */     //   134: aload_2
/*      */     //   135: arraylength
/*      */     //   136: bipush #48
/*      */     //   138: if_icmplt -> 154
/*      */     //   141: aload_2
/*      */     //   142: iconst_0
/*      */     //   143: aload_3
/*      */     //   144: iload #4
/*      */     //   146: bipush #48
/*      */     //   148: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
/*      */     //   151: iinc #4, 48
/*      */     //   154: iinc #6, 1
/*      */     //   157: goto -> 89
/*      */     //   160: bipush #16
/*      */     //   162: newarray byte
/*      */     //   164: astore #6
/*      */     //   166: bipush #16
/*      */     //   168: newarray byte
/*      */     //   170: astore #4
/*      */     //   172: aload_0
/*      */     //   173: iconst_0
/*      */     //   174: aload #6
/*      */     //   176: iconst_0
/*      */     //   177: bipush #16
/*      */     //   179: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
/*      */     //   182: aload_0
/*      */     //   183: bipush #16
/*      */     //   185: aload #4
/*      */     //   187: iconst_0
/*      */     //   188: bipush #16
/*      */     //   190: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
/*      */     //   193: ldc 'AES/CBC/NoPadding'
/*      */     //   195: invokestatic getInstance : (Ljava/lang/String;)Ljavax/crypto/Cipher;
/*      */     //   198: astore_0
/*      */     //   199: new javax/crypto/spec/SecretKeySpec
/*      */     //   202: dup
/*      */     //   203: aload #6
/*      */     //   205: ldc 'AES'
/*      */     //   207: invokespecial <init> : ([BLjava/lang/String;)V
/*      */     //   210: astore #6
/*      */     //   212: new javax/crypto/spec/IvParameterSpec
/*      */     //   215: dup
/*      */     //   216: aload #4
/*      */     //   218: invokespecial <init> : ([B)V
/*      */     //   221: astore #4
/*      */     //   223: aload_0
/*      */     //   224: iconst_1
/*      */     //   225: aload #6
/*      */     //   227: aload #4
/*      */     //   229: invokevirtual init : (ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
/*      */     //   232: aload_0
/*      */     //   233: aload_3
/*      */     //   234: invokevirtual doFinal : ([B)[B
/*      */     //   237: astore #4
/*      */     //   239: bipush #16
/*      */     //   241: newarray byte
/*      */     //   243: astore_0
/*      */     //   244: aload #4
/*      */     //   246: iconst_0
/*      */     //   247: aload_0
/*      */     //   248: iconst_0
/*      */     //   249: bipush #16
/*      */     //   251: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
/*      */     //   254: new java/math/BigInteger
/*      */     //   257: dup
/*      */     //   258: iconst_1
/*      */     //   259: aload_0
/*      */     //   260: invokespecial <init> : (I[B)V
/*      */     //   263: dup
/*      */     //   264: astore_0
/*      */     //   265: new java/math/BigInteger
/*      */     //   268: dup
/*      */     //   269: ldc '3'
/*      */     //   271: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   274: invokevirtual mod : (Ljava/math/BigInteger;)Ljava/math/BigInteger;
/*      */     //   277: astore_0
/*      */     //   278: getstatic org/a/c/h/c/p.e : [Ljava/lang/String;
/*      */     //   281: aload_0
/*      */     //   282: invokevirtual intValue : ()I
/*      */     //   285: aaload
/*      */     //   286: dup
/*      */     //   287: astore_0
/*      */     //   288: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/MessageDigest;
/*      */     //   291: dup
/*      */     //   292: astore_3
/*      */     //   293: aload #4
/*      */     //   295: invokevirtual digest : ([B)[B
/*      */     //   298: astore_0
/*      */     //   299: iinc #5, 1
/*      */     //   302: goto -> 18
/*      */     //   305: aload_0
/*      */     //   306: arraylength
/*      */     //   307: bipush #32
/*      */     //   309: if_icmple -> 331
/*      */     //   312: bipush #32
/*      */     //   314: newarray byte
/*      */     //   316: astore #5
/*      */     //   318: aload_0
/*      */     //   319: iconst_0
/*      */     //   320: aload #5
/*      */     //   322: iconst_0
/*      */     //   323: bipush #32
/*      */     //   325: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
/*      */     //   328: aload #5
/*      */     //   330: areturn
/*      */     //   331: aload_0
/*      */     //   332: areturn
/*      */     //   333: astore_3
/*      */     //   334: invokestatic d : ()V
/*      */     //   337: new java/io/IOException
/*      */     //   340: dup
/*      */     //   341: aload_3
/*      */     //   342: invokespecial <init> : (Ljava/lang/Throwable;)V
/*      */     //   345: athrow
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1087	-> 0
/*      */     //   #1088	-> 6
/*      */     //   #1090	-> 12
/*      */     //   #1091	-> 15
/*      */     //   #1094	-> 44
/*      */     //   #1096	-> 55
/*      */     //   #1100	-> 72
/*      */     //   #1103	-> 83
/*      */     //   #1104	-> 86
/*      */     //   #1106	-> 96
/*      */     //   #1107	-> 106
/*      */     //   #1108	-> 113
/*      */     //   #1109	-> 123
/*      */     //   #1110	-> 130
/*      */     //   #1112	-> 141
/*      */     //   #1113	-> 151
/*      */     //   #1104	-> 154
/*      */     //   #1117	-> 160
/*      */     //   #1118	-> 166
/*      */     //   #1119	-> 172
/*      */     //   #1120	-> 182
/*      */     //   #1122	-> 193
/*      */     //   #1123	-> 199
/*      */     //   #1124	-> 212
/*      */     //   #1125	-> 223
/*      */     //   #1126	-> 232
/*      */     //   #1128	-> 239
/*      */     //   #1129	-> 244
/*      */     //   #1130	-> 254
/*      */     //   #1131	-> 264
/*      */     //   #1132	-> 278
/*      */     //   #1134	-> 287
/*      */     //   #1135	-> 292
/*      */     //   #1091	-> 299
/*      */     //   #1138	-> 305
/*      */     //   #1140	-> 312
/*      */     //   #1141	-> 318
/*      */     //   #1142	-> 328
/*      */     //   #1146	-> 331
/*      */     //   #1149	-> 333
/*      */     //   #1151	-> 334
/*      */     //   #1152	-> 337
/*      */     // Exception table:
/*      */     //   from	to	target	type
/*      */     //   0	330	333	java/security/GeneralSecurityException
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static byte[] c(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3) {
/*      */     try {
/*      */       MessageDigest messageDigest;
/* 1162 */       (messageDigest = MessageDigest.getInstance("SHA-256")).update(paramArrayOfbyte1);
/* 1163 */       messageDigest.update(paramArrayOfbyte2);
/* 1164 */       return (paramArrayOfbyte3 == null) ? messageDigest.digest() : messageDigest.digest(paramArrayOfbyte3);
/*      */     }
/* 1166 */     catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*      */       
/* 1168 */       throw new IOException(noSuchAlgorithmException);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/* 1174 */     byte[] arrayOfByte = new byte[paramArrayOfbyte1.length + 8];
/* 1175 */     System.arraycopy(paramArrayOfbyte1, 0, arrayOfByte, 0, paramArrayOfbyte1.length);
/* 1176 */     System.arraycopy(paramArrayOfbyte2, 0, arrayOfByte, paramArrayOfbyte1.length, 8);
/* 1177 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */   
/*      */   private static byte[] d(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3) {
/* 1182 */     byte[] arrayOfByte = new byte[paramArrayOfbyte1.length + paramArrayOfbyte2.length + paramArrayOfbyte3.length];
/* 1183 */     System.arraycopy(paramArrayOfbyte1, 0, arrayOfByte, 0, paramArrayOfbyte1.length);
/* 1184 */     System.arraycopy(paramArrayOfbyte2, 0, arrayOfByte, paramArrayOfbyte1.length, paramArrayOfbyte2.length);
/* 1185 */     System.arraycopy(paramArrayOfbyte3, 0, arrayOfByte, paramArrayOfbyte1.length + paramArrayOfbyte2.length, paramArrayOfbyte3.length);
/* 1186 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */   
/*      */   private static byte[] b(byte[] paramArrayOfbyte) {
/* 1191 */     if (paramArrayOfbyte.length <= 127)
/*      */     {
/* 1193 */       return paramArrayOfbyte;
/*      */     }
/* 1195 */     byte[] arrayOfByte = new byte[127];
/* 1196 */     System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 0, 127);
/* 1197 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static void d() {
/*      */     try {
/* 1204 */       Cipher.getMaxAllowedKeyLength("AES");
/*      */ 
/*      */ 
/*      */       
/*      */       return;
/* 1209 */     } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*      */       return;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean a() {
/* 1220 */     return (this.f != null);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\c\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */