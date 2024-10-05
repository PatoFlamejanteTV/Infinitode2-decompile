/*     */ package nonapi.io.github.classgraph.json;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.util.AbstractList;
/*     */ import java.util.AbstractMap;
/*     */ import java.util.AbstractQueue;
/*     */ import java.util.AbstractSequentialList;
/*     */ import java.util.AbstractSet;
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Deque;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.Queue;
/*     */ import java.util.Set;
/*     */ import java.util.SortedMap;
/*     */ import java.util.SortedSet;
/*     */ import java.util.TreeMap;
/*     */ import java.util.TreeSet;
/*     */ import java.util.concurrent.BlockingDeque;
/*     */ import java.util.concurrent.BlockingQueue;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import java.util.concurrent.ConcurrentNavigableMap;
/*     */ import java.util.concurrent.ConcurrentSkipListMap;
/*     */ import java.util.concurrent.LinkedBlockingDeque;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import java.util.concurrent.LinkedTransferQueue;
/*     */ import java.util.concurrent.TransferQueue;
/*     */ import nonapi.io.github.classgraph.reflection.ReflectionUtils;
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
/*     */ class ClassFieldCache
/*     */ {
/*  73 */   private final Map<Class<?>, ClassFields> classToClassFields = new HashMap<>();
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean resolveTypes;
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean onlySerializePublicFields;
/*     */ 
/*     */ 
/*     */   
/*  85 */   private final Map<Class<?>, Constructor<?>> defaultConstructorForConcreteType = new HashMap<>();
/*     */ 
/*     */   
/*  88 */   private final Map<Class<?>, Constructor<?>> constructorForConcreteTypeWithSizeHint = new HashMap<>();
/*     */   
/*     */   private static final Constructor<?> NO_CONSTRUCTOR;
/*     */   
/*     */   ReflectionUtils reflectionUtils;
/*     */ 
/*     */   
/*     */   static {
/*     */     try {
/*  97 */       NO_CONSTRUCTOR = NoConstructor.class.getDeclaredConstructor(new Class[0]); return;
/*  98 */     } catch (NoSuchMethodException|SecurityException noSuchMethodException) {
/*     */       
/* 100 */       throw new RuntimeException("Could not find or access constructor for " + NoConstructor.class.getName(), noSuchMethodException);
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
/*     */   private static class NoConstructor {}
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
/*     */   ClassFieldCache(boolean paramBoolean1, boolean paramBoolean2, ReflectionUtils paramReflectionUtils) {
/* 125 */     this.resolveTypes = paramBoolean1;
/* 126 */     this.onlySerializePublicFields = (!paramBoolean1 && paramBoolean2);
/* 127 */     this.reflectionUtils = paramReflectionUtils;
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
/*     */   ClassFields get(Class<?> paramClass) {
/*     */     ClassFields classFields;
/* 140 */     if ((classFields = this.classToClassFields.get(paramClass)) == null) {
/* 141 */       this.classToClassFields.put(paramClass, classFields = new ClassFields(paramClass, this.resolveTypes, this.onlySerializePublicFields, this, this.reflectionUtils));
/*     */     }
/*     */     
/* 144 */     return classFields;
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
/*     */   private static Class<?> getConcreteType(Class<?> paramClass, boolean paramBoolean) {
/* 159 */     if (paramClass == Map.class || paramClass == AbstractMap.class || paramClass == HashMap.class)
/* 160 */       return HashMap.class; 
/* 161 */     if (paramClass == ConcurrentMap.class || paramClass == ConcurrentHashMap.class)
/* 162 */       return ConcurrentHashMap.class; 
/* 163 */     if (paramClass == SortedMap.class || paramClass == NavigableMap.class || paramClass == TreeMap.class)
/* 164 */       return TreeMap.class; 
/* 165 */     if (paramClass == ConcurrentNavigableMap.class || paramClass == ConcurrentSkipListMap.class)
/* 166 */       return ConcurrentSkipListMap.class; 
/* 167 */     if (paramClass == List.class || paramClass == AbstractList.class || paramClass == ArrayList.class || paramClass == Collection.class)
/*     */     {
/* 169 */       return ArrayList.class; } 
/* 170 */     if (paramClass == AbstractSequentialList.class || paramClass == LinkedList.class)
/* 171 */       return LinkedList.class; 
/* 172 */     if (paramClass == Set.class || paramClass == AbstractSet.class || paramClass == HashSet.class)
/* 173 */       return HashSet.class; 
/* 174 */     if (paramClass == SortedSet.class || paramClass == TreeSet.class)
/* 175 */       return TreeSet.class; 
/* 176 */     if (paramClass == Queue.class || paramClass == AbstractQueue.class || paramClass == Deque.class || paramClass == ArrayDeque.class)
/*     */     {
/* 178 */       return ArrayDeque.class; } 
/* 179 */     if (paramClass == BlockingQueue.class || paramClass == LinkedBlockingQueue.class)
/* 180 */       return LinkedBlockingQueue.class; 
/* 181 */     if (paramClass == BlockingDeque.class || paramClass == LinkedBlockingDeque.class)
/* 182 */       return LinkedBlockingDeque.class; 
/* 183 */     if (paramClass == TransferQueue.class || paramClass == LinkedTransferQueue.class) {
/* 184 */       return LinkedTransferQueue.class;
/*     */     }
/* 186 */     return paramBoolean ? null : paramClass;
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
/*     */   Constructor<?> getDefaultConstructorForConcreteTypeOf(Class<?> paramClass) {
/* 200 */     if (paramClass == null) {
/* 201 */       throw new IllegalArgumentException("Class reference cannot be null");
/*     */     }
/*     */     
/*     */     Constructor<?> constructor;
/* 205 */     if ((constructor = this.defaultConstructorForConcreteType.get(paramClass)) != null) {
/* 206 */       return constructor;
/*     */     }
/*     */     
/* 209 */     Class<?> clazz = getConcreteType(paramClass, false), clazz = clazz;
/* 210 */     for (; clazz != null && (clazz != Object.class || paramClass == Object.class); clazz = clazz.getSuperclass()) {
/*     */       try {
/*     */         Constructor<?> constructor1;
/* 213 */         JSONUtils.makeAccessible(constructor1 = clazz.getDeclaredConstructor(new Class[0]), this.reflectionUtils);
/*     */         
/* 215 */         this.defaultConstructorForConcreteType.put(paramClass, constructor1);
/* 216 */         return constructor1;
/* 217 */       } catch (ReflectiveOperationException|SecurityException reflectiveOperationException) {}
/*     */     } 
/*     */ 
/*     */     
/* 221 */     throw new IllegalArgumentException("Class " + paramClass.getName() + " does not have an accessible default (no-arg) constructor");
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
/*     */   Constructor<?> getConstructorWithSizeHintForConcreteTypeOf(Class<?> paramClass) {
/*     */     Constructor<?> constructor;
/* 237 */     if ((constructor = this.constructorForConcreteTypeWithSizeHint.get(paramClass)) == NO_CONSTRUCTOR)
/* 238 */       return null; 
/* 239 */     if (constructor != null) {
/* 240 */       return constructor;
/*     */     }
/*     */     Class<?> clazz;
/* 243 */     if ((clazz = getConcreteType(paramClass, true)) != null) {
/* 244 */       clazz = clazz;
/* 245 */       for (; clazz != null && (clazz != Object.class || paramClass == Object.class); clazz = clazz.getSuperclass()) {
/*     */         try {
/*     */           Constructor<?> constructor1;
/* 248 */           JSONUtils.makeAccessible(constructor1 = clazz.getDeclaredConstructor(new Class[] { int.class }, ), this.reflectionUtils);
/*     */           
/* 250 */           this.constructorForConcreteTypeWithSizeHint.put(paramClass, constructor1);
/* 251 */           return constructor1;
/* 252 */         } catch (ReflectiveOperationException|SecurityException reflectiveOperationException) {}
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 257 */     this.constructorForConcreteTypeWithSizeHint.put(paramClass, NO_CONSTRUCTOR);
/* 258 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\json\ClassFieldCache.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */