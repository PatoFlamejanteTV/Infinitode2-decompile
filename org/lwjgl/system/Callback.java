/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.jni.JNINativeInterface;
/*     */ import org.lwjgl.system.libffi.FFICIF;
/*     */ import org.lwjgl.system.libffi.FFIClosure;
/*     */ import org.lwjgl.system.libffi.LibFFI;
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
/*     */ public abstract class Callback
/*     */   implements NativeResource, Pointer
/*     */ {
/*  28 */   private static final boolean DEBUG_ALLOCATOR = ((Boolean)Configuration.DEBUG_MEMORY_ALLOCATOR.get(Boolean.FALSE)).booleanValue();
/*     */ 
/*     */   
/*     */   private static final ClosureRegistry CLOSURE_REGISTRY;
/*     */ 
/*     */   
/*     */   private static final long CALLBACK_HANDLER;
/*     */   
/*     */   private long address;
/*     */ 
/*     */   
/*     */   static {
/*  40 */     MemoryStack memoryStack = MemoryStack.stackPush(); Throwable throwable = null; 
/*  41 */     try { PointerBuffer pointerBuffer = memoryStack.mallocPointer(1);
/*     */       
/*     */       FFIClosure fFIClosure;
/*  44 */       if ((fFIClosure = LibFFI.ffi_closure_alloc(FFIClosure.SIZEOF, pointerBuffer)) == null) {
/*  45 */         throw new OutOfMemoryError();
/*     */       }
/*     */       
/*  48 */       if (pointerBuffer.get(0) == fFIClosure.address()) {
/*  49 */         APIUtil.apiLog("Closure Registry: simple");
/*     */ 
/*     */ 
/*     */         
/*  53 */         CLOSURE_REGISTRY = new ClosureRegistry()
/*     */           {
/*     */             public final void put(long param1Long, FFIClosure param1FFIClosure) {}
/*     */ 
/*     */ 
/*     */             
/*     */             public final FFIClosure get(long param1Long) {
/*  60 */               return FFIClosure.create(param1Long);
/*     */             }
/*     */             
/*     */             public final FFIClosure remove(long param1Long) {
/*  64 */               return get(param1Long);
/*     */             }
/*     */           };
/*     */       } else {
/*  68 */         APIUtil.apiLog("Closure Registry: ConcurrentHashMap");
/*     */         
/*  70 */         CLOSURE_REGISTRY = new ClosureRegistry() {
/*  71 */             private final ConcurrentHashMap<Long, FFIClosure> map = new ConcurrentHashMap<>();
/*     */ 
/*     */             
/*     */             public final void put(long param1Long, FFIClosure param1FFIClosure) {
/*  75 */               this.map.put(Long.valueOf(param1Long), param1FFIClosure);
/*     */             }
/*     */             
/*     */             public final FFIClosure get(long param1Long) {
/*  79 */               return this.map.get(Long.valueOf(param1Long));
/*     */             }
/*     */             
/*     */             public final FFIClosure remove(long param1Long) {
/*  83 */               return this.map.remove(Long.valueOf(param1Long));
/*     */             }
/*     */           };
/*     */       } 
/*  87 */       LibFFI.ffi_closure_free(fFIClosure); } catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/*  88 */     finally { if (memoryStack != null) if (throwable != null) { try { memoryStack.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }
/*     */       
/*     */        }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  97 */       CALLBACK_HANDLER = getCallbackHandler(CallbackI.class.getDeclaredMethod("callback", new Class[] { long.class, long.class }));
/*  98 */     } catch (Exception exception) {
/*  99 */       throw new IllegalStateException("Failed to initialize the native callback handler.", exception);
/*     */     } 
/*     */     
/* 102 */     MemoryUtil.getAllocator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Callback(FFICIF paramFFICIF) {
/* 113 */     this.address = create(paramFFICIF, this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Callback(long paramLong) {
/* 122 */     if (Checks.CHECKS) {
/* 123 */       Checks.check(paramLong);
/*     */     }
/* 125 */     this.address = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public long address() {
/* 130 */     return this.address;
/*     */   }
/*     */ 
/*     */   
/*     */   public void free() {
/* 135 */     free(address());
/*     */   }
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
/*     */   static long create(FFICIF paramFFICIF, Object paramObject) {
/*     */     FFIClosure fFIClosure;
/*     */     long l1;
/* 154 */     try (MemoryStack null = MemoryStack.stackPush()) {
/* 155 */       PointerBuffer pointerBuffer = memoryStack.mallocPointer(1);
/*     */ 
/*     */       
/* 158 */       if ((fFIClosure = LibFFI.ffi_closure_alloc(FFIClosure.SIZEOF, pointerBuffer)) == null) {
/* 159 */         throw new OutOfMemoryError();
/*     */       }
/* 161 */       l1 = pointerBuffer.get(0);
/* 162 */       if (DEBUG_ALLOCATOR) {
/* 163 */         MemoryManage.DebugAllocator.track(l1, FFIClosure.SIZEOF);
/*     */       }
/*     */     } 
/*     */     
/* 167 */     long l2 = JNINativeInterface.NewGlobalRef(throwable);
/*     */     
/*     */     int i;
/* 170 */     if ((i = LibFFI.ffi_prep_closure_loc(fFIClosure, paramFFICIF, CALLBACK_HANDLER, l2, l1)) != 0) {
/* 171 */       JNINativeInterface.DeleteGlobalRef(l2);
/* 172 */       LibFFI.ffi_closure_free(fFIClosure);
/* 173 */       throw new RuntimeException("Failed to prepare the libffi closure");
/*     */     } 
/*     */     
/* 176 */     CLOSURE_REGISTRY.put(l1, fFIClosure);
/*     */     
/* 178 */     return l1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends CallbackI> T get(long paramLong) {
/* 190 */     return (T)MemoryUtil.<CallbackI>memGlobalRefToObject(CLOSURE_REGISTRY.get(paramLong).user_data());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends CallbackI> T getSafe(long paramLong) {
/* 196 */     return (paramLong == 0L) ? null : get(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void free(long paramLong) {
/* 205 */     if (DEBUG_ALLOCATOR) {
/* 206 */       MemoryManage.DebugAllocator.untrack(paramLong);
/*     */     }
/*     */     
/*     */     FFIClosure fFIClosure;
/*     */     
/* 211 */     JNINativeInterface.DeleteGlobalRef((fFIClosure = CLOSURE_REGISTRY.get(paramLong)).user_data());
/* 212 */     LibFFI.ffi_closure_free(fFIClosure);
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 216 */     if (this == paramObject) {
/* 217 */       return true;
/*     */     }
/* 219 */     if (!(paramObject instanceof Callback)) {
/* 220 */       return false;
/*     */     }
/*     */     
/* 223 */     paramObject = paramObject;
/*     */     
/* 225 */     return (this.address == paramObject.address());
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 229 */     return (int)(this.address ^ this.address >>> 32L);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 234 */     return String.format("%s pointer [0x%X]", new Object[] { getClass().getSimpleName(), Long.valueOf(this.address) });
/*     */   }
/*     */   
/*     */   private static native long getCallbackHandler(Method paramMethod);
/*     */   
/*     */   private static interface ClosureRegistry {
/*     */     void put(long param1Long, FFIClosure param1FFIClosure);
/*     */     
/*     */     FFIClosure get(long param1Long);
/*     */     
/*     */     FFIClosure remove(long param1Long);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\Callback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */