/*     */ package nonapi.io.github.classgraph.reflection;
/*     */ 
/*     */ import java.lang.reflect.AccessibleObject;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import nonapi.io.github.classgraph.concurrency.SingletonMap;
/*     */ import nonapi.io.github.classgraph.utils.LogNode;
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
/*     */ abstract class ReflectionDriver
/*     */ {
/*  49 */   private final SingletonMap<Class<?>, ClassMemberCache, Exception> classToClassMemberCache = new SingletonMap<Class<?>, ClassMemberCache, Exception>()
/*     */     {
/*     */       
/*     */       public ReflectionDriver.ClassMemberCache newInstance(Class<?> param1Class, LogNode param1LogNode)
/*     */       {
/*  54 */         return new ReflectionDriver.ClassMemberCache(param1Class);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private static Method isAccessibleMethod;
/*     */   
/*     */   private static Method canAccessMethod;
/*     */ 
/*     */   
/*     */   static {
/*     */     try {
/*  66 */       isAccessibleMethod = AccessibleObject.class.getDeclaredMethod("isAccessible", new Class[0]);
/*  67 */     } catch (Throwable throwable) {}
/*     */ 
/*     */     
/*     */     try {
/*  71 */       canAccessMethod = AccessibleObject.class.getDeclaredMethod("canAccess", new Class[] { Object.class }); return;
/*  72 */     } catch (Throwable throwable) {
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public class ClassMemberCache
/*     */   {
/*  79 */     private final Map<String, List<Method>> methodNameToMethods = new HashMap<>();
/*  80 */     private final Map<String, Field> fieldNameToField = new HashMap<>();
/*     */ 
/*     */     
/*     */     private ClassMemberCache(Class<?> param1Class) {
/*  84 */       HashSet<Class<?>> hashSet = new HashSet();
/*  85 */       LinkedList<Class<?>> linkedList = new LinkedList();
/*  86 */       for (param1Class = param1Class; param1Class != null; param1Class = param1Class.getSuperclass()) {
/*     */         try {
/*     */           Method[] arrayOfMethod; int i; byte b;
/*  89 */           for (i = (arrayOfMethod = ReflectionDriver.this.getDeclaredMethods(param1Class)).length, b = 0; b < i; ) { Method method = arrayOfMethod[b];
/*  90 */             cacheMethod(method); b++; }
/*     */            Field[] arrayOfField;
/*  92 */           for (i = (arrayOfField = ReflectionDriver.this.getDeclaredFields(param1Class)).length, b = 0; b < i; ) { Field field = arrayOfField[b];
/*  93 */             cacheField(field);
/*     */             b++; }
/*     */           
/*  96 */           if (param1Class.isInterface() && hashSet.add(param1Class))
/*  97 */             linkedList.add(param1Class); 
/*     */           Class[] arrayOfClass;
/*  99 */           for (i = (arrayOfClass = param1Class.getInterfaces()).length, b = 0; b < i; ) { Class<?> clazz = arrayOfClass[b];
/* 100 */             if (hashSet.add(clazz))
/* 101 */               linkedList.add(clazz); 
/*     */             b++; }
/*     */         
/* 104 */         } catch (Exception exception) {}
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 109 */       while (!linkedList.isEmpty()) {
/* 110 */         param1Class = linkedList.remove(); try {
/*     */           Method[] arrayOfMethod; int j; byte b1;
/* 112 */           for (j = (arrayOfMethod = ReflectionDriver.this.getDeclaredMethods(param1Class)).length, b1 = 0; b1 < j; ) { Method method = arrayOfMethod[b1];
/* 113 */             cacheMethod(method); b1++; }
/*     */         
/* 115 */         } catch (Exception exception) {} Class[] arrayOfClass;
/*     */         int i;
/*     */         byte b;
/* 118 */         for (i = (arrayOfClass = param1Class.getInterfaces()).length, b = 0; b < i; ) { Class<?> clazz = arrayOfClass[b];
/* 119 */           if (hashSet.add(clazz))
/* 120 */             linkedList.add(clazz); 
/*     */           b++; }
/*     */       
/*     */       } 
/*     */     }
/*     */     
/*     */     private void cacheMethod(Method param1Method) {
/*     */       List<Method> list;
/* 128 */       if ((list = this.methodNameToMethods.get(param1Method.getName())) == null) {
/* 129 */         this.methodNameToMethods.put(param1Method.getName(), list = new ArrayList<>());
/*     */       }
/* 131 */       list.add(param1Method);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void cacheField(Field param1Field) {
/* 137 */       if (!this.fieldNameToField.containsKey(param1Field.getName())) {
/* 138 */         this.fieldNameToField.put(param1Field.getName(), param1Field);
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
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isAccessible(Object paramObject, AccessibleObject paramAccessibleObject) {
/* 273 */     if (canAccessMethod != null) {
/*     */       
/*     */       try {
/* 276 */         return ((Boolean)canAccessMethod.invoke(paramAccessibleObject, new Object[] { paramObject })).booleanValue();
/* 277 */       } catch (Throwable throwable) {}
/*     */     }
/*     */ 
/*     */     
/* 281 */     if (isAccessibleMethod != null) {
/*     */       
/*     */       try {
/* 284 */         return ((Boolean)isAccessibleMethod.invoke(paramAccessibleObject, new Object[0])).booleanValue();
/* 285 */       } catch (Throwable throwable) {}
/*     */     }
/*     */ 
/*     */     
/* 289 */     return false;
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
/*     */   protected Field findField(Class<?> paramClass, Object paramObject, String paramString) {
/*     */     Field field;
/* 308 */     if ((field = (Field)((ClassMemberCache)this.classToClassMemberCache.get(paramClass, null)).fieldNameToField.get(paramString)) != null) {
/* 309 */       if (!isAccessible(paramObject, field))
/*     */       {
/*     */         
/* 312 */         makeAccessible(paramObject, field);
/*     */       }
/* 314 */       return field;
/*     */     } 
/* 316 */     throw new NoSuchFieldException("Could not find field " + paramClass.getName() + "." + paramString);
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
/*     */   protected Field findStaticField(Class<?> paramClass, String paramString) {
/* 332 */     return findField(paramClass, null, paramString);
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
/*     */   protected Field findInstanceField(Object paramObject, String paramString) {
/* 348 */     if (paramObject == null) {
/* 349 */       throw new IllegalArgumentException("obj cannot be null");
/*     */     }
/* 351 */     return findField(paramObject.getClass(), paramObject, paramString);
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
/*     */ 
/*     */ 
/*     */   
/*     */   protected Method findMethod(Class<?> paramClass, Object paramObject, String paramString, Class<?>... paramVarArgs) {
/*     */     List<Method> list;
/* 373 */     if ((list = (List)((ClassMemberCache)this.classToClassMemberCache.get(paramClass, null)).methodNameToMethods.get(paramString)) != null) {
/*     */       
/* 375 */       boolean bool = false; Iterator<Method> iterator;
/* 376 */       for (iterator = list.iterator(); iterator.hasNext();) {
/* 377 */         if (Arrays.equals((Object[])(method = iterator.next()).getParameterTypes(), (Object[])paramVarArgs)) {
/* 378 */           bool = true;
/* 379 */           if (isAccessible(paramObject, method)) {
/* 380 */             return method;
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 386 */       if (bool) {
/* 387 */         for (iterator = list.iterator(); iterator.hasNext();) {
/* 388 */           if (Arrays.equals((Object[])(method = iterator.next()).getParameterTypes(), (Object[])paramVarArgs) && makeAccessible(paramObject, method)) {
/* 389 */             return method;
/*     */           }
/*     */         } 
/*     */       }
/* 393 */       throw new NoSuchMethodException("Could not make method accessible: " + paramClass
/* 394 */           .getName() + "." + paramString);
/*     */     } 
/* 396 */     throw new NoSuchMethodException("Could not find method " + paramClass.getName() + "." + paramString);
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
/*     */   protected Method findStaticMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs) {
/* 414 */     return findMethod(paramClass, null, paramString, paramVarArgs);
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
/*     */   protected Method findInstanceMethod(Object paramObject, String paramString, Class<?>... paramVarArgs) {
/* 432 */     if (paramObject == null) {
/* 433 */       throw new IllegalArgumentException("obj cannot be null");
/*     */     }
/* 435 */     return findMethod(paramObject.getClass(), paramObject, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   abstract Class<?> findClass(String paramString);
/*     */   
/*     */   abstract Method[] getDeclaredMethods(Class<?> paramClass);
/*     */   
/*     */   abstract <T> Constructor<T>[] getDeclaredConstructors(Class<T> paramClass);
/*     */   
/*     */   abstract Field[] getDeclaredFields(Class<?> paramClass);
/*     */   
/*     */   abstract Object getField(Object paramObject, Field paramField);
/*     */   
/*     */   abstract void setField(Object paramObject1, Field paramField, Object paramObject2);
/*     */   
/*     */   abstract Object getStaticField(Field paramField);
/*     */   
/*     */   abstract void setStaticField(Field paramField, Object paramObject);
/*     */   
/*     */   abstract Object invokeMethod(Object paramObject, Method paramMethod, Object... paramVarArgs);
/*     */   
/*     */   abstract Object invokeStaticMethod(Method paramMethod, Object... paramVarArgs);
/*     */   
/*     */   abstract boolean makeAccessible(Object paramObject, AccessibleObject paramAccessibleObject);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\reflection\ReflectionDriver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */