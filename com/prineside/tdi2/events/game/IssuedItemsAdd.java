/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.IssuedItems;
/*    */ import com.prineside.tdi2.ItemStack;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class IssuedItemsAdd extends StoppableEvent {
/*    */   private IssuedItems a;
/*    */   private ItemStack b;
/*    */   private float c;
/*    */   private float d;
/*    */   private int e;
/*    */   
/*    */   public IssuedItemsAdd(IssuedItems paramIssuedItems, ItemStack paramItemStack, float paramFloat1, float paramFloat2, int paramInt) {
/* 18 */     setIssuedItems(paramIssuedItems);
/* 19 */     setItemStack(paramItemStack);
/* 20 */     setStageX(paramFloat1);
/* 21 */     setStageY(paramFloat2);
/* 22 */     setFlyAlign(paramInt);
/*    */   }
/*    */   
/*    */   public final IssuedItems getIssuedItems() {
/* 26 */     return this.a;
/*    */   }
/*    */   
/*    */   public final IssuedItemsAdd setIssuedItems(IssuedItems paramIssuedItems) {
/* 30 */     Preconditions.checkNotNull(paramIssuedItems);
/* 31 */     this.a = paramIssuedItems;
/* 32 */     return this;
/*    */   }
/*    */   
/*    */   public final ItemStack getItemStack() {
/* 36 */     return this.b;
/*    */   }
/*    */   
/*    */   public final IssuedItemsAdd setItemStack(ItemStack paramItemStack) {
/* 40 */     Preconditions.checkNotNull(paramItemStack);
/* 41 */     this.b = paramItemStack;
/* 42 */     return this;
/*    */   }
/*    */   
/*    */   public final float getStageX() {
/* 46 */     return this.c;
/*    */   }
/*    */   
/*    */   public final IssuedItemsAdd setStageX(float paramFloat) {
/* 50 */     this.c = paramFloat;
/* 51 */     return this;
/*    */   }
/*    */   
/*    */   public final float getStageY() {
/* 55 */     return this.d;
/*    */   }
/*    */   
/*    */   public final IssuedItemsAdd setStageY(float paramFloat) {
/* 59 */     this.d = paramFloat;
/* 60 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final int getFlyAlign() {
/* 67 */     return this.e;
/*    */   }
/*    */   
/*    */   public final IssuedItemsAdd setFlyAlign(int paramInt) {
/* 71 */     this.e = paramInt;
/* 72 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\IssuedItemsAdd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */