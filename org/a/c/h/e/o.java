/*     */ package org.a.c.h.e;
/*     */ 
/*     */ import com.a.a.a.am;
/*     */ import java.io.Closeable;
/*     */ import java.io.InputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.a.b.h.a;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.g;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.l;
/*     */ import org.a.c.b.p;
/*     */ import org.a.c.h.a.c;
/*     */ import org.a.c.i.d;
/*     */ import org.a.c.i.f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class o
/*     */   implements c
/*     */ {
/*     */   protected final ac a;
/*     */   private Map<Integer, Float> b;
/*     */   private float c;
/*  52 */   private final Map<Integer, Float> d = new HashMap<Integer, Float>();
/*  53 */   private final Map<Integer, f> e = new HashMap<Integer, f>();
/*  54 */   private float[] f = new float[] { 880.0F, -1000.0F };
/*     */ 
/*     */ 
/*     */   
/*     */   private d g;
/*     */ 
/*     */   
/*     */   private v h;
/*     */ 
/*     */ 
/*     */   
/*     */   o(d paramd, ac paramac) {
/*  66 */     this.g = paramd;
/*  67 */     this.a = paramac;
/*  68 */     j();
/*  69 */     k();
/*     */   }
/*     */ 
/*     */   
/*     */   private void j() {
/*  74 */     this.b = new HashMap<Integer, Float>();
/*     */     b b;
/*  76 */     if (b = this.g.a(j.dX) instanceof a) {
/*     */       a a;
/*     */       
/*  79 */       int i = (a = (a)b).b();
/*  80 */       byte b1 = 0;
/*  81 */       while (b1 < i) {
/*     */         a a1;
/*  83 */         l l1 = (l)a.a(b1++);
/*     */         b b2;
/*  85 */         if (b2 = a.a(b1++) instanceof a) {
/*     */           
/*  87 */           a1 = (a)b2;
/*  88 */           int m = l1.c();
/*  89 */           j = a1.b();
/*  90 */           for (byte b3 = 0; b3 < j; b3++) {
/*     */             
/*  92 */             l l = (l)a1.a(b3);
/*  93 */             this.b.put(Integer.valueOf(m + b3), Float.valueOf(l.a()));
/*     */           } 
/*     */           
/*     */           continue;
/*     */         } 
/*  98 */         l l2 = (l)a1;
/*  99 */         l l3 = (l)a.a(b1++);
/* 100 */         int j = j.c();
/* 101 */         int k = l2.c();
/* 102 */         float f = l3.a();
/* 103 */         for (j = j; j <= k; j++)
/*     */         {
/* 105 */           this.b.put(Integer.valueOf(j), Float.valueOf(f));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void k() {
/*     */     b b;
/* 116 */     if (b = this.g.a(j.aN) instanceof a) {
/*     */       a a;
/*     */       
/* 119 */       b b2 = (a = (a)b).a(0);
/* 120 */       b b1 = a.a(1);
/* 121 */       if (b2 instanceof l && b1 instanceof l) {
/*     */         
/* 123 */         this.f[0] = ((l)b2).a();
/* 124 */         this.f[1] = ((l)b1).a();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 130 */     if (b = this.g.a(j.dY) instanceof a) {
/*     */       
/* 132 */       a a = (a)b;
/* 133 */       for (byte b1 = 0; b1 < a.b(); b1++) {
/*     */         int i;
/* 135 */         l l = (l)a.a(b1);
/*     */         b b2;
/* 137 */         if (b2 = a.a(++b1) instanceof a) {
/*     */           
/* 139 */           a a1 = (a)b2;
/* 140 */           for (i = 0; i < a1.b(); i++)
/*     */           {
/* 142 */             int j = l.c() + i / 3;
/* 143 */             l l1 = (l)a1.a(i);
/* 144 */             l l2 = (l)a1.a(++i);
/* 145 */             l l3 = (l)a1.a(++i);
/* 146 */             this.d.put(Integer.valueOf(j), Float.valueOf(l1.a()));
/* 147 */             this.e.put(Integer.valueOf(j), new f(l2.a(), l3.a()));
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 152 */           int j = l.c();
/* 153 */           i = ((l)i).c();
/* 154 */           l l1 = (l)a.a(++b1);
/* 155 */           l l2 = (l)a.a(++b1);
/* 156 */           l l3 = (l)a.a(++b1);
/* 157 */           for (int k = j; k <= i; k++) {
/*     */             
/* 159 */             this.d.put(Integer.valueOf(k), Float.valueOf(l1.a()));
/* 160 */             this.e.put(Integer.valueOf(k), new f(l2.a(), l3.a()));
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private d l() {
/* 170 */     return this.g;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a() {
/* 180 */     return this.g.g(j.v);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String b() {
/* 186 */     return a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final v c() {
/* 192 */     if (this.h == null) {
/*     */       d d1;
/*     */       
/* 195 */       if ((d1 = (d)this.g.a(j.bg)) != null)
/*     */       {
/* 197 */         this.h = new v(d1);
/*     */       }
/*     */     } 
/* 200 */     return this.h;
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
/*     */   private float m() {
/* 226 */     if (this.c == 0.0F) {
/*     */       b b;
/*     */       
/* 229 */       if (b = this.g.a(j.aM) instanceof l) {
/*     */         
/* 231 */         this.c = ((l)b).a();
/*     */       }
/*     */       else {
/*     */         
/* 235 */         this.c = 1000.0F;
/*     */       } 
/*     */     } 
/* 238 */     return this.c;
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
/*     */   private float e(int paramInt) {
/*     */     Float float_;
/* 254 */     if ((float_ = this.b.get(Integer.valueOf(paramInt))) == null)
/*     */     {
/* 256 */       float_ = Float.valueOf(m());
/*     */     }
/* 258 */     return float_.floatValue();
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
/*     */   public final float a(int paramInt) {
/* 305 */     return e(c(paramInt));
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
/*     */   public final t h() {
/*     */     b b;
/* 348 */     if (b = this.g.a(j.Z) instanceof d)
/*     */     {
/* 350 */       return new t((d)b);
/*     */     }
/* 352 */     return null;
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
/*     */   final int[] i() {
/*     */     int[] arrayOfInt;
/* 386 */     p p = null;
/*     */     b b;
/* 388 */     if (b = this.g.a(j.X) instanceof p) {
/*     */       g g;
/*     */ 
/*     */ 
/*     */       
/* 393 */       byte[] arrayOfByte = am.a((InputStream)(g = (p = (p)b).k()));
/* 394 */       am.a((Closeable)g);
/*     */       int i;
/* 396 */       arrayOfInt = new int[i = arrayOfByte.length / 2];
/* 397 */       byte b1 = 0;
/* 398 */       for (byte b2 = 0; b2 < i; b2++) {
/*     */         
/* 400 */         int j = (arrayOfByte[b1] & 0xFF) << 8 | arrayOfByte[b1 + 1] & 0xFF;
/* 401 */         arrayOfInt[b2] = j;
/* 402 */         b1 += 2;
/*     */       } 
/*     */     } 
/* 405 */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   public abstract d d();
/*     */   
/*     */   public abstract a e();
/*     */   
/*     */   public abstract float b(int paramInt);
/*     */   
/*     */   public abstract boolean g();
/*     */   
/*     */   public abstract int c(int paramInt);
/*     */   
/*     */   protected abstract byte[] d(int paramInt);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */