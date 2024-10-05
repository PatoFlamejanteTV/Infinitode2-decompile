/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.GlyphLayout;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Base64Coder;
/*     */ import com.badlogic.gdx.utils.ByteArray;
/*     */ import com.badlogic.gdx.utils.IntIntMap;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.math.BigInteger;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.util.regex.Pattern;
/*     */ import java.util.zip.DataFormatException;
/*     */ import java.util.zip.Deflater;
/*     */ import java.util.zip.Inflater;
/*     */ 
/*     */ public class StringFormatter {
/*     */   public static final String DISTINGUISHABLE_STRING_CHARS = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";
/*     */   
/*  25 */   public enum MeasureUnits { tiles,
/*  26 */     degrees_per_second,
/*  27 */     tiles_per_second,
/*  28 */     seconds,
/*  29 */     percent,
/*  30 */     units_per_second,
/*  31 */     percent_per_second,
/*  32 */     degrees; static {
/*     */     
/*  34 */     } public static final MeasureUnits[] values = values(); }
/*     */ 
/*     */ 
/*     */   
/*  38 */   public static final IntIntMap DIST_STRING_CHAR_TO_IDX = new IntIntMap(); static {
/*     */     byte b;
/*  40 */     for (b = 0; b < 32; b++) {
/*  41 */       DIST_STRING_CHAR_TO_IDX.put("23456789ABCDEFGHJKLMNPQRSTUVWXYZ".charAt(b), b);
/*     */     }
/*     */   }
/*     */   
/*  45 */   public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", 2);
/*     */   private static final String[] a;
/*     */   
/*     */   static {
/*  49 */     (a = new String[40])[0] = "";
/*  50 */     for (b = 1; b <= 3; ) { a[b] = (new String(new char[b])).replace("\000", "I"); b++; }
/*  51 */      a[4] = "IV";
/*  52 */     for (b = 5; b <= 8; ) { a[b] = "V" + a[b - 5]; b++; }
/*  53 */      a[9] = "IX";
/*  54 */     a[10] = "X";
/*  55 */     for (b = 11; b <= 39; ) { a[b] = (new String(new char[b / 10])).replace("\000", "X") + a[b % 10]; b++; }
/*     */   
/*     */   }
/*  58 */   private static final byte[] b = new byte[1024];
/*  59 */   private static final ByteArrayOutputStream c = new ByteArrayOutputStream();
/*  60 */   private static byte[] d = new byte[32];
/*  61 */   private static final Deflater e = new Deflater(1, true);
/*  62 */   private static final Inflater f = new Inflater(true);
/*     */   
/*  64 */   private static ByteArray g = new ByteArray(1024);
/*     */   
/*     */   private static MessageDigest h;
/*     */   private static GlyphLayout i;
/*  68 */   private static final char[] j = "0123456789ABCDEF".toCharArray();
/*     */   
/*     */   public static String bytesToHex(byte[] paramArrayOfbyte) {
/*  71 */     char[] arrayOfChar = new char[paramArrayOfbyte.length << 1];
/*  72 */     for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/*  73 */       int i = paramArrayOfbyte[b] & 0xFF;
/*  74 */       arrayOfChar[b << 1] = j[i >>> 4];
/*  75 */       arrayOfChar[(b << 1) + 1] = j[i & 0xF];
/*     */     } 
/*  77 */     return new String(arrayOfChar);
/*     */   }
/*     */   
/*     */   private static MessageDigest a() {
/*  81 */     if (h == null) {
/*     */       try {
/*  83 */         h = MessageDigest.getInstance("MD5");
/*  84 */       } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*  85 */         throw new RuntimeException("Failed to get MD5 digest", noSuchAlgorithmException);
/*     */       } 
/*     */     }
/*     */     
/*  89 */     return h;
/*     */   }
/*     */   
/*  92 */   private static final StringBuilder k = new StringBuilder();
/*     */   public static StringBuilder toUpperCase(CharSequence paramCharSequence) {
/*  94 */     k.setLength(0); byte b; int i;
/*  95 */     for (b = 0, i = paramCharSequence.length(); b < i; b++) {
/*  96 */       k.append(Character.toUpperCase(paramCharSequence.charAt(b)));
/*     */     }
/*     */     
/*  99 */     return k;
/*     */   }
/*     */   
/* 102 */   private static final StringBuilder l = new StringBuilder();
/*     */   public static StringBuilder toLowerCase(CharSequence paramCharSequence) {
/* 104 */     l.setLength(0); byte b; int i;
/* 105 */     for (b = 0, i = paramCharSequence.length(); b < i; b++) {
/* 106 */       l.append(Character.toLowerCase(paramCharSequence.charAt(b)));
/*     */     }
/*     */     
/* 109 */     return l;
/*     */   }
/*     */   
/* 112 */   private static final StringBuilder m = new StringBuilder();
/*     */ 
/*     */ 
/*     */   
/*     */   public static StringBuilder toRGB(Color paramColor) {
/* 117 */     int k = (int)(255.0F * paramColor.r);
/* 118 */     int m = (int)(255.0F * paramColor.g);
/* 119 */     int j = (int)(255.0F * paramColor.b);
/*     */ 
/*     */     
/* 122 */     String str = Integer.toHexString(j = (k << 16) + (m << 8) + j);
/* 123 */     m.setLength(0);
/* 124 */     m.append(str);
/* 125 */     for (int i = str.length(); i < 6; i++) {
/* 126 */       m.insert(0, '0');
/*     */     }
/*     */     
/* 129 */     return m;
/*     */   }
/*     */   
/*     */   public static StringBuilder digestTime(int paramInt) {
/* 133 */     return digestTimeWithZeroHours(paramInt, false);
/*     */   }
/*     */   
/* 136 */   private static final StringBuilder n = new StringBuilder();
/*     */   public static StringBuilder digestTimeWithZeroHours(int paramInt, boolean paramBoolean) {
/* 138 */     n.setLength(0);
/*     */     
/* 140 */     int i = paramInt / 60 / 60;
/* 141 */     int j = (paramInt - i * 60 * 60) / 60;
/* 142 */     paramInt %= 60;
/*     */     
/* 144 */     if (paramBoolean || i != 0) {
/* 145 */       if (i < 10) n.append('0'); 
/* 146 */       n.append(i).append(':');
/*     */     } 
/* 148 */     if (j < 10) n.append('0'); 
/* 149 */     n.append(j).append(':');
/* 150 */     if (paramInt < 10) n.append('0'); 
/* 151 */     n.append(paramInt);
/*     */     
/* 153 */     return n;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String timePassed(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/* 162 */     if (Config.isHeadless()) return ""; 
/* 163 */     if (paramInt <= 0) {
/* 164 */       return "-";
/*     */     }
/*     */     
/* 167 */     int i = paramInt / 60 / 60 / 24;
/* 168 */     if (paramBoolean2) {
/* 169 */       paramInt -= i * 60 * 60 * 24;
/*     */     }
/* 171 */     int j = paramInt / 60 / 60;
/* 172 */     int k = paramInt % 3600 / 60;
/* 173 */     paramInt %= 60;
/*     */     
/* 175 */     String str = "";
/*     */     
/* 177 */     if (paramBoolean2 && i != 0) {
/* 178 */       str = str + i + Game.i.localeManager.i18n.get("TIME_CHAR_DAY") + " ";
/*     */     }
/*     */     
/* 181 */     if (j != 0) {
/* 182 */       str = str + j + Game.i.localeManager.i18n.get("TIME_CHAR_HOUR") + " ";
/*     */     }
/*     */     
/* 185 */     if ((j > 0 || k != 0) && (
/* 186 */       k != 0 || paramBoolean1)) {
/* 187 */       str = str + k + Game.i.localeManager.i18n.get("TIME_CHAR_MINUTE") + " ";
/*     */     }
/*     */ 
/*     */     
/* 191 */     if (paramInt != 0 || paramBoolean1) {
/* 192 */       str = str + paramInt + Game.i.localeManager.i18n.get("TIME_CHAR_SECOND");
/*     */     }
/*     */     
/* 195 */     return str.trim();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(StringBuilder paramStringBuilder, double paramDouble1, int paramInt, double paramDouble2) {
/* 201 */     paramDouble2 /= 10.0D;
/* 202 */     int i = (int)(paramDouble1 / paramDouble2);
/* 203 */     paramStringBuilder.append(i);
/* 204 */     if (paramInt == 1) paramStringBuilder.append('.'); 
/* 205 */     paramDouble1 -= i * paramDouble2;
/*     */     
/* 207 */     paramDouble2 /= 10.0D;
/* 208 */     i = (int)(paramDouble1 / paramDouble2);
/* 209 */     paramStringBuilder.append(i);
/* 210 */     if (paramInt == 2) paramStringBuilder.append('.'); 
/* 211 */     paramDouble1 -= i * paramDouble2;
/*     */     
/* 213 */     paramDouble2 /= 10.0D;
/* 214 */     i = (int)(paramDouble1 / paramDouble2);
/* 215 */     paramStringBuilder.append(i);
/*     */   }
/*     */   
/* 218 */   private static final StringBuilder o = new StringBuilder();
/*     */   public static StringBuilder commaSeparatedNumber(long paramLong) {
/* 220 */     o.setLength(0);
/*     */     
/* 222 */     boolean bool = true;
/*     */     
/* 224 */     long l = 1000000000000000000L;
/* 225 */     while (l > 0L) {
/* 226 */       if (paramLong >= l) {
/* 227 */         long l1 = paramLong / l;
/* 228 */         paramLong -= l1 * l;
/* 229 */         if (bool) {
/* 230 */           o.append(l1);
/*     */         } else {
/* 232 */           if (l1 < 10L) {
/* 233 */             o.append("00");
/* 234 */           } else if (l1 < 100L) {
/* 235 */             o.append('0');
/*     */           } 
/* 237 */           o.append(l1);
/*     */         } 
/* 239 */         o.append(',');
/* 240 */         bool = false;
/* 241 */       } else if (!bool) {
/* 242 */         o.append("000");
/* 243 */         o.append(',');
/*     */       } 
/*     */       
/* 246 */       if ((l = l / 1000L) == 1L) {
/*     */         break;
/*     */       }
/*     */     } 
/* 250 */     if (!bool) {
/* 251 */       if (paramLong < 10L) {
/* 252 */         o.append("00");
/* 253 */       } else if (paramLong < 100L) {
/* 254 */         o.append('0');
/*     */       } 
/*     */     }
/* 257 */     o.append(paramLong);
/*     */     
/* 259 */     return o;
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
/*     */   public static StringBuilder compactNumberWithPrecision(double paramDouble, int paramInt) {
/* 278 */     return compactNumberWithPrecisionTrimZeros(paramDouble, paramInt, false);
/*     */   }
/*     */   
/* 281 */   private static final StringBuilder p = new StringBuilder();
/*     */   public static synchronized StringBuilder compactNumberWithPrecisionTrimZeros(double paramDouble, int paramInt, boolean paramBoolean) {
/* 283 */     p.setLength(0);
/* 284 */     if (Double.isInfinite(paramDouble)) {
/* 285 */       p.append("Inf");
/* 286 */       return p;
/*     */     } 
/* 288 */     if (Double.isNaN(paramDouble)) {
/* 289 */       p.append("NaN");
/* 290 */       return p;
/*     */     } 
/*     */     boolean bool;
/* 293 */     if (bool = (paramDouble < 0.0D) ? true : false) {
/* 294 */       paramDouble = -paramDouble;
/*     */     }
/*     */     
/* 297 */     byte b = 32;
/* 298 */     if (paramDouble < 10.0D && paramInt != 0) {
/*     */       
/* 300 */       paramDouble = StrictMath.round(paramDouble * 10000.0D) / 10000.0D;
/* 301 */       p.append(paramDouble);
/* 302 */       int i = paramInt + 2;
/* 303 */       if (p.length > i) p.setLength(i); 
/* 304 */     } else if (paramDouble < 100.0D && paramInt != 0) {
/*     */       
/* 306 */       paramDouble = StrictMath.round(paramDouble * 1000.0D) / 1000.0D;
/* 307 */       p.append(paramDouble);
/* 308 */       int i = paramInt + 3;
/* 309 */       if (p.length > i) p.setLength(i); 
/* 310 */     } else if (paramDouble < 1000.0D) {
/*     */       
/* 312 */       p.append(StrictMath.round(paramDouble));
/* 313 */     } else if (paramDouble < 10000.0D) {
/*     */       
/* 315 */       a(p, paramDouble, 1, 10000.0D);
/* 316 */       b = 75;
/* 317 */     } else if (paramDouble < 100000.0D) {
/*     */       
/* 319 */       a(p, paramDouble, 2, 100000.0D);
/* 320 */       b = 75;
/* 321 */     } else if (paramDouble < 1000000.0D) {
/*     */       
/* 323 */       a(p, paramDouble, 0, 1000000.0D);
/* 324 */       b = 75;
/* 325 */     } else if (paramDouble < 1.0E7D) {
/*     */       
/* 327 */       a(p, paramDouble, 1, 1.0E7D);
/* 328 */       b = 77;
/* 329 */     } else if (paramDouble < 1.0E8D) {
/*     */       
/* 331 */       a(p, paramDouble, 2, 1.0E8D);
/* 332 */       b = 77;
/* 333 */     } else if (paramDouble < 1.0E9D) {
/*     */       
/* 335 */       a(p, paramDouble, 0, 1.0E9D);
/* 336 */       b = 77;
/* 337 */     } else if (paramDouble < 1.0E10D) {
/*     */       
/* 339 */       a(p, paramDouble, 1, 1.0E10D);
/* 340 */       b = 66;
/* 341 */     } else if (paramDouble < 1.0E11D) {
/*     */       
/* 343 */       a(p, paramDouble, 2, 1.0E11D);
/* 344 */       b = 66;
/* 345 */     } else if (paramDouble < 1.0E12D) {
/*     */       
/* 347 */       a(p, paramDouble, 0, 1.0E12D);
/* 348 */       b = 66;
/* 349 */     } else if (paramDouble < 1.0E13D) {
/*     */       
/* 351 */       a(p, paramDouble, 1, 1.0E13D);
/* 352 */       b = 84;
/* 353 */     } else if (paramDouble < 1.0E14D) {
/*     */       
/* 355 */       a(p, paramDouble, 2, 1.0E14D);
/* 356 */       b = 84;
/* 357 */     } else if (paramDouble < 1.0E15D) {
/*     */       
/* 359 */       a(p, paramDouble, 0, 1.0E15D);
/* 360 */       b = 84;
/*     */     } else {
/*     */       
/* 363 */       double d = paramDouble;
/* 364 */       byte b1 = 0;
/*     */ 
/*     */       
/* 367 */       while (d >= 1.0E9D) {
/* 368 */         d /= 1.0E9D;
/* 369 */         b1 += true;
/*     */       } 
/*     */       
/* 372 */       while (d >= 1000000.0D) {
/* 373 */         d /= 1000000.0D;
/* 374 */         b1 += true;
/*     */       } 
/*     */       
/* 377 */       while (d >= 1000.0D) {
/* 378 */         d /= 10.0D;
/* 379 */         b1++;
/*     */       } 
/*     */       
/* 382 */       p.append((int)d).append('e').append(b1);
/*     */ 
/*     */       
/* 385 */       if (bool) {
/* 386 */         p.insert(0, '-');
/*     */       }
/* 388 */       return p;
/*     */     } 
/*     */     
/* 391 */     if (paramBoolean) {
/*     */       
/* 393 */       boolean bool1 = false; int i;
/* 394 */       for (i = 0; i < p.length; i++) {
/* 395 */         if (p.charAt(i) == '.') {
/* 396 */           bool1 = true;
/*     */           break;
/*     */         } 
/*     */       } 
/* 400 */       if (bool1) {
/* 401 */         for (i = p.length - 1; i >= 0; i--) {
/*     */           char c;
/* 403 */           if ((c = p.charAt(i)) == '.') {
/* 404 */             p.setLength(i); break;
/*     */           } 
/* 406 */           if (c != '0') {
/* 407 */             p.setLength(i + 1);
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/* 413 */     if (bool) {
/* 414 */       p.insert(0, '-');
/*     */     }
/* 416 */     if (b != 32) {
/* 417 */       p.append(b);
/*     */     }
/*     */     
/* 420 */     return p;
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
/* 460 */   private static final StringBuilder q = new StringBuilder();
/*     */   public static synchronized StringBuilder compactNumber(double paramDouble, boolean paramBoolean) {
/* 462 */     q.setLength(0);
/*     */     boolean bool;
/* 464 */     if (bool = (paramDouble < 0.0D) ? true : false) {
/* 465 */       paramDouble = -paramDouble;
/*     */     }
/*     */     
/* 468 */     if (paramDouble < 1.0D && paramBoolean) {
/*     */       
/* 470 */       paramDouble = StrictMath.round(paramDouble * 1000.0D) / 1000.0D;
/* 471 */       q.append(paramDouble);
/* 472 */       if (q.length > 5) q.setLength(5); 
/* 473 */     } else if (paramDouble < 100.0D && paramBoolean) {
/*     */       
/* 475 */       paramDouble = StrictMath.round(paramDouble * 1000.0D) / 1000.0D;
/* 476 */       q.append(paramDouble);
/* 477 */       if (q.length > 4) q.setLength(4); 
/* 478 */     } else if (paramDouble < 1000.0D) {
/*     */       
/* 480 */       q.append(StrictMath.round(paramDouble));
/* 481 */     } else if (paramDouble < 10000.0D) {
/*     */       
/* 483 */       a(q, paramDouble, 1, 10000.0D);
/* 484 */       q.append('K');
/* 485 */     } else if (paramDouble < 100000.0D) {
/*     */       
/* 487 */       a(q, paramDouble, 2, 100000.0D);
/* 488 */       q.append('K');
/* 489 */     } else if (paramDouble < 1000000.0D) {
/*     */       
/* 491 */       a(q, paramDouble, 0, 1000000.0D);
/* 492 */       q.append('K');
/* 493 */     } else if (paramDouble < 1.0E7D) {
/*     */       
/* 495 */       a(q, paramDouble, 1, 1.0E7D);
/* 496 */       q.append('M');
/* 497 */     } else if (paramDouble < 1.0E8D) {
/*     */       
/* 499 */       a(q, paramDouble, 2, 1.0E8D);
/* 500 */       q.append('M');
/* 501 */     } else if (paramDouble < 1.0E9D) {
/*     */       
/* 503 */       a(q, paramDouble, 0, 1.0E9D);
/* 504 */       q.append('M');
/* 505 */     } else if (paramDouble < 1.0E10D) {
/*     */       
/* 507 */       a(q, paramDouble, 1, 1.0E10D);
/* 508 */       q.append('B');
/* 509 */     } else if (paramDouble < 1.0E11D) {
/*     */       
/* 511 */       a(q, paramDouble, 2, 1.0E11D);
/* 512 */       q.append('B');
/* 513 */     } else if (paramDouble < 1.0E12D) {
/*     */       
/* 515 */       a(q, paramDouble, 0, 1.0E12D);
/* 516 */       q.append('B');
/* 517 */     } else if (paramDouble < 1.0E13D) {
/*     */       
/* 519 */       a(q, paramDouble, 1, 1.0E13D);
/* 520 */       q.append('T');
/* 521 */     } else if (paramDouble < 1.0E14D) {
/*     */       
/* 523 */       a(q, paramDouble, 2, 1.0E14D);
/* 524 */       q.append('T');
/* 525 */     } else if (paramDouble < 1.0E15D) {
/*     */       
/* 527 */       a(q, paramDouble, 0, 1.0E15D);
/* 528 */       q.append('T');
/*     */     } else {
/*     */       
/* 531 */       double d = paramDouble;
/* 532 */       byte b = 0;
/* 533 */       while (d >= 1000.0D) {
/* 534 */         d /= 10.0D;
/* 535 */         b++;
/*     */       } 
/*     */       
/* 538 */       q.append((int)d).append('e').append(b);
/*     */     } 
/* 540 */     if (bool) {
/* 541 */       q.insert(0, '-');
/*     */     }
/*     */     
/* 544 */     return q;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String romanNumber(int paramInt) {
/* 552 */     if (paramInt < 0 || paramInt >= a.length) {
/* 553 */       return "";
/*     */     }
/* 555 */     return a[paramInt];
/*     */   }
/*     */   
/*     */   public static String distinguishableString(int paramInt) {
/* 559 */     char[] arrayOfChar = new char[33];
/* 560 */     boolean bool = (paramInt < 0) ? true : false;
/* 561 */     byte b1 = 32;
/* 562 */     byte b2 = 32;
/*     */     
/* 564 */     if (!bool) {
/* 565 */       paramInt = -paramInt;
/*     */     }
/*     */     
/* 568 */     while (paramInt <= -b2) {
/* 569 */       arrayOfChar[b1--] = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ".charAt(-(paramInt % b2));
/* 570 */       paramInt /= b2;
/*     */     } 
/* 572 */     arrayOfChar[b1] = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ".charAt(-paramInt);
/*     */     
/* 574 */     if (bool) {
/* 575 */       arrayOfChar[--b1] = '-';
/*     */     }
/*     */     
/* 578 */     return new String(arrayOfChar, b1, 33 - b1);
/*     */   }
/*     */ 
/*     */   
/*     */   public static synchronized String toCompactBase64(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 583 */     if (d.length < paramArrayOfbyte.length) {
/* 584 */       d = new byte[MathUtils.nextPowerOfTwo(paramArrayOfbyte.length)];
/*     */     }
/*     */     
/* 587 */     e.setInput(paramArrayOfbyte, paramInt1, paramInt2);
/* 588 */     e.finish();
/* 589 */     int i = e.deflate(d);
/* 590 */     e.reset();
/*     */     
/* 592 */     return new String(Base64Coder.encode(d, 0, i, Base64Coder.regularMap));
/*     */   }
/*     */   
/*     */   public static synchronized String toBase64(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 596 */     return new String(Base64Coder.encode(paramArrayOfbyte, paramInt1, paramInt2, Base64Coder.regularMap));
/*     */   }
/*     */   
/*     */   public static synchronized ByteArray compactBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 600 */     if (d.length < paramArrayOfbyte.length) {
/* 601 */       d = new byte[MathUtils.nextPowerOfTwo(paramArrayOfbyte.length)];
/*     */     }
/*     */     
/* 604 */     e.setInput(paramArrayOfbyte, paramInt1, paramInt2);
/* 605 */     e.finish();
/* 606 */     int i = e.deflate(d);
/* 607 */     e.reset();
/*     */     
/* 609 */     g.clear();
/* 610 */     g.addAll(d, 0, i);
/* 611 */     return g;
/*     */   }
/*     */   
/*     */   public static synchronized ByteArrayOutputStream fromCompactBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*     */     try {
/* 616 */       c.reset();
/*     */       
/* 618 */       f.setInput(paramArrayOfbyte, paramInt1, paramInt2); int i;
/* 619 */       while (!f.finished() && (
/*     */         
/* 621 */         i = f.inflate(b)) != 0)
/*     */       {
/* 623 */         c.write(b, 0, i);
/*     */       }
/*     */       
/* 626 */       f.reset();
/*     */       
/* 628 */       return c;
/* 629 */     } catch (DataFormatException dataFormatException) {
/* 630 */       throw new IllegalArgumentException("Failed to read compact base64", dataFormatException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static synchronized byte[] fromCompactBase64(String paramString) {
/*     */     try {
/* 636 */       c.reset();
/*     */       
/* 638 */       byte[] arrayOfByte = Base64Coder.decode(paramString);
/*     */       
/* 640 */       f.reset();
/* 641 */       f.setInput(arrayOfByte, 0, arrayOfByte.length); int i;
/* 642 */       while (!f.finished() && (
/*     */         
/* 644 */         i = f.inflate(b)) != 0)
/*     */       {
/* 646 */         c.write(b, 0, i);
/*     */       }
/*     */       
/* 649 */       f.reset();
/*     */       
/* 651 */       return c.toByteArray();
/* 652 */     } catch (DataFormatException dataFormatException) {
/* 653 */       throw new IllegalArgumentException("Failed to read compact base64", dataFormatException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static synchronized byte[] fromBase64(String paramString) {
/*     */     try {
/* 659 */       return Base64Coder.decode(paramString);
/* 660 */     } catch (Exception exception) {
/* 661 */       throw new IllegalArgumentException("Failed to read base64", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static synchronized String stringToCompactBase64(String paramString) {
/* 667 */     byte[] arrayOfByte = paramString.getBytes();
/* 668 */     if (d.length < arrayOfByte.length) {
/* 669 */       d = new byte[MathUtils.nextPowerOfTwo(arrayOfByte.length)];
/*     */     }
/*     */     
/* 672 */     e.setInput(arrayOfByte, 0, arrayOfByte.length);
/* 673 */     e.finish();
/* 674 */     int i = e.deflate(d);
/* 675 */     e.reset();
/*     */     
/* 677 */     return new String(Base64Coder.encode(d, 0, i, Base64Coder.regularMap));
/*     */   }
/*     */   
/*     */   public static synchronized String stringFromCompactBase64(String paramString) {
/*     */     try {
/* 682 */       c.reset();
/*     */       
/* 684 */       byte[] arrayOfByte = Base64Coder.decode(paramString);
/* 685 */       f.setInput(arrayOfByte, 0, arrayOfByte.length); int i;
/* 686 */       while (!f.finished() && (
/*     */         
/* 688 */         i = f.inflate(b)) != 0)
/*     */       {
/* 690 */         c.write(b, 0, i);
/*     */       }
/* 692 */       f.reset();
/*     */       
/* 694 */       return c.toString();
/* 695 */     } catch (DataFormatException dataFormatException) {
/* 696 */       throw new IllegalArgumentException("Failed to read compact base64", dataFormatException);
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
/*     */   public static synchronized String md5Hash(String paramString) {
/*     */     MessageDigest messageDigest;
/* 713 */     (messageDigest = a()).reset();
/* 714 */     messageDigest.update(paramString.getBytes());
/* 715 */     byte[] arrayOfByte = messageDigest.digest();
/*     */     
/* 717 */     BigInteger bigInteger = new BigInteger(1, arrayOfByte);
/* 718 */     StringBuilder stringBuilder = new StringBuilder(bigInteger.toString(16));
/* 719 */     while (stringBuilder.length() < 32) {
/* 720 */       stringBuilder.insert(0, "0");
/*     */     }
/*     */     
/* 723 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static synchronized String bytesMd5Hash(byte[] paramArrayOfbyte) {
/*     */     MessageDigest messageDigest;
/* 728 */     (messageDigest = a()).reset();
/* 729 */     messageDigest.update(paramArrayOfbyte);
/* 730 */     paramArrayOfbyte = messageDigest.digest();
/*     */     
/* 732 */     BigInteger bigInteger = new BigInteger(1, paramArrayOfbyte);
/* 733 */     StringBuilder stringBuilder = new StringBuilder(bigInteger.toString(16));
/* 734 */     while (stringBuilder.length() < 32) {
/* 735 */       stringBuilder.insert(0, "0");
/*     */     }
/*     */     
/* 738 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static byte[] md5HashToBytes(String paramString) {
/*     */     MessageDigest messageDigest;
/* 743 */     (messageDigest = a()).reset();
/* 744 */     messageDigest.update(paramString.getBytes());
/* 745 */     return messageDigest.digest();
/*     */   }
/*     */   
/*     */   public static float calculateWidth(CharSequence paramCharSequence, BitmapFont paramBitmapFont) {
/* 749 */     if (i == null) {
/* 750 */       i = new GlyphLayout(paramBitmapFont, "");
/*     */     }
/*     */     GlyphLayout glyphLayout;
/* 753 */     (glyphLayout = i).setText(paramBitmapFont, paramCharSequence);
/*     */     
/* 755 */     return glyphLayout.width;
/*     */   }
/*     */   
/* 758 */   private static final StringBuilder r = new StringBuilder();
/*     */   
/*     */   public static CharSequence fitToWidth(CharSequence paramCharSequence1, float paramFloat, BitmapFont paramBitmapFont, CharSequence paramCharSequence2) {
/* 761 */     if (i == null) {
/* 762 */       i = new GlyphLayout(paramBitmapFont, "");
/*     */     }
/*     */     
/*     */     GlyphLayout glyphLayout;
/* 766 */     (glyphLayout = i).setText(paramBitmapFont, paramCharSequence1);
/* 767 */     if (glyphLayout.width <= paramFloat)
/*     */     {
/* 769 */       return paramCharSequence1;
/*     */     }
/*     */     
/* 772 */     r.setLength(0);
/* 773 */     r.append(paramCharSequence2);
/*     */     
/* 775 */     glyphLayout.setText(paramBitmapFont, (CharSequence)r);
/* 776 */     float f = glyphLayout.width;
/*     */     
/* 778 */     r.setLength(0);
/*     */ 
/*     */     
/* 781 */     for (byte b = 0; b < paramCharSequence1.length(); b++) {
/* 782 */       char c = paramCharSequence1.charAt(b);
/* 783 */       boolean bool = (paramCharSequence1.length() > b + 1) ? paramCharSequence1.charAt(b + 1) : true;
/* 784 */       if (c == '[' && bool == 35) {
/*     */         
/* 786 */         while (b < paramCharSequence1.length()) {
/* 787 */           c = paramCharSequence1.charAt(b);
/* 788 */           r.append(paramCharSequence1.charAt(b));
/* 789 */           b++;
/* 790 */           if (c == ']')
/*     */             break; 
/*     */         } 
/*     */         continue;
/*     */       } 
/* 795 */       if (c == '[' && bool == 93) {
/*     */         
/* 797 */         r.append("[]");
/* 798 */         b += 2;
/*     */         
/*     */         continue;
/*     */       } 
/* 802 */       r.append(c);
/*     */       
/* 804 */       glyphLayout.setText(paramBitmapFont, (CharSequence)r);
/* 805 */       if (glyphLayout.width + f < paramFloat) {
/*     */         continue;
/*     */       }
/*     */     } 
/*     */     
/* 810 */     r.append(paramCharSequence2);
/*     */ 
/*     */     
/* 813 */     return (CharSequence)r;
/*     */   }
/*     */   
/* 816 */   private static final char[] s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
/*     */   
/* 818 */   private static final StringBuilder t = new StringBuilder();
/*     */   public static StringBuilder intToString(int paramInt) {
/* 820 */     t.setLength(0);
/* 821 */     int i = s.length;
/* 822 */     while (paramInt >= i) {
/* 823 */       t.append(s[paramInt % i]);
/* 824 */       paramInt /= i;
/*     */     } 
/* 826 */     t.append(s[paramInt % i]);
/*     */     
/* 828 */     return t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String shortenFirstWord(String paramString) {
/* 835 */     StringBuilder stringBuilder = new StringBuilder();
/* 836 */     boolean bool = false;
/* 837 */     for (byte b = 0; b < paramString.length(); b++) {
/*     */       char c;
/* 839 */       switch (c = paramString.charAt(b)) {
/*     */         case 'a':
/*     */         case 'e':
/*     */         case 'i':
/*     */         case 'o':
/*     */         case 'u':
/*     */         case 'y':
/* 846 */           bool = true;
/*     */           break;
/*     */         
/*     */         default:
/* 850 */           if (bool && (
/* 851 */             Character.isUpperCase(c) || c == '.' || c == '_' || c == '-' || c == ' ')) {
/*     */             
/* 853 */             stringBuilder.append(paramString.subSequence(b, paramString.length()));
/*     */             
/*     */             break;
/*     */           } 
/* 857 */           stringBuilder.append(c);
/*     */           break;
/*     */       } 
/*     */ 
/*     */     
/*     */     } 
/* 863 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CharSequence stripTerminalColors(String paramString) {
/* 872 */     if (!paramString.contains("\033")) {
/* 873 */       return paramString;
/*     */     }
/* 875 */     StringBuilder stringBuilder = new StringBuilder();
/* 876 */     boolean bool = false;
/* 877 */     for (byte b = 0; b < paramString.length(); b++) {
/*     */       char c;
/* 879 */       if ((c = paramString.charAt(b)) == '\033') {
/* 880 */         bool = true;
/*     */       }
/* 882 */       else if (!bool) {
/* 883 */         stringBuilder.append(c);
/*     */       }
/* 885 */       else if (c == 'm') {
/* 886 */         bool = false;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 891 */     return stringBuilder;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\StringFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */