/*      */ package com.badlogic.gdx.graphics.glutils;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.Matrix4;
/*      */ import com.badlogic.gdx.math.Vector2;
/*      */ import com.badlogic.gdx.math.Vector3;
/*      */ import com.badlogic.gdx.utils.Disposable;
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
/*      */ public class ShapeRenderer
/*      */   implements Disposable
/*      */ {
/*      */   private final ImmediateModeRenderer renderer;
/*      */   
/*      */   public enum ShapeType
/*      */   {
/*   82 */     Point(0), Line(1), Filled(4);
/*      */     
/*      */     private final int glType;
/*      */     
/*      */     ShapeType(int param1Int1) {
/*   87 */       this.glType = param1Int1;
/*      */     }
/*      */     
/*      */     public final int getGlType() {
/*   91 */       return this.glType;
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean matrixDirty = false;
/*      */   
/*   97 */   private final Matrix4 projectionMatrix = new Matrix4();
/*   98 */   private final Matrix4 transformMatrix = new Matrix4();
/*   99 */   private final Matrix4 combinedMatrix = new Matrix4();
/*  100 */   private final Vector2 tmp = new Vector2();
/*  101 */   private final Color color = new Color(1.0F, 1.0F, 1.0F, 1.0F);
/*      */   private ShapeType shapeType;
/*      */   private boolean autoShapeType;
/*  104 */   private float defaultRectLineWidth = 0.75F;
/*      */   
/*      */   public ShapeRenderer() {
/*  107 */     this(5000);
/*      */   }
/*      */   
/*      */   public ShapeRenderer(int paramInt) {
/*  111 */     this(paramInt, null);
/*      */   }
/*      */   
/*      */   public ShapeRenderer(int paramInt, ShaderProgram paramShaderProgram) {
/*  115 */     if (paramShaderProgram == null) {
/*  116 */       this.renderer = new ImmediateModeRenderer20(paramInt, false, true, 0);
/*      */     } else {
/*  118 */       this.renderer = new ImmediateModeRenderer20(paramInt, false, true, 0, paramShaderProgram);
/*      */     } 
/*  120 */     this.projectionMatrix.setToOrtho2D(0.0F, 0.0F, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
/*  121 */     this.matrixDirty = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setColor(Color paramColor) {
/*  126 */     this.color.set(paramColor);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  131 */     this.color.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*      */   }
/*      */   
/*      */   public Color getColor() {
/*  135 */     return this.color;
/*      */   }
/*      */   
/*      */   public void updateMatrices() {
/*  139 */     this.matrixDirty = true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setProjectionMatrix(Matrix4 paramMatrix4) {
/*  145 */     this.projectionMatrix.set(paramMatrix4);
/*  146 */     this.matrixDirty = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public Matrix4 getProjectionMatrix() {
/*  151 */     return this.projectionMatrix;
/*      */   }
/*      */   
/*      */   public void setTransformMatrix(Matrix4 paramMatrix4) {
/*  155 */     this.transformMatrix.set(paramMatrix4);
/*  156 */     this.matrixDirty = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public Matrix4 getTransformMatrix() {
/*  161 */     return this.transformMatrix;
/*      */   }
/*      */ 
/*      */   
/*      */   public void identity() {
/*  166 */     this.transformMatrix.idt();
/*  167 */     this.matrixDirty = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void translate(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  172 */     this.transformMatrix.translate(paramFloat1, paramFloat2, paramFloat3);
/*  173 */     this.matrixDirty = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  178 */     this.transformMatrix.rotate(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*  179 */     this.matrixDirty = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void scale(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  184 */     this.transformMatrix.scale(paramFloat1, paramFloat2, paramFloat3);
/*  185 */     this.matrixDirty = true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAutoShapeType(boolean paramBoolean) {
/*  192 */     this.autoShapeType = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void begin() {
/*  198 */     if (!this.autoShapeType) throw new IllegalStateException("autoShapeType must be true to use this method."); 
/*  199 */     begin(ShapeType.Line);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void begin(ShapeType paramShapeType) {
/*  206 */     if (this.shapeType != null) throw new IllegalStateException("Call end() before beginning a new shape batch."); 
/*  207 */     this.shapeType = paramShapeType;
/*  208 */     if (this.matrixDirty) {
/*  209 */       this.combinedMatrix.set(this.projectionMatrix);
/*  210 */       Matrix4.mul(this.combinedMatrix.val, this.transformMatrix.val);
/*  211 */       this.matrixDirty = false;
/*      */     } 
/*  213 */     this.renderer.begin(this.combinedMatrix, this.shapeType.getGlType());
/*      */   }
/*      */   
/*      */   public void set(ShapeType paramShapeType) {
/*  217 */     if (this.shapeType == paramShapeType)
/*  218 */       return;  if (this.shapeType == null) throw new IllegalStateException("begin must be called first."); 
/*  219 */     if (!this.autoShapeType) throw new IllegalStateException("autoShapeType must be enabled."); 
/*  220 */     end();
/*  221 */     begin(paramShapeType);
/*      */   }
/*      */ 
/*      */   
/*      */   public void point(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  226 */     if (this.shapeType == ShapeType.Line) {
/*  227 */       float f = this.defaultRectLineWidth * 0.5F;
/*  228 */       line(paramFloat1 - f, paramFloat2 - f, paramFloat3, paramFloat1 + f, paramFloat2 + f, paramFloat3); return;
/*      */     } 
/*  230 */     if (this.shapeType == ShapeType.Filled) {
/*  231 */       float f = this.defaultRectLineWidth * 0.5F;
/*  232 */       box(paramFloat1 - f, paramFloat2 - f, paramFloat3 - f, this.defaultRectLineWidth, this.defaultRectLineWidth, this.defaultRectLineWidth);
/*      */       return;
/*      */     } 
/*  235 */     check(ShapeType.Point, null, 1);
/*  236 */     this.renderer.color(this.color);
/*  237 */     this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void line(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/*  242 */     line(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, this.color, this.color);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void line(Vector3 paramVector31, Vector3 paramVector32) {
/*  247 */     line(paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z, this.color, this.color);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void line(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  252 */     line(paramFloat1, paramFloat2, 0.0F, paramFloat3, paramFloat4, 0.0F, this.color, this.color);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void line(Vector2 paramVector21, Vector2 paramVector22) {
/*  257 */     line(paramVector21.x, paramVector21.y, 0.0F, paramVector22.x, paramVector22.y, 0.0F, this.color, this.color);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void line(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Color paramColor1, Color paramColor2) {
/*  262 */     line(paramFloat1, paramFloat2, 0.0F, paramFloat3, paramFloat4, 0.0F, paramColor1, paramColor2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void line(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Color paramColor1, Color paramColor2) {
/*  268 */     if (this.shapeType == ShapeType.Filled) {
/*  269 */       rectLine(paramFloat1, paramFloat2, paramFloat4, paramFloat5, this.defaultRectLineWidth, paramColor1, paramColor2);
/*      */       return;
/*      */     } 
/*  272 */     check(ShapeType.Line, null, 2);
/*  273 */     this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
/*  274 */     this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
/*  275 */     this.renderer.color(paramColor2.r, paramColor2.g, paramColor2.b, paramColor2.a);
/*  276 */     this.renderer.vertex(paramFloat4, paramFloat5, paramFloat6);
/*      */   }
/*      */ 
/*      */   
/*      */   public void curve(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt) {
/*  281 */     check(ShapeType.Line, null, (paramInt << 1) + 2);
/*  282 */     float f1 = this.color.toFloatBits();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  287 */     float f2, f3, f4 = (f3 = (f2 = 1.0F / paramInt) * f2) * f2;
/*      */     
/*  289 */     f2 = 3.0F * f2;
/*  290 */     float f5 = 3.0F * f3;
/*  291 */     f3 = 6.0F * f3;
/*  292 */     float f6 = 6.0F * f4;
/*      */     
/*  294 */     float f7 = paramFloat1 - paramFloat3 * 2.0F + paramFloat5;
/*  295 */     float f8 = paramFloat2 - paramFloat4 * 2.0F + paramFloat6;
/*      */     
/*  297 */     paramFloat5 = (paramFloat3 - paramFloat5) * 3.0F - paramFloat1 + paramFloat7;
/*  298 */     paramFloat6 = (paramFloat4 - paramFloat6) * 3.0F - paramFloat2 + paramFloat8;
/*      */     
/*  300 */     float f9 = paramFloat1;
/*  301 */     float f10 = paramFloat2;
/*      */     
/*  303 */     paramFloat1 = (paramFloat3 - paramFloat1) * f2 + f7 * f5 + paramFloat5 * f4;
/*  304 */     paramFloat2 = (paramFloat4 - paramFloat2) * f2 + f8 * f5 + paramFloat6 * f4;
/*      */     
/*  306 */     paramFloat3 = f7 * f3 + paramFloat5 * f6;
/*  307 */     paramFloat4 = f8 * f3 + paramFloat6 * f6;
/*      */     
/*  309 */     paramFloat5 *= f6;
/*  310 */     paramFloat6 *= f6;
/*      */     
/*  312 */     while (paramInt-- > 0) {
/*  313 */       this.renderer.color(f1);
/*  314 */       this.renderer.vertex(f9, f10, 0.0F);
/*  315 */       f9 += paramFloat1;
/*  316 */       f10 += paramFloat2;
/*  317 */       paramFloat1 += paramFloat3;
/*  318 */       paramFloat2 += paramFloat4;
/*  319 */       paramFloat3 += paramFloat5;
/*  320 */       paramFloat4 += paramFloat6;
/*  321 */       this.renderer.color(f1);
/*  322 */       this.renderer.vertex(f9, f10, 0.0F);
/*      */     } 
/*  324 */     this.renderer.color(f1);
/*  325 */     this.renderer.vertex(f9, f10, 0.0F);
/*  326 */     this.renderer.color(f1);
/*  327 */     this.renderer.vertex(paramFloat7, paramFloat8, 0.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   public void triangle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/*  332 */     check(ShapeType.Line, ShapeType.Filled, 6);
/*  333 */     float f = this.color.toFloatBits();
/*  334 */     if (this.shapeType == ShapeType.Line) {
/*  335 */       this.renderer.color(f);
/*  336 */       this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
/*  337 */       this.renderer.color(f);
/*  338 */       this.renderer.vertex(paramFloat3, paramFloat4, 0.0F);
/*      */       
/*  340 */       this.renderer.color(f);
/*  341 */       this.renderer.vertex(paramFloat3, paramFloat4, 0.0F);
/*  342 */       this.renderer.color(f);
/*  343 */       this.renderer.vertex(paramFloat5, paramFloat6, 0.0F);
/*      */       
/*  345 */       this.renderer.color(f);
/*  346 */       this.renderer.vertex(paramFloat5, paramFloat6, 0.0F);
/*  347 */       this.renderer.color(f);
/*  348 */       this.renderer.vertex(paramFloat1, paramFloat2, 0.0F); return;
/*      */     } 
/*  350 */     this.renderer.color(f);
/*  351 */     this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
/*  352 */     this.renderer.color(f);
/*  353 */     this.renderer.vertex(paramFloat3, paramFloat4, 0.0F);
/*  354 */     this.renderer.color(f);
/*  355 */     this.renderer.vertex(paramFloat5, paramFloat6, 0.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void triangle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Color paramColor1, Color paramColor2, Color paramColor3) {
/*  361 */     check(ShapeType.Line, ShapeType.Filled, 6);
/*  362 */     if (this.shapeType == ShapeType.Line) {
/*  363 */       this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
/*  364 */       this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
/*  365 */       this.renderer.color(paramColor2.r, paramColor2.g, paramColor2.b, paramColor2.a);
/*  366 */       this.renderer.vertex(paramFloat3, paramFloat4, 0.0F);
/*      */       
/*  368 */       this.renderer.color(paramColor2.r, paramColor2.g, paramColor2.b, paramColor2.a);
/*  369 */       this.renderer.vertex(paramFloat3, paramFloat4, 0.0F);
/*  370 */       this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
/*  371 */       this.renderer.vertex(paramFloat5, paramFloat6, 0.0F);
/*      */       
/*  373 */       this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
/*  374 */       this.renderer.vertex(paramFloat5, paramFloat6, 0.0F);
/*  375 */       this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
/*  376 */       this.renderer.vertex(paramFloat1, paramFloat2, 0.0F); return;
/*      */     } 
/*  378 */     this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
/*  379 */     this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
/*  380 */     this.renderer.color(paramColor2.r, paramColor2.g, paramColor2.b, paramColor2.a);
/*  381 */     this.renderer.vertex(paramFloat3, paramFloat4, 0.0F);
/*  382 */     this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
/*  383 */     this.renderer.vertex(paramFloat5, paramFloat6, 0.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void rect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  389 */     check(ShapeType.Line, ShapeType.Filled, 8);
/*  390 */     float f = this.color.toFloatBits();
/*  391 */     if (this.shapeType == ShapeType.Line) {
/*  392 */       this.renderer.color(f);
/*  393 */       this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
/*  394 */       this.renderer.color(f);
/*  395 */       this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2, 0.0F);
/*      */       
/*  397 */       this.renderer.color(f);
/*  398 */       this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2, 0.0F);
/*  399 */       this.renderer.color(f);
/*  400 */       this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, 0.0F);
/*      */       
/*  402 */       this.renderer.color(f);
/*  403 */       this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, 0.0F);
/*  404 */       this.renderer.color(f);
/*  405 */       this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat4, 0.0F);
/*      */       
/*  407 */       this.renderer.color(f);
/*  408 */       this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat4, 0.0F);
/*  409 */       this.renderer.color(f);
/*  410 */       this.renderer.vertex(paramFloat1, paramFloat2, 0.0F); return;
/*      */     } 
/*  412 */     this.renderer.color(f);
/*  413 */     this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
/*  414 */     this.renderer.color(f);
/*  415 */     this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2, 0.0F);
/*  416 */     this.renderer.color(f);
/*  417 */     this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, 0.0F);
/*      */     
/*  419 */     this.renderer.color(f);
/*  420 */     this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, 0.0F);
/*  421 */     this.renderer.color(f);
/*  422 */     this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat4, 0.0F);
/*  423 */     this.renderer.color(f);
/*  424 */     this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Color paramColor1, Color paramColor2, Color paramColor3, Color paramColor4) {
/*  435 */     check(ShapeType.Line, ShapeType.Filled, 8);
/*      */     
/*  437 */     if (this.shapeType == ShapeType.Line) {
/*  438 */       this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
/*  439 */       this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
/*  440 */       this.renderer.color(paramColor2.r, paramColor2.g, paramColor2.b, paramColor2.a);
/*  441 */       this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2, 0.0F);
/*      */       
/*  443 */       this.renderer.color(paramColor2.r, paramColor2.g, paramColor2.b, paramColor2.a);
/*  444 */       this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2, 0.0F);
/*  445 */       this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
/*  446 */       this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, 0.0F);
/*      */       
/*  448 */       this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
/*  449 */       this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, 0.0F);
/*  450 */       this.renderer.color(paramColor4.r, paramColor4.g, paramColor4.b, paramColor4.a);
/*  451 */       this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat4, 0.0F);
/*      */       
/*  453 */       this.renderer.color(paramColor4.r, paramColor4.g, paramColor4.b, paramColor4.a);
/*  454 */       this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat4, 0.0F);
/*  455 */       this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
/*  456 */       this.renderer.vertex(paramFloat1, paramFloat2, 0.0F); return;
/*      */     } 
/*  458 */     this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
/*  459 */     this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
/*  460 */     this.renderer.color(paramColor2.r, paramColor2.g, paramColor2.b, paramColor2.a);
/*  461 */     this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2, 0.0F);
/*  462 */     this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
/*  463 */     this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, 0.0F);
/*      */     
/*  465 */     this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
/*  466 */     this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, 0.0F);
/*  467 */     this.renderer.color(paramColor4.r, paramColor4.g, paramColor4.b, paramColor4.a);
/*  468 */     this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat4, 0.0F);
/*  469 */     this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
/*  470 */     this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/*  478 */     rect(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, this.color, this.color, this.color, this.color);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, Color paramColor1, Color paramColor2, Color paramColor3, Color paramColor4) {
/*  489 */     check(ShapeType.Line, ShapeType.Filled, 8);
/*      */     
/*  491 */     float f1 = MathUtils.cosDeg(paramFloat9);
/*  492 */     paramFloat9 = MathUtils.sinDeg(paramFloat9);
/*  493 */     float f2 = -paramFloat3;
/*  494 */     float f3 = -paramFloat4;
/*  495 */     paramFloat5 -= paramFloat3;
/*  496 */     paramFloat6 -= paramFloat4;
/*      */     
/*  498 */     if (paramFloat7 != 1.0F || paramFloat8 != 1.0F) {
/*  499 */       f2 *= paramFloat7;
/*  500 */       f3 *= paramFloat8;
/*  501 */       paramFloat5 *= paramFloat7;
/*  502 */       paramFloat6 *= paramFloat8;
/*      */     } 
/*      */     
/*  505 */     paramFloat1 += paramFloat3;
/*  506 */     paramFloat2 += paramFloat4;
/*      */     
/*  508 */     paramFloat3 = f1 * f2 - paramFloat9 * f3 + paramFloat1;
/*  509 */     paramFloat4 = paramFloat9 * f2 + f1 * f3 + paramFloat2;
/*      */     
/*  511 */     paramFloat7 = f1 * paramFloat5 - paramFloat9 * f3 + paramFloat1;
/*  512 */     paramFloat8 = paramFloat9 * paramFloat5 + f1 * f3 + paramFloat2;
/*      */     
/*  514 */     paramFloat1 = f1 * paramFloat5 - paramFloat9 * paramFloat6 + paramFloat1;
/*  515 */     paramFloat2 = paramFloat9 * paramFloat5 + f1 * paramFloat6 + paramFloat2;
/*      */     
/*  517 */     paramFloat5 = paramFloat3 + paramFloat1 - paramFloat7;
/*  518 */     paramFloat6 = paramFloat2 - paramFloat8 - paramFloat4;
/*      */     
/*  520 */     if (this.shapeType == ShapeType.Line) {
/*  521 */       this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
/*  522 */       this.renderer.vertex(paramFloat3, paramFloat4, 0.0F);
/*  523 */       this.renderer.color(paramColor2.r, paramColor2.g, paramColor2.b, paramColor2.a);
/*  524 */       this.renderer.vertex(paramFloat7, paramFloat8, 0.0F);
/*      */       
/*  526 */       this.renderer.color(paramColor2.r, paramColor2.g, paramColor2.b, paramColor2.a);
/*  527 */       this.renderer.vertex(paramFloat7, paramFloat8, 0.0F);
/*  528 */       this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
/*  529 */       this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
/*      */       
/*  531 */       this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
/*  532 */       this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
/*  533 */       this.renderer.color(paramColor4.r, paramColor4.g, paramColor4.b, paramColor4.a);
/*  534 */       this.renderer.vertex(paramFloat5, paramFloat6, 0.0F);
/*      */       
/*  536 */       this.renderer.color(paramColor4.r, paramColor4.g, paramColor4.b, paramColor4.a);
/*  537 */       this.renderer.vertex(paramFloat5, paramFloat6, 0.0F);
/*  538 */       this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
/*  539 */       this.renderer.vertex(paramFloat3, paramFloat4, 0.0F); return;
/*      */     } 
/*  541 */     this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
/*  542 */     this.renderer.vertex(paramFloat3, paramFloat4, 0.0F);
/*  543 */     this.renderer.color(paramColor2.r, paramColor2.g, paramColor2.b, paramColor2.a);
/*  544 */     this.renderer.vertex(paramFloat7, paramFloat8, 0.0F);
/*  545 */     this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
/*  546 */     this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
/*      */     
/*  548 */     this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
/*  549 */     this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
/*  550 */     this.renderer.color(paramColor4.r, paramColor4.g, paramColor4.b, paramColor4.a);
/*  551 */     this.renderer.vertex(paramFloat5, paramFloat6, 0.0F);
/*  552 */     this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
/*  553 */     this.renderer.vertex(paramFloat3, paramFloat4, 0.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rectLine(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/*  561 */     check(ShapeType.Line, ShapeType.Filled, 8);
/*  562 */     float f1 = this.color.toFloatBits();
/*  563 */     Vector2 vector2 = this.tmp.set(paramFloat4 - paramFloat2, paramFloat1 - paramFloat3).nor();
/*  564 */     paramFloat5 *= 0.5F;
/*  565 */     float f2 = vector2.x * paramFloat5;
/*  566 */     paramFloat5 = vector2.y * paramFloat5;
/*  567 */     if (this.shapeType == ShapeType.Line) {
/*  568 */       this.renderer.color(f1);
/*  569 */       this.renderer.vertex(paramFloat1 + f2, paramFloat2 + paramFloat5, 0.0F);
/*  570 */       this.renderer.color(f1);
/*  571 */       this.renderer.vertex(paramFloat1 - f2, paramFloat2 - paramFloat5, 0.0F);
/*      */       
/*  573 */       this.renderer.color(f1);
/*  574 */       this.renderer.vertex(paramFloat3 + f2, paramFloat4 + paramFloat5, 0.0F);
/*  575 */       this.renderer.color(f1);
/*  576 */       this.renderer.vertex(paramFloat3 - f2, paramFloat4 - paramFloat5, 0.0F);
/*      */       
/*  578 */       this.renderer.color(f1);
/*  579 */       this.renderer.vertex(paramFloat3 + f2, paramFloat4 + paramFloat5, 0.0F);
/*  580 */       this.renderer.color(f1);
/*  581 */       this.renderer.vertex(paramFloat1 + f2, paramFloat2 + paramFloat5, 0.0F);
/*      */       
/*  583 */       this.renderer.color(f1);
/*  584 */       this.renderer.vertex(paramFloat3 - f2, paramFloat4 - paramFloat5, 0.0F);
/*  585 */       this.renderer.color(f1);
/*  586 */       this.renderer.vertex(paramFloat1 - f2, paramFloat2 - paramFloat5, 0.0F); return;
/*      */     } 
/*  588 */     this.renderer.color(f1);
/*  589 */     this.renderer.vertex(paramFloat1 + f2, paramFloat2 + paramFloat5, 0.0F);
/*  590 */     this.renderer.color(f1);
/*  591 */     this.renderer.vertex(paramFloat1 - f2, paramFloat2 - paramFloat5, 0.0F);
/*  592 */     this.renderer.color(f1);
/*  593 */     this.renderer.vertex(paramFloat3 + f2, paramFloat4 + paramFloat5, 0.0F);
/*      */     
/*  595 */     this.renderer.color(f1);
/*  596 */     this.renderer.vertex(paramFloat3 - f2, paramFloat4 - paramFloat5, 0.0F);
/*  597 */     this.renderer.color(f1);
/*  598 */     this.renderer.vertex(paramFloat3 + f2, paramFloat4 + paramFloat5, 0.0F);
/*  599 */     this.renderer.color(f1);
/*  600 */     this.renderer.vertex(paramFloat1 - f2, paramFloat2 - paramFloat5, 0.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rectLine(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, Color paramColor1, Color paramColor2) {
/*  607 */     check(ShapeType.Line, ShapeType.Filled, 8);
/*  608 */     float f1 = paramColor1.toFloatBits();
/*  609 */     float f2 = paramColor2.toFloatBits();
/*  610 */     Vector2 vector2 = this.tmp.set(paramFloat4 - paramFloat2, paramFloat1 - paramFloat3).nor();
/*  611 */     paramFloat5 *= 0.5F;
/*  612 */     float f3 = vector2.x * paramFloat5;
/*  613 */     paramFloat5 = vector2.y * paramFloat5;
/*  614 */     if (this.shapeType == ShapeType.Line) {
/*  615 */       this.renderer.color(f1);
/*  616 */       this.renderer.vertex(paramFloat1 + f3, paramFloat2 + paramFloat5, 0.0F);
/*  617 */       this.renderer.color(f1);
/*  618 */       this.renderer.vertex(paramFloat1 - f3, paramFloat2 - paramFloat5, 0.0F);
/*      */       
/*  620 */       this.renderer.color(f2);
/*  621 */       this.renderer.vertex(paramFloat3 + f3, paramFloat4 + paramFloat5, 0.0F);
/*  622 */       this.renderer.color(f2);
/*  623 */       this.renderer.vertex(paramFloat3 - f3, paramFloat4 - paramFloat5, 0.0F);
/*      */       
/*  625 */       this.renderer.color(f2);
/*  626 */       this.renderer.vertex(paramFloat3 + f3, paramFloat4 + paramFloat5, 0.0F);
/*  627 */       this.renderer.color(f1);
/*  628 */       this.renderer.vertex(paramFloat1 + f3, paramFloat2 + paramFloat5, 0.0F);
/*      */       
/*  630 */       this.renderer.color(f2);
/*  631 */       this.renderer.vertex(paramFloat3 - f3, paramFloat4 - paramFloat5, 0.0F);
/*  632 */       this.renderer.color(f1);
/*  633 */       this.renderer.vertex(paramFloat1 - f3, paramFloat2 - paramFloat5, 0.0F); return;
/*      */     } 
/*  635 */     this.renderer.color(f1);
/*  636 */     this.renderer.vertex(paramFloat1 + f3, paramFloat2 + paramFloat5, 0.0F);
/*  637 */     this.renderer.color(f1);
/*  638 */     this.renderer.vertex(paramFloat1 - f3, paramFloat2 - paramFloat5, 0.0F);
/*  639 */     this.renderer.color(f2);
/*  640 */     this.renderer.vertex(paramFloat3 + f3, paramFloat4 + paramFloat5, 0.0F);
/*      */     
/*  642 */     this.renderer.color(f2);
/*  643 */     this.renderer.vertex(paramFloat3 - f3, paramFloat4 - paramFloat5, 0.0F);
/*  644 */     this.renderer.color(f2);
/*  645 */     this.renderer.vertex(paramFloat3 + f3, paramFloat4 + paramFloat5, 0.0F);
/*  646 */     this.renderer.color(f1);
/*  647 */     this.renderer.vertex(paramFloat1 - f3, paramFloat2 - paramFloat5, 0.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void rectLine(Vector2 paramVector21, Vector2 paramVector22, float paramFloat) {
/*  653 */     rectLine(paramVector21.x, paramVector21.y, paramVector22.x, paramVector22.y, paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void box(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/*  659 */     paramFloat6 = -paramFloat6;
/*  660 */     float f = this.color.toFloatBits();
/*  661 */     if (this.shapeType == ShapeType.Line) {
/*  662 */       check(ShapeType.Line, ShapeType.Filled, 24);
/*      */       
/*  664 */       this.renderer.color(f);
/*  665 */       this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
/*  666 */       this.renderer.color(f);
/*  667 */       this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3);
/*      */       
/*  669 */       this.renderer.color(f);
/*  670 */       this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3);
/*  671 */       this.renderer.color(f);
/*  672 */       this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3 + paramFloat6);
/*      */       
/*  674 */       this.renderer.color(f);
/*  675 */       this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3 + paramFloat6);
/*  676 */       this.renderer.color(f);
/*  677 */       this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + paramFloat6);
/*      */       
/*  679 */       this.renderer.color(f);
/*  680 */       this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + paramFloat6);
/*  681 */       this.renderer.color(f);
/*  682 */       this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
/*      */       
/*  684 */       this.renderer.color(f);
/*  685 */       this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
/*  686 */       this.renderer.color(f);
/*  687 */       this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3);
/*      */       
/*  689 */       this.renderer.color(f);
/*  690 */       this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3);
/*  691 */       this.renderer.color(f);
/*  692 */       this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3);
/*      */       
/*  694 */       this.renderer.color(f);
/*  695 */       this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3);
/*  696 */       this.renderer.color(f);
/*  697 */       this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + paramFloat6);
/*      */       
/*  699 */       this.renderer.color(f);
/*  700 */       this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + paramFloat6);
/*  701 */       this.renderer.color(f);
/*  702 */       this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3 + paramFloat6);
/*      */       
/*  704 */       this.renderer.color(f);
/*  705 */       this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3 + paramFloat6);
/*  706 */       this.renderer.color(f);
/*  707 */       this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3);
/*      */       
/*  709 */       this.renderer.color(f);
/*  710 */       this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3);
/*  711 */       this.renderer.color(f);
/*  712 */       this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3);
/*      */       
/*  714 */       this.renderer.color(f);
/*  715 */       this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3 + paramFloat6);
/*  716 */       this.renderer.color(f);
/*  717 */       this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + paramFloat6);
/*      */       
/*  719 */       this.renderer.color(f);
/*  720 */       this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + paramFloat6);
/*  721 */       this.renderer.color(f);
/*  722 */       this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3 + paramFloat6); return;
/*      */     } 
/*  724 */     check(ShapeType.Line, ShapeType.Filled, 36);
/*      */ 
/*      */     
/*  727 */     this.renderer.color(f);
/*  728 */     this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
/*  729 */     this.renderer.color(f);
/*  730 */     this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3);
/*  731 */     this.renderer.color(f);
/*  732 */     this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3);
/*      */     
/*  734 */     this.renderer.color(f);
/*  735 */     this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
/*  736 */     this.renderer.color(f);
/*  737 */     this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3);
/*  738 */     this.renderer.color(f);
/*  739 */     this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3);
/*      */ 
/*      */     
/*  742 */     this.renderer.color(f);
/*  743 */     this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3 + paramFloat6);
/*  744 */     this.renderer.color(f);
/*  745 */     this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + paramFloat6);
/*  746 */     this.renderer.color(f);
/*  747 */     this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + paramFloat6);
/*      */     
/*  749 */     this.renderer.color(f);
/*  750 */     this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + paramFloat6);
/*  751 */     this.renderer.color(f);
/*  752 */     this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + paramFloat6);
/*  753 */     this.renderer.color(f);
/*  754 */     this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3 + paramFloat6);
/*      */ 
/*      */     
/*  757 */     this.renderer.color(f);
/*  758 */     this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + paramFloat6);
/*  759 */     this.renderer.color(f);
/*  760 */     this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
/*  761 */     this.renderer.color(f);
/*  762 */     this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3);
/*      */     
/*  764 */     this.renderer.color(f);
/*  765 */     this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + paramFloat6);
/*  766 */     this.renderer.color(f);
/*  767 */     this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3);
/*  768 */     this.renderer.color(f);
/*  769 */     this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3 + paramFloat6);
/*      */ 
/*      */     
/*  772 */     this.renderer.color(f);
/*  773 */     this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3);
/*  774 */     this.renderer.color(f);
/*  775 */     this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3 + paramFloat6);
/*  776 */     this.renderer.color(f);
/*  777 */     this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + paramFloat6);
/*      */     
/*  779 */     this.renderer.color(f);
/*  780 */     this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3);
/*  781 */     this.renderer.color(f);
/*  782 */     this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + paramFloat6);
/*  783 */     this.renderer.color(f);
/*  784 */     this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3);
/*      */ 
/*      */     
/*  787 */     this.renderer.color(f);
/*  788 */     this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3);
/*  789 */     this.renderer.color(f);
/*  790 */     this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3);
/*  791 */     this.renderer.color(f);
/*  792 */     this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + paramFloat6);
/*      */     
/*  794 */     this.renderer.color(f);
/*  795 */     this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3);
/*  796 */     this.renderer.color(f);
/*  797 */     this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + paramFloat6);
/*  798 */     this.renderer.color(f);
/*  799 */     this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3 + paramFloat6);
/*      */ 
/*      */     
/*  802 */     this.renderer.color(f);
/*  803 */     this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + paramFloat6);
/*  804 */     this.renderer.color(f);
/*  805 */     this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3 + paramFloat6);
/*  806 */     this.renderer.color(f);
/*  807 */     this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3);
/*      */     
/*  809 */     this.renderer.color(f);
/*  810 */     this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + paramFloat6);
/*  811 */     this.renderer.color(f);
/*  812 */     this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3);
/*  813 */     this.renderer.color(f);
/*  814 */     this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void x(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  821 */     line(paramFloat1 - paramFloat3, paramFloat2 - paramFloat3, paramFloat1 + paramFloat3, paramFloat2 + paramFloat3);
/*  822 */     line(paramFloat1 - paramFloat3, paramFloat2 + paramFloat3, paramFloat1 + paramFloat3, paramFloat2 - paramFloat3);
/*      */   }
/*      */ 
/*      */   
/*      */   public void x(Vector2 paramVector2, float paramFloat) {
/*  827 */     x(paramVector2.x, paramVector2.y, paramFloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public void arc(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/*  832 */     arc(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, Math.max(1, (int)(6.0F * (float)Math.cbrt(paramFloat3) * paramFloat5 / 360.0F)));
/*      */   }
/*      */ 
/*      */   
/*      */   public void arc(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt) {
/*  837 */     if (paramInt <= 0) throw new IllegalArgumentException("segments must be > 0."); 
/*  838 */     float f1 = this.color.toFloatBits();
/*      */     
/*  840 */     float f2 = MathUtils.cos(paramFloat5 = 6.2831855F * paramFloat5 / 360.0F / paramInt);
/*  841 */     paramFloat5 = MathUtils.sin(paramFloat5);
/*  842 */     float f3 = paramFloat3 * MathUtils.cos(paramFloat4 * 0.017453292F);
/*  843 */     paramFloat3 *= MathUtils.sin(paramFloat4 * 0.017453292F);
/*      */     
/*  845 */     if (this.shapeType == ShapeType.Line) {
/*  846 */       check(ShapeType.Line, ShapeType.Filled, (paramInt << 1) + 2);
/*      */       
/*  848 */       this.renderer.color(f1);
/*  849 */       this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
/*  850 */       this.renderer.color(f1);
/*  851 */       this.renderer.vertex(paramFloat1 + f3, paramFloat2 + paramFloat3, 0.0F);
/*  852 */       for (byte b = 0; b < paramInt; b++) {
/*  853 */         this.renderer.color(f1);
/*  854 */         this.renderer.vertex(paramFloat1 + f3, paramFloat2 + paramFloat3, 0.0F);
/*  855 */         float f = f3;
/*  856 */         f3 = f2 * f3 - paramFloat5 * paramFloat3;
/*  857 */         paramFloat3 = paramFloat5 * f + f2 * paramFloat3;
/*  858 */         this.renderer.color(f1);
/*  859 */         this.renderer.vertex(paramFloat1 + f3, paramFloat2 + paramFloat3, 0.0F);
/*      */       } 
/*  861 */       this.renderer.color(f1);
/*  862 */       this.renderer.vertex(paramFloat1 + f3, paramFloat2 + paramFloat3, 0.0F);
/*      */     } else {
/*  864 */       check(ShapeType.Line, ShapeType.Filled, paramInt * 3 + 3);
/*      */       
/*  866 */       for (byte b = 0; b < paramInt; b++) {
/*  867 */         this.renderer.color(f1);
/*  868 */         this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
/*  869 */         this.renderer.color(f1);
/*  870 */         this.renderer.vertex(paramFloat1 + f3, paramFloat2 + paramFloat3, 0.0F);
/*  871 */         float f = f3;
/*  872 */         f3 = f2 * f3 - paramFloat5 * paramFloat3;
/*  873 */         paramFloat3 = paramFloat5 * f + f2 * paramFloat3;
/*  874 */         this.renderer.color(f1);
/*  875 */         this.renderer.vertex(paramFloat1 + f3, paramFloat2 + paramFloat3, 0.0F);
/*      */       } 
/*  877 */       this.renderer.color(f1);
/*  878 */       this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
/*  879 */       this.renderer.color(f1);
/*  880 */       this.renderer.vertex(paramFloat1 + f3, paramFloat2 + paramFloat3, 0.0F);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  886 */     this.renderer.color(f1);
/*  887 */     this.renderer.vertex(paramFloat1 + 0.0F, paramFloat2 + 0.0F, 0.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   public void circle(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  892 */     circle(paramFloat1, paramFloat2, paramFloat3, Math.max(1, (int)(6.0F * (float)Math.cbrt(paramFloat3))));
/*      */   }
/*      */ 
/*      */   
/*      */   public void circle(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt) {
/*  897 */     if (paramInt <= 0) throw new IllegalArgumentException("segments must be > 0."); 
/*  898 */     float f1 = this.color.toFloatBits();
/*      */     
/*  900 */     float f2, f3 = MathUtils.cos(f2 = 6.2831855F / paramInt);
/*  901 */     f2 = MathUtils.sin(f2);
/*  902 */     float f4 = paramFloat3, f5 = 0.0F;
/*  903 */     if (this.shapeType == ShapeType.Line) {
/*  904 */       check(ShapeType.Line, ShapeType.Filled, (paramInt << 1) + 2);
/*  905 */       for (byte b = 0; b < paramInt; b++) {
/*  906 */         this.renderer.color(f1);
/*  907 */         this.renderer.vertex(paramFloat1 + f4, paramFloat2 + f5, 0.0F);
/*  908 */         float f = f4;
/*  909 */         f4 = f3 * f4 - f2 * f5;
/*  910 */         f5 = f2 * f + f3 * f5;
/*  911 */         this.renderer.color(f1);
/*  912 */         this.renderer.vertex(paramFloat1 + f4, paramFloat2 + f5, 0.0F);
/*      */       } 
/*      */       
/*  915 */       this.renderer.color(f1);
/*  916 */       this.renderer.vertex(paramFloat1 + f4, paramFloat2 + f5, 0.0F);
/*      */     } else {
/*  918 */       check(ShapeType.Line, ShapeType.Filled, paramInt * 3 + 3);
/*  919 */       paramInt--;
/*  920 */       for (byte b = 0; b < paramInt; b++) {
/*  921 */         this.renderer.color(f1);
/*  922 */         this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
/*  923 */         this.renderer.color(f1);
/*  924 */         this.renderer.vertex(paramFloat1 + f4, paramFloat2 + f5, 0.0F);
/*  925 */         float f = f4;
/*  926 */         f4 = f3 * f4 - f2 * f5;
/*  927 */         f5 = f2 * f + f3 * f5;
/*  928 */         this.renderer.color(f1);
/*  929 */         this.renderer.vertex(paramFloat1 + f4, paramFloat2 + f5, 0.0F);
/*      */       } 
/*      */       
/*  932 */       this.renderer.color(f1);
/*  933 */       this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
/*  934 */       this.renderer.color(f1);
/*  935 */       this.renderer.vertex(paramFloat1 + f4, paramFloat2 + f5, 0.0F);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  941 */     this.renderer.color(f1);
/*  942 */     this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2 + 0.0F, 0.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  948 */     ellipse(paramFloat1, paramFloat2, paramFloat3, paramFloat4, Math.max(1, (int)(12.0F * (float)Math.cbrt(Math.max(paramFloat3 * 0.5F, paramFloat4 * 0.5F)))));
/*      */   }
/*      */ 
/*      */   
/*      */   public void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt) {
/*  953 */     if (paramInt <= 0) throw new IllegalArgumentException("segments must be > 0."); 
/*  954 */     check(ShapeType.Line, ShapeType.Filled, paramInt * 3);
/*  955 */     float f1 = this.color.toFloatBits();
/*  956 */     float f2 = 6.2831855F / paramInt;
/*      */     
/*  958 */     paramFloat1 += paramFloat3 / 2.0F; paramFloat2 += paramFloat4 / 2.0F;
/*  959 */     if (this.shapeType == ShapeType.Line) {
/*  960 */       for (byte b1 = 0; b1 < paramInt; b1++) {
/*  961 */         this.renderer.color(f1);
/*  962 */         this.renderer.vertex(paramFloat1 + paramFloat3 * 0.5F * MathUtils.cos(b1 * f2), paramFloat2 + paramFloat4 * 0.5F * MathUtils.sin(b1 * f2), 0.0F);
/*      */         
/*  964 */         this.renderer.color(f1);
/*  965 */         this.renderer.vertex(paramFloat1 + paramFloat3 * 0.5F * MathUtils.cos((b1 + 1) * f2), paramFloat2 + paramFloat4 * 0.5F * 
/*  966 */             MathUtils.sin((b1 + 1) * f2), 0.0F);
/*      */       }  return;
/*      */     } 
/*  969 */     for (byte b = 0; b < paramInt; b++) {
/*  970 */       this.renderer.color(f1);
/*  971 */       this.renderer.vertex(paramFloat1 + paramFloat3 * 0.5F * MathUtils.cos(b * f2), paramFloat2 + paramFloat4 * 0.5F * MathUtils.sin(b * f2), 0.0F);
/*      */       
/*  973 */       this.renderer.color(f1);
/*  974 */       this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
/*      */       
/*  976 */       this.renderer.color(f1);
/*  977 */       this.renderer.vertex(paramFloat1 + paramFloat3 * 0.5F * MathUtils.cos((b + 1) * f2), paramFloat2 + paramFloat4 * 0.5F * 
/*  978 */           MathUtils.sin((b + 1) * f2), 0.0F);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/*  986 */     ellipse(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, Math.max(1, (int)(12.0F * (float)Math.cbrt(Math.max(paramFloat3 * 0.5F, paramFloat4 * 0.5F)))));
/*      */   }
/*      */ 
/*      */   
/*      */   public void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt) {
/*  991 */     if (paramInt <= 0) throw new IllegalArgumentException("segments must be > 0."); 
/*  992 */     check(ShapeType.Line, ShapeType.Filled, paramInt * 3);
/*  993 */     float f1 = this.color.toFloatBits();
/*  994 */     float f2 = 6.2831855F / paramInt;
/*      */ 
/*      */     
/*  997 */     float f3 = MathUtils.sin(paramFloat5 = 3.1415927F * paramFloat5 / 180.0F);
/*  998 */     paramFloat5 = MathUtils.cos(paramFloat5);
/*      */     
/* 1000 */     paramFloat1 += paramFloat3 / 2.0F; paramFloat2 += paramFloat4 / 2.0F;
/* 1001 */     float f4 = paramFloat3 * 0.5F;
/* 1002 */     float f5 = 0.0F;
/* 1003 */     if (this.shapeType == ShapeType.Line) {
/* 1004 */       for (byte b1 = 0; b1 < paramInt; b1++) {
/* 1005 */         this.renderer.color(f1);
/* 1006 */         this.renderer.vertex(paramFloat1 + paramFloat5 * f4 - f3 * f5, paramFloat2 + f3 * f4 + paramFloat5 * f5, 0.0F);
/*      */         
/* 1008 */         f4 = paramFloat3 * 0.5F * MathUtils.cos((b1 + 1) * f2);
/* 1009 */         f5 = paramFloat4 * 0.5F * MathUtils.sin((b1 + 1) * f2);
/*      */         
/* 1011 */         this.renderer.color(f1);
/* 1012 */         this.renderer.vertex(paramFloat1 + paramFloat5 * f4 - f3 * f5, paramFloat2 + f3 * f4 + paramFloat5 * f5, 0.0F);
/*      */       }  return;
/*      */     } 
/* 1015 */     for (byte b = 0; b < paramInt; b++) {
/* 1016 */       this.renderer.color(f1);
/* 1017 */       this.renderer.vertex(paramFloat1 + paramFloat5 * f4 - f3 * f5, paramFloat2 + f3 * f4 + paramFloat5 * f5, 0.0F);
/*      */       
/* 1019 */       this.renderer.color(f1);
/* 1020 */       this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
/*      */       
/* 1022 */       f4 = paramFloat3 * 0.5F * MathUtils.cos((b + 1) * f2);
/* 1023 */       f5 = paramFloat4 * 0.5F * MathUtils.sin((b + 1) * f2);
/*      */       
/* 1025 */       this.renderer.color(f1);
/* 1026 */       this.renderer.vertex(paramFloat1 + paramFloat5 * f4 - f3 * f5, paramFloat2 + f3 * f4 + paramFloat5 * f5, 0.0F);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void cone(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/* 1034 */     cone(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, Math.max(1, (int)(4.0F * (float)Math.sqrt(paramFloat4))));
/*      */   }
/*      */ 
/*      */   
/*      */   public void cone(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt) {
/* 1039 */     if (paramInt <= 0) throw new IllegalArgumentException("segments must be > 0."); 
/* 1040 */     check(ShapeType.Line, ShapeType.Filled, (paramInt << 2) + 2);
/* 1041 */     float f1 = this.color.toFloatBits();
/*      */     
/* 1043 */     float f2, f3 = MathUtils.cos(f2 = 6.2831855F / paramInt);
/* 1044 */     f2 = MathUtils.sin(f2);
/* 1045 */     float f4 = paramFloat4, f5 = 0.0F;
/* 1046 */     if (this.shapeType == ShapeType.Line) {
/* 1047 */       for (byte b = 0; b < paramInt; b++) {
/* 1048 */         this.renderer.color(f1);
/* 1049 */         this.renderer.vertex(paramFloat1 + f4, paramFloat2 + f5, paramFloat3);
/* 1050 */         this.renderer.color(f1);
/* 1051 */         this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + paramFloat5);
/* 1052 */         this.renderer.color(f1);
/* 1053 */         this.renderer.vertex(paramFloat1 + f4, paramFloat2 + f5, paramFloat3);
/* 1054 */         float f = f4;
/* 1055 */         f4 = f3 * f4 - f2 * f5;
/* 1056 */         f5 = f2 * f + f3 * f5;
/* 1057 */         this.renderer.color(f1);
/* 1058 */         this.renderer.vertex(paramFloat1 + f4, paramFloat2 + f5, paramFloat3);
/*      */       } 
/*      */       
/* 1061 */       this.renderer.color(f1);
/* 1062 */       this.renderer.vertex(paramFloat1 + f4, paramFloat2 + f5, paramFloat3);
/*      */     } else {
/* 1064 */       paramInt--;
/* 1065 */       for (byte b = 0; b < paramInt; b++) {
/* 1066 */         this.renderer.color(f1);
/* 1067 */         this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
/* 1068 */         this.renderer.color(f1);
/* 1069 */         this.renderer.vertex(paramFloat1 + f4, paramFloat2 + f5, paramFloat3);
/* 1070 */         float f8 = f4;
/* 1071 */         float f9 = f5;
/* 1072 */         f4 = f3 * f4 - f2 * f5;
/* 1073 */         f5 = f2 * f8 + f3 * f5;
/* 1074 */         this.renderer.color(f1);
/* 1075 */         this.renderer.vertex(paramFloat1 + f4, paramFloat2 + f5, paramFloat3);
/*      */         
/* 1077 */         this.renderer.color(f1);
/* 1078 */         this.renderer.vertex(paramFloat1 + f8, paramFloat2 + f9, paramFloat3);
/* 1079 */         this.renderer.color(f1);
/* 1080 */         this.renderer.vertex(paramFloat1 + f4, paramFloat2 + f5, paramFloat3);
/* 1081 */         this.renderer.color(f1);
/* 1082 */         this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + paramFloat5);
/*      */       } 
/*      */       
/* 1085 */       this.renderer.color(f1);
/* 1086 */       this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
/* 1087 */       this.renderer.color(f1);
/* 1088 */       this.renderer.vertex(paramFloat1 + f4, paramFloat2 + f5, paramFloat3);
/*      */     } 
/* 1090 */     float f6 = f4;
/* 1091 */     float f7 = f5;
/*      */ 
/*      */     
/* 1094 */     this.renderer.color(f1);
/* 1095 */     this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + 0.0F, paramFloat3);
/* 1096 */     if (this.shapeType != ShapeType.Line) {
/* 1097 */       this.renderer.color(f1);
/* 1098 */       this.renderer.vertex(paramFloat1 + f6, paramFloat2 + f7, paramFloat3);
/* 1099 */       this.renderer.color(f1);
/* 1100 */       this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + 0.0F, paramFloat3);
/* 1101 */       this.renderer.color(f1);
/* 1102 */       this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + paramFloat5);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void polygon(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 1109 */     if (paramInt2 < 6) throw new IllegalArgumentException("Polygons must contain at least 3 points."); 
/* 1110 */     if (paramInt2 % 2 != 0) throw new IllegalArgumentException("Polygons must have an even number of vertices.");
/*      */     
/* 1112 */     check(ShapeType.Line, null, paramInt2);
/* 1113 */     float f1 = this.color.toFloatBits();
/* 1114 */     float f2 = paramArrayOffloat[0];
/* 1115 */     float f3 = paramArrayOffloat[1];
/*      */     
/* 1117 */     for (int i = paramInt1; i < paramInt1; i += 2) {
/* 1118 */       float f6, f7, f4 = paramArrayOffloat[i];
/* 1119 */       float f5 = paramArrayOffloat[i + 1];
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1124 */       if (i + 2 >= paramInt2) {
/* 1125 */         f6 = f2;
/* 1126 */         f7 = f3;
/*      */       } else {
/* 1128 */         f6 = paramArrayOffloat[i + 2];
/* 1129 */         f7 = paramArrayOffloat[i + 3];
/*      */       } 
/*      */       
/* 1132 */       this.renderer.color(f1);
/* 1133 */       this.renderer.vertex(f4, f5, 0.0F);
/* 1134 */       this.renderer.color(f1);
/* 1135 */       this.renderer.vertex(f6, f7, 0.0F);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void polygon(float[] paramArrayOffloat) {
/* 1141 */     polygon(paramArrayOffloat, 0, paramArrayOffloat.length);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void polyline(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 1147 */     if (paramInt2 < 4) throw new IllegalArgumentException("Polylines must contain at least 2 points."); 
/* 1148 */     if (paramInt2 % 2 != 0) throw new IllegalArgumentException("Polylines must have an even number of vertices.");
/*      */     
/* 1150 */     check(ShapeType.Line, null, paramInt2);
/* 1151 */     float f = this.color.toFloatBits();
/* 1152 */     for (int i = paramInt1; i < paramInt1; i += 2) {
/* 1153 */       float f1 = paramArrayOffloat[i];
/* 1154 */       float f2 = paramArrayOffloat[i + 1];
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1159 */       float f3 = paramArrayOffloat[i + 2];
/* 1160 */       float f4 = paramArrayOffloat[i + 3];
/*      */       
/* 1162 */       this.renderer.color(f);
/* 1163 */       this.renderer.vertex(f1, f2, 0.0F);
/* 1164 */       this.renderer.color(f);
/* 1165 */       this.renderer.vertex(f3, f4, 0.0F);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void polyline(float[] paramArrayOffloat) {
/* 1171 */     polyline(paramArrayOffloat, 0, paramArrayOffloat.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void check(ShapeType paramShapeType1, ShapeType paramShapeType2, int paramInt) {
/* 1181 */     if (this.shapeType == null) throw new IllegalStateException("begin must be called first.");
/*      */     
/* 1183 */     if (this.shapeType != paramShapeType1 && this.shapeType != paramShapeType2) {
/*      */       
/* 1185 */       if (!this.autoShapeType) {
/* 1186 */         if (paramShapeType2 == null) {
/* 1187 */           throw new IllegalStateException("Must call begin(ShapeType." + paramShapeType1 + ").");
/*      */         }
/* 1189 */         throw new IllegalStateException("Must call begin(ShapeType." + paramShapeType1 + ") or begin(ShapeType." + paramShapeType2 + ").");
/*      */       } 
/* 1191 */       end();
/* 1192 */       begin(paramShapeType1); return;
/* 1193 */     }  if (this.matrixDirty) {
/*      */       
/* 1195 */       paramShapeType1 = this.shapeType;
/* 1196 */       end();
/* 1197 */       begin(paramShapeType1); return;
/* 1198 */     }  if (this.renderer.getMaxVertices() - this.renderer.getNumVertices() < paramInt) {
/*      */       
/* 1200 */       paramShapeType1 = this.shapeType;
/* 1201 */       end();
/* 1202 */       begin(paramShapeType1);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void end() {
/* 1208 */     this.renderer.end();
/* 1209 */     this.shapeType = null;
/*      */   }
/*      */   
/*      */   public void flush() {
/*      */     ShapeType shapeType;
/* 1214 */     if ((shapeType = this.shapeType) == null)
/* 1215 */       return;  end();
/* 1216 */     begin(shapeType);
/*      */   }
/*      */ 
/*      */   
/*      */   public ShapeType getCurrentType() {
/* 1221 */     return this.shapeType;
/*      */   }
/*      */   
/*      */   public ImmediateModeRenderer getRenderer() {
/* 1225 */     return this.renderer;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isDrawing() {
/* 1230 */     return (this.shapeType != null);
/*      */   }
/*      */   
/*      */   public void dispose() {
/* 1234 */     this.renderer.dispose();
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\ShapeRenderer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */