/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.prineside.tdi2.managers.HttpManager;
/*     */ import com.prineside.tdi2.managers.ReplayManager;
/*     */ import com.prineside.tdi2.systems.GameStateSystem;
/*     */ import com.prineside.tdi2.utils.ObjectConsumer;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.PlatformLogger;
/*     */ import com.prineside.tdi2.utils.logging.SystemOutPlatformLogger;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HeadlessReplayValidationGame
/*     */   extends Game
/*     */ {
/*  27 */   private static final TLog a = TLog.forClass(HeadlessReplayValidationGame.class);
/*     */   
/*     */   public String currentReplay;
/*     */   
/*     */   public short instanceNumber;
/*     */   private FileHandle b;
/*     */   private int c;
/*  34 */   private final int d = (new Random()).nextInt(1800);
/*     */   
/*     */   public HeadlessReplayValidationGame(short paramShort, FileHandle paramFileHandle) {
/*  37 */     super(ActionResolver.createDummy(paramFileHandle, (PlatformLogger)new SystemOutPlatformLogger(false, false)), null);
/*     */     
/*  39 */     System.out.println("instance: " + paramShort);
/*  40 */     this.instanceNumber = paramShort;
/*  41 */     this.c = Game.getTimestampSeconds();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkServerHalted() {
/*  49 */     if (Gdx.files.local("halt.txt").exists()) {
/*  50 */       a.i("halt.txt found, exiting", new Object[0]);
/*  51 */       writeServerStatus("halted");
/*  52 */       Game.exit();
/*     */       
/*  54 */       return true;
/*     */     } 
/*     */     
/*  57 */     if (Game.getTimestampSeconds() > this.c + 43200 + this.d) {
/*     */       
/*  59 */       a.i("automatic restart", new Object[0]);
/*  60 */       writeServerStatus("autoRestart");
/*  61 */       Game.exit();
/*     */       
/*  63 */       return true;
/*     */     } 
/*     */     
/*  66 */     return false;
/*     */   }
/*     */   
/*     */   public synchronized void writeServerStatus(String paramString) {
/*  70 */     if (this.b == null) this.b = Gdx.files.local("status-" + this.instanceNumber + ".txt"); 
/*  71 */     int i = (int)((float)Runtime.getRuntime().totalMemory() / 1024.0F / 1024.0F);
/*  72 */     int j = (int)((float)Runtime.getRuntime().freeMemory() / 1024.0F / 1024.0F);
/*  73 */     int k = (int)((float)Runtime.getRuntime().maxMemory() / 1024.0F / 1024.0F);
/*  74 */     this.b.writeString(Game.getTimestampSeconds() + "|" + i + "," + j + "," + k + "|" + paramString, false, "UTF-8");
/*     */   }
/*     */ 
/*     */   
/*     */   public void create() {
/*  79 */     super.create();
/*     */     
/*  81 */     a.i("started loading...", new Object[0]);
/*  82 */     while (this.gameSyncLoader.iterate()) {
/*  83 */       a.i("loading: " + StringFormatter.compactNumberWithPrecision((this.gameSyncLoader.getProgress() * 100.0F), 1) + "%", new Object[0]);
/*     */       try {
/*  85 */         Thread.sleep(1L);
/*  86 */       } catch (InterruptedException interruptedException2) {
/*  87 */         InterruptedException interruptedException1; (interruptedException1 = null).printStackTrace();
/*     */       } 
/*     */     } 
/*  90 */     a.i("fully loaded!", new Object[0]);
/*     */     
/*  92 */     writeServerStatus("loaded");
/*  93 */     b();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b() {
/* 104 */     if (checkServerHalted()) {
/*     */       return;
/*     */     }
/*     */     
/* 108 */     a(paramString -> {
/*     */           ReplayManager.ReplayRecord replayRecord1;
/*     */           
/*     */           if (paramString == null || paramString.length() == 0) {
/*     */             writeServerStatus("emptyReplayPushMainThread");
/*     */             writeServerStatus("noReplay");
/*     */             a.i("...", new Object[0]);
/*     */             try {
/*     */               Thread.sleep(5000L);
/* 117 */             } catch (InterruptedException interruptedException) {
/*     */               (paramString = null).printStackTrace();
/*     */             } 
/*     */             
/*     */             b();
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*     */           writeServerStatus("notEmptyReplayPushMainThread");
/*     */           try {
/*     */             replayRecord1 = ReplayManager.ReplayRecord.fromCompactString(paramString);
/* 129 */           } catch (Exception exception) {
/*     */             writeServerStatus("replayParseException");
/*     */             Game.i.httpManager.post(Config.SITE_URL + "/?m=api&a=submitReplayValidation&v=207").param("id", this.currentReplay).param("log", "r:" + GameStateSystem.ReplayValidationResult.Result.INVALID_RECORD.name() + ",u:0,ts:0,ups:0,rw:0,rs:0,i:" + this.instanceNumber + ",failed to parse json").param("valid", "false").send();
/*     */             a.e("failed to parse record json for " + this.currentReplay + ":" + exception.getMessage(), new Object[] { exception });
/*     */             b();
/*     */             return;
/*     */           } 
/*     */           a.i("", new Object[0]);
/*     */           ReplayManager.ReplayRecord replayRecord2 = replayRecord1;
/*     */           Runnable runnable = ();
/*     */           if (replayRecord1.gameMode == GameStateSystem.GameMode.BASIC_LEVELS && replayRecord1.levelName.startsWith("DQ")) {
/*     */             int i = Integer.parseInt(replayRecord1.levelName.substring(2));
/*     */             writeServerStatus("requestDailyQuestHash");
/*     */             Game.i.dailyQuestManager.getDailyQuestHashFromServer(i, ());
/*     */             return;
/*     */           } 
/*     */           runnable.run();
/*     */         });
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
/*     */   private void a(ObjectConsumer<String> paramObjectConsumer) {
/* 234 */     long l = Game.getTimestampMillis();
/*     */     
/* 236 */     writeServerStatus("sendingReplayRequest");
/*     */     
/*     */     HttpManager.PreparedRequest preparedRequest;
/*     */     
/* 240 */     (preparedRequest = Game.i.httpManager.post(Config.SITE_URL + "/?m=api&a=getReplayForValidationV2&v=207").timeOut(5000)).param("protocol", "207");
/* 241 */     preparedRequest.param("validatorInstance", this.instanceNumber);
/* 242 */     if (Gdx.files.local("endless.txt").exists()) {
/* 243 */       preparedRequest.param("endless", "true");
/*     */     }
/* 245 */     preparedRequest.listener((paramBoolean1, paramHttpResponse, paramBoolean2, paramThrowable) -> {
/*     */           writeServerStatus("replayResponseReceived_" + paramBoolean1);
/*     */           
/*     */           if (paramBoolean1) {
/*     */             String str = paramHttpResponse.getResultAsString();
/*     */             
/*     */             a.i("got from server in: " + StringFormatter.compactNumber(((float)(Game.getTimestampMillis() - paramLong) * 0.001F), true) + "s, " + str.length() + " chars", new Object[0]);
/*     */             try {
/*     */               writeServerStatus("parsingReplay");
/*     */               JsonValue jsonValue = (new JsonReader()).parse(str);
/*     */               writeServerStatus("parsedReplay");
/*     */               if (jsonValue.getString("status").equals("success")) {
/*     */                 this.currentReplay = jsonValue.getString("id");
/*     */                 a.i("---- starting replay " + this.currentReplay, new Object[0]);
/*     */                 paramObjectConsumer.accept(jsonValue.getString("replay"));
/*     */               } else {
/*     */                 writeServerStatus("replayResponseInvalidStatus_" + jsonValue.getString("status"));
/*     */                 throw new IllegalStateException("Status is not success: " + jsonValue.getString("status"));
/*     */               } 
/* 264 */             } catch (Exception exception) {
/*     */               writeServerStatus("replayResponseException");
/*     */               
/*     */               paramObjectConsumer.accept(null);
/*     */             } 
/*     */             return;
/*     */           } 
/*     */           a.e("Failed", new Object[] { paramThrowable });
/*     */           writeServerStatus("replayResponseFailure");
/*     */           paramObjectConsumer.accept(null);
/*     */         });
/* 275 */     preparedRequest.send();
/*     */   }
/*     */   
/*     */   public static void headlessValidateGame(ReplayManager.ReplayRecord paramReplayRecord, ObjectConsumer<GameStateSystem.ReplayValidationResult> paramObjectConsumer) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield build : I
/*     */     //   4: invokestatic isCompatibleWithBuild : (I)Z
/*     */     //   7: ifne -> 67
/*     */     //   10: getstatic com/prineside/tdi2/HeadlessReplayValidationGame.a : Lcom/prineside/tdi2/utils/logging/TLog;
/*     */     //   13: new java/lang/StringBuilder
/*     */     //   16: dup
/*     */     //   17: ldc 'Game is from build '
/*     */     //   19: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   22: aload_0
/*     */     //   23: getfield build : I
/*     */     //   26: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   29: ldc ', not compatible with 207'
/*     */     //   31: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   34: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   37: iconst_0
/*     */     //   38: anewarray java/lang/Object
/*     */     //   41: invokevirtual i : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   44: aload_1
/*     */     //   45: new com/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult
/*     */     //   48: dup
/*     */     //   49: getstatic com/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result.INVALID_RECORD : Lcom/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result;
/*     */     //   52: fconst_0
/*     */     //   53: iconst_0
/*     */     //   54: iconst_0
/*     */     //   55: iconst_0
/*     */     //   56: lconst_0
/*     */     //   57: aload_0
/*     */     //   58: invokespecial <init> : (Lcom/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result;FIIIJLcom/prineside/tdi2/managers/ReplayManager$ReplayRecord;)V
/*     */     //   61: invokeinterface accept : (Ljava/lang/Object;)V
/*     */     //   66: return
/*     */     //   67: aload_0
/*     */     //   68: invokevirtual getStateBytes : ()[B
/*     */     //   71: astore_2
/*     */     //   72: new com/esotericsoftware/kryo/io/Input
/*     */     //   75: dup
/*     */     //   76: aload_2
/*     */     //   77: invokespecial <init> : ([B)V
/*     */     //   80: dup
/*     */     //   81: astore_2
/*     */     //   82: invokestatic fromBytes : (Lcom/esotericsoftware/kryo/io/Input;)Lcom/prineside/tdi2/managers/ReplayManager$ReplayHeader;
/*     */     //   85: dup
/*     */     //   86: astore_2
/*     */     //   87: getfield difficultyMode : Lcom/prineside/tdi2/enums/DifficultyMode;
/*     */     //   90: getstatic com/prineside/tdi2/enums/DifficultyMode.NORMAL : Lcom/prineside/tdi2/enums/DifficultyMode;
/*     */     //   93: if_acmpne -> 102
/*     */     //   96: aload_2
/*     */     //   97: bipush #100
/*     */     //   99: putfield modeDifficultyMultiplier : I
/*     */     //   102: aload_2
/*     */     //   103: getfield progressSnapshot : Lcom/prineside/tdi2/managers/ProgressManager$ProgressSnapshotForState;
/*     */     //   106: invokevirtual validate : ()V
/*     */     //   109: new com/prineside/tdi2/GameSystemProvider
/*     */     //   112: dup
/*     */     //   113: new com/prineside/tdi2/GameSystemProvider$SystemsConfig
/*     */     //   116: dup
/*     */     //   117: getstatic com/prineside/tdi2/GameSystemProvider$SystemsConfig$Setup.GAME : Lcom/prineside/tdi2/GameSystemProvider$SystemsConfig$Setup;
/*     */     //   120: iconst_1
/*     */     //   121: invokespecial <init> : (Lcom/prineside/tdi2/GameSystemProvider$SystemsConfig$Setup;Z)V
/*     */     //   124: invokespecial <init> : (Lcom/prineside/tdi2/GameSystemProvider$SystemsConfig;)V
/*     */     //   127: dup
/*     */     //   128: astore_3
/*     */     //   129: invokevirtual createSystems : ()V
/*     */     //   132: aload_2
/*     */     //   133: getfield gameMode : Lcom/prineside/tdi2/systems/GameStateSystem$GameMode;
/*     */     //   136: getstatic com/prineside/tdi2/systems/GameStateSystem$GameMode.BASIC_LEVELS : Lcom/prineside/tdi2/systems/GameStateSystem$GameMode;
/*     */     //   139: if_acmpne -> 375
/*     */     //   142: getstatic com/prineside/tdi2/Game.i : Lcom/prineside/tdi2/Game;
/*     */     //   145: getfield basicLevelManager : Lcom/prineside/tdi2/managers/BasicLevelManager;
/*     */     //   148: aload_2
/*     */     //   149: getfield basicLevelName : Ljava/lang/String;
/*     */     //   152: invokevirtual getLevel : (Ljava/lang/String;)Lcom/prineside/tdi2/BasicLevel;
/*     */     //   155: dup
/*     */     //   156: astore #4
/*     */     //   158: ifnonnull -> 188
/*     */     //   161: new java/lang/IllegalArgumentException
/*     */     //   164: dup
/*     */     //   165: new java/lang/StringBuilder
/*     */     //   168: dup
/*     */     //   169: ldc 'Level not found: '
/*     */     //   171: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   174: aload_2
/*     */     //   175: getfield basicLevelName : Ljava/lang/String;
/*     */     //   178: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   181: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   184: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   187: athrow
/*     */     //   188: aload #4
/*     */     //   190: getfield hasLeaderboards : Z
/*     */     //   193: ifne -> 231
/*     */     //   196: getstatic com/prineside/tdi2/HeadlessReplayValidationGame.a : Lcom/prineside/tdi2/utils/logging/TLog;
/*     */     //   199: ldc 'headlessValidateGame - basic level doesn't have leaderboards'
/*     */     //   201: iconst_0
/*     */     //   202: anewarray java/lang/Object
/*     */     //   205: invokevirtual i : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   208: aload_1
/*     */     //   209: new com/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult
/*     */     //   212: dup
/*     */     //   213: getstatic com/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result.INVALID_RECORD : Lcom/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result;
/*     */     //   216: fconst_0
/*     */     //   217: iconst_0
/*     */     //   218: iconst_0
/*     */     //   219: iconst_0
/*     */     //   220: lconst_0
/*     */     //   221: aload_0
/*     */     //   222: invokespecial <init> : (Lcom/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result;FIIIJLcom/prineside/tdi2/managers/ReplayManager$ReplayRecord;)V
/*     */     //   225: invokeinterface accept : (Ljava/lang/Object;)V
/*     */     //   230: return
/*     */     //   231: aload #4
/*     */     //   233: getfield forcedDifficulty : Lcom/prineside/tdi2/enums/DifficultyMode;
/*     */     //   236: ifnull -> 321
/*     */     //   239: aload #4
/*     */     //   241: getfield forcedDifficulty : Lcom/prineside/tdi2/enums/DifficultyMode;
/*     */     //   244: aload_2
/*     */     //   245: getfield difficultyMode : Lcom/prineside/tdi2/enums/DifficultyMode;
/*     */     //   248: if_acmpeq -> 321
/*     */     //   251: getstatic com/prineside/tdi2/HeadlessReplayValidationGame.a : Lcom/prineside/tdi2/utils/logging/TLog;
/*     */     //   254: new java/lang/StringBuilder
/*     */     //   257: dup
/*     */     //   258: ldc 'headlessValidateGame - forced difficulty mismatch ('
/*     */     //   260: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   263: aload #4
/*     */     //   265: getfield forcedDifficulty : Lcom/prineside/tdi2/enums/DifficultyMode;
/*     */     //   268: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   271: ldc ', '
/*     */     //   273: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   276: aload_2
/*     */     //   277: getfield difficultyMode : Lcom/prineside/tdi2/enums/DifficultyMode;
/*     */     //   280: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   283: ldc ')'
/*     */     //   285: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   288: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   291: iconst_0
/*     */     //   292: anewarray java/lang/Object
/*     */     //   295: invokevirtual i : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   298: aload_1
/*     */     //   299: new com/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult
/*     */     //   302: dup
/*     */     //   303: getstatic com/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result.INVALID_RECORD : Lcom/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result;
/*     */     //   306: fconst_0
/*     */     //   307: iconst_0
/*     */     //   308: iconst_0
/*     */     //   309: iconst_0
/*     */     //   310: lconst_0
/*     */     //   311: aload_0
/*     */     //   312: invokespecial <init> : (Lcom/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result;FIIIJLcom/prineside/tdi2/managers/ReplayManager$ReplayRecord;)V
/*     */     //   315: invokeinterface accept : (Ljava/lang/Object;)V
/*     */     //   320: return
/*     */     //   321: aload_3
/*     */     //   322: aload_2
/*     */     //   323: getfield abilitiesConfiguration : Lcom/prineside/tdi2/ui/shared/AbilitySelectionOverlay$SelectedAbilitiesConfiguration;
/*     */     //   326: aload_2
/*     */     //   327: getfield canLootCases : Z
/*     */     //   330: aload_2
/*     */     //   331: getfield lootBoostEnabled : Z
/*     */     //   334: aload_2
/*     */     //   335: getfield rarityBoostEnabled : Z
/*     */     //   338: aload_2
/*     */     //   339: getfield gameStartTs : J
/*     */     //   342: aload #4
/*     */     //   344: aconst_null
/*     */     //   345: aload_2
/*     */     //   346: getfield difficultyMode : Lcom/prineside/tdi2/enums/DifficultyMode;
/*     */     //   349: aload_2
/*     */     //   350: getfield modeDifficultyMultiplier : I
/*     */     //   353: getstatic com/prineside/tdi2/systems/GameStateSystem$GameMode.BASIC_LEVELS : Lcom/prineside/tdi2/systems/GameStateSystem$GameMode;
/*     */     //   356: aconst_null
/*     */     //   357: aload_2
/*     */     //   358: getfield progressSnapshot : Lcom/prineside/tdi2/managers/ProgressManager$ProgressSnapshotForState;
/*     */     //   361: aload_2
/*     */     //   362: getfield inventoryStatistics : Lcom/prineside/tdi2/managers/ProgressManager$InventoryStatistics;
/*     */     //   365: aload_2
/*     */     //   366: getfield dailyQuestLevel : Lcom/prineside/tdi2/managers/DailyQuestManager$DailyQuestLevel;
/*     */     //   369: invokestatic configureSystemsBeforeSetup : (Lcom/prineside/tdi2/GameSystemProvider;Lcom/prineside/tdi2/ui/shared/AbilitySelectionOverlay$SelectedAbilitiesConfiguration;ZZZJLcom/prineside/tdi2/BasicLevel;Lcom/prineside/tdi2/UserMap;Lcom/prineside/tdi2/enums/DifficultyMode;ILcom/prineside/tdi2/systems/GameStateSystem$GameMode;[Lcom/prineside/tdi2/enums/BossType;Lcom/prineside/tdi2/managers/ProgressManager$ProgressSnapshotForState;Lcom/prineside/tdi2/managers/ProgressManager$InventoryStatistics;Lcom/prineside/tdi2/managers/DailyQuestManager$DailyQuestLevel;)V
/*     */     //   372: goto -> 395
/*     */     //   375: aload_2
/*     */     //   376: getfield gameMode : Lcom/prineside/tdi2/systems/GameStateSystem$GameMode;
/*     */     //   379: getstatic com/prineside/tdi2/systems/GameStateSystem$GameMode.USER_MAPS : Lcom/prineside/tdi2/systems/GameStateSystem$GameMode;
/*     */     //   382: if_acmpne -> 395
/*     */     //   385: new java/lang/IllegalArgumentException
/*     */     //   388: dup
/*     */     //   389: ldc 'User map validation not supported'
/*     */     //   391: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   394: athrow
/*     */     //   395: aload_3
/*     */     //   396: invokevirtual setupSystems : ()V
/*     */     //   399: aload_3
/*     */     //   400: invokevirtual postSetupSystems : ()V
/*     */     //   403: aload_3
/*     */     //   404: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*     */     //   407: dup
/*     */     //   408: astore #4
/*     */     //   410: getfield difficultyMode : Lcom/prineside/tdi2/enums/DifficultyMode;
/*     */     //   413: aload_2
/*     */     //   414: getfield modeDifficultyMultiplier : I
/*     */     //   417: aload #4
/*     */     //   419: getfield basicLevelName : Ljava/lang/String;
/*     */     //   422: ifnonnull -> 429
/*     */     //   425: aconst_null
/*     */     //   426: goto -> 443
/*     */     //   429: getstatic com/prineside/tdi2/Game.i : Lcom/prineside/tdi2/Game;
/*     */     //   432: getfield basicLevelManager : Lcom/prineside/tdi2/managers/BasicLevelManager;
/*     */     //   435: aload #4
/*     */     //   437: getfield basicLevelName : Ljava/lang/String;
/*     */     //   440: invokevirtual getLevel : (Ljava/lang/String;)Lcom/prineside/tdi2/BasicLevel;
/*     */     //   443: aload_3
/*     */     //   444: getfield map : Lcom/prineside/tdi2/systems/MapSystem;
/*     */     //   447: invokevirtual getMap : ()Lcom/prineside/tdi2/Map;
/*     */     //   450: invokevirtual getTargetTileOrThrow : ()Lcom/prineside/tdi2/tiles/TargetTile;
/*     */     //   453: invokevirtual isUseStockGameValues : ()Z
/*     */     //   456: aload_3
/*     */     //   457: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*     */     //   460: getfield userMapId : Ljava/lang/String;
/*     */     //   463: ifnull -> 470
/*     */     //   466: iconst_1
/*     */     //   467: goto -> 471
/*     */     //   470: iconst_0
/*     */     //   471: aload_2
/*     */     //   472: getfield progressSnapshot : Lcom/prineside/tdi2/managers/ProgressManager$ProgressSnapshotForState;
/*     */     //   475: invokestatic clampModeDifficulty : (Lcom/prineside/tdi2/enums/DifficultyMode;ILcom/prineside/tdi2/BasicLevel;ZZLcom/prineside/tdi2/managers/ProgressManager$ProgressSnapshotForState;)I
/*     */     //   478: dup
/*     */     //   479: istore #5
/*     */     //   481: aload_2
/*     */     //   482: getfield modeDifficultyMultiplier : I
/*     */     //   485: if_icmpeq -> 550
/*     */     //   488: getstatic com/prineside/tdi2/HeadlessReplayValidationGame.a : Lcom/prineside/tdi2/utils/logging/TLog;
/*     */     //   491: new java/lang/StringBuilder
/*     */     //   494: dup
/*     */     //   495: ldc 'headlessValidateGame - mode difficulty incorrect: '
/*     */     //   497: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   500: aload_2
/*     */     //   501: getfield modeDifficultyMultiplier : I
/*     */     //   504: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   507: ldc ' should be '
/*     */     //   509: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   512: iload #5
/*     */     //   514: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   517: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   520: iconst_0
/*     */     //   521: anewarray java/lang/Object
/*     */     //   524: invokevirtual i : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   527: aload_1
/*     */     //   528: new com/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult
/*     */     //   531: dup
/*     */     //   532: getstatic com/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result.INVALID_RECORD : Lcom/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result;
/*     */     //   535: fconst_0
/*     */     //   536: iconst_0
/*     */     //   537: iconst_0
/*     */     //   538: iconst_0
/*     */     //   539: lconst_0
/*     */     //   540: aload_0
/*     */     //   541: invokespecial <init> : (Lcom/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result;FIIIJLcom/prineside/tdi2/managers/ReplayManager$ReplayRecord;)V
/*     */     //   544: invokeinterface accept : (Ljava/lang/Object;)V
/*     */     //   549: return
/*     */     //   550: getstatic com/prineside/tdi2/Game.i : Lcom/prineside/tdi2/Game;
/*     */     //   553: getfield researchManager : Lcom/prineside/tdi2/managers/ResearchManager;
/*     */     //   556: invokevirtual getUnusedStarsCount : ()I
/*     */     //   559: ifge -> 619
/*     */     //   562: getstatic com/prineside/tdi2/HeadlessReplayValidationGame.a : Lcom/prineside/tdi2/utils/logging/TLog;
/*     */     //   565: new java/lang/StringBuilder
/*     */     //   568: dup
/*     */     //   569: ldc 'headlessValidateGame - unused research stars '
/*     */     //   571: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   574: getstatic com/prineside/tdi2/Game.i : Lcom/prineside/tdi2/Game;
/*     */     //   577: getfield researchManager : Lcom/prineside/tdi2/managers/ResearchManager;
/*     */     //   580: invokevirtual getUnusedStarsCount : ()I
/*     */     //   583: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   586: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   589: iconst_0
/*     */     //   590: anewarray java/lang/Object
/*     */     //   593: invokevirtual i : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   596: aload_1
/*     */     //   597: new com/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult
/*     */     //   600: dup
/*     */     //   601: getstatic com/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result.INVALID_RECORD : Lcom/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result;
/*     */     //   604: fconst_0
/*     */     //   605: iconst_0
/*     */     //   606: iconst_0
/*     */     //   607: iconst_0
/*     */     //   608: lconst_0
/*     */     //   609: aload_0
/*     */     //   610: invokespecial <init> : (Lcom/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result;FIIIJLcom/prineside/tdi2/managers/ReplayManager$ReplayRecord;)V
/*     */     //   613: invokeinterface accept : (Ljava/lang/Object;)V
/*     */     //   618: return
/*     */     //   619: aload #4
/*     */     //   621: invokevirtual getSeed : ()J
/*     */     //   624: aload_2
/*     */     //   625: getfield seed : J
/*     */     //   628: lcmp
/*     */     //   629: ifeq -> 697
/*     */     //   632: getstatic com/prineside/tdi2/HeadlessReplayValidationGame.a : Lcom/prineside/tdi2/utils/logging/TLog;
/*     */     //   635: new java/lang/StringBuilder
/*     */     //   638: dup
/*     */     //   639: ldc 'headlessValidateGame - seeds don't match: '
/*     */     //   641: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   644: aload #4
/*     */     //   646: invokevirtual getSeed : ()J
/*     */     //   649: invokevirtual append : (J)Ljava/lang/StringBuilder;
/*     */     //   652: ldc ' '
/*     */     //   654: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   657: aload_2
/*     */     //   658: getfield seed : J
/*     */     //   661: invokevirtual append : (J)Ljava/lang/StringBuilder;
/*     */     //   664: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   667: iconst_0
/*     */     //   668: anewarray java/lang/Object
/*     */     //   671: invokevirtual i : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   674: aload_1
/*     */     //   675: new com/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult
/*     */     //   678: dup
/*     */     //   679: getstatic com/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result.INVALID_RECORD : Lcom/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result;
/*     */     //   682: fconst_0
/*     */     //   683: iconst_0
/*     */     //   684: iconst_0
/*     */     //   685: iconst_0
/*     */     //   686: lconst_0
/*     */     //   687: aload_0
/*     */     //   688: invokespecial <init> : (Lcom/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result;FIIIJLcom/prineside/tdi2/managers/ReplayManager$ReplayRecord;)V
/*     */     //   691: invokeinterface accept : (Ljava/lang/Object;)V
/*     */     //   696: return
/*     */     //   697: aload #4
/*     */     //   699: aload_2
/*     */     //   700: getfield playRealTime : F
/*     */     //   703: putfield playRealTime : F
/*     */     //   706: aload #4
/*     */     //   708: aload_0
/*     */     //   709: putfield headlessValidatedReplayRecord : Lcom/prineside/tdi2/managers/ReplayManager$ReplayRecord;
/*     */     //   712: aload #4
/*     */     //   714: invokestatic getTimestampMillis : ()J
/*     */     //   717: putfield validationStartTimestamp : J
/*     */     //   720: aload #4
/*     */     //   722: aload_2
/*     */     //   723: getfield updateNumber : J
/*     */     //   726: l2i
/*     */     //   727: putfield validationLastUpdateNumber : I
/*     */     //   730: iconst_0
/*     */     //   731: istore #5
/*     */     //   733: iload #5
/*     */     //   735: aload_2
/*     */     //   736: getfield actionsCount : I
/*     */     //   739: if_icmpge -> 777
/*     */     //   742: aload_2
/*     */     //   743: getfield actions : Lcom/badlogic/gdx/utils/Array;
/*     */     //   746: iload #5
/*     */     //   748: invokevirtual get : (I)Ljava/lang/Object;
/*     */     //   751: checkcast com/prineside/tdi2/systems/StateSystem$ActionUpdatePair
/*     */     //   754: astore #6
/*     */     //   756: aload #4
/*     */     //   758: aload #6
/*     */     //   760: getfield action : Lcom/prineside/tdi2/Action;
/*     */     //   763: aload #6
/*     */     //   765: getfield update : I
/*     */     //   768: invokevirtual pushAction : (Lcom/prineside/tdi2/Action;I)V
/*     */     //   771: iinc #5, 1
/*     */     //   774: goto -> 733
/*     */     //   777: getstatic com/prineside/tdi2/HeadlessReplayValidationGame.a : Lcom/prineside/tdi2/utils/logging/TLog;
/*     */     //   780: new java/lang/StringBuilder
/*     */     //   783: dup
/*     */     //   784: ldc 'replay is '
/*     */     //   786: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   789: aload_2
/*     */     //   790: getfield updateNumber : J
/*     */     //   793: invokevirtual append : (J)Ljava/lang/StringBuilder;
/*     */     //   796: ldc ' frames long, '
/*     */     //   798: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   801: aload_0
/*     */     //   802: getfield defeatedWaves : I
/*     */     //   805: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   808: ldc ' waves and '
/*     */     //   810: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   813: aload_0
/*     */     //   814: getfield score : J
/*     */     //   817: invokevirtual append : (J)Ljava/lang/StringBuilder;
/*     */     //   820: ldc ' score'
/*     */     //   822: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   825: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   828: iconst_0
/*     */     //   829: anewarray java/lang/Object
/*     */     //   832: invokevirtual i : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   835: aload_3
/*     */     //   836: invokestatic start : (Lcom/prineside/tdi2/GameSystemProvider;)V
/*     */     //   839: aload_3
/*     */     //   840: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*     */     //   843: invokevirtual isGameOver : ()Z
/*     */     //   846: ifne -> 872
/*     */     //   849: aload_3
/*     */     //   850: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*     */     //   853: getfield updateNumber : I
/*     */     //   856: i2l
/*     */     //   857: aload_2
/*     */     //   858: getfield updateNumber : J
/*     */     //   861: lcmp
/*     */     //   862: ifge -> 872
/*     */     //   865: aload_3
/*     */     //   866: invokevirtual updateSystems : ()V
/*     */     //   869: goto -> 839
/*     */     //   872: getstatic com/prineside/tdi2/HeadlessReplayValidationGame.a : Lcom/prineside/tdi2/utils/logging/TLog;
/*     */     //   875: ldc 'finished successfully'
/*     */     //   877: iconst_0
/*     */     //   878: anewarray java/lang/Object
/*     */     //   881: invokevirtual i : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   884: invokestatic getTimestampMillis : ()J
/*     */     //   887: aload_3
/*     */     //   888: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*     */     //   891: getfield validationStartTimestamp : J
/*     */     //   894: lsub
/*     */     //   895: l2f
/*     */     //   896: ldc 0.001
/*     */     //   898: fmul
/*     */     //   899: fstore #5
/*     */     //   901: aload_3
/*     */     //   902: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*     */     //   905: getfield updateNumber : I
/*     */     //   908: i2f
/*     */     //   909: fload #5
/*     */     //   911: fdiv
/*     */     //   912: f2i
/*     */     //   913: istore #6
/*     */     //   915: aload_3
/*     */     //   916: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*     */     //   919: invokevirtual isMaxEndlessReplayTimeReached : ()Z
/*     */     //   922: ifeq -> 940
/*     */     //   925: getstatic com/prineside/tdi2/HeadlessReplayValidationGame.a : Lcom/prineside/tdi2/utils/logging/TLog;
/*     */     //   928: ldc 'max duration of endless replay reached'
/*     */     //   930: iconst_0
/*     */     //   931: anewarray java/lang/Object
/*     */     //   934: invokevirtual i : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   937: goto -> 1012
/*     */     //   940: aload_3
/*     */     //   941: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*     */     //   944: getfield headlessValidatedReplayRecord : Lcom/prineside/tdi2/managers/ReplayManager$ReplayRecord;
/*     */     //   947: getfield defeatedWaves : I
/*     */     //   950: aload_3
/*     */     //   951: getfield wave : Lcom/prineside/tdi2/systems/WaveSystem;
/*     */     //   954: invokevirtual getCompletedWavesCount : ()I
/*     */     //   957: if_icmpeq -> 967
/*     */     //   960: getstatic com/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result.INVALID : Lcom/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result;
/*     */     //   963: astore_2
/*     */     //   964: goto -> 1016
/*     */     //   967: aload_3
/*     */     //   968: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*     */     //   971: getfield headlessValidatedReplayRecord : Lcom/prineside/tdi2/managers/ReplayManager$ReplayRecord;
/*     */     //   974: getfield score : J
/*     */     //   977: aload_3
/*     */     //   978: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*     */     //   981: invokevirtual getScore : ()J
/*     */     //   984: lcmp
/*     */     //   985: ifeq -> 995
/*     */     //   988: getstatic com/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result.INVALID : Lcom/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result;
/*     */     //   991: astore_2
/*     */     //   992: goto -> 1016
/*     */     //   995: aload_3
/*     */     //   996: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*     */     //   999: getfield validationFingerprintMismatchPrinted : Z
/*     */     //   1002: ifeq -> 1012
/*     */     //   1005: getstatic com/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result.INVALID : Lcom/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result;
/*     */     //   1008: astore_2
/*     */     //   1009: goto -> 1016
/*     */     //   1012: getstatic com/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result.VALID : Lcom/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result;
/*     */     //   1015: astore_2
/*     */     //   1016: new com/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult
/*     */     //   1019: dup
/*     */     //   1020: aload_2
/*     */     //   1021: fload #5
/*     */     //   1023: iload #6
/*     */     //   1025: aload_3
/*     */     //   1026: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*     */     //   1029: getfield updateNumber : I
/*     */     //   1032: aload_3
/*     */     //   1033: getfield wave : Lcom/prineside/tdi2/systems/WaveSystem;
/*     */     //   1036: invokevirtual getCompletedWavesCount : ()I
/*     */     //   1039: aload_3
/*     */     //   1040: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*     */     //   1043: invokevirtual getScore : ()J
/*     */     //   1046: aload_3
/*     */     //   1047: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*     */     //   1050: getfield headlessValidatedReplayRecord : Lcom/prineside/tdi2/managers/ReplayManager$ReplayRecord;
/*     */     //   1053: invokespecial <init> : (Lcom/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result;FIIIJLcom/prineside/tdi2/managers/ReplayManager$ReplayRecord;)V
/*     */     //   1056: dup
/*     */     //   1057: astore_2
/*     */     //   1058: aload_3
/*     */     //   1059: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*     */     //   1062: getfield pxpExperience : I
/*     */     //   1065: putfield xp : I
/*     */     //   1068: aload_2
/*     */     //   1069: aload_3
/*     */     //   1070: getfield statistics : Lcom/prineside/tdi2/systems/StatisticsSystem;
/*     */     //   1073: getstatic com/prineside/tdi2/enums/StatisticsType.EK : Lcom/prineside/tdi2/enums/StatisticsType;
/*     */     //   1076: invokevirtual getStatistic : (Lcom/prineside/tdi2/enums/StatisticsType;)D
/*     */     //   1079: d2i
/*     */     //   1080: putfield enemiesKilled : I
/*     */     //   1083: aload_2
/*     */     //   1084: aload_3
/*     */     //   1085: getfield statistics : Lcom/prineside/tdi2/systems/StatisticsSystem;
/*     */     //   1088: getstatic com/prineside/tdi2/enums/StatisticsType.RG : Lcom/prineside/tdi2/enums/StatisticsType;
/*     */     //   1091: invokevirtual getStatistic : (Lcom/prineside/tdi2/enums/StatisticsType;)D
/*     */     //   1094: d2i
/*     */     //   1095: putfield resourcesMined : I
/*     */     //   1098: aload_2
/*     */     //   1099: aload_3
/*     */     //   1100: putfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*     */     //   1103: aload_1
/*     */     //   1104: aload_2
/*     */     //   1105: invokeinterface accept : (Ljava/lang/Object;)V
/*     */     //   1110: goto -> 1243
/*     */     //   1113: astore #5
/*     */     //   1115: getstatic com/prineside/tdi2/HeadlessReplayValidationGame.a : Lcom/prineside/tdi2/utils/logging/TLog;
/*     */     //   1118: ldc 'headlessValidateGame - simulation failed'
/*     */     //   1120: iconst_1
/*     */     //   1121: anewarray java/lang/Object
/*     */     //   1124: dup
/*     */     //   1125: iconst_0
/*     */     //   1126: aload #5
/*     */     //   1128: aastore
/*     */     //   1129: invokevirtual i : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   1132: invokestatic getTimestampMillis : ()J
/*     */     //   1135: aload_3
/*     */     //   1136: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*     */     //   1139: getfield validationStartTimestamp : J
/*     */     //   1142: lsub
/*     */     //   1143: l2f
/*     */     //   1144: ldc 0.001
/*     */     //   1146: fmul
/*     */     //   1147: fstore #6
/*     */     //   1149: aload_3
/*     */     //   1150: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*     */     //   1153: getfield updateNumber : I
/*     */     //   1156: i2f
/*     */     //   1157: fload #6
/*     */     //   1159: fdiv
/*     */     //   1160: f2i
/*     */     //   1161: istore_2
/*     */     //   1162: aload_1
/*     */     //   1163: new com/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult
/*     */     //   1166: dup
/*     */     //   1167: getstatic com/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result.INVALID_RECORD : Lcom/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result;
/*     */     //   1170: fload #6
/*     */     //   1172: iload_2
/*     */     //   1173: aload_3
/*     */     //   1174: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*     */     //   1177: getfield updateNumber : I
/*     */     //   1180: aload_3
/*     */     //   1181: getfield wave : Lcom/prineside/tdi2/systems/WaveSystem;
/*     */     //   1184: invokevirtual getCompletedWavesCount : ()I
/*     */     //   1187: aload_3
/*     */     //   1188: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*     */     //   1191: invokevirtual getScore : ()J
/*     */     //   1194: aload_0
/*     */     //   1195: invokespecial <init> : (Lcom/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result;FIIIJLcom/prineside/tdi2/managers/ReplayManager$ReplayRecord;)V
/*     */     //   1198: invokeinterface accept : (Ljava/lang/Object;)V
/*     */     //   1203: return
/*     */     //   1204: astore_2
/*     */     //   1205: getstatic com/prineside/tdi2/HeadlessReplayValidationGame.a : Lcom/prineside/tdi2/utils/logging/TLog;
/*     */     //   1208: ldc 'headlessValidateGame - parsing failed'
/*     */     //   1210: iconst_1
/*     */     //   1211: anewarray java/lang/Object
/*     */     //   1214: dup
/*     */     //   1215: iconst_0
/*     */     //   1216: aload_2
/*     */     //   1217: aastore
/*     */     //   1218: invokevirtual i : (Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   1221: aload_1
/*     */     //   1222: new com/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult
/*     */     //   1225: dup
/*     */     //   1226: getstatic com/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result.INVALID_RECORD : Lcom/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result;
/*     */     //   1229: fconst_0
/*     */     //   1230: iconst_0
/*     */     //   1231: iconst_0
/*     */     //   1232: iconst_0
/*     */     //   1233: lconst_0
/*     */     //   1234: aload_0
/*     */     //   1235: invokespecial <init> : (Lcom/prineside/tdi2/systems/GameStateSystem$ReplayValidationResult$Result;FIIIJLcom/prineside/tdi2/managers/ReplayManager$ReplayRecord;)V
/*     */     //   1238: invokeinterface accept : (Ljava/lang/Object;)V
/*     */     //   1243: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #279	-> 0
/*     */     //   #280	-> 10
/*     */     //   #281	-> 44
/*     */     //   #282	-> 66
/*     */     //   #286	-> 67
/*     */     //   #287	-> 72
/*     */     //   #288	-> 81
/*     */     //   #291	-> 86
/*     */     //   #292	-> 96
/*     */     //   #294	-> 102
/*     */     //   #296	-> 109
/*     */     //   #300	-> 128
/*     */     //   #302	-> 132
/*     */     //   #303	-> 142
/*     */     //   #304	-> 156
/*     */     //   #305	-> 161
/*     */     //   #308	-> 188
/*     */     //   #309	-> 196
/*     */     //   #310	-> 208
/*     */     //   #311	-> 230
/*     */     //   #314	-> 231
/*     */     //   #315	-> 251
/*     */     //   #316	-> 298
/*     */     //   #317	-> 320
/*     */     //   #320	-> 321
/*     */     //   #337	-> 372
/*     */     //   #338	-> 385
/*     */     //   #341	-> 395
/*     */     //   #342	-> 399
/*     */     //   #344	-> 403
/*     */     //   #347	-> 408
/*     */     //   #350	-> 417
/*     */     //   #351	-> 447
/*     */     //   #347	-> 475
/*     */     //   #355	-> 479
/*     */     //   #356	-> 488
/*     */     //   #357	-> 527
/*     */     //   #359	-> 549
/*     */     //   #363	-> 550
/*     */     //   #364	-> 562
/*     */     //   #365	-> 596
/*     */     //   #367	-> 618
/*     */     //   #371	-> 619
/*     */     //   #372	-> 632
/*     */     //   #373	-> 674
/*     */     //   #374	-> 696
/*     */     //   #376	-> 697
/*     */     //   #377	-> 706
/*     */     //   #378	-> 712
/*     */     //   #380	-> 720
/*     */     //   #382	-> 730
/*     */     //   #383	-> 742
/*     */     //   #384	-> 756
/*     */     //   #382	-> 771
/*     */     //   #387	-> 777
/*     */     //   #390	-> 835
/*     */     //   #395	-> 839
/*     */     //   #396	-> 865
/*     */     //   #398	-> 872
/*     */     //   #400	-> 884
/*     */     //   #401	-> 901
/*     */     //   #404	-> 915
/*     */     //   #406	-> 925
/*     */     //   #407	-> 937
/*     */     //   #409	-> 940
/*     */     //   #410	-> 960
/*     */     //   #411	-> 967
/*     */     //   #412	-> 988
/*     */     //   #413	-> 995
/*     */     //   #415	-> 1005
/*     */     //   #417	-> 1012
/*     */     //   #421	-> 1016
/*     */     //   #422	-> 1036
/*     */     //   #424	-> 1057
/*     */     //   #425	-> 1068
/*     */     //   #426	-> 1083
/*     */     //   #427	-> 1098
/*     */     //   #428	-> 1103
/*     */     //   #434	-> 1110
/*     */     //   #429	-> 1113
/*     */     //   #430	-> 1115
/*     */     //   #431	-> 1132
/*     */     //   #432	-> 1149
/*     */     //   #433	-> 1162
/*     */     //   #438	-> 1203
/*     */     //   #435	-> 1204
/*     */     //   #436	-> 1205
/*     */     //   #437	-> 1221
/*     */     //   #439	-> 1243
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   67	230	1204	java/lang/Exception
/*     */     //   231	320	1204	java/lang/Exception
/*     */     //   321	549	1204	java/lang/Exception
/*     */     //   550	618	1204	java/lang/Exception
/*     */     //   619	696	1204	java/lang/Exception
/*     */     //   697	1203	1204	java/lang/Exception
/*     */     //   839	1110	1113	java/lang/Exception
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\HeadlessReplayValidationGame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */