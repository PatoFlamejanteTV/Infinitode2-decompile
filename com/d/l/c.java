/*     */ package com.d.l;
/*     */ 
/*     */ import com.d.d.d;
/*     */ import com.d.d.e;
/*     */ import com.d.d.i;
/*     */ import com.d.d.s;
/*     */ import com.d.j.f;
/*     */ import com.d.j.g;
/*     */ import com.d.m.f;
/*     */ import com.d.m.l;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.Reader;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.net.URL;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.logging.Level;
/*     */ import javax.imageio.ImageIO;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements s
/*     */ {
/*  67 */   protected final LinkedHashMap<String, f> a = new LinkedHashMap<>();
/*  68 */   private i b = new c();
/*     */   
/*  70 */   private i c = this.b;
/*     */   private String d;
/*  72 */   private Map<String, e> e = new HashMap<>(2);
/*     */   
/*     */   public static class a implements d {
/*     */     private InputStream a;
/*     */     
/*     */     public a(InputStream param1InputStream) {
/*  78 */       this.a = param1InputStream;
/*     */     }
/*     */ 
/*     */     
/*     */     public final InputStream a() {
/*  83 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final Reader b() {
/*  88 */       if (this.a != null) {
/*     */         try {
/*  90 */           return new InputStreamReader(this.a, "UTF-8");
/*  91 */         } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*  92 */           l.a("Exception when creating stream reader", unsupportedEncodingException);
/*     */         } 
/*     */       }
/*  95 */       return null;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class b
/*     */     implements e
/*     */   {
/*     */     public final d a(String param1String) {
/* 103 */       InputStream inputStream = null;
/*     */       
/*     */       try {
/* 106 */         inputStream = (new URL(param1String)).openStream();
/* 107 */       } catch (MalformedURLException malformedURLException) {
/* 108 */         l.a("bad URL given: " + param1String, malformedURLException);
/* 109 */       } catch (FileNotFoundException fileNotFoundException) {
/* 110 */         l.c("item at URI " + param1String + " not found");
/* 111 */       } catch (IOException iOException) {
/* 112 */         l.a("IO problem for " + param1String, iOException);
/*     */       } 
/* 114 */       return new c.a(inputStream);
/*     */     }
/*     */   }
/*     */   
/*     */   public c() {
/* 119 */     b b = new b();
/* 120 */     this.e.put("http", b);
/* 121 */     this.e.put("https", b);
/*     */   }
/*     */   
/*     */   public final void a(Map<String, e> paramMap) {
/* 125 */     this.e = paramMap;
/*     */   }
/*     */   
/*     */   public final void a(i parami) {
/* 129 */     this.c = parami;
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
/*     */   private e h(String paramString) {
/* 145 */     return this.e.get(paramString);
/*     */   }
/*     */   
/*     */   private boolean i(String paramString) {
/* 149 */     return this.e.containsKey(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final InputStream g(String paramString) {
/* 156 */     InputStream inputStream = null;
/*     */     
/*     */     try {
/*     */       URI uRI;
/* 160 */       String str = (uRI = new URI(paramString)).getScheme();
/*     */       
/* 162 */       if (i(str)) {
/* 163 */         return h(str).a(paramString).a();
/*     */       }
/*     */       
/*     */       try {
/* 167 */         inputStream = (new URL(paramString)).openStream();
/* 168 */       } catch (MalformedURLException malformedURLException) {
/* 169 */         l.a("bad URL given: " + paramString, malformedURLException);
/* 170 */       } catch (FileNotFoundException fileNotFoundException) {
/* 171 */         l.a("item at URI " + paramString + " not found", fileNotFoundException);
/* 172 */       } catch (IOException iOException) {
/* 173 */         l.a("IO problem for " + paramString, iOException);
/*     */       }
/*     */     
/* 176 */     } catch (URISyntaxException uRISyntaxException) {
/* 177 */       l.a("bad URL given: " + paramString, uRISyntaxException);
/*     */     } 
/*     */     
/* 180 */     return inputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Reader j(String paramString) {
/* 187 */     InputStream inputStream = null;
/*     */     
/*     */     try {
/*     */       URI uRI;
/* 191 */       String str = (uRI = new URI(paramString)).getScheme();
/*     */       
/* 193 */       if (i(str)) {
/* 194 */         return h(str).a(paramString).b();
/*     */       }
/*     */       
/*     */       try {
/* 198 */         inputStream = (new URL(paramString)).openStream();
/* 199 */       } catch (MalformedURLException malformedURLException) {
/* 200 */         l.a("bad URL given: " + paramString, malformedURLException);
/* 201 */       } catch (FileNotFoundException fileNotFoundException) {
/* 202 */         l.c("item at URI " + paramString + " not found");
/* 203 */       } catch (IOException iOException) {
/* 204 */         l.a("IO problem for " + paramString, iOException);
/*     */       }
/*     */     
/* 207 */     } catch (URISyntaxException uRISyntaxException) {
/* 208 */       l.a("bad URL given: " + paramString, uRISyntaxException);
/*     */     } 
/*     */     
/*     */     try {
/* 212 */       return (inputStream == null) ? null : new InputStreamReader(inputStream, "UTF-8");
/* 213 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 214 */       l.a("Failed to create stream reader", unsupportedEncodingException);
/*     */ 
/*     */       
/* 217 */       return null;
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
/*     */   public final com.d.j.b a(String paramString) {
/*     */     String str;
/* 242 */     if ((str = this.c.a(this.d, paramString)) == null) {
/* 243 */       l.e(Level.INFO, "URI resolver rejected loading CSS resource at (" + paramString + ")");
/* 244 */       return null;
/*     */     } 
/*     */     
/* 247 */     return new com.d.j.b(j(str));
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
/*     */   public f b(String paramString) {
/* 262 */     if (f.a(paramString)) {
/* 263 */       BufferedImage bufferedImage = f.e(paramString);
/* 264 */       return new f(null, a.a(bufferedImage));
/*     */     } 
/*     */     
/*     */     String str;
/* 268 */     if ((str = this.c.a(this.d, paramString)) == null) {
/* 269 */       l.e(Level.INFO, "URI resolver rejected loading image resource at (" + paramString + ")");
/* 270 */       return null;
/*     */     } 
/*     */     
/*     */     f f;
/*     */     
/* 275 */     if ((f = this.a.get(str)) != null) {
/* 276 */       return f;
/*     */     }
/*     */ 
/*     */     
/*     */     InputStream inputStream;
/*     */     
/* 282 */     if ((inputStream = g(str)) != null) {
/*     */       try {
/*     */         BufferedImage bufferedImage;
/* 285 */         if ((bufferedImage = ImageIO.read(inputStream)) == null) {
/* 286 */           throw new IOException("ImageIO.read() returned null");
/*     */         }
/*     */         
/* 289 */         a a = (a)a.a(bufferedImage);
/*     */         
/* 291 */         f f1 = new f(str, a);
/* 292 */         this.a.put(str, f1);
/*     */         
/* 294 */         f1 = f1; return f1;
/* 295 */       } catch (FileNotFoundException fileNotFoundException) {
/* 296 */         l.c("Can't read image file; image at URI '" + str + "' not found");
/* 297 */       } catch (IOException iOException) {
/* 298 */         l.a("Can't read image file; unexpected problem for URI '" + str + "'", iOException);
/*     */       } finally {
/*     */         try {
/* 301 */           inputStream.close();
/* 302 */         } catch (IOException iOException) {}
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 308 */     return new f(str, null);
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
/*     */   public final g c(String paramString) {
/*     */     String str;
/* 324 */     if ((str = this.c.a(this.d, paramString)) == null) {
/* 325 */       l.e(Level.INFO, "URI resolver rejected loading XML resource at (" + paramString + ")");
/* 326 */       return null;
/*     */     } 
/*     */     
/* 329 */     try { Reader reader = j(str);
/*     */       
/* 331 */       try { g g = (reader == null) ? null : g.a(reader);
/* 332 */         if (reader != null) reader.close();  return g; } catch (Throwable throwable) { if (reader != null) try { reader.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (IOException iOException)
/*     */     
/* 334 */     { return null; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public final byte[] d(String paramString) {
/* 340 */     if (f.b(paramString)) {
/* 341 */       return f.d(paramString);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 346 */     if ((null = this.c.a(this.d, paramString)) == null) {
/* 347 */       l.e(Level.INFO, "URI resolver rejected loading binary resource at (" + paramString + ")");
/* 348 */       return null;
/*     */     } 
/*     */     
/*     */     InputStream inputStream;
/* 352 */     if ((inputStream = g(null)) == null) {
/* 353 */       return null;
/*     */     }
/*     */     
/*     */     try {
/* 357 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 358 */       byte[] arrayOfByte2 = new byte[10240];
/*     */       int j;
/* 360 */       while ((j = inputStream.read(arrayOfByte2)) != -1) {
/* 361 */         byteArrayOutputStream.write(arrayOfByte2, 0, j);
/*     */       }
/* 363 */       inputStream.close();
/* 364 */       inputStream = null;
/*     */ 
/*     */       
/* 367 */       byte[] arrayOfByte1 = byteArrayOutputStream.toByteArray(), arrayOfByte1 = arrayOfByte1; return arrayOfByte1;
/* 368 */     } catch (IOException iOException) {
/* 369 */       return null;
/*     */     } finally {
/* 371 */       if (inputStream != null) {
/*     */         try {
/* 373 */           inputStream.close();
/* 374 */         } catch (IOException iOException) {}
/*     */       }
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
/*     */   public final void e(String paramString) {
/* 399 */     this.d = paramString;
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
/*     */   public static class c
/*     */     implements i
/*     */   {
/*     */     public final String a(String param1String1, String param1String2) {
/* 415 */       if (param1String2 == null || param1String2.isEmpty()) {
/* 416 */         return null;
/*     */       }
/*     */       
/*     */       try {
/*     */         URI uRI;
/* 421 */         if ((uRI = new URI(param1String2)).isAbsolute()) {
/* 422 */           return uRI.toString();
/*     */         }
/* 424 */         if (param1String1 == null) {
/*     */           
/* 426 */           l.e(Level.WARNING, "Couldn't resolve relative URI(" + param1String2 + ") because no base URI was provided.");
/* 427 */           return null;
/* 428 */         }  if (param1String1.startsWith("jar")) {
/*     */ 
/*     */ 
/*     */           
/* 432 */           URL uRL = new URL(param1String1);
/*     */           
/* 434 */           return (uRL = new URL(uRL, param1String2)).toString();
/*     */         } 
/*     */ 
/*     */         
/* 438 */         return (uRI = (uRI = new URI(param1String1)).resolve(param1String2)).toString();
/*     */       
/*     */       }
/* 441 */       catch (URISyntaxException uRISyntaxException) {
/* 442 */         l.a("When trying to load uri(" + param1String2 + ") with base URI(" + param1String1 + "), one or both were invalid URIs.", uRISyntaxException);
/* 443 */         return null;
/* 444 */       } catch (MalformedURLException malformedURLException) {
/* 445 */         l.a("When trying to load uri(" + param1String2 + ") with base jar scheme URI(" + param1String1 + "), one or both were invalid URIs.", malformedURLException);
/* 446 */         return null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a() {
/* 456 */     return this.d;
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
/*     */   public final String f(String paramString) {
/* 479 */     return this.c.a(a(), paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public final String a(String paramString1, String paramString2) {
/* 484 */     return this.c.a(paramString1, paramString2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\l\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */