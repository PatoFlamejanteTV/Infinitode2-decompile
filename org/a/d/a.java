/*     */ package org.a.d;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.Locale;
/*     */ import java.util.SimpleTimeZone;
/*     */ import java.util.TimeZone;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.xml.bind.DatatypeConverter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class a
/*     */ {
/*  56 */   private static final SimpleDateFormat[] a = new SimpleDateFormat[] { new SimpleDateFormat("EEEE, dd MMM yyyy hh:mm:ss a"), new SimpleDateFormat("EEEE, MMM dd, yyyy hh:mm:ss a"), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz"), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S") };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Calendar a(String paramString) {
/*  85 */     GregorianCalendar gregorianCalendar = null;
/*  86 */     if (paramString != null && paramString.trim().length() > 0) {
/*     */ 
/*     */       
/*  89 */       int i = 1;
/*  90 */       int j = 1;
/*  91 */       int k = 0;
/*  92 */       int m = 0;
/*  93 */       int n = 0;
/*     */ 
/*     */       
/*     */       try {
/*  97 */         SimpleTimeZone simpleTimeZone = null;
/*     */         
/*  99 */         if (Pattern.matches("^\\d{4}-\\d{2}-\\d{2}T.*", paramString))
/*     */         {
/*     */           
/* 102 */           return b(paramString);
/*     */         }
/* 104 */         if (paramString.startsWith("D:"))
/*     */         {
/* 106 */           paramString = paramString.substring(2, paramString.length());
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 111 */         if ((paramString = paramString.replaceAll("[-:T]", "")).length() < 4)
/*     */         {
/* 113 */           throw new IOException("Error: Invalid date format '" + paramString + "'");
/*     */         }
/* 115 */         int i1 = Integer.parseInt(paramString.substring(0, 4));
/* 116 */         if (paramString.length() >= 6)
/*     */         {
/* 118 */           i = Integer.parseInt(paramString.substring(4, 6));
/*     */         }
/* 120 */         if (paramString.length() >= 8)
/*     */         {
/* 122 */           j = Integer.parseInt(paramString.substring(6, 8));
/*     */         }
/* 124 */         if (paramString.length() >= 10)
/*     */         {
/* 126 */           k = Integer.parseInt(paramString.substring(8, 10));
/*     */         }
/* 128 */         if (paramString.length() >= 12)
/*     */         {
/* 130 */           m = Integer.parseInt(paramString.substring(10, 12));
/*     */         }
/*     */         
/* 133 */         byte b = 12;
/* 134 */         if (paramString.length() - 12 > 5 || (paramString.length() - 12 == 3 && paramString.endsWith("Z"))) {
/*     */           
/* 136 */           if (paramString.length() >= 14)
/*     */           {
/* 138 */             n = Integer.parseInt(paramString.substring(12, 14));
/*     */           }
/* 140 */           b = 14;
/*     */         }
/*     */         else {
/*     */           
/* 144 */           n = 0;
/*     */         } 
/*     */         
/* 147 */         if (paramString.length() >= b + 1) {
/*     */           char c;
/*     */           
/* 150 */           if ((c = paramString.charAt(b)) == 'Z') {
/*     */             
/* 152 */             simpleTimeZone = new SimpleTimeZone(0, "Unknown");
/*     */           }
/*     */           else {
/*     */             
/* 156 */             int i2 = 0;
/* 157 */             int i3 = 0;
/* 158 */             if (paramString.length() >= b + 3)
/*     */             {
/* 160 */               if (simpleTimeZone == 43) {
/*     */ 
/*     */                 
/* 163 */                 i2 = Integer.parseInt(paramString.substring(b + 1, b + 3));
/*     */               }
/*     */               else {
/*     */                 
/* 167 */                 i2 = -Integer.parseInt(paramString.substring(b, b + 2));
/*     */               } 
/*     */             }
/* 170 */             if (simpleTimeZone == 43) {
/*     */               
/* 172 */               if (paramString.length() >= b + 5)
/*     */               {
/* 174 */                 i3 = Integer.parseInt(paramString.substring(b + 3, b + 5));
/*     */               
/*     */               }
/*     */             
/*     */             }
/* 179 */             else if (paramString.length() >= b + 4) {
/*     */               
/* 181 */               i3 = Integer.parseInt(paramString.substring(b + 2, b + 4));
/*     */             } 
/*     */             
/* 184 */             simpleTimeZone = new SimpleTimeZone(i2 * 60 * 60 * 1000 + i3 * 60 * 1000, "Unknown");
/*     */           } 
/*     */         } 
/*     */         
/* 188 */         if (simpleTimeZone == null) {
/*     */           
/* 190 */           gregorianCalendar = new GregorianCalendar();
/*     */         }
/*     */         else {
/*     */           
/* 194 */           a(simpleTimeZone);
/* 195 */           gregorianCalendar = new GregorianCalendar(simpleTimeZone);
/*     */         } 
/* 197 */         gregorianCalendar.clear();
/* 198 */         gregorianCalendar.set(i1, i - 1, j, k, m, n);
/*     */       }
/* 200 */       catch (NumberFormatException numberFormatException) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 205 */         if (paramString.substring(paramString.length() - 3, paramString.length() - 2).equals(":") && (paramString
/* 206 */           .substring(paramString.length() - 6, paramString.length() - 5).equals("+") || paramString.substring(paramString
/* 207 */             .length() - 6, paramString.length() - 5).equals("-")))
/*     */         {
/*     */           
/* 210 */           paramString = paramString.substring(0, paramString.length() - 3) + paramString.substring(paramString.length() - 2);
/*     */         }
/* 212 */         for (byte b = 0; gregorianCalendar == null && b < a.length; b++) {
/*     */ 
/*     */           
/*     */           try {
/* 216 */             Date date = a[b].parse(paramString);
/*     */             
/* 218 */             (gregorianCalendar = new GregorianCalendar()).setTime(date);
/*     */           }
/* 220 */           catch (ParseException parseException) {}
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 225 */         if (gregorianCalendar == null)
/*     */         {
/*     */           
/* 228 */           throw new IOException("Error converting date:" + paramString, numberFormatException);
/*     */         }
/*     */       } 
/*     */     } 
/* 232 */     return gregorianCalendar;
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
/* 244 */     int i = paramTimeZone.getRawOffset();
/* 245 */     byte b = 43;
/* 246 */     if (i < 0) {
/*     */       
/* 248 */       b = 45;
/* 249 */       i = -i;
/*     */     } 
/* 251 */     int j = i / 3600000;
/* 252 */     int k = i % 3600000 / 60000;
/* 253 */     if (i == 0) {
/*     */       
/* 255 */       paramTimeZone.setID("GMT"); return;
/*     */     } 
/* 257 */     if (b == 43 && j <= 12) {
/*     */       
/* 259 */       paramTimeZone.setID(String.format(Locale.US, "GMT+%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) })); return;
/*     */     } 
/* 261 */     if (b == 45 && j <= 14) {
/*     */       
/* 263 */       paramTimeZone.setID(String.format(Locale.US, "GMT-%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) }));
/*     */       
/*     */       return;
/*     */     } 
/* 267 */     paramTimeZone.setID("unknown");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Calendar b(String paramString) {
/*     */     Calendar calendar;
/*     */     String str1;
/*     */     Pattern pattern;
/* 352 */     Matcher matcher = (pattern = Pattern.compile("[\\d-]*T?[\\d-\\.]([A-Z]{1,4})$|(.*\\d*)([A-Z][a-z]+\\/[A-Z][a-z]+)$")).matcher(paramString);
/*     */     
/* 354 */     String str2 = null;
/*     */     
/* 356 */     while (matcher.find()) {
/*     */       
/* 358 */       for (byte b = 1; b <= matcher.groupCount(); b++) {
/*     */         
/* 360 */         if (matcher.group(b) != null)
/*     */         {
/* 362 */           str2 = matcher.group(b);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 367 */     if (str2 != null) {
/*     */ 
/*     */       
/* 370 */       int n = paramString.indexOf('T');
/* 371 */       int m = paramString.indexOf(str2);
/* 372 */       String str = paramString.substring(0, m);
/* 373 */       if (m - n == 6)
/*     */       {
/* 375 */         str = paramString.substring(0, m) + ":00";
/*     */       }
/* 377 */       calendar = DatatypeConverter.parseDateTime(str);
/*     */       
/* 379 */       TimeZone timeZone = TimeZone.getTimeZone(str2);
/* 380 */       calendar.setTimeZone(timeZone);
/* 381 */       return calendar;
/*     */     } 
/*     */ 
/*     */     
/*     */     int j;
/*     */     
/* 387 */     if ((j = calendar.indexOf('T')) == -1)
/*     */     {
/* 389 */       return DatatypeConverter.parseDateTime((String)calendar);
/*     */     }
/* 391 */     int i = calendar.indexOf('+', j + 1);
/* 392 */     int k = calendar.indexOf('-', j + 1);
/* 393 */     if (i == -1 && k == -1)
/*     */     {
/* 395 */       return DatatypeConverter.parseDateTime((String)calendar);
/*     */     }
/*     */     
/* 398 */     if ((i = Math.max(i, k)) - j == 6)
/*     */     {
/*     */       
/* 401 */       return DatatypeConverter.parseDateTime(str1 = calendar.substring(0, i) + ":00" + calendar.substring(i));
/*     */     }
/* 403 */     return DatatypeConverter.parseDateTime(str1);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */