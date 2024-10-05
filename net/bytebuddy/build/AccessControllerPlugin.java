/*     */ package net.bytebuddy.build;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.lang.annotation.Documented;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import java.security.Permission;
/*     */ import java.security.PrivilegedAction;
/*     */ import java.security.PrivilegedExceptionAction;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.bytebuddy.asm.AsmVisitorWrapper;
/*     */ import net.bytebuddy.description.field.FieldList;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.modifier.FieldManifestation;
/*     */ import net.bytebuddy.description.modifier.ModifierContributor;
/*     */ import net.bytebuddy.description.modifier.Ownership;
/*     */ import net.bytebuddy.description.modifier.Visibility;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.ClassFileLocator;
/*     */ import net.bytebuddy.dynamic.DynamicType;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*     */ import net.bytebuddy.implementation.bytecode.StackSize;
/*     */ import net.bytebuddy.jar.asm.Label;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.jar.asm.Type;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
/*     */ import net.bytebuddy.pool.TypePool;
/*     */ import net.bytebuddy.utility.JavaType;
/*     */ import net.bytebuddy.utility.OpenedClassReader;
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
/*     */ @Enhance
/*     */ public class AccessControllerPlugin
/*     */   extends Plugin.ForElementMatcher
/*     */   implements Plugin.Factory
/*     */ {
/*     */   private static final String ACCESS_CONTROLLER = "java.security.AccessController";
/*     */   private static final String NAME = "ACCESS_CONTROLLER";
/*  73 */   private static final Object[] EMPTY = new Object[0];
/*     */ 
/*     */   
/*     */   private static final Map<MethodDescription.SignatureToken, MethodDescription.SignatureToken> SIGNATURES;
/*     */ 
/*     */   
/*     */   @MaybeNull
/*     */   @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*     */   private final String property;
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  86 */     (SIGNATURES = new HashMap<MethodDescription.SignatureToken, MethodDescription.SignatureToken>()).put(new MethodDescription.SignatureToken("doPrivileged", 
/*  87 */           TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[] {
/*  88 */             TypeDescription.ForLoadedType.of(PrivilegedAction.class) }), new MethodDescription.SignatureToken("doPrivileged", 
/*  89 */           TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[] {
/*  90 */             TypeDescription.ForLoadedType.of(PrivilegedAction.class) }));
/*  91 */     SIGNATURES.put(new MethodDescription.SignatureToken("doPrivilegedWithCombiner", 
/*  92 */           TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[] {
/*  93 */             TypeDescription.ForLoadedType.of(PrivilegedAction.class) }), new MethodDescription.SignatureToken("doPrivilegedWithCombiner", 
/*  94 */           TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[] {
/*  95 */             TypeDescription.ForLoadedType.of(PrivilegedAction.class) }));
/*  96 */     SIGNATURES.put(new MethodDescription.SignatureToken("doPrivileged", 
/*  97 */           TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[] {
/*  98 */             TypeDescription.ForLoadedType.of(PrivilegedAction.class), 
/*  99 */             TypeDescription.ForLoadedType.of(Object.class) }), new MethodDescription.SignatureToken("doPrivileged", 
/* 100 */           TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[] {
/* 101 */             TypeDescription.ForLoadedType.of(PrivilegedAction.class), JavaType.ACCESS_CONTROL_CONTEXT
/* 102 */             .getTypeStub() }));
/* 103 */     SIGNATURES.put(new MethodDescription.SignatureToken("doPrivileged", 
/* 104 */           TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[] {
/* 105 */             TypeDescription.ForLoadedType.of(PrivilegedAction.class), 
/* 106 */             TypeDescription.ForLoadedType.of(Object.class), 
/* 107 */             TypeDescription.ForLoadedType.of(Permission[].class) }), new MethodDescription.SignatureToken("doPrivileged", 
/* 108 */           TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[] {
/* 109 */             TypeDescription.ForLoadedType.of(PrivilegedAction.class), JavaType.ACCESS_CONTROL_CONTEXT
/* 110 */             .getTypeStub(), 
/* 111 */             TypeDescription.ForLoadedType.of(Permission[].class) }));
/* 112 */     SIGNATURES.put(new MethodDescription.SignatureToken("doPrivilegedWithCombiner", 
/* 113 */           TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[] {
/* 114 */             TypeDescription.ForLoadedType.of(PrivilegedAction.class), 
/* 115 */             TypeDescription.ForLoadedType.of(Object.class), 
/* 116 */             TypeDescription.ForLoadedType.of(Permission[].class) }), new MethodDescription.SignatureToken("doPrivilegedWithCombiner", 
/* 117 */           TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[] {
/* 118 */             TypeDescription.ForLoadedType.of(PrivilegedAction.class), JavaType.ACCESS_CONTROL_CONTEXT
/* 119 */             .getTypeStub(), 
/* 120 */             TypeDescription.ForLoadedType.of(Permission[].class) }));
/* 121 */     SIGNATURES.put(new MethodDescription.SignatureToken("doPrivileged", 
/* 122 */           TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[] {
/* 123 */             TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class) }), new MethodDescription.SignatureToken("doPrivileged", 
/* 124 */           TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[] {
/* 125 */             TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class) }));
/* 126 */     SIGNATURES.put(new MethodDescription.SignatureToken("doPrivilegedWithCombiner", 
/* 127 */           TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[] {
/* 128 */             TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class) }), new MethodDescription.SignatureToken("doPrivilegedWithCombiner", 
/* 129 */           TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[] {
/* 130 */             TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class) }));
/* 131 */     SIGNATURES.put(new MethodDescription.SignatureToken("doPrivileged", 
/* 132 */           TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[] {
/* 133 */             TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class), 
/* 134 */             TypeDescription.ForLoadedType.of(Object.class) }), new MethodDescription.SignatureToken("doPrivileged", 
/* 135 */           TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[] {
/* 136 */             TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class), JavaType.ACCESS_CONTROL_CONTEXT
/* 137 */             .getTypeStub() }));
/* 138 */     SIGNATURES.put(new MethodDescription.SignatureToken("doPrivileged", 
/* 139 */           TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[] {
/* 140 */             TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class), 
/* 141 */             TypeDescription.ForLoadedType.of(Object.class), 
/* 142 */             TypeDescription.ForLoadedType.of(Permission[].class) }), new MethodDescription.SignatureToken("doPrivileged", 
/* 143 */           TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[] {
/* 144 */             TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class), JavaType.ACCESS_CONTROL_CONTEXT
/* 145 */             .getTypeStub(), 
/* 146 */             TypeDescription.ForLoadedType.of(Permission[].class) }));
/* 147 */     SIGNATURES.put(new MethodDescription.SignatureToken("doPrivilegedWithCombiner", 
/* 148 */           TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[] {
/* 149 */             TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class), 
/* 150 */             TypeDescription.ForLoadedType.of(Object.class), 
/* 151 */             TypeDescription.ForLoadedType.of(Permission[].class) }), new MethodDescription.SignatureToken("doPrivilegedWithCombiner", 
/* 152 */           TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[] {
/* 153 */             TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class), JavaType.ACCESS_CONTROL_CONTEXT
/* 154 */             .getTypeStub(), 
/* 155 */             TypeDescription.ForLoadedType.of(Permission[].class) }));
/* 156 */     SIGNATURES.put(new MethodDescription.SignatureToken("getContext", 
/* 157 */           TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[0]), new MethodDescription.SignatureToken("getContext", JavaType.ACCESS_CONTROL_CONTEXT
/* 158 */           .getTypeStub(), new TypeDescription[0]));
/* 159 */     SIGNATURES.put(new MethodDescription.SignatureToken("checkPermission", 
/* 160 */           TypeDescription.ForLoadedType.of(void.class), new TypeDescription[] {
/* 161 */             TypeDescription.ForLoadedType.of(Permission.class) }), new MethodDescription.SignatureToken("checkPermission", 
/* 162 */           TypeDescription.ForLoadedType.of(void.class), new TypeDescription[] {
/* 163 */             TypeDescription.ForLoadedType.of(Permission.class)
/*     */           }));
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
/*     */   public AccessControllerPlugin() {
/* 179 */     this(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Priority(2147483647)
/*     */   public AccessControllerPlugin(@MaybeNull String paramString) {
/* 190 */     super((ElementMatcher<? super TypeDescription>)ElementMatchers.declaresMethod((ElementMatcher)ElementMatchers.isAnnotatedWith(Enhance.class)));
/* 191 */     this.property = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Plugin make() {
/* 198 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SuppressFBWarnings(value = {"SBSC_USE_STRINGBUFFER_CONCATENATION"}, justification = "Collision is unlikely and buffer overhead not justified.")
/*     */   public DynamicType.Builder<?> apply(DynamicType.Builder<?> paramBuilder, TypeDescription paramTypeDescription, ClassFileLocator paramClassFileLocator) {
/* 206 */     String str = "ACCESS_CONTROLLER";
/* 207 */     while (!((FieldList)paramTypeDescription.getDeclaredFields().filter((ElementMatcher)ElementMatchers.named(str))).isEmpty()) {
/* 208 */       str = str + "$";
/*     */     }
/* 210 */     return paramBuilder
/* 211 */       .defineField(str, boolean.class, new ModifierContributor.ForField[] { (ModifierContributor.ForField)Visibility.PRIVATE, (ModifierContributor.ForField)Ownership.STATIC, (ModifierContributor.ForField)FieldManifestation.FINAL
/* 212 */         }).visit((AsmVisitorWrapper)(new AsmVisitorWrapper.ForDeclaredMethods()).method((ElementMatcher)ElementMatchers.isAnnotatedWith(Enhance.class), new AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper[] { new AccessControlWrapper(str)
/* 213 */           })).initializer((this.property == null) ? new Initializer.WithoutProperty(paramTypeDescription, str) : new Initializer.WithProperty(paramTypeDescription, str, this.property));
/*     */   }
/*     */   public void close() {}
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     String str;
/*     */     if (!super.equals(paramObject))
/*     */       return false; 
/*     */     if (this == paramObject)
/*     */       return true; 
/*     */     if (paramObject == null)
/*     */       return false; 
/*     */     if (getClass() != paramObject.getClass())
/*     */       return false; 
/*     */     paramObject = ((AccessControllerPlugin)paramObject).property;
/*     */     if (paramObject != null) {
/*     */       if ((str = this.property) != null) {
/*     */         if (!str.equals(paramObject))
/*     */           return false; 
/*     */       } else {
/*     */         return false;
/*     */       } 
/*     */     } else if ((str = this.property) != null) {
/*     */       return false;
/*     */     } 
/*     */     return true;
/*     */   }
/*     */   public int hashCode() {
/*     */     String str;
/*     */     if ((str = this.property) != null);
/*     */     return super.hashCode() * 31 + str.hashCode();
/*     */   }
/*     */   @Enhance
/*     */   protected static abstract class Initializer implements ByteCodeAppender { private final TypeDescription instrumentedType;
/*     */     private final String name;
/*     */     
/*     */     protected Initializer(TypeDescription param1TypeDescription, String param1String) {
/* 249 */       this.instrumentedType = param1TypeDescription;
/* 250 */       this.name = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/* 257 */       Label label1 = new Label(), label2 = new Label(), label3 = new Label(), label4 = new Label(), label5 = new Label();
/* 258 */       param1MethodVisitor.visitTryCatchBlock(label1, label2, label3, Type.getInternalName(ClassNotFoundException.class));
/* 259 */       param1MethodVisitor.visitTryCatchBlock(label1, label2, label4, Type.getInternalName(SecurityException.class));
/* 260 */       param1MethodVisitor.visitLabel(label1);
/* 261 */       param1MethodVisitor.visitLdcInsn("java.security.AccessController");
/* 262 */       param1MethodVisitor.visitInsn(3);
/* 263 */       param1MethodVisitor.visitInsn(1);
/* 264 */       param1MethodVisitor.visitMethodInsn(184, 
/* 265 */           Type.getInternalName(Class.class), "forName", 
/*     */           
/* 267 */           Type.getMethodDescriptor(Type.getType(Class.class), new Type[] {
/* 268 */               Type.getType(String.class), 
/* 269 */               Type.getType(boolean.class), 
/* 270 */               Type.getType(ClassLoader.class)
/*     */             }), false);
/* 272 */       param1MethodVisitor.visitInsn(87);
/* 273 */       int i = onAccessController(param1MethodVisitor);
/* 274 */       param1MethodVisitor.visitFieldInsn(179, this.instrumentedType.getInternalName(), this.name, Type.getDescriptor(boolean.class));
/* 275 */       param1MethodVisitor.visitLabel(label2);
/* 276 */       param1MethodVisitor.visitJumpInsn(167, label5);
/* 277 */       param1MethodVisitor.visitLabel(label3);
/* 278 */       param1Context.getFrameGeneration().same1(param1MethodVisitor, 
/* 279 */           (TypeDefinition)TypeDescription.ForLoadedType.of(ClassNotFoundException.class), 
/* 280 */           Collections.emptyList());
/* 281 */       param1MethodVisitor.visitInsn(87);
/* 282 */       param1MethodVisitor.visitInsn(3);
/* 283 */       param1MethodVisitor.visitFieldInsn(179, this.instrumentedType.getInternalName(), this.name, Type.getDescriptor(boolean.class));
/* 284 */       param1MethodVisitor.visitJumpInsn(167, label5);
/* 285 */       param1MethodVisitor.visitLabel(label4);
/* 286 */       param1Context.getFrameGeneration().same1(param1MethodVisitor, 
/* 287 */           (TypeDefinition)TypeDescription.ForLoadedType.of(SecurityException.class), 
/* 288 */           Collections.emptyList());
/* 289 */       param1MethodVisitor.visitInsn(87);
/* 290 */       param1MethodVisitor.visitInsn(4);
/* 291 */       param1MethodVisitor.visitFieldInsn(179, this.instrumentedType.getInternalName(), this.name, Type.getDescriptor(boolean.class));
/* 292 */       param1MethodVisitor.visitLabel(label5);
/* 293 */       param1Context.getFrameGeneration().same(param1MethodVisitor, Collections.emptyList());
/* 294 */       return new ByteCodeAppender.Size(Math.max(3, i), 0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract int onAccessController(MethodVisitor param1MethodVisitor);
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.name.equals(((Initializer)param1Object).name) ? false : (!!this.instrumentedType.equals(((Initializer)param1Object).instrumentedType)))));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return (getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.name.hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     protected static class WithProperty
/*     */       extends Initializer
/*     */     {
/*     */       private final String property;
/*     */ 
/*     */ 
/*     */       
/*     */       protected WithProperty(TypeDescription param2TypeDescription, String param2String1, String param2String2) {
/* 324 */         super(param2TypeDescription, param2String1);
/* 325 */         this.property = param2String2;
/*     */       }
/*     */ 
/*     */       
/*     */       protected int onAccessController(MethodVisitor param2MethodVisitor) {
/* 330 */         param2MethodVisitor.visitLdcInsn(this.property);
/* 331 */         param2MethodVisitor.visitLdcInsn("true");
/* 332 */         param2MethodVisitor.visitMethodInsn(184, 
/* 333 */             Type.getInternalName(System.class), "getProperty", 
/*     */             
/* 335 */             Type.getMethodDescriptor(Type.getType(String.class), new Type[] { Type.getType(String.class), Type.getType(String.class) }), false);
/*     */         
/* 337 */         param2MethodVisitor.visitMethodInsn(184, 
/* 338 */             Type.getInternalName(Boolean.class), "parseBoolean", 
/*     */             
/* 340 */             Type.getMethodDescriptor(Type.getType(boolean.class), new Type[] { Type.getType(String.class) }), false);
/*     */         
/* 342 */         return 2;
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return !super.equals(param2Object) ? false : ((this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.property.equals(((WithProperty)param2Object).property)))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return super.hashCode() * 31 + this.property.hashCode();
/*     */       }
/*     */     }
/*     */     
/*     */     @Enhance
/*     */     protected static class WithoutProperty
/*     */       extends Initializer
/*     */     {
/*     */       protected WithoutProperty(TypeDescription param2TypeDescription, String param2String) {
/* 359 */         super(param2TypeDescription, param2String);
/*     */       } public boolean equals(@MaybeNull Object param2Object) {
/*     */         return !super.equals(param2Object) ? false : ((this == param2Object) ? true : ((param2Object == null) ? false : (!(getClass() != param2Object.getClass()))));
/*     */       } public int hashCode() {
/*     */         return super.hashCode();
/* 364 */       } protected int onAccessController(MethodVisitor param2MethodVisitor) { param2MethodVisitor.visitInsn(4);
/* 365 */         return 1; } } } @Enhance protected static class WithProperty extends Initializer { private final String property; protected WithProperty(TypeDescription param1TypeDescription, String param1String1, String param1String2) { super(param1TypeDescription, param1String1); this.property = param1String2; } protected int onAccessController(MethodVisitor param1MethodVisitor) { param1MethodVisitor.visitLdcInsn(this.property); param1MethodVisitor.visitLdcInsn("true"); param1MethodVisitor.visitMethodInsn(184, Type.getInternalName(System.class), "getProperty", Type.getMethodDescriptor(Type.getType(String.class), new Type[] { Type.getType(String.class), Type.getType(String.class) }), false); param1MethodVisitor.visitMethodInsn(184, Type.getInternalName(Boolean.class), "parseBoolean", Type.getMethodDescriptor(Type.getType(boolean.class), new Type[] { Type.getType(String.class) }), false); return 2; } public boolean equals(@MaybeNull Object param1Object) { return !super.equals(param1Object) ? false : ((this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.property.equals(((WithProperty)param1Object).property))))); } public int hashCode() { return super.hashCode() * 31 + this.property.hashCode(); } } @Enhance protected static class WithoutProperty extends Initializer { protected int onAccessController(MethodVisitor param1MethodVisitor) { param1MethodVisitor.visitInsn(4); return 1; }
/*     */ 
/*     */     
/*     */     protected WithoutProperty(TypeDescription param1TypeDescription, String param1String) {
/*     */       super(param1TypeDescription, param1String);
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return !super.equals(param1Object) ? false : ((this == param1Object) ? true : ((param1Object == null) ? false : (!(getClass() != param1Object.getClass()))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return super.hashCode();
/*     */     } }
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   protected static class AccessControlWrapper
/*     */     implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper {
/*     */     private final String name;
/*     */     
/*     */     protected AccessControlWrapper(String param1String) {
/* 387 */       this.name = param1String;
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
/*     */     public MethodVisitor wrap(TypeDescription param1TypeDescription, MethodDescription param1MethodDescription, MethodVisitor param1MethodVisitor, Implementation.Context param1Context, TypePool param1TypePool, int param1Int1, int param1Int2) {
/*     */       MethodDescription.SignatureToken signatureToken;
/* 401 */       if ((signatureToken = (MethodDescription.SignatureToken)AccessControllerPlugin.a().get(((MethodDescription.InDefinedShape)param1MethodDescription.asDefined()).asSignatureToken())) == null)
/* 402 */         throw new IllegalStateException(param1MethodDescription + " does not have a method with a matching signature in java.security.AccessController"); 
/* 403 */       if (param1MethodDescription.isPublic() || param1MethodDescription.isProtected()) {
/* 404 */         throw new IllegalStateException(param1MethodDescription + " is either public or protected what is not permitted to avoid context leaks");
/*     */       }
/* 406 */       return new PrefixingMethodVisitor(param1MethodVisitor, param1TypeDescription, signatureToken, this.name, 
/*     */ 
/*     */ 
/*     */           
/* 410 */           param1MethodDescription.isStatic() ? 0 : 1, param1Context
/* 411 */           .getFrameGeneration());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.name.equals(((AccessControlWrapper)param1Object).name))));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.name.hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected static class PrefixingMethodVisitor
/*     */       extends MethodVisitor
/*     */     {
/*     */       private final TypeDescription instrumentedType;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final MethodDescription.SignatureToken token;
/*     */ 
/*     */ 
/*     */       
/*     */       private final String name;
/*     */ 
/*     */ 
/*     */       
/*     */       private final int offset;
/*     */ 
/*     */ 
/*     */       
/*     */       private final Implementation.Context.FrameGeneration frameGeneration;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected PrefixingMethodVisitor(MethodVisitor param2MethodVisitor, TypeDescription param2TypeDescription, MethodDescription.SignatureToken param2SignatureToken, String param2String, int param2Int, Implementation.Context.FrameGeneration param2FrameGeneration) {
/* 460 */         super(OpenedClassReader.ASM_API, param2MethodVisitor);
/* 461 */         this.instrumentedType = param2TypeDescription;
/* 462 */         this.token = param2SignatureToken;
/* 463 */         this.name = param2String;
/* 464 */         this.offset = param2Int;
/* 465 */         this.frameGeneration = param2FrameGeneration;
/*     */       }
/*     */ 
/*     */       
/*     */       public void visitCode() {
/* 470 */         this.mv.visitCode();
/* 471 */         this.mv.visitFieldInsn(178, this.instrumentedType.getInternalName(), this.name, Type.getDescriptor(boolean.class));
/* 472 */         Label label = new Label();
/* 473 */         this.mv.visitJumpInsn(153, label);
/* 474 */         int i = this.offset;
/* 475 */         for (TypeDescription typeDescription : this.token.getParameterTypes()) {
/* 476 */           this.mv.visitVarInsn(Type.getType(typeDescription.getDescriptor()).getOpcode(21), i);
/* 477 */           if (typeDescription.equals(JavaType.ACCESS_CONTROL_CONTEXT.getTypeStub())) {
/* 478 */             this.mv.visitTypeInsn(192, typeDescription.getInternalName());
/*     */           }
/* 480 */           i += typeDescription.getStackSize().getSize();
/*     */         } 
/* 482 */         this.mv.visitMethodInsn(184, "java.security.AccessController"
/* 483 */             .replace('.', '/'), this.token
/* 484 */             .getName(), this.token
/* 485 */             .getDescriptor(), false);
/*     */         
/* 487 */         this.mv.visitInsn(Type.getType(this.token.getReturnType().getDescriptor()).getOpcode(172));
/* 488 */         this.mv.visitLabel(label);
/* 489 */         this.frameGeneration.same(this.mv, this.token.getParameterTypes());
/*     */       }
/*     */ 
/*     */       
/*     */       public void visitMaxs(int param2Int1, int param2Int2) {
/* 494 */         this.mv.visitMaxs(Math.max(Math.max(StackSize.of(this.token.getParameterTypes()), this.token
/* 495 */                 .getReturnType().getStackSize().getSize()), param2Int1), param2Int2);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @Documented
/*     */   @Target({ElementType.METHOD})
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   public static @interface Enhance {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\build\AccessControllerPlugin.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */