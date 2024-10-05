/*      */ package com.a.a.c.m;
/*      */ 
/*      */ import com.a.a.b.a.c;
/*      */ import com.a.a.b.c.h;
/*      */ import com.a.a.b.d.f;
/*      */ import com.a.a.b.g.c;
/*      */ import com.a.a.b.g.i;
/*      */ import com.a.a.b.h;
/*      */ import com.a.a.b.j;
/*      */ import com.a.a.b.l;
/*      */ import com.a.a.b.n;
/*      */ import com.a.a.b.o;
/*      */ import com.a.a.b.p;
/*      */ import com.a.a.b.r;
/*      */ import com.a.a.b.s;
/*      */ import com.a.a.b.t;
/*      */ import com.a.a.c.g;
/*      */ import com.a.a.c.i;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.OutputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.util.TreeMap;
/*      */ 
/*      */ public class ac
/*      */   extends h
/*      */ {
/*   29 */   private static int c = h.a.a();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private p d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private n e;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int f;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean g;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean h;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean i;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean j;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private b k;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private b l;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int m;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Object n;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Object o;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean p = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private f q;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ac(l paraml, g paramg) {
/*  172 */     this.d = paraml.a();
/*  173 */     this.e = paraml.d();
/*  174 */     this.f = c;
/*  175 */     this.q = f.b(null);
/*      */     
/*  177 */     this.k = this.l = new b();
/*  178 */     this.m = 0;
/*  179 */     this.g = paraml.T();
/*  180 */     this.h = paraml.S();
/*  181 */     this.i = (this.g || this.h);
/*  182 */     this
/*  183 */       .j = paramg.a(i.a);
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
/*      */   public final l o() {
/*  242 */     return a(this.d);
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
/*      */ 
/*      */   
/*      */   public final l p() {
/*      */     l l;
/*  257 */     (l = a(this.d)).g();
/*  258 */     return l;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private l a(p paramp) {
/*  276 */     return (l)new a(this.k, paramp, this.g, this.h, this.e);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final l c(l paraml) {
/*      */     a a;
/*  286 */     (a = new a(this.k, paraml.a(), this.g, this.h, this.e)).a(paraml.f());
/*  287 */     return (l)a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final o q() {
/*  298 */     return this.k.a(0);
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
/*      */   public final ac a(ac paramac) {
/*  329 */     if (!this.g) {
/*  330 */       this.g = paramac.e();
/*      */     }
/*  332 */     if (!this.h) {
/*  333 */       this.h = paramac.d();
/*      */     }
/*  335 */     this.i = (this.g || this.h);
/*      */     
/*  337 */     l l = paramac.o();
/*  338 */     while (l.g() != null) {
/*  339 */       b(l);
/*      */     }
/*  341 */     return this;
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
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(h paramh) {
/*  356 */     b b1 = this.k;
/*  357 */     byte b2 = -1;
/*      */     
/*      */     boolean bool;
/*  360 */     boolean bool1 = ((bool = this.i) && b1.b()) ? true : false;
/*      */     
/*      */     while (true) {
/*  363 */       if (++b2 >= 16) {
/*  364 */         b2 = 0;
/*      */         
/*  366 */         if ((b1 = b1.a()) != null)
/*  367 */         { bool1 = (bool && b1.b()) ? true : false; }
/*      */         else { break; }
/*      */       
/*  370 */       }  o o; if ((o = b1.a(b2)) != null) {
/*      */         Object object;
/*  372 */         if (bool1) {
/*      */           Object object1;
/*  374 */           if ((object1 = b1.c(b2)) != null) {
/*  375 */             paramh.f(object1);
/*      */           }
/*      */           
/*  378 */           if ((object1 = b1.d(b2)) != null) {
/*  379 */             paramh.g(object1);
/*      */           }
/*      */         } 
/*      */ 
/*      */         
/*  384 */         switch (ad.a[o.ordinal()]) {
/*      */           case 1:
/*  386 */             paramh.i();
/*      */             continue;
/*      */           case 2:
/*  389 */             paramh.j();
/*      */             continue;
/*      */           case 3:
/*  392 */             paramh.g();
/*      */             continue;
/*      */           case 4:
/*  395 */             paramh.h();
/*      */             continue;
/*      */ 
/*      */ 
/*      */           
/*      */           case 5:
/*  401 */             if (object = b1.b(b2) instanceof r) {
/*  402 */               paramh.b((r)object); continue;
/*      */             } 
/*  404 */             paramh.a((String)object);
/*      */             continue;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           case 6:
/*  411 */             if (object = b1.b(b2) instanceof r) {
/*  412 */               paramh.c((r)object); continue;
/*      */             } 
/*  414 */             paramh.b((String)object);
/*      */             continue;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           case 7:
/*  421 */             if (object = b1.b(b2) instanceof Integer) {
/*  422 */               paramh.c(((Integer)object).intValue()); continue;
/*  423 */             }  if (object instanceof BigInteger) {
/*  424 */               paramh.a((BigInteger)object); continue;
/*  425 */             }  if (object instanceof Long) {
/*  426 */               paramh.b(((Long)object).longValue()); continue;
/*  427 */             }  if (object instanceof Short) {
/*  428 */               paramh.a(((Short)object).shortValue()); continue;
/*      */             } 
/*  430 */             paramh.c(((Number)object).intValue());
/*      */             continue;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           case 8:
/*  437 */             if (object = b1.b(b2) instanceof Double) {
/*  438 */               paramh.a(((Double)object).doubleValue()); continue;
/*  439 */             }  if (object instanceof BigDecimal) {
/*  440 */               paramh.a((BigDecimal)object); continue;
/*  441 */             }  if (object instanceof Float) {
/*  442 */               paramh.a(((Float)object).floatValue()); continue;
/*  443 */             }  if (object == null) {
/*  444 */               paramh.k(); continue;
/*  445 */             }  if (object instanceof String) {
/*  446 */               paramh.e((String)object); continue;
/*      */             } 
/*  448 */             f(String.format("Unrecognized value type for VALUE_NUMBER_FLOAT: %s, cannot serialize", new Object[] { object
/*      */                     
/*  450 */                     .getClass().getName() }));
/*      */             continue;
/*      */ 
/*      */           
/*      */           case 9:
/*  455 */             paramh.a(true);
/*      */             continue;
/*      */           case 10:
/*  458 */             paramh.a(false);
/*      */             continue;
/*      */           case 11:
/*  461 */             paramh.k();
/*      */             continue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           case 12:
/*  469 */             if (object = b1.b(b2) instanceof y) {
/*  470 */               ((y)object).a(paramh); continue;
/*  471 */             }  if (object instanceof com.a.a.c.n) {
/*  472 */               paramh.h(object); continue;
/*      */             } 
/*  474 */             paramh.e(object);
/*      */             continue;
/*      */         } 
/*      */ 
/*      */         
/*  479 */         throw new RuntimeException("Internal error: should never end up through this code path");
/*      */       } 
/*      */       break;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ac a(l paraml, g paramg) {
/*  491 */     if (!paraml.a(o.f)) {
/*  492 */       b(paraml);
/*  493 */       return this;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  499 */     i(); o o;
/*      */     do {
/*  501 */       b(paraml);
/*  502 */     } while ((o = paraml.g()) == o.f);
/*  503 */     if (o != o.c) {
/*  504 */       paramg.a(ac.class, o.c, "Expected END_OBJECT after copying contents of a JsonParser into TokenBuffer, got " + o, new Object[0]);
/*      */     }
/*      */ 
/*      */     
/*  508 */     j();
/*  509 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/*      */     StringBuilder stringBuilder;
/*  520 */     (stringBuilder = new StringBuilder()).append("[TokenBuffer: ");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  527 */     l l = o();
/*  528 */     byte b1 = 0;
/*  529 */     boolean bool = (this.g || this.h) ? true : false;
/*      */     
/*      */     while (true) {
/*      */       try {
/*      */         o o;
/*      */         
/*  535 */         if ((o = l.g()) == null)
/*      */           break; 
/*  537 */         if (bool) {
/*  538 */           a(stringBuilder);
/*      */         }
/*      */         
/*  541 */         if (b1 < 100) {
/*  542 */           if (b1 > 0) {
/*  543 */             stringBuilder.append(", ");
/*      */           }
/*  545 */           stringBuilder.append(o.toString());
/*  546 */           if (o == o.f) {
/*  547 */             stringBuilder.append('(');
/*  548 */             stringBuilder.append(l.v());
/*  549 */             stringBuilder.append(')');
/*      */           } 
/*      */         } 
/*  552 */       } catch (IOException iOException) {
/*  553 */         throw new IllegalStateException(iOException);
/*      */       } 
/*  555 */       b1++;
/*      */     } 
/*      */     
/*  558 */     if (b1 >= 100) {
/*  559 */       iOException.append(" ... (truncated ").append(b1 - 100).append(" entries)");
/*      */     }
/*  561 */     iOException.append(']');
/*  562 */     return iOException.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   private final void a(StringBuilder paramStringBuilder) {
/*      */     Object object;
/*  568 */     if ((object = this.l.c(this.m - 1)) != null) {
/*  569 */       paramStringBuilder.append("[objectId=").append(String.valueOf(object)).append(']');
/*      */     }
/*      */     
/*  572 */     if ((object = this.l.d(this.m - 1)) != null) {
/*  573 */       paramStringBuilder.append("[typeId=").append(String.valueOf(object)).append(']');
/*      */     }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final h a(h.a parama) {
/*  591 */     this.f &= parama.b() ^ 0xFFFFFFFF;
/*  592 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean b(h.a parama) {
/*  599 */     return ((this.f & parama.b()) != 0);
/*      */   }
/*      */ 
/*      */   
/*      */   public final int b() {
/*  604 */     return this.f;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public final h a(int paramInt) {
/*  611 */     this.f = paramInt;
/*  612 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public final h a(int paramInt1, int paramInt2) {
/*  617 */     int i = b();
/*  618 */     this.f = i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2;
/*  619 */     return this;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private f r() {
/*  638 */     return this.q;
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
/*      */   
/*      */   public final boolean f() {
/*  651 */     return true;
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
/*      */ 
/*      */   
/*      */   public void flush() {}
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
/*      */   public void close() {}
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
/*      */   public final void g() {
/*  689 */     this.q.n();
/*  690 */     b(o.d);
/*  691 */     this.q = this.q.i();
/*      */   }
/*      */ 
/*      */   
/*      */   public final void b(Object paramObject) {
/*  696 */     this.q.n();
/*  697 */     b(o.d);
/*  698 */     this.q = this.q.b(paramObject);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void a(Object paramObject, int paramInt) {
/*  703 */     this.q.n();
/*  704 */     b(o.d);
/*  705 */     this.q = this.q.b(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void h() {
/*  711 */     c(o.e);
/*      */     
/*      */     f f1;
/*  714 */     if ((f1 = this.q.k()) != null) {
/*  715 */       this.q = f1;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void i() {
/*  722 */     this.q.n();
/*  723 */     b(o.b);
/*  724 */     this.q = this.q.j();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void c(Object paramObject) {
/*  730 */     this.q.n();
/*  731 */     b(o.b);
/*  732 */     paramObject = this.q.c(paramObject);
/*  733 */     this.q = (f)paramObject;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void d(Object paramObject) {
/*  739 */     this.q.n();
/*  740 */     b(o.b);
/*  741 */     paramObject = this.q.c(paramObject);
/*  742 */     this.q = (f)paramObject;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void j() {
/*  748 */     c(o.c);
/*      */     
/*      */     f f1;
/*  751 */     if ((f1 = this.q.k()) != null) {
/*  752 */       this.q = f1;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(String paramString) {
/*  759 */     this.q.a(paramString);
/*  760 */     j(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void b(r paramr) {
/*  766 */     this.q.a(paramr.a());
/*  767 */     j(paramr);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void b(String paramString) {
/*  778 */     if (paramString == null) {
/*  779 */       k(); return;
/*      */     } 
/*  781 */     a(o.h, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  787 */     b(new String(paramArrayOfchar, paramInt1, paramInt2));
/*      */   }
/*      */ 
/*      */   
/*      */   public final void c(r paramr) {
/*  792 */     if (paramr == null) {
/*  793 */       k(); return;
/*      */     } 
/*  795 */     a(o.h, paramr);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void c(String paramString) {
/*  815 */     n();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void d(r paramr) {
/*  825 */     n();
/*      */   }
/*      */ 
/*      */   
/*      */   public final void b(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  830 */     n();
/*      */   }
/*      */ 
/*      */   
/*      */   public final void a(char paramChar) {
/*  835 */     n();
/*      */   }
/*      */ 
/*      */   
/*      */   public final void d(String paramString) {
/*  840 */     a(o.g, new y(paramString));
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
/*      */   public final void a(short paramShort) {
/*  864 */     a(o.i, Short.valueOf(paramShort));
/*      */   }
/*      */ 
/*      */   
/*      */   public final void c(int paramInt) {
/*  869 */     a(o.i, Integer.valueOf(paramInt));
/*      */   }
/*      */ 
/*      */   
/*      */   public final void b(long paramLong) {
/*  874 */     a(o.i, Long.valueOf(paramLong));
/*      */   }
/*      */ 
/*      */   
/*      */   public final void a(double paramDouble) {
/*  879 */     a(o.j, Double.valueOf(paramDouble));
/*      */   }
/*      */ 
/*      */   
/*      */   public final void a(float paramFloat) {
/*  884 */     a(o.j, Float.valueOf(paramFloat));
/*      */   }
/*      */ 
/*      */   
/*      */   public final void a(BigDecimal paramBigDecimal) {
/*  889 */     if (paramBigDecimal == null) {
/*  890 */       k(); return;
/*      */     } 
/*  892 */     a(o.j, paramBigDecimal);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(BigInteger paramBigInteger) {
/*  898 */     if (paramBigInteger == null) {
/*  899 */       k(); return;
/*      */     } 
/*  901 */     a(o.i, paramBigInteger);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void e(String paramString) {
/*  910 */     a(o.j, paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void a(boolean paramBoolean) {
/*  915 */     a(paramBoolean ? o.k : o.l);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void k() {
/*  920 */     a(o.m);
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
/*      */   public final void h(Object paramObject) {
/*  932 */     if (paramObject == null) {
/*  933 */       k();
/*      */       return;
/*      */     } 
/*      */     Class<?> clazz;
/*  937 */     if ((clazz = paramObject.getClass()) == byte[].class || paramObject instanceof y) {
/*  938 */       a(o.g, paramObject);
/*      */       return;
/*      */     } 
/*  941 */     if (this.d == null) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  946 */       a(o.g, paramObject); return;
/*      */     } 
/*  948 */     this.d.a(this, paramObject);
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
/*      */   public final void a(com.a.a.b.a parama, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  983 */     byte[] arrayOfByte = new byte[paramInt2];
/*  984 */     System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte, 0, paramInt2);
/*  985 */     h(arrayOfByte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int a(com.a.a.b.a parama, InputStream paramInputStream, int paramInt) {
/*  996 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean e() {
/* 1007 */     return this.g;
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean d() {
/* 1012 */     return this.h;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void g(Object paramObject) {
/* 1017 */     this.n = paramObject;
/* 1018 */     this.p = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void f(Object paramObject) {
/* 1023 */     this.o = paramObject;
/* 1024 */     this.p = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void e(Object paramObject) {
/* 1029 */     a(o.g, paramObject);
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
/*      */   public final void a(l paraml) {
/* 1041 */     if (this.i) {
/* 1042 */       e(paraml);
/*      */     }
/* 1044 */     switch (ad.a[paraml.k().ordinal()]) {
/*      */       case 1:
/* 1046 */         i();
/*      */         return;
/*      */       case 2:
/* 1049 */         j();
/*      */         return;
/*      */       case 3:
/* 1052 */         g();
/*      */         return;
/*      */       case 4:
/* 1055 */         h();
/*      */         return;
/*      */       case 5:
/* 1058 */         a(paraml.v());
/*      */         return;
/*      */       case 6:
/* 1061 */         if (paraml.A()) {
/* 1062 */           a(paraml.x(), paraml.z(), paraml.y()); return;
/*      */         } 
/* 1064 */         b(paraml.w());
/*      */         return;
/*      */       
/*      */       case 7:
/* 1068 */         switch (ad.b[paraml.D().ordinal()]) {
/*      */           case 1:
/* 1070 */             c(paraml.G());
/*      */             return;
/*      */           case 2:
/* 1073 */             a(paraml.I());
/*      */             return;
/*      */         } 
/* 1076 */         b(paraml.H());
/*      */         return;
/*      */       
/*      */       case 8:
/* 1080 */         if (this.j) {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1085 */           a(paraml.L()); return;
/*      */         } 
/* 1087 */         switch (ad.b[paraml.D().ordinal()]) {
/*      */           case 3:
/* 1089 */             a(paraml.L());
/*      */             return;
/*      */           case 4:
/* 1092 */             a(paraml.J());
/*      */             return;
/*      */         } 
/* 1095 */         a(paraml.K());
/*      */         return;
/*      */ 
/*      */       
/*      */       case 9:
/* 1100 */         a(true);
/*      */         return;
/*      */       case 10:
/* 1103 */         a(false);
/*      */         return;
/*      */       case 11:
/* 1106 */         k();
/*      */         return;
/*      */       case 12:
/* 1109 */         h(paraml.N());
/*      */         return;
/*      */     } 
/* 1112 */     throw new RuntimeException("Internal error: unexpected token: " + paraml.k());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void b(l paraml) {
/*      */     o o;
/* 1122 */     if ((o = paraml.k()) == o.f) {
/* 1123 */       if (this.i) {
/* 1124 */         e(paraml);
/*      */       }
/* 1126 */       a(paraml.v());
/* 1127 */       o = paraml.g();
/*      */     }
/* 1129 */     else if (o == null) {
/* 1130 */       throw new IllegalStateException("No token available from argument `JsonParser`");
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1136 */     switch (ad.a[o.ordinal()]) {
/*      */       case 3:
/* 1138 */         if (this.i) {
/* 1139 */           e(paraml);
/*      */         }
/* 1141 */         g();
/* 1142 */         d(paraml);
/*      */         return;
/*      */       case 1:
/* 1145 */         if (this.i) {
/* 1146 */           e(paraml);
/*      */         }
/* 1148 */         i();
/* 1149 */         d(paraml);
/*      */         return;
/*      */       case 4:
/* 1152 */         h();
/*      */         return;
/*      */       case 2:
/* 1155 */         j();
/*      */         return;
/*      */     } 
/* 1158 */     a(paraml, o);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void d(l paraml) {
/* 1164 */     byte b1 = 1;
/*      */     
/*      */     o o;
/* 1167 */     while ((o = paraml.g()) != null) {
/* 1168 */       switch (ad.a[o.ordinal()]) {
/*      */         case 5:
/* 1170 */           if (this.i) {
/* 1171 */             e(paraml);
/*      */           }
/* 1173 */           a(paraml.v());
/*      */           continue;
/*      */         
/*      */         case 3:
/* 1177 */           if (this.i) {
/* 1178 */             e(paraml);
/*      */           }
/* 1180 */           g();
/* 1181 */           b1++;
/*      */           continue;
/*      */         
/*      */         case 1:
/* 1185 */           if (this.i) {
/* 1186 */             e(paraml);
/*      */           }
/* 1188 */           i();
/* 1189 */           b1++;
/*      */           continue;
/*      */         
/*      */         case 4:
/* 1193 */           h();
/* 1194 */           if (--b1 == 0) {
/*      */             return;
/*      */           }
/*      */           continue;
/*      */         case 2:
/* 1199 */           j();
/* 1200 */           if (--b1 == 0) {
/*      */             return;
/*      */           }
/*      */           continue;
/*      */       } 
/*      */       
/* 1206 */       a(paraml, o);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(l paraml, o paramo) {
/*      */     Number number;
/* 1214 */     if (this.i) {
/* 1215 */       e(paraml);
/*      */     }
/* 1217 */     switch (ad.a[paramo.ordinal()]) {
/*      */       case 6:
/* 1219 */         if (paraml.A()) {
/* 1220 */           a(paraml.x(), paraml.z(), paraml.y()); return;
/*      */         } 
/* 1222 */         b(paraml.w());
/*      */         return;
/*      */       
/*      */       case 7:
/* 1226 */         switch (ad.b[paraml.D().ordinal()]) {
/*      */           case 1:
/* 1228 */             c(paraml.G());
/*      */             return;
/*      */           case 2:
/* 1231 */             a(paraml.I());
/*      */             return;
/*      */         } 
/* 1234 */         b(paraml.H());
/*      */         return;
/*      */       
/*      */       case 8:
/* 1238 */         if (this.j) {
/* 1239 */           a(paraml.L());
/*      */           
/*      */           return;
/*      */         } 
/* 1243 */         number = paraml.C();
/* 1244 */         a(o.j, number);
/*      */         return;
/*      */       
/*      */       case 9:
/* 1248 */         a(true);
/*      */         return;
/*      */       case 10:
/* 1251 */         a(false);
/*      */         return;
/*      */       case 11:
/* 1254 */         k();
/*      */         return;
/*      */       case 12:
/* 1257 */         h(number.N());
/*      */         return;
/*      */     } 
/* 1260 */     throw new RuntimeException("Internal error: unexpected token: " + paramo);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private final void e(l paraml) {
/* 1266 */     if ((this.n = paraml.V()) != null) {
/* 1267 */       this.p = true;
/*      */     }
/* 1269 */     if ((this.o = paraml.U()) != null) {
/* 1270 */       this.p = true;
/*      */     }
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
/*      */   private void a(o paramo) {
/*      */     b b1;
/* 1323 */     this.q.n();
/*      */     
/* 1325 */     if (this.p) {
/* 1326 */       b1 = this.l.a(this.m, paramo, this.o, this.n);
/*      */     } else {
/* 1328 */       b1 = this.l.a(this.m, (o)b1);
/*      */     } 
/* 1330 */     if (b1 == null) {
/* 1331 */       this.m++; return;
/*      */     } 
/* 1333 */     this.l = b1;
/* 1334 */     this.m = 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(o paramo, Object paramObject) {
/*      */     b b1;
/* 1346 */     this.q.n();
/*      */     
/* 1348 */     if (this.p) {
/* 1349 */       b1 = this.l.a(this.m, paramo, paramObject, this.o, this.n);
/*      */     } else {
/* 1351 */       b1 = this.l.a(this.m, (o)b1, paramObject);
/*      */     } 
/* 1353 */     if (b1 == null) {
/* 1354 */       this.m++; return;
/*      */     } 
/* 1356 */     this.l = b1;
/* 1357 */     this.m = 1;
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
/*      */ 
/*      */   
/*      */   private void j(Object paramObject) {
/* 1371 */     if (this.p) {
/* 1372 */       paramObject = this.l.a(this.m, o.f, paramObject, this.o, this.n);
/*      */     } else {
/* 1374 */       paramObject = this.l.a(this.m, o.f, paramObject);
/*      */     } 
/* 1376 */     if (paramObject == null) {
/* 1377 */       this.m++; return;
/*      */     } 
/* 1379 */     this.l = (b)paramObject;
/* 1380 */     this.m = 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(o paramo) {
/*      */     b b1;
/* 1392 */     if (this.p) {
/* 1393 */       b1 = this.l.a(this.m, paramo, this.o, this.n);
/*      */     } else {
/* 1395 */       b1 = this.l.a(this.m, (o)b1);
/*      */     } 
/* 1397 */     if (b1 == null) {
/* 1398 */       this.m++; return;
/*      */     } 
/* 1400 */     this.l = b1;
/* 1401 */     this.m = 1;
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
/*      */   private void c(o paramo) {
/*      */     b b1;
/* 1414 */     if ((b1 = this.l.a(this.m, paramo)) == null) {
/* 1415 */       this.m++; return;
/*      */     } 
/* 1417 */     this.l = b1;
/* 1418 */     this.m = 1;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void n() {
/* 1424 */     throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static final class a
/*      */     extends c
/*      */   {
/*      */     private p c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean e;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private ac.b f;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int g;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private ae h;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean i;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private transient c j;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1482 */     private j k = null;
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
/*      */     public a(ac.b param1b, p param1p, boolean param1Boolean1, boolean param1Boolean2, n param1n) {
/* 1505 */       this.f = param1b;
/* 1506 */       this.g = -1;
/* 1507 */       this.c = param1p;
/* 1508 */       this.h = ae.a(param1n);
/* 1509 */       this.d = param1Boolean1;
/* 1510 */       this.e = param1Boolean2;
/*      */     }
/*      */ 
/*      */     
/*      */     public final void a(j param1j) {
/* 1515 */       this.k = param1j;
/*      */     }
/*      */     
/*      */     public final p a() {
/* 1519 */       return this.c;
/*      */     }
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
/*      */     public final i<s> c() {
/* 1541 */       return a;
/*      */     }
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
/*      */     public final void close() {
/* 1571 */       if (!this.i) {
/* 1572 */         this.i = true;
/*      */       }
/*      */     }
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
/*      */     public final o g() {
/* 1586 */       if (this.i || this.f == null) return null;
/*      */ 
/*      */       
/* 1589 */       if (++this.g >= 16) {
/* 1590 */         this.g = 0;
/* 1591 */         this.f = this.f.a();
/* 1592 */         if (this.f == null) {
/* 1593 */           return null;
/*      */         }
/*      */       } 
/* 1596 */       this.D = this.f.a(this.g);
/*      */       
/* 1598 */       if (this.D == o.f) {
/*      */         
/* 1600 */         Object object = (object = W() instanceof String) ? object : object.toString();
/* 1601 */         this.h.a((String)object);
/* 1602 */       } else if (this.D == o.b) {
/* 1603 */         this.h = this.h.j();
/* 1604 */       } else if (this.D == o.d) {
/* 1605 */         this.h = this.h.i();
/* 1606 */       } else if (this.D == o.c || this.D == o.e) {
/*      */ 
/*      */         
/* 1609 */         this.h = this.h.k();
/*      */       } else {
/* 1611 */         this.h.l();
/*      */       } 
/* 1613 */       return this.D;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final String h() {
/* 1620 */       if (this.i || this.f == null) {
/* 1621 */         return null;
/*      */       }
/*      */       
/*      */       int i;
/* 1625 */       if ((i = this.g + 1) < 16 && this.f.a(i) == o.f) {
/* 1626 */         this.g = i;
/* 1627 */         this.D = o.f;
/*      */         
/* 1629 */         Object object = (object = this.f.b(i) instanceof String) ? object : object.toString();
/* 1630 */         this.h.a((String)object);
/* 1631 */         return (String)object;
/*      */       } 
/* 1633 */       return (g() == o.f) ? v() : null;
/*      */     }
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
/*      */     public final n d() {
/* 1646 */       return this.h;
/*      */     }
/*      */     public final j f() {
/* 1649 */       return e();
/*      */     }
/*      */     
/*      */     public final j e() {
/* 1653 */       return (this.k == null) ? j.a : this.k;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final String v() {
/* 1659 */       if (this.D == o.b || this.D == o.d) {
/*      */         n n;
/* 1661 */         return (n = this.h.a()).g();
/*      */       } 
/* 1663 */       return this.h.g();
/*      */     }
/*      */     
/*      */     public final String u() {
/* 1667 */       return v();
/*      */     }
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
/*      */     public final String w() {
/* 1696 */       if (this.D == o.h || this.D == o.f) {
/*      */         Object object;
/*      */         
/* 1699 */         if (object = W() instanceof String) {
/* 1700 */           return (String)object;
/*      */         }
/* 1702 */         return i.b(object);
/*      */       } 
/* 1704 */       if (this.D == null) {
/* 1705 */         return null;
/*      */       }
/* 1707 */       switch (ad.a[this.D.ordinal()]) {
/*      */         case 7:
/*      */         case 8:
/* 1710 */           return i.b(W());
/*      */       } 
/* 1712 */       return this.D.b();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final char[] x() {
/*      */       String str;
/* 1719 */       return ((str = w()) == null) ? null : str.toCharArray();
/*      */     }
/*      */ 
/*      */     
/*      */     public final int y() {
/*      */       String str;
/* 1725 */       return ((str = w()) == null) ? 0 : str.length();
/*      */     }
/*      */     
/*      */     public final int z() {
/* 1729 */       return 0;
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean A() {
/* 1734 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final boolean s() {
/* 1746 */       if (this.D == o.j) {
/*      */         Object object;
/* 1748 */         if (object = W() instanceof Double) {
/*      */           
/* 1750 */           if ((object = object).isNaN() || object.isInfinite()) return true;  return false;
/*      */         } 
/* 1752 */         if (object instanceof Float) {
/*      */           
/* 1754 */           if ((object = object).isNaN() || object.isInfinite()) return true;  return false;
/*      */         } 
/*      */       } 
/* 1757 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final BigInteger I() {
/*      */       Number number;
/* 1764 */       if (number = B() instanceof BigInteger) {
/* 1765 */         return (BigInteger)number;
/*      */       }
/* 1767 */       if (D() == l.b.f) {
/* 1768 */         return ((BigDecimal)number).toBigInteger();
/*      */       }
/*      */       
/* 1771 */       return BigInteger.valueOf(number.longValue());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final BigDecimal L() {
/*      */       Number number;
/* 1778 */       if (number = B() instanceof BigDecimal) {
/* 1779 */         return (BigDecimal)number;
/*      */       }
/* 1781 */       switch (ad.b[D().ordinal()]) {
/*      */         case 1:
/*      */         case 5:
/* 1784 */           return BigDecimal.valueOf(number.longValue());
/*      */         case 2:
/* 1786 */           return new BigDecimal((BigInteger)number);
/*      */       } 
/*      */ 
/*      */       
/* 1790 */       return BigDecimal.valueOf(number.doubleValue());
/*      */     }
/*      */ 
/*      */     
/*      */     public final double K() {
/* 1795 */       return B().doubleValue();
/*      */     }
/*      */ 
/*      */     
/*      */     public final float J() {
/* 1800 */       return B().floatValue();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final int G() {
/*      */       Number number;
/* 1808 */       if (number = (this.D == o.i) ? (Number)W() : B() instanceof Integer || a(number)) {
/* 1809 */         return number.intValue();
/*      */       }
/* 1811 */       return c(number);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final long H() {
/*      */       Number number;
/* 1818 */       if (number = (this.D == o.i) ? (Number)W() : B() instanceof Long || b(number)) {
/* 1819 */         return number.longValue();
/*      */       }
/* 1821 */       return d(number);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final l.b D() {
/*      */       Number number;
/* 1828 */       if (number = B() instanceof Integer) return l.b.a; 
/* 1829 */       if (number instanceof Long) return l.b.b; 
/* 1830 */       if (number instanceof Double) return l.b.e; 
/* 1831 */       if (number instanceof BigDecimal) return l.b.f; 
/* 1832 */       if (number instanceof BigInteger) return l.b.c; 
/* 1833 */       if (number instanceof Float) return l.b.d; 
/* 1834 */       if (number instanceof Short) return l.b.a; 
/* 1835 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public final Number B() {
/* 1840 */       X();
/*      */       Object object;
/* 1842 */       if (object = W() instanceof Number) {
/* 1843 */         return (Number)object;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1848 */       if (object instanceof String) {
/*      */         
/* 1850 */         if ((object = object).indexOf('.') >= 0) {
/* 1851 */           return Double.valueOf(h.b((String)object, a(t.a)));
/*      */         }
/* 1853 */         return Long.valueOf(h.b((String)object));
/*      */       } 
/* 1855 */       if (object == null) {
/* 1856 */         return null;
/*      */       }
/* 1858 */       throw new IllegalStateException("Internal error: entry should be a Number, but is of type " + object
/* 1859 */           .getClass().getName());
/*      */     }
/*      */     
/*      */     private static boolean a(Number param1Number) {
/* 1863 */       return (param1Number instanceof Short || param1Number instanceof Byte);
/*      */     }
/*      */     
/*      */     private static boolean b(Number param1Number) {
/* 1867 */       return (param1Number instanceof Integer || param1Number instanceof Short || param1Number instanceof Byte);
/*      */     }
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
/*      */     private int c(Number param1Number) {
/*      */       // Byte code:
/*      */       //   0: aload_1
/*      */       //   1: instanceof java/lang/Long
/*      */       //   4: ifeq -> 28
/*      */       //   7: aload_1
/*      */       //   8: invokevirtual longValue : ()J
/*      */       //   11: dup2
/*      */       //   12: lstore_2
/*      */       //   13: l2i
/*      */       //   14: dup
/*      */       //   15: istore_1
/*      */       //   16: i2l
/*      */       //   17: lload_2
/*      */       //   18: lcmp
/*      */       //   19: ifeq -> 26
/*      */       //   22: aload_0
/*      */       //   23: invokevirtual ai : ()V
/*      */       //   26: iload_1
/*      */       //   27: ireturn
/*      */       //   28: aload_1
/*      */       //   29: instanceof java/math/BigInteger
/*      */       //   32: ifeq -> 67
/*      */       //   35: aload_1
/*      */       //   36: checkcast java/math/BigInteger
/*      */       //   39: astore_2
/*      */       //   40: getstatic com/a/a/c/m/ac$a.v : Ljava/math/BigInteger;
/*      */       //   43: aload_2
/*      */       //   44: invokevirtual compareTo : (Ljava/math/BigInteger;)I
/*      */       //   47: ifgt -> 60
/*      */       //   50: getstatic com/a/a/c/m/ac$a.w : Ljava/math/BigInteger;
/*      */       //   53: aload_2
/*      */       //   54: invokevirtual compareTo : (Ljava/math/BigInteger;)I
/*      */       //   57: ifge -> 64
/*      */       //   60: aload_0
/*      */       //   61: invokevirtual ai : ()V
/*      */       //   64: goto -> 151
/*      */       //   67: aload_1
/*      */       //   68: instanceof java/lang/Double
/*      */       //   71: ifne -> 81
/*      */       //   74: aload_1
/*      */       //   75: instanceof java/lang/Float
/*      */       //   78: ifeq -> 109
/*      */       //   81: aload_1
/*      */       //   82: invokevirtual doubleValue : ()D
/*      */       //   85: dup2
/*      */       //   86: dstore_2
/*      */       //   87: ldc2_w -2.147483648E9
/*      */       //   90: dcmpg
/*      */       //   91: iflt -> 102
/*      */       //   94: dload_2
/*      */       //   95: ldc2_w 2.147483647E9
/*      */       //   98: dcmpl
/*      */       //   99: ifle -> 106
/*      */       //   102: aload_0
/*      */       //   103: invokevirtual ai : ()V
/*      */       //   106: dload_2
/*      */       //   107: d2i
/*      */       //   108: ireturn
/*      */       //   109: aload_1
/*      */       //   110: instanceof java/math/BigDecimal
/*      */       //   113: ifeq -> 148
/*      */       //   116: aload_1
/*      */       //   117: checkcast java/math/BigDecimal
/*      */       //   120: astore_2
/*      */       //   121: getstatic com/a/a/c/m/ac$a.B : Ljava/math/BigDecimal;
/*      */       //   124: aload_2
/*      */       //   125: invokevirtual compareTo : (Ljava/math/BigDecimal;)I
/*      */       //   128: ifgt -> 141
/*      */       //   131: getstatic com/a/a/c/m/ac$a.C : Ljava/math/BigDecimal;
/*      */       //   134: aload_2
/*      */       //   135: invokevirtual compareTo : (Ljava/math/BigDecimal;)I
/*      */       //   138: ifge -> 145
/*      */       //   141: aload_0
/*      */       //   142: invokevirtual ai : ()V
/*      */       //   145: goto -> 151
/*      */       //   148: invokestatic al : ()V
/*      */       //   151: aload_1
/*      */       //   152: invokevirtual intValue : ()I
/*      */       //   155: ireturn
/*      */       // Line number table:
/*      */       //   Java source line number -> byte code offset
/*      */       //   #1874	-> 0
/*      */       //   #1875	-> 7
/*      */       //   #1876	-> 12
/*      */       //   #1877	-> 15
/*      */       //   #1878	-> 22
/*      */       //   #1880	-> 26
/*      */       //   #1882	-> 28
/*      */       //   #1883	-> 35
/*      */       //   #1884	-> 40
/*      */       //   #1885	-> 54
/*      */       //   #1886	-> 60
/*      */       //   #1888	-> 64
/*      */       //   #1889	-> 81
/*      */       //   #1891	-> 86
/*      */       //   #1892	-> 102
/*      */       //   #1894	-> 106
/*      */       //   #1895	-> 109
/*      */       //   #1896	-> 116
/*      */       //   #1897	-> 121
/*      */       //   #1898	-> 135
/*      */       //   #1899	-> 141
/*      */       //   #1901	-> 145
/*      */       //   #1902	-> 148
/*      */       //   #1904	-> 151
/*      */     }
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
/*      */     private long d(Number param1Number) {
/* 1909 */       if (param1Number instanceof BigInteger) {
/* 1910 */         BigInteger bigInteger = (BigInteger)param1Number;
/* 1911 */         if (x.compareTo(bigInteger) > 0 || y
/* 1912 */           .compareTo(bigInteger) < 0)
/* 1913 */           aj(); 
/*      */       } else {
/* 1915 */         if (param1Number instanceof Double || param1Number instanceof Float) {
/*      */           double d;
/*      */           
/* 1918 */           if ((d = param1Number.doubleValue()) < -9.223372036854776E18D || d > 9.223372036854776E18D) {
/* 1919 */             aj();
/*      */           }
/* 1921 */           return (long)d;
/* 1922 */         }  if (param1Number instanceof BigDecimal) {
/* 1923 */           BigDecimal bigDecimal = (BigDecimal)param1Number;
/* 1924 */           if (z.compareTo(bigDecimal) > 0 || A
/* 1925 */             .compareTo(bigDecimal) < 0) {
/* 1926 */             aj();
/*      */           }
/*      */         } else {
/* 1929 */           al();
/*      */         } 
/* 1931 */       }  return param1Number.longValue();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final Object N() {
/* 1943 */       if (this.D == o.g) {
/* 1944 */         return W();
/*      */       }
/* 1946 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final byte[] a(com.a.a.b.a param1a) {
/* 1954 */       if (this.D == o.g) {
/*      */         Object object;
/*      */         
/* 1957 */         if (object = W() instanceof byte[]) {
/* 1958 */           return (byte[])object;
/*      */         }
/*      */       } 
/*      */       
/* 1962 */       if (this.D != o.h) {
/* 1963 */         throw b("Current token (" + this.D + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), cannot access as binary");
/*      */       }
/*      */       String str;
/* 1966 */       if ((str = w()) == null) {
/* 1967 */         return null;
/*      */       }
/*      */       c c1;
/* 1970 */       if ((c1 = this.j) == null) {
/* 1971 */         this.j = c1 = new c(100);
/*      */       } else {
/* 1973 */         this.j.a();
/*      */       } 
/* 1975 */       a(str, c1, param1a);
/* 1976 */       return c1.b();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final int a(com.a.a.b.a param1a, OutputStream param1OutputStream) {
/*      */       byte[] arrayOfByte;
/* 1983 */       if ((arrayOfByte = a(param1a)) != null) {
/* 1984 */         param1OutputStream.write(arrayOfByte, 0, arrayOfByte.length);
/* 1985 */         return arrayOfByte.length;
/*      */       } 
/* 1987 */       return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final boolean S() {
/* 1998 */       return this.e;
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean T() {
/* 2003 */       return this.d;
/*      */     }
/*      */ 
/*      */     
/*      */     public final Object V() {
/* 2008 */       return this.f.d(this.g);
/*      */     }
/*      */ 
/*      */     
/*      */     public final Object U() {
/* 2013 */       return this.f.c(this.g);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object W() {
/* 2023 */       return this.f.b(this.g);
/*      */     }
/*      */ 
/*      */     
/*      */     private void X() {
/* 2028 */       if (this.D == null || !this.D.d()) {
/* 2029 */         throw b("Current token (" + this.D + ") not numeric, cannot use numeric value accessors");
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     protected final void Y() {
/* 2035 */       al();
/*      */     }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static final class b
/*      */   {
/* 2057 */     private static final o[] a = new o[16]; private b b; private long c;
/*      */     static {
/*      */       o[] arrayOfO;
/* 2060 */       System.arraycopy(arrayOfO = o.values(), 1, a, 1, Math.min(15, arrayOfO.length - 1));
/*      */     }
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
/* 2078 */     private Object[] d = new Object[16];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private TreeMap<Integer, Object> e;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final o a(int param1Int) {
/* 2091 */       long l = this.c;
/* 2092 */       if (param1Int > 0) {
/* 2093 */         l >>= param1Int << 2;
/*      */       }
/* 2095 */       param1Int = (int)l & 0xF;
/* 2096 */       return a[param1Int];
/*      */     }
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
/*      */     public final Object b(int param1Int) {
/* 2110 */       return this.d[param1Int];
/*      */     }
/*      */     public final b a() {
/* 2113 */       return this.b;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final boolean b() {
/* 2120 */       return (this.e != null);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final b a(int param1Int, o param1o) {
/* 2127 */       if (param1Int < 16) {
/* 2128 */         b(param1Int, param1o);
/* 2129 */         return null;
/*      */       } 
/* 2131 */       this.b = new b();
/* 2132 */       this.b.b(0, param1o);
/* 2133 */       return this.b;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final b a(int param1Int, o param1o, Object param1Object1, Object param1Object2) {
/* 2139 */       if (param1Int < 16) {
/* 2140 */         b(param1Int, param1o, param1Object1, param1Object2);
/* 2141 */         return null;
/*      */       } 
/* 2143 */       this.b = new b();
/* 2144 */       this.b.b(0, param1o, param1Object1, param1Object2);
/* 2145 */       return this.b;
/*      */     }
/*      */ 
/*      */     
/*      */     public final b a(int param1Int, o param1o, Object param1Object) {
/* 2150 */       if (param1Int < 16) {
/* 2151 */         b(param1Int, param1o, param1Object);
/* 2152 */         return null;
/*      */       } 
/* 2154 */       this.b = new b();
/* 2155 */       this.b.b(0, param1o, param1Object);
/* 2156 */       return this.b;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final b a(int param1Int, o param1o, Object param1Object1, Object param1Object2, Object param1Object3) {
/* 2162 */       if (param1Int < 16) {
/* 2163 */         b(param1Int, param1o, param1Object1, param1Object2, param1Object3);
/* 2164 */         return null;
/*      */       } 
/* 2166 */       this.b = new b();
/* 2167 */       this.b.b(0, param1o, param1Object1, param1Object2, param1Object3);
/* 2168 */       return this.b;
/*      */     }
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
/*      */     private void b(int param1Int, o param1o) {
/* 2222 */       long l = param1o.ordinal();
/* 2223 */       if (param1Int > 0) {
/* 2224 */         l <<= param1Int << 2;
/*      */       }
/* 2226 */       this.c |= l;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private void b(int param1Int, o param1o, Object param1Object1, Object param1Object2) {
/* 2232 */       long l = param1o.ordinal();
/* 2233 */       if (param1Int > 0) {
/* 2234 */         l <<= param1Int << 2;
/*      */       }
/* 2236 */       this.c |= l;
/* 2237 */       a(param1Int, param1Object1, param1Object2);
/*      */     }
/*      */ 
/*      */     
/*      */     private void b(int param1Int, o param1o, Object param1Object) {
/* 2242 */       this.d[param1Int] = param1Object;
/* 2243 */       long l = param1o.ordinal();
/* 2244 */       if (param1Int > 0) {
/* 2245 */         l <<= param1Int << 2;
/*      */       }
/* 2247 */       this.c |= l;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private void b(int param1Int, o param1o, Object param1Object1, Object param1Object2, Object param1Object3) {
/* 2253 */       this.d[param1Int] = param1Object1;
/* 2254 */       long l = param1o.ordinal();
/* 2255 */       if (param1Int > 0) {
/* 2256 */         l <<= param1Int << 2;
/*      */       }
/* 2258 */       this.c |= l;
/* 2259 */       a(param1Int, param1Object2, param1Object3);
/*      */     }
/*      */ 
/*      */     
/*      */     private final void a(int param1Int, Object param1Object1, Object param1Object2) {
/* 2264 */       if (this.e == null) {
/* 2265 */         this.e = new TreeMap<>();
/*      */       }
/* 2267 */       if (param1Object1 != null) {
/* 2268 */         this.e.put(Integer.valueOf(f(param1Int)), param1Object1);
/*      */       }
/* 2270 */       if (param1Object2 != null) {
/* 2271 */         this.e.put(Integer.valueOf(e(param1Int)), param1Object2);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final Object c(int param1Int) {
/* 2279 */       return (this.e == null) ? null : this.e.get(Integer.valueOf(f(param1Int)));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final Object d(int param1Int) {
/* 2286 */       return (this.e == null) ? null : this.e.get(Integer.valueOf(e(param1Int)));
/*      */     }
/*      */     
/* 2289 */     private static int e(int param1Int) { return param1Int + param1Int; } private static int f(int param1Int) {
/* 2290 */       return param1Int + param1Int + 1;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\ac.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */