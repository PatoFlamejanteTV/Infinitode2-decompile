/*     */ package net.bytebuddy.description;
/*     */ 
/*     */ import net.bytebuddy.description.modifier.EnumerationState;
/*     */ import net.bytebuddy.description.modifier.FieldManifestation;
/*     */ import net.bytebuddy.description.modifier.FieldPersistence;
/*     */ import net.bytebuddy.description.modifier.MethodManifestation;
/*     */ import net.bytebuddy.description.modifier.MethodStrictness;
/*     */ import net.bytebuddy.description.modifier.Ownership;
/*     */ import net.bytebuddy.description.modifier.ParameterManifestation;
/*     */ import net.bytebuddy.description.modifier.ProvisioningState;
/*     */ import net.bytebuddy.description.modifier.SynchronizationState;
/*     */ import net.bytebuddy.description.modifier.SyntheticState;
/*     */ import net.bytebuddy.description.modifier.TypeManifestation;
/*     */ import net.bytebuddy.description.modifier.Visibility;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface ModifierReviewable
/*     */ {
/*     */   public static final int EMPTY_MASK = 0;
/*     */   
/*     */   int getModifiers();
/*     */   
/*     */   boolean isFinal();
/*     */   
/*     */   boolean isSynthetic();
/*     */   
/*     */   SyntheticState getSyntheticState();
/*     */   
/*     */   public static abstract class AbstractBase
/*     */     implements ForFieldDescription, ForMethodDescription, ForParameterDescription, ForTypeDefinition
/*     */   {
/*     */     public boolean isAbstract() {
/* 315 */       return matchesMask(1024);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isFinal() {
/* 322 */       return matchesMask(16);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isStatic() {
/* 329 */       return matchesMask(8);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isPublic() {
/* 336 */       return matchesMask(1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isProtected() {
/* 343 */       return matchesMask(4);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isPackagePrivate() {
/* 350 */       return (!isPublic() && !isProtected() && !isPrivate());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isPrivate() {
/* 357 */       return matchesMask(2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isNative() {
/* 364 */       return matchesMask(256);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSynchronized() {
/* 371 */       return matchesMask(32);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isStrict() {
/* 378 */       return matchesMask(2048);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isMandated() {
/* 385 */       return matchesMask(32768);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSynthetic() {
/* 392 */       return matchesMask(4096);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isBridge() {
/* 399 */       return matchesMask(64);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isDeprecated() {
/* 406 */       return matchesMask(131072);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isAnnotation() {
/* 413 */       return matchesMask(8192);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isEnum() {
/* 420 */       return matchesMask(16384);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isInterface() {
/* 427 */       return matchesMask(512);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isTransient() {
/* 434 */       return matchesMask(128);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isVolatile() {
/* 441 */       return matchesMask(64);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isVarArgs() {
/* 448 */       return matchesMask(128);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SyntheticState getSyntheticState() {
/* 455 */       return isSynthetic() ? SyntheticState.SYNTHETIC : SyntheticState.PLAIN;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Visibility getVisibility() {
/*     */       int i;
/* 465 */       switch ((i = getModifiers()) & 0x7) {
/*     */         case 1:
/* 467 */           return Visibility.PUBLIC;
/*     */         case 4:
/* 469 */           return Visibility.PROTECTED;
/*     */         case 0:
/* 471 */           return Visibility.PACKAGE_PRIVATE;
/*     */         case 2:
/* 473 */           return Visibility.PRIVATE;
/*     */       } 
/* 475 */       throw new IllegalStateException("Unexpected modifiers: " + i);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Ownership getOwnership() {
/* 483 */       return isStatic() ? Ownership.STATIC : Ownership.MEMBER;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public EnumerationState getEnumerationState() {
/* 492 */       return isEnum() ? EnumerationState.ENUMERATION : EnumerationState.PLAIN;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeManifestation getTypeManifestation() {
/*     */       int i;
/* 502 */       switch ((i = getModifiers()) & 0x2610) {
/*     */         case 16:
/* 504 */           return TypeManifestation.FINAL;
/*     */         case 1024:
/* 506 */           return TypeManifestation.ABSTRACT;
/*     */         case 1536:
/* 508 */           return TypeManifestation.INTERFACE;
/*     */         case 9728:
/* 510 */           return TypeManifestation.ANNOTATION;
/*     */         case 0:
/* 512 */           return TypeManifestation.PLAIN;
/*     */       } 
/* 514 */       throw new IllegalStateException("Unexpected modifiers: " + i);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FieldManifestation getFieldManifestation() {
/*     */       int i;
/* 523 */       switch ((i = getModifiers()) & 0x50) {
/*     */         case 16:
/* 525 */           return FieldManifestation.FINAL;
/*     */         case 64:
/* 527 */           return FieldManifestation.VOLATILE;
/*     */         case 0:
/* 529 */           return FieldManifestation.PLAIN;
/*     */       } 
/* 531 */       throw new IllegalStateException("Unexpected modifiers: " + i);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FieldPersistence getFieldPersistence() {
/*     */       int i;
/* 540 */       switch ((i = getModifiers()) & 0x80) {
/*     */         case 128:
/* 542 */           return FieldPersistence.TRANSIENT;
/*     */         case 0:
/* 544 */           return FieldPersistence.PLAIN;
/*     */       } 
/* 546 */       throw new IllegalStateException("Unexpected modifiers: " + i);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SynchronizationState getSynchronizationState() {
/* 554 */       return isSynchronized() ? SynchronizationState.SYNCHRONIZED : SynchronizationState.PLAIN;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public MethodManifestation getMethodManifestation() {
/*     */       int i;
/* 564 */       switch ((i = getModifiers()) & 0x550) {
/*     */         case 272:
/* 566 */           return MethodManifestation.FINAL_NATIVE;
/*     */         case 256:
/* 568 */           return MethodManifestation.NATIVE;
/*     */         case 16:
/* 570 */           return MethodManifestation.FINAL;
/*     */         case 64:
/* 572 */           return MethodManifestation.BRIDGE;
/*     */         case 80:
/* 574 */           return MethodManifestation.FINAL_BRIDGE;
/*     */         case 1024:
/* 576 */           return MethodManifestation.ABSTRACT;
/*     */         case 0:
/* 578 */           return MethodManifestation.PLAIN;
/*     */       } 
/* 580 */       throw new IllegalStateException("Unexpected modifiers: " + i);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public MethodStrictness getMethodStrictness() {
/* 588 */       return isStrict() ? MethodStrictness.STRICT : MethodStrictness.PLAIN;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ParameterManifestation getParameterManifestation() {
/* 597 */       return isFinal() ? ParameterManifestation.FINAL : ParameterManifestation.PLAIN;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ProvisioningState getProvisioningState() {
/* 606 */       return isMandated() ? ProvisioningState.MANDATED : ProvisioningState.PLAIN;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean matchesMask(int param1Int) {
/* 618 */       return ((getModifiers() & param1Int) == param1Int);
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface ForParameterDescription extends ModifierReviewable {
/*     */     boolean isMandated();
/*     */     
/*     */     ParameterManifestation getParameterManifestation();
/*     */     
/*     */     ProvisioningState getProvisioningState();
/*     */   }
/*     */   
/*     */   public static interface ForMethodDescription extends OfAbstraction {
/*     */     boolean isSynchronized();
/*     */     
/*     */     boolean isVarArgs();
/*     */     
/*     */     boolean isNative();
/*     */     
/*     */     boolean isBridge();
/*     */     
/*     */     boolean isStrict();
/*     */     
/*     */     SynchronizationState getSynchronizationState();
/*     */     
/*     */     MethodStrictness getMethodStrictness();
/*     */     
/*     */     MethodManifestation getMethodManifestation();
/*     */   }
/*     */   
/*     */   public static interface ForFieldDescription extends OfEnumeration {
/*     */     boolean isVolatile();
/*     */     
/*     */     boolean isTransient();
/*     */     
/*     */     FieldManifestation getFieldManifestation();
/*     */     
/*     */     FieldPersistence getFieldPersistence();
/*     */   }
/*     */   
/*     */   public static interface ForTypeDefinition extends OfAbstraction, OfEnumeration {
/*     */     boolean isInterface();
/*     */     
/*     */     boolean isAnnotation();
/*     */     
/*     */     TypeManifestation getTypeManifestation();
/*     */   }
/*     */   
/*     */   public static interface OfEnumeration extends OfByteCodeElement {
/*     */     boolean isEnum();
/*     */     
/*     */     EnumerationState getEnumerationState();
/*     */   }
/*     */   
/*     */   public static interface OfAbstraction extends OfByteCodeElement {
/*     */     boolean isAbstract();
/*     */   }
/*     */   
/*     */   public static interface OfByteCodeElement extends ModifierReviewable {
/*     */     boolean isPublic();
/*     */     
/*     */     boolean isProtected();
/*     */     
/*     */     boolean isPackagePrivate();
/*     */     
/*     */     boolean isPrivate();
/*     */     
/*     */     boolean isStatic();
/*     */     
/*     */     boolean isDeprecated();
/*     */     
/*     */     Ownership getOwnership();
/*     */     
/*     */     Visibility getVisibility();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\ModifierReviewable.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */