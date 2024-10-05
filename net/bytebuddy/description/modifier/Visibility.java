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
/*     */ public enum Visibility
/*     */   implements ModifierContributor.ForField, ModifierContributor.ForMethod, ModifierContributor.ForType
/*     */ {
/*  28 */   PUBLIC(1),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  33 */   PACKAGE_PRIVATE(0),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   PROTECTED(4),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   PRIVATE(2);
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
/*     */   Visibility(int paramInt1) {
/*  56 */     this.mask = paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getMask() {
/*  63 */     return this.mask;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getRange() {
/*  70 */     return 7;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isDefault() {
/*  77 */     return (this == PACKAGE_PRIVATE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isPublic() {
/*  86 */     return ((this.mask & 0x1) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isProtected() {
/*  95 */     return ((this.mask & 0x4) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isPackagePrivate() {
/* 104 */     return (!isPublic() && !isPrivate() && !isProtected());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isPrivate() {
/* 113 */     return ((this.mask & 0x2) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Visibility expandTo(Visibility paramVisibility) {
/* 123 */     switch (null.a[paramVisibility.ordinal()]) {
/*     */       case 1:
/* 125 */         return PUBLIC;
/*     */       case 2:
/* 127 */         return (this == PUBLIC) ? PUBLIC : paramVisibility;
/*     */ 
/*     */       
/*     */       case 3:
/* 131 */         return (this == PRIVATE) ? PACKAGE_PRIVATE : this;
/*     */ 
/*     */       
/*     */       case 4:
/* 135 */         return this;
/*     */     } 
/* 137 */     throw new IllegalStateException("Unexpected visibility: " + paramVisibility);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\modifier\Visibility.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */