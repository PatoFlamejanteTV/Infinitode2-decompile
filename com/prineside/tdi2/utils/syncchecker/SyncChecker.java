/*     */ package com.prineside.tdi2.utils.syncchecker;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.prineside.luaj.LuaBoolean;
/*     */ import com.prineside.luaj.LuaNil;
/*     */ import com.prineside.luaj.LuaNumber;
/*     */ import com.prineside.luaj.LuaString;
/*     */ import com.prineside.luaj.lib.jse.JavaClass;
/*     */ import com.prineside.luaj.lib.jse.JavaInstance;
/*     */ import com.prineside.tdi2.Action;
/*     */ import com.prineside.tdi2.BasicLevel;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.managers.GameValueManager;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.ui.shared.AbilitySelectionOverlay;
/*     */ import com.prineside.tdi2.utils.EnumKeyArray;
/*     */ import com.prineside.tdi2.utils.ReflectionUtils;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.BooleanArrayComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.ByteArrayComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.CharArrayComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.CheatSafeIntComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.CheatSafeLongComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.DoubleArrayComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.FloatArrayComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.GdxArrayComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.GdxFloatArrayComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.GdxIntArrayComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.IdentityMapComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.IdentityObjectIntMapComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.IntArrayComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.IntFloatMapComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.IntIntMapComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.IntMapComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.IntSetComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.JsonValueComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.LongArrayComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.ObjectArrayComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.ObjectIntMapComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.ObjectMapComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.ObjectSetComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.RandomXS128Comparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.RectangleComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.ShortArrayComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.Vector2Comparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.comparators.WeakReferenceComparator;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.IdentityHashMap;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ public class SyncChecker
/*     */ {
/*     */   public static boolean VERBOSE_MODE = false;
/*  60 */   private static final String[] b = new String[1024];
/*     */   
/*  62 */   static final Pool<Set<Object>> a = new Pool<Set<Object>>(1, 512)
/*     */     {
/*     */       private static Set<Object> a() {
/*  65 */         return Collections.newSetFromMap(new IdentityHashMap<>());
/*     */       }
/*     */ 
/*     */       
/*     */       private static void a(Set<Object> param1Set) {
/*  70 */         param1Set.clear();
/*     */       }
/*     */     };
/*     */   
/*  74 */   private static final ObjectMap<Class<?>, DeepClassComparator<?>> c = new ObjectMap();
/*     */   
/*  76 */   public static final ObjectSet<Class<?>> SYNC_SHAREABLE_CLASSES = new ObjectSet(); private static final ObjectSet<Class<?>> e;
/*  77 */   private static final ObjectSet<Object> d = new ObjectSet();
/*     */   
/*     */   public static void addSyncShareableObject(Object paramObject) {
/*  80 */     synchronized (d) {
/*  81 */       d.add(paramObject);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   public static boolean isSyncShareableObject(Object paramObject) {
/*  86 */     synchronized (d) {
/*  87 */       return d.contains(paramObject);
/*     */     } 
/*     */   }
/*     */   
/*     */   static {
/*  92 */     SYNC_SHAREABLE_CLASSES.add(Integer.class);
/*  93 */     SYNC_SHAREABLE_CLASSES.add(Float.class);
/*  94 */     SYNC_SHAREABLE_CLASSES.add(Double.class);
/*  95 */     SYNC_SHAREABLE_CLASSES.add(Boolean.class);
/*  96 */     SYNC_SHAREABLE_CLASSES.add(Short.class);
/*  97 */     SYNC_SHAREABLE_CLASSES.add(Long.class);
/*  98 */     SYNC_SHAREABLE_CLASSES.add(Byte.class);
/*  99 */     SYNC_SHAREABLE_CLASSES.add(Character.class);
/*     */ 
/*     */     
/* 102 */     SYNC_SHAREABLE_CLASSES.add(LuaString.class);
/* 103 */     SYNC_SHAREABLE_CLASSES.add(LuaBoolean.class);
/* 104 */     SYNC_SHAREABLE_CLASSES.add(LuaNil.class);
/* 105 */     SYNC_SHAREABLE_CLASSES.add(LuaNumber.class);
/* 106 */     SYNC_SHAREABLE_CLASSES.add(JavaClass.class);
/* 107 */     SYNC_SHAREABLE_CLASSES.add(JavaInstance.class);
/*     */ 
/*     */     
/* 110 */     SYNC_SHAREABLE_CLASSES.add(Color.class);
/* 111 */     SYNC_SHAREABLE_CLASSES.add(Item.class);
/*     */ 
/*     */     
/* 114 */     SYNC_SHAREABLE_CLASSES.add(Action.class);
/* 115 */     SYNC_SHAREABLE_CLASSES.add(GameValueManager.GameValuesSnapshot.class);
/* 116 */     SYNC_SHAREABLE_CLASSES.add(AbilitySelectionOverlay.SelectedAbilitiesConfiguration.class);
/* 117 */     SYNC_SHAREABLE_CLASSES.add(BasicLevel.class);
/* 118 */     SYNC_SHAREABLE_CLASSES.add(ProgressManager.InventoryStatistics.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 127 */     (e = new ObjectSet()).add(Character.class);
/* 128 */     e.add(Byte.class);
/* 129 */     e.add(Short.class);
/* 130 */     e.add(Long.class);
/* 131 */     e.add(Float.class);
/* 132 */     e.add(Integer.class);
/* 133 */     e.add(Double.class);
/* 134 */     e.add(Boolean.class);
/* 135 */     e.add(String.class);
/*     */   }
/*     */   
/* 138 */   public static final Array<DeepClassComparator<?>> CLASS_COMPARATORS = new Array((Object[])new DeepClassComparator[] { (DeepClassComparator)new BooleanArrayComparator(), (DeepClassComparator)new ByteArrayComparator(), (DeepClassComparator)new CharArrayComparator(), (DeepClassComparator)new CheatSafeIntComparator(), (DeepClassComparator)new CheatSafeLongComparator(), (DeepClassComparator)new DoubleArrayComparator(), (DeepClassComparator)new FloatArrayComparator(), (DeepClassComparator)new GdxArrayComparator(), (DeepClassComparator)new GdxFloatArrayComparator(), (DeepClassComparator)new GdxIntArrayComparator(), (DeepClassComparator)new IdentityMapComparator(), (DeepClassComparator)new IdentityObjectIntMapComparator(), (DeepClassComparator)new IntArrayComparator(), (DeepClassComparator)new IntFloatMapComparator(), (DeepClassComparator)new IntIntMapComparator(), (DeepClassComparator)new IntMapComparator(), (DeepClassComparator)new IntSetComparator(), (DeepClassComparator)new LongArrayComparator(), (DeepClassComparator)new ObjectArrayComparator(), (DeepClassComparator)new ObjectIntMapComparator(), (DeepClassComparator)new ObjectMapComparator(), (DeepClassComparator)new ObjectSetComparator(), (DeepClassComparator)new RandomXS128Comparator(), (DeepClassComparator)new RectangleComparator(), (DeepClassComparator)new ShortArrayComparator(), (DeepClassComparator)new Vector2Comparator(), (DeepClassComparator)new WeakReferenceComparator(), (DeepClassComparator)new JsonValueComparator() });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void compareObjects(Object paramObject1, Object paramObject2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 171 */     if (paramDeepClassComparisonConfig.depth < 0) {
/* 172 */       if (paramDeepClassComparisonConfig.debug) paramDeepClassComparisonConfig.sb.append("> too deep\n"); 
/*     */       return;
/*     */     } 
/* 175 */     paramDeepClassComparisonConfig.depth--;
/*     */     
/* 177 */     if (paramObject1 == paramObject2) {
/*     */       
/* 179 */       if (paramObject1 != null)
/*     */       {
/* 181 */         if (!d.contains(paramObject1)) {
/*     */           Class<?> clazz;
/*     */ 
/*     */           
/* 185 */           if (!(clazz = paramObject1.getClass()).isEnum() && !clazz.isPrimitive() && clazz != String.class && clazz != Class.class) {
/*     */             
/* 187 */             Class<?> clazz1 = clazz;
/* 188 */             boolean bool = false;
/* 189 */             while (clazz1 != null && clazz1 != Object.class) {
/* 190 */               if (SYNC_SHAREABLE_CLASSES.contains(clazz1)) {
/* 191 */                 bool = true;
/*     */                 break;
/*     */               } 
/* 194 */               clazz1 = clazz1.getSuperclass();
/*     */             } 
/*     */ 
/*     */             
/* 198 */             if (!bool) {
/*     */               
/* 200 */               paramDeepClassComparisonConfig.appendPrefix().append(": same object that can not be shared ").append(paramObject1.getClass().getName()).append(" ").append(paramObject1);
/* 201 */               if (paramObject1 instanceof Object[]) {
/* 202 */                 paramDeepClassComparisonConfig.sb.append(" (is array: ").append(Arrays.toString((Object[])paramObject1)).append(")");
/* 203 */               } else if (paramObject1 instanceof float[]) {
/* 204 */                 paramDeepClassComparisonConfig.sb.append(" (is array: ").append(Arrays.toString((float[])paramObject1)).append(")");
/* 205 */               } else if (paramObject1 instanceof int[]) {
/* 206 */                 paramDeepClassComparisonConfig.sb.append(" (is array: ").append(Arrays.toString((int[])paramObject1)).append(")");
/* 207 */               } else if (paramObject1 instanceof double[]) {
/* 208 */                 paramDeepClassComparisonConfig.sb.append(" (is array: ").append(Arrays.toString((double[])paramObject1)).append(")");
/* 209 */               } else if (paramObject1 instanceof long[]) {
/* 210 */                 paramDeepClassComparisonConfig.sb.append(" (is array: ").append(Arrays.toString((long[])paramObject1)).append(")");
/* 211 */               } else if (paramObject1 instanceof boolean[]) {
/* 212 */                 paramDeepClassComparisonConfig.sb.append(" (is array: ").append(Arrays.toString((boolean[])paramObject1)).append(")");
/*     */               } 
/* 214 */               paramDeepClassComparisonConfig.sb.append("\n");
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 220 */       paramDeepClassComparisonConfig.depth++;
/*     */       
/*     */       return;
/*     */     } 
/* 224 */     if (paramObject2 != null && paramDeepClassComparisonConfig.comparesMap.containsKey(paramObject2))
/*     */     {
/* 226 */       if (!SYNC_SHAREABLE_CLASSES.contains(paramObject2.getClass())) {
/* 227 */         paramDeepClassComparisonConfig.appendPrefix().append(": shared object ").append(paramObject2.getClass().getName()).append(" ").append(Integer.toHexString(paramObject1.hashCode())).append("/").append(Integer.toHexString(paramObject2.hashCode())).append(" ").append(paramObject2).append("\n");
/* 228 */         paramDeepClassComparisonConfig.depth++;
/*     */         
/*     */         return;
/*     */       } 
/*     */     }
/* 233 */     if (paramObject1 != null && paramObject2 != null) {
/*     */       Set<Object> set;
/* 235 */       if ((set = paramDeepClassComparisonConfig.comparesMap.get(paramObject1)) != null && set.contains(paramObject2)) {
/*     */         
/* 237 */         if (paramDeepClassComparisonConfig.debug) {
/* 238 */           paramDeepClassComparisonConfig.sb.append("> skipped (already compared) ");
/* 239 */           for (byte b = 0; b < paramDeepClassComparisonConfig.a.size; b++) {
/* 240 */             paramDeepClassComparisonConfig.sb.append(((String[])paramDeepClassComparisonConfig.a.items)[b]);
/*     */           }
/* 242 */           paramDeepClassComparisonConfig.sb.append("\n");
/*     */         } 
/* 244 */         paramDeepClassComparisonConfig.depth++;
/*     */         return;
/*     */       } 
/* 247 */       if (set == null) {
/* 248 */         set = (Set)a.obtain();
/*     */       }
/* 250 */       set.add(paramObject2);
/* 251 */       paramDeepClassComparisonConfig.comparesMap.put(paramObject1, set);
/*     */     } 
/*     */     
/* 254 */     if (paramDeepClassComparisonConfig.debug) {
/* 255 */       paramDeepClassComparisonConfig.sb.append("> comparing ");
/* 256 */       for (byte b = 0; b < paramDeepClassComparisonConfig.a.size; b++) {
/* 257 */         paramDeepClassComparisonConfig.sb.append(((String[])paramDeepClassComparisonConfig.a.items)[b]);
/*     */       }
/* 259 */       paramDeepClassComparisonConfig.sb.append("\n");
/*     */     } 
/*     */     
/* 262 */     if (paramObject1 == null || paramObject2 == null) {
/* 263 */       paramDeepClassComparisonConfig.appendPrefix().append(": one object is null\n");
/*     */     }
/* 265 */     else if (paramObject1.getClass() != paramObject2.getClass()) {
/* 266 */       paramDeepClassComparisonConfig.appendPrefix().append(": classes differ (").append(paramObject1.getClass().getName()).append(", ").append(paramObject2.getClass().getName()).append(")\n");
/*     */     } else {
/*     */       
/* 269 */       Class<?> clazz = paramObject1.getClass();
/* 270 */       DeepClassComparator<?> deepClassComparator = null;
/* 271 */       if (c.containsKey(clazz)) {
/* 272 */         deepClassComparator = (DeepClassComparator)c.get(clazz);
/*     */       } else {
/* 274 */         for (Array.ArrayIterator<DeepClassComparator> arrayIterator = CLASS_COMPARATORS.iterator(); arrayIterator.hasNext();) {
/* 275 */           if ((deepClassComparator1 = arrayIterator.next()).forClass().isAssignableFrom(clazz)) {
/* 276 */             deepClassComparator = deepClassComparator1;
/*     */             break;
/*     */           } 
/*     */         } 
/* 280 */         c.put(clazz, deepClassComparator);
/*     */       } 
/*     */       
/* 283 */       if (deepClassComparator != null) {
/* 284 */         deepClassComparator.compare(paramObject1, paramObject2, paramDeepClassComparisonConfig);
/*     */       }
/* 286 */       else if (paramObject1.getClass().isPrimitive() || paramObject1.getClass().isEnum() || e.contains(paramObject1.getClass())) {
/*     */         
/* 288 */         if (!paramObject1.equals(paramObject2)) {
/* 289 */           paramDeepClassComparisonConfig.appendPrefix().append(": ").append(paramObject1).append(" != ").append(paramObject2).append("\n");
/*     */         }
/*     */       } else {
/*     */         
/* 293 */         Array array = ReflectionUtils.getAllSerializableFields(paramObject1.getClass());
/*     */         
/* 295 */         for (byte b = 0; b < array.size; b++) {
/* 296 */           Field field = ((Field[])array.items)[b];
/*     */           try {
/*     */             float f;
/*     */             Class<?> clazz1;
/* 300 */             if ((clazz1 = field.getType()) == float.class) {
/* 301 */               f = field.getFloat(paramObject1);
/* 302 */               float f1 = field.getFloat(paramObject2);
/* 303 */               if (paramDeepClassComparisonConfig.debug) {
/* 304 */                 paramDeepClassComparisonConfig.sb.append("> comparing ");
/* 305 */                 for (byte b1 = 0; b1 < paramDeepClassComparisonConfig.a.size; b1++) {
/* 306 */                   paramDeepClassComparisonConfig.sb.append(((String[])paramDeepClassComparisonConfig.a.items)[b1]);
/*     */                 }
/* 308 */                 paramDeepClassComparisonConfig.sb.append(".(float)").append(field.getName());
/* 309 */                 paramDeepClassComparisonConfig.sb.append("\n");
/*     */               } 
/*     */               
/* 312 */               if (f != f1)
/* 313 */                 paramDeepClassComparisonConfig.appendPrefix().append(".(float)").append(field.getName()).append(" ").append(f).append(" != ").append(f1).append("\n"); 
/*     */             } else {
/* 315 */               int i; if (f == int.class)
/* 316 */               { i = field.getInt(paramObject1);
/* 317 */                 int j = field.getInt(paramObject2);
/* 318 */                 if (paramDeepClassComparisonConfig.debug) {
/* 319 */                   paramDeepClassComparisonConfig.sb.append("> comparing ");
/* 320 */                   for (byte b1 = 0; b1 < paramDeepClassComparisonConfig.a.size; b1++) {
/* 321 */                     paramDeepClassComparisonConfig.sb.append(((String[])paramDeepClassComparisonConfig.a.items)[b1]);
/*     */                   }
/* 323 */                   paramDeepClassComparisonConfig.sb.append(".(int)").append(field.getName());
/* 324 */                   paramDeepClassComparisonConfig.sb.append("\n");
/*     */                 } 
/*     */                 
/* 327 */                 if (i != j) {
/* 328 */                   paramDeepClassComparisonConfig.appendPrefix().append(".(int)").append(field.getName()).append(" ").append(i).append(" != ").append(j).append("\n");
/*     */                 } }
/* 330 */               else if (i == long.class)
/* 331 */               { if (paramDeepClassComparisonConfig.debug) {
/* 332 */                   paramDeepClassComparisonConfig.sb.append("> comparing ");
/* 333 */                   for (i = 0; i < paramDeepClassComparisonConfig.a.size; i++) {
/* 334 */                     paramDeepClassComparisonConfig.sb.append(((String[])paramDeepClassComparisonConfig.a.items)[i]);
/*     */                   }
/* 336 */                   paramDeepClassComparisonConfig.sb.append(".(long)").append(field.getName());
/* 337 */                   paramDeepClassComparisonConfig.sb.append("\n");
/*     */                 } 
/*     */                 
/* 340 */                 if (field.getLong(paramObject1) != field.getLong(paramObject2)) {
/* 341 */                   paramDeepClassComparisonConfig.appendPrefix().append(".(long)").append(field.getName()).append(" ").append(field.getLong(paramObject1)).append(" != ").append(field.getLong(paramObject2)).append("\n");
/*     */                 } }
/* 343 */               else if (i == boolean.class)
/* 344 */               { if (paramDeepClassComparisonConfig.debug) {
/* 345 */                   paramDeepClassComparisonConfig.sb.append("> comparing ");
/* 346 */                   for (i = 0; i < paramDeepClassComparisonConfig.a.size; i++) {
/* 347 */                     paramDeepClassComparisonConfig.sb.append(((String[])paramDeepClassComparisonConfig.a.items)[i]);
/*     */                   }
/* 349 */                   paramDeepClassComparisonConfig.sb.append(".(boolean)").append(field.getName());
/* 350 */                   paramDeepClassComparisonConfig.sb.append("\n");
/*     */                 } 
/*     */                 
/* 353 */                 if (field.getBoolean(paramObject1) != field.getBoolean(paramObject2)) {
/* 354 */                   paramDeepClassComparisonConfig.appendPrefix().append(".(boolean)").append(field.getName()).append(" ").append(field.getBoolean(paramObject1)).append(" != ").append(field.getBoolean(paramObject2)).append("\n");
/*     */                 } }
/* 356 */               else if (i == double.class)
/* 357 */               { if (paramDeepClassComparisonConfig.debug) {
/* 358 */                   paramDeepClassComparisonConfig.sb.append("> comparing ");
/* 359 */                   for (i = 0; i < paramDeepClassComparisonConfig.a.size; i++) {
/* 360 */                     paramDeepClassComparisonConfig.sb.append(((String[])paramDeepClassComparisonConfig.a.items)[i]);
/*     */                   }
/* 362 */                   paramDeepClassComparisonConfig.sb.append(".(double)").append(field.getName());
/* 363 */                   paramDeepClassComparisonConfig.sb.append("\n");
/*     */                 } 
/*     */                 
/* 366 */                 if (field.getDouble(paramObject1) != field.getDouble(paramObject2)) {
/* 367 */                   paramDeepClassComparisonConfig.appendPrefix().append(".(double)").append(field.getName()).append(" ").append(field.getDouble(paramObject1)).append(" != ").append(field.getDouble(paramObject2)).append("\n");
/*     */                 } }
/* 369 */               else if (i == byte.class)
/* 370 */               { if (paramDeepClassComparisonConfig.debug) {
/* 371 */                   paramDeepClassComparisonConfig.sb.append("> comparing ");
/* 372 */                   for (i = 0; i < paramDeepClassComparisonConfig.a.size; i++) {
/* 373 */                     paramDeepClassComparisonConfig.sb.append(((String[])paramDeepClassComparisonConfig.a.items)[i]);
/*     */                   }
/* 375 */                   paramDeepClassComparisonConfig.sb.append(".(byte)").append(field.getName());
/* 376 */                   paramDeepClassComparisonConfig.sb.append("\n");
/*     */                 } 
/*     */                 
/* 379 */                 if (field.getByte(paramObject1) != field.getByte(paramObject2)) {
/* 380 */                   paramDeepClassComparisonConfig.appendPrefix().append(".(byte)").append(field.getName()).append(" ").append(field.getByte(paramObject1)).append(" != ").append(field.getByte(paramObject2)).append("\n");
/*     */                 } }
/*     */               else
/* 383 */               { String str = "?";
/* 384 */                 if (field.get(paramObject1) != null) {
/* 385 */                   if (VERBOSE_MODE) {
/* 386 */                     str = field.get(paramObject1).getClass().getSimpleName() + "@" + Integer.toHexString(field.get(paramObject1).hashCode());
/* 387 */                     if (field.get(paramObject2) != null) {
/* 388 */                       str = str + " <> @" + Integer.toHexString(field.get(paramObject2).hashCode());
/*     */                     }
/*     */                   } else {
/* 391 */                     str = field.get(paramObject1).getClass().getSimpleName();
/*     */                   } 
/* 393 */                 } else if (field.get(paramObject2) != null) {
/* 394 */                   if (VERBOSE_MODE) {
/* 395 */                     if (field.get(paramObject1) != null) {
/* 396 */                       str = field.get(paramObject1).getClass().getSimpleName() + "@" + Integer.toHexString(field.get(paramObject1).hashCode());
/*     */                     }
/* 398 */                     str = str + " <> @" + Integer.toHexString(field.get(paramObject2).hashCode());
/*     */                   } else {
/* 400 */                     str = field.get(paramObject2).getClass().getSimpleName();
/*     */                   } 
/*     */                 } 
/*     */                 
/* 404 */                 Enum[] arrayOfEnum = null;
/*     */                 EnumKeyArray enumKeyArray;
/* 406 */                 if ((enumKeyArray = ReflectionUtils.getEnumKeyArrayFieldAnnotationCached(field)) != null) {
/* 407 */                   arrayOfEnum = enumKeyArray.enumerator().getEnumConstants();
/*     */                 }
/*     */                 
/* 410 */                 paramDeepClassComparisonConfig.addPrefix(new String[] { ".(", str, ")", field.getName() });
/*     */                 
/* 412 */                 paramDeepClassComparisonConfig.keyEnum = (Enum<?>[])arrayOfEnum;
/* 413 */                 compareObjects(field.get(paramObject1), field.get(paramObject2), paramDeepClassComparisonConfig);
/* 414 */                 paramDeepClassComparisonConfig.keyEnum = null;
/*     */                 
/* 416 */                 paramDeepClassComparisonConfig.popPrefix(4); } 
/*     */             } 
/* 418 */           } catch (Exception exception) {
/* 419 */             paramDeepClassComparisonConfig.depth++;
/* 420 */             throw new RuntimeException("failed for " + paramDeepClassComparisonConfig.a.toString("") + "." + field.getName() + "\n" + paramDeepClassComparisonConfig.sb.toString(), exception);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 427 */     paramDeepClassComparisonConfig.depth++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toString(int paramInt) {
/*     */     int i;
/* 436 */     if ((i = paramInt + 256) >= 0 && i < b.length) {
/*     */       String str;
/* 438 */       if ((str = b[i]) == null) {
/* 439 */         b[i] = Integer.toString(paramInt);
/* 440 */         return b[i];
/*     */       } 
/* 442 */       return str;
/*     */     } 
/* 444 */     return Integer.toString(paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\SyncChecker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */