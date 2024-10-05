/*     */ package com.esotericsoftware.kryo.serializers;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.esotericsoftware.minlog.Log;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
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
/*     */ public class RecordSerializer<T>
/*     */   extends ImmutableSerializer<T>
/*     */ {
/*     */   private static final Method IS_RECORD;
/*     */   private static final Method GET_RECORD_COMPONENTS;
/*     */   private static final Method GET_NAME;
/*     */   private static final Method GET_TYPE;
/*     */   
/*     */   static {
/*     */     Method method1, method2, method3, method4;
/*     */     try {
/*  52 */       Class<?> clazz = Class.forName("java.lang.reflect.RecordComponent");
/*  53 */       method1 = Class.class.getDeclaredMethod("isRecord", new Class[0]);
/*  54 */       method2 = Class.class.getMethod("getRecordComponents", new Class[0]);
/*  55 */       method3 = clazz.getMethod("getName", new Class[0]);
/*  56 */       method4 = clazz.getMethod("getType", new Class[0]);
/*  57 */     } catch (ClassNotFoundException|NoSuchMethodException classNotFoundException) {
/*     */       
/*  59 */       method1 = null;
/*  60 */       method2 = null;
/*  61 */       method3 = null;
/*  62 */       method4 = null;
/*     */     } 
/*     */     
/*  65 */     IS_RECORD = method1;
/*  66 */     GET_RECORD_COMPONENTS = method2;
/*  67 */     GET_NAME = method3;
/*  68 */     GET_TYPE = method4;
/*     */   }
/*     */   
/*  71 */   private static final ClassValue<Constructor<?>> CONSTRUCTOR = new ClassValue<Constructor<?>>() {
/*     */       protected Constructor<?> computeValue(Class<?> param1Class) {
/*  73 */         RecordSerializer.RecordComponent[] arrayOfRecordComponent = RecordSerializer.recordComponents((Class)param1Class, (Comparator)Comparator.comparing(RecordSerializer.RecordComponent::index));
/*  74 */         return RecordSerializer.getCanonicalConstructor((Class)param1Class, arrayOfRecordComponent);
/*     */       }
/*     */     };
/*  77 */   private static final ClassValue<RecordComponent[]> RECORD_COMPONENTS = new ClassValue<RecordComponent[]>() {
/*     */       protected RecordSerializer.RecordComponent[] computeValue(Class<?> param1Class) {
/*  79 */         return RecordSerializer.recordComponents((Class)param1Class, (Comparator)Comparator.comparing(RecordSerializer.RecordComponent::name));
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean fixedFieldTypes = false;
/*     */ 
/*     */ 
/*     */   
/*     */   public RecordSerializer(Class<T> paramClass) {
/*  91 */     if (!isRecord(paramClass)) throw new KryoException(paramClass + " is not a record"); 
/*     */   } public void write(Kryo paramKryo, Output paramOutput, T paramT) {
/*     */     RecordComponent[] arrayOfRecordComponent;
/*     */     int i;
/*     */     byte b;
/*  96 */     for (i = (arrayOfRecordComponent = RECORD_COMPONENTS.get(paramT.getClass())).length, b = 0; b < i; b++) {
/*  97 */       RecordComponent recordComponent; Class<?> clazz = (recordComponent = arrayOfRecordComponent[b]).type();
/*  98 */       String str = recordComponent.name();
/*     */       try {
/* 100 */         if (Log.TRACE) Log.trace("kryo", "Write property: " + str + " (" + clazz.getName() + ")"); 
/* 101 */         if (clazz.isPrimitive()) {
/* 102 */           paramKryo.writeObject(paramOutput, recordComponent.getValue(paramT));
/*     */         }
/* 104 */         else if (this.fixedFieldTypes || paramKryo.isFinal(clazz)) {
/* 105 */           paramKryo.writeObjectOrNull(paramOutput, recordComponent.getValue(paramT), clazz);
/*     */         } else {
/* 107 */           paramKryo.writeClassAndObject(paramOutput, recordComponent.getValue(paramT));
/*     */         }
/*     */       
/* 110 */       } catch (KryoException kryoException) {
/* 111 */         (paramKryo = null).addTrace(str + " (" + clazz.getName() + ")");
/* 112 */         throw paramKryo;
/* 113 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 115 */         (kryoException = new KryoException(throwable)).addTrace(str + " (" + clazz.getName() + ")");
/* 116 */         throw kryoException;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public T read(Kryo paramKryo, Input paramInput, Class<? extends T> paramClass) {
/*     */     RecordComponent[] arrayOfRecordComponent;
/* 124 */     Object[] arrayOfObject = new Object[(arrayOfRecordComponent = RECORD_COMPONENTS.get(paramClass)).length];
/* 125 */     for (byte b = 0; b < arrayOfRecordComponent.length; b++) {
/*     */       RecordComponent recordComponent;
/* 127 */       String str = (recordComponent = arrayOfRecordComponent[b]).name();
/* 128 */       Class<?> clazz = recordComponent.type();
/*     */       try {
/* 130 */         if (Log.TRACE) Log.trace("kryo", "Read property: " + str + " (" + paramClass.getName() + ")");
/*     */         
/* 132 */         if (clazz.isPrimitive()) {
/* 133 */           arrayOfObject[recordComponent.index()] = paramKryo.readObject(paramInput, clazz);
/*     */         }
/* 135 */         else if (this.fixedFieldTypes || paramKryo.isFinal(clazz)) {
/* 136 */           arrayOfObject[recordComponent.index()] = paramKryo.readObjectOrNull(paramInput, clazz);
/*     */         } else {
/* 138 */           arrayOfObject[recordComponent.index()] = paramKryo.readClassAndObject(paramInput);
/*     */         }
/*     */       
/* 141 */       } catch (KryoException kryoException) {
/* 142 */         (paramKryo = null).addTrace(str + " (" + paramClass.getName() + ")");
/* 143 */         throw paramKryo;
/* 144 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 146 */         (kryoException = new KryoException(throwable)).addTrace(str + " (" + paramClass.getName() + ")");
/* 147 */         throw kryoException;
/*     */       } 
/*     */     } 
/* 150 */     return invokeCanonicalConstructor(paramClass, arrayOfObject);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isRecord(Class<?> paramClass) {
/*     */     try {
/* 156 */       return ((Boolean)IS_RECORD.invoke(paramClass, new Object[0])).booleanValue();
/* 157 */     } catch (Throwable throwable) {
/* 158 */       throw new KryoException("Could not determine type (" + paramClass + ")");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static final class RecordComponent
/*     */   {
/*     */     private final Class<?> recordType;
/*     */     private final String name;
/*     */     private final Class<?> type;
/*     */     private final int index;
/*     */     private final Method getter;
/*     */     
/*     */     RecordComponent(Class<?> param1Class1, String param1String, Class<?> param1Class2, int param1Int) {
/* 172 */       this.recordType = param1Class1;
/* 173 */       this.name = param1String;
/* 174 */       this.type = param1Class2;
/* 175 */       this.index = param1Int;
/*     */       
/*     */       try {
/* 178 */         this.getter = param1Class1.getDeclaredMethod(param1String, new Class[0]);
/* 179 */         if (!this.getter.isAccessible())
/* 180 */           this.getter.setAccessible(true); 
/*     */         return;
/* 182 */       } catch (Exception exception) {
/*     */         KryoException kryoException;
/* 184 */         (kryoException = new KryoException(exception)).addTrace("Could not retrieve record component getter (" + param1Class1.getName() + ")");
/* 185 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */     
/*     */     final String name() {
/* 190 */       return this.name;
/*     */     }
/*     */     
/*     */     final Class<?> type() {
/* 194 */       return this.type;
/*     */     }
/*     */     
/*     */     final int index() {
/* 198 */       return this.index;
/*     */     }
/*     */     
/*     */     final Object getValue(Object param1Object) {
/*     */       try {
/* 203 */         return this.getter.invoke(param1Object, new Object[0]);
/* 204 */       } catch (Exception exception) {
/*     */         KryoException kryoException;
/* 206 */         (kryoException = new KryoException(exception)).addTrace("Could not retrieve record component value (" + this.recordType.getName() + ")");
/* 207 */         throw kryoException;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static <T> RecordComponent[] recordComponents(Class<T> paramClass, Comparator<RecordComponent> paramComparator) {
/*     */     try {
/*     */       Object[] arrayOfObject;
/* 218 */       RecordComponent[] arrayOfRecordComponent = new RecordComponent[(arrayOfObject = (Object[])GET_RECORD_COMPONENTS.invoke(paramClass, new Object[0])).length];
/* 219 */       for (byte b = 0; b < arrayOfObject.length; b++) {
/* 220 */         Object object = arrayOfObject[b];
/* 221 */         arrayOfRecordComponent[b] = new RecordComponent(paramClass, (String)GET_NAME
/*     */             
/* 223 */             .invoke(object, new Object[0]), (Class)GET_TYPE
/* 224 */             .invoke(object, new Object[0]), b);
/*     */       } 
/* 226 */       if (paramComparator != null) Arrays.sort(arrayOfRecordComponent, paramComparator); 
/* 227 */       return arrayOfRecordComponent;
/* 228 */     } catch (Throwable throwable) {
/*     */       KryoException kryoException;
/* 230 */       (kryoException = new KryoException(throwable)).addTrace("Could not retrieve record components (" + paramClass.getName() + ")");
/* 231 */       throw kryoException;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private T invokeCanonicalConstructor(Class<? extends T> paramClass, Object[] paramArrayOfObject) {
/*     */     try {
/* 238 */       return ((Constructor<T>)CONSTRUCTOR.get(paramClass)).newInstance(paramArrayOfObject);
/* 239 */     } catch (Throwable throwable) {
/*     */       KryoException kryoException;
/* 241 */       (kryoException = new KryoException(throwable)).addTrace("Could not construct type (" + paramClass.getName() + ")");
/* 242 */       throw kryoException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static <T> Constructor<T> getCanonicalConstructor(Class<T> paramClass, RecordComponent[] paramArrayOfRecordComponent) {
/*     */     try {
/* 250 */       Class[] arrayOfClass = (Class[])Arrays.<RecordComponent>stream(paramArrayOfRecordComponent).map(RecordComponent::type).toArray(paramInt -> new Class[paramInt]);
/* 251 */       return getCanonicalConstructor(paramClass, arrayOfClass);
/* 252 */     } catch (Throwable throwable) {
/*     */       KryoException kryoException;
/* 254 */       (kryoException = new KryoException(throwable)).addTrace("Could not retrieve record canonical constructor (" + paramClass.getName() + ")");
/* 255 */       throw kryoException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static <T> Constructor<T> getCanonicalConstructor(Class<T> paramClass, Class<?>[] paramArrayOfClass) {
/*     */     Constructor<T> constructor;
/*     */     try {
/* 264 */       if (!(constructor = paramClass.getConstructor(paramArrayOfClass)).canAccess(null)) {
/* 265 */         constructor.setAccessible(true);
/*     */       }
/* 267 */     } catch (Exception exception) {
/*     */       
/* 269 */       (constructor = paramClass.getDeclaredConstructor(paramArrayOfClass)).setAccessible(true);
/*     */     } 
/* 271 */     return constructor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFixedFieldTypes(boolean paramBoolean) {
/* 277 */     this.fixedFieldTypes = paramBoolean;
/*     */   }
/*     */   
/*     */   @Deprecated(forRemoval = true)
/*     */   public RecordSerializer() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\RecordSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */