/*     */ package com.a.a.c.m;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class c
/*     */ {
/*  17 */   private a a = null;
/*     */ 
/*     */ 
/*     */   
/*  21 */   private b b = null;
/*  22 */   private g c = null;
/*  23 */   private e d = null;
/*  24 */   private f e = null;
/*     */   
/*  26 */   private d f = null;
/*  27 */   private c g = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final a a() {
/*  33 */     if (this.a == null) {
/*  34 */       this.a = new a();
/*     */     }
/*  36 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public final b b() {
/*  41 */     if (this.b == null) {
/*  42 */       this.b = new b();
/*     */     }
/*  44 */     return this.b;
/*     */   }
/*     */   
/*     */   public final g c() {
/*  48 */     if (this.c == null) {
/*  49 */       this.c = new g();
/*     */     }
/*  51 */     return this.c;
/*     */   }
/*     */   
/*     */   public final e d() {
/*  55 */     if (this.d == null) {
/*  56 */       this.d = new e();
/*     */     }
/*  58 */     return this.d;
/*     */   }
/*     */   
/*     */   public final f e() {
/*  62 */     if (this.e == null) {
/*  63 */       this.e = new f();
/*     */     }
/*  65 */     return this.e;
/*     */   }
/*     */ 
/*     */   
/*     */   public final d f() {
/*  70 */     if (this.f == null) {
/*  71 */       this.f = new d();
/*     */     }
/*  73 */     return this.f;
/*     */   }
/*     */   
/*     */   public final c g() {
/*  77 */     if (this.g == null) {
/*  78 */       this.g = new c();
/*     */     }
/*  80 */     return this.g;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class a
/*     */     extends x<boolean[]>
/*     */   {
/*     */     private static boolean[] b(int param1Int) {
/*  94 */       return new boolean[param1Int];
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class b
/*     */     extends x<byte[]>
/*     */   {
/*     */     private static byte[] b(int param1Int) {
/* 102 */       return new byte[param1Int];
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class g
/*     */     extends x<short[]> {
/*     */     private static short[] b(int param1Int) {
/* 109 */       return new short[param1Int];
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class e
/*     */     extends x<int[]> {
/*     */     private static int[] b(int param1Int) {
/* 116 */       return new int[param1Int];
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class f
/*     */     extends x<long[]> {
/*     */     private static long[] b(int param1Int) {
/* 123 */       return new long[param1Int];
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class d
/*     */     extends x<float[]>
/*     */   {
/*     */     private static float[] b(int param1Int) {
/* 131 */       return new float[param1Int];
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class c
/*     */     extends x<double[]> {
/*     */     private static double[] b(int param1Int) {
/* 138 */       return new double[param1Int];
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object a(Object paramObject) {
/* 159 */     int i = Array.getLength(paramObject);
/* 160 */     Class<?> clazz = paramObject.getClass();
/* 161 */     return new d(clazz, i, paramObject);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */