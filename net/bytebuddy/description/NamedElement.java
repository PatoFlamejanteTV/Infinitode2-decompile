/*     */ package net.bytebuddy.description;
/*     */ 
/*     */ import net.bytebuddy.utility.nullability.AlwaysNull;
/*     */ import net.bytebuddy.utility.nullability.MaybeNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface NamedElement
/*     */ {
/*     */   @AlwaysNull
/*  30 */   public static final String NO_NAME = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String EMPTY_NAME = "";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getActualName();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface WithDescriptor
/*     */     extends NamedElement
/*     */   {
/*     */     @AlwaysNull
/* 102 */     public static final String NON_GENERIC_SIGNATURE = null;
/*     */     
/*     */     String getDescriptor();
/*     */     
/*     */     @MaybeNull
/*     */     String getGenericSignature();
/*     */   }
/*     */   
/*     */   public static interface WithGenericName extends WithRuntimeName {
/*     */     String toGenericString();
/*     */   }
/*     */   
/*     */   public static interface WithOptionalName extends NamedElement {
/*     */     boolean isNamed();
/*     */   }
/*     */   
/*     */   public static interface WithRuntimeName extends NamedElement {
/*     */     String getName();
/*     */     
/*     */     String getInternalName();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\NamedElement.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */