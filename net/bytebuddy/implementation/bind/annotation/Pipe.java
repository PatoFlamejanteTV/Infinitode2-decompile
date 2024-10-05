/*     */ package net.bytebuddy.implementation.bind.annotation;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.annotation.Documented;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import net.bytebuddy.ByteBuddy;
/*     */ import net.bytebuddy.ClassFileVersion;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.field.FieldList;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.method.ParameterDescription;
/*     */ import net.bytebuddy.description.modifier.ModifierContributor;
/*     */ import net.bytebuddy.description.modifier.Visibility;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.description.type.TypeList;
/*     */ import net.bytebuddy.dynamic.DynamicType;
/*     */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*     */ import net.bytebuddy.dynamic.scaffold.TypeValidation;
/*     */ import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.MethodAccessorFactory;
/*     */ import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
/*     */ import net.bytebuddy.implementation.bind.MethodDelegationBinder;
/*     */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*     */ import net.bytebuddy.implementation.bytecode.Duplication;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.TypeCreation;
/*     */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*     */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodReturn;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
/*     */ import net.bytebuddy.utility.RandomString;
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
/*     */ @Documented
/*     */ @Retention(RetentionPolicy.RUNTIME)
/*     */ @Target({ElementType.PARAMETER})
/*     */ public @interface Pipe
/*     */ {
/*     */   boolean serializableProxy() default false;
/*     */   
/*     */   @Enhance
/*     */   public static class Binder
/*     */     implements TargetMethodAnnotationDrivenBinder.ParameterBinder<Pipe>
/*     */   {
/*  99 */     private static final MethodDescription.InDefinedShape SERIALIZABLE_PROXY = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(Pipe.class)
/* 100 */       .getDeclaredMethods()
/* 101 */       .filter((ElementMatcher)ElementMatchers.named("serializableProxy")))
/* 102 */       .getOnly();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final MethodDescription forwardingMethod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected Binder(MethodDescription param1MethodDescription) {
/* 121 */       this.forwardingMethod = param1MethodDescription;
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
/*     */     public static TargetMethodAnnotationDrivenBinder.ParameterBinder<Pipe> install(Class<?> param1Class) {
/* 135 */       return install(TypeDescription.ForLoadedType.of(param1Class));
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
/*     */     public static TargetMethodAnnotationDrivenBinder.ParameterBinder<Pipe> install(TypeDescription param1TypeDescription) {
/* 149 */       return new Binder(onlyMethod(param1TypeDescription));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static MethodDescription onlyMethod(TypeDescription param1TypeDescription) {
/* 159 */       if (!param1TypeDescription.isInterface())
/* 160 */         throw new IllegalArgumentException(param1TypeDescription + " is not an interface"); 
/* 161 */       if (!param1TypeDescription.getInterfaces().isEmpty())
/* 162 */         throw new IllegalArgumentException(param1TypeDescription + " must not extend other interfaces"); 
/* 163 */       if (!param1TypeDescription.isPublic()) {
/* 164 */         throw new IllegalArgumentException(param1TypeDescription + " is mot public");
/*     */       }
/*     */       MethodList methodList;
/* 167 */       if ((methodList = (MethodList)param1TypeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isAbstract())).size() != 1) {
/* 168 */         throw new IllegalArgumentException(param1TypeDescription + " must declare exactly one abstract method");
/*     */       }
/*     */       MethodDescription methodDescription;
/* 171 */       if (!(methodDescription = (MethodDescription)methodList.getOnly()).getReturnType().asErasure().represents(Object.class))
/* 172 */         throw new IllegalArgumentException(methodDescription + " does not return an Object-type"); 
/* 173 */       if (methodDescription.getParameters().size() != 1 || !((ParameterDescription)methodDescription.getParameters().getOnly()).getType().asErasure().represents(Object.class)) {
/* 174 */         throw new IllegalArgumentException(methodDescription + " does not take a single Object-typed argument");
/*     */       }
/* 176 */       return methodDescription;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Class<Pipe> getHandledType() {
/* 183 */       return Pipe.class;
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
/*     */     public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<Pipe> param1Loadable, MethodDescription param1MethodDescription, ParameterDescription param1ParameterDescription, Implementation.Target param1Target, Assigner param1Assigner, Assigner.Typing param1Typing) {
/* 195 */       if (!param1ParameterDescription.getType().asErasure().equals(this.forwardingMethod.getDeclaringType()))
/* 196 */         throw new IllegalStateException("Illegal use of @Pipe for " + param1ParameterDescription + " which was installed for " + this.forwardingMethod.getDeclaringType()); 
/* 197 */       if (param1MethodDescription.isStatic()) {
/* 198 */         return (MethodDelegationBinder.ParameterBinding<?>)MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
/*     */       }
/* 200 */       return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous((StackManipulation)new RedirectionProxy(this.forwardingMethod.getDeclaringType().asErasure(), param1MethodDescription, param1Assigner, ((Boolean)param1Loadable
/*     */ 
/*     */             
/* 203 */             .getValue(SERIALIZABLE_PROXY).resolve(Boolean.class)).booleanValue()));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.forwardingMethod.equals(((Binder)param1Object).forwardingMethod))));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.forwardingMethod.hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     protected static class RedirectionProxy
/*     */       extends StackManipulation.AbstractBase
/*     */       implements AuxiliaryType
/*     */     {
/*     */       private static final String FIELD_NAME_PREFIX = "argument";
/*     */ 
/*     */ 
/*     */       
/*     */       private final TypeDescription forwardingType;
/*     */ 
/*     */ 
/*     */       
/*     */       private final MethodDescription sourceMethod;
/*     */ 
/*     */ 
/*     */       
/*     */       private final Assigner assigner;
/*     */ 
/*     */ 
/*     */       
/*     */       private final boolean serializableProxy;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected RedirectionProxy(TypeDescription param2TypeDescription, MethodDescription param2MethodDescription, Assigner param2Assigner, boolean param2Boolean) {
/* 250 */         this.forwardingType = param2TypeDescription;
/* 251 */         this.sourceMethod = param2MethodDescription;
/* 252 */         this.assigner = param2Assigner;
/* 253 */         this.serializableProxy = param2Boolean;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private static LinkedHashMap<String, TypeDescription> extractFields(MethodDescription param2MethodDescription) {
/* 264 */         TypeList typeList = param2MethodDescription.getParameters().asTypeList().asErasures();
/* 265 */         LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/* 266 */         byte b = 0;
/* 267 */         for (TypeDescription typeDescription : typeList) {
/* 268 */           linkedHashMap.put(fieldName(b++), typeDescription);
/*     */         }
/* 270 */         return (LinkedHashMap)linkedHashMap;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private static String fieldName(int param2Int) {
/* 280 */         return "argument" + param2Int;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public String getSuffix() {
/* 287 */         return RandomString.hashOf(this.forwardingType.hashCode()) + 
/* 288 */           RandomString.hashOf(this.sourceMethod.hashCode()) + (this.serializableProxy ? "S" : "0");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public DynamicType make(String param2String, ClassFileVersion param2ClassFileVersion, MethodAccessorFactory param2MethodAccessorFactory) {
/*     */         DynamicType.Builder.FieldDefinition.Optional.Valuable valuable;
/* 298 */         LinkedHashMap<String, TypeDescription> linkedHashMap = extractFields(this.sourceMethod);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 303 */         (new Class[1])[0] = Serializable.class;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 308 */         DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition receiverTypeDefinition = (new ByteBuddy(param2ClassFileVersion)).with(TypeValidation.DISABLED).subclass((TypeDefinition)this.forwardingType, (ConstructorStrategy)ConstructorStrategy.Default.NO_CONSTRUCTORS).name(param2String).modifiers(DEFAULT_TYPE_MODIFIER).implement(this.serializableProxy ? (Type[])new Class[1] : (Type[])new Class[0]).method((ElementMatcher)ElementMatchers.isAbstract().and((ElementMatcher)ElementMatchers.isDeclaredBy(this.forwardingType))).intercept(new MethodCall(this.sourceMethod, this.assigner, (byte)0)).defineConstructor(new ModifierContributor.ForMethod[0]).withParameters(linkedHashMap.values()).intercept(ConstructorCall.INSTANCE);
/* 309 */         for (Map.Entry<String, TypeDescription> entry : linkedHashMap.entrySet()) {
/* 310 */           valuable = receiverTypeDefinition.defineField((String)entry.getKey(), (TypeDefinition)entry.getValue(), new ModifierContributor.ForField[] { (ModifierContributor.ForField)Visibility.PRIVATE });
/*     */         } 
/* 312 */         return (DynamicType)valuable.make();
/*     */       }
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.serializableProxy != ((RedirectionProxy)param2Object).serializableProxy) ? false : (!this.forwardingType.equals(((RedirectionProxy)param2Object).forwardingType) ? false : (!this.sourceMethod.equals(((RedirectionProxy)param2Object).sourceMethod) ? false : (!!this.assigner.equals(((RedirectionProxy)param2Object).assigner)))))));
/*     */       }
/*     */       
/*     */       public StackManipulation.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context) {
/* 319 */         TypeDescription typeDescription = param2Context.register(this);
/* 320 */         return (new StackManipulation.Compound(new StackManipulation[] {
/* 321 */               TypeCreation.of(typeDescription), (StackManipulation)Duplication.SINGLE, 
/*     */               
/* 323 */               (StackManipulation)MethodVariableAccess.allArgumentsOf(this.sourceMethod), 
/* 324 */               (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)((MethodList)typeDescription.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor())).getOnly())
/* 325 */             })).apply(param2MethodVisitor, param2Context);
/*     */       }
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return (((getClass().hashCode() * 31 + this.forwardingType.hashCode()) * 31 + this.sourceMethod.hashCode()) * 31 + this.assigner.hashCode()) * 31 + this.serializableProxy;
/*     */       }
/*     */       
/*     */       protected enum ConstructorCall
/*     */         implements Implementation
/*     */       {
/* 336 */         INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private final transient MethodDescription.InDefinedShape objectTypeDefaultConstructor;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         ConstructorCall() {
/* 347 */           this.objectTypeDefaultConstructor = (MethodDescription.InDefinedShape)((MethodList)TypeDescription.ForLoadedType.of(Object.class).getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isConstructor())).getOnly();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public final InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/* 354 */           return param3InstrumentedType;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public final ByteCodeAppender appender(Implementation.Target param3Target) {
/* 361 */           return new Appender(param3Target.getInstrumentedType(), (byte)0);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         @Enhance
/*     */         private static class Appender
/*     */           implements ByteCodeAppender
/*     */         {
/*     */           private final TypeDescription instrumentedType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           private Appender(TypeDescription param4TypeDescription) {
/* 381 */             this.instrumentedType = param4TypeDescription;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public ByteCodeAppender.Size apply(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, MethodDescription param4MethodDescription) {
/*     */             FieldList fieldList;
/* 389 */             StackManipulation[] arrayOfStackManipulation = new StackManipulation[(fieldList = this.instrumentedType.getDeclaredFields()).size()];
/* 390 */             byte b = 0;
/* 391 */             for (FieldDescription fieldDescription : fieldList) {
/* 392 */               arrayOfStackManipulation[b] = (StackManipulation)new StackManipulation.Compound(new StackManipulation[] {
/* 393 */                     MethodVariableAccess.loadThis(), 
/* 394 */                     MethodVariableAccess.load((ParameterDescription)param4MethodDescription.getParameters().get(b)), 
/* 395 */                     FieldAccess.forField(fieldDescription).write()
/*     */                   });
/* 397 */               b++;
/*     */             } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 404 */             StackManipulation.Size size = (new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.loadThis(), (StackManipulation)MethodInvocation.invoke(Pipe.Binder.RedirectionProxy.ConstructorCall.a(Pipe.Binder.RedirectionProxy.ConstructorCall.INSTANCE)), (StackManipulation)new StackManipulation.Compound(arrayOfStackManipulation), (StackManipulation)MethodReturn.VOID })).apply(param4MethodVisitor, param4Context);
/* 405 */             return new ByteCodeAppender.Size(size.getMaximalSize(), param4MethodDescription.getStackSize());
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean equals(@MaybeNull Object param4Object) {
/*     */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.instrumentedType.equals(((Appender)param4Object).instrumentedType))));
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public int hashCode() {
/*     */             return getClass().hashCode() * 31 + this.instrumentedType.hashCode();
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/*     */       
/*     */       @Enhance
/*     */       protected static class MethodCall
/*     */         implements Implementation
/*     */       {
/*     */         private final MethodDescription redirectedMethod;
/*     */         
/*     */         private final Assigner assigner;
/*     */ 
/*     */         
/*     */         private MethodCall(MethodDescription param3MethodDescription, Assigner param3Assigner) {
/* 433 */           this.redirectedMethod = param3MethodDescription;
/* 434 */           this.assigner = param3Assigner;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public InstrumentedType prepare(InstrumentedType param3InstrumentedType) {
/* 441 */           return param3InstrumentedType;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public ByteCodeAppender appender(Implementation.Target param3Target) {
/* 448 */           if (!this.redirectedMethod.isAccessibleTo(param3Target.getInstrumentedType())) {
/* 449 */             throw new IllegalStateException("Cannot invoke " + this.redirectedMethod + " from outside of class via @Pipe proxy");
/*     */           }
/* 451 */           return new Appender(param3Target.getInstrumentedType(), (byte)0);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean equals(@MaybeNull Object param3Object) {
/*     */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.redirectedMethod.equals(((MethodCall)param3Object).redirectedMethod) ? false : (!!this.assigner.equals(((MethodCall)param3Object).assigner)))));
/*     */         }
/*     */ 
/*     */         
/*     */         public int hashCode() {
/*     */           return (getClass().hashCode() * 31 + this.redirectedMethod.hashCode()) * 31 + this.assigner.hashCode();
/*     */         }
/*     */         
/*     */         @Enhance(includeSyntheticFields = true)
/*     */         private class Appender
/*     */           implements ByteCodeAppender
/*     */         {
/*     */           private final TypeDescription instrumentedType;
/*     */           
/*     */           private Appender(Pipe.Binder.RedirectionProxy.MethodCall this$0, TypeDescription param4TypeDescription) {
/* 471 */             this.instrumentedType = param4TypeDescription;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public ByteCodeAppender.Size apply(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, MethodDescription param4MethodDescription) {
/*     */             FieldList fieldList;
/* 481 */             StackManipulation[] arrayOfStackManipulation = new StackManipulation[(fieldList = this.instrumentedType.getDeclaredFields()).size()];
/* 482 */             byte b = 0;
/* 483 */             for (FieldDescription fieldDescription : fieldList) {
/* 484 */               arrayOfStackManipulation[b++] = (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.loadThis(), FieldAccess.forField(fieldDescription).read() });
/*     */             } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 493 */             StackManipulation.Size size = (new StackManipulation.Compound(new StackManipulation[] { MethodVariableAccess.REFERENCE.loadFrom(1), Pipe.Binder.RedirectionProxy.MethodCall.b(this.a).assign(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), Pipe.Binder.RedirectionProxy.MethodCall.a(this.a).getDeclaringType().asGenericType(), Assigner.Typing.DYNAMIC), (StackManipulation)new StackManipulation.Compound(arrayOfStackManipulation), (StackManipulation)MethodInvocation.invoke(Pipe.Binder.RedirectionProxy.MethodCall.a(this.a)), Pipe.Binder.RedirectionProxy.MethodCall.b(this.a).assign(Pipe.Binder.RedirectionProxy.MethodCall.a(this.a).getReturnType(), param4MethodDescription.getReturnType(), Assigner.Typing.DYNAMIC), (StackManipulation)MethodReturn.REFERENCE })).apply(param4MethodVisitor, param4Context);
/* 494 */             return new ByteCodeAppender.Size(size.getMaximalSize(), param4MethodDescription.getStackSize());
/*     */           }
/*     */           
/*     */           public boolean equals(@MaybeNull Object param4Object) {
/*     */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.instrumentedType.equals(((Appender)param4Object).instrumentedType) ? false : (!!this.a.equals(((Appender)param4Object).a)))));
/*     */           }
/*     */           
/*     */           public int hashCode() {
/*     */             return (getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.a.hashCode();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\annotation\Pipe.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */