/*    */ package io.github.classgraph;
/*    */ 
/*    */ import java.io.Closeable;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CloseableByteBuffer
/*    */   implements Closeable
/*    */ {
/*    */   private ByteBuffer byteBuffer;
/*    */   private Runnable onClose;
/*    */   
/*    */   CloseableByteBuffer(ByteBuffer paramByteBuffer, Runnable paramRunnable) {
/* 53 */     this.byteBuffer = paramByteBuffer;
/* 54 */     this.onClose = paramRunnable;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ByteBuffer getByteBuffer() {
/* 61 */     return this.byteBuffer;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void close() {
/* 67 */     if (this.onClose != null) {
/*    */       try {
/* 69 */         this.onClose.run();
/* 70 */       } catch (Exception exception) {}
/*    */ 
/*    */       
/* 73 */       this.onClose = null;
/*    */     } 
/* 75 */     this.byteBuffer = null;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\CloseableByteBuffer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */