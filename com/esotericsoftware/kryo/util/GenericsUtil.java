/*     */ package com.esotericsoftware.kryo.util;
/*     */ 
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.GenericArrayType;
/*     */ import java.lang.reflect.GenericDeclaration;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ import java.lang.reflect.TypeVariable;
/*     */ import java.lang.reflect.WildcardType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GenericsUtil
/*     */ {
/*     */   public static Type resolveType(Class paramClass1, Class paramClass2, Type paramType) {
/*  38 */     if (paramType instanceof Class) return paramType;
/*     */ 
/*     */     
/*  41 */     if (paramType instanceof TypeVariable) return resolveTypeVariable(paramClass1, paramClass2, paramType, true);
/*     */ 
/*     */     
/*  44 */     if (paramType instanceof ParameterizedType) return ((ParameterizedType)paramType).getRawType();
/*     */ 
/*     */     
/*  47 */     if (paramType instanceof GenericArrayType) {
/*  48 */       byte b = 1;
/*     */ 
/*     */       
/*  51 */       while (paramType = ((GenericArrayType)paramType).getGenericComponentType() instanceof GenericArrayType) {
/*  52 */         b++;
/*     */       }
/*     */       Type type;
/*  55 */       if (!(type = resolveType(paramClass1, paramClass2, paramType) instanceof Class)) return paramType; 
/*  56 */       if (b == 1) return Array.newInstance((Class)type, 0).getClass(); 
/*  57 */       return Array.newInstance((Class)type, new int[b]).getClass();
/*     */     } 
/*     */ 
/*     */     
/*  61 */     if (paramType instanceof WildcardType) {
/*     */       Type type;
/*     */       
/*  64 */       if ((type = ((WildcardType)paramType).getUpperBounds()[0]) != Object.class) return resolveType(paramClass1, paramClass2, type); 
/*     */       Type[] arrayOfType;
/*  66 */       if ((arrayOfType = ((WildcardType)paramType).getLowerBounds()).length != 0) return resolveType(paramClass1, paramClass2, arrayOfType[0]); 
/*  67 */       return Object.class;
/*     */     } 
/*     */ 
/*     */     
/*  71 */     throw new KryoException("Unable to resolve type: " + paramType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Type resolveTypeVariable(Class paramClass1, Class paramClass2, Type paramType, boolean paramBoolean) {
/*     */     Type type;
/*  81 */     if (!(type = paramClass2.getGenericSuperclass() instanceof ParameterizedType)) return paramType;
/*     */ 
/*     */     
/*     */     Class clazz;
/*  85 */     if ((clazz = paramClass2.getSuperclass()) != paramClass1) {
/*     */       Type type1;
/*  87 */       if (type1 = resolveTypeVariable(paramClass1, clazz, paramType, false) instanceof Class) return type1; 
/*  88 */       paramType = type1;
/*     */     } 
/*     */ 
/*     */     
/*  92 */     String str = paramType.toString();
/*  93 */     TypeVariable[] arrayOfTypeVariable = clazz.getTypeParameters(); byte b; int i;
/*  94 */     for (b = 0, i = arrayOfTypeVariable.length; b < i; b++) {
/*     */       TypeVariable<GenericDeclaration> typeVariable;
/*  96 */       if ((typeVariable = arrayOfTypeVariable[b]).getName().equals(str)) {
/*     */         Type type1;
/*     */ 
/*     */ 
/*     */         
/* 101 */         if (type1 = ((ParameterizedType)type).getActualTypeArguments()[b] instanceof Class) return type1; 
/* 102 */         if (type1 instanceof ParameterizedType) return resolveType(paramClass1, paramClass2, type1); 
/* 103 */         if (type1 instanceof GenericArrayType) return resolveType(paramClass1, paramClass2, type1);
/*     */         
/* 105 */         if (type1 instanceof TypeVariable) {
/* 106 */           if (paramBoolean) return paramType; 
/* 107 */           return type1;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 114 */     return paramType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Type[] resolveTypeParameters(Class paramClass1, Class paramClass2, Type paramType) {
/*     */     Type[] arrayOfType;
/* 124 */     if (paramType instanceof ParameterizedType) {
/*     */       int i;
/*     */       
/* 127 */       Type[] arrayOfType1 = new Type[i = (arrayOfType = ((ParameterizedType)paramType).getActualTypeArguments()).length];
/* 128 */       for (byte b = 0; b < i; b++)
/* 129 */         arrayOfType1[b] = resolveType(paramClass1, paramClass2, arrayOfType[b]); 
/* 130 */       return arrayOfType1;
/*     */     } 
/*     */ 
/*     */     
/* 134 */     if (arrayOfType instanceof GenericArrayType) {
/*     */       Type type; do {
/*     */       
/* 137 */       } while (type = ((GenericArrayType)arrayOfType).getGenericComponentType() instanceof GenericArrayType);
/*     */       
/* 139 */       return resolveTypeParameters(paramClass1, paramClass2, type);
/*     */     } 
/*     */     
/* 142 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\util\GenericsUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */