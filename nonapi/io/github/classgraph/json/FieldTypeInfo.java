/*     */ package nonapi.io.github.classgraph.json;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class FieldTypeInfo
/*     */ {
/*     */   final Field field;
/*     */   private final Type fieldTypePartiallyResolved;
/*     */   private final boolean hasUnresolvedTypeVariables;
/*     */   private final boolean isTypeVariable;
/*     */   private final PrimitiveType primitiveType;
/*     */   private Constructor<?> constructorForFieldTypeWithSizeHint;
/*     */   private Constructor<?> defaultConstructorForFieldType;
/*     */   
/*     */   private enum PrimitiveType
/*     */   {
/*  83 */     NON_PRIMITIVE,
/*     */     
/*  85 */     INTEGER,
/*     */     
/*  87 */     LONG,
/*     */     
/*  89 */     SHORT,
/*     */     
/*  91 */     DOUBLE,
/*     */     
/*  93 */     FLOAT,
/*     */     
/*  95 */     BOOLEAN,
/*     */     
/*  97 */     BYTE,
/*     */     
/*  99 */     CHARACTER,
/*     */     
/* 101 */     CLASS_REF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean hasTypeVariables(Type paramType) {
/* 112 */     if (paramType instanceof java.lang.reflect.TypeVariable || paramType instanceof java.lang.reflect.GenericArrayType)
/* 113 */       return true; 
/* 114 */     if (paramType instanceof ParameterizedType) {
/* 115 */       Type[] arrayOfType; int i; byte b; for (i = (arrayOfType = ((ParameterizedType)paramType).getActualTypeArguments()).length, b = 0; b < i; b++) {
/* 116 */         Type type; if (hasTypeVariables(type = arrayOfType[b])) {
/* 117 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/* 121 */     return false;
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
/*     */   public FieldTypeInfo(Field paramField, Type paramType, ClassFieldCache paramClassFieldCache) {
/* 136 */     this.field = paramField;
/* 137 */     this.fieldTypePartiallyResolved = paramType;
/* 138 */     this.isTypeVariable = paramType instanceof java.lang.reflect.TypeVariable;
/* 139 */     this.hasUnresolvedTypeVariables = (this.isTypeVariable || hasTypeVariables(paramType));
/*     */ 
/*     */     
/*     */     boolean bool;
/*     */ 
/*     */     
/* 145 */     if ((bool = (paramType instanceof java.lang.reflect.GenericArrayType || (paramType instanceof Class && ((Class)paramType).isArray())) ? true : false) || this.isTypeVariable) {
/* 146 */       this.primitiveType = PrimitiveType.NON_PRIMITIVE;
/*     */       return;
/*     */     } 
/*     */     Class<?> clazz;
/* 150 */     if ((clazz = JSONUtils.getRawType(paramType)) == int.class) {
/* 151 */       this.primitiveType = PrimitiveType.INTEGER;
/* 152 */     } else if (clazz == long.class) {
/* 153 */       this.primitiveType = PrimitiveType.LONG;
/* 154 */     } else if (clazz == short.class) {
/* 155 */       this.primitiveType = PrimitiveType.SHORT;
/* 156 */     } else if (clazz == double.class) {
/* 157 */       this.primitiveType = PrimitiveType.DOUBLE;
/* 158 */     } else if (clazz == float.class) {
/* 159 */       this.primitiveType = PrimitiveType.FLOAT;
/* 160 */     } else if (clazz == boolean.class) {
/* 161 */       this.primitiveType = PrimitiveType.BOOLEAN;
/* 162 */     } else if (clazz == byte.class) {
/* 163 */       this.primitiveType = PrimitiveType.BYTE;
/* 164 */     } else if (clazz == char.class) {
/* 165 */       this.primitiveType = PrimitiveType.CHARACTER;
/* 166 */     } else if (clazz == Class.class) {
/* 167 */       this.primitiveType = PrimitiveType.CLASS_REF;
/*     */     } else {
/* 169 */       this.primitiveType = PrimitiveType.NON_PRIMITIVE;
/*     */     } 
/*     */ 
/*     */     
/* 173 */     if (!JSONUtils.isBasicValueType(clazz)) {
/* 174 */       if (Collection.class.isAssignableFrom(clazz) || Map.class.isAssignableFrom(clazz)) {
/* 175 */         this
/* 176 */           .constructorForFieldTypeWithSizeHint = paramClassFieldCache.getConstructorWithSizeHintForConcreteTypeOf(clazz);
/*     */       }
/* 178 */       if (this.constructorForFieldTypeWithSizeHint == null) {
/* 179 */         this
/* 180 */           .defaultConstructorForFieldType = paramClassFieldCache.getDefaultConstructorForConcreteTypeOf(clazz);
/*     */       }
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
/*     */   public Constructor<?> getConstructorForFieldTypeWithSizeHint(Type<?> paramType, ClassFieldCache paramClassFieldCache) {
/* 197 */     if (!this.isTypeVariable) {
/* 198 */       return this.constructorForFieldTypeWithSizeHint;
/*     */     }
/* 200 */     paramType = JSONUtils.getRawType(paramType);
/* 201 */     if (!Collection.class.isAssignableFrom((Class<?>)paramType) && 
/* 202 */       !Map.class.isAssignableFrom((Class<?>)paramType))
/*     */     {
/*     */       
/* 205 */       return null;
/*     */     }
/* 207 */     return paramClassFieldCache.getConstructorWithSizeHintForConcreteTypeOf((Class<?>)paramType);
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
/*     */   public Constructor<?> getDefaultConstructorForFieldType(Type<?> paramType, ClassFieldCache paramClassFieldCache) {
/* 222 */     if (!this.isTypeVariable) {
/* 223 */       return this.defaultConstructorForFieldType;
/*     */     }
/* 225 */     paramType = JSONUtils.getRawType(paramType);
/* 226 */     return paramClassFieldCache.getDefaultConstructorForConcreteTypeOf((Class<?>)paramType);
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
/*     */   public Type getFullyResolvedFieldType(TypeResolutions paramTypeResolutions) {
/* 238 */     if (!this.hasUnresolvedTypeVariables)
/*     */     {
/* 240 */       return this.fieldTypePartiallyResolved;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 245 */     return paramTypeResolutions.resolveTypeVariables(this.fieldTypePartiallyResolved);
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
/*     */   void setFieldValue(Object paramObject1, Object paramObject2) {
/*     */     try {
/* 258 */       if (paramObject2 == null) {
/* 259 */         if (this.primitiveType != PrimitiveType.NON_PRIMITIVE) {
/* 260 */           throw new IllegalArgumentException("Tried to set primitive-typed field " + this.field
/* 261 */               .getDeclaringClass().getName() + "." + this.field.getName() + " to null value");
/*     */         }
/* 263 */         this.field.set(paramObject1, null);
/*     */         return;
/*     */       } 
/* 266 */       switch (this.primitiveType) {
/*     */         case NON_PRIMITIVE:
/* 268 */           this.field.set(paramObject1, paramObject2);
/*     */           return;
/*     */         case CLASS_REF:
/* 271 */           if (!(paramObject2 instanceof Class)) {
/* 272 */             throw new IllegalArgumentException("Expected value of type Class<?>; got " + paramObject2
/* 273 */                 .getClass().getName());
/*     */           }
/* 275 */           this.field.set(paramObject1, paramObject2);
/*     */           return;
/*     */         case INTEGER:
/* 278 */           if (!(paramObject2 instanceof Integer)) {
/* 279 */             throw new IllegalArgumentException("Expected value of type Integer; got " + paramObject2
/* 280 */                 .getClass().getName());
/*     */           }
/* 282 */           this.field.setInt(paramObject1, ((Integer)paramObject2).intValue());
/*     */           return;
/*     */         case LONG:
/* 285 */           if (!(paramObject2 instanceof Long)) {
/* 286 */             throw new IllegalArgumentException("Expected value of type Long; got " + paramObject2
/* 287 */                 .getClass().getName());
/*     */           }
/* 289 */           this.field.setLong(paramObject1, ((Long)paramObject2).longValue());
/*     */           return;
/*     */         case SHORT:
/* 292 */           if (!(paramObject2 instanceof Short)) {
/* 293 */             throw new IllegalArgumentException("Expected value of type Short; got " + paramObject2
/* 294 */                 .getClass().getName());
/*     */           }
/* 296 */           this.field.setShort(paramObject1, ((Short)paramObject2).shortValue());
/*     */           return;
/*     */         case DOUBLE:
/* 299 */           if (!(paramObject2 instanceof Double)) {
/* 300 */             throw new IllegalArgumentException("Expected value of type Double; got " + paramObject2
/* 301 */                 .getClass().getName());
/*     */           }
/* 303 */           this.field.setDouble(paramObject1, ((Double)paramObject2).doubleValue());
/*     */           return;
/*     */         case FLOAT:
/* 306 */           if (!(paramObject2 instanceof Float)) {
/* 307 */             throw new IllegalArgumentException("Expected value of type Float; got " + paramObject2
/* 308 */                 .getClass().getName());
/*     */           }
/* 310 */           this.field.setFloat(paramObject1, ((Float)paramObject2).floatValue());
/*     */           return;
/*     */         case BOOLEAN:
/* 313 */           if (!(paramObject2 instanceof Boolean)) {
/* 314 */             throw new IllegalArgumentException("Expected value of type Boolean; got " + paramObject2
/* 315 */                 .getClass().getName());
/*     */           }
/* 317 */           this.field.setBoolean(paramObject1, ((Boolean)paramObject2).booleanValue());
/*     */           return;
/*     */         case BYTE:
/* 320 */           if (!(paramObject2 instanceof Byte)) {
/* 321 */             throw new IllegalArgumentException("Expected value of type Byte; got " + paramObject2
/* 322 */                 .getClass().getName());
/*     */           }
/* 324 */           this.field.setByte(paramObject1, ((Byte)paramObject2).byteValue());
/*     */           return;
/*     */         case CHARACTER:
/* 327 */           if (!(paramObject2 instanceof Character)) {
/* 328 */             throw new IllegalArgumentException("Expected value of type Character; got " + paramObject2
/* 329 */                 .getClass().getName());
/*     */           }
/* 331 */           this.field.setChar(paramObject1, ((Character)paramObject2).charValue());
/*     */           return;
/*     */       } 
/* 334 */       throw new IllegalArgumentException();
/*     */     }
/* 336 */     catch (IllegalArgumentException|IllegalAccessException illegalArgumentException) {
/* 337 */       throw new IllegalArgumentException("Could not set field " + this.field
/* 338 */           .getDeclaringClass().getName() + "." + this.field.getName(), illegalArgumentException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 347 */     return this.fieldTypePartiallyResolved + " " + this.field.getDeclaringClass().getName() + "." + this.field
/* 348 */       .getDeclaringClass().getName();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\json\FieldTypeInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */