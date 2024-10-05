/*     */ package org.a.c.h.c;
/*     */ 
/*     */ import com.a.a.a.am;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.security.GeneralSecurityException;
/*     */ import java.security.InvalidAlgorithmParameterException;
/*     */ import java.security.InvalidKeyException;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.security.SecureRandom;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.IdentityHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.crypto.BadPaddingException;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.CipherInputStream;
/*     */ import javax.crypto.IllegalBlockSizeException;
/*     */ import javax.crypto.NoSuchPaddingException;
/*     */ import javax.crypto.spec.IvParameterSpec;
/*     */ import javax.crypto.spec.SecretKeySpec;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.p;
/*     */ import org.a.c.b.s;
/*     */ import org.a.c.h.b;
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
/*     */ 
/*     */ 
/*     */ public abstract class k
/*     */ {
/*  68 */   private static final a c = c.a(k.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  73 */   private static final byte[] d = new byte[] { 115, 65, 108, 84 };
/*     */ 
/*     */   
/*  76 */   protected int a = 40;
/*     */ 
/*     */   
/*     */   protected byte[] b;
/*     */ 
/*     */   
/*  82 */   private final i e = new i();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean f;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  93 */   private final Set<b> g = Collections.newSetFromMap(new IdentityHashMap<b, Boolean>());
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean h;
/*     */ 
/*     */ 
/*     */   
/* 101 */   private j i = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void a(boolean paramBoolean) {
/* 120 */     this.f = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void a(j paramj) {
/* 130 */     this.k = paramj;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void b(j paramj) {
/* 140 */     this.j = paramj;
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
/*     */   public abstract void a(b paramb);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void a(d paramd, a parama, a parama1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(long paramLong1, long paramLong2, InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean) {
/* 180 */     if (this.h && this.b.length == 32) {
/*     */       
/* 182 */       a(paramInputStream, paramOutputStream, paramBoolean);
/*     */     }
/*     */     else {
/*     */       
/* 186 */       byte[] arrayOfByte = a(paramLong1, paramLong2);
/*     */       
/* 188 */       if (this.h) {
/*     */         
/* 190 */         a(arrayOfByte, paramInputStream, paramOutputStream, paramBoolean);
/*     */       }
/*     */       else {
/*     */         
/* 194 */         a(arrayOfByte, paramInputStream, paramOutputStream);
/*     */       } 
/*     */     } 
/* 197 */     paramOutputStream.flush();
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
/*     */   private byte[] a(long paramLong1, long paramLong2) {
/* 209 */     byte[] arrayOfByte3 = new byte[this.b.length + 5];
/* 210 */     System.arraycopy(this.b, 0, arrayOfByte3, 0, this.b.length);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 215 */     arrayOfByte3[arrayOfByte3.length - 5] = (byte)(int)(paramLong1 & 0xFFL);
/* 216 */     arrayOfByte3[arrayOfByte3.length - 4] = (byte)(int)(paramLong1 >> 8L & 0xFFL);
/* 217 */     arrayOfByte3[arrayOfByte3.length - 3] = (byte)(int)(paramLong1 >> 16L & 0xFFL);
/* 218 */     arrayOfByte3[arrayOfByte3.length - 2] = (byte)(int)(paramLong2 & 0xFFL);
/* 219 */     arrayOfByte3[arrayOfByte3.length - 1] = (byte)(int)(paramLong2 >> 8L & 0xFFL);
/*     */     
/*     */     MessageDigest messageDigest;
/* 222 */     (messageDigest = j.a()).update(arrayOfByte3);
/* 223 */     if (this.h)
/*     */     {
/* 225 */       messageDigest.update(d);
/*     */     }
/* 227 */     byte[] arrayOfByte1 = messageDigest.digest();
/*     */     
/*     */     int m;
/* 230 */     byte[] arrayOfByte2 = new byte[m = Math.min(arrayOfByte3.length, 16)];
/* 231 */     System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, m);
/* 232 */     return arrayOfByte2;
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
/*     */   protected final void a(byte[] paramArrayOfbyte, InputStream paramInputStream, OutputStream paramOutputStream) {
/* 247 */     this.e.a(paramArrayOfbyte);
/* 248 */     this.e.a(paramInputStream, paramOutputStream);
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
/*     */   protected final void a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, OutputStream paramOutputStream) {
/* 262 */     this.e.a(paramArrayOfbyte1);
/* 263 */     this.e.a(paramArrayOfbyte2, paramOutputStream);
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
/*     */   private void a(byte[] paramArrayOfbyte, InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean) {
/* 280 */     byte[] arrayOfByte = new byte[16];
/*     */     
/* 282 */     if (!a(paramBoolean, arrayOfByte, paramInputStream, paramOutputStream)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/*     */       Cipher cipher;
/*     */ 
/*     */       
/*     */       try {
/* 292 */         cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
/*     */       }
/* 294 */       catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*     */ 
/*     */         
/* 297 */         throw new RuntimeException(noSuchAlgorithmException);
/*     */       } 
/*     */       
/* 300 */       SecretKeySpec secretKeySpec = new SecretKeySpec((byte[])noSuchAlgorithmException, "AES");
/* 301 */       IvParameterSpec ivParameterSpec = new IvParameterSpec(arrayOfByte);
/* 302 */       cipher.init(paramBoolean ? 2 : 1, secretKeySpec, ivParameterSpec);
/* 303 */       byte[] arrayOfByte1 = new byte[256];
/*     */       int m;
/* 305 */       while ((m = paramInputStream.read(arrayOfByte1)) != -1) {
/*     */         byte[] arrayOfByte2;
/*     */         
/* 308 */         if ((arrayOfByte2 = cipher.update(arrayOfByte1, 0, m)) != null)
/*     */         {
/* 310 */           paramOutputStream.write(arrayOfByte2);
/*     */         }
/*     */       } 
/* 313 */       paramOutputStream.write(cipher.doFinal());
/*     */       return;
/* 315 */     } catch (InvalidKeyException invalidKeyException) {
/*     */       
/* 317 */       throw new IOException(invalidKeyException);
/*     */     }
/* 319 */     catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
/*     */       
/* 321 */       throw new IOException(invalidAlgorithmParameterException);
/*     */     }
/* 323 */     catch (NoSuchPaddingException noSuchPaddingException) {
/*     */       
/* 325 */       throw new IOException(noSuchPaddingException);
/*     */     }
/* 327 */     catch (IllegalBlockSizeException illegalBlockSizeException) {
/*     */       
/* 329 */       throw new IOException(illegalBlockSizeException);
/*     */     }
/* 331 */     catch (BadPaddingException badPaddingException) {
/*     */       
/* 333 */       throw new IOException(badPaddingException);
/*     */     } 
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
/*     */   private void a(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean) {
/*     */     Cipher cipher;
/* 348 */     byte[] arrayOfByte = new byte[16];
/*     */     
/* 350 */     if (!a(paramBoolean, arrayOfByte, paramInputStream, paramOutputStream)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 358 */       cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
/* 359 */       SecretKeySpec secretKeySpec = new SecretKeySpec(this.b, "AES");
/* 360 */       IvParameterSpec ivParameterSpec = new IvParameterSpec(arrayOfByte);
/* 361 */       cipher.init(paramBoolean ? 2 : 1, secretKeySpec, ivParameterSpec);
/*     */     }
/* 363 */     catch (GeneralSecurityException generalSecurityException) {
/*     */       
/* 365 */       throw new IOException(generalSecurityException);
/*     */     } 
/*     */     
/* 368 */     CipherInputStream cipherInputStream = new CipherInputStream(paramInputStream, cipher);
/*     */     
/*     */     try {
/* 371 */       am.a(cipherInputStream, paramOutputStream);
/*     */       return;
/* 373 */     } catch (IOException iOException) {
/*     */ 
/*     */ 
/*     */       
/* 377 */       if (!((arrayOfByte = null).getCause() instanceof GeneralSecurityException))
/*     */       {
/* 379 */         throw arrayOfByte;
/*     */       }
/*     */ 
/*     */       
/*     */       return;
/*     */     } finally {
/* 385 */       cipherInputStream.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean a(boolean paramBoolean, byte[] paramArrayOfbyte, InputStream paramInputStream, OutputStream paramOutputStream) {
/* 391 */     if (paramBoolean) {
/*     */       int m;
/*     */ 
/*     */       
/* 395 */       if ((m = paramInputStream.read(paramArrayOfbyte)) == -1)
/*     */       {
/* 397 */         return false;
/*     */       }
/* 399 */       if (m != 16)
/*     */       {
/* 401 */         throw new IOException("AES initialization vector not fully read: only " + m + " bytes read instead of 16");
/*     */       }
/*     */     } else {
/*     */       SecureRandom secureRandom;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 410 */       (secureRandom = new SecureRandom()).nextBytes(paramArrayOfbyte);
/* 411 */       paramOutputStream.write(paramArrayOfbyte);
/*     */     } 
/* 413 */     return true;
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
/*     */   public final void a(b paramb, long paramLong1, long paramLong2) {
/* 427 */     if (!(paramb instanceof s) && !(paramb instanceof d) && !(paramb instanceof a)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 432 */     if (paramb instanceof s) {
/*     */       
/* 434 */       if (this.g.contains(paramb)) {
/*     */         return;
/*     */       }
/*     */       
/* 438 */       this.g.add(paramb);
/* 439 */       a((s)paramb, paramLong1, paramLong2); return;
/*     */     } 
/* 441 */     if (paramb instanceof p) {
/*     */       
/* 443 */       if (this.g.contains(paramb)) {
/*     */         return;
/*     */       }
/*     */       
/* 447 */       this.g.add(paramb);
/* 448 */       a((p)paramb, paramLong1, paramLong2); return;
/*     */     } 
/* 450 */     if (paramb instanceof d) {
/*     */       
/* 452 */       a((d)paramb, paramLong1, paramLong2); return;
/*     */     } 
/* 454 */     if (paramb instanceof a)
/*     */     {
/* 456 */       a((a)paramb, paramLong1, paramLong2);
/*     */     }
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
/*     */   public final void a(p paramp, long paramLong1, long paramLong2) {
/* 472 */     if (j.bB.equals(this.j)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 477 */     j j1 = paramp.b(j.dN);
/* 478 */     if (!this.f && j.cj.equals(j1)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 483 */     if (j.ef.equals(j1)) {
/*     */       return;
/*     */     }
/*     */     
/* 487 */     if (j.cj.equals(j1)) {
/*     */ 
/*     */       
/* 490 */       InputStream inputStream = paramp.j();
/* 491 */       byte[] arrayOfByte1 = new byte[10];
/* 492 */       inputStream.read(arrayOfByte1);
/* 493 */       inputStream.close();
/* 494 */       if (Arrays.equals(arrayOfByte1, "<?xpacket ".getBytes(a.d))) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 501 */     a((d)paramp, paramLong1, paramLong2);
/* 502 */     byte[] arrayOfByte = am.a(paramp.j());
/* 503 */     ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
/* 504 */     OutputStream outputStream = paramp.m();
/*     */     
/*     */     try {
/* 507 */       a(paramLong1, paramLong2, byteArrayInputStream, outputStream, true);
/*     */       
/*     */       return;
/*     */     } finally {
/* 511 */       outputStream.close();
/*     */     } 
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
/*     */   public final void a(p paramp, long paramLong, int paramInt) {
/* 528 */     byte[] arrayOfByte = am.a(paramp.j());
/* 529 */     ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
/* 530 */     OutputStream outputStream = paramp.m();
/*     */     
/*     */     try {
/* 533 */       a(paramLong, paramInt, byteArrayInputStream, outputStream, false);
/*     */       
/*     */       return;
/*     */     } finally {
/* 537 */       outputStream.close();
/*     */     } 
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
/*     */   private void a(d paramd, long paramLong1, long paramLong2) {
/* 552 */     if (paramd.n(j.Q) != null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 557 */     b b = paramd.a(j.dN);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 562 */     boolean bool = (j.dq.equals(b) || j.aH.equals(b) || (paramd.a(j.af) instanceof s && paramd.a(j.G) instanceof a)) ? true : false;
/* 563 */     for (Map.Entry entry : paramd.e()) {
/*     */       
/* 565 */       if (!bool || !j.af.equals(entry.getKey())) {
/*     */         b b1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 572 */         if (b1 = (b)entry.getValue() instanceof s || b1 instanceof a || b1 instanceof d)
/*     */         {
/* 574 */           a(b1, paramLong1, paramLong2);
/*     */         }
/*     */       } 
/*     */     } 
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
/*     */   private void a(s params, long paramLong1, long paramLong2) {
/* 591 */     if (j.bB.equals(this.k)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 596 */     ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(params.c());
/* 597 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */     
/*     */     try {
/* 600 */       a(paramLong1, paramLong2, byteArrayInputStream, byteArrayOutputStream, true);
/* 601 */       params.a(byteArrayOutputStream.toByteArray());
/*     */       return;
/* 603 */     } catch (IOException iOException) {
/*     */       
/* 605 */       (new StringBuilder("Failed to decrypt COSString of length ")).append((params.c()).length).append(" in object ").append(paramLong1).append(": ")
/* 606 */         .append(iOException.getMessage());
/*     */       return;
/*     */     } 
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
/*     */   public final void a(s params, long paramLong, int paramInt) {
/* 621 */     ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(params.c());
/* 622 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 623 */     a(paramLong, paramInt, byteArrayInputStream, byteArrayOutputStream, false);
/* 624 */     params.a(byteArrayOutputStream.toByteArray());
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
/*     */   private void a(a parama, long paramLong1, long paramLong2) {
/* 638 */     for (byte b = 0; b < parama.b(); b++)
/*     */     {
/* 640 */       a(parama.b(b), paramLong1, paramLong2);
/*     */     }
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
/*     */   public final void a(j paramj) {
/* 670 */     this.i = paramj;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final j b() {
/* 681 */     return this.i;
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
/*     */   public final void b(boolean paramBoolean) {
/* 702 */     this.h = paramBoolean;
/*     */   }
/*     */   
/*     */   public abstract boolean a();
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\c\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */