/*    */ package org.lwjgl.stb;
/*    */ 
/*    */ import org.lwjgl.system.Configuration;
/*    */ import org.lwjgl.system.Library;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.Platform;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class LibSTB
/*    */ {
/*    */   static {
/* 16 */     String str = Platform.mapLibraryNameBundled("lwjgl_stb");
/* 17 */     Library.loadSystem(System::load, System::loadLibrary, LibSTB.class, "org.lwjgl.stb", str);
/*    */     
/*    */     MemoryUtil.MemoryAllocator memoryAllocator;
/* 20 */     setupMalloc((memoryAllocator = MemoryUtil.getAllocator(((Boolean)Configuration.DEBUG_MEMORY_ALLOCATOR_INTERNAL.get(Boolean.TRUE)).booleanValue()))
/* 21 */         .getMalloc(), memoryAllocator
/* 22 */         .getCalloc(), memoryAllocator
/* 23 */         .getRealloc(), memoryAllocator
/* 24 */         .getFree(), memoryAllocator
/* 25 */         .getAlignedAlloc(), memoryAllocator
/* 26 */         .getAlignedFree());
/*    */   }
/*    */   
/*    */   private static native void setupMalloc(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   static void initialize() {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\LibSTB.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */