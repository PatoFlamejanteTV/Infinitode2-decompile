/*    */ package com.badlogic.gdx.utils.compression;
/*    */ 
/*    */ 
/*    */ public class CRC
/*    */ {
/*  6 */   public static int[] Table = new int[256];
/*    */   
/*    */   static {
/*  9 */     for (byte b = 0; b < 'Ā'; b++) {
/* 10 */       int i = b;
/* 11 */       for (byte b1 = 0; b1 < 8; b1++) {
/* 12 */         if ((i & 0x1) != 0)
/* 13 */         { i = i >>> 1 ^ 0xEDB88320; }
/*    */         else
/* 15 */         { i >>>= 1; } 
/* 16 */       }  Table[b] = i;
/*    */     } 
/*    */   }
/*    */   
/* 20 */   int _value = -1;
/*    */   
/*    */   public void Init() {
/* 23 */     this._value = -1;
/*    */   }
/*    */   
/*    */   public void Update(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 27 */     for (byte b = 0; b < paramInt2; b++)
/* 28 */       this._value = Table[(this._value ^ paramArrayOfbyte[paramInt1 + b]) & 0xFF] ^ this._value >>> 8; 
/*    */   }
/*    */   
/*    */   public void Update(byte[] paramArrayOfbyte) {
/* 32 */     int i = paramArrayOfbyte.length;
/* 33 */     for (byte b = 0; b < i; b++)
/* 34 */       this._value = Table[(this._value ^ paramArrayOfbyte[b]) & 0xFF] ^ this._value >>> 8; 
/*    */   }
/*    */   
/*    */   public void UpdateByte(int paramInt) {
/* 38 */     this._value = Table[(this._value ^ paramInt) & 0xFF] ^ this._value >>> 8;
/*    */   }
/*    */   
/*    */   public int GetDigest() {
/* 42 */     return this._value ^ 0xFFFFFFFF;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\compression\CRC.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */