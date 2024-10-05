/*     */ package org.a.b.g;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.a.b.d.a;
/*     */ import org.a.b.d.b;
/*     */ import org.a.b.d.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class f
/*     */ {
/*     */   private e a;
/*     */   private d b;
/*     */   
/*     */   public final d a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  60 */     this.b = new d(paramArrayOfbyte1, paramArrayOfbyte2);
/*  61 */     a(paramArrayOfbyte1);
/*  62 */     if (paramArrayOfbyte2.length > 0)
/*     */     {
/*  64 */       b(paramArrayOfbyte2);
/*     */     }
/*  66 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(byte[] paramArrayOfbyte) {
/*  74 */     if (paramArrayOfbyte.length == 0)
/*     */     {
/*  76 */       throw new IllegalArgumentException("byte[] is empty");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  81 */     if (paramArrayOfbyte.length < 2 || (paramArrayOfbyte[0] != 37 && paramArrayOfbyte[1] != 33))
/*     */     {
/*  83 */       throw new IOException("Invalid start of ASCII segment");
/*     */     }
/*     */     
/*  86 */     this.a = new e(paramArrayOfbyte);
/*     */ 
/*     */     
/*  89 */     if (this.a.b().a().equals("FontDirectory")) {
/*     */       
/*  91 */       a(b.b, "FontDirectory");
/*  92 */       a(b.c);
/*  93 */       a(b.b, "known");
/*  94 */       a(b.h);
/*  95 */       e();
/*  96 */       a(b.h);
/*  97 */       e();
/*  98 */       a(b.b, "ifelse");
/*     */     } 
/*     */ 
/*     */     
/* 102 */     int i = a(b.e).c();
/* 103 */     a(b.b, "dict");
/*     */     
/* 105 */     b(b.b, "dup");
/*     */     
/* 107 */     a(b.b, "begin");
/*     */     
/* 109 */     for (byte b = 0; b < i;) {
/*     */ 
/*     */ 
/*     */       
/* 113 */       if ((b1 = this.a.b()) != null)
/*     */       {
/*     */ 
/*     */         
/* 117 */         if (b1.b() != b.b || (
/* 118 */           !b1.a().equals("currentdict") && !b1.a().equals("end"))) {
/*     */           String str;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 125 */           if ((str = a(b.c).a()).equals("FontInfo") || str.equals("Fontinfo")) {
/*     */             
/* 127 */             a(b());
/*     */           }
/* 129 */           else if (str.equals("Metrics")) {
/*     */             
/* 131 */             b();
/*     */           }
/* 133 */           else if (str.equals("Encoding")) {
/*     */             
/* 135 */             a();
/*     */           }
/*     */           else {
/*     */             
/* 139 */             a(str);
/*     */           }  b++;
/*     */         }  } 
/*     */     } 
/* 143 */     b(b.b, "currentdict");
/* 144 */     a(b.b, "end");
/*     */     
/* 146 */     a(b.b, "currentfile");
/* 147 */     a(b.b, "eexec");
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(String paramString) {
/* 152 */     List<b> list = c();
/*     */     
/* 154 */     if (paramString.equals("FontName")) {
/*     */       
/* 156 */       this.b.a = ((b)list.get(0)).a(); return;
/*     */     } 
/* 158 */     if (paramString.equals("PaintType")) {
/*     */       
/* 160 */       ((b)list.get(0)).c(); return;
/*     */     } 
/* 162 */     if (paramString.equals("FontType")) {
/*     */       
/* 164 */       ((b)list.get(0)).c(); return;
/*     */     } 
/* 166 */     if (paramString.equals("FontMatrix")) {
/*     */       
/* 168 */       this.b.c = a(list); return;
/*     */     } 
/* 170 */     if (paramString.equals("FontBBox")) {
/*     */       
/* 172 */       this.b.d = a(list); return;
/*     */     } 
/* 174 */     if (paramString.equals("UniqueID")) {
/*     */       
/* 176 */       ((b)list.get(0)).c(); return;
/*     */     } 
/* 178 */     if (paramString.equals("StrokeWidth")) {
/*     */       
/* 180 */       ((b)list.get(0)).d(); return;
/*     */     } 
/* 182 */     if (paramString.equals("FID"))
/*     */     {
/* 184 */       ((b)list.get(0)).a();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void a() {
/* 190 */     if (this.a.b().b() == b.b) {
/*     */       String str;
/*     */ 
/*     */       
/* 194 */       if ((str = this.a.a().a()).equals("StandardEncoding")) {
/*     */         
/* 196 */         this.b.b = (b)c.a;
/*     */       }
/*     */       else {
/*     */         
/* 200 */         throw new IOException("Unknown encoding: " + str);
/*     */       } 
/* 202 */       b(b.b, "readonly");
/* 203 */       a(b.b, "def");
/*     */       
/*     */       return;
/*     */     } 
/* 207 */     a(b.e).c();
/* 208 */     b(b.b, "array");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 213 */     while (this.a.b().b() != b.b || (
/* 214 */       !this.a.b().a().equals("dup") && 
/* 215 */       !this.a.b().a().equals("readonly") && 
/* 216 */       !this.a.b().a().equals("def")))
/*     */     {
/* 218 */       this.a.a();
/*     */     }
/*     */     
/* 221 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 222 */     while (this.a.b().b() == b.b && this.a
/* 223 */       .b().a().equals("dup")) {
/*     */       
/* 225 */       a(b.b, "dup");
/* 226 */       int i = a(b.e).c();
/* 227 */       String str = a(b.c).a();
/* 228 */       a(b.b, "put");
/* 229 */       hashMap.put(Integer.valueOf(i), str);
/*     */     } 
/* 231 */     this.b.b = (b)new a(hashMap);
/* 232 */     b(b.b, "readonly");
/* 233 */     a(b.b, "def");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static List<Number> a(List<b> paramList) {
/* 242 */     ArrayList<Float> arrayList = new ArrayList(); byte b; int i;
/* 243 */     for (b = 1, i = paramList.size() - 1; b < i; b++) {
/*     */       b b1;
/*     */       
/* 246 */       if ((b1 = paramList.get(b)).b() == b.d) {
/*     */         
/* 248 */         arrayList.add(Float.valueOf(b1.d()));
/*     */       }
/* 250 */       else if (b1.b() == b.e) {
/*     */         
/* 252 */         arrayList.add(Integer.valueOf(b1.c()));
/*     */       }
/*     */       else {
/*     */         
/* 256 */         throw new IOException("Expected INTEGER or REAL but got " + b1.b());
/*     */       } 
/*     */     } 
/* 259 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Map<String, List<b>> paramMap) {
/* 267 */     for (Iterator<Map.Entry> iterator = paramMap.entrySet().iterator(); iterator.hasNext(); ) {
/*     */       Map.Entry<String, ?> entry;
/* 269 */       String str = (entry = iterator.next()).getKey();
/* 270 */       List<b> list = (List)entry.getValue();
/*     */       
/* 272 */       if (str.equals("version")) {
/*     */         
/* 274 */         ((b)list.get(0)).a(); continue;
/*     */       } 
/* 276 */       if (str.equals("Notice")) {
/*     */         
/* 278 */         ((b)list.get(0)).a(); continue;
/*     */       } 
/* 280 */       if (str.equals("FullName")) {
/*     */         
/* 282 */         this.b.e = ((b)list.get(0)).a(); continue;
/*     */       } 
/* 284 */       if (str.equals("FamilyName")) {
/*     */         
/* 286 */         this.b.f = ((b)list.get(0)).a(); continue;
/*     */       } 
/* 288 */       if (str.equals("Weight")) {
/*     */         
/* 290 */         this.b.g = ((b)list.get(0)).a(); continue;
/*     */       } 
/* 292 */       if (str.equals("ItalicAngle")) {
/*     */         
/* 294 */         ((b)list.get(0)).d(); continue;
/*     */       } 
/* 296 */       if (str.equals("isFixedPitch")) {
/*     */         
/* 298 */         ((b)list.get(0)).e(); continue;
/*     */       } 
/* 300 */       if (str.equals("UnderlinePosition")) {
/*     */         
/* 302 */         ((b)list.get(0)).d(); continue;
/*     */       } 
/* 304 */       if (str.equals("UnderlineThickness"))
/*     */       {
/* 306 */         ((b)list.get(0)).d();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<String, List<b>> b() {
/* 317 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*     */     
/* 319 */     int i = a(b.e).c();
/* 320 */     a(b.b, "dict");
/* 321 */     b(b.b, "dup");
/* 322 */     a(b.b, "begin");
/*     */     
/* 324 */     for (byte b = 0; b < i;) {
/*     */       
/* 326 */       if (this.a.b() != null) {
/*     */ 
/*     */ 
/*     */         
/* 330 */         if (this.a.b().b() == b.b && 
/* 331 */           !this.a.b().a().equals("end"))
/*     */         {
/* 333 */           a(b.b);
/*     */         }
/*     */         
/* 336 */         if (this.a.b() != null)
/*     */         {
/*     */ 
/*     */           
/* 340 */           if (this.a.b().b() != b.b || 
/* 341 */             !this.a.b().a().equals("end")) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 347 */             String str = a(b.c).a();
/* 348 */             List<b> list = c();
/* 349 */             hashMap.put(str, list); b++;
/*     */           }  } 
/*     */       } 
/* 352 */     }  a(b.b, "end");
/* 353 */     b(b.b, "readonly");
/* 354 */     a(b.b, "def");
/*     */     
/* 356 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<b> c() {
/* 364 */     List<b> list = d();
/* 365 */     g();
/* 366 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<b> d() {
/* 376 */     ArrayList<b> arrayList = new ArrayList();
/* 377 */     b b = this.a.a();
/* 378 */     if (this.a.b() == null)
/*     */     {
/* 380 */       return arrayList;
/*     */     }
/* 382 */     arrayList.add(b);
/*     */     
/* 384 */     if (b.b() == b.f) {
/*     */       
/* 386 */       byte b1 = 1;
/*     */       
/*     */       while (true) {
/* 389 */         if (this.a.b() == null)
/*     */         {
/* 391 */           return arrayList;
/*     */         }
/* 393 */         if (this.a.b().b() == b.f)
/*     */         {
/* 395 */           b1++;
/*     */         }
/*     */         
/* 398 */         b = this.a.a();
/* 399 */         arrayList.add(b);
/*     */         
/* 401 */         if (b.b() == b.g)
/*     */         {
/* 403 */           b1--;
/* 404 */           if (b1 == 0) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       
/*     */       }
/*     */     
/* 411 */     } else if (b.b() == b.h) {
/*     */       
/* 413 */       arrayList.addAll(e());
/*     */     }
/* 415 */     else if (b.b() == b.k) {
/*     */ 
/*     */       
/* 418 */       a(b.l);
/* 419 */       return arrayList;
/*     */     } 
/*     */     
/* 422 */     b(arrayList);
/* 423 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(List<b> paramList) {
/* 429 */     if (this.a.b().a().equals("systemdict")) {
/*     */       
/* 431 */       a(b.b, "systemdict");
/* 432 */       a(b.c, "internaldict");
/* 433 */       a(b.b, "known");
/*     */       
/* 435 */       a(b.h);
/* 436 */       e();
/*     */       
/* 438 */       a(b.h);
/* 439 */       e();
/*     */       
/* 441 */       a(b.b, "ifelse");
/*     */ 
/*     */       
/* 444 */       a(b.h);
/* 445 */       a(b.b, "pop");
/* 446 */       paramList.clear();
/* 447 */       paramList.addAll(d());
/* 448 */       a(b.i);
/*     */       
/* 450 */       a(b.b, "if");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<b> e() {
/* 459 */     ArrayList<b> arrayList = new ArrayList();
/*     */     
/* 461 */     byte b = 1;
/*     */     
/*     */     while (true) {
/* 464 */       if (this.a.b().b() == b.h)
/*     */       {
/* 466 */         b++;
/*     */       }
/*     */       
/* 469 */       b b2 = this.a.a();
/* 470 */       arrayList.add(b2);
/*     */       
/* 472 */       if (b2.b() == b.i) {
/*     */         
/* 474 */         b--;
/* 475 */         if (b != 0) {
/*     */           continue;
/*     */         }
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     b b1;
/* 482 */     if ((b1 = b(b.b, "executeonly")) != null)
/*     */     {
/* 484 */       arrayList.add(b1);
/*     */     }
/*     */     
/* 487 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(byte[] paramArrayOfbyte) {
/* 497 */     if (c(paramArrayOfbyte)) {
/*     */       
/* 499 */       paramArrayOfbyte = a(paramArrayOfbyte, 55665, 4);
/*     */     }
/*     */     else {
/*     */       
/* 503 */       paramArrayOfbyte = a(d(paramArrayOfbyte), 55665, 4);
/*     */     } 
/* 505 */     this.a = new e(paramArrayOfbyte);
/*     */ 
/*     */     
/* 508 */     b b = this.a.b();
/* 509 */     while (b != null && !b.a().equals("Private")) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 514 */       this.a.a();
/* 515 */       b = this.a.b();
/*     */     } 
/* 517 */     if (b == null)
/*     */     {
/* 519 */       throw new IOException("/Private token not found");
/*     */     }
/*     */ 
/*     */     
/* 523 */     a(b.c, "Private");
/* 524 */     int i = a(b.e).c();
/* 525 */     a(b.b, "dict");
/*     */ 
/*     */     
/* 528 */     b(b.b, "dup");
/* 529 */     a(b.b, "begin");
/*     */     
/* 531 */     int j = 4;
/*     */     
/* 533 */     for (byte b1 = 0; b1 < i;) {
/*     */ 
/*     */       
/* 536 */       if (this.a.b() != null && this.a.b().b() == b.c) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 542 */         String str = a(b.c).a();
/*     */         
/* 544 */         if ("Subrs".equals(str)) {
/*     */           
/* 546 */           a(j);
/*     */         }
/* 548 */         else if ("OtherSubrs".equals(str)) {
/*     */           
/* 550 */           f();
/*     */         }
/* 552 */         else if ("lenIV".equals(str)) {
/*     */           
/* 554 */           j = ((b)c().get(0)).c();
/*     */         }
/* 556 */         else if ("ND".equals(str)) {
/*     */           
/* 558 */           a(b.h);
/*     */           
/* 560 */           b(b.b, "noaccess");
/* 561 */           a(b.b, "def");
/* 562 */           a(b.i);
/* 563 */           b(b.b, "executeonly");
/* 564 */           a(b.b, "def");
/*     */         }
/* 566 */         else if ("NP".equals(str)) {
/*     */           
/* 568 */           a(b.h);
/* 569 */           b(b.b, "noaccess");
/* 570 */           a(b.b);
/* 571 */           a(b.i);
/* 572 */           b(b.b, "executeonly");
/* 573 */           a(b.b, "def");
/*     */         }
/* 575 */         else if ("RD".equals(str)) {
/*     */ 
/*     */           
/* 578 */           a(b.h);
/* 579 */           e();
/* 580 */           b(b.b, "bind");
/* 581 */           b(b.b, "executeonly");
/* 582 */           a(b.b, "def");
/*     */         }
/*     */         else {
/*     */           
/* 586 */           a(str, c());
/*     */         } 
/*     */         
/*     */         b1++;
/*     */       } 
/*     */     } 
/*     */     
/* 593 */     while (this.a.b().b() != b.c || 
/* 594 */       !this.a.b().a().equals("CharStrings"))
/*     */     {
/* 596 */       this.a.a();
/*     */     }
/*     */ 
/*     */     
/* 600 */     a(b.c, "CharStrings");
/* 601 */     b(j);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(String paramString, List<b> paramList) {
/* 609 */     if (paramString.equals("BlueValues")) {
/*     */       
/* 611 */       a(paramList); return;
/*     */     } 
/* 613 */     if (paramString.equals("OtherBlues")) {
/*     */       
/* 615 */       a(paramList); return;
/*     */     } 
/* 617 */     if (paramString.equals("FamilyBlues")) {
/*     */       
/* 619 */       a(paramList); return;
/*     */     } 
/* 621 */     if (paramString.equals("FamilyOtherBlues")) {
/*     */       
/* 623 */       a(paramList); return;
/*     */     } 
/* 625 */     if (paramString.equals("BlueScale")) {
/*     */       
/* 627 */       ((b)paramList.get(0)).d(); return;
/*     */     } 
/* 629 */     if (paramString.equals("BlueShift")) {
/*     */       
/* 631 */       ((b)paramList.get(0)).c(); return;
/*     */     } 
/* 633 */     if (paramString.equals("BlueFuzz")) {
/*     */       
/* 635 */       ((b)paramList.get(0)).c(); return;
/*     */     } 
/* 637 */     if (paramString.equals("StdHW")) {
/*     */       
/* 639 */       a(paramList); return;
/*     */     } 
/* 641 */     if (paramString.equals("StdVW")) {
/*     */       
/* 643 */       a(paramList); return;
/*     */     } 
/* 645 */     if (paramString.equals("StemSnapH")) {
/*     */       
/* 647 */       a(paramList); return;
/*     */     } 
/* 649 */     if (paramString.equals("StemSnapV")) {
/*     */       
/* 651 */       a(paramList); return;
/*     */     } 
/* 653 */     if (paramString.equals("ForceBold")) {
/*     */       
/* 655 */       ((b)paramList.get(0)).e(); return;
/*     */     } 
/* 657 */     if (paramString.equals("LanguageGroup"))
/*     */     {
/* 659 */       ((b)paramList.get(0)).c();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(int paramInt) {
/* 670 */     int i = a(b.e).c(); byte b;
/* 671 */     for (b = 0; b < i; b++)
/*     */     {
/* 673 */       this.b.h.add(null);
/*     */     }
/* 675 */     a(b.b, "array");
/*     */     
/* 677 */     for (b = 0; b < i;) {
/*     */ 
/*     */       
/* 680 */       if (this.a.b() != null)
/*     */       {
/*     */ 
/*     */         
/* 684 */         if (this.a.b().b() == b.b && this.a
/* 685 */           .b().a().equals("dup")) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 690 */           a(b.b, "dup");
/* 691 */           b b1 = a(b.e);
/* 692 */           a(b.e);
/*     */ 
/*     */           
/* 695 */           b b2 = a(b.j);
/* 696 */           this.b.h.set(b1.c(), a(b2.f(), 4330, paramInt));
/* 697 */           h(); b++;
/*     */         }  } 
/* 699 */     }  g();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void f() {
/* 705 */     if (this.a.b().b() == b.f) {
/*     */       
/* 707 */       d();
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 712 */       int i = a(b.e).c();
/* 713 */       a(b.b, "array");
/*     */       
/* 715 */       for (byte b = 0; b < i; b++) {
/*     */         
/* 717 */         a(b.b, "dup");
/* 718 */         a(b.e);
/* 719 */         d();
/* 720 */         h();
/*     */       } 
/* 722 */     }  g();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(int paramInt) {
/* 732 */     int i = a(b.e).c();
/* 733 */     a(b.b, "dict");
/*     */ 
/*     */     
/* 736 */     a(b.b, "dup");
/* 737 */     a(b.b, "begin");
/*     */     
/* 739 */     for (byte b = 0; b < i;) {
/*     */ 
/*     */       
/* 742 */       if (this.a.b() != null)
/*     */       {
/*     */ 
/*     */         
/* 746 */         if (this.a.b().b() != b.b || 
/* 747 */           !this.a.b().a().equals("end")) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 752 */           String str = a(b.c).a();
/*     */ 
/*     */           
/* 755 */           a(b.e);
/* 756 */           b b1 = a(b.j);
/* 757 */           this.b.i.put(str, a(b1.f(), 4330, paramInt));
/* 758 */           g();
/*     */           b++;
/*     */         }  } 
/*     */     } 
/* 762 */     a(b.b, "end");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void g() {
/* 773 */     b(b.b, "readonly");
/* 774 */     b(b.b, "noaccess");
/*     */     
/*     */     b b;
/* 777 */     if ((b = a(b.b)).a().equals("ND") || b.a().equals("|-")) {
/*     */       return;
/*     */     }
/*     */     
/* 781 */     if (b.a().equals("noaccess"))
/*     */     {
/* 783 */       b = a(b.b);
/*     */     }
/*     */     
/* 786 */     if (b.a().equals("def")) {
/*     */       return;
/*     */     }
/*     */     
/* 790 */     throw new IOException("Found " + b + " but expected ND");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void h() {
/* 798 */     b(b.b, "readonly");
/*     */     
/*     */     b b;
/* 801 */     if ((b = a(b.b)).a().equals("NP") || b.a().equals("|")) {
/*     */       return;
/*     */     }
/*     */     
/* 805 */     if (b.a().equals("noaccess"))
/*     */     {
/* 807 */       b = a(b.b);
/*     */     }
/*     */     
/* 810 */     if (b.a().equals("put")) {
/*     */       return;
/*     */     }
/*     */     
/* 814 */     throw new IOException("Found " + b + " but expected NP");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private b a(b.a parama) {
/*     */     b b;
/* 823 */     if ((b = this.a.a()) == null || b.b() != parama)
/*     */     {
/* 825 */       throw new IOException("Found " + b + " but expected " + parama);
/*     */     }
/* 827 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(b.a parama, String paramString) {
/*     */     b b;
/* 837 */     if (!(b = a(parama)).a().equals(paramString))
/*     */     {
/* 839 */       throw new IOException("Found " + b + " but expected " + paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private b b(b.a parama, String paramString) {
/*     */     b b;
/* 850 */     if ((b = this.a.b()) != null && b.b() == parama && b.a().equals(paramString))
/*     */     {
/* 852 */       return this.a.a();
/*     */     }
/* 854 */     return null;
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
/*     */   private static byte[] a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 868 */     if (paramInt2 == -1)
/*     */     {
/* 870 */       return paramArrayOfbyte;
/*     */     }
/*     */     
/* 873 */     if (paramArrayOfbyte.length == 0 || paramInt2 > paramArrayOfbyte.length)
/*     */     {
/* 875 */       return new byte[0];
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 880 */     byte[] arrayOfByte = new byte[paramArrayOfbyte.length - paramInt2];
/* 881 */     for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/*     */ 
/*     */       
/* 884 */       int i, j = (i = paramArrayOfbyte[b] & 0xFF) ^ paramInt1 >> 8;
/* 885 */       if (b >= paramInt2)
/*     */       {
/* 887 */         arrayOfByte[b - paramInt2] = (byte)j;
/*     */       }
/* 889 */       paramInt1 = (i + paramInt1) * 52845 + 22719 & 0xFFFF;
/*     */     } 
/* 891 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean c(byte[] paramArrayOfbyte) {
/* 898 */     if (paramArrayOfbyte.length < 4)
/*     */     {
/* 900 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 904 */     for (byte b = 0; b < 4; b++) {
/*     */       byte b1;
/*     */       
/* 907 */       if ((b1 = paramArrayOfbyte[b]) != 10 && b1 != 13 && b1 != 32 && b1 != 9 && 
/* 908 */         Character.digit((char)b1, 16) == -1)
/*     */       {
/* 910 */         return true;
/*     */       }
/*     */     } 
/* 913 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static byte[] d(byte[] paramArrayOfbyte) {
/* 919 */     byte b = 0; byte[] arrayOfByte1; int j, k;
/* 920 */     for (j = (arrayOfByte1 = paramArrayOfbyte).length, k = 0; k < j; k++) {
/*     */       byte b1;
/* 922 */       if (Character.digit((char)(b1 = arrayOfByte1[k]), 16) != -1)
/*     */       {
/* 924 */         b++;
/*     */       }
/*     */     } 
/* 927 */     arrayOfByte1 = new byte[b / 2];
/* 928 */     j = 0;
/* 929 */     k = -1; byte[] arrayOfByte2;
/* 930 */     for (int i = (arrayOfByte2 = paramArrayOfbyte).length; b < i; b++) {
/*     */       byte b1;
/*     */       int m;
/* 933 */       if ((m = Character.digit((char)(b1 = arrayOfByte2[b]), 16)) != -1)
/*     */       {
/* 935 */         if (k == -1) {
/*     */           
/* 937 */           k = m;
/*     */         }
/*     */         else {
/*     */           
/* 941 */           arrayOfByte1[j++] = (byte)((k << 4) + m);
/* 942 */           k = -1;
/*     */         } 
/*     */       }
/*     */     } 
/* 946 */     return arrayOfByte1;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\g\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */