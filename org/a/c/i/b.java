/*     */ package org.a.c.i;
/*     */ 
/*     */ import java.text.ParsePosition;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.Locale;
/*     */ import java.util.SimpleTimeZone;
/*     */ import java.util.TimeZone;
/*     */ import org.a.c.b.s;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class b
/*     */ {
/* 103 */   private static final String[] a = new String[] { "EEEE, dd MMM yy hh:mm:ss a", "EEEE, MMM dd, yy hh:mm:ss a", "EEEE, MMM dd, yy 'at' hh:mma", "EEEE, MMM dd, yy", "EEEE MMM dd, yy HH:mm:ss", "EEEE MMM dd HH:mm:ss z yy", "EEEE MMM dd HH:mm:ss yy" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 114 */   private static final String[] b = new String[] { "dd MMM yy HH:mm:ss", "dd MMM yy HH:mm", "yyyy MMM d", "yyyymmddhh:mm:ss", "H:m M/d/yy", "M/d/yy HH:mm:ss", "M/d/yy HH:mm", "M/d/yy" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String a(Calendar paramCalendar) {
/* 162 */     if (paramCalendar == null)
/*     */     {
/* 164 */       return null;
/*     */     }
/* 166 */     String str = a((paramCalendar.get(15) + paramCalendar
/* 167 */         .get(16)), "'");
/* 168 */     return String.format(Locale.US, "D:%1$4tY%1$2tm%1$2td%1$2tH%1$2tM%1$2tS%2$s'", new Object[] { paramCalendar, str });
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
/*     */   private static int a(long paramLong) {
/* 205 */     if (paramLong <= 50400000L && paramLong >= -50400000L)
/*     */     {
/*     */ 
/*     */       
/* 209 */       return (int)paramLong;
/*     */     }
/*     */ 
/*     */     
/* 213 */     if ((paramLong = ((paramLong + 43200000L) % 86400000L + 86400000L) % 86400000L) == 0L)
/*     */     {
/* 215 */       return 43200000;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 220 */     return (int)(paramLong = (paramLong - 43200000L) % 43200000L);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String a(long paramLong, String paramString) {
/*     */     SimpleDateFormat simpleDateFormat;
/* 284 */     (simpleDateFormat = new SimpleDateFormat("Z")).setTimeZone(new SimpleTimeZone(a(paramLong), "unknown"));
/* 285 */     String str = simpleDateFormat.format(new Date());
/* 286 */     return str.substring(0, 3) + paramString + str.substring(3);
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
/*     */   private static int a(String paramString, ParsePosition paramParsePosition, int paramInt1, int paramInt2) {
/* 304 */     if (paramString == null)
/*     */     {
/* 306 */       return paramInt2;
/*     */     }
/*     */ 
/*     */     
/* 310 */     int i = 0;
/*     */     int j;
/* 312 */     paramInt1 = (j = paramParsePosition.getIndex()) + Math.min(paramInt1, paramString.length() - j);
/* 313 */     while (j < paramInt1) {
/*     */       int k;
/*     */ 
/*     */ 
/*     */       
/* 318 */       if ((k = paramString.charAt(j) - 48) >= 0 && k <= 9) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 324 */         i = i * 10 + k; j++;
/*     */       } 
/* 326 */     }  if (j == paramParsePosition.getIndex())
/*     */     {
/* 328 */       return paramInt2;
/*     */     }
/* 330 */     paramParsePosition.setIndex(j);
/* 331 */     return i;
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
/*     */   private static char a(String paramString1, ParsePosition paramParsePosition, String paramString2) {
/* 346 */     byte b1 = 32; char c;
/* 347 */     while (paramString1 != null && paramParsePosition.getIndex() < paramString1.length() && paramString2
/* 348 */       .indexOf(c = paramString1.charAt(paramParsePosition.getIndex())) >= 0) {
/*     */       
/* 350 */       b1 = (c != ' ') ? c : b1;
/* 351 */       paramParsePosition.setIndex(paramParsePosition.getIndex() + 1);
/*     */     } 
/* 353 */     return b1;
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
/*     */   private static boolean a(String paramString1, String paramString2, ParsePosition paramParsePosition) {
/* 366 */     if (paramString1.startsWith(paramString2, paramParsePosition.getIndex())) {
/*     */       
/* 368 */       paramParsePosition.setIndex(paramParsePosition.getIndex() + paramString2.length());
/* 369 */       return true;
/*     */     } 
/* 371 */     return false;
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
/*     */   private static GregorianCalendar a() {
/*     */     GregorianCalendar gregorianCalendar;
/* 385 */     (gregorianCalendar = new GregorianCalendar(Locale.ENGLISH)).setTimeZone(new SimpleTimeZone(0, "UTC"));
/* 386 */     gregorianCalendar.setLenient(false);
/* 387 */     gregorianCalendar.set(14, 0);
/* 388 */     return gregorianCalendar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(GregorianCalendar paramGregorianCalendar, TimeZone paramTimeZone) {
/* 399 */     paramGregorianCalendar.setTimeZone(paramTimeZone);
/* 400 */     int i = (paramGregorianCalendar.get(15) + paramGregorianCalendar.get(16)) / 60000;
/*     */     
/* 402 */     paramGregorianCalendar.add(12, -i);
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
/*     */   private static boolean a(String paramString, GregorianCalendar paramGregorianCalendar, ParsePosition paramParsePosition) {
/* 427 */     ParsePosition parsePosition = new ParsePosition(paramParsePosition.getIndex());
/* 428 */     TimeZone timeZone = new SimpleTimeZone(0, "GMT");
/*     */ 
/*     */     
/*     */     boolean bool;
/*     */     
/* 433 */     char c = !(bool = ((c = a(paramString, parsePosition, "Z+- ")) == 'Z' || a(paramString, "GMT", parsePosition) || a(paramString, "UTC", parsePosition)) ? true : false) ? c : a(paramString, parsePosition, "+- ");
/*     */     
/* 435 */     int i = a(paramString, parsePosition, 2, -999);
/* 436 */     a(paramString, parsePosition, "': ");
/* 437 */     int j = a(paramString, parsePosition, 2, 0);
/* 438 */     a(paramString, parsePosition, "' ");
/*     */     
/* 440 */     if (i != -999) {
/*     */ 
/*     */       
/* 443 */       c = (c == '-') ? -1 : '\001';
/* 444 */       timeZone.setRawOffset(a(c * ((i * 3600000) + j * 60000L)));
/*     */       
/* 446 */       a(timeZone);
/*     */     }
/* 448 */     else if (!bool) {
/*     */       String str;
/*     */ 
/*     */       
/* 452 */       timeZone = TimeZone.getTimeZone(str = paramString.substring(paramParsePosition.getIndex()).trim());
/*     */       
/* 454 */       if ("GMT".equals(timeZone.getID()))
/*     */       {
/*     */         
/* 457 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 462 */       parsePosition.setIndex(paramString.length());
/*     */     } 
/*     */     
/* 465 */     a(paramGregorianCalendar, timeZone);
/* 466 */     paramParsePosition.setIndex(parsePosition.getIndex());
/* 467 */     return true;
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
/*     */   private static void a(TimeZone paramTimeZone) {
/* 479 */     int i = paramTimeZone.getRawOffset();
/* 480 */     byte b1 = 43;
/* 481 */     if (i < 0) {
/*     */       
/* 483 */       b1 = 45;
/* 484 */       i = -i;
/*     */     } 
/* 486 */     int j = i / 3600000;
/* 487 */     int k = i % 3600000 / 60000;
/* 488 */     if (i == 0) {
/*     */       
/* 490 */       paramTimeZone.setID("GMT"); return;
/*     */     } 
/* 492 */     if (b1 == 43 && j <= 12) {
/*     */       
/* 494 */       paramTimeZone.setID(String.format(Locale.US, "GMT+%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) })); return;
/*     */     } 
/* 496 */     if (b1 == 45 && j <= 14) {
/*     */       
/* 498 */       paramTimeZone.setID(String.format(Locale.US, "GMT-%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) }));
/*     */       
/*     */       return;
/*     */     } 
/* 502 */     paramTimeZone.setID("unknown");
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
/*     */   private static GregorianCalendar a(String paramString, ParsePosition paramParsePosition) {
/* 524 */     ParsePosition parsePosition = new ParsePosition(paramParsePosition.getIndex());
/* 525 */     int i = a(paramString, parsePosition, 4, 0);
/* 526 */     if (parsePosition.getIndex() != 4 + paramParsePosition.getIndex())
/*     */     {
/* 528 */       return null;
/*     */     }
/* 530 */     a(paramString, parsePosition, "/- ");
/* 531 */     int j = a(paramString, parsePosition, 2, 1) - 1;
/* 532 */     a(paramString, parsePosition, "/- ");
/* 533 */     int k = a(paramString, parsePosition, 2, 1);
/* 534 */     a(paramString, parsePosition, " T");
/* 535 */     int m = a(paramString, parsePosition, 2, 0);
/* 536 */     a(paramString, parsePosition, ": ");
/* 537 */     int n = a(paramString, parsePosition, 2, 0);
/* 538 */     a(paramString, parsePosition, ": ");
/* 539 */     int i1 = a(paramString, parsePosition, 2, 0);
/*     */     char c;
/* 541 */     if ((c = a(paramString, parsePosition, ".")) == '.')
/*     */     {
/*     */       
/* 544 */       a(paramString, parsePosition, 19, 0);
/*     */     }
/*     */     
/* 547 */     GregorianCalendar gregorianCalendar = a();
/*     */     
/*     */     try {
/* 550 */       gregorianCalendar.set(i, j, k, m, n, i1);
/*     */       
/* 552 */       gregorianCalendar.getTimeInMillis();
/*     */     }
/* 554 */     catch (IllegalArgumentException illegalArgumentException) {
/*     */       
/* 556 */       return null;
/*     */     } 
/* 558 */     paramParsePosition.setIndex(parsePosition.getIndex());
/* 559 */     a(paramString, paramParsePosition, " ");
/*     */     
/* 561 */     return gregorianCalendar;
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
/*     */   private static GregorianCalendar a(String paramString, String[] paramArrayOfString, ParsePosition paramParsePosition) {
/*     */     int i;
/*     */     byte b1;
/* 581 */     for (i = (paramArrayOfString = paramArrayOfString).length, b1 = 0; b1 < i; ) { String str = paramArrayOfString[b1];
/*     */       
/* 583 */       ParsePosition parsePosition = new ParsePosition(paramParsePosition.getIndex());
/* 584 */       SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.ENGLISH);
/* 585 */       GregorianCalendar gregorianCalendar = a();
/* 586 */       simpleDateFormat.setCalendar(gregorianCalendar);
/* 587 */       if (simpleDateFormat.parse(paramString, parsePosition) != null) {
/*     */         
/* 589 */         paramParsePosition.setIndex(parsePosition.getIndex());
/* 590 */         a(paramString, paramParsePosition, " ");
/* 591 */         return gregorianCalendar;
/*     */       }  b1++; }
/*     */     
/* 594 */     return null;
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
/*     */   private static Calendar b(String paramString, ParsePosition paramParsePosition) {
/* 617 */     if (paramString == null || paramString.isEmpty())
/*     */     {
/* 619 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 623 */     int i = -999999;
/*     */ 
/*     */ 
/*     */     
/* 627 */     GregorianCalendar gregorianCalendar1 = null;
/*     */ 
/*     */     
/* 630 */     ParsePosition parsePosition = new ParsePosition(paramParsePosition.getIndex());
/*     */     
/* 632 */     a(paramString, parsePosition, " ");
/* 633 */     int j = parsePosition.getIndex();
/*     */ 
/*     */     
/*     */     GregorianCalendar gregorianCalendar2;
/*     */     
/* 638 */     if ((gregorianCalendar2 = a(paramString, parsePosition)) != null && (parsePosition.getIndex() == paramString.length() || 
/* 639 */       a(paramString, gregorianCalendar2, parsePosition))) {
/*     */       int k;
/*     */ 
/*     */       
/* 643 */       if ((k = parsePosition.getIndex()) == paramString.length()) {
/*     */         
/* 645 */         paramParsePosition.setIndex(k);
/* 646 */         return gregorianCalendar2;
/*     */       } 
/* 648 */       i = k;
/* 649 */       gregorianCalendar1 = gregorianCalendar2;
/*     */     } 
/*     */ 
/*     */     
/* 653 */     parsePosition.setIndex(j);
/*     */     
/* 655 */     String[] arrayOfString = Character.isDigit(paramString.charAt(j)) ? b : a;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 660 */     if ((gregorianCalendar2 = a(paramString, arrayOfString, parsePosition)) != null && (parsePosition
/* 661 */       .getIndex() == paramString.length() || 
/* 662 */       a(paramString, gregorianCalendar2, parsePosition))) {
/*     */       int k;
/*     */ 
/*     */       
/* 666 */       if ((k = parsePosition.getIndex()) == paramString.length()) {
/*     */         
/* 668 */         paramParsePosition.setIndex(k);
/* 669 */         return gregorianCalendar2;
/*     */       } 
/* 671 */       if (k > i) {
/*     */         
/* 673 */         i = k;
/* 674 */         gregorianCalendar1 = gregorianCalendar2;
/*     */       } 
/*     */     } 
/*     */     
/* 678 */     if (gregorianCalendar1 != null) {
/*     */       
/* 680 */       paramParsePosition.setIndex(i);
/* 681 */       return gregorianCalendar1;
/*     */     } 
/* 683 */     return gregorianCalendar2;
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
/*     */   public static Calendar a(s params) {
/* 697 */     if (params == null)
/*     */     {
/* 699 */       return null;
/*     */     }
/* 701 */     return a(params.b());
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
/*     */   private static Calendar a(String paramString) {
/* 715 */     if (paramString == null || paramString.trim().isEmpty())
/*     */     {
/* 717 */       return null;
/*     */     }
/*     */     
/* 720 */     ParsePosition parsePosition = new ParsePosition(0);
/* 721 */     a(paramString, parsePosition, " ");
/* 722 */     a(paramString, "D:", parsePosition);
/*     */     
/*     */     Calendar calendar;
/* 725 */     if ((calendar = b(paramString, parsePosition)) == null || parsePosition.getIndex() != paramString.length())
/*     */     {
/*     */       
/* 728 */       return null;
/*     */     }
/* 730 */     return calendar;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\i\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */