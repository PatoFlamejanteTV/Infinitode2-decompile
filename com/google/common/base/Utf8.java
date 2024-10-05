/*     */ package com.google.common.base;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ElementTypesAreNonnullByDefault
/*     */ public final class Utf8
/*     */ {
/*     */   public static int encodedLength(CharSequence paramCharSequence) {
/*  54 */     int i = paramCharSequence.length(), j = i;
/*  55 */     byte b = 0;
/*     */ 
/*     */     
/*  58 */     while (b < i && paramCharSequence.charAt(b) < '') {
/*  59 */       b++;
/*     */     }
/*     */ 
/*     */     
/*  63 */     for (; b < i; b++) {
/*     */       char c;
/*  65 */       if ((c = paramCharSequence.charAt(b)) < 'ࠀ') {
/*  66 */         j += 127 - c >>> 31;
/*     */       } else {
/*  68 */         j += encodedLengthGeneral(paramCharSequence, b);
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*  73 */     if (j < i) {
/*     */       
/*  75 */       long l = j + 4294967296L; throw new IllegalArgumentException((new StringBuilder(54)).append("UTF-8 length does not fit in int: ").append(l).toString());
/*     */     } 
/*     */     
/*  78 */     return j;
/*     */   }
/*     */   
/*     */   private static int encodedLengthGeneral(CharSequence paramCharSequence, int paramInt) {
/*  82 */     int i = paramCharSequence.length();
/*  83 */     int j = 0;
/*  84 */     for (paramInt = paramInt; paramInt < i; paramInt++) {
/*     */       char c;
/*  86 */       if ((c = paramCharSequence.charAt(paramInt)) < 'ࠀ') {
/*  87 */         j += 127 - c >>> 31;
/*     */       } else {
/*  89 */         j += 2;
/*     */         
/*  91 */         if ('?' <= c && c <= '?') {
/*     */           
/*  93 */           if (Character.codePointAt(paramCharSequence, paramInt) == c) {
/*  94 */             throw new IllegalArgumentException(unpairedSurrogateMsg(paramInt));
/*     */           }
/*  96 */           paramInt++;
/*     */         } 
/*     */       } 
/*     */     } 
/* 100 */     return j;
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
/*     */   public static boolean isWellFormed(byte[] paramArrayOfbyte) {
/* 114 */     return isWellFormed(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   public static boolean isWellFormed(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 127 */     paramInt2 = paramInt1 + paramInt2;
/* 128 */     Preconditions.checkPositionIndexes(paramInt1, paramInt2, paramArrayOfbyte.length);
/*     */     
/* 130 */     for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/* 131 */       if (paramArrayOfbyte[paramInt1] < 0) {
/* 132 */         return isWellFormedSlowPath(paramArrayOfbyte, paramInt1, paramInt2);
/*     */       }
/*     */     } 
/* 135 */     return true;
/*     */   }
/*     */   
/*     */   private static boolean isWellFormedSlowPath(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 139 */     paramInt1 = paramInt1;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/* 145 */       if (paramInt1 >= paramInt2)
/* 146 */         return true; 
/*     */       byte b;
/* 148 */       if ((b = paramArrayOfbyte[paramInt1++]) < 0) {
/*     */         
/* 150 */         if (b < -32) {
/*     */           
/* 152 */           if (paramInt1 == paramInt2) {
/* 153 */             return false;
/*     */           }
/*     */ 
/*     */           
/* 157 */           if (b < -62 || paramArrayOfbyte[paramInt1++] > -65)
/* 158 */             return false;  continue;
/*     */         } 
/* 160 */         if (b < -16) {
/*     */           
/* 162 */           if (paramInt1 + 1 >= paramInt2) {
/* 163 */             return false;
/*     */           }
/*     */           byte b2;
/* 166 */           if ((b2 = paramArrayOfbyte[paramInt1++]) > -65 || (b == -32 && b2 < -96) || (b == -19 && -96 <= b2) || paramArrayOfbyte[paramInt1++] > -65)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 173 */             return false;
/*     */           }
/*     */           continue;
/*     */         } 
/* 177 */         if (paramInt1 + 2 >= paramInt2) {
/* 178 */           return false;
/*     */         }
/*     */         byte b1;
/* 181 */         if ((b1 = paramArrayOfbyte[paramInt1++]) > -65 || (b << 28) + b1 - -112 >> 30 != 0 || paramArrayOfbyte[paramInt1++] > -65 || paramArrayOfbyte[paramInt1++] > -65) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 191 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String unpairedSurrogateMsg(int paramInt) {
/* 198 */     return (new StringBuilder(39)).append("Unpaired surrogate at index ").append(paramInt).toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Utf8.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */