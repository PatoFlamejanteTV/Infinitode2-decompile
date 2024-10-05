/*     */ package com.a.a.c.k.b;
/*     */ 
/*     */ import com.a.a.a.al;
/*     */ import com.a.a.a.am;
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.b.f.a;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.f.ad;
/*     */ import com.a.a.c.f.b;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k.a;
/*     */ import com.a.a.c.k.a.h;
/*     */ import com.a.a.c.k.a.j;
/*     */ import com.a.a.c.k.a.m;
/*     */ import com.a.a.c.k.a.v;
/*     */ import com.a.a.c.k.e;
/*     */ import com.a.a.c.k.g;
/*     */ import com.a.a.c.k.k;
/*     */ import com.a.a.c.k.o;
/*     */ import com.a.a.c.k.p;
/*     */ import com.a.a.c.k.q;
/*     */ import com.a.a.c.l;
/*     */ import com.a.a.c.l.o;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.m.k;
/*     */ import com.a.a.c.m.n;
/*     */ import com.a.a.c.m.r;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.w;
/*     */ import com.a.a.c.y;
/*     */ import java.io.Closeable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ public abstract class d
/*     */   extends ao<Object>
/*     */   implements k, q
/*     */ {
/*  47 */   protected static final e[] b = new e[0];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final e[] c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final e[] d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final a e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final Object f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final m g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private l.c j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected d(j paramj, g paramg, e[] paramArrayOfe1, e[] paramArrayOfe2) {
/* 116 */     super(paramj);
/* 117 */     this.a = paramj;
/* 118 */     this.c = paramArrayOfe1;
/* 119 */     this.d = paramArrayOfe2;
/* 120 */     if (paramg == null) {
/*     */ 
/*     */       
/* 123 */       this.i = null;
/* 124 */       this.e = null;
/* 125 */       this.f = null;
/* 126 */       this.g = null;
/* 127 */       this.j = null; return;
/*     */     } 
/* 129 */     this.i = paramg.e();
/* 130 */     this.e = paramg.c();
/* 131 */     this.f = paramg.d();
/* 132 */     this.g = paramg.f();
/* 133 */     l.d d1 = paramg.a().a(null);
/* 134 */     this.j = d1.c();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected d(d paramd, e[] paramArrayOfe1, e[] paramArrayOfe2) {
/* 141 */     super(paramd.h);
/* 142 */     this.a = paramd.a;
/* 143 */     this.c = paramArrayOfe1;
/* 144 */     this.d = paramArrayOfe2;
/*     */     
/* 146 */     this.i = paramd.i;
/* 147 */     this.e = paramd.e;
/* 148 */     this.g = paramd.g;
/* 149 */     this.f = paramd.f;
/* 150 */     this.j = paramd.j;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected d(d paramd, m paramm) {
/* 156 */     this(paramd, paramm, paramd.f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected d(d paramd, m paramm, Object paramObject) {
/* 165 */     super(paramd.h);
/* 166 */     this.a = paramd.a;
/* 167 */     this.c = paramd.c;
/* 168 */     this.d = paramd.d;
/*     */     
/* 170 */     this.i = paramd.i;
/* 171 */     this.e = paramd.e;
/* 172 */     this.g = paramm;
/* 173 */     this.f = paramObject;
/* 174 */     this.j = paramd.j;
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
/*     */   protected d(d paramd, Set<String> paramSet1, Set<String> paramSet2) {
/* 190 */     super(paramd.h);
/*     */     
/* 192 */     this.a = paramd.a;
/* 193 */     e[] arrayOfE1 = paramd.c;
/* 194 */     e[] arrayOfE2 = paramd.d;
/* 195 */     int i = arrayOfE1.length;
/*     */     
/* 197 */     ArrayList<e> arrayList1 = new ArrayList(i);
/* 198 */     ArrayList<e> arrayList2 = (arrayOfE2 == null) ? null : new ArrayList(i);
/*     */     
/* 200 */     for (byte b = 0; b < i; b++) {
/*     */       e e1;
/*     */       
/* 203 */       if (!n.a((e1 = arrayOfE1[b]).a(), paramSet1, paramSet2)) {
/*     */ 
/*     */         
/* 206 */         arrayList1.add(e1);
/* 207 */         if (arrayOfE2 != null)
/* 208 */           arrayList2.add(arrayOfE2[b]); 
/*     */       } 
/*     */     } 
/* 211 */     this.c = arrayList1.<e>toArray(new e[arrayList1.size()]);
/* 212 */     this.d = (arrayList2 == null) ? null : arrayList2.<e>toArray(new e[arrayList2.size()]);
/*     */     
/* 214 */     this.i = paramd.i;
/* 215 */     this.e = paramd.e;
/* 216 */     this.g = paramd.g;
/* 217 */     this.f = paramd.f;
/* 218 */     this.j = paramd.j;
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
/*     */   public abstract d a(m paramm);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract d a(Set<String> paramSet1, Set<String> paramSet2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract d d();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract d a(Object paramObject);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract d a(e[] paramArrayOfe1, e[] paramArrayOfe2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected d(d paramd, r paramr) {
/* 304 */     this(paramd, a(paramd.c, paramr), a(paramd.d, paramr));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final e[] a(e[] paramArrayOfe, r paramr) {
/* 310 */     if (paramArrayOfe == null || paramArrayOfe.length == 0 || paramr == null || paramr == r.a) {
/* 311 */       return paramArrayOfe;
/*     */     }
/*     */     int i;
/* 314 */     e[] arrayOfE = new e[i = paramArrayOfe.length];
/* 315 */     for (byte b = 0; b < i; b++) {
/*     */       e e1;
/* 317 */       if ((e1 = paramArrayOfe[b]) != null) {
/* 318 */         arrayOfE[b] = e1.a(paramr);
/*     */       }
/*     */     } 
/* 321 */     return arrayOfE;
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
/*     */   public final void a(aa paramaa) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield d : [Lcom/a/a/c/k/e;
/*     */     //   4: ifnonnull -> 11
/*     */     //   7: iconst_0
/*     */     //   8: goto -> 16
/*     */     //   11: aload_0
/*     */     //   12: getfield d : [Lcom/a/a/c/k/e;
/*     */     //   15: arraylength
/*     */     //   16: istore_2
/*     */     //   17: iconst_0
/*     */     //   18: istore_3
/*     */     //   19: aload_0
/*     */     //   20: getfield c : [Lcom/a/a/c/k/e;
/*     */     //   23: arraylength
/*     */     //   24: istore #4
/*     */     //   26: iload_3
/*     */     //   27: iload #4
/*     */     //   29: if_icmpge -> 265
/*     */     //   32: aload_0
/*     */     //   33: getfield c : [Lcom/a/a/c/k/e;
/*     */     //   36: iload_3
/*     */     //   37: aaload
/*     */     //   38: dup
/*     */     //   39: astore #5
/*     */     //   41: invokevirtual i : ()Z
/*     */     //   44: ifne -> 96
/*     */     //   47: aload #5
/*     */     //   49: invokevirtual g : ()Z
/*     */     //   52: ifne -> 96
/*     */     //   55: aload_1
/*     */     //   56: invokevirtual m : ()Lcom/a/a/c/o;
/*     */     //   59: dup
/*     */     //   60: astore #6
/*     */     //   62: ifnull -> 96
/*     */     //   65: aload #5
/*     */     //   67: aload #6
/*     */     //   69: invokevirtual b : (Lcom/a/a/c/o;)V
/*     */     //   72: iload_3
/*     */     //   73: iload_2
/*     */     //   74: if_icmpge -> 96
/*     */     //   77: aload_0
/*     */     //   78: getfield d : [Lcom/a/a/c/k/e;
/*     */     //   81: iload_3
/*     */     //   82: aaload
/*     */     //   83: dup
/*     */     //   84: astore #7
/*     */     //   86: ifnull -> 96
/*     */     //   89: aload #7
/*     */     //   91: aload #6
/*     */     //   93: invokevirtual b : (Lcom/a/a/c/o;)V
/*     */     //   96: aload #5
/*     */     //   98: invokevirtual f : ()Z
/*     */     //   101: ifne -> 259
/*     */     //   104: aload_1
/*     */     //   105: aload #5
/*     */     //   107: invokestatic a : (Lcom/a/a/c/aa;Lcom/a/a/c/k/e;)Lcom/a/a/c/o;
/*     */     //   110: dup
/*     */     //   111: astore #6
/*     */     //   113: ifnonnull -> 225
/*     */     //   116: aload #5
/*     */     //   118: invokevirtual j : ()Lcom/a/a/c/j;
/*     */     //   121: dup
/*     */     //   122: astore #7
/*     */     //   124: ifnonnull -> 167
/*     */     //   127: aload #5
/*     */     //   129: invokevirtual c : ()Lcom/a/a/c/j;
/*     */     //   132: dup
/*     */     //   133: astore #7
/*     */     //   135: invokevirtual m : ()Z
/*     */     //   138: ifne -> 167
/*     */     //   141: aload #7
/*     */     //   143: invokevirtual n : ()Z
/*     */     //   146: ifne -> 157
/*     */     //   149: aload #7
/*     */     //   151: invokevirtual w : ()I
/*     */     //   154: ifle -> 259
/*     */     //   157: aload #5
/*     */     //   159: aload #7
/*     */     //   161: invokevirtual a : (Lcom/a/a/c/j;)V
/*     */     //   164: goto -> 259
/*     */     //   167: aload_1
/*     */     //   168: aload #7
/*     */     //   170: aload #5
/*     */     //   172: invokevirtual a : (Lcom/a/a/c/j;Lcom/a/a/c/c;)Lcom/a/a/c/o;
/*     */     //   175: astore #6
/*     */     //   177: aload #7
/*     */     //   179: invokevirtual n : ()Z
/*     */     //   182: ifeq -> 225
/*     */     //   185: aload #7
/*     */     //   187: invokevirtual u : ()Lcom/a/a/c/j;
/*     */     //   190: invokevirtual B : ()Ljava/lang/Object;
/*     */     //   193: checkcast com/a/a/c/i/i
/*     */     //   196: dup
/*     */     //   197: astore #7
/*     */     //   199: ifnull -> 225
/*     */     //   202: aload #6
/*     */     //   204: instanceof com/a/a/c/k/j
/*     */     //   207: ifeq -> 225
/*     */     //   210: aload #6
/*     */     //   212: checkcast com/a/a/c/k/j
/*     */     //   215: aload #7
/*     */     //   217: invokevirtual a : (Lcom/a/a/c/i/i;)Lcom/a/a/c/k/j;
/*     */     //   220: dup
/*     */     //   221: astore #6
/*     */     //   223: astore #6
/*     */     //   225: iload_3
/*     */     //   226: iload_2
/*     */     //   227: if_icmpge -> 252
/*     */     //   230: aload_0
/*     */     //   231: getfield d : [Lcom/a/a/c/k/e;
/*     */     //   234: iload_3
/*     */     //   235: aaload
/*     */     //   236: dup
/*     */     //   237: astore #7
/*     */     //   239: ifnull -> 252
/*     */     //   242: aload #7
/*     */     //   244: aload #6
/*     */     //   246: invokevirtual a : (Lcom/a/a/c/o;)V
/*     */     //   249: goto -> 259
/*     */     //   252: aload #5
/*     */     //   254: aload #6
/*     */     //   256: invokevirtual a : (Lcom/a/a/c/o;)V
/*     */     //   259: iinc #3, 1
/*     */     //   262: goto -> 26
/*     */     //   265: aload_0
/*     */     //   266: getfield e : Lcom/a/a/c/k/a;
/*     */     //   269: ifnull -> 280
/*     */     //   272: aload_0
/*     */     //   273: getfield e : Lcom/a/a/c/k/a;
/*     */     //   276: aload_1
/*     */     //   277: invokevirtual a : (Lcom/a/a/c/aa;)V
/*     */     //   280: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #338	-> 0
/*     */     //   #339	-> 17
/*     */     //   #340	-> 32
/*     */     //   #342	-> 39
/*     */     //   #343	-> 55
/*     */     //   #344	-> 60
/*     */     //   #345	-> 65
/*     */     //   #347	-> 72
/*     */     //   #348	-> 77
/*     */     //   #349	-> 84
/*     */     //   #350	-> 89
/*     */     //   #356	-> 96
/*     */     //   #360	-> 104
/*     */     //   #361	-> 111
/*     */     //   #363	-> 116
/*     */     //   #367	-> 122
/*     */     //   #368	-> 127
/*     */     //   #369	-> 133
/*     */     //   #370	-> 141
/*     */     //   #371	-> 157
/*     */     //   #376	-> 167
/*     */     //   #379	-> 177
/*     */     //   #380	-> 185
/*     */     //   #381	-> 197
/*     */     //   #383	-> 202
/*     */     //   #386	-> 210
/*     */     //   #387	-> 221
/*     */     //   #393	-> 225
/*     */     //   #394	-> 230
/*     */     //   #395	-> 237
/*     */     //   #396	-> 242
/*     */     //   #400	-> 249
/*     */     //   #403	-> 252
/*     */     //   #339	-> 259
/*     */     //   #407	-> 265
/*     */     //   #409	-> 272
/*     */     //   #411	-> 280
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
/*     */   private static o<Object> a(aa paramaa, e parame) {
/*     */     a a1;
/*     */     Object object;
/*     */     j j1;
/* 425 */     if ((a1 = paramaa.d()) != null && (
/*     */       
/* 427 */       j1 = parame.e()) != null && (
/*     */       
/* 429 */       object = a1.s((b)j1)) != null) {
/*     */       
/* 431 */       paramaa.b();
/*     */       
/*     */       j j2;
/* 434 */       o<?> o = (j2 = (object = paramaa.a((b)parame.e(), object)).b()).q() ? null : paramaa.a(j2, (c)parame);
/* 435 */       return new aj((k<Object, ?>)object, j2, o);
/*     */     } 
/*     */ 
/*     */     
/* 439 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final o<?> a(aa paramaa, c paramc) {
/* 448 */     a a1 = paramaa.d();
/*     */     
/* 450 */     j j1 = (paramc == null || a1 == null) ? null : paramc.e();
/* 451 */     y y = paramaa.c();
/*     */ 
/*     */ 
/*     */     
/* 455 */     l.d d1 = a(paramaa, paramc, this.h);
/* 456 */     l.c c1 = null;
/* 457 */     if (d1 != null && d1.g() && (
/*     */ 
/*     */       
/* 460 */       c1 = d1.c()) != l.c.a && c1 != this.j) {
/* 461 */       if (this.a.h()) {
/* 462 */         n n; switch (e.a[c1.ordinal()]) {
/*     */ 
/*     */           
/*     */           case 1:
/*     */           case 2:
/*     */           case 3:
/* 468 */             y.d(this.a);
/* 469 */             n = n.a(this.a.b(), paramaa
/* 470 */                 .c(), d1);
/* 471 */             return paramaa.a(n, paramc);
/*     */         } 
/*     */       
/* 474 */       } else if (c1 == l.c.b && (
/* 475 */         !this.a.p() || !Map.class.isAssignableFrom(this.h))) {
/*     */         
/* 477 */         if (Map.Entry.class.isAssignableFrom(this.h)) {
/*     */ 
/*     */           
/* 480 */           j j2, j3 = (j2 = this.a.d(Map.Entry.class)).b(0);
/* 481 */           j j4 = j2.b(1);
/*     */ 
/*     */ 
/*     */           
/* 485 */           h h = new h(this.a, j3, j4, false, null, paramc);
/*     */           
/* 487 */           return paramaa.a((o)h, paramc);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 493 */     m m1 = this.g;
/*     */ 
/*     */ 
/*     */     
/* 497 */     int i = 0;
/* 498 */     Set<String> set1 = null;
/* 499 */     Set<String> set2 = null;
/* 500 */     Object object = null;
/*     */ 
/*     */     
/* 503 */     if (j1 != null) {
/* 504 */       set1 = a1.b((b)j1).b();
/* 505 */       set2 = a1.c((b)j1).b();
/*     */       ad ad;
/* 507 */       if ((ad = a1.a((b)j1)) == null) {
/*     */         
/* 509 */         if (m1 != null && (
/*     */           
/* 511 */           ad = a1.a((b)j1, null)) != null) {
/* 512 */           m1 = this.g.a(ad.f());
/*     */ 
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 521 */         Class<am.c> clazz = (ad = a1.a((b)j1, ad)).d();
/* 522 */         j j2 = paramaa.a(clazz);
/* 523 */         paramaa.b(); j j3 = o.c(j2, al.class)[0];
/*     */         
/* 525 */         if (clazz == am.c.class) {
/* 526 */           e e1; String str = ad.b().b();
/*     */ 
/*     */           
/* 529 */           for (int n = 0;; n++) {
/* 530 */             if (n == i)
/* 531 */               paramaa.a(this.a, String.format("Invalid Object Id definition for %s: cannot find property with name %s", new Object[] {
/*     */                       
/* 533 */                       i.g(a()), i.b(str)
/*     */                     })); 
/* 535 */             e e2 = this.c[n];
/* 536 */             if (str.equals(e2.a())) {
/* 537 */               e1 = e2;
/*     */ 
/*     */               
/* 540 */               i = n;
/*     */               break;
/*     */             } 
/*     */           } 
/* 544 */           j3 = e1.c();
/* 545 */           j j4 = new j(ad, e1);
/* 546 */           m m2 = m.a(j3, (w)null, (al)j4, ad.f());
/*     */         } else {
/* 548 */           al al = paramaa.a((b)j1, ad);
/* 549 */           m1 = m.a(j3, ad.b(), al, ad
/* 550 */               .f());
/*     */         } 
/*     */       } 
/*     */       
/*     */       Object object1;
/* 555 */       if ((object1 = a1.d((b)j1)) != null)
/*     */       {
/* 557 */         if (this.f == null || !object1.equals(this.f)) {
/* 558 */           object = object1;
/*     */         }
/*     */       }
/*     */     } 
/*     */     
/* 563 */     d d2 = this;
/*     */ 
/*     */     
/* 566 */     if (i > 0) {
/*     */       
/* 568 */       e arrayOfE2[], arrayOfE1[], e1 = (arrayOfE1 = Arrays.<e>copyOf(this.c, this.c.length))[i];
/* 569 */       System.arraycopy(arrayOfE1, 0, arrayOfE1, 1, i);
/* 570 */       arrayOfE1[0] = e1;
/*     */       
/* 572 */       if (this.d == null) {
/* 573 */         arrayOfE2 = null;
/*     */       } else {
/*     */         
/* 576 */         e1 = (arrayOfE2 = Arrays.<e>copyOf(this.d, this.d.length))[i];
/* 577 */         System.arraycopy(arrayOfE2, 0, arrayOfE2, 1, i);
/* 578 */         arrayOfE2[0] = e1;
/*     */       } 
/* 580 */       d2 = d2.a(arrayOfE1, arrayOfE2);
/*     */     } 
/*     */ 
/*     */     
/* 584 */     o o = paramaa.a(m1.a, paramc);
/*     */     
/* 586 */     if (m1 != null && (m1 = m1.a(o)) != this.g) {
/* 587 */       d2 = d2.a(m1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 592 */     if ((set1 != null && !set1.isEmpty()) || set2 != null)
/*     */     {
/* 594 */       d2 = d2.a(set1, set2);
/*     */     }
/* 596 */     if (object != null) {
/* 597 */       d2 = d2.a(object);
/*     */     }
/*     */     
/* 600 */     if (c1 == null) {
/* 601 */       c1 = this.j;
/*     */     }
/*     */     
/* 604 */     if (c1 == l.c.d) {
/* 605 */       return d2.d();
/*     */     }
/* 607 */     return d2;
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
/*     */   public final boolean b() {
/* 629 */     return (this.g != null);
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
/*     */   public void a(Object paramObject, h paramh, aa paramaa, i parami) {
/* 643 */     if (this.g != null) {
/*     */ 
/*     */ 
/*     */       
/* 647 */       b(paramObject, paramh, paramaa, parami);
/*     */       
/*     */       return;
/*     */     } 
/* 651 */     a a1 = a(parami, paramObject, o.b);
/* 652 */     parami.a(paramh, a1);
/* 653 */     paramh.a(paramObject);
/* 654 */     if (this.f != null) {
/* 655 */       c(paramObject, paramh, paramaa);
/*     */     } else {
/* 657 */       b(paramObject, paramh, paramaa);
/*     */     } 
/* 659 */     parami.b(paramh, a1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void a(Object paramObject, h paramh, aa paramaa, boolean paramBoolean) {
/* 665 */     m m1 = this.g;
/*     */     
/*     */     v v;
/* 668 */     if ((v = paramaa.a(paramObject, m1.c)).a(paramh, paramaa, m1)) {
/*     */       return;
/*     */     }
/*     */     
/* 672 */     Object object = v.a(paramObject);
/* 673 */     if (m1.e) {
/* 674 */       m1.d.a(object, paramh, paramaa);
/*     */       return;
/*     */     } 
/* 677 */     if (paramBoolean) {
/* 678 */       paramh.c(paramObject);
/*     */     }
/* 680 */     v.b(paramh, paramaa, m1);
/* 681 */     if (this.f != null) {
/* 682 */       c(paramObject, paramh, paramaa);
/*     */     } else {
/* 684 */       b(paramObject, paramh, paramaa);
/*     */     } 
/* 686 */     if (paramBoolean) {
/* 687 */       paramh.j();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void b(Object paramObject, h paramh, aa paramaa, i parami) {
/* 694 */     m m1 = this.g;
/*     */     
/*     */     v v;
/* 697 */     if ((v = paramaa.a(paramObject, m1.c)).a(paramh, paramaa, m1)) {
/*     */       return;
/*     */     }
/*     */     
/* 701 */     Object object = v.a(paramObject);
/* 702 */     if (m1.e) {
/* 703 */       m1.d.a(object, paramh, paramaa);
/*     */       return;
/*     */     } 
/* 706 */     a(paramObject, paramh, paramaa, parami, v);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Object paramObject, h paramh, aa paramaa, i parami, v paramv) {
/* 713 */     m m1 = this.g;
/* 714 */     a a1 = a(parami, paramObject, o.b);
/*     */     
/* 716 */     parami.a(paramh, a1);
/*     */     
/* 718 */     paramh.a(paramObject);
/* 719 */     paramv.b(paramh, paramaa, m1);
/* 720 */     if (this.f != null) {
/* 721 */       c(paramObject, paramh, paramaa);
/*     */     } else {
/* 723 */       b(paramObject, paramh, paramaa);
/*     */     } 
/* 725 */     parami.b(paramh, a1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final a a(i parami, Object paramObject, o paramo) {
/* 733 */     if (this.i == null) {
/* 734 */       return parami.a(paramObject, paramo);
/*     */     }
/*     */     Object object;
/* 737 */     if ((object = this.i.b(paramObject)) == null)
/*     */     {
/* 739 */       object = "";
/*     */     }
/* 741 */     return parami.a(paramObject, paramo, object);
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
/*     */   protected final void b(Object paramObject, h paramh, aa paramaa) {
/*     */     e[] arrayOfE;
/* 764 */     if (this.d != null && paramaa.e() != null) {
/* 765 */       arrayOfE = this.d;
/*     */     } else {
/* 767 */       arrayOfE = this.c;
/*     */     } 
/* 769 */     byte b = 0;
/*     */     try {
/* 771 */       for (int i = arrayOfE.length; b < i; b++) {
/*     */         e e1;
/* 773 */         if ((e1 = arrayOfE[b]) != null) {
/* 774 */           e1.a(paramObject, paramh, paramaa);
/*     */         }
/*     */       } 
/* 777 */       if (this.e != null)
/* 778 */         this.e.a(paramObject, paramh, paramaa); 
/*     */       return;
/* 780 */     } catch (Exception exception) {
/* 781 */       String str = (b == arrayOfE.length) ? "[anySetter]" : arrayOfE[b].a();
/* 782 */       a(paramaa, exception, paramObject, str); return;
/* 783 */     } catch (StackOverflowError stackOverflowError) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 789 */       l l = new l((Closeable)paramh, "Infinite recursion (StackOverflowError)", stackOverflowError);
/*     */       
/* 791 */       String str = (b == arrayOfE.length) ? "[anySetter]" : arrayOfE[b].a();
/* 792 */       l.a(paramObject, str);
/* 793 */       throw l;
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
/*     */   protected final void c(Object paramObject, h paramh, aa paramaa) {
/*     */     e[] arrayOfE;
/* 809 */     if (this.d != null && paramaa.e() != null) {
/* 810 */       arrayOfE = this.d;
/*     */     } else {
/* 812 */       arrayOfE = this.c;
/*     */     } 
/*     */     
/*     */     o o;
/* 816 */     if ((o = a(paramaa, this.f, paramObject)) == null) {
/* 817 */       b(paramObject, paramh, paramaa);
/*     */       return;
/*     */     } 
/* 820 */     byte b = 0;
/*     */     try {
/* 822 */       for (int i = arrayOfE.length; b < i; b++) {
/*     */         e e1;
/* 824 */         if ((e1 = arrayOfE[b]) != null) {
/* 825 */           o.a(paramObject, paramh, paramaa, (p)e1);
/*     */         }
/*     */       } 
/* 828 */       if (this.e != null)
/* 829 */         this.e.a(paramObject, paramh, paramaa, o); 
/*     */       return;
/* 831 */     } catch (Exception exception) {
/* 832 */       String str = (b == arrayOfE.length) ? "[anySetter]" : arrayOfE[b].a();
/* 833 */       a(paramaa, exception, paramObject, str); return;
/* 834 */     } catch (StackOverflowError stackOverflowError) {
/*     */ 
/*     */       
/* 837 */       l l = new l((Closeable)paramh, "Infinite recursion (StackOverflowError)", stackOverflowError);
/* 838 */       String str = (b == arrayOfE.length) ? "[anySetter]" : arrayOfE[b].a();
/* 839 */       l.a(paramObject, str);
/* 840 */       throw l;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */