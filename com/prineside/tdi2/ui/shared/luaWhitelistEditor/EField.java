/*    */ package com.prineside.tdi2.ui.shared.luaWhitelistEditor;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.managers.script.Whitelist;
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ import java.lang.reflect.Field;
/*    */ import java.lang.reflect.Modifier;
/*    */ 
/*    */ 
/*    */ public final class EField
/*    */   extends TreeEntry
/*    */ {
/*    */   private final Field b;
/*    */   
/*    */   public EField(Field paramField, TreeEntry paramTreeEntry) {
/* 17 */     super(paramTreeEntry, paramField.getName() + "[#FFFFFF80" + "]: " + paramField.getType().getSimpleName() + "[]");
/* 18 */     this.b = paramField;
/*    */   }
/*    */   
/*    */   public final Field getField() {
/* 22 */     return this.b;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void applyStateFromWhitelist(Whitelist paramWhitelist) {
/* 27 */     if (paramWhitelist.isFieldWhiteListed(this.b)) {
/* 28 */       this.state = 1; return;
/* 29 */     }  if (paramWhitelist.isFieldBlackListed(this.b)) {
/* 30 */       this.state = 2;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public final String getSortName() {
/* 36 */     return this.b.getName() + ": " + this.b.getType().getSimpleName();
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 41 */     return "F:" + getName();
/*    */   }
/*    */ 
/*    */   
/*    */   protected final boolean a() {
/* 46 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int getSortCategory() {
/* 51 */     if (Modifier.isStatic(this.b.getModifiers())) {
/* 52 */       return 30;
/*    */     }
/* 54 */     return 31;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final void gatherSaveData(Array<String> paramArray) {
/* 60 */     switch (getState()) {
/*    */       case 1:
/* 62 */         paramArray.add("+f:" + this.b.getName());
/*    */         return;
/*    */       
/*    */       case 2:
/* 66 */         paramArray.add("-f:" + this.b.getName());
/*    */         break;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final Drawable getEntryIcon() {
/* 74 */     if (Modifier.isStatic(this.b.getModifiers())) {
/* 75 */       return (Drawable)Game.i.assetManager.getQuad("icons.classTree.static-field");
/*    */     }
/* 77 */     return (Drawable)Game.i.assetManager.getQuad("icons.classTree.field");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\luaWhitelistEditor\EField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */