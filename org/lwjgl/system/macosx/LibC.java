/*    */ package org.lwjgl.system.macosx;
/*    */ 
/*    */ import org.lwjgl.system.APIUtil;
/*    */ import org.lwjgl.system.FunctionProvider;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.NativeType;
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
/*    */ public class LibC
/*    */ {
/*    */   public static final class Functions
/*    */   {
/* 23 */     public static final long getpid = APIUtil.apiGetFunctionAddress((FunctionProvider)LibSystem.getLibrary(), "getpid");
/*    */   }
/*    */ 
/*    */   
/*    */   protected LibC() {
/* 28 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("pid_t")
/*    */   public static long getpid() {
/*    */     long l;
/* 37 */     return JNI.invokeP(l = Functions.getpid);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\macosx\LibC.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */