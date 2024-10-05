/*      */ package com.badlogic.gdx.graphics.g2d;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.GL20;
/*      */ import com.badlogic.gdx.graphics.Mesh;
/*      */ import com.badlogic.gdx.graphics.Texture;
/*      */ import com.badlogic.gdx.graphics.VertexAttribute;
/*      */ import com.badlogic.gdx.graphics.glutils.ShaderProgram;
/*      */ import com.badlogic.gdx.math.Affine2;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.Matrix4;
/*      */ import java.nio.ShortBuffer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class SpriteBatch
/*      */   implements Batch
/*      */ {
/*      */   @Deprecated
/*   41 */   public static Mesh.VertexDataType defaultVertexDataType = Mesh.VertexDataType.VertexArray;
/*      */   
/*      */   private Mesh mesh;
/*      */   
/*      */   final float[] vertices;
/*   46 */   int idx = 0;
/*   47 */   Texture lastTexture = null;
/*   48 */   float invTexWidth = 0.0F; float invTexHeight = 0.0F;
/*      */   
/*      */   boolean drawing = false;
/*      */   
/*   52 */   private final Matrix4 transformMatrix = new Matrix4();
/*   53 */   private final Matrix4 projectionMatrix = new Matrix4();
/*   54 */   private final Matrix4 combinedMatrix = new Matrix4();
/*      */   
/*      */   private boolean blendingDisabled = false;
/*   57 */   private int blendSrcFunc = 770;
/*   58 */   private int blendDstFunc = 771;
/*   59 */   private int blendSrcFuncAlpha = 770;
/*   60 */   private int blendDstFuncAlpha = 771;
/*      */   
/*      */   private final ShaderProgram shader;
/*   63 */   private ShaderProgram customShader = null;
/*      */   
/*      */   private boolean ownsShader;
/*   66 */   private final Color color = new Color(1.0F, 1.0F, 1.0F, 1.0F);
/*   67 */   float colorPacked = Color.WHITE_FLOAT_BITS;
/*      */ 
/*      */   
/*   70 */   public int renderCalls = 0;
/*      */ 
/*      */   
/*   73 */   public int totalRenderCalls = 0;
/*      */ 
/*      */   
/*   76 */   public int maxSpritesInBatch = 0;
/*      */ 
/*      */ 
/*      */   
/*      */   public SpriteBatch() {
/*   81 */     this(1000, null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public SpriteBatch(int paramInt) {
/*   87 */     this(paramInt, null);
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
/*      */   public SpriteBatch(int paramInt, ShaderProgram paramShaderProgram) {
/*  100 */     if (paramInt > 8191) throw new IllegalArgumentException("Can't have more than 8191 sprites per batch: " + paramInt);
/*      */     
/*  102 */     Mesh.VertexDataType vertexDataType = (Gdx.gl30 != null) ? Mesh.VertexDataType.VertexBufferObjectWithVAO : defaultVertexDataType;
/*      */     
/*  104 */     this.mesh = new Mesh(vertexDataType, false, paramInt << 2, paramInt * 6, new VertexAttribute[] { new VertexAttribute(1, 2, "a_position"), new VertexAttribute(4, 4, "a_color"), new VertexAttribute(16, 2, "a_texCoord0") });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  109 */     this.projectionMatrix.setToOrtho2D(0.0F, 0.0F, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
/*      */     
/*  111 */     this.vertices = new float[paramInt * 20];
/*      */ 
/*      */     
/*  114 */     short[] arrayOfShort = new short[paramInt = paramInt * 6];
/*  115 */     short s = 0;
/*  116 */     for (byte b = 0; b < paramInt; b += 6, s = (short)(s + 4)) {
/*  117 */       arrayOfShort[b] = s;
/*  118 */       arrayOfShort[b + 1] = (short)(s + 1);
/*  119 */       arrayOfShort[b + 2] = (short)(s + 2);
/*  120 */       arrayOfShort[b + 3] = (short)(s + 2);
/*  121 */       arrayOfShort[b + 4] = (short)(s + 3);
/*  122 */       arrayOfShort[b + 5] = s;
/*      */     } 
/*  124 */     this.mesh.setIndices(arrayOfShort);
/*      */     
/*  126 */     if (paramShaderProgram == null) {
/*  127 */       this.shader = createDefaultShader();
/*  128 */       this.ownsShader = true;
/*      */     } else {
/*  130 */       this.shader = paramShaderProgram;
/*      */     } 
/*      */     
/*  133 */     if (vertexDataType != Mesh.VertexDataType.VertexArray) {
/*  134 */       this.mesh.bind(this.shader);
/*  135 */       this.mesh.unbind(this.shader);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static ShaderProgram createDefaultShader() {
/*  141 */     String str1 = "attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projTrans;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main()\n{\n   v_color = a_color;\n   v_color.a = v_color.a * (255.0/254.0);\n   v_texCoords = a_texCoord0;\n   gl_Position =  u_projTrans * a_position;\n}\n";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  155 */     String str2 = "#ifdef GL_ES\n#define LOWP lowp\nprecision mediump float;\n#else\n#define LOWP \n#endif\nvarying LOWP vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nvoid main()\n{\n  gl_FragColor = v_color * texture2D(u_texture, v_texCoords);\n}";
/*      */ 
/*      */ 
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
/*      */ 
/*      */     
/*  170 */     if (!(shaderProgram = new ShaderProgram(str1, str2)).isCompiled()) throw new IllegalArgumentException("Error compiling shader: " + shaderProgram.getLog()); 
/*  171 */     return shaderProgram;
/*      */   }
/*      */ 
/*      */   
/*      */   public void begin() {
/*  176 */     if (this.drawing) throw new IllegalStateException("SpriteBatch.end must be called before begin."); 
/*  177 */     this.renderCalls = 0;
/*      */     
/*  179 */     Gdx.gl.glDepthMask(false);
/*  180 */     if (this.customShader != null) {
/*  181 */       this.customShader.bind();
/*      */     } else {
/*  183 */       this.shader.bind();
/*  184 */     }  setupMatrices();
/*      */     
/*  186 */     this.drawing = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end() {
/*  191 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before end."); 
/*  192 */     if (this.idx > 0) flush(); 
/*  193 */     this.lastTexture = null;
/*  194 */     this.drawing = false;
/*      */     
/*      */     GL20 gL20;
/*  197 */     (gL20 = Gdx.gl).glDepthMask(true);
/*  198 */     if (isBlendingEnabled()) gL20.glDisable(3042);
/*      */   
/*      */   }
/*      */   
/*      */   public void setColor(Color paramColor) {
/*  203 */     this.color.set(paramColor);
/*  204 */     this.colorPacked = paramColor.toFloatBits();
/*      */   }
/*      */ 
/*      */   
/*      */   public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  209 */     this.color.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*  210 */     this.colorPacked = this.color.toFloatBits();
/*      */   }
/*      */ 
/*      */   
/*      */   public Color getColor() {
/*  215 */     return this.color;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPackedColor(float paramFloat) {
/*  220 */     Color.abgr8888ToColor(this.color, paramFloat);
/*  221 */     this.colorPacked = paramFloat;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getPackedColor() {
/*  226 */     return this.colorPacked;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2) {
/*  232 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
/*      */     
/*  234 */     float[] arrayOfFloat = this.vertices;
/*      */     
/*  236 */     if (paramTexture != this.lastTexture) {
/*  237 */       switchTexture(paramTexture);
/*  238 */     } else if (this.idx == arrayOfFloat.length) {
/*  239 */       flush();
/*      */     } 
/*      */     
/*  242 */     float f1 = paramFloat1 + paramFloat3;
/*  243 */     paramFloat1 = paramFloat2 + paramFloat4;
/*  244 */     paramFloat2 = -paramFloat3;
/*  245 */     float f3 = -paramFloat4;
/*  246 */     paramFloat3 = paramFloat5 - paramFloat3;
/*  247 */     paramFloat4 = paramFloat6 - paramFloat4;
/*      */ 
/*      */     
/*  250 */     if (paramFloat7 != 1.0F || paramFloat8 != 1.0F) {
/*  251 */       paramFloat2 *= paramFloat7;
/*  252 */       f3 *= paramFloat8;
/*  253 */       paramFloat3 *= paramFloat7;
/*  254 */       paramFloat4 *= paramFloat8;
/*      */     } 
/*      */ 
/*      */     
/*  258 */     paramFloat5 = paramFloat2;
/*  259 */     paramFloat6 = f3;
/*  260 */     paramFloat2 = paramFloat2;
/*  261 */     paramFloat7 = paramFloat4;
/*  262 */     paramFloat8 = paramFloat3;
/*  263 */     paramFloat4 = paramFloat4;
/*  264 */     paramFloat3 = paramFloat3;
/*  265 */     f3 = f3;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  277 */     if (paramFloat9 != 0.0F) {
/*  278 */       f3 = MathUtils.cosDeg(paramFloat9);
/*  279 */       float f = MathUtils.sinDeg(paramFloat9);
/*      */       
/*  281 */       paramFloat9 = f3 * paramFloat5 - f * paramFloat6;
/*  282 */       paramFloat5 = f * paramFloat5 + f3 * paramFloat6;
/*      */       
/*  284 */       paramFloat6 = f3 * paramFloat2 - f * paramFloat7;
/*  285 */       paramFloat2 = f * paramFloat2 + f3 * paramFloat7;
/*      */       
/*  287 */       paramFloat7 = f3 * paramFloat8 - f * paramFloat4;
/*  288 */       paramFloat4 = f * paramFloat8 + f3 * paramFloat4;
/*      */       
/*  290 */       paramFloat3 = paramFloat9 + paramFloat7 - paramFloat6;
/*  291 */       paramFloat8 = paramFloat4 - paramFloat2 - paramFloat5;
/*      */     } else {
/*  293 */       paramFloat9 = paramFloat5;
/*  294 */       paramFloat5 = paramFloat6;
/*      */       
/*  296 */       paramFloat6 = paramFloat2;
/*  297 */       paramFloat2 = paramFloat7;
/*      */       
/*  299 */       paramFloat7 = paramFloat8;
/*  300 */       paramFloat4 = paramFloat4;
/*      */       
/*  302 */       paramFloat3 = paramFloat3;
/*  303 */       paramFloat8 = f3;
/*      */     } 
/*      */     
/*  306 */     paramFloat9 += f1;
/*  307 */     paramFloat5 += paramFloat1;
/*  308 */     paramFloat6 += f1;
/*  309 */     paramFloat2 += paramFloat1;
/*  310 */     paramFloat7 += f1;
/*  311 */     paramFloat4 += paramFloat1;
/*  312 */     paramFloat3 += f1;
/*  313 */     paramFloat8 += paramFloat1;
/*      */     
/*  315 */     f3 = paramInt1 * this.invTexWidth;
/*  316 */     float f4 = (paramInt2 + paramInt4) * this.invTexHeight;
/*  317 */     f1 = (paramInt1 + paramInt3) * this.invTexWidth;
/*  318 */     paramFloat1 = paramInt2 * this.invTexHeight;
/*      */     
/*  320 */     if (paramBoolean1) {
/*  321 */       float f = f3;
/*  322 */       f3 = f1;
/*  323 */       f1 = f;
/*      */     } 
/*      */     
/*  326 */     if (paramBoolean2) {
/*  327 */       float f = f4;
/*  328 */       f4 = paramFloat1;
/*  329 */       paramFloat1 = f;
/*      */     } 
/*      */     
/*  332 */     float f2 = this.colorPacked;
/*  333 */     paramInt2 = this.idx;
/*  334 */     arrayOfFloat[paramInt2] = paramFloat9;
/*  335 */     arrayOfFloat[paramInt2 + 1] = paramFloat5;
/*  336 */     arrayOfFloat[paramInt2 + 2] = f2;
/*  337 */     arrayOfFloat[paramInt2 + 3] = f3;
/*  338 */     arrayOfFloat[paramInt2 + 4] = f4;
/*      */     
/*  340 */     arrayOfFloat[paramInt2 + 5] = paramFloat6;
/*  341 */     arrayOfFloat[paramInt2 + 6] = paramFloat2;
/*  342 */     arrayOfFloat[paramInt2 + 7] = f2;
/*  343 */     arrayOfFloat[paramInt2 + 8] = f3;
/*  344 */     arrayOfFloat[paramInt2 + 9] = paramFloat1;
/*      */     
/*  346 */     arrayOfFloat[paramInt2 + 10] = paramFloat7;
/*  347 */     arrayOfFloat[paramInt2 + 11] = paramFloat4;
/*  348 */     arrayOfFloat[paramInt2 + 12] = f2;
/*  349 */     arrayOfFloat[paramInt2 + 13] = f1;
/*  350 */     arrayOfFloat[paramInt2 + 14] = paramFloat1;
/*      */     
/*  352 */     arrayOfFloat[paramInt2 + 15] = paramFloat3;
/*  353 */     arrayOfFloat[paramInt2 + 16] = paramFloat8;
/*  354 */     arrayOfFloat[paramInt2 + 17] = f2;
/*  355 */     arrayOfFloat[paramInt2 + 18] = f1;
/*  356 */     arrayOfFloat[paramInt2 + 19] = f4;
/*  357 */     this.idx = paramInt2 + 20;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2) {
/*  363 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
/*      */     
/*  365 */     float[] arrayOfFloat = this.vertices;
/*      */     
/*  367 */     if (paramTexture != this.lastTexture) {
/*  368 */       switchTexture(paramTexture);
/*  369 */     } else if (this.idx == arrayOfFloat.length) {
/*  370 */       flush();
/*      */     } 
/*  372 */     float f1 = paramInt1 * this.invTexWidth;
/*  373 */     float f5 = (paramInt2 + paramInt4) * this.invTexHeight;
/*  374 */     float f2 = (paramInt1 + paramInt3) * this.invTexWidth;
/*  375 */     float f3 = paramInt2 * this.invTexHeight;
/*  376 */     paramFloat3 = paramFloat1 + paramFloat3;
/*  377 */     paramFloat4 = paramFloat2 + paramFloat4;
/*      */     
/*  379 */     if (paramBoolean1) {
/*  380 */       float f = f1;
/*  381 */       f1 = f2;
/*  382 */       f2 = f;
/*      */     } 
/*      */     
/*  385 */     if (paramBoolean2) {
/*  386 */       float f = f5;
/*  387 */       f5 = f3;
/*  388 */       f3 = f;
/*      */     } 
/*      */     
/*  391 */     float f4 = this.colorPacked;
/*  392 */     int i = this.idx;
/*  393 */     arrayOfFloat[i] = paramFloat1;
/*  394 */     arrayOfFloat[i + 1] = paramFloat2;
/*  395 */     arrayOfFloat[i + 2] = f4;
/*  396 */     arrayOfFloat[i + 3] = f1;
/*  397 */     arrayOfFloat[i + 4] = f5;
/*      */     
/*  399 */     arrayOfFloat[i + 5] = paramFloat1;
/*  400 */     arrayOfFloat[i + 6] = paramFloat4;
/*  401 */     arrayOfFloat[i + 7] = f4;
/*  402 */     arrayOfFloat[i + 8] = f1;
/*  403 */     arrayOfFloat[i + 9] = f3;
/*      */     
/*  405 */     arrayOfFloat[i + 10] = paramFloat3;
/*  406 */     arrayOfFloat[i + 11] = paramFloat4;
/*  407 */     arrayOfFloat[i + 12] = f4;
/*  408 */     arrayOfFloat[i + 13] = f2;
/*  409 */     arrayOfFloat[i + 14] = f3;
/*      */     
/*  411 */     arrayOfFloat[i + 15] = paramFloat3;
/*  412 */     arrayOfFloat[i + 16] = paramFloat2;
/*  413 */     arrayOfFloat[i + 17] = f4;
/*  414 */     arrayOfFloat[i + 18] = f2;
/*  415 */     arrayOfFloat[i + 19] = f5;
/*  416 */     this.idx = i + 20;
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  421 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
/*      */     
/*  423 */     float[] arrayOfFloat = this.vertices;
/*      */     
/*  425 */     if (paramTexture != this.lastTexture) {
/*  426 */       switchTexture(paramTexture);
/*  427 */     } else if (this.idx == arrayOfFloat.length) {
/*  428 */       flush();
/*      */     } 
/*  430 */     float f1 = paramInt1 * this.invTexWidth;
/*  431 */     float f6 = (paramInt2 + paramInt4) * this.invTexHeight;
/*  432 */     float f2 = (paramInt1 + paramInt3) * this.invTexWidth;
/*  433 */     float f3 = paramInt2 * this.invTexHeight;
/*  434 */     float f4 = paramFloat1 + paramInt3;
/*  435 */     float f5 = paramFloat2 + paramInt4;
/*      */     
/*  437 */     float f7 = this.colorPacked;
/*  438 */     int i = this.idx;
/*  439 */     arrayOfFloat[i] = paramFloat1;
/*  440 */     arrayOfFloat[i + 1] = paramFloat2;
/*  441 */     arrayOfFloat[i + 2] = f7;
/*  442 */     arrayOfFloat[i + 3] = f1;
/*  443 */     arrayOfFloat[i + 4] = f6;
/*      */     
/*  445 */     arrayOfFloat[i + 5] = paramFloat1;
/*  446 */     arrayOfFloat[i + 6] = f5;
/*  447 */     arrayOfFloat[i + 7] = f7;
/*  448 */     arrayOfFloat[i + 8] = f1;
/*  449 */     arrayOfFloat[i + 9] = f3;
/*      */     
/*  451 */     arrayOfFloat[i + 10] = f4;
/*  452 */     arrayOfFloat[i + 11] = f5;
/*  453 */     arrayOfFloat[i + 12] = f7;
/*  454 */     arrayOfFloat[i + 13] = f2;
/*  455 */     arrayOfFloat[i + 14] = f3;
/*      */     
/*  457 */     arrayOfFloat[i + 15] = f4;
/*  458 */     arrayOfFloat[i + 16] = paramFloat2;
/*  459 */     arrayOfFloat[i + 17] = f7;
/*  460 */     arrayOfFloat[i + 18] = f2;
/*  461 */     arrayOfFloat[i + 19] = f6;
/*  462 */     this.idx = i + 20;
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {
/*  467 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
/*      */     
/*  469 */     float[] arrayOfFloat = this.vertices;
/*      */     
/*  471 */     if (paramTexture != this.lastTexture) {
/*  472 */       switchTexture(paramTexture);
/*  473 */     } else if (this.idx == arrayOfFloat.length) {
/*  474 */       flush();
/*      */     } 
/*  476 */     float f = paramFloat1 + paramFloat3;
/*  477 */     paramFloat3 = paramFloat2 + paramFloat4;
/*      */     
/*  479 */     paramFloat4 = this.colorPacked;
/*  480 */     int i = this.idx;
/*  481 */     arrayOfFloat[i] = paramFloat1;
/*  482 */     arrayOfFloat[i + 1] = paramFloat2;
/*  483 */     arrayOfFloat[i + 2] = paramFloat4;
/*  484 */     arrayOfFloat[i + 3] = paramFloat5;
/*  485 */     arrayOfFloat[i + 4] = paramFloat6;
/*      */     
/*  487 */     arrayOfFloat[i + 5] = paramFloat1;
/*  488 */     arrayOfFloat[i + 6] = paramFloat3;
/*  489 */     arrayOfFloat[i + 7] = paramFloat4;
/*  490 */     arrayOfFloat[i + 8] = paramFloat5;
/*  491 */     arrayOfFloat[i + 9] = paramFloat8;
/*      */     
/*  493 */     arrayOfFloat[i + 10] = f;
/*  494 */     arrayOfFloat[i + 11] = paramFloat3;
/*  495 */     arrayOfFloat[i + 12] = paramFloat4;
/*  496 */     arrayOfFloat[i + 13] = paramFloat7;
/*  497 */     arrayOfFloat[i + 14] = paramFloat8;
/*      */     
/*  499 */     arrayOfFloat[i + 15] = f;
/*  500 */     arrayOfFloat[i + 16] = paramFloat2;
/*  501 */     arrayOfFloat[i + 17] = paramFloat4;
/*  502 */     arrayOfFloat[i + 18] = paramFloat7;
/*  503 */     arrayOfFloat[i + 19] = paramFloat6;
/*  504 */     this.idx = i + 20;
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(Texture paramTexture, float paramFloat1, float paramFloat2) {
/*  509 */     draw(paramTexture, paramFloat1, paramFloat2, paramTexture.getWidth(), paramTexture.getHeight());
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  514 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
/*      */     
/*  516 */     float[] arrayOfFloat = this.vertices;
/*      */     
/*  518 */     if (paramTexture != this.lastTexture) {
/*  519 */       switchTexture(paramTexture);
/*  520 */     } else if (this.idx == arrayOfFloat.length) {
/*  521 */       flush();
/*      */     } 
/*  523 */     float f = paramFloat1 + paramFloat3;
/*  524 */     paramFloat3 = paramFloat2 + paramFloat4;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  530 */     paramFloat4 = this.colorPacked;
/*  531 */     int i = this.idx;
/*  532 */     arrayOfFloat[i] = paramFloat1;
/*  533 */     arrayOfFloat[i + 1] = paramFloat2;
/*  534 */     arrayOfFloat[i + 2] = paramFloat4;
/*  535 */     arrayOfFloat[i + 3] = 0.0F;
/*  536 */     arrayOfFloat[i + 4] = 1.0F;
/*      */     
/*  538 */     arrayOfFloat[i + 5] = paramFloat1;
/*  539 */     arrayOfFloat[i + 6] = paramFloat3;
/*  540 */     arrayOfFloat[i + 7] = paramFloat4;
/*  541 */     arrayOfFloat[i + 8] = 0.0F;
/*  542 */     arrayOfFloat[i + 9] = 0.0F;
/*      */     
/*  544 */     arrayOfFloat[i + 10] = f;
/*  545 */     arrayOfFloat[i + 11] = paramFloat3;
/*  546 */     arrayOfFloat[i + 12] = paramFloat4;
/*  547 */     arrayOfFloat[i + 13] = 1.0F;
/*  548 */     arrayOfFloat[i + 14] = 0.0F;
/*      */     
/*  550 */     arrayOfFloat[i + 15] = f;
/*  551 */     arrayOfFloat[i + 16] = paramFloat2;
/*  552 */     arrayOfFloat[i + 17] = paramFloat4;
/*  553 */     arrayOfFloat[i + 18] = 1.0F;
/*  554 */     arrayOfFloat[i + 19] = 1.0F;
/*  555 */     this.idx = i + 20;
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(Texture paramTexture, float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/*  560 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
/*      */ 
/*      */     
/*  563 */     int j = this.vertices.length, k = j;
/*  564 */     if (paramTexture != this.lastTexture) {
/*  565 */       switchTexture(paramTexture);
/*      */     
/*      */     }
/*  568 */     else if ((k = j - this.idx) == 0) {
/*  569 */       flush();
/*  570 */       k = j;
/*      */     } 
/*      */     
/*  573 */     int i = Math.min(k, paramInt2);
/*      */     
/*  575 */     System.arraycopy(paramArrayOffloat, paramInt1, this.vertices, this.idx, i);
/*  576 */     this.idx += i;
/*  577 */     paramInt2 -= i;
/*  578 */     while (paramInt2 > 0) {
/*  579 */       paramInt1 += i;
/*  580 */       flush();
/*  581 */       i = Math.min(j, paramInt2);
/*  582 */       System.arraycopy(paramArrayOffloat, paramInt1, this.vertices, 0, i);
/*  583 */       this.idx += i;
/*  584 */       paramInt2 -= i;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2) {
/*  590 */     draw(paramTextureRegion, paramFloat1, paramFloat2, paramTextureRegion.getRegionWidth(), paramTextureRegion.getRegionHeight());
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  595 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
/*      */     
/*  597 */     float[] arrayOfFloat = this.vertices;
/*      */     
/*      */     Texture texture;
/*  600 */     if ((texture = paramTextureRegion.texture) != this.lastTexture) {
/*  601 */       switchTexture(texture);
/*  602 */     } else if (this.idx == arrayOfFloat.length) {
/*  603 */       flush();
/*      */     } 
/*  605 */     paramFloat3 = paramFloat1 + paramFloat3;
/*  606 */     paramFloat4 = paramFloat2 + paramFloat4;
/*  607 */     float f2 = paramTextureRegion.u;
/*  608 */     float f3 = paramTextureRegion.v2;
/*  609 */     float f4 = paramTextureRegion.u2;
/*  610 */     float f1 = paramTextureRegion.v;
/*      */     
/*  612 */     float f5 = this.colorPacked;
/*  613 */     int i = this.idx;
/*  614 */     arrayOfFloat[i] = paramFloat1;
/*  615 */     arrayOfFloat[i + 1] = paramFloat2;
/*  616 */     arrayOfFloat[i + 2] = f5;
/*  617 */     arrayOfFloat[i + 3] = f2;
/*  618 */     arrayOfFloat[i + 4] = f3;
/*      */     
/*  620 */     arrayOfFloat[i + 5] = paramFloat1;
/*  621 */     arrayOfFloat[i + 6] = paramFloat4;
/*  622 */     arrayOfFloat[i + 7] = f5;
/*  623 */     arrayOfFloat[i + 8] = f2;
/*  624 */     arrayOfFloat[i + 9] = f1;
/*      */     
/*  626 */     arrayOfFloat[i + 10] = paramFloat3;
/*  627 */     arrayOfFloat[i + 11] = paramFloat4;
/*  628 */     arrayOfFloat[i + 12] = f5;
/*  629 */     arrayOfFloat[i + 13] = f4;
/*  630 */     arrayOfFloat[i + 14] = f1;
/*      */     
/*  632 */     arrayOfFloat[i + 15] = paramFloat3;
/*  633 */     arrayOfFloat[i + 16] = paramFloat2;
/*  634 */     arrayOfFloat[i + 17] = f5;
/*  635 */     arrayOfFloat[i + 18] = f4;
/*  636 */     arrayOfFloat[i + 19] = f3;
/*  637 */     this.idx = i + 20;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/*  643 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
/*      */     
/*  645 */     float[] arrayOfFloat = this.vertices;
/*      */     
/*      */     Texture texture;
/*  648 */     if ((texture = paramTextureRegion.texture) != this.lastTexture) {
/*  649 */       switchTexture(texture);
/*  650 */     } else if (this.idx == arrayOfFloat.length) {
/*  651 */       flush();
/*      */     } 
/*      */     
/*  654 */     paramFloat1 += paramFloat3;
/*  655 */     paramFloat2 += paramFloat4;
/*  656 */     float f2 = -paramFloat3;
/*  657 */     float f3 = -paramFloat4;
/*  658 */     paramFloat3 = paramFloat5 - paramFloat3;
/*  659 */     paramFloat4 = paramFloat6 - paramFloat4;
/*      */ 
/*      */     
/*  662 */     if (paramFloat7 != 1.0F || paramFloat8 != 1.0F) {
/*  663 */       f2 *= paramFloat7;
/*  664 */       f3 *= paramFloat8;
/*  665 */       paramFloat3 *= paramFloat7;
/*  666 */       paramFloat4 *= paramFloat8;
/*      */     } 
/*      */ 
/*      */     
/*  670 */     paramFloat5 = f2;
/*  671 */     paramFloat6 = f3;
/*  672 */     paramFloat7 = f2;
/*  673 */     paramFloat8 = paramFloat4;
/*  674 */     f2 = paramFloat3;
/*  675 */     paramFloat4 = paramFloat4;
/*  676 */     paramFloat3 = paramFloat3;
/*  677 */     f3 = f3;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  689 */     if (paramFloat9 != 0.0F) {
/*  690 */       f3 = MathUtils.cosDeg(paramFloat9);
/*  691 */       float f = MathUtils.sinDeg(paramFloat9);
/*      */       
/*  693 */       paramFloat9 = f3 * paramFloat5 - f * paramFloat6;
/*  694 */       paramFloat5 = f * paramFloat5 + f3 * paramFloat6;
/*      */       
/*  696 */       paramFloat6 = f3 * paramFloat7 - f * paramFloat8;
/*  697 */       paramFloat7 = f * paramFloat7 + f3 * paramFloat8;
/*      */       
/*  699 */       paramFloat8 = f3 * f2 - f * paramFloat4;
/*  700 */       paramFloat4 = f * f2 + f3 * paramFloat4;
/*      */       
/*  702 */       paramFloat3 = paramFloat9 + paramFloat8 - paramFloat6;
/*  703 */       f2 = paramFloat4 - paramFloat7 - paramFloat5;
/*      */     } else {
/*  705 */       paramFloat9 = paramFloat5;
/*  706 */       paramFloat5 = paramFloat6;
/*      */       
/*  708 */       paramFloat6 = paramFloat7;
/*  709 */       paramFloat7 = paramFloat8;
/*      */       
/*  711 */       paramFloat8 = f2;
/*  712 */       paramFloat4 = paramFloat4;
/*      */       
/*  714 */       paramFloat3 = paramFloat3;
/*  715 */       f2 = f3;
/*      */     } 
/*      */     
/*  718 */     paramFloat9 += paramFloat1;
/*  719 */     paramFloat5 += paramFloat2;
/*  720 */     paramFloat6 += paramFloat1;
/*  721 */     paramFloat7 += paramFloat2;
/*  722 */     paramFloat8 += paramFloat1;
/*  723 */     paramFloat4 += paramFloat2;
/*  724 */     paramFloat3 += paramFloat1;
/*  725 */     f2 += paramFloat2;
/*      */     
/*  727 */     f3 = paramTextureRegion.u;
/*  728 */     float f4 = paramTextureRegion.v2;
/*  729 */     paramFloat1 = paramTextureRegion.u2;
/*  730 */     float f1 = paramTextureRegion.v;
/*      */     
/*  732 */     paramFloat2 = this.colorPacked;
/*  733 */     int i = this.idx;
/*  734 */     arrayOfFloat[i] = paramFloat9;
/*  735 */     arrayOfFloat[i + 1] = paramFloat5;
/*  736 */     arrayOfFloat[i + 2] = paramFloat2;
/*  737 */     arrayOfFloat[i + 3] = f3;
/*  738 */     arrayOfFloat[i + 4] = f4;
/*      */     
/*  740 */     arrayOfFloat[i + 5] = paramFloat6;
/*  741 */     arrayOfFloat[i + 6] = paramFloat7;
/*  742 */     arrayOfFloat[i + 7] = paramFloat2;
/*  743 */     arrayOfFloat[i + 8] = f3;
/*  744 */     arrayOfFloat[i + 9] = f1;
/*      */     
/*  746 */     arrayOfFloat[i + 10] = paramFloat8;
/*  747 */     arrayOfFloat[i + 11] = paramFloat4;
/*  748 */     arrayOfFloat[i + 12] = paramFloat2;
/*  749 */     arrayOfFloat[i + 13] = paramFloat1;
/*  750 */     arrayOfFloat[i + 14] = f1;
/*      */     
/*  752 */     arrayOfFloat[i + 15] = paramFloat3;
/*  753 */     arrayOfFloat[i + 16] = f2;
/*  754 */     arrayOfFloat[i + 17] = paramFloat2;
/*  755 */     arrayOfFloat[i + 18] = paramFloat1;
/*  756 */     arrayOfFloat[i + 19] = f4;
/*  757 */     this.idx = i + 20;
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, boolean paramBoolean) {
/*      */     float f1, f2, f5, f6, f7;
/*  763 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
/*      */     
/*  765 */     float[] arrayOfFloat = this.vertices;
/*      */     
/*      */     Texture texture;
/*  768 */     if ((texture = paramTextureRegion.texture) != this.lastTexture) {
/*  769 */       switchTexture(texture);
/*  770 */     } else if (this.idx == arrayOfFloat.length) {
/*  771 */       flush();
/*      */     } 
/*      */     
/*  774 */     paramFloat1 += paramFloat3;
/*  775 */     paramFloat2 += paramFloat4;
/*  776 */     float f3 = -paramFloat3;
/*  777 */     float f4 = -paramFloat4;
/*  778 */     paramFloat3 = paramFloat5 - paramFloat3;
/*  779 */     paramFloat4 = paramFloat6 - paramFloat4;
/*      */ 
/*      */     
/*  782 */     if (paramFloat7 != 1.0F || paramFloat8 != 1.0F) {
/*  783 */       f3 *= paramFloat7;
/*  784 */       f4 *= paramFloat8;
/*  785 */       paramFloat3 *= paramFloat7;
/*  786 */       paramFloat4 *= paramFloat8;
/*      */     } 
/*      */ 
/*      */     
/*  790 */     paramFloat5 = f3;
/*  791 */     paramFloat6 = f4;
/*  792 */     paramFloat7 = f3;
/*  793 */     paramFloat8 = paramFloat4;
/*  794 */     f3 = paramFloat3;
/*  795 */     paramFloat4 = paramFloat4;
/*  796 */     paramFloat3 = paramFloat3;
/*  797 */     f4 = f4;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  809 */     if (paramFloat9 != 0.0F) {
/*  810 */       f4 = MathUtils.cosDeg(paramFloat9);
/*  811 */       f5 = MathUtils.sinDeg(paramFloat9);
/*      */       
/*  813 */       paramFloat9 = f4 * paramFloat5 - f5 * paramFloat6;
/*  814 */       paramFloat5 = f5 * paramFloat5 + f4 * paramFloat6;
/*      */       
/*  816 */       paramFloat6 = f4 * paramFloat7 - f5 * paramFloat8;
/*  817 */       paramFloat7 = f5 * paramFloat7 + f4 * paramFloat8;
/*      */       
/*  819 */       paramFloat8 = f4 * f3 - f5 * paramFloat4;
/*  820 */       paramFloat4 = f5 * f3 + f4 * paramFloat4;
/*      */       
/*  822 */       paramFloat3 = paramFloat9 + paramFloat8 - paramFloat6;
/*  823 */       f3 = paramFloat4 - paramFloat7 - paramFloat5;
/*      */     } else {
/*  825 */       paramFloat9 = paramFloat5;
/*  826 */       paramFloat5 = paramFloat6;
/*      */       
/*  828 */       paramFloat6 = paramFloat7;
/*  829 */       paramFloat7 = paramFloat8;
/*      */       
/*  831 */       paramFloat8 = f3;
/*  832 */       paramFloat4 = paramFloat4;
/*      */       
/*  834 */       paramFloat3 = paramFloat3;
/*  835 */       f3 = f4;
/*      */     } 
/*      */     
/*  838 */     paramFloat9 += paramFloat1;
/*  839 */     paramFloat5 += paramFloat2;
/*  840 */     paramFloat6 += paramFloat1;
/*  841 */     paramFloat7 += paramFloat2;
/*  842 */     paramFloat8 += paramFloat1;
/*  843 */     paramFloat4 += paramFloat2;
/*  844 */     paramFloat3 += paramFloat1;
/*  845 */     f3 += paramFloat2;
/*      */ 
/*      */     
/*  848 */     if (paramBoolean) {
/*  849 */       f4 = paramTextureRegion.u2;
/*  850 */       f5 = paramTextureRegion.v2;
/*  851 */       paramFloat1 = paramTextureRegion.u;
/*  852 */       paramFloat2 = paramTextureRegion.v2;
/*  853 */       f2 = paramTextureRegion.u;
/*  854 */       f6 = paramTextureRegion.v;
/*  855 */       f7 = paramTextureRegion.u2;
/*  856 */       f1 = paramTextureRegion.v;
/*      */     } else {
/*  858 */       f4 = f1.u;
/*  859 */       f5 = f1.v;
/*  860 */       paramFloat1 = f1.u2;
/*  861 */       paramFloat2 = f1.v;
/*  862 */       f2 = f1.u2;
/*  863 */       f6 = f1.v2;
/*  864 */       f7 = f1.u;
/*  865 */       f1 = f1.v2;
/*      */     } 
/*      */     
/*  868 */     float f8 = this.colorPacked;
/*  869 */     int i = this.idx;
/*  870 */     arrayOfFloat[i] = paramFloat9;
/*  871 */     arrayOfFloat[i + 1] = paramFloat5;
/*  872 */     arrayOfFloat[i + 2] = f8;
/*  873 */     arrayOfFloat[i + 3] = f4;
/*  874 */     arrayOfFloat[i + 4] = f5;
/*      */     
/*  876 */     arrayOfFloat[i + 5] = paramFloat6;
/*  877 */     arrayOfFloat[i + 6] = paramFloat7;
/*  878 */     arrayOfFloat[i + 7] = f8;
/*  879 */     arrayOfFloat[i + 8] = paramFloat1;
/*  880 */     arrayOfFloat[i + 9] = paramFloat2;
/*      */     
/*  882 */     arrayOfFloat[i + 10] = paramFloat8;
/*  883 */     arrayOfFloat[i + 11] = paramFloat4;
/*  884 */     arrayOfFloat[i + 12] = f8;
/*  885 */     arrayOfFloat[i + 13] = f2;
/*  886 */     arrayOfFloat[i + 14] = f6;
/*      */     
/*  888 */     arrayOfFloat[i + 15] = paramFloat3;
/*  889 */     arrayOfFloat[i + 16] = f3;
/*  890 */     arrayOfFloat[i + 17] = f8;
/*  891 */     arrayOfFloat[i + 18] = f7;
/*  892 */     arrayOfFloat[i + 19] = f1;
/*  893 */     this.idx = i + 20;
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, Affine2 paramAffine2) {
/*  898 */     if (!this.drawing) throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
/*      */     
/*  900 */     float[] arrayOfFloat = this.vertices;
/*      */     
/*      */     Texture texture;
/*  903 */     if ((texture = paramTextureRegion.texture) != this.lastTexture) {
/*  904 */       switchTexture(texture);
/*  905 */     } else if (this.idx == arrayOfFloat.length) {
/*  906 */       flush();
/*      */     } 
/*      */ 
/*      */     
/*  910 */     float f3 = paramAffine2.m02;
/*  911 */     float f4 = paramAffine2.m12;
/*  912 */     float f5 = paramAffine2.m01 * paramFloat2 + paramAffine2.m02;
/*  913 */     float f6 = paramAffine2.m11 * paramFloat2 + paramAffine2.m12;
/*  914 */     float f7 = paramAffine2.m00 * paramFloat1 + paramAffine2.m01 * paramFloat2 + paramAffine2.m02;
/*  915 */     paramFloat2 = paramAffine2.m10 * paramFloat1 + paramAffine2.m11 * paramFloat2 + paramAffine2.m12;
/*  916 */     float f8 = paramAffine2.m00 * paramFloat1 + paramAffine2.m02;
/*  917 */     paramFloat1 = paramAffine2.m10 * paramFloat1 + paramAffine2.m12;
/*      */     
/*  919 */     float f2 = paramTextureRegion.u;
/*  920 */     float f9 = paramTextureRegion.v2;
/*  921 */     float f10 = paramTextureRegion.u2;
/*  922 */     float f1 = paramTextureRegion.v;
/*      */     
/*  924 */     float f11 = this.colorPacked;
/*  925 */     int i = this.idx;
/*  926 */     arrayOfFloat[i] = f3;
/*  927 */     arrayOfFloat[i + 1] = f4;
/*  928 */     arrayOfFloat[i + 2] = f11;
/*  929 */     arrayOfFloat[i + 3] = f2;
/*  930 */     arrayOfFloat[i + 4] = f9;
/*      */     
/*  932 */     arrayOfFloat[i + 5] = f5;
/*  933 */     arrayOfFloat[i + 6] = f6;
/*  934 */     arrayOfFloat[i + 7] = f11;
/*  935 */     arrayOfFloat[i + 8] = f2;
/*  936 */     arrayOfFloat[i + 9] = f1;
/*      */     
/*  938 */     arrayOfFloat[i + 10] = f7;
/*  939 */     arrayOfFloat[i + 11] = paramFloat2;
/*  940 */     arrayOfFloat[i + 12] = f11;
/*  941 */     arrayOfFloat[i + 13] = f10;
/*  942 */     arrayOfFloat[i + 14] = f1;
/*      */     
/*  944 */     arrayOfFloat[i + 15] = f8;
/*  945 */     arrayOfFloat[i + 16] = paramFloat1;
/*  946 */     arrayOfFloat[i + 17] = f11;
/*  947 */     arrayOfFloat[i + 18] = f10;
/*  948 */     arrayOfFloat[i + 19] = f9;
/*  949 */     this.idx = i + 20;
/*      */   }
/*      */ 
/*      */   
/*      */   public void flush() {
/*  954 */     if (this.idx == 0)
/*      */       return; 
/*  956 */     this.renderCalls++;
/*  957 */     this.totalRenderCalls++;
/*      */     int i;
/*  959 */     if ((i = this.idx / 20) > this.maxSpritesInBatch) this.maxSpritesInBatch = i; 
/*  960 */     i *= 6;
/*      */     
/*  962 */     this.lastTexture.bind();
/*      */     Mesh mesh;
/*  964 */     (mesh = this.mesh).setVertices(this.vertices, 0, this.idx);
/*      */     ShortBuffer shortBuffer;
/*  966 */     (shortBuffer = mesh.getIndicesBuffer(false)).position(0);
/*  967 */     shortBuffer.limit(i);
/*      */     
/*  969 */     if (this.blendingDisabled) {
/*  970 */       Gdx.gl.glDisable(3042);
/*      */     } else {
/*  972 */       Gdx.gl.glEnable(3042);
/*  973 */       if (this.blendSrcFunc != -1) Gdx.gl.glBlendFuncSeparate(this.blendSrcFunc, this.blendDstFunc, this.blendSrcFuncAlpha, this.blendDstFuncAlpha);
/*      */     
/*      */     } 
/*  976 */     mesh.render((this.customShader != null) ? this.customShader : this.shader, 4, 0, i);
/*      */     
/*  978 */     this.idx = 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public void disableBlending() {
/*  983 */     if (this.blendingDisabled)
/*  984 */       return;  flush();
/*  985 */     this.blendingDisabled = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void enableBlending() {
/*  990 */     if (!this.blendingDisabled)
/*  991 */       return;  flush();
/*  992 */     this.blendingDisabled = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setBlendFunction(int paramInt1, int paramInt2) {
/*  997 */     setBlendFunctionSeparate(paramInt1, paramInt2, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setBlendFunctionSeparate(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1002 */     if (this.blendSrcFunc == paramInt1 && this.blendDstFunc == paramInt2 && this.blendSrcFuncAlpha == paramInt3 && this.blendDstFuncAlpha == paramInt4)
/*      */       return; 
/* 1004 */     flush();
/* 1005 */     this.blendSrcFunc = paramInt1;
/* 1006 */     this.blendDstFunc = paramInt2;
/* 1007 */     this.blendSrcFuncAlpha = paramInt3;
/* 1008 */     this.blendDstFuncAlpha = paramInt4;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getBlendSrcFunc() {
/* 1013 */     return this.blendSrcFunc;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getBlendDstFunc() {
/* 1018 */     return this.blendDstFunc;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getBlendSrcFuncAlpha() {
/* 1023 */     return this.blendSrcFuncAlpha;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getBlendDstFuncAlpha() {
/* 1028 */     return this.blendDstFuncAlpha;
/*      */   }
/*      */ 
/*      */   
/*      */   public void dispose() {
/* 1033 */     this.mesh.dispose();
/* 1034 */     if (this.ownsShader && this.shader != null) this.shader.dispose();
/*      */   
/*      */   }
/*      */   
/*      */   public Matrix4 getProjectionMatrix() {
/* 1039 */     return this.projectionMatrix;
/*      */   }
/*      */ 
/*      */   
/*      */   public Matrix4 getTransformMatrix() {
/* 1044 */     return this.transformMatrix;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setProjectionMatrix(Matrix4 paramMatrix4) {
/* 1049 */     if (this.drawing) flush(); 
/* 1050 */     this.projectionMatrix.set(paramMatrix4);
/* 1051 */     if (this.drawing) setupMatrices();
/*      */   
/*      */   }
/*      */   
/*      */   public void setTransformMatrix(Matrix4 paramMatrix4) {
/* 1056 */     if (this.drawing) flush(); 
/* 1057 */     this.transformMatrix.set(paramMatrix4);
/* 1058 */     if (this.drawing) setupMatrices(); 
/*      */   }
/*      */   
/*      */   protected void setupMatrices() {
/* 1062 */     this.combinedMatrix.set(this.projectionMatrix).mul(this.transformMatrix);
/* 1063 */     if (this.customShader != null) {
/* 1064 */       this.customShader.setUniformMatrix("u_projTrans", this.combinedMatrix);
/* 1065 */       this.customShader.setUniformi("u_texture", 0); return;
/*      */     } 
/* 1067 */     this.shader.setUniformMatrix("u_projTrans", this.combinedMatrix);
/* 1068 */     this.shader.setUniformi("u_texture", 0);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void switchTexture(Texture paramTexture) {
/* 1073 */     flush();
/* 1074 */     this.lastTexture = paramTexture;
/* 1075 */     this.invTexWidth = 1.0F / paramTexture.getWidth();
/* 1076 */     this.invTexHeight = 1.0F / paramTexture.getHeight();
/*      */   }
/*      */ 
/*      */   
/*      */   public void setShader(ShaderProgram paramShaderProgram) {
/* 1081 */     if (paramShaderProgram == this.customShader)
/*      */       return; 
/* 1083 */     if (this.drawing) {
/* 1084 */       flush();
/*      */     }
/* 1086 */     this.customShader = paramShaderProgram;
/* 1087 */     if (this.drawing) {
/* 1088 */       if (this.customShader != null) {
/* 1089 */         this.customShader.bind();
/*      */       } else {
/* 1091 */         this.shader.bind();
/* 1092 */       }  setupMatrices();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public ShaderProgram getShader() {
/* 1098 */     if (this.customShader == null) {
/* 1099 */       return this.shader;
/*      */     }
/* 1101 */     return this.customShader;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isBlendingEnabled() {
/* 1106 */     return !this.blendingDisabled;
/*      */   }
/*      */   
/*      */   public boolean isDrawing() {
/* 1110 */     return this.drawing;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\SpriteBatch.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */