/*      */ package com.a.a.c.m;
/*      */ import com.a.a.b.h;
/*      */ import com.a.a.c.j;
/*      */ import com.a.a.c.w;
/*      */ import java.io.Closeable;
/*      */ import java.io.IOException;
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.reflect.AccessibleObject;
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.Member;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.EnumMap;
/*      */ import java.util.EnumSet;
/*      */ import java.util.Iterator;
/*      */ 
/*      */ public final class i {
/*   20 */   private static final Class<?> a = Object.class;
/*      */   
/*   22 */   private static final Annotation[] b = new Annotation[0];
/*   23 */   private static final a[] c = new a[0];
/*      */   
/*   25 */   private static final Iterator<?> d = Collections.emptyIterator();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> Iterator<T> a() {
/*   38 */     return (Iterator)d;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<Class<?>> a(Class<?> paramClass1, Class<?> paramClass2, boolean paramBoolean) {
/*   75 */     if (paramClass1 == null || paramClass1 == paramClass2 || paramClass1 == Object.class) {
/*   76 */       return Collections.emptyList();
/*      */     }
/*   78 */     ArrayList<Class<?>> arrayList = new ArrayList(8);
/*   79 */     a(paramClass1, paramClass2, arrayList, true);
/*   80 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<Class<?>> b(Class<?> paramClass1, Class<?> paramClass2, boolean paramBoolean) {
/*   95 */     ArrayList<Class<?>> arrayList = new ArrayList(8);
/*   96 */     if (paramClass1 != null && paramClass1 != paramClass2) {
/*   97 */       if (paramBoolean) {
/*   98 */         arrayList.add(paramClass1);
/*      */       }
/*  100 */       while ((paramClass1 = paramClass1.getSuperclass()) != null && 
/*  101 */         paramClass1 != paramClass2)
/*      */       {
/*      */         
/*  104 */         arrayList.add(paramClass1);
/*      */       }
/*      */     } 
/*  107 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void a(Class<?> paramClass1, Class<?> paramClass2, Collection<Class<?>> paramCollection, boolean paramBoolean) {
/*  142 */     if (paramClass1 == paramClass2 || paramClass1 == null || paramClass1 == Object.class)
/*  143 */       return;  if (paramBoolean) {
/*  144 */       if (paramCollection.contains(paramClass1)) {
/*      */         return;
/*      */       }
/*  147 */       paramCollection.add(paramClass1);
/*      */     }  Class[] arrayOfClass; int j; byte b;
/*  149 */     for (j = (arrayOfClass = x(paramClass1)).length, b = 0; b < j; b++) {
/*  150 */       Class<?> clazz; a(clazz = arrayOfClass[b], paramClass2, paramCollection, true);
/*      */     } 
/*  152 */     a(paramClass1.getSuperclass(), paramClass2, paramCollection, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String a(Class<?> paramClass) {
/*  168 */     if (paramClass.isAnnotation()) {
/*  169 */       return "annotation";
/*      */     }
/*  171 */     if (paramClass.isArray()) {
/*  172 */       return "array";
/*      */     }
/*  174 */     if (Enum.class.isAssignableFrom(paramClass)) {
/*  175 */       return "enum";
/*      */     }
/*  177 */     if (paramClass.isPrimitive()) {
/*  178 */       return "primitive";
/*      */     }
/*      */ 
/*      */     
/*  182 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String a(Class<?> paramClass, boolean paramBoolean) {
/*      */     
/*  197 */     try { if (!(paramBoolean = Modifier.isStatic(paramClass.getModifiers())) && v(paramClass)) {
/*  198 */         return "local/anonymous";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */        }
/*      */     
/*  210 */     catch (SecurityException securityException) {  }
/*  211 */     catch (NullPointerException nullPointerException) {}
/*  212 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Class<?> b(Class<?> paramClass) {
/*  221 */     if (!Modifier.isStatic(paramClass.getModifiers())) {
/*      */       
/*      */       try {
/*  224 */         if (v(paramClass)) {
/*  225 */           return null;
/*      */         }
/*  227 */         return w(paramClass);
/*  228 */       } catch (SecurityException securityException) {}
/*      */     }
/*  230 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean c(Class<?> paramClass) {
/*      */     String str;
/*  249 */     if ((str = paramClass.getName()).startsWith("net.sf.cglib.proxy.") || str
/*  250 */       .startsWith("org.hibernate.proxy.")) {
/*  251 */       return true;
/*      */     }
/*      */     
/*  254 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean d(Class<?> paramClass) {
/*      */     int j;
/*  264 */     return (((j = paramClass.getModifiers()) & 0x600) == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean e(Class<?> paramClass) {
/*  282 */     return (paramClass == Void.class || paramClass == void.class || paramClass == j.class);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean f(Class<?> paramClass) {
/*  293 */     if ((paramClass = paramClass.getSuperclass()) != null && "java.lang.Record".equals(paramClass.getName())) return true;  return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean t(Class<?> paramClass) {
/*  300 */     return (paramClass == a || paramClass.isPrimitive());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean a(Object paramObject, Class<?> paramClass) {
/*  309 */     return (paramObject != null && paramObject.getClass() == paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(Class<?> paramClass, Object paramObject, String paramString) {
/*  318 */     if (paramObject.getClass() != paramClass) {
/*  319 */       throw new IllegalStateException(String.format("Sub-class %s (of class %s) must override method '%s'", new Object[] { paramObject
/*      */               
/*  321 */               .getClass().getName(), paramClass.getName(), paramString }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Throwable a(Throwable paramThrowable) {
/*  367 */     if (paramThrowable instanceof Error) {
/*  368 */       throw (Error)paramThrowable;
/*      */     }
/*  370 */     return paramThrowable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Throwable b(Throwable paramThrowable) {
/*  380 */     if (paramThrowable instanceof RuntimeException) {
/*  381 */       throw (RuntimeException)paramThrowable;
/*      */     }
/*  383 */     return paramThrowable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Throwable c(Throwable paramThrowable) {
/*  393 */     if (paramThrowable instanceof IOException) {
/*  394 */       throw (IOException)paramThrowable;
/*      */     }
/*  396 */     return paramThrowable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Throwable d(Throwable paramThrowable) {
/*  411 */     while (paramThrowable.getCause() != null) {
/*  412 */       paramThrowable = paramThrowable.getCause();
/*      */     }
/*  414 */     return paramThrowable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Throwable e(Throwable paramThrowable) {
/*  425 */     return c(d(paramThrowable));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void h(Throwable paramThrowable) {
/*  433 */     b(paramThrowable, paramThrowable.getMessage());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void b(Throwable paramThrowable, String paramString) {
/*  443 */     b(paramThrowable);
/*  444 */     a(paramThrowable);
/*  445 */     throw new IllegalArgumentException(paramString, paramThrowable);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T a(g paramg, IOException paramIOException) {
/*  453 */     if (paramIOException instanceof l) {
/*  454 */       throw (l)paramIOException;
/*      */     }
/*  456 */     throw l.a(paramg, paramIOException.getMessage())
/*  457 */       .a(paramIOException);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void f(Throwable paramThrowable) {
/*  467 */     h(d(paramThrowable));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(Throwable paramThrowable, String paramString) {
/*  477 */     b(d(paramThrowable), paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(h paramh, Exception paramException) {
/*  494 */     paramh.a(h.a.b);
/*      */     try {
/*  496 */       paramh.close();
/*  497 */     } catch (Exception exception) {
/*  498 */       paramException.addSuppressed(exception);
/*      */     } 
/*  500 */     c(paramException);
/*  501 */     b(paramException);
/*  502 */     throw new RuntimeException(paramException);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(h paramh, Closeable paramCloseable, Exception paramException) {
/*  518 */     if (paramh != null) {
/*  519 */       paramh.a(h.a.b);
/*      */       try {
/*  521 */         paramh.close();
/*  522 */       } catch (Exception exception) {
/*  523 */         paramException.addSuppressed(exception);
/*      */       } 
/*      */     } 
/*  526 */     if (paramCloseable != null) {
/*      */       try {
/*  528 */         paramCloseable.close();
/*  529 */       } catch (Exception exception) {
/*  530 */         paramException.addSuppressed(exception);
/*      */       } 
/*      */     }
/*  533 */     c(paramException);
/*  534 */     b(paramException);
/*  535 */     throw new RuntimeException(paramException);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T b(Class<T> paramClass, boolean paramBoolean) {
/*      */     Constructor<T> constructor;
/*  561 */     if ((constructor = c(paramClass, paramBoolean)) == null) {
/*  562 */       throw new IllegalArgumentException("Class " + paramClass.getName() + " has no default (no arg) constructor");
/*      */     }
/*      */     try {
/*  565 */       return constructor.newInstance(new Object[0]);
/*  566 */     } catch (Exception exception) {
/*  567 */       a((Throwable)(constructor = null), "Failed to instantiate class " + paramClass.getName() + ", problem: " + constructor.getMessage());
/*  568 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> Constructor<T> c(Class<T> paramClass, boolean paramBoolean) {
/*      */     try {
/*  576 */       Constructor<T> constructor = paramClass.getDeclaredConstructor(new Class[0]);
/*  577 */       if (paramBoolean) {
/*  578 */         a(constructor, paramBoolean);
/*      */       
/*      */       }
/*  581 */       else if (!Modifier.isPublic(constructor.getModifiers())) {
/*  582 */         throw new IllegalArgumentException("Default constructor for " + paramClass.getName() + " is not accessible (non-public?): not allowed to try modify access via Reflection: cannot instantiate type");
/*      */       } 
/*      */       
/*  585 */       return constructor;
/*  586 */     } catch (NoSuchMethodException noSuchMethodException) {
/*      */     
/*  588 */     } catch (Exception exception2) {
/*  589 */       Exception exception1; a(exception1 = null, "Failed to find default constructor of class " + paramClass.getName() + ", problem: " + exception1.getMessage());
/*      */     } 
/*  591 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Class<?> a(Object paramObject) {
/*  604 */     if (paramObject == null) {
/*  605 */       return null;
/*      */     }
/*  607 */     return paramObject.getClass();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Class<?> a(j paramj) {
/*  614 */     if (paramj == null) {
/*  615 */       return null;
/*      */     }
/*  617 */     return paramj.b();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T a(T paramT1, T paramT2) {
/*  624 */     return (paramT1 == null) ? paramT2 : paramT1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String b(Object paramObject) {
/*  631 */     if (paramObject == null) {
/*  632 */       return null;
/*      */     }
/*  634 */     return paramObject.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String a(String paramString) {
/*  641 */     if (paramString == null) {
/*  642 */       return "";
/*      */     }
/*  644 */     return paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String a(Object paramObject, String paramString) {
/*  654 */     if (paramObject == null) {
/*  655 */       return paramString;
/*      */     }
/*  657 */     return String.format("\"%s\"", new Object[] { paramObject });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String c(Object paramObject) {
/*  673 */     if (paramObject == null) {
/*  674 */       return "unknown";
/*      */     }
/*      */ 
/*      */     
/*  678 */     return g((Class<?>)(paramObject = (paramObject instanceof Class) ? (Class)paramObject : paramObject.getClass()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String b(j paramj) {
/*  694 */     if (paramj == null) {
/*  695 */       return "[null]";
/*      */     }
/*      */     StringBuilder stringBuilder;
/*  698 */     (stringBuilder = (new StringBuilder(80)).append('`')).append(paramj.G());
/*  699 */     return stringBuilder.append('`').toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String d(Object paramObject) {
/*  710 */     if (paramObject == null) {
/*  711 */       return "[null]";
/*      */     }
/*      */     
/*  714 */     return g((Class<?>)(paramObject = (paramObject instanceof Class) ? (Class)paramObject : paramObject.getClass()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String g(Class<?> paramClass) {
/*  724 */     if (paramClass == null) {
/*  725 */       return "[null]";
/*      */     }
/*  727 */     byte b = 0;
/*  728 */     while (paramClass.isArray()) {
/*  729 */       b++;
/*  730 */       paramClass = paramClass.getComponentType();
/*      */     } 
/*  732 */     String str = paramClass.isPrimitive() ? paramClass.getSimpleName() : paramClass.getName();
/*  733 */     if (b > 0) {
/*  734 */       StringBuilder stringBuilder = new StringBuilder(str);
/*      */       while (true) {
/*  736 */         stringBuilder.append("[]");
/*  737 */         if (--b <= 0)
/*  738 */         { str = stringBuilder.toString(); break; } 
/*      */       } 
/*  740 */     }  return c(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String a(v paramv) {
/*  753 */     if (paramv == null) {
/*  754 */       return "[null]";
/*      */     }
/*  756 */     return d(paramv.a());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String b(String paramString) {
/*  766 */     if (paramString == null) {
/*  767 */       return "[null]";
/*      */     }
/*  769 */     return d(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String a(w paramw) {
/*  779 */     if (paramw == null) {
/*  780 */       return "[null]";
/*      */     }
/*      */     
/*  783 */     return d(paramw.b());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String c(String paramString) {
/*  798 */     if (paramString == null) {
/*  799 */       return "[null]";
/*      */     }
/*  801 */     return (new StringBuilder(paramString.length() + 2)).append('`').append(paramString).append('`').toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String d(String paramString) {
/*  810 */     if (paramString == null) {
/*  811 */       return "[null]";
/*      */     }
/*  813 */     return (new StringBuilder(paramString.length() + 2)).append('\'').append(paramString).append('\'').toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String g(Throwable paramThrowable) {
/*  827 */     if (paramThrowable instanceof d) {
/*  828 */       return ((d)paramThrowable).b();
/*      */     }
/*  830 */     if (paramThrowable instanceof java.lang.reflect.InvocationTargetException && paramThrowable.getCause() != null) {
/*  831 */       return paramThrowable.getCause().getMessage();
/*      */     }
/*  833 */     return paramThrowable.getMessage();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object h(Class<?> paramClass) {
/*  848 */     if (paramClass == int.class) {
/*  849 */       return Integer.valueOf(0);
/*      */     }
/*  851 */     if (paramClass == long.class) {
/*  852 */       return Long.valueOf(0L);
/*      */     }
/*  854 */     if (paramClass == boolean.class) {
/*  855 */       return Boolean.FALSE;
/*      */     }
/*  857 */     if (paramClass == double.class) {
/*  858 */       return Double.valueOf(0.0D);
/*      */     }
/*  860 */     if (paramClass == float.class) {
/*  861 */       return Float.valueOf(0.0F);
/*      */     }
/*  863 */     if (paramClass == byte.class) {
/*  864 */       return Byte.valueOf((byte)0);
/*      */     }
/*  866 */     if (paramClass == short.class) {
/*  867 */       return Short.valueOf((short)0);
/*      */     }
/*  869 */     if (paramClass == char.class) {
/*  870 */       return Character.valueOf(false);
/*      */     }
/*  872 */     throw new IllegalArgumentException("Class " + paramClass.getName() + " is not a primitive type");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Class<?> i(Class<?> paramClass) {
/*  883 */     if (paramClass == int.class) {
/*  884 */       return Integer.class;
/*      */     }
/*  886 */     if (paramClass == long.class) {
/*  887 */       return Long.class;
/*      */     }
/*  889 */     if (paramClass == boolean.class) {
/*  890 */       return Boolean.class;
/*      */     }
/*  892 */     if (paramClass == double.class) {
/*  893 */       return Double.class;
/*      */     }
/*  895 */     if (paramClass == float.class) {
/*  896 */       return Float.class;
/*      */     }
/*  898 */     if (paramClass == byte.class) {
/*  899 */       return Byte.class;
/*      */     }
/*  901 */     if (paramClass == short.class) {
/*  902 */       return Short.class;
/*      */     }
/*  904 */     if (paramClass == char.class) {
/*  905 */       return Character.class;
/*      */     }
/*  907 */     throw new IllegalArgumentException("Class " + paramClass.getName() + " is not a primitive type");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Class<?> j(Class<?> paramClass) {
/*  918 */     if (paramClass.isPrimitive()) {
/*  919 */       return paramClass;
/*      */     }
/*      */     
/*  922 */     if (paramClass == Integer.class) {
/*  923 */       return int.class;
/*      */     }
/*  925 */     if (paramClass == Long.class) {
/*  926 */       return long.class;
/*      */     }
/*  928 */     if (paramClass == Boolean.class) {
/*  929 */       return boolean.class;
/*      */     }
/*  931 */     if (paramClass == Double.class) {
/*  932 */       return double.class;
/*      */     }
/*  934 */     if (paramClass == Float.class) {
/*  935 */       return float.class;
/*      */     }
/*  937 */     if (paramClass == Byte.class) {
/*  938 */       return byte.class;
/*      */     }
/*  940 */     if (paramClass == Short.class) {
/*  941 */       return short.class;
/*      */     }
/*  943 */     if (paramClass == Character.class) {
/*  944 */       return char.class;
/*      */     }
/*  946 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(Member paramMember, boolean paramBoolean) {
/*  983 */     AccessibleObject accessibleObject = (AccessibleObject)paramMember;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/*  991 */       Class<?> clazz = paramMember.getDeclaringClass();
/*      */       
/*      */       boolean bool;
/*  994 */       if (!(bool = (Modifier.isPublic(paramMember.getModifiers()) && Modifier.isPublic(clazz.getModifiers())) ? true : false) || (paramBoolean && !m(clazz)))
/*  995 */         accessibleObject.setAccessible(true); 
/*      */       return;
/*  997 */     } catch (SecurityException securityException) {
/*      */ 
/*      */       
/* 1000 */       if (!accessibleObject.isAccessible()) {
/* 1001 */         Class<?> clazz = paramMember.getDeclaringClass();
/* 1002 */         throw new IllegalArgumentException("Cannot access " + paramMember + " (from class " + clazz.getName() + "; failed to set access: " + securityException.getMessage());
/*      */       } 
/*      */       
/*      */       return;
/* 1006 */     } catch (RuntimeException runtimeException) {
/* 1007 */       if ("InaccessibleObjectException".equals(runtimeException.getClass().getSimpleName())) {
/* 1008 */         throw new IllegalArgumentException(String.format("Failed to call `setAccess()` on %s '%s' (of class %s) due to `%s`, problem: %s", new Object[] { paramMember
/*      */                 
/* 1010 */                 .getClass().getSimpleName(), paramMember.getName(), 
/* 1011 */                 g(paramMember.getDeclaringClass()), runtimeException
/* 1012 */                 .getClass().getName(), runtimeException.getMessage() }), runtimeException);
/*      */       }
/*      */       
/* 1015 */       throw runtimeException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean k(Class<?> paramClass) {
/* 1032 */     return Enum.class.isAssignableFrom(paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Class<? extends Enum<?>> a(EnumSet<?> paramEnumSet) {
/* 1044 */     if (!paramEnumSet.isEmpty()) {
/* 1045 */       return a(paramEnumSet.iterator().next());
/*      */     }
/*      */     
/* 1048 */     return b.a.a(paramEnumSet);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Class<? extends Enum<?>> a(EnumMap<?, ?> paramEnumMap) {
/* 1059 */     if (!paramEnumMap.isEmpty()) {
/* 1060 */       return a(paramEnumMap.keySet().iterator().next());
/*      */     }
/*      */     
/* 1063 */     return b.a.a(paramEnumMap);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Class<? extends Enum<?>> a(Enum<?> paramEnum) {
/* 1075 */     return (Class)paramEnum.getDeclaringClass();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Class<? extends Enum<?>> l(Class<?> paramClass) {
/* 1088 */     if (paramClass.getSuperclass() != Enum.class) {
/* 1089 */       paramClass = paramClass.getSuperclass();
/*      */     }
/* 1091 */     return (Class)paramClass;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends Annotation> Enum<?> a(Class<Enum<?>> paramClass, Class<T> paramClass1) {
/*      */     Field[] arrayOfField;
/*      */     int j;
/*      */     byte b;
/* 1108 */     for (j = (arrayOfField = arrayOfField = paramClass.getDeclaredFields()).length, b = 0; b < j; ) {
/* 1109 */       Field field; Enum[] arrayOfEnum; if ((field = arrayOfField[b]).isEnumConstant() && (
/*      */         
/* 1111 */         arrayOfEnum = field.<Annotation>getAnnotation((Class)paramClass1)) != null) {
/* 1112 */         String str = field.getName(); int k; byte b1;
/* 1113 */         for (k = (arrayOfEnum = (Enum[])paramClass.getEnumConstants()).length, b1 = 0; b1 < k; ) { Enum<?> enum_ = arrayOfEnum[b1];
/* 1114 */           if (str.equals(enum_.name()))
/* 1115 */             return enum_; 
/*      */           b1++; }
/*      */       
/*      */       } 
/*      */       b++;
/*      */     } 
/* 1121 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean e(Object paramObject) {
/* 1141 */     return (paramObject == null || u(paramObject.getClass()));
/*      */   }
/*      */   
/*      */   private static boolean u(Class<?> paramClass) {
/* 1145 */     return (paramClass.getAnnotation(com.a.a.c.a.a.class) != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean m(Class<?> paramClass) {
/*      */     String str;
/* 1163 */     if ((str = paramClass.getName()).startsWith("java.") || str.startsWith("javax.")) return true;  return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean n(Class<?> paramClass) {
/* 1176 */     if (!Modifier.isStatic(paramClass.getModifiers()) && 
/* 1177 */       w(paramClass) != null) return true;
/*      */     
/*      */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean v(Class<?> paramClass) {
/* 1195 */     return (!t(paramClass) && paramClass.getEnclosingMethod() != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Annotation[] o(Class<?> paramClass) {
/* 1218 */     if (t(paramClass)) {
/* 1219 */       return b;
/*      */     }
/* 1221 */     return paramClass.getDeclaredAnnotations();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Method[] p(Class<?> paramClass) {
/*      */     try {
/* 1234 */       return paramClass.getDeclaredMethods();
/* 1235 */     } catch (NoClassDefFoundError noClassDefFoundError) {
/*      */       ClassLoader classLoader;
/*      */ 
/*      */       
/* 1239 */       if ((classLoader = Thread.currentThread().getContextClassLoader()) == null)
/*      */       {
/* 1241 */         return a(paramClass, noClassDefFoundError);
/*      */       }
/*      */       
/*      */       try {
/* 1245 */         Class<?> clazz = classLoader.loadClass(paramClass.getName());
/* 1246 */       } catch (ClassNotFoundException classNotFoundException) {
/* 1247 */         noClassDefFoundError.addSuppressed(classNotFoundException);
/* 1248 */         return a(paramClass, noClassDefFoundError);
/*      */       } 
/*      */       try {
/* 1251 */         return classNotFoundException.getDeclaredMethods();
/* 1252 */       } catch (Throwable throwable) {
/* 1253 */         return a(paramClass, throwable);
/*      */       } 
/* 1255 */     } catch (Throwable throwable) {
/* 1256 */       return a(paramClass, throwable);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Method[] a(Class<?> paramClass, Throwable paramThrowable) {
/* 1264 */     throw new IllegalArgumentException(String.format("Failed on call to `getDeclaredMethods()` on class `%s`, problem: (%s) %s", new Object[] { paramClass
/*      */             
/* 1266 */             .getName(), paramThrowable.getClass().getName(), paramThrowable.getMessage() }), paramThrowable);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static a[] q(Class<?> paramClass) {
/* 1276 */     if (paramClass.isInterface() || t(paramClass)) {
/* 1277 */       return c;
/*      */     }
/*      */     Constructor[] arrayOfConstructor;
/*      */     int j;
/* 1281 */     a[] arrayOfA = new a[j = (arrayOfConstructor = (Constructor[])paramClass.getDeclaredConstructors()).length];
/* 1282 */     for (byte b = 0; b < j; b++) {
/* 1283 */       arrayOfA[b] = new a(arrayOfConstructor[b]);
/*      */     }
/* 1285 */     return arrayOfA;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Type r(Class<?> paramClass) {
/* 1302 */     return paramClass.getGenericSuperclass();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Type[] s(Class<?> paramClass) {
/* 1309 */     return paramClass.getGenericInterfaces();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Class<?> w(Class<?> paramClass) {
/* 1317 */     return t(paramClass) ? null : paramClass.getEnclosingClass();
/*      */   }
/*      */   
/*      */   private static Class<?>[] x(Class<?> paramClass) {
/* 1321 */     return paramClass.getInterfaces();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class b
/*      */   {
/* 1336 */     static final b a = new b();
/*      */     
/*      */     private final Field b;
/*      */     
/*      */     private final Field c;
/*      */     
/*      */     private final String d;
/*      */     
/*      */     private final String e;
/*      */ 
/*      */     
/*      */     private b() {
/* 1348 */       Field field = null;
/* 1349 */       Exception exception = null;
/*      */       
/*      */       try {
/* 1352 */         field = a(EnumSet.class, "elementType", Class.class);
/* 1353 */       } catch (Exception exception1) {
/* 1354 */         str = (exception = null).toString();
/*      */       } 
/* 1356 */       this.b = field;
/* 1357 */       this.d = str;
/*      */       
/* 1359 */       field = null;
/* 1360 */       String str = null;
/*      */       try {
/* 1362 */         field = a(EnumMap.class, "keyType", Class.class);
/* 1363 */       } catch (Exception exception1) {
/* 1364 */         str = (str = null).toString();
/*      */       } 
/* 1366 */       this.c = field;
/* 1367 */       this.e = str;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final Class<? extends Enum<?>> a(EnumSet<?> param1EnumSet) {
/* 1373 */       if (this.b != null) {
/* 1374 */         return (Class<? extends Enum<?>>)a(param1EnumSet, this.b);
/*      */       }
/* 1376 */       throw new IllegalStateException("Cannot figure out type parameter for `EnumSet` (odd JDK platform?), problem: " + this.d);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final Class<? extends Enum<?>> a(EnumMap<?, ?> param1EnumMap) {
/* 1383 */       if (this.c != null) {
/* 1384 */         return (Class<? extends Enum<?>>)a(param1EnumMap, this.c);
/*      */       }
/* 1386 */       throw new IllegalStateException("Cannot figure out type parameter for `EnumMap` (odd JDK platform?), problem: " + this.e);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private static Object a(Object param1Object, Field param1Field) {
/*      */       try {
/* 1393 */         return param1Field.get(param1Object);
/* 1394 */       } catch (Exception exception) {
/* 1395 */         throw new IllegalArgumentException(exception);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     private static Field a(Class<?> param1Class1, String param1String, Class<?> param1Class2) {
/*      */       Field[] arrayOfField;
/*      */       int i;
/*      */       byte b1;
/* 1404 */       for (i = (arrayOfField = arrayOfField = param1Class1.getDeclaredFields()).length, b1 = 0; b1 < i; ) { Field field = arrayOfField[b1];
/* 1405 */         if (param1String.equals(field.getName()) && field.getType() == param1Class2) {
/*      */ 
/*      */           
/* 1408 */           field.setAccessible(true);
/* 1409 */           return field;
/*      */         }  b1++; }
/*      */       
/* 1412 */       throw new IllegalStateException(String.format("No field named '%s' in class '%s'", new Object[] { param1String, param1Class1
/* 1413 */               .getName() }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class a
/*      */   {
/*      */     private Constructor<?> a;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private transient Annotation[] b;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private transient Annotation[][] c;
/*      */ 
/*      */ 
/*      */     
/* 1437 */     private int d = -1;
/*      */     
/*      */     public a(Constructor<?> param1Constructor) {
/* 1440 */       this.a = param1Constructor;
/*      */     }
/*      */     
/*      */     public final Constructor<?> a() {
/* 1444 */       return this.a;
/*      */     }
/*      */     
/*      */     public final int b() {
/*      */       int i;
/* 1449 */       if ((i = this.d) < 0) {
/* 1450 */         i = this.a.getParameterCount();
/* 1451 */         this.d = i;
/*      */       } 
/* 1453 */       return i;
/*      */     }
/*      */     
/*      */     public final Class<?> c() {
/* 1457 */       return this.a.getDeclaringClass();
/*      */     }
/*      */     
/*      */     public final Annotation[] d() {
/*      */       Annotation[] arrayOfAnnotation;
/* 1462 */       if ((arrayOfAnnotation = this.b) == null) {
/* 1463 */         arrayOfAnnotation = this.a.getDeclaredAnnotations();
/* 1464 */         this.b = arrayOfAnnotation;
/*      */       } 
/* 1466 */       return arrayOfAnnotation;
/*      */     }
/*      */     
/*      */     public final Annotation[][] e() {
/*      */       Annotation[][] arrayOfAnnotation;
/* 1471 */       if ((arrayOfAnnotation = this.c) == null) {
/* 1472 */         arrayOfAnnotation = this.a.getParameterAnnotations();
/* 1473 */         this.c = arrayOfAnnotation;
/*      */       } 
/* 1475 */       return arrayOfAnnotation;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */