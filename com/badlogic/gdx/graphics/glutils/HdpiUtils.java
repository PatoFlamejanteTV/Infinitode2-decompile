/*    */ package com.badlogic.gdx.graphics.glutils;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HdpiUtils
/*    */ {
/* 29 */   private static HdpiMode mode = HdpiMode.Logical;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void setMode(HdpiMode paramHdpiMode) {
/* 46 */     mode = paramHdpiMode;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glScissor(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 52 */     if (mode == HdpiMode.Logical && (Gdx.graphics.getWidth() != Gdx.graphics.getBackBufferWidth() || Gdx.graphics
/* 53 */       .getHeight() != Gdx.graphics.getBackBufferHeight())) {
/* 54 */       Gdx.gl.glScissor(toBackBufferX(paramInt1), toBackBufferY(paramInt2), toBackBufferX(paramInt3), toBackBufferY(paramInt4)); return;
/*    */     } 
/* 56 */     Gdx.gl.glScissor(paramInt1, paramInt2, paramInt3, paramInt4);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glViewport(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 63 */     if (mode == HdpiMode.Logical && (Gdx.graphics.getWidth() != Gdx.graphics.getBackBufferWidth() || Gdx.graphics
/* 64 */       .getHeight() != Gdx.graphics.getBackBufferHeight())) {
/* 65 */       Gdx.gl.glViewport(toBackBufferX(paramInt1), toBackBufferY(paramInt2), toBackBufferX(paramInt3), toBackBufferY(paramInt4)); return;
/*    */     } 
/* 67 */     Gdx.gl.glViewport(paramInt1, paramInt2, paramInt3, paramInt4);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static int toLogicalX(int paramInt) {
/* 73 */     return (int)((paramInt * Gdx.graphics.getWidth()) / Gdx.graphics.getBackBufferWidth());
/*    */   }
/*    */ 
/*    */   
/*    */   public static int toLogicalY(int paramInt) {
/* 78 */     return (int)((paramInt * Gdx.graphics.getHeight()) / Gdx.graphics.getBackBufferHeight());
/*    */   }
/*    */ 
/*    */   
/*    */   public static int toBackBufferX(int paramInt) {
/* 83 */     return (int)((paramInt * Gdx.graphics.getBackBufferWidth()) / Gdx.graphics.getWidth());
/*    */   }
/*    */ 
/*    */   
/*    */   public static int toBackBufferY(int paramInt) {
/* 88 */     return (int)((paramInt * Gdx.graphics.getBackBufferHeight()) / Gdx.graphics.getHeight());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\HdpiUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */