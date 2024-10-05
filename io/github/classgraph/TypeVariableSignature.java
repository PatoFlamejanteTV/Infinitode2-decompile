/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.types.ParseException;
/*     */ import nonapi.io.github.classgraph.types.Parser;
/*     */ import nonapi.io.github.classgraph.types.TypeUtils;
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
/*     */ public final class TypeVariableSignature
/*     */   extends ClassRefOrTypeVariableSignature
/*     */ {
/*     */   private final String name;
/*     */   private final String definingClassName;
/*     */   MethodTypeSignature containingMethodSignature;
/*     */   private TypeParameter typeParameterCached;
/*     */   
/*     */   private TypeVariableSignature(String paramString1, String paramString2) {
/*  68 */     this.name = paramString1;
/*  69 */     this.definingClassName = paramString2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getName() {
/*  80 */     return this.name;
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
/*     */   public final TypeParameter resolve() {
/*  94 */     if (this.typeParameterCached != null) {
/*  95 */       return this.typeParameterCached;
/*     */     }
/*     */     
/*  98 */     if (this.containingMethodSignature != null && this.containingMethodSignature.typeParameters != null && 
/*  99 */       !this.containingMethodSignature.typeParameters.isEmpty()) {
/* 100 */       for (Iterator<TypeParameter> iterator = this.containingMethodSignature.typeParameters.iterator(); iterator.hasNext();) {
/* 101 */         if ((typeParameter1 = iterator.next()).name.equals(this.name)) {
/* 102 */           this.typeParameterCached = typeParameter1;
/* 103 */           return typeParameter1;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 108 */     if (getClassName() != null) {
/*     */       ClassInfo classInfo;
/* 110 */       if ((classInfo = getClassInfo()) == null) {
/* 111 */         throw new IllegalArgumentException("Could not find ClassInfo object for " + this.definingClassName);
/*     */       }
/* 113 */       ClassTypeSignature classTypeSignature = null;
/*     */       try {
/* 115 */         classTypeSignature = classInfo.getTypeSignature();
/* 116 */       } catch (Exception exception) {}
/*     */ 
/*     */       
/* 119 */       if (classTypeSignature != null && classTypeSignature.typeParameters != null && 
/* 120 */         !classTypeSignature.typeParameters.isEmpty()) {
/* 121 */         for (Iterator<TypeParameter> iterator = classTypeSignature.typeParameters.iterator(); iterator.hasNext();) {
/* 122 */           if ((typeParameter1 = iterator.next()).name.equals(this.name)) {
/* 123 */             this.typeParameterCached = typeParameter1;
/* 124 */             return typeParameter1;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*     */     TypeParameter typeParameter;
/*     */     
/* 133 */     (typeParameter = new TypeParameter(this.name, null, Collections.emptyList())).setScanResult(this.scanResult);
/* 134 */     this.typeParameterCached = typeParameter;
/* 135 */     return typeParameter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void addTypeAnnotation(List<Classfile.TypePathNode> paramList, AnnotationInfo paramAnnotationInfo) {
/* 142 */     if (paramList.isEmpty()) {
/* 143 */       addTypeAnnotation(paramAnnotationInfo); return;
/*     */     } 
/* 145 */     throw new IllegalArgumentException("Type variable should have empty typePath");
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
/*     */   static TypeVariableSignature parse(Parser paramParser, String paramString) {
/*     */     char c;
/* 164 */     if ((c = paramParser.peek()) == 'T') {
/* 165 */       paramParser.next();
/*     */       
/* 167 */       if (!TypeUtils.getIdentifierToken(paramParser, false)) {
/* 168 */         throw new ParseException(paramParser, "Could not parse type variable signature");
/*     */       }
/* 170 */       paramParser.expect(';');
/* 171 */       TypeVariableSignature typeVariableSignature = new TypeVariableSignature(paramParser.currToken(), paramString);
/*     */ 
/*     */ 
/*     */       
/*     */       List<TypeVariableSignature> list;
/*     */ 
/*     */       
/* 178 */       if ((list = (List)paramParser.getState()) == null) {
/* 179 */         paramParser.setState(list = new ArrayList());
/*     */       }
/* 181 */       list.add(typeVariableSignature);
/*     */       
/* 183 */       return typeVariableSignature;
/*     */     } 
/* 185 */     return null;
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
/*     */   protected final String getClassName() {
/* 199 */     return this.definingClassName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void findReferencedClassNames(Set<String> paramSet) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void setScanResult(ScanResult paramScanResult) {
/* 216 */     super.setScanResult(paramScanResult);
/* 217 */     if (this.typeParameterCached != null) {
/* 218 */       this.typeParameterCached.setScanResult(paramScanResult);
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
/* 229 */     return this.name.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 237 */     if (paramObject == this)
/* 238 */       return true; 
/* 239 */     if (!(paramObject instanceof TypeVariableSignature)) {
/* 240 */       return false;
/*     */     }
/*     */     
/* 243 */     if (((TypeVariableSignature)(paramObject = paramObject)).name.equals(this.name) && Objects.equals(((TypeVariableSignature)paramObject).typeAnnotationInfo, this.typeAnnotationInfo)) return true;  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equalsIgnoringTypeParams(TypeSignature paramTypeSignature) {
/* 251 */     if (paramTypeSignature instanceof ClassRefTypeSignature) {
/* 252 */       TypeParameter typeParameter; if (((ClassRefTypeSignature)paramTypeSignature).className.equals("java.lang.Object"))
/*     */       {
/*     */         
/* 255 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       try {
/* 260 */         typeParameter = resolve();
/* 261 */       } catch (IllegalArgumentException illegalArgumentException) {
/*     */ 
/*     */         
/* 264 */         return true;
/*     */       } 
/* 266 */       if (typeParameter.classBound == null && (typeParameter.interfaceBounds == null || typeParameter.interfaceBounds
/* 267 */         .isEmpty()))
/*     */       {
/*     */         
/* 270 */         return true;
/*     */       }
/* 272 */       if (typeParameter.classBound != null) {
/* 273 */         if (typeParameter.classBound instanceof ClassRefTypeSignature) {
/* 274 */           if (typeParameter.classBound.equals(paramTypeSignature))
/*     */           {
/* 276 */             return true; } 
/*     */         } else {
/* 278 */           if (typeParameter.classBound instanceof TypeVariableSignature)
/*     */           {
/* 280 */             return equalsIgnoringTypeParams(typeParameter.classBound);
/*     */           }
/* 282 */           return false;
/*     */         } 
/*     */       }
/* 285 */       if (typeParameter.interfaceBounds != null) {
/* 286 */         for (Iterator<ReferenceTypeSignature> iterator = typeParameter.interfaceBounds.iterator(); iterator.hasNext(); ) {
/* 287 */           ReferenceTypeSignature referenceTypeSignature; if (referenceTypeSignature = iterator.next() instanceof ClassRefTypeSignature) {
/* 288 */             if (referenceTypeSignature.equals(paramTypeSignature))
/*     */             {
/* 290 */               return true; }  continue;
/*     */           } 
/* 292 */           if (referenceTypeSignature instanceof TypeVariableSignature)
/*     */           {
/* 294 */             return equalsIgnoringTypeParams(referenceTypeSignature);
/*     */           }
/* 296 */           return false;
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 304 */       return false;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 310 */     return equals(paramTypeSignature);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toStringWithTypeBound() {
/*     */     try {
/* 322 */       return resolve().toString();
/* 323 */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */       
/* 325 */       return this.name;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void toStringInternal(boolean paramBoolean, AnnotationInfoList paramAnnotationInfoList, StringBuilder paramStringBuilder) {
/* 332 */     if (this.typeAnnotationInfo != null) {
/* 333 */       for (AnnotationInfo annotationInfo : this.typeAnnotationInfo) {
/* 334 */         if (paramAnnotationInfoList == null || !paramAnnotationInfoList.contains(annotationInfo)) {
/* 335 */           annotationInfo.toString(paramBoolean, paramStringBuilder);
/* 336 */           paramStringBuilder.append(' ');
/*     */         } 
/*     */       } 
/*     */     }
/* 340 */     paramStringBuilder.append(this.name);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\TypeVariableSignature.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */