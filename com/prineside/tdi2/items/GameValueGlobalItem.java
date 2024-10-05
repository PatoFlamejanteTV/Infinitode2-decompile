/*     */ package com.prineside.tdi2.items;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.enums.ItemDataType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.SelectBox;
/*     */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.shared.ItemCreationOverlay;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS(serializer = GameValueGlobalItem.Serializer.class)
/*     */ public class GameValueGlobalItem extends Item {
/*  32 */   private static final TLog a = TLog.forClass(GameValueGlobalItem.class);
/*     */   
/*     */   public GameValueType gameValueType;
/*     */   
/*     */   public double delta;
/*  37 */   private static final StringBuilder b = new StringBuilder();
/*     */   
/*     */   public static class Serializer
/*     */     extends com.esotericsoftware.kryo.Serializer<GameValueGlobalItem> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, GameValueGlobalItem param1GameValueGlobalItem) {
/*  42 */       param1Kryo.writeObject(param1Output, param1GameValueGlobalItem.gameValueType);
/*  43 */       param1Output.writeDouble(param1GameValueGlobalItem.delta);
/*     */     }
/*     */ 
/*     */     
/*     */     public GameValueGlobalItem read(Kryo param1Kryo, Input param1Input, Class<? extends GameValueGlobalItem> param1Class) {
/*  48 */       GameValueType gameValueType = (GameValueType)param1Kryo.readObject(param1Input, GameValueType.class);
/*  49 */       double d = param1Input.readDouble();
/*  50 */       return Item.D.F_GAME_VALUE_GLOBAL.create(gameValueType, d);
/*     */     }
/*     */   }
/*     */   
/*     */   private GameValueGlobalItem(GameValueType paramGameValueType, double paramDouble) {
/*  55 */     if (paramGameValueType == null) throw new IllegalArgumentException("GameValueType is null"); 
/*  56 */     this.delta = paramDouble;
/*  57 */     this.gameValueType = paramGameValueType;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item from(Item paramItem) {
/*  62 */     paramItem = paramItem;
/*  63 */     this.gameValueType = ((GameValueGlobalItem)paramItem).gameValueType;
/*  64 */     this.delta = ((GameValueGlobalItem)paramItem).delta;
/*  65 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IntArray getData() {
/*     */     IntArray intArray;
/*  72 */     (intArray = super.getData()).add(ItemDataType.TYPE.ordinal(), this.gameValueType.ordinal());
/*  73 */     intArray.add(ItemDataType.VALUE.ordinal(), MathUtils.round((float)(this.delta * 1000.0D)));
/*     */     
/*  75 */     return intArray;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item cpy() {
/*  80 */     return Item.D.F_GAME_VALUE_GLOBAL.create(this.gameValueType, this.delta);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/*  85 */     b.setLength(0);
/*  86 */     b.append(Game.i.gameValueManager.getTitle(this.gameValueType));
/*  87 */     b.append(" ");
/*  88 */     b.append(Game.i.gameValueManager.formatEffectValue(this.delta, (Game.i.gameValueManager.getStockValueConfig(this.gameValueType)).units));
/*     */     
/*  90 */     return (CharSequence)b;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/*  95 */     return Game.i.localeManager.i18n.get("item_description_GAME_VALUE_GLOBAL");
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/* 100 */     return RarityType.EPIC;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/* 105 */     return "gv_global";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/* 110 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 115 */     super.toJson(paramJson);
/*     */     
/* 117 */     paramJson.writeValue("gameValueType", this.gameValueType.name());
/* 118 */     paramJson.writeValue("delta", Double.valueOf(this.delta));
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/* 123 */     return ItemType.GAME_VALUE_GLOBAL;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/* 128 */     return ItemCategoryType.OTHER;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/* 133 */     return ItemSubcategoryType.O_OTHER;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/*     */     Group group;
/* 139 */     (group = new Group()).setTransform(false);
/*     */     
/* 141 */     group.setSize(paramFloat, paramFloat);
/*     */     
/*     */     Image image;
/* 144 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("item-cell-game-value-global"))).setSize(paramFloat, paramFloat);
/* 145 */     image.setColor(MaterialColor.PURPLE.P300);
/* 146 */     group.addActor((Actor)image);
/*     */ 
/*     */     
/* 149 */     (image = new Image((Drawable)Game.i.gameValueManager.getStockValueConfig(this.gameValueType).createIconForBackgroundWithColor(MaterialColor.PURPLE.P300, Color.BLACK))).setPosition(paramFloat * 0.25F, paramFloat * 0.08F);
/* 150 */     image.setSize(paramFloat * 0.66F, paramFloat * 0.66F);
/* 151 */     group.addActor((Actor)image);
/*     */     
/* 153 */     return (Actor)group;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fillItemCreationForm(ItemCreationOverlay paramItemCreationOverlay) {
/* 158 */     paramItemCreationOverlay.label("Game value");
/*     */     SelectBox selectBox;
/* 160 */     (selectBox = new SelectBox(paramItemCreationOverlay.selectBoxStyle)).setItems((Object[])GameValueType.values);
/* 161 */     selectBox.setSelected(this.gameValueType);
/* 162 */     selectBox.addListener((EventListener)new ChangeListener(this, paramItemCreationOverlay, selectBox)
/*     */         {
/*     */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 165 */             this.a.currentItem = Item.D.F_GAME_VALUE_GLOBAL.create((GameValueType)this.b.getSelected(), this.c.delta);
/* 166 */             this.a.updateItemIcon();
/*     */           }
/*     */         });
/* 169 */     paramItemCreationOverlay.selectBox(selectBox);
/*     */     
/* 171 */     paramItemCreationOverlay.label("Delta");
/* 172 */     paramItemCreationOverlay.textField(String.valueOf(this.delta), paramString -> {
/*     */           try {
/*     */             double d = Double.parseDouble(paramString); paramItemCreationOverlay.currentItem = Item.D.F_GAME_VALUE_GLOBAL.create(this.gameValueType, d);
/*     */             paramItemCreationOverlay.updateItemIcon();
/*     */             return;
/* 177 */           } catch (Exception exception) {
/*     */             a.e("bad value: " + paramString, new Object[0]);
/*     */             return;
/*     */           } 
/*     */         });
/*     */   }
/*     */   
/*     */   public boolean sameAs(Item paramItem) {
/* 185 */     if (!super.sameAs(paramItem)) return false;
/*     */ 
/*     */ 
/*     */     
/* 189 */     if (((GameValueGlobalItem)(paramItem = paramItem)).gameValueType != this.gameValueType) return false; 
/* 190 */     if (((GameValueGlobalItem)paramItem).delta != this.delta) return false;
/*     */     
/* 192 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class GameValueGlobalItemFactory
/*     */     implements Item.Factory<GameValueGlobalItem>
/*     */   {
/*     */     public void setup() {}
/*     */     
/*     */     public GameValueGlobalItem create(GameValueType param1GameValueType, double param1Double) {
/* 202 */       return new GameValueGlobalItem(param1GameValueType, param1Double, (byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public GameValueGlobalItem fromJson(JsonValue param1JsonValue) {
/* 207 */       return create(GameValueType.valueOf(param1JsonValue.getString("gameValueType")), param1JsonValue.getDouble("delta"));
/*     */     }
/*     */ 
/*     */     
/*     */     public GameValueGlobalItem createDefault() {
/* 212 */       return create(GameValueType.values[0], 1.0D);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\GameValueGlobalItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */