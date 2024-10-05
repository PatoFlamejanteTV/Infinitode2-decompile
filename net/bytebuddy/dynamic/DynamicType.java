/*      */ package net.bytebuddy.dynamic;
/*      */ 
/*      */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*      */ import java.io.File;
/*      */ import java.io.FileInputStream;
/*      */ import java.io.FileOutputStream;
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.reflect.AnnotatedElement;
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Type;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.jar.Attributes;
/*      */ import java.util.jar.JarEntry;
/*      */ import java.util.jar.JarInputStream;
/*      */ import java.util.jar.JarOutputStream;
/*      */ import java.util.jar.Manifest;
/*      */ import net.bytebuddy.ClassFileVersion;
/*      */ import net.bytebuddy.asm.AsmVisitorWrapper;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*      */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*      */ import net.bytebuddy.description.annotation.AnnotationList;
/*      */ import net.bytebuddy.description.annotation.AnnotationValue;
/*      */ import net.bytebuddy.description.field.FieldDescription;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.method.ParameterDescription;
/*      */ import net.bytebuddy.description.method.ParameterList;
/*      */ import net.bytebuddy.description.modifier.FieldManifestation;
/*      */ import net.bytebuddy.description.modifier.MethodManifestation;
/*      */ import net.bytebuddy.description.modifier.ModifierContributor;
/*      */ import net.bytebuddy.description.modifier.Ownership;
/*      */ import net.bytebuddy.description.modifier.Visibility;
/*      */ import net.bytebuddy.description.type.RecordComponentDescription;
/*      */ import net.bytebuddy.description.type.TypeDefinition;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.description.type.TypeList;
/*      */ import net.bytebuddy.description.type.TypeVariableToken;
/*      */ import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
/*      */ import net.bytebuddy.dynamic.loading.InjectionClassLoader;
/*      */ import net.bytebuddy.dynamic.scaffold.ClassWriterStrategy;
/*      */ import net.bytebuddy.dynamic.scaffold.FieldRegistry;
/*      */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*      */ import net.bytebuddy.dynamic.scaffold.MethodGraph;
/*      */ import net.bytebuddy.dynamic.scaffold.MethodRegistry;
/*      */ import net.bytebuddy.dynamic.scaffold.RecordComponentRegistry;
/*      */ import net.bytebuddy.dynamic.scaffold.TypeValidation;
/*      */ import net.bytebuddy.dynamic.scaffold.TypeWriter;
/*      */ import net.bytebuddy.implementation.EqualsMethod;
/*      */ import net.bytebuddy.implementation.FieldAccessor;
/*      */ import net.bytebuddy.implementation.HashCodeMethod;
/*      */ import net.bytebuddy.implementation.Implementation;
/*      */ import net.bytebuddy.implementation.LoadedTypeInitializer;
/*      */ import net.bytebuddy.implementation.ToStringMethod;
/*      */ import net.bytebuddy.implementation.attribute.AnnotationRetention;
/*      */ import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
/*      */ import net.bytebuddy.implementation.attribute.FieldAttributeAppender;
/*      */ import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
/*      */ import net.bytebuddy.implementation.attribute.RecordComponentAttributeAppender;
/*      */ import net.bytebuddy.implementation.attribute.TypeAttributeAppender;
/*      */ import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
/*      */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*      */ import net.bytebuddy.jar.asm.ClassVisitor;
/*      */ import net.bytebuddy.matcher.ElementMatcher;
/*      */ import net.bytebuddy.matcher.ElementMatchers;
/*      */ import net.bytebuddy.matcher.LatentMatcher;
/*      */ import net.bytebuddy.pool.TypePool;
/*      */ import net.bytebuddy.utility.CompoundList;
/*      */ import net.bytebuddy.utility.FileSystem;
/*      */ import net.bytebuddy.utility.nullability.MaybeNull;
/*      */ import net.bytebuddy.utility.visitor.ContextClassVisitor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public interface DynamicType
/*      */   extends ClassFileLocator
/*      */ {
/*      */   TypeDescription getTypeDescription();
/*      */   
/*      */   byte[] getBytes();
/*      */   
/*      */   Map<TypeDescription, byte[]> getAuxiliaryTypes();
/*      */   
/*      */   Map<TypeDescription, byte[]> getAllTypes();
/*      */   
/*      */   Map<TypeDescription, LoadedTypeInitializer> getLoadedTypeInitializers();
/*      */   
/*      */   boolean hasAliveLoadedTypeInitializers();
/*      */   
/*      */   Map<TypeDescription, File> saveIn(File paramFile);
/*      */   
/*      */   File inject(File paramFile1, File paramFile2);
/*      */   
/*      */   File inject(File paramFile);
/*      */   
/*      */   File toJar(File paramFile);
/*      */   
/*      */   File toJar(File paramFile, Manifest paramManifest);
/*      */   
/*      */   public static interface Builder<T>
/*      */   {
/*      */     Builder<T> visit(AsmVisitorWrapper param1AsmVisitorWrapper);
/*      */     
/*      */     Builder<T> name(String param1String);
/*      */     
/*      */     Builder<T> suffix(String param1String);
/*      */     
/*      */     Builder<T> modifiers(ModifierContributor.ForType... param1VarArgs);
/*      */     
/*      */     Builder<T> modifiers(Collection<? extends ModifierContributor.ForType> param1Collection);
/*      */     
/*      */     Builder<T> modifiers(int param1Int);
/*      */     
/*      */     Builder<T> merge(ModifierContributor.ForType... param1VarArgs);
/*      */     
/*      */     Builder<T> merge(Collection<? extends ModifierContributor.ForType> param1Collection);
/*      */     
/*      */     Builder<T> topLevelType();
/*      */     
/*      */     InnerTypeDefinition.ForType<T> innerTypeOf(Class<?> param1Class);
/*      */     
/*      */     InnerTypeDefinition.ForType<T> innerTypeOf(TypeDescription param1TypeDescription);
/*      */     
/*      */     InnerTypeDefinition<T> innerTypeOf(Method param1Method);
/*      */     
/*      */     InnerTypeDefinition<T> innerTypeOf(Constructor<?> param1Constructor);
/*      */     
/*      */     InnerTypeDefinition<T> innerTypeOf(MethodDescription.InDefinedShape param1InDefinedShape);
/*      */     
/*      */     Builder<T> declaredTypes(Class<?>... param1VarArgs);
/*      */     
/*      */     Builder<T> declaredTypes(TypeDescription... param1VarArgs);
/*      */     
/*      */     Builder<T> declaredTypes(List<? extends Class<?>> param1List);
/*      */     
/*      */     Builder<T> declaredTypes(Collection<? extends TypeDescription> param1Collection);
/*      */     
/*      */     Builder<T> noNestMate();
/*      */     
/*      */     Builder<T> nestHost(Class<?> param1Class);
/*      */     
/*      */     Builder<T> nestHost(TypeDescription param1TypeDescription);
/*      */     
/*      */     Builder<T> nestMembers(Class<?>... param1VarArgs);
/*      */     
/*      */     Builder<T> nestMembers(TypeDescription... param1VarArgs);
/*      */     
/*      */     Builder<T> nestMembers(List<? extends Class<?>> param1List);
/*      */     
/*      */     Builder<T> nestMembers(Collection<? extends TypeDescription> param1Collection);
/*      */     
/*      */     Builder<T> permittedSubclass(Class<?>... param1VarArgs);
/*      */     
/*      */     Builder<T> permittedSubclass(TypeDescription... param1VarArgs);
/*      */     
/*      */     Builder<T> permittedSubclass(List<? extends Class<?>> param1List);
/*      */     
/*      */     Builder<T> permittedSubclass(Collection<? extends TypeDescription> param1Collection);
/*      */     
/*      */     Builder<T> unsealed();
/*      */     
/*      */     Builder<T> attribute(TypeAttributeAppender param1TypeAttributeAppender);
/*      */     
/*      */     Builder<T> annotateType(Annotation... param1VarArgs);
/*      */     
/*      */     Builder<T> annotateType(List<? extends Annotation> param1List);
/*      */     
/*      */     Builder<T> annotateType(AnnotationDescription... param1VarArgs);
/*      */     
/*      */     Builder<T> annotateType(Collection<? extends AnnotationDescription> param1Collection);
/*      */     
/*      */     MethodDefinition.ImplementationDefinition.Optional<T> implement(Type... param1VarArgs);
/*      */     
/*      */     MethodDefinition.ImplementationDefinition.Optional<T> implement(List<? extends Type> param1List);
/*      */     
/*      */     MethodDefinition.ImplementationDefinition.Optional<T> implement(TypeDefinition... param1VarArgs);
/*      */     
/*      */     MethodDefinition.ImplementationDefinition.Optional<T> implement(Collection<? extends TypeDefinition> param1Collection);
/*      */     
/*      */     Builder<T> initializer(ByteCodeAppender param1ByteCodeAppender);
/*      */     
/*      */     Builder<T> initializer(LoadedTypeInitializer param1LoadedTypeInitializer);
/*      */     
/*      */     Builder<T> require(TypeDescription param1TypeDescription, byte[] param1ArrayOfbyte);
/*      */     
/*      */     Builder<T> require(TypeDescription param1TypeDescription, byte[] param1ArrayOfbyte, LoadedTypeInitializer param1LoadedTypeInitializer);
/*      */     
/*      */     Builder<T> require(DynamicType... param1VarArgs);
/*      */     
/*      */     Builder<T> require(Collection<DynamicType> param1Collection);
/*      */     
/*      */     TypeVariableDefinition<T> typeVariable(String param1String);
/*      */     
/*      */     TypeVariableDefinition<T> typeVariable(String param1String, Type... param1VarArgs);
/*      */     
/*      */     TypeVariableDefinition<T> typeVariable(String param1String, List<? extends Type> param1List);
/*      */     
/*      */     TypeVariableDefinition<T> typeVariable(String param1String, TypeDefinition... param1VarArgs);
/*      */     
/*      */     TypeVariableDefinition<T> typeVariable(String param1String, Collection<? extends TypeDefinition> param1Collection);
/*      */     
/*      */     Builder<T> transform(ElementMatcher<? super TypeDescription.Generic> param1ElementMatcher, Transformer<TypeVariableToken> param1Transformer);
/*      */     
/*      */     FieldDefinition.Optional.Valuable<T> defineField(String param1String, Type param1Type, ModifierContributor.ForField... param1VarArgs);
/*      */     
/*      */     FieldDefinition.Optional.Valuable<T> defineField(String param1String, Type param1Type, Collection<? extends ModifierContributor.ForField> param1Collection);
/*      */     
/*      */     FieldDefinition.Optional.Valuable<T> defineField(String param1String, Type param1Type, int param1Int);
/*      */     
/*      */     FieldDefinition.Optional.Valuable<T> defineField(String param1String, TypeDefinition param1TypeDefinition, ModifierContributor.ForField... param1VarArgs);
/*      */     
/*      */     FieldDefinition.Optional.Valuable<T> defineField(String param1String, TypeDefinition param1TypeDefinition, Collection<? extends ModifierContributor.ForField> param1Collection);
/*      */     
/*      */     FieldDefinition.Optional.Valuable<T> defineField(String param1String, TypeDefinition param1TypeDefinition, int param1Int);
/*      */     
/*      */     FieldDefinition.Optional.Valuable<T> define(Field param1Field);
/*      */     
/*      */     FieldDefinition.Optional.Valuable<T> define(FieldDescription param1FieldDescription);
/*      */     
/*      */     FieldDefinition.Optional<T> serialVersionUid(long param1Long);
/*      */     
/*      */     FieldDefinition.Valuable<T> field(ElementMatcher<? super FieldDescription> param1ElementMatcher);
/*      */     
/*      */     FieldDefinition.Valuable<T> field(LatentMatcher<? super FieldDescription> param1LatentMatcher);
/*      */     
/*      */     Builder<T> ignoreAlso(ElementMatcher<? super MethodDescription> param1ElementMatcher);
/*      */     
/*      */     Builder<T> ignoreAlso(LatentMatcher<? super MethodDescription> param1LatentMatcher);
/*      */     
/*      */     MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String param1String, Type param1Type, ModifierContributor.ForMethod... param1VarArgs);
/*      */     
/*      */     MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String param1String, Type param1Type, Collection<? extends ModifierContributor.ForMethod> param1Collection);
/*      */     
/*      */     MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String param1String, Type param1Type, int param1Int);
/*      */     
/*      */     MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String param1String, TypeDefinition param1TypeDefinition, ModifierContributor.ForMethod... param1VarArgs);
/*      */     
/*      */     MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String param1String, TypeDefinition param1TypeDefinition, Collection<? extends ModifierContributor.ForMethod> param1Collection);
/*      */     
/*      */     MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String param1String, TypeDefinition param1TypeDefinition, int param1Int);
/*      */     
/*      */     MethodDefinition.ParameterDefinition.Initial<T> defineConstructor(ModifierContributor.ForMethod... param1VarArgs);
/*      */     
/*      */     MethodDefinition.ParameterDefinition.Initial<T> defineConstructor(Collection<? extends ModifierContributor.ForMethod> param1Collection);
/*      */     
/*      */     MethodDefinition.ParameterDefinition.Initial<T> defineConstructor(int param1Int);
/*      */     
/*      */     MethodDefinition.ImplementationDefinition<T> define(Method param1Method);
/*      */     
/*      */     MethodDefinition.ImplementationDefinition<T> define(Constructor<?> param1Constructor);
/*      */     
/*      */     MethodDefinition.ImplementationDefinition<T> define(MethodDescription param1MethodDescription);
/*      */     
/*      */     FieldDefinition.Optional<T> defineProperty(String param1String, Type param1Type);
/*      */     
/*      */     FieldDefinition.Optional<T> defineProperty(String param1String, Type param1Type, boolean param1Boolean);
/*      */     
/*      */     FieldDefinition.Optional<T> defineProperty(String param1String, TypeDefinition param1TypeDefinition);
/*      */     
/*      */     FieldDefinition.Optional<T> defineProperty(String param1String, TypeDefinition param1TypeDefinition, boolean param1Boolean);
/*      */     
/*      */     MethodDefinition.ImplementationDefinition<T> method(ElementMatcher<? super MethodDescription> param1ElementMatcher);
/*      */     
/*      */     MethodDefinition.ImplementationDefinition<T> constructor(ElementMatcher<? super MethodDescription> param1ElementMatcher);
/*      */     
/*      */     MethodDefinition.ImplementationDefinition<T> invokable(ElementMatcher<? super MethodDescription> param1ElementMatcher);
/*      */     
/*      */     MethodDefinition.ImplementationDefinition<T> invokable(LatentMatcher<? super MethodDescription> param1LatentMatcher);
/*      */     
/*      */     Builder<T> withHashCodeEquals();
/*      */     
/*      */     Builder<T> withToString();
/*      */     
/*      */     RecordComponentDefinition.Optional<T> defineRecordComponent(String param1String, Type param1Type);
/*      */     
/*      */     RecordComponentDefinition.Optional<T> defineRecordComponent(String param1String, TypeDefinition param1TypeDefinition);
/*      */     
/*      */     RecordComponentDefinition.Optional<T> define(RecordComponentDescription param1RecordComponentDescription);
/*      */     
/*      */     RecordComponentDefinition<T> recordComponent(ElementMatcher<? super RecordComponentDescription> param1ElementMatcher);
/*      */     
/*      */     RecordComponentDefinition<T> recordComponent(LatentMatcher<? super RecordComponentDescription> param1LatentMatcher);
/*      */     
/*      */     ContextClassVisitor wrap(ClassVisitor param1ClassVisitor);
/*      */     
/*      */     ContextClassVisitor wrap(ClassVisitor param1ClassVisitor, int param1Int1, int param1Int2);
/*      */     
/*      */     ContextClassVisitor wrap(ClassVisitor param1ClassVisitor, TypePool param1TypePool);
/*      */     
/*      */     ContextClassVisitor wrap(ClassVisitor param1ClassVisitor, TypePool param1TypePool, int param1Int1, int param1Int2);
/*      */     
/*      */     DynamicType.Unloaded<T> make();
/*      */     
/*      */     DynamicType.Unloaded<T> make(TypeResolutionStrategy param1TypeResolutionStrategy);
/*      */     
/*      */     DynamicType.Unloaded<T> make(TypePool param1TypePool);
/*      */     
/*      */     DynamicType.Unloaded<T> make(TypeResolutionStrategy param1TypeResolutionStrategy, TypePool param1TypePool);
/*      */     
/*      */     TypeDescription toTypeDescription();
/*      */     
/*      */     public static interface TypeVariableDefinition<S>
/*      */       extends Builder<S>
/*      */     {
/*      */       TypeVariableDefinition<S> annotateTypeVariable(Annotation... param2VarArgs);
/*      */       
/*      */       TypeVariableDefinition<S> annotateTypeVariable(List<? extends Annotation> param2List);
/*      */       
/*      */       TypeVariableDefinition<S> annotateTypeVariable(AnnotationDescription... param2VarArgs);
/*      */       
/*      */       TypeVariableDefinition<S> annotateTypeVariable(Collection<? extends AnnotationDescription> param2Collection);
/*      */       
/*      */       public static abstract class AbstractBase<U>
/*      */         extends DynamicType.Builder.AbstractBase.Delegator<U>
/*      */         implements TypeVariableDefinition<U>
/*      */       {
/*      */         public DynamicType.Builder.TypeVariableDefinition<U> annotateTypeVariable(Annotation... param3VarArgs) {
/* 1605 */           return annotateTypeVariable(Arrays.asList(param3VarArgs));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.TypeVariableDefinition<U> annotateTypeVariable(List<? extends Annotation> param3List) {
/* 1612 */           return annotateTypeVariable((Collection<? extends AnnotationDescription>)new AnnotationList.ForLoadedAnnotations(param3List));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.TypeVariableDefinition<U> annotateTypeVariable(AnnotationDescription... param3VarArgs) {
/* 1619 */           return annotateTypeVariable(Arrays.asList(param3VarArgs));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static interface Valuable<V>
/*      */       extends FieldDefinition.Optional<V>, FieldDefinition.Valuable<V>
/*      */     {
/*      */       public static abstract class AbstractBase<U>
/*      */         extends DynamicType.Builder.FieldDefinition.Optional.AbstractBase<U>
/*      */         implements Valuable<U>
/*      */       {
/*      */         public DynamicType.Builder.FieldDefinition.Optional<U> value(boolean param5Boolean) {
/* 1821 */           return defaultValue(Integer.valueOf(param5Boolean ? 1 : 0));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.FieldDefinition.Optional<U> value(int param5Int) {
/* 1828 */           return defaultValue(Integer.valueOf(param5Int));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.FieldDefinition.Optional<U> value(long param5Long) {
/* 1835 */           return defaultValue(Long.valueOf(param5Long));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.FieldDefinition.Optional<U> value(float param5Float) {
/* 1842 */           return defaultValue(Float.valueOf(param5Float));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.FieldDefinition.Optional<U> value(double param5Double) {
/* 1849 */           return defaultValue(Double.valueOf(param5Double));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.FieldDefinition.Optional<U> value(String param5String) {
/* 1856 */           if (param5String == null) {
/* 1857 */             throw new IllegalArgumentException("Cannot define 'null' as constant value");
/*      */           }
/* 1859 */           return defaultValue(param5String);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected abstract DynamicType.Builder.FieldDefinition.Optional<U> defaultValue(Object param5Object);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         private static abstract class Adapter<V>
/*      */           extends AbstractBase<V>
/*      */         {
/*      */           protected final FieldAttributeAppender.Factory fieldAttributeAppenderFactory;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected final Transformer<FieldDescription> transformer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @MaybeNull
/*      */           @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*      */           protected final Object defaultValue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected Adapter(FieldAttributeAppender.Factory param6Factory, Transformer<FieldDescription> param6Transformer, @MaybeNull Object param6Object) {
/* 1906 */             this.fieldAttributeAppenderFactory = param6Factory;
/* 1907 */             this.transformer = param6Transformer;
/* 1908 */             this.defaultValue = param6Object;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.FieldDefinition.Optional<V> attribute(FieldAttributeAppender.Factory param6Factory) {
/* 1915 */             return materialize((FieldAttributeAppender.Factory)new FieldAttributeAppender.Factory.Compound(new FieldAttributeAppender.Factory[] { this.fieldAttributeAppenderFactory, param6Factory }, ), this.transformer, this.defaultValue);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.FieldDefinition.Optional<V> transform(Transformer<FieldDescription> param6Transformer) {
/* 1923 */             return materialize(this.fieldAttributeAppenderFactory, new Transformer.Compound<FieldDescription>((Transformer<FieldDescription>[])new Transformer[] { this.transformer, param6Transformer }, ), this.defaultValue);
/*      */           }
/*      */           
/*      */           protected DynamicType.Builder.FieldDefinition.Optional<V> defaultValue(Object param6Object)
/*      */           {
/* 1928 */             return materialize(this.fieldAttributeAppenderFactory, this.transformer, param6Object); } protected abstract DynamicType.Builder.FieldDefinition.Optional<V> materialize(FieldAttributeAppender.Factory param6Factory, Transformer<FieldDescription> param6Transformer, @MaybeNull Object param6Object); public boolean equals(@MaybeNull Object param6Object) { Object object; if (this == param6Object) return true;  if (param6Object == null) return false;  if (getClass() != param6Object.getClass()) return false;  if (!this.fieldAttributeAppenderFactory.equals(((Adapter)param6Object).fieldAttributeAppenderFactory)) return false;  if (!this.transformer.equals(((Adapter)param6Object).transformer)) return false;  param6Object = ((Adapter)param6Object).defaultValue; if (param6Object != null) { if ((object = this.defaultValue) != null) { if (!object.equals(param6Object)) return false;  } else { return false; }  } else if ((object = this.defaultValue) != null) { return false; }  return true; } public int hashCode() { Object object; if ((object = this.defaultValue) != null); return ((getClass().hashCode() * 31 + this.fieldAttributeAppenderFactory.hashCode()) * 31 + this.transformer.hashCode()) * 31 + object.hashCode(); } } } } public static interface FieldDefinition<S> { Optional<S> annotateField(Annotation... param2VarArgs); Optional<S> annotateField(List<? extends Annotation> param2List); Optional<S> annotateField(AnnotationDescription... param2VarArgs); Optional<S> annotateField(Collection<? extends AnnotationDescription> param2Collection); Optional<S> attribute(FieldAttributeAppender.Factory param2Factory); Optional<S> transform(Transformer<FieldDescription> param2Transformer); public static interface Optional<U> extends DynamicType.Builder<U>, FieldDefinition<U> { public static interface Valuable<V> extends Optional<V>, DynamicType.Builder.FieldDefinition.Valuable<V> { public static abstract class AbstractBase<U> extends DynamicType.Builder.FieldDefinition.Optional.AbstractBase<U> implements Valuable<U> { public DynamicType.Builder.FieldDefinition.Optional<U> value(boolean param5Boolean) { return defaultValue(Integer.valueOf(param5Boolean ? 1 : 0)); } public DynamicType.Builder.FieldDefinition.Optional<U> value(int param5Int) { return defaultValue(Integer.valueOf(param5Int)); } public DynamicType.Builder.FieldDefinition.Optional<U> value(long param5Long) { return defaultValue(Long.valueOf(param5Long)); } public DynamicType.Builder.FieldDefinition.Optional<U> value(float param5Float) { return defaultValue(Float.valueOf(param5Float)); } public DynamicType.Builder.FieldDefinition.Optional<U> value(double param5Double) { return defaultValue(Double.valueOf(param5Double)); } public DynamicType.Builder.FieldDefinition.Optional<U> value(String param5String) { if (param5String == null) throw new IllegalArgumentException("Cannot define 'null' as constant value");  return defaultValue(param5String); } protected abstract DynamicType.Builder.FieldDefinition.Optional<U> defaultValue(Object param5Object); @Enhance private static abstract class Adapter<V> extends AbstractBase<V> { protected final FieldAttributeAppender.Factory fieldAttributeAppenderFactory; protected final Transformer<FieldDescription> transformer; @MaybeNull @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY) protected final Object defaultValue; protected Adapter(FieldAttributeAppender.Factory param6Factory, Transformer<FieldDescription> param6Transformer, @MaybeNull Object param6Object) { this.fieldAttributeAppenderFactory = param6Factory; this.transformer = param6Transformer; this.defaultValue = param6Object; } public DynamicType.Builder.FieldDefinition.Optional<V> attribute(FieldAttributeAppender.Factory param6Factory) { return materialize((FieldAttributeAppender.Factory)new FieldAttributeAppender.Factory.Compound(new FieldAttributeAppender.Factory[] { this.fieldAttributeAppenderFactory, param6Factory }, ), this.transformer, this.defaultValue); } public DynamicType.Builder.FieldDefinition.Optional<V> transform(Transformer<FieldDescription> param6Transformer) { return materialize(this.fieldAttributeAppenderFactory, new Transformer.Compound<FieldDescription>((Transformer<FieldDescription>[])new Transformer[] { this.transformer, param6Transformer }, ), this.defaultValue); } protected DynamicType.Builder.FieldDefinition.Optional<V> defaultValue(Object param6Object) { return materialize(this.fieldAttributeAppenderFactory, this.transformer, param6Object); } protected abstract DynamicType.Builder.FieldDefinition.Optional<V> materialize(FieldAttributeAppender.Factory param6Factory, Transformer<FieldDescription> param6Transformer, @MaybeNull Object param6Object); public boolean equals(@MaybeNull Object param6Object) {
/*      */                 Object object;
/*      */                 if (this == param6Object)
/*      */                   return true; 
/*      */                 if (param6Object == null)
/*      */                   return false; 
/*      */                 if (getClass() != param6Object.getClass())
/*      */                   return false; 
/*      */                 if (!this.fieldAttributeAppenderFactory.equals(((Adapter)param6Object).fieldAttributeAppenderFactory))
/*      */                   return false; 
/*      */                 if (!this.transformer.equals(((Adapter)param6Object).transformer))
/*      */                   return false; 
/*      */                 param6Object = ((Adapter)param6Object).defaultValue;
/*      */                 if (param6Object != null) {
/*      */                   if ((object = this.defaultValue) != null) {
/*      */                     if (!object.equals(param6Object))
/*      */                       return false; 
/*      */                   } else {
/*      */                     return false;
/*      */                   } 
/*      */                 } else if ((object = this.defaultValue) != null) {
/*      */                   return false;
/*      */                 } 
/*      */                 return true;
/*      */               } public int hashCode() {
/*      */                 Object object;
/*      */                 if ((object = this.defaultValue) != null);
/*      */                 return ((getClass().hashCode() * 31 + this.fieldAttributeAppenderFactory.hashCode()) * 31 + this.transformer.hashCode()) * 31 + object.hashCode();
/*      */               } } } } public static abstract class AbstractBase<U> extends DynamicType.Builder.AbstractBase.Delegator<U> implements Optional<U> { public DynamicType.Builder.FieldDefinition.Optional<U> annotateField(Annotation... param4VarArgs) {
/* 1957 */             return annotateField(Arrays.asList(param4VarArgs));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.FieldDefinition.Optional<U> annotateField(List<? extends Annotation> param4List) {
/* 1964 */             return annotateField((Collection<? extends AnnotationDescription>)new AnnotationList.ForLoadedAnnotations(param4List));
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.FieldDefinition.Optional<U> annotateField(AnnotationDescription... param4VarArgs)
/*      */           {
/* 1971 */             return annotateField(Arrays.asList(param4VarArgs)); } } } public static interface Valuable<U> extends FieldDefinition<U> { DynamicType.Builder.FieldDefinition.Optional<U> value(boolean param3Boolean); DynamicType.Builder.FieldDefinition.Optional<U> value(int param3Int); DynamicType.Builder.FieldDefinition.Optional<U> value(long param3Long); DynamicType.Builder.FieldDefinition.Optional<U> value(float param3Float); DynamicType.Builder.FieldDefinition.Optional<U> value(double param3Double); DynamicType.Builder.FieldDefinition.Optional<U> value(String param3String); } } public static interface Optional<U> extends Builder<U>, FieldDefinition<U> { public static interface Valuable<V> extends Optional<V>, DynamicType.Builder.FieldDefinition.Valuable<V> { public static abstract class AbstractBase<U> extends DynamicType.Builder.FieldDefinition.Optional.AbstractBase<U> implements Valuable<U> { public DynamicType.Builder.FieldDefinition.Optional<U> value(boolean param5Boolean) { return defaultValue(Integer.valueOf(param5Boolean ? 1 : 0)); } public DynamicType.Builder.FieldDefinition.Optional<U> value(int param5Int) { return defaultValue(Integer.valueOf(param5Int)); } public DynamicType.Builder.FieldDefinition.Optional<U> value(long param5Long) { return defaultValue(Long.valueOf(param5Long)); } public DynamicType.Builder.FieldDefinition.Optional<U> value(float param5Float) { return defaultValue(Float.valueOf(param5Float)); } public DynamicType.Builder.FieldDefinition.Optional<U> value(double param5Double) { return defaultValue(Double.valueOf(param5Double)); } public DynamicType.Builder.FieldDefinition.Optional<U> value(String param5String) { if (param5String == null) throw new IllegalArgumentException("Cannot define 'null' as constant value");  return defaultValue(param5String); } protected abstract DynamicType.Builder.FieldDefinition.Optional<U> defaultValue(Object param5Object); @Enhance private static abstract class Adapter<V> extends AbstractBase<V> { protected final FieldAttributeAppender.Factory fieldAttributeAppenderFactory; protected final Transformer<FieldDescription> transformer; @MaybeNull @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY) protected final Object defaultValue; protected Adapter(FieldAttributeAppender.Factory param6Factory, Transformer<FieldDescription> param6Transformer, @MaybeNull Object param6Object) { this.fieldAttributeAppenderFactory = param6Factory; this.transformer = param6Transformer; this.defaultValue = param6Object; } public DynamicType.Builder.FieldDefinition.Optional<V> attribute(FieldAttributeAppender.Factory param6Factory) { return materialize((FieldAttributeAppender.Factory)new FieldAttributeAppender.Factory.Compound(new FieldAttributeAppender.Factory[] { this.fieldAttributeAppenderFactory, param6Factory }, ), this.transformer, this.defaultValue); } public DynamicType.Builder.FieldDefinition.Optional<V> transform(Transformer<FieldDescription> param6Transformer) { return materialize(this.fieldAttributeAppenderFactory, new Transformer.Compound<FieldDescription>((Transformer<FieldDescription>[])new Transformer[] { this.transformer, param6Transformer }, ), this.defaultValue); } protected DynamicType.Builder.FieldDefinition.Optional<V> defaultValue(Object param6Object) { return materialize(this.fieldAttributeAppenderFactory, this.transformer, param6Object); } protected abstract DynamicType.Builder.FieldDefinition.Optional<V> materialize(FieldAttributeAppender.Factory param6Factory, Transformer<FieldDescription> param6Transformer, @MaybeNull Object param6Object); public boolean equals(@MaybeNull Object param6Object) { Object object; if (this == param6Object) return true;  if (param6Object == null) return false;  if (getClass() != param6Object.getClass()) return false;  if (!this.fieldAttributeAppenderFactory.equals(((Adapter)param6Object).fieldAttributeAppenderFactory)) return false;  if (!this.transformer.equals(((Adapter)param6Object).transformer)) return false;  param6Object = ((Adapter)param6Object).defaultValue; if (param6Object != null) { if ((object = this.defaultValue) != null) { if (!object.equals(param6Object)) return false;  } else { return false; }  } else if ((object = this.defaultValue) != null) { return false; }  return true; } public int hashCode() { Object object; if ((object = this.defaultValue) != null); return ((getClass().hashCode() * 31 + this.fieldAttributeAppenderFactory.hashCode()) * 31 + this.transformer.hashCode()) * 31 + object.hashCode(); } } } } public static abstract class AbstractBase<U> extends DynamicType.Builder.AbstractBase.Delegator<U> implements Optional<U> { public DynamicType.Builder.FieldDefinition.Optional<U> annotateField(Annotation... param4VarArgs) { return annotateField(Arrays.asList(param4VarArgs)); } public DynamicType.Builder.FieldDefinition.Optional<U> annotateField(List<? extends Annotation> param4List) { return annotateField((Collection<? extends AnnotationDescription>)new AnnotationList.ForLoadedAnnotations(param4List)); } public DynamicType.Builder.FieldDefinition.Optional<U> annotateField(AnnotationDescription... param4VarArgs) { return annotateField(Arrays.asList(param4VarArgs)); }
/*      */          }
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
/*      */     public static interface ImplementationDefinition<U>
/*      */     {
/*      */       DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<U> intercept(Implementation param2Implementation);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<U> withoutCode();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<U> defaultValue(AnnotationValue<?, ?> param2AnnotationValue);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       <W> DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<U> defaultValue(W param2W, Class<? extends W> param2Class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static abstract class AbstractBase<V>
/*      */         implements ImplementationDefinition<V>
/*      */       {
/*      */         public <W> DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<V> defaultValue(W param4W, Class<? extends W> param4Class) {
/* 2199 */           return defaultValue(AnnotationDescription.ForLoadedAnnotation.asValue(param4W, param4Class));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static interface Optional<V>
/*      */         extends DynamicType.Builder<V>, ImplementationDefinition<V> {}
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static interface Initial<V>
/*      */       extends MethodDefinition.ParameterDefinition<V>, MethodDefinition.ParameterDefinition.Simple<V>
/*      */     {
/*      */       DynamicType.Builder.MethodDefinition.ExceptionDefinition<V> withParameters(Type... param2VarArgs);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       DynamicType.Builder.MethodDefinition.ExceptionDefinition<V> withParameters(List<? extends Type> param2List);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       DynamicType.Builder.MethodDefinition.ExceptionDefinition<V> withParameters(TypeDefinition... param2VarArgs);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       DynamicType.Builder.MethodDefinition.ExceptionDefinition<V> withParameters(Collection<? extends TypeDefinition> param2Collection);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static abstract class AbstractBase<W>
/*      */         extends DynamicType.Builder.MethodDefinition.ParameterDefinition.AbstractBase<W>
/*      */         implements Initial<W>
/*      */       {
/*      */         public DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable<W> withParameter(Type param5Type) {
/* 2933 */           return withParameter((TypeDefinition)TypeDefinition.Sort.describe(param5Type));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.MethodDefinition.ExceptionDefinition<W> withParameters(Type... param5VarArgs) {
/* 2940 */           return withParameters(Arrays.asList(param5VarArgs));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.MethodDefinition.ExceptionDefinition<W> withParameters(List<? extends Type> param5List) {
/* 2947 */           return withParameters((Collection<? extends TypeDefinition>)new TypeList.Generic.ForLoadedTypes(param5List));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.MethodDefinition.ExceptionDefinition<W> withParameters(TypeDefinition... param5VarArgs) {
/* 2954 */           return withParameters(Arrays.asList(param5VarArgs));
/*      */         }
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.MethodDefinition.ExceptionDefinition<W> withParameters(Collection<? extends TypeDefinition> param5Collection)
/*      */         {
/*      */           DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable<W> annotatable;
/* 2961 */           AbstractBase abstractBase = this;
/* 2962 */           for (TypeDefinition typeDefinition : param5Collection) {
/* 2963 */             annotatable = abstractBase.withParameter(typeDefinition);
/*      */           }
/* 2965 */           return annotatable; } } } public static interface ParameterDefinition<U> extends MethodDefinition.ExceptionDefinition<U> { Annotatable<U> withParameter(Type param2Type, String param2String, ModifierContributor.ForParameter... param2VarArgs); Annotatable<U> withParameter(Type param2Type, String param2String, Collection<? extends ModifierContributor.ForParameter> param2Collection); Annotatable<U> withParameter(Type param2Type, String param2String, int param2Int); Annotatable<U> withParameter(TypeDefinition param2TypeDefinition, String param2String, ModifierContributor.ForParameter... param2VarArgs); Annotatable<U> withParameter(TypeDefinition param2TypeDefinition, String param2String, Collection<? extends ModifierContributor.ForParameter> param2Collection); Annotatable<U> withParameter(TypeDefinition param2TypeDefinition, String param2String, int param2Int); public static interface Annotatable<V> extends ParameterDefinition<V> { Annotatable<V> annotateParameter(Annotation... param4VarArgs); Annotatable<V> annotateParameter(List<? extends Annotation> param4List); Annotatable<V> annotateParameter(AnnotationDescription... param4VarArgs); Annotatable<V> annotateParameter(Collection<? extends AnnotationDescription> param4Collection); public static abstract class AbstractBase<W> extends DynamicType.Builder.MethodDefinition.ParameterDefinition.AbstractBase<W> implements Annotatable<W> { public DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable<W> annotateParameter(Annotation... param5VarArgs) { return annotateParameter(Arrays.asList(param5VarArgs)); } public DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable<W> annotateParameter(List<? extends Annotation> param5List) { return annotateParameter((Collection<? extends AnnotationDescription>)new AnnotationList.ForLoadedAnnotations(param5List)); } public DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable<W> annotateParameter(AnnotationDescription... param5VarArgs) { return annotateParameter(Arrays.asList(param5VarArgs)); } protected static abstract class Adapter<X> extends AbstractBase<X> { public DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable<X> withParameter(TypeDefinition param6TypeDefinition, String param6String, int param6Int) { return materialize().withParameter(param6TypeDefinition, param6String, param6Int); } public DynamicType.Builder.MethodDefinition.ExceptionDefinition<X> throwing(Collection<? extends TypeDefinition> param6Collection) { return materialize().throwing(param6Collection); } public DynamicType.Builder.MethodDefinition.TypeVariableDefinition.Annotatable<X> typeVariable(String param6String, Collection<? extends TypeDefinition> param6Collection) { return materialize().typeVariable(param6String, param6Collection); } public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<X> intercept(Implementation param6Implementation) { return materialize().intercept(param6Implementation); } public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<X> withoutCode() { return materialize().withoutCode(); } public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<X> defaultValue(AnnotationValue<?, ?> param6AnnotationValue) { return materialize().defaultValue(param6AnnotationValue); } public <V> DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<X> defaultValue(V param6V, Class<? extends V> param6Class) { return materialize().defaultValue(param6V, param6Class); } protected abstract DynamicType.Builder.MethodDefinition.ParameterDefinition<X> materialize(); } } } public static interface Simple<V> extends DynamicType.Builder.MethodDefinition.ExceptionDefinition<V> { Annotatable<V> withParameter(Type param4Type); Annotatable<V> withParameter(TypeDefinition param4TypeDefinition); public static interface Annotatable<V> extends Simple<V> { Annotatable<V> annotateParameter(Annotation... param5VarArgs); Annotatable<V> annotateParameter(List<? extends Annotation> param5List); Annotatable<V> annotateParameter(AnnotationDescription... param5VarArgs); Annotatable<V> annotateParameter(Collection<? extends AnnotationDescription> param5Collection); public static abstract class AbstractBase<W> extends DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.AbstractBase<W> implements Annotatable<W> { public DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable<W> annotateParameter(Annotation... param6VarArgs) { return annotateParameter(Arrays.asList(param6VarArgs)); } public DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable<W> annotateParameter(List<? extends Annotation> param6List) { return annotateParameter((Collection<? extends AnnotationDescription>)new AnnotationList.ForLoadedAnnotations(param6List)); } public DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable<W> annotateParameter(AnnotationDescription... param6VarArgs) { return annotateParameter(Arrays.asList(param6VarArgs)); } protected static abstract class Adapter<X> extends AbstractBase<X> { public DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable<X> withParameter(TypeDefinition param7TypeDefinition) { return materialize().withParameter(param7TypeDefinition); } public DynamicType.Builder.MethodDefinition.ExceptionDefinition<X> throwing(Collection<? extends TypeDefinition> param7Collection) { return materialize().throwing(param7Collection); } public DynamicType.Builder.MethodDefinition.TypeVariableDefinition.Annotatable<X> typeVariable(String param7String, Collection<? extends TypeDefinition> param7Collection) { return materialize().typeVariable(param7String, param7Collection); } public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<X> intercept(Implementation param7Implementation) { return materialize().intercept(param7Implementation); } public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<X> withoutCode() { return materialize().withoutCode(); } public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<X> defaultValue(AnnotationValue<?, ?> param7AnnotationValue) { return materialize().defaultValue(param7AnnotationValue); } public <V> DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<X> defaultValue(V param7V, Class<? extends V> param7Class) { return materialize().defaultValue(param7V, param7Class); } protected abstract DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple<X> materialize(); } } } public static abstract class AbstractBase<W> extends DynamicType.Builder.MethodDefinition.ExceptionDefinition.AbstractBase<W> implements Simple<W> { public DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable<W> withParameter(Type param5Type) { return withParameter((TypeDefinition)TypeDefinition.Sort.describe(param5Type)); } } } public static interface Initial<V> extends ParameterDefinition<V>, Simple<V> { DynamicType.Builder.MethodDefinition.ExceptionDefinition<V> withParameters(Type... param4VarArgs); DynamicType.Builder.MethodDefinition.ExceptionDefinition<V> withParameters(List<? extends Type> param4List); DynamicType.Builder.MethodDefinition.ExceptionDefinition<V> withParameters(TypeDefinition... param4VarArgs); DynamicType.Builder.MethodDefinition.ExceptionDefinition<V> withParameters(Collection<? extends TypeDefinition> param4Collection); public static abstract class AbstractBase<W> extends DynamicType.Builder.MethodDefinition.ParameterDefinition.AbstractBase<W> implements Initial<W> { public DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable<W> withParameter(Type param5Type) { return withParameter((TypeDefinition)TypeDefinition.Sort.describe(param5Type)); } public DynamicType.Builder.MethodDefinition.ExceptionDefinition<W> withParameters(Type... param5VarArgs) { return withParameters(Arrays.asList(param5VarArgs)); } public DynamicType.Builder.MethodDefinition.ExceptionDefinition<W> withParameters(List<? extends Type> param5List) { return withParameters((Collection<? extends TypeDefinition>)new TypeList.Generic.ForLoadedTypes(param5List)); } public DynamicType.Builder.MethodDefinition.ExceptionDefinition<W> withParameters(TypeDefinition... param5VarArgs) { return withParameters(Arrays.asList(param5VarArgs)); } public DynamicType.Builder.MethodDefinition.ExceptionDefinition<W> withParameters(Collection<? extends TypeDefinition> param5Collection) { DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable<W> annotatable; AbstractBase abstractBase = this; for (TypeDefinition typeDefinition : param5Collection) annotatable = abstractBase.withParameter(typeDefinition);  return annotatable; }
/*      */            }
/*      */          }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static abstract class AbstractBase<V>
/*      */         extends DynamicType.Builder.MethodDefinition.ExceptionDefinition.AbstractBase<V>
/*      */         implements ParameterDefinition<V>
/*      */       {
/*      */         public DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable<V> withParameter(Type param4Type, String param4String, ModifierContributor.ForParameter... param4VarArgs) {
/* 2981 */           return withParameter(param4Type, param4String, Arrays.asList(param4VarArgs));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable<V> withParameter(Type param4Type, String param4String, Collection<? extends ModifierContributor.ForParameter> param4Collection) {
/* 2988 */           return withParameter(param4Type, param4String, ModifierContributor.Resolver.of(param4Collection).resolve());
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable<V> withParameter(Type param4Type, String param4String, int param4Int) {
/* 2995 */           return withParameter((TypeDefinition)TypeDefinition.Sort.describe(param4Type), param4String, param4Int);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable<V> withParameter(TypeDefinition param4TypeDefinition, String param4String, ModifierContributor.ForParameter... param4VarArgs) {
/* 3002 */           return withParameter(param4TypeDefinition, param4String, Arrays.asList(param4VarArgs));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable<V> withParameter(TypeDefinition param4TypeDefinition, String param4String, Collection<? extends ModifierContributor.ForParameter> param4Collection)
/*      */         {
/* 3009 */           return withParameter(param4TypeDefinition, param4String, ModifierContributor.Resolver.of(param4Collection).resolve()); } } } public static interface MethodDefinition<S> extends Builder<S> { MethodDefinition<S> annotateMethod(Annotation... param2VarArgs); MethodDefinition<S> annotateMethod(List<? extends Annotation> param2List); MethodDefinition<S> annotateMethod(AnnotationDescription... param2VarArgs); MethodDefinition<S> annotateMethod(Collection<? extends AnnotationDescription> param2Collection); MethodDefinition<S> annotateParameter(int param2Int, Annotation... param2VarArgs); MethodDefinition<S> annotateParameter(int param2Int, List<? extends Annotation> param2List); MethodDefinition<S> annotateParameter(int param2Int, AnnotationDescription... param2VarArgs); MethodDefinition<S> annotateParameter(int param2Int, Collection<? extends AnnotationDescription> param2Collection); MethodDefinition<S> attribute(MethodAttributeAppender.Factory param2Factory); MethodDefinition<S> transform(Transformer<MethodDescription> param2Transformer); public static interface ReceiverTypeDefinition<U> extends MethodDefinition<U> { DynamicType.Builder.MethodDefinition<U> receiverType(AnnotatedElement param3AnnotatedElement); DynamicType.Builder.MethodDefinition<U> receiverType(TypeDescription.Generic param3Generic); public static abstract class AbstractBase<V> extends DynamicType.Builder.MethodDefinition.AbstractBase<V> implements ReceiverTypeDefinition<V> { public DynamicType.Builder.MethodDefinition<V> receiverType(AnnotatedElement param4AnnotatedElement) { return receiverType(TypeDefinition.Sort.describeAnnotated(param4AnnotatedElement)); } } } public static interface ImplementationDefinition<U> { DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<U> intercept(Implementation param3Implementation); DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<U> withoutCode(); DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<U> defaultValue(AnnotationValue<?, ?> param3AnnotationValue); <W> DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<U> defaultValue(W param3W, Class<? extends W> param3Class); public static abstract class AbstractBase<V> implements ImplementationDefinition<V> { public <W> DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<V> defaultValue(W param4W, Class<? extends W> param4Class) { return defaultValue(AnnotationDescription.ForLoadedAnnotation.asValue(param4W, param4Class)); } } public static interface Optional<V> extends DynamicType.Builder<V>, ImplementationDefinition<V> {} } public static interface TypeVariableDefinition<U> extends ImplementationDefinition<U> { Annotatable<U> typeVariable(String param3String); Annotatable<U> typeVariable(String param3String, Type... param3VarArgs); Annotatable<U> typeVariable(String param3String, List<? extends Type> param3List); Annotatable<U> typeVariable(String param3String, TypeDefinition... param3VarArgs); Annotatable<U> typeVariable(String param3String, Collection<? extends TypeDefinition> param3Collection); public static interface Annotatable<V> extends TypeVariableDefinition<V> { Annotatable<V> annotateTypeVariable(Annotation... param4VarArgs); Annotatable<V> annotateTypeVariable(List<? extends Annotation> param4List); Annotatable<V> annotateTypeVariable(AnnotationDescription... param4VarArgs); Annotatable<V> annotateTypeVariable(Collection<? extends AnnotationDescription> param4Collection); public static abstract class AbstractBase<W> extends DynamicType.Builder.MethodDefinition.TypeVariableDefinition.AbstractBase<W> implements Annotatable<W> { public DynamicType.Builder.MethodDefinition.TypeVariableDefinition.Annotatable<W> annotateTypeVariable(Annotation... param5VarArgs) { return annotateTypeVariable(Arrays.asList(param5VarArgs)); } public DynamicType.Builder.MethodDefinition.TypeVariableDefinition.Annotatable<W> annotateTypeVariable(List<? extends Annotation> param5List) { return annotateTypeVariable((Collection<? extends AnnotationDescription>)new AnnotationList.ForLoadedAnnotations(param5List)); } public DynamicType.Builder.MethodDefinition.TypeVariableDefinition.Annotatable<W> annotateTypeVariable(AnnotationDescription... param5VarArgs) { return annotateTypeVariable(Arrays.asList(param5VarArgs)); } protected static abstract class Adapter<X> extends AbstractBase<X> { public DynamicType.Builder.MethodDefinition.TypeVariableDefinition.Annotatable<X> typeVariable(String param6String, Collection<? extends TypeDefinition> param6Collection) { return materialize().typeVariable(param6String, param6Collection); } public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<X> intercept(Implementation param6Implementation) { return materialize().intercept(param6Implementation); } public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<X> withoutCode() { return materialize().withoutCode(); } public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<X> defaultValue(AnnotationValue<?, ?> param6AnnotationValue) { return materialize().defaultValue(param6AnnotationValue); } public <V> DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<X> defaultValue(V param6V, Class<? extends V> param6Class) { return materialize().defaultValue(param6V, param6Class); } protected abstract DynamicType.Builder.MethodDefinition.ParameterDefinition<X> materialize(); } } } public static abstract class AbstractBase<V> extends DynamicType.Builder.MethodDefinition.ImplementationDefinition.AbstractBase<V> implements TypeVariableDefinition<V> { public DynamicType.Builder.MethodDefinition.TypeVariableDefinition.Annotatable<V> typeVariable(String param4String) { return typeVariable(param4String, Collections.singletonList(Object.class)); } public DynamicType.Builder.MethodDefinition.TypeVariableDefinition.Annotatable<V> typeVariable(String param4String, Type... param4VarArgs) { return typeVariable(param4String, Arrays.asList(param4VarArgs)); } public DynamicType.Builder.MethodDefinition.TypeVariableDefinition.Annotatable<V> typeVariable(String param4String, List<? extends Type> param4List) { return typeVariable(param4String, (Collection<? extends TypeDefinition>)new TypeList.Generic.ForLoadedTypes(param4List)); } public DynamicType.Builder.MethodDefinition.TypeVariableDefinition.Annotatable<V> typeVariable(String param4String, TypeDefinition... param4VarArgs) { return typeVariable(param4String, Arrays.asList(param4VarArgs)); } } } public static interface ExceptionDefinition<U> extends TypeVariableDefinition<U> { ExceptionDefinition<U> throwing(Type... param3VarArgs); ExceptionDefinition<U> throwing(List<? extends Type> param3List); ExceptionDefinition<U> throwing(TypeDefinition... param3VarArgs); ExceptionDefinition<U> throwing(Collection<? extends TypeDefinition> param3Collection); public static abstract class AbstractBase<V> extends DynamicType.Builder.MethodDefinition.TypeVariableDefinition.AbstractBase<V> implements ExceptionDefinition<V> { public DynamicType.Builder.MethodDefinition.ExceptionDefinition<V> throwing(Type... param4VarArgs) { return throwing(Arrays.asList(param4VarArgs)); } public DynamicType.Builder.MethodDefinition.ExceptionDefinition<V> throwing(List<? extends Type> param4List) { return throwing((Collection<? extends TypeDefinition>)new TypeList.Generic.ForLoadedTypes(param4List)); } public DynamicType.Builder.MethodDefinition.ExceptionDefinition<V> throwing(TypeDefinition... param4VarArgs) { return throwing(Arrays.asList(param4VarArgs)); } } } public static interface ParameterDefinition<U> extends ExceptionDefinition<U> { Annotatable<U> withParameter(Type param3Type, String param3String, ModifierContributor.ForParameter... param3VarArgs); Annotatable<U> withParameter(Type param3Type, String param3String, Collection<? extends ModifierContributor.ForParameter> param3Collection); Annotatable<U> withParameter(Type param3Type, String param3String, int param3Int); Annotatable<U> withParameter(TypeDefinition param3TypeDefinition, String param3String, ModifierContributor.ForParameter... param3VarArgs); Annotatable<U> withParameter(TypeDefinition param3TypeDefinition, String param3String, Collection<? extends ModifierContributor.ForParameter> param3Collection); Annotatable<U> withParameter(TypeDefinition param3TypeDefinition, String param3String, int param3Int); public static interface Annotatable<V> extends ParameterDefinition<V> { Annotatable<V> annotateParameter(Annotation... param4VarArgs); Annotatable<V> annotateParameter(List<? extends Annotation> param4List); Annotatable<V> annotateParameter(AnnotationDescription... param4VarArgs); Annotatable<V> annotateParameter(Collection<? extends AnnotationDescription> param4Collection); public static abstract class AbstractBase<W> extends DynamicType.Builder.MethodDefinition.ParameterDefinition.AbstractBase<W> implements Annotatable<W> { public DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable<W> annotateParameter(Annotation... param5VarArgs) { return annotateParameter(Arrays.asList(param5VarArgs)); } public DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable<W> annotateParameter(List<? extends Annotation> param5List) { return annotateParameter((Collection<? extends AnnotationDescription>)new AnnotationList.ForLoadedAnnotations(param5List)); } public DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable<W> annotateParameter(AnnotationDescription... param5VarArgs) { return annotateParameter(Arrays.asList(param5VarArgs)); } protected static abstract class Adapter<X> extends AbstractBase<X> { public DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable<X> withParameter(TypeDefinition param6TypeDefinition, String param6String, int param6Int) { return materialize().withParameter(param6TypeDefinition, param6String, param6Int); } public DynamicType.Builder.MethodDefinition.ExceptionDefinition<X> throwing(Collection<? extends TypeDefinition> param6Collection) { return materialize().throwing(param6Collection); } public DynamicType.Builder.MethodDefinition.TypeVariableDefinition.Annotatable<X> typeVariable(String param6String, Collection<? extends TypeDefinition> param6Collection) { return materialize().typeVariable(param6String, param6Collection); } public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<X> intercept(Implementation param6Implementation) { return materialize().intercept(param6Implementation); } public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<X> withoutCode() { return materialize().withoutCode(); } public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<X> defaultValue(AnnotationValue<?, ?> param6AnnotationValue) { return materialize().defaultValue(param6AnnotationValue); } public <V> DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<X> defaultValue(V param6V, Class<? extends V> param6Class) { return materialize().defaultValue(param6V, param6Class); } protected abstract DynamicType.Builder.MethodDefinition.ParameterDefinition<X> materialize(); } } } public static interface Simple<V> extends DynamicType.Builder.MethodDefinition.ExceptionDefinition<V> { Annotatable<V> withParameter(Type param4Type); Annotatable<V> withParameter(TypeDefinition param4TypeDefinition); public static interface Annotatable<V> extends Simple<V> { Annotatable<V> annotateParameter(Annotation... param5VarArgs); Annotatable<V> annotateParameter(List<? extends Annotation> param5List); Annotatable<V> annotateParameter(AnnotationDescription... param5VarArgs); Annotatable<V> annotateParameter(Collection<? extends AnnotationDescription> param5Collection); public static abstract class AbstractBase<W> extends DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.AbstractBase<W> implements Annotatable<W> { public DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable<W> annotateParameter(Annotation... param6VarArgs) { return annotateParameter(Arrays.asList(param6VarArgs)); } public DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable<W> annotateParameter(List<? extends Annotation> param6List) { return annotateParameter((Collection<? extends AnnotationDescription>)new AnnotationList.ForLoadedAnnotations(param6List)); } public DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable<W> annotateParameter(AnnotationDescription... param6VarArgs) { return annotateParameter(Arrays.asList(param6VarArgs)); } protected static abstract class Adapter<X> extends AbstractBase<X> { public DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable<X> withParameter(TypeDefinition param7TypeDefinition) { return materialize().withParameter(param7TypeDefinition); } public DynamicType.Builder.MethodDefinition.ExceptionDefinition<X> throwing(Collection<? extends TypeDefinition> param7Collection) { return materialize().throwing(param7Collection); } public DynamicType.Builder.MethodDefinition.TypeVariableDefinition.Annotatable<X> typeVariable(String param7String, Collection<? extends TypeDefinition> param7Collection) { return materialize().typeVariable(param7String, param7Collection); } public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<X> intercept(Implementation param7Implementation) { return materialize().intercept(param7Implementation); } public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<X> withoutCode() { return materialize().withoutCode(); } public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<X> defaultValue(AnnotationValue<?, ?> param7AnnotationValue) { return materialize().defaultValue(param7AnnotationValue); } public <V> DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<X> defaultValue(V param7V, Class<? extends V> param7Class) { return materialize().defaultValue(param7V, param7Class); } protected abstract DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple<X> materialize(); } } } public static abstract class AbstractBase<W> extends DynamicType.Builder.MethodDefinition.ExceptionDefinition.AbstractBase<W> implements Simple<W> { public DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable<W> withParameter(Type param5Type) { return withParameter((TypeDefinition)TypeDefinition.Sort.describe(param5Type)); } } } public static interface Initial<V> extends ParameterDefinition<V>, Simple<V> { DynamicType.Builder.MethodDefinition.ExceptionDefinition<V> withParameters(Type... param4VarArgs); DynamicType.Builder.MethodDefinition.ExceptionDefinition<V> withParameters(List<? extends Type> param4List); DynamicType.Builder.MethodDefinition.ExceptionDefinition<V> withParameters(TypeDefinition... param4VarArgs); DynamicType.Builder.MethodDefinition.ExceptionDefinition<V> withParameters(Collection<? extends TypeDefinition> param4Collection); public static abstract class AbstractBase<W> extends DynamicType.Builder.MethodDefinition.ParameterDefinition.AbstractBase<W> implements Initial<W> { public DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable<W> withParameter(Type param5Type) { return withParameter((TypeDefinition)TypeDefinition.Sort.describe(param5Type)); } public DynamicType.Builder.MethodDefinition.ExceptionDefinition<W> withParameters(Type... param5VarArgs) { return withParameters(Arrays.asList(param5VarArgs)); } public DynamicType.Builder.MethodDefinition.ExceptionDefinition<W> withParameters(List<? extends Type> param5List) { return withParameters((Collection<? extends TypeDefinition>)new TypeList.Generic.ForLoadedTypes(param5List)); } public DynamicType.Builder.MethodDefinition.ExceptionDefinition<W> withParameters(TypeDefinition... param5VarArgs) { return withParameters(Arrays.asList(param5VarArgs)); } public DynamicType.Builder.MethodDefinition.ExceptionDefinition<W> withParameters(Collection<? extends TypeDefinition> param5Collection) { DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable<W> annotatable; AbstractBase abstractBase = this; for (TypeDefinition typeDefinition : param5Collection) annotatable = abstractBase.withParameter(typeDefinition);  return annotatable; } } } public static abstract class AbstractBase<V> extends DynamicType.Builder.MethodDefinition.ExceptionDefinition.AbstractBase<V> implements ParameterDefinition<V> { public DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable<V> withParameter(TypeDefinition param4TypeDefinition, String param4String, Collection<? extends ModifierContributor.ForParameter> param4Collection) { return withParameter(param4TypeDefinition, param4String, ModifierContributor.Resolver.of(param4Collection).resolve()); }
/*      */           
/*      */           public DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable<V> withParameter(Type param4Type, String param4String, ModifierContributor.ForParameter... param4VarArgs) {
/*      */             return withParameter(param4Type, param4String, Arrays.asList(param4VarArgs));
/*      */           }
/*      */           public DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable<V> withParameter(Type param4Type, String param4String, Collection<? extends ModifierContributor.ForParameter> param4Collection) {
/*      */             return withParameter(param4Type, param4String, ModifierContributor.Resolver.of(param4Collection).resolve());
/*      */           }
/*      */           public DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable<V> withParameter(Type param4Type, String param4String, int param4Int) {
/*      */             return withParameter((TypeDefinition)TypeDefinition.Sort.describe(param4Type), param4String, param4Int);
/*      */           }
/*      */           public DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable<V> withParameter(TypeDefinition param4TypeDefinition, String param4String, ModifierContributor.ForParameter... param4VarArgs) {
/*      */             return withParameter(param4TypeDefinition, param4String, Arrays.asList(param4VarArgs));
/*      */           } } }
/*      */       
/*      */       public static abstract class AbstractBase<U> extends DynamicType.Builder.AbstractBase.Delegator<U> implements MethodDefinition<U> { public DynamicType.Builder.MethodDefinition<U> annotateMethod(Annotation... param3VarArgs) {
/* 3025 */           return annotateMethod(Arrays.asList(param3VarArgs));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.MethodDefinition<U> annotateMethod(List<? extends Annotation> param3List) {
/* 3032 */           return annotateMethod((Collection<? extends AnnotationDescription>)new AnnotationList.ForLoadedAnnotations(param3List));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.MethodDefinition<U> annotateMethod(AnnotationDescription... param3VarArgs) {
/* 3039 */           return annotateMethod(Arrays.asList(param3VarArgs));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.MethodDefinition<U> annotateParameter(int param3Int, Annotation... param3VarArgs) {
/* 3046 */           return annotateParameter(param3Int, Arrays.asList(param3VarArgs));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.MethodDefinition<U> annotateParameter(int param3Int, List<? extends Annotation> param3List) {
/* 3053 */           return annotateParameter(param3Int, (Collection<? extends AnnotationDescription>)new AnnotationList.ForLoadedAnnotations(param3List));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.MethodDefinition<U> annotateParameter(int param3Int, AnnotationDescription... param3VarArgs) {
/* 3060 */           return annotateParameter(param3Int, Arrays.asList(param3VarArgs));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         protected static abstract class Adapter<V>
/*      */           extends DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition.AbstractBase<V>
/*      */         {
/*      */           protected final MethodRegistry.Handler handler;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected final MethodAttributeAppender.Factory methodAttributeAppenderFactory;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected final Transformer<MethodDescription> transformer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected Adapter(MethodRegistry.Handler param4Handler, MethodAttributeAppender.Factory param4Factory, Transformer<MethodDescription> param4Transformer) {
/* 3096 */             this.handler = param4Handler;
/* 3097 */             this.methodAttributeAppenderFactory = param4Factory;
/* 3098 */             this.transformer = param4Transformer;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.MethodDefinition<V> attribute(MethodAttributeAppender.Factory param4Factory) {
/* 3105 */             return materialize(this.handler, (MethodAttributeAppender.Factory)new MethodAttributeAppender.Factory.Compound(new MethodAttributeAppender.Factory[] { this.methodAttributeAppenderFactory, param4Factory }, ), this.transformer);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.MethodDefinition<V> transform(Transformer<MethodDescription> param4Transformer) {
/* 3113 */             return materialize(this.handler, this.methodAttributeAppenderFactory, new Transformer.Compound<MethodDescription>((Transformer<MethodDescription>[])new Transformer[] { this.transformer, param4Transformer }));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected abstract DynamicType.Builder.MethodDefinition<V> materialize(MethodRegistry.Handler param4Handler, MethodAttributeAppender.Factory param4Factory, Transformer<MethodDescription> param4Transformer);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.handler.equals(((Adapter)param4Object).handler) ? false : (!this.methodAttributeAppenderFactory.equals(((Adapter)param4Object).methodAttributeAppenderFactory) ? false : (!!this.transformer.equals(((Adapter)param4Object).transformer))))));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return ((getClass().hashCode() * 31 + this.handler.hashCode()) * 31 + this.methodAttributeAppenderFactory.hashCode()) * 31 + this.transformer.hashCode();
/*      */           }
/*      */         } }
/*      */        }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static interface RecordComponentDefinition<S>
/*      */     {
/*      */       Optional<S> annotateRecordComponent(Annotation... param2VarArgs);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       Optional<S> annotateRecordComponent(List<? extends Annotation> param2List);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       Optional<S> annotateRecordComponent(AnnotationDescription... param2VarArgs);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       Optional<S> annotateRecordComponent(Collection<? extends AnnotationDescription> param2Collection);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       Optional<S> attribute(RecordComponentAttributeAppender.Factory param2Factory);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       Optional<S> transform(Transformer<RecordComponentDescription> param2Transformer);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static interface Optional<U>
/*      */         extends DynamicType.Builder<U>, RecordComponentDefinition<U>
/*      */       {
/*      */         public static abstract class AbstractBase<U>
/*      */           extends DynamicType.Builder.AbstractBase.Delegator<U>
/*      */           implements Optional<U>
/*      */         {
/*      */           public DynamicType.Builder.RecordComponentDefinition.Optional<U> annotateRecordComponent(Annotation... param4VarArgs) {
/* 3206 */             return annotateRecordComponent(Arrays.asList(param4VarArgs));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.RecordComponentDefinition.Optional<U> annotateRecordComponent(List<? extends Annotation> param4List) {
/* 3213 */             return annotateRecordComponent((Collection<? extends AnnotationDescription>)new AnnotationList.ForLoadedAnnotations(param4List));
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.RecordComponentDefinition.Optional<U> annotateRecordComponent(AnnotationDescription... param4VarArgs)
/*      */           {
/* 3220 */             return annotateRecordComponent(Arrays.asList(param4VarArgs)); } } } } public static interface Optional<U> extends Builder<U>, RecordComponentDefinition<U> { public static abstract class AbstractBase<U> extends DynamicType.Builder.AbstractBase.Delegator<U> implements Optional<U> { public DynamicType.Builder.RecordComponentDefinition.Optional<U> annotateRecordComponent(Annotation... param4VarArgs) { return annotateRecordComponent(Arrays.asList(param4VarArgs)); } public DynamicType.Builder.RecordComponentDefinition.Optional<U> annotateRecordComponent(List<? extends Annotation> param4List) { return annotateRecordComponent((Collection<? extends AnnotationDescription>)new AnnotationList.ForLoadedAnnotations(param4List)); } public DynamicType.Builder.RecordComponentDefinition.Optional<U> annotateRecordComponent(AnnotationDescription... param4VarArgs) { return annotateRecordComponent(Arrays.asList(param4VarArgs)); }
/*      */          }
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
/*      */     public static abstract class AbstractBase<S>
/*      */       implements Builder<S>
/*      */     {
/*      */       public DynamicType.Builder.InnerTypeDefinition.ForType<S> innerTypeOf(Class<?> param2Class) {
/* 3237 */         return innerTypeOf(TypeDescription.ForLoadedType.of(param2Class));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.InnerTypeDefinition<S> innerTypeOf(Method param2Method) {
/* 3244 */         return innerTypeOf((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(param2Method));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.InnerTypeDefinition<S> innerTypeOf(Constructor<?> param2Constructor) {
/* 3251 */         return innerTypeOf((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedConstructor(param2Constructor));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> declaredTypes(Class<?>... param2VarArgs) {
/* 3258 */         return declaredTypes(Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> declaredTypes(TypeDescription... param2VarArgs) {
/* 3265 */         return declaredTypes(Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> declaredTypes(List<? extends Class<?>> param2List) {
/* 3272 */         return declaredTypes((Collection<? extends TypeDescription>)new TypeList.ForLoadedTypes(param2List));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> noNestMate() {
/* 3279 */         return nestHost(TargetType.DESCRIPTION);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> nestHost(Class<?> param2Class) {
/* 3286 */         return nestHost(TypeDescription.ForLoadedType.of(param2Class));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> nestMembers(Class<?>... param2VarArgs) {
/* 3293 */         return nestMembers(Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> nestMembers(TypeDescription... param2VarArgs) {
/* 3300 */         return nestMembers(Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> nestMembers(List<? extends Class<?>> param2List) {
/* 3307 */         return nestMembers((Collection<? extends TypeDescription>)new TypeList.ForLoadedTypes(param2List));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> permittedSubclass(Class<?>... param2VarArgs) {
/* 3314 */         return permittedSubclass(Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> permittedSubclass(TypeDescription... param2VarArgs) {
/* 3321 */         return permittedSubclass(Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> permittedSubclass(List<? extends Class<?>> param2List) {
/* 3328 */         return permittedSubclass((Collection<? extends TypeDescription>)new TypeList.ForLoadedTypes(param2List));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> annotateType(Annotation... param2VarArgs) {
/* 3335 */         return annotateType(Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> annotateType(List<? extends Annotation> param2List) {
/* 3342 */         return annotateType((Collection<? extends AnnotationDescription>)new AnnotationList.ForLoadedAnnotations(param2List));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> annotateType(AnnotationDescription... param2VarArgs) {
/* 3349 */         return annotateType(Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> modifiers(ModifierContributor.ForType... param2VarArgs) {
/* 3356 */         return modifiers(Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> modifiers(Collection<? extends ModifierContributor.ForType> param2Collection) {
/* 3363 */         return modifiers(ModifierContributor.Resolver.of(param2Collection).resolve());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> merge(ModifierContributor.ForType... param2VarArgs) {
/* 3370 */         return merge(Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional<S> implement(Type... param2VarArgs) {
/* 3377 */         return implement(Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional<S> implement(List<? extends Type> param2List) {
/* 3384 */         return implement((Collection<? extends TypeDefinition>)new TypeList.Generic.ForLoadedTypes(param2List));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional<S> implement(TypeDefinition... param2VarArgs) {
/* 3391 */         return implement(Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.TypeVariableDefinition<S> typeVariable(String param2String) {
/* 3398 */         return typeVariable(param2String, new TypeDefinition[] { (TypeDefinition)TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class) });
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.TypeVariableDefinition<S> typeVariable(String param2String, Type... param2VarArgs) {
/* 3405 */         return typeVariable(param2String, Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.TypeVariableDefinition<S> typeVariable(String param2String, List<? extends Type> param2List) {
/* 3412 */         return typeVariable(param2String, (Collection<? extends TypeDefinition>)new TypeList.Generic.ForLoadedTypes(param2List));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.TypeVariableDefinition<S> typeVariable(String param2String, TypeDefinition... param2VarArgs) {
/* 3419 */         return typeVariable(param2String, Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.RecordComponentDefinition.Optional<S> defineRecordComponent(String param2String, Type param2Type) {
/* 3426 */         return defineRecordComponent(param2String, (TypeDefinition)TypeDefinition.Sort.describe(param2Type));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.RecordComponentDefinition.Optional<S> define(RecordComponentDescription param2RecordComponentDescription) {
/* 3433 */         return defineRecordComponent(param2RecordComponentDescription.getActualName(), (TypeDefinition)param2RecordComponentDescription.getType());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.RecordComponentDefinition<S> recordComponent(ElementMatcher<? super RecordComponentDescription> param2ElementMatcher) {
/* 3440 */         return recordComponent((LatentMatcher<? super RecordComponentDescription>)new LatentMatcher.Resolved(param2ElementMatcher));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.FieldDefinition.Optional.Valuable<S> defineField(String param2String, Type param2Type, ModifierContributor.ForField... param2VarArgs) {
/* 3447 */         return defineField(param2String, param2Type, Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.FieldDefinition.Optional.Valuable<S> defineField(String param2String, Type param2Type, Collection<? extends ModifierContributor.ForField> param2Collection) {
/* 3454 */         return defineField(param2String, param2Type, ModifierContributor.Resolver.of(param2Collection).resolve());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.FieldDefinition.Optional.Valuable<S> defineField(String param2String, Type param2Type, int param2Int) {
/* 3461 */         return defineField(param2String, (TypeDefinition)TypeDefinition.Sort.describe(param2Type), param2Int);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.FieldDefinition.Optional.Valuable<S> defineField(String param2String, TypeDefinition param2TypeDefinition, ModifierContributor.ForField... param2VarArgs) {
/* 3468 */         return defineField(param2String, param2TypeDefinition, Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.FieldDefinition.Optional.Valuable<S> defineField(String param2String, TypeDefinition param2TypeDefinition, Collection<? extends ModifierContributor.ForField> param2Collection) {
/* 3475 */         return defineField(param2String, param2TypeDefinition, ModifierContributor.Resolver.of(param2Collection).resolve());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.FieldDefinition.Optional.Valuable<S> define(Field param2Field) {
/* 3482 */         return define((FieldDescription)new FieldDescription.ForLoadedField(param2Field));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.FieldDefinition.Optional.Valuable<S> define(FieldDescription param2FieldDescription) {
/* 3489 */         return defineField(param2FieldDescription.getName(), (TypeDefinition)param2FieldDescription.getType(), param2FieldDescription.getModifiers());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.FieldDefinition.Optional<S> serialVersionUid(long param2Long) {
/* 3496 */         return defineField("serialVersionUID", long.class, new ModifierContributor.ForField[] { (ModifierContributor.ForField)Visibility.PRIVATE, (ModifierContributor.ForField)FieldManifestation.FINAL, (ModifierContributor.ForField)Ownership.STATIC }).value(param2Long);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.FieldDefinition.Valuable<S> field(ElementMatcher<? super FieldDescription> param2ElementMatcher) {
/* 3503 */         return field((LatentMatcher<? super FieldDescription>)new LatentMatcher.Resolved(param2ElementMatcher));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> ignoreAlso(ElementMatcher<? super MethodDescription> param2ElementMatcher) {
/* 3510 */         return ignoreAlso((LatentMatcher<? super MethodDescription>)new LatentMatcher.Resolved(param2ElementMatcher));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial<S> defineMethod(String param2String, Type param2Type, ModifierContributor.ForMethod... param2VarArgs) {
/* 3517 */         return defineMethod(param2String, param2Type, Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial<S> defineMethod(String param2String, Type param2Type, Collection<? extends ModifierContributor.ForMethod> param2Collection) {
/* 3524 */         return defineMethod(param2String, param2Type, ModifierContributor.Resolver.of(param2Collection).resolve());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial<S> defineMethod(String param2String, Type param2Type, int param2Int) {
/* 3531 */         return defineMethod(param2String, (TypeDefinition)TypeDefinition.Sort.describe(param2Type), param2Int);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial<S> defineMethod(String param2String, TypeDefinition param2TypeDefinition, ModifierContributor.ForMethod... param2VarArgs) {
/* 3538 */         return defineMethod(param2String, param2TypeDefinition, Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial<S> defineMethod(String param2String, TypeDefinition param2TypeDefinition, Collection<? extends ModifierContributor.ForMethod> param2Collection) {
/* 3545 */         return defineMethod(param2String, param2TypeDefinition, ModifierContributor.Resolver.of(param2Collection).resolve());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial<S> defineConstructor(ModifierContributor.ForMethod... param2VarArgs) {
/* 3552 */         return defineConstructor(Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial<S> defineConstructor(Collection<? extends ModifierContributor.ForMethod> param2Collection) {
/* 3559 */         return defineConstructor(ModifierContributor.Resolver.of(param2Collection).resolve());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.MethodDefinition.ImplementationDefinition<S> define(Method param2Method) {
/* 3566 */         return define((MethodDescription)new MethodDescription.ForLoadedMethod(param2Method));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.MethodDefinition.ImplementationDefinition<S> define(Constructor<?> param2Constructor) {
/* 3573 */         return define((MethodDescription)new MethodDescription.ForLoadedConstructor(param2Constructor));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.MethodDefinition.ImplementationDefinition<S> define(MethodDescription param2MethodDescription) {
/*      */         DynamicType.Builder.MethodDefinition.TypeVariableDefinition.Annotatable<S> annotatable;
/* 3582 */         DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial<S> initial = param2MethodDescription.isConstructor() ? defineConstructor(param2MethodDescription.getModifiers()) : defineMethod(param2MethodDescription.getInternalName(), (TypeDefinition)param2MethodDescription.getReturnType(), param2MethodDescription.getModifiers());
/*      */         
/*      */         ParameterList parameterList;
/* 3585 */         if ((parameterList = param2MethodDescription.getParameters()).hasExplicitMetaData()) {
/* 3586 */           initial = initial;
/* 3587 */           for (ParameterDescription parameterDescription : parameterList) {
/* 3588 */             exceptionDefinition = initial.withParameter((TypeDefinition)parameterDescription.getType(), parameterDescription.getName(), parameterDescription.getModifiers());
/*      */           }
/* 3590 */           exceptionDefinition = exceptionDefinition;
/*      */         } else {
/* 3592 */           exceptionDefinition = exceptionDefinition.withParameters((Collection<? extends TypeDefinition>)parameterList.asTypeList());
/*      */         } 
/* 3594 */         DynamicType.Builder.MethodDefinition.ExceptionDefinition<S> exceptionDefinition = exceptionDefinition.throwing((Collection<? extends TypeDefinition>)param2MethodDescription.getExceptionTypes());
/* 3595 */         for (TypeDescription.Generic generic : param2MethodDescription.getTypeVariables()) {
/* 3596 */           annotatable = exceptionDefinition.typeVariable(generic.getSymbol(), (Collection<? extends TypeDefinition>)generic.getUpperBounds());
/*      */         }
/* 3598 */         return annotatable;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.FieldDefinition.Optional<S> defineProperty(String param2String, Type param2Type) {
/* 3605 */         return defineProperty(param2String, (TypeDefinition)TypeDefinition.Sort.describe(param2Type));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.FieldDefinition.Optional<S> defineProperty(String param2String, Type param2Type, boolean param2Boolean) {
/* 3612 */         return defineProperty(param2String, (TypeDefinition)TypeDefinition.Sort.describe(param2Type), param2Boolean);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.FieldDefinition.Optional<S> defineProperty(String param2String, TypeDefinition param2TypeDefinition) {
/* 3619 */         return defineProperty(param2String, param2TypeDefinition, false);
/*      */       }
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.FieldDefinition.Optional<S> defineProperty(String param2String, TypeDefinition param2TypeDefinition, boolean param2Boolean) {
/*      */         FieldManifestation fieldManifestation;
/*      */         DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<S> receiverTypeDefinition;
/* 3626 */         if (param2String.length() == 0)
/* 3627 */           throw new IllegalArgumentException("A bean property cannot have an empty name"); 
/* 3628 */         if (param2TypeDefinition.represents(void.class)) {
/* 3629 */           throw new IllegalArgumentException("A bean property cannot have a void type");
/*      */         }
/* 3631 */         AbstractBase abstractBase = this;
/*      */         
/* 3633 */         if (!param2Boolean) {
/*      */ 
/*      */ 
/*      */           
/* 3637 */           receiverTypeDefinition = abstractBase.defineMethod("set" + Character.toUpperCase(param2String.charAt(0)) + param2String.substring(1), void.class, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PUBLIC }).withParameters(new TypeDefinition[] { param2TypeDefinition }).intercept((Implementation)FieldAccessor.ofField(param2String));
/* 3638 */           fieldManifestation = FieldManifestation.PLAIN;
/*      */         } else {
/* 3640 */           fieldManifestation = FieldManifestation.FINAL;
/*      */         } 
/* 3642 */         return receiverTypeDefinition
/* 3643 */           .defineMethod((param2TypeDefinition.represents(boolean.class) ? "is" : "get") + 
/*      */             
/* 3645 */             Character.toUpperCase(param2String.charAt(0)) + param2String.substring(1), param2TypeDefinition, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PUBLIC
/* 3646 */             }).intercept((Implementation)FieldAccessor.ofField(param2String))
/* 3647 */           .defineField(param2String, param2TypeDefinition, new ModifierContributor.ForField[] { (ModifierContributor.ForField)Visibility.PRIVATE, (ModifierContributor.ForField)fieldManifestation });
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.MethodDefinition.ImplementationDefinition<S> method(ElementMatcher<? super MethodDescription> param2ElementMatcher) {
/* 3654 */         return invokable((ElementMatcher<? super MethodDescription>)ElementMatchers.isMethod().and(param2ElementMatcher));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.MethodDefinition.ImplementationDefinition<S> constructor(ElementMatcher<? super MethodDescription> param2ElementMatcher) {
/* 3661 */         return invokable((ElementMatcher<? super MethodDescription>)ElementMatchers.isConstructor().and(param2ElementMatcher));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder.MethodDefinition.ImplementationDefinition<S> invokable(ElementMatcher<? super MethodDescription> param2ElementMatcher) {
/* 3668 */         return invokable((LatentMatcher<? super MethodDescription>)new LatentMatcher.Resolved(param2ElementMatcher));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> withHashCodeEquals() {
/* 3675 */         return method((ElementMatcher<? super MethodDescription>)ElementMatchers.isHashCode())
/* 3676 */           .intercept((Implementation)HashCodeMethod.usingDefaultOffset().withIgnoredFields((ElementMatcher)ElementMatchers.isSynthetic()))
/* 3677 */           .method((ElementMatcher<? super MethodDescription>)ElementMatchers.isEquals())
/* 3678 */           .intercept((Implementation)EqualsMethod.isolated().withIgnoredFields((ElementMatcher)ElementMatchers.isSynthetic()));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> withToString() {
/* 3685 */         return method((ElementMatcher<? super MethodDescription>)ElementMatchers.isToString()).intercept((Implementation)ToStringMethod.prefixedBySimpleClassName());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> require(TypeDescription param2TypeDescription, byte[] param2ArrayOfbyte) {
/* 3692 */         return require(param2TypeDescription, param2ArrayOfbyte, (LoadedTypeInitializer)LoadedTypeInitializer.NoOp.INSTANCE);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> require(TypeDescription param2TypeDescription, byte[] param2ArrayOfbyte, LoadedTypeInitializer param2LoadedTypeInitializer) {
/* 3699 */         return require(new DynamicType[] { new DynamicType.Default(param2TypeDescription, param2ArrayOfbyte, param2LoadedTypeInitializer, Collections.emptyList()) });
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Builder<S> require(DynamicType... param2VarArgs) {
/* 3706 */         return require(Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ContextClassVisitor wrap(ClassVisitor param2ClassVisitor) {
/* 3713 */         return wrap(param2ClassVisitor, 0, 0);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ContextClassVisitor wrap(ClassVisitor param2ClassVisitor, TypePool param2TypePool) {
/* 3720 */         return wrap(param2ClassVisitor, param2TypePool, 0, 0);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Unloaded<S> make(TypePool param2TypePool) {
/* 3727 */         return make(TypeResolutionStrategy.Passive.INSTANCE, param2TypePool);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Unloaded<S> make() {
/* 3734 */         return make(TypeResolutionStrategy.Passive.INSTANCE);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static abstract class Delegator<U>
/*      */         extends AbstractBase<U>
/*      */       {
/*      */         public DynamicType.Builder<U> visit(AsmVisitorWrapper param3AsmVisitorWrapper) {
/* 3748 */           return materialize().visit(param3AsmVisitorWrapper);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> initializer(LoadedTypeInitializer param3LoadedTypeInitializer) {
/* 3755 */           return materialize().initializer(param3LoadedTypeInitializer);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> annotateType(Collection<? extends AnnotationDescription> param3Collection) {
/* 3762 */           return materialize().annotateType(param3Collection);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> attribute(TypeAttributeAppender param3TypeAttributeAppender) {
/* 3769 */           return materialize().attribute(param3TypeAttributeAppender);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> modifiers(int param3Int) {
/* 3776 */           return materialize().modifiers(param3Int);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> merge(Collection<? extends ModifierContributor.ForType> param3Collection) {
/* 3783 */           return materialize().merge(param3Collection);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> suffix(String param3String) {
/* 3790 */           return materialize().suffix(param3String);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> name(String param3String) {
/* 3797 */           return materialize().name(param3String);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> topLevelType() {
/* 3804 */           return materialize().topLevelType();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.InnerTypeDefinition.ForType<U> innerTypeOf(TypeDescription param3TypeDescription) {
/* 3811 */           return materialize().innerTypeOf(param3TypeDescription);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.InnerTypeDefinition<U> innerTypeOf(MethodDescription.InDefinedShape param3InDefinedShape) {
/* 3818 */           return materialize().innerTypeOf(param3InDefinedShape);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> declaredTypes(Collection<? extends TypeDescription> param3Collection) {
/* 3825 */           return materialize().declaredTypes(param3Collection);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> nestHost(TypeDescription param3TypeDescription) {
/* 3832 */           return materialize().nestHost(param3TypeDescription);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> nestMembers(Collection<? extends TypeDescription> param3Collection) {
/* 3839 */           return materialize().nestMembers(param3Collection);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> permittedSubclass(Collection<? extends TypeDescription> param3Collection) {
/* 3846 */           return materialize().permittedSubclass(param3Collection);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> unsealed() {
/* 3853 */           return materialize().unsealed();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional<U> implement(Collection<? extends TypeDefinition> param3Collection) {
/* 3860 */           return materialize().implement(param3Collection);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> initializer(ByteCodeAppender param3ByteCodeAppender) {
/* 3867 */           return materialize().initializer(param3ByteCodeAppender);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> ignoreAlso(ElementMatcher<? super MethodDescription> param3ElementMatcher) {
/* 3874 */           return materialize().ignoreAlso(param3ElementMatcher);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> ignoreAlso(LatentMatcher<? super MethodDescription> param3LatentMatcher) {
/* 3881 */           return materialize().ignoreAlso(param3LatentMatcher);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.TypeVariableDefinition<U> typeVariable(String param3String, Collection<? extends TypeDefinition> param3Collection) {
/* 3888 */           return materialize().typeVariable(param3String, param3Collection);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> transform(ElementMatcher<? super TypeDescription.Generic> param3ElementMatcher, Transformer<TypeVariableToken> param3Transformer) {
/* 3895 */           return materialize().transform(param3ElementMatcher, param3Transformer);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.FieldDefinition.Optional.Valuable<U> defineField(String param3String, TypeDefinition param3TypeDefinition, int param3Int) {
/* 3902 */           return materialize().defineField(param3String, param3TypeDefinition, param3Int);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.FieldDefinition.Valuable<U> field(LatentMatcher<? super FieldDescription> param3LatentMatcher) {
/* 3909 */           return materialize().field(param3LatentMatcher);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial<U> defineMethod(String param3String, TypeDefinition param3TypeDefinition, int param3Int) {
/* 3916 */           return materialize().defineMethod(param3String, param3TypeDefinition, param3Int);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial<U> defineConstructor(int param3Int) {
/* 3923 */           return materialize().defineConstructor(param3Int);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.MethodDefinition.ImplementationDefinition<U> invokable(LatentMatcher<? super MethodDescription> param3LatentMatcher) {
/* 3930 */           return materialize().invokable(param3LatentMatcher);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> require(Collection<DynamicType> param3Collection) {
/* 3937 */           return materialize().require(param3Collection);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.RecordComponentDefinition.Optional<U> defineRecordComponent(String param3String, TypeDefinition param3TypeDefinition) {
/* 3944 */           return materialize().defineRecordComponent(param3String, param3TypeDefinition);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.RecordComponentDefinition.Optional<U> define(RecordComponentDescription param3RecordComponentDescription) {
/* 3951 */           return materialize().define(param3RecordComponentDescription);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.RecordComponentDefinition<U> recordComponent(ElementMatcher<? super RecordComponentDescription> param3ElementMatcher) {
/* 3958 */           return materialize().recordComponent(param3ElementMatcher);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.RecordComponentDefinition<U> recordComponent(LatentMatcher<? super RecordComponentDescription> param3LatentMatcher) {
/* 3965 */           return materialize().recordComponent(param3LatentMatcher);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ContextClassVisitor wrap(ClassVisitor param3ClassVisitor, int param3Int1, int param3Int2) {
/* 3972 */           return materialize().wrap(param3ClassVisitor, param3Int1, param3Int2);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ContextClassVisitor wrap(ClassVisitor param3ClassVisitor, TypePool param3TypePool, int param3Int1, int param3Int2) {
/* 3979 */           return materialize().wrap(param3ClassVisitor, param3TypePool, param3Int1, param3Int2);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Unloaded<U> make() {
/* 3986 */           return materialize().make();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Unloaded<U> make(TypeResolutionStrategy param3TypeResolutionStrategy) {
/* 3993 */           return materialize().make(param3TypeResolutionStrategy);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Unloaded<U> make(TypePool param3TypePool) {
/* 4000 */           return materialize().make(param3TypePool);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Unloaded<U> make(TypeResolutionStrategy param3TypeResolutionStrategy, TypePool param3TypePool) {
/* 4007 */           return materialize().make(param3TypeResolutionStrategy, param3TypePool);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription toTypeDescription() {
/* 4014 */           return materialize().toTypeDescription();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected abstract DynamicType.Builder<U> materialize();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static abstract class UsingTypeWriter<U>
/*      */         extends AbstractBase<U>
/*      */       {
/*      */         public ContextClassVisitor wrap(ClassVisitor param3ClassVisitor, int param3Int1, int param3Int2) {
/* 4036 */           return toTypeWriter().wrap(param3ClassVisitor, param3Int1, param3Int2);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ContextClassVisitor wrap(ClassVisitor param3ClassVisitor, TypePool param3TypePool, int param3Int1, int param3Int2) {
/* 4043 */           return toTypeWriter(param3TypePool).wrap(param3ClassVisitor, param3Int1, param3Int2);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Unloaded<U> make(TypeResolutionStrategy param3TypeResolutionStrategy) {
/* 4050 */           return toTypeWriter().make(param3TypeResolutionStrategy.resolve());
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Unloaded<U> make(TypeResolutionStrategy param3TypeResolutionStrategy, TypePool param3TypePool) {
/* 4057 */           return toTypeWriter(param3TypePool).make(param3TypeResolutionStrategy.resolve());
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected abstract TypeWriter<U> toTypeWriter();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected abstract TypeWriter<U> toTypeWriter(TypePool param3TypePool);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static abstract class Adapter<U>
/*      */         extends UsingTypeWriter<U>
/*      */       {
/*      */         protected final InstrumentedType.WithFlexibleName instrumentedType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final FieldRegistry fieldRegistry;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final MethodRegistry methodRegistry;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final RecordComponentRegistry recordComponentRegistry;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final TypeAttributeAppender typeAttributeAppender;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final AsmVisitorWrapper asmVisitorWrapper;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final ClassFileVersion classFileVersion;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final AnnotationValueFilter.Factory annotationValueFilterFactory;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final AnnotationRetention annotationRetention;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final Implementation.Context.Factory implementationContextFactory;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final MethodGraph.Compiler methodGraphCompiler;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final TypeValidation typeValidation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final VisibilityBridgeStrategy visibilityBridgeStrategy;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final ClassWriterStrategy classWriterStrategy;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final LatentMatcher<? super MethodDescription> ignoredMethods;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final List<? extends DynamicType> auxiliaryTypes;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected Adapter(InstrumentedType.WithFlexibleName param3WithFlexibleName, FieldRegistry param3FieldRegistry, MethodRegistry param3MethodRegistry, RecordComponentRegistry param3RecordComponentRegistry, TypeAttributeAppender param3TypeAttributeAppender, AsmVisitorWrapper param3AsmVisitorWrapper, ClassFileVersion param3ClassFileVersion, AuxiliaryType.NamingStrategy param3NamingStrategy, AnnotationValueFilter.Factory param3Factory, AnnotationRetention param3AnnotationRetention, Implementation.Context.Factory param3Factory1, MethodGraph.Compiler param3Compiler, TypeValidation param3TypeValidation, VisibilityBridgeStrategy param3VisibilityBridgeStrategy, ClassWriterStrategy param3ClassWriterStrategy, LatentMatcher<? super MethodDescription> param3LatentMatcher, List<? extends DynamicType> param3List) {
/* 4207 */           this.instrumentedType = param3WithFlexibleName;
/* 4208 */           this.fieldRegistry = param3FieldRegistry;
/* 4209 */           this.methodRegistry = param3MethodRegistry;
/* 4210 */           this.recordComponentRegistry = param3RecordComponentRegistry;
/* 4211 */           this.typeAttributeAppender = param3TypeAttributeAppender;
/* 4212 */           this.asmVisitorWrapper = param3AsmVisitorWrapper;
/* 4213 */           this.classFileVersion = param3ClassFileVersion;
/* 4214 */           this.auxiliaryTypeNamingStrategy = param3NamingStrategy;
/* 4215 */           this.annotationValueFilterFactory = param3Factory;
/* 4216 */           this.annotationRetention = param3AnnotationRetention;
/* 4217 */           this.implementationContextFactory = param3Factory1;
/* 4218 */           this.methodGraphCompiler = param3Compiler;
/* 4219 */           this.typeValidation = param3TypeValidation;
/* 4220 */           this.visibilityBridgeStrategy = param3VisibilityBridgeStrategy;
/* 4221 */           this.classWriterStrategy = param3ClassWriterStrategy;
/* 4222 */           this.ignoredMethods = param3LatentMatcher;
/* 4223 */           this.auxiliaryTypes = param3List;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.FieldDefinition.Optional.Valuable<U> defineField(String param3String, TypeDefinition param3TypeDefinition, int param3Int) {
/* 4230 */           return new FieldDefinitionAdapter(new FieldDescription.Token(param3String, param3Int, param3TypeDefinition.asGenericType()));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.FieldDefinition.Valuable<U> field(LatentMatcher<? super FieldDescription> param3LatentMatcher) {
/* 4237 */           return new FieldMatchAdapter(param3LatentMatcher);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial<U> defineMethod(String param3String, TypeDefinition param3TypeDefinition, int param3Int) {
/* 4244 */           return new MethodDefinitionAdapter(this, new MethodDescription.Token(param3String, param3Int, param3TypeDefinition.asGenericType()));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial<U> defineConstructor(int param3Int) {
/* 4251 */           return new MethodDefinitionAdapter(this, new MethodDescription.Token(param3Int));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.MethodDefinition.ImplementationDefinition<U> invokable(LatentMatcher<? super MethodDescription> param3LatentMatcher) {
/* 4258 */           return new MethodMatchAdapter(this, param3LatentMatcher);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional<U> implement(Collection<? extends TypeDefinition> param3Collection) {
/* 4265 */           return new OptionalMethodMatchAdapter(this, (TypeList.Generic)new TypeList.Generic.Explicit(new ArrayList<TypeDefinition>(param3Collection)));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> ignoreAlso(LatentMatcher<? super MethodDescription> param3LatentMatcher) {
/* 4273 */           return materialize(this.instrumentedType, this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, (LatentMatcher<? super MethodDescription>)new LatentMatcher.Disjunction(new LatentMatcher[] { this.ignoredMethods, param3LatentMatcher }, ), this.auxiliaryTypes);
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
/*      */         public DynamicType.Builder.RecordComponentDefinition.Optional<U> defineRecordComponent(String param3String, TypeDefinition param3TypeDefinition) {
/* 4296 */           return new RecordComponentDefinitionAdapter(new RecordComponentDescription.Token(param3String, param3TypeDefinition.asGenericType()));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.RecordComponentDefinition<U> recordComponent(LatentMatcher<? super RecordComponentDescription> param3LatentMatcher) {
/* 4303 */           return new RecordComponentMatchAdapter(param3LatentMatcher);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> initializer(ByteCodeAppender param3ByteCodeAppender) {
/* 4310 */           return materialize(this.instrumentedType.withInitializer(param3ByteCodeAppender), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
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
/*      */         public DynamicType.Builder<U> initializer(LoadedTypeInitializer param3LoadedTypeInitializer) {
/* 4333 */           return materialize(this.instrumentedType.withInitializer(param3LoadedTypeInitializer), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
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
/*      */         public DynamicType.Builder<U> name(String param3String) {
/* 4356 */           return materialize(this.instrumentedType.withName(param3String), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
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
/*      */         public DynamicType.Builder<U> suffix(String param3String) {
/* 4379 */           return name(this.instrumentedType.getName() + "$" + param3String);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> modifiers(int param3Int) {
/* 4386 */           return materialize(this.instrumentedType.withModifiers(param3Int), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
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
/*      */         public DynamicType.Builder<U> merge(Collection<? extends ModifierContributor.ForType> param3Collection) {
/* 4409 */           return materialize(this.instrumentedType.withModifiers(ModifierContributor.Resolver.of(param3Collection).resolve(this.instrumentedType.getModifiers())), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
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
/*      */         public DynamicType.Builder<U> topLevelType() {
/* 4432 */           return materialize(this.instrumentedType
/* 4433 */               .withDeclaringType(TypeDescription.UNDEFINED)
/* 4434 */               .withEnclosingType(TypeDescription.UNDEFINED)
/* 4435 */               .withLocalClass(false), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
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
/*      */         public DynamicType.Builder.InnerTypeDefinition.ForType<U> innerTypeOf(TypeDescription param3TypeDescription) {
/* 4458 */           return new InnerTypeDefinitionForTypeAdapter(this, param3TypeDescription);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder.InnerTypeDefinition<U> innerTypeOf(MethodDescription.InDefinedShape param3InDefinedShape) {
/* 4465 */           return param3InDefinedShape.isTypeInitializer() ? new InnerTypeDefinitionForTypeAdapter(this, param3InDefinedShape
/* 4466 */               .getDeclaringType()) : new InnerTypeDefinitionForMethodAdapter(this, param3InDefinedShape);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> declaredTypes(Collection<? extends TypeDescription> param3Collection) {
/* 4474 */           return materialize(this.instrumentedType.withDeclaredTypes((TypeList)new TypeList.Explicit(new ArrayList<TypeDescription>(param3Collection))), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
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
/*      */         public DynamicType.Builder<U> nestHost(TypeDescription param3TypeDescription) {
/* 4497 */           return materialize(this.instrumentedType.withNestHost(param3TypeDescription), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
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
/*      */         public DynamicType.Builder<U> nestMembers(Collection<? extends TypeDescription> param3Collection) {
/* 4520 */           return materialize(this.instrumentedType.withNestMembers((TypeList)new TypeList.Explicit(new ArrayList<TypeDescription>(param3Collection))), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
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
/*      */         public DynamicType.Builder<U> permittedSubclass(Collection<? extends TypeDescription> param3Collection) {
/* 4543 */           return materialize(this.instrumentedType.withPermittedSubclasses((TypeList)new TypeList.Explicit(new ArrayList<TypeDescription>(param3Collection))), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
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
/*      */         public DynamicType.Builder<U> unsealed() {
/* 4566 */           return materialize(this.instrumentedType.withPermittedSubclasses(TypeList.UNDEFINED), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
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
/*      */         public DynamicType.Builder.TypeVariableDefinition<U> typeVariable(String param3String, Collection<? extends TypeDefinition> param3Collection) {
/* 4589 */           return new TypeVariableDefinitionAdapter(this, new TypeVariableToken(param3String, (List)new TypeList.Generic.Explicit(new ArrayList<TypeDefinition>(param3Collection))));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public DynamicType.Builder<U> transform(ElementMatcher<? super TypeDescription.Generic> param3ElementMatcher, Transformer<TypeVariableToken> param3Transformer) {
/* 4596 */           return materialize(this.instrumentedType.withTypeVariables(param3ElementMatcher, param3Transformer), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
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
/*      */         public DynamicType.Builder<U> attribute(TypeAttributeAppender param3TypeAttributeAppender) {
/* 4619 */           return materialize(this.instrumentedType, this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, (TypeAttributeAppender)new TypeAttributeAppender.Compound(new TypeAttributeAppender[] { this.typeAttributeAppender, param3TypeAttributeAppender }, ), this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
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
/*      */         public DynamicType.Builder<U> annotateType(Collection<? extends AnnotationDescription> param3Collection) {
/* 4642 */           return materialize(this.instrumentedType.withAnnotations(new ArrayList<AnnotationDescription>(param3Collection)), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
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
/*      */         public DynamicType.Builder<U> visit(AsmVisitorWrapper param3AsmVisitorWrapper) {
/* 4665 */           return materialize(this.instrumentedType, this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, (AsmVisitorWrapper)new AsmVisitorWrapper.Compound(new AsmVisitorWrapper[] { this.asmVisitorWrapper, param3AsmVisitorWrapper }, ), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes);
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
/*      */         public DynamicType.Builder<U> require(Collection<DynamicType> param3Collection) {
/* 4688 */           return materialize(this.instrumentedType, this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 4704 */               CompoundList.of(this.auxiliaryTypes, new ArrayList<DynamicType>(param3Collection)));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public TypeDescription toTypeDescription() {
/* 4711 */           return (TypeDescription)this.instrumentedType;
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
/*      */         protected abstract DynamicType.Builder<U> materialize(InstrumentedType.WithFlexibleName param3WithFlexibleName, FieldRegistry param3FieldRegistry, MethodRegistry param3MethodRegistry, RecordComponentRegistry param3RecordComponentRegistry, TypeAttributeAppender param3TypeAttributeAppender, AsmVisitorWrapper param3AsmVisitorWrapper, ClassFileVersion param3ClassFileVersion, AuxiliaryType.NamingStrategy param3NamingStrategy, AnnotationValueFilter.Factory param3Factory, AnnotationRetention param3AnnotationRetention, Implementation.Context.Factory param3Factory1, MethodGraph.Compiler param3Compiler, TypeValidation param3TypeValidation, VisibilityBridgeStrategy param3VisibilityBridgeStrategy, ClassWriterStrategy param3ClassWriterStrategy, LatentMatcher<? super MethodDescription> param3LatentMatcher, List<? extends DynamicType> param3List);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.annotationRetention.equals(((Adapter)param3Object).annotationRetention) ? false : (!this.typeValidation.equals(((Adapter)param3Object).typeValidation) ? false : (!this.instrumentedType.equals(((Adapter)param3Object).instrumentedType) ? false : (!this.fieldRegistry.equals(((Adapter)param3Object).fieldRegistry) ? false : (!this.methodRegistry.equals(((Adapter)param3Object).methodRegistry) ? false : (!this.recordComponentRegistry.equals(((Adapter)param3Object).recordComponentRegistry) ? false : (!this.typeAttributeAppender.equals(((Adapter)param3Object).typeAttributeAppender) ? false : (!this.asmVisitorWrapper.equals(((Adapter)param3Object).asmVisitorWrapper) ? false : (!this.classFileVersion.equals(((Adapter)param3Object).classFileVersion) ? false : (!this.auxiliaryTypeNamingStrategy.equals(((Adapter)param3Object).auxiliaryTypeNamingStrategy) ? false : (!this.annotationValueFilterFactory.equals(((Adapter)param3Object).annotationValueFilterFactory) ? false : (!this.implementationContextFactory.equals(((Adapter)param3Object).implementationContextFactory) ? false : (!this.methodGraphCompiler.equals(((Adapter)param3Object).methodGraphCompiler) ? false : (!this.visibilityBridgeStrategy.equals(((Adapter)param3Object).visibilityBridgeStrategy) ? false : (!this.classWriterStrategy.equals(((Adapter)param3Object).classWriterStrategy) ? false : (!this.ignoredMethods.equals(((Adapter)param3Object).ignoredMethods) ? false : (!!this.auxiliaryTypes.equals(((Adapter)param3Object).auxiliaryTypes))))))))))))))))))));
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
/*      */         public int hashCode() {
/*      */           return ((((((((((((((((getClass().hashCode() * 31 + this.instrumentedType.hashCode()) * 31 + this.fieldRegistry.hashCode()) * 31 + this.methodRegistry.hashCode()) * 31 + this.recordComponentRegistry.hashCode()) * 31 + this.typeAttributeAppender.hashCode()) * 31 + this.asmVisitorWrapper.hashCode()) * 31 + this.classFileVersion.hashCode()) * 31 + this.auxiliaryTypeNamingStrategy.hashCode()) * 31 + this.annotationValueFilterFactory.hashCode()) * 31 + this.annotationRetention.hashCode()) * 31 + this.implementationContextFactory.hashCode()) * 31 + this.methodGraphCompiler.hashCode()) * 31 + this.typeValidation.hashCode()) * 31 + this.visibilityBridgeStrategy.hashCode()) * 31 + this.classWriterStrategy.hashCode()) * 31 + this.ignoredMethods.hashCode()) * 31 + this.auxiliaryTypes.hashCode();
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
/*      */         @Enhance(includeSyntheticFields = true)
/*      */         protected class InnerTypeDefinitionForTypeAdapter
/*      */           extends DynamicType.Builder.AbstractBase.Delegator<U>
/*      */           implements DynamicType.Builder.InnerTypeDefinition.ForType<U>
/*      */         {
/*      */           private final TypeDescription typeDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected InnerTypeDefinitionForTypeAdapter(DynamicType.Builder.AbstractBase.Adapter this$0, TypeDescription param4TypeDescription) {
/* 4771 */             this.typeDescription = param4TypeDescription;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder<U> asAnonymousType() {
/* 4778 */             return this.a.materialize(this.a.instrumentedType
/* 4779 */                 .withDeclaringType(TypeDescription.UNDEFINED)
/* 4780 */                 .withEnclosingType(this.typeDescription)
/* 4781 */                 .withAnonymousClass(true), this.a.fieldRegistry, this.a.methodRegistry, this.a.recordComponentRegistry, this.a.typeAttributeAppender, this.a.asmVisitorWrapper, this.a.classFileVersion, this.a.auxiliaryTypeNamingStrategy, this.a.annotationValueFilterFactory, this.a.annotationRetention, this.a.implementationContextFactory, this.a.methodGraphCompiler, this.a.typeValidation, this.a.visibilityBridgeStrategy, this.a.classWriterStrategy, this.a.ignoredMethods, this.a.auxiliaryTypes);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder<U> asMemberType() {
/* 4804 */             return this.a.materialize(this.a.instrumentedType
/* 4805 */                 .withDeclaringType(this.typeDescription)
/* 4806 */                 .withEnclosingType(this.typeDescription)
/* 4807 */                 .withAnonymousClass(false)
/* 4808 */                 .withLocalClass(false), this.a.fieldRegistry, this.a.methodRegistry, this.a.recordComponentRegistry, this.a.typeAttributeAppender, this.a.asmVisitorWrapper, this.a.classFileVersion, this.a.auxiliaryTypeNamingStrategy, this.a.annotationValueFilterFactory, this.a.annotationRetention, this.a.implementationContextFactory, this.a.methodGraphCompiler, this.a.typeValidation, this.a.visibilityBridgeStrategy, this.a.classWriterStrategy, this.a.ignoredMethods, this.a.auxiliaryTypes);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected DynamicType.Builder<U> materialize() {
/* 4829 */             return this.a.materialize(this.a.instrumentedType
/* 4830 */                 .withDeclaringType(TypeDescription.UNDEFINED)
/* 4831 */                 .withEnclosingType(this.typeDescription)
/* 4832 */                 .withLocalClass(true), this.a.fieldRegistry, this.a.methodRegistry, this.a.recordComponentRegistry, this.a.typeAttributeAppender, this.a.asmVisitorWrapper, this.a.classFileVersion, this.a.auxiliaryTypeNamingStrategy, this.a.annotationValueFilterFactory, this.a.annotationRetention, this.a.implementationContextFactory, this.a.methodGraphCompiler, this.a.typeValidation, this.a.visibilityBridgeStrategy, this.a.classWriterStrategy, this.a.ignoredMethods, this.a.auxiliaryTypes);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.typeDescription.equals(((InnerTypeDefinitionForTypeAdapter)param4Object).typeDescription) ? false : (!!this.a.equals(((InnerTypeDefinitionForTypeAdapter)param4Object).a)))));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return (getClass().hashCode() * 31 + this.typeDescription.hashCode()) * 31 + this.a.hashCode();
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance(includeSyntheticFields = true)
/*      */         protected class InnerTypeDefinitionForMethodAdapter
/*      */           extends DynamicType.Builder.AbstractBase.Delegator<U>
/*      */           implements DynamicType.Builder.InnerTypeDefinition<U>
/*      */         {
/*      */           private final MethodDescription.InDefinedShape methodDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected InnerTypeDefinitionForMethodAdapter(DynamicType.Builder.AbstractBase.Adapter this$0, MethodDescription.InDefinedShape param4InDefinedShape) {
/* 4869 */             this.methodDescription = param4InDefinedShape;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder<U> asAnonymousType() {
/* 4876 */             return this.a.materialize(this.a.instrumentedType
/* 4877 */                 .withDeclaringType(TypeDescription.UNDEFINED)
/* 4878 */                 .withEnclosingMethod(this.methodDescription)
/* 4879 */                 .withAnonymousClass(true), this.a.fieldRegistry, this.a.methodRegistry, this.a.recordComponentRegistry, this.a.typeAttributeAppender, this.a.asmVisitorWrapper, this.a.classFileVersion, this.a.auxiliaryTypeNamingStrategy, this.a.annotationValueFilterFactory, this.a.annotationRetention, this.a.implementationContextFactory, this.a.methodGraphCompiler, this.a.typeValidation, this.a.visibilityBridgeStrategy, this.a.classWriterStrategy, this.a.ignoredMethods, this.a.auxiliaryTypes);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected DynamicType.Builder<U> materialize() {
/* 4900 */             return this.a.materialize(this.a.instrumentedType
/* 4901 */                 .withDeclaringType(TypeDescription.UNDEFINED)
/* 4902 */                 .withEnclosingMethod(this.methodDescription)
/* 4903 */                 .withLocalClass(true), this.a.fieldRegistry, this.a.methodRegistry, this.a.recordComponentRegistry, this.a.typeAttributeAppender, this.a.asmVisitorWrapper, this.a.classFileVersion, this.a.auxiliaryTypeNamingStrategy, this.a.annotationValueFilterFactory, this.a.annotationRetention, this.a.implementationContextFactory, this.a.methodGraphCompiler, this.a.typeValidation, this.a.visibilityBridgeStrategy, this.a.classWriterStrategy, this.a.ignoredMethods, this.a.auxiliaryTypes);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.methodDescription.equals(((InnerTypeDefinitionForMethodAdapter)param4Object).methodDescription) ? false : (!!this.a.equals(((InnerTypeDefinitionForMethodAdapter)param4Object).a)))));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return (getClass().hashCode() * 31 + this.methodDescription.hashCode()) * 31 + this.a.hashCode();
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance(includeSyntheticFields = true)
/*      */         protected class TypeVariableDefinitionAdapter
/*      */           extends DynamicType.Builder.TypeVariableDefinition.AbstractBase<U>
/*      */         {
/*      */           private final TypeVariableToken token;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected TypeVariableDefinitionAdapter(DynamicType.Builder.AbstractBase.Adapter this$0, TypeVariableToken param4TypeVariableToken) {
/* 4940 */             this.token = param4TypeVariableToken;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.TypeVariableDefinition<U> annotateTypeVariable(Collection<? extends AnnotationDescription> param4Collection) {
/* 4947 */             return new TypeVariableDefinitionAdapter(this.a, new TypeVariableToken(this.token.getSymbol(), (List)this.token
/* 4948 */                   .getBounds(), 
/* 4949 */                   CompoundList.of((List)this.token.getAnnotations(), new ArrayList<AnnotationDescription>(param4Collection))));
/*      */           }
/*      */ 
/*      */           
/*      */           protected DynamicType.Builder<U> materialize() {
/* 4954 */             return this.a.materialize(this.a.instrumentedType.withTypeVariable(this.token), this.a.fieldRegistry, this.a.methodRegistry, this.a.recordComponentRegistry, this.a.typeAttributeAppender, this.a.asmVisitorWrapper, this.a.classFileVersion, this.a.auxiliaryTypeNamingStrategy, this.a.annotationValueFilterFactory, this.a.annotationRetention, this.a.implementationContextFactory, this.a.methodGraphCompiler, this.a.typeValidation, this.a.visibilityBridgeStrategy, this.a.classWriterStrategy, this.a.ignoredMethods, this.a.auxiliaryTypes);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.token.equals(((TypeVariableDefinitionAdapter)param4Object).token) ? false : (!!this.a.equals(((TypeVariableDefinitionAdapter)param4Object).a)))));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return (getClass().hashCode() * 31 + this.token.hashCode()) * 31 + this.a.hashCode();
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance(includeSyntheticFields = true)
/*      */         protected class FieldDefinitionAdapter
/*      */           extends DynamicType.Builder.FieldDefinition.Optional.Valuable.AbstractBase.Adapter<U>
/*      */         {
/*      */           private final FieldDescription.Token token;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected FieldDefinitionAdapter(FieldDescription.Token param4Token) {
/* 4991 */             this((FieldAttributeAppender.Factory)FieldAttributeAppender.ForInstrumentedField.INSTANCE, 
/* 4992 */                 Transformer.NoOp.make(), FieldDescription.NO_DEFAULT_VALUE, param4Token);
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
/*      */ 
/*      */           
/*      */           protected FieldDefinitionAdapter(FieldAttributeAppender.Factory param4Factory, @MaybeNull Transformer<FieldDescription> param4Transformer, Object param4Object, FieldDescription.Token param4Token) {
/* 5009 */             super(param4Factory, param4Transformer, param4Object);
/* 5010 */             this.token = param4Token;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.FieldDefinition.Optional<U> annotateField(Collection<? extends AnnotationDescription> param4Collection) {
/* 5017 */             return new FieldDefinitionAdapter(this.fieldAttributeAppenderFactory, this.transformer, this.defaultValue, new FieldDescription.Token(this.token.getName(), this.token
/* 5018 */                   .getModifiers(), this.token
/* 5019 */                   .getType(), 
/* 5020 */                   CompoundList.of((List)this.token.getAnnotations(), new ArrayList<AnnotationDescription>(param4Collection))));
/*      */           }
/*      */ 
/*      */           
/*      */           protected DynamicType.Builder<U> materialize() {
/* 5025 */             return this.a.materialize(this.a.instrumentedType.withField(this.token), this.a.fieldRegistry
/* 5026 */                 .prepend((LatentMatcher)new LatentMatcher.ForFieldToken(this.token), this.fieldAttributeAppenderFactory, this.defaultValue, this.transformer), this.a.methodRegistry, this.a.recordComponentRegistry, this.a.typeAttributeAppender, this.a.asmVisitorWrapper, this.a.classFileVersion, this.a.auxiliaryTypeNamingStrategy, this.a.annotationValueFilterFactory, this.a.annotationRetention, this.a.implementationContextFactory, this.a.methodGraphCompiler, this.a.typeValidation, this.a.visibilityBridgeStrategy, this.a.classWriterStrategy, this.a.ignoredMethods, this.a.auxiliaryTypes);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected DynamicType.Builder.FieldDefinition.Optional<U> materialize(FieldAttributeAppender.Factory param4Factory, Transformer<FieldDescription> param4Transformer, @MaybeNull Object param4Object) {
/* 5048 */             return new FieldDefinitionAdapter(param4Factory, param4Transformer, param4Object, this.token);
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.token.equals(((FieldDefinitionAdapter)param4Object).token) ? false : (!!this.a.equals(((FieldDefinitionAdapter)param4Object).a))))));
/*      */           }
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return (super.hashCode() * 31 + this.token.hashCode()) * 31 + this.a.hashCode();
/*      */           }
/*      */         }
/*      */         
/*      */         @Enhance(includeSyntheticFields = true)
/*      */         protected class FieldMatchAdapter
/*      */           extends DynamicType.Builder.FieldDefinition.Optional.Valuable.AbstractBase.Adapter<U>
/*      */         {
/*      */           private final LatentMatcher<? super FieldDescription> matcher;
/*      */           
/*      */           protected FieldMatchAdapter(LatentMatcher<? super FieldDescription> param4LatentMatcher) {
/* 5069 */             this((FieldAttributeAppender.Factory)FieldAttributeAppender.NoOp.INSTANCE, 
/* 5070 */                 Transformer.NoOp.make(), FieldDescription.NO_DEFAULT_VALUE, param4LatentMatcher);
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
/*      */ 
/*      */           
/*      */           protected FieldMatchAdapter(FieldAttributeAppender.Factory param4Factory, @MaybeNull Transformer<FieldDescription> param4Transformer, Object param4Object, LatentMatcher<? super FieldDescription> param4LatentMatcher) {
/* 5087 */             super(param4Factory, param4Transformer, param4Object);
/* 5088 */             this.matcher = param4LatentMatcher;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.FieldDefinition.Optional<U> annotateField(Collection<? extends AnnotationDescription> param4Collection) {
/* 5095 */             return attribute((FieldAttributeAppender.Factory)new FieldAttributeAppender.Explicit(new ArrayList<AnnotationDescription>(param4Collection)));
/*      */           }
/*      */ 
/*      */           
/*      */           protected DynamicType.Builder<U> materialize() {
/* 5100 */             return this.a.materialize(this.a.instrumentedType, this.a.fieldRegistry
/* 5101 */                 .prepend(this.matcher, this.fieldAttributeAppenderFactory, this.defaultValue, this.transformer), this.a.methodRegistry, this.a.recordComponentRegistry, this.a.typeAttributeAppender, this.a.asmVisitorWrapper, this.a.classFileVersion, this.a.auxiliaryTypeNamingStrategy, this.a.annotationValueFilterFactory, this.a.annotationRetention, this.a.implementationContextFactory, this.a.methodGraphCompiler, this.a.typeValidation, this.a.visibilityBridgeStrategy, this.a.classWriterStrategy, this.a.ignoredMethods, this.a.auxiliaryTypes);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected DynamicType.Builder.FieldDefinition.Optional<U> materialize(FieldAttributeAppender.Factory param4Factory, Transformer<FieldDescription> param4Transformer, @MaybeNull Object param4Object) {
/* 5123 */             return new FieldMatchAdapter(param4Factory, param4Transformer, param4Object, this.matcher);
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.matcher.equals(((FieldMatchAdapter)param4Object).matcher) ? false : (!!this.a.equals(((FieldMatchAdapter)param4Object).a))))));
/*      */           }
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return (super.hashCode() * 31 + this.matcher.hashCode()) * 31 + this.a.hashCode();
/*      */           }
/*      */         }
/*      */         
/*      */         @Enhance(includeSyntheticFields = true)
/*      */         protected class MethodDefinitionAdapter
/*      */           extends DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial.AbstractBase<U>
/*      */         {
/*      */           private final MethodDescription.Token token;
/*      */           
/*      */           protected MethodDefinitionAdapter(DynamicType.Builder.AbstractBase.Adapter this$0, MethodDescription.Token param4Token) {
/* 5144 */             this.token = param4Token;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable<U> withParameter(TypeDefinition param4TypeDefinition, String param4String, int param4Int) {
/* 5151 */             return new ParameterAnnotationAdapter(this, new ParameterDescription.Token(param4TypeDefinition.asGenericType(), param4String, Integer.valueOf(param4Int)));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable<U> withParameter(TypeDefinition param4TypeDefinition) {
/* 5158 */             return new SimpleParameterAnnotationAdapter(this, new ParameterDescription.Token(param4TypeDefinition.asGenericType()));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.MethodDefinition.ExceptionDefinition<U> throwing(Collection<? extends TypeDefinition> param4Collection) {
/* 5165 */             return new MethodDefinitionAdapter(this.a, new MethodDescription.Token(this.token.getName(), this.token
/* 5166 */                   .getModifiers(), (List)this.token
/* 5167 */                   .getTypeVariableTokens(), this.token
/* 5168 */                   .getReturnType(), (List)this.token
/* 5169 */                   .getParameterTokens(), 
/* 5170 */                   CompoundList.of((List)this.token.getExceptionTypes(), (List)new TypeList.Generic.Explicit(new ArrayList<TypeDefinition>(param4Collection))), (List)this.token
/* 5171 */                   .getAnnotations(), this.token
/* 5172 */                   .getDefaultValue(), this.token
/* 5173 */                   .getReceiverType()));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.MethodDefinition.TypeVariableDefinition.Annotatable<U> typeVariable(String param4String, Collection<? extends TypeDefinition> param4Collection) {
/* 5180 */             return new TypeVariableAnnotationAdapter(this, new TypeVariableToken(param4String, (List)new TypeList.Generic.Explicit(new ArrayList<TypeDefinition>(param4Collection))));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<U> intercept(Implementation param4Implementation) {
/* 5187 */             return materialize((MethodRegistry.Handler)new MethodRegistry.Handler.ForImplementation(param4Implementation));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<U> withoutCode() {
/* 5194 */             return (new MethodDefinitionAdapter(this.a, new MethodDescription.Token(this.token.getName(), 
/* 5195 */                   ((this.token.getModifiers() & 0x100) == 0) ? 
/* 5196 */                   ModifierContributor.Resolver.of(new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)MethodManifestation.ABSTRACT }, ).resolve(this.token.getModifiers()) : this.token
/* 5197 */                   .getModifiers(), (List)this.token
/* 5198 */                   .getTypeVariableTokens(), this.token
/* 5199 */                   .getReturnType(), (List)this.token
/* 5200 */                   .getParameterTokens(), (List)this.token
/* 5201 */                   .getExceptionTypes(), (List)this.token
/* 5202 */                   .getAnnotations(), this.token
/* 5203 */                   .getDefaultValue(), this.token
/* 5204 */                   .getReceiverType()))).materialize((MethodRegistry.Handler)MethodRegistry.Handler.ForAbstractMethod.INSTANCE);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<U> defaultValue(AnnotationValue<?, ?> param4AnnotationValue) {
/* 5211 */             return (new MethodDefinitionAdapter(this.a, new MethodDescription.Token(this.token.getName(), 
/* 5212 */                   ModifierContributor.Resolver.of(new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)MethodManifestation.ABSTRACT }, ).resolve(this.token.getModifiers()), (List)this.token
/* 5213 */                   .getTypeVariableTokens(), this.token
/* 5214 */                   .getReturnType(), (List)this.token
/* 5215 */                   .getParameterTokens(), (List)this.token
/* 5216 */                   .getExceptionTypes(), (List)this.token
/* 5217 */                   .getAnnotations(), param4AnnotationValue, this.token
/*      */                   
/* 5219 */                   .getReceiverType()))).materialize((MethodRegistry.Handler)new MethodRegistry.Handler.ForAnnotationValue(param4AnnotationValue));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<U> materialize(MethodRegistry.Handler param4Handler) {
/* 5229 */             return new AnnotationAdapter(param4Handler);
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.token.equals(((MethodDefinitionAdapter)param4Object).token) ? false : (!!this.a.equals(((MethodDefinitionAdapter)param4Object).a)))));
/*      */           }
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return (getClass().hashCode() * 31 + this.token.hashCode()) * 31 + this.a.hashCode();
/*      */           }
/*      */           
/*      */           @Enhance(includeSyntheticFields = true)
/*      */           protected class TypeVariableAnnotationAdapter
/*      */             extends DynamicType.Builder.MethodDefinition.TypeVariableDefinition.Annotatable.AbstractBase.Adapter<U>
/*      */           {
/*      */             private final TypeVariableToken token;
/*      */             
/*      */             protected TypeVariableAnnotationAdapter(DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter this$0, TypeVariableToken param5TypeVariableToken) {
/* 5249 */               this.token = param5TypeVariableToken;
/*      */             }
/*      */ 
/*      */             
/*      */             protected DynamicType.Builder.MethodDefinition.ParameterDefinition<U> materialize() {
/* 5254 */               return new DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter(this.a.a, new MethodDescription.Token(DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getName(), 
/* 5255 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getModifiers(), 
/* 5256 */                     CompoundList.of((List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getTypeVariableTokens(), this.token), 
/* 5257 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getReturnType(), 
/* 5258 */                     (List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getParameterTokens(), 
/* 5259 */                     (List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getExceptionTypes(), 
/* 5260 */                     (List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getAnnotations(), 
/* 5261 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getDefaultValue(), 
/* 5262 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getReceiverType()));
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public DynamicType.Builder.MethodDefinition.TypeVariableDefinition.Annotatable<U> annotateTypeVariable(Collection<? extends AnnotationDescription> param5Collection) {
/* 5269 */               return new TypeVariableAnnotationAdapter(this.a, new TypeVariableToken(this.token.getSymbol(), (List)this.token
/* 5270 */                     .getBounds(), 
/* 5271 */                     CompoundList.of((List)this.token.getAnnotations(), new ArrayList<AnnotationDescription>(param5Collection))));
/*      */             }
/*      */ 
/*      */             
/*      */             public boolean equals(@MaybeNull Object param5Object) {
/*      */               return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!this.token.equals(((TypeVariableAnnotationAdapter)param5Object).token) ? false : (!!this.a.equals(((TypeVariableAnnotationAdapter)param5Object).a)))));
/*      */             }
/*      */ 
/*      */             
/*      */             public int hashCode() {
/*      */               return (getClass().hashCode() * 31 + this.token.hashCode()) * 31 + this.a.hashCode();
/*      */             }
/*      */           }
/*      */           
/*      */           @Enhance(includeSyntheticFields = true)
/*      */           protected class ParameterAnnotationAdapter
/*      */             extends DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable.AbstractBase.Adapter<U>
/*      */           {
/*      */             private final ParameterDescription.Token token;
/*      */             
/*      */             protected ParameterAnnotationAdapter(DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter this$0, ParameterDescription.Token param5Token) {
/* 5292 */               this.token = param5Token;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable<U> annotateParameter(Collection<? extends AnnotationDescription> param5Collection) {
/* 5299 */               return new ParameterAnnotationAdapter(this.a, new ParameterDescription.Token(this.token.getType(), 
/* 5300 */                     CompoundList.of((List)this.token.getAnnotations(), new ArrayList<AnnotationDescription>(param5Collection)), this.token
/* 5301 */                     .getName(), this.token
/* 5302 */                     .getModifiers()));
/*      */             }
/*      */ 
/*      */             
/*      */             protected DynamicType.Builder.MethodDefinition.ParameterDefinition<U> materialize() {
/* 5307 */               return new DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter(this.a.a, new MethodDescription.Token(DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getName(), 
/* 5308 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getModifiers(), 
/* 5309 */                     (List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getTypeVariableTokens(), 
/* 5310 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getReturnType(), 
/* 5311 */                     CompoundList.of((List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getParameterTokens(), this.token), 
/* 5312 */                     (List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getExceptionTypes(), 
/* 5313 */                     (List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getAnnotations(), 
/* 5314 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getDefaultValue(), 
/* 5315 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getReceiverType()));
/*      */             }
/*      */ 
/*      */             
/*      */             public boolean equals(@MaybeNull Object param5Object) {
/*      */               return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!this.token.equals(((ParameterAnnotationAdapter)param5Object).token) ? false : (!!this.a.equals(((ParameterAnnotationAdapter)param5Object).a)))));
/*      */             }
/*      */ 
/*      */             
/*      */             public int hashCode() {
/*      */               return (getClass().hashCode() * 31 + this.token.hashCode()) * 31 + this.a.hashCode();
/*      */             }
/*      */           }
/*      */           
/*      */           @Enhance(includeSyntheticFields = true)
/*      */           protected class SimpleParameterAnnotationAdapter
/*      */             extends DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable.AbstractBase.Adapter<U>
/*      */           {
/*      */             private final ParameterDescription.Token token;
/*      */             
/*      */             protected SimpleParameterAnnotationAdapter(DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter this$0, ParameterDescription.Token param5Token) {
/* 5336 */               this.token = param5Token;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable<U> annotateParameter(Collection<? extends AnnotationDescription> param5Collection) {
/* 5343 */               return new SimpleParameterAnnotationAdapter(this.a, new ParameterDescription.Token(this.token.getType(), 
/* 5344 */                     CompoundList.of((List)this.token.getAnnotations(), new ArrayList<AnnotationDescription>(param5Collection)), this.token
/* 5345 */                     .getName(), this.token
/* 5346 */                     .getModifiers()));
/*      */             }
/*      */ 
/*      */             
/*      */             protected DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple<U> materialize() {
/* 5351 */               return new DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter(this.a.a, new MethodDescription.Token(DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getName(), 
/* 5352 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getModifiers(), 
/* 5353 */                     (List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getTypeVariableTokens(), 
/* 5354 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getReturnType(), 
/* 5355 */                     CompoundList.of((List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getParameterTokens(), this.token), 
/* 5356 */                     (List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getExceptionTypes(), 
/* 5357 */                     (List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getAnnotations(), 
/* 5358 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getDefaultValue(), 
/* 5359 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getReceiverType()));
/*      */             }
/*      */             
/*      */             public boolean equals(@MaybeNull Object param5Object) {
/*      */               return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!this.token.equals(((SimpleParameterAnnotationAdapter)param5Object).token) ? false : (!!this.a.equals(((SimpleParameterAnnotationAdapter)param5Object).a)))));
/*      */             }
/*      */             
/*      */             public int hashCode() {
/*      */               return (getClass().hashCode() * 31 + this.token.hashCode()) * 31 + this.a.hashCode();
/*      */             }
/*      */           }
/*      */           
/*      */           @Enhance(includeSyntheticFields = true)
/*      */           protected class AnnotationAdapter
/*      */             extends DynamicType.Builder.MethodDefinition.AbstractBase.Adapter<U> {
/*      */             protected AnnotationAdapter(MethodRegistry.Handler param5Handler) {
/* 5375 */               this(param5Handler, (MethodAttributeAppender.Factory)MethodAttributeAppender.ForInstrumentedMethod.INCLUDING_RECEIVER, 
/*      */                   
/* 5377 */                   Transformer.NoOp.make());
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
/*      */             protected AnnotationAdapter(MethodRegistry.Handler param5Handler, MethodAttributeAppender.Factory param5Factory, Transformer<MethodDescription> param5Transformer) {
/* 5390 */               super(param5Handler, param5Factory, param5Transformer);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public DynamicType.Builder.MethodDefinition<U> receiverType(TypeDescription.Generic param5Generic) {
/* 5397 */               (new DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter(this.a.a, new MethodDescription.Token(DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getName(), 
/* 5398 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getModifiers(), 
/* 5399 */                     (List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getTypeVariableTokens(), 
/* 5400 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getReturnType(), 
/* 5401 */                     (List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getParameterTokens(), 
/* 5402 */                     (List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getExceptionTypes(), 
/* 5403 */                     (List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getAnnotations(), 
/* 5404 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getDefaultValue(), param5Generic))).getClass(); return new AnnotationAdapter(this.handler, this.methodAttributeAppenderFactory, this.transformer);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public DynamicType.Builder.MethodDefinition<U> annotateMethod(Collection<? extends AnnotationDescription> param5Collection) {
/* 5412 */               (new DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter(this.a.a, new MethodDescription.Token(DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getName(), 
/* 5413 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getModifiers(), 
/* 5414 */                     (List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getTypeVariableTokens(), 
/* 5415 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getReturnType(), 
/* 5416 */                     (List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getParameterTokens(), 
/* 5417 */                     (List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getExceptionTypes(), 
/* 5418 */                     CompoundList.of((List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getAnnotations(), new ArrayList<AnnotationDescription>(param5Collection)), 
/* 5419 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getDefaultValue(), 
/* 5420 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getReceiverType()))).getClass(); return new AnnotationAdapter(this.handler, this.methodAttributeAppenderFactory, this.transformer);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public DynamicType.Builder.MethodDefinition<U> annotateParameter(int param5Int, Collection<? extends AnnotationDescription> param5Collection) {
/*      */               ArrayList<ParameterDescription.Token> arrayList;
/* 5428 */               (arrayList = new ArrayList<ParameterDescription.Token>((Collection<?>)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getParameterTokens())).set(param5Int, new ParameterDescription.Token(((ParameterDescription.Token)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getParameterTokens().get(param5Int)).getType(), 
/* 5429 */                     CompoundList.of((List)((ParameterDescription.Token)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getParameterTokens().get(param5Int)).getAnnotations(), new ArrayList<AnnotationDescription>(param5Collection)), (
/* 5430 */                     (ParameterDescription.Token)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getParameterTokens().get(param5Int)).getName(), (
/* 5431 */                     (ParameterDescription.Token)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getParameterTokens().get(param5Int)).getModifiers()));
/* 5432 */               (new DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter(this.a.a, new MethodDescription.Token(DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getName(), 
/* 5433 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getModifiers(), 
/* 5434 */                     (List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getTypeVariableTokens(), 
/* 5435 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getReturnType(), arrayList, 
/*      */                     
/* 5437 */                     (List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getExceptionTypes(), 
/* 5438 */                     (List)DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getAnnotations(), 
/* 5439 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getDefaultValue(), 
/* 5440 */                     DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a).getReceiverType()))).getClass(); return new AnnotationAdapter(this.handler, this.methodAttributeAppenderFactory, this.transformer);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected DynamicType.Builder.MethodDefinition<U> materialize(MethodRegistry.Handler param5Handler, MethodAttributeAppender.Factory param5Factory, Transformer<MethodDescription> param5Transformer) {
/* 5447 */               return new AnnotationAdapter(param5Handler, param5Factory, param5Transformer);
/*      */             }
/*      */ 
/*      */             
/*      */             protected DynamicType.Builder<U> materialize() {
/* 5452 */               return this.a.a.materialize(this.a.a.instrumentedType.withMethod(DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a)), this.a.a.fieldRegistry, this.a.a.methodRegistry
/*      */                   
/* 5454 */                   .prepend((LatentMatcher)new LatentMatcher.ForMethodToken(DynamicType.Builder.AbstractBase.Adapter.MethodDefinitionAdapter.a(this.a)), this.handler, this.methodAttributeAppenderFactory, this.transformer), this.a.a.recordComponentRegistry, this.a.a.typeAttributeAppender, this.a.a.asmVisitorWrapper, this.a.a.classFileVersion, this.a.a.auxiliaryTypeNamingStrategy, this.a.a.annotationValueFilterFactory, this.a.a.annotationRetention, this.a.a.implementationContextFactory, this.a.a.methodGraphCompiler, this.a.a.typeValidation, this.a.a.visibilityBridgeStrategy, this.a.a.classWriterStrategy, this.a.a.ignoredMethods, this.a.a.auxiliaryTypes);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean equals(@MaybeNull Object param5Object) {
/*      */               return !super.equals(param5Object) ? false : ((this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.a.equals(((AnnotationAdapter)param5Object).a)))));
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public int hashCode() {
/*      */               return super.hashCode() * 31 + this.a.hashCode();
/*      */             }
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance(includeSyntheticFields = true)
/*      */         protected class MethodMatchAdapter
/*      */           extends DynamicType.Builder.MethodDefinition.ImplementationDefinition.AbstractBase<U>
/*      */         {
/*      */           private final LatentMatcher<? super MethodDescription> matcher;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected MethodMatchAdapter(DynamicType.Builder.AbstractBase.Adapter this$0, LatentMatcher<? super MethodDescription> param4LatentMatcher) {
/* 5493 */             this.matcher = param4LatentMatcher;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<U> intercept(Implementation param4Implementation) {
/* 5500 */             return materialize((MethodRegistry.Handler)new MethodRegistry.Handler.ForImplementation(param4Implementation));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<U> withoutCode() {
/* 5507 */             return materialize((MethodRegistry.Handler)MethodRegistry.Handler.ForAbstractMethod.INSTANCE);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<U> defaultValue(AnnotationValue<?, ?> param4AnnotationValue) {
/* 5514 */             return materialize((MethodRegistry.Handler)new MethodRegistry.Handler.ForAnnotationValue(param4AnnotationValue));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<U> materialize(MethodRegistry.Handler param4Handler) {
/* 5524 */             return new AnnotationAdapter(param4Handler);
/*      */           }
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.matcher.equals(((MethodMatchAdapter)param4Object).matcher) ? false : (!!this.a.equals(((MethodMatchAdapter)param4Object).a)))));
/*      */           }
/*      */           
/*      */           public int hashCode() {
/*      */             return (getClass().hashCode() * 31 + this.matcher.hashCode()) * 31 + this.a.hashCode();
/*      */           }
/*      */           
/*      */           @Enhance(includeSyntheticFields = true)
/*      */           protected class AnnotationAdapter
/*      */             extends DynamicType.Builder.MethodDefinition.AbstractBase.Adapter<U> {
/*      */             protected AnnotationAdapter(MethodRegistry.Handler param5Handler) {
/* 5539 */               this(param5Handler, (MethodAttributeAppender.Factory)MethodAttributeAppender.NoOp.INSTANCE, Transformer.NoOp.make());
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
/*      */             protected AnnotationAdapter(MethodRegistry.Handler param5Handler, MethodAttributeAppender.Factory param5Factory, Transformer<MethodDescription> param5Transformer) {
/* 5552 */               super(param5Handler, param5Factory, param5Transformer);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public DynamicType.Builder.MethodDefinition<U> receiverType(TypeDescription.Generic param5Generic) {
/* 5559 */               return new AnnotationAdapter(this.handler, (MethodAttributeAppender.Factory)new MethodAttributeAppender.Factory.Compound(new MethodAttributeAppender.Factory[] { this.methodAttributeAppenderFactory, (MethodAttributeAppender.Factory)new MethodAttributeAppender.ForReceiverType(param5Generic) }, ), this.transformer);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public DynamicType.Builder.MethodDefinition<U> annotateMethod(Collection<? extends AnnotationDescription> param5Collection) {
/* 5568 */               return new AnnotationAdapter(this.handler, (MethodAttributeAppender.Factory)new MethodAttributeAppender.Factory.Compound(new MethodAttributeAppender.Factory[] { this.methodAttributeAppenderFactory, (MethodAttributeAppender.Factory)new MethodAttributeAppender.Explicit(new ArrayList<AnnotationDescription>(param5Collection)) }, ), this.transformer);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public DynamicType.Builder.MethodDefinition<U> annotateParameter(int param5Int, Collection<? extends AnnotationDescription> param5Collection) {
/* 5577 */               return new AnnotationAdapter(this.handler, (MethodAttributeAppender.Factory)new MethodAttributeAppender.Factory.Compound(new MethodAttributeAppender.Factory[] { this.methodAttributeAppenderFactory, (MethodAttributeAppender.Factory)new MethodAttributeAppender.Explicit(param5Int, new ArrayList<AnnotationDescription>(param5Collection)) }), this.transformer);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             protected DynamicType.Builder.MethodDefinition<U> materialize(MethodRegistry.Handler param5Handler, MethodAttributeAppender.Factory param5Factory, Transformer<MethodDescription> param5Transformer) {
/* 5586 */               return new AnnotationAdapter(param5Handler, param5Factory, param5Transformer);
/*      */             }
/*      */ 
/*      */             
/*      */             protected DynamicType.Builder<U> materialize() {
/* 5591 */               return this.a.a.materialize(this.a.a.instrumentedType, this.a.a.fieldRegistry, this.a.a.methodRegistry
/*      */                   
/* 5593 */                   .prepend(DynamicType.Builder.AbstractBase.Adapter.MethodMatchAdapter.a(this.a), this.handler, this.methodAttributeAppenderFactory, this.transformer), this.a.a.recordComponentRegistry, this.a.a.typeAttributeAppender, this.a.a.asmVisitorWrapper, this.a.a.classFileVersion, this.a.a.auxiliaryTypeNamingStrategy, this.a.a.annotationValueFilterFactory, this.a.a.annotationRetention, this.a.a.implementationContextFactory, this.a.a.methodGraphCompiler, this.a.a.typeValidation, this.a.a.visibilityBridgeStrategy, this.a.a.classWriterStrategy, this.a.a.ignoredMethods, this.a.a.auxiliaryTypes);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean equals(@MaybeNull Object param5Object) {
/*      */               return !super.equals(param5Object) ? false : ((this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.a.equals(((AnnotationAdapter)param5Object).a)))));
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public int hashCode() {
/*      */               return super.hashCode() * 31 + this.a.hashCode();
/*      */             }
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance(includeSyntheticFields = true)
/*      */         protected class OptionalMethodMatchAdapter
/*      */           extends DynamicType.Builder.AbstractBase.Delegator<U>
/*      */           implements DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional<U>
/*      */         {
/*      */           private final TypeList.Generic interfaces;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected OptionalMethodMatchAdapter(DynamicType.Builder.AbstractBase.Adapter this$0, TypeList.Generic param4Generic) {
/* 5629 */             this.interfaces = param4Generic;
/*      */           }
/*      */ 
/*      */           
/*      */           protected DynamicType.Builder<U> materialize() {
/* 5634 */             return this.a.materialize(this.a.instrumentedType.withInterfaces(this.interfaces), this.a.fieldRegistry, this.a.methodRegistry, this.a.recordComponentRegistry, this.a.typeAttributeAppender, this.a.asmVisitorWrapper, this.a.classFileVersion, this.a.auxiliaryTypeNamingStrategy, this.a.annotationValueFilterFactory, this.a.annotationRetention, this.a.implementationContextFactory, this.a.methodGraphCompiler, this.a.typeValidation, this.a.visibilityBridgeStrategy, this.a.classWriterStrategy, this.a.ignoredMethods, this.a.auxiliaryTypes);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<U> intercept(Implementation param4Implementation) {
/* 5657 */             return interfaceType().intercept(param4Implementation);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<U> withoutCode() {
/* 5664 */             return interfaceType().withoutCode();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<U> defaultValue(AnnotationValue<?, ?> param4AnnotationValue) {
/* 5671 */             return interfaceType().defaultValue(param4AnnotationValue);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public <V> DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<U> defaultValue(V param4V, Class<? extends V> param4Class) {
/* 5678 */             return interfaceType().defaultValue(param4V, param4Class);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private DynamicType.Builder.MethodDefinition.ImplementationDefinition<U> interfaceType() {
/* 5687 */             ElementMatcher.Junction junction = ElementMatchers.none();
/* 5688 */             for (TypeDescription typeDescription : this.interfaces.asErasures()) {
/* 5689 */               junction = junction.or((ElementMatcher)ElementMatchers.isSuperTypeOf(typeDescription));
/*      */             }
/* 5691 */             return materialize().invokable((ElementMatcher<? super MethodDescription>)ElementMatchers.isDeclaredBy((ElementMatcher)ElementMatchers.isInterface().and((ElementMatcher)junction)));
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.interfaces.equals(((OptionalMethodMatchAdapter)param4Object).interfaces) ? false : (!!this.a.equals(((OptionalMethodMatchAdapter)param4Object).a)))));
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return (getClass().hashCode() * 31 + this.interfaces.hashCode()) * 31 + this.a.hashCode();
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance(includeSyntheticFields = true)
/*      */         protected class RecordComponentDefinitionAdapter
/*      */           extends DynamicType.Builder.RecordComponentDefinition.Optional.AbstractBase<U>
/*      */         {
/*      */           private final RecordComponentAttributeAppender.Factory recordComponentAttributeAppenderFactory;
/*      */ 
/*      */           
/*      */           private final RecordComponentDescription.Token token;
/*      */           
/*      */           private final Transformer<RecordComponentDescription> transformer;
/*      */ 
/*      */           
/*      */           protected RecordComponentDefinitionAdapter(RecordComponentDescription.Token param4Token) {
/* 5722 */             this((RecordComponentAttributeAppender.Factory)RecordComponentAttributeAppender.ForInstrumentedRecordComponent.INSTANCE, 
/* 5723 */                 Transformer.NoOp.make(), param4Token);
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
/*      */           protected RecordComponentDefinitionAdapter(RecordComponentAttributeAppender.Factory param4Factory, Transformer<RecordComponentDescription> param4Transformer, RecordComponentDescription.Token param4Token) {
/* 5737 */             this.recordComponentAttributeAppenderFactory = param4Factory;
/* 5738 */             this.transformer = param4Transformer;
/* 5739 */             this.token = param4Token;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.RecordComponentDefinition.Optional<U> annotateRecordComponent(Collection<? extends AnnotationDescription> param4Collection) {
/* 5746 */             return new RecordComponentDefinitionAdapter(this.recordComponentAttributeAppenderFactory, this.transformer, new RecordComponentDescription.Token(this.token.getName(), this.token
/* 5747 */                   .getType(), 
/* 5748 */                   CompoundList.of((List)this.token.getAnnotations(), new ArrayList<AnnotationDescription>(param4Collection))));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.RecordComponentDefinition.Optional<U> attribute(RecordComponentAttributeAppender.Factory param4Factory) {
/* 5755 */             return new RecordComponentDefinitionAdapter((RecordComponentAttributeAppender.Factory)new RecordComponentAttributeAppender.Factory.Compound(new RecordComponentAttributeAppender.Factory[] { this.recordComponentAttributeAppenderFactory, param4Factory }, ), this.transformer, this.token);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.RecordComponentDefinition.Optional<U> transform(Transformer<RecordComponentDescription> param4Transformer) {
/* 5764 */             return new RecordComponentDefinitionAdapter(this.recordComponentAttributeAppenderFactory, new Transformer.Compound<RecordComponentDescription>((Transformer<RecordComponentDescription>[])new Transformer[] { this.transformer, param4Transformer }, ), this.token);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected DynamicType.Builder<U> materialize() {
/* 5771 */             return this.a.materialize(this.a.instrumentedType.withRecordComponent(this.token), this.a.fieldRegistry, this.a.methodRegistry, this.a.recordComponentRegistry
/*      */ 
/*      */                 
/* 5774 */                 .prepend((LatentMatcher)new LatentMatcher.ForRecordComponentToken(this.token), this.recordComponentAttributeAppenderFactory, this.transformer), this.a.typeAttributeAppender, this.a.asmVisitorWrapper, this.a.classFileVersion, this.a.auxiliaryTypeNamingStrategy, this.a.annotationValueFilterFactory, this.a.annotationRetention, this.a.implementationContextFactory, this.a.methodGraphCompiler, this.a.typeValidation, this.a.visibilityBridgeStrategy, this.a.classWriterStrategy, this.a.ignoredMethods, this.a.auxiliaryTypes);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!this.recordComponentAttributeAppenderFactory.equals(((RecordComponentDefinitionAdapter)param4Object).recordComponentAttributeAppenderFactory) ? false : (!this.token.equals(((RecordComponentDefinitionAdapter)param4Object).token) ? false : (!this.transformer.equals(((RecordComponentDefinitionAdapter)param4Object).transformer) ? false : (!!this.a.equals(((RecordComponentDefinitionAdapter)param4Object).a)))))));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return (((getClass().hashCode() * 31 + this.recordComponentAttributeAppenderFactory.hashCode()) * 31 + this.token.hashCode()) * 31 + this.transformer.hashCode()) * 31 + this.a.hashCode();
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected class RecordComponentMatchAdapter
/*      */           extends DynamicType.Builder.RecordComponentDefinition.Optional.AbstractBase<U>
/*      */         {
/*      */           private final LatentMatcher<? super RecordComponentDescription> matcher;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final RecordComponentAttributeAppender.Factory recordComponentAttributeAppenderFactory;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private final Transformer<RecordComponentDescription> transformer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected RecordComponentMatchAdapter(LatentMatcher<? super RecordComponentDescription> param4LatentMatcher) {
/* 5819 */             this(param4LatentMatcher, (RecordComponentAttributeAppender.Factory)RecordComponentAttributeAppender.NoOp.INSTANCE, Transformer.NoOp.make());
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
/*      */           protected RecordComponentMatchAdapter(LatentMatcher<? super RecordComponentDescription> param4LatentMatcher, RecordComponentAttributeAppender.Factory param4Factory, Transformer<RecordComponentDescription> param4Transformer) {
/* 5832 */             this.matcher = param4LatentMatcher;
/* 5833 */             this.recordComponentAttributeAppenderFactory = param4Factory;
/* 5834 */             this.transformer = param4Transformer;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.RecordComponentDefinition.Optional<U> annotateRecordComponent(Collection<? extends AnnotationDescription> param4Collection) {
/* 5841 */             return attribute((RecordComponentAttributeAppender.Factory)new RecordComponentAttributeAppender.Explicit(new ArrayList<AnnotationDescription>(param4Collection)));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.RecordComponentDefinition.Optional<U> attribute(RecordComponentAttributeAppender.Factory param4Factory) {
/* 5848 */             return new RecordComponentMatchAdapter(this.matcher, (RecordComponentAttributeAppender.Factory)new RecordComponentAttributeAppender.Factory.Compound(new RecordComponentAttributeAppender.Factory[] { this.recordComponentAttributeAppenderFactory, param4Factory }, ), this.transformer);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public DynamicType.Builder.RecordComponentDefinition.Optional<U> transform(Transformer<RecordComponentDescription> param4Transformer) {
/* 5857 */             return new RecordComponentMatchAdapter(this.matcher, this.recordComponentAttributeAppenderFactory, new Transformer.Compound<RecordComponentDescription>((Transformer<RecordComponentDescription>[])new Transformer[] { this.transformer, param4Transformer }));
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected DynamicType.Builder<U> materialize() {
/* 5864 */             return this.a.materialize(this.a.instrumentedType, this.a.fieldRegistry, this.a.methodRegistry, this.a.recordComponentRegistry
/*      */ 
/*      */                 
/* 5867 */                 .prepend(this.matcher, this.recordComponentAttributeAppenderFactory, this.transformer), this.a.typeAttributeAppender, this.a.asmVisitorWrapper, this.a.classFileVersion, this.a.auxiliaryTypeNamingStrategy, this.a.annotationValueFilterFactory, this.a.annotationRetention, this.a.implementationContextFactory, this.a.methodGraphCompiler, this.a.typeValidation, this.a.visibilityBridgeStrategy, this.a.classWriterStrategy, this.a.ignoredMethods, this.a.auxiliaryTypes);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static interface InnerTypeDefinition<S>
/*      */       extends Builder<S>
/*      */     {
/*      */       DynamicType.Builder<S> asAnonymousType();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static interface ForType<U>
/*      */         extends InnerTypeDefinition<U>
/*      */       {
/*      */         DynamicType.Builder<U> asMemberType();
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static interface ForType<U>
/*      */       extends InnerTypeDefinition<U>
/*      */     {
/*      */       DynamicType.Builder<U> asMemberType();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static interface Optional<V>
/*      */       extends Builder<V>, MethodDefinition.ImplementationDefinition<V> {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static interface Valuable<U>
/*      */       extends FieldDefinition<U>
/*      */     {
/*      */       DynamicType.Builder.FieldDefinition.Optional<U> value(boolean param2Boolean);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       DynamicType.Builder.FieldDefinition.Optional<U> value(int param2Int);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       DynamicType.Builder.FieldDefinition.Optional<U> value(long param2Long);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       DynamicType.Builder.FieldDefinition.Optional<U> value(float param2Float);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       DynamicType.Builder.FieldDefinition.Optional<U> value(double param2Double);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       DynamicType.Builder.FieldDefinition.Optional<U> value(String param2String);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface Unloaded<T>
/*      */     extends DynamicType
/*      */   {
/*      */     DynamicType.Loaded<T> load(@MaybeNull ClassLoader param1ClassLoader);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     <S extends ClassLoader> DynamicType.Loaded<T> load(@MaybeNull S param1S, ClassLoadingStrategy<? super S> param1ClassLoadingStrategy);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Unloaded<T> include(DynamicType... param1VarArgs);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Unloaded<T> include(List<? extends DynamicType> param1List);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface Loaded<T>
/*      */     extends DynamicType
/*      */   {
/*      */     Class<? extends T> getLoaded();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Map<TypeDescription, Class<?>> getLoadedAuxiliaryTypes();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Map<TypeDescription, Class<?>> getAllLoaded();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class Default
/*      */     implements DynamicType
/*      */   {
/*      */     private static final String CLASS_FILE_EXTENSION = ".class";
/*      */ 
/*      */ 
/*      */     
/*      */     private static final String MANIFEST_VERSION = "1.0";
/*      */ 
/*      */ 
/*      */     
/*      */     private static final int BUFFER_SIZE = 1024;
/*      */ 
/*      */ 
/*      */     
/*      */     private static final int FROM_BEGINNING = 0;
/*      */ 
/*      */ 
/*      */     
/*      */     private static final int END_OF_FILE = -1;
/*      */ 
/*      */ 
/*      */     
/*      */     private static final String TEMP_SUFFIX = "tmp";
/*      */ 
/*      */ 
/*      */     
/*      */     protected final TypeDescription typeDescription;
/*      */ 
/*      */ 
/*      */     
/*      */     protected final byte[] binaryRepresentation;
/*      */ 
/*      */ 
/*      */     
/*      */     protected final LoadedTypeInitializer loadedTypeInitializer;
/*      */ 
/*      */ 
/*      */     
/*      */     protected final List<? extends DynamicType> auxiliaryTypes;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @SuppressFBWarnings(value = {"EI_EXPOSE_REP2"}, justification = "The array is not modified by class contract.")
/*      */     public Default(TypeDescription param1TypeDescription, byte[] param1ArrayOfbyte, LoadedTypeInitializer param1LoadedTypeInitializer, List<? extends DynamicType> param1List) {
/* 6050 */       this.typeDescription = param1TypeDescription;
/* 6051 */       this.binaryRepresentation = param1ArrayOfbyte;
/* 6052 */       this.loadedTypeInitializer = param1LoadedTypeInitializer;
/* 6053 */       this.auxiliaryTypes = param1List;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ClassFileLocator.Resolution locate(String param1String) {
/* 6060 */       if (this.typeDescription.getName().equals(param1String)) {
/* 6061 */         return new ClassFileLocator.Resolution.Explicit(this.binaryRepresentation);
/*      */       }
/* 6063 */       for (Iterator<? extends DynamicType> iterator = this.auxiliaryTypes.iterator(); iterator.hasNext();) {
/*      */         
/* 6065 */         if ((resolution = (dynamicType = iterator.next()).locate(param1String)).isResolved()) {
/* 6066 */           return resolution;
/*      */         }
/*      */       } 
/* 6069 */       return new ClassFileLocator.Resolution.Illegal(param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {}
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription getTypeDescription() {
/* 6080 */       return this.typeDescription;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Map<TypeDescription, byte[]> getAllTypes() {
/*      */       LinkedHashMap<Object, Object> linkedHashMap;
/* 6088 */       (linkedHashMap = new LinkedHashMap<Object, Object>()).put(this.typeDescription, this.binaryRepresentation);
/* 6089 */       for (DynamicType dynamicType : this.auxiliaryTypes) {
/* 6090 */         linkedHashMap.putAll(dynamicType.getAllTypes());
/*      */       }
/* 6092 */       return (Map)linkedHashMap;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Map<TypeDescription, LoadedTypeInitializer> getLoadedTypeInitializers() {
/* 6099 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 6100 */       for (DynamicType dynamicType : this.auxiliaryTypes) {
/* 6101 */         hashMap.putAll(dynamicType.getLoadedTypeInitializers());
/*      */       }
/* 6103 */       hashMap.put(this.typeDescription, this.loadedTypeInitializer);
/* 6104 */       return (Map)hashMap;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasAliveLoadedTypeInitializers() {
/* 6111 */       for (Iterator<LoadedTypeInitializer> iterator = getLoadedTypeInitializers().values().iterator(); iterator.hasNext();) {
/* 6112 */         if ((loadedTypeInitializer = iterator.next()).isAlive()) {
/* 6113 */           return true;
/*      */         }
/*      */       } 
/* 6116 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @SuppressFBWarnings(value = {"EI_EXPOSE_REP"}, justification = "The array is not modified by class contract.")
/*      */     public byte[] getBytes() {
/* 6124 */       return this.binaryRepresentation;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Map<TypeDescription, byte[]> getAuxiliaryTypes() {
/* 6131 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 6132 */       for (DynamicType dynamicType : this.auxiliaryTypes) {
/* 6133 */         hashMap.put(dynamicType.getTypeDescription(), dynamicType.getBytes());
/* 6134 */         hashMap.putAll(dynamicType.getAuxiliaryTypes());
/*      */       } 
/* 6136 */       return (Map)hashMap;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Map<TypeDescription, File> saveIn(File param1File) {
/* 6143 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*      */       File file;
/* 6145 */       if ((file = new File(param1File, this.typeDescription.getName().replace('.', File.separatorChar) + ".class")).getParentFile() != null && !file.getParentFile().isDirectory() && !file.getParentFile().mkdirs()) {
/* 6146 */         throw new IllegalArgumentException("Could not create directory: " + file.getParentFile());
/*      */       }
/* 6148 */       FileOutputStream fileOutputStream = new FileOutputStream(file);
/*      */       try {
/* 6150 */         fileOutputStream.write(this.binaryRepresentation);
/*      */       } finally {
/* 6152 */         fileOutputStream.close();
/*      */       } 
/* 6154 */       hashMap.put(this.typeDescription, file);
/* 6155 */       for (DynamicType dynamicType : this.auxiliaryTypes) {
/* 6156 */         hashMap.putAll(dynamicType.saveIn(param1File));
/*      */       }
/* 6158 */       return (Map)hashMap;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public File inject(File param1File1, File param1File2) {
/* 6165 */       if (param1File1.equals(param1File2))
/* 6166 */         return inject(param1File1); 
/* 6167 */       return doInject(param1File1, param1File2);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public File inject(File param1File) {
/* 6174 */       FileSystem.getInstance().move(doInject(param1File, File.createTempFile(param1File.getName(), "tmp")), param1File);
/* 6175 */       return param1File;
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
/*      */     private File doInject(File param1File1, File param1File2) {
/* 6187 */       JarInputStream jarInputStream = new JarInputStream(new FileInputStream(param1File1));
/*      */       try {
/* 6189 */         if (!param1File2.isFile() && !param1File2.createNewFile()) {
/* 6190 */           throw new IllegalArgumentException("Could not create file: " + param1File2);
/*      */         }
/*      */         Manifest manifest;
/* 6193 */         JarOutputStream jarOutputStream = ((manifest = jarInputStream.getManifest()) == null) ? new JarOutputStream(new FileOutputStream(param1File2)) : new JarOutputStream(new FileOutputStream(param1File2), manifest);
/*      */ 
/*      */         
/*      */         try {
/* 6197 */           Map<TypeDescription, byte[]> map = getAuxiliaryTypes();
/* 6198 */           HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 6199 */           for (Map.Entry<TypeDescription, byte> entry : map.entrySet()) {
/* 6200 */             hashMap.put(((TypeDescription)entry.getKey()).getInternalName() + ".class", entry.getValue());
/*      */           }
/* 6202 */           hashMap.put(this.typeDescription.getInternalName() + ".class", this.binaryRepresentation);
/*      */           JarEntry jarEntry;
/* 6204 */           while ((jarEntry = jarInputStream.getNextJarEntry()) != null) {
/*      */             byte[] arrayOfByte1; int i; byte[] arrayOfByte2;
/* 6206 */             if ((arrayOfByte2 = (byte[])hashMap.remove(jarEntry.getName())) == null) {
/* 6207 */               jarOutputStream.putNextEntry(jarEntry);
/* 6208 */               arrayOfByte1 = new byte[1024];
/*      */               
/* 6210 */               while ((i = jarInputStream.read(arrayOfByte1)) != -1) {
/* 6211 */                 jarOutputStream.write(arrayOfByte1, 0, i);
/*      */               }
/*      */             } else {
/* 6214 */               jarOutputStream.putNextEntry(new JarEntry(arrayOfByte1.getName()));
/* 6215 */               jarOutputStream.write(i);
/*      */             } 
/* 6217 */             jarInputStream.closeEntry();
/* 6218 */             jarOutputStream.closeEntry();
/*      */           } 
/* 6220 */           for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
/* 6221 */             jarOutputStream.putNextEntry(new JarEntry((String)entry.getKey()));
/* 6222 */             jarOutputStream.write((byte[])entry.getValue());
/* 6223 */             jarOutputStream.closeEntry();
/*      */           } 
/*      */         } finally {
/* 6226 */           jarOutputStream.close();
/*      */         } 
/*      */       } finally {
/* 6229 */         jarInputStream.close();
/*      */       } 
/* 6231 */       return param1File2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public File toJar(File param1File) {
/*      */       Manifest manifest;
/* 6239 */       (manifest = new Manifest()).getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
/* 6240 */       return toJar(param1File, manifest);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public File toJar(File param1File, Manifest param1Manifest) {
/* 6247 */       if (!param1File.isFile() && !param1File.createNewFile()) {
/* 6248 */         throw new IllegalArgumentException("Could not create file: " + param1File);
/*      */       }
/* 6250 */       JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(param1File), param1Manifest);
/*      */       try {
/* 6252 */         for (Map.Entry<TypeDescription, byte> entry : getAuxiliaryTypes().entrySet()) {
/* 6253 */           jarOutputStream.putNextEntry(new JarEntry(((TypeDescription)entry.getKey()).getInternalName() + ".class"));
/* 6254 */           jarOutputStream.write((byte[])entry.getValue());
/* 6255 */           jarOutputStream.closeEntry();
/*      */         } 
/* 6257 */         jarOutputStream.putNextEntry(new JarEntry(this.typeDescription.getInternalName() + ".class"));
/* 6258 */         jarOutputStream.write(this.binaryRepresentation);
/* 6259 */         jarOutputStream.closeEntry();
/*      */       } finally {
/* 6261 */         jarOutputStream.close();
/*      */       } 
/* 6263 */       return param1File;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.typeDescription.equals(((Default)param1Object).typeDescription) ? false : (!Arrays.equals(this.binaryRepresentation, ((Default)param1Object).binaryRepresentation) ? false : (!this.loadedTypeInitializer.equals(((Default)param1Object).loadedTypeInitializer) ? false : (!!this.auxiliaryTypes.equals(((Default)param1Object).auxiliaryTypes)))))));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return (((getClass().hashCode() * 31 + this.typeDescription.hashCode()) * 31 + Arrays.hashCode(this.binaryRepresentation)) * 31 + this.loadedTypeInitializer.hashCode()) * 31 + this.auxiliaryTypes.hashCode();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class Unloaded<T>
/*      */       extends Default
/*      */       implements DynamicType.Unloaded<T>
/*      */     {
/*      */       private final TypeResolutionStrategy.Resolved typeResolutionStrategy;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Unloaded(TypeDescription param2TypeDescription, byte[] param2ArrayOfbyte, LoadedTypeInitializer param2LoadedTypeInitializer, List<? extends DynamicType> param2List, TypeResolutionStrategy.Resolved param2Resolved) {
/* 6294 */         super(param2TypeDescription, param2ArrayOfbyte, param2LoadedTypeInitializer, param2List);
/* 6295 */         this.typeResolutionStrategy = param2Resolved;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Loaded<T> load(@MaybeNull ClassLoader param2ClassLoader) {
/* 6302 */         if (param2ClassLoader instanceof InjectionClassLoader && !((InjectionClassLoader)param2ClassLoader).isSealed()) {
/* 6303 */           return load((InjectionClassLoader)param2ClassLoader, (ClassLoadingStrategy<? super InjectionClassLoader>)InjectionClassLoader.Strategy.INSTANCE);
/*      */         }
/* 6305 */         return load(param2ClassLoader, (ClassLoadingStrategy<? super ClassLoader>)ClassLoadingStrategy.Default.WRAPPER);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public <S extends ClassLoader> DynamicType.Loaded<T> load(@MaybeNull S param2S, ClassLoadingStrategy<? super S> param2ClassLoadingStrategy) {
/* 6313 */         return new DynamicType.Default.Loaded<T>(this.typeDescription, this.binaryRepresentation, this.loadedTypeInitializer, this.auxiliaryTypes, this.typeResolutionStrategy
/*      */ 
/*      */ 
/*      */             
/* 6317 */             .initialize(this, param2S, param2ClassLoadingStrategy));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Unloaded<T> include(DynamicType... param2VarArgs) {
/* 6324 */         return include(Arrays.asList(param2VarArgs));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DynamicType.Unloaded<T> include(List<? extends DynamicType> param2List) {
/* 6331 */         return new Unloaded(this.typeDescription, this.binaryRepresentation, this.loadedTypeInitializer, 
/*      */ 
/*      */             
/* 6334 */             CompoundList.of(this.auxiliaryTypes, param2List), this.typeResolutionStrategy);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return !super.equals(param2Object) ? false : ((this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.typeResolutionStrategy.equals(((Unloaded)param2Object).typeResolutionStrategy)))));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return super.hashCode() * 31 + this.typeResolutionStrategy.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class Loaded<T>
/*      */       extends Default
/*      */       implements DynamicType.Loaded<T>
/*      */     {
/*      */       private final Map<TypeDescription, Class<?>> loadedTypes;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected Loaded(TypeDescription param2TypeDescription, byte[] param2ArrayOfbyte, LoadedTypeInitializer param2LoadedTypeInitializer, List<? extends DynamicType> param2List, Map<TypeDescription, Class<?>> param2Map) {
/* 6367 */         super(param2TypeDescription, param2ArrayOfbyte, param2LoadedTypeInitializer, param2List);
/* 6368 */         this.loadedTypes = param2Map;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Class<? extends T> getLoaded() {
/* 6376 */         return (Class<? extends T>)this.loadedTypes.get(this.typeDescription);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Map<TypeDescription, Class<?>> getLoadedAuxiliaryTypes() {
/*      */         HashMap<TypeDescription, Class<?>> hashMap;
/* 6384 */         (hashMap = new HashMap<TypeDescription, Class<?>>(this.loadedTypes)).remove(this.typeDescription);
/* 6385 */         return hashMap;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Map<TypeDescription, Class<?>> getAllLoaded() {
/* 6392 */         return new HashMap<TypeDescription, Class<?>>(this.loadedTypes);
/*      */       }
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return !super.equals(param2Object) ? false : ((this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.loadedTypes.equals(((Loaded)param2Object).loadedTypes)))));
/*      */       }
/*      */       
/*      */       public int hashCode() {
/*      */         return super.hashCode() * 31 + this.loadedTypes.hashCode();
/*      */       }
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\DynamicType.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */