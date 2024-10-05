/*     */ package com.prineside.tdi2.gameplayMods;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS(classOnly = true)
/*     */ public interface ProbableBonusesProvider
/*     */ {
/*  13 */   public static final TLog logger = TLog.forClass(ProbableBonusesProvider.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String _TAG = "ProbableBonusesProvider";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void provide(int paramInt, BonusStagesConfig paramBonusStagesConfig, Array<GameplayModSystem.ActiveMod> paramArray, Array<ProbableBonus> paramArray1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   static <T extends GenericGameplayMod> ProbableBonus addOrModify(T paramT, int paramInt, Array<GameplayModSystem.ActiveMod> paramArray, BonusProviderConfig paramBonusProviderConfig) {
/*     */     // Byte code:
/*     */     //   0: iload_1
/*     */     //   1: aload_3
/*     */     //   2: invokevirtual getMinStage : ()I
/*     */     //   5: if_icmpge -> 10
/*     */     //   8: aconst_null
/*     */     //   9: areturn
/*     */     //   10: aload_3
/*     */     //   11: getfield maxStage : I
/*     */     //   14: ifle -> 27
/*     */     //   17: iload_1
/*     */     //   18: aload_3
/*     */     //   19: getfield maxStage : I
/*     */     //   22: if_icmple -> 27
/*     */     //   25: aconst_null
/*     */     //   26: areturn
/*     */     //   27: aload_3
/*     */     //   28: getfield probability : F
/*     */     //   31: dup
/*     */     //   32: fstore #4
/*     */     //   34: f2d
/*     */     //   35: aload_3
/*     */     //   36: getfield probabilityMultiplierPerStage : F
/*     */     //   39: fconst_0
/*     */     //   40: fcmpg
/*     */     //   41: ifgt -> 48
/*     */     //   44: dconst_1
/*     */     //   45: goto -> 63
/*     */     //   48: aload_3
/*     */     //   49: getfield probabilityMultiplierPerStage : F
/*     */     //   52: f2d
/*     */     //   53: iload_1
/*     */     //   54: aload_3
/*     */     //   55: invokevirtual getMinStage : ()I
/*     */     //   58: isub
/*     */     //   59: i2d
/*     */     //   60: invokestatic pow : (DD)D
/*     */     //   63: dmul
/*     */     //   64: d2f
/*     */     //   65: dup
/*     */     //   66: fstore #4
/*     */     //   68: fconst_0
/*     */     //   69: fcmpg
/*     */     //   70: ifgt -> 75
/*     */     //   73: aconst_null
/*     */     //   74: areturn
/*     */     //   75: aconst_null
/*     */     //   76: astore_1
/*     */     //   77: iconst_0
/*     */     //   78: istore #5
/*     */     //   80: iload #5
/*     */     //   82: aload_2
/*     */     //   83: getfield size : I
/*     */     //   86: if_icmpge -> 151
/*     */     //   89: aload_2
/*     */     //   90: getfield items : [Ljava/lang/Object;
/*     */     //   93: checkcast [Lcom/prineside/tdi2/systems/GameplayModSystem$ActiveMod;
/*     */     //   96: iload #5
/*     */     //   98: aaload
/*     */     //   99: dup
/*     */     //   100: astore #6
/*     */     //   102: invokevirtual getMod : ()Lcom/prineside/tdi2/gameplayMods/GameplayMod;
/*     */     //   105: invokeinterface getId : ()Ljava/lang/String;
/*     */     //   110: aload_0
/*     */     //   111: invokevirtual getId : ()Ljava/lang/String;
/*     */     //   114: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   117: ifeq -> 145
/*     */     //   120: aload #6
/*     */     //   122: invokevirtual getSource : ()Ljava/lang/String;
/*     */     //   125: ldc 'BonusSystem'
/*     */     //   127: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   130: ifeq -> 145
/*     */     //   133: aload #6
/*     */     //   135: invokevirtual getMod : ()Lcom/prineside/tdi2/gameplayMods/GameplayMod;
/*     */     //   138: checkcast com/prineside/tdi2/gameplayMods/GenericGameplayMod
/*     */     //   141: astore_1
/*     */     //   142: goto -> 151
/*     */     //   145: iinc #5, 1
/*     */     //   148: goto -> 80
/*     */     //   151: aload_1
/*     */     //   152: ifnull -> 356
/*     */     //   155: aload_1
/*     */     //   156: invokevirtual getMaxPower : ()I
/*     */     //   159: aload_1
/*     */     //   160: invokevirtual getPower : ()I
/*     */     //   163: iconst_1
/*     */     //   164: iadd
/*     */     //   165: invokestatic min : (II)I
/*     */     //   168: dup
/*     */     //   169: istore #5
/*     */     //   171: aload_1
/*     */     //   172: invokevirtual getPower : ()I
/*     */     //   175: if_icmpgt -> 245
/*     */     //   178: getstatic com/prineside/tdi2/gameplayMods/ProbableBonusesProvider.logger : Lcom/prineside/tdi2/utils/logging/TLog;
/*     */     //   181: new java/lang/StringBuilder
/*     */     //   184: dup
/*     */     //   185: ldc 'won't increase power (proto: '
/*     */     //   187: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   190: aload_0
/*     */     //   191: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   194: ldc ', was '
/*     */     //   196: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   199: aload_1
/*     */     //   200: invokevirtual getPower : ()I
/*     */     //   203: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   206: ldc ', max '
/*     */     //   208: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   211: aload_1
/*     */     //   212: invokevirtual getMaxPower : ()I
/*     */     //   215: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   218: ldc ', new '
/*     */     //   220: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   223: iload #5
/*     */     //   225: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   228: ldc '), skipping'
/*     */     //   230: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   233: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   236: iconst_0
/*     */     //   237: anewarray java/lang/Object
/*     */     //   240: invokevirtual d : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   243: aconst_null
/*     */     //   244: areturn
/*     */     //   245: getstatic com/prineside/tdi2/gameplayMods/ProbableBonusesProvider.logger : Lcom/prineside/tdi2/utils/logging/TLog;
/*     */     //   248: new java/lang/StringBuilder
/*     */     //   251: dup
/*     */     //   252: ldc 'found existing for proto (proto: '
/*     */     //   254: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   257: aload_0
/*     */     //   258: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   261: ldc ', existing: '
/*     */     //   263: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   266: aload_1
/*     */     //   267: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   270: ldc ')'
/*     */     //   272: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   275: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   278: iconst_0
/*     */     //   279: anewarray java/lang/Object
/*     */     //   282: invokevirtual d : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   285: aload_0
/*     */     //   286: invokevirtual cpy : ()Lcom/prineside/tdi2/gameplayMods/GameplayMod;
/*     */     //   289: checkcast com/prineside/tdi2/gameplayMods/GenericGameplayMod
/*     */     //   292: astore #6
/*     */     //   294: aload_3
/*     */     //   295: getfield powerUpProbabilityMultiplier : F
/*     */     //   298: fconst_0
/*     */     //   299: fcmpl
/*     */     //   300: ifne -> 307
/*     */     //   303: fconst_1
/*     */     //   304: goto -> 322
/*     */     //   307: aload_3
/*     */     //   308: getfield powerUpProbabilityMultiplier : F
/*     */     //   311: f2d
/*     */     //   312: aload #6
/*     */     //   314: getfield power : I
/*     */     //   317: i2d
/*     */     //   318: invokestatic pow : (DD)D
/*     */     //   321: d2f
/*     */     //   322: fstore_1
/*     */     //   323: aload #6
/*     */     //   325: iload #5
/*     */     //   327: putfield power : I
/*     */     //   330: ldc 100000.0
/*     */     //   332: fload #4
/*     */     //   334: fmul
/*     */     //   335: fload_1
/*     */     //   336: fmul
/*     */     //   337: f2i
/*     */     //   338: dup
/*     */     //   339: istore_0
/*     */     //   340: ifle -> 354
/*     */     //   343: new com/prineside/tdi2/gameplayMods/ProbableBonus
/*     */     //   346: dup
/*     */     //   347: aload #6
/*     */     //   349: iload_0
/*     */     //   350: invokespecial <init> : (Lcom/prineside/tdi2/gameplayMods/GameplayMod;I)V
/*     */     //   353: areturn
/*     */     //   354: aconst_null
/*     */     //   355: areturn
/*     */     //   356: aload_0
/*     */     //   357: invokevirtual cpy : ()Lcom/prineside/tdi2/gameplayMods/GameplayMod;
/*     */     //   360: checkcast com/prineside/tdi2/gameplayMods/GenericGameplayMod
/*     */     //   363: dup
/*     */     //   364: astore #5
/*     */     //   366: invokevirtual allowsMultipleInstancesFromDifferentSources : ()Z
/*     */     //   369: ifne -> 434
/*     */     //   372: iconst_0
/*     */     //   373: istore #6
/*     */     //   375: iload #6
/*     */     //   377: aload_2
/*     */     //   378: getfield size : I
/*     */     //   381: if_icmpge -> 434
/*     */     //   384: aload_2
/*     */     //   385: getfield items : [Ljava/lang/Object;
/*     */     //   388: checkcast [Lcom/prineside/tdi2/systems/GameplayModSystem$ActiveMod;
/*     */     //   391: iload #6
/*     */     //   393: aaload
/*     */     //   394: dup
/*     */     //   395: astore_1
/*     */     //   396: invokevirtual getSource : ()Ljava/lang/String;
/*     */     //   399: ldc 'BonusSystem'
/*     */     //   401: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   404: ifne -> 428
/*     */     //   407: aload_0
/*     */     //   408: invokevirtual getId : ()Ljava/lang/String;
/*     */     //   411: aload_1
/*     */     //   412: invokevirtual getMod : ()Lcom/prineside/tdi2/gameplayMods/GameplayMod;
/*     */     //   415: invokeinterface getId : ()Ljava/lang/String;
/*     */     //   420: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   423: ifeq -> 428
/*     */     //   426: aconst_null
/*     */     //   427: areturn
/*     */     //   428: iinc #6, 1
/*     */     //   431: goto -> 375
/*     */     //   434: ldc 100000.0
/*     */     //   436: fload #4
/*     */     //   438: fmul
/*     */     //   439: f2i
/*     */     //   440: dup
/*     */     //   441: istore #6
/*     */     //   443: ifgt -> 448
/*     */     //   446: aconst_null
/*     */     //   447: areturn
/*     */     //   448: new com/prineside/tdi2/gameplayMods/ProbableBonus
/*     */     //   451: dup
/*     */     //   452: aload #5
/*     */     //   454: iload #6
/*     */     //   456: invokespecial <init> : (Lcom/prineside/tdi2/gameplayMods/GameplayMod;I)V
/*     */     //   459: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #35	-> 0
/*     */     //   #36	-> 10
/*     */     //   #38	-> 27
/*     */     //   #39	-> 32
/*     */     //   #40	-> 66
/*     */     //   #42	-> 75
/*     */     //   #43	-> 77
/*     */     //   #44	-> 89
/*     */     //   #45	-> 100
/*     */     //   #48	-> 133
/*     */     //   #49	-> 142
/*     */     //   #43	-> 145
/*     */     //   #53	-> 151
/*     */     //   #55	-> 155
/*     */     //   #56	-> 169
/*     */     //   #57	-> 178
/*     */     //   #58	-> 243
/*     */     //   #61	-> 245
/*     */     //   #63	-> 285
/*     */     //   #64	-> 294
/*     */     //   #65	-> 323
/*     */     //   #67	-> 330
/*     */     //   #68	-> 339
/*     */     //   #69	-> 343
/*     */     //   #71	-> 354
/*     */     //   #77	-> 356
/*     */     //   #78	-> 364
/*     */     //   #80	-> 372
/*     */     //   #81	-> 384
/*     */     //   #82	-> 395
/*     */     //   #83	-> 426
/*     */     //   #80	-> 428
/*     */     //   #89	-> 434
/*     */     //   #90	-> 441
/*     */     //   #92	-> 448
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
/*     */   public static class BonusProviderConfig
/*     */   {
/*  96 */     public float probability = 1.0F;
/*     */     
/*     */     public float powerUpProbabilityMultiplier;
/*     */     
/*     */     public int minStage;
/*     */     public int maxStage;
/*     */     public float probabilityMultiplierPerStage;
/*     */     
/*     */     public BonusProviderConfig() {}
/*     */     
/*     */     public BonusProviderConfig(float param1Float) {
/* 107 */       this.probability = param1Float;
/*     */     }
/*     */     
/*     */     public int getMinStage() {
/* 111 */       return Math.max(this.minStage, 1);
/*     */     }
/*     */     
/*     */     public BonusProviderConfig setProbability(float param1Float) {
/* 115 */       this.probability = param1Float;
/* 116 */       return this;
/*     */     }
/*     */     
/*     */     public BonusProviderConfig setPowerUpProbabilityMultiplier(float param1Float) {
/* 120 */       this.powerUpProbabilityMultiplier = param1Float;
/* 121 */       return this;
/*     */     }
/*     */     
/*     */     public BonusProviderConfig setProbabilityMultiplierPerStage(float param1Float) {
/* 125 */       this.probabilityMultiplierPerStage = param1Float;
/* 126 */       return this;
/*     */     }
/*     */     
/*     */     public BonusProviderConfig setMinStage(int param1Int) {
/* 130 */       this.minStage = param1Int;
/* 131 */       return this;
/*     */     }
/*     */     
/*     */     public BonusProviderConfig setMaxStage(int param1Int) {
/* 135 */       this.maxStage = param1Int;
/* 136 */       return this;
/*     */     }
/*     */     
/*     */     public BonusProviderConfig(float param1Float1, float param1Float2, int param1Int1, int param1Int2, float param1Float3) {
/* 140 */       this.probability = param1Float1;
/* 141 */       this.powerUpProbabilityMultiplier = param1Float2;
/* 142 */       this.minStage = param1Int1;
/* 143 */       this.maxStage = param1Int2;
/* 144 */       this.probabilityMultiplierPerStage = param1Float3;
/*     */     }
/*     */     
/*     */     public BonusProviderConfig applyConfig(JsonValue param1JsonValue) {
/* 148 */       this.probability = param1JsonValue.getFloat("probability", this.probability);
/* 149 */       this.powerUpProbabilityMultiplier = param1JsonValue.getFloat("powerUpProbabilityMultiplier", this.powerUpProbabilityMultiplier);
/* 150 */       this.minStage = param1JsonValue.getInt("minStage", this.minStage);
/* 151 */       this.maxStage = param1JsonValue.getInt("maxStage", this.maxStage);
/* 152 */       this.probabilityMultiplierPerStage = param1JsonValue.getFloat("probabilityMultiplierPerStage", this.probabilityMultiplierPerStage);
/* 153 */       return this;
/*     */     }
/*     */     
/*     */     public BonusProviderConfig cpy() {
/* 157 */       return new BonusProviderConfig(this.probability, this.powerUpProbabilityMultiplier, this.minStage, this.maxStage, this.probabilityMultiplierPerStage);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\ProbableBonusesProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */