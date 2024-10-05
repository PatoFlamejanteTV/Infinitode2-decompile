/*     */ package org.a.c.h.c;
/*     */ 
/*     */ import java.security.Key;
/*     */ import java.security.KeyStore;
/*     */ import java.security.KeyStoreException;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.security.UnrecoverableKeyException;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.Enumeration;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class f
/*     */   extends a
/*     */ {
/*  45 */   private String a = null;
/*  46 */   private KeyStore b = null;
/*  47 */   private String c = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public f(KeyStore paramKeyStore, String paramString1, String paramString2) {
/*  60 */     this.b = paramKeyStore;
/*  61 */     this.c = paramString1;
/*  62 */     this.a = paramString2;
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
/*     */   public final X509Certificate a() {
/*  76 */     if (this.b.size() == 1) {
/*     */       Enumeration<String> enumeration;
/*     */       
/*  79 */       String str = (enumeration = this.b.aliases()).nextElement();
/*  80 */       return (X509Certificate)this.b.getCertificate(str);
/*     */     } 
/*     */ 
/*     */     
/*  84 */     if (this.b.containsAlias(this.c))
/*     */     {
/*  86 */       return (X509Certificate)this.b.getCertificate(this.c);
/*     */     }
/*  88 */     throw new KeyStoreException("the keystore does not contain the given alias");
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
/*     */   public final Key b() {
/*     */     try {
/* 112 */       if (this.b.size() == 1) {
/*     */         Enumeration<String> enumeration;
/*     */         
/* 115 */         String str = (enumeration = this.b.aliases()).nextElement();
/* 116 */         return this.b.getKey(str, this.a.toCharArray());
/*     */       } 
/*     */ 
/*     */       
/* 120 */       if (this.b.containsAlias(this.c))
/*     */       {
/* 122 */         return this.b.getKey(this.c, this.a.toCharArray());
/*     */       }
/* 124 */       throw new KeyStoreException("the keystore does not contain the given alias");
/*     */     
/*     */     }
/* 127 */     catch (UnrecoverableKeyException unrecoverableKeyException) {
/*     */       
/* 129 */       throw new KeyStoreException("the private key is not recoverable", unrecoverableKeyException);
/*     */     }
/* 131 */     catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*     */       
/* 133 */       throw new KeyStoreException("the algorithm necessary to recover the key is not available", noSuchAlgorithmException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */