/*     */ package com.badlogic.gdx.scenes.scene2d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Camera;
/*     */ import com.badlogic.gdx.graphics.glutils.HdpiUtils;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
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
/*     */ public class ScissorStack
/*     */ {
/*  34 */   private static Array<Rectangle> scissors = new Array();
/*  35 */   static Vector3 tmp = new Vector3();
/*  36 */   static final Rectangle viewport = new Rectangle();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean pushScissors(Rectangle paramRectangle) {
/*  47 */     fix(paramRectangle);
/*     */     
/*  49 */     if (scissors.size == 0) {
/*  50 */       if (paramRectangle.width < 1.0F || paramRectangle.height < 1.0F) return false; 
/*  51 */       Gdx.gl.glEnable(3089);
/*     */     } else {
/*     */       Rectangle rectangle;
/*     */       
/*  55 */       float f2 = Math.max((rectangle = (Rectangle)scissors.get(scissors.size - 1)).x, paramRectangle.x);
/*     */       float f3;
/*  57 */       if ((f3 = Math.min(rectangle.x + rectangle.width, paramRectangle.x + paramRectangle.width)) - f2 < 1.0F) return false;
/*     */       
/*  59 */       float f4 = Math.max(rectangle.y, paramRectangle.y);
/*     */       float f1;
/*  61 */       if ((f1 = Math.min(rectangle.y + rectangle.height, paramRectangle.y + paramRectangle.height)) - f4 < 1.0F) return false;
/*     */       
/*  63 */       paramRectangle.x = f2;
/*  64 */       paramRectangle.y = f4;
/*  65 */       paramRectangle.width = f3 - f2;
/*  66 */       paramRectangle.height = Math.max(1.0F, f1 - f4);
/*     */     } 
/*  68 */     scissors.add(paramRectangle);
/*  69 */     HdpiUtils.glScissor((int)paramRectangle.x, (int)paramRectangle.y, (int)paramRectangle.width, (int)paramRectangle.height);
/*  70 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Rectangle popScissors() {
/*  78 */     Rectangle rectangle = (Rectangle)scissors.pop();
/*  79 */     if (scissors.size == 0) {
/*  80 */       Gdx.gl.glDisable(3089);
/*     */     } else {
/*     */       Rectangle rectangle1;
/*  83 */       HdpiUtils.glScissor((int)(rectangle1 = (Rectangle)scissors.peek()).x, (int)rectangle1.y, (int)rectangle1.width, (int)rectangle1.height);
/*     */     } 
/*  85 */     return rectangle;
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public static Rectangle peekScissors() {
/*  91 */     if (scissors.size == 0) return null; 
/*  92 */     return (Rectangle)scissors.peek();
/*     */   }
/*     */   
/*     */   private static void fix(Rectangle paramRectangle) {
/*  96 */     paramRectangle.x = Math.round(paramRectangle.x);
/*  97 */     paramRectangle.y = Math.round(paramRectangle.y);
/*  98 */     paramRectangle.width = Math.round(paramRectangle.width);
/*  99 */     paramRectangle.height = Math.round(paramRectangle.height);
/* 100 */     if (paramRectangle.width < 0.0F) {
/* 101 */       paramRectangle.width = -paramRectangle.width;
/* 102 */       paramRectangle.x -= paramRectangle.width;
/*     */     } 
/* 104 */     if (paramRectangle.height < 0.0F) {
/* 105 */       paramRectangle.height = -paramRectangle.height;
/* 106 */       paramRectangle.y -= paramRectangle.height;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void calculateScissors(Camera paramCamera, Matrix4 paramMatrix4, Rectangle paramRectangle1, Rectangle paramRectangle2) {
/* 113 */     calculateScissors(paramCamera, 0.0F, 0.0F, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), paramMatrix4, paramRectangle1, paramRectangle2);
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
/*     */   public static void calculateScissors(Camera paramCamera, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Matrix4 paramMatrix4, Rectangle paramRectangle1, Rectangle paramRectangle2) {
/* 127 */     tmp.set(paramRectangle1.x, paramRectangle1.y, 0.0F);
/* 128 */     tmp.mul(paramMatrix4);
/* 129 */     paramCamera.project(tmp, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 130 */     paramRectangle2.x = tmp.x;
/* 131 */     paramRectangle2.y = tmp.y;
/*     */     
/* 133 */     tmp.set(paramRectangle1.x + paramRectangle1.width, paramRectangle1.y + paramRectangle1.height, 0.0F);
/* 134 */     tmp.mul(paramMatrix4);
/* 135 */     paramCamera.project(tmp, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 136 */     paramRectangle2.width = tmp.x - paramRectangle2.x;
/* 137 */     paramRectangle2.height = tmp.y - paramRectangle2.y;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Rectangle getViewport() {
/* 142 */     if (scissors.size == 0) {
/* 143 */       viewport.set(0.0F, 0.0F, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
/* 144 */       return viewport;
/*     */     } 
/* 146 */     Rectangle rectangle = (Rectangle)scissors.peek();
/* 147 */     viewport.set(rectangle);
/* 148 */     return viewport;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\utils\ScissorStack.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */