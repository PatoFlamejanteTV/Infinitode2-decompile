/*     */ package nonapi.io.github.classgraph.utils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class StringUtils
/*     */ {
/*     */   public static String readString(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
/*  62 */     if (paramInt1 < 0L || paramInt2 < 0 || paramInt1 + paramInt2 > paramArrayOfbyte.length) {
/*  63 */       throw new IllegalArgumentException("offset or numBytes out of range");
/*     */     }
/*  65 */     char[] arrayOfChar = new char[paramInt2];
/*  66 */     byte b1 = 0;
/*  67 */     byte b2 = 0; int i;
/*  68 */     for (; b1 < paramInt2 && (
/*     */       
/*  70 */       i = paramArrayOfbyte[paramInt1 + b1] & 0xFF) <= 127; b1++)
/*     */     {
/*     */       
/*  73 */       arrayOfChar[b2++] = (char)((paramBoolean1 && i == 47) ? '.' : i);
/*     */     }
/*  75 */     while (b1 < paramInt2) {
/*     */       byte b; int j;
/*  77 */       switch ((i = paramArrayOfbyte[paramInt1 + b1] & 0xFF) >> 4) {
/*     */         case 0:
/*     */         case 1:
/*     */         case 2:
/*     */         case 3:
/*     */         case 4:
/*     */         case 5:
/*     */         case 6:
/*     */         case 7:
/*  86 */           b1++;
/*  87 */           arrayOfChar[b2++] = (char)((paramBoolean1 && i == 47) ? '.' : i);
/*     */           continue;
/*     */         
/*     */         case 12:
/*     */         case 13:
/*  92 */           b1 += 2;
/*  93 */           if (b1 > paramInt2) {
/*  94 */             throw new IllegalArgumentException("Bad modified UTF8");
/*     */           }
/*     */           
/*  97 */           if (((b = paramArrayOfbyte[paramInt1 + b1 - 1]) & 0xC0) != 128) {
/*  98 */             throw new IllegalArgumentException("Bad modified UTF8");
/*     */           }
/* 100 */           j = (i & 0x1F) << 6 | b & 0x3F;
/* 101 */           arrayOfChar[b2++] = (char)((paramBoolean1 && j == 47) ? '.' : j);
/*     */           continue;
/*     */         
/*     */         case 14:
/* 105 */           b1 += 3;
/* 106 */           if (b1 > paramInt2) {
/* 107 */             throw new IllegalArgumentException("Bad modified UTF8");
/*     */           }
/* 109 */           b = paramArrayOfbyte[paramInt1 + b1 - 2];
/* 110 */           j = paramArrayOfbyte[paramInt1 + b1 - 1];
/* 111 */           if ((b & 0xC0) != 128 || (j & 0xC0) != 128) {
/* 112 */             throw new IllegalArgumentException("Bad modified UTF8");
/*     */           }
/* 114 */           i = (i & 0xF) << 12 | (b & 0x3F) << 6 | j & 0x3F;
/* 115 */           arrayOfChar[b2++] = (char)((paramBoolean1 && i == 47) ? '.' : i);
/*     */           continue;
/*     */       } 
/*     */       
/* 119 */       throw new IllegalArgumentException("Bad modified UTF8");
/*     */     } 
/*     */     
/* 122 */     if (b2 == paramInt2 && !paramBoolean2) {
/* 123 */       return new String(arrayOfChar);
/*     */     }
/* 125 */     if (paramBoolean2) {
/* 126 */       if (b2 < 2 || arrayOfChar[0] != 'L' || arrayOfChar[b2 - 1] != ';') {
/* 127 */         throw new IllegalArgumentException("Expected string to start with 'L' and end with ';', got \"" + new String(arrayOfChar) + "\"");
/*     */       }
/*     */       
/* 130 */       return new String(arrayOfChar, 1, b2 - 2);
/*     */     } 
/* 132 */     return new String(arrayOfChar, 0, b2);
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
/*     */   public static void join(StringBuilder paramStringBuilder, String paramString1, String paramString2, String paramString3, Iterable<?> paramIterable) {
/* 153 */     if (!paramString1.isEmpty()) {
/* 154 */       paramStringBuilder.append(paramString1);
/*     */     }
/* 156 */     boolean bool = true;
/* 157 */     for (Object object : paramIterable) {
/* 158 */       if (bool) {
/* 159 */         bool = false;
/*     */       } else {
/* 161 */         paramStringBuilder.append(paramString2);
/*     */       } 
/* 163 */       paramStringBuilder.append((object == null) ? "null" : object.toString());
/*     */     } 
/* 165 */     if (!paramString3.isEmpty()) {
/* 166 */       paramStringBuilder.append(paramString3);
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
/*     */   public static String join(String paramString, Iterable<?> paramIterable) {
/*     */     StringBuilder stringBuilder;
/* 181 */     join(stringBuilder = new StringBuilder(), "", paramString, "", paramIterable);
/* 182 */     return stringBuilder.toString();
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
/*     */   public static String join(String paramString, Object... paramVarArgs) {
/* 195 */     StringBuilder stringBuilder = new StringBuilder();
/* 196 */     boolean bool = true; int i; byte b;
/* 197 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { Object object = paramVarArgs[b];
/* 198 */       if (bool) {
/* 199 */         bool = false;
/*     */       } else {
/* 201 */         stringBuilder.append(paramString);
/*     */       } 
/* 203 */       stringBuilder.append(object.toString()); b++; }
/*     */     
/* 205 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgrap\\utils\StringUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */