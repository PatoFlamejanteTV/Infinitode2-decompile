/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.IdentityMap;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashSet;
/*     */ import java.util.WeakHashMap;
/*     */ 
/*     */ 
/*     */ public final class ReflectionUtils
/*     */ {
/*  21 */   private static final TLog a = TLog.forClass(ReflectionUtils.class);
/*     */   
/*  23 */   private static final IdentityMap<Class<?>, Constructor<?>> b = new IdentityMap();
/*  24 */   private static final ObjectMap<Class<?>, Array<Field>> c = new ObjectMap();
/*  25 */   private static final ObjectMap<Field, EnumKeyArray> d = new ObjectMap();
/*  26 */   private static final WeakHashMap<String, Class<?>> e = new WeakHashMap<>(); public static final Comparator<Field> FIELD_COMPARATOR; public static final Comparator<Constructor<?>> CONSTRUCTOR_COMPARATOR; public static final Comparator<Method> METHOD_COMPARATOR;
/*     */   static {
/*  28 */     FIELD_COMPARATOR = ((paramField1, paramField2) -> paramField1.getName().compareTo(paramField2.getName()));
/*     */     
/*  30 */     CONSTRUCTOR_COMPARATOR = ((paramConstructor1, paramConstructor2) -> {
/*     */         int i;
/*     */         
/*     */         if ((i = paramConstructor1.getName().compareTo(paramConstructor2.getName())) == 0) {
/*     */           Class[] arrayOfClass1 = paramConstructor1.getParameterTypes();
/*     */           
/*     */           Class[] arrayOfClass2 = paramConstructor2.getParameterTypes();
/*     */           
/*     */           if ((i = Integer.compare(arrayOfClass1.length, arrayOfClass2.length)) == 0) {
/*     */             for (byte b = 0; b < arrayOfClass1.length; b++) {
/*     */               Class clazz1 = arrayOfClass1[b];
/*     */               
/*     */               Class clazz2 = arrayOfClass2[b];
/*     */               
/*     */               String str2 = clazz1.getSimpleName();
/*     */               
/*     */               String str1 = clazz2.getSimpleName();
/*     */               
/*     */               if ((i = Integer.compare(str2.length(), str1.length())) != 0) {
/*     */                 return i;
/*     */               }
/*     */               for (byte b1 = 0; b1 < str2.length(); b1++) {
/*     */                 if ((i = Integer.compare(str2.charAt(b1), str1.charAt(b1))) != 0) {
/*     */                   return i;
/*     */                 }
/*     */               } 
/*     */             } 
/*     */             return 0;
/*     */           } 
/*     */           return i;
/*     */         } 
/*     */         return i;
/*     */       });
/*  63 */     METHOD_COMPARATOR = ((paramMethod1, paramMethod2) -> {
/*     */         int i;
/*     */         if ((i = paramMethod1.getName().compareTo(paramMethod2.getName())) == 0) {
/*     */           Class[] arrayOfClass1 = paramMethod1.getParameterTypes();
/*     */           Class[] arrayOfClass2 = paramMethod2.getParameterTypes();
/*     */           if ((i = Integer.compare(arrayOfClass1.length, arrayOfClass2.length)) == 0) {
/*     */             for (byte b = 0; b < arrayOfClass1.length; b++) {
/*     */               Class clazz1 = arrayOfClass1[b];
/*     */               Class clazz2 = arrayOfClass2[b];
/*     */               String str2 = clazz1.getSimpleName();
/*     */               String str1 = clazz2.getSimpleName();
/*     */               if ((i = Integer.compare(str2.length(), str1.length())) != 0) {
/*     */                 return i;
/*     */               }
/*     */               for (byte b1 = 0; b1 < str2.length(); b1++) {
/*     */                 if ((i = Integer.compare(str2.charAt(b1), str1.charAt(b1))) != 0) {
/*     */                   return i;
/*     */                 }
/*     */               } 
/*     */             } 
/*     */             return 0;
/*     */           } 
/*     */           return i;
/*     */         } 
/*     */         return i;
/*     */       });
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
/*     */   public static synchronized <T> T newObject(Class<T> paramClass) {
/*     */     Constructor<T> constructor;
/* 105 */     if ((constructor = (Constructor)b.get(paramClass)) == null) {
/*     */       try {
/* 107 */         constructor = paramClass.getConstructor(new Class[0]);
/* 108 */         b.put(paramClass, constructor);
/* 109 */       } catch (NoSuchMethodException noSuchMethodException) {
/* 110 */         throw new IllegalArgumentException(paramClass + " has no simple (no-arg) constructor");
/*     */       } 
/*     */     }
/*     */     
/*     */     try {
/* 115 */       return constructor.newInstance(new Object[0]);
/* 116 */     } catch (Exception exception) {
/* 117 */       throw new IllegalStateException("Can not create new instance of " + paramClass, exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static synchronized Array<Field> getAllSerializableFields(Class<?> paramClass) {
/* 123 */     Class<?> clazz = paramClass;
/*     */     
/*     */     Array<Field> array;
/* 126 */     if ((array = (Array)c.get(paramClass, null)) != null) {
/* 127 */       return array;
/*     */     }
/*     */     
/* 130 */     array = new Array(Field.class);
/*     */     
/* 132 */     while (paramClass != null && paramClass != Object.class) {
/*     */       Field[] arrayOfField; int i; byte b;
/* 134 */       for (i = (arrayOfField = arrayOfField = paramClass.getDeclaredFields()).length, b = 0; b < i; ) {
/* 135 */         Field field; if (!isFieldIgnoredBySerialization(field = arrayOfField[b]) && 
/* 136 */           !array.contains(field, true)) {
/*     */           try {
/* 138 */             field.setAccessible(true);
/* 139 */           } catch (Exception exception) {}
/* 140 */           array.add(field);
/*     */         } 
/*     */         b++;
/*     */       } 
/* 144 */       paramClass = paramClass.getSuperclass();
/*     */     } 
/*     */     
/* 147 */     Threads.sortGdxArray(array, FIELD_COMPARATOR);
/*     */     
/* 149 */     c.put(clazz, array);
/*     */     
/* 151 */     return array;
/*     */   }
/*     */   
/*     */   public static boolean isFieldIgnoredBySerialization(Field paramField) {
/* 155 */     if (Modifier.isStatic(paramField.getModifiers()) || paramField
/* 156 */       .isAnnotationPresent((Class)NAGS.class) || paramField
/* 157 */       .getType().isAnnotationPresent((Class)NAGS.class)) return true; 
/*     */     return false;
/*     */   }
/*     */   public static synchronized EnumKeyArray getEnumKeyArrayFieldAnnotationCached(Field paramField) {
/* 161 */     if (paramField.isAnnotationPresent((Class)EnumKeyArray.class)) {
/* 162 */       if (d.containsKey(paramField)) {
/* 163 */         return (EnumKeyArray)d.get(paramField);
/*     */       }
/*     */       
/* 166 */       EnumKeyArray enumKeyArray = paramField.<EnumKeyArray>getAnnotation(EnumKeyArray.class);
/* 167 */       d.put(paramField, enumKeyArray);
/*     */       
/* 169 */       return enumKeyArray;
/*     */     } 
/* 171 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized Class<?> getClassByName(String paramString) {
/*     */     Class<boolean> clazz;
/*     */     Class<int> clazz1;
/* 180 */     if ((clazz1 = (Class)e.get(paramString)) == null) {
/*     */       Class<short> clazz7; Class<long> clazz6; Class<byte> clazz5; Class<char> clazz4; Class<float> clazz3; Class<double> clazz2;
/* 182 */       clazz1 = null;
/* 183 */       switch (paramString) {
/*     */         case "int":
/* 185 */           clazz1 = int.class;
/*     */           break;
/*     */         
/*     */         case "short":
/* 189 */           clazz7 = short.class;
/*     */           break;
/*     */         
/*     */         case "long":
/* 193 */           clazz6 = long.class;
/*     */           break;
/*     */         
/*     */         case "byte":
/* 197 */           clazz5 = byte.class;
/*     */           break;
/*     */         
/*     */         case "char":
/* 201 */           clazz4 = char.class;
/*     */           break;
/*     */         
/*     */         case "float":
/* 205 */           clazz3 = float.class;
/*     */           break;
/*     */         
/*     */         case "double":
/* 209 */           clazz2 = double.class;
/*     */           break;
/*     */         
/*     */         case "boolean":
/* 213 */           clazz = boolean.class;
/*     */           break;
/*     */       } 
/*     */       
/* 217 */       if (clazz != null) {
/*     */         
/* 219 */         e.put(paramString, clazz);
/* 220 */         return clazz;
/*     */       } 
/*     */       try {
/* 223 */         clazz = (Class)Class.forName(paramString);
/* 224 */         e.put(paramString, clazz);
/* 225 */         return clazz;
/* 226 */       } catch (ClassNotFoundException classNotFoundException) {
/* 227 */         e.put(paramString, UnknownClass.class);
/* 228 */         return null;
/*     */       } 
/*     */     } 
/* 231 */     if (clazz == UnknownClass.class)
/*     */     {
/* 233 */       return null;
/*     */     }
/* 235 */     return clazz;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isFirstOverridesSecond(Class<?> paramClass1, Class<?> paramClass2) {
/* 240 */     if (paramClass2 == Object.class) {
/* 241 */       return true;
/*     */     }
/*     */     
/* 244 */     if (paramClass1.isInterface() && !paramClass2.isInterface()) {
/* 245 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 249 */     Class<?> clazz = paramClass1.getSuperclass();
/* 250 */     while (clazz != null) {
/* 251 */       if (paramClass2 == clazz) return true; 
/* 252 */       clazz = clazz.getSuperclass();
/*     */     } 
/*     */ 
/*     */     
/* 256 */     return paramClass2.isAssignableFrom(paramClass1);
/*     */   }
/*     */   
/*     */   public static final class LuaRelated { private static void a(Class<?> param1Class, int param1Int1, StringBuilder param1StringBuilder, int param1Int2) {
/*     */       String str;
/* 261 */       byte b = 0;
/* 262 */       while (param1Class.isArray()) {
/* 263 */         b++;
/* 264 */         param1Class = param1Class.getComponentType();
/*     */       } 
/* 266 */       param1StringBuilder.append('_');
/* 267 */       if (param1Int1 != 1) {
/* 268 */         param1StringBuilder.append(param1Int1);
/*     */       }
/*     */ 
/*     */       
/* 272 */       if (param1Class == int.class) {
/* 273 */         str = "i";
/* 274 */       } else if (str == float.class) {
/* 275 */         str = "f";
/* 276 */       } else if (str == double.class) {
/* 277 */         str = "d";
/* 278 */       } else if (str == long.class) {
/* 279 */         str = "l";
/* 280 */       } else if (str == char.class) {
/* 281 */         str = "c";
/* 282 */       } else if (str == byte.class) {
/* 283 */         str = "byte";
/* 284 */       } else if (str == boolean.class) {
/* 285 */         str = "b";
/* 286 */       } else if (str == short.class) {
/* 287 */         str = "s";
/*     */       
/*     */       }
/* 290 */       else if (param1Int2 <= 1) {
/* 291 */         StringBuilder stringBuilder = new StringBuilder();
/* 292 */         str = str.getSimpleName();
/* 293 */         for (param1Int2 = 0; param1Int2 < str.length(); param1Int2++) {
/*     */           char c;
/* 295 */           if (Character.isUpperCase(c = str.charAt(param1Int2)) || Character.isDigit(c)) {
/* 296 */             stringBuilder.append(c);
/*     */           }
/*     */         } 
/* 299 */         if (stringBuilder.length != 0) {
/* 300 */           str = stringBuilder.toString();
/*     */         }
/*     */       } else {
/*     */         
/* 304 */         str = str.getSimpleName();
/*     */       } 
/*     */       
/* 307 */       param1StringBuilder.append(str);
/*     */       
/* 309 */       for (param1Int1 = 0; param1Int1 < b; param1Int1++) {
/* 310 */         param1StringBuilder.append("Arr");
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static Array<String> generateOverloadSuffixForTypeArray(Array<ObjectPair<Object, Array<Class<?>>>> param1Array, int param1Int) {
/* 318 */       Array<String> array = new Array(true, param1Array.size, String.class);
/* 319 */       for (byte b = 0; b < param1Array.size; b++) {
/* 320 */         param1Array.get(b);
/*     */         
/*     */         Array array1;
/* 323 */         if ((array1 = (Array)((ObjectPair)param1Array.get(b)).second).size == 0) {
/* 324 */           array.add("");
/*     */         } else {
/* 326 */           StringBuilder stringBuilder = new StringBuilder();
/* 327 */           Class<?> clazz = null;
/* 328 */           byte b1 = 0;
/* 329 */           for (Array.ArrayIterator<Class<?>> arrayIterator = array1.iterator(); arrayIterator.hasNext(); ) { Class<?> clazz1 = arrayIterator.next();
/* 330 */             if (clazz == clazz1) {
/* 331 */               b1++;
/*     */               continue;
/*     */             } 
/* 334 */             if (b1 != 0) {
/* 335 */               a(clazz, b1, stringBuilder, param1Int);
/*     */             }
/* 337 */             b1 = 1;
/* 338 */             clazz = clazz1; }
/*     */ 
/*     */           
/* 341 */           if (b1 != 0) {
/* 342 */             a(clazz, b1, stringBuilder, param1Int);
/*     */           }
/*     */           
/* 345 */           String str = stringBuilder.toString();
/* 346 */           if (array.contains(str, false))
/*     */           {
/*     */ 
/*     */             
/* 350 */             return generateOverloadSuffixForTypeArray(param1Array, param1Int + 1);
/*     */           }
/* 352 */           array.add(str);
/*     */         } 
/*     */       } 
/* 355 */       return array;
/*     */     }
/*     */ 
/*     */     
/*     */     public static Array<String> generateOverloadSuffixForMethods(Array<Method> param1Array) {
/* 360 */       Array<ObjectPair<Object, Array<Class<?>>>> array = new Array(true, param1Array.size, ObjectPair.class);
/* 361 */       for (byte b = 0; b < param1Array.size; b++) {
/* 362 */         Method method = (Method)param1Array.get(b);
/* 363 */         array.add(new ObjectPair<>(method, new Array((Object[])method.getParameterTypes())));
/*     */       } 
/* 365 */       return generateOverloadSuffixForTypeArray(array, 1);
/*     */     }
/*     */ 
/*     */     
/*     */     public static Array<String> generateOverloadSuffixForConstructors(Array<Constructor<?>> param1Array) {
/* 370 */       Array<ObjectPair<Object, Array<Class<?>>>> array = new Array(true, param1Array.size, ObjectPair.class);
/* 371 */       for (byte b = 0; b < param1Array.size; b++) {
/* 372 */         Constructor constructor = (Constructor)param1Array.get(b);
/* 373 */         array.add(new ObjectPair<>(constructor, new Array((Object[])constructor.getParameterTypes())));
/*     */       } 
/* 375 */       return generateOverloadSuffixForTypeArray(array, 1);
/*     */     }
/*     */     
/*     */     public static Array<Class<?>> filterClasses(HashSet<Class<?>> param1HashSet, ObjectConsumer<ObjectPair<Class<?>, String>> param1ObjectConsumer) {
/* 379 */       Array<Class<?>> array = new Array(true, 1, Class.class);
/* 380 */       for (Class<?> clazz : param1HashSet) {
/*     */         try {
/* 382 */           if (clazz.isAnonymousClass()) {
/* 383 */             if (param1ObjectConsumer != null) {
/* 384 */               param1ObjectConsumer.accept(new ObjectPair<>(clazz, "anonymous"));
/*     */             }
/*     */             continue;
/*     */           } 
/* 388 */           if (!Modifier.isPublic(clazz.getModifiers())) {
/* 389 */             if (param1ObjectConsumer != null) {
/* 390 */               param1ObjectConsumer.accept(new ObjectPair<>(clazz, "not public"));
/*     */             }
/*     */             continue;
/*     */           } 
/* 394 */           if (clazz.isMemberClass() && clazz.getSimpleName().startsWith("_")) {
/* 395 */             if (param1ObjectConsumer != null) {
/* 396 */               param1ObjectConsumer.accept(new ObjectPair<>(clazz, "member class starting with underscore"));
/*     */             }
/*     */             
/*     */             continue;
/*     */           } 
/*     */           
/* 402 */           array.add(clazz);
/* 403 */         } catch (Throwable throwable) {}
/*     */       } 
/* 405 */       Threads.sortGdxArray(array, (param1Class1, param1Class2) -> param1Class1.getName().compareTo(param1Class2.getName()));
/* 406 */       return array;
/*     */     }
/*     */     
/*     */     public static Array<Field> gatherFields(Class<?> param1Class) {
/* 410 */       Array<Field> array = new Array(true, 1, Field.class); try {
/*     */         Field[] arrayOfField; int i;
/*     */         byte b;
/* 413 */         for (i = (arrayOfField = arrayOfField = param1Class.getDeclaredFields()).length, b = 0; b < i; ) {
/*     */           Field field;
/* 415 */           if (Modifier.isPublic((field = arrayOfField[b]).getModifiers()) && 
/* 416 */             !field.isAnnotationPresent((Class)Deprecated.class) && 
/* 417 */             Modifier.isPublic(field.getType().getModifiers()))
/*     */           {
/* 419 */             array.add(field); } 
/*     */           b++;
/*     */         } 
/* 422 */       } catch (Throwable throwable) {}
/* 423 */       array.sort(ReflectionUtils.FIELD_COMPARATOR);
/* 424 */       return array;
/*     */     }
/*     */     
/*     */     public static Array<Constructor<?>> gatherConstructors(Class<?> param1Class) {
/* 428 */       Array<Constructor<?>> array = new Array(true, 1, Constructor.class);
/* 429 */       if (Modifier.isAbstract(param1Class.getModifiers()))
/*     */       {
/* 431 */         return array;
/*     */       }
/*     */ 
/*     */       
/* 435 */       if (param1Class.isMemberClass() && !Modifier.isStatic(param1Class.getModifiers())) {
/* 436 */         return array;
/*     */       }
/*     */ 
/*     */       
/*     */       try {
/* 441 */         arrayOfConstructor = (Constructor[])param1Class.getDeclaredConstructors();
/* 442 */       } catch (Throwable throwable) {
/* 443 */         return array;
/*     */       }  Constructor[] arrayOfConstructor; int i; byte b;
/* 445 */       label28: for (i = (arrayOfConstructor = arrayOfConstructor).length, b = 0; b < i; b++) {
/*     */         Constructor<?> constructor; int j;
/* 447 */         if (Modifier.isPublic(j = (constructor = arrayOfConstructor[b]).getModifiers())) {
/*     */           Class[] arrayOfClass;
/*     */           
/*     */           int k;
/*     */           
/*     */           byte b1;
/* 453 */           for (k = (arrayOfClass = arrayOfClass = constructor.getParameterTypes()).length, b1 = 0; b1 < k; ) {
/* 454 */             Class<?> clazz; if (Modifier.isPublic((clazz = arrayOfClass[b1]).getModifiers())) {
/*     */               b1++;
/*     */               continue;
/*     */             } 
/*     */             continue label28;
/*     */           } 
/* 460 */           if (!constructor.isAnnotationPresent((Class)Deprecated.class))
/*     */           {
/*     */ 
/*     */ 
/*     */             
/* 465 */             array.add(constructor);
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 505 */       array.sort(ReflectionUtils.CONSTRUCTOR_COMPARATOR);
/* 506 */       return array;
/*     */     }
/*     */     
/*     */     public static Array<Method> gatherMethods(Class<?> param1Class) {
/* 510 */       DelayedRemovalArray delayedRemovalArray = new DelayedRemovalArray(true, 1, Method.class); Method[] arrayOfMethod; int j;
/*     */       byte b;
/* 512 */       label61: for (j = (arrayOfMethod = arrayOfMethod = param1Class.getDeclaredMethods()).length, b = 0; b < j; b++) {
/* 513 */         Method method; if (Modifier.isPublic((method = arrayOfMethod[b]).getModifiers())) {
/*     */           Class[] arrayOfClass1;
/*     */           
/*     */           Class[] arrayOfClass2;
/*     */           int k;
/*     */           byte b1;
/* 519 */           for (k = (arrayOfClass2 = arrayOfClass1 = method.getParameterTypes()).length, b1 = 0; b1 < k; ) {
/* 520 */             Class<?> clazz; if (Modifier.isPublic((clazz = arrayOfClass2[b1]).getModifiers())) {
/*     */               b1++;
/*     */ 
/*     */ 
/*     */               
/*     */               continue;
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/*     */             continue label61;
/*     */           } 
/*     */ 
/*     */           
/* 534 */           if (!method.isAnnotationPresent((Class)Deprecated.class))
/*     */           {
/*     */ 
/*     */             
/* 538 */             if (Modifier.isPublic(method.getReturnType().getModifiers()))
/*     */             {
/*     */               
/* 541 */               if (!method.getName().equals("finalize"))
/*     */               {
/*     */                 
/* 544 */                 delayedRemovalArray.add(method);
/*     */               }
/*     */             }
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 622 */       delayedRemovalArray.begin();
/* 623 */       for (int i = delayedRemovalArray.size - 1; i >= 0; i--) {
/* 624 */         Method method = (Method)delayedRemovalArray.get(i);
/* 625 */         for (b = 0; b < delayedRemovalArray.size; b++) {
/* 626 */           if (i != b) {
/*     */             Method method1;
/* 628 */             if ((method1 = (Method)delayedRemovalArray.get(b)) == method) {
/* 629 */               delayedRemovalArray.removeIndex(i);
/*     */               break;
/*     */             } 
/* 632 */             if (method1.getName().equals(method.getName())) {
/*     */               
/* 634 */               Class[] arrayOfClass1 = method.getParameterTypes();
/* 635 */               Class[] arrayOfClass2 = method1.getParameterTypes();
/* 636 */               if (arrayOfClass1.length == arrayOfClass2.length) {
/*     */                 
/* 638 */                 boolean bool = true;
/* 639 */                 for (byte b1 = 0; b1 < arrayOfClass1.length; b1++) {
/* 640 */                   if (arrayOfClass1[b1] != arrayOfClass2[b1]) {
/* 641 */                     bool = false;
/*     */                     break;
/*     */                   } 
/*     */                 } 
/* 645 */                 if (bool) {
/*     */                   
/* 647 */                   Class<?> clazz2 = method.getReturnType();
/* 648 */                   Class<?> clazz1 = method1.getReturnType();
/*     */                   
/* 650 */                   if (clazz2.isAssignableFrom(clazz1)) {
/*     */ 
/*     */                     
/* 653 */                     delayedRemovalArray.removeIndex(i);
/* 654 */                   } else if (clazz1.isAssignableFrom(clazz2)) {
/*     */ 
/*     */                     
/* 657 */                     delayedRemovalArray.removeIndex(b);
/*     */                   
/*     */                   }
/* 660 */                   else if (clazz2.isInterface() && !clazz1.isInterface()) {
/* 661 */                     delayedRemovalArray.removeIndex(b);
/* 662 */                   } else if (!clazz2.isInterface() && clazz1.isInterface()) {
/* 663 */                     delayedRemovalArray.removeIndex(i);
/*     */                   } else {
/* 665 */                     ReflectionUtils.a().i("/!\\ Same method signatures (" + method + ") in " + param1Class + ", return types:", new Object[0]);
/* 666 */                     ReflectionUtils.a().i("     A: " + method.getReturnType(), new Object[0]);
/* 667 */                     ReflectionUtils.a().i("     B: " + method1.getReturnType(), new Object[0]);
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 678 */       delayedRemovalArray.end();
/*     */       
/* 680 */       Threads.sortGdxArray((Array)delayedRemovalArray, ReflectionUtils.METHOD_COMPARATOR);
/*     */       
/* 682 */       return (Array<Method>)delayedRemovalArray;
/*     */     } }
/*     */ 
/*     */   
/*     */   private static final class UnknownClass {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\ReflectionUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */