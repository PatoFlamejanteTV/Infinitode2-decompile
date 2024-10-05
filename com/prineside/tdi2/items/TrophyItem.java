/*     */ package com.prineside.tdi2.items;
/*     */ 
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.enums.ItemDataType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.TrophyType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.SelectBox;
/*     */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.ui.shared.ItemCreationOverlay;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(serializer = TrophyItem.Serializer.class)
/*     */ public class TrophyItem extends Item {
/*     */   public final TrophyType trophyType;
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<TrophyItem> { public void write(Kryo param1Kryo, Output param1Output, TrophyItem param1TrophyItem) {
/*  33 */       param1Kryo.writeObject(param1Output, param1TrophyItem.trophyType);
/*     */     }
/*     */ 
/*     */     
/*     */     public TrophyItem read(Kryo param1Kryo, Input param1Input, Class<? extends TrophyItem> param1Class) {
/*  38 */       return Item.D.F_TROPHY.create((TrophyType)param1Kryo.readObject(param1Input, TrophyType.class));
/*     */     }
/*     */     
/*     */     public TrophyItem read() {
/*  42 */       throw new IllegalStateException("Do not use");
/*     */     } }
/*     */   
/*     */   private TrophyItem(TrophyType paramTrophyType) {
/*  46 */     if (paramTrophyType == null) throw new IllegalArgumentException("TrophyType is null"); 
/*  47 */     this.trophyType = paramTrophyType;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item from(Item paramItem) {
/*  52 */     return Item.D.F_TROPHY.create(((TrophyItem)paramItem).trophyType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IntArray getData() {
/*     */     IntArray intArray;
/*  59 */     (intArray = super.getData()).add(ItemDataType.TYPE.ordinal(), this.trophyType.ordinal());
/*     */     
/*  61 */     return intArray;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item cpy() {
/*  66 */     return Item.D.F_TROPHY.create(this.trophyType);
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/*  71 */     return ItemType.TROPHY;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/*  76 */     return ItemCategoryType.OTHER;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/*  81 */     return ItemSubcategoryType.O_OTHER;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/*  86 */     return Game.i.localeManager.i18n.get("item_title_TROPHY");
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/*  91 */     return Game.i.trophyManager.getConfig(this.trophyType).getTitle();
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/*  96 */     return RarityType.EPIC;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/* 101 */     return "trophy";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/* 106 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean sameAs(Item paramItem) {
/* 111 */     if (!super.sameAs(paramItem)) return false;
/*     */     
/* 113 */     return (((TrophyItem)paramItem).trophyType == this.trophyType);
/*     */   }
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 118 */     super.toJson(paramJson);
/*     */     
/* 120 */     paramJson.writeValue("trophyType", this.trophyType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/* 127 */     if (Game.i.trophyManager.getConfig(this.trophyType).isReceived()) {
/*     */       Image image1;
/*     */       
/* 130 */       (image1 = new Image(Game.i.trophyManager.getConfig(this.trophyType).getIconTexture())).setSize(paramFloat, paramFloat);
/*     */       
/* 132 */       return (Actor)image1;
/*     */     } 
/*     */     
/*     */     Group group;
/* 136 */     (group = new Group()).setTransform(false);
/*     */     
/* 138 */     group.setSize(paramFloat, paramFloat);
/*     */     
/*     */     Image image;
/* 141 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-question"))).setSize(paramFloat, paramFloat);
/* 142 */     group.addActor((Actor)image);
/*     */     
/* 144 */     return (Actor)group;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void fillItemCreationForm(ItemCreationOverlay paramItemCreationOverlay) {
/* 150 */     paramItemCreationOverlay.label("Trophy type");
/*     */     
/*     */     SelectBox selectBox;
/* 153 */     (selectBox = new SelectBox(paramItemCreationOverlay.selectBoxStyle)).setItems((Object[])TrophyType.values);
/* 154 */     selectBox.setSelected(this.trophyType);
/* 155 */     selectBox.addListener((EventListener)new ChangeListener(this, paramItemCreationOverlay, selectBox)
/*     */         {
/*     */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 158 */             this.a.currentItem = Item.D.F_TROPHY.create((TrophyType)this.b
/* 159 */                 .getSelected());
/*     */             
/* 161 */             this.a.updateForm();
/*     */           }
/*     */         });
/* 164 */     paramItemCreationOverlay.selectBox(selectBox);
/*     */   }
/*     */   
/*     */   public static class TrophyItemFactory implements Item.Factory<TrophyItem> {
/* 168 */     private final TrophyItem[] a = new TrophyItem[TrophyType.values.length]; public TrophyItemFactory() { TrophyType[] arrayOfTrophyType;
/*     */       int i;
/*     */       byte b;
/* 171 */       for (i = (arrayOfTrophyType = TrophyType.values).length, b = 0; b < i; ) { TrophyType trophyType = arrayOfTrophyType[b];
/* 172 */         this.a[trophyType.ordinal()] = new TrophyItem(trophyType, (byte)0);
/*     */         b++; }
/*     */        }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setup() {}
/*     */     
/*     */     public TrophyItem create(TrophyType param1TrophyType) {
/* 181 */       return this.a[param1TrophyType.ordinal()];
/*     */     }
/*     */ 
/*     */     
/*     */     public TrophyItem fromJson(JsonValue param1JsonValue) {
/* 186 */       return create(TrophyType.valueOf(param1JsonValue.getString("trophyType")));
/*     */     }
/*     */ 
/*     */     
/*     */     public TrophyItem createDefault() {
/* 191 */       return create(TrophyType.values[0]);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\TrophyItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */