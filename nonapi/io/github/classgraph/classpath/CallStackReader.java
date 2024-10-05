/*     */ package nonapi.io.github.classgraph.classpath;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Callable;
/*     */ import nonapi.io.github.classgraph.reflection.ReflectionUtils;
/*     */ import nonapi.io.github.classgraph.utils.LogNode;
/*     */ import nonapi.io.github.classgraph.utils.VersionFinder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CallStackReader
/*     */ {
/*     */   ReflectionUtils reflectionUtils;
/*     */   
/*     */   public CallStackReader(ReflectionUtils paramReflectionUtils) {
/*  51 */     this.reflectionUtils = paramReflectionUtils;
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
/*     */   private static Class<?>[] getCallStackViaStackWalker() {
/*     */     try {
/*  66 */       Class<?> clazz1 = Class.forName("java.util.function.Consumer");
/*  67 */       final ArrayList stackFrameClasses = new ArrayList();
/*  68 */       Class<?> clazz2 = Class.forName("java.lang.StackWalker$Option");
/*     */ 
/*     */       
/*  71 */       final Object stackFrameGetDeclaringClassMethod = Class.forName("java.lang.Enum").getMethod("valueOf", new Class[] { Class.class, String.class }).invoke(null, new Object[] { clazz2, "RETAIN_CLASS_REFERENCE" });
/*     */       
/*     */       Class<?> clazz3;
/*  74 */       Object object1 = (clazz3 = Class.forName("java.lang.StackWalker")).getMethod("getInstance", new Class[] { clazz2 }).invoke(null, new Object[] { object2 });
/*     */       
/*  76 */       object2 = Class.forName("java.lang.StackWalker$StackFrame").getMethod("getDeclaringClass", new Class[0]);
/*  77 */       clazz3.getMethod("forEach", new Class[] { clazz1 }).invoke(object1, new Object[] {
/*     */             
/*  79 */             Proxy.newProxyInstance(clazz1.getClassLoader(), new Class[] { clazz1 }, new InvocationHandler()
/*     */               {
/*     */ 
/*     */ 
/*     */                 
/*     */                 public final Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject)
/*     */                 {
/*  86 */                   param1Object = stackFrameGetDeclaringClassMethod.invoke(param1ArrayOfObject[0], new Object[0]);
/*  87 */                   stackFrameClasses.add(param1Object);
/*  88 */                   return null;
/*     */                 }
/*     */               }) });
/*  91 */       return (Class[])arrayList.toArray((Object[])new Class[0]);
/*  92 */     } catch (Exception|LinkageError exception) {
/*  93 */       return null;
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
/*     */   private static Class<?>[] getCallStackViaSecurityManager(LogNode paramLogNode) {
/*     */     try {
/* 109 */       Class<?> clazz = Class.forName("java.lang.SecurityManager");
/* 110 */       Object object = null; Constructor[] arrayOfConstructor; int i; byte b;
/* 111 */       for (i = (arrayOfConstructor = (Constructor[])clazz.getDeclaredConstructors()).length, b = 0; b < i; b++) {
/* 112 */         Constructor<Object> constructor; if (((constructor = arrayOfConstructor[b]).getParameterTypes()).length == 0) {
/* 113 */           object = constructor.newInstance(new Object[0]);
/*     */           break;
/*     */         } 
/*     */       } 
/* 117 */       if (object != null) {
/*     */         Method method;
/* 119 */         (method = object.getClass().getDeclaredMethod("getClassContext", new Class[0])).setAccessible(true);
/* 120 */         return (Class[])method.invoke(object, new Object[0]);
/*     */       } 
/* 122 */       return null;
/*     */     }
/* 124 */     catch (Throwable throwable) {
/*     */ 
/*     */       
/* 127 */       if (paramLogNode != null) {
/* 128 */         paramLogNode.log("Exception while trying to obtain call stack via SecurityManager", throwable);
/*     */       }
/* 130 */       return null;
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
/*     */   Class<?>[] getClassContext(final LogNode log) {
/* 144 */     Class[] arrayOfClass = null;
/*     */ 
/*     */     
/* 147 */     if (VersionFinder.JAVA_MAJOR_VERSION != 9 && VersionFinder.JAVA_MAJOR_VERSION != 10 && (VersionFinder.JAVA_MAJOR_VERSION != 11 || VersionFinder.JAVA_MINOR_VERSION != 0 || (VersionFinder.JAVA_SUB_VERSION >= 4 && (VersionFinder.JAVA_SUB_VERSION != 4 || !VersionFinder.JAVA_IS_EA_VERSION))) && (VersionFinder.JAVA_MAJOR_VERSION != 12 || VersionFinder.JAVA_MINOR_VERSION != 0 || (VersionFinder.JAVA_SUB_VERSION >= 2 && (VersionFinder.JAVA_SUB_VERSION != 2 || !VersionFinder.JAVA_IS_EA_VERSION)))) {
/*     */       
/*     */       try {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 167 */         arrayOfClass = (Class[])this.reflectionUtils.doPrivileged(new Callable<Class<?>[]>()
/*     */             {
/*     */               public Class<?>[] call() {
/* 170 */                 return CallStackReader.getCallStackViaStackWalker();
/*     */               }
/*     */             });
/* 173 */       } catch (Throwable throwable) {}
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 180 */     if (VersionFinder.JAVA_MAJOR_VERSION < 9 && (arrayOfClass == null || arrayOfClass.length == 0)) {
/*     */       try {
/* 182 */         arrayOfClass = (Class[])this.reflectionUtils.doPrivileged(new Callable<Class<?>[]>()
/*     */             {
/*     */               public Class<?>[] call() {
/* 185 */                 return CallStackReader.getCallStackViaSecurityManager(log);
/*     */               }
/*     */             });
/* 188 */       } catch (Throwable throwable) {}
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 194 */     if (arrayOfClass == null || arrayOfClass.length == 0) {
/* 195 */       log = null;
/*     */       try {
/* 197 */         arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
/* 198 */       } catch (SecurityException securityException) {}
/*     */ 
/*     */       
/* 201 */       if (arrayOfStackTraceElement == null || arrayOfStackTraceElement.length == 0) {
/*     */         
/*     */         try {
/* 204 */           throw new Exception();
/* 205 */         } catch (Exception exception2) {
/* 206 */           Exception exception1; arrayOfStackTraceElement = (exception1 = null).getStackTrace();
/*     */         } 
/*     */       }
/* 209 */       ArrayList<Class<?>> arrayList = new ArrayList(); StackTraceElement[] arrayOfStackTraceElement; int i; byte b;
/* 210 */       for (i = (arrayOfStackTraceElement = arrayOfStackTraceElement).length, b = 0; b < i; ) { StackTraceElement stackTraceElement = arrayOfStackTraceElement[b];
/*     */         try {
/* 212 */           arrayList.add(Class.forName(stackTraceElement.getClassName()));
/* 213 */         } catch (ClassNotFoundException|LinkageError classNotFoundException) {}
/*     */         
/*     */         b++; }
/*     */       
/* 217 */       if (!arrayList.isEmpty()) {
/* 218 */         arrayOfClass = (Class[])arrayList.<Class<?>[]>toArray((Class<?>[][])new Class[0]);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 223 */     if (arrayOfClass == null || arrayOfClass.length == 0) {
/* 224 */       arrayOfClass = new Class[] { CallStackReader.class };
/*     */     }
/*     */     
/* 227 */     return arrayOfClass;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\classpath\CallStackReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */