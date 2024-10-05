/*     */ package org.a.c.b;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class s
/*     */   extends b
/*     */ {
/*  48 */   private static final a a = c.a(s.class);
/*     */ 
/*     */ 
/*     */   
/*  52 */   private static boolean b = Boolean.getBoolean("org.apache.pdfbox.forceParsing");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private byte[] c;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static s a(String paramString) {
/*  63 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */     
/*     */     StringBuilder stringBuilder;
/*     */     
/*  67 */     if ((stringBuilder = new StringBuilder(paramString.trim())).length() % 2 != 0)
/*     */     {
/*  69 */       stringBuilder.append('0');
/*     */     }
/*     */     
/*  72 */     int i = stringBuilder.length();
/*  73 */     for (byte b1 = 0; b1 < i; b1 += 2) {
/*     */ 
/*     */       
/*     */       try {
/*  77 */         byteArrayOutputStream.write(Integer.parseInt(stringBuilder.substring(b1, b1 + 2), 16));
/*     */       }
/*  79 */       catch (NumberFormatException numberFormatException) {
/*     */         
/*  81 */         if (b) {
/*     */ 
/*     */           
/*  84 */           byteArrayOutputStream.write(63);
/*     */         }
/*     */         else {
/*     */           
/*  88 */           throw new IOException("Invalid hex string: " + paramString, numberFormatException);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  93 */     return new s(byteArrayOutputStream.toByteArray());
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
/*     */   public s(byte[] paramArrayOfbyte) {
/* 107 */     a(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public s(String paramString) {
/* 118 */     boolean bool = true; char[] arrayOfChar; int i; byte b1;
/* 119 */     for (i = (arrayOfChar = paramString.toCharArray()).length, b1 = 0; b1 < i; b1++) {
/*     */       char c;
/* 121 */       if (!v.a(c = arrayOfChar[b1])) {
/*     */         
/* 123 */         bool = false;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 128 */     if (bool) {
/*     */ 
/*     */       
/* 131 */       this.c = v.a(paramString);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 136 */     byte[] arrayOfByte = paramString.getBytes(a.b);
/*     */     ByteArrayOutputStream byteArrayOutputStream;
/* 138 */     (byteArrayOutputStream = new ByteArrayOutputStream(arrayOfByte.length + 2)).write(254);
/* 139 */     byteArrayOutputStream.write(255);
/*     */     
/*     */     try {
/* 142 */       byteArrayOutputStream.write(arrayOfByte);
/*     */     }
/* 144 */     catch (IOException iOException) {
/*     */ 
/*     */       
/* 147 */       throw new RuntimeException(iOException);
/*     */     } 
/* 149 */     this.c = byteArrayOutputStream.toByteArray();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(byte[] paramArrayOfbyte) {
/* 160 */     this.c = (byte[])paramArrayOfbyte.clone();
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
/*     */   public final boolean a() {
/* 181 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String b() {
/* 192 */     if (this.c.length >= 2) {
/*     */       
/* 194 */       if ((this.c[0] & 0xFF) == 254 && (this.c[1] & 0xFF) == 255)
/*     */       {
/*     */         
/* 197 */         return new String(this.c, 2, this.c.length - 2, a.b);
/*     */       }
/* 199 */       if ((this.c[0] & 0xFF) == 255 && (this.c[1] & 0xFF) == 254)
/*     */       {
/*     */         
/* 202 */         return new String(this.c, 2, this.c.length - 2, a.c);
/*     */       }
/*     */     } 
/*     */     
/* 206 */     return v.a(this.c);
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
/*     */   public final byte[] c() {
/* 227 */     return this.c;
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
/*     */   public final Object a(u paramu) {
/* 250 */     return paramu.a(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 256 */     if (paramObject instanceof s) {
/*     */       
/* 258 */       paramObject = paramObject;
/* 259 */       return b().equals(paramObject.b());
/*     */     } 
/*     */     
/* 262 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/*     */     int i;
/* 269 */     return i = Arrays.hashCode(this.c);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 275 */     return "COSString{" + b() + "}";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\b\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */