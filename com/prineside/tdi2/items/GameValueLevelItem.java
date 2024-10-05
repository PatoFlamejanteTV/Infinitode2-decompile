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
/*     */ @REGS(serializer = GameValueLevelItem.Serializer.class)
/*     */ public class GameValueLevelItem extends Item {
/*  32 */   private static final TLog a = TLog.forClass(GameValueLevelItem.class);
/*     */   public GameValueType gameValueType;
/*     */   public String levelName;
/*     */   public double delta;
/*     */   
/*     */   public static class Serializer
/*     */     extends com.esotericsoftware.kryo.Serializer<GameValueLevelItem>
/*     */   {
/*     */     public void write(Kryo param1Kryo, Output param1Output, GameValueLevelItem param1GameValueLevelItem) {
/*  41 */       param1Kryo.writeObject(param1Output, param1GameValueLevelItem.gameValueType);
/*  42 */       param1Kryo.writeObject(param1Output, param1GameValueLevelItem.levelName);
/*  43 */       param1Output.writeDouble(param1GameValueLevelItem.delta);
/*     */     }
/*     */ 
/*     */     
/*     */     public GameValueLevelItem read(Kryo param1Kryo, Input param1Input, Class<? extends GameValueLevelItem> param1Class) {
/*  48 */       GameValueType gameValueType = (GameValueType)param1Kryo.readObject(param1Input, GameValueType.class);
/*  49 */       String str = (String)param1Kryo.readObject(param1Input, String.class);
/*  50 */       double d = param1Input.readDouble();
/*  51 */       return Item.D.F_GAME_VALUE_LEVEL.create(gameValueType, d, str);
/*     */     }
/*     */   }
/*     */   
/*  55 */   private static final StringBuilder b = new StringBuilder();
/*     */   
/*     */   private GameValueLevelItem(GameValueType paramGameValueType, String paramString, double paramDouble) {
/*  58 */     if (paramGameValueType == null) throw new IllegalArgumentException("GameValueType is null"); 
/*  59 */     if (paramString == null) throw new IllegalArgumentException("Level name is null"); 
/*  60 */     this.gameValueType = paramGameValueType;
/*  61 */     this.levelName = paramString;
/*  62 */     this.delta = paramDouble;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item from(Item paramItem) {
/*  67 */     paramItem = paramItem;
/*  68 */     this.gameValueType = ((GameValueLevelItem)paramItem).gameValueType;
/*  69 */     this.levelName = ((GameValueLevelItem)paramItem).levelName;
/*  70 */     this.delta = ((GameValueLevelItem)paramItem).delta;
/*  71 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IntArray getData() {
/*     */     IntArray intArray;
/*  78 */     (intArray = super.getData()).add(ItemDataType.TYPE.ordinal(), this.gameValueType.ordinal());
/*  79 */     intArray.add(ItemDataType.VALUE.ordinal(), MathUtils.round((float)(this.delta * 1000.0D)));
/*     */     
/*  81 */     return intArray;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  86 */     return "gv_level";
/*     */   }
/*     */ 
/*     */   
/*     */   public Item cpy() {
/*  91 */     return Item.D.F_GAME_VALUE_LEVEL.create(this.gameValueType, this.delta, this.levelName);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/*  96 */     b.setLength(0);
/*  97 */     b.append(Game.i.gameValueManager.getTitle(this.gameValueType));
/*  98 */     b.append(" ");
/*  99 */     b.append(Game.i.gameValueManager.formatEffectValue(this.delta, (Game.i.gameValueManager.getStockValueConfig(this.gameValueType)).units));
/* 100 */     b.append(" (").append(Game.i.localeManager.i18n.get("level")).append(" ");
/* 101 */     b.append(this.levelName);
/* 102 */     b.append(")");
/*     */     
/* 104 */     return (CharSequence)b;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/* 109 */     return Game.i.localeManager.i18n.get("item_description_GAME_VALUE_LEVEL");
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/* 114 */     return RarityType.VERY_RARE;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/* 119 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 124 */     super.toJson(paramJson);
/*     */     
/* 126 */     paramJson.writeValue("gameValueType", this.gameValueType.name());
/* 127 */     paramJson.writeValue("delta", Double.valueOf(this.delta));
/* 128 */     paramJson.writeValue("levelName", this.levelName);
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/* 133 */     return ItemType.GAME_VALUE_LEVEL;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/* 138 */     return ItemCategoryType.OTHER;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/* 143 */     return ItemSubcategoryType.O_OTHER;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fillItemCreationForm(ItemCreationOverlay paramItemCreationOverlay) {
/* 148 */     paramItemCreationOverlay.label("Game value");
/*     */     SelectBox selectBox;
/* 150 */     (selectBox = new SelectBox(paramItemCreationOverlay.selectBoxStyle)).setItems((Object[])GameValueType.values);
/* 151 */     selectBox.setSelected(this.gameValueType);
/* 152 */     selectBox.addListener((EventListener)new ChangeListener(this, selectBox, paramItemCreationOverlay)
/*     */         {
/*     */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 155 */             this.c.gameValueType = (GameValueType)this.a.getSelected();
/*     */             
/* 157 */             this.b.updateItemIcon();
/*     */           }
/*     */         });
/* 160 */     paramItemCreationOverlay.selectBox(selectBox);
/*     */     
/* 162 */     paramItemCreationOverlay.label("Delta");
/* 163 */     paramItemCreationOverlay.textField(String.valueOf(this.delta), paramString -> {
/*     */           try {
/*     */             double d = Double.parseDouble(paramString);
/*     */             this.delta = d;
/*     */             paramItemCreationOverlay.updateItemIcon();
/*     */             return;
/* 169 */           } catch (Exception exception) {
/*     */             a.e("bad value: " + paramString, new Object[0]);
/*     */             return;
/*     */           } 
/*     */         });
/* 174 */     paramItemCreationOverlay.label("Level name");
/* 175 */     paramItemCreationOverlay.textField(this.levelName, paramString -> {
/*     */           try {
/*     */             this.levelName = paramString;
/*     */             paramItemCreationOverlay.updateItemIcon();
/*     */             return;
/* 180 */           } catch (Exception exception) {
/*     */             a.e("bad value: " + paramString, new Object[0]);
/*     */             return;
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/*     */     Group group;
/* 190 */     (group = new Group()).setTransform(false);
/*     */     
/* 192 */     group.setSize(paramFloat, paramFloat);
/*     */     
/*     */     Image image;
/* 195 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("item-cell-game-value-level"))).setSize(paramFloat, paramFloat);
/* 196 */     image.setColor(MaterialColor.LIME.P300);
/* 197 */     group.addActor((Actor)image);
/*     */ 
/*     */     
/* 200 */     (image = new Image((Drawable)Game.i.gameValueManager.getStockValueConfig(this.gameValueType).createIconForBackgroundWithColor(MaterialColor.LIME.P300, Color.BLACK))).setPosition(paramFloat * 0.25F, paramFloat * 0.08F);
/* 201 */     image.setSize(paramFloat * 0.66F, paramFloat * 0.66F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 207 */     group.addActor((Actor)image);
/*     */     
/* 209 */     return (Actor)group;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean sameAs(Item paramItem) {
/* 214 */     if (!super.sameAs(paramItem)) return false;
/*     */ 
/*     */ 
/*     */     
/* 218 */     if (((GameValueLevelItem)(paramItem = paramItem)).gameValueType != this.gameValueType) return false; 
/* 219 */     if (((GameValueLevelItem)paramItem).delta != this.delta) return false;
/*     */     
/* 221 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class GameValueLevelItemFactory
/*     */     implements Item.Factory<GameValueLevelItem>
/*     */   {
/*     */     public void setup() {}
/*     */     
/*     */     public GameValueLevelItem create(GameValueType param1GameValueType, double param1Double, String param1String) {
/* 231 */       return new GameValueLevelItem(param1GameValueType, param1String, param1Double, (byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public GameValueLevelItem fromJson(JsonValue param1JsonValue) {
/* 236 */       return create(
/* 237 */           GameValueType.valueOf(param1JsonValue.getString("gameValueType")), param1JsonValue
/* 238 */           .getDouble("delta"), param1JsonValue
/* 239 */           .getString("levelName"));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public GameValueLevelItem createDefault() {
/* 245 */       return create(GameValueType.values[0], 1.0D, "1.1");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\GameValueLevelItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */