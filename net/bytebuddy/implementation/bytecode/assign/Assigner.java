/*     */ package net.bytebuddy.implementation.bytecode.assign;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveTypeAwareAssigner;
/*     */ import net.bytebuddy.implementation.bytecode.assign.primitive.VoidAwareAssigner;
/*     */ import net.bytebuddy.implementation.bytecode.assign.reference.GenericTypeAwareAssigner;
/*     */ import net.bytebuddy.implementation.bytecode.assign.reference.ReferenceTypeAwareAssigner;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SuppressFBWarnings(value = {"IC_SUPERCLASS_USES_SUBCLASS_DURING_INITIALIZATION"}, justification = "Safe initialization is implied.")
/*     */ public interface Assigner
/*     */ {
/*  38 */   public static final Assigner DEFAULT = (Assigner)new VoidAwareAssigner((Assigner)new PrimitiveTypeAwareAssigner((Assigner)ReferenceTypeAwareAssigner.INSTANCE));
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   public static final Assigner GENERICS_AWARE = (Assigner)new VoidAwareAssigner((Assigner)new PrimitiveTypeAwareAssigner((Assigner)GenericTypeAwareAssigner.INSTANCE));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   StackManipulation assign(TypeDescription.Generic paramGeneric1, TypeDescription.Generic paramGeneric2, Typing paramTyping);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Typing
/*     */   {
/*  65 */     STATIC(false),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  70 */     DYNAMIC(true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final boolean dynamic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Typing(boolean param1Boolean) {
/*  83 */       this.dynamic = param1Boolean;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static Typing of(boolean param1Boolean) {
/*  93 */       return param1Boolean ? DYNAMIC : STATIC;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isDynamic() {
/* 104 */       return this.dynamic;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum EqualTypesOnly
/*     */     implements Assigner
/*     */   {
/* 116 */     GENERIC
/*     */     {
/*     */       public final StackManipulation assign(TypeDescription.Generic param2Generic1, TypeDescription.Generic param2Generic2, Assigner.Typing param2Typing) {
/* 119 */         return param2Generic1.equals(param2Generic2) ? (StackManipulation)StackManipulation.Trivial.INSTANCE : (StackManipulation)StackManipulation.Illegal.INSTANCE;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 128 */     ERASURE
/*     */     {
/*     */       public final StackManipulation assign(TypeDescription.Generic param2Generic1, TypeDescription.Generic param2Generic2, Assigner.Typing param2Typing) {
/* 131 */         return param2Generic1.asErasure().equals(param2Generic2.asErasure()) ? (StackManipulation)StackManipulation.Trivial.INSTANCE : (StackManipulation)StackManipulation.Illegal.INSTANCE;
/*     */       }
/*     */     };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Refusing
/*     */     implements Assigner
/*     */   {
/* 146 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final StackManipulation assign(TypeDescription.Generic param1Generic1, TypeDescription.Generic param1Generic2, Assigner.Typing param1Typing) {
/* 152 */       return (StackManipulation)StackManipulation.Illegal.INSTANCE;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\assign\Assigner.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */