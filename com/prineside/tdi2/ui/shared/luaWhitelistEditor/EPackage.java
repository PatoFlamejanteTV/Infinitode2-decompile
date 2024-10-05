/*    */ package com.prineside.tdi2.ui.shared.luaWhitelistEditor;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.managers.script.Whitelist;
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ 
/*    */ public final class EPackage extends TreeEntry {
/*    */   private String b;
/*    */   
/*    */   public EPackage(TreeEntry paramTreeEntry, String paramString1, String paramString2) {
/* 12 */     super(paramTreeEntry, paramString1);
/* 13 */     this.b = paramString2;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int getSortCategory() {
/* 18 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void applyStateFromWhitelist(Whitelist paramWhitelist) {
/* 23 */     if (paramWhitelist.isPackageBlackListed(this.b)) {
/* 24 */       this.state = 2;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public final void gatherSaveData(Array<String> paramArray) {
/* 30 */     if (getState() == 2) {
/*    */       
/* 32 */       paramArray.add("-p:" + this.a);
/*    */       return;
/*    */     } 
/* 35 */     Array<String> array = new Array(); byte b;
/* 36 */     for (b = 0; b < this.children.size; b++) {
/* 37 */       ((TreeEntry)this.children.get(b)).gatherSaveData(array);
/*    */     }
/* 39 */     if (array.size != 0) {
/* 40 */       paramArray.add(">p:" + this.a + "{");
/* 41 */       for (b = 0; b < array.size; b++) {
/* 42 */         paramArray.add(" " + (String)array.get(b));
/*    */       }
/* 44 */       paramArray.add("}");
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final int getState() {
/* 51 */     if (this.state == 2) {
/* 52 */       return 2;
/*    */     }
/*    */     
/* 55 */     boolean bool1 = true;
/* 56 */     boolean bool2 = true;
/* 57 */     boolean bool3 = true;
/* 58 */     for (byte b = 0; b < this.children.size; b++) {
/*    */       int i;
/*    */       TreeEntry treeEntry;
/* 61 */       if ((i = (treeEntry = (TreeEntry)this.children.get(b)).getState()) == 0) {
/* 62 */         bool1 = false;
/*    */         break;
/*    */       } 
/* 65 */       if (i != 1 && i != 4) {
/* 66 */         bool2 = false;
/*    */       }
/* 68 */       if (i != 2 && i != 5) {
/* 69 */         bool3 = false;
/*    */       }
/*    */     } 
/* 72 */     if (bool1) {
/* 73 */       if (bool3) {
/* 74 */         return 5;
/*    */       }
/* 76 */       if (bool2) {
/* 77 */         return 4;
/*    */       }
/*    */       
/* 80 */       return 3;
/*    */     } 
/* 82 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 88 */     return "P:" + getName();
/*    */   }
/*    */ 
/*    */   
/*    */   public final Drawable getEntryIcon() {
/* 93 */     return (Drawable)Game.i.assetManager.getQuad("icons.classTree.package");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\luaWhitelistEditor\EPackage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */