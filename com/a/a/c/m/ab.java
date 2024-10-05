/*     */ package com.a.a.c.m;
/*     */ 
/*     */ import com.a.a.b.c.h;
/*     */ import java.text.DateFormat;
/*     */ import java.text.FieldPosition;
/*     */ import java.text.ParseException;
/*     */ import java.text.ParsePosition;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.Locale;
/*     */ import java.util.TimeZone;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ab
/*     */   extends DateFormat
/*     */ {
/*  50 */   private static Pattern b = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d");
/*     */   
/*     */   private static Pattern c;
/*     */   
/*     */   static {
/*     */     try {
/*  56 */       Pattern pattern = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d[T]\\d\\d[:]\\d\\d(?:[:]\\d\\d)?(\\.\\d+)?(Z|[+-]\\d\\d(?:[:]?\\d\\d)?)?");
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*  61 */     catch (Throwable throwable) {
/*  62 */       throw new RuntimeException(throwable);
/*     */     } 
/*  64 */     c = (Pattern)throwable;
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
/*  89 */   private static String[] d = new String[] { "yyyy-MM-dd'T'HH:mm:ss.SSSX", "yyyy-MM-dd'T'HH:mm:ss.SSS", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 102 */   private static TimeZone e = TimeZone.getTimeZone("UTC");
/*     */ 
/*     */   
/* 105 */   private static Locale f = Locale.US;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static DateFormat g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 117 */     (g = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", f)).setTimeZone(e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 123 */   public static final ab a = new ab();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 132 */   private static Calendar h = new GregorianCalendar(e, f);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient TimeZone i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Locale j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Boolean k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient Calendar l;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient DateFormat m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean n = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ab() {
/* 178 */     this.j = f;
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
/*     */   private ab(TimeZone paramTimeZone, Locale paramLocale, Boolean paramBoolean, boolean paramBoolean1) {
/* 196 */     this.i = paramTimeZone;
/* 197 */     this.j = paramLocale;
/* 198 */     this.k = paramBoolean;
/* 199 */     this.n = paramBoolean1;
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
/*     */   public final ab a(TimeZone paramTimeZone) {
/* 211 */     if (paramTimeZone == null) {
/* 212 */       paramTimeZone = e;
/*     */     }
/* 214 */     if (paramTimeZone == this.i || paramTimeZone.equals(this.i)) {
/* 215 */       return this;
/*     */     }
/* 217 */     return new ab(paramTimeZone, this.j, this.k, this.n);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ab a(Locale paramLocale) {
/* 227 */     if (paramLocale.equals(this.j)) {
/* 228 */       return this;
/*     */     }
/* 230 */     return new ab(this.i, paramLocale, this.k, this.n);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ab a(Boolean paramBoolean) {
/* 241 */     if (a(paramBoolean, this.k)) {
/* 242 */       return this;
/*     */     }
/* 244 */     return new ab(this.i, this.j, paramBoolean, this.n);
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
/*     */   private ab b() {
/* 271 */     return new ab(this.i, this.j, this.k, this.n);
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
/*     */   public TimeZone getTimeZone() {
/* 313 */     return this.i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimeZone(TimeZone paramTimeZone) {
/* 321 */     if (!paramTimeZone.equals(this.i)) {
/* 322 */       c();
/* 323 */       this.i = paramTimeZone;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLenient(boolean paramBoolean) {
/*     */     Boolean bool;
/* 335 */     if (!a(bool = Boolean.valueOf(paramBoolean), this.k)) {
/* 336 */       this.k = bool;
/*     */       
/* 338 */       c();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLenient() {
/* 345 */     return (this.k == null || this.k.booleanValue());
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
/*     */   public Date parse(String paramString) {
/* 375 */     paramString = paramString.trim();
/* 376 */     ParsePosition parsePosition = new ParsePosition(0);
/*     */     Date date;
/* 378 */     if ((date = a(paramString, parsePosition)) != null) {
/* 379 */       return date;
/*     */     }
/* 381 */     StringBuilder stringBuilder = new StringBuilder(); String[] arrayOfString; int i; byte b;
/* 382 */     for (i = (arrayOfString = d).length, b = 0; b < i; ) { String str = arrayOfString[b];
/* 383 */       if (stringBuilder.length() > 0) {
/* 384 */         stringBuilder.append("\", \"");
/*     */       } else {
/* 386 */         stringBuilder.append('"');
/*     */       } 
/* 388 */       stringBuilder.append(str); b++; }
/*     */     
/* 390 */     stringBuilder.append('"');
/* 391 */     throw new ParseException(
/* 392 */         String.format("Cannot parse date \"%s\": not compatible with any of standard forms (%s)", new Object[] {
/* 393 */             paramString, stringBuilder.toString() }), parsePosition.getErrorIndex());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date parse(String paramString, ParsePosition paramParsePosition) {
/*     */     try {
/* 401 */       return a(paramString, paramParsePosition);
/* 402 */     } catch (ParseException parseException) {
/*     */ 
/*     */       
/* 405 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private Date a(String paramString, ParsePosition paramParsePosition) {
/* 410 */     if (a(paramString)) {
/* 411 */       return c(paramString, paramParsePosition);
/*     */     }
/*     */     
/* 414 */     int i = paramString.length();
/* 415 */     while (--i >= 0) {
/*     */       char c;
/* 417 */       if ((c = paramString.charAt(i)) < '0' || c > '9') {
/*     */         
/* 419 */         if (i <= 0 && c == '-')
/*     */           continue; 
/*     */         break;
/*     */       } 
/*     */     } 
/* 424 */     if (i < 0 && (paramString
/*     */       
/* 426 */       .charAt(0) == '-' || h.a(paramString, false))) {
/* 427 */       return b(paramString, paramParsePosition);
/*     */     }
/*     */     
/* 430 */     return d(paramString, paramParsePosition);
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
/*     */   public StringBuffer format(Date paramDate, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition) {
/*     */     TimeZone timeZone;
/* 444 */     if ((timeZone = this.i) == null) {
/* 445 */       timeZone = e;
/*     */     }
/* 447 */     a(timeZone, paramDate, paramStringBuffer);
/* 448 */     return paramStringBuffer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(TimeZone paramTimeZone, Date paramDate, StringBuffer paramStringBuffer) {
/*     */     Calendar calendar;
/* 455 */     (calendar = b(paramTimeZone)).setTime(paramDate);
/*     */     
/* 457 */     int j = calendar.get(1);
/*     */ 
/*     */     
/* 460 */     if (calendar.get(0) == 0) {
/* 461 */       a(paramStringBuffer, j);
/*     */     } else {
/* 463 */       if (j > 9999)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 469 */         paramStringBuffer.append('+');
/*     */       }
/* 471 */       d(paramStringBuffer, j);
/*     */     } 
/* 473 */     paramStringBuffer.append('-');
/* 474 */     b(paramStringBuffer, calendar.get(2) + 1);
/* 475 */     paramStringBuffer.append('-');
/* 476 */     b(paramStringBuffer, calendar.get(5));
/* 477 */     paramStringBuffer.append('T');
/* 478 */     b(paramStringBuffer, calendar.get(11));
/* 479 */     paramStringBuffer.append(':');
/* 480 */     b(paramStringBuffer, calendar.get(12));
/* 481 */     paramStringBuffer.append(':');
/* 482 */     b(paramStringBuffer, calendar.get(13));
/* 483 */     paramStringBuffer.append('.');
/* 484 */     c(paramStringBuffer, calendar.get(14));
/*     */     
/*     */     int i;
/* 487 */     if ((i = paramTimeZone.getOffset(calendar.getTimeInMillis())) != 0) {
/* 488 */       j = Math.abs(i / 60000 / 60);
/* 489 */       int k = Math.abs(i / 60000 % 60);
/* 490 */       paramStringBuffer.append((i < 0) ? 45 : 43);
/* 491 */       b(paramStringBuffer, j);
/* 492 */       if (this.n) {
/* 493 */         paramStringBuffer.append(':');
/*     */       }
/* 495 */       b(paramStringBuffer, k);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 502 */     if (this.n) {
/* 503 */       paramStringBuffer.append("+00:00"); return;
/*     */     } 
/* 505 */     paramStringBuffer.append("+0000");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(StringBuffer paramStringBuffer, int paramInt) {
/* 513 */     if (paramInt == 1) {
/* 514 */       paramStringBuffer.append("+0000");
/*     */       return;
/*     */     } 
/* 517 */     paramInt--;
/* 518 */     paramStringBuffer.append('-');
/*     */ 
/*     */ 
/*     */     
/* 522 */     d(paramStringBuffer, paramInt);
/*     */   }
/*     */   
/*     */   private static void b(StringBuffer paramStringBuffer, int paramInt) {
/*     */     int i;
/* 527 */     if ((i = paramInt / 10) == 0) {
/* 528 */       paramStringBuffer.append('0');
/*     */     } else {
/* 530 */       paramStringBuffer.append((char)(i + 48));
/* 531 */       paramInt -= i * 10;
/*     */     } 
/* 533 */     paramStringBuffer.append((char)(paramInt + 48));
/*     */   }
/*     */   
/*     */   private static void c(StringBuffer paramStringBuffer, int paramInt) {
/*     */     int i;
/* 538 */     if ((i = paramInt / 100) == 0) {
/* 539 */       paramStringBuffer.append('0');
/*     */     } else {
/* 541 */       paramStringBuffer.append((char)(i + 48));
/* 542 */       paramInt -= i * 100;
/*     */     } 
/* 544 */     b(paramStringBuffer, paramInt);
/*     */   }
/*     */   
/*     */   private static void d(StringBuffer paramStringBuffer, int paramInt) {
/*     */     int i;
/* 549 */     if ((i = paramInt / 100) == 0) {
/* 550 */       paramStringBuffer.append('0').append('0');
/*     */     } else {
/* 552 */       if (i > 99) {
/* 553 */         paramStringBuffer.append(i);
/*     */       } else {
/* 555 */         b(paramStringBuffer, i);
/*     */       } 
/* 557 */       paramInt -= i * 100;
/*     */     } 
/* 559 */     b(paramStringBuffer, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 570 */     return String.format("DateFormat %s: (timezone: %s, locale: %s, lenient: %s)", new Object[] {
/* 571 */           getClass().getName(), this.i, this.j, this.k });
/*     */   }
/*     */   
/*     */   public final String a() {
/*     */     StringBuilder stringBuilder;
/* 576 */     (stringBuilder = new StringBuilder(100)).append("[one of: 'yyyy-MM-dd'T'HH:mm:ss.SSSX")
/*     */       
/* 578 */       .append("', 'EEE, dd MMM yyyy HH:mm:ss zzz")
/*     */       
/* 580 */       .append("' (");
/*     */     
/* 582 */     stringBuilder.append(Boolean.FALSE.equals(this.k) ? "strict" : "lenient")
/*     */       
/* 584 */       .append(")]");
/* 585 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 590 */     return (paramObject == this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 595 */     return System.identityHashCode(this);
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
/*     */   private static boolean a(String paramString) {
/* 610 */     if (paramString.length() >= 7 && 
/* 611 */       Character.isDigit(paramString.charAt(0)) && 
/* 612 */       Character.isDigit(paramString.charAt(3)) && paramString
/* 613 */       .charAt(4) == '-' && 
/* 614 */       Character.isDigit(paramString.charAt(5)))
/*     */     {
/* 616 */       return true;
/*     */     }
/* 618 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static Date b(String paramString, ParsePosition paramParsePosition) {
/*     */     long l;
/*     */     try {
/* 625 */       l = h.b(paramString);
/* 626 */     } catch (NumberFormatException numberFormatException) {
/* 627 */       throw new ParseException(String.format("Timestamp value %s out of 64-bit value range", new Object[] { paramString }), paramParsePosition
/*     */           
/* 629 */           .getErrorIndex());
/*     */     } 
/* 631 */     return new Date(l);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Date c(String paramString, ParsePosition paramParsePosition) {
/*     */     try {
/* 638 */       return b(paramString);
/* 639 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 640 */       throw new ParseException(String.format("Cannot parse date \"%s\", problem: %s", new Object[] { paramString, illegalArgumentException
/* 641 */               .getMessage()
/* 642 */             }), paramParsePosition.getErrorIndex());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private Date b(String paramString) {
/*     */     String str;
/* 649 */     int i = paramString.length();
/*     */     
/* 651 */     TimeZone timeZone = e;
/* 652 */     if (this.i != null && 'Z' != paramString.charAt(i - 1)) {
/* 653 */       timeZone = this.i;
/*     */     }
/*     */     Calendar calendar;
/* 656 */     (calendar = b(timeZone)).clear();
/*     */     
/* 658 */     if (i <= 10) {
/*     */       Matcher matcher;
/* 660 */       if ((matcher = b.matcher(paramString)).matches()) {
/* 661 */         int j = a(paramString, 0);
/* 662 */         int k = b(paramString, 5) - 1;
/* 663 */         int m = b(paramString, 8);
/*     */         
/* 665 */         calendar.set(j, k, m, 0, 0, 0);
/* 666 */         calendar.set(14, 0);
/* 667 */         return calendar.getTime();
/*     */       } 
/* 669 */       str = "yyyy-MM-dd";
/*     */     } else {
/*     */       Matcher matcher;
/* 672 */       if ((matcher = c.matcher(paramString)).matches()) {
/*     */ 
/*     */         
/* 675 */         int j, k = matcher.start(2);
/*     */         
/*     */         int m, n;
/* 678 */         if ((n = (m = matcher.end(2)) - k) > 1) {
/*     */           
/* 680 */           int i3 = b(paramString, k + 1) * 3600;
/* 681 */           if (n >= 5) {
/* 682 */             i3 += b(paramString, m - 2) * 60;
/*     */           }
/* 684 */           if (paramString.charAt(k) == '-') {
/* 685 */             i3 *= -1000;
/*     */           } else {
/* 687 */             i3 *= 1000;
/*     */           } 
/* 689 */           calendar.set(15, i3);
/*     */           
/* 691 */           calendar.set(16, 0);
/*     */         } 
/*     */         
/* 694 */         int i1 = a(paramString, 0);
/* 695 */         k = b(paramString, 5) - 1;
/* 696 */         m = b(paramString, 8);
/*     */ 
/*     */         
/* 699 */         n = b(paramString, 11);
/* 700 */         int i2 = b(paramString, 14);
/*     */ 
/*     */ 
/*     */         
/* 704 */         if (str > '\020' && paramString.charAt(16) == ':') {
/* 705 */           j = b(paramString, 17);
/*     */         } else {
/* 707 */           j = 0;
/*     */         } 
/* 709 */         calendar.set(i1, k, m, n, i2, j);
/*     */ 
/*     */         
/* 712 */         k = matcher.start(1) + 1;
/* 713 */         m = matcher.end(1);
/*     */         
/* 715 */         if (k >= m) {
/* 716 */           calendar.set(14, 0);
/*     */         } else {
/*     */           
/* 719 */           j = 0;
/*     */           
/* 721 */           switch (m = m - k) {
/*     */             
/*     */             default:
/* 724 */               if (m > 9) {
/* 725 */                 throw new ParseException(String.format("Cannot parse date \"%s\": invalid fractional seconds '%s'; can use at most 9 digits", new Object[] { paramString, matcher
/*     */                         
/* 727 */                         .group(1).substring(1) }), k);
/*     */               }
/*     */ 
/*     */             
/*     */             case 3:
/* 732 */               j = 0 + paramString.charAt(k + 2) - 48;
/*     */             case 2:
/* 734 */               j += 10 * (paramString.charAt(k + 1) - 48);
/*     */             case 1:
/* 736 */               j += 100 * (paramString.charAt(k) - 48);
/*     */               break;
/*     */             case 0:
/*     */               break;
/*     */           } 
/* 741 */           calendar.set(14, j);
/*     */         } 
/* 743 */         return calendar.getTime();
/*     */       } 
/* 745 */       str = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
/*     */     } 
/*     */     
/* 748 */     throw new ParseException(
/* 749 */         String.format("Cannot parse date \"%s\": while it seems to fit format '%s', parsing fails (leniency? %s)", new Object[] { paramString, str, this.k }), 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int a(String paramString, int paramInt) {
/* 757 */     return 1000 * (paramString.charAt(0) - 48) + 100 * (paramString
/* 758 */       .charAt(1) - 48) + 10 * (paramString
/* 759 */       .charAt(2) - 48) + paramString
/* 760 */       .charAt(3) - 48;
/*     */   }
/*     */   
/*     */   private static int b(String paramString, int paramInt) {
/* 764 */     return 10 * (paramString.charAt(paramInt) - 48) + paramString
/* 765 */       .charAt(paramInt + 1) - 48;
/*     */   }
/*     */ 
/*     */   
/*     */   private Date d(String paramString, ParsePosition paramParsePosition) {
/* 770 */     if (this.m == null) {
/* 771 */       this.m = a(g, "EEE, dd MMM yyyy HH:mm:ss zzz", this.i, this.j, this.k);
/*     */     }
/*     */     
/* 774 */     return this.m.parse(paramString, paramParsePosition);
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
/*     */   private static final DateFormat a(DateFormat paramDateFormat, String paramString, TimeZone paramTimeZone, Locale paramLocale, Boolean paramBoolean) {
/* 786 */     if (!paramLocale.equals(f)) {
/*     */       
/* 788 */       (paramDateFormat = new SimpleDateFormat(paramString, paramLocale)).setTimeZone((paramTimeZone == null) ? e : paramTimeZone);
/*     */     } else {
/* 790 */       paramDateFormat = (DateFormat)paramDateFormat.clone();
/* 791 */       if (paramTimeZone != null) {
/* 792 */         paramDateFormat.setTimeZone(paramTimeZone);
/*     */       }
/*     */     } 
/* 795 */     if (paramBoolean != null) {
/* 796 */       paramDateFormat.setLenient(paramBoolean.booleanValue());
/*     */     }
/* 798 */     return paramDateFormat;
/*     */   }
/*     */   
/*     */   private void c() {
/* 802 */     this.m = null;
/*     */   }
/*     */   
/*     */   private Calendar b(TimeZone paramTimeZone) {
/*     */     Calendar calendar;
/* 807 */     if ((calendar = this.l) == null) {
/* 808 */       this.l = calendar = (Calendar)h.clone();
/*     */     }
/* 810 */     if (!calendar.getTimeZone().equals(paramTimeZone)) {
/* 811 */       calendar.setTimeZone(paramTimeZone);
/*     */     }
/* 813 */     calendar.setLenient(isLenient());
/* 814 */     return calendar;
/*     */   }
/*     */   
/*     */   private static <T> boolean a(T paramT1, T paramT2) {
/* 818 */     if (paramT1 == paramT2) {
/* 819 */       return true;
/*     */     }
/* 821 */     return (paramT1 != null && paramT1.equals(paramT2));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\ab.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */