/*     */ package com.badlogic.gdx.utils.reflect;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.GenericArrayType;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Field
/*     */ {
/*     */   private final Field field;
/*     */   
/*     */   Field(Field paramField) {
/*  31 */     this.field = paramField;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getName() {
/*  36 */     return this.field.getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public final Class getType() {
/*  41 */     return this.field.getType();
/*     */   }
/*     */ 
/*     */   
/*     */   public final Class getDeclaringClass() {
/*  46 */     return this.field.getDeclaringClass();
/*     */   }
/*     */   
/*     */   public final boolean isAccessible() {
/*  50 */     return this.field.isAccessible();
/*     */   }
/*     */   
/*     */   public final void setAccessible(boolean paramBoolean) {
/*  54 */     this.field.setAccessible(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isDefaultAccess() {
/*  59 */     return (!isPrivate() && !isProtected() && !isPublic());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isFinal() {
/*  64 */     return Modifier.isFinal(this.field.getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isPrivate() {
/*  69 */     return Modifier.isPrivate(this.field.getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isProtected() {
/*  74 */     return Modifier.isProtected(this.field.getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isPublic() {
/*  79 */     return Modifier.isPublic(this.field.getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isStatic() {
/*  84 */     return Modifier.isStatic(this.field.getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isTransient() {
/*  89 */     return Modifier.isTransient(this.field.getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isVolatile() {
/*  94 */     return Modifier.isVolatile(this.field.getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isSynthetic() {
/*  99 */     return this.field.isSynthetic();
/*     */   }
/*     */ 
/*     */   
/*     */   public final Class getElementType(int paramInt) {
/*     */     Type type;
/*     */     Type[] arrayOfType;
/* 106 */     if (type = this.field.getGenericType() instanceof ParameterizedType && (
/*     */       
/* 108 */       arrayOfType = ((ParameterizedType)type).getActualTypeArguments()).length - 1 >= paramInt) {
/*     */       Type type1;
/* 110 */       if (type1 = arrayOfType[paramInt] instanceof Class)
/* 111 */         return (Class)type1; 
/* 112 */       if (type1 instanceof ParameterizedType)
/* 113 */         return (Class)((ParameterizedType)type1).getRawType(); 
/* 114 */       if (type1 instanceof GenericArrayType && 
/*     */         
/* 116 */         type1 = ((GenericArrayType)type1).getGenericComponentType() instanceof Class) return ArrayReflection.newInstance((Class)type1, 0).getClass();
/*     */     
/*     */     } 
/*     */     
/* 120 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isAnnotationPresent(Class<? extends Annotation> paramClass) {
/* 125 */     return this.field.isAnnotationPresent(paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Annotation[] getDeclaredAnnotations() {
/*     */     Annotation[] arrayOfAnnotation;
/* 132 */     Annotation[] arrayOfAnnotation1 = new Annotation[(arrayOfAnnotation = this.field.getDeclaredAnnotations()).length];
/* 133 */     for (byte b = 0; b < arrayOfAnnotation.length; b++) {
/* 134 */       arrayOfAnnotation1[b] = new Annotation(arrayOfAnnotation[b]);
/*     */     }
/* 136 */     return arrayOfAnnotation1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Annotation getDeclaredAnnotation(Class<? extends Annotation> paramClass) {
/*     */     Annotation[] arrayOfAnnotation;
/* 143 */     if ((arrayOfAnnotation = this.field.getDeclaredAnnotations()) == null)
/* 144 */       return null;  int i;
/*     */     byte b;
/* 146 */     for (i = (arrayOfAnnotation = arrayOfAnnotation).length, b = 0; b < i; b++) {
/* 147 */       Annotation annotation; if ((annotation = arrayOfAnnotation[b]).annotationType().equals(paramClass)) {
/* 148 */         return new Annotation(annotation);
/*     */       }
/*     */     } 
/* 151 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object get(Object paramObject) {
/*     */     try {
/* 157 */       return this.field.get(paramObject);
/* 158 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 159 */       throw new ReflectionException("Object is not an instance of " + getDeclaringClass(), illegalArgumentException);
/* 160 */     } catch (IllegalAccessException illegalAccessException) {
/* 161 */       throw new ReflectionException("Illegal access to field: " + getName(), illegalAccessException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void set(Object paramObject1, Object paramObject2) {
/*     */     try {
/* 168 */       this.field.set(paramObject1, paramObject2); return;
/* 169 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 170 */       throw new ReflectionException("Argument not valid for field: " + getName(), illegalArgumentException);
/* 171 */     } catch (IllegalAccessException illegalAccessException) {
/* 172 */       throw new ReflectionException("Illegal access to field: " + getName(), illegalAccessException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\reflect\Field.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */