/*      */ package io.github.classgraph;
/*      */ 
/*      */ import java.io.File;
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.annotation.Inherited;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.net.URI;
/*      */ import java.net.URL;
/*      */ import java.util.AbstractMap;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.EnumMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashSet;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import nonapi.io.github.classgraph.json.Id;
/*      */ import nonapi.io.github.classgraph.reflection.ReflectionUtils;
/*      */ import nonapi.io.github.classgraph.scanspec.ScanSpec;
/*      */ import nonapi.io.github.classgraph.types.ParseException;
/*      */ import nonapi.io.github.classgraph.types.Parser;
/*      */ import nonapi.io.github.classgraph.types.TypeUtils;
/*      */ import nonapi.io.github.classgraph.utils.Assert;
/*      */ import nonapi.io.github.classgraph.utils.LogNode;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ClassInfo
/*      */   extends ScanResultObject
/*      */   implements HasName, Comparable<ClassInfo>
/*      */ {
/*      */   @Id
/*      */   protected String name;
/*      */   private int modifiers;
/*      */   private boolean isRecord;
/*      */   boolean isInherited;
/*      */   private int classfileMinorVersion;
/*      */   private int classfileMajorVersion;
/*      */   protected String typeSignatureStr;
/*      */   private transient ClassTypeSignature typeSignature;
/*      */   private transient ClassTypeSignature typeDescriptor;
/*      */   private String sourceFile;
/*      */   private String fullyQualifiedDefiningMethodName;
/*      */   protected boolean isExternalClass = true;
/*      */   protected boolean isScannedClass;
/*      */   transient ClasspathElement classpathElement;
/*      */   protected transient Resource classfileResource;
/*      */   transient ClassLoader classLoader;
/*      */   ModuleInfo moduleInfo;
/*      */   PackageInfo packageInfo;
/*      */   AnnotationInfoList annotationInfo;
/*      */   FieldInfoList fieldInfo;
/*      */   MethodInfoList methodInfo;
/*      */   AnnotationParameterValueList annotationDefaultParamValues;
/*      */   transient List<Classfile.ClassTypeAnnotationDecorator> typeAnnotationDecorators;
/*      */   private Set<String> referencedClassNames;
/*      */   private ClassInfoList referencedClasses;
/*      */   transient boolean annotationDefaultParamValuesHasBeenConvertedToPrimitive;
/*      */   private Map<RelType, Set<ClassInfo>> relatedClasses;
/*      */   private transient List<ClassInfo> overrideOrder;
/*      */   private transient List<ClassInfo> methodOverrideOrder;
/*      */   private static final int ANNOTATION_CLASS_MODIFIER = 8192;
/*  188 */   private static final ReachableAndDirectlyRelatedClasses NO_REACHABLE_CLASSES = new ReachableAndDirectlyRelatedClasses(
/*  189 */       Collections.emptySet(), 
/*  190 */       Collections.emptySet());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ClassInfo(String paramString, int paramInt, Resource paramResource) {
/*  212 */     this.name = paramString;
/*  213 */     if (paramString.endsWith(";"))
/*      */     {
/*  215 */       throw new IllegalArgumentException("Bad class name");
/*      */     }
/*  217 */     setModifiers(paramInt);
/*  218 */     this.classfileResource = paramResource;
/*  219 */     this.relatedClasses = new EnumMap<>(RelType.class);
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
/*      */   enum RelType
/*      */   {
/*  235 */     SUPERCLASSES,
/*      */ 
/*      */     
/*  238 */     SUBCLASSES,
/*      */ 
/*      */     
/*  241 */     CONTAINS_INNER_CLASS,
/*      */ 
/*      */     
/*  244 */     CONTAINED_WITHIN_OUTER_CLASS,
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  255 */     IMPLEMENTED_INTERFACES,
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  260 */     CLASSES_IMPLEMENTING,
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  268 */     CLASS_ANNOTATIONS,
/*      */ 
/*      */     
/*  271 */     CLASSES_WITH_ANNOTATION,
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  276 */     METHOD_ANNOTATIONS,
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  281 */     CLASSES_WITH_METHOD_ANNOTATION,
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  287 */     CLASSES_WITH_NONPRIVATE_METHOD_ANNOTATION,
/*      */ 
/*      */     
/*  290 */     METHOD_PARAMETER_ANNOTATIONS,
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  296 */     CLASSES_WITH_METHOD_PARAMETER_ANNOTATION,
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  302 */     CLASSES_WITH_NONPRIVATE_METHOD_PARAMETER_ANNOTATION,
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  307 */     FIELD_ANNOTATIONS,
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  312 */     CLASSES_WITH_FIELD_ANNOTATION,
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  318 */     CLASSES_WITH_NONPRIVATE_FIELD_ANNOTATION;
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
/*      */   boolean addRelatedClass(RelType paramRelType, ClassInfo paramClassInfo) {
/*      */     Set<ClassInfo> set;
/*  332 */     if ((set = this.relatedClasses.get(paramRelType)) == null) {
/*  333 */       this.relatedClasses.put(paramRelType, set = new LinkedHashSet<>(4));
/*      */     }
/*  335 */     return set.add(paramClassInfo);
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
/*      */   static ClassInfo getOrCreateClassInfo(String paramString, Map<String, ClassInfo> paramMap) {
/*  353 */     byte b = 0;
/*  354 */     String str = paramString;
/*  355 */     while (str.endsWith("[]")) {
/*  356 */       b++;
/*  357 */       str = str.substring(0, str.length() - 2);
/*      */     } 
/*      */     
/*  360 */     while (str.startsWith("[")) {
/*  361 */       b++;
/*  362 */       str = str.substring(1);
/*      */     } 
/*  364 */     if (str.endsWith(";")) {
/*  365 */       str = str.substring(str.length() - 1);
/*      */     }
/*  367 */     str = str.replace('/', '.');
/*      */     
/*      */     ClassInfo classInfo;
/*  370 */     if ((classInfo = paramMap.get(paramString)) == null) {
/*  371 */       if (b == 0) {
/*  372 */         classInfo = new ClassInfo(str, 0, null);
/*      */       } else {
/*  374 */         ClassRefTypeSignature classRefTypeSignature; StringBuilder stringBuilder = new StringBuilder(); char c;
/*  375 */         for (c = Character.MIN_VALUE; c < b; c++) {
/*  376 */           stringBuilder.append('[');
/*      */         }
/*      */ 
/*      */         
/*  380 */         if ((c = BaseTypeSignature.getTypeChar(str)) != '\000') {
/*      */           
/*  382 */           stringBuilder.append(c);
/*  383 */           BaseTypeSignature baseTypeSignature = new BaseTypeSignature(c);
/*      */         } else {
/*      */           
/*  386 */           String str1 = "L" + str.replace('.', '/') + ";";
/*  387 */           stringBuilder.append(str1);
/*      */ 
/*      */ 
/*      */           
/*      */           try {
/*  392 */             if ((classRefTypeSignature = ClassRefTypeSignature.parse(new Parser(str1), null)) == null) {
/*  393 */               throw new IllegalArgumentException("Could not form array base type signature for class " + str);
/*      */             }
/*      */           }
/*  396 */           catch (ParseException parseException) {
/*  397 */             throw new IllegalArgumentException("Could not form array base type signature for class " + str);
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/*  402 */         classInfo = new ArrayClassInfo(new ArrayTypeSignature(classRefTypeSignature, b, stringBuilder.toString()));
/*      */       } 
/*  404 */       paramMap.put(paramString, classInfo);
/*      */     } 
/*  406 */     return classInfo;
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
/*      */   void setClassfileVersion(int paramInt1, int paramInt2) {
/*  418 */     this.classfileMinorVersion = paramInt1;
/*  419 */     this.classfileMajorVersion = paramInt2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setModifiers(int paramInt) {
/*  429 */     this.modifiers |= paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setIsInterface(boolean paramBoolean) {
/*  439 */     if (paramBoolean) {
/*  440 */       this.modifiers |= 0x200;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setIsAnnotation(boolean paramBoolean) {
/*  451 */     if (paramBoolean) {
/*  452 */       this.modifiers |= 0x2000;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setIsRecord(boolean paramBoolean) {
/*  463 */     if (paramBoolean) {
/*  464 */       this.isRecord = paramBoolean;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setSourceFile(String paramString) {
/*  475 */     this.sourceFile = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void addTypeDecorators(List<Classfile.ClassTypeAnnotationDecorator> paramList) {
/*  485 */     if (this.typeAnnotationDecorators == null) {
/*  486 */       this.typeAnnotationDecorators = new ArrayList<>();
/*      */     }
/*  488 */     this.typeAnnotationDecorators.addAll(paramList);
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
/*      */   void addSuperclass(String paramString, Map<String, ClassInfo> paramMap) {
/*  502 */     if (paramString != null && !paramString.equals("java.lang.Object")) {
/*  503 */       ClassInfo classInfo = getOrCreateClassInfo(paramString, paramMap);
/*  504 */       addRelatedClass(RelType.SUPERCLASSES, classInfo);
/*  505 */       classInfo.addRelatedClass(RelType.SUBCLASSES, this);
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
/*      */   void addImplementedInterface(String paramString, Map<String, ClassInfo> paramMap) {
/*      */     ClassInfo classInfo;
/*  519 */     (classInfo = getOrCreateClassInfo(paramString, paramMap)).setIsInterface(true);
/*  520 */     addRelatedClass(RelType.IMPLEMENTED_INTERFACES, classInfo);
/*  521 */     classInfo.addRelatedClass(RelType.CLASSES_IMPLEMENTING, this);
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
/*      */   static void addClassContainment(List<Classfile.ClassContainment> paramList, Map<String, ClassInfo> paramMap) {
/*  534 */     for (Iterator<Classfile.ClassContainment> iterator = paramList.iterator(); iterator.hasNext(); ) {
/*      */       Classfile.ClassContainment classContainment;
/*      */       ClassInfo classInfo2;
/*  537 */       (classInfo2 = getOrCreateClassInfo((classContainment = iterator.next()).innerClassName, paramMap)).setModifiers(classContainment.innerClassModifierBits);
/*  538 */       ClassInfo classInfo1 = getOrCreateClassInfo(classContainment.outerClassName, paramMap);
/*      */       
/*  540 */       classInfo2.addRelatedClass(RelType.CONTAINED_WITHIN_OUTER_CLASS, classInfo1);
/*  541 */       classInfo1.addRelatedClass(RelType.CONTAINS_INNER_CLASS, classInfo2);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void addFullyQualifiedDefiningMethodName(String paramString) {
/*  552 */     this.fullyQualifiedDefiningMethodName = paramString;
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
/*      */   void addClassAnnotation(AnnotationInfo paramAnnotationInfo, Map<String, ClassInfo> paramMap) {
/*      */     ClassInfo classInfo;
/*  567 */     (classInfo = getOrCreateClassInfo(paramAnnotationInfo.getName(), paramMap)).setModifiers(8192);
/*  568 */     if (this.annotationInfo == null) {
/*  569 */       this.annotationInfo = new AnnotationInfoList(2);
/*      */     }
/*  571 */     this.annotationInfo.add(paramAnnotationInfo);
/*      */     
/*  573 */     addRelatedClass(RelType.CLASS_ANNOTATIONS, classInfo);
/*  574 */     classInfo.addRelatedClass(RelType.CLASSES_WITH_ANNOTATION, this);
/*      */ 
/*      */     
/*  577 */     if (paramAnnotationInfo.getName().equals(Inherited.class.getName())) {
/*  578 */       this.isInherited = true;
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
/*      */   private void addFieldOrMethodAnnotationInfo(AnnotationInfoList paramAnnotationInfoList, boolean paramBoolean, int paramInt, Map<String, ClassInfo> paramMap) {
/*  596 */     if (paramAnnotationInfoList != null) {
/*  597 */       for (Iterator<AnnotationInfo> iterator = paramAnnotationInfoList.iterator(); iterator.hasNext(); ) {
/*      */         ClassInfo classInfo;
/*      */         AnnotationInfo annotationInfo;
/*  600 */         (classInfo = getOrCreateClassInfo((annotationInfo = iterator.next()).getName(), paramMap)).setModifiers(8192);
/*      */         
/*  602 */         addRelatedClass(paramBoolean ? RelType.FIELD_ANNOTATIONS : RelType.METHOD_ANNOTATIONS, classInfo);
/*      */         
/*  604 */         classInfo.addRelatedClass(paramBoolean ? RelType.CLASSES_WITH_FIELD_ANNOTATION : RelType.CLASSES_WITH_METHOD_ANNOTATION, this);
/*      */ 
/*      */ 
/*      */         
/*  608 */         if (!Modifier.isPrivate(paramInt)) {
/*  609 */           classInfo.addRelatedClass(paramBoolean ? RelType.CLASSES_WITH_NONPRIVATE_FIELD_ANNOTATION : RelType.CLASSES_WITH_NONPRIVATE_METHOD_ANNOTATION, this);
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
/*      */ 
/*      */   
/*      */   void addFieldInfo(FieldInfoList paramFieldInfoList, Map<String, ClassInfo> paramMap) {
/*  625 */     for (FieldInfo fieldInfo : paramFieldInfoList)
/*      */     {
/*  627 */       addFieldOrMethodAnnotationInfo(fieldInfo.annotationInfo, true, fieldInfo.getModifiers(), paramMap);
/*      */     }
/*      */     
/*  630 */     if (this.fieldInfo == null) {
/*  631 */       this.fieldInfo = paramFieldInfoList; return;
/*      */     } 
/*  633 */     this.fieldInfo.addAll(paramFieldInfoList);
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
/*      */   void addMethodInfo(MethodInfoList paramMethodInfoList, Map<String, ClassInfo> paramMap) {
/*  646 */     for (MethodInfo methodInfo : paramMethodInfoList) {
/*      */       
/*  648 */       addFieldOrMethodAnnotationInfo(methodInfo.annotationInfo, false, methodInfo.getModifiers(), paramMap);
/*      */ 
/*      */ 
/*      */       
/*  652 */       if (methodInfo.parameterAnnotationInfo != null) {
/*  653 */         for (byte b = 0; b < methodInfo.parameterAnnotationInfo.length; b++) {
/*      */           AnnotationInfo[] arrayOfAnnotationInfo;
/*  655 */           if ((arrayOfAnnotationInfo = methodInfo.parameterAnnotationInfo[b]) != null) {
/*  656 */             int i; byte b1; for (i = (arrayOfAnnotationInfo = arrayOfAnnotationInfo).length, b1 = 0; b1 < i; b1++) {
/*      */               ClassInfo classInfo;
/*      */               AnnotationInfo annotationInfo;
/*  659 */               (classInfo = getOrCreateClassInfo((annotationInfo = arrayOfAnnotationInfo[b1]).getName(), paramMap)).setModifiers(8192);
/*  660 */               addRelatedClass(RelType.METHOD_PARAMETER_ANNOTATIONS, classInfo);
/*  661 */               classInfo.addRelatedClass(RelType.CLASSES_WITH_METHOD_PARAMETER_ANNOTATION, this);
/*      */ 
/*      */               
/*  664 */               if (!Modifier.isPrivate(methodInfo.getModifiers())) {
/*  665 */                 classInfo.addRelatedClass(RelType.CLASSES_WITH_NONPRIVATE_METHOD_PARAMETER_ANNOTATION, this);
/*      */               }
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/*  673 */     if (this.methodInfo == null) {
/*  674 */       this.methodInfo = paramMethodInfoList; return;
/*      */     } 
/*  676 */     this.methodInfo.addAll(paramMethodInfoList);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setTypeSignature(String paramString) {
/*  687 */     this.typeSignatureStr = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void addAnnotationParamDefaultValues(AnnotationParameterValueList paramAnnotationParameterValueList) {
/*  698 */     setIsAnnotation(true);
/*  699 */     if (this.annotationDefaultParamValues == null) {
/*  700 */       this.annotationDefaultParamValues = paramAnnotationParameterValueList; return;
/*      */     } 
/*  702 */     this.annotationDefaultParamValues.addAll(paramAnnotationParameterValueList);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static ClassInfo addScannedClass(String paramString, int paramInt, boolean paramBoolean, Map<String, ClassInfo> paramMap, ClasspathElement paramClasspathElement, Resource paramResource) {
/*      */     ClassInfo classInfo;
/*  730 */     if ((classInfo = paramMap.get(paramString)) == null) {
/*      */       
/*  732 */       paramMap.put(paramString, classInfo = new ClassInfo(paramString, paramInt, paramResource));
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */       
/*  738 */       if (classInfo.isScannedClass)
/*      */       {
/*  740 */         throw new IllegalArgumentException("Class " + paramString + " should not have been encountered more than once due to classpath masking -- please report this bug at: https://github.com/classgraph/classgraph/issues");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  746 */       classInfo.classfileResource = paramResource;
/*      */ 
/*      */       
/*  749 */       classInfo.modifiers |= paramInt;
/*      */     } 
/*      */ 
/*      */     
/*  753 */     classInfo.isScannedClass = true;
/*      */ 
/*      */     
/*  756 */     classInfo.isExternalClass = paramBoolean;
/*      */ 
/*      */     
/*  759 */     classInfo.classpathElement = paramClasspathElement;
/*      */ 
/*      */     
/*  762 */     classInfo.classLoader = paramClasspathElement.getClassLoader();
/*      */     
/*  764 */     return classInfo;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private enum ClassType
/*      */   {
/*  772 */     ALL,
/*      */     
/*  774 */     STANDARD_CLASS,
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  779 */     IMPLEMENTED_INTERFACE,
/*      */     
/*  781 */     ANNOTATION,
/*      */     
/*  783 */     INTERFACE_OR_ANNOTATION,
/*      */     
/*  785 */     ENUM,
/*      */     
/*  787 */     RECORD;
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
/*      */   private static Set<ClassInfo> filterClassInfo(Collection<ClassInfo> paramCollection, ScanSpec paramScanSpec, boolean paramBoolean, ClassType... paramVarArgs) {
/*  805 */     if (paramCollection == null) {
/*  806 */       return Collections.emptySet();
/*      */     }
/*  808 */     boolean bool1 = (paramVarArgs.length == 0) ? true : false;
/*  809 */     boolean bool2 = false;
/*  810 */     boolean bool3 = false;
/*  811 */     boolean bool4 = false;
/*  812 */     boolean bool5 = false;
/*  813 */     boolean bool6 = false; int i; byte b;
/*  814 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { ClassType classType = paramVarArgs[b];
/*  815 */       switch (classType) {
/*      */         case ALL:
/*  817 */           bool1 = true;
/*      */           break;
/*      */         case STANDARD_CLASS:
/*  820 */           bool2 = true;
/*      */           break;
/*      */         case IMPLEMENTED_INTERFACE:
/*  823 */           bool3 = true;
/*      */           break;
/*      */         case ANNOTATION:
/*  826 */           bool4 = true;
/*      */           break;
/*      */         case INTERFACE_OR_ANNOTATION:
/*  829 */           bool3 = bool4 = true;
/*      */           break;
/*      */         case ENUM:
/*  832 */           bool5 = true;
/*      */           break;
/*      */         case RECORD:
/*  835 */           bool6 = true;
/*      */           break;
/*      */         default:
/*  838 */           throw new IllegalArgumentException("Unknown ClassType: " + classType);
/*      */       }  b++; }
/*      */     
/*  841 */     if (bool2 && bool3 && bool4) {
/*  842 */       bool1 = true;
/*      */     }
/*  844 */     LinkedHashSet<ClassInfo> linkedHashSet = new LinkedHashSet(paramCollection.size());
/*  845 */     for (ClassInfo classInfo : paramCollection) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  852 */       boolean bool8 = (bool1 || (bool2 && classInfo.isStandardClass()) || (bool3 && classInfo.isImplementedInterface()) || (bool4 && classInfo.isAnnotation()) || (bool5 && classInfo.isEnum()) || (bool6 && classInfo.isRecord())) ? true : false;
/*      */       
/*  854 */       boolean bool7 = (!classInfo.isExternalClass || paramScanSpec.enableExternalClasses || !paramBoolean) ? true : false;
/*      */ 
/*      */       
/*  857 */       if (bool8 && bool7 && !paramScanSpec.classOrPackageIsRejected(classInfo.name))
/*      */       {
/*  859 */         linkedHashSet.add(classInfo);
/*      */       }
/*      */     } 
/*  862 */     return linkedHashSet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class ReachableAndDirectlyRelatedClasses
/*      */   {
/*      */     final Set<ClassInfo> reachableClasses;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final Set<ClassInfo> directlyRelatedClasses;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private ReachableAndDirectlyRelatedClasses(Set<ClassInfo> param1Set1, Set<ClassInfo> param1Set2) {
/*  887 */       this.reachableClasses = param1Set1;
/*  888 */       this.directlyRelatedClasses = param1Set2;
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
/*      */   private ReachableAndDirectlyRelatedClasses filterClassInfo(RelType paramRelType, boolean paramBoolean, ClassType... paramVarArgs) {
/*      */     Set<?> set;
/*  907 */     if ((set = this.relatedClasses.get(paramRelType)) == null) {
/*  908 */       return NO_REACHABLE_CLASSES;
/*      */     }
/*      */     
/*  911 */     set = new LinkedHashSet(set);
/*      */     
/*  913 */     LinkedHashSet<ClassInfo> linkedHashSet = new LinkedHashSet(set);
/*  914 */     if (paramRelType == RelType.METHOD_ANNOTATIONS || paramRelType == RelType.METHOD_PARAMETER_ANNOTATIONS || paramRelType == RelType.FIELD_ANNOTATIONS) {
/*      */ 
/*      */       
/*  917 */       for (ClassInfo classInfo : set) {
/*  918 */         linkedHashSet.addAll(
/*  919 */             (classInfo.filterClassInfo(RelType.CLASS_ANNOTATIONS, paramBoolean, new ClassType[0])).reachableClasses);
/*      */       }
/*  921 */     } else if (paramRelType == RelType.CLASSES_WITH_METHOD_ANNOTATION || paramRelType == RelType.CLASSES_WITH_NONPRIVATE_METHOD_ANNOTATION || paramRelType == RelType.CLASSES_WITH_METHOD_PARAMETER_ANNOTATION || paramRelType == RelType.CLASSES_WITH_NONPRIVATE_METHOD_PARAMETER_ANNOTATION || paramRelType == RelType.CLASSES_WITH_FIELD_ANNOTATION || paramRelType == RelType.CLASSES_WITH_NONPRIVATE_FIELD_ANNOTATION) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  929 */       for (Iterator<ClassInfo> iterator = (filterClassInfo(RelType.CLASSES_WITH_ANNOTATION, paramBoolean, new ClassType[] { ClassType.ANNOTATION })).reachableClasses.iterator(); iterator.hasNext();)
/*      */       {
/*      */         
/*  932 */         if ((set1 = (classInfo = iterator.next()).relatedClasses.get(paramRelType)) != null) {
/*  933 */           linkedHashSet.addAll(set1);
/*      */         }
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/*  939 */       LinkedList<ClassInfo> linkedList = new LinkedList(set);
/*  940 */       while (!linkedList.isEmpty()) {
/*      */         ClassInfo classInfo;
/*      */         Set set1;
/*  943 */         if ((set1 = (classInfo = linkedList.removeFirst()).relatedClasses.get(paramRelType)) != null) {
/*  944 */           for (ClassInfo classInfo1 : set1) {
/*      */             
/*  946 */             if (linkedHashSet.add(classInfo1)) {
/*  947 */               linkedList.add(classInfo1);
/*      */             }
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*  953 */     if (linkedHashSet.isEmpty()) {
/*  954 */       return NO_REACHABLE_CLASSES;
/*      */     }
/*      */     
/*  957 */     if (paramRelType == RelType.CLASS_ANNOTATIONS || paramRelType == RelType.METHOD_ANNOTATIONS || paramRelType == RelType.METHOD_PARAMETER_ANNOTATIONS || paramRelType == RelType.FIELD_ANNOTATIONS) {
/*      */ 
/*      */ 
/*      */       
/*  961 */       LinkedHashSet<ClassInfo> linkedHashSet1 = null;
/*  962 */       for (Iterator<ClassInfo> iterator = linkedHashSet.iterator(); iterator.hasNext();) {
/*      */         
/*  964 */         if ((classInfo = iterator.next()).getName().startsWith("java.lang.annotation.") && 
/*  965 */           !set.contains(classInfo)) {
/*  966 */           if (linkedHashSet1 == null) {
/*  967 */             linkedHashSet1 = new LinkedHashSet();
/*      */           }
/*  969 */           linkedHashSet1.add(classInfo);
/*      */         } 
/*      */       } 
/*  972 */       if (linkedHashSet1 != null) {
/*  973 */         linkedHashSet.removeAll(linkedHashSet1);
/*      */       }
/*      */     } 
/*      */     
/*  977 */     return new ReachableAndDirectlyRelatedClasses(
/*  978 */         filterClassInfo(linkedHashSet, this.scanResult.scanSpec, paramBoolean, paramVarArgs), 
/*  979 */         filterClassInfo((Collection)set, this.scanResult.scanSpec, paramBoolean, paramVarArgs));
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
/*      */   static ClassInfoList getAllClasses(Collection<ClassInfo> paramCollection, ScanSpec paramScanSpec) {
/*  995 */     return new ClassInfoList(
/*  996 */         filterClassInfo(paramCollection, paramScanSpec, true, new ClassType[] { ClassType.ALL }), true);
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
/*      */   static ClassInfoList getAllEnums(Collection<ClassInfo> paramCollection, ScanSpec paramScanSpec) {
/* 1010 */     return new ClassInfoList(
/* 1011 */         filterClassInfo(paramCollection, paramScanSpec, true, new ClassType[] { ClassType.ENUM }), true);
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
/*      */   static ClassInfoList getAllRecords(Collection<ClassInfo> paramCollection, ScanSpec paramScanSpec) {
/* 1025 */     return new ClassInfoList(
/* 1026 */         filterClassInfo(paramCollection, paramScanSpec, true, new ClassType[] { ClassType.RECORD }), true);
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
/*      */   static ClassInfoList getAllStandardClasses(Collection<ClassInfo> paramCollection, ScanSpec paramScanSpec) {
/* 1040 */     return new ClassInfoList(
/* 1041 */         filterClassInfo(paramCollection, paramScanSpec, true, new ClassType[] { ClassType.STANDARD_CLASS }), true);
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
/*      */   static ClassInfoList getAllImplementedInterfaceClasses(Collection<ClassInfo> paramCollection, ScanSpec paramScanSpec) {
/* 1056 */     return new ClassInfoList(filterClassInfo(paramCollection, paramScanSpec, true, new ClassType[] { ClassType.IMPLEMENTED_INTERFACE }), true);
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
/*      */   static ClassInfoList getAllAnnotationClasses(Collection<ClassInfo> paramCollection, ScanSpec paramScanSpec) {
/* 1071 */     return new ClassInfoList(
/* 1072 */         filterClassInfo(paramCollection, paramScanSpec, true, new ClassType[] { ClassType.ANNOTATION }), true);
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
/*      */   static ClassInfoList getAllInterfacesOrAnnotationClasses(Collection<ClassInfo> paramCollection, ScanSpec paramScanSpec) {
/* 1088 */     return new ClassInfoList(filterClassInfo(paramCollection, paramScanSpec, true, new ClassType[] { ClassType.INTERFACE_OR_ANNOTATION }), true);
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
/*      */   public String getName() {
/* 1102 */     return this.name;
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
/*      */   static String getSimpleName(String paramString) {
/* 1115 */     return paramString.substring(Math.max(paramString.lastIndexOf('.'), paramString.lastIndexOf('$')) + 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSimpleName() {
/* 1126 */     return getSimpleName(this.name);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ModuleInfo getModuleInfo() {
/* 1135 */     return this.moduleInfo;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PackageInfo getPackageInfo() {
/* 1144 */     return this.packageInfo;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPackageName() {
/* 1153 */     return PackageInfo.getParentPackageName(this.name);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isExternalClass() {
/* 1163 */     return this.isExternalClass;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getClassfileMinorVersion() {
/* 1173 */     return this.classfileMinorVersion;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getClassfileMajorVersion() {
/* 1183 */     return this.classfileMajorVersion;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getModifiers() {
/* 1192 */     return this.modifiers;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getModifiersStr() {
/* 1202 */     StringBuilder stringBuilder = new StringBuilder();
/* 1203 */     TypeUtils.modifiersToString(this.modifiers, TypeUtils.ModifierType.CLASS, false, stringBuilder);
/* 1204 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPublic() {
/* 1213 */     return Modifier.isPublic(this.modifiers);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPrivate() {
/* 1222 */     return Modifier.isPrivate(this.modifiers);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isProtected() {
/* 1231 */     return Modifier.isProtected(this.modifiers);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPackageVisible() {
/* 1240 */     return (!isPublic() && !isPrivate() && !isProtected());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAbstract() {
/* 1249 */     return Modifier.isAbstract(this.modifiers);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSynthetic() {
/* 1258 */     return ((this.modifiers & 0x1000) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isFinal() {
/* 1267 */     return Modifier.isFinal(this.modifiers);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isStatic() {
/* 1276 */     return Modifier.isStatic(this.modifiers);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAnnotation() {
/* 1285 */     return ((this.modifiers & 0x2000) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isInterface() {
/* 1295 */     return (isInterfaceOrAnnotation() && !isAnnotation());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isInterfaceOrAnnotation() {
/* 1305 */     return ((this.modifiers & 0x200) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEnum() {
/* 1314 */     return ((this.modifiers & 0x4000) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isRecord() {
/* 1323 */     return this.isRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isStandardClass() {
/* 1332 */     return (!isAnnotation() && !isInterface());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isArrayClass() {
/* 1342 */     return this instanceof ArrayClassInfo;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean extendsSuperclass(Class<?> paramClass) {
/* 1353 */     return extendsSuperclass(paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean extendsSuperclass(String paramString) {
/* 1364 */     if ((paramString.equals("java.lang.Object") && isStandardClass()) || 
/* 1365 */       getSuperclasses().containsName(paramString)) return true;
/*      */     
/*      */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isInnerClass() {
/* 1375 */     return !getOuterClasses().isEmpty();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isOuterClass() {
/* 1385 */     return !getInnerClasses().isEmpty();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAnonymousInnerClass() {
/* 1395 */     return (this.fullyQualifiedDefiningMethodName != null);
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
/*      */   public boolean isImplementedInterface() {
/* 1410 */     return (this.relatedClasses.get(RelType.CLASSES_IMPLEMENTING) != null || isInterface());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean implementsInterface(Class<?> paramClass) {
/* 1421 */     Assert.isInterface(paramClass);
/* 1422 */     return implementsInterface(paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean implementsInterface(String paramString) {
/* 1433 */     return getInterfaces().containsName(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasAnnotation(Class<? extends Annotation> paramClass) {
/* 1444 */     Assert.isAnnotation(paramClass);
/* 1445 */     return hasAnnotation(paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasAnnotation(String paramString) {
/* 1456 */     return getAnnotations().containsName(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasDeclaredField(String paramString) {
/* 1467 */     return getDeclaredFieldInfo().containsName(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasField(String paramString) {
/* 1478 */     for (Iterator<ClassInfo> iterator = getFieldOverrideOrder().iterator(); iterator.hasNext();) {
/* 1479 */       if ((classInfo = iterator.next()).hasDeclaredField(paramString)) {
/* 1480 */         return true;
/*      */       }
/*      */     } 
/* 1483 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasDeclaredFieldAnnotation(Class<? extends Annotation> paramClass) {
/* 1494 */     Assert.isAnnotation(paramClass);
/* 1495 */     return hasDeclaredFieldAnnotation(paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasDeclaredFieldAnnotation(String paramString) {
/* 1506 */     for (Iterator<FieldInfo> iterator = getDeclaredFieldInfo().iterator(); iterator.hasNext();) {
/* 1507 */       if ((fieldInfo = iterator.next()).hasAnnotation(paramString)) {
/* 1508 */         return true;
/*      */       }
/*      */     } 
/* 1511 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasFieldAnnotation(Class<? extends Annotation> paramClass) {
/* 1522 */     Assert.isAnnotation(paramClass);
/* 1523 */     return hasFieldAnnotation(paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasFieldAnnotation(String paramString) {
/* 1534 */     for (Iterator<ClassInfo> iterator = getFieldOverrideOrder().iterator(); iterator.hasNext();) {
/* 1535 */       if ((classInfo = iterator.next()).hasDeclaredFieldAnnotation(paramString)) {
/* 1536 */         return true;
/*      */       }
/*      */     } 
/* 1539 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasDeclaredMethod(String paramString) {
/* 1550 */     return getDeclaredMethodInfo().containsName(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasMethod(String paramString) {
/* 1561 */     for (Iterator<ClassInfo> iterator = getMethodOverrideOrder().iterator(); iterator.hasNext();) {
/* 1562 */       if ((classInfo = iterator.next()).hasDeclaredMethod(paramString)) {
/* 1563 */         return true;
/*      */       }
/*      */     } 
/* 1566 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasDeclaredMethodAnnotation(Class<? extends Annotation> paramClass) {
/* 1577 */     Assert.isAnnotation(paramClass);
/* 1578 */     return hasDeclaredMethodAnnotation(paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasDeclaredMethodAnnotation(String paramString) {
/* 1589 */     for (Iterator<MethodInfo> iterator = getDeclaredMethodInfo().iterator(); iterator.hasNext();) {
/* 1590 */       if ((methodInfo = iterator.next()).hasAnnotation(paramString)) {
/* 1591 */         return true;
/*      */       }
/*      */     } 
/* 1594 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasMethodAnnotation(Class<? extends Annotation> paramClass) {
/* 1605 */     Assert.isAnnotation(paramClass);
/* 1606 */     return hasMethodAnnotation(paramClass.getName());
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
/*      */   public boolean hasMethodAnnotation(String paramString) {
/* 1619 */     for (Iterator<ClassInfo> iterator = getMethodOverrideOrder().iterator(); iterator.hasNext();) {
/* 1620 */       if ((classInfo = iterator.next()).hasDeclaredMethodAnnotation(paramString)) {
/* 1621 */         return true;
/*      */       }
/*      */     } 
/* 1624 */     return false;
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
/*      */   public boolean hasDeclaredMethodParameterAnnotation(Class<? extends Annotation> paramClass) {
/* 1636 */     Assert.isAnnotation(paramClass);
/* 1637 */     return hasDeclaredMethodParameterAnnotation(paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasDeclaredMethodParameterAnnotation(String paramString) {
/* 1648 */     for (Iterator<MethodInfo> iterator = getDeclaredMethodInfo().iterator(); iterator.hasNext();) {
/* 1649 */       if ((methodInfo = iterator.next()).hasParameterAnnotation(paramString)) {
/* 1650 */         return true;
/*      */       }
/*      */     } 
/* 1653 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasMethodParameterAnnotation(Class<? extends Annotation> paramClass) {
/* 1664 */     Assert.isAnnotation(paramClass);
/* 1665 */     return hasMethodParameterAnnotation(paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasMethodParameterAnnotation(String paramString) {
/* 1676 */     for (Iterator<ClassInfo> iterator = getMethodOverrideOrder().iterator(); iterator.hasNext();) {
/* 1677 */       if ((classInfo = iterator.next()).hasDeclaredMethodParameterAnnotation(paramString)) {
/* 1678 */         return true;
/*      */       }
/*      */     } 
/* 1681 */     return false;
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
/*      */   private List<ClassInfo> getFieldOverrideOrder(Set<ClassInfo> paramSet, List<ClassInfo> paramList) {
/* 1697 */     if (paramSet.add(this)) {
/* 1698 */       paramList.add(this);
/* 1699 */       for (Iterator<ClassInfo> iterator = getInterfaces().iterator(); iterator.hasNext();) {
/* 1700 */         (classInfo1 = iterator.next()).getFieldOverrideOrder(paramSet, paramList);
/*      */       }
/*      */       ClassInfo classInfo;
/* 1703 */       if ((classInfo = getSuperclass()) != null) {
/* 1704 */         classInfo.getFieldOverrideOrder(paramSet, paramList);
/*      */       }
/*      */     } 
/* 1707 */     return paramList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private List<ClassInfo> getFieldOverrideOrder() {
/* 1716 */     if (this.overrideOrder == null) {
/* 1717 */       this.overrideOrder = getFieldOverrideOrder(new HashSet<>(), new ArrayList<>());
/*      */     }
/* 1719 */     return this.overrideOrder;
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
/*      */   private List<ClassInfo> getMethodOverrideOrder(Set<ClassInfo> paramSet, List<ClassInfo> paramList) {
/* 1739 */     if (!paramSet.add(this)) {
/* 1740 */       return paramList;
/*      */     }
/*      */     
/* 1743 */     if (!isInterfaceOrAnnotation()) {
/* 1744 */       paramList.add(this);
/*      */       
/*      */       ClassInfo classInfo;
/* 1747 */       if ((classInfo = getSuperclass()) != null) {
/* 1748 */         classInfo.getMethodOverrideOrder(paramSet, paramList);
/*      */       }
/* 1750 */       for (Iterator<ClassInfo> iterator1 = getInterfaces().iterator(); iterator1.hasNext();) {
/* 1751 */         (classInfo1 = iterator1.next()).getMethodOverrideOrder(paramSet, paramList);
/*      */       }
/* 1753 */       return paramList;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1762 */     ClassInfoList classInfoList = getInterfaces();
/* 1763 */     int i = Integer.MAX_VALUE;
/* 1764 */     for (ClassInfo classInfo : classInfoList) {
/* 1765 */       if (paramSet.contains(classInfo)) {
/*      */         int j;
/*      */ 
/*      */         
/* 1769 */         i = ((j = paramList.indexOf(classInfo)) >= 0 && j < i) ? j : i;
/*      */       } 
/* 1771 */     }  if (i == Integer.MAX_VALUE) {
/* 1772 */       paramList.add(this);
/*      */     } else {
/* 1774 */       paramList.add(i, this);
/*      */     } 
/*      */     
/* 1777 */     for (Iterator<ClassInfo> iterator = classInfoList.iterator(); iterator.hasNext();) {
/* 1778 */       (classInfo = iterator.next()).getMethodOverrideOrder(paramSet, paramList);
/*      */     }
/* 1780 */     return paramList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private List<ClassInfo> getMethodOverrideOrder() {
/* 1789 */     if (this.methodOverrideOrder == null) {
/* 1790 */       this.methodOverrideOrder = getMethodOverrideOrder(new HashSet<>(), new ArrayList<>());
/*      */     }
/* 1792 */     return this.methodOverrideOrder;
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
/*      */   public ClassInfoList getSubclasses() {
/* 1808 */     if (getName().equals("java.lang.Object"))
/*      */     {
/* 1810 */       return this.scanResult.getAllStandardClasses();
/*      */     }
/* 1812 */     return new ClassInfoList(
/* 1813 */         filterClassInfo(RelType.SUBCLASSES, !this.isExternalClass, new ClassType[0]), true);
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
/*      */   public ClassInfoList getSuperclasses() {
/* 1828 */     return new ClassInfoList(filterClassInfo(RelType.SUPERCLASSES, false, new ClassType[0]), false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassInfo getSuperclass() {
/*      */     Set<ClassInfo> set;
/* 1840 */     if ((set = this.relatedClasses.get(RelType.SUPERCLASSES)) == null || set.isEmpty())
/* 1841 */       return null; 
/* 1842 */     if (set.size() > 2) {
/* 1843 */       throw new IllegalArgumentException("More than one superclass: " + set);
/*      */     }
/*      */     ClassInfo classInfo;
/* 1846 */     if ((classInfo = set.iterator().next()).getName().equals("java.lang.Object")) {
/* 1847 */       return null;
/*      */     }
/* 1849 */     return classInfo;
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
/*      */   public ClassInfoList getOuterClasses() {
/* 1862 */     return new ClassInfoList(
/* 1863 */         filterClassInfo(RelType.CONTAINED_WITHIN_OUTER_CLASS, false, new ClassType[0]), false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassInfoList getInnerClasses() {
/* 1873 */     return new ClassInfoList(filterClassInfo(RelType.CONTAINS_INNER_CLASS, false, new ClassType[0]), true);
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
/*      */   public String getFullyQualifiedDefiningMethodName() {
/* 1885 */     return this.fullyQualifiedDefiningMethodName;
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
/*      */   public ClassInfoList getInterfaces() {
/* 1902 */     ReachableAndDirectlyRelatedClasses reachableAndDirectlyRelatedClasses = filterClassInfo(RelType.IMPLEMENTED_INTERFACES, false, new ClassType[0]);
/* 1903 */     LinkedHashSet<ClassInfo> linkedHashSet = new LinkedHashSet<>(reachableAndDirectlyRelatedClasses.reachableClasses);
/* 1904 */     for (Iterator<ClassInfo> iterator = (filterClassInfo(RelType.SUPERCLASSES, false, new ClassType[0])).reachableClasses.iterator(); iterator.hasNext(); ) {
/*      */       ClassInfo classInfo;
/*      */       
/* 1907 */       Set<ClassInfo> set = ((classInfo = iterator.next()).filterClassInfo(RelType.IMPLEMENTED_INTERFACES, false, new ClassType[0])).reachableClasses;
/* 1908 */       linkedHashSet.addAll(set);
/*      */     } 
/*      */     
/* 1911 */     return new ClassInfoList(linkedHashSet, reachableAndDirectlyRelatedClasses.directlyRelatedClasses, false);
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
/*      */   public ClassInfoList getClassesImplementing() {
/* 1924 */     ReachableAndDirectlyRelatedClasses reachableAndDirectlyRelatedClasses = filterClassInfo(RelType.CLASSES_IMPLEMENTING, !this.isExternalClass, new ClassType[0]);
/* 1925 */     LinkedHashSet<ClassInfo> linkedHashSet = new LinkedHashSet<>(reachableAndDirectlyRelatedClasses.reachableClasses);
/* 1926 */     for (Iterator<ClassInfo> iterator = reachableAndDirectlyRelatedClasses.reachableClasses.iterator(); iterator.hasNext(); ) {
/* 1927 */       ClassInfo classInfo; Set<ClassInfo> set = ((classInfo = iterator.next()).filterClassInfo(RelType.SUBCLASSES, !classInfo.isExternalClass, new ClassType[0])).reachableClasses;
/*      */       
/* 1929 */       linkedHashSet.addAll(set);
/*      */     } 
/* 1931 */     return new ClassInfoList(linkedHashSet, reachableAndDirectlyRelatedClasses.directlyRelatedClasses, true);
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
/*      */   
/*      */   public ClassInfoList getAnnotations() {
/* 1952 */     if (!this.scanResult.scanSpec.enableAnnotationInfo) {
/* 1953 */       throw new IllegalArgumentException("Please call ClassGraph#enableAnnotationInfo() before #scan()");
/*      */     }
/*      */ 
/*      */     
/* 1957 */     ReachableAndDirectlyRelatedClasses reachableAndDirectlyRelatedClasses = filterClassInfo(RelType.CLASS_ANNOTATIONS, false, new ClassType[0]);
/*      */ 
/*      */     
/* 1960 */     LinkedHashSet<ClassInfo> linkedHashSet = null;
/* 1961 */     for (Iterator<ClassInfo> iterator = getSuperclasses().iterator(); iterator.hasNext();) {
/* 1962 */       for (Iterator<ClassInfo> iterator1 = ((classInfo = iterator.next()).filterClassInfo(RelType.CLASS_ANNOTATIONS, false, new ClassType[0])).reachableClasses.iterator(); iterator1.hasNext();) {
/*      */ 
/*      */ 
/*      */         
/* 1966 */         if ((classInfo1 = iterator1.next()) != null && classInfo1.isInherited) {
/*      */           
/* 1968 */           if (linkedHashSet == null) {
/* 1969 */             linkedHashSet = new LinkedHashSet();
/*      */           }
/* 1971 */           linkedHashSet.add(classInfo1);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1976 */     if (linkedHashSet == null)
/*      */     {
/* 1978 */       return new ClassInfoList(reachableAndDirectlyRelatedClasses, true);
/*      */     }
/*      */     
/* 1981 */     linkedHashSet.addAll(reachableAndDirectlyRelatedClasses.reachableClasses);
/* 1982 */     return new ClassInfoList(linkedHashSet, reachableAndDirectlyRelatedClasses.directlyRelatedClasses, true);
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
/*      */   private ClassInfoList getFieldOrMethodAnnotations(RelType paramRelType) {
/*      */     boolean bool;
/* 2000 */     if (((bool = (paramRelType == RelType.FIELD_ANNOTATIONS) ? true : false) ? this.scanResult.scanSpec.enableFieldInfo : this.scanResult.scanSpec.enableMethodInfo) || !this.scanResult.scanSpec.enableAnnotationInfo)
/*      */     {
/* 2002 */       throw new IllegalArgumentException("Please call ClassGraph#enable" + (bool ? "Field" : "Method") + "Info() and #enableAnnotationInfo() before #scan()");
/*      */     }
/*      */     
/* 2005 */     ReachableAndDirectlyRelatedClasses reachableAndDirectlyRelatedClasses = filterClassInfo(paramRelType, false, new ClassType[] { ClassType.ANNOTATION });
/*      */     
/* 2007 */     LinkedHashSet<ClassInfo> linkedHashSet = new LinkedHashSet<>(reachableAndDirectlyRelatedClasses.reachableClasses);
/*      */     
/* 2009 */     return new ClassInfoList(linkedHashSet, reachableAndDirectlyRelatedClasses.directlyRelatedClasses, true);
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
/*      */   private ClassInfoList getClassesWithFieldOrMethodAnnotation(RelType paramRelType) {
/*      */     boolean bool;
/* 2029 */     if (((bool = (paramRelType == RelType.CLASSES_WITH_FIELD_ANNOTATION || paramRelType == RelType.CLASSES_WITH_NONPRIVATE_FIELD_ANNOTATION) ? true : false) ? this.scanResult.scanSpec.enableFieldInfo : this.scanResult.scanSpec.enableMethodInfo) || !this.scanResult.scanSpec.enableAnnotationInfo)
/*      */     {
/* 2031 */       throw new IllegalArgumentException("Please call ClassGraph#enable" + (bool ? "Field" : "Method") + "Info() and #enableAnnotationInfo() before #scan()");
/*      */     }
/*      */ 
/*      */     
/* 2035 */     ReachableAndDirectlyRelatedClasses reachableAndDirectlyRelatedClasses1 = filterClassInfo(paramRelType, !this.isExternalClass, new ClassType[0]);
/*      */     
/*      */     ReachableAndDirectlyRelatedClasses reachableAndDirectlyRelatedClasses2;
/* 2038 */     if ((reachableAndDirectlyRelatedClasses2 = filterClassInfo(RelType.CLASSES_WITH_ANNOTATION, !this.isExternalClass, new ClassType[] { ClassType.ANNOTATION })).reachableClasses.isEmpty())
/*      */     {
/* 2040 */       return new ClassInfoList(reachableAndDirectlyRelatedClasses1, true);
/*      */     }
/*      */ 
/*      */     
/* 2044 */     LinkedHashSet<ClassInfo> linkedHashSet = new LinkedHashSet<>(reachableAndDirectlyRelatedClasses1.reachableClasses);
/*      */     
/* 2046 */     for (ClassInfo classInfo : reachableAndDirectlyRelatedClasses2.reachableClasses) {
/* 2047 */       linkedHashSet
/* 2048 */         .addAll((classInfo.filterClassInfo(paramRelType, !classInfo.isExternalClass, new ClassType[0])).reachableClasses);
/*      */     }
/*      */     
/* 2051 */     return new ClassInfoList(linkedHashSet, reachableAndDirectlyRelatedClasses1.directlyRelatedClasses, true);
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
/*      */   public AnnotationInfoList getAnnotationInfo() {
/* 2067 */     if (!this.scanResult.scanSpec.enableAnnotationInfo) {
/* 2068 */       throw new IllegalArgumentException("Please call ClassGraph#enableAnnotationInfo() before #scan()");
/*      */     }
/* 2070 */     return AnnotationInfoList.getIndirectAnnotations(this.annotationInfo, this);
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
/*      */ 
/*      */   
/*      */   public AnnotationInfo getAnnotationInfo(Class<? extends Annotation> paramClass) {
/* 2092 */     Assert.isAnnotation(paramClass);
/* 2093 */     return getAnnotationInfo(paramClass.getName());
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
/*      */ 
/*      */   
/*      */   public AnnotationInfo getAnnotationInfo(String paramString) {
/* 2115 */     return getAnnotationInfo().get(paramString);
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
/*      */ 
/*      */   
/*      */   public AnnotationInfoList getAnnotationInfoRepeatable(Class<? extends Annotation> paramClass) {
/* 2137 */     Assert.isAnnotation(paramClass);
/* 2138 */     return getAnnotationInfoRepeatable(paramClass.getName());
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
/*      */ 
/*      */   
/*      */   public AnnotationInfoList getAnnotationInfoRepeatable(String paramString) {
/* 2160 */     return getAnnotationInfo().getRepeatable(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AnnotationParameterValueList getAnnotationDefaultParameterValues() {
/* 2170 */     if (!this.scanResult.scanSpec.enableAnnotationInfo) {
/* 2171 */       throw new IllegalArgumentException("Please call ClassGraph#enableAnnotationInfo() before #scan()");
/*      */     }
/* 2173 */     if (!isAnnotation()) {
/* 2174 */       throw new IllegalArgumentException("Class is not an annotation: " + getName());
/*      */     }
/* 2176 */     if (this.annotationDefaultParamValues == null) {
/* 2177 */       return AnnotationParameterValueList.EMPTY_LIST;
/*      */     }
/* 2179 */     if (!this.annotationDefaultParamValuesHasBeenConvertedToPrimitive) {
/* 2180 */       this.annotationDefaultParamValues.convertWrapperArraysToPrimitiveArrays(this);
/* 2181 */       this.annotationDefaultParamValuesHasBeenConvertedToPrimitive = true;
/*      */     } 
/* 2183 */     return this.annotationDefaultParamValues;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassInfoList getClassesWithAnnotation() {
/* 2194 */     if (!this.scanResult.scanSpec.enableAnnotationInfo) {
/* 2195 */       throw new IllegalArgumentException("Please call ClassGraph#enableAnnotationInfo() before #scan()");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 2200 */     ReachableAndDirectlyRelatedClasses reachableAndDirectlyRelatedClasses = filterClassInfo(RelType.CLASSES_WITH_ANNOTATION, !this.isExternalClass, new ClassType[0]);
/*      */     
/* 2202 */     if (this.isInherited) {
/*      */       
/* 2204 */       LinkedHashSet<ClassInfo> linkedHashSet = new LinkedHashSet<>(reachableAndDirectlyRelatedClasses.reachableClasses);
/*      */       
/* 2206 */       for (ClassInfo classInfo : reachableAndDirectlyRelatedClasses.reachableClasses) {
/* 2207 */         linkedHashSet.addAll(classInfo.getSubclasses());
/*      */       }
/* 2209 */       return new ClassInfoList(linkedHashSet, reachableAndDirectlyRelatedClasses.directlyRelatedClasses, true);
/*      */     } 
/*      */ 
/*      */     
/* 2213 */     return new ClassInfoList(reachableAndDirectlyRelatedClasses, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ClassInfoList getClassesWithAnnotationDirectOnly() {
/* 2224 */     return new ClassInfoList(
/* 2225 */         filterClassInfo(RelType.CLASSES_WITH_ANNOTATION, !this.isExternalClass, new ClassType[0]), true);
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
/*      */   
/*      */   private MethodInfoList getDeclaredMethodInfo(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*      */     boolean bool;
/* 2247 */     if (!this.scanResult.scanSpec.enableMethodInfo) {
/* 2248 */       throw new IllegalArgumentException("Please call ClassGraph#enableMethodInfo() before #scan()");
/*      */     }
/* 2250 */     if (this.methodInfo == null) {
/* 2251 */       return MethodInfoList.EMPTY_LIST;
/*      */     }
/* 2253 */     if (paramString == null) {
/*      */ 
/*      */       
/* 2256 */       MethodInfoList methodInfoList1 = new MethodInfoList();
/* 2257 */       for (Iterator<MethodInfo> iterator = this.methodInfo.iterator(); iterator.hasNext(); ) {
/* 2258 */         MethodInfo methodInfo; String str = (methodInfo = iterator.next()).getName();
/* 2259 */         bool = "<init>".equals(str);
/*      */         
/* 2261 */         boolean bool2 = "<clinit>".equals(str);
/* 2262 */         if ((bool && paramBoolean2) || (bool2 && paramBoolean3) || (!bool && !bool2 && paramBoolean1))
/*      */         {
/* 2264 */           methodInfoList1.add(methodInfo);
/*      */         }
/*      */       } 
/* 2267 */       return methodInfoList1;
/*      */     } 
/*      */     
/* 2270 */     boolean bool1 = false;
/* 2271 */     for (Iterator<MethodInfo> iterator1 = this.methodInfo.iterator(); iterator1.hasNext();) {
/* 2272 */       if ((methodInfo = iterator1.next()).getName().equals(bool)) {
/* 2273 */         bool1 = true;
/*      */         break;
/*      */       } 
/*      */     } 
/* 2277 */     if (!bool1) {
/* 2278 */       return MethodInfoList.EMPTY_LIST;
/*      */     }
/* 2280 */     MethodInfoList methodInfoList = new MethodInfoList();
/* 2281 */     for (Iterator<MethodInfo> iterator2 = this.methodInfo.iterator(); iterator2.hasNext();) {
/* 2282 */       if ((methodInfo = iterator2.next()).getName().equals(bool)) {
/* 2283 */         methodInfoList.add(methodInfo);
/*      */       }
/*      */     } 
/* 2286 */     return methodInfoList;
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
/*      */   private MethodInfoList getMethodInfo(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 2305 */     if (!this.scanResult.scanSpec.enableMethodInfo) {
/* 2306 */       throw new IllegalArgumentException("Please call ClassGraph#enableMethodInfo() before #scan()");
/*      */     }
/*      */     
/* 2309 */     MethodInfoList methodInfoList = new MethodInfoList();
/* 2310 */     HashSet hashSet = new HashSet();
/* 2311 */     for (Iterator<ClassInfo> iterator = getMethodOverrideOrder().iterator(); iterator.hasNext();) {
/* 2312 */       for (MethodInfo methodInfo : (classInfo = iterator.next()).getDeclaredMethodInfo(paramString, paramBoolean1, paramBoolean2, paramBoolean3)) {
/*      */ 
/*      */         
/* 2315 */         if (hashSet.add(new AbstractMap.SimpleEntry<>(methodInfo.getName(), methodInfo.getTypeDescriptorStr())))
/*      */         {
/* 2317 */           methodInfoList.add(methodInfo);
/*      */         }
/*      */       } 
/*      */     } 
/* 2321 */     return methodInfoList;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodInfoList getDeclaredMethodInfo() {
/* 2355 */     return getDeclaredMethodInfo(null, true, false, false);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodInfoList getMethodInfo() {
/* 2390 */     return getMethodInfo(null, true, false, false);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodInfoList getDeclaredConstructorInfo() {
/* 2425 */     return getDeclaredMethodInfo(null, false, true, false);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodInfoList getConstructorInfo() {
/* 2460 */     return getMethodInfo(null, false, true, false);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodInfoList getDeclaredMethodAndConstructorInfo() {
/* 2499 */     return getDeclaredMethodInfo(null, true, true, false);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodInfoList getMethodAndConstructorInfo() {
/* 2535 */     return getMethodInfo(null, true, true, false);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodInfoList getDeclaredMethodInfo(String paramString) {
/* 2572 */     return getDeclaredMethodInfo(paramString, false, false, false);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodInfoList getMethodInfo(String paramString) {
/* 2608 */     return getMethodInfo(paramString, false, false, false);
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
/*      */   public ClassInfoList getMethodAnnotations() {
/* 2621 */     return getFieldOrMethodAnnotations(RelType.METHOD_ANNOTATIONS);
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
/*      */   public ClassInfoList getMethodParameterAnnotations() {
/* 2634 */     return getFieldOrMethodAnnotations(RelType.METHOD_PARAMETER_ANNOTATIONS);
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
/*      */   public ClassInfoList getClassesWithMethodAnnotation() {
/* 2647 */     HashSet<ClassInfo> hashSet = new HashSet(getClassesWithFieldOrMethodAnnotation(RelType.CLASSES_WITH_METHOD_ANNOTATION));
/*      */ 
/*      */ 
/*      */     
/* 2651 */     for (ClassInfo classInfo : getClassesWithFieldOrMethodAnnotation(RelType.CLASSES_WITH_NONPRIVATE_METHOD_ANNOTATION)) {
/* 2652 */       hashSet.addAll(classInfo.getSubclasses());
/*      */     }
/* 2654 */     return new ClassInfoList(hashSet, new HashSet<>(
/* 2655 */           getClassesWithMethodAnnotationDirectOnly()), true);
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
/*      */   public ClassInfoList getClassesWithMethodParameterAnnotation() {
/* 2668 */     HashSet<ClassInfo> hashSet = new HashSet(getClassesWithFieldOrMethodAnnotation(RelType.CLASSES_WITH_METHOD_PARAMETER_ANNOTATION));
/*      */ 
/*      */ 
/*      */     
/* 2672 */     for (ClassInfo classInfo : getClassesWithFieldOrMethodAnnotation(RelType.CLASSES_WITH_NONPRIVATE_METHOD_PARAMETER_ANNOTATION)) {
/* 2673 */       hashSet
/* 2674 */         .addAll(classInfo.getSubclasses());
/*      */     }
/* 2676 */     return new ClassInfoList(hashSet, new HashSet<>(
/* 2677 */           getClassesWithMethodParameterAnnotationDirectOnly()), true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ClassInfoList getClassesWithMethodAnnotationDirectOnly() {
/* 2687 */     return new ClassInfoList(
/* 2688 */         filterClassInfo(RelType.CLASSES_WITH_METHOD_ANNOTATION, !this.isExternalClass, new ClassType[0]), true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ClassInfoList getClassesWithMethodParameterAnnotationDirectOnly() {
/* 2699 */     return new ClassInfoList(filterClassInfo(RelType.CLASSES_WITH_METHOD_PARAMETER_ANNOTATION, !this.isExternalClass, new ClassType[0]), true);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FieldInfoList getDeclaredFieldInfo() {
/* 2729 */     if (!this.scanResult.scanSpec.enableFieldInfo) {
/* 2730 */       throw new IllegalArgumentException("Please call ClassGraph#enableFieldInfo() before #scan()");
/*      */     }
/* 2732 */     return (this.fieldInfo == null) ? FieldInfoList.EMPTY_LIST : this.fieldInfo;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FieldInfoList getFieldInfo() {
/* 2758 */     if (!this.scanResult.scanSpec.enableFieldInfo) {
/* 2759 */       throw new IllegalArgumentException("Please call ClassGraph#enableFieldInfo() before #scan()");
/*      */     }
/*      */     
/* 2762 */     FieldInfoList fieldInfoList = new FieldInfoList();
/* 2763 */     HashSet<String> hashSet = new HashSet();
/* 2764 */     for (Iterator<ClassInfo> iterator = getFieldOverrideOrder().iterator(); iterator.hasNext();) {
/* 2765 */       for (FieldInfo fieldInfo : (classInfo = iterator.next()).getDeclaredFieldInfo()) {
/*      */         
/* 2767 */         if (hashSet.add(fieldInfo.getName()))
/*      */         {
/* 2769 */           fieldInfoList.add(fieldInfo);
/*      */         }
/*      */       } 
/*      */     } 
/* 2773 */     return fieldInfoList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FieldInfoList getEnumConstants() {
/* 2781 */     if (!isEnum()) {
/* 2782 */       throw new IllegalArgumentException("Class " + getName() + " is not an enum");
/*      */     }
/* 2784 */     return getFieldInfo().filter(new FieldInfoList.FieldInfoFilter()
/*      */         {
/*      */           public boolean accept(FieldInfo param1FieldInfo) {
/* 2787 */             return param1FieldInfo.isEnum();
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */   
/*      */   public List<Object> getEnumConstantObjects() {
/* 2794 */     if (!isEnum()) {
/* 2795 */       throw new IllegalArgumentException("Class " + getName() + " is not an enum");
/*      */     }
/* 2797 */     Class<?> clazz = loadClass();
/* 2798 */     FieldInfoList fieldInfoList = getEnumConstants();
/* 2799 */     ArrayList<Object> arrayList = new ArrayList(fieldInfoList.size());
/* 2800 */     ReflectionUtils reflectionUtils = (this.scanResult == null) ? new ReflectionUtils() : this.scanResult.reflectionUtils;
/*      */     
/* 2802 */     for (FieldInfo fieldInfo : fieldInfoList) {
/*      */       Object object;
/* 2804 */       if ((object = reflectionUtils.getStaticFieldVal(true, clazz, fieldInfo.getName())) == null) {
/* 2805 */         throw new IllegalArgumentException("Could not read enum constant objects");
/*      */       }
/* 2807 */       arrayList.add(object);
/*      */     } 
/* 2809 */     return arrayList;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FieldInfo getDeclaredFieldInfo(String paramString) {
/* 2837 */     if (!this.scanResult.scanSpec.enableFieldInfo) {
/* 2838 */       throw new IllegalArgumentException("Please call ClassGraph#enableFieldInfo() before #scan()");
/*      */     }
/* 2840 */     if (this.fieldInfo == null) {
/* 2841 */       return null;
/*      */     }
/* 2843 */     for (Iterator<FieldInfo> iterator = this.fieldInfo.iterator(); iterator.hasNext();) {
/* 2844 */       if ((fieldInfo = iterator.next()).getName().equals(paramString)) {
/* 2845 */         return fieldInfo;
/*      */       }
/*      */     } 
/* 2848 */     return null;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FieldInfo getFieldInfo(String paramString) {
/* 2876 */     if (!this.scanResult.scanSpec.enableFieldInfo) {
/* 2877 */       throw new IllegalArgumentException("Please call ClassGraph#enableFieldInfo() before #scan()");
/*      */     }
/*      */     
/* 2880 */     for (Iterator<ClassInfo> iterator = getFieldOverrideOrder().iterator(); iterator.hasNext();) {
/*      */       
/* 2882 */       if ((fieldInfo = (classInfo = iterator.next()).getDeclaredFieldInfo(paramString)) != null) {
/* 2883 */         return fieldInfo;
/*      */       }
/*      */     } 
/* 2886 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassInfoList getFieldAnnotations() {
/* 2897 */     return getFieldOrMethodAnnotations(RelType.FIELD_ANNOTATIONS);
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
/*      */   public ClassInfoList getClassesWithFieldAnnotation() {
/* 2909 */     HashSet<ClassInfo> hashSet = new HashSet(getClassesWithFieldOrMethodAnnotation(RelType.CLASSES_WITH_FIELD_ANNOTATION));
/*      */ 
/*      */ 
/*      */     
/* 2913 */     for (ClassInfo classInfo : getClassesWithFieldOrMethodAnnotation(RelType.CLASSES_WITH_NONPRIVATE_FIELD_ANNOTATION)) {
/* 2914 */       hashSet.addAll(classInfo.getSubclasses());
/*      */     }
/* 2916 */     return new ClassInfoList(hashSet, new HashSet<>(
/* 2917 */           getClassesWithMethodAnnotationDirectOnly()), true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ClassInfoList getClassesWithFieldAnnotationDirectOnly() {
/* 2927 */     return new ClassInfoList(
/* 2928 */         filterClassInfo(RelType.CLASSES_WITH_FIELD_ANNOTATION, !this.isExternalClass, new ClassType[0]), true);
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
/*      */   public ClassTypeSignature getTypeSignature() {
/* 2945 */     if (this.typeSignatureStr == null) {
/* 2946 */       return null;
/*      */     }
/* 2948 */     if (this.typeSignature == null) {
/*      */       try {
/* 2950 */         this.typeSignature = ClassTypeSignature.parse(this.typeSignatureStr, this);
/* 2951 */         this.typeSignature.setScanResult(this.scanResult);
/* 2952 */         if (this.typeAnnotationDecorators != null) {
/* 2953 */           for (Iterator<Classfile.ClassTypeAnnotationDecorator> iterator = this.typeAnnotationDecorators.iterator(); iterator.hasNext();) {
/* 2954 */             (classTypeAnnotationDecorator = iterator.next()).decorate(this.typeSignature);
/*      */           }
/*      */         }
/* 2957 */       } catch (ParseException parseException) {
/* 2958 */         throw new IllegalArgumentException("Invalid type signature for class " + getName() + " in classpath element " + 
/* 2959 */             getClasspathElementURI() + " : " + this.typeSignatureStr, parseException);
/*      */       } 
/*      */     }
/* 2962 */     return this.typeSignature;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTypeSignatureStr() {
/* 2972 */     return this.typeSignatureStr;
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
/*      */   public ClassTypeSignature getTypeSignatureOrTypeDescriptor() {
/*      */     try {
/*      */       ClassTypeSignature classTypeSignature;
/* 2988 */       if ((classTypeSignature = getTypeSignature()) != null) {
/* 2989 */         return classTypeSignature;
/*      */       }
/* 2991 */     } catch (Exception exception) {}
/*      */ 
/*      */     
/* 2994 */     return getTypeDescriptor();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassTypeSignature getTypeDescriptor() {
/* 3004 */     if (this.typeDescriptor == null) {
/* 3005 */       this.typeDescriptor = new ClassTypeSignature(this, getSuperclass(), getInterfaces());
/* 3006 */       this.typeDescriptor.setScanResult(this.scanResult);
/* 3007 */       if (this.typeAnnotationDecorators != null) {
/* 3008 */         for (Iterator<Classfile.ClassTypeAnnotationDecorator> iterator = this.typeAnnotationDecorators.iterator(); iterator.hasNext();) {
/* 3009 */           (classTypeAnnotationDecorator = iterator.next()).decorate(this.typeDescriptor);
/*      */         }
/*      */       }
/*      */     } 
/* 3013 */     return this.typeDescriptor;
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
/*      */   public String getSourceFile() {
/* 3026 */     return this.sourceFile;
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
/*      */   public URI getClasspathElementURI() {
/* 3041 */     return this.classfileResource.getClasspathElementURI();
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
/*      */   public URL getClasspathElementURL() {
/*      */     try {
/* 3057 */       return getClasspathElementURI().toURL();
/* 3058 */     } catch (IllegalArgumentException|java.net.MalformedURLException illegalArgumentException) {
/* 3059 */       throw new IllegalArgumentException("Could not get classpath element URL", illegalArgumentException);
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
/*      */   public File getClasspathElementFile() {
/* 3073 */     if (this.classpathElement == null) {
/* 3074 */       throw new IllegalArgumentException("Classpath element is not known for this classpath element");
/*      */     }
/* 3076 */     return this.classpathElement.getFile();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ModuleRef getModuleRef() {
/* 3087 */     if (this.classpathElement == null) {
/* 3088 */       throw new IllegalArgumentException("Classpath element is not known for this classpath element");
/*      */     }
/* 3090 */     if (this.classpathElement instanceof ClasspathElementModule)
/* 3091 */       return ((ClasspathElementModule)this.classpathElement).getModuleRef();  return null;
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
/*      */   public Resource getResource() {
/* 3103 */     return this.classfileResource;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> Class<T> loadClass(Class<T> paramClass, boolean paramBoolean) {
/* 3135 */     return super.loadClass(paramClass, paramBoolean);
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
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> Class<T> loadClass(Class<T> paramClass) {
/* 3158 */     return super.loadClass(paramClass, false);
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
/*      */   public Class<?> loadClass(boolean paramBoolean) {
/* 3174 */     return super.loadClass(paramBoolean);
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
/*      */   public Class<?> loadClass() {
/* 3187 */     return super.loadClass(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getClassName() {
/* 3197 */     return this.name;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ClassInfo getClassInfo() {
/* 3205 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setScanResult(ScanResult paramScanResult) {
/* 3213 */     super.setScanResult(paramScanResult);
/* 3214 */     if (this.typeSignature != null) {
/* 3215 */       this.typeSignature.setScanResult(paramScanResult);
/*      */     }
/* 3217 */     if (this.annotationInfo != null) {
/* 3218 */       for (Iterator<AnnotationInfo> iterator = this.annotationInfo.iterator(); iterator.hasNext();) {
/* 3219 */         (annotationInfo = iterator.next()).setScanResult(paramScanResult);
/*      */       }
/*      */     }
/* 3222 */     if (this.fieldInfo != null) {
/* 3223 */       for (Iterator<FieldInfo> iterator = this.fieldInfo.iterator(); iterator.hasNext();) {
/* 3224 */         (fieldInfo = iterator.next()).setScanResult(paramScanResult);
/*      */       }
/*      */     }
/* 3227 */     if (this.methodInfo != null) {
/* 3228 */       for (Iterator<MethodInfo> iterator = this.methodInfo.iterator(); iterator.hasNext();) {
/* 3229 */         (methodInfo = iterator.next()).setScanResult(paramScanResult);
/*      */       }
/*      */     }
/* 3232 */     if (this.annotationDefaultParamValues != null) {
/* 3233 */       for (Iterator<AnnotationParameterValue> iterator = this.annotationDefaultParamValues.iterator(); iterator.hasNext();) {
/* 3234 */         (annotationParameterValue = iterator.next()).setScanResult(paramScanResult);
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
/*      */   void handleRepeatableAnnotations(Set<String> paramSet) {
/* 3248 */     if (this.annotationInfo != null) {
/* 3249 */       this.annotationInfo.handleRepeatableAnnotations(paramSet, this, RelType.CLASS_ANNOTATIONS, RelType.CLASSES_WITH_ANNOTATION, (RelType)null);
/*      */     }
/*      */     
/* 3252 */     if (this.fieldInfo != null) {
/* 3253 */       for (Iterator<FieldInfo> iterator = this.fieldInfo.iterator(); iterator.hasNext();) {
/* 3254 */         (fieldInfo = iterator.next()).handleRepeatableAnnotations(paramSet);
/*      */       }
/*      */     }
/* 3257 */     if (this.methodInfo != null) {
/* 3258 */       for (Iterator<MethodInfo> iterator = this.methodInfo.iterator(); iterator.hasNext();) {
/* 3259 */         (methodInfo = iterator.next()).handleRepeatableAnnotations(paramSet);
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
/*      */   void addReferencedClassNames(Set<String> paramSet) {
/* 3273 */     if (this.referencedClassNames == null) {
/* 3274 */       this.referencedClassNames = paramSet; return;
/*      */     } 
/* 3276 */     this.referencedClassNames.addAll(paramSet);
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
/*      */   protected void findReferencedClassInfo(Map<String, ClassInfo> paramMap, Set<ClassInfo> paramSet, LogNode paramLogNode) {
/* 3295 */     super.findReferencedClassInfo(paramMap, paramSet, paramLogNode);
/* 3296 */     if (this.referencedClassNames != null) {
/* 3297 */       for (Iterator<String> iterator = this.referencedClassNames.iterator(); iterator.hasNext(); ) {
/*      */         ClassInfo classInfo; String str;
/* 3299 */         (classInfo = getOrCreateClassInfo(str = iterator.next(), paramMap)).setScanResult(this.scanResult);
/* 3300 */         paramSet.add(classInfo);
/*      */       } 
/*      */     }
/* 3303 */     getMethodInfo().findReferencedClassInfo(paramMap, paramSet, paramLogNode);
/* 3304 */     getFieldInfo().findReferencedClassInfo(paramMap, paramSet, paramLogNode);
/* 3305 */     getAnnotationInfo().findReferencedClassInfo(paramMap, paramSet, paramLogNode);
/* 3306 */     if (this.annotationDefaultParamValues != null) {
/* 3307 */       this.annotationDefaultParamValues.findReferencedClassInfo(paramMap, paramSet, paramLogNode);
/*      */     }
/*      */     try {
/*      */       ClassTypeSignature classTypeSignature;
/* 3311 */       if ((classTypeSignature = getTypeSignature()) != null)
/* 3312 */         classTypeSignature.findReferencedClassInfo(paramMap, paramSet, paramLogNode); 
/*      */       return;
/* 3314 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 3315 */       if (paramLogNode != null) {
/* 3316 */         paramLogNode.log("Illegal type signature for class " + getClassName() + ": " + getTypeSignatureStr());
/*      */       }
/*      */       return;
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
/*      */   void setReferencedClasses(ClassInfoList paramClassInfoList) {
/* 3330 */     this.referencedClasses = paramClassInfoList;
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
/*      */   public ClassInfoList getClassDependencies() {
/* 3343 */     if (!this.scanResult.scanSpec.enableInterClassDependencies) {
/* 3344 */       throw new IllegalArgumentException("Please call ClassGraph#enableInterClassDependencies() before #scan()");
/*      */     }
/*      */     
/* 3347 */     return (this.referencedClasses == null) ? ClassInfoList.EMPTY_LIST : this.referencedClasses;
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
/*      */   public int compareTo(ClassInfo paramClassInfo) {
/* 3361 */     return this.name.compareTo(paramClassInfo.name);
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
/*      */   public boolean equals(Object paramObject) {
/* 3373 */     if (paramObject == this)
/* 3374 */       return true; 
/* 3375 */     if (!(paramObject instanceof ClassInfo)) {
/* 3376 */       return false;
/*      */     }
/* 3378 */     paramObject = paramObject;
/* 3379 */     return this.name.equals(((ClassInfo)paramObject).name);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 3389 */     return (this.name == null) ? 0 : this.name.hashCode();
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
/*      */   protected void toString(boolean paramBoolean, StringBuilder paramStringBuilder) {
/* 3404 */     boolean bool = (paramStringBuilder.length() == 0) ? true : false;
/* 3405 */     if (this.annotationInfo != null) {
/* 3406 */       for (AnnotationInfo annotationInfo : this.annotationInfo) {
/* 3407 */         if (paramStringBuilder.length() > 0 && paramStringBuilder.charAt(paramStringBuilder.length() - 1) != ' ' && paramStringBuilder
/* 3408 */           .charAt(paramStringBuilder.length() - 1) != '(') {
/* 3409 */           paramStringBuilder.append(' ');
/*      */         }
/* 3411 */         annotationInfo.toString(paramBoolean, paramStringBuilder);
/*      */       } 
/*      */     }
/* 3414 */     ClassTypeSignature classTypeSignature = null;
/*      */     try {
/* 3416 */       classTypeSignature = getTypeSignature();
/* 3417 */     } catch (Exception exception) {}
/*      */ 
/*      */     
/* 3420 */     if (classTypeSignature != null) {
/*      */       
/* 3422 */       classTypeSignature.toStringInternal(paramBoolean ? getSimpleName(this.name) : this.name, false, this.modifiers, 
/* 3423 */           isAnnotation(), isInterface(), this.annotationInfo, paramStringBuilder);
/*      */       
/*      */       return;
/*      */     } 
/* 3427 */     TypeUtils.modifiersToString(this.modifiers, TypeUtils.ModifierType.CLASS, false, paramStringBuilder);
/* 3428 */     if (paramStringBuilder.length() > 0 && paramStringBuilder.charAt(paramStringBuilder.length() - 1) != ' ' && paramStringBuilder.charAt(paramStringBuilder.length() - 1) != '(') {
/* 3429 */       paramStringBuilder.append(' ');
/*      */     }
/*      */     
/* 3432 */     if (bool) {
/* 3433 */       paramStringBuilder.append(isRecord() ? "record " : (
/* 3434 */           isEnum() ? "enum " : (
/* 3435 */           isAnnotation() ? "@interface " : (
/* 3436 */           isInterface() ? "interface " : "class "))));
/*      */     }
/*      */     
/* 3439 */     paramStringBuilder.append(paramBoolean ? getSimpleName(this.name) : this.name);
/* 3440 */     if (this.isRecord) {
/*      */       
/* 3442 */       paramStringBuilder.append('(');
/* 3443 */       boolean bool1 = true;
/* 3444 */       for (FieldInfo fieldInfo : getFieldInfo()) {
/* 3445 */         if (!bool1) {
/* 3446 */           paramStringBuilder.append(", ");
/*      */         } else {
/* 3448 */           bool1 = false;
/*      */         } 
/* 3450 */         fieldInfo.toString(false, false, paramStringBuilder);
/*      */       } 
/* 3452 */       paramStringBuilder.append(')');
/*      */     } 
/*      */     
/* 3455 */     if ((classInfo = getSuperclass()) != null && !classInfo.getName().equals("java.lang.Object")) {
/* 3456 */       paramStringBuilder.append(" extends ");
/* 3457 */       classInfo.toString(paramBoolean, paramStringBuilder);
/*      */     } 
/*      */     
/*      */     Set<ClassInfo> set;
/* 3461 */     if (!(set = (filterClassInfo(RelType.IMPLEMENTED_INTERFACES, false, new ClassType[0])).directlyRelatedClasses).isEmpty()) {
/* 3462 */       paramStringBuilder.append(isInterface() ? " extends " : " implements ");
/* 3463 */       boolean bool1 = true;
/* 3464 */       for (ClassInfo classInfo : set) {
/* 3465 */         if (bool1) {
/* 3466 */           bool1 = false;
/*      */         } else {
/* 3468 */           paramStringBuilder.append(", ");
/*      */         } 
/* 3470 */         classInfo.toString(paramBoolean, paramStringBuilder);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   ClassInfo() {}
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ClassInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */