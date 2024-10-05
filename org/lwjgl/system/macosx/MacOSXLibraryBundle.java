/*    */ package org.lwjgl.system.macosx;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.MemoryStack;
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
/*    */ public class MacOSXLibraryBundle
/*    */   extends MacOSXLibrary
/*    */ {
/*    */   public MacOSXLibraryBundle(String paramString, long paramLong) {
/* 21 */     super(paramString, paramLong);
/*    */   }
/*    */   
/*    */   public static MacOSXLibraryBundle getWithIdentifier(String paramString) {
/* 25 */     long l = 0L; try {
/* 26 */       MemoryStack memoryStack = MemoryStack.stackPush(); Throwable throwable2 = null;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     }
/*    */     finally {
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 37 */       if (l != 0L) {
/* 38 */         CoreFoundation.CFRelease(l);
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   public static MacOSXLibraryBundle create(String paramString) {
/* 44 */     long l1 = 0L;
/* 45 */     long l2 = 0L; try {
/* 46 */       MemoryStack memoryStack = MemoryStack.stackPush();
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     }
/*    */     finally {
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 57 */       if (l2 != 0L) {
/* 58 */         CoreFoundation.CFRelease(l2);
/*    */       }
/* 60 */       if (l1 != 0L) {
/* 61 */         CoreFoundation.CFRelease(l1);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String getPath() {
/* 68 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getFunctionAddress(ByteBuffer paramByteBuffer) {
/* 73 */     long l = CString2CFString(paramByteBuffer, 1536);
/*    */     try {
/* 75 */       return CoreFoundation.CFBundleGetFunctionPointerForName(address(), l);
/*    */     } finally {
/* 77 */       CoreFoundation.CFRelease(l);
/*    */     } 
/*    */   }
/*    */   
/*    */   private static long CString2CFString(ByteBuffer paramByteBuffer, int paramInt) {
/* 82 */     return Checks.check(CoreFoundation.CFStringCreateWithCStringNoCopy(0L, paramByteBuffer, paramInt, CoreFoundation.kCFAllocatorNull));
/*    */   }
/*    */ 
/*    */   
/*    */   public void free() {
/* 87 */     CoreFoundation.CFRelease(address());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\macosx\MacOSXLibraryBundle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */