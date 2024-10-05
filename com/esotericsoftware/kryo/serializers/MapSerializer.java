/*     */ package com.esotericsoftware.kryo.serializers;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.Serializer;
/*     */ import com.esotericsoftware.kryo.SerializerFactory;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.esotericsoftware.kryo.util.Generics;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
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
/*     */ public class MapSerializer<T extends Map>
/*     */   extends Serializer<T>
/*     */ {
/*     */   private Class keyClass;
/*     */   private Class valueClass;
/*     */   private Serializer keySerializer;
/*     */   private Serializer valueSerializer;
/*     */   private boolean keysCanBeNull = true, valuesCanBeNull = true;
/*     */   
/*     */   public MapSerializer() {
/*  48 */     setAcceptsNull(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeysCanBeNull(boolean paramBoolean) {
/*  54 */     this.keysCanBeNull = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeyClass(Class paramClass) {
/*  60 */     this.keyClass = paramClass;
/*     */   }
/*     */   
/*     */   public Class getKeyClass() {
/*  64 */     return this.keyClass;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setKeyClass(Class paramClass, Serializer paramSerializer) {
/*  69 */     this.keyClass = paramClass;
/*  70 */     this.keySerializer = paramSerializer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeySerializer(Serializer paramSerializer) {
/*  76 */     this.keySerializer = paramSerializer;
/*     */   }
/*     */   
/*     */   public Serializer getKeySerializer() {
/*  80 */     return this.keySerializer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValueClass(Class paramClass) {
/*  86 */     this.valueClass = paramClass;
/*     */   }
/*     */   
/*     */   public Class getValueClass() {
/*  90 */     return this.valueClass;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValueClass(Class paramClass, Serializer paramSerializer) {
/*  95 */     this.valueClass = paramClass;
/*  96 */     this.valueSerializer = paramSerializer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValueSerializer(Serializer paramSerializer) {
/* 102 */     this.valueSerializer = paramSerializer;
/*     */   }
/*     */   
/*     */   public Serializer getValueSerializer() {
/* 106 */     return this.valueSerializer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValuesCanBeNull(boolean paramBoolean) {
/* 112 */     this.valuesCanBeNull = paramBoolean;
/*     */   }
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput, T paramT) {
/* 116 */     if (paramT == null) {
/* 117 */       paramOutput.writeByte(0);
/*     */       
/*     */       return;
/*     */     } 
/*     */     int i;
/* 122 */     if ((i = paramT.size()) == 0) {
/* 123 */       paramOutput.writeByte(1);
/* 124 */       writeHeader(paramKryo, paramOutput, paramT);
/*     */       
/*     */       return;
/*     */     } 
/* 128 */     paramOutput.writeVarInt(i + 1, true);
/* 129 */     writeHeader(paramKryo, paramOutput, paramT);
/*     */     
/* 131 */     Serializer serializer1 = this.keySerializer, serializer2 = this.valueSerializer;
/*     */     
/*     */     Generics.GenericType[] arrayOfGenericType;
/* 134 */     if ((arrayOfGenericType = paramKryo.getGenerics().nextGenericTypes()) != null) {
/* 135 */       Class clazz; if (serializer1 == null && (
/*     */         
/* 137 */         clazz = arrayOfGenericType[0].resolve(paramKryo.getGenerics())) != null && paramKryo.isFinal(clazz)) serializer1 = paramKryo.getSerializer(clazz);
/*     */       
/* 139 */       if (serializer2 == null && (
/*     */         
/* 141 */         clazz = arrayOfGenericType[1].resolve(paramKryo.getGenerics())) != null && paramKryo.isFinal(clazz)) serializer2 = paramKryo.getSerializer(clazz);
/*     */     
/*     */     } 
/*     */     
/* 145 */     for (Map.Entry entry : paramT.entrySet()) {
/*     */       
/* 147 */       if (arrayOfGenericType != null) paramKryo.getGenerics().pushGenericType(arrayOfGenericType[0]); 
/* 148 */       if (serializer1 != null)
/* 149 */       { if (this.keysCanBeNull) {
/* 150 */           paramKryo.writeObjectOrNull(paramOutput, entry.getKey(), serializer1);
/*     */         } else {
/* 152 */           paramKryo.writeObject(paramOutput, entry.getKey(), serializer1);
/*     */         }  }
/* 154 */       else { paramKryo.writeClassAndObject(paramOutput, entry.getKey()); }
/* 155 */        if (arrayOfGenericType != null) paramKryo.getGenerics().popGenericType(); 
/* 156 */       if (serializer2 != null) {
/* 157 */         if (this.valuesCanBeNull) {
/* 158 */           paramKryo.writeObjectOrNull(paramOutput, entry.getValue(), serializer2); continue;
/*     */         } 
/* 160 */         paramKryo.writeObject(paramOutput, entry.getValue(), serializer2); continue;
/*     */       } 
/* 162 */       paramKryo.writeClassAndObject(paramOutput, entry.getValue());
/*     */     } 
/* 164 */     paramKryo.getGenerics().popGenericType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writeHeader(Kryo paramKryo, Output paramOutput, T paramT) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected T create(Kryo paramKryo, Input paramInput, Class<? extends T> paramClass, int paramInt) {
/* 176 */     if (paramClass == HashMap.class) {
/* 177 */       if (paramInt < 3) {
/* 178 */         paramInt++;
/* 179 */       } else if (paramInt < 1073741824) {
/* 180 */         paramInt = (int)(paramInt / 0.75F + 1.0F);
/* 181 */       }  return (T)new HashMap<>(paramInt);
/*     */     } 
/* 183 */     return (T)paramKryo.newInstance(paramClass);
/*     */   }
/*     */   
/*     */   public T read(Kryo paramKryo, Input paramInput, Class<? extends T> paramClass) {
/*     */     int i;
/* 188 */     if ((i = paramInput.readVarInt(true)) == 0) return null; 
/* 189 */     i--;
/*     */     
/* 191 */     paramClass = (Class<? extends T>)create(paramKryo, paramInput, paramClass, i);
/* 192 */     paramKryo.reference(paramClass);
/* 193 */     if (i == 0) return (T)paramClass;
/*     */     
/* 195 */     Class clazz1 = this.keyClass;
/* 196 */     Class clazz2 = this.valueClass;
/* 197 */     Serializer serializer1 = this.keySerializer, serializer2 = this.valueSerializer;
/*     */     
/*     */     Generics.GenericType[] arrayOfGenericType;
/* 200 */     if ((arrayOfGenericType = paramKryo.getGenerics().nextGenericTypes()) != null) {
/* 201 */       Class clazz; if (serializer1 == null && (
/*     */         
/* 203 */         clazz = arrayOfGenericType[0].resolve(paramKryo.getGenerics())) != null && paramKryo.isFinal(clazz)) {
/* 204 */         serializer1 = paramKryo.getSerializer(clazz);
/* 205 */         clazz1 = clazz;
/*     */       } 
/*     */       
/* 208 */       if (serializer2 == null && (
/*     */         
/* 210 */         clazz = arrayOfGenericType[1].resolve(paramKryo.getGenerics())) != null && paramKryo.isFinal(clazz)) {
/* 211 */         serializer2 = paramKryo.getSerializer(clazz);
/* 212 */         clazz2 = clazz;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 217 */     for (byte b = 0; b < i; b++) {
/*     */       Object object1, object2;
/* 219 */       if (arrayOfGenericType != null) paramKryo.getGenerics().pushGenericType(arrayOfGenericType[0]); 
/* 220 */       if (serializer1 != null)
/* 221 */       { if (this.keysCanBeNull) {
/* 222 */           object1 = paramKryo.readObjectOrNull(paramInput, clazz1, serializer1);
/*     */         } else {
/* 224 */           object1 = paramKryo.readObject(paramInput, clazz1, serializer1);
/*     */         }  }
/* 226 */       else { object1 = paramKryo.readClassAndObject(paramInput); }
/* 227 */        if (arrayOfGenericType != null) paramKryo.getGenerics().popGenericType();
/*     */       
/* 229 */       if (serializer2 != null)
/* 230 */       { if (this.valuesCanBeNull) {
/* 231 */           object2 = paramKryo.readObjectOrNull(paramInput, clazz2, serializer2);
/*     */         } else {
/* 233 */           object2 = paramKryo.readObject(paramInput, clazz2, serializer2);
/*     */         }  }
/* 235 */       else { object2 = paramKryo.readClassAndObject(paramInput); }
/* 236 */        paramClass.put((T)object1, object2);
/*     */     } 
/* 238 */     paramKryo.getGenerics().popGenericType();
/* 239 */     return (T)paramClass;
/*     */   }
/*     */   
/*     */   protected T createCopy(Kryo paramKryo, T paramT) {
/* 243 */     return (T)paramKryo.newInstance(paramT.getClass());
/*     */   }
/*     */   
/*     */   public T copy(Kryo paramKryo, T paramT) {
/* 247 */     T t = createCopy(paramKryo, paramT);
/* 248 */     for (Map.Entry entry : paramT.entrySet())
/*     */     {
/* 250 */       t.put(paramKryo.copy(entry.getKey()), paramKryo.copy(entry.getValue()));
/*     */     }
/* 252 */     return t;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   @Target({ElementType.FIELD})
/*     */   public static @interface BindMap {
/*     */     Class keyClass() default Object.class;
/*     */     
/*     */     Class<? extends Serializer> keySerializer() default Serializer.class;
/*     */     
/*     */     Class<? extends SerializerFactory> keySerializerFactory() default SerializerFactory.class;
/*     */     
/*     */     Class valueClass() default Object.class;
/*     */     
/*     */     Class<? extends Serializer> valueSerializer() default Serializer.class;
/*     */     
/*     */     Class<? extends SerializerFactory> valueSerializerFactory() default SerializerFactory.class;
/*     */     
/*     */     boolean keysCanBeNull() default true;
/*     */     
/*     */     boolean valuesCanBeNull() default true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\MapSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */