/*     */ package com.esotericsoftware.kryo.serializers;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.esotericsoftware.minlog.Log;
/*     */ import java.lang.annotation.Annotation;
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
/*     */ public class VersionFieldSerializer<T>
/*     */   extends FieldSerializer<T>
/*     */ {
/*     */   private final VersionFieldSerializerConfig config;
/*     */   private int typeVersion;
/*     */   private int[] fieldVersion;
/*     */   
/*     */   public VersionFieldSerializer(Kryo paramKryo, Class paramClass) {
/*  53 */     this(paramKryo, paramClass, new VersionFieldSerializerConfig());
/*     */   }
/*     */   
/*     */   public VersionFieldSerializer(Kryo paramKryo, Class paramClass, VersionFieldSerializerConfig paramVersionFieldSerializerConfig) {
/*  57 */     super(paramKryo, paramClass, paramVersionFieldSerializerConfig);
/*  58 */     this.config = paramVersionFieldSerializerConfig;
/*  59 */     setAcceptsNull(true);
/*     */     
/*  61 */     initializeCachedFields();
/*     */   }
/*     */   
/*     */   protected void initializeCachedFields() {
/*  65 */     FieldSerializer.CachedField[] arrayOfCachedField = this.cachedFields.fields;
/*  66 */     this.fieldVersion = new int[arrayOfCachedField.length]; byte b; int i;
/*  67 */     for (b = 0, i = arrayOfCachedField.length; b < i; b++) {
/*     */       Field field;
/*     */       Since since;
/*  70 */       if ((since = (field = (arrayOfCachedField[b]).field).<Annotation>getAnnotation(Since.class)) != null) {
/*  71 */         this.fieldVersion[b] = since.value();
/*     */         
/*  73 */         this.typeVersion = Math.max(this.fieldVersion[b], this.typeVersion);
/*     */       } else {
/*  75 */         this.fieldVersion[b] = 0;
/*     */       } 
/*     */     } 
/*  78 */     if (Log.DEBUG) Log.debug("Version for type " + getType().getName() + ": " + this.typeVersion); 
/*     */   }
/*     */   
/*     */   public void removeField(String paramString) {
/*  82 */     super.removeField(paramString);
/*  83 */     initializeCachedFields();
/*     */   }
/*     */   
/*     */   public void removeField(FieldSerializer.CachedField paramCachedField) {
/*  87 */     super.removeField(paramCachedField);
/*  88 */     initializeCachedFields();
/*     */   }
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput, T paramT) {
/*  92 */     if (paramT == null) {
/*  93 */       paramOutput.writeByte((byte)0);
/*     */       
/*     */       return;
/*     */     } 
/*  97 */     int i = pushTypeVariables();
/*     */     
/*  99 */     FieldSerializer.CachedField[] arrayOfCachedField = this.cachedFields.fields;
/*     */     
/* 101 */     paramOutput.writeVarInt(this.typeVersion + 1, true); byte b;
/*     */     int j;
/* 103 */     for (b = 0, j = arrayOfCachedField.length; b < j; b++) {
/* 104 */       if (Log.TRACE) log("Write", arrayOfCachedField[b], paramOutput.position()); 
/* 105 */       arrayOfCachedField[b].write(paramOutput, paramT);
/*     */     } 
/*     */     
/* 108 */     popTypeVariables(i);
/*     */   }
/*     */   
/*     */   public T read(Kryo paramKryo, Input paramInput, Class<? extends T> paramClass) {
/*     */     int i;
/* 113 */     if ((i = paramInput.readVarInt(true)) == 0) return null; 
/* 114 */     i--;
/* 115 */     if (!this.config.compatible && i != this.typeVersion) {
/* 116 */       throw new KryoException("Version is not compatible: " + i + " != " + this.typeVersion);
/*     */     }
/* 118 */     int j = pushTypeVariables();
/*     */     
/* 120 */     paramClass = (Class<? extends T>)create(paramKryo, paramInput, paramClass);
/* 121 */     paramKryo.reference(paramClass);
/*     */     
/* 123 */     FieldSerializer.CachedField[] arrayOfCachedField = this.cachedFields.fields; byte b; int k;
/* 124 */     for (b = 0, k = arrayOfCachedField.length; b < k; b++) {
/*     */       
/* 126 */       if (this.fieldVersion[b] > i) {
/* 127 */         if (Log.DEBUG) Log.debug("Skip field: " + (arrayOfCachedField[b]).field.getName());
/*     */       
/*     */       } else {
/* 130 */         if (Log.TRACE) log("Read", arrayOfCachedField[b], paramInput.position()); 
/* 131 */         arrayOfCachedField[b].read(paramInput, paramClass);
/*     */       } 
/*     */     } 
/* 134 */     popTypeVariables(j);
/* 135 */     return (T)paramClass;
/*     */   }
/*     */   
/*     */   public VersionFieldSerializerConfig getVersionFieldSerializerConfig() {
/* 139 */     return this.config;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class VersionFieldSerializerConfig
/*     */     extends FieldSerializer.FieldSerializerConfig
/*     */   {
/*     */     boolean compatible = true;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public VersionFieldSerializerConfig clone() {
/* 155 */       return (VersionFieldSerializerConfig)super.clone();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setCompatible(boolean param1Boolean) {
/* 161 */       this.compatible = param1Boolean;
/* 162 */       if (Log.TRACE) Log.trace("kryo", "VersionFieldSerializerConfig setCompatible: " + param1Boolean); 
/*     */     }
/*     */     
/*     */     public boolean getCompatible() {
/* 166 */       return this.compatible;
/*     */     }
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   @Target({ElementType.FIELD})
/*     */   public static @interface Since {
/*     */     int value() default 0;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\VersionFieldSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */