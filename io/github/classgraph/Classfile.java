/*      */ package io.github.classgraph;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.lang.reflect.Array;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import nonapi.io.github.classgraph.concurrency.WorkQueue;
/*      */ import nonapi.io.github.classgraph.fileslice.reader.ClassfileReader;
/*      */ import nonapi.io.github.classgraph.scanspec.ScanSpec;
/*      */ import nonapi.io.github.classgraph.types.ParseException;
/*      */ import nonapi.io.github.classgraph.utils.CollectionUtils;
/*      */ import nonapi.io.github.classgraph.utils.JarUtils;
/*      */ import nonapi.io.github.classgraph.utils.LogNode;
/*      */ import nonapi.io.github.classgraph.utils.StringUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ class Classfile
/*      */ {
/*      */   private ClassfileReader reader;
/*      */   private final ClasspathElement classpathElement;
/*      */   private final List<ClasspathElement> classpathOrder;
/*      */   private final String relativePath;
/*      */   private final Resource classfileResource;
/*      */   private final ConcurrentHashMap<String, String> stringInternMap;
/*      */   private String className;
/*      */   private int minorVersion;
/*      */   private int majorVersion;
/*      */   private final boolean isExternalClass;
/*      */   private int classModifiers;
/*      */   private boolean isInterface;
/*      */   private boolean isRecord;
/*      */   private boolean isAnnotation;
/*      */   private String superclassName;
/*      */   private List<String> implementedInterfaces;
/*      */   private AnnotationInfoList classAnnotations;
/*      */   private String fullyQualifiedDefiningMethodName;
/*      */   private List<ClassContainment> classContainmentEntries;
/*      */   private AnnotationParameterValueList annotationParamDefaultValues;
/*      */   private Set<String> refdClassNames;
/*      */   private FieldInfoList fieldInfoList;
/*      */   private MethodInfoList methodInfoList;
/*      */   private String typeSignatureStr;
/*      */   private String sourceFile;
/*      */   private List<ClassTypeAnnotationDecorator> classTypeAnnotationDecorators;
/*      */   private final Set<String> acceptedClassNamesFound;
/*      */   private final Set<String> classNamesScheduledForExtendedScanning;
/*      */   private List<Scanner.ClassfileScanWorkUnit> additionalWorkUnits;
/*      */   private final ScanSpec scanSpec;
/*      */   private int cpCount;
/*      */   private int[] entryOffset;
/*      */   private int[] entryTag;
/*      */   private int[] indirectStringRefs;
/*  172 */   private static final AnnotationInfo[] NO_ANNOTATIONS = new AnnotationInfo[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class ClassContainment
/*      */   {
/*      */     public final String innerClassName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final int innerClassModifierBits;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final String outerClassName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ClassContainment(String param1String1, int param1Int, String param1String2) {
/*  201 */       this.innerClassName = param1String1;
/*  202 */       this.innerClassModifierBits = param1Int;
/*  203 */       this.outerClassName = param1String2;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class ClassfileFormatException
/*      */     extends IOException
/*      */   {
/*      */     static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ClassfileFormatException(String param1String) {
/*  221 */       super(param1String);
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
/*      */     public ClassfileFormatException(String param1String, Throwable param1Throwable) {
/*  233 */       super(param1String, param1Throwable);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public synchronized Throwable fillInStackTrace() {
/*  243 */       return this;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class SkipClassException
/*      */     extends IOException
/*      */   {
/*      */     static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public SkipClassException(String param1String) {
/*  259 */       super(param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public synchronized Throwable fillInStackTrace() {
/*  269 */       return this;
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
/*      */   private void scheduleScanningIfExternalClass(String paramString1, String paramString2, LogNode paramLogNode) {
/*  288 */     if (paramString1 != null && !paramString1.equals("java.lang.Object") && 
/*      */       
/*  290 */       !this.acceptedClassNamesFound.contains(paramString1) && this.classNamesScheduledForExtendedScanning
/*      */       
/*  292 */       .add(paramString1)) {
/*  293 */       if (this.scanSpec.classAcceptReject.isRejected(paramString1)) {
/*  294 */         if (paramLogNode != null) {
/*  295 */           paramLogNode.log("Cannot extend scanning upwards to external " + paramString2 + " " + paramString1 + ", since it is rejected");
/*      */ 
/*      */           
/*      */           return;
/*      */         } 
/*      */       } else {
/*  301 */         String str = JarUtils.classNameToClassfilePath(paramString1);
/*      */         
/*  303 */         Resource resource = this.classpathElement.getResource(str);
/*  304 */         ClasspathElement classpathElement = null;
/*  305 */         if (resource != null) {
/*      */           
/*  307 */           classpathElement = this.classpathElement;
/*      */         } else {
/*      */           
/*  310 */           for (Iterator<ClasspathElement> iterator = this.classpathOrder.iterator(); iterator.hasNext();) {
/*  311 */             if ((classpathElement1 = iterator.next()) != this.classpathElement && (
/*      */               
/*  313 */               resource = classpathElement1.getResource(str)) != null) {
/*  314 */               classpathElement = classpathElement1;
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         } 
/*  320 */         if (resource != null) {
/*      */           
/*  322 */           if (paramLogNode != null)
/*      */           {
/*      */ 
/*      */             
/*  326 */             resource
/*  327 */               .scanLog = paramLogNode.log("Extending scanning to external " + paramString2 + ((classpathElement == this.classpathElement) ? " in same classpath element" : (" in classpath element " + classpathElement)) + ": " + paramString1);
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*  332 */           if (this.additionalWorkUnits == null) {
/*  333 */             this.additionalWorkUnits = new ArrayList<>();
/*      */           }
/*      */           
/*  336 */           this.additionalWorkUnits.add(new Scanner.ClassfileScanWorkUnit(classpathElement, resource, true));
/*      */           return;
/*      */         } 
/*  339 */         if (paramLogNode != null) {
/*  340 */           paramLogNode.log("External " + paramString2 + " " + paramString1 + " was not found in non-rejected packages -- cannot extend scanning to this class");
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
/*      */ 
/*      */   
/*      */   private void extendScanningUpwardsFromAnnotationParameterValues(Object paramObject, LogNode paramLogNode) {
/*  358 */     if (paramObject != null) {
/*      */       
/*  360 */       if (paramObject instanceof AnnotationInfo) {
/*  361 */         AnnotationInfo annotationInfo = (AnnotationInfo)paramObject;
/*  362 */         scheduleScanningIfExternalClass(annotationInfo.getClassName(), "annotation class", paramLogNode);
/*  363 */         for (Object paramObject : annotationInfo.getParameterValues())
/*  364 */           extendScanningUpwardsFromAnnotationParameterValues(paramObject.getValue(), paramLogNode);  return;
/*      */       } 
/*  366 */       if (paramObject instanceof AnnotationEnumValue) {
/*  367 */         scheduleScanningIfExternalClass(((AnnotationEnumValue)paramObject).getClassName(), "enum class", paramLogNode); return;
/*      */       } 
/*  369 */       if (paramObject instanceof AnnotationClassRef) {
/*  370 */         scheduleScanningIfExternalClass(((AnnotationClassRef)paramObject).getClassName(), "class ref", paramLogNode); return;
/*      */       } 
/*  372 */       if (paramObject.getClass().isArray()) {
/*  373 */         byte b; int i; for (b = 0, i = Array.getLength(paramObject); b < i; b++) {
/*  374 */           extendScanningUpwardsFromAnnotationParameterValues(Array.get(paramObject, b), paramLogNode);
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
/*      */   private void extendScanningUpwards(LogNode paramLogNode) {
/*  389 */     if (this.superclassName != null) {
/*  390 */       scheduleScanningIfExternalClass(this.superclassName, "superclass", paramLogNode);
/*      */     }
/*      */     
/*  393 */     if (this.implementedInterfaces != null) {
/*  394 */       for (String str : this.implementedInterfaces) {
/*  395 */         scheduleScanningIfExternalClass(str, "interface", paramLogNode);
/*      */       }
/*      */     }
/*      */     
/*  399 */     if (this.classAnnotations != null) {
/*  400 */       for (AnnotationInfo annotationInfo : this.classAnnotations) {
/*  401 */         scheduleScanningIfExternalClass(annotationInfo.getName(), "class annotation", paramLogNode);
/*  402 */         extendScanningUpwardsFromAnnotationParameterValues(annotationInfo, paramLogNode);
/*      */       } 
/*      */     }
/*      */     
/*  406 */     if (this.annotationParamDefaultValues != null) {
/*  407 */       for (AnnotationParameterValue annotationParameterValue : this.annotationParamDefaultValues) {
/*  408 */         extendScanningUpwardsFromAnnotationParameterValues(annotationParameterValue.getValue(), paramLogNode);
/*      */       }
/*      */     }
/*      */     
/*  412 */     if (this.methodInfoList != null) {
/*  413 */       for (Iterator<MethodInfo> iterator = this.methodInfoList.iterator(); iterator.hasNext(); ) {
/*  414 */         MethodInfo methodInfo; if ((methodInfo = iterator.next()).annotationInfo != null) {
/*  415 */           for (AnnotationInfo annotationInfo : methodInfo.annotationInfo) {
/*  416 */             scheduleScanningIfExternalClass(annotationInfo.getName(), "method annotation", paramLogNode);
/*  417 */             extendScanningUpwardsFromAnnotationParameterValues(annotationInfo, paramLogNode);
/*      */           } 
/*  419 */           if (methodInfo.parameterAnnotationInfo != null && methodInfo.parameterAnnotationInfo.length > 0) {
/*      */             AnnotationInfo[][] arrayOfAnnotationInfo; int i; byte b;
/*  421 */             for (i = (arrayOfAnnotationInfo = methodInfo.parameterAnnotationInfo).length, b = 0; b < i; ) {
/*  422 */               AnnotationInfo[] arrayOfAnnotationInfo1; if ((arrayOfAnnotationInfo1 = arrayOfAnnotationInfo[b]) != null && arrayOfAnnotationInfo1.length > 0) {
/*  423 */                 int j; byte b1; for (j = (arrayOfAnnotationInfo1 = arrayOfAnnotationInfo1).length, b1 = 0; b1 < j; ) { AnnotationInfo annotationInfo = arrayOfAnnotationInfo1[b1];
/*  424 */                   scheduleScanningIfExternalClass(annotationInfo.getName(), "method parameter annotation", paramLogNode);
/*      */                   
/*  426 */                   extendScanningUpwardsFromAnnotationParameterValues(annotationInfo, paramLogNode); b1++; }
/*      */               
/*      */               }  b++;
/*      */             } 
/*      */           } 
/*      */         } 
/*  432 */         if (methodInfo.getThrownExceptionNames() != null) {
/*  433 */           String[] arrayOfString; int i; byte b; for (i = (arrayOfString = methodInfo.getThrownExceptionNames()).length, b = 0; b < i; ) { String str = arrayOfString[b];
/*  434 */             scheduleScanningIfExternalClass(str, "method throws", paramLogNode);
/*      */             b++; }
/*      */         
/*      */         } 
/*      */       } 
/*      */     }
/*  440 */     if (this.fieldInfoList != null) {
/*  441 */       for (Iterator<FieldInfo> iterator = this.fieldInfoList.iterator(); iterator.hasNext();) {
/*  442 */         if ((fieldInfo = iterator.next()).annotationInfo != null) {
/*  443 */           for (AnnotationInfo annotationInfo : fieldInfo.annotationInfo) {
/*  444 */             scheduleScanningIfExternalClass(annotationInfo.getName(), "field annotation", paramLogNode);
/*  445 */             extendScanningUpwardsFromAnnotationParameterValues(annotationInfo, paramLogNode);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/*  451 */     if (this.classContainmentEntries != null) {
/*  452 */       for (Iterator<ClassContainment> iterator = this.classContainmentEntries.iterator(); iterator.hasNext();) {
/*  453 */         if ((classContainment = iterator.next()).innerClassName.equals(this.className)) {
/*  454 */           scheduleScanningIfExternalClass(classContainment.outerClassName, "outer class", paramLogNode);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void link(Map<String, ClassInfo> paramMap, Map<String, PackageInfo> paramMap1, Map<String, ModuleInfo> paramMap2) {
/*  475 */     boolean bool1 = false;
/*  476 */     boolean bool2 = false;
/*  477 */     ClassInfo classInfo = null;
/*  478 */     if (this.className.equals("module-info")) {
/*  479 */       bool1 = true;
/*      */     }
/*  481 */     else if (this.className.equals("package-info") || this.className.endsWith(".package-info")) {
/*  482 */       bool2 = true;
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */       
/*  488 */       (classInfo = ClassInfo.addScannedClass(this.className, this.classModifiers, this.isExternalClass, paramMap, this.classpathElement, this.classfileResource)).setClassfileVersion(this.minorVersion, this.majorVersion);
/*  489 */       classInfo.setModifiers(this.classModifiers);
/*  490 */       classInfo.setIsInterface(this.isInterface);
/*  491 */       classInfo.setIsAnnotation(this.isAnnotation);
/*  492 */       classInfo.setIsRecord(this.isRecord);
/*  493 */       classInfo.setSourceFile(this.sourceFile);
/*  494 */       if (this.superclassName != null) {
/*  495 */         classInfo.addSuperclass(this.superclassName, paramMap);
/*      */       }
/*  497 */       if (this.implementedInterfaces != null) {
/*  498 */         for (String str1 : this.implementedInterfaces) {
/*  499 */           classInfo.addImplementedInterface(str1, paramMap);
/*      */         }
/*      */       }
/*  502 */       if (this.classAnnotations != null) {
/*  503 */         for (AnnotationInfo annotationInfo : this.classAnnotations) {
/*  504 */           classInfo.addClassAnnotation(annotationInfo, paramMap);
/*      */         }
/*      */       }
/*  507 */       if (this.classContainmentEntries != null) {
/*  508 */         ClassInfo.addClassContainment(this.classContainmentEntries, paramMap);
/*      */       }
/*  510 */       if (this.annotationParamDefaultValues != null) {
/*  511 */         classInfo.addAnnotationParamDefaultValues(this.annotationParamDefaultValues);
/*      */       }
/*  513 */       if (this.fullyQualifiedDefiningMethodName != null) {
/*  514 */         classInfo.addFullyQualifiedDefiningMethodName(this.fullyQualifiedDefiningMethodName);
/*      */       }
/*  516 */       if (this.fieldInfoList != null) {
/*  517 */         classInfo.addFieldInfo(this.fieldInfoList, paramMap);
/*      */       }
/*  519 */       if (this.methodInfoList != null) {
/*  520 */         classInfo.addMethodInfo(this.methodInfoList, paramMap);
/*      */       }
/*  522 */       if (this.typeSignatureStr != null) {
/*  523 */         classInfo.setTypeSignature(this.typeSignatureStr);
/*      */       }
/*  525 */       if (this.refdClassNames != null) {
/*  526 */         classInfo.addReferencedClassNames(this.refdClassNames);
/*      */       }
/*  528 */       if (this.classTypeAnnotationDecorators != null) {
/*  529 */         classInfo.addTypeDecorators(this.classTypeAnnotationDecorators);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  534 */     PackageInfo packageInfo = null;
/*  535 */     if (!bool1) {
/*      */       String str1;
/*      */       
/*  538 */       packageInfo = PackageInfo.getOrCreatePackage(str1 = PackageInfo.getParentPackageName(this.className), paramMap1, this.scanSpec);
/*  539 */       if (bool2) {
/*      */         
/*  541 */         packageInfo.addAnnotations(this.classAnnotations);
/*  542 */       } else if (classInfo != null) {
/*      */         
/*  544 */         packageInfo.addClassInfo(classInfo);
/*  545 */         classInfo.packageInfo = packageInfo;
/*      */       } 
/*      */     } 
/*      */     
/*      */     String str;
/*      */     
/*  551 */     if ((str = this.classpathElement.getModuleName()) != null) {
/*      */       ModuleInfo moduleInfo;
/*      */       
/*  554 */       if ((moduleInfo = paramMap2.get(str)) == null) {
/*  555 */         paramMap2.put(str, 
/*  556 */             moduleInfo = new ModuleInfo(this.classfileResource.getModuleRef(), this.classpathElement));
/*      */       }
/*  558 */       if (bool1)
/*      */       {
/*  560 */         moduleInfo.addAnnotations(this.classAnnotations);
/*      */       }
/*  562 */       if (classInfo != null) {
/*      */         
/*  564 */         moduleInfo.addClassInfo(classInfo);
/*  565 */         classInfo.moduleInfo = moduleInfo;
/*      */       } 
/*  567 */       if (packageInfo != null)
/*      */       {
/*  569 */         moduleInfo.addPackageInfo(packageInfo);
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
/*      */   private String intern(String paramString) {
/*  584 */     if (paramString == null) {
/*  585 */       return null;
/*      */     }
/*      */     String str;
/*  588 */     if ((str = this.stringInternMap.putIfAbsent(paramString, paramString)) != null) {
/*  589 */       return str;
/*      */     }
/*  591 */     return paramString;
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
/*      */   private int getConstantPoolStringOffset(int paramInt1, int paramInt2) {
/*  608 */     if (paramInt1 <= 0 || paramInt1 >= this.cpCount) {
/*  609 */       throw new ClassfileFormatException("Constant pool index " + paramInt1 + ", should be in range [1, " + (this.cpCount - 1) + "] -- cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
/*      */     }
/*      */     
/*      */     int i;
/*      */     
/*  614 */     if (((i = this.entryTag[paramInt1]) != 12 && paramInt2 != 0) || (i == 12 && paramInt2 != 0 && paramInt2 != 1)) {
/*  615 */       throw new ClassfileFormatException("Bad subfield index " + paramInt2 + " for tag " + i + ", cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  620 */     if (i == 0)
/*      */     {
/*  622 */       return 0; } 
/*  623 */     if (i == 1) {
/*      */       
/*  625 */       paramInt2 = paramInt1;
/*  626 */     } else if (i == 7 || i == 8 || i == 19) {
/*      */ 
/*      */ 
/*      */       
/*  630 */       if ((i = this.indirectStringRefs[paramInt1]) == -1)
/*      */       {
/*  632 */         throw new ClassfileFormatException("Bad string indirection index, cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
/*      */       }
/*      */       
/*  635 */       if (i == 0)
/*      */       {
/*  637 */         return 0;
/*      */       }
/*  639 */       paramInt2 = i;
/*  640 */     } else if (i == 12) {
/*      */ 
/*      */       
/*  643 */       if ((i = this.indirectStringRefs[paramInt1]) == -1)
/*      */       {
/*  645 */         throw new ClassfileFormatException("Bad string indirection index, cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
/*      */       }
/*      */ 
/*      */       
/*  649 */       if ((paramInt2 = ((paramInt2 == 0) ? (i >> 16) : i) & 0xFFFF) == 0)
/*      */       {
/*  651 */         throw new ClassfileFormatException("Bad string indirection index, cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
/*      */       }
/*      */       
/*  654 */       paramInt2 = paramInt2;
/*      */     } else {
/*  656 */       throw new ClassfileFormatException("Wrong tag number " + i + " at constant pool index " + paramInt1 + ", cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
/*      */     } 
/*      */ 
/*      */     
/*  660 */     if (paramInt2 <= 0 || paramInt2 >= this.cpCount) {
/*  661 */       throw new ClassfileFormatException("Constant pool index " + paramInt1 + ", should be in range [1, " + (this.cpCount - 1) + "] -- cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
/*      */     }
/*      */ 
/*      */     
/*  665 */     return this.entryOffset[paramInt2];
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
/*      */   private String getConstantPoolString(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/*  687 */     if ((paramInt = getConstantPoolStringOffset(paramInt, 0)) == 0) {
/*  688 */       return null;
/*      */     }
/*      */     int i;
/*  691 */     if ((i = this.reader.readUnsignedShort(paramInt)) == 0) {
/*  692 */       return "";
/*      */     }
/*  694 */     return intern(this.reader
/*  695 */         .readString(paramInt + 2L, i, paramBoolean1, paramBoolean2));
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
/*      */   private String getConstantPoolString(int paramInt1, int paramInt2) {
/*  715 */     if ((paramInt1 = getConstantPoolStringOffset(paramInt1, paramInt2)) == 0) {
/*  716 */       return null;
/*      */     }
/*      */     
/*  719 */     if ((paramInt2 = this.reader.readUnsignedShort(paramInt1)) == 0) {
/*  720 */       return "";
/*      */     }
/*  722 */     return intern(this.reader.readString(paramInt1 + 2L, paramInt2, false, false));
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
/*      */   private String getConstantPoolString(int paramInt) {
/*  738 */     return getConstantPoolString(paramInt, 0);
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
/*      */   private byte getConstantPoolStringFirstByte(int paramInt) {
/*  754 */     if ((paramInt = getConstantPoolStringOffset(paramInt, 0)) == 0) {
/*  755 */       return 0;
/*      */     }
/*      */     int i;
/*  758 */     if ((i = this.reader.readUnsignedShort(paramInt)) == 0) {
/*  759 */       return 0;
/*      */     }
/*  761 */     return this.reader.readByte(paramInt + 2L);
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
/*      */   private String getConstantPoolClassName(int paramInt) {
/*  776 */     return getConstantPoolString(paramInt, true, false);
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
/*      */   private String getConstantPoolClassDescriptor(int paramInt) {
/*  793 */     return getConstantPoolString(paramInt, true, true);
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
/*      */   private boolean constantPoolStringEquals(int paramInt, String paramString) {
/*  813 */     if ((paramInt = getConstantPoolStringOffset(paramInt, 0)) == 0)
/*  814 */       return (paramString == null); 
/*  815 */     if (paramString == null) {
/*  816 */       return false;
/*      */     }
/*  818 */     int i = this.reader.readUnsignedShort(paramInt);
/*  819 */     int j = paramString.length();
/*  820 */     if (i != j) {
/*  821 */       return false;
/*      */     }
/*  823 */     paramInt += 2;
/*  824 */     this.reader.bufferTo(paramInt + i);
/*  825 */     byte[] arrayOfByte = this.reader.buf();
/*  826 */     for (byte b = 0; b < i; b++) {
/*  827 */       if ((char)(arrayOfByte[paramInt + b] & 0xFF) != paramString.charAt(b)) {
/*  828 */         return false;
/*      */       }
/*      */     } 
/*  831 */     return true;
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
/*      */   private int cpReadInt(int paramInt) {
/*  846 */     if (paramInt <= 0 || paramInt >= this.cpCount) {
/*  847 */       throw new ClassfileFormatException("Constant pool index " + paramInt + ", should be in range [1, " + (this.cpCount - 1) + "] -- cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
/*      */     }
/*      */ 
/*      */     
/*  851 */     return this.reader.readInt(this.entryOffset[paramInt]);
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
/*      */   private long cpReadLong(int paramInt) {
/*  864 */     if (paramInt <= 0 || paramInt >= this.cpCount) {
/*  865 */       throw new ClassfileFormatException("Constant pool index " + paramInt + ", should be in range [1, " + (this.cpCount - 1) + "] -- cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
/*      */     }
/*      */ 
/*      */     
/*  869 */     return this.reader.readLong(this.entryOffset[paramInt]);
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
/*      */   private Object getFieldConstantPoolValue(int paramInt1, char paramChar, int paramInt2) {
/*  891 */     switch (paramInt1) {
/*      */       
/*      */       case 1:
/*      */       case 7:
/*      */       case 8:
/*  896 */         return getConstantPoolString(paramInt2);
/*      */       case 3:
/*  898 */         paramInt1 = cpReadInt(paramInt2);
/*  899 */         switch (paramChar) {
/*      */           case 'I':
/*  901 */             return Integer.valueOf(paramInt1);
/*      */           case 'S':
/*  903 */             return Short.valueOf((short)paramInt1);
/*      */           case 'C':
/*  905 */             return Character.valueOf((char)paramInt1);
/*      */           case 'B':
/*  907 */             return Byte.valueOf((byte)paramInt1);
/*      */           case 'Z':
/*  909 */             return Boolean.valueOf((paramInt1 != 0));
/*      */         } 
/*      */ 
/*      */         
/*  913 */         throw new ClassfileFormatException("Unknown Constant_INTEGER type " + paramChar + ", cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
/*      */ 
/*      */       
/*      */       case 4:
/*  917 */         return Float.valueOf(Float.intBitsToFloat(cpReadInt(paramInt2)));
/*      */       case 5:
/*  919 */         return Long.valueOf(cpReadLong(paramInt2));
/*      */       case 6:
/*  921 */         return Double.valueOf(Double.longBitsToDouble(cpReadLong(paramInt2)));
/*      */     } 
/*      */ 
/*      */     
/*  925 */     throw new ClassfileFormatException("Unknown field constant pool tag " + paramInt1 + ", cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
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
/*      */   private AnnotationInfo readAnnotation() {
/*  942 */     String str = getConstantPoolClassDescriptor(this.reader.readUnsignedShort());
/*  943 */     int i = this.reader.readUnsignedShort();
/*  944 */     AnnotationParameterValueList annotationParameterValueList = null;
/*  945 */     if (i > 0) {
/*  946 */       annotationParameterValueList = new AnnotationParameterValueList(i);
/*  947 */       for (byte b = 0; b < i; b++) {
/*  948 */         String str1 = getConstantPoolString(this.reader.readUnsignedShort());
/*  949 */         Object object = readAnnotationElementValue();
/*  950 */         annotationParameterValueList.add(new AnnotationParameterValue(str1, object));
/*      */       } 
/*      */     } 
/*  953 */     return new AnnotationInfo(str, annotationParameterValueList);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private Object readAnnotationElementValue() {
/*      */     String str1;
/*      */     Object[] arrayOfObject;
/*      */     String str2;
/*      */     int i;
/*      */     byte b;
/*      */     char c;
/*  965 */     switch (c = (char)this.reader.readUnsignedByte()) {
/*      */       case 'B':
/*  967 */         return Byte.valueOf((byte)cpReadInt(this.reader.readUnsignedShort()));
/*      */       case 'C':
/*  969 */         return Character.valueOf((char)cpReadInt(this.reader.readUnsignedShort()));
/*      */       case 'D':
/*  971 */         return Double.valueOf(Double.longBitsToDouble(cpReadLong(this.reader.readUnsignedShort())));
/*      */       case 'F':
/*  973 */         return Float.valueOf(Float.intBitsToFloat(cpReadInt(this.reader.readUnsignedShort())));
/*      */       case 'I':
/*  975 */         return Integer.valueOf(cpReadInt(this.reader.readUnsignedShort()));
/*      */       case 'J':
/*  977 */         return Long.valueOf(cpReadLong(this.reader.readUnsignedShort()));
/*      */       case 'S':
/*  979 */         return Short.valueOf((short)cpReadInt(this.reader.readUnsignedShort()));
/*      */       case 'Z':
/*  981 */         return Boolean.valueOf((cpReadInt(this.reader.readUnsignedShort()) != 0));
/*      */       case 's':
/*  983 */         return getConstantPoolString(this.reader.readUnsignedShort());
/*      */       
/*      */       case 'e':
/*  986 */         str1 = getConstantPoolClassDescriptor(this.reader.readUnsignedShort());
/*  987 */         str2 = getConstantPoolString(this.reader.readUnsignedShort());
/*  988 */         return new AnnotationEnumValue(str1, str2);
/*      */ 
/*      */       
/*      */       case 'c':
/*  992 */         str1 = getConstantPoolString(this.reader.readUnsignedShort());
/*  993 */         return new AnnotationClassRef(str1);
/*      */       
/*      */       case '@':
/*  996 */         return readAnnotation();
/*      */ 
/*      */       
/*      */       case '[':
/* 1000 */         arrayOfObject = new Object[i = this.reader.readUnsignedShort()];
/* 1001 */         for (b = 0; b < i; b++)
/*      */         {
/* 1003 */           arrayOfObject[b] = readAnnotationElementValue();
/*      */         }
/* 1005 */         return arrayOfObject;
/*      */     } 
/* 1007 */     throw new ClassfileFormatException("Class " + this.className + " has unknown annotation element type tag '" + (char)arrayOfObject + "': element size unknown, cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class TypePathNode
/*      */   {
/*      */     short typePathKind;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     short typeArgumentIdx;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TypePathNode(int param1Int1, int param1Int2) {
/* 1032 */       this.typePathKind = (short)param1Int1;
/* 1033 */       this.typeArgumentIdx = (short)param1Int2;
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1038 */       return "(" + this.typePathKind + "," + this.typeArgumentIdx + ")";
/*      */     }
/*      */   }
/*      */   
/*      */   private List<TypePathNode> readTypePath() {
/*      */     int i;
/* 1044 */     if ((i = this.reader.readUnsignedByte()) == 0) {
/* 1045 */       return Collections.emptyList();
/*      */     }
/* 1047 */     ArrayList<TypePathNode> arrayList = new ArrayList(i);
/* 1048 */     for (byte b = 0; b < i; b++) {
/* 1049 */       int j = this.reader.readUnsignedByte();
/* 1050 */       int k = this.reader.readUnsignedByte();
/* 1051 */       arrayList.add(new TypePathNode(j, k));
/*      */     } 
/* 1053 */     return arrayList;
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
/*      */   private void readConstantPoolEntries(LogNode paramLogNode) {
/* 1069 */     ArrayList<Integer> arrayList1 = null;
/* 1070 */     ArrayList<Integer> arrayList2 = null;
/* 1071 */     if (this.scanSpec.enableInterClassDependencies) {
/* 1072 */       arrayList1 = new ArrayList();
/* 1073 */       arrayList2 = new ArrayList();
/*      */     } 
/*      */ 
/*      */     
/* 1077 */     this.cpCount = this.reader.readUnsignedShort();
/*      */ 
/*      */     
/* 1080 */     this.entryOffset = new int[this.cpCount];
/* 1081 */     this.entryTag = new int[this.cpCount];
/* 1082 */     this.indirectStringRefs = new int[this.cpCount];
/* 1083 */     Arrays.fill(this.indirectStringRefs, 0, this.cpCount, -1);
/*      */     
/*      */     int i;
/* 1086 */     for (byte b = 1; b < this.cpCount; b++) {
/* 1087 */       if (i == 1) {
/*      */         
/* 1089 */         i = 0;
/*      */       } else {
/*      */         int j, k;
/* 1092 */         this.entryTag[b] = this.reader.readUnsignedByte();
/* 1093 */         this.entryOffset[b] = this.reader.currPos();
/* 1094 */         switch (this.entryTag[b]) {
/*      */           case 0:
/* 1096 */             throw new ClassfileFormatException("Invalid constant pool tag 0 in classfile " + this.relativePath + " (possible buffer underflow issue). Please report this at https://github.com/classgraph/classgraph/issues");
/*      */ 
/*      */           
/*      */           case 1:
/* 1100 */             j = this.reader.readUnsignedShort();
/* 1101 */             this.reader.skip(j);
/*      */             break;
/*      */           
/*      */           case 3:
/*      */           case 4:
/* 1106 */             this.reader.skip(4);
/*      */             break;
/*      */           case 5:
/*      */           case 6:
/* 1110 */             this.reader.skip(8);
/* 1111 */             i = 1;
/*      */             break;
/*      */           
/*      */           case 7:
/* 1115 */             this.indirectStringRefs[b] = this.reader.readUnsignedShort();
/* 1116 */             if (arrayList1 != null)
/*      */             {
/* 1118 */               arrayList1.add(Integer.valueOf(this.indirectStringRefs[b]));
/*      */             }
/*      */             break;
/*      */           
/*      */           case 8:
/* 1123 */             this.indirectStringRefs[b] = this.reader.readUnsignedShort();
/*      */             break;
/*      */           
/*      */           case 9:
/* 1127 */             this.reader.skip(4);
/*      */             break;
/*      */           
/*      */           case 10:
/* 1131 */             this.reader.skip(4);
/*      */             break;
/*      */           
/*      */           case 11:
/* 1135 */             this.reader.skip(4);
/*      */             break;
/*      */           case 12:
/* 1138 */             k = this.reader.readUnsignedShort();
/* 1139 */             j = this.reader.readUnsignedShort();
/* 1140 */             if (arrayList2 != null) {
/* 1141 */               arrayList2.add(Integer.valueOf(j));
/*      */             }
/* 1143 */             this.indirectStringRefs[b] = k << 16 | j;
/*      */             break;
/*      */           
/*      */           case 15:
/* 1147 */             this.reader.skip(3);
/*      */             break;
/*      */           case 16:
/* 1150 */             this.reader.skip(2);
/*      */             break;
/*      */           case 17:
/* 1153 */             this.reader.skip(4);
/*      */             break;
/*      */           case 18:
/* 1156 */             this.reader.skip(4);
/*      */             break;
/*      */           
/*      */           case 19:
/* 1160 */             this.indirectStringRefs[b] = this.reader.readUnsignedShort();
/*      */             break;
/*      */           
/*      */           case 20:
/* 1164 */             this.reader.skip(2);
/*      */             break;
/*      */           default:
/* 1167 */             throw new ClassfileFormatException("Unknown constant pool tag " + this.entryTag[b] + " (element size unknown, cannot continue reading class). Please report this at https://github.com/classgraph/classgraph/issues");
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       } 
/*      */     } 
/* 1178 */     if (arrayList1 != null) {
/* 1179 */       this.refdClassNames = new HashSet<>();
/*      */       
/* 1181 */       for (Iterator<Integer> iterator = arrayList1.iterator(); iterator.hasNext(); ) { i = ((Integer)iterator.next()).intValue();
/*      */         
/*      */         String str;
/* 1184 */         if ((str = getConstantPoolString(i, true, false)) != null) {
/* 1185 */           if (str.startsWith("[")) {
/*      */             try {
/*      */               TypeSignature typeSignature;
/*      */ 
/*      */               
/* 1190 */               (typeSignature = TypeSignature.parse(str.replace('.', '/'), (String)null)).findReferencedClassNames(this.refdClassNames);
/* 1191 */             } catch (ParseException parseException) {
/*      */               
/* 1193 */               throw new ClassfileFormatException("Could not parse class name: " + str, parseException);
/*      */             }  continue;
/*      */           } 
/* 1196 */           this.refdClassNames.add(str);
/*      */         }  }
/*      */     
/*      */     } 
/*      */     
/* 1201 */     if (arrayList2 != null)
/*      */     {
/* 1203 */       for (Iterator<Integer> iterator = arrayList2.iterator(); iterator.hasNext(); ) { i = ((Integer)iterator.next()).intValue();
/*      */         String str;
/* 1205 */         if ((str = getConstantPoolString(i)) != null) {
/*      */           try {
/* 1207 */             if (str.startsWith("L") && str.endsWith(";")) {
/*      */               TypeSignature typeSignature;
/*      */ 
/*      */ 
/*      */               
/* 1212 */               (typeSignature = TypeSignature.parse(str, (String)null)).findReferencedClassNames(this.refdClassNames); continue;
/* 1213 */             }  if (str.indexOf('(') >= 0 || "<init>".equals(str)) {
/*      */               MethodTypeSignature methodTypeSignature;
/*      */ 
/*      */ 
/*      */               
/* 1218 */               (methodTypeSignature = MethodTypeSignature.parse(str, null)).findReferencedClassNames(this.refdClassNames); continue;
/*      */             } 
/* 1220 */             if (paramLogNode != null) {
/* 1221 */               paramLogNode.log("Could not extract referenced class names from constant pool string: " + str);
/*      */             
/*      */             }
/*      */           }
/* 1225 */           catch (ParseException parseException) {
/* 1226 */             if (paramLogNode != null) {
/* 1227 */               paramLogNode.log("Could not extract referenced class names from constant pool string: " + str + " : " + parseException);
/*      */             }
/*      */           } 
/*      */         } }
/*      */     
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
/*      */   private void readBasicClassInfo() {
/* 1251 */     this.classModifiers = this.reader.readUnsignedShort();
/*      */     
/* 1253 */     this.isInterface = ((this.classModifiers & 0x200) != 0);
/* 1254 */     this.isAnnotation = ((this.classModifiers & 0x2000) != 0);
/*      */     
/*      */     String str;
/*      */     
/* 1258 */     if ((str = getConstantPoolString(this.reader.readUnsignedShort())) == null) {
/* 1259 */       throw new ClassfileFormatException("Class name is null");
/*      */     }
/* 1261 */     this.className = str.replace('/', '.');
/* 1262 */     if ("java.lang.Object".equals(this.className))
/*      */     {
/*      */       
/* 1265 */       throw new SkipClassException("No need to scan java.lang.Object");
/*      */     }
/*      */ 
/*      */     
/* 1269 */     int j = ((this.classModifiers & 0x8000) != 0) ? 1 : 0;
/* 1270 */     boolean bool = this.relativePath.regionMatches(this.relativePath.lastIndexOf('/') + 1, "package-info.class", 0, 18);
/*      */     
/* 1272 */     if (!this.scanSpec.ignoreClassVisibility && !Modifier.isPublic(this.classModifiers) && !j && !bool) {
/* 1273 */       throw new SkipClassException("Class is not public, and ignoreClassVisibility() was not called");
/*      */     }
/*      */ 
/*      */     
/* 1277 */     if (!this.relativePath.endsWith(".class"))
/*      */     {
/* 1279 */       throw new SkipClassException("Classfile filename " + this.relativePath + " does not end in \".class\"");
/*      */     }
/* 1281 */     j = str.length();
/* 1282 */     if (this.relativePath.length() != j + 6 || !str.regionMatches(0, this.relativePath, 0, j)) {
/* 1283 */       throw new SkipClassException("Relative path " + this.relativePath + " does not match class name " + this.className);
/*      */     }
/*      */ 
/*      */     
/*      */     int i;
/*      */     
/* 1289 */     if ((i = this.reader.readUnsignedShort()) > 0) {
/* 1290 */       this.superclassName = getConstantPoolClassName(i);
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
/*      */   private void readInterfaces() {
/* 1304 */     int i = this.reader.readUnsignedShort();
/* 1305 */     for (byte b = 0; b < i; b++) {
/* 1306 */       String str = getConstantPoolClassName(this.reader.readUnsignedShort());
/* 1307 */       if (this.implementedInterfaces == null) {
/* 1308 */         this.implementedInterfaces = new ArrayList<>();
/*      */       }
/* 1310 */       this.implementedInterfaces.add(str);
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
/*      */   private void readFields() {
/* 1326 */     int i = this.reader.readUnsignedShort();
/* 1327 */     for (byte b = 0; b < i; b++) {
/*      */       int j;
/*      */ 
/*      */       
/* 1331 */       boolean bool1 = ((bool1 = (((j = this.reader.readUnsignedShort()) & 0x1) == 1) ? true : false) || this.scanSpec.ignoreFieldVisibility) ? true : false;
/* 1332 */       boolean bool2 = (this.scanSpec.enableStaticFinalFieldConstantInitializerValues && bool1) ? true : false;
/*      */       
/* 1334 */       ArrayList<TypeAnnotationDecorator> arrayList = null;
/* 1335 */       if (!bool1 || (!this.scanSpec.enableFieldInfo && !bool2)) {
/*      */         
/* 1337 */         this.reader.readUnsignedShort();
/* 1338 */         this.reader.readUnsignedShort();
/* 1339 */         int k = this.reader.readUnsignedShort();
/* 1340 */         for (byte b1 = 0; b1 < k; b1++) {
/* 1341 */           this.reader.readUnsignedShort();
/* 1342 */           int m = this.reader.readInt();
/* 1343 */           this.reader.skip(m);
/*      */         } 
/*      */       } else {
/* 1346 */         int k = this.reader.readUnsignedShort();
/* 1347 */         String str1 = getConstantPoolString(k);
/* 1348 */         int m = this.reader.readUnsignedShort();
/* 1349 */         k = (char)getConstantPoolStringFirstByte(m);
/*      */ 
/*      */         
/* 1352 */         String str3 = null;
/* 1353 */         String str2 = getConstantPoolString(m);
/*      */         
/* 1355 */         Object object = null;
/* 1356 */         AnnotationInfoList annotationInfoList = null;
/* 1357 */         int n = this.reader.readUnsignedShort();
/* 1358 */         for (byte b1 = 0; b1 < n; b1++) {
/* 1359 */           int i1 = this.reader.readUnsignedShort();
/* 1360 */           int i2 = this.reader.readInt();
/*      */ 
/*      */           
/* 1363 */           if (bool2 && 
/* 1364 */             constantPoolStringEquals(i1, "ConstantValue")) {
/*      */ 
/*      */             
/* 1367 */             if ((i1 = this.reader.readUnsignedShort()) <= 0 || i1 >= this.cpCount) {
/* 1368 */               throw new ClassfileFormatException("Constant pool index " + i1 + ", should be in range [1, " + (this.cpCount - 1) + "] -- cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
/*      */             }
/*      */ 
/*      */ 
/*      */             
/* 1373 */             object = getFieldConstantPoolValue(this.entryTag[i1], k, i1);
/*      */           }
/* 1375 */           else if (bool1 && constantPoolStringEquals(i1, "Signature")) {
/* 1376 */             str3 = getConstantPoolString(this.reader.readUnsignedShort());
/* 1377 */           } else if (this.scanSpec.enableAnnotationInfo && (
/* 1378 */             constantPoolStringEquals(i1, "RuntimeVisibleAnnotations") || (!this.scanSpec.disableRuntimeInvisibleAnnotations && 
/* 1379 */             constantPoolStringEquals(i1, "RuntimeInvisibleAnnotations")))) {
/*      */ 
/*      */ 
/*      */             
/* 1383 */             if ((i1 = this.reader.readUnsignedShort()) > 0) {
/* 1384 */               if (annotationInfoList == null) {
/* 1385 */                 annotationInfoList = new AnnotationInfoList(1);
/*      */               }
/* 1387 */               for (i2 = 0; i2 < i1; i2++) {
/* 1388 */                 final AnnotationInfo annotationInfo = readAnnotation();
/* 1389 */                 annotationInfoList.add(annotationInfo);
/*      */               } 
/*      */             } 
/* 1392 */           } else if (this.scanSpec.enableAnnotationInfo && (
/* 1393 */             constantPoolStringEquals(i1, "RuntimeVisibleTypeAnnotations") || (!this.scanSpec.disableRuntimeInvisibleAnnotations && 
/* 1394 */             constantPoolStringEquals(i1, "RuntimeInvisibleTypeAnnotations")))) {
/*      */ 
/*      */             
/* 1397 */             if ((i1 = this.reader.readUnsignedShort()) > 0) {
/* 1398 */               arrayList = new ArrayList();
/* 1399 */               for (i2 = 0; i2 < i1; i2++) {
/*      */                 int i3;
/* 1401 */                 if ((i3 = this.reader.readUnsignedByte()) != 19) {
/* 1402 */                   throw new ClassfileFormatException("Class " + this.className + " has unknown field type annotation target 0x" + 
/*      */                       
/* 1404 */                       Integer.toHexString(i3) + ": element size unknown, cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
/*      */                 }
/*      */ 
/*      */ 
/*      */                 
/* 1409 */                 final List<TypePathNode> typePath = readTypePath();
/* 1410 */                 final AnnotationInfo annotationInfo = readAnnotation();
/* 1411 */                 arrayList.add(new TypeAnnotationDecorator()
/*      */                     {
/*      */                       public void decorate(TypeSignature param1TypeSignature) {
/* 1414 */                         param1TypeSignature.addTypeAnnotation(typePath, annotationInfo);
/*      */                       }
/*      */                     });
/*      */               } 
/*      */             } 
/*      */           } else {
/*      */             
/* 1421 */             this.reader.skip(i2);
/*      */           } 
/*      */         } 
/* 1424 */         if (this.scanSpec.enableFieldInfo && bool1) {
/* 1425 */           if (this.fieldInfoList == null) {
/* 1426 */             this.fieldInfoList = new FieldInfoList();
/*      */           }
/* 1428 */           this.fieldInfoList.add(new FieldInfo(this.className, str1, j, str2, str3, object, annotationInfoList, arrayList));
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void readMethods() {
/* 1448 */     int i = this.reader.readUnsignedShort();
/* 1449 */     for (byte b = 0; b < i; b++) {
/*      */       int j;
/*      */ 
/*      */       
/* 1453 */       byte b1 = ((b1 = (((j = this.reader.readUnsignedShort()) & 0x1) == 1) ? 1 : 0) || this.scanSpec.ignoreMethodVisibility) ? 1 : 0;
/* 1454 */       ArrayList<MethodTypeAnnotationDecorator> arrayList = null;
/* 1455 */       String str1 = null;
/* 1456 */       String str2 = null;
/* 1457 */       String str3 = null;
/*      */       
/*      */       boolean bool1;
/* 1460 */       if ((bool1 = (this.scanSpec.enableMethodInfo || this.isAnnotation) ? true : false) || this.isAnnotation) {
/* 1461 */         int i1 = this.reader.readUnsignedShort();
/* 1462 */         str1 = getConstantPoolString(i1);
/* 1463 */         int i2 = this.reader.readUnsignedShort();
/* 1464 */         str2 = getConstantPoolString(i2);
/*      */       } else {
/* 1466 */         this.reader.skip(4);
/*      */       } 
/* 1468 */       int k = this.reader.readUnsignedShort();
/* 1469 */       String[] arrayOfString1 = null;
/* 1470 */       String[] arrayOfString2 = null;
/* 1471 */       int[] arrayOfInt = null;
/* 1472 */       AnnotationInfo[][] arrayOfAnnotationInfo = (AnnotationInfo[][])null;
/* 1473 */       AnnotationInfoList annotationInfoList = null;
/* 1474 */       boolean bool2 = false;
/* 1475 */       int m = 0;
/* 1476 */       int n = 0;
/* 1477 */       if (!b1 || (!bool1 && !this.isAnnotation)) {
/*      */         
/* 1479 */         for (b1 = 0; b1 < k; b1++) {
/* 1480 */           this.reader.skip(2);
/* 1481 */           int i1 = this.reader.readInt();
/* 1482 */           this.reader.skip(i1);
/*      */         } 
/*      */       } else {
/*      */         
/* 1486 */         for (b1 = 0; b1 < k; b1++) {
/* 1487 */           int i1 = this.reader.readUnsignedShort();
/* 1488 */           int i2 = this.reader.readInt();
/* 1489 */           if (this.scanSpec.enableAnnotationInfo && (
/* 1490 */             constantPoolStringEquals(i1, "RuntimeVisibleAnnotations") || (!this.scanSpec.disableRuntimeInvisibleAnnotations && 
/* 1491 */             constantPoolStringEquals(i1, "RuntimeInvisibleAnnotations")))) {
/*      */ 
/*      */             
/* 1494 */             if ((i1 = this.reader.readUnsignedShort()) > 0) {
/* 1495 */               if (annotationInfoList == null) {
/* 1496 */                 annotationInfoList = new AnnotationInfoList(1);
/*      */               }
/* 1498 */               for (i2 = 0; i2 < i1; i2++) {
/* 1499 */                 final AnnotationInfo annotationInfo = readAnnotation();
/* 1500 */                 annotationInfoList.add(annotationInfo);
/*      */               } 
/*      */             } 
/* 1503 */           } else if (this.scanSpec.enableAnnotationInfo && (
/* 1504 */             constantPoolStringEquals(i1, "RuntimeVisibleParameterAnnotations") || (!this.scanSpec.disableRuntimeInvisibleAnnotations && 
/* 1505 */             constantPoolStringEquals(i1, "RuntimeInvisibleParameterAnnotations")))) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1512 */             i1 = this.reader.readUnsignedByte();
/* 1513 */             if (arrayOfAnnotationInfo == null) {
/* 1514 */               arrayOfAnnotationInfo = new AnnotationInfo[i1][];
/* 1515 */             } else if (arrayOfAnnotationInfo.length != i1) {
/* 1516 */               throw new ClassfileFormatException("Mismatch in number of parameters between RuntimeVisibleParameterAnnotations and RuntimeInvisibleParameterAnnotations");
/*      */             } 
/*      */ 
/*      */             
/* 1520 */             for (i2 = 0; i2 < i1; i2++) {
/*      */               final int targetType;
/* 1522 */               if ((i3 = this.reader.readUnsignedShort()) > 0) {
/* 1523 */                 final int throwsTypeIndex = 0;
/* 1524 */                 if (arrayOfAnnotationInfo[i2] != null) {
/* 1525 */                   i4 = (arrayOfAnnotationInfo[i2]).length;
/* 1526 */                   arrayOfAnnotationInfo[i2] = Arrays.<AnnotationInfo>copyOf(arrayOfAnnotationInfo[i2], i4 + i3);
/*      */                 } else {
/*      */                   
/* 1529 */                   arrayOfAnnotationInfo[i2] = new AnnotationInfo[i3];
/*      */                 } 
/* 1531 */                 for (final byte typeParameterIndex = 0; b2 < i3; b2++) {
/* 1532 */                   arrayOfAnnotationInfo[i2][i4 + b2] = readAnnotation();
/*      */                 }
/* 1534 */               } else if (arrayOfAnnotationInfo[i2] == null) {
/* 1535 */                 arrayOfAnnotationInfo[i2] = NO_ANNOTATIONS;
/*      */               } 
/*      */             } 
/* 1538 */           } else if (this.scanSpec.enableAnnotationInfo && (
/* 1539 */             constantPoolStringEquals(i1, "RuntimeVisibleTypeAnnotations") || (!this.scanSpec.disableRuntimeInvisibleAnnotations && 
/* 1540 */             constantPoolStringEquals(i1, "RuntimeInvisibleTypeAnnotations")))) {
/*      */ 
/*      */             
/* 1543 */             if ((i1 = this.reader.readUnsignedShort()) > 0) {
/* 1544 */               arrayList = new ArrayList(i1);
/* 1545 */               for (i2 = 0; i2 < i1; i2++) {
/*      */                 final byte typeParameterIndex, boundIndex, formalParameterIndex;
/*      */ 
/*      */                 
/*      */                 final int throwsTypeIndex, targetType;
/*      */                 
/* 1551 */                 if ((i3 = this.reader.readUnsignedByte()) == 1) {
/*      */                   
/* 1553 */                   b2 = this.reader.readUnsignedByte();
/* 1554 */                   b3 = -1;
/* 1555 */                   b4 = -1;
/* 1556 */                   i4 = -1;
/* 1557 */                 } else if (i3 == 18) {
/*      */ 
/*      */                   
/* 1560 */                   b2 = this.reader.readUnsignedByte();
/* 1561 */                   b3 = this.reader.readUnsignedByte();
/* 1562 */                   b4 = -1;
/* 1563 */                   i4 = -1;
/* 1564 */                 } else if (i3 == 19) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1571 */                   b2 = -1;
/* 1572 */                   b3 = -1;
/* 1573 */                   b4 = -1;
/* 1574 */                   i4 = -1;
/* 1575 */                 } else if (i3 == 20) {
/*      */ 
/*      */                   
/* 1578 */                   b2 = -1;
/* 1579 */                   b3 = -1;
/* 1580 */                   b4 = -1;
/* 1581 */                   i4 = -1;
/* 1582 */                 } else if (i3 == 21) {
/*      */ 
/*      */                   
/* 1585 */                   b2 = -1;
/* 1586 */                   b3 = -1;
/* 1587 */                   b4 = -1;
/* 1588 */                   i4 = -1;
/* 1589 */                 } else if (i3 == 22) {
/*      */ 
/*      */                   
/* 1592 */                   b2 = -1;
/* 1593 */                   b3 = -1;
/* 1594 */                   b4 = this.reader.readUnsignedByte();
/* 1595 */                   i4 = -1;
/* 1596 */                 } else if (i3 == 23) {
/*      */                   
/* 1598 */                   b2 = -1;
/* 1599 */                   b3 = -1;
/* 1600 */                   b4 = -1;
/* 1601 */                   i4 = this.reader.readUnsignedShort();
/*      */                 } else {
/* 1603 */                   throw new ClassfileFormatException("Class " + this.className + " has unknown method type annotation target 0x" + 
/*      */                       
/* 1605 */                       Integer.toHexString(i3) + ": element size unknown, cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
/*      */                 } 
/*      */ 
/*      */ 
/*      */                 
/* 1610 */                 final List<TypePathNode> typePath = readTypePath();
/* 1611 */                 final AnnotationInfo annotationInfo = readAnnotation();
/* 1612 */                 arrayList.add(new MethodTypeAnnotationDecorator() { public void decorate(MethodTypeSignature param1MethodTypeSignature) {
/*      */                         List<TypeParameter> list1;
/*      */                         List<ReferenceTypeSignature> list;
/* 1615 */                         if (targetType == 1) {
/*      */ 
/*      */ 
/*      */                           
/* 1619 */                           if ((list1 = param1MethodTypeSignature.getTypeParameters()) != null && typeParameterIndex < list1
/* 1620 */                             .size()) {
/* 1621 */                             ((TypeParameter)list1.get(typeParameterIndex)).addTypeAnnotation(typePath, annotationInfo);
/*      */                           }
/*      */                           
/*      */                           return;
/*      */                         } 
/* 1626 */                         if (targetType == 18) {
/*      */ 
/*      */ 
/*      */ 
/*      */                           
/* 1631 */                           if ((list1 = list1.getTypeParameters()) != null && typeParameterIndex < list1
/* 1632 */                             .size()) {
/*      */                             ReferenceTypeSignature referenceTypeSignature;
/* 1634 */                             TypeParameter typeParameter = list1.get(typeParameterIndex);
/*      */                             
/* 1636 */                             if (boundIndex == 0) {
/*      */ 
/*      */                               
/* 1639 */                               if ((referenceTypeSignature = typeParameter.getClassBound()) != null) {
/* 1640 */                                 referenceTypeSignature.addTypeAnnotation(typePath, annotationInfo);
/*      */                               }
/*      */                             }
/*      */                             else {
/*      */                               
/* 1645 */                               if ((list = referenceTypeSignature.getInterfaceBounds()) != null && boundIndex - 1 < list
/* 1646 */                                 .size())
/* 1647 */                                 ((ReferenceTypeSignature)list.get(boundIndex - 1))
/* 1648 */                                   .addTypeAnnotation(typePath, annotationInfo);  return;
/*      */                             } 
/*      */                           } else {
/*      */                             return;
/*      */                           } 
/*      */                         } else {
/* 1654 */                           if (targetType == 20) {
/*      */                             
/* 1656 */                             list.getResultType().addTypeAnnotation(typePath, annotationInfo); return;
/*      */                           } 
/* 1658 */                           if (targetType == 21) {
/*      */                             
/* 1660 */                             list.addRecieverTypeAnnotation(annotationInfo); return;
/* 1661 */                           }  if (targetType == 22) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                             
/* 1676 */                             list = (List)list.getParameterTypeSignatures();
/* 1677 */                             if (formalParameterIndex < list.size())
/* 1678 */                               ((TypeSignature)list.get(formalParameterIndex))
/* 1679 */                                 .addTypeAnnotation(typePath, annotationInfo);  return;
/*      */                           } 
/* 1681 */                           if (targetType == 23)
/*      */                           {
/*      */ 
/*      */                             
/* 1685 */                             if ((list = (List)list.getThrowsSignatures()) != null && throwsTypeIndex < list
/* 1686 */                               .size()) {
/* 1687 */                               ((ClassRefOrTypeVariableSignature)list.get(throwsTypeIndex)).addTypeAnnotation(typePath, annotationInfo);
/*      */                             }
/*      */                           }
/*      */                         } 
/*      */                       } }
/*      */                   );
/*      */               } 
/*      */             } 
/* 1695 */           } else if (constantPoolStringEquals(i1, "MethodParameters")) {
/*      */ 
/*      */ 
/*      */             
/* 1699 */             arrayOfString1 = new String[i1 = this.reader.readUnsignedByte()];
/* 1700 */             arrayOfInt = new int[i1];
/* 1701 */             for (i2 = 0; i2 < i1; i2++) {
/* 1702 */               final int targetType = this.reader.readUnsignedShort();
/*      */               
/* 1704 */               arrayOfString1[i2] = (i3 == 0) ? null : getConstantPoolString(i3);
/* 1705 */               arrayOfInt[i2] = this.reader.readUnsignedShort();
/*      */             } 
/* 1707 */           } else if (constantPoolStringEquals(i1, "Signature")) {
/*      */             
/* 1709 */             str3 = getConstantPoolString(this.reader.readUnsignedShort());
/* 1710 */           } else if (constantPoolStringEquals(i1, "AnnotationDefault")) {
/* 1711 */             if (this.annotationParamDefaultValues == null) {
/* 1712 */               this.annotationParamDefaultValues = new AnnotationParameterValueList();
/*      */             }
/* 1714 */             this.annotationParamDefaultValues.add(new AnnotationParameterValue(str1, 
/*      */                   
/* 1716 */                   readAnnotationElementValue()));
/* 1717 */           } else if (constantPoolStringEquals(i1, "Exceptions")) {
/*      */             
/* 1719 */             arrayOfString2 = new String[i1 = this.reader.readUnsignedShort()];
/* 1720 */             for (i2 = 0; i2 < i1; i2++) {
/* 1721 */               final int targetType = this.reader.readUnsignedShort();
/* 1722 */               arrayOfString2[i2] = getConstantPoolClassName(i3);
/*      */             } 
/* 1724 */           } else if (constantPoolStringEquals(i1, "Code")) {
/* 1725 */             bool2 = true;
/* 1726 */             this.reader.skip(4);
/* 1727 */             i1 = this.reader.readInt();
/* 1728 */             this.reader.skip(i1);
/* 1729 */             i2 = this.reader.readUnsignedShort();
/* 1730 */             this.reader.skip(i2 * 8);
/* 1731 */             final int targetType = this.reader.readUnsignedShort();
/* 1732 */             for (final byte typeParameterIndex = 0; b2 < i3; b2++) {
/* 1733 */               final int throwsTypeIndex = this.reader.readUnsignedShort();
/* 1734 */               int i5 = this.reader.readInt();
/* 1735 */               if (constantPoolStringEquals(i4, "LineNumberTable")) {
/* 1736 */                 int i6 = this.reader.readUnsignedShort();
/* 1737 */                 for (final byte boundIndex = 0; b3 < i6; b3++) {
/* 1738 */                   this.reader.skip(2);
/* 1739 */                   int i7 = this.reader.readUnsignedShort();
/* 1740 */                   m = !m ? i7 : Math.min(m, i7);
/* 1741 */                   n = !n ? i7 : Math.max(n, i7);
/*      */                 } 
/*      */               } else {
/* 1744 */                 this.reader.skip(i5);
/*      */               } 
/*      */             } 
/*      */           } else {
/* 1748 */             this.reader.skip(i2);
/*      */           } 
/*      */         } 
/*      */         
/* 1752 */         if (bool1) {
/* 1753 */           if (this.methodInfoList == null) {
/* 1754 */             this.methodInfoList = new MethodInfoList();
/*      */           }
/* 1756 */           this.methodInfoList.add(new MethodInfo(this.className, str1, annotationInfoList, j, str2, str3, arrayOfString1, arrayOfInt, arrayOfAnnotationInfo, bool2, m, n, arrayList, arrayOfString2));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void readClassAttributes() {
/* 1777 */     int i = this.reader.readUnsignedShort();
/* 1778 */     for (byte b = 0; b < i; b++) {
/* 1779 */       int j = this.reader.readUnsignedShort();
/* 1780 */       int k = this.reader.readInt();
/* 1781 */       if (this.scanSpec.enableAnnotationInfo && (
/* 1782 */         constantPoolStringEquals(j, "RuntimeVisibleAnnotations") || (!this.scanSpec.disableRuntimeInvisibleAnnotations && 
/* 1783 */         constantPoolStringEquals(j, "RuntimeInvisibleAnnotations")))) {
/*      */ 
/*      */         
/* 1786 */         if ((j = this.reader.readUnsignedShort()) > 0) {
/* 1787 */           if (this.classAnnotations == null) {
/* 1788 */             this.classAnnotations = new AnnotationInfoList();
/*      */           }
/* 1790 */           for (k = 0; k < j; k++)
/* 1791 */             this.classAnnotations.add(readAnnotation()); 
/*      */         }  continue;
/*      */       } 
/* 1794 */       if (this.scanSpec.enableAnnotationInfo && (
/* 1795 */         constantPoolStringEquals(j, "RuntimeVisibleTypeAnnotations") || (!this.scanSpec.disableRuntimeInvisibleAnnotations && 
/* 1796 */         constantPoolStringEquals(j, "RuntimeInvisibleTypeAnnotations")))) {
/*      */ 
/*      */         
/* 1799 */         if ((j = this.reader.readUnsignedShort()) > 0) {
/* 1800 */           this.classTypeAnnotationDecorators = new ArrayList<>(j);
/* 1801 */           for (k = 0; k < j; k++) {
/*      */             final int typeParameterIndex;
/*      */             
/*      */             final byte supertypeIndex;
/*      */             final int boundIndex, targetType;
/* 1806 */             if ((m = this.reader.readUnsignedByte()) == 0) {
/*      */               
/* 1808 */               n = this.reader.readUnsignedByte();
/* 1809 */               b1 = -1;
/* 1810 */               i1 = -1;
/* 1811 */             } else if (m == 16) {
/*      */ 
/*      */ 
/*      */               
/* 1815 */               b1 = this.reader.readUnsignedShort();
/* 1816 */               n = -1;
/* 1817 */               i1 = -1;
/* 1818 */             } else if (m == 17) {
/*      */               
/* 1820 */               n = this.reader.readUnsignedByte();
/* 1821 */               i1 = this.reader.readUnsignedByte();
/* 1822 */               b1 = -1;
/*      */             } else {
/* 1824 */               throw new ClassfileFormatException("Class " + this.className + " has unknown class type annotation target 0x" + 
/*      */                   
/* 1826 */                   Integer.toHexString(m) + ": element size unknown, cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
/*      */             } 
/*      */ 
/*      */             
/* 1830 */             final List<TypePathNode> typePath = readTypePath();
/* 1831 */             final AnnotationInfo annotationInfo = readAnnotation();
/* 1832 */             this.classTypeAnnotationDecorators.add(new ClassTypeAnnotationDecorator() {
/*      */                   public void decorate(ClassTypeSignature param1ClassTypeSignature) {
/*      */                     List<TypeParameter> list;
/* 1835 */                     if (targetType == 0) {
/*      */ 
/*      */ 
/*      */                       
/* 1839 */                       if ((list = param1ClassTypeSignature.getTypeParameters()) != null && typeParameterIndex < list.size())
/* 1840 */                         ((TypeParameter)list.get(typeParameterIndex)).addTypeAnnotation(typePath, annotationInfo); 
/*      */                       return;
/*      */                     } 
/* 1843 */                     if (targetType == 16) {
/*      */ 
/*      */ 
/*      */                       
/* 1847 */                       if (supertypeIndex == 65535) {
/*      */                         
/* 1849 */                         list.getSuperclassSignature().addTypeAnnotation(typePath, annotationInfo);
/*      */                         
/*      */                         return;
/*      */                       } 
/* 1853 */                       ((ClassRefTypeSignature)list.getSuperinterfaceSignatures().get(supertypeIndex))
/* 1854 */                         .addTypeAnnotation(typePath, annotationInfo); return;
/*      */                     } 
/* 1856 */                     if (targetType == 17)
/*      */                     {
/*      */ 
/*      */                       
/* 1860 */                       if ((list = list.getTypeParameters()) != null && typeParameterIndex < list.size()) {
/* 1861 */                         TypeParameter typeParameter = list.get(typeParameterIndex);
/*      */                         
/* 1863 */                         if (boundIndex == 0) {
/*      */                           ReferenceTypeSignature referenceTypeSignature;
/* 1865 */                           if ((referenceTypeSignature = typeParameter.getClassBound()) != null) {
/* 1866 */                             referenceTypeSignature.addTypeAnnotation(typePath, annotationInfo);
/*      */                           }
/*      */                           return;
/*      */                         } 
/*      */                         List<ReferenceTypeSignature> list1;
/* 1871 */                         if ((list1 = typeParameter.getInterfaceBounds()) != null && boundIndex - 1 < list1
/* 1872 */                           .size())
/* 1873 */                           ((ReferenceTypeSignature)typeParameter.getInterfaceBounds().get(boundIndex - 1))
/* 1874 */                             .addTypeAnnotation(typePath, annotationInfo); 
/*      */                       } 
/*      */                     }
/*      */                   }
/*      */                 });
/*      */           } 
/*      */         } 
/*      */         continue;
/*      */       } 
/* 1883 */       if (constantPoolStringEquals(j, "Record")) {
/* 1884 */         this.isRecord = true;
/*      */       } else {
/*      */         String str;
/*      */ 
/*      */         
/* 1889 */         if (constantPoolStringEquals(j, "InnerClasses")) {
/* 1890 */           j = this.reader.readUnsignedShort();
/* 1891 */           for (k = 0; k < j; k++) {
/* 1892 */             final int targetType = this.reader.readUnsignedShort();
/* 1893 */             final int typeParameterIndex = this.reader.readUnsignedShort();
/* 1894 */             this.reader.skip(2);
/* 1895 */             final int boundIndex = this.reader.readUnsignedShort();
/* 1896 */             if (m != 0 && n != 0) {
/* 1897 */               String str1 = getConstantPoolClassName(m);
/* 1898 */               String str2 = getConstantPoolClassName(n);
/* 1899 */               if (str1 == null || str2 == null)
/*      */               {
/* 1901 */                 throw new ClassfileFormatException("Inner and/or outer class name is null");
/*      */               }
/* 1903 */               if (str1.equals(str2))
/*      */               {
/* 1905 */                 throw new ClassfileFormatException("Inner and outer class name cannot be the same");
/*      */               }
/*      */               
/* 1908 */               if (!"java.lang.invoke.MethodHandles$Lookup".equals(str1) || 
/* 1909 */                 !"java.lang.invoke.MethodHandles".equals(str2)) {
/*      */                 
/* 1911 */                 if (this.classContainmentEntries == null) {
/* 1912 */                   this.classContainmentEntries = new ArrayList<>();
/*      */                 }
/* 1914 */                 this.classContainmentEntries.add(new ClassContainment(str1, i1, str2));
/*      */               } 
/*      */             } 
/*      */           }  continue;
/*      */         } 
/* 1919 */         if (constantPoolStringEquals(j, "Signature")) {
/*      */           
/* 1921 */           this.typeSignatureStr = getConstantPoolString(this.reader.readUnsignedShort()); continue;
/* 1922 */         }  if (constantPoolStringEquals(j, "SourceFile")) {
/* 1923 */           this.sourceFile = getConstantPoolString(this.reader.readUnsignedShort()); continue;
/* 1924 */         }  if (constantPoolStringEquals(j, "EnclosingMethod")) {
/* 1925 */           String str1; str = getConstantPoolClassName(this.reader.readUnsignedShort());
/*      */ 
/*      */           
/* 1928 */           if ((k = this.reader.readUnsignedShort()) == 0) {
/*      */ 
/*      */             
/* 1931 */             str1 = "<clinit>";
/*      */           } else {
/* 1933 */             str1 = getConstantPoolString(k, 0);
/*      */           } 
/*      */ 
/*      */           
/* 1937 */           if (this.classContainmentEntries == null) {
/* 1938 */             this.classContainmentEntries = new ArrayList<>();
/*      */           }
/* 1940 */           this.classContainmentEntries
/* 1941 */             .add(new ClassContainment(this.className, this.classModifiers, str));
/*      */ 
/*      */           
/* 1944 */           this.fullyQualifiedDefiningMethodName = str + "." + str1; continue;
/* 1945 */         }  if (constantPoolStringEquals(str, "Module")) {
/* 1946 */           final int targetType = this.reader.readUnsignedShort();
/* 1947 */           this.classpathElement.moduleNameFromModuleDescriptor = getConstantPoolString(m);
/*      */ 
/*      */           
/* 1950 */           this.reader.skip(k - 2); continue;
/*      */         } 
/* 1952 */       }  this.reader.skip(k);
/*      */       continue;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Classfile(ClasspathElement paramClasspathElement, List<ClasspathElement> paramList, Set<String> paramSet1, Set<String> paramSet2, String paramString, Resource paramResource, boolean paramBoolean, ConcurrentHashMap<String, String> paramConcurrentHashMap, WorkQueue<Scanner.ClassfileScanWorkUnit> paramWorkQueue, ScanSpec paramScanSpec, LogNode paramLogNode) {
/*      */     Set<String> set;
/* 2002 */     this.classpathElement = paramClasspathElement;
/* 2003 */     this.classpathOrder = paramList;
/* 2004 */     this.relativePath = paramString;
/* 2005 */     this.acceptedClassNamesFound = paramSet1;
/* 2006 */     this.classNamesScheduledForExtendedScanning = paramSet2;
/* 2007 */     this.classfileResource = paramResource;
/* 2008 */     this.isExternalClass = paramBoolean;
/* 2009 */     this.stringInternMap = paramConcurrentHashMap;
/* 2010 */     this.scanSpec = paramScanSpec;
/*      */ 
/*      */     
/* 2013 */     ClassfileReader classfileReader = paramResource.openClassfile(); paramList = null; 
/* 2014 */     try { this.reader = classfileReader;
/*      */ 
/*      */       
/* 2017 */       if (this.reader.readInt() != -889275714) {
/* 2018 */         throw new ClassfileFormatException("Classfile does not have correct magic number");
/*      */       }
/*      */ 
/*      */       
/* 2022 */       this.minorVersion = this.reader.readUnsignedShort();
/* 2023 */       this.majorVersion = this.reader.readUnsignedShort();
/*      */ 
/*      */       
/* 2026 */       readConstantPoolEntries(paramLogNode);
/*      */ 
/*      */       
/* 2029 */       readBasicClassInfo();
/*      */ 
/*      */       
/* 2032 */       readInterfaces();
/*      */ 
/*      */       
/* 2035 */       readFields();
/*      */ 
/*      */       
/* 2038 */       readMethods();
/*      */ 
/*      */       
/* 2041 */       readClassAttributes();
/*      */       
/* 2043 */       this.reader = null; } catch (Throwable throwable) { set = paramSet1 = null; throw paramSet1; }
/* 2044 */     finally { if (classfileReader != null) if (set != null) { try { classfileReader.close(); } catch (Throwable throwable) { set.addSuppressed(throwable); }  } else { throwable.close(); }
/*      */       
/*      */        }
/*      */ 
/*      */     
/*      */     LogNode logNode;
/*      */     
/* 2051 */     if ((logNode = (LogNode)((paramLogNode == null) ? null : paramLogNode.log("Found " + (this.isAnnotation ? "annotation class" : (this.isInterface ? "interface class" : "class")) + " " + this.className))) != null) {
/* 2052 */       if (this.superclassName != null) {
/* 2053 */         logNode.log("Super" + ((this.isInterface && !this.isAnnotation) ? "interface" : "class") + ": " + this.superclassName);
/*      */       }
/*      */       
/* 2056 */       if (this.implementedInterfaces != null) {
/* 2057 */         logNode.log("Interfaces: " + StringUtils.join(", ", this.implementedInterfaces));
/*      */       }
/* 2059 */       if (this.classAnnotations != null) {
/* 2060 */         logNode.log("Class annotations: " + StringUtils.join(", ", this.classAnnotations));
/*      */       }
/* 2062 */       if (this.annotationParamDefaultValues != null) {
/* 2063 */         for (AnnotationParameterValue annotationParameterValue : this.annotationParamDefaultValues) {
/* 2064 */           logNode.log("Annotation default param value: " + annotationParameterValue);
/*      */         }
/*      */       }
/* 2067 */       if (this.fieldInfoList != null) {
/* 2068 */         for (Iterator<FieldInfo> iterator = this.fieldInfoList.iterator(); iterator.hasNext(); ) {
/* 2069 */           FieldInfo fieldInfo; String str = (fieldInfo = iterator.next()).getModifiersStr();
/* 2070 */           logNode.log("Field: " + str + (str.isEmpty() ? "" : " ") + fieldInfo.getName());
/*      */         } 
/*      */       }
/* 2073 */       if (this.methodInfoList != null) {
/* 2074 */         for (Iterator<MethodInfo> iterator = this.methodInfoList.iterator(); iterator.hasNext(); ) {
/* 2075 */           MethodInfo methodInfo; String str = (methodInfo = iterator.next()).getModifiersStr();
/* 2076 */           logNode.log("Method: " + str + (
/* 2077 */               str.isEmpty() ? "" : " ") + methodInfo.getName());
/*      */         } 
/*      */       }
/* 2080 */       if (this.typeSignatureStr != null) {
/* 2081 */         logNode.log("Class type signature: " + this.typeSignatureStr);
/*      */       }
/* 2083 */       if (this.refdClassNames != null) {
/*      */         ArrayList<String> arrayList;
/* 2085 */         CollectionUtils.sortIfNotEmpty(arrayList = new ArrayList<>(this.refdClassNames));
/* 2086 */         logNode.log("Additional referenced class names: " + StringUtils.join(", ", arrayList));
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2094 */     if (paramScanSpec.extendScanningUpwardsToExternalClasses) {
/* 2095 */       extendScanningUpwards(logNode);
/*      */       
/* 2097 */       if (this.additionalWorkUnits != null)
/* 2098 */         paramWorkQueue.addWorkUnits(this.additionalWorkUnits); 
/*      */     } 
/*      */   }
/*      */   
/*      */   static interface TypeAnnotationDecorator {
/*      */     void decorate(TypeSignature param1TypeSignature);
/*      */   }
/*      */   
/*      */   static interface MethodTypeAnnotationDecorator {
/*      */     void decorate(MethodTypeSignature param1MethodTypeSignature);
/*      */   }
/*      */   
/*      */   static interface ClassTypeAnnotationDecorator {
/*      */     void decorate(ClassTypeSignature param1ClassTypeSignature);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\Classfile.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */