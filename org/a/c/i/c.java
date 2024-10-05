/*     */ package org.a.c.i;
/*     */ 
/*     */ import java.io.OutputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class c
/*     */ {
/*     */   static {
/*  35 */     org.a.a.a.c.a(c.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   private static final byte[] a = new byte[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
/*  44 */   private static final char[] b = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static char[] a(short paramShort) {
/*     */     char[] arrayOfChar;
/*  98 */     (arrayOfChar = new char[4])[0] = b[paramShort >> 12 & 0xF];
/*  99 */     arrayOfChar[1] = b[paramShort >> 8 & 0xF];
/* 100 */     arrayOfChar[2] = b[paramShort >> 4 & 0xF];
/* 101 */     arrayOfChar[3] = b[paramShort & 0xF];
/* 102 */     return arrayOfChar;
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
/*     */   public static char[] a(String paramString) {
/* 122 */     char[] arrayOfChar = new char[paramString.length() << 2];
/*     */     
/* 124 */     for (byte b1 = 0, b2 = 0; b1 < paramString.length(); b1++) {
/*     */       
/* 126 */       char c1 = paramString.charAt(b1);
/* 127 */       arrayOfChar[b2++] = b[c1 >> 12 & 0xF];
/* 128 */       arrayOfChar[b2++] = b[c1 >> 8 & 0xF];
/* 129 */       arrayOfChar[b2++] = b[c1 >> 4 & 0xF];
/* 130 */       arrayOfChar[b2++] = b[c1 & 0xF];
/*     */     } 
/*     */     
/* 133 */     return arrayOfChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(byte paramByte, OutputStream paramOutputStream) {
/* 144 */     paramOutputStream.write(a[a(paramByte)]);
/* 145 */     paramOutputStream.write(a[b(paramByte)]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(byte[] paramArrayOfbyte, OutputStream paramOutputStream) {
/*     */     int i;
/*     */     byte b;
/* 156 */     for (i = (paramArrayOfbyte = paramArrayOfbyte).length, b = 0; b < i; b++) {
/*     */       byte b1;
/* 158 */       a(b1 = paramArrayOfbyte[b], paramOutputStream);
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
/*     */   private static int a(byte paramByte) {
/* 170 */     return (paramByte & 0xF0) >> 4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int b(byte paramByte) {
/* 181 */     return paramByte & 0xF;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\i\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */