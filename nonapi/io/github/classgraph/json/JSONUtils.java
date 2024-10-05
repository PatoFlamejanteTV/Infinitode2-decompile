/*     */ package nonapi.io.github.classgraph.json;
/*     */ 
/*     */ import java.lang.reflect.AccessibleObject;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.Collection;
/*     */ import java.util.concurrent.Callable;
/*     */ import nonapi.io.github.classgraph.reflection.ReflectionUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class JSONUtils
/*     */ {
/*     */   private static Method isAccessibleMethod;
/*     */   private static Method setAccessibleMethod;
/*     */   private static Method trySetAccessibleMethod;
/*     */   static final String ID_KEY = "__ID";
/*     */   static final String ID_PREFIX = "[#";
/*     */   static final String ID_SUFFIX = "]";
/*     */   
/*     */   static {
/*     */     try {
/*  53 */       isAccessibleMethod = AccessibleObject.class.getDeclaredMethod("isAccessible", new Class[0]);
/*  54 */     } catch (Throwable throwable) {}
/*     */ 
/*     */     
/*     */     try {
/*  58 */       setAccessibleMethod = AccessibleObject.class.getDeclaredMethod("setAccessible", new Class[] { boolean.class });
/*  59 */     } catch (Throwable throwable) {}
/*     */ 
/*     */     
/*     */     try {
/*  63 */       trySetAccessibleMethod = AccessibleObject.class.getDeclaredMethod("trySetAccessible", new Class[0]);
/*  64 */     } catch (Throwable throwable) {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isAccessible(AccessibleObject paramAccessibleObject) {
/*  70 */     if (isAccessibleMethod != null) {
/*     */       
/*     */       try {
/*  73 */         if (((Boolean)isAccessibleMethod.invoke(paramAccessibleObject, new Object[0])).booleanValue()) {
/*  74 */           return true;
/*     */         }
/*  76 */       } catch (Throwable throwable) {}
/*     */     }
/*     */ 
/*     */     
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean tryMakeAccessible(AccessibleObject paramAccessibleObject) {
/*  84 */     if (setAccessibleMethod != null) {
/*     */       try {
/*  86 */         setAccessibleMethod.invoke(paramAccessibleObject, new Object[] { Boolean.TRUE });
/*  87 */         return true;
/*  88 */       } catch (Throwable throwable) {}
/*     */     }
/*     */ 
/*     */     
/*  92 */     if (trySetAccessibleMethod != null) {
/*     */       try {
/*  94 */         if (((Boolean)trySetAccessibleMethod.invoke(paramAccessibleObject, new Object[0])).booleanValue()) {
/*  95 */           return true;
/*     */         }
/*  97 */       } catch (Throwable throwable) {}
/*     */     }
/*     */ 
/*     */     
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean makeAccessible(final AccessibleObject obj, ReflectionUtils paramReflectionUtils) {
/* 108 */     if (isAccessible(obj) || tryMakeAccessible(obj)) {
/* 109 */       return true;
/*     */     }
/*     */     try {
/* 112 */       return ((Boolean)paramReflectionUtils.doPrivileged(new Callable<Boolean>()
/*     */           {
/*     */             public final Boolean call() {
/* 115 */               return Boolean.valueOf(JSONUtils.tryMakeAccessible(obj));
/*     */             }
/*     */           })).booleanValue();
/* 118 */     } catch (Throwable throwable) {
/* 119 */       return false;
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
/* 138 */   private static final String[] JSON_CHAR_REPLACEMENTS = new String[256];
/*     */   
/*     */   static {
/* 141 */     for (byte b1 = 0; b1 < 'Ā'; b1++) {
/* 142 */       if (b1 == 32) {
/* 143 */         b1 = 127;
/*     */       }
/*     */       
/* 146 */       int i = ((i = b1 >> 4) <= 9) ? (char)(i + 48) : (char)(i + 65 - 10);
/*     */       
/* 148 */       int j = ((j = b1 & 0xF) <= 9) ? (char)(j + 48) : (char)(j + 65 - 10);
/* 149 */       JSON_CHAR_REPLACEMENTS[b1] = "\\u00" + i + j;
/*     */     } 
/* 151 */     JSON_CHAR_REPLACEMENTS[34] = "\\\"";
/* 152 */     JSON_CHAR_REPLACEMENTS[92] = "\\\\";
/* 153 */     JSON_CHAR_REPLACEMENTS[10] = "\\n";
/* 154 */     JSON_CHAR_REPLACEMENTS[13] = "\\r";
/* 155 */     JSON_CHAR_REPLACEMENTS[9] = "\\t";
/* 156 */     JSON_CHAR_REPLACEMENTS[8] = "\\b";
/* 157 */     JSON_CHAR_REPLACEMENTS[12] = "\\f";
/*     */   }
/*     */ 
/*     */   
/* 161 */   private static final String[] INDENT_LEVELS = new String[17];
/*     */   static {
/* 163 */     StringBuilder stringBuilder = new StringBuilder();
/* 164 */     for (byte b2 = 0; b2 < INDENT_LEVELS.length; b2++) {
/* 165 */       INDENT_LEVELS[b2] = stringBuilder.toString();
/* 166 */       stringBuilder.append(' ');
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
/*     */   static void escapeJSONString(String paramString, StringBuilder paramStringBuilder) {
/* 188 */     if (paramString == null) {
/*     */       return;
/*     */     }
/*     */     
/* 192 */     int i = 0; byte b; int j;
/* 193 */     for (b = 0, j = paramString.length(); b < j; b++) {
/*     */       char c;
/* 195 */       if ((c = paramString.charAt(b)) > 'ÿ' || JSON_CHAR_REPLACEMENTS[c] != null) {
/* 196 */         i = 1;
/*     */         break;
/*     */       } 
/*     */     } 
/* 200 */     if (!i) {
/* 201 */       paramStringBuilder.append(paramString);
/*     */       
/*     */       return;
/*     */     } 
/* 205 */     for (b = 0, j = paramString.length(); b < j; b++) {
/*     */       char c;
/* 207 */       if ((c = paramString.charAt(b)) > 'ÿ') {
/* 208 */         paramStringBuilder.append("\\u");
/* 209 */         i = (c & 0xF000) >> 12;
/* 210 */         paramStringBuilder.append((i <= 9) ? (char)(i + 48) : (char)(i + 65 - 10));
/* 211 */         i = (c & 0xF00) >> 8;
/* 212 */         paramStringBuilder.append((i <= 9) ? (char)(i + 48) : (char)(i + 65 - 10));
/* 213 */         i = (c & 0xF0) >> 4;
/* 214 */         paramStringBuilder.append((i <= 9) ? (char)(i + 48) : (char)(i + 65 - 10));
/* 215 */         i = c & 0xF;
/* 216 */         paramStringBuilder.append((i <= 9) ? (char)(i + 48) : (char)(i + 65 - 10));
/*     */       } else {
/*     */         String str;
/* 219 */         if ((str = JSON_CHAR_REPLACEMENTS[c]) == null) {
/* 220 */           paramStringBuilder.append(c);
/*     */         } else {
/* 222 */           paramStringBuilder.append(str);
/*     */         } 
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
/*     */   public static String escapeJSONString(String paramString) {
/* 236 */     StringBuilder stringBuilder = new StringBuilder(paramString.length() << 1);
/* 237 */     escapeJSONString(paramString, stringBuilder);
/* 238 */     return stringBuilder.toString();
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
/*     */   static void indent(int paramInt1, int paramInt2, StringBuilder paramStringBuilder) {
/* 254 */     int i = INDENT_LEVELS.length - 1;
/* 255 */     for (paramInt1 *= paramInt2; paramInt1 > 0; ) {
/* 256 */       paramInt2 = Math.min(paramInt1, i);
/* 257 */       paramStringBuilder.append(INDENT_LEVELS[paramInt2]);
/* 258 */       paramInt1 -= paramInt2;
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
/*     */   static Object getFieldValue(Object paramObject, Field paramField) {
/*     */     Class<?> clazz;
/* 282 */     if ((clazz = paramField.getType()) == int.class)
/* 283 */       return Integer.valueOf(paramField.getInt(paramObject)); 
/* 284 */     if (clazz == long.class)
/* 285 */       return Long.valueOf(paramField.getLong(paramObject)); 
/* 286 */     if (clazz == short.class)
/* 287 */       return Short.valueOf(paramField.getShort(paramObject)); 
/* 288 */     if (clazz == double.class)
/* 289 */       return Double.valueOf(paramField.getDouble(paramObject)); 
/* 290 */     if (clazz == float.class)
/* 291 */       return Float.valueOf(paramField.getFloat(paramObject)); 
/* 292 */     if (clazz == boolean.class)
/* 293 */       return Boolean.valueOf(paramField.getBoolean(paramObject)); 
/* 294 */     if (clazz == byte.class)
/* 295 */       return Byte.valueOf(paramField.getByte(paramObject)); 
/* 296 */     if (clazz == char.class) {
/* 297 */       return Character.valueOf(paramField.getChar(paramObject));
/*     */     }
/* 299 */     return paramField.get(paramObject);
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
/*     */   static boolean isBasicValueType(Class<?> paramClass) {
/* 314 */     if (paramClass == String.class || paramClass == Integer.class || paramClass == int.class || paramClass == Long.class || paramClass == long.class || paramClass == Short.class || paramClass == short.class || paramClass == Float.class || paramClass == float.class || paramClass == Double.class || paramClass == double.class || paramClass == Byte.class || paramClass == byte.class || paramClass == Character.class || paramClass == char.class || paramClass == Boolean.class || paramClass == boolean.class || paramClass
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 323 */       .isEnum() || paramClass == Class.class) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isBasicValueType(Type paramType) {
/* 335 */     if (paramType instanceof Class)
/* 336 */       return isBasicValueType((Class)paramType); 
/* 337 */     if (paramType instanceof ParameterizedType) {
/* 338 */       return isBasicValueType(((ParameterizedType)paramType).getRawType());
/*     */     }
/* 340 */     return false;
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
/*     */   static boolean isBasicValueType(Object paramObject) {
/* 352 */     if (paramObject == null || paramObject instanceof String || paramObject instanceof Integer || paramObject instanceof Boolean || paramObject instanceof Long || paramObject instanceof Float || paramObject instanceof Double || paramObject instanceof Short || paramObject instanceof Byte || paramObject instanceof Character || paramObject
/*     */       
/* 354 */       .getClass().isEnum() || paramObject instanceof Class) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isCollectionOrArray(Object<?> paramObject) {
/* 366 */     paramObject = (Object<?>)paramObject.getClass();
/* 367 */     return (Collection.class.isAssignableFrom((Class<?>)paramObject) || paramObject.isArray());
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
/*     */   static Class<?> getRawType(Type paramType) {
/* 383 */     if (paramType instanceof Class)
/* 384 */       return (Class)paramType; 
/* 385 */     if (paramType instanceof ParameterizedType) {
/* 386 */       return (Class)((ParameterizedType)paramType).getRawType();
/*     */     }
/* 388 */     throw new IllegalArgumentException("Illegal type: " + paramType);
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
/*     */   static boolean fieldIsSerializable(Field paramField, boolean paramBoolean, ReflectionUtils paramReflectionUtils) {
/* 407 */     int i = paramField.getModifiers();
/* 408 */     if ((!paramBoolean || Modifier.isPublic(i)) && !Modifier.isTransient(i) && 
/* 409 */       !Modifier.isFinal(i) && (i & 0x1000) == 0) {
/* 410 */       return makeAccessible(paramField, paramReflectionUtils);
/*     */     }
/* 412 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\json\JSONUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */