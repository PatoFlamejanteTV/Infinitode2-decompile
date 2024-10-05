/*     */ package com.esotericsoftware.kryo.serializers;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import com.esotericsoftware.kryo.Serializer;
/*     */ import com.esotericsoftware.kryo.SerializerFactory;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.esotericsoftware.kryo.util.Generics;
/*     */ import com.esotericsoftware.kryo.util.Util;
/*     */ import com.esotericsoftware.minlog.Log;
/*     */ import com.esotericsoftware.reflectasm.FieldAccess;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FieldSerializer<T>
/*     */   extends Serializer<T>
/*     */ {
/*     */   final Kryo kryo;
/*     */   final Class type;
/*     */   final FieldSerializerConfig config;
/*     */   final CachedFields cachedFields;
/*     */   private final Generics.GenericsHierarchy genericsHierarchy;
/*     */   
/*     */   public FieldSerializer(Kryo paramKryo, Class paramClass) {
/*  68 */     this(paramKryo, paramClass, new FieldSerializerConfig());
/*     */   }
/*     */   
/*     */   public FieldSerializer(Kryo paramKryo, Class paramClass, FieldSerializerConfig paramFieldSerializerConfig) {
/*  72 */     if (paramClass == null) throw new IllegalArgumentException("type cannot be null."); 
/*  73 */     if (paramClass.isPrimitive()) throw new IllegalArgumentException("type cannot be a primitive class: " + paramClass); 
/*  74 */     if (paramFieldSerializerConfig == null) throw new IllegalArgumentException("config cannot be null."); 
/*  75 */     this.kryo = paramKryo;
/*  76 */     this.type = paramClass;
/*  77 */     this.config = paramFieldSerializerConfig;
/*     */     
/*  79 */     this.genericsHierarchy = new Generics.GenericsHierarchy(paramClass);
/*     */     
/*  81 */     this.cachedFields = new CachedFields(this);
/*  82 */     this.cachedFields.rebuild();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initializeCachedFields() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public FieldSerializerConfig getFieldSerializerConfig() {
/*  92 */     return this.config;
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateFields() {
/*  97 */     if (Log.TRACE) Log.trace("kryo", "Update fields: " + Util.className(this.type)); 
/*  98 */     this.cachedFields.rebuild();
/*     */   }
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput, T paramT) {
/* 102 */     int i = pushTypeVariables();
/*     */     
/* 104 */     CachedField[] arrayOfCachedField = this.cachedFields.fields; byte b; int j;
/* 105 */     for (b = 0, j = arrayOfCachedField.length; b < j; b++) {
/* 106 */       if (Log.TRACE) log("Write", arrayOfCachedField[b], paramOutput.position()); 
/*     */       try {
/* 108 */         arrayOfCachedField[b].write(paramOutput, paramT);
/* 109 */       } catch (KryoException kryoException2) {
/* 110 */         KryoException kryoException1; throw kryoException1 = null;
/* 111 */       } catch (OutOfMemoryError|Exception outOfMemoryError) {
/* 112 */         throw new KryoException("Error writing " + arrayOfCachedField[b] + " at position " + paramOutput.position(), outOfMemoryError);
/*     */       } 
/*     */     } 
/*     */     
/* 116 */     popTypeVariables(outOfMemoryError);
/*     */   }
/*     */   
/*     */   public T read(Kryo paramKryo, Input paramInput, Class<? extends T> paramClass) {
/* 120 */     int i = pushTypeVariables();
/*     */     
/* 122 */     paramClass = (Class<? extends T>)create(paramKryo, paramInput, paramClass);
/* 123 */     paramKryo.reference(paramClass);
/*     */     
/* 125 */     CachedField[] arrayOfCachedField = this.cachedFields.fields; byte b; int j;
/* 126 */     for (b = 0, j = arrayOfCachedField.length; b < j; b++) {
/* 127 */       if (Log.TRACE) log("Read", arrayOfCachedField[b], paramInput.position()); 
/*     */       try {
/* 129 */         arrayOfCachedField[b].read(paramInput, paramClass);
/* 130 */       } catch (KryoException kryoException) {
/* 131 */         throw paramClass = null;
/* 132 */       } catch (OutOfMemoryError|Exception outOfMemoryError) {
/* 133 */         throw new KryoException("Error reading " + arrayOfCachedField[b] + " at position " + paramInput.position(), outOfMemoryError);
/*     */       } 
/*     */     } 
/*     */     
/* 137 */     popTypeVariables(i);
/* 138 */     return (T)outOfMemoryError;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int pushTypeVariables() {
/*     */     Generics.GenericType[] arrayOfGenericType;
/* 145 */     if ((arrayOfGenericType = this.kryo.getGenerics().nextGenericTypes()) == null) return 0;
/*     */     
/* 147 */     int i = this.kryo.getGenerics().pushTypeVariables(this.genericsHierarchy, arrayOfGenericType);
/* 148 */     if (Log.TRACE && i > 0) Log.trace("kryo", "Generics: " + this.kryo.getGenerics()); 
/* 149 */     return i;
/*     */   }
/*     */   
/*     */   protected void popTypeVariables(int paramInt) {
/* 153 */     Generics generics = this.kryo.getGenerics();
/* 154 */     if (paramInt > 0) {
/* 155 */       generics.popTypeVariables(paramInt);
/*     */     }
/* 157 */     generics.popGenericType();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected T create(Kryo paramKryo, Input paramInput, Class<? extends T> paramClass) {
/* 163 */     return (T)paramKryo.newInstance(paramClass);
/*     */   }
/*     */   
/*     */   protected void log(String paramString, CachedField paramCachedField, int paramInt) {
/*     */     String str;
/* 168 */     if (paramCachedField instanceof ReflectField) {
/*     */       ReflectField reflectField;
/*     */       Class<?> clazz;
/* 171 */       if ((clazz = (reflectField = (ReflectField)paramCachedField).resolveFieldClass()) == null) clazz = paramCachedField.field.getType(); 
/* 172 */       str = Util.simpleName(clazz, reflectField.genericType);
/*     */     }
/* 174 */     else if (paramCachedField.valueClass != null) {
/* 175 */       str = paramCachedField.valueClass.getSimpleName();
/*     */     } else {
/* 177 */       str = paramCachedField.field.getType().getSimpleName();
/*     */     } 
/* 179 */     Log.trace("kryo", paramString + " field " + str + ": " + paramCachedField.name + " (" + 
/* 180 */         Util.className(paramCachedField.field.getDeclaringClass()) + ')' + Util.pos(paramInt));
/*     */   } public CachedField getField(String paramString) {
/*     */     CachedField[] arrayOfCachedField;
/*     */     int i;
/*     */     byte b;
/* 185 */     for (i = (arrayOfCachedField = this.cachedFields.fields).length, b = 0; b < i; b++) {
/* 186 */       CachedField cachedField; if ((cachedField = arrayOfCachedField[b]).name.equals(paramString)) return cachedField; 
/* 187 */     }  throw new IllegalArgumentException("Field \"" + paramString + "\" not found on class: " + this.type.getName());
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeField(String paramString) {
/* 192 */     this.cachedFields.removeField(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeField(CachedField paramCachedField) {
/* 197 */     this.cachedFields.removeField(paramCachedField);
/*     */   }
/*     */ 
/*     */   
/*     */   public CachedField[] getFields() {
/* 202 */     return this.cachedFields.fields;
/*     */   }
/*     */ 
/*     */   
/*     */   public CachedField[] getCopyFields() {
/* 207 */     return this.cachedFields.copyFields;
/*     */   }
/*     */   
/*     */   public Class getType() {
/* 211 */     return this.type;
/*     */   }
/*     */   
/*     */   public Kryo getKryo() {
/* 215 */     return this.kryo;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected T createCopy(Kryo paramKryo, T paramT) {
/* 221 */     return (T)paramKryo.newInstance(paramT.getClass());
/*     */   }
/*     */   
/*     */   public T copy(Kryo paramKryo, T paramT) {
/* 225 */     T t = createCopy(paramKryo, paramT);
/* 226 */     paramKryo.reference(t); byte b;
/*     */     int i;
/* 228 */     for (b = 0, i = this.cachedFields.copyFields.length; b < i; b++) {
/* 229 */       this.cachedFields.copyFields[b].copy(paramT, t);
/*     */     }
/* 231 */     return t;
/*     */   }
/*     */   
/*     */   public static abstract class CachedField {
/*     */     final Field field;
/*     */     String name;
/*     */     Class valueClass;
/*     */     Serializer serializer;
/*     */     boolean canBeNull;
/*     */     boolean varEncoding = true;
/*     */     boolean optimizePositive;
/*     */     boolean reuseSerializer = true;
/*     */     FieldAccess access;
/* 244 */     int accessIndex = -1;
/*     */ 
/*     */     
/*     */     long offset;
/*     */     
/*     */     int tag;
/*     */ 
/*     */     
/*     */     public CachedField(Field param1Field) {
/* 253 */       this.field = param1Field;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setValueClass(Class param1Class) {
/* 261 */       this.valueClass = param1Class;
/*     */     }
/*     */ 
/*     */     
/*     */     public Class getValueClass() {
/* 266 */       return this.valueClass;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setValueClass(Class param1Class, Serializer param1Serializer) {
/* 271 */       this.valueClass = param1Class;
/* 272 */       this.serializer = param1Serializer;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setSerializer(Serializer param1Serializer) {
/* 278 */       this.serializer = param1Serializer;
/*     */     }
/*     */ 
/*     */     
/*     */     public Serializer getSerializer() {
/* 283 */       return this.serializer;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setCanBeNull(boolean param1Boolean) {
/* 292 */       this.canBeNull = param1Boolean;
/*     */     }
/*     */     
/*     */     public boolean getCanBeNull() {
/* 296 */       return this.canBeNull;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setVariableLengthEncoding(boolean param1Boolean) {
/* 304 */       this.varEncoding = param1Boolean;
/*     */     }
/*     */     
/*     */     public boolean getVariableLengthEncoding() {
/* 308 */       return this.varEncoding;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setOptimizePositive(boolean param1Boolean) {
/* 314 */       this.optimizePositive = param1Boolean;
/*     */     }
/*     */     
/*     */     public boolean getOptimizePositive() {
/* 318 */       return this.optimizePositive;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setReuseSerializer(boolean param1Boolean) {
/* 325 */       this.reuseSerializer = param1Boolean;
/*     */     }
/*     */     
/*     */     boolean getReuseSerializer() {
/* 329 */       return this.reuseSerializer;
/*     */     }
/*     */     
/*     */     public String getName() {
/* 333 */       return this.name;
/*     */     }
/*     */     
/*     */     public Field getField() {
/* 337 */       return this.field;
/*     */     }
/*     */     
/*     */     public String toString() {
/* 341 */       return this.name;
/*     */     }
/*     */ 
/*     */     
/*     */     public abstract void write(Output param1Output, Object param1Object);
/*     */ 
/*     */     
/*     */     public abstract void read(Input param1Input, Object param1Object);
/*     */ 
/*     */     
/*     */     public abstract void copy(Object param1Object1, Object param1Object2);
/*     */   }
/*     */ 
/*     */   
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   @Target({ElementType.FIELD})
/*     */   public static @interface Optional
/*     */   {
/*     */     String value();
/*     */   }
/*     */ 
/*     */   
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   @Target({ElementType.FIELD})
/*     */   public static @interface Bind
/*     */   {
/*     */     Class valueClass() default Object.class;
/*     */ 
/*     */     
/*     */     Class<? extends Serializer> serializer() default Serializer.class;
/*     */ 
/*     */     
/*     */     Class<? extends SerializerFactory> serializerFactory() default SerializerFactory.class;
/*     */ 
/*     */     
/*     */     boolean canBeNull() default true;
/*     */ 
/*     */     
/*     */     boolean variableLengthEncoding() default true;
/*     */ 
/*     */     
/*     */     boolean optimizePositive() default false;
/*     */   }
/*     */ 
/*     */   
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   @Target({ElementType.FIELD})
/*     */   public static @interface NotNull {}
/*     */ 
/*     */   
/*     */   public static class FieldSerializerConfig
/*     */     implements Cloneable
/*     */   {
/*     */     boolean fieldsCanBeNull = true;
/*     */     
/*     */     boolean setFieldsAsAccessible = true;
/*     */     
/*     */     boolean ignoreSyntheticFields = true;
/*     */     
/*     */     boolean fixedFieldTypes;
/*     */     
/*     */     boolean copyTransient = true;
/*     */     
/*     */     boolean serializeTransient;
/*     */     boolean varEncoding = true;
/*     */     boolean extendedFieldNames;
/*     */     
/*     */     public FieldSerializerConfig clone() {
/*     */       try {
/* 410 */         return (FieldSerializerConfig)super.clone();
/* 411 */       } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 412 */         throw new KryoException(cloneNotSupportedException);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setFieldsCanBeNull(boolean param1Boolean) {
/* 420 */       this.fieldsCanBeNull = param1Boolean;
/* 421 */       if (Log.TRACE) Log.trace("kryo", "FieldSerializerConfig fieldsCanBeNull: " + param1Boolean); 
/*     */     }
/*     */     
/*     */     public boolean getFieldsCanBeNull() {
/* 425 */       return this.fieldsCanBeNull;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setFieldsAsAccessible(boolean param1Boolean) {
/* 433 */       this.setFieldsAsAccessible = param1Boolean;
/* 434 */       if (Log.TRACE) Log.trace("kryo", "FieldSerializerConfig setFieldsAsAccessible: " + param1Boolean); 
/*     */     }
/*     */     
/*     */     public boolean getSetFieldsAsAccessible() {
/* 438 */       return this.setFieldsAsAccessible;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setIgnoreSyntheticFields(boolean param1Boolean) {
/* 444 */       this.ignoreSyntheticFields = param1Boolean;
/* 445 */       if (Log.TRACE) Log.trace("kryo", "FieldSerializerConfig ignoreSyntheticFields: " + param1Boolean); 
/*     */     }
/*     */     
/*     */     public boolean getIgnoreSyntheticFields() {
/* 449 */       return this.ignoreSyntheticFields;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setFixedFieldTypes(boolean param1Boolean) {
/* 456 */       this.fixedFieldTypes = param1Boolean;
/* 457 */       if (Log.TRACE) Log.trace("kryo", "FieldSerializerConfig fixedFieldTypes: " + param1Boolean); 
/*     */     }
/*     */     
/*     */     public boolean getFixedFieldTypes() {
/* 461 */       return this.fixedFieldTypes;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setCopyTransient(boolean param1Boolean) {
/* 467 */       this.copyTransient = param1Boolean;
/* 468 */       if (Log.TRACE) Log.trace("kryo", "FieldSerializerConfig copyTransient: " + param1Boolean); 
/*     */     }
/*     */     
/*     */     public boolean getCopyTransient() {
/* 472 */       return this.copyTransient;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setSerializeTransient(boolean param1Boolean) {
/* 477 */       this.serializeTransient = param1Boolean;
/* 478 */       if (Log.TRACE) Log.trace("kryo", "FieldSerializerConfig serializeTransient: " + param1Boolean); 
/*     */     }
/*     */     
/*     */     public boolean getSerializeTransient() {
/* 482 */       return this.serializeTransient;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setVariableLengthEncoding(boolean param1Boolean) {
/* 490 */       this.varEncoding = param1Boolean;
/* 491 */       if (Log.TRACE) Log.trace("kryo", "FieldSerializerConfig variable length encoding: " + param1Boolean); 
/*     */     }
/*     */     
/*     */     public boolean getVariableLengthEncoding() {
/* 495 */       return this.varEncoding;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setExtendedFieldNames(boolean param1Boolean) {
/* 501 */       this.extendedFieldNames = param1Boolean;
/* 502 */       if (Log.TRACE) Log.trace("kryo", "FieldSerializerConfig extendedFieldNames: " + param1Boolean); 
/*     */     }
/*     */     
/*     */     public boolean getExtendedFieldNames() {
/* 506 */       return this.extendedFieldNames;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\FieldSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */