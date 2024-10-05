/*     */ package com.esotericsoftware.kryo.serializers;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import com.esotericsoftware.kryo.Serializer;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.esotericsoftware.minlog.Log;
/*     */ import com.esotericsoftware.reflectasm.MethodAccess;
/*     */ import java.beans.BeanInfo;
/*     */ import java.beans.IntrospectionException;
/*     */ import java.beans.Introspector;
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
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
/*     */ public class BeanSerializer<T>
/*     */   extends Serializer<T>
/*     */ {
/*  51 */   static final Object[] noArgs = new Object[0];
/*     */   
/*     */   private CachedProperty[] properties;
/*     */   Object access;
/*     */   
/*     */   public BeanSerializer(Kryo paramKryo, Class<?> paramClass) {
/*     */     try {
/*  58 */       BeanInfo beanInfo = Introspector.getBeanInfo(paramClass);
/*  59 */     } catch (IntrospectionException introspectionException) {
/*  60 */       throw new KryoException("Error getting bean info.", introspectionException);
/*     */     } 
/*     */     
/*     */     PropertyDescriptor[] arrayOfPropertyDescriptor;
/*  64 */     Arrays.sort(arrayOfPropertyDescriptor = introspectionException.getPropertyDescriptors(), new Comparator<PropertyDescriptor>() {
/*     */           public int compare(PropertyDescriptor param1PropertyDescriptor1, PropertyDescriptor param1PropertyDescriptor2) {
/*  66 */             return param1PropertyDescriptor1.getName().compareTo(param1PropertyDescriptor2.getName());
/*     */           }
/*     */         });
/*  69 */     ArrayList<CachedProperty> arrayList = new ArrayList(arrayOfPropertyDescriptor.length); byte b; int i;
/*  70 */     for (b = 0, i = arrayOfPropertyDescriptor.length; b < i; b++) {
/*     */       PropertyDescriptor propertyDescriptor;
/*     */       String str;
/*  73 */       if (!(str = (propertyDescriptor = arrayOfPropertyDescriptor[b]).getName()).equals("class")) {
/*  74 */         Method method2 = propertyDescriptor.getReadMethod();
/*  75 */         Method method1 = propertyDescriptor.getWriteMethod();
/*  76 */         if (method2 != null && method1 != null) {
/*     */ 
/*     */           
/*  79 */           Serializer serializer = null;
/*  80 */           Class<?> clazz = method2.getReturnType();
/*  81 */           if (paramKryo.isFinal(clazz)) serializer = paramKryo.getRegistration(clazz).getSerializer();
/*     */           
/*     */           CachedProperty cachedProperty;
/*  84 */           (cachedProperty = new CachedProperty()).name = str;
/*  85 */           cachedProperty.getMethod = method2;
/*  86 */           cachedProperty.setMethod = method1;
/*  87 */           cachedProperty.serializer = serializer;
/*  88 */           cachedProperty.setMethodType = method1.getParameterTypes()[0];
/*  89 */           arrayList.add(cachedProperty);
/*     */         } 
/*     */       } 
/*  92 */     }  this.properties = arrayList.<CachedProperty>toArray(new CachedProperty[arrayList.size()]);
/*     */     
/*     */     try {
/*  95 */       this.access = MethodAccess.get(paramClass);
/*  96 */       for (b = 0, i = this.properties.length; b < i; b++) {
/*     */         CachedProperty cachedProperty;
/*  98 */         (cachedProperty = this.properties[b]).getterAccessIndex = ((MethodAccess)this.access).getIndex(cachedProperty.getMethod.getName(), cachedProperty.getMethod
/*  99 */             .getParameterTypes());
/* 100 */         cachedProperty.setterAccessIndex = ((MethodAccess)this.access).getIndex(cachedProperty.setMethod.getName(), cachedProperty.setMethod
/* 101 */             .getParameterTypes());
/*     */       }  return;
/* 103 */     } catch (Throwable throwable) {
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput, T paramT) {
/* 109 */     Class<?> clazz = paramT.getClass(); byte b; int i;
/* 110 */     for (b = 0, i = this.properties.length; b < i; b++) {
/* 111 */       CachedProperty cachedProperty = this.properties[b];
/*     */       try {
/* 113 */         if (Log.TRACE) Log.trace("kryo", "Write property: " + cachedProperty + " (" + clazz.getName() + ")"); 
/* 114 */         Object object = cachedProperty.get(paramT);
/*     */         Serializer serializer;
/* 116 */         if ((serializer = cachedProperty.serializer) != null)
/* 117 */         { paramKryo.writeObjectOrNull(paramOutput, object, serializer); }
/*     */         else
/* 119 */         { paramKryo.writeClassAndObject(paramOutput, object); } 
/* 120 */       } catch (IllegalAccessException illegalAccessException) {
/* 121 */         throw new KryoException("Error accessing getter method: " + cachedProperty + " (" + clazz.getName() + ")", illegalAccessException);
/* 122 */       } catch (InvocationTargetException invocationTargetException) {
/* 123 */         throw new KryoException("Error invoking getter method: " + cachedProperty + " (" + clazz.getName() + ")", invocationTargetException);
/* 124 */       } catch (KryoException kryoException2) {
/* 125 */         KryoException kryoException1; (kryoException1 = null).addTrace(cachedProperty + " (" + clazz.getName() + ")");
/* 126 */         throw kryoException1;
/* 127 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 129 */         (kryoException = new KryoException(throwable)).addTrace(cachedProperty + " (" + clazz.getName() + ")");
/* 130 */         throw kryoException;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public T read(Kryo paramKryo, Input paramInput, Class<? extends T> paramClass) {
/* 136 */     Object object = paramKryo.newInstance(paramClass);
/* 137 */     paramKryo.reference(object); byte b; int i;
/* 138 */     for (b = 0, i = this.properties.length; b < i; b++) {
/* 139 */       CachedProperty cachedProperty = this.properties[b];
/*     */       try {
/* 141 */         if (Log.TRACE) Log.trace("kryo", "Read property: " + cachedProperty + " (" + object.getClass() + ")");
/*     */         
/*     */         Object object1;
/* 144 */         if ((object1 = cachedProperty.serializer) != null) {
/* 145 */           Object object2 = paramKryo.readObjectOrNull(paramInput, cachedProperty.setMethodType, (Serializer)object1);
/*     */         } else {
/* 147 */           object1 = paramKryo.readClassAndObject(paramInput);
/* 148 */         }  cachedProperty.set(object, object1);
/* 149 */       } catch (IllegalAccessException illegalAccessException) {
/* 150 */         throw new KryoException("Error accessing setter method: " + cachedProperty + " (" + object.getClass().getName() + ")", illegalAccessException);
/* 151 */       } catch (InvocationTargetException invocationTargetException) {
/* 152 */         throw new KryoException("Error invoking setter method: " + cachedProperty + " (" + object.getClass().getName() + ")", invocationTargetException);
/* 153 */       } catch (KryoException kryoException2) {
/* 154 */         KryoException kryoException1; (kryoException1 = null).addTrace(cachedProperty + " (" + object.getClass().getName() + ")");
/* 155 */         throw kryoException1;
/* 156 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 158 */         (kryoException = new KryoException(throwable)).addTrace(cachedProperty + " (" + object.getClass().getName() + ")");
/* 159 */         throw kryoException;
/*     */       } 
/*     */     } 
/* 162 */     return (T)object;
/*     */   }
/*     */   
/*     */   public T copy(Kryo paramKryo, T paramT) {
/* 166 */     Object object = paramKryo.newInstance(paramT.getClass()); byte b; int i;
/* 167 */     for (b = 0, i = this.properties.length; b < i; b++) {
/* 168 */       CachedProperty cachedProperty = this.properties[b];
/*     */       try {
/* 170 */         Object object1 = cachedProperty.get(paramT);
/* 171 */         cachedProperty.set(object, object1);
/* 172 */       } catch (KryoException kryoException2) {
/* 173 */         KryoException kryoException1; (kryoException1 = null).addTrace(cachedProperty + " (" + object.getClass().getName() + ")");
/* 174 */         throw kryoException1;
/* 175 */       } catch (Exception exception) {
/* 176 */         throw new KryoException("Error copying bean property: " + cachedProperty + " (" + object.getClass().getName() + ")", exception);
/* 177 */       } catch (Throwable throwable) {
/*     */         KryoException kryoException;
/* 179 */         (kryoException = new KryoException(throwable)).addTrace(cachedProperty + " (" + object.getClass().getName() + ")");
/* 180 */         throw kryoException;
/*     */       } 
/*     */     } 
/* 183 */     return (T)object;
/*     */   }
/*     */   class CachedProperty<X> { String name;
/*     */     Method getMethod;
/*     */     Method setMethod;
/*     */     Class setMethodType;
/*     */     Serializer serializer;
/*     */     int getterAccessIndex;
/*     */     int setterAccessIndex;
/*     */     
/*     */     public String toString() {
/* 194 */       return this.name;
/*     */     }
/*     */     
/*     */     Object get(Object param1Object) {
/* 198 */       if (BeanSerializer.this.access != null) return ((MethodAccess)BeanSerializer.this.access).invoke(param1Object, this.getterAccessIndex, new Object[0]); 
/* 199 */       return this.getMethod.invoke(param1Object, BeanSerializer.noArgs);
/*     */     }
/*     */     
/*     */     void set(Object param1Object1, Object param1Object2) {
/* 203 */       if (BeanSerializer.this.access != null) {
/* 204 */         ((MethodAccess)BeanSerializer.this.access).invoke(param1Object1, this.setterAccessIndex, new Object[] { param1Object2 });
/*     */         return;
/*     */       } 
/* 207 */       this.setMethod.invoke(param1Object1, new Object[] { param1Object2 });
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\BeanSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */