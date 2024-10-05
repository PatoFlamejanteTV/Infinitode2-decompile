/*     */ package io.github.classgraph;
/*     */ 
/*     */ import nonapi.io.github.classgraph.types.ParseException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AnnotationClassRef
/*     */   extends ScanResultObject
/*     */ {
/*     */   private String typeDescriptorStr;
/*     */   private transient TypeSignature typeSignature;
/*     */   private transient String className;
/*     */   
/*     */   AnnotationClassRef() {}
/*     */   
/*     */   AnnotationClassRef(String paramString) {
/*  61 */     this.typeDescriptorStr = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  72 */     return getClassName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TypeSignature getTypeSignature() {
/*  82 */     if (this.typeSignature == null) {
/*     */       
/*     */       try {
/*     */         
/*  86 */         this.typeSignature = TypeSignature.parse(this.typeDescriptorStr, (String)null);
/*  87 */         this.typeSignature.setScanResult(this.scanResult);
/*  88 */       } catch (ParseException parseException) {
/*  89 */         throw new IllegalArgumentException(parseException);
/*     */       } 
/*     */     }
/*  92 */     return this.typeSignature;
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
/*     */   public Class<?> loadClass(boolean paramBoolean) {
/* 106 */     getTypeSignature();
/* 107 */     if (this.typeSignature instanceof BaseTypeSignature)
/* 108 */       return ((BaseTypeSignature)this.typeSignature).getType(); 
/* 109 */     if (this.typeSignature instanceof ClassRefTypeSignature)
/* 110 */       return this.typeSignature.loadClass(paramBoolean); 
/* 111 */     if (this.typeSignature instanceof ArrayTypeSignature) {
/* 112 */       return this.typeSignature.loadClass(paramBoolean);
/*     */     }
/* 114 */     throw new IllegalArgumentException("Got unexpected type " + this.typeSignature.getClass().getName() + " for ref type signature: " + this.typeDescriptorStr);
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
/*     */   public Class<?> loadClass() {
/* 128 */     return loadClass(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getClassName() {
/* 138 */     if (this.className == null) {
/* 139 */       getTypeSignature();
/* 140 */       if (this.typeSignature instanceof BaseTypeSignature) {
/* 141 */         this.className = ((BaseTypeSignature)this.typeSignature).getTypeStr();
/* 142 */       } else if (this.typeSignature instanceof ClassRefTypeSignature) {
/* 143 */         this.className = ((ClassRefTypeSignature)this.typeSignature).getFullyQualifiedClassName();
/* 144 */       } else if (this.typeSignature instanceof ArrayTypeSignature) {
/* 145 */         this.className = this.typeSignature.getClassName();
/*     */       } else {
/* 147 */         throw new IllegalArgumentException("Got unexpected type " + this.typeSignature.getClass().getName() + " for ref type signature: " + this.typeDescriptorStr);
/*     */       } 
/*     */     } 
/*     */     
/* 151 */     return this.className;
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
/*     */   public ClassInfo getClassInfo() {
/* 164 */     getTypeSignature();
/* 165 */     return this.typeSignature.getClassInfo();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setScanResult(ScanResult paramScanResult) {
/* 173 */     super.setScanResult(paramScanResult);
/* 174 */     if (this.typeSignature != null) {
/* 175 */       this.typeSignature.setScanResult(paramScanResult);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 186 */     return getTypeSignature().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 194 */     if (paramObject == this)
/* 195 */       return true; 
/* 196 */     if (!(paramObject instanceof AnnotationClassRef)) {
/* 197 */       return false;
/*     */     }
/* 199 */     return getTypeSignature().equals(((AnnotationClassRef)paramObject).getTypeSignature());
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
/*     */   protected void toString(boolean paramBoolean, StringBuilder paramStringBuilder) {
/* 218 */     paramStringBuilder.append(getTypeSignature().toString(paramBoolean)).append(".class");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\AnnotationClassRef.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */