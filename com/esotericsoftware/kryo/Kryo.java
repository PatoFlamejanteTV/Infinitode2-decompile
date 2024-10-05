/*      */ package com.esotericsoftware.kryo;
/*      */ 
/*      */ import com.esotericsoftware.kryo.io.Input;
/*      */ import com.esotericsoftware.kryo.io.Output;
/*      */ import com.esotericsoftware.kryo.serializers.ClosureSerializer;
/*      */ import com.esotericsoftware.kryo.serializers.CollectionSerializer;
/*      */ import com.esotericsoftware.kryo.serializers.DefaultArraySerializers;
/*      */ import com.esotericsoftware.kryo.serializers.DefaultSerializers;
/*      */ import com.esotericsoftware.kryo.serializers.ImmutableCollectionsSerializers;
/*      */ import com.esotericsoftware.kryo.serializers.MapSerializer;
/*      */ import com.esotericsoftware.kryo.serializers.OptionalSerializers;
/*      */ import com.esotericsoftware.kryo.serializers.RecordSerializer;
/*      */ import com.esotericsoftware.kryo.serializers.TimeSerializers;
/*      */ import com.esotericsoftware.kryo.util.DefaultClassResolver;
/*      */ import com.esotericsoftware.kryo.util.DefaultGenerics;
/*      */ import com.esotericsoftware.kryo.util.DefaultInstantiatorStrategy;
/*      */ import com.esotericsoftware.kryo.util.Generics;
/*      */ import com.esotericsoftware.kryo.util.IdentityMap;
/*      */ import com.esotericsoftware.kryo.util.IntArray;
/*      */ import com.esotericsoftware.kryo.util.MapReferenceResolver;
/*      */ import com.esotericsoftware.kryo.util.NoGenerics;
/*      */ import com.esotericsoftware.kryo.util.ObjectMap;
/*      */ import com.esotericsoftware.kryo.util.Util;
/*      */ import com.esotericsoftware.minlog.Log;
/*      */ import java.lang.reflect.InvocationHandler;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.lang.reflect.Proxy;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.net.URL;
/*      */ import java.nio.charset.Charset;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.BitSet;
/*      */ import java.util.Calendar;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.ConcurrentModificationException;
/*      */ import java.util.Currency;
/*      */ import java.util.Date;
/*      */ import java.util.EnumSet;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.PriorityQueue;
/*      */ import java.util.TimeZone;
/*      */ import java.util.TreeMap;
/*      */ import java.util.TreeSet;
/*      */ import java.util.concurrent.ConcurrentSkipListMap;
/*      */ import org.c.a.a;
/*      */ import org.c.b.a;
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
/*      */ public class Kryo
/*      */ {
/*      */   public static final byte NULL = 0;
/*      */   public static final byte NOT_NULL = 1;
/*      */   private static final int REF = -1;
/*      */   private static final int NO_REF = -2;
/*      */   private static final int DEFAULT_SERIALIZER_SIZE = 68;
/*  139 */   private SerializerFactory defaultSerializer = new SerializerFactory.FieldSerializerFactory();
/*  140 */   private final ArrayList<DefaultSerializerEntry> defaultSerializers = new ArrayList<>(68);
/*      */   
/*      */   private final int lowPriorityDefaultSerializerCount;
/*      */   private final ClassResolver classResolver;
/*      */   private int nextRegisterID;
/*  145 */   private ClassLoader classLoader = getClass().getClassLoader();
/*  146 */   private a strategy = (a)new DefaultInstantiatorStrategy();
/*      */   private boolean registrationRequired = true;
/*      */   private boolean warnUnregisteredClasses;
/*      */   private int depth;
/*  150 */   private int maxDepth = Integer.MAX_VALUE;
/*      */   private boolean autoReset = true;
/*      */   private volatile Thread thread;
/*      */   private ObjectMap context;
/*      */   private ObjectMap graphContext;
/*      */   private ReferenceResolver referenceResolver;
/*  156 */   private final IntArray readReferenceIds = new IntArray(0);
/*      */   private boolean references;
/*      */   private boolean copyReferences = true;
/*      */   private Object readObject;
/*      */   private int copyDepth;
/*      */   private boolean copyShallow;
/*      */   private IdentityMap originalToCopy;
/*      */   private Object needsCopyReference;
/*  164 */   private Generics generics = (Generics)new DefaultGenerics(this);
/*      */ 
/*      */   
/*      */   public Kryo() {
/*  168 */     this((ClassResolver)new DefaultClassResolver(), null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Kryo(ReferenceResolver paramReferenceResolver) {
/*  174 */     this((ClassResolver)new DefaultClassResolver(), paramReferenceResolver);
/*      */   }
/*      */ 
/*      */   
/*      */   public Kryo(ClassResolver paramClassResolver, ReferenceResolver paramReferenceResolver) {
/*  179 */     if (paramClassResolver == null) throw new IllegalArgumentException("classResolver cannot be null.");
/*      */     
/*  181 */     this.classResolver = paramClassResolver;
/*  182 */     paramClassResolver.setKryo(this);
/*      */     
/*  184 */     this.referenceResolver = paramReferenceResolver;
/*  185 */     if (paramReferenceResolver != null) {
/*  186 */       paramReferenceResolver.setKryo(this);
/*  187 */       this.references = true;
/*      */     } 
/*      */     
/*  190 */     addDefaultSerializer(byte[].class, (Class)DefaultArraySerializers.ByteArraySerializer.class);
/*  191 */     addDefaultSerializer(char[].class, (Class)DefaultArraySerializers.CharArraySerializer.class);
/*  192 */     addDefaultSerializer(short[].class, (Class)DefaultArraySerializers.ShortArraySerializer.class);
/*  193 */     addDefaultSerializer(int[].class, (Class)DefaultArraySerializers.IntArraySerializer.class);
/*  194 */     addDefaultSerializer(long[].class, (Class)DefaultArraySerializers.LongArraySerializer.class);
/*  195 */     addDefaultSerializer(float[].class, (Class)DefaultArraySerializers.FloatArraySerializer.class);
/*  196 */     addDefaultSerializer(double[].class, (Class)DefaultArraySerializers.DoubleArraySerializer.class);
/*  197 */     addDefaultSerializer(boolean[].class, (Class)DefaultArraySerializers.BooleanArraySerializer.class);
/*  198 */     addDefaultSerializer(String[].class, (Class)DefaultArraySerializers.StringArraySerializer.class);
/*  199 */     addDefaultSerializer(Object[].class, (Class)DefaultArraySerializers.ObjectArraySerializer.class);
/*  200 */     addDefaultSerializer(BigInteger.class, (Class)DefaultSerializers.BigIntegerSerializer.class);
/*  201 */     addDefaultSerializer(BigDecimal.class, (Class)DefaultSerializers.BigDecimalSerializer.class);
/*  202 */     addDefaultSerializer(Class.class, (Class)DefaultSerializers.ClassSerializer.class);
/*  203 */     addDefaultSerializer(Date.class, (Class)DefaultSerializers.DateSerializer.class);
/*  204 */     addDefaultSerializer(Enum.class, (Class)DefaultSerializers.EnumSerializer.class);
/*  205 */     addDefaultSerializer(EnumSet.class, (Class)DefaultSerializers.EnumSetSerializer.class);
/*  206 */     addDefaultSerializer(Currency.class, (Class)DefaultSerializers.CurrencySerializer.class);
/*  207 */     addDefaultSerializer(StringBuffer.class, (Class)DefaultSerializers.StringBufferSerializer.class);
/*  208 */     addDefaultSerializer(StringBuilder.class, (Class)DefaultSerializers.StringBuilderSerializer.class);
/*  209 */     addDefaultSerializer(Collections.EMPTY_LIST.getClass(), (Class)DefaultSerializers.CollectionsEmptyListSerializer.class);
/*  210 */     addDefaultSerializer(Collections.EMPTY_MAP.getClass(), (Class)DefaultSerializers.CollectionsEmptyMapSerializer.class);
/*  211 */     addDefaultSerializer(Collections.EMPTY_SET.getClass(), (Class)DefaultSerializers.CollectionsEmptySetSerializer.class);
/*  212 */     addDefaultSerializer(Collections.singletonList(null).getClass(), (Class)DefaultSerializers.CollectionsSingletonListSerializer.class);
/*  213 */     addDefaultSerializer(Collections.singletonMap(null, null).getClass(), (Class)DefaultSerializers.CollectionsSingletonMapSerializer.class);
/*  214 */     addDefaultSerializer(Collections.singleton(null).getClass(), (Class)DefaultSerializers.CollectionsSingletonSetSerializer.class);
/*  215 */     addDefaultSerializer(TreeSet.class, (Class)DefaultSerializers.TreeSetSerializer.class);
/*  216 */     addDefaultSerializer(Collection.class, (Class)CollectionSerializer.class);
/*  217 */     addDefaultSerializer(ConcurrentSkipListMap.class, (Class)DefaultSerializers.ConcurrentSkipListMapSerializer.class);
/*  218 */     addDefaultSerializer(TreeMap.class, (Class)DefaultSerializers.TreeMapSerializer.class);
/*  219 */     addDefaultSerializer(Map.class, (Class)MapSerializer.class);
/*  220 */     addDefaultSerializer(TimeZone.class, (Class)DefaultSerializers.TimeZoneSerializer.class);
/*  221 */     addDefaultSerializer(Calendar.class, (Class)DefaultSerializers.CalendarSerializer.class);
/*  222 */     addDefaultSerializer(Locale.class, (Class)DefaultSerializers.LocaleSerializer.class);
/*  223 */     addDefaultSerializer(Charset.class, (Class)DefaultSerializers.CharsetSerializer.class);
/*  224 */     addDefaultSerializer(URL.class, (Class)DefaultSerializers.URLSerializer.class);
/*  225 */     addDefaultSerializer(Arrays.<Object>asList(new Object[0]).getClass(), (Class)DefaultSerializers.ArraysAsListSerializer.class);
/*  226 */     addDefaultSerializer(void.class, (Serializer)new DefaultSerializers.VoidSerializer());
/*  227 */     addDefaultSerializer(PriorityQueue.class, (Serializer)new DefaultSerializers.PriorityQueueSerializer());
/*  228 */     addDefaultSerializer(BitSet.class, (Serializer)new DefaultSerializers.BitSetSerializer());
/*  229 */     addDefaultSerializer(KryoSerializable.class, (Class)DefaultSerializers.KryoSerializableSerializer.class);
/*  230 */     OptionalSerializers.addDefaultSerializers(this);
/*  231 */     TimeSerializers.addDefaultSerializers(this);
/*  232 */     ImmutableCollectionsSerializers.addDefaultSerializers(this);
/*      */     
/*  234 */     if (Util.isClassAvailable("java.lang.Record")) {
/*  235 */       addDefaultSerializer("java.lang.Record", (Class)RecordSerializer.class);
/*      */     }
/*  237 */     this.lowPriorityDefaultSerializerCount = this.defaultSerializers.size();
/*      */ 
/*      */     
/*  240 */     register(int.class, (Serializer)new DefaultSerializers.IntSerializer());
/*  241 */     register(String.class, (Serializer)new DefaultSerializers.StringSerializer());
/*  242 */     register(float.class, (Serializer)new DefaultSerializers.FloatSerializer());
/*  243 */     register(boolean.class, (Serializer)new DefaultSerializers.BooleanSerializer());
/*  244 */     register(byte.class, (Serializer)new DefaultSerializers.ByteSerializer());
/*  245 */     register(char.class, (Serializer)new DefaultSerializers.CharSerializer());
/*  246 */     register(short.class, (Serializer)new DefaultSerializers.ShortSerializer());
/*  247 */     register(long.class, (Serializer)new DefaultSerializers.LongSerializer());
/*  248 */     register(double.class, (Serializer)new DefaultSerializers.DoubleSerializer());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDefaultSerializer(SerializerFactory paramSerializerFactory) {
/*  257 */     if (paramSerializerFactory == null) throw new IllegalArgumentException("serializer cannot be null."); 
/*  258 */     this.defaultSerializer = paramSerializerFactory;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDefaultSerializer(Class<? extends Serializer> paramClass) {
/*  265 */     if (paramClass == null) throw new IllegalArgumentException("serializer cannot be null."); 
/*  266 */     this.defaultSerializer = new SerializerFactory.ReflectionSerializerFactory<>(paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addDefaultSerializer(Class paramClass, Serializer paramSerializer) {
/*  273 */     if (paramClass == null) throw new IllegalArgumentException("type cannot be null."); 
/*  274 */     if (paramSerializer == null) throw new IllegalArgumentException("serializer cannot be null."); 
/*  275 */     insertDefaultSerializer(paramClass, new SerializerFactory.SingletonSerializerFactory<>(paramSerializer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addDefaultSerializer(Class paramClass, SerializerFactory paramSerializerFactory) {
/*  282 */     if (paramClass == null) throw new IllegalArgumentException("type cannot be null."); 
/*  283 */     if (paramSerializerFactory == null) throw new IllegalArgumentException("serializerFactory cannot be null."); 
/*  284 */     insertDefaultSerializer(paramClass, paramSerializerFactory);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void addDefaultSerializer(String paramString, Class<? extends Serializer> paramClass) {
/*      */     try {
/*  292 */       addDefaultSerializer(Class.forName(paramString), paramClass); return;
/*  293 */     } catch (ClassNotFoundException classNotFoundException) {
/*  294 */       throw new KryoException("default serializer cannot be added: " + paramString);
/*      */     } 
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
/*      */   public void addDefaultSerializer(Class paramClass, Class<? extends Serializer> paramClass1) {
/*  427 */     if (paramClass == null) throw new IllegalArgumentException("type cannot be null."); 
/*  428 */     if (paramClass1 == null) throw new IllegalArgumentException("serializerClass cannot be null."); 
/*  429 */     insertDefaultSerializer(paramClass, new SerializerFactory.ReflectionSerializerFactory<>(paramClass1));
/*      */   }
/*      */   
/*      */   private int insertDefaultSerializer(Class paramClass, SerializerFactory paramSerializerFactory) {
/*  433 */     int i = 0; byte b; int j;
/*  434 */     for (b = 0, j = this.defaultSerializers.size() - this.lowPriorityDefaultSerializerCount; b < j; b++) {
/*  435 */       if (paramClass.isAssignableFrom(((DefaultSerializerEntry)this.defaultSerializers.get(b)).type)) i = b + 1; 
/*  436 */     }  this.defaultSerializers.add(i, new DefaultSerializerEntry(paramClass, paramSerializerFactory));
/*  437 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Serializer getDefaultSerializer(Class<?> paramClass) {
/*  443 */     if (paramClass == null) throw new IllegalArgumentException("type cannot be null.");
/*      */     
/*      */     Serializer serializer;
/*  446 */     if ((serializer = getDefaultSerializerForAnnotatedType(paramClass)) != null) return serializer;  byte b;
/*      */     int i;
/*  448 */     for (b = 0, i = this.defaultSerializers.size(); b < i; b++) {
/*      */       DefaultSerializerEntry defaultSerializerEntry;
/*  450 */       if ((defaultSerializerEntry = this.defaultSerializers.get(b)).type.isAssignableFrom(paramClass) && defaultSerializerEntry.serializerFactory.isSupported(paramClass)) {
/*  451 */         return defaultSerializerEntry.serializerFactory.newSerializer(this, paramClass);
/*      */       }
/*      */     } 
/*  454 */     return newDefaultSerializer(paramClass);
/*      */   }
/*      */   
/*      */   protected Serializer getDefaultSerializerForAnnotatedType(Class paramClass) {
/*  458 */     if (paramClass.isAnnotationPresent((Class)DefaultSerializer.class)) {
/*      */       DefaultSerializer defaultSerializer;
/*  460 */       return Util.newFactory((defaultSerializer = (DefaultSerializer)paramClass.getAnnotation(DefaultSerializer.class)).serializerFactory(), defaultSerializer.value()).newSerializer(this, paramClass);
/*      */     } 
/*  462 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Serializer newDefaultSerializer(Class paramClass) {
/*  469 */     return this.defaultSerializer.newSerializer(this, paramClass);
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
/*      */   public Registration register(Class paramClass) {
/*      */     Registration registration;
/*  482 */     if ((registration = this.classResolver.getRegistration(paramClass)) != null) return registration; 
/*  483 */     return register(paramClass, getDefaultSerializer(paramClass));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Registration register(Class paramClass, int paramInt) {
/*      */     Registration registration;
/*  495 */     if ((registration = this.classResolver.getRegistration(paramClass)) != null) return registration; 
/*  496 */     return register(paramClass, getDefaultSerializer(paramClass), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Registration register(Class paramClass, Serializer paramSerializer) {
/*      */     Registration registration;
/*  507 */     if ((registration = this.classResolver.getRegistration(paramClass)) != null) {
/*  508 */       registration.setSerializer(paramSerializer);
/*  509 */       return registration;
/*      */     } 
/*  511 */     return this.classResolver.register(new Registration(paramClass, paramSerializer, getNextRegistrationId()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Registration register(Class paramClass, Serializer paramSerializer, int paramInt) {
/*  521 */     if (paramInt < 0) throw new IllegalArgumentException("id must be >= 0: " + paramInt); 
/*  522 */     return register(new Registration(paramClass, paramSerializer, paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Registration register(Registration paramRegistration) {
/*      */     int i;
/*  534 */     if ((i = paramRegistration.getId()) < 0) throw new IllegalArgumentException("id must be > 0: " + i);
/*      */     
/*  536 */     Registration registration = this.classResolver.unregister(i);
/*  537 */     if (Log.DEBUG && registration != null && registration.getType() != paramRegistration.getType()) {
/*  538 */       Log.debug("kryo", "Registration overwritten: " + registration + " -> " + paramRegistration);
/*      */     }
/*  540 */     return this.classResolver.register(paramRegistration);
/*      */   }
/*      */ 
/*      */   
/*      */   public int getNextRegistrationId() {
/*  545 */     while (this.nextRegisterID != -2) {
/*  546 */       if (this.classResolver.getRegistration(this.nextRegisterID) == null) return this.nextRegisterID; 
/*  547 */       this.nextRegisterID++;
/*      */     } 
/*  549 */     throw new KryoException("No registration IDs are available.");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Registration getRegistration(Class<?> paramClass) {
/*  557 */     if (paramClass == null) throw new IllegalArgumentException("type cannot be null.");
/*      */     
/*      */     Registration registration;
/*  560 */     if ((registration = this.classResolver.getRegistration(paramClass)) == null) {
/*  561 */       if (isProxy(paramClass)) {
/*      */         
/*  563 */         registration = getRegistration(InvocationHandler.class);
/*  564 */       } else if (!paramClass.isEnum() && Enum.class.isAssignableFrom(paramClass) && paramClass != Enum.class) {
/*      */ 
/*      */ 
/*      */         
/*  568 */         while ((paramClass = paramClass.getSuperclass()) != null) {
/*  569 */           if (paramClass.isEnum()) {
/*  570 */             registration = this.classResolver.getRegistration(paramClass);
/*      */             break;
/*      */           } 
/*      */         } 
/*  574 */       } else if (EnumSet.class.isAssignableFrom(paramClass)) {
/*  575 */         registration = this.classResolver.getRegistration(EnumSet.class);
/*  576 */       } else if (isClosure(paramClass)) {
/*  577 */         registration = this.classResolver.getRegistration(ClosureSerializer.Closure.class);
/*  578 */       }  if (registration == null) {
/*  579 */         if (this.registrationRequired) throw new IllegalArgumentException(unregisteredClassMessage(paramClass)); 
/*  580 */         if (Log.WARN && this.warnUnregisteredClasses) Log.warn(unregisteredClassMessage(paramClass)); 
/*  581 */         registration = this.classResolver.registerImplicit(paramClass);
/*      */       } 
/*      */     } 
/*  584 */     return registration;
/*      */   }
/*      */   
/*      */   protected String unregisteredClassMessage(Class paramClass) {
/*  588 */     return "Class is not registered: " + Util.className(paramClass) + "\nNote: To register this class use: kryo.register(" + 
/*  589 */       Util.canonicalName(paramClass) + ".class);";
/*      */   }
/*      */ 
/*      */   
/*      */   public Registration getRegistration(int paramInt) {
/*  594 */     return this.classResolver.getRegistration(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Serializer getSerializer(Class paramClass) {
/*  601 */     return getRegistration(paramClass).getSerializer();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Registration writeClass(Output paramOutput, Class paramClass) {
/*  611 */     if (paramOutput == null) throw new IllegalArgumentException("output cannot be null."); 
/*      */     try {
/*  613 */       return this.classResolver.writeClass(paramOutput, paramClass);
/*      */     } finally {
/*  615 */       if (this.depth == 0 && this.autoReset) reset();
/*      */     
/*      */     } 
/*      */   }
/*      */   
/*      */   public void writeObject(Output paramOutput, Object paramObject) {
/*  621 */     if (paramOutput == null) throw new IllegalArgumentException("output cannot be null."); 
/*  622 */     if (paramObject == null) throw new IllegalArgumentException("object cannot be null."); 
/*  623 */     beginObject();
/*      */     try {
/*  625 */       if (this.references && writeReferenceOrNull(paramOutput, paramObject, false))
/*  626 */         return;  if (Log.TRACE || (Log.DEBUG && this.depth == 1)) Util.log("Write", paramObject, paramOutput.position()); 
/*  627 */       getRegistration(paramObject.getClass()).getSerializer().write(this, paramOutput, paramObject);
/*      */     } finally {
/*  629 */       if (--this.depth == 0 && this.autoReset) reset();
/*      */     
/*      */     } 
/*      */   }
/*      */   
/*      */   public void writeObject(Output paramOutput, Object paramObject, Serializer<Object> paramSerializer) {
/*  635 */     if (paramOutput == null) throw new IllegalArgumentException("output cannot be null."); 
/*  636 */     if (paramObject == null) throw new IllegalArgumentException("object cannot be null."); 
/*  637 */     if (paramSerializer == null) throw new IllegalArgumentException("serializer cannot be null."); 
/*  638 */     beginObject();
/*      */     try {
/*  640 */       if (this.references && writeReferenceOrNull(paramOutput, paramObject, false))
/*  641 */         return;  if (Log.TRACE || (Log.DEBUG && this.depth == 1)) Util.log("Write", paramObject, paramOutput.position()); 
/*  642 */       paramSerializer.write(this, paramOutput, paramObject);
/*      */     } finally {
/*  644 */       if (--this.depth == 0 && this.autoReset) reset();
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeObjectOrNull(Output paramOutput, Object paramObject, Class paramClass) {
/*  651 */     if (paramOutput == null) throw new IllegalArgumentException("output cannot be null."); 
/*  652 */     beginObject();
/*      */     try {
/*  654 */       Serializer<Object> serializer = getRegistration(paramClass).getSerializer();
/*  655 */       if (this.references)
/*  656 */       { if (writeReferenceOrNull(paramOutput, paramObject, true))
/*  657 */           return;  } else if (!serializer.getAcceptsNull())
/*  658 */       { if (paramObject == null) {
/*  659 */           if (Log.TRACE || (Log.DEBUG && this.depth == 1)) Util.log("Write", paramObject, paramOutput.position()); 
/*  660 */           paramOutput.writeByte((byte)0);
/*      */           return;
/*      */         } 
/*  663 */         if (Log.TRACE) Log.trace("kryo", "Write: <not null>" + Util.pos(paramOutput.position())); 
/*  664 */         paramOutput.writeByte((byte)1); }
/*      */       
/*  666 */       if (Log.TRACE || (Log.DEBUG && this.depth == 1)) Util.log("Write", paramObject, paramOutput.position()); 
/*  667 */       serializer.write(this, paramOutput, paramObject);
/*      */     } finally {
/*  669 */       if (--this.depth == 0 && this.autoReset) reset();
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeObjectOrNull(Output paramOutput, Object paramObject, Serializer<Object> paramSerializer) {
/*  676 */     if (paramOutput == null) throw new IllegalArgumentException("output cannot be null."); 
/*  677 */     if (paramSerializer == null) throw new IllegalArgumentException("serializer cannot be null."); 
/*  678 */     beginObject();
/*      */     try {
/*  680 */       if (this.references)
/*  681 */       { if (writeReferenceOrNull(paramOutput, paramObject, true))
/*  682 */           return;  } else if (!paramSerializer.getAcceptsNull())
/*  683 */       { if (paramObject == null) {
/*  684 */           if (Log.TRACE || (Log.DEBUG && this.depth == 1)) Util.log("Write", null, paramOutput.position()); 
/*  685 */           paramOutput.writeByte((byte)0);
/*      */           return;
/*      */         } 
/*  688 */         if (Log.TRACE) Log.trace("kryo", "Write: <not null>" + Util.pos(paramOutput.position())); 
/*  689 */         paramOutput.writeByte((byte)1); }
/*      */       
/*  691 */       if (Log.TRACE || (Log.DEBUG && this.depth == 1)) Util.log("Write", paramObject, paramOutput.position()); 
/*  692 */       paramSerializer.write(this, paramOutput, paramObject);
/*      */     } finally {
/*  694 */       if (--this.depth == 0 && this.autoReset) reset();
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeClassAndObject(Output paramOutput, Object paramObject) {
/*  701 */     if (paramOutput == null) throw new IllegalArgumentException("output cannot be null."); 
/*  702 */     beginObject();
/*      */     try {
/*  704 */       if (paramObject == null) {
/*  705 */         writeClass(paramOutput, null);
/*      */         return;
/*      */       } 
/*  708 */       Registration registration = writeClass(paramOutput, paramObject.getClass());
/*  709 */       if (this.references && writeReferenceOrNull(paramOutput, paramObject, false))
/*  710 */         return;  if (Log.TRACE || (Log.DEBUG && this.depth == 1)) Util.log("Write", paramObject, paramOutput.position()); 
/*  711 */       registration.getSerializer().write(this, paramOutput, paramObject);
/*      */     } finally {
/*  713 */       if (--this.depth == 0 && this.autoReset) reset();
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   boolean writeReferenceOrNull(Output paramOutput, Object paramObject, boolean paramBoolean) {
/*  720 */     if (paramObject == null) {
/*  721 */       if (Log.TRACE || (Log.DEBUG && this.depth == 1)) Util.log("Write", null, paramOutput.position()); 
/*  722 */       paramOutput.writeByte((byte)0);
/*  723 */       return true;
/*      */     } 
/*      */     
/*  726 */     if (!this.referenceResolver.useReferences(paramObject.getClass())) {
/*  727 */       if (paramBoolean) {
/*  728 */         if (Log.TRACE) Log.trace("kryo", "Write: <not null>" + Util.pos(paramOutput.position())); 
/*  729 */         paramOutput.writeByte((byte)1);
/*      */       } 
/*  731 */       return false;
/*      */     } 
/*      */ 
/*      */     
/*      */     int i;
/*      */ 
/*      */     
/*  738 */     if ((i = this.referenceResolver.getWrittenId(paramObject)) != -1) {
/*  739 */       if (Log.DEBUG) Log.debug("kryo", "Write reference " + i + ": " + Util.string(paramObject) + Util.pos(paramOutput.position())); 
/*  740 */       paramOutput.writeVarInt(i + 2, true);
/*  741 */       return true;
/*      */     } 
/*      */ 
/*      */     
/*  745 */     i = this.referenceResolver.addWrittenObject(paramObject);
/*  746 */     if (Log.TRACE) Log.trace("kryo", "Write: <not null>" + Util.pos(paramOutput.position())); 
/*  747 */     paramOutput.writeByte((byte)1);
/*  748 */     if (Log.TRACE) Log.trace("kryo", "Write initial reference " + i + ": " + Util.string(paramObject) + Util.pos(paramOutput.position())); 
/*  749 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Registration readClass(Input paramInput) {
/*  756 */     if (paramInput == null) throw new IllegalArgumentException("input cannot be null."); 
/*      */     try {
/*  758 */       return this.classResolver.readClass(paramInput);
/*      */     } finally {
/*  760 */       if (this.depth == 0 && this.autoReset) reset();
/*      */     
/*      */     } 
/*      */   }
/*      */   
/*      */   public <T> T readObject(Input paramInput, Class<T> paramClass) {
/*  766 */     if (paramInput == null) throw new IllegalArgumentException("input cannot be null."); 
/*  767 */     if (paramClass == null) throw new IllegalArgumentException("type cannot be null."); 
/*  768 */     beginObject();
/*      */     try {
/*      */       Object object;
/*  771 */       if (this.references) {
/*      */         int i;
/*  773 */         if ((i = readReferenceOrNull(paramInput, paramClass, false)) == -1) { object = this.readObject; return (T)object; }
/*  774 */          paramClass = getRegistration(paramClass).getSerializer().read(this, (Input)object, (Class)paramClass);
/*  775 */         if (i == this.readReferenceIds.size) reference(paramClass); 
/*      */       } else {
/*  777 */         paramClass = getRegistration(paramClass).getSerializer().read(this, (Input)object, (Class)paramClass);
/*  778 */       }  if (Log.TRACE || (Log.DEBUG && this.depth == 1)) Util.log("Read", paramClass, object.position()); 
/*  779 */       return (T)paramClass;
/*      */     } finally {
/*  781 */       if (--this.depth == 0 && this.autoReset) reset();
/*      */     
/*      */     } 
/*      */   }
/*      */   
/*      */   public <T> T readObject(Input paramInput, Class<T> paramClass, Serializer<Class<T>> paramSerializer) {
/*  787 */     if (paramInput == null) throw new IllegalArgumentException("input cannot be null."); 
/*  788 */     if (paramClass == null) throw new IllegalArgumentException("type cannot be null."); 
/*  789 */     if (paramSerializer == null) throw new IllegalArgumentException("serializer cannot be null."); 
/*  790 */     beginObject();
/*      */     try {
/*      */       Object object;
/*  793 */       if (this.references) {
/*      */         int i;
/*  795 */         if ((i = readReferenceOrNull(paramInput, paramClass, false)) == -1) { object = this.readObject; return (T)object; }
/*  796 */          paramClass = paramSerializer.read(this, (Input)object, (Class)paramClass);
/*  797 */         if (i == this.readReferenceIds.size) reference(paramClass); 
/*      */       } else {
/*  799 */         paramClass = paramSerializer.read(this, (Input)object, (Class)paramClass);
/*  800 */       }  if (Log.TRACE || (Log.DEBUG && this.depth == 1)) Util.log("Read", paramClass, object.position()); 
/*  801 */       return (T)paramClass;
/*      */     } finally {
/*  803 */       if (--this.depth == 0 && this.autoReset) reset();
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public <T> T readObjectOrNull(Input paramInput, Class<T> paramClass) {
/*  810 */     if (paramInput == null) throw new IllegalArgumentException("input cannot be null."); 
/*  811 */     if (paramClass == null) throw new IllegalArgumentException("type cannot be null."); 
/*  812 */     beginObject();
/*      */     try {
/*      */       Object object;
/*  815 */       if (this.references) {
/*      */         int i;
/*  817 */         if ((i = readReferenceOrNull(paramInput, paramClass, true)) == -1) { object = this.readObject; return (T)object; }
/*  818 */          paramClass = getRegistration(paramClass).getSerializer().read(this, (Input)object, (Class)paramClass);
/*  819 */         if (i == this.readReferenceIds.size) reference(paramClass); 
/*      */       } else {
/*      */         Serializer<?> serializer;
/*  822 */         if (!(serializer = getRegistration(paramClass).getSerializer()).getAcceptsNull() && object.readByte() == 0) {
/*  823 */           if (Log.TRACE || (Log.DEBUG && this.depth == 1)) Util.log("Read", null, object.position()); 
/*  824 */           object = null; return (T)object;
/*      */         } 
/*  826 */         paramClass = (Class<T>)serializer.read(this, (Input)object, paramClass);
/*      */       } 
/*  828 */       if (Log.TRACE || (Log.DEBUG && this.depth == 1)) Util.log("Read", paramClass, object.position()); 
/*  829 */       return (T)paramClass;
/*      */     } finally {
/*  831 */       if (--this.depth == 0 && this.autoReset) reset();
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public <T> T readObjectOrNull(Input paramInput, Class<T> paramClass, Serializer<Class<T>> paramSerializer) {
/*  838 */     if (paramInput == null) throw new IllegalArgumentException("input cannot be null."); 
/*  839 */     if (paramClass == null) throw new IllegalArgumentException("type cannot be null."); 
/*  840 */     if (paramSerializer == null) throw new IllegalArgumentException("serializer cannot be null."); 
/*  841 */     beginObject();
/*      */     try {
/*      */       Object object;
/*  844 */       if (this.references) {
/*      */         int i;
/*  846 */         if ((i = readReferenceOrNull(paramInput, paramClass, true)) == -1) { object = this.readObject; return (T)object; }
/*  847 */          paramClass = paramSerializer.read(this, (Input)object, (Class)paramClass);
/*  848 */         if (i == this.readReferenceIds.size) reference(paramClass); 
/*      */       } else {
/*  850 */         if (!paramSerializer.getAcceptsNull() && object.readByte() == 0) {
/*  851 */           if (Log.TRACE || (Log.DEBUG && this.depth == 1)) Util.log("Read", null, object.position()); 
/*  852 */           return null;
/*      */         } 
/*  854 */         paramClass = paramSerializer.read(this, (Input)object, (Class)paramClass);
/*      */       } 
/*  856 */       if (Log.TRACE || (Log.DEBUG && this.depth == 1)) Util.log("Read", paramClass, object.position()); 
/*  857 */       return (T)paramClass;
/*      */     } finally {
/*  859 */       if (--this.depth == 0 && this.autoReset) reset();
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object readClassAndObject(Input paramInput) {
/*  866 */     if (paramInput == null) throw new IllegalArgumentException("input cannot be null."); 
/*  867 */     beginObject(); try {
/*      */       Object object;
/*      */       Registration registration;
/*  870 */       if ((registration = readClass(paramInput)) == null) return null; 
/*  871 */       Class<? extends Registration> clazz = registration.getType();
/*      */ 
/*      */       
/*  874 */       if (this.references) {
/*      */         int i;
/*  876 */         if ((i = readReferenceOrNull(paramInput, clazz, false)) == -1) { object = this.readObject; return object; }
/*  877 */          registration = registration.getSerializer().read(this, (Input)object, clazz);
/*  878 */         if (i == this.readReferenceIds.size) reference(registration); 
/*      */       } else {
/*  880 */         registration = registration.getSerializer().read(this, (Input)object, clazz);
/*  881 */       }  if (Log.TRACE || (Log.DEBUG && this.depth == 1)) Util.log("Read", registration, object.position()); 
/*  882 */       return registration;
/*      */     } finally {
/*  884 */       if (--this.depth == 0 && this.autoReset) reset();
/*      */     
/*      */     } 
/*      */   }
/*      */   
/*      */   int readReferenceOrNull(Input paramInput, Class paramClass, boolean paramBoolean) {
/*      */     int i;
/*  891 */     if (paramClass.isPrimitive()) paramClass = Util.getWrapperClass(paramClass); 
/*  892 */     boolean bool = this.referenceResolver.useReferences(paramClass);
/*      */     
/*  894 */     if (paramBoolean) {
/*      */       
/*  896 */       if ((i = paramInput.readVarInt(true)) == 0) {
/*  897 */         if (Log.TRACE || (Log.DEBUG && this.depth == 1)) Util.log("Read", null, paramInput.position()); 
/*  898 */         this.readObject = null;
/*  899 */         return -1;
/*      */       } 
/*  901 */       if (!bool) {
/*  902 */         this.readReferenceIds.add(-2);
/*  903 */         return this.readReferenceIds.size;
/*      */       } 
/*      */     } else {
/*  906 */       if (!bool) {
/*  907 */         this.readReferenceIds.add(-2);
/*  908 */         return this.readReferenceIds.size;
/*      */       } 
/*  910 */       i = paramInput.readVarInt(true);
/*      */     } 
/*  912 */     if (i == 1) {
/*  913 */       if (Log.TRACE) Log.trace("kryo", "Read: <not null>" + Util.pos(paramInput.position()));
/*      */       
/*  915 */       i = this.referenceResolver.nextReadId(paramClass);
/*  916 */       if (Log.TRACE) Log.trace("kryo", "Read initial reference " + i + ": " + Util.className(paramClass) + Util.pos(paramInput.position())); 
/*  917 */       this.readReferenceIds.add(i);
/*  918 */       return this.readReferenceIds.size;
/*      */     } 
/*      */     
/*  921 */     i -= 2;
/*      */     try {
/*  923 */       this.readObject = this.referenceResolver.getReadObject(paramClass, i);
/*  924 */     } catch (Exception exception) {
/*  925 */       throw new KryoException("Unable to resolve reference for " + Util.className(paramClass) + " with id: " + i, exception);
/*      */     } 
/*  927 */     if (Log.DEBUG) Log.debug("kryo", "Read reference " + i + ": " + Util.string(this.readObject) + Util.pos(exception.position())); 
/*  928 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void reference(Object paramObject) {
/*  936 */     if (this.copyDepth > 0)
/*  937 */     { if (this.needsCopyReference != null) {
/*  938 */         if (paramObject == null) throw new IllegalArgumentException("object cannot be null."); 
/*  939 */         this.originalToCopy.put(this.needsCopyReference, paramObject);
/*  940 */         this.needsCopyReference = null; return;
/*      */       }  }
/*  942 */     else { int i; if (this.references && paramObject != null && (
/*      */         
/*  944 */         i = this.readReferenceIds.pop()) != -2) this.referenceResolver.setReadObject(i, paramObject);
/*      */        }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void reset() {
/*  953 */     this.depth = 0;
/*  954 */     if (this.graphContext != null) this.graphContext.clear(2048); 
/*  955 */     this.classResolver.reset();
/*  956 */     if (this.references) {
/*  957 */       this.referenceResolver.reset();
/*  958 */       this.readObject = null;
/*      */     } 
/*      */     
/*  961 */     this.copyDepth = 0;
/*  962 */     if (this.originalToCopy != null) this.originalToCopy.clear(2048);
/*      */     
/*  964 */     if (Log.TRACE) Log.trace("kryo", "Object graph complete.");
/*      */   
/*      */   }
/*      */ 
/*      */   
/*      */   public <T> T copy(T paramT) {
/*  970 */     if (paramT == null) return null; 
/*  971 */     if (this.copyShallow) return paramT; 
/*  972 */     this.copyDepth++;
/*      */     try {
/*  974 */       if (this.originalToCopy == null) this.originalToCopy = new IdentityMap(); 
/*      */       Object object;
/*  976 */       if ((object = this.originalToCopy.get(paramT)) != null) { paramT = (T)object; return paramT; }
/*      */       
/*  978 */       if (this.copyReferences) this.needsCopyReference = paramT;
/*      */       
/*  980 */       if (paramT instanceof KryoCopyable) {
/*  981 */         paramT = ((KryoCopyable<T>)paramT).copy(this);
/*      */       } else {
/*  983 */         paramT = getSerializer(paramT.getClass()).copy(this, paramT);
/*  984 */       }  if (this.needsCopyReference != null) reference(paramT); 
/*  985 */       if (Log.TRACE || (Log.DEBUG && this.copyDepth == 1)) Util.log("Copy", paramT, -1); 
/*  986 */       paramT = paramT; return paramT;
/*      */     } finally {
/*  988 */       if (--this.copyDepth == 0) reset();
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> T copy(T paramT, Serializer<T> paramSerializer) {
/*  996 */     if (paramT == null) return null; 
/*  997 */     if (this.copyShallow) return paramT; 
/*  998 */     this.copyDepth++;
/*      */     try {
/* 1000 */       if (this.originalToCopy == null) this.originalToCopy = new IdentityMap(); 
/*      */       Object object;
/* 1002 */       if ((object = this.originalToCopy.get(paramT)) != null) { paramT = (T)object; return paramT; }
/*      */       
/* 1004 */       if (this.copyReferences) this.needsCopyReference = paramT;
/*      */       
/* 1006 */       if (paramT instanceof KryoCopyable) {
/* 1007 */         paramT = ((KryoCopyable<T>)paramT).copy(this);
/*      */       } else {
/* 1009 */         paramT = paramSerializer.copy(this, paramT);
/* 1010 */       }  if (this.needsCopyReference != null) reference(paramT); 
/* 1011 */       if (Log.TRACE || (Log.DEBUG && this.copyDepth == 1)) Util.log("Copy", paramT, -1); 
/* 1012 */       paramT = paramT; return paramT;
/*      */     } finally {
/* 1014 */       if (--this.copyDepth == 0) reset();
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> T copyShallow(T paramT) {
/* 1022 */     if (paramT == null) return null; 
/* 1023 */     this.copyDepth++;
/* 1024 */     this.copyShallow = true;
/*      */     try {
/* 1026 */       if (this.originalToCopy == null) this.originalToCopy = new IdentityMap(); 
/*      */       Object object;
/* 1028 */       if ((object = this.originalToCopy.get(paramT)) != null) { paramT = (T)object; return paramT; }
/*      */       
/* 1030 */       if (this.copyReferences) this.needsCopyReference = paramT;
/*      */       
/* 1032 */       if (paramT instanceof KryoCopyable) {
/* 1033 */         paramT = ((KryoCopyable<T>)paramT).copy(this);
/*      */       } else {
/* 1035 */         paramT = getSerializer(paramT.getClass()).copy(this, paramT);
/* 1036 */       }  if (this.needsCopyReference != null) reference(paramT); 
/* 1037 */       if (Log.TRACE || (Log.DEBUG && this.copyDepth == 1)) Util.log("Shallow copy", paramT, -1); 
/* 1038 */       paramT = paramT; return paramT;
/*      */     } finally {
/* 1040 */       this.copyShallow = false;
/* 1041 */       if (--this.copyDepth == 0) reset();
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> T copyShallow(T paramT, Serializer<T> paramSerializer) {
/* 1049 */     if (paramT == null) return null; 
/* 1050 */     this.copyDepth++;
/* 1051 */     this.copyShallow = true;
/*      */     try {
/* 1053 */       if (this.originalToCopy == null) this.originalToCopy = new IdentityMap(); 
/*      */       Object object;
/* 1055 */       if ((object = this.originalToCopy.get(paramT)) != null) { paramT = (T)object; return paramT; }
/*      */       
/* 1057 */       if (this.copyReferences) this.needsCopyReference = paramT;
/*      */       
/* 1059 */       if (paramT instanceof KryoCopyable) {
/* 1060 */         paramT = ((KryoCopyable<T>)paramT).copy(this);
/*      */       } else {
/* 1062 */         paramT = paramSerializer.copy(this, paramT);
/* 1063 */       }  if (this.needsCopyReference != null) reference(paramT); 
/* 1064 */       if (Log.TRACE || (Log.DEBUG && this.copyDepth == 1)) Util.log("Shallow copy", paramT, -1); 
/* 1065 */       paramT = paramT; return paramT;
/*      */     } finally {
/* 1067 */       this.copyShallow = false;
/* 1068 */       if (--this.copyDepth == 0) reset();
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void beginObject() {
/* 1075 */     if (Log.DEBUG)
/* 1076 */       if (this.depth == 0) {
/* 1077 */         this.thread = Thread.currentThread();
/* 1078 */       } else if (this.thread != Thread.currentThread()) {
/* 1079 */         throw new ConcurrentModificationException("Kryo must not be accessed concurrently by multiple threads.");
/*      */       }  
/* 1081 */     if (this.depth == this.maxDepth) throw new KryoException("Max depth exceeded: " + this.depth); 
/* 1082 */     this.depth++;
/*      */   }
/*      */   
/*      */   public ClassResolver getClassResolver() {
/* 1086 */     return this.classResolver;
/*      */   }
/*      */ 
/*      */   
/*      */   public ReferenceResolver getReferenceResolver() {
/* 1091 */     return this.referenceResolver;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setClassLoader(ClassLoader paramClassLoader) {
/* 1097 */     if (paramClassLoader == null) throw new IllegalArgumentException("classLoader cannot be null."); 
/* 1098 */     this.classLoader = paramClassLoader;
/*      */   }
/*      */   
/*      */   public ClassLoader getClassLoader() {
/* 1102 */     return this.classLoader;
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
/*      */   public void setRegistrationRequired(boolean paramBoolean) {
/* 1118 */     this.registrationRequired = paramBoolean;
/* 1119 */     if (Log.TRACE) Log.trace("kryo", "Registration required: " + paramBoolean); 
/*      */   }
/*      */   
/*      */   public boolean isRegistrationRequired() {
/* 1123 */     return this.registrationRequired;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setWarnUnregisteredClasses(boolean paramBoolean) {
/* 1128 */     this.warnUnregisteredClasses = paramBoolean;
/* 1129 */     if (Log.TRACE) Log.trace("kryo", "Warn unregistered classes: " + paramBoolean); 
/*      */   }
/*      */   
/*      */   public boolean getWarnUnregisteredClasses() {
/* 1133 */     return this.warnUnregisteredClasses;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setReferences(boolean paramBoolean) {
/* 1142 */     boolean bool = this.references;
/* 1143 */     if (paramBoolean == bool) return paramBoolean; 
/* 1144 */     if (bool) {
/* 1145 */       this.referenceResolver.reset();
/* 1146 */       this.readObject = null;
/*      */     } 
/* 1148 */     this.references = paramBoolean;
/* 1149 */     if (paramBoolean && this.referenceResolver == null) this.referenceResolver = (ReferenceResolver)new MapReferenceResolver(); 
/* 1150 */     if (Log.TRACE) Log.trace("kryo", "References: " + paramBoolean); 
/* 1151 */     return !paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCopyReferences(boolean paramBoolean) {
/* 1159 */     this.copyReferences = paramBoolean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setReferenceResolver(ReferenceResolver paramReferenceResolver) {
/* 1164 */     if (paramReferenceResolver == null) throw new IllegalArgumentException("referenceResolver cannot be null."); 
/* 1165 */     this.references = true;
/* 1166 */     this.referenceResolver = paramReferenceResolver;
/* 1167 */     if (Log.TRACE) Log.trace("kryo", "Reference resolver: " + paramReferenceResolver.getClass().getName()); 
/*      */   }
/*      */   
/*      */   public boolean getReferences() {
/* 1171 */     return this.references;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInstantiatorStrategy(a parama) {
/* 1179 */     this.strategy = parama;
/*      */   }
/*      */   
/*      */   public a getInstantiatorStrategy() {
/* 1183 */     return this.strategy;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected a newInstantiator(Class paramClass) {
/* 1190 */     return this.strategy.newInstantiatorOf(paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> T newInstance(Class<T> paramClass) {
/*      */     Registration registration;
/*      */     a a1;
/* 1198 */     if ((a1 = (registration = getRegistration(paramClass)).getInstantiator()) == null) {
/* 1199 */       a1 = newInstantiator(paramClass);
/* 1200 */       registration.setInstantiator(a1);
/*      */     } 
/* 1202 */     return (T)a1.newInstance();
/*      */   }
/*      */ 
/*      */   
/*      */   public ObjectMap getContext() {
/* 1207 */     if (this.context == null) this.context = new ObjectMap(); 
/* 1208 */     return this.context;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ObjectMap getGraphContext() {
/* 1214 */     if (this.graphContext == null) this.graphContext = new ObjectMap(); 
/* 1215 */     return this.graphContext;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getDepth() {
/* 1220 */     return this.depth;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IdentityMap getOriginalToCopyMap() {
/* 1227 */     return this.originalToCopy;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAutoReset(boolean paramBoolean) {
/* 1234 */     this.autoReset = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaxDepth(int paramInt) {
/* 1240 */     if (paramInt <= 0) throw new IllegalArgumentException("maxDepth must be > 0."); 
/* 1241 */     this.maxDepth = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isFinal(Class paramClass) {
/* 1251 */     if (paramClass == null) throw new IllegalArgumentException("type cannot be null."); 
/* 1252 */     if (paramClass.isArray()) return Modifier.isFinal(Util.getElementClass(paramClass).getModifiers()); 
/* 1253 */     return Modifier.isFinal(paramClass.getModifiers());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isClosure(Class paramClass) {
/* 1262 */     if (paramClass == null) throw new IllegalArgumentException("type cannot be null."); 
/* 1263 */     return (paramClass.isSynthetic() && paramClass.getSimpleName().indexOf('/') >= 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isProxy(Class<?> paramClass) {
/* 1272 */     if (paramClass == null) throw new IllegalArgumentException("type cannot be null."); 
/* 1273 */     return Proxy.isProxyClass(paramClass);
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
/*      */   public Generics getGenerics() {
/* 1292 */     return this.generics;
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
/*      */   public void setOptimizedGenerics(boolean paramBoolean) {
/* 1304 */     this.generics = paramBoolean ? (Generics)new DefaultGenerics(this) : NoGenerics.INSTANCE;
/*      */   }
/*      */   
/*      */   static final class DefaultSerializerEntry {
/*      */     final Class type;
/*      */     final SerializerFactory serializerFactory;
/*      */     
/*      */     DefaultSerializerEntry(Class param1Class, SerializerFactory param1SerializerFactory) {
/* 1312 */       this.type = param1Class;
/* 1313 */       this.serializerFactory = param1SerializerFactory;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\Kryo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */