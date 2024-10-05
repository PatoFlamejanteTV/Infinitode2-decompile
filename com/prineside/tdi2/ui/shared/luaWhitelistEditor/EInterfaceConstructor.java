/*    */ package com.prineside.tdi2.ui.shared.luaWhitelistEditor;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.managers.script.Whitelist;
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ 
/*    */ public final class EInterfaceConstructor
/*    */   extends TreeEntry
/*    */ {
/*    */   public EInterfaceConstructor(TreeEntry paramTreeEntry) {
/* 12 */     super(paramTreeEntry, "");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final String getName() {
/* 18 */     return ((EClass)this.parent).forClass.getSimpleName() + "()[#FFFFFF80" + "] - interface proxying[]";
/*    */   }
/*    */ 
/*    */   
/*    */   public final void applyStateFromWhitelist(Whitelist paramWhitelist) {
/* 23 */     if (paramWhitelist.isInterfaceProxyWhiteListed(((EClass)this.parent).forClass)) {
/* 24 */       this.state = 1; return;
/* 25 */     }  if (paramWhitelist.isInterfaceProxyBlackListed(((EClass)this.parent).forClass)) {
/* 26 */       this.state = 2;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public final void gatherSaveData(Array<String> paramArray) {
/* 32 */     switch (getState()) {
/*    */       case 1:
/* 34 */         paramArray.add("+z");
/*    */         return;
/*    */       
/*    */       case 2:
/* 38 */         paramArray.add("-z");
/*    */         break;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final int getSortCategory() {
/* 47 */     return 20;
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 52 */     return "ICtor:" + getName();
/*    */   }
/*    */ 
/*    */   
/*    */   public final Drawable getEntryIcon() {
/* 57 */     return (Drawable)Game.i.assetManager.getQuad("icons.classTree.interface-constructor");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\luaWhitelistEditor\EInterfaceConstructor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */