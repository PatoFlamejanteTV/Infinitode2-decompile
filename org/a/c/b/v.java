/*     */ package org.a.c.b;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class v
/*     */ {
/*  37 */   private static final int[] a = new int[256];
/*  38 */   private static final Map<Character, Integer> b = new HashMap<Character, Integer>(256);
/*     */   
/*     */   static {
/*  41 */     for (byte b = 0; b < 'Ā'; b++) {
/*     */ 
/*     */       
/*  44 */       if (b <= 23 || b >= 32)
/*     */       {
/*     */ 
/*     */         
/*  48 */         if (b <= 126 || b >= '¡')
/*     */         {
/*     */ 
/*     */           
/*  52 */           if (b != '­')
/*     */           {
/*     */ 
/*     */ 
/*     */             
/*  57 */             a(b, (char)b);
/*     */           }
/*     */         }
/*     */       }
/*     */     } 
/*  62 */     a(24, '˘');
/*  63 */     a(25, 'ˇ');
/*  64 */     a(26, 'ˆ');
/*  65 */     a(27, '˙');
/*  66 */     a(28, '˝');
/*  67 */     a(29, '˛');
/*  68 */     a(30, '˚');
/*  69 */     a(31, '˜');
/*     */     
/*  71 */     a(127, '�');
/*  72 */     a(128, '•');
/*  73 */     a(129, '†');
/*  74 */     a(130, '‡');
/*  75 */     a(131, '…');
/*  76 */     a(132, '—');
/*  77 */     a(133, '–');
/*  78 */     a(134, 'ƒ');
/*  79 */     a(135, '⁄');
/*  80 */     a(136, '‹');
/*  81 */     a(137, '›');
/*  82 */     a(138, '−');
/*  83 */     a(139, '‰');
/*  84 */     a(140, '„');
/*  85 */     a(141, '“');
/*  86 */     a(142, '”');
/*  87 */     a(143, '‘');
/*  88 */     a(144, '’');
/*  89 */     a(145, '‚');
/*  90 */     a(146, '™');
/*  91 */     a(147, 'ﬁ');
/*  92 */     a(148, 'ﬂ');
/*  93 */     a(149, 'Ł');
/*  94 */     a(150, 'Œ');
/*  95 */     a(151, 'Š');
/*  96 */     a(152, 'Ÿ');
/*  97 */     a(153, 'Ž');
/*  98 */     a(154, 'ı');
/*  99 */     a(155, 'ł');
/* 100 */     a(156, 'œ');
/* 101 */     a(157, 'š');
/* 102 */     a(158, 'ž');
/* 103 */     a(159, '�');
/* 104 */     a(160, '€');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(int paramInt, char paramChar) {
/* 114 */     a[paramInt] = paramChar;
/* 115 */     b.put(Character.valueOf(paramChar), Integer.valueOf(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String a(byte[] paramArrayOfbyte) {
/* 123 */     StringBuilder stringBuilder = new StringBuilder(); int i; byte b;
/* 124 */     for (i = (paramArrayOfbyte = paramArrayOfbyte).length, b = 0; b < i; b++) {
/*     */       byte b1;
/* 126 */       if (((b1 = paramArrayOfbyte[b]) & 0xFF) >= a.length) {
/*     */         
/* 128 */         stringBuilder.append('?');
/*     */       }
/*     */       else {
/*     */         
/* 132 */         stringBuilder.append((char)a[b1 & 0xFF]);
/*     */       } 
/*     */     } 
/* 135 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] a(String paramString) {
/* 143 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); char[] arrayOfChar; int i; byte b;
/* 144 */     for (i = (arrayOfChar = paramString.toCharArray()).length, b = 0; b < i; ) { char c = arrayOfChar[b];
/*     */       
/*     */       Integer integer;
/* 147 */       if ((integer = b.get(Character.valueOf(c))) == null) {
/*     */         
/* 149 */         byteArrayOutputStream.write(0);
/*     */       }
/*     */       else {
/*     */         
/* 153 */         byteArrayOutputStream.write(integer.intValue());
/*     */       }  b++; }
/*     */     
/* 156 */     return byteArrayOutputStream.toByteArray();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean a(char paramChar) {
/* 166 */     return b.containsKey(Character.valueOf(paramChar));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\b\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */