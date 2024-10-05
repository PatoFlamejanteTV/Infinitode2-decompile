/*     */ package com.prineside.tdi2.items;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.enums.BlueprintType;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.enums.ItemDataType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(serializer = BlueprintItem.Serializer.class)
/*     */ public class BlueprintItem
/*     */   extends Item {
/*     */   private BlueprintType a;
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<BlueprintItem> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, BlueprintItem param1BlueprintItem) {
/*  35 */       param1Kryo.writeObject(param1Output, BlueprintItem.a(param1BlueprintItem));
/*     */     }
/*     */ 
/*     */     
/*     */     public BlueprintItem read(Kryo param1Kryo, Input param1Input, Class<? extends BlueprintItem> param1Class) {
/*  40 */       return Item.D.F_BLUEPRINT.create((BlueprintType)param1Kryo.readObject(param1Input, BlueprintType.class));
/*     */     }
/*     */     
/*     */     public BlueprintItem read() {
/*  44 */       throw new IllegalStateException("Do not use");
/*     */     } }
/*     */   
/*     */   private BlueprintItem(BlueprintType paramBlueprintType) {
/*  48 */     this.a = paramBlueprintType;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAffectedByDoubleGain() {
/*  53 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IntArray getData() {
/*     */     IntArray intArray;
/*  60 */     (intArray = super.getData()).add(ItemDataType.TYPE.ordinal(), this.a.ordinal());
/*     */     
/*  62 */     return intArray;
/*     */   }
/*     */   
/*     */   public boolean canBeSold() {
/*  66 */     return true;
/*     */   }
/*     */   
/*     */   public Item from(Item paramItem) {
/*  70 */     return Item.D.F_BLUEPRINT.create(((BlueprintItem)paramItem).a);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addSellItems(Array<ItemStack> paramArray) {
/*  75 */     char c = '\001';
/*     */     
/*  77 */     switch (null.a[this.a.ordinal()]) { case 1:
/*     */       case 2:
/*     */       case 3:
/*  80 */         c = 'Ĭ'; break;
/*  81 */       case 4: c = 'Ϩ'; break;
/*  82 */       case 5: c = 'ৄ'; break;
/*  83 */       case 6: c = 'ᥤ'; break;
/*  84 */       case 7: c = '㪘';
/*     */         break; }
/*     */     
/*  87 */     paramArray.add(new ItemStack(Item.D.GREEN_PAPER, c));
/*     */   }
/*     */ 
/*     */   
/*     */   public double getPriceInAcceleratorsForResearchReset(int paramInt) {
/*  92 */     int i = paramInt;
/*  93 */     switch (null.a[this.a.ordinal()]) { case 1:
/*     */       case 2:
/*     */       case 3:
/*  96 */         i = paramInt * 300; break;
/*  97 */       case 4: i = paramInt * 1000; break;
/*  98 */       case 5: i = paramInt * 2500; break;
/*  99 */       case 6: i = paramInt * 6500; break;
/* 100 */       case 7: i = paramInt * 15000;
/*     */         break; }
/*     */     
/* 103 */     return Item.D.GREEN_PAPER.getPriceInAcceleratorsForResearchReset(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/* 108 */     switch (null.a[this.a.ordinal()]) { case 1:
/* 109 */         return Game.i.localeManager.i18n.get("item_title_BLUEPRINT_POWER");
/* 110 */       case 2: return Game.i.localeManager.i18n.get("item_title_BLUEPRINT_AGILITY");
/* 111 */       case 3: return Game.i.localeManager.i18n.get("item_title_BLUEPRINT_EXPERIENCE");
/* 112 */       case 4: return Game.i.localeManager.i18n.get("item_title_BLUEPRINT_SPECIAL_I");
/* 113 */       case 5: return Game.i.localeManager.i18n.get("item_title_BLUEPRINT_SPECIAL_II");
/* 114 */       case 6: return Game.i.localeManager.i18n.get("item_title_BLUEPRINT_SPECIAL_III");
/* 115 */       case 7: return Game.i.localeManager.i18n.get("item_title_BLUEPRINT_SPECIAL_IV"); }
/*     */ 
/*     */     
/* 118 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/* 123 */     return Game.i.localeManager.i18n.get("item_description_BLUEPRINT");
/*     */   }
/*     */   
/*     */   public BlueprintType getBlueprintType() {
/* 127 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/* 132 */     switch (null.a[this.a.ordinal()]) { case 1:
/*     */       case 2:
/*     */       case 3:
/* 135 */         return RarityType.COMMON;
/* 136 */       case 4: return RarityType.RARE;
/* 137 */       case 5: return RarityType.VERY_RARE;
/* 138 */       case 6: return RarityType.EPIC;
/* 139 */       case 7: return RarityType.LEGENDARY; }
/*     */ 
/*     */     
/* 142 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/* 147 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 152 */     super.toJson(paramJson);
/*     */     
/* 154 */     paramJson.writeValue("blueprintType", this.a.name());
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 159 */     return "BlueprintItem@" + Integer.toHexString(hashCode()) + " (type: " + this.a.name() + ")";
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/* 164 */     return ItemType.BLUEPRINT;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/* 169 */     return ItemCategoryType.MATERIALS;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/* 174 */     return ItemSubcategoryType.M_BLUEPRINT;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/* 179 */     return "blueprint_" + this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public Drawable getIconDrawable() {
/* 184 */     return BlueprintItemFactory.a(Item.D.F_BLUEPRINT)[this.a.ordinal()];
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/* 189 */     if (paramBoolean) {
/*     */       Group group;
/* 191 */       (group = new Group()).setTransform(false);
/* 192 */       group.setSize(paramFloat, paramFloat);
/*     */       
/*     */       Image image1;
/* 195 */       (image1 = new Image(BlueprintItemFactory.b(Item.D.F_BLUEPRINT)[this.a.ordinal()])).setSize(paramFloat, paramFloat);
/* 196 */       image1.setPosition(a(paramFloat), -a(paramFloat));
/* 197 */       image1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 198 */       group.addActor((Actor)image1);
/*     */ 
/*     */       
/* 201 */       (image1 = new Image(BlueprintItemFactory.b(Item.D.F_BLUEPRINT)[this.a.ordinal()])).setSize(paramFloat, paramFloat);
/* 202 */       group.addActor((Actor)image1);
/*     */       
/* 204 */       return (Actor)group;
/*     */     } 
/*     */     Image image;
/* 207 */     (image = new Image(BlueprintItemFactory.b(Item.D.F_BLUEPRINT)[this.a.ordinal()])).setSize(paramFloat, paramFloat);
/*     */     
/* 209 */     return (Actor)image;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean sameAs(Item paramItem) {
/* 215 */     if (!super.sameAs(paramItem)) return false;
/*     */ 
/*     */ 
/*     */     
/* 219 */     if (((BlueprintItem)(paramItem = paramItem)).a != this.a) return false;
/*     */     
/* 221 */     return true;
/*     */   }
/*     */   
/*     */   public static class BlueprintItemFactory implements Item.Factory<BlueprintItem> {
/* 225 */     private BlueprintItem[] a = new BlueprintItem[BlueprintType.values.length];
/* 226 */     private TextureRegion[] b = new TextureRegion[BlueprintType.values.length];
/* 227 */     private Drawable[] c = new Drawable[BlueprintType.values.length];
/*     */     public BlueprintItemFactory() {
/*     */       BlueprintType[] arrayOfBlueprintType;
/*     */       int i;
/*     */       byte b;
/* 232 */       for (i = (arrayOfBlueprintType = BlueprintType.values).length, b = 0; b < i; ) { BlueprintType blueprintType = arrayOfBlueprintType[b];
/* 233 */         this.a[blueprintType.ordinal()] = new BlueprintItem(blueprintType, (byte)0);
/*     */         b++; }
/*     */     
/*     */     }
/*     */ 
/*     */     
/*     */     public void setup() {
/* 240 */       if (Game.i.assetManager != null) {
/* 241 */         BlueprintType[] arrayOfBlueprintType; int i; byte b; for (i = (arrayOfBlueprintType = BlueprintType.values).length, b = 0; b < i; ) { BlueprintType blueprintType = arrayOfBlueprintType[b];
/* 242 */           this.b[blueprintType.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion("blueprint-" + blueprintType.name());
/* 243 */           this.c[blueprintType.ordinal()] = (Drawable)new TextureRegionDrawable(this.b[blueprintType.ordinal()]);
/*     */           b++; }
/*     */       
/*     */       } 
/*     */     }
/*     */     public BlueprintItem create(BlueprintType param1BlueprintType) {
/* 249 */       return this.a[param1BlueprintType.ordinal()];
/*     */     }
/*     */ 
/*     */     
/*     */     public BlueprintItem fromJson(JsonValue param1JsonValue) {
/* 254 */       return create(BlueprintType.valueOf(param1JsonValue.getString("blueprintType")));
/*     */     }
/*     */ 
/*     */     
/*     */     public BlueprintItem createDefault() {
/* 259 */       return create(BlueprintType.values[0]);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\BlueprintItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */