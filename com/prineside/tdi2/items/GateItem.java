/*     */ package com.prineside.tdi2.items;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Gate;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.enums.GateType;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.enums.ItemSortingType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(serializer = GateItem.Serializer.class)
/*     */ public class GateItem
/*     */   extends Item {
/*     */   public Gate gate;
/*     */   
/*     */   public static class Serializer extends com.esotericsoftware.kryo.Serializer<GateItem> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, GateItem param1GateItem) {
/*  29 */       param1Kryo.writeClassAndObject(param1Output, param1GateItem.gate);
/*     */     }
/*     */ 
/*     */     
/*     */     public GateItem read(Kryo param1Kryo, Input param1Input, Class<? extends GateItem> param1Class) {
/*  34 */       return Item.D.F_GATE.create((Gate)param1Kryo.readClassAndObject(param1Input));
/*     */     }
/*     */   }
/*     */   
/*     */   private GateItem(Gate paramGate) {
/*  39 */     if (paramGate == null) throw new IllegalArgumentException("Gate is null"); 
/*  40 */     this.gate = paramGate;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item from(Item paramItem) {
/*  45 */     this.gate = ((GateItem)paramItem).gate.cloneGate();
/*  46 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item cpy() {
/*  51 */     return Item.D.F_GATE.create(this.gate.cloneGate());
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/*  56 */     return ItemSubcategoryType.ME_ROADS;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/*  61 */     return ItemType.GATE;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/*  66 */     return ItemCategoryType.MAP_EDITOR;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/*  71 */     return Game.i.gateManager.getFactory(this.gate.getType()).getTitle(this.gate);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/*  76 */     return Game.i.gateManager.getFactory(this.gate.getType()).getDescription(this.gate);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSortingScore(ItemSortingType paramItemSortingType) {
/*  81 */     return this.gate.getSortingScore(paramItemSortingType);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  86 */     return "gate_" + this.gate.getType();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBeSold() {
/*  91 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addSellItems(Array<ItemStack> paramArray) {
/*  96 */     this.gate.addSellItems(paramArray);
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/* 101 */     return this.gate.getRarity();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/* 106 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean sameAs(Item paramItem) {
/* 111 */     if (!super.sameAs(paramItem)) return false;
/*     */     
/* 113 */     return this.gate.sameAs(((GateItem)paramItem).gate);
/*     */   }
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 118 */     super.toJson(paramJson);
/*     */     
/* 120 */     paramJson.writeObjectStart("gate");
/* 121 */     this.gate.toJson(paramJson);
/* 122 */     paramJson.writeObjectEnd();
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/* 127 */     return this.gate.generateIcon(paramFloat, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 132 */     return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.gate.toString() + ")";
/*     */   }
/*     */ 
/*     */   
/*     */   public static class GateItemFactory
/*     */     implements Item.Factory<GateItem>
/*     */   {
/*     */     public void setup() {}
/*     */     
/*     */     public GateItem create(Gate param1Gate) {
/* 142 */       return new GateItem(param1Gate, (byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public GateItem fromJson(JsonValue param1JsonValue) {
/* 147 */       return create(Game.i.gateManager.createGateFromJson(param1JsonValue.get("gate")));
/*     */     }
/*     */ 
/*     */     
/*     */     public GateItem createDefault() {
/* 152 */       return create(Game.i.gateManager.getFactory(GateType.values[0]).create());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\GateItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */