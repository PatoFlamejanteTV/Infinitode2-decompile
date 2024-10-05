/*     */ package com.prineside.luaj;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.luaj.debug.CallFrame;
/*     */ import com.prineside.luaj.lib.DebugLib;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS(serializer = LuaClosure.Serializer.class)
/*     */ public final class LuaClosure extends LuaFunction {
/*     */   private static final UpValue[] b;
/*     */   
/*     */   static {
/*  18 */     TLog.forClass(LuaClosure.class);
/*     */ 
/*     */ 
/*     */     
/*  22 */     SyncChecker.addSyncShareableObject(b = new UpValue[0]);
/*     */   }
/*     */   public final FPrototype p;
/*     */   @Null
/*     */   final Globals a;
/*     */   private final UpValue[] c;
/*     */   
/*  29 */   public static final DeepClassComparator<LuaClosure> CLASS_COMPARATOR = new DeepClassComparator<LuaClosure>() {
/*     */       public Class<LuaClosure> forClass() {
/*  31 */         return LuaClosure.class;
/*     */       }
/*     */       
/*     */       public void compare(LuaClosure param1LuaClosure1, LuaClosure param1LuaClosure2, DeepClassComparisonConfig param1DeepClassComparisonConfig) {
/*  35 */         param1DeepClassComparisonConfig.addPrefix(new String[] { "{", param1LuaClosure1.tojstring(), "}" });
/*  36 */         param1DeepClassComparisonConfig.addPrefix(new String[] { ".p" });
/*  37 */         SyncChecker.compareObjects(param1LuaClosure1.p, param1LuaClosure2.p, param1DeepClassComparisonConfig);
/*  38 */         param1DeepClassComparisonConfig.popPrefix(1);
/*  39 */         param1DeepClassComparisonConfig.addPrefix(new String[] { ".globals" });
/*  40 */         SyncChecker.compareObjects(param1LuaClosure1.a, param1LuaClosure2.a, param1DeepClassComparisonConfig);
/*  41 */         param1DeepClassComparisonConfig.popPrefix(1);
/*  42 */         param1DeepClassComparisonConfig.addPrefix(new String[] { ".upValues" });
/*  43 */         SyncChecker.compareObjects(LuaClosure.a(param1LuaClosure1), LuaClosure.a(param1LuaClosure2), param1DeepClassComparisonConfig);
/*  44 */         param1DeepClassComparisonConfig.popPrefix(1);
/*     */         
/*  46 */         param1DeepClassComparisonConfig.popPrefix(3);
/*     */       }
/*     */     };
/*     */   static {
/*  50 */     SyncChecker.CLASS_COMPARATORS.add(CLASS_COMPARATOR);
/*     */   }
/*     */   
/*     */   public static class Serializer
/*     */     extends com.esotericsoftware.kryo.Serializer<LuaClosure> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, LuaClosure param1LuaClosure) {
/*  56 */       param1Kryo.writeClassAndObject(param1Output, param1LuaClosure.p);
/*  57 */       param1Kryo.writeObjectOrNull(param1Output, param1LuaClosure.a, Globals.class);
/*  58 */       param1Kryo.writeObject(param1Output, LuaClosure.a(param1LuaClosure));
/*     */     }
/*     */ 
/*     */     
/*     */     public LuaClosure read(Kryo param1Kryo, Input param1Input, Class<? extends LuaClosure> param1Class) {
/*  63 */       FPrototype fPrototype = (FPrototype)param1Kryo.readClassAndObject(param1Input);
/*  64 */       Globals globals = (Globals)param1Kryo.readObjectOrNull(param1Input, Globals.class);
/*  65 */       UpValue[] arrayOfUpValue = (UpValue[])param1Kryo.readObject(param1Input, UpValue[].class);
/*  66 */       return new LuaClosure(fPrototype, globals, arrayOfUpValue, (byte)0);
/*     */     }
/*     */   }
/*     */   
/*     */   private LuaClosure(FPrototype paramFPrototype, Globals paramGlobals, UpValue[] paramArrayOfUpValue) {
/*  71 */     if (paramArrayOfUpValue == null) {
/*  72 */       paramArrayOfUpValue = b;
/*     */     }
/*  74 */     this.p = paramFPrototype;
/*  75 */     this.a = paramGlobals;
/*  76 */     this.c = paramArrayOfUpValue;
/*     */   }
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
/*     */   public LuaClosure(FPrototype paramFPrototype, LuaValue paramLuaValue) {
/*  89 */     this.p = paramFPrototype;
/*  90 */     if (paramFPrototype.upvalues == null || paramFPrototype.upvalues.length == 0) {
/*  91 */       this.c = b;
/*     */     } else {
/*  93 */       this.c = new UpValue[paramFPrototype.upvalues.length];
/*  94 */       this.c[0] = new UpValue(new LuaValue[] { paramLuaValue }, 0);
/*     */     } 
/*  96 */     this.a = (paramLuaValue instanceof Globals) ? (Globals)paramLuaValue : null;
/*     */   }
/*     */   
/*     */   public final boolean isclosure() {
/* 100 */     return true;
/*     */   }
/*     */   
/*     */   public final LuaClosure optclosure(LuaClosure paramLuaClosure) {
/* 104 */     return this;
/*     */   }
/*     */   
/*     */   public final LuaClosure checkclosure() {
/* 108 */     return this;
/*     */   }
/*     */   
/*     */   public final String tojstring() {
/* 112 */     return "function: " + this.p.toString();
/*     */   }
/*     */   
/*     */   private LuaValue[] d() {
/*     */     byte b;
/* 117 */     LuaValue[] arrayOfLuaValue = new LuaValue[b = this.p.maxstacksize];
/* 118 */     System.arraycopy(NILS, 0, arrayOfLuaValue, 0, b);
/* 119 */     return arrayOfLuaValue;
/*     */   }
/*     */   
/*     */   public final LuaValue call() {
/* 123 */     return a(d(), NONE).arg1();
/*     */   }
/*     */   
/*     */   public final LuaValue call(LuaValue paramLuaValue) {
/* 127 */     LuaValue[] arrayOfLuaValue = d();
/* 128 */     if (this.p.numparams == 0) {
/* 129 */       return a(arrayOfLuaValue, paramLuaValue).arg1();
/*     */     }
/* 131 */     arrayOfLuaValue[0] = paramLuaValue;
/* 132 */     return a(arrayOfLuaValue, NONE).arg1();
/*     */   }
/*     */ 
/*     */   
/*     */   public final LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 137 */     LuaValue[] arrayOfLuaValue = d();
/* 138 */     switch (this.p.numparams) {
/*     */       default:
/* 140 */         arrayOfLuaValue[0] = paramLuaValue1;
/* 141 */         arrayOfLuaValue[1] = paramLuaValue2;
/* 142 */         return a(arrayOfLuaValue, NONE).arg1();
/*     */       
/*     */       case 1:
/* 145 */         arrayOfLuaValue[0] = paramLuaValue1;
/* 146 */         return a(arrayOfLuaValue, paramLuaValue2).arg1();
/*     */       case 0:
/*     */         break;
/* 149 */     }  if (this.p.is_vararg) {
/* 150 */       return a(arrayOfLuaValue, LuaValue.varargsOf(paramLuaValue1, paramLuaValue2)).arg1();
/*     */     }
/* 152 */     return a(arrayOfLuaValue, NONE).arg1();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2, LuaValue paramLuaValue3) {
/* 159 */     LuaValue[] arrayOfLuaValue = d();
/* 160 */     switch (this.p.numparams) {
/*     */       default:
/* 162 */         arrayOfLuaValue[0] = paramLuaValue1;
/* 163 */         arrayOfLuaValue[1] = paramLuaValue2;
/* 164 */         arrayOfLuaValue[2] = paramLuaValue3;
/* 165 */         return a(arrayOfLuaValue, NONE).arg1();
/*     */       
/*     */       case 2:
/* 168 */         arrayOfLuaValue[0] = paramLuaValue1;
/* 169 */         arrayOfLuaValue[1] = paramLuaValue2;
/* 170 */         return a(arrayOfLuaValue, paramLuaValue3).arg1();
/*     */       
/*     */       case 1:
/* 173 */         arrayOfLuaValue[0] = paramLuaValue1;
/* 174 */         if (this.p.is_vararg) {
/* 175 */           return a(arrayOfLuaValue, LuaValue.varargsOf(paramLuaValue2, paramLuaValue3)).arg1();
/*     */         }
/* 177 */         return a(arrayOfLuaValue, NONE).arg1();
/*     */       case 0:
/*     */         break;
/*     */     } 
/* 181 */     if (this.p.is_vararg) {
/* 182 */       return a(arrayOfLuaValue, LuaValue.varargsOf(paramLuaValue1, paramLuaValue2, paramLuaValue3)).arg1();
/*     */     }
/* 184 */     return a(arrayOfLuaValue, NONE).arg1();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Varargs invoke(Varargs paramVarargs) {
/* 192 */     return onInvoke(paramVarargs).eval();
/*     */   }
/*     */   
/*     */   public final Varargs onInvoke(Varargs paramVarargs) {
/* 196 */     LuaValue[] arrayOfLuaValue = d(); int i;
/* 197 */     for (i = 0; i < this.p.numparams; i++) {
/* 198 */       arrayOfLuaValue[i] = paramVarargs.arg(i + 1);
/*     */     }
/*     */     
/* 201 */     if (this.p.is_vararg) {
/*     */       
/* 203 */       if ((i = this.p.numparams + 1) > 1) {
/* 204 */         return a(arrayOfLuaValue, paramVarargs.subargs(i));
/*     */       }
/* 206 */       return a(arrayOfLuaValue, paramVarargs);
/*     */     } 
/*     */     
/* 209 */     return a(arrayOfLuaValue, NONE);
/*     */   }
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
/*     */ 
/*     */ 
/*     */   
/*     */   private Varargs a(LuaValue[] paramArrayOfLuaValue, Varargs paramVarargs) {
/*     */     // Byte code:
/*     */     //   0: iconst_0
/*     */     //   1: istore #7
/*     */     //   3: iconst_0
/*     */     //   4: istore #8
/*     */     //   6: getstatic com/prineside/luaj/LuaClosure.NONE : Lcom/prineside/luaj/LuaValue;
/*     */     //   9: astore #9
/*     */     //   11: aload_0
/*     */     //   12: getfield p : Lcom/prineside/luaj/FPrototype;
/*     */     //   15: getfield code : [I
/*     */     //   18: astore #10
/*     */     //   20: aload_0
/*     */     //   21: getfield p : Lcom/prineside/luaj/FPrototype;
/*     */     //   24: getfield k : [Lcom/prineside/luaj/LuaValue;
/*     */     //   27: astore #11
/*     */     //   29: aload_0
/*     */     //   30: getfield p : Lcom/prineside/luaj/FPrototype;
/*     */     //   33: getfield p : [Lcom/prineside/luaj/FPrototype;
/*     */     //   36: arraylength
/*     */     //   37: ifle -> 48
/*     */     //   40: aload_1
/*     */     //   41: arraylength
/*     */     //   42: anewarray com/prineside/luaj/UpValue
/*     */     //   45: goto -> 49
/*     */     //   48: aconst_null
/*     */     //   49: astore #12
/*     */     //   51: getstatic com/prineside/luaj/debug/CallStack.DUMMY : Lcom/prineside/luaj/debug/CallStack;
/*     */     //   54: astore #13
/*     */     //   56: aload_0
/*     */     //   57: getfield a : Lcom/prineside/luaj/Globals;
/*     */     //   60: ifnull -> 79
/*     */     //   63: aload_0
/*     */     //   64: getfield a : Lcom/prineside/luaj/Globals;
/*     */     //   67: invokevirtual getCallstack : ()Lcom/prineside/luaj/debug/CallStack;
/*     */     //   70: dup
/*     */     //   71: astore #13
/*     */     //   73: aload_0
/*     */     //   74: aload_2
/*     */     //   75: aload_1
/*     */     //   76: invokevirtual onCall : (Lcom/prineside/luaj/LuaClosure;Lcom/prineside/luaj/Varargs;[Lcom/prineside/luaj/LuaValue;)V
/*     */     //   79: aload #13
/*     */     //   81: iload #7
/*     */     //   83: aload #9
/*     */     //   85: iload #8
/*     */     //   87: invokevirtual onInstruction : (ILcom/prineside/luaj/Varargs;I)V
/*     */     //   90: aload #10
/*     */     //   92: iload #7
/*     */     //   94: iaload
/*     */     //   95: dup
/*     */     //   96: istore_3
/*     */     //   97: bipush #6
/*     */     //   99: ishr
/*     */     //   100: sipush #255
/*     */     //   103: iand
/*     */     //   104: istore #4
/*     */     //   106: iload_3
/*     */     //   107: bipush #63
/*     */     //   109: iand
/*     */     //   110: tableswitch default -> 3574, 0 -> 284, 1 -> 297, 2 -> 311, 3 -> 409, 4 -> 442, 5 -> 469, 6 -> 488, 7 -> 543, 8 -> 592, 9 -> 670, 10 -> 689, 11 -> 761, 12 -> 787, 13 -> 847, 14 -> 919, 15 -> 991, 16 -> 1063, 17 -> 1135, 18 -> 1207, 19 -> 1279, 20 -> 1295, 21 -> 1311, 22 -> 1327, 23 -> 1415, 24 -> 1486, 25 -> 1570, 26 -> 1654, 27 -> 1738, 28 -> 1766, 29 -> 1808, 30 -> 2242, 31 -> 2675, 32 -> 2932, 33 -> 3020, 34 -> 3099, 35 -> 3170, 36 -> 3207, 37 -> 3389, 38 -> 3505, 39 -> 3564
/*     */     //   284: aload_1
/*     */     //   285: iload #4
/*     */     //   287: aload_1
/*     */     //   288: iload_3
/*     */     //   289: bipush #23
/*     */     //   291: iushr
/*     */     //   292: aaload
/*     */     //   293: aastore
/*     */     //   294: goto -> 3601
/*     */     //   297: aload_1
/*     */     //   298: iload #4
/*     */     //   300: aload #11
/*     */     //   302: iload_3
/*     */     //   303: bipush #14
/*     */     //   305: iushr
/*     */     //   306: aaload
/*     */     //   307: aastore
/*     */     //   308: goto -> 3601
/*     */     //   311: iinc #7, 1
/*     */     //   314: aload #10
/*     */     //   316: iload #7
/*     */     //   318: iaload
/*     */     //   319: dup
/*     */     //   320: istore_3
/*     */     //   321: bipush #63
/*     */     //   323: iand
/*     */     //   324: bipush #39
/*     */     //   326: if_icmpeq -> 395
/*     */     //   329: iload_3
/*     */     //   330: bipush #63
/*     */     //   332: iand
/*     */     //   333: istore #14
/*     */     //   335: new com/prineside/luaj/LuaError
/*     */     //   338: dup
/*     */     //   339: new java/lang/StringBuilder
/*     */     //   342: dup
/*     */     //   343: ldc 'OP_EXTRAARG expected after OP_LOADKX, got '
/*     */     //   345: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   348: iload #14
/*     */     //   350: getstatic com/prineside/luaj/Print.OPNAMES : [Ljava/lang/String;
/*     */     //   353: arraylength
/*     */     //   354: iconst_1
/*     */     //   355: isub
/*     */     //   356: if_icmpge -> 368
/*     */     //   359: getstatic com/prineside/luaj/Print.OPNAMES : [Ljava/lang/String;
/*     */     //   362: iload #14
/*     */     //   364: aaload
/*     */     //   365: goto -> 385
/*     */     //   368: new java/lang/StringBuilder
/*     */     //   371: dup
/*     */     //   372: ldc 'UNKNOWN_OP_'
/*     */     //   374: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   377: iload #14
/*     */     //   379: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   382: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   385: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   388: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   391: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   394: athrow
/*     */     //   395: aload_1
/*     */     //   396: iload #4
/*     */     //   398: aload #11
/*     */     //   400: iload_3
/*     */     //   401: bipush #6
/*     */     //   403: iushr
/*     */     //   404: aaload
/*     */     //   405: aastore
/*     */     //   406: goto -> 3601
/*     */     //   409: aload_1
/*     */     //   410: iload #4
/*     */     //   412: iload_3
/*     */     //   413: bipush #23
/*     */     //   415: iushr
/*     */     //   416: ifeq -> 425
/*     */     //   419: getstatic com/prineside/luaj/LuaValue.TRUE : Lcom/prineside/luaj/LuaBoolean;
/*     */     //   422: goto -> 428
/*     */     //   425: getstatic com/prineside/luaj/LuaValue.FALSE : Lcom/prineside/luaj/LuaBoolean;
/*     */     //   428: aastore
/*     */     //   429: iload_3
/*     */     //   430: ldc 8372224
/*     */     //   432: iand
/*     */     //   433: ifeq -> 3601
/*     */     //   436: iinc #7, 1
/*     */     //   439: goto -> 3601
/*     */     //   442: iload_3
/*     */     //   443: bipush #23
/*     */     //   445: iushr
/*     */     //   446: istore #5
/*     */     //   448: iload #5
/*     */     //   450: iinc #5, -1
/*     */     //   453: iflt -> 3601
/*     */     //   456: aload_1
/*     */     //   457: iload #4
/*     */     //   459: iinc #4, 1
/*     */     //   462: getstatic com/prineside/luaj/LuaValue.NIL : Lcom/prineside/luaj/LuaValue;
/*     */     //   465: aastore
/*     */     //   466: goto -> 448
/*     */     //   469: aload_1
/*     */     //   470: iload #4
/*     */     //   472: aload_0
/*     */     //   473: getfield c : [Lcom/prineside/luaj/UpValue;
/*     */     //   476: iload_3
/*     */     //   477: bipush #23
/*     */     //   479: iushr
/*     */     //   480: aaload
/*     */     //   481: invokevirtual getValue : ()Lcom/prineside/luaj/LuaValue;
/*     */     //   484: aastore
/*     */     //   485: goto -> 3601
/*     */     //   488: aload_1
/*     */     //   489: iload #4
/*     */     //   491: aload_0
/*     */     //   492: getfield c : [Lcom/prineside/luaj/UpValue;
/*     */     //   495: iload_3
/*     */     //   496: bipush #23
/*     */     //   498: iushr
/*     */     //   499: aaload
/*     */     //   500: invokevirtual getValue : ()Lcom/prineside/luaj/LuaValue;
/*     */     //   503: iload_3
/*     */     //   504: bipush #14
/*     */     //   506: ishr
/*     */     //   507: sipush #511
/*     */     //   510: iand
/*     */     //   511: dup
/*     */     //   512: istore #6
/*     */     //   514: sipush #255
/*     */     //   517: if_icmple -> 532
/*     */     //   520: aload #11
/*     */     //   522: iload #6
/*     */     //   524: sipush #255
/*     */     //   527: iand
/*     */     //   528: aaload
/*     */     //   529: goto -> 536
/*     */     //   532: aload_1
/*     */     //   533: iload #6
/*     */     //   535: aaload
/*     */     //   536: invokevirtual get : (Lcom/prineside/luaj/LuaValue;)Lcom/prineside/luaj/LuaValue;
/*     */     //   539: aastore
/*     */     //   540: goto -> 3601
/*     */     //   543: aload_1
/*     */     //   544: iload #4
/*     */     //   546: aload_1
/*     */     //   547: iload_3
/*     */     //   548: bipush #23
/*     */     //   550: iushr
/*     */     //   551: aaload
/*     */     //   552: iload_3
/*     */     //   553: bipush #14
/*     */     //   555: ishr
/*     */     //   556: sipush #511
/*     */     //   559: iand
/*     */     //   560: dup
/*     */     //   561: istore #6
/*     */     //   563: sipush #255
/*     */     //   566: if_icmple -> 581
/*     */     //   569: aload #11
/*     */     //   571: iload #6
/*     */     //   573: sipush #255
/*     */     //   576: iand
/*     */     //   577: aaload
/*     */     //   578: goto -> 585
/*     */     //   581: aload_1
/*     */     //   582: iload #6
/*     */     //   584: aaload
/*     */     //   585: invokevirtual get : (Lcom/prineside/luaj/LuaValue;)Lcom/prineside/luaj/LuaValue;
/*     */     //   588: aastore
/*     */     //   589: goto -> 3601
/*     */     //   592: aload_0
/*     */     //   593: getfield c : [Lcom/prineside/luaj/UpValue;
/*     */     //   596: iload #4
/*     */     //   598: aaload
/*     */     //   599: invokevirtual getValue : ()Lcom/prineside/luaj/LuaValue;
/*     */     //   602: iload_3
/*     */     //   603: bipush #23
/*     */     //   605: iushr
/*     */     //   606: dup
/*     */     //   607: istore #5
/*     */     //   609: sipush #255
/*     */     //   612: if_icmple -> 627
/*     */     //   615: aload #11
/*     */     //   617: iload #5
/*     */     //   619: sipush #255
/*     */     //   622: iand
/*     */     //   623: aaload
/*     */     //   624: goto -> 631
/*     */     //   627: aload_1
/*     */     //   628: iload #5
/*     */     //   630: aaload
/*     */     //   631: iload_3
/*     */     //   632: bipush #14
/*     */     //   634: ishr
/*     */     //   635: sipush #511
/*     */     //   638: iand
/*     */     //   639: dup
/*     */     //   640: istore #6
/*     */     //   642: sipush #255
/*     */     //   645: if_icmple -> 660
/*     */     //   648: aload #11
/*     */     //   650: iload #6
/*     */     //   652: sipush #255
/*     */     //   655: iand
/*     */     //   656: aaload
/*     */     //   657: goto -> 664
/*     */     //   660: aload_1
/*     */     //   661: iload #6
/*     */     //   663: aaload
/*     */     //   664: invokevirtual set : (Lcom/prineside/luaj/LuaValue;Lcom/prineside/luaj/LuaValue;)V
/*     */     //   667: goto -> 3601
/*     */     //   670: aload_0
/*     */     //   671: getfield c : [Lcom/prineside/luaj/UpValue;
/*     */     //   674: iload_3
/*     */     //   675: bipush #23
/*     */     //   677: iushr
/*     */     //   678: aaload
/*     */     //   679: aload_1
/*     */     //   680: iload #4
/*     */     //   682: aaload
/*     */     //   683: invokevirtual setValue : (Lcom/prineside/luaj/LuaValue;)V
/*     */     //   686: goto -> 3601
/*     */     //   689: aload_1
/*     */     //   690: iload #4
/*     */     //   692: aaload
/*     */     //   693: iload_3
/*     */     //   694: bipush #23
/*     */     //   696: iushr
/*     */     //   697: dup
/*     */     //   698: istore #5
/*     */     //   700: sipush #255
/*     */     //   703: if_icmple -> 718
/*     */     //   706: aload #11
/*     */     //   708: iload #5
/*     */     //   710: sipush #255
/*     */     //   713: iand
/*     */     //   714: aaload
/*     */     //   715: goto -> 722
/*     */     //   718: aload_1
/*     */     //   719: iload #5
/*     */     //   721: aaload
/*     */     //   722: iload_3
/*     */     //   723: bipush #14
/*     */     //   725: ishr
/*     */     //   726: sipush #511
/*     */     //   729: iand
/*     */     //   730: dup
/*     */     //   731: istore #6
/*     */     //   733: sipush #255
/*     */     //   736: if_icmple -> 751
/*     */     //   739: aload #11
/*     */     //   741: iload #6
/*     */     //   743: sipush #255
/*     */     //   746: iand
/*     */     //   747: aaload
/*     */     //   748: goto -> 755
/*     */     //   751: aload_1
/*     */     //   752: iload #6
/*     */     //   754: aaload
/*     */     //   755: invokevirtual set : (Lcom/prineside/luaj/LuaValue;Lcom/prineside/luaj/LuaValue;)V
/*     */     //   758: goto -> 3601
/*     */     //   761: aload_1
/*     */     //   762: iload #4
/*     */     //   764: new com/prineside/luaj/LuaTable
/*     */     //   767: dup
/*     */     //   768: iload_3
/*     */     //   769: bipush #23
/*     */     //   771: iushr
/*     */     //   772: iload_3
/*     */     //   773: bipush #14
/*     */     //   775: ishr
/*     */     //   776: sipush #511
/*     */     //   779: iand
/*     */     //   780: invokespecial <init> : (II)V
/*     */     //   783: aastore
/*     */     //   784: goto -> 3601
/*     */     //   787: aload_1
/*     */     //   788: iload #4
/*     */     //   790: iconst_1
/*     */     //   791: iadd
/*     */     //   792: aload_1
/*     */     //   793: iload_3
/*     */     //   794: bipush #23
/*     */     //   796: iushr
/*     */     //   797: aaload
/*     */     //   798: dup
/*     */     //   799: astore #6
/*     */     //   801: aastore
/*     */     //   802: aload_1
/*     */     //   803: iload #4
/*     */     //   805: aload #6
/*     */     //   807: iload_3
/*     */     //   808: bipush #14
/*     */     //   810: ishr
/*     */     //   811: sipush #511
/*     */     //   814: iand
/*     */     //   815: dup
/*     */     //   816: istore #6
/*     */     //   818: sipush #255
/*     */     //   821: if_icmple -> 836
/*     */     //   824: aload #11
/*     */     //   826: iload #6
/*     */     //   828: sipush #255
/*     */     //   831: iand
/*     */     //   832: aaload
/*     */     //   833: goto -> 840
/*     */     //   836: aload_1
/*     */     //   837: iload #6
/*     */     //   839: aaload
/*     */     //   840: invokevirtual get : (Lcom/prineside/luaj/LuaValue;)Lcom/prineside/luaj/LuaValue;
/*     */     //   843: aastore
/*     */     //   844: goto -> 3601
/*     */     //   847: aload_1
/*     */     //   848: iload #4
/*     */     //   850: iload_3
/*     */     //   851: bipush #23
/*     */     //   853: iushr
/*     */     //   854: dup
/*     */     //   855: istore #5
/*     */     //   857: sipush #255
/*     */     //   860: if_icmple -> 875
/*     */     //   863: aload #11
/*     */     //   865: iload #5
/*     */     //   867: sipush #255
/*     */     //   870: iand
/*     */     //   871: aaload
/*     */     //   872: goto -> 879
/*     */     //   875: aload_1
/*     */     //   876: iload #5
/*     */     //   878: aaload
/*     */     //   879: iload_3
/*     */     //   880: bipush #14
/*     */     //   882: ishr
/*     */     //   883: sipush #511
/*     */     //   886: iand
/*     */     //   887: dup
/*     */     //   888: istore #6
/*     */     //   890: sipush #255
/*     */     //   893: if_icmple -> 908
/*     */     //   896: aload #11
/*     */     //   898: iload #6
/*     */     //   900: sipush #255
/*     */     //   903: iand
/*     */     //   904: aaload
/*     */     //   905: goto -> 912
/*     */     //   908: aload_1
/*     */     //   909: iload #6
/*     */     //   911: aaload
/*     */     //   912: invokevirtual add : (Lcom/prineside/luaj/LuaValue;)Lcom/prineside/luaj/LuaValue;
/*     */     //   915: aastore
/*     */     //   916: goto -> 3601
/*     */     //   919: aload_1
/*     */     //   920: iload #4
/*     */     //   922: iload_3
/*     */     //   923: bipush #23
/*     */     //   925: iushr
/*     */     //   926: dup
/*     */     //   927: istore #5
/*     */     //   929: sipush #255
/*     */     //   932: if_icmple -> 947
/*     */     //   935: aload #11
/*     */     //   937: iload #5
/*     */     //   939: sipush #255
/*     */     //   942: iand
/*     */     //   943: aaload
/*     */     //   944: goto -> 951
/*     */     //   947: aload_1
/*     */     //   948: iload #5
/*     */     //   950: aaload
/*     */     //   951: iload_3
/*     */     //   952: bipush #14
/*     */     //   954: ishr
/*     */     //   955: sipush #511
/*     */     //   958: iand
/*     */     //   959: dup
/*     */     //   960: istore #6
/*     */     //   962: sipush #255
/*     */     //   965: if_icmple -> 980
/*     */     //   968: aload #11
/*     */     //   970: iload #6
/*     */     //   972: sipush #255
/*     */     //   975: iand
/*     */     //   976: aaload
/*     */     //   977: goto -> 984
/*     */     //   980: aload_1
/*     */     //   981: iload #6
/*     */     //   983: aaload
/*     */     //   984: invokevirtual sub : (Lcom/prineside/luaj/LuaValue;)Lcom/prineside/luaj/LuaValue;
/*     */     //   987: aastore
/*     */     //   988: goto -> 3601
/*     */     //   991: aload_1
/*     */     //   992: iload #4
/*     */     //   994: iload_3
/*     */     //   995: bipush #23
/*     */     //   997: iushr
/*     */     //   998: dup
/*     */     //   999: istore #5
/*     */     //   1001: sipush #255
/*     */     //   1004: if_icmple -> 1019
/*     */     //   1007: aload #11
/*     */     //   1009: iload #5
/*     */     //   1011: sipush #255
/*     */     //   1014: iand
/*     */     //   1015: aaload
/*     */     //   1016: goto -> 1023
/*     */     //   1019: aload_1
/*     */     //   1020: iload #5
/*     */     //   1022: aaload
/*     */     //   1023: iload_3
/*     */     //   1024: bipush #14
/*     */     //   1026: ishr
/*     */     //   1027: sipush #511
/*     */     //   1030: iand
/*     */     //   1031: dup
/*     */     //   1032: istore #6
/*     */     //   1034: sipush #255
/*     */     //   1037: if_icmple -> 1052
/*     */     //   1040: aload #11
/*     */     //   1042: iload #6
/*     */     //   1044: sipush #255
/*     */     //   1047: iand
/*     */     //   1048: aaload
/*     */     //   1049: goto -> 1056
/*     */     //   1052: aload_1
/*     */     //   1053: iload #6
/*     */     //   1055: aaload
/*     */     //   1056: invokevirtual mul : (Lcom/prineside/luaj/LuaValue;)Lcom/prineside/luaj/LuaValue;
/*     */     //   1059: aastore
/*     */     //   1060: goto -> 3601
/*     */     //   1063: aload_1
/*     */     //   1064: iload #4
/*     */     //   1066: iload_3
/*     */     //   1067: bipush #23
/*     */     //   1069: iushr
/*     */     //   1070: dup
/*     */     //   1071: istore #5
/*     */     //   1073: sipush #255
/*     */     //   1076: if_icmple -> 1091
/*     */     //   1079: aload #11
/*     */     //   1081: iload #5
/*     */     //   1083: sipush #255
/*     */     //   1086: iand
/*     */     //   1087: aaload
/*     */     //   1088: goto -> 1095
/*     */     //   1091: aload_1
/*     */     //   1092: iload #5
/*     */     //   1094: aaload
/*     */     //   1095: iload_3
/*     */     //   1096: bipush #14
/*     */     //   1098: ishr
/*     */     //   1099: sipush #511
/*     */     //   1102: iand
/*     */     //   1103: dup
/*     */     //   1104: istore #6
/*     */     //   1106: sipush #255
/*     */     //   1109: if_icmple -> 1124
/*     */     //   1112: aload #11
/*     */     //   1114: iload #6
/*     */     //   1116: sipush #255
/*     */     //   1119: iand
/*     */     //   1120: aaload
/*     */     //   1121: goto -> 1128
/*     */     //   1124: aload_1
/*     */     //   1125: iload #6
/*     */     //   1127: aaload
/*     */     //   1128: invokevirtual div : (Lcom/prineside/luaj/LuaValue;)Lcom/prineside/luaj/LuaValue;
/*     */     //   1131: aastore
/*     */     //   1132: goto -> 3601
/*     */     //   1135: aload_1
/*     */     //   1136: iload #4
/*     */     //   1138: iload_3
/*     */     //   1139: bipush #23
/*     */     //   1141: iushr
/*     */     //   1142: dup
/*     */     //   1143: istore #5
/*     */     //   1145: sipush #255
/*     */     //   1148: if_icmple -> 1163
/*     */     //   1151: aload #11
/*     */     //   1153: iload #5
/*     */     //   1155: sipush #255
/*     */     //   1158: iand
/*     */     //   1159: aaload
/*     */     //   1160: goto -> 1167
/*     */     //   1163: aload_1
/*     */     //   1164: iload #5
/*     */     //   1166: aaload
/*     */     //   1167: iload_3
/*     */     //   1168: bipush #14
/*     */     //   1170: ishr
/*     */     //   1171: sipush #511
/*     */     //   1174: iand
/*     */     //   1175: dup
/*     */     //   1176: istore #6
/*     */     //   1178: sipush #255
/*     */     //   1181: if_icmple -> 1196
/*     */     //   1184: aload #11
/*     */     //   1186: iload #6
/*     */     //   1188: sipush #255
/*     */     //   1191: iand
/*     */     //   1192: aaload
/*     */     //   1193: goto -> 1200
/*     */     //   1196: aload_1
/*     */     //   1197: iload #6
/*     */     //   1199: aaload
/*     */     //   1200: invokevirtual mod : (Lcom/prineside/luaj/LuaValue;)Lcom/prineside/luaj/LuaValue;
/*     */     //   1203: aastore
/*     */     //   1204: goto -> 3601
/*     */     //   1207: aload_1
/*     */     //   1208: iload #4
/*     */     //   1210: iload_3
/*     */     //   1211: bipush #23
/*     */     //   1213: iushr
/*     */     //   1214: dup
/*     */     //   1215: istore #5
/*     */     //   1217: sipush #255
/*     */     //   1220: if_icmple -> 1235
/*     */     //   1223: aload #11
/*     */     //   1225: iload #5
/*     */     //   1227: sipush #255
/*     */     //   1230: iand
/*     */     //   1231: aaload
/*     */     //   1232: goto -> 1239
/*     */     //   1235: aload_1
/*     */     //   1236: iload #5
/*     */     //   1238: aaload
/*     */     //   1239: iload_3
/*     */     //   1240: bipush #14
/*     */     //   1242: ishr
/*     */     //   1243: sipush #511
/*     */     //   1246: iand
/*     */     //   1247: dup
/*     */     //   1248: istore #6
/*     */     //   1250: sipush #255
/*     */     //   1253: if_icmple -> 1268
/*     */     //   1256: aload #11
/*     */     //   1258: iload #6
/*     */     //   1260: sipush #255
/*     */     //   1263: iand
/*     */     //   1264: aaload
/*     */     //   1265: goto -> 1272
/*     */     //   1268: aload_1
/*     */     //   1269: iload #6
/*     */     //   1271: aaload
/*     */     //   1272: invokevirtual pow : (Lcom/prineside/luaj/LuaValue;)Lcom/prineside/luaj/LuaValue;
/*     */     //   1275: aastore
/*     */     //   1276: goto -> 3601
/*     */     //   1279: aload_1
/*     */     //   1280: iload #4
/*     */     //   1282: aload_1
/*     */     //   1283: iload_3
/*     */     //   1284: bipush #23
/*     */     //   1286: iushr
/*     */     //   1287: aaload
/*     */     //   1288: invokevirtual neg : ()Lcom/prineside/luaj/LuaValue;
/*     */     //   1291: aastore
/*     */     //   1292: goto -> 3601
/*     */     //   1295: aload_1
/*     */     //   1296: iload #4
/*     */     //   1298: aload_1
/*     */     //   1299: iload_3
/*     */     //   1300: bipush #23
/*     */     //   1302: iushr
/*     */     //   1303: aaload
/*     */     //   1304: invokevirtual not : ()Lcom/prineside/luaj/LuaValue;
/*     */     //   1307: aastore
/*     */     //   1308: goto -> 3601
/*     */     //   1311: aload_1
/*     */     //   1312: iload #4
/*     */     //   1314: aload_1
/*     */     //   1315: iload_3
/*     */     //   1316: bipush #23
/*     */     //   1318: iushr
/*     */     //   1319: aaload
/*     */     //   1320: invokevirtual len : ()Lcom/prineside/luaj/LuaValue;
/*     */     //   1323: aastore
/*     */     //   1324: goto -> 3601
/*     */     //   1327: iload_3
/*     */     //   1328: bipush #23
/*     */     //   1330: iushr
/*     */     //   1331: istore #5
/*     */     //   1333: iload_3
/*     */     //   1334: bipush #14
/*     */     //   1336: ishr
/*     */     //   1337: sipush #511
/*     */     //   1340: iand
/*     */     //   1341: dup
/*     */     //   1342: istore #6
/*     */     //   1344: iload #5
/*     */     //   1346: iconst_1
/*     */     //   1347: iadd
/*     */     //   1348: if_icmple -> 1395
/*     */     //   1351: aload_1
/*     */     //   1352: iload #6
/*     */     //   1354: aaload
/*     */     //   1355: invokevirtual buffer : ()Lcom/prineside/luaj/Buffer;
/*     */     //   1358: astore #14
/*     */     //   1360: iinc #6, -1
/*     */     //   1363: iload #6
/*     */     //   1365: iload #5
/*     */     //   1367: if_icmplt -> 1383
/*     */     //   1370: aload #14
/*     */     //   1372: aload_1
/*     */     //   1373: iload #6
/*     */     //   1375: aaload
/*     */     //   1376: invokevirtual concatTo : (Lcom/prineside/luaj/LuaValue;)Lcom/prineside/luaj/Buffer;
/*     */     //   1379: pop
/*     */     //   1380: goto -> 1360
/*     */     //   1383: aload_1
/*     */     //   1384: iload #4
/*     */     //   1386: aload #14
/*     */     //   1388: invokevirtual value : ()Lcom/prineside/luaj/LuaValue;
/*     */     //   1391: aastore
/*     */     //   1392: goto -> 3601
/*     */     //   1395: aload_1
/*     */     //   1396: iload #4
/*     */     //   1398: aload_1
/*     */     //   1399: iload #6
/*     */     //   1401: iconst_1
/*     */     //   1402: isub
/*     */     //   1403: aaload
/*     */     //   1404: aload_1
/*     */     //   1405: iload #6
/*     */     //   1407: aaload
/*     */     //   1408: invokevirtual concat : (Lcom/prineside/luaj/LuaValue;)Lcom/prineside/luaj/LuaValue;
/*     */     //   1411: aastore
/*     */     //   1412: goto -> 3601
/*     */     //   1415: iload #7
/*     */     //   1417: iload_3
/*     */     //   1418: bipush #14
/*     */     //   1420: iushr
/*     */     //   1421: ldc 131071
/*     */     //   1423: isub
/*     */     //   1424: iadd
/*     */     //   1425: istore #7
/*     */     //   1427: iload #4
/*     */     //   1429: ifle -> 3601
/*     */     //   1432: iinc #4, -1
/*     */     //   1435: aload #12
/*     */     //   1437: arraylength
/*     */     //   1438: istore #5
/*     */     //   1440: iinc #5, -1
/*     */     //   1443: iload #5
/*     */     //   1445: iflt -> 3601
/*     */     //   1448: aload #12
/*     */     //   1450: iload #5
/*     */     //   1452: aaload
/*     */     //   1453: ifnull -> 1440
/*     */     //   1456: aload #12
/*     */     //   1458: iload #5
/*     */     //   1460: aaload
/*     */     //   1461: getfield a : I
/*     */     //   1464: iload #4
/*     */     //   1466: if_icmplt -> 1440
/*     */     //   1469: aload #12
/*     */     //   1471: iload #5
/*     */     //   1473: aaload
/*     */     //   1474: invokevirtual close : ()V
/*     */     //   1477: aload #12
/*     */     //   1479: iload #5
/*     */     //   1481: aconst_null
/*     */     //   1482: aastore
/*     */     //   1483: goto -> 1440
/*     */     //   1486: iload_3
/*     */     //   1487: bipush #23
/*     */     //   1489: iushr
/*     */     //   1490: dup
/*     */     //   1491: istore #5
/*     */     //   1493: sipush #255
/*     */     //   1496: if_icmple -> 1511
/*     */     //   1499: aload #11
/*     */     //   1501: iload #5
/*     */     //   1503: sipush #255
/*     */     //   1506: iand
/*     */     //   1507: aaload
/*     */     //   1508: goto -> 1515
/*     */     //   1511: aload_1
/*     */     //   1512: iload #5
/*     */     //   1514: aaload
/*     */     //   1515: iload_3
/*     */     //   1516: bipush #14
/*     */     //   1518: ishr
/*     */     //   1519: sipush #511
/*     */     //   1522: iand
/*     */     //   1523: dup
/*     */     //   1524: istore #6
/*     */     //   1526: sipush #255
/*     */     //   1529: if_icmple -> 1544
/*     */     //   1532: aload #11
/*     */     //   1534: iload #6
/*     */     //   1536: sipush #255
/*     */     //   1539: iand
/*     */     //   1540: aaload
/*     */     //   1541: goto -> 1548
/*     */     //   1544: aload_1
/*     */     //   1545: iload #6
/*     */     //   1547: aaload
/*     */     //   1548: invokevirtual eq_b : (Lcom/prineside/luaj/LuaValue;)Z
/*     */     //   1551: iload #4
/*     */     //   1553: ifne -> 1560
/*     */     //   1556: iconst_1
/*     */     //   1557: goto -> 1561
/*     */     //   1560: iconst_0
/*     */     //   1561: if_icmpne -> 3601
/*     */     //   1564: iinc #7, 1
/*     */     //   1567: goto -> 3601
/*     */     //   1570: iload_3
/*     */     //   1571: bipush #23
/*     */     //   1573: iushr
/*     */     //   1574: dup
/*     */     //   1575: istore #5
/*     */     //   1577: sipush #255
/*     */     //   1580: if_icmple -> 1595
/*     */     //   1583: aload #11
/*     */     //   1585: iload #5
/*     */     //   1587: sipush #255
/*     */     //   1590: iand
/*     */     //   1591: aaload
/*     */     //   1592: goto -> 1599
/*     */     //   1595: aload_1
/*     */     //   1596: iload #5
/*     */     //   1598: aaload
/*     */     //   1599: iload_3
/*     */     //   1600: bipush #14
/*     */     //   1602: ishr
/*     */     //   1603: sipush #511
/*     */     //   1606: iand
/*     */     //   1607: dup
/*     */     //   1608: istore #6
/*     */     //   1610: sipush #255
/*     */     //   1613: if_icmple -> 1628
/*     */     //   1616: aload #11
/*     */     //   1618: iload #6
/*     */     //   1620: sipush #255
/*     */     //   1623: iand
/*     */     //   1624: aaload
/*     */     //   1625: goto -> 1632
/*     */     //   1628: aload_1
/*     */     //   1629: iload #6
/*     */     //   1631: aaload
/*     */     //   1632: invokevirtual lt_b : (Lcom/prineside/luaj/LuaValue;)Z
/*     */     //   1635: iload #4
/*     */     //   1637: ifne -> 1644
/*     */     //   1640: iconst_1
/*     */     //   1641: goto -> 1645
/*     */     //   1644: iconst_0
/*     */     //   1645: if_icmpne -> 3601
/*     */     //   1648: iinc #7, 1
/*     */     //   1651: goto -> 3601
/*     */     //   1654: iload_3
/*     */     //   1655: bipush #23
/*     */     //   1657: iushr
/*     */     //   1658: dup
/*     */     //   1659: istore #5
/*     */     //   1661: sipush #255
/*     */     //   1664: if_icmple -> 1679
/*     */     //   1667: aload #11
/*     */     //   1669: iload #5
/*     */     //   1671: sipush #255
/*     */     //   1674: iand
/*     */     //   1675: aaload
/*     */     //   1676: goto -> 1683
/*     */     //   1679: aload_1
/*     */     //   1680: iload #5
/*     */     //   1682: aaload
/*     */     //   1683: iload_3
/*     */     //   1684: bipush #14
/*     */     //   1686: ishr
/*     */     //   1687: sipush #511
/*     */     //   1690: iand
/*     */     //   1691: dup
/*     */     //   1692: istore #6
/*     */     //   1694: sipush #255
/*     */     //   1697: if_icmple -> 1712
/*     */     //   1700: aload #11
/*     */     //   1702: iload #6
/*     */     //   1704: sipush #255
/*     */     //   1707: iand
/*     */     //   1708: aaload
/*     */     //   1709: goto -> 1716
/*     */     //   1712: aload_1
/*     */     //   1713: iload #6
/*     */     //   1715: aaload
/*     */     //   1716: invokevirtual lteq_b : (Lcom/prineside/luaj/LuaValue;)Z
/*     */     //   1719: iload #4
/*     */     //   1721: ifne -> 1728
/*     */     //   1724: iconst_1
/*     */     //   1725: goto -> 1729
/*     */     //   1728: iconst_0
/*     */     //   1729: if_icmpne -> 3601
/*     */     //   1732: iinc #7, 1
/*     */     //   1735: goto -> 3601
/*     */     //   1738: aload_1
/*     */     //   1739: iload #4
/*     */     //   1741: aaload
/*     */     //   1742: invokevirtual toboolean : ()Z
/*     */     //   1745: iload_3
/*     */     //   1746: ldc 8372224
/*     */     //   1748: iand
/*     */     //   1749: ifne -> 1756
/*     */     //   1752: iconst_1
/*     */     //   1753: goto -> 1757
/*     */     //   1756: iconst_0
/*     */     //   1757: if_icmpne -> 3601
/*     */     //   1760: iinc #7, 1
/*     */     //   1763: goto -> 3601
/*     */     //   1766: aload_1
/*     */     //   1767: iload_3
/*     */     //   1768: bipush #23
/*     */     //   1770: iushr
/*     */     //   1771: aaload
/*     */     //   1772: dup
/*     */     //   1773: astore #6
/*     */     //   1775: invokevirtual toboolean : ()Z
/*     */     //   1778: iload_3
/*     */     //   1779: ldc 8372224
/*     */     //   1781: iand
/*     */     //   1782: ifne -> 1789
/*     */     //   1785: iconst_1
/*     */     //   1786: goto -> 1790
/*     */     //   1789: iconst_0
/*     */     //   1790: if_icmpne -> 1799
/*     */     //   1793: iinc #7, 1
/*     */     //   1796: goto -> 3601
/*     */     //   1799: aload_1
/*     */     //   1800: iload #4
/*     */     //   1802: aload #6
/*     */     //   1804: aastore
/*     */     //   1805: goto -> 3601
/*     */     //   1808: iload_3
/*     */     //   1809: sipush #-16384
/*     */     //   1812: iand
/*     */     //   1813: lookupswitch default -> 2129, 8388608 -> 1904, 8404992 -> 1957, 8421376 -> 2037, 16777216 -> 1929, 16793600 -> 1968, 16809984 -> 2051, 25182208 -> 1985, 25198592 -> 2071, 33570816 -> 2008, 33587200 -> 2097
/*     */     //   1904: aload_1
/*     */     //   1905: iload #4
/*     */     //   1907: aaload
/*     */     //   1908: getstatic com/prineside/luaj/LuaClosure.NONE : Lcom/prineside/luaj/LuaValue;
/*     */     //   1911: invokevirtual invoke : (Lcom/prineside/luaj/Varargs;)Lcom/prineside/luaj/Varargs;
/*     */     //   1914: astore #9
/*     */     //   1916: iload #4
/*     */     //   1918: aload #9
/*     */     //   1920: invokevirtual narg : ()I
/*     */     //   1923: iadd
/*     */     //   1924: istore #8
/*     */     //   1926: goto -> 3601
/*     */     //   1929: aload_1
/*     */     //   1930: iload #4
/*     */     //   1932: aaload
/*     */     //   1933: aload_1
/*     */     //   1934: iload #4
/*     */     //   1936: iconst_1
/*     */     //   1937: iadd
/*     */     //   1938: aaload
/*     */     //   1939: invokevirtual invoke : (Lcom/prineside/luaj/Varargs;)Lcom/prineside/luaj/Varargs;
/*     */     //   1942: astore #9
/*     */     //   1944: iload #4
/*     */     //   1946: aload #9
/*     */     //   1948: invokevirtual narg : ()I
/*     */     //   1951: iadd
/*     */     //   1952: istore #8
/*     */     //   1954: goto -> 3601
/*     */     //   1957: aload_1
/*     */     //   1958: iload #4
/*     */     //   1960: aaload
/*     */     //   1961: invokevirtual call : ()Lcom/prineside/luaj/LuaValue;
/*     */     //   1964: pop
/*     */     //   1965: goto -> 3601
/*     */     //   1968: aload_1
/*     */     //   1969: iload #4
/*     */     //   1971: aaload
/*     */     //   1972: aload_1
/*     */     //   1973: iload #4
/*     */     //   1975: iconst_1
/*     */     //   1976: iadd
/*     */     //   1977: aaload
/*     */     //   1978: invokevirtual call : (Lcom/prineside/luaj/LuaValue;)Lcom/prineside/luaj/LuaValue;
/*     */     //   1981: pop
/*     */     //   1982: goto -> 3601
/*     */     //   1985: aload_1
/*     */     //   1986: iload #4
/*     */     //   1988: aaload
/*     */     //   1989: aload_1
/*     */     //   1990: iload #4
/*     */     //   1992: iconst_1
/*     */     //   1993: iadd
/*     */     //   1994: aaload
/*     */     //   1995: aload_1
/*     */     //   1996: iload #4
/*     */     //   1998: iconst_2
/*     */     //   1999: iadd
/*     */     //   2000: aaload
/*     */     //   2001: invokevirtual call : (Lcom/prineside/luaj/LuaValue;Lcom/prineside/luaj/LuaValue;)Lcom/prineside/luaj/LuaValue;
/*     */     //   2004: pop
/*     */     //   2005: goto -> 3601
/*     */     //   2008: aload_1
/*     */     //   2009: iload #4
/*     */     //   2011: aaload
/*     */     //   2012: aload_1
/*     */     //   2013: iload #4
/*     */     //   2015: iconst_1
/*     */     //   2016: iadd
/*     */     //   2017: aaload
/*     */     //   2018: aload_1
/*     */     //   2019: iload #4
/*     */     //   2021: iconst_2
/*     */     //   2022: iadd
/*     */     //   2023: aaload
/*     */     //   2024: aload_1
/*     */     //   2025: iload #4
/*     */     //   2027: iconst_3
/*     */     //   2028: iadd
/*     */     //   2029: aaload
/*     */     //   2030: invokevirtual call : (Lcom/prineside/luaj/LuaValue;Lcom/prineside/luaj/LuaValue;Lcom/prineside/luaj/LuaValue;)Lcom/prineside/luaj/LuaValue;
/*     */     //   2033: pop
/*     */     //   2034: goto -> 3601
/*     */     //   2037: aload_1
/*     */     //   2038: iload #4
/*     */     //   2040: aload_1
/*     */     //   2041: iload #4
/*     */     //   2043: aaload
/*     */     //   2044: invokevirtual call : ()Lcom/prineside/luaj/LuaValue;
/*     */     //   2047: aastore
/*     */     //   2048: goto -> 3601
/*     */     //   2051: aload_1
/*     */     //   2052: iload #4
/*     */     //   2054: aload_1
/*     */     //   2055: iload #4
/*     */     //   2057: aaload
/*     */     //   2058: aload_1
/*     */     //   2059: iload #4
/*     */     //   2061: iconst_1
/*     */     //   2062: iadd
/*     */     //   2063: aaload
/*     */     //   2064: invokevirtual call : (Lcom/prineside/luaj/LuaValue;)Lcom/prineside/luaj/LuaValue;
/*     */     //   2067: aastore
/*     */     //   2068: goto -> 3601
/*     */     //   2071: aload_1
/*     */     //   2072: iload #4
/*     */     //   2074: aload_1
/*     */     //   2075: iload #4
/*     */     //   2077: aaload
/*     */     //   2078: aload_1
/*     */     //   2079: iload #4
/*     */     //   2081: iconst_1
/*     */     //   2082: iadd
/*     */     //   2083: aaload
/*     */     //   2084: aload_1
/*     */     //   2085: iload #4
/*     */     //   2087: iconst_2
/*     */     //   2088: iadd
/*     */     //   2089: aaload
/*     */     //   2090: invokevirtual call : (Lcom/prineside/luaj/LuaValue;Lcom/prineside/luaj/LuaValue;)Lcom/prineside/luaj/LuaValue;
/*     */     //   2093: aastore
/*     */     //   2094: goto -> 3601
/*     */     //   2097: aload_1
/*     */     //   2098: iload #4
/*     */     //   2100: aload_1
/*     */     //   2101: iload #4
/*     */     //   2103: aaload
/*     */     //   2104: aload_1
/*     */     //   2105: iload #4
/*     */     //   2107: iconst_1
/*     */     //   2108: iadd
/*     */     //   2109: aaload
/*     */     //   2110: aload_1
/*     */     //   2111: iload #4
/*     */     //   2113: iconst_2
/*     */     //   2114: iadd
/*     */     //   2115: aaload
/*     */     //   2116: aload_1
/*     */     //   2117: iload #4
/*     */     //   2119: iconst_3
/*     */     //   2120: iadd
/*     */     //   2121: aaload
/*     */     //   2122: invokevirtual call : (Lcom/prineside/luaj/LuaValue;Lcom/prineside/luaj/LuaValue;Lcom/prineside/luaj/LuaValue;)Lcom/prineside/luaj/LuaValue;
/*     */     //   2125: aastore
/*     */     //   2126: goto -> 3601
/*     */     //   2129: iload_3
/*     */     //   2130: bipush #23
/*     */     //   2132: iushr
/*     */     //   2133: istore #5
/*     */     //   2135: iload_3
/*     */     //   2136: bipush #14
/*     */     //   2138: ishr
/*     */     //   2139: sipush #511
/*     */     //   2142: iand
/*     */     //   2143: istore #6
/*     */     //   2145: aload_1
/*     */     //   2146: iload #4
/*     */     //   2148: aaload
/*     */     //   2149: iload #5
/*     */     //   2151: ifle -> 2169
/*     */     //   2154: aload_1
/*     */     //   2155: iload #4
/*     */     //   2157: iconst_1
/*     */     //   2158: iadd
/*     */     //   2159: iload #5
/*     */     //   2161: iconst_1
/*     */     //   2162: isub
/*     */     //   2163: invokestatic varargsOf : ([Lcom/prineside/luaj/LuaValue;II)Lcom/prineside/luaj/Varargs;
/*     */     //   2166: goto -> 2192
/*     */     //   2169: aload_1
/*     */     //   2170: iload #4
/*     */     //   2172: iconst_1
/*     */     //   2173: iadd
/*     */     //   2174: iload #8
/*     */     //   2176: aload #9
/*     */     //   2178: invokevirtual narg : ()I
/*     */     //   2181: isub
/*     */     //   2182: iload #4
/*     */     //   2184: iconst_1
/*     */     //   2185: iadd
/*     */     //   2186: isub
/*     */     //   2187: aload #9
/*     */     //   2189: invokestatic varargsOf : ([Lcom/prineside/luaj/LuaValue;IILcom/prineside/luaj/Varargs;)Lcom/prineside/luaj/Varargs;
/*     */     //   2192: invokevirtual invoke : (Lcom/prineside/luaj/Varargs;)Lcom/prineside/luaj/Varargs;
/*     */     //   2195: astore #9
/*     */     //   2197: iload #6
/*     */     //   2199: ifle -> 2222
/*     */     //   2202: aload #9
/*     */     //   2204: aload_1
/*     */     //   2205: iload #4
/*     */     //   2207: iload #6
/*     */     //   2209: iconst_1
/*     */     //   2210: isub
/*     */     //   2211: invokevirtual a : ([Lcom/prineside/luaj/LuaValue;II)V
/*     */     //   2214: getstatic com/prineside/luaj/LuaClosure.NONE : Lcom/prineside/luaj/LuaValue;
/*     */     //   2217: astore #9
/*     */     //   2219: goto -> 3601
/*     */     //   2222: iload #4
/*     */     //   2224: aload #9
/*     */     //   2226: invokevirtual narg : ()I
/*     */     //   2229: iadd
/*     */     //   2230: istore #8
/*     */     //   2232: aload #9
/*     */     //   2234: invokevirtual dealias : ()Lcom/prineside/luaj/Varargs;
/*     */     //   2237: astore #9
/*     */     //   2239: goto -> 3601
/*     */     //   2242: iload_3
/*     */     //   2243: ldc -8388608
/*     */     //   2245: iand
/*     */     //   2246: lookupswitch default -> 2565, 8388608 -> 2288, 16777216 -> 2349, 25165824 -> 2413, 33554432 -> 2486
/*     */     //   2288: new com/prineside/luaj/TailcallVarargs
/*     */     //   2291: dup
/*     */     //   2292: aload_1
/*     */     //   2293: iload #4
/*     */     //   2295: aaload
/*     */     //   2296: getstatic com/prineside/luaj/LuaClosure.NONE : Lcom/prineside/luaj/LuaValue;
/*     */     //   2299: invokespecial <init> : (Lcom/prineside/luaj/LuaValue;Lcom/prineside/luaj/Varargs;)V
/*     */     //   2302: astore #14
/*     */     //   2304: aload #12
/*     */     //   2306: ifnull -> 2341
/*     */     //   2309: aload #12
/*     */     //   2311: arraylength
/*     */     //   2312: istore #15
/*     */     //   2314: iinc #15, -1
/*     */     //   2317: iload #15
/*     */     //   2319: iflt -> 2341
/*     */     //   2322: aload #12
/*     */     //   2324: iload #15
/*     */     //   2326: aaload
/*     */     //   2327: ifnull -> 2314
/*     */     //   2330: aload #12
/*     */     //   2332: iload #15
/*     */     //   2334: aaload
/*     */     //   2335: invokevirtual close : ()V
/*     */     //   2338: goto -> 2314
/*     */     //   2341: aload #13
/*     */     //   2343: invokevirtual onReturn : ()V
/*     */     //   2346: aload #14
/*     */     //   2348: areturn
/*     */     //   2349: new com/prineside/luaj/TailcallVarargs
/*     */     //   2352: dup
/*     */     //   2353: aload_1
/*     */     //   2354: iload #4
/*     */     //   2356: aaload
/*     */     //   2357: aload_1
/*     */     //   2358: iload #4
/*     */     //   2360: iconst_1
/*     */     //   2361: iadd
/*     */     //   2362: aaload
/*     */     //   2363: invokespecial <init> : (Lcom/prineside/luaj/LuaValue;Lcom/prineside/luaj/Varargs;)V
/*     */     //   2366: astore #14
/*     */     //   2368: aload #12
/*     */     //   2370: ifnull -> 2405
/*     */     //   2373: aload #12
/*     */     //   2375: arraylength
/*     */     //   2376: istore #15
/*     */     //   2378: iinc #15, -1
/*     */     //   2381: iload #15
/*     */     //   2383: iflt -> 2405
/*     */     //   2386: aload #12
/*     */     //   2388: iload #15
/*     */     //   2390: aaload
/*     */     //   2391: ifnull -> 2378
/*     */     //   2394: aload #12
/*     */     //   2396: iload #15
/*     */     //   2398: aaload
/*     */     //   2399: invokevirtual close : ()V
/*     */     //   2402: goto -> 2378
/*     */     //   2405: aload #13
/*     */     //   2407: invokevirtual onReturn : ()V
/*     */     //   2410: aload #14
/*     */     //   2412: areturn
/*     */     //   2413: new com/prineside/luaj/TailcallVarargs
/*     */     //   2416: dup
/*     */     //   2417: aload_1
/*     */     //   2418: iload #4
/*     */     //   2420: aaload
/*     */     //   2421: aload_1
/*     */     //   2422: iload #4
/*     */     //   2424: iconst_1
/*     */     //   2425: iadd
/*     */     //   2426: aaload
/*     */     //   2427: aload_1
/*     */     //   2428: iload #4
/*     */     //   2430: iconst_2
/*     */     //   2431: iadd
/*     */     //   2432: aaload
/*     */     //   2433: invokestatic varargsOf : (Lcom/prineside/luaj/LuaValue;Lcom/prineside/luaj/Varargs;)Lcom/prineside/luaj/Varargs;
/*     */     //   2436: invokespecial <init> : (Lcom/prineside/luaj/LuaValue;Lcom/prineside/luaj/Varargs;)V
/*     */     //   2439: astore #14
/*     */     //   2441: aload #12
/*     */     //   2443: ifnull -> 2478
/*     */     //   2446: aload #12
/*     */     //   2448: arraylength
/*     */     //   2449: istore #15
/*     */     //   2451: iinc #15, -1
/*     */     //   2454: iload #15
/*     */     //   2456: iflt -> 2478
/*     */     //   2459: aload #12
/*     */     //   2461: iload #15
/*     */     //   2463: aaload
/*     */     //   2464: ifnull -> 2451
/*     */     //   2467: aload #12
/*     */     //   2469: iload #15
/*     */     //   2471: aaload
/*     */     //   2472: invokevirtual close : ()V
/*     */     //   2475: goto -> 2451
/*     */     //   2478: aload #13
/*     */     //   2480: invokevirtual onReturn : ()V
/*     */     //   2483: aload #14
/*     */     //   2485: areturn
/*     */     //   2486: new com/prineside/luaj/TailcallVarargs
/*     */     //   2489: dup
/*     */     //   2490: aload_1
/*     */     //   2491: iload #4
/*     */     //   2493: aaload
/*     */     //   2494: aload_1
/*     */     //   2495: iload #4
/*     */     //   2497: iconst_1
/*     */     //   2498: iadd
/*     */     //   2499: aaload
/*     */     //   2500: aload_1
/*     */     //   2501: iload #4
/*     */     //   2503: iconst_2
/*     */     //   2504: iadd
/*     */     //   2505: aaload
/*     */     //   2506: aload_1
/*     */     //   2507: iload #4
/*     */     //   2509: iconst_3
/*     */     //   2510: iadd
/*     */     //   2511: aaload
/*     */     //   2512: invokestatic varargsOf : (Lcom/prineside/luaj/LuaValue;Lcom/prineside/luaj/LuaValue;Lcom/prineside/luaj/Varargs;)Lcom/prineside/luaj/Varargs;
/*     */     //   2515: invokespecial <init> : (Lcom/prineside/luaj/LuaValue;Lcom/prineside/luaj/Varargs;)V
/*     */     //   2518: astore #14
/*     */     //   2520: aload #12
/*     */     //   2522: ifnull -> 2557
/*     */     //   2525: aload #12
/*     */     //   2527: arraylength
/*     */     //   2528: istore #15
/*     */     //   2530: iinc #15, -1
/*     */     //   2533: iload #15
/*     */     //   2535: iflt -> 2557
/*     */     //   2538: aload #12
/*     */     //   2540: iload #15
/*     */     //   2542: aaload
/*     */     //   2543: ifnull -> 2530
/*     */     //   2546: aload #12
/*     */     //   2548: iload #15
/*     */     //   2550: aaload
/*     */     //   2551: invokevirtual close : ()V
/*     */     //   2554: goto -> 2530
/*     */     //   2557: aload #13
/*     */     //   2559: invokevirtual onReturn : ()V
/*     */     //   2562: aload #14
/*     */     //   2564: areturn
/*     */     //   2565: iload_3
/*     */     //   2566: bipush #23
/*     */     //   2568: iushr
/*     */     //   2569: dup
/*     */     //   2570: istore #5
/*     */     //   2572: ifle -> 2590
/*     */     //   2575: aload_1
/*     */     //   2576: iload #4
/*     */     //   2578: iconst_1
/*     */     //   2579: iadd
/*     */     //   2580: iload #5
/*     */     //   2582: iconst_1
/*     */     //   2583: isub
/*     */     //   2584: invokestatic varargsOf : ([Lcom/prineside/luaj/LuaValue;II)Lcom/prineside/luaj/Varargs;
/*     */     //   2587: goto -> 2613
/*     */     //   2590: aload_1
/*     */     //   2591: iload #4
/*     */     //   2593: iconst_1
/*     */     //   2594: iadd
/*     */     //   2595: iload #8
/*     */     //   2597: aload #9
/*     */     //   2599: invokevirtual narg : ()I
/*     */     //   2602: isub
/*     */     //   2603: iload #4
/*     */     //   2605: iconst_1
/*     */     //   2606: iadd
/*     */     //   2607: isub
/*     */     //   2608: aload #9
/*     */     //   2610: invokestatic varargsOf : ([Lcom/prineside/luaj/LuaValue;IILcom/prineside/luaj/Varargs;)Lcom/prineside/luaj/Varargs;
/*     */     //   2613: astore #9
/*     */     //   2615: new com/prineside/luaj/TailcallVarargs
/*     */     //   2618: dup
/*     */     //   2619: aload_1
/*     */     //   2620: iload #4
/*     */     //   2622: aaload
/*     */     //   2623: aload #9
/*     */     //   2625: invokespecial <init> : (Lcom/prineside/luaj/LuaValue;Lcom/prineside/luaj/Varargs;)V
/*     */     //   2628: astore #14
/*     */     //   2630: aload #12
/*     */     //   2632: ifnull -> 2667
/*     */     //   2635: aload #12
/*     */     //   2637: arraylength
/*     */     //   2638: istore #15
/*     */     //   2640: iinc #15, -1
/*     */     //   2643: iload #15
/*     */     //   2645: iflt -> 2667
/*     */     //   2648: aload #12
/*     */     //   2650: iload #15
/*     */     //   2652: aaload
/*     */     //   2653: ifnull -> 2640
/*     */     //   2656: aload #12
/*     */     //   2658: iload #15
/*     */     //   2660: aaload
/*     */     //   2661: invokevirtual close : ()V
/*     */     //   2664: goto -> 2640
/*     */     //   2667: aload #13
/*     */     //   2669: invokevirtual onReturn : ()V
/*     */     //   2672: aload #14
/*     */     //   2674: areturn
/*     */     //   2675: iload_3
/*     */     //   2676: bipush #23
/*     */     //   2678: iushr
/*     */     //   2679: dup
/*     */     //   2680: istore #5
/*     */     //   2682: tableswitch default -> 2875, 0 -> 2708, 1 -> 2774, 2 -> 2824
/*     */     //   2708: aload_1
/*     */     //   2709: iload #4
/*     */     //   2711: iload #8
/*     */     //   2713: aload #9
/*     */     //   2715: invokevirtual narg : ()I
/*     */     //   2718: isub
/*     */     //   2719: iload #4
/*     */     //   2721: isub
/*     */     //   2722: aload #9
/*     */     //   2724: invokestatic varargsOf : ([Lcom/prineside/luaj/LuaValue;IILcom/prineside/luaj/Varargs;)Lcom/prineside/luaj/Varargs;
/*     */     //   2727: astore #14
/*     */     //   2729: aload #12
/*     */     //   2731: ifnull -> 2766
/*     */     //   2734: aload #12
/*     */     //   2736: arraylength
/*     */     //   2737: istore #15
/*     */     //   2739: iinc #15, -1
/*     */     //   2742: iload #15
/*     */     //   2744: iflt -> 2766
/*     */     //   2747: aload #12
/*     */     //   2749: iload #15
/*     */     //   2751: aaload
/*     */     //   2752: ifnull -> 2739
/*     */     //   2755: aload #12
/*     */     //   2757: iload #15
/*     */     //   2759: aaload
/*     */     //   2760: invokevirtual close : ()V
/*     */     //   2763: goto -> 2739
/*     */     //   2766: aload #13
/*     */     //   2768: invokevirtual onReturn : ()V
/*     */     //   2771: aload #14
/*     */     //   2773: areturn
/*     */     //   2774: getstatic com/prineside/luaj/LuaClosure.NONE : Lcom/prineside/luaj/LuaValue;
/*     */     //   2777: astore #14
/*     */     //   2779: aload #12
/*     */     //   2781: ifnull -> 2816
/*     */     //   2784: aload #12
/*     */     //   2786: arraylength
/*     */     //   2787: istore #15
/*     */     //   2789: iinc #15, -1
/*     */     //   2792: iload #15
/*     */     //   2794: iflt -> 2816
/*     */     //   2797: aload #12
/*     */     //   2799: iload #15
/*     */     //   2801: aaload
/*     */     //   2802: ifnull -> 2789
/*     */     //   2805: aload #12
/*     */     //   2807: iload #15
/*     */     //   2809: aaload
/*     */     //   2810: invokevirtual close : ()V
/*     */     //   2813: goto -> 2789
/*     */     //   2816: aload #13
/*     */     //   2818: invokevirtual onReturn : ()V
/*     */     //   2821: aload #14
/*     */     //   2823: areturn
/*     */     //   2824: aload_1
/*     */     //   2825: iload #4
/*     */     //   2827: aaload
/*     */     //   2828: astore #14
/*     */     //   2830: aload #12
/*     */     //   2832: ifnull -> 2867
/*     */     //   2835: aload #12
/*     */     //   2837: arraylength
/*     */     //   2838: istore #15
/*     */     //   2840: iinc #15, -1
/*     */     //   2843: iload #15
/*     */     //   2845: iflt -> 2867
/*     */     //   2848: aload #12
/*     */     //   2850: iload #15
/*     */     //   2852: aaload
/*     */     //   2853: ifnull -> 2840
/*     */     //   2856: aload #12
/*     */     //   2858: iload #15
/*     */     //   2860: aaload
/*     */     //   2861: invokevirtual close : ()V
/*     */     //   2864: goto -> 2840
/*     */     //   2867: aload #13
/*     */     //   2869: invokevirtual onReturn : ()V
/*     */     //   2872: aload #14
/*     */     //   2874: areturn
/*     */     //   2875: aload_1
/*     */     //   2876: iload #4
/*     */     //   2878: iload #5
/*     */     //   2880: iconst_1
/*     */     //   2881: isub
/*     */     //   2882: invokestatic varargsOf : ([Lcom/prineside/luaj/LuaValue;II)Lcom/prineside/luaj/Varargs;
/*     */     //   2885: astore #14
/*     */     //   2887: aload #12
/*     */     //   2889: ifnull -> 2924
/*     */     //   2892: aload #12
/*     */     //   2894: arraylength
/*     */     //   2895: istore #15
/*     */     //   2897: iinc #15, -1
/*     */     //   2900: iload #15
/*     */     //   2902: iflt -> 2924
/*     */     //   2905: aload #12
/*     */     //   2907: iload #15
/*     */     //   2909: aaload
/*     */     //   2910: ifnull -> 2897
/*     */     //   2913: aload #12
/*     */     //   2915: iload #15
/*     */     //   2917: aaload
/*     */     //   2918: invokevirtual close : ()V
/*     */     //   2921: goto -> 2897
/*     */     //   2924: aload #13
/*     */     //   2926: invokevirtual onReturn : ()V
/*     */     //   2929: aload #14
/*     */     //   2931: areturn
/*     */     //   2932: aload_1
/*     */     //   2933: iload #4
/*     */     //   2935: iconst_1
/*     */     //   2936: iadd
/*     */     //   2937: aaload
/*     */     //   2938: astore #14
/*     */     //   2940: aload_1
/*     */     //   2941: iload #4
/*     */     //   2943: iconst_2
/*     */     //   2944: iadd
/*     */     //   2945: aaload
/*     */     //   2946: astore #15
/*     */     //   2948: aload_1
/*     */     //   2949: iload #4
/*     */     //   2951: aaload
/*     */     //   2952: aload #15
/*     */     //   2954: invokevirtual add : (Lcom/prineside/luaj/LuaValue;)Lcom/prineside/luaj/LuaValue;
/*     */     //   2957: astore #16
/*     */     //   2959: aload #15
/*     */     //   2961: iconst_0
/*     */     //   2962: invokevirtual gt_b : (I)Z
/*     */     //   2965: ifeq -> 2981
/*     */     //   2968: aload #16
/*     */     //   2970: aload #14
/*     */     //   2972: invokevirtual lteq_b : (Lcom/prineside/luaj/LuaValue;)Z
/*     */     //   2975: ifeq -> 3017
/*     */     //   2978: goto -> 2991
/*     */     //   2981: aload #16
/*     */     //   2983: aload #14
/*     */     //   2985: invokevirtual gteq_b : (Lcom/prineside/luaj/LuaValue;)Z
/*     */     //   2988: ifeq -> 3017
/*     */     //   2991: aload_1
/*     */     //   2992: iload #4
/*     */     //   2994: aload #16
/*     */     //   2996: aastore
/*     */     //   2997: aload_1
/*     */     //   2998: iload #4
/*     */     //   3000: iconst_3
/*     */     //   3001: iadd
/*     */     //   3002: aload #16
/*     */     //   3004: aastore
/*     */     //   3005: iload #7
/*     */     //   3007: iload_3
/*     */     //   3008: bipush #14
/*     */     //   3010: iushr
/*     */     //   3011: ldc 131071
/*     */     //   3013: isub
/*     */     //   3014: iadd
/*     */     //   3015: istore #7
/*     */     //   3017: goto -> 3601
/*     */     //   3020: aload_1
/*     */     //   3021: iload #4
/*     */     //   3023: aaload
/*     */     //   3024: ldc ''for' initial value must be a number'
/*     */     //   3026: invokevirtual checknumber : (Ljava/lang/String;)Lcom/prineside/luaj/LuaNumber;
/*     */     //   3029: astore #14
/*     */     //   3031: aload_1
/*     */     //   3032: iload #4
/*     */     //   3034: iconst_1
/*     */     //   3035: iadd
/*     */     //   3036: aaload
/*     */     //   3037: ldc ''for' limit must be a number'
/*     */     //   3039: invokevirtual checknumber : (Ljava/lang/String;)Lcom/prineside/luaj/LuaNumber;
/*     */     //   3042: astore #15
/*     */     //   3044: aload_1
/*     */     //   3045: iload #4
/*     */     //   3047: iconst_2
/*     */     //   3048: iadd
/*     */     //   3049: aaload
/*     */     //   3050: ldc ''for' step must be a number'
/*     */     //   3052: invokevirtual checknumber : (Ljava/lang/String;)Lcom/prineside/luaj/LuaNumber;
/*     */     //   3055: astore #16
/*     */     //   3057: aload_1
/*     */     //   3058: iload #4
/*     */     //   3060: aload #14
/*     */     //   3062: aload #16
/*     */     //   3064: invokevirtual sub : (Lcom/prineside/luaj/LuaValue;)Lcom/prineside/luaj/LuaValue;
/*     */     //   3067: aastore
/*     */     //   3068: aload_1
/*     */     //   3069: iload #4
/*     */     //   3071: iconst_1
/*     */     //   3072: iadd
/*     */     //   3073: aload #15
/*     */     //   3075: aastore
/*     */     //   3076: aload_1
/*     */     //   3077: iload #4
/*     */     //   3079: iconst_2
/*     */     //   3080: iadd
/*     */     //   3081: aload #16
/*     */     //   3083: aastore
/*     */     //   3084: iload #7
/*     */     //   3086: iload_3
/*     */     //   3087: bipush #14
/*     */     //   3089: iushr
/*     */     //   3090: ldc 131071
/*     */     //   3092: isub
/*     */     //   3093: iadd
/*     */     //   3094: istore #7
/*     */     //   3096: goto -> 3601
/*     */     //   3099: aload_1
/*     */     //   3100: iload #4
/*     */     //   3102: aaload
/*     */     //   3103: aload_1
/*     */     //   3104: iload #4
/*     */     //   3106: iconst_1
/*     */     //   3107: iadd
/*     */     //   3108: aaload
/*     */     //   3109: aload_1
/*     */     //   3110: iload #4
/*     */     //   3112: iconst_2
/*     */     //   3113: iadd
/*     */     //   3114: aaload
/*     */     //   3115: invokestatic varargsOf : (Lcom/prineside/luaj/LuaValue;Lcom/prineside/luaj/Varargs;)Lcom/prineside/luaj/Varargs;
/*     */     //   3118: invokevirtual invoke : (Lcom/prineside/luaj/Varargs;)Lcom/prineside/luaj/Varargs;
/*     */     //   3121: astore #9
/*     */     //   3123: iload_3
/*     */     //   3124: bipush #14
/*     */     //   3126: ishr
/*     */     //   3127: sipush #511
/*     */     //   3130: iand
/*     */     //   3131: istore #6
/*     */     //   3133: iinc #6, -1
/*     */     //   3136: iload #6
/*     */     //   3138: iflt -> 3162
/*     */     //   3141: aload_1
/*     */     //   3142: iload #4
/*     */     //   3144: iconst_3
/*     */     //   3145: iadd
/*     */     //   3146: iload #6
/*     */     //   3148: iadd
/*     */     //   3149: aload #9
/*     */     //   3151: iload #6
/*     */     //   3153: iconst_1
/*     */     //   3154: iadd
/*     */     //   3155: invokevirtual arg : (I)Lcom/prineside/luaj/LuaValue;
/*     */     //   3158: aastore
/*     */     //   3159: goto -> 3133
/*     */     //   3162: getstatic com/prineside/luaj/LuaClosure.NONE : Lcom/prineside/luaj/LuaValue;
/*     */     //   3165: astore #9
/*     */     //   3167: goto -> 3601
/*     */     //   3170: aload_1
/*     */     //   3171: iload #4
/*     */     //   3173: iconst_1
/*     */     //   3174: iadd
/*     */     //   3175: aaload
/*     */     //   3176: invokevirtual isnil : ()Z
/*     */     //   3179: ifne -> 3601
/*     */     //   3182: aload_1
/*     */     //   3183: iload #4
/*     */     //   3185: aload_1
/*     */     //   3186: iload #4
/*     */     //   3188: iconst_1
/*     */     //   3189: iadd
/*     */     //   3190: aaload
/*     */     //   3191: aastore
/*     */     //   3192: iload #7
/*     */     //   3194: iload_3
/*     */     //   3195: bipush #14
/*     */     //   3197: iushr
/*     */     //   3198: ldc 131071
/*     */     //   3200: isub
/*     */     //   3201: iadd
/*     */     //   3202: istore #7
/*     */     //   3204: goto -> 3601
/*     */     //   3207: iload_3
/*     */     //   3208: bipush #14
/*     */     //   3210: ishr
/*     */     //   3211: sipush #511
/*     */     //   3214: iand
/*     */     //   3215: dup
/*     */     //   3216: istore #6
/*     */     //   3218: ifne -> 3231
/*     */     //   3221: aload #10
/*     */     //   3223: iinc #7, 1
/*     */     //   3226: iload #7
/*     */     //   3228: iaload
/*     */     //   3229: istore #6
/*     */     //   3231: iload #6
/*     */     //   3233: iconst_1
/*     */     //   3234: isub
/*     */     //   3235: bipush #50
/*     */     //   3237: imul
/*     */     //   3238: istore #14
/*     */     //   3240: aload_1
/*     */     //   3241: iload #4
/*     */     //   3243: aaload
/*     */     //   3244: astore #6
/*     */     //   3246: iload_3
/*     */     //   3247: bipush #23
/*     */     //   3249: iushr
/*     */     //   3250: dup
/*     */     //   3251: istore #5
/*     */     //   3253: ifne -> 3343
/*     */     //   3256: iload #8
/*     */     //   3258: iload #4
/*     */     //   3260: isub
/*     */     //   3261: iconst_1
/*     */     //   3262: isub
/*     */     //   3263: dup
/*     */     //   3264: istore #5
/*     */     //   3266: aload #9
/*     */     //   3268: invokevirtual narg : ()I
/*     */     //   3271: isub
/*     */     //   3272: istore #15
/*     */     //   3274: iconst_1
/*     */     //   3275: istore #16
/*     */     //   3277: iload #16
/*     */     //   3279: iload #15
/*     */     //   3281: if_icmpgt -> 3307
/*     */     //   3284: aload #6
/*     */     //   3286: iload #14
/*     */     //   3288: iload #16
/*     */     //   3290: iadd
/*     */     //   3291: aload_1
/*     */     //   3292: iload #4
/*     */     //   3294: iload #16
/*     */     //   3296: iadd
/*     */     //   3297: aaload
/*     */     //   3298: invokevirtual set : (ILcom/prineside/luaj/LuaValue;)V
/*     */     //   3301: iinc #16, 1
/*     */     //   3304: goto -> 3277
/*     */     //   3307: iload #16
/*     */     //   3309: iload #5
/*     */     //   3311: if_icmpgt -> 3340
/*     */     //   3314: aload #6
/*     */     //   3316: iload #14
/*     */     //   3318: iload #16
/*     */     //   3320: iadd
/*     */     //   3321: aload #9
/*     */     //   3323: iload #16
/*     */     //   3325: iload #15
/*     */     //   3327: isub
/*     */     //   3328: invokevirtual arg : (I)Lcom/prineside/luaj/LuaValue;
/*     */     //   3331: invokevirtual set : (ILcom/prineside/luaj/LuaValue;)V
/*     */     //   3334: iinc #16, 1
/*     */     //   3337: goto -> 3307
/*     */     //   3340: goto -> 3601
/*     */     //   3343: aload #6
/*     */     //   3345: iload #14
/*     */     //   3347: iload #5
/*     */     //   3349: iadd
/*     */     //   3350: invokevirtual presize : (I)V
/*     */     //   3353: iconst_1
/*     */     //   3354: istore #15
/*     */     //   3356: iload #15
/*     */     //   3358: iload #5
/*     */     //   3360: if_icmpgt -> 3386
/*     */     //   3363: aload #6
/*     */     //   3365: iload #14
/*     */     //   3367: iload #15
/*     */     //   3369: iadd
/*     */     //   3370: aload_1
/*     */     //   3371: iload #4
/*     */     //   3373: iload #15
/*     */     //   3375: iadd
/*     */     //   3376: aaload
/*     */     //   3377: invokevirtual set : (ILcom/prineside/luaj/LuaValue;)V
/*     */     //   3380: iinc #15, 1
/*     */     //   3383: goto -> 3356
/*     */     //   3386: goto -> 3601
/*     */     //   3389: aload_0
/*     */     //   3390: getfield p : Lcom/prineside/luaj/FPrototype;
/*     */     //   3393: getfield p : [Lcom/prineside/luaj/FPrototype;
/*     */     //   3396: iload_3
/*     */     //   3397: bipush #14
/*     */     //   3399: iushr
/*     */     //   3400: aaload
/*     */     //   3401: astore #14
/*     */     //   3403: new com/prineside/luaj/LuaClosure
/*     */     //   3406: dup
/*     */     //   3407: aload #14
/*     */     //   3409: aload_0
/*     */     //   3410: getfield a : Lcom/prineside/luaj/Globals;
/*     */     //   3413: invokespecial <init> : (Lcom/prineside/luaj/FPrototype;Lcom/prineside/luaj/LuaValue;)V
/*     */     //   3416: astore #15
/*     */     //   3418: aload #14
/*     */     //   3420: getfield upvalues : [Lcom/prineside/luaj/Upvaldesc;
/*     */     //   3423: astore #16
/*     */     //   3425: iconst_0
/*     */     //   3426: istore_3
/*     */     //   3427: aload #16
/*     */     //   3429: arraylength
/*     */     //   3430: istore #5
/*     */     //   3432: iload_3
/*     */     //   3433: iload #5
/*     */     //   3435: if_icmpge -> 3496
/*     */     //   3438: aload #16
/*     */     //   3440: iload_3
/*     */     //   3441: aaload
/*     */     //   3442: getfield instack : Z
/*     */     //   3445: ifeq -> 3471
/*     */     //   3448: aload #15
/*     */     //   3450: getfield c : [Lcom/prineside/luaj/UpValue;
/*     */     //   3453: iload_3
/*     */     //   3454: aload_1
/*     */     //   3455: aload #16
/*     */     //   3457: iload_3
/*     */     //   3458: aaload
/*     */     //   3459: getfield idx : S
/*     */     //   3462: aload #12
/*     */     //   3464: invokestatic a : ([Lcom/prineside/luaj/LuaValue;S[Lcom/prineside/luaj/UpValue;)Lcom/prineside/luaj/UpValue;
/*     */     //   3467: aastore
/*     */     //   3468: goto -> 3490
/*     */     //   3471: aload #15
/*     */     //   3473: getfield c : [Lcom/prineside/luaj/UpValue;
/*     */     //   3476: iload_3
/*     */     //   3477: aload_0
/*     */     //   3478: getfield c : [Lcom/prineside/luaj/UpValue;
/*     */     //   3481: aload #16
/*     */     //   3483: iload_3
/*     */     //   3484: aaload
/*     */     //   3485: getfield idx : S
/*     */     //   3488: aaload
/*     */     //   3489: aastore
/*     */     //   3490: iinc #3, 1
/*     */     //   3493: goto -> 3432
/*     */     //   3496: aload_1
/*     */     //   3497: iload #4
/*     */     //   3499: aload #15
/*     */     //   3501: aastore
/*     */     //   3502: goto -> 3601
/*     */     //   3505: iload_3
/*     */     //   3506: bipush #23
/*     */     //   3508: iushr
/*     */     //   3509: dup
/*     */     //   3510: istore #5
/*     */     //   3512: ifne -> 3530
/*     */     //   3515: iload #4
/*     */     //   3517: aload_2
/*     */     //   3518: invokevirtual narg : ()I
/*     */     //   3521: iadd
/*     */     //   3522: istore #8
/*     */     //   3524: aload_2
/*     */     //   3525: astore #9
/*     */     //   3527: goto -> 3601
/*     */     //   3530: iconst_1
/*     */     //   3531: istore #14
/*     */     //   3533: iload #14
/*     */     //   3535: iload #5
/*     */     //   3537: if_icmpge -> 3561
/*     */     //   3540: aload_1
/*     */     //   3541: iload #4
/*     */     //   3543: iload #14
/*     */     //   3545: iadd
/*     */     //   3546: iconst_1
/*     */     //   3547: isub
/*     */     //   3548: aload_2
/*     */     //   3549: iload #14
/*     */     //   3551: invokevirtual arg : (I)Lcom/prineside/luaj/LuaValue;
/*     */     //   3554: aastore
/*     */     //   3555: iinc #14, 1
/*     */     //   3558: goto -> 3533
/*     */     //   3561: goto -> 3601
/*     */     //   3564: new java/lang/IllegalArgumentException
/*     */     //   3567: dup
/*     */     //   3568: ldc 'Uexecutable opcode: OP_EXTRAARG'
/*     */     //   3570: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   3573: athrow
/*     */     //   3574: new java/lang/IllegalArgumentException
/*     */     //   3577: dup
/*     */     //   3578: new java/lang/StringBuilder
/*     */     //   3581: dup
/*     */     //   3582: ldc 'Illegal opcode: '
/*     */     //   3584: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   3587: iload_3
/*     */     //   3588: bipush #63
/*     */     //   3590: iand
/*     */     //   3591: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   3594: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   3597: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   3600: athrow
/*     */     //   3601: iinc #7, 1
/*     */     //   3604: goto -> 79
/*     */     //   3607: dup
/*     */     //   3608: astore #14
/*     */     //   3610: getfield c : Ljava/lang/String;
/*     */     //   3613: ifnonnull -> 3628
/*     */     //   3616: aload_0
/*     */     //   3617: aload #14
/*     */     //   3619: aload_0
/*     */     //   3620: getfield p : Lcom/prineside/luaj/FPrototype;
/*     */     //   3623: iload #7
/*     */     //   3625: invokespecial a : (Lcom/prineside/luaj/LuaError;Lcom/prineside/luaj/FPrototype;I)V
/*     */     //   3628: aload #14
/*     */     //   3630: athrow
/*     */     //   3631: astore #14
/*     */     //   3633: new com/prineside/luaj/LuaError
/*     */     //   3636: dup
/*     */     //   3637: aload #14
/*     */     //   3639: invokespecial <init> : (Ljava/lang/Throwable;)V
/*     */     //   3642: astore #15
/*     */     //   3644: aload_0
/*     */     //   3645: aload #15
/*     */     //   3647: aload_0
/*     */     //   3648: getfield p : Lcom/prineside/luaj/FPrototype;
/*     */     //   3651: iload #7
/*     */     //   3653: invokespecial a : (Lcom/prineside/luaj/LuaError;Lcom/prineside/luaj/FPrototype;I)V
/*     */     //   3656: aload #15
/*     */     //   3658: athrow
/*     */     //   3659: astore_1
/*     */     //   3660: aload #12
/*     */     //   3662: ifnull -> 3693
/*     */     //   3665: aload #12
/*     */     //   3667: arraylength
/*     */     //   3668: istore_2
/*     */     //   3669: iinc #2, -1
/*     */     //   3672: iload_2
/*     */     //   3673: iflt -> 3693
/*     */     //   3676: aload #12
/*     */     //   3678: iload_2
/*     */     //   3679: aaload
/*     */     //   3680: ifnull -> 3669
/*     */     //   3683: aload #12
/*     */     //   3685: iload_2
/*     */     //   3686: aaload
/*     */     //   3687: invokevirtual close : ()V
/*     */     //   3690: goto -> 3669
/*     */     //   3693: aload #13
/*     */     //   3695: invokevirtual onReturn : ()V
/*     */     //   3698: aload_1
/*     */     //   3699: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #221	-> 0
/*     */     //   #223	-> 6
/*     */     //   #224	-> 11
/*     */     //   #225	-> 20
/*     */     //   #229	-> 29
/*     */     //   #232	-> 51
/*     */     //   #233	-> 56
/*     */     //   #234	-> 63
/*     */     //   #235	-> 71
/*     */     //   #242	-> 79
/*     */     //   #245	-> 90
/*     */     //   #246	-> 96
/*     */     //   #268	-> 106
/*     */     //   #271	-> 284
/*     */     //   #272	-> 294
/*     */     //   #275	-> 297
/*     */     //   #276	-> 308
/*     */     //   #279	-> 311
/*     */     //   #280	-> 314
/*     */     //   #281	-> 320
/*     */     //   #282	-> 329
/*     */     //   #283	-> 335
/*     */     //   #284	-> 348
/*     */     //   #286	-> 395
/*     */     //   #287	-> 406
/*     */     //   #290	-> 409
/*     */     //   #291	-> 429
/*     */     //   #292	-> 436
/*     */     //   #296	-> 442
/*     */     //   #297	-> 456
/*     */     //   #301	-> 469
/*     */     //   #302	-> 485
/*     */     //   #305	-> 488
/*     */     //   #306	-> 540
/*     */     //   #327	-> 543
/*     */     //   #328	-> 589
/*     */     //   #331	-> 592
/*     */     //   #332	-> 667
/*     */     //   #335	-> 670
/*     */     //   #336	-> 686
/*     */     //   #339	-> 689
/*     */     //   #340	-> 758
/*     */     //   #343	-> 761
/*     */     //   #344	-> 784
/*     */     //   #347	-> 787
/*     */     //   #348	-> 802
/*     */     //   #349	-> 844
/*     */     //   #352	-> 847
/*     */     //   #353	-> 916
/*     */     //   #356	-> 919
/*     */     //   #357	-> 988
/*     */     //   #360	-> 991
/*     */     //   #361	-> 1060
/*     */     //   #364	-> 1063
/*     */     //   #365	-> 1132
/*     */     //   #368	-> 1135
/*     */     //   #369	-> 1204
/*     */     //   #372	-> 1207
/*     */     //   #373	-> 1276
/*     */     //   #376	-> 1279
/*     */     //   #377	-> 1292
/*     */     //   #380	-> 1295
/*     */     //   #381	-> 1308
/*     */     //   #384	-> 1311
/*     */     //   #385	-> 1324
/*     */     //   #388	-> 1327
/*     */     //   #389	-> 1333
/*     */     //   #391	-> 1342
/*     */     //   #392	-> 1351
/*     */     //   #393	-> 1360
/*     */     //   #394	-> 1370
/*     */     //   #395	-> 1383
/*     */     //   #396	-> 1392
/*     */     //   #397	-> 1395
/*     */     //   #400	-> 1412
/*     */     //   #403	-> 1415
/*     */     //   #404	-> 1427
/*     */     //   #405	-> 1432
/*     */     //   #406	-> 1448
/*     */     //   #407	-> 1469
/*     */     //   #408	-> 1477
/*     */     //   #414	-> 1486
/*     */     //   #415	-> 1564
/*     */     //   #419	-> 1570
/*     */     //   #420	-> 1648
/*     */     //   #424	-> 1654
/*     */     //   #425	-> 1732
/*     */     //   #429	-> 1738
/*     */     //   #430	-> 1760
/*     */     //   #435	-> 1766
/*     */     //   #436	-> 1793
/*     */     //   #438	-> 1799
/*     */     //   #439	-> 1805
/*     */     //   #442	-> 1808
/*     */     //   #443	-> 1904
/*     */     //   #444	-> 1929
/*     */     //   #445	-> 1957
/*     */     //   #446	-> 1968
/*     */     //   #447	-> 1985
/*     */     //   #448	-> 2008
/*     */     //   #449	-> 2037
/*     */     //   #450	-> 2051
/*     */     //   #451	-> 2071
/*     */     //   #452	-> 2097
/*     */     //   #454	-> 2129
/*     */     //   #455	-> 2135
/*     */     //   #456	-> 2145
/*     */     //   #457	-> 2154
/*     */     //   #458	-> 2169
/*     */     //   #456	-> 2192
/*     */     //   #459	-> 2197
/*     */     //   #460	-> 2202
/*     */     //   #461	-> 2214
/*     */     //   #463	-> 2222
/*     */     //   #464	-> 2232
/*     */     //   #466	-> 2239
/*     */     //   #470	-> 2242
/*     */     //   #471	-> 2288
/*     */     //   #597	-> 2304
/*     */     //   #598	-> 2309
/*     */     //   #599	-> 2322
/*     */     //   #600	-> 2330
/*     */     //   #602	-> 2341
/*     */     //   #471	-> 2346
/*     */     //   #472	-> 2349
/*     */     //   #597	-> 2368
/*     */     //   #598	-> 2373
/*     */     //   #599	-> 2386
/*     */     //   #600	-> 2394
/*     */     //   #602	-> 2405
/*     */     //   #472	-> 2410
/*     */     //   #473	-> 2413
/*     */     //   #597	-> 2441
/*     */     //   #598	-> 2446
/*     */     //   #599	-> 2459
/*     */     //   #600	-> 2467
/*     */     //   #602	-> 2478
/*     */     //   #473	-> 2483
/*     */     //   #474	-> 2486
/*     */     //   #597	-> 2520
/*     */     //   #598	-> 2525
/*     */     //   #599	-> 2538
/*     */     //   #600	-> 2546
/*     */     //   #602	-> 2557
/*     */     //   #474	-> 2562
/*     */     //   #476	-> 2565
/*     */     //   #477	-> 2570
/*     */     //   #478	-> 2575
/*     */     //   #479	-> 2590
/*     */     //   #480	-> 2615
/*     */     //   #597	-> 2630
/*     */     //   #598	-> 2635
/*     */     //   #599	-> 2648
/*     */     //   #600	-> 2656
/*     */     //   #602	-> 2667
/*     */     //   #480	-> 2672
/*     */     //   #484	-> 2675
/*     */     //   #485	-> 2680
/*     */     //   #486	-> 2708
/*     */     //   #597	-> 2729
/*     */     //   #598	-> 2734
/*     */     //   #599	-> 2747
/*     */     //   #600	-> 2755
/*     */     //   #602	-> 2766
/*     */     //   #486	-> 2771
/*     */     //   #487	-> 2774
/*     */     //   #597	-> 2779
/*     */     //   #598	-> 2784
/*     */     //   #599	-> 2797
/*     */     //   #600	-> 2805
/*     */     //   #602	-> 2816
/*     */     //   #487	-> 2821
/*     */     //   #488	-> 2824
/*     */     //   #597	-> 2830
/*     */     //   #598	-> 2835
/*     */     //   #599	-> 2848
/*     */     //   #600	-> 2856
/*     */     //   #602	-> 2867
/*     */     //   #488	-> 2872
/*     */     //   #490	-> 2875
/*     */     //   #597	-> 2887
/*     */     //   #598	-> 2892
/*     */     //   #599	-> 2905
/*     */     //   #600	-> 2913
/*     */     //   #602	-> 2924
/*     */     //   #490	-> 2929
/*     */     //   #495	-> 2932
/*     */     //   #496	-> 2940
/*     */     //   #497	-> 2948
/*     */     //   #498	-> 2959
/*     */     //   #499	-> 2991
/*     */     //   #500	-> 2997
/*     */     //   #501	-> 3005
/*     */     //   #504	-> 3017
/*     */     //   #508	-> 3020
/*     */     //   #509	-> 3031
/*     */     //   #510	-> 3044
/*     */     //   #511	-> 3057
/*     */     //   #512	-> 3068
/*     */     //   #513	-> 3076
/*     */     //   #514	-> 3084
/*     */     //   #516	-> 3096
/*     */     //   #519	-> 3099
/*     */     //   #520	-> 3123
/*     */     //   #521	-> 3133
/*     */     //   #522	-> 3141
/*     */     //   #523	-> 3162
/*     */     //   #524	-> 3167
/*     */     //   #527	-> 3170
/*     */     //   #528	-> 3182
/*     */     //   #529	-> 3192
/*     */     //   #535	-> 3207
/*     */     //   #536	-> 3221
/*     */     //   #537	-> 3231
/*     */     //   #538	-> 3240
/*     */     //   #539	-> 3246
/*     */     //   #540	-> 3256
/*     */     //   #541	-> 3264
/*     */     //   #542	-> 3274
/*     */     //   #543	-> 3277
/*     */     //   #544	-> 3284
/*     */     //   #543	-> 3301
/*     */     //   #545	-> 3307
/*     */     //   #546	-> 3314
/*     */     //   #545	-> 3334
/*     */     //   #547	-> 3340
/*     */     //   #548	-> 3343
/*     */     //   #549	-> 3353
/*     */     //   #550	-> 3363
/*     */     //   #549	-> 3380
/*     */     //   #553	-> 3386
/*     */     //   #557	-> 3389
/*     */     //   #558	-> 3403
/*     */     //   #559	-> 3418
/*     */     //   #560	-> 3425
/*     */     //   #561	-> 3438
/*     */     //   #562	-> 3448
/*     */     //   #564	-> 3471
/*     */     //   #560	-> 3490
/*     */     //   #566	-> 3496
/*     */     //   #568	-> 3502
/*     */     //   #571	-> 3505
/*     */     //   #572	-> 3510
/*     */     //   #573	-> 3515
/*     */     //   #574	-> 3524
/*     */     //   #576	-> 3530
/*     */     //   #577	-> 3540
/*     */     //   #576	-> 3555
/*     */     //   #579	-> 3561
/*     */     //   #582	-> 3564
/*     */     //   #585	-> 3574
/*     */     //   #241	-> 3601
/*     */     //   #588	-> 3607
/*     */     //   #589	-> 3608
/*     */     //   #590	-> 3616
/*     */     //   #591	-> 3628
/*     */     //   #592	-> 3631
/*     */     //   #593	-> 3633
/*     */     //   #594	-> 3644
/*     */     //   #595	-> 3656
/*     */     //   #597	-> 3659
/*     */     //   #598	-> 3665
/*     */     //   #599	-> 3676
/*     */     //   #600	-> 3683
/*     */     //   #602	-> 3693
/*     */     //   #603	-> 3698
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   79	2304	3607	com/prineside/luaj/LuaError
/*     */     //   79	2304	3631	java/lang/Exception
/*     */     //   79	2304	3659	finally
/*     */     //   2349	2368	3607	com/prineside/luaj/LuaError
/*     */     //   2349	2368	3631	java/lang/Exception
/*     */     //   2349	2368	3659	finally
/*     */     //   2413	2441	3607	com/prineside/luaj/LuaError
/*     */     //   2413	2441	3631	java/lang/Exception
/*     */     //   2413	2441	3659	finally
/*     */     //   2486	2520	3607	com/prineside/luaj/LuaError
/*     */     //   2486	2520	3631	java/lang/Exception
/*     */     //   2486	2520	3659	finally
/*     */     //   2565	2630	3607	com/prineside/luaj/LuaError
/*     */     //   2565	2630	3631	java/lang/Exception
/*     */     //   2565	2630	3659	finally
/*     */     //   2675	2729	3607	com/prineside/luaj/LuaError
/*     */     //   2675	2729	3631	java/lang/Exception
/*     */     //   2675	2729	3659	finally
/*     */     //   2774	2779	3607	com/prineside/luaj/LuaError
/*     */     //   2774	2779	3631	java/lang/Exception
/*     */     //   2774	2779	3659	finally
/*     */     //   2824	2830	3607	com/prineside/luaj/LuaError
/*     */     //   2824	2830	3631	java/lang/Exception
/*     */     //   2824	2830	3659	finally
/*     */     //   2875	2887	3607	com/prineside/luaj/LuaError
/*     */     //   2875	2887	3631	java/lang/Exception
/*     */     //   2875	2887	3659	finally
/*     */     //   2932	3607	3607	com/prineside/luaj/LuaError
/*     */     //   2932	3607	3631	java/lang/Exception
/*     */     //   2932	3660	3659	finally
/*     */   }
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
/*     */ 
/*     */ 
/*     */   
/*     */   private String a(String paramString, int paramInt) {
/* 611 */     if (this.a == null) return paramString; 
/*     */     LuaValue luaValue;
/* 613 */     if ((luaValue = this.a.getErrorFunc()) == null) {
/*     */       DebugLib debugLib;
/* 615 */       if ((debugLib = this.a.getDebugLib()) != null) {
/* 616 */         return paramString + "\n" + debugLib.traceback(paramInt);
/*     */       }
/* 618 */       return paramString;
/*     */     } 
/* 620 */     this.a.setErrorFunc(null);
/*     */     try {
/* 622 */       return luaValue.call(LuaValue.valueOf(paramString)).tojstring();
/* 623 */     } catch (Throwable throwable) {
/* 624 */       paramString = "error in error handling"; return paramString;
/*     */     } finally {
/* 626 */       this.a.setErrorFunc(luaValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(LuaError paramLuaError, FPrototype paramFPrototype, int paramInt) {
/* 631 */     String str = "?";
/* 632 */     int i = -1;
/*     */     
/* 634 */     CallFrame callFrame = null; DebugLib debugLib;
/* 635 */     if (this.a != null && (
/*     */       
/* 637 */       debugLib = this.a.getDebugLib()) != null && (
/*     */       
/* 639 */       callFrame = debugLib.getCallFrame(paramLuaError.a)) != null) {
/* 640 */       str = callFrame.shortsource();
/* 641 */       i = callFrame.currentline();
/*     */     } 
/*     */ 
/*     */     
/* 645 */     if (callFrame == null) {
/* 646 */       str = (paramFPrototype.source != null) ? paramFPrototype.source.tojstring() : "?";
/* 647 */       i = (paramFPrototype.lineinfo != null && paramInt >= 0 && paramInt < paramFPrototype.lineinfo.length) ? paramFPrototype.lineinfo[paramInt] : -1;
/*     */     } 
/*     */     
/* 650 */     paramLuaError.b = str + ":" + i;
/* 651 */     paramLuaError.c = a(paramLuaError.getMessage(), paramLuaError.a);
/*     */   }
/*     */   
/*     */   private static UpValue a(LuaValue[] paramArrayOfLuaValue, short paramShort, UpValue[] paramArrayOfUpValue) {
/* 655 */     int i = paramArrayOfUpValue.length; UpValue[] arrayOfUpValue; int j; byte b2;
/* 656 */     for (j = (arrayOfUpValue = paramArrayOfUpValue).length, b2 = 0; b2 < j; ) {
/* 657 */       UpValue upValue; if ((upValue = arrayOfUpValue[b2]) != null && upValue.a == paramShort)
/* 658 */         return upValue;  b2++;
/* 659 */     }  for (byte b1 = 0; b1 < i; b1++) {
/* 660 */       if (paramArrayOfUpValue[b1] == null)
/* 661 */       { paramArrayOfUpValue[b1] = new UpValue(paramArrayOfLuaValue, paramShort); return new UpValue(paramArrayOfLuaValue, paramShort); } 
/* 662 */     }  error("No space for upvalue");
/* 663 */     return null;
/*     */   }
/*     */   
/*     */   public final String name() {
/* 667 */     return "<" + this.p.shortsource() + ":" + this.p.linedefined + ">";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\LuaClosure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */