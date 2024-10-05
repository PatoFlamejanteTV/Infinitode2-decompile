/*      */ package com.vladsch.flexmark.util.misc;
/*      */ 
/*      */ import java.io.InvalidObjectException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.Serializable;
/*      */ import java.lang.reflect.Field;
/*      */ import java.util.AbstractSet;
/*      */ import java.util.Collection;
/*      */ import java.util.Iterator;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class BitFieldSet<E extends Enum<E>>
/*      */   extends AbstractSet<E>
/*      */   implements Serializable, Cloneable
/*      */ {
/*      */   private static final long serialVersionUID = 3411599620347842686L;
/*      */   
/*      */   static class UniverseLoader
/*      */   {
/*   34 */     static final ConcurrentHashMap<Class, Enum[]> enumUniverseMap = (ConcurrentHashMap)new ConcurrentHashMap<>();
/*   35 */     static final ConcurrentHashMap<Class, long[]> enumBitMasksMap = (ConcurrentHashMap)new ConcurrentHashMap<>();
/*      */ 
/*      */     
/*      */     public static Enum[] getUniverseSlow(Class param1Class) {
/*      */       Enum<?>[] arrayOfEnum;
/*   40 */       assert param1Class.isEnum();
/*      */       Enum[] arrayOfEnum1;
/*   42 */       if ((arrayOfEnum1 = enumUniverseMap.get(param1Class)) != null) return arrayOfEnum1;
/*      */       
/*   44 */       Field[] arrayOfField1 = param1Class.getFields();
/*   45 */       byte b1 = 0; Field[] arrayOfField2; int i; byte b2;
/*   46 */       for (i = (arrayOfField2 = arrayOfField1).length, b2 = 0; b2 < i; b2++) {
/*   47 */         Field field; if ((field = arrayOfField2[b2]).getType().isEnum()) b1++;
/*      */       
/*      */       } 
/*   50 */       if (b1 > 0) {
/*   51 */         arrayOfEnum1 = new Enum[b1];
/*      */         
/*   53 */         b1 = 0;
/*   54 */         for (i = (arrayOfField2 = arrayOfField1).length, b2 = 0; b2 < i; b2++) {
/*   55 */           Field field; if ((field = arrayOfField2[b2]).getType().isEnum())
/*      */           {
/*   57 */             arrayOfEnum1[b1++] = Enum.valueOf(field.getType(), field.getName());
/*      */           }
/*      */         } 
/*      */       } else {
/*   61 */         arrayOfEnum = BitFieldSet.ZERO_LENGTH_ENUM_ARRAY;
/*      */       } 
/*      */       
/*   64 */       enumUniverseMap.put(param1Class, arrayOfEnum);
/*   65 */       return (Enum[])arrayOfEnum;
/*      */     }
/*      */   }
/*      */   
/*      */   public static long nextBitMask(int paramInt1, int paramInt2) {
/*   70 */     return -1L >>> -paramInt2 << paramInt1;
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
/*      */   public static <E extends Enum<E>> E[] getUniverse(Class<E> paramClass) {
/*   82 */     return (E[])UniverseLoader.getUniverseSlow(paramClass);
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
/*      */   public static <E extends Enum<E>> long[] getBitMasks(Class<E> paramClass) {
/*      */     long[] arrayOfLong;
/*   95 */     if ((arrayOfLong = UniverseLoader.enumBitMasksMap.get(paramClass)) != null) return arrayOfLong;
/*      */ 
/*      */ 
/*      */     
/*   99 */     Enum[] arrayOfEnum = UniverseLoader.getUniverseSlow(paramClass);
/*  100 */     if (BitField.class.isAssignableFrom(paramClass)) {
/*  101 */       int i = 0;
/*  102 */       arrayOfLong = new long[arrayOfEnum.length]; int j;
/*      */       byte b;
/*  104 */       for (j = (arrayOfEnum = arrayOfEnum).length, b = 0; b < j; b++) {
/*      */         Enum enum_; int k;
/*  106 */         if ((k = ((BitField)(enum_ = arrayOfEnum[b])).getBits()) <= 0) {
/*  107 */           throw new IllegalArgumentException(String.format("Enum bit field %s.%s bits must be >= 1, got: %d", new Object[] { paramClass.getSimpleName(), enum_.name(), Integer.valueOf(k) }));
/*      */         }
/*  109 */         if (i + k > 64) {
/*  110 */           throw new IllegalArgumentException(String.format("Enum bit field %s.%s bits exceed available 64 bits by %d", new Object[] { paramClass.getSimpleName(), enum_.name(), Integer.valueOf(i + k - 64) }));
/*      */         }
/*  112 */         arrayOfLong[enum_.ordinal()] = nextBitMask(i, k);
/*      */         
/*  114 */         i += k;
/*      */       }
/*      */     
/*  117 */     } else if (arrayOfEnum.length <= 64) {
/*  118 */       arrayOfLong = new long[arrayOfEnum.length]; int i; Enum[] arrayOfEnum1; byte b;
/*  119 */       for (i = (arrayOfEnum1 = arrayOfEnum).length, b = 0; b < i; ) { Enum enum_ = arrayOfEnum1[b];
/*  120 */         arrayOfLong[enum_.ordinal()] = 1L << enum_.ordinal(); b++; }
/*      */     
/*      */     } else {
/*  123 */       throw new IllegalArgumentException("Enums with more than 64 values are not supported");
/*      */     } 
/*      */     
/*  126 */     UniverseLoader.enumBitMasksMap.put(paramClass, arrayOfLong);
/*  127 */     return arrayOfLong;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  134 */   long elements = 0L;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final Class<E> elementType;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final E[] universe;
/*      */ 
/*      */ 
/*      */   
/*      */   final long[] bitMasks;
/*      */ 
/*      */ 
/*      */   
/*      */   final int totalBits;
/*      */ 
/*      */ 
/*      */   
/*  156 */   static final Enum<?>[] ZERO_LENGTH_ENUM_ARRAY = (Enum<?>[])new Enum[0];
/*      */   
/*      */   BitFieldSet(Class<E> paramClass, Enum<?>[] paramArrayOfEnum, long[] paramArrayOflong) {
/*  159 */     this.elementType = paramClass;
/*      */     
/*  161 */     this.universe = (E[])paramArrayOfEnum;
/*  162 */     this.bitMasks = paramArrayOflong;
/*  163 */     this.totalBits = getTotalBits(paramArrayOflong);
/*      */   }
/*      */   
/*      */   public static int getTotalBits(long[] paramArrayOflong) {
/*  167 */     return (paramArrayOflong.length == 0) ? 0 : (64 - Long.numberOfLeadingZeros(paramArrayOflong[paramArrayOflong.length - 1]));
/*      */   }
/*      */ 
/*      */   
/*      */   void addRange(E paramE1, E paramE2) {
/*  172 */     this.elements = -1L >>> paramE1.ordinal() - paramE2.ordinal() - 1 << paramE1.ordinal();
/*      */   }
/*      */   
/*      */   void addAll() {
/*  176 */     if (this.totalBits != 0)
/*  177 */       this.elements = -1L >>> -this.totalBits; 
/*      */   }
/*      */   
/*      */   public void complement() {
/*  181 */     if (this.totalBits != 0) {
/*  182 */       this.elements ^= 0xFFFFFFFFFFFFFFFFL;
/*  183 */       this.elements &= -1L >>> -this.totalBits;
/*      */     } 
/*      */   }
/*      */   
/*      */   public long toLong() {
/*  188 */     return this.elements;
/*      */   }
/*      */   
/*      */   public int toInt() {
/*  192 */     if (this.totalBits > 32)
/*  193 */       throw new IllegalArgumentException(String.format("Enum fields use %d bits, which is more than 32 bits available in an int", new Object[] { Integer.valueOf(this.totalBits) })); 
/*  194 */     return (int)this.elements;
/*      */   }
/*      */   
/*      */   public short toShort() {
/*  198 */     if (this.totalBits > 16)
/*  199 */       throw new IllegalArgumentException(String.format("Enum fields use %d bits, which is more than 16 bits available in a short", new Object[] { Integer.valueOf(this.totalBits) })); 
/*  200 */     return (short)(int)this.elements;
/*      */   }
/*      */   
/*      */   public byte toByte() {
/*  204 */     if (this.totalBits > 8)
/*  205 */       throw new IllegalArgumentException(String.format("Enum fields use %d bits, which is more than 8 bits available in a byte", new Object[] { Integer.valueOf(this.totalBits) })); 
/*  206 */     return (byte)(int)this.elements;
/*      */   }
/*      */   
/*      */   public long allBitsMask() {
/*  210 */     return -1L >>> -this.totalBits;
/*      */   }
/*      */   
/*      */   public boolean orMask(long paramLong) {
/*  214 */     long l1 = -1L >>> -this.totalBits;
/*  215 */     if ((paramLong & (l1 ^ 0xFFFFFFFFFFFFFFFFL)) != 0L) {
/*  216 */       throw new IllegalArgumentException(String.format("bitMask %d value contains elements outside the universe %s", new Object[] { Long.valueOf(paramLong), Long.toBinaryString(paramLong & (l1 ^ 0xFFFFFFFFFFFFFFFFL)) }));
/*      */     }
/*      */     
/*  219 */     long l2 = this.elements;
/*  220 */     this.elements |= paramLong;
/*  221 */     return (l2 != this.elements);
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
/*      */   @Deprecated
/*      */   public boolean replaceAll(long paramLong) {
/*  234 */     return setAll(paramLong);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean setAll(long paramLong) {
/*  239 */     long l1 = -1L >>> -this.totalBits;
/*  240 */     if ((paramLong & (l1 ^ 0xFFFFFFFFFFFFFFFFL)) != 0L) {
/*  241 */       throw new IllegalArgumentException(String.format("mask %d(0b%s) value contains elements outside the universe 0b%s", new Object[] { Long.valueOf(paramLong), Long.toBinaryString(paramLong), Long.toBinaryString(paramLong & (l1 ^ 0xFFFFFFFFFFFFFFFFL)) }));
/*      */     }
/*      */     
/*  244 */     long l2 = this.elements;
/*  245 */     this.elements = paramLong;
/*  246 */     return (l2 != this.elements);
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/*  251 */     if (this.elements == 0L) {
/*  252 */       return this.elementType.getSimpleName() + ": { }";
/*      */     }
/*      */     
/*      */     DelimitedBuilder delimitedBuilder;
/*  256 */     (delimitedBuilder = new DelimitedBuilder(", ")).append(this.elementType.getSimpleName()).append(": { "); E[] arrayOfE; int i; byte b;
/*  257 */     for (i = (arrayOfE = this.universe).length, b = 0; b < i; ) { E e = arrayOfE[b];
/*  258 */       if (any(mask(e))) {
/*  259 */         delimitedBuilder.append(e.name());
/*  260 */         if (e instanceof BitField && ((BitField)e).getBits() > 1) {
/*  261 */           delimitedBuilder.append("(").append(getLong(e)).append(")");
/*      */         }
/*  263 */         delimitedBuilder.mark();
/*      */       }  b++; }
/*      */     
/*  266 */     delimitedBuilder.unmark().append(" }");
/*  267 */     return delimitedBuilder.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean andNotMask(long paramLong) {
/*  272 */     long l = this.elements;
/*  273 */     this.elements &= paramLong ^ 0xFFFFFFFFFFFFFFFFL;
/*  274 */     return (l != this.elements);
/*      */   }
/*      */   
/*      */   public boolean any(long paramLong) {
/*  278 */     return ((this.elements & paramLong) != 0L);
/*      */   }
/*      */   
/*      */   public boolean none(long paramLong) {
/*  282 */     return ((this.elements & paramLong) == 0L);
/*      */   }
/*      */   
/*      */   public boolean all(long paramLong) {
/*  286 */     long l = -1L >>> -this.totalBits;
/*  287 */     if ((paramLong & (l ^ 0xFFFFFFFFFFFFFFFFL)) != 0L) {
/*  288 */       throw new IllegalArgumentException(String.format("mask %d(0b%s) value contains elements outside the universe 0b%s", new Object[] { Long.valueOf(paramLong), Long.toBinaryString(paramLong), Long.toBinaryString(paramLong & (l ^ 0xFFFFFFFFFFFFFFFFL)) }));
/*      */     }
/*  290 */     return ((this.elements & paramLong) == paramLong);
/*      */   }
/*      */ 
/*      */   
/*      */   public static <E extends Enum<E>> long longMask(E paramE) {
/*      */     long[] arrayOfLong;
/*  296 */     return (arrayOfLong = getBitMasks(paramE.getDeclaringClass()))[paramE.ordinal()];
/*      */   }
/*      */   
/*      */   public static <E extends Enum<E>> int intMask(E paramE) {
/*      */     long[] arrayOfLong;
/*      */     int i;
/*  302 */     if ((i = getTotalBits(arrayOfLong = getBitMasks(paramE.getDeclaringClass()))) > 32)
/*  303 */       throw new IllegalArgumentException(String.format("Enum fields use %d, which is more than 32 available in int", new Object[] { Integer.valueOf(i) })); 
/*  304 */     return (int)arrayOfLong[paramE.ordinal()];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long get(E paramE) {
/*  314 */     long l = this.bitMasks[paramE.ordinal()];
/*  315 */     return (this.elements & l) >>> Long.numberOfTrailingZeros(l);
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
/*      */   public boolean setUnsigned(E paramE, long paramLong) {
/*  327 */     long l = this.elements;
/*  328 */     this.elements = setUnsigned(this.elementType, this.bitMasks, this.elements, paramE, paramLong);
/*  329 */     return (l != this.elements);
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
/*      */   public boolean setSigned(E paramE, long paramLong) {
/*  341 */     long l = this.elements;
/*  342 */     this.elements = setSigned(this.elementType, this.bitMasks, this.elements, paramE, paramLong);
/*  343 */     return (l != this.elements);
/*      */   }
/*      */   
/*      */   public void setBitField(E paramE, long paramLong) {
/*  347 */     setSigned(paramE, paramLong);
/*      */   }
/*      */   
/*      */   public void setBitField(E paramE, int paramInt) {
/*  351 */     setSigned(paramE, paramInt);
/*      */   }
/*      */   
/*      */   public void setBitField(E paramE, short paramShort) {
/*  355 */     setSigned(paramE, paramShort);
/*      */   }
/*      */   
/*      */   public void setBitField(E paramE, byte paramByte) {
/*  359 */     setSigned(paramE, paramByte);
/*      */   }
/*      */   
/*      */   public void setUnsignedField(E paramE, long paramLong) {
/*  363 */     setUnsigned(paramE, paramLong);
/*      */   }
/*      */   
/*      */   public void setUnsignedField(E paramE, int paramInt) {
/*  367 */     setUnsigned(paramE, paramInt);
/*      */   }
/*      */   
/*      */   public void setUnsignedField(E paramE, short paramShort) {
/*  371 */     setUnsigned(paramE, paramShort);
/*      */   }
/*      */   
/*      */   public void setUnsignedField(E paramE, byte paramByte) {
/*  375 */     setUnsigned(paramE, paramByte);
/*      */   }
/*      */   
/*      */   public long getUnsigned(E paramE, int paramInt, String paramString) {
/*  379 */     return getUnsignedBitField(this.elements, paramE, paramInt, paramString);
/*      */   }
/*      */   
/*      */   public long getSigned(E paramE, int paramInt, String paramString) {
/*  383 */     return getSignedBitField(this.elements, paramE, paramInt, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getLong(E paramE) {
/*  393 */     return getSigned(paramE, 64, "long");
/*      */   }
/*      */   
/*      */   public int getInt(E paramE) {
/*  397 */     return (int)getSigned(paramE, 32, "int");
/*      */   }
/*      */   
/*      */   public short getShort(E paramE) {
/*  401 */     return (short)(int)getSigned(paramE, 16, "short");
/*      */   }
/*      */   
/*      */   public byte getByte(E paramE) {
/*  405 */     return (byte)(int)getSigned(paramE, 8, "byte");
/*      */   }
/*      */   
/*      */   public int getUInt(E paramE) {
/*  409 */     return (int)getSigned(paramE, 32, "int");
/*      */   }
/*      */   
/*      */   public short getUShort(E paramE) {
/*  413 */     return (short)(int)getSigned(paramE, 16, "short");
/*      */   }
/*      */   
/*      */   public byte getUByte(E paramE) {
/*  417 */     return (byte)(int)getSigned(paramE, 8, "byte");
/*      */   }
/*      */   
/*      */   public static long orMask(long paramLong1, long paramLong2) {
/*  421 */     return paramLong1 | paramLong2;
/*      */   }
/*      */   
/*      */   public static long andNotMask(long paramLong1, long paramLong2) {
/*  425 */     return paramLong1 & (paramLong2 ^ 0xFFFFFFFFFFFFFFFFL);
/*      */   }
/*      */   
/*      */   public static boolean any(long paramLong1, long paramLong2) {
/*  429 */     return ((paramLong1 & paramLong2) != 0L);
/*      */   }
/*      */   
/*      */   public static boolean all(long paramLong1, long paramLong2) {
/*  433 */     return ((paramLong1 & paramLong2) == paramLong2);
/*      */   }
/*      */   
/*      */   public static boolean none(long paramLong1, long paramLong2) {
/*  437 */     return ((paramLong1 & paramLong2) == 0L);
/*      */   }
/*      */   public long mask(E paramE) {
/*  440 */     return this.bitMasks[paramE.ordinal()];
/*      */   } public long mask(E paramE1, E paramE2) {
/*  442 */     return this.bitMasks[paramE1.ordinal()] | this.bitMasks[paramE2.ordinal()];
/*      */   } public long mask(E paramE1, E paramE2, E paramE3) {
/*  444 */     return this.bitMasks[paramE1.ordinal()] | this.bitMasks[paramE2.ordinal()] | this.bitMasks[paramE3.ordinal()];
/*      */   } public long mask(E paramE1, E paramE2, E paramE3, E paramE4) {
/*  446 */     return this.bitMasks[paramE1.ordinal()] | this.bitMasks[paramE2.ordinal()] | this.bitMasks[paramE3.ordinal()] | this.bitMasks[paramE4.ordinal()];
/*      */   } public long mask(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5) {
/*  448 */     return this.bitMasks[paramE1.ordinal()] | this.bitMasks[paramE2.ordinal()] | this.bitMasks[paramE3.ordinal()] | this.bitMasks[paramE4.ordinal()] | this.bitMasks[paramE5.ordinal()];
/*      */   }
/*      */   @SafeVarargs
/*      */   public final long mask(E... paramVarArgs) {
/*  452 */     long l = 0L; int i; byte b;
/*  453 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { E e = paramVarArgs[b];
/*  454 */       l |= this.bitMasks[e.ordinal()]; b++; }
/*      */     
/*  456 */     return l;
/*      */   }
/*      */   public boolean add(E paramE1, E paramE2) {
/*  459 */     return orMask(mask(paramE1, paramE2));
/*      */   } public boolean add(E paramE1, E paramE2, E paramE3) {
/*  461 */     return orMask(mask(paramE1, paramE2, paramE3));
/*      */   } public boolean add(E paramE1, E paramE2, E paramE3, E paramE4) {
/*  463 */     return orMask(mask(paramE1, paramE2, paramE3, paramE4));
/*      */   } public boolean add(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5) {
/*  465 */     return orMask(mask(paramE1, paramE2, paramE3, paramE4, paramE5));
/*      */   } @SafeVarargs
/*      */   public final boolean add(E... paramVarArgs) {
/*  468 */     return orMask(mask(paramVarArgs));
/*      */   } public boolean remove(E paramE1, E paramE2) {
/*  470 */     return andNotMask(mask(paramE1, paramE2));
/*      */   } public boolean remove(E paramE1, E paramE2, E paramE3) {
/*  472 */     return andNotMask(mask(paramE1, paramE2, paramE3));
/*      */   } public boolean remove(E paramE1, E paramE2, E paramE3, E paramE4) {
/*  474 */     return andNotMask(mask(paramE1, paramE2, paramE3, paramE4));
/*      */   } public boolean remove(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5) {
/*  476 */     return andNotMask(mask(paramE1, paramE2, paramE3, paramE4, paramE5));
/*      */   } @SafeVarargs
/*      */   public final boolean remove(E... paramVarArgs) {
/*  479 */     return andNotMask(mask(paramVarArgs));
/*      */   } public boolean any(E paramE) {
/*  481 */     return any(mask(paramE));
/*      */   } public boolean any(E paramE1, E paramE2) {
/*  483 */     return any(mask(paramE1, paramE2));
/*      */   } public boolean any(E paramE1, E paramE2, E paramE3) {
/*  485 */     return any(mask(paramE1, paramE2, paramE3));
/*      */   } public boolean any(E paramE1, E paramE2, E paramE3, E paramE4) {
/*  487 */     return any(mask(paramE1, paramE2, paramE3, paramE4));
/*      */   } public boolean any(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5) {
/*  489 */     return any(mask(paramE1, paramE2, paramE3, paramE4, paramE5));
/*      */   } @SafeVarargs
/*      */   public final boolean any(E... paramVarArgs) {
/*  492 */     return any(mask(paramVarArgs));
/*      */   } public boolean all(E paramE) {
/*  494 */     return all(mask(paramE));
/*      */   } public boolean all(E paramE1, E paramE2) {
/*  496 */     return all(mask(paramE1, paramE2));
/*      */   } public boolean all(E paramE1, E paramE2, E paramE3) {
/*  498 */     return all(mask(paramE1, paramE2, paramE3));
/*      */   } public boolean all(E paramE1, E paramE2, E paramE3, E paramE4) {
/*  500 */     return all(mask(paramE1, paramE2, paramE3, paramE4));
/*      */   } public boolean all(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5) {
/*  502 */     return all(mask(paramE1, paramE2, paramE3, paramE4, paramE5));
/*      */   } @SafeVarargs
/*      */   public final boolean all(E... paramVarArgs) {
/*  505 */     return all(mask(paramVarArgs));
/*      */   } public boolean none(E paramE) {
/*  507 */     return none(mask(paramE));
/*      */   } public boolean none(E paramE1, E paramE2) {
/*  509 */     return none(mask(paramE1, paramE2));
/*      */   } public boolean none(E paramE1, E paramE2, E paramE3) {
/*  511 */     return none(mask(paramE1, paramE2, paramE3));
/*      */   } public boolean none(E paramE1, E paramE2, E paramE3, E paramE4) {
/*  513 */     return none(mask(paramE1, paramE2, paramE3, paramE4));
/*      */   } public boolean none(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5) {
/*  515 */     return none(mask(paramE1, paramE2, paramE3, paramE4, paramE5));
/*      */   } @SafeVarargs
/*      */   public final boolean none(E... paramVarArgs) {
/*  518 */     return none(mask(paramVarArgs));
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
/*      */   public Iterator<E> iterator() {
/*  534 */     return (Iterator<E>)((this.bitMasks.length == this.totalBits) ? new EnumBitSetIterator<>() : new EnumBitFieldIterator<>());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private class EnumBitSetIterator<E extends Enum<E>>
/*      */     implements Iterator<E>
/*      */   {
/*      */     long unseen;
/*      */ 
/*      */ 
/*      */     
/*  548 */     long lastReturned = 0L;
/*      */     
/*      */     EnumBitSetIterator() {
/*  551 */       this.unseen = BitFieldSet.this.elements;
/*      */     }
/*      */     
/*      */     public boolean hasNext() {
/*  555 */       return (this.unseen != 0L);
/*      */     }
/*      */ 
/*      */     
/*      */     public E next() {
/*  560 */       if (this.unseen == 0L)
/*  561 */         throw new NoSuchElementException(); 
/*  562 */       this.lastReturned = this.unseen & -this.unseen;
/*  563 */       this.unseen -= this.lastReturned;
/*  564 */       return BitFieldSet.this.universe[Long.numberOfTrailingZeros(this.lastReturned)];
/*      */     }
/*      */     
/*      */     public void remove() {
/*  568 */       if (this.lastReturned == 0L)
/*  569 */         throw new IllegalStateException(); 
/*  570 */       BitFieldSet.this.elements &= this.lastReturned ^ 0xFFFFFFFFFFFFFFFFL;
/*  571 */       this.lastReturned = 0L;
/*      */     }
/*      */   }
/*      */   
/*      */   private class EnumBitFieldIterator<E extends Enum<E>> implements Iterator<E> {
/*      */     int nextIndex;
/*  577 */     int lastReturnedIndex = -1;
/*      */     
/*      */     EnumBitFieldIterator() {
/*  580 */       this.nextIndex = -1;
/*  581 */       findNext();
/*      */     }
/*      */     
/*      */     public boolean hasNext() {
/*  585 */       return (this.nextIndex < BitFieldSet.this.universe.length);
/*      */     }
/*      */ 
/*      */     
/*      */     public E next() {
/*  590 */       if (this.nextIndex >= BitFieldSet.this.universe.length) {
/*  591 */         throw new NoSuchElementException();
/*      */       }
/*  593 */       this.lastReturnedIndex = this.nextIndex;
/*  594 */       findNext();
/*      */       
/*  596 */       return BitFieldSet.this.universe[this.lastReturnedIndex];
/*      */     }
/*      */     
/*      */     void findNext() {
/*      */       do {
/*  601 */         this.nextIndex++;
/*  602 */       } while (this.nextIndex < BitFieldSet.this.universe.length && (
/*  603 */         BitFieldSet.this.elements & BitFieldSet.this.bitMasks[this.nextIndex]) == 0L);
/*      */     }
/*      */     
/*      */     public void remove() {
/*  607 */       if (this.lastReturnedIndex == -1)
/*  608 */         throw new IllegalStateException(); 
/*  609 */       BitFieldSet.this.elements &= BitFieldSet.this.bitMasks[this.lastReturnedIndex] ^ 0xFFFFFFFFFFFFFFFFL;
/*  610 */       this.lastReturnedIndex = -1;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int size() {
/*  620 */     return this.totalBits;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmpty() {
/*  629 */     return (this.elements == 0L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean contains(Object paramObject) {
/*  639 */     if (paramObject == null)
/*  640 */       return false; 
/*      */     Class<?> clazz;
/*  642 */     if ((clazz = paramObject.getClass()) != this.elementType && clazz.getSuperclass() != this.elementType) {
/*  643 */       return false;
/*      */     }
/*  645 */     return ((this.elements & this.bitMasks[((Enum)paramObject).ordinal()]) != 0L);
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
/*      */   public boolean add(E paramE) {
/*  658 */     typeCheck(paramE);
/*      */     
/*  660 */     long l = this.elements;
/*  661 */     this.elements |= this.bitMasks[paramE.ordinal()];
/*  662 */     return (this.elements != l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean remove(Object paramObject) {
/*  672 */     if (paramObject == null)
/*  673 */       return false; 
/*      */     Class<?> clazz;
/*  675 */     if ((clazz = paramObject.getClass()) != this.elementType && clazz.getSuperclass() != this.elementType) {
/*  676 */       return false;
/*      */     }
/*  678 */     long l = this.elements;
/*  679 */     this.elements &= this.bitMasks[((Enum)paramObject).ordinal()] ^ 0xFFFFFFFFFFFFFFFFL;
/*  680 */     return (this.elements != l);
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
/*      */   public boolean containsAll(Collection<?> paramCollection) {
/*  695 */     if (!(paramCollection instanceof BitFieldSet)) {
/*  696 */       return super.containsAll(paramCollection);
/*      */     }
/*      */     
/*  699 */     if (((BitFieldSet)(paramCollection = paramCollection)).elementType != this.elementType) {
/*  700 */       return paramCollection.isEmpty();
/*      */     }
/*  702 */     return ((((BitFieldSet)paramCollection).elements & (this.elements ^ 0xFFFFFFFFFFFFFFFFL)) == 0L);
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
/*      */   public boolean addAll(Collection<? extends E> paramCollection) {
/*  714 */     if (!(paramCollection instanceof BitFieldSet)) {
/*  715 */       return super.addAll(paramCollection);
/*      */     }
/*      */     
/*  718 */     if (((BitFieldSet)(paramCollection = paramCollection)).elementType != this.elementType) {
/*  719 */       if (paramCollection.isEmpty()) {
/*  720 */         return false;
/*      */       }
/*  722 */       throw new ClassCastException(paramCollection.elementType + " != " + this.elementType);
/*      */     } 
/*      */ 
/*      */     
/*  726 */     long l = this.elements;
/*  727 */     this.elements |= ((BitFieldSet)paramCollection).elements;
/*  728 */     return (this.elements != l);
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
/*      */   public boolean removeAll(Collection<?> paramCollection) {
/*  740 */     if (!(paramCollection instanceof BitFieldSet)) {
/*  741 */       return super.removeAll(paramCollection);
/*      */     }
/*      */     
/*  744 */     if (((BitFieldSet)(paramCollection = paramCollection)).elementType != this.elementType) {
/*  745 */       return false;
/*      */     }
/*  747 */     long l = this.elements;
/*  748 */     this.elements &= ((BitFieldSet)paramCollection).elements ^ 0xFFFFFFFFFFFFFFFFL;
/*  749 */     return (this.elements != l);
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
/*      */   public boolean retainAll(Collection<?> paramCollection) {
/*  761 */     if (!(paramCollection instanceof BitFieldSet)) {
/*  762 */       return super.retainAll(paramCollection);
/*      */     }
/*      */     
/*  765 */     if (((BitFieldSet)(paramCollection = paramCollection)).elementType != this.elementType) {
/*  766 */       boolean bool = (this.elements != 0L) ? true : false;
/*  767 */       this.elements = 0L;
/*  768 */       return bool;
/*      */     } 
/*      */     
/*  771 */     long l = this.elements;
/*  772 */     this.elements &= ((BitFieldSet)paramCollection).elements;
/*  773 */     return (this.elements != l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clear() {
/*  780 */     this.elements = 0L;
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
/*      */   public static <T extends Enum<T>> BitFieldSet<T> of(Class<T> paramClass, long paramLong) {
/*      */     BitFieldSet<T> bitFieldSet;
/*  793 */     (bitFieldSet = noneOf(paramClass)).orMask(paramLong);
/*  794 */     return bitFieldSet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BitFieldSet<E> clone() {
/*      */     try {
/*  805 */       return (BitFieldSet<E>)super.clone();
/*  806 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/*  807 */       throw new AssertionError(cloneNotSupportedException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final void typeCheck(E paramE) {
/*      */     Class<?> clazz;
/*  816 */     if ((clazz = paramE.getClass()) != this.elementType && clazz.getSuperclass() != this.elementType) {
/*  817 */       throw new ClassCastException(clazz + " != " + this.elementType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class SerializationProxy<E extends Enum<E>>
/*      */     implements Serializable
/*      */   {
/*      */     private final Class<E> elementType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final long bits;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static final long serialVersionUID = 362491234563181265L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     SerializationProxy(BitFieldSet<E> param1BitFieldSet) {
/*  847 */       this.elementType = param1BitFieldSet.elementType;
/*  848 */       this.bits = param1BitFieldSet.elements;
/*      */     }
/*      */     
/*      */     private Object readResolve() {
/*      */       BitFieldSet<E> bitFieldSet;
/*  853 */       (bitFieldSet = BitFieldSet.<E>noneOf(this.elementType)).orMask(this.bits);
/*  854 */       return bitFieldSet;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   Object writeReplace() {
/*  861 */     return new SerializationProxy<>(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream paramObjectInputStream) {
/*  868 */     throw new InvalidObjectException("Proxy required");
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
/*      */   public boolean equals(Object paramObject) {
/*  881 */     if (!(paramObject instanceof BitFieldSet)) {
/*  882 */       return super.equals(paramObject);
/*      */     }
/*      */     
/*  885 */     if (((BitFieldSet)(paramObject = paramObject)).elementType != this.elementType)
/*  886 */       return (this.elements == 0L && ((BitFieldSet)paramObject).elements == 0L); 
/*  887 */     return (((BitFieldSet)paramObject).elements == this.elements);
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
/*      */   public static <E extends Enum<E>> BitFieldSet<E> noneOf(Class<E> paramClass) {
/*  900 */     if (!paramClass.isEnum()) {
/*  901 */       throw new ClassCastException(paramClass + " not an enum");
/*      */     }
/*  903 */     Object[] arrayOfObject = getUniverse((Class)paramClass);
/*      */     
/*  905 */     return new BitFieldSet<>(paramClass, (Enum<?>[])arrayOfObject, getBitMasks(paramClass));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static <E extends Enum<E>> long setSigned(long paramLong1, E paramE, long paramLong2) {
/*      */     Class<Enum> clazz;
/*  916 */     long[] arrayOfLong = getBitMasks(clazz = paramE.getDeclaringClass());
/*  917 */     return setSigned(clazz, arrayOfLong, paramLong1, (Enum)paramE, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static <E extends Enum<E>> long setSigned(Class<E> paramClass, long[] paramArrayOflong, long paramLong1, E paramE, long paramLong2) {
/*      */     long l1;
/*  929 */     int i = Long.bitCount(l1 = paramArrayOflong[paramE.ordinal()]);
/*  930 */     long l2 = 1L << i - 1;
/*      */     
/*  932 */     if (i < 64 && (
/*  933 */       paramLong2 < -l2 || paramLong2 > l2 - 1L)) {
/*  934 */       throw new IllegalArgumentException(String.format("Enum field %s.%s is %d bit%s, value range is [%d, %d], cannot be set to %d", new Object[] { paramClass.getSimpleName(), paramE.name(), Integer.valueOf(i), (i > 1) ? "s" : "", Long.valueOf(-l2), Long.valueOf(l2 - 1L), Long.valueOf(paramLong2) }));
/*      */     }
/*      */     
/*  937 */     long l3 = paramLong2 << Long.numberOfTrailingZeros(l1);
/*  938 */     return paramLong1 ^ (paramLong1 ^ l3) & l1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static <E extends Enum<E>> long setUnsigned(long paramLong1, E paramE, long paramLong2) {
/*      */     Class<Enum> clazz;
/*  949 */     long[] arrayOfLong = getBitMasks(clazz = paramE.getDeclaringClass());
/*  950 */     return setUnsigned(clazz, arrayOfLong, paramLong1, (Enum)paramE, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static <E extends Enum<E>> long setUnsigned(Class<E> paramClass, long[] paramArrayOflong, long paramLong1, E paramE, long paramLong2) {
/*      */     long l1;
/*  962 */     int i = Long.bitCount(l1 = paramArrayOflong[paramE.ordinal()]);
/*  963 */     long l2 = 1L << i;
/*      */     
/*  965 */     if (i < 64 && (
/*  966 */       paramLong2 < 0L || paramLong2 >= l2)) {
/*  967 */       throw new IllegalArgumentException(String.format("Enum field %s.%s is %d bit%s, value range is [0, %d), cannot be set to %d", new Object[] { paramClass.getSimpleName(), paramE.name(), Integer.valueOf(i), (i > 1) ? "s" : "", Long.valueOf(l2 - 1L), Long.valueOf(paramLong2) }));
/*      */     }
/*      */     
/*  970 */     long l3 = paramLong2 << Long.numberOfTrailingZeros(l1);
/*  971 */     return paramLong1 ^ (paramLong1 ^ l3) & l1;
/*      */   }
/*      */   
/*      */   public static <E extends Enum<E>> long setBitField(long paramLong, E paramE, int paramInt) {
/*  975 */     return setUnsigned(paramLong, paramE, paramInt);
/*      */   }
/*      */   
/*      */   public static <E extends Enum<E>> int setBitField(int paramInt1, E paramE, int paramInt2) {
/*  979 */     return (int)setUnsigned(paramInt1, paramE, paramInt2);
/*      */   }
/*      */   
/*      */   public static <E extends Enum<E>> short setBitField(short paramShort1, E paramE, short paramShort2) {
/*  983 */     return (short)(int)setUnsigned(paramShort1, paramE, paramShort2);
/*      */   }
/*      */   
/*      */   public static <E extends Enum<E>> byte setBitField(byte paramByte1, E paramE, byte paramByte2) {
/*  987 */     return (byte)(int)setUnsigned(paramByte1, paramE, paramByte2);
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
/*      */   public static <E extends Enum<E>> long getUnsignedBitField(long paramLong, E paramE, int paramInt, String paramString) {
/*      */     Class<Enum> clazz;
/*      */     int i;
/*      */     long[] arrayOfLong;
/*      */     long l;
/* 1006 */     if ((i = Long.bitCount(l = (arrayOfLong = getBitMasks(clazz = paramE.getDeclaringClass()))[paramE.ordinal()])) > paramInt) {
/* 1007 */       throw new IllegalArgumentException(String.format("Enum field %s.%s uses %d, which is more than %d available in %s", new Object[] { clazz.getSimpleName(), paramE.name(), Integer.valueOf(i), Integer.valueOf(paramInt), paramString }));
/*      */     }
/* 1009 */     return (paramLong & l) >>> Long.numberOfTrailingZeros(l);
/*      */   }
/*      */ 
/*      */   
/*      */   static <E extends Enum<E>> long getSignedBitField(long paramLong, E paramE, int paramInt, String paramString) {
/*      */     Class<Enum> clazz;
/*      */     long[] arrayOfLong;
/*      */     int i;
/*      */     long l;
/* 1018 */     if ((i = Long.bitCount(l = (arrayOfLong = getBitMasks(clazz = paramE.getDeclaringClass()))[paramE.ordinal()])) > paramInt) {
/* 1019 */       throw new IllegalArgumentException(String.format("Enum field %s.%s uses %d, which is more than %d available in %s", new Object[] { clazz.getSimpleName(), paramE.name(), Integer.valueOf(i), Integer.valueOf(paramInt), paramString }));
/*      */     }
/* 1021 */     return paramLong << Long.numberOfLeadingZeros(l) >> 64 - i;
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
/*      */   public static <E extends Enum<E>> long getBitField(long paramLong, E paramE) {
/* 1033 */     return getUnsignedBitField(paramLong, paramE, 64, "long");
/*      */   }
/*      */   
/*      */   public static <E extends Enum<E>> int getBitField(int paramInt, E paramE) {
/* 1037 */     return (int)getUnsignedBitField(paramInt, paramE, 32, "int");
/*      */   }
/*      */   
/*      */   public static <E extends Enum<E>> short getBitField(short paramShort, E paramE) {
/* 1041 */     return (short)(int)getUnsignedBitField(paramShort, paramE, 16, "short");
/*      */   }
/*      */   
/*      */   public static <E extends Enum<E>> byte getBitField(byte paramByte, E paramE) {
/* 1045 */     return (byte)(int)getUnsignedBitField(paramByte, paramE, 8, "byte");
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
/*      */   public static <E extends Enum<E>> BitFieldSet<E> allOf(Class<E> paramClass) {
/*      */     BitFieldSet<E> bitFieldSet;
/* 1060 */     (bitFieldSet = noneOf(paramClass)).addAll();
/* 1061 */     return bitFieldSet;
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
/*      */   public static <E extends Enum<E>> BitFieldSet<E> copyOf(BitFieldSet<E> paramBitFieldSet) {
/* 1074 */     return paramBitFieldSet.clone();
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
/*      */   public static <E extends Enum<E>> BitFieldSet<E> copyOf(Collection<E> paramCollection) {
/* 1092 */     if (paramCollection instanceof BitFieldSet) {
/* 1093 */       return ((BitFieldSet<E>)paramCollection).clone();
/*      */     }
/* 1095 */     if (paramCollection.isEmpty())
/* 1096 */       throw new IllegalArgumentException("Collection is empty"); 
/*      */     Iterator<E> iterator;
/*      */     Enum enum_;
/* 1099 */     BitFieldSet<Enum> bitFieldSet = of(enum_ = (Enum)(iterator = paramCollection.iterator()).next());
/* 1100 */     for (; iterator.hasNext(); bitFieldSet.add((Enum)iterator.next()));
/* 1101 */     return (BitFieldSet)bitFieldSet;
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
/*      */   public static <E extends Enum<E>> BitFieldSet<E> complementOf(BitFieldSet<E> paramBitFieldSet) {
/* 1117 */     (paramBitFieldSet = copyOf(paramBitFieldSet)).complement();
/* 1118 */     return paramBitFieldSet;
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
/*      */   public static <E extends Enum<E>> BitFieldSet<E> of(E paramE) {
/*      */     BitFieldSet<Enum> bitFieldSet;
/* 1137 */     (bitFieldSet = noneOf(paramE.getDeclaringClass())).add((Enum)paramE);
/* 1138 */     return (BitFieldSet)bitFieldSet;
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
/*      */   public static <E extends Enum<E>> BitFieldSet<E> of(E paramE1, E paramE2) {
/*      */     BitFieldSet<Enum> bitFieldSet;
/* 1158 */     (bitFieldSet = noneOf(paramE1.getDeclaringClass())).add((Enum)paramE1);
/* 1159 */     bitFieldSet.add((Enum)paramE2);
/* 1160 */     return (BitFieldSet)bitFieldSet;
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
/*      */   public static <E extends Enum<E>> BitFieldSet<E> of(E paramE1, E paramE2, E paramE3) {
/*      */     BitFieldSet<Enum> bitFieldSet;
/* 1181 */     (bitFieldSet = noneOf(paramE1.getDeclaringClass())).add((Enum)paramE1);
/* 1182 */     bitFieldSet.add((Enum)paramE2);
/* 1183 */     bitFieldSet.add((Enum)paramE3);
/* 1184 */     return (BitFieldSet)bitFieldSet;
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
/*      */   public static <E extends Enum<E>> BitFieldSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4) {
/*      */     BitFieldSet<Enum> bitFieldSet;
/* 1206 */     (bitFieldSet = noneOf(paramE1.getDeclaringClass())).add((Enum)paramE1);
/* 1207 */     bitFieldSet.add((Enum)paramE2);
/* 1208 */     bitFieldSet.add((Enum)paramE3);
/* 1209 */     bitFieldSet.add((Enum)paramE4);
/* 1210 */     return (BitFieldSet)bitFieldSet;
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
/*      */   public static <E extends Enum<E>> BitFieldSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5) {
/*      */     BitFieldSet<Enum> bitFieldSet;
/* 1236 */     (bitFieldSet = noneOf(paramE1.getDeclaringClass())).add((Enum)paramE1);
/* 1237 */     bitFieldSet.add((Enum)paramE2);
/* 1238 */     bitFieldSet.add((Enum)paramE3);
/* 1239 */     bitFieldSet.add((Enum)paramE4);
/* 1240 */     bitFieldSet.add((Enum)paramE5);
/* 1241 */     return (BitFieldSet)bitFieldSet;
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
/*      */   @SafeVarargs
/*      */   public static <E extends Enum<E>> BitFieldSet<E> of(E paramE, E... paramVarArgs) {
/*      */     BitFieldSet<Enum> bitFieldSet;
/* 1261 */     (bitFieldSet = noneOf(paramE.getDeclaringClass())).add((Enum)paramE); E[] arrayOfE; int i; byte b;
/* 1262 */     for (i = (arrayOfE = paramVarArgs).length, b = 0; b < i; ) { E e = arrayOfE[b]; bitFieldSet.add((Enum)e); b++; }
/* 1263 */      return (BitFieldSet)bitFieldSet;
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
/*      */   public static <E extends Enum<E>> BitFieldSet<E> of(Class<E> paramClass, E[] paramArrayOfE) {
/* 1281 */     BitFieldSet<E> bitFieldSet = noneOf(paramClass); int i; byte b;
/* 1282 */     for (i = (paramArrayOfE = paramArrayOfE).length, b = 0; b < i; ) { E e = paramArrayOfE[b]; bitFieldSet.add(e); b++; }
/* 1283 */      return bitFieldSet;
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
/*      */   public static <E extends Enum<E>> BitFieldSet<E> range(E paramE1, E paramE2) {
/* 1301 */     if (paramE1.compareTo(paramE2) > 0)
/* 1302 */       throw new IllegalArgumentException((new StringBuilder()).append(paramE1).append(" > ").append(paramE2).toString()); 
/*      */     BitFieldSet<Enum> bitFieldSet;
/* 1304 */     (bitFieldSet = noneOf(paramE1.getDeclaringClass())).addRange((Enum)paramE1, (Enum)paramE2);
/* 1305 */     return (BitFieldSet)bitFieldSet;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\misc\BitFieldSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */