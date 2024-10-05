/*     */ package com.prineside.tdi2.systems;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Action;
/*     */ import com.prineside.tdi2.Building;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Modifier;
/*     */ import com.prineside.tdi2.ModifierProcessor;
/*     */ import com.prineside.tdi2.SerializableListener;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.actions.BuildModifierAction;
/*     */ import com.prineside.tdi2.actions.CustomModifierButtonAction;
/*     */ import com.prineside.tdi2.actions.SellModifierAction;
/*     */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*     */ import com.prineside.tdi2.enums.ActionType;
/*     */ import com.prineside.tdi2.enums.BuildingType;
/*     */ import com.prineside.tdi2.enums.ModifierType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.BuildingRemove;
/*     */ import com.prineside.tdi2.events.game.ModifierCustomButtonPress;
/*     */ import com.prineside.tdi2.events.game.ModifierPlace;
/*     */ import com.prineside.tdi2.events.game.ModifierSell;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS
/*     */ public final class ModifierSystem extends GameSystem {
/*  38 */   private static final TLog a = TLog.forClass(ModifierSystem.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   public DelayedRemovalArray<Modifier> modifiers = new DelayedRemovalArray(false, 8, Modifier.class);
/*  44 */   public int[] modifiersBuiltByType = new int[ModifierType.values.length];
/*  45 */   public int[] modifiersBuiltByTypeAllTime = new int[ModifierType.values.length];
/*  46 */   public int[] modifiersSoldByTypeAllTime = new int[ModifierType.values.length];
/*  47 */   private int b = 1;
/*  48 */   private int[] c = new int[ModifierType.values.length];
/*     */   
/*  50 */   private ModifierProcessor[] d = new ModifierProcessor[ModifierType.values.length];
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  54 */     super.write(paramKryo, paramOutput);
/*  55 */     paramKryo.writeObject(paramOutput, this.modifiers);
/*  56 */     paramKryo.writeObject(paramOutput, this.modifiersBuiltByType);
/*  57 */     paramKryo.writeObject(paramOutput, this.modifiersBuiltByTypeAllTime);
/*  58 */     paramKryo.writeObject(paramOutput, this.modifiersSoldByTypeAllTime);
/*  59 */     paramOutput.writeVarInt(this.b, true);
/*  60 */     paramKryo.writeObject(paramOutput, this.c);
/*  61 */     paramKryo.writeObject(paramOutput, this.d);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  66 */     super.read(paramKryo, paramInput);
/*  67 */     this.modifiers = (DelayedRemovalArray<Modifier>)paramKryo.readObject(paramInput, DelayedRemovalArray.class);
/*  68 */     this.modifiersBuiltByType = (int[])paramKryo.readObject(paramInput, int[].class);
/*  69 */     this.modifiersBuiltByTypeAllTime = (int[])paramKryo.readObject(paramInput, int[].class);
/*  70 */     this.modifiersSoldByTypeAllTime = (int[])paramKryo.readObject(paramInput, int[].class);
/*  71 */     this.b = paramInput.readVarInt(true);
/*  72 */     this.c = (int[])paramKryo.readObject(paramInput, int[].class);
/*  73 */     this.d = (ModifierProcessor[])paramKryo.readObject(paramInput, ModifierProcessor[].class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/*  78 */     return true;
/*     */   } public final void setup() {
/*     */     ModifierType[] arrayOfModifierType;
/*     */     int i;
/*     */     byte b;
/*  83 */     for (i = (arrayOfModifierType = ModifierType.values).length, b = 0; b < i; ) { ModifierType modifierType = arrayOfModifierType[b];
/*  84 */       this.d[modifierType.ordinal()] = Game.i.modifierManager.getFactory(modifierType).createProcessor(); b++; }
/*     */     
/*     */     ModifierProcessor[] arrayOfModifierProcessor;
/*  87 */     for (i = (arrayOfModifierProcessor = this.d).length, b = 0; b < i; b++) {
/*  88 */       ModifierProcessor modifierProcessor; if ((modifierProcessor = arrayOfModifierProcessor[b]) != null) {
/*  89 */         modifierProcessor.setRegistered(this.S);
/*     */       }
/*     */     } 
/*  92 */     this.S.events.getListeners(ModifierPlace.class).addStateAffecting(new OnModifierPlace(this));
/*  93 */     this.S.events.getListeners(BuildingRemove.class).addStateAffecting(new OnBuildingRemove(this));
/*  94 */     if (!this.S.CFG.headless) a();
/*     */   
/*     */   }
/*     */   
/*     */   public final void postStateRestore() {
/*  99 */     a();
/*     */   }
/*     */   
/*     */   private void a() {
/* 103 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.MODIFIER_DRAW_BATCH, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> drawBatch(paramBatch, this.S.map.getMap(), paramFloat2, this.S._mapRendering.getDrawMode())))
/*     */ 
/*     */         
/* 106 */         .setName("Modifier-drawBatch"));
/*     */     
/* 108 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.MODIFIER_DRAW_BATCH_ADDITIVE, true, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> drawBatchAdditive(paramBatch, this.S.map.getMap(), paramFloat2, this.S._mapRendering.getDrawMode())))
/*     */ 
/*     */         
/* 111 */         .setName("Modifier-drawBatchAdditive"));
/*     */   }
/*     */   
/*     */   public final ModifierProcessor getProcessor(ModifierType paramModifierType) {
/* 115 */     return this.d[paramModifierType.ordinal()];
/*     */   }
/*     */   
/*     */   public final boolean isRegistered(Modifier paramModifier) {
/* 119 */     return paramModifier.isRegistered();
/*     */   }
/*     */   
/*     */   private void a(Modifier paramModifier) {
/* 123 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 125 */     if (paramModifier.isRegistered()) throw new IllegalArgumentException("Modifier is already registered");
/*     */     
/* 127 */     this.c[paramModifier.type.ordinal()] = this.c[paramModifier.type.ordinal()] + 1;
/* 128 */     paramModifier.id = this.b++;
/* 129 */     paramModifier.setRegistered(this.S);
/* 130 */     this.modifiers.add(paramModifier);
/*     */   }
/*     */   
/*     */   private void b(Modifier paramModifier) {
/* 134 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 136 */     if (!paramModifier.isRegistered()) throw new IllegalArgumentException("Modifier is not registered");
/*     */     
/* 138 */     this.c[paramModifier.type.ordinal()] = this.c[paramModifier.type.ordinal()] - 1;
/* 139 */     paramModifier.setUnregistered();
/* 140 */     this.modifiers.removeValue(paramModifier, true);
/*     */   }
/*     */   
/*     */   public final int getBuildPrice(ModifierType paramModifierType) {
/* 144 */     return Game.i.modifierManager.getFactory(paramModifierType).getBuildPrice(this.S, a(paramModifierType));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getMaxModifiersCount(ModifierType paramModifierType) {
/* 151 */     return this.S.gameValue.getIntValue(Game.i.modifierManager.getCountGameValue(paramModifierType));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int a(ModifierType paramModifierType) {
/* 158 */     return this.c[paramModifierType.ordinal()];
/*     */   }
/*     */   
/*     */   public final int getBuildableModifiersCount(ModifierType paramModifierType) {
/* 162 */     return Math.max(0, getMaxModifiersCount(paramModifierType) - this.c[paramModifierType.ordinal()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void buildModifierActionAtSelectedTile(ModifierType paramModifierType) {
/*     */     Tile tile;
/* 170 */     if ((tile = this.S._gameMapSelection.getSelectedTile()) != null)
/*     */     {
/* 172 */       if (tile.type == TileType.PLATFORM && 
/* 173 */         ((PlatformTile)tile).building == null) {
/* 174 */         buildModifierActionAt(paramModifierType, tile.getX(), tile.getY());
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void buildModifierActionAt(ModifierType paramModifierType, int paramInt1, int paramInt2) {
/* 182 */     boolean[] arrayOfBoolean = { true };
/* 183 */     this.S.map.traverseNeighborTilesAroundPos(paramInt1, paramInt2, paramTile -> {
/*     */           if (paramTile.type == TileType.PLATFORM && ((PlatformTile)paramTile).building != null && ((PlatformTile)paramTile).building.buildingType == BuildingType.MODIFIER && !Game.i.modifierManager.getFactory(paramModifierType).canBePlacedNear(((Modifier)((PlatformTile)paramTile).building).type, this.S.gameValue)) {
/*     */             paramArrayOfboolean[0] = false;
/*     */ 
/*     */             
/*     */             return false;
/*     */           } 
/*     */ 
/*     */           
/*     */           return true;
/*     */         });
/*     */ 
/*     */     
/* 196 */     if (arrayOfBoolean[0]) {
/* 197 */       int i = getBuildPrice(paramModifierType);
/* 198 */       if (this.S.gameState.getMoney() >= i)
/* 199 */         this.S.gameState.pushActionNextUpdate((Action)new BuildModifierAction(paramModifierType, paramInt1, paramInt2)); 
/*     */       return;
/*     */     } 
/* 202 */     Notifications.i().add(Game.i.localeManager.i18n.get("modifier_cant_be_placed_near_other"), null, null, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void customModifierButtonAction(Modifier paramModifier, int paramInt1, int paramInt2) {
/* 207 */     this.S.gameState.pushActionNextUpdate((Action)new CustomModifierButtonAction(paramModifier.getTile().getX(), paramModifier.getTile().getY(), paramInt1, paramInt2));
/*     */   }
/*     */   
/*     */   public final void customModifierButtonActionAt(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 211 */     this.S.gameState.pushActionNextUpdate((Action)new CustomModifierButtonAction(paramInt1, paramInt2, paramInt3, paramInt4));
/*     */   }
/*     */   @Null
/*     */   public final Modifier buildModifier(ModifierType paramModifierType, int paramInt1, int paramInt2) {
/* 215 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 217 */     if (this.c[paramModifierType.ordinal()] + 1 > getMaxModifiersCount(paramModifierType)) {
/* 218 */       a.e("No more modifiers of type " + paramModifierType.name() + " can be built", new Object[0]);
/* 219 */       return null;
/*     */     } 
/*     */     
/*     */     Tile tile;
/* 223 */     if ((tile = this.S.map.getMap().getTile(paramInt1, paramInt2)) != null) {
/*     */       
/* 225 */       if (tile.type == TileType.PLATFORM) {
/*     */         PlatformTile platformTile;
/* 227 */         if ((platformTile = (PlatformTile)tile).building == null) {
/*     */           
/* 229 */           boolean[] arrayOfBoolean = { true };
/* 230 */           this.S.map.traverseNeighborTilesAroundTile((Tile)platformTile, paramTile -> {
/*     */                 if (paramTile.type == TileType.PLATFORM && ((PlatformTile)paramTile).building != null && ((PlatformTile)paramTile).building.buildingType == BuildingType.MODIFIER && !Game.i.modifierManager.getFactory(paramModifierType).canBePlacedNear(((Modifier)((PlatformTile)paramTile).building).type, this.S.gameValue)) {
/*     */                   paramArrayOfboolean[0] = false;
/*     */ 
/*     */                   
/*     */                   return false;
/*     */                 } 
/*     */ 
/*     */                 
/*     */                 return true;
/*     */               });
/*     */ 
/*     */           
/* 243 */           if (arrayOfBoolean[0]) {
/* 244 */             Modifier modifier = Game.i.modifierManager.getFactory(paramModifierType).create();
/* 245 */             int i = getBuildPrice(paramModifierType);
/* 246 */             if (this.S.gameState.removeMoney(i)) {
/*     */ 
/*     */ 
/*     */               
/* 250 */               modifier.moneySpentOn = i;
/* 251 */               this.S.map.setModifier(tile.getX(), tile.getY(), modifier);
/* 252 */               this.modifiersBuiltByType[paramModifierType.ordinal()] = this.modifiersBuiltByType[paramModifierType.ordinal()] + 1;
/* 253 */               this.modifiersBuiltByTypeAllTime[paramModifierType.ordinal()] = this.modifiersBuiltByTypeAllTime[paramModifierType.ordinal()] + 1;
/*     */               
/* 255 */               this.S.map.updateDirtyTiles();
/*     */               
/* 257 */               this.S.events.trigger((Event)new ModifierBuild(modifier, i));
/* 258 */               return modifier;
/*     */             } 
/* 260 */             a.w("not enough money to build a modifier", new Object[0]);
/* 261 */             return null;
/*     */           } 
/*     */           
/* 264 */           a.w("can't place near other modifier", new Object[0]);
/* 265 */           return null;
/*     */         } 
/*     */         
/* 268 */         a.e("trying to build modifier on tile which already has a building", new Object[0]);
/* 269 */         return null;
/*     */       } 
/*     */       
/* 272 */       a.e("buildModifier - tile type is " + tile.type.name(), new Object[0]);
/* 273 */       return null;
/*     */     } 
/*     */     
/* 276 */     a.e("buildModifier - tile is null", new Object[0]);
/* 277 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void sellModifierAction(Modifier paramModifier) {
/* 282 */     this.S.gameState.pushActionNextUpdate((Action)new SellModifierAction(paramModifier.getTile().getX(), paramModifier.getTile().getY()));
/*     */   }
/*     */   
/*     */   public final void sellModifier(Modifier paramModifier) {
/* 286 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 288 */     int i = paramModifier.getSellPrice();
/* 289 */     if (!paramModifier.isSellAvailable())
/*     */     {
/* 291 */       i = (int)(i * 0.75F);
/*     */     }
/* 293 */     if (i > 0) this.S.gameState.addMoney(i, false);
/*     */     
/* 295 */     this.S.map.removeBuilding((Building)paramModifier);
/*     */     
/* 297 */     this.modifiersSoldByTypeAllTime[paramModifier.type.ordinal()] = this.modifiersSoldByTypeAllTime[paramModifier.type.ordinal()] + 1;
/* 298 */     this.modifiersBuiltByType[paramModifier.type.ordinal()] = this.modifiersBuiltByType[paramModifier.type.ordinal()] - 1;
/*     */     
/* 300 */     this.S.events.trigger((Event)new ModifierSell(paramModifier, i));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void dispose() {
/* 307 */     for (byte b = 0; b < this.d.length; b++) {
/* 308 */       if (this.d[b] != null) {
/* 309 */         this.d[b].setUnregistered();
/* 310 */         this.d[b] = null;
/*     */       } 
/*     */     } 
/* 313 */     this.modifiers.clear();
/*     */     
/* 315 */     super.dispose();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/*     */     StateSystem.ActionsArray actionsArray;
/* 322 */     if ((actionsArray = this.S.gameState.getCurrentUpdateActions()) != null) {
/* 323 */       for (byte b1 = 0; b1 < actionsArray.size; b1++) {
/*     */         BuildModifierAction buildModifierAction; Action action;
/* 325 */         if ((action = actionsArray.actions[b1]).getType() == ActionType.BMO) {
/*     */           
/* 327 */           buildModifierAction = (BuildModifierAction)action;
/* 328 */           if (buildModifier(buildModifierAction.modifierType, buildModifierAction.x, buildModifierAction.y) != null)
/* 329 */             this.S.gameState.registerPlayerActivity(); 
/*     */         } else {
/* 331 */           SellModifierAction sellModifierAction; if (buildModifierAction.getType() == ActionType.SMO) {
/*     */             
/* 333 */             sellModifierAction = (SellModifierAction)buildModifierAction; PlatformTile platformTile;
/*     */             Tile tile;
/* 335 */             if ((tile = this.S.map.getMap().getTile(sellModifierAction.x, sellModifierAction.y)) != null && tile.type == TileType.PLATFORM && 
/*     */               
/* 337 */               (platformTile = (PlatformTile)tile).building != null && platformTile.building.buildingType == BuildingType.MODIFIER) {
/* 338 */               sellModifier((Modifier)platformTile.building);
/* 339 */               this.S.gameState.registerPlayerActivity();
/*     */             }
/*     */           
/* 342 */           } else if (sellModifierAction.getType() == ActionType.CMB) {
/*     */             
/* 344 */             CustomModifierButtonAction customModifierButtonAction = (CustomModifierButtonAction)sellModifierAction; PlatformTile platformTile;
/*     */             Tile tile;
/* 346 */             if ((tile = this.S.map.getMap().getTile(customModifierButtonAction.x, customModifierButtonAction.y)) != null && tile.type == TileType.PLATFORM && 
/*     */               
/* 348 */               (platformTile = (PlatformTile)tile).building != null && platformTile.building.buildingType == BuildingType.MODIFIER) {
/*     */               Modifier modifier;
/*     */ 
/*     */               
/* 352 */               if ((modifier = (Modifier)platformTile.building).hasCustomButton()) {
/* 353 */                 modifier.customButtonAction(customModifierButtonAction.mapX, customModifierButtonAction.mapY);
/*     */                 
/* 355 */                 this.S.events.trigger((Event)new ModifierCustomButtonPress(modifier));
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 363 */     this.modifiers.begin(); byte b; int i;
/* 364 */     for (b = 0, i = this.modifiers.size; b < i; b++) {
/* 365 */       ((Modifier[])this.modifiers.items)[b].update(paramFloat);
/*     */     }
/* 367 */     this.modifiers.end();
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getSystemName() {
/* 372 */     return "Modifier";
/*     */   }
/*     */   
/*     */   public static void drawBatch(Batch paramBatch, Map paramMap, float paramFloat, MapRenderingSystem.DrawMode paramDrawMode) {
/* 376 */     for (Array.ArrayIterator<PlatformTile> arrayIterator = paramMap.getTilesByType(PlatformTile.class).iterator(); arrayIterator.hasNext();) {
/* 377 */       if ((platformTile = arrayIterator.next()).visibleOnScreen && 
/* 378 */         platformTile.building instanceof Modifier) {
/* 379 */         ((Modifier)platformTile.building).drawBatch(paramBatch, paramFloat, paramDrawMode);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void drawBatchAdditive(Batch paramBatch, Map paramMap, float paramFloat, MapRenderingSystem.DrawMode paramDrawMode) {
/* 385 */     for (Array.ArrayIterator<PlatformTile> arrayIterator = paramMap.getTilesByType(PlatformTile.class).iterator(); arrayIterator.hasNext();) {
/* 386 */       if ((platformTile = arrayIterator.next()).visibleOnScreen && 
/* 387 */         platformTile.building instanceof Modifier)
/* 388 */         ((Modifier)platformTile.building).drawBatchAdditive(paramBatch, paramFloat, paramDrawMode); 
/*     */     } 
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnModifierPlace
/*     */     extends SerializableListener<ModifierSystem> implements Listener<ModifierPlace> {
/*     */     private OnModifierPlace() {}
/*     */     
/*     */     public OnModifierPlace(ModifierSystem param1ModifierSystem) {
/* 398 */       this.a = param1ModifierSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(ModifierPlace param1ModifierPlace) {
/* 403 */       ModifierSystem.a((ModifierSystem)this.a, param1ModifierPlace.getModifier());
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnBuildingRemove extends SerializableListener<ModifierSystem> implements Listener<BuildingRemove> {
/*     */     private OnBuildingRemove() {}
/*     */     
/*     */     public OnBuildingRemove(ModifierSystem param1ModifierSystem) {
/* 412 */       this.a = param1ModifierSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(BuildingRemove param1BuildingRemove) {
/* 417 */       if ((param1BuildingRemove.getBuilding()).buildingType == BuildingType.MODIFIER)
/* 418 */         ModifierSystem.b((ModifierSystem)this.a, (Modifier)param1BuildingRemove.getBuilding()); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\ModifierSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */