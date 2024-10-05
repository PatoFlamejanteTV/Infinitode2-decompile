/*      */ package net.bytebuddy.utility;
/*      */ 
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.Method;
/*      */ import java.security.AccessController;
/*      */ import java.security.PrivilegedAction;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import net.bytebuddy.ClassFileVersion;
/*      */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*      */ import net.bytebuddy.description.enumeration.EnumerationDescription;
/*      */ import net.bytebuddy.description.field.FieldDescription;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.description.type.TypeList;
/*      */ import net.bytebuddy.dynamic.ClassFileLocator;
/*      */ import net.bytebuddy.jar.asm.Type;
/*      */ import net.bytebuddy.pool.TypePool;
/*      */ import net.bytebuddy.utility.dispatcher.JavaDispatcher;
/*      */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Container;
/*      */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Instance;
/*      */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.IsConstructor;
/*      */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.IsStatic;
/*      */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied;
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
/*      */ public interface JavaConstant
/*      */ {
/*      */   Object toDescription();
/*      */   
/*      */   TypeDescription getTypeDescription();
/*      */   
/*      */   <T> T accept(Visitor<T> paramVisitor);
/*      */   
/*      */   public static interface Visitor<T>
/*      */   {
/*      */     T onValue(JavaConstant.Simple<?> param1Simple);
/*      */     
/*      */     T onType(JavaConstant.Simple<TypeDescription> param1Simple);
/*      */     
/*      */     T onMethodType(JavaConstant.MethodType param1MethodType);
/*      */     
/*      */     T onMethodHandle(JavaConstant.MethodHandle param1MethodHandle);
/*      */     
/*      */     T onDynamic(JavaConstant.Dynamic param1Dynamic);
/*      */     
/*      */     public enum NoOp
/*      */       implements Visitor<JavaConstant>
/*      */     {
/*  124 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final JavaConstant onValue(JavaConstant.Simple<?> param2Simple) {
/*  130 */         return param2Simple;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final JavaConstant onType(JavaConstant.Simple<TypeDescription> param2Simple) {
/*  137 */         return param2Simple;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final JavaConstant onMethodType(JavaConstant.MethodType param2MethodType) {
/*  144 */         return param2MethodType;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final JavaConstant onMethodHandle(JavaConstant.MethodHandle param2MethodHandle) {
/*  151 */         return param2MethodHandle;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final JavaConstant onDynamic(JavaConstant.Dynamic param2Dynamic) {
/*  158 */         return param2Dynamic;
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static abstract class Simple<T>
/*      */     implements JavaConstant
/*      */   {
/*  173 */     protected static final Dispatcher CONSTANT_DESC = doPrivileged(JavaDispatcher.of(Dispatcher.class));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  178 */     protected static final Dispatcher.OfClassDesc CLASS_DESC = doPrivileged(JavaDispatcher.of(Dispatcher.OfClassDesc.class));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  183 */     protected static final Dispatcher.OfMethodTypeDesc METHOD_TYPE_DESC = doPrivileged(JavaDispatcher.of(Dispatcher.OfMethodTypeDesc.class));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  188 */     protected static final Dispatcher.OfMethodHandleDesc METHOD_HANDLE_DESC = doPrivileged(JavaDispatcher.of(Dispatcher.OfMethodHandleDesc.class));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  193 */     protected static final Dispatcher.OfDirectMethodHandleDesc DIRECT_METHOD_HANDLE_DESC = doPrivileged(JavaDispatcher.of(Dispatcher.OfDirectMethodHandleDesc.class));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  198 */     protected static final Dispatcher.OfDirectMethodHandleDesc.ForKind DIRECT_METHOD_HANDLE_DESC_KIND = doPrivileged(JavaDispatcher.of(Dispatcher.OfDirectMethodHandleDesc.ForKind.class));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  203 */     protected static final Dispatcher.OfDynamicConstantDesc DYNAMIC_CONSTANT_DESC = doPrivileged(JavaDispatcher.of(Dispatcher.OfDynamicConstantDesc.class)); protected final T value; private final TypeDescription typeDescription; private static final boolean ACCESS_CONTROLLER; static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*      */        }
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
/*      */     protected Simple(T param1T, TypeDescription param1TypeDescription) {
/*  222 */       this.value = param1T;
/*  223 */       this.typeDescription = param1TypeDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     private static <T> T doPrivileged(PrivilegedAction<T> param1PrivilegedAction) {
/*  235 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedAction) : param1PrivilegedAction.run();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static JavaConstant ofLoaded(Object param1Object) {
/*  245 */       if (param1Object instanceof Integer)
/*  246 */         return new OfTrivialValue<Integer>((Integer)param1Object, TypeDescription.ForLoadedType.of(int.class)); 
/*  247 */       if (param1Object instanceof Long)
/*  248 */         return new OfTrivialValue<Long>((Long)param1Object, TypeDescription.ForLoadedType.of(long.class)); 
/*  249 */       if (param1Object instanceof Float)
/*  250 */         return new OfTrivialValue<Float>((Float)param1Object, TypeDescription.ForLoadedType.of(float.class)); 
/*  251 */       if (param1Object instanceof Double)
/*  252 */         return new OfTrivialValue<Double>((Double)param1Object, TypeDescription.ForLoadedType.of(double.class)); 
/*  253 */       if (param1Object instanceof String)
/*  254 */         return new OfTrivialValue<String>((String)param1Object, TypeDescription.ForLoadedType.of(String.class)); 
/*  255 */       if (param1Object instanceof Class)
/*  256 */         return of(TypeDescription.ForLoadedType.of((Class)param1Object)); 
/*  257 */       if (JavaType.METHOD_HANDLE.isInstance(param1Object))
/*  258 */         return JavaConstant.MethodHandle.ofLoaded(param1Object); 
/*  259 */       if (JavaType.METHOD_TYPE.isInstance(param1Object)) {
/*  260 */         return JavaConstant.MethodType.ofLoaded(param1Object);
/*      */       }
/*  262 */       throw new IllegalArgumentException("Not a loaded Java constant value: " + param1Object);
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
/*      */     public static JavaConstant ofDescription(Object param1Object, @MaybeNull ClassLoader param1ClassLoader) {
/*  274 */       return ofDescription(param1Object, ClassFileLocator.ForClassLoader.of(param1ClassLoader));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static JavaConstant ofDescription(Object param1Object, ClassFileLocator param1ClassFileLocator) {
/*  285 */       return ofDescription(param1Object, TypePool.Default.WithLazyResolution.of(param1ClassFileLocator));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static JavaConstant ofDescription(Object param1Object, TypePool param1TypePool) {
/*  296 */       if (param1Object instanceof Integer)
/*  297 */         return new OfTrivialValue<Integer>((Integer)param1Object, TypeDescription.ForLoadedType.of(int.class)); 
/*  298 */       if (param1Object instanceof Long)
/*  299 */         return new OfTrivialValue<Long>((Long)param1Object, TypeDescription.ForLoadedType.of(long.class)); 
/*  300 */       if (param1Object instanceof Float)
/*  301 */         return new OfTrivialValue<Float>((Float)param1Object, TypeDescription.ForLoadedType.of(float.class)); 
/*  302 */       if (param1Object instanceof Double)
/*  303 */         return new OfTrivialValue<Double>((Double)param1Object, TypeDescription.ForLoadedType.of(double.class)); 
/*  304 */       if (param1Object instanceof String)
/*  305 */         return new OfTrivialValue<String>((String)param1Object, TypeDescription.ForLoadedType.of(String.class)); 
/*  306 */       if (CLASS_DESC.isInstance(param1Object)) {
/*  307 */         Type type = Type.getType(CLASS_DESC.descriptorString(param1Object));
/*  308 */         return OfTypeDescription.of(param1TypePool.describe((type.getSort() == 9) ? type
/*  309 */               .getInternalName().replace('/', '.') : type
/*  310 */               .getClassName()).resolve());
/*  311 */       }  if (METHOD_TYPE_DESC.isInstance(param1Object)) {
/*  312 */         Object[] arrayOfObject1 = METHOD_TYPE_DESC.parameterArray(param1Object);
/*  313 */         ArrayList<TypeDescription> arrayList = new ArrayList(arrayOfObject1.length); Object[] arrayOfObject2; int i; byte b;
/*  314 */         for (i = (arrayOfObject2 = arrayOfObject1).length, b = 0; b < i; ) { Object object = arrayOfObject2[b];
/*  315 */           Type type1 = Type.getType(CLASS_DESC.descriptorString(object));
/*  316 */           arrayList.add(param1TypePool.describe((type1.getSort() == 9) ? type1
/*  317 */                 .getInternalName().replace('/', '.') : type1
/*  318 */                 .getClassName()).resolve()); b++; }
/*      */         
/*  320 */         Type type = Type.getType(CLASS_DESC.descriptorString(METHOD_TYPE_DESC.returnType(param1Object)));
/*  321 */         return JavaConstant.MethodType.of(param1TypePool.describe((type.getSort() == 9) ? type
/*  322 */               .getInternalName().replace('/', '.') : type
/*  323 */               .getClassName()).resolve(), arrayList);
/*  324 */       }  if (DIRECT_METHOD_HANDLE_DESC.isInstance(param1Object)) {
/*  325 */         Object[] arrayOfObject1 = METHOD_TYPE_DESC.parameterArray(METHOD_HANDLE_DESC.invocationType(param1Object));
/*  326 */         ArrayList<TypeDescription> arrayList = new ArrayList(arrayOfObject1.length); Object[] arrayOfObject2; int i; byte b;
/*  327 */         for (i = (arrayOfObject2 = arrayOfObject1).length, b = 0; b < i; ) { Object object = arrayOfObject2[b];
/*  328 */           Type type1 = Type.getType(CLASS_DESC.descriptorString(object));
/*  329 */           arrayList.add(param1TypePool.describe((type1.getSort() == 9) ? type1
/*  330 */                 .getInternalName().replace('/', '.') : type1
/*  331 */                 .getClassName()).resolve()); b++; }
/*      */         
/*  333 */         Type type = Type.getType(CLASS_DESC.descriptorString(METHOD_TYPE_DESC.returnType(METHOD_HANDLE_DESC.invocationType(param1Object))));
/*  334 */         return new JavaConstant.MethodHandle(JavaConstant.MethodHandle.HandleType.of(DIRECT_METHOD_HANDLE_DESC.refKind(param1Object)), param1TypePool
/*  335 */             .describe(Type.getType(CLASS_DESC.descriptorString(DIRECT_METHOD_HANDLE_DESC.owner(param1Object))).getClassName()).resolve(), DIRECT_METHOD_HANDLE_DESC
/*  336 */             .methodName(param1Object), 
/*  337 */             (DIRECT_METHOD_HANDLE_DESC.refKind(param1Object) == 8) ? 
/*  338 */             TypeDescription.ForLoadedType.of(void.class) : param1TypePool
/*  339 */             .describe((type.getSort() == 9) ? type.getInternalName().replace('/', '.') : type.getClassName()).resolve(), arrayList);
/*      */       } 
/*  341 */       if (DYNAMIC_CONSTANT_DESC.isInstance(param1Object)) {
/*  342 */         Type type1 = Type.getMethodType(DIRECT_METHOD_HANDLE_DESC.lookupDescriptor(DYNAMIC_CONSTANT_DESC.bootstrapMethod(param1Object)));
/*  343 */         ArrayList<TypeDescription> arrayList = new ArrayList((type1.getArgumentTypes()).length); Type[] arrayOfType; int i; byte b1;
/*  344 */         for (i = (arrayOfType = type1.getArgumentTypes()).length, b1 = 0; b1 < i; ) { Type type = arrayOfType[b1];
/*  345 */           arrayList.add(param1TypePool.describe((type.getSort() == 9) ? type
/*  346 */                 .getInternalName().replace('/', '.') : type
/*  347 */                 .getClassName()).resolve()); b1++; }
/*      */         
/*  349 */         Object[] arrayOfObject1 = DYNAMIC_CONSTANT_DESC.bootstrapArgs(param1Object);
/*  350 */         ArrayList<JavaConstant> arrayList1 = new ArrayList(arrayOfObject1.length); Object[] arrayOfObject2; int j; byte b2;
/*  351 */         for (j = (arrayOfObject2 = arrayOfObject1).length, b2 = 0; b2 < j; ) { Object object = arrayOfObject2[b2];
/*  352 */           arrayList1.add(ofDescription(object, param1TypePool)); b2++; }
/*      */         
/*  354 */         Type type2 = Type.getType(CLASS_DESC.descriptorString(DYNAMIC_CONSTANT_DESC.constantType(param1Object)));
/*  355 */         return new JavaConstant.Dynamic(DYNAMIC_CONSTANT_DESC.constantName(param1Object), param1TypePool
/*  356 */             .describe((type2.getSort() == 9) ? type2
/*  357 */               .getInternalName().replace('/', '.') : type2
/*  358 */               .getClassName()).resolve(), new JavaConstant.MethodHandle(
/*  359 */               JavaConstant.MethodHandle.HandleType.of(DIRECT_METHOD_HANDLE_DESC.refKind(DYNAMIC_CONSTANT_DESC.bootstrapMethod(param1Object))), param1TypePool
/*  360 */               .describe(Type.getType(CLASS_DESC.descriptorString(DIRECT_METHOD_HANDLE_DESC.owner(DYNAMIC_CONSTANT_DESC.bootstrapMethod(param1Object)))).getClassName()).resolve(), DIRECT_METHOD_HANDLE_DESC
/*  361 */               .methodName(DYNAMIC_CONSTANT_DESC.bootstrapMethod(param1Object)), param1TypePool
/*  362 */               .describe((type1.getReturnType().getSort() == 9) ? type1
/*  363 */                 .getReturnType().getInternalName().replace('/', '.') : type1
/*  364 */                 .getReturnType().getClassName()).resolve(), arrayList), arrayList1);
/*      */       } 
/*      */ 
/*      */       
/*  368 */       throw new IllegalArgumentException("Not a resolvable constant description or not expressible as a constant pool value: " + param1Object);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static JavaConstant of(TypeDescription param1TypeDescription) {
/*  379 */       if (param1TypeDescription.isPrimitive()) {
/*  380 */         throw new IllegalArgumentException("A primitive type cannot be represented as a type constant: " + param1TypeDescription);
/*      */       }
/*  382 */       return new OfTypeDescription(param1TypeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static JavaConstant wrap(Object param1Object) {
/*  392 */       if (param1Object instanceof JavaConstant)
/*  393 */         return (JavaConstant)param1Object; 
/*  394 */       if (param1Object instanceof TypeDescription) {
/*  395 */         return of((TypeDescription)param1Object);
/*      */       }
/*  397 */       return ofLoaded(param1Object);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static List<JavaConstant> wrap(List<?> param1List) {
/*  408 */       ArrayList<JavaConstant> arrayList = new ArrayList(param1List.size());
/*  409 */       for (Object object : param1List) {
/*  410 */         arrayList.add(wrap(object));
/*      */       }
/*  412 */       return arrayList;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public T getValue() {
/*  421 */       return this.value;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription getTypeDescription() {
/*  428 */       return this.typeDescription;
/*      */     } @Proxied("java.lang.constant.DynamicConstantDesc") public static interface OfDynamicConstantDesc extends Dispatcher { @IsStatic @Proxied("ofCanonical") Object ofCanonical(@Proxied("java.lang.constant.DirectMethodHandleDesc") Object param2Object1, String param2String, @Proxied("java.lang.constant.ClassDesc") Object param2Object2, @Proxied("java.lang.constant.ConstantDesc") Object[] param2ArrayOfObject); @Proxied("bootstrapArgs")
/*      */       Object[] bootstrapArgs(Object param2Object); @Proxied("constantName")
/*      */       String constantName(Object param2Object); @Proxied("constantType")
/*      */       Object constantType(Object param2Object); @Proxied("bootstrapMethod")
/*  433 */       Object bootstrapMethod(Object param2Object); } public int hashCode() { return this.value.hashCode(); }
/*      */     @Proxied("java.lang.constant.DirectMethodHandleDesc$Kind")
/*      */     public static interface ForKind {
/*      */       @IsStatic
/*      */       @Proxied("valueOf")
/*  438 */       Object valueOf(int param2Int, boolean param2Boolean); } public boolean equals(@MaybeNull Object param1Object) { if (this == param1Object) return true; 
/*  439 */       if (param1Object == null || getClass() != param1Object.getClass()) return false; 
/*  440 */       return this.value.equals(((Simple)param1Object).value); } @Proxied("java.lang.constant.DirectMethodHandleDesc") public static interface OfDirectMethodHandleDesc extends Dispatcher {
/*      */       @Proxied("refKind") int refKind(Object param2Object); @Proxied("methodName") String methodName(Object param2Object); @Proxied("owner") Object owner(Object param2Object); @Proxied("lookupDescriptor") String lookupDescriptor(Object param2Object); @Proxied("java.lang.constant.DirectMethodHandleDesc$Kind") public static interface ForKind {
/*      */         @IsStatic @Proxied("valueOf") Object valueOf(int param4Int, boolean param4Boolean); } } @Proxied("java.lang.constant.MethodHandleDesc") public static interface OfMethodHandleDesc extends Dispatcher {
/*      */       @IsStatic @Proxied("of") Object of(@Proxied("java.lang.constant.DirectMethodHandleDesc$Kind") Object param2Object1, @Proxied("java.lang.constant.ClassDesc") Object param2Object2, String param2String1, String param2String2); @Proxied("invocationType") Object invocationType(Object param2Object); } @Proxied("java.lang.constant.MethodTypeDesc") public static interface OfMethodTypeDesc extends Dispatcher {
/*      */       @IsStatic @Proxied("of") Object of(@Proxied("java.lang.constant.ClassDesc") Object param2Object, @Proxied("java.lang.constant.ClassDesc") Object[] param2ArrayOfObject); @IsStatic @Proxied("ofDescriptor") Object ofDescriptor(String param2String); @Proxied("returnType") Object returnType(Object param2Object); @Proxied("parameterArray")
/*  445 */       Object[] parameterArray(Object param2Object); } public String toString() { return this.value.toString(); }
/*      */ 
/*      */     
/*      */     @Proxied("java.lang.constant.ClassDesc")
/*      */     public static interface OfClassDesc
/*      */       extends Dispatcher {
/*      */       @IsStatic
/*      */       @Proxied("ofDescriptor")
/*      */       Object ofDescriptor(String param2String);
/*      */       
/*      */       @Proxied("descriptorString")
/*      */       String descriptorString(Object param2Object);
/*      */     }
/*      */     
/*      */     protected static class OfTrivialValue<S>
/*      */       extends Simple<S> {
/*      */       protected OfTrivialValue(S param2S, TypeDescription param2TypeDescription) {
/*  462 */         super(param2S, param2TypeDescription);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Object toDescription() {
/*  469 */         return this.value;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public <T> T accept(JavaConstant.Visitor<T> param2Visitor) {
/*  476 */         return param2Visitor.onValue(this);
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
/*      */     protected static class OfTypeDescription
/*      */       extends Simple<TypeDescription>
/*      */     {
/*      */       protected OfTypeDescription(TypeDescription param2TypeDescription) {
/*  491 */         super(param2TypeDescription, TypeDescription.ForLoadedType.of(Class.class));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Object toDescription() {
/*  498 */         return CLASS_DESC.ofDescriptor(this.value.getDescriptor());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public <T> T accept(JavaConstant.Visitor<T> param2Visitor) {
/*  505 */         return param2Visitor.onType(this);
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
/*      */     @Proxied("java.lang.constant.ConstantDesc")
/*      */     protected static interface Dispatcher
/*      */     {
/*      */       @Instance
/*      */       @Proxied("isInstance")
/*      */       boolean isInstance(Object param2Object);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Container
/*      */       @Proxied("toArray")
/*      */       Object[] toArray(int param2Int);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Proxied("java.lang.constant.DynamicConstantDesc")
/*      */       public static interface OfDynamicConstantDesc
/*      */         extends Dispatcher
/*      */       {
/*      */         @IsStatic
/*      */         @Proxied("ofCanonical")
/*      */         Object ofCanonical(@Proxied("java.lang.constant.DirectMethodHandleDesc") Object param3Object1, String param3String, @Proxied("java.lang.constant.ClassDesc") Object param3Object2, @Proxied("java.lang.constant.ConstantDesc") Object[] param3ArrayOfObject);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Proxied("bootstrapArgs")
/*      */         Object[] bootstrapArgs(Object param3Object);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Proxied("constantName")
/*      */         String constantName(Object param3Object);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Proxied("constantType")
/*      */         Object constantType(Object param3Object);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Proxied("bootstrapMethod")
/*      */         Object bootstrapMethod(Object param3Object);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Proxied("java.lang.constant.DirectMethodHandleDesc")
/*      */       public static interface OfDirectMethodHandleDesc
/*      */         extends Dispatcher
/*      */       {
/*      */         @Proxied("refKind")
/*      */         int refKind(Object param3Object);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Proxied("methodName")
/*      */         String methodName(Object param3Object);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Proxied("owner")
/*      */         Object owner(Object param3Object);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Proxied("lookupDescriptor")
/*      */         String lookupDescriptor(Object param3Object);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Proxied("java.lang.constant.DirectMethodHandleDesc$Kind")
/*      */         public static interface ForKind
/*      */         {
/*      */           @IsStatic
/*      */           @Proxied("valueOf")
/*      */           Object valueOf(int param4Int, boolean param4Boolean);
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Proxied("java.lang.constant.MethodHandleDesc")
/*      */       public static interface OfMethodHandleDesc
/*      */         extends Dispatcher
/*      */       {
/*      */         @IsStatic
/*      */         @Proxied("of")
/*      */         Object of(@Proxied("java.lang.constant.DirectMethodHandleDesc$Kind") Object param3Object1, @Proxied("java.lang.constant.ClassDesc") Object param3Object2, String param3String1, String param3String2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Proxied("invocationType")
/*      */         Object invocationType(Object param3Object);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Proxied("java.lang.constant.MethodTypeDesc")
/*      */       public static interface OfMethodTypeDesc
/*      */         extends Dispatcher
/*      */       {
/*      */         @IsStatic
/*      */         @Proxied("of")
/*      */         Object of(@Proxied("java.lang.constant.ClassDesc") Object param3Object, @Proxied("java.lang.constant.ClassDesc") Object[] param3ArrayOfObject);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @IsStatic
/*      */         @Proxied("ofDescriptor")
/*      */         Object ofDescriptor(String param3String);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Proxied("returnType")
/*      */         Object returnType(Object param3Object);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Proxied("parameterArray")
/*      */         Object[] parameterArray(Object param3Object);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Proxied("java.lang.constant.ClassDesc")
/*      */       public static interface OfClassDesc
/*      */         extends Dispatcher
/*      */       {
/*      */         @IsStatic
/*      */         @Proxied("ofDescriptor")
/*      */         Object ofDescriptor(String param3String);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Proxied("descriptorString")
/*      */         String descriptorString(Object param3Object);
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class MethodType
/*      */     implements JavaConstant
/*      */   {
/*  752 */     private static final Dispatcher DISPATCHER = doPrivileged(JavaDispatcher.of(Dispatcher.class)); private final TypeDescription returnType; private final List<? extends TypeDescription> parameterTypes; private static final boolean ACCESS_CONTROLLER; static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*      */        }
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
/*      */     protected MethodType(TypeDescription param1TypeDescription, List<? extends TypeDescription> param1List) {
/*  771 */       this.returnType = param1TypeDescription;
/*  772 */       this.parameterTypes = param1List;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     private static <T> T doPrivileged(PrivilegedAction<T> param1PrivilegedAction) {
/*  784 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedAction) : param1PrivilegedAction.run();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodType ofLoaded(Object param1Object) {
/*  794 */       if (!JavaType.METHOD_TYPE.isInstance(param1Object)) {
/*  795 */         throw new IllegalArgumentException("Expected method type object: " + param1Object);
/*      */       }
/*  797 */       return of(DISPATCHER.returnType(param1Object), DISPATCHER.parameterArray(param1Object));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodType of(Class<?> param1Class, Class<?>... param1VarArgs) {
/*  808 */       return of(TypeDescription.ForLoadedType.of(param1Class), (List<? extends TypeDescription>)new TypeList.ForLoadedTypes(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodType of(TypeDescription param1TypeDescription, TypeDescription... param1VarArgs) {
/*  819 */       return new MethodType(param1TypeDescription, Arrays.asList(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodType of(TypeDescription param1TypeDescription, List<? extends TypeDescription> param1List) {
/*  830 */       return new MethodType(param1TypeDescription, param1List);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodType of(Method param1Method) {
/*  840 */       return of((MethodDescription)new MethodDescription.ForLoadedMethod(param1Method));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodType of(Constructor<?> param1Constructor) {
/*  850 */       return of((MethodDescription)new MethodDescription.ForLoadedConstructor(param1Constructor));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodType of(MethodDescription param1MethodDescription) {
/*  860 */       return new MethodType(param1MethodDescription.getReturnType().asErasure(), (List<? extends TypeDescription>)param1MethodDescription.getParameters().asTypeList().asErasures());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodType ofSetter(Field param1Field) {
/*  870 */       return ofSetter((FieldDescription)new FieldDescription.ForLoadedField(param1Field));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodType ofSetter(FieldDescription param1FieldDescription) {
/*  880 */       return new MethodType(TypeDescription.ForLoadedType.of(void.class), Collections.singletonList(param1FieldDescription.getType().asErasure()));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodType ofGetter(Field param1Field) {
/*  890 */       return ofGetter((FieldDescription)new FieldDescription.ForLoadedField(param1Field));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodType ofGetter(FieldDescription param1FieldDescription) {
/*  900 */       return new MethodType(param1FieldDescription.getType().asErasure(), Collections.emptyList());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodType ofConstant(Object param1Object) {
/*  910 */       return ofConstant(param1Object.getClass());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodType ofConstant(Class<?> param1Class) {
/*  920 */       return ofConstant(TypeDescription.ForLoadedType.of(param1Class));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodType ofConstant(TypeDescription param1TypeDescription) {
/*  930 */       return new MethodType(param1TypeDescription, Collections.emptyList());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription getReturnType() {
/*  939 */       return this.returnType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeList getParameterTypes() {
/*  948 */       return (TypeList)new TypeList.Explicit(this.parameterTypes);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getDescriptor() {
/*  957 */       StringBuilder stringBuilder = new StringBuilder("(");
/*  958 */       for (TypeDescription typeDescription : this.parameterTypes) {
/*  959 */         stringBuilder.append(typeDescription.getDescriptor());
/*      */       }
/*  961 */       return stringBuilder.append(')').append(this.returnType.getDescriptor()).toString();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object toDescription() {
/*  968 */       Object[] arrayOfObject = JavaConstant.Simple.CLASS_DESC.toArray(this.parameterTypes.size());
/*  969 */       for (byte b = 0; b < this.parameterTypes.size(); b++) {
/*  970 */         arrayOfObject[b] = JavaConstant.Simple.CLASS_DESC.ofDescriptor(((TypeDescription)this.parameterTypes.get(b)).getDescriptor());
/*      */       }
/*  972 */       return JavaConstant.Simple.METHOD_TYPE_DESC.of(JavaConstant.Simple.CLASS_DESC.ofDescriptor(this.returnType.getDescriptor()), arrayOfObject);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public <T> T accept(JavaConstant.Visitor<T> param1Visitor) {
/*  979 */       return param1Visitor.onMethodType(this);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription getTypeDescription() {
/*  986 */       return JavaType.METHOD_TYPE.getTypeStub();
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*  991 */       int i = this.returnType.hashCode();
/*      */       
/*  993 */       return i = i * 31 + this.parameterTypes.hashCode();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*  998 */       if (this == param1Object) {
/*  999 */         return true;
/*      */       }
/* 1001 */       if (!(param1Object instanceof MethodType)) {
/* 1002 */         return false;
/*      */       }
/* 1004 */       param1Object = param1Object;
/* 1005 */       return (this.parameterTypes.equals(((MethodType)param1Object).parameterTypes) && this.returnType.equals(((MethodType)param1Object).returnType));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1011 */       StringBuilder stringBuilder = new StringBuilder("(");
/* 1012 */       boolean bool = true;
/* 1013 */       for (TypeDescription typeDescription : this.parameterTypes) {
/* 1014 */         if (bool) {
/* 1015 */           bool = false;
/*      */         } else {
/* 1017 */           stringBuilder.append(',');
/*      */         } 
/* 1019 */         stringBuilder.append(typeDescription.getSimpleName());
/*      */       } 
/* 1021 */       return stringBuilder.append(')').append(this.returnType.getSimpleName()).toString();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Proxied("java.lang.invoke.MethodType")
/*      */     protected static interface Dispatcher
/*      */     {
/*      */       @Proxied("returnType")
/*      */       Class<?> returnType(Object param2Object);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Proxied("parameterArray")
/*      */       Class<?>[] parameterArray(Object param2Object);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class MethodHandle
/*      */     implements JavaConstant
/*      */   {
/* 1058 */     protected static final MethodHandleInfo METHOD_HANDLE_INFO = doPrivileged(JavaDispatcher.of(MethodHandleInfo.class));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1063 */     protected static final MethodType METHOD_TYPE = doPrivileged(JavaDispatcher.of(MethodType.class));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1068 */     protected static final MethodHandles METHOD_HANDLES = doPrivileged(JavaDispatcher.of(MethodHandles.class));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1073 */     protected static final MethodHandles.Lookup METHOD_HANDLES_LOOKUP = doPrivileged(JavaDispatcher.of(MethodHandles.Lookup.class)); private final HandleType handleType; private final TypeDescription ownerType; private final String name; private final TypeDescription returnType; private final List<? extends TypeDescription> parameterTypes; private static final boolean ACCESS_CONTROLLER; static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*      */        }
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
/*      */     protected MethodHandle(HandleType param1HandleType, TypeDescription param1TypeDescription1, String param1String, TypeDescription param1TypeDescription2, List<? extends TypeDescription> param1List) {
/* 1114 */       this.handleType = param1HandleType;
/* 1115 */       this.ownerType = param1TypeDescription1;
/* 1116 */       this.name = param1String;
/* 1117 */       this.returnType = param1TypeDescription2;
/* 1118 */       this.parameterTypes = param1List;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     private static <T> T doPrivileged(PrivilegedAction<T> param1PrivilegedAction) {
/* 1130 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedAction) : param1PrivilegedAction.run();
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
/*      */     public static MethodHandle ofLoaded(Object param1Object) {
/* 1142 */       return ofLoaded(param1Object, METHOD_HANDLES.publicLookup());
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
/*      */     public static MethodHandle ofLoaded(Object param1Object1, Object param1Object2) {
/* 1155 */       if (!JavaType.METHOD_HANDLE.isInstance(param1Object1))
/* 1156 */         throw new IllegalArgumentException("Expected method handle object: " + param1Object1); 
/* 1157 */       if (!JavaType.METHOD_HANDLES_LOOKUP.isInstance(param1Object2)) {
/* 1158 */         throw new IllegalArgumentException("Expected method handle lookup object: " + param1Object2);
/*      */       }
/*      */ 
/*      */       
/* 1162 */       param1Object1 = ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V8).isAtMost(ClassFileVersion.JAVA_V7) ? METHOD_HANDLE_INFO.revealDirect(param1Object1) : METHOD_HANDLES_LOOKUP.revealDirect(param1Object2, param1Object1);
/* 1163 */       param1Object2 = METHOD_HANDLE_INFO.getMethodType(param1Object1);
/* 1164 */       return new MethodHandle(HandleType.of(METHOD_HANDLE_INFO.getReferenceKind(param1Object1)), 
/* 1165 */           TypeDescription.ForLoadedType.of(METHOD_HANDLE_INFO.getDeclaringClass(param1Object1)), METHOD_HANDLE_INFO
/* 1166 */           .getName(param1Object1), 
/* 1167 */           TypeDescription.ForLoadedType.of(METHOD_TYPE.returnType(param1Object2)), (List<? extends TypeDescription>)new TypeList.ForLoadedTypes(METHOD_TYPE
/* 1168 */             .parameterArray(param1Object2)));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodHandle of(Method param1Method) {
/* 1178 */       return of((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(param1Method));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodHandle of(Constructor<?> param1Constructor) {
/* 1188 */       return of((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedConstructor(param1Constructor));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodHandle of(MethodDescription.InDefinedShape param1InDefinedShape) {
/* 1198 */       return new MethodHandle(HandleType.of(param1InDefinedShape), param1InDefinedShape
/* 1199 */           .getDeclaringType().asErasure(), param1InDefinedShape
/* 1200 */           .getInternalName(), param1InDefinedShape
/* 1201 */           .getReturnType().asErasure(), (List<? extends TypeDescription>)param1InDefinedShape
/* 1202 */           .getParameters().asTypeList().asErasures());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodHandle ofSpecial(Method param1Method, Class<?> param1Class) {
/* 1213 */       return ofSpecial((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(param1Method), TypeDescription.ForLoadedType.of(param1Class));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodHandle ofSpecial(MethodDescription.InDefinedShape param1InDefinedShape, TypeDescription param1TypeDescription) {
/* 1224 */       if (!param1InDefinedShape.isSpecializableFor(param1TypeDescription)) {
/* 1225 */         throw new IllegalArgumentException("Cannot specialize " + param1InDefinedShape + " for " + param1TypeDescription);
/*      */       }
/* 1227 */       return new MethodHandle(HandleType.ofSpecial(param1InDefinedShape), param1TypeDescription, param1InDefinedShape
/*      */           
/* 1229 */           .getInternalName(), param1InDefinedShape
/* 1230 */           .getReturnType().asErasure(), (List<? extends TypeDescription>)param1InDefinedShape
/* 1231 */           .getParameters().asTypeList().asErasures());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodHandle ofGetter(Field param1Field) {
/* 1241 */       return ofGetter((FieldDescription.InDefinedShape)new FieldDescription.ForLoadedField(param1Field));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodHandle ofGetter(FieldDescription.InDefinedShape param1InDefinedShape) {
/* 1251 */       return new MethodHandle(HandleType.ofGetter(param1InDefinedShape), param1InDefinedShape
/* 1252 */           .getDeclaringType().asErasure(), param1InDefinedShape
/* 1253 */           .getInternalName(), param1InDefinedShape
/* 1254 */           .getType().asErasure(), 
/* 1255 */           Collections.emptyList());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodHandle ofSetter(Field param1Field) {
/* 1265 */       return ofSetter((FieldDescription.InDefinedShape)new FieldDescription.ForLoadedField(param1Field));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static MethodHandle ofSetter(FieldDescription.InDefinedShape param1InDefinedShape) {
/* 1275 */       return new MethodHandle(HandleType.ofSetter(param1InDefinedShape), param1InDefinedShape
/* 1276 */           .getDeclaringType().asErasure(), param1InDefinedShape
/* 1277 */           .getInternalName(), 
/* 1278 */           TypeDescription.ForLoadedType.of(void.class), 
/* 1279 */           Collections.singletonList(param1InDefinedShape.getType().asErasure()));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Class<?> lookupType(Object param1Object) {
/* 1289 */       return METHOD_HANDLES_LOOKUP.lookupClass(param1Object);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object toDescription() {
/* 1296 */       return JavaConstant.Simple.METHOD_HANDLE_DESC.of(JavaConstant.Simple.DIRECT_METHOD_HANDLE_DESC_KIND.valueOf(this.handleType.getIdentifier(), this.ownerType.isInterface()), JavaConstant.Simple.CLASS_DESC
/* 1297 */           .ofDescriptor(this.ownerType.getDescriptor()), this.name, 
/*      */           
/* 1299 */           getDescriptor());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public <T> T accept(JavaConstant.Visitor<T> param1Visitor) {
/* 1306 */       return param1Visitor.onMethodHandle(this);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription getTypeDescription() {
/* 1313 */       return JavaType.METHOD_HANDLE.getTypeStub();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public HandleType getHandleType() {
/* 1322 */       return this.handleType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription getOwnerType() {
/* 1331 */       return this.ownerType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getName() {
/* 1340 */       return this.name;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription getReturnType() {
/* 1349 */       return this.returnType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeList getParameterTypes() {
/* 1358 */       return (TypeList)new TypeList.Explicit(this.parameterTypes);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getDescriptor() {
/* 1367 */       switch (JavaConstant.null.a[this.handleType.ordinal()]) {
/*      */         case 1:
/*      */         case 2:
/* 1370 */           return this.returnType.getDescriptor();
/*      */         case 3:
/*      */         case 4:
/* 1373 */           return ((TypeDescription)this.parameterTypes.get(0)).getDescriptor();
/*      */       } 
/* 1375 */       StringBuilder stringBuilder = new StringBuilder("(");
/* 1376 */       for (TypeDescription typeDescription : this.parameterTypes) {
/* 1377 */         stringBuilder.append(typeDescription.getDescriptor());
/*      */       }
/* 1379 */       return stringBuilder.append(')').append(this.returnType.getDescriptor()).toString();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/* 1385 */       int i = this.handleType.hashCode();
/* 1386 */       i = i * 31 + this.ownerType.hashCode();
/* 1387 */       i = i * 31 + this.name.hashCode();
/* 1388 */       i = i * 31 + this.returnType.hashCode();
/*      */       
/* 1390 */       return i = i * 31 + this.parameterTypes.hashCode();
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object)
/*      */     {
/* 1395 */       if (this == param1Object)
/* 1396 */         return true; 
/* 1397 */       if (!(param1Object instanceof MethodHandle)) {
/* 1398 */         return false;
/*      */       }
/* 1400 */       param1Object = param1Object;
/* 1401 */       if (this.handleType == ((MethodHandle)param1Object).handleType && this.name
/* 1402 */         .equals(((MethodHandle)param1Object).name) && this.ownerType
/* 1403 */         .equals(((MethodHandle)param1Object).ownerType) && this.parameterTypes
/* 1404 */         .equals(((MethodHandle)param1Object).parameterTypes) && this.returnType
/* 1405 */         .equals(((MethodHandle)param1Object).returnType)) return true; 
/*      */       return false; } @Proxied("java.lang.invoke.MethodHandles")
/*      */     protected static interface MethodHandles {
/*      */       @IsStatic
/*      */       @Proxied("publicLookup")
/*      */       Object publicLookup(); @Proxied("java.lang.invoke.MethodHandles$Lookup")
/*      */       public static interface Lookup {
/*      */         @Proxied("lookupClass")
/*      */         Class<?> lookupClass(Object param3Object); @Proxied("revealDirect")
/*      */         Object revealDirect(Object param3Object1, @Proxied("java.lang.invoke.MethodHandle") Object param3Object2); } } @Proxied("java.lang.invoke.MethodType")
/*      */     protected static interface MethodType {
/*      */       @Proxied("returnType")
/*      */       Class<?> returnType(Object param2Object); @Proxied("parameterArray")
/*      */       Class<?>[] parameterArray(Object param2Object); } public String toString() {
/* 1419 */       StringBuilder stringBuilder = (new StringBuilder()).append(this.handleType.name()).append((this.ownerType.isInterface() && !this.handleType.isField() && this.handleType != HandleType.INVOKE_INTERFACE) ? "@interface" : "").append('/').append(this.ownerType.getSimpleName()).append("::").append(this.name).append('(');
/* 1420 */       boolean bool = true;
/* 1421 */       for (TypeDescription typeDescription : this.parameterTypes) {
/* 1422 */         if (bool) {
/* 1423 */           bool = false;
/*      */         } else {
/* 1425 */           stringBuilder.append(',');
/*      */         } 
/* 1427 */         stringBuilder.append(typeDescription.getSimpleName());
/*      */       } 
/* 1429 */       return stringBuilder.append(')').append(this.returnType.getSimpleName()).toString();
/*      */     } @Proxied("java.lang.invoke.MethodHandleInfo")
/*      */     protected static interface MethodHandleInfo {
/*      */       @Proxied("getName")
/*      */       String getName(Object param2Object); @Proxied("getDeclaringClass")
/*      */       Class<?> getDeclaringClass(Object param2Object); @Proxied("getReferenceKind")
/*      */       int getReferenceKind(Object param2Object); @Proxied("getMethodType")
/*      */       Object getMethodType(Object param2Object);
/*      */       @IsConstructor
/*      */       @Proxied("revealDirect")
/*      */       Object revealDirect(@Proxied("java.lang.invoke.MethodHandle") Object param2Object); }
/* 1440 */     public enum HandleType { INVOKE_VIRTUAL(5, false),
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1445 */       INVOKE_STATIC(6, false),
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1450 */       INVOKE_SPECIAL(7, false),
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1455 */       INVOKE_INTERFACE(9, false),
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1460 */       INVOKE_SPECIAL_CONSTRUCTOR(8, false),
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1465 */       PUT_FIELD(3, true),
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1470 */       GET_FIELD(1, true),
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1475 */       PUT_STATIC_FIELD(4, true),
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1480 */       GET_STATIC_FIELD(2, true);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final int identifier;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final boolean field;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       HandleType(int param2Int1, boolean param2Boolean) {
/* 1499 */         this.identifier = param2Int1;
/* 1500 */         this.field = param2Boolean;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static HandleType of(MethodDescription.InDefinedShape param2InDefinedShape) {
/* 1510 */         if (param2InDefinedShape.isTypeInitializer())
/* 1511 */           throw new IllegalArgumentException("Cannot create handle of type initializer " + param2InDefinedShape); 
/* 1512 */         if (param2InDefinedShape.isStatic())
/* 1513 */           return INVOKE_STATIC; 
/* 1514 */         if (param2InDefinedShape.isConstructor())
/* 1515 */           return INVOKE_SPECIAL_CONSTRUCTOR; 
/* 1516 */         if (param2InDefinedShape.isPrivate())
/* 1517 */           return INVOKE_SPECIAL; 
/* 1518 */         if (param2InDefinedShape.getDeclaringType().isInterface()) {
/* 1519 */           return INVOKE_INTERFACE;
/*      */         }
/* 1521 */         return INVOKE_VIRTUAL;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static HandleType of(int param2Int) {
/*      */         HandleType[] arrayOfHandleType;
/*      */         int i;
/*      */         byte b;
/* 1532 */         for (i = (arrayOfHandleType = values()).length, b = 0; b < i; b++) {
/* 1533 */           HandleType handleType; if ((handleType = arrayOfHandleType[b]).getIdentifier() == param2Int) {
/* 1534 */             return handleType;
/*      */           }
/*      */         } 
/* 1537 */         throw new IllegalArgumentException("Unknown handle type: " + param2Int);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static HandleType ofSpecial(MethodDescription.InDefinedShape param2InDefinedShape) {
/* 1547 */         if (param2InDefinedShape.isStatic() || param2InDefinedShape.isAbstract()) {
/* 1548 */           throw new IllegalArgumentException("Cannot invoke " + param2InDefinedShape + " via invokespecial");
/*      */         }
/* 1550 */         return param2InDefinedShape.isConstructor() ? INVOKE_SPECIAL_CONSTRUCTOR : INVOKE_SPECIAL;
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
/*      */       protected static HandleType ofGetter(FieldDescription.InDefinedShape param2InDefinedShape) {
/* 1562 */         return param2InDefinedShape.isStatic() ? GET_STATIC_FIELD : GET_FIELD;
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
/*      */       protected static HandleType ofSetter(FieldDescription.InDefinedShape param2InDefinedShape) {
/* 1574 */         return param2InDefinedShape.isStatic() ? PUT_STATIC_FIELD : PUT_FIELD;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final int getIdentifier() {
/* 1585 */         return this.identifier;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final boolean isField() {
/* 1594 */         return this.field;
/*      */       } }
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
/*      */     @Proxied("java.lang.invoke.MethodHandles$Lookup")
/*      */     public static interface Lookup
/*      */     {
/*      */       @Proxied("lookupClass")
/*      */       Class<?> lookupClass(Object param2Object);
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
/*      */       @Proxied("revealDirect")
/*      */       Object revealDirect(Object param2Object1, @Proxied("java.lang.invoke.MethodHandle") Object param2Object2);
/*      */     }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Dynamic
/*      */     implements JavaConstant
/*      */   {
/*      */     public static final String DEFAULT_NAME = "_";
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
/*      */     private final String name;
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
/*      */     private final TypeDescription typeDescription;
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
/*      */     private final JavaConstant.MethodHandle bootstrap;
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
/*      */     private final List<JavaConstant> arguments;
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
/*      */     protected Dynamic(String param1String, TypeDescription param1TypeDescription, JavaConstant.MethodHandle param1MethodHandle, List<JavaConstant> param1List) {
/* 1749 */       this.name = param1String;
/* 1750 */       this.typeDescription = param1TypeDescription;
/* 1751 */       this.bootstrap = param1MethodHandle;
/* 1752 */       this.arguments = param1List;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Dynamic ofNullConstant() {
/* 1761 */       return new Dynamic("_", 
/* 1762 */           TypeDescription.ForLoadedType.of(Object.class), new JavaConstant.MethodHandle(JavaConstant.MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS
/*      */             
/* 1764 */             .getTypeStub(), "nullConstant", 
/*      */             
/* 1766 */             TypeDescription.ForLoadedType.of(Object.class), 
/* 1767 */             Arrays.asList(new TypeDescription[] { JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.ForLoadedType.of(String.class), TypeDescription.ForLoadedType.of(Class.class)
/* 1768 */               })), Collections.emptyList());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static JavaConstant ofPrimitiveType(Class<?> param1Class) {
/* 1778 */       return ofPrimitiveType(TypeDescription.ForLoadedType.of(param1Class));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static JavaConstant ofPrimitiveType(TypeDescription param1TypeDescription) {
/* 1788 */       if (!param1TypeDescription.isPrimitive()) {
/* 1789 */         throw new IllegalArgumentException("Not a primitive type: " + param1TypeDescription);
/*      */       }
/* 1791 */       return new Dynamic(param1TypeDescription.getDescriptor(), 
/* 1792 */           TypeDescription.ForLoadedType.of(Class.class), new JavaConstant.MethodHandle(JavaConstant.MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS
/*      */             
/* 1794 */             .getTypeStub(), "primitiveClass", 
/*      */             
/* 1796 */             TypeDescription.ForLoadedType.of(Class.class), 
/* 1797 */             Arrays.asList(new TypeDescription[] { JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.ForLoadedType.of(String.class), TypeDescription.ForLoadedType.of(Class.class)
/* 1798 */               })), Collections.emptyList());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static JavaConstant ofEnumeration(Enum<?> param1Enum) {
/* 1808 */       return ofEnumeration((EnumerationDescription)new EnumerationDescription.ForLoadedEnumeration(param1Enum));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static JavaConstant ofEnumeration(EnumerationDescription param1EnumerationDescription) {
/* 1818 */       return new Dynamic(param1EnumerationDescription.getValue(), param1EnumerationDescription
/* 1819 */           .getEnumerationType(), new JavaConstant.MethodHandle(JavaConstant.MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS
/*      */             
/* 1821 */             .getTypeStub(), "enumConstant", 
/*      */             
/* 1823 */             TypeDescription.ForLoadedType.of(Enum.class), 
/* 1824 */             Arrays.asList(new TypeDescription[] { JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.ForLoadedType.of(String.class), TypeDescription.ForLoadedType.of(Class.class)
/* 1825 */               })), Collections.emptyList());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Dynamic ofField(Field param1Field) {
/* 1835 */       return ofField((FieldDescription.InDefinedShape)new FieldDescription.ForLoadedField(param1Field));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Dynamic ofField(FieldDescription.InDefinedShape param1InDefinedShape) {
/* 1845 */       if (!param1InDefinedShape.isStatic() || !param1InDefinedShape.isFinal()) {
/* 1846 */         throw new IllegalArgumentException("Field must be static and final: " + param1InDefinedShape);
/*      */       }
/*      */ 
/*      */       
/* 1850 */       boolean bool = param1InDefinedShape.getType().isPrimitive() ? param1InDefinedShape.getType().asErasure().asBoxed().equals(param1InDefinedShape.getType().asErasure()) : param1InDefinedShape.getDeclaringType().equals(param1InDefinedShape.getType().asErasure());
/* 1851 */       return new Dynamic(param1InDefinedShape.getInternalName(), param1InDefinedShape
/* 1852 */           .getType().asErasure(), new JavaConstant.MethodHandle(JavaConstant.MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS
/*      */             
/* 1854 */             .getTypeStub(), "getStaticFinal", 
/*      */             
/* 1856 */             TypeDescription.ForLoadedType.of(Object.class), bool ? 
/*      */             
/* 1858 */             Arrays.<TypeDescription>asList(new TypeDescription[] { JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.ForLoadedType.of(String.class), TypeDescription.ForLoadedType.of(Class.class)
/* 1859 */               }) : Arrays.<TypeDescription>asList(new TypeDescription[] { JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.ForLoadedType.of(String.class), TypeDescription.ForLoadedType.of(Class.class), TypeDescription.ForLoadedType.of(Class.class) })), bool ? 
/*      */           
/* 1861 */           Collections.<JavaConstant>emptyList() : 
/* 1862 */           Collections.<JavaConstant>singletonList(JavaConstant.Simple.of(param1InDefinedShape.getDeclaringType())));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Dynamic ofInvocation(Method param1Method, Object... param1VarArgs) {
/* 1873 */       return ofInvocation(param1Method, Arrays.asList(param1VarArgs));
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
/*      */     public static Dynamic ofInvocation(Method param1Method, List<?> param1List) {
/* 1886 */       return ofInvocation((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(param1Method), param1List);
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
/*      */     public static Dynamic ofInvocation(Constructor<?> param1Constructor, Object... param1VarArgs) {
/* 1899 */       return ofInvocation(param1Constructor, Arrays.asList(param1VarArgs));
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
/*      */     public static Dynamic ofInvocation(Constructor<?> param1Constructor, List<?> param1List) {
/* 1912 */       return ofInvocation((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedConstructor(param1Constructor), param1List);
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
/*      */     public static Dynamic ofInvocation(MethodDescription.InDefinedShape param1InDefinedShape, Object... param1VarArgs) {
/* 1925 */       return ofInvocation(param1InDefinedShape, Arrays.asList(param1VarArgs));
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
/*      */     public static Dynamic ofInvocation(MethodDescription.InDefinedShape param1InDefinedShape, List<?> param1List) {
/*      */       Iterator<TypeDescription> iterator;
/* 1938 */       if (!param1InDefinedShape.isConstructor() && param1InDefinedShape.getReturnType().represents(void.class))
/* 1939 */         throw new IllegalArgumentException("Bootstrap method is no constructor or non-void static factory: " + param1InDefinedShape); 
/* 1940 */       if (param1InDefinedShape.isVarArgs() ? (param1InDefinedShape
/* 1941 */         .getParameters().size() + ((param1InDefinedShape.isStatic() || param1InDefinedShape.isConstructor()) ? 0 : 1) > param1List.size() + 1) : (param1InDefinedShape
/* 1942 */         .getParameters().size() + ((param1InDefinedShape.isStatic() || param1InDefinedShape.isConstructor()) ? 0 : 1) != param1List.size())) {
/* 1943 */         throw new IllegalArgumentException("Cannot assign " + param1List + " to " + param1InDefinedShape);
/*      */       }
/*      */ 
/*      */       
/* 1947 */       List<?> list = (List<?>)((param1InDefinedShape.isStatic() || param1InDefinedShape.isConstructor()) ? param1InDefinedShape.getParameters().asTypeList().asErasures() : CompoundList.<TypeDescription>of(param1InDefinedShape.getDeclaringType(), (List<? extends TypeDescription>)param1InDefinedShape.getParameters().asTypeList().asErasures()));
/*      */       
/* 1949 */       if (param1InDefinedShape.isVarArgs()) {
/*      */ 
/*      */         
/* 1952 */         iterator = CompoundList.of(list.subList(0, list.size() - 1), Collections.nCopies(param1List.size() - list.size() + 1, ((TypeDescription)list.get(list.size() - 1)).getComponentType())).iterator();
/*      */       } else {
/* 1954 */         iterator = iterator.iterator();
/*      */       } 
/*      */       ArrayList<JavaConstant.MethodHandle> arrayList;
/* 1957 */       (arrayList = new ArrayList<JavaConstant.MethodHandle>(param1List.size() + 1)).add(JavaConstant.MethodHandle.of(param1InDefinedShape));
/* 1958 */       for (Iterator<?> iterator1 = param1List.iterator(); iterator1.hasNext(); ) {
/*      */         Object object;
/* 1960 */         if (!(object = JavaConstant.Simple.wrap(object = iterator1.next())).getTypeDescription().isAssignableTo(iterator.next())) {
/* 1961 */           throw new IllegalArgumentException("Cannot assign " + param1List + " to " + param1InDefinedShape);
/*      */         }
/* 1963 */         arrayList.add(object);
/*      */       } 
/* 1965 */       return new Dynamic("_", 
/* 1966 */           param1InDefinedShape.isConstructor() ? param1InDefinedShape
/* 1967 */           .getDeclaringType() : param1InDefinedShape
/* 1968 */           .getReturnType().asErasure(), new JavaConstant.MethodHandle(JavaConstant.MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS
/*      */             
/* 1970 */             .getTypeStub(), "invoke", 
/*      */             
/* 1972 */             TypeDescription.ForLoadedType.of(Object.class), 
/* 1973 */             Arrays.asList(new TypeDescription[] { JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), 
/* 1974 */                 TypeDescription.ForLoadedType.of(String.class), 
/* 1975 */                 TypeDescription.ForLoadedType.of(Class.class), JavaType.METHOD_HANDLE
/* 1976 */                 .getTypeStub(), 
/* 1977 */                 TypeDescription.ArrayProjection.of(TypeDescription.ForLoadedType.of(Object.class)) })), (List)arrayList);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static JavaConstant ofVarHandle(Field param1Field) {
/* 1988 */       return ofVarHandle((FieldDescription.InDefinedShape)new FieldDescription.ForLoadedField(param1Field));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static JavaConstant ofVarHandle(FieldDescription.InDefinedShape param1InDefinedShape) {
/* 1998 */       return new Dynamic(param1InDefinedShape.getInternalName(), JavaType.VAR_HANDLE
/* 1999 */           .getTypeStub(), new JavaConstant.MethodHandle(JavaConstant.MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS
/*      */             
/* 2001 */             .getTypeStub(), 
/* 2002 */             param1InDefinedShape.isStatic() ? "staticFieldVarHandle" : "fieldVarHandle", JavaType.VAR_HANDLE
/*      */ 
/*      */             
/* 2005 */             .getTypeStub(), 
/* 2006 */             Arrays.asList(new TypeDescription[] { JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), 
/* 2007 */                 TypeDescription.ForLoadedType.of(String.class), 
/* 2008 */                 TypeDescription.ForLoadedType.of(Class.class), 
/* 2009 */                 TypeDescription.ForLoadedType.of(Class.class), 
/* 2010 */                 TypeDescription.ForLoadedType.of(Class.class)
/* 2011 */               })), Arrays.asList(new JavaConstant[] { JavaConstant.Simple.of(param1InDefinedShape.getDeclaringType()), JavaConstant.Simple.of(param1InDefinedShape.getType().asErasure()) }));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static JavaConstant ofArrayVarHandle(Class<?> param1Class) {
/* 2021 */       return ofArrayVarHandle(TypeDescription.ForLoadedType.of(param1Class));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static JavaConstant ofArrayVarHandle(TypeDescription param1TypeDescription) {
/* 2031 */       if (!param1TypeDescription.isArray()) {
/* 2032 */         throw new IllegalArgumentException("Not an array type: " + param1TypeDescription);
/*      */       }
/* 2034 */       return new Dynamic("_", JavaType.VAR_HANDLE
/* 2035 */           .getTypeStub(), new JavaConstant.MethodHandle(JavaConstant.MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS
/*      */             
/* 2037 */             .getTypeStub(), "arrayVarHandle", JavaType.VAR_HANDLE
/*      */             
/* 2039 */             .getTypeStub(), 
/* 2040 */             Arrays.asList(new TypeDescription[] { JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), 
/* 2041 */                 TypeDescription.ForLoadedType.of(String.class), 
/* 2042 */                 TypeDescription.ForLoadedType.of(Class.class), 
/* 2043 */                 TypeDescription.ForLoadedType.of(Class.class)
/* 2044 */               })), Collections.singletonList(JavaConstant.Simple.of(param1TypeDescription)));
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
/*      */     public static Dynamic bootstrap(String param1String, Method param1Method, Object... param1VarArgs) {
/* 2057 */       return bootstrap(param1String, param1Method, Arrays.asList(param1VarArgs));
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
/*      */     public static Dynamic bootstrap(String param1String, Method param1Method, List<?> param1List) {
/* 2071 */       return bootstrap(param1String, (MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(param1Method), param1List);
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
/*      */     public static Dynamic bootstrap(String param1String, Constructor<?> param1Constructor, Object... param1VarArgs) {
/* 2085 */       return bootstrap(param1String, param1Constructor, Arrays.asList(param1VarArgs));
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
/*      */     public static Dynamic bootstrap(String param1String, Constructor<?> param1Constructor, List<?> param1List) {
/* 2099 */       return bootstrap(param1String, (MethodDescription.InDefinedShape)new MethodDescription.ForLoadedConstructor(param1Constructor), param1List);
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
/*      */     public static Dynamic bootstrap(String param1String, MethodDescription.InDefinedShape param1InDefinedShape, Object... param1VarArgs) {
/* 2113 */       return bootstrap(param1String, param1InDefinedShape, Arrays.asList(param1VarArgs));
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
/*      */     public static Dynamic bootstrap(String param1String, MethodDescription.InDefinedShape param1InDefinedShape, List<?> param1List) {
/* 2127 */       if (param1String.length() == 0 || param1String.contains(".")) {
/* 2128 */         throw new IllegalArgumentException("Not a valid field name: " + param1String);
/*      */       }
/* 2130 */       ArrayList<Object> arrayList = new ArrayList(param1List.size());
/* 2131 */       ArrayList<TypeDescription> arrayList1 = new ArrayList(param1List.size());
/* 2132 */       for (Iterator<?> iterator = param1List.iterator(); iterator.hasNext(); ) {
/* 2133 */         Object object = JavaConstant.Simple.wrap(object = iterator.next());
/* 2134 */         arrayList.add(object);
/* 2135 */         arrayList1.add(object.getTypeDescription());
/*      */       } 
/* 2137 */       if (!param1InDefinedShape.isConstantBootstrap(arrayList1)) {
/* 2138 */         throw new IllegalArgumentException("Not a valid bootstrap method " + param1InDefinedShape + " for " + arrayList);
/*      */       }
/* 2140 */       return new Dynamic(param1String, 
/* 2141 */           param1InDefinedShape.isConstructor() ? param1InDefinedShape
/* 2142 */           .getDeclaringType() : param1InDefinedShape
/* 2143 */           .getReturnType().asErasure(), new JavaConstant.MethodHandle(
/* 2144 */             param1InDefinedShape.isConstructor() ? JavaConstant.MethodHandle.HandleType.INVOKE_SPECIAL_CONSTRUCTOR : JavaConstant.MethodHandle.HandleType.INVOKE_STATIC, param1InDefinedShape
/* 2145 */             .getDeclaringType(), param1InDefinedShape
/* 2146 */             .getInternalName(), param1InDefinedShape
/* 2147 */             .getReturnType().asErasure(), (List<? extends TypeDescription>)param1InDefinedShape
/* 2148 */             .getParameters().asTypeList().asErasures()), arrayList);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getName() {
/* 2158 */       return this.name;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public JavaConstant.MethodHandle getBootstrap() {
/* 2167 */       return this.bootstrap;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public List<JavaConstant> getArguments() {
/* 2176 */       return this.arguments;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public JavaConstant withType(Class<?> param1Class) {
/* 2187 */       return withType(TypeDescription.ForLoadedType.of(param1Class));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public JavaConstant withType(TypeDescription param1TypeDescription) {
/* 2198 */       if (param1TypeDescription.represents(void.class))
/* 2199 */         throw new IllegalArgumentException("Constant value cannot represent void"); 
/* 2200 */       if (getBootstrap().getName().equals("<init>") ? 
/* 2201 */         !getTypeDescription().isAssignableTo(param1TypeDescription) : 
/* 2202 */         !param1TypeDescription.asBoxed().isInHierarchyWith(getTypeDescription().asBoxed())) {
/* 2203 */         throw new IllegalArgumentException(param1TypeDescription + " is not compatible with bootstrapped type " + getTypeDescription());
/*      */       }
/* 2205 */       return new Dynamic(getName(), param1TypeDescription, getBootstrap(), getArguments());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object toDescription() {
/* 2212 */       Object[] arrayOfObject = JavaConstant.Simple.CONSTANT_DESC.toArray(this.arguments.size());
/* 2213 */       for (byte b = 0; b < arrayOfObject.length; b++) {
/* 2214 */         arrayOfObject[b] = ((JavaConstant)this.arguments.get(b)).toDescription();
/*      */       }
/* 2216 */       return JavaConstant.Simple.DYNAMIC_CONSTANT_DESC.ofCanonical(JavaConstant.Simple.METHOD_HANDLE_DESC.of(JavaConstant.Simple.DIRECT_METHOD_HANDLE_DESC_KIND
/* 2217 */             .valueOf(this.bootstrap.getHandleType().getIdentifier(), this.bootstrap.getOwnerType().isInterface()), JavaConstant.Simple.CLASS_DESC
/* 2218 */             .ofDescriptor(this.bootstrap.getOwnerType().getDescriptor()), this.bootstrap
/* 2219 */             .getName(), this.bootstrap
/* 2220 */             .getDescriptor()), getName(), JavaConstant.Simple.CLASS_DESC.ofDescriptor(this.typeDescription.getDescriptor()), arrayOfObject);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public <T> T accept(JavaConstant.Visitor<T> param1Visitor) {
/* 2227 */       return param1Visitor.onDynamic(this);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription getTypeDescription() {
/* 2234 */       return this.typeDescription;
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/* 2239 */       int i = this.name.hashCode();
/* 2240 */       i = i * 31 + this.typeDescription.hashCode();
/* 2241 */       i = i * 31 + this.bootstrap.hashCode();
/*      */       
/* 2243 */       return i = i * 31 + this.arguments.hashCode();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/* 2248 */       if (this == param1Object) return true; 
/* 2249 */       if (param1Object == null || getClass() != param1Object.getClass()) return false; 
/* 2250 */       param1Object = param1Object;
/* 2251 */       if (!this.name.equals(((Dynamic)param1Object).name)) return false; 
/* 2252 */       if (!this.typeDescription.equals(((Dynamic)param1Object).typeDescription)) return false; 
/* 2253 */       if (!this.bootstrap.equals(((Dynamic)param1Object).bootstrap)) return false; 
/* 2254 */       return this.arguments.equals(((Dynamic)param1Object).arguments);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/* 2265 */       StringBuilder stringBuilder = (new StringBuilder()).append(this.bootstrap.getOwnerType().getSimpleName()).append("::").append(this.bootstrap.getName()).append('(').append(this.name.equals("_") ? "" : this.name).append('/');
/* 2266 */       boolean bool = true;
/* 2267 */       for (JavaConstant javaConstant : this.arguments) {
/* 2268 */         if (bool) {
/* 2269 */           bool = false;
/*      */         } else {
/* 2271 */           stringBuilder.append(',');
/*      */         } 
/* 2273 */         stringBuilder.append(javaConstant.toString());
/*      */       } 
/* 2275 */       return stringBuilder.append(')').append(this.typeDescription.getSimpleName()).toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\JavaConstant.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */