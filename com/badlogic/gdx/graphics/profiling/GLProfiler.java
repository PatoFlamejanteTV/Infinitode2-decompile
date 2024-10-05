/*     */ package com.badlogic.gdx.graphics.profiling;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Graphics;
/*     */ import com.badlogic.gdx.graphics.GL30;
/*     */ import com.badlogic.gdx.graphics.GL31;
/*     */ import com.badlogic.gdx.graphics.GL32;
/*     */ import com.badlogic.gdx.math.FloatCounter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GLProfiler
/*     */ {
/*     */   private Graphics graphics;
/*     */   private GLInterceptor glInterceptor;
/*     */   private GLErrorListener listener;
/*     */   private boolean enabled = false;
/*     */   
/*     */   public GLProfiler(Graphics paramGraphics) {
/*  45 */     this.graphics = paramGraphics;
/*  46 */     GL32 gL32 = paramGraphics.getGL32();
/*  47 */     GL31 gL31 = paramGraphics.getGL31();
/*  48 */     GL30 gL30 = paramGraphics.getGL30();
/*  49 */     if (gL32 != null) {
/*  50 */       this.glInterceptor = new GL32Interceptor(this, gL32);
/*  51 */     } else if (gL31 != null) {
/*  52 */       this.glInterceptor = new GL31Interceptor(this, gL31);
/*  53 */     } else if (gL30 != null) {
/*  54 */       this.glInterceptor = new GL30Interceptor(this, gL30);
/*     */     } else {
/*  56 */       this.glInterceptor = new GL20Interceptor(this, paramGraphics.getGL20());
/*     */     } 
/*  58 */     this.listener = GLErrorListener.LOGGING_LISTENER;
/*     */   }
/*     */ 
/*     */   
/*     */   public void enable() {
/*  63 */     if (this.enabled)
/*     */       return; 
/*  65 */     if (this.glInterceptor instanceof GL32) {
/*  66 */       this.graphics.setGL32((GL32)this.glInterceptor);
/*     */     }
/*  68 */     if (this.glInterceptor instanceof GL31) {
/*  69 */       this.graphics.setGL31((GL31)this.glInterceptor);
/*     */     }
/*  71 */     if (this.glInterceptor instanceof GL30) {
/*  72 */       this.graphics.setGL30((GL30)this.glInterceptor);
/*     */     }
/*  74 */     this.graphics.setGL20(this.glInterceptor);
/*     */     
/*  76 */     Gdx.gl32 = this.graphics.getGL32();
/*  77 */     Gdx.gl31 = this.graphics.getGL31();
/*  78 */     Gdx.gl30 = this.graphics.getGL30();
/*  79 */     Gdx.gl20 = this.graphics.getGL20();
/*  80 */     Gdx.gl = this.graphics.getGL20();
/*     */     
/*  82 */     this.enabled = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void disable() {
/*  87 */     if (!this.enabled)
/*     */       return; 
/*  89 */     if (this.glInterceptor instanceof GL32Interceptor) {
/*  90 */       this.graphics.setGL32(((GL32Interceptor)this.glInterceptor).gl32);
/*     */     }
/*  92 */     if (this.glInterceptor instanceof GL31Interceptor) {
/*  93 */       this.graphics.setGL31(((GL31Interceptor)this.glInterceptor).gl31);
/*     */     }
/*  95 */     if (this.glInterceptor instanceof GL30Interceptor) {
/*  96 */       this.graphics.setGL30(((GL30Interceptor)this.glInterceptor).gl30);
/*     */     }
/*  98 */     if (this.glInterceptor instanceof GL20Interceptor) {
/*  99 */       this.graphics.setGL20(((GL20Interceptor)this.graphics.getGL20()).gl20);
/*     */     }
/*     */     
/* 102 */     Gdx.gl32 = this.graphics.getGL32();
/* 103 */     Gdx.gl31 = this.graphics.getGL31();
/* 104 */     Gdx.gl30 = this.graphics.getGL30();
/* 105 */     Gdx.gl20 = this.graphics.getGL20();
/* 106 */     Gdx.gl = this.graphics.getGL20();
/*     */     
/* 108 */     this.enabled = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setListener(GLErrorListener paramGLErrorListener) {
/* 113 */     this.listener = paramGLErrorListener;
/*     */   }
/*     */ 
/*     */   
/*     */   public GLErrorListener getListener() {
/* 118 */     return this.listener;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/* 123 */     return this.enabled;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCalls() {
/* 128 */     return this.glInterceptor.getCalls();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTextureBindings() {
/* 133 */     return this.glInterceptor.getTextureBindings();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDrawCalls() {
/* 138 */     return this.glInterceptor.getDrawCalls();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getShaderSwitches() {
/* 143 */     return this.glInterceptor.getShaderSwitches();
/*     */   }
/*     */ 
/*     */   
/*     */   public FloatCounter getVertexCount() {
/* 148 */     return this.glInterceptor.getVertexCount();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 154 */     this.glInterceptor.reset();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\profiling\GLProfiler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */