/*      */ package net.bytebuddy.dynamic.scaffold;
/*      */ 
/*      */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*      */ import java.io.File;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.security.AccessController;
/*      */ import java.security.PrivilegedAction;
/*      */ import java.security.PrivilegedExceptionAction;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.LinkedHashSet;
/*      */ import java.util.List;
/*      */ import java.util.Set;
/*      */ import net.bytebuddy.ClassFileVersion;
/*      */ import net.bytebuddy.asm.AsmVisitorWrapper;
/*      */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*      */ import net.bytebuddy.description.annotation.AnnotationList;
/*      */ import net.bytebuddy.description.annotation.AnnotationValue;
/*      */ import net.bytebuddy.description.field.FieldDescription;
/*      */ import net.bytebuddy.description.field.FieldList;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.method.MethodList;
/*      */ import net.bytebuddy.description.method.ParameterDescription;
/*      */ import net.bytebuddy.description.method.ParameterList;
/*      */ import net.bytebuddy.description.modifier.ModifierContributor;
/*      */ import net.bytebuddy.description.modifier.Visibility;
/*      */ import net.bytebuddy.description.type.RecordComponentDescription;
/*      */ import net.bytebuddy.description.type.RecordComponentList;
/*      */ import net.bytebuddy.description.type.TypeDefinition;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.description.type.TypeList;
/*      */ import net.bytebuddy.dynamic.ClassFileLocator;
/*      */ import net.bytebuddy.dynamic.DynamicType;
/*      */ import net.bytebuddy.dynamic.TypeResolutionStrategy;
/*      */ import net.bytebuddy.dynamic.scaffold.inline.MethodRebaseResolver;
/*      */ import net.bytebuddy.dynamic.scaffold.inline.RebaseImplementationTarget;
/*      */ import net.bytebuddy.dynamic.scaffold.subclass.SubclassImplementationTarget;
/*      */ import net.bytebuddy.implementation.Implementation;
/*      */ import net.bytebuddy.implementation.LoadedTypeInitializer;
/*      */ import net.bytebuddy.implementation.attribute.AnnotationAppender;
/*      */ import net.bytebuddy.implementation.attribute.AnnotationRetention;
/*      */ import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
/*      */ import net.bytebuddy.implementation.attribute.FieldAttributeAppender;
/*      */ import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
/*      */ import net.bytebuddy.implementation.attribute.RecordComponentAttributeAppender;
/*      */ import net.bytebuddy.implementation.attribute.TypeAttributeAppender;
/*      */ import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
/*      */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*      */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*      */ import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
/*      */ import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodReturn;
/*      */ import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
/*      */ import net.bytebuddy.jar.asm.AnnotationVisitor;
/*      */ import net.bytebuddy.jar.asm.ClassReader;
/*      */ import net.bytebuddy.jar.asm.ClassVisitor;
/*      */ import net.bytebuddy.jar.asm.ClassWriter;
/*      */ import net.bytebuddy.jar.asm.FieldVisitor;
/*      */ import net.bytebuddy.jar.asm.Handle;
/*      */ import net.bytebuddy.jar.asm.Label;
/*      */ import net.bytebuddy.jar.asm.MethodVisitor;
/*      */ import net.bytebuddy.jar.asm.Opcodes;
/*      */ import net.bytebuddy.jar.asm.RecordComponentVisitor;
/*      */ import net.bytebuddy.jar.asm.Type;
/*      */ import net.bytebuddy.jar.asm.TypePath;
/*      */ import net.bytebuddy.jar.asm.commons.ClassRemapper;
/*      */ import net.bytebuddy.jar.asm.commons.Remapper;
/*      */ import net.bytebuddy.jar.asm.commons.SimpleRemapper;
/*      */ import net.bytebuddy.matcher.ElementMatcher;
/*      */ import net.bytebuddy.matcher.ElementMatchers;
/*      */ import net.bytebuddy.pool.TypePool;
/*      */ import net.bytebuddy.utility.CompoundList;
/*      */ import net.bytebuddy.utility.OpenedClassReader;
/*      */ import net.bytebuddy.utility.nullability.AlwaysNull;
/*      */ import net.bytebuddy.utility.nullability.MaybeNull;
/*      */ import net.bytebuddy.utility.nullability.UnknownNull;
/*      */ import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
/*      */ import net.bytebuddy.utility.visitor.ContextClassVisitor;
/*      */ import net.bytebuddy.utility.visitor.MetadataAwareClassVisitor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public interface TypeWriter<T>
/*      */ {
/*      */   public static final String DUMP_PROPERTY = "net.bytebuddy.dump";
/*      */   
/*      */   DynamicType.Unloaded<T> make(TypeResolutionStrategy.Resolved paramResolved);
/*      */   
/*      */   ContextClassVisitor wrap(ClassVisitor paramClassVisitor, int paramInt1, int paramInt2);
/*      */   
/*      */   public static interface FieldPool
/*      */   {
/*      */     Record target(FieldDescription param1FieldDescription);
/*      */     
/*      */     public static interface Record
/*      */     {
/*      */       boolean isImplicit();
/*      */       
/*      */       FieldDescription getField();
/*      */       
/*      */       FieldAttributeAppender getFieldAppender();
/*      */       
/*      */       @MaybeNull
/*      */       Object resolveDefault(@MaybeNull Object param2Object);
/*      */       
/*      */       void apply(ClassVisitor param2ClassVisitor, AnnotationValueFilter.Factory param2Factory);
/*      */       
/*      */       void apply(FieldVisitor param2FieldVisitor, AnnotationValueFilter.Factory param2Factory);
/*      */       
/*      */       @Enhance
/*      */       public static class ForImplicitField
/*      */         implements Record
/*      */       {
/*      */         private final FieldDescription fieldDescription;
/*      */         
/*      */         public ForImplicitField(FieldDescription param3FieldDescription) {
/*  191 */           this.fieldDescription = param3FieldDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean isImplicit() {
/*  198 */           return true;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public FieldDescription getField() {
/*  205 */           return this.fieldDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public FieldAttributeAppender getFieldAppender() {
/*  212 */           throw new IllegalStateException("An implicit field record does not expose a field appender: " + this);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Object resolveDefault(@MaybeNull Object param3Object) {
/*  219 */           throw new IllegalStateException("An implicit field record does not expose a default value: " + this);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void apply(ClassVisitor param3ClassVisitor, AnnotationValueFilter.Factory param3Factory) {
/*      */           FieldVisitor fieldVisitor;
/*  231 */           if ((fieldVisitor = param3ClassVisitor.visitField(this.fieldDescription.getActualModifiers(), this.fieldDescription.getInternalName(), this.fieldDescription.getDescriptor(), this.fieldDescription.getGenericSignature(), FieldDescription.NO_DEFAULT_VALUE)) != null) {
/*  232 */             FieldAttributeAppender.ForInstrumentedField.INSTANCE.apply(fieldVisitor, this.fieldDescription, param3Factory
/*      */                 
/*  234 */                 .on(this.fieldDescription));
/*  235 */             fieldVisitor.visitEnd();
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void apply(FieldVisitor param3FieldVisitor, AnnotationValueFilter.Factory param3Factory) {
/*  243 */           throw new IllegalStateException("An implicit field record is not intended for partial application: " + this);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.fieldDescription.equals(((ForImplicitField)param3Object).fieldDescription))));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.fieldDescription.hashCode();
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class ForExplicitField
/*      */         implements Record
/*      */       {
/*      */         private final FieldAttributeAppender attributeAppender;
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*      */         private final Object defaultValue;
/*      */ 
/*      */         
/*      */         private final FieldDescription fieldDescription;
/*      */ 
/*      */ 
/*      */         
/*      */         public ForExplicitField(FieldAttributeAppender param3FieldAttributeAppender, @MaybeNull Object param3Object, FieldDescription param3FieldDescription) {
/*  280 */           this.attributeAppender = param3FieldAttributeAppender;
/*  281 */           this.defaultValue = param3Object;
/*  282 */           this.fieldDescription = param3FieldDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean isImplicit() {
/*  289 */           return false;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public FieldDescription getField() {
/*  296 */           return this.fieldDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public FieldAttributeAppender getFieldAppender() {
/*  303 */           return this.attributeAppender;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public Object resolveDefault(@MaybeNull Object param3Object) {
/*  311 */           return (this.defaultValue == null) ? param3Object : this.defaultValue;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void apply(ClassVisitor param3ClassVisitor, AnnotationValueFilter.Factory param3Factory) {
/*      */           FieldVisitor fieldVisitor;
/*  325 */           if ((fieldVisitor = param3ClassVisitor.visitField(this.fieldDescription.getActualModifiers(), this.fieldDescription.getInternalName(), this.fieldDescription.getDescriptor(), this.fieldDescription.getGenericSignature(), resolveDefault(FieldDescription.NO_DEFAULT_VALUE))) != null) {
/*  326 */             this.attributeAppender.apply(fieldVisitor, this.fieldDescription, param3Factory.on(this.fieldDescription));
/*  327 */             fieldVisitor.visitEnd();
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void apply(FieldVisitor param3FieldVisitor, AnnotationValueFilter.Factory param3Factory) {
/*  335 */           this.attributeAppender.apply(param3FieldVisitor, this.fieldDescription, param3Factory.on(this.fieldDescription));
/*      */         } public boolean equals(@MaybeNull Object param3Object) { Object object2; if (this == param3Object)
/*      */             return true;  if (param3Object == null)
/*      */             return false;  if (getClass() != param3Object.getClass())
/*      */             return false;  if (!this.attributeAppender.equals(((ForExplicitField)param3Object).attributeAppender))
/*      */             return false;  Object object1 = ((ForExplicitField)param3Object).defaultValue; if (object1 != null) { if ((object2 = this.defaultValue) != null) { if (!object2.equals(object1))
/*      */                 return false;  }
/*      */             else
/*      */             { return false; }
/*      */              }
/*      */           else if ((object2 = this.defaultValue) != null)
/*      */           { return false; }
/*      */            return !!this.fieldDescription.equals(((ForExplicitField)param3Object).fieldDescription); } public int hashCode() { Object object; if ((object = this.defaultValue) != null); return ((getClass().hashCode() * 31 + this.attributeAppender.hashCode()) * 31 + object.hashCode()) * 31 + this.fieldDescription.hashCode(); } } }
/*  348 */     public enum Disabled implements FieldPool { INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final TypeWriter.FieldPool.Record target(FieldDescription param2FieldDescription) {
/*  354 */         throw new IllegalStateException("Cannot look up field from disabled pool");
/*      */       } }
/*      */   
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
/*      */   public static interface MethodPool
/*      */   {
/*      */     Record target(MethodDescription param1MethodDescription);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static interface Record
/*      */     {
/*      */       Sort getSort();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       MethodDescription getMethod();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       Visibility getVisibility();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       Record prepend(ByteCodeAppender param2ByteCodeAppender);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void apply(ClassVisitor param2ClassVisitor, Implementation.Context param2Context, AnnotationValueFilter.Factory param2Factory);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void applyHead(MethodVisitor param2MethodVisitor);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void applyBody(MethodVisitor param2MethodVisitor, Implementation.Context param2Context, AnnotationValueFilter.Factory param2Factory);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void applyAttributes(MethodVisitor param2MethodVisitor, AnnotationValueFilter.Factory param2Factory);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       ByteCodeAppender.Size applyCode(MethodVisitor param2MethodVisitor, Implementation.Context param2Context);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public enum Sort
/*      */       {
/*  463 */         SKIPPED(false, false),
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  468 */         DEFINED(true, false),
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  473 */         IMPLEMENTED(true, true);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final boolean define;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final boolean implement;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         Sort(boolean param3Boolean1, boolean param3Boolean2) {
/*  492 */           this.define = param3Boolean1;
/*  493 */           this.implement = param3Boolean2;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final boolean isDefined() {
/*  502 */           return this.define;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final boolean isImplemented() {
/*  511 */           return this.implement;
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class ForNonImplementedMethod
/*      */         implements Record
/*      */       {
/*      */         private final MethodDescription methodDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ForNonImplementedMethod(MethodDescription param3MethodDescription) {
/*  532 */           this.methodDescription = param3MethodDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void apply(ClassVisitor param3ClassVisitor, Implementation.Context param3Context, AnnotationValueFilter.Factory param3Factory) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void applyBody(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, AnnotationValueFilter.Factory param3Factory) {
/*  546 */           throw new IllegalStateException("Cannot apply body for non-implemented method on " + this.methodDescription);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void applyAttributes(MethodVisitor param3MethodVisitor, AnnotationValueFilter.Factory param3Factory) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ByteCodeAppender.Size applyCode(MethodVisitor param3MethodVisitor, Implementation.Context param3Context) {
/*  560 */           throw new IllegalStateException("Cannot apply code for non-implemented method on " + this.methodDescription);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void applyHead(MethodVisitor param3MethodVisitor) {
/*  567 */           throw new IllegalStateException("Cannot apply head for non-implemented method on " + this.methodDescription);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public MethodDescription getMethod() {
/*  574 */           return this.methodDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Visibility getVisibility() {
/*  581 */           return this.methodDescription.getVisibility();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeWriter.MethodPool.Record.Sort getSort() {
/*  588 */           return TypeWriter.MethodPool.Record.Sort.SKIPPED;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeWriter.MethodPool.Record prepend(ByteCodeAppender param3ByteCodeAppender) {
/*  595 */           return new TypeWriter.MethodPool.Record.ForDefinedMethod.WithBody(this.methodDescription, (ByteCodeAppender)new ByteCodeAppender.Compound(new ByteCodeAppender[] { param3ByteCodeAppender, (ByteCodeAppender)new ByteCodeAppender.Simple(new StackManipulation[] {
/*  596 */                       DefaultValue.of((TypeDefinition)this.methodDescription.getReturnType()), MethodReturn.of((TypeDefinition)this.methodDescription.getReturnType())
/*      */                     }) }));
/*      */         }
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.methodDescription.equals(((ForNonImplementedMethod)param3Object).methodDescription))));
/*      */         }
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.methodDescription.hashCode();
/*      */         }
/*      */       }
/*      */       
/*      */       public static abstract class ForDefinedMethod
/*      */         implements Record
/*      */       {
/*      */         public void apply(ClassVisitor param3ClassVisitor, Implementation.Context param3Context, AnnotationValueFilter.Factory param3Factory) {
/*      */           MethodVisitor methodVisitor;
/*  614 */           if ((methodVisitor = param3ClassVisitor.visitMethod(getMethod().getActualModifiers(getSort().isImplemented(), getVisibility()), getMethod().getInternalName(), getMethod().getDescriptor(), getMethod().getGenericSignature(), getMethod().getExceptionTypes().asErasures().toInternalNames())) != null) {
/*      */             ParameterList parameterList;
/*  616 */             if ((parameterList = getMethod().getParameters()).hasExplicitMetaData()) {
/*  617 */               for (ParameterDescription parameterDescription : parameterList) {
/*  618 */                 methodVisitor.visitParameter(parameterDescription.getName(), parameterDescription.getModifiers());
/*      */               }
/*      */             }
/*  621 */             applyHead(methodVisitor);
/*  622 */             applyBody(methodVisitor, param3Context, param3Factory);
/*  623 */             methodVisitor.visitEnd();
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class WithBody
/*      */           extends ForDefinedMethod
/*      */         {
/*      */           private final MethodDescription methodDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final ByteCodeAppender byteCodeAppender;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final MethodAttributeAppender methodAttributeAppender;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final Visibility visibility;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public WithBody(MethodDescription param4MethodDescription, ByteCodeAppender param4ByteCodeAppender) {
/*  660 */             this(param4MethodDescription, param4ByteCodeAppender, (MethodAttributeAppender)MethodAttributeAppender.NoOp.INSTANCE, param4MethodDescription.getVisibility());
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public WithBody(MethodDescription param4MethodDescription, ByteCodeAppender param4ByteCodeAppender, MethodAttributeAppender param4MethodAttributeAppender, Visibility param4Visibility) {
/*  675 */             this.methodDescription = param4MethodDescription;
/*  676 */             this.byteCodeAppender = param4ByteCodeAppender;
/*  677 */             this.methodAttributeAppender = param4MethodAttributeAppender;
/*  678 */             this.visibility = param4Visibility;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public MethodDescription getMethod() {
/*  685 */             return this.methodDescription;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeWriter.MethodPool.Record.Sort getSort() {
/*  692 */             return TypeWriter.MethodPool.Record.Sort.IMPLEMENTED;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Visibility getVisibility() {
/*  699 */             return this.visibility;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void applyHead(MethodVisitor param4MethodVisitor) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void applyBody(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, AnnotationValueFilter.Factory param4Factory) {
/*  713 */             applyAttributes(param4MethodVisitor, param4Factory);
/*  714 */             param4MethodVisitor.visitCode();
/*  715 */             ByteCodeAppender.Size size = applyCode(param4MethodVisitor, param4Context);
/*  716 */             param4MethodVisitor.visitMaxs(size.getOperandStackSize(), size.getLocalVariableSize());
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void applyAttributes(MethodVisitor param4MethodVisitor, AnnotationValueFilter.Factory param4Factory) {
/*  723 */             this.methodAttributeAppender.apply(param4MethodVisitor, this.methodDescription, param4Factory.on(this.methodDescription));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public ByteCodeAppender.Size applyCode(MethodVisitor param4MethodVisitor, Implementation.Context param4Context) {
/*  730 */             return this.byteCodeAppender.apply(param4MethodVisitor, param4Context, this.methodDescription);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeWriter.MethodPool.Record prepend(ByteCodeAppender param4ByteCodeAppender) {
/*  737 */             return new WithBody(this.methodDescription, (ByteCodeAppender)new ByteCodeAppender.Compound(new ByteCodeAppender[] { param4ByteCodeAppender, this.byteCodeAppender }, ), this.methodAttributeAppender, this.visibility);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.visibility.equals(((WithBody)param4Object).visibility) ? false : (!this.methodDescription.equals(((WithBody)param4Object).methodDescription) ? false : (!this.byteCodeAppender.equals(((WithBody)param4Object).byteCodeAppender) ? false : (!!this.methodAttributeAppender.equals(((WithBody)param4Object).methodAttributeAppender)))))));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return (((getClass().hashCode() * 31 + this.methodDescription.hashCode()) * 31 + this.byteCodeAppender.hashCode()) * 31 + this.methodAttributeAppender.hashCode()) * 31 + this.visibility.hashCode();
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class WithoutBody
/*      */           extends ForDefinedMethod
/*      */         {
/*      */           private final MethodDescription methodDescription;
/*      */ 
/*      */           
/*      */           private final MethodAttributeAppender methodAttributeAppender;
/*      */ 
/*      */           
/*      */           private final Visibility visibility;
/*      */ 
/*      */ 
/*      */           
/*      */           public WithoutBody(MethodDescription param4MethodDescription, MethodAttributeAppender param4MethodAttributeAppender, Visibility param4Visibility) {
/*  773 */             this.methodDescription = param4MethodDescription;
/*  774 */             this.methodAttributeAppender = param4MethodAttributeAppender;
/*  775 */             this.visibility = param4Visibility;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public MethodDescription getMethod() {
/*  782 */             return this.methodDescription;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeWriter.MethodPool.Record.Sort getSort() {
/*  789 */             return TypeWriter.MethodPool.Record.Sort.DEFINED;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Visibility getVisibility() {
/*  796 */             return this.visibility;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void applyHead(MethodVisitor param4MethodVisitor) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void applyBody(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, AnnotationValueFilter.Factory param4Factory) {
/*  810 */             applyAttributes(param4MethodVisitor, param4Factory);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void applyAttributes(MethodVisitor param4MethodVisitor, AnnotationValueFilter.Factory param4Factory) {
/*  817 */             this.methodAttributeAppender.apply(param4MethodVisitor, this.methodDescription, param4Factory.on(this.methodDescription));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public ByteCodeAppender.Size applyCode(MethodVisitor param4MethodVisitor, Implementation.Context param4Context) {
/*  824 */             throw new IllegalStateException("Cannot apply code for abstract method on " + this.methodDescription);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeWriter.MethodPool.Record prepend(ByteCodeAppender param4ByteCodeAppender) {
/*  831 */             throw new IllegalStateException("Cannot prepend code for abstract method on " + this.methodDescription);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.visibility.equals(((WithoutBody)param4Object).visibility) ? false : (!this.methodDescription.equals(((WithoutBody)param4Object).methodDescription) ? false : (!!this.methodAttributeAppender.equals(((WithoutBody)param4Object).methodAttributeAppender))))));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return ((getClass().hashCode() * 31 + this.methodDescription.hashCode()) * 31 + this.methodAttributeAppender.hashCode()) * 31 + this.visibility.hashCode();
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class WithAnnotationDefaultValue
/*      */           extends ForDefinedMethod
/*      */         {
/*      */           private final MethodDescription methodDescription;
/*      */ 
/*      */           
/*      */           private final AnnotationValue<?, ?> annotationValue;
/*      */ 
/*      */           
/*      */           private final MethodAttributeAppender methodAttributeAppender;
/*      */ 
/*      */ 
/*      */           
/*      */           public WithAnnotationDefaultValue(MethodDescription param4MethodDescription, AnnotationValue<?, ?> param4AnnotationValue, MethodAttributeAppender param4MethodAttributeAppender) {
/*  866 */             this.methodDescription = param4MethodDescription;
/*  867 */             this.annotationValue = param4AnnotationValue;
/*  868 */             this.methodAttributeAppender = param4MethodAttributeAppender;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public MethodDescription getMethod() {
/*  875 */             return this.methodDescription;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeWriter.MethodPool.Record.Sort getSort() {
/*  882 */             return TypeWriter.MethodPool.Record.Sort.DEFINED;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Visibility getVisibility() {
/*  889 */             return this.methodDescription.getVisibility();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void applyHead(MethodVisitor param4MethodVisitor) {
/*  896 */             if (!this.methodDescription.isDefaultValue(this.annotationValue)) {
/*  897 */               throw new IllegalStateException("Cannot set " + this.annotationValue + " as default for " + this.methodDescription);
/*      */             }
/*      */             AnnotationVisitor annotationVisitor;
/*  900 */             AnnotationAppender.Default.apply(annotationVisitor = param4MethodVisitor.visitAnnotationDefault(), this.methodDescription
/*  901 */                 .getReturnType().asErasure(), AnnotationAppender.NO_NAME, this.annotationValue
/*      */                 
/*  903 */                 .resolve());
/*  904 */             annotationVisitor.visitEnd();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void applyBody(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, AnnotationValueFilter.Factory param4Factory) {
/*  911 */             this.methodAttributeAppender.apply(param4MethodVisitor, this.methodDescription, param4Factory.on(this.methodDescription));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void applyAttributes(MethodVisitor param4MethodVisitor, AnnotationValueFilter.Factory param4Factory) {
/*  918 */             throw new IllegalStateException("Cannot apply attributes for default value on " + this.methodDescription);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public ByteCodeAppender.Size applyCode(MethodVisitor param4MethodVisitor, Implementation.Context param4Context) {
/*  925 */             throw new IllegalStateException("Cannot apply code for default value on " + this.methodDescription);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeWriter.MethodPool.Record prepend(ByteCodeAppender param4ByteCodeAppender) {
/*  932 */             throw new IllegalStateException("Cannot prepend code for default value on " + this.methodDescription);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.methodDescription.equals(((WithAnnotationDefaultValue)param4Object).methodDescription) ? false : (!this.annotationValue.equals(((WithAnnotationDefaultValue)param4Object).annotationValue) ? false : (!!this.methodAttributeAppender.equals(((WithAnnotationDefaultValue)param4Object).methodAttributeAppender))))));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return ((getClass().hashCode() * 31 + this.methodDescription.hashCode()) * 31 + this.annotationValue.hashCode()) * 31 + this.methodAttributeAppender.hashCode();
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class OfVisibilityBridge
/*      */           extends ForDefinedMethod
/*      */           implements ByteCodeAppender
/*      */         {
/*      */           private final MethodDescription visibilityBridge;
/*      */ 
/*      */ 
/*      */           
/*      */           private final MethodDescription bridgeTarget;
/*      */ 
/*      */ 
/*      */           
/*      */           private final TypeDescription bridgeType;
/*      */ 
/*      */           
/*      */           private final MethodAttributeAppender attributeAppender;
/*      */ 
/*      */ 
/*      */           
/*      */           protected OfVisibilityBridge(MethodDescription param4MethodDescription1, MethodDescription param4MethodDescription2, TypeDescription param4TypeDescription, MethodAttributeAppender param4MethodAttributeAppender) {
/*  974 */             this.visibilityBridge = param4MethodDescription1;
/*  975 */             this.bridgeTarget = param4MethodDescription2;
/*  976 */             this.bridgeType = param4TypeDescription;
/*  977 */             this.attributeAppender = param4MethodAttributeAppender;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public static TypeWriter.MethodPool.Record of(TypeDescription param4TypeDescription, MethodDescription param4MethodDescription, MethodAttributeAppender param4MethodAttributeAppender) {
/*      */             TypeDescription typeDescription2, typeDescription1;
/*  990 */             TypeDefinition typeDefinition = null;
/*  991 */             if (param4MethodDescription.isDefaultMethod()) {
/*  992 */               TypeDescription typeDescription = param4MethodDescription.getDeclaringType().asErasure();
/*  993 */               for (TypeDescription typeDescription3 : param4TypeDescription.getInterfaces().asErasures().filter((ElementMatcher)ElementMatchers.isSubTypeOf(typeDescription))) {
/*  994 */                 if (typeDefinition == null || typeDescription.isAssignableTo(typeDefinition.asErasure())) {
/*  995 */                   typeDescription2 = typeDescription3;
/*      */                 }
/*      */               } 
/*      */             } 
/*      */             TypeDescription.Generic generic;
/* 1000 */             if (typeDescription2 == null && (
/*      */               
/* 1002 */               generic = param4TypeDescription.getSuperClass()) == null) {
/* 1003 */               typeDescription1 = TypeDescription.ForLoadedType.of(Object.class);
/*      */             }
/*      */             
/* 1006 */             return new OfVisibilityBridge((MethodDescription)new VisibilityBridge(param4TypeDescription, param4MethodDescription), param4MethodDescription, typeDescription1
/*      */                 
/* 1008 */                 .asErasure(), param4MethodAttributeAppender);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public MethodDescription getMethod() {
/* 1016 */             return this.visibilityBridge;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeWriter.MethodPool.Record.Sort getSort() {
/* 1023 */             return TypeWriter.MethodPool.Record.Sort.IMPLEMENTED;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Visibility getVisibility() {
/* 1030 */             return this.bridgeTarget.getVisibility();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeWriter.MethodPool.Record prepend(ByteCodeAppender param4ByteCodeAppender) {
/* 1037 */             return new TypeWriter.MethodPool.Record.ForDefinedMethod.WithBody(this.visibilityBridge, (ByteCodeAppender)new ByteCodeAppender.Compound(new ByteCodeAppender[] { this, param4ByteCodeAppender }, ), this.attributeAppender, this.bridgeTarget
/*      */ 
/*      */                 
/* 1040 */                 .getVisibility());
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void applyHead(MethodVisitor param4MethodVisitor) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void applyBody(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, AnnotationValueFilter.Factory param4Factory) {
/* 1054 */             applyAttributes(param4MethodVisitor, param4Factory);
/* 1055 */             param4MethodVisitor.visitCode();
/* 1056 */             ByteCodeAppender.Size size = applyCode(param4MethodVisitor, param4Context);
/* 1057 */             param4MethodVisitor.visitMaxs(size.getOperandStackSize(), size.getLocalVariableSize());
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void applyAttributes(MethodVisitor param4MethodVisitor, AnnotationValueFilter.Factory param4Factory) {
/* 1064 */             this.attributeAppender.apply(param4MethodVisitor, this.visibilityBridge, param4Factory.on(this.visibilityBridge));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public ByteCodeAppender.Size applyCode(MethodVisitor param4MethodVisitor, Implementation.Context param4Context) {
/* 1071 */             return apply(param4MethodVisitor, param4Context, this.visibilityBridge);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public ByteCodeAppender.Size apply(MethodVisitor param4MethodVisitor, Implementation.Context param4Context, MethodDescription param4MethodDescription) {
/* 1078 */             return (new ByteCodeAppender.Simple(new StackManipulation[] {
/* 1079 */                   MethodVariableAccess.allArgumentsOf(param4MethodDescription).prependThisReference(), 
/* 1080 */                   MethodInvocation.invoke(this.bridgeTarget).special(this.bridgeType), 
/* 1081 */                   MethodReturn.of((TypeDefinition)param4MethodDescription.getReturnType())
/* 1082 */                 })).apply(param4MethodVisitor, param4Context, param4MethodDescription);
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.visibilityBridge.equals(((OfVisibilityBridge)param4Object).visibilityBridge) ? false : (!this.bridgeTarget.equals(((OfVisibilityBridge)param4Object).bridgeTarget) ? false : (!this.bridgeType.equals(((OfVisibilityBridge)param4Object).bridgeType) ? false : (!!this.attributeAppender.equals(((OfVisibilityBridge)param4Object).attributeAppender)))))));
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return (((getClass().hashCode() * 31 + this.visibilityBridge.hashCode()) * 31 + this.bridgeTarget.hashCode()) * 31 + this.bridgeType.hashCode()) * 31 + this.attributeAppender.hashCode();
/*      */           }
/*      */ 
/*      */           
/*      */           protected static class VisibilityBridge
/*      */             extends MethodDescription.InDefinedShape.AbstractBase
/*      */           {
/*      */             private final TypeDescription instrumentedType;
/*      */             
/*      */             private final MethodDescription bridgeTarget;
/*      */ 
/*      */             
/*      */             protected VisibilityBridge(TypeDescription param5TypeDescription, MethodDescription param5MethodDescription) {
/* 1107 */               this.instrumentedType = param5TypeDescription;
/* 1108 */               this.bridgeTarget = param5MethodDescription;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeDescription getDeclaringType() {
/* 1116 */               return this.instrumentedType;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
/* 1123 */               return (ParameterList<ParameterDescription.InDefinedShape>)new ParameterList.Explicit.ForTypes((MethodDescription.InDefinedShape)this, (List)this.bridgeTarget.getParameters().asTypeList().asRawTypes());
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeDescription.Generic getReturnType() {
/* 1130 */               return this.bridgeTarget.getReturnType().asRawType();
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeList.Generic getExceptionTypes() {
/* 1137 */               return this.bridgeTarget.getExceptionTypes().asRawTypes();
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             @MaybeNull
/*      */             public AnnotationValue<?, ?> getDefaultValue() {
/* 1145 */               return AnnotationValue.UNDEFINED;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public TypeList.Generic getTypeVariables() {
/* 1152 */               return (TypeList.Generic)new TypeList.Generic.Empty();
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public AnnotationList getDeclaredAnnotations() {
/* 1159 */               return this.bridgeTarget.getDeclaredAnnotations();
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public int getModifiers() {
/* 1166 */               return (this.bridgeTarget.getModifiers() | 0x1000 | 0x40) & 0xFFFFFEFF;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public String getInternalName() {
/* 1173 */               return this.bridgeTarget.getName();
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class AccessBridgeWrapper
/*      */         implements Record
/*      */       {
/*      */         private final TypeWriter.MethodPool.Record delegate;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final MethodDescription bridgeTarget;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Set<MethodDescription.TypeToken> bridgeTypes;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final MethodAttributeAppender attributeAppender;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected AccessBridgeWrapper(TypeWriter.MethodPool.Record param3Record, TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Set<MethodDescription.TypeToken> param3Set, MethodAttributeAppender param3MethodAttributeAppender) {
/* 1226 */           this.delegate = param3Record;
/* 1227 */           this.instrumentedType = param3TypeDescription;
/* 1228 */           this.bridgeTarget = param3MethodDescription;
/* 1229 */           this.bridgeTypes = param3Set;
/* 1230 */           this.attributeAppender = param3MethodAttributeAppender;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public static TypeWriter.MethodPool.Record of(TypeWriter.MethodPool.Record param3Record, TypeDescription param3TypeDescription, MethodDescription param3MethodDescription, Set<MethodDescription.TypeToken> param3Set, MethodAttributeAppender param3MethodAttributeAppender) {
/* 1248 */           HashSet<MethodDescription.TypeToken> hashSet = new HashSet();
/* 1249 */           for (MethodDescription.TypeToken typeToken : param3Set) {
/* 1250 */             if (param3MethodDescription.isBridgeCompatible(typeToken)) {
/* 1251 */               hashSet.add(typeToken);
/*      */             }
/*      */           } 
/* 1254 */           return (hashSet.isEmpty() || (param3TypeDescription.isInterface() && !param3Record.getSort().isImplemented())) ? param3Record : new AccessBridgeWrapper(param3Record, param3TypeDescription, param3MethodDescription, hashSet, param3MethodAttributeAppender);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeWriter.MethodPool.Record.Sort getSort() {
/* 1263 */           return this.delegate.getSort();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public MethodDescription getMethod() {
/* 1270 */           return this.bridgeTarget;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Visibility getVisibility() {
/* 1277 */           return this.delegate.getVisibility();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeWriter.MethodPool.Record prepend(ByteCodeAppender param3ByteCodeAppender) {
/* 1284 */           return new AccessBridgeWrapper(this.delegate.prepend(param3ByteCodeAppender), this.instrumentedType, this.bridgeTarget, this.bridgeTypes, this.attributeAppender);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void apply(ClassVisitor param3ClassVisitor, Implementation.Context param3Context, AnnotationValueFilter.Factory param3Factory) {
/* 1293 */           this.delegate.apply(param3ClassVisitor, param3Context, param3Factory);
/* 1294 */           for (MethodDescription.TypeToken typeToken : this.bridgeTypes) {
/* 1295 */             AccessorBridge accessorBridge = new AccessorBridge(this.bridgeTarget, typeToken, this.instrumentedType);
/* 1296 */             BridgeTarget bridgeTarget = new BridgeTarget(this.bridgeTarget, this.instrumentedType);
/*      */ 
/*      */             
/*      */             MethodVisitor methodVisitor;
/*      */ 
/*      */             
/* 1302 */             if ((methodVisitor = param3ClassVisitor.visitMethod(accessorBridge.getActualModifiers(true, getVisibility()), accessorBridge.getInternalName(), accessorBridge.getDescriptor(), MethodDescription.NON_GENERIC_SIGNATURE, accessorBridge.getExceptionTypes().asErasures().toInternalNames())) != null) {
/* 1303 */               this.attributeAppender.apply(methodVisitor, (MethodDescription)accessorBridge, param3Factory.on(this.instrumentedType));
/* 1304 */               methodVisitor.visitCode();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1312 */               ByteCodeAppender.Size size = (new ByteCodeAppender.Simple(new StackManipulation[] { MethodVariableAccess.allArgumentsOf((MethodDescription)accessorBridge).asBridgeOf((MethodDescription)bridgeTarget).prependThisReference(), MethodInvocation.invoke((MethodDescription.InDefinedShape)bridgeTarget).virtual(this.instrumentedType), bridgeTarget.getReturnType().asErasure().isAssignableTo(accessorBridge.getReturnType().asErasure()) ? (StackManipulation)StackManipulation.Trivial.INSTANCE : TypeCasting.to((TypeDefinition)accessorBridge.getReturnType().asErasure()), MethodReturn.of((TypeDefinition)accessorBridge.getReturnType()) })).apply(methodVisitor, param3Context, (MethodDescription)accessorBridge);
/* 1313 */               methodVisitor.visitMaxs(size.getOperandStackSize(), size.getLocalVariableSize());
/* 1314 */               methodVisitor.visitEnd();
/*      */             } 
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void applyHead(MethodVisitor param3MethodVisitor) {
/* 1323 */           this.delegate.applyHead(param3MethodVisitor);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void applyBody(MethodVisitor param3MethodVisitor, Implementation.Context param3Context, AnnotationValueFilter.Factory param3Factory) {
/* 1332 */           this.delegate.applyBody(param3MethodVisitor, param3Context, param3Factory);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void applyAttributes(MethodVisitor param3MethodVisitor, AnnotationValueFilter.Factory param3Factory) {
/* 1339 */           this.delegate.applyAttributes(param3MethodVisitor, param3Factory);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ByteCodeAppender.Size applyCode(MethodVisitor param3MethodVisitor, Implementation.Context param3Context) {
/* 1346 */           return this.delegate.applyCode(param3MethodVisitor, param3Context);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.delegate.equals(((AccessBridgeWrapper)param3Object).delegate) ? false : (!this.instrumentedType.equals(((AccessBridgeWrapper)param3Object).instrumentedType) ? false : (!this.bridgeTarget.equals(((AccessBridgeWrapper)param3Object).bridgeTarget) ? false : (!this.bridgeTypes.equals(((AccessBridgeWrapper)param3Object).bridgeTypes) ? false : (!!this.attributeAppender.equals(((AccessBridgeWrapper)param3Object).attributeAppender))))))));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return ((((getClass().hashCode() * 31 + this.delegate.hashCode()) * 31 + this.instrumentedType.hashCode()) * 31 + this.bridgeTarget.hashCode()) * 31 + this.bridgeTypes.hashCode()) * 31 + this.attributeAppender.hashCode();
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         protected static class AccessorBridge
/*      */           extends MethodDescription.InDefinedShape.AbstractBase
/*      */         {
/*      */           private final MethodDescription bridgeTarget;
/*      */ 
/*      */           
/*      */           private final MethodDescription.TypeToken bridgeType;
/*      */ 
/*      */           
/*      */           private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */           
/*      */           protected AccessorBridge(MethodDescription param4MethodDescription, MethodDescription.TypeToken param4TypeToken, TypeDescription param4TypeDescription) {
/* 1377 */             this.bridgeTarget = param4MethodDescription;
/* 1378 */             this.bridgeType = param4TypeToken;
/* 1379 */             this.instrumentedType = param4TypeDescription;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription getDeclaringType() {
/* 1387 */             return this.instrumentedType;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
/* 1394 */             return (ParameterList<ParameterDescription.InDefinedShape>)new ParameterList.Explicit.ForTypes((MethodDescription.InDefinedShape)this, this.bridgeType.getParameterTypes());
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription.Generic getReturnType() {
/* 1401 */             return this.bridgeType.getReturnType().asGenericType();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeList.Generic getExceptionTypes() {
/* 1408 */             return this.bridgeTarget.getExceptionTypes().accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.TypeErasing.INSTANCE);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           public AnnotationValue<?, ?> getDefaultValue() {
/* 1416 */             return AnnotationValue.UNDEFINED;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeList.Generic getTypeVariables() {
/* 1423 */             return (TypeList.Generic)new TypeList.Generic.Empty();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public AnnotationList getDeclaredAnnotations() {
/* 1430 */             return (AnnotationList)new AnnotationList.Empty();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int getModifiers() {
/* 1437 */             return (this.bridgeTarget.getModifiers() | 0x40 | 0x1000) & 0xFFFFFAFF;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public String getInternalName() {
/* 1444 */             return this.bridgeTarget.getInternalName();
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected static class BridgeTarget
/*      */           extends MethodDescription.InDefinedShape.AbstractBase
/*      */         {
/*      */           private final MethodDescription bridgeTarget;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected BridgeTarget(MethodDescription param4MethodDescription, TypeDescription param4TypeDescription) {
/* 1470 */             this.bridgeTarget = param4MethodDescription;
/* 1471 */             this.instrumentedType = param4TypeDescription;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription getDeclaringType() {
/* 1479 */             return this.instrumentedType;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
/* 1486 */             return (ParameterList<ParameterDescription.InDefinedShape>)new ParameterList.ForTokens((MethodDescription.InDefinedShape)this, (List)this.bridgeTarget.getParameters().asTokenList((ElementMatcher)ElementMatchers.is(this.instrumentedType)));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeDescription.Generic getReturnType() {
/* 1493 */             return this.bridgeTarget.getReturnType();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeList.Generic getExceptionTypes() {
/* 1500 */             return this.bridgeTarget.getExceptionTypes();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           public AnnotationValue<?, ?> getDefaultValue() {
/* 1508 */             return this.bridgeTarget.getDefaultValue();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public TypeList.Generic getTypeVariables() {
/* 1515 */             return this.bridgeTarget.getTypeVariables();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public AnnotationList getDeclaredAnnotations() {
/* 1522 */             return this.bridgeTarget.getDeclaredAnnotations();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int getModifiers() {
/* 1529 */             return this.bridgeTarget.getModifiers();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public String getInternalName() {
/* 1536 */             return this.bridgeTarget.getInternalName();
/*      */           }
/*      */         }
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
/*      */   public static interface RecordComponentPool
/*      */   {
/*      */     Record target(RecordComponentDescription param1RecordComponentDescription);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static interface Record
/*      */     {
/*      */       boolean isImplicit();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       RecordComponentDescription getRecordComponent();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       RecordComponentAttributeAppender getRecordComponentAppender();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void apply(ClassVisitor param2ClassVisitor, AnnotationValueFilter.Factory param2Factory);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void apply(RecordComponentVisitor param2RecordComponentVisitor, AnnotationValueFilter.Factory param2Factory);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class ForImplicitRecordComponent
/*      */         implements Record
/*      */       {
/*      */         private final RecordComponentDescription recordComponentDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ForImplicitRecordComponent(RecordComponentDescription param3RecordComponentDescription) {
/* 1617 */           this.recordComponentDescription = param3RecordComponentDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean isImplicit() {
/* 1624 */           return true;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public RecordComponentDescription getRecordComponent() {
/* 1631 */           return this.recordComponentDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public RecordComponentAttributeAppender getRecordComponentAppender() {
/* 1638 */           throw new IllegalStateException("An implicit field record does not expose a field appender: " + this);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void apply(ClassVisitor param3ClassVisitor, AnnotationValueFilter.Factory param3Factory) {
/*      */           RecordComponentVisitor recordComponentVisitor;
/* 1648 */           if ((recordComponentVisitor = param3ClassVisitor.visitRecordComponent(this.recordComponentDescription.getActualName(), this.recordComponentDescription.getDescriptor(), this.recordComponentDescription.getGenericSignature())) != null) {
/* 1649 */             RecordComponentAttributeAppender.ForInstrumentedRecordComponent.INSTANCE.apply(recordComponentVisitor, this.recordComponentDescription, param3Factory
/*      */                 
/* 1651 */                 .on(this.recordComponentDescription));
/* 1652 */             recordComponentVisitor.visitEnd();
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void apply(RecordComponentVisitor param3RecordComponentVisitor, AnnotationValueFilter.Factory param3Factory) {
/* 1660 */           throw new IllegalStateException("An implicit field record is not intended for partial application: " + this);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.recordComponentDescription.equals(((ForImplicitRecordComponent)param3Object).recordComponentDescription))));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.recordComponentDescription.hashCode();
/*      */         }
/*      */       }
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class ForExplicitRecordComponent
/*      */         implements Record
/*      */       {
/*      */         private final RecordComponentAttributeAppender attributeAppender;
/*      */         
/*      */         private final RecordComponentDescription recordComponentDescription;
/*      */ 
/*      */         
/*      */         public ForExplicitRecordComponent(RecordComponentAttributeAppender param3RecordComponentAttributeAppender, RecordComponentDescription param3RecordComponentDescription) {
/* 1687 */           this.attributeAppender = param3RecordComponentAttributeAppender;
/* 1688 */           this.recordComponentDescription = param3RecordComponentDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean isImplicit() {
/* 1695 */           return false;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public RecordComponentDescription getRecordComponent() {
/* 1702 */           return this.recordComponentDescription;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public RecordComponentAttributeAppender getRecordComponentAppender() {
/* 1709 */           return this.attributeAppender;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void apply(ClassVisitor param3ClassVisitor, AnnotationValueFilter.Factory param3Factory) {
/*      */           RecordComponentVisitor recordComponentVisitor;
/* 1719 */           if ((recordComponentVisitor = param3ClassVisitor.visitRecordComponent(this.recordComponentDescription.getActualName(), this.recordComponentDescription.getDescriptor(), this.recordComponentDescription.getGenericSignature())) != null) {
/* 1720 */             this.attributeAppender.apply(recordComponentVisitor, this.recordComponentDescription, param3Factory.on(this.recordComponentDescription));
/* 1721 */             recordComponentVisitor.visitEnd();
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void apply(RecordComponentVisitor param3RecordComponentVisitor, AnnotationValueFilter.Factory param3Factory) {
/* 1729 */           this.attributeAppender.apply(param3RecordComponentVisitor, this.recordComponentDescription, param3Factory.on(this.recordComponentDescription));
/*      */         }
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.attributeAppender.equals(((ForExplicitRecordComponent)param3Object).attributeAppender) ? false : (!!this.recordComponentDescription.equals(((ForExplicitRecordComponent)param3Object).recordComponentDescription)))));
/*      */         }
/*      */         
/*      */         public int hashCode() {
/*      */           return (getClass().hashCode() * 31 + this.attributeAppender.hashCode()) * 31 + this.recordComponentDescription.hashCode();
/*      */         } }
/*      */     }
/*      */     
/*      */     public enum Disabled implements RecordComponentPool {
/* 1742 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final TypeWriter.RecordComponentPool.Record target(RecordComponentDescription param2RecordComponentDescription) {
/* 1748 */         throw new IllegalStateException("Cannot look up record component from disabled pool");
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
/*      */   @Enhance
/*      */   public static abstract class Default<S>
/*      */     implements TypeWriter<S>
/*      */   {
/*      */     @AlwaysNull
/* 1765 */     private static final String NO_REFERENCE = null; @MaybeNull
/*      */     protected static final String DUMP_FOLDER; protected final TypeDescription instrumentedType; protected final ClassFileVersion classFileVersion; protected final TypeWriter.FieldPool fieldPool; protected final TypeWriter.RecordComponentPool recordComponentPool; protected final List<? extends DynamicType> auxiliaryTypes; protected final FieldList<FieldDescription.InDefinedShape> fields; protected final MethodList<?> methods; protected final MethodList<?> instrumentedMethods; protected final RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponents; protected final LoadedTypeInitializer loadedTypeInitializer; protected final TypeInitializer typeInitializer;
/*      */     protected final TypeAttributeAppender typeAttributeAppender;
/*      */     protected final AsmVisitorWrapper asmVisitorWrapper;
/*      */     protected final AnnotationValueFilter.Factory annotationValueFilterFactory;
/*      */     protected final AnnotationRetention annotationRetention;
/*      */     protected final AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy;
/*      */     protected final Implementation.Context.Factory implementationContextFactory;
/*      */     protected final TypeValidation typeValidation;
/*      */     protected final ClassWriterStrategy classWriterStrategy;
/*      */     protected final TypePool typePool;
/*      */     private static final boolean ACCESS_CONTROLLER;
/*      */     
/*      */     static { try {
/* 1779 */         str = doPrivileged((PrivilegedAction<String>)new GetSystemPropertyAction("net.bytebuddy.dump"));
/* 1780 */       } catch (RuntimeException runtimeException) {
/* 1781 */         str = null;
/*      */       } 
/* 1783 */       DUMP_FOLDER = str; } static { String str; 
/* 1784 */       try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Default(TypeDescription param1TypeDescription, ClassFileVersion param1ClassFileVersion, TypeWriter.FieldPool param1FieldPool, TypeWriter.RecordComponentPool param1RecordComponentPool, List<? extends DynamicType> param1List, FieldList<FieldDescription.InDefinedShape> param1FieldList, MethodList<?> param1MethodList1, MethodList<?> param1MethodList2, RecordComponentList<RecordComponentDescription.InDefinedShape> param1RecordComponentList, LoadedTypeInitializer param1LoadedTypeInitializer, TypeInitializer param1TypeInitializer, TypeAttributeAppender param1TypeAttributeAppender, AsmVisitorWrapper param1AsmVisitorWrapper, AnnotationValueFilter.Factory param1Factory, AnnotationRetention param1AnnotationRetention, AuxiliaryType.NamingStrategy param1NamingStrategy, Implementation.Context.Factory param1Factory1, TypeValidation param1TypeValidation, ClassWriterStrategy param1ClassWriterStrategy, TypePool param1TypePool) {
/* 1930 */       this.instrumentedType = param1TypeDescription;
/* 1931 */       this.classFileVersion = param1ClassFileVersion;
/* 1932 */       this.fieldPool = param1FieldPool;
/* 1933 */       this.recordComponentPool = param1RecordComponentPool;
/* 1934 */       this.auxiliaryTypes = param1List;
/* 1935 */       this.fields = param1FieldList;
/* 1936 */       this.methods = param1MethodList1;
/* 1937 */       this.instrumentedMethods = param1MethodList2;
/* 1938 */       this.recordComponents = param1RecordComponentList;
/* 1939 */       this.loadedTypeInitializer = param1LoadedTypeInitializer;
/* 1940 */       this.typeInitializer = param1TypeInitializer;
/* 1941 */       this.typeAttributeAppender = param1TypeAttributeAppender;
/* 1942 */       this.asmVisitorWrapper = param1AsmVisitorWrapper;
/* 1943 */       this.auxiliaryTypeNamingStrategy = param1NamingStrategy;
/* 1944 */       this.annotationValueFilterFactory = param1Factory;
/* 1945 */       this.annotationRetention = param1AnnotationRetention;
/* 1946 */       this.implementationContextFactory = param1Factory1;
/* 1947 */       this.typeValidation = param1TypeValidation;
/* 1948 */       this.classWriterStrategy = param1ClassWriterStrategy;
/* 1949 */       this.typePool = param1TypePool;
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
/* 1961 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedAction) : param1PrivilegedAction.run();
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
/*      */     private static <T> T doPrivileged(PrivilegedExceptionAction<T> param1PrivilegedExceptionAction) {
/* 1974 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedExceptionAction) : param1PrivilegedExceptionAction.run();
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
/*      */     public static <U> TypeWriter<U> forCreation(MethodRegistry.Compiled param1Compiled, List<? extends DynamicType> param1List, TypeWriter.FieldPool param1FieldPool, TypeWriter.RecordComponentPool param1RecordComponentPool, TypeAttributeAppender param1TypeAttributeAppender, AsmVisitorWrapper param1AsmVisitorWrapper, ClassFileVersion param1ClassFileVersion, AnnotationValueFilter.Factory param1Factory, AnnotationRetention param1AnnotationRetention, AuxiliaryType.NamingStrategy param1NamingStrategy, Implementation.Context.Factory param1Factory1, TypeValidation param1TypeValidation, ClassWriterStrategy param1ClassWriterStrategy, TypePool param1TypePool) {
/* 2011 */       return new ForCreation<U>(param1Compiled.getInstrumentedType(), param1ClassFileVersion, param1FieldPool, param1Compiled, param1RecordComponentPool, param1List, param1Compiled
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2017 */           .getInstrumentedType().getDeclaredFields(), param1Compiled
/* 2018 */           .getMethods(), param1Compiled
/* 2019 */           .getInstrumentedMethods(), param1Compiled
/* 2020 */           .getInstrumentedType().getRecordComponents(), param1Compiled
/* 2021 */           .getLoadedTypeInitializer(), param1Compiled
/* 2022 */           .getTypeInitializer(), param1TypeAttributeAppender, param1AsmVisitorWrapper, param1Factory, param1AnnotationRetention, param1NamingStrategy, param1Factory1, param1TypeValidation, param1ClassWriterStrategy, param1TypePool);
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
/*      */     public static <U> TypeWriter<U> forRedefinition(MethodRegistry.Prepared param1Prepared, List<? extends DynamicType> param1List, TypeWriter.FieldPool param1FieldPool, TypeWriter.RecordComponentPool param1RecordComponentPool, TypeAttributeAppender param1TypeAttributeAppender, AsmVisitorWrapper param1AsmVisitorWrapper, ClassFileVersion param1ClassFileVersion, AnnotationValueFilter.Factory param1Factory, AnnotationRetention param1AnnotationRetention, AuxiliaryType.NamingStrategy param1NamingStrategy, Implementation.Context.Factory param1Factory1, TypeValidation param1TypeValidation, ClassWriterStrategy param1ClassWriterStrategy, TypePool param1TypePool, TypeDescription param1TypeDescription, ClassFileLocator param1ClassFileLocator) {
/* 2072 */       return new ForInlining.WithFullProcessing<U>(param1Prepared.getInstrumentedType(), param1ClassFileVersion, param1FieldPool, param1RecordComponentPool, param1List, param1Prepared
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2077 */           .getInstrumentedType().getDeclaredFields(), param1Prepared
/* 2078 */           .getMethods(), param1Prepared
/* 2079 */           .getInstrumentedMethods(), param1Prepared
/* 2080 */           .getInstrumentedType().getRecordComponents(), param1Prepared
/* 2081 */           .getLoadedTypeInitializer(), param1Prepared
/* 2082 */           .getTypeInitializer(), param1TypeAttributeAppender, param1AsmVisitorWrapper, param1Factory, param1AnnotationRetention, param1NamingStrategy, param1Factory1, param1TypeValidation, param1ClassWriterStrategy, param1TypePool, param1TypeDescription, param1ClassFileLocator, param1Prepared, (Implementation.Target.Factory)SubclassImplementationTarget.Factory.LEVEL_TYPE, (MethodRebaseResolver)MethodRebaseResolver.Disabled.INSTANCE);
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
/*      */     public static <U> TypeWriter<U> forRebasing(MethodRegistry.Prepared param1Prepared, List<? extends DynamicType> param1List, TypeWriter.FieldPool param1FieldPool, TypeWriter.RecordComponentPool param1RecordComponentPool, TypeAttributeAppender param1TypeAttributeAppender, AsmVisitorWrapper param1AsmVisitorWrapper, ClassFileVersion param1ClassFileVersion, AnnotationValueFilter.Factory param1Factory, AnnotationRetention param1AnnotationRetention, AuxiliaryType.NamingStrategy param1NamingStrategy, Implementation.Context.Factory param1Factory1, TypeValidation param1TypeValidation, ClassWriterStrategy param1ClassWriterStrategy, TypePool param1TypePool, TypeDescription param1TypeDescription, ClassFileLocator param1ClassFileLocator, MethodRebaseResolver param1MethodRebaseResolver) {
/* 2139 */       return new ForInlining.WithFullProcessing<U>(param1Prepared.getInstrumentedType(), param1ClassFileVersion, param1FieldPool, param1RecordComponentPool, 
/*      */ 
/*      */ 
/*      */           
/* 2143 */           CompoundList.of(param1List, param1MethodRebaseResolver.getAuxiliaryTypes()), param1Prepared
/* 2144 */           .getInstrumentedType().getDeclaredFields(), param1Prepared
/* 2145 */           .getMethods(), param1Prepared
/* 2146 */           .getInstrumentedMethods(), param1Prepared
/* 2147 */           .getInstrumentedType().getRecordComponents(), param1Prepared
/* 2148 */           .getLoadedTypeInitializer(), param1Prepared
/* 2149 */           .getTypeInitializer(), param1TypeAttributeAppender, param1AsmVisitorWrapper, param1Factory, param1AnnotationRetention, param1NamingStrategy, param1Factory1, param1TypeValidation, param1ClassWriterStrategy, param1TypePool, param1TypeDescription, param1ClassFileLocator, param1Prepared, (Implementation.Target.Factory)new RebaseImplementationTarget.Factory(param1MethodRebaseResolver), param1MethodRebaseResolver);
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
/*      */     public static <U> TypeWriter<U> forDecoration(TypeDescription param1TypeDescription, ClassFileVersion param1ClassFileVersion, List<? extends DynamicType> param1List, List<? extends MethodDescription> param1List1, TypeAttributeAppender param1TypeAttributeAppender, AsmVisitorWrapper param1AsmVisitorWrapper, AnnotationValueFilter.Factory param1Factory, AnnotationRetention param1AnnotationRetention, AuxiliaryType.NamingStrategy param1NamingStrategy, Implementation.Context.Factory param1Factory1, TypeValidation param1TypeValidation, ClassWriterStrategy param1ClassWriterStrategy, TypePool param1TypePool, ClassFileLocator param1ClassFileLocator) {
/* 2200 */       return new ForInlining.WithDecorationOnly<U>(param1TypeDescription, param1ClassFileVersion, param1List, (MethodList<?>)new MethodList.Explicit(param1List1), param1TypeAttributeAppender, param1AsmVisitorWrapper, param1Factory, param1AnnotationRetention, param1NamingStrategy, param1Factory1, param1TypeValidation, param1ClassWriterStrategy, param1TypePool, param1ClassFileLocator);
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
/*      */     @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Setting a debugging property should never change the program outcome.")
/*      */     public DynamicType.Unloaded<S> make(TypeResolutionStrategy.Resolved param1Resolved) {
/* 2223 */       ClassDumpAction.Dispatcher dispatcher = (ClassDumpAction.Dispatcher)((DUMP_FOLDER == null) ? ClassDumpAction.Dispatcher.Disabled.INSTANCE : new ClassDumpAction.Dispatcher.Enabled(DUMP_FOLDER, System.currentTimeMillis()));
/* 2224 */       UnresolvedType unresolvedType = create(param1Resolved.injectedInto(this.typeInitializer), dispatcher);
/* 2225 */       dispatcher.dump(this.instrumentedType, false, unresolvedType.getBinaryRepresentation());
/* 2226 */       return unresolvedType.toDynamicType(param1Resolved);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected abstract UnresolvedType create(TypeInitializer param1TypeInitializer, ClassDumpAction.Dispatcher param1Dispatcher);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.annotationRetention.equals(((Default)param1Object).annotationRetention) ? false : (!this.typeValidation.equals(((Default)param1Object).typeValidation) ? false : (!this.instrumentedType.equals(((Default)param1Object).instrumentedType) ? false : (!this.classFileVersion.equals(((Default)param1Object).classFileVersion) ? false : (!this.fieldPool.equals(((Default)param1Object).fieldPool) ? false : (!this.recordComponentPool.equals(((Default)param1Object).recordComponentPool) ? false : (!this.auxiliaryTypes.equals(((Default)param1Object).auxiliaryTypes) ? false : (!this.fields.equals(((Default)param1Object).fields) ? false : (!this.methods.equals(((Default)param1Object).methods) ? false : (!this.instrumentedMethods.equals(((Default)param1Object).instrumentedMethods) ? false : (!this.recordComponents.equals(((Default)param1Object).recordComponents) ? false : (!this.loadedTypeInitializer.equals(((Default)param1Object).loadedTypeInitializer) ? false : (!this.typeInitializer.equals(((Default)param1Object).typeInitializer) ? false : (!this.typeAttributeAppender.equals(((Default)param1Object).typeAttributeAppender) ? false : (!this.asmVisitorWrapper.equals(((Default)param1Object).asmVisitorWrapper) ? false : (!this.annotationValueFilterFactory.equals(((Default)param1Object).annotationValueFilterFactory) ? false : (!this.auxiliaryTypeNamingStrategy.equals(((Default)param1Object).auxiliaryTypeNamingStrategy) ? false : (!this.implementationContextFactory.equals(((Default)param1Object).implementationContextFactory) ? false : (!this.classWriterStrategy.equals(((Default)param1Object).classWriterStrategy) ? false : (!!this.typePool.equals(((Default)param1Object).typePool)))))))))))))))))))))));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return (((((((((((((((((((getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.classFileVersion.hashCode()) * 31 + this.fieldPool.hashCode()) * 31 + this.recordComponentPool.hashCode()) * 31 + this.auxiliaryTypes.hashCode()) * 31 + this.fields.hashCode()) * 31 + this.methods.hashCode()) * 31 + this.instrumentedMethods.hashCode()) * 31 + this.recordComponents.hashCode()) * 31 + this.loadedTypeInitializer.hashCode()) * 31 + this.typeInitializer.hashCode()) * 31 + this.typeAttributeAppender.hashCode()) * 31 + this.asmVisitorWrapper.hashCode()) * 31 + this.annotationValueFilterFactory.hashCode()) * 31 + this.annotationRetention.hashCode()) * 31 + this.auxiliaryTypeNamingStrategy.hashCode()) * 31 + this.implementationContextFactory.hashCode()) * 31 + this.typeValidation.hashCode()) * 31 + this.classWriterStrategy.hashCode()) * 31 + this.typePool.hashCode();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance(includeSyntheticFields = true)
/*      */     protected class UnresolvedType
/*      */     {
/*      */       private final byte[] binaryRepresentation;
/*      */ 
/*      */       
/*      */       private final List<? extends DynamicType> auxiliaryTypes;
/*      */ 
/*      */ 
/*      */       
/*      */       protected UnresolvedType(TypeWriter.Default this$0, byte[] param2ArrayOfbyte, List<? extends DynamicType> param2List) {
/* 2261 */         this.binaryRepresentation = param2ArrayOfbyte;
/* 2262 */         this.auxiliaryTypes = param2List;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected DynamicType.Unloaded<S> toDynamicType(TypeResolutionStrategy.Resolved param2Resolved) {
/* 2272 */         return (DynamicType.Unloaded<S>)new DynamicType.Default.Unloaded(this.a.instrumentedType, this.binaryRepresentation, this.a.loadedTypeInitializer, 
/*      */ 
/*      */             
/* 2275 */             CompoundList.of(this.a.auxiliaryTypes, this.auxiliaryTypes), param2Resolved);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected byte[] getBinaryRepresentation() {
/* 2285 */         return this.binaryRepresentation;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!Arrays.equals(this.binaryRepresentation, ((UnresolvedType)param2Object).binaryRepresentation) ? false : (!this.auxiliaryTypes.equals(((UnresolvedType)param2Object).auxiliaryTypes) ? false : (!!this.a.equals(((UnresolvedType)param2Object).a))))));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return ((getClass().hashCode() * 31 + Arrays.hashCode(this.binaryRepresentation)) * 31 + this.auxiliaryTypes.hashCode()) * 31 + this.a.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected static class SignatureKey
/*      */     {
/*      */       private final String internalName;
/*      */       
/*      */       private final String descriptor;
/*      */ 
/*      */       
/*      */       public SignatureKey(String param2String1, String param2String2) {
/* 2311 */         this.internalName = param2String1;
/* 2312 */         this.descriptor = param2String2;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/* 2317 */         if (this == param2Object) return true; 
/* 2318 */         if (param2Object == null || getClass() != param2Object.getClass()) return false; 
/* 2319 */         param2Object = param2Object;
/* 2320 */         return (this.internalName.equals(((SignatureKey)param2Object).internalName) && this.descriptor.equals(((SignatureKey)param2Object).descriptor));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/* 2325 */         return 17 + this.internalName.hashCode() + 31 * this.descriptor.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static class ValidatingClassVisitor
/*      */       extends ClassVisitor
/*      */     {
/*      */       private static final String NO_PARAMETERS = "()";
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private static final String RETURNS_VOID = "V";
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private static final String STRING_DESCRIPTOR = "Ljava/lang/String;";
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @AlwaysNull
/* 2353 */       private static final FieldVisitor IGNORE_FIELD = null;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @AlwaysNull
/* 2359 */       private static final MethodVisitor IGNORE_METHOD = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @UnknownNull
/*      */       private Constraint constraint;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected ValidatingClassVisitor(ClassVisitor param2ClassVisitor) {
/* 2373 */         super(OpenedClassReader.ASM_API, param2ClassVisitor);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static ClassVisitor of(ClassVisitor param2ClassVisitor, TypeValidation param2TypeValidation) {
/* 2384 */         return param2TypeValidation.isEnabled() ? new ValidatingClassVisitor(param2ClassVisitor) : param2ClassVisitor;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public void visit(int param2Int1, int param2Int2, String param2String1, @MaybeNull String param2String2, @MaybeNull String param2String3, @MaybeNull String[] param2ArrayOfString) {
/*      */         boolean bool;
/* 2391 */         ClassFileVersion classFileVersion = ClassFileVersion.ofMinorMajor(param2Int1);
/*      */         ArrayList<Constraint.ForClassFileVersion> arrayList;
/* 2393 */         (arrayList = new ArrayList<Constraint.ForClassFileVersion>()).add(new Constraint.ForClassFileVersion(classFileVersion));
/* 2394 */         if (param2String1.endsWith("/package-info")) {
/* 2395 */           arrayList.add(Constraint.ForPackageType.INSTANCE);
/* 2396 */         } else if ((param2Int2 & 0x2000) != 0) {
/* 2397 */           if (!classFileVersion.isAtLeast(ClassFileVersion.JAVA_V5)) {
/* 2398 */             throw new IllegalStateException("Cannot define an annotation type for class file version " + classFileVersion);
/*      */           }
/* 2400 */           arrayList.add(classFileVersion.isAtLeast(ClassFileVersion.JAVA_V8) ? Constraint.ForAnnotation.JAVA_8 : Constraint.ForAnnotation.CLASSIC);
/*      */         
/*      */         }
/* 2403 */         else if ((param2Int2 & 0x200) != 0) {
/* 2404 */           arrayList.add(classFileVersion.isAtLeast(ClassFileVersion.JAVA_V8) ? Constraint.ForInterface.JAVA_8 : Constraint.ForInterface.CLASSIC);
/*      */         
/*      */         }
/* 2407 */         else if ((param2Int2 & 0x400) != 0) {
/* 2408 */           arrayList.add(Constraint.ForClass.ABSTRACT);
/*      */         } else {
/* 2410 */           arrayList.add(Constraint.ForClass.MANIFEST);
/*      */         } 
/*      */         
/* 2413 */         if ((param2Int2 & 0x10000) != 0) {
/* 2414 */           arrayList.add(Constraint.ForRecord.INSTANCE);
/* 2415 */           bool = true;
/*      */         } else {
/* 2417 */           bool = false;
/*      */         } 
/* 2419 */         this.constraint = new Constraint.Compound((List)arrayList);
/* 2420 */         this.constraint.assertType(param2Int2, (param2ArrayOfString != null), (param2String2 != null));
/* 2421 */         if (bool) {
/* 2422 */           this.constraint.assertRecord();
/*      */         }
/* 2424 */         super.visit(param2Int1, param2Int2, param2String1, param2String2, param2String3, param2ArrayOfString);
/*      */       }
/*      */ 
/*      */       
/*      */       public void visitPermittedSubclass(String param2String) {
/* 2429 */         this.constraint.assertPermittedSubclass();
/* 2430 */         super.visitPermittedSubclass(param2String);
/*      */       }
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       public AnnotationVisitor visitAnnotation(String param2String, boolean param2Boolean) {
/* 2436 */         this.constraint.assertAnnotation();
/* 2437 */         return super.visitAnnotation(param2String, param2Boolean);
/*      */       }
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       public AnnotationVisitor visitTypeAnnotation(int param2Int, @MaybeNull TypePath param2TypePath, String param2String, boolean param2Boolean) {
/* 2443 */         this.constraint.assertTypeAnnotation();
/* 2444 */         return super.visitTypeAnnotation(param2Int, param2TypePath, param2String, param2Boolean);
/*      */       }
/*      */ 
/*      */       
/*      */       public void visitNestHost(String param2String) {
/* 2449 */         this.constraint.assertNestMate();
/* 2450 */         super.visitNestHost(param2String);
/*      */       }
/*      */ 
/*      */       
/*      */       public void visitNestMember(String param2String) {
/* 2455 */         this.constraint.assertNestMate();
/* 2456 */         super.visitNestMember(param2String);
/*      */       }
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       public FieldVisitor visitField(int param2Int, String param2String1, String param2String2, @MaybeNull String param2String3, @MaybeNull Object param2Object) {
/* 2462 */         if (param2Object != null) {
/*      */           Class<Integer> clazz4; Class<Long> clazz3; Class<Float> clazz2; Class<Double> clazz1; Class<String> clazz;
/* 2464 */           switch (param2String2.charAt(0)) {
/*      */             case 'B':
/*      */             case 'C':
/*      */             case 'I':
/*      */             case 'S':
/*      */             case 'Z':
/* 2470 */               clazz4 = Integer.class;
/*      */               break;
/*      */             case 'J':
/* 2473 */               clazz3 = Long.class;
/*      */               break;
/*      */             case 'F':
/* 2476 */               clazz2 = Float.class;
/*      */               break;
/*      */             case 'D':
/* 2479 */               clazz1 = Double.class;
/*      */               break;
/*      */             default:
/* 2482 */               if (!param2String2.equals("Ljava/lang/String;")) {
/* 2483 */                 throw new IllegalStateException("Cannot define a default value for type of field " + param2String1);
/*      */               }
/* 2485 */               clazz = String.class; break;
/*      */           } 
/* 2487 */           if (!clazz.isInstance(param2Object))
/* 2488 */             throw new IllegalStateException("Field " + param2String1 + " defines an incompatible default value " + param2Object); 
/* 2489 */           if (clazz == Integer.class) {
/*      */             int i; int j;
/* 2491 */             switch (param2String2.charAt(0)) {
/*      */               case 'Z':
/* 2493 */                 i = 0;
/* 2494 */                 j = 1;
/*      */                 break;
/*      */               case 'B':
/* 2497 */                 i = -128;
/* 2498 */                 j = 127;
/*      */                 break;
/*      */               case 'C':
/* 2501 */                 i = 0;
/* 2502 */                 j = 65535;
/*      */                 break;
/*      */               case 'S':
/* 2505 */                 i = -32768;
/* 2506 */                 j = 32767;
/*      */                 break;
/*      */               default:
/* 2509 */                 i = Integer.MIN_VALUE;
/* 2510 */                 j = Integer.MAX_VALUE; break;
/*      */             } 
/* 2512 */             if (((Integer)param2Object).intValue() < i || ((Integer)param2Object).intValue() > j) {
/* 2513 */               throw new IllegalStateException("Field " + param2String1 + " defines an incompatible default value " + param2Object);
/*      */             }
/*      */           } 
/*      */         } 
/* 2517 */         this.constraint.assertField(param2String1, ((param2Int & 0x1) != 0), ((param2Int & 0x8) != 0), ((param2Int & 0x10) != 0), (param2String3 != null));
/*      */ 
/*      */         
/*      */         FieldVisitor fieldVisitor;
/*      */ 
/*      */         
/* 2523 */         return ((fieldVisitor = super.visitField(param2Int, param2String1, param2String2, param2String3, param2Object)) == null) ? IGNORE_FIELD : new ValidatingFieldVisitor(this, fieldVisitor);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       public MethodVisitor visitMethod(int param2Int, String param2String1, String param2String2, @MaybeNull String param2String3, @MaybeNull String[] param2ArrayOfString) {
/* 2531 */         this.constraint.assertMethod(param2String1, ((param2Int & 0x400) != 0), ((param2Int & 0x1) != 0), ((param2Int & 0x2) != 0), ((param2Int & 0x8) != 0), (
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 2536 */             !param2String1.equals("<init>") && 
/* 2537 */             !param2String1.equals("<clinit>") && (param2Int & 0xA) == 0), param2String1
/*      */             
/* 2539 */             .equals("<init>"), (
/* 2540 */             !param2String2.startsWith("()") || param2String2.endsWith("V")), (param2String3 != null));
/*      */         
/*      */         MethodVisitor methodVisitor;
/* 2543 */         return ((methodVisitor = super.visitMethod(param2Int, param2String1, param2String2, param2String3, param2ArrayOfString)) == null) ? IGNORE_METHOD : new ValidatingMethodVisitor(this, methodVisitor, param2String1);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public enum ForClass
/*      */         implements Constraint
/*      */       {
/* 2671 */         MANIFEST(true),
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2676 */         ABSTRACT(false);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final boolean manifestType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         ForClass(boolean param3Boolean) {
/* 2689 */           this.manifestType = param3Boolean;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertType(int param3Int, boolean param3Boolean1, boolean param3Boolean2) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertField(String param3String, boolean param3Boolean1, boolean param3Boolean2, boolean param3Boolean3, boolean param3Boolean4) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertMethod(String param3String, boolean param3Boolean1, boolean param3Boolean2, boolean param3Boolean3, boolean param3Boolean4, boolean param3Boolean5, boolean param3Boolean6, boolean param3Boolean7, boolean param3Boolean8) {
/* 2718 */           if (param3Boolean1 && this.manifestType) {
/* 2719 */             throw new IllegalStateException("Cannot define abstract method '" + param3String + "' for non-abstract class");
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertAnnotation() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertTypeAnnotation() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertDefaultValue(String param3String) {
/* 2741 */           throw new IllegalStateException("Cannot define default value for '" + param3String + "' for non-annotation type");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertDefaultMethodCall() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertTypeInConstantPool() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertMethodTypeInConstantPool() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertHandleInConstantPool() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertInvokeDynamic() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertSubRoutine() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertDynamicValueInConstantPool() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertNestMate() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertRecord() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertPermittedSubclass() {}
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public enum ForPackageType
/*      */         implements Constraint
/*      */       {
/* 2823 */         INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertField(String param3String, boolean param3Boolean1, boolean param3Boolean2, boolean param3Boolean3, boolean param3Boolean4) {
/* 2829 */           throw new IllegalStateException("Cannot define a field for a package description type");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertMethod(String param3String, boolean param3Boolean1, boolean param3Boolean2, boolean param3Boolean3, boolean param3Boolean4, boolean param3Boolean5, boolean param3Boolean6, boolean param3Boolean7, boolean param3Boolean8) {
/* 2844 */           throw new IllegalStateException("Cannot define a method for a package description type");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertAnnotation() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertTypeAnnotation() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertDefaultValue(String param3String) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertDefaultMethodCall() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertTypeInConstantPool() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertMethodTypeInConstantPool() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertHandleInConstantPool() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertInvokeDynamic() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertSubRoutine() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertType(int param3Int, boolean param3Boolean1, boolean param3Boolean2) {
/* 2914 */           if (param3Int != 5632)
/* 2915 */             throw new IllegalStateException("A package description type must define 5632 as modifier"); 
/* 2916 */           if (param3Boolean1) {
/* 2917 */             throw new IllegalStateException("Cannot implement interface for package type");
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertDynamicValueInConstantPool() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertNestMate() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertRecord() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertPermittedSubclass() {}
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public enum ForInterface
/*      */         implements Constraint
/*      */       {
/* 2958 */         CLASSIC(true),
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2963 */         JAVA_8(false);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final boolean classic;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         ForInterface(boolean param3Boolean) {
/* 2976 */           this.classic = param3Boolean;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertField(String param3String, boolean param3Boolean1, boolean param3Boolean2, boolean param3Boolean3, boolean param3Boolean4) {
/* 2983 */           if (!param3Boolean2 || !param3Boolean1 || !param3Boolean3) {
/* 2984 */             throw new IllegalStateException("Cannot only define public, static, final field '" + param3String + "' for interface type");
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertMethod(String param3String, boolean param3Boolean1, boolean param3Boolean2, boolean param3Boolean3, boolean param3Boolean4, boolean param3Boolean5, boolean param3Boolean6, boolean param3Boolean7, boolean param3Boolean8) {
/* 3000 */           if (!param3String.equals("<clinit>")) {
/* 3001 */             if (param3Boolean6)
/* 3002 */               throw new IllegalStateException("Cannot define constructor for interface type"); 
/* 3003 */             if (this.classic && !param3Boolean2)
/* 3004 */               throw new IllegalStateException("Cannot define non-public method '" + param3String + "' for interface type"); 
/* 3005 */             if (this.classic && !param3Boolean5)
/* 3006 */               throw new IllegalStateException("Cannot define non-virtual method '" + param3String + "' for a pre-Java 8 interface type"); 
/* 3007 */             if (this.classic && !param3Boolean1) {
/* 3008 */               throw new IllegalStateException("Cannot define default method '" + param3String + "' for pre-Java 8 interface type");
/*      */             }
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertAnnotation() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertTypeAnnotation() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertDefaultValue(String param3String) {
/* 3031 */           throw new IllegalStateException("Cannot define default value for '" + param3String + "' for non-annotation type");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertDefaultMethodCall() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertType(int param3Int, boolean param3Boolean1, boolean param3Boolean2) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertTypeInConstantPool() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertMethodTypeInConstantPool() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertHandleInConstantPool() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertInvokeDynamic() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertSubRoutine() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertDynamicValueInConstantPool() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertNestMate() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertRecord() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertPermittedSubclass() {}
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public enum ForRecord
/*      */         implements Constraint
/*      */       {
/* 3120 */         INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertField(String param3String, boolean param3Boolean1, boolean param3Boolean2, boolean param3Boolean3, boolean param3Boolean4) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertMethod(String param3String, boolean param3Boolean1, boolean param3Boolean2, boolean param3Boolean3, boolean param3Boolean4, boolean param3Boolean5, boolean param3Boolean6, boolean param3Boolean7, boolean param3Boolean8) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertAnnotation() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertTypeAnnotation() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertDefaultValue(String param3String) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertDefaultMethodCall() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertType(int param3Int, boolean param3Boolean1, boolean param3Boolean2) {
/* 3176 */           if ((param3Int & 0x400) != 0) {
/* 3177 */             throw new IllegalStateException("Cannot define a record class as abstract");
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertTypeInConstantPool() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertMethodTypeInConstantPool() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertHandleInConstantPool() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertInvokeDynamic() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertSubRoutine() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertDynamicValueInConstantPool() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertNestMate() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertRecord() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertPermittedSubclass() {}
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public enum ForAnnotation
/*      */         implements Constraint
/*      */       {
/* 3253 */         CLASSIC(true),
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 3258 */         JAVA_8(false);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final boolean classic;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         ForAnnotation(boolean param3Boolean) {
/* 3271 */           this.classic = param3Boolean;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertField(String param3String, boolean param3Boolean1, boolean param3Boolean2, boolean param3Boolean3, boolean param3Boolean4) {
/* 3278 */           if (!param3Boolean2 || !param3Boolean1 || !param3Boolean3) {
/* 3279 */             throw new IllegalStateException("Cannot only define public, static, final field '" + param3String + "' for interface type");
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertMethod(String param3String, boolean param3Boolean1, boolean param3Boolean2, boolean param3Boolean3, boolean param3Boolean4, boolean param3Boolean5, boolean param3Boolean6, boolean param3Boolean7, boolean param3Boolean8) {
/* 3295 */           if (!param3String.equals("<clinit>")) {
/* 3296 */             if (param3Boolean6)
/* 3297 */               throw new IllegalStateException("Cannot define constructor for interface type"); 
/* 3298 */             if (this.classic && !param3Boolean5)
/* 3299 */               throw new IllegalStateException("Cannot define non-virtual method '" + param3String + "' for a pre-Java 8 annotation type"); 
/* 3300 */             if (!param3Boolean4 && param3Boolean7) {
/* 3301 */               throw new IllegalStateException("Cannot define method '" + param3String + "' with the given signature as an annotation type method");
/*      */             }
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertAnnotation() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertTypeAnnotation() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertDefaultValue(String param3String) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertDefaultMethodCall() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertType(int param3Int, boolean param3Boolean1, boolean param3Boolean2) {
/* 3338 */           if ((param3Int & 0x200) == 0) {
/* 3339 */             throw new IllegalStateException("Cannot define annotation type without interface modifier");
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertTypeInConstantPool() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertMethodTypeInConstantPool() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertHandleInConstantPool() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertInvokeDynamic() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertSubRoutine() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertDynamicValueInConstantPool() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertNestMate() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertRecord() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void assertPermittedSubclass() {}
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class ForClassFileVersion
/*      */         implements Constraint
/*      */       {
/*      */         private final ClassFileVersion classFileVersion;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected ForClassFileVersion(ClassFileVersion param3ClassFileVersion) {
/* 3424 */           this.classFileVersion = param3ClassFileVersion;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void assertType(int param3Int, boolean param3Boolean1, boolean param3Boolean2) {
/* 3431 */           if ((param3Int & 0x2000) != 0 && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V5))
/* 3432 */             throw new IllegalStateException("Cannot define annotation type for class file version " + this.classFileVersion); 
/* 3433 */           if (param3Boolean2 && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V4)) {
/* 3434 */             throw new IllegalStateException("Cannot define a generic type for class file version " + this.classFileVersion);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void assertField(String param3String, boolean param3Boolean1, boolean param3Boolean2, boolean param3Boolean3, boolean param3Boolean4) {
/* 3442 */           if (param3Boolean4 && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V4)) {
/* 3443 */             throw new IllegalStateException("Cannot define generic field '" + param3String + "' for class file version " + this.classFileVersion);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void assertMethod(String param3String, boolean param3Boolean1, boolean param3Boolean2, boolean param3Boolean3, boolean param3Boolean4, boolean param3Boolean5, boolean param3Boolean6, boolean param3Boolean7, boolean param3Boolean8) {
/* 3459 */           if (param3Boolean8 && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V4))
/* 3460 */             throw new IllegalStateException("Cannot define generic method '" + param3String + "' for class file version " + this.classFileVersion); 
/* 3461 */           if (!param3Boolean5 && param3Boolean1) {
/* 3462 */             throw new IllegalStateException("Cannot define static or non-virtual method '" + param3String + "' to be abstract");
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void assertAnnotation() {
/* 3470 */           if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V5)) {
/* 3471 */             throw new IllegalStateException("Cannot write annotations for class file version " + this.classFileVersion);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void assertTypeAnnotation() {
/* 3479 */           if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V5)) {
/* 3480 */             throw new IllegalStateException("Cannot write type annotations for class file version " + this.classFileVersion);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void assertDefaultValue(String param3String) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void assertDefaultMethodCall() {
/* 3495 */           if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V8)) {
/* 3496 */             throw new IllegalStateException("Cannot invoke default method for class file version " + this.classFileVersion);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void assertTypeInConstantPool() {
/* 3504 */           if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V5)) {
/* 3505 */             throw new IllegalStateException("Cannot write type to constant pool for class file version " + this.classFileVersion);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void assertMethodTypeInConstantPool() {
/* 3513 */           if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V7)) {
/* 3514 */             throw new IllegalStateException("Cannot write method type to constant pool for class file version " + this.classFileVersion);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void assertHandleInConstantPool() {
/* 3522 */           if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V7)) {
/* 3523 */             throw new IllegalStateException("Cannot write method handle to constant pool for class file version " + this.classFileVersion);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void assertInvokeDynamic() {
/* 3531 */           if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V7)) {
/* 3532 */             throw new IllegalStateException("Cannot write invoke dynamic instruction for class file version " + this.classFileVersion);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void assertSubRoutine() {
/* 3540 */           if (this.classFileVersion.isGreaterThan(ClassFileVersion.JAVA_V5)) {
/* 3541 */             throw new IllegalStateException("Cannot write subroutine for class file version " + this.classFileVersion);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void assertDynamicValueInConstantPool() {
/* 3549 */           if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V11)) {
/* 3550 */             throw new IllegalStateException("Cannot write dynamic constant for class file version " + this.classFileVersion);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void assertNestMate() {
/* 3558 */           if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V11)) {
/* 3559 */             throw new IllegalStateException("Cannot define nest mate for class file version " + this.classFileVersion);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void assertRecord() {
/* 3567 */           if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V14)) {
/* 3568 */             throw new IllegalStateException("Cannot define record for class file version " + this.classFileVersion);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public void assertPermittedSubclass()
/*      */         {
/* 3576 */           if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V17))
/* 3577 */             throw new IllegalStateException("Cannot define permitted subclasses for class file version " + this.classFileVersion);  } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.classFileVersion.equals(((ForClassFileVersion)param3Object).classFileVersion)))); } public int hashCode() { return getClass().hashCode() * 31 + this.classFileVersion.hashCode(); } } protected static interface Constraint { void assertType(int param3Int, boolean param3Boolean1, boolean param3Boolean2); void assertField(String param3String, boolean param3Boolean1, boolean param3Boolean2, boolean param3Boolean3, boolean param3Boolean4); void assertMethod(String param3String, boolean param3Boolean1, boolean param3Boolean2, boolean param3Boolean3, boolean param3Boolean4, boolean param3Boolean5, boolean param3Boolean6, boolean param3Boolean7, boolean param3Boolean8); void assertAnnotation(); void assertTypeAnnotation(); void assertDefaultValue(String param3String); void assertDefaultMethodCall(); void assertTypeInConstantPool(); void assertMethodTypeInConstantPool(); void assertHandleInConstantPool(); void assertInvokeDynamic(); void assertSubRoutine(); void assertDynamicValueInConstantPool(); void assertNestMate(); void assertRecord(); void assertPermittedSubclass(); public enum ForClass implements Constraint { MANIFEST(true), ABSTRACT(false); private final boolean manifestType; ForClass(boolean param4Boolean) { this.manifestType = param4Boolean; } public final void assertType(int param4Int, boolean param4Boolean1, boolean param4Boolean2) {} public final void assertField(String param4String, boolean param4Boolean1, boolean param4Boolean2, boolean param4Boolean3, boolean param4Boolean4) {} public final void assertMethod(String param4String, boolean param4Boolean1, boolean param4Boolean2, boolean param4Boolean3, boolean param4Boolean4, boolean param4Boolean5, boolean param4Boolean6, boolean param4Boolean7, boolean param4Boolean8) { if (param4Boolean1 && this.manifestType) throw new IllegalStateException("Cannot define abstract method '" + param4String + "' for non-abstract class");  } public final void assertAnnotation() {} public final void assertTypeAnnotation() {} public final void assertDefaultValue(String param4String) { throw new IllegalStateException("Cannot define default value for '" + param4String + "' for non-annotation type"); } public final void assertDefaultMethodCall() {} public final void assertTypeInConstantPool() {} public final void assertMethodTypeInConstantPool() {} public final void assertHandleInConstantPool() {} public final void assertInvokeDynamic() {} public final void assertSubRoutine() {} public final void assertDynamicValueInConstantPool() {} public final void assertNestMate() {} public final void assertRecord() {} public final void assertPermittedSubclass() {} } public enum ForPackageType implements Constraint { INSTANCE; public final void assertField(String param4String, boolean param4Boolean1, boolean param4Boolean2, boolean param4Boolean3, boolean param4Boolean4) { throw new IllegalStateException("Cannot define a field for a package description type"); } public final void assertMethod(String param4String, boolean param4Boolean1, boolean param4Boolean2, boolean param4Boolean3, boolean param4Boolean4, boolean param4Boolean5, boolean param4Boolean6, boolean param4Boolean7, boolean param4Boolean8) { throw new IllegalStateException("Cannot define a method for a package description type"); } public final void assertAnnotation() {} public final void assertTypeAnnotation() {} public final void assertDefaultValue(String param4String) {} public final void assertDefaultMethodCall() {} public final void assertTypeInConstantPool() {} public final void assertMethodTypeInConstantPool() {} public final void assertHandleInConstantPool() {} public final void assertInvokeDynamic() {} public final void assertSubRoutine() {} public final void assertType(int param4Int, boolean param4Boolean1, boolean param4Boolean2) { if (param4Int != 5632) throw new IllegalStateException("A package description type must define 5632 as modifier");  if (param4Boolean1) throw new IllegalStateException("Cannot implement interface for package type");  } public final void assertDynamicValueInConstantPool() {} public final void assertNestMate() {} public final void assertRecord() {} public final void assertPermittedSubclass() {} } public enum ForInterface implements Constraint { CLASSIC(true), JAVA_8(false); private final boolean classic; ForInterface(boolean param4Boolean) { this.classic = param4Boolean; } public final void assertField(String param4String, boolean param4Boolean1, boolean param4Boolean2, boolean param4Boolean3, boolean param4Boolean4) { if (!param4Boolean2 || !param4Boolean1 || !param4Boolean3) throw new IllegalStateException("Cannot only define public, static, final field '" + param4String + "' for interface type");  } public final void assertMethod(String param4String, boolean param4Boolean1, boolean param4Boolean2, boolean param4Boolean3, boolean param4Boolean4, boolean param4Boolean5, boolean param4Boolean6, boolean param4Boolean7, boolean param4Boolean8) { if (!param4String.equals("<clinit>")) { if (param4Boolean6) throw new IllegalStateException("Cannot define constructor for interface type");  if (this.classic && !param4Boolean2) throw new IllegalStateException("Cannot define non-public method '" + param4String + "' for interface type");  if (this.classic && !param4Boolean5) throw new IllegalStateException("Cannot define non-virtual method '" + param4String + "' for a pre-Java 8 interface type");  if (this.classic && !param4Boolean1) throw new IllegalStateException("Cannot define default method '" + param4String + "' for pre-Java 8 interface type");  }  } public final void assertAnnotation() {} public final void assertTypeAnnotation() {} public final void assertDefaultValue(String param4String) { throw new IllegalStateException("Cannot define default value for '" + param4String + "' for non-annotation type"); } public final void assertDefaultMethodCall() {} public final void assertType(int param4Int, boolean param4Boolean1, boolean param4Boolean2) {} public final void assertTypeInConstantPool() {} public final void assertMethodTypeInConstantPool() {} public final void assertHandleInConstantPool() {} public final void assertInvokeDynamic() {} public final void assertSubRoutine() {} public final void assertDynamicValueInConstantPool() {} public final void assertNestMate() {} public final void assertRecord() {} public final void assertPermittedSubclass() {} } public enum ForRecord implements Constraint { INSTANCE; public final void assertField(String param4String, boolean param4Boolean1, boolean param4Boolean2, boolean param4Boolean3, boolean param4Boolean4) {} public final void assertMethod(String param4String, boolean param4Boolean1, boolean param4Boolean2, boolean param4Boolean3, boolean param4Boolean4, boolean param4Boolean5, boolean param4Boolean6, boolean param4Boolean7, boolean param4Boolean8) {} public final void assertAnnotation() {} public final void assertTypeAnnotation() {} public final void assertDefaultValue(String param4String) {} public final void assertDefaultMethodCall() {} public final void assertType(int param4Int, boolean param4Boolean1, boolean param4Boolean2) { if ((param4Int & 0x400) != 0) throw new IllegalStateException("Cannot define a record class as abstract");  } public final void assertTypeInConstantPool() {} public final void assertMethodTypeInConstantPool() {} public final void assertHandleInConstantPool() {} public final void assertInvokeDynamic() {} public final void assertSubRoutine() {} public final void assertDynamicValueInConstantPool() {} public final void assertNestMate() {} public final void assertRecord() {} public final void assertPermittedSubclass() {} } public enum ForAnnotation implements Constraint { CLASSIC(true), JAVA_8(false); private final boolean classic; ForAnnotation(boolean param4Boolean) { this.classic = param4Boolean; } public final void assertField(String param4String, boolean param4Boolean1, boolean param4Boolean2, boolean param4Boolean3, boolean param4Boolean4) { if (!param4Boolean2 || !param4Boolean1 || !param4Boolean3) throw new IllegalStateException("Cannot only define public, static, final field '" + param4String + "' for interface type");  } public final void assertMethod(String param4String, boolean param4Boolean1, boolean param4Boolean2, boolean param4Boolean3, boolean param4Boolean4, boolean param4Boolean5, boolean param4Boolean6, boolean param4Boolean7, boolean param4Boolean8) { if (!param4String.equals("<clinit>")) { if (param4Boolean6) throw new IllegalStateException("Cannot define constructor for interface type");  if (this.classic && !param4Boolean5) throw new IllegalStateException("Cannot define non-virtual method '" + param4String + "' for a pre-Java 8 annotation type");  if (!param4Boolean4 && param4Boolean7) throw new IllegalStateException("Cannot define method '" + param4String + "' with the given signature as an annotation type method");  }  } public final void assertAnnotation() {} public final void assertTypeAnnotation() {} public final void assertDefaultValue(String param4String) {} public final void assertDefaultMethodCall() {} public final void assertType(int param4Int, boolean param4Boolean1, boolean param4Boolean2) { if ((param4Int & 0x200) == 0) throw new IllegalStateException("Cannot define annotation type without interface modifier");  } public final void assertTypeInConstantPool() {} public final void assertMethodTypeInConstantPool() {} public final void assertHandleInConstantPool() {} public final void assertInvokeDynamic() {} public final void assertSubRoutine() {} public final void assertDynamicValueInConstantPool() {} public final void assertNestMate() {} public final void assertRecord() {} public final void assertPermittedSubclass() {} } @Enhance public static class ForClassFileVersion implements Constraint { private final ClassFileVersion classFileVersion; protected ForClassFileVersion(ClassFileVersion param4ClassFileVersion) { this.classFileVersion = param4ClassFileVersion; } public void assertType(int param4Int, boolean param4Boolean1, boolean param4Boolean2) { if ((param4Int & 0x2000) != 0 && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V5)) throw new IllegalStateException("Cannot define annotation type for class file version " + this.classFileVersion);  if (param4Boolean2 && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V4)) throw new IllegalStateException("Cannot define a generic type for class file version " + this.classFileVersion);  } public void assertField(String param4String, boolean param4Boolean1, boolean param4Boolean2, boolean param4Boolean3, boolean param4Boolean4) { if (param4Boolean4 && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V4)) throw new IllegalStateException("Cannot define generic field '" + param4String + "' for class file version " + this.classFileVersion);  } public void assertMethod(String param4String, boolean param4Boolean1, boolean param4Boolean2, boolean param4Boolean3, boolean param4Boolean4, boolean param4Boolean5, boolean param4Boolean6, boolean param4Boolean7, boolean param4Boolean8) { if (param4Boolean8 && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V4)) throw new IllegalStateException("Cannot define generic method '" + param4String + "' for class file version " + this.classFileVersion);  if (!param4Boolean5 && param4Boolean1) throw new IllegalStateException("Cannot define static or non-virtual method '" + param4String + "' to be abstract");  } public void assertAnnotation() { if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V5)) throw new IllegalStateException("Cannot write annotations for class file version " + this.classFileVersion);  } public void assertTypeAnnotation() { if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V5)) throw new IllegalStateException("Cannot write type annotations for class file version " + this.classFileVersion);  } public void assertDefaultValue(String param4String) {} public void assertDefaultMethodCall() { if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V8)) throw new IllegalStateException("Cannot invoke default method for class file version " + this.classFileVersion);  } public void assertTypeInConstantPool() { if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V5)) throw new IllegalStateException("Cannot write type to constant pool for class file version " + this.classFileVersion);  } public void assertMethodTypeInConstantPool() { if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V7)) throw new IllegalStateException("Cannot write method type to constant pool for class file version " + this.classFileVersion);  } public void assertHandleInConstantPool() { if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V7)) throw new IllegalStateException("Cannot write method handle to constant pool for class file version " + this.classFileVersion);  } public void assertInvokeDynamic() { if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V7)) throw new IllegalStateException("Cannot write invoke dynamic instruction for class file version " + this.classFileVersion);  } public void assertSubRoutine() { if (this.classFileVersion.isGreaterThan(ClassFileVersion.JAVA_V5)) throw new IllegalStateException("Cannot write subroutine for class file version " + this.classFileVersion);  } public void assertDynamicValueInConstantPool() { if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V11)) throw new IllegalStateException("Cannot write dynamic constant for class file version " + this.classFileVersion);  } public void assertNestMate() { if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V11)) throw new IllegalStateException("Cannot define nest mate for class file version " + this.classFileVersion);  } public void assertRecord() { if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V14)) throw new IllegalStateException("Cannot define record for class file version " + this.classFileVersion);  } public void assertPermittedSubclass() { if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V17)) throw new IllegalStateException("Cannot define permitted subclasses for class file version " + this.classFileVersion);
/*      */              }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.classFileVersion.equals(((ForClassFileVersion)param4Object).classFileVersion))));
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return getClass().hashCode() * 31 + this.classFileVersion.hashCode();
/*      */           } }
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class Compound
/*      */           implements Constraint
/*      */         {
/* 3599 */           private final List<TypeWriter.Default.ValidatingClassVisitor.Constraint> constraints = new ArrayList<TypeWriter.Default.ValidatingClassVisitor.Constraint>(); public Compound(List<? extends TypeWriter.Default.ValidatingClassVisitor.Constraint> param4List) {
/* 3600 */             for (Iterator<? extends TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = param4List.iterator(); iterator.hasNext(); ) {
/* 3601 */               TypeWriter.Default.ValidatingClassVisitor.Constraint constraint; if (constraint = iterator.next() instanceof Compound) {
/* 3602 */                 this.constraints.addAll(((Compound)constraint).constraints); continue;
/*      */               } 
/* 3604 */               this.constraints.add(constraint);
/*      */             } 
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void assertType(int param4Int, boolean param4Boolean1, boolean param4Boolean2) {
/* 3613 */             for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) {
/* 3614 */               (constraint = iterator.next()).assertType(param4Int, param4Boolean1, param4Boolean2);
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void assertField(String param4String, boolean param4Boolean1, boolean param4Boolean2, boolean param4Boolean3, boolean param4Boolean4) {
/* 3622 */             for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) {
/* 3623 */               (constraint = iterator.next()).assertField(param4String, param4Boolean1, param4Boolean2, param4Boolean3, param4Boolean4);
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void assertMethod(String param4String, boolean param4Boolean1, boolean param4Boolean2, boolean param4Boolean3, boolean param4Boolean4, boolean param4Boolean5, boolean param4Boolean6, boolean param4Boolean7, boolean param4Boolean8) {
/* 3639 */             for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) {
/* 3640 */               (constraint = iterator.next()).assertMethod(param4String, param4Boolean1, param4Boolean2, param4Boolean3, param4Boolean4, param4Boolean5, param4Boolean6, param4Boolean7, param4Boolean8);
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void assertDefaultValue(String param4String) {
/* 3656 */             for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) {
/* 3657 */               (constraint = iterator.next()).assertDefaultValue(param4String);
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void assertDefaultMethodCall() {
/* 3665 */             for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) {
/* 3666 */               (constraint = iterator.next()).assertDefaultMethodCall();
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void assertAnnotation() {
/* 3674 */             for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) {
/* 3675 */               (constraint = iterator.next()).assertAnnotation();
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void assertTypeAnnotation() {
/* 3683 */             for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) {
/* 3684 */               (constraint = iterator.next()).assertTypeAnnotation();
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void assertTypeInConstantPool() {
/* 3692 */             for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) {
/* 3693 */               (constraint = iterator.next()).assertTypeInConstantPool();
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void assertMethodTypeInConstantPool() {
/* 3701 */             for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) {
/* 3702 */               (constraint = iterator.next()).assertMethodTypeInConstantPool();
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void assertHandleInConstantPool() {
/* 3710 */             for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) {
/* 3711 */               (constraint = iterator.next()).assertHandleInConstantPool();
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void assertInvokeDynamic() {
/* 3719 */             for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) {
/* 3720 */               (constraint = iterator.next()).assertInvokeDynamic();
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void assertSubRoutine() {
/* 3728 */             for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) {
/* 3729 */               (constraint = iterator.next()).assertSubRoutine();
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void assertDynamicValueInConstantPool() {
/* 3737 */             for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) {
/* 3738 */               (constraint = iterator.next()).assertDynamicValueInConstantPool();
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void assertNestMate() {
/* 3746 */             for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) {
/* 3747 */               (constraint = iterator.next()).assertNestMate();
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void assertRecord() {
/* 3755 */             for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) {
/* 3756 */               (constraint = iterator.next()).assertRecord();
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public void assertPermittedSubclass()
/*      */           {
/* 3764 */             for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();)
/* 3765 */               (constraint = iterator.next()).assertPermittedSubclass();  } public boolean equals(@MaybeNull Object param4Object) { return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.constraints.equals(((Compound)param4Object).constraints)))); } public int hashCode() { return getClass().hashCode() * 31 + this.constraints.hashCode(); } } } @Enhance public static class Compound implements Constraint { private final List<TypeWriter.Default.ValidatingClassVisitor.Constraint> constraints = new ArrayList<TypeWriter.Default.ValidatingClassVisitor.Constraint>(); public Compound(List<? extends TypeWriter.Default.ValidatingClassVisitor.Constraint> param3List) { for (Iterator<? extends TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = param3List.iterator(); iterator.hasNext(); ) { TypeWriter.Default.ValidatingClassVisitor.Constraint constraint; if (constraint = iterator.next() instanceof Compound) { this.constraints.addAll(((Compound)constraint).constraints); continue; }  this.constraints.add(constraint); }  } public void assertType(int param3Int, boolean param3Boolean1, boolean param3Boolean2) { for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) (constraint = iterator.next()).assertType(param3Int, param3Boolean1, param3Boolean2);  } public void assertField(String param3String, boolean param3Boolean1, boolean param3Boolean2, boolean param3Boolean3, boolean param3Boolean4) { for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) (constraint = iterator.next()).assertField(param3String, param3Boolean1, param3Boolean2, param3Boolean3, param3Boolean4);  } public void assertMethod(String param3String, boolean param3Boolean1, boolean param3Boolean2, boolean param3Boolean3, boolean param3Boolean4, boolean param3Boolean5, boolean param3Boolean6, boolean param3Boolean7, boolean param3Boolean8) { for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) (constraint = iterator.next()).assertMethod(param3String, param3Boolean1, param3Boolean2, param3Boolean3, param3Boolean4, param3Boolean5, param3Boolean6, param3Boolean7, param3Boolean8);  } public void assertDefaultValue(String param3String) { for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) (constraint = iterator.next()).assertDefaultValue(param3String);  } public void assertDefaultMethodCall() { for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) (constraint = iterator.next()).assertDefaultMethodCall();  } public void assertAnnotation() { for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) (constraint = iterator.next()).assertAnnotation();  } public void assertTypeAnnotation() { for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) (constraint = iterator.next()).assertTypeAnnotation();  } public void assertTypeInConstantPool() { for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) (constraint = iterator.next()).assertTypeInConstantPool();  } public void assertMethodTypeInConstantPool() { for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) (constraint = iterator.next()).assertMethodTypeInConstantPool();  } public void assertHandleInConstantPool() { for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) (constraint = iterator.next()).assertHandleInConstantPool();  } public void assertInvokeDynamic() { for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) (constraint = iterator.next()).assertInvokeDynamic();  } public void assertSubRoutine() { for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) (constraint = iterator.next()).assertSubRoutine();  } public void assertDynamicValueInConstantPool() { for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) (constraint = iterator.next()).assertDynamicValueInConstantPool();  } public void assertNestMate() { for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) (constraint = iterator.next()).assertNestMate();  } public void assertRecord() { for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) (constraint = iterator.next()).assertRecord();  } public void assertPermittedSubclass() { for (Iterator<TypeWriter.Default.ValidatingClassVisitor.Constraint> iterator = this.constraints.iterator(); iterator.hasNext();) (constraint = iterator.next()).assertPermittedSubclass();
/*      */            }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.constraints.equals(((Compound)param3Object).constraints))));
/*      */         }
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.constraints.hashCode();
/*      */         } }
/*      */ 
/*      */       
/*      */       protected class ValidatingFieldVisitor
/*      */         extends FieldVisitor
/*      */       {
/*      */         protected ValidatingFieldVisitor(TypeWriter.Default.ValidatingClassVisitor this$0, FieldVisitor param3FieldVisitor) {
/* 3782 */           super(OpenedClassReader.ASM_API, param3FieldVisitor);
/*      */         }
/*      */ 
/*      */         
/*      */         public AnnotationVisitor visitAnnotation(String param3String, boolean param3Boolean) {
/* 3787 */           TypeWriter.Default.ValidatingClassVisitor.a(this.a).assertAnnotation();
/* 3788 */           return super.visitAnnotation(param3String, param3Boolean);
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected class ValidatingMethodVisitor
/*      */         extends MethodVisitor
/*      */       {
/*      */         private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected ValidatingMethodVisitor(TypeWriter.Default.ValidatingClassVisitor this$0, MethodVisitor param3MethodVisitor, String param3String) {
/* 3809 */           super(OpenedClassReader.ASM_API, param3MethodVisitor);
/* 3810 */           this.name = param3String;
/*      */         }
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public AnnotationVisitor visitAnnotation(String param3String, boolean param3Boolean) {
/* 3816 */           TypeWriter.Default.ValidatingClassVisitor.a(this.a).assertAnnotation();
/* 3817 */           return super.visitAnnotation(param3String, param3Boolean);
/*      */         }
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public AnnotationVisitor visitAnnotationDefault() {
/* 3823 */           TypeWriter.Default.ValidatingClassVisitor.a(this.a).assertDefaultValue(this.name);
/* 3824 */           return super.visitAnnotationDefault();
/*      */         }
/*      */ 
/*      */         
/*      */         @SuppressFBWarnings(value = {"SF_SWITCH_NO_DEFAULT"}, justification = "Fall through to default case is intentional.")
/*      */         public void visitLdcInsn(Object param3Object) {
/* 3830 */           if (param3Object instanceof Type) {
/*      */             Type type;
/* 3832 */             switch ((type = (Type)param3Object).getSort()) {
/*      */               case 9:
/*      */               case 10:
/* 3835 */                 TypeWriter.Default.ValidatingClassVisitor.a(this.a).assertTypeInConstantPool();
/*      */                 break;
/*      */               case 11:
/* 3838 */                 TypeWriter.Default.ValidatingClassVisitor.a(this.a).assertMethodTypeInConstantPool();
/*      */                 break;
/*      */             } 
/* 3841 */           } else if (param3Object instanceof Handle) {
/* 3842 */             TypeWriter.Default.ValidatingClassVisitor.a(this.a).assertHandleInConstantPool();
/* 3843 */           } else if (param3Object instanceof net.bytebuddy.jar.asm.ConstantDynamic) {
/* 3844 */             TypeWriter.Default.ValidatingClassVisitor.a(this.a).assertDynamicValueInConstantPool();
/*      */           } 
/* 3846 */           super.visitLdcInsn(param3Object);
/*      */         }
/*      */ 
/*      */         
/*      */         public void visitMethodInsn(int param3Int, String param3String1, String param3String2, String param3String3, boolean param3Boolean) {
/* 3851 */           if (param3Boolean && param3Int == 183) {
/* 3852 */             TypeWriter.Default.ValidatingClassVisitor.a(this.a).assertDefaultMethodCall();
/*      */           }
/* 3854 */           super.visitMethodInsn(param3Int, param3String1, param3String2, param3String3, param3Boolean);
/*      */         }
/*      */ 
/*      */         
/*      */         public void visitInvokeDynamicInsn(String param3String1, String param3String2, Handle param3Handle, Object... param3VarArgs) {
/* 3859 */           TypeWriter.Default.ValidatingClassVisitor.a(this.a).assertInvokeDynamic(); Object[] arrayOfObject; int i; byte b;
/* 3860 */           for (i = (arrayOfObject = param3VarArgs).length, b = 0; b < i; b++) {
/* 3861 */             Object object; if (object = arrayOfObject[b] instanceof net.bytebuddy.jar.asm.ConstantDynamic) {
/* 3862 */               TypeWriter.Default.ValidatingClassVisitor.a(this.a).assertDynamicValueInConstantPool();
/*      */             }
/*      */           } 
/* 3865 */           super.visitInvokeDynamicInsn(param3String1, param3String2, param3Handle, param3VarArgs);
/*      */         }
/*      */ 
/*      */         
/*      */         public void visitJumpInsn(int param3Int, Label param3Label) {
/* 3870 */           if (param3Int == 168) {
/* 3871 */             TypeWriter.Default.ValidatingClassVisitor.a(this.a).assertSubRoutine();
/*      */           }
/* 3873 */           super.visitJumpInsn(param3Int, param3Label);
/*      */         }
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
/*      */     @Enhance
/*      */     public static abstract class ForInlining<U>
/*      */       extends Default<U>
/*      */     {
/*      */       @AlwaysNull
/* 3890 */       private static final FieldVisitor IGNORE_FIELD = null;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @AlwaysNull
/* 3896 */       private static final MethodVisitor IGNORE_METHOD = null;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @AlwaysNull
/* 3902 */       private static final RecordComponentVisitor IGNORE_RECORD_COMPONENT = null;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @AlwaysNull
/* 3908 */       private static final AnnotationVisitor IGNORE_ANNOTATION = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected final TypeDescription originalType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected final ClassFileLocator classFileLocator;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected ForInlining(TypeDescription param2TypeDescription1, ClassFileVersion param2ClassFileVersion, TypeWriter.FieldPool param2FieldPool, TypeWriter.RecordComponentPool param2RecordComponentPool, List<? extends DynamicType> param2List, FieldList<FieldDescription.InDefinedShape> param2FieldList, MethodList<?> param2MethodList1, MethodList<?> param2MethodList2, RecordComponentList<RecordComponentDescription.InDefinedShape> param2RecordComponentList, LoadedTypeInitializer param2LoadedTypeInitializer, TypeInitializer param2TypeInitializer, TypeAttributeAppender param2TypeAttributeAppender, AsmVisitorWrapper param2AsmVisitorWrapper, AnnotationValueFilter.Factory param2Factory, AnnotationRetention param2AnnotationRetention, AuxiliaryType.NamingStrategy param2NamingStrategy, Implementation.Context.Factory param2Factory1, TypeValidation param2TypeValidation, ClassWriterStrategy param2ClassWriterStrategy, TypePool param2TypePool, TypeDescription param2TypeDescription2, ClassFileLocator param2ClassFileLocator) {
/* 3968 */         super(param2TypeDescription1, param2ClassFileVersion, param2FieldPool, param2RecordComponentPool, param2List, param2FieldList, param2MethodList1, param2MethodList2, param2RecordComponentList, param2LoadedTypeInitializer, param2TypeInitializer, param2TypeAttributeAppender, param2AsmVisitorWrapper, param2Factory, param2AnnotationRetention, param2NamingStrategy, param2Factory1, param2TypeValidation, param2ClassWriterStrategy, param2TypePool);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 3988 */         this.originalType = param2TypeDescription2;
/* 3989 */         this.classFileLocator = param2ClassFileLocator;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ContextClassVisitor wrap(ClassVisitor param2ClassVisitor, int param2Int1, int param2Int2) {
/* 3996 */         ContextRegistry contextRegistry = new ContextRegistry();
/* 3997 */         return new RegistryContextClassVisitor(this, writeTo(TypeWriter.Default.ValidatingClassVisitor.of(param2ClassVisitor, this.typeValidation), this.typeInitializer, contextRegistry, this.asmVisitorWrapper
/*      */ 
/*      */               
/* 4000 */               .mergeWriter(param2Int1), this.asmVisitorWrapper
/* 4001 */               .mergeReader(param2Int2)), contextRegistry);
/*      */       }
/*      */ 
/*      */       
/*      */       protected TypeWriter.Default<U>.UnresolvedType create(TypeInitializer param2TypeInitializer, TypeWriter.Default.ClassDumpAction.Dispatcher param2Dispatcher) {
/*      */         try {
/* 4007 */           int i = this.asmVisitorWrapper.mergeWriter(0);
/* 4008 */           int j = this.asmVisitorWrapper.mergeReader(0);
/* 4009 */           byte[] arrayOfByte = this.classFileLocator.locate(this.originalType.getName()).resolve();
/* 4010 */           param2Dispatcher.dump(this.instrumentedType, true, arrayOfByte);
/* 4011 */           ClassReader classReader = OpenedClassReader.of(arrayOfByte);
/* 4012 */           ClassWriter classWriter = this.classWriterStrategy.resolve(i, this.typePool, classReader);
/* 4013 */           ContextRegistry contextRegistry = new ContextRegistry();
/* 4014 */           classReader.accept(writeTo(TypeWriter.Default.ValidatingClassVisitor.of((ClassVisitor)classWriter, this.typeValidation), param2TypeInitializer, contextRegistry, i, j), j);
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 4019 */           return new TypeWriter.Default.UnresolvedType(this, classWriter.toByteArray(), contextRegistry.getAuxiliaryTypes());
/* 4020 */         } catch (IOException iOException) {
/* 4021 */           throw new RuntimeException("The class file could not be written", iOException);
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected abstract ClassVisitor writeTo(ClassVisitor param2ClassVisitor, TypeInitializer param2TypeInitializer, ContextRegistry param2ContextRegistry, int param2Int1, int param2Int2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return !super.equals(param2Object) ? false : ((this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.originalType.equals(((ForInlining)param2Object).originalType) ? false : (!!this.classFileLocator.equals(((ForInlining)param2Object).classFileLocator))))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (super.hashCode() * 31 + this.originalType.hashCode()) * 31 + this.classFileLocator.hashCode();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected class RegistryContextClassVisitor
/*      */         extends ContextClassVisitor
/*      */       {
/*      */         private final TypeWriter.Default.ForInlining.ContextRegistry contextRegistry;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected RegistryContextClassVisitor(TypeWriter.Default.ForInlining this$0, ClassVisitor param3ClassVisitor, TypeWriter.Default.ForInlining.ContextRegistry param3ContextRegistry) {
/* 4058 */           super(param3ClassVisitor);
/* 4059 */           this.contextRegistry = param3ContextRegistry;
/*      */         }
/*      */ 
/*      */         
/*      */         public List<DynamicType> getAuxiliaryTypes() {
/* 4064 */           return CompoundList.of(this.a.auxiliaryTypes, this.contextRegistry.getAuxiliaryTypes());
/*      */         }
/*      */ 
/*      */         
/*      */         public LoadedTypeInitializer getLoadedTypeInitializer() {
/* 4069 */           return this.a.loadedTypeInitializer;
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static class ContextRegistry
/*      */       {
/*      */         @UnknownNull
/*      */         private Implementation.Context.ExtractableView implementationContext;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void setImplementationContext(Implementation.Context.ExtractableView param3ExtractableView) {
/* 4090 */           this.implementationContext = param3ExtractableView;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @SuppressFBWarnings(value = {"UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR"}, justification = "Lazy value definition is intended.")
/*      */         public List<DynamicType> getAuxiliaryTypes() {
/* 4101 */           return this.implementationContext.getAuxiliaryTypes();
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       protected static class WithFullProcessing<V>
/*      */         extends ForInlining<V>
/*      */       {
/* 4116 */         private static final Object[] EMPTY = new Object[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final MethodRegistry.Prepared methodRegistry;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Implementation.Target.Factory implementationTargetFactory;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final MethodRebaseResolver methodRebaseResolver;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected WithFullProcessing(TypeDescription param3TypeDescription1, ClassFileVersion param3ClassFileVersion, TypeWriter.FieldPool param3FieldPool, TypeWriter.RecordComponentPool param3RecordComponentPool, List<? extends DynamicType> param3List, FieldList<FieldDescription.InDefinedShape> param3FieldList, MethodList<?> param3MethodList1, MethodList<?> param3MethodList2, RecordComponentList<RecordComponentDescription.InDefinedShape> param3RecordComponentList, LoadedTypeInitializer param3LoadedTypeInitializer, TypeInitializer param3TypeInitializer, TypeAttributeAppender param3TypeAttributeAppender, AsmVisitorWrapper param3AsmVisitorWrapper, AnnotationValueFilter.Factory param3Factory, AnnotationRetention param3AnnotationRetention, AuxiliaryType.NamingStrategy param3NamingStrategy, Implementation.Context.Factory param3Factory1, TypeValidation param3TypeValidation, ClassWriterStrategy param3ClassWriterStrategy, TypePool param3TypePool, TypeDescription param3TypeDescription2, ClassFileLocator param3ClassFileLocator, MethodRegistry.Prepared param3Prepared, Implementation.Target.Factory param3Factory2, MethodRebaseResolver param3MethodRebaseResolver) {
/* 4186 */           super(param3TypeDescription1, param3ClassFileVersion, param3FieldPool, param3RecordComponentPool, param3List, param3FieldList, param3MethodList1, param3MethodList2, param3RecordComponentList, param3LoadedTypeInitializer, param3TypeInitializer, param3TypeAttributeAppender, param3AsmVisitorWrapper, param3Factory, param3AnnotationRetention, param3NamingStrategy, param3Factory1, param3TypeValidation, param3ClassWriterStrategy, param3TypePool, param3TypeDescription2, param3ClassFileLocator);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 4208 */           this.methodRegistry = param3Prepared;
/* 4209 */           this.implementationTargetFactory = param3Factory2;
/* 4210 */           this.methodRebaseResolver = param3MethodRebaseResolver;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected ClassVisitor writeTo(ClassVisitor param3ClassVisitor, TypeInitializer param3TypeInitializer, TypeWriter.Default.ForInlining.ContextRegistry param3ContextRegistry, int param3Int1, int param3Int2) {
/* 4217 */           RedefinitionClassVisitor redefinitionClassVisitor = new RedefinitionClassVisitor(this, param3ClassVisitor, param3TypeInitializer, param3ContextRegistry, param3Int1, param3Int2);
/* 4218 */           return (ClassVisitor)(this.originalType.getName().equals(this.instrumentedType.getName()) ? redefinitionClassVisitor : new OpenedClassRemapper((ClassVisitor)redefinitionClassVisitor, (Remapper)new SimpleRemapper(this.originalType
/*      */                 
/* 4220 */                 .getInternalName(), this.instrumentedType.getInternalName())));
/*      */         }
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return !super.equals(param3Object) ? false : ((this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.methodRegistry.equals(((WithFullProcessing)param3Object).methodRegistry) ? false : (!this.implementationTargetFactory.equals(((WithFullProcessing)param3Object).implementationTargetFactory) ? false : (!!this.methodRebaseResolver.equals(((WithFullProcessing)param3Object).methodRebaseResolver)))))));
/*      */         }
/*      */         
/*      */         public int hashCode() {
/*      */           return ((super.hashCode() * 31 + this.methodRegistry.hashCode()) * 31 + this.implementationTargetFactory.hashCode()) * 31 + this.methodRebaseResolver.hashCode();
/*      */         }
/*      */         
/*      */         protected static class OpenedClassRemapper
/*      */           extends ClassRemapper
/*      */         {
/*      */           protected OpenedClassRemapper(ClassVisitor param4ClassVisitor, Remapper param4Remapper) {
/* 4235 */             super(OpenedClassReader.ASM_API, param4ClassVisitor, param4Remapper);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected static interface InitializationHandler
/*      */         {
/*      */           void complete(ClassVisitor param4ClassVisitor, Implementation.Context.ExtractableView param4ExtractableView);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public static class Creating
/*      */             extends TypeInitializer.Drain.Default
/*      */             implements InitializationHandler
/*      */           {
/*      */             protected Creating(TypeDescription param5TypeDescription, TypeWriter.MethodPool param5MethodPool, AnnotationValueFilter.Factory param5Factory) {
/* 4267 */               super(param5TypeDescription, param5MethodPool, param5Factory);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public void complete(ClassVisitor param5ClassVisitor, Implementation.Context.ExtractableView param5ExtractableView) {
/* 4274 */               param5ExtractableView.drain(this, param5ClassVisitor, this.annotationValueFilterFactory);
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public static abstract class Appending
/*      */             extends MethodVisitor
/*      */             implements TypeInitializer.Drain, InitializationHandler
/*      */           {
/*      */             protected final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected final TypeWriter.MethodPool.Record record;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected final AnnotationValueFilter.Factory annotationValueFilterFactory;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected final FrameWriter frameWriter;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected int stackSize;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected int localVariableLength;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected Appending(MethodVisitor param5MethodVisitor, TypeDescription param5TypeDescription, TypeWriter.MethodPool.Record param5Record, AnnotationValueFilter.Factory param5Factory, boolean param5Boolean1, boolean param5Boolean2) {
/* 4329 */               super(OpenedClassReader.ASM_API, param5MethodVisitor);
/* 4330 */               this.instrumentedType = param5TypeDescription;
/* 4331 */               this.record = param5Record;
/* 4332 */               this.annotationValueFilterFactory = param5Factory;
/* 4333 */               if (!param5Boolean1) {
/* 4334 */                 this.frameWriter = FrameWriter.NoOp.INSTANCE; return;
/* 4335 */               }  if (param5Boolean2) {
/* 4336 */                 this.frameWriter = FrameWriter.Expanding.INSTANCE; return;
/*      */               } 
/* 4338 */               this.frameWriter = new FrameWriter.Active();
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected static TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler of(boolean param5Boolean1, MethodVisitor param5MethodVisitor, TypeDescription param5TypeDescription, TypeWriter.MethodPool param5MethodPool, AnnotationValueFilter.Factory param5Factory, boolean param5Boolean2, boolean param5Boolean3) {
/* 4361 */               if (param5Boolean1)
/* 4362 */                 return withDrain(param5MethodVisitor, param5TypeDescription, param5MethodPool, param5Factory, param5Boolean2, param5Boolean3); 
/* 4363 */               return withoutDrain(param5MethodVisitor, param5TypeDescription, param5MethodPool, param5Factory, param5Boolean2, param5Boolean3);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private static WithDrain withDrain(MethodVisitor param5MethodVisitor, TypeDescription param5TypeDescription, TypeWriter.MethodPool param5MethodPool, AnnotationValueFilter.Factory param5Factory, boolean param5Boolean1, boolean param5Boolean2) {
/*      */               TypeWriter.MethodPool.Record record;
/* 4384 */               return (WithDrain)((record = param5MethodPool.target((MethodDescription)new MethodDescription.Latent.TypeInitializer(param5TypeDescription))).getSort().isImplemented() ? new WithDrain.WithActiveRecord(param5MethodVisitor, param5TypeDescription, record, param5Factory, param5Boolean1, param5Boolean2) : new WithDrain.WithoutActiveRecord(param5MethodVisitor, param5TypeDescription, record, param5Factory, param5Boolean1, param5Boolean2));
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private static WithoutDrain withoutDrain(MethodVisitor param5MethodVisitor, TypeDescription param5TypeDescription, TypeWriter.MethodPool param5MethodPool, AnnotationValueFilter.Factory param5Factory, boolean param5Boolean1, boolean param5Boolean2) {
/*      */               TypeWriter.MethodPool.Record record;
/* 4407 */               return (WithoutDrain)((record = param5MethodPool.target((MethodDescription)new MethodDescription.Latent.TypeInitializer(param5TypeDescription))).getSort().isImplemented() ? new WithoutDrain.WithActiveRecord(param5MethodVisitor, param5TypeDescription, record, param5Factory, param5Boolean1, param5Boolean2) : new WithoutDrain.WithoutActiveRecord(param5MethodVisitor, param5TypeDescription, record, param5Factory));
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public void visitCode() {
/* 4414 */               this.record.applyAttributes(this.mv, this.annotationValueFilterFactory);
/* 4415 */               super.visitCode();
/* 4416 */               onStart();
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*      */             protected abstract void onStart();
/*      */ 
/*      */ 
/*      */             
/*      */             public void visitFrame(int param5Int1, int param5Int2, @MaybeNull Object[] param5ArrayOfObject1, int param5Int3, @MaybeNull Object[] param5ArrayOfObject2) {
/* 4426 */               super.visitFrame(param5Int1, param5Int2, param5ArrayOfObject1, param5Int3, param5ArrayOfObject2);
/* 4427 */               this.frameWriter.onFrame(param5Int1, param5Int2);
/*      */             }
/*      */ 
/*      */             
/*      */             public void visitMaxs(int param5Int1, int param5Int2) {
/* 4432 */               this.stackSize = param5Int1;
/* 4433 */               this.localVariableLength = param5Int2;
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*      */             public abstract void visitEnd();
/*      */ 
/*      */ 
/*      */             
/*      */             public void apply(ClassVisitor param5ClassVisitor, TypeInitializer param5TypeInitializer, Implementation.Context param5Context) {
/* 4443 */               ByteCodeAppender.Size size = param5TypeInitializer.apply(this.mv, param5Context, (MethodDescription)new MethodDescription.Latent.TypeInitializer(this.instrumentedType));
/* 4444 */               this.stackSize = Math.max(this.stackSize, size.getOperandStackSize());
/* 4445 */               this.localVariableLength = Math.max(this.localVariableLength, size.getLocalVariableSize());
/* 4446 */               onComplete(param5Context);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected abstract void onComplete(Implementation.Context param5Context);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public void complete(ClassVisitor param5ClassVisitor, Implementation.Context.ExtractableView param5ExtractableView) {
/* 4460 */               param5ExtractableView.drain(this, param5ClassVisitor, this.annotationValueFilterFactory);
/* 4461 */               this.mv.visitMaxs(this.stackSize, this.localVariableLength);
/* 4462 */               this.mv.visitEnd();
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected static interface FrameWriter
/*      */             {
/* 4473 */               public static final Object[] EMPTY = new Object[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               void onFrame(int param6Int1, int param6Int2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               void emitFrame(MethodVisitor param6MethodVisitor);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public enum NoOp
/*      */                 implements FrameWriter
/*      */               {
/* 4498 */                 INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 public final void onFrame(int param7Int1, int param7Int2) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 public final void emitFrame(MethodVisitor param7MethodVisitor) {}
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public enum Expanding
/*      */                 implements FrameWriter
/*      */               {
/* 4523 */                 INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 public final void onFrame(int param7Int1, int param7Int2) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 public final void emitFrame(MethodVisitor param7MethodVisitor) {
/* 4536 */                   param7MethodVisitor.visitFrame(-1, EMPTY.length, EMPTY, EMPTY.length, EMPTY);
/* 4537 */                   param7MethodVisitor.visitInsn(0);
/*      */                 }
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public static class Active
/*      */                 implements FrameWriter
/*      */               {
/*      */                 private int currentLocalVariableLength;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 public void onFrame(int param7Int1, int param7Int2) {
/* 4555 */                   switch (param7Int1) {
/*      */                     case 3:
/*      */                     case 4:
/*      */                       return;
/*      */                     case 1:
/* 4560 */                       this.currentLocalVariableLength += param7Int2;
/*      */                       return;
/*      */                     case 2:
/* 4563 */                       this.currentLocalVariableLength -= param7Int2;
/*      */                       return;
/*      */                     case -1:
/*      */                     case 0:
/* 4567 */                       this.currentLocalVariableLength = param7Int2;
/*      */                       return;
/*      */                   } 
/* 4570 */                   throw new IllegalStateException("Unexpected frame type: " + param7Int1);
/*      */                 }
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 public void emitFrame(MethodVisitor param7MethodVisitor)
/*      */                 {
/* 4578 */                   if (this.currentLocalVariableLength == 0) {
/* 4579 */                     param7MethodVisitor.visitFrame(3, EMPTY.length, EMPTY, EMPTY.length, EMPTY);
/* 4580 */                   } else if (this.currentLocalVariableLength > 3) {
/* 4581 */                     param7MethodVisitor.visitFrame(0, EMPTY.length, EMPTY, EMPTY.length, EMPTY);
/*      */                   } else {
/* 4583 */                     param7MethodVisitor.visitFrame(2, this.currentLocalVariableLength, EMPTY, EMPTY.length, EMPTY);
/*      */                   } 
/* 4585 */                   param7MethodVisitor.visitInsn(0);
/* 4586 */                   this.currentLocalVariableLength = 0; } } } public enum NoOp implements FrameWriter { INSTANCE; public final void onFrame(int param6Int1, int param6Int2) {} public final void emitFrame(MethodVisitor param6MethodVisitor) {} } public enum Expanding implements FrameWriter { INSTANCE; public final void onFrame(int param6Int1, int param6Int2) {} public final void emitFrame(MethodVisitor param6MethodVisitor) { param6MethodVisitor.visitFrame(-1, EMPTY.length, EMPTY, EMPTY.length, EMPTY); param6MethodVisitor.visitInsn(0); } } public static class Active implements FrameWriter { private int currentLocalVariableLength; public void onFrame(int param6Int1, int param6Int2) { switch (param6Int1) { case 3: case 4: return;case 1: this.currentLocalVariableLength += param6Int2; return;case 2: this.currentLocalVariableLength -= param6Int2; return;case -1: case 0: this.currentLocalVariableLength = param6Int2; return; }  throw new IllegalStateException("Unexpected frame type: " + param6Int1); } public void emitFrame(MethodVisitor param6MethodVisitor) { if (this.currentLocalVariableLength == 0) { param6MethodVisitor.visitFrame(3, EMPTY.length, EMPTY, EMPTY.length, EMPTY); } else if (this.currentLocalVariableLength > 3) { param6MethodVisitor.visitFrame(0, EMPTY.length, EMPTY, EMPTY.length, EMPTY); } else { param6MethodVisitor.visitFrame(2, this.currentLocalVariableLength, EMPTY, EMPTY.length, EMPTY); }  param6MethodVisitor.visitInsn(0); this.currentLocalVariableLength = 0; }
/*      */                }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected static abstract class WithoutDrain
/*      */               extends Appending
/*      */             {
/*      */               protected WithoutDrain(MethodVisitor param6MethodVisitor, TypeDescription param6TypeDescription, TypeWriter.MethodPool.Record param6Record, AnnotationValueFilter.Factory param6Factory, boolean param6Boolean1, boolean param6Boolean2) {
/* 4613 */                 super(param6MethodVisitor, param6TypeDescription, param6Record, param6Factory, param6Boolean1, param6Boolean2);
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               protected void onStart() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public void visitEnd() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               protected static class WithoutActiveRecord
/*      */                 extends WithoutDrain
/*      */               {
/*      */                 protected WithoutActiveRecord(MethodVisitor param7MethodVisitor, TypeDescription param7TypeDescription, TypeWriter.MethodPool.Record param7Record, AnnotationValueFilter.Factory param7Factory) {
/* 4644 */                   super(param7MethodVisitor, param7TypeDescription, param7Record, param7Factory, false, false);
/*      */                 }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 protected void onComplete(Implementation.Context param7Context) {}
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               protected static class WithActiveRecord
/*      */                 extends WithoutDrain
/*      */               {
/*      */                 private final Label label;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 protected WithActiveRecord(MethodVisitor param7MethodVisitor, TypeDescription param7TypeDescription, TypeWriter.MethodPool.Record param7Record, AnnotationValueFilter.Factory param7Factory, boolean param7Boolean1, boolean param7Boolean2) {
/* 4680 */                   super(param7MethodVisitor, param7TypeDescription, param7Record, param7Factory, param7Boolean1, param7Boolean2);
/* 4681 */                   this.label = new Label();
/*      */                 }
/*      */ 
/*      */                 
/*      */                 public void visitInsn(int param7Int) {
/* 4686 */                   if (param7Int == 177) {
/* 4687 */                     this.mv.visitJumpInsn(167, this.label); return;
/*      */                   } 
/* 4689 */                   super.visitInsn(param7Int);
/*      */                 }
/*      */ 
/*      */                 
/*      */                 protected void onComplete(Implementation.Context param7Context)
/*      */                 {
/* 4695 */                   this.mv.visitLabel(this.label);
/* 4696 */                   this.frameWriter.emitFrame(this.mv);
/* 4697 */                   ByteCodeAppender.Size size = this.record.applyCode(this.mv, param7Context);
/* 4698 */                   this.stackSize = Math.max(this.stackSize, size.getOperandStackSize());
/* 4699 */                   this.localVariableLength = Math.max(this.localVariableLength, size.getLocalVariableSize()); } } } protected static class WithoutActiveRecord extends WithoutDrain { protected WithoutActiveRecord(MethodVisitor param6MethodVisitor, TypeDescription param6TypeDescription, TypeWriter.MethodPool.Record param6Record, AnnotationValueFilter.Factory param6Factory) { super(param6MethodVisitor, param6TypeDescription, param6Record, param6Factory, false, false); } protected void onComplete(Implementation.Context param6Context) {} } protected static class WithActiveRecord extends WithoutDrain { private final Label label; protected WithActiveRecord(MethodVisitor param6MethodVisitor, TypeDescription param6TypeDescription, TypeWriter.MethodPool.Record param6Record, AnnotationValueFilter.Factory param6Factory, boolean param6Boolean1, boolean param6Boolean2) { super(param6MethodVisitor, param6TypeDescription, param6Record, param6Factory, param6Boolean1, param6Boolean2); this.label = new Label(); } public void visitInsn(int param6Int) { if (param6Int == 177) { this.mv.visitJumpInsn(167, this.label); return; }  super.visitInsn(param6Int); } protected void onComplete(Implementation.Context param6Context) { this.mv.visitLabel(this.label); this.frameWriter.emitFrame(this.mv); ByteCodeAppender.Size size = this.record.applyCode(this.mv, param6Context); this.stackSize = Math.max(this.stackSize, size.getOperandStackSize()); this.localVariableLength = Math.max(this.localVariableLength, size.getLocalVariableSize()); }
/*      */                }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected static abstract class WithDrain
/*      */               extends Appending
/*      */             {
/*      */               protected final Label appended;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               protected final Label original;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               protected WithDrain(MethodVisitor param6MethodVisitor, TypeDescription param6TypeDescription, TypeWriter.MethodPool.Record param6Record, AnnotationValueFilter.Factory param6Factory, boolean param6Boolean1, boolean param6Boolean2) {
/* 4737 */                 super(param6MethodVisitor, param6TypeDescription, param6Record, param6Factory, param6Boolean1, param6Boolean2);
/* 4738 */                 this.appended = new Label();
/* 4739 */                 this.original = new Label();
/*      */               }
/*      */ 
/*      */               
/*      */               protected void onStart() {
/* 4744 */                 this.mv.visitJumpInsn(167, this.appended);
/* 4745 */                 this.mv.visitLabel(this.original);
/* 4746 */                 this.frameWriter.emitFrame(this.mv);
/*      */               }
/*      */ 
/*      */               
/*      */               public void visitEnd() {
/* 4751 */                 this.mv.visitLabel(this.appended);
/* 4752 */                 this.frameWriter.emitFrame(this.mv);
/*      */               }
/*      */ 
/*      */               
/*      */               protected void onComplete(Implementation.Context param6Context) {
/* 4757 */                 this.mv.visitJumpInsn(167, this.original);
/* 4758 */                 onAfterComplete(param6Context);
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               protected abstract void onAfterComplete(Implementation.Context param6Context);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               protected static class WithoutActiveRecord
/*      */                 extends WithDrain
/*      */               {
/*      */                 protected WithoutActiveRecord(MethodVisitor param7MethodVisitor, TypeDescription param7TypeDescription, TypeWriter.MethodPool.Record param7Record, AnnotationValueFilter.Factory param7Factory, boolean param7Boolean1, boolean param7Boolean2) {
/* 4789 */                   super(param7MethodVisitor, param7TypeDescription, param7Record, param7Factory, param7Boolean1, param7Boolean2);
/*      */                 }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 protected void onAfterComplete(Implementation.Context param7Context) {}
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               protected static class WithActiveRecord
/*      */                 extends WithDrain
/*      */               {
/*      */                 private final Label label;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 protected WithActiveRecord(MethodVisitor param7MethodVisitor, TypeDescription param7TypeDescription, TypeWriter.MethodPool.Record param7Record, AnnotationValueFilter.Factory param7Factory, boolean param7Boolean1, boolean param7Boolean2) {
/* 4824 */                   super(param7MethodVisitor, param7TypeDescription, param7Record, param7Factory, param7Boolean1, param7Boolean2);
/* 4825 */                   this.label = new Label();
/*      */                 }
/*      */ 
/*      */                 
/*      */                 public void visitInsn(int param7Int) {
/* 4830 */                   if (param7Int == 177) {
/* 4831 */                     this.mv.visitJumpInsn(167, this.label); return;
/*      */                   } 
/* 4833 */                   super.visitInsn(param7Int);
/*      */                 }
/*      */ 
/*      */                 
/*      */                 protected void onAfterComplete(Implementation.Context param7Context)
/*      */                 {
/* 4839 */                   this.mv.visitLabel(this.label);
/* 4840 */                   this.frameWriter.emitFrame(this.mv);
/* 4841 */                   ByteCodeAppender.Size size = this.record.applyCode(this.mv, param7Context);
/* 4842 */                   this.stackSize = Math.max(this.stackSize, size.getOperandStackSize());
/* 4843 */                   this.localVariableLength = Math.max(this.localVariableLength, size.getLocalVariableSize()); } } } protected static class WithoutActiveRecord extends WithDrain { protected WithoutActiveRecord(MethodVisitor param6MethodVisitor, TypeDescription param6TypeDescription, TypeWriter.MethodPool.Record param6Record, AnnotationValueFilter.Factory param6Factory, boolean param6Boolean1, boolean param6Boolean2) { super(param6MethodVisitor, param6TypeDescription, param6Record, param6Factory, param6Boolean1, param6Boolean2); } protected void onAfterComplete(Implementation.Context param6Context) {} } protected static class WithActiveRecord extends WithDrain { private final Label label; protected WithActiveRecord(MethodVisitor param6MethodVisitor, TypeDescription param6TypeDescription, TypeWriter.MethodPool.Record param6Record, AnnotationValueFilter.Factory param6Factory, boolean param6Boolean1, boolean param6Boolean2) { super(param6MethodVisitor, param6TypeDescription, param6Record, param6Factory, param6Boolean1, param6Boolean2); this.label = new Label(); } public void visitInsn(int param6Int) { if (param6Int == 177) { this.mv.visitJumpInsn(167, this.label); return; }  super.visitInsn(param6Int); } protected void onAfterComplete(Implementation.Context param6Context) { this.mv.visitLabel(this.label); this.frameWriter.emitFrame(this.mv); ByteCodeAppender.Size size = this.record.applyCode(this.mv, param6Context); this.stackSize = Math.max(this.stackSize, size.getOperandStackSize()); this.localVariableLength = Math.max(this.localVariableLength, size.getLocalVariableSize()); }
/*      */                }
/*      */           
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @SuppressFBWarnings(value = {"UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR"}, justification = "Field access order is implied by ASM.")
/*      */         protected class RedefinitionClassVisitor
/*      */           extends MetadataAwareClassVisitor
/*      */         {
/*      */           private final TypeInitializer typeInitializer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final TypeWriter.Default.ForInlining.ContextRegistry contextRegistry;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final int writerFlags;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final int readerFlags;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final LinkedHashMap<TypeWriter.Default.SignatureKey, FieldDescription> declarableFields;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final LinkedHashMap<TypeWriter.Default.SignatureKey, MethodDescription> declarableMethods;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final LinkedHashMap<String, RecordComponentDescription> declarableRecordComponents;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final Set<String> nestMembers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final LinkedHashMap<String, TypeDescription> declaredTypes;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           private final Set<String> permittedSubclasses;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @UnknownNull
/*      */           private TypeWriter.MethodPool methodPool;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @UnknownNull
/*      */           private TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler initializationHandler;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @UnknownNull
/*      */           private Implementation.Context.ExtractableView implementationContext;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private boolean retainDeprecationModifiers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected RedefinitionClassVisitor(TypeWriter.Default.ForInlining.WithFullProcessing this$0, ClassVisitor param4ClassVisitor, TypeInitializer param4TypeInitializer, TypeWriter.Default.ForInlining.ContextRegistry param4ContextRegistry, int param4Int1, int param4Int2) {
/* 4944 */             super(OpenedClassReader.ASM_API, param4ClassVisitor);
/* 4945 */             this.typeInitializer = param4TypeInitializer;
/* 4946 */             this.contextRegistry = param4ContextRegistry;
/* 4947 */             this.writerFlags = param4Int1;
/* 4948 */             this.readerFlags = param4Int2;
/* 4949 */             this.declarableFields = new LinkedHashMap<TypeWriter.Default.SignatureKey, FieldDescription>((int)Math.ceil(this$0.fields.size() / 0.75D));
/* 4950 */             for (FieldDescription fieldDescription : this$0.fields) {
/* 4951 */               this.declarableFields.put(new TypeWriter.Default.SignatureKey(fieldDescription.getInternalName(), fieldDescription.getDescriptor()), fieldDescription);
/*      */             }
/* 4953 */             this.declarableMethods = new LinkedHashMap<TypeWriter.Default.SignatureKey, MethodDescription>((int)Math.ceil(this$0.instrumentedMethods.size() / 0.75D));
/* 4954 */             for (MethodDescription methodDescription : this$0.instrumentedMethods) {
/* 4955 */               this.declarableMethods.put(new TypeWriter.Default.SignatureKey(methodDescription.getInternalName(), methodDescription.getDescriptor()), methodDescription);
/*      */             }
/* 4957 */             this.declarableRecordComponents = new LinkedHashMap<String, RecordComponentDescription>((int)Math.ceil(this$0.recordComponents.size() / 0.75D));
/* 4958 */             for (RecordComponentDescription recordComponentDescription : this$0.recordComponents) {
/* 4959 */               this.declarableRecordComponents.put(recordComponentDescription.getActualName(), recordComponentDescription);
/*      */             }
/* 4961 */             if (this$0.instrumentedType.isNestHost()) {
/* 4962 */               this.nestMembers = new LinkedHashSet<String>((int)Math.ceil(this$0.instrumentedType.getNestMembers().size() / 0.75D));
/* 4963 */               for (TypeDescription typeDescription : this$0.instrumentedType.getNestMembers().filter((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.is(this$0.instrumentedType)))) {
/* 4964 */                 this.nestMembers.add(typeDescription.getInternalName());
/*      */               }
/*      */             } else {
/* 4967 */               this.nestMembers = Collections.emptySet();
/*      */             } 
/* 4969 */             this.declaredTypes = new LinkedHashMap<String, TypeDescription>((int)Math.ceil(this$0.instrumentedType.getDeclaredTypes().size() / 0.75D));
/* 4970 */             for (TypeDescription typeDescription : this$0.instrumentedType.getDeclaredTypes()) {
/* 4971 */               this.declaredTypes.put(typeDescription.getInternalName(), typeDescription);
/*      */             }
/* 4973 */             if (this$0.instrumentedType.isSealed()) {
/* 4974 */               this.permittedSubclasses = new LinkedHashSet<String>((int)Math.ceil(this$0.instrumentedType.getPermittedSubtypes().size() / 0.75D));
/* 4975 */               for (TypeDescription typeDescription : this$0.instrumentedType.getPermittedSubtypes())
/* 4976 */                 this.permittedSubclasses.add(typeDescription.getInternalName()); 
/*      */               return;
/*      */             } 
/* 4979 */             this.permittedSubclasses = null;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Relying on correlated type properties.")
/*      */           public void visit(int param4Int1, int param4Int2, String param4String1, String param4String2, String param4String3, String[] param4ArrayOfString) {
/* 4991 */             ClassFileVersion classFileVersion = ClassFileVersion.ofMinorMajor(param4Int1);
/* 4992 */             this.methodPool = TypeWriter.Default.ForInlining.WithFullProcessing.b(this.a).compile(TypeWriter.Default.ForInlining.WithFullProcessing.a(this.a), classFileVersion);
/* 4993 */             this.initializationHandler = new TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Creating(this.a.instrumentedType, this.methodPool, this.a.annotationValueFilterFactory);
/* 4994 */             this.implementationContext = this.a.implementationContextFactory.make(this.a.instrumentedType, this.a.auxiliaryTypeNamingStrategy, this.typeInitializer, classFileVersion, this.a.classFileVersion, ((this.writerFlags & 0x2) == 0 && classFileVersion
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 4999 */                 .isAtLeast(ClassFileVersion.JAVA_V6)) ? (((this.readerFlags & 0x8) == 0) ? Implementation.Context.FrameGeneration.GENERATE : Implementation.Context.FrameGeneration.EXPAND) : Implementation.Context.FrameGeneration.DISABLED);
/*      */ 
/*      */             
/* 5002 */             this.retainDeprecationModifiers = classFileVersion.isLessThan(ClassFileVersion.JAVA_V5);
/* 5003 */             this.contextRegistry.setImplementationContext(this.implementationContext);
/* 5004 */             this.cv = this.a.asmVisitorWrapper.wrap(this.a.instrumentedType, this.cv, (Implementation.Context)this.implementationContext, this.a.typePool, this.a.fields, this.a.methods, this.writerFlags, this.readerFlags);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 5012 */             this.cv.visit(param4Int1, this.a.instrumentedType
/* 5013 */                 .getActualModifiers(((param4Int2 & 0x20) != 0 && !this.a.instrumentedType.isInterface())) | 
/* 5014 */                 resolveDeprecationModifiers(param4Int2) | (((param4Int2 & 0x10) != 0 && this.a.instrumentedType
/*      */                 
/* 5016 */                 .isAnonymousType()) ? 16 : 0), this.a.instrumentedType
/* 5017 */                 .getInternalName(), TypeDescription.AbstractBase.RAW_TYPES ? param4String2 : this.a.instrumentedType
/*      */ 
/*      */                 
/* 5020 */                 .getGenericSignature(), 
/* 5021 */                 (this.a.instrumentedType.getSuperClass() == null) ? (
/* 5022 */                 this.a.instrumentedType.isInterface() ? TypeDescription.ForLoadedType.of(Object.class).getInternalName() : TypeWriter.Default.a()) : this.a.instrumentedType
/* 5023 */                 .getSuperClass().asErasure().getInternalName(), this.a.instrumentedType
/* 5024 */                 .getInterfaces().asErasures().toInternalNames());
/*      */           }
/*      */ 
/*      */           
/*      */           protected void onVisitNestHost(String param4String) {
/* 5029 */             onNestHost();
/*      */           }
/*      */ 
/*      */           
/*      */           protected void onNestHost() {
/* 5034 */             if (!this.a.instrumentedType.isNestHost()) {
/* 5035 */               this.cv.visitNestHost(this.a.instrumentedType.getNestHost().getInternalName());
/*      */             }
/*      */           }
/*      */ 
/*      */           
/*      */           protected void onVisitPermittedSubclass(String param4String) {
/* 5041 */             if (this.permittedSubclasses != null && this.permittedSubclasses.remove(param4String)) {
/* 5042 */               this.cv.visitPermittedSubclass(param4String);
/*      */             }
/*      */           }
/*      */ 
/*      */           
/*      */           protected void onVisitOuterClass(String param4String1, @MaybeNull String param4String2, @MaybeNull String param4String3) {
/*      */             try {
/* 5049 */               onOuterType(); return;
/* 5050 */             } catch (Throwable throwable) {
/* 5051 */               this.cv.visitOuterClass(param4String1, param4String2, param4String3);
/*      */               return;
/*      */             } 
/*      */           }
/*      */           
/*      */           @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH"}, justification = "Relying on correlated type properties.")
/*      */           protected void onOuterType() {
/*      */             MethodDescription.InDefinedShape inDefinedShape;
/* 5059 */             if ((inDefinedShape = this.a.instrumentedType.getEnclosingMethod()) != null) {
/* 5060 */               this.cv.visitOuterClass(inDefinedShape.getDeclaringType().getInternalName(), inDefinedShape
/* 5061 */                   .getInternalName(), inDefinedShape
/* 5062 */                   .getDescriptor()); return;
/* 5063 */             }  if (this.a.instrumentedType.isLocalType() || this.a.instrumentedType.isAnonymousType()) {
/* 5064 */               this.cv.visitOuterClass(this.a.instrumentedType.getEnclosingType().getInternalName(), TypeWriter.Default.a(), TypeWriter.Default.a());
/*      */             }
/*      */           }
/*      */ 
/*      */           
/*      */           protected void onAfterAttributes() {
/* 5070 */             this.a.typeAttributeAppender.apply(this.cv, this.a.instrumentedType, this.a.annotationValueFilterFactory.on(this.a.instrumentedType));
/*      */           }
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           protected AnnotationVisitor onVisitTypeAnnotation(int param4Int, TypePath param4TypePath, String param4String, boolean param4Boolean) {
/* 5076 */             if (this.a.annotationRetention.isEnabled())
/* 5077 */               return this.cv.visitTypeAnnotation(param4Int, param4TypePath, param4String, param4Boolean); 
/* 5078 */             return TypeWriter.Default.ForInlining.b();
/*      */           }
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           protected AnnotationVisitor onVisitAnnotation(String param4String, boolean param4Boolean) {
/* 5084 */             if (this.a.annotationRetention.isEnabled())
/* 5085 */               return this.cv.visitAnnotation(param4String, param4Boolean); 
/* 5086 */             return TypeWriter.Default.ForInlining.b();
/*      */           }
/*      */           
/*      */           @MaybeNull
/*      */           protected RecordComponentVisitor onVisitRecordComponent(String param4String1, String param4String2, @MaybeNull String param4String3) {
/*      */             RecordComponentDescription recordComponentDescription;
/*      */             TypeWriter.RecordComponentPool.Record record;
/* 5093 */             if ((recordComponentDescription = this.declarableRecordComponents.remove(param4String1)) != null && 
/*      */               
/* 5095 */               !(record = this.a.recordComponentPool.target(recordComponentDescription)).isImplicit()) {
/* 5096 */               return redefine(record, param4String3);
/*      */             }
/*      */             
/* 5099 */             return this.cv.visitRecordComponent(param4String1, param4String2, param4String3);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           protected RecordComponentVisitor redefine(TypeWriter.RecordComponentPool.Record param4Record, @MaybeNull String param4String) {
/* 5111 */             RecordComponentDescription recordComponentDescription = param4Record.getRecordComponent();
/*      */ 
/*      */             
/*      */             RecordComponentVisitor recordComponentVisitor;
/*      */ 
/*      */             
/* 5117 */             if ((recordComponentVisitor = this.cv.visitRecordComponent(recordComponentDescription.getActualName(), recordComponentDescription.getDescriptor(), TypeDescription.AbstractBase.RAW_TYPES ? param4String : recordComponentDescription.getGenericSignature())) == null)
/* 5118 */               return TypeWriter.Default.ForInlining.c();  return new AttributeObtainingRecordComponentVisitor(this, recordComponentVisitor, param4Record);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           protected FieldVisitor onVisitField(int param4Int, String param4String1, String param4String2, @MaybeNull String param4String3, @MaybeNull Object param4Object) {
/*      */             FieldDescription fieldDescription;
/*      */             TypeWriter.FieldPool.Record record;
/* 5130 */             if ((fieldDescription = this.declarableFields.remove(new TypeWriter.Default.SignatureKey(param4String1, param4String2))) != null && 
/*      */               
/* 5132 */               !(record = this.a.fieldPool.target(fieldDescription)).isImplicit()) {
/* 5133 */               return redefine(record, param4Object, param4Int, param4String3);
/*      */             }
/*      */             
/* 5136 */             return this.cv.visitField(param4Int, param4String1, param4String2, param4String3, param4Object);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           protected FieldVisitor redefine(TypeWriter.FieldPool.Record param4Record, @MaybeNull Object param4Object, int param4Int, @MaybeNull String param4String) {
/* 5150 */             FieldDescription fieldDescription = param4Record.getField();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 5158 */             if ((param4Object = this.cv.visitField(fieldDescription.getActualModifiers() | resolveDeprecationModifiers(param4Int), fieldDescription.getInternalName(), fieldDescription.getDescriptor(), TypeDescription.AbstractBase.RAW_TYPES ? param4String : fieldDescription.getGenericSignature(), param4Record.resolveDefault(param4Object))) == null)
/* 5159 */               return TypeWriter.Default.ForInlining.d();  return new AttributeObtainingFieldVisitor(this, (FieldVisitor)param4Object, param4Record);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           protected MethodVisitor onVisitMethod(int param4Int, String param4String1, String param4String2, @MaybeNull String param4String3, @MaybeNull String[] param4ArrayOfString) {
/* 5170 */             if (param4String1.equals("<clinit>")) {
/*      */               MethodVisitor methodVisitor;
/* 5172 */               if ((methodVisitor = this.cv.visitMethod(param4Int, param4String1, param4String2, param4String3, param4ArrayOfString)) == null)
/* 5173 */                 return TypeWriter.Default.ForInlining.e(); 
/* 5174 */               return (MethodVisitor)(this.initializationHandler = TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending.of(this.implementationContext.isEnabled(), methodVisitor, this.a.instrumentedType, this.methodPool, this.a.annotationValueFilterFactory, ((this.writerFlags & 0x2) == 0 && this.implementationContext
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 5179 */                   .getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V6)), ((this.readerFlags & 0x8) != 0)));
/*      */             } 
/*      */             
/*      */             MethodDescription methodDescription;
/* 5183 */             if ((methodDescription = this.declarableMethods.remove(new TypeWriter.Default.SignatureKey(param4String1, param4String2))) == null)
/* 5184 */               return this.cv.visitMethod(param4Int, param4String1, param4String2, param4String3, param4ArrayOfString); 
/* 5185 */             return redefine(methodDescription, ((param4Int & 0x400) != 0), param4Int, param4String3);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           protected MethodVisitor redefine(MethodDescription param4MethodDescription, boolean param4Boolean, int param4Int, @MaybeNull String param4String) {
/*      */             TypeWriter.MethodPool.Record record;
/* 5202 */             if (!(record = this.methodPool.target(param4MethodDescription)).getSort().isDefined()) {
/* 5203 */               return this.cv.visitMethod(param4MethodDescription.getActualModifiers() | resolveDeprecationModifiers(param4Int), param4MethodDescription
/* 5204 */                   .getInternalName(), param4MethodDescription
/* 5205 */                   .getDescriptor(), TypeDescription.AbstractBase.RAW_TYPES ? param4String : param4MethodDescription
/*      */ 
/*      */                   
/* 5208 */                   .getGenericSignature(), param4MethodDescription
/* 5209 */                   .getExceptionTypes().asErasures().toInternalNames());
/*      */             }
/* 5211 */             MethodDescription methodDescription = record.getMethod();
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             MethodVisitor methodVisitor;
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 5221 */             if ((methodVisitor = this.cv.visitMethod(ModifierContributor.Resolver.of(Collections.singleton(record.getVisibility())).resolve(methodDescription.getActualModifiers(record.getSort().isImplemented())) | resolveDeprecationModifiers(param4Int), methodDescription.getInternalName(), methodDescription.getDescriptor(), TypeDescription.AbstractBase.RAW_TYPES ? param4String : methodDescription.getGenericSignature(), methodDescription.getExceptionTypes().asErasures().toInternalNames())) == null)
/* 5222 */               return TypeWriter.Default.ForInlining.e(); 
/* 5223 */             if (param4Boolean)
/* 5224 */               return new AttributeObtainingMethodVisitor(this, methodVisitor, record); 
/* 5225 */             if (param4MethodDescription.isNative()) {
/*      */               MethodRebaseResolver.Resolution resolution;
/* 5227 */               if ((resolution = TypeWriter.Default.ForInlining.WithFullProcessing.c(this.a).resolve((MethodDescription.InDefinedShape)methodDescription.asDefined())).isRebased()) {
/*      */                 MethodVisitor methodVisitor1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 5236 */                 if ((methodVisitor1 = visitMethod(resolution.getResolvedMethod().getActualModifiers() | resolveDeprecationModifiers(param4Int), resolution.getResolvedMethod().getInternalName(), resolution.getResolvedMethod().getDescriptor(), TypeDescription.AbstractBase.RAW_TYPES ? param4String : methodDescription.getGenericSignature(), resolution.getResolvedMethod().getExceptionTypes().asErasures().toInternalNames())) != null) {
/* 5237 */                   methodVisitor1.visitEnd();
/*      */                 }
/*      */               } 
/* 5240 */               return new AttributeObtainingMethodVisitor(this, methodVisitor, record);
/*      */             } 
/* 5242 */             return new CodePreservingMethodVisitor(this, methodVisitor, record, TypeWriter.Default.ForInlining.WithFullProcessing.c(this.a).resolve((MethodDescription.InDefinedShape)methodDescription.asDefined()));
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           protected void onVisitInnerClass(String param4String1, @MaybeNull String param4String2, @MaybeNull String param4String3, int param4Int) {
/* 5248 */             if (!param4String1.equals(this.a.instrumentedType.getInternalName())) {
/*      */               TypeDescription typeDescription;
/* 5250 */               if ((typeDescription = this.declaredTypes.remove(param4String1)) == null) {
/* 5251 */                 this.cv.visitInnerClass(param4String1, param4String2, param4String3, param4Int); return;
/*      */               } 
/* 5253 */               this.cv.visitInnerClass(param4String1, (typeDescription
/*      */                   
/* 5255 */                   .isMemberType() || (param4String2 != null && param4String3 == null && typeDescription.isAnonymousType())) ? this.a.instrumentedType
/* 5256 */                   .getInternalName() : 
/* 5257 */                   TypeWriter.Default.a(), 
/* 5258 */                   typeDescription.isAnonymousType() ? 
/* 5259 */                   TypeWriter.Default.a() : typeDescription
/* 5260 */                   .getSimpleName(), typeDescription
/* 5261 */                   .getModifiers());
/*      */             } 
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           protected void onVisitNestMember(String param4String) {
/* 5268 */             if (this.a.instrumentedType.isNestHost() && this.nestMembers.remove(param4String)) {
/* 5269 */               this.cv.visitNestMember(param4String);
/*      */             }
/*      */           }
/*      */ 
/*      */           
/*      */           protected void onVisitEnd() {
/* 5275 */             for (String str : this.nestMembers) {
/* 5276 */               this.cv.visitNestMember(str);
/*      */             }
/* 5278 */             if (this.permittedSubclasses != null) {
/* 5279 */               for (String str : this.permittedSubclasses) {
/* 5280 */                 this.cv.visitPermittedSubclass(str);
/*      */               }
/*      */             }
/*      */             
/* 5284 */             if ((typeDescription = this.a.instrumentedType.getDeclaringType()) != null) {
/* 5285 */               this.cv.visitInnerClass(this.a.instrumentedType.getInternalName(), typeDescription
/* 5286 */                   .getInternalName(), this.a.instrumentedType
/* 5287 */                   .getSimpleName(), this.a.instrumentedType
/* 5288 */                   .getModifiers());
/* 5289 */             } else if (this.a.instrumentedType.isLocalType()) {
/* 5290 */               this.cv.visitInnerClass(this.a.instrumentedType.getInternalName(), 
/* 5291 */                   TypeWriter.Default.a(), this.a.instrumentedType
/* 5292 */                   .getSimpleName(), this.a.instrumentedType
/* 5293 */                   .getModifiers());
/* 5294 */             } else if (this.a.instrumentedType.isAnonymousType()) {
/* 5295 */               this.cv.visitInnerClass(this.a.instrumentedType.getInternalName(), 
/* 5296 */                   TypeWriter.Default.a(), 
/* 5297 */                   TypeWriter.Default.a(), this.a.instrumentedType
/* 5298 */                   .getModifiers());
/*      */             } 
/* 5300 */             for (TypeDescription typeDescription : this.declaredTypes.values()) {
/* 5301 */               this.cv.visitInnerClass(typeDescription.getInternalName(), 
/* 5302 */                   typeDescription.isMemberType() ? this.a.instrumentedType
/* 5303 */                   .getInternalName() : 
/* 5304 */                   TypeWriter.Default.a(), 
/* 5305 */                   typeDescription.isAnonymousType() ? 
/* 5306 */                   TypeWriter.Default.a() : typeDescription
/* 5307 */                   .getSimpleName(), typeDescription
/* 5308 */                   .getModifiers());
/*      */             }
/* 5310 */             for (RecordComponentDescription recordComponentDescription : this.declarableRecordComponents.values()) {
/* 5311 */               this.a.recordComponentPool.target(recordComponentDescription).apply(this.cv, this.a.annotationValueFilterFactory);
/*      */             }
/* 5313 */             for (FieldDescription fieldDescription : this.declarableFields.values()) {
/* 5314 */               this.a.fieldPool.target(fieldDescription).apply(this.cv, this.a.annotationValueFilterFactory);
/*      */             }
/* 5316 */             for (MethodDescription methodDescription : this.declarableMethods.values()) {
/* 5317 */               this.methodPool.target(methodDescription).apply(this.cv, (Implementation.Context)this.implementationContext, this.a.annotationValueFilterFactory);
/*      */             }
/* 5319 */             this.initializationHandler.complete(this.cv, this.implementationContext);
/* 5320 */             this.cv.visitEnd();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private int resolveDeprecationModifiers(int param4Int) {
/* 5332 */             return (this.retainDeprecationModifiers && (param4Int & 0x20000) != 0) ? 131072 : 0;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected class AttributeObtainingFieldVisitor
/*      */             extends FieldVisitor
/*      */           {
/*      */             private final TypeWriter.FieldPool.Record record;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected AttributeObtainingFieldVisitor(TypeWriter.Default.ForInlining.WithFullProcessing.RedefinitionClassVisitor this$0, FieldVisitor param5FieldVisitor, TypeWriter.FieldPool.Record param5Record) {
/* 5355 */               super(OpenedClassReader.ASM_API, param5FieldVisitor);
/* 5356 */               this.record = param5Record;
/*      */             }
/*      */ 
/*      */             
/*      */             @MaybeNull
/*      */             public AnnotationVisitor visitTypeAnnotation(int param5Int, @MaybeNull TypePath param5TypePath, String param5String, boolean param5Boolean) {
/* 5362 */               if (this.a.a.annotationRetention.isEnabled())
/* 5363 */                 return super.visitTypeAnnotation(param5Int, param5TypePath, param5String, param5Boolean); 
/* 5364 */               return TypeWriter.Default.ForInlining.b();
/*      */             }
/*      */ 
/*      */             
/*      */             @MaybeNull
/*      */             public AnnotationVisitor visitAnnotation(String param5String, boolean param5Boolean) {
/* 5370 */               if (this.a.a.annotationRetention.isEnabled())
/* 5371 */                 return super.visitAnnotation(param5String, param5Boolean); 
/* 5372 */               return TypeWriter.Default.ForInlining.b();
/*      */             }
/*      */ 
/*      */             
/*      */             public void visitEnd() {
/* 5377 */               this.record.apply(this.fv, this.a.a.annotationValueFilterFactory);
/* 5378 */               super.visitEnd();
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected class AttributeObtainingRecordComponentVisitor
/*      */             extends RecordComponentVisitor
/*      */           {
/*      */             private final TypeWriter.RecordComponentPool.Record record;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected AttributeObtainingRecordComponentVisitor(TypeWriter.Default.ForInlining.WithFullProcessing.RedefinitionClassVisitor this$0, RecordComponentVisitor param5RecordComponentVisitor, TypeWriter.RecordComponentPool.Record param5Record) {
/* 5400 */               super(OpenedClassReader.ASM_API, param5RecordComponentVisitor);
/* 5401 */               this.record = param5Record;
/*      */             }
/*      */ 
/*      */             
/*      */             public AnnotationVisitor visitTypeAnnotation(int param5Int, TypePath param5TypePath, String param5String, boolean param5Boolean) {
/* 5406 */               if (this.a.a.annotationRetention.isEnabled())
/* 5407 */                 return super.visitTypeAnnotation(param5Int, param5TypePath, param5String, param5Boolean); 
/* 5408 */               return TypeWriter.Default.ForInlining.b();
/*      */             }
/*      */ 
/*      */             
/*      */             public AnnotationVisitor visitAnnotation(String param5String, boolean param5Boolean) {
/* 5413 */               if (this.a.a.annotationRetention.isEnabled())
/* 5414 */                 return super.visitAnnotation(param5String, param5Boolean); 
/* 5415 */               return TypeWriter.Default.ForInlining.b();
/*      */             }
/*      */ 
/*      */             
/*      */             public void visitEnd() {
/* 5420 */               this.record.apply(getDelegate(), this.a.a.annotationValueFilterFactory);
/* 5421 */               super.visitEnd();
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected class CodePreservingMethodVisitor
/*      */             extends MethodVisitor
/*      */           {
/*      */             private final MethodVisitor actualMethodVisitor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final TypeWriter.MethodPool.Record record;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final MethodRebaseResolver.Resolution resolution;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected CodePreservingMethodVisitor(TypeWriter.Default.ForInlining.WithFullProcessing.RedefinitionClassVisitor this$0, MethodVisitor param5MethodVisitor, TypeWriter.MethodPool.Record param5Record, MethodRebaseResolver.Resolution param5Resolution) {
/* 5456 */               super(OpenedClassReader.ASM_API, param5MethodVisitor);
/* 5457 */               this.actualMethodVisitor = param5MethodVisitor;
/* 5458 */               this.record = param5Record;
/* 5459 */               this.resolution = param5Resolution;
/* 5460 */               param5Record.applyHead(param5MethodVisitor);
/*      */             }
/*      */ 
/*      */             
/*      */             @MaybeNull
/*      */             public AnnotationVisitor visitAnnotationDefault() {
/* 5466 */               return TypeWriter.Default.ForInlining.b();
/*      */             }
/*      */ 
/*      */             
/*      */             @MaybeNull
/*      */             public AnnotationVisitor visitTypeAnnotation(int param5Int, @MaybeNull TypePath param5TypePath, String param5String, boolean param5Boolean) {
/* 5472 */               if (this.a.a.annotationRetention.isEnabled())
/* 5473 */                 return super.visitTypeAnnotation(param5Int, param5TypePath, param5String, param5Boolean); 
/* 5474 */               return TypeWriter.Default.ForInlining.b();
/*      */             }
/*      */ 
/*      */             
/*      */             @MaybeNull
/*      */             public AnnotationVisitor visitAnnotation(String param5String, boolean param5Boolean) {
/* 5480 */               if (this.a.a.annotationRetention.isEnabled())
/* 5481 */                 return super.visitAnnotation(param5String, param5Boolean); 
/* 5482 */               return TypeWriter.Default.ForInlining.b();
/*      */             }
/*      */ 
/*      */             
/*      */             public void visitAnnotableParameterCount(int param5Int, boolean param5Boolean) {
/* 5487 */               if (this.a.a.annotationRetention.isEnabled()) {
/* 5488 */                 super.visitAnnotableParameterCount(param5Int, param5Boolean);
/*      */               }
/*      */             }
/*      */ 
/*      */             
/*      */             @MaybeNull
/*      */             public AnnotationVisitor visitParameterAnnotation(int param5Int, String param5String, boolean param5Boolean) {
/* 5495 */               if (this.a.a.annotationRetention.isEnabled())
/* 5496 */                 return super.visitParameterAnnotation(param5Int, param5String, param5Boolean); 
/* 5497 */               return TypeWriter.Default.ForInlining.b();
/*      */             }
/*      */ 
/*      */             
/*      */             public void visitCode() {
/* 5502 */               this.record.applyBody(this.actualMethodVisitor, (Implementation.Context)TypeWriter.Default.ForInlining.WithFullProcessing.RedefinitionClassVisitor.a(this.a), this.a.a.annotationValueFilterFactory);
/* 5503 */               this.actualMethodVisitor.visitEnd();
/* 5504 */               if (this.resolution.isRebased()) {
/* 5505 */                 this.mv = TypeWriter.Default.ForInlining.WithFullProcessing.RedefinitionClassVisitor.b(this.a).visitMethod(this.resolution.getResolvedMethod().getActualModifiers(), this.resolution
/* 5506 */                     .getResolvedMethod().getInternalName(), this.resolution
/* 5507 */                     .getResolvedMethod().getDescriptor(), this.resolution
/* 5508 */                     .getResolvedMethod().getGenericSignature(), this.resolution
/* 5509 */                     .getResolvedMethod().getExceptionTypes().asErasures().toInternalNames());
/* 5510 */                 super.visitCode();
/* 5511 */                 if (!this.resolution.getAppendedParameters().isEmpty() && TypeWriter.Default.ForInlining.WithFullProcessing.RedefinitionClassVisitor.a(this.a).getFrameGeneration().isActive()) {
/* 5512 */                   if (TypeWriter.Default.ForInlining.WithFullProcessing.RedefinitionClassVisitor.a(this.a).getFrameGeneration() == Implementation.Context.FrameGeneration.GENERATE && this.resolution.getAppendedParameters().size() < 4) {
/* 5513 */                     visitFrame(2, this.resolution.getAppendedParameters().size(), TypeWriter.Default.ForInlining.WithFullProcessing.f(), (TypeWriter.Default.ForInlining.WithFullProcessing.f()).length, TypeWriter.Default.ForInlining.WithFullProcessing.f());
/*      */                   } else {
/*      */                     Object[] arrayOfObject;
/*      */ 
/*      */                     
/* 5518 */                     (arrayOfObject = new Object[this.resolution.getResolvedMethod().getParameters().size() - this.resolution.getAppendedParameters().size() + 1])[0] = Opcodes.UNINITIALIZED_THIS;
/* 5519 */                     for (byte b = 1; b < arrayOfObject.length; b++) {
/*      */                       TypeDescription.Generic generic;
/*      */ 
/*      */ 
/*      */                       
/* 5524 */                       if ((generic = ((ParameterDescription.InDefinedShape)this.resolution.getResolvedMethod().getParameters().get(b - 1)).getType()).represents(boolean.class) || generic
/* 5525 */                         .represents(byte.class) || generic
/* 5526 */                         .represents(short.class) || generic
/* 5527 */                         .represents(char.class) || generic
/* 5528 */                         .represents(int.class)) {
/* 5529 */                         arrayOfObject[b] = Opcodes.INTEGER;
/* 5530 */                       } else if (generic.represents(long.class)) {
/* 5531 */                         arrayOfObject[b] = Opcodes.LONG;
/* 5532 */                       } else if (generic.represents(float.class)) {
/* 5533 */                         arrayOfObject[b] = Opcodes.FLOAT;
/* 5534 */                       } else if (generic.represents(double.class)) {
/* 5535 */                         arrayOfObject[b] = Opcodes.DOUBLE;
/*      */                       } else {
/* 5537 */                         arrayOfObject[b] = generic.asErasure().getInternalName();
/*      */                       } 
/*      */                     } 
/* 5540 */                     visitFrame(((TypeWriter.Default.ForInlining.WithFullProcessing.RedefinitionClassVisitor.c(this.a) & 0x8) == 0) ? 0 : -1, arrayOfObject.length, arrayOfObject, (
/*      */                         
/* 5542 */                         TypeWriter.Default.ForInlining.WithFullProcessing.f()).length, TypeWriter.Default.ForInlining.WithFullProcessing.f());
/*      */                   } 
/* 5544 */                   visitInsn(0); return;
/*      */                 } 
/*      */               } else {
/* 5547 */                 this.mv = TypeWriter.Default.ForInlining.e();
/* 5548 */                 super.visitCode();
/*      */               } 
/*      */             }
/*      */ 
/*      */             
/*      */             public void visitMaxs(int param5Int1, int param5Int2) {
/* 5554 */               super.visitMaxs(param5Int1, Math.max(param5Int2, this.resolution.getResolvedMethod().getStackSize()));
/*      */             }
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected class AttributeObtainingMethodVisitor
/*      */             extends MethodVisitor
/*      */           {
/*      */             private final MethodVisitor actualMethodVisitor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final TypeWriter.MethodPool.Record record;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected AttributeObtainingMethodVisitor(TypeWriter.Default.ForInlining.WithFullProcessing.RedefinitionClassVisitor this$0, MethodVisitor param5MethodVisitor, TypeWriter.MethodPool.Record param5Record) {
/* 5581 */               super(OpenedClassReader.ASM_API, param5MethodVisitor);
/* 5582 */               this.actualMethodVisitor = param5MethodVisitor;
/* 5583 */               this.record = param5Record;
/* 5584 */               param5Record.applyHead(param5MethodVisitor);
/*      */             }
/*      */ 
/*      */             
/*      */             @MaybeNull
/*      */             public AnnotationVisitor visitAnnotationDefault() {
/* 5590 */               return TypeWriter.Default.ForInlining.b();
/*      */             }
/*      */ 
/*      */             
/*      */             @MaybeNull
/*      */             public AnnotationVisitor visitTypeAnnotation(int param5Int, @MaybeNull TypePath param5TypePath, String param5String, boolean param5Boolean) {
/* 5596 */               if (this.a.a.annotationRetention.isEnabled())
/* 5597 */                 return super.visitTypeAnnotation(param5Int, param5TypePath, param5String, param5Boolean); 
/* 5598 */               return TypeWriter.Default.ForInlining.b();
/*      */             }
/*      */ 
/*      */             
/*      */             @MaybeNull
/*      */             public AnnotationVisitor visitAnnotation(String param5String, boolean param5Boolean) {
/* 5604 */               if (this.a.a.annotationRetention.isEnabled())
/* 5605 */                 return super.visitAnnotation(param5String, param5Boolean); 
/* 5606 */               return TypeWriter.Default.ForInlining.b();
/*      */             }
/*      */ 
/*      */             
/*      */             public void visitAnnotableParameterCount(int param5Int, boolean param5Boolean) {
/* 5611 */               if (this.a.a.annotationRetention.isEnabled()) {
/* 5612 */                 super.visitAnnotableParameterCount(param5Int, param5Boolean);
/*      */               }
/*      */             }
/*      */ 
/*      */             
/*      */             @MaybeNull
/*      */             public AnnotationVisitor visitParameterAnnotation(int param5Int, String param5String, boolean param5Boolean) {
/* 5619 */               if (this.a.a.annotationRetention.isEnabled())
/* 5620 */                 return super.visitParameterAnnotation(param5Int, param5String, param5Boolean); 
/* 5621 */               return TypeWriter.Default.ForInlining.b();
/*      */             }
/*      */ 
/*      */             
/*      */             public void visitCode() {
/* 5626 */               this.mv = TypeWriter.Default.ForInlining.e();
/*      */             }
/*      */ 
/*      */             
/*      */             public void visitEnd() {
/* 5631 */               this.record.applyBody(this.actualMethodVisitor, (Implementation.Context)TypeWriter.Default.ForInlining.WithFullProcessing.RedefinitionClassVisitor.a(this.a), this.a.a.annotationValueFilterFactory);
/* 5632 */               this.actualMethodVisitor.visitEnd();
/*      */             }
/*      */           }
/*      */         }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static class WithDecorationOnly<V>
/*      */         extends ForInlining<V>
/*      */       {
/*      */         protected WithDecorationOnly(TypeDescription param3TypeDescription, ClassFileVersion param3ClassFileVersion, List<? extends DynamicType> param3List, MethodList<?> param3MethodList, TypeAttributeAppender param3TypeAttributeAppender, AsmVisitorWrapper param3AsmVisitorWrapper, AnnotationValueFilter.Factory param3Factory, AnnotationRetention param3AnnotationRetention, AuxiliaryType.NamingStrategy param3NamingStrategy, Implementation.Context.Factory param3Factory1, TypeValidation param3TypeValidation, ClassWriterStrategy param3ClassWriterStrategy, TypePool param3TypePool, ClassFileLocator param3ClassFileLocator) {
/* 5677 */           super(param3TypeDescription, param3ClassFileVersion, TypeWriter.FieldPool.Disabled.INSTANCE, TypeWriter.RecordComponentPool.Disabled.INSTANCE, param3List, (FieldList<FieldDescription.InDefinedShape>)new LazyFieldList(param3TypeDescription), param3MethodList, (MethodList<?>)new MethodList.Empty(), (RecordComponentList<RecordComponentDescription.InDefinedShape>)new RecordComponentList.Empty(), (LoadedTypeInitializer)LoadedTypeInitializer.NoOp.INSTANCE, TypeInitializer.None.INSTANCE, param3TypeAttributeAppender, param3AsmVisitorWrapper, param3Factory, param3AnnotationRetention, param3NamingStrategy, param3Factory1, param3TypeValidation, param3ClassWriterStrategy, param3TypePool, param3TypeDescription, param3ClassFileLocator);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected ClassVisitor writeTo(ClassVisitor param3ClassVisitor, TypeInitializer param3TypeInitializer, TypeWriter.Default.ForInlining.ContextRegistry param3ContextRegistry, int param3Int1, int param3Int2) {
/* 5709 */           if (param3TypeInitializer.isDefined()) {
/* 5710 */             throw new UnsupportedOperationException("Cannot apply a type initializer for a decoration");
/*      */           }
/* 5712 */           return (ClassVisitor)new DecorationClassVisitor(this, param3ClassVisitor, param3ContextRegistry, param3Int1, param3Int2);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected static class LazyFieldList
/*      */           extends FieldList.AbstractBase<FieldDescription.InDefinedShape>
/*      */         {
/*      */           private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected LazyFieldList(TypeDescription param4TypeDescription) {
/* 5731 */             this.instrumentedType = param4TypeDescription;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public FieldDescription.InDefinedShape get(int param4Int) {
/* 5738 */             return (FieldDescription.InDefinedShape)this.instrumentedType.getDeclaredFields().get(param4Int);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int size() {
/* 5745 */             return this.instrumentedType.getDeclaredFields().size();
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @SuppressFBWarnings(value = {"UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR"}, justification = "Field access order is implied by ASM.")
/*      */         protected class DecorationClassVisitor
/*      */           extends MetadataAwareClassVisitor
/*      */           implements TypeInitializer.Drain
/*      */         {
/*      */           private final TypeWriter.Default.ForInlining.ContextRegistry contextRegistry;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final int writerFlags;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final int readerFlags;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @UnknownNull
/*      */           private Implementation.Context.ExtractableView implementationContext;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected DecorationClassVisitor(TypeWriter.Default.ForInlining.WithDecorationOnly this$0, ClassVisitor param4ClassVisitor, TypeWriter.Default.ForInlining.ContextRegistry param4ContextRegistry, int param4Int1, int param4Int2) {
/* 5785 */             super(OpenedClassReader.ASM_API, param4ClassVisitor);
/* 5786 */             this.contextRegistry = param4ContextRegistry;
/* 5787 */             this.writerFlags = param4Int1;
/* 5788 */             this.readerFlags = param4Int2;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void visit(int param4Int1, int param4Int2, String param4String1, String param4String2, String param4String3, String[] param4ArrayOfString) {
/* 5798 */             ClassFileVersion classFileVersion = ClassFileVersion.ofMinorMajor(param4Int1);
/* 5799 */             this.implementationContext = this.a.implementationContextFactory.make(this.a.instrumentedType, this.a.auxiliaryTypeNamingStrategy, this.a.typeInitializer, classFileVersion, this.a.classFileVersion, ((this.writerFlags & 0x2) == 0 && classFileVersion
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 5804 */                 .isAtLeast(ClassFileVersion.JAVA_V6)) ? (((this.readerFlags & 0x8) == 0) ? Implementation.Context.FrameGeneration.GENERATE : Implementation.Context.FrameGeneration.EXPAND) : Implementation.Context.FrameGeneration.DISABLED);
/*      */ 
/*      */             
/* 5807 */             this.contextRegistry.setImplementationContext(this.implementationContext);
/* 5808 */             this.cv = this.a.asmVisitorWrapper.wrap(this.a.instrumentedType, this.cv, (Implementation.Context)this.implementationContext, this.a.typePool, this.a.fields, this.a.methods, this.writerFlags, this.readerFlags);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 5816 */             this.cv.visit(param4Int1, param4Int2, param4String1, param4String2, param4String3, param4ArrayOfString);
/*      */           }
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           protected AnnotationVisitor onVisitTypeAnnotation(int param4Int, TypePath param4TypePath, String param4String, boolean param4Boolean) {
/* 5822 */             if (this.a.annotationRetention.isEnabled())
/* 5823 */               return this.cv.visitTypeAnnotation(param4Int, param4TypePath, param4String, param4Boolean); 
/* 5824 */             return TypeWriter.Default.ForInlining.b();
/*      */           }
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           protected AnnotationVisitor onVisitAnnotation(String param4String, boolean param4Boolean) {
/* 5830 */             if (this.a.annotationRetention.isEnabled())
/* 5831 */               return this.cv.visitAnnotation(param4String, param4Boolean); 
/* 5832 */             return TypeWriter.Default.ForInlining.b();
/*      */           }
/*      */ 
/*      */           
/*      */           protected void onAfterAttributes() {
/* 5837 */             this.a.typeAttributeAppender.apply(this.cv, this.a.instrumentedType, this.a.annotationValueFilterFactory.on(this.a.instrumentedType));
/*      */           }
/*      */           
/*      */           public void apply(ClassVisitor param4ClassVisitor, TypeInitializer param4TypeInitializer, Implementation.Context param4Context) {}
/*      */           
/* 5842 */           protected void onVisitEnd() { this.implementationContext.drain(this, this.cv, this.a.annotationValueFilterFactory);
/* 5843 */             this.cv.visitEnd(); } } } } @Enhance protected static class WithFullProcessing<V> extends ForInlining<V> { private static final Object[] EMPTY = new Object[0]; private final MethodRegistry.Prepared methodRegistry; private final Implementation.Target.Factory implementationTargetFactory; private final MethodRebaseResolver methodRebaseResolver; protected WithFullProcessing(TypeDescription param2TypeDescription1, ClassFileVersion param2ClassFileVersion, TypeWriter.FieldPool param2FieldPool, TypeWriter.RecordComponentPool param2RecordComponentPool, List<? extends DynamicType> param2List, FieldList<FieldDescription.InDefinedShape> param2FieldList, MethodList<?> param2MethodList1, MethodList<?> param2MethodList2, RecordComponentList<RecordComponentDescription.InDefinedShape> param2RecordComponentList, LoadedTypeInitializer param2LoadedTypeInitializer, TypeInitializer param2TypeInitializer, TypeAttributeAppender param2TypeAttributeAppender, AsmVisitorWrapper param2AsmVisitorWrapper, AnnotationValueFilter.Factory param2Factory, AnnotationRetention param2AnnotationRetention, AuxiliaryType.NamingStrategy param2NamingStrategy, Implementation.Context.Factory param2Factory1, TypeValidation param2TypeValidation, ClassWriterStrategy param2ClassWriterStrategy, TypePool param2TypePool, TypeDescription param2TypeDescription2, ClassFileLocator param2ClassFileLocator, MethodRegistry.Prepared param2Prepared, Implementation.Target.Factory param2Factory2, MethodRebaseResolver param2MethodRebaseResolver) { super(param2TypeDescription1, param2ClassFileVersion, param2FieldPool, param2RecordComponentPool, param2List, param2FieldList, param2MethodList1, param2MethodList2, param2RecordComponentList, param2LoadedTypeInitializer, param2TypeInitializer, param2TypeAttributeAppender, param2AsmVisitorWrapper, param2Factory, param2AnnotationRetention, param2NamingStrategy, param2Factory1, param2TypeValidation, param2ClassWriterStrategy, param2TypePool, param2TypeDescription2, param2ClassFileLocator); this.methodRegistry = param2Prepared; this.implementationTargetFactory = param2Factory2; this.methodRebaseResolver = param2MethodRebaseResolver; } protected ClassVisitor writeTo(ClassVisitor param2ClassVisitor, TypeInitializer param2TypeInitializer, TypeWriter.Default.ForInlining.ContextRegistry param2ContextRegistry, int param2Int1, int param2Int2) { RedefinitionClassVisitor redefinitionClassVisitor = new RedefinitionClassVisitor(this, param2ClassVisitor, param2TypeInitializer, param2ContextRegistry, param2Int1, param2Int2); return (ClassVisitor)(this.originalType.getName().equals(this.instrumentedType.getName()) ? redefinitionClassVisitor : new OpenedClassRemapper((ClassVisitor)redefinitionClassVisitor, (Remapper)new SimpleRemapper(this.originalType.getInternalName(), this.instrumentedType.getInternalName()))); } public boolean equals(@MaybeNull Object param2Object) { return !super.equals(param2Object) ? false : ((this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.methodRegistry.equals(((WithFullProcessing)param2Object).methodRegistry) ? false : (!this.implementationTargetFactory.equals(((WithFullProcessing)param2Object).implementationTargetFactory) ? false : (!!this.methodRebaseResolver.equals(((WithFullProcessing)param2Object).methodRebaseResolver))))))); } public int hashCode() { return ((super.hashCode() * 31 + this.methodRegistry.hashCode()) * 31 + this.implementationTargetFactory.hashCode()) * 31 + this.methodRebaseResolver.hashCode(); } protected static class OpenedClassRemapper extends ClassRemapper { protected OpenedClassRemapper(ClassVisitor param4ClassVisitor, Remapper param4Remapper) { super(OpenedClassReader.ASM_API, param4ClassVisitor, param4Remapper); } } protected static interface InitializationHandler { void complete(ClassVisitor param4ClassVisitor, Implementation.Context.ExtractableView param4ExtractableView); public static class Creating extends TypeInitializer.Drain.Default implements InitializationHandler { protected Creating(TypeDescription param5TypeDescription, TypeWriter.MethodPool param5MethodPool, AnnotationValueFilter.Factory param5Factory) { super(param5TypeDescription, param5MethodPool, param5Factory); } public void complete(ClassVisitor param5ClassVisitor, Implementation.Context.ExtractableView param5ExtractableView) { param5ExtractableView.drain(this, param5ClassVisitor, this.annotationValueFilterFactory); } } public static abstract class Appending extends MethodVisitor implements TypeInitializer.Drain, InitializationHandler { protected final TypeDescription instrumentedType; protected final TypeWriter.MethodPool.Record record; protected final AnnotationValueFilter.Factory annotationValueFilterFactory; protected final FrameWriter frameWriter; protected int stackSize; protected int localVariableLength; protected Appending(MethodVisitor param5MethodVisitor, TypeDescription param5TypeDescription, TypeWriter.MethodPool.Record param5Record, AnnotationValueFilter.Factory param5Factory, boolean param5Boolean1, boolean param5Boolean2) { super(OpenedClassReader.ASM_API, param5MethodVisitor); this.instrumentedType = param5TypeDescription; this.record = param5Record; this.annotationValueFilterFactory = param5Factory; if (!param5Boolean1) { this.frameWriter = FrameWriter.NoOp.INSTANCE; return; }  if (param5Boolean2) { this.frameWriter = FrameWriter.Expanding.INSTANCE; return; }  this.frameWriter = new FrameWriter.Active(); } protected static TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler of(boolean param5Boolean1, MethodVisitor param5MethodVisitor, TypeDescription param5TypeDescription, TypeWriter.MethodPool param5MethodPool, AnnotationValueFilter.Factory param5Factory, boolean param5Boolean2, boolean param5Boolean3) { if (param5Boolean1) return withDrain(param5MethodVisitor, param5TypeDescription, param5MethodPool, param5Factory, param5Boolean2, param5Boolean3);  return withoutDrain(param5MethodVisitor, param5TypeDescription, param5MethodPool, param5Factory, param5Boolean2, param5Boolean3); } private static WithDrain withDrain(MethodVisitor param5MethodVisitor, TypeDescription param5TypeDescription, TypeWriter.MethodPool param5MethodPool, AnnotationValueFilter.Factory param5Factory, boolean param5Boolean1, boolean param5Boolean2) { TypeWriter.MethodPool.Record record; return (WithDrain)((record = param5MethodPool.target((MethodDescription)new MethodDescription.Latent.TypeInitializer(param5TypeDescription))).getSort().isImplemented() ? new WithDrain.WithActiveRecord(param5MethodVisitor, param5TypeDescription, record, param5Factory, param5Boolean1, param5Boolean2) : new WithDrain.WithoutActiveRecord(param5MethodVisitor, param5TypeDescription, record, param5Factory, param5Boolean1, param5Boolean2)); } private static WithoutDrain withoutDrain(MethodVisitor param5MethodVisitor, TypeDescription param5TypeDescription, TypeWriter.MethodPool param5MethodPool, AnnotationValueFilter.Factory param5Factory, boolean param5Boolean1, boolean param5Boolean2) { TypeWriter.MethodPool.Record record; return (WithoutDrain)((record = param5MethodPool.target((MethodDescription)new MethodDescription.Latent.TypeInitializer(param5TypeDescription))).getSort().isImplemented() ? new WithoutDrain.WithActiveRecord(param5MethodVisitor, param5TypeDescription, record, param5Factory, param5Boolean1, param5Boolean2) : new WithoutDrain.WithoutActiveRecord(param5MethodVisitor, param5TypeDescription, record, param5Factory)); } public void visitCode() { this.record.applyAttributes(this.mv, this.annotationValueFilterFactory); super.visitCode(); onStart(); } protected abstract void onStart(); public void visitFrame(int param5Int1, int param5Int2, @MaybeNull Object[] param5ArrayOfObject1, int param5Int3, @MaybeNull Object[] param5ArrayOfObject2) { super.visitFrame(param5Int1, param5Int2, param5ArrayOfObject1, param5Int3, param5ArrayOfObject2); this.frameWriter.onFrame(param5Int1, param5Int2); } public void visitMaxs(int param5Int1, int param5Int2) { this.stackSize = param5Int1; this.localVariableLength = param5Int2; } public abstract void visitEnd(); public void apply(ClassVisitor param5ClassVisitor, TypeInitializer param5TypeInitializer, Implementation.Context param5Context) { ByteCodeAppender.Size size = param5TypeInitializer.apply(this.mv, param5Context, (MethodDescription)new MethodDescription.Latent.TypeInitializer(this.instrumentedType)); this.stackSize = Math.max(this.stackSize, size.getOperandStackSize()); this.localVariableLength = Math.max(this.localVariableLength, size.getLocalVariableSize()); onComplete(param5Context); } protected abstract void onComplete(Implementation.Context param5Context); public void complete(ClassVisitor param5ClassVisitor, Implementation.Context.ExtractableView param5ExtractableView) { param5ExtractableView.drain(this, param5ClassVisitor, this.annotationValueFilterFactory); this.mv.visitMaxs(this.stackSize, this.localVariableLength); this.mv.visitEnd(); } protected static interface FrameWriter { public static final Object[] EMPTY = new Object[0]; void onFrame(int param6Int1, int param6Int2); void emitFrame(MethodVisitor param6MethodVisitor); public enum NoOp implements FrameWriter { INSTANCE; public final void onFrame(int param7Int1, int param7Int2) {} public final void emitFrame(MethodVisitor param7MethodVisitor) {} } public enum Expanding implements FrameWriter { INSTANCE; public final void onFrame(int param7Int1, int param7Int2) {} public final void emitFrame(MethodVisitor param7MethodVisitor) { param7MethodVisitor.visitFrame(-1, EMPTY.length, EMPTY, EMPTY.length, EMPTY); param7MethodVisitor.visitInsn(0); } } public static class Active implements FrameWriter { private int currentLocalVariableLength; public void onFrame(int param7Int1, int param7Int2) { switch (param7Int1) { case 3: case 4: return;case 1: this.currentLocalVariableLength += param7Int2; return;case 2: this.currentLocalVariableLength -= param7Int2; return;case -1: case 0: this.currentLocalVariableLength = param7Int2; return; }  throw new IllegalStateException("Unexpected frame type: " + param7Int1); } public void emitFrame(MethodVisitor param7MethodVisitor) { if (this.currentLocalVariableLength == 0) { param7MethodVisitor.visitFrame(3, EMPTY.length, EMPTY, EMPTY.length, EMPTY); } else if (this.currentLocalVariableLength > 3) { param7MethodVisitor.visitFrame(0, EMPTY.length, EMPTY, EMPTY.length, EMPTY); } else { param7MethodVisitor.visitFrame(2, this.currentLocalVariableLength, EMPTY, EMPTY.length, EMPTY); }  param7MethodVisitor.visitInsn(0); this.currentLocalVariableLength = 0; } } } public enum NoOp implements FrameWriter { INSTANCE; public final void onFrame(int param6Int1, int param6Int2) {} public final void emitFrame(MethodVisitor param6MethodVisitor) {} } public enum Expanding implements FrameWriter { INSTANCE; public final void onFrame(int param6Int1, int param6Int2) {} public final void emitFrame(MethodVisitor param6MethodVisitor) { param6MethodVisitor.visitFrame(-1, EMPTY.length, EMPTY, EMPTY.length, EMPTY); param6MethodVisitor.visitInsn(0); } } public static class Active implements FrameWriter { private int currentLocalVariableLength; public void onFrame(int param6Int1, int param6Int2) { switch (param6Int1) { case 3: case 4: return;case 1: this.currentLocalVariableLength += param6Int2; return;case 2: this.currentLocalVariableLength -= param6Int2; return;case -1: case 0: this.currentLocalVariableLength = param6Int2; return; }  throw new IllegalStateException("Unexpected frame type: " + param6Int1); } public void emitFrame(MethodVisitor param6MethodVisitor) { if (this.currentLocalVariableLength == 0) { param6MethodVisitor.visitFrame(3, EMPTY.length, EMPTY, EMPTY.length, EMPTY); } else if (this.currentLocalVariableLength > 3) { param6MethodVisitor.visitFrame(0, EMPTY.length, EMPTY, EMPTY.length, EMPTY); } else { param6MethodVisitor.visitFrame(2, this.currentLocalVariableLength, EMPTY, EMPTY.length, EMPTY); }  param6MethodVisitor.visitInsn(0); this.currentLocalVariableLength = 0; } } protected static abstract class WithoutDrain extends Appending { protected WithoutDrain(MethodVisitor param6MethodVisitor, TypeDescription param6TypeDescription, TypeWriter.MethodPool.Record param6Record, AnnotationValueFilter.Factory param6Factory, boolean param6Boolean1, boolean param6Boolean2) { super(param6MethodVisitor, param6TypeDescription, param6Record, param6Factory, param6Boolean1, param6Boolean2); } protected void onStart() {} public void visitEnd() {} protected static class WithoutActiveRecord extends WithoutDrain { protected WithoutActiveRecord(MethodVisitor param7MethodVisitor, TypeDescription param7TypeDescription, TypeWriter.MethodPool.Record param7Record, AnnotationValueFilter.Factory param7Factory) { super(param7MethodVisitor, param7TypeDescription, param7Record, param7Factory, false, false); } protected void onComplete(Implementation.Context param7Context) {} } protected static class WithActiveRecord extends WithoutDrain { private final Label label; protected WithActiveRecord(MethodVisitor param7MethodVisitor, TypeDescription param7TypeDescription, TypeWriter.MethodPool.Record param7Record, AnnotationValueFilter.Factory param7Factory, boolean param7Boolean1, boolean param7Boolean2) { super(param7MethodVisitor, param7TypeDescription, param7Record, param7Factory, param7Boolean1, param7Boolean2); this.label = new Label(); } public void visitInsn(int param7Int) { if (param7Int == 177) { this.mv.visitJumpInsn(167, this.label); return; }  super.visitInsn(param7Int); } protected void onComplete(Implementation.Context param7Context) { this.mv.visitLabel(this.label); this.frameWriter.emitFrame(this.mv); ByteCodeAppender.Size size = this.record.applyCode(this.mv, param7Context); this.stackSize = Math.max(this.stackSize, size.getOperandStackSize()); this.localVariableLength = Math.max(this.localVariableLength, size.getLocalVariableSize()); } } } protected static class WithoutActiveRecord extends WithoutDrain { protected WithoutActiveRecord(MethodVisitor param6MethodVisitor, TypeDescription param6TypeDescription, TypeWriter.MethodPool.Record param6Record, AnnotationValueFilter.Factory param6Factory) { super(param6MethodVisitor, param6TypeDescription, param6Record, param6Factory, false, false); } protected void onComplete(Implementation.Context param6Context) {} } protected static class WithActiveRecord extends WithoutDrain { private final Label label; protected WithActiveRecord(MethodVisitor param6MethodVisitor, TypeDescription param6TypeDescription, TypeWriter.MethodPool.Record param6Record, AnnotationValueFilter.Factory param6Factory, boolean param6Boolean1, boolean param6Boolean2) { super(param6MethodVisitor, param6TypeDescription, param6Record, param6Factory, param6Boolean1, param6Boolean2); this.label = new Label(); } public void visitInsn(int param6Int) { if (param6Int == 177) { this.mv.visitJumpInsn(167, this.label); return; }  super.visitInsn(param6Int); } protected void onComplete(Implementation.Context param6Context) { this.mv.visitLabel(this.label); this.frameWriter.emitFrame(this.mv); ByteCodeAppender.Size size = this.record.applyCode(this.mv, param6Context); this.stackSize = Math.max(this.stackSize, size.getOperandStackSize()); this.localVariableLength = Math.max(this.localVariableLength, size.getLocalVariableSize()); } } protected static abstract class WithDrain extends Appending { protected final Label appended; protected final Label original; protected WithDrain(MethodVisitor param6MethodVisitor, TypeDescription param6TypeDescription, TypeWriter.MethodPool.Record param6Record, AnnotationValueFilter.Factory param6Factory, boolean param6Boolean1, boolean param6Boolean2) { super(param6MethodVisitor, param6TypeDescription, param6Record, param6Factory, param6Boolean1, param6Boolean2); this.appended = new Label(); this.original = new Label(); } protected void onStart() { this.mv.visitJumpInsn(167, this.appended); this.mv.visitLabel(this.original); this.frameWriter.emitFrame(this.mv); } public void visitEnd() { this.mv.visitLabel(this.appended); this.frameWriter.emitFrame(this.mv); } protected void onComplete(Implementation.Context param6Context) { this.mv.visitJumpInsn(167, this.original); onAfterComplete(param6Context); } protected abstract void onAfterComplete(Implementation.Context param6Context); protected static class WithoutActiveRecord extends WithDrain { protected WithoutActiveRecord(MethodVisitor param7MethodVisitor, TypeDescription param7TypeDescription, TypeWriter.MethodPool.Record param7Record, AnnotationValueFilter.Factory param7Factory, boolean param7Boolean1, boolean param7Boolean2) { super(param7MethodVisitor, param7TypeDescription, param7Record, param7Factory, param7Boolean1, param7Boolean2); } protected void onAfterComplete(Implementation.Context param7Context) {} } protected static class WithActiveRecord extends WithDrain { private final Label label; protected WithActiveRecord(MethodVisitor param7MethodVisitor, TypeDescription param7TypeDescription, TypeWriter.MethodPool.Record param7Record, AnnotationValueFilter.Factory param7Factory, boolean param7Boolean1, boolean param7Boolean2) { super(param7MethodVisitor, param7TypeDescription, param7Record, param7Factory, param7Boolean1, param7Boolean2); this.label = new Label(); } public void visitInsn(int param7Int) { if (param7Int == 177) { this.mv.visitJumpInsn(167, this.label); return; }  super.visitInsn(param7Int); } protected void onAfterComplete(Implementation.Context param7Context) { this.mv.visitLabel(this.label); this.frameWriter.emitFrame(this.mv); ByteCodeAppender.Size size = this.record.applyCode(this.mv, param7Context); this.stackSize = Math.max(this.stackSize, size.getOperandStackSize()); this.localVariableLength = Math.max(this.localVariableLength, size.getLocalVariableSize()); } } } protected static class WithoutActiveRecord extends WithDrain { protected WithoutActiveRecord(MethodVisitor param6MethodVisitor, TypeDescription param6TypeDescription, TypeWriter.MethodPool.Record param6Record, AnnotationValueFilter.Factory param6Factory, boolean param6Boolean1, boolean param6Boolean2) { super(param6MethodVisitor, param6TypeDescription, param6Record, param6Factory, param6Boolean1, param6Boolean2); } protected void onAfterComplete(Implementation.Context param6Context) {} } protected static class WithActiveRecord extends WithDrain { private final Label label; protected WithActiveRecord(MethodVisitor param6MethodVisitor, TypeDescription param6TypeDescription, TypeWriter.MethodPool.Record param6Record, AnnotationValueFilter.Factory param6Factory, boolean param6Boolean1, boolean param6Boolean2) { super(param6MethodVisitor, param6TypeDescription, param6Record, param6Factory, param6Boolean1, param6Boolean2); this.label = new Label(); } public void visitInsn(int param6Int) { if (param6Int == 177) { this.mv.visitJumpInsn(167, this.label); return; }  super.visitInsn(param6Int); } protected void onAfterComplete(Implementation.Context param6Context) { this.mv.visitLabel(this.label); this.frameWriter.emitFrame(this.mv); ByteCodeAppender.Size size = this.record.applyCode(this.mv, param6Context); this.stackSize = Math.max(this.stackSize, size.getOperandStackSize()); this.localVariableLength = Math.max(this.localVariableLength, size.getLocalVariableSize()); } } } } @SuppressFBWarnings(value = {"UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR"}, justification = "Field access order is implied by ASM.") protected class RedefinitionClassVisitor extends MetadataAwareClassVisitor { private final TypeInitializer typeInitializer; private final TypeWriter.Default.ForInlining.ContextRegistry contextRegistry; private final int writerFlags; private final int readerFlags; private final LinkedHashMap<TypeWriter.Default.SignatureKey, FieldDescription> declarableFields; private final LinkedHashMap<TypeWriter.Default.SignatureKey, MethodDescription> declarableMethods; private final LinkedHashMap<String, RecordComponentDescription> declarableRecordComponents; private final Set<String> nestMembers; private final LinkedHashMap<String, TypeDescription> declaredTypes; @MaybeNull private final Set<String> permittedSubclasses; @UnknownNull private TypeWriter.MethodPool methodPool; @UnknownNull private TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler initializationHandler; @UnknownNull private Implementation.Context.ExtractableView implementationContext; private boolean retainDeprecationModifiers; protected RedefinitionClassVisitor(TypeWriter.Default.ForInlining.WithFullProcessing this$0, ClassVisitor param4ClassVisitor, TypeInitializer param4TypeInitializer, TypeWriter.Default.ForInlining.ContextRegistry param4ContextRegistry, int param4Int1, int param4Int2) { super(OpenedClassReader.ASM_API, param4ClassVisitor); this.typeInitializer = param4TypeInitializer; this.contextRegistry = param4ContextRegistry; this.writerFlags = param4Int1; this.readerFlags = param4Int2; this.declarableFields = new LinkedHashMap<TypeWriter.Default.SignatureKey, FieldDescription>((int)Math.ceil(this$0.fields.size() / 0.75D)); for (FieldDescription fieldDescription : this$0.fields) this.declarableFields.put(new TypeWriter.Default.SignatureKey(fieldDescription.getInternalName(), fieldDescription.getDescriptor()), fieldDescription);  this.declarableMethods = new LinkedHashMap<TypeWriter.Default.SignatureKey, MethodDescription>((int)Math.ceil(this$0.instrumentedMethods.size() / 0.75D)); for (MethodDescription methodDescription : this$0.instrumentedMethods) this.declarableMethods.put(new TypeWriter.Default.SignatureKey(methodDescription.getInternalName(), methodDescription.getDescriptor()), methodDescription);  this.declarableRecordComponents = new LinkedHashMap<String, RecordComponentDescription>((int)Math.ceil(this$0.recordComponents.size() / 0.75D)); for (RecordComponentDescription recordComponentDescription : this$0.recordComponents) this.declarableRecordComponents.put(recordComponentDescription.getActualName(), recordComponentDescription);  if (this$0.instrumentedType.isNestHost()) { this.nestMembers = new LinkedHashSet<String>((int)Math.ceil(this$0.instrumentedType.getNestMembers().size() / 0.75D)); for (TypeDescription typeDescription : this$0.instrumentedType.getNestMembers().filter((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.is(this$0.instrumentedType)))) this.nestMembers.add(typeDescription.getInternalName());  } else { this.nestMembers = Collections.emptySet(); }  this.declaredTypes = new LinkedHashMap<String, TypeDescription>((int)Math.ceil(this$0.instrumentedType.getDeclaredTypes().size() / 0.75D)); for (TypeDescription typeDescription : this$0.instrumentedType.getDeclaredTypes()) this.declaredTypes.put(typeDescription.getInternalName(), typeDescription);  if (this$0.instrumentedType.isSealed()) { this.permittedSubclasses = new LinkedHashSet<String>((int)Math.ceil(this$0.instrumentedType.getPermittedSubtypes().size() / 0.75D)); for (TypeDescription typeDescription : this$0.instrumentedType.getPermittedSubtypes()) this.permittedSubclasses.add(typeDescription.getInternalName());  return; }  this.permittedSubclasses = null; } @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Relying on correlated type properties.") public void visit(int param4Int1, int param4Int2, String param4String1, String param4String2, String param4String3, String[] param4ArrayOfString) { ClassFileVersion classFileVersion = ClassFileVersion.ofMinorMajor(param4Int1); this.methodPool = TypeWriter.Default.ForInlining.WithFullProcessing.b(this.a).compile(TypeWriter.Default.ForInlining.WithFullProcessing.a(this.a), classFileVersion); this.initializationHandler = new TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Creating(this.a.instrumentedType, this.methodPool, this.a.annotationValueFilterFactory); this.implementationContext = this.a.implementationContextFactory.make(this.a.instrumentedType, this.a.auxiliaryTypeNamingStrategy, this.typeInitializer, classFileVersion, this.a.classFileVersion, ((this.writerFlags & 0x2) == 0 && classFileVersion.isAtLeast(ClassFileVersion.JAVA_V6)) ? (((this.readerFlags & 0x8) == 0) ? Implementation.Context.FrameGeneration.GENERATE : Implementation.Context.FrameGeneration.EXPAND) : Implementation.Context.FrameGeneration.DISABLED); this.retainDeprecationModifiers = classFileVersion.isLessThan(ClassFileVersion.JAVA_V5); this.contextRegistry.setImplementationContext(this.implementationContext); this.cv = this.a.asmVisitorWrapper.wrap(this.a.instrumentedType, this.cv, (Implementation.Context)this.implementationContext, this.a.typePool, this.a.fields, this.a.methods, this.writerFlags, this.readerFlags); this.cv.visit(param4Int1, this.a.instrumentedType.getActualModifiers(((param4Int2 & 0x20) != 0 && !this.a.instrumentedType.isInterface())) | resolveDeprecationModifiers(param4Int2) | (((param4Int2 & 0x10) != 0 && this.a.instrumentedType.isAnonymousType()) ? 16 : 0), this.a.instrumentedType.getInternalName(), TypeDescription.AbstractBase.RAW_TYPES ? param4String2 : this.a.instrumentedType.getGenericSignature(), (this.a.instrumentedType.getSuperClass() == null) ? (this.a.instrumentedType.isInterface() ? TypeDescription.ForLoadedType.of(Object.class).getInternalName() : TypeWriter.Default.a()) : this.a.instrumentedType.getSuperClass().asErasure().getInternalName(), this.a.instrumentedType.getInterfaces().asErasures().toInternalNames()); } protected void onVisitNestHost(String param4String) { onNestHost(); } protected void onNestHost() { if (!this.a.instrumentedType.isNestHost()) this.cv.visitNestHost(this.a.instrumentedType.getNestHost().getInternalName());  } protected void onVisitPermittedSubclass(String param4String) { if (this.permittedSubclasses != null && this.permittedSubclasses.remove(param4String)) this.cv.visitPermittedSubclass(param4String);  } protected void onVisitOuterClass(String param4String1, @MaybeNull String param4String2, @MaybeNull String param4String3) { try { onOuterType(); return; } catch (Throwable throwable) { this.cv.visitOuterClass(param4String1, param4String2, param4String3); return; }  } @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH"}, justification = "Relying on correlated type properties.") protected void onOuterType() { MethodDescription.InDefinedShape inDefinedShape; if ((inDefinedShape = this.a.instrumentedType.getEnclosingMethod()) != null) { this.cv.visitOuterClass(inDefinedShape.getDeclaringType().getInternalName(), inDefinedShape.getInternalName(), inDefinedShape.getDescriptor()); return; }  if (this.a.instrumentedType.isLocalType() || this.a.instrumentedType.isAnonymousType()) this.cv.visitOuterClass(this.a.instrumentedType.getEnclosingType().getInternalName(), TypeWriter.Default.a(), TypeWriter.Default.a());  } protected void onAfterAttributes() { this.a.typeAttributeAppender.apply(this.cv, this.a.instrumentedType, this.a.annotationValueFilterFactory.on(this.a.instrumentedType)); } @MaybeNull protected AnnotationVisitor onVisitTypeAnnotation(int param4Int, TypePath param4TypePath, String param4String, boolean param4Boolean) { if (this.a.annotationRetention.isEnabled()) return this.cv.visitTypeAnnotation(param4Int, param4TypePath, param4String, param4Boolean);  return TypeWriter.Default.ForInlining.b(); } @MaybeNull protected AnnotationVisitor onVisitAnnotation(String param4String, boolean param4Boolean) { if (this.a.annotationRetention.isEnabled()) return this.cv.visitAnnotation(param4String, param4Boolean);  return TypeWriter.Default.ForInlining.b(); } @MaybeNull protected RecordComponentVisitor onVisitRecordComponent(String param4String1, String param4String2, @MaybeNull String param4String3) { TypeWriter.RecordComponentPool.Record record; RecordComponentDescription recordComponentDescription; if ((recordComponentDescription = this.declarableRecordComponents.remove(param4String1)) != null && !(record = this.a.recordComponentPool.target(recordComponentDescription)).isImplicit()) return redefine(record, param4String3);  return this.cv.visitRecordComponent(param4String1, param4String2, param4String3); } @MaybeNull protected RecordComponentVisitor redefine(TypeWriter.RecordComponentPool.Record param4Record, @MaybeNull String param4String) { RecordComponentDescription recordComponentDescription = param4Record.getRecordComponent(); RecordComponentVisitor recordComponentVisitor; if ((recordComponentVisitor = this.cv.visitRecordComponent(recordComponentDescription.getActualName(), recordComponentDescription.getDescriptor(), TypeDescription.AbstractBase.RAW_TYPES ? param4String : recordComponentDescription.getGenericSignature())) == null) return TypeWriter.Default.ForInlining.c();  return new AttributeObtainingRecordComponentVisitor(this, recordComponentVisitor, param4Record); } @MaybeNull protected FieldVisitor onVisitField(int param4Int, String param4String1, String param4String2, @MaybeNull String param4String3, @MaybeNull Object param4Object) { FieldDescription fieldDescription; TypeWriter.FieldPool.Record record; if ((fieldDescription = this.declarableFields.remove(new TypeWriter.Default.SignatureKey(param4String1, param4String2))) != null && !(record = this.a.fieldPool.target(fieldDescription)).isImplicit()) return redefine(record, param4Object, param4Int, param4String3);  return this.cv.visitField(param4Int, param4String1, param4String2, param4String3, param4Object); } @MaybeNull protected FieldVisitor redefine(TypeWriter.FieldPool.Record param4Record, @MaybeNull Object param4Object, int param4Int, @MaybeNull String param4String) { FieldDescription fieldDescription = param4Record.getField(); if ((param4Object = this.cv.visitField(fieldDescription.getActualModifiers() | resolveDeprecationModifiers(param4Int), fieldDescription.getInternalName(), fieldDescription.getDescriptor(), TypeDescription.AbstractBase.RAW_TYPES ? param4String : fieldDescription.getGenericSignature(), param4Record.resolveDefault(param4Object))) == null) return TypeWriter.Default.ForInlining.d();  return new AttributeObtainingFieldVisitor(this, (FieldVisitor)param4Object, param4Record); } @MaybeNull protected MethodVisitor onVisitMethod(int param4Int, String param4String1, String param4String2, @MaybeNull String param4String3, @MaybeNull String[] param4ArrayOfString) { if (param4String1.equals("<clinit>")) { MethodVisitor methodVisitor; if ((methodVisitor = this.cv.visitMethod(param4Int, param4String1, param4String2, param4String3, param4ArrayOfString)) == null) return TypeWriter.Default.ForInlining.e();  return (MethodVisitor)(this.initializationHandler = TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending.of(this.implementationContext.isEnabled(), methodVisitor, this.a.instrumentedType, this.methodPool, this.a.annotationValueFilterFactory, ((this.writerFlags & 0x2) == 0 && this.implementationContext.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V6)), ((this.readerFlags & 0x8) != 0))); }  MethodDescription methodDescription; if ((methodDescription = this.declarableMethods.remove(new TypeWriter.Default.SignatureKey(param4String1, param4String2))) == null) return this.cv.visitMethod(param4Int, param4String1, param4String2, param4String3, param4ArrayOfString);  return redefine(methodDescription, ((param4Int & 0x400) != 0), param4Int, param4String3); } @MaybeNull protected MethodVisitor redefine(MethodDescription param4MethodDescription, boolean param4Boolean, int param4Int, @MaybeNull String param4String) { TypeWriter.MethodPool.Record record; if (!(record = this.methodPool.target(param4MethodDescription)).getSort().isDefined()) return this.cv.visitMethod(param4MethodDescription.getActualModifiers() | resolveDeprecationModifiers(param4Int), param4MethodDescription.getInternalName(), param4MethodDescription.getDescriptor(), TypeDescription.AbstractBase.RAW_TYPES ? param4String : param4MethodDescription.getGenericSignature(), param4MethodDescription.getExceptionTypes().asErasures().toInternalNames());  MethodDescription methodDescription = record.getMethod(); MethodVisitor methodVisitor; if ((methodVisitor = this.cv.visitMethod(ModifierContributor.Resolver.of(Collections.singleton(record.getVisibility())).resolve(methodDescription.getActualModifiers(record.getSort().isImplemented())) | resolveDeprecationModifiers(param4Int), methodDescription.getInternalName(), methodDescription.getDescriptor(), TypeDescription.AbstractBase.RAW_TYPES ? param4String : methodDescription.getGenericSignature(), methodDescription.getExceptionTypes().asErasures().toInternalNames())) == null) return TypeWriter.Default.ForInlining.e();  if (param4Boolean) return new AttributeObtainingMethodVisitor(this, methodVisitor, record);  if (param4MethodDescription.isNative()) { MethodRebaseResolver.Resolution resolution; if ((resolution = TypeWriter.Default.ForInlining.WithFullProcessing.c(this.a).resolve((MethodDescription.InDefinedShape)methodDescription.asDefined())).isRebased()) { MethodVisitor methodVisitor1; if ((methodVisitor1 = visitMethod(resolution.getResolvedMethod().getActualModifiers() | resolveDeprecationModifiers(param4Int), resolution.getResolvedMethod().getInternalName(), resolution.getResolvedMethod().getDescriptor(), TypeDescription.AbstractBase.RAW_TYPES ? param4String : methodDescription.getGenericSignature(), resolution.getResolvedMethod().getExceptionTypes().asErasures().toInternalNames())) != null) methodVisitor1.visitEnd();  }  return new AttributeObtainingMethodVisitor(this, methodVisitor, record); }  return new CodePreservingMethodVisitor(this, methodVisitor, record, TypeWriter.Default.ForInlining.WithFullProcessing.c(this.a).resolve((MethodDescription.InDefinedShape)methodDescription.asDefined())); } protected void onVisitInnerClass(String param4String1, @MaybeNull String param4String2, @MaybeNull String param4String3, int param4Int) { if (!param4String1.equals(this.a.instrumentedType.getInternalName())) { TypeDescription typeDescription; if ((typeDescription = this.declaredTypes.remove(param4String1)) == null) { this.cv.visitInnerClass(param4String1, param4String2, param4String3, param4Int); return; }  this.cv.visitInnerClass(param4String1, (typeDescription.isMemberType() || (param4String2 != null && param4String3 == null && typeDescription.isAnonymousType())) ? this.a.instrumentedType.getInternalName() : TypeWriter.Default.a(), typeDescription.isAnonymousType() ? TypeWriter.Default.a() : typeDescription.getSimpleName(), typeDescription.getModifiers()); }  } protected void onVisitNestMember(String param4String) { if (this.a.instrumentedType.isNestHost() && this.nestMembers.remove(param4String)) this.cv.visitNestMember(param4String);  } protected void onVisitEnd() { for (String str : this.nestMembers) this.cv.visitNestMember(str);  if (this.permittedSubclasses != null) for (String str : this.permittedSubclasses) this.cv.visitPermittedSubclass(str);   if ((typeDescription = this.a.instrumentedType.getDeclaringType()) != null) { this.cv.visitInnerClass(this.a.instrumentedType.getInternalName(), typeDescription.getInternalName(), this.a.instrumentedType.getSimpleName(), this.a.instrumentedType.getModifiers()); } else if (this.a.instrumentedType.isLocalType()) { this.cv.visitInnerClass(this.a.instrumentedType.getInternalName(), TypeWriter.Default.a(), this.a.instrumentedType.getSimpleName(), this.a.instrumentedType.getModifiers()); } else if (this.a.instrumentedType.isAnonymousType()) { this.cv.visitInnerClass(this.a.instrumentedType.getInternalName(), TypeWriter.Default.a(), TypeWriter.Default.a(), this.a.instrumentedType.getModifiers()); }  for (TypeDescription typeDescription : this.declaredTypes.values()) this.cv.visitInnerClass(typeDescription.getInternalName(), typeDescription.isMemberType() ? this.a.instrumentedType.getInternalName() : TypeWriter.Default.a(), typeDescription.isAnonymousType() ? TypeWriter.Default.a() : typeDescription.getSimpleName(), typeDescription.getModifiers());  for (RecordComponentDescription recordComponentDescription : this.declarableRecordComponents.values()) this.a.recordComponentPool.target(recordComponentDescription).apply(this.cv, this.a.annotationValueFilterFactory);  for (FieldDescription fieldDescription : this.declarableFields.values()) this.a.fieldPool.target(fieldDescription).apply(this.cv, this.a.annotationValueFilterFactory);  for (MethodDescription methodDescription : this.declarableMethods.values()) this.methodPool.target(methodDescription).apply(this.cv, (Implementation.Context)this.implementationContext, this.a.annotationValueFilterFactory);  this.initializationHandler.complete(this.cv, this.implementationContext); this.cv.visitEnd(); } private int resolveDeprecationModifiers(int param4Int) { return (this.retainDeprecationModifiers && (param4Int & 0x20000) != 0) ? 131072 : 0; } protected class AttributeObtainingFieldVisitor extends FieldVisitor { private final TypeWriter.FieldPool.Record record; protected AttributeObtainingFieldVisitor(TypeWriter.Default.ForInlining.WithFullProcessing.RedefinitionClassVisitor this$0, FieldVisitor param5FieldVisitor, TypeWriter.FieldPool.Record param5Record) { super(OpenedClassReader.ASM_API, param5FieldVisitor); this.record = param5Record; } @MaybeNull public AnnotationVisitor visitTypeAnnotation(int param5Int, @MaybeNull TypePath param5TypePath, String param5String, boolean param5Boolean) { if (this.a.a.annotationRetention.isEnabled()) return super.visitTypeAnnotation(param5Int, param5TypePath, param5String, param5Boolean);  return TypeWriter.Default.ForInlining.b(); } @MaybeNull public AnnotationVisitor visitAnnotation(String param5String, boolean param5Boolean) { if (this.a.a.annotationRetention.isEnabled()) return super.visitAnnotation(param5String, param5Boolean);  return TypeWriter.Default.ForInlining.b(); } public void visitEnd() { this.record.apply(this.fv, this.a.a.annotationValueFilterFactory); super.visitEnd(); } } protected class AttributeObtainingRecordComponentVisitor extends RecordComponentVisitor { private final TypeWriter.RecordComponentPool.Record record; protected AttributeObtainingRecordComponentVisitor(TypeWriter.Default.ForInlining.WithFullProcessing.RedefinitionClassVisitor this$0, RecordComponentVisitor param5RecordComponentVisitor, TypeWriter.RecordComponentPool.Record param5Record) { super(OpenedClassReader.ASM_API, param5RecordComponentVisitor); this.record = param5Record; } public AnnotationVisitor visitTypeAnnotation(int param5Int, TypePath param5TypePath, String param5String, boolean param5Boolean) { if (this.a.a.annotationRetention.isEnabled()) return super.visitTypeAnnotation(param5Int, param5TypePath, param5String, param5Boolean);  return TypeWriter.Default.ForInlining.b(); } public AnnotationVisitor visitAnnotation(String param5String, boolean param5Boolean) { if (this.a.a.annotationRetention.isEnabled()) return super.visitAnnotation(param5String, param5Boolean);  return TypeWriter.Default.ForInlining.b(); } public void visitEnd() { this.record.apply(getDelegate(), this.a.a.annotationValueFilterFactory); super.visitEnd(); } } protected class CodePreservingMethodVisitor extends MethodVisitor { private final MethodVisitor actualMethodVisitor; private final TypeWriter.MethodPool.Record record; private final MethodRebaseResolver.Resolution resolution; protected CodePreservingMethodVisitor(TypeWriter.Default.ForInlining.WithFullProcessing.RedefinitionClassVisitor this$0, MethodVisitor param5MethodVisitor, TypeWriter.MethodPool.Record param5Record, MethodRebaseResolver.Resolution param5Resolution) { super(OpenedClassReader.ASM_API, param5MethodVisitor); this.actualMethodVisitor = param5MethodVisitor; this.record = param5Record; this.resolution = param5Resolution; param5Record.applyHead(param5MethodVisitor); } @MaybeNull public AnnotationVisitor visitAnnotationDefault() { return TypeWriter.Default.ForInlining.b(); } @MaybeNull public AnnotationVisitor visitTypeAnnotation(int param5Int, @MaybeNull TypePath param5TypePath, String param5String, boolean param5Boolean) { if (this.a.a.annotationRetention.isEnabled()) return super.visitTypeAnnotation(param5Int, param5TypePath, param5String, param5Boolean);  return TypeWriter.Default.ForInlining.b(); } @MaybeNull public AnnotationVisitor visitAnnotation(String param5String, boolean param5Boolean) { if (this.a.a.annotationRetention.isEnabled()) return super.visitAnnotation(param5String, param5Boolean);  return TypeWriter.Default.ForInlining.b(); } public void visitAnnotableParameterCount(int param5Int, boolean param5Boolean) { if (this.a.a.annotationRetention.isEnabled()) super.visitAnnotableParameterCount(param5Int, param5Boolean);  } @MaybeNull public AnnotationVisitor visitParameterAnnotation(int param5Int, String param5String, boolean param5Boolean) { if (this.a.a.annotationRetention.isEnabled()) return super.visitParameterAnnotation(param5Int, param5String, param5Boolean);  return TypeWriter.Default.ForInlining.b(); } public void visitCode() { this.record.applyBody(this.actualMethodVisitor, (Implementation.Context)TypeWriter.Default.ForInlining.WithFullProcessing.RedefinitionClassVisitor.a(this.a), this.a.a.annotationValueFilterFactory); this.actualMethodVisitor.visitEnd(); if (this.resolution.isRebased()) { this.mv = TypeWriter.Default.ForInlining.WithFullProcessing.RedefinitionClassVisitor.b(this.a).visitMethod(this.resolution.getResolvedMethod().getActualModifiers(), this.resolution.getResolvedMethod().getInternalName(), this.resolution.getResolvedMethod().getDescriptor(), this.resolution.getResolvedMethod().getGenericSignature(), this.resolution.getResolvedMethod().getExceptionTypes().asErasures().toInternalNames()); super.visitCode(); if (!this.resolution.getAppendedParameters().isEmpty() && TypeWriter.Default.ForInlining.WithFullProcessing.RedefinitionClassVisitor.a(this.a).getFrameGeneration().isActive()) { if (TypeWriter.Default.ForInlining.WithFullProcessing.RedefinitionClassVisitor.a(this.a).getFrameGeneration() == Implementation.Context.FrameGeneration.GENERATE && this.resolution.getAppendedParameters().size() < 4) { visitFrame(2, this.resolution.getAppendedParameters().size(), TypeWriter.Default.ForInlining.WithFullProcessing.f(), (TypeWriter.Default.ForInlining.WithFullProcessing.f()).length, TypeWriter.Default.ForInlining.WithFullProcessing.f()); } else { Object[] arrayOfObject; (arrayOfObject = new Object[this.resolution.getResolvedMethod().getParameters().size() - this.resolution.getAppendedParameters().size() + 1])[0] = Opcodes.UNINITIALIZED_THIS; for (byte b = 1; b < arrayOfObject.length; b++) { TypeDescription.Generic generic; if ((generic = ((ParameterDescription.InDefinedShape)this.resolution.getResolvedMethod().getParameters().get(b - 1)).getType()).represents(boolean.class) || generic.represents(byte.class) || generic.represents(short.class) || generic.represents(char.class) || generic.represents(int.class)) { arrayOfObject[b] = Opcodes.INTEGER; } else if (generic.represents(long.class)) { arrayOfObject[b] = Opcodes.LONG; } else if (generic.represents(float.class)) { arrayOfObject[b] = Opcodes.FLOAT; } else if (generic.represents(double.class)) { arrayOfObject[b] = Opcodes.DOUBLE; } else { arrayOfObject[b] = generic.asErasure().getInternalName(); }  }  visitFrame(((TypeWriter.Default.ForInlining.WithFullProcessing.RedefinitionClassVisitor.c(this.a) & 0x8) == 0) ? 0 : -1, arrayOfObject.length, arrayOfObject, (TypeWriter.Default.ForInlining.WithFullProcessing.f()).length, TypeWriter.Default.ForInlining.WithFullProcessing.f()); }  visitInsn(0); return; }  } else { this.mv = TypeWriter.Default.ForInlining.e(); super.visitCode(); }  } public void visitMaxs(int param5Int1, int param5Int2) { super.visitMaxs(param5Int1, Math.max(param5Int2, this.resolution.getResolvedMethod().getStackSize())); } } protected class AttributeObtainingMethodVisitor extends MethodVisitor { private final MethodVisitor actualMethodVisitor; private final TypeWriter.MethodPool.Record record; protected AttributeObtainingMethodVisitor(TypeWriter.Default.ForInlining.WithFullProcessing.RedefinitionClassVisitor this$0, MethodVisitor param5MethodVisitor, TypeWriter.MethodPool.Record param5Record) { super(OpenedClassReader.ASM_API, param5MethodVisitor); this.actualMethodVisitor = param5MethodVisitor; this.record = param5Record; param5Record.applyHead(param5MethodVisitor); } @MaybeNull public AnnotationVisitor visitAnnotationDefault() { return TypeWriter.Default.ForInlining.b(); } @MaybeNull public AnnotationVisitor visitTypeAnnotation(int param5Int, @MaybeNull TypePath param5TypePath, String param5String, boolean param5Boolean) { if (this.a.a.annotationRetention.isEnabled()) return super.visitTypeAnnotation(param5Int, param5TypePath, param5String, param5Boolean);  return TypeWriter.Default.ForInlining.b(); } @MaybeNull public AnnotationVisitor visitAnnotation(String param5String, boolean param5Boolean) { if (this.a.a.annotationRetention.isEnabled()) return super.visitAnnotation(param5String, param5Boolean);  return TypeWriter.Default.ForInlining.b(); } public void visitAnnotableParameterCount(int param5Int, boolean param5Boolean) { if (this.a.a.annotationRetention.isEnabled()) super.visitAnnotableParameterCount(param5Int, param5Boolean);  } @MaybeNull public AnnotationVisitor visitParameterAnnotation(int param5Int, String param5String, boolean param5Boolean) { if (this.a.a.annotationRetention.isEnabled()) return super.visitParameterAnnotation(param5Int, param5String, param5Boolean);  return TypeWriter.Default.ForInlining.b(); } public void visitCode() { this.mv = TypeWriter.Default.ForInlining.e(); } public void visitEnd() { this.record.applyBody(this.actualMethodVisitor, (Implementation.Context)TypeWriter.Default.ForInlining.WithFullProcessing.RedefinitionClassVisitor.a(this.a), this.a.a.annotationValueFilterFactory); this.actualMethodVisitor.visitEnd(); } } } } protected static class WithDecorationOnly<V> extends ForInlining<V> { protected WithDecorationOnly(TypeDescription param2TypeDescription, ClassFileVersion param2ClassFileVersion, List<? extends DynamicType> param2List, MethodList<?> param2MethodList, TypeAttributeAppender param2TypeAttributeAppender, AsmVisitorWrapper param2AsmVisitorWrapper, AnnotationValueFilter.Factory param2Factory, AnnotationRetention param2AnnotationRetention, AuxiliaryType.NamingStrategy param2NamingStrategy, Implementation.Context.Factory param2Factory1, TypeValidation param2TypeValidation, ClassWriterStrategy param2ClassWriterStrategy, TypePool param2TypePool, ClassFileLocator param2ClassFileLocator) { super(param2TypeDescription, param2ClassFileVersion, TypeWriter.FieldPool.Disabled.INSTANCE, TypeWriter.RecordComponentPool.Disabled.INSTANCE, param2List, (FieldList<FieldDescription.InDefinedShape>)new LazyFieldList(param2TypeDescription), param2MethodList, (MethodList<?>)new MethodList.Empty(), (RecordComponentList<RecordComponentDescription.InDefinedShape>)new RecordComponentList.Empty(), (LoadedTypeInitializer)LoadedTypeInitializer.NoOp.INSTANCE, TypeInitializer.None.INSTANCE, param2TypeAttributeAppender, param2AsmVisitorWrapper, param2Factory, param2AnnotationRetention, param2NamingStrategy, param2Factory1, param2TypeValidation, param2ClassWriterStrategy, param2TypePool, param2TypeDescription, param2ClassFileLocator); } protected ClassVisitor writeTo(ClassVisitor param2ClassVisitor, TypeInitializer param2TypeInitializer, TypeWriter.Default.ForInlining.ContextRegistry param2ContextRegistry, int param2Int1, int param2Int2) { if (param2TypeInitializer.isDefined()) throw new UnsupportedOperationException("Cannot apply a type initializer for a decoration");  return (ClassVisitor)new DecorationClassVisitor(this, param2ClassVisitor, param2ContextRegistry, param2Int1, param2Int2); } protected static class LazyFieldList extends FieldList.AbstractBase<FieldDescription.InDefinedShape> { private final TypeDescription instrumentedType; protected LazyFieldList(TypeDescription param4TypeDescription) { this.instrumentedType = param4TypeDescription; } public FieldDescription.InDefinedShape get(int param4Int) { return (FieldDescription.InDefinedShape)this.instrumentedType.getDeclaredFields().get(param4Int); } public int size() { return this.instrumentedType.getDeclaredFields().size(); } } @SuppressFBWarnings(value = {"UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR"}, justification = "Field access order is implied by ASM.") protected class DecorationClassVisitor extends MetadataAwareClassVisitor implements TypeInitializer.Drain { protected void onVisitEnd() { this.implementationContext.drain(this, this.cv, this.a.annotationValueFilterFactory); this.cv.visitEnd(); }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final TypeWriter.Default.ForInlining.ContextRegistry contextRegistry;
/*      */ 
/*      */         
/*      */         private final int writerFlags;
/*      */ 
/*      */         
/*      */         private final int readerFlags;
/*      */ 
/*      */         
/*      */         @UnknownNull
/*      */         private Implementation.Context.ExtractableView implementationContext;
/*      */ 
/*      */ 
/*      */         
/*      */         protected DecorationClassVisitor(TypeWriter.Default.ForInlining.WithDecorationOnly this$0, ClassVisitor param4ClassVisitor, TypeWriter.Default.ForInlining.ContextRegistry param4ContextRegistry, int param4Int1, int param4Int2) {
/*      */           super(OpenedClassReader.ASM_API, param4ClassVisitor);
/*      */           this.contextRegistry = param4ContextRegistry;
/*      */           this.writerFlags = param4Int1;
/*      */           this.readerFlags = param4Int2;
/*      */         }
/*      */ 
/*      */         
/*      */         public void visit(int param4Int1, int param4Int2, String param4String1, String param4String2, String param4String3, String[] param4ArrayOfString) {
/*      */           ClassFileVersion classFileVersion = ClassFileVersion.ofMinorMajor(param4Int1);
/*      */           this.implementationContext = this.a.implementationContextFactory.make(this.a.instrumentedType, this.a.auxiliaryTypeNamingStrategy, this.a.typeInitializer, classFileVersion, this.a.classFileVersion, ((this.writerFlags & 0x2) == 0 && classFileVersion.isAtLeast(ClassFileVersion.JAVA_V6)) ? (((this.readerFlags & 0x8) == 0) ? Implementation.Context.FrameGeneration.GENERATE : Implementation.Context.FrameGeneration.EXPAND) : Implementation.Context.FrameGeneration.DISABLED);
/*      */           this.contextRegistry.setImplementationContext(this.implementationContext);
/*      */           this.cv = this.a.asmVisitorWrapper.wrap(this.a.instrumentedType, this.cv, (Implementation.Context)this.implementationContext, this.a.typePool, this.a.fields, this.a.methods, this.writerFlags, this.readerFlags);
/*      */           this.cv.visit(param4Int1, param4Int2, param4String1, param4String2, param4String3, param4ArrayOfString);
/*      */         }
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         protected AnnotationVisitor onVisitTypeAnnotation(int param4Int, TypePath param4TypePath, String param4String, boolean param4Boolean) {
/*      */           if (this.a.annotationRetention.isEnabled()) {
/*      */             return this.cv.visitTypeAnnotation(param4Int, param4TypePath, param4String, param4Boolean);
/*      */           }
/*      */           return TypeWriter.Default.ForInlining.b();
/*      */         }
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         protected AnnotationVisitor onVisitAnnotation(String param4String, boolean param4Boolean) {
/*      */           if (this.a.annotationRetention.isEnabled()) {
/*      */             return this.cv.visitAnnotation(param4String, param4Boolean);
/*      */           }
/*      */           return TypeWriter.Default.ForInlining.b();
/*      */         }
/*      */ 
/*      */         
/*      */         protected void onAfterAttributes() {
/*      */           this.a.typeAttributeAppender.apply(this.cv, this.a.instrumentedType, this.a.annotationValueFilterFactory.on(this.a.instrumentedType));
/*      */         }
/*      */ 
/*      */         
/*      */         public void apply(ClassVisitor param4ClassVisitor, TypeInitializer param4TypeInitializer, Implementation.Context param4Context) {} }
/*      */        }
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForCreation<U>
/*      */       extends Default<U>
/*      */     {
/*      */       private final TypeWriter.MethodPool methodPool;
/*      */ 
/*      */       
/*      */       protected ForCreation(TypeDescription param2TypeDescription, ClassFileVersion param2ClassFileVersion, TypeWriter.FieldPool param2FieldPool, TypeWriter.MethodPool param2MethodPool, TypeWriter.RecordComponentPool param2RecordComponentPool, List<? extends DynamicType> param2List, FieldList<FieldDescription.InDefinedShape> param2FieldList, MethodList<?> param2MethodList1, MethodList<?> param2MethodList2, RecordComponentList<RecordComponentDescription.InDefinedShape> param2RecordComponentList, LoadedTypeInitializer param2LoadedTypeInitializer, TypeInitializer param2TypeInitializer, TypeAttributeAppender param2TypeAttributeAppender, AsmVisitorWrapper param2AsmVisitorWrapper, AnnotationValueFilter.Factory param2Factory, AnnotationRetention param2AnnotationRetention, AuxiliaryType.NamingStrategy param2NamingStrategy, Implementation.Context.Factory param2Factory1, TypeValidation param2TypeValidation, ClassWriterStrategy param2ClassWriterStrategy, TypePool param2TypePool) {
/* 5915 */         super(param2TypeDescription, param2ClassFileVersion, param2FieldPool, param2RecordComponentPool, param2List, param2FieldList, param2MethodList1, param2MethodList2, param2RecordComponentList, param2LoadedTypeInitializer, param2TypeInitializer, param2TypeAttributeAppender, param2AsmVisitorWrapper, param2Factory, param2AnnotationRetention, param2NamingStrategy, param2Factory1, param2TypeValidation, param2ClassWriterStrategy, param2TypePool);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 5935 */         this.methodPool = param2MethodPool;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ContextClassVisitor wrap(ClassVisitor param2ClassVisitor, int param2Int1, int param2Int2) {
/* 5942 */         Implementation.Context.ExtractableView extractableView = this.implementationContextFactory.make(this.instrumentedType, this.auxiliaryTypeNamingStrategy, this.typeInitializer, this.classFileVersion, this.classFileVersion, ((param2Int1 & 0x2) == 0 && this.classFileVersion
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 5947 */             .isAtLeast(ClassFileVersion.JAVA_V6)) ? (((param2Int2 & 0x8) == 0) ? Implementation.Context.FrameGeneration.GENERATE : Implementation.Context.FrameGeneration.EXPAND) : Implementation.Context.FrameGeneration.DISABLED);
/*      */ 
/*      */         
/* 5950 */         return new ImplementationContextClassVisitor(this, (ClassVisitor)new CreationClassVisitor(this, this.asmVisitorWrapper.wrap(this.instrumentedType, 
/* 5951 */                 TypeWriter.Default.ValidatingClassVisitor.of(param2ClassVisitor, this.typeValidation), (Implementation.Context)extractableView, this.typePool, this.fields, this.methods, this.asmVisitorWrapper
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 5956 */                 .mergeWriter(param2Int1), this.asmVisitorWrapper
/* 5957 */                 .mergeReader(param2Int2)), extractableView), extractableView);
/*      */       }
/*      */ 
/*      */       
/*      */       @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Relying on correlated type properties.")
/*      */       protected TypeWriter.Default<U>.UnresolvedType create(TypeInitializer param2TypeInitializer, TypeWriter.Default.ClassDumpAction.Dispatcher param2Dispatcher) {
/* 5963 */         int i = this.asmVisitorWrapper.mergeWriter(0), j = this.asmVisitorWrapper.mergeReader(0);
/* 5964 */         ClassWriter classWriter = this.classWriterStrategy.resolve(i, this.typePool);
/* 5965 */         Implementation.Context.ExtractableView extractableView = this.implementationContextFactory.make(this.instrumentedType, this.auxiliaryTypeNamingStrategy, param2TypeInitializer, this.classFileVersion, this.classFileVersion, ((i & 0x2) == 0 && this.classFileVersion
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 5970 */             .isAtLeast(ClassFileVersion.JAVA_V6)) ? (((j & 0x8) == 0) ? Implementation.Context.FrameGeneration.GENERATE : Implementation.Context.FrameGeneration.EXPAND) : Implementation.Context.FrameGeneration.DISABLED);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         ClassVisitor classVisitor;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 5981 */         (classVisitor = this.asmVisitorWrapper.wrap(this.instrumentedType, TypeWriter.Default.ValidatingClassVisitor.of((ClassVisitor)classWriter, this.typeValidation), (Implementation.Context)extractableView, this.typePool, this.fields, this.methods, i, j)).visit(this.classFileVersion.getMinorMajorVersion(), this.instrumentedType
/* 5982 */             .getActualModifiers(!this.instrumentedType.isInterface()), this.instrumentedType
/* 5983 */             .getInternalName(), this.instrumentedType
/* 5984 */             .getGenericSignature(), (
/* 5985 */             (this.instrumentedType.getSuperClass() == null) ? 
/* 5986 */             TypeDescription.ForLoadedType.of(Object.class) : this.instrumentedType
/* 5987 */             .getSuperClass().asErasure()).getInternalName(), this.instrumentedType
/* 5988 */             .getInterfaces().asErasures().toInternalNames());
/* 5989 */         if (!this.instrumentedType.isNestHost()) {
/* 5990 */           classVisitor.visitNestHost(this.instrumentedType.getNestHost().getInternalName());
/*      */         }
/*      */         MethodDescription.InDefinedShape inDefinedShape;
/* 5993 */         if ((inDefinedShape = this.instrumentedType.getEnclosingMethod()) != null) {
/* 5994 */           classVisitor.visitOuterClass(inDefinedShape.getDeclaringType().getInternalName(), inDefinedShape
/* 5995 */               .getInternalName(), inDefinedShape
/* 5996 */               .getDescriptor());
/* 5997 */         } else if (this.instrumentedType.isLocalType() || this.instrumentedType.isAnonymousType()) {
/* 5998 */           classVisitor.visitOuterClass(this.instrumentedType.getEnclosingType().getInternalName(), TypeWriter.Default.a(), TypeWriter.Default.a());
/*      */         } 
/* 6000 */         this.typeAttributeAppender.apply(classVisitor, this.instrumentedType, this.annotationValueFilterFactory.on(this.instrumentedType));
/* 6001 */         if (this.instrumentedType.isNestHost()) {
/* 6002 */           for (TypeDescription typeDescription1 : this.instrumentedType.getNestMembers().filter((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.is(this.instrumentedType)))) {
/* 6003 */             classVisitor.visitNestMember(typeDescription1.getInternalName());
/*      */           }
/*      */         }
/* 6006 */         for (TypeDescription typeDescription1 : this.instrumentedType.getPermittedSubtypes()) {
/* 6007 */           classVisitor.visitPermittedSubclass(typeDescription1.getInternalName());
/*      */         }
/*      */         
/* 6010 */         if ((typeDescription = this.instrumentedType.getDeclaringType()) != null) {
/* 6011 */           classVisitor.visitInnerClass(this.instrumentedType.getInternalName(), typeDescription
/* 6012 */               .getInternalName(), this.instrumentedType
/* 6013 */               .getSimpleName(), this.instrumentedType
/* 6014 */               .getModifiers());
/* 6015 */         } else if (this.instrumentedType.isLocalType()) {
/* 6016 */           classVisitor.visitInnerClass(this.instrumentedType.getInternalName(), 
/* 6017 */               TypeWriter.Default.a(), this.instrumentedType
/* 6018 */               .getSimpleName(), this.instrumentedType
/* 6019 */               .getModifiers());
/* 6020 */         } else if (this.instrumentedType.isAnonymousType()) {
/* 6021 */           classVisitor.visitInnerClass(this.instrumentedType.getInternalName(), 
/* 6022 */               TypeWriter.Default.a(), 
/* 6023 */               TypeWriter.Default.a(), this.instrumentedType
/* 6024 */               .getModifiers());
/*      */         } 
/* 6026 */         for (TypeDescription typeDescription : this.instrumentedType.getDeclaredTypes()) {
/* 6027 */           classVisitor.visitInnerClass(typeDescription.getInternalName(), 
/* 6028 */               typeDescription.isMemberType() ? this.instrumentedType
/* 6029 */               .getInternalName() : 
/* 6030 */               TypeWriter.Default.a(), 
/* 6031 */               typeDescription.isAnonymousType() ? 
/* 6032 */               TypeWriter.Default.a() : typeDescription
/* 6033 */               .getSimpleName(), typeDescription
/* 6034 */               .getModifiers());
/*      */         }
/* 6036 */         for (RecordComponentDescription recordComponentDescription : this.recordComponents) {
/* 6037 */           this.recordComponentPool.target(recordComponentDescription).apply(classVisitor, this.annotationValueFilterFactory);
/*      */         }
/* 6039 */         for (FieldDescription fieldDescription : this.fields) {
/* 6040 */           this.fieldPool.target(fieldDescription).apply(classVisitor, this.annotationValueFilterFactory);
/*      */         }
/* 6042 */         for (MethodDescription methodDescription : this.instrumentedMethods) {
/* 6043 */           this.methodPool.target(methodDescription).apply(classVisitor, (Implementation.Context)extractableView, this.annotationValueFilterFactory);
/*      */         }
/* 6045 */         extractableView.drain(new TypeInitializer.Drain.Default(this.instrumentedType, this.methodPool, this.annotationValueFilterFactory), classVisitor, this.annotationValueFilterFactory);
/*      */ 
/*      */         
/* 6048 */         classVisitor.visitEnd();
/* 6049 */         return new TypeWriter.Default.UnresolvedType(this, classWriter.toByteArray(), extractableView.getAuxiliaryTypes());
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return !super.equals(param2Object) ? false : ((this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.methodPool.equals(((ForCreation)param2Object).methodPool)))));
/*      */       }
/*      */       
/*      */       public int hashCode() {
/*      */         return super.hashCode() * 31 + this.methodPool.hashCode();
/*      */       }
/*      */       
/*      */       protected class CreationClassVisitor
/*      */         extends MetadataAwareClassVisitor
/*      */       {
/*      */         private final Implementation.Context.ExtractableView implementationContext;
/* 6065 */         private final Set<String> declaredTypes = new HashSet<String>();
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6070 */         private final Set<TypeWriter.Default.SignatureKey> visitedFields = new HashSet<TypeWriter.Default.SignatureKey>();
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6075 */         private final Set<TypeWriter.Default.SignatureKey> visitedMethods = new HashSet<TypeWriter.Default.SignatureKey>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected CreationClassVisitor(TypeWriter.Default.ForCreation this$0, ClassVisitor param3ClassVisitor, Implementation.Context.ExtractableView param3ExtractableView) {
/* 6084 */           super(OpenedClassReader.ASM_API, param3ClassVisitor);
/* 6085 */           this.implementationContext = param3ExtractableView;
/*      */         }
/*      */ 
/*      */         
/*      */         protected void onAfterAttributes() {
/* 6090 */           this.a.typeAttributeAppender.apply(this.cv, this.a.instrumentedType, this.a.annotationValueFilterFactory.on(this.a.instrumentedType));
/*      */         }
/*      */ 
/*      */         
/*      */         protected void onVisitInnerClass(String param3String1, @MaybeNull String param3String2, @MaybeNull String param3String3, int param3Int) {
/* 6095 */           this.declaredTypes.add(param3String1);
/* 6096 */           super.onVisitInnerClass(param3String1, param3String2, param3String3, param3Int);
/*      */         }
/*      */ 
/*      */         
/*      */         protected FieldVisitor onVisitField(int param3Int, String param3String1, String param3String2, @MaybeNull String param3String3, @MaybeNull Object param3Object) {
/* 6101 */           this.visitedFields.add(new TypeWriter.Default.SignatureKey(param3String1, param3String2));
/* 6102 */           return super.onVisitField(param3Int, param3String1, param3String2, param3String3, param3Object);
/*      */         }
/*      */ 
/*      */         
/*      */         protected MethodVisitor onVisitMethod(int param3Int, String param3String1, String param3String2, @MaybeNull String param3String3, @MaybeNull String[] param3ArrayOfString) {
/* 6107 */           this.visitedMethods.add(new TypeWriter.Default.SignatureKey(param3String1, param3String2));
/* 6108 */           return super.onVisitMethod(param3Int, param3String1, param3String2, param3String3, param3ArrayOfString);
/*      */         }
/*      */ 
/*      */         
/*      */         protected void onVisitEnd() {
/* 6113 */           for (TypeDescription typeDescription : this.a.instrumentedType.getDeclaredTypes()) {
/* 6114 */             if (!this.declaredTypes.contains(typeDescription.getInternalName())) {
/* 6115 */               this.cv.visitInnerClass(typeDescription.getInternalName(), 
/* 6116 */                   typeDescription.isMemberType() ? this.a.instrumentedType
/* 6117 */                   .getInternalName() : 
/* 6118 */                   TypeWriter.Default.a(), 
/* 6119 */                   typeDescription.isAnonymousType() ? 
/* 6120 */                   TypeWriter.Default.a() : typeDescription
/* 6121 */                   .getSimpleName(), typeDescription
/* 6122 */                   .getModifiers());
/*      */             }
/*      */           } 
/* 6125 */           for (FieldDescription fieldDescription : this.a.fields) {
/* 6126 */             if (!this.visitedFields.contains(new TypeWriter.Default.SignatureKey(fieldDescription.getName(), fieldDescription.getDescriptor()))) {
/* 6127 */               this.a.fieldPool.target(fieldDescription).apply(this.cv, this.a.annotationValueFilterFactory);
/*      */             }
/*      */           } 
/* 6130 */           for (MethodDescription methodDescription : this.a.instrumentedMethods) {
/* 6131 */             if (!this.visitedMethods.contains(new TypeWriter.Default.SignatureKey(methodDescription.getInternalName(), methodDescription.getDescriptor()))) {
/* 6132 */               TypeWriter.Default.ForCreation.a(this.a).target(methodDescription).apply(this.cv, (Implementation.Context)this.implementationContext, this.a.annotationValueFilterFactory);
/*      */             }
/*      */           } 
/* 6135 */           this.implementationContext.drain(new TypeInitializer.Drain.Default(this.a.instrumentedType, 
/* 6136 */                 TypeWriter.Default.ForCreation.a(this.a), this.a.annotationValueFilterFactory), this.cv, this.a.annotationValueFilterFactory);
/*      */           
/* 6138 */           super.onVisitEnd();
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected class ImplementationContextClassVisitor
/*      */         extends ContextClassVisitor
/*      */       {
/*      */         private final Implementation.Context.ExtractableView implementationContext;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected ImplementationContextClassVisitor(TypeWriter.Default.ForCreation this$0, ClassVisitor param3ClassVisitor, Implementation.Context.ExtractableView param3ExtractableView) {
/* 6159 */           super(param3ClassVisitor);
/* 6160 */           this.implementationContext = param3ExtractableView;
/*      */         }
/*      */ 
/*      */         
/*      */         public List<DynamicType> getAuxiliaryTypes() {
/* 6165 */           return CompoundList.of(this.a.auxiliaryTypes, this.implementationContext.getAuxiliaryTypes());
/*      */         }
/*      */ 
/*      */         
/*      */         public LoadedTypeInitializer getLoadedTypeInitializer() {
/* 6170 */           return this.a.loadedTypeInitializer;
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class ClassDumpAction
/*      */       implements PrivilegedExceptionAction<Void>
/*      */     {
/*      */       @AlwaysNull
/* 6185 */       private static final Void NOTHING = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final String target;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final TypeDescription instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final boolean original;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final long suffix;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final byte[] binaryRepresentation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected ClassDumpAction(String param2String, TypeDescription param2TypeDescription, boolean param2Boolean, long param2Long, byte[] param2ArrayOfbyte) {
/* 6222 */         this.target = param2String;
/* 6223 */         this.instrumentedType = param2TypeDescription;
/* 6224 */         this.original = param2Boolean;
/* 6225 */         this.suffix = param2Long;
/* 6226 */         this.binaryRepresentation = param2ArrayOfbyte;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Void run() {
/* 6233 */         FileOutputStream fileOutputStream = new FileOutputStream(new File(this.target, this.instrumentedType.getName() + (this.original ? "-original." : ".") + this.suffix + ".class"));
/*      */ 
/*      */ 
/*      */         
/*      */         try {
/* 6238 */           fileOutputStream.write(this.binaryRepresentation);
/* 6239 */           return NOTHING;
/*      */         } finally {
/* 6241 */           fileOutputStream.close();
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.original != ((ClassDumpAction)param2Object).original) ? false : ((this.suffix != ((ClassDumpAction)param2Object).suffix) ? false : (!this.target.equals(((ClassDumpAction)param2Object).target) ? false : (!this.instrumentedType.equals(((ClassDumpAction)param2Object).instrumentedType) ? false : (!!Arrays.equals(this.binaryRepresentation, ((ClassDumpAction)param2Object).binaryRepresentation))))))));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return ((((getClass().hashCode() * 31 + this.target.hashCode()) * 31 + this.instrumentedType.hashCode()) * 31 + this.original) * 31 + (int)(this.suffix ^ this.suffix >>> 32L)) * 31 + Arrays.hashCode(this.binaryRepresentation);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       protected static interface Dispatcher
/*      */       {
/*      */         void dump(TypeDescription param3TypeDescription, boolean param3Boolean, byte[] param3ArrayOfbyte);
/*      */ 
/*      */         
/*      */         public enum Disabled
/*      */           implements Dispatcher
/*      */         {
/* 6267 */           INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public final void dump(TypeDescription param4TypeDescription, boolean param4Boolean, byte[] param4ArrayOfbyte) {}
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class Enabled
/*      */           implements Dispatcher
/*      */         {
/*      */           private final String folder;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final long timestamp;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected Enabled(String param4String, long param4Long) {
/* 6300 */             this.folder = param4String;
/* 6301 */             this.timestamp = param4Long;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public void dump(TypeDescription param4TypeDescription, boolean param4Boolean, byte[] param4ArrayOfbyte)
/*      */           {
/*      */             
/* 6309 */             try { TypeWriter.Default.a(new TypeWriter.Default.ClassDumpAction(this.folder, param4TypeDescription, param4Boolean, this.timestamp, param4ArrayOfbyte)); return; }
/* 6310 */             catch (Exception exception)
/* 6311 */             { (param4TypeDescription = null).printStackTrace(); return; }  } public boolean equals(@MaybeNull Object param4Object) { return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : ((this.timestamp != ((Enabled)param4Object).timestamp) ? false : (!!this.folder.equals(((Enabled)param4Object).folder))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.folder.hashCode()) * 31 + (int)(this.timestamp ^ this.timestamp >>> 32L); } } } } public enum Disabled implements ClassDumpAction.Dispatcher { INSTANCE; public final void dump(TypeDescription param2TypeDescription, boolean param2Boolean, byte[] param2ArrayOfbyte) {} } protected static interface Dispatcher { void dump(TypeDescription param2TypeDescription, boolean param2Boolean, byte[] param2ArrayOfbyte); public enum Disabled implements Dispatcher { INSTANCE; public final void dump(TypeDescription param4TypeDescription, boolean param4Boolean, byte[] param4ArrayOfbyte) {} } @Enhance public static class Enabled implements Dispatcher { private final String folder; private final long timestamp; protected Enabled(String param4String, long param4Long) { this.folder = param4String; this.timestamp = param4Long; } public void dump(TypeDescription param4TypeDescription, boolean param4Boolean, byte[] param4ArrayOfbyte) { try { TypeWriter.Default.a(new TypeWriter.Default.ClassDumpAction(this.folder, param4TypeDescription, param4Boolean, this.timestamp, param4ArrayOfbyte)); return; } catch (Exception exception) { (param4TypeDescription = null).printStackTrace(); return; }  } public boolean equals(@MaybeNull Object param4Object) { return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : ((this.timestamp != ((Enabled)param4Object).timestamp) ? false : (!!this.folder.equals(((Enabled)param4Object).folder))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.folder.hashCode()) * 31 + (int)(this.timestamp ^ this.timestamp >>> 32L); } } } @Enhance public static class Enabled implements ClassDumpAction.Dispatcher { private final String folder; private final long timestamp; protected Enabled(String param2String, long param2Long) { this.folder = param2String; this.timestamp = param2Long; } public void dump(TypeDescription param2TypeDescription, boolean param2Boolean, byte[] param2ArrayOfbyte) { try { TypeWriter.Default.a(new TypeWriter.Default.ClassDumpAction(this.folder, param2TypeDescription, param2Boolean, this.timestamp, param2ArrayOfbyte)); return; } catch (Exception exception) { (param2TypeDescription = null).printStackTrace();
/*      */           return; }
/*      */          }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : ((this.timestamp != ((Enabled)param2Object).timestamp) ? false : (!!this.folder.equals(((Enabled)param2Object).folder)))));
/*      */       }
/*      */       
/*      */       public int hashCode() {
/*      */         return (getClass().hashCode() * 31 + this.folder.hashCode()) * 31 + (int)(this.timestamp ^ this.timestamp >>> 32L);
/*      */       } }
/*      */   
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\scaffold\TypeWriter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */