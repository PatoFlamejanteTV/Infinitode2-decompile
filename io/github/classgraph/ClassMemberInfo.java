/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.Modifier;
/*     */ import nonapi.io.github.classgraph.utils.Assert;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ClassMemberInfo
/*     */   extends ScanResultObject
/*     */   implements HasName
/*     */ {
/*     */   protected String declaringClassName;
/*     */   protected String name;
/*     */   protected int modifiers;
/*     */   protected String typeDescriptorStr;
/*     */   protected String typeSignatureStr;
/*     */   protected AnnotationInfoList annotationInfo;
/*     */   
/*     */   ClassMemberInfo() {}
/*     */   
/*     */   public ClassMemberInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, AnnotationInfoList paramAnnotationInfoList) {
/*  91 */     this.declaringClassName = paramString1;
/*  92 */     this.name = paramString2;
/*  93 */     this.modifiers = paramInt;
/*  94 */     this.typeDescriptorStr = paramString3;
/*  95 */     this.typeSignatureStr = paramString4;
/*  96 */     this.annotationInfo = (paramAnnotationInfoList == null || paramAnnotationInfoList.isEmpty()) ? null : paramAnnotationInfoList;
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
/*     */   public ClassInfo getClassInfo() {
/* 110 */     return super.getClassInfo();
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
/*     */   public String getClassName() {
/* 122 */     return this.declaringClassName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 132 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getModifiers() {
/* 143 */     return this.modifiers;
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
/*     */   public boolean isPublic() {
/* 159 */     return Modifier.isPublic(this.modifiers);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPrivate() {
/* 168 */     return Modifier.isPrivate(this.modifiers);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isProtected() {
/* 177 */     return Modifier.isProtected(this.modifiers);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStatic() {
/* 186 */     return Modifier.isStatic(this.modifiers);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFinal() {
/* 195 */     return Modifier.isFinal(this.modifiers);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSynthetic() {
/* 204 */     return ((this.modifiers & 0x1000) != 0);
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
/*     */   public String getTypeDescriptorStr() {
/* 224 */     return this.typeDescriptorStr;
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
/*     */   public String getTypeSignatureStr() {
/* 248 */     return this.typeSignatureStr;
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
/*     */   public String getTypeSignatureOrTypeDescriptorStr() {
/* 270 */     if (this.typeSignatureStr != null) {
/* 271 */       return this.typeSignatureStr;
/*     */     }
/* 273 */     return this.typeDescriptorStr;
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
/*     */   public AnnotationInfoList getAnnotationInfo() {
/* 286 */     if (!this.scanResult.scanSpec.enableAnnotationInfo) {
/* 287 */       throw new IllegalArgumentException("Please call ClassGraph#enableAnnotationInfo() before #scan()");
/*     */     }
/* 289 */     return (this.annotationInfo == null) ? AnnotationInfoList.EMPTY_LIST : 
/* 290 */       AnnotationInfoList.getIndirectAnnotations(this.annotationInfo, (ClassInfo)null);
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
/*     */   public AnnotationInfo getAnnotationInfo(Class<? extends Annotation> paramClass) {
/* 303 */     Assert.isAnnotation(paramClass);
/* 304 */     return getAnnotationInfo(paramClass.getName());
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
/*     */   public AnnotationInfo getAnnotationInfo(String paramString) {
/* 318 */     return getAnnotationInfo().get(paramString);
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
/*     */   public AnnotationInfoList getAnnotationInfoRepeatable(Class<? extends Annotation> paramClass) {
/* 331 */     Assert.isAnnotation(paramClass);
/* 332 */     return getAnnotationInfoRepeatable(paramClass.getName());
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
/*     */   public AnnotationInfoList getAnnotationInfoRepeatable(String paramString) {
/* 345 */     return getAnnotationInfo().getRepeatable(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasAnnotation(Class<? extends Annotation> paramClass) {
/* 356 */     Assert.isAnnotation(paramClass);
/* 357 */     return hasAnnotation(paramClass.getName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasAnnotation(String paramString) {
/* 368 */     return getAnnotationInfo().containsName(paramString);
/*     */   }
/*     */   
/*     */   public abstract String getModifiersStr();
/*     */   
/*     */   public abstract HierarchicalTypeSignature getTypeDescriptor();
/*     */   
/*     */   public abstract HierarchicalTypeSignature getTypeSignature();
/*     */   
/*     */   public abstract HierarchicalTypeSignature getTypeSignatureOrTypeDescriptor();
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ClassMemberInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */