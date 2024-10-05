/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.b.b;
/*     */ import com.a.a.c.d.c;
/*     */ import com.a.a.c.g;
/*     */ import java.util.Arrays;
/*     */ import java.util.UUID;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ap
/*     */   extends q<UUID>
/*     */ {
/*     */   private static int[] a;
/*     */   
/*     */   static {
/*  19 */     Arrays.fill(a = new int[127], -1); byte b;
/*  20 */     for (b = 0; b < 10; ) { a[b + 48] = b; b++; }
/*  21 */      for (b = 0; b < 6; b++) {
/*  22 */       a[b + 97] = b + 10;
/*  23 */       a[b + 65] = b + 10;
/*     */     } 
/*     */   }
/*     */   public ap() {
/*  27 */     super(UUID.class);
/*     */   }
/*     */   
/*     */   public final Object c(g paramg) {
/*  31 */     return new UUID(0L, 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private UUID b(String paramString, g paramg) {
/*  39 */     if (paramString.length() != 36) {
/*     */ 
/*     */ 
/*     */       
/*  43 */       if (paramString.length() == 24) {
/*  44 */         byte[] arrayOfByte = b.a().a(paramString);
/*  45 */         return a(arrayOfByte, paramg);
/*     */       } 
/*  47 */       return c(paramString, paramg);
/*     */     } 
/*     */ 
/*     */     
/*  51 */     if (paramString.charAt(8) != '-' || paramString.charAt(13) != '-' || paramString
/*  52 */       .charAt(18) != '-' || paramString.charAt(23) != '-') {
/*  53 */       c(paramString, paramg);
/*     */     }
/*     */     
/*  56 */     long l2 = (l2 = a(paramString, 0, paramg)) << 32L;
/*     */     
/*  58 */     long l3 = (l3 = b(paramString, 9, paramg) << 16L) | b(paramString, 14, paramg);
/*  59 */     long l4 = l2 + l3;
/*     */     
/*     */     int i;
/*     */     
/*  63 */     long l1 = (l1 = (i = b(paramString, 19, paramg) << 16 | b(paramString, 24, paramg))) << 32L;
/*     */     
/*  65 */     l3 = (l3 = a(paramString, 28, paramg)) << 32L >>> 32L;
/*  66 */     long l5 = l1 | l3;
/*     */     
/*  68 */     return new UUID(l4, l5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private UUID b(Object paramObject, g paramg) {
/*  74 */     if (paramObject instanceof byte[]) {
/*  75 */       return a((byte[])paramObject, paramg);
/*     */     }
/*  77 */     return super.a(paramObject, paramg);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private UUID c(String paramString, g paramg) {
/*  83 */     return (UUID)paramg.b(a(), paramString, "UUID has to be represented by standard 36-char representation", new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   private int a(String paramString, int paramInt, g paramg) {
/*  88 */     return (c(paramString, paramInt, paramg) << 24) + (
/*  89 */       c(paramString, paramInt + 2, paramg) << 16) + (
/*  90 */       c(paramString, paramInt + 4, paramg) << 8) + 
/*  91 */       c(paramString, paramInt + 6, paramg);
/*     */   }
/*     */   
/*     */   private int b(String paramString, int paramInt, g paramg) {
/*  95 */     return (c(paramString, paramInt, paramg) << 8) + c(paramString, paramInt + 2, paramg);
/*     */   }
/*     */ 
/*     */   
/*     */   private int c(String paramString, int paramInt, g paramg) {
/* 100 */     char c = paramString.charAt(paramInt);
/* 101 */     paramInt = paramString.charAt(paramInt + 1);
/*     */     int i;
/* 103 */     if (c <= '' && paramInt <= 127 && (
/*     */       
/* 105 */       i = a[c] << 4 | a[paramInt]) >= 0) {
/* 106 */       return i;
/*     */     }
/*     */     
/* 109 */     if (c > '' || a[c] < 0) {
/* 110 */       return a(paramString, paramg, c);
/*     */     }
/* 112 */     return a(paramString, paramg, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int a(String paramString, g paramg, char paramChar) {
/* 118 */     throw paramg.a(paramString, a(), 
/* 119 */         String.format("Non-hex character '%c' (value 0x%s), not valid for UUID String", new Object[] {
/*     */             
/* 121 */             Character.valueOf(paramChar), Integer.toHexString(paramChar) }));
/*     */   }
/*     */   
/*     */   private UUID a(byte[] paramArrayOfbyte, g paramg) {
/* 125 */     if (paramArrayOfbyte.length != 16) {
/* 126 */       throw c.a(paramg.j(), "Can only construct UUIDs from byte[16]; got " + paramArrayOfbyte.length + " bytes", paramArrayOfbyte, 
/*     */           
/* 128 */           a());
/*     */     }
/* 130 */     return new UUID(a(paramArrayOfbyte, 0), a(paramArrayOfbyte, 8));
/*     */   }
/*     */   
/*     */   private static long a(byte[] paramArrayOfbyte, int paramInt) {
/* 134 */     long l1 = b(paramArrayOfbyte, paramInt) << 32L;
/*     */ 
/*     */     
/* 137 */     long l2 = (l2 = b(paramArrayOfbyte, paramInt + 4)) << 32L >>> 32L;
/* 138 */     return l1 | l2;
/*     */   }
/*     */   
/*     */   private static int b(byte[] paramArrayOfbyte, int paramInt) {
/* 142 */     return paramArrayOfbyte[paramInt] << 24 | (paramArrayOfbyte[paramInt + 1] & 0xFF) << 16 | (paramArrayOfbyte[paramInt + 2] & 0xFF) << 8 | paramArrayOfbyte[paramInt + 3] & 0xFF;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\ap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */