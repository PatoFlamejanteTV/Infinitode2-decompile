/*     */ package com.esotericsoftware.kryo.util;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.GenericArrayType;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ import java.lang.reflect.TypeVariable;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface Generics
/*     */ {
/*     */   void pushGenericType(GenericType paramGenericType);
/*     */   
/*     */   void popGenericType();
/*     */   
/*     */   GenericType[] nextGenericTypes();
/*     */   
/*     */   Class nextGenericClass();
/*     */   
/*     */   int pushTypeVariables(GenericsHierarchy paramGenericsHierarchy, GenericType[] paramArrayOfGenericType);
/*     */   
/*     */   void popTypeVariables(int paramInt);
/*     */   
/*     */   Class resolveTypeVariable(TypeVariable paramTypeVariable);
/*     */   
/*     */   int getGenericTypesSize();
/*     */   
/*     */   public static class GenericsHierarchy
/*     */   {
/*     */     final int total;
/*     */     final int rootTotal;
/*     */     final int[] counts;
/*     */     final TypeVariable[] parameters;
/*     */     
/*     */     public GenericsHierarchy(Class param1Class) {
/*  88 */       IntArray intArray = new IntArray();
/*  89 */       ArrayList<TypeVariable> arrayList = new ArrayList();
/*     */       
/*  91 */       int i = 0;
/*  92 */       Class clazz = param1Class;
/*     */       do {
/*  94 */         TypeVariable[] arrayOfTypeVariable = clazz.getTypeParameters(); byte b; int j;
/*  95 */         for (b = 0, j = arrayOfTypeVariable.length; b < j; b++) {
/*  96 */           TypeVariable typeVariable = arrayOfTypeVariable[b];
/*  97 */           arrayList.add(typeVariable);
/*  98 */           intArray.add(1);
/*     */ 
/*     */           
/* 101 */           Class clazz1 = clazz;
/*     */           while (true) {
/* 103 */             Type type = clazz1.getGenericSuperclass();
/* 104 */             clazz1 = clazz1.getSuperclass();
/* 105 */             if (type instanceof ParameterizedType) {
/* 106 */               TypeVariable[] arrayOfTypeVariable1 = clazz1.getTypeParameters();
/* 107 */               Type[] arrayOfType = ((ParameterizedType)type).getActualTypeArguments(); byte b1; int k;
/* 108 */               for (b1 = 0, k = arrayOfType.length; b1 < k; b1++) {
/*     */                 Type type1;
/* 110 */                 if ((type1 = arrayOfType[b1]) == typeVariable) {
/*     */                   
/* 112 */                   typeVariable = arrayOfTypeVariable1[b1];
/* 113 */                   arrayList.add(typeVariable);
/* 114 */                   intArray.incr(intArray.size - 1, 1);
/*     */                 } 
/*     */               }  continue;
/*     */             }  break;
/*     */           } 
/* 119 */           i += intArray.peek();
/*     */         }
/*     */       
/* 122 */       } while ((clazz = clazz.getSuperclass()) != null);
/*     */       
/* 124 */       this.total = i;
/* 125 */       this.rootTotal = (param1Class.getTypeParameters()).length;
/* 126 */       this.counts = intArray.toArray();
/* 127 */       this.parameters = arrayList.<TypeVariable>toArray(new TypeVariable[arrayList.size()]);
/*     */     }
/*     */     
/*     */     public String toString() {
/*     */       StringBuilder stringBuilder;
/* 132 */       (stringBuilder = new StringBuilder()).append("[");
/* 133 */       int[] arrayOfInt = this.counts;
/* 134 */       TypeVariable[] arrayOfTypeVariable = this.parameters; byte b1, b2; int i;
/* 135 */       for (b1 = 0, b2 = 0, i = arrayOfInt.length; b1 < i; b1++) {
/* 136 */         int j = arrayOfInt[b1];
/* 137 */         for (j = b2 + j; b2 < j; b2++) {
/* 138 */           if (stringBuilder.length() > 1) stringBuilder.append(", "); 
/*     */           Class clazz;
/* 140 */           if (clazz = (Class)arrayOfTypeVariable[b2].getGenericDeclaration() instanceof Class) {
/* 141 */             stringBuilder.append(((Class)clazz).getSimpleName());
/*     */           } else {
/* 143 */             stringBuilder.append(clazz);
/* 144 */           }  stringBuilder.append('<');
/* 145 */           stringBuilder.append(arrayOfTypeVariable[b2].getName());
/* 146 */           stringBuilder.append('>');
/*     */         } 
/*     */       } 
/* 149 */       stringBuilder.append("]");
/* 150 */       return stringBuilder.toString();
/*     */     }
/*     */   }
/*     */   
/*     */   public static class GenericType
/*     */   {
/*     */     Type type;
/*     */     GenericType[] arguments;
/*     */     
/*     */     public GenericType(Class param1Class1, Class param1Class2, Type param1Type) {
/* 160 */       initialize(param1Class1, param1Class2, param1Type);
/*     */     } private void initialize(Class param1Class1, Class param1Class2, Type param1Type) {
/*     */       Type[] arrayOfType;
/*     */       Type type;
/* 164 */       if (param1Type instanceof ParameterizedType) {
/*     */         ParameterizedType parameterizedType;
/*     */         
/* 167 */         param1Type = (parameterizedType = (ParameterizedType)param1Type).getRawType();
/* 168 */         this.type = param1Type;
/*     */         
/* 170 */         int i = (arrayOfType = parameterizedType.getActualTypeArguments()).length;
/* 171 */         this.arguments = new GenericType[i];
/* 172 */         for (byte b = 0; b < i; b++)
/* 173 */           this.arguments[b] = new GenericType(param1Class1, param1Class2, arrayOfType[b]);  return;
/*     */       } 
/* 175 */       if (arrayOfType instanceof GenericArrayType) {
/*     */         
/* 177 */         byte b = 1;
/*     */ 
/*     */         
/* 180 */         while (type = ((GenericArrayType)arrayOfType).getGenericComponentType() instanceof GenericArrayType) {
/* 181 */           b++;
/*     */         }
/* 183 */         initialize(param1Class1, param1Class2, type);
/*     */         
/* 185 */         if (type = GenericsUtil.resolveType(param1Class1, param1Class2, type) instanceof Class)
/* 186 */         { if (b == 1) {
/* 187 */             this.type = Array.newInstance((Class)type, 0).getClass();
/*     */           } else {
/* 189 */             this.type = Array.newInstance((Class)type, new int[b]).getClass(); return;
/*     */           }  }
/*     */         else { return; }
/*     */       
/*     */       } else {
/* 194 */         this.type = GenericsUtil.resolveType(param1Class1, param1Class2, type);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Class resolve(Generics param1Generics) {
/* 201 */       if (this.type instanceof Class) return (Class)this.type; 
/* 202 */       return param1Generics.resolveTypeVariable((TypeVariable)this.type);
/*     */     }
/*     */     
/*     */     public Type getType() {
/* 206 */       return this.type;
/*     */     }
/*     */ 
/*     */     
/*     */     public GenericType[] getTypeParameters() {
/* 211 */       return this.arguments;
/*     */     }
/*     */     
/*     */     public String toString() {
/* 215 */       StringBuilder stringBuilder = new StringBuilder(32);
/* 216 */       boolean bool = false;
/* 217 */       if (this.type instanceof Class) {
/*     */         Class<?> clazz;
/* 219 */         bool = (clazz = (Class)this.type).isArray();
/* 220 */         stringBuilder.append((bool ? Util.getElementClass(clazz) : clazz).getSimpleName());
/* 221 */         if (this.arguments != null) {
/* 222 */           stringBuilder.append('<'); int i; byte b;
/* 223 */           for (b = 0, i = this.arguments.length; b < i; b++) {
/* 224 */             if (b > 0) stringBuilder.append(", "); 
/* 225 */             stringBuilder.append(this.arguments[b].toString());
/*     */           } 
/* 227 */           stringBuilder.append('>');
/*     */         } 
/*     */       } else {
/* 230 */         stringBuilder.append(this.type.toString());
/* 231 */       }  if (bool) {
/* 232 */         byte b; int i; for (b = 0, i = Util.getDimensionCount((Class)this.type); b < i; b++)
/* 233 */           stringBuilder.append("[]"); 
/*     */       } 
/* 235 */       return stringBuilder.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\util\Generics.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */