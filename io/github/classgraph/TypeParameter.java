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
/*     */ public final class TypeParameter
/*     */   extends HierarchicalTypeSignature
/*     */ {
/*     */   final String name;
/*     */   final ReferenceTypeSignature classBound;
/*     */   final List<ReferenceTypeSignature> interfaceBounds;
/*     */   
/*     */   protected TypeParameter(String paramString, ReferenceTypeSignature paramReferenceTypeSignature, List<ReferenceTypeSignature> paramList) {
/*  68 */     this.name = paramString;
/*  69 */     this.classBound = paramReferenceTypeSignature;
/*  70 */     this.interfaceBounds = paramList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getName() {
/*  79 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ReferenceTypeSignature getClassBound() {
/*  88 */     return this.classBound;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<ReferenceTypeSignature> getInterfaceBounds() {
/*  97 */     return this.interfaceBounds;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void addTypeAnnotation(List<Classfile.TypePathNode> paramList, AnnotationInfo paramAnnotationInfo) {
/* 102 */     if (paramList.isEmpty()) {
/* 103 */       addTypeAnnotation(paramAnnotationInfo); return;
/*     */     } 
/* 105 */     throw new IllegalArgumentException("Type parameter should have empty typePath");
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
/*     */   static List<TypeParameter> parseList(Parser paramParser, String paramString) {
/* 124 */     if (paramParser.peek() != '<') {
/* 125 */       return Collections.emptyList();
/*     */     }
/* 127 */     paramParser.expect('<');
/* 128 */     ArrayList<TypeParameter> arrayList = new ArrayList(1);
/* 129 */     while (paramParser.peek() != '>') {
/* 130 */       List<?> list; if (!paramParser.hasMore()) {
/* 131 */         throw new ParseException(paramParser, "Missing '>'");
/*     */       }
/*     */       
/* 134 */       if (!TypeUtils.getIdentifierToken(paramParser, false)) {
/* 135 */         throw new ParseException(paramParser, "Could not parse identifier token");
/*     */       }
/* 137 */       String str = paramParser.currToken();
/*     */       
/* 139 */       ReferenceTypeSignature referenceTypeSignature = ReferenceTypeSignature.parseClassBound(paramParser, paramString);
/*     */ 
/*     */       
/* 142 */       if (paramParser.peek() == ':') {
/* 143 */         list = new ArrayList();
/* 144 */         while (paramParser.peek() == ':') {
/* 145 */           paramParser.expect(':');
/*     */           
/*     */           ReferenceTypeSignature referenceTypeSignature1;
/* 148 */           if ((referenceTypeSignature1 = ReferenceTypeSignature.parseReferenceTypeSignature(paramParser, paramString)) == null) {
/* 149 */             throw new ParseException(paramParser, "Missing interface type signature");
/*     */           }
/* 151 */           list.add(referenceTypeSignature1);
/*     */         } 
/*     */       } else {
/* 154 */         list = Collections.emptyList();
/*     */       } 
/* 156 */       arrayList.add(new TypeParameter(str, referenceTypeSignature, (List)list));
/*     */     } 
/* 158 */     paramParser.expect('>');
/* 159 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final String getClassName() {
/* 170 */     throw new IllegalArgumentException("getClassName() cannot be called here");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final ClassInfo getClassInfo() {
/* 178 */     throw new IllegalArgumentException("getClassInfo() cannot be called here");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void setScanResult(ScanResult paramScanResult) {
/* 186 */     super.setScanResult(paramScanResult);
/* 187 */     if (this.classBound != null) {
/* 188 */       this.classBound.setScanResult(paramScanResult);
/*     */     }
/* 190 */     if (this.interfaceBounds != null) {
/* 191 */       for (Iterator<ReferenceTypeSignature> iterator = this.interfaceBounds.iterator(); iterator.hasNext();) {
/* 192 */         (referenceTypeSignature = iterator.next()).setScanResult(paramScanResult);
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
/*     */   protected final void findReferencedClassNames(Set<String> paramSet) {
/* 204 */     if (this.classBound != null) {
/* 205 */       this.classBound.findReferencedClassNames(paramSet);
/*     */     }
/* 207 */     for (Iterator<ReferenceTypeSignature> iterator = this.interfaceBounds.iterator(); iterator.hasNext();) {
/* 208 */       (referenceTypeSignature = iterator.next()).findReferencedClassNames(paramSet);
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
/* 219 */     return this.name.hashCode() + ((this.classBound == null) ? 0 : (this.classBound.hashCode() * 7)) + this.interfaceBounds
/* 220 */       .hashCode() * 15;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 228 */     if (paramObject == this)
/* 229 */       return true; 
/* 230 */     if (!(paramObject instanceof TypeParameter)) {
/* 231 */       return false;
/*     */     }
/*     */     
/* 234 */     if (((TypeParameter)(paramObject = paramObject)).name.equals(this.name) && Objects.equals(((TypeParameter)paramObject).typeAnnotationInfo, this.typeAnnotationInfo) && ((((TypeParameter)paramObject).classBound == null && this.classBound == null) || (((TypeParameter)paramObject).classBound != null && ((TypeParameter)paramObject).classBound
/*     */       
/* 236 */       .equals(this.classBound))) && ((TypeParameter)paramObject).interfaceBounds
/* 237 */       .equals(this.interfaceBounds)) return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   protected final void toStringInternal(boolean paramBoolean, AnnotationInfoList paramAnnotationInfoList, StringBuilder paramStringBuilder) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield typeAnnotationInfo : Lio/github/classgraph/AnnotationInfoList;
/*     */     //   4: ifnull -> 68
/*     */     //   7: aload_0
/*     */     //   8: getfield typeAnnotationInfo : Lio/github/classgraph/AnnotationInfoList;
/*     */     //   11: invokevirtual iterator : ()Ljava/util/Iterator;
/*     */     //   14: astore #4
/*     */     //   16: aload #4
/*     */     //   18: invokeinterface hasNext : ()Z
/*     */     //   23: ifeq -> 68
/*     */     //   26: aload #4
/*     */     //   28: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   33: checkcast io/github/classgraph/AnnotationInfo
/*     */     //   36: astore #5
/*     */     //   38: aload_2
/*     */     //   39: ifnull -> 51
/*     */     //   42: aload_2
/*     */     //   43: aload #5
/*     */     //   45: invokevirtual contains : (Ljava/lang/Object;)Z
/*     */     //   48: ifne -> 65
/*     */     //   51: aload #5
/*     */     //   53: iload_1
/*     */     //   54: aload_3
/*     */     //   55: invokevirtual toString : (ZLjava/lang/StringBuilder;)V
/*     */     //   58: aload_3
/*     */     //   59: bipush #32
/*     */     //   61: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   64: pop
/*     */     //   65: goto -> 16
/*     */     //   68: aload_3
/*     */     //   69: iload_1
/*     */     //   70: ifeq -> 83
/*     */     //   73: aload_0
/*     */     //   74: getfield name : Ljava/lang/String;
/*     */     //   77: invokestatic getSimpleName : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   80: goto -> 87
/*     */     //   83: aload_0
/*     */     //   84: getfield name : Ljava/lang/String;
/*     */     //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   90: pop
/*     */     //   91: aload_0
/*     */     //   92: getfield classBound : Lio/github/classgraph/ReferenceTypeSignature;
/*     */     //   95: ifnull -> 145
/*     */     //   98: aload_0
/*     */     //   99: getfield classBound : Lio/github/classgraph/ReferenceTypeSignature;
/*     */     //   102: iload_1
/*     */     //   103: invokevirtual toString : (Z)Ljava/lang/String;
/*     */     //   106: dup
/*     */     //   107: astore #4
/*     */     //   109: ldc 'java.lang.Object'
/*     */     //   111: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   114: ifne -> 145
/*     */     //   117: aload #4
/*     */     //   119: ldc 'Object'
/*     */     //   121: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   124: ifeq -> 148
/*     */     //   127: aload_0
/*     */     //   128: getfield classBound : Lio/github/classgraph/ReferenceTypeSignature;
/*     */     //   131: checkcast io/github/classgraph/ClassRefTypeSignature
/*     */     //   134: getfield className : Ljava/lang/String;
/*     */     //   137: ldc 'java.lang.Object'
/*     */     //   139: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   142: ifeq -> 148
/*     */     //   145: aconst_null
/*     */     //   146: astore #4
/*     */     //   148: aload #4
/*     */     //   150: ifnonnull -> 165
/*     */     //   153: aload_0
/*     */     //   154: getfield interfaceBounds : Ljava/util/List;
/*     */     //   157: invokeinterface isEmpty : ()Z
/*     */     //   162: ifne -> 172
/*     */     //   165: aload_3
/*     */     //   166: ldc ' extends'
/*     */     //   168: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   171: pop
/*     */     //   172: aload #4
/*     */     //   174: ifnull -> 191
/*     */     //   177: aload_3
/*     */     //   178: bipush #32
/*     */     //   180: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   183: pop
/*     */     //   184: aload_3
/*     */     //   185: aload #4
/*     */     //   187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   190: pop
/*     */     //   191: iconst_0
/*     */     //   192: istore #5
/*     */     //   194: iload #5
/*     */     //   196: aload_0
/*     */     //   197: getfield interfaceBounds : Ljava/util/List;
/*     */     //   200: invokeinterface size : ()I
/*     */     //   205: if_icmpge -> 257
/*     */     //   208: iload #5
/*     */     //   210: ifgt -> 218
/*     */     //   213: aload #4
/*     */     //   215: ifnull -> 225
/*     */     //   218: aload_3
/*     */     //   219: ldc ' &'
/*     */     //   221: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   224: pop
/*     */     //   225: aload_3
/*     */     //   226: bipush #32
/*     */     //   228: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   231: pop
/*     */     //   232: aload_0
/*     */     //   233: getfield interfaceBounds : Ljava/util/List;
/*     */     //   236: iload #5
/*     */     //   238: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   243: checkcast io/github/classgraph/ReferenceTypeSignature
/*     */     //   246: iload_1
/*     */     //   247: aload_3
/*     */     //   248: invokevirtual toString : (ZLjava/lang/StringBuilder;)V
/*     */     //   251: iinc #5, 1
/*     */     //   254: goto -> 194
/*     */     //   257: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #245	-> 0
/*     */     //   #246	-> 7
/*     */     //   #247	-> 38
/*     */     //   #248	-> 51
/*     */     //   #249	-> 58
/*     */     //   #251	-> 65
/*     */     //   #253	-> 68
/*     */     //   #255	-> 91
/*     */     //   #258	-> 98
/*     */     //   #259	-> 107
/*     */     //   #260	-> 139
/*     */     //   #262	-> 145
/*     */     //   #265	-> 148
/*     */     //   #266	-> 165
/*     */     //   #268	-> 172
/*     */     //   #269	-> 177
/*     */     //   #270	-> 184
/*     */     //   #272	-> 191
/*     */     //   #273	-> 208
/*     */     //   #274	-> 218
/*     */     //   #276	-> 225
/*     */     //   #277	-> 232
/*     */     //   #272	-> 251
/*     */     //   #279	-> 257
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\TypeParameter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */