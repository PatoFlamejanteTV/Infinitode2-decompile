/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import java.util.concurrent.atomic.AtomicLong;
/*     */ import org.lwjgl.system.libc.LibCStdlib;
/*     */ import org.lwjgl.system.libffi.FFICIF;
/*     */ import org.lwjgl.system.libffi.FFIType;
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
/*     */ final class MemoryManage
/*     */ {
/*     */   static MemoryUtil.MemoryAllocator getInstance() {
/*     */     Object object;
/*  29 */     if (object = Configuration.MEMORY_ALLOCATOR.get() instanceof MemoryUtil.MemoryAllocator) {
/*  30 */       return (MemoryUtil.MemoryAllocator)object;
/*     */     }
/*     */     
/*  33 */     if (!"system".equals(object)) {
/*     */       String str;
/*  35 */       if (object == null || "jemalloc".equals(object)) {
/*  36 */         str = "org.lwjgl.system.jemalloc.JEmallocAllocator";
/*  37 */       } else if ("rpmalloc".equals(object)) {
/*  38 */         str = "org.lwjgl.system.rpmalloc.RPmallocAllocator";
/*     */       } else {
/*  40 */         str = object.toString();
/*     */       } 
/*     */       
/*     */       try {
/*     */         Class<?> clazz;
/*  45 */         return (clazz = Class.forName(str)).getConstructor(new Class[0]).newInstance(new Object[0]);
/*  46 */       } catch (Throwable throwable) {
/*  47 */         if (Checks.DEBUG && object != null) {
/*  48 */           throwable.printStackTrace(APIUtil.DEBUG_STREAM);
/*     */         }
/*  50 */         APIUtil.apiLog(String.format("Warning: Failed to instantiate memory allocator: %s. Using the system default.", new Object[] { str }));
/*     */       } 
/*     */     } 
/*     */     
/*  54 */     return new StdlibAllocator();
/*     */   }
/*     */   
/*     */   private static class StdlibAllocator implements MemoryUtil.MemoryAllocator {
/*     */     private StdlibAllocator() {}
/*     */     
/*  60 */     public long getMalloc() { return MemoryAccessJNI.malloc; }
/*  61 */     public long getCalloc() { return MemoryAccessJNI.calloc; }
/*  62 */     public long getRealloc() { return MemoryAccessJNI.realloc; }
/*  63 */     public long getFree() { return MemoryAccessJNI.free; }
/*  64 */     public long getAlignedAlloc() { return MemoryAccessJNI.aligned_alloc; } public long getAlignedFree() {
/*  65 */       return MemoryAccessJNI.aligned_free;
/*     */     }
/*  67 */     public long malloc(long param1Long) { return LibCStdlib.nmalloc(param1Long); }
/*  68 */     public long calloc(long param1Long1, long param1Long2) { return LibCStdlib.ncalloc(param1Long1, param1Long2); }
/*  69 */     public long realloc(long param1Long1, long param1Long2) { return LibCStdlib.nrealloc(param1Long1, param1Long2); }
/*  70 */     public void free(long param1Long) { LibCStdlib.nfree(param1Long); }
/*  71 */     public long aligned_alloc(long param1Long1, long param1Long2) { return LibCStdlib.naligned_alloc(param1Long1, param1Long2); } public void aligned_free(long param1Long) {
/*  72 */       LibCStdlib.naligned_free(param1Long);
/*     */     }
/*     */   }
/*     */   
/*     */   static class DebugAllocator
/*     */     implements MemoryUtil.MemoryAllocator
/*     */   {
/*  79 */     private static final ConcurrentMap<Allocation, Allocation> ALLOCATIONS = new ConcurrentHashMap<>();
/*  80 */     private static final ConcurrentMap<Long, String> THREADS = new ConcurrentHashMap<>();
/*     */     
/*     */     private final MemoryUtil.MemoryAllocator allocator;
/*     */     
/*     */     private final long[] callbacks;
/*     */     
/*     */     DebugAllocator(MemoryUtil.MemoryAllocator param1MemoryAllocator) {
/*  87 */       this.allocator = param1MemoryAllocator;
/*     */       
/*  89 */       this
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 146 */         .callbacks = new long[] { (new CallbackI() { public FFICIF getCallInterface() { return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_pointer, new FFIType[] { LibFFI.ffi_type_pointer }); } public void callback(long param2Long1, long param2Long2) { long l = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(param2Long2)); MemoryUtil.memPutAddress(param2Long1, MemoryManage.DebugAllocator.this.malloc(l)); } }).address(), (new CallbackI() { public FFICIF getCallInterface() { return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_pointer, new FFIType[] { LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer }); } public void callback(long param2Long1, long param2Long2) { long l1 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(param2Long2)); long l2 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(param2Long2 + POINTER_SIZE)); MemoryUtil.memPutAddress(param2Long1, MemoryManage.DebugAllocator.this.calloc(l1, l2)); } }).address(), (new CallbackI() { public FFICIF getCallInterface() { return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_pointer, new FFIType[] { LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer }); } public void callback(long param2Long1, long param2Long2) { long l1 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(param2Long2)); long l2 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(param2Long2 + POINTER_SIZE)); MemoryUtil.memPutAddress(param2Long1, MemoryManage.DebugAllocator.this.realloc(l1, l2)); } }).address(), (new CallbackI() { public FFICIF getCallInterface() { return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_void, new FFIType[] { LibFFI.ffi_type_pointer }); } public void callback(long param2Long1, long param2Long2) { long l = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(param2Long2)); MemoryManage.DebugAllocator.this.free(l); } }).address(), (new CallbackI() { public FFICIF getCallInterface() { return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_pointer, new FFIType[] { LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer }); } public void callback(long param2Long1, long param2Long2) { long l1 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(param2Long2)); long l2 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(param2Long2 + POINTER_SIZE)); MemoryUtil.memPutAddress(param2Long1, MemoryManage.DebugAllocator.this.aligned_alloc(l1, l2)); } }).address(), (new CallbackI() { public FFICIF getCallInterface() { return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_void, new FFIType[] { LibFFI.ffi_type_pointer }); } public void callback(long param2Long1, long param2Long2) { long l = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(param2Long2)); MemoryManage.DebugAllocator.this.aligned_free(l); } }).address() };
/*     */ 
/*     */       
/* 149 */       Runtime.getRuntime().addShutdownHook(new Thread(() -> {
/*     */               long[] arrayOfLong;
/*     */               int i = (arrayOfLong = this.callbacks).length;
/*     */               for (byte b = 0; b < i; b++) {
/*     */                 long l;
/*     */                 Callback.free(l = arrayOfLong[b]);
/*     */               } 
/*     */               if (ALLOCATIONS.isEmpty()) {
/*     */                 return;
/*     */               }
/*     */               boolean bool = false;
/*     */               for (Allocation allocation : ALLOCATIONS.keySet()) {
/*     */                 StringBuilder stringBuilder;
/*     */                 (stringBuilder = new StringBuilder(512)).append("[LWJGL] ").append(allocation.size).append(" bytes leaked, thread ").append(allocation.threadId).append(" (").append(THREADS.get(Long.valueOf(allocation.threadId))).append("), address: 0x").append(Long.toHexString(allocation.address).toUpperCase()).append("\n");
/*     */                 StackTraceElement[] arrayOfStackTraceElement;
/*     */                 if ((arrayOfStackTraceElement = allocation.getElements()) != null) {
/*     */                   StackTraceElement[] arrayOfStackTraceElement1;
/*     */                   int j = (arrayOfStackTraceElement1 = arrayOfStackTraceElement).length;
/*     */                   for (byte b1 = 0; b1 < j; b1++) {
/*     */                     StackTraceElement stackTraceElement = arrayOfStackTraceElement1[b1];
/*     */                     stringBuilder.append("\tat ").append(stackTraceElement.toString()).append("\n");
/*     */                   } 
/*     */                 } else {
/*     */                   bool = true;
/*     */                 } 
/*     */                 APIUtil.DEBUG_STREAM.print(stringBuilder);
/*     */               } 
/*     */               if (bool) {
/*     */                 APIUtil.DEBUG_STREAM.print("[LWJGL] Reminder: disable Configuration.DEBUG_MEMORY_ALLOCATOR_FAST to get stacktraces of leaking allocations.\n");
/*     */               }
/*     */             }));
/*     */     }
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
/*     */     public long getMalloc() {
/* 194 */       return this.callbacks[0];
/* 195 */     } public long getCalloc() { return this.callbacks[1]; }
/* 196 */     public long getRealloc() { return this.callbacks[2]; }
/* 197 */     public long getFree() { return this.callbacks[3]; }
/* 198 */     public long getAlignedAlloc() { return this.callbacks[4]; } public long getAlignedFree() {
/* 199 */       return this.callbacks[5];
/*     */     }
/*     */     public long malloc(long param1Long) {
/* 202 */       return track(this.allocator.malloc(param1Long), param1Long);
/*     */     }
/*     */ 
/*     */     
/*     */     public long calloc(long param1Long1, long param1Long2) {
/* 207 */       return track(this.allocator.calloc(param1Long1, param1Long2), param1Long1 * param1Long2);
/*     */     }
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
/*     */     public long realloc(long param1Long1, long param1Long2) {
/* 225 */       long l1 = untrack(param1Long1);
/*     */       
/*     */       long l2;
/*     */       
/* 229 */       if ((l2 = this.allocator.realloc(param1Long1, param1Long2)) != 0L) {
/* 230 */         track(l2, param1Long2);
/* 231 */       } else if (param1Long2 != 0L) {
/* 232 */         track(param1Long1, l1);
/*     */       } 
/*     */       
/* 235 */       return l2;
/*     */     }
/*     */ 
/*     */     
/*     */     public void free(long param1Long) {
/* 240 */       untrack(param1Long);
/* 241 */       this.allocator.free(param1Long);
/*     */     }
/*     */ 
/*     */     
/*     */     public long aligned_alloc(long param1Long1, long param1Long2) {
/* 246 */       return track(this.allocator.aligned_alloc(param1Long1, param1Long2), param1Long2);
/*     */     }
/*     */ 
/*     */     
/*     */     public void aligned_free(long param1Long) {
/* 251 */       untrack(param1Long);
/* 252 */       this.allocator.aligned_free(param1Long);
/*     */     }
/*     */     
/*     */     static long track(long param1Long1, long param1Long2) {
/* 256 */       if (param1Long1 != 0L) {
/* 257 */         Thread thread = Thread.currentThread();
/* 258 */         THREADS.putIfAbsent(Long.valueOf(thread.getId()), thread.getName());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 264 */         Allocation allocation1 = new Allocation(param1Long1, param1Long2, thread.getId(), ((Boolean)Configuration.DEBUG_MEMORY_ALLOCATOR_FAST.get(Boolean.FALSE)).booleanValue() ? null : StackWalkUtil.stackWalkGetTrace());
/*     */         
/*     */         Allocation allocation2;
/*     */         
/* 268 */         if ((allocation2 = ALLOCATIONS.put(allocation1, allocation1)) != null) {
/* 269 */           trackAbort(param1Long1, allocation2, allocation1);
/*     */         }
/*     */       } 
/*     */       
/* 273 */       return param1Long1;
/*     */     }
/*     */     private static void trackAbort(long param1Long, Allocation param1Allocation1, Allocation param1Allocation2) {
/* 276 */       String str = Long.toHexString(param1Long).toUpperCase();
/*     */       
/* 278 */       trackAbortPrint(param1Allocation1, "Old", str);
/* 279 */       trackAbortPrint(param1Allocation2, "New", str);
/*     */       
/* 281 */       throw new IllegalStateException("The memory address specified is already being tracked: 0x" + str);
/*     */     }
/*     */     
/*     */     private static void trackAbortPrint(Allocation param1Allocation, String param1String1, String param1String2) {
/*     */       StringBuilder stringBuilder;
/* 286 */       (stringBuilder = new StringBuilder(512))
/* 287 */         .append("[LWJGL] ")
/* 288 */         .append(param1String1)
/* 289 */         .append(" allocation with size ")
/* 290 */         .append(param1Allocation.size)
/* 291 */         .append(", thread ")
/* 292 */         .append(param1Allocation.threadId)
/* 293 */         .append(" (")
/* 294 */         .append(THREADS.get(Long.valueOf(param1Allocation.threadId)))
/* 295 */         .append("), address: 0x")
/* 296 */         .append(param1String2)
/* 297 */         .append("\n");
/*     */       
/*     */       StackTraceElement[] arrayOfStackTraceElement;
/* 300 */       if ((arrayOfStackTraceElement = param1Allocation.getElements()) != null) {
/* 301 */         int i; byte b; for (i = (arrayOfStackTraceElement = arrayOfStackTraceElement).length, b = 0; b < i; ) { StackTraceElement stackTraceElement = arrayOfStackTraceElement[b];
/* 302 */           stringBuilder
/* 303 */             .append("\tat ")
/* 304 */             .append(stackTraceElement.toString())
/* 305 */             .append("\n");
/*     */           b++; }
/*     */       
/*     */       } 
/* 309 */       APIUtil.DEBUG_STREAM.print(stringBuilder);
/*     */     }
/*     */     
/*     */     static long untrack(long param1Long) {
/* 313 */       if (param1Long == 0L) {
/* 314 */         return 0L;
/*     */       }
/*     */       
/*     */       Allocation allocation;
/* 318 */       if ((allocation = ALLOCATIONS.remove(new Allocation(param1Long, 0L, 0L, null))) == null) {
/* 319 */         untrackAbort(param1Long);
/*     */       }
/*     */       
/* 322 */       return allocation.size;
/*     */     }
/*     */     private static void untrackAbort(long param1Long) {
/* 325 */       String str = Long.toHexString(param1Long).toUpperCase();
/*     */       
/* 327 */       throw new IllegalStateException("The memory address specified is not being tracked: 0x" + str);
/*     */     }
/*     */ 
/*     */     
/*     */     private static class Allocation
/*     */     {
/*     */       final long address;
/*     */       
/*     */       final long size;
/*     */       final long threadId;
/*     */       private final Object[] stacktrace;
/*     */       
/*     */       Allocation(long param2Long1, long param2Long2, long param2Long3, Object[] param2ArrayOfObject) {
/* 340 */         this.address = param2Long1;
/* 341 */         this.size = param2Long2;
/* 342 */         this.threadId = param2Long3;
/* 343 */         this.stacktrace = param2ArrayOfObject;
/*     */       }
/*     */ 
/*     */       
/*     */       private StackTraceElement[] getElements() {
/* 348 */         return (this.stacktrace == null) ? null : StackWalkUtil.stackWalkArray(this.stacktrace);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean equals(Object param2Object) {
/* 354 */         return (this.address == ((Allocation)param2Object).address);
/*     */       }
/*     */ 
/*     */       
/*     */       public int hashCode() {
/* 359 */         return Long.hashCode(this.address);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     static void report(MemoryUtil.MemoryAllocationReport param1MemoryAllocationReport) {
/* 365 */       for (Allocation allocation : ALLOCATIONS.keySet()) {
/* 366 */         param1MemoryAllocationReport.invoke(allocation.address, allocation.size, allocation.threadId, THREADS.get(Long.valueOf(allocation.threadId)), allocation.getElements());
/*     */       }
/*     */     }
/*     */     
/*     */     private static <T> void aggregate(T param1T, long param1Long, Map<T, AtomicLong> param1Map) {
/*     */       AtomicLong atomicLong;
/* 372 */       (atomicLong = param1Map.computeIfAbsent(param1T, param1Object -> new AtomicLong())).set(atomicLong.get() + param1Long);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static void report(MemoryUtil.MemoryAllocationReport param1MemoryAllocationReport, MemoryUtil.MemoryAllocationReport.Aggregate param1Aggregate, boolean param1Boolean) {
/* 380 */       switch (param1Aggregate) {
/*     */         case ALL:
/* 382 */           reportAll(param1MemoryAllocationReport, param1Boolean);
/*     */           return;
/*     */         case GROUP_BY_METHOD:
/* 385 */           reportByMethod(param1MemoryAllocationReport, param1Boolean);
/*     */           return;
/*     */         case GROUP_BY_STACKTRACE:
/* 388 */           reportByStacktrace(param1MemoryAllocationReport, param1Boolean);
/*     */           break;
/*     */       } 
/*     */     }
/*     */     private static void reportAll(MemoryUtil.MemoryAllocationReport param1MemoryAllocationReport, boolean param1Boolean) {
/* 393 */       if (param1Boolean) {
/* 394 */         HashMap<Object, Object> hashMap = new HashMap<>();
/* 395 */         for (null = ALLOCATIONS.values().iterator(); null.hasNext();) {
/* 396 */           aggregate(Long.valueOf((allocation = null.next()).threadId), allocation.size, (Map)hashMap);
/*     */         }
/* 398 */         for (Map.Entry<Object, Object> entry : hashMap.entrySet())
/* 399 */           param1MemoryAllocationReport.invoke(0L, ((AtomicLong)entry.getValue()).get(), ((Long)entry.getKey()).longValue(), THREADS.get(entry.getKey()), (StackTraceElement[])null); 
/*     */         return;
/*     */       } 
/* 402 */       long l = 0L;
/* 403 */       for (Allocation allocation : ALLOCATIONS.values()) {
/* 404 */         l += allocation.size;
/*     */       }
/* 406 */       param1MemoryAllocationReport.invoke(0L, l, 0L, null, (StackTraceElement[])null);
/*     */     }
/*     */ 
/*     */     
/*     */     private static void reportByMethod(MemoryUtil.MemoryAllocationReport param1MemoryAllocationReport, boolean param1Boolean) {
/* 411 */       if (param1Boolean) {
/* 412 */         HashMap<Object, Object> hashMap1 = new HashMap<>(); Iterator<Allocation> iterator;
/* 413 */         for (iterator = ALLOCATIONS.keySet().iterator(); iterator.hasNext();) {
/*     */           
/* 415 */           if ((arrayOfStackTraceElement = (allocation = iterator.next()).getElements()) != null) {
/* 416 */             Map<StackTraceElement, AtomicLong> map = (Map)hashMap1.computeIfAbsent(Long.valueOf(allocation.threadId), param1Long -> new HashMap<>());
/* 417 */             aggregate(arrayOfStackTraceElement[0], allocation.size, map);
/*     */           } 
/*     */         } 
/*     */         
/* 421 */         for (iterator = hashMap1.entrySet().iterator(); iterator.hasNext(); ) {
/* 422 */           Map.Entry<Long, ?> entry; long l = ((Long)(entry = (Map.Entry<Long, ?>)iterator.next()).getKey()).longValue();
/* 423 */           String str = THREADS.get(Long.valueOf(l));
/* 424 */           for (Map.Entry entry1 : ((Map)entry.getValue()).entrySet()) {
/* 425 */             param1MemoryAllocationReport.invoke(0L, ((AtomicLong)entry1.getValue()).get(), l, str, new StackTraceElement[] { (StackTraceElement)entry1.getKey() });
/*     */           } 
/*     */         }  return;
/*     */       } 
/* 429 */       HashMap<Object, Object> hashMap = new HashMap<>();
/* 430 */       for (null = ALLOCATIONS.keySet().iterator(); null.hasNext();) {
/*     */         
/* 432 */         if ((arrayOfStackTraceElement = (allocation = null.next()).getElements()) != null) {
/* 433 */           aggregate(arrayOfStackTraceElement[0], allocation.size, (Map)hashMap);
/*     */         }
/*     */       } 
/* 436 */       for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
/* 437 */         param1MemoryAllocationReport.invoke(0L, ((AtomicLong)entry.getValue()).get(), 0L, null, new StackTraceElement[] { (StackTraceElement)entry.getKey() });
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private static void reportByStacktrace(MemoryUtil.MemoryAllocationReport param1MemoryAllocationReport, boolean param1Boolean) {
/* 443 */       if (param1Boolean) {
/* 444 */         HashMap<Object, Object> hashMap1 = new HashMap<>(); Iterator<Allocation> iterator;
/* 445 */         for (iterator = ALLOCATIONS.keySet().iterator(); iterator.hasNext();) {
/*     */           
/* 447 */           if ((arrayOfStackTraceElement = (allocation = iterator.next()).getElements()) != null) {
/* 448 */             Map<AllocationKey, AtomicLong> map = (Map)hashMap1.computeIfAbsent(Long.valueOf(allocation.threadId), param1Long -> new HashMap<>());
/* 449 */             aggregate(new AllocationKey(arrayOfStackTraceElement), allocation.size, map);
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 454 */         for (iterator = hashMap1.entrySet().iterator(); iterator.hasNext(); ) {
/* 455 */           long l = ((Long)(entry = (Map.Entry<Long, ?>)iterator.next()).getKey()).longValue();
/* 456 */           for (Map.Entry<Long, ?> entry : (Iterable<Map.Entry<Long, ?>>)((Map)entry.getValue()).entrySet())
/* 457 */             param1MemoryAllocationReport.invoke(0L, ((AtomicLong)entry.getValue()).get(), l, THREADS.get(Long.valueOf(l)), ((AllocationKey)entry.getKey()).elements); 
/*     */         } 
/*     */         return;
/*     */       } 
/* 461 */       HashMap<Object, Object> hashMap = new HashMap<>();
/* 462 */       for (null = ALLOCATIONS.keySet().iterator(); null.hasNext();) {
/*     */         
/* 464 */         if ((arrayOfStackTraceElement = (allocation = null.next()).getElements()) != null) {
/* 465 */           aggregate(new AllocationKey(arrayOfStackTraceElement), allocation.size, (Map)hashMap);
/*     */         }
/*     */       } 
/* 468 */       for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
/* 469 */         param1MemoryAllocationReport.invoke(0L, ((AtomicLong)entry.getValue()).get(), 0L, null, ((AllocationKey)entry.getKey()).elements);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     private static class AllocationKey
/*     */     {
/*     */       final StackTraceElement[] elements;
/*     */       
/*     */       AllocationKey(StackTraceElement[] param2ArrayOfStackTraceElement) {
/* 479 */         this.elements = param2ArrayOfStackTraceElement;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean equals(Object param2Object) {
/* 484 */         return (this == param2Object || Arrays.equals((Object[])this.elements, (Object[])((AllocationKey)param2Object).elements));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/* 488 */         return Arrays.hashCode((Object[])this.elements);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\MemoryManage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */