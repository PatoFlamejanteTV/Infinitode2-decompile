/*     */ package com.google.common.base;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.EnumSet;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.WeakHashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class Enums
/*     */ {
/*     */   public static Field getField(Enum<?> paramEnum) {
/*  51 */     Class<?> clazz = paramEnum.getDeclaringClass();
/*     */     try {
/*  53 */       return clazz.getDeclaredField(paramEnum.name());
/*  54 */     } catch (NoSuchFieldException noSuchFieldException) {
/*  55 */       throw new AssertionError(noSuchFieldException);
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
/*     */   public static <T extends Enum<T>> Optional<T> getIfPresent(Class<T> paramClass, String paramString) {
/*  68 */     Preconditions.checkNotNull(paramClass);
/*  69 */     Preconditions.checkNotNull(paramString);
/*  70 */     return Platform.getEnumIfPresent(paramClass, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  75 */   private static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> enumConstantCache = new WeakHashMap<>();
/*     */ 
/*     */ 
/*     */   
/*     */   private static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> populateCache(Class<T> paramClass) {
/*  80 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  81 */     for (Enum enum_ : EnumSet.<T>allOf(paramClass)) {
/*  82 */       hashMap.put(enum_.name(), new WeakReference<>(enum_));
/*     */     }
/*  84 */     enumConstantCache.put(paramClass, hashMap);
/*  85 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> getEnumConstants(Class<T> paramClass) {
/*  91 */     synchronized (enumConstantCache) {
/*     */       Map<String, WeakReference<? extends Enum<?>>> map;
/*  93 */       if ((map = enumConstantCache.get(paramClass)) == null) {
/*  94 */         map = populateCache(paramClass);
/*     */       }
/*  96 */       return map;
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
/*     */   public static <T extends Enum<T>> Converter<String, T> stringConverter(Class<T> paramClass) {
/* 109 */     return new StringConverter<>(paramClass);
/*     */   }
/*     */   
/*     */   private static final class StringConverter<T extends Enum<T>>
/*     */     extends Converter<String, T> implements Serializable {
/*     */     private final Class<T> enumClass;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     StringConverter(Class<T> param1Class) {
/* 118 */       this.enumClass = Preconditions.<Class<T>>checkNotNull(param1Class);
/*     */     }
/*     */ 
/*     */     
/*     */     protected final T doForward(String param1String) {
/* 123 */       return Enum.valueOf(this.enumClass, param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     protected final String doBackward(T param1T) {
/* 128 */       return param1T.name();
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean equals(Object param1Object) {
/* 133 */       if (param1Object instanceof StringConverter) {
/* 134 */         param1Object = param1Object;
/* 135 */         return this.enumClass.equals(((StringConverter)param1Object).enumClass);
/*     */       } 
/* 137 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int hashCode() {
/* 142 */       return this.enumClass.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 147 */       String str = this.enumClass.getName(); return (new StringBuilder(29 + String.valueOf(str).length())).append("Enums.stringConverter(").append(str).append(".class)").toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Enums.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */