/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.types.ParseException;
/*     */ import nonapi.io.github.classgraph.types.Parser;
/*     */ import nonapi.io.github.classgraph.types.TypeUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ClassRefTypeSignature
/*     */   extends ClassRefOrTypeVariableSignature
/*     */ {
/*     */   final String className;
/*     */   private final List<TypeArgument> typeArguments;
/*     */   private final List<String> suffixes;
/*     */   private final List<List<TypeArgument>> suffixTypeArguments;
/*     */   private List<AnnotationInfoList> suffixTypeAnnotations;
/*     */   
/*     */   private ClassRefTypeSignature(String paramString, List<TypeArgument> paramList, List<String> paramList1, List<List<TypeArgument>> paramList2) {
/*  76 */     this.className = paramString;
/*  77 */     this.typeArguments = paramList;
/*  78 */     this.suffixes = paramList1;
/*  79 */     this.suffixTypeArguments = paramList2;
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
/*     */   public final String getBaseClassName() {
/*  91 */     return this.className;
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
/*     */   public final String getFullyQualifiedClassName() {
/* 108 */     if (this.suffixes.isEmpty()) {
/* 109 */       return this.className;
/*     */     }
/*     */     StringBuilder stringBuilder;
/* 112 */     (stringBuilder = new StringBuilder()).append(this.className);
/* 113 */     for (String str : this.suffixes) {
/* 114 */       stringBuilder.append('$');
/* 115 */       stringBuilder.append(str);
/*     */     } 
/* 117 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<TypeArgument> getTypeArguments() {
/* 127 */     return this.typeArguments;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<String> getSuffixes() {
/* 136 */     return this.suffixes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<List<TypeArgument>> getSuffixTypeArguments() {
/* 146 */     return this.suffixTypeArguments;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<AnnotationInfoList> getSuffixTypeAnnotationInfo() {
/* 156 */     return this.suffixTypeAnnotations;
/*     */   }
/*     */   
/*     */   private void addSuffixTypeAnnotation(int paramInt, AnnotationInfo paramAnnotationInfo) {
/* 160 */     if (this.suffixTypeAnnotations == null) {
/* 161 */       this.suffixTypeAnnotations = new ArrayList<>(this.suffixes.size());
/* 162 */       for (byte b = 0; b < this.suffixes.size(); b++) {
/* 163 */         this.suffixTypeAnnotations.add(new AnnotationInfoList(1));
/*     */       }
/*     */     } 
/* 166 */     ((AnnotationInfoList)this.suffixTypeAnnotations.get(paramInt)).add(paramAnnotationInfo);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void addTypeAnnotation(List<Classfile.TypePathNode> paramList, AnnotationInfo paramAnnotationInfo) {
/*     */     // Byte code:
/*     */     //   0: iconst_0
/*     */     //   1: istore_3
/*     */     //   2: iconst_m1
/*     */     //   3: istore #4
/*     */     //   5: aload_1
/*     */     //   6: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   11: astore #5
/*     */     //   13: aload #5
/*     */     //   15: invokeinterface hasNext : ()Z
/*     */     //   20: ifeq -> 96
/*     */     //   23: aload #5
/*     */     //   25: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   30: checkcast io/github/classgraph/Classfile$TypePathNode
/*     */     //   33: dup
/*     */     //   34: astore #6
/*     */     //   36: getfield typePathKind : S
/*     */     //   39: iconst_1
/*     */     //   40: if_icmpne -> 49
/*     */     //   43: iinc #3, 1
/*     */     //   46: goto -> 13
/*     */     //   49: aload #6
/*     */     //   51: getfield typePathKind : S
/*     */     //   54: iconst_3
/*     */     //   55: if_icmpne -> 68
/*     */     //   58: aload #6
/*     */     //   60: getfield typeArgumentIdx : S
/*     */     //   63: istore #4
/*     */     //   65: goto -> 96
/*     */     //   68: new java/lang/IllegalArgumentException
/*     */     //   71: dup
/*     */     //   72: new java/lang/StringBuilder
/*     */     //   75: dup
/*     */     //   76: ldc 'Bad typePathKind: '
/*     */     //   78: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   81: aload #6
/*     */     //   83: getfield typePathKind : S
/*     */     //   86: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   89: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   92: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   95: athrow
/*     */     //   96: iconst_m1
/*     */     //   97: istore #5
/*     */     //   99: iconst_m1
/*     */     //   100: istore #6
/*     */     //   102: aload_0
/*     */     //   103: getfield className : Ljava/lang/String;
/*     */     //   106: astore #7
/*     */     //   108: iload #5
/*     */     //   110: aload_0
/*     */     //   111: getfield suffixes : Ljava/util/List;
/*     */     //   114: invokeinterface size : ()I
/*     */     //   119: if_icmplt -> 132
/*     */     //   122: new java/lang/IllegalArgumentException
/*     */     //   125: dup
/*     */     //   126: ldc 'Ran out of nested types while trying to add type annotation'
/*     */     //   128: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   131: athrow
/*     */     //   132: iload #5
/*     */     //   134: aload_0
/*     */     //   135: getfield suffixes : Ljava/util/List;
/*     */     //   138: invokeinterface size : ()I
/*     */     //   143: iconst_1
/*     */     //   144: isub
/*     */     //   145: if_icmpeq -> 262
/*     */     //   148: aload_0
/*     */     //   149: getfield scanResult : Lio/github/classgraph/ScanResult;
/*     */     //   152: aload #7
/*     */     //   154: invokevirtual getClassInfo : (Ljava/lang/String;)Lio/github/classgraph/ClassInfo;
/*     */     //   157: astore #9
/*     */     //   159: new java/lang/StringBuilder
/*     */     //   162: dup
/*     */     //   163: invokespecial <init> : ()V
/*     */     //   166: aload #7
/*     */     //   168: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   171: bipush #36
/*     */     //   173: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   176: aload_0
/*     */     //   177: getfield suffixes : Ljava/util/List;
/*     */     //   180: iload #5
/*     */     //   182: iconst_1
/*     */     //   183: iadd
/*     */     //   184: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   189: checkcast java/lang/String
/*     */     //   192: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   195: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   198: astore #7
/*     */     //   200: aload_0
/*     */     //   201: getfield scanResult : Lio/github/classgraph/ScanResult;
/*     */     //   204: aload #7
/*     */     //   206: invokevirtual getClassInfo : (Ljava/lang/String;)Lio/github/classgraph/ClassInfo;
/*     */     //   209: astore #8
/*     */     //   211: aload #9
/*     */     //   213: ifnull -> 258
/*     */     //   216: aload #8
/*     */     //   218: ifnull -> 258
/*     */     //   221: aload #9
/*     */     //   223: invokevirtual isInterfaceOrAnnotation : ()Z
/*     */     //   226: ifne -> 258
/*     */     //   229: aload #8
/*     */     //   231: invokevirtual isInterfaceOrAnnotation : ()Z
/*     */     //   234: ifne -> 258
/*     */     //   237: aload #8
/*     */     //   239: invokevirtual isStatic : ()Z
/*     */     //   242: ifne -> 258
/*     */     //   245: aload #9
/*     */     //   247: invokevirtual getInnerClasses : ()Lio/github/classgraph/ClassInfoList;
/*     */     //   250: aload #8
/*     */     //   252: invokevirtual contains : (Ljava/lang/Object;)Z
/*     */     //   255: ifne -> 262
/*     */     //   258: iconst_1
/*     */     //   259: goto -> 263
/*     */     //   262: iconst_0
/*     */     //   263: dup
/*     */     //   264: istore #8
/*     */     //   266: ifne -> 278
/*     */     //   269: iinc #6, 1
/*     */     //   272: iload #6
/*     */     //   274: iload_3
/*     */     //   275: if_icmpge -> 284
/*     */     //   278: iinc #5, 1
/*     */     //   281: goto -> 108
/*     */     //   284: iload #4
/*     */     //   286: iconst_m1
/*     */     //   287: if_icmpne -> 310
/*     */     //   290: iload #5
/*     */     //   292: iconst_m1
/*     */     //   293: if_icmpne -> 302
/*     */     //   296: aload_0
/*     */     //   297: aload_2
/*     */     //   298: invokevirtual addTypeAnnotation : (Lio/github/classgraph/AnnotationInfo;)V
/*     */     //   301: return
/*     */     //   302: aload_0
/*     */     //   303: iload #5
/*     */     //   305: aload_2
/*     */     //   306: invokespecial addSuffixTypeAnnotation : (ILio/github/classgraph/AnnotationInfo;)V
/*     */     //   309: return
/*     */     //   310: iload #5
/*     */     //   312: iconst_m1
/*     */     //   313: if_icmpne -> 323
/*     */     //   316: aload_0
/*     */     //   317: getfield typeArguments : Ljava/util/List;
/*     */     //   320: goto -> 337
/*     */     //   323: aload_0
/*     */     //   324: getfield suffixTypeArguments : Ljava/util/List;
/*     */     //   327: iload #5
/*     */     //   329: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   334: checkcast java/util/List
/*     */     //   337: astore #8
/*     */     //   339: iload #4
/*     */     //   341: aload #8
/*     */     //   343: invokeinterface size : ()I
/*     */     //   348: if_icmpge -> 386
/*     */     //   351: aload_1
/*     */     //   352: iload_3
/*     */     //   353: iconst_1
/*     */     //   354: iadd
/*     */     //   355: aload_1
/*     */     //   356: invokeinterface size : ()I
/*     */     //   361: invokeinterface subList : (II)Ljava/util/List;
/*     */     //   366: astore #9
/*     */     //   368: aload #8
/*     */     //   370: iload #4
/*     */     //   372: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   377: checkcast io/github/classgraph/TypeArgument
/*     */     //   380: aload #9
/*     */     //   382: aload_2
/*     */     //   383: invokevirtual addTypeAnnotation : (Ljava/util/List;Lio/github/classgraph/AnnotationInfo;)V
/*     */     //   386: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #172	-> 0
/*     */     //   #173	-> 2
/*     */     //   #174	-> 5
/*     */     //   #175	-> 34
/*     */     //   #178	-> 43
/*     */     //   #179	-> 49
/*     */     //   #182	-> 58
/*     */     //   #183	-> 65
/*     */     //   #188	-> 68
/*     */     //   #193	-> 96
/*     */     //   #194	-> 99
/*     */     //   #195	-> 102
/*     */     //   #198	-> 108
/*     */     //   #199	-> 122
/*     */     //   #200	-> 132
/*     */     //   #206	-> 148
/*     */     //   #207	-> 159
/*     */     //   #208	-> 200
/*     */     //   #209	-> 211
/*     */     //   #210	-> 223
/*     */     //   #211	-> 231
/*     */     //   #212	-> 239
/*     */     //   #213	-> 247
/*     */     //   #215	-> 264
/*     */     //   #217	-> 269
/*     */     //   #218	-> 272
/*     */     //   #222	-> 278
/*     */     //   #223	-> 281
/*     */     //   #225	-> 284
/*     */     //   #227	-> 290
/*     */     //   #229	-> 296
/*     */     //   #232	-> 302
/*     */     //   #235	-> 310
/*     */     //   #236	-> 329
/*     */     //   #239	-> 339
/*     */     //   #243	-> 351
/*     */     //   #244	-> 356
/*     */     //   #243	-> 361
/*     */     //   #246	-> 368
/*     */     //   #249	-> 386
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Class<?> loadClass(boolean paramBoolean) {
/* 265 */     return super.loadClass(paramBoolean);
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
/*     */   public final Class<?> loadClass() {
/* 278 */     return super.loadClass();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final String getClassName() {
/* 286 */     return getFullyQualifiedClassName();
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
/*     */   public final ClassInfo getClassInfo() {
/* 299 */     return super.getClassInfo();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void setScanResult(ScanResult paramScanResult) {
/* 307 */     super.setScanResult(paramScanResult); Iterator<TypeArgument> iterator;
/* 308 */     for (iterator = this.typeArguments.iterator(); iterator.hasNext();) {
/* 309 */       (typeArgument = iterator.next()).setScanResult(paramScanResult);
/*     */     }
/* 311 */     for (iterator = (Iterator)this.suffixTypeArguments.iterator(); iterator.hasNext();) {
/* 312 */       for (Iterator<?> iterator1 = (list = (List)iterator.next()).iterator(); iterator1.hasNext();) {
/* 313 */         (typeArgument = (TypeArgument)iterator1.next()).setScanResult(paramScanResult);
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
/*     */   protected final void findReferencedClassNames(Set<String> paramSet) {
/* 326 */     paramSet.add(getFullyQualifiedClassName()); Iterator<TypeArgument> iterator;
/* 327 */     for (iterator = this.typeArguments.iterator(); iterator.hasNext();) {
/* 328 */       (typeArgument = iterator.next()).findReferencedClassNames(paramSet);
/*     */     }
/* 330 */     for (iterator = (Iterator)this.suffixTypeArguments.iterator(); iterator.hasNext();) {
/* 331 */       for (Iterator<?> iterator1 = (list = (List)iterator.next()).iterator(); iterator1.hasNext();) {
/* 332 */         (typeArgument = (TypeArgument)iterator1.next()).findReferencedClassNames(paramSet);
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
/*     */   public final int hashCode() {
/* 344 */     return this.className.hashCode() + 7 * this.typeArguments.hashCode() + 15 * this.suffixTypeArguments.hashCode() + 31 * ((this.typeAnnotationInfo == null) ? 0 : this.typeAnnotationInfo
/* 345 */       .hashCode()) + 64 * ((this.suffixTypeAnnotations == null) ? 0 : this.suffixTypeAnnotations
/* 346 */       .hashCode());
/*     */   }
/*     */   
/*     */   private static boolean suffixesMatch(ClassRefTypeSignature paramClassRefTypeSignature1, ClassRefTypeSignature paramClassRefTypeSignature2) {
/* 350 */     if (paramClassRefTypeSignature1.suffixes.equals(paramClassRefTypeSignature2.suffixes) && paramClassRefTypeSignature1.suffixTypeArguments
/* 351 */       .equals(paramClassRefTypeSignature2.suffixTypeArguments) && 
/* 352 */       Objects.equals(paramClassRefTypeSignature1.suffixTypeAnnotations, paramClassRefTypeSignature2.suffixTypeAnnotations)) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 360 */     if (paramObject == this)
/* 361 */       return true; 
/* 362 */     if (!(paramObject instanceof ClassRefTypeSignature)) {
/* 363 */       return false;
/*     */     }
/*     */     
/* 366 */     if (((ClassRefTypeSignature)(paramObject = paramObject)).className.equals(this.className) && ((ClassRefTypeSignature)paramObject).typeArguments.equals(this.typeArguments) && 
/* 367 */       Objects.equals(this.typeAnnotationInfo, ((ClassRefTypeSignature)paramObject).typeAnnotationInfo) && suffixesMatch((ClassRefTypeSignature)paramObject, this)) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equalsIgnoringTypeParams(TypeSignature paramTypeSignature) {
/* 375 */     if (paramTypeSignature instanceof TypeVariableSignature)
/*     */     {
/*     */       
/* 378 */       return paramTypeSignature.equalsIgnoringTypeParams(this);
/*     */     }
/* 380 */     if (!(paramTypeSignature instanceof ClassRefTypeSignature)) {
/* 381 */       return false;
/*     */     }
/*     */     
/* 384 */     if (((ClassRefTypeSignature)(paramTypeSignature = paramTypeSignature)).className.equals(this.className) && Objects.equals(this.typeAnnotationInfo, ((ClassRefTypeSignature)paramTypeSignature).typeAnnotationInfo) && 
/* 385 */       suffixesMatch((ClassRefTypeSignature)paramTypeSignature, this)) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void toStringInternal(boolean paramBoolean, AnnotationInfoList paramAnnotationInfoList, StringBuilder paramStringBuilder) {
/* 394 */     if (!paramBoolean || this.suffixes.isEmpty()) {
/*     */       
/* 396 */       if (this.typeAnnotationInfo != null) {
/* 397 */         for (AnnotationInfo annotationInfo : this.typeAnnotationInfo) {
/* 398 */           if (paramAnnotationInfoList == null || !paramAnnotationInfoList.contains(annotationInfo)) {
/* 399 */             annotationInfo.toString(paramBoolean, paramStringBuilder);
/* 400 */             paramStringBuilder.append(' ');
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 405 */       paramStringBuilder.append(paramBoolean ? ClassInfo.getSimpleName(this.className) : this.className);
/*     */       
/* 407 */       if (!this.typeArguments.isEmpty()) {
/* 408 */         paramStringBuilder.append('<');
/* 409 */         for (byte b = 0; b < this.typeArguments.size(); b++) {
/* 410 */           if (b > 0) {
/* 411 */             paramStringBuilder.append(", ");
/*     */           }
/* 413 */           ((TypeArgument)this.typeArguments.get(b)).toString(paramBoolean, paramStringBuilder);
/*     */         } 
/* 415 */         paramStringBuilder.append('>');
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 420 */     if (!this.suffixes.isEmpty()) {
/* 421 */       for (byte b = paramBoolean ? (this.suffixes.size() - 1) : 0; b < this.suffixes.size(); b++) {
/* 422 */         if (!paramBoolean)
/*     */         {
/* 424 */           paramStringBuilder.append('$');
/*     */         }
/*     */         
/*     */         AnnotationInfoList annotationInfoList;
/*     */         
/* 429 */         if ((annotationInfoList = (AnnotationInfoList)((this.suffixTypeAnnotations == null) ? null : this.suffixTypeAnnotations.get(b))) != null && !annotationInfoList.isEmpty()) {
/* 430 */           for (Iterator<AnnotationInfo> iterator = annotationInfoList.iterator(); iterator.hasNext(); ) {
/* 431 */             AnnotationInfo annotationInfo; (annotationInfo = iterator.next()).toString(paramBoolean, paramStringBuilder);
/* 432 */             paramStringBuilder.append(' ');
/*     */           } 
/*     */         }
/*     */         
/* 436 */         paramStringBuilder.append(this.suffixes.get(b));
/*     */         
/*     */         List<?> list;
/* 439 */         if (!(list = this.suffixTypeArguments.get(b)).isEmpty()) {
/* 440 */           paramStringBuilder.append('<');
/* 441 */           for (byte b1 = 0; b1 < list.size(); b1++) {
/* 442 */             if (b1 > 0) {
/* 443 */               paramStringBuilder.append(", ");
/*     */             }
/* 445 */             ((TypeArgument)list.get(b1)).toString(paramBoolean, paramStringBuilder);
/*     */           } 
/* 447 */           paramStringBuilder.append('>');
/*     */         } 
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
/*     */ 
/*     */ 
/*     */   
/*     */   static ClassRefTypeSignature parse(Parser paramParser, String paramString) {
/* 467 */     if (paramParser.peek() == 'L') {
/* 468 */       paramParser.next();
/* 469 */       int i = paramParser.getPosition();
/* 470 */       if (!TypeUtils.getIdentifierToken(paramParser, true)) {
/* 471 */         throw new ParseException(paramParser, "Could not parse identifier token");
/*     */       }
/* 473 */       String str = paramParser.currToken();
/* 474 */       List<TypeArgument> list = TypeArgument.parseList(paramParser, paramString);
/*     */ 
/*     */       
/* 477 */       boolean bool = false;
/* 478 */       if (paramParser.peek() == '.' || paramParser.peek() == '$')
/* 479 */       { ArrayList<String> arrayList = new ArrayList();
/* 480 */         ArrayList<List<TypeArgument>> arrayList1 = new ArrayList();
/* 481 */         while (paramParser.peek() == '.' || paramParser.peek() == '$') {
/* 482 */           paramParser.advance(1);
/* 483 */           if (!TypeUtils.getIdentifierToken(paramParser, true)) {
/*     */             
/* 485 */             arrayList.add("");
/* 486 */             arrayList1.add(Collections.emptyList());
/* 487 */             bool = true; continue;
/*     */           } 
/* 489 */           arrayList.add(paramParser.currToken());
/* 490 */           arrayList1.add(TypeArgument.parseList(paramParser, paramString));
/*     */         } 
/*     */         
/* 493 */         if (bool)
/*     */         
/*     */         { 
/* 496 */           str = paramParser.getSubstring(i, paramParser.getPosition()).replace('/', '.');
/*     */           
/*     */            }
/*     */         
/*     */         else
/*     */         
/*     */         { 
/*     */           
/* 504 */           paramParser.expect(';');
/* 505 */           return new ClassRefTypeSignature(str, list, arrayList, arrayList1); }  }  List<?> list1 = Collections.emptyList(); List<?> list2 = Collections.emptyList(); paramParser.expect(';'); return new ClassRefTypeSignature(str, list, (List)list1, (List)list2);
/*     */     } 
/* 507 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ClassRefTypeSignature.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */