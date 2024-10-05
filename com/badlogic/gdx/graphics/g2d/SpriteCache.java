/*      */ package com.badlogic.gdx.graphics.g2d;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.GL20;
/*      */ import com.badlogic.gdx.graphics.Mesh;
/*      */ import com.badlogic.gdx.graphics.Texture;
/*      */ import com.badlogic.gdx.graphics.VertexAttribute;
/*      */ import com.badlogic.gdx.graphics.glutils.ShaderProgram;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.Matrix4;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.Disposable;
/*      */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*      */ import com.badlogic.gdx.utils.IntArray;
/*      */ import java.nio.FloatBuffer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class SpriteCache
/*      */   implements Disposable
/*      */ {
/*   70 */   private static final float[] tempVertices = new float[30];
/*      */   
/*      */   private final Mesh mesh;
/*      */   private boolean drawing;
/*   74 */   private final Matrix4 transformMatrix = new Matrix4();
/*   75 */   private final Matrix4 projectionMatrix = new Matrix4();
/*   76 */   private Array<Cache> caches = new Array();
/*      */   
/*   78 */   private final Matrix4 combinedMatrix = new Matrix4();
/*      */   
/*      */   private final ShaderProgram shader;
/*      */   private Cache currentCache;
/*   82 */   private final Array<Texture> textures = new Array(8);
/*   83 */   private final IntArray counts = new IntArray(8);
/*      */   
/*   85 */   private final Color color = new Color(1.0F, 1.0F, 1.0F, 1.0F);
/*   86 */   private float colorPacked = Color.WHITE_FLOAT_BITS;
/*      */   
/*   88 */   private ShaderProgram customShader = null;
/*      */ 
/*      */   
/*   91 */   public int renderCalls = 0;
/*      */ 
/*      */   
/*   94 */   public int totalRenderCalls = 0;
/*      */ 
/*      */   
/*      */   public SpriteCache() {
/*   98 */     this(1000, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SpriteCache(int paramInt, boolean paramBoolean) {
/*  106 */     this(paramInt, createDefaultShader(), paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SpriteCache(int paramInt, ShaderProgram paramShaderProgram, boolean paramBoolean) {
/*  114 */     this.shader = paramShaderProgram;
/*      */     
/*  116 */     if (paramBoolean && paramInt > 8191) throw new IllegalArgumentException("Can't have more than 8191 sprites per batch: " + paramInt);
/*      */     
/*  118 */     this.mesh = new Mesh(true, paramInt * (paramBoolean ? 4 : 6), paramBoolean ? (paramInt * 6) : 0, new VertexAttribute[] { new VertexAttribute(1, 2, "a_position"), new VertexAttribute(4, 4, "a_color"), new VertexAttribute(16, 2, "a_texCoord0") });
/*      */ 
/*      */ 
/*      */     
/*  122 */     this.mesh.setAutoBind(false);
/*      */     
/*  124 */     if (paramBoolean) {
/*      */       
/*  126 */       short[] arrayOfShort = new short[paramInt = paramInt * 6];
/*  127 */       paramBoolean = false;
/*  128 */       for (byte b = 0; b < paramInt; b += 6, s = (short)(paramBoolean + 4)) {
/*  129 */         short s; arrayOfShort[b] = paramBoolean;
/*  130 */         arrayOfShort[b + 1] = (short)(paramBoolean + 1);
/*  131 */         arrayOfShort[b + 2] = (short)(paramBoolean + 2);
/*  132 */         arrayOfShort[b + 3] = (short)(paramBoolean + 2);
/*  133 */         arrayOfShort[b + 4] = (short)(paramBoolean + 3);
/*  134 */         arrayOfShort[b + 5] = paramBoolean;
/*      */       } 
/*  136 */       this.mesh.setIndices(arrayOfShort);
/*      */     } 
/*      */     
/*  139 */     this.projectionMatrix.setToOrtho2D(0.0F, 0.0F, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
/*      */   }
/*      */ 
/*      */   
/*      */   public void setColor(Color paramColor) {
/*  144 */     this.color.set(paramColor);
/*  145 */     this.colorPacked = paramColor.toFloatBits();
/*      */   }
/*      */ 
/*      */   
/*      */   public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  150 */     this.color.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*  151 */     this.colorPacked = this.color.toFloatBits();
/*      */   }
/*      */   
/*      */   public Color getColor() {
/*  155 */     return this.color;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPackedColor(float paramFloat) {
/*  161 */     Color.abgr8888ToColor(this.color, paramFloat);
/*  162 */     this.colorPacked = paramFloat;
/*      */   }
/*      */   
/*      */   public float getPackedColor() {
/*  166 */     return this.colorPacked;
/*      */   }
/*      */ 
/*      */   
/*      */   public void beginCache() {
/*  171 */     if (this.drawing) throw new IllegalStateException("end must be called before beginCache"); 
/*  172 */     if (this.currentCache != null) throw new IllegalStateException("endCache must be called before begin."); 
/*  173 */     this.mesh.getNumIndices();
/*  174 */     FloatBuffer floatBuffer = this.mesh.getVerticesBuffer(true);
/*  175 */     this.currentCache = new Cache(this.caches.size, floatBuffer.limit());
/*  176 */     this.caches.add(this.currentCache);
/*  177 */     floatBuffer.compact();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void beginCache(int paramInt) {
/*      */     Cache cache;
/*  184 */     if (this.drawing) throw new IllegalStateException("end must be called before beginCache"); 
/*  185 */     if (this.currentCache != null) throw new IllegalStateException("endCache must be called before begin."); 
/*  186 */     FloatBuffer floatBuffer = this.mesh.getVerticesBuffer(true);
/*  187 */     if (paramInt == this.caches.size - 1) {
/*  188 */       cache = (Cache)this.caches.removeIndex(paramInt);
/*  189 */       floatBuffer.limit(cache.offset);
/*  190 */       beginCache();
/*      */       return;
/*      */     } 
/*  193 */     this.currentCache = (Cache)this.caches.get(cache);
/*  194 */     floatBuffer.position(this.currentCache.offset);
/*      */   }
/*      */ 
/*      */   
/*      */   public int endCache() {
/*  199 */     if (this.currentCache == null) throw new IllegalStateException("beginCache must be called before endCache."); 
/*  200 */     Cache cache = this.currentCache;
/*  201 */     int i = this.mesh.getVerticesBuffer(false).position() - cache.offset;
/*  202 */     if (cache.textures == null) {
/*      */       
/*  204 */       cache.maxCount = i;
/*  205 */       cache.textureCount = this.textures.size;
/*  206 */       cache.textures = (Texture[])this.textures.toArray(Texture.class);
/*  207 */       cache.counts = new int[cache.textureCount]; int j;
/*  208 */       for (i = 0, j = this.counts.size; i < j; i++) {
/*  209 */         cache.counts[i] = this.counts.get(i);
/*      */       }
/*  211 */       this.mesh.getVerticesBuffer(true).flip();
/*      */     } else {
/*      */       
/*  214 */       if (i > cache.maxCount) {
/*  215 */         throw new GdxRuntimeException("If a cache is not the last created, it cannot be redefined with more entries than when it was first created: " + i + " (" + cache.maxCount + " max)");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  220 */       cache.textureCount = this.textures.size;
/*      */       
/*  222 */       if (cache.textures.length < cache.textureCount) cache.textures = new Texture[cache.textureCount];  int j;
/*  223 */       for (i = 0, j = cache.textureCount; i < j; i++) {
/*  224 */         cache.textures[i] = (Texture)this.textures.get(i);
/*      */       }
/*  226 */       if (cache.counts.length < cache.textureCount) cache.counts = new int[cache.textureCount]; 
/*  227 */       for (i = 0, j = cache.textureCount; i < j; i++) {
/*  228 */         cache.counts[i] = this.counts.get(i);
/*      */       }
/*      */       FloatBuffer floatBuffer;
/*  231 */       (floatBuffer = this.mesh.getVerticesBuffer(true)).position(0);
/*  232 */       Cache cache1 = (Cache)this.caches.get(this.caches.size - 1);
/*  233 */       floatBuffer.limit(cache1.offset + cache1.maxCount);
/*      */     } 
/*      */     
/*  236 */     this.currentCache = null;
/*  237 */     this.textures.clear();
/*  238 */     this.counts.clear();
/*      */     
/*  240 */     return cache.id;
/*      */   }
/*      */ 
/*      */   
/*      */   public void clear() {
/*  245 */     this.caches.clear();
/*  246 */     this.mesh.getVerticesBuffer(true).clear().flip();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void add(Texture paramTexture, float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/*  253 */     if (this.currentCache == null) throw new IllegalStateException("beginCache must be called before add.");
/*      */     
/*  255 */     int i = (this.mesh.getNumIndices() > 0) ? 4 : 6;
/*  256 */     i = paramInt2 / i * 5 * 6;
/*      */     int j;
/*  258 */     if ((j = this.textures.size - 1) < 0 || this.textures.get(j) != paramTexture) {
/*  259 */       this.textures.add(paramTexture);
/*  260 */       this.counts.add(i);
/*      */     } else {
/*  262 */       this.counts.incr(j, i);
/*      */     } 
/*  264 */     this.mesh.getVerticesBuffer(true).put(paramArrayOffloat, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   public void add(Texture paramTexture, float paramFloat1, float paramFloat2) {
/*  269 */     float f1 = paramFloat1 + paramTexture.getWidth();
/*  270 */     float f2 = paramFloat2 + paramTexture.getHeight();
/*      */     
/*  272 */     tempVertices[0] = paramFloat1;
/*  273 */     tempVertices[1] = paramFloat2;
/*  274 */     tempVertices[2] = this.colorPacked;
/*  275 */     tempVertices[3] = 0.0F;
/*  276 */     tempVertices[4] = 1.0F;
/*      */     
/*  278 */     tempVertices[5] = paramFloat1;
/*  279 */     tempVertices[6] = f2;
/*  280 */     tempVertices[7] = this.colorPacked;
/*  281 */     tempVertices[8] = 0.0F;
/*  282 */     tempVertices[9] = 0.0F;
/*      */     
/*  284 */     tempVertices[10] = f1;
/*  285 */     tempVertices[11] = f2;
/*  286 */     tempVertices[12] = this.colorPacked;
/*  287 */     tempVertices[13] = 1.0F;
/*  288 */     tempVertices[14] = 0.0F;
/*      */     
/*  290 */     if (this.mesh.getNumIndices() > 0) {
/*  291 */       tempVertices[15] = f1;
/*  292 */       tempVertices[16] = paramFloat2;
/*  293 */       tempVertices[17] = this.colorPacked;
/*  294 */       tempVertices[18] = 1.0F;
/*  295 */       tempVertices[19] = 1.0F;
/*  296 */       add(paramTexture, tempVertices, 0, 20); return;
/*      */     } 
/*  298 */     tempVertices[15] = f1;
/*  299 */     tempVertices[16] = f2;
/*  300 */     tempVertices[17] = this.colorPacked;
/*  301 */     tempVertices[18] = 1.0F;
/*  302 */     tempVertices[19] = 0.0F;
/*      */     
/*  304 */     tempVertices[20] = f1;
/*  305 */     tempVertices[21] = paramFloat2;
/*  306 */     tempVertices[22] = this.colorPacked;
/*  307 */     tempVertices[23] = 1.0F;
/*  308 */     tempVertices[24] = 1.0F;
/*      */     
/*  310 */     tempVertices[25] = paramFloat1;
/*  311 */     tempVertices[26] = paramFloat2;
/*  312 */     tempVertices[27] = this.colorPacked;
/*  313 */     tempVertices[28] = 0.0F;
/*  314 */     tempVertices[29] = 1.0F;
/*  315 */     add(paramTexture, tempVertices, 0, 30);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void add(Texture paramTexture, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) {
/*  322 */     float f1 = paramFloat1 + paramInt1;
/*  323 */     float f2 = paramFloat2 + paramInt2;
/*      */     
/*  325 */     tempVertices[0] = paramFloat1;
/*  326 */     tempVertices[1] = paramFloat2;
/*  327 */     tempVertices[2] = paramFloat7;
/*  328 */     tempVertices[3] = paramFloat3;
/*  329 */     tempVertices[4] = paramFloat4;
/*      */     
/*  331 */     tempVertices[5] = paramFloat1;
/*  332 */     tempVertices[6] = f2;
/*  333 */     tempVertices[7] = paramFloat7;
/*  334 */     tempVertices[8] = paramFloat3;
/*  335 */     tempVertices[9] = paramFloat6;
/*      */     
/*  337 */     tempVertices[10] = f1;
/*  338 */     tempVertices[11] = f2;
/*  339 */     tempVertices[12] = paramFloat7;
/*  340 */     tempVertices[13] = paramFloat5;
/*  341 */     tempVertices[14] = paramFloat6;
/*      */     
/*  343 */     if (this.mesh.getNumIndices() > 0) {
/*  344 */       tempVertices[15] = f1;
/*  345 */       tempVertices[16] = paramFloat2;
/*  346 */       tempVertices[17] = paramFloat7;
/*  347 */       tempVertices[18] = paramFloat5;
/*  348 */       tempVertices[19] = paramFloat4;
/*  349 */       add(paramTexture, tempVertices, 0, 20); return;
/*      */     } 
/*  351 */     tempVertices[15] = f1;
/*  352 */     tempVertices[16] = f2;
/*  353 */     tempVertices[17] = paramFloat7;
/*  354 */     tempVertices[18] = paramFloat5;
/*  355 */     tempVertices[19] = paramFloat6;
/*      */     
/*  357 */     tempVertices[20] = f1;
/*  358 */     tempVertices[21] = paramFloat2;
/*  359 */     tempVertices[22] = paramFloat7;
/*  360 */     tempVertices[23] = paramFloat5;
/*  361 */     tempVertices[24] = paramFloat4;
/*      */     
/*  363 */     tempVertices[25] = paramFloat1;
/*  364 */     tempVertices[26] = paramFloat2;
/*  365 */     tempVertices[27] = paramFloat7;
/*  366 */     tempVertices[28] = paramFloat3;
/*  367 */     tempVertices[29] = paramFloat4;
/*  368 */     add(paramTexture, tempVertices, 0, 30);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void add(Texture paramTexture, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  374 */     float f5 = 1.0F / paramTexture.getWidth();
/*  375 */     float f6 = 1.0F / paramTexture.getHeight();
/*  376 */     float f7 = paramInt1 * f5;
/*  377 */     float f8 = (paramInt2 + paramInt4) * f6;
/*  378 */     float f1 = (paramInt1 + paramInt3) * f5;
/*  379 */     float f2 = paramInt2 * f6;
/*  380 */     float f3 = paramFloat1 + paramInt3;
/*  381 */     float f4 = paramFloat2 + paramInt4;
/*      */     
/*  383 */     tempVertices[0] = paramFloat1;
/*  384 */     tempVertices[1] = paramFloat2;
/*  385 */     tempVertices[2] = this.colorPacked;
/*  386 */     tempVertices[3] = f7;
/*  387 */     tempVertices[4] = f8;
/*      */     
/*  389 */     tempVertices[5] = paramFloat1;
/*  390 */     tempVertices[6] = f4;
/*  391 */     tempVertices[7] = this.colorPacked;
/*  392 */     tempVertices[8] = f7;
/*  393 */     tempVertices[9] = f2;
/*      */     
/*  395 */     tempVertices[10] = f3;
/*  396 */     tempVertices[11] = f4;
/*  397 */     tempVertices[12] = this.colorPacked;
/*  398 */     tempVertices[13] = f1;
/*  399 */     tempVertices[14] = f2;
/*      */     
/*  401 */     if (this.mesh.getNumIndices() > 0) {
/*  402 */       tempVertices[15] = f3;
/*  403 */       tempVertices[16] = paramFloat2;
/*  404 */       tempVertices[17] = this.colorPacked;
/*  405 */       tempVertices[18] = f1;
/*  406 */       tempVertices[19] = f8;
/*  407 */       add(paramTexture, tempVertices, 0, 20); return;
/*      */     } 
/*  409 */     tempVertices[15] = f3;
/*  410 */     tempVertices[16] = f4;
/*  411 */     tempVertices[17] = this.colorPacked;
/*  412 */     tempVertices[18] = f1;
/*  413 */     tempVertices[19] = f2;
/*      */     
/*  415 */     tempVertices[20] = f3;
/*  416 */     tempVertices[21] = paramFloat2;
/*  417 */     tempVertices[22] = this.colorPacked;
/*  418 */     tempVertices[23] = f1;
/*  419 */     tempVertices[24] = f8;
/*      */     
/*  421 */     tempVertices[25] = paramFloat1;
/*  422 */     tempVertices[26] = paramFloat2;
/*  423 */     tempVertices[27] = this.colorPacked;
/*  424 */     tempVertices[28] = f7;
/*  425 */     tempVertices[29] = f8;
/*  426 */     add(paramTexture, tempVertices, 0, 30);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void add(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2) {
/*  434 */     float f4 = 1.0F / paramTexture.getWidth();
/*  435 */     float f5 = 1.0F / paramTexture.getHeight();
/*  436 */     float f6 = paramInt1 * f4;
/*  437 */     float f3 = (paramInt2 + paramInt4) * f5;
/*  438 */     float f1 = (paramInt1 + paramInt3) * f4;
/*  439 */     float f2 = paramInt2 * f5;
/*  440 */     paramFloat3 = paramFloat1 + paramFloat3;
/*  441 */     paramFloat4 = paramFloat2 + paramFloat4;
/*      */     
/*  443 */     if (paramBoolean1) {
/*  444 */       float f = f6;
/*  445 */       f6 = f1;
/*  446 */       f1 = f;
/*      */     } 
/*  448 */     if (paramBoolean2) {
/*  449 */       float f = f3;
/*  450 */       f3 = f2;
/*  451 */       f2 = f;
/*      */     } 
/*      */     
/*  454 */     tempVertices[0] = paramFloat1;
/*  455 */     tempVertices[1] = paramFloat2;
/*  456 */     tempVertices[2] = this.colorPacked;
/*  457 */     tempVertices[3] = f6;
/*  458 */     tempVertices[4] = f3;
/*      */     
/*  460 */     tempVertices[5] = paramFloat1;
/*  461 */     tempVertices[6] = paramFloat4;
/*  462 */     tempVertices[7] = this.colorPacked;
/*  463 */     tempVertices[8] = f6;
/*  464 */     tempVertices[9] = f2;
/*      */     
/*  466 */     tempVertices[10] = paramFloat3;
/*  467 */     tempVertices[11] = paramFloat4;
/*  468 */     tempVertices[12] = this.colorPacked;
/*  469 */     tempVertices[13] = f1;
/*  470 */     tempVertices[14] = f2;
/*      */     
/*  472 */     if (this.mesh.getNumIndices() > 0) {
/*  473 */       tempVertices[15] = paramFloat3;
/*  474 */       tempVertices[16] = paramFloat2;
/*  475 */       tempVertices[17] = this.colorPacked;
/*  476 */       tempVertices[18] = f1;
/*  477 */       tempVertices[19] = f3;
/*  478 */       add(paramTexture, tempVertices, 0, 20); return;
/*      */     } 
/*  480 */     tempVertices[15] = paramFloat3;
/*  481 */     tempVertices[16] = paramFloat4;
/*  482 */     tempVertices[17] = this.colorPacked;
/*  483 */     tempVertices[18] = f1;
/*  484 */     tempVertices[19] = f2;
/*      */     
/*  486 */     tempVertices[20] = paramFloat3;
/*  487 */     tempVertices[21] = paramFloat2;
/*  488 */     tempVertices[22] = this.colorPacked;
/*  489 */     tempVertices[23] = f1;
/*  490 */     tempVertices[24] = f3;
/*      */     
/*  492 */     tempVertices[25] = paramFloat1;
/*  493 */     tempVertices[26] = paramFloat2;
/*  494 */     tempVertices[27] = this.colorPacked;
/*  495 */     tempVertices[28] = f6;
/*  496 */     tempVertices[29] = f3;
/*  497 */     add(paramTexture, tempVertices, 0, 30);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void add(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2) {
/*  506 */     paramFloat1 += paramFloat3;
/*  507 */     paramFloat2 += paramFloat4;
/*  508 */     float f3 = -paramFloat3;
/*  509 */     float f4 = -paramFloat4;
/*  510 */     paramFloat3 = paramFloat5 - paramFloat3;
/*  511 */     paramFloat4 = paramFloat6 - paramFloat4;
/*      */ 
/*      */     
/*  514 */     if (paramFloat7 != 1.0F || paramFloat8 != 1.0F) {
/*  515 */       f3 *= paramFloat7;
/*  516 */       f4 *= paramFloat8;
/*  517 */       paramFloat3 *= paramFloat7;
/*  518 */       paramFloat4 *= paramFloat8;
/*      */     } 
/*      */ 
/*      */     
/*  522 */     paramFloat5 = f3;
/*  523 */     paramFloat6 = f4;
/*  524 */     paramFloat7 = f3;
/*  525 */     paramFloat8 = paramFloat4;
/*  526 */     f3 = paramFloat3;
/*  527 */     paramFloat4 = paramFloat4;
/*  528 */     paramFloat3 = paramFloat3;
/*  529 */     f4 = f4;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  541 */     if (paramFloat9 != 0.0F) {
/*  542 */       f4 = MathUtils.cosDeg(paramFloat9);
/*  543 */       float f = MathUtils.sinDeg(paramFloat9);
/*      */       
/*  545 */       paramFloat9 = f4 * paramFloat5 - f * paramFloat6;
/*  546 */       paramFloat5 = f * paramFloat5 + f4 * paramFloat6;
/*      */       
/*  548 */       paramFloat6 = f4 * paramFloat7 - f * paramFloat8;
/*  549 */       paramFloat7 = f * paramFloat7 + f4 * paramFloat8;
/*      */       
/*  551 */       paramFloat8 = f4 * f3 - f * paramFloat4;
/*  552 */       paramFloat4 = f * f3 + f4 * paramFloat4;
/*      */       
/*  554 */       paramFloat3 = paramFloat9 + paramFloat8 - paramFloat6;
/*  555 */       f3 = paramFloat4 - paramFloat7 - paramFloat5;
/*      */     } else {
/*  557 */       paramFloat9 = paramFloat5;
/*  558 */       paramFloat5 = paramFloat6;
/*      */       
/*  560 */       paramFloat6 = paramFloat7;
/*  561 */       paramFloat7 = paramFloat8;
/*      */       
/*  563 */       paramFloat8 = f3;
/*  564 */       paramFloat4 = paramFloat4;
/*      */       
/*  566 */       paramFloat3 = paramFloat3;
/*  567 */       f3 = f4;
/*      */     } 
/*      */     
/*  570 */     paramFloat9 += paramFloat1;
/*  571 */     paramFloat5 += paramFloat2;
/*  572 */     paramFloat6 += paramFloat1;
/*  573 */     paramFloat7 += paramFloat2;
/*  574 */     paramFloat8 += paramFloat1;
/*  575 */     paramFloat4 += paramFloat2;
/*  576 */     paramFloat3 += paramFloat1;
/*  577 */     f3 += paramFloat2;
/*      */     
/*  579 */     f4 = 1.0F / paramTexture.getWidth();
/*  580 */     float f5 = 1.0F / paramTexture.getHeight();
/*  581 */     paramFloat1 = paramInt1 * f4;
/*  582 */     paramFloat2 = (paramInt2 + paramInt4) * f5;
/*  583 */     float f1 = (paramInt1 + paramInt3) * f4;
/*  584 */     float f2 = paramInt2 * f5;
/*      */     
/*  586 */     if (paramBoolean1) {
/*  587 */       float f = paramFloat1;
/*  588 */       paramFloat1 = f1;
/*  589 */       f1 = f;
/*      */     } 
/*      */     
/*  592 */     if (paramBoolean2) {
/*  593 */       float f = paramFloat2;
/*  594 */       paramFloat2 = f2;
/*  595 */       f2 = f;
/*      */     } 
/*      */     
/*  598 */     tempVertices[0] = paramFloat9;
/*  599 */     tempVertices[1] = paramFloat5;
/*  600 */     tempVertices[2] = this.colorPacked;
/*  601 */     tempVertices[3] = paramFloat1;
/*  602 */     tempVertices[4] = paramFloat2;
/*      */     
/*  604 */     tempVertices[5] = paramFloat6;
/*  605 */     tempVertices[6] = paramFloat7;
/*  606 */     tempVertices[7] = this.colorPacked;
/*  607 */     tempVertices[8] = paramFloat1;
/*  608 */     tempVertices[9] = f2;
/*      */     
/*  610 */     tempVertices[10] = paramFloat8;
/*  611 */     tempVertices[11] = paramFloat4;
/*  612 */     tempVertices[12] = this.colorPacked;
/*  613 */     tempVertices[13] = f1;
/*  614 */     tempVertices[14] = f2;
/*      */     
/*  616 */     if (this.mesh.getNumIndices() > 0) {
/*  617 */       tempVertices[15] = paramFloat3;
/*  618 */       tempVertices[16] = f3;
/*  619 */       tempVertices[17] = this.colorPacked;
/*  620 */       tempVertices[18] = f1;
/*  621 */       tempVertices[19] = paramFloat2;
/*  622 */       add(paramTexture, tempVertices, 0, 20); return;
/*      */     } 
/*  624 */     tempVertices[15] = paramFloat8;
/*  625 */     tempVertices[16] = paramFloat4;
/*  626 */     tempVertices[17] = this.colorPacked;
/*  627 */     tempVertices[18] = f1;
/*  628 */     tempVertices[19] = f2;
/*      */     
/*  630 */     tempVertices[20] = paramFloat3;
/*  631 */     tempVertices[21] = f3;
/*  632 */     tempVertices[22] = this.colorPacked;
/*  633 */     tempVertices[23] = f1;
/*  634 */     tempVertices[24] = paramFloat2;
/*      */     
/*  636 */     tempVertices[25] = paramFloat9;
/*  637 */     tempVertices[26] = paramFloat5;
/*  638 */     tempVertices[27] = this.colorPacked;
/*  639 */     tempVertices[28] = paramFloat1;
/*  640 */     tempVertices[29] = paramFloat2;
/*  641 */     add(paramTexture, tempVertices, 0, 30);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void add(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2) {
/*  647 */     add(paramTextureRegion, paramFloat1, paramFloat2, paramTextureRegion.getRegionWidth(), paramTextureRegion.getRegionHeight());
/*      */   }
/*      */ 
/*      */   
/*      */   public void add(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  652 */     paramFloat3 = paramFloat1 + paramFloat3;
/*  653 */     paramFloat4 = paramFloat2 + paramFloat4;
/*  654 */     float f1 = paramTextureRegion.u;
/*  655 */     float f2 = paramTextureRegion.v2;
/*  656 */     float f3 = paramTextureRegion.u2;
/*  657 */     float f4 = paramTextureRegion.v;
/*      */     
/*  659 */     tempVertices[0] = paramFloat1;
/*  660 */     tempVertices[1] = paramFloat2;
/*  661 */     tempVertices[2] = this.colorPacked;
/*  662 */     tempVertices[3] = f1;
/*  663 */     tempVertices[4] = f2;
/*      */     
/*  665 */     tempVertices[5] = paramFloat1;
/*  666 */     tempVertices[6] = paramFloat4;
/*  667 */     tempVertices[7] = this.colorPacked;
/*  668 */     tempVertices[8] = f1;
/*  669 */     tempVertices[9] = f4;
/*      */     
/*  671 */     tempVertices[10] = paramFloat3;
/*  672 */     tempVertices[11] = paramFloat4;
/*  673 */     tempVertices[12] = this.colorPacked;
/*  674 */     tempVertices[13] = f3;
/*  675 */     tempVertices[14] = f4;
/*      */     
/*  677 */     if (this.mesh.getNumIndices() > 0) {
/*  678 */       tempVertices[15] = paramFloat3;
/*  679 */       tempVertices[16] = paramFloat2;
/*  680 */       tempVertices[17] = this.colorPacked;
/*  681 */       tempVertices[18] = f3;
/*  682 */       tempVertices[19] = f2;
/*  683 */       add(paramTextureRegion.texture, tempVertices, 0, 20); return;
/*      */     } 
/*  685 */     tempVertices[15] = paramFloat3;
/*  686 */     tempVertices[16] = paramFloat4;
/*  687 */     tempVertices[17] = this.colorPacked;
/*  688 */     tempVertices[18] = f3;
/*  689 */     tempVertices[19] = f4;
/*      */     
/*  691 */     tempVertices[20] = paramFloat3;
/*  692 */     tempVertices[21] = paramFloat2;
/*  693 */     tempVertices[22] = this.colorPacked;
/*  694 */     tempVertices[23] = f3;
/*  695 */     tempVertices[24] = f2;
/*      */     
/*  697 */     tempVertices[25] = paramFloat1;
/*  698 */     tempVertices[26] = paramFloat2;
/*  699 */     tempVertices[27] = this.colorPacked;
/*  700 */     tempVertices[28] = f1;
/*  701 */     tempVertices[29] = f2;
/*  702 */     add(paramTextureRegion.texture, tempVertices, 0, 30);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void add(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/*  711 */     paramFloat1 += paramFloat3;
/*  712 */     paramFloat2 += paramFloat4;
/*  713 */     float f1 = -paramFloat3;
/*  714 */     float f2 = -paramFloat4;
/*  715 */     paramFloat3 = paramFloat5 - paramFloat3;
/*  716 */     paramFloat4 = paramFloat6 - paramFloat4;
/*      */ 
/*      */     
/*  719 */     if (paramFloat7 != 1.0F || paramFloat8 != 1.0F) {
/*  720 */       f1 *= paramFloat7;
/*  721 */       f2 *= paramFloat8;
/*  722 */       paramFloat3 *= paramFloat7;
/*  723 */       paramFloat4 *= paramFloat8;
/*      */     } 
/*      */ 
/*      */     
/*  727 */     paramFloat5 = f1;
/*  728 */     paramFloat6 = f2;
/*  729 */     paramFloat7 = f1;
/*  730 */     paramFloat8 = paramFloat4;
/*  731 */     f1 = paramFloat3;
/*  732 */     paramFloat4 = paramFloat4;
/*  733 */     paramFloat3 = paramFloat3;
/*  734 */     f2 = f2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  746 */     if (paramFloat9 != 0.0F) {
/*  747 */       f2 = MathUtils.cosDeg(paramFloat9);
/*  748 */       float f = MathUtils.sinDeg(paramFloat9);
/*      */       
/*  750 */       paramFloat9 = f2 * paramFloat5 - f * paramFloat6;
/*  751 */       paramFloat5 = f * paramFloat5 + f2 * paramFloat6;
/*      */       
/*  753 */       paramFloat6 = f2 * paramFloat7 - f * paramFloat8;
/*  754 */       paramFloat7 = f * paramFloat7 + f2 * paramFloat8;
/*      */       
/*  756 */       paramFloat8 = f2 * f1 - f * paramFloat4;
/*  757 */       paramFloat4 = f * f1 + f2 * paramFloat4;
/*      */       
/*  759 */       paramFloat3 = paramFloat9 + paramFloat8 - paramFloat6;
/*  760 */       f1 = paramFloat4 - paramFloat7 - paramFloat5;
/*      */     } else {
/*  762 */       paramFloat9 = paramFloat5;
/*  763 */       paramFloat5 = paramFloat6;
/*      */       
/*  765 */       paramFloat6 = paramFloat7;
/*  766 */       paramFloat7 = paramFloat8;
/*      */       
/*  768 */       paramFloat8 = f1;
/*  769 */       paramFloat4 = paramFloat4;
/*      */       
/*  771 */       paramFloat3 = paramFloat3;
/*  772 */       f1 = f2;
/*      */     } 
/*      */     
/*  775 */     paramFloat9 += paramFloat1;
/*  776 */     paramFloat5 += paramFloat2;
/*  777 */     paramFloat6 += paramFloat1;
/*  778 */     paramFloat7 += paramFloat2;
/*  779 */     paramFloat8 += paramFloat1;
/*  780 */     paramFloat4 += paramFloat2;
/*  781 */     paramFloat3 += paramFloat1;
/*  782 */     f1 += paramFloat2;
/*      */     
/*  784 */     f2 = paramTextureRegion.u;
/*  785 */     float f3 = paramTextureRegion.v2;
/*  786 */     paramFloat1 = paramTextureRegion.u2;
/*  787 */     paramFloat2 = paramTextureRegion.v;
/*      */     
/*  789 */     tempVertices[0] = paramFloat9;
/*  790 */     tempVertices[1] = paramFloat5;
/*  791 */     tempVertices[2] = this.colorPacked;
/*  792 */     tempVertices[3] = f2;
/*  793 */     tempVertices[4] = f3;
/*      */     
/*  795 */     tempVertices[5] = paramFloat6;
/*  796 */     tempVertices[6] = paramFloat7;
/*  797 */     tempVertices[7] = this.colorPacked;
/*  798 */     tempVertices[8] = f2;
/*  799 */     tempVertices[9] = paramFloat2;
/*      */     
/*  801 */     tempVertices[10] = paramFloat8;
/*  802 */     tempVertices[11] = paramFloat4;
/*  803 */     tempVertices[12] = this.colorPacked;
/*  804 */     tempVertices[13] = paramFloat1;
/*  805 */     tempVertices[14] = paramFloat2;
/*      */     
/*  807 */     if (this.mesh.getNumIndices() > 0) {
/*  808 */       tempVertices[15] = paramFloat3;
/*  809 */       tempVertices[16] = f1;
/*  810 */       tempVertices[17] = this.colorPacked;
/*  811 */       tempVertices[18] = paramFloat1;
/*  812 */       tempVertices[19] = f3;
/*  813 */       add(paramTextureRegion.texture, tempVertices, 0, 20); return;
/*      */     } 
/*  815 */     tempVertices[15] = paramFloat8;
/*  816 */     tempVertices[16] = paramFloat4;
/*  817 */     tempVertices[17] = this.colorPacked;
/*  818 */     tempVertices[18] = paramFloat1;
/*  819 */     tempVertices[19] = paramFloat2;
/*      */     
/*  821 */     tempVertices[20] = paramFloat3;
/*  822 */     tempVertices[21] = f1;
/*  823 */     tempVertices[22] = this.colorPacked;
/*  824 */     tempVertices[23] = paramFloat1;
/*  825 */     tempVertices[24] = f3;
/*      */     
/*  827 */     tempVertices[25] = paramFloat9;
/*  828 */     tempVertices[26] = paramFloat5;
/*  829 */     tempVertices[27] = this.colorPacked;
/*  830 */     tempVertices[28] = f2;
/*  831 */     tempVertices[29] = f3;
/*  832 */     add(paramTextureRegion.texture, tempVertices, 0, 30);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void add(Sprite paramSprite) {
/*  838 */     if (this.mesh.getNumIndices() > 0) {
/*  839 */       add(paramSprite.getTexture(), paramSprite.getVertices(), 0, 20);
/*      */       
/*      */       return;
/*      */     } 
/*      */     float[] arrayOfFloat;
/*  844 */     System.arraycopy(arrayOfFloat = paramSprite.getVertices(), 0, tempVertices, 0, 15);
/*  845 */     System.arraycopy(arrayOfFloat, 10, tempVertices, 15, 5);
/*  846 */     System.arraycopy(arrayOfFloat, 15, tempVertices, 20, 5);
/*  847 */     System.arraycopy(arrayOfFloat, 0, tempVertices, 25, 5);
/*  848 */     add(paramSprite.getTexture(), tempVertices, 0, 30);
/*      */   }
/*      */ 
/*      */   
/*      */   public void begin() {
/*  853 */     if (this.drawing) throw new IllegalStateException("end must be called before begin."); 
/*  854 */     if (this.currentCache != null) throw new IllegalStateException("endCache must be called before begin"); 
/*  855 */     this.renderCalls = 0;
/*  856 */     this.combinedMatrix.set(this.projectionMatrix).mul(this.transformMatrix);
/*      */     
/*  858 */     Gdx.gl20.glDepthMask(false);
/*      */     
/*  860 */     if (this.customShader != null) {
/*  861 */       this.customShader.bind();
/*  862 */       this.customShader.setUniformMatrix("u_proj", this.projectionMatrix);
/*  863 */       this.customShader.setUniformMatrix("u_trans", this.transformMatrix);
/*  864 */       this.customShader.setUniformMatrix("u_projTrans", this.combinedMatrix);
/*  865 */       this.customShader.setUniformi("u_texture", 0);
/*  866 */       this.mesh.bind(this.customShader);
/*      */     } else {
/*  868 */       this.shader.bind();
/*  869 */       this.shader.setUniformMatrix("u_projectionViewMatrix", this.combinedMatrix);
/*  870 */       this.shader.setUniformi("u_texture", 0);
/*  871 */       this.mesh.bind(this.shader);
/*      */     } 
/*  873 */     this.drawing = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end() {
/*  878 */     if (!this.drawing) throw new IllegalStateException("begin must be called before end."); 
/*  879 */     this.drawing = false;
/*      */     
/*      */     GL20 gL20;
/*  882 */     (gL20 = Gdx.gl20).glDepthMask(true);
/*  883 */     if (this.customShader != null) {
/*  884 */       this.mesh.unbind(this.customShader); return;
/*      */     } 
/*  886 */     this.mesh.unbind(this.shader);
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(int paramInt) {
/*  891 */     if (!this.drawing) throw new IllegalStateException("SpriteCache.begin must be called before draw.");
/*      */     
/*  893 */     Cache cache = (Cache)this.caches.get(paramInt);
/*  894 */     int j = (this.mesh.getNumIndices() > 0) ? 4 : 6;
/*  895 */     j = cache.offset / j * 5 * 6;
/*  896 */     Texture[] arrayOfTexture = cache.textures;
/*  897 */     int[] arrayOfInt = cache.counts;
/*  898 */     int i = cache.textureCount;
/*  899 */     for (byte b = 0; b < i; b++) {
/*  900 */       int k = arrayOfInt[b];
/*  901 */       arrayOfTexture[b].bind();
/*  902 */       if (this.customShader != null) {
/*  903 */         this.mesh.render(this.customShader, 4, j, k);
/*      */       } else {
/*  905 */         this.mesh.render(this.shader, 4, j, k);
/*  906 */       }  j += k;
/*      */     } 
/*  908 */     this.renderCalls += i;
/*  909 */     this.totalRenderCalls += i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void draw(int paramInt1, int paramInt2, int paramInt3) {
/*  916 */     if (!this.drawing) throw new IllegalStateException("SpriteCache.begin must be called before draw.");
/*      */     
/*  918 */     Cache cache = (Cache)this.caches.get(paramInt1);
/*  919 */     byte b = (this.mesh.getNumIndices() > 0) ? 4 : 6;
/*  920 */     paramInt2 = cache.offset / b * 5 * 6 + paramInt2 * 6;
/*  921 */     paramInt3 *= 6;
/*  922 */     Texture[] arrayOfTexture = cache.textures;
/*  923 */     int[] arrayOfInt = cache.counts;
/*  924 */     int i = cache.textureCount;
/*  925 */     for (int j = 0; j < i; j++) {
/*  926 */       arrayOfTexture[j].bind();
/*      */       int k;
/*  928 */       if ((k = arrayOfInt[j]) > paramInt3) {
/*  929 */         j = i;
/*  930 */         k = paramInt3;
/*      */       } else {
/*  932 */         paramInt3 -= k;
/*  933 */       }  if (this.customShader != null) {
/*  934 */         this.mesh.render(this.customShader, 4, paramInt2, k);
/*      */       } else {
/*  936 */         this.mesh.render(this.shader, 4, paramInt2, k);
/*  937 */       }  paramInt2 += k;
/*      */     } 
/*  939 */     this.renderCalls += cache.textureCount;
/*  940 */     this.totalRenderCalls += i;
/*      */   }
/*      */ 
/*      */   
/*      */   public void dispose() {
/*  945 */     this.mesh.dispose();
/*  946 */     if (this.shader != null) this.shader.dispose(); 
/*      */   }
/*      */   
/*      */   public Matrix4 getProjectionMatrix() {
/*  950 */     return this.projectionMatrix;
/*      */   }
/*      */   
/*      */   public void setProjectionMatrix(Matrix4 paramMatrix4) {
/*  954 */     if (this.drawing) throw new IllegalStateException("Can't set the matrix within begin/end."); 
/*  955 */     this.projectionMatrix.set(paramMatrix4);
/*      */   }
/*      */   
/*      */   public Matrix4 getTransformMatrix() {
/*  959 */     return this.transformMatrix;
/*      */   }
/*      */   
/*      */   public void setTransformMatrix(Matrix4 paramMatrix4) {
/*  963 */     if (this.drawing) throw new IllegalStateException("Can't set the matrix within begin/end."); 
/*  964 */     this.transformMatrix.set(paramMatrix4);
/*      */   }
/*      */   
/*      */   private static class Cache {
/*      */     final int id;
/*      */     final int offset;
/*      */     int maxCount;
/*      */     int textureCount;
/*      */     Texture[] textures;
/*      */     int[] counts;
/*      */     
/*      */     public Cache(int param1Int1, int param1Int2) {
/*  976 */       this.id = param1Int1;
/*  977 */       this.offset = param1Int2;
/*      */     }
/*      */   }
/*      */   
/*      */   static ShaderProgram createDefaultShader() {
/*  982 */     String str1 = "attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projectionViewMatrix;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main()\n{\n   v_color = a_color;\n   v_color.a = v_color.a * (255.0/254.0);\n   v_texCoords = a_texCoord0;\n   gl_Position =  u_projectionViewMatrix * a_position;\n}\n";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  996 */     String str2 = "#ifdef GL_ES\nprecision mediump float;\n#endif\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nvoid main()\n{\n  gl_FragColor = v_color * texture2D(u_texture, v_texCoords);\n}";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     ShaderProgram shaderProgram;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1007 */     if (!(shaderProgram = new ShaderProgram(str1, str2)).isCompiled()) throw new IllegalArgumentException("Error compiling shader: " + shaderProgram.getLog()); 
/* 1008 */     return shaderProgram;
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
/*      */   public void setShader(ShaderProgram paramShaderProgram) {
/* 1021 */     this.customShader = paramShaderProgram;
/*      */   }
/*      */ 
/*      */   
/*      */   public ShaderProgram getCustomShader() {
/* 1026 */     return this.customShader;
/*      */   }
/*      */   
/*      */   public boolean isDrawing() {
/* 1030 */     return this.drawing;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\SpriteCache.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */