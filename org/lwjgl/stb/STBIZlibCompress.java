/*    */ package org.lwjgl.stb;
/*    */ 
/*    */ import org.lwjgl.system.Callback;
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
/*    */ 
/*    */ public abstract class STBIZlibCompress
/*    */   extends Callback
/*    */   implements STBIZlibCompressI
/*    */ {
/*    */   public static STBIZlibCompress create(long paramLong) {
/*    */     STBIZlibCompressI sTBIZlibCompressI;
/* 36 */     return (sTBIZlibCompressI = (STBIZlibCompressI)Callback.get(paramLong) instanceof STBIZlibCompress) ? (STBIZlibCompress)sTBIZlibCompressI : new Container(paramLong, sTBIZlibCompressI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static STBIZlibCompress createSafe(long paramLong) {
/* 44 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static STBIZlibCompress create(STBIZlibCompressI paramSTBIZlibCompressI) {
/* 49 */     return (paramSTBIZlibCompressI instanceof STBIZlibCompress) ? (STBIZlibCompress)paramSTBIZlibCompressI : new Container(paramSTBIZlibCompressI
/*    */         
/* 51 */         .address(), paramSTBIZlibCompressI);
/*    */   }
/*    */   
/*    */   protected STBIZlibCompress() {
/* 55 */     super(CIF);
/*    */   }
/*    */   
/*    */   STBIZlibCompress(long paramLong) {
/* 59 */     super(paramLong);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends STBIZlibCompress {
/*    */     private final STBIZlibCompressI delegate;
/*    */     
/*    */     Container(long param1Long, STBIZlibCompressI param1STBIZlibCompressI) {
/* 67 */       super(param1Long);
/* 68 */       this.delegate = param1STBIZlibCompressI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final long invoke(long param1Long1, int param1Int1, long param1Long2, int param1Int2) {
/* 73 */       return this.delegate.invoke(param1Long1, param1Int1, param1Long2, param1Int2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBIZlibCompress.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */