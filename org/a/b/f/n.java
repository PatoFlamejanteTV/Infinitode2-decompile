/*     */ package org.a.b.f;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class n
/*     */   extends an
/*     */ {
/*  42 */   private static final org.a.a.a.a c = org.a.a.a.c.a(n.class);
/*     */ 
/*     */   
/*     */   private LinkedHashMap<String, n> d;
/*     */   
/*     */   private d[] e;
/*     */   
/*     */   private i[] f;
/*     */   
/*  51 */   private final Map<Integer, Integer> g = new HashMap<Integer, Integer>();
/*  52 */   private final Map<Integer, Integer> h = new HashMap<Integer, Integer>();
/*     */   
/*     */   private String i;
/*     */ 
/*     */   
/*     */   n(ap paramap) {
/*  58 */     super(paramap);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   final void a(ap paramap, ak paramak) {
/*  64 */     long l = paramak.e();
/*     */     
/*  66 */     paramak.c();
/*  67 */     int j = paramak.c();
/*  68 */     int k = paramak.c();
/*  69 */     int m = paramak.c();
/*  70 */     int i1 = paramak.c();
/*     */ 
/*     */     
/*  73 */     if (j == 1L)
/*     */     {
/*  75 */       paramak.k();
/*     */     }
/*     */     
/*  78 */     this.d = a(paramak, l + k);
/*  79 */     this.e = d(paramak, l + m);
/*  80 */     this.f = f(paramak, l + i1);
/*     */   }
/*     */ 
/*     */   
/*     */   private LinkedHashMap<String, n> a(ak paramak, long paramLong) {
/*  85 */     paramak.a(paramLong);
/*     */     int k;
/*  87 */     m[] arrayOfM1 = new m[k = paramak.c()];
/*  88 */     int[] arrayOfInt = new int[k]; byte b2;
/*  89 */     for (b2 = 0; b2 < k; b2++) {
/*     */       m m;
/*     */       
/*  92 */       (m = new m()).a = paramak.a(4);
/*  93 */       arrayOfInt[b2] = paramak.c();
/*  94 */       arrayOfM1[b2] = m;
/*     */     } 
/*  96 */     for (b2 = 0; b2 < k; b2++)
/*     */     {
/*  98 */       (arrayOfM1[b2]).b = b(paramak, paramLong + arrayOfInt[b2]);
/*     */     }
/* 100 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(k); int j; byte b1; m[] arrayOfM2;
/* 101 */     for (j = (arrayOfM2 = arrayOfM1).length, b1 = 0; b1 < j; ) { m m = arrayOfM2[b1];
/*     */       
/* 103 */       linkedHashMap.put(m.a, m.b); b1++; }
/*     */     
/* 105 */     return (LinkedHashMap)linkedHashMap;
/*     */   }
/*     */ 
/*     */   
/*     */   private n b(ak paramak, long paramLong) {
/* 110 */     paramak.a(paramLong);
/* 111 */     n n1 = new n();
/* 112 */     int j = paramak.c();
/*     */     int k;
/* 114 */     f[] arrayOfF1 = new f[k = paramak.c()];
/* 115 */     int[] arrayOfInt = new int[k];
/* 116 */     String str = ""; byte b2;
/* 117 */     for (b2 = 0; b2 < k; b2++) {
/*     */       f f;
/*     */       
/* 120 */       (f = new f()).a = paramak.a(4);
/* 121 */       if (b2 > 0 && f.a.compareTo(str) <= 0)
/*     */       {
/*     */ 
/*     */         
/* 125 */         throw new IOException("LangSysRecords not alphabetically sorted by LangSys tag: " + f.a + " <= " + str);
/*     */       }
/*     */       
/* 128 */       arrayOfInt[b2] = paramak.c();
/* 129 */       arrayOfF1[b2] = f;
/* 130 */       str = f.a;
/*     */     } 
/* 132 */     if (j != 0)
/*     */     {
/* 134 */       n1.a = c(paramak, paramLong + j);
/*     */     }
/* 136 */     for (b2 = 0; b2 < k; b2++)
/*     */     {
/* 138 */       (arrayOfF1[b2]).b = c(paramak, paramLong + arrayOfInt[b2]);
/*     */     }
/* 140 */     n1.b = new LinkedHashMap<String, g>(k); byte b1; f[] arrayOfF2; int m;
/* 141 */     for (m = (arrayOfF2 = arrayOfF1).length, b1 = 0; b1 < m; ) { f f = arrayOfF2[b1];
/*     */       
/* 143 */       n1.b.put(f.a, f.b); b1++; }
/*     */     
/* 145 */     return n1;
/*     */   }
/*     */ 
/*     */   
/*     */   private static g c(ak paramak, long paramLong) {
/* 150 */     paramak.a(paramLong);
/* 151 */     g g = new g();
/*     */     
/* 153 */     paramak.c();
/* 154 */     g.a = paramak.c();
/* 155 */     int j = paramak.c();
/* 156 */     g.b = new int[j];
/* 157 */     for (byte b = 0; b < j; b++)
/*     */     {
/* 159 */       g.b[b] = paramak.c();
/*     */     }
/* 161 */     return g;
/*     */   }
/*     */ 
/*     */   
/*     */   private d[] d(ak paramak, long paramLong) {
/* 166 */     paramak.a(paramLong);
/*     */     int j;
/* 168 */     d[] arrayOfD = new d[j = paramak.c()];
/* 169 */     int[] arrayOfInt = new int[j]; byte b;
/* 170 */     for (b = 0; b < j; b++) {
/*     */       d d1;
/*     */       
/* 173 */       (d1 = new d()).a = paramak.a(4);
/* 174 */       arrayOfInt[b] = paramak.c();
/* 175 */       arrayOfD[b] = d1;
/*     */     } 
/* 177 */     for (b = 0; b < j; b++)
/*     */     {
/* 179 */       (arrayOfD[b]).b = e(paramak, paramLong + arrayOfInt[b]);
/*     */     }
/* 181 */     return arrayOfD;
/*     */   }
/*     */ 
/*     */   
/*     */   private static e e(ak paramak, long paramLong) {
/* 186 */     paramak.a(paramLong);
/* 187 */     e e = new e();
/*     */     
/* 189 */     paramak.c();
/* 190 */     int j = paramak.c();
/* 191 */     e.a = new int[j];
/* 192 */     for (byte b = 0; b < j; b++)
/*     */     {
/* 194 */       e.a[b] = paramak.c();
/*     */     }
/* 196 */     return e;
/*     */   }
/*     */ 
/*     */   
/*     */   private i[] f(ak paramak, long paramLong) {
/* 201 */     paramak.a(paramLong);
/*     */     
/* 203 */     int j, arrayOfInt[] = new int[j = paramak.c()];
/* 204 */     for (byte b1 = 0; b1 < j; b1++)
/*     */     {
/* 206 */       arrayOfInt[b1] = paramak.c();
/*     */     }
/* 208 */     i[] arrayOfI = new i[j];
/* 209 */     for (byte b2 = 0; b2 < j; b2++)
/*     */     {
/* 211 */       arrayOfI[b2] = g(paramak, paramLong + arrayOfInt[b2]);
/*     */     }
/* 213 */     return arrayOfI;
/*     */   }
/*     */ 
/*     */   
/*     */   private i g(ak paramak, long paramLong) {
/* 218 */     paramak.a(paramLong);
/*     */     i i1;
/* 220 */     (i1 = new i()).a = paramak.c();
/* 221 */     i1.b = paramak.c();
/*     */     
/* 223 */     int j, arrayOfInt[] = new int[j = paramak.c()]; byte b;
/* 224 */     for (b = 0; b < j; b++)
/*     */     {
/* 226 */       arrayOfInt[b] = paramak.c();
/*     */     }
/* 228 */     if ((i1.b & 0x10) != 0)
/*     */     {
/* 230 */       i1.c = paramak.c();
/*     */     }
/* 232 */     i1.d = new h[j];
/* 233 */     switch (i1.a)
/*     */     
/*     */     { case 1:
/* 236 */         for (b = 0; b < j; b++)
/*     */         {
/* 238 */           i1.d[b] = h(paramak, paramLong + arrayOfInt[b]);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 245 */         return i1; }  (new StringBuilder("Type ")).append(i1.a).append(" GSUB lookup table is not supported and will be ignored"); return i1; } private h h(ak paramak, long paramLong) {
/*     */     j j1;
/*     */     k k;
/*     */     int m;
/*     */     byte b;
/* 250 */     paramak.a(paramLong);
/*     */     int j;
/* 252 */     switch (j = paramak.c()) {
/*     */ 
/*     */ 
/*     */       
/*     */       case 1:
/* 257 */         (j1 = new j()).a = j;
/* 258 */         j = paramak.c();
/* 259 */         j1.c = paramak.d();
/* 260 */         j1.b = i(paramak, paramLong + j);
/* 261 */         return j1;
/*     */ 
/*     */ 
/*     */       
/*     */       case 2:
/* 266 */         (k = new k()).a = j;
/* 267 */         j = paramak.c();
/* 268 */         m = paramak.c();
/* 269 */         k.c = new int[m];
/* 270 */         for (b = 0; b < m; b++)
/*     */         {
/* 272 */           k.c[b] = paramak.c();
/*     */         }
/* 274 */         k.b = i(paramak, paramLong + j);
/* 275 */         return k;
/*     */     } 
/*     */     
/* 278 */     throw new IllegalArgumentException("Unknown substFormat: " + j);
/*     */   }
/*     */   private a i(ak paramak, long paramLong) {
/*     */     b b;
/*     */     c c;
/*     */     byte b1;
/* 284 */     paramak.a(paramLong);
/*     */     int j;
/* 286 */     switch (j = paramak.c()) {
/*     */ 
/*     */ 
/*     */       
/*     */       case 1:
/* 291 */         (b = new b()).a = j;
/* 292 */         j = paramak.c();
/* 293 */         b.b = new int[j];
/* 294 */         for (b1 = 0; b1 < j; b1++)
/*     */         {
/* 296 */           b.b[b1] = paramak.c();
/*     */         }
/* 298 */         return b;
/*     */ 
/*     */ 
/*     */       
/*     */       case 2:
/* 303 */         (c = new c()).a = j;
/* 304 */         j = paramak.c();
/* 305 */         c.b = new l[j];
/* 306 */         for (b1 = 0; b1 < j; b1++)
/*     */         {
/* 308 */           c.b[b1] = a(paramak);
/*     */         }
/* 310 */         return c;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 315 */     throw new IllegalArgumentException("Unknown coverage format: " + j);
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
/*     */   private String a(String[] paramArrayOfString) {
/* 329 */     if (paramArrayOfString.length == 1) {
/*     */       
/* 331 */       String str = paramArrayOfString[0];
/* 332 */       if ("Inherited".equals(str) || ("DFLT"
/* 333 */         .equals(str) && !this.d.containsKey(str))) {
/*     */ 
/*     */         
/* 336 */         if (this.i == null)
/*     */         {
/*     */           
/* 339 */           this.i = this.d.keySet().iterator().next();
/*     */         }
/*     */ 
/*     */         
/* 343 */         return this.i;
/*     */       } 
/*     */     }  String[] arrayOfString; int j; byte b;
/* 346 */     for (j = (arrayOfString = paramArrayOfString).length, b = 0; b < j; ) { String str = arrayOfString[b];
/*     */       
/* 348 */       if (this.d.containsKey(str)) {
/*     */ 
/*     */ 
/*     */         
/* 352 */         this.i = str;
/* 353 */         return this.i;
/*     */       }  b++; }
/*     */     
/* 356 */     return paramArrayOfString[0];
/*     */   }
/*     */ 
/*     */   
/*     */   private Collection<g> b(String paramString) {
/* 361 */     List<?> list = Collections.emptyList();
/*     */     n n1;
/* 363 */     if ((n1 = this.d.get(paramString)) != null)
/*     */     {
/* 365 */       if (n1.a == null) {
/*     */         
/* 367 */         Collection<g> collection = n1.b.values();
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 372 */         (list = new ArrayList(n1.b.values())).add(n1.a);
/*     */       } 
/*     */     }
/* 375 */     return (Collection)list;
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
/*     */   private List<d> a(Collection<g> paramCollection, List<String> paramList) {
/* 394 */     if (paramCollection.isEmpty())
/*     */     {
/* 396 */       return Collections.emptyList();
/*     */     }
/* 398 */     ArrayList<d> arrayList = new ArrayList();
/* 399 */     for (Iterator<g> iterator = paramCollection.iterator(); iterator.hasNext(); ) {
/*     */       g g;
/*     */       int j;
/* 402 */       if ((j = (g = iterator.next()).a) != 65535)
/*     */       {
/* 404 */         arrayList.add(this.e[j]); }  int[] arrayOfInt;
/*     */       byte b;
/* 406 */       for (j = (arrayOfInt = g.b).length, b = 0; b < j; ) { int k = arrayOfInt[b];
/*     */         
/* 408 */         if (paramList == null || paramList
/* 409 */           .contains((this.e[k]).a))
/*     */         {
/* 411 */           arrayList.add(this.e[k]);
/*     */         }
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/*     */     
/* 418 */     if (a(arrayList, "vrt2"))
/*     */     {
/* 420 */       b(arrayList, "vert");
/*     */     }
/*     */     
/* 423 */     if (paramList != null && arrayList.size() > 1)
/*     */     {
/* 425 */       Collections.sort(arrayList, new o(this, paramList));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 437 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean a(List<d> paramList, String paramString) {
/* 442 */     for (Iterator<d> iterator = paramList.iterator(); iterator.hasNext();) {
/*     */       
/* 444 */       if ((d1 = iterator.next()).a.equals(paramString))
/*     */       {
/* 446 */         return true;
/*     */       }
/*     */     } 
/* 449 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void b(List<d> paramList, String paramString) {
/* 454 */     Iterator<d> iterator = paramList.iterator();
/* 455 */     while (iterator.hasNext()) {
/*     */       
/* 457 */       if (((d)iterator.next()).a.equals(paramString))
/*     */       {
/* 459 */         iterator.remove(); } 
/*     */     } 
/*     */   }
/*     */   private int a(d paramd, int paramInt) {
/*     */     int[] arrayOfInt;
/*     */     int j;
/*     */     byte b;
/* 466 */     for (j = (arrayOfInt = paramd.b.a).length, b = 0; b < j; ) { int k = arrayOfInt[b];
/*     */       
/*     */       i i1;
/* 469 */       if ((i1 = this.f[k]).a != 1) {
/*     */         
/* 471 */         (new StringBuilder("Skipping GSUB feature '")).append(paramd.a).append("' because it requires unsupported lookup table type ").append(i1.a);
/*     */       }
/*     */       else {
/*     */         
/* 475 */         paramInt = a(i1, paramInt);
/*     */       }  b++; }
/* 477 */      return paramInt;
/*     */   } private static int a(i parami, int paramInt) {
/*     */     h[] arrayOfH;
/*     */     int j;
/*     */     byte b;
/* 482 */     for (j = (arrayOfH = parami.d).length, b = 0; b < j; b++) {
/*     */       h h;
/*     */       int k;
/* 485 */       if ((k = (h = arrayOfH[b]).b.a(paramInt)) >= 0)
/*     */       {
/* 487 */         return h.a(paramInt, k);
/*     */       }
/*     */     } 
/* 490 */     return paramInt;
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
/*     */   public final int a(int paramInt, String[] paramArrayOfString, List<String> paramList) {
/* 508 */     if (paramInt == -1)
/*     */     {
/* 510 */       return -1;
/*     */     }
/*     */     Integer integer;
/* 513 */     if ((integer = this.g.get(Integer.valueOf(paramInt))) != null)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 518 */       return integer.intValue();
/*     */     }
/* 520 */     String str = a(paramArrayOfString);
/* 521 */     Collection<g> collection = b(str);
/* 522 */     collection = (Collection)a(collection, paramList);
/* 523 */     int j = paramInt;
/* 524 */     for (d d1 : collection)
/*     */     {
/* 526 */       j = a(d1, j);
/*     */     }
/* 528 */     this.g.put(Integer.valueOf(paramInt), Integer.valueOf(j));
/* 529 */     this.h.put(Integer.valueOf(j), Integer.valueOf(paramInt));
/* 530 */     return j;
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
/*     */   public final int a(int paramInt) {
/*     */     Integer integer;
/* 545 */     if ((integer = this.h.get(Integer.valueOf(paramInt))) == null) {
/*     */       
/* 547 */       (new StringBuilder("Trying to un-substitute a never-before-seen gid: ")).append(paramInt);
/* 548 */       return paramInt;
/*     */     } 
/* 550 */     return integer.intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   private static l a(ak paramak) {
/*     */     l l;
/* 556 */     (l = new l()).a = paramak.c();
/* 557 */     l.b = paramak.c();
/* 558 */     l.c = paramak.c();
/* 559 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   static class m
/*     */   {
/*     */     String a;
/*     */     
/*     */     n.n b;
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 571 */       return String.format("ScriptRecord[scriptTag=%s]", new Object[] { this.a });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class n
/*     */   {
/*     */     n.g a;
/*     */     
/*     */     LinkedHashMap<String, n.g> b;
/*     */     
/*     */     public final String toString() {
/* 583 */       return String.format("ScriptTable[hasDefault=%s,langSysRecordsCount=%d]", new Object[] {
/* 584 */             Boolean.valueOf((this.a != null)), Integer.valueOf(this.b.size())
/*     */           });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class f
/*     */   {
/*     */     String a;
/*     */     
/*     */     n.g b;
/*     */     
/*     */     public final String toString() {
/* 597 */       return String.format("LangSysRecord[langSysTag=%s]", new Object[] { this.a });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class g
/*     */   {
/*     */     int a;
/*     */     
/*     */     int[] b;
/*     */     
/*     */     public final String toString() {
/* 609 */       return String.format("LangSysTable[requiredFeatureIndex=%d]", new Object[] { Integer.valueOf(this.a) });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class d
/*     */   {
/*     */     String a;
/*     */     
/*     */     n.e b;
/*     */     
/*     */     public final String toString() {
/* 621 */       return String.format("FeatureRecord[featureTag=%s]", new Object[] { this.a });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class e
/*     */   {
/*     */     int[] a;
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 632 */       return String.format("FeatureTable[lookupListIndiciesCount=%d]", new Object[] {
/* 633 */             Integer.valueOf(this.a.length)
/*     */           });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class i
/*     */   {
/*     */     int a;
/*     */     int b;
/*     */     int c;
/*     */     n.h[] d;
/*     */     
/*     */     public final String toString() {
/* 647 */       return String.format("LookupTable[lookupType=%d,lookupFlag=%d,markFilteringSet=%d]", new Object[] {
/* 648 */             Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c)
/*     */           });
/*     */     }
/*     */   }
/*     */   
/*     */   static abstract class h
/*     */   {
/*     */     int a;
/*     */     n.a b;
/*     */     
/*     */     abstract int a(int param1Int1, int param1Int2);
/*     */   }
/*     */   
/*     */   static class j
/*     */     extends h
/*     */   {
/*     */     short c;
/*     */     
/*     */     final int a(int param1Int1, int param1Int2) {
/* 667 */       return (param1Int2 < 0) ? param1Int1 : (param1Int1 + this.c);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 673 */       return String.format("LookupTypeSingleSubstFormat1[substFormat=%d,deltaGlyphID=%d]", new Object[] {
/* 674 */             Integer.valueOf(this.a), Short.valueOf(this.c)
/*     */           });
/*     */     }
/*     */   }
/*     */   
/*     */   static class k
/*     */     extends h
/*     */   {
/*     */     int[] c;
/*     */     
/*     */     final int a(int param1Int1, int param1Int2) {
/* 685 */       return (param1Int2 < 0) ? param1Int1 : this.c[param1Int2];
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 691 */       return String.format("LookupTypeSingleSubstFormat2[substFormat=%d,substituteGlyphIDs=%s]", new Object[] {
/*     */             
/* 693 */             Integer.valueOf(this.a), Arrays.toString(this.c)
/*     */           });
/*     */     }
/*     */   }
/*     */   
/*     */   static abstract class a
/*     */   {
/*     */     int a;
/*     */     
/*     */     abstract int a(int param1Int);
/*     */   }
/*     */   
/*     */   static class b
/*     */     extends a
/*     */   {
/*     */     int[] b;
/*     */     
/*     */     final int a(int param1Int) {
/* 711 */       return Arrays.binarySearch(this.b, param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 717 */       return String.format("CoverageTableFormat1[coverageFormat=%d,glyphArray=%s]", new Object[] {
/* 718 */             Integer.valueOf(this.a), Arrays.toString(this.b) });
/*     */     }
/*     */   }
/*     */   
/*     */   static class c extends a {
/*     */     n.l[] b;
/*     */     
/*     */     final int a(int param1Int) {
/*     */       n.l[] arrayOfL;
/*     */       int i;
/*     */       byte b;
/* 729 */       for (i = (arrayOfL = this.b).length, b = 0; b < i; ) {
/*     */         n.l l1;
/* 731 */         if ((l1 = arrayOfL[b]).a <= param1Int && param1Int <= l1.b)
/*     */         {
/* 733 */           return l1.c + param1Int - l1.a; } 
/*     */         b++;
/*     */       } 
/* 736 */       return -1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 742 */       return String.format("CoverageTableFormat2[coverageFormat=%d]", new Object[] { Integer.valueOf(this.a) });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class l
/*     */   {
/*     */     int a;
/*     */     
/*     */     int b;
/*     */     int c;
/*     */     
/*     */     public final String toString() {
/* 755 */       return String.format("RangeRecord[startGlyphID=%d,endGlyphID=%d,startCoverageIndex=%d]", new Object[] {
/* 756 */             Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c)
/*     */           });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */