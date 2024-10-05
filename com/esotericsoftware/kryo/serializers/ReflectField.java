/*     */ package com.esotericsoftware.kryo.serializers;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import com.esotericsoftware.kryo.Registration;
/*     */ import com.esotericsoftware.kryo.Serializer;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.esotericsoftware.kryo.util.Generics;
/*     */ import com.esotericsoftware.kryo.util.Util;
/*     */ import java.lang.reflect.Field;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ReflectField
/*     */   extends FieldSerializer.CachedField
/*     */ {
/*     */   final FieldSerializer fieldSerializer;
/*     */   final Generics.GenericType genericType;
/*     */   
/*     */   ReflectField(Field paramField, FieldSerializer paramFieldSerializer, Generics.GenericType paramGenericType) {
/*  42 */     super(paramField);
/*  43 */     this.fieldSerializer = paramFieldSerializer;
/*  44 */     this.genericType = paramGenericType;
/*     */   }
/*     */   
/*     */   public Object get(Object paramObject) {
/*  48 */     return this.field.get(paramObject);
/*     */   }
/*     */   
/*     */   public void set(Object paramObject1, Object paramObject2) {
/*  52 */     this.field.set(paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void write(Output paramOutput, Object paramObject) {
/*  56 */     Kryo kryo = this.fieldSerializer.kryo; try {
/*     */       Registration registration;
/*  58 */       Object object = get(paramObject);
/*     */       
/*  60 */       Serializer serializer = this.serializer;
/*     */       Class clazz;
/*  62 */       if ((clazz = resolveFieldClass()) == null)
/*     */       
/*  64 */       { if (object == null) {
/*  65 */           kryo.writeClass(paramOutput, null);
/*     */           return;
/*     */         } 
/*  68 */         registration = kryo.writeClass(paramOutput, object.getClass());
/*  69 */         if (serializer == null) serializer = registration.getSerializer(); 
/*  70 */         kryo.getGenerics().pushGenericType(this.genericType); }
/*     */       else
/*     */       
/*  73 */       { if (serializer == null) {
/*  74 */           serializer = kryo.getSerializer((Class)registration);
/*     */           
/*  76 */           if (this.valueClass != null && this.reuseSerializer) this.serializer = serializer; 
/*     */         } 
/*  78 */         kryo.getGenerics().pushGenericType(this.genericType);
/*  79 */         if (this.canBeNull) {
/*  80 */           kryo.writeObjectOrNull(paramOutput, object, serializer);
/*     */         } else {
/*  82 */           if (object == null) {
/*  83 */             throw new KryoException("Field value cannot be null when canBeNull is false: " + this.name + " (" + paramObject
/*  84 */                 .getClass().getName() + ")");
/*     */           }
/*  86 */           kryo.writeObject(paramOutput, object, serializer);
/*     */         } 
/*     */         
/*  89 */         kryo.getGenerics().popGenericType(); return; }  kryo.writeObject(paramOutput, object, serializer);
/*  90 */     } catch (IllegalAccessException illegalAccessException) {
/*  91 */       throw new KryoException("Error accessing field: " + this.name + " (" + paramObject.getClass().getName() + ")", illegalAccessException);
/*  92 */     } catch (KryoException kryoException2) {
/*  93 */       KryoException kryoException1; (kryoException1 = null).addTrace(this.name + " (" + paramObject.getClass().getName() + ")");
/*  94 */       throw kryoException1;
/*  95 */     } catch (StackOverflowError stackOverflowError) {
/*  96 */       throw new KryoException("A StackOverflow occurred. The most likely cause is that your data has a circular reference resulting in infinite recursion. Try enabling references with Kryo.setReferences(true). If your data structure is really more than " + kryo
/*     */ 
/*     */           
/*  99 */           .getDepth() + " levels deep then try increasing your Java stack size.", stackOverflowError);
/*     */     }
/* 101 */     catch (Throwable throwable) {
/*     */       KryoException kryoException;
/* 103 */       (kryoException = new KryoException(throwable)).addTrace(this.name + " (" + paramObject.getClass().getName() + ")");
/* 104 */       throw kryoException;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void read(Input paramInput, Object paramObject) {
/* 109 */     Kryo kryo = this.fieldSerializer.kryo;
/*     */     try {
/*     */       Object object;
/*     */       Registration registration;
/* 113 */       Serializer serializer = this.serializer;
/*     */       Class clazz;
/* 115 */       if ((clazz = resolveFieldClass()) == null) {
/*     */ 
/*     */         
/* 118 */         if ((registration = kryo.readClass(paramInput)) == null) {
/* 119 */           set(paramObject, (Object)null);
/*     */           return;
/*     */         } 
/* 122 */         if (serializer == null) serializer = registration.getSerializer(); 
/* 123 */         kryo.getGenerics().pushGenericType(this.genericType);
/* 124 */         object = kryo.readObject(paramInput, registration.getType(), serializer);
/*     */       } else {
/* 126 */         if (serializer == null) {
/* 127 */           serializer = kryo.getSerializer((Class)registration);
/*     */           
/* 129 */           if (this.valueClass != null && this.reuseSerializer) this.serializer = serializer; 
/*     */         } 
/* 131 */         kryo.getGenerics().pushGenericType(this.genericType);
/* 132 */         if (this.canBeNull) {
/* 133 */           object = kryo.readObjectOrNull((Input)object, (Class)registration, serializer);
/*     */         } else {
/* 135 */           object = kryo.readObject((Input)object, (Class)registration, serializer);
/*     */         } 
/* 137 */       }  kryo.getGenerics().popGenericType();
/*     */       
/* 139 */       set(paramObject, object); return;
/* 140 */     } catch (IllegalAccessException illegalAccessException) {
/* 141 */       throw new KryoException("Error accessing field: " + this.name + " (" + this.fieldSerializer.type.getName() + ")", illegalAccessException);
/* 142 */     } catch (KryoException kryoException) {
/* 143 */       (paramInput = null).addTrace(this.name + " (" + this.fieldSerializer.type.getName() + ")");
/* 144 */       throw paramInput;
/* 145 */     } catch (Throwable throwable) {
/*     */       KryoException kryoException;
/* 147 */       (kryoException = new KryoException(throwable)).addTrace(this.name + " (" + this.fieldSerializer.type.getName() + ")");
/* 148 */       throw kryoException;
/*     */     } 
/*     */   }
/*     */   Class resolveFieldClass() {
/*     */     Class clazz;
/* 153 */     if (this.valueClass == null && (
/*     */       
/* 155 */       clazz = this.genericType.resolve(this.fieldSerializer.kryo.getGenerics())) != null && this.fieldSerializer.kryo.isFinal(clazz)) {
/* 156 */       return this.field.getType().isArray() ? Util.getArrayType(clazz) : clazz;
/*     */     }
/*     */     
/* 159 */     return this.valueClass;
/*     */   }
/*     */   
/*     */   public void copy(Object paramObject1, Object paramObject2) {
/*     */     try {
/* 164 */       set(paramObject2, this.fieldSerializer.kryo.copy(get(paramObject1))); return;
/* 165 */     } catch (IllegalAccessException illegalAccessException) {
/* 166 */       throw new KryoException("Error accessing field: " + this.name + " (" + this.fieldSerializer.type.getName() + ")", illegalAccessException);
/* 167 */     } catch (KryoException kryoException) {
/* 168 */       (paramObject1 = null).addTrace(this.name + " (" + this.fieldSerializer.type.getName() + ")");
/* 169 */       throw paramObject1;
/* 170 */     } catch (Throwable throwable) {
/*     */       KryoException kryoException;
/* 172 */       (kryoException = new KryoException(throwable)).addTrace(this.name + " (" + this.fieldSerializer.type.getName() + ")");
/* 173 */       throw kryoException;
/*     */     } 
/*     */   }
/*     */   
/*     */   static final class IntReflectField extends FieldSerializer.CachedField {
/*     */     public IntReflectField(Field param1Field) {
/* 179 */       super(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/*     */       try {
/* 184 */         if (this.varEncoding)
/* 185 */         { param1Output.writeVarInt(this.field.getInt(param1Object), false); }
/*     */         else
/* 187 */         { param1Output.writeInt(this.field.getInt(param1Object)); return; } 
/* 188 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 190 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (int)");
/* 191 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/*     */       try {
/* 197 */         if (this.varEncoding)
/* 198 */         { this.field.setInt(param1Object, param1Input.readVarInt(false)); }
/*     */         else
/* 200 */         { this.field.setInt(param1Object, param1Input.readInt()); return; } 
/* 201 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 203 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (int)");
/* 204 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/*     */       try {
/* 210 */         this.field.setInt(param1Object2, this.field.getInt(param1Object1)); return;
/* 211 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 213 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (int)");
/* 214 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   static final class FloatReflectField extends FieldSerializer.CachedField {
/*     */     public FloatReflectField(Field param1Field) {
/* 221 */       super(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/*     */       try {
/* 226 */         param1Output.writeFloat(this.field.getFloat(param1Object)); return;
/* 227 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 229 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (float)");
/* 230 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/*     */       try {
/* 236 */         this.field.setFloat(param1Object, param1Input.readFloat()); return;
/* 237 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 239 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (float)");
/* 240 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/*     */       try {
/* 246 */         this.field.setFloat(param1Object2, this.field.getFloat(param1Object1)); return;
/* 247 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 249 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (float)");
/* 250 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   static final class ShortReflectField extends FieldSerializer.CachedField {
/*     */     public ShortReflectField(Field param1Field) {
/* 257 */       super(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/*     */       try {
/* 262 */         param1Output.writeShort(this.field.getShort(param1Object)); return;
/* 263 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 265 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (short)");
/* 266 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/*     */       try {
/* 272 */         this.field.setShort(param1Object, param1Input.readShort()); return;
/* 273 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 275 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (short)");
/* 276 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/*     */       try {
/* 282 */         this.field.setShort(param1Object2, this.field.getShort(param1Object1)); return;
/* 283 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 285 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (short)");
/* 286 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   static final class ByteReflectField extends FieldSerializer.CachedField {
/*     */     public ByteReflectField(Field param1Field) {
/* 293 */       super(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/*     */       try {
/* 298 */         param1Output.writeByte(this.field.getByte(param1Object)); return;
/* 299 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 301 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (byte)");
/* 302 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/*     */       try {
/* 308 */         this.field.setByte(param1Object, param1Input.readByte()); return;
/* 309 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 311 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (byte)");
/* 312 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/*     */       try {
/* 318 */         this.field.setByte(param1Object2, this.field.getByte(param1Object1)); return;
/* 319 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 321 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (byte)");
/* 322 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   static final class BooleanReflectField extends FieldSerializer.CachedField {
/*     */     public BooleanReflectField(Field param1Field) {
/* 329 */       super(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/*     */       try {
/* 334 */         param1Output.writeBoolean(this.field.getBoolean(param1Object)); return;
/* 335 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 337 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (boolean)");
/* 338 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/*     */       try {
/* 344 */         this.field.setBoolean(param1Object, param1Input.readBoolean()); return;
/* 345 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 347 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (boolean)");
/* 348 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/*     */       try {
/* 354 */         this.field.setBoolean(param1Object2, this.field.getBoolean(param1Object1)); return;
/* 355 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 357 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (boolean)");
/* 358 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   static final class CharReflectField extends FieldSerializer.CachedField {
/*     */     public CharReflectField(Field param1Field) {
/* 365 */       super(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/*     */       try {
/* 370 */         param1Output.writeChar(this.field.getChar(param1Object)); return;
/* 371 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 373 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (char)");
/* 374 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/*     */       try {
/* 380 */         this.field.setChar(param1Object, param1Input.readChar()); return;
/* 381 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 383 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (char)");
/* 384 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/*     */       try {
/* 390 */         this.field.setChar(param1Object2, this.field.getChar(param1Object1)); return;
/* 391 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 393 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (char)");
/* 394 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   static final class LongReflectField extends FieldSerializer.CachedField {
/*     */     public LongReflectField(Field param1Field) {
/* 401 */       super(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/*     */       try {
/* 406 */         if (this.varEncoding)
/* 407 */         { param1Output.writeVarLong(this.field.getLong(param1Object), false); }
/*     */         else
/* 409 */         { param1Output.writeLong(this.field.getLong(param1Object)); return; } 
/* 410 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 412 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (long)");
/* 413 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/*     */       try {
/* 419 */         if (this.varEncoding)
/* 420 */         { this.field.setLong(param1Object, param1Input.readVarLong(false)); }
/*     */         else
/* 422 */         { this.field.setLong(param1Object, param1Input.readLong()); return; } 
/* 423 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 425 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (long)");
/* 426 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/*     */       try {
/* 432 */         this.field.setLong(param1Object2, this.field.getLong(param1Object1)); return;
/* 433 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 435 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (long)");
/* 436 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   static final class DoubleReflectField extends FieldSerializer.CachedField {
/*     */     public DoubleReflectField(Field param1Field) {
/* 443 */       super(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/*     */       try {
/* 448 */         param1Output.writeDouble(this.field.getDouble(param1Object)); return;
/* 449 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 451 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (double)");
/* 452 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/*     */       try {
/* 458 */         this.field.setDouble(param1Object, param1Input.readDouble()); return;
/* 459 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 461 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (double)");
/* 462 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/*     */       try {
/* 468 */         this.field.setDouble(param1Object2, this.field.getDouble(param1Object1)); return;
/* 469 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 471 */         (kryoException = new KryoException(throwable)).addTrace(this.name + " (double)");
/* 472 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\ReflectField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */