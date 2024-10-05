/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.types.Parser;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BaseTypeSignature
/*     */   extends TypeSignature
/*     */ {
/*     */   private final char typeSignatureChar;
/*     */   
/*     */   BaseTypeSignature(char paramChar) {
/*  50 */     switch (paramChar) {
/*     */       case 'B':
/*     */       case 'C':
/*     */       case 'D':
/*     */       case 'F':
/*     */       case 'I':
/*     */       case 'J':
/*     */       case 'S':
/*     */       case 'V':
/*     */       case 'Z':
/*  60 */         this.typeSignatureChar = paramChar;
/*     */         return;
/*     */     } 
/*  63 */     throw new IllegalArgumentException("Illegal " + BaseTypeSignature.class
/*  64 */         .getSimpleName() + " type: '" + paramChar + "'");
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
/*     */   static String getTypeStr(char paramChar) {
/*  78 */     switch (paramChar) {
/*     */       case 'B':
/*  80 */         return "byte";
/*     */       case 'C':
/*  82 */         return "char";
/*     */       case 'D':
/*  84 */         return "double";
/*     */       case 'F':
/*  86 */         return "float";
/*     */       case 'I':
/*  88 */         return "int";
/*     */       case 'J':
/*  90 */         return "long";
/*     */       case 'S':
/*  92 */         return "short";
/*     */       case 'Z':
/*  94 */         return "boolean";
/*     */       case 'V':
/*  96 */         return "void";
/*     */     } 
/*  98 */     return null;
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
/*     */   static char getTypeChar(String paramString) {
/* 110 */     switch (paramString) {
/*     */       case "byte":
/* 112 */         return 'B';
/*     */       case "char":
/* 114 */         return 'C';
/*     */       case "double":
/* 116 */         return 'D';
/*     */       case "float":
/* 118 */         return 'F';
/*     */       case "int":
/* 120 */         return 'I';
/*     */       case "long":
/* 122 */         return 'J';
/*     */       case "short":
/* 124 */         return 'S';
/*     */       case "boolean":
/* 126 */         return 'Z';
/*     */       case "void":
/* 128 */         return 'V';
/*     */     } 
/* 130 */     return Character.MIN_VALUE;
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
/*     */   static Class<?> getType(char paramChar) {
/* 142 */     switch (paramChar) {
/*     */       case 'B':
/* 144 */         return byte.class;
/*     */       case 'C':
/* 146 */         return char.class;
/*     */       case 'D':
/* 148 */         return double.class;
/*     */       case 'F':
/* 150 */         return float.class;
/*     */       case 'I':
/* 152 */         return int.class;
/*     */       case 'J':
/* 154 */         return long.class;
/*     */       case 'S':
/* 156 */         return short.class;
/*     */       case 'Z':
/* 158 */         return boolean.class;
/*     */       case 'V':
/* 160 */         return void.class;
/*     */     } 
/* 162 */     return null;
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
/*     */   public char getTypeSignatureChar() {
/* 174 */     return this.typeSignatureChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTypeStr() {
/* 183 */     return getTypeStr(this.typeSignatureChar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getType() {
/* 192 */     return getType(this.typeSignatureChar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addTypeAnnotation(List<Classfile.TypePathNode> paramList, AnnotationInfo paramAnnotationInfo) {
/* 199 */     addTypeAnnotation(paramAnnotationInfo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Class<?> loadClass() {
/* 209 */     return getType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   <T> Class<T> loadClass(Class<T> paramClass) {
/* 217 */     Class<?> clazz = getType();
/* 218 */     if (!paramClass.isAssignableFrom(clazz)) {
/* 219 */       throw new IllegalArgumentException("Primitive class " + getTypeStr() + " cannot be cast to " + paramClass
/* 220 */           .getName());
/*     */     }
/*     */ 
/*     */     
/* 224 */     return paramClass = (Class)clazz;
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
/*     */   static BaseTypeSignature parse(Parser paramParser) {
/* 237 */     switch (paramParser.peek()) {
/*     */       case 'B':
/* 239 */         paramParser.next();
/* 240 */         return new BaseTypeSignature('B');
/*     */       case 'C':
/* 242 */         paramParser.next();
/* 243 */         return new BaseTypeSignature('C');
/*     */       case 'D':
/* 245 */         paramParser.next();
/* 246 */         return new BaseTypeSignature('D');
/*     */       case 'F':
/* 248 */         paramParser.next();
/* 249 */         return new BaseTypeSignature('F');
/*     */       case 'I':
/* 251 */         paramParser.next();
/* 252 */         return new BaseTypeSignature('I');
/*     */       case 'J':
/* 254 */         paramParser.next();
/* 255 */         return new BaseTypeSignature('J');
/*     */       case 'S':
/* 257 */         paramParser.next();
/* 258 */         return new BaseTypeSignature('S');
/*     */       case 'Z':
/* 260 */         paramParser.next();
/* 261 */         return new BaseTypeSignature('Z');
/*     */       case 'V':
/* 263 */         paramParser.next();
/* 264 */         return new BaseTypeSignature('V');
/*     */     } 
/* 266 */     return null;
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
/* 277 */     return getTypeStr();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ClassInfo getClassInfo() {
/* 285 */     return null;
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
/*     */   protected void findReferencedClassNames(Set<String> paramSet) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setScanResult(ScanResult paramScanResult) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 320 */     return this.typeSignatureChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 328 */     if (paramObject == this)
/* 329 */       return true; 
/* 330 */     if (!(paramObject instanceof BaseTypeSignature)) {
/* 331 */       return false;
/*     */     }
/* 333 */     paramObject = paramObject;
/* 334 */     return (Objects.equals(this.typeAnnotationInfo, ((BaseTypeSignature)paramObject).typeAnnotationInfo) && ((BaseTypeSignature)paramObject).typeSignatureChar == this.typeSignatureChar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equalsIgnoringTypeParams(TypeSignature paramTypeSignature) {
/* 343 */     if (!(paramTypeSignature instanceof BaseTypeSignature)) {
/* 344 */       return false;
/*     */     }
/* 346 */     return (this.typeSignatureChar == ((BaseTypeSignature)paramTypeSignature).typeSignatureChar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void toStringInternal(boolean paramBoolean, AnnotationInfoList paramAnnotationInfoList, StringBuilder paramStringBuilder) {
/* 354 */     if (this.typeAnnotationInfo != null) {
/* 355 */       for (AnnotationInfo annotationInfo : this.typeAnnotationInfo) {
/* 356 */         if (paramAnnotationInfoList == null || !paramAnnotationInfoList.contains(annotationInfo)) {
/* 357 */           annotationInfo.toString(paramBoolean, paramStringBuilder);
/* 358 */           paramStringBuilder.append(' ');
/*     */         } 
/*     */       } 
/*     */     }
/* 362 */     paramStringBuilder.append(getTypeStr());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\BaseTypeSignature.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */