/*     */ package net.bytebuddy.implementation.bytecode.constant;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.security.PrivilegedExceptionAction;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.auxiliary.PrivilegedMemberLookupAction;
/*     */ import net.bytebuddy.implementation.bytecode.Duplication;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.TypeCreation;
/*     */ import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
/*     */ import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
/*     */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
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
/*     */ public abstract class MethodConstant
/*     */   extends StackManipulation.AbstractBase
/*     */ {
/*     */   @MaybeNull
/*  52 */   protected static final MethodDescription.InDefinedShape DO_PRIVILEGED = doPrivileged();
/*     */ 
/*     */ 
/*     */   
/*     */   protected final MethodDescription.InDefinedShape methodDescription;
/*     */ 
/*     */ 
/*     */   
/*     */   @MaybeNull
/*     */   @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.")
/*     */   private static MethodDescription.InDefinedShape doPrivileged() {
/*     */     MethodDescription.InDefinedShape inDefinedShape;
/*     */     try {
/*  65 */       inDefinedShape = (MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(Class.forName("java.security.AccessController").getMethod("doPrivileged", new Class[] { PrivilegedExceptionAction.class }));
/*     */       try {
/*  67 */         if (!Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"))) {
/*  68 */           inDefinedShape = null;
/*     */         }
/*  70 */       } catch (SecurityException securityException) {}
/*     */     
/*     */     }
/*  73 */     catch (Exception exception) {
/*  74 */       inDefinedShape = null;
/*     */     } 
/*  76 */     return inDefinedShape;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected MethodConstant(MethodDescription.InDefinedShape paramInDefinedShape) {
/*  91 */     this.methodDescription = paramInDefinedShape;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CanCache of(MethodDescription.InDefinedShape paramInDefinedShape) {
/* 101 */     if (paramInDefinedShape.isTypeInitializer())
/* 102 */       return CanCacheIllegal.INSTANCE; 
/* 103 */     if (paramInDefinedShape.isConstructor()) {
/* 104 */       return new ForConstructor(paramInDefinedShape);
/*     */     }
/* 106 */     return new ForMethod(paramInDefinedShape);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CanCache ofPrivileged(MethodDescription.InDefinedShape paramInDefinedShape) {
/* 119 */     if (DO_PRIVILEGED == null) {
/* 120 */       return of(paramInDefinedShape);
/*     */     }
/* 122 */     if (paramInDefinedShape.isTypeInitializer())
/* 123 */       return CanCacheIllegal.INSTANCE; 
/* 124 */     if (paramInDefinedShape.isConstructor()) {
/* 125 */       return (new ForConstructor(paramInDefinedShape)).withPrivilegedLookup();
/*     */     }
/* 127 */     return (new ForMethod(paramInDefinedShape)).withPrivilegedLookup();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static List<StackManipulation> typeConstantsFor(List<TypeDescription> paramList) {
/* 139 */     ArrayList<StackManipulation> arrayList = new ArrayList(paramList.size());
/* 140 */     for (TypeDescription typeDescription : paramList) {
/* 141 */       arrayList.add(ClassConstant.of(typeDescription));
/*     */     }
/* 143 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StackManipulation.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext) {
/* 150 */     return (new StackManipulation.Compound(new StackManipulation[] {
/* 151 */           ClassConstant.of(this.methodDescription.getDeclaringType()), 
/* 152 */           methodName(), 
/* 153 */           ArrayFactory.forType(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Class.class))
/* 154 */           .withValues(typeConstantsFor((List<TypeDescription>)this.methodDescription.getParameters().asTypeList().asErasures())), 
/* 155 */           (StackManipulation)MethodInvocation.invoke(accessorMethod())
/* 156 */         })).apply(paramMethodVisitor, paramContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CanCache withPrivilegedLookup() {
/* 165 */     return new PrivilegedLookup(this.methodDescription, methodName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract StackManipulation methodName();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract MethodDescription.InDefinedShape accessorMethod();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 184 */     return this.methodDescription.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/* 189 */     if (this == paramObject)
/* 190 */       return true; 
/* 191 */     if (paramObject == null || getClass() != paramObject.getClass()) {
/* 192 */       return false;
/*     */     }
/* 194 */     paramObject = paramObject;
/* 195 */     return this.methodDescription.equals(((MethodConstant)paramObject).methodDescription);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected enum CanCacheIllegal
/*     */     implements CanCache
/*     */   {
/* 206 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final StackManipulation cached() {
/* 212 */       return (StackManipulation)StackManipulation.Illegal.INSTANCE;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isValid() {
/* 219 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 226 */       return StackManipulation.Illegal.INSTANCE.apply(param1MethodVisitor, param1Context);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface CanCache
/*     */     extends StackManipulation
/*     */   {
/*     */     StackManipulation cached();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class ForMethod
/*     */     extends MethodConstant
/*     */     implements CanCache
/*     */   {
/*     */     private static final MethodDescription.InDefinedShape GET_METHOD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape GET_DECLARED_METHOD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/*     */       try {
/* 268 */         GET_METHOD = (MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(Class.class.getMethod("getMethod", new Class[] { String.class, Class[].class }));
/* 269 */         GET_DECLARED_METHOD = (MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(Class.class.getMethod("getDeclaredMethod", new Class[] { String.class, Class[].class })); return;
/* 270 */       } catch (NoSuchMethodException noSuchMethodException) {
/* 271 */         throw new IllegalStateException("Could not locate method lookup", noSuchMethodException);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ForMethod(MethodDescription.InDefinedShape param1InDefinedShape) {
/* 282 */       super(param1InDefinedShape);
/*     */     }
/*     */ 
/*     */     
/*     */     protected StackManipulation methodName() {
/* 287 */       return (StackManipulation)new TextConstant(this.methodDescription.getInternalName());
/*     */     }
/*     */ 
/*     */     
/*     */     protected MethodDescription.InDefinedShape accessorMethod() {
/* 292 */       return this.methodDescription.isPublic() ? GET_METHOD : GET_DECLARED_METHOD;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation cached() {
/* 301 */       return new MethodConstant.CachedMethod(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class ForConstructor
/*     */     extends MethodConstant
/*     */     implements CanCache
/*     */   {
/*     */     private static final MethodDescription.InDefinedShape GET_CONSTRUCTOR;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final MethodDescription.InDefinedShape GET_DECLARED_CONSTRUCTOR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/*     */       try {
/* 326 */         GET_CONSTRUCTOR = (MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(Class.class.getMethod("getConstructor", new Class[] { Class[].class }));
/* 327 */         GET_DECLARED_CONSTRUCTOR = (MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(Class.class.getMethod("getDeclaredConstructor", new Class[] { Class[].class })); return;
/* 328 */       } catch (NoSuchMethodException noSuchMethodException) {
/* 329 */         throw new IllegalStateException("Could not locate Class::getDeclaredConstructor", noSuchMethodException);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ForConstructor(MethodDescription.InDefinedShape param1InDefinedShape) {
/* 340 */       super(param1InDefinedShape);
/*     */     }
/*     */ 
/*     */     
/*     */     protected StackManipulation methodName() {
/* 345 */       return (StackManipulation)StackManipulation.Trivial.INSTANCE;
/*     */     }
/*     */ 
/*     */     
/*     */     protected MethodDescription.InDefinedShape accessorMethod() {
/* 350 */       return this.methodDescription.isPublic() ? GET_CONSTRUCTOR : GET_DECLARED_CONSTRUCTOR;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation cached() {
/* 359 */       return new MethodConstant.CachedConstructor(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class PrivilegedLookup
/*     */     implements StackManipulation, CanCache
/*     */   {
/*     */     private final MethodDescription.InDefinedShape methodDescription;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final StackManipulation methodName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected PrivilegedLookup(MethodDescription.InDefinedShape param1InDefinedShape, StackManipulation param1StackManipulation) {
/* 385 */       this.methodDescription = param1InDefinedShape;
/* 386 */       this.methodName = param1StackManipulation;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isValid() {
/* 393 */       return this.methodName.isValid();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 400 */       if (MethodConstant.DO_PRIVILEGED == null) {
/* 401 */         throw new IllegalStateException("Privileged method invocation is not supported on the current VM");
/*     */       }
/* 403 */       TypeDescription typeDescription = param1Context.register(PrivilegedMemberLookupAction.of((MethodDescription)this.methodDescription));
/* 404 */       return (new StackManipulation.Compound(new StackManipulation[] {
/* 405 */             TypeCreation.of(typeDescription), (StackManipulation)Duplication.SINGLE, 
/*     */             
/* 407 */             ClassConstant.of(this.methodDescription.getDeclaringType()), this.methodName, 
/*     */             
/* 409 */             ArrayFactory.forType(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Class.class))
/* 410 */             .withValues(MethodConstant.typeConstantsFor((List<TypeDescription>)this.methodDescription.getParameters().asTypeList().asErasures())), 
/* 411 */             (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)((MethodList)typeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor())).getOnly()), 
/* 412 */             (StackManipulation)MethodInvocation.invoke(MethodConstant.DO_PRIVILEGED), 
/* 413 */             TypeCasting.to((TypeDefinition)TypeDescription.ForLoadedType.of(this.methodDescription.isConstructor() ? Constructor.class : Method.class))
/*     */ 
/*     */           
/* 416 */           })).apply(param1MethodVisitor, param1Context);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation cached() {
/* 423 */       return (StackManipulation)(this.methodDescription.isConstructor() ? new MethodConstant.CachedConstructor(this) : new MethodConstant.CachedMethod(this));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 430 */       return this.methodDescription.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/* 435 */       if (this == param1Object)
/* 436 */         return true; 
/* 437 */       if (param1Object == null || getClass() != param1Object.getClass()) {
/* 438 */         return false;
/*     */       }
/* 440 */       param1Object = param1Object;
/* 441 */       return this.methodDescription.equals(((PrivilegedLookup)param1Object).methodDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class CachedMethod
/*     */     implements StackManipulation
/*     */   {
/* 453 */     private static final TypeDescription METHOD_TYPE = TypeDescription.ForLoadedType.of(Method.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final StackManipulation methodConstant;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected CachedMethod(StackManipulation param1StackManipulation) {
/* 466 */       this.methodConstant = param1StackManipulation;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isValid() {
/* 473 */       return this.methodConstant.isValid();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 480 */       return FieldAccess.forField(param1Context.cache(this.methodConstant, METHOD_TYPE))
/* 481 */         .read()
/* 482 */         .apply(param1MethodVisitor, param1Context);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 487 */       return this.methodConstant.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/* 492 */       if (this == param1Object)
/* 493 */         return true; 
/* 494 */       if (param1Object == null || getClass() != param1Object.getClass()) {
/* 495 */         return false;
/*     */       }
/* 497 */       param1Object = param1Object;
/* 498 */       return this.methodConstant.equals(((CachedMethod)param1Object).methodConstant);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class CachedConstructor
/*     */     implements StackManipulation
/*     */   {
/* 510 */     private static final TypeDescription CONSTRUCTOR_TYPE = TypeDescription.ForLoadedType.of(Constructor.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final StackManipulation constructorConstant;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected CachedConstructor(StackManipulation param1StackManipulation) {
/* 523 */       this.constructorConstant = param1StackManipulation;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isValid() {
/* 530 */       return this.constructorConstant.isValid();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 537 */       return FieldAccess.forField(param1Context.cache(this.constructorConstant, CONSTRUCTOR_TYPE))
/* 538 */         .read()
/* 539 */         .apply(param1MethodVisitor, param1Context);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 544 */       return this.constructorConstant.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/* 549 */       if (this == param1Object)
/* 550 */         return true; 
/* 551 */       if (param1Object == null || getClass() != param1Object.getClass()) {
/* 552 */         return false;
/*     */       }
/* 554 */       param1Object = param1Object;
/* 555 */       return this.constructorConstant.equals(((CachedConstructor)param1Object).constructorConstant);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\constant\MethodConstant.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */