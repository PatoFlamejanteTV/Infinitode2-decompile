/*    */ package com.prineside.tdi2.ui.shared.luaWhitelistEditor.events;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.ui.shared.luaWhitelistEditor.TreeEntry;
/*    */ 
/*    */ public final class EntryStateChange extends StoppableEvent {
/*    */   private final TreeEntry a;
/*    */   
/*    */   public EntryStateChange(TreeEntry paramTreeEntry) {
/* 11 */     Preconditions.checkNotNull(paramTreeEntry);
/* 12 */     this.a = paramTreeEntry;
/*    */   }
/*    */   
/*    */   public final TreeEntry getTreeEntry() {
/* 16 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\luaWhitelistEditor\events\EntryStateChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */