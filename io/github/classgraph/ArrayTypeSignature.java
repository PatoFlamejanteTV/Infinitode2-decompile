/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.types.ParseException;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArrayTypeSignature
/*     */   extends ReferenceTypeSignature
/*     */ {
/*     */   private final String typeSignatureStr;
/*     */   private String className;
/*     */   private ArrayClassInfo arrayClassInfo;
/*     */   private Class<?> elementClassRef;
/*     */   private final TypeSignature nestedType;
/*     */   
/*     */   ArrayTypeSignature(TypeSignature paramTypeSignature, int paramInt, String paramString) {
/*  71 */     boolean bool = paramString.startsWith("[[");
/*  72 */     if (paramInt <= 0)
/*  73 */       throw new IllegalArgumentException("numDims < 1"); 
/*  74 */     if (((paramInt >= 2)) != bool) {
/*  75 */       throw new IllegalArgumentException("numDims does not match type signature");
/*     */     }
/*  77 */     this.typeSignatureStr = paramString;
/*  78 */     this
/*     */       
/*  80 */       .nestedType = bool ? new ArrayTypeSignature(paramTypeSignature, paramInt - 1, paramString.substring(1)) : paramTypeSignature;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTypeSignatureStr() {
/*  91 */     return this.typeSignatureStr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeSignature getElementTypeSignature() {
/* 100 */     ArrayTypeSignature arrayTypeSignature = this;
/* 101 */     while (arrayTypeSignature.nestedType instanceof ArrayTypeSignature) {
/* 102 */       arrayTypeSignature = (ArrayTypeSignature)arrayTypeSignature.nestedType;
/*     */     }
/* 104 */     return arrayTypeSignature.getNestedType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumDimensions() {
/* 113 */     byte b = 1;
/* 114 */     ArrayTypeSignature arrayTypeSignature = this;
/* 115 */     while (arrayTypeSignature.nestedType instanceof ArrayTypeSignature) {
/* 116 */       arrayTypeSignature = (ArrayTypeSignature)arrayTypeSignature.nestedType;
/* 117 */       b++;
/*     */     } 
/* 119 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TypeSignature getNestedType() {
/* 129 */     return this.nestedType;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addTypeAnnotation(List<Classfile.TypePathNode> paramList, AnnotationInfo paramAnnotationInfo) {
/* 134 */     if (paramList.isEmpty()) {
/* 135 */       addTypeAnnotation(paramAnnotationInfo); return;
/*     */     } 
/*     */     Classfile.TypePathNode typePathNode;
/* 138 */     if ((typePathNode = paramList.get(0)).typePathKind != 0 || typePathNode.typeArgumentIdx != 0) {
/* 139 */       throw new IllegalArgumentException("typePath element contains bad values: " + typePathNode);
/*     */     }
/* 141 */     this.nestedType.addTypeAnnotation(paramList.subList(1, paramList.size()), paramAnnotationInfo);
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
/*     */   public AnnotationInfoList getTypeAnnotationInfo() {
/* 155 */     return this.typeAnnotationInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getClassName() {
/* 165 */     if (this.className == null) {
/* 166 */       this.className = toString();
/*     */     }
/* 168 */     return this.className;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ClassInfo getClassInfo() {
/* 176 */     return getArrayClassInfo();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayClassInfo getArrayClassInfo() {
/* 185 */     if (this.arrayClassInfo == null) {
/* 186 */       if (this.scanResult != null) {
/* 187 */         String str = getClassName();
/*     */         
/* 189 */         this.arrayClassInfo = (ArrayClassInfo)this.scanResult.classNameToClassInfo.get(str);
/* 190 */         if (this.arrayClassInfo == null) {
/* 191 */           this.scanResult.classNameToClassInfo.put(str, this.arrayClassInfo = new ArrayClassInfo(this));
/* 192 */           this.arrayClassInfo.setScanResult(this.scanResult);
/*     */         } 
/*     */       } else {
/*     */         
/* 196 */         this.arrayClassInfo = new ArrayClassInfo(this);
/*     */       } 
/*     */     }
/* 199 */     return this.arrayClassInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setScanResult(ScanResult paramScanResult) {
/* 207 */     super.setScanResult(paramScanResult);
/* 208 */     this.nestedType.setScanResult(paramScanResult);
/* 209 */     if (this.arrayClassInfo != null) {
/* 210 */       this.arrayClassInfo.setScanResult(paramScanResult);
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
/*     */   protected void findReferencedClassNames(Set<String> paramSet) {
/* 222 */     this.nestedType.findReferencedClassNames(paramSet);
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
/*     */   public Class<?> loadElementClass(boolean paramBoolean) {
/* 237 */     if (this.elementClassRef == null) {
/*     */       TypeSignature typeSignature;
/*     */       
/* 240 */       if (typeSignature = getElementTypeSignature() instanceof BaseTypeSignature) {
/* 241 */         this.elementClassRef = ((BaseTypeSignature)typeSignature).getType();
/*     */       }
/* 243 */       else if (this.scanResult != null) {
/* 244 */         this.elementClassRef = typeSignature.loadClass(paramBoolean);
/*     */       } else {
/*     */         
/* 247 */         String str = typeSignature.getClassName();
/*     */         try {
/* 249 */           this.elementClassRef = Class.forName(str);
/* 250 */         } catch (Throwable throwable) {
/* 251 */           if (!paramBoolean) {
/* 252 */             throw new IllegalArgumentException("Could not load array element class " + str, throwable);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 259 */     return this.elementClassRef;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> loadElementClass() {
/* 270 */     return loadElementClass(false);
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
/*     */   public Class<?> loadClass(boolean paramBoolean) {
/* 286 */     if (this.classRef == null) {
/*     */       Class<?> clazz;
/*     */       
/* 289 */       if (paramBoolean) {
/*     */         try {
/* 291 */           clazz = loadElementClass();
/* 292 */         } catch (IllegalArgumentException illegalArgumentException) {
/* 293 */           return null;
/*     */         } 
/*     */       } else {
/* 296 */         clazz = loadElementClass();
/*     */       } 
/* 298 */       if (clazz == null) {
/* 299 */         throw new IllegalArgumentException("Could not load array element class " + 
/* 300 */             getElementTypeSignature());
/*     */       }
/*     */       
/* 303 */       Object object = Array.newInstance(clazz, new int[getNumDimensions()]);
/*     */       
/* 305 */       this.classRef = object.getClass();
/*     */     } 
/* 307 */     return this.classRef;
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
/*     */   public Class<?> loadClass() {
/* 320 */     return loadClass(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 330 */     return 1 + this.nestedType.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 338 */     if (paramObject == this)
/* 339 */       return true; 
/* 340 */     if (!(paramObject instanceof ArrayTypeSignature)) {
/* 341 */       return false;
/*     */     }
/* 343 */     paramObject = paramObject;
/* 344 */     if (Objects.equals(this.typeAnnotationInfo, ((ArrayTypeSignature)paramObject).typeAnnotationInfo) && this.nestedType
/* 345 */       .equals(((ArrayTypeSignature)paramObject).nestedType)) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equalsIgnoringTypeParams(TypeSignature paramTypeSignature) {
/* 353 */     if (this == paramTypeSignature) {
/* 354 */       return true;
/*     */     }
/* 356 */     if (!(paramTypeSignature instanceof ArrayTypeSignature)) {
/* 357 */       return false;
/*     */     }
/* 359 */     paramTypeSignature = paramTypeSignature;
/* 360 */     return this.nestedType.equalsIgnoringTypeParams(((ArrayTypeSignature)paramTypeSignature).nestedType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void toStringInternal(boolean paramBoolean, AnnotationInfoList paramAnnotationInfoList, StringBuilder paramStringBuilder) {
/* 369 */     getElementTypeSignature().toStringInternal(paramBoolean, paramAnnotationInfoList, paramStringBuilder);
/*     */ 
/*     */     
/* 372 */     ArrayTypeSignature arrayTypeSignature = this; while (true) {
/* 373 */       if (arrayTypeSignature.typeAnnotationInfo != null && !arrayTypeSignature.typeAnnotationInfo.isEmpty()) {
/* 374 */         for (AnnotationInfo annotationInfo : arrayTypeSignature.typeAnnotationInfo) {
/* 375 */           if (paramStringBuilder.length() == 0 || paramStringBuilder.charAt(paramStringBuilder.length() - 1) != ' ') {
/* 376 */             paramStringBuilder.append(' ');
/*     */           }
/* 378 */           annotationInfo.toString(paramBoolean, paramStringBuilder);
/*     */         } 
/* 380 */         paramStringBuilder.append(' ');
/*     */       } 
/*     */       
/* 383 */       paramStringBuilder.append("[]");
/*     */       
/* 385 */       if (arrayTypeSignature.nestedType instanceof ArrayTypeSignature) {
/* 386 */         arrayTypeSignature = (ArrayTypeSignature)arrayTypeSignature.nestedType;
/*     */         continue;
/*     */       } 
/*     */       break;
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
/*     */ 
/*     */ 
/*     */   
/*     */   static ArrayTypeSignature parse(Parser paramParser, String paramString) {
/* 407 */     byte b = 0;
/* 408 */     int i = paramParser.getPosition();
/* 409 */     while (paramParser.peek() == '[') {
/* 410 */       b++;
/* 411 */       paramParser.next();
/*     */     } 
/* 413 */     if (b > 0) {
/*     */       TypeSignature typeSignature;
/* 415 */       if ((typeSignature = TypeSignature.parse(paramParser, paramString)) == null) {
/* 416 */         throw new ParseException(paramParser, "elementTypeSignature == null");
/*     */       }
/* 418 */       String str = paramParser.getSubsequence(i, paramParser.getPosition()).toString();
/* 419 */       return new ArrayTypeSignature(typeSignature, b, str);
/*     */     } 
/* 421 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ArrayTypeSignature.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */