/*     */ package com.google.common.base;
/*     */ 
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.AbstractList;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ElementTypesAreNonnullByDefault
/*     */ public final class Throwables
/*     */ {
/*     */   private static final String JAVA_LANG_ACCESS_CLASSNAME = "sun.misc.JavaLangAccess";
/*     */   static final String SHARED_SECRETS_CLASSNAME = "sun.misc.SharedSecrets";
/*     */   private static final Object jla;
/*     */   
/*     */   public static <X extends Throwable> void throwIfInstanceOf(Throwable paramThrowable, Class<X> paramClass) throws X {
/*  75 */     Preconditions.checkNotNull(paramThrowable);
/*  76 */     if (paramClass.isInstance(paramThrowable)) {
/*  77 */       throw (X)paramClass.cast(paramThrowable);
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
/*     */   @Deprecated
/*     */   public static <X extends Throwable> void propagateIfInstanceOf(Throwable paramThrowable, Class<X> paramClass) throws X {
/* 104 */     if (paramThrowable != null) {
/* 105 */       throwIfInstanceOf(paramThrowable, paramClass);
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
/*     */   public static void throwIfUnchecked(Throwable paramThrowable) {
/* 129 */     Preconditions.checkNotNull(paramThrowable);
/* 130 */     if (paramThrowable instanceof RuntimeException) {
/* 131 */       throw (RuntimeException)paramThrowable;
/*     */     }
/* 133 */     if (paramThrowable instanceof Error) {
/* 134 */       throw (Error)paramThrowable;
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
/*     */   @Deprecated
/*     */   public static void propagateIfPossible(Throwable paramThrowable) {
/* 159 */     if (paramThrowable != null) {
/* 160 */       throwIfUnchecked(paramThrowable);
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
/*     */   public static <X extends Throwable> void propagateIfPossible(Throwable paramThrowable, Class<X> paramClass) throws X {
/* 185 */     propagateIfInstanceOf(paramThrowable, paramClass);
/* 186 */     propagateIfPossible(paramThrowable);
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
/*     */   public static <X1 extends Throwable, X2 extends Throwable> void propagateIfPossible(Throwable paramThrowable, Class<X1> paramClass, Class<X2> paramClass1) throws X1, X2 {
/* 204 */     Preconditions.checkNotNull(paramClass1);
/* 205 */     propagateIfInstanceOf(paramThrowable, paramClass);
/* 206 */     propagateIfPossible(paramThrowable, paramClass1);
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
/*     */   @Deprecated
/*     */   public static RuntimeException propagate(Throwable paramThrowable) {
/* 241 */     throwIfUnchecked(paramThrowable);
/* 242 */     throw new RuntimeException(paramThrowable);
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
/*     */   public static Throwable getRootCause(Throwable paramThrowable) {
/* 258 */     Throwable throwable1 = paramThrowable;
/* 259 */     boolean bool = false;
/*     */     
/*     */     Throwable throwable2;
/* 262 */     while ((throwable2 = paramThrowable.getCause()) != null) {
/*     */ 
/*     */       
/* 265 */       if ((paramThrowable = throwable2) == throwable1) {
/* 266 */         throw new IllegalArgumentException("Loop in causal chain detected.", paramThrowable);
/*     */       }
/* 268 */       if (bool) {
/* 269 */         throwable1 = throwable1.getCause();
/*     */       }
/* 271 */       bool = !bool ? true : false;
/*     */     } 
/* 273 */     return paramThrowable;
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
/*     */   public static List<Throwable> getCausalChain(Throwable paramThrowable) {
/* 293 */     Preconditions.checkNotNull(paramThrowable);
/*     */     ArrayList<Throwable> arrayList;
/* 295 */     (arrayList = new ArrayList<>(4)).add(paramThrowable);
/*     */ 
/*     */ 
/*     */     
/* 299 */     Throwable throwable = paramThrowable;
/* 300 */     boolean bool = false;
/*     */ 
/*     */     
/* 303 */     while ((paramThrowable = paramThrowable.getCause()) != null) {
/* 304 */       paramThrowable = paramThrowable;
/* 305 */       arrayList.add(paramThrowable);
/*     */       
/* 307 */       if (paramThrowable == throwable) {
/* 308 */         throw new IllegalArgumentException("Loop in causal chain detected.", paramThrowable);
/*     */       }
/* 310 */       if (bool) {
/* 311 */         throwable = throwable.getCause();
/*     */       }
/* 313 */       bool = !bool ? true : false;
/*     */     } 
/* 315 */     return Collections.unmodifiableList(arrayList);
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
/*     */   public static <X extends Throwable> X getCauseAs(Throwable paramThrowable, Class<X> paramClass) {
/*     */     try {
/* 336 */       return paramClass.cast(paramThrowable.getCause());
/* 337 */     } catch (ClassCastException classCastException) {
/* 338 */       (paramClass = null).initCause(paramThrowable);
/* 339 */       throw paramClass;
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
/*     */   public static String getStackTraceAsString(Throwable paramThrowable) {
/* 351 */     StringWriter stringWriter = new StringWriter();
/* 352 */     paramThrowable.printStackTrace(new PrintWriter(stringWriter));
/* 353 */     return stringWriter.toString();
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
/*     */   @Deprecated
/*     */   public static List<StackTraceElement> lazyStackTrace(Throwable paramThrowable) {
/* 389 */     if (lazyStackTraceIsLazy())
/* 390 */       return jlaStackTrace(paramThrowable); 
/* 391 */     return Collections.unmodifiableList(Arrays.asList(paramThrowable.getStackTrace()));
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
/*     */   @Deprecated
/*     */   public static boolean lazyStackTraceIsLazy() {
/* 405 */     return (getStackTraceElementMethod != null && getStackTraceDepthMethod != null);
/*     */   }
/*     */ 
/*     */   
/*     */   private static List<StackTraceElement> jlaStackTrace(final Throwable t) {
/* 410 */     Preconditions.checkNotNull(t);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 417 */     return new AbstractList<StackTraceElement>()
/*     */       {
/*     */ 
/*     */ 
/*     */         
/*     */         public StackTraceElement get(int param1Int)
/*     */         {
/* 424 */           return 
/* 425 */             (StackTraceElement)Throwables.invokeAccessibleNonThrowingMethod(
/* 426 */               Objects.<Method>requireNonNull(Throwables.getStackTraceElementMethod), Objects.requireNonNull(Throwables.jla), new Object[] { this.val$t, Integer.valueOf(param1Int) });
/*     */         }
/*     */ 
/*     */         
/*     */         public int size() {
/* 431 */           return (
/* 432 */             (Integer)Throwables.invokeAccessibleNonThrowingMethod(
/* 433 */               Objects.<Method>requireNonNull(Throwables.getStackTraceDepthMethod), Objects.requireNonNull(Throwables.jla), new Object[] { this.val$t })).intValue();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Object invokeAccessibleNonThrowingMethod(Method paramMethod, Object paramObject, Object... paramVarArgs) {
/*     */     try {
/* 442 */       return paramMethod.invoke(paramObject, paramVarArgs);
/* 443 */     } catch (IllegalAccessException illegalAccessException) {
/* 444 */       throw new RuntimeException(illegalAccessException);
/* 445 */     } catch (InvocationTargetException invocationTargetException) {
/* 446 */       throw propagate((paramMethod = null).getCause());
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
/* 470 */   private static final Method getStackTraceElementMethod = ((jla = getJLA()) == null) ? null : getGetMethod();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 478 */   private static final Method getStackTraceDepthMethod = (jla == null) ? null : getSizeMethod(jla);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Object getJLA() {
/*     */     try {
/*     */       Method method;
/*     */       Class<?> clazz;
/* 494 */       return (method = (clazz = Class.forName("sun.misc.SharedSecrets", false, (ClassLoader)null)).getMethod("getJavaLangAccess", new Class[0])).invoke(null, new Object[0]);
/* 495 */     } catch (ThreadDeath threadDeath2) {
/* 496 */       ThreadDeath threadDeath1; throw threadDeath1 = null;
/* 497 */     } catch (Throwable throwable) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 502 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Method getGetMethod() {
/* 513 */     return getJlaMethod("getStackTraceElement", new Class[] { Throwable.class, int.class });
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
/*     */   private static Method getSizeMethod(Object paramObject) {
/*     */     try {
/*     */       Method method;
/* 530 */       if ((method = getJlaMethod("getStackTraceDepth", new Class[] { Throwable.class })) == null) {
/* 531 */         return null;
/*     */       }
/* 533 */       method.invoke(paramObject, new Object[] { new Throwable() });
/* 534 */       return method;
/* 535 */     } catch (UnsupportedOperationException|IllegalAccessException|InvocationTargetException unsupportedOperationException) {
/* 536 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Method getJlaMethod(String paramString, Class<?>... paramVarArgs) {
/*     */     try {
/* 544 */       return Class.forName("sun.misc.JavaLangAccess", false, (ClassLoader)null).getMethod(paramString, paramVarArgs);
/* 545 */     } catch (ThreadDeath threadDeath) {
/* 546 */       throw paramString = null;
/* 547 */     } catch (Throwable throwable) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 552 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Throwables.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */