/*      */ package io.github.classgraph;
/*      */ 
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import nonapi.io.github.classgraph.types.ParseException;
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
/*      */ public class MethodInfo
/*      */   extends ClassMemberInfo
/*      */   implements Comparable<MethodInfo>
/*      */ {
/*      */   private transient MethodTypeSignature typeDescriptor;
/*      */   private transient MethodTypeSignature typeSignature;
/*      */   private String[] parameterNames;
/*      */   private int[] parameterModifiers;
/*      */   AnnotationInfo[][] parameterAnnotationInfo;
/*      */   private transient MethodParameterInfo[] parameterInfo;
/*      */   private boolean hasBody;
/*      */   private int minLineNum;
/*      */   private int maxLineNum;
/*      */   private transient List<Classfile.MethodTypeAnnotationDecorator> typeAnnotationDecorators;
/*      */   private String[] thrownExceptionNames;
/*      */   private transient ClassInfoList thrownExceptions;
/*      */   
/*      */   MethodInfo() {}
/*      */   
/*      */   MethodInfo(String paramString1, String paramString2, AnnotationInfoList paramAnnotationInfoList, int paramInt1, String paramString3, String paramString4, String[] paramArrayOfString1, int[] paramArrayOfint, AnnotationInfo[][] paramArrayOfAnnotationInfo, boolean paramBoolean, int paramInt2, int paramInt3, List<Classfile.MethodTypeAnnotationDecorator> paramList, String[] paramArrayOfString2) {
/*  140 */     super(paramString1, paramString2, paramInt1, paramString3, paramString4, paramAnnotationInfoList);
/*  141 */     this.parameterNames = paramArrayOfString1;
/*  142 */     this.parameterModifiers = paramArrayOfint;
/*  143 */     this.parameterAnnotationInfo = paramArrayOfAnnotationInfo;
/*  144 */     this.hasBody = paramBoolean;
/*  145 */     this.minLineNum = paramInt2;
/*  146 */     this.maxLineNum = paramInt3;
/*  147 */     this.typeAnnotationDecorators = paramList;
/*  148 */     this.thrownExceptionNames = paramArrayOfString2;
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
/*      */   public String getName() {
/*  161 */     return this.name;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getModifiersStr() {
/*  172 */     StringBuilder stringBuilder = new StringBuilder();
/*  173 */     TypeUtils.modifiersToString(this.modifiers, TypeUtils.ModifierType.METHOD, isDefault(), stringBuilder);
/*  174 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MethodTypeSignature getTypeDescriptor() {
/*  185 */     if (this.typeDescriptor == null) {
/*      */       try {
/*  187 */         this.typeDescriptor = MethodTypeSignature.parse(this.typeDescriptorStr, this.declaringClassName);
/*  188 */         this.typeDescriptor.setScanResult(this.scanResult);
/*  189 */         if (this.typeAnnotationDecorators != null) {
/*      */           Classfile.MethodTypeAnnotationDecorator methodTypeAnnotationDecorator;
/*      */ 
/*      */           
/*      */           MethodTypeSignature methodTypeSignature;
/*      */ 
/*      */           
/*  196 */           if ((methodTypeSignature = getTypeSignature()) == null) {
/*      */             
/*  198 */             for (Iterator<Classfile.MethodTypeAnnotationDecorator> iterator = this.typeAnnotationDecorators.iterator(); iterator.hasNext();) {
/*  199 */               (methodTypeAnnotationDecorator = iterator.next()).decorate(this.typeDescriptor);
/*      */             }
/*      */           } else {
/*      */             
/*  203 */             int i = methodTypeAnnotationDecorator.getParameterTypeSignatures().size();
/*      */             
/*      */             int j;
/*  206 */             if ((i = (j = this.typeDescriptor.getParameterTypeSignatures().size()) - i) < 0)
/*      */             {
/*  208 */               throw new IllegalArgumentException("Fewer params in method type descriptor than in method type signature");
/*      */             }
/*  210 */             if (i == 0) {
/*      */               
/*  212 */               for (Iterator<Classfile.MethodTypeAnnotationDecorator> iterator = this.typeAnnotationDecorators.iterator(); iterator.hasNext();) {
/*  213 */                 (methodTypeAnnotationDecorator1 = iterator.next()).decorate(this.typeDescriptor);
/*      */               
/*      */               }
/*      */             }
/*      */             else {
/*      */               
/*  219 */               List<TypeSignature> list1, list2 = (list1 = this.typeDescriptor.getParameterTypeSignatures()).subList(0, i);
/*      */               
/*  221 */               for (byte b = 0; b < i; b++) {
/*  222 */                 list1.remove(0);
/*      */               }
/*  224 */               for (Iterator<Classfile.MethodTypeAnnotationDecorator> iterator = this.typeAnnotationDecorators.iterator(); iterator.hasNext();) {
/*  225 */                 (methodTypeAnnotationDecorator1 = iterator.next()).decorate(this.typeDescriptor);
/*      */               }
/*  227 */               for (int k = i - 1; k >= 0; k--) {
/*  228 */                 list1.add(0, list2.get(k));
/*      */               }
/*      */             } 
/*      */           } 
/*      */         } 
/*  233 */       } catch (ParseException parseException) {
/*  234 */         throw new IllegalArgumentException(parseException);
/*      */       } 
/*      */     }
/*  237 */     return this.typeDescriptor;
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
/*      */   public MethodTypeSignature getTypeSignature() {
/*  253 */     if (this.typeSignature == null && this.typeSignatureStr != null) {
/*      */       try {
/*  255 */         this.typeSignature = MethodTypeSignature.parse(this.typeSignatureStr, this.declaringClassName);
/*  256 */         this.typeSignature.setScanResult(this.scanResult);
/*  257 */         if (this.typeAnnotationDecorators != null) {
/*  258 */           for (Iterator<Classfile.MethodTypeAnnotationDecorator> iterator = this.typeAnnotationDecorators.iterator(); iterator.hasNext();) {
/*  259 */             (methodTypeAnnotationDecorator = iterator.next()).decorate(this.typeSignature);
/*      */           }
/*      */         }
/*  262 */       } catch (ParseException parseException) {
/*  263 */         throw new IllegalArgumentException("Invalid type signature for method " + 
/*  264 */             getClassName() + "." + getName() + (
/*  265 */             (getClassInfo() != null) ? (" in classpath element " + 
/*  266 */             getClassInfo().getClasspathElementURI()) : "") + " : " + this.typeSignatureStr, parseException);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  272 */     return this.typeSignature;
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
/*      */   public MethodTypeSignature getTypeSignatureOrTypeDescriptor() {
/*      */     try {
/*      */       MethodTypeSignature methodTypeSignature;
/*  288 */       if ((methodTypeSignature = getTypeSignature()) != null) {
/*  289 */         return methodTypeSignature;
/*      */       }
/*  291 */     } catch (Exception exception) {}
/*      */ 
/*      */     
/*  294 */     return getTypeDescriptor();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassInfoList getThrownExceptions() {
/*  303 */     if (this.thrownExceptions == null && this.thrownExceptionNames != null) {
/*  304 */       this.thrownExceptions = new ClassInfoList(this.thrownExceptionNames.length); String[] arrayOfString; int i; byte b;
/*  305 */       for (i = (arrayOfString = this.thrownExceptionNames).length, b = 0; b < i; ) { String str = arrayOfString[b];
/*      */         ClassInfo classInfo;
/*  307 */         if ((classInfo = this.scanResult.getClassInfo(str)) != null) {
/*  308 */           this.thrownExceptions.add(classInfo);
/*  309 */           classInfo.setScanResult(this.scanResult);
/*      */         }  b++; }
/*      */     
/*      */     } 
/*  313 */     return (this.thrownExceptions == null) ? ClassInfoList.EMPTY_LIST : this.thrownExceptions;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getThrownExceptionNames() {
/*  322 */     return (this.thrownExceptionNames == null) ? new String[0] : this.thrownExceptionNames;
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
/*      */   public boolean isConstructor() {
/*  335 */     return "<init>".equals(this.name);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSynchronized() {
/*  344 */     return Modifier.isSynchronized(this.modifiers);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isBridge() {
/*  353 */     return ((this.modifiers & 0x40) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isVarArgs() {
/*  362 */     return ((this.modifiers & 0x80) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isNative() {
/*  371 */     return Modifier.isNative(this.modifiers);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAbstract() {
/*  380 */     return Modifier.isAbstract(this.modifiers);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isStrict() {
/*  389 */     return Modifier.isStrict(this.modifiers);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasBody() {
/*  398 */     return this.hasBody;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMinLineNum() {
/*  407 */     return this.minLineNum;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxLineNum() {
/*  416 */     return this.maxLineNum;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDefault() {
/*      */     ClassInfo classInfo;
/*  427 */     if ((classInfo = getClassInfo()) != null && classInfo.isInterface() && this.hasBody) return true;  return false;
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
/*      */   public MethodParameterInfo[] getParameterInfo() {
/*  455 */     if (this.parameterInfo == null) {
/*      */       
/*  457 */       List<TypeSignature> list2, list1 = null;
/*      */       MethodTypeSignature methodTypeSignature;
/*  459 */       if ((methodTypeSignature = getTypeSignature()) != null) {
/*  460 */         list1 = methodTypeSignature.getParameterTypeSignatures();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  468 */       methodTypeSignature = null;
/*      */       try {
/*      */         MethodTypeSignature methodTypeSignature1;
/*  471 */         if ((methodTypeSignature1 = getTypeDescriptor()) != null) {
/*  472 */           list2 = methodTypeSignature1.getParameterTypeSignatures();
/*      */         }
/*  474 */       } catch (Exception exception) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  481 */       int i = (list1 == null) ? 0 : list1.size();
/*  482 */       if (list2 != null && list2.size() > i) {
/*  483 */         i = list2.size();
/*      */       }
/*  485 */       if (this.parameterNames != null && this.parameterNames.length > i) {
/*  486 */         i = this.parameterNames.length;
/*      */       }
/*  488 */       if (this.parameterModifiers != null && this.parameterModifiers.length > i) {
/*  489 */         i = this.parameterModifiers.length;
/*      */       }
/*  491 */       if (this.parameterAnnotationInfo != null && this.parameterAnnotationInfo.length > i) {
/*  492 */         i = this.parameterAnnotationInfo.length;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  498 */       String[] arrayOfString = null;
/*  499 */       if (this.parameterNames != null && this.parameterNames.length > 0) {
/*  500 */         if (this.parameterNames.length == i) {
/*      */           
/*  502 */           arrayOfString = this.parameterNames;
/*      */         } else {
/*      */           
/*  505 */           arrayOfString = new String[i]; byte b1; int j;
/*  506 */           for (b1 = 0, j = i - this.parameterNames.length; b1 < this.parameterNames.length; b1++) {
/*  507 */             arrayOfString[j + b1] = this.parameterNames[b1];
/*      */           }
/*      */         } 
/*      */       }
/*  511 */       int[] arrayOfInt = null;
/*  512 */       if (this.parameterModifiers != null && this.parameterModifiers.length > 0) {
/*  513 */         if (this.parameterModifiers.length == i) {
/*      */           
/*  515 */           arrayOfInt = this.parameterModifiers;
/*      */         } else {
/*      */           
/*  518 */           arrayOfInt = new int[i];
/*  519 */           byte b1 = 0;
/*  520 */           for (int j = i - this.parameterModifiers.length; b1 < this.parameterModifiers.length; b1++) {
/*  521 */             arrayOfInt[j + b1] = this.parameterModifiers[b1];
/*      */           }
/*      */         } 
/*      */       }
/*  525 */       AnnotationInfo[][] arrayOfAnnotationInfo = (AnnotationInfo[][])null;
/*  526 */       if (this.parameterAnnotationInfo != null && this.parameterAnnotationInfo.length > 0) {
/*  527 */         if (this.parameterAnnotationInfo.length == i) {
/*      */           
/*  529 */           arrayOfAnnotationInfo = this.parameterAnnotationInfo;
/*      */         } else {
/*      */           
/*  532 */           arrayOfAnnotationInfo = new AnnotationInfo[i][];
/*  533 */           byte b1 = 0; int j = i - this.parameterAnnotationInfo.length;
/*  534 */           for (; b1 < this.parameterAnnotationInfo.length; b1++) {
/*  535 */             arrayOfAnnotationInfo[j + b1] = this.parameterAnnotationInfo[b1];
/*      */           }
/*      */         } 
/*      */       }
/*  539 */       List<TypeSignature> list3 = null;
/*  540 */       if (list1 != null && list1.size() > 0) {
/*  541 */         if (list1.size() == i) {
/*      */           
/*  543 */           list3 = list1;
/*      */         } else {
/*      */           
/*  546 */           list3 = new ArrayList<>(i); byte b1; int j;
/*  547 */           for (b1 = 0, j = i - list1.size(); b1 < j; b1++)
/*      */           {
/*  549 */             list3.add(null);
/*      */           }
/*  551 */           list3.addAll(list1);
/*      */         } 
/*      */       }
/*  554 */       List<TypeSignature> list4 = null;
/*  555 */       if (list2 != null && list2.size() > 0) {
/*  556 */         if (list2.size() == i) {
/*      */           
/*  558 */           list4 = list2;
/*      */         } else {
/*      */           
/*  561 */           list4 = new ArrayList<>(i); int j; byte b1;
/*  562 */           for (b1 = 0, j = i - list2.size(); b1 < j; b1++)
/*      */           {
/*  564 */             list4.add(null);
/*      */           }
/*  566 */           list4.addAll(list2);
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*  571 */       this.parameterInfo = new MethodParameterInfo[i];
/*  572 */       for (byte b = 0; b < i; b++) {
/*  573 */         this.parameterInfo[b] = new MethodParameterInfo(this, (arrayOfAnnotationInfo == null) ? null : arrayOfAnnotationInfo[b], (arrayOfInt == null) ? 0 : arrayOfInt[b], (list4 == null) ? null : list4
/*      */ 
/*      */             
/*  576 */             .get(b), (list3 == null) ? null : list3
/*  577 */             .get(b), (arrayOfString == null) ? null : arrayOfString[b]);
/*      */         
/*  579 */         this.parameterInfo[b].setScanResult(this.scanResult);
/*      */       } 
/*      */     } 
/*  582 */     return this.parameterInfo;
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
/*      */   public boolean hasParameterAnnotation(Class<? extends Annotation> paramClass) {
/*  595 */     Assert.isAnnotation(paramClass);
/*  596 */     return hasParameterAnnotation(paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasParameterAnnotation(String paramString) {
/*      */     MethodParameterInfo[] arrayOfMethodParameterInfo;
/*      */     int i;
/*      */     byte b;
/*  607 */     for (i = (arrayOfMethodParameterInfo = getParameterInfo()).length, b = 0; b < i; b++) {
/*  608 */       MethodParameterInfo methodParameterInfo; if ((methodParameterInfo = arrayOfMethodParameterInfo[b]).hasAnnotation(paramString)) {
/*  609 */         return true;
/*      */       }
/*      */     } 
/*  612 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Class<?>[] loadParameterClasses() {
/*  623 */     MethodParameterInfo[] arrayOfMethodParameterInfo = getParameterInfo();
/*  624 */     ArrayList<Class<?>> arrayList = new ArrayList(arrayOfMethodParameterInfo.length); int i; byte b;
/*  625 */     for (i = (arrayOfMethodParameterInfo = arrayOfMethodParameterInfo).length, b = 0; b < i; b++) {
/*      */       TypeSignature typeSignature;
/*      */       MethodParameterInfo methodParameterInfo;
/*  628 */       if (typeSignature = (methodParameterInfo = arrayOfMethodParameterInfo[b]).getTypeSignatureOrTypeDescriptor() instanceof TypeVariableSignature) {
/*      */         ReferenceTypeSignature referenceTypeSignature;
/*      */         TypeParameter typeParameter;
/*  631 */         if ((typeParameter = (typeSignature = typeSignature).resolve()).classBound != null) {
/*      */ 
/*      */ 
/*      */           
/*  635 */           referenceTypeSignature = typeParameter.classBound;
/*  636 */         } else if (((TypeParameter)referenceTypeSignature).interfaceBounds != null && !((TypeParameter)referenceTypeSignature).interfaceBounds.isEmpty()) {
/*      */ 
/*      */           
/*  639 */           typeSignature = ((TypeParameter)referenceTypeSignature).interfaceBounds.get(0);
/*      */         } else {
/*      */           
/*  642 */           throw new IllegalArgumentException("TypeVariableSignature has no bounds");
/*      */         } 
/*      */       } else {
/*  645 */         typeSignature = typeSignature;
/*      */       } 
/*  647 */       arrayList.add(typeSignature.loadClass());
/*      */     } 
/*  649 */     return (Class[])arrayList.<Class<?>[]>toArray((Class<?>[][])new Class[0]);
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
/*      */   public Method loadClassAndGetMethod() {
/*  662 */     if (isConstructor()) {
/*  663 */       throw new IllegalArgumentException("Need to call loadClassAndGetConstructor() for constructors, not loadClassAndGetMethod()");
/*      */     }
/*      */     
/*  666 */     Class[] arrayOfClass = loadParameterClasses();
/*      */     try {
/*  668 */       return loadClass().getMethod(getName(), arrayOfClass);
/*  669 */     } catch (NoSuchMethodException noSuchMethodException) {
/*      */       try {
/*  671 */         return loadClass().getDeclaredMethod(getName(), arrayOfClass);
/*  672 */       } catch (NoSuchMethodException noSuchMethodException1) {
/*  673 */         throw new IllegalArgumentException("Method not found: " + getClassName() + "." + getName());
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
/*      */   public Constructor<?> loadClassAndGetConstructor() {
/*  689 */     if (!isConstructor()) {
/*  690 */       throw new IllegalArgumentException("Need to call loadClassAndGetMethod() for non-constructor methods, not loadClassAndGetConstructor()");
/*      */     }
/*      */ 
/*      */     
/*  694 */     Class[] arrayOfClass = loadParameterClasses();
/*      */     try {
/*  696 */       return loadClass().getConstructor(arrayOfClass);
/*  697 */     } catch (NoSuchMethodException noSuchMethodException) {
/*      */       try {
/*  699 */         return loadClass().getDeclaredConstructor(arrayOfClass);
/*  700 */       } catch (NoSuchMethodException noSuchMethodException1) {
/*  701 */         throw new IllegalArgumentException("Constructor not found for class " + getClassName());
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
/*  715 */     if (this.annotationInfo != null) {
/*  716 */       this.annotationInfo.handleRepeatableAnnotations(paramSet, getClassInfo(), ClassInfo.RelType.METHOD_ANNOTATIONS, ClassInfo.RelType.CLASSES_WITH_METHOD_ANNOTATION, ClassInfo.RelType.CLASSES_WITH_NONPRIVATE_METHOD_ANNOTATION);
/*      */     }
/*      */ 
/*      */     
/*  720 */     if (this.parameterAnnotationInfo != null) {
/*  721 */       for (byte b = 0; b < this.parameterAnnotationInfo.length; b++) {
/*      */         AnnotationInfo[] arrayOfAnnotationInfo;
/*  723 */         if ((arrayOfAnnotationInfo = this.parameterAnnotationInfo[b]) != null && arrayOfAnnotationInfo.length > 0) {
/*  724 */           boolean bool = false; AnnotationInfo[] arrayOfAnnotationInfo1; int i; byte b1;
/*  725 */           for (i = (arrayOfAnnotationInfo1 = arrayOfAnnotationInfo).length, b1 = 0; b1 < i; ) { AnnotationInfo annotationInfo = arrayOfAnnotationInfo1[b1];
/*  726 */             if (paramSet.contains(annotationInfo.getName())) {
/*  727 */               bool = true; break;
/*      */             } 
/*      */             b1++; }
/*      */           
/*  731 */           if (bool) {
/*      */             AnnotationInfoList annotationInfoList;
/*  733 */             (annotationInfoList = new AnnotationInfoList(arrayOfAnnotationInfo.length)).addAll(Arrays.asList(arrayOfAnnotationInfo));
/*  734 */             annotationInfoList.handleRepeatableAnnotations(paramSet, getClassInfo(), ClassInfo.RelType.METHOD_PARAMETER_ANNOTATIONS, ClassInfo.RelType.CLASSES_WITH_METHOD_PARAMETER_ANNOTATION, ClassInfo.RelType.CLASSES_WITH_NONPRIVATE_METHOD_PARAMETER_ANNOTATION);
/*      */ 
/*      */ 
/*      */             
/*  738 */             this.parameterAnnotationInfo[b] = (AnnotationInfo[])annotationInfoList.toArray((Object[])new AnnotationInfo[0]);
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
/*      */   void setScanResult(ScanResult paramScanResult) {
/*  752 */     super.setScanResult(paramScanResult);
/*  753 */     if (this.typeDescriptor != null) {
/*  754 */       this.typeDescriptor.setScanResult(paramScanResult);
/*      */     }
/*  756 */     if (this.typeSignature != null) {
/*  757 */       this.typeSignature.setScanResult(paramScanResult);
/*      */     }
/*  759 */     if (this.annotationInfo != null) {
/*  760 */       for (Iterator<AnnotationInfo> iterator = this.annotationInfo.iterator(); iterator.hasNext();) {
/*  761 */         (annotationInfo = iterator.next()).setScanResult(paramScanResult);
/*      */       }
/*      */     }
/*  764 */     if (this.parameterAnnotationInfo != null) {
/*  765 */       AnnotationInfo[][] arrayOfAnnotationInfo; int i; byte b; for (i = (arrayOfAnnotationInfo = this.parameterAnnotationInfo).length, b = 0; b < i; b++) {
/*  766 */         AnnotationInfo[] arrayOfAnnotationInfo1; if ((arrayOfAnnotationInfo1 = arrayOfAnnotationInfo[b]) != null) {
/*  767 */           int j; byte b1; for (j = (arrayOfAnnotationInfo1 = arrayOfAnnotationInfo1).length, b1 = 0; b1 < j; b1++) {
/*  768 */             AnnotationInfo annotationInfo; (annotationInfo = arrayOfAnnotationInfo1[b1]).setScanResult(paramScanResult);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  773 */     if (this.parameterInfo != null) {
/*  774 */       MethodParameterInfo[] arrayOfMethodParameterInfo; int i; byte b; for (i = (arrayOfMethodParameterInfo = this.parameterInfo).length, b = 0; b < i; b++) {
/*  775 */         MethodParameterInfo methodParameterInfo; (methodParameterInfo = arrayOfMethodParameterInfo[b]).setScanResult(paramScanResult);
/*      */       } 
/*      */     } 
/*  778 */     if (this.thrownExceptions != null) {
/*  779 */       for (Iterator<ClassInfo> iterator = this.thrownExceptions.iterator(); iterator.hasNext();) {
/*  780 */         if ((classInfo = iterator.next()).scanResult == null) {
/*  781 */           classInfo.setScanResult(paramScanResult);
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
/*      */   protected void findReferencedClassInfo(Map<String, ClassInfo> paramMap, Set<ClassInfo> paramSet, LogNode paramLogNode) {
/*      */     try {
/*      */       MethodTypeSignature methodTypeSignature;
/*  800 */       if ((methodTypeSignature = getTypeSignature()) != null) {
/*  801 */         methodTypeSignature.findReferencedClassInfo(paramMap, paramSet, paramLogNode);
/*      */       }
/*  803 */     } catch (IllegalArgumentException illegalArgumentException) {
/*  804 */       if (paramLogNode != null) {
/*  805 */         paramLogNode.log("Illegal type signature for method " + getClassName() + "." + getName() + ": " + 
/*  806 */             getTypeSignatureStr());
/*      */       }
/*      */     } 
/*      */     try {
/*      */       MethodTypeSignature methodTypeSignature;
/*  811 */       if ((methodTypeSignature = getTypeDescriptor()) != null) {
/*  812 */         methodTypeSignature.findReferencedClassInfo(paramMap, paramSet, paramLogNode);
/*      */       }
/*  814 */     } catch (IllegalArgumentException illegalArgumentException) {
/*  815 */       if (paramLogNode != null) {
/*  816 */         paramLogNode.log("Illegal type descriptor for method " + getClassName() + "." + getName() + ": " + 
/*  817 */             getTypeDescriptorStr());
/*      */       }
/*      */     } 
/*  820 */     if (this.annotationInfo != null)
/*  821 */       for (Iterator<AnnotationInfo> iterator = this.annotationInfo.iterator(); iterator.hasNext();)
/*  822 */         (annotationInfo = iterator.next()).findReferencedClassInfo(paramMap, paramSet, paramLogNode);   MethodParameterInfo[] arrayOfMethodParameterInfo;
/*      */     int i;
/*      */     byte b;
/*  825 */     for (i = (arrayOfMethodParameterInfo = getParameterInfo()).length, b = 0; b < i; b++) {
/*      */       MethodParameterInfo methodParameterInfo; AnnotationInfo[] arrayOfAnnotationInfo;
/*  827 */       if ((arrayOfAnnotationInfo = (methodParameterInfo = arrayOfMethodParameterInfo[b]).annotationInfo) != null) {
/*  828 */         int j; byte b1; for (j = (arrayOfAnnotationInfo = arrayOfAnnotationInfo).length, b1 = 0; b1 < j; b1++) {
/*  829 */           AnnotationInfo annotationInfo; (annotationInfo = arrayOfAnnotationInfo[b1]).findReferencedClassInfo(paramMap, paramSet, paramLogNode);
/*      */         } 
/*      */       } 
/*      */     }  ClassInfoList classInfoList;
/*  833 */     if (this.thrownExceptionNames != null && (
/*      */       
/*  835 */       classInfoList = getThrownExceptions()) != null) {
/*  836 */       for (i = 0; i < classInfoList.size(); i++) {
/*  837 */         paramMap.put(this.thrownExceptionNames[i], classInfoList.get(i));
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
/*      */   public boolean equals(Object paramObject) {
/*  854 */     if (paramObject == this)
/*  855 */       return true; 
/*  856 */     if (!(paramObject instanceof MethodInfo)) {
/*  857 */       return false;
/*      */     }
/*  859 */     paramObject = paramObject;
/*  860 */     if (this.declaringClassName.equals(((MethodInfo)paramObject).declaringClassName) && this.typeDescriptorStr
/*  861 */       .equals(((MethodInfo)paramObject).typeDescriptorStr) && this.name.equals(((MethodInfo)paramObject).name)) return true;
/*      */     
/*      */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/*  871 */     return this.name.hashCode() + this.typeDescriptorStr.hashCode() * 11 + this.declaringClassName.hashCode() * 57;
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
/*      */   public int compareTo(MethodInfo paramMethodInfo) {
/*      */     int i;
/*  884 */     if ((i = this.declaringClassName.compareTo(paramMethodInfo.declaringClassName)) != 0) {
/*  885 */       return i;
/*      */     }
/*      */     
/*  888 */     if ((i = this.name.compareTo(paramMethodInfo.name)) != 0) {
/*  889 */       return i;
/*      */     }
/*  891 */     return this.typeDescriptorStr.compareTo(paramMethodInfo.typeDescriptorStr);
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
/*      */   protected void toString(boolean paramBoolean, StringBuilder paramStringBuilder) {
/*  907 */     MethodTypeSignature methodTypeSignature = getTypeSignatureOrTypeDescriptor();
/*      */     
/*  909 */     if (this.annotationInfo != null) {
/*  910 */       for (AnnotationInfo annotationInfo : this.annotationInfo) {
/*  911 */         if (paramStringBuilder.length() > 0) {
/*  912 */           paramStringBuilder.append(' ');
/*      */         }
/*  914 */         annotationInfo.toString(paramBoolean, paramStringBuilder);
/*      */       } 
/*      */     }
/*      */     
/*  918 */     if (this.modifiers != 0) {
/*  919 */       if (paramStringBuilder.length() > 0) {
/*  920 */         paramStringBuilder.append(' ');
/*      */       }
/*  922 */       TypeUtils.modifiersToString(this.modifiers, TypeUtils.ModifierType.METHOD, isDefault(), paramStringBuilder);
/*      */     } 
/*      */     
/*      */     List<TypeParameter> list;
/*  926 */     if (!(list = methodTypeSignature.getTypeParameters()).isEmpty()) {
/*  927 */       if (paramStringBuilder.length() > 0) {
/*  928 */         paramStringBuilder.append(' ');
/*      */       }
/*  930 */       paramStringBuilder.append('<');
/*  931 */       for (byte b = 0; b < list.size(); b++) {
/*  932 */         if (b > 0) {
/*  933 */           paramStringBuilder.append(", ");
/*      */         }
/*  935 */         ((TypeParameter)list.get(b)).toString(paramBoolean, paramStringBuilder);
/*      */       } 
/*  937 */       paramStringBuilder.append('>');
/*      */     } 
/*      */     
/*  940 */     if (!isConstructor()) {
/*  941 */       if (paramStringBuilder.length() > 0) {
/*  942 */         paramStringBuilder.append(' ');
/*      */       }
/*  944 */       methodTypeSignature.getResultType().toStringInternal(paramBoolean, this.annotationInfo, paramStringBuilder);
/*      */     } 
/*      */ 
/*      */     
/*  948 */     if (paramStringBuilder.length() > 0) {
/*  949 */       paramStringBuilder.append(' ');
/*      */     }
/*  951 */     if (this.name != null) {
/*  952 */       paramStringBuilder.append(paramBoolean ? ClassInfo.getSimpleName(this.name) : this.name);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  957 */     MethodParameterInfo[] arrayOfMethodParameterInfo1 = getParameterInfo();
/*  958 */     boolean bool = false; MethodParameterInfo[] arrayOfMethodParameterInfo2; int j, k;
/*  959 */     for (j = (arrayOfMethodParameterInfo2 = arrayOfMethodParameterInfo1).length, k = 0; k < j; k++) {
/*  960 */       MethodParameterInfo methodParameterInfo; if ((methodParameterInfo = arrayOfMethodParameterInfo2[k]).getName() != null) {
/*  961 */         bool = true;
/*      */ 
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  969 */     int i = -1;
/*  970 */     if (isVarArgs()) {
/*  971 */       for (j = arrayOfMethodParameterInfo1.length - 1; j >= 0; j--) {
/*      */         TypeSignature typeSignature;
/*  973 */         if (((k = arrayOfMethodParameterInfo1[j].getModifiers()) & 0x1000) == 0 && (k & 0x8000) == 0 && 
/*      */           
/*  975 */           typeSignature = arrayOfMethodParameterInfo1[j].getTypeSignatureOrTypeDescriptor() instanceof ArrayTypeSignature) {
/*  976 */           i = j;
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/*  983 */     paramStringBuilder.append('(');
/*  984 */     for (j = 0, k = arrayOfMethodParameterInfo1.length; j < k; j++) {
/*  985 */       MethodParameterInfo methodParameterInfo = arrayOfMethodParameterInfo1[j];
/*  986 */       if (j > 0) {
/*  987 */         paramStringBuilder.append(", ");
/*      */       }
/*      */       
/*  990 */       if (methodParameterInfo.annotationInfo != null) {
/*  991 */         AnnotationInfo[] arrayOfAnnotationInfo; int m; byte b; for (m = (arrayOfAnnotationInfo = methodParameterInfo.annotationInfo).length, b = 0; b < m; b++) {
/*  992 */           AnnotationInfo annotationInfo; (annotationInfo = arrayOfAnnotationInfo[b]).toString(paramBoolean, paramStringBuilder);
/*  993 */           paramStringBuilder.append(' ');
/*      */         } 
/*      */       } 
/*      */       
/*  997 */       MethodParameterInfo.modifiersToString(methodParameterInfo.getModifiers(), paramStringBuilder);
/*      */ 
/*      */       
/*      */       TypeSignature typeSignature;
/*      */       
/* 1002 */       if ((typeSignature = methodParameterInfo.getTypeSignatureOrTypeDescriptor()) != null) {
/* 1003 */         if (j == i) {
/*      */           
/* 1005 */           if (!(typeSignature instanceof ArrayTypeSignature)) {
/* 1006 */             throw new IllegalArgumentException("Got non-array type for last parameter of varargs method " + this.name);
/*      */           }
/*      */           
/*      */           ArrayTypeSignature arrayTypeSignature;
/* 1010 */           if ((arrayTypeSignature = (ArrayTypeSignature)typeSignature).getNumDimensions() == 0) {
/* 1011 */             throw new IllegalArgumentException("Got a zero-dimension array type for last parameter of varargs method " + this.name);
/*      */           }
/*      */           
/* 1014 */           arrayTypeSignature.getElementTypeSignature().toString(paramBoolean, paramStringBuilder);
/* 1015 */           for (byte b = 0; b < arrayTypeSignature.getNumDimensions() - 1; b++) {
/* 1016 */             paramStringBuilder.append("[]");
/*      */           }
/* 1018 */           paramStringBuilder.append("...");
/*      */         } else {
/*      */           AnnotationInfoList annotationInfoList;
/*      */ 
/*      */           
/* 1023 */           if (methodParameterInfo.annotationInfo == null || methodParameterInfo.annotationInfo.length == 0) {
/* 1024 */             annotationInfoList = null;
/*      */           } else {
/*      */             
/* 1027 */             (annotationInfoList = new AnnotationInfoList(methodParameterInfo.annotationInfo.length)).addAll(Arrays.asList(methodParameterInfo.annotationInfo));
/*      */           } 
/* 1029 */           typeSignature.toStringInternal(paramBoolean, annotationInfoList, paramStringBuilder);
/*      */         } 
/*      */       }
/*      */       String str;
/* 1033 */       if (bool && (
/*      */         
/* 1035 */         str = methodParameterInfo.getName()) != null) {
/* 1036 */         if (paramStringBuilder.charAt(paramStringBuilder.length() - 1) != ' ') {
/* 1037 */           paramStringBuilder.append(' ');
/*      */         }
/* 1039 */         paramStringBuilder.append(str);
/*      */       } 
/*      */     } 
/*      */     
/* 1043 */     paramStringBuilder.append(')');
/*      */ 
/*      */     
/* 1046 */     if (!methodTypeSignature.getThrowsSignatures().isEmpty()) {
/* 1047 */       paramStringBuilder.append(" throws ");
/* 1048 */       for (j = 0; j < methodTypeSignature.getThrowsSignatures().size(); j++) {
/* 1049 */         if (j > 0) {
/* 1050 */           paramStringBuilder.append(", ");
/*      */         }
/* 1052 */         ((ClassRefOrTypeVariableSignature)methodTypeSignature.getThrowsSignatures().get(j)).toString(paramBoolean, paramStringBuilder);
/*      */       }  return;
/*      */     } 
/* 1055 */     if (this.thrownExceptionNames != null && this.thrownExceptionNames.length > 0) {
/* 1056 */       paramStringBuilder.append(" throws ");
/* 1057 */       for (j = 0; j < this.thrownExceptionNames.length; j++) {
/* 1058 */         if (j > 0) {
/* 1059 */           paramStringBuilder.append(", ");
/*      */         }
/* 1061 */         paramStringBuilder.append(paramBoolean ? ClassInfo.getSimpleName(this.thrownExceptionNames[j]) : this.thrownExceptionNames[j]);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\MethodInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */