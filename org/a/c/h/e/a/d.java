/*     */ package org.a.c.h.e.a;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class d
/*     */ {
/*  36 */   private static final a a = c.a(d.class);
/*     */ 
/*     */   
/*  39 */   private static final d b = a("glyphlist.txt", 4281);
/*     */ 
/*     */   
/*  42 */   private static final d c = a("zapfdingbats.txt", 201);
/*     */   
/*     */   private final Map<String, String> d;
/*     */   
/*     */   private final Map<String, String> e;
/*     */   
/*     */   private static d a(String paramString, int paramInt) {
/*  49 */     String str = "/org/apache/pdfbox/resources/glyphlist/";
/*     */     
/*     */     try {
/*  52 */       return new d(d.class.getResourceAsStream(str + paramString), paramInt);
/*     */     }
/*  54 */     catch (IOException iOException) {
/*     */       
/*  56 */       throw new RuntimeException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*     */     try {
/*     */       String str;
/*  66 */       if ((str = System.getProperty("glyphlist_ext")) != null)
/*     */       {
/*  68 */         throw new UnsupportedOperationException("glyphlist_ext is no longer supported, use GlyphList.DEFAULT.addGlyphs(Properties) instead");
/*     */       }
/*     */       
/*     */       return;
/*  72 */     } catch (SecurityException securityException) {
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static d a() {
/*  83 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static d b() {
/*  91 */     return c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  99 */   private final Map<String, String> f = new ConcurrentHashMap<String, String>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private d(InputStream paramInputStream, int paramInt) {
/* 110 */     this.d = new HashMap<String, String>(paramInt);
/* 111 */     this.e = new HashMap<String, String>(paramInt);
/* 112 */     a(paramInputStream);
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
/*     */   private void a(InputStream paramInputStream) {
/* 131 */     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(paramInputStream, "ISO-8859-1"));
/*     */     
/*     */     try {
/* 134 */       while (bufferedReader.ready()) {
/*     */         String str;
/*     */         
/* 137 */         if ((str = bufferedReader.readLine()) != null && !str.startsWith("#")) {
/*     */           String[] arrayOfString1;
/*     */           
/* 140 */           if ((arrayOfString1 = str.split(";")).length < 2)
/*     */           {
/* 142 */             throw new IOException("Invalid glyph list entry: " + str);
/*     */           }
/*     */           
/* 145 */           str = arrayOfString1[0];
/* 146 */           String[] arrayOfString2 = arrayOfString1[1].split(" ");
/*     */           
/* 148 */           if (this.d.containsKey(str))
/*     */           {
/* 150 */             (new StringBuilder("duplicate value for ")).append(str).append(" -> ").append(arrayOfString1[1]).append(" ")
/* 151 */               .append(this.d.get(str));
/*     */           }
/*     */           
/* 154 */           int[] arrayOfInt = new int[arrayOfString2.length];
/* 155 */           byte b1 = 0; int i; byte b2;
/* 156 */           for (i = (arrayOfString2 = arrayOfString2).length, b2 = 0; b2 < i; ) { String str2 = arrayOfString2[b2];
/*     */             
/* 158 */             arrayOfInt[b1++] = Integer.parseInt(str2, 16); b2++; }
/*     */           
/* 160 */           String str1 = new String(arrayOfInt, 0, arrayOfInt.length);
/*     */ 
/*     */           
/* 163 */           this.d.put(str, str1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 173 */           i = (k.c.a(str) || g.d.a(str) || e.c.a(str) || i.c.a(str) || l.c.a(str)) ? 1 : 0;
/* 174 */           if (!this.e.containsKey(str1) || i != 0)
/*     */           {
/* 176 */             this.e.put(str1, str);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/*     */       return;
/*     */     } finally {
/* 183 */       bufferedReader.close();
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
/*     */   public final String a(int paramInt) {
/*     */     String str;
/* 196 */     if ((str = this.e.get(new String(new int[] { paramInt }, 0, 1))) == null)
/*     */     {
/* 198 */       return ".notdef";
/*     */     }
/* 200 */     return str;
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
/*     */   public final String a(String paramString) {
/* 227 */     if (paramString == null)
/*     */     {
/* 229 */       return null;
/*     */     }
/*     */     
/*     */     String str;
/* 233 */     if ((str = this.d.get(paramString)) != null)
/*     */     {
/* 235 */       return str;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 240 */     if ((str = this.f.get(paramString)) == null) {
/*     */ 
/*     */       
/* 243 */       if (paramString.indexOf('.') > 0) {
/*     */         
/* 245 */         str = a(paramString.substring(0, paramString.indexOf('.')));
/*     */       }
/* 247 */       else if (paramString.startsWith("uni") && paramString.length() == 7) {
/*     */ 
/*     */         
/* 250 */         int i = paramString.length();
/* 251 */         StringBuilder stringBuilder = new StringBuilder();
/*     */         
/*     */         try {
/* 254 */           for (byte b = 3; b + 4 <= i; b += 4) {
/*     */             int j;
/*     */             
/* 257 */             if ((j = Integer.parseInt(paramString.substring(b, b + 4), 16)) > 55295 && j < 57344) {
/*     */               
/* 259 */               (new StringBuilder("Unicode character name with disallowed code area: ")).append(paramString);
/*     */             }
/*     */             else {
/*     */               
/* 263 */               stringBuilder.append((char)j);
/*     */             } 
/*     */           } 
/* 266 */           str = stringBuilder.toString();
/*     */         }
/* 268 */         catch (NumberFormatException numberFormatException) {
/*     */           
/* 270 */           (new StringBuilder("Not a number in Unicode character name: ")).append(paramString);
/*     */         }
/*     */       
/* 273 */       } else if (paramString.startsWith("u") && paramString.length() == 5) {
/*     */         try {
/*     */           int i;
/*     */ 
/*     */ 
/*     */           
/* 279 */           if ((i = Integer.parseInt(paramString.substring(1), 16)) > 55295 && i < 57344)
/*     */           {
/* 281 */             (new StringBuilder("Unicode character name with disallowed code area: ")).append(paramString);
/*     */           }
/*     */           else
/*     */           {
/* 285 */             str = String.valueOf((char)i);
/*     */           }
/*     */         
/* 288 */         } catch (NumberFormatException numberFormatException) {
/*     */           
/* 290 */           (new StringBuilder("Not a number in Unicode character name: ")).append(paramString);
/*     */         } 
/*     */       } 
/* 293 */       if (str != null)
/*     */       {
/*     */         
/* 296 */         this.f.put(paramString, str);
/*     */       }
/*     */     } 
/* 299 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */