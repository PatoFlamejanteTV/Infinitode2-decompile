/*     */ package com.prineside.tdi2.items;
/*     */ 
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.enums.ItemDataType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(serializer = AbilityItem.Serializer.class)
/*     */ public class AbilityItem extends Item {
/*     */   public AbilityType abilityType;
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<AbilityItem> { public void write(Kryo param1Kryo, Output param1Output, AbilityItem param1AbilityItem) {
/*  31 */       param1Kryo.writeObject(param1Output, param1AbilityItem.abilityType);
/*     */     }
/*     */ 
/*     */     
/*     */     public AbilityItem read(Kryo param1Kryo, Input param1Input, Class<? extends AbilityItem> param1Class) {
/*  36 */       return Item.D.F_ABILITY.create((AbilityType)param1Kryo.readObject(param1Input, AbilityType.class));
/*     */     }
/*     */     
/*     */     public AbilityItem read() {
/*  40 */       throw new IllegalStateException("Do not use");
/*     */     } }
/*     */   
/*     */   private AbilityItem(AbilityType paramAbilityType) {
/*  44 */     if (paramAbilityType == null) throw new IllegalArgumentException("AbilityType is null");
/*     */     
/*  46 */     this.abilityType = paramAbilityType;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item from(Item paramItem) {
/*  51 */     return Item.D.F_ABILITY.create(((AbilityItem)paramItem).abilityType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IntArray getData() {
/*     */     IntArray intArray;
/*  58 */     (intArray = super.getData()).add(ItemDataType.TYPE.ordinal(), this.abilityType.ordinal());
/*     */     
/*  60 */     return intArray;
/*     */   }
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/*  65 */     super.toJson(paramJson);
/*     */     
/*  67 */     paramJson.writeValue("abilityType", this.abilityType.name());
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/*  72 */     return ItemType.ABILITY;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/*  77 */     return ItemCategoryType.OTHER;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/*  82 */     return ItemSubcategoryType.O_OTHER;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/*  87 */     return Game.i.abilityManager.getFactory(this.abilityType).getTitle();
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/*  92 */     return Game.i.abilityManager.getFactory(this.abilityType).getDescription((GameValueProvider)Game.i.gameValueManager.getSnapshot());
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/*  97 */     return RarityType.COMMON;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/* 102 */     return "ability_" + this.abilityType;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/* 107 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean sameAs(Item paramItem) {
/* 112 */     if (!super.sameAs(paramItem)) return false;
/*     */     
/* 114 */     return (((AbilityItem)paramItem).abilityType == this.abilityType);
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/* 119 */     Ability.Factory factory = Game.i.abilityManager.getFactory(this.abilityType);
/* 120 */     if (paramBoolean) {
/*     */       Group group;
/* 122 */       (group = new Group()).setTransform(false);
/* 123 */       group.setSize(paramFloat, paramFloat);
/*     */       
/*     */       Image image1;
/* 126 */       (image1 = new Image((Drawable)factory.getIconDrawable())).setSize(paramFloat, paramFloat);
/* 127 */       image1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 128 */       image1.setPosition(a(paramFloat), -a(paramFloat));
/* 129 */       group.addActor((Actor)image1);
/*     */ 
/*     */       
/* 132 */       (image1 = new Image((Drawable)factory.getIconDrawable())).setSize(paramFloat, paramFloat);
/* 133 */       image1.setColor(factory.getColor());
/* 134 */       group.addActor((Actor)image1);
/*     */       
/* 136 */       return (Actor)group;
/*     */     } 
/*     */     Image image;
/* 139 */     (image = new Image((Drawable)factory.getIconDrawable())).setSize(paramFloat, paramFloat);
/* 140 */     image.setColor(factory.getColor());
/*     */     
/* 142 */     return (Actor)image;
/*     */   }
/*     */   
/*     */   public static class AbilityItemFactory
/*     */     implements Item.Factory<AbilityItem> {
/* 147 */     private final AbilityItem[] a = new AbilityItem[AbilityType.values.length]; public AbilityItemFactory() { AbilityType[] arrayOfAbilityType;
/*     */       int i;
/*     */       byte b;
/* 150 */       for (i = (arrayOfAbilityType = AbilityType.values).length, b = 0; b < i; ) { AbilityType abilityType = arrayOfAbilityType[b];
/* 151 */         this.a[abilityType.ordinal()] = new AbilityItem(abilityType, (byte)0);
/*     */         b++; }
/*     */        }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setup() {}
/*     */ 
/*     */     
/*     */     public AbilityItem create(AbilityType param1AbilityType) {
/* 161 */       return this.a[param1AbilityType.ordinal()];
/*     */     }
/*     */ 
/*     */     
/*     */     public AbilityItem fromJson(JsonValue param1JsonValue) {
/* 166 */       return create(AbilityType.valueOf(param1JsonValue.getString("abilityType")));
/*     */     }
/*     */ 
/*     */     
/*     */     public AbilityItem createDefault() {
/* 171 */       return create(AbilityType.values[0]);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\AbilityItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */