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
/*    */ 
/*    */ @FunctionalInterface
/*    */ public interface FunctionProvider
/*    */ {
/*    */   default long getFunctionAddress(CharSequence paramCharSequence) {
/* 17 */     MemoryStack memoryStack = MemoryStack.stackPush(); Throwable throwable = null; 
/* 18 */     try { return getFunctionAddress(memoryStack.ASCII(paramCharSequence)); } catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/* 19 */     finally { if (memoryStack != null) if (throwable != null) { try { memoryStack.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }
/*    */           }
/*    */   
/*    */   }
/*    */   
/*    */   long getFunctionAddress(ByteBuffer paramByteBuffer);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\FunctionProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */