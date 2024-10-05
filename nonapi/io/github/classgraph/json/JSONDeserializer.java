/*     */ package nonapi.io.github.classgraph.json;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.AbstractMap;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import nonapi.io.github.classgraph.reflection.ReflectionUtils;
/*     */ import nonapi.io.github.classgraph.types.ParseException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JSONDeserializer
/*     */ {
/*     */   private static Object jsonBasicValueToObject(Object paramObject, Type paramType, boolean paramBoolean) {
/*  72 */     if (paramObject == null)
/*  73 */       return null; 
/*  74 */     if (paramObject instanceof JSONArray || paramObject instanceof JSONObject) {
/*  75 */       throw new RuntimeException("Expected a basic value type");
/*     */     }
/*  77 */     if (paramType instanceof ParameterizedType) {
/*  78 */       if (((ParameterizedType)paramType).getRawType().getClass() == Class.class) {
/*     */         String str1;
/*  80 */         int i = (str1 = paramObject.toString()).indexOf('<');
/*  81 */         String str2 = str1.substring(0, (i < 0) ? str1.length() : i);
/*     */         try {
/*  83 */           return Class.forName(str2);
/*  84 */         } catch (ClassNotFoundException classNotFoundException) {
/*  85 */           throw new IllegalArgumentException("Could not deserialize class reference " + paramObject, classNotFoundException);
/*     */         } 
/*     */       } 
/*  88 */       throw new IllegalArgumentException("Got illegal ParameterizedType: " + classNotFoundException);
/*     */     } 
/*  90 */     if (!(classNotFoundException instanceof Class)) {
/*  91 */       throw new IllegalArgumentException("Got illegal basic value type: " + classNotFoundException);
/*     */     }
/*     */     
/*     */     Class<String> clazz;
/*  95 */     if ((clazz = (Class<String>)classNotFoundException) == String.class) {
/*  96 */       if (!(paramObject instanceof CharSequence)) {
/*  97 */         throw new IllegalArgumentException("Expected string; got " + paramObject.getClass().getName());
/*     */       }
/*  99 */       return paramObject.toString();
/*     */     } 
/* 101 */     if (clazz == CharSequence.class) {
/* 102 */       if (!(paramObject instanceof CharSequence)) {
/* 103 */         throw new IllegalArgumentException("Expected CharSequence; got " + paramObject.getClass().getName());
/*     */       }
/* 105 */       return paramObject;
/*     */     } 
/* 107 */     if (clazz == Integer.class || clazz == int.class) {
/* 108 */       if (paramBoolean && paramObject instanceof CharSequence) {
/* 109 */         return Integer.valueOf(Integer.parseInt(paramObject.toString()));
/*     */       }
/* 111 */       if (!(paramObject instanceof Integer)) {
/* 112 */         throw new IllegalArgumentException("Expected integer; got " + paramObject.getClass().getName());
/*     */       }
/* 114 */       return paramObject;
/*     */     } 
/* 116 */     if (clazz == Long.class || clazz == long.class) {
/* 117 */       boolean bool1 = paramObject instanceof Long;
/* 118 */       boolean bool2 = paramObject instanceof Integer;
/* 119 */       if (paramBoolean && paramObject instanceof CharSequence) {
/* 120 */         return Long.valueOf(bool1 ? Long.parseLong(paramObject.toString()) : Integer.parseInt(paramObject.toString()));
/*     */       }
/* 122 */       if (!bool1 && !bool2) {
/* 123 */         throw new IllegalArgumentException("Expected long; got " + paramObject.getClass().getName());
/*     */       }
/* 125 */       if (bool1) {
/* 126 */         return paramObject;
/*     */       }
/* 128 */       return Long.valueOf(((Integer)paramObject).intValue());
/*     */     } 
/*     */     
/* 131 */     if (clazz == Short.class || clazz == short.class) {
/* 132 */       if (paramBoolean && paramObject instanceof CharSequence) {
/* 133 */         return Short.valueOf(Short.parseShort(paramObject.toString()));
/*     */       }
/* 135 */       if (!(paramObject instanceof Integer)) {
/* 136 */         throw new IllegalArgumentException("Expected short; got " + paramObject.getClass().getName());
/*     */       }
/*     */       int i;
/* 139 */       if ((i = ((Integer)paramObject).intValue()) < -32768 || i > 32767) {
/* 140 */         throw new IllegalArgumentException("Expected short; got out-of-range value " + i);
/*     */       }
/* 142 */       return Short.valueOf((short)i);
/*     */     } 
/* 144 */     if (clazz == Float.class || clazz == float.class) {
/* 145 */       if (paramBoolean && paramObject instanceof CharSequence) {
/* 146 */         return Float.valueOf(Float.parseFloat(paramObject.toString()));
/*     */       }
/* 148 */       if (!(paramObject instanceof Double)) {
/* 149 */         throw new IllegalArgumentException("Expected float; got " + paramObject.getClass().getName());
/*     */       }
/*     */       double d;
/* 152 */       if ((d = ((Double)paramObject).doubleValue()) < -3.4028234663852886E38D || d > 3.4028234663852886E38D) {
/* 153 */         throw new IllegalArgumentException("Expected float; got out-of-range value " + d);
/*     */       }
/* 155 */       return Float.valueOf((float)d);
/*     */     } 
/* 157 */     if (clazz == Double.class || clazz == double.class) {
/* 158 */       if (paramBoolean && paramObject instanceof CharSequence) {
/* 159 */         return Double.valueOf(Double.parseDouble(paramObject.toString()));
/*     */       }
/* 161 */       if (!(paramObject instanceof Double)) {
/* 162 */         throw new IllegalArgumentException("Expected double; got " + paramObject.getClass().getName());
/*     */       }
/* 164 */       return paramObject;
/*     */     } 
/* 166 */     if (clazz == Byte.class || clazz == byte.class) {
/* 167 */       if (paramBoolean && paramObject instanceof CharSequence) {
/* 168 */         return Byte.valueOf(Byte.parseByte(paramObject.toString()));
/*     */       }
/* 170 */       if (!(paramObject instanceof Integer)) {
/* 171 */         throw new IllegalArgumentException("Expected byte; got " + paramObject.getClass().getName());
/*     */       }
/*     */       int i;
/* 174 */       if ((i = ((Integer)paramObject).intValue()) < -128 || i > 127) {
/* 175 */         throw new IllegalArgumentException("Expected byte; got out-of-range value " + i);
/*     */       }
/* 177 */       return Byte.valueOf((byte)i);
/*     */     } 
/* 179 */     if (clazz == Character.class || clazz == char.class) {
/* 180 */       if (!(paramObject instanceof CharSequence)) {
/* 181 */         throw new IllegalArgumentException("Expected character; got " + paramObject.getClass().getName());
/*     */       }
/*     */       CharSequence charSequence;
/* 184 */       if ((charSequence = (CharSequence)paramObject).length() != 1) {
/* 185 */         throw new IllegalArgumentException("Expected single character; got string");
/*     */       }
/* 187 */       return Character.valueOf(charSequence.charAt(0));
/*     */     } 
/* 189 */     if (clazz == Boolean.class || clazz == boolean.class) {
/* 190 */       if (paramBoolean && paramObject instanceof CharSequence) {
/* 191 */         return Boolean.valueOf(Boolean.parseBoolean(paramObject.toString()));
/*     */       }
/* 193 */       if (!(paramObject instanceof Boolean)) {
/* 194 */         throw new IllegalArgumentException("Expected boolean; got " + paramObject.getClass().getName());
/*     */       }
/* 196 */       return paramObject;
/* 197 */     }  if (Enum.class.isAssignableFrom(clazz)) {
/* 198 */       if (!(paramObject instanceof CharSequence)) {
/* 199 */         throw new IllegalArgumentException("Expected string for enum value; got " + paramObject
/* 200 */             .getClass().getName());
/*     */       }
/*     */       
/*     */       Object object;
/* 204 */       return object = Enum.<Enum>valueOf((Class)clazz, paramObject.toString());
/*     */     } 
/* 206 */     if (JSONUtils.getRawType((Type)classNotFoundException).isAssignableFrom(paramObject.getClass())) {
/* 207 */       return paramObject;
/*     */     }
/*     */     
/* 210 */     throw new IllegalArgumentException("Got type " + paramObject.getClass() + "; expected " + classNotFoundException);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class ObjectInstantiation
/*     */   {
/*     */     Object jsonVal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Object objectInstance;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Type type;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ObjectInstantiation(Object param1Object1, Type param1Type, Object param1Object2) {
/* 240 */       this.jsonVal = param1Object2;
/* 241 */       this.objectInstance = param1Object1;
/* 242 */       this.type = param1Type;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void populateObjectFromJsonObject(Object paramObject1, Type paramType, Object paramObject2, ClassFieldCache paramClassFieldCache, Map<CharSequence, Object> paramMap, List<Runnable> paramList) {
/*     */     TypeResolutions typeResolutions;
/*     */     Type type2;
/*     */     Class<?> clazz2;
/*     */     boolean bool7;
/*     */     Constructor constructor;
/* 267 */     if (paramObject2 == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 272 */     boolean bool1 = paramObject2 instanceof JSONObject;
/*     */     boolean bool2;
/* 274 */     if (!(bool2 = paramObject2 instanceof JSONArray) && !bool1) {
/* 275 */       throw new IllegalArgumentException("Expected JSONObject or JSONArray, got " + paramObject2
/* 276 */           .getClass().getSimpleName());
/*     */     }
/* 278 */     JSONObject jSONObject = bool1 ? (JSONObject)paramObject2 : null;
/* 279 */     paramObject2 = bool2 ? paramObject2 : null;
/*     */ 
/*     */     
/* 282 */     Class<?> clazz1 = paramObject1.getClass();
/*     */     
/*     */     boolean bool3;
/* 285 */     Map<Object, Object<?>> map = (bool3 = Map.class.isAssignableFrom(clazz1)) ? (Map)paramObject1 : null;
/*     */     
/*     */     boolean bool4;
/* 288 */     final Collection collectionInstance = (bool4 = Collection.class.isAssignableFrom(clazz1)) ? (Collection)paramObject1 : null;
/* 289 */     boolean bool5 = clazz1.isArray();
/* 290 */     boolean bool6 = (!bool3 && !bool4 && !bool5) ? true : false;
/* 291 */     if (((bool3 || bool6)) != bool1 || ((bool4 || bool5)) != bool2) {
/* 292 */       throw new IllegalArgumentException("Wrong JSON type for class " + paramObject1.getClass().getName());
/*     */     }
/*     */ 
/*     */     
/* 296 */     Type type1 = paramType;
/* 297 */     if (paramType instanceof Class) {
/* 298 */       paramType = paramType;
/* 299 */       if (Map.class.isAssignableFrom((Class<?>)paramType)) {
/* 300 */         if (!bool3) {
/* 301 */           throw new IllegalArgumentException("Got an unexpected map type");
/*     */         }
/* 303 */         type1 = paramType.getGenericSuperclass();
/* 304 */       } else if (Collection.class.isAssignableFrom((Class<?>)paramType)) {
/* 305 */         if (!bool4) {
/* 306 */           throw new IllegalArgumentException("Got an unexpected map type");
/*     */         }
/* 308 */         type1 = paramType.getGenericSuperclass();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 322 */     if (type1 instanceof Class) {
/*     */       
/* 324 */       paramType = null;
/* 325 */       type2 = null;
/* 326 */       Class clazz = (Class)type1;
/* 327 */       if (bool5) {
/*     */         
/* 329 */         bool7 = !(clazz2 = clazz.getComponentType()).isArray() ? true : false;
/*     */       } else {
/* 331 */         clazz2 = null;
/* 332 */         bool7 = false;
/*     */       } 
/* 334 */       type1 = null;
/* 335 */     } else if (type1 instanceof ParameterizedType) {
/*     */ 
/*     */       
/* 338 */       ParameterizedType parameterizedType = (ParameterizedType)type1;
/*     */ 
/*     */       
/* 341 */       int i = (typeResolutions = new TypeResolutions(parameterizedType)).resolvedTypeArguments.length;
/* 342 */       if (bool3 && i != 2) {
/* 343 */         throw new IllegalArgumentException("Wrong number of type arguments for Map: got " + i + "; expected 2");
/*     */       }
/* 345 */       if (bool4 && i != 1) {
/* 346 */         throw new IllegalArgumentException("Wrong number of type arguments for Collection: got " + i + "; expected 1");
/*     */       }
/*     */       
/* 349 */       type2 = bool3 ? typeResolutions.resolvedTypeArguments[0] : null;
/* 350 */       type1 = bool3 ? typeResolutions.resolvedTypeArguments[1] : (bool4 ? typeResolutions.resolvedTypeArguments[0] : null);
/*     */       
/* 352 */       bool7 = false;
/* 353 */       clazz2 = null;
/*     */     } else {
/* 355 */       throw new IllegalArgumentException("Got illegal type: " + type1);
/*     */     } 
/*     */     
/* 358 */     Class<?> clazz3 = (type1 == null) ? null : JSONUtils.getRawType(type1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 364 */     if (bool3 || bool4 || (bool7 && !JSONUtils.isBasicValueType(clazz2))) {
/*     */ 
/*     */ 
/*     */       
/* 368 */       if ((constructor = paramClassFieldCache.getConstructorWithSizeHintForConcreteTypeOf(bool7 ? clazz2 : clazz3)) != null) {
/*     */         
/* 370 */         clazz3 = null;
/*     */       } else {
/* 372 */         Constructor<?> constructor1 = paramClassFieldCache.getDefaultConstructorForConcreteTypeOf(bool7 ? clazz2 : clazz3);
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 378 */       constructor = null;
/* 379 */       clazz3 = null;
/*     */     } 
/*     */ 
/*     */     
/* 383 */     ClassFields classFields = bool6 ? paramClassFieldCache.get(clazz1) : null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 388 */     ArrayList<ObjectInstantiation> arrayList = null;
/*     */ 
/*     */ 
/*     */     
/* 392 */     byte b1 = (jSONObject != null) ? jSONObject.items.size() : ((paramObject2 != null) ? ((JSONArray)paramObject2).items.size() : 0);
/* 393 */     for (byte b2 = 0; b2 < b1; b2++) {
/*     */       Object object; Object object1; HashMap<Object, Object> hashMap;
/*     */       final Object<?> instantiatedItemObject;
/*     */       FieldTypeInfo fieldTypeInfo;
/* 397 */       if (jSONObject != null) {
/*     */         
/* 399 */         object = (hashMap = (HashMap)jSONObject.items.get(b2)).getKey();
/* 400 */         object1 = hashMap.getValue();
/* 401 */       } else if (paramObject2 != null) {
/* 402 */         object = null;
/* 403 */         object1 = ((JSONArray)paramObject2).items.get(b2);
/*     */       } else {
/*     */         
/* 406 */         throw new RuntimeException("This exception should not be thrown");
/*     */       } 
/* 408 */       boolean bool8 = object1 instanceof JSONObject;
/* 409 */       boolean bool9 = object1 instanceof JSONArray;
/* 410 */       JSONObject jSONObject1 = bool8 ? (JSONObject)object1 : null;
/*     */       
/* 412 */       JSONArray jSONArray = bool9 ? (JSONArray)object1 : null;
/*     */ 
/*     */ 
/*     */       
/* 416 */       if (classFields != null) {
/*     */ 
/*     */ 
/*     */         
/* 420 */         if ((fieldTypeInfo = classFields.fieldNameToFieldTypeInfo.get(object)) == null) {
/* 421 */           throw new IllegalArgumentException("Field " + clazz1.getName() + "." + object + " does not exist or is not accessible, non-final, and non-transient");
/*     */         }
/*     */       } else {
/*     */         
/* 425 */         fieldTypeInfo = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 435 */       Type type = (fieldTypeInfo != null) ? fieldTypeInfo.getFullyResolvedFieldType(typeResolutions) : (bool5 ? clazz2 : type1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 443 */       if (object1 == null) {
/*     */         
/* 445 */         hashMap = null;
/*     */       }
/* 447 */       else if (type == Object.class) {
/*     */ 
/*     */         
/* 450 */         if (hashMap != null) {
/* 451 */           hashMap = new HashMap<>();
/* 452 */           if (arrayList == null) {
/* 453 */             arrayList = new ArrayList();
/*     */           }
/* 455 */           arrayList.add(new ObjectInstantiation(hashMap, ParameterizedTypeImpl.MAP_OF_UNKNOWN_TYPE, object1));
/*     */         
/*     */         }
/* 458 */         else if (bool9) {
/* 459 */           object2 = (Object<?>)new ArrayList();
/* 460 */           if (arrayList == null) {
/* 461 */             arrayList = new ArrayList<>();
/*     */           }
/* 463 */           arrayList.add(new ObjectInstantiation(object2, ParameterizedTypeImpl.LIST_OF_UNKNOWN_TYPE, object1));
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 468 */           object2 = (Object<?>)jsonBasicValueToObject(object1, type, false);
/*     */         }
/*     */       
/*     */       }
/* 472 */       else if (JSONUtils.isBasicValueType(type)) {
/*     */         
/* 474 */         if (object2 != null || bool9) {
/* 475 */           throw new IllegalArgumentException("Got JSONObject or JSONArray type when expecting a simple value type");
/*     */         }
/*     */ 
/*     */         
/* 479 */         object2 = (Object<?>)jsonBasicValueToObject(object1, type, false);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 485 */       else if (CharSequence.class.isAssignableFrom(object1.getClass())) {
/*     */ 
/*     */ 
/*     */         
/* 489 */         if ((jSONObject1 = (JSONObject)paramMap.get(object1)) == null)
/*     */         {
/*     */           
/* 492 */           throw new IllegalArgumentException("Object id not found: " + object1);
/*     */         }
/*     */         
/* 495 */         object2 = (Object<?>)jSONObject1;
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 500 */         if (object2 == null && !bool9) {
/* 501 */           throw new IllegalArgumentException("Got simple value type when expecting a JSON object or JSON array");
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         try {
/* 510 */           boolean bool = (jSONObject1 != null) ? jSONObject1.items.size() : ((jSONArray != null) ? jSONArray.items.size() : false);
/*     */           
/* 512 */           if (type instanceof Class && ((Class)type)
/* 513 */             .isArray()) {
/*     */             
/* 515 */             if (!bool9) {
/* 516 */               throw new IllegalArgumentException("Expected JSONArray, got " + object1
/* 517 */                   .getClass().getName());
/*     */             }
/* 519 */             object2 = (Object<?>)Array.newInstance(((Class)type)
/* 520 */                 .getComponentType(), bool);
/*     */           
/*     */           }
/* 523 */           else if (bool4 || bool3 || bool7) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 530 */             object2 = (Object<?>)((constructor != null) ? constructor.newInstance(new Object[] { Integer.valueOf(bool) }) : ((clazz3 != null) ? clazz3.newInstance(new Object[0]) : null));
/*     */           }
/* 532 */           else if (fieldTypeInfo != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 538 */             if ((object2 = (Object<?>)fieldTypeInfo.getConstructorForFieldTypeWithSizeHint(type, paramClassFieldCache)) != null) {
/* 539 */               object2 = (Object<?>)object2.newInstance(new Object[] { Integer.valueOf(bool) });
/*     */             } else {
/*     */               
/* 542 */               object2 = (Object<?>)fieldTypeInfo.getDefaultConstructorForFieldType(type, paramClassFieldCache).newInstance(new Object[0]);
/*     */             } 
/* 544 */           } else if (bool5 && !bool7) {
/*     */             
/* 546 */             object2 = (Object<?>)Array.newInstance(clazz1.getComponentType(), bool);
/*     */           } else {
/*     */             
/* 549 */             throw new IllegalArgumentException("Got illegal type");
/*     */           }
/*     */         
/* 552 */         } catch (ReflectiveOperationException|SecurityException reflectiveOperationException) {
/* 553 */           throw new IllegalArgumentException("Could not instantiate type " + type, reflectiveOperationException);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 560 */         if (object1 instanceof JSONObject && 
/*     */           
/* 562 */           (jSONObject1 = (JSONObject)object1).objectId != null) {
/* 563 */           paramMap.put(jSONObject1.objectId, object2);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 568 */         if (arrayList == null) {
/* 569 */           arrayList = new ArrayList<>();
/*     */         }
/* 571 */         arrayList.add(new ObjectInstantiation(object2, type, object1));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 577 */       if (fieldTypeInfo != null) {
/* 578 */         fieldTypeInfo.setFieldValue(paramObject1, object2);
/* 579 */       } else if (map != null) {
/*     */ 
/*     */         
/* 582 */         Object object3 = jsonBasicValueToObject(object, type2, true);
/*     */         
/* 584 */         map.put(object3, object2);
/* 585 */       } else if (bool5) {
/* 586 */         Array.set(paramObject1, b2, object2);
/* 587 */       } else if (collection != null) {
/*     */ 
/*     */         
/* 590 */         paramList.add(new Runnable()
/*     */             {
/*     */               public final void run() {
/* 593 */                 collectionInstance.add(instantiatedItemObject);
/*     */               }
/*     */             });
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 600 */     if (arrayList != null) {
/* 601 */       for (Iterator<ObjectInstantiation> iterator = arrayList.iterator(); iterator.hasNext();) {
/* 602 */         populateObjectFromJsonObject((objectInstantiation = iterator.next()).objectInstance, objectInstantiation.type, objectInstantiation.jsonVal, paramClassFieldCache, paramMap, paramList);
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
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<CharSequence, Object> getInitialIdToObjectMap(Object paramObject1, Object paramObject2) {
/* 622 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 623 */     if (paramObject2 instanceof JSONObject && 
/*     */       
/* 625 */       !((JSONObject)(paramObject2 = paramObject2)).items.isEmpty() && (
/*     */       
/* 627 */       (String)(paramObject2 = ((JSONObject)paramObject2).items.get(0)).getKey()).equals("__ID") && ((
/*     */       
/* 629 */       paramObject2 = paramObject2.getValue()) == null || !CharSequence.class.isAssignableFrom(paramObject2.getClass()))) {
/* 630 */       hashMap.put(paramObject2, paramObject1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 635 */     return (Map)hashMap;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static <T> T deserializeObject(Class<T> paramClass, String paramString, ClassFieldCache paramClassFieldCache) {
/*     */     Object object;
/*     */     Constructor<?> constructor;
/*     */     try {
/* 663 */       object = JSONParser.parseJSON(paramString);
/* 664 */     } catch (ParseException parseException) {
/* 665 */       throw new IllegalArgumentException("Could not parse JSON", parseException);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 674 */       Constructor<?> constructor1 = (Constructor<?>)(constructor1 = paramClassFieldCache.getDefaultConstructorForConcreteTypeOf(paramClass)).newInstance(new Object[0]);
/* 675 */     } catch (ReflectiveOperationException|SecurityException reflectiveOperationException) {
/* 676 */       throw new IllegalArgumentException("Could not construct object of type " + paramClass.getName(), reflectiveOperationException);
/*     */     } 
/*     */ 
/*     */     
/* 680 */     ArrayList<Runnable> arrayList = new ArrayList();
/* 681 */     populateObjectFromJsonObject(constructor, paramClass, object, paramClassFieldCache, 
/* 682 */         getInitialIdToObjectMap(constructor, object), arrayList);
/* 683 */     for (Iterator<Runnable> iterator = arrayList.iterator(); iterator.hasNext();) {
/* 684 */       (runnable = iterator.next()).run();
/*     */     }
/* 686 */     return (T)constructor;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> T deserializeObject(Class<T> paramClass, String paramString, ReflectionUtils paramReflectionUtils) {
/* 706 */     ClassFieldCache classFieldCache = new ClassFieldCache(true, false, paramReflectionUtils);
/*     */     
/* 708 */     return deserializeObject(paramClass, paramString, classFieldCache);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> T deserializeObject(Class<T> paramClass, String paramString) {
/* 727 */     return deserializeObject(paramClass, paramString, new ReflectionUtils());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void deserializeToField(Object<Runnable> paramObject, String paramString1, String paramString2, ClassFieldCache paramClassFieldCache) {
/*     */     Object object;
/* 749 */     if (paramObject == null) {
/* 750 */       throw new IllegalArgumentException("Cannot deserialize to a field of a null object");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 756 */       object = JSONParser.parseJSON(paramString2);
/* 757 */     } catch (ParseException parseException) {
/* 758 */       throw new IllegalArgumentException("Could not parse JSON", parseException);
/*     */     } 
/*     */     
/*     */     JSONObject jSONObject;
/*     */     
/* 763 */     (jSONObject = new JSONObject(1)).items.add(new AbstractMap.SimpleEntry<>(paramString1, object));
/*     */ 
/*     */ 
/*     */     
/* 767 */     ArrayList<Runnable> arrayList = new ArrayList();
/* 768 */     populateObjectFromJsonObject(paramObject, paramObject.getClass(), jSONObject, paramClassFieldCache, new HashMap<>(), arrayList);
/*     */     
/* 770 */     for (paramObject = (Object<Runnable>)arrayList.iterator(); paramObject.hasNext();) {
/* 771 */       (runnable = paramObject.next()).run();
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void deserializeToField(Object paramObject, String paramString1, String paramString2, ReflectionUtils paramReflectionUtils) {
/* 791 */     ClassFieldCache classFieldCache = new ClassFieldCache(true, false, paramReflectionUtils);
/*     */     
/* 793 */     deserializeToField(paramObject, paramString1, paramString2, classFieldCache);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void deserializeToField(Object paramObject, String paramString1, String paramString2) {
/* 812 */     deserializeToField(paramObject, paramString1, paramString2, new ReflectionUtils());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\json\JSONDeserializer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */