/*     */ package com.esotericsoftware.kryo.serializers;
/*     */ 
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import com.esotericsoftware.kryo.Serializer;
/*     */ import com.esotericsoftware.kryo.SerializerFactory;
/*     */ import com.esotericsoftware.kryo.util.Generics;
/*     */ import com.esotericsoftware.kryo.util.Util;
/*     */ import com.esotericsoftware.minlog.Log;
/*     */ import com.esotericsoftware.reflectasm.FieldAccess;
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.security.AccessControlException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
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
/*     */ class CachedFields
/*     */   implements Comparator<FieldSerializer.CachedField>
/*     */ {
/*  74 */   static final FieldSerializer.CachedField[] emptyCachedFields = new FieldSerializer.CachedField[0];
/*     */   
/*     */   private final FieldSerializer serializer;
/*  77 */   FieldSerializer.CachedField[] fields = new FieldSerializer.CachedField[0];
/*  78 */   FieldSerializer.CachedField[] copyFields = new FieldSerializer.CachedField[0];
/*  79 */   private final ArrayList<Field> removedFields = new ArrayList<>();
/*     */   private Object access;
/*     */   
/*     */   public CachedFields(FieldSerializer paramFieldSerializer) {
/*  83 */     this.serializer = paramFieldSerializer;
/*     */   }
/*     */   
/*     */   public void rebuild() {
/*  87 */     if (this.serializer.type.isInterface()) {
/*  88 */       this.fields = emptyCachedFields;
/*  89 */       this.copyFields = emptyCachedFields;
/*  90 */       this.serializer.initializeCachedFields();
/*     */       
/*     */       return;
/*     */     } 
/*  94 */     ArrayList<FieldSerializer.CachedField> arrayList1 = new ArrayList(), arrayList2 = new ArrayList();
/*  95 */     boolean bool = (!Util.unsafe && !Util.isAndroid && Modifier.isPublic(this.serializer.type.getModifiers())) ? true : false;
/*  96 */     Class<Object> clazz = this.serializer.type;
/*  97 */     while (clazz != Object.class) {
/*  98 */       Field[] arrayOfField; int i; byte b; for (i = (arrayOfField = clazz.getDeclaredFields()).length, b = 0; b < i; ) { Field field = arrayOfField[b];
/*  99 */         addField(field, bool, arrayList1, arrayList2); b++; }
/* 100 */        clazz = (Class)clazz.getSuperclass();
/*     */     } 
/*     */     
/* 103 */     if (this.fields.length != arrayList1.size()) this.fields = new FieldSerializer.CachedField[arrayList1.size()]; 
/* 104 */     arrayList1.toArray(this.fields);
/* 105 */     Arrays.sort(this.fields, this);
/*     */     
/* 107 */     if (this.copyFields.length != arrayList2.size()) this.copyFields = new FieldSerializer.CachedField[arrayList2.size()]; 
/* 108 */     arrayList2.toArray(this.copyFields);
/* 109 */     Arrays.sort(this.copyFields, this);
/*     */     
/* 111 */     this.serializer.initializeCachedFields();
/*     */   }
/*     */   private void addField(Field paramField, boolean paramBoolean, ArrayList<FieldSerializer.CachedField> paramArrayList1, ArrayList<FieldSerializer.CachedField> paramArrayList2) {
/*     */     FieldSerializer.CachedField cachedField;
/*     */     int i;
/* 116 */     if (Modifier.isStatic(i = paramField.getModifiers()))
/* 117 */       return;  FieldSerializer.FieldSerializerConfig fieldSerializerConfig = this.serializer.config;
/* 118 */     if (paramField.isSynthetic() && fieldSerializerConfig.ignoreSyntheticFields)
/*     */       return; 
/* 120 */     if (!paramField.isAccessible()) {
/* 121 */       if (!fieldSerializerConfig.setFieldsAsAccessible)
/*     */         return;  try {
/* 123 */         paramField.setAccessible(true);
/* 124 */       } catch (AccessControlException accessControlException) {
/* 125 */         if (Log.DEBUG) Log.debug("kryo", "Unable to set field as accessible: " + paramField);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     FieldSerializer.Optional optional;
/* 131 */     if ((optional = paramField.<Annotation>getAnnotation(FieldSerializer.Optional.class)) != null && !this.serializer.kryo.getContext().containsKey(optional.value()))
/*     */       return; 
/* 133 */     if (this.removedFields.contains(paramField))
/*     */       return; 
/*     */     boolean bool;
/* 136 */     if ((bool = Modifier.isTransient(i)) && !fieldSerializerConfig.serializeTransient && !fieldSerializerConfig.copyTransient)
/*     */       return; 
/* 138 */     Class<?> clazz = paramField.getDeclaringClass();
/*     */     Generics.GenericType genericType;
/* 140 */     Class<String> clazz1 = ((genericType = new Generics.GenericType(clazz, this.serializer.type, paramField.getGenericType())).getType() instanceof Class) ? (Class)genericType.getType() : paramField.getType();
/* 141 */     int j = -1;
/* 142 */     if (paramBoolean && 
/* 143 */       !Modifier.isFinal(i) && 
/* 144 */       Modifier.isPublic(i) && 
/* 145 */       Modifier.isPublic(clazz1.getModifiers())) {
/*     */       try {
/* 147 */         if (this.access == null) this.access = FieldAccess.get(this.serializer.type); 
/* 148 */         j = ((FieldAccess)this.access).getIndex(paramField);
/* 149 */       } catch (RuntimeException|LinkageError runtimeException) {
/* 150 */         if (Log.DEBUG) Log.debug("kryo", "Unable to use ReflectASM.", runtimeException);
/*     */       
/*     */       } 
/*     */     }
/*     */     
/* 155 */     if (Util.unsafe) {
/* 156 */       cachedField = newUnsafeField(paramField, clazz1, genericType);
/* 157 */     } else if (j != -1) {
/*     */       
/* 159 */       (cachedField = newAsmField(paramField, clazz1, genericType)).access = (FieldAccess)this.access;
/* 160 */       cachedField.accessIndex = j;
/*     */     } else {
/* 162 */       cachedField = newReflectField(paramField, clazz1, genericType);
/*     */     } 
/* 164 */     cachedField.varEncoding = fieldSerializerConfig.varEncoding;
/* 165 */     if (fieldSerializerConfig.extendedFieldNames) {
/* 166 */       cachedField.name = clazz.getSimpleName() + "." + paramField.getName();
/*     */     } else {
/* 168 */       cachedField.name = paramField.getName();
/*     */     } 
/* 170 */     if (cachedField instanceof ReflectField) {
/* 171 */       cachedField.canBeNull = (fieldSerializerConfig.fieldsCanBeNull && !paramField.isAnnotationPresent((Class)FieldSerializer.NotNull.class));
/* 172 */       if (this.serializer.kryo.isFinal(clazz1) || fieldSerializerConfig.fixedFieldTypes) cachedField.valueClass = clazz1;
/*     */       
/* 174 */       if (Log.TRACE) {
/* 175 */         Log.trace("kryo", "Cached " + clazz1
/* 176 */             .getSimpleName() + " field: " + paramField.getName() + " (" + Util.className(clazz) + ")");
/*     */       }
/*     */     } else {
/* 179 */       cachedField.canBeNull = (clazz1 == String.class && fieldSerializerConfig.fieldsCanBeNull);
/* 180 */       cachedField.valueClass = clazz1;
/*     */       
/* 182 */       if (Log.TRACE) Log.trace("kryo", "Cached " + clazz1
/* 183 */             .getSimpleName() + " field: " + paramField.getName() + " (" + Util.className(clazz) + ")");
/*     */     
/*     */     } 
/* 186 */     applyAnnotations(cachedField);
/*     */     
/* 188 */     if (bool)
/* 189 */     { if (fieldSerializerConfig.serializeTransient) paramArrayList1.add(cachedField); 
/* 190 */       if (fieldSerializerConfig.copyTransient) { paramArrayList2.add(cachedField); return; }
/*     */        }
/* 192 */     else { paramArrayList1.add(cachedField);
/* 193 */       paramArrayList2.add(cachedField); }
/*     */   
/*     */   }
/*     */   
/*     */   private FieldSerializer.CachedField newUnsafeField(Field paramField, Class<int> paramClass, Generics.GenericType paramGenericType) {
/* 198 */     if (paramClass.isPrimitive()) {
/* 199 */       if (paramClass == int.class) return new UnsafeField.IntUnsafeField(paramField); 
/* 200 */       if (paramClass == float.class) return new UnsafeField.FloatUnsafeField(paramField); 
/* 201 */       if (paramClass == boolean.class) return new UnsafeField.BooleanUnsafeField(paramField); 
/* 202 */       if (paramClass == long.class) return new UnsafeField.LongUnsafeField(paramField); 
/* 203 */       if (paramClass == double.class) return new UnsafeField.DoubleUnsafeField(paramField); 
/* 204 */       if (paramClass == short.class) return new UnsafeField.ShortUnsafeField(paramField); 
/* 205 */       if (paramClass == char.class) return new UnsafeField.CharUnsafeField(paramField); 
/* 206 */       if (paramClass == byte.class) return new UnsafeField.ByteUnsafeField(paramField); 
/*     */     } 
/* 208 */     if (paramClass == String.class && (
/* 209 */       !this.serializer.kryo.getReferences() || !this.serializer.kryo.getReferenceResolver().useReferences(String.class)))
/* 210 */       return new UnsafeField.StringUnsafeField(paramField); 
/* 211 */     return new UnsafeField(paramField, this.serializer, paramGenericType);
/*     */   }
/*     */   
/*     */   private FieldSerializer.CachedField newAsmField(Field paramField, Class<int> paramClass, Generics.GenericType paramGenericType) {
/* 215 */     if (paramClass.isPrimitive()) {
/* 216 */       if (paramClass == int.class) return new AsmField.IntAsmField(paramField); 
/* 217 */       if (paramClass == float.class) return new AsmField.FloatAsmField(paramField); 
/* 218 */       if (paramClass == boolean.class) return new AsmField.BooleanAsmField(paramField); 
/* 219 */       if (paramClass == long.class) return new AsmField.LongAsmField(paramField); 
/* 220 */       if (paramClass == double.class) return new AsmField.DoubleAsmField(paramField); 
/* 221 */       if (paramClass == short.class) return new AsmField.ShortAsmField(paramField); 
/* 222 */       if (paramClass == char.class) return new AsmField.CharAsmField(paramField); 
/* 223 */       if (paramClass == byte.class) return new AsmField.ByteAsmField(paramField); 
/*     */     } 
/* 225 */     if (paramClass == String.class && (
/* 226 */       !this.serializer.kryo.getReferences() || !this.serializer.kryo.getReferenceResolver().useReferences(String.class)))
/* 227 */       return new AsmField.StringAsmField(paramField); 
/* 228 */     return new AsmField(paramField, this.serializer, paramGenericType);
/*     */   }
/*     */   
/*     */   private FieldSerializer.CachedField newReflectField(Field paramField, Class<int> paramClass, Generics.GenericType paramGenericType) {
/* 232 */     if (paramClass.isPrimitive()) {
/* 233 */       if (paramClass == int.class) return new ReflectField.IntReflectField(paramField); 
/* 234 */       if (paramClass == float.class) return new ReflectField.FloatReflectField(paramField); 
/* 235 */       if (paramClass == boolean.class) return new ReflectField.BooleanReflectField(paramField); 
/* 236 */       if (paramClass == long.class) return new ReflectField.LongReflectField(paramField); 
/* 237 */       if (paramClass == double.class) return new ReflectField.DoubleReflectField(paramField); 
/* 238 */       if (paramClass == short.class) return new ReflectField.ShortReflectField(paramField); 
/* 239 */       if (paramClass == char.class) return new ReflectField.CharReflectField(paramField); 
/* 240 */       if (paramClass == byte.class) return new ReflectField.ByteReflectField(paramField); 
/*     */     } 
/* 242 */     return new ReflectField(paramField, this.serializer, paramGenericType);
/*     */   }
/*     */ 
/*     */   
/*     */   public int compare(FieldSerializer.CachedField paramCachedField1, FieldSerializer.CachedField paramCachedField2) {
/* 247 */     return paramCachedField1.name.compareTo(paramCachedField2.name);
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeField(String paramString) {
/* 252 */     boolean bool = false; byte b;
/* 253 */     for (b = 0; b < this.fields.length; b++) {
/*     */       FieldSerializer.CachedField cachedField;
/* 255 */       if ((cachedField = this.fields[b]).name.equals(paramString)) {
/* 256 */         FieldSerializer.CachedField[] arrayOfCachedField = new FieldSerializer.CachedField[this.fields.length - 1];
/* 257 */         System.arraycopy(this.fields, 0, arrayOfCachedField, 0, b);
/* 258 */         System.arraycopy(this.fields, b + 1, arrayOfCachedField, b, arrayOfCachedField.length - b);
/* 259 */         this.fields = arrayOfCachedField;
/* 260 */         this.removedFields.add(cachedField.field);
/* 261 */         boolean bool1 = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 265 */     for (b = 0; b < this.copyFields.length; b++) {
/*     */       FieldSerializer.CachedField cachedField;
/* 267 */       if ((cachedField = this.copyFields[b]).name.equals(paramString)) {
/* 268 */         FieldSerializer.CachedField[] arrayOfCachedField = new FieldSerializer.CachedField[this.copyFields.length - 1];
/* 269 */         System.arraycopy(this.copyFields, 0, arrayOfCachedField, 0, b);
/* 270 */         System.arraycopy(this.copyFields, b + 1, arrayOfCachedField, b, arrayOfCachedField.length - b);
/* 271 */         this.copyFields = arrayOfCachedField;
/* 272 */         this.removedFields.add(cachedField.field);
/* 273 */         bool = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 277 */     if (!bool) {
/* 278 */       throw new IllegalArgumentException("Field \"" + paramString + "\" not found on class: " + this.serializer.type.getName());
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeField(FieldSerializer.CachedField paramCachedField) {
/* 283 */     boolean bool = false; byte b;
/* 284 */     for (b = 0; b < this.fields.length; b++) {
/*     */       FieldSerializer.CachedField cachedField;
/* 286 */       if ((cachedField = this.fields[b]) == paramCachedField) {
/* 287 */         FieldSerializer.CachedField[] arrayOfCachedField = new FieldSerializer.CachedField[this.fields.length - 1];
/* 288 */         System.arraycopy(this.fields, 0, arrayOfCachedField, 0, b);
/* 289 */         System.arraycopy(this.fields, b + 1, arrayOfCachedField, b, arrayOfCachedField.length - b);
/* 290 */         this.fields = arrayOfCachedField;
/* 291 */         this.removedFields.add(cachedField.field);
/* 292 */         boolean bool1 = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 296 */     for (b = 0; b < this.copyFields.length; b++) {
/*     */       FieldSerializer.CachedField cachedField;
/* 298 */       if ((cachedField = this.copyFields[b]) == paramCachedField) {
/* 299 */         FieldSerializer.CachedField[] arrayOfCachedField = new FieldSerializer.CachedField[this.copyFields.length - 1];
/* 300 */         System.arraycopy(this.copyFields, 0, arrayOfCachedField, 0, b);
/* 301 */         System.arraycopy(this.copyFields, b + 1, arrayOfCachedField, b, arrayOfCachedField.length - b);
/* 302 */         this.copyFields = arrayOfCachedField;
/* 303 */         this.removedFields.add(cachedField.field);
/* 304 */         bool = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 308 */     if (!bool) {
/* 309 */       throw new IllegalArgumentException("Field \"" + paramCachedField + "\" not found on class: " + this.serializer.type.getName());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void applyAnnotations(FieldSerializer.CachedField paramCachedField) {
/*     */     Field field;
/* 320 */     if ((field = paramCachedField.field).isAnnotationPresent((Class)FieldSerializer.Bind.class)) {
/* 321 */       if (paramCachedField.serializer != null) {
/* 322 */         throw new KryoException("@Bind applied to a field that already has a serializer: " + paramCachedField.field
/* 323 */             .getDeclaringClass().getName() + "." + paramCachedField.field.getName());
/*     */       }
/*     */       
/*     */       FieldSerializer.Bind bind;
/*     */       Class<Object> clazz;
/* 328 */       if ((clazz = (bind = field.<Annotation>getAnnotation(FieldSerializer.Bind.class)).valueClass()) == Object.class) clazz = null; 
/* 329 */       if (clazz != null) paramCachedField.setValueClass(clazz);
/*     */       
/*     */       Serializer serializer;
/* 332 */       if ((serializer = newSerializer(clazz, bind.serializer(), bind.serializerFactory())) != null) paramCachedField.setSerializer(serializer);
/*     */       
/* 334 */       paramCachedField.setCanBeNull(bind.canBeNull());
/* 335 */       paramCachedField.setVariableLengthEncoding(bind.variableLengthEncoding());
/* 336 */       paramCachedField.setOptimizePositive(bind.optimizePositive());
/*     */     } 
/*     */ 
/*     */     
/* 340 */     if (field.isAnnotationPresent((Class)CollectionSerializer.BindCollection.class)) {
/* 341 */       if (paramCachedField.serializer != null) {
/* 342 */         throw new KryoException("@BindCollection applied to a field that already has a serializer: " + paramCachedField.field
/* 343 */             .getDeclaringClass().getName() + "." + paramCachedField.field.getName());
/*     */       }
/* 345 */       if (!Collection.class.isAssignableFrom(field.getType())) throw new KryoException("@BindCollection can only be used with a field implementing Collection: " + 
/* 346 */             Util.className(field.getType()));
/*     */       
/*     */       CollectionSerializer.BindCollection bindCollection;
/*     */       Class<Object> clazz;
/* 350 */       if ((clazz = (bindCollection = field.<Annotation>getAnnotation(CollectionSerializer.BindCollection.class)).elementClass()) == Object.class) clazz = null; 
/* 351 */       Serializer serializer = newSerializer(clazz, bindCollection.elementSerializer(), bindCollection
/* 352 */           .elementSerializerFactory());
/*     */       
/*     */       CollectionSerializer<Collection> collectionSerializer;
/* 355 */       (collectionSerializer = new CollectionSerializer<>()).setElementsCanBeNull(bindCollection.elementsCanBeNull());
/* 356 */       if (clazz != null) collectionSerializer.setElementClass(clazz); 
/* 357 */       if (serializer != null) collectionSerializer.setElementSerializer(serializer); 
/* 358 */       paramCachedField.setSerializer(collectionSerializer);
/*     */     } 
/*     */ 
/*     */     
/* 362 */     if (field.isAnnotationPresent((Class)MapSerializer.BindMap.class)) {
/* 363 */       if (paramCachedField.serializer != null) {
/* 364 */         throw new KryoException("@BindMap applied to a field that already has a serializer: " + paramCachedField.field
/* 365 */             .getDeclaringClass().getName() + "." + paramCachedField.field.getName());
/*     */       }
/* 367 */       if (!Map.class.isAssignableFrom(field.getType())) {
/* 368 */         throw new KryoException("@BindMap can only be used with a field implementing Map: " + Util.className(field.getType()));
/*     */       }
/*     */       MapSerializer.BindMap bindMap;
/*     */       Class<Object> clazz1;
/* 372 */       if ((clazz1 = (bindMap = field.<Annotation>getAnnotation(MapSerializer.BindMap.class)).valueClass()) == Object.class) clazz1 = null; 
/* 373 */       Serializer serializer2 = newSerializer(clazz1, bindMap.valueSerializer(), bindMap
/* 374 */           .valueSerializerFactory());
/*     */       
/*     */       Class<Object> clazz2;
/* 377 */       if ((clazz2 = bindMap.keyClass()) == Object.class) clazz2 = null; 
/* 378 */       Serializer serializer1 = newSerializer(clazz2, bindMap.keySerializer(), bindMap.keySerializerFactory());
/*     */       
/*     */       MapSerializer<Map> mapSerializer;
/* 381 */       (mapSerializer = new MapSerializer<>()).setKeysCanBeNull(bindMap.keysCanBeNull());
/* 382 */       mapSerializer.setValuesCanBeNull(bindMap.valuesCanBeNull());
/* 383 */       if (clazz2 != null) mapSerializer.setKeyClass(clazz2); 
/* 384 */       if (serializer1 != null) mapSerializer.setKeySerializer(serializer1); 
/* 385 */       if (clazz1 != null) mapSerializer.setValueClass(clazz1); 
/* 386 */       if (serializer2 != null) mapSerializer.setValueSerializer(serializer2); 
/* 387 */       paramCachedField.setSerializer(mapSerializer);
/*     */     } 
/*     */   }
/*     */   private Serializer newSerializer(Class paramClass1, Class<Serializer> paramClass2, Class<SerializerFactory> paramClass3) {
/*     */     Class<SerializerFactory.ReflectionSerializerFactory> clazz;
/* 392 */     if (paramClass2 == Serializer.class) paramClass2 = null; 
/* 393 */     if (paramClass3 == SerializerFactory.class) paramClass3 = null; 
/* 394 */     if (paramClass3 == null && paramClass2 != null) clazz = SerializerFactory.ReflectionSerializerFactory.class; 
/* 395 */     if (clazz == null) return null; 
/* 396 */     return Util.newFactory(clazz, paramClass2).newSerializer(this.serializer.kryo, paramClass1);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\CachedFields.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */