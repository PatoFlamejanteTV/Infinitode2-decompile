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
/*    */ public abstract class STBIReadCallback
/*    */   extends Callback
/*    */   implements STBIReadCallbackI
/*    */ {
/*    */   public static STBIReadCallback create(long paramLong) {
/*    */     STBIReadCallbackI sTBIReadCallbackI;
/* 37 */     return (sTBIReadCallbackI = (STBIReadCallbackI)Callback.get(paramLong) instanceof STBIReadCallback) ? (STBIReadCallback)sTBIReadCallbackI : new Container(paramLong, sTBIReadCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static STBIReadCallback createSafe(long paramLong) {
/* 45 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static STBIReadCallback create(STBIReadCallbackI paramSTBIReadCallbackI) {
/* 50 */     return (paramSTBIReadCallbackI instanceof STBIReadCallback) ? (STBIReadCallback)paramSTBIReadCallbackI : new Container(paramSTBIReadCallbackI
/*    */         
/* 52 */         .address(), paramSTBIReadCallbackI);
/*    */   }
/*    */   
/*    */   protected STBIReadCallback() {
/* 56 */     super(CIF);
/*    */   }
/*    */   
/*    */   STBIReadCallback(long paramLong) {
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
/*    */     extends STBIReadCallback {
/*    */     private final STBIReadCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, STBIReadCallbackI param1STBIReadCallbackI) {
/* 82 */       super(param1Long);
/* 83 */       this.delegate = param1STBIReadCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final int invoke(long param1Long1, long param1Long2, int param1Int) {
/* 88 */       return this.delegate.invoke(param1Long1, param1Long2, param1Int);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBIReadCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */