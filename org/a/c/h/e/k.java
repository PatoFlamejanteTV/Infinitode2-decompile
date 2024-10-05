/*     */ package org.a.c.h.e;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.PriorityQueue;
/*     */ import java.util.Set;
/*     */ import org.a.b.f.ad;
/*     */ import org.a.b.f.al;
/*     */ import org.a.b.f.ap;
/*     */ import org.a.b.g.d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class k
/*     */   implements j
/*     */ {
/*  44 */   private static final g a = new g();
/*     */   
/*     */   private n b;
/*     */   
/*     */   private Map<String, i> c;
/*     */   private final ap d;
/*  50 */   private final Map<String, List<String>> e = new HashMap<String, List<String>>();
/*     */ 
/*     */ 
/*     */   
/*     */   k() {
/*  55 */     this.e.put("Courier", 
/*  56 */         Arrays.asList(new String[] { "CourierNew", "CourierNewPSMT", "LiberationMono", "NimbusMonL-Regu" }));
/*  57 */     this.e.put("Courier-Bold", 
/*  58 */         Arrays.asList(new String[] { "CourierNewPS-BoldMT", "CourierNew-Bold", "LiberationMono-Bold", "NimbusMonL-Bold" }));
/*     */     
/*  60 */     this.e.put("Courier-Oblique", 
/*  61 */         Arrays.asList(new String[] { "CourierNewPS-ItalicMT", "CourierNew-Italic", "LiberationMono-Italic", "NimbusMonL-ReguObli" }));
/*     */     
/*  63 */     this.e.put("Courier-BoldOblique", 
/*  64 */         Arrays.asList(new String[] { "CourierNewPS-BoldItalicMT", "CourierNew-BoldItalic", "LiberationMono-BoldItalic", "NimbusMonL-BoldObli" }));
/*     */     
/*  66 */     this.e.put("Helvetica", 
/*  67 */         Arrays.asList(new String[] { "ArialMT", "Arial", "LiberationSans", "NimbusSanL-Regu" }));
/*  68 */     this.e.put("Helvetica-Bold", 
/*  69 */         Arrays.asList(new String[] { "Arial-BoldMT", "Arial-Bold", "LiberationSans-Bold", "NimbusSanL-Bold" }));
/*     */     
/*  71 */     this.e.put("Helvetica-Oblique", 
/*  72 */         Arrays.asList(new String[] { "Arial-ItalicMT", "Arial-Italic", "Helvetica-Italic", "LiberationSans-Italic", "NimbusSanL-ReguItal" }));
/*     */     
/*  74 */     this.e.put("Helvetica-BoldOblique", 
/*  75 */         Arrays.asList(new String[] { "Arial-BoldItalicMT", "Helvetica-BoldItalic", "LiberationSans-BoldItalic", "NimbusSanL-BoldItal" }));
/*     */     
/*  77 */     this.e.put("Times-Roman", 
/*  78 */         Arrays.asList(new String[] { "TimesNewRomanPSMT", "TimesNewRoman", "TimesNewRomanPS", "LiberationSerif", "NimbusRomNo9L-Regu" }));
/*     */     
/*  80 */     this.e.put("Times-Bold", 
/*  81 */         Arrays.asList(new String[] { "TimesNewRomanPS-BoldMT", "TimesNewRomanPS-Bold", "TimesNewRoman-Bold", "LiberationSerif-Bold", "NimbusRomNo9L-Medi" }));
/*     */ 
/*     */     
/*  84 */     this.e.put("Times-Italic", 
/*  85 */         Arrays.asList(new String[] { "TimesNewRomanPS-ItalicMT", "TimesNewRomanPS-Italic", "TimesNewRoman-Italic", "LiberationSerif-Italic", "NimbusRomNo9L-ReguItal" }));
/*     */ 
/*     */     
/*  88 */     this.e.put("Times-BoldItalic", 
/*  89 */         Arrays.asList(new String[] { "TimesNewRomanPS-BoldItalicMT", "TimesNewRomanPS-BoldItalic", "TimesNewRoman-BoldItalic", "LiberationSerif-BoldItalic", "NimbusRomNo9L-MediItal" }));
/*     */ 
/*     */     
/*  92 */     this.e.put("Symbol", Arrays.asList(new String[] { "Symbol", "SymbolMT", "StandardSymL" }));
/*  93 */     this.e.put("ZapfDingbats", Arrays.asList(new String[] { "ZapfDingbatsITC", "Dingbats", "MS-Gothic" }));
/*     */ 
/*     */ 
/*     */     
/*  97 */     for (String str : ah.a()) {
/*     */       
/*  99 */       if (!this.e.containsKey(str)) {
/*     */         
/* 101 */         String str1 = ah.c(str);
/* 102 */         this.e.put(str, b(str1));
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 110 */       String str = "/org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf";
/*     */       InputStream inputStream;
/* 112 */       if ((inputStream = j.class.getResourceAsStream(str)) == null)
/*     */       {
/* 114 */         throw new IOException("Error loading resource: " + str);
/*     */       }
/* 116 */       al al = new al();
/* 117 */       this.d = al.b(inputStream);
/*     */       return;
/* 119 */     } catch (IOException iOException) {
/*     */       
/* 121 */       throw new RuntimeException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static class a
/*     */   {
/* 128 */     private static final n a = new d(k.a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private synchronized void a(n paramn) {
/* 136 */     this.c = a(paramn.a());
/* 137 */     this.b = paramn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private synchronized n b() {
/* 145 */     if (this.b == null)
/*     */     {
/* 147 */       a(a.a());
/*     */     }
/* 149 */     return this.b;
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
/*     */   private Map<String, i> a(List<? extends i> paramList) {
/* 163 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/* 164 */     for (Iterator<? extends i> iterator = paramList.iterator(); iterator.hasNext();) {
/*     */       
/* 166 */       for (String str : a((i = iterator.next()).a()))
/*     */       {
/* 168 */         linkedHashMap.put(str, i);
/*     */       }
/*     */     } 
/* 171 */     return (Map)linkedHashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Set<String> a(String paramString) {
/*     */     HashSet<String> hashSet;
/* 182 */     (hashSet = new HashSet<String>()).add(paramString);
/*     */ 
/*     */     
/* 185 */     hashSet.add(paramString.replaceAll("-", ""));
/*     */     
/* 187 */     return hashSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> b(String paramString) {
/* 195 */     return new ArrayList<String>(this.e.get(paramString));
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
/*     */   private List<String> c(String paramString) {
/*     */     List<String> list;
/* 219 */     if ((list = this.e.get(paramString.replaceAll(" ", ""))) != null)
/*     */     {
/* 221 */       return list;
/*     */     }
/*     */ 
/*     */     
/* 225 */     return Collections.emptyList();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String a(v paramv) {
/*     */     String str;
/* 235 */     if (paramv != null) {
/*     */ 
/*     */       
/* 238 */       boolean bool = false;
/*     */       
/* 240 */       if ((str = paramv.g()) != null)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 245 */         bool = ((str = paramv.g().toLowerCase()).contains("bold") || str.contains("black") || str.contains("heavy")) ? true : false;
/*     */       }
/*     */ 
/*     */       
/* 249 */       if (paramv.a()) {
/*     */         
/* 251 */         str = "Courier";
/* 252 */         if (bool && paramv.d())
/*     */         {
/* 254 */           str = str + "-BoldOblique";
/*     */         }
/* 256 */         else if (bool)
/*     */         {
/* 258 */           str = str + "-Bold";
/*     */         }
/* 260 */         else if (paramv.d())
/*     */         {
/* 262 */           str = str + "-Oblique";
/*     */         }
/*     */       
/* 265 */       } else if (paramv.b()) {
/*     */         
/* 267 */         str = "Times";
/* 268 */         if (bool && paramv.d())
/*     */         {
/* 270 */           str = str + "-BoldItalic";
/*     */         }
/* 272 */         else if (bool)
/*     */         {
/* 274 */           str = str + "-Bold";
/*     */         }
/* 276 */         else if (paramv.d())
/*     */         {
/* 278 */           str = str + "-Italic";
/*     */         }
/*     */         else
/*     */         {
/* 282 */           str = str + "-Roman";
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 287 */         str = "Helvetica";
/* 288 */         if (bool && paramv.d())
/*     */         {
/* 290 */           str = str + "-BoldOblique";
/*     */         }
/* 292 */         else if (bool)
/*     */         {
/* 294 */           str = str + "-Bold";
/*     */         }
/* 296 */         else if (paramv.d())
/*     */         {
/* 298 */           str = str + "-Oblique";
/*     */         }
/*     */       
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 305 */       str = "Times-Roman";
/*     */     } 
/* 307 */     return str;
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
/*     */   public final m<ap> a(String paramString, v paramv) {
/*     */     ap ap2;
/* 320 */     if ((ap2 = (ap)a(h.a, paramString)) != null)
/*     */     {
/* 322 */       return new m<ap>(ap2, false);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 327 */     String str = a(paramv);
/*     */     ap ap1;
/* 329 */     if ((ap1 = (ap)a(h.a, str)) == null)
/*     */     {
/*     */       
/* 332 */       ap1 = this.d;
/*     */     }
/* 334 */     return new m<ap>(ap1, true);
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
/*     */   public final m<org.a.b.b> b(String paramString, v paramv) {
/*     */     ap ap1;
/*     */     org.a.b.b b2;
/* 349 */     if ((b2 = d(paramString)) != null)
/*     */     {
/* 351 */       return new m<org.a.b.b>(b2, false);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 356 */     String str = a(paramv);
/*     */     org.a.b.b b1;
/* 358 */     if ((b1 = d(str)) == null)
/*     */     {
/*     */       
/* 361 */       ap1 = this.d;
/*     */     }
/* 363 */     return new m(ap1, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private org.a.b.b d(String paramString) {
/*     */     d d;
/* 375 */     if ((d = (d)a(h.c, paramString)) != null)
/*     */     {
/* 377 */       return (org.a.b.b)d;
/*     */     }
/*     */     
/*     */     ap ap1;
/* 381 */     if ((ap1 = (ap)a(h.a, paramString)) != null)
/*     */     {
/* 383 */       return (org.a.b.b)ap1;
/*     */     }
/*     */     
/*     */     ad ad;
/* 387 */     if ((ad = (ad)a(h.b, paramString)) != null)
/*     */     {
/* 389 */       return (org.a.b.b)ad;
/*     */     }
/*     */     
/* 392 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private org.a.b.b a(h paramh, String paramString) {
/* 403 */     if (paramString == null)
/*     */     {
/* 405 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 409 */     if (this.b == null)
/*     */     {
/* 411 */       b();
/*     */     }
/*     */     
/*     */     i i;
/*     */     
/* 416 */     if ((i = b(paramh, paramString)) != null)
/*     */     {
/* 418 */       return i.d();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 423 */     if ((i = b(paramh, paramString.replaceAll("-", ""))) != null)
/*     */     {
/* 425 */       return i.d();
/*     */     }
/*     */ 
/*     */     
/* 429 */     for (String str : c(paramString)) {
/*     */       i i1;
/*     */       
/* 432 */       if ((i1 = b(paramh, str)) != null)
/*     */       {
/* 434 */         return i1.d();
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 440 */     if ((i = b(paramh, paramString.replaceAll(",", "-"))) != null)
/*     */     {
/* 442 */       return i.d();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 447 */     if ((i = b(paramh, paramString + "-Regular")) != null)
/*     */     {
/* 449 */       return i.d();
/*     */     }
/*     */     
/* 452 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private i b(h paramh, String paramString) {
/* 461 */     if (paramString.contains("+"))
/*     */     {
/* 463 */       paramString = paramString.substring(paramString.indexOf('+') + 1);
/*     */     }
/*     */     
/*     */     i i;
/*     */     
/* 468 */     if ((i = this.c.get(paramString)) != null && i.b() == paramh)
/*     */     {
/* 470 */       return i;
/*     */     }
/* 472 */     return null;
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
/*     */   public final a a(String paramString, v paramv, t paramt) {
/*     */     ad ad;
/* 488 */     if ((ad = (ad)a(h.b, paramString)) != null)
/*     */     {
/* 490 */       return new a(ad, null, false);
/*     */     }
/*     */     
/*     */     ap ap1;
/*     */     
/* 495 */     if ((ap1 = (ap)a(h.a, paramString)) != null)
/*     */     {
/* 497 */       return new a(null, (org.a.b.b)ap1, false);
/*     */     }
/*     */     
/* 500 */     if (paramt != null) {
/*     */       String str;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 508 */       if ((str = paramt.a() + "-" + paramt.b()).equals("Adobe-GB1") || str.equals("Adobe-CNS1") || str
/* 509 */         .equals("Adobe-Japan1") || str.equals("Adobe-Korea1")) {
/*     */         b b;
/*     */         
/*     */         PriorityQueue<b> priorityQueue;
/*     */         
/* 514 */         if ((b = (priorityQueue = a(paramv, paramt)).poll()) != null) {
/*     */           org.a.b.b b1;
/*     */           
/* 517 */           if (b1 = b.b.d() instanceof ad)
/*     */           {
/* 519 */             return new a((ad)b1, null, true);
/*     */           }
/* 521 */           if (b1 != null)
/*     */           {
/* 523 */             return new a(null, b1, true);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 530 */     return new a(null, (org.a.b.b)this.d, true);
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
/*     */   private PriorityQueue<b> a(v paramv, t paramt) {
/*     */     // Byte code:
/*     */     //   0: new java/util/PriorityQueue
/*     */     //   3: dup
/*     */     //   4: bipush #20
/*     */     //   6: invokespecial <init> : (I)V
/*     */     //   9: astore_3
/*     */     //   10: aload_0
/*     */     //   11: getfield c : Ljava/util/Map;
/*     */     //   14: invokeinterface values : ()Ljava/util/Collection;
/*     */     //   19: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   24: astore #4
/*     */     //   26: aload #4
/*     */     //   28: invokeinterface hasNext : ()Z
/*     */     //   33: ifeq -> 508
/*     */     //   36: aload #4
/*     */     //   38: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   43: checkcast org/a/c/h/e/i
/*     */     //   46: astore #5
/*     */     //   48: aload_2
/*     */     //   49: ifnull -> 61
/*     */     //   52: aload_2
/*     */     //   53: aload #5
/*     */     //   55: invokestatic a : (Lorg/a/c/h/e/t;Lorg/a/c/h/e/i;)Z
/*     */     //   58: ifeq -> 26
/*     */     //   61: new org/a/c/h/e/k$b
/*     */     //   64: dup
/*     */     //   65: aload #5
/*     */     //   67: invokespecial <init> : (Lorg/a/c/h/e/i;)V
/*     */     //   70: astore #6
/*     */     //   72: aload_1
/*     */     //   73: invokevirtual r : ()Lorg/a/c/h/e/y;
/*     */     //   76: ifnull -> 443
/*     */     //   79: aload #5
/*     */     //   81: invokevirtual j : ()Lorg/a/c/h/e/z;
/*     */     //   84: ifnull -> 443
/*     */     //   87: aload_1
/*     */     //   88: invokevirtual r : ()Lorg/a/c/h/e/y;
/*     */     //   91: invokevirtual a : ()Lorg/a/c/h/e/z;
/*     */     //   94: dup
/*     */     //   95: astore #7
/*     */     //   97: invokevirtual a : ()I
/*     */     //   100: aload #5
/*     */     //   102: invokevirtual j : ()Lorg/a/c/h/e/z;
/*     */     //   105: invokevirtual a : ()I
/*     */     //   108: if_icmpne -> 440
/*     */     //   111: aload #7
/*     */     //   113: invokevirtual a : ()I
/*     */     //   116: ifne -> 155
/*     */     //   119: aload #5
/*     */     //   121: invokevirtual a : ()Ljava/lang/String;
/*     */     //   124: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   127: ldc 'barcode'
/*     */     //   129: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*     */     //   132: ifne -> 148
/*     */     //   135: aload #5
/*     */     //   137: invokevirtual a : ()Ljava/lang/String;
/*     */     //   140: ldc 'Code'
/*     */     //   142: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   145: ifeq -> 155
/*     */     //   148: aload_1
/*     */     //   149: invokestatic b : (Lorg/a/c/h/e/v;)Z
/*     */     //   152: ifeq -> 26
/*     */     //   155: aload #7
/*     */     //   157: invokevirtual b : ()I
/*     */     //   160: aload #5
/*     */     //   162: invokevirtual j : ()Lorg/a/c/h/e/z;
/*     */     //   165: invokevirtual b : ()I
/*     */     //   168: if_icmpne -> 187
/*     */     //   171: aload #6
/*     */     //   173: dup
/*     */     //   174: getfield a : D
/*     */     //   177: ldc2_w 2.0
/*     */     //   180: dadd
/*     */     //   181: putfield a : D
/*     */     //   184: goto -> 333
/*     */     //   187: aload #7
/*     */     //   189: invokevirtual b : ()I
/*     */     //   192: iconst_2
/*     */     //   193: if_icmplt -> 243
/*     */     //   196: aload #7
/*     */     //   198: invokevirtual b : ()I
/*     */     //   201: iconst_5
/*     */     //   202: if_icmpgt -> 243
/*     */     //   205: aload #5
/*     */     //   207: invokevirtual j : ()Lorg/a/c/h/e/z;
/*     */     //   210: invokevirtual b : ()I
/*     */     //   213: iconst_2
/*     */     //   214: if_icmplt -> 243
/*     */     //   217: aload #5
/*     */     //   219: invokevirtual j : ()Lorg/a/c/h/e/z;
/*     */     //   222: invokevirtual b : ()I
/*     */     //   225: iconst_5
/*     */     //   226: if_icmpgt -> 243
/*     */     //   229: aload #6
/*     */     //   231: dup
/*     */     //   232: getfield a : D
/*     */     //   235: dconst_1
/*     */     //   236: dadd
/*     */     //   237: putfield a : D
/*     */     //   240: goto -> 333
/*     */     //   243: aload #7
/*     */     //   245: invokevirtual b : ()I
/*     */     //   248: bipush #11
/*     */     //   250: if_icmplt -> 303
/*     */     //   253: aload #7
/*     */     //   255: invokevirtual b : ()I
/*     */     //   258: bipush #13
/*     */     //   260: if_icmpgt -> 303
/*     */     //   263: aload #5
/*     */     //   265: invokevirtual j : ()Lorg/a/c/h/e/z;
/*     */     //   268: invokevirtual b : ()I
/*     */     //   271: bipush #11
/*     */     //   273: if_icmplt -> 303
/*     */     //   276: aload #5
/*     */     //   278: invokevirtual j : ()Lorg/a/c/h/e/z;
/*     */     //   281: invokevirtual b : ()I
/*     */     //   284: bipush #13
/*     */     //   286: if_icmpgt -> 303
/*     */     //   289: aload #6
/*     */     //   291: dup
/*     */     //   292: getfield a : D
/*     */     //   295: dconst_1
/*     */     //   296: dadd
/*     */     //   297: putfield a : D
/*     */     //   300: goto -> 333
/*     */     //   303: aload #7
/*     */     //   305: invokevirtual b : ()I
/*     */     //   308: ifeq -> 333
/*     */     //   311: aload #5
/*     */     //   313: invokevirtual j : ()Lorg/a/c/h/e/z;
/*     */     //   316: invokevirtual b : ()I
/*     */     //   319: ifeq -> 333
/*     */     //   322: aload #6
/*     */     //   324: dup
/*     */     //   325: getfield a : D
/*     */     //   328: dconst_1
/*     */     //   329: dsub
/*     */     //   330: putfield a : D
/*     */     //   333: aload #5
/*     */     //   335: invokevirtual j : ()Lorg/a/c/h/e/z;
/*     */     //   338: invokevirtual c : ()I
/*     */     //   341: istore #8
/*     */     //   343: aload #5
/*     */     //   345: invokevirtual k : ()I
/*     */     //   348: istore #5
/*     */     //   350: iload #8
/*     */     //   352: iload #5
/*     */     //   354: isub
/*     */     //   355: invokestatic abs : (I)I
/*     */     //   358: iconst_2
/*     */     //   359: if_icmple -> 366
/*     */     //   362: iload #5
/*     */     //   364: istore #8
/*     */     //   366: aload #7
/*     */     //   368: invokevirtual c : ()I
/*     */     //   371: iload #8
/*     */     //   373: if_icmpne -> 392
/*     */     //   376: aload #6
/*     */     //   378: dup
/*     */     //   379: getfield a : D
/*     */     //   382: ldc2_w 2.0
/*     */     //   385: dadd
/*     */     //   386: putfield a : D
/*     */     //   389: goto -> 498
/*     */     //   392: aload #7
/*     */     //   394: invokevirtual c : ()I
/*     */     //   397: iconst_1
/*     */     //   398: if_icmple -> 440
/*     */     //   401: iload #8
/*     */     //   403: iconst_1
/*     */     //   404: if_icmple -> 440
/*     */     //   407: aload #7
/*     */     //   409: invokevirtual c : ()I
/*     */     //   412: iload #8
/*     */     //   414: isub
/*     */     //   415: invokestatic abs : (I)I
/*     */     //   418: i2f
/*     */     //   419: fstore #5
/*     */     //   421: aload #6
/*     */     //   423: dup
/*     */     //   424: getfield a : D
/*     */     //   427: dconst_1
/*     */     //   428: fload #5
/*     */     //   430: f2d
/*     */     //   431: ldc2_w 0.5
/*     */     //   434: dmul
/*     */     //   435: dsub
/*     */     //   436: dadd
/*     */     //   437: putfield a : D
/*     */     //   440: goto -> 498
/*     */     //   443: aload_1
/*     */     //   444: invokevirtual i : ()F
/*     */     //   447: fconst_0
/*     */     //   448: fcmpl
/*     */     //   449: ifle -> 498
/*     */     //   452: aload #5
/*     */     //   454: invokevirtual f : ()I
/*     */     //   457: ifle -> 498
/*     */     //   460: aload_1
/*     */     //   461: invokevirtual i : ()F
/*     */     //   464: aload #5
/*     */     //   466: invokevirtual f : ()I
/*     */     //   469: i2f
/*     */     //   470: fsub
/*     */     //   471: invokestatic abs : (F)F
/*     */     //   474: fstore #7
/*     */     //   476: aload #6
/*     */     //   478: dup
/*     */     //   479: getfield a : D
/*     */     //   482: dconst_1
/*     */     //   483: fload #7
/*     */     //   485: ldc 100.0
/*     */     //   487: fdiv
/*     */     //   488: f2d
/*     */     //   489: ldc2_w 0.5
/*     */     //   492: dmul
/*     */     //   493: dsub
/*     */     //   494: dadd
/*     */     //   495: putfield a : D
/*     */     //   498: aload_3
/*     */     //   499: aload #6
/*     */     //   501: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   504: pop
/*     */     //   505: goto -> 26
/*     */     //   508: aload_3
/*     */     //   509: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #543	-> 0
/*     */     //   #545	-> 10
/*     */     //   #548	-> 48
/*     */     //   #553	-> 61
/*     */     //   #556	-> 72
/*     */     //   #558	-> 87
/*     */     //   #559	-> 95
/*     */     //   #561	-> 111
/*     */     //   #562	-> 121
/*     */     //   #563	-> 137
/*     */     //   #564	-> 149
/*     */     //   #570	-> 155
/*     */     //   #573	-> 171
/*     */     //   #575	-> 187
/*     */     //   #576	-> 207
/*     */     //   #577	-> 219
/*     */     //   #580	-> 229
/*     */     //   #582	-> 243
/*     */     //   #583	-> 265
/*     */     //   #584	-> 278
/*     */     //   #587	-> 289
/*     */     //   #589	-> 303
/*     */     //   #592	-> 322
/*     */     //   #596	-> 333
/*     */     //   #597	-> 343
/*     */     //   #598	-> 350
/*     */     //   #601	-> 362
/*     */     //   #604	-> 366
/*     */     //   #607	-> 376
/*     */     //   #609	-> 392
/*     */     //   #611	-> 407
/*     */     //   #612	-> 421
/*     */     //   #618	-> 440
/*     */     //   #619	-> 443
/*     */     //   #622	-> 460
/*     */     //   #623	-> 476
/*     */     //   #628	-> 498
/*     */     //   #629	-> 505
/*     */     //   #630	-> 508
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
/*     */   private static boolean b(v paramv) {
/*     */     String str2;
/* 636 */     if ((str2 = paramv.h()) == null)
/*     */     {
/* 638 */       str2 = "";
/*     */     }
/*     */     String str1;
/* 641 */     if ((str1 = paramv.g()) == null)
/*     */     {
/* 643 */       str1 = "";
/*     */     }
/* 645 */     if (str2.startsWith("Code") || str2.toLowerCase().contains("barcode") || str1
/* 646 */       .startsWith("Code") || str1.toLowerCase().contains("barcode")) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean a(t paramt, i parami) {
/* 655 */     if (parami.c() != null) {
/*     */       
/* 657 */       if (parami.c().a().equals(paramt.a()) && parami
/* 658 */         .c().b().equals(paramt.b())) return true;
/*     */       
/*     */       return false;
/*     */     } 
/* 662 */     long l = parami.l();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 670 */     if (paramt.b().equals("GB1") && (l & 0x40000L) == 262144L)
/*     */     {
/*     */       
/* 673 */       return true;
/*     */     }
/* 675 */     if (paramt.b().equals("CNS1") && (l & 0x100000L) == 1048576L)
/*     */     {
/*     */       
/* 678 */       return true;
/*     */     }
/* 680 */     if (paramt.b().equals("Japan1") && (l & 0x20000L) == 131072L)
/*     */     {
/*     */       
/* 683 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 687 */     return ((paramt.b().equals("Korea1") && (l & 0x80000L) == 524288L) || (l & 0x200000L) == 2097152L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class b
/*     */     implements Comparable<b>
/*     */   {
/*     */     double a;
/*     */ 
/*     */     
/*     */     final i b;
/*     */ 
/*     */ 
/*     */     
/*     */     b(i param1i) {
/* 704 */       this.b = param1i;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private int a(b param1b) {
/* 710 */       return Double.compare(param1b.a, this.a);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */