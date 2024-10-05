/*     */ package org.a.c.h.c;
/*     */ 
/*     */ import com.a.a.a.am;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.math.BigInteger;
/*     */ import java.security.AlgorithmParameterGenerator;
/*     */ import java.security.AlgorithmParameters;
/*     */ import java.security.GeneralSecurityException;
/*     */ import java.security.KeyStoreException;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.security.PrivateKey;
/*     */ import java.security.SecureRandom;
/*     */ import java.security.cert.CertificateEncodingException;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.KeyGenerator;
/*     */ import javax.crypto.NoSuchPaddingException;
/*     */ import javax.crypto.SecretKey;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.s;
/*     */ import org.a.c.h.b;
/*     */ import org.bouncycastle.asn1.ASN1Encodable;
/*     */ import org.bouncycastle.asn1.ASN1InputStream;
/*     */ import org.bouncycastle.asn1.ASN1ObjectIdentifier;
/*     */ import org.bouncycastle.asn1.ASN1OctetString;
/*     */ import org.bouncycastle.asn1.ASN1Primitive;
/*     */ import org.bouncycastle.asn1.ASN1Set;
/*     */ import org.bouncycastle.asn1.DEROctetString;
/*     */ import org.bouncycastle.asn1.DEROutputStream;
/*     */ import org.bouncycastle.asn1.DERSet;
/*     */ import org.bouncycastle.asn1.cms.ContentInfo;
/*     */ import org.bouncycastle.asn1.cms.EncryptedContentInfo;
/*     */ import org.bouncycastle.asn1.cms.EnvelopedData;
/*     */ import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
/*     */ import org.bouncycastle.asn1.cms.KeyTransRecipientInfo;
/*     */ import org.bouncycastle.asn1.cms.RecipientIdentifier;
/*     */ import org.bouncycastle.asn1.cms.RecipientInfo;
/*     */ import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
/*     */ import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
/*     */ import org.bouncycastle.asn1.x509.TBSCertificate;
/*     */ import org.bouncycastle.cert.X509CertificateHolder;
/*     */ import org.bouncycastle.cms.CMSEnvelopedData;
/*     */ import org.bouncycastle.cms.CMSException;
/*     */ import org.bouncycastle.cms.KeyTransRecipientId;
/*     */ import org.bouncycastle.cms.Recipient;
/*     */ import org.bouncycastle.cms.RecipientId;
/*     */ import org.bouncycastle.cms.RecipientInformation;
/*     */ import org.bouncycastle.cms.jcajce.JceKeyTransEnvelopedRecipient;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class h
/*     */   extends k
/*     */ {
/*  86 */   private g c = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(d paramd, a parama, a parama1) {
/* 125 */     if (!(parama1 instanceof f))
/*     */     {
/* 127 */       throw new IOException("Provided decryption material is not compatible with the document");
/*     */     }
/*     */ 
/*     */     
/* 131 */     a(paramd.l());
/* 132 */     if (paramd.d() != 0)
/*     */     {
/* 134 */       this.a = paramd.d();
/*     */     }
/*     */     
/* 137 */     f f = (f)parama1;
/*     */     
/*     */     try {
/*     */       byte[] arrayOfByte1, arrayOfByte5;
/* 141 */       boolean bool = false;
/*     */       
/* 143 */       X509Certificate x509Certificate = f.a();
/* 144 */       X509CertificateHolder x509CertificateHolder = null;
/* 145 */       if (x509Certificate != null)
/*     */       {
/* 147 */         x509CertificateHolder = new X509CertificateHolder(x509Certificate.getEncoded());
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 152 */       PrivateKey privateKey = null;
/*     */       
/*     */       a a1;
/*     */       
/* 156 */       if ((a1 = (a)paramd.b().n(j.dc)) == null) {
/*     */         c c;
/*     */         
/* 159 */         a1 = (a)(c = paramd.n()).a().n(j.dc);
/*     */       } 
/* 161 */       byte[][] arrayOfByte2 = new byte[a1.b()][];
/*     */ 
/*     */       
/* 164 */       int i = 0;
/* 165 */       StringBuilder stringBuilder = new StringBuilder();
/* 166 */       for (byte b1 = 0; b1 < a1.b(); b1++) {
/*     */         s s;
/*     */         
/* 169 */         byte[] arrayOfByte = (s = (s)a1.a(b1)).c();
/*     */         
/*     */         CMSEnvelopedData cMSEnvelopedData;
/* 172 */         Collection collection = (cMSEnvelopedData = new CMSEnvelopedData(arrayOfByte)).getRecipientInfos().getRecipients();
/* 173 */         byte b = 0;
/* 174 */         for (Iterator<RecipientInformation> iterator = collection.iterator(); iterator.hasNext(); ) {
/*     */           RecipientInformation recipientInformation;
/*     */ 
/*     */           
/* 178 */           RecipientId recipientId = (recipientInformation = iterator.next()).getRID();
/* 179 */           if (!bool && recipientId.match(x509CertificateHolder)) {
/*     */             
/* 181 */             bool = true;
/* 182 */             privateKey = (PrivateKey)f.b();
/*     */ 
/*     */             
/* 185 */             arrayOfByte1 = recipientInformation.getContent((Recipient)new JceKeyTransEnvelopedRecipient(privateKey));
/*     */             break;
/*     */           } 
/* 188 */           b++;
/* 189 */           if (x509Certificate != null) {
/*     */             
/* 191 */             stringBuilder.append('\n');
/* 192 */             stringBuilder.append(b);
/* 193 */             stringBuilder.append(": ");
/* 194 */             if (recipientId instanceof KeyTransRecipientId)
/*     */             {
/* 196 */               a(stringBuilder, (KeyTransRecipientId)recipientId, x509Certificate, x509CertificateHolder);
/*     */             }
/*     */           } 
/*     */         } 
/* 200 */         arrayOfByte2[b1] = arrayOfByte;
/* 201 */         i += arrayOfByte.length;
/*     */       } 
/* 203 */       if (!bool || arrayOfByte1 == null)
/*     */       {
/* 205 */         throw new IOException("The certificate matches none of " + a1.b() + " recipient entries" + stringBuilder
/* 206 */             .toString());
/*     */       }
/* 208 */       if (arrayOfByte1.length != 24)
/*     */       {
/* 210 */         throw new IOException("The enveloped data does not contain 24 bytes");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 216 */       byte[] arrayOfByte3 = new byte[4];
/* 217 */       System.arraycopy(arrayOfByte1, 20, arrayOfByte3, 0, 4);
/*     */       
/*     */       j j;
/* 220 */       (j = new j(arrayOfByte3)).k();
/* 221 */       a(j);
/*     */ 
/*     */       
/* 224 */       byte[] arrayOfByte4 = new byte[i + 20];
/*     */ 
/*     */       
/* 227 */       System.arraycopy(arrayOfByte1, 0, arrayOfByte4, 0, 20);
/*     */ 
/*     */       
/* 230 */       int m = 20; byte[][] arrayOfByte6; int n; byte b2;
/* 231 */       for (n = (arrayOfByte6 = arrayOfByte2).length, b2 = 0; b2 < n; b2++) {
/*     */         byte[] arrayOfByte;
/* 233 */         System.arraycopy(arrayOfByte = arrayOfByte6[b2], 0, arrayOfByte4, m, arrayOfByte.length);
/*     */         
/* 235 */         m += arrayOfByte.length;
/*     */       } 
/*     */ 
/*     */       
/* 239 */       if (paramd.c() == 4 || paramd.c() == 5) {
/*     */         
/* 241 */         arrayOfByte5 = j.c().digest(arrayOfByte4);
/*     */ 
/*     */         
/*     */         c c;
/*     */ 
/*     */         
/* 247 */         if ((c = paramd.n()) != null)
/*     */         {
/* 249 */           j j1 = c.b();
/* 250 */           b((j.d.equals(j1) || j.e
/* 251 */               .equals(j1)));
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 256 */         arrayOfByte5 = j.b().digest(arrayOfByte4);
/*     */       } 
/*     */ 
/*     */       
/* 260 */       this.b = new byte[this.a / 8];
/* 261 */       System.arraycopy(arrayOfByte5, 0, this.b, 0, this.a / 8);
/*     */       return;
/* 263 */     } catch (CMSException cMSException) {
/*     */       
/* 265 */       throw new IOException(cMSException);
/*     */     }
/* 267 */     catch (KeyStoreException keyStoreException) {
/*     */       
/* 269 */       throw new IOException(keyStoreException);
/*     */     }
/* 271 */     catch (CertificateEncodingException certificateEncodingException) {
/*     */       
/* 273 */       throw new IOException(certificateEncodingException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(StringBuilder paramStringBuilder, KeyTransRecipientId paramKeyTransRecipientId, X509Certificate paramX509Certificate, X509CertificateHolder paramX509CertificateHolder) {
/*     */     BigInteger bigInteger;
/* 281 */     if ((bigInteger = paramKeyTransRecipientId.getSerialNumber()) != null) {
/*     */       
/* 283 */       String str = "unknown";
/*     */       BigInteger bigInteger1;
/* 285 */       if ((bigInteger1 = paramX509Certificate.getSerialNumber()) != null)
/*     */       {
/* 287 */         str = bigInteger1.toString(16);
/*     */       }
/* 289 */       paramStringBuilder.append("serial-#: rid ");
/* 290 */       paramStringBuilder.append(bigInteger.toString(16));
/* 291 */       paramStringBuilder.append(" vs. cert ");
/* 292 */       paramStringBuilder.append(str);
/* 293 */       paramStringBuilder.append(" issuer: rid '");
/* 294 */       paramStringBuilder.append(paramKeyTransRecipientId.getIssuer());
/* 295 */       paramStringBuilder.append("' vs. cert '");
/* 296 */       paramStringBuilder.append((paramX509CertificateHolder == null) ? "null" : paramX509CertificateHolder.getIssuer());
/* 297 */       paramStringBuilder.append("' ");
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
/*     */   public final void a(b paramb) {
/*     */     try {
/*     */       byte[] arrayOfByte5;
/*     */       d d;
/* 314 */       if ((d = paramb.d()) == null)
/*     */       {
/* 316 */         d = new d();
/*     */       }
/*     */       
/* 319 */       d.a("Adobe.PubSec");
/* 320 */       d.b(this.a);
/* 321 */       int i = c();
/* 322 */       d.a(i);
/*     */ 
/*     */       
/* 325 */       d.q();
/*     */ 
/*     */       
/* 328 */       byte[] arrayOfByte1 = new byte[20];
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 333 */         KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
/*     */       }
/* 335 */       catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*     */ 
/*     */         
/* 338 */         throw new RuntimeException(noSuchAlgorithmException);
/*     */       } 
/*     */       
/* 341 */       noSuchAlgorithmException.init(192, new SecureRandom());
/*     */       
/*     */       SecretKey secretKey;
/*     */       
/* 345 */       System.arraycopy((secretKey = noSuchAlgorithmException.generateKey()).getEncoded(), 0, arrayOfByte1, 0, 20);
/*     */       
/* 347 */       byte[][] arrayOfByte2 = a(arrayOfByte1);
/*     */       
/* 349 */       int j = 20; byte[][] arrayOfByte4; int m;
/*     */       byte b2;
/* 351 */       for (m = (arrayOfByte4 = arrayOfByte2).length, b2 = 0; b2 < m; ) { byte[] arrayOfByte = arrayOfByte4[b2];
/*     */         
/* 353 */         j += arrayOfByte.length;
/*     */         b2++; }
/*     */       
/* 356 */       byte[] arrayOfByte3 = new byte[j];
/*     */       
/* 358 */       System.arraycopy(arrayOfByte1, 0, arrayOfByte3, 0, 20);
/*     */       
/* 360 */       m = 20; byte b1; byte[][] arrayOfByte6;
/*     */       int n;
/* 362 */       for (n = (arrayOfByte6 = arrayOfByte2).length, b1 = 0; b1 < n; b1++) {
/*     */         byte[] arrayOfByte;
/* 364 */         System.arraycopy(arrayOfByte = arrayOfByte6[b1], 0, arrayOfByte3, m, arrayOfByte.length);
/* 365 */         m += arrayOfByte.length;
/*     */       } 
/*     */ 
/*     */       
/* 369 */       if (i == 4 || i == 5) {
/*     */         
/* 371 */         d.b("adbe.pkcs7.s5");
/* 372 */         arrayOfByte5 = j.c().digest(arrayOfByte3);
/* 373 */         j j1 = (i == 5) ? j.e : j.d;
/* 374 */         a(d, j1, arrayOfByte2);
/*     */       }
/*     */       else {
/*     */         
/* 378 */         d.b("adbe.pkcs7.s4");
/* 379 */         arrayOfByte5 = j.b().digest(arrayOfByte3);
/* 380 */         d.a(arrayOfByte2);
/*     */       } 
/*     */       
/* 383 */       this.b = new byte[this.a / 8];
/* 384 */       System.arraycopy(arrayOfByte5, 0, this.b, 0, this.a / 8);
/*     */       
/* 386 */       paramb.a(d);
/* 387 */       paramb.a().b(d.b());
/*     */       return;
/* 389 */     } catch (GeneralSecurityException generalSecurityException) {
/*     */       
/* 391 */       throw new IOException(generalSecurityException);
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
/*     */   private int c() {
/* 405 */     switch (this.a) {
/*     */       
/*     */       case 40:
/* 408 */         return 1;
/*     */       case 128:
/* 410 */         return 2;
/*     */       
/*     */       case 256:
/* 413 */         return 5;
/*     */     } 
/* 415 */     throw new IllegalArgumentException("key length must be 40, 128 or 256");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(d paramd, j paramj, byte[][] paramArrayOfbyte) {
/*     */     c c;
/* 422 */     (c = new c()).a(paramj);
/* 423 */     c.a(this.a);
/* 424 */     a a = new a(); int i; byte b;
/* 425 */     for (i = (paramArrayOfbyte = paramArrayOfbyte).length, b = 0; b < i; ) { byte[] arrayOfByte = paramArrayOfbyte[b];
/*     */       
/* 427 */       a.a((b)new s(arrayOfByte)); b++; }
/*     */     
/* 429 */     c.a().a(j.dc, (b)a);
/* 430 */     a.a(true);
/* 431 */     paramd.b(c);
/* 432 */     paramd.a(j.at);
/* 433 */     paramd.b(j.at);
/* 434 */     c.a().a(true);
/* 435 */     b(true);
/*     */   }
/*     */ 
/*     */   
/*     */   private byte[][] a(byte[] paramArrayOfbyte) {
/* 440 */     byte[][] arrayOfByte = new byte[this.c.b()][];
/* 441 */     Iterator<am> iterator = this.c.a();
/* 442 */     byte b = 0;
/*     */     
/* 444 */     while (iterator.hasNext()) {
/*     */       am am;
/*     */       
/* 447 */       X509Certificate x509Certificate = (am = iterator.next()).a();
/* 448 */       int i = am.b().e();
/*     */       
/* 450 */       byte[] arrayOfByte1 = new byte[24];
/* 451 */       byte b1 = (byte)i;
/* 452 */       byte b2 = (byte)(i >>> 8);
/* 453 */       byte b3 = (byte)(i >>> 16);
/* 454 */       i = (byte)(i >>> 24);
/*     */       
/* 456 */       System.arraycopy(paramArrayOfbyte, 0, arrayOfByte1, 0, 20);
/*     */       
/* 458 */       arrayOfByte1[20] = i;
/* 459 */       arrayOfByte1[21] = b3;
/* 460 */       arrayOfByte1[22] = b2;
/* 461 */       arrayOfByte1[23] = b1;
/*     */       
/* 463 */       ASN1Primitive aSN1Primitive = a(arrayOfByte1, x509Certificate);
/*     */       
/* 465 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */       
/*     */       DEROutputStream dEROutputStream;
/*     */       
/* 469 */       (dEROutputStream = new DEROutputStream(byteArrayOutputStream)).writeObject((ASN1Encodable)aSN1Primitive);
/*     */       
/* 471 */       arrayOfByte[b] = byteArrayOutputStream.toByteArray();
/*     */       
/* 473 */       b++;
/*     */     } 
/* 475 */     return arrayOfByte;
/*     */   }
/*     */   
/*     */   private ASN1Primitive a(byte[] paramArrayOfbyte, X509Certificate paramX509Certificate) {
/*     */     KeyGenerator keyGenerator;
/*     */     Cipher cipher;
/* 481 */     String str = PKCSObjectIdentifiers.RC2_CBC.getId();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 487 */       AlgorithmParameterGenerator algorithmParameterGenerator = AlgorithmParameterGenerator.getInstance(str, m.a());
/* 488 */       keyGenerator = KeyGenerator.getInstance(str, m.a());
/* 489 */       cipher = Cipher.getInstance(str, m.a());
/*     */     }
/* 491 */     catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*     */ 
/*     */       
/* 494 */       throw new IOException("Could not find a suitable javax.crypto provider for algorithm " + str + "; possible reason: using an unsigned .jar file", noSuchAlgorithmException);
/*     */     
/*     */     }
/* 497 */     catch (NoSuchPaddingException noSuchPaddingException) {
/*     */ 
/*     */       
/* 500 */       throw new RuntimeException("Could not find a suitable javax.crypto provider", noSuchPaddingException);
/*     */     } 
/*     */     
/* 503 */     AlgorithmParameters algorithmParameters = noSuchPaddingException.generateParameters();
/*     */     
/*     */     ASN1InputStream aSN1InputStream;
/* 506 */     ASN1Primitive aSN1Primitive = (aSN1InputStream = new ASN1InputStream(algorithmParameters.getEncoded("ASN.1"))).readObject();
/* 507 */     aSN1InputStream.close();
/*     */     
/* 509 */     keyGenerator.init(128);
/* 510 */     SecretKey secretKey = keyGenerator.generateKey();
/*     */     
/* 512 */     cipher.init(1, secretKey, algorithmParameters);
/* 513 */     paramArrayOfbyte = cipher.doFinal(paramArrayOfbyte);
/*     */     
/* 515 */     KeyTransRecipientInfo keyTransRecipientInfo = a(paramX509Certificate, secretKey.getEncoded());
/* 516 */     DERSet dERSet = new DERSet((ASN1Encodable)new RecipientInfo(keyTransRecipientInfo));
/*     */     
/* 518 */     AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(new ASN1ObjectIdentifier(str), (ASN1Encodable)aSN1Primitive);
/* 519 */     EncryptedContentInfo encryptedContentInfo = new EncryptedContentInfo(PKCSObjectIdentifiers.data, algorithmIdentifier, (ASN1OctetString)new DEROctetString(paramArrayOfbyte));
/*     */     
/* 521 */     EnvelopedData envelopedData = new EnvelopedData(null, (ASN1Set)dERSet, encryptedContentInfo, (ASN1Set)null);
/*     */     
/*     */     ContentInfo contentInfo;
/* 524 */     return (contentInfo = new ContentInfo(PKCSObjectIdentifiers.envelopedData, (ASN1Encodable)envelopedData)).toASN1Primitive();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static KeyTransRecipientInfo a(X509Certificate paramX509Certificate, byte[] paramArrayOfbyte) {
/*     */     Cipher cipher;
/*     */     ASN1InputStream aSN1InputStream;
/* 532 */     TBSCertificate tBSCertificate = TBSCertificate.getInstance((aSN1InputStream = new ASN1InputStream(paramX509Certificate.getTBSCertificate())).readObject());
/* 533 */     aSN1InputStream.close();
/*     */     
/* 535 */     AlgorithmIdentifier algorithmIdentifier = tBSCertificate.getSubjectPublicKeyInfo().getAlgorithm();
/*     */ 
/*     */ 
/*     */     
/* 539 */     IssuerAndSerialNumber issuerAndSerialNumber = new IssuerAndSerialNumber(tBSCertificate.getIssuer(), tBSCertificate.getSerialNumber().getValue());
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 544 */       cipher = Cipher.getInstance(algorithmIdentifier.getAlgorithm().getId(), 
/* 545 */           m.a());
/*     */     }
/* 547 */     catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*     */ 
/*     */       
/* 550 */       throw new RuntimeException("Could not find a suitable javax.crypto provider", noSuchAlgorithmException);
/*     */     }
/* 552 */     catch (NoSuchPaddingException noSuchPaddingException) {
/*     */ 
/*     */       
/* 555 */       throw new RuntimeException("Could not find a suitable javax.crypto provider", noSuchPaddingException);
/*     */     } 
/*     */     
/* 558 */     cipher.init(1, noSuchPaddingException.getPublicKey());
/*     */     
/* 560 */     DEROctetString dEROctetString = new DEROctetString(cipher.doFinal(paramArrayOfbyte));
/* 561 */     RecipientIdentifier recipientIdentifier = new RecipientIdentifier(issuerAndSerialNumber);
/* 562 */     return new KeyTransRecipientInfo(recipientIdentifier, algorithmIdentifier, (ASN1OctetString)dEROctetString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean a() {
/* 571 */     return (this.c != null);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */