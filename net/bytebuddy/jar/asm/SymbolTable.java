/*      */ package net.bytebuddy.jar.asm;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ final class SymbolTable
/*      */ {
/*      */   final ClassWriter a;
/*      */   private final ClassReader sourceClassReader;
/*      */   private int majorVersion;
/*      */   private String className;
/*      */   private int entryCount;
/*      */   private Entry[] entries;
/*      */   private int constantPoolCount;
/*      */   private ByteVector constantPool;
/*      */   private int bootstrapMethodCount;
/*      */   private ByteVector bootstrapMethods;
/*      */   private int typeCount;
/*      */   private Entry[] typeTable;
/*      */   
/*      */   SymbolTable(ClassWriter paramClassWriter) {
/*  122 */     this.a = paramClassWriter;
/*  123 */     this.sourceClassReader = null;
/*  124 */     this.entries = new Entry[256];
/*  125 */     this.constantPoolCount = 1;
/*  126 */     this.constantPool = new ByteVector();
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
/*      */   SymbolTable(ClassWriter paramClassWriter, ClassReader paramClassReader) {
/*  138 */     this.a = paramClassWriter;
/*  139 */     this.sourceClassReader = paramClassReader;
/*      */ 
/*      */     
/*  142 */     byte[] arrayOfByte = paramClassReader.a;
/*  143 */     int i = paramClassReader.getItem(1) - 1;
/*  144 */     int j = paramClassReader.header - i;
/*  145 */     this.constantPoolCount = paramClassReader.getItemCount();
/*  146 */     this.constantPool = new ByteVector(j);
/*  147 */     this.constantPool.putByteArray(arrayOfByte, i, j);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  152 */     this.entries = new Entry[this.constantPoolCount << 1];
/*  153 */     char[] arrayOfChar = new char[paramClassReader.getMaxStringLength()];
/*  154 */     j = 0;
/*  155 */     int k = 1;
/*  156 */     while (k < this.constantPoolCount) {
/*  157 */       int n, i1, m = paramClassReader.getItem(k);
/*      */       
/*      */       byte b;
/*  160 */       switch (b = arrayOfByte[m - 1]) {
/*      */         
/*      */         case 9:
/*      */         case 10:
/*      */         case 11:
/*  165 */           n = paramClassReader.getItem(paramClassReader.readUnsignedShort(m + 2));
/*  166 */           addConstantMemberReference(k, b, paramClassReader
/*      */ 
/*      */               
/*  169 */               .readClass(m, arrayOfChar), paramClassReader
/*  170 */               .readUTF8(n, arrayOfChar), paramClassReader
/*  171 */               .readUTF8(n + 2, arrayOfChar));
/*      */           break;
/*      */         case 3:
/*      */         case 4:
/*  175 */           addConstantIntegerOrFloat(k, b, paramClassReader.readInt(m));
/*      */           break;
/*      */         case 12:
/*  178 */           addConstantNameAndType(k, paramClassReader
/*      */               
/*  180 */               .readUTF8(m, arrayOfChar), paramClassReader
/*  181 */               .readUTF8(m + 2, arrayOfChar));
/*      */           break;
/*      */         case 5:
/*      */         case 6:
/*  185 */           addConstantLongOrDouble(k, b, paramClassReader.readLong(m));
/*      */           break;
/*      */         case 1:
/*  188 */           addConstantUtf8(k, paramClassReader.a(k, arrayOfChar));
/*      */           break;
/*      */         
/*      */         case 15:
/*  192 */           i1 = paramClassReader.getItem(paramClassReader.readUnsignedShort(m + 1));
/*      */           
/*  194 */           n = paramClassReader.getItem(paramClassReader.readUnsignedShort(i1 + 2));
/*  195 */           addConstantMethodHandle(k, paramClassReader
/*      */               
/*  197 */               .readByte(m), paramClassReader
/*  198 */               .readClass(i1, arrayOfChar), paramClassReader
/*  199 */               .readUTF8(n, arrayOfChar), paramClassReader
/*  200 */               .readUTF8(n + 2, arrayOfChar));
/*      */           break;
/*      */         case 17:
/*      */         case 18:
/*  204 */           j = 1;
/*      */           
/*  206 */           n = paramClassReader.getItem(paramClassReader.readUnsignedShort(m + 2));
/*  207 */           addConstantDynamicOrInvokeDynamicReference(b, k, paramClassReader
/*      */ 
/*      */               
/*  210 */               .readUTF8(n, arrayOfChar), paramClassReader
/*  211 */               .readUTF8(n + 2, arrayOfChar), paramClassReader
/*  212 */               .readUnsignedShort(m));
/*      */           break;
/*      */         case 7:
/*      */         case 8:
/*      */         case 16:
/*      */         case 19:
/*      */         case 20:
/*  219 */           addConstantUtf8Reference(k, b, paramClassReader
/*  220 */               .readUTF8(m, arrayOfChar));
/*      */           break;
/*      */         default:
/*  223 */           throw new IllegalArgumentException();
/*      */       } 
/*  225 */       k += (
/*  226 */         b == 5 || b == 6) ? 2 : 1;
/*      */     } 
/*      */ 
/*      */     
/*  230 */     if (j != 0) {
/*  231 */       copyBootstrapMethods(paramClassReader, arrayOfChar);
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
/*      */   private void copyBootstrapMethods(ClassReader paramClassReader, char[] paramArrayOfchar) {
/*  245 */     byte[] arrayOfByte = paramClassReader.a;
/*  246 */     int i = paramClassReader.a(); int j;
/*  247 */     for (j = paramClassReader.readUnsignedShort(i - 2); j > 0; j--) {
/*  248 */       String str = paramClassReader.readUTF8(i, paramArrayOfchar);
/*  249 */       if ("BootstrapMethods".equals(str)) {
/*  250 */         this.bootstrapMethodCount = paramClassReader.readUnsignedShort(i + 6);
/*      */         break;
/*      */       } 
/*  253 */       i += 6 + paramClassReader.readInt(i + 2);
/*      */     } 
/*  255 */     if (this.bootstrapMethodCount > 0) {
/*      */       
/*  257 */       j = i + 8;
/*  258 */       int m = paramClassReader.readInt(i + 2) - 2;
/*  259 */       this.bootstrapMethods = new ByteVector(m);
/*  260 */       this.bootstrapMethods.putByteArray(arrayOfByte, j, m);
/*      */ 
/*      */       
/*  263 */       int k = j;
/*  264 */       for (i = 0; i < this.bootstrapMethodCount; i++) {
/*  265 */         m = k - j;
/*  266 */         int n = paramClassReader.readUnsignedShort(k);
/*  267 */         k += 2;
/*  268 */         int i1 = paramClassReader.readUnsignedShort(k);
/*  269 */         k += 2;
/*  270 */         n = paramClassReader.readConst(n, paramArrayOfchar).hashCode();
/*  271 */         while (i1-- > 0) {
/*  272 */           int i2 = paramClassReader.readUnsignedShort(k);
/*  273 */           k += 2;
/*  274 */           n ^= paramClassReader.readConst(i2, paramArrayOfchar).hashCode();
/*      */         } 
/*  276 */         add(new Entry(i, 64, m, n & Integer.MAX_VALUE));
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final ClassReader a() {
/*  288 */     return this.sourceClassReader;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final int b() {
/*  297 */     return this.majorVersion;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final String c() {
/*  306 */     return this.className;
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
/*      */   final int a(int paramInt, String paramString) {
/*  318 */     this.majorVersion = paramInt;
/*  319 */     this.className = paramString;
/*  320 */     return (a(paramString)).a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final int d() {
/*  329 */     return this.constantPoolCount;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final int e() {
/*  338 */     return this.constantPool.b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final void a(ByteVector paramByteVector) {
/*  348 */     paramByteVector.putShort(this.constantPoolCount).putByteArray(this.constantPool.a, 0, this.constantPool.b);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final int f() {
/*  358 */     if (this.bootstrapMethods != null) {
/*  359 */       b("BootstrapMethods");
/*  360 */       return 8 + this.bootstrapMethods.b;
/*      */     } 
/*  362 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final void b(ByteVector paramByteVector) {
/*  373 */     if (this.bootstrapMethods != null) {
/*  374 */       paramByteVector
/*  375 */         .putShort(b("BootstrapMethods"))
/*  376 */         .putInt(this.bootstrapMethods.b + 2)
/*  377 */         .putShort(this.bootstrapMethodCount)
/*  378 */         .putByteArray(this.bootstrapMethods.a, 0, this.bootstrapMethods.b);
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
/*      */   private Entry get(int paramInt) {
/*  394 */     return this.entries[paramInt % this.entries.length];
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
/*      */   private Entry put(Entry paramEntry) {
/*  407 */     if (this.entryCount > this.entries.length * 3 / 4) {
/*      */       int j, k;
/*      */       
/*  410 */       Entry[] arrayOfEntry = new Entry[k = ((j = this.entries.length) << 1) + 1];
/*  411 */       for (; --j >= 0; j--) {
/*  412 */         Entry entry = this.entries[j];
/*  413 */         while (entry != null) {
/*  414 */           int m = entry.h % k;
/*  415 */           Entry entry1 = entry.i;
/*  416 */           entry.i = arrayOfEntry[m];
/*  417 */           arrayOfEntry[m] = entry;
/*  418 */           entry = entry1;
/*      */         } 
/*      */       } 
/*  421 */       this.entries = arrayOfEntry;
/*      */     } 
/*  423 */     this.entryCount++;
/*  424 */     int i = paramEntry.h % this.entries.length;
/*  425 */     paramEntry.i = this.entries[i];
/*  426 */     this.entries[i] = paramEntry; return paramEntry;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void add(Entry paramEntry) {
/*  437 */     this.entryCount++;
/*  438 */     int i = paramEntry.h % this.entries.length;
/*  439 */     paramEntry.i = this.entries[i];
/*  440 */     this.entries[i] = paramEntry;
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
/*      */   final Symbol a(Object paramObject) {
/*  457 */     if (paramObject instanceof Integer)
/*  458 */       return a(((Integer)paramObject).intValue()); 
/*  459 */     if (paramObject instanceof Byte)
/*  460 */       return a(((Byte)paramObject).intValue()); 
/*  461 */     if (paramObject instanceof Character)
/*  462 */       return a(((Character)paramObject).charValue()); 
/*  463 */     if (paramObject instanceof Short)
/*  464 */       return a(((Short)paramObject).intValue()); 
/*  465 */     if (paramObject instanceof Boolean)
/*  466 */       return a(((Boolean)paramObject).booleanValue() ? 1 : 0); 
/*  467 */     if (paramObject instanceof Float)
/*  468 */       return a(((Float)paramObject).floatValue()); 
/*  469 */     if (paramObject instanceof Long)
/*  470 */       return a(((Long)paramObject).longValue()); 
/*  471 */     if (paramObject instanceof Double)
/*  472 */       return a(((Double)paramObject).doubleValue()); 
/*  473 */     if (paramObject instanceof String)
/*  474 */       return g((String)paramObject); 
/*  475 */     if (paramObject instanceof Type) {
/*      */       int i;
/*      */       
/*  478 */       if ((i = (paramObject = paramObject).getSort()) == 10)
/*  479 */         return a(paramObject.getInternalName()); 
/*  480 */       if (i == 11) {
/*  481 */         return c(paramObject.getDescriptor());
/*      */       }
/*  483 */       return a(paramObject.getDescriptor());
/*      */     } 
/*  485 */     if (paramObject instanceof Handle) {
/*  486 */       paramObject = paramObject;
/*  487 */       return a(paramObject
/*  488 */           .getTag(), paramObject
/*  489 */           .getOwner(), paramObject
/*  490 */           .getName(), paramObject
/*  491 */           .getDesc(), paramObject
/*  492 */           .isInterface());
/*  493 */     }  if (paramObject instanceof ConstantDynamic) {
/*  494 */       paramObject = paramObject;
/*  495 */       return a(paramObject
/*  496 */           .getName(), paramObject
/*  497 */           .getDescriptor(), paramObject
/*  498 */           .getBootstrapMethod(), paramObject
/*  499 */           .a());
/*      */     } 
/*  501 */     throw new IllegalArgumentException("value " + paramObject);
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
/*      */   final Symbol a(String paramString) {
/*  513 */     return addConstantUtf8Reference(7, paramString);
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
/*      */   final Symbol a(String paramString1, String paramString2, String paramString3) {
/*  526 */     return addConstantMemberReference(9, paramString1, paramString2, paramString3);
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
/*      */   final Symbol a(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
/*  541 */     byte b = paramBoolean ? 11 : 10;
/*  542 */     return addConstantMemberReference(b, paramString1, paramString2, paramString3);
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
/*      */   private Entry addConstantMemberReference(int paramInt, String paramString1, String paramString2, String paramString3) {
/*  559 */     int i = hash(paramInt, paramString1, paramString2, paramString3);
/*  560 */     Entry entry = get(i);
/*  561 */     while (entry != null) {
/*  562 */       if (entry.b == paramInt && entry.h == i && entry.c
/*      */         
/*  564 */         .equals(paramString1) && entry.d
/*  565 */         .equals(paramString2) && entry.e
/*  566 */         .equals(paramString3)) {
/*  567 */         return entry;
/*      */       }
/*  569 */       entry = entry.i;
/*      */     } 
/*  571 */     this.constantPool.b(paramInt, 
/*  572 */         (a(paramString1)).a, a(paramString2, paramString3));
/*  573 */     return put(new Entry(this.constantPoolCount++, paramInt, paramString1, paramString2, paramString3, 0L, i));
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
/*      */   private void addConstantMemberReference(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3) {
/*  593 */     add(new Entry(paramInt1, paramInt2, paramString1, paramString2, paramString3, 0L, hash(paramInt2, paramString1, paramString2, paramString3)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Symbol g(String paramString) {
/*  604 */     return addConstantUtf8Reference(8, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final Symbol a(int paramInt) {
/*  615 */     return addConstantIntegerOrFloat(3, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final Symbol a(float paramFloat) {
/*  626 */     return addConstantIntegerOrFloat(4, Float.floatToRawIntBits(paramFloat));
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
/*      */   private Symbol addConstantIntegerOrFloat(int paramInt1, int paramInt2) {
/*  638 */     int i = hash(paramInt1, paramInt2);
/*  639 */     Entry entry = get(i);
/*  640 */     while (entry != null) {
/*  641 */       if (entry.b == paramInt1 && entry.h == i && entry.f == paramInt2) {
/*  642 */         return entry;
/*      */       }
/*  644 */       entry = entry.i;
/*      */     } 
/*  646 */     this.constantPool.putByte(paramInt1).putInt(paramInt2);
/*  647 */     return put(new Entry(this.constantPoolCount++, paramInt1, paramInt2, i));
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
/*      */   private void addConstantIntegerOrFloat(int paramInt1, int paramInt2, int paramInt3) {
/*  659 */     add(new Entry(paramInt1, paramInt2, paramInt3, hash(paramInt2, paramInt3)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final Symbol a(long paramLong) {
/*  670 */     return addConstantLongOrDouble(5, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final Symbol a(double paramDouble) {
/*  681 */     return addConstantLongOrDouble(6, Double.doubleToRawLongBits(paramDouble));
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
/*      */   private Symbol addConstantLongOrDouble(int paramInt, long paramLong) {
/*  693 */     int i = hash(paramInt, paramLong);
/*  694 */     Entry entry = get(i);
/*  695 */     while (entry != null) {
/*  696 */       if (entry.b == paramInt && entry.h == i && entry.f == paramLong) {
/*  697 */         return entry;
/*      */       }
/*  699 */       entry = entry.i;
/*      */     } 
/*  701 */     int j = this.constantPoolCount;
/*  702 */     this.constantPool.putByte(paramInt).putLong(paramLong);
/*  703 */     this.constantPoolCount += 2;
/*  704 */     return put(new Entry(j, paramInt, paramLong, i));
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
/*      */   private void addConstantLongOrDouble(int paramInt1, int paramInt2, long paramLong) {
/*  716 */     add(new Entry(paramInt1, paramInt2, paramLong, hash(paramInt2, paramLong)));
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
/*      */   final int a(String paramString1, String paramString2) {
/*  729 */     int i = hash(12, paramString1, paramString2);
/*  730 */     Entry entry = get(i);
/*  731 */     while (entry != null) {
/*  732 */       if (entry.b == 12 && entry.h == i && entry.d
/*      */         
/*  734 */         .equals(paramString1) && entry.e
/*  735 */         .equals(paramString2)) {
/*  736 */         return entry.a;
/*      */       }
/*  738 */       entry = entry.i;
/*      */     } 
/*  740 */     this.constantPool.b(12, b(paramString1), b(paramString2));
/*  741 */     return (put(new Entry(this.constantPoolCount++, 12, paramString1, paramString2, i))).a;
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
/*      */   private void addConstantNameAndType(int paramInt, String paramString1, String paramString2) {
/*  753 */     add(new Entry(paramInt, 12, paramString1, paramString2, hash(12, paramString1, paramString2)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final int b(String paramString) {
/*  764 */     int i = hash(1, paramString);
/*  765 */     Entry entry = get(i);
/*  766 */     while (entry != null) {
/*  767 */       if (entry.b == 1 && entry.h == i && entry.e
/*      */         
/*  769 */         .equals(paramString)) {
/*  770 */         return entry.a;
/*      */       }
/*  772 */       entry = entry.i;
/*      */     } 
/*  774 */     this.constantPool.putByte(1).putUTF8(paramString);
/*  775 */     return (put(new Entry(this.constantPoolCount++, 1, paramString, i))).a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void addConstantUtf8(int paramInt, String paramString) {
/*  785 */     add(new Entry(paramInt, 1, paramString, hash(1, paramString)));
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
/*      */   final Symbol a(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
/*  811 */     int i = hash(15, paramString1, paramString2, paramString3, paramInt);
/*  812 */     Entry entry = get(i);
/*  813 */     while (entry != null) {
/*  814 */       if (entry.b == 15 && entry.h == i && entry.f == paramInt && entry.c
/*      */ 
/*      */         
/*  817 */         .equals(paramString1) && entry.d
/*  818 */         .equals(paramString2) && entry.e
/*  819 */         .equals(paramString3)) {
/*  820 */         return entry;
/*      */       }
/*  822 */       entry = entry.i;
/*      */     } 
/*  824 */     if (paramInt <= 4) {
/*  825 */       this.constantPool.a(15, paramInt, (a(paramString1, paramString2, paramString3)).a);
/*      */     } else {
/*  827 */       this.constantPool.a(15, paramInt, 
/*  828 */           (a(paramString1, paramString2, paramString3, paramBoolean)).a);
/*      */     } 
/*  830 */     return put(new Entry(this.constantPoolCount++, 15, paramString1, paramString2, paramString3, paramInt, i));
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
/*      */   private void addConstantMethodHandle(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3) {
/*  853 */     int i = hash(15, paramString1, paramString2, paramString3, paramInt2);
/*  854 */     add(new Entry(paramInt1, 15, paramString1, paramString2, paramString3, paramInt2, i));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final Symbol c(String paramString) {
/*  865 */     return addConstantUtf8Reference(16, paramString);
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
/*      */   final Symbol a(String paramString1, String paramString2, Handle paramHandle, Object... paramVarArgs) {
/*  884 */     Symbol symbol = a(paramHandle, paramVarArgs);
/*  885 */     return addConstantDynamicOrInvokeDynamicReference(17, paramString1, paramString2, symbol.a);
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
/*      */   final Symbol b(String paramString1, String paramString2, Handle paramHandle, Object... paramVarArgs) {
/*  905 */     Symbol symbol = a(paramHandle, paramVarArgs);
/*  906 */     return addConstantDynamicOrInvokeDynamicReference(18, paramString1, paramString2, symbol.a);
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
/*      */   private Symbol addConstantDynamicOrInvokeDynamicReference(int paramInt1, String paramString1, String paramString2, int paramInt2) {
/*  924 */     int i = hash(paramInt1, paramString1, paramString2, paramInt2);
/*  925 */     Entry entry = get(i);
/*  926 */     while (entry != null) {
/*  927 */       if (entry.b == paramInt1 && entry.h == i && entry.f == paramInt2 && entry.d
/*      */ 
/*      */         
/*  930 */         .equals(paramString1) && entry.e
/*  931 */         .equals(paramString2)) {
/*  932 */         return entry;
/*      */       }
/*  934 */       entry = entry.i;
/*      */     } 
/*  936 */     this.constantPool.b(paramInt1, paramInt2, a(paramString1, paramString2));
/*  937 */     return put(new Entry(this.constantPoolCount++, paramInt1, null, paramString1, paramString2, paramInt2, i));
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
/*      */   private void addConstantDynamicOrInvokeDynamicReference(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3) {
/*  960 */     int i = hash(paramInt1, paramString1, paramString2, paramInt3);
/*  961 */     add(new Entry(paramInt2, paramInt1, null, paramString1, paramString2, paramInt3, i));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final Symbol d(String paramString) {
/*  972 */     return addConstantUtf8Reference(19, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final Symbol e(String paramString) {
/*  983 */     return addConstantUtf8Reference(20, paramString);
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
/*      */   private Symbol addConstantUtf8Reference(int paramInt, String paramString) {
/*  999 */     int i = hash(paramInt, paramString);
/* 1000 */     Entry entry = get(i);
/* 1001 */     while (entry != null) {
/* 1002 */       if (entry.b == paramInt && entry.h == i && entry.e.equals(paramString)) {
/* 1003 */         return entry;
/*      */       }
/* 1005 */       entry = entry.i;
/*      */     } 
/* 1007 */     this.constantPool.b(paramInt, b(paramString));
/* 1008 */     return put(new Entry(this.constantPoolCount++, paramInt, paramString, i));
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
/*      */   private void addConstantUtf8Reference(int paramInt1, int paramInt2, String paramString) {
/* 1023 */     add(new Entry(paramInt1, paramInt2, paramString, hash(paramInt2, paramString)));
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
/*      */   private Symbol a(Handle paramHandle, Object... paramVarArgs) {
/*      */     ByteVector byteVector;
/* 1041 */     if ((byteVector = this.bootstrapMethods) == null) {
/* 1042 */       byteVector = this.bootstrapMethods = new ByteVector();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1050 */     int k, arrayOfInt[] = new int[k = paramVarArgs.length]; int m;
/* 1051 */     for (m = 0; m < k; m++) {
/* 1052 */       arrayOfInt[m] = (a(paramVarArgs[m])).a;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1058 */     m = byteVector.b;
/* 1059 */     byteVector.putShort(
/* 1060 */         (a(paramHandle
/* 1061 */           .getTag(), paramHandle
/* 1062 */           .getOwner(), paramHandle
/* 1063 */           .getName(), paramHandle
/* 1064 */           .getDesc(), paramHandle
/* 1065 */           .isInterface())).a);
/*      */ 
/*      */     
/* 1068 */     byteVector.putShort(k); int n;
/* 1069 */     for (n = 0; n < k; n++) {
/* 1070 */       byteVector.putShort(arrayOfInt[n]);
/*      */     }
/*      */ 
/*      */     
/* 1074 */     n = byteVector.b - m;
/* 1075 */     int i = paramHandle.hashCode();
/* 1076 */     for (int j = (paramVarArgs = paramVarArgs).length; k < j; ) { Object object = paramVarArgs[k];
/* 1077 */       i ^= object.hashCode(); k++; }
/*      */     
/* 1079 */     i &= Integer.MAX_VALUE;
/*      */ 
/*      */     
/* 1082 */     return addBootstrapMethod(m, n, i);
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
/*      */   private Symbol addBootstrapMethod(int paramInt1, int paramInt2, int paramInt3) {
/* 1096 */     byte[] arrayOfByte = this.bootstrapMethods.a;
/* 1097 */     Entry entry = get(paramInt3);
/* 1098 */     while (entry != null) {
/* 1099 */       if (entry.b == 64 && entry.h == paramInt3) {
/* 1100 */         int i = (int)entry.f;
/* 1101 */         boolean bool = true;
/* 1102 */         for (byte b = 0; b < paramInt2; b++) {
/* 1103 */           if (arrayOfByte[paramInt1 + b] != arrayOfByte[i + b]) {
/* 1104 */             bool = false;
/*      */             break;
/*      */           } 
/*      */         } 
/* 1108 */         if (bool) {
/* 1109 */           this.bootstrapMethods.b = paramInt1;
/* 1110 */           return entry;
/*      */         } 
/*      */       } 
/* 1113 */       entry = entry.i;
/*      */     } 
/* 1115 */     return put(new Entry(this.bootstrapMethodCount++, 64, paramInt1, paramInt3));
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
/*      */   final Symbol b(int paramInt) {
/* 1129 */     return this.typeTable[paramInt];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final int f(String paramString) {
/* 1140 */     int i = hash(128, paramString);
/* 1141 */     Entry entry = get(i);
/* 1142 */     while (entry != null) {
/* 1143 */       if (entry.b == 128 && entry.h == i && entry.e.equals(paramString)) {
/* 1144 */         return entry.a;
/*      */       }
/* 1146 */       entry = entry.i;
/*      */     } 
/* 1148 */     return addTypeInternal(new Entry(this.typeCount, 128, paramString, i));
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
/*      */   final int a(String paramString, int paramInt) {
/* 1161 */     int i = hash(129, paramString, paramInt);
/* 1162 */     Entry entry = get(i);
/* 1163 */     while (entry != null) {
/* 1164 */       if (entry.b == 129 && entry.h == i && entry.f == paramInt && entry.e
/*      */ 
/*      */         
/* 1167 */         .equals(paramString)) {
/* 1168 */         return entry.a;
/*      */       }
/* 1170 */       entry = entry.i;
/*      */     } 
/* 1172 */     return addTypeInternal(new Entry(this.typeCount, 129, paramString, paramInt, i));
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
/*      */   final int a(int paramInt1, int paramInt2) {
/* 1191 */     long l = (paramInt1 < paramInt2) ? (paramInt1 | paramInt2 << 32L) : (paramInt2 | paramInt1 << 32L);
/* 1192 */     int j = hash(130, paramInt1 + paramInt2);
/* 1193 */     Entry entry = get(j);
/* 1194 */     while (entry != null) {
/* 1195 */       if (entry.b == 130 && entry.h == j && entry.f == l) {
/* 1196 */         return entry.g;
/*      */       }
/* 1198 */       entry = entry.i;
/*      */     } 
/* 1200 */     String str1 = (this.typeTable[paramInt1]).e;
/* 1201 */     String str2 = (this.typeTable[paramInt2]).e;
/* 1202 */     int i = f(this.a.getCommonSuperClass(str1, str2));
/* 1203 */     (put(new Entry(this.typeCount, 130, l, j))).g = i;
/* 1204 */     return i;
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
/*      */   private int addTypeInternal(Entry paramEntry) {
/* 1216 */     if (this.typeTable == null) {
/* 1217 */       this.typeTable = new Entry[16];
/*      */     }
/* 1219 */     if (this.typeCount == this.typeTable.length) {
/* 1220 */       Entry[] arrayOfEntry = new Entry[2 * this.typeTable.length];
/* 1221 */       System.arraycopy(this.typeTable, 0, arrayOfEntry, 0, this.typeTable.length);
/* 1222 */       this.typeTable = arrayOfEntry;
/*      */     } 
/* 1224 */     this.typeTable[this.typeCount++] = paramEntry;
/* 1225 */     return (put(paramEntry)).a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int hash(int paramInt1, int paramInt2) {
/* 1233 */     return Integer.MAX_VALUE & paramInt1 + paramInt2;
/*      */   }
/*      */   
/*      */   private static int hash(int paramInt, long paramLong) {
/* 1237 */     return Integer.MAX_VALUE & paramInt + (int)paramLong + (int)(paramLong >>> 32L);
/*      */   }
/*      */   
/*      */   private static int hash(int paramInt, String paramString) {
/* 1241 */     return Integer.MAX_VALUE & paramInt + paramString.hashCode();
/*      */   }
/*      */   
/*      */   private static int hash(int paramInt1, String paramString, int paramInt2) {
/* 1245 */     return Integer.MAX_VALUE & paramInt1 + paramString.hashCode() + paramInt2;
/*      */   }
/*      */   
/*      */   private static int hash(int paramInt, String paramString1, String paramString2) {
/* 1249 */     return Integer.MAX_VALUE & paramInt + paramString1.hashCode() * paramString2.hashCode();
/*      */   }
/*      */ 
/*      */   
/*      */   private static int hash(int paramInt1, String paramString1, String paramString2, int paramInt2) {
/* 1254 */     return Integer.MAX_VALUE & paramInt1 + paramString1.hashCode() * paramString2.hashCode() * (paramInt2 + 1);
/*      */   }
/*      */ 
/*      */   
/*      */   private static int hash(int paramInt, String paramString1, String paramString2, String paramString3) {
/* 1259 */     return Integer.MAX_VALUE & paramInt + paramString1.hashCode() * paramString2.hashCode() * paramString3.hashCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int hash(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2) {
/* 1268 */     return Integer.MAX_VALUE & paramInt1 + paramString1.hashCode() * paramString2.hashCode() * paramString3.hashCode() * paramInt2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class Entry
/*      */     extends Symbol
/*      */   {
/*      */     final int h;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Entry i;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Entry(int param1Int1, int param1Int2, String param1String1, String param1String2, String param1String3, long param1Long, int param1Int3) {
/* 1297 */       super(param1Int1, param1Int2, param1String1, param1String2, param1String3, param1Long);
/* 1298 */       this.h = param1Int3;
/*      */     }
/*      */     
/*      */     Entry(int param1Int1, int param1Int2, String param1String, int param1Int3) {
/* 1302 */       super(param1Int1, param1Int2, null, null, param1String, 0L);
/* 1303 */       this.h = param1Int3;
/*      */     }
/*      */     
/*      */     Entry(int param1Int1, int param1Int2, String param1String, long param1Long, int param1Int3) {
/* 1307 */       super(param1Int1, 129, null, null, param1String, param1Long);
/* 1308 */       this.h = param1Int3;
/*      */     }
/*      */ 
/*      */     
/*      */     Entry(int param1Int1, int param1Int2, String param1String1, String param1String2, int param1Int3) {
/* 1313 */       super(param1Int1, 12, null, param1String1, param1String2, 0L);
/* 1314 */       this.h = param1Int3;
/*      */     }
/*      */     
/*      */     Entry(int param1Int1, int param1Int2, long param1Long, int param1Int3) {
/* 1318 */       super(param1Int1, param1Int2, null, null, null, param1Long);
/* 1319 */       this.h = param1Int3;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\SymbolTable.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */