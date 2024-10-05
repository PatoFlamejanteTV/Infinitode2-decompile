/*    */ package org.lwjgl.glfw;
/*    */ 
/*    */ import org.lwjgl.system.Configuration;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.Platform;
/*    */ import org.lwjgl.system.macosx.LibC;
/*    */ import org.lwjgl.system.macosx.ObjCRuntime;
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
/*    */ final class EventLoop
/*    */ {
/*    */   static void check() {
/* 30 */     if (Platform.get() == Platform.MACOSX && !isMainThread())
/*    */     {
/* 32 */       throw new IllegalStateException(
/* 33 */           isJavaStartedOnFirstThread() ? "GLFW may only be used on the main thread. This check may be disabled with Configuration.GLFW_CHECK_THREAD0." : "GLFW may only be used on the main thread and that thread must be the first thread in the process. Please run the JVM with -XstartOnFirstThread. This check may be disabled with Configuration.GLFW_CHECK_THREAD0.");
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static boolean isMainThread() {
/* 42 */     if (!((Boolean)Configuration.GLFW_CHECK_THREAD0.get(Boolean.TRUE)).booleanValue() || ((String)Configuration.GLFW_LIBRARY_NAME.get("")).contains("glfw_async")) {
/* 43 */       return true;
/*    */     }
/*    */     
/* 46 */     long l1 = ObjCRuntime.getLibrary().getFunctionAddress("objc_msgSend");
/*    */ 
/*    */     
/*    */     long l2, l3;
/*    */     
/* 51 */     return JNI.invokePPZ(l3 = JNI.invokePPP(l2 = ObjCRuntime.objc_getClass("NSThread"), ObjCRuntime.sel_getUid("currentThread"), l1), ObjCRuntime.sel_getUid("isMainThread"), l1);
/*    */   }
/*    */   
/*    */   private static boolean isJavaStartedOnFirstThread() {
/* 55 */     return "1".equals(System.getenv().get("JAVA_STARTED_ON_FIRST_THREAD_" + LibC.getpid()));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\EventLoop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */