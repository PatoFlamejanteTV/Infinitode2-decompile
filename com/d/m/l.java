/*     */ package com.d.m;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.logging.Level;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class l
/*     */ {
/*  36 */   private static final List<String> b = new ArrayList<>(20);
/*  37 */   public static final String a = g("com.openhtmltopdf.config");
/*  38 */   private static String c = g("com.openhtmltopdf.exception");
/*  39 */   private static String d = g("com.openhtmltopdf.general");
/*  40 */   private static String e = g("com.openhtmltopdf.init"); static {
/*  41 */     g("com.openhtmltopdf.junit");
/*  42 */   } private static String f = g("com.openhtmltopdf.load");
/*  43 */   private static String g = g("com.openhtmltopdf.match");
/*  44 */   private static String h = g("com.openhtmltopdf.cascade");
/*  45 */   private static String i = g("com.openhtmltopdf.load.xml-entities");
/*  46 */   private static String j = g("com.openhtmltopdf.css-parse");
/*  47 */   private static String k = g("com.openhtmltopdf.layout");
/*  48 */   private static String l = g("com.openhtmltopdf.render");
/*     */   
/*     */   private static String g(String paramString) {
/*  51 */     b.add(paramString);
/*  52 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean m = true;
/*     */ 
/*     */   
/*     */   private static m n;
/*     */ 
/*     */   
/*     */   private static volatile Boolean o;
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<String> a() {
/*  69 */     return new ArrayList<>(b);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void a(String paramString) {
/*  74 */     a(Level.INFO, paramString);
/*     */   }
/*     */   
/*     */   public static void a(Level paramLevel, String paramString) {
/*  78 */     a(j, paramLevel, paramString);
/*     */   }
/*     */   
/*     */   public static void a(Level paramLevel, String paramString, Throwable paramThrowable) {
/*  82 */     a(j, paramLevel, paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public static void b(String paramString) {
/*  86 */     b(Level.INFO, paramString);
/*     */   }
/*     */   
/*     */   public static void b(Level paramLevel, String paramString) {
/*  90 */     a(i, paramLevel, paramString);
/*     */   }
/*     */   
/*     */   public static void b(Level paramLevel, String paramString, Throwable paramThrowable) {
/*  94 */     a(i, paramLevel, paramString, paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void c(Level paramLevel, String paramString) {
/* 102 */     a(h, paramLevel, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void c(String paramString) {
/* 110 */     a(paramString, (Throwable)null);
/*     */   }
/*     */   
/*     */   public static void a(String paramString, Throwable paramThrowable) {
/* 114 */     a(c, Level.WARNING, paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public static void d(String paramString) {
/* 118 */     d(Level.INFO, paramString);
/*     */   }
/*     */   
/*     */   public static void d(Level paramLevel, String paramString) {
/* 122 */     a(d, paramLevel, paramString);
/*     */   }
/*     */   
/*     */   public static void c(Level paramLevel, String paramString, Throwable paramThrowable) {
/* 126 */     a(d, paramLevel, paramString, paramThrowable);
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
/*     */   public static void d(Level paramLevel, String paramString, Throwable paramThrowable) {
/* 138 */     a(e, paramLevel, paramString, paramThrowable);
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
/*     */   public static void e(String paramString) {
/* 154 */     e(Level.INFO, paramString);
/*     */   }
/*     */   
/*     */   public static void e(Level paramLevel, String paramString) {
/* 158 */     a(f, paramLevel, paramString);
/*     */   }
/*     */   
/*     */   public static void e(Level paramLevel, String paramString, Throwable paramThrowable) {
/* 162 */     a(f, paramLevel, paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public static void f(String paramString) {
/* 166 */     f(Level.INFO, paramString);
/*     */   }
/*     */   
/*     */   public static void f(Level paramLevel, String paramString) {
/* 170 */     a(g, paramLevel, paramString);
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
/*     */   public static void g(Level paramLevel, String paramString) {
/* 182 */     a(k, paramLevel, paramString);
/*     */   }
/*     */   
/*     */   public static void f(Level paramLevel, String paramString, Throwable paramThrowable) {
/* 186 */     a(k, paramLevel, paramString, paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void h(Level paramLevel, String paramString) {
/* 194 */     a(l, paramLevel, paramString);
/*     */   }
/*     */   
/*     */   public static void g(Level paramLevel, String paramString, Throwable paramThrowable) {
/* 198 */     a(l, paramLevel, paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   private static synchronized void a(String paramString1, Level paramLevel, String paramString2) {
/* 202 */     if (m) {
/* 203 */       c();
/*     */     }
/* 205 */     if (b()) {
/* 206 */       n.a(paramString1, paramLevel, paramString2);
/*     */     }
/*     */   }
/*     */   
/*     */   private static synchronized void a(String paramString1, Level paramLevel, String paramString2, Throwable paramThrowable) {
/* 211 */     if (m) {
/* 212 */       c();
/*     */     }
/* 214 */     if (b()) {
/* 215 */       n.a(paramString1, paramLevel, paramString2, paramThrowable);
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
/*     */   private static void c() {
/* 243 */     synchronized (l.class) {
/* 244 */       if (!m) {
/*     */         return;
/*     */       }
/*     */       
/* 248 */       if (o == null) {
/* 249 */         a(b.a("xr.util-logging.loggingEnabled", true));
/*     */       }
/*     */       
/* 252 */       if (n == null) {
/* 253 */         n = new g();
/*     */       }
/*     */       
/* 256 */       m = false;
/*     */       return;
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
/*     */   public static boolean b() {
/* 274 */     return (o.booleanValue() == true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(boolean paramBoolean) {
/* 285 */     o = Boolean.valueOf(paramBoolean);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\m\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */