/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AnnotationInfo
/*     */   extends ScanResultObject
/*     */   implements HasName, Comparable<AnnotationInfo>
/*     */ {
/*     */   private String name;
/*     */   private AnnotationParameterValueList annotationParamValues;
/*     */   private transient boolean annotationParamValuesHasBeenConvertedToPrimitive;
/*     */   private transient AnnotationParameterValueList annotationParamValuesWithDefaults;
/*     */   
/*     */   AnnotationInfo() {}
/*     */   
/*     */   AnnotationInfo(String paramString, AnnotationParameterValueList paramAnnotationParameterValueList) {
/*  80 */     this.name = paramString;
/*  81 */     this.annotationParamValues = paramAnnotationParameterValueList;
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
/*     */   public String getName() {
/*  93 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInherited() {
/* 102 */     return (getClassInfo()).isInherited;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationParameterValueList getDefaultParameterValues() {
/* 111 */     return getClassInfo().getAnnotationDefaultParameterValues();
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
/*     */   public AnnotationParameterValueList getParameterValues(boolean paramBoolean) {
/*     */     ClassInfo classInfo;
/* 124 */     if ((classInfo = getClassInfo()) == null)
/*     */     {
/*     */       
/* 127 */       return (this.annotationParamValues == null) ? AnnotationParameterValueList.EMPTY_LIST : this.annotationParamValues;
/*     */     }
/*     */     
/* 130 */     if (this.annotationParamValues != null && !this.annotationParamValuesHasBeenConvertedToPrimitive) {
/* 131 */       this.annotationParamValues.convertWrapperArraysToPrimitiveArrays(classInfo);
/* 132 */       this.annotationParamValuesHasBeenConvertedToPrimitive = true;
/*     */     } 
/* 134 */     if (!paramBoolean)
/*     */     {
/* 136 */       return (this.annotationParamValues == null) ? AnnotationParameterValueList.EMPTY_LIST : this.annotationParamValues;
/*     */     }
/* 138 */     if (this.annotationParamValuesWithDefaults == null) {
/* 139 */       if (classInfo.annotationDefaultParamValues != null && !classInfo.annotationDefaultParamValuesHasBeenConvertedToPrimitive) {
/*     */         
/* 141 */         classInfo.annotationDefaultParamValues.convertWrapperArraysToPrimitiveArrays(classInfo);
/* 142 */         classInfo.annotationDefaultParamValuesHasBeenConvertedToPrimitive = true;
/*     */       } 
/*     */       
/*     */       AnnotationParameterValueList annotationParameterValueList;
/*     */       
/* 147 */       if ((annotationParameterValueList = classInfo.annotationDefaultParamValues) == null && this.annotationParamValues == null)
/* 148 */         return AnnotationParameterValueList.EMPTY_LIST; 
/* 149 */       if (annotationParameterValueList == null)
/* 150 */         return this.annotationParamValues; 
/* 151 */       if (this.annotationParamValues == null) {
/* 152 */         return annotationParameterValueList;
/*     */       }
/*     */ 
/*     */       
/* 156 */       HashMap<Object, Object> hashMap = new HashMap<>();
/* 157 */       for (AnnotationParameterValue annotationParameterValue : annotationParameterValueList) {
/* 158 */         hashMap.put(annotationParameterValue.getName(), annotationParameterValue.getValue());
/*     */       }
/* 160 */       for (AnnotationParameterValue annotationParameterValue : this.annotationParamValues) {
/* 161 */         hashMap.put(annotationParameterValue.getName(), annotationParameterValue.getValue());
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 166 */       if (classInfo.methodInfo == null)
/*     */       {
/*     */         
/* 169 */         throw new IllegalArgumentException("Could not find methods for annotation " + classInfo.getName());
/*     */       }
/* 171 */       this.annotationParamValuesWithDefaults = new AnnotationParameterValueList();
/* 172 */       for (Iterator<MethodInfo> iterator = classInfo.methodInfo.iterator(); iterator.hasNext(); ) {
/*     */         String str; MethodInfo methodInfo;
/* 174 */         switch (str = (methodInfo = iterator.next()).getName()) {
/*     */           case "<init>":
/*     */           case "<clinit>":
/*     */           case "hashCode":
/*     */           case "equals":
/*     */           case "toString":
/*     */           case "annotationType":
/*     */             continue;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 190 */         if ((methodInfo = (MethodInfo)hashMap.get(str)) != null) {
/* 191 */           this.annotationParamValuesWithDefaults.add(new AnnotationParameterValue(str, methodInfo));
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 197 */     return this.annotationParamValuesWithDefaults;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationParameterValueList getParameterValues() {
/* 207 */     return getParameterValues(true);
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
/*     */   protected String getClassName() {
/* 219 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setScanResult(ScanResult paramScanResult) {
/* 227 */     super.setScanResult(paramScanResult);
/* 228 */     if (this.annotationParamValues != null) {
/* 229 */       for (Iterator<AnnotationParameterValue> iterator = this.annotationParamValues.iterator(); iterator.hasNext();) {
/* 230 */         (annotationParameterValue = iterator.next()).setScanResult(paramScanResult);
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
/* 246 */     super.findReferencedClassInfo(paramMap, paramSet, paramLogNode);
/* 247 */     if (this.annotationParamValues != null) {
/* 248 */       for (Iterator<AnnotationParameterValue> iterator = this.annotationParamValues.iterator(); iterator.hasNext();) {
/* 249 */         (annotationParameterValue = iterator.next()).findReferencedClassInfo(paramMap, paramSet, paramLogNode);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassInfo getClassInfo() {
/* 259 */     return super.getClassInfo();
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
/*     */   public Annotation loadClassAndInstantiate() {
/*     */     Class<Annotation> clazz;
/* 290 */     return (Annotation)Proxy.newProxyInstance((clazz = getClassInfo().loadClass(Annotation.class)).getClassLoader(), new Class[] { clazz }, new AnnotationInvocationHandler(clazz, this));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class AnnotationInvocationHandler
/*     */     implements InvocationHandler
/*     */   {
/*     */     private final Class<? extends Annotation> annotationClass;
/*     */ 
/*     */     
/*     */     private final AnnotationInfo annotationInfo;
/*     */ 
/*     */     
/* 304 */     private final Map<String, Object> annotationParameterValuesInstantiated = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     AnnotationInvocationHandler(Class<? extends Annotation> param1Class, AnnotationInfo param1AnnotationInfo) {
/* 316 */       this.annotationClass = param1Class;
/* 317 */       this.annotationInfo = param1AnnotationInfo;
/*     */ 
/*     */ 
/*     */       
/* 321 */       for (Iterator<AnnotationParameterValue> iterator = param1AnnotationInfo.getParameterValues().iterator(); iterator.hasNext(); ) {
/*     */         AnnotationParameterValue annotationParameterValue; Object object;
/* 323 */         if ((object = (annotationParameterValue = iterator.next()).instantiate(param1AnnotationInfo.getClassInfo())) == null)
/*     */         {
/* 325 */           throw new IllegalArgumentException("Got null value for annotation parameter " + annotationParameterValue.getName() + " of annotation " + param1AnnotationInfo
/* 326 */               .name);
/*     */         }
/* 328 */         this.annotationParameterValuesInstantiated.put(annotationParameterValue.getName(), object);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) {
/*     */       // Byte code:
/*     */       //   0: aload_2
/*     */       //   1: invokevirtual getName : ()Ljava/lang/String;
/*     */       //   4: astore_1
/*     */       //   5: aload_2
/*     */       //   6: invokevirtual getParameterTypes : ()[Ljava/lang/Class;
/*     */       //   9: astore_2
/*     */       //   10: aload_3
/*     */       //   11: ifnonnull -> 18
/*     */       //   14: iconst_0
/*     */       //   15: goto -> 20
/*     */       //   18: aload_3
/*     */       //   19: arraylength
/*     */       //   20: aload_2
/*     */       //   21: arraylength
/*     */       //   22: if_icmpeq -> 92
/*     */       //   25: new java/lang/IllegalArgumentException
/*     */       //   28: dup
/*     */       //   29: new java/lang/StringBuilder
/*     */       //   32: dup
/*     */       //   33: ldc 'Wrong number of arguments for '
/*     */       //   35: invokespecial <init> : (Ljava/lang/String;)V
/*     */       //   38: aload_0
/*     */       //   39: getfield annotationClass : Ljava/lang/Class;
/*     */       //   42: invokevirtual getName : ()Ljava/lang/String;
/*     */       //   45: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   48: ldc '.'
/*     */       //   50: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   53: aload_1
/*     */       //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   57: ldc ': got '
/*     */       //   59: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   62: aload_3
/*     */       //   63: ifnonnull -> 70
/*     */       //   66: iconst_0
/*     */       //   67: goto -> 72
/*     */       //   70: aload_3
/*     */       //   71: arraylength
/*     */       //   72: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */       //   75: ldc ', expected '
/*     */       //   77: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   80: aload_2
/*     */       //   81: arraylength
/*     */       //   82: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */       //   85: invokevirtual toString : ()Ljava/lang/String;
/*     */       //   88: invokespecial <init> : (Ljava/lang/String;)V
/*     */       //   91: athrow
/*     */       //   92: aload_3
/*     */       //   93: ifnull -> 321
/*     */       //   96: aload_2
/*     */       //   97: arraylength
/*     */       //   98: iconst_1
/*     */       //   99: if_icmpne -> 321
/*     */       //   102: ldc 'equals'
/*     */       //   104: aload_1
/*     */       //   105: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */       //   108: ifeq -> 313
/*     */       //   111: aload_2
/*     */       //   112: iconst_0
/*     */       //   113: aaload
/*     */       //   114: ldc java/lang/Object
/*     */       //   116: if_acmpne -> 313
/*     */       //   119: aload_0
/*     */       //   120: aload_3
/*     */       //   121: iconst_0
/*     */       //   122: aaload
/*     */       //   123: if_acmpne -> 130
/*     */       //   126: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
/*     */       //   129: areturn
/*     */       //   130: aload_0
/*     */       //   131: getfield annotationClass : Ljava/lang/Class;
/*     */       //   134: aload_3
/*     */       //   135: iconst_0
/*     */       //   136: aaload
/*     */       //   137: invokevirtual isInstance : (Ljava/lang/Object;)Z
/*     */       //   140: ifne -> 147
/*     */       //   143: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
/*     */       //   146: areturn
/*     */       //   147: aload_0
/*     */       //   148: getfield annotationInfo : Lio/github/classgraph/AnnotationInfo;
/*     */       //   151: getfield scanResult : Lio/github/classgraph/ScanResult;
/*     */       //   154: ifnonnull -> 167
/*     */       //   157: new nonapi/io/github/classgraph/reflection/ReflectionUtils
/*     */       //   160: dup
/*     */       //   161: invokespecial <init> : ()V
/*     */       //   164: goto -> 177
/*     */       //   167: aload_0
/*     */       //   168: getfield annotationInfo : Lio/github/classgraph/AnnotationInfo;
/*     */       //   171: getfield scanResult : Lio/github/classgraph/ScanResult;
/*     */       //   174: getfield reflectionUtils : Lnonapi/io/github/classgraph/reflection/ReflectionUtils;
/*     */       //   177: astore_2
/*     */       //   178: aload_0
/*     */       //   179: getfield annotationParameterValuesInstantiated : Ljava/util/Map;
/*     */       //   182: invokeinterface entrySet : ()Ljava/util/Set;
/*     */       //   187: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */       //   192: astore #4
/*     */       //   194: aload #4
/*     */       //   196: invokeinterface hasNext : ()Z
/*     */       //   201: ifeq -> 309
/*     */       //   204: aload #4
/*     */       //   206: invokeinterface next : ()Ljava/lang/Object;
/*     */       //   211: checkcast java/util/Map$Entry
/*     */       //   214: dup
/*     */       //   215: astore_1
/*     */       //   216: invokeinterface getKey : ()Ljava/lang/Object;
/*     */       //   221: checkcast java/lang/String
/*     */       //   224: astore #5
/*     */       //   226: aload_1
/*     */       //   227: invokeinterface getValue : ()Ljava/lang/Object;
/*     */       //   232: astore #6
/*     */       //   234: aload_2
/*     */       //   235: iconst_0
/*     */       //   236: aload_3
/*     */       //   237: iconst_0
/*     */       //   238: aaload
/*     */       //   239: aload #5
/*     */       //   241: invokevirtual invokeMethod : (ZLjava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
/*     */       //   244: astore #7
/*     */       //   246: aload #6
/*     */       //   248: ifnonnull -> 255
/*     */       //   251: iconst_1
/*     */       //   252: goto -> 256
/*     */       //   255: iconst_0
/*     */       //   256: aload #7
/*     */       //   258: ifnonnull -> 265
/*     */       //   261: iconst_1
/*     */       //   262: goto -> 266
/*     */       //   265: iconst_0
/*     */       //   266: if_icmpeq -> 273
/*     */       //   269: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
/*     */       //   272: areturn
/*     */       //   273: aload #6
/*     */       //   275: ifnonnull -> 287
/*     */       //   278: aload #7
/*     */       //   280: ifnonnull -> 287
/*     */       //   283: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
/*     */       //   286: areturn
/*     */       //   287: aload #6
/*     */       //   289: ifnull -> 302
/*     */       //   292: aload #6
/*     */       //   294: aload #7
/*     */       //   296: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */       //   299: ifne -> 306
/*     */       //   302: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
/*     */       //   305: areturn
/*     */       //   306: goto -> 194
/*     */       //   309: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
/*     */       //   312: areturn
/*     */       //   313: new java/lang/IllegalArgumentException
/*     */       //   316: dup
/*     */       //   317: invokespecial <init> : ()V
/*     */       //   320: athrow
/*     */       //   321: aload_2
/*     */       //   322: arraylength
/*     */       //   323: ifne -> 709
/*     */       //   326: aload_1
/*     */       //   327: astore_2
/*     */       //   328: iconst_m1
/*     */       //   329: istore #4
/*     */       //   331: aload_2
/*     */       //   332: invokevirtual hashCode : ()I
/*     */       //   335: lookupswitch default -> 410, -1776922004 -> 368, 147696667 -> 383, 1444986633 -> 398
/*     */       //   368: aload_2
/*     */       //   369: ldc 'toString'
/*     */       //   371: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */       //   374: ifeq -> 410
/*     */       //   377: iconst_0
/*     */       //   378: istore #4
/*     */       //   380: goto -> 410
/*     */       //   383: aload_2
/*     */       //   384: ldc 'hashCode'
/*     */       //   386: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */       //   389: ifeq -> 410
/*     */       //   392: iconst_1
/*     */       //   393: istore #4
/*     */       //   395: goto -> 410
/*     */       //   398: aload_2
/*     */       //   399: ldc 'annotationType'
/*     */       //   401: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */       //   404: ifeq -> 410
/*     */       //   407: iconst_2
/*     */       //   408: istore #4
/*     */       //   410: iload #4
/*     */       //   412: tableswitch default -> 706, 0 -> 440, 1 -> 448, 2 -> 701
/*     */       //   440: aload_0
/*     */       //   441: getfield annotationInfo : Lio/github/classgraph/AnnotationInfo;
/*     */       //   444: invokevirtual toString : ()Ljava/lang/String;
/*     */       //   447: areturn
/*     */       //   448: iconst_0
/*     */       //   449: istore_1
/*     */       //   450: aload_0
/*     */       //   451: getfield annotationParameterValuesInstantiated : Ljava/util/Map;
/*     */       //   454: invokeinterface entrySet : ()Ljava/util/Set;
/*     */       //   459: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */       //   464: astore #5
/*     */       //   466: aload #5
/*     */       //   468: invokeinterface hasNext : ()Z
/*     */       //   473: ifeq -> 696
/*     */       //   476: aload #5
/*     */       //   478: invokeinterface next : ()Ljava/lang/Object;
/*     */       //   483: checkcast java/util/Map$Entry
/*     */       //   486: dup
/*     */       //   487: astore #6
/*     */       //   489: invokeinterface getKey : ()Ljava/lang/Object;
/*     */       //   494: checkcast java/lang/String
/*     */       //   497: astore #7
/*     */       //   499: aload #6
/*     */       //   501: invokeinterface getValue : ()Ljava/lang/Object;
/*     */       //   506: dup
/*     */       //   507: astore_2
/*     */       //   508: ifnonnull -> 516
/*     */       //   511: iconst_0
/*     */       //   512: istore_2
/*     */       //   513: goto -> 680
/*     */       //   516: aload_2
/*     */       //   517: invokevirtual getClass : ()Ljava/lang/Class;
/*     */       //   520: dup
/*     */       //   521: astore_3
/*     */       //   522: invokevirtual isArray : ()Z
/*     */       //   525: ifne -> 536
/*     */       //   528: aload_2
/*     */       //   529: invokevirtual hashCode : ()I
/*     */       //   532: istore_2
/*     */       //   533: goto -> 680
/*     */       //   536: aload_3
/*     */       //   537: ldc [B
/*     */       //   539: if_acmpne -> 553
/*     */       //   542: aload_2
/*     */       //   543: checkcast [B
/*     */       //   546: invokestatic hashCode : ([B)I
/*     */       //   549: istore_2
/*     */       //   550: goto -> 680
/*     */       //   553: aload_3
/*     */       //   554: ldc [C
/*     */       //   556: if_acmpne -> 570
/*     */       //   559: aload_2
/*     */       //   560: checkcast [C
/*     */       //   563: invokestatic hashCode : ([C)I
/*     */       //   566: istore_2
/*     */       //   567: goto -> 680
/*     */       //   570: aload_3
/*     */       //   571: ldc [D
/*     */       //   573: if_acmpne -> 587
/*     */       //   576: aload_2
/*     */       //   577: checkcast [D
/*     */       //   580: invokestatic hashCode : ([D)I
/*     */       //   583: istore_2
/*     */       //   584: goto -> 680
/*     */       //   587: aload_3
/*     */       //   588: ldc [F
/*     */       //   590: if_acmpne -> 604
/*     */       //   593: aload_2
/*     */       //   594: checkcast [F
/*     */       //   597: invokestatic hashCode : ([F)I
/*     */       //   600: istore_2
/*     */       //   601: goto -> 680
/*     */       //   604: aload_3
/*     */       //   605: ldc [I
/*     */       //   607: if_acmpne -> 621
/*     */       //   610: aload_2
/*     */       //   611: checkcast [I
/*     */       //   614: invokestatic hashCode : ([I)I
/*     */       //   617: istore_2
/*     */       //   618: goto -> 680
/*     */       //   621: aload_3
/*     */       //   622: ldc [J
/*     */       //   624: if_acmpne -> 638
/*     */       //   627: aload_2
/*     */       //   628: checkcast [J
/*     */       //   631: invokestatic hashCode : ([J)I
/*     */       //   634: istore_2
/*     */       //   635: goto -> 680
/*     */       //   638: aload_3
/*     */       //   639: ldc [S
/*     */       //   641: if_acmpne -> 655
/*     */       //   644: aload_2
/*     */       //   645: checkcast [S
/*     */       //   648: invokestatic hashCode : ([S)I
/*     */       //   651: istore_2
/*     */       //   652: goto -> 680
/*     */       //   655: aload_3
/*     */       //   656: ldc [Z
/*     */       //   658: if_acmpne -> 672
/*     */       //   661: aload_2
/*     */       //   662: checkcast [Z
/*     */       //   665: invokestatic hashCode : ([Z)I
/*     */       //   668: istore_2
/*     */       //   669: goto -> 680
/*     */       //   672: aload_2
/*     */       //   673: checkcast [Ljava/lang/Object;
/*     */       //   676: invokestatic hashCode : ([Ljava/lang/Object;)I
/*     */       //   679: istore_2
/*     */       //   680: iload_1
/*     */       //   681: bipush #127
/*     */       //   683: aload #7
/*     */       //   685: invokevirtual hashCode : ()I
/*     */       //   688: imul
/*     */       //   689: iload_2
/*     */       //   690: ixor
/*     */       //   691: iadd
/*     */       //   692: istore_1
/*     */       //   693: goto -> 466
/*     */       //   696: iload_1
/*     */       //   697: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */       //   700: areturn
/*     */       //   701: aload_0
/*     */       //   702: getfield annotationClass : Ljava/lang/Class;
/*     */       //   705: areturn
/*     */       //   706: goto -> 717
/*     */       //   709: new java/lang/IllegalArgumentException
/*     */       //   712: dup
/*     */       //   713: invokespecial <init> : ()V
/*     */       //   716: athrow
/*     */       //   717: aload_0
/*     */       //   718: getfield annotationParameterValuesInstantiated : Ljava/util/Map;
/*     */       //   721: aload_1
/*     */       //   722: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */       //   727: dup
/*     */       //   728: astore_2
/*     */       //   729: ifnonnull -> 745
/*     */       //   732: new java/lang/annotation/IncompleteAnnotationException
/*     */       //   735: dup
/*     */       //   736: aload_0
/*     */       //   737: getfield annotationClass : Ljava/lang/Class;
/*     */       //   740: aload_1
/*     */       //   741: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;)V
/*     */       //   744: athrow
/*     */       //   745: aload_2
/*     */       //   746: invokevirtual getClass : ()Ljava/lang/Class;
/*     */       //   749: dup
/*     */       //   750: astore #4
/*     */       //   752: invokevirtual isArray : ()Z
/*     */       //   755: ifeq -> 903
/*     */       //   758: aload #4
/*     */       //   760: ldc [Ljava/lang/String;
/*     */       //   762: if_acmpne -> 773
/*     */       //   765: aload_2
/*     */       //   766: checkcast [Ljava/lang/String;
/*     */       //   769: invokevirtual clone : ()Ljava/lang/Object;
/*     */       //   772: areturn
/*     */       //   773: aload #4
/*     */       //   775: ldc [B
/*     */       //   777: if_acmpne -> 788
/*     */       //   780: aload_2
/*     */       //   781: checkcast [B
/*     */       //   784: invokevirtual clone : ()Ljava/lang/Object;
/*     */       //   787: areturn
/*     */       //   788: aload #4
/*     */       //   790: ldc [C
/*     */       //   792: if_acmpne -> 803
/*     */       //   795: aload_2
/*     */       //   796: checkcast [C
/*     */       //   799: invokevirtual clone : ()Ljava/lang/Object;
/*     */       //   802: areturn
/*     */       //   803: aload #4
/*     */       //   805: ldc [D
/*     */       //   807: if_acmpne -> 818
/*     */       //   810: aload_2
/*     */       //   811: checkcast [D
/*     */       //   814: invokevirtual clone : ()Ljava/lang/Object;
/*     */       //   817: areturn
/*     */       //   818: aload #4
/*     */       //   820: ldc [F
/*     */       //   822: if_acmpne -> 833
/*     */       //   825: aload_2
/*     */       //   826: checkcast [F
/*     */       //   829: invokevirtual clone : ()Ljava/lang/Object;
/*     */       //   832: areturn
/*     */       //   833: aload #4
/*     */       //   835: ldc [I
/*     */       //   837: if_acmpne -> 848
/*     */       //   840: aload_2
/*     */       //   841: checkcast [I
/*     */       //   844: invokevirtual clone : ()Ljava/lang/Object;
/*     */       //   847: areturn
/*     */       //   848: aload #4
/*     */       //   850: ldc [J
/*     */       //   852: if_acmpne -> 863
/*     */       //   855: aload_2
/*     */       //   856: checkcast [J
/*     */       //   859: invokevirtual clone : ()Ljava/lang/Object;
/*     */       //   862: areturn
/*     */       //   863: aload #4
/*     */       //   865: ldc [S
/*     */       //   867: if_acmpne -> 878
/*     */       //   870: aload_2
/*     */       //   871: checkcast [S
/*     */       //   874: invokevirtual clone : ()Ljava/lang/Object;
/*     */       //   877: areturn
/*     */       //   878: aload #4
/*     */       //   880: ldc [Z
/*     */       //   882: if_acmpne -> 893
/*     */       //   885: aload_2
/*     */       //   886: checkcast [Z
/*     */       //   889: invokevirtual clone : ()Ljava/lang/Object;
/*     */       //   892: areturn
/*     */       //   893: aload_2
/*     */       //   894: checkcast [Ljava/lang/Object;
/*     */       //   897: dup
/*     */       //   898: astore_1
/*     */       //   899: invokevirtual clone : ()Ljava/lang/Object;
/*     */       //   902: areturn
/*     */       //   903: aload_2
/*     */       //   904: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #338	-> 0
/*     */       //   #339	-> 5
/*     */       //   #340	-> 10
/*     */       //   #341	-> 25
/*     */       //   #342	-> 42
/*     */       //   #345	-> 92
/*     */       //   #346	-> 102
/*     */       //   #349	-> 119
/*     */       //   #350	-> 126
/*     */       //   #351	-> 130
/*     */       //   #352	-> 143
/*     */       //   #354	-> 147
/*     */       //   #357	-> 178
/*     */       //   #358	-> 215
/*     */       //   #359	-> 226
/*     */       //   #360	-> 234
/*     */       //   #362	-> 246
/*     */       //   #364	-> 269
/*     */       //   #365	-> 273
/*     */       //   #366	-> 283
/*     */       //   #367	-> 287
/*     */       //   #368	-> 302
/*     */       //   #370	-> 306
/*     */       //   #371	-> 309
/*     */       //   #374	-> 313
/*     */       //   #376	-> 321
/*     */       //   #378	-> 326
/*     */       //   #380	-> 440
/*     */       //   #384	-> 448
/*     */       //   #385	-> 450
/*     */       //   #386	-> 487
/*     */       //   #387	-> 499
/*     */       //   #389	-> 507
/*     */       //   #391	-> 511
/*     */       //   #393	-> 516
/*     */       //   #394	-> 521
/*     */       //   #395	-> 528
/*     */       //   #396	-> 536
/*     */       //   #397	-> 542
/*     */       //   #398	-> 553
/*     */       //   #399	-> 559
/*     */       //   #400	-> 570
/*     */       //   #401	-> 576
/*     */       //   #402	-> 587
/*     */       //   #403	-> 593
/*     */       //   #404	-> 604
/*     */       //   #405	-> 610
/*     */       //   #406	-> 621
/*     */       //   #407	-> 627
/*     */       //   #408	-> 638
/*     */       //   #409	-> 644
/*     */       //   #410	-> 655
/*     */       //   #411	-> 661
/*     */       //   #413	-> 672
/*     */       //   #416	-> 680
/*     */       //   #417	-> 693
/*     */       //   #418	-> 696
/*     */       //   #421	-> 701
/*     */       //   #424	-> 706
/*     */       //   #428	-> 709
/*     */       //   #433	-> 717
/*     */       //   #434	-> 728
/*     */       //   #436	-> 732
/*     */       //   #440	-> 745
/*     */       //   #441	-> 750
/*     */       //   #443	-> 758
/*     */       //   #444	-> 765
/*     */       //   #445	-> 773
/*     */       //   #446	-> 780
/*     */       //   #447	-> 788
/*     */       //   #448	-> 795
/*     */       //   #449	-> 803
/*     */       //   #450	-> 810
/*     */       //   #451	-> 818
/*     */       //   #452	-> 825
/*     */       //   #453	-> 833
/*     */       //   #454	-> 840
/*     */       //   #455	-> 848
/*     */       //   #456	-> 855
/*     */       //   #457	-> 863
/*     */       //   #458	-> 870
/*     */       //   #459	-> 878
/*     */       //   #460	-> 885
/*     */       //   #463	-> 893
/*     */       //   #464	-> 898
/*     */       //   #467	-> 903
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void convertWrapperArraysToPrimitiveArrays() {
/* 475 */     if (this.annotationParamValues != null) {
/* 476 */       this.annotationParamValues.convertWrapperArraysToPrimitiveArrays(getClassInfo());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(AnnotationInfo paramAnnotationInfo) {
/*     */     int i;
/* 488 */     if ((i = this.name.compareTo(paramAnnotationInfo.name)) != 0) {
/* 489 */       return i;
/*     */     }
/* 491 */     if (this.annotationParamValues == null && paramAnnotationInfo.annotationParamValues == null)
/* 492 */       return 0; 
/* 493 */     if (this.annotationParamValues == null)
/* 494 */       return -1; 
/* 495 */     if (paramAnnotationInfo.annotationParamValues == null) {
/* 496 */       return 1;
/*     */     }
/* 498 */     i = 0;
/* 499 */     for (int j = Math.max(this.annotationParamValues.size(), paramAnnotationInfo.annotationParamValues.size()); i < j; i++) {
/* 500 */       if (i >= this.annotationParamValues.size())
/* 501 */         return -1; 
/* 502 */       if (i >= paramAnnotationInfo.annotationParamValues.size()) {
/* 503 */         return 1;
/*     */       }
/*     */       int k;
/* 506 */       if ((k = this.annotationParamValues.get(i).compareTo(paramAnnotationInfo.annotationParamValues.get(i))) != 0) {
/* 507 */         return k;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 512 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 520 */     if (paramObject == this)
/* 521 */       return true; 
/* 522 */     if (!(paramObject instanceof AnnotationInfo)) {
/* 523 */       return false;
/*     */     }
/* 525 */     paramObject = paramObject;
/* 526 */     return (compareTo((AnnotationInfo)paramObject) == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 534 */     int i = this.name.hashCode();
/* 535 */     if (this.annotationParamValues != null) {
/* 536 */       for (AnnotationParameterValue annotationParameterValue : this.annotationParamValues) {
/* 537 */         i = i * 7 + annotationParameterValue.getName().hashCode() * 3 + annotationParameterValue.getValue().hashCode();
/*     */       }
/*     */     }
/* 540 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void toString(boolean paramBoolean, StringBuilder paramStringBuilder) {
/* 545 */     paramStringBuilder.append('@').append(paramBoolean ? ClassInfo.getSimpleName(this.name) : this.name);
/*     */     AnnotationParameterValueList annotationParameterValueList;
/* 547 */     if (!(annotationParameterValueList = getParameterValues()).isEmpty()) {
/* 548 */       paramStringBuilder.append('(');
/* 549 */       for (byte b = 0; b < annotationParameterValueList.size(); b++) {
/* 550 */         if (b > 0) {
/* 551 */           paramStringBuilder.append(", ");
/*     */         }
/* 553 */         AnnotationParameterValue annotationParameterValue = annotationParameterValueList.get(b);
/* 554 */         if (annotationParameterValueList.size() > 1 || !"value".equals(annotationParameterValue.getName())) {
/* 555 */           annotationParameterValue.toString(paramBoolean, paramStringBuilder);
/*     */         } else {
/* 557 */           annotationParameterValue.toStringParamValueOnly(paramBoolean, paramStringBuilder);
/*     */         } 
/*     */       } 
/* 560 */       paramStringBuilder.append(')');
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\AnnotationInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */