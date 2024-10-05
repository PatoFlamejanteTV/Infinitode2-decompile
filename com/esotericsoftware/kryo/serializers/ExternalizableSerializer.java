/*     */ package com.esotericsoftware.kryo.serializers;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import com.esotericsoftware.kryo.Serializer;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.KryoObjectInput;
/*     */ import com.esotericsoftware.kryo.io.KryoObjectOutput;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.esotericsoftware.kryo.util.ObjectMap;
/*     */ import java.io.Externalizable;
/*     */ import java.io.ObjectInput;
/*     */ import java.io.ObjectOutput;
/*     */ import java.lang.reflect.Method;
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
/*     */ public class ExternalizableSerializer
/*     */   extends Serializer
/*     */ {
/*     */   private ObjectMap<Class, JavaSerializer> javaSerializerByType;
/*  47 */   private KryoObjectInput objectInput = null;
/*  48 */   private KryoObjectOutput objectOutput = null;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput, Object paramObject) {
/*     */     JavaSerializer javaSerializer;
/*  52 */     if ((javaSerializer = getJavaSerializerIfRequired(paramObject.getClass())) == null) {
/*  53 */       writeExternal(paramKryo, paramOutput, paramObject); return;
/*     */     } 
/*  55 */     javaSerializer.write(paramKryo, paramOutput, paramObject);
/*     */   }
/*     */   
/*     */   public Object read(Kryo paramKryo, Input paramInput, Class paramClass) {
/*     */     JavaSerializer javaSerializer;
/*  60 */     if ((javaSerializer = getJavaSerializerIfRequired(paramClass)) == null) return readExternal(paramKryo, paramInput, paramClass); 
/*  61 */     return javaSerializer.read(paramKryo, paramInput, paramClass);
/*     */   }
/*     */   
/*     */   private void writeExternal(Kryo paramKryo, Output paramOutput, Object paramObject) {
/*     */     try {
/*  66 */       ((Externalizable)paramObject).writeExternal(getObjectOutput(paramKryo, paramOutput)); return;
/*  67 */     } catch (Exception exception) {
/*  68 */       throw new KryoException(exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private Object readExternal(Kryo paramKryo, Input paramInput, Class paramClass) {
/*     */     try {
/*     */       Externalizable externalizable;
/*  75 */       (externalizable = (Externalizable)paramKryo.newInstance(paramClass)).readExternal(getObjectInput(paramKryo, paramInput));
/*  76 */       return externalizable;
/*  77 */     } catch (Exception exception) {
/*  78 */       throw new KryoException(exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private ObjectOutput getObjectOutput(Kryo paramKryo, Output paramOutput) {
/*  83 */     if (this.objectOutput == null) {
/*  84 */       this.objectOutput = new KryoObjectOutput(paramKryo, paramOutput);
/*     */     } else {
/*  86 */       this.objectOutput.setOutput(paramOutput);
/*  87 */     }  return (ObjectOutput)this.objectOutput;
/*     */   }
/*     */   
/*     */   private ObjectInput getObjectInput(Kryo paramKryo, Input paramInput) {
/*  91 */     if (this.objectInput == null) {
/*  92 */       this.objectInput = new KryoObjectInput(paramKryo, paramInput);
/*     */     } else {
/*  94 */       this.objectInput.setInput(paramInput);
/*  95 */     }  return (ObjectInput)this.objectInput;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JavaSerializer getJavaSerializerIfRequired(Class paramClass) {
/*     */     JavaSerializer javaSerializer;
/* 104 */     if ((javaSerializer = getCachedSerializer(paramClass)) == null && isJavaSerializerRequired(paramClass)) javaSerializer = new JavaSerializer(); 
/* 105 */     return javaSerializer;
/*     */   }
/*     */   
/*     */   private JavaSerializer getCachedSerializer(Class paramClass) {
/* 109 */     if (this.javaSerializerByType == null) {
/* 110 */       this.javaSerializerByType = new ObjectMap();
/* 111 */       return null;
/*     */     } 
/* 113 */     return (JavaSerializer)this.javaSerializerByType.get(paramClass);
/*     */   }
/*     */   
/*     */   private boolean isJavaSerializerRequired(Class paramClass) {
/* 117 */     return (hasInheritableReplaceMethod(paramClass, "writeReplace") || hasInheritableReplaceMethod(paramClass, "readResolve"));
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean hasInheritableReplaceMethod(Class paramClass, String paramString) {
/* 122 */     Method method = null;
/* 123 */     paramClass = paramClass;
/* 124 */     while (paramClass != null) {
/*     */       try {
/* 126 */         method = paramClass.getDeclaredMethod(paramString, new Class[0]);
/*     */         break;
/* 128 */       } catch (NoSuchMethodException noSuchMethodException) {
/* 129 */         paramClass = paramClass.getSuperclass();
/*     */       } 
/*     */     } 
/* 132 */     return (method != null && method.getReturnType() == Object.class);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\ExternalizableSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */