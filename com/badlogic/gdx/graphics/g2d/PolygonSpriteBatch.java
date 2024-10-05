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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class PolygonSpriteBatch
/*      */   implements PolygonBatch
/*      */ {
/*      */   private Mesh mesh;
/*      */   private final float[] vertices;
/*      */   private final short[] triangles;
/*      */   private int vertexIndex;
/*      */   private int triangleIndex;
/*      */   private Texture lastTexture;
/*   65 */   private float invTexWidth = 0.0F; private float invTexHeight = 0.0F;
/*      */   
/*      */   private boolean drawing;
/*   68 */   private final Matrix4 transformMatrix = new Matrix4();
/*   69 */   private final Matrix4 projectionMatrix = new Matrix4();
/*   70 */   private final Matrix4 combinedMatrix = new Matrix4();
/*      */   
/*      */   private boolean blendingDisabled;
/*   73 */   private int blendSrcFunc = 770;
/*   74 */   private int blendDstFunc = 771;
/*   75 */   private int blendSrcFuncAlpha = 770;
/*   76 */   private int blendDstFuncAlpha = 771;
/*      */   
/*      */   private final ShaderProgram shader;
/*      */   
/*      */   private ShaderProgram customShader;
/*      */   private boolean ownsShader;
/*   82 */   private final Color color = new Color(1.0F, 1.0F, 1.0F, 1.0F);
/*   83 */   float colorPacked = Color.WHITE_FLOAT_BITS;
/*      */ 
/*      */   
/*   86 */   public int renderCalls = 0;
/*      */ 
/*      */   
/*   89 */   public int totalRenderCalls = 0;
/*      */ 
/*      */   
/*   92 */   public int maxTrianglesInBatch = 0;
/*      */ 
/*      */ 
/*      */   
/*      */   public PolygonSpriteBatch() {
/*   97 */     this(2000, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PolygonSpriteBatch(int paramInt) {
/*  104 */     this(paramInt, paramInt << 1, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PolygonSpriteBatch(int paramInt, ShaderProgram paramShaderProgram) {
/*  111 */     this(paramInt, paramInt << 1, paramShaderProgram);
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
/*      */   public PolygonSpriteBatch(int paramInt1, int paramInt2, ShaderProgram paramShaderProgram) {
/*  126 */     if (paramInt1 > 32767) {
/*  127 */       throw new IllegalArgumentException("Can't have more than 32767 vertices per batch: " + paramInt1);
/*      */     }
/*  129 */     Mesh.VertexDataType vertexDataType = Mesh.VertexDataType.VertexArray;
/*  130 */     if (Gdx.gl30 != null) {
/*  131 */       vertexDataType = Mesh.VertexDataType.VertexBufferObjectWithVAO;
/*      */     }
/*  133 */     this.mesh = new Mesh(vertexDataType, false, paramInt1, paramInt2 * 3, new VertexAttribute[] { new VertexAttribute(1, 2, "a_position"), new VertexAttribute(4, 4, "a_color"), new VertexAttribute(16, 2, "a_texCoord0") });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  138 */     this.vertices = new float[paramInt1 * 5];
/*  139 */     this.triangles = new short[paramInt2 * 3];
/*      */     
/*  141 */     if (paramShaderProgram == null) {
/*  142 */       this.shader = SpriteBatch.createDefaultShader();
/*  143 */       this.ownsShader = true;
/*      */     } else {
/*  145 */       this.shader = paramShaderProgram;
/*      */     } 
/*  147 */     this.projectionMatrix.setToOrtho2D(0.0F, 0.0F, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
/*      */   }
/*      */ 
/*      */   
/*      */   public void begin() {
/*  152 */     if (this.drawing) throw new IllegalStateException("PolygonSpriteBatch.end must be called before begin."); 
/*  153 */     this.renderCalls = 0;
/*      */     
/*  155 */     Gdx.gl.glDepthMask(false);
/*  156 */     if (this.customShader != null) {
/*  157 */       this.customShader.bind();
/*      */     } else {
/*  159 */       this.shader.bind();
/*  160 */     }  setupMatrices();
/*      */     
/*  162 */     this.drawing = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void end() {
/*  167 */     if (!this.drawing) throw new IllegalStateException("PolygonSpriteBatch.begin must be called before end."); 
/*  168 */     if (this.vertexIndex > 0) flush(); 
/*  169 */     this.lastTexture = null;
/*  170 */     this.drawing = false;
/*      */     
/*      */     GL20 gL20;
/*  173 */     (gL20 = Gdx.gl).glDepthMask(true);
/*  174 */     if (isBlendingEnabled()) gL20.glDisable(3042);
/*      */   
/*      */   }
/*      */   
/*      */   public void setColor(Color paramColor) {
/*  179 */     this.color.set(paramColor);
/*  180 */     this.colorPacked = paramColor.toFloatBits();
/*      */   }
/*      */ 
/*      */   
/*      */   public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  185 */     this.color.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*  186 */     this.colorPacked = this.color.toFloatBits();
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPackedColor(float paramFloat) {
/*  191 */     Color.abgr8888ToColor(this.color, paramFloat);
/*  192 */     this.colorPacked = paramFloat;
/*      */   }
/*      */ 
/*      */   
/*      */   public Color getColor() {
/*  197 */     return this.color;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getPackedColor() {
/*  202 */     return this.colorPacked;
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(PolygonRegion paramPolygonRegion, float paramFloat1, float paramFloat2) {
/*  207 */     if (!this.drawing) throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
/*      */     
/*  209 */     short[] arrayOfShort1 = this.triangles;
/*      */     short[] arrayOfShort2;
/*  211 */     int i = (arrayOfShort2 = paramPolygonRegion.triangles).length;
/*      */     float[] arrayOfFloat2;
/*  213 */     int j = (arrayOfFloat2 = paramPolygonRegion.vertices).length;
/*      */     
/*      */     Texture texture;
/*  216 */     if ((texture = paramPolygonRegion.region.texture) != this.lastTexture) {
/*  217 */       switchTexture(texture);
/*  218 */     } else if (this.triangleIndex + i > arrayOfShort1.length || this.vertexIndex + j * 5 / 2 > this.vertices.length) {
/*  219 */       flush();
/*      */     } 
/*  221 */     int k = this.triangleIndex;
/*      */     
/*  223 */     int m, n = (m = this.vertexIndex) / 5;
/*      */     
/*  225 */     for (byte b2 = 0; b2 < i; b2++)
/*  226 */       arrayOfShort1[k++] = (short)(arrayOfShort2[b2] + n); 
/*  227 */     this.triangleIndex = k;
/*      */     
/*  229 */     float[] arrayOfFloat3 = this.vertices;
/*  230 */     float f = this.colorPacked;
/*  231 */     float[] arrayOfFloat1 = paramPolygonRegion.textureCoords;
/*      */     
/*  233 */     for (byte b1 = 0; b1 < j; b1 += 2) {
/*  234 */       arrayOfFloat3[m++] = arrayOfFloat2[b1] + paramFloat1;
/*  235 */       arrayOfFloat3[m++] = arrayOfFloat2[b1 + 1] + paramFloat2;
/*  236 */       arrayOfFloat3[m++] = f;
/*  237 */       arrayOfFloat3[m++] = arrayOfFloat1[b1];
/*  238 */       arrayOfFloat3[m++] = arrayOfFloat1[b1 + 1];
/*      */     } 
/*  240 */     this.vertexIndex = m;
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(PolygonRegion paramPolygonRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  245 */     if (!this.drawing) throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
/*      */     
/*  247 */     short[] arrayOfShort1 = this.triangles;
/*      */     short[] arrayOfShort2;
/*  249 */     int i = (arrayOfShort2 = paramPolygonRegion.triangles).length;
/*      */     float[] arrayOfFloat2;
/*  251 */     int j = (arrayOfFloat2 = paramPolygonRegion.vertices).length;
/*      */     
/*      */     TextureRegion textureRegion;
/*      */     Texture texture;
/*  255 */     if ((texture = (textureRegion = paramPolygonRegion.region).texture) != this.lastTexture) {
/*  256 */       switchTexture(texture);
/*  257 */     } else if (this.triangleIndex + i > arrayOfShort1.length || this.vertexIndex + j * 5 / 2 > this.vertices.length) {
/*  258 */       flush();
/*      */     } 
/*  260 */     i = this.triangleIndex;
/*      */     
/*  262 */     int k, m = (k = this.vertexIndex) / 5; byte b2;
/*      */     int n;
/*  264 */     for (b2 = 0, n = arrayOfShort2.length; b2 < n; b2++)
/*  265 */       arrayOfShort1[i++] = (short)(arrayOfShort2[b2] + m); 
/*  266 */     this.triangleIndex = i;
/*      */     
/*  268 */     float[] arrayOfFloat3 = this.vertices;
/*  269 */     float f = this.colorPacked;
/*  270 */     float[] arrayOfFloat1 = paramPolygonRegion.textureCoords;
/*  271 */     paramFloat3 /= textureRegion.regionWidth;
/*  272 */     paramFloat4 /= textureRegion.regionHeight;
/*      */     
/*  274 */     for (byte b1 = 0; b1 < j; b1 += 2) {
/*  275 */       arrayOfFloat3[k++] = arrayOfFloat2[b1] * paramFloat3 + paramFloat1;
/*  276 */       arrayOfFloat3[k++] = arrayOfFloat2[b1 + 1] * paramFloat4 + paramFloat2;
/*  277 */       arrayOfFloat3[k++] = f;
/*  278 */       arrayOfFloat3[k++] = arrayOfFloat1[b1];
/*  279 */       arrayOfFloat3[k++] = arrayOfFloat1[b1 + 1];
/*      */     } 
/*  281 */     this.vertexIndex = k;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void draw(PolygonRegion paramPolygonRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/*  287 */     if (!this.drawing) throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
/*      */     
/*  289 */     short[] arrayOfShort1 = this.triangles;
/*      */     short[] arrayOfShort2;
/*  291 */     int i = (arrayOfShort2 = paramPolygonRegion.triangles).length;
/*      */     float[] arrayOfFloat2;
/*  293 */     int j = (arrayOfFloat2 = paramPolygonRegion.vertices).length;
/*      */     
/*      */     TextureRegion textureRegion;
/*      */     Texture texture;
/*  297 */     if ((texture = (textureRegion = paramPolygonRegion.region).texture) != this.lastTexture) {
/*  298 */       switchTexture(texture);
/*  299 */     } else if (this.triangleIndex + i > arrayOfShort1.length || this.vertexIndex + j * 5 / 2 > this.vertices.length) {
/*  300 */       flush();
/*      */     } 
/*  302 */     int k = this.triangleIndex;
/*      */     
/*  304 */     int m, n = (m = this.vertexIndex) / 5;
/*      */     
/*  306 */     for (byte b = 0; b < i; b++)
/*  307 */       arrayOfShort1[k++] = (short)(arrayOfShort2[b] + n); 
/*  308 */     this.triangleIndex = k;
/*      */     
/*  310 */     float[] arrayOfFloat3 = this.vertices;
/*  311 */     float f1 = this.colorPacked;
/*  312 */     float[] arrayOfFloat1 = paramPolygonRegion.textureCoords;
/*      */     
/*  314 */     paramFloat1 += paramFloat3;
/*  315 */     paramFloat2 += paramFloat4;
/*  316 */     paramFloat5 /= textureRegion.regionWidth;
/*  317 */     paramFloat6 /= textureRegion.regionHeight;
/*  318 */     float f2 = MathUtils.cosDeg(paramFloat9);
/*  319 */     paramFloat9 = MathUtils.sinDeg(paramFloat9);
/*      */ 
/*      */     
/*  322 */     for (k = 0; k < j; k += 2) {
/*  323 */       float f3 = (arrayOfFloat2[k] * paramFloat5 - paramFloat3) * paramFloat7;
/*  324 */       float f4 = (arrayOfFloat2[k + 1] * paramFloat6 - paramFloat4) * paramFloat8;
/*  325 */       arrayOfFloat3[m++] = f2 * f3 - paramFloat9 * f4 + paramFloat1;
/*  326 */       arrayOfFloat3[m++] = paramFloat9 * f3 + f2 * f4 + paramFloat2;
/*  327 */       arrayOfFloat3[m++] = f1;
/*  328 */       arrayOfFloat3[m++] = arrayOfFloat1[k];
/*  329 */       arrayOfFloat3[m++] = arrayOfFloat1[k + 1];
/*      */     } 
/*  331 */     this.vertexIndex = m;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void draw(Texture paramTexture, float[] paramArrayOffloat, int paramInt1, int paramInt2, short[] paramArrayOfshort, int paramInt3, int paramInt4) {
/*  337 */     if (!this.drawing) throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
/*      */     
/*  339 */     short[] arrayOfShort = this.triangles;
/*  340 */     float[] arrayOfFloat = this.vertices;
/*      */     
/*  342 */     if (paramTexture != this.lastTexture) {
/*  343 */       switchTexture(paramTexture);
/*  344 */     } else if (this.triangleIndex + paramInt4 > arrayOfShort.length || this.vertexIndex + paramInt2 > arrayOfFloat.length) {
/*  345 */       flush();
/*      */     } 
/*  347 */     int i = this.triangleIndex;
/*      */     
/*  349 */     int j, k = (j = this.vertexIndex) / 5;
/*      */     
/*  351 */     for (int m = paramInt3; m < paramInt3; m++)
/*  352 */       arrayOfShort[i++] = (short)(paramArrayOfshort[m] + k); 
/*  353 */     this.triangleIndex = i;
/*      */     
/*  355 */     System.arraycopy(paramArrayOffloat, paramInt1, arrayOfFloat, j, paramInt2);
/*  356 */     this.vertexIndex += paramInt2;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2) {
/*  362 */     if (!this.drawing) throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
/*      */     
/*  364 */     short[] arrayOfShort = this.triangles;
/*  365 */     float[] arrayOfFloat = this.vertices;
/*      */     
/*  367 */     if (paramTexture != this.lastTexture) {
/*  368 */       switchTexture(paramTexture);
/*  369 */     } else if (this.triangleIndex + 6 > arrayOfShort.length || this.vertexIndex + 20 > arrayOfFloat.length) {
/*  370 */       flush();
/*      */     } 
/*  372 */     int i = this.triangleIndex;
/*  373 */     int j = this.vertexIndex / 5;
/*  374 */     arrayOfShort[i++] = (short)j;
/*  375 */     arrayOfShort[i++] = (short)(j + 1);
/*  376 */     arrayOfShort[i++] = (short)(j + 2);
/*  377 */     arrayOfShort[i++] = (short)(j + 2);
/*  378 */     arrayOfShort[i++] = (short)(j + 3);
/*  379 */     arrayOfShort[i++] = (short)j;
/*  380 */     this.triangleIndex = i;
/*      */ 
/*      */     
/*  383 */     float f1 = paramFloat1 + paramFloat3;
/*  384 */     paramFloat1 = paramFloat2 + paramFloat4;
/*  385 */     paramFloat2 = -paramFloat3;
/*  386 */     float f3 = -paramFloat4;
/*  387 */     paramFloat3 = paramFloat5 - paramFloat3;
/*  388 */     paramFloat4 = paramFloat6 - paramFloat4;
/*      */ 
/*      */     
/*  391 */     if (paramFloat7 != 1.0F || paramFloat8 != 1.0F) {
/*  392 */       paramFloat2 *= paramFloat7;
/*  393 */       f3 *= paramFloat8;
/*  394 */       paramFloat3 *= paramFloat7;
/*  395 */       paramFloat4 *= paramFloat8;
/*      */     } 
/*      */ 
/*      */     
/*  399 */     paramFloat5 = paramFloat2;
/*  400 */     paramFloat6 = f3;
/*  401 */     paramFloat2 = paramFloat2;
/*  402 */     paramFloat7 = paramFloat4;
/*  403 */     paramFloat8 = paramFloat3;
/*  404 */     paramFloat4 = paramFloat4;
/*  405 */     paramFloat3 = paramFloat3;
/*  406 */     f3 = f3;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  418 */     if (paramFloat9 != 0.0F) {
/*  419 */       f3 = MathUtils.cosDeg(paramFloat9);
/*  420 */       float f = MathUtils.sinDeg(paramFloat9);
/*      */       
/*  422 */       paramFloat9 = f3 * paramFloat5 - f * paramFloat6;
/*  423 */       paramFloat5 = f * paramFloat5 + f3 * paramFloat6;
/*      */       
/*  425 */       paramFloat6 = f3 * paramFloat2 - f * paramFloat7;
/*  426 */       paramFloat2 = f * paramFloat2 + f3 * paramFloat7;
/*      */       
/*  428 */       paramFloat7 = f3 * paramFloat8 - f * paramFloat4;
/*  429 */       paramFloat4 = f * paramFloat8 + f3 * paramFloat4;
/*      */       
/*  431 */       paramFloat3 = paramFloat9 + paramFloat7 - paramFloat6;
/*  432 */       paramFloat8 = paramFloat4 - paramFloat2 - paramFloat5;
/*      */     } else {
/*  434 */       paramFloat9 = paramFloat5;
/*  435 */       paramFloat5 = paramFloat6;
/*      */       
/*  437 */       paramFloat6 = paramFloat2;
/*  438 */       paramFloat2 = paramFloat7;
/*      */       
/*  440 */       paramFloat7 = paramFloat8;
/*  441 */       paramFloat4 = paramFloat4;
/*      */       
/*  443 */       paramFloat3 = paramFloat3;
/*  444 */       paramFloat8 = f3;
/*      */     } 
/*      */     
/*  447 */     paramFloat9 += f1;
/*  448 */     paramFloat5 += paramFloat1;
/*  449 */     paramFloat6 += f1;
/*  450 */     paramFloat2 += paramFloat1;
/*  451 */     paramFloat7 += f1;
/*  452 */     paramFloat4 += paramFloat1;
/*  453 */     paramFloat3 += f1;
/*  454 */     paramFloat8 += paramFloat1;
/*      */     
/*  456 */     f3 = paramInt1 * this.invTexWidth;
/*  457 */     float f4 = (paramInt2 + paramInt4) * this.invTexHeight;
/*  458 */     f1 = (paramInt1 + paramInt3) * this.invTexWidth;
/*  459 */     paramFloat1 = paramInt2 * this.invTexHeight;
/*      */     
/*  461 */     if (paramBoolean1) {
/*  462 */       float f = f3;
/*  463 */       f3 = f1;
/*  464 */       f1 = f;
/*      */     } 
/*      */     
/*  467 */     if (paramBoolean2) {
/*  468 */       float f = f4;
/*  469 */       f4 = paramFloat1;
/*  470 */       paramFloat1 = f;
/*      */     } 
/*      */     
/*  473 */     float f2 = this.colorPacked;
/*  474 */     paramInt2 = this.vertexIndex;
/*  475 */     arrayOfFloat[paramInt2++] = paramFloat9;
/*  476 */     arrayOfFloat[paramInt2++] = paramFloat5;
/*  477 */     arrayOfFloat[paramInt2++] = f2;
/*  478 */     arrayOfFloat[paramInt2++] = f3;
/*  479 */     arrayOfFloat[paramInt2++] = f4;
/*      */     
/*  481 */     arrayOfFloat[paramInt2++] = paramFloat6;
/*  482 */     arrayOfFloat[paramInt2++] = paramFloat2;
/*  483 */     arrayOfFloat[paramInt2++] = f2;
/*  484 */     arrayOfFloat[paramInt2++] = f3;
/*  485 */     arrayOfFloat[paramInt2++] = paramFloat1;
/*      */     
/*  487 */     arrayOfFloat[paramInt2++] = paramFloat7;
/*  488 */     arrayOfFloat[paramInt2++] = paramFloat4;
/*  489 */     arrayOfFloat[paramInt2++] = f2;
/*  490 */     arrayOfFloat[paramInt2++] = f1;
/*  491 */     arrayOfFloat[paramInt2++] = paramFloat1;
/*      */     
/*  493 */     arrayOfFloat[paramInt2++] = paramFloat3;
/*  494 */     arrayOfFloat[paramInt2++] = paramFloat8;
/*  495 */     arrayOfFloat[paramInt2++] = f2;
/*  496 */     arrayOfFloat[paramInt2++] = f1;
/*  497 */     arrayOfFloat[paramInt2++] = f4;
/*  498 */     this.vertexIndex = paramInt2;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2) {
/*  504 */     if (!this.drawing) throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
/*      */     
/*  506 */     short[] arrayOfShort = this.triangles;
/*  507 */     float[] arrayOfFloat = this.vertices;
/*      */     
/*  509 */     if (paramTexture != this.lastTexture) {
/*  510 */       switchTexture(paramTexture);
/*  511 */     } else if (this.triangleIndex + 6 > arrayOfShort.length || this.vertexIndex + 20 > arrayOfFloat.length) {
/*  512 */       flush();
/*      */     } 
/*  514 */     int i = this.triangleIndex;
/*  515 */     int k = this.vertexIndex / 5;
/*  516 */     arrayOfShort[i++] = (short)k;
/*  517 */     arrayOfShort[i++] = (short)(k + 1);
/*  518 */     arrayOfShort[i++] = (short)(k + 2);
/*  519 */     arrayOfShort[i++] = (short)(k + 2);
/*  520 */     arrayOfShort[i++] = (short)(k + 3);
/*  521 */     arrayOfShort[i++] = (short)k;
/*  522 */     this.triangleIndex = i;
/*      */     
/*  524 */     float f1 = paramInt1 * this.invTexWidth;
/*  525 */     float f5 = (paramInt2 + paramInt4) * this.invTexHeight;
/*  526 */     float f2 = (paramInt1 + paramInt3) * this.invTexWidth;
/*  527 */     float f3 = paramInt2 * this.invTexHeight;
/*  528 */     paramFloat3 = paramFloat1 + paramFloat3;
/*  529 */     paramFloat4 = paramFloat2 + paramFloat4;
/*      */     
/*  531 */     if (paramBoolean1) {
/*  532 */       float f = f1;
/*  533 */       f1 = f2;
/*  534 */       f2 = f;
/*      */     } 
/*      */     
/*  537 */     if (paramBoolean2) {
/*  538 */       float f = f5;
/*  539 */       f5 = f3;
/*  540 */       f3 = f;
/*      */     } 
/*      */     
/*  543 */     float f4 = this.colorPacked;
/*  544 */     int j = this.vertexIndex;
/*  545 */     arrayOfFloat[j++] = paramFloat1;
/*  546 */     arrayOfFloat[j++] = paramFloat2;
/*  547 */     arrayOfFloat[j++] = f4;
/*  548 */     arrayOfFloat[j++] = f1;
/*  549 */     arrayOfFloat[j++] = f5;
/*      */     
/*  551 */     arrayOfFloat[j++] = paramFloat1;
/*  552 */     arrayOfFloat[j++] = paramFloat4;
/*  553 */     arrayOfFloat[j++] = f4;
/*  554 */     arrayOfFloat[j++] = f1;
/*  555 */     arrayOfFloat[j++] = f3;
/*      */     
/*  557 */     arrayOfFloat[j++] = paramFloat3;
/*  558 */     arrayOfFloat[j++] = paramFloat4;
/*  559 */     arrayOfFloat[j++] = f4;
/*  560 */     arrayOfFloat[j++] = f2;
/*  561 */     arrayOfFloat[j++] = f3;
/*      */     
/*  563 */     arrayOfFloat[j++] = paramFloat3;
/*  564 */     arrayOfFloat[j++] = paramFloat2;
/*  565 */     arrayOfFloat[j++] = f4;
/*  566 */     arrayOfFloat[j++] = f2;
/*  567 */     arrayOfFloat[j++] = f5;
/*  568 */     this.vertexIndex = j;
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  573 */     if (!this.drawing) throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
/*      */     
/*  575 */     short[] arrayOfShort = this.triangles;
/*  576 */     float[] arrayOfFloat = this.vertices;
/*      */     
/*  578 */     if (paramTexture != this.lastTexture) {
/*  579 */       switchTexture(paramTexture);
/*  580 */     } else if (this.triangleIndex + 6 > arrayOfShort.length || this.vertexIndex + 20 > arrayOfFloat.length) {
/*  581 */       flush();
/*      */     } 
/*  583 */     int i = this.triangleIndex;
/*  584 */     int j = this.vertexIndex / 5;
/*  585 */     arrayOfShort[i++] = (short)j;
/*  586 */     arrayOfShort[i++] = (short)(j + 1);
/*  587 */     arrayOfShort[i++] = (short)(j + 2);
/*  588 */     arrayOfShort[i++] = (short)(j + 2);
/*  589 */     arrayOfShort[i++] = (short)(j + 3);
/*  590 */     arrayOfShort[i++] = (short)j;
/*  591 */     this.triangleIndex = i;
/*      */     
/*  593 */     float f1 = paramInt1 * this.invTexWidth;
/*  594 */     float f6 = (paramInt2 + paramInt4) * this.invTexHeight;
/*  595 */     float f2 = (paramInt1 + paramInt3) * this.invTexWidth;
/*  596 */     float f3 = paramInt2 * this.invTexHeight;
/*  597 */     float f4 = paramFloat1 + paramInt3;
/*  598 */     float f5 = paramFloat2 + paramInt4;
/*      */     
/*  600 */     float f7 = this.colorPacked;
/*  601 */     int k = this.vertexIndex;
/*  602 */     arrayOfFloat[k++] = paramFloat1;
/*  603 */     arrayOfFloat[k++] = paramFloat2;
/*  604 */     arrayOfFloat[k++] = f7;
/*  605 */     arrayOfFloat[k++] = f1;
/*  606 */     arrayOfFloat[k++] = f6;
/*      */     
/*  608 */     arrayOfFloat[k++] = paramFloat1;
/*  609 */     arrayOfFloat[k++] = f5;
/*  610 */     arrayOfFloat[k++] = f7;
/*  611 */     arrayOfFloat[k++] = f1;
/*  612 */     arrayOfFloat[k++] = f3;
/*      */     
/*  614 */     arrayOfFloat[k++] = f4;
/*  615 */     arrayOfFloat[k++] = f5;
/*  616 */     arrayOfFloat[k++] = f7;
/*  617 */     arrayOfFloat[k++] = f2;
/*  618 */     arrayOfFloat[k++] = f3;
/*      */     
/*  620 */     arrayOfFloat[k++] = f4;
/*  621 */     arrayOfFloat[k++] = paramFloat2;
/*  622 */     arrayOfFloat[k++] = f7;
/*  623 */     arrayOfFloat[k++] = f2;
/*  624 */     arrayOfFloat[k++] = f6;
/*  625 */     this.vertexIndex = k;
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {
/*  630 */     if (!this.drawing) throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
/*      */     
/*  632 */     short[] arrayOfShort = this.triangles;
/*  633 */     float[] arrayOfFloat = this.vertices;
/*      */     
/*  635 */     if (paramTexture != this.lastTexture) {
/*  636 */       switchTexture(paramTexture);
/*  637 */     } else if (this.triangleIndex + 6 > arrayOfShort.length || this.vertexIndex + 20 > arrayOfFloat.length) {
/*  638 */       flush();
/*      */     } 
/*  640 */     int i = this.triangleIndex;
/*  641 */     int k = this.vertexIndex / 5;
/*  642 */     arrayOfShort[i++] = (short)k;
/*  643 */     arrayOfShort[i++] = (short)(k + 1);
/*  644 */     arrayOfShort[i++] = (short)(k + 2);
/*  645 */     arrayOfShort[i++] = (short)(k + 2);
/*  646 */     arrayOfShort[i++] = (short)(k + 3);
/*  647 */     arrayOfShort[i++] = (short)k;
/*  648 */     this.triangleIndex = i;
/*      */     
/*  650 */     float f = paramFloat1 + paramFloat3;
/*  651 */     paramFloat3 = paramFloat2 + paramFloat4;
/*      */     
/*  653 */     paramFloat4 = this.colorPacked;
/*  654 */     int j = this.vertexIndex;
/*  655 */     arrayOfFloat[j++] = paramFloat1;
/*  656 */     arrayOfFloat[j++] = paramFloat2;
/*  657 */     arrayOfFloat[j++] = paramFloat4;
/*  658 */     arrayOfFloat[j++] = paramFloat5;
/*  659 */     arrayOfFloat[j++] = paramFloat6;
/*      */     
/*  661 */     arrayOfFloat[j++] = paramFloat1;
/*  662 */     arrayOfFloat[j++] = paramFloat3;
/*  663 */     arrayOfFloat[j++] = paramFloat4;
/*  664 */     arrayOfFloat[j++] = paramFloat5;
/*  665 */     arrayOfFloat[j++] = paramFloat8;
/*      */     
/*  667 */     arrayOfFloat[j++] = f;
/*  668 */     arrayOfFloat[j++] = paramFloat3;
/*  669 */     arrayOfFloat[j++] = paramFloat4;
/*  670 */     arrayOfFloat[j++] = paramFloat7;
/*  671 */     arrayOfFloat[j++] = paramFloat8;
/*      */     
/*  673 */     arrayOfFloat[j++] = f;
/*  674 */     arrayOfFloat[j++] = paramFloat2;
/*  675 */     arrayOfFloat[j++] = paramFloat4;
/*  676 */     arrayOfFloat[j++] = paramFloat7;
/*  677 */     arrayOfFloat[j++] = paramFloat6;
/*  678 */     this.vertexIndex = j;
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(Texture paramTexture, float paramFloat1, float paramFloat2) {
/*  683 */     draw(paramTexture, paramFloat1, paramFloat2, paramTexture.getWidth(), paramTexture.getHeight());
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  688 */     if (!this.drawing) throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
/*      */     
/*  690 */     short[] arrayOfShort = this.triangles;
/*  691 */     float[] arrayOfFloat = this.vertices;
/*      */     
/*  693 */     if (paramTexture != this.lastTexture) {
/*  694 */       switchTexture(paramTexture);
/*  695 */     } else if (this.triangleIndex + 6 > arrayOfShort.length || this.vertexIndex + 20 > arrayOfFloat.length) {
/*  696 */       flush();
/*      */     } 
/*  698 */     int i = this.triangleIndex;
/*  699 */     int k = this.vertexIndex / 5;
/*  700 */     arrayOfShort[i++] = (short)k;
/*  701 */     arrayOfShort[i++] = (short)(k + 1);
/*  702 */     arrayOfShort[i++] = (short)(k + 2);
/*  703 */     arrayOfShort[i++] = (short)(k + 2);
/*  704 */     arrayOfShort[i++] = (short)(k + 3);
/*  705 */     arrayOfShort[i++] = (short)k;
/*  706 */     this.triangleIndex = i;
/*      */     
/*  708 */     float f = paramFloat1 + paramFloat3;
/*  709 */     paramFloat3 = paramFloat2 + paramFloat4;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  715 */     paramFloat4 = this.colorPacked;
/*  716 */     int j = this.vertexIndex;
/*  717 */     arrayOfFloat[j++] = paramFloat1;
/*  718 */     arrayOfFloat[j++] = paramFloat2;
/*  719 */     arrayOfFloat[j++] = paramFloat4;
/*  720 */     arrayOfFloat[j++] = 0.0F;
/*  721 */     arrayOfFloat[j++] = 1.0F;
/*      */     
/*  723 */     arrayOfFloat[j++] = paramFloat1;
/*  724 */     arrayOfFloat[j++] = paramFloat3;
/*  725 */     arrayOfFloat[j++] = paramFloat4;
/*  726 */     arrayOfFloat[j++] = 0.0F;
/*  727 */     arrayOfFloat[j++] = 0.0F;
/*      */     
/*  729 */     arrayOfFloat[j++] = f;
/*  730 */     arrayOfFloat[j++] = paramFloat3;
/*  731 */     arrayOfFloat[j++] = paramFloat4;
/*  732 */     arrayOfFloat[j++] = 1.0F;
/*  733 */     arrayOfFloat[j++] = 0.0F;
/*      */     
/*  735 */     arrayOfFloat[j++] = f;
/*  736 */     arrayOfFloat[j++] = paramFloat2;
/*  737 */     arrayOfFloat[j++] = paramFloat4;
/*  738 */     arrayOfFloat[j++] = 1.0F;
/*  739 */     arrayOfFloat[j++] = 1.0F;
/*  740 */     this.vertexIndex = j;
/*      */   }
/*      */   
/*      */   public void draw(Texture paramTexture, float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/*      */     int i;
/*  745 */     if (!this.drawing) throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
/*      */     
/*  747 */     short[] arrayOfShort = this.triangles;
/*  748 */     float[] arrayOfFloat = this.vertices;
/*      */     
/*  750 */     int j = paramInt2 / 20 * 6;
/*      */     
/*  752 */     if (paramTexture != this.lastTexture) {
/*  753 */       switchTexture(paramTexture);
/*      */       
/*  755 */       j = (i = Math.min(Math.min(paramInt2, arrayOfFloat.length - arrayOfFloat.length % 20), arrayOfShort.length / 6 * 20)) / 20 * 6;
/*  756 */     } else if (this.triangleIndex + j > arrayOfShort.length || this.vertexIndex + paramInt2 > arrayOfFloat.length) {
/*  757 */       flush();
/*      */       
/*  759 */       j = (i = Math.min(Math.min(paramInt2, arrayOfFloat.length - arrayOfFloat.length % 20), arrayOfShort.length / 6 * 20)) / 20 * 6;
/*      */     } else {
/*  761 */       i = paramInt2;
/*      */     } 
/*      */     int k;
/*  764 */     short s = (short)((k = this.vertexIndex) / 5);
/*      */     int m;
/*  766 */     for (j = (m = this.triangleIndex) + j; m < j; m += 6, s = (short)(s + 4)) {
/*  767 */       arrayOfShort[m] = s;
/*  768 */       arrayOfShort[m + 1] = (short)(s + 1);
/*  769 */       arrayOfShort[m + 2] = (short)(s + 2);
/*  770 */       arrayOfShort[m + 3] = (short)(s + 2);
/*  771 */       arrayOfShort[m + 4] = (short)(s + 3);
/*  772 */       arrayOfShort[m + 5] = s;
/*      */     } 
/*      */ 
/*      */     
/*  776 */     System.arraycopy(paramArrayOffloat, paramInt1, arrayOfFloat, k, i);
/*  777 */     this.vertexIndex = k + i;
/*  778 */     this.triangleIndex = m;
/*      */     
/*  780 */     while ((paramInt2 = paramInt2 - i) != 0) {
/*  781 */       paramInt1 += i;
/*  782 */       flush();
/*  783 */       k = 0;
/*  784 */       if (i > paramInt2)
/*      */       {
/*  786 */         m = (i = Math.min(paramInt2, arrayOfShort.length / 6 * 20)) / 20 * 6;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2) {
/*  793 */     draw(paramTextureRegion, paramFloat1, paramFloat2, paramTextureRegion.getRegionWidth(), paramTextureRegion.getRegionHeight());
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  798 */     if (!this.drawing) throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
/*      */     
/*  800 */     short[] arrayOfShort = this.triangles;
/*  801 */     float[] arrayOfFloat = this.vertices;
/*      */     
/*      */     Texture texture;
/*  804 */     if ((texture = paramTextureRegion.texture) != this.lastTexture) {
/*  805 */       switchTexture(texture);
/*  806 */     } else if (this.triangleIndex + 6 > arrayOfShort.length || this.vertexIndex + 20 > arrayOfFloat.length) {
/*  807 */       flush();
/*      */     } 
/*  809 */     int i = this.triangleIndex;
/*  810 */     int j = this.vertexIndex / 5;
/*  811 */     arrayOfShort[i++] = (short)j;
/*  812 */     arrayOfShort[i++] = (short)(j + 1);
/*  813 */     arrayOfShort[i++] = (short)(j + 2);
/*  814 */     arrayOfShort[i++] = (short)(j + 2);
/*  815 */     arrayOfShort[i++] = (short)(j + 3);
/*  816 */     arrayOfShort[i++] = (short)j;
/*  817 */     this.triangleIndex = i;
/*      */     
/*  819 */     paramFloat3 = paramFloat1 + paramFloat3;
/*  820 */     paramFloat4 = paramFloat2 + paramFloat4;
/*  821 */     float f2 = paramTextureRegion.u;
/*  822 */     float f3 = paramTextureRegion.v2;
/*  823 */     float f4 = paramTextureRegion.u2;
/*  824 */     float f1 = paramTextureRegion.v;
/*      */     
/*  826 */     float f5 = this.colorPacked;
/*  827 */     int k = this.vertexIndex;
/*  828 */     arrayOfFloat[k++] = paramFloat1;
/*  829 */     arrayOfFloat[k++] = paramFloat2;
/*  830 */     arrayOfFloat[k++] = f5;
/*  831 */     arrayOfFloat[k++] = f2;
/*  832 */     arrayOfFloat[k++] = f3;
/*      */     
/*  834 */     arrayOfFloat[k++] = paramFloat1;
/*  835 */     arrayOfFloat[k++] = paramFloat4;
/*  836 */     arrayOfFloat[k++] = f5;
/*  837 */     arrayOfFloat[k++] = f2;
/*  838 */     arrayOfFloat[k++] = f1;
/*      */     
/*  840 */     arrayOfFloat[k++] = paramFloat3;
/*  841 */     arrayOfFloat[k++] = paramFloat4;
/*  842 */     arrayOfFloat[k++] = f5;
/*  843 */     arrayOfFloat[k++] = f4;
/*  844 */     arrayOfFloat[k++] = f1;
/*      */     
/*  846 */     arrayOfFloat[k++] = paramFloat3;
/*  847 */     arrayOfFloat[k++] = paramFloat2;
/*  848 */     arrayOfFloat[k++] = f5;
/*  849 */     arrayOfFloat[k++] = f4;
/*  850 */     arrayOfFloat[k++] = f3;
/*  851 */     this.vertexIndex = k;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/*  857 */     if (!this.drawing) throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
/*      */     
/*  859 */     short[] arrayOfShort = this.triangles;
/*  860 */     float[] arrayOfFloat = this.vertices;
/*      */     
/*      */     Texture texture;
/*  863 */     if ((texture = paramTextureRegion.texture) != this.lastTexture) {
/*  864 */       switchTexture(texture);
/*  865 */     } else if (this.triangleIndex + 6 > arrayOfShort.length || this.vertexIndex + 20 > arrayOfFloat.length) {
/*  866 */       flush();
/*      */     } 
/*  868 */     int i = this.triangleIndex;
/*  869 */     int j = this.vertexIndex / 5;
/*  870 */     arrayOfShort[i++] = (short)j;
/*  871 */     arrayOfShort[i++] = (short)(j + 1);
/*  872 */     arrayOfShort[i++] = (short)(j + 2);
/*  873 */     arrayOfShort[i++] = (short)(j + 2);
/*  874 */     arrayOfShort[i++] = (short)(j + 3);
/*  875 */     arrayOfShort[i++] = (short)j;
/*  876 */     this.triangleIndex = i;
/*      */ 
/*      */     
/*  879 */     paramFloat1 += paramFloat3;
/*  880 */     paramFloat2 += paramFloat4;
/*  881 */     float f2 = -paramFloat3;
/*  882 */     float f3 = -paramFloat4;
/*  883 */     paramFloat3 = paramFloat5 - paramFloat3;
/*  884 */     paramFloat4 = paramFloat6 - paramFloat4;
/*      */ 
/*      */     
/*  887 */     if (paramFloat7 != 1.0F || paramFloat8 != 1.0F) {
/*  888 */       f2 *= paramFloat7;
/*  889 */       f3 *= paramFloat8;
/*  890 */       paramFloat3 *= paramFloat7;
/*  891 */       paramFloat4 *= paramFloat8;
/*      */     } 
/*      */ 
/*      */     
/*  895 */     paramFloat5 = f2;
/*  896 */     paramFloat6 = f3;
/*  897 */     paramFloat7 = f2;
/*  898 */     paramFloat8 = paramFloat4;
/*  899 */     f2 = paramFloat3;
/*  900 */     paramFloat4 = paramFloat4;
/*  901 */     paramFloat3 = paramFloat3;
/*  902 */     f3 = f3;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  914 */     if (paramFloat9 != 0.0F) {
/*  915 */       f3 = MathUtils.cosDeg(paramFloat9);
/*  916 */       float f = MathUtils.sinDeg(paramFloat9);
/*      */       
/*  918 */       paramFloat9 = f3 * paramFloat5 - f * paramFloat6;
/*  919 */       paramFloat5 = f * paramFloat5 + f3 * paramFloat6;
/*      */       
/*  921 */       paramFloat6 = f3 * paramFloat7 - f * paramFloat8;
/*  922 */       paramFloat7 = f * paramFloat7 + f3 * paramFloat8;
/*      */       
/*  924 */       paramFloat8 = f3 * f2 - f * paramFloat4;
/*  925 */       paramFloat4 = f * f2 + f3 * paramFloat4;
/*      */       
/*  927 */       paramFloat3 = paramFloat9 + paramFloat8 - paramFloat6;
/*  928 */       f2 = paramFloat4 - paramFloat7 - paramFloat5;
/*      */     } else {
/*  930 */       paramFloat9 = paramFloat5;
/*  931 */       paramFloat5 = paramFloat6;
/*      */       
/*  933 */       paramFloat6 = paramFloat7;
/*  934 */       paramFloat7 = paramFloat8;
/*      */       
/*  936 */       paramFloat8 = f2;
/*  937 */       paramFloat4 = paramFloat4;
/*      */       
/*  939 */       paramFloat3 = paramFloat3;
/*  940 */       f2 = f3;
/*      */     } 
/*      */     
/*  943 */     paramFloat9 += paramFloat1;
/*  944 */     paramFloat5 += paramFloat2;
/*  945 */     paramFloat6 += paramFloat1;
/*  946 */     paramFloat7 += paramFloat2;
/*  947 */     paramFloat8 += paramFloat1;
/*  948 */     paramFloat4 += paramFloat2;
/*  949 */     paramFloat3 += paramFloat1;
/*  950 */     f2 += paramFloat2;
/*      */     
/*  952 */     f3 = paramTextureRegion.u;
/*  953 */     float f4 = paramTextureRegion.v2;
/*  954 */     paramFloat1 = paramTextureRegion.u2;
/*  955 */     float f1 = paramTextureRegion.v;
/*      */     
/*  957 */     paramFloat2 = this.colorPacked;
/*  958 */     int k = this.vertexIndex;
/*  959 */     arrayOfFloat[k++] = paramFloat9;
/*  960 */     arrayOfFloat[k++] = paramFloat5;
/*  961 */     arrayOfFloat[k++] = paramFloat2;
/*  962 */     arrayOfFloat[k++] = f3;
/*  963 */     arrayOfFloat[k++] = f4;
/*      */     
/*  965 */     arrayOfFloat[k++] = paramFloat6;
/*  966 */     arrayOfFloat[k++] = paramFloat7;
/*  967 */     arrayOfFloat[k++] = paramFloat2;
/*  968 */     arrayOfFloat[k++] = f3;
/*  969 */     arrayOfFloat[k++] = f1;
/*      */     
/*  971 */     arrayOfFloat[k++] = paramFloat8;
/*  972 */     arrayOfFloat[k++] = paramFloat4;
/*  973 */     arrayOfFloat[k++] = paramFloat2;
/*  974 */     arrayOfFloat[k++] = paramFloat1;
/*  975 */     arrayOfFloat[k++] = f1;
/*      */     
/*  977 */     arrayOfFloat[k++] = paramFloat3;
/*  978 */     arrayOfFloat[k++] = f2;
/*  979 */     arrayOfFloat[k++] = paramFloat2;
/*  980 */     arrayOfFloat[k++] = paramFloat1;
/*  981 */     arrayOfFloat[k++] = f4;
/*  982 */     this.vertexIndex = k;
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, boolean paramBoolean) {
/*      */     float f1, f2, f5, f6, f7;
/*  988 */     if (!this.drawing) throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
/*      */     
/*  990 */     short[] arrayOfShort = this.triangles;
/*  991 */     float[] arrayOfFloat = this.vertices;
/*      */     
/*      */     Texture texture;
/*  994 */     if ((texture = paramTextureRegion.texture) != this.lastTexture) {
/*  995 */       switchTexture(texture);
/*  996 */     } else if (this.triangleIndex + 6 > arrayOfShort.length || this.vertexIndex + 20 > arrayOfFloat.length) {
/*  997 */       flush();
/*      */     } 
/*  999 */     int i = this.triangleIndex;
/* 1000 */     int j = this.vertexIndex / 5;
/* 1001 */     arrayOfShort[i++] = (short)j;
/* 1002 */     arrayOfShort[i++] = (short)(j + 1);
/* 1003 */     arrayOfShort[i++] = (short)(j + 2);
/* 1004 */     arrayOfShort[i++] = (short)(j + 2);
/* 1005 */     arrayOfShort[i++] = (short)(j + 3);
/* 1006 */     arrayOfShort[i++] = (short)j;
/* 1007 */     this.triangleIndex = i;
/*      */ 
/*      */     
/* 1010 */     paramFloat1 += paramFloat3;
/* 1011 */     paramFloat2 += paramFloat4;
/* 1012 */     float f3 = -paramFloat3;
/* 1013 */     float f4 = -paramFloat4;
/* 1014 */     paramFloat3 = paramFloat5 - paramFloat3;
/* 1015 */     paramFloat4 = paramFloat6 - paramFloat4;
/*      */ 
/*      */     
/* 1018 */     if (paramFloat7 != 1.0F || paramFloat8 != 1.0F) {
/* 1019 */       f3 *= paramFloat7;
/* 1020 */       f4 *= paramFloat8;
/* 1021 */       paramFloat3 *= paramFloat7;
/* 1022 */       paramFloat4 *= paramFloat8;
/*      */     } 
/*      */ 
/*      */     
/* 1026 */     paramFloat5 = f3;
/* 1027 */     paramFloat6 = f4;
/* 1028 */     paramFloat7 = f3;
/* 1029 */     paramFloat8 = paramFloat4;
/* 1030 */     f3 = paramFloat3;
/* 1031 */     paramFloat4 = paramFloat4;
/* 1032 */     paramFloat3 = paramFloat3;
/* 1033 */     f4 = f4;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1045 */     if (paramFloat9 != 0.0F) {
/* 1046 */       f4 = MathUtils.cosDeg(paramFloat9);
/* 1047 */       f5 = MathUtils.sinDeg(paramFloat9);
/*      */       
/* 1049 */       paramFloat9 = f4 * paramFloat5 - f5 * paramFloat6;
/* 1050 */       paramFloat5 = f5 * paramFloat5 + f4 * paramFloat6;
/*      */       
/* 1052 */       paramFloat6 = f4 * paramFloat7 - f5 * paramFloat8;
/* 1053 */       paramFloat7 = f5 * paramFloat7 + f4 * paramFloat8;
/*      */       
/* 1055 */       paramFloat8 = f4 * f3 - f5 * paramFloat4;
/* 1056 */       paramFloat4 = f5 * f3 + f4 * paramFloat4;
/*      */       
/* 1058 */       paramFloat3 = paramFloat9 + paramFloat8 - paramFloat6;
/* 1059 */       f3 = paramFloat4 - paramFloat7 - paramFloat5;
/*      */     } else {
/* 1061 */       paramFloat9 = paramFloat5;
/* 1062 */       paramFloat5 = paramFloat6;
/*      */       
/* 1064 */       paramFloat6 = paramFloat7;
/* 1065 */       paramFloat7 = paramFloat8;
/*      */       
/* 1067 */       paramFloat8 = f3;
/* 1068 */       paramFloat4 = paramFloat4;
/*      */       
/* 1070 */       paramFloat3 = paramFloat3;
/* 1071 */       f3 = f4;
/*      */     } 
/*      */     
/* 1074 */     paramFloat9 += paramFloat1;
/* 1075 */     paramFloat5 += paramFloat2;
/* 1076 */     paramFloat6 += paramFloat1;
/* 1077 */     paramFloat7 += paramFloat2;
/* 1078 */     paramFloat8 += paramFloat1;
/* 1079 */     paramFloat4 += paramFloat2;
/* 1080 */     paramFloat3 += paramFloat1;
/* 1081 */     f3 += paramFloat2;
/*      */ 
/*      */     
/* 1084 */     if (paramBoolean) {
/* 1085 */       f4 = paramTextureRegion.u2;
/* 1086 */       f5 = paramTextureRegion.v2;
/* 1087 */       paramFloat1 = paramTextureRegion.u;
/* 1088 */       paramFloat2 = paramTextureRegion.v2;
/* 1089 */       f2 = paramTextureRegion.u;
/* 1090 */       f6 = paramTextureRegion.v;
/* 1091 */       f7 = paramTextureRegion.u2;
/* 1092 */       f1 = paramTextureRegion.v;
/*      */     } else {
/* 1094 */       f4 = f1.u;
/* 1095 */       f5 = f1.v;
/* 1096 */       paramFloat1 = f1.u2;
/* 1097 */       paramFloat2 = f1.v;
/* 1098 */       f2 = f1.u2;
/* 1099 */       f6 = f1.v2;
/* 1100 */       f7 = f1.u;
/* 1101 */       f1 = f1.v2;
/*      */     } 
/*      */     
/* 1104 */     float f8 = this.colorPacked;
/* 1105 */     int k = this.vertexIndex;
/* 1106 */     arrayOfFloat[k++] = paramFloat9;
/* 1107 */     arrayOfFloat[k++] = paramFloat5;
/* 1108 */     arrayOfFloat[k++] = f8;
/* 1109 */     arrayOfFloat[k++] = f4;
/* 1110 */     arrayOfFloat[k++] = f5;
/*      */     
/* 1112 */     arrayOfFloat[k++] = paramFloat6;
/* 1113 */     arrayOfFloat[k++] = paramFloat7;
/* 1114 */     arrayOfFloat[k++] = f8;
/* 1115 */     arrayOfFloat[k++] = paramFloat1;
/* 1116 */     arrayOfFloat[k++] = paramFloat2;
/*      */     
/* 1118 */     arrayOfFloat[k++] = paramFloat8;
/* 1119 */     arrayOfFloat[k++] = paramFloat4;
/* 1120 */     arrayOfFloat[k++] = f8;
/* 1121 */     arrayOfFloat[k++] = f2;
/* 1122 */     arrayOfFloat[k++] = f6;
/*      */     
/* 1124 */     arrayOfFloat[k++] = paramFloat3;
/* 1125 */     arrayOfFloat[k++] = f3;
/* 1126 */     arrayOfFloat[k++] = f8;
/* 1127 */     arrayOfFloat[k++] = f7;
/* 1128 */     arrayOfFloat[k++] = f1;
/* 1129 */     this.vertexIndex = k;
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, Affine2 paramAffine2) {
/* 1134 */     if (!this.drawing) throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
/*      */     
/* 1136 */     short[] arrayOfShort = this.triangles;
/* 1137 */     float[] arrayOfFloat = this.vertices;
/*      */     
/*      */     Texture texture;
/* 1140 */     if ((texture = paramTextureRegion.texture) != this.lastTexture) {
/* 1141 */       switchTexture(texture);
/* 1142 */     } else if (this.triangleIndex + 6 > arrayOfShort.length || this.vertexIndex + 20 > arrayOfFloat.length) {
/* 1143 */       flush();
/*      */     } 
/* 1145 */     int i = this.triangleIndex;
/* 1146 */     int j = this.vertexIndex / 5;
/* 1147 */     arrayOfShort[i++] = (short)j;
/* 1148 */     arrayOfShort[i++] = (short)(j + 1);
/* 1149 */     arrayOfShort[i++] = (short)(j + 2);
/* 1150 */     arrayOfShort[i++] = (short)(j + 2);
/* 1151 */     arrayOfShort[i++] = (short)(j + 3);
/* 1152 */     arrayOfShort[i++] = (short)j;
/* 1153 */     this.triangleIndex = i;
/*      */ 
/*      */     
/* 1156 */     float f3 = paramAffine2.m02;
/* 1157 */     float f4 = paramAffine2.m12;
/* 1158 */     float f5 = paramAffine2.m01 * paramFloat2 + paramAffine2.m02;
/* 1159 */     float f6 = paramAffine2.m11 * paramFloat2 + paramAffine2.m12;
/* 1160 */     float f7 = paramAffine2.m00 * paramFloat1 + paramAffine2.m01 * paramFloat2 + paramAffine2.m02;
/* 1161 */     paramFloat2 = paramAffine2.m10 * paramFloat1 + paramAffine2.m11 * paramFloat2 + paramAffine2.m12;
/* 1162 */     float f8 = paramAffine2.m00 * paramFloat1 + paramAffine2.m02;
/* 1163 */     paramFloat1 = paramAffine2.m10 * paramFloat1 + paramAffine2.m12;
/*      */     
/* 1165 */     float f2 = paramTextureRegion.u;
/* 1166 */     float f9 = paramTextureRegion.v2;
/* 1167 */     float f10 = paramTextureRegion.u2;
/* 1168 */     float f1 = paramTextureRegion.v;
/*      */     
/* 1170 */     float f11 = this.colorPacked;
/* 1171 */     int k = this.vertexIndex;
/* 1172 */     arrayOfFloat[k++] = f3;
/* 1173 */     arrayOfFloat[k++] = f4;
/* 1174 */     arrayOfFloat[k++] = f11;
/* 1175 */     arrayOfFloat[k++] = f2;
/* 1176 */     arrayOfFloat[k++] = f9;
/*      */     
/* 1178 */     arrayOfFloat[k++] = f5;
/* 1179 */     arrayOfFloat[k++] = f6;
/* 1180 */     arrayOfFloat[k++] = f11;
/* 1181 */     arrayOfFloat[k++] = f2;
/* 1182 */     arrayOfFloat[k++] = f1;
/*      */     
/* 1184 */     arrayOfFloat[k++] = f7;
/* 1185 */     arrayOfFloat[k++] = paramFloat2;
/* 1186 */     arrayOfFloat[k++] = f11;
/* 1187 */     arrayOfFloat[k++] = f10;
/* 1188 */     arrayOfFloat[k++] = f1;
/*      */     
/* 1190 */     arrayOfFloat[k++] = f8;
/* 1191 */     arrayOfFloat[k++] = paramFloat1;
/* 1192 */     arrayOfFloat[k++] = f11;
/* 1193 */     arrayOfFloat[k++] = f10;
/* 1194 */     arrayOfFloat[k++] = f9;
/* 1195 */     this.vertexIndex = k;
/*      */   }
/*      */ 
/*      */   
/*      */   public void flush() {
/* 1200 */     if (this.vertexIndex == 0)
/*      */       return; 
/* 1202 */     this.renderCalls++;
/* 1203 */     this.totalRenderCalls++;
/*      */     int i;
/* 1205 */     if ((i = this.triangleIndex) > this.maxTrianglesInBatch) this.maxTrianglesInBatch = i;
/*      */     
/* 1207 */     this.lastTexture.bind();
/*      */     Mesh mesh;
/* 1209 */     (mesh = this.mesh).setVertices(this.vertices, 0, this.vertexIndex);
/* 1210 */     mesh.setIndices(this.triangles, 0, i);
/* 1211 */     if (this.blendingDisabled) {
/* 1212 */       Gdx.gl.glDisable(3042);
/*      */     } else {
/* 1214 */       Gdx.gl.glEnable(3042);
/* 1215 */       if (this.blendSrcFunc != -1) Gdx.gl.glBlendFuncSeparate(this.blendSrcFunc, this.blendDstFunc, this.blendSrcFuncAlpha, this.blendDstFuncAlpha);
/*      */     
/*      */     } 
/* 1218 */     mesh.render((this.customShader != null) ? this.customShader : this.shader, 4, 0, i);
/*      */     
/* 1220 */     this.vertexIndex = 0;
/* 1221 */     this.triangleIndex = 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public void disableBlending() {
/* 1226 */     flush();
/* 1227 */     this.blendingDisabled = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void enableBlending() {
/* 1232 */     flush();
/* 1233 */     this.blendingDisabled = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setBlendFunction(int paramInt1, int paramInt2) {
/* 1238 */     setBlendFunctionSeparate(paramInt1, paramInt2, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setBlendFunctionSeparate(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1243 */     if (this.blendSrcFunc == paramInt1 && this.blendDstFunc == paramInt2 && this.blendSrcFuncAlpha == paramInt3 && this.blendDstFuncAlpha == paramInt4)
/*      */       return; 
/* 1245 */     flush();
/* 1246 */     this.blendSrcFunc = paramInt1;
/* 1247 */     this.blendDstFunc = paramInt2;
/* 1248 */     this.blendSrcFuncAlpha = paramInt3;
/* 1249 */     this.blendDstFuncAlpha = paramInt4;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getBlendSrcFunc() {
/* 1254 */     return this.blendSrcFunc;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getBlendDstFunc() {
/* 1259 */     return this.blendDstFunc;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getBlendSrcFuncAlpha() {
/* 1264 */     return this.blendSrcFuncAlpha;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getBlendDstFuncAlpha() {
/* 1269 */     return this.blendDstFuncAlpha;
/*      */   }
/*      */ 
/*      */   
/*      */   public void dispose() {
/* 1274 */     this.mesh.dispose();
/* 1275 */     if (this.ownsShader && this.shader != null) this.shader.dispose();
/*      */   
/*      */   }
/*      */   
/*      */   public Matrix4 getProjectionMatrix() {
/* 1280 */     return this.projectionMatrix;
/*      */   }
/*      */ 
/*      */   
/*      */   public Matrix4 getTransformMatrix() {
/* 1285 */     return this.transformMatrix;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setProjectionMatrix(Matrix4 paramMatrix4) {
/* 1290 */     if (this.drawing) flush(); 
/* 1291 */     this.projectionMatrix.set(paramMatrix4);
/* 1292 */     if (this.drawing) setupMatrices();
/*      */   
/*      */   }
/*      */   
/*      */   public void setTransformMatrix(Matrix4 paramMatrix4) {
/* 1297 */     if (this.drawing) flush(); 
/* 1298 */     this.transformMatrix.set(paramMatrix4);
/* 1299 */     if (this.drawing) setupMatrices(); 
/*      */   }
/*      */   
/*      */   protected void setupMatrices() {
/* 1303 */     this.combinedMatrix.set(this.projectionMatrix).mul(this.transformMatrix);
/* 1304 */     if (this.customShader != null) {
/* 1305 */       this.customShader.setUniformMatrix("u_projTrans", this.combinedMatrix);
/* 1306 */       this.customShader.setUniformi("u_texture", 0); return;
/*      */     } 
/* 1308 */     this.shader.setUniformMatrix("u_projTrans", this.combinedMatrix);
/* 1309 */     this.shader.setUniformi("u_texture", 0);
/*      */   }
/*      */ 
/*      */   
/*      */   private void switchTexture(Texture paramTexture) {
/* 1314 */     flush();
/* 1315 */     this.lastTexture = paramTexture;
/* 1316 */     this.invTexWidth = 1.0F / paramTexture.getWidth();
/* 1317 */     this.invTexHeight = 1.0F / paramTexture.getHeight();
/*      */   }
/*      */ 
/*      */   
/*      */   public void setShader(ShaderProgram paramShaderProgram) {
/* 1322 */     if (this.drawing) {
/* 1323 */       flush();
/*      */     }
/* 1325 */     this.customShader = paramShaderProgram;
/* 1326 */     if (this.drawing) {
/* 1327 */       if (this.customShader != null) {
/* 1328 */         this.customShader.bind();
/*      */       } else {
/* 1330 */         this.shader.bind();
/* 1331 */       }  setupMatrices();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public ShaderProgram getShader() {
/* 1337 */     if (this.customShader == null) {
/* 1338 */       return this.shader;
/*      */     }
/* 1340 */     return this.customShader;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isBlendingEnabled() {
/* 1345 */     return !this.blendingDisabled;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isDrawing() {
/* 1350 */     return this.drawing;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\PolygonSpriteBatch.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */