/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class LimitedBAOS
/*     */   extends ByteArrayOutputStream
/*     */ {
/*     */   private final int a;
/*     */   private final float b;
/*     */   
/*     */   public LimitedBAOS(int paramInt1, int paramInt2, float paramFloat) {
/*  30 */     if (paramInt1 < 0) {
/*  31 */       throw new IllegalArgumentException("Negative initial size: " + paramInt1);
/*     */     }
/*     */     
/*  34 */     if (paramFloat <= 0.0F || paramFloat >= 1.0F) {
/*  35 */       throw new IllegalArgumentException("Invalid cleanupMultiplier, must be (0..1): " + paramFloat);
/*     */     }
/*     */     
/*  38 */     if (paramInt2 < paramInt1) throw new IllegalArgumentException("Max size can not be " + paramInt2); 
/*  39 */     this.buf = new byte[paramInt1];
/*  40 */     this.a = paramInt2;
/*  41 */     this.b = paramFloat;
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
/*     */   private void a(int paramInt) {
/*  56 */     if (paramInt - this.buf.length > 0) {
/*  57 */       b(paramInt);
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
/*     */   private void b(int paramInt) {
/*     */     int i;
/*  78 */     if ((i = (i = this.buf.length) << 1) - paramInt < 0)
/*  79 */       i = paramInt; 
/*  80 */     if (i - 2147483639 > 0) {
/*  81 */       i = c(paramInt);
/*     */     }
/*  83 */     if (i > this.a) {
/*     */       
/*  85 */       paramInt = (int)(this.count * (1.0F - this.b));
/*  86 */       i = this.count - paramInt;
/*  87 */       System.arraycopy(this.buf, i, this.buf, 0, paramInt);
/*  88 */       this.count = paramInt; return;
/*     */     } 
/*  90 */     this.buf = Arrays.copyOf(this.buf, i);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int c(int paramInt) {
/*  95 */     if (paramInt < 0)
/*  96 */       throw new OutOfMemoryError(); 
/*  97 */     if (paramInt > 2147483639)
/*  98 */       return Integer.MAX_VALUE; 
/*  99 */     return 2147483639;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final synchronized void write(int paramInt) {
/* 110 */     a(this.count + 1);
/* 111 */     this.buf[this.count] = (byte)paramInt;
/* 112 */     this.count++;
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
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final synchronized void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 126 */     if (paramInt1 < 0 || paramInt1 > paramArrayOfbyte.length || paramInt2 < 0 || paramInt1 + paramInt2 - paramArrayOfbyte.length > 0)
/*     */     {
/* 128 */       throw new IndexOutOfBoundsException();
/*     */     }
/* 130 */     a(this.count + paramInt2);
/* 131 */     System.arraycopy(paramArrayOfbyte, paramInt1, this.buf, this.count, paramInt2);
/* 132 */     this.count += paramInt2;
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
/*     */   public final synchronized void writeTo(OutputStream paramOutputStream) {
/* 144 */     paramOutputStream.write(this.buf, 0, this.count);
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
/*     */   public final synchronized void reset() {
/* 156 */     this.count = 0;
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
/*     */   public final synchronized byte[] toByteArray() {
/* 168 */     return Arrays.copyOf(this.buf, this.count);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final synchronized int size() {
/* 179 */     return this.count;
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
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final synchronized String toString() {
/* 200 */     return new String(this.buf, 0, this.count);
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
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final synchronized String toString(String paramString) {
/* 226 */     return new String(this.buf, 0, this.count, paramString);
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
/*     */   @Deprecated
/*     */   public final synchronized String toString(int paramInt) {
/* 253 */     return new String(this.buf, paramInt, 0, this.count);
/*     */   }
/*     */   
/*     */   public final void close() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\LimitedBAOS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */