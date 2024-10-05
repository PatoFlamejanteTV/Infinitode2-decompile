/*     */ package nonapi.io.github.classgraph.reflection;
/*     */ 
/*     */ import java.lang.reflect.AccessibleObject;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.util.concurrent.Callable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class StandardReflectionDriver
/*     */   extends ReflectionDriver
/*     */ {
/*     */   private static Method setAccessibleMethod;
/*     */   private static Method trySetAccessibleMethod;
/*     */   private static Class<?> accessControllerClass;
/*     */   private static Class<?> privilegedActionClass;
/*     */   private static Method accessControllerDoPrivileged;
/*     */   
/*     */   static {
/*     */     try {
/*  55 */       setAccessibleMethod = AccessibleObject.class.getDeclaredMethod("setAccessible", new Class[] { boolean.class });
/*  56 */     } catch (Throwable throwable) {}
/*     */ 
/*     */     
/*     */     try {
/*  60 */       trySetAccessibleMethod = AccessibleObject.class.getDeclaredMethod("trySetAccessible", new Class[0]);
/*  61 */     } catch (Throwable throwable) {}
/*     */ 
/*     */     
/*     */     try {
/*  65 */       accessControllerClass = Class.forName("java.security.AccessController");
/*  66 */       privilegedActionClass = Class.forName("java.security.PrivilegedAction");
/*  67 */       accessControllerDoPrivileged = accessControllerClass.getMethod("doPrivileged", new Class[] { privilegedActionClass }); return;
/*  68 */     } catch (Throwable throwable) {
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   private class PrivilegedActionInvocationHandler<T>
/*     */     implements InvocationHandler
/*     */   {
/*     */     private final Callable<T> callable;
/*     */     
/*     */     public PrivilegedActionInvocationHandler(Callable<T> param1Callable) {
/*  79 */       this.callable = param1Callable;
/*     */     }
/*     */ 
/*     */     
/*     */     public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) {
/*  84 */       return this.callable.call();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private <T> T doPrivileged(Callable<T> paramCallable) {
/*     */     Object object;
/*  94 */     if (accessControllerDoPrivileged != null) {
/*  95 */       object = Proxy.newProxyInstance(privilegedActionClass.getClassLoader(), new Class[] { privilegedActionClass }, new PrivilegedActionInvocationHandler<>(paramCallable));
/*     */       
/*  97 */       return (T)accessControllerDoPrivileged.invoke(null, new Object[] { object });
/*     */     } 
/*     */     
/* 100 */     return object.call();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean tryMakeAccessible(AccessibleObject paramAccessibleObject) {
/* 107 */     if (trySetAccessibleMethod != null) {
/*     */       
/*     */       try {
/* 110 */         return ((Boolean)trySetAccessibleMethod.invoke(paramAccessibleObject, new Object[0])).booleanValue();
/* 111 */       } catch (Throwable throwable) {}
/*     */     }
/*     */ 
/*     */     
/* 115 */     if (setAccessibleMethod != null) {
/*     */       
/*     */       try {
/* 118 */         setAccessibleMethod.invoke(paramAccessibleObject, new Object[] { Boolean.TRUE });
/* 119 */         return true;
/* 120 */       } catch (Throwable throwable) {}
/*     */     }
/*     */ 
/*     */     
/* 124 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean makeAccessible(Object paramObject, final AccessibleObject obj) {
/* 129 */     if (isAccessible(paramObject, obj)) {
/* 130 */       return true;
/*     */     }
/*     */     try {
/* 133 */       return ((Boolean)doPrivileged(new Callable<Boolean>()
/*     */           {
/*     */             public Boolean call() {
/* 136 */               return Boolean.valueOf(StandardReflectionDriver.tryMakeAccessible(obj));
/*     */             }
/*     */           })).booleanValue();
/* 139 */     } catch (Throwable throwable) {
/*     */       
/* 141 */       return tryMakeAccessible(obj);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   Class<?> findClass(String paramString) {
/* 147 */     return Class.forName(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   Method[] getDeclaredMethods(Class<?> paramClass) {
/* 152 */     return paramClass.getDeclaredMethods();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   <T> Constructor<T>[] getDeclaredConstructors(Class<T> paramClass) {
/* 158 */     return (Constructor<T>[])paramClass.getDeclaredConstructors();
/*     */   }
/*     */ 
/*     */   
/*     */   Field[] getDeclaredFields(Class<?> paramClass) {
/* 163 */     return paramClass.getDeclaredFields();
/*     */   }
/*     */ 
/*     */   
/*     */   Object getField(Object paramObject, Field paramField) {
/* 168 */     makeAccessible(paramObject, paramField);
/* 169 */     return paramField.get(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   void setField(Object paramObject1, Field paramField, Object paramObject2) {
/* 174 */     makeAccessible(paramObject1, paramField);
/* 175 */     paramField.set(paramObject1, paramObject2);
/*     */   }
/*     */ 
/*     */   
/*     */   Object getStaticField(Field paramField) {
/* 180 */     makeAccessible((Object)null, paramField);
/* 181 */     return paramField.get(null);
/*     */   }
/*     */ 
/*     */   
/*     */   void setStaticField(Field paramField, Object paramObject) {
/* 186 */     makeAccessible((Object)null, paramField);
/* 187 */     paramField.set(null, paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   Object invokeMethod(Object paramObject, Method paramMethod, Object... paramVarArgs) {
/* 192 */     makeAccessible(paramObject, paramMethod);
/* 193 */     return paramMethod.invoke(paramObject, paramVarArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   Object invokeStaticMethod(Method paramMethod, Object... paramVarArgs) {
/* 198 */     makeAccessible((Object)null, paramMethod);
/* 199 */     return paramMethod.invoke(null, paramVarArgs);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\reflection\StandardReflectionDriver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */