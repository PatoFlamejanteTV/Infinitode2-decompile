/*      */ package org.a.b.f;
/*      */ 
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.DataOutputStream;
/*      */ import java.io.EOFException;
/*      */ import java.io.InputStream;
/*      */ import java.io.OutputStream;
/*      */ import java.nio.charset.Charset;
/*      */ import java.util.Calendar;
/*      */ import java.util.GregorianCalendar;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.SortedMap;
/*      */ import java.util.SortedSet;
/*      */ import java.util.TimeZone;
/*      */ import java.util.TreeMap;
/*      */ import java.util.TreeSet;
/*      */ import org.a.a.a.a;
/*      */ import org.a.a.a.c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class am
/*      */ {
/*   53 */   private static final a a = c.a(am.class);
/*      */   
/*   55 */   private static final byte[] b = new byte[] { 0, 0, 0 };
/*      */ 
/*      */ 
/*      */   
/*      */   private final ap c;
/*      */ 
/*      */ 
/*      */   
/*      */   private final c d;
/*      */ 
/*      */ 
/*      */   
/*      */   private final SortedMap<Integer, Integer> e;
/*      */ 
/*      */   
/*      */   private final List<String> f;
/*      */ 
/*      */   
/*      */   private final SortedSet<Integer> g;
/*      */ 
/*      */   
/*      */   private String h;
/*      */ 
/*      */   
/*      */   private boolean i;
/*      */ 
/*      */ 
/*      */   
/*      */   public am(ap paramap, List<String> paramList) {
/*   84 */     this.c = paramap;
/*   85 */     this.f = paramList;
/*      */     
/*   87 */     this.e = new TreeMap<Integer, Integer>();
/*   88 */     this.g = new TreeSet<Integer>();
/*      */ 
/*      */     
/*   91 */     this.d = paramap.z();
/*      */ 
/*      */     
/*   94 */     this.g.add(Integer.valueOf(0));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(String paramString) {
/*  102 */     this.h = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(int paramInt) {
/*      */     int i;
/*  113 */     if ((i = this.d.a(paramInt)) != 0) {
/*      */       
/*  115 */       this.e.put(Integer.valueOf(paramInt), Integer.valueOf(i));
/*  116 */       this.g.add(Integer.valueOf(i));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(Set<Integer> paramSet) {
/*  127 */     for (Iterator<Integer> iterator = paramSet.iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/*      */       
/*  129 */       a(i); }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Map<Integer, Integer> a() {
/*  138 */     g();
/*      */     
/*  140 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*  141 */     byte b = 0;
/*  142 */     for (Iterator<Integer> iterator = this.g.iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/*      */       
/*  144 */       hashMap.put(Integer.valueOf(b), Integer.valueOf(i));
/*  145 */       b++; }
/*      */     
/*  147 */     return (Map)hashMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private long a(DataOutputStream paramDataOutputStream, int paramInt) {
/*  158 */     paramDataOutputStream.writeInt(65536);
/*  159 */     paramDataOutputStream.writeShort(paramInt);
/*      */ 
/*      */     
/*  162 */     int i, j = (i = Integer.highestOneBit(paramInt)) << 4;
/*  163 */     paramDataOutputStream.writeShort(j);
/*      */     
/*  165 */     i = b(i);
/*      */     
/*  167 */     paramDataOutputStream.writeShort(i);
/*      */ 
/*      */     
/*  170 */     int k = paramInt * 16 - j;
/*  171 */     paramDataOutputStream.writeShort(k);
/*      */     
/*  173 */     return 65536L + a(paramInt, j) + a(i, k);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private long a(DataOutputStream paramDataOutputStream, String paramString, long paramLong, byte[] paramArrayOfbyte) {
/*  179 */     long l = 0L; byte b; int i;
/*  180 */     for (b = 0, i = paramArrayOfbyte.length; b < i; b++)
/*      */     {
/*  182 */       l += (paramArrayOfbyte[b] & 0xFFL) << 24 - (b % 4 << 3);
/*      */     }
/*  184 */     l &= 0xFFFFFFFFL;
/*      */     
/*  186 */     byte[] arrayOfByte = paramString.getBytes("US-ASCII");
/*      */     
/*  188 */     paramDataOutputStream.write(arrayOfByte, 0, 4);
/*  189 */     paramDataOutputStream.writeInt((int)l);
/*  190 */     paramDataOutputStream.writeInt((int)paramLong);
/*  191 */     paramDataOutputStream.writeInt(paramArrayOfbyte.length);
/*      */ 
/*      */     
/*  194 */     return a(arrayOfByte) + l + l + paramLong + paramArrayOfbyte.length;
/*      */   }
/*      */ 
/*      */   
/*      */   private static void a(OutputStream paramOutputStream, byte[] paramArrayOfbyte) {
/*  199 */     int i = paramArrayOfbyte.length;
/*  200 */     paramOutputStream.write(paramArrayOfbyte);
/*  201 */     if (i % 4 != 0)
/*      */     {
/*  203 */       paramOutputStream.write(b, 0, 4 - i % 4);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private byte[] b() {
/*  209 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  210 */     DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
/*      */     
/*  212 */     q q = this.c.n();
/*  213 */     a(dataOutputStream, q.l());
/*  214 */     a(dataOutputStream, q.d());
/*  215 */     a(dataOutputStream, 0L);
/*  216 */     a(dataOutputStream, q.i());
/*  217 */     b(dataOutputStream, q.b());
/*  218 */     b(dataOutputStream, q.k());
/*  219 */     a(dataOutputStream, q.a());
/*  220 */     a(dataOutputStream, q.j());
/*  221 */     a(dataOutputStream, q.n());
/*  222 */     a(dataOutputStream, q.p());
/*  223 */     a(dataOutputStream, q.m());
/*  224 */     a(dataOutputStream, q.o());
/*  225 */     b(dataOutputStream, q.h());
/*  226 */     b(dataOutputStream, q.g());
/*  227 */     a(dataOutputStream, q.c());
/*      */     
/*  229 */     a(dataOutputStream, (short)1);
/*  230 */     a(dataOutputStream, q.e());
/*  231 */     dataOutputStream.flush();
/*      */     
/*  233 */     return byteArrayOutputStream.toByteArray();
/*      */   }
/*      */ 
/*      */   
/*      */   private byte[] c() {
/*  238 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  239 */     DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
/*      */     
/*  241 */     r r = this.c.o();
/*  242 */     a(dataOutputStream, r.p());
/*  243 */     a(dataOutputStream, r.b());
/*  244 */     a(dataOutputStream, r.e());
/*  245 */     a(dataOutputStream, r.f());
/*  246 */     b(dataOutputStream, r.a());
/*  247 */     a(dataOutputStream, r.h());
/*  248 */     a(dataOutputStream, r.i());
/*  249 */     a(dataOutputStream, r.q());
/*  250 */     a(dataOutputStream, r.c());
/*  251 */     a(dataOutputStream, r.d());
/*  252 */     a(dataOutputStream, r.k());
/*  253 */     a(dataOutputStream, r.l());
/*  254 */     a(dataOutputStream, r.m());
/*  255 */     a(dataOutputStream, r.n());
/*  256 */     a(dataOutputStream, r.o());
/*  257 */     a(dataOutputStream, r.g());
/*      */ 
/*      */ 
/*      */     
/*  261 */     int i = this.g.subSet(Integer.valueOf(0), Integer.valueOf(r.j())).size();
/*  262 */     if (((Integer)this.g.last()).intValue() >= r.j() && !this.g.contains(Integer.valueOf(r.j() - 1)))
/*      */     {
/*  264 */       i++;
/*      */     }
/*  266 */     b(dataOutputStream, i);
/*      */     
/*  268 */     dataOutputStream.flush();
/*  269 */     return byteArrayOutputStream.toByteArray();
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean a(y paramy) {
/*  274 */     if (paramy.f() == 3 && paramy
/*  275 */       .e() == 1 && paramy
/*  276 */       .c() == 1033 && paramy
/*  277 */       .d() >= 0 && paramy.d() < 7) return true; 
/*      */     return false;
/*      */   }
/*      */   
/*      */   private byte[] d() {
/*  282 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  283 */     DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
/*      */     
/*      */     z z;
/*  286 */     if ((z = this.c.j()) == null || (this.f != null && !this.f.contains("name")))
/*      */     {
/*  288 */       return null;
/*      */     }
/*      */     
/*  291 */     List<y> list = z.a();
/*  292 */     byte b1 = 0;
/*  293 */     for (Iterator<y> iterator1 = list.iterator(); iterator1.hasNext();) {
/*      */       
/*  295 */       if (a(y = iterator1.next()))
/*      */       {
/*  297 */         b1++;
/*      */       }
/*      */     } 
/*  300 */     b(dataOutputStream, 0);
/*  301 */     b(dataOutputStream, b1);
/*  302 */     b(dataOutputStream, 6 + b1 * 12);
/*      */     
/*  304 */     if (b1 == 0)
/*      */     {
/*  306 */       return null;
/*      */     }
/*      */     
/*  309 */     byte[][] arrayOfByte = new byte[b1][];
/*  310 */     byte b2 = 0;
/*  311 */     for (Iterator<y> iterator2 = list.iterator(); iterator2.hasNext();) {
/*      */       
/*  313 */       if (a(y = iterator2.next())) {
/*      */         
/*  315 */         int j = y.f();
/*  316 */         int k = y.e();
/*  317 */         String str2 = "ISO-8859-1";
/*      */         
/*  319 */         if (j == 3 && k == 1) {
/*      */ 
/*      */           
/*  322 */           str2 = "UTF-16BE";
/*      */         }
/*  324 */         else if (j == 2) {
/*      */           
/*  326 */           if (k == 0) {
/*      */             
/*  328 */             str2 = "US-ASCII";
/*      */           }
/*  330 */           else if (k == 1) {
/*      */ 
/*      */             
/*  333 */             str2 = "UTF16-BE";
/*      */           }
/*  335 */           else if (k == 2) {
/*      */             
/*  337 */             str2 = "ISO-8859-1";
/*      */           } 
/*      */         } 
/*  340 */         String str1 = y.g();
/*  341 */         if (y.d() == 6 && this.h != null)
/*      */         {
/*  343 */           str1 = this.h + str1;
/*      */         }
/*  345 */         arrayOfByte[b2] = str1.getBytes(str2);
/*  346 */         b2++;
/*      */       } 
/*      */     } 
/*      */     
/*  350 */     int i = 0;
/*  351 */     b2 = 0;
/*  352 */     for (Iterator<y> iterator3 = list.iterator(); iterator3.hasNext();) {
/*      */       
/*  354 */       if (a(y = iterator3.next())) {
/*      */         
/*  356 */         b(dataOutputStream, y.f());
/*  357 */         b(dataOutputStream, y.e());
/*  358 */         b(dataOutputStream, y.c());
/*  359 */         b(dataOutputStream, y.d());
/*  360 */         b(dataOutputStream, (arrayOfByte[b2]).length);
/*  361 */         b(dataOutputStream, i);
/*  362 */         i += (arrayOfByte[b2]).length;
/*  363 */         b2++;
/*      */       } 
/*      */     } 
/*      */     
/*  367 */     for (byte b3 = 0; b3 < b1; b3++)
/*      */     {
/*  369 */       dataOutputStream.write(arrayOfByte[b3]);
/*      */     }
/*      */     
/*  372 */     dataOutputStream.flush();
/*  373 */     return byteArrayOutputStream.toByteArray();
/*      */   }
/*      */ 
/*      */   
/*      */   private byte[] e() {
/*  378 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  379 */     DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
/*      */     
/*  381 */     w w = this.c.m();
/*  382 */     a(dataOutputStream, 1.0D);
/*  383 */     b(dataOutputStream, this.g.size());
/*  384 */     b(dataOutputStream, w.h());
/*  385 */     b(dataOutputStream, w.e());
/*  386 */     b(dataOutputStream, w.d());
/*  387 */     b(dataOutputStream, w.c());
/*  388 */     b(dataOutputStream, w.m());
/*  389 */     b(dataOutputStream, w.l());
/*  390 */     b(dataOutputStream, w.k());
/*  391 */     b(dataOutputStream, w.f());
/*  392 */     b(dataOutputStream, w.g());
/*  393 */     b(dataOutputStream, w.j());
/*  394 */     b(dataOutputStream, w.i());
/*  395 */     b(dataOutputStream, w.b());
/*  396 */     b(dataOutputStream, w.a());
/*      */     
/*  398 */     dataOutputStream.flush();
/*  399 */     return byteArrayOutputStream.toByteArray();
/*      */   }
/*      */ 
/*      */   
/*      */   private byte[] f() {
/*      */     aa aa;
/*  405 */     if ((aa = this.c.l()) == null || this.e.isEmpty() || (this.f != null && !this.f.contains("OS/2")))
/*      */     {
/*  407 */       return null;
/*      */     }
/*      */     
/*  410 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*      */     
/*      */     DataOutputStream dataOutputStream;
/*  413 */     b(dataOutputStream = new DataOutputStream(byteArrayOutputStream), aa.v());
/*  414 */     a(dataOutputStream, aa.b());
/*  415 */     b(dataOutputStream, aa.w());
/*  416 */     b(dataOutputStream, aa.x());
/*      */     
/*  418 */     a(dataOutputStream, aa.g());
/*      */     
/*  420 */     a(dataOutputStream, aa.l());
/*  421 */     a(dataOutputStream, aa.n());
/*  422 */     a(dataOutputStream, aa.k());
/*  423 */     a(dataOutputStream, aa.m());
/*      */     
/*  425 */     a(dataOutputStream, aa.p());
/*  426 */     a(dataOutputStream, aa.r());
/*  427 */     a(dataOutputStream, aa.o());
/*  428 */     a(dataOutputStream, aa.q());
/*      */     
/*  430 */     a(dataOutputStream, aa.j());
/*  431 */     a(dataOutputStream, aa.i());
/*  432 */     a(dataOutputStream, (short)aa.e());
/*  433 */     dataOutputStream.write(aa.h());
/*      */     
/*  435 */     a(dataOutputStream, 0L);
/*  436 */     a(dataOutputStream, 0L);
/*  437 */     a(dataOutputStream, 0L);
/*  438 */     a(dataOutputStream, 0L);
/*      */     
/*  440 */     dataOutputStream.write(aa.a().getBytes("US-ASCII"));
/*      */     
/*  442 */     b(dataOutputStream, aa.f());
/*  443 */     b(dataOutputStream, ((Integer)this.e.firstKey()).intValue());
/*  444 */     b(dataOutputStream, ((Integer)this.e.lastKey()).intValue());
/*  445 */     b(dataOutputStream, aa.t());
/*  446 */     b(dataOutputStream, aa.u());
/*  447 */     b(dataOutputStream, aa.s());
/*  448 */     b(dataOutputStream, aa.y());
/*  449 */     b(dataOutputStream, aa.z());
/*      */     
/*  451 */     dataOutputStream.flush();
/*  452 */     return byteArrayOutputStream.toByteArray();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private byte[] a(long[] paramArrayOflong) {
/*  458 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  459 */     DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream); int i;
/*      */     byte b;
/*  461 */     for (i = (paramArrayOflong = paramArrayOflong).length, b = 0; b < i; ) { long l = paramArrayOflong[b];
/*      */       
/*  463 */       a(dataOutputStream, l);
/*      */       b++; }
/*      */     
/*  466 */     dataOutputStream.flush();
/*  467 */     return byteArrayOutputStream.toByteArray();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void g() {
/*  475 */     if (this.i) {
/*      */       return;
/*      */     }
/*      */     
/*  479 */     this.i = true;
/*      */     
/*      */     do {
/*      */       boolean bool;
/*      */       
/*  484 */       null = this.c.e();
/*  485 */       long[] arrayOfLong = this.c.q().a();
/*  486 */       InputStream inputStream = this.c.u();
/*  487 */       TreeSet<Integer> treeSet = null;
/*      */       
/*      */       try {
/*  490 */         inputStream.skip(null.D());
/*  491 */         long l = 0L;
/*  492 */         for (Integer integer : this.g)
/*      */         {
/*  494 */           long l2 = arrayOfLong[integer.intValue()];
/*  495 */           long l3 = arrayOfLong[integer.intValue() + 1] - l2;
/*  496 */           inputStream.skip(l2 - l);
/*  497 */           byte[] arrayOfByte = new byte[(int)l3];
/*  498 */           inputStream.read(arrayOfByte);
/*      */           
/*  500 */           if (arrayOfByte.length >= 2 && arrayOfByte[0] == -1 && arrayOfByte[1] == -1) {
/*      */             int i;
/*  502 */             byte b = 10;
/*      */ 
/*      */             
/*      */             do {
/*  506 */               i = (arrayOfByte[b] & 0xFF) << 8 | arrayOfByte[b + 1] & 0xFF;
/*  507 */               b += 2;
/*  508 */               int j = (arrayOfByte[b] & 0xFF) << 8 | arrayOfByte[b + 1] & 0xFF;
/*  509 */               if (!this.g.contains(Integer.valueOf(j))) {
/*      */                 
/*  511 */                 if (treeSet == null)
/*      */                 {
/*  513 */                   treeSet = new TreeSet();
/*      */                 }
/*  515 */                 treeSet.add(Integer.valueOf(j));
/*      */               } 
/*  517 */               b += 2;
/*      */               
/*  519 */               if ((i & 0x1) != 0) {
/*      */                 
/*  521 */                 b += 4;
/*      */               }
/*      */               else {
/*      */                 
/*  525 */                 b += 2;
/*      */               } 
/*      */               
/*  528 */               if ((i & 0x80) != 0)
/*      */               {
/*  530 */                 b += 8;
/*      */               
/*      */               }
/*  533 */               else if ((i & 0x40) != 0)
/*      */               {
/*  535 */                 b += 4;
/*      */               
/*      */               }
/*  538 */               else if ((i & 0x8) != 0)
/*      */               {
/*  540 */                 b += 2;
/*      */               }
/*      */             
/*  543 */             } while ((i & 0x20) != 0);
/*      */           } 
/*      */           
/*  546 */           long l1 = arrayOfLong[integer.intValue() + 1];
/*      */         }
/*      */       
/*      */       } finally {
/*      */         
/*  551 */         inputStream.close();
/*      */       } 
/*  553 */       if (treeSet != null)
/*      */       {
/*  555 */         this.g.addAll(treeSet);
/*      */       
/*      */       }
/*      */     }
/*  559 */     while (bool = (treeSet != null) ? true : false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private byte[] b(long[] paramArrayOflong) {
/*  565 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*      */     
/*  567 */     p p = this.c.e();
/*  568 */     long[] arrayOfLong = this.c.q().a();
/*  569 */     InputStream inputStream = this.c.u();
/*      */     
/*      */     try {
/*  572 */       inputStream.skip(p.D());
/*      */       
/*  574 */       long l1 = 0L;
/*  575 */       long l2 = 0L;
/*  576 */       byte b = 0;
/*      */ 
/*      */       
/*  579 */       for (Integer integer : this.g) {
/*      */         
/*  581 */         long l4 = arrayOfLong[integer.intValue()];
/*  582 */         long l5 = arrayOfLong[integer.intValue() + 1] - l4;
/*      */         
/*  584 */         paramArrayOflong[b++] = l2;
/*  585 */         inputStream.skip(l4 - l1);
/*      */         
/*  587 */         byte[] arrayOfByte = new byte[(int)l5];
/*  588 */         inputStream.read(arrayOfByte);
/*      */ 
/*      */         
/*  591 */         if (arrayOfByte.length >= 2 && arrayOfByte[0] == -1 && arrayOfByte[1] == -1) {
/*      */ 
/*      */           
/*  594 */           int j, i = 10;
/*      */ 
/*      */ 
/*      */           
/*      */           do {
/*  599 */             j = (arrayOfByte[i] & 0xFF) << 8 | arrayOfByte[i + 1] & 0xFF;
/*  600 */             i += 2;
/*      */ 
/*      */             
/*  603 */             int k = (arrayOfByte[i] & 0xFF) << 8 | arrayOfByte[i + 1] & 0xFF;
/*  604 */             if (!this.g.contains(Integer.valueOf(k)))
/*      */             {
/*  606 */               this.g.add(Integer.valueOf(k));
/*      */             }
/*      */             
/*  609 */             k = a(Integer.valueOf(k));
/*  610 */             arrayOfByte[i] = (byte)(k >>> 8);
/*  611 */             arrayOfByte[i + 1] = (byte)k;
/*  612 */             i += 2;
/*      */ 
/*      */             
/*  615 */             if ((j & 0x1) != 0) {
/*      */               
/*  617 */               i += 4;
/*      */             }
/*      */             else {
/*      */               
/*  621 */               i += 2;
/*      */             } 
/*      */             
/*  624 */             if ((j & 0x80) != 0)
/*      */             {
/*  626 */               i += 8;
/*      */             
/*      */             }
/*  629 */             else if ((j & 0x40) != 0)
/*      */             {
/*  631 */               i += 4;
/*      */             
/*      */             }
/*  634 */             else if ((j & 0x8) != 0)
/*      */             {
/*  636 */               i += 2;
/*      */             }
/*      */           
/*  639 */           } while ((j & 0x20) != 0);
/*      */ 
/*      */           
/*  642 */           if ((j & 0x100) == 256) {
/*      */ 
/*      */             
/*  645 */             int k = (arrayOfByte[i] & 0xFF) << 8 | arrayOfByte[i + 1] & 0xFF;
/*  646 */             i += 2;
/*      */ 
/*      */             
/*  649 */             i += k;
/*      */           } 
/*      */ 
/*      */           
/*  653 */           byteArrayOutputStream.write(arrayOfByte, 0, i);
/*      */ 
/*      */           
/*  656 */           l2 += i;
/*      */         }
/*  658 */         else if (arrayOfByte.length > 0) {
/*      */ 
/*      */           
/*  661 */           byteArrayOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
/*      */ 
/*      */           
/*  664 */           l2 += arrayOfByte.length;
/*      */         } 
/*      */ 
/*      */         
/*  668 */         if (l2 % 4L != 0L) {
/*      */           
/*  670 */           int i = 4 - (int)(l2 % 4L);
/*  671 */           byteArrayOutputStream.write(b, 0, i);
/*  672 */           l2 += i;
/*      */         } 
/*      */         
/*  675 */         long l3 = l4 + l5;
/*      */       } 
/*  677 */       paramArrayOflong[b] = l2;
/*      */     }
/*      */     finally {
/*      */       
/*  681 */       inputStream.close();
/*      */     } 
/*      */     
/*  684 */     return byteArrayOutputStream.toByteArray();
/*      */   }
/*      */ 
/*      */   
/*      */   private int a(Integer paramInteger) {
/*  689 */     return this.g.headSet(paramInteger).size();
/*      */   }
/*      */ 
/*      */   
/*      */   private byte[] h() {
/*  694 */     if (this.c.r() == null || this.e.isEmpty() || (this.f != null && !this.f.contains("cmap")))
/*      */     {
/*  696 */       return null;
/*      */     }
/*      */     
/*  699 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*      */     
/*      */     DataOutputStream dataOutputStream;
/*      */     
/*  703 */     b(dataOutputStream = new DataOutputStream(byteArrayOutputStream), 0);
/*  704 */     b(dataOutputStream, 1);
/*      */ 
/*      */     
/*  707 */     b(dataOutputStream, 3);
/*  708 */     b(dataOutputStream, 1);
/*  709 */     a(dataOutputStream, 12L);
/*      */ 
/*      */     
/*      */     Iterator<Map.Entry> iterator;
/*      */     
/*  714 */     Map.Entry entry1 = (iterator = this.e.entrySet().iterator()).next(), entry2 = entry1;
/*  715 */     int i = a((Integer)entry1.getValue());
/*      */ 
/*      */     
/*  718 */     int[] arrayOfInt1 = new int[this.e.size() + 1];
/*  719 */     int[] arrayOfInt2 = new int[this.e.size() + 1];
/*  720 */     int[] arrayOfInt3 = new int[this.e.size() + 1];
/*  721 */     byte b1 = 0;
/*  722 */     while (iterator.hasNext()) {
/*      */       
/*  724 */       Map.Entry entry = iterator.next();
/*  725 */       int k = a((Integer)entry.getValue());
/*      */ 
/*      */       
/*  728 */       if (((Integer)entry.getKey()).intValue() > 65535)
/*      */       {
/*  730 */         throw new UnsupportedOperationException("non-BMP Unicode character");
/*      */       }
/*      */       
/*  733 */       if (((Integer)entry.getKey()).intValue() != ((Integer)entry2.getKey()).intValue() + 1 || k - i != ((Integer)entry
/*  734 */         .getKey()).intValue() - ((Integer)entry1.getKey()).intValue()) {
/*      */         
/*  736 */         if (i != 0) {
/*      */ 
/*      */ 
/*      */           
/*  740 */           arrayOfInt1[b1] = ((Integer)entry1.getKey()).intValue();
/*  741 */           arrayOfInt2[b1] = ((Integer)entry2.getKey()).intValue();
/*  742 */           arrayOfInt3[b1] = i - ((Integer)entry1.getKey()).intValue();
/*  743 */           b1++;
/*      */         }
/*  745 */         else if (!((Integer)entry1.getKey()).equals(entry2.getKey())) {
/*      */ 
/*      */           
/*  748 */           arrayOfInt1[b1] = ((Integer)entry1.getKey()).intValue() + 1;
/*  749 */           arrayOfInt2[b1] = ((Integer)entry2.getKey()).intValue();
/*  750 */           arrayOfInt3[b1] = i - ((Integer)entry1.getKey()).intValue();
/*  751 */           b1++;
/*      */         } 
/*  753 */         i = k;
/*  754 */         entry1 = entry;
/*      */       } 
/*  756 */       entry2 = entry;
/*      */     } 
/*      */ 
/*      */     
/*  760 */     arrayOfInt1[b1] = ((Integer)entry1.getKey()).intValue();
/*  761 */     arrayOfInt2[b1] = ((Integer)entry2.getKey()).intValue();
/*  762 */     arrayOfInt3[b1] = i - ((Integer)entry1.getKey()).intValue();
/*  763 */     b1++;
/*      */ 
/*      */     
/*  766 */     arrayOfInt1[b1] = 65535;
/*  767 */     arrayOfInt2[b1] = 65535;
/*  768 */     arrayOfInt3[b1] = 1;
/*  769 */     b1++;
/*      */ 
/*      */     
/*  772 */     int j = 2 * (int)Math.pow(2.0D, b(b1));
/*  773 */     b(dataOutputStream, 4);
/*  774 */     b(dataOutputStream, 16 + (b1 << 2 << 1));
/*  775 */     b(dataOutputStream, 0);
/*  776 */     b(dataOutputStream, b1 << 1);
/*  777 */     b(dataOutputStream, j);
/*  778 */     b(dataOutputStream, b(j / 2));
/*  779 */     b(dataOutputStream, 2 * b1 - j);
/*      */     
/*      */     byte b2;
/*  782 */     for (b2 = 0; b2 < b1; b2++)
/*      */     {
/*  784 */       b(dataOutputStream, arrayOfInt2[b2]);
/*      */     }
/*      */ 
/*      */     
/*  788 */     b(dataOutputStream, 0);
/*      */ 
/*      */     
/*  791 */     for (b2 = 0; b2 < b1; b2++)
/*      */     {
/*  793 */       b(dataOutputStream, arrayOfInt1[b2]);
/*      */     }
/*      */ 
/*      */     
/*  797 */     for (b2 = 0; b2 < b1; b2++)
/*      */     {
/*  799 */       b(dataOutputStream, arrayOfInt3[b2]);
/*      */     }
/*      */     
/*  802 */     for (b2 = 0; b2 < b1; b2++)
/*      */     {
/*  804 */       b(dataOutputStream, 0);
/*      */     }
/*      */     
/*  807 */     return byteArrayOutputStream.toByteArray();
/*      */   }
/*      */ 
/*      */   
/*      */   private byte[] i() {
/*      */     ag ag;
/*  813 */     if ((ag = this.c.k()) == null || (this.f != null && !this.f.contains("post")))
/*      */     {
/*  815 */       return null;
/*      */     }
/*      */     
/*  818 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*      */     
/*      */     DataOutputStream dataOutputStream;
/*  821 */     a(dataOutputStream = new DataOutputStream(byteArrayOutputStream), 2.0D);
/*  822 */     a(dataOutputStream, ag.b());
/*  823 */     a(dataOutputStream, ag.g());
/*  824 */     a(dataOutputStream, ag.h());
/*  825 */     a(dataOutputStream, ag.a());
/*  826 */     a(dataOutputStream, ag.f());
/*  827 */     a(dataOutputStream, ag.d());
/*  828 */     a(dataOutputStream, ag.e());
/*  829 */     a(dataOutputStream, ag.c());
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  834 */     b(dataOutputStream, this.g.size());
/*      */ 
/*      */     
/*  837 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(); Iterator<Integer> iterator;
/*  838 */     for (iterator = this.g.iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/*      */       
/*  840 */       String str = ag.a(i);
/*      */       Integer integer;
/*  842 */       if ((integer = at.b.get(str)) != null) {
/*      */ 
/*      */         
/*  845 */         b(dataOutputStream, integer.intValue());
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  851 */       if ((integer = (Integer)linkedHashMap.get(str)) == null) {
/*      */         
/*  853 */         integer = Integer.valueOf(linkedHashMap.size());
/*  854 */         linkedHashMap.put(str, integer);
/*      */       } 
/*  856 */       b(dataOutputStream, 258 + integer.intValue()); }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  861 */     for (iterator = linkedHashMap.keySet().iterator(); iterator.hasNext(); ) {
/*      */       String str;
/*  863 */       byte[] arrayOfByte = (str = (String)iterator.next()).getBytes(Charset.forName("US-ASCII"));
/*  864 */       c(dataOutputStream, arrayOfByte.length);
/*  865 */       dataOutputStream.write(arrayOfByte);
/*      */     } 
/*      */     
/*  868 */     dataOutputStream.flush();
/*  869 */     return byteArrayOutputStream.toByteArray();
/*      */   }
/*      */ 
/*      */   
/*      */   private byte[] j() {
/*  874 */     null = new ByteArrayOutputStream();
/*      */     
/*  876 */     r r = this.c.o();
/*  877 */     s s = this.c.p();
/*  878 */     InputStream inputStream = this.c.u();
/*      */ 
/*      */     
/*  881 */     int i = r.j() - 1;
/*      */     
/*  883 */     boolean bool = false;
/*  884 */     if (((Integer)this.g.last()).intValue() > i && !this.g.contains(Integer.valueOf(i)))
/*      */     {
/*  886 */       bool = true;
/*      */     }
/*      */ 
/*      */     
/*      */     try {
/*  891 */       inputStream.skip(s.D());
/*  892 */       long l = 0L;
/*  893 */       for (Iterator<Integer> iterator = this.g.iterator(); iterator.hasNext(); ) {
/*      */         Integer integer;
/*      */ 
/*      */         
/*  897 */         if ((integer = iterator.next()).intValue() <= i) {
/*      */ 
/*      */           
/*  900 */           long l2 = (integer.intValue() << 2);
/*  901 */           l = a(inputStream, null, l2, l, 4);
/*      */           
/*      */           continue;
/*      */         } 
/*  905 */         if (bool) {
/*      */ 
/*      */ 
/*      */           
/*  909 */           bool = false;
/*  910 */           long l2 = (i << 2);
/*  911 */           l = a(inputStream, null, l2, l, 2);
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  917 */         long l1 = ((r.j() << 2) + (integer.intValue() - r.j() << 1));
/*  918 */         l = a(inputStream, null, l1, l, 2);
/*      */       } 
/*      */ 
/*      */       
/*  922 */       return null.toByteArray();
/*      */     }
/*      */     finally {
/*      */       
/*  926 */       inputStream.close();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static long a(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong1, long paramLong2, int paramInt) {
/*      */     long l;
/*  935 */     if ((l = paramLong1 - paramLong2) != paramInputStream.skip(l))
/*      */     {
/*  937 */       throw new EOFException("Unexpected EOF exception parsing glyphId of hmtx table.");
/*      */     }
/*  939 */     byte[] arrayOfByte = new byte[paramInt];
/*  940 */     if (paramInt != paramInputStream.read(arrayOfByte, 0, paramInt))
/*      */     {
/*  942 */       throw new EOFException("Unexpected EOF exception parsing glyphId of hmtx table.");
/*      */     }
/*  944 */     paramOutputStream.write(arrayOfByte, 0, paramInt);
/*  945 */     return paramLong1 + paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(OutputStream paramOutputStream) {
/*  957 */     if (!this.g.isEmpty()) this.e.isEmpty();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  962 */     g();
/*      */     
/*  964 */     paramOutputStream = new DataOutputStream(paramOutputStream);
/*      */     
/*      */     try {
/*  967 */       long[] arrayOfLong = new long[this.g.size() + 1];
/*      */ 
/*      */       
/*  970 */       byte[] arrayOfByte2 = b();
/*  971 */       arrayOfByte3 = c();
/*  972 */       byte[] arrayOfByte4 = e();
/*  973 */       byte[] arrayOfByte5 = d();
/*  974 */       byte[] arrayOfByte6 = f();
/*  975 */       byte[] arrayOfByte7 = b(arrayOfLong);
/*  976 */       byte[] arrayOfByte1 = a(arrayOfLong);
/*  977 */       byte[] arrayOfByte8 = h();
/*  978 */       byte[] arrayOfByte9 = j();
/*  979 */       byte[] arrayOfByte10 = i();
/*      */ 
/*      */       
/*  982 */       TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
/*  983 */       if (arrayOfByte6 != null)
/*      */       {
/*  985 */         treeMap.put("OS/2", arrayOfByte6);
/*      */       }
/*  987 */       if (arrayOfByte8 != null)
/*      */       {
/*  989 */         treeMap.put("cmap", arrayOfByte8);
/*      */       }
/*  991 */       treeMap.put("glyf", arrayOfByte7);
/*  992 */       treeMap.put("head", arrayOfByte2);
/*  993 */       treeMap.put("hhea", arrayOfByte3);
/*  994 */       treeMap.put("hmtx", arrayOfByte9);
/*  995 */       treeMap.put("loca", arrayOfByte1);
/*  996 */       treeMap.put("maxp", arrayOfByte4);
/*  997 */       if (arrayOfByte5 != null)
/*      */       {
/*  999 */         treeMap.put("name", arrayOfByte5);
/*      */       }
/* 1001 */       if (arrayOfByte10 != null)
/*      */       {
/* 1003 */         treeMap.put("post", arrayOfByte10);
/*      */       }
/*      */ 
/*      */       
/* 1007 */       for (Iterator<Map.Entry> iterator = this.c.i().entrySet().iterator(); iterator.hasNext(); ) {
/*      */         Map.Entry<String, ?> entry;
/* 1009 */         String str = (entry = iterator.next()).getKey();
/* 1010 */         an an = (an)entry.getValue();
/*      */         
/* 1012 */         if (!treeMap.containsKey(str) && (this.f == null || this.f.contains(str)))
/*      */         {
/* 1014 */           treeMap.put(str, this.c.b(an));
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/* 1019 */       long l1 = a((DataOutputStream)paramOutputStream, treeMap.size());
/* 1020 */       long l2 = 12L + 16L * treeMap.size();
/* 1021 */       for (Map.Entry<Object, Object> entry : treeMap.entrySet()) {
/*      */         
/* 1023 */         l1 += a((DataOutputStream)paramOutputStream, (String)entry.getKey(), l2, (byte[])entry.getValue());
/* 1024 */         l2 += ((((byte[])entry.getValue()).length + 3) / 4 << 2);
/*      */       } 
/* 1026 */       l1 = 2981146554L - (l1 & 0xFFFFFFFFL);
/*      */ 
/*      */       
/* 1029 */       arrayOfByte2[8] = (byte)(int)(l1 >>> 24L);
/* 1030 */       arrayOfByte2[9] = (byte)(int)(l1 >>> 16L);
/* 1031 */       arrayOfByte2[10] = (byte)(int)(l1 >>> 8L);
/* 1032 */       arrayOfByte2[11] = (byte)(int)l1;
/* 1033 */       for (byte[] arrayOfByte3 : treeMap.values())
/*      */       {
/* 1035 */         a(paramOutputStream, arrayOfByte3);
/*      */       }
/*      */       
/*      */       return;
/*      */     } finally {
/* 1040 */       paramOutputStream.close();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static void a(DataOutputStream paramDataOutputStream, double paramDouble) {
/* 1046 */     double d1 = Math.floor(paramDouble);
/* 1047 */     double d2 = (paramDouble - d1) * 65536.0D;
/* 1048 */     paramDataOutputStream.writeShort((int)d1);
/* 1049 */     paramDataOutputStream.writeShort((int)d2);
/*      */   }
/*      */ 
/*      */   
/*      */   private static void a(DataOutputStream paramDataOutputStream, long paramLong) {
/* 1054 */     paramDataOutputStream.writeInt((int)paramLong);
/*      */   }
/*      */ 
/*      */   
/*      */   private static void b(DataOutputStream paramDataOutputStream, int paramInt) {
/* 1059 */     paramDataOutputStream.writeShort(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   private static void a(DataOutputStream paramDataOutputStream, short paramShort) {
/* 1064 */     paramDataOutputStream.writeShort(paramShort);
/*      */   }
/*      */ 
/*      */   
/*      */   private static void c(DataOutputStream paramDataOutputStream, int paramInt) {
/* 1069 */     paramDataOutputStream.writeByte(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static void a(DataOutputStream paramDataOutputStream, Calendar paramCalendar) {
/*      */     Calendar calendar;
/* 1076 */     (calendar = GregorianCalendar.getInstance(TimeZone.getTimeZone("UTC"))).set(1904, 0, 1, 0, 0, 0);
/* 1077 */     calendar.set(14, 0);
/* 1078 */     long l1 = calendar.getTimeInMillis();
/* 1079 */     long l2 = (paramCalendar.getTimeInMillis() - l1) / 1000L;
/* 1080 */     paramDataOutputStream.writeLong(l2);
/*      */   }
/*      */ 
/*      */   
/*      */   private static long a(int paramInt1, int paramInt2) {
/* 1085 */     return (paramInt1 & 0xFFFFL) << 16L | paramInt2 & 0xFFFFL;
/*      */   }
/*      */ 
/*      */   
/*      */   private static long a(byte[] paramArrayOfbyte) {
/* 1090 */     return (paramArrayOfbyte[0] & 0xFFL) << 24L | (paramArrayOfbyte[1] & 0xFFL) << 16L | (paramArrayOfbyte[2] & 0xFFL) << 8L | paramArrayOfbyte[3] & 0xFFL;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int b(int paramInt) {
/* 1098 */     return (int)Math.round(Math.log(paramInt) / Math.log(2.0D));
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */