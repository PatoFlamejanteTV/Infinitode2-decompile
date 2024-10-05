/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
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
/*     */ public class AnnotationParameterValue
/*     */   extends ScanResultObject
/*     */   implements HasName, Comparable<AnnotationParameterValue>
/*     */ {
/*     */   private String name;
/*     */   private ObjectTypedValueWrapper value;
/*     */   
/*     */   AnnotationParameterValue() {}
/*     */   
/*     */   AnnotationParameterValue(String paramString, Object paramObject) {
/*  62 */     this.name = paramString;
/*  63 */     this.value = new ObjectTypedValueWrapper(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  73 */     return this.name;
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
/*     */   public Object getValue() {
/*  96 */     return (this.value == null) ? null : this.value.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setValue(Object paramObject) {
/* 107 */     this.value = new ObjectTypedValueWrapper(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getClassName() {
/* 118 */     throw new IllegalArgumentException("getClassName() cannot be called here");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ClassInfo getClassInfo() {
/* 126 */     throw new IllegalArgumentException("getClassInfo() cannot be called here");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setScanResult(ScanResult paramScanResult) {
/* 134 */     super.setScanResult(paramScanResult);
/* 135 */     if (this.value != null) {
/* 136 */       this.value.setScanResult(paramScanResult);
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
/* 151 */     if (this.value != null) {
/* 152 */       this.value.findReferencedClassInfo(paramMap, paramSet, paramLogNode);
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
/*     */   void convertWrapperArraysToPrimitiveArrays(ClassInfo paramClassInfo) {
/* 166 */     if (this.value != null) {
/* 167 */       this.value.convertWrapperArraysToPrimitiveArrays(paramClassInfo, this.name);
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
/*     */   Object instantiate(ClassInfo paramClassInfo) {
/* 179 */     return this.value.instantiateOrGet(paramClassInfo, this.name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(AnnotationParameterValue paramAnnotationParameterValue) {
/* 189 */     if (paramAnnotationParameterValue == this) {
/* 190 */       return 0;
/*     */     }
/*     */     int i;
/* 193 */     if ((i = this.name.compareTo(paramAnnotationParameterValue.getName())) != 0) {
/* 194 */       return i;
/*     */     }
/* 196 */     if (this.value.equals(paramAnnotationParameterValue.value)) {
/* 197 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 201 */     Object object1 = getValue();
/* 202 */     Object object2 = paramAnnotationParameterValue.getValue();
/* 203 */     return (object1 == null || object2 == null) ? (((object1 == null) ? 0 : 1) - ((object2 == null) ? 0 : 1)) : 
/* 204 */       toStringParamValueOnly().compareTo(paramAnnotationParameterValue.toStringParamValueOnly());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 212 */     if (paramObject == this)
/* 213 */       return true; 
/* 214 */     if (!(paramObject instanceof AnnotationParameterValue)) {
/* 215 */       return false;
/*     */     }
/* 217 */     paramObject = paramObject;
/* 218 */     if (this.name.equals(((AnnotationParameterValue)paramObject).name)) if (((this.value == null) ? true : false) == ((((AnnotationParameterValue)paramObject).value == null) ? true : false) && (this.value == null || this.value
/* 219 */         .equals(((AnnotationParameterValue)paramObject).value))) return true;
/*     */     
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 227 */     return Objects.hash(new Object[] { this.name, this.value });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void toString(boolean paramBoolean, StringBuilder paramStringBuilder) {
/* 234 */     paramStringBuilder.append(this.name);
/* 235 */     paramStringBuilder.append("=");
/* 236 */     toStringParamValueOnly(paramBoolean, paramStringBuilder);
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
/*     */   private static void toString(Object paramObject, boolean paramBoolean, StringBuilder paramStringBuilder) {
/* 250 */     if (paramObject == null) {
/* 251 */       paramStringBuilder.append("null"); return;
/* 252 */     }  if (paramObject instanceof ScanResultObject) {
/* 253 */       ((ScanResultObject)paramObject).toString(paramBoolean, paramStringBuilder); return;
/*     */     } 
/* 255 */     paramStringBuilder.append(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void toStringParamValueOnly(boolean paramBoolean, StringBuilder paramStringBuilder) {
/* 266 */     if (this.value == null) {
/* 267 */       paramStringBuilder.append("null"); return;
/*     */     } 
/*     */     Object object;
/*     */     Class<?> clazz;
/* 271 */     if ((clazz = (object = this.value.get()).getClass()).isArray()) {
/* 272 */       paramStringBuilder.append('{'); byte b; int i;
/* 273 */       for (b = 0, i = Array.getLength(object); b < i; b++) {
/* 274 */         if (b > 0) {
/* 275 */           paramStringBuilder.append(", ");
/*     */         }
/*     */         Object object1;
/* 278 */         toString(object1 = Array.get(object, b), paramBoolean, paramStringBuilder);
/*     */       } 
/* 280 */       paramStringBuilder.append('}'); return;
/* 281 */     }  if (object instanceof String) {
/* 282 */       paramStringBuilder.append('"');
/* 283 */       paramStringBuilder.append(object.toString().replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r"));
/* 284 */       paramStringBuilder.append('"'); return;
/* 285 */     }  if (object instanceof Character) {
/* 286 */       paramStringBuilder.append('\'');
/* 287 */       paramStringBuilder.append(object.toString().replace("'", "\\'").replace("\n", "\\n").replace("\r", "\\r"));
/* 288 */       paramStringBuilder.append('\''); return;
/*     */     } 
/* 290 */     toString(object, paramBoolean, paramStringBuilder);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String toStringParamValueOnly() {
/* 301 */     StringBuilder stringBuilder = new StringBuilder();
/* 302 */     toStringParamValueOnly(false, stringBuilder);
/* 303 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\AnnotationParameterValue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */