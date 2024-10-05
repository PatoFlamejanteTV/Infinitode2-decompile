/*     */ package net.bytebuddy.implementation.bytecode.member;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import net.bytebuddy.build.CachedReturnPlugin.Enhance;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.ParameterDescription;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.StackSize;
/*     */ import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
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
/*     */ 
/*     */ public enum MethodVariableAccess
/*     */ {
/*  42 */   INTEGER(21, 54, StackSize.SINGLE),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   LONG(22, 55, StackSize.DOUBLE),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  52 */   FLOAT(23, 56, StackSize.SINGLE),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  57 */   DOUBLE(24, 57, StackSize.DOUBLE),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   REFERENCE(25, 58, StackSize.SINGLE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int loadOpcode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int storeOpcode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final StackSize size;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   MethodVariableAccess(int paramInt1, int paramInt2, StackSize paramStackSize) {
/*  87 */     this.loadOpcode = paramInt1;
/*  88 */     this.size = paramStackSize;
/*  89 */     this.storeOpcode = paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MethodVariableAccess of(TypeDefinition paramTypeDefinition) {
/*  99 */     if (paramTypeDefinition.isPrimitive()) {
/* 100 */       if (paramTypeDefinition.represents(long.class))
/* 101 */         return LONG; 
/* 102 */       if (paramTypeDefinition.represents(double.class))
/* 103 */         return DOUBLE; 
/* 104 */       if (paramTypeDefinition.represents(float.class))
/* 105 */         return FLOAT; 
/* 106 */       if (paramTypeDefinition.represents(void.class)) {
/* 107 */         throw new IllegalArgumentException("Variable type cannot be void");
/*     */       }
/* 109 */       return INTEGER;
/*     */     } 
/*     */     
/* 112 */     return REFERENCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MethodLoading allArgumentsOf(MethodDescription paramMethodDescription) {
/* 123 */     return new MethodLoading(paramMethodDescription, MethodLoading.TypeCastingHandler.NoOp.INSTANCE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance("loadThis")
/*     */   public static StackManipulation loadThis() {
/*     */     StackManipulation stackManipulation;
/* 133 */     if ((stackManipulation = (StackManipulation)(((stackManipulation = loadThis) != null) ? null : REFERENCE.loadFrom(0))) == null) { stackManipulation = loadThis; } else { loadThis = stackManipulation; }  return stackManipulation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StackManipulation loadFrom(int paramInt) {
/* 143 */     return (StackManipulation)new OffsetLoading(this, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StackManipulation storeAt(int paramInt) {
/* 153 */     return (StackManipulation)new OffsetWriting(this, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StackManipulation increment(int paramInt1, int paramInt2) {
/* 164 */     if (this != INTEGER) {
/* 165 */       throw new IllegalStateException("Cannot increment type: " + this);
/*     */     }
/* 167 */     return (StackManipulation)new OffsetIncrementing(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StackManipulation load(ParameterDescription paramParameterDescription) {
/* 177 */     return of((TypeDefinition)paramParameterDescription.getType()).loadFrom(paramParameterDescription.getOffset());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StackManipulation store(ParameterDescription paramParameterDescription) {
/* 187 */     return of((TypeDefinition)paramParameterDescription.getType()).storeAt(paramParameterDescription.getOffset());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StackManipulation increment(ParameterDescription paramParameterDescription, int paramInt) {
/* 198 */     return of((TypeDefinition)paramParameterDescription.getType()).increment(paramParameterDescription.getOffset(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class MethodLoading
/*     */     extends StackManipulation.AbstractBase
/*     */   {
/*     */     private final MethodDescription methodDescription;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final TypeCastingHandler typeCastingHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected MethodLoading(MethodDescription param1MethodDescription, TypeCastingHandler param1TypeCastingHandler) {
/* 224 */       this.methodDescription = param1MethodDescription;
/* 225 */       this.typeCastingHandler = param1TypeCastingHandler;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 232 */       ArrayList<StackManipulation> arrayList = new ArrayList();
/* 233 */       for (Iterator<ParameterDescription> iterator = this.methodDescription.getParameters().iterator(); iterator.hasNext(); ) {
/* 234 */         ParameterDescription parameterDescription; TypeDescription typeDescription = (parameterDescription = iterator.next()).getType().asErasure();
/* 235 */         arrayList.add(MethodVariableAccess.of((TypeDefinition)typeDescription).loadFrom(parameterDescription.getOffset()));
/* 236 */         arrayList.add(this.typeCastingHandler.ofIndex(typeDescription, parameterDescription.getIndex()));
/*     */       } 
/* 238 */       return (new StackManipulation.Compound(arrayList)).apply(param1MethodVisitor, param1Context);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation prependThisReference() {
/* 248 */       return (StackManipulation)(this.methodDescription.isStatic() ? this : new StackManipulation.Compound(new StackManipulation[] {
/*     */             
/* 250 */             MethodVariableAccess.loadThis(), (StackManipulation)this
/*     */           }));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public MethodLoading asBridgeOf(MethodDescription param1MethodDescription) {
/* 261 */       return new MethodLoading(this.methodDescription, new TypeCastingHandler.ForBridgeTarget(param1MethodDescription));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.methodDescription.equals(((MethodLoading)param1Object).methodDescription) ? false : (!!this.typeCastingHandler.equals(((MethodLoading)param1Object).typeCastingHandler)))));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.methodDescription.hashCode()) * 31 + this.typeCastingHandler.hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected static interface TypeCastingHandler
/*     */     {
/*     */       StackManipulation ofIndex(TypeDescription param2TypeDescription, int param2Int);
/*     */ 
/*     */       
/*     */       public enum NoOp
/*     */         implements TypeCastingHandler
/*     */       {
/* 286 */         INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public final StackManipulation ofIndex(TypeDescription param3TypeDescription, int param3Int) {
/* 292 */           return (StackManipulation)StackManipulation.Trivial.INSTANCE;
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @Enhance
/*     */       public static class ForBridgeTarget
/*     */         implements TypeCastingHandler
/*     */       {
/*     */         private final MethodDescription bridgeTarget;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public ForBridgeTarget(MethodDescription param3MethodDescription) {
/* 314 */           this.bridgeTarget = param3MethodDescription;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public StackManipulation ofIndex(TypeDescription param3TypeDescription, int param3Int)
/*     */         {
/* 321 */           TypeDescription typeDescription = ((ParameterDescription)this.bridgeTarget.getParameters().get(param3Int)).getType().asErasure();
/* 322 */           return (StackManipulation)(param3TypeDescription.equals(typeDescription) ? StackManipulation.Trivial.INSTANCE : 
/*     */             
/* 324 */             TypeCasting.to((TypeDefinition)typeDescription)); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.bridgeTarget.equals(((ForBridgeTarget)param3Object).bridgeTarget)))); } public int hashCode() { return getClass().hashCode() * 31 + this.bridgeTarget.hashCode(); } } } @Enhance public static class ForBridgeTarget implements TypeCastingHandler { private final MethodDescription bridgeTarget; public ForBridgeTarget(MethodDescription param2MethodDescription) { this.bridgeTarget = param2MethodDescription; } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.bridgeTarget.equals(((ForBridgeTarget)param2Object).bridgeTarget)))); } public StackManipulation ofIndex(TypeDescription param2TypeDescription, int param2Int) { TypeDescription typeDescription = ((ParameterDescription)this.bridgeTarget.getParameters().get(param2Int)).getType().asErasure(); return (StackManipulation)(param2TypeDescription.equals(typeDescription) ? StackManipulation.Trivial.INSTANCE : TypeCasting.to((TypeDefinition)typeDescription)); } public int hashCode() { return getClass().hashCode() * 31 + this.bridgeTarget.hashCode(); } } } public enum NoOp implements MethodLoading.TypeCastingHandler { INSTANCE; public final StackManipulation ofIndex(TypeDescription param1TypeDescription, int param1Int) { return (StackManipulation)StackManipulation.Trivial.INSTANCE; } } protected static interface TypeCastingHandler { StackManipulation ofIndex(TypeDescription param1TypeDescription, int param1Int); public enum NoOp implements TypeCastingHandler { INSTANCE; public final StackManipulation ofIndex(TypeDescription param3TypeDescription, int param3Int) { return (StackManipulation)StackManipulation.Trivial.INSTANCE; } } @Enhance public static class ForBridgeTarget implements TypeCastingHandler { public StackManipulation ofIndex(TypeDescription param3TypeDescription, int param3Int) { TypeDescription typeDescription = ((ParameterDescription)this.bridgeTarget.getParameters().get(param3Int)).getType().asErasure(); return (StackManipulation)(param3TypeDescription.equals(typeDescription) ? StackManipulation.Trivial.INSTANCE : TypeCasting.to((TypeDefinition)typeDescription)); }
/*     */ 
/*     */       
/*     */       private final MethodDescription bridgeTarget;
/*     */       
/*     */       public ForBridgeTarget(MethodDescription param3MethodDescription) {
/*     */         this.bridgeTarget = param3MethodDescription;
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param3Object) {
/*     */         return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.bridgeTarget.equals(((ForBridgeTarget)param3Object).bridgeTarget))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.bridgeTarget.hashCode();
/*     */       } } }
/*     */ 
/*     */   
/*     */   @Enhance(includeSyntheticFields = true)
/*     */   protected class OffsetLoading extends StackManipulation.AbstractBase {
/*     */     private final int offset;
/*     */     
/*     */     protected OffsetLoading(MethodVariableAccess this$0, int param1Int) {
/* 347 */       this.offset = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 354 */       param1MethodVisitor.visitVarInsn(MethodVariableAccess.a(this.a), this.offset);
/* 355 */       return MethodVariableAccess.b(this.a).toIncreasingSize();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.offset != ((OffsetLoading)param1Object).offset) ? false : (!!this.a.equals(((OffsetLoading)param1Object).a)))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.offset) * 31 + this.a.hashCode();
/*     */     }
/*     */   }
/*     */   
/*     */   @Enhance(includeSyntheticFields = true)
/*     */   protected class OffsetWriting
/*     */     extends StackManipulation.AbstractBase
/*     */   {
/*     */     private final int offset;
/*     */     
/*     */     protected OffsetWriting(MethodVariableAccess this$0, int param1Int) {
/* 376 */       this.offset = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 383 */       param1MethodVisitor.visitVarInsn(MethodVariableAccess.c(this.a), this.offset);
/* 384 */       return MethodVariableAccess.b(this.a).toDecreasingSize();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.offset != ((OffsetWriting)param1Object).offset) ? false : (!!this.a.equals(((OffsetWriting)param1Object).a)))));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.offset) * 31 + this.a.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   protected static class OffsetIncrementing
/*     */     extends StackManipulation.AbstractBase
/*     */   {
/*     */     private final int offset;
/*     */     
/*     */     private final int value;
/*     */ 
/*     */     
/*     */     protected OffsetIncrementing(int param1Int1, int param1Int2) {
/* 411 */       this.offset = param1Int1;
/* 412 */       this.value = param1Int2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 419 */       param1MethodVisitor.visitIincInsn(this.offset, this.value);
/* 420 */       return StackManipulation.Size.ZERO;
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.offset != ((OffsetIncrementing)param1Object).offset) ? false : (!(this.value != ((OffsetIncrementing)param1Object).value)))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.offset) * 31 + this.value;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\member\MethodVariableAccess.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */