/*     */ package com.esotericsoftware.kryo.serializers;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import com.esotericsoftware.kryo.Registration;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.InputChunked;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.esotericsoftware.kryo.io.OutputChunked;
/*     */ import com.esotericsoftware.kryo.util.IntMap;
/*     */ import com.esotericsoftware.kryo.util.Util;
/*     */ import com.esotericsoftware.minlog.Log;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.ArrayList;
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
/*     */ public class TaggedFieldSerializer<T>
/*     */   extends FieldSerializer<T>
/*     */ {
/*     */   private FieldSerializer.CachedField[] writeTags;
/*     */   private IntMap<FieldSerializer.CachedField> readTags;
/*     */   private final TaggedFieldSerializerConfig config;
/*     */   
/*     */   public TaggedFieldSerializer(Kryo paramKryo, Class paramClass) {
/*  68 */     this(paramKryo, paramClass, new TaggedFieldSerializerConfig());
/*     */   }
/*     */   
/*     */   public TaggedFieldSerializer(Kryo paramKryo, Class paramClass, TaggedFieldSerializerConfig paramTaggedFieldSerializerConfig) {
/*  72 */     super(paramKryo, paramClass, paramTaggedFieldSerializerConfig);
/*  73 */     this.config = paramTaggedFieldSerializerConfig;
/*  74 */     setAcceptsNull(true);
/*     */   }
/*     */   
/*     */   protected void initializeCachedFields() {
/*  78 */     FieldSerializer.CachedField[] arrayOfCachedField1 = this.cachedFields.fields; byte b2;
/*     */     int i;
/*  80 */     for (b2 = 0, i = arrayOfCachedField1.length; b2 < i; b2++) {
/*     */       Field field;
/*  82 */       if ((field = (arrayOfCachedField1[b2]).field).getAnnotation(Tag.class) == null) {
/*  83 */         if (Log.TRACE) Log.trace("kryo", "Ignoring field without tag: " + arrayOfCachedField1[b2]); 
/*  84 */         super.removeField(arrayOfCachedField1[b2]);
/*     */       } 
/*     */     } 
/*  87 */     arrayOfCachedField1 = this.cachedFields.fields;
/*     */ 
/*     */     
/*  90 */     ArrayList<FieldSerializer.CachedField> arrayList = new ArrayList(arrayOfCachedField1.length);
/*  91 */     this.readTags = new IntMap((int)(arrayOfCachedField1.length / 0.8F)); byte b1; FieldSerializer.CachedField[] arrayOfCachedField2; int j;
/*  92 */     for (j = (arrayOfCachedField2 = arrayOfCachedField1).length, b1 = 0; b1 < j; b1++) {
/*     */       FieldSerializer.CachedField cachedField; Field field;
/*  94 */       int k = ((Tag)(field = (cachedField = arrayOfCachedField2[b1]).field).<Tag>getAnnotation(Tag.class)).value();
/*  95 */       if (this.readTags.containsKey(k))
/*  96 */         throw new KryoException(String.format("Duplicate tag %d on fields: %s and %s", new Object[] { Integer.valueOf(k), field, arrayList.get(k) })); 
/*  97 */       this.readTags.put(k, cachedField);
/*  98 */       if (field.getAnnotation(Deprecated.class) == null) arrayList.add(cachedField); 
/*  99 */       cachedField.tag = k;
/*     */     } 
/* 101 */     this.writeTags = arrayList.<FieldSerializer.CachedField>toArray(new FieldSerializer.CachedField[arrayList.size()]);
/*     */   }
/*     */   
/*     */   public void removeField(String paramString) {
/* 105 */     super.removeField(paramString);
/* 106 */     initializeCachedFields();
/*     */   }
/*     */   
/*     */   public void removeField(FieldSerializer.CachedField paramCachedField) {
/* 110 */     super.removeField(paramCachedField);
/* 111 */     initializeCachedFields();
/*     */   }
/*     */   public void write(Kryo paramKryo, Output paramOutput, T paramT) {
/*     */     Output output;
/* 115 */     if (paramT == null) {
/* 116 */       paramOutput.writeByte((byte)0);
/*     */       
/*     */       return;
/*     */     } 
/* 120 */     int i = pushTypeVariables();
/*     */     
/* 122 */     FieldSerializer.CachedField[] arrayOfCachedField = this.writeTags;
/* 123 */     paramOutput.writeVarInt(arrayOfCachedField.length + 1, true);
/* 124 */     writeHeader(paramKryo, paramOutput, paramT);
/*     */     
/* 126 */     boolean bool1 = this.config.chunked, bool2 = this.config.readUnknownTagData;
/*     */     
/* 128 */     OutputChunked outputChunked = null;
/* 129 */     if (bool1) {
/* 130 */       OutputChunked outputChunked1 = outputChunked = new OutputChunked((OutputStream)paramOutput, this.config.chunkSize);
/*     */     } else {
/* 132 */       output = paramOutput;
/*     */     } 
/* 134 */     byte b = 0; int j = arrayOfCachedField.length; while (true) { FieldSerializer.CachedField cachedField; if (b < j)
/* 135 */       { cachedField = arrayOfCachedField[b];
/* 136 */         if (Log.TRACE) log("Write", cachedField, paramOutput.position()); 
/* 137 */         paramOutput.writeVarInt(cachedField.tag, true);
/*     */ 
/*     */         
/* 140 */         if (bool2)
/* 141 */         { Class<?> clazz = null; try {
/*     */             Object object;
/* 143 */             if (paramT != null && (
/*     */               
/* 145 */               object = cachedField.field.get(paramT)) != null) clazz = object.getClass();
/*     */           
/* 147 */           } catch (IllegalAccessException illegalAccessException) {}
/*     */           
/* 149 */           paramKryo.writeClass(output, clazz);
/* 150 */           if (clazz == null)
/* 151 */           { if (bool1) outputChunked.endChunk();
/*     */              }
/*     */           else
/* 154 */           { cachedField.setCanBeNull(false);
/* 155 */             cachedField.setValueClass(clazz);
/* 156 */             cachedField.setReuseSerializer(false);
/*     */ 
/*     */             
/* 159 */             cachedField.write(output, paramT); }  continue; }  } else { break; }  cachedField.write(output, paramT);
/*     */       
/*     */       b++; }
/*     */     
/* 163 */     popTypeVariables(i);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void writeHeader(Kryo paramKryo, Output paramOutput, T paramT) {}
/*     */   
/*     */   public T read(Kryo paramKryo, Input paramInput, Class<? extends T> paramClass) {
/*     */     Input input;
/*     */     int i;
/* 172 */     if ((i = paramInput.readVarInt(true)) == 0) return null; 
/* 173 */     i--;
/*     */     
/* 175 */     int j = pushTypeVariables();
/*     */     
/* 177 */     paramClass = (Class<? extends T>)create(paramKryo, paramInput, paramClass);
/* 178 */     paramKryo.reference(paramClass);
/*     */     
/* 180 */     boolean bool1 = this.config.chunked, bool2 = this.config.readUnknownTagData;
/*     */     
/* 182 */     InputChunked inputChunked = null;
/* 183 */     if (bool1) {
/* 184 */       InputChunked inputChunked1 = inputChunked = new InputChunked((InputStream)paramInput, this.config.chunkSize);
/*     */     } else {
/* 186 */       input = paramInput;
/* 187 */     }  IntMap<FieldSerializer.CachedField> intMap = this.readTags;
/* 188 */     byte b = 0; while (true) { FieldSerializer.CachedField cachedField; if (b < i)
/* 189 */       { String str; int k = paramInput.readVarInt(true);
/* 190 */         cachedField = (FieldSerializer.CachedField)intMap.get(k);
/*     */         
/* 192 */         if (bool2)
/*     */         
/*     */         { try {
/* 195 */             Registration registration = paramKryo.readClass(input);
/* 196 */           } catch (KryoException kryoException) {
/* 197 */             String str1 = "Unable to read unknown tag " + k + " data (unknown type). (" + getType().getName() + "#" + cachedField + ")";
/*     */             
/* 199 */             if (!bool1) throw new KryoException(str1, kryoException); 
/* 200 */             if (Log.DEBUG) Log.debug("kryo", str1, (Throwable)kryoException); 
/* 201 */             inputChunked.nextChunk();
/*     */           } 
/*     */           
/* 204 */           if (kryoException == null)
/* 205 */           { if (bool1) inputChunked.nextChunk();
/*     */              }
/*     */           else
/* 208 */           { Class clazz = kryoException.getType();
/* 209 */             if (cachedField == null)
/*     */             
/* 211 */             { if (Log.TRACE) Log.trace("kryo", "Read unknown tag " + k + " data, type: " + Util.className(clazz)); 
/*     */               try {
/* 213 */                 paramKryo.readObject(input, clazz);
/* 214 */               } catch (KryoException kryoException1) {
/*     */                 
/* 216 */                 str = "Unable to read unknown tag " + k + " data, type: " + Util.className(clazz) + " (" + getType().getName() + "#" + cachedField + ")";
/* 217 */                 if (!bool1) throw new KryoException(str, kryoException1); 
/* 218 */                 if (Log.DEBUG) Log.debug("kryo", str, (Throwable)kryoException1); 
/*     */               } 
/* 220 */               if (bool1) inputChunked.nextChunk();
/*     */                }
/*     */             else
/* 223 */             { cachedField.setCanBeNull(false);
/* 224 */               cachedField.setValueClass(clazz);
/* 225 */               cachedField.setReuseSerializer(false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 233 */               if (Log.TRACE) log("Read", cachedField, paramInput.position());  }  }  continue; }  if (cachedField == null) { if (!bool1) throw new KryoException("Unknown field tag: " + str + " (" + getType().getName() + ")");  if (Log.TRACE) Log.trace("kryo", "Skip unknown field tag: " + str);  inputChunked.nextChunk(); continue; }  } else { break; }  if (Log.TRACE) log("Read", cachedField, paramInput.position());
/*     */ 
/*     */       
/*     */       b++; }
/*     */     
/* 238 */     popTypeVariables(j);
/* 239 */     return (T)paramClass;
/*     */   }
/*     */   
/*     */   public TaggedFieldSerializerConfig getTaggedFieldSerializerConfig() {
/* 243 */     return this.config;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class TaggedFieldSerializerConfig
/*     */     extends FieldSerializer.FieldSerializerConfig
/*     */   {
/*     */     boolean readUnknownTagData;
/*     */ 
/*     */     
/*     */     boolean chunked;
/*     */     
/* 256 */     int chunkSize = 1024;
/*     */     
/*     */     public TaggedFieldSerializerConfig clone() {
/* 259 */       return (TaggedFieldSerializerConfig)super.clone();
/*     */     }
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
/*     */     public void setReadUnknownTagData(boolean param1Boolean) {
/* 276 */       this.readUnknownTagData = param1Boolean;
/*     */     }
/*     */     
/*     */     public boolean getReadUnknownTagData() {
/* 280 */       return this.readUnknownTagData;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setChunkedEncoding(boolean param1Boolean) {
/* 286 */       this.chunked = param1Boolean;
/* 287 */       if (Log.TRACE) Log.trace("kryo", "TaggedFieldSerializerConfig setChunked: " + param1Boolean); 
/*     */     }
/*     */     
/*     */     public boolean getChunkedEncoding() {
/* 291 */       return this.chunked;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setChunkSize(int param1Int) {
/* 296 */       this.chunkSize = param1Int;
/* 297 */       if (Log.TRACE) Log.trace("kryo", "TaggedFieldSerializerConfig setChunkSize: " + param1Int); 
/*     */     }
/*     */     
/*     */     public int getChunkSize() {
/* 301 */       return this.chunkSize;
/*     */     }
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   @Target({ElementType.FIELD})
/*     */   public static @interface Tag {
/*     */     int value();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\TaggedFieldSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */