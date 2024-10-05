/*     */ package com.esotericsoftware.kryo.serializers;
/*     */ 
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.esotericsoftware.kryo.unsafe.UnsafeUtil;
/*     */ import com.esotericsoftware.kryo.util.Generics;
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
/*     */ 
/*     */ class UnsafeField
/*     */   extends ReflectField
/*     */ {
/*     */   public UnsafeField(Field paramField, FieldSerializer paramFieldSerializer, Generics.GenericType paramGenericType) {
/*  37 */     super(paramField, paramFieldSerializer, paramGenericType);
/*  38 */     this.offset = UnsafeUtil.unsafe.objectFieldOffset(paramField);
/*     */   }
/*     */   
/*     */   public Object get(Object paramObject) {
/*  42 */     return UnsafeUtil.unsafe.getObject(paramObject, this.offset);
/*     */   }
/*     */   
/*     */   public void set(Object paramObject1, Object paramObject2) {
/*  46 */     UnsafeUtil.unsafe.putObject(paramObject1, this.offset, paramObject2);
/*     */   }
/*     */   
/*     */   public void copy(Object paramObject1, Object paramObject2) {
/*     */     try {
/*  51 */       UnsafeUtil.unsafe.putObject(paramObject2, this.offset, this.fieldSerializer.kryo.copy(UnsafeUtil.unsafe.getObject(paramObject1, this.offset))); return;
/*  52 */     } catch (KryoException kryoException) {
/*  53 */       (paramObject1 = null).addTrace(this + " (" + this.fieldSerializer.type.getName() + ")");
/*  54 */       throw paramObject1;
/*  55 */     } catch (Throwable throwable) {
/*     */       KryoException kryoException;
/*  57 */       (kryoException = new KryoException(throwable)).addTrace(this + " (" + this.fieldSerializer.type.getName() + ")");
/*  58 */       throw kryoException;
/*     */     } 
/*     */   }
/*     */   
/*     */   static final class IntUnsafeField extends FieldSerializer.CachedField {
/*     */     public IntUnsafeField(Field param1Field) {
/*  64 */       super(param1Field);
/*  65 */       this.offset = UnsafeUtil.unsafe.objectFieldOffset(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/*  69 */       if (this.varEncoding) {
/*  70 */         param1Output.writeVarInt(UnsafeUtil.unsafe.getInt(param1Object, this.offset), false); return;
/*     */       } 
/*  72 */       param1Output.writeInt(UnsafeUtil.unsafe.getInt(param1Object, this.offset));
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/*  76 */       if (this.varEncoding) {
/*  77 */         UnsafeUtil.unsafe.putInt(param1Object, this.offset, param1Input.readVarInt(false)); return;
/*     */       } 
/*  79 */       UnsafeUtil.unsafe.putInt(param1Object, this.offset, param1Input.readInt());
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/*  83 */       UnsafeUtil.unsafe.putInt(param1Object2, this.offset, UnsafeUtil.unsafe.getInt(param1Object1, this.offset));
/*     */     }
/*     */   }
/*     */   
/*     */   static final class FloatUnsafeField extends FieldSerializer.CachedField {
/*     */     public FloatUnsafeField(Field param1Field) {
/*  89 */       super(param1Field);
/*  90 */       this.offset = UnsafeUtil.unsafe.objectFieldOffset(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/*  94 */       param1Output.writeFloat(UnsafeUtil.unsafe.getFloat(param1Object, this.offset));
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/*  98 */       UnsafeUtil.unsafe.putFloat(param1Object, this.offset, param1Input.readFloat());
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/* 102 */       UnsafeUtil.unsafe.putFloat(param1Object2, this.offset, UnsafeUtil.unsafe.getFloat(param1Object1, this.offset));
/*     */     }
/*     */   }
/*     */   
/*     */   static final class ShortUnsafeField extends FieldSerializer.CachedField {
/*     */     public ShortUnsafeField(Field param1Field) {
/* 108 */       super(param1Field);
/* 109 */       this.offset = UnsafeUtil.unsafe.objectFieldOffset(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/* 113 */       param1Output.writeShort(UnsafeUtil.unsafe.getShort(param1Object, this.offset));
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/* 117 */       UnsafeUtil.unsafe.putShort(param1Object, this.offset, param1Input.readShort());
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/* 121 */       UnsafeUtil.unsafe.putShort(param1Object2, this.offset, UnsafeUtil.unsafe.getShort(param1Object1, this.offset));
/*     */     }
/*     */   }
/*     */   
/*     */   static final class ByteUnsafeField extends FieldSerializer.CachedField {
/*     */     public ByteUnsafeField(Field param1Field) {
/* 127 */       super(param1Field);
/* 128 */       this.offset = UnsafeUtil.unsafe.objectFieldOffset(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/* 132 */       param1Output.writeByte(UnsafeUtil.unsafe.getByte(param1Object, this.offset));
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/* 136 */       UnsafeUtil.unsafe.putByte(param1Object, this.offset, param1Input.readByte());
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/* 140 */       UnsafeUtil.unsafe.putByte(param1Object2, this.offset, UnsafeUtil.unsafe.getByte(param1Object1, this.offset));
/*     */     }
/*     */   }
/*     */   
/*     */   static final class BooleanUnsafeField extends FieldSerializer.CachedField {
/*     */     public BooleanUnsafeField(Field param1Field) {
/* 146 */       super(param1Field);
/* 147 */       this.offset = UnsafeUtil.unsafe.objectFieldOffset(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/* 151 */       param1Output.writeBoolean(UnsafeUtil.unsafe.getBoolean(param1Object, this.offset));
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/* 155 */       UnsafeUtil.unsafe.putBoolean(param1Object, this.offset, param1Input.readBoolean());
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/* 159 */       UnsafeUtil.unsafe.putBoolean(param1Object2, this.offset, UnsafeUtil.unsafe.getBoolean(param1Object1, this.offset));
/*     */     }
/*     */   }
/*     */   
/*     */   static final class CharUnsafeField extends FieldSerializer.CachedField {
/*     */     public CharUnsafeField(Field param1Field) {
/* 165 */       super(param1Field);
/* 166 */       this.offset = UnsafeUtil.unsafe.objectFieldOffset(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/* 170 */       param1Output.writeChar(UnsafeUtil.unsafe.getChar(param1Object, this.offset));
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/* 174 */       UnsafeUtil.unsafe.putChar(param1Object, this.offset, param1Input.readChar());
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/* 178 */       UnsafeUtil.unsafe.putChar(param1Object2, this.offset, UnsafeUtil.unsafe.getChar(param1Object1, this.offset));
/*     */     }
/*     */   }
/*     */   
/*     */   static final class LongUnsafeField extends FieldSerializer.CachedField {
/*     */     public LongUnsafeField(Field param1Field) {
/* 184 */       super(param1Field);
/* 185 */       this.offset = UnsafeUtil.unsafe.objectFieldOffset(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/* 189 */       if (this.varEncoding) {
/* 190 */         param1Output.writeVarLong(UnsafeUtil.unsafe.getLong(param1Object, this.offset), false); return;
/*     */       } 
/* 192 */       param1Output.writeLong(UnsafeUtil.unsafe.getLong(param1Object, this.offset));
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/* 196 */       if (this.varEncoding) {
/* 197 */         UnsafeUtil.unsafe.putLong(param1Object, this.offset, param1Input.readVarLong(false)); return;
/*     */       } 
/* 199 */       UnsafeUtil.unsafe.putLong(param1Object, this.offset, param1Input.readLong());
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/* 203 */       UnsafeUtil.unsafe.putLong(param1Object2, this.offset, UnsafeUtil.unsafe.getLong(param1Object1, this.offset));
/*     */     }
/*     */   }
/*     */   
/*     */   static final class DoubleUnsafeField extends FieldSerializer.CachedField {
/*     */     public DoubleUnsafeField(Field param1Field) {
/* 209 */       super(param1Field);
/* 210 */       this.offset = UnsafeUtil.unsafe.objectFieldOffset(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/* 214 */       param1Output.writeDouble(UnsafeUtil.unsafe.getDouble(param1Object, this.offset));
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/* 218 */       UnsafeUtil.unsafe.putDouble(param1Object, this.offset, param1Input.readDouble());
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/* 222 */       UnsafeUtil.unsafe.putDouble(param1Object2, this.offset, UnsafeUtil.unsafe.getDouble(param1Object1, this.offset));
/*     */     }
/*     */   }
/*     */   
/*     */   static final class StringUnsafeField extends FieldSerializer.CachedField {
/*     */     public StringUnsafeField(Field param1Field) {
/* 228 */       super(param1Field);
/* 229 */       this.offset = UnsafeUtil.unsafe.objectFieldOffset(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/* 233 */       param1Output.writeString((String)UnsafeUtil.unsafe.getObject(param1Object, this.offset));
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/* 237 */       UnsafeUtil.unsafe.putObject(param1Object, this.offset, param1Input.readString());
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/* 241 */       UnsafeUtil.unsafe.putObject(param1Object2, this.offset, UnsafeUtil.unsafe.getObject(param1Object1, this.offset));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\UnsafeField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */