/*     */ package com.prineside.tdi2.items;
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
/*     */ import com.prineside.tdi2.Screen;
/*     */ import com.prineside.tdi2.enums.CaseType;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.enums.ItemDataType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.screens.MoneyScreen;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS(serializer = CaseKeyItem.Serializer.class)
/*     */ public class CaseKeyItem extends Item implements Item.UsableItem {
/*  31 */   private static final TLog a = TLog.forClass(CaseKeyItem.class);
/*     */   public CaseType caseType;
/*     */   
/*     */   public static class Serializer
/*     */     extends SingletonSerializer<CaseKeyItem>
/*     */   {
/*     */     public void write(Kryo param1Kryo, Output param1Output, CaseKeyItem param1CaseKeyItem) {
/*  38 */       param1Kryo.writeObject(param1Output, param1CaseKeyItem.caseType);
/*     */     }
/*     */ 
/*     */     
/*     */     public CaseKeyItem read(Kryo param1Kryo, Input param1Input, Class<? extends CaseKeyItem> param1Class) {
/*  43 */       return Item.D.F_CASE_KEY.create((CaseType)param1Kryo.readObject(param1Input, CaseType.class));
/*     */     }
/*     */     
/*     */     public CaseKeyItem read() {
/*  47 */       throw new IllegalStateException("Do not use");
/*     */     } }
/*     */   
/*     */   private CaseKeyItem(CaseType paramCaseType) {
/*  51 */     if (paramCaseType == null) throw new IllegalArgumentException("caseType is null");
/*     */     
/*  53 */     this.caseType = paramCaseType;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAffectedByDoubleGain() {
/*  58 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item from(Item paramItem) {
/*  63 */     return Item.D.F_CASE_KEY.create(((CaseKeyItem)paramItem).caseType);
/*     */   }
/*     */   
/*     */   public boolean canBeSold() {
/*  67 */     return true;
/*     */   }
/*     */   
/*     */   public String getAnalyticName() {
/*  71 */     return "case_key_" + this.caseType;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addSellItems(Array<ItemStack> paramArray) {
/*  76 */     char c = '\001';
/*     */     
/*  78 */     switch (null.a[this.caseType.ordinal()]) { case 1:
/*  79 */         c = 'Ĭ'; break;
/*  80 */       case 2: c = 'Ǵ'; break;
/*  81 */       case 3: c = '̠'; break;
/*  82 */       case 4: c = 'Ұ'; break;
/*  83 */       case 5: c = 'ߐ'; break;
/*  84 */       case 6: c = 'Ĭ';
/*     */         break; }
/*     */     
/*  87 */     paramArray.add(new ItemStack(Item.D.GREEN_PAPER, c));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IntArray getData() {
/*     */     IntArray intArray;
/*  94 */     (intArray = super.getData()).add(ItemDataType.TYPE.ordinal(), this.caseType.ordinal());
/*     */     
/*  96 */     return intArray;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/* 101 */     return ItemType.CASE_KEY;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/* 106 */     return ItemCategoryType.PACKS;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/* 111 */     return ItemSubcategoryType.P_DECRYPTED;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/* 116 */     String str = "case_key_title_" + this.caseType.name();
/* 117 */     return Game.i.localeManager.i18n.get(str);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/* 122 */     return Game.i.localeManager.i18n.get("item_description_CASE_KEY");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean sameAs(Item paramItem) {
/* 127 */     if (!super.sameAs(paramItem)) return false;
/*     */     
/* 129 */     paramItem = paramItem;
/*     */     
/* 131 */     if (this.caseType != ((CaseKeyItem)paramItem).caseType) return false;
/*     */     
/* 133 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/* 138 */     return Item.D.F_CASE.create(this.caseType, true).getRarity();
/*     */   }
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 143 */     super.toJson(paramJson);
/*     */     
/* 145 */     paramJson.writeValue("caseType", this.caseType.name());
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/* 150 */     Image image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-key"));
/* 151 */     switch (null.a[this.caseType.ordinal()]) {
/*     */       case 1:
/* 153 */         image.setColor(MaterialColor.GREEN.P300);
/*     */         break;
/*     */       case 2:
/* 156 */         image.setColor(MaterialColor.INDIGO.P300);
/*     */         break;
/*     */       case 3:
/* 159 */         image.setColor(MaterialColor.PURPLE.P300);
/*     */         break;
/*     */       case 4:
/* 162 */         image.setColor(MaterialColor.ORANGE.P300);
/*     */         break;
/*     */       case 5:
/* 165 */         image.setColor(MaterialColor.CYAN.P300);
/*     */         break;
/*     */     } 
/* 168 */     image.setSize(paramFloat, paramFloat);
/*     */     
/* 170 */     if (paramBoolean) {
/*     */       Group group;
/* 172 */       (group = new Group()).setTransform(false);
/* 173 */       group.setSize(paramFloat, paramFloat);
/*     */       
/*     */       Image image1;
/* 176 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-key"))).setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 177 */       image1.setSize(paramFloat, paramFloat);
/* 178 */       image1.setPosition(a(paramFloat), -a(paramFloat));
/* 179 */       group.addActor((Actor)image1);
/* 180 */       group.addActor((Actor)image);
/*     */       
/* 182 */       return (Actor)group;
/*     */     } 
/* 184 */     return (Actor)image;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/* 190 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean autoUseWhenAdded() {
/* 195 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useItem() {
/* 200 */     Game.i.screenManager.goToMoneyScreen();
/*     */     
/* 202 */     String str = "spend_keys_" + this.caseType.name();
/* 203 */     Game.i.uiManager.runOnStageActOnce(() -> {
/*     */           Screen screen;
/*     */           
/*     */           if (screen = Game.i.screenManager.getCurrentScreen() instanceof MoneyScreen) {
/*     */             MoneyScreen moneyScreen;
/*     */             (moneyScreen = (MoneyScreen)screen).scrollToActor(paramString);
/*     */             return;
/*     */           } 
/*     */           a.i("warning: current screen is not a shop", new Object[0]);
/*     */         });
/* 213 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useItemNeedsConfirmation() {
/* 218 */     return false;
/*     */   }
/*     */   
/*     */   public static class CaseKeyItemFactory implements Item.Factory<CaseKeyItem> {
/* 222 */     private final CaseKeyItem[] a = new CaseKeyItem[CaseType.values.length]; public CaseKeyItemFactory() { CaseType[] arrayOfCaseType;
/*     */       int i;
/*     */       byte b;
/* 225 */       for (i = (arrayOfCaseType = CaseType.values).length, b = 0; b < i; ) { CaseType caseType = arrayOfCaseType[b];
/* 226 */         this.a[caseType.ordinal()] = new CaseKeyItem(caseType, (byte)0);
/*     */         b++; }
/*     */        }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setup() {}
/*     */ 
/*     */     
/*     */     public CaseKeyItem create(CaseType param1CaseType) {
/* 236 */       return this.a[param1CaseType.ordinal()];
/*     */     }
/*     */ 
/*     */     
/*     */     public CaseKeyItem fromJson(JsonValue param1JsonValue) {
/* 241 */       return create(CaseType.valueOf(param1JsonValue.getString("caseType")));
/*     */     }
/*     */ 
/*     */     
/*     */     public CaseKeyItem createDefault() {
/* 246 */       return create(CaseType.BLUE);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\CaseKeyItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */