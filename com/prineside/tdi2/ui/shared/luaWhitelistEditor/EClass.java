/*     */ package com.prineside.tdi2.ui.shared.luaWhitelistEditor;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.script.Whitelist;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ 
/*     */ public final class EClass extends TreeEntry {
/*     */   public Class<?> forClass;
/*     */   
/*     */   public EClass(Class<?> paramClass, TreeEntry paramTreeEntry) {
/*  12 */     super(paramTreeEntry, paramClass.getSimpleName());
/*  13 */     this.forClass = paramClass;
/*     */   }
/*     */   
/*     */   public final Class<?> getForClass() {
/*  17 */     return this.forClass;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void applyStateFromWhitelist(Whitelist paramWhitelist) {
/*  22 */     if (paramWhitelist.isClassBlackListed(this.forClass)) {
/*  23 */       this.state = 2;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/*  29 */     return "C:" + getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getSortCategory() {
/*  34 */     if (this.forClass.isInterface()) {
/*  35 */       return 10;
/*     */     }
/*  37 */     return 11;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getState() {
/*  43 */     if (this.state == 2) {
/*  44 */       return 2;
/*     */     }
/*     */     
/*  47 */     boolean bool1 = true;
/*  48 */     boolean bool2 = true;
/*  49 */     boolean bool3 = true;
/*  50 */     for (byte b = 0; b < this.children.size; b++) {
/*     */       int i;
/*     */       TreeEntry treeEntry;
/*  53 */       if ((i = (treeEntry = (TreeEntry)this.children.get(b)).getState()) == 0) {
/*  54 */         bool1 = false;
/*     */         break;
/*     */       } 
/*  57 */       if (i != 1 && i != 4) {
/*  58 */         bool2 = false;
/*     */       }
/*  60 */       if (i != 2 && i != 5) {
/*  61 */         bool3 = false;
/*     */       }
/*     */     } 
/*  64 */     if (bool1) {
/*  65 */       if (bool3) {
/*  66 */         return 5;
/*     */       }
/*  68 */       if (bool2) {
/*  69 */         return 4;
/*     */       }
/*     */       
/*  72 */       return 3;
/*     */     } 
/*  74 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void gatherSaveData(Array<String> paramArray) {
/*  80 */     if (getState() == 2) {
/*     */       
/*  82 */       paramArray.add("-c:" + this.a);
/*     */       return;
/*     */     } 
/*  85 */     Array<String> array = new Array(); byte b;
/*  86 */     for (b = 0; b < this.children.size; b++) {
/*  87 */       ((TreeEntry)this.children.get(b)).gatherSaveData(array);
/*     */     }
/*  89 */     if (array.size != 0) {
/*  90 */       paramArray.add(">c:" + this.a + "{");
/*  91 */       for (b = 0; b < array.size; b++) {
/*  92 */         paramArray.add(" " + (String)array.get(b));
/*     */       }
/*  94 */       paramArray.add("}");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Drawable getEntryIcon() {
/* 101 */     if (this.forClass.isInterface()) {
/* 102 */       return (Drawable)Game.i.assetManager.getQuad("icons.classTree.interface");
/*     */     }
/* 104 */     if (this.forClass.isEnum()) {
/* 105 */       return (Drawable)Game.i.assetManager.getQuad("icons.classTree.enum");
/*     */     }
/* 107 */     return (Drawable)Game.i.assetManager.getQuad("icons.classTree.class");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\luaWhitelistEditor\EClass.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */