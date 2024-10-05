/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import sun.misc.Unsafe;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface Pointer
/*     */ {
/*     */   public static final int POINTER_SIZE;
/*  31 */   public static final int POINTER_SHIFT = ((POINTER_SIZE = MemoryAccessJNI.getPointerSize()) == 8) ? 3 : 2;
/*     */ 
/*     */   
/*     */   public static final int CLONG_SIZE;
/*     */ 
/*     */   
/*  37 */   public static final int CLONG_SHIFT = ((CLONG_SIZE = (POINTER_SIZE == 8 && Platform.get() == Platform.WINDOWS) ? 4 : POINTER_SIZE) == 8) ? 3 : 2;
/*     */ 
/*     */   
/*  40 */   public static final boolean BITS32 = (POINTER_SIZE << 3 == 32);
/*     */ 
/*     */   
/*  43 */   public static final boolean BITS64 = (POINTER_SIZE << 3 == 64);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   long address();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class Default
/*     */     implements Pointer
/*     */   {
/*     */     protected static final long ADDRESS;
/*     */ 
/*     */ 
/*     */     
/*     */     protected static final long BUFFER_CONTAINER;
/*     */ 
/*     */ 
/*     */     
/*     */     protected static final long BUFFER_MARK;
/*     */ 
/*     */     
/*  67 */     protected static final Unsafe UNSAFE = MemoryUtil.UNSAFE;
/*     */     static {
/*     */       try {
/*  70 */         ADDRESS = UNSAFE.objectFieldOffset(Default.class.getDeclaredField("address"));
/*     */         
/*  72 */         BUFFER_CONTAINER = UNSAFE.objectFieldOffset(CustomBuffer.class.getDeclaredField("container"));
/*     */         
/*  74 */         BUFFER_MARK = UNSAFE.objectFieldOffset(CustomBuffer.class.getDeclaredField("mark"));
/*  75 */         BUFFER_POSITION = UNSAFE.objectFieldOffset(CustomBuffer.class.getDeclaredField("position"));
/*  76 */         BUFFER_LIMIT = UNSAFE.objectFieldOffset(CustomBuffer.class.getDeclaredField("limit"));
/*  77 */         BUFFER_CAPACITY = UNSAFE.objectFieldOffset(CustomBuffer.class.getDeclaredField("capacity")); return;
/*  78 */       } catch (Throwable throwable) {
/*  79 */         throw new UnsupportedOperationException(throwable);
/*     */       } 
/*     */     }
/*     */     
/*     */     protected static final long BUFFER_POSITION;
/*     */     protected static final long BUFFER_LIMIT;
/*     */     
/*     */     protected Default(long param1Long) {
/*  87 */       if (Checks.CHECKS && param1Long == 0L) {
/*  88 */         throw new NullPointerException();
/*     */       }
/*  90 */       this.address = param1Long;
/*     */     }
/*     */     protected static final long BUFFER_CAPACITY; protected long address;
/*     */     
/*     */     public long address() {
/*  95 */       return this.address;
/*     */     }
/*     */     
/*     */     public boolean equals(Object param1Object) {
/*  99 */       if (this == param1Object) {
/* 100 */         return true;
/*     */       }
/* 102 */       if (!(param1Object instanceof Pointer)) {
/* 103 */         return false;
/*     */       }
/*     */       
/* 106 */       param1Object = param1Object;
/*     */       
/* 108 */       return (this.address == param1Object.address());
/*     */     }
/*     */     
/*     */     public int hashCode() {
/* 112 */       return (int)(this.address ^ this.address >>> 32L);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 117 */       return String.format("%s pointer [0x%X]", new Object[] { getClass().getSimpleName(), Long.valueOf(this.address) });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\Pointer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */