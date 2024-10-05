/*     */ package com.badlogic.gdx.utils.reflect;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.InvocationTargetException;
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
/*     */ 
/*     */ public final class Method
/*     */ {
/*     */   private final Method method;
/*     */   
/*     */   Method(Method paramMethod) {
/*  29 */     this.method = paramMethod;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getName() {
/*  34 */     return this.method.getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public final Class getReturnType() {
/*  39 */     return this.method.getReturnType();
/*     */   }
/*     */ 
/*     */   
/*     */   public final Class[] getParameterTypes() {
/*  44 */     return this.method.getParameterTypes();
/*     */   }
/*     */ 
/*     */   
/*     */   public final Class getDeclaringClass() {
/*  49 */     return this.method.getDeclaringClass();
/*     */   }
/*     */   
/*     */   public final boolean isAccessible() {
/*  53 */     return this.method.isAccessible();
/*     */   }
/*     */   
/*     */   public final void setAccessible(boolean paramBoolean) {
/*  57 */     this.method.setAccessible(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isAbstract() {
/*  62 */     return Modifier.isAbstract(this.method.getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isDefaultAccess() {
/*  67 */     return (!isPrivate() && !isProtected() && !isPublic());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isFinal() {
/*  72 */     return Modifier.isFinal(this.method.getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isPrivate() {
/*  77 */     return Modifier.isPrivate(this.method.getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isProtected() {
/*  82 */     return Modifier.isProtected(this.method.getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isPublic() {
/*  87 */     return Modifier.isPublic(this.method.getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isNative() {
/*  92 */     return Modifier.isNative(this.method.getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isStatic() {
/*  97 */     return Modifier.isStatic(this.method.getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isVarArgs() {
/* 102 */     return this.method.isVarArgs();
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object invoke(Object paramObject, Object... paramVarArgs) {
/*     */     try {
/* 108 */       return this.method.invoke(paramObject, paramVarArgs);
/* 109 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 110 */       throw new ReflectionException("Illegal argument(s) supplied to method: " + getName(), illegalArgumentException);
/* 111 */     } catch (IllegalAccessException illegalAccessException) {
/* 112 */       throw new ReflectionException("Illegal access to method: " + getName(), illegalAccessException);
/* 113 */     } catch (InvocationTargetException invocationTargetException) {
/* 114 */       throw new ReflectionException("Exception occurred in method: " + getName(), invocationTargetException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isAnnotationPresent(Class<? extends Annotation> paramClass) {
/* 120 */     return this.method.isAnnotationPresent(paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Annotation[] getDeclaredAnnotations() {
/*     */     Annotation[] arrayOfAnnotation;
/* 127 */     Annotation[] arrayOfAnnotation1 = new Annotation[(arrayOfAnnotation = this.method.getDeclaredAnnotations()).length];
/* 128 */     for (byte b = 0; b < arrayOfAnnotation.length; b++) {
/* 129 */       arrayOfAnnotation1[b] = new Annotation(arrayOfAnnotation[b]);
/*     */     }
/* 131 */     return arrayOfAnnotation1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Annotation getDeclaredAnnotation(Class<? extends Annotation> paramClass) {
/*     */     Annotation[] arrayOfAnnotation;
/* 138 */     if ((arrayOfAnnotation = this.method.getDeclaredAnnotations()) == null)
/* 139 */       return null;  int i;
/*     */     byte b;
/* 141 */     for (i = (arrayOfAnnotation = arrayOfAnnotation).length, b = 0; b < i; b++) {
/* 142 */       Annotation annotation; if ((annotation = arrayOfAnnotation[b]).annotationType().equals(paramClass)) {
/* 143 */         return new Annotation(annotation);
/*     */       }
/*     */     } 
/* 146 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\reflect\Method.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */