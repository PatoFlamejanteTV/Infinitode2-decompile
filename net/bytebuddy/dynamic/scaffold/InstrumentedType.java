/*      */ package net.bytebuddy.dynamic.scaffold;
/*      */ 
/*      */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*      */ import java.lang.annotation.ElementType;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import net.bytebuddy.ClassFileVersion;
/*      */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*      */ import net.bytebuddy.description.annotation.AnnotationList;
/*      */ import net.bytebuddy.description.annotation.AnnotationValue;
/*      */ import net.bytebuddy.description.field.FieldDescription;
/*      */ import net.bytebuddy.description.field.FieldList;
/*      */ import net.bytebuddy.description.method.MethodDescription;
/*      */ import net.bytebuddy.description.method.MethodList;
/*      */ import net.bytebuddy.description.method.ParameterDescription;
/*      */ import net.bytebuddy.description.modifier.ModifierContributor;
/*      */ import net.bytebuddy.description.type.PackageDescription;
/*      */ import net.bytebuddy.description.type.RecordComponentDescription;
/*      */ import net.bytebuddy.description.type.RecordComponentList;
/*      */ import net.bytebuddy.description.type.TypeDefinition;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.description.type.TypeList;
/*      */ import net.bytebuddy.description.type.TypeVariableToken;
/*      */ import net.bytebuddy.dynamic.TargetType;
/*      */ import net.bytebuddy.dynamic.Transformer;
/*      */ import net.bytebuddy.implementation.LoadedTypeInitializer;
/*      */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*      */ import net.bytebuddy.matcher.ElementMatcher;
/*      */ import net.bytebuddy.matcher.ElementMatchers;
/*      */ import net.bytebuddy.utility.CompoundList;
/*      */ import net.bytebuddy.utility.JavaType;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public interface InstrumentedType
/*      */   extends TypeDescription
/*      */ {
/*      */   InstrumentedType withField(FieldDescription.Token paramToken);
/*      */   
/*      */   InstrumentedType withAuxiliaryField(FieldDescription.Token paramToken, Object paramObject);
/*      */   
/*      */   InstrumentedType withMethod(MethodDescription.Token paramToken);
/*      */   
/*      */   InstrumentedType withRecordComponent(RecordComponentDescription.Token paramToken);
/*      */   
/*      */   InstrumentedType withModifiers(int paramInt);
/*      */   
/*      */   InstrumentedType withInterfaces(TypeList.Generic paramGeneric);
/*      */   
/*      */   InstrumentedType withTypeVariable(TypeVariableToken paramTypeVariableToken);
/*      */   
/*      */   InstrumentedType withAnnotations(List<? extends AnnotationDescription> paramList);
/*      */   
/*      */   InstrumentedType withNestHost(TypeDescription paramTypeDescription);
/*      */   
/*      */   InstrumentedType withNestMembers(TypeList paramTypeList);
/*      */   
/*      */   InstrumentedType withEnclosingType(TypeDescription paramTypeDescription);
/*      */   
/*      */   InstrumentedType withEnclosingMethod(MethodDescription.InDefinedShape paramInDefinedShape);
/*      */   
/*      */   InstrumentedType withDeclaringType(@MaybeNull TypeDescription paramTypeDescription);
/*      */   
/*      */   InstrumentedType withDeclaredTypes(TypeList paramTypeList);
/*      */   
/*      */   InstrumentedType withPermittedSubclasses(@MaybeNull TypeList paramTypeList);
/*      */   
/*      */   InstrumentedType withLocalClass(boolean paramBoolean);
/*      */   
/*      */   InstrumentedType withAnonymousClass(boolean paramBoolean);
/*      */   
/*      */   InstrumentedType withRecord(boolean paramBoolean);
/*      */   
/*      */   InstrumentedType withInitializer(LoadedTypeInitializer paramLoadedTypeInitializer);
/*      */   
/*      */   InstrumentedType withInitializer(ByteCodeAppender paramByteCodeAppender);
/*      */   
/*      */   LoadedTypeInitializer getLoadedTypeInitializer();
/*      */   
/*      */   TypeInitializer getTypeInitializer();
/*      */   
/*      */   TypeDescription validated();
/*      */   
/*      */   public static interface WithFlexibleName
/*      */     extends InstrumentedType
/*      */   {
/*      */     WithFlexibleName withField(FieldDescription.Token param1Token);
/*      */     
/*      */     WithFlexibleName withAuxiliaryField(FieldDescription.Token param1Token, Object param1Object);
/*      */     
/*      */     WithFlexibleName withMethod(MethodDescription.Token param1Token);
/*      */     
/*      */     WithFlexibleName withRecordComponent(RecordComponentDescription.Token param1Token);
/*      */     
/*      */     WithFlexibleName withModifiers(int param1Int);
/*      */     
/*      */     WithFlexibleName withInterfaces(TypeList.Generic param1Generic);
/*      */     
/*      */     WithFlexibleName withNestHost(TypeDescription param1TypeDescription);
/*      */     
/*      */     WithFlexibleName withNestMembers(TypeList param1TypeList);
/*      */     
/*      */     WithFlexibleName withEnclosingType(@MaybeNull TypeDescription param1TypeDescription);
/*      */     
/*      */     WithFlexibleName withEnclosingMethod(MethodDescription.InDefinedShape param1InDefinedShape);
/*      */     
/*      */     WithFlexibleName withDeclaringType(@MaybeNull TypeDescription param1TypeDescription);
/*      */     
/*      */     WithFlexibleName withDeclaredTypes(TypeList param1TypeList);
/*      */     
/*      */     WithFlexibleName withPermittedSubclasses(@MaybeNull TypeList param1TypeList);
/*      */     
/*      */     WithFlexibleName withLocalClass(boolean param1Boolean);
/*      */     
/*      */     WithFlexibleName withAnonymousClass(boolean param1Boolean);
/*      */     
/*      */     WithFlexibleName withRecord(boolean param1Boolean);
/*      */     
/*      */     WithFlexibleName withTypeVariable(TypeVariableToken param1TypeVariableToken);
/*      */     
/*      */     WithFlexibleName withAnnotations(List<? extends AnnotationDescription> param1List);
/*      */     
/*      */     WithFlexibleName withInitializer(LoadedTypeInitializer param1LoadedTypeInitializer);
/*      */     
/*      */     WithFlexibleName withInitializer(ByteCodeAppender param1ByteCodeAppender);
/*      */     
/*      */     WithFlexibleName withName(String param1String);
/*      */     
/*      */     WithFlexibleName withTypeVariables(ElementMatcher<? super TypeDescription.Generic> param1ElementMatcher, Transformer<TypeVariableToken> param1Transformer);
/*      */   }
/*      */   
/*      */   public static interface Prepareable
/*      */   {
/*      */     InstrumentedType prepare(InstrumentedType param1InstrumentedType);
/*      */     
/*      */     public enum NoOp
/*      */       implements Prepareable
/*      */     {
/*  386 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final InstrumentedType prepare(InstrumentedType param2InstrumentedType) {
/*  392 */         return param2InstrumentedType;
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
/*      */   
/*      */   public static interface Factory
/*      */   {
/*      */     InstrumentedType.WithFlexibleName represent(TypeDescription param1TypeDescription);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     InstrumentedType.WithFlexibleName subclass(String param1String, int param1Int, TypeDescription.Generic param1Generic);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public enum Default
/*      */       implements Factory
/*      */     {
/*  428 */       MODIFIABLE
/*      */       {
/*      */         public final InstrumentedType.WithFlexibleName represent(TypeDescription param3TypeDescription) {
/*  431 */           return new InstrumentedType.Default(param3TypeDescription.getName(), param3TypeDescription
/*  432 */               .getModifiers(), param3TypeDescription
/*  433 */               .getSuperClass(), (List<? extends TypeVariableToken>)param3TypeDescription
/*  434 */               .getTypeVariables().asTokenList((ElementMatcher)ElementMatchers.is(param3TypeDescription)), (List<? extends TypeDescription.Generic>)param3TypeDescription
/*  435 */               .getInterfaces().accept(TypeDescription.Generic.Visitor.Substitutor.ForDetachment.of((TypeDefinition)param3TypeDescription)), (List<? extends FieldDescription.Token>)param3TypeDescription
/*  436 */               .getDeclaredFields().asTokenList((ElementMatcher)ElementMatchers.is(param3TypeDescription)), 
/*  437 */               Collections.emptyMap(), (List<? extends MethodDescription.Token>)param3TypeDescription
/*  438 */               .getDeclaredMethods().asTokenList((ElementMatcher)ElementMatchers.is(param3TypeDescription)), (List<? extends RecordComponentDescription.Token>)param3TypeDescription
/*  439 */               .getRecordComponents().asTokenList((ElementMatcher)ElementMatchers.is(param3TypeDescription)), (List<? extends AnnotationDescription>)param3TypeDescription
/*  440 */               .getDeclaredAnnotations(), TypeInitializer.None.INSTANCE, (LoadedTypeInitializer)LoadedTypeInitializer.NoOp.INSTANCE, param3TypeDescription
/*      */ 
/*      */               
/*  443 */               .getDeclaringType(), param3TypeDescription
/*  444 */               .getEnclosingMethod(), param3TypeDescription
/*  445 */               .getEnclosingType(), (List<? extends TypeDescription>)param3TypeDescription
/*  446 */               .getDeclaredTypes(), 
/*  447 */               param3TypeDescription.isSealed() ? (List<? extends TypeDescription>)param3TypeDescription
/*  448 */               .getPermittedSubtypes() : (List<? extends TypeDescription>)TypeList.UNDEFINED, param3TypeDescription
/*      */               
/*  450 */               .isAnonymousType(), param3TypeDescription
/*  451 */               .isLocalType(), param3TypeDescription
/*  452 */               .isRecord(), 
/*  453 */               param3TypeDescription.isNestHost() ? TargetType.DESCRIPTION : param3TypeDescription
/*      */               
/*  455 */               .getNestHost(), 
/*  456 */               param3TypeDescription.isNestHost() ? (List<? extends TypeDescription>)param3TypeDescription
/*  457 */               .getNestMembers().filter((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.is(param3TypeDescription))) : 
/*  458 */               Collections.<TypeDescription>emptyList());
/*      */         }
/*      */       },
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  465 */       FROZEN
/*      */       {
/*      */         public final InstrumentedType.WithFlexibleName represent(TypeDescription param3TypeDescription) {
/*  468 */           return new InstrumentedType.Frozen(param3TypeDescription, (LoadedTypeInitializer)LoadedTypeInitializer.NoOp.INSTANCE);
/*      */         }
/*      */       };
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public InstrumentedType.WithFlexibleName subclass(String param2String, int param2Int, TypeDescription.Generic param2Generic) {
/*  476 */         return new InstrumentedType.Default(param2String, param2Int, param2Generic, 
/*      */ 
/*      */             
/*  479 */             Collections.emptyList(), 
/*  480 */             Collections.emptyList(), 
/*  481 */             Collections.emptyList(), 
/*  482 */             Collections.emptyMap(), 
/*  483 */             Collections.emptyList(), 
/*  484 */             Collections.emptyList(), 
/*  485 */             Collections.emptyList(), TypeInitializer.None.INSTANCE, (LoadedTypeInitializer)LoadedTypeInitializer.NoOp.INSTANCE, TypeDescription.UNDEFINED, MethodDescription.UNDEFINED, TypeDescription.UNDEFINED, 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  491 */             Collections.emptyList(), (List<? extends TypeDescription>)TypeList.UNDEFINED, false, false, false, TargetType.DESCRIPTION, 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  497 */             Collections.emptyList());
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Default
/*      */     extends TypeDescription.AbstractBase.OfSimpleType
/*      */     implements WithFlexibleName
/*      */   {
/*  510 */     private static final Set<String> KEYWORDS = new HashSet<String>(Arrays.asList(new String[] { "abstract", "continue", "for", "new", "switch", "assert", "default", "goto", "package", "synchronized", "boolean", "do", "if", "private", "this", "break", "double", "implements", "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum", "instanceof", "return", "transient", "catch", "extends", "int", "short", "try", "char", "final", "interface", "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float", "native", "super", "while" }));
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
/*      */     private final int modifiers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     private final TypeDescription.Generic superClass;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<? extends TypeVariableToken> typeVariables;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<? extends TypeDescription.Generic> interfaceTypes;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<? extends FieldDescription.Token> fieldTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final Map<String, Object> auxiliaryFields;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<? extends MethodDescription.Token> methodTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<? extends RecordComponentDescription.Token> recordComponentTokens;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<? extends AnnotationDescription> annotationDescriptions;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final TypeInitializer typeInitializer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final LoadedTypeInitializer loadedTypeInitializer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     private final TypeDescription declaringType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     private final MethodDescription.InDefinedShape enclosingMethod;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     private final TypeDescription enclosingType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<? extends TypeDescription> declaredTypes;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     private final List<? extends TypeDescription> permittedSubclasses;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final boolean anonymousClass;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final boolean localClass;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final boolean record;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final TypeDescription nestHost;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<? extends TypeDescription> nestMembers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Default(String param1String, int param1Int, @MaybeNull TypeDescription.Generic param1Generic, List<? extends TypeVariableToken> param1List, List<? extends TypeDescription.Generic> param1List1, List<? extends FieldDescription.Token> param1List2, Map<String, Object> param1Map, List<? extends MethodDescription.Token> param1List3, List<? extends RecordComponentDescription.Token> param1List4, List<? extends AnnotationDescription> param1List5, TypeInitializer param1TypeInitializer, LoadedTypeInitializer param1LoadedTypeInitializer, @MaybeNull TypeDescription param1TypeDescription1, @MaybeNull MethodDescription.InDefinedShape param1InDefinedShape, @MaybeNull TypeDescription param1TypeDescription2, List<? extends TypeDescription> param1List6, @MaybeNull List<? extends TypeDescription> param1List7, boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3, TypeDescription param1TypeDescription3, List<? extends TypeDescription> param1List8) {
/*  681 */       this.name = param1String;
/*  682 */       this.modifiers = param1Int;
/*  683 */       this.typeVariables = param1List;
/*  684 */       this.superClass = param1Generic;
/*  685 */       this.interfaceTypes = param1List1;
/*  686 */       this.fieldTokens = param1List2;
/*  687 */       this.auxiliaryFields = param1Map;
/*  688 */       this.methodTokens = param1List3;
/*  689 */       this.recordComponentTokens = param1List4;
/*  690 */       this.annotationDescriptions = param1List5;
/*  691 */       this.typeInitializer = param1TypeInitializer;
/*  692 */       this.loadedTypeInitializer = param1LoadedTypeInitializer;
/*  693 */       this.declaringType = param1TypeDescription1;
/*  694 */       this.enclosingMethod = param1InDefinedShape;
/*  695 */       this.enclosingType = param1TypeDescription2;
/*  696 */       this.declaredTypes = param1List6;
/*  697 */       this.permittedSubclasses = param1List7;
/*  698 */       this.anonymousClass = param1Boolean1;
/*  699 */       this.localClass = param1Boolean2;
/*  700 */       this.record = param1Boolean3;
/*  701 */       this.nestHost = param1TypeDescription3;
/*  702 */       this.nestMembers = param1List8;
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
/*      */     public static InstrumentedType of(String param1String, TypeDescription.Generic param1Generic, ModifierContributor.ForType... param1VarArgs) {
/*  714 */       return of(param1String, param1Generic, ModifierContributor.Resolver.of(param1VarArgs).resolve());
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
/*      */     public static InstrumentedType of(String param1String, TypeDescription.Generic param1Generic, int param1Int) {
/*  726 */       return InstrumentedType.Factory.Default.MODIFIABLE.subclass(param1String, param1Int, param1Generic);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withModifiers(int param1Int) {
/*  733 */       return new Default(this.name, param1Int, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
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
/*      */     public InstrumentedType.WithFlexibleName withField(FieldDescription.Token param1Token) {
/*  761 */       return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  766 */           CompoundList.of(this.fieldTokens, param1Token.accept(TypeDescription.Generic.Visitor.Substitutor.ForDetachment.of((TypeDefinition)this))), this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
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
/*      */     public InstrumentedType.WithFlexibleName withAuxiliaryField(FieldDescription.Token param1Token, Object param1Object) {
/*      */       HashMap<String, Object> hashMap;
/*      */       Object object;
/*  791 */       if ((object = (hashMap = new HashMap<String, Object>(this.auxiliaryFields)).put(param1Token.getName(), param1Object)) != null) {
/*  792 */         if (object == param1Object) {
/*  793 */           return this;
/*      */         }
/*  795 */         throw new IllegalStateException("Field " + param1Token.getName() + " for " + this + " already mapped to " + object + " and not " + param1Object);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  801 */       return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  806 */           CompoundList.of(this.fieldTokens, param1Token.accept(TypeDescription.Generic.Visitor.Substitutor.ForDetachment.of((TypeDefinition)this))), hashMap, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, (LoadedTypeInitializer)new LoadedTypeInitializer.Compound(new LoadedTypeInitializer[] { this.loadedTypeInitializer, (LoadedTypeInitializer)new LoadedTypeInitializer.ForStaticField(param1Token
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*  812 */                 .getName(), param1Object) }), this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
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
/*      */     public InstrumentedType.WithFlexibleName withMethod(MethodDescription.Token param1Token) {
/*  829 */       return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  836 */           CompoundList.of(this.methodTokens, param1Token.accept(TypeDescription.Generic.Visitor.Substitutor.ForDetachment.of((TypeDefinition)this))), this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
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
/*      */     public InstrumentedType.WithFlexibleName withRecordComponent(RecordComponentDescription.Token param1Token) {
/*  857 */       return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  865 */           CompoundList.of(this.recordComponentTokens, param1Token.accept(TypeDescription.Generic.Visitor.Substitutor.ForDetachment.of((TypeDefinition)this))), this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, true, this.nestHost, this.nestMembers);
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
/*      */     public InstrumentedType.WithFlexibleName withInterfaces(TypeList.Generic param1Generic) {
/*  885 */       return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, 
/*      */ 
/*      */ 
/*      */           
/*  889 */           CompoundList.of(this.interfaceTypes, (List)param1Generic.accept(TypeDescription.Generic.Visitor.Substitutor.ForDetachment.of((TypeDefinition)this))), this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
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
/*      */     public InstrumentedType.WithFlexibleName withAnnotations(List<? extends AnnotationDescription> param1List) {
/*  913 */       return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  922 */           CompoundList.of(this.annotationDescriptions, param1List), this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
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
/*      */     public InstrumentedType.WithFlexibleName withNestHost(TypeDescription param1TypeDescription) {
/*  941 */       return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  961 */           param1TypeDescription.equals(this) ? TargetType.DESCRIPTION : param1TypeDescription, 
/*      */ 
/*      */           
/*  964 */           Collections.emptyList());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withNestMembers(TypeList param1TypeList) {
/*  971 */       return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, TargetType.DESCRIPTION, 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  992 */           CompoundList.of(this.nestMembers, (List)param1TypeList));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withEnclosingType(@MaybeNull TypeDescription param1TypeDescription) {
/*  999 */       return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, MethodDescription.UNDEFINED, param1TypeDescription, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
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
/*      */     public InstrumentedType.WithFlexibleName withEnclosingMethod(MethodDescription.InDefinedShape param1InDefinedShape) {
/* 1027 */       return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, param1InDefinedShape, param1InDefinedShape
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1041 */           .getDeclaringType(), this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
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
/*      */     public InstrumentedType.WithFlexibleName withDeclaringType(@MaybeNull TypeDescription param1TypeDescription) {
/* 1055 */       return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, param1TypeDescription, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
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
/*      */     public InstrumentedType.WithFlexibleName withDeclaredTypes(TypeList param1TypeList) {
/* 1083 */       return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1098 */           CompoundList.of(this.declaredTypes, (List)param1TypeList), this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
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
/*      */     public InstrumentedType.WithFlexibleName withPermittedSubclasses(@MaybeNull TypeList param1TypeList) {
/* 1111 */       return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, (param1TypeList == null || this.permittedSubclasses == null) ? (List<? extends TypeDescription>)param1TypeList : 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1129 */           CompoundList.of(this.permittedSubclasses, (List)param1TypeList), this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
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
/*      */     public InstrumentedType.WithFlexibleName withTypeVariable(TypeVariableToken param1TypeVariableToken) {
/* 1141 */       return new Default(this.name, this.modifiers, this.superClass, 
/*      */ 
/*      */           
/* 1144 */           CompoundList.of(this.typeVariables, param1TypeVariableToken.accept(TypeDescription.Generic.Visitor.Substitutor.ForDetachment.of((TypeDefinition)this))), this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
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
/*      */     public InstrumentedType.WithFlexibleName withName(String param1String) {
/* 1169 */       return new Default(param1String, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
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
/*      */     public InstrumentedType.WithFlexibleName withTypeVariables(ElementMatcher<? super TypeDescription.Generic> param1ElementMatcher, Transformer<TypeVariableToken> param1Transformer) {
/* 1197 */       ArrayList<TypeVariableToken> arrayList = new ArrayList(this.typeVariables.size());
/* 1198 */       byte b = 0;
/* 1199 */       for (TypeVariableToken typeVariableToken : this.typeVariables) {
/* 1200 */         arrayList.add(param1ElementMatcher.matches(getTypeVariables().get(b++)) ? (TypeVariableToken)param1Transformer
/* 1201 */             .transform(this, typeVariableToken) : typeVariableToken);
/*      */       }
/*      */       
/* 1204 */       return new Default(this.name, this.modifiers, this.superClass, arrayList, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
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
/*      */     public InstrumentedType.WithFlexibleName withLocalClass(boolean param1Boolean) {
/* 1232 */       return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, false, param1Boolean, this.record, this.nestHost, this.nestMembers);
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
/*      */     public InstrumentedType.WithFlexibleName withAnonymousClass(boolean param1Boolean) {
/* 1260 */       return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, param1Boolean, false, this.record, this.nestHost, this.nestMembers);
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
/*      */     public InstrumentedType.WithFlexibleName withRecord(boolean param1Boolean) {
/* 1288 */       return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, param1Boolean ? this.recordComponentTokens : 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1298 */           Collections.<RecordComponentDescription.Token>emptyList(), this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, param1Boolean, this.nestHost, this.nestMembers);
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
/*      */     public InstrumentedType.WithFlexibleName withInitializer(LoadedTypeInitializer param1LoadedTypeInitializer) {
/* 1318 */       return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, (LoadedTypeInitializer)new LoadedTypeInitializer.Compound(new LoadedTypeInitializer[] { this.loadedTypeInitializer, param1LoadedTypeInitializer }, ), this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
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
/*      */     public InstrumentedType.WithFlexibleName withInitializer(ByteCodeAppender param1ByteCodeAppender) {
/* 1346 */       return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1356 */           .expandWith(param1ByteCodeAppender), this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
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
/*      */     public LoadedTypeInitializer getLoadedTypeInitializer() {
/* 1374 */       return this.loadedTypeInitializer;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeInitializer getTypeInitializer() {
/* 1381 */       return this.typeInitializer;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public MethodDescription.InDefinedShape getEnclosingMethod() {
/* 1389 */       return this.enclosingMethod;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public TypeDescription getEnclosingType() {
/* 1397 */       return this.enclosingType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeList getDeclaredTypes() {
/* 1404 */       return (TypeList)new TypeList.Explicit(this.declaredTypes);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isAnonymousType() {
/* 1411 */       return this.anonymousClass;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isLocalType() {
/* 1418 */       return this.localClass;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public PackageDescription getPackage() {
/*      */       int i;
/* 1427 */       return (PackageDescription)(((i = this.name.lastIndexOf('.')) == -1) ? PackageDescription.DEFAULT : new PackageDescription.Simple(this.name
/*      */           
/* 1429 */           .substring(0, i)));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationList getDeclaredAnnotations() {
/* 1436 */       return (AnnotationList)new AnnotationList.Explicit(this.annotationDescriptions);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public TypeDescription getDeclaringType() {
/* 1444 */       return this.declaringType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public TypeDescription.Generic getSuperClass() {
/* 1452 */       return (TypeDescription.Generic)((this.superClass == null) ? TypeDescription.Generic.UNDEFINED : new TypeDescription.Generic.LazyProjection.WithResolvedErasure(this.superClass, 
/*      */           
/* 1454 */           (TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(this)));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeList.Generic getInterfaces() {
/* 1461 */       return (TypeList.Generic)new TypeList.Generic.ForDetachedTypes.WithResolvedErasure(this.interfaceTypes, (TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(this));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
/* 1468 */       return (FieldList<FieldDescription.InDefinedShape>)new FieldList.ForTokens(this, this.fieldTokens);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
/* 1475 */       return (MethodList<MethodDescription.InDefinedShape>)new MethodList.ForTokens(this, this.methodTokens);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeList.Generic getTypeVariables() {
/* 1482 */       return TypeList.Generic.ForDetachedTypes.attachVariables(this, this.typeVariables);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getModifiers() {
/* 1489 */       return this.modifiers;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getName() {
/* 1496 */       return this.name;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription getNestHost() {
/* 1503 */       return this.nestHost.represents(TargetType.class) ? this : this.nestHost;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeList getNestMembers() {
/* 1512 */       return (TypeList)(this.nestHost.represents(TargetType.class) ? new TypeList.Explicit(
/* 1513 */           CompoundList.of(this, this.nestMembers)) : this.nestHost
/* 1514 */         .getNestMembers());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
/* 1521 */       return (RecordComponentList<RecordComponentDescription.InDefinedShape>)new RecordComponentList.ForTokens(this, this.recordComponentTokens);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming super class for given instance.")
/*      */     public boolean isRecord() {
/* 1529 */       if (this.record && this.superClass != null && 
/*      */         
/* 1531 */         getSuperClass().asErasure().equals(JavaType.RECORD.getTypeStub())) return true; 
/*      */       return false;
/*      */     }
/*      */     
/*      */     public boolean isSealed() {
/* 1536 */       return (this.permittedSubclasses != null);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeList getPermittedSubtypes() {
/* 1543 */       return (this.permittedSubclasses == null) ? (TypeList)new TypeList.Empty() : (TypeList)new TypeList.Explicit(this.permittedSubclasses);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription validated() {
/* 1552 */       if (!isValidIdentifier(getName().split("\\.")))
/* 1553 */         throw new IllegalStateException("Illegal type name: " + getName() + " for " + this); 
/* 1554 */       if ((getModifiers() & 0xFFFD89E0) != 0)
/* 1555 */         throw new IllegalStateException("Illegal modifiers " + getModifiers() + " for " + this); 
/* 1556 */       if (isPackageType() && getModifiers() != 5632) {
/* 1557 */         throw new IllegalStateException("Illegal modifiers " + getModifiers() + " for package " + this);
/*      */       }
/*      */       TypeDescription.Generic generic;
/* 1560 */       if ((generic = getSuperClass()) != null) {
/* 1561 */         if (!((Boolean)generic.accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Validator.SUPER_CLASS)).booleanValue())
/* 1562 */           throw new IllegalStateException("Illegal super class " + generic + " for " + this); 
/* 1563 */         if (!((Boolean)generic.accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE)).booleanValue())
/* 1564 */           throw new IllegalStateException("Illegal type annotations on super class " + generic + " for " + this); 
/* 1565 */         if (!generic.asErasure().isVisibleTo(this)) {
/* 1566 */           throw new IllegalStateException("Invisible super type " + generic + " for " + this);
/*      */         }
/*      */       } 
/* 1569 */       HashSet<TypeDescription> hashSet1 = new HashSet();
/* 1570 */       for (Iterator<TypeDescription.Generic> iterator2 = getInterfaces().iterator(); iterator2.hasNext(); ) {
/* 1571 */         TypeDescription.Generic generic2; if (!((Boolean)(generic2 = iterator2.next()).accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Validator.INTERFACE)).booleanValue())
/* 1572 */           throw new IllegalStateException("Illegal interface " + generic2 + " for " + this); 
/* 1573 */         if (!((Boolean)generic2.accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE)).booleanValue())
/* 1574 */           throw new IllegalStateException("Illegal type annotations on interface " + generic2 + " for " + this); 
/* 1575 */         if (!hashSet1.add(generic2.asErasure()))
/* 1576 */           throw new IllegalStateException("Already implemented interface " + generic2 + " for " + this); 
/* 1577 */         if (!generic2.asErasure().isVisibleTo(this)) {
/* 1578 */           throw new IllegalStateException("Invisible interface type " + generic2 + " for " + this);
/*      */         }
/*      */       } 
/*      */       TypeList.Generic generic1;
/* 1582 */       if (!(generic1 = getTypeVariables()).isEmpty() && isAssignableTo(Throwable.class)) {
/* 1583 */         throw new IllegalStateException("Cannot define throwable " + this + " to be generic");
/*      */       }
/* 1585 */       HashSet<String> hashSet2 = new HashSet();
/* 1586 */       for (Iterator<TypeDescription.Generic> iterator1 = generic1.iterator(); iterator1.hasNext(); ) {
/* 1587 */         TypeDescription.Generic generic2; String str = (generic2 = iterator1.next()).getSymbol();
/* 1588 */         if (!hashSet2.add(str))
/* 1589 */           throw new IllegalStateException("Duplicate type variable symbol '" + generic2 + "' for " + this); 
/* 1590 */         if (!isValidIdentifier(str))
/* 1591 */           throw new IllegalStateException("Illegal type variable name '" + generic2 + "' for " + this); 
/* 1592 */         if (!TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.ofFormalTypeVariable(generic2)) {
/* 1593 */           throw new IllegalStateException("Illegal type annotation on '" + generic2 + "' for " + this);
/*      */         }
/* 1595 */         boolean bool = false;
/* 1596 */         HashSet<TypeDescription.Generic> hashSet6 = new HashSet();
/* 1597 */         for (Iterator<TypeDescription.Generic> iterator6 = generic2.getUpperBounds().iterator(); iterator6.hasNext(); ) {
/* 1598 */           TypeDescription.Generic generic3; if (!((Boolean)(generic3 = iterator6.next()).accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Validator.TYPE_VARIABLE)).booleanValue())
/* 1599 */             throw new IllegalStateException("Illegal type variable bound " + generic3 + " of " + generic2 + " for " + this); 
/* 1600 */           if (!((Boolean)generic3.accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE)).booleanValue())
/* 1601 */             throw new IllegalStateException("Illegal type annotations on type variable " + generic3 + " for " + this); 
/* 1602 */           if (!hashSet6.add(generic3))
/* 1603 */             throw new IllegalStateException("Duplicate bound " + generic3 + " of " + generic2 + " for " + this); 
/* 1604 */           if (bool && (generic3.getSort().isTypeVariable() || !generic3.isInterface())) {
/* 1605 */             throw new IllegalStateException("Illegal interface bound " + generic3 + " of " + generic2 + " for " + this);
/*      */           }
/* 1607 */           bool = true;
/*      */         } 
/* 1609 */         if (!bool) {
/* 1610 */           throw new IllegalStateException("Type variable " + generic2 + " for " + this + " does not define at least one bound");
/*      */         }
/*      */       } 
/*      */       TypeDescription typeDescription1;
/* 1614 */       if ((typeDescription1 = getEnclosingType()) != null && (typeDescription1.isArray() || typeDescription1.isPrimitive())) {
/* 1615 */         throw new IllegalStateException("Cannot define array type or primitive type " + typeDescription1 + " + as enclosing type for " + this);
/*      */       }
/*      */       MethodDescription.InDefinedShape inDefinedShape;
/* 1618 */       if ((inDefinedShape = getEnclosingMethod()) != null && inDefinedShape.isTypeInitializer()) {
/* 1619 */         throw new IllegalStateException("Cannot enclose type declaration in class initializer " + inDefinedShape);
/*      */       }
/*      */       TypeDescription typeDescription2;
/* 1622 */       if ((typeDescription2 = getDeclaringType()) != null) {
/* 1623 */         if (typeDescription2.isPrimitive() || typeDescription2.isArray()) {
/* 1624 */           throw new IllegalStateException("Cannot define array type or primitive type " + typeDescription2 + " as declaring type for " + this);
/*      */         }
/* 1626 */       } else if (typeDescription1 == null && inDefinedShape == null && (isLocalType() || isAnonymousType())) {
/* 1627 */         throw new IllegalStateException("Cannot define an anonymous or local class without a declaring type for " + this);
/*      */       } 
/* 1629 */       HashSet<TypeDescription> hashSet3 = new HashSet();
/* 1630 */       for (Iterator<TypeDescription> iterator3 = getDeclaredTypes().iterator(); iterator3.hasNext(); ) {
/* 1631 */         TypeDescription typeDescription; if ((typeDescription = iterator3.next()).isArray() || typeDescription.isPrimitive())
/* 1632 */           throw new IllegalStateException("Cannot define array type or primitive type " + typeDescription + " + as declared type for " + this); 
/* 1633 */         if (!hashSet3.add(typeDescription)) {
/* 1634 */           throw new IllegalStateException("Duplicate definition of declared type " + typeDescription);
/*      */         }
/*      */       } 
/*      */       TypeDescription typeDescription3;
/* 1638 */       if ((typeDescription3 = getNestHost()).equals(this)) {
/* 1639 */         HashSet<TypeDescription> hashSet6 = new HashSet();
/* 1640 */         for (Iterator<TypeDescription> iterator6 = getNestMembers().iterator(); iterator6.hasNext(); ) {
/* 1641 */           TypeDescription typeDescription; if ((typeDescription = iterator6.next()).isArray() || typeDescription.isPrimitive())
/* 1642 */             throw new IllegalStateException("Cannot define array type or primitive type " + typeDescription + " + as nest member of " + this); 
/* 1643 */           if (!typeDescription.isSamePackage(this))
/* 1644 */             throw new IllegalStateException("Cannot define nest member " + typeDescription + " + within different package then " + this); 
/* 1645 */           if (!hashSet6.add(typeDescription))
/* 1646 */             throw new IllegalStateException("Duplicate definition of nest member " + typeDescription); 
/*      */         } 
/*      */       } else {
/* 1649 */         if (typeDescription3.isArray() || typeDescription3.isPrimitive())
/* 1650 */           throw new IllegalStateException("Cannot define array type or primitive type " + typeDescription3 + " + as nest host for " + this); 
/* 1651 */         if (!typeDescription3.isSamePackage(this))
/* 1652 */           throw new IllegalStateException("Cannot define nest host " + typeDescription3 + " + within different package then " + this); 
/*      */       } 
/* 1654 */       for (Iterator<TypeDescription> iterator4 = getPermittedSubtypes().iterator(); iterator4.hasNext();) {
/* 1655 */         if (!(typeDescription = iterator4.next()).isAssignableTo(this) || typeDescription.equals(this)) {
/* 1656 */           throw new IllegalStateException("Cannot assign permitted subclass " + typeDescription + " to " + this);
/*      */         }
/*      */       } 
/* 1659 */       HashSet<TypeDescription> hashSet4 = new HashSet();
/* 1660 */       for (Iterator<AnnotationDescription> iterator5 = getDeclaredAnnotations().iterator(); iterator5.hasNext(); ) {
/* 1661 */         AnnotationDescription annotationDescription; if (!(annotationDescription = iterator5.next()).isSupportedOn(ElementType.TYPE) && (
/* 1662 */           !isAnnotation() || !annotationDescription.isSupportedOn(ElementType.ANNOTATION_TYPE)) && (
/* 1663 */           !isPackageType() || !annotationDescription.isSupportedOn(ElementType.PACKAGE)))
/* 1664 */           throw new IllegalStateException("Cannot add " + annotationDescription + " on " + this); 
/* 1665 */         if (!hashSet4.add(annotationDescription.getAnnotationType())) {
/* 1666 */           throw new IllegalStateException("Duplicate annotation " + annotationDescription + " for " + this);
/*      */         }
/*      */       } 
/* 1669 */       HashSet<FieldDescription.SignatureToken> hashSet5 = new HashSet();
/* 1670 */       for (Iterator<FieldDescription.InDefinedShape> iterator = getDeclaredFields().iterator(); iterator.hasNext(); ) {
/* 1671 */         FieldDescription.InDefinedShape inDefinedShape1; String str = (inDefinedShape1 = iterator.next()).getName();
/* 1672 */         if (!hashSet5.add(inDefinedShape1.asSignatureToken()))
/* 1673 */           throw new IllegalStateException("Duplicate field definition for " + inDefinedShape1); 
/* 1674 */         if (!isValidIdentifier(str))
/* 1675 */           throw new IllegalStateException("Illegal field name for " + inDefinedShape1); 
/* 1676 */         if ((inDefinedShape1.getModifiers() & 0xFFFDAF20) != 0) {
/* 1677 */           throw new IllegalStateException("Illegal field modifiers " + inDefinedShape1.getModifiers() + " for " + inDefinedShape1);
/*      */         }
/*      */         TypeDescription.Generic generic2;
/* 1680 */         if (!((Boolean)(generic2 = inDefinedShape1.getType()).accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Validator.FIELD)).booleanValue())
/* 1681 */           throw new IllegalStateException("Illegal field type " + generic2 + " for " + inDefinedShape1); 
/* 1682 */         if (!((Boolean)generic2.accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE)).booleanValue())
/* 1683 */           throw new IllegalStateException("Illegal type annotations on " + generic2 + " for " + this); 
/* 1684 */         if (!inDefinedShape1.isSynthetic() && !generic2.asErasure().isVisibleTo(this)) {
/* 1685 */           throw new IllegalStateException("Invisible field type " + inDefinedShape1.getType() + " for " + inDefinedShape1);
/*      */         }
/* 1687 */         hashSet4 = new HashSet<TypeDescription>();
/* 1688 */         for (Iterator<AnnotationDescription> iterator6 = inDefinedShape1.getDeclaredAnnotations().iterator(); iterator6.hasNext(); ) {
/* 1689 */           AnnotationDescription annotationDescription; if (!(annotationDescription = iterator6.next()).isSupportedOn(ElementType.FIELD))
/* 1690 */             throw new IllegalStateException("Cannot add " + annotationDescription + " on " + inDefinedShape1); 
/* 1691 */           if (!hashSet4.add(annotationDescription.getAnnotationType())) {
/* 1692 */             throw new IllegalStateException("Duplicate annotation " + annotationDescription + " for " + inDefinedShape1);
/*      */           }
/*      */         } 
/*      */       } 
/* 1696 */       HashSet<MethodDescription.SignatureToken> hashSet = new HashSet();
/* 1697 */       for (MethodDescription.InDefinedShape inDefinedShape1 : getDeclaredMethods()) {
/* 1698 */         if (!hashSet.add(inDefinedShape1.asSignatureToken()))
/* 1699 */           throw new IllegalStateException("Duplicate method signature for " + inDefinedShape1); 
/* 1700 */         if ((inDefinedShape1.getModifiers() & 0xFFFFE200) != 0)
/* 1701 */           throw new IllegalStateException("Illegal modifiers " + inDefinedShape1.getModifiers() + " for " + inDefinedShape1); 
/* 1702 */         if (isInterface() && !inDefinedShape1.isPublic() && !inDefinedShape1.isPrivate()) {
/* 1703 */           throw new IllegalStateException("Methods declared by an interface must be public or private " + inDefinedShape1);
/*      */         }
/* 1705 */         HashSet<String> hashSet6 = new HashSet();
/* 1706 */         for (Iterator<TypeDescription.Generic> iterator6 = inDefinedShape1.getTypeVariables().iterator(); iterator6.hasNext(); ) {
/* 1707 */           TypeDescription.Generic generic4; String str = (generic4 = iterator6.next()).getSymbol();
/* 1708 */           if (!hashSet6.add(str))
/* 1709 */             throw new IllegalStateException("Duplicate type variable symbol '" + generic4 + "' for " + inDefinedShape1); 
/* 1710 */           if (!isValidIdentifier(str))
/* 1711 */             throw new IllegalStateException("Illegal type variable name '" + generic4 + "' for " + inDefinedShape1); 
/* 1712 */           if (!TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.ofFormalTypeVariable(generic4)) {
/* 1713 */             throw new IllegalStateException("Illegal type annotation on '" + generic4 + "' for " + inDefinedShape1);
/*      */           }
/* 1715 */           boolean bool = false;
/* 1716 */           HashSet<TypeDescription.Generic> hashSet9 = new HashSet();
/* 1717 */           for (Iterator<TypeDescription.Generic> iterator9 = generic4.getUpperBounds().iterator(); iterator9.hasNext(); ) {
/* 1718 */             TypeDescription.Generic generic5; if (!((Boolean)(generic5 = iterator9.next()).accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Validator.TYPE_VARIABLE)).booleanValue())
/* 1719 */               throw new IllegalStateException("Illegal type variable bound " + generic5 + " of " + generic4 + " for " + inDefinedShape1); 
/* 1720 */             if (!((Boolean)generic5.accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE)).booleanValue())
/* 1721 */               throw new IllegalStateException("Illegal type annotations on bound " + generic5 + " of " + generic4 + " for " + this); 
/* 1722 */             if (!hashSet9.add(generic5))
/* 1723 */               throw new IllegalStateException("Duplicate bound " + generic5 + " of " + generic4 + " for " + inDefinedShape1); 
/* 1724 */             if (bool && (generic5.getSort().isTypeVariable() || !generic5.isInterface())) {
/* 1725 */               throw new IllegalStateException("Illegal interface bound " + generic5 + " of " + generic4 + " for " + inDefinedShape1);
/*      */             }
/* 1727 */             bool = true;
/*      */           } 
/* 1729 */           if (!bool) {
/* 1730 */             throw new IllegalStateException("Type variable " + generic4 + " for " + inDefinedShape1 + " does not define at least one bound");
/*      */           }
/*      */         } 
/* 1733 */         TypeDescription.Generic generic2 = inDefinedShape1.getReturnType();
/* 1734 */         if (inDefinedShape1.isTypeInitializer())
/* 1735 */           throw new IllegalStateException("Illegal explicit declaration of a type initializer by " + this); 
/* 1736 */         if (inDefinedShape1.isConstructor()) {
/* 1737 */           if (!generic2.represents(void.class))
/* 1738 */             throw new IllegalStateException("A constructor must return void " + inDefinedShape1); 
/* 1739 */           if (!generic2.getDeclaredAnnotations().isEmpty())
/* 1740 */             throw new IllegalStateException("The void non-type must not be annotated for " + inDefinedShape1); 
/*      */         } else {
/* 1742 */           if (!isValidIdentifier(inDefinedShape1.getInternalName()))
/* 1743 */             throw new IllegalStateException("Illegal method name " + generic2 + " for " + inDefinedShape1); 
/* 1744 */           if (!((Boolean)generic2.accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Validator.METHOD_RETURN)).booleanValue())
/* 1745 */             throw new IllegalStateException("Illegal return type " + generic2 + " for " + inDefinedShape1); 
/* 1746 */           if (!((Boolean)generic2.accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE)).booleanValue())
/* 1747 */             throw new IllegalStateException("Illegal type annotations on return type " + generic2 + " for " + inDefinedShape1); 
/* 1748 */           if (!inDefinedShape1.isSynthetic() && !inDefinedShape1.getReturnType().asErasure().isVisibleTo(this))
/* 1749 */             throw new IllegalStateException("Invisible return type " + inDefinedShape1.getReturnType() + " for " + inDefinedShape1); 
/*      */         } 
/* 1751 */         HashSet<String> hashSet7 = new HashSet(); Iterator<ParameterDescription.InDefinedShape> iterator8;
/* 1752 */         for (iterator8 = inDefinedShape1.getParameters().iterator(); iterator8.hasNext(); ) {
/*      */           ParameterDescription.InDefinedShape inDefinedShape2; TypeDescription.Generic generic4;
/* 1754 */           if (!((Boolean)(generic4 = (inDefinedShape2 = iterator8.next()).getType()).accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Validator.METHOD_PARAMETER)).booleanValue())
/* 1755 */             throw new IllegalStateException("Illegal parameter type of " + inDefinedShape2 + " for " + inDefinedShape1); 
/* 1756 */           if (!((Boolean)generic4.accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE)).booleanValue())
/* 1757 */             throw new IllegalStateException("Illegal type annotations on parameter " + inDefinedShape2 + " for " + inDefinedShape1); 
/* 1758 */           if (!inDefinedShape1.isSynthetic() && !generic4.asErasure().isVisibleTo(this)) {
/* 1759 */             throw new IllegalStateException("Invisible parameter type of " + inDefinedShape2 + " for " + inDefinedShape1);
/*      */           }
/* 1761 */           if (inDefinedShape2.isNamed()) {
/* 1762 */             String str = inDefinedShape2.getName();
/* 1763 */             if (!hashSet7.add(str))
/* 1764 */               throw new IllegalStateException("Duplicate parameter name of " + inDefinedShape2 + " for " + inDefinedShape1); 
/* 1765 */             if (!isValidIdentifier(str)) {
/* 1766 */               throw new IllegalStateException("Illegal parameter name of " + inDefinedShape2 + " for " + inDefinedShape1);
/*      */             }
/*      */           } 
/* 1769 */           if (inDefinedShape2.hasModifiers() && (inDefinedShape2.getModifiers() & 0xFFFF6FEF) != 0) {
/* 1770 */             throw new IllegalStateException("Illegal modifiers of " + inDefinedShape2 + " for " + inDefinedShape1);
/*      */           }
/* 1772 */           HashSet<TypeDescription> hashSet9 = new HashSet();
/* 1773 */           for (Iterator<AnnotationDescription> iterator9 = inDefinedShape2.getDeclaredAnnotations().iterator(); iterator9.hasNext(); ) {
/* 1774 */             AnnotationDescription annotationDescription; if (!(annotationDescription = iterator9.next()).isSupportedOn(ElementType.PARAMETER))
/* 1775 */               throw new IllegalStateException("Cannot add " + annotationDescription + " on " + inDefinedShape2); 
/* 1776 */             if (!hashSet9.add(annotationDescription.getAnnotationType())) {
/* 1777 */               throw new IllegalStateException("Duplicate annotation " + annotationDescription + " of " + inDefinedShape2 + " for " + inDefinedShape1);
/*      */             }
/*      */           } 
/*      */         } 
/* 1781 */         for (iterator8 = inDefinedShape1.getExceptionTypes().iterator(); iterator8.hasNext(); ) {
/* 1782 */           TypeDescription.Generic generic4; if (!((Boolean)(generic4 = (TypeDescription.Generic)iterator8.next()).accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Validator.EXCEPTION)).booleanValue())
/* 1783 */             throw new IllegalStateException("Illegal exception type " + generic4 + " for " + inDefinedShape1); 
/* 1784 */           if (!((Boolean)generic4.accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE)).booleanValue())
/* 1785 */             throw new IllegalStateException("Illegal type annotations on " + generic4 + " for " + inDefinedShape1); 
/* 1786 */           if (!inDefinedShape1.isSynthetic() && !generic4.asErasure().isVisibleTo(this)) {
/* 1787 */             throw new IllegalStateException("Invisible exception type " + generic4 + " for " + inDefinedShape1);
/*      */           }
/*      */         } 
/* 1790 */         HashSet<TypeDescription> hashSet8 = new HashSet();
/* 1791 */         for (Iterator<AnnotationDescription> iterator7 = inDefinedShape1.getDeclaredAnnotations().iterator(); iterator7.hasNext(); ) {
/* 1792 */           AnnotationDescription annotationDescription; if (!(annotationDescription = iterator7.next()).isSupportedOn(inDefinedShape1.isMethod() ? ElementType.METHOD : ElementType.CONSTRUCTOR))
/* 1793 */             throw new IllegalStateException("Cannot add " + annotationDescription + " on " + inDefinedShape1); 
/* 1794 */           if (!hashSet8.add(annotationDescription.getAnnotationType())) {
/* 1795 */             throw new IllegalStateException("Duplicate annotation " + annotationDescription + " for " + inDefinedShape1);
/*      */           }
/*      */         } 
/*      */         AnnotationValue annotationValue;
/* 1799 */         if ((annotationValue = inDefinedShape1.getDefaultValue()) != null && !inDefinedShape1.isDefaultValue(annotationValue)) {
/* 1800 */           throw new IllegalStateException("Illegal default value " + annotationValue + "for " + inDefinedShape1);
/*      */         }
/*      */         TypeDescription.Generic generic3;
/* 1803 */         if ((generic3 = inDefinedShape1.getReceiverType()) != null && !((Boolean)generic3.accept((TypeDescription.Generic.Visitor)TypeDescription.Generic.Visitor.Validator.RECEIVER)).booleanValue())
/* 1804 */           throw new IllegalStateException("Illegal receiver type " + generic3 + " for " + inDefinedShape1); 
/* 1805 */         if (inDefinedShape1.isStatic()) {
/* 1806 */           if (generic3 != null)
/* 1807 */             throw new IllegalStateException("Static method " + inDefinedShape1 + " defines a non-null receiver " + generic3);  continue;
/*      */         } 
/* 1809 */         if (inDefinedShape1.isConstructor()) {
/* 1810 */           if (generic3 == null || !generic3.asErasure().equals((typeDescription1 == null) ? this : typeDescription1))
/* 1811 */             throw new IllegalStateException("Constructor " + inDefinedShape1 + " defines an illegal receiver " + generic3);  continue;
/*      */         } 
/* 1813 */         if (generic3 == null || !equals(generic3.asErasure())) {
/* 1814 */           throw new IllegalStateException("Method " + inDefinedShape1 + " defines an illegal receiver " + generic3);
/*      */         }
/*      */       } 
/* 1817 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static boolean isValidIdentifier(String[] param1ArrayOfString) {
/* 1827 */       if (param1ArrayOfString.length == 0)
/* 1828 */         return false;  int i;
/*      */       byte b;
/* 1830 */       for (i = (param1ArrayOfString = param1ArrayOfString).length, b = 0; b < i; b++) {
/* 1831 */         String str; if (!isValidIdentifier(str = param1ArrayOfString[b])) {
/* 1832 */           return false;
/*      */         }
/*      */       } 
/* 1835 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static boolean isValidIdentifier(String param1String) {
/* 1845 */       if (KEYWORDS.contains(param1String) || param1String.length() == 0 || !Character.isJavaIdentifierStart(param1String.charAt(0)))
/* 1846 */         return false; 
/* 1847 */       if (param1String.equals("package-info")) {
/* 1848 */         return true;
/*      */       }
/* 1850 */       for (byte b = 1; b < param1String.length(); b++) {
/* 1851 */         if (!Character.isJavaIdentifierPart(param1String.charAt(b))) {
/* 1852 */           return false;
/*      */         }
/*      */       } 
/* 1855 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Frozen
/*      */     extends TypeDescription.AbstractBase.OfSimpleType
/*      */     implements WithFlexibleName
/*      */   {
/*      */     private final TypeDescription typeDescription;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final LoadedTypeInitializer loadedTypeInitializer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Frozen(TypeDescription param1TypeDescription, LoadedTypeInitializer param1LoadedTypeInitializer) {
/* 1881 */       this.typeDescription = param1TypeDescription;
/* 1882 */       this.loadedTypeInitializer = param1LoadedTypeInitializer;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationList getDeclaredAnnotations() {
/* 1889 */       return this.typeDescription.getDeclaredAnnotations();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getModifiers() {
/* 1896 */       return this.typeDescription.getModifiers();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeList.Generic getTypeVariables() {
/* 1903 */       return this.typeDescription.getTypeVariables();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getName() {
/* 1910 */       return this.typeDescription.getName();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public TypeDescription.Generic getSuperClass() {
/* 1918 */       return this.typeDescription.getSuperClass();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeList.Generic getInterfaces() {
/* 1925 */       return this.typeDescription.getInterfaces();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
/* 1932 */       return this.typeDescription.getDeclaredFields();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
/* 1939 */       return this.typeDescription.getDeclaredMethods();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isAnonymousType() {
/* 1946 */       return this.typeDescription.isAnonymousType();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isLocalType() {
/* 1953 */       return this.typeDescription.isLocalType();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public PackageDescription getPackage() {
/* 1961 */       return this.typeDescription.getPackage();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public TypeDescription getEnclosingType() {
/* 1969 */       return this.typeDescription.getEnclosingType();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public TypeDescription getDeclaringType() {
/* 1977 */       return this.typeDescription.getDeclaringType();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeList getDeclaredTypes() {
/* 1984 */       return this.typeDescription.getDeclaredTypes();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public MethodDescription.InDefinedShape getEnclosingMethod() {
/* 1992 */       return this.typeDescription.getEnclosingMethod();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public String getGenericSignature() {
/* 2001 */       return this.typeDescription.getGenericSignature();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getActualModifiers(boolean param1Boolean) {
/* 2009 */       return this.typeDescription.getActualModifiers(param1Boolean);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription getNestHost() {
/* 2016 */       return this.typeDescription.getNestHost();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeList getNestMembers() {
/* 2023 */       return this.typeDescription.getNestMembers();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
/* 2030 */       return this.typeDescription.getRecordComponents();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isRecord() {
/* 2037 */       return this.typeDescription.isRecord();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSealed() {
/* 2042 */       return this.typeDescription.isSealed();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeList getPermittedSubtypes() {
/* 2049 */       return this.typeDescription.getPermittedSubtypes();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withField(FieldDescription.Token param1Token) {
/* 2056 */       throw new IllegalStateException("Cannot define field for frozen type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withAuxiliaryField(FieldDescription.Token param1Token, Object param1Object) {
/* 2063 */       throw new IllegalStateException("Cannot define auxiliary field for frozen type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withMethod(MethodDescription.Token param1Token) {
/* 2070 */       throw new IllegalStateException("Cannot define method for frozen type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withRecordComponent(RecordComponentDescription.Token param1Token) {
/* 2077 */       throw new IllegalStateException("Cannot define record component for frozen type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withModifiers(int param1Int) {
/* 2084 */       throw new IllegalStateException("Cannot change modifiers for frozen type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withInterfaces(TypeList.Generic param1Generic) {
/* 2091 */       throw new IllegalStateException("Cannot add interfaces for frozen type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withTypeVariable(TypeVariableToken param1TypeVariableToken) {
/* 2098 */       throw new IllegalStateException("Cannot define type variable for frozen type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withAnnotations(List<? extends AnnotationDescription> param1List) {
/* 2105 */       throw new IllegalStateException("Cannot add annotation to frozen type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withNestHost(TypeDescription param1TypeDescription) {
/* 2112 */       throw new IllegalStateException("Cannot set nest host of frozen type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withNestMembers(TypeList param1TypeList) {
/* 2119 */       throw new IllegalStateException("Cannot add nest members to frozen type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withEnclosingType(@MaybeNull TypeDescription param1TypeDescription) {
/* 2126 */       throw new IllegalStateException("Cannot set enclosing type of frozen type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withEnclosingMethod(MethodDescription.InDefinedShape param1InDefinedShape) {
/* 2133 */       throw new IllegalStateException("Cannot set enclosing method of frozen type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withDeclaringType(@MaybeNull TypeDescription param1TypeDescription) {
/* 2140 */       throw new IllegalStateException("Cannot add declaring type to frozen type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withDeclaredTypes(TypeList param1TypeList) {
/* 2147 */       throw new IllegalStateException("Cannot add declared types to frozen type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withPermittedSubclasses(@MaybeNull TypeList param1TypeList) {
/* 2154 */       throw new IllegalStateException("Cannot add permitted subclasses to frozen type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withLocalClass(boolean param1Boolean) {
/* 2161 */       throw new IllegalStateException("Cannot define local class state for frozen type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withAnonymousClass(boolean param1Boolean) {
/* 2168 */       throw new IllegalStateException("Cannot define anonymous class state for frozen type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withRecord(boolean param1Boolean) {
/* 2175 */       throw new IllegalStateException("Cannot define record state for frozen type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withInitializer(LoadedTypeInitializer param1LoadedTypeInitializer) {
/* 2182 */       return new Frozen(this.typeDescription, (LoadedTypeInitializer)new LoadedTypeInitializer.Compound(new LoadedTypeInitializer[] { this.loadedTypeInitializer, param1LoadedTypeInitializer }));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withInitializer(ByteCodeAppender param1ByteCodeAppender) {
/* 2189 */       throw new IllegalStateException("Cannot add initializer to frozen type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withName(String param1String) {
/* 2196 */       throw new IllegalStateException("Cannot change name of frozen type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public InstrumentedType.WithFlexibleName withTypeVariables(ElementMatcher<? super TypeDescription.Generic> param1ElementMatcher, Transformer<TypeVariableToken> param1Transformer) {
/* 2203 */       throw new IllegalStateException("Cannot add type variables of frozen type: " + this.typeDescription);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public LoadedTypeInitializer getLoadedTypeInitializer() {
/* 2210 */       return this.loadedTypeInitializer;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeInitializer getTypeInitializer() {
/* 2217 */       return TypeInitializer.None.INSTANCE;
/*      */     }
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public ClassFileVersion getClassFileVersion() {
/* 2223 */       return this.typeDescription.getClassFileVersion();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypeDescription validated() {
/* 2230 */       return this.typeDescription;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\scaffold\InstrumentedType.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */