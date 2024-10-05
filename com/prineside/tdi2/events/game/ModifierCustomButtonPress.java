/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Modifier;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class ModifierCustomButtonPress extends StoppableEvent {
/*    */   private final Modifier a;
/*    */   
/*    */   public ModifierCustomButtonPress(Modifier paramModifier) {
/* 13 */     Preconditions.checkNotNull(paramModifier);
/* 14 */     this.a = paramModifier;
/*    */   }
/*    */   
/*    */   public final Modifier getModifier() {
/* 18 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\ModifierCustomButtonPress.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */