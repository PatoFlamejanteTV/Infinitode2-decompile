/*     */ package com.prineside.tdi2.gates;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Gate;
/*     */ import com.prineside.tdi2.GateBarrier;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.GateType;
/*     */ import com.prineside.tdi2.enums.ItemSortingType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public class BarrierHealthGate extends GateBarrier {
/*     */   public boolean moreThanHalf;
/*     */   
/*     */   private BarrierHealthGate() {
/*  29 */     super(GateType.BARRIER_HEALTH);
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/*  34 */     return RarityType.COMMON;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Gate cloneGate() {
/*     */     BarrierHealthGate barrierHealthGate;
/*  41 */     (barrierHealthGate = Game.i.gateManager.F.BARRIER_HEALTH.create()).setPosition(getX(), getY(), isLeftSide());
/*  42 */     barrierHealthGate.moreThanHalf = this.moreThanHalf;
/*     */     
/*  44 */     return (Gate)barrierHealthGate;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addSellItems(Array<ItemStack> paramArray) {
/*  49 */     paramArray.add(new ItemStack((Item)Item.D.GREEN_PAPER, 200));
/*     */   }
/*     */ 
/*     */   
/*     */   public double getPrestigeScore() {
/*  54 */     return 0.05D;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSortingScore(ItemSortingType paramItemSortingType) {
/*  59 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canEnemyPass(EnemyType paramEnemyType) {
/*  64 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/*     */     Image image;
/*  70 */     if (this.moreThanHalf) {
/*  71 */       image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-gate-health-high"));
/*     */     } else {
/*  73 */       image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-gate-health-low"));
/*     */     } 
/*  75 */     image.setSize(paramFloat, paramFloat);
/*  76 */     return (Actor)image;
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawStatic(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  81 */     paramFloat1 = paramFloat3 * 0.0078125F;
/*  82 */     paramFloat2 = paramFloat4 * 0.0078125F;
/*  83 */     if (isLeftSide()) {
/*     */       
/*  85 */       if (this.moreThanHalf) {
/*  86 */         paramBatch.draw(Game.i.gateManager.F.BARRIER_HEALTH.a, ((
/*     */             
/*  88 */             getX() << 7) - 16.0F) * paramFloat1, (
/*  89 */             getY() << 7) * paramFloat2, 32.0F * paramFloat1, 128.0F * paramFloat2);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/*  94 */       paramBatch.draw(Game.i.gateManager.F.BARRIER_HEALTH.c, ((
/*     */           
/*  96 */           getX() << 7) - 16.0F) * paramFloat1, (
/*  97 */           getY() << 7) * paramFloat2, 32.0F * paramFloat1, 128.0F * paramFloat2);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 104 */     if (this.moreThanHalf) {
/* 105 */       paramBatch.draw(Game.i.gateManager.F.BARRIER_HEALTH.b, (
/*     */           
/* 107 */           getX() << 7) * paramFloat1, ((
/* 108 */           getY() << 7) - 16.0F) * paramFloat2, 128.0F * paramFloat1, 32.0F * paramFloat2);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 113 */     paramBatch.draw(Game.i.gateManager.F.BARRIER_HEALTH.d, (
/*     */         
/* 115 */         getX() << 7) * paramFloat1, ((
/* 116 */         getY() << 7) - 16.0F) * paramFloat2, 128.0F * paramFloat1, 32.0F * paramFloat2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean sameAs(Gate paramGate) {
/* 126 */     if (!super.sameAs(paramGate)) return false;
/*     */ 
/*     */     
/*     */     BarrierHealthGate barrierHealthGate;
/* 130 */     if ((barrierHealthGate = (BarrierHealthGate)paramGate).moreThanHalf != this.moreThanHalf) return false;
/*     */     
/* 132 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 137 */     super.toJson(paramJson);
/*     */     
/* 139 */     paramJson.writeValue("moreThanHalf", Boolean.valueOf(this.moreThanHalf));
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 144 */     return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.moreThanHalf + ")";
/*     */   }
/*     */   
/*     */   public static class BarrierHealthGateFactory extends Gate.Factory.AbstractFactory<BarrierHealthGate> {
/*     */     TextureRegion a;
/*     */     TextureRegion b;
/*     */     TextureRegion c;
/*     */     TextureRegion d;
/*     */     
/*     */     public BarrierHealthGateFactory() {
/* 154 */       super(GateType.BARRIER_HEALTH);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 159 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("gate-barrier-health-high-vertical");
/* 160 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("gate-barrier-health-high-horizontal");
/* 161 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("gate-barrier-health-low-vertical");
/* 162 */       this.d = (TextureRegion)Game.i.assetManager.getTextureRegion("gate-barrier-health-low-horizontal");
/*     */     }
/*     */ 
/*     */     
/*     */     public BarrierHealthGate create() {
/* 167 */       return new BarrierHealthGate((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public BarrierHealthGate createRandom(float param1Float, RandomXS128 param1RandomXS128) {
/* 172 */       if (param1RandomXS128 == null) {
/* 173 */         param1RandomXS128 = FastRandom.random;
/*     */       }
/*     */       
/*     */       BarrierHealthGate barrierHealthGate;
/* 177 */       (barrierHealthGate = create()).moreThanHalf = (param1RandomXS128.nextFloat() < 0.5F);
/*     */       
/* 179 */       return barrierHealthGate;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BarrierHealthGate fromJson(JsonValue param1JsonValue) {
/*     */       BarrierHealthGate barrierHealthGate;
/* 186 */       (barrierHealthGate = (BarrierHealthGate)super.fromJson(param1JsonValue)).moreThanHalf = param1JsonValue.getBoolean("moreThanHalf", false);
/*     */       
/* 188 */       return barrierHealthGate;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gates\BarrierHealthGate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */