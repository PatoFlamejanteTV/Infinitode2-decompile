/*     */ package com.prineside.tdi2.items;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.ResearchType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(serializer = OpenedResearchItem.Serializer.class)
/*     */ public class OpenedResearchItem
/*     */   extends Item {
/*     */   public final ResearchType researchType;
/*     */   
/*     */   public static class Serializer extends com.esotericsoftware.kryo.Serializer<OpenedResearchItem> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, OpenedResearchItem param1OpenedResearchItem) {
/*  30 */       param1Kryo.writeObject(param1Output, param1OpenedResearchItem.researchType);
/*     */     }
/*     */ 
/*     */     
/*     */     public OpenedResearchItem read(Kryo param1Kryo, Input param1Input, Class<? extends OpenedResearchItem> param1Class) {
/*  35 */       return Item.D.F_OPENED_RESEARCH.create((ResearchType)param1Kryo.readObject(param1Input, ResearchType.class));
/*     */     }
/*     */   }
/*     */   
/*     */   private OpenedResearchItem(ResearchType paramResearchType) {
/*  40 */     if (paramResearchType == null) throw new IllegalArgumentException("ResearchType is null"); 
/*  41 */     this.researchType = paramResearchType;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item from(Item paramItem) {
/*  46 */     return Item.D.F_OPENED_RESEARCH.create(((OpenedResearchItem)paramItem).researchType);
/*     */   }
/*     */ 
/*     */   
/*     */   public Item cpy() {
/*  51 */     return Item.D.F_OPENED_RESEARCH.create(this.researchType);
/*     */   }
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/*  56 */     super.toJson(paramJson);
/*     */     
/*  58 */     paramJson.writeValue("researchType", this.researchType.name());
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/*  63 */     return (CharSequence)Game.i.researchManager.getResearchInstance(this.researchType).getTitle();
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/*  68 */     return Game.i.localeManager.i18n.get("item_description_OPENED_RESEARCH");
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/*  73 */     return RarityType.LEGENDARY;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  78 */     return "opened_research";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/*  83 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/*  88 */     return ItemType.OPENED_RESEARCH;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/*  93 */     return ItemCategoryType.OTHER;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/*  98 */     return ItemSubcategoryType.O_OTHER;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean sameAs(Item paramItem) {
/* 103 */     if (!super.sameAs(paramItem)) return false;
/*     */ 
/*     */ 
/*     */     
/* 107 */     if (((OpenedResearchItem)(paramItem = paramItem)).researchType != this.researchType) return false;
/*     */     
/* 109 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/*     */     Group group;
/* 115 */     (group = new Group()).setTransform(false);
/*     */     
/* 117 */     group.setSize(paramFloat, paramFloat);
/*     */     
/* 119 */     Drawable drawable = (Game.i.researchManager.getResearchInstance(this.researchType)).category.getIcon();
/*     */     Image image;
/* 121 */     (image = new Image(drawable)).setSize(paramFloat, paramFloat);
/* 122 */     group.addActor((Actor)image);
/*     */ 
/*     */     
/* 125 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-research"))).setSize(paramFloat * 0.4F, paramFloat * 0.4F);
/* 126 */     image.setPosition(5.0F, paramFloat * 0.6F - 5.0F);
/* 127 */     image.setColor(Config.BACKGROUND_COLOR);
/* 128 */     group.addActor((Actor)image);
/*     */ 
/*     */     
/* 131 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-research"))).setSize(paramFloat * 0.4F, paramFloat * 0.4F);
/* 132 */     image.setPosition(0.0F, paramFloat * 0.6F);
/* 133 */     image.setColor(MaterialColor.CYAN.P500);
/* 134 */     group.addActor((Actor)image);
/*     */     
/* 136 */     return (Actor)group;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class OpenedResearchItemFactory
/*     */     implements Item.Factory<OpenedResearchItem>
/*     */   {
/*     */     public void setup() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public OpenedResearchItem create(ResearchType param1ResearchType) {
/* 150 */       return new OpenedResearchItem(param1ResearchType, (byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public OpenedResearchItem fromJson(JsonValue param1JsonValue) {
/* 155 */       return create(ResearchType.valueOf(param1JsonValue.getString("researchType")));
/*     */     }
/*     */ 
/*     */     
/*     */     public OpenedResearchItem createDefault() {
/* 160 */       return create(ResearchType.values[0]);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\OpenedResearchItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */