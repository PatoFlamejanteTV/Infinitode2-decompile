/*      */ package com.badlogic.gdx.utils;
/*      */ 
/*      */ import java.io.Writer;
/*      */ import java.util.Iterator;
/*      */ import java.util.NoSuchElementException;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class JsonValue
/*      */   implements Iterable<JsonValue>
/*      */ {
/*      */   private ValueType type;
/*      */   private String stringValue;
/*      */   private double doubleValue;
/*      */   private long longValue;
/*      */   public String name;
/*      */   public JsonValue child;
/*      */   public JsonValue parent;
/*      */   public JsonValue next;
/*      */   public JsonValue prev;
/*      */   public int size;
/*      */   
/*      */   public JsonValue(ValueType paramValueType) {
/*   58 */     this.type = paramValueType;
/*      */   }
/*      */ 
/*      */   
/*      */   public JsonValue(@Null String paramString) {
/*   63 */     set(paramString);
/*      */   }
/*      */   
/*      */   public JsonValue(double paramDouble) {
/*   67 */     set(paramDouble, (String)null);
/*      */   }
/*      */   
/*      */   public JsonValue(long paramLong) {
/*   71 */     set(paramLong, (String)null);
/*      */   }
/*      */   
/*      */   public JsonValue(double paramDouble, String paramString) {
/*   75 */     set(paramDouble, paramString);
/*      */   }
/*      */   
/*      */   public JsonValue(long paramLong, String paramString) {
/*   79 */     set(paramLong, paramString);
/*      */   }
/*      */   
/*      */   public JsonValue(boolean paramBoolean) {
/*   83 */     set(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public JsonValue get(int paramInt) {
/*   90 */     JsonValue jsonValue = this.child;
/*   91 */     while (jsonValue != null && paramInt > 0) {
/*   92 */       paramInt--;
/*   93 */       jsonValue = jsonValue.next;
/*      */     } 
/*   95 */     return jsonValue;
/*      */   }
/*      */ 
/*      */   
/*      */   @Null
/*      */   public JsonValue get(String paramString) {
/*  101 */     JsonValue jsonValue = this.child;
/*  102 */     while (jsonValue != null && (jsonValue.name == null || !jsonValue.name.equalsIgnoreCase(paramString)))
/*  103 */       jsonValue = jsonValue.next; 
/*  104 */     return jsonValue;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean has(String paramString) {
/*  109 */     return (get(paramString) != null);
/*      */   }
/*      */   
/*      */   public JsonIterator iterator(String paramString) {
/*      */     JsonIterator jsonIterator;
/*      */     JsonValue jsonValue;
/*  115 */     if ((jsonValue = get(paramString)) == null) {
/*      */       
/*  117 */       (jsonIterator = new JsonIterator()).entry = null;
/*  118 */       return jsonIterator;
/*      */     } 
/*  120 */     return jsonIterator.iterator();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JsonValue require(int paramInt) {
/*      */     JsonValue jsonValue;
/*  128 */     if ((jsonValue = get(paramInt)) == null) throw new IllegalArgumentException("Child not found with index: " + paramInt); 
/*  129 */     return jsonValue;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public JsonValue require(String paramString) {
/*      */     JsonValue jsonValue;
/*  136 */     if ((jsonValue = get(paramString)) == null) throw new IllegalArgumentException("Child not found with name: " + paramString); 
/*  137 */     return jsonValue;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public JsonValue remove(int paramInt) {
/*      */     JsonValue jsonValue;
/*  145 */     if ((jsonValue = get(paramInt)) == null) return null; 
/*  146 */     if (jsonValue.prev == null) {
/*  147 */       this.child = jsonValue.next;
/*  148 */       if (this.child != null) this.child.prev = null; 
/*      */     } else {
/*  150 */       jsonValue.prev.next = jsonValue.next;
/*  151 */       if (jsonValue.next != null) jsonValue.next.prev = jsonValue.prev; 
/*      */     } 
/*  153 */     this.size--;
/*  154 */     return jsonValue;
/*      */   }
/*      */ 
/*      */   
/*      */   @Null
/*      */   public JsonValue remove(String paramString) {
/*      */     JsonValue jsonValue;
/*  161 */     if ((jsonValue = get(paramString)) == null) return null; 
/*  162 */     if (jsonValue.prev == null) {
/*  163 */       this.child = jsonValue.next;
/*  164 */       if (this.child != null) this.child.prev = null; 
/*      */     } else {
/*  166 */       jsonValue.prev.next = jsonValue.next;
/*  167 */       if (jsonValue.next != null) jsonValue.next.prev = jsonValue.prev; 
/*      */     } 
/*  169 */     this.size--;
/*  170 */     return jsonValue;
/*      */   }
/*      */ 
/*      */   
/*      */   public void remove() {
/*  175 */     if (this.parent == null) throw new IllegalStateException(); 
/*  176 */     if (this.prev == null) {
/*  177 */       this.parent.child = this.next;
/*  178 */       if (this.parent.child != null) this.parent.child.prev = null; 
/*      */     } else {
/*  180 */       this.prev.next = this.next;
/*  181 */       if (this.next != null) this.next.prev = this.prev; 
/*      */     } 
/*  183 */     this.parent.size--;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean notEmpty() {
/*  188 */     return (this.size > 0);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isEmpty() {
/*  193 */     return (this.size == 0);
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public int size() {
/*  199 */     return this.size;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public String asString() {
/*  206 */     switch (this.type) {
/*      */       case stringValue:
/*  208 */         return this.stringValue;
/*      */       case doubleValue:
/*  210 */         return (this.stringValue != null) ? this.stringValue : Double.toString(this.doubleValue);
/*      */       case longValue:
/*  212 */         return (this.stringValue != null) ? this.stringValue : Long.toString(this.longValue);
/*      */       case booleanValue:
/*  214 */         return (this.longValue != 0L) ? "true" : "false";
/*      */       case nullValue:
/*  216 */         return null;
/*      */     } 
/*  218 */     throw new IllegalStateException("Value cannot be converted to string: " + this.type);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float asFloat() {
/*  224 */     switch (this.type) {
/*      */       case stringValue:
/*  226 */         return Float.parseFloat(this.stringValue);
/*      */       case doubleValue:
/*  228 */         return (float)this.doubleValue;
/*      */       case longValue:
/*  230 */         return (float)this.longValue;
/*      */       case booleanValue:
/*  232 */         return (this.longValue != 0L) ? 1.0F : 0.0F;
/*      */     } 
/*  234 */     throw new IllegalStateException("Value cannot be converted to float: " + this.type);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public double asDouble() {
/*  240 */     switch (this.type) {
/*      */       case stringValue:
/*  242 */         return Double.parseDouble(this.stringValue);
/*      */       case doubleValue:
/*  244 */         return this.doubleValue;
/*      */       case longValue:
/*  246 */         return this.longValue;
/*      */       case booleanValue:
/*  248 */         return (this.longValue != 0L) ? 1.0D : 0.0D;
/*      */     } 
/*  250 */     throw new IllegalStateException("Value cannot be converted to double: " + this.type);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public long asLong() {
/*  256 */     switch (this.type) {
/*      */       case stringValue:
/*  258 */         return Long.parseLong(this.stringValue);
/*      */       case doubleValue:
/*  260 */         return (long)this.doubleValue;
/*      */       case longValue:
/*  262 */         return this.longValue;
/*      */       case booleanValue:
/*  264 */         return (this.longValue != 0L) ? 1L : 0L;
/*      */     } 
/*  266 */     throw new IllegalStateException("Value cannot be converted to long: " + this.type);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int asInt() {
/*  272 */     switch (this.type) {
/*      */       case stringValue:
/*  274 */         return Integer.parseInt(this.stringValue);
/*      */       case doubleValue:
/*  276 */         return (int)this.doubleValue;
/*      */       case longValue:
/*  278 */         return (int)this.longValue;
/*      */       case booleanValue:
/*  280 */         return (this.longValue != 0L) ? 1 : 0;
/*      */     } 
/*  282 */     throw new IllegalStateException("Value cannot be converted to int: " + this.type);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean asBoolean() {
/*  288 */     switch (this.type) {
/*      */       case stringValue:
/*  290 */         return this.stringValue.equalsIgnoreCase("true");
/*      */       case doubleValue:
/*  292 */         return (this.doubleValue != 0.0D);
/*      */       case longValue:
/*  294 */         return (this.longValue != 0L);
/*      */       case booleanValue:
/*  296 */         return (this.longValue != 0L);
/*      */     } 
/*  298 */     throw new IllegalStateException("Value cannot be converted to boolean: " + this.type);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public byte asByte() {
/*  304 */     switch (this.type) {
/*      */       case stringValue:
/*  306 */         return Byte.parseByte(this.stringValue);
/*      */       case doubleValue:
/*  308 */         return (byte)(int)this.doubleValue;
/*      */       case longValue:
/*  310 */         return (byte)(int)this.longValue;
/*      */       case booleanValue:
/*  312 */         return (this.longValue != 0L) ? 1 : 0;
/*      */     } 
/*  314 */     throw new IllegalStateException("Value cannot be converted to byte: " + this.type);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public short asShort() {
/*  320 */     switch (this.type) {
/*      */       case stringValue:
/*  322 */         return Short.parseShort(this.stringValue);
/*      */       case doubleValue:
/*  324 */         return (short)(int)this.doubleValue;
/*      */       case longValue:
/*  326 */         return (short)(int)this.longValue;
/*      */       case booleanValue:
/*  328 */         return (this.longValue != 0L) ? 1 : 0;
/*      */     } 
/*  330 */     throw new IllegalStateException("Value cannot be converted to short: " + this.type);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public char asChar() {
/*  336 */     switch (this.type) {
/*      */       case stringValue:
/*  338 */         return (this.stringValue.length() == 0) ? Character.MIN_VALUE : this.stringValue.charAt(0);
/*      */       case doubleValue:
/*  340 */         return (char)(int)this.doubleValue;
/*      */       case longValue:
/*  342 */         return (char)(int)this.longValue;
/*      */       case booleanValue:
/*  344 */         return (this.longValue != 0L) ? '\001' : Character.MIN_VALUE;
/*      */     } 
/*  346 */     throw new IllegalStateException("Value cannot be converted to char: " + this.type);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] asStringArray() {
/*  352 */     if (this.type != ValueType.array) throw new IllegalStateException("Value is not an array: " + this.type); 
/*  353 */     String[] arrayOfString = new String[this.size];
/*  354 */     byte b = 0;
/*  355 */     for (JsonValue jsonValue = this.child; jsonValue != null; jsonValue = jsonValue.next, b++) {
/*      */       String str;
/*  357 */       switch (jsonValue.type) {
/*      */         case stringValue:
/*  359 */           str = jsonValue.stringValue;
/*      */           break;
/*      */         case doubleValue:
/*  362 */           str = (this.stringValue != null) ? this.stringValue : Double.toString(jsonValue.doubleValue);
/*      */           break;
/*      */         case longValue:
/*  365 */           str = (this.stringValue != null) ? this.stringValue : Long.toString(jsonValue.longValue);
/*      */           break;
/*      */         case booleanValue:
/*  368 */           str = (jsonValue.longValue != 0L) ? "true" : "false";
/*      */           break;
/*      */         case nullValue:
/*  371 */           str = null;
/*      */           break;
/*      */         default:
/*  374 */           throw new IllegalStateException("Value cannot be converted to string: " + jsonValue.type);
/*      */       } 
/*  376 */       arrayOfString[b] = str;
/*      */     } 
/*  378 */     return arrayOfString;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float[] asFloatArray() {
/*  384 */     if (this.type != ValueType.array) throw new IllegalStateException("Value is not an array: " + this.type); 
/*  385 */     float[] arrayOfFloat = new float[this.size];
/*  386 */     byte b = 0;
/*  387 */     for (JsonValue jsonValue = this.child; jsonValue != null; jsonValue = jsonValue.next, b++) {
/*      */       float f;
/*  389 */       switch (jsonValue.type) {
/*      */         case stringValue:
/*  391 */           f = Float.parseFloat(jsonValue.stringValue);
/*      */           break;
/*      */         case doubleValue:
/*  394 */           f = (float)jsonValue.doubleValue;
/*      */           break;
/*      */         case longValue:
/*  397 */           f = (float)jsonValue.longValue;
/*      */           break;
/*      */         case booleanValue:
/*  400 */           f = (jsonValue.longValue != 0L) ? 1.0F : 0.0F;
/*      */           break;
/*      */         default:
/*  403 */           throw new IllegalStateException("Value cannot be converted to float: " + jsonValue.type);
/*      */       } 
/*  405 */       arrayOfFloat[b] = f;
/*      */     } 
/*  407 */     return arrayOfFloat;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public double[] asDoubleArray() {
/*  413 */     if (this.type != ValueType.array) throw new IllegalStateException("Value is not an array: " + this.type); 
/*  414 */     double[] arrayOfDouble = new double[this.size];
/*  415 */     byte b = 0;
/*  416 */     for (JsonValue jsonValue = this.child; jsonValue != null; jsonValue = jsonValue.next, b++) {
/*      */       double d;
/*  418 */       switch (jsonValue.type) {
/*      */         case stringValue:
/*  420 */           d = Double.parseDouble(jsonValue.stringValue);
/*      */           break;
/*      */         case doubleValue:
/*  423 */           d = jsonValue.doubleValue;
/*      */           break;
/*      */         case longValue:
/*  426 */           d = jsonValue.longValue;
/*      */           break;
/*      */         case booleanValue:
/*  429 */           d = (jsonValue.longValue != 0L) ? 1.0D : 0.0D;
/*      */           break;
/*      */         default:
/*  432 */           throw new IllegalStateException("Value cannot be converted to double: " + jsonValue.type);
/*      */       } 
/*  434 */       arrayOfDouble[b] = d;
/*      */     } 
/*  436 */     return arrayOfDouble;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public long[] asLongArray() {
/*  442 */     if (this.type != ValueType.array) throw new IllegalStateException("Value is not an array: " + this.type); 
/*  443 */     long[] arrayOfLong = new long[this.size];
/*  444 */     byte b = 0;
/*  445 */     for (JsonValue jsonValue = this.child; jsonValue != null; jsonValue = jsonValue.next, b++) {
/*      */       long l;
/*  447 */       switch (jsonValue.type) {
/*      */         case stringValue:
/*  449 */           l = Long.parseLong(jsonValue.stringValue);
/*      */           break;
/*      */         case doubleValue:
/*  452 */           l = (long)jsonValue.doubleValue;
/*      */           break;
/*      */         case longValue:
/*  455 */           l = jsonValue.longValue;
/*      */           break;
/*      */         case booleanValue:
/*  458 */           l = (jsonValue.longValue != 0L) ? 1L : 0L;
/*      */           break;
/*      */         default:
/*  461 */           throw new IllegalStateException("Value cannot be converted to long: " + jsonValue.type);
/*      */       } 
/*  463 */       arrayOfLong[b] = l;
/*      */     } 
/*  465 */     return arrayOfLong;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int[] asIntArray() {
/*  471 */     if (this.type != ValueType.array) throw new IllegalStateException("Value is not an array: " + this.type); 
/*  472 */     int[] arrayOfInt = new int[this.size];
/*  473 */     byte b = 0;
/*  474 */     for (JsonValue jsonValue = this.child; jsonValue != null; jsonValue = jsonValue.next, b++) {
/*      */       int i;
/*  476 */       switch (jsonValue.type) {
/*      */         case stringValue:
/*  478 */           i = Integer.parseInt(jsonValue.stringValue);
/*      */           break;
/*      */         case doubleValue:
/*  481 */           i = (int)jsonValue.doubleValue;
/*      */           break;
/*      */         case longValue:
/*  484 */           i = (int)jsonValue.longValue;
/*      */           break;
/*      */         case booleanValue:
/*  487 */           i = (jsonValue.longValue != 0L) ? 1 : 0;
/*      */           break;
/*      */         default:
/*  490 */           throw new IllegalStateException("Value cannot be converted to int: " + jsonValue.type);
/*      */       } 
/*  492 */       arrayOfInt[b] = i;
/*      */     } 
/*  494 */     return arrayOfInt;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean[] asBooleanArray() {
/*  500 */     if (this.type != ValueType.array) throw new IllegalStateException("Value is not an array: " + this.type); 
/*  501 */     boolean[] arrayOfBoolean = new boolean[this.size];
/*  502 */     byte b = 0;
/*  503 */     for (JsonValue jsonValue = this.child; jsonValue != null; jsonValue = jsonValue.next, b++) {
/*      */       boolean bool;
/*  505 */       switch (jsonValue.type) {
/*      */         case stringValue:
/*  507 */           bool = Boolean.parseBoolean(jsonValue.stringValue);
/*      */           break;
/*      */         case doubleValue:
/*  510 */           bool = (jsonValue.doubleValue == 0.0D);
/*      */           break;
/*      */         case longValue:
/*  513 */           bool = (jsonValue.longValue == 0L);
/*      */           break;
/*      */         case booleanValue:
/*  516 */           bool = (jsonValue.longValue != 0L);
/*      */           break;
/*      */         default:
/*  519 */           throw new IllegalStateException("Value cannot be converted to boolean: " + jsonValue.type);
/*      */       } 
/*  521 */       arrayOfBoolean[b] = bool;
/*      */     } 
/*  523 */     return arrayOfBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] asByteArray() {
/*  529 */     if (this.type != ValueType.array) throw new IllegalStateException("Value is not an array: " + this.type); 
/*  530 */     byte[] arrayOfByte = new byte[this.size];
/*  531 */     byte b = 0;
/*  532 */     for (JsonValue jsonValue = this.child; jsonValue != null; jsonValue = jsonValue.next, b++) {
/*      */       byte b1;
/*  534 */       switch (jsonValue.type) {
/*      */         case stringValue:
/*  536 */           b1 = Byte.parseByte(jsonValue.stringValue);
/*      */           break;
/*      */         case doubleValue:
/*  539 */           b1 = (byte)(int)jsonValue.doubleValue;
/*      */           break;
/*      */         case longValue:
/*  542 */           b1 = (byte)(int)jsonValue.longValue;
/*      */           break;
/*      */         case booleanValue:
/*  545 */           b1 = (jsonValue.longValue != 0L) ? 1 : 0;
/*      */           break;
/*      */         default:
/*  548 */           throw new IllegalStateException("Value cannot be converted to byte: " + jsonValue.type);
/*      */       } 
/*  550 */       arrayOfByte[b] = b1;
/*      */     } 
/*  552 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public short[] asShortArray() {
/*  558 */     if (this.type != ValueType.array) throw new IllegalStateException("Value is not an array: " + this.type); 
/*  559 */     short[] arrayOfShort = new short[this.size];
/*  560 */     byte b = 0;
/*  561 */     for (JsonValue jsonValue = this.child; jsonValue != null; jsonValue = jsonValue.next, b++) {
/*      */       short s;
/*  563 */       switch (jsonValue.type) {
/*      */         case stringValue:
/*  565 */           s = Short.parseShort(jsonValue.stringValue);
/*      */           break;
/*      */         case doubleValue:
/*  568 */           s = (short)(int)jsonValue.doubleValue;
/*      */           break;
/*      */         case longValue:
/*  571 */           s = (short)(int)jsonValue.longValue;
/*      */           break;
/*      */         case booleanValue:
/*  574 */           s = (jsonValue.longValue != 0L) ? 1 : 0;
/*      */           break;
/*      */         default:
/*  577 */           throw new IllegalStateException("Value cannot be converted to short: " + jsonValue.type);
/*      */       } 
/*  579 */       arrayOfShort[b] = s;
/*      */     } 
/*  581 */     return arrayOfShort;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public char[] asCharArray() {
/*  587 */     if (this.type != ValueType.array) throw new IllegalStateException("Value is not an array: " + this.type); 
/*  588 */     char[] arrayOfChar = new char[this.size];
/*  589 */     byte b = 0;
/*  590 */     for (JsonValue jsonValue = this.child; jsonValue != null; jsonValue = jsonValue.next, b++) {
/*      */       char c;
/*  592 */       switch (jsonValue.type) {
/*      */         case stringValue:
/*  594 */           c = (jsonValue.stringValue.length() == 0) ? Character.MIN_VALUE : jsonValue.stringValue.charAt(0);
/*      */           break;
/*      */         case doubleValue:
/*  597 */           c = (char)(int)jsonValue.doubleValue;
/*      */           break;
/*      */         case longValue:
/*  600 */           c = (char)(int)jsonValue.longValue;
/*      */           break;
/*      */         case booleanValue:
/*  603 */           c = (jsonValue.longValue != 0L) ? '\001' : Character.MIN_VALUE;
/*      */           break;
/*      */         default:
/*  606 */           throw new IllegalStateException("Value cannot be converted to char: " + jsonValue.type);
/*      */       } 
/*  608 */       arrayOfChar[b] = c;
/*      */     } 
/*  610 */     return arrayOfChar;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasChild(String paramString) {
/*  615 */     return (getChild(paramString) != null);
/*      */   }
/*      */ 
/*      */   
/*      */   @Null
/*      */   public JsonValue getChild(String paramString) {
/*      */     JsonValue jsonValue;
/*  622 */     return ((jsonValue = get(paramString)) == null) ? null : jsonValue.child;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String getString(String paramString1, @Null String paramString2) {
/*      */     JsonValue jsonValue;
/*  629 */     if ((jsonValue = get(paramString1)) == null || !jsonValue.isValue() || jsonValue.isNull()) return paramString2;  return jsonValue.asString();
/*      */   }
/*      */ 
/*      */   
/*      */   public float getFloat(String paramString, float paramFloat) {
/*      */     JsonValue jsonValue;
/*  635 */     if ((jsonValue = get(paramString)) == null || !jsonValue.isValue() || jsonValue.isNull()) return paramFloat;  return jsonValue.asFloat();
/*      */   }
/*      */ 
/*      */   
/*      */   public double getDouble(String paramString, double paramDouble) {
/*      */     JsonValue jsonValue;
/*  641 */     if ((jsonValue = get(paramString)) == null || !jsonValue.isValue() || jsonValue.isNull()) return paramDouble;  return jsonValue.asDouble();
/*      */   }
/*      */ 
/*      */   
/*      */   public long getLong(String paramString, long paramLong) {
/*      */     JsonValue jsonValue;
/*  647 */     if ((jsonValue = get(paramString)) == null || !jsonValue.isValue() || jsonValue.isNull()) return paramLong;  return jsonValue.asLong();
/*      */   }
/*      */ 
/*      */   
/*      */   public int getInt(String paramString, int paramInt) {
/*      */     JsonValue jsonValue;
/*  653 */     if ((jsonValue = get(paramString)) == null || !jsonValue.isValue() || jsonValue.isNull()) return paramInt;  return jsonValue.asInt();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean getBoolean(String paramString, boolean paramBoolean) {
/*      */     JsonValue jsonValue;
/*  659 */     if ((jsonValue = get(paramString)) == null || !jsonValue.isValue() || jsonValue.isNull()) return paramBoolean;  return jsonValue.asBoolean();
/*      */   }
/*      */ 
/*      */   
/*      */   public byte getByte(String paramString, byte paramByte) {
/*      */     JsonValue jsonValue;
/*  665 */     if ((jsonValue = get(paramString)) == null || !jsonValue.isValue() || jsonValue.isNull()) return paramByte;  return jsonValue.asByte();
/*      */   }
/*      */ 
/*      */   
/*      */   public short getShort(String paramString, short paramShort) {
/*      */     JsonValue jsonValue;
/*  671 */     if ((jsonValue = get(paramString)) == null || !jsonValue.isValue() || jsonValue.isNull()) return paramShort;  return jsonValue.asShort();
/*      */   }
/*      */ 
/*      */   
/*      */   public char getChar(String paramString, char paramChar) {
/*      */     JsonValue jsonValue;
/*  677 */     if ((jsonValue = get(paramString)) == null || !jsonValue.isValue() || jsonValue.isNull()) return paramChar;  return jsonValue.asChar();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String getString(String paramString) {
/*      */     JsonValue jsonValue;
/*  684 */     if ((jsonValue = get(paramString)) == null) throw new IllegalArgumentException("Named value not found: " + paramString); 
/*  685 */     return jsonValue.asString();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float getFloat(String paramString) {
/*      */     JsonValue jsonValue;
/*  692 */     if ((jsonValue = get(paramString)) == null) throw new IllegalArgumentException("Named value not found: " + paramString); 
/*  693 */     return jsonValue.asFloat();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public double getDouble(String paramString) {
/*      */     JsonValue jsonValue;
/*  700 */     if ((jsonValue = get(paramString)) == null) throw new IllegalArgumentException("Named value not found: " + paramString); 
/*  701 */     return jsonValue.asDouble();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public long getLong(String paramString) {
/*      */     JsonValue jsonValue;
/*  708 */     if ((jsonValue = get(paramString)) == null) throw new IllegalArgumentException("Named value not found: " + paramString); 
/*  709 */     return jsonValue.asLong();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getInt(String paramString) {
/*      */     JsonValue jsonValue;
/*  716 */     if ((jsonValue = get(paramString)) == null) throw new IllegalArgumentException("Named value not found: " + paramString); 
/*  717 */     return jsonValue.asInt();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getBoolean(String paramString) {
/*      */     JsonValue jsonValue;
/*  724 */     if ((jsonValue = get(paramString)) == null) throw new IllegalArgumentException("Named value not found: " + paramString); 
/*  725 */     return jsonValue.asBoolean();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public byte getByte(String paramString) {
/*      */     JsonValue jsonValue;
/*  732 */     if ((jsonValue = get(paramString)) == null) throw new IllegalArgumentException("Named value not found: " + paramString); 
/*  733 */     return jsonValue.asByte();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public short getShort(String paramString) {
/*      */     JsonValue jsonValue;
/*  740 */     if ((jsonValue = get(paramString)) == null) throw new IllegalArgumentException("Named value not found: " + paramString); 
/*  741 */     return jsonValue.asShort();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public char getChar(String paramString) {
/*      */     JsonValue jsonValue;
/*  748 */     if ((jsonValue = get(paramString)) == null) throw new IllegalArgumentException("Named value not found: " + paramString); 
/*  749 */     return jsonValue.asChar();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String getString(int paramInt) {
/*      */     JsonValue jsonValue;
/*  756 */     if ((jsonValue = get(paramInt)) == null) throw new IllegalArgumentException("Indexed value not found: " + this.name); 
/*  757 */     return jsonValue.asString();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float getFloat(int paramInt) {
/*      */     JsonValue jsonValue;
/*  764 */     if ((jsonValue = get(paramInt)) == null) throw new IllegalArgumentException("Indexed value not found: " + this.name); 
/*  765 */     return jsonValue.asFloat();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public double getDouble(int paramInt) {
/*      */     JsonValue jsonValue;
/*  772 */     if ((jsonValue = get(paramInt)) == null) throw new IllegalArgumentException("Indexed value not found: " + this.name); 
/*  773 */     return jsonValue.asDouble();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public long getLong(int paramInt) {
/*      */     JsonValue jsonValue;
/*  780 */     if ((jsonValue = get(paramInt)) == null) throw new IllegalArgumentException("Indexed value not found: " + this.name); 
/*  781 */     return jsonValue.asLong();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getInt(int paramInt) {
/*      */     JsonValue jsonValue;
/*  788 */     if ((jsonValue = get(paramInt)) == null) throw new IllegalArgumentException("Indexed value not found: " + this.name); 
/*  789 */     return jsonValue.asInt();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getBoolean(int paramInt) {
/*      */     JsonValue jsonValue;
/*  796 */     if ((jsonValue = get(paramInt)) == null) throw new IllegalArgumentException("Indexed value not found: " + this.name); 
/*  797 */     return jsonValue.asBoolean();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public byte getByte(int paramInt) {
/*      */     JsonValue jsonValue;
/*  804 */     if ((jsonValue = get(paramInt)) == null) throw new IllegalArgumentException("Indexed value not found: " + this.name); 
/*  805 */     return jsonValue.asByte();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public short getShort(int paramInt) {
/*      */     JsonValue jsonValue;
/*  812 */     if ((jsonValue = get(paramInt)) == null) throw new IllegalArgumentException("Indexed value not found: " + this.name); 
/*  813 */     return jsonValue.asShort();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public char getChar(int paramInt) {
/*      */     JsonValue jsonValue;
/*  820 */     if ((jsonValue = get(paramInt)) == null) throw new IllegalArgumentException("Indexed value not found: " + this.name); 
/*  821 */     return jsonValue.asChar();
/*      */   }
/*      */   
/*      */   public ValueType type() {
/*  825 */     return this.type;
/*      */   }
/*      */   
/*      */   public void setType(ValueType paramValueType) {
/*  829 */     if (paramValueType == null) throw new IllegalArgumentException("type cannot be null."); 
/*  830 */     this.type = paramValueType;
/*      */   }
/*      */   
/*      */   public boolean isArray() {
/*  834 */     return (this.type == ValueType.array);
/*      */   }
/*      */   
/*      */   public boolean isObject() {
/*  838 */     return (this.type == ValueType.object);
/*      */   }
/*      */   
/*      */   public boolean isString() {
/*  842 */     return (this.type == ValueType.stringValue);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isNumber() {
/*  847 */     return (this.type == ValueType.doubleValue || this.type == ValueType.longValue);
/*      */   }
/*      */   
/*      */   public boolean isDouble() {
/*  851 */     return (this.type == ValueType.doubleValue);
/*      */   }
/*      */   
/*      */   public boolean isLong() {
/*  855 */     return (this.type == ValueType.longValue);
/*      */   }
/*      */   
/*      */   public boolean isBoolean() {
/*  859 */     return (this.type == ValueType.booleanValue);
/*      */   }
/*      */   
/*      */   public boolean isNull() {
/*  863 */     return (this.type == ValueType.nullValue);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isValue() {
/*  868 */     switch (this.type) {
/*      */       case stringValue:
/*      */       case doubleValue:
/*      */       case longValue:
/*      */       case booleanValue:
/*      */       case nullValue:
/*  874 */         return true;
/*      */     } 
/*  876 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   @Null
/*      */   public String name() {
/*  882 */     return this.name;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setName(@Null String paramString) {
/*  887 */     this.name = paramString;
/*      */   }
/*      */ 
/*      */   
/*      */   @Null
/*      */   public JsonValue parent() {
/*  893 */     return this.parent;
/*      */   }
/*      */ 
/*      */   
/*      */   @Null
/*      */   public JsonValue child() {
/*  899 */     return this.child;
/*      */   }
/*      */ 
/*      */   
/*      */   public void addChild(String paramString, JsonValue paramJsonValue) {
/*  904 */     if (paramString == null) throw new IllegalArgumentException("name cannot be null."); 
/*  905 */     paramJsonValue.name = paramString;
/*  906 */     addChild(paramJsonValue);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void addChild(JsonValue paramJsonValue) {
/*  912 */     if (this.type == ValueType.object && paramJsonValue.name == null)
/*  913 */       throw new IllegalStateException("An object child requires a name: " + paramJsonValue); 
/*  914 */     paramJsonValue.parent = this;
/*  915 */     paramJsonValue.next = null;
/*  916 */     this.size++;
/*      */     JsonValue jsonValue;
/*  918 */     if ((jsonValue = this.child) == null) {
/*  919 */       paramJsonValue.prev = null;
/*  920 */       this.child = paramJsonValue; return;
/*      */     } 
/*      */     while (true) {
/*  923 */       if (jsonValue.next == null) {
/*  924 */         jsonValue.next = paramJsonValue;
/*  925 */         paramJsonValue.prev = jsonValue;
/*      */         return;
/*      */       } 
/*  928 */       jsonValue = jsonValue.next;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public JsonValue next() {
/*  936 */     return this.next;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNext(@Null JsonValue paramJsonValue) {
/*  942 */     this.next = paramJsonValue;
/*      */   }
/*      */ 
/*      */   
/*      */   @Null
/*      */   public JsonValue prev() {
/*  948 */     return this.prev;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPrev(@Null JsonValue paramJsonValue) {
/*  954 */     this.prev = paramJsonValue;
/*      */   }
/*      */ 
/*      */   
/*      */   public void set(@Null String paramString) {
/*  959 */     this.stringValue = paramString;
/*  960 */     this.type = (paramString == null) ? ValueType.nullValue : ValueType.stringValue;
/*      */   }
/*      */ 
/*      */   
/*      */   public void set(double paramDouble, @Null String paramString) {
/*  965 */     this.doubleValue = paramDouble;
/*  966 */     this.longValue = (long)paramDouble;
/*  967 */     this.stringValue = paramString;
/*  968 */     this.type = ValueType.doubleValue;
/*      */   }
/*      */ 
/*      */   
/*      */   public void set(long paramLong, @Null String paramString) {
/*  973 */     this.longValue = paramLong;
/*  974 */     this.doubleValue = paramLong;
/*  975 */     this.stringValue = paramString;
/*  976 */     this.type = ValueType.longValue;
/*      */   }
/*      */   
/*      */   public void set(boolean paramBoolean) {
/*  980 */     this.longValue = paramBoolean ? 1L : 0L;
/*  981 */     this.type = ValueType.booleanValue;
/*      */   }
/*      */   
/*      */   public String toJson(JsonWriter.OutputType paramOutputType) {
/*  985 */     if (isValue()) return asString(); 
/*  986 */     StringBuilder stringBuilder = new StringBuilder(512);
/*  987 */     json(this, stringBuilder, paramOutputType);
/*  988 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */   private void json(JsonValue paramJsonValue, StringBuilder paramStringBuilder, JsonWriter.OutputType paramOutputType) {
/*  992 */     if (paramJsonValue.isObject()) {
/*  993 */       if (paramJsonValue.child == null) {
/*  994 */         paramStringBuilder.append("{}"); return;
/*      */       } 
/*  996 */       paramStringBuilder.length();
/*      */       
/*  998 */       paramStringBuilder.append('{');
/*      */       
/* 1000 */       for (JsonValue jsonValue = paramJsonValue.child; jsonValue != null; jsonValue = jsonValue.next) {
/* 1001 */         paramStringBuilder.append(paramOutputType.quoteName(jsonValue.name));
/* 1002 */         paramStringBuilder.append(':');
/* 1003 */         json(jsonValue, paramStringBuilder, paramOutputType);
/* 1004 */         if (jsonValue.next != null) paramStringBuilder.append(',');
/*      */       
/*      */       } 
/*      */       
/* 1008 */       paramStringBuilder.append('}'); return;
/*      */     } 
/* 1010 */     if (paramJsonValue.isArray()) {
/* 1011 */       if (paramJsonValue.child == null) {
/* 1012 */         paramStringBuilder.append("[]"); return;
/*      */       } 
/* 1014 */       paramStringBuilder.length();
/*      */       
/* 1016 */       paramStringBuilder.append('[');
/* 1017 */       for (JsonValue jsonValue = paramJsonValue.child; jsonValue != null; jsonValue = jsonValue.next) {
/* 1018 */         json(jsonValue, paramStringBuilder, paramOutputType);
/* 1019 */         if (jsonValue.next != null) paramStringBuilder.append(',');
/*      */       
/*      */       } 
/*      */       
/* 1023 */       paramStringBuilder.append(']'); return;
/*      */     } 
/* 1025 */     if (paramJsonValue.isString()) {
/* 1026 */       paramStringBuilder.append(paramOutputType.quoteValue(paramJsonValue.asString())); return;
/* 1027 */     }  if (paramJsonValue.isDouble()) {
/* 1028 */       double d = paramJsonValue.asDouble();
/* 1029 */       long l = paramJsonValue.asLong();
/* 1030 */       paramStringBuilder.append((d == l) ? l : d); return;
/* 1031 */     }  if (paramJsonValue.isLong()) {
/* 1032 */       paramStringBuilder.append(paramJsonValue.asLong()); return;
/* 1033 */     }  if (paramJsonValue.isBoolean()) {
/* 1034 */       paramStringBuilder.append(paramJsonValue.asBoolean()); return;
/* 1035 */     }  if (paramJsonValue.isNull()) {
/* 1036 */       paramStringBuilder.append("null"); return;
/*      */     } 
/* 1038 */     throw new SerializationException("Unknown object type: " + paramJsonValue);
/*      */   }
/*      */ 
/*      */   
/*      */   public JsonIterator iterator() {
/* 1043 */     return new JsonIterator();
/*      */   }
/*      */   
/*      */   public String toString() {
/* 1047 */     if (isValue()) return (this.name == null) ? asString() : (this.name + ": " + asString()); 
/* 1048 */     return ((this.name == null) ? "" : (this.name + ": ")) + prettyPrint(JsonWriter.OutputType.minimal, 0);
/*      */   }
/*      */   
/*      */   public String trace() {
/*      */     String str;
/* 1053 */     if (this.parent == null) {
/* 1054 */       if (this.type == ValueType.array) return "[]"; 
/* 1055 */       if (this.type == ValueType.object) return "{}"; 
/* 1056 */       return "";
/*      */     } 
/*      */     
/* 1059 */     if (this.parent.type == ValueType.array) {
/* 1060 */       str = "[]";
/* 1061 */       byte b = 0;
/* 1062 */       for (JsonValue jsonValue = this.parent.child; jsonValue != null; jsonValue = jsonValue.next, b++) {
/* 1063 */         if (jsonValue == this) {
/* 1064 */           str = "[" + b + "]";
/*      */           break;
/*      */         } 
/*      */       } 
/* 1068 */     } else if (this.name.indexOf('.') != -1) {
/* 1069 */       str = ".\"" + this.name.replace("\"", "\\\"") + "\"";
/*      */     } else {
/* 1071 */       str = "." + this.name;
/* 1072 */     }  return this.parent.trace() + str;
/*      */   }
/*      */   
/*      */   public String prettyPrint(JsonWriter.OutputType paramOutputType, int paramInt) {
/*      */     PrettyPrintSettings prettyPrintSettings;
/* 1077 */     (prettyPrintSettings = new PrettyPrintSettings()).outputType = paramOutputType;
/* 1078 */     prettyPrintSettings.singleLineColumns = paramInt;
/* 1079 */     return prettyPrint(prettyPrintSettings);
/*      */   }
/*      */   
/*      */   public String prettyPrint(PrettyPrintSettings paramPrettyPrintSettings) {
/* 1083 */     StringBuilder stringBuilder = new StringBuilder(512);
/* 1084 */     prettyPrint(this, stringBuilder, 0, paramPrettyPrintSettings);
/* 1085 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */   private void prettyPrint(JsonValue paramJsonValue, StringBuilder paramStringBuilder, int paramInt, PrettyPrintSettings paramPrettyPrintSettings) {
/* 1089 */     JsonWriter.OutputType outputType = paramPrettyPrintSettings.outputType;
/* 1090 */     if (paramJsonValue.isObject()) {
/* 1091 */       if (paramJsonValue.child == null) {
/* 1092 */         paramStringBuilder.append("{}"); return;
/*      */       } 
/* 1094 */       boolean bool = !isFlat(paramJsonValue) ? true : false;
/* 1095 */       int i = paramStringBuilder.length();
/*      */       
/*      */       label100: while (true) {
/* 1098 */         paramStringBuilder.append(bool ? "{\n" : "{ ");
/*      */         
/* 1100 */         for (JsonValue jsonValue = paramJsonValue.child; jsonValue != null; jsonValue = jsonValue.next) {
/* 1101 */           if (bool) indent(paramInt, paramStringBuilder); 
/* 1102 */           paramStringBuilder.append(outputType.quoteName(jsonValue.name));
/* 1103 */           paramStringBuilder.append(": ");
/* 1104 */           prettyPrint(jsonValue, paramStringBuilder, paramInt + 1, paramPrettyPrintSettings);
/* 1105 */           if ((!bool || outputType != JsonWriter.OutputType.minimal) && jsonValue.next != null) paramStringBuilder.append(','); 
/* 1106 */           paramStringBuilder.append(bool ? 10 : 32);
/* 1107 */           if (!bool && paramStringBuilder.length() - i > paramPrettyPrintSettings.singleLineColumns) {
/* 1108 */             paramStringBuilder.setLength(i);
/* 1109 */             bool = true;
/*      */             continue label100;
/*      */           } 
/*      */         } 
/*      */         break;
/*      */       } 
/* 1115 */       if (bool) indent(paramInt - 1, paramStringBuilder); 
/* 1116 */       paramStringBuilder.append('}'); return;
/*      */     } 
/* 1118 */     if (paramJsonValue.isArray()) {
/* 1119 */       if (paramJsonValue.child == null) {
/* 1120 */         paramStringBuilder.append("[]"); return;
/*      */       } 
/* 1122 */       boolean bool1 = !isFlat(paramJsonValue) ? true : false;
/* 1123 */       boolean bool2 = (paramPrettyPrintSettings.wrapNumericArrays || !isNumeric(paramJsonValue)) ? true : false;
/* 1124 */       int i = paramStringBuilder.length();
/*      */       
/*      */       label101: while (true) {
/* 1127 */         paramStringBuilder.append(bool1 ? "[\n" : "[ ");
/* 1128 */         for (JsonValue jsonValue = paramJsonValue.child; jsonValue != null; jsonValue = jsonValue.next) {
/* 1129 */           if (bool1) indent(paramInt, paramStringBuilder); 
/* 1130 */           prettyPrint(jsonValue, paramStringBuilder, paramInt + 1, paramPrettyPrintSettings);
/* 1131 */           if ((!bool1 || outputType != JsonWriter.OutputType.minimal) && jsonValue.next != null) paramStringBuilder.append(','); 
/* 1132 */           paramStringBuilder.append(bool1 ? 10 : 32);
/* 1133 */           if (bool2 && !bool1 && paramStringBuilder.length() - i > paramPrettyPrintSettings.singleLineColumns) {
/* 1134 */             paramStringBuilder.setLength(i);
/* 1135 */             bool1 = true;
/*      */             continue label101;
/*      */           } 
/*      */         } 
/*      */         break;
/*      */       } 
/* 1141 */       if (bool1) indent(paramInt - 1, paramStringBuilder); 
/* 1142 */       paramStringBuilder.append(']'); return;
/*      */     } 
/* 1144 */     if (paramJsonValue.isString()) {
/* 1145 */       paramStringBuilder.append(outputType.quoteValue(paramJsonValue.asString())); return;
/* 1146 */     }  if (paramJsonValue.isDouble()) {
/* 1147 */       double d = paramJsonValue.asDouble();
/* 1148 */       long l = paramJsonValue.asLong();
/* 1149 */       paramStringBuilder.append((d == l) ? l : d); return;
/* 1150 */     }  if (paramJsonValue.isLong()) {
/* 1151 */       paramStringBuilder.append(paramJsonValue.asLong()); return;
/* 1152 */     }  if (paramJsonValue.isBoolean()) {
/* 1153 */       paramStringBuilder.append(paramJsonValue.asBoolean()); return;
/* 1154 */     }  if (paramJsonValue.isNull()) {
/* 1155 */       paramStringBuilder.append("null"); return;
/*      */     } 
/* 1157 */     throw new SerializationException("Unknown object type: " + paramJsonValue);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void prettyPrint(JsonWriter.OutputType paramOutputType, Writer paramWriter) {
/*      */     PrettyPrintSettings prettyPrintSettings;
/* 1164 */     (prettyPrintSettings = new PrettyPrintSettings()).outputType = paramOutputType;
/* 1165 */     prettyPrint(this, paramWriter, 0, prettyPrintSettings);
/*      */   }
/*      */   
/*      */   private void prettyPrint(JsonValue paramJsonValue, Writer paramWriter, int paramInt, PrettyPrintSettings paramPrettyPrintSettings) {
/* 1169 */     JsonWriter.OutputType outputType = paramPrettyPrintSettings.outputType;
/* 1170 */     if (paramJsonValue.isObject()) {
/* 1171 */       if (paramJsonValue.child == null) {
/* 1172 */         paramWriter.append("{}"); return;
/*      */       } 
/* 1174 */       boolean bool = (!isFlat(paramJsonValue) || paramJsonValue.size > 6) ? true : false;
/* 1175 */       paramWriter.append(bool ? "{\n" : "{ ");
/*      */       
/* 1177 */       for (JsonValue jsonValue = paramJsonValue.child; jsonValue != null; jsonValue = jsonValue.next) {
/* 1178 */         if (bool) indent(paramInt, paramWriter); 
/* 1179 */         paramWriter.append(outputType.quoteName(jsonValue.name));
/* 1180 */         paramWriter.append(": ");
/* 1181 */         prettyPrint(jsonValue, paramWriter, paramInt + 1, paramPrettyPrintSettings);
/* 1182 */         if ((!bool || outputType != JsonWriter.OutputType.minimal) && jsonValue.next != null) paramWriter.append(','); 
/* 1183 */         paramWriter.append(bool ? 10 : 32);
/*      */       } 
/* 1185 */       if (bool) indent(paramInt - 1, paramWriter); 
/* 1186 */       paramWriter.append('}'); return;
/*      */     } 
/* 1188 */     if (paramJsonValue.isArray()) {
/* 1189 */       if (paramJsonValue.child == null) {
/* 1190 */         paramWriter.append("[]"); return;
/*      */       } 
/* 1192 */       boolean bool = !isFlat(paramJsonValue) ? true : false;
/* 1193 */       paramWriter.append(bool ? "[\n" : "[ ");
/*      */       
/* 1195 */       for (JsonValue jsonValue = paramJsonValue.child; jsonValue != null; jsonValue = jsonValue.next) {
/* 1196 */         if (bool) indent(paramInt, paramWriter); 
/* 1197 */         prettyPrint(jsonValue, paramWriter, paramInt + 1, paramPrettyPrintSettings);
/* 1198 */         if ((!bool || outputType != JsonWriter.OutputType.minimal) && jsonValue.next != null) paramWriter.append(','); 
/* 1199 */         paramWriter.append(bool ? 10 : 32);
/*      */       } 
/* 1201 */       if (bool) indent(paramInt - 1, paramWriter); 
/* 1202 */       paramWriter.append(']'); return;
/*      */     } 
/* 1204 */     if (paramJsonValue.isString()) {
/* 1205 */       paramWriter.append(outputType.quoteValue(paramJsonValue.asString())); return;
/* 1206 */     }  if (paramJsonValue.isDouble()) {
/* 1207 */       double d = paramJsonValue.asDouble();
/* 1208 */       long l = paramJsonValue.asLong();
/* 1209 */       paramWriter.append(Double.toString((d == l) ? l : d)); return;
/* 1210 */     }  if (paramJsonValue.isLong()) {
/* 1211 */       paramWriter.append(Long.toString(paramJsonValue.asLong())); return;
/* 1212 */     }  if (paramJsonValue.isBoolean()) {
/* 1213 */       paramWriter.append(Boolean.toString(paramJsonValue.asBoolean())); return;
/* 1214 */     }  if (paramJsonValue.isNull()) {
/* 1215 */       paramWriter.append("null"); return;
/*      */     } 
/* 1217 */     throw new SerializationException("Unknown object type: " + paramJsonValue);
/*      */   }
/*      */   
/*      */   private static boolean isFlat(JsonValue paramJsonValue) {
/* 1221 */     for (paramJsonValue = paramJsonValue.child; paramJsonValue != null; paramJsonValue = paramJsonValue.next) {
/* 1222 */       if (paramJsonValue.isObject() || paramJsonValue.isArray()) return false; 
/* 1223 */     }  return true;
/*      */   }
/*      */   
/*      */   private static boolean isNumeric(JsonValue paramJsonValue) {
/* 1227 */     for (paramJsonValue = paramJsonValue.child; paramJsonValue != null; paramJsonValue = paramJsonValue.next) {
/* 1228 */       if (!paramJsonValue.isNumber()) return false; 
/* 1229 */     }  return true;
/*      */   }
/*      */   
/*      */   private static void indent(int paramInt, StringBuilder paramStringBuilder) {
/* 1233 */     for (byte b = 0; b < paramInt; b++)
/* 1234 */       paramStringBuilder.append('\t'); 
/*      */   }
/*      */   
/*      */   private static void indent(int paramInt, Writer paramWriter) {
/* 1238 */     for (byte b = 0; b < paramInt; b++)
/* 1239 */       paramWriter.append('\t'); 
/*      */   }
/*      */   
/*      */   public class JsonIterator implements Iterable<JsonValue>, Iterator<JsonValue> {
/* 1243 */     JsonValue entry = JsonValue.this.child;
/*      */     JsonValue current;
/*      */     
/*      */     public boolean hasNext() {
/* 1247 */       return (this.entry != null);
/*      */     }
/*      */     
/*      */     public JsonValue next() {
/* 1251 */       this.current = this.entry;
/* 1252 */       if (this.current == null) throw new NoSuchElementException(); 
/* 1253 */       this.entry = this.current.next;
/* 1254 */       return this.current;
/*      */     }
/*      */     
/*      */     public void remove() {
/* 1258 */       if (this.current.prev == null) {
/* 1259 */         JsonValue.this.child = this.current.next;
/* 1260 */         if (JsonValue.this.child != null) JsonValue.this.child.prev = null; 
/*      */       } else {
/* 1262 */         this.current.prev.next = this.current.next;
/* 1263 */         if (this.current.next != null) this.current.next.prev = this.current.prev; 
/*      */       } 
/* 1265 */       JsonValue.this.size--;
/*      */     }
/*      */     
/*      */     public Iterator<JsonValue> iterator() {
/* 1269 */       return this;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum ValueType {
/* 1274 */     object, array, stringValue, doubleValue, longValue, booleanValue, nullValue;
/*      */   }
/*      */   
/*      */   public static class PrettyPrintSettings {
/*      */     public JsonWriter.OutputType outputType;
/*      */     public int singleLineColumns;
/*      */     public boolean wrapNumericArrays;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\JsonValue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */