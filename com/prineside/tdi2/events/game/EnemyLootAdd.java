/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Item;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class EnemyLootAdd extends StoppableEvent {
/*    */   private int a;
/*    */   private Item b;
/*    */   
/*    */   public EnemyLootAdd(Item paramItem, int paramInt) {
/* 14 */     setItem(paramItem);
/* 15 */     setCount(paramInt);
/*    */   }
/*    */   
/*    */   public final int getCount() {
/* 19 */     return this.a;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final EnemyLootAdd setCount(int paramInt) {
/* 26 */     Preconditions.checkArgument((paramInt >= 0), "count can not be %s", paramInt);
/* 27 */     this.a = paramInt;
/* 28 */     return this;
/*    */   }
/*    */   
/*    */   public final Item getItem() {
/* 32 */     return this.b;
/*    */   }
/*    */   
/*    */   public final EnemyLootAdd setItem(Item paramItem) {
/* 36 */     Preconditions.checkNotNull(paramItem);
/* 37 */     this.b = paramItem;
/* 38 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\EnemyLootAdd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */