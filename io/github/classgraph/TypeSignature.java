/*     */ package io.github.classgraph;
/*     */ 
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
/*     */ public abstract class TypeSignature
/*     */   extends HierarchicalTypeSignature
/*     */ {
/*     */   protected void findReferencedClassNames(Set<String> paramSet) {
/*     */     String str;
/*  60 */     if ((str = getClassName()) != null && !str.isEmpty()) {
/*  61 */       paramSet.add(getClassName());
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
/*  76 */     HashSet<String> hashSet = new HashSet();
/*  77 */     findReferencedClassNames(hashSet);
/*  78 */     for (Iterator<String> iterator = hashSet.iterator(); iterator.hasNext(); ) {
/*     */       String str; ClassInfo classInfo;
/*  80 */       (classInfo = ClassInfo.getOrCreateClassInfo(str = iterator.next(), paramMap)).scanResult = this.scanResult;
/*  81 */       paramSet.add(classInfo);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationInfoList getTypeAnnotationInfo() {
/*  91 */     return this.typeAnnotationInfo;
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
/*     */   public abstract boolean equalsIgnoringTypeParams(TypeSignature paramTypeSignature);
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
/*     */   static TypeSignature parse(Parser paramParser, String paramString) {
/*     */     ReferenceTypeSignature referenceTypeSignature;
/* 117 */     if ((referenceTypeSignature = ReferenceTypeSignature.parseReferenceTypeSignature(paramParser, paramString)) != null) {
/* 118 */       return referenceTypeSignature;
/*     */     }
/*     */     BaseTypeSignature baseTypeSignature;
/* 121 */     if ((baseTypeSignature = BaseTypeSignature.parse(paramParser)) != null) {
/* 122 */       return baseTypeSignature;
/*     */     }
/* 124 */     return null;
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
/*     */   static TypeSignature parse(String paramString1, String paramString2) {
/*     */     Parser parser;
/*     */     TypeSignature typeSignature;
/* 142 */     if ((typeSignature = parse(parser = new Parser(paramString1), paramString2)) == null) {
/* 143 */       throw new ParseException(parser, "Could not parse type signature");
/*     */     }
/* 145 */     if (parser.hasMore()) {
/* 146 */       throw new ParseException(parser, "Extra characters at end of type descriptor");
/*     */     }
/* 148 */     return typeSignature;
/*     */   }
/*     */   
/*     */   protected abstract void addTypeAnnotation(List<Classfile.TypePathNode> paramList, AnnotationInfo paramAnnotationInfo);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\TypeSignature.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */