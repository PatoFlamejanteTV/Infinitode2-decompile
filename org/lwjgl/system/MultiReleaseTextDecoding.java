/*    */ package org.lwjgl.system;
/*    */ 
/*    */ import java.nio.charset.StandardCharsets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class MultiReleaseTextDecoding
/*    */ {
/*    */   static String decodeUTF8(long paramLong, int paramInt) {
/* 25 */     if (paramInt <= 0) {
/* 26 */       return "";
/*    */     }
/*    */     
/* 29 */     if (Checks.DEBUG) {
/*    */       
/* 31 */       byte[] arrayOfByte = (paramInt <= MemoryUtil.ARRAY_TLC_SIZE) ? MemoryUtil.ARRAY_TLC_BYTE.get() : new byte[paramInt];
/* 32 */       MemoryUtil.memByteBuffer(paramLong, paramInt).get(arrayOfByte, 0, paramInt);
/* 33 */       return new String(arrayOfByte, 0, paramInt, StandardCharsets.UTF_8);
/*    */     } 
/*    */     
/* 36 */     char[] arrayOfChar = (paramInt <= MemoryUtil.ARRAY_TLC_SIZE) ? MemoryUtil.ARRAY_TLC_CHAR.get() : new char[paramInt];
/*    */     
/* 38 */     byte b1 = 0, b2 = 0;
/*    */     
/* 40 */     while (b2 < paramInt) {
/*    */       int i;
/*    */ 
/*    */       
/* 44 */       if ((i = MemoryUtil.UNSAFE.getByte(null, paramLong + b2++) & 0xFF) < 128) {
/* 45 */         i = (char)i;
/*    */       } else {
/* 47 */         int j = MemoryUtil.UNSAFE.getByte(null, paramLong + b2++) & 0x3F;
/* 48 */         if ((i & 0xE0) == 192) {
/* 49 */           i = (char)((i & 0x1F) << 6 | j);
/*    */         } else {
/* 51 */           int k = MemoryUtil.UNSAFE.getByte(null, paramLong + b2++) & 0x3F;
/* 52 */           if ((i & 0xF0) == 224) {
/* 53 */             i = (char)((i & 0xF) << 12 | j << 6 | k);
/*    */           } else {
/* 55 */             int m = MemoryUtil.UNSAFE.getByte(null, paramLong + b2++) & 0x3F;
/* 56 */             i = (i & 0x7) << 18 | j << 12 | k << 6 | m;
/*    */             
/* 58 */             if (b1 < paramInt) {
/* 59 */               arrayOfChar[b1++] = (char)((i >>> 10) + 55232);
/*    */             }
/* 61 */             i = (char)((i & 0x3FF) + 56320);
/*    */           } 
/*    */         } 
/*    */       } 
/* 65 */       if (b1 < paramInt) {
/* 66 */         arrayOfChar[b1++] = i;
/*    */       }
/*    */     } 
/*    */     
/* 70 */     return new String(arrayOfChar, 0, Math.min(b1, paramInt));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\MultiReleaseTextDecoding.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */