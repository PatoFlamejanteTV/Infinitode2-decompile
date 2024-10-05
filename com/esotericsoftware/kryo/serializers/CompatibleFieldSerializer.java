/*     */ package com.esotericsoftware.kryo.serializers;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import com.esotericsoftware.kryo.Registration;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.InputChunked;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.esotericsoftware.kryo.io.OutputChunked;
/*     */ import com.esotericsoftware.kryo.util.ObjectMap;
/*     */ import com.esotericsoftware.kryo.util.Util;
/*     */ import com.esotericsoftware.minlog.Log;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
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
/*     */ public class CompatibleFieldSerializer<T>
/*     */   extends FieldSerializer<T>
/*     */ {
/*     */   private static final int binarySearchThreshold = 32;
/*     */   private final CompatibleFieldSerializerConfig config;
/*     */   
/*     */   public CompatibleFieldSerializer(Kryo paramKryo, Class paramClass) {
/*  53 */     this(paramKryo, paramClass, new CompatibleFieldSerializerConfig());
/*     */   }
/*     */   
/*     */   public CompatibleFieldSerializer(Kryo paramKryo, Class paramClass, CompatibleFieldSerializerConfig paramCompatibleFieldSerializerConfig) {
/*  57 */     super(paramKryo, paramClass, paramCompatibleFieldSerializerConfig);
/*  58 */     this.config = paramCompatibleFieldSerializerConfig;
/*     */   }
/*     */   public void write(Kryo paramKryo, Output paramOutput, T paramT) {
/*     */     Output output;
/*  62 */     int i = pushTypeVariables();
/*     */     
/*  64 */     FieldSerializer.CachedField[] arrayOfCachedField = this.cachedFields.fields;
/*     */     ObjectMap objectMap;
/*  66 */     if (!(objectMap = paramKryo.getGraphContext()).containsKey(this)) {
/*  67 */       if (Log.TRACE) Log.trace("kryo", "Write fields for class: " + this.type.getName()); 
/*  68 */       objectMap.put(this, null);
/*  69 */       paramOutput.writeVarInt(arrayOfCachedField.length, true); byte b1; int k;
/*  70 */       for (b1 = 0, k = arrayOfCachedField.length; b1 < k; b1++) {
/*  71 */         if (Log.TRACE) Log.trace("kryo", "Write field name: " + (arrayOfCachedField[b1]).name + Util.pos(paramOutput.position())); 
/*  72 */         paramOutput.writeString((arrayOfCachedField[b1]).name);
/*     */       } 
/*     */     } 
/*     */     
/*  76 */     boolean bool1 = this.config.chunked, bool2 = this.config.readUnknownFieldData;
/*     */     
/*  78 */     OutputChunked outputChunked = null;
/*  79 */     if (bool1) {
/*  80 */       OutputChunked outputChunked1 = outputChunked = new OutputChunked((OutputStream)paramOutput, this.config.chunkSize);
/*     */     } else {
/*  82 */       output = paramOutput;
/*  83 */     }  byte b = 0; int j = arrayOfCachedField.length; while (true) { FieldSerializer.CachedField cachedField; if (b < j)
/*  84 */       { cachedField = arrayOfCachedField[b];
/*  85 */         if (Log.TRACE) log("Write", cachedField, paramOutput.position());
/*     */ 
/*     */         
/*  88 */         if (bool2)
/*  89 */         { Class<?> clazz = null; try {
/*     */             Object object;
/*  91 */             if (paramT != null && (
/*     */               
/*  93 */               object = cachedField.field.get(paramT)) != null) clazz = object.getClass();
/*     */           
/*  95 */           } catch (IllegalAccessException illegalAccessException) {}
/*     */           
/*  97 */           paramKryo.writeClass(output, clazz);
/*  98 */           if (clazz == null)
/*  99 */           { if (bool1) outputChunked.endChunk();
/*     */              }
/*     */           else
/* 102 */           { cachedField.setCanBeNull(false);
/* 103 */             cachedField.setValueClass(clazz);
/* 104 */             cachedField.setReuseSerializer(false);
/*     */ 
/*     */             
/* 107 */             cachedField.write(output, paramT); }  continue; }  } else { break; }  cachedField.write(output, paramT);
/*     */       
/*     */       b++; }
/*     */     
/* 111 */     popTypeVariables(i);
/*     */   }
/*     */   public T read(Kryo paramKryo, Input paramInput, Class<? extends T> paramClass) {
/*     */     Input input;
/* 115 */     int i = pushTypeVariables();
/*     */     
/* 117 */     paramClass = (Class<? extends T>)create(paramKryo, paramInput, paramClass);
/* 118 */     paramKryo.reference(paramClass);
/*     */     
/*     */     FieldSerializer.CachedField[] arrayOfCachedField;
/* 121 */     if ((arrayOfCachedField = (FieldSerializer.CachedField[])paramKryo.getGraphContext().get(this)) == null) arrayOfCachedField = readFields(paramKryo, paramInput);
/*     */     
/* 123 */     boolean bool1 = this.config.chunked, bool2 = this.config.readUnknownFieldData;
/*     */     
/* 125 */     InputChunked inputChunked = null;
/* 126 */     if (bool1) {
/* 127 */       InputChunked inputChunked1 = inputChunked = new InputChunked((InputStream)paramInput, this.config.chunkSize);
/*     */     } else {
/* 129 */       input = paramInput;
/* 130 */     }  byte b = 0; int j = arrayOfCachedField.length; while (true) { String str; if (b < j)
/* 131 */       { FieldSerializer.CachedField cachedField = arrayOfCachedField[b];
/*     */         
/* 133 */         if (bool2)
/*     */         
/*     */         { try {
/* 136 */             Registration registration = paramKryo.readClass(input);
/* 137 */           } catch (KryoException kryoException) {
/* 138 */             String str1 = "Unable to read unknown data (unknown type). (" + getType().getName() + "#" + cachedField + ")";
/* 139 */             if (!bool1) throw new KryoException(str1, kryoException); 
/* 140 */             if (Log.DEBUG) Log.debug("kryo", str1, (Throwable)kryoException); 
/* 141 */             inputChunked.nextChunk();
/*     */           } 
/*     */           
/* 144 */           if (kryoException == null)
/* 145 */           { if (bool1) inputChunked.nextChunk();
/*     */              }
/*     */           else
/* 148 */           { Class clazz = kryoException.getType();
/* 149 */             if (cachedField == null)
/*     */             
/* 151 */             { if (Log.TRACE) Log.trace("kryo", "Read unknown data, type: " + Util.className(clazz) + Util.pos(paramInput.position())); 
/*     */               try {
/* 153 */                 paramKryo.readObject(input, clazz);
/* 154 */               } catch (KryoException kryoException1) {
/* 155 */                 str = "Unable to read unknown data, type: " + Util.className(clazz) + " (" + getType().getName() + "#" + cachedField + ")";
/*     */                 
/* 157 */                 if (!bool1) throw new KryoException(str, kryoException1); 
/* 158 */                 if (Log.DEBUG) Log.debug("kryo", str, (Throwable)kryoException1); 
/*     */               } 
/* 160 */               if (bool1) inputChunked.nextChunk();
/*     */               
/*     */               
/*     */                }
/*     */             
/* 165 */             else if (((FieldSerializer.CachedField)str).valueClass != null && !Util.isAssignableTo(clazz, ((FieldSerializer.CachedField)str).field.getType()))
/*     */             
/* 167 */             { String str1 = "Read type is incompatible with the field type: " + Util.className(clazz) + " -> " + Util.className(((FieldSerializer.CachedField)str).valueClass) + " (" + getType().getName() + "#" + str + ")";
/* 168 */               if (!bool1) throw new KryoException(str1); 
/* 169 */               if (Log.DEBUG) Log.debug("kryo", str1); 
/* 170 */               inputChunked.nextChunk(); }
/*     */             
/*     */             else
/*     */             
/* 174 */             { str.setCanBeNull(false);
/* 175 */               str.setValueClass(clazz);
/* 176 */               str.setReuseSerializer(false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 184 */               if (Log.TRACE) log("Read", (FieldSerializer.CachedField)str, paramInput.position());  }  }  continue; }  if (str == null) { if (!bool1) throw new KryoException("Unknown field. (" + getType().getName() + ")");  if (Log.TRACE) Log.trace("kryo", "Skip unknown field.");  inputChunked.nextChunk(); continue; }  } else { break; }  if (Log.TRACE) log("Read", (FieldSerializer.CachedField)str, paramInput.position());
/*     */ 
/*     */       
/*     */       b++; }
/*     */     
/* 189 */     popTypeVariables(i);
/* 190 */     return (T)paramClass;
/*     */   }
/*     */   
/*     */   private FieldSerializer.CachedField[] readFields(Kryo paramKryo, Input paramInput) {
/* 194 */     if (Log.TRACE) Log.trace("kryo", "Read fields for class: " + this.type.getName());
/*     */     
/*     */     int i;
/* 197 */     String[] arrayOfString = new String[i = paramInput.readVarInt(true)];
/* 198 */     for (byte b = 0; b < i; b++) {
/* 199 */       arrayOfString[b] = paramInput.readString();
/* 200 */       if (Log.TRACE) Log.trace("kryo", "Read field name: " + arrayOfString[b]);
/*     */     
/*     */     } 
/* 203 */     FieldSerializer.CachedField[] arrayOfCachedField2 = new FieldSerializer.CachedField[i];
/* 204 */     FieldSerializer.CachedField[] arrayOfCachedField1 = this.cachedFields.fields;
/* 205 */     if (i < 32) {
/*     */       byte b1;
/* 207 */       label49: for (b1 = 0; b1 < i; b1++) {
/* 208 */         String str = arrayOfString[b1]; byte b2; int j;
/* 209 */         for (b2 = 0, j = arrayOfCachedField1.length; b2 < j; b2++) {
/* 210 */           if ((arrayOfCachedField1[b2]).name.equals(str)) {
/* 211 */             arrayOfCachedField2[b1] = arrayOfCachedField1[b2];
/*     */             continue label49;
/*     */           } 
/*     */         } 
/* 215 */         if (Log.TRACE) Log.trace("kryo", "Unknown field will be skipped: " + str);
/*     */       
/*     */       } 
/*     */     } else {
/* 219 */       int j = arrayOfCachedField1.length - 1;
/*     */       byte b1;
/* 221 */       label50: for (b1 = 0; b1 < i; b1++) {
/* 222 */         String str = arrayOfString[b1];
/* 223 */         int k = 0;
/* 224 */         int m = j;
/* 225 */         while (k <= m) {
/* 226 */           int n = k + m >>> 1;
/*     */           int i1;
/* 228 */           if ((i1 = str.compareTo((arrayOfCachedField1[n]).name)) < 0) {
/* 229 */             m = n - 1; continue;
/* 230 */           }  if (i1 > 0) {
/* 231 */             k = n + 1; continue;
/*     */           } 
/* 233 */           arrayOfCachedField2[b1] = arrayOfCachedField1[n];
/*     */           
/*     */           continue label50;
/*     */         } 
/* 237 */         if (Log.TRACE) Log.trace("kryo", "Unknown field will be skipped: " + str);
/*     */       
/*     */       } 
/*     */     } 
/* 241 */     paramKryo.getGraphContext().put(this, arrayOfCachedField2);
/* 242 */     return arrayOfCachedField2;
/*     */   }
/*     */   
/*     */   public CompatibleFieldSerializerConfig getCompatibleFieldSerializerConfig() {
/* 246 */     return this.config;
/*     */   }
/*     */   
/*     */   public static class CompatibleFieldSerializerConfig extends FieldSerializer.FieldSerializerConfig {
/*     */     boolean readUnknownFieldData = true;
/*     */     boolean chunked;
/* 252 */     int chunkSize = 1024;
/*     */     
/*     */     public CompatibleFieldSerializerConfig clone() {
/* 255 */       return (CompatibleFieldSerializerConfig)super.clone();
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
/*     */     public void setReadUnknownFieldData(boolean param1Boolean) {
/* 271 */       this.readUnknownFieldData = param1Boolean;
/*     */     }
/*     */     
/*     */     public boolean getReadUnknownTagData() {
/* 275 */       return this.readUnknownFieldData;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setChunkedEncoding(boolean param1Boolean) {
/* 281 */       this.chunked = param1Boolean;
/* 282 */       if (Log.TRACE) Log.trace("kryo", "CompatibleFieldSerializerConfig setChunked: " + param1Boolean); 
/*     */     }
/*     */     
/*     */     public boolean getChunkedEncoding() {
/* 286 */       return this.chunked;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setChunkSize(int param1Int) {
/* 291 */       this.chunkSize = param1Int;
/* 292 */       if (Log.TRACE) Log.trace("kryo", "CompatibleFieldSerializerConfig setChunkSize: " + param1Int); 
/*     */     }
/*     */     
/*     */     public int getChunkSize() {
/* 296 */       return this.chunkSize;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\CompatibleFieldSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */