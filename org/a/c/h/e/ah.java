/*     */ package org.a.c.h.e;
/*     */ 
/*     */ import com.b.a.a.o;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class ah
/*     */ {
/*  42 */   private static final Set<String> a = new HashSet<String>(34);
/*  43 */   private static final Map<String, String> b = new HashMap<String, String>(34);
/*  44 */   private static final Map<String, l> c = new HashMap<String, l>(34);
/*     */ 
/*     */   
/*     */   static {
/*     */     try {
/*  49 */       d("Courier-Bold");
/*  50 */       d("Courier-BoldOblique");
/*  51 */       d("Courier");
/*  52 */       d("Courier-Oblique");
/*  53 */       d("Helvetica");
/*  54 */       d("Helvetica-Bold");
/*  55 */       d("Helvetica-BoldOblique");
/*  56 */       d("Helvetica-Oblique");
/*  57 */       d("Symbol");
/*  58 */       d("Times-Bold");
/*  59 */       d("Times-BoldItalic");
/*  60 */       d("Times-Italic");
/*  61 */       d("Times-Roman");
/*  62 */       d("ZapfDingbats");
/*     */ 
/*     */       
/*  65 */       a("CourierCourierNew", "Courier");
/*  66 */       a("CourierNew", "Courier");
/*  67 */       a("CourierNew,Italic", "Courier-Oblique");
/*  68 */       a("CourierNew,Bold", "Courier-Bold");
/*  69 */       a("CourierNew,BoldItalic", "Courier-BoldOblique");
/*  70 */       a("Arial", "Helvetica");
/*  71 */       a("Arial,Italic", "Helvetica-Oblique");
/*  72 */       a("Arial,Bold", "Helvetica-Bold");
/*  73 */       a("Arial,BoldItalic", "Helvetica-BoldOblique");
/*  74 */       a("TimesNewRoman", "Times-Roman");
/*  75 */       a("TimesNewRoman,Italic", "Times-Italic");
/*  76 */       a("TimesNewRoman,Bold", "Times-Bold");
/*  77 */       a("TimesNewRoman,BoldItalic", "Times-BoldItalic");
/*     */ 
/*     */       
/*  80 */       a("Symbol,Italic", "Symbol");
/*  81 */       a("Symbol,Bold", "Symbol");
/*  82 */       a("Symbol,BoldItalic", "Symbol");
/*  83 */       a("Times", "Times-Roman");
/*  84 */       a("Times,Italic", "Times-Italic");
/*  85 */       a("Times,Bold", "Times-Bold");
/*  86 */       a("Times,BoldItalic", "Times-BoldItalic");
/*     */ 
/*     */       
/*  89 */       a("ArialMT", "Helvetica");
/*  90 */       a("Arial-ItalicMT", "Helvetica-Oblique");
/*  91 */       a("Arial-BoldMT", "Helvetica-Bold");
/*  92 */       a("Arial-BoldItalicMT", "Helvetica-BoldOblique");
/*     */       return;
/*  94 */     } catch (IOException iOException) {
/*     */       
/*  96 */       throw new RuntimeException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void d(String paramString) {
/* 102 */     a(paramString, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void a(String paramString1, String paramString2) {
/* 107 */     a.add(paramString1);
/* 108 */     b.put(paramString1, paramString2);
/*     */     
/* 110 */     if (c.containsKey(paramString2))
/*     */     {
/* 112 */       c.put(paramString1, c.get(paramString2));
/*     */     }
/*     */     
/* 115 */     paramString2 = "/org/apache/pdfbox/resources/afm/" + paramString2 + ".afm";
/*     */     InputStream inputStream;
/* 117 */     if ((inputStream = ae.class.getResourceAsStream(paramString2)) == null)
/*     */     {
/* 119 */       throw new IOException(paramString2 + " not found");
/*     */     }
/*     */     
/*     */     try {
/*     */       o.a a;
/* 124 */       l l = (a = new o.a(inputStream)).a(true);
/* 125 */       c.put(paramString1, l);
/*     */       
/*     */       return;
/*     */     } finally {
/* 129 */       inputStream.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static l a(String paramString) {
/* 139 */     return c.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean b(String paramString) {
/* 148 */     return a.contains(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Set<String> a() {
/* 156 */     return Collections.unmodifiableSet(a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String c(String paramString) {
/* 165 */     return b.get(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */