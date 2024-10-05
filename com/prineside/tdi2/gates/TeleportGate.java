/*     */ package com.prineside.tdi2.gates;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Gate;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.enums.GateType;
/*     */ import com.prineside.tdi2.enums.ItemSortingType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.components.MapEditorItemInfoMenu;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public class TeleportGate extends Gate {
/*  35 */   public static final Color[] INDEX_COLORS = new Color[] { MaterialColor.RED.P500, MaterialColor.PINK.P500, MaterialColor.PURPLE.P500, MaterialColor.DEEP_PURPLE.P500, MaterialColor.INDIGO.P500, MaterialColor.BLUE.P500, MaterialColor.LIGHT_BLUE.P500, MaterialColor.CYAN.P500, MaterialColor.TEAL.P500, MaterialColor.GREEN.P500, MaterialColor.LIGHT_GREEN.P500, MaterialColor.LIME.P500, MaterialColor.YELLOW.P500, MaterialColor.AMBER.P500, MaterialColor.ORANGE.P500, MaterialColor.DEEP_ORANGE.P500, MaterialColor.BROWN.P500, MaterialColor.GREY.P500, MaterialColor.BLUE_GREY.P500, MaterialColor.RED.P800, MaterialColor.PINK.P800, MaterialColor.PURPLE.P800, MaterialColor.DEEP_PURPLE.P800, MaterialColor.INDIGO.P800, MaterialColor.BLUE.P800, MaterialColor.LIGHT_BLUE.P800, MaterialColor.CYAN.P800, MaterialColor.TEAL.P800, MaterialColor.GREEN.P800, MaterialColor.LIGHT_GREEN.P800, MaterialColor.LIME.P800, MaterialColor.YELLOW.P800, MaterialColor.AMBER.P800, MaterialColor.ORANGE.P800, MaterialColor.DEEP_ORANGE.P800, MaterialColor.BROWN.P800, MaterialColor.GREY.P800, MaterialColor.BLUE_GREY.P800, MaterialColor.RED.P300, MaterialColor.PINK.P300, MaterialColor.PURPLE.P300, MaterialColor.DEEP_PURPLE.P300, MaterialColor.INDIGO.P300, MaterialColor.BLUE.P300, MaterialColor.LIGHT_BLUE.P300, MaterialColor.CYAN.P300, MaterialColor.TEAL.P300, MaterialColor.GREEN.P300, MaterialColor.LIGHT_GREEN.P300, MaterialColor.LIME.P300, MaterialColor.YELLOW.P300, MaterialColor.AMBER.P300, MaterialColor.ORANGE.P300, MaterialColor.DEEP_ORANGE.P300, MaterialColor.BROWN.P300, MaterialColor.GREY.P300, MaterialColor.BLUE_GREY.P300 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  98 */   public static final String[] INDEX_NAMES = new String[] { "RED", "PINK", "PURPLE", "DEEP_PURPLE", "INDIGO", "BLUE", "LIGHT_BLUE", "CYAN", "TEAL", "GREEN", "LIGHT_GREEN", "LIME", "YELLOW", "AMBER", "ORANGE", "DEEP_ORANGE", "BROWN", "GRAY", "BLUE_GRAY", "Dark RED", "Dark PINK", "Dark PURPLE", "Dark DEEP_PURPLE", "Dark INDIGO", "Dark BLUE", "Dark LIGHT_BLUE", "Dark CYAN", "Dark TEAL", "Dark GREEN", "Dark LIGHT_GREEN", "Dark LIME", "Dark YELLOW", "Dark AMBER", "Dark ORANGE", "Dark DEEP_ORANGE", "Dark BROWN", "Dark GRAY", "Dark BLUE_GRAY", "Bright RED", "Bright PINK", "Bright PURPLE", "Bright DEEP_PURPLE", "Bright INDIGO", "Bright BLUE", "Bright LIGHT_BLUE", "Bright CYAN", "Bright TEAL", "Bright GREEN", "Bright LIGHT_GREEN", "Bright LIME", "Bright YELLOW", "Bright AMBER", "Bright ORANGE", "Bright DEEP_ORANGE", "Bright BROWN", "Bright GRAY", "Bright BLUE_GRAY" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 160 */   public static final int MAX_INDEX = INDEX_COLORS.length - 1;
/*     */   
/*     */   public static final int MAX_INDEX_FOR_LOOT = 16;
/*     */   public int index;
/*     */   @NAGS
/*     */   private ParticleEffectPool.PooledEffect a;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/* 168 */     super.write(paramKryo, paramOutput);
/* 169 */     paramOutput.writeVarInt(this.index, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/* 174 */     super.read(paramKryo, paramInput);
/* 175 */     this.index = paramInput.readVarInt(true);
/*     */   }
/*     */   
/*     */   private TeleportGate() {
/* 179 */     super(GateType.TELEPORT);
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/* 184 */     return RarityType.VERY_RARE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Gate cloneGate() {
/*     */     TeleportGate teleportGate;
/* 191 */     (teleportGate = Game.i.gateManager.F.TELEPORT.create()).setPosition(getX(), getY(), isLeftSide());
/* 192 */     teleportGate.index = this.index;
/*     */     
/* 194 */     return teleportGate;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addSellItems(Array<ItemStack> paramArray) {
/* 199 */     paramArray.add(new ItemStack((Item)Item.D.GREEN_PAPER, 100));
/*     */   }
/*     */ 
/*     */   
/*     */   public void fillMapEditorMenu(Table paramTable, MapEditorItemInfoMenu paramMapEditorItemInfoMenu) {
/* 204 */     super.fillMapEditorMenu(paramTable, paramMapEditorItemInfoMenu);
/*     */     
/* 206 */     String str = INDEX_NAMES[this.index] + " (" + this.index + ")";
/*     */     
/*     */     Label label;
/* 209 */     (label = new Label(str, Game.i.assetManager.getLabelStyle(30))).setWrap(true);
/* 210 */     label.setAlignment(1);
/* 211 */     paramTable.add((Actor)label).padBottom(4.0F).growX();
/*     */   }
/*     */ 
/*     */   
/*     */   public double getPrestigeScore() {
/* 216 */     return 0.3D;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSortingScore(ItemSortingType paramItemSortingType) {
/* 221 */     if (paramItemSortingType == ItemSortingType.KIND) {
/* 222 */       return 3000 + this.index;
/*     */     }
/* 224 */     return getRarity().ordinal() * 1000 + this.index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUnregistered() {
/* 231 */     if (this.a != null) {
/* 232 */       this.a.allowCompletion();
/* 233 */       this.a = null;
/*     */     } 
/*     */     
/* 236 */     super.setUnregistered();
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/*     */     Image image;
/* 242 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("item-gate-teleport-icon"))).setSize(paramFloat, paramFloat);
/* 243 */     image.setColor(INDEX_COLORS[this.index]);
/* 244 */     return (Actor)image;
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawStatic(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 249 */     paramFloat3 *= 0.0078125F;
/* 250 */     paramFloat4 *= 0.0078125F;
/* 251 */     paramBatch.setColor(INDEX_COLORS[this.index]);
/* 252 */     if (isLeftSide()) {
/*     */       
/* 254 */       paramBatch.draw(Game.i.gateManager.F.TELEPORT.a, paramFloat1 - 14.0F * paramFloat3, paramFloat2, 28.0F * paramFloat3, 128.0F * paramFloat4);
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */       
/* 263 */       paramBatch.draw(Game.i.gateManager.F.TELEPORT.b, paramFloat1, paramFloat2 - 14.0F * paramFloat4, 128.0F * paramFloat3, 28.0F * paramFloat4);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 271 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawBatch(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/* 276 */     float f = paramFloat4 * 0.0078125F;
/* 277 */     paramFloat1 = paramFloat5 * 0.0078125F;
/*     */ 
/*     */     
/* 280 */     if (this.S != null && Game.i.settingsManager.isParticlesDrawing()) {
/* 281 */       if (this.a == null) {
/* 282 */         if (!isLeftSide()) {
/*     */           
/* 284 */           this.a = (ParticleEffectPool.PooledEffect)Game.i.gateManager.F.TELEPORT.c.obtain();
/* 285 */           this.a.setPosition(paramFloat2 + 64.0F * f, paramFloat3);
/*     */         } else {
/*     */           
/* 288 */           this.a = (ParticleEffectPool.PooledEffect)Game.i.gateManager.F.TELEPORT.d.obtain();
/* 289 */           this.a.setPosition(paramFloat2, paramFloat3 + 64.0F * paramFloat1);
/*     */         } 
/* 291 */         for (Array.ArrayIterator<ParticleEmitter> arrayIterator = this.a.getEmitters().iterator(); arrayIterator.hasNext();) {
/* 292 */           (particleEmitter = arrayIterator.next()).getTint().setColors(new float[] { (INDEX_COLORS[this.index]).r, (INDEX_COLORS[this.index]).g, (INDEX_COLORS[this.index]).b });
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 298 */         this.S._particle.addParticle((ParticleEffect)this.a, false);
/*     */         
/*     */         return;
/*     */       } 
/* 302 */     } else if (this.a != null) {
/* 303 */       this.a.allowCompletion();
/* 304 */       this.a = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean sameAs(Gate paramGate) {
/* 311 */     if (!super.sameAs(paramGate)) return false;
/*     */ 
/*     */ 
/*     */     
/* 315 */     return (((TeleportGate)(paramGate = paramGate)).index == this.index);
/*     */   }
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 320 */     super.toJson(paramJson);
/*     */     
/* 322 */     paramJson.writeValue("index", Integer.valueOf(this.index));
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 327 */     return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.index + ")";
/*     */   }
/*     */   
/*     */   public static class TeleportGateFactory
/*     */     extends Gate.Factory.AbstractFactory<TeleportGate> {
/*     */     TextureRegion a;
/*     */     TextureRegion b;
/*     */     ParticleEffectPool c;
/*     */     ParticleEffectPool d;
/*     */     
/*     */     public TeleportGateFactory() {
/* 338 */       super(GateType.TELEPORT);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 343 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("gate-teleport-vertical");
/* 344 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("gate-teleport-horizontal");
/*     */       
/* 346 */       this.c = Game.i.assetManager.getParticleEffectPool("teleport-horizontal.prt");
/* 347 */       this.d = Game.i.assetManager.getParticleEffectPool("teleport-vertical.prt");
/*     */     }
/*     */ 
/*     */     
/*     */     public TeleportGate create() {
/* 352 */       return new TeleportGate((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public TeleportGate createRandom(float param1Float, RandomXS128 param1RandomXS128) {
/*     */       TeleportGate teleportGate;
/* 358 */       (teleportGate = create()).index = param1RandomXS128.nextInt(17);
/*     */       
/* 360 */       return teleportGate;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public TeleportGate fromJson(JsonValue param1JsonValue) {
/*     */       TeleportGate teleportGate;
/* 367 */       (teleportGate = (TeleportGate)super.fromJson(param1JsonValue)).index = param1JsonValue.getInt("index");
/*     */       
/* 369 */       return teleportGate;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gates\TeleportGate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */