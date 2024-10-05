/*     */ package com.esotericsoftware.kryo.serializers;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import com.esotericsoftware.kryo.Serializer;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.esotericsoftware.kryo.util.Util;
/*     */ import com.esotericsoftware.minlog.Log;
/*     */ import java.lang.invoke.SerializedLambda;
/*     */ import java.lang.reflect.Field;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClosureSerializer
/*     */   extends Serializer
/*     */ {
/*     */   private static Method readResolve;
/*     */   private static Field capturingClass;
/*     */   
/*     */   public static class Closure {}
/*     */   
/*     */   public ClosureSerializer() {
/*  56 */     if (readResolve == null) {
/*     */       
/*     */       try {
/*  59 */         (readResolve = SerializedLambda.class.getDeclaredMethod("readResolve", new Class[0])).setAccessible(true);
/*  60 */       } catch (Exception exception) {
/*  61 */         readResolve = null;
/*  62 */         Log.warn("Unable to obtain SerializedLambda#readResolve via reflection. Falling back on resolving lambdas via capturing class.", exception);
/*     */       } 
/*     */     }
/*     */     
/*  66 */     if (capturingClass == null) {
/*     */       
/*     */       try {
/*  69 */         (capturingClass = SerializedLambda.class.getDeclaredField("capturingClass")).setAccessible(true); return;
/*  70 */       } catch (Exception exception) {
/*  71 */         capturingClass = null;
/*  72 */         Log.warn("Unable to obtain SerializedLambda#capturingClass via reflection. Falling back to resolving capturing class via Class.forName.", exception);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput, Object paramObject) {
/*  80 */     int i = (paramObject = toSerializedLambda(paramObject)).getCapturedArgCount();
/*  81 */     paramOutput.writeVarInt(i, true);
/*  82 */     for (byte b = 0; b < i; b++)
/*  83 */       paramKryo.writeClassAndObject(paramOutput, paramObject.getCapturedArg(b)); 
/*     */     try {
/*  85 */       paramKryo.writeClass(paramOutput, getCapturingClass((SerializedLambda)paramObject));
/*  86 */     } catch (ClassNotFoundException classNotFoundException) {
/*  87 */       throw new KryoException("Error writing closure.", classNotFoundException);
/*     */     } 
/*  89 */     paramOutput.writeString(paramObject.getFunctionalInterfaceClass());
/*  90 */     paramOutput.writeString(paramObject.getFunctionalInterfaceMethodName());
/*  91 */     paramOutput.writeString(paramObject.getFunctionalInterfaceMethodSignature());
/*  92 */     paramOutput.writeVarInt(paramObject.getImplMethodKind(), true);
/*  93 */     paramOutput.writeString(paramObject.getImplClass());
/*  94 */     paramOutput.writeString(paramObject.getImplMethodName());
/*  95 */     paramOutput.writeString(paramObject.getImplMethodSignature());
/*  96 */     paramOutput.writeString(paramObject.getInstantiatedMethodType());
/*     */   }
/*     */   
/*     */   public Object read(Kryo paramKryo, Input paramInput, Class paramClass) {
/*     */     int i;
/* 101 */     Object[] arrayOfObject = new Object[i = paramInput.readVarInt(true)];
/* 102 */     for (byte b = 0; b < i; b++)
/* 103 */       arrayOfObject[b] = paramKryo.readClassAndObject(paramInput); 
/* 104 */     Class<?> clazz = paramKryo.readClass(paramInput).getType();
/*     */ 
/*     */     
/* 107 */     SerializedLambda serializedLambda = new SerializedLambda(clazz, paramInput.readString(), paramInput.readString(), paramInput.readString(), paramInput.readVarInt(true), paramInput.readString(), paramInput.readString(), paramInput.readString(), paramInput.readString(), arrayOfObject);
/*     */     try {
/* 109 */       return readResolve(clazz, serializedLambda);
/* 110 */     } catch (Exception exception) {
/* 111 */       throw new KryoException("Error reading closure.", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Object copy(Kryo paramKryo, Object<?> paramObject) {
/*     */     try {
/*     */       SerializedLambda serializedLambda;
/* 118 */       paramObject = (Object<?>)getCapturingClass(serializedLambda = toSerializedLambda(paramObject));
/* 119 */       return readResolve((Class<?>)paramObject, serializedLambda);
/* 120 */     } catch (Exception exception) {
/* 121 */       throw new KryoException("Error copying closure.", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private Object readResolve(Class<?> paramClass, SerializedLambda paramSerializedLambda) {
/* 126 */     if (readResolve != null) {
/* 127 */       return readResolve.invoke(paramSerializedLambda, new Object[0]);
/*     */     }
/*     */     
/*     */     Method method;
/*     */     
/* 132 */     (method = paramClass.getDeclaredMethod("$deserializeLambda$", new Class[] { SerializedLambda.class })).setAccessible(true);
/* 133 */     return method.invoke(null, new Object[] { paramSerializedLambda });
/*     */   }
/*     */   
/*     */   private SerializedLambda toSerializedLambda(Object paramObject) {
/*     */     Object object;
/*     */     try {
/*     */       Method method;
/* 140 */       (method = paramObject.getClass().getDeclaredMethod("writeReplace", new Class[0])).setAccessible(true);
/* 141 */       object = method.invoke(paramObject, new Object[0]);
/* 142 */     } catch (Exception exception) {
/* 143 */       if (paramObject instanceof java.io.Serializable) throw new KryoException("Error serializing closure.", exception); 
/* 144 */       throw new KryoException("Closure must implement java.io.Serializable.", exception);
/*     */     } 
/*     */     try {
/* 147 */       return (SerializedLambda)object;
/* 148 */     } catch (Exception exception) {
/* 149 */       throw new KryoException("writeReplace must return a SerializedLambda: " + Util.className(object.getClass()), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Class<?> getCapturingClass(SerializedLambda paramSerializedLambda) {
/* 154 */     if (capturingClass != null) {
/*     */       try {
/* 156 */         return (Class)capturingClass.get(paramSerializedLambda);
/* 157 */       } catch (IllegalAccessException illegalAccessException) {}
/*     */     }
/*     */ 
/*     */     
/* 161 */     return Class.forName(paramSerializedLambda.getCapturingClass().replace('/', '.'));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\ClosureSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */