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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ class Frame
/*      */ {
/*      */   private static final int ITEM_ASM_BOOLEAN = 9;
/*      */   private static final int ITEM_ASM_BYTE = 10;
/*      */   private static final int ITEM_ASM_CHAR = 11;
/*      */   private static final int ITEM_ASM_SHORT = 12;
/*      */   private static final int DIM_SIZE = 6;
/*      */   private static final int KIND_SIZE = 4;
/*      */   private static final int FLAGS_SIZE = 2;
/*      */   private static final int VALUE_SIZE = 20;
/*      */   private static final int DIM_SHIFT = 26;
/*      */   private static final int KIND_SHIFT = 22;
/*      */   private static final int FLAGS_SHIFT = 20;
/*      */   private static final int DIM_MASK = -67108864;
/*      */   private static final int KIND_MASK = 62914560;
/*      */   private static final int VALUE_MASK = 1048575;
/*      */   private static final int ARRAY_OF = 67108864;
/*      */   private static final int ELEMENT_OF = -67108864;
/*      */   private static final int CONSTANT_KIND = 4194304;
/*      */   private static final int REFERENCE_KIND = 8388608;
/*      */   private static final int UNINITIALIZED_KIND = 12582912;
/*      */   private static final int LOCAL_KIND = 16777216;
/*      */   private static final int STACK_KIND = 20971520;
/*      */   private static final int TOP_IF_LONG_OR_DOUBLE_FLAG = 1048576;
/*      */   private static final int TOP = 4194304;
/*      */   private static final int BOOLEAN = 4194313;
/*      */   private static final int BYTE = 4194314;
/*      */   private static final int CHAR = 4194315;
/*      */   private static final int SHORT = 4194316;
/*      */   private static final int INTEGER = 4194305;
/*      */   private static final int FLOAT = 4194306;
/*      */   private static final int LONG = 4194308;
/*      */   private static final int DOUBLE = 4194307;
/*      */   private static final int NULL = 4194309;
/*      */   private static final int UNINITIALIZED_THIS = 4194310;
/*      */   Label a;
/*      */   private int[] inputLocals;
/*      */   private int[] inputStack;
/*      */   private int[] outputLocals;
/*      */   private int[] outputStack;
/*      */   private short outputStackStart;
/*      */   private short outputStackTop;
/*      */   private int initializationCount;
/*      */   private int[] initializations;
/*      */   
/*      */   Frame(Label paramLabel) {
/*  243 */     this.a = paramLabel;
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
/*      */   final void a(Frame paramFrame) {
/*  255 */     this.inputLocals = paramFrame.inputLocals;
/*  256 */     this.inputStack = paramFrame.inputStack;
/*  257 */     this.outputStackStart = 0;
/*  258 */     this.outputLocals = paramFrame.outputLocals;
/*  259 */     this.outputStack = paramFrame.outputStack;
/*  260 */     this.outputStackTop = paramFrame.outputStackTop;
/*  261 */     this.initializationCount = paramFrame.initializationCount;
/*  262 */     this.initializations = paramFrame.initializations;
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
/*      */   static int a(SymbolTable paramSymbolTable, Object paramObject) {
/*  281 */     if (paramObject instanceof Integer)
/*  282 */       return 0x400000 | ((Integer)paramObject).intValue(); 
/*  283 */     if (paramObject instanceof String) {
/*  284 */       paramObject = Type.getObjectType((String)paramObject).getDescriptor();
/*  285 */       return getAbstractTypeFromDescriptor(paramSymbolTable, (String)paramObject, 0);
/*      */     } 
/*  287 */     return 0xC00000 | paramSymbolTable
/*  288 */       .a("", ((Label)paramObject).c);
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
/*      */   static int a(SymbolTable paramSymbolTable, String paramString) {
/*  302 */     return 0x800000 | paramSymbolTable.f(paramString);
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
/*      */   private static int getAbstractTypeFromDescriptor(SymbolTable paramSymbolTable, String paramString, int paramInt) {
/*      */     // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: iload_2
/*      */     //   2: invokevirtual charAt : (I)C
/*      */     //   5: tableswitch default -> 391, 66 -> 126, 67 -> 126, 68 -> 135, 69 -> 391, 70 -> 129, 71 -> 391, 72 -> 391, 73 -> 126, 74 -> 132, 75 -> 391, 76 -> 138, 77 -> 391, 78 -> 391, 79 -> 391, 80 -> 391, 81 -> 391, 82 -> 391, 83 -> 126, 84 -> 391, 85 -> 391, 86 -> 124, 87 -> 391, 88 -> 391, 89 -> 391, 90 -> 126, 91 -> 161
/*      */     //   124: iconst_0
/*      */     //   125: ireturn
/*      */     //   126: ldc 4194305
/*      */     //   128: ireturn
/*      */     //   129: ldc 4194306
/*      */     //   131: ireturn
/*      */     //   132: ldc 4194308
/*      */     //   134: ireturn
/*      */     //   135: ldc 4194307
/*      */     //   137: ireturn
/*      */     //   138: aload_1
/*      */     //   139: iload_2
/*      */     //   140: iconst_1
/*      */     //   141: iadd
/*      */     //   142: aload_1
/*      */     //   143: invokevirtual length : ()I
/*      */     //   146: iconst_1
/*      */     //   147: isub
/*      */     //   148: invokevirtual substring : (II)Ljava/lang/String;
/*      */     //   151: astore_1
/*      */     //   152: ldc 8388608
/*      */     //   154: aload_0
/*      */     //   155: aload_1
/*      */     //   156: invokevirtual f : (Ljava/lang/String;)I
/*      */     //   159: ior
/*      */     //   160: ireturn
/*      */     //   161: iload_2
/*      */     //   162: iconst_1
/*      */     //   163: iadd
/*      */     //   164: istore_3
/*      */     //   165: aload_1
/*      */     //   166: iload_3
/*      */     //   167: invokevirtual charAt : (I)C
/*      */     //   170: bipush #91
/*      */     //   172: if_icmpne -> 181
/*      */     //   175: iinc #3, 1
/*      */     //   178: goto -> 165
/*      */     //   181: aload_1
/*      */     //   182: iload_3
/*      */     //   183: invokevirtual charAt : (I)C
/*      */     //   186: tableswitch default -> 374, 66 -> 312, 67 -> 306, 68 -> 342, 69 -> 374, 70 -> 330, 71 -> 374, 72 -> 374, 73 -> 324, 74 -> 336, 75 -> 374, 76 -> 348, 77 -> 374, 78 -> 374, 79 -> 374, 80 -> 374, 81 -> 374, 82 -> 374, 83 -> 318, 84 -> 374, 85 -> 374, 86 -> 374, 87 -> 374, 88 -> 374, 89 -> 374, 90 -> 300
/*      */     //   300: ldc 4194313
/*      */     //   302: istore_0
/*      */     //   303: goto -> 382
/*      */     //   306: ldc 4194315
/*      */     //   308: istore_0
/*      */     //   309: goto -> 382
/*      */     //   312: ldc 4194314
/*      */     //   314: istore_0
/*      */     //   315: goto -> 382
/*      */     //   318: ldc 4194316
/*      */     //   320: istore_0
/*      */     //   321: goto -> 382
/*      */     //   324: ldc 4194305
/*      */     //   326: istore_0
/*      */     //   327: goto -> 382
/*      */     //   330: ldc 4194306
/*      */     //   332: istore_0
/*      */     //   333: goto -> 382
/*      */     //   336: ldc 4194308
/*      */     //   338: istore_0
/*      */     //   339: goto -> 382
/*      */     //   342: ldc 4194307
/*      */     //   344: istore_0
/*      */     //   345: goto -> 382
/*      */     //   348: aload_1
/*      */     //   349: iload_3
/*      */     //   350: iconst_1
/*      */     //   351: iadd
/*      */     //   352: aload_1
/*      */     //   353: invokevirtual length : ()I
/*      */     //   356: iconst_1
/*      */     //   357: isub
/*      */     //   358: invokevirtual substring : (II)Ljava/lang/String;
/*      */     //   361: astore_1
/*      */     //   362: ldc 8388608
/*      */     //   364: aload_0
/*      */     //   365: aload_1
/*      */     //   366: invokevirtual f : (Ljava/lang/String;)I
/*      */     //   369: ior
/*      */     //   370: istore_0
/*      */     //   371: goto -> 382
/*      */     //   374: new java/lang/IllegalArgumentException
/*      */     //   377: dup
/*      */     //   378: invokespecial <init> : ()V
/*      */     //   381: athrow
/*      */     //   382: iload_3
/*      */     //   383: iload_2
/*      */     //   384: isub
/*      */     //   385: bipush #26
/*      */     //   387: ishl
/*      */     //   388: iload_0
/*      */     //   389: ior
/*      */     //   390: ireturn
/*      */     //   391: new java/lang/IllegalArgumentException
/*      */     //   394: dup
/*      */     //   395: invokespecial <init> : ()V
/*      */     //   398: athrow
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #316	-> 0
/*      */     //   #318	-> 124
/*      */     //   #324	-> 126
/*      */     //   #326	-> 129
/*      */     //   #328	-> 132
/*      */     //   #330	-> 135
/*      */     //   #332	-> 138
/*      */     //   #333	-> 152
/*      */     //   #335	-> 161
/*      */     //   #336	-> 165
/*      */     //   #337	-> 175
/*      */     //   #340	-> 181
/*      */     //   #342	-> 300
/*      */     //   #343	-> 303
/*      */     //   #345	-> 306
/*      */     //   #346	-> 309
/*      */     //   #348	-> 312
/*      */     //   #349	-> 315
/*      */     //   #351	-> 318
/*      */     //   #352	-> 321
/*      */     //   #354	-> 324
/*      */     //   #355	-> 327
/*      */     //   #357	-> 330
/*      */     //   #358	-> 333
/*      */     //   #360	-> 336
/*      */     //   #361	-> 339
/*      */     //   #363	-> 342
/*      */     //   #364	-> 345
/*      */     //   #366	-> 348
/*      */     //   #367	-> 362
/*      */     //   #368	-> 371
/*      */     //   #370	-> 374
/*      */     //   #372	-> 382
/*      */     //   #374	-> 391
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
/*      */   final void a(SymbolTable paramSymbolTable, int paramInt1, String paramString, int paramInt2) {
/*  397 */     this.inputLocals = new int[paramInt2];
/*  398 */     this.inputStack = new int[0];
/*  399 */     byte b1 = 0;
/*  400 */     if ((paramInt1 & 0x8) == 0)
/*  401 */       if ((paramInt1 & 0x40000) == 0) {
/*  402 */         b1++; this.inputLocals[0] = 0x800000 | paramSymbolTable
/*  403 */           .f(paramSymbolTable.c());
/*      */       } else {
/*  405 */         b1++; this.inputLocals[0] = 4194310;
/*      */       }   Type[] arrayOfType; int i;
/*      */     byte b2;
/*  408 */     for (i = (arrayOfType = Type.getArgumentTypes(paramString)).length, b2 = 0; b2 < i; ) { Type type = arrayOfType[b2];
/*      */       
/*  410 */       int j = getAbstractTypeFromDescriptor(paramSymbolTable, type.getDescriptor(), 0);
/*  411 */       this.inputLocals[b1++] = j;
/*  412 */       if (j == 4194308 || j == 4194307)
/*  413 */         this.inputLocals[b1++] = 4194304; 
/*      */       b2++; }
/*      */     
/*  416 */     while (b1 < paramInt2) {
/*  417 */       this.inputLocals[b1++] = 4194304;
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
/*      */   final void a(SymbolTable paramSymbolTable, int paramInt1, Object[] paramArrayOfObject1, int paramInt2, Object[] paramArrayOfObject2) {
/*  438 */     byte b2 = 0; byte b3;
/*  439 */     for (b3 = 0; b3 < paramInt1; b3++) {
/*  440 */       this.inputLocals[b2++] = a(paramSymbolTable, paramArrayOfObject1[b3]);
/*  441 */       if (paramArrayOfObject1[b3] == Opcodes.LONG || paramArrayOfObject1[b3] == Opcodes.DOUBLE) {
/*  442 */         this.inputLocals[b2++] = 4194304;
/*      */       }
/*      */     } 
/*  445 */     while (b2 < this.inputLocals.length) {
/*  446 */       this.inputLocals[b2++] = 4194304;
/*      */     }
/*  448 */     b3 = 0;
/*  449 */     for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
/*  450 */       if (paramArrayOfObject2[paramInt1] == Opcodes.LONG || paramArrayOfObject2[paramInt1] == Opcodes.DOUBLE) {
/*  451 */         b3++;
/*      */       }
/*      */     } 
/*  454 */     this.inputStack = new int[paramInt2 + b3];
/*  455 */     paramInt1 = 0;
/*  456 */     for (byte b1 = 0; b1 < paramInt2; b1++) {
/*  457 */       this.inputStack[paramInt1++] = a(paramSymbolTable, paramArrayOfObject2[b1]);
/*  458 */       if (paramArrayOfObject2[b1] == Opcodes.LONG || paramArrayOfObject2[b1] == Opcodes.DOUBLE) {
/*  459 */         this.inputStack[paramInt1++] = 4194304;
/*      */       }
/*      */     } 
/*  462 */     this.outputStackTop = 0;
/*  463 */     this.initializationCount = 0;
/*      */   }
/*      */   
/*      */   final int a() {
/*  467 */     return this.inputStack.length;
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
/*      */   private int getLocal(int paramInt) {
/*  481 */     if (this.outputLocals == null || paramInt >= this.outputLocals.length)
/*      */     {
/*      */       
/*  484 */       return 0x1000000 | paramInt;
/*      */     }
/*      */     int i;
/*  487 */     if ((i = this.outputLocals[paramInt]) == 0)
/*      */     {
/*      */       
/*  490 */       i = this.outputLocals[paramInt] = 0x1000000 | paramInt;
/*      */     }
/*  492 */     return i;
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
/*      */   private void setLocal(int paramInt1, int paramInt2) {
/*  504 */     if (this.outputLocals == null) {
/*  505 */       this.outputLocals = new int[10];
/*      */     }
/*  507 */     int i = this.outputLocals.length;
/*  508 */     if (paramInt1 >= i) {
/*  509 */       int[] arrayOfInt = new int[Math.max(paramInt1 + 1, 2 * i)];
/*  510 */       System.arraycopy(this.outputLocals, 0, arrayOfInt, 0, i);
/*  511 */       this.outputLocals = arrayOfInt;
/*      */     } 
/*      */     
/*  514 */     this.outputLocals[paramInt1] = paramInt2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void push(int paramInt) {
/*  524 */     if (this.outputStack == null) {
/*  525 */       this.outputStack = new int[10];
/*      */     }
/*  527 */     int i = this.outputStack.length;
/*  528 */     if (this.outputStackTop >= i) {
/*  529 */       int[] arrayOfInt = new int[Math.max(this.outputStackTop + 1, 2 * i)];
/*  530 */       System.arraycopy(this.outputStack, 0, arrayOfInt, 0, i);
/*  531 */       this.outputStack = arrayOfInt;
/*      */     } 
/*      */     
/*  534 */     this.outputStackTop = (short)(this.outputStackTop + 1); this.outputStack[this.outputStackTop] = paramInt;
/*      */     
/*      */     short s;
/*      */     
/*  538 */     if ((s = (short)(this.outputStackStart + this.outputStackTop)) > this.a.f) {
/*  539 */       this.a.f = s;
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
/*      */   private void push(SymbolTable paramSymbolTable, String paramString) {
/*  551 */     boolean bool = (paramString.charAt(0) == '(') ? Type.a(paramString) : false;
/*      */     int i;
/*  553 */     if ((i = getAbstractTypeFromDescriptor(paramSymbolTable, paramString, bool)) != 0) {
/*  554 */       push(i);
/*  555 */       if (i == 4194308 || i == 4194307) {
/*  556 */         push(4194304);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int pop() {
/*  567 */     if (this.outputStackTop > 0) {
/*  568 */       return this.outputStack[this.outputStackTop = (short)(this.outputStackTop - 1)];
/*      */     }
/*      */     
/*  571 */     return 0x1400000 | -(this.outputStackStart = (short)(this.outputStackStart - 1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void pop(int paramInt) {
/*  581 */     if (this.outputStackTop >= paramInt) {
/*  582 */       this.outputStackTop = (short)(this.outputStackTop - paramInt);
/*      */       
/*      */       return;
/*      */     } 
/*  586 */     this.outputStackStart = (short)(this.outputStackStart - paramInt - this.outputStackTop);
/*  587 */     this.outputStackTop = 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void pop(String paramString) {
/*      */     char c;
/*  598 */     if ((c = paramString.charAt(0)) == '(') {
/*  599 */       pop((Type.getArgumentsAndReturnSizes(paramString) >> 2) - 1); return;
/*  600 */     }  if (c == 'J' || c == 'D') {
/*  601 */       pop(2); return;
/*      */     } 
/*  603 */     pop(1);
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
/*      */   private void addInitializedType(int paramInt) {
/*  619 */     if (this.initializations == null) {
/*  620 */       this.initializations = new int[2];
/*      */     }
/*  622 */     int i = this.initializations.length;
/*  623 */     if (this.initializationCount >= i) {
/*      */       
/*  625 */       int[] arrayOfInt = new int[Math.max(this.initializationCount + 1, 2 * i)];
/*  626 */       System.arraycopy(this.initializations, 0, arrayOfInt, 0, i);
/*  627 */       this.initializations = arrayOfInt;
/*      */     } 
/*      */     
/*  630 */     this.initializations[this.initializationCount++] = paramInt;
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
/*      */   private int getInitializedType(SymbolTable paramSymbolTable, int paramInt) {
/*  643 */     if (paramInt == 4194310 || (paramInt & 0xFFC00000) == 12582912)
/*      */     {
/*  645 */       for (byte b = 0; b < this.initializationCount; b++) {
/*      */         
/*  647 */         int i, j = (i = this.initializations[b]) & 0xFC000000;
/*  648 */         int k = i & 0x3C00000;
/*  649 */         int m = i & 0xFFFFF;
/*  650 */         if (k == 16777216) {
/*  651 */           i = j + this.inputLocals[m];
/*  652 */         } else if (k == 20971520) {
/*  653 */           i = j + this.inputStack[this.inputStack.length - m];
/*      */         } 
/*  655 */         if (paramInt == i) {
/*  656 */           if (paramInt == 4194310) {
/*  657 */             return 0x800000 | paramSymbolTable.f(paramSymbolTable.c());
/*      */           }
/*  659 */           return 0x800000 | paramSymbolTable
/*  660 */             .f((paramSymbolTable.b(paramInt & 0xFFFFF)).e);
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/*  665 */     return paramInt;
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
/*      */   void a(int paramInt1, int paramInt2, Symbol paramSymbol, SymbolTable paramSymbolTable) {
/*      */     String str;
/*      */     int i;
/*      */     int j;
/*  687 */     switch (paramInt1) {
/*      */       case 0:
/*      */       case 116:
/*      */       case 117:
/*      */       case 118:
/*      */       case 119:
/*      */       case 145:
/*      */       case 146:
/*      */       case 147:
/*      */       case 167:
/*      */       case 177:
/*      */         return;
/*      */       case 1:
/*  700 */         push(4194309);
/*      */         return;
/*      */       case 2:
/*      */       case 3:
/*      */       case 4:
/*      */       case 5:
/*      */       case 6:
/*      */       case 7:
/*      */       case 8:
/*      */       case 16:
/*      */       case 17:
/*      */       case 21:
/*  712 */         push(4194305);
/*      */         return;
/*      */       case 9:
/*      */       case 10:
/*      */       case 22:
/*  717 */         push(4194308);
/*  718 */         push(4194304);
/*      */         return;
/*      */       case 11:
/*      */       case 12:
/*      */       case 13:
/*      */       case 23:
/*  724 */         push(4194306);
/*      */         return;
/*      */       case 14:
/*      */       case 15:
/*      */       case 24:
/*  729 */         push(4194307);
/*  730 */         push(4194304);
/*      */         return;
/*      */       case 18:
/*  733 */         switch (paramSymbol.b) {
/*      */           case 3:
/*  735 */             push(4194305);
/*      */             return;
/*      */           case 5:
/*  738 */             push(4194308);
/*  739 */             push(4194304);
/*      */             return;
/*      */           case 4:
/*  742 */             push(4194306);
/*      */             return;
/*      */           case 6:
/*  745 */             push(4194307);
/*  746 */             push(4194304);
/*      */             return;
/*      */           case 7:
/*  749 */             push(0x800000 | paramSymbolTable.f("java/lang/Class"));
/*      */             return;
/*      */           case 8:
/*  752 */             push(0x800000 | paramSymbolTable.f("java/lang/String"));
/*      */             return;
/*      */           case 16:
/*  755 */             push(0x800000 | paramSymbolTable.f("java/lang/invoke/MethodType"));
/*      */             return;
/*      */           case 15:
/*  758 */             push(0x800000 | paramSymbolTable.f("java/lang/invoke/MethodHandle"));
/*      */             return;
/*      */           case 17:
/*  761 */             push(paramSymbolTable, paramSymbol.e);
/*      */             return;
/*      */         } 
/*  764 */         throw new AssertionError();
/*      */ 
/*      */       
/*      */       case 25:
/*  768 */         push(getLocal(paramInt2));
/*      */         return;
/*      */       case 47:
/*      */       case 143:
/*  772 */         pop(2);
/*  773 */         push(4194308);
/*  774 */         push(4194304);
/*      */         return;
/*      */       case 49:
/*      */       case 138:
/*  778 */         pop(2);
/*  779 */         push(4194307);
/*  780 */         push(4194304);
/*      */         return;
/*      */       case 50:
/*  783 */         pop(1);
/*  784 */         j = pop();
/*  785 */         push((j == 4194309) ? j : (j + -67108864));
/*      */         return;
/*      */       case 54:
/*      */       case 56:
/*      */       case 58:
/*  790 */         j = pop();
/*  791 */         setLocal(paramInt2, j);
/*  792 */         if (paramInt2 > 0)
/*      */         {
/*  794 */           if ((paramInt1 = getLocal(paramInt2 - 1)) == 4194308 || paramInt1 == 4194307)
/*  795 */           { setLocal(paramInt2 - 1, 4194304); }
/*  796 */           else { if ((paramInt1 & 0x3C00000) == 16777216 || (paramInt1 & 0x3C00000) == 20971520)
/*      */             {
/*      */ 
/*      */               
/*  800 */               setLocal(paramInt2 - 1, paramInt1 | 0x100000); } 
/*      */             return; }
/*      */            } 
/*      */         return;
/*      */       case 55:
/*      */       case 57:
/*  806 */         pop(1);
/*  807 */         j = pop();
/*  808 */         setLocal(paramInt2, j);
/*  809 */         setLocal(paramInt2 + 1, 4194304);
/*  810 */         if (paramInt2 > 0)
/*      */         {
/*  812 */           if ((paramInt1 = getLocal(paramInt2 - 1)) == 4194308 || paramInt1 == 4194307)
/*  813 */           { setLocal(paramInt2 - 1, 4194304); }
/*  814 */           else { if ((paramInt1 & 0x3C00000) == 16777216 || (paramInt1 & 0x3C00000) == 20971520)
/*      */             {
/*      */ 
/*      */               
/*  818 */               setLocal(paramInt2 - 1, paramInt1 | 0x100000); } 
/*      */             return; }
/*      */            } 
/*      */         return;
/*      */       case 79:
/*      */       case 81:
/*      */       case 83:
/*      */       case 84:
/*      */       case 85:
/*      */       case 86:
/*  828 */         pop(3);
/*      */         return;
/*      */       case 80:
/*      */       case 82:
/*  832 */         pop(4);
/*      */         return;
/*      */       case 87:
/*      */       case 153:
/*      */       case 154:
/*      */       case 155:
/*      */       case 156:
/*      */       case 157:
/*      */       case 158:
/*      */       case 170:
/*      */       case 171:
/*      */       case 172:
/*      */       case 174:
/*      */       case 176:
/*      */       case 191:
/*      */       case 194:
/*      */       case 195:
/*      */       case 198:
/*      */       case 199:
/*  851 */         pop(1);
/*      */         return;
/*      */       case 88:
/*      */       case 159:
/*      */       case 160:
/*      */       case 161:
/*      */       case 162:
/*      */       case 163:
/*      */       case 164:
/*      */       case 165:
/*      */       case 166:
/*      */       case 173:
/*      */       case 175:
/*  864 */         pop(2);
/*      */         return;
/*      */       case 89:
/*  867 */         j = pop();
/*  868 */         push(j);
/*  869 */         push(j);
/*      */         return;
/*      */       case 90:
/*  872 */         j = pop();
/*  873 */         paramInt1 = pop();
/*  874 */         push(j);
/*  875 */         push(paramInt1);
/*  876 */         push(j);
/*      */         return;
/*      */       case 91:
/*  879 */         j = pop();
/*  880 */         paramInt1 = pop();
/*  881 */         paramInt2 = pop();
/*  882 */         push(j);
/*  883 */         push(paramInt2);
/*  884 */         push(paramInt1);
/*  885 */         push(j);
/*      */         return;
/*      */       case 92:
/*  888 */         j = pop();
/*  889 */         paramInt1 = pop();
/*  890 */         push(paramInt1);
/*  891 */         push(j);
/*  892 */         push(paramInt1);
/*  893 */         push(j);
/*      */         return;
/*      */       case 93:
/*  896 */         j = pop();
/*  897 */         paramInt1 = pop();
/*  898 */         paramInt2 = pop();
/*  899 */         push(paramInt1);
/*  900 */         push(j);
/*  901 */         push(paramInt2);
/*  902 */         push(paramInt1);
/*  903 */         push(j);
/*      */         return;
/*      */       case 94:
/*  906 */         j = pop();
/*  907 */         paramInt1 = pop();
/*  908 */         paramInt2 = pop();
/*  909 */         i = pop();
/*  910 */         push(paramInt1);
/*  911 */         push(j);
/*  912 */         push(i);
/*  913 */         push(paramInt2);
/*  914 */         push(paramInt1);
/*  915 */         push(j);
/*      */         return;
/*      */       case 95:
/*  918 */         j = pop();
/*  919 */         paramInt1 = pop();
/*  920 */         push(j);
/*  921 */         push(paramInt1);
/*      */         return;
/*      */       case 46:
/*      */       case 51:
/*      */       case 52:
/*      */       case 53:
/*      */       case 96:
/*      */       case 100:
/*      */       case 104:
/*      */       case 108:
/*      */       case 112:
/*      */       case 120:
/*      */       case 122:
/*      */       case 124:
/*      */       case 126:
/*      */       case 128:
/*      */       case 130:
/*      */       case 136:
/*      */       case 142:
/*      */       case 149:
/*      */       case 150:
/*  942 */         pop(2);
/*  943 */         push(4194305);
/*      */         return;
/*      */       case 97:
/*      */       case 101:
/*      */       case 105:
/*      */       case 109:
/*      */       case 113:
/*      */       case 127:
/*      */       case 129:
/*      */       case 131:
/*  953 */         pop(4);
/*  954 */         push(4194308);
/*  955 */         push(4194304);
/*      */         return;
/*      */       case 48:
/*      */       case 98:
/*      */       case 102:
/*      */       case 106:
/*      */       case 110:
/*      */       case 114:
/*      */       case 137:
/*      */       case 144:
/*  965 */         pop(2);
/*  966 */         push(4194306);
/*      */         return;
/*      */       case 99:
/*      */       case 103:
/*      */       case 107:
/*      */       case 111:
/*      */       case 115:
/*  973 */         pop(4);
/*  974 */         push(4194307);
/*  975 */         push(4194304);
/*      */         return;
/*      */       case 121:
/*      */       case 123:
/*      */       case 125:
/*  980 */         pop(3);
/*  981 */         push(4194308);
/*  982 */         push(4194304);
/*      */         return;
/*      */       case 132:
/*  985 */         setLocal(paramInt2, 4194305);
/*      */         return;
/*      */       case 133:
/*      */       case 140:
/*  989 */         pop(1);
/*  990 */         push(4194308);
/*  991 */         push(4194304);
/*      */         return;
/*      */       case 134:
/*  994 */         pop(1);
/*  995 */         push(4194306);
/*      */         return;
/*      */       case 135:
/*      */       case 141:
/*  999 */         pop(1);
/* 1000 */         push(4194307);
/* 1001 */         push(4194304);
/*      */         return;
/*      */       case 139:
/*      */       case 190:
/*      */       case 193:
/* 1006 */         pop(1);
/* 1007 */         push(4194305);
/*      */         return;
/*      */       case 148:
/*      */       case 151:
/*      */       case 152:
/* 1012 */         pop(4);
/* 1013 */         push(4194305);
/*      */         return;
/*      */       case 168:
/*      */       case 169:
/* 1017 */         throw new IllegalArgumentException("JSR/RET are not supported with computeFrames option");
/*      */       case 178:
/* 1019 */         push(paramSymbolTable, i.e);
/*      */         return;
/*      */       case 179:
/* 1022 */         pop(i.e);
/*      */         return;
/*      */       case 180:
/* 1025 */         pop(1);
/* 1026 */         push(paramSymbolTable, i.e);
/*      */         return;
/*      */       case 181:
/* 1029 */         pop(i.e);
/* 1030 */         pop();
/*      */         return;
/*      */       case 182:
/*      */       case 183:
/*      */       case 184:
/*      */       case 185:
/* 1036 */         pop(i.e);
/* 1037 */         if (paramInt1 != 184) {
/* 1038 */           j = pop();
/* 1039 */           if (paramInt1 == 183 && i.d.charAt(0) == '<') {
/* 1040 */             addInitializedType(j);
/*      */           }
/*      */         } 
/* 1043 */         push(paramSymbolTable, i.e);
/*      */         return;
/*      */       case 186:
/* 1046 */         pop(i.e);
/* 1047 */         push(paramSymbolTable, i.e);
/*      */         return;
/*      */       case 187:
/* 1050 */         push(0xC00000 | paramSymbolTable.a(i.e, paramInt2));
/*      */         return;
/*      */       case 188:
/* 1053 */         pop();
/* 1054 */         switch (paramInt2) {
/*      */           case 4:
/* 1056 */             push(71303177);
/*      */             return;
/*      */           case 5:
/* 1059 */             push(71303179);
/*      */             return;
/*      */           case 8:
/* 1062 */             push(71303178);
/*      */             return;
/*      */           case 9:
/* 1065 */             push(71303180);
/*      */             return;
/*      */           case 10:
/* 1068 */             push(71303169);
/*      */             return;
/*      */           case 6:
/* 1071 */             push(71303170);
/*      */             return;
/*      */           case 7:
/* 1074 */             push(71303171);
/*      */             return;
/*      */           case 11:
/* 1077 */             push(71303172);
/*      */             return;
/*      */         } 
/* 1080 */         throw new IllegalArgumentException();
/*      */ 
/*      */       
/*      */       case 189:
/* 1084 */         str = i.e;
/* 1085 */         pop();
/* 1086 */         if (str.charAt(0) == '[') {
/* 1087 */           push(paramSymbolTable, "[" + str); return;
/*      */         } 
/* 1089 */         push(0x4800000 | paramSymbolTable.f(str));
/*      */         return;
/*      */       
/*      */       case 192:
/* 1093 */         str = i.e;
/* 1094 */         pop();
/* 1095 */         if (str.charAt(0) == '[') {
/* 1096 */           push(paramSymbolTable, str); return;
/*      */         } 
/* 1098 */         push(0x800000 | paramSymbolTable.f(str));
/*      */         return;
/*      */       
/*      */       case 197:
/* 1102 */         pop(paramInt2);
/* 1103 */         push(paramSymbolTable, i.e);
/*      */         return;
/*      */     } 
/* 1106 */     throw new IllegalArgumentException();
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
/*      */   private int getConcreteOutputType(int paramInt1, int paramInt2) {
/* 1123 */     int i = paramInt1 & 0xFC000000;
/*      */     int j;
/* 1125 */     if ((j = paramInt1 & 0x3C00000) == 16777216) {
/*      */ 
/*      */ 
/*      */       
/* 1129 */       paramInt2 = i + this.inputLocals[paramInt1 & 0xFFFFF];
/* 1130 */       if ((paramInt1 & 0x100000) != 0 && (paramInt2 == 4194308 || paramInt2 == 4194307))
/*      */       {
/* 1132 */         paramInt2 = 4194304;
/*      */       }
/* 1134 */       return paramInt2;
/* 1135 */     }  if (j == 20971520) {
/*      */ 
/*      */ 
/*      */       
/* 1139 */       paramInt2 = i + this.inputStack[paramInt2 - (paramInt1 & 0xFFFFF)];
/* 1140 */       if ((paramInt1 & 0x100000) != 0 && (paramInt2 == 4194308 || paramInt2 == 4194307))
/*      */       {
/* 1142 */         paramInt2 = 4194304;
/*      */       }
/* 1144 */       return paramInt2;
/*      */     } 
/* 1146 */     return paramInt1;
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
/*      */   final boolean a(SymbolTable paramSymbolTable, Frame paramFrame, int paramInt) {
/* 1164 */     boolean bool = false;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1169 */     int i = this.inputLocals.length;
/* 1170 */     int j = this.inputStack.length;
/* 1171 */     if (paramFrame.inputLocals == null) {
/* 1172 */       paramFrame.inputLocals = new int[i];
/* 1173 */       bool = true;
/*      */     }  int k;
/* 1175 */     for (k = 0; k < i; k++) {
/*      */       int m;
/* 1177 */       if (this.outputLocals != null && k < this.outputLocals.length) {
/*      */         int n;
/* 1179 */         if ((n = this.outputLocals[k]) == 0) {
/*      */ 
/*      */           
/* 1182 */           m = this.inputLocals[k];
/*      */         } else {
/* 1184 */           m = getConcreteOutputType(n, j);
/*      */         }
/*      */       
/*      */       } else {
/*      */         
/* 1189 */         m = this.inputLocals[k];
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1194 */       if (this.initializations != null) {
/* 1195 */         m = getInitializedType(paramSymbolTable, m);
/*      */       }
/* 1197 */       bool |= merge(paramSymbolTable, m, paramFrame.inputLocals, k);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1205 */     if (paramInt > 0) {
/* 1206 */       for (k = 0; k < i; k++) {
/* 1207 */         bool |= merge(paramSymbolTable, this.inputLocals[k], paramFrame.inputLocals, k);
/*      */       }
/* 1209 */       if (paramFrame.inputStack == null) {
/* 1210 */         paramFrame.inputStack = new int[1];
/* 1211 */         bool = true;
/*      */       } 
/*      */       
/* 1214 */       return bool = bool | merge(paramSymbolTable, paramInt, paramFrame.inputStack, 0);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1220 */     k = this.inputStack.length + this.outputStackStart;
/* 1221 */     if (paramFrame.inputStack == null) {
/* 1222 */       paramFrame.inputStack = new int[k + this.outputStackTop];
/* 1223 */       bool = true;
/*      */     } 
/*      */     
/*      */     byte b;
/*      */     
/* 1228 */     for (b = 0; b < k; b++) {
/* 1229 */       int m = this.inputStack[b];
/* 1230 */       if (this.initializations != null) {
/* 1231 */         m = getInitializedType(paramSymbolTable, m);
/*      */       }
/* 1233 */       bool |= merge(paramSymbolTable, m, paramFrame.inputStack, b);
/*      */     } 
/*      */ 
/*      */     
/* 1237 */     for (b = 0; b < this.outputStackTop; b++) {
/* 1238 */       int m = this.outputStack[b];
/* 1239 */       paramInt = getConcreteOutputType(m, j);
/* 1240 */       if (this.initializations != null) {
/* 1241 */         paramInt = getInitializedType(paramSymbolTable, paramInt);
/*      */       }
/* 1243 */       bool |= 
/* 1244 */         merge(paramSymbolTable, paramInt, paramFrame.inputStack, k + b);
/*      */     } 
/* 1246 */     return bool;
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
/*      */   private static boolean merge(SymbolTable paramSymbolTable, int paramInt1, int[] paramArrayOfint, int paramInt2) {
/*      */     // Byte code:
/*      */     //   0: aload_2
/*      */     //   1: iload_3
/*      */     //   2: iaload
/*      */     //   3: dup
/*      */     //   4: istore #4
/*      */     //   6: iload_1
/*      */     //   7: if_icmpne -> 12
/*      */     //   10: iconst_0
/*      */     //   11: ireturn
/*      */     //   12: iload_1
/*      */     //   13: istore #5
/*      */     //   15: iload_1
/*      */     //   16: ldc 67108863
/*      */     //   18: iand
/*      */     //   19: ldc 4194309
/*      */     //   21: if_icmpne -> 37
/*      */     //   24: iload #4
/*      */     //   26: ldc 4194309
/*      */     //   28: if_icmpne -> 33
/*      */     //   31: iconst_0
/*      */     //   32: ireturn
/*      */     //   33: ldc 4194309
/*      */     //   35: istore #5
/*      */     //   37: iload #4
/*      */     //   39: ifne -> 49
/*      */     //   42: aload_2
/*      */     //   43: iload_3
/*      */     //   44: iload #5
/*      */     //   46: iastore
/*      */     //   47: iconst_1
/*      */     //   48: ireturn
/*      */     //   49: iload #4
/*      */     //   51: ldc -67108864
/*      */     //   53: iand
/*      */     //   54: ifne -> 67
/*      */     //   57: iload #4
/*      */     //   59: ldc 62914560
/*      */     //   61: iand
/*      */     //   62: ldc 8388608
/*      */     //   64: if_icmpne -> 240
/*      */     //   67: iload #5
/*      */     //   69: ldc 4194309
/*      */     //   71: if_icmpne -> 76
/*      */     //   74: iconst_0
/*      */     //   75: ireturn
/*      */     //   76: iload_1
/*      */     //   77: ldc -4194304
/*      */     //   79: iand
/*      */     //   80: iload #4
/*      */     //   82: ldc -4194304
/*      */     //   84: iand
/*      */     //   85: if_icmpne -> 147
/*      */     //   88: iload #4
/*      */     //   90: ldc 62914560
/*      */     //   92: iand
/*      */     //   93: ldc 8388608
/*      */     //   95: if_icmpne -> 123
/*      */     //   98: iload_1
/*      */     //   99: ldc -67108864
/*      */     //   101: iand
/*      */     //   102: ldc 8388608
/*      */     //   104: ior
/*      */     //   105: aload_0
/*      */     //   106: iload_1
/*      */     //   107: ldc 1048575
/*      */     //   109: iand
/*      */     //   110: iload #4
/*      */     //   112: ldc 1048575
/*      */     //   114: iand
/*      */     //   115: invokevirtual a : (II)I
/*      */     //   118: ior
/*      */     //   119: istore_0
/*      */     //   120: goto -> 278
/*      */     //   123: ldc -67108864
/*      */     //   125: iload_1
/*      */     //   126: ldc -67108864
/*      */     //   128: iand
/*      */     //   129: iadd
/*      */     //   130: dup
/*      */     //   131: istore #5
/*      */     //   133: ldc 8388608
/*      */     //   135: ior
/*      */     //   136: aload_0
/*      */     //   137: ldc 'java/lang/Object'
/*      */     //   139: invokevirtual f : (Ljava/lang/String;)I
/*      */     //   142: ior
/*      */     //   143: istore_0
/*      */     //   144: goto -> 278
/*      */     //   147: iload_1
/*      */     //   148: ldc -67108864
/*      */     //   150: iand
/*      */     //   151: ifne -> 163
/*      */     //   154: iload_1
/*      */     //   155: ldc 62914560
/*      */     //   157: iand
/*      */     //   158: ldc 8388608
/*      */     //   160: if_icmpne -> 234
/*      */     //   163: iload_1
/*      */     //   164: ldc -67108864
/*      */     //   166: iand
/*      */     //   167: dup
/*      */     //   168: istore #5
/*      */     //   170: ifeq -> 189
/*      */     //   173: iload_1
/*      */     //   174: ldc 62914560
/*      */     //   176: iand
/*      */     //   177: ldc 8388608
/*      */     //   179: if_icmpeq -> 189
/*      */     //   182: iload #5
/*      */     //   184: ldc -67108864
/*      */     //   186: iadd
/*      */     //   187: istore #5
/*      */     //   189: iload #4
/*      */     //   191: ldc -67108864
/*      */     //   193: iand
/*      */     //   194: dup
/*      */     //   195: istore_1
/*      */     //   196: ifeq -> 214
/*      */     //   199: iload #4
/*      */     //   201: ldc 62914560
/*      */     //   203: iand
/*      */     //   204: ldc 8388608
/*      */     //   206: if_icmpeq -> 214
/*      */     //   209: iload_1
/*      */     //   210: ldc -67108864
/*      */     //   212: iadd
/*      */     //   213: istore_1
/*      */     //   214: iload #5
/*      */     //   216: iload_1
/*      */     //   217: invokestatic min : (II)I
/*      */     //   220: ldc 8388608
/*      */     //   222: ior
/*      */     //   223: aload_0
/*      */     //   224: ldc 'java/lang/Object'
/*      */     //   226: invokevirtual f : (Ljava/lang/String;)I
/*      */     //   229: ior
/*      */     //   230: istore_0
/*      */     //   231: goto -> 278
/*      */     //   234: ldc 4194304
/*      */     //   236: istore_0
/*      */     //   237: goto -> 278
/*      */     //   240: iload #4
/*      */     //   242: ldc 4194309
/*      */     //   244: if_icmpne -> 275
/*      */     //   247: iload #5
/*      */     //   249: ldc -67108864
/*      */     //   251: iand
/*      */     //   252: ifne -> 265
/*      */     //   255: iload #5
/*      */     //   257: ldc 62914560
/*      */     //   259: iand
/*      */     //   260: ldc 8388608
/*      */     //   262: if_icmpne -> 269
/*      */     //   265: iload_1
/*      */     //   266: goto -> 271
/*      */     //   269: ldc 4194304
/*      */     //   271: istore_0
/*      */     //   272: goto -> 278
/*      */     //   275: ldc 4194304
/*      */     //   277: istore_0
/*      */     //   278: iload_0
/*      */     //   279: iload #4
/*      */     //   281: if_icmpeq -> 290
/*      */     //   284: aload_2
/*      */     //   285: iload_3
/*      */     //   286: iload_0
/*      */     //   287: iastore
/*      */     //   288: iconst_1
/*      */     //   289: ireturn
/*      */     //   290: iconst_0
/*      */     //   291: ireturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1268	-> 0
/*      */     //   #1269	-> 4
/*      */     //   #1271	-> 10
/*      */     //   #1273	-> 12
/*      */     //   #1274	-> 15
/*      */     //   #1275	-> 24
/*      */     //   #1276	-> 31
/*      */     //   #1278	-> 33
/*      */     //   #1280	-> 37
/*      */     //   #1282	-> 42
/*      */     //   #1283	-> 47
/*      */     //   #1286	-> 49
/*      */     //   #1288	-> 67
/*      */     //   #1290	-> 74
/*      */     //   #1291	-> 76
/*      */     //   #1293	-> 88
/*      */     //   #1296	-> 98
/*      */     //   #1299	-> 115
/*      */     //   #1303	-> 123
/*      */     //   #1304	-> 131
/*      */     //   #1305	-> 144
/*      */     //   #1306	-> 147
/*      */     //   #1311	-> 163
/*      */     //   #1312	-> 168
/*      */     //   #1313	-> 182
/*      */     //   #1315	-> 189
/*      */     //   #1316	-> 195
/*      */     //   #1317	-> 209
/*      */     //   #1319	-> 214
/*      */     //   #1320	-> 217
/*      */     //   #1321	-> 231
/*      */     //   #1323	-> 234
/*      */     //   #1325	-> 240
/*      */     //   #1329	-> 247
/*      */     //   #1332	-> 275
/*      */     //   #1334	-> 278
/*      */     //   #1335	-> 284
/*      */     //   #1336	-> 288
/*      */     //   #1338	-> 290
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
/*      */   final void a(MethodWriter paramMethodWriter) {
/* 1356 */     int[] arrayOfInt1 = this.inputLocals;
/* 1357 */     int i = 0;
/* 1358 */     byte b = 0;
/* 1359 */     int j = 0;
/* 1360 */     while (j < arrayOfInt1.length) {
/* 1361 */       int m = arrayOfInt1[j];
/* 1362 */       j += (m == 4194308 || m == 4194307) ? 2 : 1;
/* 1363 */       if (m == 4194304) {
/* 1364 */         b++; continue;
/*      */       } 
/* 1366 */       i += b + 1;
/* 1367 */       b = 0;
/*      */     } 
/*      */ 
/*      */     
/* 1371 */     int[] arrayOfInt2 = this.inputStack;
/* 1372 */     b = 0;
/* 1373 */     j = 0;
/* 1374 */     while (j < arrayOfInt2.length) {
/* 1375 */       int m = arrayOfInt2[j];
/* 1376 */       j += (m == 4194308 || m == 4194307) ? 2 : 1;
/* 1377 */       b++;
/*      */     } 
/*      */     
/* 1380 */     int k = paramMethodWriter.a(this.a.c, i, b);
/* 1381 */     j = 0;
/* 1382 */     while (i-- > 0) {
/* 1383 */       int m = arrayOfInt1[j];
/* 1384 */       j += (m == 4194308 || m == 4194307) ? 2 : 1;
/* 1385 */       paramMethodWriter.a(k++, m);
/*      */     } 
/* 1387 */     j = 0;
/* 1388 */     while (b-- > 0) {
/* 1389 */       int m = arrayOfInt2[j];
/* 1390 */       j += (m == 4194308 || m == 4194307) ? 2 : 1;
/* 1391 */       paramMethodWriter.a(k++, m);
/*      */     } 
/* 1393 */     paramMethodWriter.c();
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
/*      */   static void a(SymbolTable paramSymbolTable, int paramInt, ByteVector paramByteVector) {
/*      */     int i;
/* 1410 */     if ((i = (paramInt & 0xFC000000) >> 26) == 0) {
/* 1411 */       int j = paramInt & 0xFFFFF;
/* 1412 */       switch (paramInt & 0x3C00000) {
/*      */         case 4194304:
/* 1414 */           paramByteVector.putByte(j);
/*      */           return;
/*      */         case 8388608:
/* 1417 */           paramByteVector
/* 1418 */             .putByte(7)
/* 1419 */             .putShort((paramSymbolTable.a((paramSymbolTable.b(j)).e)).a);
/*      */           return;
/*      */         case 12582912:
/* 1422 */           paramByteVector.putByte(8).putShort((int)(paramSymbolTable.b(j)).f);
/*      */           return;
/*      */       } 
/* 1425 */       throw new AssertionError();
/*      */     } 
/*      */ 
/*      */     
/* 1429 */     StringBuilder stringBuilder = new StringBuilder();
/* 1430 */     while (i-- > 0) {
/* 1431 */       stringBuilder.append('[');
/*      */     }
/* 1433 */     if ((paramInt & 0x3C00000) == 8388608) {
/* 1434 */       stringBuilder
/* 1435 */         .append('L')
/* 1436 */         .append((paramSymbolTable.b(paramInt & 0xFFFFF)).e)
/* 1437 */         .append(';');
/*      */     } else {
/* 1439 */       switch (paramInt & 0xFFFFF) {
/*      */         case 9:
/* 1441 */           stringBuilder.append('Z');
/*      */           break;
/*      */         case 10:
/* 1444 */           stringBuilder.append('B');
/*      */           break;
/*      */         case 11:
/* 1447 */           stringBuilder.append('C');
/*      */           break;
/*      */         case 12:
/* 1450 */           stringBuilder.append('S');
/*      */           break;
/*      */         case 1:
/* 1453 */           stringBuilder.append('I');
/*      */           break;
/*      */         case 2:
/* 1456 */           stringBuilder.append('F');
/*      */           break;
/*      */         case 4:
/* 1459 */           stringBuilder.append('J');
/*      */           break;
/*      */         case 3:
/* 1462 */           stringBuilder.append('D');
/*      */           break;
/*      */         default:
/* 1465 */           throw new AssertionError();
/*      */       } 
/*      */     } 
/* 1468 */     paramByteVector
/* 1469 */       .putByte(7)
/* 1470 */       .putShort((paramSymbolTable.a(stringBuilder.toString())).a);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\Frame.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */