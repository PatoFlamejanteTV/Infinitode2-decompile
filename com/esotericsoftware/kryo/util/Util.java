/*     */ package com.esotericsoftware.kryo.util;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Serializer;
/*     */ import com.esotericsoftware.kryo.serializers.ClosureSerializer;
/*     */ import com.esotericsoftware.kryo.serializers.FieldSerializer;
/*     */ import com.esotericsoftware.minlog.Log;
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.HashMap;
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
/*     */ public class Util
/*     */ {
/*  38 */   public static final boolean isAndroid = "Dalvik".equals(System.getProperty("java.vm.name")); public static final boolean unsafe;
/*     */   public static final int maxArraySize = 2147483639;
/*     */   private static final Map<Class<?>, Class<?>> primitiveWrappers;
/*     */   
/*     */   static {
/*  43 */     boolean bool = false;
/*  44 */     if ("false".equals(System.getProperty("kryo.unsafe"))) {
/*  45 */       if (Log.TRACE) Log.trace("kryo", "Unsafe is disabled.");
/*     */     
/*     */     } else {
/*     */       try {
/*  49 */         bool = (Class.forName("com.esotericsoftware.kryo.unsafe.UnsafeUtil", true, FieldSerializer.class.getClassLoader()).getField("unsafe").get(null) != null) ? true : false;
/*  50 */       } catch (Throwable throwable) {
/*  51 */         if (Log.TRACE) Log.trace("kryo", "Unsafe is unavailable.", throwable); 
/*     */       } 
/*     */     } 
/*  54 */     unsafe = bool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  62 */     (primitiveWrappers = new HashMap<>()).put(boolean.class, Boolean.class);
/*  63 */     primitiveWrappers.put(byte.class, Byte.class);
/*  64 */     primitiveWrappers.put(char.class, Character.class);
/*  65 */     primitiveWrappers.put(double.class, Double.class);
/*  66 */     primitiveWrappers.put(float.class, Float.class);
/*  67 */     primitiveWrappers.put(int.class, Integer.class);
/*  68 */     primitiveWrappers.put(long.class, Long.class);
/*  69 */     primitiveWrappers.put(short.class, Short.class);
/*     */   }
/*     */   
/*     */   public static boolean isUnsafeAvailable() {
/*  73 */     return unsafe;
/*     */   }
/*     */   
/*     */   public static boolean isClassAvailable(String paramString) {
/*     */     try {
/*  78 */       Class.forName(paramString);
/*  79 */       return true;
/*  80 */     } catch (Exception exception) {
/*  81 */       Log.debug("kryo", "Class not available: " + paramString);
/*  82 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static Class getWrapperClass(Class<int> paramClass) {
/*  88 */     if (paramClass == int.class) return Integer.class; 
/*  89 */     if (paramClass == float.class) return Float.class; 
/*  90 */     if (paramClass == boolean.class) return Boolean.class; 
/*  91 */     if (paramClass == byte.class) return Byte.class; 
/*  92 */     if (paramClass == long.class) return Long.class; 
/*  93 */     if (paramClass == char.class) return Character.class; 
/*  94 */     if (paramClass == double.class) return Double.class; 
/*  95 */     if (paramClass == short.class) return Short.class; 
/*  96 */     return paramClass;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Class getPrimitiveClass(Class<Integer> paramClass) {
/* 102 */     if (paramClass == Integer.class) return int.class; 
/* 103 */     if (paramClass == Float.class) return float.class; 
/* 104 */     if (paramClass == Boolean.class) return boolean.class; 
/* 105 */     if (paramClass == Byte.class) return byte.class; 
/* 106 */     if (paramClass == Long.class) return long.class; 
/* 107 */     if (paramClass == Character.class) return char.class; 
/* 108 */     if (paramClass == Double.class) return double.class; 
/* 109 */     if (paramClass == Short.class) return short.class; 
/* 110 */     if (paramClass == Void.class) return void.class; 
/* 111 */     return paramClass;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Class getArrayType(Class<String> paramClass) {
/* 116 */     if (paramClass == String.class) return String[].class; 
/* 117 */     if (paramClass == Integer.class) return Integer[].class; 
/* 118 */     if (paramClass == Float.class) return Float[].class; 
/* 119 */     if (paramClass == Boolean.class) return Boolean[].class; 
/* 120 */     if (paramClass == Byte.class) return Byte[].class; 
/* 121 */     if (paramClass == Long.class) return Long[].class; 
/* 122 */     if (paramClass == Character.class) return Character[].class; 
/* 123 */     if (paramClass == Double.class) return Double[].class; 
/* 124 */     if (paramClass == Short.class) return Short[].class;
/*     */     
/* 126 */     return Array.newInstance(paramClass, 0).getClass();
/*     */   }
/*     */   
/*     */   public static boolean isWrapperClass(Class<Integer> paramClass) {
/* 130 */     return (paramClass == Integer.class || paramClass == Float.class || paramClass == Boolean.class || paramClass == Byte.class || paramClass == Long.class || paramClass == Character.class || paramClass == Double.class || paramClass == Short.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isEnum(Class<?> paramClass) {
/* 136 */     return (Enum.class.isAssignableFrom(paramClass) && paramClass != Enum.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void log(String paramString, Object paramObject, int paramInt) {
/* 141 */     if (paramObject == null) {
/* 142 */       if (Log.TRACE) Log.trace("kryo", paramString + ": null" + pos(paramInt)); 
/*     */       return;
/*     */     } 
/*     */     Class<?> clazz;
/* 146 */     if ((clazz = paramObject.getClass()).isPrimitive() || isWrapperClass(clazz) || clazz == String.class)
/* 147 */     { if (Log.TRACE) { Log.trace("kryo", paramString + ": " + string(paramObject) + pos(paramInt)); return; }
/*     */        }
/* 149 */     else { Log.debug("kryo", paramString + ": " + string(paramObject) + pos(paramInt)); }
/*     */   
/*     */   }
/*     */   public static String pos(int paramInt) {
/* 153 */     return (paramInt == -1) ? "" : (" [" + paramInt + "]");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String string(Object paramObject) {
/* 159 */     if (paramObject == null) return "null"; 
/*     */     Class<?> clazz;
/* 161 */     if ((clazz = paramObject.getClass()).isArray()) return className(clazz); 
/* 162 */     String str = Log.TRACE ? className(clazz) : clazz.getSimpleName();
/*     */     try {
/* 164 */       if (clazz.getMethod("toString", new Class[0]).getDeclaringClass() == Object.class) return str; 
/* 165 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/*     */     try {
/* 169 */       return (String)(((paramObject = String.valueOf(paramObject) + " (" + str + ")").length() > 97) ? (paramObject.substring(0, 97) + "...") : paramObject);
/* 170 */     } catch (Throwable throwable) {
/* 171 */       return str + " (toString exception: " + throwable + ")";
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
/*     */   public static String className(Class paramClass) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: ifnonnull -> 7
/*     */     //   4: ldc 'null'
/*     */     //   6: areturn
/*     */     //   7: aload_0
/*     */     //   8: invokevirtual isArray : ()Z
/*     */     //   11: ifeq -> 76
/*     */     //   14: aload_0
/*     */     //   15: invokestatic getElementClass : (Ljava/lang/Class;)Ljava/lang/Class;
/*     */     //   18: astore_1
/*     */     //   19: new java/lang/StringBuilder
/*     */     //   22: dup
/*     */     //   23: bipush #16
/*     */     //   25: invokespecial <init> : (I)V
/*     */     //   28: astore_2
/*     */     //   29: iconst_0
/*     */     //   30: istore_3
/*     */     //   31: aload_0
/*     */     //   32: invokestatic getDimensionCount : (Ljava/lang/Class;)I
/*     */     //   35: istore_0
/*     */     //   36: iload_3
/*     */     //   37: iload_0
/*     */     //   38: if_icmpge -> 54
/*     */     //   41: aload_2
/*     */     //   42: ldc '[]'
/*     */     //   44: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   47: pop
/*     */     //   48: iinc #3, 1
/*     */     //   51: goto -> 36
/*     */     //   54: new java/lang/StringBuilder
/*     */     //   57: dup
/*     */     //   58: invokespecial <init> : ()V
/*     */     //   61: aload_1
/*     */     //   62: invokestatic className : (Ljava/lang/Class;)Ljava/lang/String;
/*     */     //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   68: aload_2
/*     */     //   69: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   72: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   75: areturn
/*     */     //   76: aload_0
/*     */     //   77: invokevirtual isPrimitive : ()Z
/*     */     //   80: ifne -> 143
/*     */     //   83: aload_0
/*     */     //   84: ldc java/lang/Object
/*     */     //   86: if_acmpeq -> 143
/*     */     //   89: aload_0
/*     */     //   90: ldc java/lang/Boolean
/*     */     //   92: if_acmpeq -> 143
/*     */     //   95: aload_0
/*     */     //   96: ldc java/lang/Byte
/*     */     //   98: if_acmpeq -> 143
/*     */     //   101: aload_0
/*     */     //   102: ldc java/lang/Character
/*     */     //   104: if_acmpeq -> 143
/*     */     //   107: aload_0
/*     */     //   108: ldc java/lang/Short
/*     */     //   110: if_acmpeq -> 143
/*     */     //   113: aload_0
/*     */     //   114: ldc java/lang/Integer
/*     */     //   116: if_acmpeq -> 143
/*     */     //   119: aload_0
/*     */     //   120: ldc java/lang/Long
/*     */     //   122: if_acmpeq -> 143
/*     */     //   125: aload_0
/*     */     //   126: ldc java/lang/Float
/*     */     //   128: if_acmpeq -> 143
/*     */     //   131: aload_0
/*     */     //   132: ldc java/lang/Double
/*     */     //   134: if_acmpeq -> 143
/*     */     //   137: aload_0
/*     */     //   138: ldc java/lang/String
/*     */     //   140: if_acmpne -> 148
/*     */     //   143: aload_0
/*     */     //   144: invokevirtual getSimpleName : ()Ljava/lang/String;
/*     */     //   147: areturn
/*     */     //   148: aload_0
/*     */     //   149: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   152: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #177	-> 0
/*     */     //   #178	-> 7
/*     */     //   #179	-> 14
/*     */     //   #180	-> 19
/*     */     //   #181	-> 29
/*     */     //   #182	-> 41
/*     */     //   #181	-> 48
/*     */     //   #183	-> 54
/*     */     //   #185	-> 76
/*     */     //   #188	-> 143
/*     */     //   #190	-> 148
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String classNames(Class[] paramArrayOfClass) {
/* 195 */     StringBuilder stringBuilder = new StringBuilder(32); byte b; int i;
/* 196 */     for (b = 0, i = paramArrayOfClass.length; b < i; b++) {
/* 197 */       if (b > 0) stringBuilder.append(", "); 
/* 198 */       stringBuilder.append(className(paramArrayOfClass[b]));
/*     */     } 
/* 200 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String canonicalName(Class paramClass) {
/* 206 */     if (paramClass == null) return "null"; 
/*     */     String str;
/* 208 */     return ((str = paramClass.getCanonicalName()) != null) ? str : className(paramClass);
/*     */   }
/*     */   
/*     */   public static String simpleName(Type paramType) {
/* 212 */     if (paramType instanceof Class) return ((Class)paramType).getSimpleName(); 
/* 213 */     return paramType.toString();
/*     */   }
/*     */   
/*     */   public static String simpleName(Class<?> paramClass, Generics.GenericType paramGenericType) {
/*     */     StringBuilder stringBuilder;
/* 218 */     (stringBuilder = new StringBuilder(32)).append((paramClass.isArray() ? getElementClass(paramClass) : paramClass).getSimpleName());
/* 219 */     if (paramGenericType.arguments != null) {
/* 220 */       stringBuilder.append('<'); byte b; int i;
/* 221 */       for (b = 0, i = paramGenericType.arguments.length; b < i; b++) {
/* 222 */         if (b > 0) stringBuilder.append(", "); 
/* 223 */         stringBuilder.append(paramGenericType.arguments[b].toString());
/*     */       } 
/* 225 */       stringBuilder.append('>');
/*     */     } 
/* 227 */     if (paramClass.isArray()) {
/* 228 */       byte b; int i; for (b = 0, i = getDimensionCount(paramClass); b < i; b++)
/* 229 */         stringBuilder.append("[]"); 
/*     */     } 
/* 231 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDimensionCount(Class<?> paramClass) {
/* 236 */     byte b = 0;
/* 237 */     paramClass = paramClass.getComponentType();
/* 238 */     while (paramClass != null) {
/* 239 */       b++;
/* 240 */       paramClass = paramClass.getComponentType();
/*     */     } 
/* 242 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Class getElementClass(Class<?> paramClass) {
/* 247 */     paramClass = paramClass;
/* 248 */     while (paramClass.getComponentType() != null)
/* 249 */       paramClass = paramClass.getComponentType(); 
/* 250 */     return paramClass;
/*     */   }
/*     */   
/*     */   public static boolean isAssignableTo(Class<?> paramClass1, Class<?> paramClass2) {
/* 254 */     if (paramClass2 == Object.class) return true; 
/* 255 */     if (paramClass2.isAssignableFrom(paramClass1)) return true; 
/* 256 */     if (paramClass1.isPrimitive()) return (isPrimitiveWrapperOf(paramClass2, paramClass1) || paramClass2.isAssignableFrom(getPrimitiveWrapper(paramClass1))); 
/* 257 */     if (paramClass2.isPrimitive()) return isPrimitiveWrapperOf(paramClass1, paramClass2); 
/* 258 */     if (paramClass1 == ClosureSerializer.Closure.class) return paramClass2.isInterface(); 
/* 259 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean isPrimitiveWrapperOf(Class<?> paramClass1, Class<?> paramClass2) {
/* 263 */     return (getPrimitiveWrapper(paramClass2) == paramClass1);
/*     */   }
/*     */   
/*     */   private static Class<?> getPrimitiveWrapper(Class<?> paramClass) {
/* 267 */     if (!paramClass.isPrimitive()) throw new IllegalArgumentException("Argument has to be primitive type"); 
/* 268 */     return primitiveWrappers.get(paramClass);
/*     */   } public static boolean isAscii(String paramString) {
/*     */     byte b;
/*     */     int i;
/* 272 */     for (b = 0, i = paramString.length(); b < i; b++) {
/* 273 */       if (paramString.charAt(b) > '') return false; 
/* 274 */     }  return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends com.esotericsoftware.kryo.SerializerFactory> T newFactory(Class<T> paramClass, Class<? extends Serializer> paramClass1) {
/*     */     try {
/* 281 */       if (paramClass1 != null) {
/*     */         try {
/* 283 */           return (T)paramClass.getConstructor(new Class[] { Class.class }).newInstance(new Object[] { paramClass1 });
/* 284 */         } catch (NoSuchMethodException noSuchMethodException) {}
/*     */       }
/*     */       
/* 287 */       return paramClass.newInstance();
/* 288 */     } catch (Exception exception) {
/* 289 */       if (paramClass1 == null) {
/* 290 */         throw new IllegalArgumentException("Unable to create serializer factory: " + paramClass.getName(), exception);
/*     */       }
/* 292 */       throw new IllegalArgumentException("Unable to create serializer factory \"" + paramClass.getName() + "\" for serializer class: " + 
/* 293 */           className(paramClass1), exception);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\util\Util.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */