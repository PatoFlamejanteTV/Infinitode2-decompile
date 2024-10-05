/*    */ package org.lwjgl.system;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface FunctionProviderLocal
/*    */   extends FunctionProvider
/*    */ {
/*    */   default long getFunctionAddress(long paramLong, CharSequence paramCharSequence) {
/* 16 */     try (MemoryStack null = MemoryStack.stackPush()) {
/* 17 */       return getFunctionAddress(paramLong, memoryStack.ASCII(paramCharSequence));
/*    */     } 
/*    */   }
/*    */   
/*    */   long getFunctionAddress(long paramLong, ByteBuffer paramByteBuffer);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\FunctionProviderLocal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */