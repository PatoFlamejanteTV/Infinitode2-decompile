/*     */ package org.a.b.f;
/*     */ 
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ag
/*     */   extends an
/*     */ {
/*  30 */   private static final a c = c.a(ag.class);
/*     */   private float d;
/*     */   private float e;
/*     */   private short f;
/*     */   private short g;
/*     */   private long h;
/*     */   private long i;
/*     */   private long j;
/*     */   private long k;
/*     */   private long l;
/*  40 */   private String[] m = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ag(ap paramap) {
/*  49 */     super(paramap);
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
/*     */   public final void a(ap paramap, ak paramak) {
/*  62 */     this.d = paramak.h();
/*  63 */     this.e = paramak.h();
/*  64 */     this.f = paramak.d();
/*  65 */     this.g = paramak.d();
/*  66 */     this.h = paramak.k();
/*  67 */     this.i = paramak.k();
/*  68 */     this.j = paramak.k();
/*  69 */     this.k = paramak.k();
/*  70 */     this.l = paramak.k();
/*     */     
/*  72 */     if (this.d == 1.0F) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  77 */       this.m = new String[258];
/*  78 */       System.arraycopy(at.a, 0, this.m, 0, 258);
/*     */     } else {
/*  80 */       int i; if (this.d == 2.0F) {
/*     */ 
/*     */         
/*  83 */         int[] arrayOfInt = new int[i = paramak.c()];
/*  84 */         this.m = new String[i];
/*  85 */         int j = Integer.MIN_VALUE;
/*  86 */         for (byte b1 = 0; b1 < i; b1++) {
/*     */           
/*  88 */           int k = paramak.c();
/*  89 */           arrayOfInt[b1] = k;
/*     */ 
/*     */           
/*  92 */           if (k <= 32767)
/*     */           {
/*  94 */             j = Math.max(j, k);
/*     */           }
/*     */         } 
/*  97 */         String[] arrayOfString = null;
/*  98 */         if (j >= 258) {
/*     */           
/* 100 */           arrayOfString = new String[j - 258 + 1];
/* 101 */           for (byte b = 0; b < j - 258 + 1; b++) {
/*     */             
/* 103 */             int k = paramak.j();
/* 104 */             arrayOfString[b] = paramak.a(k);
/*     */           } 
/*     */         } 
/* 107 */         for (byte b2 = 0; b2 < i; b2++) {
/*     */           int k;
/*     */           
/* 110 */           if ((k = arrayOfInt[b2]) < 258)
/*     */           {
/* 112 */             this.m[b2] = at.a[k];
/*     */           }
/* 114 */           else if (k >= 258 && k <= 32767)
/*     */           {
/* 116 */             this.m[b2] = arrayOfString[k - 258];
/*     */           
/*     */           }
/*     */           else
/*     */           {
/*     */             
/* 122 */             this.m[b2] = ".undefined";
/*     */           }
/*     */         
/*     */         } 
/* 126 */       } else if (this.d == 2.5F) {
/*     */         
/* 128 */         int[] arrayOfInt = new int[i.w()]; byte b;
/* 129 */         for (b = 0; b < arrayOfInt.length; b++) {
/*     */           
/* 131 */           int j = paramak.i();
/* 132 */           arrayOfInt[b] = b + 1 + j;
/*     */         } 
/* 134 */         this.m = new String[arrayOfInt.length];
/* 135 */         for (b = 0; b < this.m.length; b++) {
/*     */           String str;
/*     */           
/* 138 */           if ((str = at.a[arrayOfInt[b]]) != null)
/*     */           {
/* 140 */             this.m[b] = str;
/*     */           }
/*     */         }
/*     */       
/*     */       }
/* 145 */       else if (this.d == 3.0F) {
/*     */ 
/*     */         
/* 148 */         (new StringBuilder("No PostScript name information is provided for the font ")).append(this.b.b());
/*     */       } 
/* 150 */     }  this.a = true;
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
/*     */   public final long a() {
/* 174 */     return this.h;
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
/*     */   public final float b() {
/* 190 */     return this.e;
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
/*     */   public final long c() {
/* 206 */     return this.l;
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
/*     */   public final long d() {
/* 222 */     return this.j;
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
/*     */   public final long e() {
/* 238 */     return this.k;
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
/*     */   public final long f() {
/* 254 */     return this.i;
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
/*     */   public final short g() {
/* 270 */     return this.f;
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
/*     */   public final short h() {
/* 286 */     return this.g;
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
/*     */   public final String[] i() {
/* 302 */     return this.m;
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
/*     */   public final String a(int paramInt) {
/* 318 */     if (paramInt < 0 || this.m == null || paramInt >= this.m.length)
/*     */     {
/* 320 */       return null;
/*     */     }
/* 322 */     return this.m[paramInt];
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */