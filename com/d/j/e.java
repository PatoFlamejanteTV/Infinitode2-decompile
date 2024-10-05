/*     */ package com.d.j;
/*     */ 
/*     */ import com.d.m.l;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.StringReader;
/*     */ import java.net.URL;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.logging.Level;
/*     */ import org.xml.sax.EntityResolver;
/*     */ import org.xml.sax.InputSource;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class e
/*     */   implements EntityResolver
/*     */ {
/*  61 */   private static final e a = new e();
/*     */   
/*  63 */   private final Map<String, String> b = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private e() {
/*  69 */     c c = new c();
/*     */     
/*  71 */     this.b.putAll(c.a("/resources/schema/openhtmltopdf/catalog-special.xml"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputSource resolveEntity(String paramString1, String paramString2) {
/*     */     InputSource inputSource;
/*     */     String str;
/*  81 */     if ((str = b().get(paramString1)) != null) {
/*  82 */       InputStream inputStream; URL uRL = e.class.getResource(str);
/*  83 */       paramString2 = null;
/*     */       try {
/*  85 */         inputStream = uRL.openStream();
/*  86 */       } catch (IOException iOException2) {
/*  87 */         IOException iOException1; (iOException1 = null).printStackTrace();
/*     */       } 
/*     */       
/*  90 */       if (inputStream == null) {
/*  91 */         l.b(Level.WARNING, "Can't find a local reference for Entity for public ID: " + paramString1 + " and expected to. The local URL should be: " + str + ". Not finding this probably means a CLASSPATH configuration problem; this resource should be included with the renderer and so not finding it means it is not on the CLASSPATH, and should be. Will let parser use the default in this case.");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 100 */       (inputSource = new InputSource(inputStream)).setSystemId(uRL.toExternalForm());
/* 101 */       l.b(Level.FINE, "Entity public: " + paramString1 + " -> " + str + 
/* 102 */           " (local)");
/*     */     } else {
/* 104 */       l.b("Entity public: " + paramString1 + ", no local mapping. Returning empty entity to avoid pulling from network.");
/* 105 */       inputSource = new InputSource(new StringReader(""));
/*     */     } 
/* 107 */     return inputSource;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static e a() {
/* 116 */     return a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<String, String> b() {
/* 124 */     return Collections.unmodifiableMap(this.b);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\j\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */