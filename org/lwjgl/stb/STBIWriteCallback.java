/*    */ package org.lwjgl.stb;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.Callback;
/*    */ import org.lwjgl.system.MemoryUtil;
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
/*    */ 
/*    */ 
/*    */ public abstract class STBIWriteCallback
/*    */   extends Callback
/*    */   implements STBIWriteCallbackI
/*    */ {
/*    */   public static STBIWriteCallback create(long paramLong) {
/*    */     STBIWriteCallbackI sTBIWriteCallbackI;
/* 37 */     return (sTBIWriteCallbackI = (STBIWriteCallbackI)Callback.get(paramLong) instanceof STBIWriteCallback) ? (STBIWriteCallback)sTBIWriteCallbackI : new Container(paramLong, sTBIWriteCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static STBIWriteCallback createSafe(long paramLong) {
/* 45 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static STBIWriteCallback create(STBIWriteCallbackI paramSTBIWriteCallbackI) {
/* 50 */     return (paramSTBIWriteCallbackI instanceof STBIWriteCallback) ? (STBIWriteCallback)paramSTBIWriteCallbackI : new Container(paramSTBIWriteCallbackI
/*    */         
/* 52 */         .address(), paramSTBIWriteCallbackI);
/*    */   }
/*    */   
/*    */   protected STBIWriteCallback() {
/* 56 */     super(CIF);
/*    */   }
/*    */   
/*    */   STBIWriteCallback(long paramLong) {
/* 60 */     super(paramLong);
/*    */   }
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
/*    */   public static ByteBuffer getData(long paramLong, int paramInt) {
/* 74 */     return MemoryUtil.memByteBuffer(paramLong, paramInt);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends STBIWriteCallback {
/*    */     private final STBIWriteCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, STBIWriteCallbackI param1STBIWriteCallbackI) {
/* 82 */       super(param1Long);
/* 83 */       this.delegate = param1STBIWriteCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long1, long param1Long2, int param1Int) {
/* 88 */       this.delegate.invoke(param1Long1, param1Long2, param1Int);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBIWriteCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */