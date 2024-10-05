/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.types.ParseException;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FieldInfo
/*     */   extends ClassMemberInfo
/*     */   implements Comparable<FieldInfo>
/*     */ {
/*     */   private transient TypeSignature typeSignature;
/*     */   private transient TypeSignature typeDescriptor;
/*     */   private ObjectTypedValueWrapper constantInitializerValue;
/*     */   private transient List<Classfile.TypeAnnotationDecorator> typeAnnotationDecorators;
/*     */   
/*     */   FieldInfo() {}
/*     */   
/*     */   FieldInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, Object paramObject, AnnotationInfoList paramAnnotationInfoList, List<Classfile.TypeAnnotationDecorator> paramList) {
/*  91 */     super(paramString1, paramString2, paramInt, paramString3, paramString4, paramAnnotationInfoList);
/*  92 */     if (paramString2 == null) {
/*  93 */       throw new IllegalArgumentException("fieldName must not be null");
/*     */     }
/*  95 */     this.constantInitializerValue = (paramObject == null) ? null : new ObjectTypedValueWrapper(paramObject);
/*     */     
/*  97 */     this.typeAnnotationDecorators = paramList;
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
/*     */   @Deprecated
/*     */   public String getModifierStr() {
/* 110 */     return getModifiersStr();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getModifiersStr() {
/* 120 */     StringBuilder stringBuilder = new StringBuilder();
/* 121 */     TypeUtils.modifiersToString(this.modifiers, TypeUtils.ModifierType.FIELD, false, stringBuilder);
/* 122 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTransient() {
/* 131 */     return Modifier.isTransient(this.modifiers);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnum() {
/* 140 */     return ((this.modifiers & 0x4000) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeSignature getTypeDescriptor() {
/* 151 */     if (this.typeDescriptorStr == null) {
/* 152 */       return null;
/*     */     }
/* 154 */     if (this.typeDescriptor == null) {
/*     */       try {
/* 156 */         this.typeDescriptor = TypeSignature.parse(this.typeDescriptorStr, this.declaringClassName);
/* 157 */         this.typeDescriptor.setScanResult(this.scanResult);
/* 158 */         if (this.typeAnnotationDecorators != null) {
/* 159 */           for (Iterator<Classfile.TypeAnnotationDecorator> iterator = this.typeAnnotationDecorators.iterator(); iterator.hasNext();) {
/* 160 */             (typeAnnotationDecorator = iterator.next()).decorate(this.typeDescriptor);
/*     */           }
/*     */         }
/* 163 */       } catch (ParseException parseException) {
/* 164 */         throw new IllegalArgumentException(parseException);
/*     */       } 
/*     */     }
/* 167 */     return this.typeDescriptor;
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
/*     */   public TypeSignature getTypeSignature() {
/* 183 */     if (this.typeSignatureStr == null) {
/* 184 */       return null;
/*     */     }
/* 186 */     if (this.typeSignature == null) {
/*     */       try {
/* 188 */         this.typeSignature = TypeSignature.parse(this.typeSignatureStr, this.declaringClassName);
/* 189 */         this.typeSignature.setScanResult(this.scanResult);
/* 190 */         if (this.typeAnnotationDecorators != null) {
/* 191 */           for (Iterator<Classfile.TypeAnnotationDecorator> iterator = this.typeAnnotationDecorators.iterator(); iterator.hasNext();) {
/* 192 */             (typeAnnotationDecorator = iterator.next()).decorate(this.typeSignature);
/*     */           }
/*     */         }
/* 195 */       } catch (ParseException parseException) {
/* 196 */         throw new IllegalArgumentException("Invalid type signature for field " + 
/* 197 */             getClassName() + "." + getName() + (
/* 198 */             (getClassInfo() != null) ? (" in classpath element " + 
/* 199 */             getClassInfo().getClasspathElementURI()) : "") + " : " + this.typeSignatureStr, parseException);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 205 */     return this.typeSignature;
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
/*     */   public TypeSignature getTypeSignatureOrTypeDescriptor() {
/*     */     try {
/*     */       TypeSignature typeSignature;
/* 221 */       if ((typeSignature = getTypeSignature()) != null) {
/* 222 */         return typeSignature;
/*     */       }
/* 224 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 227 */     return getTypeDescriptor();
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
/*     */   public Object getConstantInitializerValue() {
/* 242 */     if (!this.scanResult.scanSpec.enableStaticFinalFieldConstantInitializerValues) {
/* 243 */       throw new IllegalArgumentException("Please call ClassGraph#enableStaticFinalFieldConstantInitializerValues() before #scan()");
/*     */     }
/*     */     
/* 246 */     return (this.constantInitializerValue == null) ? null : this.constantInitializerValue.get();
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
/*     */   public Field loadClassAndGetField() {
/*     */     try {
/* 260 */       return loadClass().getField(getName());
/* 261 */     } catch (NoSuchFieldException noSuchFieldException) {
/*     */       try {
/* 263 */         return loadClass().getDeclaredField(getName());
/* 264 */       } catch (NoSuchFieldException noSuchFieldException1) {
/* 265 */         throw new IllegalArgumentException("No such field: " + getClassName() + "." + getName());
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
/*     */   void handleRepeatableAnnotations(Set<String> paramSet) {
/* 279 */     if (this.annotationInfo != null) {
/* 280 */       this.annotationInfo.handleRepeatableAnnotations(paramSet, getClassInfo(), ClassInfo.RelType.FIELD_ANNOTATIONS, ClassInfo.RelType.CLASSES_WITH_FIELD_ANNOTATION, ClassInfo.RelType.CLASSES_WITH_NONPRIVATE_FIELD_ANNOTATION);
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
/*     */   void setScanResult(ScanResult paramScanResult) {
/* 293 */     super.setScanResult(paramScanResult);
/* 294 */     if (this.typeSignature != null) {
/* 295 */       this.typeSignature.setScanResult(paramScanResult);
/*     */     }
/* 297 */     if (this.typeDescriptor != null) {
/* 298 */       this.typeDescriptor.setScanResult(paramScanResult);
/*     */     }
/* 300 */     if (this.annotationInfo != null) {
/* 301 */       for (Iterator<AnnotationInfo> iterator = this.annotationInfo.iterator(); iterator.hasNext();) {
/* 302 */         (annotationInfo = iterator.next()).setScanResult(paramScanResult);
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
/*     */   protected void findReferencedClassInfo(Map<String, ClassInfo> paramMap, Set<ClassInfo> paramSet, LogNode paramLogNode) {
/*     */     try {
/*     */       TypeSignature typeSignature;
/* 320 */       if ((typeSignature = getTypeSignature()) != null) {
/* 321 */         typeSignature.findReferencedClassInfo(paramMap, paramSet, paramLogNode);
/*     */       }
/* 323 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 324 */       if (paramLogNode != null) {
/* 325 */         paramLogNode.log("Illegal type signature for field " + getClassName() + "." + getName() + ": " + 
/* 326 */             getTypeSignatureStr());
/*     */       }
/*     */     } 
/*     */     try {
/*     */       TypeSignature typeSignature;
/* 331 */       if ((typeSignature = getTypeDescriptor()) != null) {
/* 332 */         typeSignature.findReferencedClassInfo(paramMap, paramSet, paramLogNode);
/*     */       }
/* 334 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 335 */       if (paramLogNode != null) {
/* 336 */         paramLogNode.log("Illegal type descriptor for field " + getClassName() + "." + getName() + ": " + 
/* 337 */             getTypeDescriptorStr());
/*     */       }
/*     */     } 
/* 340 */     if (this.annotationInfo != null) {
/* 341 */       for (Iterator<AnnotationInfo> iterator = this.annotationInfo.iterator(); iterator.hasNext();) {
/* 342 */         (annotationInfo = iterator.next()).findReferencedClassInfo(paramMap, paramSet, paramLogNode);
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
/*     */   public boolean equals(Object paramObject) {
/* 358 */     if (paramObject == this)
/* 359 */       return true; 
/* 360 */     if (!(paramObject instanceof FieldInfo)) {
/* 361 */       return false;
/*     */     }
/* 363 */     paramObject = paramObject;
/* 364 */     return (this.declaringClassName.equals(((FieldInfo)paramObject).declaringClassName) && this.name.equals(((FieldInfo)paramObject).name));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 374 */     return this.name.hashCode() + this.declaringClassName.hashCode() * 11;
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
/*     */   public int compareTo(FieldInfo paramFieldInfo) {
/*     */     int i;
/* 387 */     if ((i = this.declaringClassName.compareTo(paramFieldInfo.declaringClassName)) != 0) {
/* 388 */       return i;
/*     */     }
/* 390 */     return this.name.compareTo(paramFieldInfo.name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void toString(boolean paramBoolean1, boolean paramBoolean2, StringBuilder paramStringBuilder) {
/* 396 */     if (this.annotationInfo != null) {
/* 397 */       for (AnnotationInfo annotationInfo : this.annotationInfo) {
/*     */         
/* 399 */         if (paramStringBuilder.length() > 0 && paramStringBuilder.charAt(paramStringBuilder.length() - 1) != ' ' && paramStringBuilder
/* 400 */           .charAt(paramStringBuilder.length() - 1) != '(') {
/* 401 */           paramStringBuilder.append(' ');
/*     */         }
/* 403 */         annotationInfo.toString(paramBoolean2, paramStringBuilder);
/*     */       } 
/*     */     }
/*     */     
/* 407 */     if (this.modifiers != 0 && paramBoolean1) {
/* 408 */       if (paramStringBuilder.length() > 0 && paramStringBuilder.charAt(paramStringBuilder.length() - 1) != ' ' && paramStringBuilder.charAt(paramStringBuilder.length() - 1) != '(') {
/* 409 */         paramStringBuilder.append(' ');
/*     */       }
/* 411 */       TypeUtils.modifiersToString(this.modifiers, TypeUtils.ModifierType.FIELD, false, paramStringBuilder);
/*     */     } 
/*     */     
/* 414 */     if (paramStringBuilder.length() > 0 && paramStringBuilder.charAt(paramStringBuilder.length() - 1) != ' ' && paramStringBuilder.charAt(paramStringBuilder.length() - 1) != '(') {
/* 415 */       paramStringBuilder.append(' ');
/*     */     }
/*     */     TypeSignature typeSignature;
/* 418 */     (typeSignature = getTypeSignatureOrTypeDescriptor()).toStringInternal(paramBoolean2, this.annotationInfo, paramStringBuilder);
/*     */     
/* 420 */     paramStringBuilder.append(' ');
/* 421 */     paramStringBuilder.append(this.name);
/*     */     
/* 423 */     if (this.constantInitializerValue != null) {
/* 424 */       Object object = this.constantInitializerValue.get();
/* 425 */       paramStringBuilder.append(" = ");
/* 426 */       if (object instanceof String) {
/* 427 */         paramStringBuilder.append('"').append(((String)object).replace("\\", "\\\\").replace("\"", "\\\"")).append('"'); return;
/* 428 */       }  if (object instanceof Character) {
/* 429 */         paramStringBuilder.append('\'').append(((Character)object).toString().replace("\\", "\\\\").replaceAll("'", "\\'"))
/* 430 */           .append('\''); return;
/*     */       } 
/* 432 */       paramStringBuilder.append((object == null) ? "null" : object.toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void toString(boolean paramBoolean, StringBuilder paramStringBuilder) {
/* 439 */     toString(true, paramBoolean, paramStringBuilder);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\FieldInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */