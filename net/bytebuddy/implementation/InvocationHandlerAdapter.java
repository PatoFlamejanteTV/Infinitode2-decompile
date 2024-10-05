/*     */ package net.bytebuddy.implementation;
/*     */ 
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.field.FieldList;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.description.type.TypeList;
/*     */ import net.bytebuddy.dynamic.scaffold.FieldLocator;
/*     */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*     */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*     */ import net.bytebuddy.implementation.bytecode.Removal;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*     */ import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
/*     */ import net.bytebuddy.implementation.bytecode.constant.MethodConstant;
/*     */ import net.bytebuddy.implementation.bytecode.constant.NullConstant;
/*     */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
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
/*     */ @Enhance
/*     */ public abstract class InvocationHandlerAdapter
/*     */   implements Implementation.Composable
/*     */ {
/*  56 */   private static final TypeDescription.Generic INVOCATION_HANDLER_TYPE = TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(InvocationHandler.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final boolean UNCACHED = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final boolean CACHED = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final boolean UNPRIVILEGED = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final boolean PRIVILEGED = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final boolean RETURNING = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final boolean DROPPING = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final String fieldName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean cached;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean privileged;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean returning;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final Assigner assigner;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected InvocationHandlerAdapter(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Assigner paramAssigner) {
/* 126 */     this.fieldName = paramString;
/* 127 */     this.cached = paramBoolean1;
/* 128 */     this.privileged = paramBoolean2;
/* 129 */     this.returning = paramBoolean3;
/* 130 */     this.assigner = paramAssigner;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static InvocationHandlerAdapter of(InvocationHandler paramInvocationHandler) {
/* 141 */     return of(paramInvocationHandler, "invocationHandler$" + RandomString.hashOf(paramInvocationHandler));
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
/*     */   public static InvocationHandlerAdapter of(InvocationHandler paramInvocationHandler, String paramString) {
/* 153 */     return new ForInstance(paramString, true, false, true, Assigner.DEFAULT, paramInvocationHandler);
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
/*     */   public static InvocationHandlerAdapter toField(String paramString) {
/* 166 */     return toField(paramString, (FieldLocator.Factory)FieldLocator.ForClassHierarchy.Factory.INSTANCE);
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
/*     */   public static InvocationHandlerAdapter toField(String paramString, FieldLocator.Factory paramFactory) {
/* 180 */     return new ForField(paramString, true, false, true, Assigner.DEFAULT, paramFactory);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<StackManipulation> argumentValuesOf(MethodDescription paramMethodDescription) {
/* 190 */     TypeList.Generic generic = paramMethodDescription.getParameters().asTypeList();
/* 191 */     ArrayList<StackManipulation.Compound> arrayList = new ArrayList(generic.size());
/* 192 */     int i = 1;
/* 193 */     for (TypeDescription.Generic generic1 : generic) {
/* 194 */       arrayList.add(new StackManipulation.Compound(new StackManipulation[] {
/* 195 */               MethodVariableAccess.of((TypeDefinition)generic1).loadFrom(i), this.assigner
/* 196 */               .assign(generic1, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), Assigner.Typing.STATIC) }));
/* 197 */       i += generic1.getStackSize().getSize();
/*     */     } 
/* 199 */     return (List)arrayList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ByteCodeAppender.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext, MethodDescription paramMethodDescription, StackManipulation paramStackManipulation, FieldDescription paramFieldDescription) {
/* 241 */     if (paramMethodDescription.isStatic() || paramMethodDescription.isConstructor()) {
/* 242 */       throw new IllegalStateException("It is not possible to apply an invocation handler onto the static method or constructor " + paramMethodDescription);
/*     */     }
/*     */ 
/*     */     
/* 246 */     MethodConstant.CanCache canCache = this.privileged ? MethodConstant.ofPrivileged((MethodDescription.InDefinedShape)paramMethodDescription.asDefined()) : MethodConstant.of((MethodDescription.InDefinedShape)paramMethodDescription.asDefined());
/* 247 */     (new StackManipulation[7])[0] = paramStackManipulation; (new StackManipulation[7])[1] = 
/*     */       
/* 249 */       FieldAccess.forField(paramFieldDescription).read(); (new StackManipulation[7])[2] = 
/* 250 */       MethodVariableAccess.loadThis(); (new StackManipulation[7])[3] = this.cached ? canCache
/* 251 */       .cached() : (StackManipulation)canCache; (new StackManipulation[7])[4] = 
/* 252 */       paramMethodDescription.getParameters().isEmpty() ? (StackManipulation)NullConstant.INSTANCE : 
/*     */       
/* 254 */       ArrayFactory.forType(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class)).withValues(argumentValuesOf(paramMethodDescription)); (new StackManipulation[7])[5] = 
/* 255 */       (StackManipulation)MethodInvocation.invoke((MethodDescription)((MethodList)INVOCATION_HANDLER_TYPE.getDeclaredMethods().filter((ElementMatcher)ElementMatchers.isAbstract())).getOnly()); if (this.returning) {
/*     */     
/*     */     } else {
/*     */     
/* 259 */     }  StackManipulation.Size size = (new StackManipulation.Compound(new StackManipulation[] { null, null, null, null, null, null, (StackManipulation)Removal.SINGLE })).apply(paramMethodVisitor, paramContext);
/* 260 */     return new ByteCodeAppender.Size(size.getMaximalSize(), paramMethodDescription.getStackSize());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract WithoutPrivilegeConfiguration withoutMethodCache();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract Implementation withAssigner(Assigner paramAssigner);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract AssignerConfigurable withPrivilegedLookup();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : ((this.cached != ((InvocationHandlerAdapter)paramObject).cached) ? false : ((this.privileged != ((InvocationHandlerAdapter)paramObject).privileged) ? false : ((this.returning != ((InvocationHandlerAdapter)paramObject).returning) ? false : (!this.fieldName.equals(((InvocationHandlerAdapter)paramObject).fieldName) ? false : (!!this.assigner.equals(((InvocationHandlerAdapter)paramObject).assigner))))))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     return ((((getClass().hashCode() * 31 + this.fieldName.hashCode()) * 31 + this.cached) * 31 + this.privileged) * 31 + this.returning) * 31 + this.assigner.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface AssignerConfigurable
/*     */     extends Implementation.Composable
/*     */   {
/*     */     Implementation.Composable withAssigner(Assigner param1Assigner);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface WithoutPrivilegeConfiguration
/*     */     extends AssignerConfigurable
/*     */   {
/*     */     InvocationHandlerAdapter.AssignerConfigurable withPrivilegedLookup();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   protected static class ForInstance
/*     */     extends InvocationHandlerAdapter
/*     */     implements WithoutPrivilegeConfiguration
/*     */   {
/*     */     private static final String PREFIX = "invocationHandler";
/*     */ 
/*     */     
/*     */     protected final InvocationHandler invocationHandler;
/*     */ 
/*     */ 
/*     */     
/*     */     protected ForInstance(String param1String, boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3, Assigner param1Assigner, InvocationHandler param1InvocationHandler) {
/* 324 */       super(param1String, param1Boolean1, param1Boolean2, param1Boolean3, param1Assigner);
/* 325 */       this.invocationHandler = param1InvocationHandler;
/*     */     }
/*     */ 
/*     */     
/*     */     public InvocationHandlerAdapter.WithoutPrivilegeConfiguration withoutMethodCache() {
/* 330 */       return new ForInstance(this.fieldName, false, this.privileged, this.returning, this.assigner, this.invocationHandler);
/*     */     }
/*     */ 
/*     */     
/*     */     public Implementation.Composable withAssigner(Assigner param1Assigner) {
/* 335 */       return new ForInstance(this.fieldName, this.cached, this.privileged, this.returning, param1Assigner, this.invocationHandler);
/*     */     }
/*     */ 
/*     */     
/*     */     public InvocationHandlerAdapter.AssignerConfigurable withPrivilegedLookup() {
/* 340 */       return new ForInstance(this.fieldName, this.cached, true, this.returning, this.assigner, this.invocationHandler);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Implementation andThen(Implementation param1Implementation) {
/* 347 */       return new Implementation.Compound(new Implementation[] { new ForInstance(this.fieldName, this.cached, this.privileged, false, this.assigner, this.invocationHandler), param1Implementation });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Implementation.Composable andThen(Implementation.Composable param1Composable) {
/* 354 */       return new Implementation.Compound.Composable(new ForInstance(this.fieldName, this.cached, this.privileged, false, this.assigner, this.invocationHandler), param1Composable);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 361 */       if (!((FieldList)param1InstrumentedType.getDeclaredFields().filter((ElementMatcher)ElementMatchers.named(this.fieldName).and((ElementMatcher)ElementMatchers.fieldType(InvocationHandlerAdapter.a().asErasure())))).isEmpty()) {
/* 362 */         throw new IllegalStateException("Field with name " + this.fieldName + " and type " + 
/* 363 */             InvocationHandlerAdapter.a().asErasure() + " already declared by " + param1InstrumentedType);
/*     */       }
/*     */       
/* 366 */       return param1InstrumentedType
/* 367 */         .withField(new FieldDescription.Token(this.fieldName, 4169, 
/*     */             
/* 369 */             InvocationHandlerAdapter.a()))
/* 370 */         .withInitializer(new LoadedTypeInitializer.ForStaticField(this.fieldName, this.invocationHandler));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeAppender appender(Implementation.Target param1Target) {
/* 377 */       return new Appender(this, param1Target.getInstrumentedType());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return !super.equals(param1Object) ? false : ((this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.invocationHandler.equals(((ForInstance)param1Object).invocationHandler)))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return super.hashCode() * 31 + this.invocationHandler.hashCode();
/*     */     }
/*     */     
/*     */     @Enhance(includeSyntheticFields = true)
/*     */     protected class Appender
/*     */       implements ByteCodeAppender
/*     */     {
/*     */       private final TypeDescription instrumentedType;
/*     */       
/*     */       protected Appender(InvocationHandlerAdapter.ForInstance this$0, TypeDescription param2TypeDescription) {
/* 397 */         this.instrumentedType = param2TypeDescription;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ByteCodeAppender.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context, MethodDescription param2MethodDescription) {
/* 404 */         return this.a.apply(param2MethodVisitor, param2Context, param2MethodDescription, (StackManipulation)StackManipulation.Trivial.INSTANCE, (FieldDescription)((FieldList)this.instrumentedType
/*     */ 
/*     */ 
/*     */             
/* 408 */             .getDeclaredFields().filter((ElementMatcher)ElementMatchers.named(this.a.fieldName).and((ElementMatcher)ElementMatchers.genericFieldType(InvocationHandlerAdapter.a())))).getOnly());
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.instrumentedType.equals(((Appender)param2Object).instrumentedType) ? false : (!!this.a.equals(((Appender)param2Object).a)))));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return (getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.a.hashCode();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   protected static class ForField
/*     */     extends InvocationHandlerAdapter
/*     */     implements WithoutPrivilegeConfiguration
/*     */   {
/*     */     private final FieldLocator.Factory fieldLocatorFactory;
/*     */ 
/*     */ 
/*     */     
/*     */     protected ForField(String param1String, boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3, Assigner param1Assigner, FieldLocator.Factory param1Factory) {
/* 438 */       super(param1String, param1Boolean1, param1Boolean2, param1Boolean3, param1Assigner);
/* 439 */       this.fieldLocatorFactory = param1Factory;
/*     */     }
/*     */ 
/*     */     
/*     */     public InvocationHandlerAdapter.WithoutPrivilegeConfiguration withoutMethodCache() {
/* 444 */       return new ForField(this.fieldName, false, this.privileged, this.returning, this.assigner, this.fieldLocatorFactory);
/*     */     }
/*     */ 
/*     */     
/*     */     public Implementation.Composable withAssigner(Assigner param1Assigner) {
/* 449 */       return new ForField(this.fieldName, this.cached, this.privileged, this.returning, param1Assigner, this.fieldLocatorFactory);
/*     */     }
/*     */ 
/*     */     
/*     */     public InvocationHandlerAdapter.AssignerConfigurable withPrivilegedLookup() {
/* 454 */       return new ForField(this.fieldName, this.cached, true, this.returning, this.assigner, this.fieldLocatorFactory);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Implementation andThen(Implementation param1Implementation) {
/* 461 */       return new Implementation.Compound(new Implementation[] { new ForField(this.fieldName, this.cached, this.privileged, false, this.assigner, this.fieldLocatorFactory), param1Implementation });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Implementation.Composable andThen(Implementation.Composable param1Composable) {
/* 468 */       return new Implementation.Compound.Composable(new ForField(this.fieldName, this.cached, this.privileged, false, this.assigner, this.fieldLocatorFactory), param1Composable);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/* 475 */       return param1InstrumentedType;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeAppender appender(Implementation.Target param1Target) {
/*     */       FieldLocator.Resolution resolution;
/* 483 */       if (!(resolution = this.fieldLocatorFactory.make(param1Target.getInstrumentedType()).locate(this.fieldName)).isResolved())
/* 484 */         throw new IllegalStateException("Could not find a field named '" + this.fieldName + "' for " + param1Target.getInstrumentedType()); 
/* 485 */       if (!resolution.getField().getType().asErasure().isAssignableTo(InvocationHandler.class)) {
/* 486 */         throw new IllegalStateException("Field " + resolution.getField() + " does not declare a type that is assignable to invocation handler");
/*     */       }
/* 488 */       return new Appender(this, resolution.getField());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return !super.equals(param1Object) ? false : ((this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.fieldLocatorFactory.equals(((ForField)param1Object).fieldLocatorFactory)))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return super.hashCode() * 31 + this.fieldLocatorFactory.hashCode();
/*     */     }
/*     */     
/*     */     @Enhance(includeSyntheticFields = true)
/*     */     protected class Appender
/*     */       implements ByteCodeAppender
/*     */     {
/*     */       private final FieldDescription fieldDescription;
/*     */       
/*     */       protected Appender(InvocationHandlerAdapter.ForField this$0, FieldDescription param2FieldDescription) {
/* 508 */         this.fieldDescription = param2FieldDescription;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ByteCodeAppender.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context, MethodDescription param2MethodDescription) {
/* 515 */         return this.a.apply(param2MethodVisitor, param2Context, param2MethodDescription, 
/*     */ 
/*     */             
/* 518 */             this.fieldDescription.isStatic() ? (StackManipulation)StackManipulation.Trivial.INSTANCE : 
/*     */             
/* 520 */             MethodVariableAccess.loadThis(), this.fieldDescription);
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.fieldDescription.equals(((Appender)param2Object).fieldDescription) ? false : (!!this.a.equals(((Appender)param2Object).a)))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return (getClass().hashCode() * 31 + this.fieldDescription.hashCode()) * 31 + this.a.hashCode();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\InvocationHandlerAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */