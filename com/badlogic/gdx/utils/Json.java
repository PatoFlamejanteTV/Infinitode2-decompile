/*      */ package com.badlogic.gdx.utils;
/*      */ 
/*      */ import com.badlogic.gdx.files.FileHandle;
/*      */ import com.badlogic.gdx.utils.reflect.ArrayReflection;
/*      */ import com.badlogic.gdx.utils.reflect.ClassReflection;
/*      */ import com.badlogic.gdx.utils.reflect.Constructor;
/*      */ import com.badlogic.gdx.utils.reflect.Field;
/*      */ import com.badlogic.gdx.utils.reflect.ReflectionException;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.Reader;
/*      */ import java.io.StringWriter;
/*      */ import java.io.Writer;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Map;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Json
/*      */ {
/*      */   private static final boolean debug = false;
/*      */   private JsonWriter writer;
/*   49 */   private String typeName = "class";
/*      */   private boolean usePrototypes = true;
/*      */   private JsonWriter.OutputType outputType;
/*      */   private boolean quoteLongValues;
/*      */   private boolean ignoreUnknownFields;
/*      */   private boolean ignoreDeprecated;
/*      */   private boolean readDeprecated;
/*      */   private boolean enumNames = true;
/*      */   private boolean sortFields;
/*      */   private Serializer defaultSerializer;
/*   59 */   private final ObjectMap<Class, OrderedMap<String, FieldMetadata>> typeToFields = new ObjectMap<>();
/*   60 */   private final ObjectMap<String, Class> tagToClass = new ObjectMap<>();
/*   61 */   private final ObjectMap<Class, String> classToTag = new ObjectMap<>();
/*   62 */   private final ObjectMap<Class, Serializer> classToSerializer = new ObjectMap<>();
/*   63 */   private final ObjectMap<Class, Object[]> classToDefaultValues = (ObjectMap)new ObjectMap<>();
/*   64 */   private final Object[] equals1 = new Object[] { null }, equals2 = new Object[] { null };
/*      */   
/*      */   public Json() {
/*   67 */     this.outputType = JsonWriter.OutputType.minimal;
/*      */   }
/*      */   
/*      */   public Json(JsonWriter.OutputType paramOutputType) {
/*   71 */     this.outputType = paramOutputType;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIgnoreUnknownFields(boolean paramBoolean) {
/*   77 */     this.ignoreUnknownFields = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean getIgnoreUnknownFields() {
/*   81 */     return this.ignoreUnknownFields;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIgnoreDeprecated(boolean paramBoolean) {
/*   88 */     this.ignoreDeprecated = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReadDeprecated(boolean paramBoolean) {
/*   95 */     this.readDeprecated = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOutputType(JsonWriter.OutputType paramOutputType) {
/*  101 */     this.outputType = paramOutputType;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setQuoteLongValues(boolean paramBoolean) {
/*  107 */     this.quoteLongValues = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEnumNames(boolean paramBoolean) {
/*  113 */     this.enumNames = paramBoolean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void addClassTag(String paramString, Class paramClass) {
/*  118 */     this.tagToClass.put(paramString, paramClass);
/*  119 */     this.classToTag.put(paramClass, paramString);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Class getClass(String paramString) {
/*  124 */     return this.tagToClass.<String>get(paramString);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public String getTag(Class<?> paramClass) {
/*  129 */     return this.classToTag.<Class<?>>get(paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTypeName(@Null String paramString) {
/*  136 */     this.typeName = paramString;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDefaultSerializer(@Null Serializer paramSerializer) {
/*  141 */     this.defaultSerializer = paramSerializer;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> void setSerializer(Class<T> paramClass, Serializer<T> paramSerializer) {
/*  147 */     this.classToSerializer.put(paramClass, paramSerializer);
/*      */   }
/*      */   
/*      */   public <T> Serializer<T> getSerializer(Class<T> paramClass) {
/*  151 */     return this.classToSerializer.<Class<T>>get(paramClass);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setUsePrototypes(boolean paramBoolean) {
/*  156 */     this.usePrototypes = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setElementType(Class paramClass1, String paramString, Class paramClass2) {
/*      */     FieldMetadata fieldMetadata;
/*  163 */     if ((fieldMetadata = getFields(paramClass1).get(paramString)) == null) throw new SerializationException("Field not found: " + paramString + " (" + paramClass1.getName() + ")"); 
/*  164 */     fieldMetadata.elementType = paramClass2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDeprecated(Class paramClass, String paramString, boolean paramBoolean) {
/*      */     FieldMetadata fieldMetadata;
/*  172 */     if ((fieldMetadata = getFields(paramClass).get(paramString)) == null) throw new SerializationException("Field not found: " + paramString + " (" + paramClass.getName() + ")"); 
/*  173 */     fieldMetadata.deprecated = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSortFields(boolean paramBoolean) {
/*  179 */     this.sortFields = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void sortFields(Class paramClass, Array<String> paramArray) {
/*  185 */     if (this.sortFields) paramArray.sort(); 
/*      */   }
/*      */   
/*      */   private OrderedMap<String, FieldMetadata> getFields(Class<?> paramClass) {
/*      */     OrderedMap<String, FieldMetadata> orderedMap;
/*  190 */     if ((orderedMap = this.typeToFields.<Class>get(paramClass)) != null) return orderedMap;
/*      */     
/*  192 */     Array<Class<?>> array = new Array();
/*  193 */     Class<?> clazz = paramClass;
/*  194 */     while (clazz != Object.class) {
/*  195 */       array.add(clazz);
/*  196 */       clazz = clazz.getSuperclass();
/*      */     } 
/*  198 */     ArrayList<? super Field> arrayList = new ArrayList();
/*  199 */     for (int i = array.size - 1; i >= 0; i--) {
/*  200 */       Collections.addAll(arrayList, ClassReflection.getDeclaredFields(array.get(i)));
/*      */     }
/*  202 */     OrderedMap<Object, Object> orderedMap1 = new OrderedMap<>(arrayList.size()); byte b; int j;
/*  203 */     for (b = 0, j = arrayList.size(); b < j; b++) {
/*      */       Field field;
/*      */       
/*  206 */       if (!(field = arrayList.get(b)).isTransient() && 
/*  207 */         !field.isStatic() && 
/*  208 */         !field.isSynthetic()) {
/*      */         
/*  210 */         if (!field.isAccessible()) {
/*      */           try {
/*  212 */             field.setAccessible(true);
/*  213 */           } catch (RuntimeException runtimeException) {}
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*  218 */         orderedMap1.put(field.getName(), new FieldMetadata(field));
/*      */       } 
/*  220 */     }  sortFields(paramClass, orderedMap1.keys);
/*  221 */     this.typeToFields.put(paramClass, orderedMap1);
/*  222 */     return (OrderedMap)orderedMap1;
/*      */   }
/*      */   
/*      */   public String toJson(@Null Object paramObject) {
/*  226 */     return toJson(paramObject, (paramObject == null) ? null : paramObject.getClass(), (Class)null);
/*      */   }
/*      */   
/*      */   public String toJson(@Null Object paramObject, @Null Class paramClass) {
/*  230 */     return toJson(paramObject, paramClass, (Class)null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String toJson(@Null Object paramObject, @Null Class paramClass1, @Null Class paramClass2) {
/*  236 */     StringWriter stringWriter = new StringWriter();
/*  237 */     toJson(paramObject, paramClass1, paramClass2, stringWriter);
/*  238 */     return stringWriter.toString();
/*      */   }
/*      */   
/*      */   public void toJson(@Null Object paramObject, FileHandle paramFileHandle) {
/*  242 */     toJson(paramObject, (paramObject == null) ? null : paramObject.getClass(), (Class)null, paramFileHandle);
/*      */   }
/*      */ 
/*      */   
/*      */   public void toJson(@Null Object paramObject, @Null Class paramClass, FileHandle paramFileHandle) {
/*  247 */     toJson(paramObject, paramClass, (Class)null, paramFileHandle);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void toJson(@Null Object paramObject, @Null Class paramClass1, @Null Class paramClass2, FileHandle paramFileHandle) {
/*  253 */     Writer writer = null;
/*      */     try {
/*  255 */       writer = paramFileHandle.writer(false, "UTF-8");
/*  256 */       toJson(paramObject, paramClass1, paramClass2, writer); return;
/*  257 */     } catch (Exception exception) {
/*  258 */       throw new SerializationException("Error writing file: " + paramFileHandle, exception);
/*      */     } finally {
/*  260 */       StreamUtils.closeQuietly(writer);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void toJson(@Null Object paramObject, Writer paramWriter) {
/*  265 */     toJson(paramObject, (paramObject == null) ? null : paramObject.getClass(), (Class)null, paramWriter);
/*      */   }
/*      */ 
/*      */   
/*      */   public void toJson(@Null Object paramObject, @Null Class paramClass, Writer paramWriter) {
/*  270 */     toJson(paramObject, paramClass, (Class)null, paramWriter);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void toJson(@Null Object paramObject, @Null Class paramClass1, @Null Class paramClass2, Writer paramWriter) {
/*  276 */     setWriter(paramWriter);
/*      */     try {
/*  278 */       writeValue(paramObject, paramClass1, paramClass2); return;
/*      */     } finally {
/*  280 */       StreamUtils.closeQuietly(this.writer);
/*  281 */       this.writer = null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setWriter(Writer paramWriter) {
/*  287 */     if (!(paramWriter instanceof JsonWriter)) paramWriter = new JsonWriter(paramWriter); 
/*  288 */     this.writer = (JsonWriter)paramWriter;
/*  289 */     this.writer.setOutputType(this.outputType);
/*  290 */     this.writer.setQuoteLongValues(this.quoteLongValues);
/*      */   }
/*      */   
/*      */   public JsonWriter getWriter() {
/*  294 */     return this.writer;
/*      */   }
/*      */   
/*      */   public void writeFields(Object paramObject)
/*      */   {
/*  299 */     Class<?> clazz = paramObject.getClass();
/*      */     
/*  301 */     Object[] arrayOfObject = getDefaultValues(clazz);
/*      */     
/*  303 */     OrderedMap<String, FieldMetadata> orderedMap = getFields(clazz);
/*  304 */     byte b1 = 0;
/*  305 */     Array<String> array = orderedMap.orderedKeys(); byte b2; int i;
/*  306 */     for (b2 = 0, i = array.size; b2 < i; b2++) {
/*  307 */       FieldMetadata fieldMetadata = orderedMap.get(array.get(b2));
/*  308 */       if (!this.ignoreDeprecated || !fieldMetadata.deprecated) {
/*  309 */         Field field = fieldMetadata.field;
/*      */         try {
/*  311 */           Object object = field.get(paramObject);
/*  312 */           if (arrayOfObject != null) {
/*  313 */             Object object1 = arrayOfObject[b1++];
/*  314 */             if (object == null && object1 == null)
/*  315 */               continue;  if (object != null && object1 != null) {
/*  316 */               if (object.equals(object1))
/*  317 */                 continue;  if (object.getClass().isArray() && object1.getClass().isArray()) {
/*  318 */                 this.equals1[0] = object;
/*  319 */                 this.equals2[0] = object1;
/*  320 */                 if (Arrays.deepEquals(this.equals1, this.equals2)) {
/*      */                   continue;
/*      */                 }
/*      */               } 
/*      */             } 
/*      */           } 
/*  326 */           this.writer.name(field.getName());
/*  327 */           writeValue(object, field.getType(), fieldMetadata.elementType);
/*  328 */         } catch (ReflectionException reflectionException) {
/*  329 */           throw new SerializationException("Error accessing field: " + field.getName() + " (" + clazz.getName() + ")", reflectionException);
/*  330 */         } catch (SerializationException serializationException2) {
/*  331 */           SerializationException serializationException1; (serializationException1 = null).addTrace(field + " (" + clazz.getName() + ")");
/*  332 */           throw serializationException1;
/*  333 */         } catch (Exception exception) {
/*      */           SerializationException serializationException;
/*  335 */           (serializationException = new SerializationException(exception)).addTrace(field + " (" + clazz.getName() + ")");
/*  336 */           throw serializationException;
/*      */         } 
/*      */       } 
/*      */       continue;
/*      */     }  } @Null
/*      */   private Object[] getDefaultValues(Class<?> paramClass) { Object object;
/*  342 */     if (!this.usePrototypes) return null; 
/*  343 */     if (this.classToDefaultValues.containsKey(paramClass)) return this.classToDefaultValues.<Class<?>>get(paramClass);
/*      */     
/*      */     try {
/*  346 */       object = newInstance(paramClass);
/*  347 */     } catch (Exception exception) {
/*  348 */       this.classToDefaultValues.put(paramClass, null);
/*  349 */       return null;
/*      */     } 
/*      */     
/*      */     OrderedMap<String, FieldMetadata> orderedMap;
/*  353 */     Object[] arrayOfObject = new Object[(orderedMap = getFields(paramClass)).size];
/*  354 */     this.classToDefaultValues.put(paramClass, arrayOfObject);
/*      */     
/*  356 */     byte b1 = 0;
/*  357 */     Array<String> array = orderedMap.orderedKeys(); byte b2; int i;
/*  358 */     for (b2 = 0, i = array.size; b2 < i; b2++) {
/*  359 */       FieldMetadata fieldMetadata = orderedMap.get(array.get(b2));
/*  360 */       if (!this.ignoreDeprecated || !fieldMetadata.deprecated) {
/*  361 */         Field field = fieldMetadata.field;
/*      */         try {
/*  363 */           arrayOfObject[b1++] = field.get(object);
/*  364 */         } catch (ReflectionException reflectionException) {
/*  365 */           throw new SerializationException("Error accessing field: " + field.getName() + " (" + paramClass.getName() + ")", reflectionException);
/*  366 */         } catch (SerializationException serializationException) {
/*  367 */           (object = null).addTrace(field + " (" + paramClass.getName() + ")");
/*  368 */           throw object;
/*  369 */         } catch (RuntimeException runtimeException) {
/*      */           
/*  371 */           (runtimeException = new SerializationException(runtimeException)).addTrace(field + " (" + paramClass.getName() + ")");
/*  372 */           throw runtimeException;
/*      */         } 
/*      */       } 
/*  375 */     }  return arrayOfObject; }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeField(Object paramObject, String paramString) {
/*  380 */     writeField(paramObject, paramString, paramString, null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeField(Object paramObject, String paramString, @Null Class paramClass) {
/*  386 */     writeField(paramObject, paramString, paramString, paramClass);
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeField(Object paramObject, String paramString1, String paramString2) {
/*  391 */     writeField(paramObject, paramString1, paramString2, null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeField(Object paramObject, String paramString1, String paramString2, @Null Class paramClass) {
/*  397 */     Class<?> clazz = paramObject.getClass();
/*      */     FieldMetadata fieldMetadata;
/*  399 */     if ((fieldMetadata = getFields(clazz).get(paramString1)) == null) throw new SerializationException("Field not found: " + paramString1 + " (" + clazz.getName() + ")"); 
/*  400 */     Field field = fieldMetadata.field;
/*  401 */     if (paramClass == null) paramClass = fieldMetadata.elementType;
/*      */     
/*      */     try {
/*  404 */       this.writer.name(paramString2);
/*  405 */       writeValue(field.get(paramObject), field.getType(), paramClass); return;
/*  406 */     } catch (ReflectionException reflectionException) {
/*  407 */       throw new SerializationException("Error accessing field: " + field.getName() + " (" + clazz.getName() + ")", reflectionException);
/*  408 */     } catch (SerializationException serializationException) {
/*  409 */       (paramObject = null).addTrace(field + " (" + clazz.getName() + ")");
/*  410 */       throw paramObject;
/*  411 */     } catch (Exception exception) {
/*      */       
/*  413 */       (exception = new SerializationException(exception)).addTrace(field + " (" + clazz.getName() + ")");
/*  414 */       throw exception;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeValue(String paramString, @Null Object paramObject) {
/*      */     try {
/*  423 */       this.writer.name(paramString);
/*  424 */     } catch (IOException iOException) {
/*  425 */       throw new SerializationException(iOException);
/*      */     } 
/*  427 */     if (paramObject == null) {
/*  428 */       writeValue(paramObject, (Class)null, (Class)null); return;
/*      */     } 
/*  430 */     writeValue(paramObject, paramObject.getClass(), (Class)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeValue(String paramString, @Null Object paramObject, @Null Class paramClass) {
/*      */     try {
/*  440 */       this.writer.name(paramString);
/*  441 */     } catch (IOException iOException) {
/*  442 */       throw new SerializationException(iOException);
/*      */     } 
/*  444 */     writeValue(paramObject, paramClass, (Class)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeValue(String paramString, @Null Object paramObject, @Null Class paramClass1, @Null Class paramClass2) {
/*      */     try {
/*  454 */       this.writer.name(paramString);
/*  455 */     } catch (IOException iOException) {
/*  456 */       throw new SerializationException(iOException);
/*      */     } 
/*  458 */     writeValue(paramObject, paramClass1, paramClass2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeValue(@Null Object paramObject) {
/*  464 */     if (paramObject == null) {
/*  465 */       writeValue(paramObject, (Class)null, (Class)null); return;
/*      */     } 
/*  467 */     writeValue(paramObject, paramObject.getClass(), (Class)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeValue(@Null Object paramObject, @Null Class paramClass) {
/*  474 */     writeValue(paramObject, paramClass, (Class)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeValue(@Null Object paramObject, @Null Class<String> paramClass1, @Null Class paramClass2) {
/*      */     // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: ifnonnull -> 14
/*      */     //   4: aload_0
/*      */     //   5: getfield writer : Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   8: aconst_null
/*      */     //   9: invokevirtual value : (Ljava/lang/Object;)Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   12: pop
/*      */     //   13: return
/*      */     //   14: aload_2
/*      */     //   15: ifnull -> 25
/*      */     //   18: aload_2
/*      */     //   19: invokevirtual isPrimitive : ()Z
/*      */     //   22: ifne -> 79
/*      */     //   25: aload_2
/*      */     //   26: ldc java/lang/String
/*      */     //   28: if_acmpeq -> 79
/*      */     //   31: aload_2
/*      */     //   32: ldc java/lang/Integer
/*      */     //   34: if_acmpeq -> 79
/*      */     //   37: aload_2
/*      */     //   38: ldc java/lang/Boolean
/*      */     //   40: if_acmpeq -> 79
/*      */     //   43: aload_2
/*      */     //   44: ldc java/lang/Float
/*      */     //   46: if_acmpeq -> 79
/*      */     //   49: aload_2
/*      */     //   50: ldc java/lang/Long
/*      */     //   52: if_acmpeq -> 79
/*      */     //   55: aload_2
/*      */     //   56: ldc java/lang/Double
/*      */     //   58: if_acmpeq -> 79
/*      */     //   61: aload_2
/*      */     //   62: ldc java/lang/Short
/*      */     //   64: if_acmpeq -> 79
/*      */     //   67: aload_2
/*      */     //   68: ldc java/lang/Byte
/*      */     //   70: if_acmpeq -> 79
/*      */     //   73: aload_2
/*      */     //   74: ldc java/lang/Character
/*      */     //   76: if_acmpne -> 89
/*      */     //   79: aload_0
/*      */     //   80: getfield writer : Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   83: aload_1
/*      */     //   84: invokevirtual value : (Ljava/lang/Object;)Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   87: pop
/*      */     //   88: return
/*      */     //   89: aload_1
/*      */     //   90: invokevirtual getClass : ()Ljava/lang/Class;
/*      */     //   93: dup
/*      */     //   94: astore #4
/*      */     //   96: invokevirtual isPrimitive : ()Z
/*      */     //   99: ifne -> 165
/*      */     //   102: aload #4
/*      */     //   104: ldc java/lang/String
/*      */     //   106: if_acmpeq -> 165
/*      */     //   109: aload #4
/*      */     //   111: ldc java/lang/Integer
/*      */     //   113: if_acmpeq -> 165
/*      */     //   116: aload #4
/*      */     //   118: ldc java/lang/Boolean
/*      */     //   120: if_acmpeq -> 165
/*      */     //   123: aload #4
/*      */     //   125: ldc java/lang/Float
/*      */     //   127: if_acmpeq -> 165
/*      */     //   130: aload #4
/*      */     //   132: ldc java/lang/Long
/*      */     //   134: if_acmpeq -> 165
/*      */     //   137: aload #4
/*      */     //   139: ldc java/lang/Double
/*      */     //   141: if_acmpeq -> 165
/*      */     //   144: aload #4
/*      */     //   146: ldc java/lang/Short
/*      */     //   148: if_acmpeq -> 165
/*      */     //   151: aload #4
/*      */     //   153: ldc java/lang/Byte
/*      */     //   155: if_acmpeq -> 165
/*      */     //   158: aload #4
/*      */     //   160: ldc java/lang/Character
/*      */     //   162: if_acmpne -> 184
/*      */     //   165: aload_0
/*      */     //   166: aload #4
/*      */     //   168: aconst_null
/*      */     //   169: invokevirtual writeObjectStart : (Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   172: aload_0
/*      */     //   173: ldc 'value'
/*      */     //   175: aload_1
/*      */     //   176: invokevirtual writeValue : (Ljava/lang/String;Ljava/lang/Object;)V
/*      */     //   179: aload_0
/*      */     //   180: invokevirtual writeObjectEnd : ()V
/*      */     //   183: return
/*      */     //   184: aload_1
/*      */     //   185: instanceof com/badlogic/gdx/utils/Json$Serializable
/*      */     //   188: ifeq -> 213
/*      */     //   191: aload_0
/*      */     //   192: aload #4
/*      */     //   194: aload_2
/*      */     //   195: invokevirtual writeObjectStart : (Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   198: aload_1
/*      */     //   199: checkcast com/badlogic/gdx/utils/Json$Serializable
/*      */     //   202: aload_0
/*      */     //   203: invokeinterface write : (Lcom/badlogic/gdx/utils/Json;)V
/*      */     //   208: aload_0
/*      */     //   209: invokevirtual writeObjectEnd : ()V
/*      */     //   212: return
/*      */     //   213: aload_0
/*      */     //   214: getfield classToSerializer : Lcom/badlogic/gdx/utils/ObjectMap;
/*      */     //   217: aload #4
/*      */     //   219: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
/*      */     //   222: checkcast com/badlogic/gdx/utils/Json$Serializer
/*      */     //   225: dup
/*      */     //   226: astore #5
/*      */     //   228: ifnull -> 242
/*      */     //   231: aload #5
/*      */     //   233: aload_0
/*      */     //   234: aload_1
/*      */     //   235: aload_2
/*      */     //   236: invokeinterface write : (Lcom/badlogic/gdx/utils/Json;Ljava/lang/Object;Ljava/lang/Class;)V
/*      */     //   241: return
/*      */     //   242: aload_1
/*      */     //   243: instanceof com/badlogic/gdx/utils/Array
/*      */     //   246: ifeq -> 346
/*      */     //   249: aload_2
/*      */     //   250: ifnull -> 300
/*      */     //   253: aload #4
/*      */     //   255: aload_2
/*      */     //   256: if_acmpeq -> 300
/*      */     //   259: aload #4
/*      */     //   261: ldc com/badlogic/gdx/utils/Array
/*      */     //   263: if_acmpeq -> 300
/*      */     //   266: new com/badlogic/gdx/utils/SerializationException
/*      */     //   269: dup
/*      */     //   270: new java/lang/StringBuilder
/*      */     //   273: dup
/*      */     //   274: ldc 'Serialization of an Array other than the known type is not supported.\\nKnown type: '
/*      */     //   276: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   279: aload_2
/*      */     //   280: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*      */     //   283: ldc '\\nActual type: '
/*      */     //   285: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   288: aload #4
/*      */     //   290: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*      */     //   293: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   296: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   299: athrow
/*      */     //   300: aload_0
/*      */     //   301: invokevirtual writeArrayStart : ()V
/*      */     //   304: aload_1
/*      */     //   305: checkcast com/badlogic/gdx/utils/Array
/*      */     //   308: astore_2
/*      */     //   309: iconst_0
/*      */     //   310: istore #4
/*      */     //   312: aload_2
/*      */     //   313: getfield size : I
/*      */     //   316: istore_1
/*      */     //   317: iload #4
/*      */     //   319: iload_1
/*      */     //   320: if_icmpge -> 341
/*      */     //   323: aload_0
/*      */     //   324: aload_2
/*      */     //   325: iload #4
/*      */     //   327: invokevirtual get : (I)Ljava/lang/Object;
/*      */     //   330: aload_3
/*      */     //   331: aconst_null
/*      */     //   332: invokevirtual writeValue : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   335: iinc #4, 1
/*      */     //   338: goto -> 317
/*      */     //   341: aload_0
/*      */     //   342: invokevirtual writeArrayEnd : ()V
/*      */     //   345: return
/*      */     //   346: aload_1
/*      */     //   347: instanceof com/badlogic/gdx/utils/Queue
/*      */     //   350: ifeq -> 450
/*      */     //   353: aload_2
/*      */     //   354: ifnull -> 404
/*      */     //   357: aload #4
/*      */     //   359: aload_2
/*      */     //   360: if_acmpeq -> 404
/*      */     //   363: aload #4
/*      */     //   365: ldc com/badlogic/gdx/utils/Queue
/*      */     //   367: if_acmpeq -> 404
/*      */     //   370: new com/badlogic/gdx/utils/SerializationException
/*      */     //   373: dup
/*      */     //   374: new java/lang/StringBuilder
/*      */     //   377: dup
/*      */     //   378: ldc 'Serialization of a Queue other than the known type is not supported.\\nKnown type: '
/*      */     //   380: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   383: aload_2
/*      */     //   384: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*      */     //   387: ldc '\\nActual type: '
/*      */     //   389: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   392: aload #4
/*      */     //   394: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*      */     //   397: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   400: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   403: athrow
/*      */     //   404: aload_0
/*      */     //   405: invokevirtual writeArrayStart : ()V
/*      */     //   408: aload_1
/*      */     //   409: checkcast com/badlogic/gdx/utils/Queue
/*      */     //   412: astore_2
/*      */     //   413: iconst_0
/*      */     //   414: istore #4
/*      */     //   416: aload_2
/*      */     //   417: getfield size : I
/*      */     //   420: istore_1
/*      */     //   421: iload #4
/*      */     //   423: iload_1
/*      */     //   424: if_icmpge -> 445
/*      */     //   427: aload_0
/*      */     //   428: aload_2
/*      */     //   429: iload #4
/*      */     //   431: invokevirtual get : (I)Ljava/lang/Object;
/*      */     //   434: aload_3
/*      */     //   435: aconst_null
/*      */     //   436: invokevirtual writeValue : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   439: iinc #4, 1
/*      */     //   442: goto -> 421
/*      */     //   445: aload_0
/*      */     //   446: invokevirtual writeArrayEnd : ()V
/*      */     //   449: return
/*      */     //   450: aload_1
/*      */     //   451: instanceof java/util/Collection
/*      */     //   454: ifeq -> 588
/*      */     //   457: aload_0
/*      */     //   458: getfield typeName : Ljava/lang/String;
/*      */     //   461: ifnull -> 541
/*      */     //   464: aload #4
/*      */     //   466: ldc java/util/ArrayList
/*      */     //   468: if_acmpeq -> 541
/*      */     //   471: aload_2
/*      */     //   472: ifnull -> 481
/*      */     //   475: aload_2
/*      */     //   476: aload #4
/*      */     //   478: if_acmpeq -> 541
/*      */     //   481: aload_0
/*      */     //   482: aload #4
/*      */     //   484: aload_2
/*      */     //   485: invokevirtual writeObjectStart : (Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   488: aload_0
/*      */     //   489: ldc 'items'
/*      */     //   491: invokevirtual writeArrayStart : (Ljava/lang/String;)V
/*      */     //   494: aload_1
/*      */     //   495: checkcast java/util/Collection
/*      */     //   498: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */     //   503: astore_2
/*      */     //   504: aload_2
/*      */     //   505: invokeinterface hasNext : ()Z
/*      */     //   510: ifeq -> 532
/*      */     //   513: aload_2
/*      */     //   514: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   519: astore #4
/*      */     //   521: aload_0
/*      */     //   522: aload #4
/*      */     //   524: aload_3
/*      */     //   525: aconst_null
/*      */     //   526: invokevirtual writeValue : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   529: goto -> 504
/*      */     //   532: aload_0
/*      */     //   533: invokevirtual writeArrayEnd : ()V
/*      */     //   536: aload_0
/*      */     //   537: invokevirtual writeObjectEnd : ()V
/*      */     //   540: return
/*      */     //   541: aload_0
/*      */     //   542: invokevirtual writeArrayStart : ()V
/*      */     //   545: aload_1
/*      */     //   546: checkcast java/util/Collection
/*      */     //   549: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */     //   554: astore_2
/*      */     //   555: aload_2
/*      */     //   556: invokeinterface hasNext : ()Z
/*      */     //   561: ifeq -> 583
/*      */     //   564: aload_2
/*      */     //   565: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   570: astore #4
/*      */     //   572: aload_0
/*      */     //   573: aload #4
/*      */     //   575: aload_3
/*      */     //   576: aconst_null
/*      */     //   577: invokevirtual writeValue : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   580: goto -> 555
/*      */     //   583: aload_0
/*      */     //   584: invokevirtual writeArrayEnd : ()V
/*      */     //   587: return
/*      */     //   588: aload #4
/*      */     //   590: invokevirtual isArray : ()Z
/*      */     //   593: ifeq -> 647
/*      */     //   596: aload_3
/*      */     //   597: ifnonnull -> 606
/*      */     //   600: aload #4
/*      */     //   602: invokevirtual getComponentType : ()Ljava/lang/Class;
/*      */     //   605: astore_3
/*      */     //   606: aload_1
/*      */     //   607: invokestatic getLength : (Ljava/lang/Object;)I
/*      */     //   610: istore_2
/*      */     //   611: aload_0
/*      */     //   612: invokevirtual writeArrayStart : ()V
/*      */     //   615: iconst_0
/*      */     //   616: istore #4
/*      */     //   618: iload #4
/*      */     //   620: iload_2
/*      */     //   621: if_icmpge -> 642
/*      */     //   624: aload_0
/*      */     //   625: aload_1
/*      */     //   626: iload #4
/*      */     //   628: invokestatic get : (Ljava/lang/Object;I)Ljava/lang/Object;
/*      */     //   631: aload_3
/*      */     //   632: aconst_null
/*      */     //   633: invokevirtual writeValue : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   636: iinc #4, 1
/*      */     //   639: goto -> 618
/*      */     //   642: aload_0
/*      */     //   643: invokevirtual writeArrayEnd : ()V
/*      */     //   646: return
/*      */     //   647: aload_1
/*      */     //   648: instanceof com/badlogic/gdx/utils/ObjectMap
/*      */     //   651: ifeq -> 735
/*      */     //   654: aload_2
/*      */     //   655: ifnonnull -> 661
/*      */     //   658: ldc com/badlogic/gdx/utils/ObjectMap
/*      */     //   660: astore_2
/*      */     //   661: aload_0
/*      */     //   662: aload #4
/*      */     //   664: aload_2
/*      */     //   665: invokevirtual writeObjectStart : (Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   668: aload_1
/*      */     //   669: checkcast com/badlogic/gdx/utils/ObjectMap
/*      */     //   672: invokevirtual entries : ()Lcom/badlogic/gdx/utils/ObjectMap$Entries;
/*      */     //   675: invokevirtual iterator : ()Lcom/badlogic/gdx/utils/ObjectMap$Entries;
/*      */     //   678: astore_2
/*      */     //   679: aload_2
/*      */     //   680: invokeinterface hasNext : ()Z
/*      */     //   685: ifeq -> 730
/*      */     //   688: aload_2
/*      */     //   689: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   694: checkcast com/badlogic/gdx/utils/ObjectMap$Entry
/*      */     //   697: astore #4
/*      */     //   699: aload_0
/*      */     //   700: getfield writer : Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   703: aload_0
/*      */     //   704: aload #4
/*      */     //   706: getfield key : Ljava/lang/Object;
/*      */     //   709: invokespecial convertToString : (Ljava/lang/Object;)Ljava/lang/String;
/*      */     //   712: invokevirtual name : (Ljava/lang/String;)Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   715: pop
/*      */     //   716: aload_0
/*      */     //   717: aload #4
/*      */     //   719: getfield value : Ljava/lang/Object;
/*      */     //   722: aload_3
/*      */     //   723: aconst_null
/*      */     //   724: invokevirtual writeValue : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   727: goto -> 679
/*      */     //   730: aload_0
/*      */     //   731: invokevirtual writeObjectEnd : ()V
/*      */     //   734: return
/*      */     //   735: aload_1
/*      */     //   736: instanceof com/badlogic/gdx/utils/ObjectIntMap
/*      */     //   739: ifeq -> 826
/*      */     //   742: aload_2
/*      */     //   743: ifnonnull -> 749
/*      */     //   746: ldc com/badlogic/gdx/utils/ObjectIntMap
/*      */     //   748: astore_2
/*      */     //   749: aload_0
/*      */     //   750: aload #4
/*      */     //   752: aload_2
/*      */     //   753: invokevirtual writeObjectStart : (Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   756: aload_1
/*      */     //   757: checkcast com/badlogic/gdx/utils/ObjectIntMap
/*      */     //   760: invokevirtual entries : ()Lcom/badlogic/gdx/utils/ObjectIntMap$Entries;
/*      */     //   763: invokevirtual iterator : ()Lcom/badlogic/gdx/utils/ObjectIntMap$Entries;
/*      */     //   766: astore_2
/*      */     //   767: aload_2
/*      */     //   768: invokeinterface hasNext : ()Z
/*      */     //   773: ifeq -> 821
/*      */     //   776: aload_2
/*      */     //   777: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   782: checkcast com/badlogic/gdx/utils/ObjectIntMap$Entry
/*      */     //   785: astore #4
/*      */     //   787: aload_0
/*      */     //   788: getfield writer : Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   791: aload_0
/*      */     //   792: aload #4
/*      */     //   794: getfield key : Ljava/lang/Object;
/*      */     //   797: invokespecial convertToString : (Ljava/lang/Object;)Ljava/lang/String;
/*      */     //   800: invokevirtual name : (Ljava/lang/String;)Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   803: pop
/*      */     //   804: aload_0
/*      */     //   805: aload #4
/*      */     //   807: getfield value : I
/*      */     //   810: invokestatic valueOf : (I)Ljava/lang/Integer;
/*      */     //   813: ldc java/lang/Integer
/*      */     //   815: invokevirtual writeValue : (Ljava/lang/Object;Ljava/lang/Class;)V
/*      */     //   818: goto -> 767
/*      */     //   821: aload_0
/*      */     //   822: invokevirtual writeObjectEnd : ()V
/*      */     //   825: return
/*      */     //   826: aload_1
/*      */     //   827: instanceof com/badlogic/gdx/utils/ObjectFloatMap
/*      */     //   830: ifeq -> 917
/*      */     //   833: aload_2
/*      */     //   834: ifnonnull -> 840
/*      */     //   837: ldc com/badlogic/gdx/utils/ObjectFloatMap
/*      */     //   839: astore_2
/*      */     //   840: aload_0
/*      */     //   841: aload #4
/*      */     //   843: aload_2
/*      */     //   844: invokevirtual writeObjectStart : (Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   847: aload_1
/*      */     //   848: checkcast com/badlogic/gdx/utils/ObjectFloatMap
/*      */     //   851: invokevirtual entries : ()Lcom/badlogic/gdx/utils/ObjectFloatMap$Entries;
/*      */     //   854: invokevirtual iterator : ()Lcom/badlogic/gdx/utils/ObjectFloatMap$Entries;
/*      */     //   857: astore_2
/*      */     //   858: aload_2
/*      */     //   859: invokeinterface hasNext : ()Z
/*      */     //   864: ifeq -> 912
/*      */     //   867: aload_2
/*      */     //   868: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   873: checkcast com/badlogic/gdx/utils/ObjectFloatMap$Entry
/*      */     //   876: astore #4
/*      */     //   878: aload_0
/*      */     //   879: getfield writer : Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   882: aload_0
/*      */     //   883: aload #4
/*      */     //   885: getfield key : Ljava/lang/Object;
/*      */     //   888: invokespecial convertToString : (Ljava/lang/Object;)Ljava/lang/String;
/*      */     //   891: invokevirtual name : (Ljava/lang/String;)Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   894: pop
/*      */     //   895: aload_0
/*      */     //   896: aload #4
/*      */     //   898: getfield value : F
/*      */     //   901: invokestatic valueOf : (F)Ljava/lang/Float;
/*      */     //   904: ldc java/lang/Float
/*      */     //   906: invokevirtual writeValue : (Ljava/lang/Object;Ljava/lang/Class;)V
/*      */     //   909: goto -> 858
/*      */     //   912: aload_0
/*      */     //   913: invokevirtual writeObjectEnd : ()V
/*      */     //   916: return
/*      */     //   917: aload_1
/*      */     //   918: instanceof com/badlogic/gdx/utils/ObjectSet
/*      */     //   921: ifeq -> 997
/*      */     //   924: aload_2
/*      */     //   925: ifnonnull -> 931
/*      */     //   928: ldc com/badlogic/gdx/utils/ObjectSet
/*      */     //   930: astore_2
/*      */     //   931: aload_0
/*      */     //   932: aload #4
/*      */     //   934: aload_2
/*      */     //   935: invokevirtual writeObjectStart : (Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   938: aload_0
/*      */     //   939: getfield writer : Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   942: ldc 'values'
/*      */     //   944: invokevirtual name : (Ljava/lang/String;)Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   947: pop
/*      */     //   948: aload_0
/*      */     //   949: invokevirtual writeArrayStart : ()V
/*      */     //   952: aload_1
/*      */     //   953: checkcast com/badlogic/gdx/utils/ObjectSet
/*      */     //   956: invokevirtual iterator : ()Lcom/badlogic/gdx/utils/ObjectSet$ObjectSetIterator;
/*      */     //   959: astore_2
/*      */     //   960: aload_2
/*      */     //   961: invokeinterface hasNext : ()Z
/*      */     //   966: ifeq -> 988
/*      */     //   969: aload_2
/*      */     //   970: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   975: astore #4
/*      */     //   977: aload_0
/*      */     //   978: aload #4
/*      */     //   980: aload_3
/*      */     //   981: aconst_null
/*      */     //   982: invokevirtual writeValue : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   985: goto -> 960
/*      */     //   988: aload_0
/*      */     //   989: invokevirtual writeArrayEnd : ()V
/*      */     //   992: aload_0
/*      */     //   993: invokevirtual writeObjectEnd : ()V
/*      */     //   996: return
/*      */     //   997: aload_1
/*      */     //   998: instanceof com/badlogic/gdx/utils/IntMap
/*      */     //   1001: ifeq -> 1084
/*      */     //   1004: aload_2
/*      */     //   1005: ifnonnull -> 1011
/*      */     //   1008: ldc com/badlogic/gdx/utils/IntMap
/*      */     //   1010: astore_2
/*      */     //   1011: aload_0
/*      */     //   1012: aload #4
/*      */     //   1014: aload_2
/*      */     //   1015: invokevirtual writeObjectStart : (Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   1018: aload_1
/*      */     //   1019: checkcast com/badlogic/gdx/utils/IntMap
/*      */     //   1022: invokevirtual entries : ()Lcom/badlogic/gdx/utils/IntMap$Entries;
/*      */     //   1025: invokevirtual iterator : ()Ljava/util/Iterator;
/*      */     //   1028: astore_2
/*      */     //   1029: aload_2
/*      */     //   1030: invokeinterface hasNext : ()Z
/*      */     //   1035: ifeq -> 1079
/*      */     //   1038: aload_2
/*      */     //   1039: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   1044: checkcast com/badlogic/gdx/utils/IntMap$Entry
/*      */     //   1047: astore #4
/*      */     //   1049: aload_0
/*      */     //   1050: getfield writer : Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   1053: aload #4
/*      */     //   1055: getfield key : I
/*      */     //   1058: invokestatic valueOf : (I)Ljava/lang/String;
/*      */     //   1061: invokevirtual name : (Ljava/lang/String;)Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   1064: pop
/*      */     //   1065: aload_0
/*      */     //   1066: aload #4
/*      */     //   1068: getfield value : Ljava/lang/Object;
/*      */     //   1071: aload_3
/*      */     //   1072: aconst_null
/*      */     //   1073: invokevirtual writeValue : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   1076: goto -> 1029
/*      */     //   1079: aload_0
/*      */     //   1080: invokevirtual writeObjectEnd : ()V
/*      */     //   1083: return
/*      */     //   1084: aload_1
/*      */     //   1085: instanceof com/badlogic/gdx/utils/LongMap
/*      */     //   1088: ifeq -> 1171
/*      */     //   1091: aload_2
/*      */     //   1092: ifnonnull -> 1098
/*      */     //   1095: ldc com/badlogic/gdx/utils/LongMap
/*      */     //   1097: astore_2
/*      */     //   1098: aload_0
/*      */     //   1099: aload #4
/*      */     //   1101: aload_2
/*      */     //   1102: invokevirtual writeObjectStart : (Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   1105: aload_1
/*      */     //   1106: checkcast com/badlogic/gdx/utils/LongMap
/*      */     //   1109: invokevirtual entries : ()Lcom/badlogic/gdx/utils/LongMap$Entries;
/*      */     //   1112: invokevirtual iterator : ()Ljava/util/Iterator;
/*      */     //   1115: astore_2
/*      */     //   1116: aload_2
/*      */     //   1117: invokeinterface hasNext : ()Z
/*      */     //   1122: ifeq -> 1166
/*      */     //   1125: aload_2
/*      */     //   1126: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   1131: checkcast com/badlogic/gdx/utils/LongMap$Entry
/*      */     //   1134: astore #4
/*      */     //   1136: aload_0
/*      */     //   1137: getfield writer : Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   1140: aload #4
/*      */     //   1142: getfield key : J
/*      */     //   1145: invokestatic valueOf : (J)Ljava/lang/String;
/*      */     //   1148: invokevirtual name : (Ljava/lang/String;)Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   1151: pop
/*      */     //   1152: aload_0
/*      */     //   1153: aload #4
/*      */     //   1155: getfield value : Ljava/lang/Object;
/*      */     //   1158: aload_3
/*      */     //   1159: aconst_null
/*      */     //   1160: invokevirtual writeValue : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   1163: goto -> 1116
/*      */     //   1166: aload_0
/*      */     //   1167: invokevirtual writeObjectEnd : ()V
/*      */     //   1170: return
/*      */     //   1171: aload_1
/*      */     //   1172: instanceof com/badlogic/gdx/utils/IntSet
/*      */     //   1175: ifeq -> 1247
/*      */     //   1178: aload_2
/*      */     //   1179: ifnonnull -> 1185
/*      */     //   1182: ldc com/badlogic/gdx/utils/IntSet
/*      */     //   1184: astore_2
/*      */     //   1185: aload_0
/*      */     //   1186: aload #4
/*      */     //   1188: aload_2
/*      */     //   1189: invokevirtual writeObjectStart : (Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   1192: aload_0
/*      */     //   1193: getfield writer : Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   1196: ldc 'values'
/*      */     //   1198: invokevirtual name : (Ljava/lang/String;)Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   1201: pop
/*      */     //   1202: aload_0
/*      */     //   1203: invokevirtual writeArrayStart : ()V
/*      */     //   1206: aload_1
/*      */     //   1207: checkcast com/badlogic/gdx/utils/IntSet
/*      */     //   1210: invokevirtual iterator : ()Lcom/badlogic/gdx/utils/IntSet$IntSetIterator;
/*      */     //   1213: astore_2
/*      */     //   1214: aload_2
/*      */     //   1215: getfield hasNext : Z
/*      */     //   1218: ifeq -> 1238
/*      */     //   1221: aload_0
/*      */     //   1222: aload_2
/*      */     //   1223: invokevirtual next : ()I
/*      */     //   1226: invokestatic valueOf : (I)Ljava/lang/Integer;
/*      */     //   1229: ldc java/lang/Integer
/*      */     //   1231: aconst_null
/*      */     //   1232: invokevirtual writeValue : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   1235: goto -> 1214
/*      */     //   1238: aload_0
/*      */     //   1239: invokevirtual writeArrayEnd : ()V
/*      */     //   1242: aload_0
/*      */     //   1243: invokevirtual writeObjectEnd : ()V
/*      */     //   1246: return
/*      */     //   1247: aload_1
/*      */     //   1248: instanceof com/badlogic/gdx/utils/ArrayMap
/*      */     //   1251: ifeq -> 1330
/*      */     //   1254: aload_2
/*      */     //   1255: ifnonnull -> 1261
/*      */     //   1258: ldc com/badlogic/gdx/utils/ArrayMap
/*      */     //   1260: astore_2
/*      */     //   1261: aload_0
/*      */     //   1262: aload #4
/*      */     //   1264: aload_2
/*      */     //   1265: invokevirtual writeObjectStart : (Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   1268: aload_1
/*      */     //   1269: checkcast com/badlogic/gdx/utils/ArrayMap
/*      */     //   1272: astore_2
/*      */     //   1273: iconst_0
/*      */     //   1274: istore #4
/*      */     //   1276: aload_2
/*      */     //   1277: getfield size : I
/*      */     //   1280: istore_1
/*      */     //   1281: iload #4
/*      */     //   1283: iload_1
/*      */     //   1284: if_icmpge -> 1325
/*      */     //   1287: aload_0
/*      */     //   1288: getfield writer : Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   1291: aload_0
/*      */     //   1292: aload_2
/*      */     //   1293: getfield keys : [Ljava/lang/Object;
/*      */     //   1296: iload #4
/*      */     //   1298: aaload
/*      */     //   1299: invokespecial convertToString : (Ljava/lang/Object;)Ljava/lang/String;
/*      */     //   1302: invokevirtual name : (Ljava/lang/String;)Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   1305: pop
/*      */     //   1306: aload_0
/*      */     //   1307: aload_2
/*      */     //   1308: getfield values : [Ljava/lang/Object;
/*      */     //   1311: iload #4
/*      */     //   1313: aaload
/*      */     //   1314: aload_3
/*      */     //   1315: aconst_null
/*      */     //   1316: invokevirtual writeValue : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   1319: iinc #4, 1
/*      */     //   1322: goto -> 1281
/*      */     //   1325: aload_0
/*      */     //   1326: invokevirtual writeObjectEnd : ()V
/*      */     //   1329: return
/*      */     //   1330: aload_1
/*      */     //   1331: instanceof java/util/Map
/*      */     //   1334: ifeq -> 1426
/*      */     //   1337: aload_2
/*      */     //   1338: ifnonnull -> 1344
/*      */     //   1341: ldc java/util/HashMap
/*      */     //   1343: astore_2
/*      */     //   1344: aload_0
/*      */     //   1345: aload #4
/*      */     //   1347: aload_2
/*      */     //   1348: invokevirtual writeObjectStart : (Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   1351: aload_1
/*      */     //   1352: checkcast java/util/Map
/*      */     //   1355: invokeinterface entrySet : ()Ljava/util/Set;
/*      */     //   1360: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */     //   1365: astore_2
/*      */     //   1366: aload_2
/*      */     //   1367: invokeinterface hasNext : ()Z
/*      */     //   1372: ifeq -> 1421
/*      */     //   1375: aload_2
/*      */     //   1376: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   1381: checkcast java/util/Map$Entry
/*      */     //   1384: astore #4
/*      */     //   1386: aload_0
/*      */     //   1387: getfield writer : Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   1390: aload_0
/*      */     //   1391: aload #4
/*      */     //   1393: invokeinterface getKey : ()Ljava/lang/Object;
/*      */     //   1398: invokespecial convertToString : (Ljava/lang/Object;)Ljava/lang/String;
/*      */     //   1401: invokevirtual name : (Ljava/lang/String;)Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   1404: pop
/*      */     //   1405: aload_0
/*      */     //   1406: aload #4
/*      */     //   1408: invokeinterface getValue : ()Ljava/lang/Object;
/*      */     //   1413: aload_3
/*      */     //   1414: aconst_null
/*      */     //   1415: invokevirtual writeValue : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   1418: goto -> 1366
/*      */     //   1421: aload_0
/*      */     //   1422: invokevirtual writeObjectEnd : ()V
/*      */     //   1425: return
/*      */     //   1426: ldc java/lang/Enum
/*      */     //   1428: aload #4
/*      */     //   1430: invokestatic isAssignableFrom : (Ljava/lang/Class;Ljava/lang/Class;)Z
/*      */     //   1433: ifeq -> 1523
/*      */     //   1436: aload #4
/*      */     //   1438: invokevirtual getEnumConstants : ()[Ljava/lang/Object;
/*      */     //   1441: ifnonnull -> 1451
/*      */     //   1444: aload #4
/*      */     //   1446: invokevirtual getSuperclass : ()Ljava/lang/Class;
/*      */     //   1449: astore #4
/*      */     //   1451: aload_0
/*      */     //   1452: getfield typeName : Ljava/lang/String;
/*      */     //   1455: ifnull -> 1506
/*      */     //   1458: aload_2
/*      */     //   1459: ifnull -> 1468
/*      */     //   1462: aload_2
/*      */     //   1463: aload #4
/*      */     //   1465: if_acmpeq -> 1506
/*      */     //   1468: aload_0
/*      */     //   1469: aload #4
/*      */     //   1471: aconst_null
/*      */     //   1472: invokevirtual writeObjectStart : (Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   1475: aload_0
/*      */     //   1476: getfield writer : Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   1479: ldc 'value'
/*      */     //   1481: invokevirtual name : (Ljava/lang/String;)Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   1484: pop
/*      */     //   1485: aload_0
/*      */     //   1486: getfield writer : Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   1489: aload_0
/*      */     //   1490: aload_1
/*      */     //   1491: checkcast java/lang/Enum
/*      */     //   1494: invokespecial convertToString : (Ljava/lang/Enum;)Ljava/lang/String;
/*      */     //   1497: invokevirtual value : (Ljava/lang/Object;)Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   1500: pop
/*      */     //   1501: aload_0
/*      */     //   1502: invokevirtual writeObjectEnd : ()V
/*      */     //   1505: return
/*      */     //   1506: aload_0
/*      */     //   1507: getfield writer : Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   1510: aload_0
/*      */     //   1511: aload_1
/*      */     //   1512: checkcast java/lang/Enum
/*      */     //   1515: invokespecial convertToString : (Ljava/lang/Enum;)Ljava/lang/String;
/*      */     //   1518: invokevirtual value : (Ljava/lang/Object;)Lcom/badlogic/gdx/utils/JsonWriter;
/*      */     //   1521: pop
/*      */     //   1522: return
/*      */     //   1523: aload_0
/*      */     //   1524: aload #4
/*      */     //   1526: aload_2
/*      */     //   1527: invokevirtual writeObjectStart : (Ljava/lang/Class;Ljava/lang/Class;)V
/*      */     //   1530: aload_0
/*      */     //   1531: aload_1
/*      */     //   1532: invokevirtual writeFields : (Ljava/lang/Object;)V
/*      */     //   1535: aload_0
/*      */     //   1536: invokevirtual writeObjectEnd : ()V
/*      */     //   1539: return
/*      */     //   1540: astore #4
/*      */     //   1542: new com/badlogic/gdx/utils/SerializationException
/*      */     //   1545: dup
/*      */     //   1546: aload #4
/*      */     //   1548: invokespecial <init> : (Ljava/lang/Throwable;)V
/*      */     //   1551: athrow
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #484	-> 0
/*      */     //   #485	-> 4
/*      */     //   #486	-> 13
/*      */     //   #489	-> 14
/*      */     //   #492	-> 79
/*      */     //   #493	-> 88
/*      */     //   #496	-> 89
/*      */     //   #498	-> 94
/*      */     //   #501	-> 165
/*      */     //   #502	-> 172
/*      */     //   #503	-> 179
/*      */     //   #504	-> 183
/*      */     //   #507	-> 184
/*      */     //   #508	-> 191
/*      */     //   #509	-> 198
/*      */     //   #510	-> 208
/*      */     //   #511	-> 212
/*      */     //   #514	-> 213
/*      */     //   #515	-> 226
/*      */     //   #516	-> 231
/*      */     //   #517	-> 241
/*      */     //   #521	-> 242
/*      */     //   #522	-> 249
/*      */     //   #523	-> 266
/*      */     //   #525	-> 300
/*      */     //   #526	-> 304
/*      */     //   #527	-> 309
/*      */     //   #528	-> 323
/*      */     //   #527	-> 335
/*      */     //   #529	-> 341
/*      */     //   #530	-> 345
/*      */     //   #532	-> 346
/*      */     //   #533	-> 353
/*      */     //   #534	-> 370
/*      */     //   #536	-> 404
/*      */     //   #537	-> 408
/*      */     //   #538	-> 413
/*      */     //   #539	-> 427
/*      */     //   #538	-> 439
/*      */     //   #540	-> 445
/*      */     //   #541	-> 449
/*      */     //   #543	-> 450
/*      */     //   #544	-> 457
/*      */     //   #545	-> 481
/*      */     //   #546	-> 488
/*      */     //   #547	-> 494
/*      */     //   #548	-> 521
/*      */     //   #549	-> 532
/*      */     //   #550	-> 536
/*      */     //   #552	-> 541
/*      */     //   #553	-> 545
/*      */     //   #554	-> 572
/*      */     //   #555	-> 583
/*      */     //   #557	-> 587
/*      */     //   #559	-> 588
/*      */     //   #560	-> 596
/*      */     //   #561	-> 606
/*      */     //   #562	-> 611
/*      */     //   #563	-> 615
/*      */     //   #564	-> 624
/*      */     //   #563	-> 636
/*      */     //   #565	-> 642
/*      */     //   #566	-> 646
/*      */     //   #570	-> 647
/*      */     //   #571	-> 654
/*      */     //   #572	-> 661
/*      */     //   #573	-> 668
/*      */     //   #574	-> 699
/*      */     //   #575	-> 716
/*      */     //   #576	-> 727
/*      */     //   #577	-> 730
/*      */     //   #578	-> 734
/*      */     //   #580	-> 735
/*      */     //   #581	-> 742
/*      */     //   #582	-> 749
/*      */     //   #583	-> 756
/*      */     //   #584	-> 787
/*      */     //   #585	-> 804
/*      */     //   #586	-> 818
/*      */     //   #587	-> 821
/*      */     //   #588	-> 825
/*      */     //   #590	-> 826
/*      */     //   #591	-> 833
/*      */     //   #592	-> 840
/*      */     //   #593	-> 847
/*      */     //   #594	-> 878
/*      */     //   #595	-> 895
/*      */     //   #596	-> 909
/*      */     //   #597	-> 912
/*      */     //   #598	-> 916
/*      */     //   #600	-> 917
/*      */     //   #601	-> 924
/*      */     //   #602	-> 931
/*      */     //   #603	-> 938
/*      */     //   #604	-> 948
/*      */     //   #605	-> 952
/*      */     //   #606	-> 977
/*      */     //   #607	-> 988
/*      */     //   #608	-> 992
/*      */     //   #609	-> 996
/*      */     //   #611	-> 997
/*      */     //   #612	-> 1004
/*      */     //   #613	-> 1011
/*      */     //   #614	-> 1018
/*      */     //   #615	-> 1049
/*      */     //   #616	-> 1065
/*      */     //   #617	-> 1076
/*      */     //   #618	-> 1079
/*      */     //   #619	-> 1083
/*      */     //   #621	-> 1084
/*      */     //   #622	-> 1091
/*      */     //   #623	-> 1098
/*      */     //   #624	-> 1105
/*      */     //   #625	-> 1136
/*      */     //   #626	-> 1152
/*      */     //   #627	-> 1163
/*      */     //   #628	-> 1166
/*      */     //   #629	-> 1170
/*      */     //   #631	-> 1171
/*      */     //   #632	-> 1178
/*      */     //   #633	-> 1185
/*      */     //   #634	-> 1192
/*      */     //   #635	-> 1202
/*      */     //   #636	-> 1206
/*      */     //   #637	-> 1221
/*      */     //   #638	-> 1238
/*      */     //   #639	-> 1242
/*      */     //   #640	-> 1246
/*      */     //   #642	-> 1247
/*      */     //   #643	-> 1254
/*      */     //   #644	-> 1261
/*      */     //   #645	-> 1268
/*      */     //   #646	-> 1273
/*      */     //   #647	-> 1287
/*      */     //   #648	-> 1306
/*      */     //   #646	-> 1319
/*      */     //   #650	-> 1325
/*      */     //   #651	-> 1329
/*      */     //   #653	-> 1330
/*      */     //   #654	-> 1337
/*      */     //   #655	-> 1344
/*      */     //   #656	-> 1351
/*      */     //   #657	-> 1386
/*      */     //   #658	-> 1405
/*      */     //   #659	-> 1418
/*      */     //   #660	-> 1421
/*      */     //   #661	-> 1425
/*      */     //   #665	-> 1426
/*      */     //   #666	-> 1436
/*      */     //   #667	-> 1444
/*      */     //   #668	-> 1451
/*      */     //   #669	-> 1468
/*      */     //   #670	-> 1475
/*      */     //   #671	-> 1485
/*      */     //   #672	-> 1501
/*      */     //   #674	-> 1506
/*      */     //   #676	-> 1522
/*      */     //   #679	-> 1523
/*      */     //   #680	-> 1530
/*      */     //   #681	-> 1535
/*      */     //   #684	-> 1539
/*      */     //   #682	-> 1540
/*      */     //   #683	-> 1542
/*      */     // Exception table:
/*      */     //   from	to	target	type
/*      */     //   0	13	1540	java/io/IOException
/*      */     //   14	88	1540	java/io/IOException
/*      */     //   89	183	1540	java/io/IOException
/*      */     //   184	212	1540	java/io/IOException
/*      */     //   213	241	1540	java/io/IOException
/*      */     //   242	345	1540	java/io/IOException
/*      */     //   346	449	1540	java/io/IOException
/*      */     //   450	587	1540	java/io/IOException
/*      */     //   588	646	1540	java/io/IOException
/*      */     //   647	734	1540	java/io/IOException
/*      */     //   735	825	1540	java/io/IOException
/*      */     //   826	916	1540	java/io/IOException
/*      */     //   917	996	1540	java/io/IOException
/*      */     //   997	1083	1540	java/io/IOException
/*      */     //   1084	1170	1540	java/io/IOException
/*      */     //   1171	1246	1540	java/io/IOException
/*      */     //   1247	1329	1540	java/io/IOException
/*      */     //   1330	1425	1540	java/io/IOException
/*      */     //   1426	1522	1540	java/io/IOException
/*      */     //   1523	1539	1540	java/io/IOException
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeObjectStart(String paramString) {
/*      */     try {
/*  689 */       this.writer.name(paramString);
/*  690 */     } catch (IOException iOException) {
/*  691 */       throw new SerializationException(iOException);
/*      */     } 
/*  693 */     writeObjectStart();
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeObjectStart(String paramString, Class paramClass1, @Null Class paramClass2) {
/*      */     try {
/*  699 */       this.writer.name(paramString);
/*  700 */     } catch (IOException iOException) {
/*  701 */       throw new SerializationException(iOException);
/*      */     } 
/*  703 */     writeObjectStart(paramClass1, paramClass2);
/*      */   }
/*      */   
/*      */   public void writeObjectStart() {
/*      */     try {
/*  708 */       this.writer.object(); return;
/*  709 */     } catch (IOException iOException) {
/*  710 */       throw new SerializationException(iOException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeObjectStart(Class paramClass1, @Null Class paramClass2) {
/*      */     try {
/*  718 */       this.writer.object();
/*  719 */     } catch (IOException iOException) {
/*  720 */       throw new SerializationException(iOException);
/*      */     } 
/*  722 */     if (paramClass2 == null || paramClass2 != iOException) writeType((Class)iOException); 
/*      */   }
/*      */   
/*      */   public void writeObjectEnd() {
/*      */     try {
/*  727 */       this.writer.pop(); return;
/*  728 */     } catch (IOException iOException) {
/*  729 */       throw new SerializationException(iOException);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void writeArrayStart(String paramString) {
/*      */     try {
/*  735 */       this.writer.name(paramString);
/*  736 */       this.writer.array(); return;
/*  737 */     } catch (IOException iOException) {
/*  738 */       throw new SerializationException(iOException);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void writeArrayStart() {
/*      */     try {
/*  744 */       this.writer.array(); return;
/*  745 */     } catch (IOException iOException) {
/*  746 */       throw new SerializationException(iOException);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void writeArrayEnd() {
/*      */     try {
/*  752 */       this.writer.pop(); return;
/*  753 */     } catch (IOException iOException) {
/*  754 */       throw new SerializationException(iOException);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void writeType(Class paramClass) {
/*  759 */     if (this.typeName == null)
/*      */       return;  String str;
/*  761 */     if ((str = getTag(paramClass)) == null) str = paramClass.getName(); 
/*      */     try {
/*  763 */       this.writer.set(this.typeName, str); return;
/*  764 */     } catch (IOException iOException) {
/*  765 */       throw new SerializationException(iOException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public <T> T fromJson(Class<T> paramClass, Reader paramReader) {
/*  773 */     return readValue(paramClass, (Class)null, (new JsonReader()).parse(paramReader));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public <T> T fromJson(Class<T> paramClass, Class paramClass1, Reader paramReader) {
/*  780 */     return readValue(paramClass, paramClass1, (new JsonReader()).parse(paramReader));
/*      */   }
/*      */ 
/*      */   
/*      */   @Null
/*      */   public <T> T fromJson(Class<T> paramClass, InputStream paramInputStream) {
/*  786 */     return readValue(paramClass, (Class)null, (new JsonReader()).parse(paramInputStream));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public <T> T fromJson(Class<T> paramClass, Class paramClass1, InputStream paramInputStream) {
/*  793 */     return readValue(paramClass, paramClass1, (new JsonReader()).parse(paramInputStream));
/*      */   }
/*      */ 
/*      */   
/*      */   @Null
/*      */   public <T> T fromJson(Class<T> paramClass, FileHandle paramFileHandle) {
/*      */     try {
/*  800 */       return readValue(paramClass, (Class)null, (new JsonReader()).parse(paramFileHandle));
/*  801 */     } catch (Exception exception) {
/*  802 */       throw new SerializationException("Error reading file: " + paramFileHandle, exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public <T> T fromJson(Class<T> paramClass, Class paramClass1, FileHandle paramFileHandle) {
/*      */     try {
/*  811 */       return readValue(paramClass, paramClass1, (new JsonReader()).parse(paramFileHandle));
/*  812 */     } catch (Exception exception) {
/*  813 */       throw new SerializationException("Error reading file: " + paramFileHandle, exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @Null
/*      */   public <T> T fromJson(Class<T> paramClass, char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  820 */     return readValue(paramClass, (Class)null, (new JsonReader()).parse(paramArrayOfchar, paramInt1, paramInt2));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public <T> T fromJson(Class<T> paramClass, Class paramClass1, char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  827 */     return readValue(paramClass, paramClass1, (new JsonReader()).parse(paramArrayOfchar, paramInt1, paramInt2));
/*      */   }
/*      */ 
/*      */   
/*      */   @Null
/*      */   public <T> T fromJson(Class<T> paramClass, String paramString) {
/*  833 */     return readValue(paramClass, (Class)null, (new JsonReader()).parse(paramString));
/*      */   }
/*      */ 
/*      */   
/*      */   @Null
/*      */   public <T> T fromJson(Class<T> paramClass, Class paramClass1, String paramString) {
/*  839 */     return readValue(paramClass, paramClass1, (new JsonReader()).parse(paramString));
/*      */   }
/*      */   
/*      */   public void readField(Object paramObject, String paramString, JsonValue paramJsonValue) {
/*  843 */     readField(paramObject, paramString, paramString, (Class)null, paramJsonValue);
/*      */   }
/*      */   
/*      */   public void readField(Object paramObject, String paramString, @Null Class paramClass, JsonValue paramJsonValue) {
/*  847 */     readField(paramObject, paramString, paramString, paramClass, paramJsonValue);
/*      */   }
/*      */   
/*      */   public void readField(Object paramObject, String paramString1, String paramString2, JsonValue paramJsonValue) {
/*  851 */     readField(paramObject, paramString1, paramString2, (Class)null, paramJsonValue);
/*      */   }
/*      */ 
/*      */   
/*      */   public void readField(Object paramObject, String paramString1, String paramString2, @Null Class paramClass, JsonValue paramJsonValue) {
/*  856 */     Class<?> clazz = paramObject.getClass();
/*      */     FieldMetadata fieldMetadata;
/*  858 */     if ((fieldMetadata = getFields(clazz).get(paramString1)) == null) throw new SerializationException("Field not found: " + paramString1 + " (" + clazz.getName() + ")"); 
/*  859 */     Field field = fieldMetadata.field;
/*  860 */     if (paramClass == null) paramClass = fieldMetadata.elementType; 
/*  861 */     readField(paramObject, field, paramString2, paramClass, paramJsonValue);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void readField(@Null Object paramObject, Field paramField, String paramString, @Null Class paramClass, JsonValue paramJsonValue) {
/*      */     JsonValue jsonValue;
/*  868 */     if ((jsonValue = paramJsonValue.get(paramString)) == null)
/*      */       return;  try {
/*  870 */       paramField.set(paramObject, readValue(paramField.getType(), paramClass, jsonValue)); return;
/*  871 */     } catch (ReflectionException reflectionException) {
/*  872 */       throw new SerializationException("Error accessing field: " + paramField
/*  873 */           .getName() + " (" + paramField.getDeclaringClass().getName() + ")", reflectionException);
/*  874 */     } catch (SerializationException serializationException) {
/*  875 */       (paramObject = null).addTrace(paramField.getName() + " (" + paramField.getDeclaringClass().getName() + ")");
/*  876 */       throw paramObject;
/*  877 */     } catch (RuntimeException runtimeException) {
/*      */       
/*  879 */       (runtimeException = new SerializationException(runtimeException)).addTrace(jsonValue.trace());
/*  880 */       runtimeException.addTrace(paramField.getName() + " (" + paramField.getDeclaringClass().getName() + ")");
/*  881 */       throw runtimeException;
/*      */     } 
/*      */   }
/*      */   
/*      */   public void readFields(Object paramObject, JsonValue paramJsonValue) {
/*  886 */     Class<?> clazz = paramObject.getClass();
/*  887 */     OrderedMap<String, FieldMetadata> orderedMap = getFields(clazz);
/*  888 */     for (paramJsonValue = paramJsonValue.child; paramJsonValue != null; paramJsonValue = paramJsonValue.next) {
/*      */       FieldMetadata fieldMetadata;
/*  890 */       if ((fieldMetadata = orderedMap.get(paramJsonValue.name().replace(" ", "_"))) == null) {
/*  891 */         if (!paramJsonValue.name.equals(this.typeName) && 
/*  892 */           !this.ignoreUnknownFields && !ignoreUnknownField(clazz, paramJsonValue.name)) {
/*      */           SerializationException serializationException;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  898 */           (serializationException = new SerializationException("Field not found: " + paramJsonValue.name + " (" + clazz.getName() + ")")).addTrace(paramJsonValue.trace());
/*  899 */           throw serializationException;
/*      */         }
/*      */       
/*  902 */       } else if (!this.ignoreDeprecated || this.readDeprecated || !fieldMetadata.deprecated) {
/*      */         
/*  904 */         Field field = fieldMetadata.field;
/*      */         try {
/*  906 */           field.set(paramObject, readValue(field.getType(), fieldMetadata.elementType, paramJsonValue));
/*  907 */         } catch (ReflectionException reflectionException) {
/*  908 */           throw new SerializationException("Error accessing field: " + field.getName() + " (" + clazz.getName() + ")", reflectionException);
/*  909 */         } catch (SerializationException serializationException) {
/*  910 */           (paramObject = null).addTrace(field.getName() + " (" + clazz.getName() + ")");
/*  911 */           throw paramObject;
/*  912 */         } catch (RuntimeException runtimeException) {
/*      */           
/*  914 */           (runtimeException = new SerializationException(runtimeException)).addTrace(paramJsonValue.trace());
/*  915 */           runtimeException.addTrace(field.getName() + " (" + clazz.getName() + ")");
/*  916 */           throw runtimeException;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean ignoreUnknownField(Class paramClass, String paramString) {
/*  928 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   @Null
/*      */   public <T> T readValue(String paramString, @Null Class<T> paramClass, JsonValue paramJsonValue) {
/*  934 */     return readValue(paramClass, (Class)null, paramJsonValue.get(paramString));
/*      */   }
/*      */ 
/*      */   
/*      */   @Null
/*      */   public <T> T readValue(String paramString, @Null Class<T> paramClass, T paramT, JsonValue paramJsonValue) {
/*      */     JsonValue jsonValue;
/*  941 */     if ((jsonValue = paramJsonValue.get(paramString)) == null) return paramT; 
/*  942 */     return readValue(paramClass, (Class)null, jsonValue);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public <T> T readValue(String paramString, @Null Class<T> paramClass, @Null Class paramClass1, JsonValue paramJsonValue) {
/*  949 */     return readValue(paramClass, paramClass1, paramJsonValue.get(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public <T> T readValue(String paramString, @Null Class<T> paramClass, @Null Class paramClass1, T paramT, JsonValue paramJsonValue) {
/*  956 */     JsonValue jsonValue = paramJsonValue.get(paramString);
/*  957 */     return readValue(paramClass, paramClass1, paramT, jsonValue);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public <T> T readValue(@Null Class<T> paramClass, @Null Class paramClass1, T paramT, JsonValue paramJsonValue) {
/*  964 */     if (paramJsonValue == null) return paramT; 
/*  965 */     return readValue(paramClass, paramClass1, paramJsonValue);
/*      */   }
/*      */ 
/*      */   
/*      */   @Null
/*      */   public <T> T readValue(@Null Class<T> paramClass, JsonValue paramJsonValue) {
/*  971 */     return readValue(paramClass, (Class)null, paramJsonValue);
/*      */   }
/*      */ 
/*      */   
/*      */   @Null
/*      */   public <T> T readValue(@Null Class<T> paramClass, @Null Class<?> paramClass1, JsonValue paramJsonValue) {
/*      */     Class<Array> clazz;
/*  978 */     if (paramJsonValue == null) return null;
/*      */     
/*  980 */     if (paramJsonValue.isObject()) {
/*      */       String str;
/*  982 */       if ((str = (String)((this.typeName == null) ? null : paramJsonValue.getString(this.typeName, null))) != null && (
/*      */         
/*  984 */         paramClass = getClass(str)) == null) {
/*      */         try {
/*  986 */           paramClass = ClassReflection.forName(str);
/*  987 */         } catch (ReflectionException reflectionException) {
/*  988 */           throw new SerializationException(reflectionException);
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*  993 */       if (paramClass == null) {
/*  994 */         if (this.defaultSerializer != null) return this.defaultSerializer.read(this, paramJsonValue, paramClass); 
/*  995 */         return (T)paramJsonValue;
/*      */       } 
/*      */       
/*  998 */       if (this.typeName != null && ClassReflection.isAssignableFrom(Collection.class, paramClass)) {
/*      */ 
/*      */         
/* 1001 */         if ((paramJsonValue = paramJsonValue.get("items")) == null) throw new SerializationException("Unable to convert object to collection: " + paramJsonValue + " (" + paramClass
/* 1002 */               .getName() + ")"); 
/*      */       } else {
/*      */         Serializer<T> serializer;
/* 1005 */         if ((serializer = this.classToSerializer.<Class>get((Class)paramClass)) != null) return serializer.read(this, paramJsonValue, paramClass);
/*      */         
/* 1007 */         if (paramClass == String.class || paramClass == Integer.class || paramClass == Boolean.class || paramClass == Float.class || paramClass == Long.class || paramClass == Double.class || paramClass == Short.class || paramClass == Byte.class || paramClass == Character.class || 
/*      */           
/* 1009 */           ClassReflection.isAssignableFrom(Enum.class, paramClass)) {
/* 1010 */           return readValue("value", paramClass, paramJsonValue);
/*      */         }
/*      */         
/*      */         Object object;
/*      */         
/* 1015 */         if (object = newInstance(paramClass) instanceof Serializable) {
/* 1016 */           ((Serializable)object).read(this, paramJsonValue);
/* 1017 */           return (T)object;
/*      */         } 
/*      */ 
/*      */         
/* 1021 */         if (object instanceof ObjectMap) {
/* 1022 */           ObjectMap objectMap = (ObjectMap)object;
/* 1023 */           for (JsonValue jsonValue = paramJsonValue.child; jsonValue != null; jsonValue = jsonValue.next)
/* 1024 */             objectMap.put(jsonValue.name, readValue(paramClass1, (Class)null, jsonValue)); 
/* 1025 */           return (T)objectMap;
/*      */         } 
/* 1027 */         if (object instanceof ObjectIntMap) {
/* 1028 */           ObjectIntMap<String> objectIntMap = (ObjectIntMap)object;
/* 1029 */           for (JsonValue jsonValue = paramJsonValue.child; jsonValue != null; jsonValue = jsonValue.next)
/* 1030 */             objectIntMap.put(jsonValue.name, ((Integer)readValue(Integer.class, (Class)null, jsonValue)).intValue()); 
/* 1031 */           return (T)objectIntMap;
/*      */         } 
/* 1033 */         if (object instanceof ObjectFloatMap) {
/* 1034 */           ObjectFloatMap<String> objectFloatMap = (ObjectFloatMap)object;
/* 1035 */           for (JsonValue jsonValue = paramJsonValue.child; jsonValue != null; jsonValue = jsonValue.next)
/* 1036 */             objectFloatMap.put(jsonValue.name, ((Float)readValue(Float.class, (Class)null, jsonValue)).floatValue()); 
/* 1037 */           return (T)objectFloatMap;
/*      */         } 
/* 1039 */         if (object instanceof ObjectSet) {
/* 1040 */           ObjectSet objectSet = (ObjectSet)object;
/* 1041 */           for (JsonValue jsonValue = paramJsonValue.getChild("values"); jsonValue != null; jsonValue = jsonValue.next)
/* 1042 */             objectSet.add(readValue(paramClass1, (Class)null, jsonValue)); 
/* 1043 */           return (T)objectSet;
/*      */         } 
/* 1045 */         if (object instanceof IntMap) {
/* 1046 */           IntMap intMap = (IntMap)object;
/* 1047 */           for (JsonValue jsonValue = paramJsonValue.child; jsonValue != null; jsonValue = jsonValue.next)
/* 1048 */             intMap.put(Integer.parseInt(jsonValue.name), readValue(paramClass1, (Class)null, jsonValue)); 
/* 1049 */           return (T)intMap;
/*      */         } 
/* 1051 */         if (object instanceof LongMap) {
/* 1052 */           LongMap longMap = (LongMap)object;
/* 1053 */           for (JsonValue jsonValue = paramJsonValue.child; jsonValue != null; jsonValue = jsonValue.next)
/* 1054 */             longMap.put(Long.parseLong(jsonValue.name), readValue(paramClass1, (Class)null, jsonValue)); 
/* 1055 */           return (T)longMap;
/*      */         } 
/* 1057 */         if (object instanceof IntSet) {
/* 1058 */           IntSet intSet = (IntSet)object;
/* 1059 */           for (JsonValue jsonValue = paramJsonValue.getChild("values"); jsonValue != null; jsonValue = jsonValue.next)
/* 1060 */             intSet.add(jsonValue.asInt()); 
/* 1061 */           return (T)intSet;
/*      */         } 
/* 1063 */         if (object instanceof ArrayMap) {
/* 1064 */           ArrayMap arrayMap = (ArrayMap)object;
/* 1065 */           for (JsonValue jsonValue = paramJsonValue.child; jsonValue != null; jsonValue = jsonValue.next)
/* 1066 */             arrayMap.put(jsonValue.name, readValue(paramClass1, (Class)null, jsonValue)); 
/* 1067 */           return (T)arrayMap;
/*      */         } 
/* 1069 */         if (object instanceof Map) {
/* 1070 */           Map map = (Map)object;
/* 1071 */           for (JsonValue jsonValue = paramJsonValue.child; jsonValue != null; jsonValue = jsonValue.next) {
/* 1072 */             if (!jsonValue.name.equals(this.typeName))
/* 1073 */               map.put(jsonValue.name, readValue(paramClass1, (Class)null, jsonValue)); 
/*      */           } 
/* 1075 */           return (T)map;
/*      */         } 
/*      */         
/* 1078 */         readFields(object, paramJsonValue);
/* 1079 */         return (T)object;
/*      */       } 
/*      */     } 
/*      */     
/* 1083 */     if (paramClass != null) {
/*      */       Serializer<T> serializer;
/* 1085 */       if ((serializer = this.classToSerializer.<Class>get((Class)paramClass)) != null) return serializer.read(this, paramJsonValue, paramClass);
/*      */       
/* 1087 */       if (ClassReflection.isAssignableFrom(Serializable.class, paramClass)) {
/*      */         Object object;
/*      */         
/* 1090 */         ((Serializable)(object = newInstance(paramClass))).read(this, paramJsonValue);
/* 1091 */         return (T)object;
/*      */       } 
/*      */     } 
/*      */     
/* 1095 */     if (paramJsonValue.isArray()) {
/*      */       
/* 1097 */       if (paramClass == null || paramClass == Object.class) clazz = Array.class; 
/* 1098 */       if (ClassReflection.isAssignableFrom(Array.class, clazz)) {
/* 1099 */         Array array = (clazz == Array.class) ? new Array() : (Array)newInstance(clazz);
/* 1100 */         for (JsonValue jsonValue = paramJsonValue.child; jsonValue != null; jsonValue = jsonValue.next)
/* 1101 */           array.add(readValue(paramClass1, (Class)null, jsonValue)); 
/* 1102 */         return (T)array;
/*      */       } 
/* 1104 */       if (ClassReflection.isAssignableFrom(Queue.class, clazz)) {
/* 1105 */         Queue queue = (clazz == Queue.class) ? new Queue() : (Queue)newInstance(clazz);
/* 1106 */         for (JsonValue jsonValue = paramJsonValue.child; jsonValue != null; jsonValue = jsonValue.next)
/* 1107 */           queue.addLast(readValue(paramClass1, (Class)null, jsonValue)); 
/* 1108 */         return (T)queue;
/*      */       } 
/* 1110 */       if (ClassReflection.isAssignableFrom(Collection.class, clazz)) {
/* 1111 */         Collection collection = clazz.isInterface() ? new ArrayList() : (Collection)newInstance(clazz);
/* 1112 */         for (JsonValue jsonValue = paramJsonValue.child; jsonValue != null; jsonValue = jsonValue.next)
/* 1113 */           collection.add(readValue(paramClass1, (Class)null, jsonValue)); 
/* 1114 */         return (T)collection;
/*      */       } 
/* 1116 */       if (clazz.isArray()) {
/* 1117 */         Class<?> clazz1 = clazz.getComponentType();
/* 1118 */         if (paramClass1 == null) paramClass1 = clazz1; 
/* 1119 */         Object object = ArrayReflection.newInstance(clazz1, paramJsonValue.size);
/* 1120 */         byte b = 0;
/* 1121 */         for (JsonValue jsonValue = paramJsonValue.child; jsonValue != null; jsonValue = jsonValue.next)
/* 1122 */           ArrayReflection.set(object, b++, readValue(paramClass1, (Class)null, jsonValue)); 
/* 1123 */         return (T)object;
/*      */       } 
/* 1125 */       throw new SerializationException("Unable to convert value to required type: " + paramJsonValue + " (" + clazz.getName() + ")");
/*      */     } 
/*      */     
/* 1128 */     if (paramJsonValue.isNumber()) {
/*      */       try {
/* 1130 */         if (clazz == null || clazz == float.class || clazz == Float.class) return (T)Float.valueOf(paramJsonValue.asFloat()); 
/* 1131 */         if (clazz == int.class || clazz == Integer.class) return (T)Integer.valueOf(paramJsonValue.asInt()); 
/* 1132 */         if (clazz == long.class || clazz == Long.class) return (T)Long.valueOf(paramJsonValue.asLong()); 
/* 1133 */         if (clazz == double.class || clazz == Double.class) return (T)Double.valueOf(paramJsonValue.asDouble()); 
/* 1134 */         if (clazz == String.class) return (T)paramJsonValue.asString(); 
/* 1135 */         if (clazz == short.class || clazz == Short.class) return (T)Short.valueOf(paramJsonValue.asShort()); 
/* 1136 */         if (clazz == byte.class || clazz == Byte.class) return (T)Byte.valueOf(paramJsonValue.asByte()); 
/* 1137 */       } catch (NumberFormatException numberFormatException) {}
/*      */       
/* 1139 */       paramJsonValue = new JsonValue(paramJsonValue.asString());
/*      */     } 
/*      */     
/* 1142 */     if (paramJsonValue.isBoolean()) {
/*      */       try {
/* 1144 */         if (clazz == null || clazz == boolean.class || clazz == Boolean.class) return (T)Boolean.valueOf(paramJsonValue.asBoolean()); 
/* 1145 */       } catch (NumberFormatException numberFormatException) {}
/*      */       
/* 1147 */       paramJsonValue = new JsonValue(paramJsonValue.asString());
/*      */     } 
/*      */     
/* 1150 */     if (paramJsonValue.isString()) {
/* 1151 */       String str = paramJsonValue.asString();
/* 1152 */       if (clazz == null || clazz == String.class) return (T)str; 
/*      */       try {
/* 1154 */         if (clazz == int.class || clazz == Integer.class) return (T)Integer.valueOf(str); 
/* 1155 */         if (clazz == float.class || clazz == Float.class) return (T)Float.valueOf(str); 
/* 1156 */         if (clazz == long.class || clazz == Long.class) return (T)Long.valueOf(str); 
/* 1157 */         if (clazz == double.class || clazz == Double.class) return (T)Double.valueOf(str); 
/* 1158 */         if (clazz == short.class || clazz == Short.class) return (T)Short.valueOf(str); 
/* 1159 */         if (clazz == byte.class || clazz == Byte.class) return (T)Byte.valueOf(str); 
/* 1160 */       } catch (NumberFormatException numberFormatException) {}
/*      */       
/* 1162 */       if (clazz == boolean.class || clazz == Boolean.class) return (T)Boolean.valueOf(str); 
/* 1163 */       if (clazz == char.class || clazz == Character.class) return (T)Character.valueOf(str.charAt(0)); 
/* 1164 */       if (ClassReflection.isAssignableFrom(Enum.class, clazz)) {
/* 1165 */         Enum[] arrayOfEnum = (Enum[])clazz.getEnumConstants(); byte b; int i;
/* 1166 */         for (b = 0, i = arrayOfEnum.length; b < i; b++) {
/* 1167 */           Enum enum_ = arrayOfEnum[b];
/* 1168 */           if (str.equals(convertToString(enum_))) return (T)enum_; 
/*      */         } 
/*      */       } 
/* 1171 */       if (clazz == CharSequence.class) return (T)str; 
/* 1172 */       throw new SerializationException("Unable to convert value to required type: " + paramJsonValue + " (" + clazz.getName() + ")");
/*      */     } 
/*      */     
/* 1175 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void copyFields(Object paramObject1, Object paramObject2) {
/* 1182 */     OrderedMap<String, FieldMetadata> orderedMap = getFields(paramObject2.getClass());
/* 1183 */     for (ObjectMap.Entries<String, FieldMetadata> entries = getFields(paramObject1.getClass()).iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = (ObjectMap.Entry)entries.next();
/* 1184 */       FieldMetadata fieldMetadata = orderedMap.get(entry.key);
/* 1185 */       Field field = ((FieldMetadata)entry.value).field;
/* 1186 */       if (fieldMetadata == null) throw new SerializationException("To object is missing field: " + (String)entry.key); 
/*      */       try {
/* 1188 */         fieldMetadata.field.set(paramObject2, field.get(paramObject1));
/* 1189 */       } catch (ReflectionException reflectionException) {
/* 1190 */         throw new SerializationException("Error copying field: " + field.getName(), reflectionException);
/*      */       }  }
/*      */   
/*      */   }
/*      */   
/*      */   private String convertToString(Enum paramEnum) {
/* 1196 */     return this.enumNames ? paramEnum.name() : paramEnum.toString();
/*      */   }
/*      */   
/*      */   private String convertToString(Object paramObject) {
/* 1200 */     if (paramObject instanceof Enum) return convertToString((Enum)paramObject); 
/* 1201 */     if (paramObject instanceof Class) return ((Class)paramObject).getName(); 
/* 1202 */     return String.valueOf(paramObject);
/*      */   }
/*      */   
/*      */   protected Object newInstance(Class paramClass) {
/*      */     try {
/* 1207 */       return ClassReflection.newInstance(paramClass);
/* 1208 */     } catch (Exception exception) {
/*      */       
/*      */       try { Constructor constructor;
/*      */         
/* 1212 */         (constructor = ClassReflection.getDeclaredConstructor(paramClass, new Class[0])).setAccessible(true);
/* 1213 */         return constructor.newInstance(new Object[0]); }
/* 1214 */       catch (SecurityException securityException) {  }
/* 1215 */       catch (ReflectionException reflectionException)
/* 1216 */       { if (ClassReflection.isAssignableFrom(Enum.class, paramClass)) {
/* 1217 */           if (paramClass.getEnumConstants() == null) paramClass = paramClass.getSuperclass(); 
/* 1218 */           return paramClass.getEnumConstants()[0];
/*      */         } 
/* 1220 */         if (paramClass.isArray())
/* 1221 */           throw new SerializationException("Encountered JSON object when expected array of type: " + paramClass.getName(), exception); 
/* 1222 */         if (ClassReflection.isMemberClass(paramClass) && !ClassReflection.isStaticClass(paramClass)) {
/* 1223 */           throw new SerializationException("Class cannot be created (non-static member class): " + paramClass.getName(), exception);
/*      */         }
/* 1225 */         throw new SerializationException("Class cannot be created (missing no-arg constructor): " + paramClass.getName(), exception); }
/* 1226 */       catch (Exception exception2)
/* 1227 */       { Exception exception1 = null; }
/*      */       
/* 1229 */       throw new SerializationException("Error constructing instance of class: " + paramClass.getName(), exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   public String prettyPrint(@Null Object paramObject) {
/* 1234 */     return prettyPrint(paramObject, 0);
/*      */   }
/*      */   
/*      */   public String prettyPrint(String paramString) {
/* 1238 */     return prettyPrint(paramString, 0);
/*      */   }
/*      */   
/*      */   public String prettyPrint(@Null Object paramObject, int paramInt) {
/* 1242 */     return prettyPrint(toJson(paramObject), paramInt);
/*      */   }
/*      */   
/*      */   public String prettyPrint(String paramString, int paramInt) {
/* 1246 */     return (new JsonReader()).parse(paramString).prettyPrint(this.outputType, paramInt);
/*      */   }
/*      */   
/*      */   public String prettyPrint(@Null Object paramObject, JsonValue.PrettyPrintSettings paramPrettyPrintSettings) {
/* 1250 */     return prettyPrint(toJson(paramObject), paramPrettyPrintSettings);
/*      */   }
/*      */   
/*      */   public String prettyPrint(String paramString, JsonValue.PrettyPrintSettings paramPrettyPrintSettings) {
/* 1254 */     return (new JsonReader()).parse(paramString).prettyPrint(paramPrettyPrintSettings);
/*      */   }
/*      */   public static interface Serializer<T> {
/*      */     void write(Json param1Json, T param1T, Class param1Class);
/*      */     T read(Json param1Json, JsonValue param1JsonValue, Class param1Class); }
/*      */   
/*      */   private static class FieldMetadata { final Field field;
/*      */     
/*      */     public FieldMetadata(Field param1Field) {
/* 1263 */       this.field = param1Field;
/*      */       
/* 1265 */       boolean bool = (ClassReflection.isAssignableFrom(ObjectMap.class, param1Field.getType()) || ClassReflection.isAssignableFrom(Map.class, param1Field.getType())) ? true : false;
/* 1266 */       this.elementType = param1Field.getElementType(bool);
/* 1267 */       this.deprecated = param1Field.isAnnotationPresent(Deprecated.class);
/*      */     }
/*      */     
/*      */     Class elementType;
/*      */     boolean deprecated; }
/*      */ 
/*      */   
/*      */   public static interface Serializable {
/*      */     void write(Json param1Json);
/*      */     
/*      */     void read(Json param1Json, JsonValue param1JsonValue);
/*      */   }
/*      */   
/*      */   public static abstract class ReadOnlySerializer<T> implements Serializer<T> {
/*      */     public void write(Json param1Json, T param1T, Class param1Class) {}
/*      */     
/*      */     public abstract T read(Json param1Json, JsonValue param1JsonValue, Class param1Class);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\Json.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */