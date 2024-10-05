/*     */ package nonapi.io.github.classgraph.json;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.GenericArrayType;
/*     */ import java.lang.reflect.ParameterizedType;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class TypeResolutions
/*     */ {
/*     */   private final TypeVariable<?>[] typeVariables;
/*     */   Type[] resolvedTypeArguments;
/*     */   
/*     */   TypeResolutions(ParameterizedType paramParameterizedType) {
/*  55 */     this.typeVariables = (TypeVariable<?>[])((Class)paramParameterizedType.getRawType()).getTypeParameters();
/*  56 */     this.resolvedTypeArguments = paramParameterizedType.getActualTypeArguments();
/*  57 */     if (this.resolvedTypeArguments.length != this.typeVariables.length) {
/*  58 */       throw new IllegalArgumentException("Type parameter count mismatch");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Type resolveTypeVariables(Type paramType) {
/*     */     Object object;
/*  70 */     if (paramType instanceof Class)
/*     */     {
/*  72 */       return paramType;
/*     */     }
/*  74 */     if (paramType instanceof ParameterizedType) {
/*     */       ParameterizedType parameterizedType;
/*     */       
/*  77 */       Type[] arrayOfType1 = (parameterizedType = (ParameterizedType)paramType).getActualTypeArguments();
/*  78 */       Type[] arrayOfType2 = null;
/*  79 */       for (byte b = 0; b < arrayOfType1.length; b++) {
/*     */         
/*  81 */         Type type = resolveTypeVariables(arrayOfType1[b]);
/*     */         
/*  83 */         if (arrayOfType2 == null) {
/*  84 */           if (!type.equals(arrayOfType1[b])) {
/*     */             
/*  86 */             arrayOfType2 = new Type[arrayOfType1.length];
/*     */             
/*  88 */             System.arraycopy(arrayOfType1, 0, arrayOfType2, 0, b);
/*     */           } else {
/*     */             continue;
/*     */           } 
/*     */         }
/*     */         
/*  94 */         arrayOfType2[b] = type;
/*     */         continue;
/*     */       } 
/*  97 */       if (arrayOfType2 == null)
/*     */       {
/*  99 */         return paramType;
/*     */       }
/*     */       
/* 102 */       return new ParameterizedTypeImpl((Class)parameterizedType.getRawType(), arrayOfType2, parameterizedType
/* 103 */           .getOwnerType());
/*     */     } 
/*     */     
/* 106 */     if (paramType instanceof TypeVariable) {
/*     */       
/* 108 */       TypeVariable typeVariable = (TypeVariable)paramType;
/* 109 */       for (byte b = 0; b < this.typeVariables.length; b++) {
/* 110 */         if (this.typeVariables[b].getName().equals(typeVariable.getName())) {
/* 111 */           return this.resolvedTypeArguments[b];
/*     */         }
/*     */       } 
/*     */       
/* 115 */       return paramType;
/*     */     } 
/* 117 */     if (paramType instanceof GenericArrayType) {
/*     */       
/* 119 */       byte b = 0;
/* 120 */       Type type1 = paramType;
/* 121 */       while (type1 instanceof GenericArrayType) {
/* 122 */         b++;
/* 123 */         type1 = ((GenericArrayType)type1).getGenericComponentType();
/*     */       } 
/* 125 */       Type type2 = type1;
/*     */       Type type3;
/* 127 */       if (!(type3 = resolveTypeVariables(type2) instanceof Class)) {
/* 128 */         throw new IllegalArgumentException("Could not resolve generic array type " + paramType);
/*     */       }
/* 130 */       Class<?> clazz = (Class)type3;
/*     */ 
/*     */       
/* 133 */       int[] arrayOfInt = (int[])Array.newInstance(int.class, b);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 139 */       return (object = Array.newInstance(clazz, arrayOfInt)).getClass();
/*     */     } 
/* 141 */     if (object instanceof java.lang.reflect.WildcardType)
/*     */     {
/* 143 */       throw new RuntimeException("WildcardType not yet supported: " + object);
/*     */     }
/*     */     
/* 146 */     throw new RuntimeException("Got unexpected type: " + object);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 155 */     if (this.typeVariables.length == 0) {
/* 156 */       return "{ }";
/*     */     }
/*     */     StringBuilder stringBuilder;
/* 159 */     (stringBuilder = new StringBuilder()).append("{ ");
/* 160 */     for (byte b = 0; b < this.typeVariables.length; b++) {
/* 161 */       if (b > 0) {
/* 162 */         stringBuilder.append(", ");
/*     */       }
/* 164 */       stringBuilder.append(this.typeVariables[b]).append(" => ").append(this.resolvedTypeArguments[b]);
/*     */     } 
/* 166 */     stringBuilder.append(" }");
/* 167 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\json\TypeResolutions.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */