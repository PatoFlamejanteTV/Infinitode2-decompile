/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import java.io.DataInputStream;
/*     */ import java.io.InputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DataInput
/*     */   extends DataInputStream
/*     */ {
/*  26 */   private char[] chars = new char[32];
/*     */   
/*     */   public DataInput(InputStream paramInputStream) {
/*  29 */     super(paramInputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   public int readInt(boolean paramBoolean) {
/*     */     byte b;
/*  35 */     int i = (b = readByte()) & Byte.MAX_VALUE;
/*  36 */     if ((b & 0x80) != 0) {
/*  37 */       b = readByte();
/*  38 */       i |= (b & Byte.MAX_VALUE) << 7;
/*  39 */       if ((b & 0x80) != 0) {
/*  40 */         b = readByte();
/*  41 */         i |= (b & Byte.MAX_VALUE) << 14;
/*  42 */         if ((b & 0x80) != 0) {
/*  43 */           b = readByte();
/*  44 */           i |= (b & Byte.MAX_VALUE) << 21;
/*  45 */           if ((b & 0x80) != 0) {
/*  46 */             b = readByte();
/*  47 */             i |= (b & Byte.MAX_VALUE) << 28;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*  52 */     return paramBoolean ? i : (i >>> 1 ^ -(i & 0x1));
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public String readString() {
/*     */     int i;
/*  59 */     switch (i = readInt(true)) {
/*     */       case 0:
/*  61 */         return null;
/*     */       case 1:
/*  63 */         return "";
/*     */     } 
/*  65 */     i--;
/*  66 */     if (this.chars.length < i) this.chars = new char[i]; 
/*  67 */     char[] arrayOfChar = this.chars;
/*     */     
/*  69 */     byte b = 0;
/*  70 */     byte b1 = 0;
/*  71 */     while (b < i && (
/*     */       
/*  73 */       b1 = readByte()) >= 0) {
/*  74 */       arrayOfChar[b++] = (char)b1;
/*     */     }
/*     */     
/*  77 */     if (b < i) readUtf8_slow(i, b, b1 & 0xFF); 
/*  78 */     return new String(arrayOfChar, 0, i);
/*     */   }
/*     */   
/*     */   private void readUtf8_slow(int paramInt1, int paramInt2, int paramInt3) {
/*  82 */     char[] arrayOfChar = this.chars;
/*     */     while (true) {
/*  84 */       switch (paramInt3 >> 4) {
/*     */         case 0:
/*     */         case 1:
/*     */         case 2:
/*     */         case 3:
/*     */         case 4:
/*     */         case 5:
/*     */         case 6:
/*     */         case 7:
/*  93 */           arrayOfChar[paramInt2] = (char)paramInt3;
/*     */           break;
/*     */         case 12:
/*     */         case 13:
/*  97 */           arrayOfChar[paramInt2] = (char)((paramInt3 & 0x1F) << 6 | readByte() & 0x3F);
/*     */           break;
/*     */         case 14:
/* 100 */           arrayOfChar[paramInt2] = (char)((paramInt3 & 0xF) << 12 | (readByte() & 0x3F) << 6 | readByte() & 0x3F);
/*     */           break;
/*     */       } 
/* 103 */       if (++paramInt2 < paramInt1) {
/* 104 */         paramInt3 = readByte() & 0xFF;
/*     */         continue;
/*     */       } 
/*     */       break;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\DataInput.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */