/*     */ package net.bytebuddy.implementation.bytecode.assign.reference;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Queue;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.description.type.TypeList;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*     */ import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
/*     */ import net.bytebuddy.utility.QueueFactory;
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
/*     */ public enum GenericTypeAwareAssigner
/*     */   implements Assigner
/*     */ {
/*  42 */   INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StackManipulation assign(TypeDescription.Generic paramGeneric1, TypeDescription.Generic paramGeneric2, Assigner.Typing paramTyping) {
/*  48 */     if (paramGeneric1.isPrimitive() || paramGeneric2.isPrimitive()) {
/*  49 */       return paramGeneric1.equals(paramGeneric2) ? (StackManipulation)StackManipulation.Trivial.INSTANCE : (StackManipulation)StackManipulation.Illegal.INSTANCE;
/*     */     }
/*     */     
/*  52 */     if (((Boolean)paramGeneric1.accept(new IsAssignableToVisitor(paramGeneric2))).booleanValue())
/*  53 */       return (StackManipulation)StackManipulation.Trivial.INSTANCE; 
/*  54 */     if (paramTyping.isDynamic()) {
/*  55 */       return (StackManipulation)(paramGeneric1.asErasure().isAssignableTo(paramGeneric2.asErasure()) ? StackManipulation.Trivial.INSTANCE : 
/*     */         
/*  57 */         TypeCasting.to((TypeDefinition)paramGeneric2));
/*     */     }
/*  59 */     return (StackManipulation)StackManipulation.Illegal.INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   protected static class IsAssignableToVisitor
/*     */     implements TypeDescription.Generic.Visitor<Boolean>
/*     */   {
/*     */     private final TypeDescription.Generic typeDescription;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final boolean polymorphic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public IsAssignableToVisitor(TypeDescription.Generic param1Generic) {
/*  85 */       this(param1Generic, true);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected IsAssignableToVisitor(TypeDescription.Generic param1Generic, boolean param1Boolean) {
/*  95 */       this.typeDescription = param1Generic;
/*  96 */       this.polymorphic = param1Boolean;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Boolean onGenericArray(TypeDescription.Generic param1Generic) {
/* 103 */       return (Boolean)this.typeDescription.accept(new OfGenericArray(param1Generic, this.polymorphic));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Boolean onWildcard(TypeDescription.Generic param1Generic) {
/* 110 */       return (Boolean)this.typeDescription.accept(new OfWildcard(param1Generic));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Boolean onParameterizedType(TypeDescription.Generic param1Generic) {
/* 117 */       return (Boolean)this.typeDescription.accept(new OfParameterizedType(param1Generic, this.polymorphic));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Boolean onTypeVariable(TypeDescription.Generic param1Generic) {
/* 124 */       if (param1Generic.getTypeVariableSource().isInferrable())
/* 125 */         throw new UnsupportedOperationException("Assignability checks for type variables declared by methods are not currently supported"); 
/* 126 */       if (param1Generic.equals(this.typeDescription))
/* 127 */         return Boolean.TRUE; 
/* 128 */       if (this.polymorphic) {
/* 129 */         Queue<TypeDescription.Generic> queue = QueueFactory.make((Collection)param1Generic.getUpperBounds());
/* 130 */         while (!queue.isEmpty()) {
/*     */           TypeDescription.Generic generic;
/* 132 */           if (((Boolean)(generic = queue.remove()).accept(new IsAssignableToVisitor(this.typeDescription))).booleanValue())
/* 133 */             return Boolean.TRUE; 
/* 134 */           if (generic.getSort().isTypeVariable()) {
/* 135 */             queue.addAll((Collection<? extends TypeDescription.Generic>)generic.getUpperBounds());
/*     */           }
/*     */         } 
/* 138 */         return Boolean.FALSE;
/*     */       } 
/* 140 */       return Boolean.FALSE;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Boolean onNonGenericType(TypeDescription.Generic param1Generic) {
/* 148 */       return (Boolean)this.typeDescription.accept(new OfNonGenericType(param1Generic, this.polymorphic));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : ((this.polymorphic != ((IsAssignableToVisitor)param1Object).polymorphic) ? false : (!!this.typeDescription.equals(((IsAssignableToVisitor)param1Object).typeDescription)))));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.typeDescription.hashCode()) * 31 + this.polymorphic;
/*     */     }
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     protected static abstract class OfManifestType
/*     */       implements TypeDescription.Generic.Visitor<Boolean>
/*     */     {
/*     */       protected final TypeDescription.Generic typeDescription;
/*     */       
/*     */       protected final boolean polymorphic;
/*     */ 
/*     */       
/*     */       protected OfManifestType(TypeDescription.Generic param2Generic, boolean param2Boolean) {
/* 174 */         this.typeDescription = param2Generic;
/* 175 */         this.polymorphic = param2Boolean;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Boolean onWildcard(TypeDescription.Generic param2Generic) {
/* 182 */         for (TypeDescription.Generic generic : param2Generic.getUpperBounds()) {
/* 183 */           if (!((Boolean)this.typeDescription.accept(new GenericTypeAwareAssigner.IsAssignableToVisitor(generic))).booleanValue()) {
/* 184 */             return Boolean.FALSE;
/*     */           }
/*     */         } 
/* 187 */         for (Iterator<TypeDescription.Generic> iterator = param2Generic.getLowerBounds().iterator(); iterator.hasNext();) {
/* 188 */           if (!((Boolean)(generic = iterator.next()).accept(new GenericTypeAwareAssigner.IsAssignableToVisitor(this.typeDescription))).booleanValue()) {
/* 189 */             return Boolean.FALSE;
/*     */           }
/*     */         } 
/* 192 */         return Boolean.TRUE;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Boolean onTypeVariable(TypeDescription.Generic param2Generic) {
/* 199 */         if (param2Generic.getTypeVariableSource().isInferrable()) {
/* 200 */           throw new UnsupportedOperationException("Assignability checks for type variables declared by methods arel not currently supported");
/*     */         }
/* 202 */         return Boolean.FALSE;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.polymorphic != ((OfManifestType)param2Object).polymorphic) ? false : (!!this.typeDescription.equals(((OfManifestType)param2Object).typeDescription)))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return (getClass().hashCode() * 31 + this.typeDescription.hashCode()) * 31 + this.polymorphic;
/*     */       }
/*     */     }
/*     */     
/*     */     protected static abstract class OfSimpleType
/*     */       extends OfManifestType
/*     */     {
/*     */       protected OfSimpleType(TypeDescription.Generic param2Generic, boolean param2Boolean) {
/* 219 */         super(param2Generic, param2Boolean);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Boolean onParameterizedType(TypeDescription.Generic param2Generic) {
/* 226 */         Queue<TypeDescription.Generic> queue = QueueFactory.make(Collections.singleton(this.typeDescription));
/* 227 */         HashSet<TypeDescription> hashSet = new HashSet(Collections.singleton(this.typeDescription.asErasure())); while (true) {
/*     */           TypeDescription.Generic<TypeDescription.Generic> generic; TypeList.Generic generic1;
/*     */           TypeDescription.Generic generic2;
/* 230 */           if ((generic2 = queue.remove()).asErasure().equals(param2Generic.asErasure())) {
/* 231 */             if (generic2.getSort().isNonGeneric()) {
/* 232 */               return Boolean.TRUE;
/*     */             }
/* 234 */             TypeList.Generic generic3 = generic2.getTypeArguments();
/* 235 */             int i = (generic1 = param2Generic.getTypeArguments()).size();
/* 236 */             if (generic3.size() != i) {
/* 237 */               return Boolean.FALSE;
/*     */             }
/* 239 */             for (byte b = 0; b < i; b++) {
/* 240 */               if (!((Boolean)((TypeDescription.Generic)generic3.get(b)).accept(new GenericTypeAwareAssigner.IsAssignableToVisitor((TypeDescription.Generic)generic1.get(b), false))).booleanValue()) {
/* 241 */                 return Boolean.FALSE;
/*     */               }
/*     */             } 
/*     */             
/* 245 */             return Boolean.valueOf(((generic = param2Generic.getOwnerType()) == null || ((Boolean)generic.accept(new GenericTypeAwareAssigner.IsAssignableToVisitor(generic))).booleanValue()));
/*     */           } 
/* 247 */           if (this.polymorphic) {
/*     */             TypeDescription.Generic generic3;
/* 249 */             if ((generic3 = generic1.getSuperClass()) != null && hashSet.add(generic3.asErasure())) {
/* 250 */               generic.add(generic3);
/*     */             }
/* 252 */             for (TypeDescription.Generic generic4 : generic1.getInterfaces()) {
/* 253 */               if (hashSet.add(generic4.asErasure())) {
/* 254 */                 generic.add(generic4);
/*     */               }
/*     */             } 
/*     */           } 
/* 258 */           if (generic.isEmpty()) {
/* 259 */             return Boolean.FALSE;
/*     */           }
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       public Boolean onNonGenericType(TypeDescription.Generic param2Generic) {
/* 266 */         return Boolean.valueOf(this.polymorphic ? this.typeDescription
/* 267 */             .asErasure().isAssignableTo(param2Generic.asErasure()) : this.typeDescription
/* 268 */             .asErasure().equals(param2Generic.asErasure()));
/*     */       }
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
/*     */     protected static class OfGenericArray
/*     */       extends OfManifestType
/*     */     {
/*     */       protected OfGenericArray(TypeDescription.Generic param2Generic, boolean param2Boolean) {
/* 284 */         super(param2Generic, param2Boolean);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*     */       public Boolean onGenericArray(TypeDescription.Generic param2Generic) {
/* 292 */         TypeDescription.Generic generic = this.typeDescription.getComponentType(); param2Generic = param2Generic.getComponentType();
/* 293 */         while (generic.getSort().isGenericArray() && param2Generic.getSort().isGenericArray()) {
/* 294 */           generic = generic.getComponentType();
/* 295 */           param2Generic = param2Generic.getComponentType();
/*     */         } 
/* 297 */         return Boolean.valueOf((!generic.getSort().isGenericArray() && !param2Generic.getSort().isGenericArray() && ((Boolean)generic.accept(new GenericTypeAwareAssigner.IsAssignableToVisitor(param2Generic))).booleanValue()));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Boolean onParameterizedType(TypeDescription.Generic param2Generic) {
/* 304 */         return Boolean.FALSE;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Boolean onNonGenericType(TypeDescription.Generic param2Generic) {
/* 311 */         return Boolean.valueOf(this.polymorphic ? this.typeDescription
/* 312 */             .asErasure().isAssignableTo(param2Generic.asErasure()) : this.typeDescription
/* 313 */             .asErasure().equals(param2Generic.asErasure()));
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     protected static class OfWildcard
/*     */       implements TypeDescription.Generic.Visitor<Boolean>
/*     */     {
/*     */       private final TypeDescription.Generic wildcard;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected OfWildcard(TypeDescription.Generic param2Generic) {
/* 334 */         this.wildcard = param2Generic;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Boolean onGenericArray(TypeDescription.Generic param2Generic) {
/* 341 */         return Boolean.FALSE;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Boolean onWildcard(TypeDescription.Generic param2Generic) {
/* 348 */         boolean bool1 = false, bool2 = false;
/* 349 */         for (TypeDescription.Generic generic : param2Generic.getUpperBounds()) {
/* 350 */           for (Iterator<TypeDescription.Generic> iterator = this.wildcard.getUpperBounds().iterator(); iterator.hasNext();) {
/* 351 */             if (!((Boolean)(generic1 = iterator.next()).accept(new GenericTypeAwareAssigner.IsAssignableToVisitor(generic))).booleanValue()) {
/* 352 */               return Boolean.FALSE;
/*     */             }
/*     */           } 
/* 355 */           bool1 = (bool1 || !generic.represents(Object.class)) ? true : false;
/*     */         } 
/* 357 */         for (TypeDescription.Generic generic : param2Generic.getLowerBounds()) {
/* 358 */           for (TypeDescription.Generic generic1 : this.wildcard.getLowerBounds()) {
/* 359 */             if (!((Boolean)generic.accept(new GenericTypeAwareAssigner.IsAssignableToVisitor(generic1))).booleanValue()) {
/* 360 */               return Boolean.FALSE;
/*     */             }
/*     */           } 
/* 363 */           bool2 = true;
/*     */         } 
/* 365 */         if (bool1)
/* 366 */           return Boolean.valueOf(this.wildcard.getLowerBounds().isEmpty()); 
/* 367 */         if (bool2) {
/*     */           TypeList.Generic generic;
/* 369 */           return Boolean.valueOf(((generic = this.wildcard.getUpperBounds()).size() == 0 || (generic.size() == 1 && ((TypeDescription.Generic)generic.getOnly()).represents(Object.class))));
/*     */         } 
/* 371 */         return Boolean.TRUE;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Boolean onParameterizedType(TypeDescription.Generic param2Generic) {
/* 379 */         return Boolean.FALSE;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Boolean onTypeVariable(TypeDescription.Generic param2Generic) {
/* 386 */         return Boolean.FALSE;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Boolean onNonGenericType(TypeDescription.Generic param2Generic) {
/* 393 */         return Boolean.FALSE;
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.wildcard.equals(((OfWildcard)param2Object).wildcard))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.wildcard.hashCode();
/*     */       }
/*     */     }
/*     */     
/*     */     protected static class OfParameterizedType
/*     */       extends OfSimpleType
/*     */     {
/*     */       protected OfParameterizedType(TypeDescription.Generic param2Generic, boolean param2Boolean) {
/* 409 */         super(param2Generic, param2Boolean);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Boolean onGenericArray(TypeDescription.Generic param2Generic) {
/* 416 */         return Boolean.FALSE;
/*     */       }
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
/*     */     protected static class OfNonGenericType
/*     */       extends OfSimpleType
/*     */     {
/*     */       protected OfNonGenericType(TypeDescription.Generic param2Generic, boolean param2Boolean) {
/* 432 */         super(param2Generic, param2Boolean);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Boolean onGenericArray(TypeDescription.Generic param2Generic) {
/* 439 */         return Boolean.valueOf(this.polymorphic ? this.typeDescription
/* 440 */             .asErasure().isAssignableTo(param2Generic.asErasure()) : this.typeDescription
/* 441 */             .asErasure().equals(param2Generic.asErasure()));
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\assign\reference\GenericTypeAwareAssigner.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */