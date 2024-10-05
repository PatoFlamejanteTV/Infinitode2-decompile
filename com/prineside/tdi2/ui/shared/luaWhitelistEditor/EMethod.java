/*     */ package com.prineside.tdi2.ui.shared.luaWhitelistEditor;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.script.Whitelist;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.lang.reflect.Parameter;
/*     */ 
/*     */ 
/*     */ public final class EMethod
/*     */   extends TreeEntry
/*     */ {
/*     */   private final Method b;
/*     */   
/*     */   public EMethod(Method paramMethod, TreeEntry paramTreeEntry) {
/*  19 */     super(paramTreeEntry, "");
/*  20 */     this.b = paramMethod;
/*     */   }
/*     */   
/*     */   public final Method getMethod() {
/*  24 */     return this.b;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void applyStateFromWhitelist(Whitelist paramWhitelist) {
/*  29 */     if (paramWhitelist.isMethodBlackListed(this.b)) {
/*  30 */       this.state = 2; return;
/*  31 */     }  if (paramWhitelist.isMethodWhiteListedInDeclaringClass(this.b)) {
/*  32 */       this.state = 1;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getSortCategory() {
/*  38 */     if (Modifier.isStatic(this.b.getModifiers())) {
/*  39 */       return 40;
/*     */     }
/*  41 */     return 41;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getMethodSignature() {
/*  47 */     byte b1 = 0;
/*     */     StringBuilder stringBuilder;
/*  49 */     (stringBuilder = new StringBuilder()).append(this.b.getName()).append(":"); Parameter[] arrayOfParameter; int i; byte b2;
/*  50 */     for (i = (arrayOfParameter = this.b.getParameters()).length, b2 = 0; b2 < i; ) { Parameter parameter = arrayOfParameter[b2];
/*  51 */       if (b1) {
/*  52 */         stringBuilder.append(",");
/*     */       }
/*  54 */       stringBuilder.append(parameter.getType().getSimpleName());
/*  55 */       b1++; b2++; }
/*     */     
/*  57 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void gatherSaveData(Array<String> paramArray) {
/*  62 */     switch (getState()) {
/*     */       case 1:
/*  64 */         paramArray.add("+m:" + getMethodSignature());
/*     */         return;
/*     */       
/*     */       case 2:
/*  68 */         paramArray.add("-m:" + getMethodSignature());
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean a() {
/*  76 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getName() {
/*     */     StringBuilder stringBuilder;
/*  83 */     (stringBuilder = new StringBuilder()).append(this.b.getName()).append("(");
/*  84 */     byte b1 = 0; Parameter[] arrayOfParameter; int i; byte b2;
/*  85 */     for (i = (arrayOfParameter = this.b.getParameters()).length, b2 = 0; b2 < i; ) { Parameter parameter = arrayOfParameter[b2];
/*  86 */       if (b1) {
/*  87 */         stringBuilder.append(", ");
/*     */       }
/*  89 */       stringBuilder.append(parameter.getName()).append("[").append("#FFFFFF80").append("]: ").append(parameter.getType().getSimpleName()).append("[]");
/*  90 */       b1++; b2++; }
/*     */     
/*  92 */     stringBuilder.append(")[").append("#FFFFFF80").append("]: ").append(this.b.getReturnType().getSimpleName()).append("[]");
/*  93 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getSortName() {
/*  98 */     return getMethodSignature();
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 103 */     return "M:" + getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getEntryIcon() {
/* 108 */     if (Modifier.isStatic(this.b.getModifiers())) {
/* 109 */       return (Drawable)Game.i.assetManager.getQuad("icons.classTree.static-method");
/*     */     }
/* 111 */     return (Drawable)Game.i.assetManager.getQuad("icons.classTree.method");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\luaWhitelistEditor\EMethod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */