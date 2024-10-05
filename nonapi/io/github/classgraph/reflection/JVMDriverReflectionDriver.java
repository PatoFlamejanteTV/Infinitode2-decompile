/*     */ package nonapi.io.github.classgraph.reflection;
/*     */ 
/*     */ import java.lang.reflect.AccessibleObject;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class JVMDriverReflectionDriver
/*     */   extends ReflectionDriver
/*     */ {
/*     */   private Object driver;
/*     */   private final Method getDeclaredMethods;
/*     */   private final Method getDeclaredConstructors;
/*     */   private final Method getDeclaredFields;
/*     */   private final Method getField;
/*     */   private final Method setField;
/*     */   private final Method invokeMethod;
/*     */   private final Method setAccessibleMethod;
/*     */   private ClassFinder classFinder;
/*     */   
/*     */   JVMDriverReflectionDriver() {
/*     */     StandardReflectionDriver standardReflectionDriver;
/*  66 */     Class<?> clazz = (standardReflectionDriver = new StandardReflectionDriver()).findClass("io.github.toolfactory.jvm.DefaultDriver"); Constructor[] arrayOfConstructor; int i; byte b;
/*  67 */     for (i = (arrayOfConstructor = standardReflectionDriver.getDeclaredConstructors(clazz)).length, b = 0; b < i; b++) {
/*  68 */       Constructor constructor; if (((constructor = arrayOfConstructor[b]).getParameterTypes()).length == 0) {
/*  69 */         this.driver = constructor.newInstance(new Object[0]);
/*     */         break;
/*     */       } 
/*     */     } 
/*  73 */     if (this.driver == null) {
/*  74 */       throw new IllegalArgumentException("Could not instantiate jvm.DefaultDriver");
/*     */     }
/*     */ 
/*     */     
/*  78 */     this.getDeclaredMethods = standardReflectionDriver.findInstanceMethod(this.driver, "getDeclaredMethods", new Class[] { Class.class });
/*  79 */     this.getDeclaredConstructors = standardReflectionDriver.findInstanceMethod(this.driver, "getDeclaredConstructors", new Class[] { Class.class });
/*  80 */     this.getDeclaredFields = standardReflectionDriver.findInstanceMethod(this.driver, "getDeclaredFields", new Class[] { Class.class });
/*  81 */     this.getField = standardReflectionDriver.findInstanceMethod(this.driver, "getFieldValue", new Class[] { Object.class, Field.class });
/*  82 */     this.setField = standardReflectionDriver.findInstanceMethod(this.driver, "setFieldValue", new Class[] { Object.class, Field.class, Object.class });
/*  83 */     this.invokeMethod = standardReflectionDriver.findInstanceMethod(this.driver, "invoke", new Class[] { Object.class, Method.class, Object[].class });
/*  84 */     this.setAccessibleMethod = standardReflectionDriver.findInstanceMethod(this.driver, "setAccessible", new Class[] { AccessibleObject.class, boolean.class });
/*     */ 
/*     */     
/*     */     try {
/*  88 */       final Method forName_method = findStaticMethod(Class.class, "forName0", new Class[] { String.class, boolean.class, ClassLoader.class });
/*     */       
/*  90 */       this.classFinder = new ClassFinder()
/*     */         {
/*     */           public Class<?> findClass(String param1String) {
/*  93 */             return (Class)forName0_method.invoke(null, new Object[] { param1String, Boolean.TRUE, 
/*  94 */                   Thread.currentThread().getContextClassLoader() });
/*     */           }
/*     */         };
/*  97 */     } catch (Throwable throwable) {}
/*     */ 
/*     */     
/* 100 */     if (this.classFinder == null) {
/*     */       
/*     */       try {
/* 103 */         final Method forName_method = findStaticMethod(Class.class, "forName0", new Class[] { String.class, boolean.class, ClassLoader.class, Class.class });
/*     */         
/* 105 */         this.classFinder = new ClassFinder()
/*     */           {
/*     */             public Class<?> findClass(String param1String) {
/* 108 */               return (Class)forName0_method.invoke(null, new Object[] { param1String, Boolean.TRUE, 
/* 109 */                     Thread.currentThread().getContextClassLoader(), JVMDriverReflectionDriver.class });
/*     */             }
/*     */           };
/* 112 */       } catch (Throwable throwable) {}
/*     */     }
/*     */ 
/*     */     
/* 116 */     if (this.classFinder == null) {
/*     */       
/*     */       try {
/* 119 */         final Method forName_method = findStaticMethod(Class.class, "forNameImpl", new Class[] { String.class, boolean.class, ClassLoader.class });
/*     */         
/* 121 */         this.classFinder = new ClassFinder()
/*     */           {
/*     */             public Class<?> findClass(String param1String) {
/* 124 */               return (Class)forNameImpl_method.invoke(null, new Object[] { param1String, Boolean.TRUE, 
/* 125 */                     Thread.currentThread().getContextClassLoader() });
/*     */             }
/*     */           };
/* 128 */       } catch (Throwable throwable) {}
/*     */     }
/*     */ 
/*     */     
/* 132 */     if (this.classFinder == null) {
/*     */ 
/*     */       
/* 135 */       final Method forName_method = findStaticMethod(Class.class, "forName", new Class[] { String.class });
/* 136 */       this.classFinder = new ClassFinder()
/*     */         {
/*     */           public Class<?> findClass(String param1String) {
/* 139 */             return (Class)forName_method.invoke(null, new Object[] { param1String });
/*     */           }
/*     */         };
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean makeAccessible(Object paramObject, AccessibleObject paramAccessibleObject) {
/*     */     try {
/* 148 */       this.setAccessibleMethod.invoke(this.driver, new Object[] { paramAccessibleObject, Boolean.TRUE });
/* 149 */     } catch (Throwable throwable) {
/* 150 */       return false;
/*     */     } 
/* 152 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   Class<?> findClass(String paramString) {
/* 157 */     return this.classFinder.findClass(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   Method[] getDeclaredMethods(Class<?> paramClass) {
/* 162 */     return (Method[])this.getDeclaredMethods.invoke(this.driver, new Object[] { paramClass });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   <T> Constructor<T>[] getDeclaredConstructors(Class<T> paramClass) {
/* 168 */     return (Constructor<T>[])this.getDeclaredConstructors.invoke(this.driver, new Object[] { paramClass });
/*     */   }
/*     */ 
/*     */   
/*     */   Field[] getDeclaredFields(Class<?> paramClass) {
/* 173 */     return (Field[])this.getDeclaredFields.invoke(this.driver, new Object[] { paramClass });
/*     */   }
/*     */ 
/*     */   
/*     */   Object getField(Object paramObject, Field paramField) {
/* 178 */     return this.getField.invoke(this.driver, new Object[] { paramObject, paramField });
/*     */   }
/*     */ 
/*     */   
/*     */   void setField(Object paramObject1, Field paramField, Object paramObject2) {
/* 183 */     this.setField.invoke(this.driver, new Object[] { paramObject1, paramField, paramObject2 });
/*     */   }
/*     */ 
/*     */   
/*     */   Object getStaticField(Field paramField) {
/* 188 */     return this.getField.invoke(this.driver, new Object[] { null, paramField });
/*     */   }
/*     */ 
/*     */   
/*     */   void setStaticField(Field paramField, Object paramObject) {
/* 193 */     this.setField.invoke(this.driver, new Object[] { null, paramField, paramObject });
/*     */   }
/*     */ 
/*     */   
/*     */   Object invokeMethod(Object paramObject, Method paramMethod, Object... paramVarArgs) {
/* 198 */     return this.invokeMethod.invoke(this.driver, new Object[] { paramObject, paramMethod, paramVarArgs });
/*     */   }
/*     */ 
/*     */   
/*     */   Object invokeStaticMethod(Method paramMethod, Object... paramVarArgs) {
/* 203 */     return this.invokeMethod.invoke(this.driver, new Object[] { null, paramMethod, paramVarArgs });
/*     */   }
/*     */   
/*     */   private static interface ClassFinder {
/*     */     Class<?> findClass(String param1String);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\reflection\JVMDriverReflectionDriver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */