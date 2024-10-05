/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AnnotationEnumValue
/*     */   extends ScanResultObject
/*     */   implements Comparable<AnnotationEnumValue>
/*     */ {
/*     */   private String className;
/*     */   private String valueName;
/*     */   
/*     */   AnnotationEnumValue() {}
/*     */   
/*     */   AnnotationEnumValue(String paramString1, String paramString2) {
/*  59 */     this.className = paramString1;
/*  60 */     this.valueName = paramString2;
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
/*  72 */     return this.className;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getValueName() {
/*  81 */     return this.valueName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  91 */     return this.className + "." + this.valueName;
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
/*     */   public Object loadClassAndReturnEnumValue(boolean paramBoolean) {
/*     */     Class<?> clazz;
/* 107 */     if ((clazz = loadClass(paramBoolean)) == null) {
/* 108 */       if (paramBoolean) {
/* 109 */         return null;
/*     */       }
/* 111 */       throw new IllegalArgumentException("Enum class " + this.className + " could not be loaded");
/*     */     } 
/*     */     
/* 114 */     if (!clazz.isEnum()) {
/* 115 */       throw new IllegalArgumentException("Class " + this.className + " is not an enum");
/*     */     }
/*     */     
/*     */     try {
/* 119 */       Field field = clazz.getDeclaredField(this.valueName);
/* 120 */     } catch (ReflectiveOperationException|SecurityException reflectiveOperationException) {
/* 121 */       throw new IllegalArgumentException("Could not find enum constant " + this, reflectiveOperationException);
/*     */     } 
/* 123 */     if (!reflectiveOperationException.isEnumConstant()) {
/* 124 */       throw new IllegalArgumentException("Field " + this + " is not an enum constant");
/*     */     }
/*     */     try {
/* 127 */       return reflectiveOperationException.get(null);
/* 128 */     } catch (ReflectiveOperationException|SecurityException reflectiveOperationException1) {
/* 129 */       throw new IllegalArgumentException("Field " + this + " is not accessible", reflectiveOperationException1);
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
/*     */   public Object loadClassAndReturnEnumValue() {
/* 142 */     return loadClassAndReturnEnumValue(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(AnnotationEnumValue paramAnnotationEnumValue) {
/*     */     int i;
/* 153 */     return ((i = this.className.compareTo(paramAnnotationEnumValue.className)) == 0) ? this.valueName.compareTo(paramAnnotationEnumValue.valueName) : i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 161 */     if (paramObject == this)
/* 162 */       return true; 
/* 163 */     if (!(paramObject instanceof AnnotationEnumValue)) {
/* 164 */       return false;
/*     */     }
/* 166 */     return (compareTo((AnnotationEnumValue)paramObject) == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 174 */     return this.className.hashCode() * 11 + this.valueName.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void toString(boolean paramBoolean, StringBuilder paramStringBuilder) {
/* 179 */     paramStringBuilder.append(paramBoolean ? ClassInfo.getSimpleName(this.className) : this.className);
/* 180 */     paramStringBuilder.append('.');
/* 181 */     paramStringBuilder.append(this.valueName);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\AnnotationEnumValue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */