/*     */ package net.bytebuddy;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.lang.ref.Reference;
/*     */ import java.lang.ref.ReferenceQueue;
/*     */ import java.lang.ref.SoftReference;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import net.bytebuddy.build.CachedReturnPlugin.Enhance;
/*     */ import net.bytebuddy.utility.CompoundList;
/*     */ import net.bytebuddy.utility.nullability.AlwaysNull;
/*     */ import net.bytebuddy.utility.nullability.MaybeNull;
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
/*     */ public class TypeCache<T>
/*     */   extends ReferenceQueue<ClassLoader>
/*     */ {
/*     */   @AlwaysNull
/*  63 */   private static final Class<?> NOT_FOUND = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final Sort sort;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final ConcurrentMap<StorageKey, ConcurrentMap<T, Object>> cache;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeCache() {
/*  79 */     this(Sort.STRONG);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeCache(Sort paramSort) {
/*  88 */     this.sort = paramSort;
/*  89 */     this.cache = new ConcurrentHashMap<StorageKey, ConcurrentMap<T, Object>>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @MaybeNull
/*     */   @SuppressFBWarnings(value = {"GC_UNRELATED_TYPES"}, justification = "Cross-comparison is intended.")
/*     */   public Class<?> find(@MaybeNull ClassLoader paramClassLoader, T paramT) {
/*     */     ConcurrentMap concurrentMap;
/* 103 */     if ((concurrentMap = this.cache.get(new LookupKey(paramClassLoader))) == null) {
/* 104 */       return NOT_FOUND;
/*     */     }
/*     */     
/* 107 */     if ((concurrentMap = (ConcurrentMap)concurrentMap.get(paramT)) == null)
/* 108 */       return NOT_FOUND; 
/* 109 */     if (concurrentMap instanceof Reference) {
/* 110 */       return ((Reference<Class<?>>)concurrentMap).get();
/*     */     }
/* 112 */     return (Class)concurrentMap;
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
/*     */   @SuppressFBWarnings(value = {"GC_UNRELATED_TYPES"}, justification = "Cross-comparison is intended.")
/*     */   public Class<?> insert(@MaybeNull ClassLoader paramClassLoader, T paramT, Class<?> paramClass) {
/* 129 */     ConcurrentMap<Object, Object> concurrentMap2 = new ConcurrentHashMap<Object, Object>();
/*     */     ConcurrentMap<Object, Object> concurrentMap1;
/* 131 */     if ((concurrentMap2 = (ConcurrentMap)this.cache.get(new LookupKey(paramClassLoader))) == null && (concurrentMap1 = (ConcurrentMap)this.cache.putIfAbsent(new StorageKey(paramClassLoader, this), concurrentMap2)) != null) {
/* 132 */       concurrentMap2 = concurrentMap1;
/*     */     }
/*     */     
/* 135 */     Object object1 = this.sort.wrap(paramClass), object2 = concurrentMap2.putIfAbsent(paramT, object1);
/* 136 */     while (object2 != null) {
/*     */       Class<?> clazz;
/*     */ 
/*     */       
/* 140 */       if ((clazz = (object2 instanceof Reference) ? ((Reference<Class<?>>)object2).get() : (Class)object2) != null)
/* 141 */         return clazz; 
/* 142 */       if (concurrentMap2.remove(paramT, object2)) {
/* 143 */         object2 = concurrentMap2.putIfAbsent(paramT, object1);
/*     */         continue;
/*     */       } 
/* 146 */       if ((object2 = concurrentMap2.get(paramT)) == null) {
/* 147 */         object2 = concurrentMap2.putIfAbsent(paramT, object1);
/*     */       }
/*     */     } 
/*     */     
/* 151 */     return paramClass;
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
/*     */   public Class<?> findOrInsert(ClassLoader paramClassLoader, T paramT, Callable<Class<?>> paramCallable) {
/*     */     Class<?> clazz;
/* 164 */     if ((clazz = find(paramClassLoader, paramT)) != null) {
/* 165 */       return clazz;
/*     */     }
/*     */     try {
/* 168 */       return insert(paramClassLoader, paramT, paramCallable.call());
/* 169 */     } catch (Throwable throwable) {
/* 170 */       throw new IllegalArgumentException("Could not create type", throwable);
/*     */     } 
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
/*     */   public Class<?> findOrInsert(@MaybeNull ClassLoader paramClassLoader, T paramT, Callable<Class<?>> paramCallable, Object paramObject) {
/*     */     Class<?> clazz;
/* 186 */     if ((clazz = find(paramClassLoader, paramT)) != null) {
/* 187 */       return clazz;
/*     */     }
/* 189 */     synchronized (paramObject) {
/* 190 */       return findOrInsert(paramClassLoader, paramT, paramCallable);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void expungeStaleEntries() {
/*     */     Reference<? extends ClassLoader> reference;
/* 200 */     while ((reference = poll()) != null) {
/* 201 */       this.cache.remove(reference);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 209 */     this.cache.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Sort
/*     */   {
/* 220 */     WEAK
/*     */     {
/*     */       protected final Reference<Class<?>> wrap(Class<?> param2Class) {
/* 223 */         return new WeakReference<Class<?>>(param2Class);
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 230 */     SOFT
/*     */     {
/*     */       protected final Reference<Class<?>> wrap(Class<?> param2Class) {
/* 233 */         return new SoftReference<Class<?>>(param2Class);
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 240 */     STRONG
/*     */     {
/*     */       protected final Class<?> wrap(Class<?> param2Class) {
/* 243 */         return param2Class;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract Object wrap(Class<?> param1Class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class LookupKey
/*     */   {
/*     */     @MaybeNull
/*     */     private final ClassLoader classLoader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int hashCode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected LookupKey(@MaybeNull ClassLoader param1ClassLoader) {
/* 278 */       this.classLoader = param1ClassLoader;
/* 279 */       this.hashCode = System.identityHashCode(param1ClassLoader);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 284 */       return this.hashCode;
/*     */     }
/*     */ 
/*     */     
/*     */     @SuppressFBWarnings(value = {"EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS"}, justification = "Cross-comparison is intended.")
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/* 290 */       if (this == param1Object)
/* 291 */         return true; 
/* 292 */       if (param1Object instanceof LookupKey)
/* 293 */         return (this.classLoader == ((LookupKey)param1Object).classLoader); 
/* 294 */       if (param1Object instanceof TypeCache.StorageKey) {
/* 295 */         param1Object = param1Object;
/* 296 */         return (this.hashCode == TypeCache.StorageKey.a((TypeCache.StorageKey)param1Object) && this.classLoader == param1Object.get());
/*     */       } 
/* 298 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class StorageKey
/*     */     extends WeakReference<ClassLoader>
/*     */   {
/*     */     private final int hashCode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected StorageKey(@MaybeNull ClassLoader param1ClassLoader, ReferenceQueue<? super ClassLoader> param1ReferenceQueue) {
/* 320 */       super(param1ClassLoader, param1ReferenceQueue);
/* 321 */       this.hashCode = System.identityHashCode(param1ClassLoader);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 326 */       return this.hashCode;
/*     */     }
/*     */ 
/*     */     
/*     */     @SuppressFBWarnings(value = {"EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS"}, justification = "Cross-comparison is intended.")
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/* 332 */       if (this == param1Object)
/* 333 */         return true; 
/* 334 */       if (param1Object instanceof TypeCache.LookupKey) {
/* 335 */         param1Object = param1Object;
/* 336 */         return (this.hashCode == TypeCache.LookupKey.a((TypeCache.LookupKey)param1Object) && get() == TypeCache.LookupKey.b((TypeCache.LookupKey)param1Object));
/* 337 */       }  if (param1Object instanceof StorageKey) {
/* 338 */         param1Object = param1Object;
/* 339 */         return (this.hashCode == ((StorageKey)param1Object).hashCode && get() == param1Object.get());
/*     */       } 
/* 341 */       return false;
/*     */     }
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
/*     */   public static class WithInlineExpunction<S>
/*     */     extends TypeCache<S>
/*     */   {
/*     */     public WithInlineExpunction() {
/* 360 */       this(TypeCache.Sort.STRONG);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public WithInlineExpunction(TypeCache.Sort param1Sort) {
/* 369 */       super(param1Sort);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Class<?> find(@MaybeNull ClassLoader param1ClassLoader, S param1S) {
/*     */       try {
/* 377 */         return super.find(param1ClassLoader, param1S);
/*     */       } finally {
/* 379 */         expungeStaleEntries();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Class<?> insert(@MaybeNull ClassLoader param1ClassLoader, S param1S, Class<?> param1Class) {
/*     */       try {
/* 388 */         return super.insert(param1ClassLoader, param1S, param1Class);
/*     */       } finally {
/* 390 */         expungeStaleEntries();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Class<?> findOrInsert(ClassLoader param1ClassLoader, S param1S, Callable<Class<?>> param1Callable) {
/*     */       try {
/* 399 */         return super.findOrInsert(param1ClassLoader, param1S, param1Callable);
/*     */       } finally {
/* 401 */         expungeStaleEntries();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Class<?> findOrInsert(@MaybeNull ClassLoader param1ClassLoader, S param1S, Callable<Class<?>> param1Callable, Object param1Object) {
/*     */       try {
/* 410 */         return super.findOrInsert(param1ClassLoader, param1S, param1Callable, param1Object);
/*     */       } finally {
/* 412 */         expungeStaleEntries();
/*     */       } 
/*     */     }
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
/*     */   
/*     */   public static class SimpleKey
/*     */   {
/*     */     public SimpleKey(Class<?> param1Class, Class<?>... param1VarArgs) {
/* 434 */       this(param1Class, Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SimpleKey(Class<?> param1Class, Collection<? extends Class<?>> param1Collection) {
/* 444 */       this(CompoundList.of(param1Class, new ArrayList<Class<?>>(param1Collection)));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 453 */     private final Set<String> types = new HashSet<String>(); public SimpleKey(Collection<? extends Class<?>> param1Collection) {
/* 454 */       for (Class<?> clazz : param1Collection)
/* 455 */         this.types.add(clazz.getName()); 
/*     */     }
/*     */     @Enhance("hashCode")
/*     */     public int hashCode() {
/*     */       int j;
/*     */       int i;
/*     */       SimpleKey simpleKey;
/* 462 */       if (!(i = ((j = this.hashCode) != 0) ? 0 : (simpleKey = this).types.hashCode())) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/* 467 */       if (this == param1Object)
/* 468 */         return true; 
/* 469 */       if (param1Object == null || getClass() != param1Object.getClass()) {
/* 470 */         return false;
/*     */       }
/* 472 */       param1Object = param1Object;
/* 473 */       return this.types.equals(((SimpleKey)param1Object).types);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\TypeCache.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */