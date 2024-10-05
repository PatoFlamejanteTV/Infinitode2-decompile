/*     */ package net.bytebuddy.description.modifier;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum MethodManifestation
/*     */   implements ModifierContributor.ForMethod
/*     */ {
/*  30 */   PLAIN(0),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  35 */   NATIVE(256),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  40 */   ABSTRACT(1024),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  45 */   FINAL(16),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  50 */   FINAL_NATIVE(272),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   BRIDGE(64),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   FINAL_BRIDGE(80);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int mask;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   MethodManifestation(int paramInt1) {
/*  73 */     this.mask = paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getMask() {
/*  80 */     return this.mask;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getRange() {
/*  87 */     return 1360;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isDefault() {
/*  94 */     return (this == PLAIN);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isNative() {
/* 103 */     return ((this.mask & 0x100) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isAbstract() {
/* 112 */     return ((this.mask & 0x400) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isFinal() {
/* 121 */     return ((this.mask & 0x10) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isBridge() {
/* 130 */     return ((this.mask & 0x40) != 0);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\modifier\MethodManifestation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */