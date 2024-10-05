/*    */ package com.crashinvaders.basisu.gdx;
/*    */ 
/*    */ import com.badlogic.gdx.utils.BufferUtils;
/*    */ import java.nio.ByteBuffer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BasisuBufferUtils
/*    */ {
/*    */   public static boolean isUnsafeByteBuffer(ByteBuffer paramByteBuffer) {
/* 15 */     return BufferUtils.isUnsafeByteBuffer(paramByteBuffer);
/*    */   }
/*    */   
/*    */   public static ByteBuffer newUnsafeByteBuffer(int paramInt) {
/* 19 */     return BufferUtils.newUnsafeByteBuffer(paramInt);
/*    */   }
/*    */   
/*    */   public static void disposeUnsafeByteBuffer(ByteBuffer paramByteBuffer) {
/* 23 */     BufferUtils.disposeUnsafeByteBuffer(paramByteBuffer);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\crashinvaders\basisu\gdx\BasisuBufferUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */