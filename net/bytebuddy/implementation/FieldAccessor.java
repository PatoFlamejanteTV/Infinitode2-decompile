/*      */ package net.bytebuddy.implementation;
/*      */ 
/*      */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.Type;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*      */ import net.bytebuddy.description.field.FieldDescription;
/*      */ import net.bytebuddy.description.field.FieldList;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.method.ParameterDescription;
/*      */ import net.bytebuddy.description.type.TypeDefinition;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.dynamic.scaffold.FieldLocator;
/*      */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*      */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*      */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*      */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*      */ import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
/*      */ import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
/*      */ import net.bytebuddy.implementation.bytecode.constant.DoubleConstant;
/*      */ import net.bytebuddy.implementation.bytecode.constant.FloatConstant;
/*      */ import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
/*      */ import net.bytebuddy.implementation.bytecode.constant.JavaConstantValue;
/*      */ import net.bytebuddy.implementation.bytecode.constant.LongConstant;
/*      */ import net.bytebuddy.implementation.bytecode.constant.TextConstant;
/*      */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodReturn;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
/*      */ import net.bytebuddy.jar.asm.MethodVisitor;
/*      */ import net.bytebuddy.matcher.ElementMatcher;
/*      */ import net.bytebuddy.matcher.ElementMatchers;
/*      */ import net.bytebuddy.utility.JavaConstant;
/*      */ import net.bytebuddy.utility.JavaType;
/*      */ import net.bytebuddy.utility.RandomString;
/*      */ import net.bytebuddy.utility.nullability.AlwaysNull;
/*      */ import net.bytebuddy.utility.nullability.MaybeNull;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @Enhance
/*      */ public abstract class FieldAccessor
/*      */   implements Implementation
/*      */ {
/*      */   protected final FieldLocation fieldLocation;
/*      */   protected final Assigner assigner;
/*      */   protected final Assigner.Typing typing;
/*      */   
/*      */   protected FieldAccessor(FieldLocation paramFieldLocation, Assigner paramAssigner, Assigner.Typing paramTyping) {
/*   89 */     this.fieldLocation = paramFieldLocation;
/*   90 */     this.assigner = paramAssigner;
/*   91 */     this.typing = paramTyping;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static OwnerTypeLocatable ofField(String paramString) {
/*  101 */     return of(new FieldNameExtractor.ForFixedValue(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static OwnerTypeLocatable ofBeanProperty() {
/*  112 */     return of(FieldNameExtractor.ForBeanProperty.INSTANCE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static OwnerTypeLocatable of(FieldNameExtractor paramFieldNameExtractor) {
/*  122 */     return new ForImplicitProperty(new FieldLocation.Relative(paramFieldNameExtractor));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static AssignerConfigurable of(Field paramField) {
/*  132 */     return of((FieldDescription)new FieldDescription.ForLoadedField(paramField));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static AssignerConfigurable of(FieldDescription paramFieldDescription) {
/*  142 */     return new ForImplicitProperty(new FieldLocation.Absolute(paramFieldDescription));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(@MaybeNull Object paramObject) {
/*      */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!this.typing.equals(((FieldAccessor)paramObject).typing) ? false : (!this.fieldLocation.equals(((FieldAccessor)paramObject).fieldLocation) ? false : (!!this.assigner.equals(((FieldAccessor)paramObject).assigner))))));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/*      */     return ((getClass().hashCode() * 31 + this.fieldLocation.hashCode()) * 31 + this.assigner.hashCode()) * 31 + this.typing.hashCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class Absolute
/*      */     implements FieldLocation, FieldLocation.Prepared
/*      */   {
/*      */     private final FieldDescription fieldDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Absolute(FieldDescription param1FieldDescription) {
/*  197 */       this.fieldDescription = param1FieldDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public FieldAccessor.FieldLocation with(FieldLocator.Factory param1Factory) {
/*  204 */       throw new IllegalStateException("Cannot specify a field locator factory for an absolute field location");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming declaring type for type member.")
/*      */     public FieldAccessor.FieldLocation.Prepared prepare(TypeDescription param1TypeDescription) {
/*  212 */       if (!this.fieldDescription.isStatic() && !param1TypeDescription.isAssignableTo(this.fieldDescription.getDeclaringType().asErasure()))
/*  213 */         throw new IllegalStateException(this.fieldDescription + " is not declared by " + param1TypeDescription); 
/*  214 */       if (!this.fieldDescription.isAccessibleTo(param1TypeDescription)) {
/*  215 */         throw new IllegalStateException("Cannot access " + this.fieldDescription + " from " + param1TypeDescription);
/*      */       }
/*  217 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public FieldDescription resolve(MethodDescription param1MethodDescription)
/*      */     {
/*  224 */       return this.fieldDescription; } public boolean equals(@MaybeNull Object param1Object) { return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.fieldDescription.equals(((Absolute)param1Object).fieldDescription)))); } public int hashCode() { return getClass().hashCode() * 31 + this.fieldDescription.hashCode(); } } protected static interface FieldLocation { FieldLocation with(FieldLocator.Factory param1Factory); Prepared prepare(TypeDescription param1TypeDescription); public static interface Prepared { FieldDescription resolve(MethodDescription param2MethodDescription); } @Enhance public static class Absolute implements FieldLocation, Prepared { private final FieldDescription fieldDescription; protected Absolute(FieldDescription param2FieldDescription) { this.fieldDescription = param2FieldDescription; } public FieldAccessor.FieldLocation with(FieldLocator.Factory param2Factory) { throw new IllegalStateException("Cannot specify a field locator factory for an absolute field location"); } @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming declaring type for type member.") public FieldAccessor.FieldLocation.Prepared prepare(TypeDescription param2TypeDescription) { if (!this.fieldDescription.isStatic() && !param2TypeDescription.isAssignableTo(this.fieldDescription.getDeclaringType().asErasure())) throw new IllegalStateException(this.fieldDescription + " is not declared by " + param2TypeDescription);  if (!this.fieldDescription.isAccessibleTo(param2TypeDescription)) throw new IllegalStateException("Cannot access " + this.fieldDescription + " from " + param2TypeDescription);  return this; } public FieldDescription resolve(MethodDescription param2MethodDescription) { return this.fieldDescription; }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.fieldDescription.equals(((Absolute)param2Object).fieldDescription))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.fieldDescription.hashCode();
/*      */       } }
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class Relative
/*      */       implements FieldLocation
/*      */     {
/*      */       private final FieldAccessor.FieldNameExtractor fieldNameExtractor;
/*      */       
/*      */       private final FieldLocator.Factory fieldLocatorFactory;
/*      */ 
/*      */       
/*      */       protected Relative(FieldAccessor.FieldNameExtractor param2FieldNameExtractor) {
/*  250 */         this(param2FieldNameExtractor, (FieldLocator.Factory)FieldLocator.ForClassHierarchy.Factory.INSTANCE);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Relative(FieldAccessor.FieldNameExtractor param2FieldNameExtractor, FieldLocator.Factory param2Factory) {
/*  260 */         this.fieldNameExtractor = param2FieldNameExtractor;
/*  261 */         this.fieldLocatorFactory = param2Factory;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public FieldAccessor.FieldLocation with(FieldLocator.Factory param2Factory) {
/*  268 */         return new Relative(this.fieldNameExtractor, param2Factory);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public FieldAccessor.FieldLocation.Prepared prepare(TypeDescription param2TypeDescription) {
/*  275 */         return new Prepared(this.fieldNameExtractor, this.fieldLocatorFactory.make(param2TypeDescription));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.fieldNameExtractor.equals(((Relative)param2Object).fieldNameExtractor) ? false : (!!this.fieldLocatorFactory.equals(((Relative)param2Object).fieldLocatorFactory)))));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (getClass().hashCode() * 31 + this.fieldNameExtractor.hashCode()) * 31 + this.fieldLocatorFactory.hashCode();
/*      */       }
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static class Prepared
/*      */         implements FieldAccessor.FieldLocation.Prepared
/*      */       {
/*      */         private final FieldAccessor.FieldNameExtractor fieldNameExtractor;
/*      */         
/*      */         private final FieldLocator fieldLocator;
/*      */ 
/*      */         
/*      */         protected Prepared(FieldAccessor.FieldNameExtractor param3FieldNameExtractor, FieldLocator param3FieldLocator) {
/*  301 */           this.fieldNameExtractor = param3FieldNameExtractor;
/*  302 */           this.fieldLocator = param3FieldLocator;
/*      */         }
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.fieldNameExtractor.equals(((Prepared)param3Object).fieldNameExtractor) ? false : (!!this.fieldLocator.equals(((Prepared)param3Object).fieldLocator)))));
/*      */         } public int hashCode() {
/*      */           return (getClass().hashCode() * 31 + this.fieldNameExtractor.hashCode()) * 31 + this.fieldLocator.hashCode();
/*      */         }
/*      */         public FieldDescription resolve(MethodDescription param3MethodDescription) { FieldLocator.Resolution resolution;
/*  310 */           if (!(resolution = this.fieldLocator.locate(this.fieldNameExtractor.resolve(param3MethodDescription))).isResolved()) {
/*  311 */             throw new IllegalStateException("Cannot resolve field for " + param3MethodDescription + " using " + this.fieldLocator);
/*      */           }
/*  313 */           return resolution.getField(); } } } } @Enhance public static class Relative implements FieldLocation { private final FieldAccessor.FieldNameExtractor fieldNameExtractor; private final FieldLocator.Factory fieldLocatorFactory; protected Relative(FieldAccessor.FieldNameExtractor param1FieldNameExtractor) { this(param1FieldNameExtractor, (FieldLocator.Factory)FieldLocator.ForClassHierarchy.Factory.INSTANCE); } private Relative(FieldAccessor.FieldNameExtractor param1FieldNameExtractor, FieldLocator.Factory param1Factory) { this.fieldNameExtractor = param1FieldNameExtractor; this.fieldLocatorFactory = param1Factory; } public FieldAccessor.FieldLocation with(FieldLocator.Factory param1Factory) { return new Relative(this.fieldNameExtractor, param1Factory); } public FieldAccessor.FieldLocation.Prepared prepare(TypeDescription param1TypeDescription) { return new Prepared(this.fieldNameExtractor, this.fieldLocatorFactory.make(param1TypeDescription)); } public boolean equals(@MaybeNull Object param1Object) { return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.fieldNameExtractor.equals(((Relative)param1Object).fieldNameExtractor) ? false : (!!this.fieldLocatorFactory.equals(((Relative)param1Object).fieldLocatorFactory))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.fieldNameExtractor.hashCode()) * 31 + this.fieldLocatorFactory.hashCode(); } @Enhance protected static class Prepared implements FieldAccessor.FieldLocation.Prepared { public FieldDescription resolve(MethodDescription param3MethodDescription) { FieldLocator.Resolution resolution; if (!(resolution = this.fieldLocator.locate(this.fieldNameExtractor.resolve(param3MethodDescription))).isResolved()) throw new IllegalStateException("Cannot resolve field for " + param3MethodDescription + " using " + this.fieldLocator);  return resolution.getField(); }
/*      */ 
/*      */ 
/*      */       
/*      */       private final FieldAccessor.FieldNameExtractor fieldNameExtractor;
/*      */       
/*      */       private final FieldLocator fieldLocator;
/*      */ 
/*      */       
/*      */       protected Prepared(FieldAccessor.FieldNameExtractor param3FieldNameExtractor, FieldLocator param3FieldLocator) {
/*      */         this.fieldNameExtractor = param3FieldNameExtractor;
/*      */         this.fieldLocator = param3FieldLocator;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param3Object) {
/*      */         return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.fieldNameExtractor.equals(((Prepared)param3Object).fieldNameExtractor) ? false : (!!this.fieldLocator.equals(((Prepared)param3Object).fieldLocator)))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (getClass().hashCode() * 31 + this.fieldNameExtractor.hashCode()) * 31 + this.fieldLocator.hashCode();
/*      */       } }
/*      */      }
/*      */ 
/*      */   
/*      */   public enum ForBeanProperty
/*      */     implements FieldNameExtractor
/*      */   {
/*  342 */     INSTANCE;
/*      */ 
/*      */ 
/*      */     
/*      */     public final String resolve(MethodDescription param1MethodDescription)
/*      */     {
/*      */       byte b;
/*      */       String str;
/*  350 */       if ((str = param1MethodDescription.getInternalName()).startsWith("get") || str.startsWith("set")) {
/*  351 */         b = 3;
/*  352 */       } else if (str.startsWith("is")) {
/*  353 */         b = 2;
/*      */       } else {
/*  355 */         throw new IllegalArgumentException(param1MethodDescription + " does not follow Java bean naming conventions");
/*      */       } 
/*      */       
/*  358 */       if ((str = str.substring(b)).length() == 0) {
/*  359 */         throw new IllegalArgumentException(param1MethodDescription + " does not specify a bean name");
/*      */       }
/*  361 */       return Character.toLowerCase(str.charAt(0)) + str.substring(1); } } public static interface FieldNameExtractor { String resolve(MethodDescription param1MethodDescription); public enum ForBeanProperty implements FieldNameExtractor { INSTANCE; public final String resolve(MethodDescription param2MethodDescription) { byte b; String str; if ((str = param2MethodDescription.getInternalName()).startsWith("get") || str.startsWith("set")) { b = 3; } else if (str.startsWith("is")) { b = 2; } else { throw new IllegalArgumentException(param2MethodDescription + " does not follow Java bean naming conventions"); }  if ((str = str.substring(b)).length() == 0) throw new IllegalArgumentException(param2MethodDescription + " does not specify a bean name");  return Character.toLowerCase(str.charAt(0)) + str.substring(1); }
/*      */        }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForFixedValue
/*      */       implements FieldNameExtractor
/*      */     {
/*      */       private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected ForFixedValue(String param2String) {
/*  382 */         this.name = param2String;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public String resolve(MethodDescription param2MethodDescription)
/*      */       {
/*  389 */         return this.name; } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.name.equals(((ForFixedValue)param2Object).name)))); } public int hashCode() { return getClass().hashCode() * 31 + this.name.hashCode(); } } } @Enhance public static class ForFixedValue implements FieldNameExtractor { private final String name; protected ForFixedValue(String param1String) { this.name = param1String; } public String resolve(MethodDescription param1MethodDescription) { return this.name; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.name.equals(((ForFixedValue)param1Object).name))));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.name.hashCode();
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static class ForImplicitProperty
/*      */     extends FieldAccessor
/*      */     implements OwnerTypeLocatable
/*      */   {
/*      */     protected ForImplicitProperty(FieldAccessor.FieldLocation param1FieldLocation) {
/*  635 */       this(param1FieldLocation, Assigner.DEFAULT, Assigner.Typing.STATIC);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private ForImplicitProperty(FieldAccessor.FieldLocation param1FieldLocation, Assigner param1Assigner, Assigner.Typing param1Typing) {
/*  646 */       super(param1FieldLocation, param1Assigner, param1Typing);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType prepare(InstrumentedType param1InstrumentedType) {
/*  653 */       return param1InstrumentedType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeAppender appender(Implementation.Target param1Target) {
/*  660 */       return new Appender(this, this.fieldLocation.prepare(param1Target.getInstrumentedType()));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Implementation.Composable setsArgumentAt(int param1Int) {
/*  667 */       if (param1Int < 0) {
/*  668 */         throw new IllegalArgumentException("A parameter index cannot be negative: " + param1Int);
/*      */       }
/*  670 */       return new FieldAccessor.ForSetter.OfParameterValue(this.fieldLocation, this.assigner, this.typing, FieldAccessor.ForSetter.TerminationHandler.RETURNING, param1Int);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Implementation.Composable setsDefaultValue() {
/*  681 */       return new FieldAccessor.ForSetter.OfDefaultValue(this.fieldLocation, this.assigner, this.typing, FieldAccessor.ForSetter.TerminationHandler.RETURNING);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Implementation.Composable setsValue(@MaybeNull Object param1Object) {
/*  688 */       if (param1Object == null) {
/*  689 */         return setsDefaultValue();
/*      */       }
/*      */       Class<?> clazz;
/*  692 */       if ((clazz = param1Object.getClass()) == String.class)
/*  693 */         return setsValue((StackManipulation)new TextConstant((String)param1Object), String.class); 
/*  694 */       if (clazz == Class.class)
/*  695 */         return setsValue(ClassConstant.of(TypeDescription.ForLoadedType.of((Class)param1Object)), Class.class); 
/*  696 */       if (clazz == Boolean.class)
/*  697 */         return setsValue(IntegerConstant.forValue(((Boolean)param1Object).booleanValue()), boolean.class); 
/*  698 */       if (clazz == Byte.class)
/*  699 */         return setsValue(IntegerConstant.forValue(((Byte)param1Object).byteValue()), byte.class); 
/*  700 */       if (clazz == Short.class)
/*  701 */         return setsValue(IntegerConstant.forValue(((Short)param1Object).shortValue()), short.class); 
/*  702 */       if (clazz == Character.class)
/*  703 */         return setsValue(IntegerConstant.forValue(((Character)param1Object).charValue()), char.class); 
/*  704 */       if (clazz == Integer.class)
/*  705 */         return setsValue(IntegerConstant.forValue(((Integer)param1Object).intValue()), int.class); 
/*  706 */       if (clazz == Long.class)
/*  707 */         return setsValue(LongConstant.forValue(((Long)param1Object).longValue()), long.class); 
/*  708 */       if (clazz == Float.class)
/*  709 */         return setsValue(FloatConstant.forValue(((Float)param1Object).floatValue()), float.class); 
/*  710 */       if (clazz == Double.class)
/*  711 */         return setsValue(DoubleConstant.forValue(((Double)param1Object).doubleValue()), double.class); 
/*  712 */       if (JavaType.METHOD_HANDLE.getTypeStub().isAssignableFrom(clazz))
/*  713 */         return setsValue((StackManipulation)new JavaConstantValue((JavaConstant)JavaConstant.MethodHandle.ofLoaded(param1Object)), clazz); 
/*  714 */       if (JavaType.METHOD_TYPE.getTypeStub().represents(clazz)) {
/*  715 */         return setsValue((StackManipulation)new JavaConstantValue((JavaConstant)JavaConstant.MethodType.ofLoaded(param1Object)), clazz);
/*      */       }
/*  717 */       return setsReference(param1Object);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Implementation.Composable setsValue(TypeDescription param1TypeDescription) {
/*  725 */       return setsValue(ClassConstant.of(param1TypeDescription), Class.class);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Implementation.Composable setsValue(JavaConstant param1JavaConstant) {
/*  732 */       return setsValue((StackManipulation)new JavaConstantValue(param1JavaConstant), param1JavaConstant.getTypeDescription().asGenericType());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Implementation.Composable setsValue(StackManipulation param1StackManipulation, Type param1Type) {
/*  739 */       return setsValue(param1StackManipulation, TypeDefinition.Sort.describe(param1Type));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Implementation.Composable setsValue(StackManipulation param1StackManipulation, TypeDescription.Generic param1Generic) {
/*  746 */       return new FieldAccessor.ForSetter.OfConstantValue(this.fieldLocation, this.assigner, this.typing, FieldAccessor.ForSetter.TerminationHandler.RETURNING, param1Generic, param1StackManipulation);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Implementation.Composable setsReference(Object param1Object) {
/*  758 */       return setsReference(param1Object, "fixedFieldValue$" + RandomString.hashOf(param1Object));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Implementation.Composable setsReference(Object param1Object, String param1String) {
/*  765 */       return new FieldAccessor.ForSetter.OfReferenceValue(this.fieldLocation, this.assigner, this.typing, FieldAccessor.ForSetter.TerminationHandler.RETURNING, param1Object, param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Implementation.Composable setsFieldValueOf(Field param1Field) {
/*  777 */       return setsFieldValueOf((FieldDescription)new FieldDescription.ForLoadedField(param1Field));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Implementation.Composable setsFieldValueOf(FieldDescription param1FieldDescription) {
/*  784 */       return new FieldAccessor.ForSetter.OfFieldValue(this.fieldLocation, this.assigner, this.typing, FieldAccessor.ForSetter.TerminationHandler.RETURNING, new FieldAccessor.FieldLocation.Absolute(param1FieldDescription));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Implementation.Composable setsFieldValueOf(String param1String) {
/*  795 */       return setsFieldValueOf(new FieldAccessor.FieldNameExtractor.ForFixedValue(param1String));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Implementation.Composable setsFieldValueOf(FieldAccessor.FieldNameExtractor param1FieldNameExtractor) {
/*  802 */       return new FieldAccessor.ForSetter.OfFieldValue(this.fieldLocation, this.assigner, this.typing, FieldAccessor.ForSetter.TerminationHandler.RETURNING, new FieldAccessor.FieldLocation.Relative(param1FieldNameExtractor));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public FieldAccessor.PropertyConfigurable withAssigner(Assigner param1Assigner, Assigner.Typing param1Typing) {
/*  813 */       return new ForImplicitProperty(this.fieldLocation, param1Assigner, param1Typing);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public FieldAccessor.AssignerConfigurable in(Class<?> param1Class) {
/*  820 */       return in(TypeDescription.ForLoadedType.of(param1Class));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public FieldAccessor.AssignerConfigurable in(TypeDescription param1TypeDescription) {
/*  827 */       return in((FieldLocator.Factory)new FieldLocator.ForExactType.Factory(param1TypeDescription));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public FieldAccessor.AssignerConfigurable in(FieldLocator.Factory param1Factory) {
/*  834 */       return new ForImplicitProperty(this.fieldLocation.with(param1Factory), this.assigner, this.typing);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance(includeSyntheticFields = true)
/*      */     protected class Appender
/*      */       implements ByteCodeAppender
/*      */     {
/*      */       private final FieldAccessor.FieldLocation.Prepared fieldLocation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected Appender(FieldAccessor.ForImplicitProperty this$0, FieldAccessor.FieldLocation.Prepared param2Prepared) {
/*  854 */         this.fieldLocation = param2Prepared;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public ByteCodeAppender.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context, MethodDescription param2MethodDescription) {
/*      */         StackManipulation.Compound compound;
/*  861 */         if (!param2MethodDescription.isMethod()) {
/*  862 */           throw new IllegalArgumentException(param2MethodDescription + " does not describe a field getter or setter");
/*      */         }
/*      */         FieldDescription fieldDescription;
/*  865 */         if (!(fieldDescription = this.fieldLocation.resolve(param2MethodDescription)).isStatic() && param2MethodDescription.isStatic()) {
/*  866 */           throw new IllegalStateException("Cannot set instance field " + fieldDescription + " from " + param2MethodDescription);
/*      */         }
/*      */ 
/*      */         
/*  870 */         StackManipulation stackManipulation = (StackManipulation)(fieldDescription.isStatic() ? StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis());
/*  871 */         if (!param2MethodDescription.getReturnType().represents(void.class)) {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  876 */           compound = new StackManipulation.Compound(new StackManipulation[] { stackManipulation, FieldAccess.forField(fieldDescription).read(), this.a.assigner.assign(fieldDescription.getType(), param2MethodDescription.getReturnType(), this.a.typing), MethodReturn.of((TypeDefinition)param2MethodDescription.getReturnType()) });
/*      */         }
/*  878 */         else if (param2MethodDescription.getReturnType().represents(void.class) && param2MethodDescription.getParameters().size() == 1) {
/*  879 */           if (fieldDescription.isFinal() && param2MethodDescription.isMethod()) {
/*  880 */             throw new IllegalStateException("Cannot set final field " + fieldDescription + " from " + param2MethodDescription);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  886 */           compound = new StackManipulation.Compound(new StackManipulation[] { (StackManipulation)compound, MethodVariableAccess.load((ParameterDescription)param2MethodDescription.getParameters().get(0)), this.a.assigner.assign(((ParameterDescription)param2MethodDescription.getParameters().get(0)).getType(), fieldDescription.getType(), this.a.typing), FieldAccess.forField(fieldDescription).write(), (StackManipulation)MethodReturn.VOID });
/*      */         }
/*      */         else {
/*      */           
/*  890 */           throw new IllegalArgumentException("Method " + param2MethodDescription + " is no bean accessor");
/*      */         } 
/*  892 */         if (!compound.isValid()) {
/*  893 */           throw new IllegalStateException("Cannot set or get value of " + param2MethodDescription + " using " + fieldDescription);
/*      */         }
/*  895 */         return new ByteCodeAppender.Size(compound.apply(param2MethodVisitor, param2Context).getMaximalSize(), param2MethodDescription.getStackSize());
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.fieldLocation.equals(((Appender)param2Object).fieldLocation) ? false : (!!this.a.equals(((Appender)param2Object).a)))));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (getClass().hashCode() * 31 + this.fieldLocation.hashCode()) * 31 + this.a.hashCode();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   protected static abstract class ForSetter<T>
/*      */     extends FieldAccessor
/*      */     implements Implementation.Composable
/*      */   {
/*      */     private final TerminationHandler terminationHandler;
/*      */ 
/*      */     
/*      */     protected ForSetter(FieldAccessor.FieldLocation param1FieldLocation, Assigner param1Assigner, Assigner.Typing param1Typing, TerminationHandler param1TerminationHandler) {
/*  922 */       super(param1FieldLocation, param1Assigner, param1Typing);
/*  923 */       this.terminationHandler = param1TerminationHandler;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteCodeAppender appender(Implementation.Target param1Target) {
/*  930 */       return new Appender(this, param1Target.getInstrumentedType(), 
/*  931 */           initialize(param1Target.getInstrumentedType()), this.fieldLocation
/*  932 */           .prepare(param1Target.getInstrumentedType()));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     protected abstract T initialize(TypeDescription param1TypeDescription);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected abstract StackManipulation resolve(@MaybeNull T param1T, FieldDescription param1FieldDescription, TypeDescription param1TypeDescription, MethodDescription param1MethodDescription);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return !super.equals(param1Object) ? false : ((this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.terminationHandler.equals(((ForSetter)param1Object).terminationHandler)))));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return super.hashCode() * 31 + this.terminationHandler.hashCode();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected enum TerminationHandler
/*      */     {
/*  966 */       RETURNING
/*      */       {
/*      */         protected final StackManipulation resolve(MethodDescription param3MethodDescription) {
/*  969 */           if (!param3MethodDescription.getReturnType().represents(void.class)) {
/*  970 */             throw new IllegalStateException("Cannot implement setter with return value for " + param3MethodDescription);
/*      */           }
/*  972 */           return (StackManipulation)MethodReturn.VOID;
/*      */         }
/*      */       },
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  979 */       NON_OPERATIONAL
/*      */       {
/*      */         protected final StackManipulation resolve(MethodDescription param3MethodDescription) {
/*  982 */           return (StackManipulation)StackManipulation.Trivial.INSTANCE;
/*      */         }
/*      */       };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected abstract StackManipulation resolve(MethodDescription param2MethodDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class OfParameterValue
/*      */       extends ForSetter<Void>
/*      */     {
/*      */       private final int index;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected OfParameterValue(FieldAccessor.FieldLocation param2FieldLocation, Assigner param2Assigner, Assigner.Typing param2Typing, FieldAccessor.ForSetter.TerminationHandler param2TerminationHandler, int param2Int) {
/* 1020 */         super(param2FieldLocation, param2Assigner, param2Typing, param2TerminationHandler);
/* 1021 */         this.index = param2Int;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/* 1028 */         return param2InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @AlwaysNull
/*      */       protected Void initialize(TypeDescription param2TypeDescription) {
/* 1036 */         return null;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected StackManipulation resolve(@MaybeNull Void param2Void, FieldDescription param2FieldDescription, TypeDescription param2TypeDescription, MethodDescription param2MethodDescription) {
/* 1046 */         if (param2MethodDescription.getParameters().size() <= this.index) {
/* 1047 */           throw new IllegalStateException(param2MethodDescription + " does not define a parameter with index " + this.index);
/*      */         }
/* 1049 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] {
/* 1050 */               MethodVariableAccess.load((ParameterDescription)param2MethodDescription.getParameters().get(this.index)), this.assigner
/* 1051 */               .assign(((ParameterDescription)param2MethodDescription.getParameters().get(this.index)).getType(), param2FieldDescription.getType(), this.typing)
/*      */             });
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Implementation andThen(Implementation param2Implementation) {
/* 1060 */         return new Implementation.Compound(new Implementation[] { new OfParameterValue(this.fieldLocation, this.assigner, this.typing, FieldAccessor.ForSetter.TerminationHandler.NON_OPERATIONAL, this.index), param2Implementation });
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Implementation.Composable andThen(Implementation.Composable param2Composable) {
/* 1071 */         return new Implementation.Compound.Composable(new OfParameterValue(this.fieldLocation, this.assigner, this.typing, FieldAccessor.ForSetter.TerminationHandler.NON_OPERATIONAL, this.index), param2Composable);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return !super.equals(param2Object) ? false : ((this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!(this.index != ((OfParameterValue)param2Object).index)))));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return super.hashCode() * 31 + this.index;
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected static class OfDefaultValue
/*      */       extends ForSetter<Void>
/*      */     {
/*      */       protected OfDefaultValue(FieldAccessor.FieldLocation param2FieldLocation, Assigner param2Assigner, Assigner.Typing param2Typing, FieldAccessor.ForSetter.TerminationHandler param2TerminationHandler) {
/* 1093 */         super(param2FieldLocation, param2Assigner, param2Typing, param2TerminationHandler);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/* 1100 */         return param2InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @AlwaysNull
/*      */       protected Void initialize(TypeDescription param2TypeDescription) {
/* 1108 */         return null;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected StackManipulation resolve(@MaybeNull Void param2Void, FieldDescription param2FieldDescription, TypeDescription param2TypeDescription, MethodDescription param2MethodDescription) {
/* 1118 */         return DefaultValue.of((TypeDefinition)param2FieldDescription.getType());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Implementation andThen(Implementation param2Implementation) {
/* 1125 */         return new Implementation.Compound(new Implementation[] { new OfDefaultValue(this.fieldLocation, this.assigner, this.typing, FieldAccessor.ForSetter.TerminationHandler.NON_OPERATIONAL), param2Implementation });
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Implementation.Composable andThen(Implementation.Composable param2Composable) {
/* 1135 */         return new Implementation.Compound.Composable(new OfDefaultValue(this.fieldLocation, this.assigner, this.typing, FieldAccessor.ForSetter.TerminationHandler.NON_OPERATIONAL), param2Composable);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class OfConstantValue
/*      */       extends ForSetter<Void>
/*      */     {
/*      */       private final TypeDescription.Generic typeDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final StackManipulation stackManipulation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected OfConstantValue(FieldAccessor.FieldLocation param2FieldLocation, Assigner param2Assigner, Assigner.Typing param2Typing, FieldAccessor.ForSetter.TerminationHandler param2TerminationHandler, TypeDescription.Generic param2Generic, StackManipulation param2StackManipulation) {
/* 1174 */         super(param2FieldLocation, param2Assigner, param2Typing, param2TerminationHandler);
/* 1175 */         this.typeDescription = param2Generic;
/* 1176 */         this.stackManipulation = param2StackManipulation;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/* 1183 */         return param2InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @AlwaysNull
/*      */       protected Void initialize(TypeDescription param2TypeDescription) {
/* 1191 */         return null;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected StackManipulation resolve(@MaybeNull Void param2Void, FieldDescription param2FieldDescription, TypeDescription param2TypeDescription, MethodDescription param2MethodDescription) {
/* 1201 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] { this.stackManipulation, this.assigner.assign(this.typeDescription, param2FieldDescription.getType(), this.typing) });
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Implementation andThen(Implementation param2Implementation) {
/* 1208 */         return new Implementation.Compound(new Implementation[] { new OfConstantValue(this.fieldLocation, this.assigner, this.typing, FieldAccessor.ForSetter.TerminationHandler.NON_OPERATIONAL, this.typeDescription, this.stackManipulation), param2Implementation });
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Implementation.Composable andThen(Implementation.Composable param2Composable) {
/* 1220 */         return new Implementation.Compound.Composable(new OfConstantValue(this.fieldLocation, this.assigner, this.typing, FieldAccessor.ForSetter.TerminationHandler.NON_OPERATIONAL, this.typeDescription, this.stackManipulation), param2Composable);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return !super.equals(param2Object) ? false : ((this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.typeDescription.equals(((OfConstantValue)param2Object).typeDescription) ? false : (!!this.stackManipulation.equals(((OfConstantValue)param2Object).stackManipulation))))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (super.hashCode() * 31 + this.typeDescription.hashCode()) * 31 + this.stackManipulation.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class OfReferenceValue
/*      */       extends ForSetter<FieldDescription.InDefinedShape>
/*      */     {
/*      */       protected static final String PREFIX = "fixedFieldValue";
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Object value;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected OfReferenceValue(FieldAccessor.FieldLocation param2FieldLocation, Assigner param2Assigner, Assigner.Typing param2Typing, FieldAccessor.ForSetter.TerminationHandler param2TerminationHandler, Object param2Object, String param2String) {
/* 1266 */         super(param2FieldLocation, param2Assigner, param2Typing, param2TerminationHandler);
/* 1267 */         this.value = param2Object;
/* 1268 */         this.name = param2String;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/* 1275 */         return param2InstrumentedType.withAuxiliaryField(new FieldDescription.Token(this.name, 4105, 
/*      */               
/* 1277 */               TypeDescription.ForLoadedType.of(this.value.getClass()).asGenericType()), this.value);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected FieldDescription.InDefinedShape initialize(TypeDescription param2TypeDescription) {
/* 1284 */         return (FieldDescription.InDefinedShape)((FieldList)param2TypeDescription.getDeclaredFields().filter((ElementMatcher)ElementMatchers.named(this.name))).getOnly();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Expects its own initialized value as argument")
/*      */       protected StackManipulation resolve(@MaybeNull FieldDescription.InDefinedShape param2InDefinedShape, FieldDescription param2FieldDescription, TypeDescription param2TypeDescription, MethodDescription param2MethodDescription) {
/* 1295 */         if (param2FieldDescription.isFinal() && param2MethodDescription.isMethod()) {
/* 1296 */           throw new IllegalArgumentException("Cannot set final field " + param2FieldDescription + " from " + param2MethodDescription);
/*      */         }
/* 1298 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] {
/* 1299 */               FieldAccess.forField(param2InDefinedShape).read(), this.assigner
/* 1300 */               .assign(TypeDescription.ForLoadedType.of(this.value.getClass()).asGenericType(), param2FieldDescription.getType(), this.typing)
/*      */             });
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Implementation andThen(Implementation param2Implementation) {
/* 1308 */         return new Implementation.Compound(new Implementation[] { new OfReferenceValue(this.fieldLocation, this.assigner, this.typing, FieldAccessor.ForSetter.TerminationHandler.NON_OPERATIONAL, this.value, this.name), param2Implementation });
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Implementation.Composable andThen(Implementation.Composable param2Composable) {
/* 1320 */         return new Implementation.Compound.Composable(new OfReferenceValue(this.fieldLocation, this.assigner, this.typing, FieldAccessor.ForSetter.TerminationHandler.NON_OPERATIONAL, this.value, this.name), param2Composable);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return !super.equals(param2Object) ? false : ((this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.name.equals(((OfReferenceValue)param2Object).name) ? false : (!!this.value.equals(((OfReferenceValue)param2Object).value))))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (super.hashCode() * 31 + this.value.hashCode()) * 31 + this.name.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class OfFieldValue
/*      */       extends ForSetter<FieldAccessor.FieldLocation.Prepared>
/*      */     {
/*      */       private final FieldAccessor.FieldLocation target;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected OfFieldValue(FieldAccessor.FieldLocation param2FieldLocation1, Assigner param2Assigner, Assigner.Typing param2Typing, FieldAccessor.ForSetter.TerminationHandler param2TerminationHandler, FieldAccessor.FieldLocation param2FieldLocation2) {
/* 1354 */         super(param2FieldLocation1, param2Assigner, param2Typing, param2TerminationHandler);
/* 1355 */         this.target = param2FieldLocation2;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/* 1362 */         return param2InstrumentedType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected FieldAccessor.FieldLocation.Prepared initialize(TypeDescription param2TypeDescription) {
/* 1369 */         return this.target.prepare(param2TypeDescription);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @SuppressFBWarnings(value = {"NP_PARAMETER_MUST_BE_NONNULL_BUT_MARKED_AS_NULLABLE"}, justification = "Expects its own initialized value as argument")
/*      */       protected StackManipulation resolve(@MaybeNull FieldAccessor.FieldLocation.Prepared param2Prepared, FieldDescription param2FieldDescription, TypeDescription param2TypeDescription, MethodDescription param2MethodDescription) {
/*      */         FieldDescription fieldDescription;
/* 1381 */         if (!(fieldDescription = param2Prepared.resolve(param2MethodDescription)).isStatic() && param2MethodDescription.isStatic()) {
/* 1382 */           throw new IllegalStateException("Cannot set instance field " + param2FieldDescription + " from " + param2MethodDescription);
/*      */         }
/* 1384 */         return (StackManipulation)new StackManipulation.Compound(new StackManipulation[] {
/* 1385 */               fieldDescription.isStatic() ? (StackManipulation)StackManipulation.Trivial.INSTANCE : 
/*      */               
/* 1387 */               MethodVariableAccess.loadThis(), 
/* 1388 */               FieldAccess.forField(fieldDescription).read(), this.assigner
/* 1389 */               .assign(fieldDescription.getType(), param2FieldDescription.getType(), this.typing)
/*      */             });
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Implementation andThen(Implementation param2Implementation) {
/* 1397 */         return new Implementation.Compound(new Implementation[] { new OfFieldValue(this.fieldLocation, this.assigner, this.typing, FieldAccessor.ForSetter.TerminationHandler.NON_OPERATIONAL, this.target), param2Implementation });
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Implementation.Composable andThen(Implementation.Composable param2Composable) {
/* 1408 */         return new Implementation.Compound.Composable(new OfFieldValue(this.fieldLocation, this.assigner, this.typing, FieldAccessor.ForSetter.TerminationHandler.NON_OPERATIONAL, this.target), param2Composable);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return !super.equals(param2Object) ? false : ((this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.target.equals(((OfFieldValue)param2Object).target)))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return super.hashCode() * 31 + this.target.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance(includeSyntheticFields = true)
/*      */     protected class Appender
/*      */       implements ByteCodeAppender
/*      */     {
/*      */       private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*      */       private final T initialized;
/*      */ 
/*      */       
/*      */       private final FieldAccessor.FieldLocation.Prepared fieldLocation;
/*      */ 
/*      */ 
/*      */       
/*      */       protected Appender(FieldAccessor.ForSetter this$0, @MaybeNull TypeDescription param2TypeDescription, T param2T, FieldAccessor.FieldLocation.Prepared param2Prepared) {
/* 1447 */         this.instrumentedType = param2TypeDescription;
/* 1448 */         this.initialized = param2T;
/* 1449 */         this.fieldLocation = param2Prepared;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ByteCodeAppender.Size apply(MethodVisitor param2MethodVisitor, Implementation.Context param2Context, MethodDescription param2MethodDescription) {
/*      */         FieldDescription fieldDescription;
/* 1457 */         if (!(fieldDescription = this.fieldLocation.resolve(param2MethodDescription)).isStatic() && param2MethodDescription.isStatic())
/* 1458 */           throw new IllegalStateException("Cannot set instance field " + fieldDescription + " from " + param2MethodDescription); 
/* 1459 */         if (fieldDescription.isFinal() && param2MethodDescription.isMethod()) {
/* 1460 */           throw new IllegalStateException("Cannot set final field " + fieldDescription + " from " + param2MethodDescription);
/*      */         }
/*      */         StackManipulation stackManipulation;
/* 1463 */         if (!(stackManipulation = this.a.resolve(this.initialized, fieldDescription, this.instrumentedType, param2MethodDescription)).isValid()) {
/* 1464 */           throw new IllegalStateException("Set value cannot be assigned to " + fieldDescription);
/*      */         }
/* 1466 */         return new ByteCodeAppender.Size((new StackManipulation.Compound(new StackManipulation[] {
/* 1467 */                 param2MethodDescription.isStatic() ? (StackManipulation)StackManipulation.Trivial.INSTANCE : 
/*      */                 
/* 1469 */                 MethodVariableAccess.loadThis(), stackManipulation, 
/*      */                 
/* 1471 */                 FieldAccess.forField(fieldDescription).write(), 
/* 1472 */                 FieldAccessor.ForSetter.a(this.a).resolve(param2MethodDescription)
/* 1473 */               }, )).apply(param2MethodVisitor, param2Context).getMaximalSize(), param2MethodDescription.getStackSize());
/*      */       }
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         T t2;
/*      */         if (this == param2Object)
/*      */           return true; 
/*      */         if (param2Object == null)
/*      */           return false; 
/*      */         if (getClass() != param2Object.getClass())
/*      */           return false; 
/*      */         if (!this.instrumentedType.equals(((Appender)param2Object).instrumentedType))
/*      */           return false; 
/*      */         T t1 = ((Appender)param2Object).initialized;
/*      */         if (t1 != null) {
/*      */           if ((t2 = this.initialized) != null) {
/*      */             if (!t2.equals(t1))
/*      */               return false; 
/*      */           } else {
/*      */             return false;
/*      */           } 
/*      */         } else if ((t2 = this.initialized) != null) {
/*      */           return false;
/*      */         } 
/*      */         return !this.fieldLocation.equals(((Appender)param2Object).fieldLocation) ? false : (!!this.a.equals(((Appender)param2Object).a));
/*      */       }
/*      */       
/*      */       public int hashCode() {
/*      */         T t;
/*      */         if ((t = this.initialized) != null);
/*      */         return (((getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + t.hashCode()) * 31 + this.fieldLocation.hashCode()) * 31 + this.a.hashCode();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static interface OwnerTypeLocatable extends AssignerConfigurable {
/*      */     FieldAccessor.AssignerConfigurable in(Class<?> param1Class);
/*      */     
/*      */     FieldAccessor.AssignerConfigurable in(TypeDescription param1TypeDescription);
/*      */     
/*      */     FieldAccessor.AssignerConfigurable in(FieldLocator.Factory param1Factory);
/*      */   }
/*      */   
/*      */   public static interface AssignerConfigurable extends PropertyConfigurable {
/*      */     FieldAccessor.PropertyConfigurable withAssigner(Assigner param1Assigner, Assigner.Typing param1Typing);
/*      */   }
/*      */   
/*      */   public static interface PropertyConfigurable extends Implementation {
/*      */     Implementation.Composable setsArgumentAt(int param1Int);
/*      */     
/*      */     Implementation.Composable setsDefaultValue();
/*      */     
/*      */     Implementation.Composable setsValue(Object param1Object);
/*      */     
/*      */     Implementation.Composable setsValue(TypeDescription param1TypeDescription);
/*      */     
/*      */     Implementation.Composable setsValue(JavaConstant param1JavaConstant);
/*      */     
/*      */     Implementation.Composable setsValue(StackManipulation param1StackManipulation, Type param1Type);
/*      */     
/*      */     Implementation.Composable setsValue(StackManipulation param1StackManipulation, TypeDescription.Generic param1Generic);
/*      */     
/*      */     Implementation.Composable setsReference(Object param1Object);
/*      */     
/*      */     Implementation.Composable setsReference(Object param1Object, String param1String);
/*      */     
/*      */     Implementation.Composable setsFieldValueOf(Field param1Field);
/*      */     
/*      */     Implementation.Composable setsFieldValueOf(FieldDescription param1FieldDescription);
/*      */     
/*      */     Implementation.Composable setsFieldValueOf(String param1String);
/*      */     
/*      */     Implementation.Composable setsFieldValueOf(FieldAccessor.FieldNameExtractor param1FieldNameExtractor);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\FieldAccessor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */