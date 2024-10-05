/*    */ package org.lwjgl.system.macosx;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.MemoryStack;
/*    */ import org.lwjgl.system.SharedLibraryUtil;
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
/*    */ public class MacOSXLibraryDL
/*    */   extends MacOSXLibrary
/*    */ {
/*    */   public MacOSXLibraryDL(String paramString) {
/* 20 */     this(paramString, loadLibrary(paramString));
/*    */   }
/*    */   
/*    */   public MacOSXLibraryDL(String paramString, long paramLong) {
/* 24 */     super(paramString, paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   private static long loadLibrary(String paramString) {
/* 29 */     try (MemoryStack null = MemoryStack.stackPush()) {
/* 30 */       long l = DynamicLinkLoader.dlopen(memoryStack.UTF8(paramString), 5);
/*    */     } 
/* 32 */     if (throwable == 0L) {
/* 33 */       throw new UnsatisfiedLinkError("Failed to dynamically load library: " + paramString + "(error = " + DynamicLinkLoader.dlerror() + ")");
/*    */     }
/* 35 */     return throwable;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getPath() {
/* 41 */     return SharedLibraryUtil.getLibraryPath(address());
/*    */   }
/*    */ 
/*    */   
/*    */   public long getFunctionAddress(ByteBuffer paramByteBuffer) {
/* 46 */     return DynamicLinkLoader.dlsym(address(), paramByteBuffer);
/*    */   }
/*    */ 
/*    */   
/*    */   public void free() {
/* 51 */     DynamicLinkLoader.dlclose(address());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\macosx\MacOSXLibraryDL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */