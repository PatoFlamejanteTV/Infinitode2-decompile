/*    */ package org.lwjgl.system.windows;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.Library;
/*    */ import org.lwjgl.system.MemoryStack;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.SharedLibrary;
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
/*    */ public class WindowsLibrary
/*    */   extends SharedLibrary.Default
/*    */ {
/*    */   public static final long HINSTANCE;
/*    */   
/*    */   static {
/* 24 */     MemoryStack memoryStack = MemoryStack.stackPush(); Throwable throwable = null;
/*    */     
/* 26 */     try { if ((HINSTANCE = WinBase.GetModuleHandle(memoryStack.UTF16(Library.JNI_LIBRARY_NAME))) == 0L)
/* 27 */         throw new RuntimeException("Failed to retrieve LWJGL module handle.");  }
/*    */     catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/* 29 */     finally { if (memoryStack != null) if (throwable != null) { try { memoryStack.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }
/*    */           }
/*    */   
/*    */   } public WindowsLibrary(String paramString) {
/* 33 */     this(paramString, loadLibrary(paramString));
/*    */   }
/*    */   
/*    */   public WindowsLibrary(String paramString, long paramLong) {
/* 37 */     super(paramString, paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   private static long loadLibrary(String paramString) {
/* 42 */     try (MemoryStack null = MemoryStack.stackPush()) {
/* 43 */       long l = WinBase.LoadLibrary(memoryStack.UTF16(paramString));
/*    */     } 
/* 45 */     if (throwable == 0L) {
/* 46 */       throw new UnsatisfiedLinkError("Failed to load library: " + paramString + " (error code = " + WinBase.getLastError() + ")");
/*    */     }
/* 48 */     return throwable;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getPath() {
/* 54 */     char c = 'Ā';
/*    */     
/* 56 */     ByteBuffer byteBuffer = MemoryUtil.memAlloc(256); try {
/*    */       while (true) {
/*    */         String str;
/* 59 */         int j = WinBase.GetModuleFileName(address(), byteBuffer);
/*    */         int k;
/* 61 */         if ((k = WinBase.getLastError()) == 0) {
/* 62 */           str = (j == 0) ? null : MemoryUtil.memUTF16(byteBuffer, j); return str;
/*    */         } 
/* 64 */         if (k != 122) {
/* 65 */           str = null; return str;
/*    */         }  int i;
/* 67 */         byteBuffer = MemoryUtil.memRealloc(byteBuffer, i = str * 3 / 2);
/*    */       } 
/*    */     } finally {
/* 70 */       MemoryUtil.memFree(byteBuffer);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public long getFunctionAddress(ByteBuffer paramByteBuffer) {
/* 76 */     return WinBase.GetProcAddress(address(), paramByteBuffer);
/*    */   }
/*    */ 
/*    */   
/*    */   public void free() {
/* 81 */     if (!WinBase.FreeLibrary(address()))
/* 82 */       WindowsUtil.windowsThrowException("Failed to unload library: " + getName()); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\WindowsLibrary.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */