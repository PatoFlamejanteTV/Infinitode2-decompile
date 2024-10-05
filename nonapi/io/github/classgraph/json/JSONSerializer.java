/*     */ package nonapi.io.github.classgraph.json;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.AbstractMap;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import nonapi.io.github.classgraph.reflection.ReflectionUtils;
/*     */ import nonapi.io.github.classgraph.utils.CollectionUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class JSONSerializer
/*     */ {
/*     */   private static void assignObjectIds(Object paramObject, Map<ReferenceEqualityKey<Object>, JSONObject> paramMap, ClassFieldCache paramClassFieldCache, Map<ReferenceEqualityKey<JSONReference>, CharSequence> paramMap1, AtomicInteger paramAtomicInteger, boolean paramBoolean) {
/*  82 */     if (paramObject instanceof JSONObject) {
/*  83 */       for (Iterator<Map.Entry<String, Object>> iterator = ((JSONObject)paramObject).items.iterator(); iterator.hasNext();)
/*  84 */         assignObjectIds((entry = iterator.next()).getValue(), paramMap, paramClassFieldCache, paramMap1, paramAtomicInteger, paramBoolean); 
/*     */       return;
/*     */     } 
/*  87 */     if (paramObject instanceof JSONArray) {
/*  88 */       for (Iterator<Object> iterator = ((JSONArray)paramObject).items.iterator(); iterator.hasNext();)
/*  89 */         assignObjectIds(object = iterator.next(), paramMap, paramClassFieldCache, paramMap1, paramAtomicInteger, paramBoolean); 
/*     */       return;
/*     */     } 
/*  92 */     if (paramObject instanceof JSONReference) {
/*     */       Object object;
/*     */       
/*  95 */       if ((object = ((JSONReference)paramObject).idObject) == null)
/*     */       {
/*  97 */         throw new RuntimeException("Internal inconsistency");
/*     */       }
/*     */       
/* 100 */       ReferenceEqualityKey referenceEqualityKey = new ReferenceEqualityKey(object);
/*     */       JSONObject jSONObject;
/* 102 */       if ((jSONObject = paramMap.get(referenceEqualityKey)) == null)
/*     */       {
/* 104 */         throw new RuntimeException("Internal inconsistency");
/*     */       }
/*     */ 
/*     */       
/* 108 */       Field field = (paramClassFieldCache.get(object.getClass())).idField;
/* 109 */       CharSequence charSequence = null;
/* 110 */       if (field != null) {
/*     */         
/*     */         try {
/*     */           
/* 114 */           if ((object = field.get(object)) != null) {
/* 115 */             charSequence = object.toString();
/* 116 */             jSONObject.objectId = charSequence;
/*     */           } 
/* 118 */         } catch (IllegalArgumentException|IllegalAccessException illegalArgumentException) {
/*     */           
/* 120 */           throw new IllegalArgumentException("Could not access @Id-annotated field " + field, illegalArgumentException);
/*     */         } 
/*     */       }
/* 123 */       if (charSequence == null)
/*     */       {
/* 125 */         if (jSONObject.objectId == null) {
/*     */           
/* 127 */           charSequence = "[#" + paramAtomicInteger.getAndIncrement() + "]";
/* 128 */           jSONObject.objectId = charSequence;
/*     */         } else {
/* 130 */           charSequence = jSONObject.objectId;
/*     */         } 
/*     */       }
/*     */       
/* 134 */       paramMap1.put(new ReferenceEqualityKey<>((JSONReference)paramObject), charSequence);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void convertVals(Object[] paramArrayOfObject, Set<ReferenceEqualityKey<Object>> paramSet1, Set<ReferenceEqualityKey<Object>> paramSet2, ClassFieldCache paramClassFieldCache, Map<ReferenceEqualityKey<Object>, JSONObject> paramMap, boolean paramBoolean) {
/* 167 */     ReferenceEqualityKey[] arrayOfReferenceEqualityKey = new ReferenceEqualityKey[paramArrayOfObject.length];
/* 168 */     boolean[] arrayOfBoolean = new boolean[paramArrayOfObject.length]; byte b;
/* 169 */     for (b = 0; b < paramArrayOfObject.length; b++) {
/* 170 */       Object object = paramArrayOfObject[b];
/*     */       
/* 172 */       arrayOfBoolean[b] = !JSONUtils.isBasicValueType(object);
/* 173 */       if (arrayOfBoolean[b] && !JSONUtils.isCollectionOrArray(object)) {
/*     */ 
/*     */ 
/*     */         
/* 177 */         ReferenceEqualityKey<Object> referenceEqualityKey = new ReferenceEqualityKey(object);
/* 178 */         arrayOfReferenceEqualityKey[b] = referenceEqualityKey;
/*     */         boolean bool;
/* 180 */         if (bool = !paramSet2.add(referenceEqualityKey) ? true : false) {
/* 181 */           paramArrayOfObject[b] = new JSONReference(object);
/* 182 */           arrayOfBoolean[b] = false;
/*     */         } 
/*     */       } 
/*     */       
/* 186 */       if (object instanceof Class) {
/* 187 */         paramArrayOfObject[b] = ((Class)object).getName();
/*     */       }
/*     */     } 
/*     */     
/* 191 */     for (b = 0; b < paramArrayOfObject.length; b++) {
/* 192 */       if (arrayOfBoolean[b]) {
/*     */ 
/*     */         
/* 195 */         Object object = paramArrayOfObject[b];
/* 196 */         paramArrayOfObject[b] = toJSONGraph(object, paramSet1, paramSet2, paramClassFieldCache, paramMap, paramBoolean);
/*     */         
/* 198 */         if (!JSONUtils.isCollectionOrArray(object)) {
/*     */ 
/*     */ 
/*     */           
/* 202 */           ReferenceEqualityKey<Object> referenceEqualityKey = arrayOfReferenceEqualityKey[b];
/* 203 */           paramMap.put(referenceEqualityKey, (JSONObject)paramArrayOfObject[b]);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 213 */   private static final Comparator<Object> SET_COMPARATOR = new Comparator()
/*     */     {
/*     */       public final int compare(Object param1Object1, Object param1Object2) {
/* 216 */         if (param1Object1 == null || param1Object2 == null) {
/* 217 */           return ((param1Object1 == null) ? 0 : 1) - ((param1Object2 == null) ? 0 : 1);
/*     */         }
/* 219 */         if (Comparable.class.isAssignableFrom(param1Object1.getClass()) && Comparable.class
/* 220 */           .isAssignableFrom(param1Object2.getClass()))
/*     */         {
/*     */           
/* 223 */           return (param1Object1 = param1Object1).compareTo(param1Object2);
/*     */         }
/*     */ 
/*     */         
/* 227 */         return param1Object1.toString().compareTo(param1Object2.toString());
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Object toJSONGraph(Object paramObject, Set<ReferenceEqualityKey<Object>> paramSet1, Set<ReferenceEqualityKey<Object>> paramSet2, ClassFieldCache paramClassFieldCache, Map<ReferenceEqualityKey<Object>, JSONObject> paramMap, boolean paramBoolean) {
/*     */     byte b;
/*     */     int i;
/*     */     String[] arrayOfString;
/* 255 */     if (paramObject instanceof Class) {
/* 256 */       return ((Class)paramObject).getName();
/*     */     }
/*     */ 
/*     */     
/* 260 */     if (JSONUtils.isBasicValueType(paramObject)) {
/* 261 */       return paramObject;
/*     */     }
/*     */ 
/*     */     
/* 265 */     ReferenceEqualityKey<Object> referenceEqualityKey = new ReferenceEqualityKey(paramObject);
/* 266 */     if (!paramSet1.add(referenceEqualityKey)) {
/*     */       
/* 268 */       if (JSONUtils.isCollectionOrArray(paramObject))
/*     */       {
/*     */ 
/*     */         
/* 272 */         throw new IllegalArgumentException("Cycles involving collections cannot be serialized, since collections are not assigned object ids. Reached cycle at: " + paramObject);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 277 */       return new JSONReference(paramObject);
/*     */     } 
/*     */ 
/*     */     
/*     */     Class<?> clazz;
/*     */     
/* 283 */     boolean bool = (clazz = paramObject.getClass()).isArray();
/*     */     
/* 285 */     if (Map.class.isAssignableFrom(clazz)) {
/* 286 */       Map map = (Map)paramObject;
/*     */ 
/*     */       
/*     */       ArrayList<?> arrayList;
/*     */       
/* 291 */       i = (arrayList = new ArrayList(map.keySet())).size();
/* 292 */       boolean bool1 = false;
/* 293 */       Object object = null;
/* 294 */       for (bool = false; bool < i && object == null; bool++) {
/* 295 */         object = arrayList.get(bool);
/*     */       }
/* 297 */       if (object != null && Comparable.class.isAssignableFrom(object.getClass())) {
/* 298 */         CollectionUtils.sortIfNotEmpty(arrayList);
/* 299 */         bool1 = true;
/*     */       } 
/*     */ 
/*     */       
/* 303 */       arrayOfString = new String[i];
/* 304 */       for (byte b1 = 0; b1 < i; b1++) {
/*     */         Object object1;
/* 306 */         if ((object1 = arrayList.get(b1)) != null && !JSONUtils.isBasicValueType(object1)) {
/* 307 */           throw new IllegalArgumentException("Map key of type " + object1.getClass().getName() + " is not a basic type (String, Integer, etc.), so can't be easily serialized as a JSON associative array key");
/*     */         }
/*     */ 
/*     */         
/* 311 */         arrayOfString[b1] = JSONUtils.escapeJSONString((object1 == null) ? "null" : object1.toString());
/*     */       } 
/*     */ 
/*     */       
/* 315 */       if (!bool1) {
/* 316 */         Arrays.sort((Object[])arrayOfString);
/*     */       }
/*     */ 
/*     */       
/* 320 */       Object[] arrayOfObject = new Object[i];
/* 321 */       for (byte b2 = 0; b2 < i; b2++) {
/* 322 */         arrayOfObject[b2] = map.get(arrayList.get(b2));
/*     */       }
/* 324 */       convertVals(arrayOfObject, paramSet1, paramSet2, paramClassFieldCache, paramMap, paramBoolean);
/*     */ 
/*     */ 
/*     */       
/* 328 */       ArrayList<Map.Entry<String, Object>> arrayList1 = new ArrayList(i);
/* 329 */       for (b = 0; b < i; b++) {
/* 330 */         arrayList1.add(new AbstractMap.SimpleEntry<>(arrayOfString[b], arrayOfObject[b]));
/*     */       }
/* 332 */       paramObject = new JSONObject(arrayList1);
/*     */     }
/* 334 */     else if (arrayOfString != null || List.class.isAssignableFrom(i)) {
/*     */       boolean bool1;
/*     */ 
/*     */       
/*     */       List list;
/*     */ 
/*     */       
/* 341 */       Object[] arrayOfObject = new Object[i = ((list = (List)((bool1 = List.class.isAssignableFrom(i)) ? paramObject : null)) != null) ? list.size() : ((arrayOfString != null) ? Array.getLength(paramObject) : 0)];
/* 342 */       for (byte b1 = 0; b1 < i; b1++) {
/* 343 */         arrayOfObject[b1] = (list != null) ? list.get(b1) : ((arrayOfString != null) ? Array.get(paramObject, b1) : Integer.valueOf(0));
/*     */       }
/* 345 */       convertVals(arrayOfObject, paramSet1, b, paramClassFieldCache, paramMap, paramBoolean);
/*     */ 
/*     */ 
/*     */       
/* 349 */       paramObject = new JSONArray(Arrays.asList(arrayOfObject));
/*     */     } else {
/* 351 */       Object[] arrayOfObject; if (Collection.class.isAssignableFrom(i)) {
/* 352 */         Collection<?> collection = (Collection)paramObject;
/*     */ 
/*     */         
/* 355 */         ArrayList arrayList = new ArrayList(collection);
/* 356 */         if (Set.class.isAssignableFrom(i)) {
/* 357 */           CollectionUtils.sortIfNotEmpty(arrayList, SET_COMPARATOR);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 362 */         convertVals(arrayOfObject = arrayList.toArray(), paramSet1, b, paramClassFieldCache, paramMap, paramBoolean);
/*     */ 
/*     */ 
/*     */         
/* 366 */         paramObject = new JSONArray(Arrays.asList(arrayOfObject));
/*     */       } else {
/*     */         int j;
/*     */ 
/*     */         
/*     */         ClassFields classFields;
/*     */ 
/*     */         
/*     */         List<FieldTypeInfo> list;
/*     */ 
/*     */         
/* 377 */         String[] arrayOfString1 = new String[j = (list = (classFields = paramClassFieldCache.get((Class<?>)arrayOfObject)).fieldOrder).size()];
/* 378 */         Object[] arrayOfObject1 = new Object[j];
/* 379 */         for (byte b1 = 0; b1 < j; b1++) {
/*     */           FieldTypeInfo fieldTypeInfo;
/* 381 */           Field field = (fieldTypeInfo = list.get(b1)).field;
/* 382 */           arrayOfString1[b1] = field.getName();
/*     */           try {
/* 384 */             arrayOfObject1[b1] = JSONUtils.getFieldValue(paramObject, field);
/* 385 */           } catch (IllegalArgumentException|IllegalAccessException illegalArgumentException) {
/* 386 */             throw new RuntimeException("Could not get value of field \"" + arrayOfString1[b1] + "\" in object of class " + paramObject
/* 387 */                 .getClass().getName(), illegalArgumentException);
/*     */           } 
/*     */         } 
/* 390 */         convertVals(arrayOfObject1, paramSet1, (Set<ReferenceEqualityKey<Object>>)illegalArgumentException, paramClassFieldCache, paramMap, paramBoolean);
/*     */ 
/*     */ 
/*     */         
/* 394 */         ArrayList<Map.Entry<String, Object>> arrayList = new ArrayList(j);
/* 395 */         for (byte b2 = 0; b2 < j; b2++) {
/* 396 */           arrayList.add(new AbstractMap.SimpleEntry<>(arrayOfString1[b2], arrayOfObject1[b2]));
/*     */         }
/* 398 */         paramObject = new JSONObject(arrayList);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 404 */     paramSet1.remove(referenceEqualityKey);
/*     */     
/* 406 */     return paramObject;
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
/*     */   
/*     */   static void jsonValToJSONString(Object paramObject, Map<ReferenceEqualityKey<JSONReference>, CharSequence> paramMap, boolean paramBoolean, int paramInt1, int paramInt2, StringBuilder paramStringBuilder) {
/* 432 */     if (paramObject == null) {
/* 433 */       paramStringBuilder.append("null"); return;
/*     */     } 
/* 435 */     if (paramObject instanceof JSONObject) {
/*     */       
/* 437 */       ((JSONObject)paramObject).toJSONString(paramMap, paramBoolean, paramInt1, paramInt2, paramStringBuilder);
/*     */       return;
/*     */     } 
/* 440 */     if (paramObject instanceof JSONArray) {
/*     */       
/* 442 */       ((JSONArray)paramObject).toJSONString(paramMap, paramBoolean, paramInt1, paramInt2, paramStringBuilder); return;
/*     */     } 
/* 444 */     if (paramObject instanceof JSONReference) {
/*     */ 
/*     */ 
/*     */       
/* 448 */       jsonValToJSONString(paramObject = paramMap.get(new ReferenceEqualityKey<>((JSONReference)paramObject)), paramMap, paramBoolean, paramInt1, paramInt2, paramStringBuilder);
/*     */       return;
/*     */     } 
/* 451 */     if (paramObject instanceof CharSequence || paramObject instanceof Character || paramObject.getClass().isEnum()) {
/*     */       
/* 453 */       paramStringBuilder.append('"');
/* 454 */       JSONUtils.escapeJSONString(paramObject.toString(), paramStringBuilder);
/* 455 */       paramStringBuilder.append('"');
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 460 */     paramStringBuilder.append(paramObject);
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
/*     */   
/*     */   public static String serializeObject(Object paramObject, int paramInt, boolean paramBoolean, ClassFieldCache paramClassFieldCache) {
/* 486 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*     */     
/* 488 */     paramObject = toJSONGraph(paramObject, new HashSet<>(), new HashSet<>(), paramClassFieldCache, (Map)hashMap1, paramBoolean);
/*     */ 
/*     */ 
/*     */     
/* 492 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/* 493 */     AtomicInteger atomicInteger = new AtomicInteger(0);
/* 494 */     assignObjectIds(paramObject, (Map)hashMap1, paramClassFieldCache, (Map)hashMap2, atomicInteger, paramBoolean);
/*     */ 
/*     */     
/* 497 */     StringBuilder stringBuilder = new StringBuilder(32768);
/* 498 */     jsonValToJSONString(paramObject, (Map)hashMap2, false, 0, paramInt, stringBuilder);
/*     */     
/* 500 */     return stringBuilder.toString();
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
/*     */   public static String serializeObject(Object paramObject, int paramInt, boolean paramBoolean, ReflectionUtils paramReflectionUtils) {
/* 520 */     return serializeObject(paramObject, paramInt, paramBoolean, new ClassFieldCache(false, false, paramReflectionUtils));
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
/*     */   public static String serializeObject(Object paramObject, int paramInt, boolean paramBoolean) {
/* 541 */     return serializeObject(paramObject, paramInt, paramBoolean, new ReflectionUtils());
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
/*     */   public static String serializeObject(Object paramObject) {
/* 555 */     return serializeObject(paramObject, 0, false);
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
/*     */   public static String serializeFromField(Object paramObject, String paramString, int paramInt, boolean paramBoolean, ClassFieldCache paramClassFieldCache) {
/*     */     FieldTypeInfo fieldTypeInfo;
/* 581 */     if ((fieldTypeInfo = (paramClassFieldCache.get(paramObject.getClass())).fieldNameToFieldTypeInfo.get(paramString)) == null) {
/* 582 */       throw new IllegalArgumentException("Class " + paramObject.getClass().getName() + " does not have a field named \"" + paramString + "\"");
/*     */     }
/*     */     
/*     */     Field field;
/* 586 */     if (!JSONUtils.fieldIsSerializable(field = fieldTypeInfo.field, false, paramClassFieldCache.reflectionUtils))
/*     */     {
/* 588 */       throw new IllegalArgumentException("Field " + paramObject.getClass().getName() + "." + paramString + " needs to be accessible, non-transient, and non-final");
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 593 */       paramObject = JSONUtils.getFieldValue(paramObject, field);
/* 594 */     } catch (IllegalAccessException illegalAccessException) {
/* 595 */       throw new IllegalArgumentException("Could get value of field " + paramString, illegalAccessException);
/*     */     } 
/* 597 */     return serializeObject(illegalAccessException, paramInt, paramBoolean, paramClassFieldCache);
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
/*     */   public static String serializeFromField(Object paramObject, String paramString, int paramInt, boolean paramBoolean, ReflectionUtils paramReflectionUtils) {
/* 621 */     ClassFieldCache classFieldCache = new ClassFieldCache(false, paramBoolean, paramReflectionUtils);
/*     */     
/* 623 */     return serializeFromField(paramObject, paramString, paramInt, paramBoolean, classFieldCache);
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
/*     */   public static String serializeFromField(Object paramObject, String paramString, int paramInt, boolean paramBoolean) {
/* 645 */     return serializeFromField(paramObject, paramString, paramInt, paramBoolean, new ReflectionUtils());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\json\JSONSerializer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */