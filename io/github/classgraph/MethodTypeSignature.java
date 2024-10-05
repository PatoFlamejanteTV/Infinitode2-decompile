/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.types.ParseException;
/*     */ import nonapi.io.github.classgraph.types.Parser;
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
/*     */ public final class MethodTypeSignature
/*     */   extends HierarchicalTypeSignature
/*     */ {
/*     */   final List<TypeParameter> typeParameters;
/*     */   private final List<TypeSignature> parameterTypeSignatures;
/*     */   private final TypeSignature resultType;
/*     */   private final List<ClassRefOrTypeVariableSignature> throwsSignatures;
/*     */   private AnnotationInfoList receiverTypeAnnotationInfo;
/*     */   
/*     */   private MethodTypeSignature(List<TypeParameter> paramList, List<TypeSignature> paramList1, TypeSignature paramTypeSignature, List<ClassRefOrTypeVariableSignature> paramList2) {
/*  77 */     this.typeParameters = paramList;
/*  78 */     this.parameterTypeSignatures = paramList1;
/*  79 */     this.resultType = paramTypeSignature;
/*  80 */     this.throwsSignatures = paramList2;
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
/*     */   public final List<TypeParameter> getTypeParameters() {
/*  92 */     return this.typeParameters;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final List<TypeSignature> getParameterTypeSignatures() {
/* 103 */     return this.parameterTypeSignatures;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final TypeSignature getResultType() {
/* 112 */     return this.resultType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<ClassRefOrTypeVariableSignature> getThrowsSignatures() {
/* 121 */     return this.throwsSignatures;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void addTypeAnnotation(List<Classfile.TypePathNode> paramList, AnnotationInfo paramAnnotationInfo) {
/* 127 */     throw new IllegalArgumentException("Cannot call this method on " + MethodTypeSignature.class
/* 128 */         .getSimpleName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void addRecieverTypeAnnotation(AnnotationInfo paramAnnotationInfo) {
/* 138 */     if (this.receiverTypeAnnotationInfo == null) {
/* 139 */       this.receiverTypeAnnotationInfo = new AnnotationInfoList(1);
/*     */     }
/* 141 */     this.receiverTypeAnnotationInfo.add(paramAnnotationInfo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final AnnotationInfoList getReceiverTypeAnnotationInfo() {
/* 150 */     return this.receiverTypeAnnotationInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final String getClassName() {
/* 161 */     throw new IllegalArgumentException("getClassName() cannot be called here");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final ClassInfo getClassInfo() {
/* 169 */     throw new IllegalArgumentException("getClassInfo() cannot be called here");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void setScanResult(ScanResult paramScanResult) {
/* 177 */     super.setScanResult(paramScanResult);
/* 178 */     if (this.typeParameters != null) {
/* 179 */       for (Iterator<TypeParameter> iterator = this.typeParameters.iterator(); iterator.hasNext();) {
/* 180 */         (typeParameter = iterator.next()).setScanResult(paramScanResult);
/*     */       }
/*     */     }
/* 183 */     if (this.parameterTypeSignatures != null) {
/* 184 */       for (Iterator<TypeSignature> iterator = this.parameterTypeSignatures.iterator(); iterator.hasNext();) {
/* 185 */         (typeSignature = iterator.next()).setScanResult(paramScanResult);
/*     */       }
/*     */     }
/* 188 */     if (this.resultType != null) {
/* 189 */       this.resultType.setScanResult(paramScanResult);
/*     */     }
/* 191 */     if (this.throwsSignatures != null) {
/* 192 */       for (Iterator<ClassRefOrTypeVariableSignature> iterator = this.throwsSignatures.iterator(); iterator.hasNext();) {
/* 193 */         (classRefOrTypeVariableSignature = iterator.next()).setScanResult(paramScanResult);
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
/* 205 */     for (iterator = this.typeParameters.iterator(); iterator.hasNext();) {
/* 206 */       if ((typeParameter = iterator.next()) != null) {
/* 207 */         typeParameter.findReferencedClassNames(paramSet);
/*     */       }
/*     */     } 
/* 210 */     for (iterator = (Iterator)this.parameterTypeSignatures.iterator(); iterator.hasNext();) {
/* 211 */       if ((typeSignature = (TypeSignature)iterator.next()) != null) {
/* 212 */         typeSignature.findReferencedClassNames(paramSet);
/*     */       }
/*     */     } 
/* 215 */     this.resultType.findReferencedClassNames(paramSet);
/* 216 */     for (iterator = (Iterator)this.throwsSignatures.iterator(); iterator.hasNext();) {
/* 217 */       if ((classRefOrTypeVariableSignature = (ClassRefOrTypeVariableSignature)iterator.next()) != null) {
/* 218 */         classRefOrTypeVariableSignature.findReferencedClassNames(paramSet);
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
/* 234 */     HashSet<String> hashSet = new HashSet();
/* 235 */     findReferencedClassNames(hashSet);
/* 236 */     for (Iterator<String> iterator = hashSet.iterator(); iterator.hasNext(); ) {
/*     */       String str; ClassInfo classInfo;
/* 238 */       (classInfo = ClassInfo.getOrCreateClassInfo(str = iterator.next(), paramMap)).scanResult = this.scanResult;
/* 239 */       paramSet.add(classInfo);
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
/* 250 */     return this.typeParameters.hashCode() + this.parameterTypeSignatures.hashCode() * 7 + this.resultType.hashCode() * 15 + this.throwsSignatures
/* 251 */       .hashCode() * 31;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 259 */     if (paramObject == this)
/* 260 */       return true; 
/* 261 */     if (!(paramObject instanceof MethodTypeSignature)) {
/* 262 */       return false;
/*     */     }
/*     */     
/* 265 */     if (((MethodTypeSignature)(paramObject = paramObject)).typeParameters.equals(this.typeParameters) && ((MethodTypeSignature)paramObject).parameterTypeSignatures
/* 266 */       .equals(this.parameterTypeSignatures) && ((MethodTypeSignature)paramObject).resultType
/* 267 */       .equals(this.resultType) && ((MethodTypeSignature)paramObject).throwsSignatures.equals(this.throwsSignatures)) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void toStringInternal(boolean paramBoolean, AnnotationInfoList paramAnnotationInfoList, StringBuilder paramStringBuilder) {
/* 275 */     if (!this.typeParameters.isEmpty()) {
/* 276 */       paramStringBuilder.append('<');
/* 277 */       for (byte b1 = 0; b1 < this.typeParameters.size(); b1++) {
/* 278 */         if (b1 > 0) {
/* 279 */           paramStringBuilder.append(", ");
/*     */         }
/* 281 */         ((TypeParameter)this.typeParameters.get(b1)).toString(paramBoolean, paramStringBuilder);
/*     */       } 
/* 283 */       paramStringBuilder.append('>');
/*     */     } 
/*     */     
/* 286 */     if (paramStringBuilder.length() > 0) {
/* 287 */       paramStringBuilder.append(' ');
/*     */     }
/* 289 */     paramStringBuilder.append(this.resultType.toString());
/*     */     
/* 291 */     paramStringBuilder.append(" ("); byte b;
/* 292 */     for (b = 0; b < this.parameterTypeSignatures.size(); b++) {
/* 293 */       if (b > 0) {
/* 294 */         paramStringBuilder.append(", ");
/*     */       }
/* 296 */       ((TypeSignature)this.parameterTypeSignatures.get(b)).toString(paramBoolean, paramStringBuilder);
/*     */     } 
/* 298 */     paramStringBuilder.append(')');
/*     */     
/* 300 */     if (!this.throwsSignatures.isEmpty()) {
/* 301 */       paramStringBuilder.append(" throws ");
/* 302 */       for (b = 0; b < this.throwsSignatures.size(); b++) {
/* 303 */         if (b > 0) {
/* 304 */           paramStringBuilder.append(", ");
/*     */         }
/* 306 */         ((ClassRefOrTypeVariableSignature)this.throwsSignatures.get(b)).toString(paramBoolean, paramStringBuilder);
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
/*     */   
/*     */   static MethodTypeSignature parse(String paramString1, String paramString2) {
/*     */     List<?> list1;
/* 326 */     if (paramString1.equals("<init>"))
/*     */     {
/*     */       
/* 329 */       return new MethodTypeSignature(Collections.emptyList(), 
/* 330 */           Collections.emptyList(), new BaseTypeSignature('V'), 
/* 331 */           Collections.emptyList());
/*     */     }
/*     */     Parser parser;
/* 334 */     List<TypeParameter> list = TypeParameter.parseList(parser = new Parser(paramString1), paramString2);
/* 335 */     parser.expect('(');
/* 336 */     ArrayList<TypeSignature> arrayList = new ArrayList();
/* 337 */     while (parser.peek() != ')') {
/* 338 */       if (!parser.hasMore()) {
/* 339 */         throw new ParseException(parser, "Ran out of input while parsing method signature");
/*     */       }
/*     */       TypeSignature typeSignature1;
/* 342 */       if ((typeSignature1 = TypeSignature.parse(parser, paramString2)) == null) {
/* 343 */         throw new ParseException(parser, "Missing method parameter type signature");
/*     */       }
/* 345 */       arrayList.add(typeSignature1);
/*     */     } 
/* 347 */     parser.expect(')');
/*     */     TypeSignature typeSignature;
/* 349 */     if ((typeSignature = TypeSignature.parse(parser, paramString2)) == null) {
/* 350 */       throw new ParseException(parser, "Missing method result type signature");
/*     */     }
/*     */     
/* 353 */     if (parser.peek() == '^') {
/* 354 */       list1 = new ArrayList();
/* 355 */       while (parser.peek() == '^') {
/* 356 */         parser.expect('^');
/*     */         
/*     */         ClassRefTypeSignature classRefTypeSignature;
/* 359 */         if ((classRefTypeSignature = ClassRefTypeSignature.parse(parser, paramString2)) != null) {
/* 360 */           list1.add(classRefTypeSignature);
/*     */           continue;
/*     */         } 
/*     */         TypeVariableSignature typeVariableSignature;
/* 364 */         if ((typeVariableSignature = TypeVariableSignature.parse(parser, paramString2)) != null) {
/* 365 */           list1.add(typeVariableSignature); continue;
/*     */         } 
/* 367 */         throw new ParseException(parser, "Missing type variable signature");
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 372 */       list1 = Collections.emptyList();
/*     */     } 
/* 374 */     if (parser.hasMore()) {
/* 375 */       throw new ParseException(parser, "Extra characters at end of type descriptor");
/*     */     }
/* 377 */     MethodTypeSignature methodTypeSignature = new MethodTypeSignature(list, arrayList, typeSignature, (List)list1);
/*     */ 
/*     */     
/*     */     List list2;
/*     */ 
/*     */     
/* 383 */     if ((list2 = (List)parser.getState()) != null) {
/* 384 */       for (Iterator<TypeVariableSignature> iterator = list2.iterator(); iterator.hasNext();) {
/* 385 */         (typeVariableSignature = iterator.next()).containingMethodSignature = methodTypeSignature;
/*     */       }
/*     */     }
/* 388 */     return methodTypeSignature;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\MethodTypeSignature.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */