/*     */ package org.a.c.f;
/*     */ 
/*     */ import java.io.OutputStream;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import java.util.TreeSet;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.e;
/*     */ import org.a.c.b.i;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.p;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class h
/*     */ {
/*     */   private final Map<Long, Object> a;
/*     */   private final Set<Long> b;
/*     */   private final p c;
/*  57 */   private long d = -1L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public h() {
/*  67 */     this.c = new p();
/*  68 */     this.a = new TreeMap<Long, Object>();
/*  69 */     this.b = new TreeSet<Long>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public h(e parame) {
/*  79 */     this.c = parame.a();
/*  80 */     this.a = new TreeMap<Long, Object>();
/*  81 */     this.b = new TreeSet<Long>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final p a() {
/*  91 */     this.c.a(j.dN, (org.a.c.b.b)j.ef);
/*  92 */     if (this.d == -1L)
/*     */     {
/*  94 */       throw new IllegalArgumentException("size is not set in xrefstream");
/*     */     }
/*  96 */     this.c.a(j.dr, this.d);
/*     */     
/*  98 */     List<Long> list = c();
/*  99 */     org.a.c.b.a a1 = new org.a.c.b.a();
/* 100 */     for (Long long_ : list)
/*     */     {
/* 102 */       a1.a((org.a.c.b.b)i.a(long_.longValue()));
/*     */     }
/* 104 */     this.c.a(j.bG, (org.a.c.b.b)a1);
/*     */     
/* 106 */     int[] arrayOfInt1 = b();
/* 107 */     org.a.c.b.a a2 = new org.a.c.b.a(); int[] arrayOfInt2; byte b;
/* 108 */     for (arrayOfInt2 = arrayOfInt1, b = 0; b < 3; ) { int i = arrayOfInt2[b];
/*     */       
/* 110 */       a2.a((org.a.c.b.b)i.a(i)); b++; }
/*     */     
/* 112 */     this.c.a(j.dX, (org.a.c.b.b)a2);
/*     */     
/* 114 */     OutputStream outputStream = this.c.a((org.a.c.b.b)j.bc);
/* 115 */     a(outputStream, arrayOfInt1);
/* 116 */     outputStream.flush();
/* 117 */     outputStream.close();
/*     */     
/*     */     Set<?> set;
/* 120 */     for (j j : set = this.c.d()) {
/*     */ 
/*     */ 
/*     */       
/* 124 */       if (!j.di.equals(j) && !j.bI.equals(j) && !j.cU.equals(j))
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 129 */         if (!j.aS.equals(j)) {
/*     */           org.a.c.b.b b1;
/*     */ 
/*     */ 
/*     */           
/* 134 */           (b1 = this.c.a(j)).a(true);
/*     */         }  } 
/* 136 */     }  return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(d paramd) {
/*     */     Set<?> set;
/* 147 */     for (Iterator<?> iterator = (set = paramd.e()).iterator(); iterator.hasNext(); ) {
/*     */       Map.Entry<j, ?> entry;
/* 149 */       j j = (entry = (Map.Entry<j, ?>)iterator.next()).getKey();
/* 150 */       if (j.bI.equals(j) || j.di.equals(j) || j.aS.equals(j) || j.bA
/* 151 */         .equals(j) || j.cU.equals(j))
/*     */       {
/* 153 */         this.c.a(j, (org.a.c.b.b)entry.getValue());
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
/*     */   public final void a(org.a.c.g.c paramc) {
/* 165 */     this.b.add(Long.valueOf(paramc.b().b()));
/* 166 */     if (paramc.d()) {
/*     */       a a;
/*     */ 
/*     */       
/* 170 */       (a = new a()).a = paramc.b().a();
/* 171 */       a.b = paramc.b().b();
/* 172 */       this.a.put(Long.valueOf(a.b), a);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     b b;
/*     */     
/* 179 */     (b = new b()).a = paramc.b().a();
/* 180 */     b.b = paramc.c();
/* 181 */     this.a.put(Long.valueOf(paramc.b().b()), b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int[] b() {
/* 192 */     long[] arrayOfLong = new long[3];
/* 193 */     for (Iterator<Object> iterator = this.a.values().iterator(); iterator.hasNext(); ) {
/*     */       b b1; a a;
/* 195 */       if (a = (a)iterator.next() instanceof a) {
/*     */         
/* 197 */         a = a;
/* 198 */         arrayOfLong[0] = Math.max(arrayOfLong[0], 0L);
/* 199 */         arrayOfLong[1] = Math.max(arrayOfLong[1], a.b);
/* 200 */         arrayOfLong[2] = Math.max(arrayOfLong[2], a.a); continue;
/*     */       } 
/* 202 */       if (a instanceof b) {
/*     */         
/* 204 */         b1 = (b)a;
/* 205 */         arrayOfLong[0] = Math.max(arrayOfLong[0], 1L);
/* 206 */         arrayOfLong[1] = Math.max(arrayOfLong[1], b1.b);
/* 207 */         arrayOfLong[2] = Math.max(arrayOfLong[2], b1.a); continue;
/*     */       } 
/* 209 */       if (b1 instanceof c) {
/*     */ 
/*     */         
/* 212 */         arrayOfLong[0] = Math.max(arrayOfLong[0], 2L);
/* 213 */         arrayOfLong[1] = Math.max(arrayOfLong[1], 0L);
/* 214 */         arrayOfLong[2] = Math.max(arrayOfLong[2], 0L);
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 219 */       throw new RuntimeException("unexpected reference type");
/*     */     } 
/*     */ 
/*     */     
/* 223 */     int[] arrayOfInt = new int[3];
/* 224 */     for (byte b = 0; b < 3; b++) {
/*     */       
/* 226 */       while (arrayOfLong[b] > 0L) {
/*     */         
/* 228 */         arrayOfInt[b] = arrayOfInt[b] + 1;
/* 229 */         arrayOfLong[b] = arrayOfLong[b] >> 8L;
/*     */       } 
/*     */     } 
/* 232 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(long paramLong) {
/* 242 */     this.d = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   private List<Long> c() {
/* 247 */     LinkedList<Long> linkedList = new LinkedList();
/* 248 */     Long long_1 = null;
/* 249 */     Long long_2 = null;
/*     */     
/*     */     TreeSet<Long> treeSet;
/* 252 */     (treeSet = new TreeSet<Long>()).add(Long.valueOf(0L));
/* 253 */     treeSet.addAll(this.b);
/* 254 */     for (Long long_ : treeSet) {
/*     */       
/* 256 */       if (long_1 == null) {
/*     */         
/* 258 */         long_1 = long_;
/* 259 */         long_2 = Long.valueOf(1L);
/*     */       } 
/* 261 */       if (long_1.longValue() + long_2.longValue() == long_.longValue())
/*     */       {
/* 263 */         long_2 = Long.valueOf(long_2.longValue() + 1L);
/*     */       }
/* 265 */       if (long_1.longValue() + long_2.longValue() < long_.longValue()) {
/*     */         
/* 267 */         linkedList.add(long_1);
/* 268 */         linkedList.add(long_2);
/* 269 */         long_1 = long_;
/* 270 */         long_2 = Long.valueOf(1L);
/*     */       } 
/*     */     } 
/* 273 */     linkedList.add(long_1);
/* 274 */     linkedList.add(long_2);
/*     */     
/* 276 */     return linkedList;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void a(OutputStream paramOutputStream, long paramLong, int paramInt) {
/* 281 */     byte[] arrayOfByte = new byte[paramInt]; byte b;
/* 282 */     for (b = 0; b < paramInt; b++) {
/*     */       
/* 284 */       arrayOfByte[b] = (byte)(int)(paramLong & 0xFFL);
/* 285 */       paramLong >>= 8L;
/*     */     } 
/*     */     
/* 288 */     for (b = 0; b < paramInt; b++)
/*     */     {
/* 290 */       paramOutputStream.write(arrayOfByte[paramInt - b - 1]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(OutputStream paramOutputStream, int[] paramArrayOfint) {
/* 297 */     a(paramOutputStream, 0L, paramArrayOfint[0]);
/* 298 */     a(paramOutputStream, 0L, paramArrayOfint[1]);
/* 299 */     a(paramOutputStream, 65535L, paramArrayOfint[2]);
/*     */     
/* 301 */     for (Iterator<Object> iterator = this.a.values().iterator(); iterator.hasNext(); ) {
/*     */       b b; a a;
/* 303 */       if (a = (a)iterator.next() instanceof a) {
/*     */         
/* 305 */         a = a;
/* 306 */         a(paramOutputStream, 0L, paramArrayOfint[0]);
/* 307 */         a(paramOutputStream, a.b, paramArrayOfint[1]);
/* 308 */         a(paramOutputStream, a.a, paramArrayOfint[2]); continue;
/*     */       } 
/* 310 */       if (a instanceof b) {
/*     */         
/* 312 */         b = (b)a;
/* 313 */         a(paramOutputStream, 1L, paramArrayOfint[0]);
/* 314 */         a(paramOutputStream, b.b, paramArrayOfint[1]);
/* 315 */         a(paramOutputStream, b.a, paramArrayOfint[2]); continue;
/*     */       } 
/* 317 */       if (b instanceof c) {
/*     */ 
/*     */         
/* 320 */         a(paramOutputStream, 2L, paramArrayOfint[0]);
/* 321 */         a(paramOutputStream, 0L, paramArrayOfint[1]);
/* 322 */         a(paramOutputStream, 0L, paramArrayOfint[2]);
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 327 */       throw new RuntimeException("unexpected reference type");
/*     */     } 
/*     */   }
/*     */   
/*     */   static class c {}
/*     */   
/*     */   static class b {
/*     */     int a;
/*     */     long b;
/*     */   }
/*     */   
/*     */   static class a {
/*     */     int a;
/*     */     long b;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\f\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */