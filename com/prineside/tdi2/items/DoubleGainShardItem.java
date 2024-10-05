/*     */ package com.prineside.tdi2.items;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.shared.ItemCreationOverlay;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS
/*     */ public class DoubleGainShardItem extends Item implements Item.UsableItem {
/*  27 */   private static final TLog a = TLog.forClass(DoubleGainShardItem.class);
/*     */   
/*     */   public static final int DEFAULT_DURATION = 1209600;
/*     */   
/*  31 */   public int duration = 1209600;
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  35 */     paramOutput.writeVarInt(this.duration, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  40 */     this.duration = paramInput.readVarInt(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  49 */     return "double_gain_shard";
/*     */   }
/*     */ 
/*     */   
/*     */   public Item cpy() {
/*     */     DoubleGainShardItem doubleGainShardItem;
/*  55 */     (doubleGainShardItem = Item.D.F_DOUBLE_GAIN_SHARD.create()).duration = this.duration;
/*     */     
/*  57 */     return doubleGainShardItem;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item from(Item paramItem) {
/*  62 */     this.duration = ((DoubleGainShardItem)paramItem).duration;
/*  63 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean sameAs(Item paramItem) {
/*  68 */     if (!super.sameAs(paramItem)) {
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     a.i(((DoubleGainShardItem)paramItem).duration + " " + this.duration, new Object[0]);
/*     */     
/*  74 */     return (((DoubleGainShardItem)paramItem).duration == this.duration);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBeSold() {
/*  79 */     return Game.i.progressManager.hasPermanentDoubleGain();
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getAcceleratorsForDuration(int paramInt) {
/*  84 */     if ((paramInt = (int)StrictMath.round(paramInt / 1209600.0D * 200.0D)) <= 0) paramInt = 1;
/*     */     
/*  86 */     return paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addSellItems(Array<ItemStack> paramArray) {
/*  91 */     paramArray.add(new ItemStack(Item.D.ACCELERATOR, getAcceleratorsForDuration(this.duration)));
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/*  96 */     return ItemType.DOUBLE_GAIN_SHARD;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/* 101 */     return ItemCategoryType.MATERIALS;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/* 106 */     return ItemSubcategoryType.M_DUST;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/* 111 */     return Game.i.localeManager.i18n.get("item_title_DOUBLE_GAIN_SHARD");
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/* 116 */     return Game.i.localeManager.i18n.get("item_description_DOUBLE_GAIN_SHARD") + " (" + StringFormatter.timePassed(this.duration, false, true) + ")";
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/* 121 */     return RarityType.LEGENDARY;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/* 126 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/* 131 */     if (paramBoolean) {
/*     */       Group group;
/* 133 */       (group = new Group()).setTransform(false);
/* 134 */       group.setSize(paramFloat, paramFloat);
/*     */       
/*     */       Image image1;
/* 137 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("double-gain-shard"))).setSize(paramFloat, paramFloat);
/* 138 */       image1.setPosition(a(paramFloat), -a(paramFloat));
/* 139 */       image1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 140 */       group.addActor((Actor)image1);
/*     */ 
/*     */       
/* 143 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("double-gain-shard"))).setSize(paramFloat, paramFloat);
/* 144 */       group.addActor((Actor)image1);
/*     */       
/* 146 */       return (Actor)group;
/*     */     } 
/*     */     Image image;
/* 149 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("double-gain-shard"))).setSize(paramFloat, paramFloat);
/*     */     
/* 151 */     return (Actor)image;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void fillItemCreationForm(ItemCreationOverlay paramItemCreationOverlay) {
/* 157 */     paramItemCreationOverlay.label("Duration (s)");
/*     */     
/* 159 */     paramItemCreationOverlay.textField(PMath.toString(this.duration), paramString -> {
/*     */           try {
/*     */             ((DoubleGainShardItem)paramItemCreationOverlay.currentItem).duration = Integer.valueOf(paramString).intValue(); paramItemCreationOverlay.updateItemIcon();
/*     */             return;
/* 163 */           } catch (Exception exception) {
/*     */             a.e("fillItemCreationForm - bad value: " + paramString, new Object[0]);
/*     */             return;
/*     */           } 
/*     */         });
/*     */   }
/*     */   
/*     */   public boolean autoUseWhenAdded() {
/* 171 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useItem() {
/* 176 */     if (Game.i.progressManager.hasPermanentDoubleGain()) return false;
/*     */     
/* 178 */     if (Game.i.progressManager.removeItems(this, 1)) {
/* 179 */       Game.i.analyticsManager.logCurrencySpent("used", getAnalyticName(), 1);
/* 180 */       return Game.i.progressManager.enableDoubleGainTemporary(this.duration);
/*     */     } 
/*     */ 
/*     */     
/* 184 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 189 */     super.toJson(paramJson);
/*     */     
/* 191 */     paramJson.writeValue("duration", Integer.valueOf(this.duration));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useItemNeedsConfirmation() {
/* 196 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private DoubleGainShardItem() {}
/*     */ 
/*     */   
/*     */   public static class DoubleGainShardItemFactory
/*     */     implements Item.Factory<DoubleGainShardItem>
/*     */   {
/*     */     public void setup() {}
/*     */     
/*     */     public DoubleGainShardItem create() {
/* 209 */       return new DoubleGainShardItem((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public DoubleGainShardItem fromJson(JsonValue param1JsonValue) {
/*     */       DoubleGainShardItem doubleGainShardItem;
/* 215 */       (doubleGainShardItem = create()).duration = param1JsonValue.getInt("duration", 1209600);
/*     */       
/* 217 */       return doubleGainShardItem;
/*     */     }
/*     */ 
/*     */     
/*     */     public DoubleGainShardItem createDefault() {
/* 222 */       return create();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\DoubleGainShardItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */