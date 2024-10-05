/*     */ package com.esotericsoftware.kryo.serializers;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.Serializer;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import java.lang.reflect.Array;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultArraySerializers
/*     */ {
/*     */   public static class ByteArraySerializer
/*     */     extends Serializer<byte[]>
/*     */   {
/*     */     public ByteArraySerializer() {
/*  38 */       setAcceptsNull(true);
/*     */     }
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output, byte[] param1ArrayOfbyte) {
/*  42 */       if (param1ArrayOfbyte == null) {
/*  43 */         param1Output.writeByte((byte)0);
/*     */         return;
/*     */       } 
/*  46 */       param1Output.writeVarInt(param1ArrayOfbyte.length + 1, true);
/*  47 */       param1Output.writeBytes(param1ArrayOfbyte);
/*     */     }
/*     */     
/*     */     public byte[] read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/*     */       int i;
/*  52 */       if ((i = param1Input.readVarInt(true)) == 0) return null; 
/*  53 */       return param1Input.readBytes(i - 1);
/*     */     }
/*     */     
/*     */     public byte[] copy(Kryo param1Kryo, byte[] param1ArrayOfbyte) {
/*  57 */       byte[] arrayOfByte = new byte[param1ArrayOfbyte.length];
/*  58 */       System.arraycopy(param1ArrayOfbyte, 0, arrayOfByte, 0, arrayOfByte.length);
/*  59 */       return arrayOfByte;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class IntArraySerializer extends Serializer<int[]> {
/*     */     public IntArraySerializer() {
/*  65 */       setAcceptsNull(true);
/*     */     }
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output, int[] param1ArrayOfint) {
/*  69 */       if (param1ArrayOfint == null) {
/*  70 */         param1Output.writeByte((byte)0);
/*     */         return;
/*     */       } 
/*  73 */       param1Output.writeVarInt(param1ArrayOfint.length + 1, true);
/*  74 */       param1Output.writeInts(param1ArrayOfint, 0, param1ArrayOfint.length, false);
/*     */     }
/*     */     
/*     */     public int[] read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/*     */       int i;
/*  79 */       if ((i = param1Input.readVarInt(true)) == 0) return null; 
/*  80 */       return param1Input.readInts(i - 1, false);
/*     */     }
/*     */     
/*     */     public int[] copy(Kryo param1Kryo, int[] param1ArrayOfint) {
/*  84 */       int[] arrayOfInt = new int[param1ArrayOfint.length];
/*  85 */       System.arraycopy(param1ArrayOfint, 0, arrayOfInt, 0, arrayOfInt.length);
/*  86 */       return arrayOfInt;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class FloatArraySerializer extends Serializer<float[]> {
/*     */     public FloatArraySerializer() {
/*  92 */       setAcceptsNull(true);
/*     */     }
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output, float[] param1ArrayOffloat) {
/*  96 */       if (param1ArrayOffloat == null) {
/*  97 */         param1Output.writeByte((byte)0);
/*     */         return;
/*     */       } 
/* 100 */       param1Output.writeVarInt(param1ArrayOffloat.length + 1, true);
/* 101 */       param1Output.writeFloats(param1ArrayOffloat, 0, param1ArrayOffloat.length);
/*     */     }
/*     */     
/*     */     public float[] read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/*     */       int i;
/* 106 */       if ((i = param1Input.readVarInt(true)) == 0) return null; 
/* 107 */       return param1Input.readFloats(i - 1);
/*     */     }
/*     */     
/*     */     public float[] copy(Kryo param1Kryo, float[] param1ArrayOffloat) {
/* 111 */       float[] arrayOfFloat = new float[param1ArrayOffloat.length];
/* 112 */       System.arraycopy(param1ArrayOffloat, 0, arrayOfFloat, 0, arrayOfFloat.length);
/* 113 */       return arrayOfFloat;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class LongArraySerializer extends Serializer<long[]> {
/*     */     public LongArraySerializer() {
/* 119 */       setAcceptsNull(true);
/*     */     }
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output, long[] param1ArrayOflong) {
/* 123 */       if (param1ArrayOflong == null) {
/* 124 */         param1Output.writeByte((byte)0);
/*     */         return;
/*     */       } 
/* 127 */       param1Output.writeVarInt(param1ArrayOflong.length + 1, true);
/* 128 */       param1Output.writeLongs(param1ArrayOflong, 0, param1ArrayOflong.length, false);
/*     */     }
/*     */     
/*     */     public long[] read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/*     */       int i;
/* 133 */       if ((i = param1Input.readVarInt(true)) == 0) return null; 
/* 134 */       return param1Input.readLongs(i - 1, false);
/*     */     }
/*     */     
/*     */     public long[] copy(Kryo param1Kryo, long[] param1ArrayOflong) {
/* 138 */       long[] arrayOfLong = new long[param1ArrayOflong.length];
/* 139 */       System.arraycopy(param1ArrayOflong, 0, arrayOfLong, 0, arrayOfLong.length);
/* 140 */       return arrayOfLong;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ShortArraySerializer extends Serializer<short[]> {
/*     */     public ShortArraySerializer() {
/* 146 */       setAcceptsNull(true);
/*     */     }
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output, short[] param1ArrayOfshort) {
/* 150 */       if (param1ArrayOfshort == null) {
/* 151 */         param1Output.writeByte((byte)0);
/*     */         return;
/*     */       } 
/* 154 */       param1Output.writeVarInt(param1ArrayOfshort.length + 1, true);
/* 155 */       param1Output.writeShorts(param1ArrayOfshort, 0, param1ArrayOfshort.length);
/*     */     }
/*     */     
/*     */     public short[] read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/*     */       int i;
/* 160 */       if ((i = param1Input.readVarInt(true)) == 0) return null; 
/* 161 */       return param1Input.readShorts(i - 1);
/*     */     }
/*     */     
/*     */     public short[] copy(Kryo param1Kryo, short[] param1ArrayOfshort) {
/* 165 */       short[] arrayOfShort = new short[param1ArrayOfshort.length];
/* 166 */       System.arraycopy(param1ArrayOfshort, 0, arrayOfShort, 0, arrayOfShort.length);
/* 167 */       return arrayOfShort;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class CharArraySerializer extends Serializer<char[]> {
/*     */     public CharArraySerializer() {
/* 173 */       setAcceptsNull(true);
/*     */     }
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output, char[] param1ArrayOfchar) {
/* 177 */       if (param1ArrayOfchar == null) {
/* 178 */         param1Output.writeByte((byte)0);
/*     */         return;
/*     */       } 
/* 181 */       param1Output.writeVarInt(param1ArrayOfchar.length + 1, true);
/* 182 */       param1Output.writeChars(param1ArrayOfchar, 0, param1ArrayOfchar.length);
/*     */     }
/*     */     
/*     */     public char[] read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/*     */       int i;
/* 187 */       if ((i = param1Input.readVarInt(true)) == 0) return null; 
/* 188 */       return param1Input.readChars(i - 1);
/*     */     }
/*     */     
/*     */     public char[] copy(Kryo param1Kryo, char[] param1ArrayOfchar) {
/* 192 */       char[] arrayOfChar = new char[param1ArrayOfchar.length];
/* 193 */       System.arraycopy(param1ArrayOfchar, 0, arrayOfChar, 0, arrayOfChar.length);
/* 194 */       return arrayOfChar;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class DoubleArraySerializer extends Serializer<double[]> {
/*     */     public DoubleArraySerializer() {
/* 200 */       setAcceptsNull(true);
/*     */     }
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output, double[] param1ArrayOfdouble) {
/* 204 */       if (param1ArrayOfdouble == null) {
/* 205 */         param1Output.writeByte((byte)0);
/*     */         return;
/*     */       } 
/* 208 */       param1Output.writeVarInt(param1ArrayOfdouble.length + 1, true);
/* 209 */       param1Output.writeDoubles(param1ArrayOfdouble, 0, param1ArrayOfdouble.length);
/*     */     }
/*     */     
/*     */     public double[] read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/*     */       int i;
/* 214 */       if ((i = param1Input.readVarInt(true)) == 0) return null; 
/* 215 */       return param1Input.readDoubles(i - 1);
/*     */     }
/*     */     
/*     */     public double[] copy(Kryo param1Kryo, double[] param1ArrayOfdouble) {
/* 219 */       double[] arrayOfDouble = new double[param1ArrayOfdouble.length];
/* 220 */       System.arraycopy(param1ArrayOfdouble, 0, arrayOfDouble, 0, arrayOfDouble.length);
/* 221 */       return arrayOfDouble;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class BooleanArraySerializer extends Serializer<boolean[]> {
/*     */     public BooleanArraySerializer() {
/* 227 */       setAcceptsNull(true);
/*     */     }
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output, boolean[] param1ArrayOfboolean) {
/* 231 */       if (param1ArrayOfboolean == null) {
/* 232 */         param1Output.writeByte((byte)0);
/*     */         return;
/*     */       } 
/* 235 */       param1Output.writeVarInt(param1ArrayOfboolean.length + 1, true); byte b; int i;
/* 236 */       for (b = 0, i = param1ArrayOfboolean.length; b < i; b++)
/* 237 */         param1Output.writeBoolean(param1ArrayOfboolean[b]); 
/*     */     }
/*     */     
/*     */     public boolean[] read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/*     */       int i;
/* 242 */       if ((i = param1Input.readVarInt(true)) == 0) return null; 
/* 243 */       boolean[] arrayOfBoolean = new boolean[--i];
/* 244 */       for (byte b = 0; b < i; b++)
/* 245 */         arrayOfBoolean[b] = param1Input.readBoolean(); 
/* 246 */       return arrayOfBoolean;
/*     */     }
/*     */     
/*     */     public boolean[] copy(Kryo param1Kryo, boolean[] param1ArrayOfboolean) {
/* 250 */       boolean[] arrayOfBoolean = new boolean[param1ArrayOfboolean.length];
/* 251 */       System.arraycopy(param1ArrayOfboolean, 0, arrayOfBoolean, 0, arrayOfBoolean.length);
/* 252 */       return arrayOfBoolean;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class StringArraySerializer extends Serializer<String[]> {
/*     */     public StringArraySerializer() {
/* 258 */       setAcceptsNull(true);
/*     */     }
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output, String[] param1ArrayOfString) {
/* 262 */       if (param1ArrayOfString == null) {
/* 263 */         param1Output.writeByte((byte)0);
/*     */         return;
/*     */       } 
/* 266 */       param1Output.writeVarInt(param1ArrayOfString.length + 1, true);
/* 267 */       if (param1Kryo.getReferences() && param1Kryo.getReferenceResolver().useReferences(String.class)) {
/* 268 */         Serializer serializer = param1Kryo.getSerializer(String.class); byte b1; int j;
/* 269 */         for (b1 = 0, j = param1ArrayOfString.length; b1 < j; b1++)
/* 270 */           param1Kryo.writeObjectOrNull(param1Output, param1ArrayOfString[b1], serializer);  return;
/*     */       }  byte b; int i;
/* 272 */       for (b = 0, i = param1ArrayOfString.length; b < i; b++) {
/* 273 */         param1Output.writeString(param1ArrayOfString[b]);
/*     */       }
/*     */     }
/*     */     
/*     */     public String[] read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/*     */       int i;
/* 279 */       if ((i = param1Input.readVarInt(true)) == 0) return null; 
/* 280 */       String[] arrayOfString = new String[--i];
/* 281 */       if (param1Kryo.getReferences() && param1Kryo.getReferenceResolver().useReferences(String.class)) {
/* 282 */         Serializer serializer = param1Kryo.getSerializer(String.class);
/* 283 */         for (byte b = 0; b < i; b++)
/* 284 */           arrayOfString[b] = (String)param1Kryo.readObjectOrNull(param1Input, String.class, serializer); 
/*     */       } else {
/* 286 */         for (byte b = 0; b < i; b++)
/* 287 */           arrayOfString[b] = param1Input.readString(); 
/*     */       } 
/* 289 */       return arrayOfString;
/*     */     }
/*     */     
/*     */     public String[] copy(Kryo param1Kryo, String[] param1ArrayOfString) {
/* 293 */       String[] arrayOfString = new String[param1ArrayOfString.length];
/* 294 */       System.arraycopy(param1ArrayOfString, 0, arrayOfString, 0, arrayOfString.length);
/* 295 */       return arrayOfString;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ObjectArraySerializer extends Serializer<Object[]> {
/*     */     private boolean elementsAreSameType;
/*     */     private boolean elementsCanBeNull = true;
/*     */     private final Class type;
/*     */     
/*     */     public ObjectArraySerializer(Kryo param1Kryo, Class param1Class) {
/* 305 */       setAcceptsNull(true);
/*     */ 
/*     */ 
/*     */       
/* 309 */       this.type = param1Class;
/* 310 */       Class<?> clazz = param1Class.getComponentType();
/*     */       boolean bool;
/* 312 */       if (bool = (0 != (clazz.getModifiers() & 0x10)) ? true : false) setElementsAreSameType(true); 
/*     */     }
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output, Object[] param1ArrayOfObject) {
/* 316 */       if (param1ArrayOfObject == null) {
/* 317 */         param1Output.writeByte((byte)0);
/*     */         return;
/*     */       } 
/* 320 */       int i = param1ArrayOfObject.length;
/* 321 */       param1Output.writeVarInt(i + 1, true);
/* 322 */       Class<?> clazz = param1ArrayOfObject.getClass().getComponentType();
/* 323 */       if (this.elementsAreSameType || param1Kryo.isFinal(clazz)) {
/* 324 */         Serializer serializer = param1Kryo.getSerializer(clazz);
/* 325 */         if (this.elementsCanBeNull) {
/* 326 */           for (byte b = 0; b < i; b++)
/* 327 */             param1Kryo.writeObjectOrNull(param1Output, param1ArrayOfObject[b], serializer); 
/*     */         } else {
/* 329 */           for (byte b = 0; b < i; b++)
/* 330 */             param1Kryo.writeObject(param1Output, param1ArrayOfObject[b], serializer);  return;
/*     */         } 
/*     */       } else {
/* 333 */         for (byte b = 0; b < i; b++)
/* 334 */           param1Kryo.writeClassAndObject(param1Output, param1ArrayOfObject[b]); 
/*     */       } 
/*     */     }
/*     */     
/*     */     public Object[] read(Kryo param1Kryo, Input param1Input, Class<?> param1Class) {
/*     */       int i;
/* 340 */       if ((i = param1Input.readVarInt(true)) == 0) return null; 
/* 341 */       i--;
/* 342 */       Object[] arrayOfObject = (Object[])Array.newInstance(param1Class.getComponentType(), i);
/* 343 */       param1Kryo.reference(arrayOfObject);
/* 344 */       param1Class = param1Class.getComponentType();
/* 345 */       if (this.elementsAreSameType || param1Kryo.isFinal(param1Class)) {
/* 346 */         Serializer serializer = param1Kryo.getSerializer(param1Class);
/* 347 */         if (this.elementsCanBeNull) {
/* 348 */           for (byte b = 0; b < i; b++)
/* 349 */             arrayOfObject[b] = param1Kryo.readObjectOrNull(param1Input, param1Class, serializer); 
/*     */         } else {
/* 351 */           for (byte b = 0; b < i; b++)
/* 352 */             arrayOfObject[b] = param1Kryo.readObject(param1Input, param1Class, serializer); 
/*     */         } 
/*     */       } else {
/* 355 */         for (byte b = 0; b < i; b++)
/* 356 */           arrayOfObject[b] = param1Kryo.readClassAndObject(param1Input); 
/*     */       } 
/* 358 */       return arrayOfObject;
/*     */     }
/*     */     
/*     */     public Object[] copy(Kryo param1Kryo, Object[] param1ArrayOfObject) {
/* 362 */       int i = param1ArrayOfObject.length;
/* 363 */       Object[] arrayOfObject = (Object[])Array.newInstance(param1ArrayOfObject.getClass().getComponentType(), i);
/* 364 */       param1Kryo.reference(arrayOfObject);
/* 365 */       for (byte b = 0; b < i; b++)
/* 366 */         arrayOfObject[b] = param1Kryo.copy(param1ArrayOfObject[b]); 
/* 367 */       return arrayOfObject;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setElementsCanBeNull(boolean param1Boolean) {
/* 373 */       this.elementsCanBeNull = param1Boolean;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setElementsAreSameType(boolean param1Boolean) {
/* 380 */       this.elementsAreSameType = param1Boolean;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\DefaultArraySerializers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */