/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Modifier;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class ModifierBuild extends StoppableEvent {
/*    */   private final Modifier a;
/*    */   private final int b;
/*    */   
/*    */   public ModifierBuild(Modifier paramModifier, int paramInt) {
/* 14 */     Preconditions.checkNotNull(paramModifier, "modifier can not be null");
/* 15 */     Preconditions.checkArgument((paramInt >= 0), "invalid price: %s", paramInt);
/* 16 */     this.a = paramModifier;
/* 17 */     this.b = paramInt;
/*    */   }
/*    */   
/*    */   public final Modifier getModifier() {
/* 21 */     return this.a;
/*    */   }
/*    */   
/*    */   public final int getPrice() {
/* 25 */     return this.b;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\ModifierBuild.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */