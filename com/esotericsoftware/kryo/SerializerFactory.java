/*     */ package com.esotericsoftware.kryo;
/*     */ 
/*     */ import com.esotericsoftware.kryo.serializers.CompatibleFieldSerializer;
/*     */ import com.esotericsoftware.kryo.serializers.FieldSerializer;
/*     */ import com.esotericsoftware.kryo.serializers.TaggedFieldSerializer;
/*     */ import com.esotericsoftware.kryo.serializers.VersionFieldSerializer;
/*     */ import com.esotericsoftware.kryo.util.Util;
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
/*     */ public interface SerializerFactory<T extends Serializer>
/*     */ {
/*     */   T newSerializer(Kryo paramKryo, Class paramClass);
/*     */   
/*     */   boolean isSupported(Class paramClass);
/*     */   
/*     */   public static abstract class BaseSerializerFactory<T extends Serializer>
/*     */     implements SerializerFactory<T>
/*     */   {
/*     */     public boolean isSupported(Class param1Class) {
/*  47 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ReflectionSerializerFactory<T extends Serializer>
/*     */     extends BaseSerializerFactory<T>
/*     */   {
/*     */     private final Class<T> serializerClass;
/*     */ 
/*     */     
/*     */     public ReflectionSerializerFactory(Class<T> param1Class) {
/*  60 */       this.serializerClass = param1Class;
/*     */     }
/*     */     
/*     */     public T newSerializer(Kryo param1Kryo, Class param1Class) {
/*  64 */       return newSerializer(param1Kryo, this.serializerClass, param1Class);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static <T extends Serializer> T newSerializer(Kryo param1Kryo, Class<T> param1Class, Class param1Class1) {
/*     */       try {
/*  72 */         return (T)param1Class.getConstructor(new Class[] { Kryo.class, Class.class }).newInstance(new Object[] { param1Kryo, param1Class1 });
/*  73 */       } catch (NoSuchMethodException noSuchMethodException) {
/*     */         try {
/*  75 */           return (T)param1Class.getConstructor(new Class[] { Kryo.class }).newInstance(new Object[] { param1Kryo });
/*  76 */         } catch (NoSuchMethodException noSuchMethodException1) {
/*     */           try {
/*  78 */             return (T)param1Class.getConstructor(new Class[] { Class.class }).newInstance(new Object[] { param1Class1 });
/*  79 */           } catch (NoSuchMethodException noSuchMethodException2) {
/*  80 */             return param1Class.newInstance();
/*     */           }
/*     */         
/*     */         } 
/*  84 */       } catch (Exception exception) {
/*  85 */         throw new IllegalArgumentException("Unable to create serializer \"" + param1Class
/*  86 */             .getName() + "\" for class: " + Util.className(param1Class1), exception);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class SingletonSerializerFactory<T extends Serializer>
/*     */     extends BaseSerializerFactory<T>
/*     */   {
/*     */     private final T serializer;
/*     */     
/*     */     public SingletonSerializerFactory(T param1T) {
/*  98 */       this.serializer = param1T;
/*     */     }
/*     */     
/*     */     public T newSerializer(Kryo param1Kryo, Class param1Class) {
/* 102 */       return this.serializer;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class FieldSerializerFactory
/*     */     extends BaseSerializerFactory<FieldSerializer>
/*     */   {
/*     */     private final FieldSerializer.FieldSerializerConfig config;
/*     */     
/*     */     public FieldSerializerFactory() {
/* 112 */       this.config = new FieldSerializer.FieldSerializerConfig();
/*     */     }
/*     */     
/*     */     public FieldSerializerFactory(FieldSerializer.FieldSerializerConfig param1FieldSerializerConfig) {
/* 116 */       this.config = param1FieldSerializerConfig;
/*     */     }
/*     */     
/*     */     public FieldSerializer.FieldSerializerConfig getConfig() {
/* 120 */       return this.config;
/*     */     }
/*     */     
/*     */     public FieldSerializer newSerializer(Kryo param1Kryo, Class param1Class) {
/* 124 */       return new FieldSerializer(param1Kryo, param1Class, this.config.clone());
/*     */     }
/*     */   }
/*     */   
/*     */   public static class TaggedFieldSerializerFactory
/*     */     extends BaseSerializerFactory<TaggedFieldSerializer>
/*     */   {
/*     */     private final TaggedFieldSerializer.TaggedFieldSerializerConfig config;
/*     */     
/*     */     public TaggedFieldSerializerFactory() {
/* 134 */       this.config = new TaggedFieldSerializer.TaggedFieldSerializerConfig();
/*     */     }
/*     */     
/*     */     public TaggedFieldSerializerFactory(TaggedFieldSerializer.TaggedFieldSerializerConfig param1TaggedFieldSerializerConfig) {
/* 138 */       this.config = param1TaggedFieldSerializerConfig;
/*     */     }
/*     */     
/*     */     public TaggedFieldSerializer.TaggedFieldSerializerConfig getConfig() {
/* 142 */       return this.config;
/*     */     }
/*     */     
/*     */     public TaggedFieldSerializer newSerializer(Kryo param1Kryo, Class param1Class) {
/* 146 */       return new TaggedFieldSerializer(param1Kryo, param1Class, this.config.clone());
/*     */     }
/*     */   }
/*     */   
/*     */   public static class VersionFieldSerializerFactory
/*     */     extends BaseSerializerFactory<VersionFieldSerializer>
/*     */   {
/*     */     private final VersionFieldSerializer.VersionFieldSerializerConfig config;
/*     */     
/*     */     public VersionFieldSerializerFactory() {
/* 156 */       this.config = new VersionFieldSerializer.VersionFieldSerializerConfig();
/*     */     }
/*     */     
/*     */     public VersionFieldSerializerFactory(VersionFieldSerializer.VersionFieldSerializerConfig param1VersionFieldSerializerConfig) {
/* 160 */       this.config = param1VersionFieldSerializerConfig;
/*     */     }
/*     */     
/*     */     public VersionFieldSerializer.VersionFieldSerializerConfig getConfig() {
/* 164 */       return this.config;
/*     */     }
/*     */     
/*     */     public VersionFieldSerializer newSerializer(Kryo param1Kryo, Class param1Class) {
/* 168 */       return new VersionFieldSerializer(param1Kryo, param1Class, this.config.clone());
/*     */     }
/*     */   }
/*     */   
/*     */   public static class CompatibleFieldSerializerFactory
/*     */     extends BaseSerializerFactory<CompatibleFieldSerializer>
/*     */   {
/*     */     private final CompatibleFieldSerializer.CompatibleFieldSerializerConfig config;
/*     */     
/*     */     public CompatibleFieldSerializerFactory() {
/* 178 */       this.config = new CompatibleFieldSerializer.CompatibleFieldSerializerConfig();
/*     */     }
/*     */     
/*     */     public CompatibleFieldSerializerFactory(CompatibleFieldSerializer.CompatibleFieldSerializerConfig param1CompatibleFieldSerializerConfig) {
/* 182 */       this.config = param1CompatibleFieldSerializerConfig;
/*     */     }
/*     */     
/*     */     public CompatibleFieldSerializer.CompatibleFieldSerializerConfig getConfig() {
/* 186 */       return this.config;
/*     */     }
/*     */     
/*     */     public CompatibleFieldSerializer newSerializer(Kryo param1Kryo, Class param1Class) {
/* 190 */       return new CompatibleFieldSerializer(param1Kryo, param1Class, this.config.clone());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\SerializerFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */