/*    */ package com.badlogic.gdx.graphics.profiling;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*    */ public interface GLErrorListener
/*    */ {
/* 36 */   public static final GLErrorListener LOGGING_LISTENER = new GLErrorListener()
/*    */     {
/*    */       public void onError(int param1Int) {
/* 39 */         String str = null;
/*    */         try {
/* 41 */           StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
/* 42 */           for (byte b = 0; b < arrayOfStackTraceElement.length; b++) {
/* 43 */             if ("check".equals(arrayOfStackTraceElement[b].getMethodName())) {
/* 44 */               if (b + 1 < arrayOfStackTraceElement.length) {
/*    */                 StackTraceElement stackTraceElement;
/* 46 */                 str = (stackTraceElement = arrayOfStackTraceElement[b + 1]).getMethodName();
/*    */               } 
/*    */               break;
/*    */             } 
/*    */           } 
/* 51 */         } catch (Exception exception) {}
/*    */ 
/*    */         
/* 54 */         if (str != null) {
/* 55 */           Gdx.app.error("GLProfiler", "Error " + GLInterceptor.resolveErrorNumber(param1Int) + " from " + str); return;
/*    */         } 
/* 57 */         Gdx.app.error("GLProfiler", "Error " + GLInterceptor.resolveErrorNumber(param1Int) + " at: ", new Exception());
/*    */       }
/*    */     };
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 64 */   public static final GLErrorListener THROWING_LISTENER = new GLErrorListener()
/*    */     {
/*    */       public void onError(int param1Int) {
/* 67 */         throw new GdxRuntimeException("GLProfiler: Got GL error " + GLInterceptor.resolveErrorNumber(param1Int));
/*    */       }
/*    */     };
/*    */   
/*    */   void onError(int paramInt);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\profiling\GLErrorListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */