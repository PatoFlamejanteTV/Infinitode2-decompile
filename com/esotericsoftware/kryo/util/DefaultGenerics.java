/*     */ package com.esotericsoftware.kryo.util;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import java.lang.reflect.GenericDeclaration;
/*     */ import java.lang.reflect.Type;
/*     */ import java.lang.reflect.TypeVariable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class DefaultGenerics
/*     */   implements Generics
/*     */ {
/*     */   private final Kryo kryo;
/*     */   private int genericTypesSize;
/*  33 */   private Generics.GenericType[] genericTypes = new Generics.GenericType[16];
/*  34 */   private int[] depths = new int[16];
/*     */   
/*     */   private int argumentsSize;
/*  37 */   private Type[] arguments = new Type[16];
/*     */   
/*     */   public DefaultGenerics(Kryo paramKryo) {
/*  40 */     this.kryo = paramKryo;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void pushGenericType(Generics.GenericType paramGenericType) {
/*     */     int i;
/*  47 */     if ((i = this.genericTypesSize) + 1 == this.genericTypes.length) {
/*  48 */       Generics.GenericType[] arrayOfGenericType = new Generics.GenericType[this.genericTypes.length << 1];
/*  49 */       System.arraycopy(this.genericTypes, 0, arrayOfGenericType, 0, i);
/*  50 */       this.genericTypes = arrayOfGenericType;
/*  51 */       int[] arrayOfInt = new int[this.depths.length << 1];
/*  52 */       System.arraycopy(this.depths, 0, arrayOfInt, 0, i);
/*  53 */       this.depths = arrayOfInt;
/*     */     } 
/*     */     
/*  56 */     this.genericTypesSize = i + 1;
/*  57 */     this.genericTypes[i] = paramGenericType;
/*  58 */     this.depths[i] = this.kryo.getDepth();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void popGenericType() {
/*     */     int i;
/*  64 */     if ((i = this.genericTypesSize) == 0)
/*  65 */       return;  i--;
/*  66 */     if (this.depths[i] < this.kryo.getDepth())
/*  67 */       return;  this.genericTypes[i] = null;
/*  68 */     this.genericTypesSize = i;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Generics.GenericType[] nextGenericTypes() {
/*     */     int i;
/*  74 */     if ((i = this.genericTypesSize) > 0) {
/*  75 */       i--;
/*     */       Generics.GenericType genericType;
/*  77 */       if ((genericType = this.genericTypes[i]).arguments == null) return null;
/*     */       
/*  79 */       if (this.depths[i] == this.kryo.getDepth() - 1) {
/*  80 */         pushGenericType(genericType.arguments[genericType.arguments.length - 1]);
/*  81 */         return genericType.arguments;
/*     */       } 
/*     */     } 
/*  84 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Class nextGenericClass() {
/*     */     Generics.GenericType[] arrayOfGenericType;
/*  90 */     if ((arrayOfGenericType = nextGenericTypes()) == null) return null; 
/*  91 */     return arrayOfGenericType[0].resolve(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int pushTypeVariables(Generics.GenericsHierarchy paramGenericsHierarchy, Generics.GenericType[] paramArrayOfGenericType) {
/*  98 */     if (paramGenericsHierarchy.total == 0 || paramGenericsHierarchy.rootTotal > paramArrayOfGenericType.length || paramArrayOfGenericType.length > paramGenericsHierarchy.counts.length) return 0;
/*     */ 
/*     */ 
/*     */     
/*     */     int i, j;
/*     */     
/* 104 */     if ((j = (i = this.argumentsSize) + paramGenericsHierarchy.total) > this.arguments.length) {
/* 105 */       Type[] arrayOfType = new Type[Math.max(j, this.arguments.length << 1)];
/* 106 */       System.arraycopy(this.arguments, 0, arrayOfType, 0, i);
/* 107 */       this.arguments = arrayOfType;
/*     */     } 
/*     */ 
/*     */     
/* 111 */     int[] arrayOfInt = paramGenericsHierarchy.counts;
/* 112 */     TypeVariable[] arrayOfTypeVariable = paramGenericsHierarchy.parameters; byte b; int k, m;
/* 113 */     for (b = 0, k = 0, m = paramArrayOfGenericType.length; b < m; b++) {
/*     */       Generics.GenericType genericType;
/*     */       Class clazz;
/* 116 */       if ((clazz = (genericType = paramArrayOfGenericType[b]).resolve(this)) != null) {
/* 117 */         int n = arrayOfInt[b];
/* 118 */         if (genericType == null) {
/* 119 */           k += n;
/*     */         } else {
/* 121 */           for (int i1 = k + n; k < i1; k++) {
/* 122 */             this.arguments[this.argumentsSize] = arrayOfTypeVariable[k];
/* 123 */             this.arguments[this.argumentsSize + 1] = clazz;
/* 124 */             this.argumentsSize += 2;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 129 */     return this.argumentsSize - i;
/*     */   }
/*     */   
/*     */   public final void popTypeVariables(int paramInt) {
/*     */     int i;
/* 134 */     paramInt = (i = this.argumentsSize) - paramInt;
/* 135 */     this.argumentsSize = paramInt;
/* 136 */     while (paramInt < i) {
/* 137 */       this.arguments[paramInt++] = null;
/*     */     }
/*     */   }
/*     */   
/*     */   public final Class resolveTypeVariable(TypeVariable paramTypeVariable) {
/* 142 */     for (int i = this.argumentsSize - 2; i >= 0; i -= 2) {
/*     */       Type type;
/* 144 */       if ((type = this.arguments[i]) == paramTypeVariable || type.equals(paramTypeVariable)) return (Class)this.arguments[i + 1]; 
/*     */     } 
/* 146 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getGenericTypesSize() {
/* 151 */     return this.genericTypesSize;
/*     */   }
/*     */   
/*     */   public final String toString() {
/* 155 */     StringBuilder stringBuilder = new StringBuilder();
/* 156 */     for (byte b = 0; b < this.argumentsSize; b += 2) {
/* 157 */       if (b != 0) stringBuilder.append(", "); 
/* 158 */       stringBuilder.append(((TypeVariable<GenericDeclaration>)this.arguments[b]).getName());
/* 159 */       stringBuilder.append("=");
/* 160 */       stringBuilder.append(((Class)this.arguments[b + 1]).getSimpleName());
/*     */     } 
/* 162 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\util\DefaultGenerics.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */