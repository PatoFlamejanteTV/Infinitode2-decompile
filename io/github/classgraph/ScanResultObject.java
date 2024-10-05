/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
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
/*     */ abstract class ScanResultObject
/*     */ {
/*     */   protected transient ScanResult scanResult;
/*     */   private transient ClassInfo classInfo;
/*     */   protected transient Class<?> classRef;
/*     */   
/*     */   void setScanResult(ScanResult paramScanResult) {
/*  59 */     this.scanResult = paramScanResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final Set<ClassInfo> findReferencedClassInfo(LogNode paramLogNode) {
/*  70 */     LinkedHashSet<ClassInfo> linkedHashSet = new LinkedHashSet();
/*  71 */     if (this.scanResult != null) {
/*  72 */       findReferencedClassInfo(this.scanResult.classNameToClassInfo, linkedHashSet, paramLogNode);
/*     */     }
/*  74 */     return linkedHashSet;
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
/*     */   protected void findReferencedClassInfo(Map<String, ClassInfo> paramMap, Set<ClassInfo> paramSet, LogNode paramLogNode) {
/*     */     ClassInfo classInfo;
/*  90 */     if ((classInfo = getClassInfo()) != null) {
/*  91 */       paramSet.add(classInfo);
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
/*     */   protected abstract String getClassName();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ClassInfo getClassInfo() {
/* 112 */     if (this.classInfo == null) {
/* 113 */       if (this.scanResult == null) {
/* 114 */         return null;
/*     */       }
/*     */       String str;
/* 117 */       if ((str = getClassName()) == null) {
/* 118 */         throw new IllegalArgumentException("Class name is not set");
/*     */       }
/* 120 */       this.classInfo = this.scanResult.getClassInfo(str);
/*     */     } 
/* 122 */     return this.classInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getClassInfoNameOrClassName() {
/*     */     String str;
/* 132 */     ClassInfo classInfo = null;
/*     */     try {
/* 134 */       classInfo = getClassInfo();
/* 135 */     } catch (IllegalArgumentException illegalArgumentException) {}
/*     */ 
/*     */     
/* 138 */     if (classInfo == null) {
/* 139 */       classInfo = this.classInfo;
/*     */     }
/* 141 */     if (classInfo != null) {
/*     */       
/* 143 */       str = classInfo.getName();
/*     */     } else {
/*     */       
/* 146 */       str = getClassName();
/*     */     } 
/* 148 */     if (str == null) {
/* 149 */       throw new IllegalArgumentException("Class name is not set");
/*     */     }
/* 151 */     return str;
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
/*     */   <T> Class<T> loadClass(Class<T> paramClass, boolean paramBoolean) {
/* 173 */     if (this.classRef == null) {
/* 174 */       String str = getClassInfoNameOrClassName();
/* 175 */       if (this.scanResult != null) {
/* 176 */         this.classRef = this.scanResult.loadClass(str, paramClass, paramBoolean);
/*     */       } else {
/*     */         
/*     */         try {
/* 180 */           this.classRef = Class.forName(str);
/* 181 */         } catch (Throwable throwable) {
/* 182 */           if (!paramBoolean) {
/* 183 */             throw new IllegalArgumentException("Could not load class " + str, throwable);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*     */     Class<?> clazz;
/* 190 */     return (Class)(clazz = this.classRef);
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
/*     */   <T> Class<T> loadClass(Class<T> paramClass) {
/* 208 */     return loadClass(paramClass, false);
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
/*     */   Class<?> loadClass(boolean paramBoolean) {
/* 223 */     if (this.classRef == null) {
/* 224 */       String str = getClassInfoNameOrClassName();
/* 225 */       if (this.scanResult != null) {
/* 226 */         this.classRef = this.scanResult.loadClass(str, paramBoolean);
/*     */       } else {
/*     */         
/*     */         try {
/* 230 */           this.classRef = Class.forName(str);
/* 231 */         } catch (Throwable throwable) {
/* 232 */           if (!paramBoolean) {
/* 233 */             throw new IllegalArgumentException("Could not load class " + str, throwable);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 238 */     return this.classRef;
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
/*     */   Class<?> loadClass() {
/* 250 */     return loadClass(false);
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
/*     */   protected abstract void toString(boolean paramBoolean, StringBuilder paramStringBuilder);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String toString(boolean paramBoolean) {
/* 273 */     StringBuilder stringBuilder = new StringBuilder();
/* 274 */     toString(paramBoolean, stringBuilder);
/* 275 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toStringWithSimpleNames() {
/* 286 */     StringBuilder stringBuilder = new StringBuilder();
/* 287 */     toString(true, stringBuilder);
/* 288 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 298 */     StringBuilder stringBuilder = new StringBuilder();
/* 299 */     toString(false, stringBuilder);
/* 300 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ScanResultObject.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */