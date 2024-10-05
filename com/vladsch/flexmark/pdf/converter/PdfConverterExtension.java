/*     */ package com.vladsch.flexmark.pdf.converter;
/*     */ 
/*     */ import com.d.a;
/*     */ import com.d.a.a;
/*     */ import com.d.a.a.a;
/*     */ import com.d.a.a.b;
/*     */ import com.d.a.c;
/*     */ import com.d.g.a.b;
/*     */ import com.d.h.q;
/*     */ import com.d.h.x;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.DataKey;
/*     */ import com.vladsch.flexmark.util.data.NullableDataKey;
/*     */ import com.vladsch.flexmark.util.misc.Utils;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import org.a.c.h.b;
/*     */ import org.a.c.h.c.e;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.w3c.dom.Document;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PdfConverterExtension
/*     */ {
/*  38 */   public static final NullableDataKey<b.d> DEFAULT_TEXT_DIRECTION = new NullableDataKey("DEFAULT_TEXT_DIRECTION");
/*  39 */   public static final NullableDataKey<e> PROTECTION_POLICY = new NullableDataKey("PROTECTION_POLICY");
/*     */   
/*     */   public static final String DEFAULT_CSS_RESOURCE_PATH = "/default.css";
/*     */   public static final String DEFAULT_TOC_LIST_CLASS = "toc";
/*  43 */   public static final DataKey<String> DEFAULT_CSS = new DataKey("DEFAULT_CSS", () -> Utils.getResourceAsString(PdfConverterExtension.class, "/default.css"));
/*     */   
/*     */   public static String embedCss(String paramString1, String paramString2) {
/*  46 */     if (paramString2 != null && !paramString2.isEmpty()) {
/*  47 */       int i = paramString1.indexOf("</head>");
/*  48 */       String str1 = "<style>\n";
/*  49 */       String str2 = "\n</style>";
/*  50 */       String str3 = "";
/*  51 */       if (i == -1)
/*     */       {
/*  53 */         if ((i = paramString1.indexOf("<html>")) != -1) {
/*  54 */           i += 6;
/*  55 */           str1 = "<head>" + str1;
/*  56 */           str2 = str2 + "</head>";
/*     */         
/*     */         }
/*  59 */         else if ((i = paramString1.indexOf("<body>")) != -1) {
/*  60 */           str1 = "<html><head>" + str1;
/*  61 */           str2 = str2 + "</head>";
/*  62 */           str3 = "</html>\n";
/*     */         } else {
/*  64 */           i = 0;
/*  65 */           str1 = "<html><head>" + str1;
/*  66 */           str2 = str2 + "</head><body>\n";
/*  67 */           str3 = "</body></html>\n";
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*  72 */       return paramString1.subSequence(0, i) + str1 + paramString2 + str2 + paramString1.subSequence(i, paramString1.length()) + str3;
/*     */     } 
/*  74 */     return paramString1;
/*     */   }
/*     */   
/*     */   public static void exportToPdf(String paramString1, String paramString2, String paramString3, DataHolder paramDataHolder) {
/*  78 */     String str = (String)DEFAULT_CSS.get(paramDataHolder);
/*  79 */     paramString2 = embedCss(paramString2, str);
/*  80 */     exportToPdf(paramString1, paramString2, paramString3, (b.d)DEFAULT_TEXT_DIRECTION.get(paramDataHolder), (e)PROTECTION_POLICY.get(paramDataHolder));
/*     */   }
/*     */   
/*     */   public static void exportToPdf(String paramString1, String paramString2, String paramString3, b.d paramd) {
/*  84 */     exportToPdf(paramString1, paramString2, paramString3, paramd, (e)null);
/*     */   }
/*     */   
/*     */   public static void exportToPdf(String paramString1, String paramString2, String paramString3, b.d paramd, e parame) {
/*     */     try {
/*     */       FileOutputStream fileOutputStream;
/*  90 */       exportToPdf(fileOutputStream = new FileOutputStream(paramString1), paramString2, paramString3, paramd, parame); return;
/*  91 */     } catch (FileNotFoundException fileNotFoundException) {
/*  92 */       (paramString1 = null).printStackTrace();
/*     */       return;
/*     */     } 
/*     */   }
/*     */   public static void exportToPdf(OutputStream paramOutputStream, String paramString1, String paramString2, DataHolder paramDataHolder) {
/*  97 */     exportToPdf(paramOutputStream, paramString1, paramString2, (b.d)DEFAULT_TEXT_DIRECTION.get(paramDataHolder), (e)PROTECTION_POLICY.get(paramDataHolder));
/*     */   }
/*     */   
/*     */   public static void exportToPdf(OutputStream paramOutputStream, String paramString1, String paramString2, b.d paramd) {
/* 101 */     exportToPdf(paramOutputStream, paramString1, paramString2, paramd, (e)null);
/*     */   }
/*     */   
/*     */   public static void exportToPdf(OutputStream paramOutputStream, String paramString1, String paramString2, b.d paramd, e parame) {
/* 105 */     q q = null;
/*     */     
/*     */     try {
/* 108 */       x x = new x();
/*     */       
/* 110 */       handleTextDirection(paramd, x);
/* 111 */       handleW3cDocument(paramString1, paramString2, x);
/*     */       
/* 113 */       x.a(paramOutputStream);
/*     */       
/* 115 */       b b = (q = x.a()).a();
/*     */       
/* 117 */       if (parame != null) {
/* 118 */         b.a(parame);
/*     */       }
/* 120 */       q.c();
/* 121 */       q.d();
/* 122 */     } catch (Exception exception2) {
/* 123 */       Exception exception1; (exception1 = null).printStackTrace();
/*     */     } finally {
/*     */       
/*     */       try {
/* 127 */         if (q != null) {
/* 128 */           q.close();
/*     */         }
/* 130 */         paramOutputStream.close();
/* 131 */       } catch (IOException iOException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void handleW3cDocument(String paramString1, String paramString2, x paramx) {
/*     */     Document document1;
/* 141 */     Document document = a.a(document1 = Jsoup.parse(paramString1));
/* 142 */     paramx.a(document, paramString2);
/*     */   }
/*     */   
/*     */   private static void handleTextDirection(b.d paramd, x paramx) {
/* 146 */     if (paramd != null) {
/* 147 */       paramx.a((c)new b.a());
/* 148 */       paramx.a((a)new a());
/* 149 */       paramx.a(paramd);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\pdf\converter\PdfConverterExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */