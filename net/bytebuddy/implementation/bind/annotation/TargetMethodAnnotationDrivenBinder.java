/*     */ package net.bytebuddy.implementation.bind.annotation;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*     */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*     */ import net.bytebuddy.description.annotation.AnnotationSource;
/*     */ import net.bytebuddy.description.enumeration.EnumerationDescription;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.ParameterDescription;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.scaffold.FieldLocator;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bind.MethodDelegationBinder;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*     */ import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
/*     */ import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
/*     */ import net.bytebuddy.implementation.bytecode.constant.DoubleConstant;
/*     */ import net.bytebuddy.implementation.bytecode.constant.FloatConstant;
/*     */ import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
/*     */ import net.bytebuddy.implementation.bytecode.constant.JavaConstantValue;
/*     */ import net.bytebuddy.implementation.bytecode.constant.LongConstant;
/*     */ import net.bytebuddy.implementation.bytecode.constant.TextConstant;
/*     */ import net.bytebuddy.implementation.bytecode.member.FieldAccess;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
/*     */ import net.bytebuddy.utility.JavaConstant;
/*     */ import net.bytebuddy.utility.JavaType;
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
/*     */ @Enhance
/*     */ public class TargetMethodAnnotationDrivenBinder
/*     */   implements MethodDelegationBinder
/*     */ {
/*     */   private final DelegationProcessor delegationProcessor;
/*     */   
/*     */   protected TargetMethodAnnotationDrivenBinder(DelegationProcessor paramDelegationProcessor) {
/*  61 */     this.delegationProcessor = paramDelegationProcessor;
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
/*     */   public static MethodDelegationBinder of(List<? extends ParameterBinder<?>> paramList) {
/*  73 */     return new TargetMethodAnnotationDrivenBinder(DelegationProcessor.of(paramList));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MethodDelegationBinder.Record compile(MethodDescription paramMethodDescription) {
/*  80 */     if (IgnoreForBinding.Verifier.check(paramMethodDescription)) {
/*  81 */       return (MethodDelegationBinder.Record)MethodDelegationBinder.Record.Illegal.INSTANCE;
/*     */     }
/*  83 */     ArrayList<DelegationProcessor.Handler> arrayList = new ArrayList(paramMethodDescription.getParameters().size());
/*  84 */     for (ParameterDescription parameterDescription : paramMethodDescription.getParameters()) {
/*  85 */       arrayList.add(this.delegationProcessor.prepare(parameterDescription));
/*     */     }
/*  87 */     return new Record(paramMethodDescription, arrayList, RuntimeType.Verifier.check((AnnotationSource)paramMethodDescription));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.delegationProcessor.equals(((TargetMethodAnnotationDrivenBinder)paramObject).delegationProcessor))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     return getClass().hashCode() * 31 + this.delegationProcessor.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   protected static class Record
/*     */     implements MethodDelegationBinder.Record
/*     */   {
/*     */     private final MethodDescription candidate;
/*     */ 
/*     */     
/*     */     private final List<TargetMethodAnnotationDrivenBinder.DelegationProcessor.Handler> handlers;
/*     */ 
/*     */     
/*     */     private final Assigner.Typing typing;
/*     */ 
/*     */ 
/*     */     
/*     */     protected Record(MethodDescription param1MethodDescription, List<TargetMethodAnnotationDrivenBinder.DelegationProcessor.Handler> param1List, Assigner.Typing param1Typing) {
/* 119 */       this.candidate = param1MethodDescription;
/* 120 */       this.handlers = param1List;
/* 121 */       this.typing = param1Typing;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public MethodDelegationBinder.MethodBinding bind(Implementation.Target param1Target, MethodDescription param1MethodDescription, MethodDelegationBinder.TerminationHandler param1TerminationHandler, MethodDelegationBinder.MethodInvoker param1MethodInvoker, Assigner param1Assigner) {
/* 132 */       if (!this.candidate.isAccessibleTo(param1Target.getInstrumentedType())) {
/* 133 */         return (MethodDelegationBinder.MethodBinding)MethodDelegationBinder.MethodBinding.Illegal.INSTANCE;
/*     */       }
/*     */       StackManipulation stackManipulation;
/* 136 */       if (!(stackManipulation = param1TerminationHandler.resolve(param1Assigner, this.typing, param1MethodDescription, this.candidate)).isValid()) {
/* 137 */         return (MethodDelegationBinder.MethodBinding)MethodDelegationBinder.MethodBinding.Illegal.INSTANCE;
/*     */       }
/* 139 */       MethodDelegationBinder.MethodBinding.Builder builder = new MethodDelegationBinder.MethodBinding.Builder(param1MethodInvoker, this.candidate);
/* 140 */       for (Iterator<TargetMethodAnnotationDrivenBinder.DelegationProcessor.Handler> iterator = this.handlers.iterator(); iterator.hasNext();) {
/*     */         
/* 142 */         if (!(parameterBinding = (handler = iterator.next()).bind(param1MethodDescription, param1Target, param1Assigner)).isValid() || !builder.append(parameterBinding)) {
/* 143 */           return (MethodDelegationBinder.MethodBinding)MethodDelegationBinder.MethodBinding.Illegal.INSTANCE;
/*     */         }
/*     */       } 
/* 146 */       return builder.build(stackManipulation);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 151 */       return this.candidate.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.typing.equals(((Record)param1Object).typing) ? false : (!this.candidate.equals(((Record)param1Object).candidate) ? false : (!!this.handlers.equals(((Record)param1Object).handlers))))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return ((getClass().hashCode() * 31 + this.candidate.hashCode()) * 31 + this.handlers.hashCode()) * 31 + this.typing.hashCode();
/*     */     }
/*     */   }
/*     */   
/*     */   @SuppressFBWarnings(value = {"IC_SUPERCLASS_USES_SUBCLASS_DURING_INITIALIZATION"}, justification = "Safe initialization is implied.")
/*     */   public static interface ParameterBinder<T extends Annotation>
/*     */   {
/* 167 */     public static final List<ParameterBinder<?>> DEFAULTS = Collections.unmodifiableList(Arrays.asList((ParameterBinder<?>[])new ParameterBinder[] { Argument.Binder.INSTANCE, AllArguments.Binder.INSTANCE, Origin.Binder.INSTANCE, This.Binder.INSTANCE, Super.Binder.INSTANCE, Default.Binder.INSTANCE, SuperCall.Binder.INSTANCE, DefaultCall.Binder.INSTANCE, SuperMethod.Binder.INSTANCE, DefaultMethod.Binder.INSTANCE, FieldValue.Binder.INSTANCE, StubValue.Binder.INSTANCE, Empty.Binder.INSTANCE }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Class<T> getHandledType();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<T> param1Loadable, MethodDescription param1MethodDescription, ParameterDescription param1ParameterDescription, Implementation.Target param1Target, Assigner param1Assigner, Assigner.Typing param1Typing);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static abstract class ForFixedValue<S extends Annotation>
/*     */       implements ParameterBinder<S>
/*     */     {
/*     */       public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<S> param2Loadable, MethodDescription param2MethodDescription, ParameterDescription param2ParameterDescription, Implementation.Target param2Target, Assigner param2Assigner, Assigner.Typing param2Typing) {
/*     */         JavaConstantValue javaConstantValue;
/*     */         Object object;
/* 237 */         if ((object = bind(param2Loadable, param2MethodDescription, param2ParameterDescription)) == null) {
/* 238 */           return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous(DefaultValue.of((TypeDefinition)param2ParameterDescription.getType()));
/*     */         }
/*     */ 
/*     */         
/* 242 */         if (object instanceof Boolean) {
/* 243 */           StackManipulation stackManipulation = IntegerConstant.forValue(((Boolean)object).booleanValue());
/* 244 */           object = TypeDescription.ForLoadedType.of(boolean.class);
/* 245 */         } else if (object instanceof Byte) {
/* 246 */           StackManipulation stackManipulation = IntegerConstant.forValue(((Byte)object).byteValue());
/* 247 */           object = TypeDescription.ForLoadedType.of(byte.class);
/* 248 */         } else if (object instanceof Short) {
/* 249 */           StackManipulation stackManipulation = IntegerConstant.forValue(((Short)object).shortValue());
/* 250 */           object = TypeDescription.ForLoadedType.of(short.class);
/* 251 */         } else if (object instanceof Character) {
/* 252 */           StackManipulation stackManipulation = IntegerConstant.forValue(((Character)object).charValue());
/* 253 */           object = TypeDescription.ForLoadedType.of(char.class);
/* 254 */         } else if (object instanceof Integer) {
/* 255 */           StackManipulation stackManipulation = IntegerConstant.forValue(((Integer)object).intValue());
/* 256 */           object = TypeDescription.ForLoadedType.of(int.class);
/* 257 */         } else if (object instanceof Long) {
/* 258 */           StackManipulation stackManipulation = LongConstant.forValue(((Long)object).longValue());
/* 259 */           object = TypeDescription.ForLoadedType.of(long.class);
/* 260 */         } else if (object instanceof Float) {
/* 261 */           StackManipulation stackManipulation = FloatConstant.forValue(((Float)object).floatValue());
/* 262 */           object = TypeDescription.ForLoadedType.of(float.class);
/* 263 */         } else if (object instanceof Double) {
/* 264 */           StackManipulation stackManipulation = DoubleConstant.forValue(((Double)object).doubleValue());
/* 265 */           object = TypeDescription.ForLoadedType.of(double.class);
/* 266 */         } else if (object instanceof String) {
/* 267 */           TextConstant textConstant = new TextConstant((String)object);
/* 268 */           object = TypeDescription.ForLoadedType.of(String.class);
/* 269 */         } else if (object instanceof Class) {
/* 270 */           StackManipulation stackManipulation = ClassConstant.of(TypeDescription.ForLoadedType.of((Class)object));
/* 271 */           object = TypeDescription.ForLoadedType.of(Class.class);
/* 272 */         } else if (object instanceof TypeDescription) {
/* 273 */           StackManipulation stackManipulation = ClassConstant.of((TypeDescription)object);
/* 274 */           object = TypeDescription.ForLoadedType.of(Class.class);
/* 275 */         } else if (object instanceof Enum) {
/* 276 */           StackManipulation stackManipulation = FieldAccess.forEnumeration((EnumerationDescription)new EnumerationDescription.ForLoadedEnumeration((Enum)object));
/* 277 */           object = TypeDescription.ForLoadedType.of(((Enum)object).getDeclaringClass());
/* 278 */         } else if (object instanceof EnumerationDescription) {
/* 279 */           StackManipulation stackManipulation = FieldAccess.forEnumeration((EnumerationDescription)object);
/* 280 */           object = ((EnumerationDescription)object).getEnumerationType();
/* 281 */         } else if (JavaType.METHOD_HANDLE.isInstance(object)) {
/* 282 */           javaConstantValue = new JavaConstantValue((JavaConstant)JavaConstant.MethodHandle.ofLoaded(object));
/* 283 */           object = JavaType.METHOD_HANDLE.getTypeStub();
/* 284 */         } else if (object instanceof JavaConstant.MethodHandle) {
/* 285 */           javaConstantValue = new JavaConstantValue((JavaConstant)object);
/* 286 */           object = JavaType.METHOD_HANDLE.getTypeStub();
/* 287 */         } else if (JavaType.METHOD_TYPE.isInstance(object)) {
/* 288 */           javaConstantValue = new JavaConstantValue((JavaConstant)JavaConstant.MethodType.ofLoaded(object));
/* 289 */           object = JavaType.METHOD_HANDLE.getTypeStub();
/* 290 */         } else if (object instanceof JavaConstant) {
/* 291 */           javaConstantValue = new JavaConstantValue((JavaConstant)object);
/* 292 */           object = ((JavaConstant)object).getTypeDescription();
/*     */         } else {
/* 294 */           throw new IllegalStateException("Not able to save in class's constant pool: " + object);
/*     */         } 
/* 296 */         return (MethodDelegationBinder.ParameterBinding<?>)new MethodDelegationBinder.ParameterBinding.Anonymous((StackManipulation)new StackManipulation.Compound(new StackManipulation[] { (StackManipulation)javaConstantValue, param2Assigner
/*     */                 
/* 298 */                 .assign(object.asGenericType(), param2ParameterDescription.getType(), param2Typing) }));
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
/*     */       @MaybeNull
/*     */       protected abstract Object bind(AnnotationDescription.Loadable<S> param2Loadable, MethodDescription param2MethodDescription, ParameterDescription param2ParameterDescription);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @Enhance
/*     */       public static class OfConstant<U extends Annotation>
/*     */         extends ForFixedValue<U>
/*     */       {
/*     */         private final Class<U> type;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         @MaybeNull
/*     */         @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*     */         private final Object value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected OfConstant(Class<U> param3Class, @MaybeNull Object param3Object) {
/* 348 */           this.type = param3Class;
/* 349 */           this.value = param3Object;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public static <V extends Annotation> TargetMethodAnnotationDrivenBinder.ParameterBinder<V> of(Class<V> param3Class, @MaybeNull Object param3Object) {
/* 361 */           return new OfConstant<V>(param3Class, param3Object);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public Class<U> getHandledType() {
/* 368 */           return this.type;
/*     */         }
/*     */         
/*     */         @MaybeNull
/*     */         protected Object bind(AnnotationDescription.Loadable<U> param3Loadable, MethodDescription param3MethodDescription, ParameterDescription param3ParameterDescription)
/*     */         {
/* 374 */           return this.value;
/*     */         } public boolean equals(@MaybeNull Object param3Object) { Object object;
/*     */           if (this == param3Object)
/*     */             return true; 
/*     */           if (param3Object == null)
/*     */             return false; 
/*     */           if (getClass() != param3Object.getClass())
/*     */             return false; 
/*     */           if (!this.type.equals(((OfConstant)param3Object).type))
/*     */             return false; 
/*     */           param3Object = ((OfConstant)param3Object).value;
/*     */           if (param3Object != null) {
/*     */             if ((object = this.value) != null) {
/*     */               if (!object.equals(param3Object))
/*     */                 return false; 
/*     */             } else {
/*     */               return false;
/*     */             } 
/*     */           } else if ((object = this.value) != null) {
/*     */             return false;
/*     */           } 
/*     */           return true; } public int hashCode() { Object object;
/*     */           if ((object = this.value) != null);
/*     */           return (getClass().hashCode() * 31 + this.type.hashCode()) * 31 + object.hashCode(); } } } public static abstract class ForFieldBinding<S extends Annotation> implements ParameterBinder<S> { protected static final String BEAN_PROPERTY = "";
/*     */       private static FieldLocator.Resolution resolveAccessor(FieldLocator param2FieldLocator, MethodDescription param2MethodDescription) {
/*     */         String str;
/* 400 */         if (ElementMatchers.isSetter().matches(param2MethodDescription)) {
/* 401 */           str = param2MethodDescription.getInternalName().substring(3);
/* 402 */         } else if (ElementMatchers.isGetter().matches(str)) {
/* 403 */           str = str.getInternalName().substring(str.getInternalName().startsWith("is") ? 2 : 3);
/*     */         } else {
/* 405 */           return (FieldLocator.Resolution)FieldLocator.Resolution.Illegal.INSTANCE;
/*     */         } 
/* 407 */         return param2FieldLocator.locate(Character.toLowerCase(str.charAt(0)) + str.substring(1));
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
/*     */       public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<S> param2Loadable, MethodDescription param2MethodDescription, ParameterDescription param2ParameterDescription, Implementation.Target param2Target, Assigner param2Assigner, Assigner.Typing param2Typing) {
/* 419 */         if (!declaringType(param2Loadable).represents(void.class)) {
/* 420 */           if (declaringType(param2Loadable).isPrimitive() || declaringType(param2Loadable).isArray())
/* 421 */             throw new IllegalStateException("A primitive type or array type cannot declare a field: " + param2MethodDescription); 
/* 422 */           if (!param2Target.getInstrumentedType().isAssignableTo(declaringType(param2Loadable))) {
/* 423 */             return (MethodDelegationBinder.ParameterBinding<?>)MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 428 */         param2Typing = declaringType(param2Loadable).represents(void.class) ? (Assigner.Typing)new FieldLocator.ForClassHierarchy(param2Target.getInstrumentedType()) : (Assigner.Typing)new FieldLocator.ForExactType(declaringType(param2Loadable), param2Target.getInstrumentedType());
/*     */         
/*     */         FieldLocator.Resolution resolution;
/*     */         
/* 432 */         if ((resolution = fieldName(param2Loadable).equals("") ? resolveAccessor((FieldLocator)param2Typing, param2MethodDescription) : param2Typing.locate(fieldName(param2Loadable))).isResolved() && (!param2MethodDescription.isStatic() || resolution.getField().isStatic()))
/* 433 */           return bind(resolution.getField(), param2Loadable, param2MethodDescription, param2ParameterDescription, param2Target, param2Assigner);  return (MethodDelegationBinder.ParameterBinding<?>)MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
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
/*     */       protected abstract String fieldName(AnnotationDescription.Loadable<S> param2Loadable);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected abstract TypeDescription declaringType(AnnotationDescription.Loadable<S> param2Loadable);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected abstract MethodDelegationBinder.ParameterBinding<?> bind(FieldDescription param2FieldDescription, AnnotationDescription.Loadable<S> param2Loadable, MethodDescription param2MethodDescription, ParameterDescription param2ParameterDescription, Implementation.Target param2Target, Assigner param2Assigner); }
/*     */   
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
/*     */   @Enhance
/*     */   protected static class DelegationProcessor
/*     */   {
/*     */     private final Map<? extends TypeDescription, ? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected DelegationProcessor(Map<? extends TypeDescription, ? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> param1Map) {
/* 495 */       this.parameterBinders = param1Map;
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
/*     */     protected static DelegationProcessor of(List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> param1List) {
/* 507 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 508 */       for (TargetMethodAnnotationDrivenBinder.ParameterBinder<?> parameterBinder : param1List) {
/* 509 */         if (hashMap.put(TypeDescription.ForLoadedType.of(parameterBinder.getHandledType()), parameterBinder) != null) {
/* 510 */           throw new IllegalArgumentException("Attempt to bind two handlers to " + parameterBinder.getHandledType());
/*     */         }
/*     */       } 
/* 513 */       return new DelegationProcessor((Map)hashMap);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected Handler prepare(ParameterDescription param1ParameterDescription) {
/* 524 */       Assigner.Typing typing = RuntimeType.Verifier.check((AnnotationSource)param1ParameterDescription);
/* 525 */       Handler handler = new Handler.Unbound(param1ParameterDescription, typing);
/* 526 */       for (AnnotationDescription annotationDescription : param1ParameterDescription.getDeclaredAnnotations()) {
/*     */         TargetMethodAnnotationDrivenBinder.ParameterBinder<?> parameterBinder;
/* 528 */         if ((parameterBinder = this.parameterBinders.get(annotationDescription.getAnnotationType())) != null && handler.isBound())
/* 529 */           throw new IllegalStateException("Ambiguous binding for parameter annotated with two handled annotation types"); 
/* 530 */         if (parameterBinder != null) {
/* 531 */           handler = Handler.Bound.of(param1ParameterDescription, parameterBinder, annotationDescription, typing);
/*     */         }
/*     */       } 
/* 534 */       return handler;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.parameterBinders.equals(((DelegationProcessor)param1Object).parameterBinders))));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.parameterBinders.hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     public static class Unbound
/*     */       implements Handler
/*     */     {
/*     */       private final ParameterDescription target;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final Assigner.Typing typing;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected Unbound(ParameterDescription param2ParameterDescription, Assigner.Typing param2Typing) {
/* 583 */         this.target = param2ParameterDescription;
/* 584 */         this.typing = param2Typing;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean isBound() {
/* 591 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public MethodDelegationBinder.ParameterBinding<?> bind(MethodDescription param2MethodDescription, Implementation.Target param2Target, Assigner param2Assigner) {
/* 598 */         return Argument.Binder.INSTANCE.bind(AnnotationDescription.ForLoadedAnnotation.of(new DefaultArgument(this.target.getIndex())), param2MethodDescription, this.target, param2Target, param2Assigner, this.typing);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.typing.equals(((Unbound)param2Object).typing) ? false : (!!this.target.equals(((Unbound)param2Object).target)))));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return (getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.typing.hashCode();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected static class DefaultArgument
/*     */         implements Argument
/*     */       {
/*     */         private static final String VALUE = "value";
/*     */ 
/*     */         
/*     */         private static final String BINDING_MECHANIC = "bindingMechanic";
/*     */ 
/*     */         
/*     */         private final int parameterIndex;
/*     */ 
/*     */ 
/*     */         
/*     */         protected DefaultArgument(int param4Int) {
/* 632 */           this.parameterIndex = param4Int;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public int value() {
/* 639 */           return this.parameterIndex;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public Argument.BindingMechanic bindingMechanic() {
/* 646 */           return Argument.BindingMechanic.UNIQUE;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public Class<Argument> annotationType() {
/* 653 */           return Argument.class;
/*     */         }
/*     */ 
/*     */         
/*     */         public int hashCode() {
/* 658 */           return (127 * "bindingMechanic".hashCode() ^ Argument.BindingMechanic.UNIQUE.hashCode()) + (127 * "value".hashCode() ^ this.parameterIndex);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean equals(@MaybeNull Object param4Object) {
/* 663 */           return (this == param4Object || (param4Object instanceof Argument && this.parameterIndex == ((Argument)param4Object).value()));
/*     */         }
/*     */         
/*     */         public String toString()
/*     */         {
/* 668 */           return "@" + Argument.class.getName() + "(bindingMechanic=" + Argument.BindingMechanic.UNIQUE + ", value=" + this.parameterIndex + ")"; } } } protected static interface Handler { boolean isBound(); MethodDelegationBinder.ParameterBinding<?> bind(MethodDescription param2MethodDescription, Implementation.Target param2Target, Assigner param2Assigner); @Enhance public static class Unbound implements Handler { private final ParameterDescription target; private final Assigner.Typing typing; protected Unbound(ParameterDescription param3ParameterDescription, Assigner.Typing param3Typing) { this.target = param3ParameterDescription; this.typing = param3Typing; } public boolean isBound() { return false; } public MethodDelegationBinder.ParameterBinding<?> bind(MethodDescription param3MethodDescription, Implementation.Target param3Target, Assigner param3Assigner) { return Argument.Binder.INSTANCE.bind(AnnotationDescription.ForLoadedAnnotation.of(new DefaultArgument(this.target.getIndex())), param3MethodDescription, this.target, param3Target, param3Assigner, this.typing); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.typing.equals(((Unbound)param3Object).typing) ? false : (!!this.target.equals(((Unbound)param3Object).target))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.typing.hashCode(); } protected static class DefaultArgument implements Argument { private static final String VALUE = "value"; private static final String BINDING_MECHANIC = "bindingMechanic"; private final int parameterIndex; protected DefaultArgument(int param4Int) { this.parameterIndex = param4Int; } public int value() { return this.parameterIndex; } public Argument.BindingMechanic bindingMechanic() { return Argument.BindingMechanic.UNIQUE; } public Class<Argument> annotationType() { return Argument.class; } public int hashCode() { return (127 * "bindingMechanic".hashCode() ^ Argument.BindingMechanic.UNIQUE.hashCode()) + (127 * "value".hashCode() ^ this.parameterIndex); } public boolean equals(@MaybeNull Object param4Object) { return (this == param4Object || (param4Object instanceof Argument && this.parameterIndex == ((Argument)param4Object).value())); } public String toString() { return "@" + Argument.class.getName() + "(bindingMechanic=" + Argument.BindingMechanic.UNIQUE + ", value=" + this.parameterIndex + ")"; }
/*     */            }
/*     */          }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @Enhance
/*     */       public static class Bound<T extends Annotation>
/*     */         implements Handler
/*     */       {
/*     */         private final ParameterDescription target;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private final TargetMethodAnnotationDrivenBinder.ParameterBinder<T> parameterBinder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private final AnnotationDescription.Loadable<T> annotation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private final Assigner.Typing typing;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected Bound(ParameterDescription param3ParameterDescription, TargetMethodAnnotationDrivenBinder.ParameterBinder<T> param3ParameterBinder, AnnotationDescription.Loadable<T> param3Loadable, Assigner.Typing param3Typing) {
/* 716 */           this.target = param3ParameterDescription;
/* 717 */           this.parameterBinder = param3ParameterBinder;
/* 718 */           this.annotation = param3Loadable;
/* 719 */           this.typing = param3Typing;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected static TargetMethodAnnotationDrivenBinder.DelegationProcessor.Handler of(ParameterDescription param3ParameterDescription, TargetMethodAnnotationDrivenBinder.ParameterBinder<?> param3ParameterBinder, AnnotationDescription param3AnnotationDescription, Assigner.Typing param3Typing) {
/* 736 */           return new Bound(param3ParameterDescription, param3ParameterBinder, param3AnnotationDescription
/*     */               
/* 738 */               .prepare(param3ParameterBinder.getHandledType()), param3Typing);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean isBound() {
/* 746 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public MethodDelegationBinder.ParameterBinding<?> bind(MethodDescription param3MethodDescription, Implementation.Target param3Target, Assigner param3Assigner)
/*     */         {
/* 753 */           return this.parameterBinder.bind(this.annotation, param3MethodDescription, this.target, param3Target, param3Assigner, this.typing); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.typing.equals(((Bound)param3Object).typing) ? false : (!this.target.equals(((Bound)param3Object).target) ? false : (!this.parameterBinder.equals(((Bound)param3Object).parameterBinder) ? false : (!!this.annotation.equals(((Bound)param3Object).annotation))))))); } public int hashCode() { return (((getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.parameterBinder.hashCode()) * 31 + this.annotation.hashCode()) * 31 + this.typing.hashCode(); } } } @Enhance public static class Bound<T extends Annotation> implements Handler { private final ParameterDescription target; private final TargetMethodAnnotationDrivenBinder.ParameterBinder<T> parameterBinder; private final AnnotationDescription.Loadable<T> annotation; private final Assigner.Typing typing; protected Bound(ParameterDescription param2ParameterDescription, TargetMethodAnnotationDrivenBinder.ParameterBinder<T> param2ParameterBinder, AnnotationDescription.Loadable<T> param2Loadable, Assigner.Typing param2Typing) { this.target = param2ParameterDescription; this.parameterBinder = param2ParameterBinder; this.annotation = param2Loadable; this.typing = param2Typing; } protected static TargetMethodAnnotationDrivenBinder.DelegationProcessor.Handler of(ParameterDescription param2ParameterDescription, TargetMethodAnnotationDrivenBinder.ParameterBinder<?> param2ParameterBinder, AnnotationDescription param2AnnotationDescription, Assigner.Typing param2Typing) { return new Bound(param2ParameterDescription, param2ParameterBinder, param2AnnotationDescription.prepare(param2ParameterBinder.getHandledType()), param2Typing); } public boolean isBound() { return true; } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.typing.equals(((Bound)param2Object).typing) ? false : (!this.target.equals(((Bound)param2Object).target) ? false : (!this.parameterBinder.equals(((Bound)param2Object).parameterBinder) ? false : (!!this.annotation.equals(((Bound)param2Object).annotation))))))); } public MethodDelegationBinder.ParameterBinding<?> bind(MethodDescription param2MethodDescription, Implementation.Target param2Target, Assigner param2Assigner) { return this.parameterBinder.bind(this.annotation, param2MethodDescription, this.target, param2Target, param2Assigner, this.typing); } public int hashCode() { return (((getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.parameterBinder.hashCode()) * 31 + this.annotation.hashCode()) * 31 + this.typing.hashCode(); } } } protected static interface Handler { boolean isBound(); MethodDelegationBinder.ParameterBinding<?> bind(MethodDescription param1MethodDescription, Implementation.Target param1Target, Assigner param1Assigner); @Enhance public static class Unbound implements Handler { private final ParameterDescription target; private final Assigner.Typing typing; protected Unbound(ParameterDescription param3ParameterDescription, Assigner.Typing param3Typing) { this.target = param3ParameterDescription; this.typing = param3Typing; } public boolean isBound() { return false; } public MethodDelegationBinder.ParameterBinding<?> bind(MethodDescription param3MethodDescription, Implementation.Target param3Target, Assigner param3Assigner) { return Argument.Binder.INSTANCE.bind(AnnotationDescription.ForLoadedAnnotation.of(new DefaultArgument(this.target.getIndex())), param3MethodDescription, this.target, param3Target, param3Assigner, this.typing); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.typing.equals(((Unbound)param3Object).typing) ? false : (!!this.target.equals(((Unbound)param3Object).target))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.typing.hashCode(); } protected static class DefaultArgument implements Argument { private static final String VALUE = "value"; private static final String BINDING_MECHANIC = "bindingMechanic"; private final int parameterIndex; protected DefaultArgument(int param4Int) { this.parameterIndex = param4Int; } public int value() { return this.parameterIndex; } public Argument.BindingMechanic bindingMechanic() { return Argument.BindingMechanic.UNIQUE; } public Class<Argument> annotationType() { return Argument.class; } public int hashCode() { return (127 * "bindingMechanic".hashCode() ^ Argument.BindingMechanic.UNIQUE.hashCode()) + (127 * "value".hashCode() ^ this.parameterIndex); } public boolean equals(@MaybeNull Object param4Object) { return (this == param4Object || (param4Object instanceof Argument && this.parameterIndex == ((Argument)param4Object).value())); } public String toString() { return "@" + Argument.class.getName() + "(bindingMechanic=" + Argument.BindingMechanic.UNIQUE + ", value=" + this.parameterIndex + ")"; } } } @Enhance public static class Bound<T extends Annotation> implements Handler { public MethodDelegationBinder.ParameterBinding<?> bind(MethodDescription param3MethodDescription, Implementation.Target param3Target, Assigner param3Assigner) { return this.parameterBinder.bind(this.annotation, param3MethodDescription, this.target, param3Target, param3Assigner, this.typing); }
/*     */ 
/*     */       
/*     */       private final ParameterDescription target;
/*     */       private final TargetMethodAnnotationDrivenBinder.ParameterBinder<T> parameterBinder;
/*     */       private final AnnotationDescription.Loadable<T> annotation;
/*     */       private final Assigner.Typing typing;
/*     */       
/*     */       protected Bound(ParameterDescription param3ParameterDescription, TargetMethodAnnotationDrivenBinder.ParameterBinder<T> param3ParameterBinder, AnnotationDescription.Loadable<T> param3Loadable, Assigner.Typing param3Typing) {
/*     */         this.target = param3ParameterDescription;
/*     */         this.parameterBinder = param3ParameterBinder;
/*     */         this.annotation = param3Loadable;
/*     */         this.typing = param3Typing;
/*     */       }
/*     */       
/*     */       protected static TargetMethodAnnotationDrivenBinder.DelegationProcessor.Handler of(ParameterDescription param3ParameterDescription, TargetMethodAnnotationDrivenBinder.ParameterBinder<?> param3ParameterBinder, AnnotationDescription param3AnnotationDescription, Assigner.Typing param3Typing) {
/*     */         return new Bound(param3ParameterDescription, param3ParameterBinder, param3AnnotationDescription.prepare(param3ParameterBinder.getHandledType()), param3Typing);
/*     */       }
/*     */       
/*     */       public boolean isBound() {
/*     */         return true;
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param3Object) {
/*     */         return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.typing.equals(((Bound)param3Object).typing) ? false : (!this.target.equals(((Bound)param3Object).target) ? false : (!this.parameterBinder.equals(((Bound)param3Object).parameterBinder) ? false : (!!this.annotation.equals(((Bound)param3Object).annotation)))))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return (((getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.parameterBinder.hashCode()) * 31 + this.annotation.hashCode()) * 31 + this.typing.hashCode();
/*     */       } }
/*     */      }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\annotation\TargetMethodAnnotationDrivenBinder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */