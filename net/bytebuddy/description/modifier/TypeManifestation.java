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
/*     */ public enum TypeManifestation
/*     */   implements ModifierContributor.ForType
/*     */ {
/*  28 */   PLAIN(0),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  33 */   FINAL(16),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   ABSTRACT(1024),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   INTERFACE(1536),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   ANNOTATION(9728);
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
/*     */   TypeManifestation(int paramInt1) {
/*  61 */     this.mask = paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getMask() {
/*  68 */     return this.mask;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getRange() {
/*  75 */     return 9744;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isDefault() {
/*  82 */     return (this == PLAIN);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isFinal() {
/*  91 */     return ((this.mask & 0x10) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isAbstract() {
/* 100 */     return ((this.mask & 0x400) != 0 && !isInterface());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isInterface() {
/* 109 */     return ((this.mask & 0x200) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isAnnotation() {
/* 118 */     return ((this.mask & 0x2000) != 0);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\modifier\TypeManifestation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */