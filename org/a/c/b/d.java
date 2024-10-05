/*      */ package org.a.c.b;
/*      */ 
/*      */ import com.a.a.a.am;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Calendar;
/*      */ import java.util.Collection;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import org.a.c.h.a.c;
/*      */ import org.a.c.i.b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class d
/*      */   extends b
/*      */   implements t
/*      */ {
/*   48 */   protected Map<j, b> a = new LinkedHashMap<j, b>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean a(Object paramObject) {
/*      */     boolean bool;
/*   78 */     if (!(bool = this.a.containsValue(paramObject)) && paramObject instanceof m)
/*      */     {
/*   80 */       bool = this.a.containsValue(((m)paramObject).a());
/*      */     }
/*   82 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final j b(Object paramObject) {
/*   93 */     for (Iterator<Map.Entry> iterator = this.a.entrySet().iterator(); iterator.hasNext();) {
/*      */ 
/*      */       
/*   96 */       if ((m = (m)(entry = iterator.next()).getValue()).equals(paramObject) || (m instanceof m && ((m)m)
/*   97 */         .a()
/*   98 */         .equals(paramObject)))
/*      */       {
/*  100 */         return (j)entry.getKey();
/*      */       }
/*      */     } 
/*  103 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int a() {
/*  113 */     return this.a.size();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void b() {
/*  121 */     this.a.clear();
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
/*      */   public final b a(j paramj1, j paramj2) {
/*      */     b b1;
/*  151 */     if ((b1 = a(paramj1)) == null && paramj2 != null)
/*      */     {
/*  153 */       b1 = a(paramj2);
/*      */     }
/*  155 */     return b1;
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
/*      */   public final b a(j paramj) {
/*      */     b b1;
/*  192 */     if (b1 = this.a.get(paramj) instanceof m)
/*      */     {
/*  194 */       b1 = ((m)b1).a();
/*      */     }
/*  196 */     if (b1 instanceof k)
/*      */     {
/*  198 */       b1 = null;
/*      */     }
/*  200 */     return b1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(j paramj, b paramb) {
/*  211 */     if (paramb == null) {
/*      */       
/*  213 */       m(paramj);
/*      */       
/*      */       return;
/*      */     } 
/*  217 */     this.a.put(paramj, paramb);
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
/*      */   public void a(j paramj, c paramc) {
/*  229 */     b b1 = null;
/*  230 */     if (paramc != null)
/*      */     {
/*  232 */       b1 = paramc.f();
/*      */     }
/*  234 */     a(paramj, b1);
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
/*      */   public void a(String paramString, boolean paramBoolean) {
/*  256 */     a(j.a(paramString), c.b(paramBoolean));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(j paramj, boolean paramBoolean) {
/*  267 */     a(paramj, c.b(paramBoolean));
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
/*      */   public void a(j paramj, String paramString) {
/*  302 */     j j1 = null;
/*  303 */     if (paramString != null)
/*      */     {
/*  305 */       j1 = j.a(paramString);
/*      */     }
/*  307 */     a(paramj, j1);
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
/*      */   public void a(j paramj, Calendar paramCalendar) {
/*  329 */     b(paramj, b.a(paramCalendar));
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
/*      */   public void a(String paramString1, String paramString2) {
/*  374 */     b(j.a(paramString1), paramString2);
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
/*      */   public void b(j paramj, String paramString) {
/*  386 */     s s = null;
/*  387 */     if (paramString != null)
/*      */     {
/*  389 */       s = new s(paramString);
/*      */     }
/*  391 */     a(paramj, s);
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
/*      */   public void a(j paramj, int paramInt) {
/*  448 */     a(paramj, i.a(paramInt));
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
/*      */   public void a(j paramj, long paramLong) {
/*  470 */     i i = i.a(paramLong);
/*  471 */     a(paramj, i);
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
/*      */   public void a(j paramj, float paramFloat) {
/*  523 */     f f = new f(paramFloat);
/*  524 */     a(paramj, f);
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
/*      */   public final void a(j paramj, int paramInt, boolean paramBoolean) {
/*  536 */     int i = b(paramj, 0);
/*  537 */     if (paramBoolean) {
/*      */       
/*  539 */       i |= paramInt;
/*      */     }
/*      */     else {
/*      */       
/*  543 */       i &= paramInt ^ 0xFFFFFFFF;
/*      */     } 
/*  545 */     a(paramj, i);
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
/*      */   public final j b(j paramj) {
/*      */     b b1;
/*  558 */     if (b1 = a(paramj) instanceof j)
/*      */     {
/*  560 */       return (j)b1;
/*      */     }
/*  562 */     return null;
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
/*      */   public final m c(j paramj) {
/*      */     b b1;
/*  575 */     if (b1 = n(paramj) instanceof m)
/*      */     {
/*  577 */       return (m)b1;
/*      */     }
/*  579 */     return null;
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
/*      */   public final d d(j paramj) {
/*      */     b b1;
/*  592 */     if (b1 = a(paramj) instanceof d)
/*      */     {
/*  594 */       return (d)b1;
/*      */     }
/*  596 */     return null;
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
/*      */   public final p e(j paramj) {
/*      */     b b1;
/*  609 */     if (b1 = a(paramj) instanceof p)
/*      */     {
/*  611 */       return (p)b1;
/*      */     }
/*  613 */     return null;
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
/*      */   public final a f(j paramj) {
/*      */     b b1;
/*  626 */     if (b1 = a(paramj) instanceof a)
/*      */     {
/*  628 */       return (a)b1;
/*      */     }
/*  630 */     return null;
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
/*      */   public final j b(j paramj1, j paramj2) {
/*      */     b b1;
/*  644 */     if (b1 = a(paramj1) instanceof j)
/*      */     {
/*  646 */       return (j)b1;
/*      */     }
/*  648 */     return paramj2;
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
/*      */   public final String g(j paramj) {
/*  672 */     String str = null;
/*      */     b b1;
/*  674 */     if (b1 = a(paramj) instanceof j) {
/*      */       
/*  676 */       str = ((j)b1).a();
/*      */     }
/*  678 */     else if (b1 instanceof s) {
/*      */       
/*  680 */       str = ((s)b1).b();
/*      */     } 
/*  682 */     return str;
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
/*      */   public final String h(j paramj) {
/*  737 */     String str = null;
/*      */     b b1;
/*  739 */     if (b1 = a(paramj) instanceof s)
/*      */     {
/*  741 */       str = ((s)b1).b();
/*      */     }
/*  743 */     return str;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Calendar i(j paramj) {
/*      */     b b1;
/*  859 */     if (b1 = a(paramj) instanceof s)
/*      */     {
/*  861 */       return b.a((s)b1);
/*      */     }
/*  863 */     return null;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean b(j paramj, boolean paramBoolean) {
/*  985 */     return a(paramj, (j)null, false);
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
/*      */   private boolean a(j paramj1, j paramj2, boolean paramBoolean) {
/* 1000 */     paramBoolean = paramBoolean;
/*      */     b b1;
/* 1002 */     if (b1 = a(paramj1, paramj2) instanceof c)
/*      */     {
/* 1004 */       paramBoolean = ((c)b1).a();
/*      */     }
/* 1006 */     return paramBoolean;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int a(String paramString) {
/* 1078 */     return b(j.a(paramString), -1);
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
/*      */   public final int j(j paramj) {
/* 1090 */     return b(paramj, -1);
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
/*      */   public final int b(j paramj, int paramInt) {
/* 1138 */     return a(paramj, (j)null, paramInt);
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
/*      */   public final int c(j paramj1, j paramj2) {
/* 1151 */     return a(paramj1, paramj2, -1);
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
/*      */   public final int a(j paramj1, j paramj2, int paramInt) {
/* 1165 */     paramInt = paramInt;
/*      */     b b1;
/* 1167 */     if (b1 = a(paramj1, paramj2) instanceof l)
/*      */     {
/* 1169 */       paramInt = ((l)b1).c();
/*      */     }
/* 1171 */     return paramInt;
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
/*      */   public final long k(j paramj) {
/* 1196 */     return b(paramj, -1L);
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
/*      */   public final long b(j paramj, long paramLong) {
/* 1244 */     long l = -1L;
/*      */     b b1;
/* 1246 */     if (b1 = a(paramj) instanceof l)
/*      */     {
/* 1248 */       l = ((l)b1).b();
/*      */     }
/* 1250 */     return l;
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
/*      */   public final float l(j paramj) {
/* 1274 */     return b(paramj, -1.0F);
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
/*      */   public final float b(j paramj, float paramFloat) {
/* 1300 */     paramFloat = paramFloat;
/*      */     b b1;
/* 1302 */     if (b1 = a(paramj) instanceof l)
/*      */     {
/* 1304 */       paramFloat = ((l)b1).a();
/*      */     }
/* 1306 */     return paramFloat;
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
/*      */   public final boolean c(j paramj, int paramInt) {
/*      */     int i;
/* 1320 */     return (((i = b(paramj, 0)) & paramInt) == paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void m(j paramj) {
/* 1330 */     this.a.remove(paramj);
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
/*      */   public final b n(j paramj) {
/* 1342 */     return this.a.get(paramj);
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
/*      */   public final b d(j paramj1, j paramj2) {
/*      */     b b1;
/* 1370 */     if ((b1 = n(paramj1)) == null && paramj2 != null)
/*      */     {
/* 1372 */       b1 = n(paramj2);
/*      */     }
/* 1374 */     return b1;
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
/*      */   public final Set<j> d() {
/* 1386 */     return this.a.keySet();
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
/*      */   public final Set<Map.Entry<j, b>> e() {
/* 1398 */     return this.a.entrySet();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Collection<b> h() {
/* 1408 */     return this.a.values();
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
/*      */   public Object a(u paramu) {
/* 1422 */     return paramu.a(this);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean c() {
/* 1428 */     return false;
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
/*      */   public void a(d paramd) {
/* 1445 */     for (Iterator<Map.Entry<j, b>> iterator = paramd.e().iterator(); iterator.hasNext();) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1451 */       if (!((j)(entry = iterator.next()).getKey()).a().equals("Size") || 
/* 1452 */         !this.a.containsKey(j.a("Size")))
/*      */       {
/* 1454 */         a(entry.getKey(), (b)entry.getValue());
/*      */       }
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
/*      */   public final boolean o(j paramj) {
/* 1467 */     return this.a.containsKey(paramj);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean b(String paramString) {
/* 1478 */     return o(j.a(paramString));
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
/*      */   public final d i() {
/* 1537 */     return new w(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/*      */     try {
/* 1548 */       return a(this, new ArrayList<b>());
/*      */     }
/* 1550 */     catch (IOException iOException) {
/*      */       
/* 1552 */       return "COSDictionary{" + iOException.getMessage() + "}";
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static String a(b paramb, List<b> paramList) {
/* 1558 */     if (paramb == null)
/*      */     {
/* 1560 */       return "null";
/*      */     }
/* 1562 */     if (paramList.contains(paramb))
/*      */     {
/*      */       
/* 1565 */       return String.valueOf(paramb.hashCode());
/*      */     }
/* 1567 */     paramList.add(paramb);
/* 1568 */     if (paramb instanceof d) {
/*      */       StringBuilder stringBuilder;
/*      */       
/* 1571 */       (stringBuilder = new StringBuilder()).append("COSDictionary{");
/* 1572 */       for (Map.Entry<j, b> entry : ((d)paramb).e()) {
/*      */         
/* 1574 */         stringBuilder.append(entry.getKey());
/* 1575 */         stringBuilder.append(":");
/* 1576 */         stringBuilder.append(a((b)entry.getValue(), paramList));
/* 1577 */         stringBuilder.append(";");
/*      */       } 
/* 1579 */       stringBuilder.append("}");
/* 1580 */       if (paramb instanceof p) {
/*      */         InputStream inputStream;
/*      */         
/* 1583 */         byte[] arrayOfByte = am.a(inputStream = ((p)paramb).j());
/* 1584 */         stringBuilder.append("COSStream{").append(Arrays.hashCode(arrayOfByte)).append("}");
/* 1585 */         inputStream.close();
/*      */       } 
/* 1587 */       return stringBuilder.toString();
/*      */     } 
/* 1589 */     if (paramb instanceof a) {
/*      */       StringBuilder stringBuilder;
/*      */       
/* 1592 */       (stringBuilder = new StringBuilder()).append("COSArray{");
/* 1593 */       for (b b1 : ((a)paramb).e()) {
/*      */         
/* 1595 */         stringBuilder.append(a(b1, paramList));
/* 1596 */         stringBuilder.append(";");
/*      */       } 
/* 1598 */       stringBuilder.append("}");
/* 1599 */       return stringBuilder.toString();
/*      */     } 
/* 1601 */     if (paramb instanceof m) {
/*      */       
/* 1603 */       m m = (m)paramb;
/* 1604 */       return "COSObject{" + a(m.a(), paramList) + "}";
/*      */     } 
/* 1606 */     return paramb.toString();
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */