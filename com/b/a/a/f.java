/*     */ package com.b.a.a;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.CharBuffer;
/*     */ import java.nio.MappedByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class f
/*     */ {
/*     */   private static final List<c> a;
/*     */   
/*     */   private static final class b
/*     */   {
/*     */     static final class a
/*     */       implements f.a
/*     */     {
/*     */       private a() {}
/*     */       
/*     */       public final boolean a(byte[] param2ArrayOfbyte) {
/*     */         return (param2ArrayOfbyte[0] == 1);
/*     */       }
/*     */     }
/*     */     
/*  47 */     private static final a a = new a((byte)0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static boolean a(ByteBuffer param1ByteBuffer) {
/*     */       try {
/*  55 */         f.b(param1ByteBuffer, 1131245124, a);
/*  56 */       } catch (IOException iOException) {
/*  57 */         return false;
/*     */       } 
/*     */       int i;
/*  60 */       if ((i = param1ByteBuffer.getInt(param1ByteBuffer.position())) <= 0) {
/*  61 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  66 */       if (param1ByteBuffer.position() + 4 + i * 24 > param1ByteBuffer.capacity()) {
/*  67 */         return false;
/*     */       }
/*  69 */       if (!a(param1ByteBuffer, b(param1ByteBuffer, 0)) || 
/*  70 */         !a(param1ByteBuffer, b(param1ByteBuffer, i - 1))) {
/*  71 */         return false;
/*     */       }
/*  73 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     private static boolean a(ByteBuffer param1ByteBuffer, int param1Int) {
/*  78 */       int i = 8 - 1; byte b1;
/*  79 */       for (b1 = 0; b1 < i; b1++) {
/*  80 */         if (param1ByteBuffer.get(param1Int + b1) != "icudt59b".charAt(b1)) {
/*  81 */           return false;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/*  86 */       if (((b1 = param1ByteBuffer.get(param1Int + i++)) != 98 && b1 != 108) || param1ByteBuffer.get(param1Int + i) != 47) {
/*  87 */         return false;
/*     */       }
/*  89 */       return true;
/*     */     } static {
/*     */     
/*     */     } static ByteBuffer a(ByteBuffer param1ByteBuffer, CharSequence param1CharSequence) {
/*     */       int i;
/*  94 */       if ((i = b(param1ByteBuffer, param1CharSequence)) >= 0) {
/*     */         ByteBuffer byteBuffer;
/*  96 */         (byteBuffer = param1ByteBuffer.duplicate()).position(c(param1ByteBuffer, i));
/*  97 */         byteBuffer.limit(c(param1ByteBuffer, i + 1));
/*  98 */         return f.a(byteBuffer);
/*     */       } 
/* 100 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static int b(ByteBuffer param1ByteBuffer, CharSequence param1CharSequence) {
/* 120 */       int i = param1ByteBuffer.position();
/* 121 */       i = param1ByteBuffer.getInt(i);
/*     */ 
/*     */       
/* 124 */       int j = 0;
/* 125 */       i = i;
/* 126 */       while (j < i) {
/* 127 */         int k = j + i >>> 1;
/*     */ 
/*     */         
/* 130 */         int m = (m = b(param1ByteBuffer, k)) + 8 + 1;
/*     */         
/* 132 */         if ((m = f.a(param1CharSequence, param1ByteBuffer, m)) < 0) {
/* 133 */           i = k; continue;
/* 134 */         }  if (m > 0) {
/* 135 */           j = k + 1;
/*     */           continue;
/*     */         } 
/* 138 */         return k;
/*     */       } 
/*     */       
/* 141 */       return j ^ 0xFFFFFFFF;
/*     */     }
/*     */     
/*     */     private static int b(ByteBuffer param1ByteBuffer, int param1Int) {
/* 145 */       int i = param1ByteBuffer.position();
/* 146 */       if (!b && (param1Int < 0 || param1Int >= param1ByteBuffer.getInt(i))) throw new AssertionError();
/*     */ 
/*     */       
/* 149 */       return i + param1ByteBuffer.getInt(i + 4 + (param1Int << 3));
/*     */     }
/*     */     
/*     */     private static int c(ByteBuffer param1ByteBuffer, int param1Int) {
/* 153 */       int i = param1ByteBuffer.position();
/* 154 */       int j = param1ByteBuffer.getInt(i);
/* 155 */       if (param1Int == j)
/*     */       {
/* 157 */         return param1ByteBuffer.capacity();
/*     */       }
/* 159 */       if (!b && (param1Int < 0 || param1Int >= j)) throw new AssertionError();
/*     */ 
/*     */ 
/*     */       
/* 163 */       return i + param1ByteBuffer.getInt(i + 4 + 4 + (param1Int << 3));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static abstract class c
/*     */   {
/*     */     protected final String a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     c(String param1String) {
/* 204 */       this.a = param1String;
/*     */     }
/*     */     
/*     */     public String toString() {
/* 208 */       return this.a;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     abstract ByteBuffer a(String param1String);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class e
/*     */     extends c
/*     */   {
/*     */     private final File b;
/*     */ 
/*     */ 
/*     */     
/*     */     e(String param1String, File param1File) {
/* 226 */       super(param1String);
/* 227 */       this.b = param1File;
/*     */     }
/*     */     
/*     */     public final String toString() {
/* 231 */       return this.b.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     final ByteBuffer a(String param1String) {
/* 236 */       if (param1String.equals(this.a)) {
/* 237 */         return f.a(this.b);
/*     */       }
/* 239 */       return null;
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
/*     */   private static final class d
/*     */     extends c
/*     */   {
/*     */     private final ByteBuffer b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     d(String param1String, ByteBuffer param1ByteBuffer) {
/* 265 */       super(param1String);
/* 266 */       this.b = param1ByteBuffer;
/*     */     }
/*     */ 
/*     */     
/*     */     final ByteBuffer a(String param1String) {
/* 271 */       return f.b.a(this.b, param1String);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 280 */     a = new ArrayList<c>();
/*     */ 
/*     */     
/*     */     String str;
/*     */     
/* 285 */     if ((str = g.a(f.class.getName() + ".dataPath")) != null) {
/* 286 */       c(str);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void c(String paramString) {
/* 296 */     byte b = 0;
/* 297 */     while (b < paramString.length()) {
/*     */       int j;
/*     */       int i;
/* 300 */       if ((i = paramString.indexOf(File.pathSeparatorChar, b)) >= 0) {
/* 301 */         j = i;
/*     */       } else {
/* 303 */         j = paramString.length();
/*     */       } 
/*     */       String str;
/* 306 */       if ((str = paramString.substring(b, j).trim()).endsWith(File.separator)) {
/* 307 */         str = str.substring(0, str.length() - 1);
/*     */       }
/* 309 */       if (str.length() != 0) {
/* 310 */         a(new File(str), new StringBuilder(), a);
/*     */       }
/* 312 */       if (i >= 0)
/*     */       {
/*     */         
/* 315 */         int k = i + 1;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void a(File paramFile, StringBuilder paramStringBuilder, List<c> paramList) {
/*     */     File[] arrayOfFile;
/* 322 */     if ((arrayOfFile = paramFile.listFiles()) == null || arrayOfFile.length == 0) {
/*     */       return;
/*     */     }
/*     */     int i;
/* 326 */     if ((i = paramStringBuilder.length()) > 0) {
/*     */ 
/*     */ 
/*     */       
/* 330 */       paramStringBuilder.append('/');
/* 331 */       i++;
/*     */     }  int j; byte b;
/* 333 */     for (j = (arrayOfFile = arrayOfFile).length, b = 0; b < j; b++) {
/*     */       File file; String str;
/* 335 */       if (!(str = (file = arrayOfFile[b]).getName()).endsWith(".txt")) {
/*     */ 
/*     */         
/* 338 */         paramStringBuilder.append(str);
/* 339 */         if (file.isDirectory())
/*     */         
/* 341 */         { a(file, paramStringBuilder, paramList); }
/* 342 */         else { ByteBuffer byteBuffer; if (str.endsWith(".dat")) {
/*     */             
/* 344 */             if ((byteBuffer = b(file)) != null && b.a(byteBuffer)) {
/* 345 */               paramList.add(new d(paramStringBuilder.toString(), byteBuffer));
/*     */             }
/*     */           } else {
/* 348 */             paramList.add(new e(paramStringBuilder.toString(), (File)byteBuffer));
/*     */           }  }
/* 350 */          paramStringBuilder.setLength(i);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static int a(CharSequence paramCharSequence, ByteBuffer paramByteBuffer, int paramInt) {
/* 359 */     for (byte b = 0;; b++, paramInt++) {
/*     */       byte b1;
/* 361 */       if ((b1 = paramByteBuffer.get(paramInt)) == 0) {
/* 362 */         if (b == paramCharSequence.length()) {
/* 363 */           return 0;
/*     */         }
/* 365 */         return 1;
/*     */       } 
/* 367 */       if (b == paramCharSequence.length()) {
/* 368 */         return -1;
/*     */       }
/*     */       int i;
/* 371 */       if ((i = paramCharSequence.charAt(b) - b1) != 0) {
/* 372 */         return i;
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer a(String paramString) {
/* 423 */     return a(null, null, paramString, false);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer b(String paramString) {
/* 449 */     return a(null, null, paramString, true);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ByteBuffer a(ClassLoader paramClassLoader, String paramString1, String paramString2, boolean paramBoolean) {
/*     */     ByteBuffer byteBuffer;
/* 483 */     if ((byteBuffer = d(paramString2)) != null) {
/* 484 */       return byteBuffer;
/*     */     }
/* 486 */     if (paramClassLoader == null) {
/* 487 */       paramClassLoader = d.a(i.class);
/*     */     }
/* 489 */     if (paramString1 == null) {
/* 490 */       paramString1 = "com/ibm/icu/impl/data/icudt59b/" + paramString2;
/*     */     }
/*     */     
/*     */     try {
/*     */       InputStream inputStream;
/*     */       
/* 496 */       if ((inputStream = i.a(paramClassLoader, paramString1, paramBoolean)) == null) {
/* 497 */         return null;
/*     */       }
/* 499 */       ByteBuffer byteBuffer1 = a(inputStream);
/* 500 */     } catch (IOException iOException) {
/* 501 */       throw new com.b.a.d.c(iOException);
/*     */     } 
/* 503 */     return (ByteBuffer)iOException;
/*     */   }
/*     */   
/*     */   private static ByteBuffer d(String paramString) {
/* 507 */     for (Iterator<c> iterator = a.iterator(); iterator.hasNext();) {
/*     */       
/* 509 */       if ((byteBuffer = (c = iterator.next()).a(paramString)) != null) {
/* 510 */         return byteBuffer;
/*     */       }
/*     */     } 
/* 513 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static ByteBuffer b(File paramFile) {
/*     */     try {
/*     */       FileInputStream fileInputStream;
/* 521 */       null = (fileInputStream = new FileInputStream(paramFile)).getChannel();
/*     */       
/*     */       try {
/* 524 */         MappedByteBuffer mappedByteBuffer = null.map(FileChannel.MapMode.READ_ONLY, 0L, null.size());
/*     */       } finally {
/* 526 */         fileInputStream.close();
/*     */       } 
/* 528 */       return (ByteBuffer)SYNTHETIC_LOCAL_VARIABLE_1;
/* 529 */     } catch (FileNotFoundException fileNotFoundException) {
/* 530 */       System.err.println(fileNotFoundException);
/* 531 */     } catch (IOException iOException) {
/* 532 */       System.err.println(iOException);
/*     */     } 
/* 534 */     return null;
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
/*     */   public static com.b.a.d.d a(ByteBuffer paramByteBuffer, int paramInt, a parama) {
/* 556 */     return a(b(paramByteBuffer, paramInt, parama));
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
/*     */   public static int b(ByteBuffer paramByteBuffer, int paramInt, a parama) {
/* 573 */     if (!b && (paramByteBuffer == null || paramByteBuffer.position() != 0)) throw new AssertionError(); 
/* 574 */     byte b1 = paramByteBuffer.get(2);
/* 575 */     byte b2 = paramByteBuffer.get(3);
/* 576 */     if (b1 != -38 || b2 != 39) {
/* 577 */       throw new IOException("ICU data file error: Not an ICU data file");
/*     */     }
/*     */     
/* 580 */     b1 = paramByteBuffer.get(8);
/* 581 */     b2 = paramByteBuffer.get(9);
/* 582 */     byte b3 = paramByteBuffer.get(10);
/* 583 */     if (b1 < 0 || 1 < b1 || b2 != 0 || b3 != 2)
/*     */     {
/* 585 */       throw new IOException("ICU data file error: Header authentication failed, please check if you have a valid ICU data file");
/*     */     }
/* 587 */     paramByteBuffer.order((b1 != 0) ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
/*     */     
/* 589 */     char c1 = paramByteBuffer.getChar(0);
/*     */     char c2;
/* 591 */     if ((c2 = paramByteBuffer.getChar(4)) < '\024' || c1 < c2 + 4) {
/* 592 */       throw new IOException("Internal Error: Header size error");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 597 */     byte[] arrayOfByte = { paramByteBuffer.get(16), paramByteBuffer.get(17), paramByteBuffer.get(18), paramByteBuffer.get(19) };
/*     */     
/* 599 */     if (paramByteBuffer.get(12) != (byte)(paramInt >> 24) || paramByteBuffer
/* 600 */       .get(13) != (byte)(paramInt >> 16) || paramByteBuffer
/* 601 */       .get(14) != (byte)(paramInt >> 8) || paramByteBuffer
/* 602 */       .get(15) != (byte)paramInt || (parama != null && 
/* 603 */       !parama.a(arrayOfByte))) {
/* 604 */       throw new IOException("ICU data file error: Header authentication failed, please check if you have a valid ICU data file" + 
/* 605 */           String.format("; data format %02x%02x%02x%02x, format version %d.%d.%d.%d", new Object[] {
/* 606 */               Byte.valueOf(paramByteBuffer.get(12)), Byte.valueOf(paramByteBuffer.get(13)), Byte.valueOf(paramByteBuffer.get(14)), Byte.valueOf(paramByteBuffer.get(15)), 
/* 607 */               Integer.valueOf(arrayOfByte[0] & 0xFF), Integer.valueOf(arrayOfByte[1] & 0xFF), 
/* 608 */               Integer.valueOf(arrayOfByte[2] & 0xFF), Integer.valueOf(arrayOfByte[3] & 0xFF)
/*     */             }));
/*     */     }
/* 611 */     paramByteBuffer.position(c1);
/* 612 */     return paramByteBuffer
/* 613 */       .get(20) << 24 | (paramByteBuffer
/* 614 */       .get(21) & 0xFF) << 16 | (paramByteBuffer
/* 615 */       .get(22) & 0xFF) << 8 | paramByteBuffer
/* 616 */       .get(23) & 0xFF;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(ByteBuffer paramByteBuffer, int paramInt) {
/* 649 */     if (paramInt > 0) {
/* 650 */       paramByteBuffer.position(paramByteBuffer.position() + paramInt);
/*     */     }
/*     */   }
/*     */   
/*     */   public static String a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
/*     */     CharBuffer charBuffer;
/* 656 */     String str = (charBuffer = paramByteBuffer.asCharBuffer()).subSequence(0, paramInt1).toString();
/* 657 */     a(paramByteBuffer, paramInt1 << 1);
/* 658 */     return str;
/*     */   }
/*     */   
/*     */   public static char[] b(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
/* 662 */     char[] arrayOfChar = new char[paramInt1];
/* 663 */     paramByteBuffer.asCharBuffer().get(arrayOfChar);
/* 664 */     a(paramByteBuffer, paramInt1 << 1);
/* 665 */     return arrayOfChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int[] c(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
/* 676 */     int[] arrayOfInt = new int[paramInt1];
/* 677 */     paramByteBuffer.asIntBuffer().get(arrayOfInt);
/* 678 */     a(paramByteBuffer, paramInt1 << 2);
/* 679 */     return arrayOfInt;
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
/*     */   public static ByteBuffer a(ByteBuffer paramByteBuffer) {
/*     */     ByteBuffer byteBuffer;
/* 694 */     return (byteBuffer = paramByteBuffer.slice()).order(paramByteBuffer.order());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ByteBuffer a(InputStream paramInputStream) {
/*     */     try {
/*     */       byte[] arrayOfByte;
/*     */       int i;
/* 708 */       if ((i = paramInputStream.available()) > 32) {
/*     */ 
/*     */         
/* 711 */         arrayOfByte = new byte[i];
/*     */       } else {
/* 713 */         arrayOfByte = new byte[128];
/*     */       } 
/*     */       
/* 716 */       int j = 0;
/*     */       label28: while (true) {
/* 718 */         while (j < arrayOfByte.length) {
/*     */           int m;
/* 720 */           if ((m = paramInputStream.read(arrayOfByte, j, arrayOfByte.length - j)) >= 0) {
/*     */ 
/*     */             
/* 723 */             j += m; continue;
/*     */           }  break label28;
/*     */         } 
/*     */         int k;
/* 727 */         if ((k = paramInputStream.read()) >= 0) {
/*     */           int m;
/*     */ 
/*     */           
/* 731 */           if ((m = 2 * arrayOfByte.length) < 128) {
/* 732 */             m = 128;
/* 733 */           } else if (m < 16384) {
/* 734 */             m <<= 1;
/*     */           } 
/*     */           
/* 737 */           byte[] arrayOfByte1 = new byte[m];
/* 738 */           System.arraycopy(arrayOfByte, 0, arrayOfByte1, 0, j);
/*     */           
/* 740 */           (arrayOfByte = arrayOfByte1)[j++] = (byte)k; continue;
/*     */         }  break;
/*     */       } 
/* 743 */       return ByteBuffer.wrap(arrayOfByte, 0, j);
/*     */     } finally {
/* 745 */       paramInputStream.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static com.b.a.d.d a(int paramInt) {
/* 753 */     return com.b.a.d.d.a(paramInt >>> 24, paramInt >> 16 & 0xFF, paramInt >> 8 & 0xFF, paramInt & 0xFF);
/*     */   }
/*     */   
/*     */   public static interface a {
/*     */     boolean a(byte[] param1ArrayOfbyte);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\b\a\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */