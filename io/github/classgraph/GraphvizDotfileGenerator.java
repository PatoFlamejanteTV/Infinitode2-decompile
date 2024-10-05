/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.util.BitSet;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import nonapi.io.github.classgraph.scanspec.ScanSpec;
/*     */ import nonapi.io.github.classgraph.utils.CollectionUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class GraphvizDotfileGenerator
/*     */ {
/*     */   private static final String STANDARD_CLASS_COLOR = "fff2b6";
/*     */   private static final String INTERFACE_COLOR = "b6e7ff";
/*     */   private static final String ANNOTATION_COLOR = "f3c9ff";
/*     */   private static final int PARAM_WRAP_WIDTH = 40;
/*  53 */   private static final BitSet IS_UNICODE_WHITESPACE = new BitSet(65536);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  93 */     for (byte b = 0; b < 26; b++) {
/*  94 */       IS_UNICODE_WHITESPACE.set(" \t\n\013\f\r  ᠎               　".charAt(b));
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
/*     */   private static boolean isUnicodeWhitespace(char paramChar) {
/* 106 */     return IS_UNICODE_WHITESPACE.get(paramChar);
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
/*     */   private static void htmlEncode(CharSequence paramCharSequence, boolean paramBoolean, StringBuilder paramStringBuilder) {
/*     */     byte b;
/*     */     int i;
/* 121 */     for (b = 0, i = paramCharSequence.length(); b < i; b++) {
/*     */       char c;
/* 123 */       switch (c = paramCharSequence.charAt(b)) {
/*     */         case '&':
/* 125 */           paramStringBuilder.append("&amp;");
/*     */           break;
/*     */         case '<':
/* 128 */           paramStringBuilder.append("&lt;");
/*     */           break;
/*     */         case '>':
/* 131 */           paramStringBuilder.append("&gt;");
/*     */           break;
/*     */         case '"':
/* 134 */           paramStringBuilder.append("&quot;");
/*     */           break;
/*     */         case '\'':
/* 137 */           paramStringBuilder.append("&#x27;");
/*     */           break;
/*     */         case '\\':
/* 140 */           paramStringBuilder.append("&lsol;");
/*     */           break;
/*     */         case '/':
/* 143 */           paramStringBuilder.append("&#x2F;");
/*     */           break;
/*     */         
/*     */         case '—':
/* 147 */           paramStringBuilder.append("&mdash;");
/*     */           break;
/*     */         case '–':
/* 150 */           paramStringBuilder.append("&ndash;");
/*     */           break;
/*     */         case '“':
/* 153 */           paramStringBuilder.append("&ldquo;");
/*     */           break;
/*     */         case '”':
/* 156 */           paramStringBuilder.append("&rdquo;");
/*     */           break;
/*     */         case '‘':
/* 159 */           paramStringBuilder.append("&lsquo;");
/*     */           break;
/*     */         case '’':
/* 162 */           paramStringBuilder.append("&rsquo;");
/*     */           break;
/*     */         case '«':
/* 165 */           paramStringBuilder.append("&laquo;");
/*     */           break;
/*     */         case '»':
/* 168 */           paramStringBuilder.append("&raquo;");
/*     */           break;
/*     */         case '£':
/* 171 */           paramStringBuilder.append("&pound;");
/*     */           break;
/*     */         case '©':
/* 174 */           paramStringBuilder.append("&copy;");
/*     */           break;
/*     */         case '®':
/* 177 */           paramStringBuilder.append("&reg;");
/*     */           break;
/*     */         case ' ':
/* 180 */           paramStringBuilder.append("&nbsp;");
/*     */           break;
/*     */         case '\n':
/* 183 */           if (paramBoolean) {
/* 184 */             paramStringBuilder.append("<br>"); break;
/*     */           } 
/* 186 */           paramStringBuilder.append(' ');
/*     */           break;
/*     */         
/*     */         default:
/* 190 */           if (c <= ' ' || isUnicodeWhitespace(c)) {
/* 191 */             paramStringBuilder.append(' '); break;
/*     */           } 
/* 193 */           paramStringBuilder.append(c);
/*     */           break;
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
/*     */   private static void htmlEncode(CharSequence paramCharSequence, StringBuilder paramStringBuilder) {
/* 209 */     htmlEncode(paramCharSequence, false, paramStringBuilder);
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
/*     */   private static void labelClassNodeHTML(ClassInfo paramClassInfo, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ScanSpec paramScanSpec, StringBuilder paramStringBuilder) {
/* 235 */     paramStringBuilder.append("[shape=").append(paramString1).append(",style=filled,fillcolor=\"#").append(paramString2)
/* 236 */       .append("\",label=");
/* 237 */     paramStringBuilder.append('<');
/* 238 */     paramStringBuilder.append("<table border='0' cellborder='0' cellspacing='1'>");
/*     */ 
/*     */     
/* 241 */     paramStringBuilder.append("<tr><td><font point-size='12'>").append(paramClassInfo.getModifiersStr()).append(' ')
/* 242 */       .append(paramClassInfo.isEnum() ? "enum" : (
/* 243 */         paramClassInfo.isAnnotation() ? "@interface" : (paramClassInfo.isInterface() ? "interface" : "class")))
/* 244 */       .append("</font></td></tr>");
/*     */     
/* 246 */     if (paramClassInfo.getName().contains(".")) {
/* 247 */       paramStringBuilder.append("<tr><td><font point-size='14'><b>");
/* 248 */       htmlEncode(paramClassInfo.getPackageName() + ".", paramStringBuilder);
/* 249 */       paramStringBuilder.append("</b></font></td></tr>");
/*     */     } 
/*     */ 
/*     */     
/* 253 */     paramStringBuilder.append("<tr><td><font point-size='20'><b>");
/* 254 */     htmlEncode(paramClassInfo.getSimpleName(), paramStringBuilder);
/* 255 */     paramStringBuilder.append("</b></font></td></tr>");
/*     */ 
/*     */ 
/*     */     
/* 259 */     int i = (int)(Integer.parseInt(paramString2.substring(0, 2), 16) * 0.8F);
/* 260 */     int k = (int)(Integer.parseInt(paramString2.substring(2, 4), 16) * 0.8F);
/* 261 */     int j = (int)(Integer.parseInt(paramString2.substring(4, 6), 16) * 0.8F);
/* 262 */     String str = String.format("#%s%s%s%s%s%s", new Object[] { Integer.toString(i >> 4, 16), 
/* 263 */           Integer.toString(i & 0xF, 16), Integer.toString(k >> 4, 16), Integer.toString(k & 0xF, 16), 
/* 264 */           Integer.toString(j >> 4, 16), Integer.toString(j & 0xF, 16) });
/*     */     
/*     */     AnnotationInfoList annotationInfoList;
/*     */     
/* 268 */     if ((annotationInfoList = paramClassInfo.annotationInfo) != null && !annotationInfoList.isEmpty()) {
/* 269 */       paramStringBuilder.append("<tr><td colspan='3' bgcolor='").append(str)
/* 270 */         .append("'><font point-size='12'><b>ANNOTATIONS</b></font></td></tr>");
/*     */       
/* 272 */       CollectionUtils.sortIfNotEmpty(annotationInfoList = new AnnotationInfoList(annotationInfoList));
/* 273 */       for (Iterator<AnnotationInfo> iterator = annotationInfoList.iterator(); iterator.hasNext();) {
/*     */         
/* 275 */         if (!(str1 = (annotationInfo = iterator.next()).getName()).startsWith("java.lang.annotation.")) {
/* 276 */           paramStringBuilder.append("<tr>");
/* 277 */           paramStringBuilder.append("<td align='center' valign='top'>");
/* 278 */           htmlEncode(annotationInfo.toString(), paramStringBuilder);
/* 279 */           paramStringBuilder.append("</td></tr>");
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 285 */     FieldInfoList fieldInfoList = paramClassInfo.fieldInfo;
/* 286 */     if (paramBoolean1 && fieldInfoList != null && !fieldInfoList.isEmpty()) {
/*     */       
/* 288 */       CollectionUtils.sortIfNotEmpty(fieldInfoList = new FieldInfoList(fieldInfoList));
/* 289 */       for (k = fieldInfoList.size() - 1; k >= 0; k--) {
/*     */         
/* 291 */         if (fieldInfoList.get(k).getName().equals("serialVersionUID")) {
/* 292 */           fieldInfoList.remove(k);
/*     */         }
/*     */       } 
/* 295 */       if (!fieldInfoList.isEmpty()) {
/* 296 */         paramStringBuilder.append("<tr><td colspan='3' bgcolor='").append(str)
/* 297 */           .append("'><font point-size='12'><b>")
/* 298 */           .append(paramScanSpec.ignoreFieldVisibility ? "" : "PUBLIC ")
/* 299 */           .append("FIELDS</b></font></td></tr>");
/* 300 */         paramStringBuilder.append("<tr><td cellpadding='0'>");
/* 301 */         paramStringBuilder.append("<table border='0' cellborder='0'>");
/* 302 */         for (FieldInfo fieldInfo : fieldInfoList) {
/* 303 */           paramStringBuilder.append("<tr>");
/* 304 */           paramStringBuilder.append("<td align='right' valign='top'>");
/*     */           
/*     */           AnnotationInfoList annotationInfoList1;
/*     */           
/* 308 */           if ((annotationInfoList1 = fieldInfo.annotationInfo) != null) {
/* 309 */             for (AnnotationInfo annotationInfo : annotationInfoList1) {
/* 310 */               if (paramStringBuilder.charAt(paramStringBuilder.length() - 1) != ' ') {
/* 311 */                 paramStringBuilder.append(' ');
/*     */               }
/* 313 */               htmlEncode(annotationInfo.toString(), paramStringBuilder);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/* 318 */           if (paramScanSpec.ignoreFieldVisibility) {
/* 319 */             if (paramStringBuilder.charAt(paramStringBuilder.length() - 1) != ' ') {
/* 320 */               paramStringBuilder.append(' ');
/*     */             }
/* 322 */             paramStringBuilder.append(fieldInfo.getModifiersStr());
/*     */           } 
/*     */ 
/*     */           
/* 326 */           if (paramStringBuilder.charAt(paramStringBuilder.length() - 1) != ' ') {
/* 327 */             paramStringBuilder.append(' ');
/*     */           }
/* 329 */           TypeSignature typeSignature = fieldInfo.getTypeSignatureOrTypeDescriptor();
/* 330 */           htmlEncode(paramBoolean3 ? typeSignature.toStringWithSimpleNames() : typeSignature.toString(), paramStringBuilder);
/* 331 */           paramStringBuilder.append("</td>");
/*     */ 
/*     */           
/* 334 */           paramStringBuilder.append("<td align='left' valign='top'><b>");
/*     */           String str1;
/* 336 */           htmlEncode(str1 = fieldInfo.getName(), paramStringBuilder);
/* 337 */           paramStringBuilder.append("</b></td></tr>");
/*     */         } 
/* 339 */         paramStringBuilder.append("</table>");
/* 340 */         paramStringBuilder.append("</td></tr>");
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 345 */     MethodInfoList methodInfoList = paramClassInfo.methodInfo;
/* 346 */     if (paramBoolean2 && methodInfoList != null) {
/*     */       MethodInfoList methodInfoList1;
/* 348 */       CollectionUtils.sortIfNotEmpty(methodInfoList1 = new MethodInfoList(methodInfoList));
/* 349 */       for (int m = methodInfoList1.size() - 1; m >= 0; m--) {
/*     */         MethodInfo methodInfo;
/*     */         
/* 352 */         String str1 = (methodInfo = methodInfoList1.get(m)).getName();
/* 353 */         int n = (methodInfo.getParameterInfo()).length;
/* 354 */         if (str1.equals("<clinit>") || (str1.equals("hashCode") && n == 0) || (str1
/* 355 */           .equals("toString") && n == 0) || (str1.equals("equals") && n == 1 && methodInfo
/* 356 */           .getTypeDescriptor().toString().equals("boolean (java.lang.Object)"))) {
/* 357 */           methodInfoList1.remove(m);
/*     */         }
/*     */       } 
/* 360 */       if (!methodInfoList1.isEmpty()) {
/* 361 */         paramStringBuilder.append("<tr><td cellpadding='0'>");
/* 362 */         paramStringBuilder.append("<table border='0' cellborder='0'>");
/* 363 */         paramStringBuilder.append("<tr><td colspan='3' bgcolor='").append(str)
/* 364 */           .append("'><font point-size='12'><b>")
/* 365 */           .append(paramScanSpec.ignoreMethodVisibility ? "" : "PUBLIC ")
/* 366 */           .append("METHODS</b></font></td></tr>");
/* 367 */         for (MethodInfo methodInfo : methodInfoList1) {
/* 368 */           paramStringBuilder.append("<tr>");
/*     */ 
/*     */ 
/*     */           
/* 372 */           paramStringBuilder.append("<td align='right' valign='top'>");
/*     */           AnnotationInfoList annotationInfoList1;
/* 374 */           if ((annotationInfoList1 = methodInfo.annotationInfo) != null) {
/* 375 */             for (AnnotationInfo annotationInfo : annotationInfoList1) {
/* 376 */               if (paramStringBuilder.charAt(paramStringBuilder.length() - 1) != ' ') {
/* 377 */                 paramStringBuilder.append(' ');
/*     */               }
/* 379 */               htmlEncode(annotationInfo.toString(), paramStringBuilder);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/* 384 */           if (paramScanSpec.ignoreMethodVisibility) {
/* 385 */             if (paramStringBuilder.charAt(paramStringBuilder.length() - 1) != ' ') {
/* 386 */               paramStringBuilder.append(' ');
/*     */             }
/* 388 */             paramStringBuilder.append(methodInfo.getModifiersStr());
/*     */           } 
/*     */ 
/*     */           
/* 392 */           if (paramStringBuilder.charAt(paramStringBuilder.length() - 1) != ' ') {
/* 393 */             paramStringBuilder.append(' ');
/*     */           }
/* 395 */           if (!methodInfo.getName().equals("<init>")) {
/*     */             
/* 397 */             TypeSignature typeSignature = methodInfo.getTypeSignatureOrTypeDescriptor().getResultType();
/* 398 */             htmlEncode(paramBoolean3 ? typeSignature
/* 399 */                 .toStringWithSimpleNames() : typeSignature.toString(), paramStringBuilder);
/*     */           } else {
/*     */             
/* 402 */             paramStringBuilder.append("<b>&lt;constructor&gt;</b>");
/*     */           } 
/* 404 */           paramStringBuilder.append("</td>");
/*     */ 
/*     */           
/* 407 */           paramStringBuilder.append("<td align='left' valign='top'>");
/* 408 */           paramStringBuilder.append("<b>");
/* 409 */           if (methodInfo.getName().equals("<init>")) {
/*     */             
/* 411 */             htmlEncode(paramClassInfo.getSimpleName(), paramStringBuilder);
/*     */           } else {
/* 413 */             htmlEncode(methodInfo.getName(), paramStringBuilder);
/*     */           } 
/* 415 */           paramStringBuilder.append("</b>&nbsp;");
/* 416 */           paramStringBuilder.append("</td>");
/*     */ 
/*     */           
/* 419 */           paramStringBuilder.append("<td align='left' valign='top'>");
/* 420 */           paramStringBuilder.append('(');
/*     */           MethodParameterInfo[] arrayOfMethodParameterInfo;
/* 422 */           if ((arrayOfMethodParameterInfo = methodInfo.getParameterInfo()).length != 0) {
/* 423 */             byte b; int n; for (b = 0, n = 0; b < arrayOfMethodParameterInfo.length; b++) {
/* 424 */               if (b > 0) {
/* 425 */                 paramStringBuilder.append(", ");
/* 426 */                 n += true;
/*     */               } 
/* 428 */               if (n > 40) {
/* 429 */                 paramStringBuilder.append("</td></tr><tr><td></td><td></td><td align='left' valign='top'>");
/* 430 */                 n = 0;
/*     */               } 
/*     */               
/*     */               AnnotationInfo[] arrayOfAnnotationInfo;
/*     */               
/* 435 */               if ((arrayOfAnnotationInfo = (arrayOfMethodParameterInfo[b]).annotationInfo) != null) {
/* 436 */                 int i1; byte b1; for (i1 = (arrayOfAnnotationInfo = arrayOfAnnotationInfo).length, b1 = 0; b1 < i1; b1++) {
/*     */                   String str3; AnnotationInfo annotationInfo;
/* 438 */                   if (!(str3 = (annotationInfo = arrayOfAnnotationInfo[b1]).toString()).isEmpty()) {
/* 439 */                     if (paramStringBuilder.charAt(paramStringBuilder.length() - 1) != ' ') {
/* 440 */                       paramStringBuilder.append(' ');
/*     */                     }
/* 442 */                     htmlEncode(str3, paramStringBuilder);
/*     */                     
/* 444 */                     if ((n = n + 1 + str3.length()) > 40) {
/* 445 */                       paramStringBuilder.append("</td></tr><tr><td></td><td></td><td align='left' valign='top'>");
/*     */                       
/* 447 */                       n = 0;
/*     */                     } 
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */ 
/*     */               
/* 454 */               TypeSignature typeSignature = arrayOfMethodParameterInfo[b].getTypeSignatureOrTypeDescriptor();
/*     */               
/*     */               String str1;
/* 457 */               htmlEncode(str1 = (String)(paramBoolean3 ? typeSignature.toStringWithSimpleNames() : typeSignature.toString()), paramStringBuilder);
/* 458 */               n += str1.length();
/*     */               
/*     */               String str2;
/*     */               
/* 462 */               if ((str2 = arrayOfMethodParameterInfo[b].getName()) != null) {
/* 463 */                 paramStringBuilder.append(" <B>");
/* 464 */                 htmlEncode(str2, paramStringBuilder);
/* 465 */                 n += 1 + str2.length();
/* 466 */                 paramStringBuilder.append("</B>");
/*     */               } 
/*     */             } 
/*     */           } 
/* 470 */           paramStringBuilder.append(')');
/* 471 */           paramStringBuilder.append("</td></tr>");
/*     */         } 
/* 473 */         paramStringBuilder.append("</table>");
/* 474 */         paramStringBuilder.append("</td></tr>");
/*     */       } 
/*     */     } 
/* 477 */     paramStringBuilder.append("</table>");
/* 478 */     paramStringBuilder.append(">]");
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
/*     */   static String generateGraphVizDotFile(ClassInfoList paramClassInfoList, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, ScanSpec paramScanSpec) {
/*     */     StringBuilder stringBuilder;
/* 513 */     (stringBuilder = new StringBuilder(1048576)).append("digraph {\n");
/* 514 */     stringBuilder.append("size=\"").append(paramFloat1).append(',').append(paramFloat2).append("\";\n");
/* 515 */     stringBuilder.append("layout=dot;\n");
/* 516 */     stringBuilder.append("rankdir=\"BT\";\n");
/* 517 */     stringBuilder.append("overlap=false;\n");
/* 518 */     stringBuilder.append("splines=true;\n");
/* 519 */     stringBuilder.append("pack=true;\n");
/* 520 */     stringBuilder.append("graph [fontname = \"Courier, Regular\"]\n");
/* 521 */     stringBuilder.append("node [fontname = \"Courier, Regular\"]\n");
/* 522 */     stringBuilder.append("edge [fontname = \"Courier, Regular\"]\n");
/*     */     
/* 524 */     ClassInfoList classInfoList1 = paramClassInfoList.getStandardClasses();
/* 525 */     ClassInfoList classInfoList2 = paramClassInfoList.getInterfaces();
/* 526 */     paramClassInfoList = paramClassInfoList.getAnnotations();
/*     */     
/* 528 */     for (ClassInfo classInfo : classInfoList1) {
/* 529 */       stringBuilder.append('"').append(classInfo.getName()).append('"');
/* 530 */       labelClassNodeHTML(classInfo, "box", "fff2b6", paramBoolean1, paramBoolean3, paramBoolean6, paramScanSpec, stringBuilder);
/*     */       
/* 532 */       stringBuilder.append(";\n");
/*     */     } 
/*     */     
/* 535 */     for (ClassInfo classInfo : classInfoList2) {
/* 536 */       stringBuilder.append('"').append(classInfo.getName()).append('"');
/* 537 */       labelClassNodeHTML(classInfo, "diamond", "b6e7ff", paramBoolean1, paramBoolean3, paramBoolean6, paramScanSpec, stringBuilder);
/*     */       
/* 539 */       stringBuilder.append(";\n");
/*     */     } 
/*     */     
/* 542 */     for (ClassInfo classInfo : paramClassInfoList) {
/* 543 */       stringBuilder.append('"').append(classInfo.getName()).append('"');
/* 544 */       labelClassNodeHTML(classInfo, "oval", "f3c9ff", paramBoolean1, paramBoolean3, paramBoolean6, paramScanSpec, stringBuilder);
/*     */       
/* 546 */       stringBuilder.append(";\n");
/*     */     } 
/*     */     
/*     */     HashSet<String> hashSet;
/* 550 */     (hashSet = new HashSet<>()).addAll(classInfoList1.getNames());
/* 551 */     hashSet.addAll(classInfoList2.getNames());
/* 552 */     hashSet.addAll(paramClassInfoList.getNames());
/*     */     
/* 554 */     stringBuilder.append('\n'); Iterator<ClassInfo> iterator;
/* 555 */     for (iterator = classInfoList1.iterator(); iterator.hasNext(); ) {
/* 556 */       ClassInfo classInfo; for (null = (classInfo = iterator.next()).getSuperclasses().directOnly().iterator(); null.hasNext();) {
/* 557 */         if ((classInfo1 = null.next()) != null && hashSet.contains(classInfo1.getName()) && 
/* 558 */           !classInfo1.getName().equals("java.lang.Object"))
/*     */         {
/* 560 */           stringBuilder.append("  \"").append(classInfo.getName()).append("\" -> \"")
/* 561 */             .append(classInfo1.getName()).append("\" [arrowsize=2.5]\n");
/*     */         }
/*     */       } 
/*     */       
/* 565 */       for (ClassInfo classInfo1 : classInfo.getInterfaces().directOnly()) {
/* 566 */         if (hashSet.contains(classInfo1.getName()))
/*     */         {
/* 568 */           stringBuilder.append("  \"").append(classInfo.getName()).append("\" -> \"")
/* 569 */             .append(classInfo1.getName())
/* 570 */             .append("\" [arrowhead=diamond, arrowsize=2.5]\n");
/*     */         }
/*     */       } 
/*     */       
/* 574 */       if (paramBoolean2 && classInfo.fieldInfo != null) {
/* 575 */         for (Iterator<FieldInfo> iterator1 = classInfo.fieldInfo.iterator(); iterator1.hasNext();) {
/* 576 */           for (ClassInfo classInfo1 : (fieldInfo = iterator1.next()).findReferencedClassInfo(null)) {
/* 577 */             if (hashSet.contains(classInfo1.getName()))
/*     */             {
/* 579 */               stringBuilder.append("  \"").append(classInfo1.getName()).append("\" -> \"")
/* 580 */                 .append(classInfo.getName())
/* 581 */                 .append("\" [arrowtail=obox, arrowsize=2.5, dir=back]\n");
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 587 */       if (paramBoolean4 && classInfo.methodInfo != null) {
/* 588 */         for (Iterator<MethodInfo> iterator1 = classInfo.methodInfo.iterator(); iterator1.hasNext();) {
/* 589 */           for (ClassInfo classInfo1 : (methodInfo = iterator1.next()).findReferencedClassInfo(null)) {
/* 590 */             if (hashSet.contains(classInfo1.getName()))
/*     */             {
/* 592 */               stringBuilder.append("  \"").append(classInfo1.getName()).append("\" -> \"")
/* 593 */                 .append(classInfo.getName())
/* 594 */                 .append("\" [arrowtail=box, arrowsize=2.5, dir=back]\n");
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/* 600 */     for (iterator = classInfoList2.iterator(); iterator.hasNext();) {
/* 601 */       for (ClassInfo classInfo1 : (classInfo = iterator.next()).getInterfaces().directOnly()) {
/* 602 */         if (hashSet.contains(classInfo1.getName()))
/*     */         {
/* 604 */           stringBuilder.append("  \"").append(classInfo.getName()).append("\" -> \"")
/* 605 */             .append(classInfo1.getName()).append("\" [arrowhead=diamond, arrowsize=2.5]\n");
/*     */         }
/*     */       } 
/*     */     } 
/* 609 */     if (paramBoolean5) {
/* 610 */       for (iterator = paramClassInfoList.iterator(); iterator.hasNext(); ) {
/* 611 */         ClassInfo classInfo; for (ClassInfo classInfo1 : (classInfo = iterator.next()).getClassesWithAnnotationDirectOnly()) {
/* 612 */           if (hashSet.contains(classInfo1.getName()))
/*     */           {
/* 614 */             stringBuilder.append("  \"").append(classInfo1.getName()).append("\" -> \"")
/* 615 */               .append(classInfo.getName()).append("\" [arrowhead=dot, arrowsize=2.5]\n");
/*     */           }
/*     */         } 
/* 618 */         for (ClassInfo classInfo1 : classInfo
/* 619 */           .getClassesWithMethodAnnotationDirectOnly()) {
/* 620 */           if (hashSet.contains(classInfo1.getName()))
/*     */           {
/* 622 */             stringBuilder.append("  \"").append(classInfo1.getName()).append("\" -> \"")
/* 623 */               .append(classInfo.getName()).append("\" [arrowhead=odot, arrowsize=2.5]\n");
/*     */           }
/*     */         } 
/* 626 */         for (ClassInfo classInfo1 : classInfo
/* 627 */           .getClassesWithFieldAnnotationDirectOnly()) {
/* 628 */           if (hashSet.contains(classInfo1.getName()))
/*     */           {
/* 630 */             stringBuilder.append("  \"").append(classInfo1.getName()).append("\" -> \"")
/* 631 */               .append(classInfo.getName()).append("\" [arrowhead=odot, arrowsize=2.5]\n");
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/* 636 */     stringBuilder.append('}');
/* 637 */     return stringBuilder.toString();
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
/*     */   static String generateGraphVizDotFileFromInterClassDependencies(ClassInfoList paramClassInfoList, float paramFloat1, float paramFloat2, boolean paramBoolean) {
/*     */     StringBuilder stringBuilder;
/* 663 */     (stringBuilder = new StringBuilder(1048576)).append("digraph {\n");
/* 664 */     stringBuilder.append("size=\"").append(paramFloat1).append(',').append(paramFloat2).append("\";\n");
/* 665 */     stringBuilder.append("layout=dot;\n");
/* 666 */     stringBuilder.append("rankdir=\"BT\";\n");
/* 667 */     stringBuilder.append("overlap=false;\n");
/* 668 */     stringBuilder.append("splines=true;\n");
/* 669 */     stringBuilder.append("pack=true;\n");
/* 670 */     stringBuilder.append("graph [fontname = \"Courier, Regular\"]\n");
/* 671 */     stringBuilder.append("node [fontname = \"Courier, Regular\"]\n");
/* 672 */     stringBuilder.append("edge [fontname = \"Courier, Regular\"]\n");
/*     */     
/* 674 */     HashSet hashSet = new HashSet(paramClassInfoList);
/* 675 */     if (paramBoolean) {
/* 676 */       for (ClassInfo classInfo : paramClassInfoList) {
/* 677 */         hashSet.addAll(classInfo.getClassDependencies());
/*     */       }
/*     */     }
/*     */     
/* 681 */     for (ClassInfo classInfo : hashSet) {
/* 682 */       stringBuilder.append('"').append(classInfo.getName()).append('"');
/* 683 */       stringBuilder.append("[shape=").append(classInfo.isAnnotation() ? "oval" : (classInfo.isInterface() ? "diamond" : "box"))
/* 684 */         .append(",style=filled,fillcolor=\"#").append(classInfo.isAnnotation() ? "f3c9ff" : (
/* 685 */           classInfo.isInterface() ? "b6e7ff" : "fff2b6"))
/* 686 */         .append("\",label=");
/* 687 */       stringBuilder.append('<');
/* 688 */       stringBuilder.append("<table border='0' cellborder='0' cellspacing='1'>");
/*     */ 
/*     */       
/* 691 */       stringBuilder.append("<tr><td><font point-size='12'>").append(classInfo.getModifiersStr()).append(' ')
/* 692 */         .append(classInfo.isEnum() ? "enum" : (
/* 693 */           classInfo.isAnnotation() ? "@interface" : (classInfo.isInterface() ? "interface" : "class")))
/* 694 */         .append("</font></td></tr>");
/*     */       
/* 696 */       if (classInfo.getName().contains(".")) {
/* 697 */         stringBuilder.append("<tr><td><font point-size='14'><b>");
/* 698 */         htmlEncode(classInfo.getPackageName(), stringBuilder);
/* 699 */         stringBuilder.append("</b></font></td></tr>");
/*     */       } 
/*     */ 
/*     */       
/* 703 */       stringBuilder.append("<tr><td><font point-size='20'><b>");
/* 704 */       htmlEncode(classInfo.getSimpleName(), stringBuilder);
/* 705 */       stringBuilder.append("</b></font></td></tr>");
/* 706 */       stringBuilder.append("</table>");
/* 707 */       stringBuilder.append(">];\n");
/*     */     } 
/*     */     
/* 710 */     stringBuilder.append('\n');
/* 711 */     for (Iterator<ClassInfo> iterator = paramClassInfoList.iterator(); iterator.hasNext();) {
/* 712 */       for (ClassInfo classInfo1 : (classInfo = iterator.next()).getClassDependencies()) {
/* 713 */         if (paramBoolean || hashSet.contains(classInfo1))
/*     */         {
/* 715 */           stringBuilder.append("  \"").append(classInfo.getName()).append("\" -> \"").append(classInfo1.getName())
/* 716 */             .append("\" [arrowsize=2.5]\n");
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 721 */     stringBuilder.append('}');
/* 722 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\GraphvizDotfileGenerator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */