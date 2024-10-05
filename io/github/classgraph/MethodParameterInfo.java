/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Objects;
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
/*     */ public class MethodParameterInfo
/*     */ {
/*     */   private final MethodInfo methodInfo;
/*     */   final AnnotationInfo[] annotationInfo;
/*     */   private final int modifiers;
/*     */   private final TypeSignature typeDescriptor;
/*     */   private final TypeSignature typeSignature;
/*     */   private final String name;
/*     */   private ScanResult scanResult;
/*     */   
/*     */   MethodParameterInfo(MethodInfo paramMethodInfo, AnnotationInfo[] paramArrayOfAnnotationInfo, int paramInt, TypeSignature paramTypeSignature1, TypeSignature paramTypeSignature2, String paramString) {
/*  87 */     this.methodInfo = paramMethodInfo;
/*  88 */     this.name = paramString;
/*  89 */     this.modifiers = paramInt;
/*  90 */     this.typeDescriptor = paramTypeSignature1;
/*  91 */     this.typeSignature = paramTypeSignature2;
/*  92 */     this.annotationInfo = paramArrayOfAnnotationInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MethodInfo getMethodInfo() {
/* 103 */     return this.methodInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 113 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getModifiers() {
/* 123 */     return this.modifiers;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getModifiersStr() {
/* 133 */     StringBuilder stringBuilder = new StringBuilder();
/* 134 */     modifiersToString(this.modifiers, stringBuilder);
/* 135 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeSignature getTypeSignature() {
/* 145 */     return this.typeSignature;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeSignature getTypeDescriptor() {
/* 154 */     return this.typeDescriptor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeSignature getTypeSignatureOrTypeDescriptor() {
/* 163 */     return (this.typeSignature != null) ? this.typeSignature : this.typeDescriptor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationInfoList getAnnotationInfo() {
/* 172 */     if (!this.scanResult.scanSpec.enableAnnotationInfo) {
/* 173 */       throw new IllegalArgumentException("Please call ClassGraph#enableAnnotationInfo() before #scan()");
/*     */     }
/* 175 */     if (this.annotationInfo == null || this.annotationInfo.length == 0) {
/* 176 */       return AnnotationInfoList.EMPTY_LIST;
/*     */     }
/*     */     AnnotationInfoList annotationInfoList;
/* 179 */     Collections.addAll(annotationInfoList = new AnnotationInfoList(this.annotationInfo.length), this.annotationInfo);
/* 180 */     return AnnotationInfoList.getIndirectAnnotations(annotationInfoList, (ClassInfo)null);
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
/*     */   public AnnotationInfo getAnnotationInfo(Class<? extends Annotation> paramClass) {
/* 194 */     Assert.isAnnotation(paramClass);
/* 195 */     return getAnnotationInfo(paramClass.getName());
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
/* 209 */     return getAnnotationInfo().get(paramString);
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
/* 222 */     Assert.isAnnotation(paramClass);
/* 223 */     return getAnnotationInfoRepeatable(paramClass.getName());
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
/* 236 */     return getAnnotationInfo().getRepeatable(paramString);
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
/* 247 */     Assert.isAnnotation(paramClass);
/* 248 */     return hasAnnotation(paramClass.getName());
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
/* 259 */     return getAnnotationInfo().containsName(paramString);
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
/*     */   protected void setScanResult(ScanResult paramScanResult) {
/* 271 */     this.scanResult = paramScanResult;
/* 272 */     if (this.annotationInfo != null) {
/* 273 */       AnnotationInfo[] arrayOfAnnotationInfo; int i; byte b; for (i = (arrayOfAnnotationInfo = this.annotationInfo).length, b = 0; b < i; b++) {
/* 274 */         AnnotationInfo annotationInfo; (annotationInfo = arrayOfAnnotationInfo[b]).setScanResult(paramScanResult);
/*     */       } 
/*     */     } 
/* 277 */     if (this.typeDescriptor != null) {
/* 278 */       this.typeDescriptor.setScanResult(paramScanResult);
/*     */     }
/* 280 */     if (this.typeSignature != null) {
/* 281 */       this.typeSignature.setScanResult(paramScanResult);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFinal() {
/* 291 */     return Modifier.isFinal(this.modifiers);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSynthetic() {
/* 300 */     return ((this.modifiers & 0x1000) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isMandated() {
/* 309 */     return ((this.modifiers & 0x8000) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 319 */     if (paramObject == this)
/* 320 */       return true; 
/* 321 */     if (!(paramObject instanceof MethodParameterInfo)) {
/* 322 */       return false;
/*     */     }
/* 324 */     paramObject = paramObject;
/* 325 */     if (Objects.equals(this.methodInfo, ((MethodParameterInfo)paramObject).methodInfo) && 
/* 326 */       Objects.deepEquals(this.annotationInfo, ((MethodParameterInfo)paramObject).annotationInfo) && this.modifiers == ((MethodParameterInfo)paramObject).modifiers && 
/* 327 */       Objects.equals(this.typeDescriptor, ((MethodParameterInfo)paramObject).typeDescriptor) && 
/* 328 */       Objects.equals(this.typeSignature, ((MethodParameterInfo)paramObject).typeSignature) && Objects.equals(this.name, ((MethodParameterInfo)paramObject).name)) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 336 */     return Objects.hash(new Object[] { this.methodInfo, Integer.valueOf(Arrays.hashCode((Object[])this.annotationInfo)), this.typeDescriptor, this.typeSignature, this.name }) + this.modifiers;
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
/*     */   static void modifiersToString(int paramInt, StringBuilder paramStringBuilder) {
/* 349 */     if ((paramInt & 0x10) != 0) {
/* 350 */       paramStringBuilder.append("final ");
/*     */     }
/* 352 */     if ((paramInt & 0x1000) != 0) {
/* 353 */       paramStringBuilder.append("synthetic ");
/*     */     }
/* 355 */     if ((paramInt & 0x8000) != 0) {
/* 356 */       paramStringBuilder.append("mandated ");
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
/*     */   protected void toString(boolean paramBoolean, StringBuilder paramStringBuilder) {
/* 371 */     if (this.annotationInfo != null) {
/* 372 */       AnnotationInfo[] arrayOfAnnotationInfo; int i; byte b; for (i = (arrayOfAnnotationInfo = this.annotationInfo).length, b = 0; b < i; b++) {
/* 373 */         AnnotationInfo annotationInfo; (annotationInfo = arrayOfAnnotationInfo[b]).toString(paramBoolean, paramStringBuilder);
/* 374 */         paramStringBuilder.append(' ');
/*     */       } 
/*     */     } 
/*     */     
/* 378 */     modifiersToString(this.modifiers, paramStringBuilder);
/*     */     
/* 380 */     getTypeSignatureOrTypeDescriptor().toString(paramBoolean, paramStringBuilder);
/*     */     
/* 382 */     paramStringBuilder.append(' ');
/* 383 */     paramStringBuilder.append((this.name == null) ? "_unnamed_param" : this.name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toStringWithSimpleNames() {
/* 392 */     StringBuilder stringBuilder = new StringBuilder();
/* 393 */     toString(true, stringBuilder);
/* 394 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 404 */     StringBuilder stringBuilder = new StringBuilder();
/* 405 */     toString(false, stringBuilder);
/* 406 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\MethodParameterInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */