/*     */ package org.a.c.h.e;
/*     */ 
/*     */ import com.a.a.a.am;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.net.URI;
/*     */ import java.security.AccessControlException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import org.a.a.a.c;
/*     */ import org.a.b.b.i;
/*     */ import org.a.b.f.ab;
/*     */ import org.a.b.f.ad;
/*     */ import org.a.b.f.al;
/*     */ import org.a.b.f.an;
/*     */ import org.a.b.f.ao;
/*     */ import org.a.b.f.ap;
/*     */ import org.a.b.f.z;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class d
/*     */   extends n
/*     */ {
/*  57 */   private static final org.a.a.a.a a = c.a(d.class);
/*     */   
/*  59 */   private final List<a> b = new ArrayList<a>();
/*     */   
/*     */   private final g c;
/*     */ 
/*     */   
/*     */   private static class a
/*     */     extends i
/*     */   {
/*     */     private final String a;
/*     */     
/*     */     private final h b;
/*     */     private final b c;
/*     */     private final int d;
/*     */     private final int e;
/*     */     private final int f;
/*     */     private final int g;
/*     */     private final int h;
/*     */     private final z i;
/*     */     private final File j;
/*     */     private transient d k;
/*     */     
/*     */     private a(File param1File, h param1h, String param1String, b param1b, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, byte[] param1ArrayOfbyte, d param1d) {
/*  81 */       this.j = param1File;
/*  82 */       this.b = param1h;
/*  83 */       this.a = param1String;
/*  84 */       this.c = param1b;
/*  85 */       this.d = param1Int1;
/*  86 */       this.e = param1Int2;
/*  87 */       this.f = param1Int3;
/*  88 */       this.g = param1Int4;
/*  89 */       this.h = param1Int5;
/*  90 */       this.i = (param1ArrayOfbyte != null) ? new z(param1ArrayOfbyte) : null;
/*  91 */       this.k = param1d;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final String a() {
/*  97 */       return this.a;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final h b() {
/* 103 */       return this.b;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final b c() {
/* 109 */       return this.c;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final org.a.b.b d() {
/*     */       org.a.b.g.d d1;
/*     */       ap ap;
/*     */       ad ad;
/*     */       org.a.b.b b1;
/* 122 */       if ((b1 = d.a(this.k).a(this)) != null)
/*     */       {
/* 124 */         return b1;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 129 */       switch (f.a[this.b.ordinal()]) {
/*     */         case 1:
/* 131 */           d1 = d.a(this.k, this.a, this.j); break;
/* 132 */         case 2: ap = d.b(this.k, this.a, this.j); break;
/* 133 */         case 3: ad = d.c(this.k, this.a, this.j); break;
/* 134 */         default: throw new RuntimeException("can't happen");
/*     */       } 
/* 136 */       if (ad != null)
/*     */       {
/* 138 */         d.a(this.k).a(this, (org.a.b.b)ad);
/*     */       }
/* 140 */       return (org.a.b.b)ad;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int e() {
/* 147 */       return this.e;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final int f() {
/* 153 */       return this.d;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final int g() {
/* 159 */       return this.f;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final int h() {
/* 165 */       return this.g;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final int i() {
/* 171 */       return this.h;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final z j() {
/* 177 */       return this.i;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 183 */       return super.toString() + " " + this.j;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class b
/*     */     extends a
/*     */   {
/*     */     private b(File param1File, h param1h, String param1String) {
/* 194 */       super(param1File, param1h, param1String, null, 0, 0, 0, 0, 0, null, null, (byte)0);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   d(g paramg) {
/* 203 */     this.c = paramg;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 212 */       ArrayList<File> arrayList = new ArrayList();
/*     */       List<?> list;
/*     */       org.a.b.h.a.b b;
/* 215 */       for (URI uRI : list = (b = new org.a.b.h.a.b()).a())
/*     */       {
/* 217 */         arrayList.add(new File(uRI));
/*     */       }
/*     */       
/* 220 */       if (a.b())
/*     */       {
/* 222 */         (new StringBuilder("Found ")).append(arrayList.size()).append(" fonts on the local system");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 227 */       if ((list = b(arrayList)) != null && !list.isEmpty()) {
/*     */         
/* 229 */         this.b.addAll(list);
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 234 */         a(arrayList);
/* 235 */         c();
/* 236 */         (new StringBuilder("Finished building on-disk font cache, found "))
/* 237 */           .append(this.b.size()).append(" fonts");
/*     */         return;
/*     */       } 
/* 240 */     } catch (AccessControlException accessControlException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(List<File> paramList) {
/* 248 */     for (File file : paramList) {
/*     */ 
/*     */       
/*     */       try {
/* 252 */         if (file.getPath().toLowerCase().endsWith(".ttf") || file
/* 253 */           .getPath().toLowerCase().endsWith(".otf")) {
/*     */           
/* 255 */           b(file); continue;
/*     */         } 
/* 257 */         if (file.getPath().toLowerCase().endsWith(".ttc") || file
/* 258 */           .getPath().toLowerCase().endsWith(".otc")) {
/*     */           
/* 260 */           a(file); continue;
/*     */         } 
/* 262 */         if (file.getPath().toLowerCase().endsWith(".pfb"))
/*     */         {
/* 264 */           c(file);
/*     */         }
/*     */       }
/* 267 */       catch (IOException iOException) {
/*     */         
/* 269 */         (new StringBuilder("Error parsing font ")).append(file.getPath());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static File b() {
/*     */     String str;
/* 277 */     if ((str = System.getProperty("pdfbox.fontcache")) == null || !(new File(str)).isDirectory() || !(new File(str)).canWrite())
/*     */     {
/*     */       
/* 280 */       if ((str = System.getProperty("user.home")) == null || !(new File(str)).isDirectory() || !(new File(str)).canWrite())
/*     */       {
/* 282 */         str = System.getProperty("java.io.tmpdir");
/*     */       }
/*     */     }
/* 285 */     return new File(str, ".pdfbox.cache");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void c() {
/* 293 */     BufferedWriter bufferedWriter = null;
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*     */       try {
/* 299 */         File file = b();
/* 300 */         bufferedWriter = new BufferedWriter(new FileWriter(file));
/*     */       }
/* 302 */       catch (SecurityException securityException) {
/*     */         return;
/*     */       } 
/*     */ 
/*     */       
/* 307 */       for (a a1 : this.b) {
/*     */         
/* 309 */         bufferedWriter.write(a.a(a1).trim());
/* 310 */         bufferedWriter.write("|");
/* 311 */         bufferedWriter.write(a.b(a1).toString());
/* 312 */         bufferedWriter.write("|");
/* 313 */         if (a.c(a1) != null)
/*     */         {
/* 315 */           bufferedWriter.write(a.c(a1).a() + '-' + 
/* 316 */               a.c(a1).b() + '-' + 
/* 317 */               a.c(a1).c());
/*     */         }
/* 319 */         bufferedWriter.write("|");
/* 320 */         if (a.d(a1) >= 0)
/*     */         {
/* 322 */           bufferedWriter.write(Integer.toHexString(a.d(a1)));
/*     */         }
/* 324 */         bufferedWriter.write("|");
/* 325 */         if (a.e(a1) >= 0)
/*     */         {
/* 327 */           bufferedWriter.write(Integer.toHexString(a.e(a1)));
/*     */         }
/* 329 */         bufferedWriter.write("|");
/* 330 */         bufferedWriter.write(Integer.toHexString(a.f(a1)));
/* 331 */         bufferedWriter.write("|");
/* 332 */         bufferedWriter.write(Integer.toHexString(a.g(a1)));
/* 333 */         bufferedWriter.write("|");
/* 334 */         if (a.h(a1) >= 0)
/*     */         {
/* 336 */           bufferedWriter.write(Integer.toHexString(a.h(a1)));
/*     */         }
/* 338 */         bufferedWriter.write("|");
/* 339 */         if (a.i(a1) != null) {
/*     */           
/* 341 */           byte[] arrayOfByte = a.i(a1).d();
/* 342 */           for (byte b = 0; b < 10; b++) {
/*     */             String str;
/*     */             
/* 345 */             if ((str = Integer.toHexString(arrayOfByte[b])).length() == 1)
/*     */             {
/* 347 */               bufferedWriter.write(48);
/*     */             }
/* 349 */             bufferedWriter.write(str);
/*     */           } 
/*     */         } 
/* 352 */         bufferedWriter.write("|");
/* 353 */         bufferedWriter.write(a.j(a1).getAbsolutePath());
/* 354 */         bufferedWriter.newLine();
/*     */       } 
/*     */       return;
/* 357 */     } catch (IOException iOException) {
/*     */ 
/*     */       
/*     */       return;
/*     */     
/*     */     }
/*     */     finally {
/*     */       
/* 365 */       am.a(bufferedWriter);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<a> b(List<File> paramList) {
/* 374 */     HashSet<String> hashSet = new HashSet();
/* 375 */     for (File file1 : paramList)
/*     */     {
/* 377 */       hashSet.add(file1.getAbsolutePath());
/*     */     }
/*     */     
/* 380 */     paramList = new ArrayList<File>();
/*     */ 
/*     */     
/* 383 */     File file = null;
/* 384 */     boolean bool = false;
/*     */ 
/*     */     
/*     */     try {
/* 388 */       bool = (file = b()).exists();
/*     */     }
/* 390 */     catch (SecurityException securityException) {}
/*     */ 
/*     */ 
/*     */     
/* 394 */     if (bool) {
/*     */       
/* 396 */       BufferedReader bufferedReader = null;
/*     */       
/*     */       try {
/* 399 */         bufferedReader = new BufferedReader(new FileReader(file));
/*     */         String str;
/* 401 */         while ((str = bufferedReader.readLine()) != null) {
/*     */           String[] arrayOfString;
/*     */           
/* 404 */           if ((arrayOfString = str.split("\\|", 10)).length < 10) {
/*     */             
/* 406 */             (new StringBuilder("Incorrect line '")).append(str).append("' in font disk cache is skipped");
/*     */ 
/*     */             
/*     */             continue;
/*     */           } 
/*     */           
/* 412 */           b b = null;
/* 413 */           int i = -1;
/* 414 */           int j = -1;
/*     */ 
/*     */           
/* 417 */           int i1 = -1;
/* 418 */           byte[] arrayOfByte = null;
/*     */ 
/*     */           
/* 421 */           str = arrayOfString[0];
/* 422 */           h h = h.valueOf(arrayOfString[1]);
/* 423 */           if (arrayOfString[2].length() > 0) {
/*     */             
/* 425 */             String[] arrayOfString1 = arrayOfString[2].split("-");
/* 426 */             b = new b(arrayOfString1[0], arrayOfString1[1], Integer.parseInt(arrayOfString1[2]));
/*     */           } 
/* 428 */           if (arrayOfString[3].length() > 0)
/*     */           {
/* 430 */             i = (int)Long.parseLong(arrayOfString[3], 16);
/*     */           }
/* 432 */           if (arrayOfString[4].length() > 0)
/*     */           {
/* 434 */             j = (int)Long.parseLong(arrayOfString[4], 16);
/*     */           }
/* 436 */           int k = (int)Long.parseLong(arrayOfString[5], 16);
/* 437 */           int m = (int)Long.parseLong(arrayOfString[6], 16);
/* 438 */           if (arrayOfString[7].length() > 0)
/*     */           {
/* 440 */             i1 = (int)Long.parseLong(arrayOfString[7], 16);
/*     */           }
/* 442 */           if (arrayOfString[8].length() > 0) {
/*     */             
/* 444 */             arrayOfByte = new byte[10];
/* 445 */             for (byte b1 = 0; b1 < 10; b1++) {
/*     */               String str1;
/*     */               
/* 448 */               int i2 = Integer.parseInt(str1 = arrayOfString[8].substring(b1 << 1, (b1 << 1) + 2), 16);
/* 449 */               arrayOfByte[b1] = (byte)i2;
/*     */             } 
/*     */           } 
/*     */           File file1;
/* 453 */           if ((file1 = new File(arrayOfString[9])).exists()) {
/*     */             
/* 455 */             a a1 = new a(file1, h, str, b, i, j, k, m, i1, arrayOfByte, this, (byte)0);
/*     */ 
/*     */             
/* 458 */             paramList.add(a1);
/*     */           }
/*     */           else {
/*     */             
/* 462 */             (new StringBuilder("Font file ")).append(file1.getAbsolutePath()).append(" not found, skipped");
/*     */           } 
/* 464 */           hashSet.remove(file1.getAbsolutePath());
/*     */         }
/*     */       
/* 467 */       } catch (IOException iOException) {
/*     */ 
/*     */         
/* 470 */         return null;
/*     */       }
/*     */       finally {
/*     */         
/* 474 */         am.a(bufferedReader);
/*     */       } 
/*     */     } 
/*     */     
/* 478 */     if (!hashSet.isEmpty())
/*     */     {
/*     */ 
/*     */       
/* 482 */       return null;
/*     */     }
/*     */     
/* 485 */     return (List)paramList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(File paramFile) {
/* 493 */     ao ao = null;
/*     */ 
/*     */     
/*     */     try {
/* 497 */       (ao = new ao(paramFile)).a(new e(this, paramFile));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/* 506 */     } catch (NullPointerException nullPointerException) {
/*     */       
/* 508 */       (new StringBuilder("Could not load font file: ")).append(paramFile);
/*     */     }
/* 510 */     catch (IOException iOException) {
/*     */       
/* 512 */       (new StringBuilder("Could not load font file: ")).append(paramFile);
/*     */     }
/*     */     finally {
/*     */       
/* 516 */       if (ao != null)
/*     */       {
/* 518 */         ao.close();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(File paramFile) {
/*     */     try {
/* 530 */       if (paramFile.getPath().endsWith(".otf")) {
/*     */         ab ab;
/*     */         
/* 533 */         ad ad = (ab = new ab(false, true)).a(paramFile);
/* 534 */         a((ap)ad, paramFile);
/*     */       } else {
/*     */         al al;
/*     */ 
/*     */         
/* 539 */         ap ap = (al = new al(false, true)).b(paramFile);
/* 540 */         a(ap, paramFile);
/*     */         return;
/*     */       } 
/* 543 */     } catch (NullPointerException nullPointerException) {
/*     */       
/* 545 */       (new StringBuilder("Could not load font file: ")).append(paramFile);
/*     */       return;
/* 547 */     } catch (IOException iOException) {
/*     */       
/* 549 */       (new StringBuilder("Could not load font file: ")).append(paramFile);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(ap paramap, File paramFile) {
/*     */     try {
/* 561 */       if (paramap.b() != null && paramap.b().contains("|")) {
/*     */         
/* 563 */         this.b.add(new b(paramFile, h.a, "*skippipeinname*", (byte)0));
/* 564 */         (new StringBuilder("Skipping font with '|' in name ")).append(paramap.b()).append(" in file ").append(paramFile);
/*     */       }
/* 566 */       else if (paramap.b() != null) {
/*     */         String str;
/*     */         
/* 569 */         if (paramap.n() == null) {
/*     */           
/* 571 */           this.b.add(new b(paramFile, h.a, paramap.b(), (byte)0));
/*     */           return;
/*     */         } 
/* 574 */         int i = paramap.n().h();
/*     */         
/* 576 */         int j = -1;
/* 577 */         int k = -1;
/* 578 */         int m = 0;
/* 579 */         int i1 = 0;
/* 580 */         byte[] arrayOfByte = null;
/*     */         
/* 582 */         if (paramap.l() != null) {
/*     */           
/* 584 */           j = paramap.l().e();
/* 585 */           k = paramap.l().w();
/* 586 */           m = (int)paramap.l().c();
/* 587 */           i1 = (int)paramap.l().d();
/* 588 */           arrayOfByte = paramap.l().h();
/*     */         } 
/*     */ 
/*     */         
/* 592 */         if (paramap instanceof ad && ((ad)paramap).f()) {
/*     */           
/* 594 */           str = "OTF";
/* 595 */           i i2 = ((ad)paramap).a().a();
/* 596 */           b b = null;
/* 597 */           if (i2 instanceof org.a.b.b.a) {
/*     */             org.a.b.b.a a1;
/*     */             
/* 600 */             String str1 = (a1 = (org.a.b.b.a)i2).a();
/* 601 */             String str2 = a1.e();
/* 602 */             int i3 = a1.f();
/* 603 */             b = new b(str1, str2, i3);
/*     */           } 
/* 605 */           this.b.add(new a(paramFile, h.b, paramap.b(), b, k, j, m, i1, i, arrayOfByte, this, (byte)0));
/*     */         } else {
/*     */           b b;
/*     */ 
/*     */ 
/*     */           
/* 611 */           String str1 = null;
/* 612 */           if (paramap.i().containsKey("gcid")) {
/*     */ 
/*     */             
/* 615 */             byte[] arrayOfByte1 = paramap.b((an)paramap.i().get("gcid"));
/*     */             
/* 617 */             String str2 = (str1 = new String(arrayOfByte1, 10, 64, org.a.c.i.a.a)).substring(0, str1.indexOf(false));
/*     */             String str3;
/* 619 */             str1 = (str3 = new String(arrayOfByte1, 76, 64, org.a.c.i.a.a)).substring(0, str3.indexOf(false));
/* 620 */             int i2 = arrayOfByte1[140] << 8 & arrayOfByte1[141];
/* 621 */             b = new b(str2, str1, i2);
/*     */           } 
/*     */           
/* 624 */           str = "TTF";
/* 625 */           this.b.add(new a(paramFile, h.a, paramap.b(), b, k, j, m, i1, i, arrayOfByte, this, (byte)0));
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 630 */         if (a.b()) {
/*     */           z z;
/*     */           
/* 633 */           if ((z = paramap.j()) != null)
/*     */           {
/* 635 */             (new StringBuilder()).append(str).append(": '").append(z.d()).append("' / '")
/* 636 */               .append(z.b()).append("' / '")
/* 637 */               .append(z.c()).append("'");
/*     */           }
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 643 */         this.b.add(new b(paramFile, h.a, "*skipnoname*", (byte)0));
/* 644 */         (new StringBuilder("Missing 'name' entry for PostScript name in font ")).append(paramFile);
/*     */       } 
/*     */       return;
/* 647 */     } catch (IOException iOException) {
/*     */       
/* 649 */       this.b.add(new b(paramFile, h.a, "*skipexception*", (byte)0));
/* 650 */       (new StringBuilder("Could not load font file: ")).append(paramFile);
/*     */       
/*     */       return;
/*     */     } finally {
/* 654 */       paramap.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(File paramFile) {
/* 663 */     FileInputStream fileInputStream = new FileInputStream(paramFile);
/*     */     
/*     */     try {
/*     */       org.a.b.g.d d1;
/* 667 */       if ((d1 = org.a.b.g.d.a(fileInputStream)).b() != null && d1.b().contains("|")) {
/*     */         
/* 669 */         this.b.add(new b(paramFile, h.c, "*skippipeinname*", (byte)0));
/* 670 */         (new StringBuilder("Skipping font with '|' in name ")).append(d1.b()).append(" in file ").append(paramFile);
/*     */         return;
/*     */       } 
/* 673 */       this.b.add(new a(paramFile, h.c, d1.b(), null, -1, -1, 0, 0, -1, null, this, (byte)0));
/*     */ 
/*     */       
/* 676 */       if (a.b())
/*     */       {
/* 678 */         (new StringBuilder("PFB: '")).append(d1.b()).append("' / '").append(d1.e()).append("' / '")
/* 679 */           .append(d1.f()).append("'");
/*     */       }
/*     */       return;
/* 682 */     } catch (IOException iOException) {
/*     */       
/* 684 */       (new StringBuilder("Could not load font file: ")).append(paramFile);
/*     */       
/*     */       return;
/*     */     } finally {
/* 688 */       fileInputStream.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private ap a(String paramString, File paramFile) {
/*     */     try {
/* 696 */       ap ap = b(paramString, paramFile);
/*     */       
/* 698 */       if (a.a())
/*     */       {
/* 700 */         (new StringBuilder("Loaded ")).append(paramString).append(" from ").append(paramFile);
/*     */       }
/* 702 */       return ap;
/*     */     }
/* 704 */     catch (NullPointerException nullPointerException) {
/*     */       
/* 706 */       (new StringBuilder("Could not load font file: ")).append(paramFile);
/*     */     }
/* 708 */     catch (IOException iOException) {
/*     */       
/* 710 */       (new StringBuilder("Could not load font file: ")).append(paramFile);
/*     */     } 
/* 712 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private static ap b(String paramString, File paramFile) {
/* 717 */     if (paramFile.getName().toLowerCase().endsWith(".ttc")) {
/*     */       ao ao;
/*     */       
/*     */       ap ap;
/* 721 */       if ((ap = (ao = new ao(paramFile)).a(paramString)) == null) {
/*     */         
/* 723 */         ao.close();
/* 724 */         throw new IOException("Font " + paramString + " not found in " + paramFile);
/*     */       } 
/* 726 */       return ap;
/*     */     } 
/*     */     
/*     */     al al;
/*     */     
/* 731 */     return (al = new al(false, true)).b(paramFile);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ad c(String paramString, File paramFile) {
/*     */     try {
/*     */       ab ab;
/* 741 */       ad ad = (ab = new ab(false, true)).a(paramFile);
/*     */       
/* 743 */       if (a.a())
/*     */       {
/* 745 */         (new StringBuilder("Loaded ")).append(paramString).append(" from ").append(paramFile);
/*     */       }
/* 747 */       return ad;
/*     */     }
/* 749 */     catch (IOException iOException) {
/*     */       
/* 751 */       (new StringBuilder("Could not load font file: ")).append(paramFile);
/*     */       
/* 753 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static org.a.b.g.d d(String paramString, File paramFile) {
/* 758 */     FileInputStream fileInputStream = null;
/*     */ 
/*     */     
/*     */     try {
/* 762 */       org.a.b.g.d d1 = org.a.b.g.d.a(fileInputStream = new FileInputStream(paramFile));
/*     */       
/* 764 */       if (a.a())
/*     */       {
/* 766 */         (new StringBuilder("Loaded ")).append(paramString).append(" from ").append(paramFile);
/*     */       }
/* 768 */       return d1;
/*     */     }
/* 770 */     catch (IOException iOException) {
/*     */       
/* 772 */       (new StringBuilder("Could not load font file: ")).append(paramFile);
/*     */     }
/*     */     finally {
/*     */       
/* 776 */       am.a(fileInputStream);
/*     */     } 
/* 778 */     return null;
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
/*     */   public final List<? extends i> a() {
/* 800 */     return (List)this.b;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */