/*     */ package com.prineside.tdi2.gates;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Gate;
/*     */ import com.prineside.tdi2.GateBarrier;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.GateType;
/*     */ import com.prineside.tdi2.enums.ItemSortingType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.components.MapEditorItemInfoMenu;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ @REGS
/*     */ public class BarrierTypeGate extends GateBarrier {
/*  37 */   private boolean[] a = new boolean[EnemyType.values.length];
/*     */   
/*  39 */   private static final Color b = new Color();
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  43 */     super.write(paramKryo, paramOutput);
/*  44 */     paramKryo.writeObject(paramOutput, this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  49 */     super.read(paramKryo, paramInput);
/*  50 */     this.a = (boolean[])paramKryo.readObject(paramInput, boolean[].class);
/*     */   }
/*     */   
/*     */   private BarrierTypeGate() {
/*  54 */     super(GateType.BARRIER_TYPE);
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/*  59 */     return RarityType.RARE;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fillMapEditorMenu(Table paramTable, MapEditorItemInfoMenu paramMapEditorItemInfoMenu) {
/*  64 */     super.fillMapEditorMenu(paramTable, paramMapEditorItemInfoMenu);
/*     */     
/*     */     Label label;
/*  67 */     (label = new Label(Game.i.localeManager.i18n.get("blocked_enemies").toUpperCase(), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  68 */     paramTable.add((Actor)label).growX().padBottom(4.0F).row();
/*     */     
/*  70 */     Table table = new Table();
/*  71 */     paramTable.add((Actor)table).growX().row();
/*     */ 
/*     */     
/*  74 */     byte b1 = 0; EnemyType[] arrayOfEnemyType; int i; byte b2;
/*  75 */     for (i = (arrayOfEnemyType = EnemyType.values).length, b2 = 0; b2 < i; ) { EnemyType enemyType = arrayOfEnemyType[b2];
/*  76 */       if (isEnemyBlocked(enemyType)) {
/*     */ 
/*     */         
/*  79 */         Table table1 = new Table();
/*  80 */         paramMapEditorItemInfoMenu.listRowBg(b1++, table1);
/*  81 */         table.add((Actor)table1).growX().height(32.0F).row();
/*     */         
/*  83 */         Image image = new Image(Game.i.enemyManager.getFactory(enemyType).getTexture());
/*  84 */         table1.add((Actor)image).size(24.0F).padRight(12.0F);
/*     */         
/*  86 */         Enemy.Factory factory = Game.i.enemyManager.getFactory(enemyType);
/*     */         Label label1;
/*  88 */         (label1 = new Label(factory.getTitle(), Game.i.assetManager.getLabelStyle(21))).setColor(factory.getColor());
/*  89 */         table1.add((Actor)label1).growX();
/*     */       } 
/*     */       b2++; }
/*     */   
/*     */   }
/*     */   
/*     */   public Gate cloneGate() {
/*     */     BarrierTypeGate barrierTypeGate;
/*  97 */     (barrierTypeGate = Game.i.gateManager.F.BARRIER_TYPE.create()).setPosition(getX(), getY(), isLeftSide());
/*  98 */     System.arraycopy(this.a, 0, barrierTypeGate.a, 0, this.a.length);
/*     */     
/* 100 */     return (Gate)barrierTypeGate;
/*     */   }
/*     */   
/*     */   public int getBlockedEnemyTypeCount() {
/* 104 */     byte b1 = 0;
/* 105 */     for (byte b2 = 0; b2 < EnemyType.values.length; b2++) {
/* 106 */       if (this.a[b2]) {
/* 107 */         b1++;
/*     */       }
/*     */     } 
/* 110 */     return b1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addSellItems(Array<ItemStack> paramArray) {
/* 115 */     paramArray.add(new ItemStack((Item)Item.D.GREEN_PAPER, 100 + getBlockedEnemyTypeCount() * 100));
/*     */   }
/*     */ 
/*     */   
/*     */   public double getPrestigeScore() {
/* 120 */     return 0.05D + getBlockedEnemyTypeCount() * 0.02D;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSortingScore(ItemSortingType paramItemSortingType) {
/* 125 */     if (paramItemSortingType == ItemSortingType.KIND) {
/* 126 */       return 2000;
/*     */     }
/* 128 */     return getRarity().ordinal() * 1000 + getBlockedEnemyTypeCount();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canEnemyPass(EnemyType paramEnemyType) {
/* 134 */     return !isEnemyBlocked(paramEnemyType);
/*     */   }
/*     */   
/*     */   public boolean isEnemyBlocked(EnemyType paramEnemyType) {
/* 138 */     return this.a[paramEnemyType.ordinal()];
/*     */   }
/*     */   
/*     */   public void setEnemyBlocked(EnemyType paramEnemyType, boolean paramBoolean) {
/* 142 */     this.a[paramEnemyType.ordinal()] = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/* 147 */     float f1 = paramFloat / 128.0F;
/*     */     Group group;
/* 149 */     (group = new Group()).setTransform(false);
/* 150 */     group.setSize(paramFloat, paramFloat);
/*     */     
/*     */     Image image;
/* 153 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("item-gate-barrier-type-icon"))).setSize(paramFloat, paramFloat);
/* 154 */     group.addActor((Actor)image);
/*     */     
/* 156 */     paramFloat = 0.0F;
/* 157 */     float f2 = 0.0F;
/* 158 */     byte b1 = 0;
/* 159 */     Array array = new Array(true, getBlockedEnemyTypeCount(), EnemyType.class); EnemyType[] arrayOfEnemyType; int i; byte b2;
/* 160 */     for (i = (arrayOfEnemyType = EnemyType.values).length, b2 = 0; b2 < i; ) { EnemyType enemyType = arrayOfEnemyType[b2];
/* 161 */       if (isEnemyBlocked(enemyType)) {
/* 162 */         array.add(enemyType);
/*     */       }
/*     */       b2++; }
/*     */     
/* 166 */     for (Array.ArrayIterator<EnemyType> arrayIterator = array.iterator(); arrayIterator.hasNext(); ) { EnemyType enemyType = arrayIterator.next();
/* 167 */       TextureRegion textureRegion = Game.i.enemyManager.getFactory(enemyType).getTexture();
/*     */       Image image1;
/* 169 */       (image1 = new Image(textureRegion)).setSize(26.0F * f1, 26.0F * f1);
/* 170 */       image1.setPosition(paramFloat, f2);
/* 171 */       group.addActor((Actor)image1);
/*     */       
/* 173 */       paramFloat += 32.0F * f1;
/* 174 */       b1++;
/* 175 */       if (b1 % 3 == 0) {
/* 176 */         f2 += 32.0F * f1;
/* 177 */         paramFloat = 0.0F;
/*     */       }  }
/*     */ 
/*     */     
/* 181 */     return (Actor)group;
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawStatic(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 186 */     paramFloat3 *= 0.0078125F;
/* 187 */     paramFloat4 *= 0.0078125F;
/*     */     
/* 189 */     ResourcePack.AtlasTextureRegion atlasTextureRegion = (AssetManager.TextureRegions.i()).blank;
/* 190 */     if (isLeftSide()) {
/*     */       
/* 192 */       float f3 = 94.0F / getBlockedEnemyTypeCount() * paramFloat4;
/* 193 */       float f4 = 17.0F * paramFloat4; EnemyType[] arrayOfEnemyType1; int j; byte b1;
/* 194 */       for (j = (arrayOfEnemyType1 = EnemyType.values).length, b1 = 0; b1 < j; ) { EnemyType enemyType = arrayOfEnemyType1[b1];
/* 195 */         if (isEnemyBlocked(enemyType)) {
/*     */           
/* 197 */           b.set(Game.i.enemyManager.getFactory(enemyType).getColor());
/* 198 */           b.a = 0.4F;
/* 199 */           paramBatch.setColor(b);
/* 200 */           paramBatch.draw((TextureRegion)atlasTextureRegion, paramFloat1 - 4.0F * paramFloat3, paramFloat2 + f4, 8.0F * paramFloat3, f3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 207 */           f4 += f3;
/*     */         }  b1++; }
/* 209 */        paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/* 210 */       paramBatch.draw(Game.i.gateManager.F.BARRIER_TYPE.a, paramFloat1 - 14.0F * paramFloat3, paramFloat2, 28.0F * paramFloat3, 128.0F * paramFloat4);
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 219 */     float f1 = 94.0F / getBlockedEnemyTypeCount() * paramFloat3;
/* 220 */     float f2 = 17.0F * paramFloat3; EnemyType[] arrayOfEnemyType; int i; byte b;
/* 221 */     for (i = (arrayOfEnemyType = EnemyType.values).length, b = 0; b < i; ) { EnemyType enemyType = arrayOfEnemyType[b];
/* 222 */       if (isEnemyBlocked(enemyType)) {
/* 223 */         b.set(Game.i.enemyManager.getFactory(enemyType).getColor());
/* 224 */         b.a = 0.4F;
/* 225 */         paramBatch.setColor(b);
/* 226 */         paramBatch.draw((TextureRegion)atlasTextureRegion, paramFloat1 + f2, paramFloat2 - 4.0F * paramFloat4, f1, 8.0F * paramFloat4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 233 */         f2 += f1;
/*     */       }  b++; }
/* 235 */      paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/* 236 */     paramBatch.draw(Game.i.gateManager.F.BARRIER_TYPE.b, paramFloat1, paramFloat2 - 14.0F * paramFloat4, 128.0F * paramFloat3, 28.0F * paramFloat4);
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
/*     */   public boolean sameAs(Gate paramGate) {
/* 248 */     if (!super.sameAs(paramGate)) return false;
/*     */     
/* 250 */     BarrierTypeGate barrierTypeGate = (BarrierTypeGate)paramGate; EnemyType[] arrayOfEnemyType; int i;
/*     */     byte b;
/* 252 */     for (i = (arrayOfEnemyType = EnemyType.values).length, b = 0; b < i; ) { EnemyType enemyType = arrayOfEnemyType[b];
/* 253 */       if (barrierTypeGate.a[enemyType.ordinal()] != this.a[enemyType.ordinal()]) return false; 
/*     */       b++; }
/*     */     
/* 256 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 261 */     return super.toString() + " {blockedEnemies: " + Arrays.toString(this.a) + "}";
/*     */   }
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 266 */     super.toJson(paramJson);
/*     */     
/* 268 */     paramJson.writeArrayStart("blockedEnemies"); EnemyType[] arrayOfEnemyType; int i; byte b;
/* 269 */     for (i = (arrayOfEnemyType = EnemyType.values).length, b = 0; b < i; ) { EnemyType enemyType = arrayOfEnemyType[b];
/* 270 */       if (isEnemyBlocked(enemyType))
/* 271 */         paramJson.writeValue(enemyType.name()); 
/*     */       b++; }
/*     */     
/* 274 */     paramJson.writeArrayEnd();
/*     */   }
/*     */   
/*     */   public static class BarrierTypeGateFactory extends Gate.Factory.AbstractFactory<BarrierTypeGate> {
/*     */     TextureRegion a;
/*     */     TextureRegion b;
/*     */     
/*     */     public BarrierTypeGateFactory() {
/* 282 */       super(GateType.BARRIER_TYPE);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 287 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("gate-barrier-type-vertical");
/* 288 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("gate-barrier-type-horizontal");
/*     */     }
/*     */ 
/*     */     
/*     */     public BarrierTypeGate create() {
/* 293 */       return new BarrierTypeGate((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public BarrierTypeGate createRandom(float param1Float, RandomXS128 param1RandomXS128) {
/* 298 */       BarrierTypeGate barrierTypeGate = create();
/* 299 */       if (param1Float <= 0.0F) param1Float = 0.001F; 
/* 300 */       while (param1Float > 0.0F) {
/* 301 */         EnemyType enemyType = EnemyType.mainEnemyTypes[param1RandomXS128.nextInt(EnemyType.mainEnemyTypes.length)];
/* 302 */         BarrierTypeGate.a(barrierTypeGate)[enemyType.ordinal()] = true;
/* 303 */         param1Float -= 0.25F;
/*     */       } 
/*     */       
/* 306 */       return barrierTypeGate;
/*     */     }
/*     */ 
/*     */     
/*     */     public BarrierTypeGate fromJson(JsonValue param1JsonValue) {
/* 311 */       BarrierTypeGate barrierTypeGate = (BarrierTypeGate)super.fromJson(param1JsonValue);
/*     */       
/* 313 */       if (param1JsonValue.has("blockedEnemies")) {
/* 314 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = param1JsonValue.get("blockedEnemies").iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue = jsonIterator.next();
/* 315 */           BarrierTypeGate.a(barrierTypeGate)[EnemyType.valueOf(jsonValue.asString()).ordinal()] = true; }
/*     */       
/*     */       }
/*     */       
/* 319 */       return barrierTypeGate;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gates\BarrierTypeGate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */