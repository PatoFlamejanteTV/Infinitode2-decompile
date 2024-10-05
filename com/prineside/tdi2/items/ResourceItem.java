/*     */ package com.prineside.tdi2.items;
/*     */ 
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
/*     */ import com.prineside.tdi2.Resource;
/*     */ import com.prineside.tdi2.enums.BlueprintType;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.enums.ItemDataType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(serializer = ResourceItem.Serializer.class)
/*     */ public class ResourceItem
/*     */   extends Item {
/*     */   public final ResourceType resourceType;
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<ResourceItem> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, ResourceItem param1ResourceItem) {
/*  35 */       param1Kryo.writeObject(param1Output, param1ResourceItem.resourceType);
/*     */     }
/*     */ 
/*     */     
/*     */     public ResourceItem read(Kryo param1Kryo, Input param1Input, Class<? extends ResourceItem> param1Class) {
/*  40 */       return Item.D.F_RESOURCE.create((ResourceType)param1Kryo.readObject(param1Input, ResourceType.class));
/*     */     }
/*     */     
/*     */     public ResourceItem read() {
/*  44 */       throw new IllegalStateException("Do not use");
/*     */     } }
/*     */   
/*     */   private ResourceItem(ResourceType paramResourceType) {
/*  48 */     if (paramResourceType == null) throw new IllegalArgumentException("ResourceType is null");
/*     */     
/*  50 */     this.resourceType = paramResourceType;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAffectedByDoubleGain() {
/*  55 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item from(Item paramItem) {
/*  60 */     return Item.D.F_RESOURCE.create(((ResourceItem)paramItem).resourceType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IntArray getData() {
/*     */     IntArray intArray;
/*  67 */     (intArray = super.getData()).add(ItemDataType.TYPE.ordinal(), this.resourceType.ordinal());
/*     */     
/*  69 */     return intArray;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item cpy() {
/*  74 */     return Item.D.F_RESOURCE.create(this.resourceType);
/*     */   }
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/*  79 */     super.toJson(paramJson);
/*     */     
/*  81 */     paramJson.writeValue("resourceType", this.resourceType.name());
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  86 */     return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (type: " + this.resourceType.name() + ")";
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  91 */     return "resource_" + this.resourceType;
/*     */   }
/*     */   
/*     */   public boolean canBeSold() {
/*  95 */     return true;
/*     */   }
/*     */   
/*     */   public void addSellItems(Array<ItemStack> paramArray) {
/*  99 */     byte b = 1;
/* 100 */     switch (null.a[this.resourceType.ordinal()]) { case 1:
/* 101 */         b = 4; break;
/* 102 */       case 2: b = 6; break;
/* 103 */       case 3: b = 8; break;
/* 104 */       case 4: b = 10; break;
/* 105 */       case 5: b = 12; break; }
/*     */     
/* 107 */     paramArray.add(new ItemStack(Item.D.GREEN_PAPER, b));
/*     */   }
/*     */ 
/*     */   
/*     */   public double getPriceInAcceleratorsForResearchReset(int paramInt) {
/* 112 */     int i = paramInt;
/* 113 */     switch (null.a[this.resourceType.ordinal()]) { case 1:
/* 114 */         i = 4 * paramInt; break;
/* 115 */       case 2: i = paramInt * 6; break;
/* 116 */       case 3: i = paramInt * 8; break;
/* 117 */       case 4: i = paramInt * 10; break;
/* 118 */       case 5: i = paramInt * 12;
/*     */         break; }
/*     */     
/* 121 */     return Item.D.GREEN_PAPER.getPriceInAcceleratorsForResearchReset(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/* 126 */     return ItemType.RESOURCE;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/* 131 */     return ItemCategoryType.MATERIALS;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/* 136 */     return ItemSubcategoryType.M_RESOURCE;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/* 141 */     return Game.i.resourceManager.getName(this.resourceType);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/* 146 */     return Game.i.localeManager.i18n.get("item_description_RESOURCE");
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/* 151 */     switch (null.a[this.resourceType.ordinal()]) { case 1:
/* 152 */         return RarityType.COMMON;
/* 153 */       case 2: return RarityType.RARE;
/* 154 */       case 3: return RarityType.VERY_RARE;
/* 155 */       case 4: return RarityType.EPIC;
/* 156 */       case 5: return RarityType.LEGENDARY; }
/*     */ 
/*     */     
/* 159 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/* 164 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean sameAs(Item paramItem) {
/* 169 */     if (!super.sameAs(paramItem)) return false;
/*     */     
/* 171 */     return (((ResourceItem)paramItem).resourceType == this.resourceType);
/*     */   }
/*     */ 
/*     */   
/*     */   public Drawable getIconDrawable() {
/* 176 */     return ResourceItemFactory.a(Item.D.F_RESOURCE)[this.resourceType.ordinal()];
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/* 181 */     if (paramBoolean) {
/*     */       Group group;
/* 183 */       (group = new Group()).setTransform(false);
/* 184 */       group.setSize(paramFloat, paramFloat);
/*     */       
/*     */       Image image1;
/* 187 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable(Resource.TEXTURE_REGION_NAMES[this.resourceType.ordinal()]))).setSize(paramFloat, paramFloat);
/* 188 */       image1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 189 */       image1.setPosition(a(paramFloat), -a(paramFloat));
/* 190 */       group.addActor((Actor)image1);
/*     */ 
/*     */       
/* 193 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable(Resource.TEXTURE_REGION_NAMES[this.resourceType.ordinal()]))).setSize(paramFloat, paramFloat);
/* 194 */       image1.setColor(Game.i.resourceManager.getColor(this.resourceType));
/* 195 */       group.addActor((Actor)image1);
/*     */       
/* 197 */       return (Actor)group;
/*     */     } 
/*     */     Image image;
/* 200 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable(Resource.TEXTURE_REGION_NAMES[this.resourceType.ordinal()]))).setSize(paramFloat, paramFloat);
/* 201 */     image.setColor(Game.i.resourceManager.getColor(this.resourceType));
/*     */     
/* 203 */     return (Actor)image;
/*     */   }
/*     */   
/*     */   public static class ResourceItemFactory
/*     */     implements Item.Factory<ResourceItem> {
/* 208 */     private final ResourceItem[] a = new ResourceItem[ResourceType.values.length];
/* 209 */     private Drawable[] b = new Drawable[BlueprintType.values.length]; public ResourceItemFactory() { ResourceType[] arrayOfResourceType;
/*     */       int i;
/*     */       byte b;
/* 212 */       for (i = (arrayOfResourceType = ResourceType.values).length, b = 0; b < i; ) { ResourceType resourceType = arrayOfResourceType[b];
/* 213 */         this.a[resourceType.ordinal()] = new ResourceItem(resourceType, (byte)0);
/*     */         b++; }
/*     */        }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setup() {
/* 220 */       if (Game.i.assetManager != null) {
/* 221 */         ResourceType[] arrayOfResourceType; int i; byte b; for (i = (arrayOfResourceType = ResourceType.values).length, b = 0; b < i; ) { ResourceType resourceType = arrayOfResourceType[b];
/* 222 */           this.b[resourceType.ordinal()] = Game.i.assetManager.getDrawable(Resource.TEXTURE_REGION_NAMES[resourceType.ordinal()]).tint(Game.i.resourceManager.getColor(resourceType));
/*     */           b++; }
/*     */       
/*     */       } 
/*     */     }
/*     */     public ResourceItem create(ResourceType param1ResourceType) {
/* 228 */       return this.a[param1ResourceType.ordinal()];
/*     */     }
/*     */ 
/*     */     
/*     */     public ResourceItem fromJson(JsonValue param1JsonValue) {
/* 233 */       return create(ResourceType.valueOf(param1JsonValue.getString("resourceType")));
/*     */     }
/*     */ 
/*     */     
/*     */     public ResourceItem createDefault() {
/* 238 */       return create(ResourceType.values[0]);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\ResourceItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */