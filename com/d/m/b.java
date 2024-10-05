/*     */ package com.d.m;
/*     */ 
/*     */ import com.a.a.b.c.a;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.lang.reflect.Field;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.LogRecord;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */ {
/*     */   private Properties a;
/*     */   private Level b;
/*     */   private static b c;
/* 111 */   private List d = new ArrayList();
/*     */   
/*     */   private Logger e;
/*     */   
/*     */   private b() {
/*     */     try {
/*     */       try {
/*     */         String str1;
/*     */         try {
/* 120 */           str1 = System.getProperty("show-config");
/* 121 */         } catch (SecurityException securityException) {
/*     */           
/* 123 */           str1 = null;
/*     */         } 
/* 125 */         this.b = Level.OFF;
/* 126 */         if (str1 != null) {
/* 127 */           this.b = a.a(str1, Level.OFF);
/*     */         }
/* 129 */       } catch (SecurityException securityException) {
/*     */         
/* 131 */         System.err.println(securityException.getLocalizedMessage());
/*     */       } 
/* 133 */       a();
/*     */       
/*     */       String str;
/* 136 */       if ((str = b()) != null) {
/* 137 */         g(str);
/*     */       
/*     */       }
/* 140 */       else if ((str = c()) != null) {
/* 141 */         g(str);
/*     */       } 
/*     */       
/* 144 */       d();
/* 145 */       e(); return;
/* 146 */     } catch (RuntimeException runtimeException2) {
/* 147 */       RuntimeException runtimeException1; a(runtimeException1 = null);
/* 148 */       throw runtimeException1;
/* 149 */     } catch (Exception exception2) {
/* 150 */       Exception exception1; a(exception1 = null);
/* 151 */       throw new RuntimeException(exception1);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void a(Exception paramException) {
/* 156 */     System.err.println("Could not initialize configuration for Flying Saucer library. Message is: " + paramException.getMessage());
/* 157 */     paramException.printStackTrace();
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
/*     */   public static void a(Logger paramLogger) {
/*     */     b b1;
/* 171 */     (b1 = f()).e = paramLogger;
/* 172 */     if (b1.d != null) {
/* 173 */       Iterator<LogRecord> iterator = b1.d.iterator();
/* 174 */       while (iterator.hasNext()) {
/* 175 */         LogRecord logRecord = iterator.next();
/* 176 */         paramLogger.log(logRecord.getLevel(), logRecord.getMessage());
/*     */       } 
/* 178 */       b1.d = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Level paramLevel, String paramString) {
/* 189 */     if (this.b != Level.OFF) {
/* 190 */       if (this.e == null) {
/* 191 */         this.d.add(new LogRecord(paramLevel, paramString)); return;
/*     */       } 
/* 193 */       this.e.log(paramLevel, paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(String paramString) {
/* 204 */     if (this.b.intValue() <= Level.INFO.intValue()) {
/* 205 */       a(Level.INFO, paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void d(String paramString) {
/* 215 */     if (this.b.intValue() <= Level.WARNING.intValue()) {
/* 216 */       a(Level.WARNING, paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(String paramString, Throwable paramThrowable) {
/* 227 */     d(paramString);
/* 228 */     paramThrowable.printStackTrace();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void e(String paramString) {
/* 237 */     if (this.b.intValue() <= Level.FINE.intValue()) {
/* 238 */       a(Level.FINE, paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void f(String paramString) {
/* 248 */     if (this.b.intValue() <= Level.FINER.intValue()) {
/* 249 */       a(Level.FINER, paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a() {
/*     */     
/* 258 */     try { InputStream inputStream = b.class.getResourceAsStream("/resources/conf/xhtmlrenderer.conf"); 
/* 259 */       try { if (inputStream == null) {
/* 260 */           System.err.println("WARNING: Flying Saucer: No configuration files found in classpath using URL: /resources/conf/xhtmlrenderer.conf, resorting to hard-coded fallback properties.");
/* 261 */           this.a = g();
/*     */         } else {
/* 263 */           this.a = new Properties();
/* 264 */           this.a.load(inputStream);
/* 265 */           c("Configuration loaded from /resources/conf/xhtmlrenderer.conf");
/*     */         } 
/* 267 */         if (inputStream != null) { inputStream.close(); } else { return; }  } catch (Throwable throwable) { if (inputStream != null) try { inputStream.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception exception)
/* 268 */     { throw new RuntimeException("Could not load properties file for configuration.", exception); }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void g(String paramString) {
/*     */     try {
/* 280 */       File file = new File(paramString);
/* 281 */       Properties properties = new Properties();
/* 282 */       if (file.exists()) {
/* 283 */         c("Found config override file " + file.getAbsolutePath());
/*     */         try {
/* 285 */           BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
/*     */           try {
/* 287 */             properties.load(bufferedInputStream);
/*     */           } finally {
/* 289 */             bufferedInputStream.close();
/*     */           } 
/* 291 */         } catch (IOException iOException) {
/* 292 */           a("Error while loading override properties file; skipping.", iOException); return;
/*     */         } 
/*     */       } else {
/*     */         BufferedInputStream bufferedInputStream;
/* 296 */         file = null;
/*     */         try {
/* 298 */           URL uRL = new URL(paramString);
/* 299 */           bufferedInputStream = new BufferedInputStream(uRL.openStream());
/* 300 */           c("Found config override URI " + paramString);
/* 301 */           properties.load(bufferedInputStream);
/* 302 */         } catch (MalformedURLException malformedURLException) {
/* 303 */           d("URI for override properties is malformed, skipping: " + paramString);
/*     */           return;
/* 305 */         } catch (IOException iOException) {
/* 306 */           a("Overridden properties could not be loaded from URI: " + paramString, iOException);
/*     */           return;
/*     */         } finally {
/* 309 */           if (bufferedInputStream != null) {
/* 310 */             try { bufferedInputStream.close(); }
/* 311 */             catch (IOException iOException) {}
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/*     */       Enumeration<Object> enumeration;
/*     */       
/*     */       ArrayList<Comparable> arrayList1;
/* 319 */       Collections.sort(arrayList1 = Collections.list(enumeration = this.a.keys()));
/* 320 */       Iterator<Comparable> iterator = arrayList1.iterator();
/*     */ 
/*     */       
/* 323 */       byte b1 = 0;
/* 324 */       while (iterator.hasNext()) {
/* 325 */         String str1 = (String)iterator.next();
/*     */         String str2;
/* 327 */         if ((str2 = properties.getProperty(str1)) != null) {
/* 328 */           this.a.setProperty(str1, str2);
/* 329 */           f("  " + str1 + " -> " + str2);
/* 330 */           b1++;
/*     */         } 
/*     */       } 
/* 333 */       f("Configuration: " + b1 + " properties overridden from secondary properties file.");
/*     */ 
/*     */       
/*     */       ArrayList<Comparable> arrayList2;
/*     */       
/* 338 */       Collections.sort(arrayList2 = Collections.list(enumeration = properties.keys()));
/* 339 */       iterator = arrayList2.iterator();
/* 340 */       b1 = 0;
/* 341 */       while (iterator.hasNext()) {
/* 342 */         String str1 = (String)iterator.next();
/*     */         String str2;
/* 344 */         if ((str2 = properties.getProperty(str1)) != null) {
/* 345 */           this.a.setProperty(str1, str2);
/* 346 */           f("  (+)" + str1 + " -> " + str2);
/* 347 */           b1++;
/*     */         } 
/*     */       } 
/* 350 */       f("Configuration: " + b1 + " properties added from secondary properties file."); return;
/* 351 */     } catch (SecurityException securityException) {
/*     */       
/* 353 */       System.err.println(securityException.getLocalizedMessage());
/*     */       return;
/*     */     } 
/*     */   }
/*     */   private static String b() {
/*     */     try {
/* 359 */       return System.getProperty("xr.conf");
/* 360 */     } catch (SecurityException securityException) {
/*     */       
/* 362 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static String c() {
/*     */     try {
/* 368 */       return System.getProperty("user.home") + File.separator + ".flyingsaucer" + File.separator + "local.xhtmlrenderer.conf";
/* 369 */     } catch (SecurityException securityException) {
/*     */       
/* 371 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void d() {
/*     */     Enumeration<Object> enumeration;
/*     */     ArrayList<Comparable> arrayList;
/* 382 */     Collections.sort(arrayList = Collections.list(enumeration = this.a.keys()));
/* 383 */     Iterator<Comparable> iterator = arrayList.iterator();
/* 384 */     e("Overriding loaded configuration from System properties.");
/* 385 */     byte b1 = 0;
/* 386 */     while (iterator.hasNext()) {
/*     */       String str;
/* 388 */       if ((str = (String)iterator.next()).startsWith("xr.")) {
/*     */         try {
/*     */           String str1;
/*     */ 
/*     */ 
/*     */           
/* 394 */           if ((str1 = System.getProperty(str)) != null) {
/* 395 */             this.a.setProperty(str, str1);
/* 396 */             f("  Overrode value for " + str);
/* 397 */             b1++;
/*     */           } 
/* 399 */         } catch (SecurityException securityException) {}
/*     */       }
/*     */     } 
/*     */     
/* 403 */     e("Configuration: " + b1 + " properties overridden from System properties.");
/*     */     
/*     */     try {
/*     */       Properties properties;
/*     */       
/* 408 */       Enumeration<Object> enumeration1 = (properties = System.getProperties()).keys();
/* 409 */       b1 = 0;
/* 410 */       while (enumeration1.hasMoreElements()) {
/*     */         String str;
/* 412 */         if ((str = (String)enumeration1.nextElement()).startsWith("xr.") && !this.a.containsKey(str)) {
/* 413 */           Object object = properties.get(str);
/* 414 */           this.a.put(str, object);
/* 415 */           f("  (+) " + str);
/* 416 */           b1++;
/*     */         } 
/*     */       } 
/* 419 */     } catch (SecurityException securityException) {}
/*     */ 
/*     */     
/* 422 */     e("Configuration: " + b1 + " FS properties added from System properties.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void e() {
/*     */     Enumeration<Object> enumeration;
/*     */     ArrayList<Comparable> arrayList;
/* 431 */     Collections.sort(arrayList = Collections.list(enumeration = this.a.keys()));
/* 432 */     Iterator<Comparable> iterator = arrayList.iterator();
/* 433 */     f("Configuration contains " + this.a.size() + " keys.");
/* 434 */     f("List of configuration properties, after override:");
/* 435 */     while (iterator.hasNext()) {
/* 436 */       String str1 = (String)iterator.next();
/* 437 */       String str2 = this.a.getProperty(str1);
/* 438 */       f("  " + str1 + " = " + str2);
/*     */     } 
/* 440 */     f("Properties list complete.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String a(String paramString) {
/*     */     b b1;
/*     */     String str;
/* 453 */     if ((str = (b1 = f()).a.getProperty(paramString)) == null) {
/* 454 */       b1.d("CONFIGURATION: no value found for key " + paramString);
/*     */     }
/* 456 */     return str;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String a(String paramString1, String paramString2) {
/*     */     b b1;
/*     */     String str;
/* 665 */     if ((str = (String)(((str = (b1 = f()).a.getProperty(paramString1)) == null) ? paramString2 : str)) == null) {
/* 666 */       b1.d("CONFIGURATION: no value found for key " + paramString1 + " and no default given.");
/*     */     }
/* 668 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Iterator b(String paramString) {
/*     */     b b1;
/* 680 */     Iterator<String> iterator = (b1 = f()).a.keySet().iterator();
/* 681 */     ArrayList<String> arrayList = new ArrayList();
/* 682 */     while (iterator.hasNext()) {
/*     */       String str;
/* 684 */       if ((str = iterator.next()).startsWith(paramString)) {
/* 685 */         arrayList.add(str);
/*     */       }
/*     */     } 
/* 688 */     return arrayList.iterator();
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
/*     */   public static boolean a(String paramString, boolean paramBoolean) {
/*     */     String str;
/* 723 */     if ((str = a(paramString)) == null) {
/* 724 */       return paramBoolean;
/*     */     }
/*     */     
/* 727 */     if ("true|false".indexOf(str) == -1) {
/* 728 */       l.c("Property '" + paramString + "' was requested as a boolean, but value of '" + str + "' is not a boolean. Check configuration.");
/*     */       
/* 730 */       return paramBoolean;
/*     */     } 
/* 732 */     return Boolean.valueOf(str).booleanValue();
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
/*     */   public static boolean b(String paramString, boolean paramBoolean) {
/* 747 */     return !a(paramString, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static synchronized b f() {
/* 754 */     if (c == null) {
/* 755 */       c = new b();
/*     */     }
/* 757 */     return c;
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
/*     */   public static Object a(String paramString, Object paramObject) {
/*     */     Object object;
/*     */     String str2, str3;
/* 771 */     b b1 = f();
/*     */     String str1;
/* 773 */     if ((str1 = a(paramString)) == null) {
/* 774 */       return paramObject;
/*     */     }
/* 776 */     int i = str1.lastIndexOf(".");
/*     */ 
/*     */     
/*     */     try {
/* 780 */       str3 = str1.substring(0, i);
/* 781 */       str2 = str1.substring(i + 1);
/* 782 */     } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
/* 783 */       b1.d("Property key " + paramString + " for object value constant is not properly formatted; should be FQN<dot>constant, is " + str1);
/*     */       
/* 785 */       return paramObject;
/*     */     } 
/*     */     
/*     */     try {
/* 789 */       object = Class.forName(str3);
/* 790 */     } catch (ClassNotFoundException classNotFoundException) {
/* 791 */       b1.d("Property for object value constant " + paramString + " is not a FQN: " + str3);
/* 792 */       return paramObject;
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 797 */       Field field = object.getDeclaredField(str2);
/*     */       try {
/* 799 */         object = field.get(object);
/* 800 */       } catch (IllegalAccessException illegalAccessException) {
/* 801 */         b1.d("Property for object value constant " + paramString + ", field is not public: " + str3 + "." + str2);
/*     */         
/* 803 */         return paramObject;
/*     */       } 
/* 805 */     } catch (NoSuchFieldException noSuchFieldException) {
/* 806 */       b1.d("Property for object value constant " + paramString + " is not a FQN: " + str3);
/* 807 */       return paramObject;
/*     */     } 
/* 809 */     return object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Properties g() {
/*     */     Properties properties;
/* 819 */     (properties = new Properties()).setProperty("xr.css.user-agent-default-css", "/resources/css/");
/* 820 */     properties.setProperty("xr.test.files.hamlet", "/demos/browser/xhtml/hamlet.xhtml");
/* 821 */     properties.setProperty("xr.simple-log-format", "{1} {2}:: {5}");
/* 822 */     properties.setProperty("xr.simple-log-format-throwable", "{1} {2}:: {5}");
/* 823 */     properties.setProperty("xr.test-config-byte", "8");
/* 824 */     properties.setProperty("xr.test-config-short", "16");
/* 825 */     properties.setProperty("xr.test-config-int", "100");
/* 826 */     properties.setProperty("xr.test-config-long", "2000");
/* 827 */     properties.setProperty("xr.test-config-float", "3000.25F");
/* 828 */     properties.setProperty("xr.test-config-double", "4000.50D");
/* 829 */     properties.setProperty("xr.test-config-boolean", "true");
/* 830 */     properties.setProperty("xr.util-logging.loggingEnabled", "false");
/* 831 */     properties.setProperty("xr.util-logging.handlers", "java.util.logging.ConsoleHandler");
/* 832 */     properties.setProperty("xr.util-logging.use-parent-handler", "false");
/* 833 */     properties.setProperty("xr.util-logging.java.util.logging.ConsoleHandler.level", "INFO");
/* 834 */     properties.setProperty("xr.util-logging.java.util.logging.ConsoleHandler.formatter", "org.xhtmlrenderer.util.XRSimpleLogFormatter");
/* 835 */     properties.setProperty("xr.util-logging.org.xhtmlrenderer.level", "ALL");
/* 836 */     properties.setProperty("xr.util-logging.org.xhtmlrenderer.config.level", "ALL");
/* 837 */     properties.setProperty("xr.util-logging.org.xhtmlrenderer.exception.level", "ALL");
/* 838 */     properties.setProperty("xr.util-logging.org.xhtmlrenderer.general.level", "ALL");
/* 839 */     properties.setProperty("xr.util-logging.org.xhtmlrenderer.init.level", "ALL");
/* 840 */     properties.setProperty("xr.util-logging.org.xhtmlrenderer.load.level", "ALL");
/* 841 */     properties.setProperty("xr.util-logging.org.xhtmlrenderer.load.xml-entities.level", "ALL");
/* 842 */     properties.setProperty("xr.util-logging.org.xhtmlrenderer.match.level", "ALL");
/* 843 */     properties.setProperty("xr.util-logging.org.xhtmlrenderer.cascade.level", "ALL");
/* 844 */     properties.setProperty("xr.util-logging.org.xhtmlrenderer.css-parse.level", "ALL");
/* 845 */     properties.setProperty("xr.util-logging.org.xhtmlrenderer.layout.level", "ALL");
/* 846 */     properties.setProperty("xr.util-logging.org.xhtmlrenderer.render.level", "ALL");
/* 847 */     properties.setProperty("xr.load.xml-reader", "default");
/* 848 */     properties.setProperty("xr.load.configure-features", "false");
/* 849 */     properties.setProperty("xr.load.validation", "false");
/* 850 */     properties.setProperty("xr.load.string-interning", "false");
/* 851 */     properties.setProperty("xr.load.namespaces", "false");
/* 852 */     properties.setProperty("xr.load.namespace-prefixes", "false");
/* 853 */     properties.setProperty("xr.layout.whitespace.experimental", "true");
/* 854 */     properties.setProperty("xr.layout.bad-sizing-hack", "false");
/* 855 */     properties.setProperty("xr.renderer.viewport-repaint", "true");
/* 856 */     properties.setProperty("xr.renderer.draw.backgrounds", "true");
/* 857 */     properties.setProperty("xr.renderer.draw.borders", "true");
/* 858 */     properties.setProperty("xr.renderer.debug.box-outlines", "false");
/* 859 */     properties.setProperty("xr.renderer.replace-missing-characters", "false");
/* 860 */     properties.setProperty("xr.renderer.missing-character-replacement", "false");
/* 861 */     properties.setProperty("xr.text.scale", "1.0");
/* 862 */     properties.setProperty("xr.text.aa-smoothing-level", "1");
/* 863 */     properties.setProperty("xr.text.aa-fontsize-threshhold", "25");
/* 864 */     properties.setProperty("xr.text.aa-rendering-hint", "RenderingHints.VALUE_TEXT_ANTIALIAS_HGRB");
/* 865 */     properties.setProperty("xr.cache.stylesheets", "false");
/* 866 */     properties.setProperty("xr.incremental.enabled", "false");
/* 867 */     properties.setProperty("xr.incremental.lazyimage", "false");
/* 868 */     properties.setProperty("xr.incremental.debug.layoutdelay", "0");
/* 869 */     properties.setProperty("xr.incremental.repaint.print-timing", "false");
/* 870 */     properties.setProperty("xr.use.threads", "false");
/* 871 */     properties.setProperty("xr.use.listeners", "true");
/* 872 */     properties.setProperty("xr.image.buffered", "false");
/* 873 */     properties.setProperty("xr.image.scale", "LOW");
/* 874 */     properties.setProperty("xr.image.render-quality", "java.awt.RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR");
/* 875 */     return properties;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\m\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */