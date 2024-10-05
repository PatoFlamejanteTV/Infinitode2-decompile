/*      */ package com.esotericsoftware.kryo.serializers;
/*      */ 
/*      */ import com.esotericsoftware.kryo.Kryo;
/*      */ import com.esotericsoftware.kryo.KryoException;
/*      */ import com.esotericsoftware.kryo.KryoSerializable;
/*      */ import com.esotericsoftware.kryo.Registration;
/*      */ import com.esotericsoftware.kryo.Serializer;
/*      */ import com.esotericsoftware.kryo.io.Input;
/*      */ import com.esotericsoftware.kryo.io.Output;
/*      */ import com.esotericsoftware.kryo.util.Util;
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.net.MalformedURLException;
/*      */ import java.net.URI;
/*      */ import java.net.URISyntaxException;
/*      */ import java.net.URL;
/*      */ import java.nio.charset.Charset;
/*      */ import java.sql.Date;
/*      */ import java.sql.Time;
/*      */ import java.sql.Timestamp;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.BitSet;
/*      */ import java.util.Calendar;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.Currency;
/*      */ import java.util.Date;
/*      */ import java.util.EnumSet;
/*      */ import java.util.GregorianCalendar;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.PriorityQueue;
/*      */ import java.util.Set;
/*      */ import java.util.TimeZone;
/*      */ import java.util.TreeMap;
/*      */ import java.util.TreeSet;
/*      */ import java.util.UUID;
/*      */ import java.util.concurrent.ConcurrentSkipListMap;
/*      */ import java.util.concurrent.atomic.AtomicBoolean;
/*      */ import java.util.concurrent.atomic.AtomicInteger;
/*      */ import java.util.concurrent.atomic.AtomicLong;
/*      */ import java.util.concurrent.atomic.AtomicReference;
/*      */ import java.util.regex.Pattern;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class DefaultSerializers
/*      */ {
/*      */   public static class VoidSerializer
/*      */     extends ImmutableSerializer
/*      */   {
/*      */     public void write(Kryo param1Kryo, Output param1Output, Object param1Object) {}
/*      */     
/*      */     public Object read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/*   79 */       return null;
/*      */     }
/*      */   }
/*      */   
/*      */   public static class BooleanSerializer extends ImmutableSerializer<Boolean> {
/*      */     public void write(Kryo param1Kryo, Output param1Output, Boolean param1Boolean) {
/*   85 */       param1Output.writeBoolean(param1Boolean.booleanValue());
/*      */     }
/*      */     
/*      */     public Boolean read(Kryo param1Kryo, Input param1Input, Class<? extends Boolean> param1Class) {
/*   89 */       return Boolean.valueOf(param1Input.readBoolean());
/*      */     }
/*      */   }
/*      */   
/*      */   public static class ByteSerializer extends ImmutableSerializer<Byte> {
/*      */     public void write(Kryo param1Kryo, Output param1Output, Byte param1Byte) {
/*   95 */       param1Output.writeByte(param1Byte.byteValue());
/*      */     }
/*      */     
/*      */     public Byte read(Kryo param1Kryo, Input param1Input, Class<? extends Byte> param1Class) {
/*   99 */       return Byte.valueOf(param1Input.readByte());
/*      */     }
/*      */   }
/*      */   
/*      */   public static class CharSerializer extends ImmutableSerializer<Character> {
/*      */     public void write(Kryo param1Kryo, Output param1Output, Character param1Character) {
/*  105 */       param1Output.writeChar(param1Character.charValue());
/*      */     }
/*      */     
/*      */     public Character read(Kryo param1Kryo, Input param1Input, Class<? extends Character> param1Class) {
/*  109 */       return Character.valueOf(param1Input.readChar());
/*      */     }
/*      */   }
/*      */   
/*      */   public static class ShortSerializer extends ImmutableSerializer<Short> {
/*      */     public void write(Kryo param1Kryo, Output param1Output, Short param1Short) {
/*  115 */       param1Output.writeShort(param1Short.shortValue());
/*      */     }
/*      */     
/*      */     public Short read(Kryo param1Kryo, Input param1Input, Class<? extends Short> param1Class) {
/*  119 */       return Short.valueOf(param1Input.readShort());
/*      */     }
/*      */   }
/*      */   
/*      */   public static class IntSerializer extends ImmutableSerializer<Integer> {
/*      */     public void write(Kryo param1Kryo, Output param1Output, Integer param1Integer) {
/*  125 */       param1Output.writeInt(param1Integer.intValue(), false);
/*      */     }
/*      */     
/*      */     public Integer read(Kryo param1Kryo, Input param1Input, Class<? extends Integer> param1Class) {
/*  129 */       return Integer.valueOf(param1Input.readInt(false));
/*      */     }
/*      */   }
/*      */   
/*      */   public static class LongSerializer extends ImmutableSerializer<Long> {
/*      */     public void write(Kryo param1Kryo, Output param1Output, Long param1Long) {
/*  135 */       param1Output.writeVarLong(param1Long.longValue(), false);
/*      */     }
/*      */     
/*      */     public Long read(Kryo param1Kryo, Input param1Input, Class<? extends Long> param1Class) {
/*  139 */       return Long.valueOf(param1Input.readVarLong(false));
/*      */     }
/*      */   }
/*      */   
/*      */   public static class FloatSerializer extends ImmutableSerializer<Float> {
/*      */     public void write(Kryo param1Kryo, Output param1Output, Float param1Float) {
/*  145 */       param1Output.writeFloat(param1Float.floatValue());
/*      */     }
/*      */     
/*      */     public Float read(Kryo param1Kryo, Input param1Input, Class<? extends Float> param1Class) {
/*  149 */       return Float.valueOf(param1Input.readFloat());
/*      */     }
/*      */   }
/*      */   
/*      */   public static class DoubleSerializer extends ImmutableSerializer<Double> {
/*      */     public void write(Kryo param1Kryo, Output param1Output, Double param1Double) {
/*  155 */       param1Output.writeDouble(param1Double.doubleValue());
/*      */     }
/*      */     
/*      */     public Double read(Kryo param1Kryo, Input param1Input, Class<? extends Double> param1Class) {
/*  159 */       return Double.valueOf(param1Input.readDouble());
/*      */     }
/*      */   }
/*      */   
/*      */   public static class StringSerializer
/*      */     extends ImmutableSerializer<String> {
/*      */     public StringSerializer() {
/*  166 */       setAcceptsNull(true);
/*      */     }
/*      */     
/*      */     public void write(Kryo param1Kryo, Output param1Output, String param1String) {
/*  170 */       param1Output.writeString(param1String);
/*      */     }
/*      */     
/*      */     public String read(Kryo param1Kryo, Input param1Input, Class<? extends String> param1Class) {
/*  174 */       return param1Input.readString();
/*      */     }
/*      */   }
/*      */   
/*      */   public static class BigIntegerSerializer
/*      */     extends ImmutableSerializer<BigInteger>
/*      */   {
/*      */     public BigIntegerSerializer() {
/*  182 */       setAcceptsNull(true);
/*      */     }
/*      */     
/*      */     public void write(Kryo param1Kryo, Output param1Output, BigInteger param1BigInteger) {
/*  186 */       if (param1BigInteger == null) {
/*  187 */         param1Output.writeByte((byte)0);
/*      */         
/*      */         return;
/*      */       } 
/*  191 */       if (param1BigInteger == BigInteger.ZERO) {
/*  192 */         param1Output.writeByte(2);
/*  193 */         param1Output.writeByte(0);
/*      */         
/*      */         return;
/*      */       } 
/*  197 */       byte[] arrayOfByte = param1BigInteger.toByteArray();
/*  198 */       param1Output.writeVarInt(arrayOfByte.length + 1, true);
/*  199 */       param1Output.writeBytes(arrayOfByte);
/*      */     }
/*      */     
/*      */     public BigInteger read(Kryo param1Kryo, Input param1Input, Class<? extends BigInteger> param1Class) {
/*      */       int i;
/*  204 */       if ((i = param1Input.readVarInt(true)) == 0) return null; 
/*  205 */       byte[] arrayOfByte = param1Input.readBytes(i - 1);
/*  206 */       if (param1Class != BigInteger.class && param1Class != null) {
/*      */         try {
/*      */           Constructor<? extends BigInteger> constructor;
/*      */           
/*  210 */           if (!(constructor = param1Class.getConstructor(new Class[] { byte[].class })).isAccessible()) {
/*      */             try {
/*  212 */               constructor.setAccessible(true);
/*  213 */             } catch (SecurityException securityException) {}
/*      */           }
/*      */           
/*  216 */           return constructor.newInstance(new Object[] { arrayOfByte });
/*  217 */         } catch (Exception exception) {
/*  218 */           throw new KryoException(exception);
/*      */         } 
/*      */       }
/*  221 */       if (exception == 2)
/*      */       {
/*  223 */         switch (arrayOfByte[0]) {
/*      */           case 0:
/*  225 */             return BigInteger.ZERO;
/*      */           case 1:
/*  227 */             return BigInteger.ONE;
/*      */           case 10:
/*  229 */             return BigInteger.TEN;
/*      */         } 
/*      */       }
/*  232 */       return new BigInteger(arrayOfByte);
/*      */     } }
/*      */   
/*      */   public static class BigDecimalSerializer extends ImmutableSerializer<BigDecimal> {
/*      */     private final DefaultSerializers.BigIntegerSerializer bigIntegerSerializer;
/*      */     
/*      */     public BigDecimalSerializer() {
/*  239 */       this.bigIntegerSerializer = new DefaultSerializers.BigIntegerSerializer();
/*      */ 
/*      */       
/*  242 */       setAcceptsNull(true);
/*      */     }
/*      */     
/*      */     public void write(Kryo param1Kryo, Output param1Output, BigDecimal param1BigDecimal) {
/*  246 */       if (param1BigDecimal == null) {
/*  247 */         param1Output.writeByte((byte)0);
/*      */         
/*      */         return;
/*      */       } 
/*  251 */       if (param1BigDecimal == BigDecimal.ZERO) {
/*  252 */         this.bigIntegerSerializer.write(param1Kryo, param1Output, BigInteger.ZERO);
/*  253 */         param1Output.writeInt(0, false);
/*      */         
/*      */         return;
/*      */       } 
/*  257 */       this.bigIntegerSerializer.write(param1Kryo, param1Output, param1BigDecimal.unscaledValue());
/*  258 */       param1Output.writeInt(param1BigDecimal.scale(), false);
/*      */     }
/*      */     
/*      */     public BigDecimal read(Kryo param1Kryo, Input param1Input, Class<? extends BigDecimal> param1Class) {
/*      */       BigInteger bigInteger;
/*  263 */       if ((bigInteger = this.bigIntegerSerializer.read(param1Kryo, param1Input, BigInteger.class)) == null) return null; 
/*  264 */       int i = param1Input.readInt(false);
/*  265 */       if (param1Class != BigDecimal.class && param1Class != null) {
/*      */         try {
/*      */           Constructor<? extends BigDecimal> constructor;
/*      */           
/*  269 */           if (!(constructor = param1Class.getConstructor(new Class[] { BigInteger.class, int.class })).isAccessible()) {
/*      */             try {
/*  271 */               constructor.setAccessible(true);
/*  272 */             } catch (SecurityException securityException) {}
/*      */           }
/*      */           
/*  275 */           return constructor.newInstance(new Object[] { bigInteger, Integer.valueOf(i) });
/*  276 */         } catch (Exception exception) {
/*  277 */           throw new KryoException(exception);
/*      */         } 
/*      */       }
/*      */       
/*  281 */       if (bigInteger == BigInteger.ZERO && i == 0) {
/*  282 */         return BigDecimal.ZERO;
/*      */       }
/*      */       
/*  285 */       return new BigDecimal(bigInteger, i);
/*      */     }
/*      */   }
/*      */   
/*      */   public static class ClassSerializer extends ImmutableSerializer<Class> {
/*      */     public ClassSerializer() {
/*  291 */       setAcceptsNull(true);
/*      */     }
/*      */     
/*      */     public void write(Kryo param1Kryo, Output param1Output, Class param1Class) {
/*  295 */       param1Kryo.writeClass(param1Output, param1Class);
/*  296 */       if (param1Class != null && (param1Class.isPrimitive() || Util.isWrapperClass(param1Class))) param1Output.writeBoolean(param1Class.isPrimitive()); 
/*      */     }
/*      */     
/*      */     public Class read(Kryo param1Kryo, Input param1Input, Class<? extends Class> param1Class) {
/*      */       Registration registration;
/*  301 */       if ((registration = param1Kryo.readClass(param1Input)) == null) return null; 
/*      */       Class<?> clazz;
/*  303 */       if (!(clazz = registration.getType()).isPrimitive() || param1Input.readBoolean()) return clazz; 
/*  304 */       return Util.getWrapperClass(clazz);
/*      */     }
/*      */   }
/*      */   
/*      */   public static class DateSerializer
/*      */     extends Serializer<Date>
/*      */   {
/*      */     private Date create(Kryo param1Kryo, Class<? extends Date> param1Class, long param1Long) {
/*  312 */       if (param1Class == Date.class || param1Class == null) {
/*  313 */         return new Date(param1Long);
/*      */       }
/*  315 */       if (param1Class == Timestamp.class) {
/*  316 */         return new Timestamp(param1Long);
/*      */       }
/*  318 */       if (param1Class == Date.class) {
/*  319 */         return new Date(param1Long);
/*      */       }
/*  321 */       if (param1Class == Time.class) {
/*  322 */         return new Time(param1Long);
/*      */       }
/*      */ 
/*      */       
/*      */       try {
/*      */         Constructor<? extends Date> constructor;
/*      */         
/*  329 */         if (!(constructor = param1Class.getConstructor(new Class[] { long.class })).isAccessible()) {
/*      */           try {
/*  331 */             constructor.setAccessible(true);
/*  332 */           } catch (SecurityException securityException) {}
/*      */         }
/*      */         
/*  335 */         return constructor.newInstance(new Object[] { Long.valueOf(param1Long) });
/*  336 */       } catch (Exception exception) {
/*      */         Date date;
/*      */         
/*  339 */         (date = (Date)param1Kryo.newInstance(param1Class)).setTime(param1Long);
/*  340 */         return date;
/*      */       } 
/*      */     }
/*      */     
/*      */     public void write(Kryo param1Kryo, Output param1Output, Date param1Date) {
/*  345 */       param1Output.writeVarLong(param1Date.getTime(), true);
/*      */     }
/*      */     
/*      */     public Date read(Kryo param1Kryo, Input param1Input, Class<? extends Date> param1Class) {
/*  349 */       return create(param1Kryo, param1Class, param1Input.readVarLong(true));
/*      */     }
/*      */     
/*      */     public Date copy(Kryo param1Kryo, Date param1Date) {
/*  353 */       return create(param1Kryo, (Class)param1Date.getClass(), param1Date.getTime());
/*      */     }
/*      */   }
/*      */   
/*      */   public static class TimestampSerializer
/*      */     extends Serializer<Timestamp> {
/*      */     public void write(Kryo param1Kryo, Output param1Output, Timestamp param1Timestamp) {
/*  360 */       param1Output.writeVarLong(integralTimeComponent(param1Timestamp), true);
/*  361 */       param1Output.writeVarInt(param1Timestamp.getNanos(), true);
/*      */     }
/*      */     
/*      */     public Timestamp read(Kryo param1Kryo, Input param1Input, Class<? extends Timestamp> param1Class) {
/*  365 */       return create(param1Input.readVarLong(true), param1Input.readVarInt(true));
/*      */     }
/*      */     
/*      */     public Timestamp copy(Kryo param1Kryo, Timestamp param1Timestamp) {
/*  369 */       return create(integralTimeComponent(param1Timestamp), param1Timestamp.getNanos());
/*      */     }
/*      */     
/*      */     private long integralTimeComponent(Timestamp param1Timestamp) {
/*  373 */       return param1Timestamp.getTime() - (param1Timestamp.getNanos() / 1000000);
/*      */     }
/*      */     
/*      */     private Timestamp create(long param1Long, int param1Int) {
/*      */       Timestamp timestamp;
/*  378 */       (timestamp = new Timestamp(param1Long)).setNanos(param1Int);
/*  379 */       return timestamp;
/*      */     }
/*      */   }
/*      */   
/*      */   public static class EnumSerializer extends ImmutableSerializer<Enum> {
/*      */     public EnumSerializer(Class<? extends Enum> param1Class) {
/*  385 */       setAcceptsNull(true);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  391 */       this.enumConstants = param1Class.getEnumConstants();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  397 */       if (this.enumConstants == null && !Enum.class.equals(param1Class))
/*  398 */         throw new IllegalArgumentException("The type must be an enum: " + param1Class); 
/*      */     }
/*      */     private Object[] enumConstants;
/*      */     public void write(Kryo param1Kryo, Output param1Output, Enum param1Enum) {
/*  402 */       if (param1Enum == null) {
/*  403 */         param1Output.writeVarInt(0, true);
/*      */         return;
/*      */       } 
/*  406 */       param1Output.writeVarInt(param1Enum.ordinal() + 1, true);
/*      */     }
/*      */     
/*      */     public Enum read(Kryo param1Kryo, Input param1Input, Class<? extends Enum> param1Class) {
/*      */       int i;
/*  411 */       if ((i = param1Input.readVarInt(true)) == 0) return null; 
/*  412 */       i--;
/*  413 */       if (i < 0 || i > this.enumConstants.length - 1)
/*  414 */         throw new KryoException("Invalid ordinal for enum \"" + param1Class.getName() + "\": " + i); 
/*      */       Object object;
/*  416 */       return (Enum)(object = this.enumConstants[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   public static class EnumSetSerializer extends Serializer<EnumSet> {
/*      */     public void write(Kryo param1Kryo, Output param1Output, EnumSet<Enum> param1EnumSet) {
/*      */       Serializer serializer;
/*  423 */       if (param1EnumSet.isEmpty()) {
/*      */         EnumSet<Enum> enumSet;
/*  425 */         if ((enumSet = EnumSet.<Enum>complementOf(param1EnumSet)).isEmpty()) throw new KryoException("An EnumSet must have a defined Enum to be serialized."); 
/*  426 */         serializer = param1Kryo.writeClass(param1Output, enumSet.iterator().next().getClass()).getSerializer();
/*      */       } else {
/*  428 */         serializer = param1Kryo.writeClass(param1Output, param1EnumSet.iterator().next().getClass()).getSerializer();
/*      */       } 
/*  430 */       param1Output.writeVarInt(param1EnumSet.size(), true);
/*  431 */       for (EnumSet<Enum> param1EnumSet : param1EnumSet)
/*  432 */         serializer.write(param1Kryo, param1Output, param1EnumSet); 
/*      */     }
/*      */     
/*      */     public EnumSet read(Kryo param1Kryo, Input param1Input, Class<? extends EnumSet> param1Class) {
/*      */       Registration registration;
/*  437 */       EnumSet<Enum> enumSet = EnumSet.noneOf((registration = param1Kryo.readClass(param1Input)).getType());
/*  438 */       Serializer serializer = registration.getSerializer();
/*  439 */       int i = param1Input.readVarInt(true);
/*  440 */       for (byte b = 0; b < i; b++)
/*  441 */         enumSet.add(serializer.read(param1Kryo, param1Input, null)); 
/*  442 */       return enumSet;
/*      */     }
/*      */     
/*      */     public EnumSet copy(Kryo param1Kryo, EnumSet<Enum> param1EnumSet) {
/*  446 */       return EnumSet.copyOf(param1EnumSet);
/*      */     }
/*      */   }
/*      */   
/*      */   public static class CurrencySerializer
/*      */     extends ImmutableSerializer<Currency> {
/*      */     public CurrencySerializer() {
/*  453 */       setAcceptsNull(true);
/*      */     }
/*      */     
/*      */     public void write(Kryo param1Kryo, Output param1Output, Currency param1Currency) {
/*  457 */       param1Output.writeString((param1Currency == null) ? null : param1Currency.getCurrencyCode());
/*      */     }
/*      */     
/*      */     public Currency read(Kryo param1Kryo, Input param1Input, Class<? extends Currency> param1Class) {
/*      */       String str;
/*  462 */       if ((str = param1Input.readString()) == null) return null; 
/*  463 */       return Currency.getInstance(str);
/*      */     }
/*      */   }
/*      */   
/*      */   public static class StringBufferSerializer
/*      */     extends Serializer<StringBuffer> {
/*      */     public StringBufferSerializer() {
/*  470 */       setAcceptsNull(true);
/*      */     }
/*      */     
/*      */     public void write(Kryo param1Kryo, Output param1Output, StringBuffer param1StringBuffer) {
/*  474 */       param1Output.writeString((param1StringBuffer == null) ? null : param1StringBuffer.toString());
/*      */     }
/*      */     
/*      */     public StringBuffer read(Kryo param1Kryo, Input param1Input, Class<? extends StringBuffer> param1Class) {
/*      */       String str;
/*  479 */       if ((str = param1Input.readString()) == null) return null; 
/*  480 */       return new StringBuffer(str);
/*      */     }
/*      */     
/*      */     public StringBuffer copy(Kryo param1Kryo, StringBuffer param1StringBuffer) {
/*  484 */       return new StringBuffer(param1StringBuffer);
/*      */     }
/*      */   }
/*      */   
/*      */   public static class StringBuilderSerializer
/*      */     extends Serializer<StringBuilder> {
/*      */     public StringBuilderSerializer() {
/*  491 */       setAcceptsNull(true);
/*      */     }
/*      */     
/*      */     public void write(Kryo param1Kryo, Output param1Output, StringBuilder param1StringBuilder) {
/*  495 */       param1Output.writeString((param1StringBuilder == null) ? null : param1StringBuilder.toString());
/*      */     }
/*      */     
/*      */     public StringBuilder read(Kryo param1Kryo, Input param1Input, Class<? extends StringBuilder> param1Class) {
/*  499 */       return param1Input.readStringBuilder();
/*      */     }
/*      */     
/*      */     public StringBuilder copy(Kryo param1Kryo, StringBuilder param1StringBuilder) {
/*  503 */       return new StringBuilder(param1StringBuilder);
/*      */     }
/*      */   }
/*      */   
/*      */   public static class KryoSerializableSerializer extends Serializer<KryoSerializable> {
/*      */     public void write(Kryo param1Kryo, Output param1Output, KryoSerializable param1KryoSerializable) {
/*  509 */       param1KryoSerializable.write(param1Kryo, param1Output);
/*      */     }
/*      */     
/*      */     public KryoSerializable read(Kryo param1Kryo, Input param1Input, Class<? extends KryoSerializable> param1Class) {
/*  513 */       KryoSerializable kryoSerializable = (KryoSerializable)param1Kryo.newInstance(param1Class);
/*  514 */       param1Kryo.reference(kryoSerializable);
/*  515 */       kryoSerializable.read(param1Kryo, param1Input);
/*  516 */       return kryoSerializable;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class CollectionsEmptyListSerializer
/*      */     extends ImmutableSerializer<Collection>
/*      */   {
/*      */     public void write(Kryo param1Kryo, Output param1Output, Collection param1Collection) {}
/*      */ 
/*      */     
/*      */     public Collection read(Kryo param1Kryo, Input param1Input, Class<? extends Collection> param1Class) {
/*  528 */       return Collections.EMPTY_LIST;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class CollectionsEmptyMapSerializer
/*      */     extends ImmutableSerializer<Map>
/*      */   {
/*      */     public void write(Kryo param1Kryo, Output param1Output, Map param1Map) {}
/*      */ 
/*      */     
/*      */     public Map read(Kryo param1Kryo, Input param1Input, Class<? extends Map> param1Class) {
/*  540 */       return Collections.EMPTY_MAP;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class CollectionsEmptySetSerializer
/*      */     extends ImmutableSerializer<Set>
/*      */   {
/*      */     public void write(Kryo param1Kryo, Output param1Output, Set param1Set) {}
/*      */ 
/*      */     
/*      */     public Set read(Kryo param1Kryo, Input param1Input, Class<? extends Set> param1Class) {
/*  552 */       return Collections.EMPTY_SET;
/*      */     }
/*      */   }
/*      */   
/*      */   public static class CollectionsSingletonListSerializer
/*      */     extends Serializer<List>
/*      */   {
/*      */     public void write(Kryo param1Kryo, Output param1Output, List param1List) {
/*  560 */       param1Kryo.writeClassAndObject(param1Output, param1List.get(0));
/*      */     }
/*      */     
/*      */     public List read(Kryo param1Kryo, Input param1Input, Class<? extends List> param1Class) {
/*  564 */       return Collections.singletonList(param1Kryo.readClassAndObject(param1Input));
/*      */     }
/*      */     
/*      */     public List copy(Kryo param1Kryo, List param1List) {
/*  568 */       return Collections.singletonList(param1Kryo.copy(param1List.get(0)));
/*      */     }
/*      */   }
/*      */   
/*      */   public static class CollectionsSingletonMapSerializer
/*      */     extends Serializer<Map>
/*      */   {
/*      */     public void write(Kryo param1Kryo, Output param1Output, Map param1Map) {
/*  576 */       Map.Entry entry = param1Map.entrySet().iterator().next();
/*  577 */       param1Kryo.writeClassAndObject(param1Output, entry.getKey());
/*  578 */       param1Kryo.writeClassAndObject(param1Output, entry.getValue());
/*      */     }
/*      */     
/*      */     public Map read(Kryo param1Kryo, Input param1Input, Class<? extends Map> param1Class) {
/*  582 */       Object object2 = param1Kryo.readClassAndObject(param1Input);
/*  583 */       Object object1 = param1Kryo.readClassAndObject(param1Input);
/*  584 */       return Collections.singletonMap(object2, object1);
/*      */     }
/*      */     
/*      */     public Map copy(Kryo param1Kryo, Map param1Map) {
/*  588 */       Map.Entry entry = param1Map.entrySet().iterator().next();
/*  589 */       return Collections.singletonMap(param1Kryo.copy(entry.getKey()), param1Kryo.copy(entry.getValue()));
/*      */     }
/*      */   }
/*      */   
/*      */   public static class CollectionsSingletonSetSerializer
/*      */     extends Serializer<Set>
/*      */   {
/*      */     public void write(Kryo param1Kryo, Output param1Output, Set param1Set) {
/*  597 */       param1Kryo.writeClassAndObject(param1Output, param1Set.iterator().next());
/*      */     }
/*      */     
/*      */     public Set read(Kryo param1Kryo, Input param1Input, Class<? extends Set> param1Class) {
/*  601 */       return Collections.singleton(param1Kryo.readClassAndObject(param1Input));
/*      */     }
/*      */     
/*      */     public Set copy(Kryo param1Kryo, Set param1Set) {
/*  605 */       return Collections.singleton(param1Kryo.copy(param1Set.iterator().next()));
/*      */     }
/*      */   }
/*      */   
/*      */   public static class TimeZoneSerializer
/*      */     extends ImmutableSerializer<TimeZone>
/*      */   {
/*      */     public void write(Kryo param1Kryo, Output param1Output, TimeZone param1TimeZone) {
/*  613 */       param1Output.writeString(param1TimeZone.getID());
/*      */     }
/*      */     
/*      */     public TimeZone read(Kryo param1Kryo, Input param1Input, Class<? extends TimeZone> param1Class) {
/*  617 */       return TimeZone.getTimeZone(param1Input.readString());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class CalendarSerializer
/*      */     extends Serializer<Calendar>
/*      */   {
/*      */     private static final long DEFAULT_GREGORIAN_CUTOVER = -12219292800000L;
/*      */     
/*  627 */     DefaultSerializers.TimeZoneSerializer timeZoneSerializer = new DefaultSerializers.TimeZoneSerializer();
/*      */     
/*      */     public void write(Kryo param1Kryo, Output param1Output, Calendar param1Calendar) {
/*  630 */       this.timeZoneSerializer.write(param1Kryo, param1Output, param1Calendar.getTimeZone());
/*  631 */       param1Output.writeVarLong(param1Calendar.getTimeInMillis(), true);
/*  632 */       param1Output.writeBoolean(param1Calendar.isLenient());
/*  633 */       param1Output.writeInt(param1Calendar.getFirstDayOfWeek(), true);
/*  634 */       param1Output.writeInt(param1Calendar.getMinimalDaysInFirstWeek(), true);
/*  635 */       if (param1Calendar instanceof GregorianCalendar) {
/*  636 */         param1Output.writeVarLong(((GregorianCalendar)param1Calendar).getGregorianChange().getTime(), false); return;
/*      */       } 
/*  638 */       param1Output.writeVarLong(-12219292800000L, false);
/*      */     }
/*      */     
/*      */     public Calendar read(Kryo param1Kryo, Input param1Input, Class<? extends Calendar> param1Class) {
/*      */       Calendar calendar;
/*  643 */       (calendar = Calendar.getInstance(this.timeZoneSerializer.read(param1Kryo, param1Input, TimeZone.class))).setTimeInMillis(param1Input.readVarLong(true));
/*  644 */       calendar.setLenient(param1Input.readBoolean());
/*  645 */       calendar.setFirstDayOfWeek(param1Input.readInt(true));
/*  646 */       calendar.setMinimalDaysInFirstWeek(param1Input.readInt(true));
/*      */       long l;
/*  648 */       if ((l = param1Input.readVarLong(false)) != -12219292800000L && 
/*  649 */         calendar instanceof GregorianCalendar) ((GregorianCalendar)calendar).setGregorianChange(new Date(l)); 
/*  650 */       return calendar;
/*      */     }
/*      */     
/*      */     public Calendar copy(Kryo param1Kryo, Calendar param1Calendar) {
/*  654 */       return (Calendar)param1Calendar.clone();
/*      */     }
/*      */   }
/*      */   
/*      */   public static class TreeMapSerializer
/*      */     extends MapSerializer<TreeMap>
/*      */   {
/*      */     protected void writeHeader(Kryo param1Kryo, Output param1Output, TreeMap param1TreeMap) {
/*  662 */       param1Kryo.writeClassAndObject(param1Output, param1TreeMap.comparator());
/*      */     }
/*      */     
/*      */     protected TreeMap create(Kryo param1Kryo, Input param1Input, Class<? extends TreeMap> param1Class, int param1Int) {
/*  666 */       return createTreeMap(param1Class, (Comparator)param1Kryo.readClassAndObject(param1Input));
/*      */     }
/*      */     
/*      */     protected TreeMap createCopy(Kryo param1Kryo, TreeMap param1TreeMap) {
/*  670 */       return createTreeMap((Class)param1TreeMap.getClass(), param1TreeMap.comparator());
/*      */     }
/*      */     
/*      */     private TreeMap createTreeMap(Class<? extends TreeMap> param1Class, Comparator<?> param1Comparator) {
/*  674 */       if (param1Class == TreeMap.class || param1Class == null) return new TreeMap<>(param1Comparator);
/*      */       
/*      */       try {
/*      */         Constructor<? extends TreeMap> constructor;
/*  678 */         if (!(constructor = param1Class.getConstructor(new Class[] { Comparator.class })).isAccessible()) {
/*      */           try {
/*  680 */             constructor.setAccessible(true);
/*  681 */           } catch (SecurityException securityException) {}
/*      */         }
/*      */         
/*  684 */         return constructor.newInstance(new Object[] { param1Comparator });
/*  685 */       } catch (Exception exception) {
/*  686 */         throw new KryoException(exception);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class ConcurrentSkipListMapSerializer
/*      */     extends MapSerializer<ConcurrentSkipListMap>
/*      */   {
/*      */     protected void writeHeader(Kryo param1Kryo, Output param1Output, ConcurrentSkipListMap param1ConcurrentSkipListMap) {
/*  696 */       param1Kryo.writeClassAndObject(param1Output, param1ConcurrentSkipListMap.comparator());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected ConcurrentSkipListMap create(Kryo param1Kryo, Input param1Input, Class<? extends ConcurrentSkipListMap> param1Class, int param1Int) {
/*  702 */       return createConcurrentSkipListMap(param1Class, (Comparator)param1Kryo.readClassAndObject(param1Input));
/*      */     }
/*      */ 
/*      */     
/*      */     protected ConcurrentSkipListMap createCopy(Kryo param1Kryo, ConcurrentSkipListMap param1ConcurrentSkipListMap) {
/*  707 */       return createConcurrentSkipListMap((Class)param1ConcurrentSkipListMap.getClass(), param1ConcurrentSkipListMap.comparator());
/*      */     }
/*      */ 
/*      */     
/*      */     private ConcurrentSkipListMap createConcurrentSkipListMap(Class<? extends ConcurrentSkipListMap> param1Class, Comparator<?> param1Comparator) {
/*  712 */       if (param1Class == ConcurrentSkipListMap.class || param1Class == null) {
/*  713 */         return new ConcurrentSkipListMap<>(param1Comparator);
/*      */       }
/*      */       
/*      */       try {
/*      */         Constructor<? extends ConcurrentSkipListMap> constructor;
/*  718 */         if (!(constructor = param1Class.getConstructor(new Class[] { Comparator.class })).isAccessible()) {
/*      */           try {
/*  720 */             constructor.setAccessible(true);
/*  721 */           } catch (SecurityException securityException) {}
/*      */         }
/*      */         
/*  724 */         return constructor.newInstance(new Object[] { param1Comparator });
/*  725 */       } catch (Exception exception) {
/*  726 */         throw new KryoException(exception);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public static class TreeSetSerializer
/*      */     extends CollectionSerializer<TreeSet>
/*      */   {
/*      */     protected void writeHeader(Kryo param1Kryo, Output param1Output, TreeSet param1TreeSet) {
/*  735 */       param1Kryo.writeClassAndObject(param1Output, param1TreeSet.comparator());
/*      */     }
/*      */     
/*      */     protected TreeSet create(Kryo param1Kryo, Input param1Input, Class<? extends TreeSet> param1Class, int param1Int) {
/*  739 */       return createTreeSet((Class)param1Class, (Comparator)param1Kryo.readClassAndObject(param1Input));
/*      */     }
/*      */     
/*      */     protected TreeSet createCopy(Kryo param1Kryo, TreeSet param1TreeSet) {
/*  743 */       return createTreeSet((Class)param1TreeSet.getClass(), param1TreeSet.comparator());
/*      */     }
/*      */     
/*      */     private TreeSet createTreeSet(Class<? extends Collection> param1Class, Comparator<?> param1Comparator) {
/*  747 */       if (param1Class == TreeSet.class || param1Class == null) return new TreeSet(param1Comparator);
/*      */       
/*      */       try {
/*      */         Constructor<? extends Collection> constructor;
/*  751 */         if (!(constructor = param1Class.getConstructor(new Class[] { Comparator.class })).isAccessible()) {
/*      */           try {
/*  753 */             constructor.setAccessible(true);
/*  754 */           } catch (SecurityException securityException) {}
/*      */         }
/*      */         
/*  757 */         return (TreeSet)constructor.newInstance(new Object[] { param1Comparator });
/*  758 */       } catch (Exception exception) {
/*  759 */         throw new KryoException(exception);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public static class PriorityQueueSerializer
/*      */     extends CollectionSerializer<PriorityQueue>
/*      */   {
/*      */     protected void writeHeader(Kryo param1Kryo, Output param1Output, PriorityQueue param1PriorityQueue) {
/*  768 */       param1Kryo.writeClassAndObject(param1Output, param1PriorityQueue.comparator());
/*      */     }
/*      */     
/*      */     protected PriorityQueue create(Kryo param1Kryo, Input param1Input, Class<? extends PriorityQueue> param1Class, int param1Int) {
/*  772 */       return createPriorityQueue((Class)param1Class, param1Int, (Comparator)param1Kryo.readClassAndObject(param1Input));
/*      */     }
/*      */     
/*      */     protected PriorityQueue createCopy(Kryo param1Kryo, PriorityQueue param1PriorityQueue) {
/*  776 */       return createPriorityQueue((Class)param1PriorityQueue.getClass(), param1PriorityQueue.size(), param1PriorityQueue.comparator());
/*      */     }
/*      */     
/*      */     private PriorityQueue createPriorityQueue(Class<? extends Collection> param1Class, int param1Int, Comparator<?> param1Comparator) {
/*  780 */       param1Int = Math.max(param1Int, 1);
/*  781 */       if (param1Class == PriorityQueue.class || param1Class == null) return new PriorityQueue(param1Int, param1Comparator);
/*      */       
/*      */       try {
/*      */         Constructor<? extends Collection> constructor;
/*  785 */         if (!(constructor = param1Class.getConstructor(new Class[] { int.class, Comparator.class })).isAccessible()) {
/*      */           try {
/*  787 */             constructor.setAccessible(true);
/*  788 */           } catch (SecurityException securityException) {}
/*      */         }
/*      */         
/*  791 */         return (PriorityQueue)constructor.newInstance(new Object[] { Integer.valueOf(param1Int), param1Comparator });
/*  792 */       } catch (Exception exception) {
/*  793 */         throw new KryoException(exception);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class LocaleSerializer
/*      */     extends ImmutableSerializer<Locale>
/*      */   {
/*  802 */     public static final Locale SPANISH = new Locale("es", "", "");
/*  803 */     public static final Locale SPAIN = new Locale("es", "ES", "");
/*      */ 
/*      */     
/*      */     protected Locale create(String param1String1, String param1String2, String param1String3) {
/*      */       Locale locale;
/*  808 */       if (isSameLocale(locale = Locale.getDefault(), param1String1, param1String2, param1String3)) return locale;
/*      */ 
/*      */       
/*  811 */       if (locale != Locale.US && isSameLocale(Locale.US, param1String1, param1String2, param1String3)) return Locale.US;
/*      */       
/*  813 */       if (isSameLocale(Locale.ENGLISH, param1String1, param1String2, param1String3)) return Locale.ENGLISH; 
/*  814 */       if (isSameLocale(Locale.GERMAN, param1String1, param1String2, param1String3)) return Locale.GERMAN; 
/*  815 */       if (isSameLocale(SPANISH, param1String1, param1String2, param1String3)) return SPANISH; 
/*  816 */       if (isSameLocale(Locale.FRENCH, param1String1, param1String2, param1String3)) return Locale.FRENCH; 
/*  817 */       if (isSameLocale(Locale.ITALIAN, param1String1, param1String2, param1String3)) return Locale.ITALIAN; 
/*  818 */       if (isSameLocale(Locale.JAPANESE, param1String1, param1String2, param1String3)) return Locale.JAPANESE; 
/*  819 */       if (isSameLocale(Locale.KOREAN, param1String1, param1String2, param1String3)) return Locale.KOREAN; 
/*  820 */       if (isSameLocale(Locale.SIMPLIFIED_CHINESE, param1String1, param1String2, param1String3)) return Locale.SIMPLIFIED_CHINESE; 
/*  821 */       if (isSameLocale(Locale.CHINESE, param1String1, param1String2, param1String3)) return Locale.CHINESE; 
/*  822 */       if (isSameLocale(Locale.TRADITIONAL_CHINESE, param1String1, param1String2, param1String3)) return Locale.TRADITIONAL_CHINESE;
/*      */       
/*  824 */       if (isSameLocale(Locale.UK, param1String1, param1String2, param1String3)) return Locale.UK; 
/*  825 */       if (isSameLocale(Locale.GERMANY, param1String1, param1String2, param1String3)) return Locale.GERMANY; 
/*  826 */       if (isSameLocale(SPAIN, param1String1, param1String2, param1String3)) return SPAIN; 
/*  827 */       if (isSameLocale(Locale.FRANCE, param1String1, param1String2, param1String3)) return Locale.FRANCE; 
/*  828 */       if (isSameLocale(Locale.ITALY, param1String1, param1String2, param1String3)) return Locale.ITALY; 
/*  829 */       if (isSameLocale(Locale.JAPAN, param1String1, param1String2, param1String3)) return Locale.JAPAN; 
/*  830 */       if (isSameLocale(Locale.KOREA, param1String1, param1String2, param1String3)) return Locale.KOREA;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  837 */       if (isSameLocale(Locale.CANADA, param1String1, param1String2, param1String3)) return Locale.CANADA; 
/*  838 */       if (isSameLocale(Locale.CANADA_FRENCH, param1String1, param1String2, param1String3)) return Locale.CANADA_FRENCH;
/*      */       
/*  840 */       return new Locale(param1String1, param1String2, param1String3);
/*      */     }
/*      */     
/*      */     public void write(Kryo param1Kryo, Output param1Output, Locale param1Locale) {
/*  844 */       param1Output.writeAscii(param1Locale.getLanguage());
/*  845 */       param1Output.writeAscii(param1Locale.getCountry());
/*  846 */       param1Output.writeString(param1Locale.getVariant());
/*      */     }
/*      */     
/*      */     public Locale read(Kryo param1Kryo, Input param1Input, Class<? extends Locale> param1Class) {
/*  850 */       String str1 = param1Input.readString();
/*  851 */       String str3 = param1Input.readString();
/*  852 */       String str2 = param1Input.readString();
/*  853 */       return create(str1, str3, str2);
/*      */     }
/*      */     
/*      */     protected static boolean isSameLocale(Locale param1Locale, String param1String1, String param1String2, String param1String3) {
/*  857 */       if (param1Locale.getLanguage().equals(param1String1) && param1Locale.getCountry().equals(param1String2) && param1Locale
/*  858 */         .getVariant().equals(param1String3)) return true; 
/*      */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   public static class CharsetSerializer extends ImmutableSerializer<Charset> {
/*      */     public void write(Kryo param1Kryo, Output param1Output, Charset param1Charset) {
/*  865 */       param1Output.writeString(param1Charset.name());
/*      */     }
/*      */     
/*      */     public Charset read(Kryo param1Kryo, Input param1Input, Class<? extends Charset> param1Class) {
/*  869 */       return Charset.forName(param1Input.readString());
/*      */     }
/*      */   }
/*      */   
/*      */   public static class URLSerializer
/*      */     extends ImmutableSerializer<URL> {
/*      */     public void write(Kryo param1Kryo, Output param1Output, URL param1URL) {
/*  876 */       param1Output.writeString(param1URL.toExternalForm());
/*      */     }
/*      */     
/*      */     public URL read(Kryo param1Kryo, Input param1Input, Class<? extends URL> param1Class) {
/*      */       try {
/*  881 */         return new URL(param1Input.readString());
/*  882 */       } catch (MalformedURLException malformedURLException) {
/*  883 */         throw new KryoException(malformedURLException);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public static class ArraysAsListSerializer
/*      */     extends CollectionSerializer<List> {
/*      */     protected List create(Kryo param1Kryo, Input param1Input, Class param1Class, int param1Int) {
/*  891 */       return new ArrayList(param1Int);
/*      */     }
/*      */     
/*      */     public List read(Kryo param1Kryo, Input param1Input, Class<? extends List> param1Class) {
/*      */       List list;
/*  896 */       if ((list = super.read(param1Kryo, param1Input, param1Class)) == null) return null; 
/*  897 */       return Arrays.asList(list.toArray());
/*      */     }
/*      */     
/*      */     public List copy(Kryo param1Kryo, List param1List) {
/*      */       Object[] arrayOfObject;
/*  902 */       List list = Arrays.asList(arrayOfObject = new Object[param1List.size()]);
/*  903 */       param1Kryo.reference(list);
/*  904 */       for (byte b = 0; b < param1List.size(); b++) {
/*  905 */         arrayOfObject[b] = param1Kryo.copy(param1List.get(b));
/*      */       }
/*  907 */       return list;
/*      */     }
/*      */   }
/*      */   
/*      */   public static class BitSetSerializer
/*      */     extends Serializer<BitSet> {
/*      */     public void write(Kryo param1Kryo, Output param1Output, BitSet param1BitSet) {
/*  914 */       long[] arrayOfLong = param1BitSet.toLongArray();
/*  915 */       param1Output.writeVarInt(arrayOfLong.length, true);
/*  916 */       param1Output.writeLongs(arrayOfLong, 0, arrayOfLong.length);
/*      */     }
/*      */     
/*      */     public BitSet read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/*  920 */       int i = param1Input.readVarInt(true);
/*      */       long[] arrayOfLong;
/*  922 */       return BitSet.valueOf(arrayOfLong = param1Input.readLongs(i));
/*      */     }
/*      */     
/*      */     public BitSet copy(Kryo param1Kryo, BitSet param1BitSet) {
/*  926 */       return BitSet.valueOf(param1BitSet.toLongArray());
/*      */     }
/*      */   }
/*      */   
/*      */   public static class PatternSerializer
/*      */     extends ImmutableSerializer<Pattern> {
/*      */     public void write(Kryo param1Kryo, Output param1Output, Pattern param1Pattern) {
/*  933 */       param1Output.writeString(param1Pattern.pattern());
/*  934 */       param1Output.writeInt(param1Pattern.flags(), true);
/*      */     }
/*      */     
/*      */     public Pattern read(Kryo param1Kryo, Input param1Input, Class<? extends Pattern> param1Class) {
/*  938 */       String str = param1Input.readString();
/*  939 */       int i = param1Input.readInt(true);
/*  940 */       return Pattern.compile(str, i);
/*      */     }
/*      */   }
/*      */   
/*      */   public static class URISerializer
/*      */     extends ImmutableSerializer<URI> {
/*      */     public void write(Kryo param1Kryo, Output param1Output, URI param1URI) {
/*  947 */       param1Output.writeString(param1URI.toString());
/*      */     }
/*      */     
/*      */     public URI read(Kryo param1Kryo, Input param1Input, Class<? extends URI> param1Class) {
/*      */       try {
/*  952 */         return new URI(param1Input.readString());
/*  953 */       } catch (URISyntaxException uRISyntaxException) {
/*  954 */         throw new KryoException(uRISyntaxException);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public static class UUIDSerializer
/*      */     extends ImmutableSerializer<UUID> {
/*      */     public void write(Kryo param1Kryo, Output param1Output, UUID param1UUID) {
/*  962 */       param1Output.writeLong(param1UUID.getMostSignificantBits());
/*  963 */       param1Output.writeLong(param1UUID.getLeastSignificantBits());
/*      */     }
/*      */     
/*      */     public UUID read(Kryo param1Kryo, Input param1Input, Class<? extends UUID> param1Class) {
/*  967 */       return new UUID(param1Input.readLong(), param1Input.readLong());
/*      */     }
/*      */   }
/*      */   
/*      */   public static class AtomicBooleanSerializer
/*      */     extends Serializer<AtomicBoolean> {
/*      */     public void write(Kryo param1Kryo, Output param1Output, AtomicBoolean param1AtomicBoolean) {
/*  974 */       param1Output.writeBoolean(param1AtomicBoolean.get());
/*      */     }
/*      */     
/*      */     public AtomicBoolean read(Kryo param1Kryo, Input param1Input, Class<? extends AtomicBoolean> param1Class) {
/*  978 */       return new AtomicBoolean(param1Input.readBoolean());
/*      */     }
/*      */     
/*      */     public AtomicBoolean copy(Kryo param1Kryo, AtomicBoolean param1AtomicBoolean) {
/*  982 */       return new AtomicBoolean(param1AtomicBoolean.get());
/*      */     }
/*      */   }
/*      */   
/*      */   public static class AtomicIntegerSerializer
/*      */     extends Serializer<AtomicInteger> {
/*      */     public void write(Kryo param1Kryo, Output param1Output, AtomicInteger param1AtomicInteger) {
/*  989 */       param1Output.writeInt(param1AtomicInteger.get());
/*      */     }
/*      */     
/*      */     public AtomicInteger read(Kryo param1Kryo, Input param1Input, Class<? extends AtomicInteger> param1Class) {
/*  993 */       return new AtomicInteger(param1Input.readInt());
/*      */     }
/*      */     
/*      */     public AtomicInteger copy(Kryo param1Kryo, AtomicInteger param1AtomicInteger) {
/*  997 */       return new AtomicInteger(param1AtomicInteger.get());
/*      */     }
/*      */   }
/*      */   
/*      */   public static class AtomicLongSerializer
/*      */     extends Serializer<AtomicLong> {
/*      */     public void write(Kryo param1Kryo, Output param1Output, AtomicLong param1AtomicLong) {
/* 1004 */       param1Output.writeLong(param1AtomicLong.get());
/*      */     }
/*      */     
/*      */     public AtomicLong read(Kryo param1Kryo, Input param1Input, Class<? extends AtomicLong> param1Class) {
/* 1008 */       return new AtomicLong(param1Input.readLong());
/*      */     }
/*      */     
/*      */     public AtomicLong copy(Kryo param1Kryo, AtomicLong param1AtomicLong) {
/* 1012 */       return new AtomicLong(param1AtomicLong.get());
/*      */     }
/*      */   }
/*      */   
/*      */   public static class AtomicReferenceSerializer
/*      */     extends Serializer<AtomicReference> {
/*      */     public void write(Kryo param1Kryo, Output param1Output, AtomicReference param1AtomicReference) {
/* 1019 */       param1Kryo.writeClassAndObject(param1Output, param1AtomicReference.get());
/*      */     }
/*      */     
/*      */     public AtomicReference read(Kryo param1Kryo, Input param1Input, Class<? extends AtomicReference> param1Class) {
/* 1023 */       Object object = param1Kryo.readClassAndObject(param1Input);
/* 1024 */       return new AtomicReference(object);
/*      */     }
/*      */     
/*      */     public AtomicReference copy(Kryo param1Kryo, AtomicReference param1AtomicReference) {
/* 1028 */       return new AtomicReference(param1Kryo.copy(param1AtomicReference.get()));
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\DefaultSerializers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */