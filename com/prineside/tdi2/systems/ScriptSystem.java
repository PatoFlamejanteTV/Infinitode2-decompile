/*     */ package com.prineside.tdi2.systems;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Action;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.actions.ScriptAction;
/*     */ import com.prineside.tdi2.enums.ActionType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.managers.script.ScriptEnvironment;
/*     */ import com.prineside.tdi2.tiles.ScriptTile;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS
/*     */ public final class ScriptSystem extends GameSystem {
/*     */   static {
/*  28 */     TLog.forClass(ScriptSystem.class);
/*     */   }
/*  30 */   public static DeepClassComparator<ScriptSystem> CLASS_COMPARATOR = new DeepClassComparator<ScriptSystem>() {
/*     */       public Class<ScriptSystem> forClass() {
/*  32 */         return ScriptSystem.class;
/*     */       }
/*     */       
/*     */       public void compare(ScriptSystem param1ScriptSystem1, ScriptSystem param1ScriptSystem2, DeepClassComparisonConfig param1DeepClassComparisonConfig) {
/*  36 */         param1DeepClassComparisonConfig.addPrefix(new String[] { ".scriptEnvironment" });
/*  37 */         SyncChecker.compareObjects(param1ScriptSystem1.scriptEnvironment, param1ScriptSystem2.scriptEnvironment, param1DeepClassComparisonConfig);
/*  38 */         param1DeepClassComparisonConfig.popPrefix(1);
/*     */       }
/*     */     };
/*     */   static {
/*  42 */     SyncChecker.CLASS_COMPARATORS.add(CLASS_COMPARATOR);
/*     */   }
/*     */   @NAGS
/*     */   @Null
/*     */   public ScriptEnvironment scriptEnvironment;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  49 */     super.write(paramKryo, paramOutput);
/*  50 */     paramKryo.writeObjectOrNull(paramOutput, this.scriptEnvironment, ScriptEnvironment.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  55 */     super.read(paramKryo, paramInput);
/*  56 */     this.scriptEnvironment = (ScriptEnvironment)paramKryo.readObjectOrNull(paramInput, ScriptEnvironment.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/*  61 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setup() {
/*  68 */     this.scriptEnvironment = new ScriptEnvironment();
/*  69 */     this.scriptEnvironment.initialize();
/*     */ 
/*     */     
/*  72 */     this.scriptEnvironment.getGlobals().set("S", CoerceJavaToLua.coerce(this.S));
/*     */     
/*  74 */     if (this.S.CFG.setup == GameSystemProvider.SystemsConfig.Setup.MAP_EDITOR) {
/*  75 */       this.scriptEnvironment.loadScriptsInDir("scripts/map-editor"); return;
/*     */     } 
/*  77 */     this.scriptEnvironment.loadScriptsInDir("scripts/game");
/*     */ 
/*     */     
/*  80 */     DelayedRemovalArray delayedRemovalArray = this.S.map.getMap().getAllTiles();
/*  81 */     for (byte b = 0; b < ((Array)delayedRemovalArray).size; b++) {
/*     */       Tile tile;
/*  83 */       if ((tile = ((Tile[])(this.S.map.getMap().getAllTiles()).items)[b]).type == TileType.SCRIPT) {
/*  84 */         ScriptTile scriptTile = (ScriptTile)tile;
/*  85 */         this.S.script.scriptEnvironment.executeLua(scriptTile.getScript(), "ScriptTile[" + scriptTile.getX() + ":" + scriptTile.getY() + "]");
/*     */       } 
/*     */     } 
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
/*     */   public final void runScriptAction(String paramString) {
/* 101 */     if (this.S.gameState == null) throw new IllegalStateException("GameStateSystem is not registered");
/*     */     
/* 103 */     if (this.S.gameState.replayMode) {
/*     */       
/* 105 */       this.scriptEnvironment.executeLua(paramString, "scriptAction"); return;
/*     */     } 
/* 107 */     this.S.gameState.pushActionNextUpdate((Action)new ScriptAction(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 113 */     if (this.scriptEnvironment == null)
/*     */       return; 
/* 115 */     if (this.S.gameState != null && !Config.isHeadless()) {
/*     */       StateSystem.ActionsArray actionsArray;
/*     */       
/* 118 */       if ((actionsArray = this.S.gameState.getCurrentUpdateActions()) != null) {
/* 119 */         for (byte b = 0; b < actionsArray.size; b++) {
/*     */           Action action;
/* 121 */           if ((action = actionsArray.actions[b]).getType() == ActionType.S) {
/* 122 */             if (Config.isHeadless()) {
/* 123 */               throw new IllegalStateException("Run script actions are not allowed in headless mode");
/*     */             }
/*     */             
/* 126 */             this.scriptEnvironment.executeLua(((ScriptAction)action).script, "scriptAction");
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getSystemName() {
/* 135 */     return "Script";
/*     */   }
/*     */ 
/*     */   
/*     */   public final void dispose() {
/* 140 */     if (this.scriptEnvironment == null)
/*     */       return; 
/* 142 */     this.scriptEnvironment.dispose();
/*     */     
/* 144 */     this.scriptEnvironment = null;
/*     */     
/* 146 */     super.dispose();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\ScriptSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */