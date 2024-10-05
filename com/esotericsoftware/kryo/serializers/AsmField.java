/*     */ package com.esotericsoftware.kryo.serializers;
/*     */ 
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
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
/*     */ class AsmField
/*     */   extends ReflectField
/*     */ {
/*     */   public AsmField(Field paramField, FieldSerializer paramFieldSerializer, Generics.GenericType paramGenericType) {
/*  34 */     super(paramField, paramFieldSerializer, paramGenericType);
/*     */   }
/*     */   
/*     */   public Object get(Object paramObject) {
/*  38 */     return this.access.get(paramObject, this.accessIndex);
/*     */   }
/*     */   
/*     */   public void set(Object paramObject1, Object paramObject2) {
/*  42 */     this.access.set(paramObject1, this.accessIndex, paramObject2);
/*     */   }
/*     */   
/*     */   public void copy(Object paramObject1, Object paramObject2) {
/*     */     try {
/*  47 */       this.access.set(paramObject2, this.accessIndex, this.fieldSerializer.kryo.copy(this.access.get(paramObject1, this.accessIndex))); return;
/*  48 */     } catch (KryoException kryoException) {
/*  49 */       (paramObject1 = null).addTrace(this + " (" + this.fieldSerializer.type.getName() + ")");
/*  50 */       throw paramObject1;
/*  51 */     } catch (Throwable throwable) {
/*     */       KryoException kryoException;
/*  53 */       (kryoException = new KryoException(throwable)).addTrace(this + " (" + this.fieldSerializer.type.getName() + ")");
/*  54 */       throw kryoException;
/*     */     } 
/*     */   }
/*     */   
/*     */   static final class IntAsmField extends FieldSerializer.CachedField {
/*     */     public IntAsmField(Field param1Field) {
/*  60 */       super(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/*  64 */       if (this.varEncoding) {
/*  65 */         param1Output.writeVarInt(this.access.getInt(param1Object, this.accessIndex), false); return;
/*     */       } 
/*  67 */       param1Output.writeInt(this.access.getInt(param1Object, this.accessIndex));
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/*  71 */       if (this.varEncoding) {
/*  72 */         this.access.setInt(param1Object, this.accessIndex, param1Input.readVarInt(false)); return;
/*     */       } 
/*  74 */       this.access.setInt(param1Object, this.accessIndex, param1Input.readInt());
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/*  78 */       this.access.setInt(param1Object2, this.accessIndex, this.access.getInt(param1Object1, this.accessIndex));
/*     */     }
/*     */   }
/*     */   
/*     */   static final class FloatAsmField extends FieldSerializer.CachedField {
/*     */     public FloatAsmField(Field param1Field) {
/*  84 */       super(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/*  88 */       param1Output.writeFloat(this.access.getFloat(param1Object, this.accessIndex));
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/*  92 */       this.access.setFloat(param1Object, this.accessIndex, param1Input.readFloat());
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/*  96 */       this.access.setFloat(param1Object2, this.accessIndex, this.access.getFloat(param1Object1, this.accessIndex));
/*     */     }
/*     */   }
/*     */   
/*     */   static final class ShortAsmField extends FieldSerializer.CachedField {
/*     */     public ShortAsmField(Field param1Field) {
/* 102 */       super(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/* 106 */       param1Output.writeShort(this.access.getShort(param1Object, this.accessIndex));
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/* 110 */       this.access.setShort(param1Object, this.accessIndex, param1Input.readShort());
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/* 114 */       this.access.setShort(param1Object2, this.accessIndex, this.access.getShort(param1Object1, this.accessIndex));
/*     */     }
/*     */   }
/*     */   
/*     */   static final class ByteAsmField extends FieldSerializer.CachedField {
/*     */     public ByteAsmField(Field param1Field) {
/* 120 */       super(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/* 124 */       param1Output.writeByte(this.access.getByte(param1Object, this.accessIndex));
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/* 128 */       this.access.setByte(param1Object, this.accessIndex, param1Input.readByte());
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/* 132 */       this.access.setByte(param1Object2, this.accessIndex, this.access.getByte(param1Object1, this.accessIndex));
/*     */     }
/*     */   }
/*     */   
/*     */   static final class BooleanAsmField extends FieldSerializer.CachedField {
/*     */     public BooleanAsmField(Field param1Field) {
/* 138 */       super(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/* 142 */       param1Output.writeBoolean(this.access.getBoolean(param1Object, this.accessIndex));
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/* 146 */       this.access.setBoolean(param1Object, this.accessIndex, param1Input.readBoolean());
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/* 150 */       this.access.setBoolean(param1Object2, this.accessIndex, this.access.getBoolean(param1Object1, this.accessIndex));
/*     */     }
/*     */   }
/*     */   
/*     */   static final class CharAsmField extends FieldSerializer.CachedField {
/*     */     public CharAsmField(Field param1Field) {
/* 156 */       super(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/* 160 */       param1Output.writeChar(this.access.getChar(param1Object, this.accessIndex));
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/* 164 */       this.access.setChar(param1Object, this.accessIndex, param1Input.readChar());
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/* 168 */       this.access.setChar(param1Object2, this.accessIndex, this.access.getChar(param1Object1, this.accessIndex));
/*     */     }
/*     */   }
/*     */   
/*     */   static final class LongAsmField extends FieldSerializer.CachedField {
/*     */     public LongAsmField(Field param1Field) {
/* 174 */       super(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/* 178 */       if (this.varEncoding) {
/* 179 */         param1Output.writeVarLong(this.access.getLong(param1Object, this.accessIndex), false); return;
/*     */       } 
/* 181 */       param1Output.writeLong(this.access.getLong(param1Object, this.accessIndex));
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/* 185 */       if (this.varEncoding) {
/* 186 */         this.access.setLong(param1Object, this.accessIndex, param1Input.readVarLong(false)); return;
/*     */       } 
/* 188 */       this.access.setLong(param1Object, this.accessIndex, param1Input.readLong());
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/* 192 */       this.access.setLong(param1Object2, this.accessIndex, this.access.getLong(param1Object1, this.accessIndex));
/*     */     }
/*     */   }
/*     */   
/*     */   static final class DoubleAsmField extends FieldSerializer.CachedField {
/*     */     public DoubleAsmField(Field param1Field) {
/* 198 */       super(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/* 202 */       param1Output.writeDouble(this.access.getDouble(param1Object, this.accessIndex));
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/* 206 */       this.access.setDouble(param1Object, this.accessIndex, param1Input.readDouble());
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/* 210 */       this.access.setDouble(param1Object2, this.accessIndex, this.access.getDouble(param1Object1, this.accessIndex));
/*     */     }
/*     */   }
/*     */   
/*     */   static final class StringAsmField extends FieldSerializer.CachedField {
/*     */     public StringAsmField(Field param1Field) {
/* 216 */       super(param1Field);
/*     */     }
/*     */     
/*     */     public final void write(Output param1Output, Object param1Object) {
/* 220 */       param1Output.writeString(this.access.getString(param1Object, this.accessIndex));
/*     */     }
/*     */     
/*     */     public final void read(Input param1Input, Object param1Object) {
/* 224 */       this.access.set(param1Object, this.accessIndex, param1Input.readString());
/*     */     }
/*     */     
/*     */     public final void copy(Object param1Object1, Object param1Object2) {
/* 228 */       this.access.set(param1Object2, this.accessIndex, this.access.getString(param1Object1, this.accessIndex));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\AsmField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */