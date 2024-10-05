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
/*     */ class NarcissusReflectionDriver
/*     */   extends ReflectionDriver
/*     */ {
/*     */   private final Class<?> narcissusClass;
/*     */   private final Method getDeclaredMethods;
/*     */   private final Method findClass;
/*     */   private final Method getDeclaredConstructors;
/*     */   private final Method getDeclaredFields;
/*     */   private final Method getField;
/*     */   private final Method setField;
/*     */   private final Method getStaticField;
/*     */   private final Method setStaticField;
/*     */   private final Method invokeMethod;
/*     */   private final Method invokeStaticMethod;
/*     */   
/*     */   NarcissusReflectionDriver() {
/*  56 */     StandardReflectionDriver standardReflectionDriver = new StandardReflectionDriver();
/*  57 */     this.narcissusClass = standardReflectionDriver.findClass("io.github.toolfactory.narcissus.Narcissus");
/*  58 */     if (!((Boolean)standardReflectionDriver.getStaticField(standardReflectionDriver.findStaticField(this.narcissusClass, "libraryLoaded"))).booleanValue()) {
/*  59 */       throw new IllegalArgumentException("Could not load Narcissus native library");
/*     */     }
/*     */ 
/*     */     
/*  63 */     this.findClass = standardReflectionDriver.findStaticMethod(this.narcissusClass, "findClass", new Class[] { String.class });
/*  64 */     this.getDeclaredMethods = standardReflectionDriver.findStaticMethod(this.narcissusClass, "getDeclaredMethods", new Class[] { Class.class });
/*  65 */     this.getDeclaredConstructors = standardReflectionDriver.findStaticMethod(this.narcissusClass, "getDeclaredConstructors", new Class[] { Class.class });
/*  66 */     this.getDeclaredFields = standardReflectionDriver.findStaticMethod(this.narcissusClass, "getDeclaredFields", new Class[] { Class.class });
/*  67 */     this.getField = standardReflectionDriver.findStaticMethod(this.narcissusClass, "getField", new Class[] { Object.class, Field.class });
/*  68 */     this.setField = standardReflectionDriver.findStaticMethod(this.narcissusClass, "setField", new Class[] { Object.class, Field.class, Object.class });
/*  69 */     this.getStaticField = standardReflectionDriver.findStaticMethod(this.narcissusClass, "getStaticField", new Class[] { Field.class });
/*  70 */     this.setStaticField = standardReflectionDriver.findStaticMethod(this.narcissusClass, "setStaticField", new Class[] { Field.class, Object.class });
/*  71 */     this.invokeMethod = standardReflectionDriver.findStaticMethod(this.narcissusClass, "invokeMethod", new Class[] { Object.class, Method.class, Object[].class });
/*     */     
/*  73 */     this.invokeStaticMethod = standardReflectionDriver.findStaticMethod(this.narcissusClass, "invokeStaticMethod", new Class[] { Method.class, Object[].class });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAccessible(Object paramObject, AccessibleObject paramAccessibleObject) {
/*  79 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean makeAccessible(Object paramObject, AccessibleObject paramAccessibleObject) {
/*  84 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   Class<?> findClass(String paramString) {
/*  89 */     return (Class)this.findClass.invoke(null, new Object[] { paramString });
/*     */   }
/*     */ 
/*     */   
/*     */   Method[] getDeclaredMethods(Class<?> paramClass) {
/*  94 */     return (Method[])this.getDeclaredMethods.invoke(null, new Object[] { paramClass });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   <T> Constructor<T>[] getDeclaredConstructors(Class<T> paramClass) {
/* 100 */     return (Constructor<T>[])this.getDeclaredConstructors.invoke(null, new Object[] { paramClass });
/*     */   }
/*     */ 
/*     */   
/*     */   Field[] getDeclaredFields(Class<?> paramClass) {
/* 105 */     return (Field[])this.getDeclaredFields.invoke(null, new Object[] { paramClass });
/*     */   }
/*     */ 
/*     */   
/*     */   Object getField(Object paramObject, Field paramField) {
/* 110 */     return this.getField.invoke(null, new Object[] { paramObject, paramField });
/*     */   }
/*     */ 
/*     */   
/*     */   void setField(Object paramObject1, Field paramField, Object paramObject2) {
/* 115 */     this.setField.invoke(null, new Object[] { paramObject1, paramField, paramObject2 });
/*     */   }
/*     */ 
/*     */   
/*     */   Object getStaticField(Field paramField) {
/* 120 */     return this.getStaticField.invoke(null, new Object[] { paramField });
/*     */   }
/*     */ 
/*     */   
/*     */   void setStaticField(Field paramField, Object paramObject) {
/* 125 */     this.setStaticField.invoke(null, new Object[] { paramField, paramObject });
/*     */   }
/*     */ 
/*     */   
/*     */   Object invokeMethod(Object paramObject, Method paramMethod, Object... paramVarArgs) {
/* 130 */     return this.invokeMethod.invoke(null, new Object[] { paramObject, paramMethod, paramVarArgs });
/*     */   }
/*     */ 
/*     */   
/*     */   Object invokeStaticMethod(Method paramMethod, Object... paramVarArgs) {
/* 135 */     return this.invokeStaticMethod.invoke(null, new Object[] { paramMethod, paramVarArgs });
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\reflection\NarcissusReflectionDriver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */