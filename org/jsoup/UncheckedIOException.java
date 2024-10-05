/*    */ package org.jsoup;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.UncheckedIOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UncheckedIOException
/*    */   extends UncheckedIOException
/*    */ {
/*    */   public UncheckedIOException(IOException paramIOException) {
/* 12 */     super(paramIOException);
/*    */   }
/*    */   
/*    */   public UncheckedIOException(String paramString) {
/* 16 */     super(new IOException(paramString));
/*    */   }
/*    */   
/*    */   public IOException ioException() {
/* 20 */     return getCause();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\UncheckedIOException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */