/*     */ package nonapi.io.github.classgraph.reflection;
/*     */ 
/*     */ import io.github.classgraph.ClassGraph;
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
/*     */ public final class ReflectionUtils
/*     */ {
/*     */   public ReflectionDriver reflectionDriver;
/*     */   private Class<?> accessControllerClass;
/*     */   private Class<?> privilegedActionClass;
/*     */   private Method accessControllerDoPrivileged;
/*     */   
/*     */   public ReflectionUtils() {
/*  50 */     if (ClassGraph.CIRCUMVENT_ENCAPSULATION == ClassGraph.CircumventEncapsulationMethod.NARCISSUS) {
/*     */       try {
/*  52 */         this.reflectionDriver = new NarcissusReflectionDriver();
/*  53 */       } catch (Throwable throwable) {
/*  54 */         System.err.println("Could not load Narcissus reflection driver: " + throwable);
/*     */       }
/*     */     
/*  57 */     } else if (ClassGraph.CIRCUMVENT_ENCAPSULATION == ClassGraph.CircumventEncapsulationMethod.JVM_DRIVER) {
/*     */       try {
/*  59 */         this.reflectionDriver = new JVMDriverReflectionDriver();
/*  60 */       } catch (Throwable throwable) {
/*  61 */         System.err.println("Could not load JVM-Driver reflection driver: " + throwable);
/*     */       } 
/*     */     } 
/*     */     
/*  65 */     if (this.reflectionDriver == null) {
/*  66 */       this.reflectionDriver = new StandardReflectionDriver();
/*     */     }
/*     */     try {
/*  69 */       this.accessControllerClass = this.reflectionDriver.findClass("java.security.AccessController");
/*  70 */       this.privilegedActionClass = this.reflectionDriver.findClass("java.security.PrivilegedAction");
/*  71 */       this.accessControllerDoPrivileged = this.reflectionDriver.findMethod(this.accessControllerClass, null, "doPrivileged", new Class[] { this.privilegedActionClass });
/*     */       return;
/*  73 */     } catch (Throwable throwable) {
/*     */       return;
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
/*     */   public final Object getFieldVal(boolean paramBoolean, Object paramObject, Field paramField) {
/*  97 */     if (this.reflectionDriver == null) {
/*  98 */       throw new RuntimeException("Cannot use reflection after ScanResult has been closed");
/*     */     }
/* 100 */     if (paramObject == null || paramField == null) {
/* 101 */       if (paramBoolean) {
/* 102 */         throw new NullPointerException();
/*     */       }
/* 104 */       return null;
/*     */     } 
/*     */     
/*     */     try {
/* 108 */       return this.reflectionDriver.getField(paramObject, paramField);
/* 109 */     } catch (Throwable throwable) {
/* 110 */       if (paramBoolean) {
/* 111 */         throw new IllegalArgumentException("Can't read field " + paramObject
/* 112 */             .getClass().getName() + "." + paramField.getName(), throwable);
/*     */       }
/*     */       
/* 115 */       return null;
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
/*     */   public final Object getFieldVal(boolean paramBoolean, Object paramObject, String paramString) {
/* 137 */     if (this.reflectionDriver == null) {
/* 138 */       throw new RuntimeException("Cannot use reflection after ScanResult has been closed");
/*     */     }
/* 140 */     if (paramObject == null || paramString == null) {
/* 141 */       if (paramBoolean) {
/* 142 */         throw new NullPointerException();
/*     */       }
/* 144 */       return null;
/*     */     } 
/*     */     
/*     */     try {
/* 148 */       return this.reflectionDriver.getField(paramObject, this.reflectionDriver.findInstanceField(paramObject, paramString));
/* 149 */     } catch (Throwable throwable) {
/* 150 */       if (paramBoolean) {
/* 151 */         throw new IllegalArgumentException("Can't read field " + paramObject.getClass().getName() + "." + paramString, throwable);
/*     */       }
/*     */ 
/*     */       
/* 155 */       return null;
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
/*     */   public final Object getStaticFieldVal(boolean paramBoolean, Class<?> paramClass, String paramString) {
/* 177 */     if (this.reflectionDriver == null) {
/* 178 */       throw new RuntimeException("Cannot use reflection after ScanResult has been closed");
/*     */     }
/* 180 */     if (paramClass == null || paramString == null) {
/* 181 */       if (paramBoolean) {
/* 182 */         throw new NullPointerException();
/*     */       }
/* 184 */       return null;
/*     */     } 
/*     */     
/*     */     try {
/* 188 */       return this.reflectionDriver.getStaticField(this.reflectionDriver.findStaticField(paramClass, paramString));
/* 189 */     } catch (Throwable throwable) {
/* 190 */       if (paramBoolean) {
/* 191 */         throw new IllegalArgumentException("Can't read field " + paramClass.getName() + "." + paramString, throwable);
/*     */       }
/*     */       
/* 194 */       return null;
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
/*     */   public final Object invokeMethod(boolean paramBoolean, Object paramObject, String paramString) {
/* 216 */     if (this.reflectionDriver == null) {
/* 217 */       throw new RuntimeException("Cannot use reflection after ScanResult has been closed");
/*     */     }
/* 219 */     if (paramObject == null || paramString == null) {
/* 220 */       if (paramBoolean) {
/* 221 */         throw new IllegalArgumentException("Unexpected null argument");
/*     */       }
/* 223 */       return null;
/*     */     } 
/*     */     
/*     */     try {
/* 227 */       return this.reflectionDriver.invokeMethod(paramObject, this.reflectionDriver.findInstanceMethod(paramObject, paramString, new Class[0]), new Object[0]);
/* 228 */     } catch (Throwable throwable) {
/* 229 */       if (paramBoolean) {
/* 230 */         throw new IllegalArgumentException("Method \"" + paramString + "\" could not be invoked", throwable);
/*     */       }
/* 232 */       return null;
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
/*     */   public final Object invokeMethod(boolean paramBoolean, Object paramObject1, String paramString, Class<?> paramClass, Object paramObject2) {
/* 259 */     if (this.reflectionDriver == null) {
/* 260 */       throw new RuntimeException("Cannot use reflection after ScanResult has been closed");
/*     */     }
/* 262 */     if (paramObject1 == null || paramString == null || paramClass == null) {
/* 263 */       if (paramBoolean) {
/* 264 */         throw new IllegalArgumentException("Unexpected null argument");
/*     */       }
/* 266 */       return null;
/*     */     } 
/*     */     
/*     */     try {
/* 270 */       return this.reflectionDriver.invokeMethod(paramObject1, this.reflectionDriver.findInstanceMethod(paramObject1, paramString, new Class[] { paramClass }), new Object[] { paramObject2 });
/*     */     }
/* 272 */     catch (Throwable throwable) {
/* 273 */       if (paramBoolean) {
/* 274 */         throw new IllegalArgumentException("Method \"" + paramString + "\" could not be invoked", throwable);
/*     */       }
/* 276 */       return null;
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
/*     */   public final Object invokeStaticMethod(boolean paramBoolean, Class<?> paramClass, String paramString) {
/* 298 */     if (this.reflectionDriver == null) {
/* 299 */       throw new RuntimeException("Cannot use reflection after ScanResult has been closed");
/*     */     }
/* 301 */     if (paramClass == null || paramString == null) {
/* 302 */       if (paramBoolean) {
/* 303 */         throw new IllegalArgumentException("Unexpected null argument");
/*     */       }
/* 305 */       return null;
/*     */     } 
/*     */     
/*     */     try {
/* 309 */       return this.reflectionDriver.invokeStaticMethod(this.reflectionDriver.findStaticMethod(paramClass, paramString, new Class[0]), new Object[0]);
/* 310 */     } catch (Throwable throwable) {
/* 311 */       if (paramBoolean) {
/* 312 */         throw new IllegalArgumentException("Method \"" + paramString + "\" could not be invoked", throwable);
/*     */       }
/* 314 */       return null;
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
/*     */   public final Object invokeStaticMethod(boolean paramBoolean, Class<?> paramClass1, String paramString, Class<?> paramClass2, Object paramObject) {
/* 340 */     if (this.reflectionDriver == null) {
/* 341 */       throw new RuntimeException("Cannot use reflection after ScanResult has been closed");
/*     */     }
/* 343 */     if (paramClass1 == null || paramString == null || paramClass2 == null) {
/* 344 */       if (paramBoolean) {
/* 345 */         throw new IllegalArgumentException("Unexpected null argument");
/*     */       }
/* 347 */       return null;
/*     */     } 
/*     */     
/*     */     try {
/* 351 */       return this.reflectionDriver.invokeStaticMethod(this.reflectionDriver.findStaticMethod(paramClass1, paramString, new Class[] { paramClass2 }), new Object[] { paramObject });
/*     */     }
/* 353 */     catch (Throwable throwable) {
/* 354 */       if (paramBoolean) {
/* 355 */         throw new IllegalArgumentException("Fethod \"" + paramString + "\" could not be invoked", throwable);
/*     */       }
/* 357 */       return null;
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
/*     */   public final Class<?> classForNameOrNull(String paramString) {
/* 369 */     if (this.reflectionDriver == null) {
/* 370 */       throw new RuntimeException("Cannot use reflection after ScanResult has been closed");
/*     */     }
/*     */     try {
/* 373 */       return this.reflectionDriver.findClass(paramString);
/* 374 */     } catch (Throwable throwable) {
/* 375 */       return null;
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
/*     */   public final Method staticMethodForNameOrNull(String paramString1, String paramString2) {
/* 387 */     if (this.reflectionDriver == null) {
/* 388 */       throw new RuntimeException("Cannot use reflection after ScanResult has been closed");
/*     */     }
/*     */     try {
/* 391 */       return this.reflectionDriver.findStaticMethod(this.reflectionDriver.findClass(paramString1), paramString2, new Class[0]);
/* 392 */     } catch (Throwable throwable) {
/* 393 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private class PrivilegedActionInvocationHandler<T>
/*     */     implements InvocationHandler
/*     */   {
/*     */     private final Callable<T> callable;
/*     */     
/*     */     public PrivilegedActionInvocationHandler(Callable<T> param1Callable) {
/* 403 */       this.callable = param1Callable;
/*     */     }
/*     */ 
/*     */     
/*     */     public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) {
/* 408 */       return this.callable.call();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final <T> T doPrivileged(Callable<T> paramCallable) {
/*     */     Object object;
/* 418 */     if (this.accessControllerDoPrivileged != null) {
/* 419 */       object = Proxy.newProxyInstance(this.privilegedActionClass.getClassLoader(), new Class[] { this.privilegedActionClass }, new PrivilegedActionInvocationHandler<>(paramCallable));
/*     */       
/* 421 */       return (T)this.accessControllerDoPrivileged.invoke(null, new Object[] { object });
/*     */     } 
/*     */     
/* 424 */     return object.call();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\reflection\ReflectionUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */