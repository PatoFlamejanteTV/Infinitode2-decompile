/*      */ package com.b.a.a;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.ByteOrder;
/*      */ import java.util.Iterator;
/*      */ import java.util.NoSuchElementException;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class s
/*      */   implements Iterable<s.a>
/*      */ {
/*      */   public static s a(ByteBuffer paramByteBuffer) {
/*   95 */     ByteOrder byteOrder = paramByteBuffer.order(); try {
/*      */       boolean bool;
/*      */       e e;
/*      */       y y;
/*      */       c c1;
/*  100 */       (c1 = new c()).a = paramByteBuffer.getInt();
/*  101 */       switch (c1.a) {
/*      */         case 1416784178:
/*      */           break;
/*      */ 
/*      */         
/*      */         case 845771348:
/*  107 */           bool = (byteOrder == ByteOrder.BIG_ENDIAN) ? true : false;
/*  108 */           paramByteBuffer.order(bool ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
/*  109 */           c1.a = 1416784178;
/*      */           break;
/*      */         default:
/*  112 */           throw new IllegalArgumentException("Buffer does not contain a serialized UTrie2");
/*      */       } 
/*      */       
/*  115 */       c1.b = paramByteBuffer.getChar();
/*  116 */       c1.c = paramByteBuffer.getChar();
/*  117 */       c1.d = paramByteBuffer.getChar();
/*  118 */       c1.e = paramByteBuffer.getChar();
/*  119 */       c1.f = paramByteBuffer.getChar();
/*  120 */       c1.g = paramByteBuffer.getChar();
/*      */ 
/*      */ 
/*      */       
/*  124 */       if ((c1.b & 0xF) > 1) {
/*  125 */         throw new IllegalArgumentException("UTrie2 serialized format error.");
/*      */       }
/*      */ 
/*      */       
/*  129 */       if ((c1.b & 0xF) == 0) {
/*  130 */         e = e.a;
/*  131 */         x x = new x();
/*      */       } else {
/*  133 */         e = e.b;
/*  134 */         y = new y();
/*      */       } 
/*  136 */       y.a = c1;
/*      */ 
/*      */       
/*  139 */       y.e = c1.c;
/*  140 */       y.f = c1.d << 2;
/*  141 */       y.g = c1.e;
/*  142 */       y.l = c1.f;
/*  143 */       y.j = c1.g << 11;
/*  144 */       y.k = y.f - 4;
/*  145 */       if (e == e.a) {
/*  146 */         y.k += y.e;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  152 */       int i = y.e;
/*  153 */       if (e == e.a) {
/*  154 */         i += y.f;
/*      */       }
/*      */ 
/*      */       
/*  158 */       y.b = f.b(paramByteBuffer, i, 0);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  163 */       if (e == e.a) {
/*  164 */         y.c = y.e;
/*      */       } else {
/*  166 */         y.d = f.c(paramByteBuffer, y.f, 0);
/*      */       } 
/*      */       
/*  169 */       switch (u.a[e.ordinal()]) {
/*      */         case 1:
/*  171 */           y.d = null;
/*  172 */           y.h = y.b[y.l];
/*  173 */           y.i = y.b[y.c + 128];
/*      */           break;
/*      */         case 2:
/*  176 */           y.c = 0;
/*  177 */           y.h = y.d[y.l];
/*  178 */           y.i = y.d[128];
/*      */           break;
/*      */         default:
/*  181 */           throw new IllegalArgumentException("UTrie2 serialized format error.");
/*      */       } 
/*      */       
/*  184 */       return y;
/*      */     } finally {
/*  186 */       paramByteBuffer.order(byteOrder);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean equals(Object paramObject) {
/*  288 */     if (!(paramObject instanceof s)) {
/*  289 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  294 */     Iterator<a> iterator = (paramObject = paramObject).iterator();
/*  295 */     for (a a2 : this) {
/*  296 */       if (!iterator.hasNext()) {
/*  297 */         return false;
/*      */       }
/*  299 */       a a1 = iterator.next();
/*  300 */       if (!a2.equals(a1)) {
/*  301 */         return false;
/*      */       }
/*      */     } 
/*  304 */     if (iterator.hasNext()) {
/*  305 */       return false;
/*      */     }
/*      */     
/*  308 */     if (this.i != ((s)paramObject).i || this.h != ((s)paramObject).h)
/*      */     {
/*  310 */       return false;
/*      */     }
/*      */     
/*  313 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/*  319 */     if (this.m == 0) {
/*  320 */       int i = -2128831035;
/*  321 */       for (a a : this) {
/*  322 */         i = f(i, a.hashCode());
/*      */       }
/*  324 */       if (i == 0) {
/*  325 */         i = 1;
/*      */       }
/*  327 */       this.m = i;
/*      */     } 
/*  329 */     return this.m;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class a
/*      */   {
/*      */     public int a;
/*      */ 
/*      */     
/*      */     public int b;
/*      */ 
/*      */     
/*      */     public int c;
/*      */     
/*      */     public boolean d;
/*      */ 
/*      */     
/*      */     public final boolean equals(Object param1Object) {
/*  348 */       if (param1Object == null || !param1Object.getClass().equals(getClass())) {
/*  349 */         return false;
/*      */       }
/*  351 */       param1Object = param1Object;
/*  352 */       return (this.a == ((a)param1Object).a && this.b == ((a)param1Object).b && this.c == ((a)param1Object).c && this.d == ((a)param1Object).d);
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
/*      */     public final int hashCode() {
/*      */       int i;
/*  366 */       return i = s.c(i = s.b(i = s.a(i = s.a(i = s.a(), this.a), this.b), this.c), this.d ? 1 : 0);
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
/*      */   public Iterator<a> iterator() {
/*  380 */     return a(n);
/*      */   }
/*      */   
/*  383 */   private static d n = new t();
/*      */   
/*      */   c a;
/*      */   
/*      */   char[] b;
/*      */   int c;
/*      */   int[] d;
/*      */   int e;
/*      */   int f;
/*      */   int g;
/*      */   int h;
/*      */   int i;
/*      */   int j;
/*      */   int k;
/*      */   int l;
/*      */   int m;
/*      */   
/*      */   private Iterator<a> a(d paramd) {
/*  401 */     return new b(this, paramd);
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
/*      */   public static interface d
/*      */   {
/*      */     int a(int param1Int);
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
/*      */   enum e
/*      */   {
/*  620 */     a,
/*  621 */     b;
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
/*      */   static class c
/*      */   {
/*      */     int a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int e;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int f;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int g;
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
/*      */   class b
/*      */     implements Iterator<a>
/*      */   {
/*      */     private s.d a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private s.a b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean f;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private s.a a() {
/*      */       int i, j;
/*      */       if (!hasNext()) {
/*      */         throw new NoSuchElementException();
/*      */       }
/*      */       if (this.c >= this.d) {
/*      */         this.e = false;
/*      */         this.c = 55296;
/*      */       } 
/*      */       if (this.e) {
/*      */         int k = this.g.a(this.c);
/*      */         j = this.a.a(k);
/*      */         i = this.g.a(this.c, this.d, k);
/*      */         while (i < this.d - 1) {
/*      */           k = this.g.a(i + 1);
/*      */           if (this.a.a(k) == j) {
/*      */             i = this.g.a(i + 1, this.d, k);
/*      */           }
/*      */         } 
/*      */       } else {
/*      */         int k = this.g.a((char)this.c);
/*      */         j = this.a.a(k);
/*      */         i = a((char)this.c);
/*      */         while (i < 56319) {
/*      */           k = this.g.a((char)(i + 1));
/*      */           if (this.a.a(k) == j) {
/*      */             i = a((char)(i + 1));
/*      */           }
/*      */         } 
/*      */       } 
/*      */       this.b.a = this.c;
/*      */       this.b.b = i;
/*      */       this.b.c = j;
/*      */       this.b.d = !this.e;
/*      */       this.c = i + 1;
/*      */       return this.b;
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
/*      */     public final boolean hasNext() {
/*      */       return ((this.e && (this.f || this.c < this.d)) || this.c < 56320);
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
/*      */     public final void remove() {
/*      */       throw new UnsupportedOperationException();
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
/*      */     private int a(char param1Char) {
/*      */       if (param1Char >= '?') {
/*      */         return 56319;
/*      */       }
/*      */       int j = this.g.a(param1Char);
/*      */       int i;
/*      */       for (i = param1Char + 1; i <= 56319 && this.g.a((char)i) == j; i++);
/*      */       return i - 1;
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
/*      */     b(s this$0, s.d param1d) {
/*  986 */       this.b = new s.a();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  995 */       this.e = true;
/*      */ 
/*      */ 
/*      */       
/*  999 */       this.f = true;
/*      */       this.a = param1d;
/*      */       this.c = 0;
/*      */       this.d = 1114112;
/*      */       this.f = true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   int a(int paramInt1, int paramInt2, int paramInt3) {
/* 1011 */     int i = Math.min(this.j, paramInt2);
/*      */     
/* 1013 */     for (; ++paramInt1 < i && 
/* 1014 */       a(paramInt1) == paramInt3; paramInt1++);
/*      */ 
/*      */ 
/*      */     
/* 1018 */     if (paramInt1 >= this.j) {
/* 1019 */       paramInt1 = paramInt2;
/*      */     }
/* 1021 */     return paramInt1 - 1;
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
/*      */   private static int d(int paramInt1, int paramInt2) {
/* 1035 */     return paramInt1 = (paramInt1 = paramInt1 * 16777619) ^ paramInt2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int e(int paramInt1, int paramInt2) {
/* 1042 */     return paramInt1 = d(paramInt1 = d(paramInt1 = d(paramInt1, paramInt2 & 0xFF), paramInt2 >> 8 & 0xFF), paramInt2 >> 16);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int f(int paramInt1, int paramInt2) {
/* 1050 */     return paramInt1 = d(paramInt1 = d(paramInt1 = d(paramInt1 = d(paramInt1, paramInt2 & 0xFF), paramInt2 >> 8 & 0xFF), paramInt2 >> 16 & 0xFF), paramInt2 >>> 24);
/*      */   }
/*      */   
/*      */   public abstract int a(int paramInt);
/*      */   
/*      */   public abstract int a(char paramChar);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\b\a\a\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */