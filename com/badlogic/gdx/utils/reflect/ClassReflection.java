/*     */ package com.badlogic.gdx.utils.reflect;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ClassReflection
/*     */ {
/*     */   public static Class forName(String paramString) {
/*     */     try {
/*  28 */       return Class.forName(paramString);
/*  29 */     } catch (ClassNotFoundException classNotFoundException) {
/*  30 */       throw new ReflectionException("Class not found: " + paramString, classNotFoundException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getSimpleName(Class paramClass) {
/*  36 */     return paramClass.getSimpleName();
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isInstance(Class paramClass, Object paramObject) {
/*  41 */     return paramClass.isInstance(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isAssignableFrom(Class paramClass1, Class<?> paramClass2) {
/*  47 */     return paramClass1.isAssignableFrom(paramClass2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isMemberClass(Class paramClass) {
/*  52 */     return paramClass.isMemberClass();
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isStaticClass(Class paramClass) {
/*  57 */     return Modifier.isStatic(paramClass.getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isArray(Class paramClass) {
/*  62 */     return paramClass.isArray();
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isPrimitive(Class paramClass) {
/*  67 */     return paramClass.isPrimitive();
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isEnum(Class paramClass) {
/*  72 */     return paramClass.isEnum();
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isAnnotation(Class paramClass) {
/*  77 */     return paramClass.isAnnotation();
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isInterface(Class paramClass) {
/*  82 */     return paramClass.isInterface();
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isAbstract(Class paramClass) {
/*  87 */     return Modifier.isAbstract(paramClass.getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public static <T> T newInstance(Class<T> paramClass) {
/*     */     try {
/*  93 */       return paramClass.newInstance();
/*  94 */     } catch (InstantiationException instantiationException) {
/*  95 */       throw new ReflectionException("Could not instantiate instance of class: " + paramClass.getName(), instantiationException);
/*  96 */     } catch (IllegalAccessException illegalAccessException) {
/*  97 */       throw new ReflectionException("Could not instantiate instance of class: " + paramClass.getName(), illegalAccessException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Class getComponentType(Class paramClass) {
/* 104 */     return paramClass.getComponentType();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Constructor[] getConstructors(Class paramClass) {
/*     */     Constructor[] arrayOfConstructor;
/* 111 */     Constructor[] arrayOfConstructor1 = new Constructor[(arrayOfConstructor = (Constructor[])paramClass.getConstructors()).length]; byte b; int i;
/* 112 */     for (b = 0, i = arrayOfConstructor.length; b < i; b++) {
/* 113 */       arrayOfConstructor1[b] = new Constructor(arrayOfConstructor[b]);
/*     */     }
/* 115 */     return arrayOfConstructor1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Constructor getConstructor(Class paramClass, Class... paramVarArgs) {
/*     */     try {
/* 122 */       return new Constructor(paramClass.getConstructor(paramVarArgs));
/* 123 */     } catch (SecurityException securityException) {
/* 124 */       throw new ReflectionException("Security violation occurred while getting constructor for class: '" + paramClass.getName() + "'.", securityException);
/*     */     }
/* 126 */     catch (NoSuchMethodException noSuchMethodException) {
/* 127 */       throw new ReflectionException("Constructor not found for class: " + paramClass.getName(), noSuchMethodException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Constructor getDeclaredConstructor(Class paramClass, Class... paramVarArgs) {
/*     */     try {
/* 135 */       return new Constructor(paramClass.getDeclaredConstructor(paramVarArgs));
/* 136 */     } catch (SecurityException securityException) {
/* 137 */       throw new ReflectionException("Security violation while getting constructor for class: " + paramClass.getName(), securityException);
/* 138 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 139 */       throw new ReflectionException("Constructor not found for class: " + paramClass.getName(), noSuchMethodException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static Object[] getEnumConstants(Class<Object> paramClass) {
/* 145 */     return paramClass.getEnumConstants();
/*     */   }
/*     */ 
/*     */   
/*     */   public static Method[] getMethods(Class paramClass) {
/*     */     Method[] arrayOfMethod;
/* 151 */     Method[] arrayOfMethod1 = new Method[(arrayOfMethod = paramClass.getMethods()).length]; byte b; int i;
/* 152 */     for (b = 0, i = arrayOfMethod.length; b < i; b++) {
/* 153 */       arrayOfMethod1[b] = new Method(arrayOfMethod[b]);
/*     */     }
/* 155 */     return arrayOfMethod1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Method getMethod(Class paramClass, String paramString, Class... paramVarArgs) {
/*     */     try {
/* 162 */       return new Method(paramClass.getMethod(paramString, paramVarArgs));
/* 163 */     } catch (SecurityException securityException) {
/* 164 */       throw new ReflectionException("Security violation while getting method: " + paramString + ", for class: " + paramClass.getName(), securityException);
/* 165 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 166 */       throw new ReflectionException("Method not found: " + paramString + ", for class: " + paramClass.getName(), noSuchMethodException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static Method[] getDeclaredMethods(Class paramClass) {
/*     */     Method[] arrayOfMethod;
/* 173 */     Method[] arrayOfMethod1 = new Method[(arrayOfMethod = paramClass.getDeclaredMethods()).length]; byte b; int i;
/* 174 */     for (b = 0, i = arrayOfMethod.length; b < i; b++) {
/* 175 */       arrayOfMethod1[b] = new Method(arrayOfMethod[b]);
/*     */     }
/* 177 */     return arrayOfMethod1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Method getDeclaredMethod(Class paramClass, String paramString, Class... paramVarArgs) {
/*     */     try {
/* 184 */       return new Method(paramClass.getDeclaredMethod(paramString, paramVarArgs));
/* 185 */     } catch (SecurityException securityException) {
/* 186 */       throw new ReflectionException("Security violation while getting method: " + paramString + ", for class: " + paramClass.getName(), securityException);
/* 187 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 188 */       throw new ReflectionException("Method not found: " + paramString + ", for class: " + paramClass.getName(), noSuchMethodException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static Field[] getFields(Class paramClass) {
/*     */     Field[] arrayOfField;
/* 195 */     Field[] arrayOfField1 = new Field[(arrayOfField = paramClass.getFields()).length]; byte b; int i;
/* 196 */     for (b = 0, i = arrayOfField.length; b < i; b++) {
/* 197 */       arrayOfField1[b] = new Field(arrayOfField[b]);
/*     */     }
/* 199 */     return arrayOfField1;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Field getField(Class paramClass, String paramString) {
/*     */     try {
/* 205 */       return new Field(paramClass.getField(paramString));
/* 206 */     } catch (SecurityException securityException) {
/* 207 */       throw new ReflectionException("Security violation while getting field: " + paramString + ", for class: " + paramClass.getName(), securityException);
/* 208 */     } catch (NoSuchFieldException noSuchFieldException) {
/* 209 */       throw new ReflectionException("Field not found: " + paramString + ", for class: " + paramClass.getName(), noSuchFieldException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static Field[] getDeclaredFields(Class paramClass) {
/*     */     Field[] arrayOfField;
/* 216 */     Field[] arrayOfField1 = new Field[(arrayOfField = paramClass.getDeclaredFields()).length]; byte b; int i;
/* 217 */     for (b = 0, i = arrayOfField.length; b < i; b++) {
/* 218 */       arrayOfField1[b] = new Field(arrayOfField[b]);
/*     */     }
/* 220 */     return arrayOfField1;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Field getDeclaredField(Class paramClass, String paramString) {
/*     */     try {
/* 226 */       return new Field(paramClass.getDeclaredField(paramString));
/* 227 */     } catch (SecurityException securityException) {
/* 228 */       throw new ReflectionException("Security violation while getting field: " + paramString + ", for class: " + paramClass.getName(), securityException);
/* 229 */     } catch (NoSuchFieldException noSuchFieldException) {
/* 230 */       throw new ReflectionException("Field not found: " + paramString + ", for class: " + paramClass.getName(), noSuchFieldException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isAnnotationPresent(Class paramClass, Class<? extends Annotation> paramClass1) {
/* 236 */     return paramClass.isAnnotationPresent(paramClass1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Annotation[] getAnnotations(Class paramClass) {
/*     */     Annotation[] arrayOfAnnotation;
/* 243 */     Annotation[] arrayOfAnnotation1 = new Annotation[(arrayOfAnnotation = paramClass.getAnnotations()).length];
/* 244 */     for (byte b = 0; b < arrayOfAnnotation.length; b++) {
/* 245 */       arrayOfAnnotation1[b] = new Annotation(arrayOfAnnotation[b]);
/*     */     }
/* 247 */     return arrayOfAnnotation1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Annotation getAnnotation(Class paramClass, Class<? extends Annotation> paramClass1) {
/* 254 */     if ((paramClass = paramClass.getAnnotation(paramClass1)) != null) return new Annotation((Annotation)paramClass); 
/* 255 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Annotation[] getDeclaredAnnotations(Class paramClass) {
/*     */     Annotation[] arrayOfAnnotation;
/* 262 */     Annotation[] arrayOfAnnotation1 = new Annotation[(arrayOfAnnotation = paramClass.getDeclaredAnnotations()).length];
/* 263 */     for (byte b = 0; b < arrayOfAnnotation.length; b++) {
/* 264 */       arrayOfAnnotation1[b] = new Annotation(arrayOfAnnotation[b]);
/*     */     }
/* 266 */     return arrayOfAnnotation1;
/*     */   }
/*     */   
/*     */   public static Annotation getDeclaredAnnotation(Class paramClass, Class<? extends Annotation> paramClass1) {
/*     */     Annotation[] arrayOfAnnotation;
/*     */     int i;
/*     */     byte b;
/* 273 */     for (i = (arrayOfAnnotation = arrayOfAnnotation = paramClass.getDeclaredAnnotations()).length, b = 0; b < i; b++) {
/* 274 */       Annotation annotation; if ((annotation = arrayOfAnnotation[b]).annotationType().equals(paramClass1)) return new Annotation(annotation); 
/*     */     } 
/* 276 */     return null;
/*     */   }
/*     */   
/*     */   public static Class[] getInterfaces(Class paramClass) {
/* 280 */     return paramClass.getInterfaces();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\reflect\ClassReflection.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */