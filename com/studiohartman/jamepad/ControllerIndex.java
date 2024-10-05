/*     */ package com.studiohartman.jamepad;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ControllerIndex
/*     */ {
/*     */   private int a;
/*     */   private long b;
/*     */   private boolean[] c;
/*     */   private boolean[] d;
/*     */   
/*     */   ControllerIndex(int paramInt) {
/*  35 */     this.a = paramInt;
/*     */     
/*  37 */     this.c = new boolean[(c.values()).length];
/*  38 */     this.d = new boolean[(c.values()).length];
/*  39 */     for (paramInt = 0; paramInt < this.c.length; paramInt++) {
/*  40 */       this.c[paramInt] = false;
/*  41 */       this.d[paramInt] = false;
/*     */     } 
/*     */     
/*  44 */     i();
/*     */   }
/*     */   private void i() {
/*  47 */     this.b = nativeConnectController(this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private native long nativeConnectController(int paramInt);
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a() {
/*  57 */     if (this.b != 0L) {
/*  58 */       nativeClose(this.b);
/*  59 */       this.b = 0L;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private native void nativeClose(long paramLong);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean b() {
/*  78 */     a();
/*  79 */     i();
/*     */     
/*  81 */     return c();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean c() {
/*  92 */     return (this.b != 0L && nativeIsConnected(this.b));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private native boolean nativeIsConnected(long paramLong);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int d() {
/* 107 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean e() {
/* 115 */     j();
/* 116 */     return nativeCanVibrate(this.b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private native boolean nativeCanVibrate(long paramLong);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private native boolean nativeDoVibration(long paramLong, int paramInt1, int paramInt2, int paramInt3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean a(float paramFloat1, float paramFloat2, int paramInt) {
/* 143 */     j();
/*     */ 
/*     */     
/* 146 */     boolean bool1 = (paramFloat1 >= 0.0F && paramFloat1 <= 1.0F) ? true : false;
/* 147 */     boolean bool2 = (paramFloat2 >= 0.0F && paramFloat2 <= 1.0F) ? true : false;
/* 148 */     if (!bool1 || !bool2) {
/* 149 */       throw new IllegalArgumentException("The passed values are not in the range 0 to 1!");
/*     */     }
/*     */     
/* 152 */     return nativeDoVibration(this.b, (int)(65535.0F * paramFloat1), (int)(65535.0F * paramFloat2), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean a(c paramc) {
/* 163 */     b(paramc.ordinal());
/* 164 */     return this.c[paramc.ordinal()];
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
/* 183 */     j();
/*     */     
/* 185 */     boolean bool = nativeCheckButton(this.b, paramInt);
/* 186 */     this.d[paramInt] = (bool && !this.c[paramInt]);
/* 187 */     this.c[paramInt] = bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private native boolean nativeCheckButton(long paramLong, int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean b(c paramc) {
/* 203 */     j();
/* 204 */     return nativeButtonAvailable(this.b, paramc.ordinal());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private native boolean nativeButtonAvailable(long paramLong, int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float a(b paramb) {
/* 220 */     j();
/*     */     
/* 222 */     return nativeCheckAxis(this.b, paramb.ordinal()) / 32767.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private native int nativeCheckAxis(long paramLong, int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean b(b paramb) {
/* 238 */     j();
/* 239 */     return nativeAxisAvailable(this.b, paramb.ordinal());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private native boolean nativeAxisAvailable(long paramLong, int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String f() {
/* 254 */     j();
/*     */ 
/*     */     
/*     */     String str;
/*     */     
/* 259 */     if ((str = nativeGetName(this.b)) == null) {
/* 260 */       return "Unnamed Controller";
/*     */     }
/* 262 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private native String nativeGetName(long paramLong);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int g() {
/* 274 */     j();
/* 275 */     return nativeGetPlayerIndex(this.b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private native int nativeGetPlayerIndex(long paramLong);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(int paramInt) {
/* 289 */     j();
/* 290 */     nativeSetPlayerIndex(this.b, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private native void nativeSetPlayerIndex(long paramLong, int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final d h() {
/* 303 */     j();
/* 304 */     return d.a(nativeGetPowerLevel(this.b));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private native int nativeGetPowerLevel(long paramLong);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void j() {
/* 316 */     if (!c())
/* 317 */       throw new e("Controller at index " + this.a + " is not connected!"); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\studiohartman\jamepad\ControllerIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */