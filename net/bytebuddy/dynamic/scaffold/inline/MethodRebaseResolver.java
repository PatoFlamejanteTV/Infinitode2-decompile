/*     */ package net.bytebuddy.dynamic.scaffold.inline;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.bytebuddy.ClassFileVersion;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.annotation.AnnotationList;
/*     */ import net.bytebuddy.description.annotation.AnnotationValue;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.ParameterDescription;
/*     */ import net.bytebuddy.description.method.ParameterList;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.description.type.TypeList;
/*     */ import net.bytebuddy.dynamic.DynamicType;
/*     */ import net.bytebuddy.implementation.MethodAccessorFactory;
/*     */ import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
/*     */ import net.bytebuddy.implementation.auxiliary.TrivialType;
/*     */ import net.bytebuddy.utility.CompoundList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface MethodRebaseResolver
/*     */ {
/*     */   Resolution resolve(MethodDescription.InDefinedShape paramInDefinedShape);
/*     */   
/*     */   List<DynamicType> getAuxiliaryTypes();
/*     */   
/*     */   Map<MethodDescription.SignatureToken, Resolution> asTokenMap();
/*     */   
/*     */   public enum Disabled
/*     */     implements MethodRebaseResolver
/*     */   {
/*  78 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final MethodRebaseResolver.Resolution resolve(MethodDescription.InDefinedShape param1InDefinedShape) {
/*  84 */       return new MethodRebaseResolver.Resolution.Preserved(param1InDefinedShape);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final List<DynamicType> getAuxiliaryTypes() {
/*  91 */       return Collections.emptyList();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Map<MethodDescription.SignatureToken, MethodRebaseResolver.Resolution> asTokenMap() {
/*  98 */       return Collections.emptyMap();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Resolution
/*     */   {
/*     */     boolean isRebased();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     MethodDescription.InDefinedShape getResolvedMethod();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TypeList getAppendedParameters();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     public static class Preserved
/*     */       implements Resolution
/*     */     {
/*     */       private final MethodDescription.InDefinedShape methodDescription;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Preserved(MethodDescription.InDefinedShape param2InDefinedShape) {
/* 147 */         this.methodDescription = param2InDefinedShape;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean isRebased() {
/* 154 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public MethodDescription.InDefinedShape getResolvedMethod() {
/* 161 */         return this.methodDescription;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public TypeList getAppendedParameters() {
/* 168 */         throw new IllegalStateException("Cannot process additional parameters for non-rebased method: " + this.methodDescription);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.methodDescription.equals(((Preserved)param2Object).methodDescription))));
/*     */       }
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.methodDescription.hashCode();
/*     */       }
/*     */     }
/*     */     
/*     */     @Enhance
/*     */     public static class ForRebasedMethod
/*     */       implements Resolution
/*     */     {
/*     */       private final MethodDescription.InDefinedShape methodDescription;
/*     */       
/*     */       protected ForRebasedMethod(MethodDescription.InDefinedShape param2InDefinedShape) {
/* 189 */         this.methodDescription = param2InDefinedShape;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public static MethodRebaseResolver.Resolution of(TypeDescription param2TypeDescription, MethodDescription.InDefinedShape param2InDefinedShape, MethodNameTransformer param2MethodNameTransformer) {
/* 203 */         return new ForRebasedMethod((MethodDescription.InDefinedShape)new RebasedMethod(param2TypeDescription, param2InDefinedShape, param2MethodNameTransformer));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean isRebased() {
/* 210 */         return true;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public MethodDescription.InDefinedShape getResolvedMethod() {
/* 217 */         return this.methodDescription;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public TypeList getAppendedParameters() {
/* 224 */         return (TypeList)new TypeList.Empty();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.methodDescription.equals(((ForRebasedMethod)param2Object).methodDescription))));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.methodDescription.hashCode();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       protected static class RebasedMethod
/*     */         extends MethodDescription.InDefinedShape.AbstractBase
/*     */       {
/*     */         private final TypeDescription instrumentedType;
/*     */ 
/*     */         
/*     */         private final MethodDescription.InDefinedShape methodDescription;
/*     */ 
/*     */         
/*     */         private final MethodNameTransformer methodNameTransformer;
/*     */ 
/*     */ 
/*     */         
/*     */         protected RebasedMethod(TypeDescription param3TypeDescription, MethodDescription.InDefinedShape param3InDefinedShape, MethodNameTransformer param3MethodNameTransformer) {
/* 255 */           this.instrumentedType = param3TypeDescription;
/* 256 */           this.methodDescription = param3InDefinedShape;
/* 257 */           this.methodNameTransformer = param3MethodNameTransformer;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public TypeDescription.Generic getReturnType() {
/* 264 */           return this.methodDescription.getReturnType().asRawType();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
/* 271 */           return (ParameterList<ParameterDescription.InDefinedShape>)new ParameterList.Explicit.ForTypes((MethodDescription.InDefinedShape)this, (List)this.methodDescription.getParameters().asTypeList().asRawTypes());
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public TypeList.Generic getExceptionTypes() {
/* 278 */           return this.methodDescription.getExceptionTypes().asRawTypes();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         @AlwaysNull
/*     */         public AnnotationValue<?, ?> getDefaultValue() {
/* 286 */           return AnnotationValue.UNDEFINED;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public TypeList.Generic getTypeVariables() {
/* 293 */           return (TypeList.Generic)new TypeList.Generic.Empty();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public AnnotationList getDeclaredAnnotations() {
/* 300 */           return (AnnotationList)new AnnotationList.Empty();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public TypeDescription getDeclaringType() {
/* 308 */           return this.methodDescription.getDeclaringType();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public int getModifiers() {
/* 315 */           return 0x1000 | (
/* 316 */             this.methodDescription.isStatic() ? 8 : 0) | (
/* 317 */             this.methodDescription.isNative() ? 272 : 0) | ((this.instrumentedType
/* 318 */             .isInterface() && !this.methodDescription.isNative()) ? 1 : 2);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public String getInternalName() {
/* 325 */           return this.methodNameTransformer.transform((MethodDescription)this.methodDescription);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     public static class ForRebasedConstructor
/*     */       implements Resolution
/*     */     {
/*     */       private final MethodDescription.InDefinedShape methodDescription;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final TypeDescription placeholderType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected ForRebasedConstructor(MethodDescription.InDefinedShape param2InDefinedShape, TypeDescription param2TypeDescription) {
/* 353 */         this.methodDescription = param2InDefinedShape;
/* 354 */         this.placeholderType = param2TypeDescription;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public static MethodRebaseResolver.Resolution of(MethodDescription.InDefinedShape param2InDefinedShape, TypeDescription param2TypeDescription) {
/* 365 */         return new ForRebasedConstructor((MethodDescription.InDefinedShape)new RebasedConstructor(param2InDefinedShape, param2TypeDescription), param2TypeDescription);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean isRebased() {
/* 372 */         return true;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public MethodDescription.InDefinedShape getResolvedMethod() {
/* 379 */         return this.methodDescription;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public TypeList getAppendedParameters() {
/* 386 */         return (TypeList)new TypeList.Explicit(new TypeDescription[] { this.placeholderType });
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.methodDescription.equals(((ForRebasedConstructor)param2Object).methodDescription) ? false : (!!this.placeholderType.equals(((ForRebasedConstructor)param2Object).placeholderType)))));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return (getClass().hashCode() * 31 + this.methodDescription.hashCode()) * 31 + this.placeholderType.hashCode();
/*     */       }
/*     */ 
/*     */       
/*     */       protected static class RebasedConstructor
/*     */         extends MethodDescription.InDefinedShape.AbstractBase
/*     */       {
/*     */         private final MethodDescription.InDefinedShape methodDescription;
/*     */         
/*     */         private final TypeDescription placeholderType;
/*     */ 
/*     */         
/*     */         protected RebasedConstructor(MethodDescription.InDefinedShape param3InDefinedShape, TypeDescription param3TypeDescription) {
/* 411 */           this.methodDescription = param3InDefinedShape;
/* 412 */           this.placeholderType = param3TypeDescription;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public TypeDescription.Generic getReturnType() {
/* 419 */           return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(void.class);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
/* 426 */           return (ParameterList<ParameterDescription.InDefinedShape>)new ParameterList.Explicit.ForTypes((MethodDescription.InDefinedShape)this, CompoundList.of((List)this.methodDescription.getParameters().asTypeList().asErasures(), this.placeholderType));
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public TypeList.Generic getExceptionTypes() {
/* 433 */           return this.methodDescription.getExceptionTypes().asRawTypes();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         @AlwaysNull
/*     */         public AnnotationValue<?, ?> getDefaultValue() {
/* 441 */           return AnnotationValue.UNDEFINED;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public TypeList.Generic getTypeVariables() {
/* 448 */           return (TypeList.Generic)new TypeList.Generic.Empty();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public AnnotationList getDeclaredAnnotations() {
/* 455 */           return (AnnotationList)new AnnotationList.Empty();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public TypeDescription getDeclaringType() {
/* 463 */           return this.methodDescription.getDeclaringType();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public int getModifiers() {
/* 470 */           return 4098;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public String getInternalName() {
/* 477 */           return "<init>";
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Default
/*     */     implements MethodRebaseResolver
/*     */   {
/*     */     private final Map<MethodDescription.InDefinedShape, MethodRebaseResolver.Resolution> resolutions;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final List<DynamicType> dynamicTypes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected Default(Map<MethodDescription.InDefinedShape, MethodRebaseResolver.Resolution> param1Map, List<DynamicType> param1List) {
/* 506 */       this.resolutions = param1Map;
/* 507 */       this.dynamicTypes = param1List;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static MethodRebaseResolver make(TypeDescription param1TypeDescription, Set<? extends MethodDescription.SignatureToken> param1Set, ClassFileVersion param1ClassFileVersion, AuxiliaryType.NamingStrategy param1NamingStrategy, MethodNameTransformer param1MethodNameTransformer) {
/* 525 */       DynamicType dynamicType = null;
/* 526 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 527 */       for (MethodDescription.InDefinedShape inDefinedShape : param1TypeDescription.getDeclaredMethods()) {
/* 528 */         if (param1Set.contains(inDefinedShape.asSignatureToken())) {
/*     */           MethodRebaseResolver.Resolution resolution;
/* 530 */           if (inDefinedShape.isConstructor()) {
/* 531 */             if (dynamicType == null) {
/* 532 */               dynamicType = TrivialType.SIGNATURE_RELEVANT.make(param1NamingStrategy.name(param1TypeDescription, (AuxiliaryType)TrivialType.SIGNATURE_RELEVANT), param1ClassFileVersion, (MethodAccessorFactory)MethodAccessorFactory.Illegal.INSTANCE);
/*     */             }
/*     */ 
/*     */             
/* 536 */             resolution = MethodRebaseResolver.Resolution.ForRebasedConstructor.of(inDefinedShape, dynamicType.getTypeDescription());
/*     */           } else {
/* 538 */             resolution = MethodRebaseResolver.Resolution.ForRebasedMethod.of(param1TypeDescription, inDefinedShape, param1MethodNameTransformer);
/*     */           } 
/* 540 */           hashMap.put(inDefinedShape, resolution);
/*     */         } 
/*     */       } 
/* 543 */       return (dynamicType == null) ? new Default((Map)hashMap, 
/* 544 */           Collections.emptyList()) : new Default((Map)hashMap, 
/* 545 */           Collections.singletonList(dynamicType));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public MethodRebaseResolver.Resolution resolve(MethodDescription.InDefinedShape param1InDefinedShape) {
/*     */       MethodRebaseResolver.Resolution resolution;
/* 553 */       return ((resolution = this.resolutions.get(param1InDefinedShape)) == null) ? new MethodRebaseResolver.Resolution.Preserved(param1InDefinedShape) : resolution;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<DynamicType> getAuxiliaryTypes() {
/* 562 */       return this.dynamicTypes;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Map<MethodDescription.SignatureToken, MethodRebaseResolver.Resolution> asTokenMap() {
/* 569 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 570 */       for (Map.Entry<MethodDescription.InDefinedShape, MethodRebaseResolver.Resolution> entry : this.resolutions.entrySet()) {
/* 571 */         hashMap.put(((MethodDescription.InDefinedShape)entry.getKey()).asSignatureToken(), entry.getValue());
/*     */       }
/* 573 */       return (Map)hashMap;
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.resolutions.equals(((Default)param1Object).resolutions) ? false : (!!this.dynamicTypes.equals(((Default)param1Object).dynamicTypes)))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.resolutions.hashCode()) * 31 + this.dynamicTypes.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\scaffold\inline\MethodRebaseResolver.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */