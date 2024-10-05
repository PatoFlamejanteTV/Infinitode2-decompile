/*     */ package com.prineside.tdi2;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.enums.BuildingType;
/*     */ import com.prineside.tdi2.enums.ModifierType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.tiles.SourceTile;
/*     */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*     */ import com.prineside.tdi2.ui.actors.ImageWithParentColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ @REGS(classOnly = true)
/*     */ public abstract class Modifier extends Building {
/*     */   public static final float PENALTY_SELL_PRICE = 0.75F;
/*     */   
/*     */   static {
/*  31 */     TLog.forClass(Modifier.class);
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public enum ConnectionSide
/*     */   {
/*  37 */     BOTTOM,
/*  38 */     LEFT,
/*  39 */     TOP,
/*  40 */     RIGHT,
/*  41 */     BOTTOM_LEFT,
/*  42 */     TOP_LEFT,
/*  43 */     TOP_RIGHT,
/*  44 */     BOTTOM_RIGHT; static {
/*     */     
/*  46 */     } public static final ConnectionSide[] values = values();
/*     */   }
/*  48 */   public static final float[][] WIRES_TEXTURES_CONFIG = new float[][] { { -31.0F, -72.0F, 62.0F, 54.0F }, { -72.0F, -31.0F, 54.0F, 62.0F }, { -31.0F, 18.0F, 62.0F, 54.0F }, { 18.0F, -31.0F, 54.0F, 62.0F }, { -72.0F, -72.0F, 54.0F, 54.0F }, { -72.0F, 18.0F, 54.0F, 54.0F }, { 18.0F, 18.0F, 54.0F, 54.0F }, { 18.0F, -72.0F, 54.0F, 54.0F } };
/*     */ 
/*     */ 
/*     */   
/*     */   public int id;
/*     */ 
/*     */ 
/*     */   
/*     */   public ModifierType type;
/*     */ 
/*     */ 
/*     */   
/*     */   public float timeSinceBuilt;
/*     */ 
/*     */ 
/*     */   
/*  64 */   public boolean[] visuallyConnectedSides = new boolean[ConnectionSide.values.length];
/*  65 */   public int moneySpentOn = 0;
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  69 */     super.write(paramKryo, paramOutput);
/*  70 */     paramOutput.writeVarInt(this.id, true);
/*  71 */     paramKryo.writeObjectOrNull(paramOutput, this.type, ModifierType.class);
/*  72 */     paramOutput.writeFloat(this.timeSinceBuilt);
/*  73 */     paramKryo.writeObject(paramOutput, this.visuallyConnectedSides);
/*  74 */     paramOutput.writeVarInt(this.moneySpentOn, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  79 */     super.read(paramKryo, paramInput);
/*  80 */     this.id = paramInput.readVarInt(true);
/*  81 */     this.type = (ModifierType)paramKryo.readObjectOrNull(paramInput, ModifierType.class);
/*  82 */     this.timeSinceBuilt = paramInput.readFloat();
/*  83 */     this.visuallyConnectedSides = (boolean[])paramKryo.readObject(paramInput, boolean[].class);
/*  84 */     this.moneySpentOn = paramInput.readVarInt(true);
/*     */   }
/*     */   
/*     */   protected Modifier(ModifierType paramModifierType) {
/*  88 */     super(BuildingType.MODIFIER);
/*     */     
/*  90 */     this.type = paramModifierType;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getWalkCost() {
/*  95 */     return 512.0F;
/*     */   }
/*     */   
/*     */   public void setSideConnected(ConnectionSide paramConnectionSide, boolean paramBoolean) {
/*  99 */     this.visuallyConnectedSides[paramConnectionSide.ordinal()] = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean connectsToTowers() {
/* 103 */     return true;
/*     */   }
/*     */   
/*     */   public boolean connectsToMiners() {
/* 107 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getSellDelay() {
/* 114 */     return 300.0F;
/*     */   }
/*     */   
/*     */   public float getTimeTillSellAvailable() {
/* 118 */     return StrictMath.max(0.0F, getSellDelay() - this.timeSinceBuilt);
/*     */   }
/*     */   
/*     */   public boolean isSellAvailable() {
/* 122 */     return (getTimeTillSellAvailable() == 0.0F);
/*     */   }
/*     */   
/*     */   public int getSellPrice() {
/* 126 */     return this.moneySpentOn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateCache() {
/* 133 */     Arrays.fill(this.visuallyConnectedSides, false);
/*     */     
/* 135 */     this.S.map.traverseNeighborTilesAroundTile((Tile)getTile(), paramTile -> {
/*     */           if (paramTile instanceof PlatformTile && connectsToTowers()) {
/*     */             PlatformTile platformTile;
/*     */             if ((platformTile = (PlatformTile)paramTile).building instanceof Tower) {
/*     */               this.visuallyConnectedSides[a(paramTile.getX(), paramTile.getY()).ordinal()] = true;
/*     */             }
/*     */           } else {
/*     */             SourceTile sourceTile;
/*     */             if (paramTile instanceof SourceTile && connectsToMiners() && (sourceTile = (SourceTile)paramTile).miner != null) {
/*     */               this.visuallyConnectedSides[a(paramTile.getX(), paramTile.getY()).ordinal()] = true;
/*     */             }
/*     */           } 
/*     */           return true;
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void fillModifierMenu(Group paramGroup, ObjectMap<String, Object> paramObjectMap) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasCustomButton()
/*     */   {
/* 159 */     return false; } public boolean isCustomButtonNeedMapPoint() {
/* 160 */     return false;
/*     */   }
/*     */   public void customButtonAction(int paramInt1, int paramInt2) {}
/*     */   
/*     */   public void updateCustomButton(ComplexButton paramComplexButton, boolean paramBoolean) {}
/*     */   
/* 166 */   public void toJson(Json paramJson) { super.toJson(paramJson);
/*     */     
/* 168 */     paramJson.writeValue("type", this.type.name()); } private void a(Batch paramBatch) {
/*     */     ConnectionSide[] arrayOfConnectionSide;
/*     */     int i;
/*     */     byte b;
/* 172 */     for (i = (arrayOfConnectionSide = ConnectionSide.values).length, b = 0; b < i; ) { ConnectionSide connectionSide = arrayOfConnectionSide[b];
/* 173 */       if (this.visuallyConnectedSides[connectionSide.ordinal()]) {
/* 174 */         float[] arrayOfFloat = WIRES_TEXTURES_CONFIG[connectionSide.ordinal()];
/* 175 */         paramBatch.draw((Game.i.modifierManager.getFactory(this.type)).wires[connectionSide.ordinal()], (getTile()).center.x + arrayOfFloat[0], (getTile()).center.y + arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
/*     */       } 
/*     */       b++; }
/*     */   
/*     */   }
/*     */   public void drawBatch(Batch paramBatch, float paramFloat, MapRenderingSystem.DrawMode paramDrawMode) {
/* 181 */     if ((getTile()).visibleOnScreen) {
/* 182 */       Factory factory = Game.i.modifierManager.getFactory(this.type);
/* 183 */       paramBatch.setColor(factory.color);
/* 184 */       a(paramBatch);
/*     */       
/* 186 */       if (paramDrawMode == MapRenderingSystem.DrawMode.DETAILED) {
/* 187 */         paramBatch.setColor(0.8F, 0.8F, 0.8F, 1.0F);
/*     */       } else {
/* 189 */         paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */       } 
/* 191 */       paramBatch.draw(factory.getBaseTexture(), (getTile()).center.x - 64.0F, (getTile()).center.y - 64.0F, 128.0F, 128.0F);
/*     */       
/* 193 */       if (paramDrawMode == MapRenderingSystem.DrawMode.DETAILED) {
/* 194 */         paramBatch.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/* 195 */         paramBatch.draw(factory.a, (getTile().getX() << 7) + 42.24F, (getTile().getY() << 7) + 42.24F, 42.24F, 42.24F);
/*     */       } else {
/* 197 */         paramBatch.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 198 */         paramBatch.draw(factory.a, (getTile().getX() << 7) + 39.68F, (getTile().getY() << 7) + 44.8F, 42.24F, 42.24F);
/* 199 */         paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/* 200 */         paramBatch.draw(factory.a, (getTile().getX() << 7) + 42.24F, (getTile().getY() << 7) + 42.24F, 42.24F, 42.24F);
/*     */       } 
/*     */ 
/*     */       
/* 204 */       if (!isSellAvailable()) {
/* 205 */         paramBatch.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 206 */         paramBatch.draw(factory.b, (getTile()).center.x - 64.0F + 10.0F + 2.0F, (getTile()).center.y - 64.0F + 10.0F - 2.0F, 18.285715F, 18.285715F);
/* 207 */         paramBatch.setColor(MaterialColor.ORANGE.P500);
/* 208 */         paramBatch.draw(factory.b, (getTile()).center.x - 64.0F + 10.0F, (getTile()).center.y - 64.0F + 10.0F, 18.285715F, 18.285715F);
/* 209 */         paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawBatchAdditive(Batch paramBatch, float paramFloat, MapRenderingSystem.DrawMode paramDrawMode) {}
/*     */ 
/*     */   
/*     */   public boolean sameAs(Building paramBuilding) {
/* 219 */     if (!super.sameAs(paramBuilding)) return false;
/*     */     
/* 221 */     if (((Modifier)(paramBuilding = paramBuilding)).type != this.type) return false;
/*     */     
/* 223 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Modifier cloneBuilding() {
/* 228 */     return Game.i.modifierManager.getFactory(this.type).create();
/*     */   }
/*     */   
/*     */   public void update(float paramFloat) {
/* 232 */     if (this.S.gameState.isGameRealTimePasses()) this.timeSinceBuilt += paramFloat; 
/*     */   }
/*     */   
/*     */   public void dispose() {}
/*     */   
/*     */   private ConnectionSide a(int paramInt1, int paramInt2) {
/* 238 */     int i = getTile().getX();
/* 239 */     int j = getTile().getY();
/*     */     
/* 241 */     if (paramInt1 == i) {
/*     */       
/* 243 */       if (paramInt2 + 1 == j)
/* 244 */         return ConnectionSide.BOTTOM; 
/* 245 */       if (paramInt2 - 1 == j) {
/* 246 */         return ConnectionSide.TOP;
/*     */       }
/* 248 */     } else if (paramInt2 == j) {
/*     */       
/* 250 */       if (paramInt1 + 1 == i)
/* 251 */         return ConnectionSide.LEFT; 
/* 252 */       if (paramInt1 - 1 == i) {
/* 253 */         return ConnectionSide.RIGHT;
/*     */       }
/* 255 */     } else if (paramInt1 + 1 == i) {
/*     */       
/* 257 */       if (paramInt2 + 1 == j)
/* 258 */         return ConnectionSide.BOTTOM_LEFT; 
/* 259 */       if (paramInt2 - 1 == j) {
/* 260 */         return ConnectionSide.TOP_LEFT;
/*     */       }
/*     */     } else {
/*     */       
/* 264 */       if (paramInt2 + 1 == j)
/* 265 */         return ConnectionSide.BOTTOM_RIGHT; 
/* 266 */       if (paramInt2 - 1 == j) {
/* 267 */         return ConnectionSide.TOP_RIGHT;
/*     */       }
/*     */     } 
/*     */     
/* 271 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadFromJson(JsonValue paramJsonValue) {}
/*     */ 
/*     */   
/*     */   public static abstract class Factory<T extends Modifier>
/*     */     implements EntityFactory
/*     */   {
/*     */     public final Color color;
/*     */     
/*     */     public final String iconName;
/*     */     
/*     */     public final ModifierType modifierType;
/*     */     
/* 287 */     public TextureRegion[] wires = new TextureRegion[Modifier.ConnectionSide.values.length];
/*     */     protected TextureRegion a;
/*     */     protected TextureRegion b;
/*     */     
/*     */     protected Factory(ModifierType param1ModifierType, Color param1Color, String param1String) {
/* 292 */       this.color = param1Color;
/* 293 */       this.iconName = param1String;
/* 294 */       this.modifierType = param1ModifierType;
/*     */       
/* 296 */       if (Game.i.assetManager != null) {
/* 297 */         this.a = (TextureRegion)Game.i.assetManager.getTextureRegion(param1String);
/* 298 */         this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("icon-dollar");
/* 299 */         this.wires[Modifier.ConnectionSide.LEFT.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion("modifier-wires-left");
/* 300 */         this.wires[Modifier.ConnectionSide.RIGHT.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion("modifier-wires-right");
/* 301 */         this.wires[Modifier.ConnectionSide.TOP.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion("modifier-wires-top");
/* 302 */         this.wires[Modifier.ConnectionSide.BOTTOM.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion("modifier-wires-bottom");
/* 303 */         this.wires[Modifier.ConnectionSide.TOP_LEFT.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion("modifier-wires-top-left");
/* 304 */         this.wires[Modifier.ConnectionSide.TOP_RIGHT.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion("modifier-wires-top-right");
/* 305 */         this.wires[Modifier.ConnectionSide.BOTTOM_LEFT.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion("modifier-wires-bottom-left");
/* 306 */         this.wires[Modifier.ConnectionSide.BOTTOM_RIGHT.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion("modifier-wires-bottom-right");
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setup() {
/* 314 */       if (Game.i.assetManager != null) {
/* 315 */         setupAssets();
/*     */       }
/*     */     }
/*     */     
/*     */     public ModifierProcessor createProcessor() {
/* 320 */       return null;
/*     */     }
/*     */     
/*     */     public boolean canBePlacedNear(ModifierType param1ModifierType, GameValueProvider param1GameValueProvider) {
/* 324 */       return true;
/*     */     }
/*     */     public void setupAssets() {}
/*     */     
/*     */     public abstract T create();
/*     */     
/*     */     public CharSequence getTitle() {
/* 331 */       String str = Game.i.modifierManager.getTitleAlias(this.modifierType);
/*     */       
/* 333 */       return Game.i.localeManager.i18n.get(str);
/*     */     }
/*     */     
/*     */     public CharSequence getFancyTitle() {
/* 337 */       String str = Game.i.modifierManager.getTitleFancyAlias(this.modifierType);
/*     */       
/* 339 */       return Game.i.localeManager.i18n.get(str);
/*     */     }
/*     */     
/*     */     public CharSequence getDescription(GameValueProvider param1GameValueProvider) {
/* 343 */       String str = Game.i.modifierManager.getDescriptionAlias(this.modifierType);
/*     */       
/* 345 */       return Game.i.localeManager.i18n.get(str);
/*     */     }
/*     */     
/*     */     protected static int a(int param1Int) {
/* 349 */       if (param1Int < 500)
/* 350 */         return MathUtils.round(param1Int / 5.0F) * 5; 
/* 351 */       if (param1Int < 5000) {
/* 352 */         return MathUtils.round(param1Int / 10.0F) * 10;
/*     */       }
/* 354 */       return MathUtils.round(param1Int / 50.0F) * 50;
/*     */     }
/*     */     
/*     */     public abstract TextureRegion getBaseTexture();
/*     */     
/*     */     public abstract int getBuildPrice(GameSystemProvider param1GameSystemProvider, int param1Int);
/*     */     
/*     */     public boolean isAvailable(GameValueProvider param1GameValueProvider) {
/* 362 */       return (param1GameValueProvider.getIntValue(Game.i.modifierManager.getCountGameValue(this.modifierType)) != 0);
/*     */     }
/*     */     
/*     */     public Actor createIconActor(float param1Float) {
/*     */       Group group;
/* 367 */       (group = new Group()).setTransform(false);
/* 368 */       group.setSize(param1Float, param1Float);
/*     */       
/*     */       ImageWithParentColor imageWithParentColor;
/* 371 */       (imageWithParentColor = new ImageWithParentColor((Drawable)Game.i.assetManager.getDrawable("modifier-icon-wires"))).setColor(this.color);
/* 372 */       imageWithParentColor.setSize(param1Float, param1Float);
/* 373 */       group.addActor((Actor)imageWithParentColor);
/*     */ 
/*     */ 
/*     */       
/* 377 */       (imageWithParentColor = new ImageWithParentColor(getBaseTexture())).setSize(param1Float, param1Float);
/* 378 */       group.addActor((Actor)imageWithParentColor);
/*     */       
/*     */       Image image;
/* 381 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable(this.iconName))).setSize(param1Float * 0.33F, param1Float * 0.33F);
/* 382 */       image.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 383 */       image.setPosition(0.31F * param1Float, 0.35F * param1Float);
/* 384 */       group.addActor((Actor)image);
/*     */ 
/*     */       
/* 387 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable(this.iconName))).setSize(param1Float * 0.33F, param1Float * 0.33F);
/* 388 */       image.setPosition(0.33F * param1Float, 0.33F * param1Float);
/* 389 */       group.addActor((Actor)image);
/*     */       
/* 391 */       return (Actor)group;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Modifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */