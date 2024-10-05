/*     */ package com.prineside.tdi2.ui.shared.luaWhitelistEditor;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.script.Whitelist;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Parameter;
/*     */ 
/*     */ 
/*     */ public final class EConstructor
/*     */   extends TreeEntry
/*     */ {
/*     */   private final Constructor<?> b;
/*     */   
/*     */   public EConstructor(TreeEntry paramTreeEntry, Constructor<?> paramConstructor) {
/*  18 */     super(paramTreeEntry, "");
/*  19 */     this.b = paramConstructor;
/*     */   }
/*     */   
/*     */   public final Constructor<?> getConstructor() {
/*  23 */     return this.b;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void applyStateFromWhitelist(Whitelist paramWhitelist) {
/*  28 */     if (paramWhitelist.isConstructorWhiteListed(this.b)) {
/*  29 */       this.state = 1; return;
/*  30 */     }  if (paramWhitelist.isConstructorBlackListed(this.b)) {
/*  31 */       this.state = 2;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected final boolean a() {
/*  37 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getName() {
/*     */     StringBuilder stringBuilder;
/*  44 */     (stringBuilder = new StringBuilder()).append(((EClass)this.parent).getName());
/*  45 */     stringBuilder.append("(");
/*     */     
/*  47 */     byte b1 = 0; Parameter[] arrayOfParameter; int i; byte b2;
/*  48 */     for (i = (arrayOfParameter = this.b.getParameters()).length, b2 = 0; b2 < i; ) { Parameter parameter = arrayOfParameter[b2];
/*  49 */       if (b1) {
/*  50 */         stringBuilder.append(", ");
/*     */       }
/*  52 */       stringBuilder.append(parameter.getName()).append("[").append("#FFFFFF80").append("]: ").append(parameter.getType().getSimpleName()).append("[]");
/*  53 */       b1++; b2++; }
/*     */     
/*  55 */     stringBuilder.append(")");
/*  56 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getCtorSignature() {
/*  61 */     byte b1 = 0;
/*  62 */     StringBuilder stringBuilder = new StringBuilder(); Parameter[] arrayOfParameter; int i; byte b2;
/*  63 */     for (i = (arrayOfParameter = this.b.getParameters()).length, b2 = 0; b2 < i; ) { Parameter parameter = arrayOfParameter[b2];
/*  64 */       if (b1) {
/*  65 */         stringBuilder.append(",");
/*     */       }
/*  67 */       stringBuilder.append(parameter.getType().getSimpleName());
/*  68 */       b1++; b2++; }
/*     */     
/*  70 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void gatherSaveData(Array<String> paramArray) {
/*  75 */     switch (getState()) {
/*     */       case 1:
/*  77 */         paramArray.add("+x:" + getCtorSignature());
/*     */         return;
/*     */       
/*     */       case 2:
/*  81 */         paramArray.add("-x:" + getCtorSignature());
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getSortCategory() {
/*  90 */     if ((this.b.getParameters()).length == 0) {
/*  91 */       return 20;
/*     */     }
/*  93 */     return 21;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/*  99 */     return "Ctor:" + getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getEntryIcon() {
/* 104 */     return (Drawable)Game.i.assetManager.getQuad("icons.classTree.constructor");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\luaWhitelistEditor\EConstructor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */