/*     */ package com.prineside.tdi2.serializers;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.Serializer;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.utils.EnumKeyArray;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.Comparator;
/*     */ 
/*     */ 
/*     */ public final class GameStateSerializer
/*     */   extends Serializer
/*     */ {
/*  22 */   private static final TLog a = TLog.forClass(GameStateSerializer.class);
/*     */   
/*  24 */   public static Serializer CLASS_ONLY_SERIALIZER = new Serializer()
/*     */     {
/*     */       public void write(Kryo param1Kryo, Output param1Output, Object param1Object) {
/*  27 */         throw new IllegalStateException("can't be used to serialize objects");
/*     */       }
/*     */ 
/*     */       
/*     */       public Object read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/*  32 */         throw new IllegalStateException("can't be used to serialize objects");
/*     */       }
/*     */     };
/*     */   
/*  36 */   private static ObjectMap<Class, Array<Field>> b = new ObjectMap(); private static final ObjectSet<Class> c;
/*     */   private static final ObjectSet<Class> d;
/*     */   
/*     */   static {
/*  40 */     (c = new ObjectSet()).add(byte[].class);
/*  41 */     c.add(char[].class);
/*  42 */     c.add(short[].class);
/*  43 */     c.add(int[].class);
/*  44 */     c.add(long[].class);
/*  45 */     c.add(float[].class);
/*  46 */     c.add(double[].class);
/*  47 */     c.add(boolean[].class);
/*  48 */     c.add(String[].class);
/*  49 */     c.add(Enum[].class);
/*  50 */     c.add(int.class);
/*  51 */     c.add(String.class);
/*  52 */     c.add(float.class);
/*  53 */     c.add(boolean.class);
/*  54 */     c.add(byte.class);
/*  55 */     c.add(char.class);
/*  56 */     c.add(short.class);
/*  57 */     c.add(long.class);
/*  58 */     c.add(double.class);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  63 */     (d = new ObjectSet()).add(int.class);
/*  64 */     d.add(float.class);
/*  65 */     d.add(boolean.class);
/*  66 */     d.add(byte.class);
/*  67 */     d.add(char.class);
/*  68 */     d.add(short.class);
/*  69 */     d.add(long.class);
/*  70 */     d.add(double.class);
/*     */   }
/*     */   
/*     */   private final Array<Field> e;
/*     */   public int writeCount;
/*  75 */   private static final ObjectMap<Field, EnumKeyArray> f = new ObjectMap(); private static final Comparator<Field> g;
/*     */   static {
/*  77 */     g = ((paramField1, paramField2) -> paramField1.getName().compareTo(paramField2.getName()));
/*     */   }
/*     */   public static EnumKeyArray getEnumKeyArrayFieldAnnotationCached(Field paramField) {
/*  80 */     if (paramField.isAnnotationPresent((Class)EnumKeyArray.class)) {
/*  81 */       if (f.containsKey(paramField)) {
/*  82 */         return (EnumKeyArray)f.get(paramField);
/*     */       }
/*     */       
/*  85 */       EnumKeyArray enumKeyArray = paramField.<EnumKeyArray>getAnnotation(EnumKeyArray.class);
/*  86 */       f.put(paramField, enumKeyArray);
/*     */       
/*  88 */       return enumKeyArray;
/*     */     } 
/*  90 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Array<Field> getAllFields(Class<Object> paramClass, Array<String> paramArray) {
/*  95 */     Class<Object> clazz = paramClass;
/*     */     
/*     */     Array<Field> array;
/*  98 */     if ((array = (Array)b.get(paramClass, null)) != null) {
/*  99 */       return array;
/*     */     }
/*     */     
/* 102 */     array = new Array(Field.class);
/*     */     
/* 104 */     while (paramClass != null && paramClass != Object.class) {
/*     */       Field[] arrayOfField; int i; byte b;
/* 106 */       for (i = (arrayOfField = arrayOfField = paramClass.getDeclaredFields()).length, b = 0; b < i; b++) {
/* 107 */         Field field; if (!a(field = arrayOfField[b])) {
/* 108 */           if (!array.contains(field, true)) {
/*     */             
/*     */             try {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 116 */               field.setAccessible(true);
/* 117 */               array.add(field);
/* 118 */             } catch (Exception exception) {}
/*     */           }
/*     */         }
/* 121 */         else if (paramArray != null) {
/*     */           String str;
/* 123 */           if ((str = paramClass.getName() + "." + field.getName()).startsWith("com.prineside.tdi2.")) {
/* 124 */             str = str.substring(19);
/*     */           }
/* 126 */           if (!paramArray.contains(str, false)) {
/* 127 */             a.e("skipped " + str + " " + field.getType().getSimpleName(), new Object[0]);
/* 128 */             paramArray.add(str);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 133 */       paramClass = (Class)paramClass.getSuperclass();
/*     */     } 
/*     */     
/* 136 */     array.sort(g);
/*     */     
/* 138 */     b.put(clazz, array);
/*     */     
/* 140 */     return array;
/*     */   }
/*     */   
/*     */   public GameStateSerializer(Class paramClass) {
/* 144 */     throw new IllegalStateException("Should not be used anymore - implement individual serializers");
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
/*     */   private static boolean a(Field paramField) {
/* 168 */     if (Modifier.isStatic(paramField.getModifiers()) || paramField
/* 169 */       .isAnnotationPresent((Class)NAGS.class) || paramField
/* 170 */       .getType().isAnnotationPresent((Class)NAGS.class)) return true;
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
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput, Object paramObject) {
/* 184 */     this.writeCount++;
/*     */ 
/*     */     
/* 187 */     for (byte b = 0; b < this.e.size; b++) {
/* 188 */       Field field = ((Field[])this.e.items)[b];
/*     */       
/*     */       try {
/* 191 */         Class<?> clazz = field.getType();
/* 192 */         if (c.contains(clazz)) {
/*     */ 
/*     */           
/* 195 */           if (d.contains(clazz)) {
/*     */ 
/*     */             
/* 198 */             if (clazz == int.class) {
/* 199 */               paramOutput.writeInt(field.getInt(paramObject), false);
/* 200 */             } else if (clazz == float.class) {
/* 201 */               paramOutput.writeFloat(field.getFloat(paramObject));
/* 202 */             } else if (clazz == boolean.class) {
/* 203 */               paramOutput.writeBoolean(field.getBoolean(paramObject));
/* 204 */             } else if (clazz == byte.class) {
/* 205 */               paramOutput.writeByte(field.getByte(paramObject));
/* 206 */             } else if (clazz == char.class) {
/* 207 */               paramOutput.writeChar(field.getChar(paramObject));
/* 208 */             } else if (clazz == short.class) {
/* 209 */               paramOutput.writeShort(field.getShort(paramObject));
/* 210 */             } else if (clazz == long.class) {
/* 211 */               paramOutput.writeLong(field.getLong(paramObject), false);
/*     */             } else {
/* 213 */               paramOutput.writeDouble(field.getDouble(paramObject));
/*     */             }
/*     */           
/*     */           } else {
/*     */             
/* 218 */             paramKryo.writeObjectOrNull(paramOutput, field.get(paramObject), paramKryo.getSerializer(clazz));
/*     */           } 
/*     */         } else {
/*     */           
/* 222 */           paramKryo.writeClassAndObject(paramOutput, field.get(paramObject));
/*     */         } 
/* 224 */       } catch (Exception exception) {
/* 225 */         throw new IllegalStateException("failed to write field " + field.toGenericString(), exception);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object read(Kryo paramKryo, Input paramInput, Class paramClass) {
/*     */     try {
/* 235 */       Constructor<Object> constructor = null;
/*     */       try {
/* 237 */         constructor = paramClass.getDeclaredConstructor(new Class[0]);
/* 238 */       } catch (Exception exception) {
/* 239 */         a.e("failed to obtain constructor", new Object[] { exception }); Constructor[] arrayOfConstructor; int i; byte b1;
/* 240 */         for (i = (arrayOfConstructor = (Constructor[])paramClass.getDeclaredConstructors()).length, b1 = 0; b1 < i; ) { Constructor constructor1 = arrayOfConstructor[b1];
/* 241 */           a.i((String)constructor1, new Object[0]); b1++; }
/*     */       
/*     */       } 
/* 244 */       constructor.setAccessible(true);
/* 245 */       Object object = constructor.newInstance(new Object[0]);
/* 246 */       paramKryo.reference(object);
/*     */       
/* 248 */       for (byte b = 0; b < this.e.size; b++) {
/*     */         Field field;
/*     */         
/* 251 */         Class<?> clazz = (field = ((Field[])this.e.items)[b]).getType();
/* 252 */         if (c.contains(clazz)) {
/* 253 */           if (d.contains(clazz)) {
/*     */             
/* 255 */             if (clazz == int.class) {
/* 256 */               field.setInt(object, paramInput.readInt(false));
/* 257 */             } else if (clazz == float.class) {
/* 258 */               field.setFloat(object, paramInput.readFloat());
/* 259 */             } else if (clazz == boolean.class) {
/* 260 */               field.setBoolean(object, paramInput.readBoolean());
/* 261 */             } else if (clazz == byte.class) {
/* 262 */               field.setByte(object, paramInput.readByte());
/* 263 */             } else if (clazz == char.class) {
/* 264 */               field.setChar(object, paramInput.readChar());
/* 265 */             } else if (clazz == short.class) {
/* 266 */               field.setShort(object, paramInput.readShort());
/* 267 */             } else if (clazz == long.class) {
/* 268 */               field.setLong(object, paramInput.readLong(false));
/*     */             } else {
/* 270 */               field.setDouble(object, paramInput.readDouble());
/*     */             } 
/*     */           } else {
/* 273 */             field.set(object, paramKryo.readObjectOrNull(paramInput, clazz, paramKryo.getSerializer(clazz)));
/*     */           } 
/*     */         } else {
/* 276 */           field.set(object, paramKryo.readClassAndObject(paramInput));
/*     */         } 
/*     */       } 
/*     */       
/* 280 */       return object;
/* 281 */     } catch (Exception exception) {
/* 282 */       throw new RuntimeException("Failed to create new instance of " + paramClass.getName(), exception);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\GameStateSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */