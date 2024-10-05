/*     */ package com.prineside.tdi2.ibxm;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ 
/*     */ public class Data {
/*     */   private int a;
/*     */   
/*     */   public Data(InputStream paramInputStream) {
/*  10 */     this.a = 65536;
/*  11 */     this.b = new byte[this.a];
/*  12 */     this.c = paramInputStream;
/*  13 */     a(this.c, this.b, 0, this.a);
/*     */   }
/*     */   private byte[] b; private InputStream c;
/*     */   public Data(byte[] paramArrayOfbyte) {
/*  17 */     this.a = paramArrayOfbyte.length;
/*  18 */     this.b = paramArrayOfbyte;
/*     */   }
/*     */   
/*     */   public byte sByte(int paramInt) {
/*  22 */     a(paramInt, 1);
/*  23 */     return this.b[paramInt];
/*     */   }
/*     */   
/*     */   public int uByte(int paramInt) {
/*  27 */     a(paramInt, 1);
/*  28 */     return this.b[paramInt] & 0xFF;
/*     */   }
/*     */   
/*     */   public int ubeShort(int paramInt) {
/*  32 */     a(paramInt, 2);
/*  33 */     return (this.b[paramInt] & 0xFF) << 8 | this.b[paramInt + 1] & 0xFF;
/*     */   }
/*     */   
/*     */   public int uleShort(int paramInt) {
/*  37 */     a(paramInt, 2);
/*  38 */     return this.b[paramInt] & 0xFF | (this.b[paramInt + 1] & 0xFF) << 8;
/*     */   }
/*     */   
/*     */   public int uleInt(int paramInt) {
/*  42 */     a(paramInt, 4);
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/*  47 */     return i = (i = (i = (i = this.b[paramInt] & 0xFF) | (this.b[paramInt + 1] & 0xFF) << 8) | (this.b[paramInt + 2] & 0xFF) << 16) | (this.b[paramInt + 3] & Byte.MAX_VALUE) << 24;
/*     */   }
/*     */   
/*     */   public String strLatin1(int paramInt1, int paramInt2) {
/*  51 */     a(paramInt1, paramInt2);
/*  52 */     char[] arrayOfChar = new char[paramInt2];
/*  53 */     for (byte b = 0; b < paramInt2; b++) {
/*  54 */       int i = this.b[paramInt1 + b] & 0xFF;
/*  55 */       arrayOfChar[b] = (i < 32) ? ' ' : (char)i;
/*     */     } 
/*  57 */     return new String(arrayOfChar);
/*     */   }
/*     */   
/*     */   public String strCp850(int paramInt1, int paramInt2) {
/*  61 */     a(paramInt1, paramInt2);
/*     */     try {
/*  63 */       char[] arrayOfChar = (new String(this.b, paramInt1, paramInt2, "Cp850")).toCharArray();
/*  64 */       for (byte b = 0; b < arrayOfChar.length; b++) {
/*  65 */         arrayOfChar[b] = (arrayOfChar[b] < ' ') ? ' ' : arrayOfChar[b];
/*     */       }
/*  67 */       return new String(arrayOfChar);
/*  68 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*  69 */       return strLatin1(paramInt1, paramInt2);
/*     */     } 
/*     */   }
/*     */   
/*     */   public short[] samS8(int paramInt1, int paramInt2) {
/*  74 */     a(paramInt1, paramInt2);
/*  75 */     short[] arrayOfShort = new short[paramInt2];
/*  76 */     for (byte b = 0; b < paramInt2; b++) {
/*  77 */       arrayOfShort[b] = (short)(this.b[paramInt1 + b] << 8);
/*     */     }
/*  79 */     return arrayOfShort;
/*     */   }
/*     */   
/*     */   public short[] samS8D(int paramInt1, int paramInt2) {
/*  83 */     a(paramInt1, paramInt2);
/*  84 */     short[] arrayOfShort = new short[paramInt2];
/*  85 */     int i = 0;
/*  86 */     for (byte b = 0; b < paramInt2; b++) {
/*  87 */       i += this.b[paramInt1 + b];
/*  88 */       arrayOfShort[b] = (short)(i << 8);
/*     */     } 
/*  90 */     return arrayOfShort;
/*     */   }
/*     */   
/*     */   public short[] samU8(int paramInt1, int paramInt2) {
/*  94 */     a(paramInt1, paramInt2);
/*  95 */     short[] arrayOfShort = new short[paramInt2];
/*  96 */     for (byte b = 0; b < paramInt2; b++) {
/*  97 */       arrayOfShort[b] = (short)((this.b[paramInt1 + b] & 0xFF) - 128 << 8);
/*     */     }
/*  99 */     return arrayOfShort;
/*     */   }
/*     */   
/*     */   public short[] samS16(int paramInt1, int paramInt2) {
/* 103 */     a(paramInt1, paramInt2 << 1);
/* 104 */     short[] arrayOfShort = new short[paramInt2];
/* 105 */     for (byte b = 0; b < paramInt2; b++) {
/* 106 */       arrayOfShort[b] = (short)(this.b[paramInt1 + (b << 1)] & 0xFF | this.b[paramInt1 + (b << 1) + 1] << 8);
/*     */     }
/* 108 */     return arrayOfShort;
/*     */   }
/*     */   
/*     */   public short[] samS16D(int paramInt1, int paramInt2) {
/* 112 */     a(paramInt1, paramInt2 << 1);
/* 113 */     short[] arrayOfShort = new short[paramInt2];
/* 114 */     int i = 0;
/* 115 */     for (byte b = 0; b < paramInt2; b++) {
/* 116 */       i += this.b[paramInt1 + (b << 1)] & 0xFF | this.b[paramInt1 + (b << 1) + 1] << 8;
/* 117 */       arrayOfShort[b] = (short)i;
/*     */     } 
/* 119 */     return arrayOfShort;
/*     */   }
/*     */   
/*     */   public short[] samU16(int paramInt1, int paramInt2) {
/* 123 */     a(paramInt1, paramInt2 << 1);
/* 124 */     short[] arrayOfShort = new short[paramInt2];
/* 125 */     for (byte b = 0; b < paramInt2; b++) {
/* 126 */       int i = this.b[paramInt1 + (b << 1)] & 0xFF | (this.b[paramInt1 + (b << 1) + 1] & 0xFF) << 8;
/* 127 */       arrayOfShort[b] = (short)(i - 32768);
/*     */     } 
/* 129 */     return arrayOfShort;
/*     */   }
/*     */   
/*     */   private void a(int paramInt1, int paramInt2) {
/* 133 */     while (paramInt1 + paramInt2 > this.a) {
/*     */       int i;
/* 135 */       byte[] arrayOfByte = new byte[i = this.a << 1];
/* 136 */       System.arraycopy(this.b, 0, arrayOfByte, 0, this.a);
/* 137 */       if (this.c != null) {
/* 138 */         a(this.c, arrayOfByte, this.a, i - this.a);
/*     */       }
/* 140 */       this.a = i;
/* 141 */       this.b = arrayOfByte;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void a(InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 146 */     int i = 1; paramInt2 = paramInt1 + paramInt2;
/* 147 */     while (i) {
/* 148 */       i = paramInputStream.read(paramArrayOfbyte, paramInt1, paramInt2 - paramInt1);
/* 149 */       paramInt1 += i;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\ibxm\Data.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */