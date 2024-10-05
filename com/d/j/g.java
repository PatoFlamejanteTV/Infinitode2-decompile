/*     */ package com.d.j;
/*     */ 
/*     */ import com.d.h.w;
/*     */ import com.d.m.b;
/*     */ import com.d.m.i;
/*     */ import com.d.m.l;
/*     */ import java.io.Reader;
/*     */ import java.util.logging.Level;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.FactoryConfigurationError;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import javax.xml.parsers.SAXParser;
/*     */ import javax.xml.parsers.SAXParserFactory;
/*     */ import javax.xml.transform.Transformer;
/*     */ import javax.xml.transform.TransformerFactory;
/*     */ import javax.xml.transform.TransformerFactoryConfigurationError;
/*     */ import javax.xml.transform.dom.DOMResult;
/*     */ import javax.xml.transform.sax.SAXSource;
/*     */ import org.w3c.dom.Document;
/*     */ import org.xml.sax.InputSource;
/*     */ import org.xml.sax.SAXException;
/*     */ import org.xml.sax.SAXNotRecognizedException;
/*     */ import org.xml.sax.SAXNotSupportedException;
/*     */ import org.xml.sax.XMLReader;
/*     */ import org.xml.sax.helpers.XMLReaderFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class g
/*     */   extends a
/*     */ {
/*     */   private Document a;
/*  64 */   private static final a b = new a((byte)0);
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean c = true;
/*     */ 
/*     */ 
/*     */   
/*     */   private g(InputSource paramInputSource) {
/*  73 */     super(paramInputSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static g a(InputSource paramInputSource) {
/*  81 */     return a.a(b, new g(paramInputSource));
/*     */   }
/*     */   
/*     */   public static g a(Reader paramReader) {
/*  85 */     return a.a(b, new g(new InputSource(paramReader)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Document d() {
/*  94 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   final void a(Document paramDocument) {
/*  99 */     this.a = paramDocument;
/*     */   }
/*     */   
/*     */   public static final XMLReader e() {
/* 103 */     XMLReader xMLReader = null;
/* 104 */     String str = b.a("xr.load.xml-reader");
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 109 */       if (str != null && 
/* 110 */         !str.toLowerCase().equals("default") && c) {
/*     */         
/*     */         try {
/* 113 */           Class.forName(str);
/* 114 */         } catch (Exception exception) {
/* 115 */           c = false;
/* 116 */           l.e(Level.WARNING, "The XMLReader class you specified as a configuration property could not be found. Class.forName() failed on " + str + ". Please check classpath. Use value 'default' in FS configuration if necessary. Will now try JDK default.");
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 122 */         if (c) {
/* 123 */           xMLReader = XMLReaderFactory.createXMLReader(str);
/*     */         }
/*     */       } 
/* 126 */     } catch (Exception exception) {
/* 127 */       l.e(Level.WARNING, "Could not instantiate custom XMLReader class for XML parsing: " + str + ". Please check classpath. Use value 'default' in FS configuration if necessary. Will now try JDK default.", exception);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 132 */     if (xMLReader == null) {
/*     */       
/*     */       try {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 143 */         xMLReader = XMLReaderFactory.createXMLReader();
/*     */       }
/* 145 */       catch (Exception exception2) {
/* 146 */         Exception exception1; l.d((exception1 = null).getMessage());
/*     */       } 
/*     */     }
/* 149 */     if (xMLReader == null) {
/*     */       try {
/* 151 */         l.e(Level.WARNING, "falling back on the default parser");
/*     */         SAXParser sAXParser;
/* 153 */         xMLReader = (sAXParser = SAXParserFactory.newInstance().newSAXParser()).getXMLReader();
/*     */       }
/* 155 */       catch (Exception exception2) {
/* 156 */         Exception exception1; l.d((exception1 = null).getMessage());
/*     */       } 
/*     */     }
/* 159 */     if (xMLReader == null) {
/* 160 */       throw new w.a("Could not instantiate any SAX 2 parser, including JDK default. The name of the class to use should have been read from the org.xml.sax.driver System property, which is set to: ");
/*     */     }
/*     */ 
/*     */     
/* 164 */     l.e("SAX XMLReader in use (parser): " + xMLReader.getClass().getName());
/* 165 */     return xMLReader;
/*     */   }
/*     */   
/*     */   static class a
/*     */   {
/*     */     private a() {}
/*     */     
/*     */     private static void a(XMLReader param1XMLReader) {
/*     */       try {
/* 174 */         param1XMLReader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", false);
/* 175 */         param1XMLReader.setFeature("http://xml.org/sax/features/external-general-entities", false);
/* 176 */         param1XMLReader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
/* 177 */         param1XMLReader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", true);
/* 178 */         param1XMLReader.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true); return;
/* 179 */       } catch (SAXNotSupportedException sAXNotSupportedException) {
/* 180 */         l.e(Level.SEVERE, "Unable to disable XML External Entities, which might put you at risk to XXE attacks", sAXNotSupportedException); return;
/* 181 */       } catch (SAXNotRecognizedException sAXNotRecognizedException) {
/* 182 */         l.e(Level.SEVERE, "Unable to disable XML External Entities, which might put you at risk to XXE attacks", sAXNotRecognizedException);
/*     */         return;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private static void a(DocumentBuilderFactory param1DocumentBuilderFactory) {
/*     */       try {
/* 190 */         param1DocumentBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", false);
/* 191 */         param1DocumentBuilderFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
/* 192 */         param1DocumentBuilderFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
/* 193 */         param1DocumentBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
/* 194 */         param1DocumentBuilderFactory.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true); return;
/* 195 */       } catch (ParserConfigurationException parserConfigurationException) {
/* 196 */         l.e(Level.SEVERE, "Unable to disable XML External Entities, which might put you at risk to XXE attacks", parserConfigurationException);
/*     */         return;
/*     */       } 
/*     */     }
/*     */     private static void a(TransformerFactory param1TransformerFactory) {
/*     */       try {
/* 202 */         param1TransformerFactory.setAttribute("http://javax.xml.XMLConstants/property/accessExternalDTD", "");
/* 203 */         param1TransformerFactory.setAttribute("http://javax.xml.XMLConstants/property/accessExternalStylesheet", ""); return;
/* 204 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 205 */         l.e(Level.SEVERE, "Unable to disable XML External Entities, which might put you at risk to XXE attacks", illegalArgumentException);
/*     */         return;
/*     */       } 
/*     */     }
/*     */     private static TransformerFactory a(String param1String) {
/*     */       try {
/* 211 */         return TransformerFactory.newInstance(param1String, null);
/* 212 */       } catch (TransformerFactoryConfigurationError transformerFactoryConfigurationError) {
/* 213 */         l.e(Level.SEVERE, "Could not load preferred XML transformer, using default which may not be secure.");
/* 214 */         return TransformerFactory.newInstance();
/*     */       } 
/*     */     }
/*     */     
/*     */     private static DocumentBuilderFactory b(String param1String) {
/*     */       try {
/* 220 */         return (param1String == null) ? DocumentBuilderFactory.newInstance() : DocumentBuilderFactory.newInstance(param1String, null);
/* 221 */       } catch (FactoryConfigurationError factoryConfigurationError) {
/* 222 */         l.e(Level.SEVERE, "Could not load preferred XML document builder, using default which may not be secure.");
/* 223 */         return DocumentBuilderFactory.newInstance();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private g a(g param1g) {
/*     */       SAXSource sAXSource;
/*     */       DOMResult dOMResult;
/*     */       Transformer transformer;
/*     */       XMLReader xMLReader;
/* 237 */       a(xMLReader = g.e());
/* 238 */       b(xMLReader);
/* 239 */       c(xMLReader);
/*     */       
/* 241 */       long l1 = System.currentTimeMillis(); try {
/*     */         TransformerFactory transformerFactory;
/* 243 */         sAXSource = new SAXSource(xMLReader, param1g.a());
/*     */         
/*     */         String str2;
/*     */         
/*     */         DocumentBuilderFactory documentBuilderFactory;
/* 248 */         a(documentBuilderFactory = b(str2 = (i.a().a()).b));
/* 249 */         documentBuilderFactory.setNamespaceAware(true);
/* 250 */         documentBuilderFactory.setValidating(false);
/*     */         
/* 252 */         dOMResult = new DOMResult(documentBuilderFactory.newDocumentBuilder().newDocument());
/*     */         
/*     */         String str1;
/*     */         
/* 256 */         if ((str1 = (i.a().a()).a) == null) {
/* 257 */           transformerFactory = TransformerFactory.newInstance();
/*     */         } else {
/* 259 */           transformerFactory = a((String)transformerFactory);
/*     */         } 
/*     */         
/* 262 */         a(transformerFactory);
/* 263 */         transformer = transformerFactory.newTransformer();
/*     */       }
/* 265 */       catch (Exception exception) {
/* 266 */         throw new w.a("Failed on configuring SAX to DOM transformer.", exception);
/*     */       } 
/*     */ 
/*     */       
/*     */       try {
/* 271 */         transformer.transform(sAXSource, dOMResult);
/* 272 */       } catch (Exception exception) {
/* 273 */         throw new w.a("Can't load the XML resource (using TRaX transformer). " + exception
/* 274 */             .getMessage(), exception);
/*     */       } 
/*     */       
/* 277 */       long l2 = System.currentTimeMillis();
/*     */       
/* 279 */       param1g.a(l2 - l1);
/*     */       
/* 281 */       l.e("Loaded document in ~" + param1g.c() + "ms");
/*     */       
/* 283 */       param1g.a((Document)dOMResult.getNode());
/* 284 */       return param1g;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void b(XMLReader param1XMLReader) {
/*     */       try {
/* 293 */         param1XMLReader.setEntityResolver(e.a());
/* 294 */         param1XMLReader.setErrorHandler(new h(this));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         return;
/* 308 */       } catch (Exception exception) {
/* 309 */         throw new w.a("Failed on configuring SAX parser/XMLReader.", exception);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void c(XMLReader param1XMLReader) {
/*     */       try {
/* 318 */         param1XMLReader.setFeature("http://xml.org/sax/features/validation", false);
/*     */         
/* 320 */         param1XMLReader.setFeature("http://xml.org/sax/features/namespaces", true);
/* 321 */       } catch (SAXException sAXException) {
/*     */         
/* 323 */         l.e(Level.WARNING, "Could not set validation/namespace features for XML parser,exception thrown.", sAXException);
/*     */       } 
/*     */       
/* 326 */       if (b.b("xr.load.configure-features", false)) {
/* 327 */         l.e(Level.FINE, "SAX Parser: by request, not changing any parser features.");
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 332 */       a(param1XMLReader, "http://xml.org/sax/features/validation", "xr.load.validation");
/*     */ 
/*     */       
/* 335 */       a(param1XMLReader, "http://xml.org/sax/features/string-interning", "xr.load.string-interning");
/*     */ 
/*     */       
/* 338 */       a(param1XMLReader, "http://xml.org/sax/features/namespaces", "xr.load.namespaces");
/* 339 */       a(param1XMLReader, "http://xml.org/sax/features/namespace-prefixes", "xr.load.namespace-prefixes");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static void a(XMLReader param1XMLReader, String param1String1, String param1String2) {
/*     */       try {
/* 348 */         param1XMLReader.setFeature(param1String1, b.a(param1String2, false));
/*     */         
/* 350 */         l.e(Level.FINE, "SAX Parser feature: " + param1String1
/* 351 */             .substring(param1String1.lastIndexOf("/")) + " set to " + param1XMLReader
/*     */             
/* 353 */             .getFeature(param1String1)); return;
/* 354 */       } catch (SAXNotSupportedException sAXNotSupportedException) {
/* 355 */         l.e(Level.WARNING, "SAX feature not supported on this XMLReader: " + param1String1); return;
/* 356 */       } catch (SAXNotRecognizedException sAXNotRecognizedException) {
/* 357 */         l.e(Level.WARNING, "SAX feature not recognized on this XMLReader: " + param1String1 + ". Feature may be properly named, but not recognized by this parser.");
/*     */         return;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\j\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */