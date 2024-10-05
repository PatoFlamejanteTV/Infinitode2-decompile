/*    */ package com.crashinvaders.basisu.gdx;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.utils.BufferUtils;
/*    */ import java.nio.Buffer;
/*    */ import java.nio.IntBuffer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BasisuGdxGl
/*    */ {
/*    */   public static int[] getSupportedTextureFormats() {
/* 19 */     IntBuffer intBuffer = BufferUtils.newIntBuffer(64);
/* 20 */     Gdx.gl.glGetIntegerv(34466, intBuffer);
/* 21 */     int i = intBuffer.get(0);
/* 22 */     if (intBuffer.capacity() < i) {
/* 23 */       intBuffer = BufferUtils.newIntBuffer(i);
/*    */     }
/* 25 */     int[] arrayOfInt = new int[i];
/* 26 */     Gdx.gl.glGetIntegerv(34467, intBuffer);
/* 27 */     for (byte b = 0; b < i; b++) {
/* 28 */       int j = intBuffer.get(b);
/* 29 */       arrayOfInt[b] = j;
/*    */     } 
/* 31 */     return arrayOfInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glCompressedTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, Buffer paramBuffer) {
/* 42 */     Gdx.gl.glCompressedTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramBuffer);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\crashinvaders\basisu\gdx\BasisuGdxGl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */