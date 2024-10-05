/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.types.ParseException;
/*     */ import nonapi.io.github.classgraph.types.Parser;
/*     */ import nonapi.io.github.classgraph.types.TypeUtils;
/*     */ import nonapi.io.github.classgraph.utils.LogNode;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ClassTypeSignature
/*     */   extends HierarchicalTypeSignature
/*     */ {
/*     */   private final ClassInfo classInfo;
/*     */   final List<TypeParameter> typeParameters;
/*     */   private final ClassRefTypeSignature superclassSignature;
/*     */   private final List<ClassRefTypeSignature> superinterfaceSignatures;
/*     */   private final List<ClassRefOrTypeVariableSignature> throwsSignatures;
/*     */   
/*     */   private ClassTypeSignature(ClassInfo paramClassInfo, List<TypeParameter> paramList, ClassRefTypeSignature paramClassRefTypeSignature, List<ClassRefTypeSignature> paramList1, List<ClassRefOrTypeVariableSignature> paramList2) {
/*  88 */     this.classInfo = paramClassInfo;
/*  89 */     this.typeParameters = paramList;
/*  90 */     this.superclassSignature = paramClassRefTypeSignature;
/*  91 */     this.superinterfaceSignatures = paramList1;
/*  92 */     this.throwsSignatures = paramList2;
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
/*     */   ClassTypeSignature(ClassInfo paramClassInfo1, ClassInfo paramClassInfo2, ClassInfoList paramClassInfoList) {
/* 107 */     this.classInfo = paramClassInfo1;
/* 108 */     this.typeParameters = Collections.emptyList();
/* 109 */     ClassRefTypeSignature classRefTypeSignature = null;
/*     */ 
/*     */     
/*     */     try {
/* 113 */       classRefTypeSignature = (paramClassInfo2 == null) ? null : (ClassRefTypeSignature)TypeSignature.parse("L" + paramClassInfo2.getName().replace('.', '/') + ";", paramClassInfo1.getName());
/* 114 */     } catch (ParseException parseException) {}
/*     */ 
/*     */     
/* 117 */     this.superclassSignature = classRefTypeSignature;
/* 118 */     this
/*     */       
/* 120 */       .superinterfaceSignatures = (paramClassInfoList == null || paramClassInfoList.isEmpty()) ? Collections.<ClassRefTypeSignature>emptyList() : new ArrayList<>(paramClassInfoList.size());
/* 121 */     if (paramClassInfoList != null) {
/* 122 */       for (ClassInfo classInfo : paramClassInfoList) {
/*     */         
/*     */         try {
/* 125 */           ClassRefTypeSignature classRefTypeSignature1 = (ClassRefTypeSignature)TypeSignature.parse("L" + classInfo.getName().replace('.', '/') + ";", paramClassInfo1.getName());
/* 126 */           this.superinterfaceSignatures.add(classRefTypeSignature1);
/* 127 */         } catch (ParseException parseException) {}
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 132 */     this.throwsSignatures = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<TypeParameter> getTypeParameters() {
/* 143 */     return this.typeParameters;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ClassRefTypeSignature getSuperclassSignature() {
/* 153 */     return this.superclassSignature;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<ClassRefTypeSignature> getSuperinterfaceSignatures() {
/* 162 */     return this.superinterfaceSignatures;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final List<ClassRefOrTypeVariableSignature> getThrowsSignatures() {
/* 172 */     return this.throwsSignatures;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void addTypeAnnotation(List<Classfile.TypePathNode> paramList, AnnotationInfo paramAnnotationInfo) {
/* 178 */     throw new IllegalArgumentException("Cannot call this method on " + ClassTypeSignature.class
/* 179 */         .getSimpleName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final String getClassName() {
/* 189 */     return (this.classInfo != null) ? this.classInfo.getName() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final ClassInfo getClassInfo() {
/* 197 */     return this.classInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void setScanResult(ScanResult paramScanResult) {
/* 205 */     super.setScanResult(paramScanResult);
/* 206 */     if (this.typeParameters != null) {
/* 207 */       for (Iterator<TypeParameter> iterator = this.typeParameters.iterator(); iterator.hasNext();) {
/* 208 */         (typeParameter = iterator.next()).setScanResult(paramScanResult);
/*     */       }
/*     */     }
/* 211 */     if (this.superclassSignature != null) {
/* 212 */       this.superclassSignature.setScanResult(paramScanResult);
/*     */     }
/* 214 */     if (this.superinterfaceSignatures != null) {
/* 215 */       for (Iterator<ClassRefTypeSignature> iterator = this.superinterfaceSignatures.iterator(); iterator.hasNext();) {
/* 216 */         (classRefTypeSignature = iterator.next()).setScanResult(paramScanResult);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void findReferencedClassNames(Set<String> paramSet) {
/*     */     Iterator<TypeParameter> iterator;
/* 228 */     for (iterator = this.typeParameters.iterator(); iterator.hasNext();) {
/* 229 */       (typeParameter = iterator.next()).findReferencedClassNames(paramSet);
/*     */     }
/* 231 */     if (this.superclassSignature != null) {
/* 232 */       this.superclassSignature.findReferencedClassNames(paramSet);
/*     */     }
/* 234 */     if (this.superinterfaceSignatures != null) {
/* 235 */       for (iterator = (Iterator)this.superinterfaceSignatures.iterator(); iterator.hasNext();) {
/* 236 */         (classRefTypeSignature = (ClassRefTypeSignature)iterator.next()).findReferencedClassNames(paramSet);
/*     */       }
/*     */     }
/* 239 */     if (this.throwsSignatures != null) {
/* 240 */       for (iterator = (Iterator)this.throwsSignatures.iterator(); iterator.hasNext();) {
/* 241 */         (classRefOrTypeVariableSignature = (ClassRefOrTypeVariableSignature)iterator.next()).findReferencedClassNames(paramSet);
/*     */       }
/*     */     }
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
/*     */   protected final void findReferencedClassInfo(Map<String, ClassInfo> paramMap, Set<ClassInfo> paramSet, LogNode paramLogNode) {
/* 257 */     HashSet<String> hashSet = new HashSet();
/* 258 */     findReferencedClassNames(hashSet);
/* 259 */     for (Iterator<String> iterator = hashSet.iterator(); iterator.hasNext(); ) {
/*     */       String str; ClassInfo classInfo;
/* 261 */       (classInfo = ClassInfo.getOrCreateClassInfo(str = iterator.next(), paramMap)).scanResult = this.scanResult;
/* 262 */       paramSet.add(classInfo);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 273 */     return this.typeParameters.hashCode() + ((this.superclassSignature == null) ? 1 : this.superclassSignature.hashCode()) * 7 + ((this.superinterfaceSignatures == null) ? 1 : this.superinterfaceSignatures
/* 274 */       .hashCode()) * 15;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 282 */     if (paramObject == this)
/* 283 */       return true; 
/* 284 */     if (!(paramObject instanceof ClassTypeSignature)) {
/* 285 */       return false;
/*     */     }
/*     */     
/* 288 */     if (Objects.equals(((ClassTypeSignature)(paramObject = paramObject)).typeParameters, this.typeParameters) && 
/* 289 */       Objects.equals(((ClassTypeSignature)paramObject).superclassSignature, this.superclassSignature) && 
/* 290 */       Objects.equals(((ClassTypeSignature)paramObject).superinterfaceSignatures, this.superinterfaceSignatures)) return true;
/*     */     
/*     */     return false;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void toStringInternal(String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, AnnotationInfoList paramAnnotationInfoList, StringBuilder paramStringBuilder) {
/* 316 */     if (this.throwsSignatures != null) {
/* 317 */       for (ClassRefOrTypeVariableSignature classRefOrTypeVariableSignature : this.throwsSignatures) {
/* 318 */         if (paramStringBuilder.length() > 0) {
/* 319 */           paramStringBuilder.append(' ');
/*     */         }
/* 321 */         paramStringBuilder.append("@throws(").append(classRefOrTypeVariableSignature).append(")");
/*     */       } 
/*     */     }
/* 324 */     if (paramInt != 0) {
/* 325 */       if (paramStringBuilder.length() > 0) {
/* 326 */         paramStringBuilder.append(' ');
/*     */       }
/* 328 */       TypeUtils.modifiersToString(paramInt, TypeUtils.ModifierType.CLASS, false, paramStringBuilder);
/*     */     } 
/* 330 */     if (paramStringBuilder.length() > 0) {
/* 331 */       paramStringBuilder.append(' ');
/*     */     }
/* 333 */     paramStringBuilder.append(paramBoolean2 ? "@interface" : (paramBoolean3 ? "interface" : (((paramInt & 0x4000) != 0) ? "enum" : "class")));
/*     */     
/* 335 */     paramStringBuilder.append(' ');
/* 336 */     if (paramString != null) {
/* 337 */       paramStringBuilder.append(paramBoolean1 ? ClassInfo.getSimpleName(paramString) : paramString);
/*     */     }
/* 339 */     if (!this.typeParameters.isEmpty()) {
/* 340 */       paramStringBuilder.append('<');
/* 341 */       for (byte b = 0; b < this.typeParameters.size(); b++) {
/* 342 */         if (b > 0) {
/* 343 */           paramStringBuilder.append(", ");
/*     */         }
/* 345 */         ((TypeParameter)this.typeParameters.get(b)).toStringInternal(paramBoolean1, null, paramStringBuilder);
/*     */       } 
/* 347 */       paramStringBuilder.append('>');
/*     */     }  String str;
/* 349 */     if (this.superclassSignature != null && 
/*     */ 
/*     */       
/* 352 */       !(str = this.superclassSignature.toString(paramBoolean1)).equals("java.lang.Object") && (
/* 353 */       !str.equals("Object") || !this.superclassSignature.className.equals("java.lang.Object"))) {
/* 354 */       paramStringBuilder.append(" extends ");
/* 355 */       paramStringBuilder.append(str);
/*     */     } 
/*     */     
/* 358 */     if (this.superinterfaceSignatures != null && !this.superinterfaceSignatures.isEmpty()) {
/* 359 */       paramStringBuilder.append(paramBoolean3 ? " extends " : " implements ");
/* 360 */       for (byte b = 0; b < this.superinterfaceSignatures.size(); b++) {
/* 361 */         if (b > 0) {
/* 362 */           paramStringBuilder.append(", ");
/*     */         }
/* 364 */         ((ClassRefTypeSignature)this.superinterfaceSignatures.get(b)).toStringInternal(paramBoolean1, (AnnotationInfoList)null, paramStringBuilder);
/*     */       } 
/*     */     } 
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
/*     */   
/*     */   protected final void toStringInternal(boolean paramBoolean, AnnotationInfoList paramAnnotationInfoList, StringBuilder paramStringBuilder) {
/* 382 */     toStringInternal(this.classInfo.getName(), paramBoolean, this.classInfo.getModifiers(), this.classInfo.isAnnotation(), this.classInfo
/* 383 */         .isInterface(), paramAnnotationInfoList, paramStringBuilder);
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
/*     */   static ClassTypeSignature parse(String paramString, ClassInfo paramClassInfo) {
/*     */     List<?> list1;
/*     */     List list2;
/* 400 */     Parser parser = new Parser(paramString);
/*     */ 
/*     */ 
/*     */     
/* 404 */     String str = null;
/* 405 */     List<TypeParameter> list = TypeParameter.parseList(parser, str);
/* 406 */     ClassRefTypeSignature classRefTypeSignature = ClassRefTypeSignature.parse(parser, str);
/*     */ 
/*     */     
/* 409 */     if (parser.hasMore()) {
/* 410 */       list1 = new ArrayList();
/* 411 */       while (parser.hasMore() && 
/* 412 */         parser.peek() != '^') {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 418 */         if ((list2 = (List)ClassRefTypeSignature.parse(parser, str)) == null) {
/* 419 */           throw new ParseException(parser, "Could not parse superinterface signature");
/*     */         }
/* 421 */         list1.add((ClassRefTypeSignature)list2);
/*     */       } 
/*     */     } else {
/* 424 */       list1 = Collections.emptyList();
/*     */     } 
/*     */     
/* 427 */     if (parser.peek() == '^') {
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
/* 438 */       list2 = new ArrayList();
/* 439 */       while (parser.peek() == '^') {
/* 440 */         parser.expect('^');
/*     */         
/*     */         ClassRefTypeSignature classRefTypeSignature1;
/* 443 */         if ((classRefTypeSignature1 = ClassRefTypeSignature.parse(parser, paramClassInfo.getName())) != null) {
/* 444 */           list2.add(classRefTypeSignature1);
/*     */           continue;
/*     */         } 
/*     */         TypeVariableSignature typeVariableSignature;
/* 448 */         if ((typeVariableSignature = TypeVariableSignature.parse(parser, paramClassInfo.getName())) != null) {
/* 449 */           list2.add(typeVariableSignature); continue;
/*     */         } 
/* 451 */         throw new ParseException(parser, "Missing type variable signature");
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 456 */       list2 = null;
/*     */     } 
/* 458 */     if (parser.hasMore()) {
/* 459 */       throw new ParseException(parser, "Extra characters at end of type descriptor");
/*     */     }
/* 461 */     return new ClassTypeSignature(paramClassInfo, list, classRefTypeSignature, (List)list1, list2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ClassTypeSignature.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */