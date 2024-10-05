/*      */ package com.prineside.tdi2.utils;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.GL20;
/*      */ import com.badlogic.gdx.graphics.Mesh;
/*      */ import com.badlogic.gdx.graphics.Texture;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.graphics.glutils.ShaderProgram;
/*      */ import com.badlogic.gdx.math.Affine2;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.Matrix4;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.ByteOrder;
/*      */ import java.nio.FloatBuffer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class ParallelBatch
/*      */   implements Batch
/*      */ {
/*   30 */   private static final TLog a = TLog.forClass(ParallelBatch.class);
/*      */   @Deprecated
/*   32 */   public static Mesh.VertexDataType defaultVertexDataType = Mesh.VertexDataType.VertexArray;
/*      */   
/*   34 */   public static final float[] FLUSH_VERTICES = new float[163840];
/*      */   
/*      */   private FloatBuffer b;
/*   37 */   private Array<Object> c = new Array();
/*      */ 
/*      */   
/*      */   private float[] d;
/*      */   
/*   42 */   private int e = 0;
/*   43 */   private Texture f = null;
/*   44 */   private float g = 0.0F; private float h = 0.0F;
/*      */   
/*      */   public boolean drawing = false;
/*      */   
/*   48 */   private final Matrix4 i = new Matrix4();
/*   49 */   private final Matrix4 j = new Matrix4();
/*   50 */   private final Matrix4 k = new Matrix4();
/*      */   
/*      */   private boolean l = false;
/*   53 */   private int m = 770;
/*   54 */   private int n = 771;
/*   55 */   private int o = 770;
/*   56 */   private int p = 771;
/*      */   
/*      */   private final ShaderProgram q;
/*   59 */   private ShaderProgram r = null;
/*      */   
/*   61 */   private final Color s = new Color(1.0F, 1.0F, 1.0F, 1.0F);
/*   62 */   private float t = Color.WHITE_FLOAT_BITS;
/*      */ 
/*      */   
/*   65 */   public int renderCalls = 0;
/*      */ 
/*      */   
/*   68 */   public int totalRenderCalls = 0;
/*      */ 
/*      */   
/*   71 */   public int maxSpritesInBatch = 0;
/*      */ 
/*      */ 
/*      */   
/*      */   public ParallelBatch() {
/*   76 */     this(1000, null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ParallelBatch(int paramInt) {
/*   82 */     this(paramInt, null);
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
/*      */   public ParallelBatch(int paramInt, ShaderProgram paramShaderProgram) {
/*   95 */     if (paramInt > 8191) throw new IllegalArgumentException("Can't have more than 8191 sprites per batch: " + paramInt);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  104 */     this.j.setToOrtho2D(0.0F, 0.0F, Game.i.uiManager.getScreenWidth(), Game.i.uiManager.getScreenHeight());
/*      */     
/*  106 */     this.d = new float[paramInt * 20];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  121 */     if (paramShaderProgram == null) {
/*  122 */       this.q = SpriteBatch.createDefaultShader();
/*      */     } else {
/*  124 */       this.q = paramShaderProgram;
/*      */     } 
/*      */     ByteBuffer byteBuffer;
/*  127 */     (byteBuffer = ByteBuffer.allocateDirect(paramInt << 2)).order(ByteOrder.nativeOrder());
/*  128 */     this.b = byteBuffer.asFloatBuffer();
/*      */   }
/*      */   
/*      */   public final void reset() {
/*  132 */     this.c.clear();
/*  133 */     this.b.clear();
/*      */   }
/*      */ 
/*      */   
/*      */   public final void render(Mesh paramMesh) {
/*  138 */     for (byte b = 0; b < this.c.size; b++) {
/*      */       Object object;
/*  140 */       if (object = this.c.items[b] instanceof OpBegin) {
/*  141 */         Gdx.gl.glDepthMask(false);
/*  142 */         OpBegin.a((OpBegin)object).bind();
/*  143 */       } else if (object instanceof OpEnd) {
/*      */         GL20 gL20;
/*  145 */         (gL20 = Gdx.gl).glDepthMask(true);
/*  146 */         if (OpEnd.a((OpEnd)object)) {
/*  147 */           gL20.glDisable(3042);
/*      */         }
/*  149 */       } else if (object instanceof OpSetupMatrices) {
/*      */         ShaderProgram shaderProgram;
/*  151 */         (shaderProgram = OpSetupMatrices.a((OpSetupMatrices)object)).setUniformMatrix("u_projTrans", OpSetupMatrices.b((OpSetupMatrices)object));
/*  152 */         shaderProgram.setUniformi("u_texture", 0);
/*  153 */       } else if (object instanceof OpFlush) {
/*      */         OpFlush opFlush;
/*  155 */         OpFlush.a(opFlush = (OpFlush)object).bind();
/*      */         
/*  157 */         this.b.position(OpFlush.b(opFlush));
/*  158 */         this.b.get(FLUSH_VERTICES, 0, OpFlush.c(opFlush));
/*  159 */         paramMesh.setVertices(FLUSH_VERTICES, 0, OpFlush.c(opFlush));
/*  160 */         paramMesh.getIndicesBuffer().position(0);
/*  161 */         paramMesh.getIndicesBuffer().limit(OpFlush.d(opFlush));
/*      */         
/*  163 */         if (OpFlush.e(opFlush)) {
/*  164 */           Gdx.gl.glDisable(3042);
/*      */         } else {
/*  166 */           Gdx.gl.glEnable(3042);
/*  167 */           if (OpFlush.f(opFlush) != -1) Gdx.gl.glBlendFuncSeparate(OpFlush.f(opFlush), OpFlush.g(opFlush), OpFlush.h(opFlush), OpFlush.i(opFlush)); 
/*      */         } 
/*  169 */         paramMesh.render(OpFlush.j(opFlush), 4, 0, OpFlush.d(opFlush));
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void begin() {
/*  178 */     if (this.drawing) throw new IllegalStateException("SpriteBatch.end must be called before begin."); 
/*  179 */     this.renderCalls = 0;
/*      */     
/*  181 */     OpBegin opBegin = new OpBegin((byte)0);
/*  182 */     if (this.r != null) {
/*  183 */       OpBegin.a(opBegin, this.r);
/*      */     } else {
/*  185 */       OpBegin.a(opBegin, this.q);
/*  186 */     }  this.c.add(opBegin);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  193 */     a();
/*      */     
/*  195 */     this.drawing = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void end() {
/*  200 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before end."); 
/*  201 */     if (this.e > 0) flush(); 
/*  202 */     this.f = null;
/*  203 */     this.drawing = false;
/*      */     
/*      */     OpEnd opEnd;
/*  206 */     OpEnd.a(opEnd = new OpEnd((byte)0), isBlendingEnabled());
/*  207 */     this.c.add(opEnd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public final void setColor(Color paramColor) {
/*  217 */     this.s.set(paramColor);
/*  218 */     this.t = paramColor.toFloatBits();
/*      */   }
/*      */ 
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public final void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  224 */     this.s.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*  225 */     this.t = this.s.toFloatBits();
/*      */   }
/*      */ 
/*      */   
/*      */   public final Color getColor() {
/*  230 */     return this.s;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void setPackedColor(float paramFloat) {
/*  235 */     Color.abgr8888ToColor(this.s, paramFloat);
/*  236 */     this.t = paramFloat;
/*      */   }
/*      */ 
/*      */   
/*      */   public final float getPackedColor() {
/*  241 */     return this.t;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public final void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2) {
/*  248 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
/*      */     
/*  250 */     float[] arrayOfFloat = this.d;
/*      */     
/*  252 */     if (paramTexture != this.f) {
/*  253 */       a(paramTexture);
/*  254 */     } else if (this.e == arrayOfFloat.length) {
/*  255 */       flush();
/*      */     } 
/*      */     
/*  258 */     float f1 = paramFloat1 + paramFloat3;
/*  259 */     paramFloat1 = paramFloat2 + paramFloat4;
/*  260 */     paramFloat2 = -paramFloat3;
/*  261 */     float f3 = -paramFloat4;
/*  262 */     paramFloat3 = paramFloat5 - paramFloat3;
/*  263 */     paramFloat4 = paramFloat6 - paramFloat4;
/*      */ 
/*      */     
/*  266 */     if (paramFloat7 != 1.0F || paramFloat8 != 1.0F) {
/*  267 */       paramFloat2 *= paramFloat7;
/*  268 */       f3 *= paramFloat8;
/*  269 */       paramFloat3 *= paramFloat7;
/*  270 */       paramFloat4 *= paramFloat8;
/*      */     } 
/*      */ 
/*      */     
/*  274 */     paramFloat5 = paramFloat2;
/*  275 */     paramFloat6 = f3;
/*  276 */     paramFloat2 = paramFloat2;
/*  277 */     paramFloat7 = paramFloat4;
/*  278 */     paramFloat8 = paramFloat3;
/*  279 */     paramFloat4 = paramFloat4;
/*  280 */     paramFloat3 = paramFloat3;
/*  281 */     f3 = f3;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  293 */     if (paramFloat9 != 0.0F) {
/*  294 */       f3 = MathUtils.cosDeg(paramFloat9);
/*  295 */       float f = MathUtils.sinDeg(paramFloat9);
/*      */       
/*  297 */       paramFloat9 = f3 * paramFloat5 - f * paramFloat6;
/*  298 */       paramFloat5 = f * paramFloat5 + f3 * paramFloat6;
/*      */       
/*  300 */       paramFloat6 = f3 * paramFloat2 - f * paramFloat7;
/*  301 */       paramFloat2 = f * paramFloat2 + f3 * paramFloat7;
/*      */       
/*  303 */       paramFloat7 = f3 * paramFloat8 - f * paramFloat4;
/*  304 */       paramFloat4 = f * paramFloat8 + f3 * paramFloat4;
/*      */       
/*  306 */       paramFloat3 = paramFloat9 + paramFloat7 - paramFloat6;
/*  307 */       paramFloat8 = paramFloat4 - paramFloat2 - paramFloat5;
/*      */     } else {
/*  309 */       paramFloat9 = paramFloat5;
/*  310 */       paramFloat5 = paramFloat6;
/*      */       
/*  312 */       paramFloat6 = paramFloat2;
/*  313 */       paramFloat2 = paramFloat7;
/*      */       
/*  315 */       paramFloat7 = paramFloat8;
/*  316 */       paramFloat4 = paramFloat4;
/*      */       
/*  318 */       paramFloat3 = paramFloat3;
/*  319 */       paramFloat8 = f3;
/*      */     } 
/*      */     
/*  322 */     paramFloat9 += f1;
/*  323 */     paramFloat5 += paramFloat1;
/*  324 */     paramFloat6 += f1;
/*  325 */     paramFloat2 += paramFloat1;
/*  326 */     paramFloat7 += f1;
/*  327 */     paramFloat4 += paramFloat1;
/*  328 */     paramFloat3 += f1;
/*  329 */     paramFloat8 += paramFloat1;
/*      */     
/*  331 */     f3 = paramInt1 * this.g;
/*  332 */     float f4 = (paramInt2 + paramInt4) * this.h;
/*  333 */     f1 = (paramInt1 + paramInt3) * this.g;
/*  334 */     paramFloat1 = paramInt2 * this.h;
/*      */     
/*  336 */     if (paramBoolean1) {
/*  337 */       float f = f3;
/*  338 */       f3 = f1;
/*  339 */       f1 = f;
/*      */     } 
/*      */     
/*  342 */     if (paramBoolean2) {
/*  343 */       float f = f4;
/*  344 */       f4 = paramFloat1;
/*  345 */       paramFloat1 = f;
/*      */     } 
/*      */     
/*  348 */     float f2 = this.t;
/*  349 */     paramInt2 = this.e;
/*  350 */     arrayOfFloat[paramInt2] = paramFloat9;
/*  351 */     arrayOfFloat[paramInt2 + 1] = paramFloat5;
/*  352 */     arrayOfFloat[paramInt2 + 2] = f2;
/*  353 */     arrayOfFloat[paramInt2 + 3] = f3;
/*  354 */     arrayOfFloat[paramInt2 + 4] = f4;
/*      */     
/*  356 */     arrayOfFloat[paramInt2 + 5] = paramFloat6;
/*  357 */     arrayOfFloat[paramInt2 + 6] = paramFloat2;
/*  358 */     arrayOfFloat[paramInt2 + 7] = f2;
/*  359 */     arrayOfFloat[paramInt2 + 8] = f3;
/*  360 */     arrayOfFloat[paramInt2 + 9] = paramFloat1;
/*      */     
/*  362 */     arrayOfFloat[paramInt2 + 10] = paramFloat7;
/*  363 */     arrayOfFloat[paramInt2 + 11] = paramFloat4;
/*  364 */     arrayOfFloat[paramInt2 + 12] = f2;
/*  365 */     arrayOfFloat[paramInt2 + 13] = f1;
/*  366 */     arrayOfFloat[paramInt2 + 14] = paramFloat1;
/*      */     
/*  368 */     arrayOfFloat[paramInt2 + 15] = paramFloat3;
/*  369 */     arrayOfFloat[paramInt2 + 16] = paramFloat8;
/*  370 */     arrayOfFloat[paramInt2 + 17] = f2;
/*  371 */     arrayOfFloat[paramInt2 + 18] = f1;
/*  372 */     arrayOfFloat[paramInt2 + 19] = f4;
/*  373 */     this.e = paramInt2 + 20;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public final void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2) {
/*  380 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
/*      */     
/*  382 */     float[] arrayOfFloat = this.d;
/*      */     
/*  384 */     if (paramTexture != this.f) {
/*  385 */       a(paramTexture);
/*  386 */     } else if (this.e == arrayOfFloat.length) {
/*  387 */       flush();
/*      */     } 
/*  389 */     float f1 = paramInt1 * this.g;
/*  390 */     float f5 = (paramInt2 + paramInt4) * this.h;
/*  391 */     float f2 = (paramInt1 + paramInt3) * this.g;
/*  392 */     float f3 = paramInt2 * this.h;
/*  393 */     paramFloat3 = paramFloat1 + paramFloat3;
/*  394 */     paramFloat4 = paramFloat2 + paramFloat4;
/*      */     
/*  396 */     if (paramBoolean1) {
/*  397 */       float f = f1;
/*  398 */       f1 = f2;
/*  399 */       f2 = f;
/*      */     } 
/*      */     
/*  402 */     if (paramBoolean2) {
/*  403 */       float f = f5;
/*  404 */       f5 = f3;
/*  405 */       f3 = f;
/*      */     } 
/*      */     
/*  408 */     float f4 = this.t;
/*  409 */     int i = this.e;
/*  410 */     arrayOfFloat[i] = paramFloat1;
/*  411 */     arrayOfFloat[i + 1] = paramFloat2;
/*  412 */     arrayOfFloat[i + 2] = f4;
/*  413 */     arrayOfFloat[i + 3] = f1;
/*  414 */     arrayOfFloat[i + 4] = f5;
/*      */     
/*  416 */     arrayOfFloat[i + 5] = paramFloat1;
/*  417 */     arrayOfFloat[i + 6] = paramFloat4;
/*  418 */     arrayOfFloat[i + 7] = f4;
/*  419 */     arrayOfFloat[i + 8] = f1;
/*  420 */     arrayOfFloat[i + 9] = f3;
/*      */     
/*  422 */     arrayOfFloat[i + 10] = paramFloat3;
/*  423 */     arrayOfFloat[i + 11] = paramFloat4;
/*  424 */     arrayOfFloat[i + 12] = f4;
/*  425 */     arrayOfFloat[i + 13] = f2;
/*  426 */     arrayOfFloat[i + 14] = f3;
/*      */     
/*  428 */     arrayOfFloat[i + 15] = paramFloat3;
/*  429 */     arrayOfFloat[i + 16] = paramFloat2;
/*  430 */     arrayOfFloat[i + 17] = f4;
/*  431 */     arrayOfFloat[i + 18] = f2;
/*  432 */     arrayOfFloat[i + 19] = f5;
/*  433 */     this.e = i + 20;
/*      */   }
/*      */ 
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public final void draw(Texture paramTexture, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  439 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
/*      */     
/*  441 */     float[] arrayOfFloat = this.d;
/*      */     
/*  443 */     if (paramTexture != this.f) {
/*  444 */       a(paramTexture);
/*  445 */     } else if (this.e == arrayOfFloat.length) {
/*  446 */       flush();
/*      */     } 
/*  448 */     float f1 = paramInt1 * this.g;
/*  449 */     float f6 = (paramInt2 + paramInt4) * this.h;
/*  450 */     float f2 = (paramInt1 + paramInt3) * this.g;
/*  451 */     float f3 = paramInt2 * this.h;
/*  452 */     float f4 = paramFloat1 + paramInt3;
/*  453 */     float f5 = paramFloat2 + paramInt4;
/*      */     
/*  455 */     float f7 = this.t;
/*  456 */     int i = this.e;
/*  457 */     arrayOfFloat[i] = paramFloat1;
/*  458 */     arrayOfFloat[i + 1] = paramFloat2;
/*  459 */     arrayOfFloat[i + 2] = f7;
/*  460 */     arrayOfFloat[i + 3] = f1;
/*  461 */     arrayOfFloat[i + 4] = f6;
/*      */     
/*  463 */     arrayOfFloat[i + 5] = paramFloat1;
/*  464 */     arrayOfFloat[i + 6] = f5;
/*  465 */     arrayOfFloat[i + 7] = f7;
/*  466 */     arrayOfFloat[i + 8] = f1;
/*  467 */     arrayOfFloat[i + 9] = f3;
/*      */     
/*  469 */     arrayOfFloat[i + 10] = f4;
/*  470 */     arrayOfFloat[i + 11] = f5;
/*  471 */     arrayOfFloat[i + 12] = f7;
/*  472 */     arrayOfFloat[i + 13] = f2;
/*  473 */     arrayOfFloat[i + 14] = f3;
/*      */     
/*  475 */     arrayOfFloat[i + 15] = f4;
/*  476 */     arrayOfFloat[i + 16] = paramFloat2;
/*  477 */     arrayOfFloat[i + 17] = f7;
/*  478 */     arrayOfFloat[i + 18] = f2;
/*  479 */     arrayOfFloat[i + 19] = f6;
/*  480 */     this.e = i + 20;
/*      */   }
/*      */ 
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public final void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {
/*  486 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
/*      */     
/*  488 */     float[] arrayOfFloat = this.d;
/*      */     
/*  490 */     if (paramTexture != this.f) {
/*  491 */       a(paramTexture);
/*  492 */     } else if (this.e == arrayOfFloat.length) {
/*  493 */       flush();
/*      */     } 
/*  495 */     float f = paramFloat1 + paramFloat3;
/*  496 */     paramFloat3 = paramFloat2 + paramFloat4;
/*      */     
/*  498 */     paramFloat4 = this.t;
/*  499 */     int i = this.e;
/*  500 */     arrayOfFloat[i] = paramFloat1;
/*  501 */     arrayOfFloat[i + 1] = paramFloat2;
/*  502 */     arrayOfFloat[i + 2] = paramFloat4;
/*  503 */     arrayOfFloat[i + 3] = paramFloat5;
/*  504 */     arrayOfFloat[i + 4] = paramFloat6;
/*      */     
/*  506 */     arrayOfFloat[i + 5] = paramFloat1;
/*  507 */     arrayOfFloat[i + 6] = paramFloat3;
/*  508 */     arrayOfFloat[i + 7] = paramFloat4;
/*  509 */     arrayOfFloat[i + 8] = paramFloat5;
/*  510 */     arrayOfFloat[i + 9] = paramFloat8;
/*      */     
/*  512 */     arrayOfFloat[i + 10] = f;
/*  513 */     arrayOfFloat[i + 11] = paramFloat3;
/*  514 */     arrayOfFloat[i + 12] = paramFloat4;
/*  515 */     arrayOfFloat[i + 13] = paramFloat7;
/*  516 */     arrayOfFloat[i + 14] = paramFloat8;
/*      */     
/*  518 */     arrayOfFloat[i + 15] = f;
/*  519 */     arrayOfFloat[i + 16] = paramFloat2;
/*  520 */     arrayOfFloat[i + 17] = paramFloat4;
/*  521 */     arrayOfFloat[i + 18] = paramFloat7;
/*  522 */     arrayOfFloat[i + 19] = paramFloat6;
/*  523 */     this.e = i + 20;
/*      */   }
/*      */ 
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public final void draw(Texture paramTexture, float paramFloat1, float paramFloat2) {
/*  529 */     draw(paramTexture, paramFloat1, paramFloat2, paramTexture.getWidth(), paramTexture.getHeight());
/*      */   }
/*      */ 
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public final void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  535 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
/*      */     
/*  537 */     float[] arrayOfFloat = this.d;
/*      */     
/*  539 */     if (paramTexture != this.f) {
/*  540 */       a(paramTexture);
/*  541 */     } else if (this.e == arrayOfFloat.length) {
/*  542 */       flush();
/*      */     } 
/*  544 */     float f = paramFloat1 + paramFloat3;
/*  545 */     paramFloat3 = paramFloat2 + paramFloat4;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  551 */     paramFloat4 = this.t;
/*  552 */     int i = this.e;
/*  553 */     arrayOfFloat[i] = paramFloat1;
/*  554 */     arrayOfFloat[i + 1] = paramFloat2;
/*  555 */     arrayOfFloat[i + 2] = paramFloat4;
/*  556 */     arrayOfFloat[i + 3] = 0.0F;
/*  557 */     arrayOfFloat[i + 4] = 1.0F;
/*      */     
/*  559 */     arrayOfFloat[i + 5] = paramFloat1;
/*  560 */     arrayOfFloat[i + 6] = paramFloat3;
/*  561 */     arrayOfFloat[i + 7] = paramFloat4;
/*  562 */     arrayOfFloat[i + 8] = 0.0F;
/*  563 */     arrayOfFloat[i + 9] = 0.0F;
/*      */     
/*  565 */     arrayOfFloat[i + 10] = f;
/*  566 */     arrayOfFloat[i + 11] = paramFloat3;
/*  567 */     arrayOfFloat[i + 12] = paramFloat4;
/*  568 */     arrayOfFloat[i + 13] = 1.0F;
/*  569 */     arrayOfFloat[i + 14] = 0.0F;
/*      */     
/*  571 */     arrayOfFloat[i + 15] = f;
/*  572 */     arrayOfFloat[i + 16] = paramFloat2;
/*  573 */     arrayOfFloat[i + 17] = paramFloat4;
/*  574 */     arrayOfFloat[i + 18] = 1.0F;
/*  575 */     arrayOfFloat[i + 19] = 1.0F;
/*  576 */     this.e = i + 20;
/*      */   }
/*      */ 
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public final void draw(Texture paramTexture, float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/*  582 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
/*      */ 
/*      */     
/*  585 */     int j = this.d.length, k = j;
/*  586 */     if (paramTexture != this.f) {
/*  587 */       a(paramTexture);
/*      */     
/*      */     }
/*  590 */     else if ((k = j - this.e) == 0) {
/*  591 */       flush();
/*  592 */       k = j;
/*      */     } 
/*      */     
/*  595 */     int i = Math.min(k, paramInt2);
/*      */     
/*  597 */     System.arraycopy(paramArrayOffloat, paramInt1, this.d, this.e, i);
/*  598 */     this.e += i;
/*  599 */     paramInt2 -= i;
/*  600 */     while (paramInt2 > 0) {
/*  601 */       paramInt1 += i;
/*  602 */       flush();
/*  603 */       i = Math.min(j, paramInt2);
/*  604 */       System.arraycopy(paramArrayOffloat, paramInt1, this.d, 0, i);
/*  605 */       this.e += i;
/*  606 */       paramInt2 -= i;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public final void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2) {
/*  613 */     draw(paramTextureRegion, paramFloat1, paramFloat2, paramTextureRegion.getRegionWidth(), paramTextureRegion.getRegionHeight());
/*      */   }
/*      */ 
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public final void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  619 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
/*      */     
/*  621 */     float[] arrayOfFloat = this.d;
/*      */     
/*      */     Texture texture;
/*  624 */     if ((texture = paramTextureRegion.getTexture()) != this.f) {
/*  625 */       a(texture);
/*  626 */     } else if (this.e == arrayOfFloat.length) {
/*  627 */       flush();
/*      */     } 
/*  629 */     paramFloat3 = paramFloat1 + paramFloat3;
/*  630 */     paramFloat4 = paramFloat2 + paramFloat4;
/*  631 */     float f2 = paramTextureRegion.getU();
/*  632 */     float f3 = paramTextureRegion.getV2();
/*  633 */     float f4 = paramTextureRegion.getU2();
/*  634 */     float f1 = paramTextureRegion.getV();
/*      */     
/*  636 */     float f5 = this.t;
/*  637 */     int i = this.e;
/*  638 */     arrayOfFloat[i] = paramFloat1;
/*  639 */     arrayOfFloat[i + 1] = paramFloat2;
/*  640 */     arrayOfFloat[i + 2] = f5;
/*  641 */     arrayOfFloat[i + 3] = f2;
/*  642 */     arrayOfFloat[i + 4] = f3;
/*      */     
/*  644 */     arrayOfFloat[i + 5] = paramFloat1;
/*  645 */     arrayOfFloat[i + 6] = paramFloat4;
/*  646 */     arrayOfFloat[i + 7] = f5;
/*  647 */     arrayOfFloat[i + 8] = f2;
/*  648 */     arrayOfFloat[i + 9] = f1;
/*      */     
/*  650 */     arrayOfFloat[i + 10] = paramFloat3;
/*  651 */     arrayOfFloat[i + 11] = paramFloat4;
/*  652 */     arrayOfFloat[i + 12] = f5;
/*  653 */     arrayOfFloat[i + 13] = f4;
/*  654 */     arrayOfFloat[i + 14] = f1;
/*      */     
/*  656 */     arrayOfFloat[i + 15] = paramFloat3;
/*  657 */     arrayOfFloat[i + 16] = paramFloat2;
/*  658 */     arrayOfFloat[i + 17] = f5;
/*  659 */     arrayOfFloat[i + 18] = f4;
/*  660 */     arrayOfFloat[i + 19] = f3;
/*  661 */     this.e = i + 20;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public final void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/*  668 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
/*      */     
/*  670 */     float[] arrayOfFloat = this.d;
/*      */     
/*      */     Texture texture;
/*  673 */     if ((texture = paramTextureRegion.getTexture()) != this.f) {
/*  674 */       a(texture);
/*  675 */     } else if (this.e == arrayOfFloat.length) {
/*  676 */       flush();
/*      */     } 
/*      */     
/*  679 */     paramFloat1 += paramFloat3;
/*  680 */     paramFloat2 += paramFloat4;
/*  681 */     float f2 = -paramFloat3;
/*  682 */     float f3 = -paramFloat4;
/*  683 */     paramFloat3 = paramFloat5 - paramFloat3;
/*  684 */     paramFloat4 = paramFloat6 - paramFloat4;
/*      */ 
/*      */     
/*  687 */     if (paramFloat7 != 1.0F || paramFloat8 != 1.0F) {
/*  688 */       f2 *= paramFloat7;
/*  689 */       f3 *= paramFloat8;
/*  690 */       paramFloat3 *= paramFloat7;
/*  691 */       paramFloat4 *= paramFloat8;
/*      */     } 
/*      */ 
/*      */     
/*  695 */     paramFloat5 = f2;
/*  696 */     paramFloat6 = f3;
/*  697 */     paramFloat7 = f2;
/*  698 */     paramFloat8 = paramFloat4;
/*  699 */     f2 = paramFloat3;
/*  700 */     paramFloat4 = paramFloat4;
/*  701 */     paramFloat3 = paramFloat3;
/*  702 */     f3 = f3;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  714 */     if (paramFloat9 != 0.0F) {
/*  715 */       f3 = MathUtils.cosDeg(paramFloat9);
/*  716 */       float f = MathUtils.sinDeg(paramFloat9);
/*      */       
/*  718 */       paramFloat9 = f3 * paramFloat5 - f * paramFloat6;
/*  719 */       paramFloat5 = f * paramFloat5 + f3 * paramFloat6;
/*      */       
/*  721 */       paramFloat6 = f3 * paramFloat7 - f * paramFloat8;
/*  722 */       paramFloat7 = f * paramFloat7 + f3 * paramFloat8;
/*      */       
/*  724 */       paramFloat8 = f3 * f2 - f * paramFloat4;
/*  725 */       paramFloat4 = f * f2 + f3 * paramFloat4;
/*      */       
/*  727 */       paramFloat3 = paramFloat9 + paramFloat8 - paramFloat6;
/*  728 */       f2 = paramFloat4 - paramFloat7 - paramFloat5;
/*      */     } else {
/*  730 */       paramFloat9 = paramFloat5;
/*  731 */       paramFloat5 = paramFloat6;
/*      */       
/*  733 */       paramFloat6 = paramFloat7;
/*  734 */       paramFloat7 = paramFloat8;
/*      */       
/*  736 */       paramFloat8 = f2;
/*  737 */       paramFloat4 = paramFloat4;
/*      */       
/*  739 */       paramFloat3 = paramFloat3;
/*  740 */       f2 = f3;
/*      */     } 
/*      */     
/*  743 */     paramFloat9 += paramFloat1;
/*  744 */     paramFloat5 += paramFloat2;
/*  745 */     paramFloat6 += paramFloat1;
/*  746 */     paramFloat7 += paramFloat2;
/*  747 */     paramFloat8 += paramFloat1;
/*  748 */     paramFloat4 += paramFloat2;
/*  749 */     paramFloat3 += paramFloat1;
/*  750 */     f2 += paramFloat2;
/*      */     
/*  752 */     f3 = paramTextureRegion.getU();
/*  753 */     float f4 = paramTextureRegion.getV2();
/*  754 */     paramFloat1 = paramTextureRegion.getU2();
/*  755 */     float f1 = paramTextureRegion.getV();
/*      */     
/*  757 */     paramFloat2 = this.t;
/*  758 */     int i = this.e;
/*  759 */     arrayOfFloat[i] = paramFloat9;
/*  760 */     arrayOfFloat[i + 1] = paramFloat5;
/*  761 */     arrayOfFloat[i + 2] = paramFloat2;
/*  762 */     arrayOfFloat[i + 3] = f3;
/*  763 */     arrayOfFloat[i + 4] = f4;
/*      */     
/*  765 */     arrayOfFloat[i + 5] = paramFloat6;
/*  766 */     arrayOfFloat[i + 6] = paramFloat7;
/*  767 */     arrayOfFloat[i + 7] = paramFloat2;
/*  768 */     arrayOfFloat[i + 8] = f3;
/*  769 */     arrayOfFloat[i + 9] = f1;
/*      */     
/*  771 */     arrayOfFloat[i + 10] = paramFloat8;
/*  772 */     arrayOfFloat[i + 11] = paramFloat4;
/*  773 */     arrayOfFloat[i + 12] = paramFloat2;
/*  774 */     arrayOfFloat[i + 13] = paramFloat1;
/*  775 */     arrayOfFloat[i + 14] = f1;
/*      */     
/*  777 */     arrayOfFloat[i + 15] = paramFloat3;
/*  778 */     arrayOfFloat[i + 16] = f2;
/*  779 */     arrayOfFloat[i + 17] = paramFloat2;
/*  780 */     arrayOfFloat[i + 18] = paramFloat1;
/*  781 */     arrayOfFloat[i + 19] = f4;
/*  782 */     this.e = i + 20;
/*      */   }
/*      */ 
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public final void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, boolean paramBoolean) {
/*      */     float f1, f2, f5, f6, f7;
/*  789 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
/*      */     
/*  791 */     float[] arrayOfFloat = this.d;
/*      */     
/*      */     Texture texture;
/*  794 */     if ((texture = paramTextureRegion.getTexture()) != this.f) {
/*  795 */       a(texture);
/*  796 */     } else if (this.e == arrayOfFloat.length) {
/*  797 */       flush();
/*      */     } 
/*      */     
/*  800 */     paramFloat1 += paramFloat3;
/*  801 */     paramFloat2 += paramFloat4;
/*  802 */     float f3 = -paramFloat3;
/*  803 */     float f4 = -paramFloat4;
/*  804 */     paramFloat3 = paramFloat5 - paramFloat3;
/*  805 */     paramFloat4 = paramFloat6 - paramFloat4;
/*      */ 
/*      */     
/*  808 */     if (paramFloat7 != 1.0F || paramFloat8 != 1.0F) {
/*  809 */       f3 *= paramFloat7;
/*  810 */       f4 *= paramFloat8;
/*  811 */       paramFloat3 *= paramFloat7;
/*  812 */       paramFloat4 *= paramFloat8;
/*      */     } 
/*      */ 
/*      */     
/*  816 */     paramFloat5 = f3;
/*  817 */     paramFloat6 = f4;
/*  818 */     paramFloat7 = f3;
/*  819 */     paramFloat8 = paramFloat4;
/*  820 */     f3 = paramFloat3;
/*  821 */     paramFloat4 = paramFloat4;
/*  822 */     paramFloat3 = paramFloat3;
/*  823 */     f4 = f4;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  835 */     if (paramFloat9 != 0.0F) {
/*  836 */       f4 = MathUtils.cosDeg(paramFloat9);
/*  837 */       f5 = MathUtils.sinDeg(paramFloat9);
/*      */       
/*  839 */       paramFloat9 = f4 * paramFloat5 - f5 * paramFloat6;
/*  840 */       paramFloat5 = f5 * paramFloat5 + f4 * paramFloat6;
/*      */       
/*  842 */       paramFloat6 = f4 * paramFloat7 - f5 * paramFloat8;
/*  843 */       paramFloat7 = f5 * paramFloat7 + f4 * paramFloat8;
/*      */       
/*  845 */       paramFloat8 = f4 * f3 - f5 * paramFloat4;
/*  846 */       paramFloat4 = f5 * f3 + f4 * paramFloat4;
/*      */       
/*  848 */       paramFloat3 = paramFloat9 + paramFloat8 - paramFloat6;
/*  849 */       f3 = paramFloat4 - paramFloat7 - paramFloat5;
/*      */     } else {
/*  851 */       paramFloat9 = paramFloat5;
/*  852 */       paramFloat5 = paramFloat6;
/*      */       
/*  854 */       paramFloat6 = paramFloat7;
/*  855 */       paramFloat7 = paramFloat8;
/*      */       
/*  857 */       paramFloat8 = f3;
/*  858 */       paramFloat4 = paramFloat4;
/*      */       
/*  860 */       paramFloat3 = paramFloat3;
/*  861 */       f3 = f4;
/*      */     } 
/*      */     
/*  864 */     paramFloat9 += paramFloat1;
/*  865 */     paramFloat5 += paramFloat2;
/*  866 */     paramFloat6 += paramFloat1;
/*  867 */     paramFloat7 += paramFloat2;
/*  868 */     paramFloat8 += paramFloat1;
/*  869 */     paramFloat4 += paramFloat2;
/*  870 */     paramFloat3 += paramFloat1;
/*  871 */     f3 += paramFloat2;
/*      */ 
/*      */     
/*  874 */     if (paramBoolean) {
/*  875 */       f4 = paramTextureRegion.getU2();
/*  876 */       f5 = paramTextureRegion.getV2();
/*  877 */       paramFloat1 = paramTextureRegion.getU();
/*  878 */       paramFloat2 = paramTextureRegion.getV2();
/*  879 */       f2 = paramTextureRegion.getU();
/*  880 */       f6 = paramTextureRegion.getV();
/*  881 */       f7 = paramTextureRegion.getU2();
/*  882 */       f1 = paramTextureRegion.getV();
/*      */     } else {
/*  884 */       f4 = f1.getU();
/*  885 */       f5 = f1.getV();
/*  886 */       paramFloat1 = f1.getU2();
/*  887 */       paramFloat2 = f1.getV();
/*  888 */       f2 = f1.getU2();
/*  889 */       f6 = f1.getV2();
/*  890 */       f7 = f1.getU();
/*  891 */       f1 = f1.getV2();
/*      */     } 
/*      */     
/*  894 */     float f8 = this.t;
/*  895 */     int i = this.e;
/*  896 */     arrayOfFloat[i] = paramFloat9;
/*  897 */     arrayOfFloat[i + 1] = paramFloat5;
/*  898 */     arrayOfFloat[i + 2] = f8;
/*  899 */     arrayOfFloat[i + 3] = f4;
/*  900 */     arrayOfFloat[i + 4] = f5;
/*      */     
/*  902 */     arrayOfFloat[i + 5] = paramFloat6;
/*  903 */     arrayOfFloat[i + 6] = paramFloat7;
/*  904 */     arrayOfFloat[i + 7] = f8;
/*  905 */     arrayOfFloat[i + 8] = paramFloat1;
/*  906 */     arrayOfFloat[i + 9] = paramFloat2;
/*      */     
/*  908 */     arrayOfFloat[i + 10] = paramFloat8;
/*  909 */     arrayOfFloat[i + 11] = paramFloat4;
/*  910 */     arrayOfFloat[i + 12] = f8;
/*  911 */     arrayOfFloat[i + 13] = f2;
/*  912 */     arrayOfFloat[i + 14] = f6;
/*      */     
/*  914 */     arrayOfFloat[i + 15] = paramFloat3;
/*  915 */     arrayOfFloat[i + 16] = f3;
/*  916 */     arrayOfFloat[i + 17] = f8;
/*  917 */     arrayOfFloat[i + 18] = f7;
/*  918 */     arrayOfFloat[i + 19] = f1;
/*  919 */     this.e = i + 20;
/*      */   }
/*      */ 
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public final void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, Affine2 paramAffine2) {
/*  925 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
/*      */     
/*  927 */     float[] arrayOfFloat = this.d;
/*      */     
/*      */     Texture texture;
/*  930 */     if ((texture = paramTextureRegion.getTexture()) != this.f) {
/*  931 */       a(texture);
/*  932 */     } else if (this.e == arrayOfFloat.length) {
/*  933 */       flush();
/*      */     } 
/*      */ 
/*      */     
/*  937 */     float f3 = paramAffine2.m02;
/*  938 */     float f4 = paramAffine2.m12;
/*  939 */     float f5 = paramAffine2.m01 * paramFloat2 + paramAffine2.m02;
/*  940 */     float f6 = paramAffine2.m11 * paramFloat2 + paramAffine2.m12;
/*  941 */     float f7 = paramAffine2.m00 * paramFloat1 + paramAffine2.m01 * paramFloat2 + paramAffine2.m02;
/*  942 */     paramFloat2 = paramAffine2.m10 * paramFloat1 + paramAffine2.m11 * paramFloat2 + paramAffine2.m12;
/*  943 */     float f8 = paramAffine2.m00 * paramFloat1 + paramAffine2.m02;
/*  944 */     paramFloat1 = paramAffine2.m10 * paramFloat1 + paramAffine2.m12;
/*      */     
/*  946 */     float f2 = paramTextureRegion.getU();
/*  947 */     float f9 = paramTextureRegion.getV2();
/*  948 */     float f10 = paramTextureRegion.getU2();
/*  949 */     float f1 = paramTextureRegion.getV();
/*      */     
/*  951 */     float f11 = this.t;
/*  952 */     int i = this.e;
/*  953 */     arrayOfFloat[i] = f3;
/*  954 */     arrayOfFloat[i + 1] = f4;
/*  955 */     arrayOfFloat[i + 2] = f11;
/*  956 */     arrayOfFloat[i + 3] = f2;
/*  957 */     arrayOfFloat[i + 4] = f9;
/*      */     
/*  959 */     arrayOfFloat[i + 5] = f5;
/*  960 */     arrayOfFloat[i + 6] = f6;
/*  961 */     arrayOfFloat[i + 7] = f11;
/*  962 */     arrayOfFloat[i + 8] = f2;
/*  963 */     arrayOfFloat[i + 9] = f1;
/*      */     
/*  965 */     arrayOfFloat[i + 10] = f7;
/*  966 */     arrayOfFloat[i + 11] = paramFloat2;
/*  967 */     arrayOfFloat[i + 12] = f11;
/*  968 */     arrayOfFloat[i + 13] = f10;
/*  969 */     arrayOfFloat[i + 14] = f1;
/*      */     
/*  971 */     arrayOfFloat[i + 15] = f8;
/*  972 */     arrayOfFloat[i + 16] = paramFloat1;
/*  973 */     arrayOfFloat[i + 17] = f11;
/*  974 */     arrayOfFloat[i + 18] = f10;
/*  975 */     arrayOfFloat[i + 19] = f9;
/*  976 */     this.e = i + 20;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void flush() {
/*  981 */     if (this.e == 0)
/*      */       return; 
/*  983 */     this.renderCalls++;
/*  984 */     this.totalRenderCalls++;
/*      */     int i;
/*  986 */     if ((i = this.e / 20) > this.maxSpritesInBatch) this.maxSpritesInBatch = i; 
/*  987 */     i *= 6;
/*      */     
/*      */     OpFlush opFlush;
/*  990 */     OpFlush.a(opFlush = new OpFlush((byte)0), this.f);
/*  991 */     OpFlush.a(opFlush, this.b.position());
/*  992 */     OpFlush.b(opFlush, this.e);
/*  993 */     OpFlush.c(opFlush, i);
/*      */     
/*  995 */     if (this.b.remaining() < this.e) {
/*      */       
/*  997 */       i = MathUtils.ceil((this.b.position() + this.e << 2) * 1.2F);
/*  998 */       a.i("enlarging allVertices from " + this.b.capacity() + " to " + i, new Object[0]);
/*      */       ByteBuffer byteBuffer;
/* 1000 */       (byteBuffer = ByteBuffer.allocateDirect(i)).order(ByteOrder.nativeOrder());
/* 1001 */       FloatBuffer floatBuffer = this.b;
/* 1002 */       this.b = byteBuffer.asFloatBuffer();
/* 1003 */       floatBuffer.rewind();
/* 1004 */       for (byte b = 0; b < floatBuffer.position(); b++)
/* 1005 */         this.b.put(floatBuffer.get()); 
/* 1006 */       a.i("copied buffer, capacity " + this.b.capacity() + ", remaining " + this.b.remaining(), new Object[0]);
/*      */     } 
/*      */     
/* 1009 */     this.b.put(this.d, 0, this.e);
/* 1010 */     OpFlush.a(opFlush, this.l);
/* 1011 */     OpFlush.d(opFlush, this.m);
/* 1012 */     OpFlush.e(opFlush, this.n);
/* 1013 */     OpFlush.f(opFlush, this.o);
/* 1014 */     OpFlush.g(opFlush, this.p);
/* 1015 */     OpFlush.a(opFlush, (this.r != null) ? this.r : this.q);
/* 1016 */     this.c.add(opFlush);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1031 */     this.e = 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void disableBlending() {
/* 1036 */     if (this.l)
/* 1037 */       return;  flush();
/* 1038 */     this.l = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void enableBlending() {
/* 1043 */     if (!this.l)
/* 1044 */       return;  flush();
/* 1045 */     this.l = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void setBlendFunction(int paramInt1, int paramInt2) {
/* 1050 */     setBlendFunctionSeparate(paramInt1, paramInt2, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void setBlendFunctionSeparate(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1055 */     if (this.m == paramInt1 && this.n == paramInt2 && this.o == paramInt3 && this.p == paramInt4)
/*      */       return; 
/* 1057 */     flush();
/* 1058 */     this.m = paramInt1;
/* 1059 */     this.n = paramInt2;
/* 1060 */     this.o = paramInt3;
/* 1061 */     this.p = paramInt4;
/*      */   }
/*      */ 
/*      */   
/*      */   public final int getBlendSrcFunc() {
/* 1066 */     return this.m;
/*      */   }
/*      */ 
/*      */   
/*      */   public final int getBlendDstFunc() {
/* 1071 */     return this.n;
/*      */   }
/*      */ 
/*      */   
/*      */   public final int getBlendSrcFuncAlpha() {
/* 1076 */     return this.o;
/*      */   }
/*      */ 
/*      */   
/*      */   public final int getBlendDstFuncAlpha() {
/* 1081 */     return this.p;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void dispose() {}
/*      */ 
/*      */ 
/*      */   
/*      */   public final Matrix4 getProjectionMatrix() {
/* 1092 */     return this.j;
/*      */   }
/*      */ 
/*      */   
/*      */   public final Matrix4 getTransformMatrix() {
/* 1097 */     return this.i;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void setProjectionMatrix(Matrix4 paramMatrix4) {
/* 1102 */     if (this.drawing) flush(); 
/* 1103 */     this.j.set(paramMatrix4);
/* 1104 */     if (this.drawing) a();
/*      */   
/*      */   }
/*      */   
/*      */   public final void setTransformMatrix(Matrix4 paramMatrix4) {
/* 1109 */     if (this.drawing) flush(); 
/* 1110 */     this.i.set(paramMatrix4);
/* 1111 */     if (this.drawing) a(); 
/*      */   }
/*      */   
/*      */   private void a() {
/* 1115 */     this.k.set(this.j).mul(this.i);
/*      */     
/* 1117 */     OpSetupMatrices opSetupMatrices = new OpSetupMatrices((byte)0);
/* 1118 */     if (this.r != null) {
/* 1119 */       OpSetupMatrices.a(opSetupMatrices, this.r);
/* 1120 */       OpSetupMatrices.b(opSetupMatrices).set(this.k);
/*      */     } else {
/* 1122 */       OpSetupMatrices.a(opSetupMatrices, this.q);
/* 1123 */       OpSetupMatrices.b(opSetupMatrices).set(this.k);
/*      */     } 
/* 1125 */     this.c.add(opSetupMatrices);
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
/*      */   private void a(Texture paramTexture) {
/* 1137 */     flush();
/* 1138 */     this.f = paramTexture;
/* 1139 */     this.g = 1.0F / paramTexture.getWidth();
/* 1140 */     this.h = 1.0F / paramTexture.getHeight();
/*      */   }
/*      */ 
/*      */   
/*      */   public final void setShader(ShaderProgram paramShaderProgram) {
/* 1145 */     if (this.drawing) {
/* 1146 */       flush();
/*      */     }
/* 1148 */     this.r = paramShaderProgram;
/* 1149 */     if (this.drawing) {
/* 1150 */       if (this.r != null) {
/* 1151 */         this.r.bind();
/*      */       } else {
/* 1153 */         this.q.bind();
/* 1154 */       }  a();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final ShaderProgram getShader() {
/* 1160 */     if (this.r == null) {
/* 1161 */       return this.q;
/*      */     }
/* 1163 */     return this.r;
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean isBlendingEnabled() {
/* 1168 */     return !this.l;
/*      */   }
/*      */   
/*      */   public final boolean isDrawing() {
/* 1172 */     return this.drawing;
/*      */   }
/*      */   
/*      */   private static final class OpBegin {
/*      */     private ShaderProgram a;
/*      */     
/*      */     private OpBegin() {} }
/*      */   
/*      */   private static final class OpSetupMatrices { private ShaderProgram a;
/* 1181 */     private Matrix4 b = new Matrix4();
/*      */     
/*      */     private OpSetupMatrices() {} }
/*      */ 
/*      */   
/*      */   private static final class OpEnd {
/*      */     private boolean a;
/*      */     
/*      */     private OpEnd() {}
/*      */   }
/*      */   
/*      */   private static final class OpFlush {
/*      */     private ShaderProgram a;
/*      */     private Texture b;
/*      */     private int c;
/*      */     private int d;
/*      */     private int e;
/*      */     private boolean f;
/*      */     private int g;
/*      */     private int h;
/*      */     private int i;
/*      */     private int j;
/*      */     
/*      */     private OpFlush() {}
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\ParallelBatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */