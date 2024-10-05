/*     */ package com.d.j;
/*     */ 
/*     */ import com.d.h.w;
/*     */ import com.d.m.l;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.logging.Level;
/*     */ import org.xml.sax.Attributes;
/*     */ import org.xml.sax.ContentHandler;
/*     */ import org.xml.sax.InputSource;
/*     */ import org.xml.sax.SAXNotRecognizedException;
/*     */ import org.xml.sax.SAXNotSupportedException;
/*     */ import org.xml.sax.XMLReader;
/*     */ import org.xml.sax.helpers.DefaultHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */ {
/*     */   public final Map<String, String> a(String paramString) {
/*     */     Map<?, ?> map;
/*     */     
/*  69 */     try { InputStream inputStream = c.class.getResourceAsStream(paramString); 
/*  70 */       try { map = a(new InputSource(new BufferedInputStream(inputStream)));
/*  71 */         if (inputStream != null) inputStream.close();  } catch (Throwable throwable) { if (inputStream != null) try { inputStream.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception exception)
/*  72 */     { l.b(Level.WARNING, "Could not open XML catalog from URI '" + paramString + "'", exception);
/*  73 */       map = Collections.emptyMap(); }
/*     */     
/*  75 */     return (Map)map;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<String, String> a(InputSource paramInputSource) {
/*  85 */     XMLReader xMLReader = g.e();
/*     */     
/*  87 */     a a = new a();
/*  88 */     a(xMLReader, a);
/*  89 */     a(xMLReader, "http://xml.org/sax/features/validation", false);
/*     */     
/*     */     try {
/*  92 */       xMLReader.parse(paramInputSource);
/*  93 */     } catch (Exception exception) {
/*  94 */       throw new RuntimeException("Failed on configuring SAX to DOM transformer.", exception);
/*     */     } 
/*     */     
/*  97 */     return a.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(XMLReader paramXMLReader, ContentHandler paramContentHandler) {
/*     */     try {
/* 106 */       paramXMLReader.setContentHandler(paramContentHandler);
/* 107 */       paramXMLReader.setErrorHandler(new d(this));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/* 126 */     } catch (Exception exception) {
/* 127 */       throw new w.a("Failed on configuring SAX parser/XMLReader.", exception);
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
/*     */   private static class a
/*     */     extends DefaultHandler
/*     */   {
/* 141 */     private final Map<String, String> a = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Map<String, String> a() {
/* 148 */       return this.a;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void startElement(String param1String1, String param1String2, String param1String3, Attributes param1Attributes) {
/* 156 */       if (param1String2.equalsIgnoreCase("public") || (param1String2
/* 157 */         .equals("") && param1String3.equalsIgnoreCase("public"))) {
/* 158 */         this.a.put(param1Attributes.getValue("publicId"), param1Attributes.getValue("uri"));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(XMLReader paramXMLReader, String paramString, boolean paramBoolean) {
/*     */     try {
/* 169 */       paramXMLReader.setFeature(paramString, false);
/*     */       
/* 171 */       l.b(Level.FINE, "SAX Parser feature: " + paramString
/* 172 */           .substring(paramString.lastIndexOf("/")) + " set to " + paramXMLReader
/*     */           
/* 174 */           .getFeature(paramString)); return;
/* 175 */     } catch (SAXNotSupportedException sAXNotSupportedException) {
/* 176 */       l.b(Level.WARNING, "SAX feature not supported on this XMLReader: " + paramString);
/*     */       return;
/* 178 */     } catch (SAXNotRecognizedException sAXNotRecognizedException) {
/* 179 */       l.b(Level.WARNING, "SAX feature not recognized on this XMLReader: " + paramString + ". Feature may be properly named, but not recognized by this parser.");
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\j\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */