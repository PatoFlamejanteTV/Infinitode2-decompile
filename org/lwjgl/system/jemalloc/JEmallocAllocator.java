/*    */ package org.lwjgl.system.jemalloc;
/*    */ 
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JEmallocAllocator
/*    */   implements MemoryUtil.MemoryAllocator
/*    */ {
/*    */   static {
/* 17 */     JEmalloc.getLibrary();
/*    */   }
/*    */   
/*    */   public long getMalloc() {
/* 21 */     return JEmalloc.Functions.malloc;
/*    */   }
/*    */   public long getCalloc() {
/* 24 */     return JEmalloc.Functions.calloc;
/*    */   }
/*    */   public long getRealloc() {
/* 27 */     return JEmalloc.Functions.realloc;
/*    */   }
/*    */   public long getFree() {
/* 30 */     return JEmalloc.Functions.free;
/*    */   }
/*    */   public long getAlignedAlloc() {
/* 33 */     return JEmalloc.Functions.aligned_alloc;
/*    */   }
/*    */   public long getAlignedFree() {
/* 36 */     return JEmalloc.Functions.free;
/*    */   }
/*    */   
/*    */   public long malloc(long paramLong) {
/* 40 */     return JEmalloc.nje_malloc(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public long calloc(long paramLong1, long paramLong2) {
/* 45 */     return JEmalloc.nje_calloc(paramLong1, paramLong2);
/*    */   }
/*    */ 
/*    */   
/*    */   public long realloc(long paramLong1, long paramLong2) {
/* 50 */     return JEmalloc.nje_realloc(paramLong1, paramLong2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void free(long paramLong) {
/* 55 */     JEmalloc.nje_free(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public long aligned_alloc(long paramLong1, long paramLong2) {
/* 60 */     return JEmalloc.nje_aligned_alloc(paramLong1, paramLong2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void aligned_free(long paramLong) {
/* 65 */     JEmalloc.nje_free(paramLong);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\jemalloc\JEmallocAllocator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */