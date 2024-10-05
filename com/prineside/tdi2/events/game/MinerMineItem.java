/*     */ package com.prineside.tdi2.events.game;
/*     */ 
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Miner;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.events.StoppableEvent;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS(classOnly = true)
/*     */ public final class MinerMineItem
/*     */   extends StoppableEvent
/*     */ {
/*     */   private Miner a;
/*     */   private ResourceType b;
/*     */   private ItemStack c;
/*     */   private float d;
/*     */   private RarityType e;
/*     */   private float f;
/*     */   private boolean g = true;
/*     */   private boolean h = true;
/*     */   private boolean i = true;
/*     */   private boolean j;
/*     */   
/*     */   public MinerMineItem(Miner paramMiner, ResourceType paramResourceType, ItemStack paramItemStack, float paramFloat1, RarityType paramRarityType, float paramFloat2) {
/*  34 */     setMiner(paramMiner);
/*  35 */     setResourceType(paramResourceType);
/*  36 */     setItemStack(paramItemStack);
/*  37 */     setQuality(paramFloat1);
/*  38 */     setRarity(paramRarityType);
/*  39 */     setRarityQuality(paramFloat2);
/*  40 */     setCountTowardsInventoryStatistics(this.g);
/*  41 */     setAddAndShowActualLoot(this.h);
/*  42 */     setAddToEmptyItemSlot(this.i);
/*  43 */     this.g = true;
/*  44 */     this.h = true;
/*  45 */     this.i = true;
/*  46 */     this.j = false;
/*     */   }
/*     */   
/*     */   public final Miner getMiner() {
/*  50 */     return this.a;
/*     */   }
/*     */   
/*     */   public final MinerMineItem setMiner(Miner paramMiner) {
/*  54 */     Preconditions.checkNotNull(paramMiner);
/*  55 */     this.a = paramMiner;
/*  56 */     return this;
/*     */   }
/*     */   
/*     */   public final ResourceType getResourceType() {
/*  60 */     return this.b;
/*     */   }
/*     */   
/*     */   public final MinerMineItem setResourceType(ResourceType paramResourceType) {
/*  64 */     Preconditions.checkNotNull(paramResourceType);
/*  65 */     this.b = paramResourceType;
/*  66 */     return this;
/*     */   }
/*     */   
/*     */   public final ItemStack getItemStack() {
/*  70 */     return this.c;
/*     */   }
/*     */   
/*     */   public final MinerMineItem setItemStack(ItemStack paramItemStack) {
/*  74 */     Preconditions.checkNotNull(paramItemStack);
/*  75 */     this.c = paramItemStack;
/*  76 */     return this;
/*     */   }
/*     */   
/*     */   public final float getQuality() {
/*  80 */     return this.d;
/*     */   }
/*     */   
/*     */   public final MinerMineItem setQuality(float paramFloat) {
/*  84 */     Preconditions.checkArgument((paramFloat >= 0.0F && paramFloat <= 10.0F && PMath.isFinite(paramFloat)));
/*  85 */     this.d = paramFloat;
/*  86 */     return this;
/*     */   }
/*     */   
/*     */   public final RarityType getRarity() {
/*  90 */     return this.e;
/*     */   }
/*     */   
/*     */   public final MinerMineItem setRarity(RarityType paramRarityType) {
/*  94 */     Preconditions.checkNotNull(paramRarityType);
/*  95 */     this.e = paramRarityType;
/*  96 */     return this;
/*     */   }
/*     */   
/*     */   public final float getRarityQuality() {
/* 100 */     return this.f;
/*     */   }
/*     */   
/*     */   public final MinerMineItem setRarityQuality(float paramFloat) {
/* 104 */     Preconditions.checkArgument((paramFloat >= 0.0F && paramFloat <= 10.0F && PMath.isFinite(paramFloat)));
/* 105 */     this.f = paramFloat;
/* 106 */     return this;
/*     */   }
/*     */   
/*     */   public final boolean isCountTowardsInventoryStatistics() {
/* 110 */     return this.g;
/*     */   }
/*     */   
/*     */   public final MinerMineItem setCountTowardsInventoryStatistics(boolean paramBoolean) {
/* 114 */     this.g = paramBoolean;
/* 115 */     return this;
/*     */   }
/*     */   
/*     */   public final boolean isAddAndShowActualLoot() {
/* 119 */     return this.h;
/*     */   }
/*     */   
/*     */   public final MinerMineItem setAddAndShowActualLoot(boolean paramBoolean) {
/* 123 */     this.h = paramBoolean;
/* 124 */     return this;
/*     */   }
/*     */   
/*     */   public final boolean isAddToEmptyItemSlot() {
/* 128 */     return this.i;
/*     */   }
/*     */   
/*     */   public final MinerMineItem setAddToEmptyItemSlot(boolean paramBoolean) {
/* 132 */     this.i = paramBoolean;
/* 133 */     return this;
/*     */   }
/*     */   
/*     */   public final boolean isCancelled() {
/* 137 */     return this.j;
/*     */   }
/*     */   
/*     */   public final MinerMineItem setCancelled(boolean paramBoolean) {
/* 141 */     this.j = paramBoolean;
/* 142 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\MinerMineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */