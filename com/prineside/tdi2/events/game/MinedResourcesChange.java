/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.enums.ResourceType;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class MinedResourcesChange extends StoppableEvent {
/*    */   private ResourceType a;
/*    */   private int b;
/*    */   private boolean c;
/*    */   
/*    */   public MinedResourcesChange(ResourceType paramResourceType, int paramInt, boolean paramBoolean) {
/* 15 */     setType(paramResourceType);
/* 16 */     setOldValue(paramInt);
/* 17 */     setGained(paramBoolean);
/*    */   }
/*    */   
/*    */   public final ResourceType getType() {
/* 21 */     return this.a;
/*    */   }
/*    */   
/*    */   public final MinedResourcesChange setType(ResourceType paramResourceType) {
/* 25 */     Preconditions.checkNotNull(paramResourceType);
/* 26 */     this.a = paramResourceType;
/* 27 */     return this;
/*    */   }
/*    */   
/*    */   public final int getOldValue() {
/* 31 */     return this.b;
/*    */   }
/*    */   
/*    */   public final MinedResourcesChange setOldValue(int paramInt) {
/* 35 */     this.b = paramInt;
/* 36 */     return this;
/*    */   }
/*    */   
/*    */   public final boolean isGained() {
/* 40 */     return this.c;
/*    */   }
/*    */   
/*    */   public final MinedResourcesChange setGained(boolean paramBoolean) {
/* 44 */     this.c = paramBoolean;
/* 45 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\MinedResourcesChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */