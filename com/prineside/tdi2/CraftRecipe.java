/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ItemDataType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ 
/*     */ 
/*     */ public class CraftRecipe
/*     */ {
/*     */   private float a;
/*  15 */   private int b = 1;
/*     */   
/*  17 */   public Array<Ingredient> ingredients = new Array(Ingredient.class);
/*     */   
/*     */   public boolean isAvailable() {
/*  20 */     return true;
/*     */   }
/*     */   
/*     */   public ItemStack result;
/*     */   
/*     */   public boolean hasEnoughItemsToRun() {
/*  26 */     for (byte b = 0; b < this.ingredients.size; b++) {
/*     */       Ingredient ingredient;
/*  28 */       Array<ItemStack> array = (ingredient = ((Ingredient[])this.ingredients.items)[b]).getSuitableItemsFromInventory();
/*  29 */       boolean bool = false;
/*  30 */       for (byte b1 = 0; b1 < array.size; b1++) {
/*  31 */         if (((ItemStack[])array.items)[b1].getCount() >= ingredient.getCountWithGVs()) {
/*  32 */           bool = true;
/*     */           break;
/*     */         } 
/*     */       } 
/*  36 */       if (!bool) return false;
/*     */     
/*     */     } 
/*  39 */     return true;
/*     */   }
/*     */   
/*     */   public void setStockTime(float paramFloat) {
/*  43 */     this.a = paramFloat;
/*     */   }
/*     */   
/*     */   public void setStockMaxQueueStack(int paramInt) {
/*  47 */     this.b = paramInt;
/*     */   }
/*     */   
/*     */   public float getTimeWithGVs() {
/*  51 */     return Math.max(this.a * (float)Game.i.gameValueManager.getSnapshot().getPercentValueAsMultiplier(GameValueType.CRAFTING_TIME), 0.1F);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxQueueStackWithGVs() {
/*     */     int i;
/*  57 */     if ((i = (i = Math.max(MathUtils.round(this.b * (float)Game.i.gameValueManager.getSnapshot().getPercentValueAsMultiplier(GameValueType.CRAFTING_MAX_STACK)), 1)) * 250) > 1000000) i = 1000000; 
/*  58 */     return i;
/*     */   }
/*     */   
/*     */   public static class Ingredient {
/*     */     public ItemType itemType;
/*  63 */     public RarityType itemRarity = null;
/*     */ 
/*     */     
/*  66 */     public int[] itemParams = null;
/*     */ 
/*     */     
/*     */     public int count;
/*     */ 
/*     */     
/*  72 */     public int minCount = 1;
/*     */     
/*     */     public boolean ignoresDiscounts;
/*     */     
/*     */     public Item[] exampleItems;
/*  77 */     private static final Array<ItemStack> a = new Array(ItemStack.class);
/*     */     
/*     */     public Item[] getExampleItems() {
/*  80 */       if (this.exampleItems == null) {
/*     */         
/*  82 */         this.exampleItems = new Item[1];
/*  83 */         this.exampleItems[0] = Game.i.itemManager.getFactory(this.itemType).createDefault();
/*     */       } 
/*     */       
/*  86 */       return this.exampleItems;
/*     */     }
/*     */     
/*     */     public Ingredient(ItemType param1ItemType, int param1Int, RarityType param1RarityType) {
/*  90 */       this.itemType = param1ItemType;
/*  91 */       this.count = param1Int;
/*  92 */       this.itemRarity = param1RarityType;
/*     */     }
/*     */     
/*     */     public Ingredient(ItemType param1ItemType, int param1Int, RarityType param1RarityType, int[] param1ArrayOfint) {
/*  96 */       this.itemType = param1ItemType;
/*  97 */       this.count = param1Int;
/*  98 */       this.itemRarity = param1RarityType;
/*  99 */       this.itemParams = param1ArrayOfint;
/*     */     }
/*     */     
/*     */     public Ingredient(ItemType param1ItemType, int param1Int, int[] param1ArrayOfint) {
/* 103 */       this.itemType = param1ItemType;
/* 104 */       this.count = param1Int;
/* 105 */       this.itemParams = param1ArrayOfint;
/*     */     }
/*     */     
/*     */     public Ingredient(ItemType param1ItemType, int param1Int) {
/* 109 */       this.itemType = param1ItemType;
/* 110 */       this.count = param1Int;
/*     */     }
/*     */     
/*     */     public int getCountWithGVs() {
/* 114 */       if (this.ignoresDiscounts) {
/* 115 */         return this.count;
/*     */       }
/*     */       
/* 118 */       double d1 = Game.i.gameValueManager.getSnapshot().getPercentValueAsMultiplier(GameValueType.CRAFTING_PRICE);
/*     */       int i;
/*     */       double d2;
/* 121 */       if ((i = MathUtils.round((float)(d2 = this.count * d1))) < this.minCount) i = this.minCount; 
/* 122 */       return i;
/*     */     }
/*     */     
/*     */     public boolean fits(Item param1Item) {
/* 126 */       if (param1Item.getType() != this.itemType) return false; 
/* 127 */       if (this.itemRarity != null && param1Item.getRarity() != this.itemRarity) return false; 
/* 128 */       if (this.itemParams != null) {
/* 129 */         for (byte b = 0; b < this.itemParams.length; b += 2) {
/*     */           int i;
/* 131 */           if ((i = this.itemParams[b + 1]) != Integer.MIN_VALUE)
/*     */           {
/* 133 */             if (param1Item.getDataOfType(ItemDataType.values[this.itemParams[b]]) != i) {
/* 134 */               return false;
/*     */             }
/*     */           }
/*     */         } 
/*     */       }
/* 139 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Array<ItemStack> getSuitableItemsFromInventory() {
/* 146 */       a.clear();
/* 147 */       DelayedRemovalArray delayedRemovalArray = Game.i.progressManager.getItemsByType(this.itemType);
/* 148 */       for (byte b = 0; b < ((Array)delayedRemovalArray).size; b++) {
/* 149 */         Item item = ((ItemStack[])((Array)delayedRemovalArray).items)[b].getItem();
/* 150 */         if (fits(item)) {
/* 151 */           a.add(((ItemStack[])((Array)delayedRemovalArray).items)[b]);
/*     */         }
/*     */       } 
/*     */       
/* 155 */       return a;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\CraftRecipe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */