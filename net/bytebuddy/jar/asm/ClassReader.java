/*      */ package net.bytebuddy.jar.asm;
/*      */ 
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ClassReader
/*      */ {
/*      */   public static final int SKIP_CODE = 1;
/*      */   public static final int SKIP_DEBUG = 2;
/*      */   public static final int SKIP_FRAMES = 4;
/*      */   public static final int EXPAND_FRAMES = 8;
/*      */   private static final int MAX_BUFFER_SIZE = 1048576;
/*      */   private static final int INPUT_STREAM_DATA_CHUNK_SIZE = 4096;
/*      */   @Deprecated
/*      */   public final byte[] b;
/*      */   public final int header;
/*      */   final byte[] a;
/*      */   private final int[] cpInfoOffsets;
/*      */   private final String[] constantUtf8Values;
/*      */   private final ConstantDynamic[] constantDynamicValues;
/*      */   private final int[] bootstrapMethodOffsets;
/*      */   private final int maxStringLength;
/*      */   
/*      */   public ClassReader(byte[] paramArrayOfbyte) {
/*  166 */     this(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassReader(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  180 */     this(paramArrayOfbyte, paramInt1, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ClassReader(byte[] paramArrayOfbyte, int paramInt, boolean paramBoolean) {
/*  193 */     this.a = paramArrayOfbyte;
/*  194 */     this.b = paramArrayOfbyte;
/*      */ 
/*      */     
/*  197 */     if (paramBoolean && readShort(paramInt + 6) > 64) {
/*  198 */       throw new IllegalArgumentException("Unsupported class file major version " + 
/*  199 */           readShort(paramInt + 6));
/*      */     }
/*      */ 
/*      */     
/*  203 */     int i = readUnsignedShort(paramInt + 8);
/*  204 */     this.cpInfoOffsets = new int[i];
/*  205 */     this.constantUtf8Values = new String[i];
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  210 */     byte b = 1;
/*  211 */     paramInt += 10;
/*  212 */     int j = 0;
/*  213 */     boolean bool1 = false;
/*  214 */     boolean bool2 = false;
/*      */     
/*  216 */     while (b < i) {
/*  217 */       int k; this.cpInfoOffsets[b++] = paramInt + 1;
/*      */       
/*  219 */       switch (paramArrayOfbyte[paramInt]) {
/*      */         case 3:
/*      */         case 4:
/*      */         case 9:
/*      */         case 10:
/*      */         case 11:
/*      */         case 12:
/*  226 */           k = 5;
/*      */           break;
/*      */         case 17:
/*  229 */           k = 5;
/*  230 */           bool1 = true;
/*  231 */           bool2 = true;
/*      */           break;
/*      */         case 18:
/*  234 */           k = 5;
/*  235 */           bool1 = true;
/*      */           break;
/*      */         case 5:
/*      */         case 6:
/*  239 */           k = 9;
/*  240 */           b++;
/*      */           break;
/*      */         
/*      */         case 1:
/*  244 */           if ((k = 3 + readUnsignedShort(paramInt + 1)) > j)
/*      */           {
/*      */ 
/*      */             
/*  248 */             j = k;
/*      */           }
/*      */           break;
/*      */         case 15:
/*  252 */           k = 4;
/*      */           break;
/*      */         case 7:
/*      */         case 8:
/*      */         case 16:
/*      */         case 19:
/*      */         case 20:
/*  259 */           k = 3;
/*      */           break;
/*      */         default:
/*  262 */           throw new IllegalArgumentException();
/*      */       } 
/*  264 */       paramInt += k;
/*      */     } 
/*  266 */     this.maxStringLength = j;
/*      */     
/*  268 */     this.header = paramInt;
/*      */ 
/*      */     
/*  271 */     this.constantDynamicValues = bool2 ? new ConstantDynamic[i] : null;
/*      */ 
/*      */     
/*  274 */     this
/*  275 */       .bootstrapMethodOffsets = bool1 ? readBootstrapMethodsAttribute(j) : null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassReader(InputStream paramInputStream) {
/*  287 */     this(readStream(paramInputStream, false));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassReader(String paramString) {
/*  298 */     this(
/*  299 */         readStream(
/*  300 */           ClassLoader.getSystemResourceAsStream(paramString.replace('.', '/') + ".class"), true));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static byte[] readStream(InputStream paramInputStream, boolean paramBoolean) {
/*  314 */     if (paramInputStream == null) {
/*  315 */       throw new IOException("Class not found");
/*      */     }
/*  317 */     int i = computeBufferSize(paramInputStream); try {
/*  318 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*      */     finally {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  332 */       if (paramBoolean) {
/*  333 */         paramInputStream.close();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int computeBufferSize(InputStream paramInputStream) {
/*      */     int i;
/*  345 */     if ((i = paramInputStream.available()) < 256) {
/*  346 */       return 4096;
/*      */     }
/*  348 */     return Math.min(i, 1048576);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getAccess() {
/*  363 */     return readUnsignedShort(this.header);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getClassName() {
/*  374 */     return readClass(this.header + 2, new char[this.maxStringLength]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSuperName() {
/*  386 */     return readClass(this.header + 4, new char[this.maxStringLength]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getInterfaces() {
/*  398 */     int i = this.header + 6;
/*      */     int j;
/*  400 */     String[] arrayOfString = new String[j = readUnsignedShort(i)];
/*  401 */     if (j > 0) {
/*  402 */       char[] arrayOfChar = new char[this.maxStringLength];
/*  403 */       for (byte b = 0; b < j; b++) {
/*  404 */         i += 2;
/*  405 */         arrayOfString[b] = readClass(i, arrayOfChar);
/*      */       } 
/*      */     } 
/*  408 */     return arrayOfString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void accept(ClassVisitor paramClassVisitor, int paramInt) {
/*  424 */     accept(paramClassVisitor, new Attribute[0], paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void accept(ClassVisitor paramClassVisitor, Attribute[] paramArrayOfAttribute, int paramInt) {
/*      */     Context context;
/*  446 */     (context = new Context()).a = paramArrayOfAttribute;
/*  447 */     context.b = paramInt;
/*  448 */     context.c = new char[this.maxStringLength];
/*      */ 
/*      */     
/*  451 */     char[] arrayOfChar = context.c;
/*  452 */     int i = this.header;
/*  453 */     int j = readUnsignedShort(i);
/*  454 */     String str1 = readClass(i + 2, arrayOfChar);
/*  455 */     String str2 = readClass(i + 4, arrayOfChar);
/*  456 */     String[] arrayOfString = new String[readUnsignedShort(i + 6)];
/*  457 */     i += 8; int k;
/*  458 */     for (k = 0; k < arrayOfString.length; k++) {
/*  459 */       arrayOfString[k] = readClass(i, arrayOfChar);
/*  460 */       i += 2;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  466 */     k = 0;
/*      */     
/*  468 */     int m = 0;
/*      */     
/*  470 */     String str3 = null;
/*      */     
/*  472 */     String str4 = null;
/*      */     
/*  474 */     String str5 = null;
/*      */     
/*  476 */     int n = 0;
/*      */     
/*  478 */     int i1 = 0;
/*      */     
/*  480 */     int i2 = 0;
/*      */     
/*  482 */     int i3 = 0;
/*      */     
/*  484 */     int i4 = 0;
/*      */     
/*  486 */     int i5 = 0;
/*      */     
/*  488 */     String str6 = null;
/*      */     
/*  490 */     String str7 = null;
/*      */     
/*  492 */     int i6 = 0;
/*      */     
/*  494 */     int i7 = 0;
/*      */     
/*  496 */     int i8 = 0;
/*      */ 
/*      */     
/*  499 */     Attribute attribute = null;
/*      */     
/*  501 */     int i9 = a(); int i10;
/*  502 */     for (i10 = readUnsignedShort(i9 - 2); i10 > 0; i10--) {
/*      */       
/*  504 */       String str = readUTF8(i9, arrayOfChar);
/*  505 */       int i12 = readInt(i9 + 2);
/*  506 */       i9 += 6;
/*      */ 
/*      */       
/*  509 */       if ("SourceFile".equals(str)) {
/*  510 */         str4 = readUTF8(i9, arrayOfChar);
/*  511 */       } else if ("InnerClasses".equals(str)) {
/*  512 */         k = i9;
/*  513 */       } else if ("EnclosingMethod".equals(str)) {
/*  514 */         m = i9;
/*  515 */       } else if ("NestHost".equals(str)) {
/*  516 */         str7 = readClass(i9, arrayOfChar);
/*  517 */       } else if ("NestMembers".equals(str)) {
/*  518 */         i6 = i9;
/*  519 */       } else if ("PermittedSubclasses".equals(str)) {
/*  520 */         i7 = i9;
/*  521 */       } else if ("Signature".equals(str)) {
/*  522 */         str3 = readUTF8(i9, arrayOfChar);
/*  523 */       } else if ("RuntimeVisibleAnnotations".equals(str)) {
/*  524 */         n = i9;
/*  525 */       } else if ("RuntimeVisibleTypeAnnotations".equals(str)) {
/*  526 */         i2 = i9;
/*  527 */       } else if ("Deprecated".equals(str)) {
/*  528 */         j |= 0x20000;
/*  529 */       } else if ("Synthetic".equals(str)) {
/*  530 */         j |= 0x1000;
/*  531 */       } else if ("SourceDebugExtension".equals(str)) {
/*  532 */         if (i12 > this.a.length - i9) {
/*  533 */           throw new IllegalArgumentException();
/*      */         }
/*      */         
/*  536 */         str5 = readUtf(i9, i12, new char[i12]);
/*  537 */       } else if ("RuntimeInvisibleAnnotations".equals(str)) {
/*  538 */         i1 = i9;
/*  539 */       } else if ("RuntimeInvisibleTypeAnnotations".equals(str)) {
/*  540 */         i3 = i9;
/*  541 */       } else if ("Record".equals(str)) {
/*  542 */         i8 = i9;
/*  543 */         j |= 0x10000;
/*  544 */       } else if ("Module".equals(str)) {
/*  545 */         i4 = i9;
/*  546 */       } else if ("ModuleMainClass".equals(str)) {
/*  547 */         str6 = readClass(i9, arrayOfChar);
/*  548 */       } else if ("ModulePackages".equals(str)) {
/*  549 */         i5 = i9;
/*  550 */       } else if (!"BootstrapMethods".equals(str)) {
/*      */         Attribute attribute1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  561 */         (attribute1 = readAttribute(paramArrayOfAttribute, str, i9, i12, arrayOfChar, -1, null)).a = attribute;
/*  562 */         attribute = attribute1;
/*      */       } 
/*  564 */       i9 += i12;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  569 */     paramClassVisitor.visit(
/*  570 */         readInt(this.cpInfoOffsets[1] - 7), j, str1, str3, str2, arrayOfString);
/*      */ 
/*      */     
/*  573 */     if ((paramInt & 0x2) == 0 && (str4 != null || str5 != null))
/*      */     {
/*  575 */       paramClassVisitor.visitSource(str4, str5);
/*      */     }
/*      */ 
/*      */     
/*  579 */     if (i4 != 0) {
/*  580 */       readModuleAttributes(paramClassVisitor, context, i4, i5, str6);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  585 */     if (str7 != null) {
/*  586 */       paramClassVisitor.visitNestHost(str7);
/*      */     }
/*      */ 
/*      */     
/*  590 */     if (m != 0) {
/*  591 */       String str8 = readClass(m, arrayOfChar);
/*      */       int i12;
/*  593 */       String str10 = ((i12 = readUnsignedShort(m + 2)) == 0) ? null : readUTF8(this.cpInfoOffsets[i12], arrayOfChar);
/*  594 */       String str9 = (i12 == 0) ? null : readUTF8(this.cpInfoOffsets[i12] + 2, arrayOfChar);
/*  595 */       paramClassVisitor.visitOuterClass(str8, str10, str9);
/*      */     } 
/*      */ 
/*      */     
/*  599 */     if (n != 0) {
/*  600 */       i10 = readUnsignedShort(n);
/*  601 */       int i12 = n + 2;
/*  602 */       while (i10-- > 0) {
/*      */         
/*  604 */         String str = readUTF8(i12, arrayOfChar);
/*  605 */         i12 += 2;
/*      */ 
/*      */         
/*  608 */         i12 = readElementValues(paramClassVisitor
/*  609 */             .visitAnnotation(str, true), i12, true, arrayOfChar);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  617 */     if (i1 != 0) {
/*  618 */       i10 = readUnsignedShort(i1);
/*  619 */       int i12 = i1 + 2;
/*  620 */       while (i10-- > 0) {
/*      */         
/*  622 */         String str = readUTF8(i12, arrayOfChar);
/*  623 */         i12 += 2;
/*      */ 
/*      */         
/*  626 */         i12 = readElementValues(paramClassVisitor
/*  627 */             .visitAnnotation(str, false), i12, true, arrayOfChar);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  635 */     if (i2 != 0) {
/*  636 */       i10 = readUnsignedShort(i2);
/*  637 */       int i12 = i2 + 2;
/*  638 */       while (i10-- > 0) {
/*      */         
/*  640 */         i12 = readTypeAnnotationTarget(context, i12);
/*      */         
/*  642 */         String str = readUTF8(i12, arrayOfChar);
/*  643 */         i12 += 2;
/*      */ 
/*      */         
/*  646 */         i12 = readElementValues(paramClassVisitor
/*  647 */             .visitTypeAnnotation(context.h, context.i, str, true), i12, true, arrayOfChar);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  659 */     if (i3 != 0) {
/*  660 */       i10 = readUnsignedShort(i3);
/*  661 */       int i12 = i3 + 2;
/*  662 */       while (i10-- > 0) {
/*      */         
/*  664 */         i12 = readTypeAnnotationTarget(context, i12);
/*      */         
/*  666 */         String str = readUTF8(i12, arrayOfChar);
/*  667 */         i12 += 2;
/*      */ 
/*      */         
/*  670 */         i12 = readElementValues(paramClassVisitor
/*  671 */             .visitTypeAnnotation(context.h, context.i, str, false), i12, true, arrayOfChar);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  683 */     while (attribute != null) {
/*      */       
/*  685 */       Attribute attribute1 = attribute.a;
/*  686 */       attribute.a = null;
/*  687 */       paramClassVisitor.visitAttribute(attribute);
/*  688 */       attribute = attribute1;
/*      */     } 
/*      */ 
/*      */     
/*  692 */     if (i6 != 0) {
/*  693 */       i10 = readUnsignedShort(i6);
/*  694 */       int i12 = i6 + 2;
/*  695 */       while (i10-- > 0) {
/*  696 */         paramClassVisitor.visitNestMember(readClass(i12, arrayOfChar));
/*  697 */         i12 += 2;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  702 */     if (i7 != 0) {
/*  703 */       i10 = readUnsignedShort(i7);
/*  704 */       int i12 = i7 + 2;
/*  705 */       while (i10-- > 0) {
/*  706 */         paramClassVisitor.visitPermittedSubclass(
/*  707 */             readClass(i12, arrayOfChar));
/*  708 */         i12 += 2;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  713 */     if (k != 0) {
/*  714 */       i10 = readUnsignedShort(k);
/*  715 */       int i12 = k + 2;
/*  716 */       while (i10-- > 0) {
/*  717 */         paramClassVisitor.visitInnerClass(
/*  718 */             readClass(i12, arrayOfChar), 
/*  719 */             readClass(i12 + 2, arrayOfChar), 
/*  720 */             readUTF8(i12 + 4, arrayOfChar), 
/*  721 */             readUnsignedShort(i12 + 6));
/*  722 */         i12 += 8;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  727 */     if (i8 != 0) {
/*  728 */       i10 = readUnsignedShort(i8);
/*  729 */       i8 += 2;
/*  730 */       while (i10-- > 0) {
/*  731 */         i8 = readRecordComponent(paramClassVisitor, context, i8);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  736 */     i10 = readUnsignedShort(i);
/*  737 */     i += 2;
/*  738 */     while (i10-- > 0) {
/*  739 */       i = readField(paramClassVisitor, context, i);
/*      */     }
/*  741 */     int i11 = readUnsignedShort(i);
/*  742 */     i += 2;
/*  743 */     while (i11-- > 0) {
/*  744 */       i = readMethod(paramClassVisitor, context, i);
/*      */     }
/*      */ 
/*      */     
/*  748 */     paramClassVisitor.visitEnd();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void readModuleAttributes(ClassVisitor paramClassVisitor, Context paramContext, int paramInt1, int paramInt2, String paramString) {
/*  773 */     char[] arrayOfChar = paramContext.c;
/*      */ 
/*      */     
/*  776 */     int k = paramInt1;
/*  777 */     String str2 = readModule(paramInt1, arrayOfChar);
/*  778 */     int n = readUnsignedShort(paramInt1 + 2);
/*  779 */     String str1 = readUTF8(paramInt1 + 4, arrayOfChar);
/*  780 */     k += 6;
/*      */     ModuleVisitor moduleVisitor;
/*  782 */     if ((moduleVisitor = paramClassVisitor.visitModule(str2, n, str1)) == null) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  787 */     if (paramString != null) {
/*  788 */       moduleVisitor.visitMainClass(paramString);
/*      */     }
/*      */ 
/*      */     
/*  792 */     if (paramInt2 != 0) {
/*  793 */       int i1 = readUnsignedShort(paramInt2);
/*  794 */       paramInt2 += 2;
/*  795 */       while (i1-- > 0) {
/*  796 */         moduleVisitor.visitPackage(readPackage(paramInt2, arrayOfChar));
/*  797 */         paramInt2 += 2;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  802 */     int i = readUnsignedShort(k);
/*  803 */     k += 2;
/*  804 */     while (i-- > 0) {
/*      */       
/*  806 */       String str = readModule(k, arrayOfChar);
/*  807 */       int i1 = readUnsignedShort(k + 2);
/*  808 */       str2 = readUTF8(k + 4, arrayOfChar);
/*  809 */       k += 6;
/*  810 */       moduleVisitor.visitRequire(str, i1, str2);
/*      */     } 
/*      */ 
/*      */     
/*  814 */     paramInt2 = readUnsignedShort(k);
/*  815 */     k += 2;
/*  816 */     while (paramInt2-- > 0) {
/*      */ 
/*      */       
/*  819 */       paramString = readPackage(k, arrayOfChar);
/*  820 */       int i1 = readUnsignedShort(k + 2);
/*  821 */       i = readUnsignedShort(k + 4);
/*  822 */       k += 6;
/*  823 */       String[] arrayOfString = null;
/*  824 */       if (i != 0) {
/*  825 */         arrayOfString = new String[i];
/*  826 */         for (byte b = 0; b < i; b++) {
/*  827 */           arrayOfString[b] = readModule(k, arrayOfChar);
/*  828 */           k += 2;
/*      */         } 
/*      */       } 
/*  831 */       moduleVisitor.visitExport(paramString, i1, arrayOfString);
/*      */     } 
/*      */ 
/*      */     
/*  835 */     int j = readUnsignedShort(k);
/*  836 */     k += 2;
/*  837 */     while (j-- > 0) {
/*      */       
/*  839 */       str2 = readPackage(k, arrayOfChar);
/*  840 */       i = readUnsignedShort(k + 2);
/*  841 */       n = readUnsignedShort(k + 4);
/*  842 */       k += 6;
/*  843 */       String[] arrayOfString = null;
/*  844 */       if (n != 0) {
/*  845 */         arrayOfString = new String[n];
/*  846 */         for (paramInt2 = 0; paramInt2 < n; paramInt2++) {
/*  847 */           arrayOfString[paramInt2] = readModule(k, arrayOfChar);
/*  848 */           k += 2;
/*      */         } 
/*      */       } 
/*  851 */       moduleVisitor.visitOpen(str2, i, arrayOfString);
/*      */     } 
/*      */ 
/*      */     
/*  855 */     int m = readUnsignedShort(k);
/*  856 */     k += 2;
/*  857 */     while (m-- > 0) {
/*  858 */       moduleVisitor.visitUse(readClass(k, arrayOfChar));
/*  859 */       k += 2;
/*      */     } 
/*      */ 
/*      */     
/*  863 */     i = readUnsignedShort(k);
/*  864 */     k += 2;
/*  865 */     while (i-- > 0) {
/*      */       
/*  867 */       String str = readClass(k, arrayOfChar);
/*  868 */       int i1 = readUnsignedShort(k + 2);
/*  869 */       k += 4;
/*  870 */       String[] arrayOfString = new String[i1];
/*  871 */       for (j = 0; j < i1; j++) {
/*  872 */         arrayOfString[j] = readClass(k, arrayOfChar);
/*  873 */         k += 2;
/*      */       } 
/*  875 */       moduleVisitor.visitProvide(str, arrayOfString);
/*      */     } 
/*      */ 
/*      */     
/*  879 */     moduleVisitor.visitEnd();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int readRecordComponent(ClassVisitor paramClassVisitor, Context paramContext, int paramInt) {
/*  892 */     char[] arrayOfChar = paramContext.c;
/*      */     
/*  894 */     int i = paramInt;
/*  895 */     String str2 = readUTF8(paramInt, arrayOfChar);
/*  896 */     String str1 = readUTF8(paramInt + 2, arrayOfChar);
/*  897 */     i += 4;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  904 */     String str3 = null;
/*      */     
/*  906 */     int j = 0;
/*      */     
/*  908 */     int k = 0;
/*      */     
/*  910 */     int m = 0;
/*      */     
/*  912 */     int n = 0;
/*      */ 
/*      */     
/*  915 */     Attribute attribute = null;
/*      */     
/*  917 */     int i1 = readUnsignedShort(i);
/*  918 */     i += 2;
/*  919 */     while (i1-- > 0) {
/*      */       
/*  921 */       String str = readUTF8(i, arrayOfChar);
/*  922 */       int i2 = readInt(i + 2);
/*  923 */       i += 6;
/*      */ 
/*      */       
/*  926 */       if ("Signature".equals(str)) {
/*  927 */         str3 = readUTF8(i, arrayOfChar);
/*  928 */       } else if ("RuntimeVisibleAnnotations".equals(str)) {
/*  929 */         j = i;
/*  930 */       } else if ("RuntimeVisibleTypeAnnotations".equals(str)) {
/*  931 */         m = i;
/*  932 */       } else if ("RuntimeInvisibleAnnotations".equals(str)) {
/*  933 */         k = i;
/*  934 */       } else if ("RuntimeInvisibleTypeAnnotations".equals(str)) {
/*  935 */         n = i;
/*      */       } else {
/*      */         Attribute attribute1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  946 */         (attribute1 = readAttribute(paramContext.a, str, i, i2, arrayOfChar, -1, null)).a = attribute;
/*  947 */         attribute = attribute1;
/*      */       } 
/*  949 */       i += i2;
/*      */     } 
/*      */     
/*      */     RecordComponentVisitor recordComponentVisitor;
/*      */     
/*  954 */     if ((recordComponentVisitor = paramClassVisitor.visitRecordComponent(str2, str1, str3)) == null) {
/*  955 */       return i;
/*      */     }
/*      */ 
/*      */     
/*  959 */     if (j != 0) {
/*  960 */       int i2 = readUnsignedShort(j);
/*  961 */       int i3 = j + 2;
/*  962 */       while (i2-- > 0) {
/*      */         
/*  964 */         String str = readUTF8(i3, arrayOfChar);
/*  965 */         i3 += 2;
/*      */ 
/*      */         
/*  968 */         i3 = readElementValues(recordComponentVisitor
/*  969 */             .visitAnnotation(str, true), i3, true, arrayOfChar);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  977 */     if (k != 0) {
/*  978 */       int i2 = readUnsignedShort(k);
/*  979 */       int i3 = k + 2;
/*  980 */       while (i2-- > 0) {
/*      */         
/*  982 */         String str = readUTF8(i3, arrayOfChar);
/*  983 */         i3 += 2;
/*      */ 
/*      */         
/*  986 */         i3 = readElementValues(recordComponentVisitor
/*  987 */             .visitAnnotation(str, false), i3, true, arrayOfChar);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  995 */     if (m != 0) {
/*  996 */       int i2 = readUnsignedShort(m);
/*  997 */       int i3 = m + 2;
/*  998 */       while (i2-- > 0) {
/*      */         
/* 1000 */         i3 = readTypeAnnotationTarget(paramContext, i3);
/*      */         
/* 1002 */         String str = readUTF8(i3, arrayOfChar);
/* 1003 */         i3 += 2;
/*      */ 
/*      */         
/* 1006 */         i3 = readElementValues(recordComponentVisitor
/* 1007 */             .visitTypeAnnotation(paramContext.h, paramContext.i, str, true), i3, true, arrayOfChar);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1019 */     if (n != 0) {
/* 1020 */       int i2 = readUnsignedShort(n);
/* 1021 */       int i3 = n + 2;
/* 1022 */       while (i2-- > 0) {
/*      */         
/* 1024 */         i3 = readTypeAnnotationTarget(paramContext, i3);
/*      */         
/* 1026 */         String str = readUTF8(i3, arrayOfChar);
/* 1027 */         i3 += 2;
/*      */ 
/*      */         
/* 1030 */         i3 = readElementValues(recordComponentVisitor
/* 1031 */             .visitTypeAnnotation(paramContext.h, paramContext.i, str, false), i3, true, arrayOfChar);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1043 */     while (attribute != null) {
/*      */       
/* 1045 */       Attribute attribute1 = attribute.a;
/* 1046 */       attribute.a = null;
/* 1047 */       recordComponentVisitor.visitAttribute(attribute);
/* 1048 */       attribute = attribute1;
/*      */     } 
/*      */ 
/*      */     
/* 1052 */     recordComponentVisitor.visitEnd();
/* 1053 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int readField(ClassVisitor paramClassVisitor, Context paramContext, int paramInt) {
/* 1066 */     char[] arrayOfChar = paramContext.c;
/*      */ 
/*      */     
/* 1069 */     int i = paramInt;
/* 1070 */     int j = readUnsignedShort(paramInt);
/* 1071 */     String str2 = readUTF8(paramInt + 2, arrayOfChar);
/* 1072 */     String str1 = readUTF8(paramInt + 4, arrayOfChar);
/* 1073 */     i += 6;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1078 */     Object object = null;
/*      */     
/* 1080 */     String str3 = null;
/*      */     
/* 1082 */     int k = 0;
/*      */     
/* 1084 */     int m = 0;
/*      */     
/* 1086 */     int n = 0;
/*      */     
/* 1088 */     int i1 = 0;
/*      */ 
/*      */     
/* 1091 */     Attribute attribute = null;
/*      */     
/* 1093 */     int i2 = readUnsignedShort(i);
/* 1094 */     i += 2;
/* 1095 */     while (i2-- > 0) {
/*      */       
/* 1097 */       String str = readUTF8(i, arrayOfChar);
/* 1098 */       int i3 = readInt(i + 2);
/* 1099 */       i += 6;
/*      */ 
/*      */       
/* 1102 */       if ("ConstantValue".equals(str)) {
/*      */         int i4;
/* 1104 */         object = ((i4 = readUnsignedShort(i)) == 0) ? null : readConst(i4, arrayOfChar);
/* 1105 */       } else if ("Signature".equals(str)) {
/* 1106 */         str3 = readUTF8(i, arrayOfChar);
/* 1107 */       } else if ("Deprecated".equals(str)) {
/* 1108 */         j |= 0x20000;
/* 1109 */       } else if ("Synthetic".equals(str)) {
/* 1110 */         j |= 0x1000;
/* 1111 */       } else if ("RuntimeVisibleAnnotations".equals(str)) {
/* 1112 */         k = i;
/* 1113 */       } else if ("RuntimeVisibleTypeAnnotations".equals(str)) {
/* 1114 */         n = i;
/* 1115 */       } else if ("RuntimeInvisibleAnnotations".equals(str)) {
/* 1116 */         m = i;
/* 1117 */       } else if ("RuntimeInvisibleTypeAnnotations".equals(str)) {
/* 1118 */         i1 = i;
/*      */       } else {
/*      */         Attribute attribute1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1129 */         (attribute1 = readAttribute(paramContext.a, str, i, i3, arrayOfChar, -1, null)).a = attribute;
/* 1130 */         attribute = attribute1;
/*      */       } 
/* 1132 */       i += i3;
/*      */     } 
/*      */ 
/*      */     
/*      */     FieldVisitor fieldVisitor;
/*      */     
/* 1138 */     if ((fieldVisitor = paramClassVisitor.visitField(j, str2, str1, str3, object)) == null) {
/* 1139 */       return i;
/*      */     }
/*      */ 
/*      */     
/* 1143 */     if (k != 0) {
/* 1144 */       int i3 = readUnsignedShort(k);
/* 1145 */       int i4 = k + 2;
/* 1146 */       while (i3-- > 0) {
/*      */         
/* 1148 */         String str = readUTF8(i4, arrayOfChar);
/* 1149 */         i4 += 2;
/*      */ 
/*      */         
/* 1152 */         i4 = readElementValues(fieldVisitor
/* 1153 */             .visitAnnotation(str, true), i4, true, arrayOfChar);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1161 */     if (m != 0) {
/* 1162 */       int i3 = readUnsignedShort(m);
/* 1163 */       int i4 = m + 2;
/* 1164 */       while (i3-- > 0) {
/*      */         
/* 1166 */         String str = readUTF8(i4, arrayOfChar);
/* 1167 */         i4 += 2;
/*      */ 
/*      */         
/* 1170 */         i4 = readElementValues(fieldVisitor
/* 1171 */             .visitAnnotation(str, false), i4, true, arrayOfChar);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1179 */     if (n != 0) {
/* 1180 */       int i3 = readUnsignedShort(n);
/* 1181 */       int i4 = n + 2;
/* 1182 */       while (i3-- > 0) {
/*      */         
/* 1184 */         i4 = readTypeAnnotationTarget(paramContext, i4);
/*      */         
/* 1186 */         String str = readUTF8(i4, arrayOfChar);
/* 1187 */         i4 += 2;
/*      */ 
/*      */         
/* 1190 */         i4 = readElementValues(fieldVisitor
/* 1191 */             .visitTypeAnnotation(paramContext.h, paramContext.i, str, true), i4, true, arrayOfChar);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1203 */     if (i1 != 0) {
/* 1204 */       int i3 = readUnsignedShort(i1);
/* 1205 */       int i4 = i1 + 2;
/* 1206 */       while (i3-- > 0) {
/*      */         
/* 1208 */         i4 = readTypeAnnotationTarget(paramContext, i4);
/*      */         
/* 1210 */         String str = readUTF8(i4, arrayOfChar);
/* 1211 */         i4 += 2;
/*      */ 
/*      */         
/* 1214 */         i4 = readElementValues(fieldVisitor
/* 1215 */             .visitTypeAnnotation(paramContext.h, paramContext.i, str, false), i4, true, arrayOfChar);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1227 */     while (attribute != null) {
/*      */       
/* 1229 */       Attribute attribute1 = attribute.a;
/* 1230 */       attribute.a = null;
/* 1231 */       fieldVisitor.visitAttribute(attribute);
/* 1232 */       attribute = attribute1;
/*      */     } 
/*      */ 
/*      */     
/* 1236 */     fieldVisitor.visitEnd();
/* 1237 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int readMethod(ClassVisitor paramClassVisitor, Context paramContext, int paramInt) {
/* 1250 */     char[] arrayOfChar = paramContext.c;
/*      */ 
/*      */     
/* 1253 */     int i = paramInt;
/* 1254 */     paramContext.d = readUnsignedShort(paramInt);
/* 1255 */     paramContext.e = readUTF8(paramInt + 2, arrayOfChar);
/* 1256 */     paramContext.f = readUTF8(paramInt + 4, arrayOfChar);
/* 1257 */     i += 6;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1262 */     int j = 0;
/*      */     
/* 1264 */     int k = 0;
/*      */     
/* 1266 */     String[] arrayOfString = null;
/*      */     
/* 1268 */     boolean bool = false;
/*      */     
/* 1270 */     int m = 0;
/*      */     
/* 1272 */     int n = 0;
/*      */     
/* 1274 */     int i1 = 0;
/*      */     
/* 1276 */     int i2 = 0;
/*      */     
/* 1278 */     int i3 = 0;
/*      */     
/* 1280 */     int i4 = 0;
/*      */     
/* 1282 */     int i5 = 0;
/*      */     
/* 1284 */     int i6 = 0;
/*      */     
/* 1286 */     int i7 = 0;
/*      */ 
/*      */     
/* 1289 */     Attribute attribute = null;
/*      */     
/* 1291 */     int i8 = readUnsignedShort(i);
/* 1292 */     i += 2;
/* 1293 */     while (i8-- > 0) {
/*      */       
/* 1295 */       String str = readUTF8(i, arrayOfChar);
/* 1296 */       int i9 = readInt(i + 2);
/* 1297 */       i += 6;
/*      */ 
/*      */       
/* 1300 */       if ("Code".equals(str)) {
/* 1301 */         if ((paramContext.b & 0x1) == 0) {
/* 1302 */           j = i;
/*      */         }
/* 1304 */       } else if ("Exceptions".equals(str)) {
/* 1305 */         k = i;
/* 1306 */         arrayOfString = new String[readUnsignedShort(k)];
/* 1307 */         int i10 = k + 2;
/* 1308 */         for (byte b = 0; b < arrayOfString.length; b++) {
/* 1309 */           arrayOfString[b] = readClass(i10, arrayOfChar);
/* 1310 */           i10 += 2;
/*      */         } 
/* 1312 */       } else if ("Signature".equals(str)) {
/* 1313 */         m = readUnsignedShort(i);
/* 1314 */       } else if ("Deprecated".equals(str)) {
/* 1315 */         paramContext.d |= 0x20000;
/* 1316 */       } else if ("RuntimeVisibleAnnotations".equals(str)) {
/* 1317 */         n = i;
/* 1318 */       } else if ("RuntimeVisibleTypeAnnotations".equals(str)) {
/* 1319 */         i4 = i;
/* 1320 */       } else if ("AnnotationDefault".equals(str)) {
/* 1321 */         i6 = i;
/* 1322 */       } else if ("Synthetic".equals(str)) {
/* 1323 */         bool = true;
/* 1324 */         paramContext.d |= 0x1000;
/* 1325 */       } else if ("RuntimeInvisibleAnnotations".equals(str)) {
/* 1326 */         i1 = i;
/* 1327 */       } else if ("RuntimeInvisibleTypeAnnotations".equals(str)) {
/* 1328 */         i5 = i;
/* 1329 */       } else if ("RuntimeVisibleParameterAnnotations".equals(str)) {
/* 1330 */         i2 = i;
/* 1331 */       } else if ("RuntimeInvisibleParameterAnnotations".equals(str)) {
/* 1332 */         i3 = i;
/* 1333 */       } else if ("MethodParameters".equals(str)) {
/* 1334 */         i7 = i;
/*      */       } else {
/*      */         Attribute attribute1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1345 */         (attribute1 = readAttribute(paramContext.a, str, i, i9, arrayOfChar, -1, null)).a = attribute;
/* 1346 */         attribute = attribute1;
/*      */       } 
/* 1348 */       i += i9;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     MethodVisitor methodVisitor;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1359 */     if ((methodVisitor = paramClassVisitor.visitMethod(paramContext.d, paramContext.e, paramContext.f, (m == 0) ? null : a(m, arrayOfChar), arrayOfString)) == null) {
/* 1360 */       return i;
/*      */     }
/*      */ 
/*      */     
/*      */     MethodWriter methodWriter;
/*      */ 
/*      */     
/* 1367 */     if (methodVisitor instanceof MethodWriter && (
/*      */       
/* 1369 */       methodWriter = (MethodWriter)methodVisitor).a(this, bool, ((paramContext.d & 0x20000) != 0), 
/*      */ 
/*      */ 
/*      */         
/* 1373 */         readUnsignedShort(paramInt + 4), m, k)) {
/*      */ 
/*      */       
/* 1376 */       methodWriter.b(paramInt, i - paramInt);
/* 1377 */       return i;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1382 */     if (i7 != 0 && (paramContext.b & 0x2) == 0) {
/* 1383 */       int i9 = readByte(i7);
/* 1384 */       int i10 = i7 + 1;
/* 1385 */       while (i9-- > 0) {
/*      */         
/* 1387 */         methodVisitor.visitParameter(
/* 1388 */             readUTF8(i10, arrayOfChar), 
/* 1389 */             readUnsignedShort(i10 + 2));
/* 1390 */         i10 += 4;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1395 */     if (i6 != 0) {
/* 1396 */       AnnotationVisitor annotationVisitor = methodVisitor.visitAnnotationDefault();
/* 1397 */       readElementValue(annotationVisitor, i6, null, arrayOfChar);
/* 1398 */       if (annotationVisitor != null) {
/* 1399 */         annotationVisitor.visitEnd();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1404 */     if (n != 0) {
/* 1405 */       int i9 = readUnsignedShort(n);
/* 1406 */       int i10 = n + 2;
/* 1407 */       while (i9-- > 0) {
/*      */         
/* 1409 */         String str = readUTF8(i10, arrayOfChar);
/* 1410 */         i10 += 2;
/*      */ 
/*      */         
/* 1413 */         i10 = readElementValues(methodVisitor
/* 1414 */             .visitAnnotation(str, true), i10, true, arrayOfChar);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1422 */     if (i1 != 0) {
/* 1423 */       int i9 = readUnsignedShort(i1);
/* 1424 */       int i10 = i1 + 2;
/* 1425 */       while (i9-- > 0) {
/*      */         
/* 1427 */         String str = readUTF8(i10, arrayOfChar);
/* 1428 */         i10 += 2;
/*      */ 
/*      */         
/* 1431 */         i10 = readElementValues(methodVisitor
/* 1432 */             .visitAnnotation(str, false), i10, true, arrayOfChar);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1440 */     if (i4 != 0) {
/* 1441 */       int i9 = readUnsignedShort(i4);
/* 1442 */       int i10 = i4 + 2;
/* 1443 */       while (i9-- > 0) {
/*      */         
/* 1445 */         i10 = readTypeAnnotationTarget(paramContext, i10);
/*      */         
/* 1447 */         String str = readUTF8(i10, arrayOfChar);
/* 1448 */         i10 += 2;
/*      */ 
/*      */         
/* 1451 */         i10 = readElementValues(methodVisitor
/* 1452 */             .visitTypeAnnotation(paramContext.h, paramContext.i, str, true), i10, true, arrayOfChar);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1464 */     if (i5 != 0) {
/* 1465 */       int i9 = readUnsignedShort(i5);
/* 1466 */       int i10 = i5 + 2;
/* 1467 */       while (i9-- > 0) {
/*      */         
/* 1469 */         i10 = readTypeAnnotationTarget(paramContext, i10);
/*      */         
/* 1471 */         String str = readUTF8(i10, arrayOfChar);
/* 1472 */         i10 += 2;
/*      */ 
/*      */         
/* 1475 */         i10 = readElementValues(methodVisitor
/* 1476 */             .visitTypeAnnotation(paramContext.h, paramContext.i, str, false), i10, true, arrayOfChar);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1488 */     if (i2 != 0) {
/* 1489 */       readParameterAnnotations(methodVisitor, paramContext, i2, true);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1494 */     if (i3 != 0) {
/* 1495 */       readParameterAnnotations(methodVisitor, paramContext, i3, false);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1503 */     while (attribute != null) {
/*      */       
/* 1505 */       Attribute attribute1 = attribute.a;
/* 1506 */       attribute.a = null;
/* 1507 */       methodVisitor.visitAttribute(attribute);
/* 1508 */       attribute = attribute1;
/*      */     } 
/*      */ 
/*      */     
/* 1512 */     if (j != 0) {
/* 1513 */       methodVisitor.visitCode();
/* 1514 */       readCode(methodVisitor, paramContext, j);
/*      */     } 
/*      */ 
/*      */     
/* 1518 */     methodVisitor.visitEnd();
/* 1519 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void readCode(MethodVisitor paramMethodVisitor, Context paramContext, int paramInt) {
/* 1536 */     int i = paramInt;
/*      */ 
/*      */     
/* 1539 */     byte[] arrayOfByte = this.a;
/* 1540 */     char[] arrayOfChar = paramContext.c;
/* 1541 */     int j = readUnsignedShort(paramInt);
/* 1542 */     int k = readUnsignedShort(paramInt + 2);
/* 1543 */     int m = readInt(paramInt + 4);
/* 1544 */     i += 8;
/* 1545 */     if (m > this.a.length - i) {
/* 1546 */       throw new IllegalArgumentException();
/*      */     }
/*      */ 
/*      */     
/* 1550 */     int n = i;
/* 1551 */     int i1 = i + m;
/* 1552 */     Label[] arrayOfLabel = paramContext.g = new Label[m + 1];
/* 1553 */     while (i < i1) {
/* 1554 */       int i11, i12, i9 = i - n;
/*      */       int i10;
/* 1556 */       switch (i10 = arrayOfByte[i] & 0xFF) {
/*      */         case 0:
/*      */         case 1:
/*      */         case 2:
/*      */         case 3:
/*      */         case 4:
/*      */         case 5:
/*      */         case 6:
/*      */         case 7:
/*      */         case 8:
/*      */         case 9:
/*      */         case 10:
/*      */         case 11:
/*      */         case 12:
/*      */         case 13:
/*      */         case 14:
/*      */         case 15:
/*      */         case 26:
/*      */         case 27:
/*      */         case 28:
/*      */         case 29:
/*      */         case 30:
/*      */         case 31:
/*      */         case 32:
/*      */         case 33:
/*      */         case 34:
/*      */         case 35:
/*      */         case 36:
/*      */         case 37:
/*      */         case 38:
/*      */         case 39:
/*      */         case 40:
/*      */         case 41:
/*      */         case 42:
/*      */         case 43:
/*      */         case 44:
/*      */         case 45:
/*      */         case 46:
/*      */         case 47:
/*      */         case 48:
/*      */         case 49:
/*      */         case 50:
/*      */         case 51:
/*      */         case 52:
/*      */         case 53:
/*      */         case 59:
/*      */         case 60:
/*      */         case 61:
/*      */         case 62:
/*      */         case 63:
/*      */         case 64:
/*      */         case 65:
/*      */         case 66:
/*      */         case 67:
/*      */         case 68:
/*      */         case 69:
/*      */         case 70:
/*      */         case 71:
/*      */         case 72:
/*      */         case 73:
/*      */         case 74:
/*      */         case 75:
/*      */         case 76:
/*      */         case 77:
/*      */         case 78:
/*      */         case 79:
/*      */         case 80:
/*      */         case 81:
/*      */         case 82:
/*      */         case 83:
/*      */         case 84:
/*      */         case 85:
/*      */         case 86:
/*      */         case 87:
/*      */         case 88:
/*      */         case 89:
/*      */         case 90:
/*      */         case 91:
/*      */         case 92:
/*      */         case 93:
/*      */         case 94:
/*      */         case 95:
/*      */         case 96:
/*      */         case 97:
/*      */         case 98:
/*      */         case 99:
/*      */         case 100:
/*      */         case 101:
/*      */         case 102:
/*      */         case 103:
/*      */         case 104:
/*      */         case 105:
/*      */         case 106:
/*      */         case 107:
/*      */         case 108:
/*      */         case 109:
/*      */         case 110:
/*      */         case 111:
/*      */         case 112:
/*      */         case 113:
/*      */         case 114:
/*      */         case 115:
/*      */         case 116:
/*      */         case 117:
/*      */         case 118:
/*      */         case 119:
/*      */         case 120:
/*      */         case 121:
/*      */         case 122:
/*      */         case 123:
/*      */         case 124:
/*      */         case 125:
/*      */         case 126:
/*      */         case 127:
/*      */         case 128:
/*      */         case 129:
/*      */         case 130:
/*      */         case 131:
/*      */         case 133:
/*      */         case 134:
/*      */         case 135:
/*      */         case 136:
/*      */         case 137:
/*      */         case 138:
/*      */         case 139:
/*      */         case 140:
/*      */         case 141:
/*      */         case 142:
/*      */         case 143:
/*      */         case 144:
/*      */         case 145:
/*      */         case 146:
/*      */         case 147:
/*      */         case 148:
/*      */         case 149:
/*      */         case 150:
/*      */         case 151:
/*      */         case 152:
/*      */         case 172:
/*      */         case 173:
/*      */         case 174:
/*      */         case 175:
/*      */         case 176:
/*      */         case 177:
/*      */         case 190:
/*      */         case 191:
/*      */         case 194:
/*      */         case 195:
/* 1704 */           i++;
/*      */           continue;
/*      */         case 153:
/*      */         case 154:
/*      */         case 155:
/*      */         case 156:
/*      */         case 157:
/*      */         case 158:
/*      */         case 159:
/*      */         case 160:
/*      */         case 161:
/*      */         case 162:
/*      */         case 163:
/*      */         case 164:
/*      */         case 165:
/*      */         case 166:
/*      */         case 167:
/*      */         case 168:
/*      */         case 198:
/*      */         case 199:
/* 1724 */           createLabel(i9 + readShort(i + 1), arrayOfLabel);
/* 1725 */           i += 3;
/*      */           continue;
/*      */         case 202:
/*      */         case 203:
/*      */         case 204:
/*      */         case 205:
/*      */         case 206:
/*      */         case 207:
/*      */         case 208:
/*      */         case 209:
/*      */         case 210:
/*      */         case 211:
/*      */         case 212:
/*      */         case 213:
/*      */         case 214:
/*      */         case 215:
/*      */         case 216:
/*      */         case 217:
/*      */         case 218:
/*      */         case 219:
/* 1745 */           createLabel(i9 + readUnsignedShort(i + 1), arrayOfLabel);
/* 1746 */           i += 3;
/*      */           continue;
/*      */         case 200:
/*      */         case 201:
/*      */         case 220:
/* 1751 */           createLabel(i9 + readInt(i + 1), arrayOfLabel);
/* 1752 */           i += 5;
/*      */           continue;
/*      */         case 196:
/* 1755 */           switch (arrayOfByte[i + 1] & 0xFF) {
/*      */             case 21:
/*      */             case 22:
/*      */             case 23:
/*      */             case 24:
/*      */             case 25:
/*      */             case 54:
/*      */             case 55:
/*      */             case 56:
/*      */             case 57:
/*      */             case 58:
/*      */             case 169:
/* 1767 */               i += 4;
/*      */               continue;
/*      */             case 132:
/* 1770 */               i += 6;
/*      */               continue;
/*      */           } 
/* 1773 */           throw new IllegalArgumentException();
/*      */ 
/*      */ 
/*      */         
/*      */         case 170:
/* 1778 */           i += 4 - (i9 & 0x3);
/*      */           
/* 1780 */           createLabel(i9 + readInt(i), arrayOfLabel);
/* 1781 */           i11 = readInt(i + 8) - readInt(i + 4) + 1;
/* 1782 */           i += 12;
/*      */           
/* 1784 */           while (i11-- > 0) {
/* 1785 */             createLabel(i9 + readInt(i), arrayOfLabel);
/* 1786 */             i += 4;
/*      */           } 
/*      */           continue;
/*      */         
/*      */         case 171:
/* 1791 */           i += 4 - (i9 & 0x3);
/*      */           
/* 1793 */           createLabel(i9 + readInt(i), arrayOfLabel);
/* 1794 */           i12 = readInt(i + 4);
/* 1795 */           i += 8;
/*      */           
/* 1797 */           while (i12-- > 0) {
/* 1798 */             createLabel(i9 + readInt(i + 4), arrayOfLabel);
/* 1799 */             i += 8;
/*      */           } 
/*      */           continue;
/*      */         case 16:
/*      */         case 18:
/*      */         case 21:
/*      */         case 22:
/*      */         case 23:
/*      */         case 24:
/*      */         case 25:
/*      */         case 54:
/*      */         case 55:
/*      */         case 56:
/*      */         case 57:
/*      */         case 58:
/*      */         case 169:
/*      */         case 188:
/* 1816 */           i += 2;
/*      */           continue;
/*      */         case 17:
/*      */         case 19:
/*      */         case 20:
/*      */         case 132:
/*      */         case 178:
/*      */         case 179:
/*      */         case 180:
/*      */         case 181:
/*      */         case 182:
/*      */         case 183:
/*      */         case 184:
/*      */         case 187:
/*      */         case 189:
/*      */         case 192:
/*      */         case 193:
/* 1833 */           i += 3;
/*      */           continue;
/*      */         case 185:
/*      */         case 186:
/* 1837 */           i += 5;
/*      */           continue;
/*      */         case 197:
/* 1840 */           i += 4;
/*      */           continue;
/*      */       } 
/* 1843 */       throw new IllegalArgumentException();
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1849 */     int i2 = readUnsignedShort(i);
/* 1850 */     i += 2;
/* 1851 */     while (i2-- > 0) {
/* 1852 */       Label label1 = createLabel(readUnsignedShort(i), arrayOfLabel);
/* 1853 */       Label label2 = createLabel(readUnsignedShort(i + 2), arrayOfLabel);
/* 1854 */       Label label3 = createLabel(readUnsignedShort(i + 4), arrayOfLabel);
/* 1855 */       String str = readUTF8(this.cpInfoOffsets[readUnsignedShort(i + 6)], arrayOfChar);
/* 1856 */       i += 8;
/* 1857 */       paramMethodVisitor.visitTryCatchBlock(label1, label2, label3, str);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1866 */     int i3 = 0;
/*      */     
/* 1868 */     int i4 = 0;
/*      */     
/* 1870 */     boolean bool1 = true;
/*      */     
/* 1872 */     int i5 = 0;
/*      */     
/* 1874 */     i2 = 0;
/*      */ 
/*      */     
/* 1877 */     int[] arrayOfInt1 = null;
/*      */ 
/*      */     
/* 1880 */     int[] arrayOfInt2 = null;
/*      */ 
/*      */     
/* 1883 */     Attribute attribute = null;
/*      */     
/* 1885 */     int i6 = readUnsignedShort(i);
/* 1886 */     i += 2;
/* 1887 */     while (i6-- > 0) {
/*      */       
/* 1889 */       String str = readUTF8(i, arrayOfChar);
/* 1890 */       int i9 = readInt(i + 2);
/* 1891 */       i += 6;
/* 1892 */       if ("LocalVariableTable".equals(str)) {
/* 1893 */         if ((paramContext.b & 0x2) == 0) {
/* 1894 */           i5 = i;
/*      */           
/* 1896 */           int i10 = i;
/* 1897 */           int i11 = readUnsignedShort(i10);
/* 1898 */           i10 += 2;
/* 1899 */           while (i11-- > 0) {
/* 1900 */             int i12 = readUnsignedShort(i10);
/* 1901 */             createDebugLabel(i12, arrayOfLabel);
/* 1902 */             int i13 = readUnsignedShort(i10 + 2);
/* 1903 */             createDebugLabel(i12 + i13, arrayOfLabel);
/*      */             
/* 1905 */             i10 += 10;
/*      */           } 
/*      */         } 
/* 1908 */       } else if ("LocalVariableTypeTable".equals(str)) {
/* 1909 */         i2 = i;
/*      */       
/*      */       }
/* 1912 */       else if ("LineNumberTable".equals(str)) {
/* 1913 */         if ((paramContext.b & 0x2) == 0) {
/*      */           
/* 1915 */           int i10 = i;
/* 1916 */           int i11 = readUnsignedShort(i10);
/* 1917 */           i10 += 2;
/* 1918 */           while (i11-- > 0) {
/* 1919 */             int i12 = readUnsignedShort(i10);
/* 1920 */             int i13 = readUnsignedShort(i10 + 2);
/* 1921 */             i10 += 4;
/* 1922 */             createDebugLabel(i12, arrayOfLabel);
/* 1923 */             arrayOfLabel[i12].a(i13);
/*      */           } 
/*      */         } 
/* 1926 */       } else if ("RuntimeVisibleTypeAnnotations".equals(str)) {
/*      */         
/* 1928 */         arrayOfInt1 = readTypeAnnotations(paramMethodVisitor, paramContext, i, true);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       }
/* 1935 */       else if ("RuntimeInvisibleTypeAnnotations".equals(str)) {
/*      */         
/* 1937 */         arrayOfInt2 = readTypeAnnotations(paramMethodVisitor, paramContext, i, false);
/*      */       }
/* 1939 */       else if ("StackMapTable".equals(str)) {
/* 1940 */         if ((paramContext.b & 0x4) == 0) {
/* 1941 */           i3 = i + 2;
/* 1942 */           i4 = i + i9;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       }
/* 1953 */       else if ("StackMap".equals(str)) {
/* 1954 */         if ((paramContext.b & 0x4) == 0) {
/* 1955 */           i3 = i + 2;
/* 1956 */           i4 = i + i9;
/* 1957 */           bool1 = false;
/*      */         } 
/*      */       } else {
/*      */         Attribute attribute1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1973 */         (attribute1 = readAttribute(paramContext.a, str, i, i9, arrayOfChar, paramInt, arrayOfLabel)).a = attribute;
/* 1974 */         attribute = attribute1;
/*      */       } 
/* 1976 */       i += i9;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1981 */     boolean bool2 = ((paramContext.b & 0x8) != 0) ? true : false;
/* 1982 */     if (i3 != 0) {
/*      */ 
/*      */ 
/*      */       
/* 1986 */       paramContext.m = -1;
/* 1987 */       paramContext.n = 0;
/* 1988 */       paramContext.o = 0;
/* 1989 */       paramContext.p = 0;
/* 1990 */       paramContext.q = new Object[k];
/* 1991 */       paramContext.r = 0;
/* 1992 */       paramContext.s = new Object[j];
/* 1993 */       if (bool2) {
/* 1994 */         computeImplicitFrame(paramContext);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2003 */       for (int i9 = i3; i9 < i4 - 2; i9++) {
/* 2004 */         int i10; if (arrayOfByte[i9] == 8 && (
/*      */           
/* 2006 */           i10 = readUnsignedShort(i9 + 1)) >= 0 && i10 < m && (arrayOfByte[n + i10] & 0xFF) == 187)
/*      */         {
/*      */ 
/*      */           
/* 2010 */           createLabel(i10, arrayOfLabel);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 2015 */     if (bool2 && (paramContext.b & 0x100) != 0)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2022 */       paramMethodVisitor.visitFrame(-1, k, null, 0, null);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2030 */     byte b1 = 0;
/*      */ 
/*      */     
/* 2033 */     int i7 = getTypeAnnotationBytecodeOffset(arrayOfInt1, 0);
/*      */ 
/*      */     
/* 2036 */     byte b2 = 0;
/*      */ 
/*      */     
/* 2039 */     int i8 = getTypeAnnotationBytecodeOffset(arrayOfInt2, 0);
/*      */ 
/*      */     
/* 2042 */     boolean bool3 = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2048 */     paramInt = ((paramContext.b & 0x100) == 0) ? 33 : 0;
/*      */     
/* 2050 */     i = n;
/* 2051 */     while (i < i1) {
/* 2052 */       Object[] arrayOfObject; Label label2; int i10, i11, i12, arrayOfInt[]; String str1; Label[] arrayOfLabel1; String str2; byte b; String str3; int i13; Handle handle; i6 = i - n;
/*      */       
/*      */       Label label1;
/*      */       
/* 2056 */       if ((label1 = arrayOfLabel[i6]) != null) {
/* 2057 */         label1.a(paramMethodVisitor, ((paramContext.b & 0x2) == 0));
/*      */       }
/*      */ 
/*      */       
/* 2061 */       while (i3 != 0 && (paramContext.m == i6 || paramContext.m == -1)) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2066 */         if (paramContext.m != -1) {
/* 2067 */           if (!bool1 || bool2) {
/* 2068 */             paramMethodVisitor.visitFrame(-1, paramContext.o, paramContext.q, paramContext.r, paramContext.s);
/*      */ 
/*      */           
/*      */           }
/*      */           else {
/*      */ 
/*      */             
/* 2075 */             paramMethodVisitor.visitFrame(paramContext.n, paramContext.p, paramContext.q, paramContext.r, paramContext.s);
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2084 */           bool3 = false;
/*      */         } 
/* 2086 */         if (i3 < i4) {
/*      */           
/* 2088 */           i3 = readStackMapFrame(i3, bool1, bool2, paramContext); continue;
/*      */         } 
/* 2090 */         i3 = 0;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2096 */       if (bool3) {
/* 2097 */         if ((paramContext.b & 0x8) != 0) {
/* 2098 */           paramMethodVisitor.visitFrame(256, 0, null, 0, null);
/*      */         }
/* 2100 */         bool3 = false;
/*      */       } 
/*      */       
/*      */       int i9;
/*      */       
/* 2105 */       switch (i9 = arrayOfByte[i] & 0xFF) {
/*      */         case 0:
/*      */         case 1:
/*      */         case 2:
/*      */         case 3:
/*      */         case 4:
/*      */         case 5:
/*      */         case 6:
/*      */         case 7:
/*      */         case 8:
/*      */         case 9:
/*      */         case 10:
/*      */         case 11:
/*      */         case 12:
/*      */         case 13:
/*      */         case 14:
/*      */         case 15:
/*      */         case 46:
/*      */         case 47:
/*      */         case 48:
/*      */         case 49:
/*      */         case 50:
/*      */         case 51:
/*      */         case 52:
/*      */         case 53:
/*      */         case 79:
/*      */         case 80:
/*      */         case 81:
/*      */         case 82:
/*      */         case 83:
/*      */         case 84:
/*      */         case 85:
/*      */         case 86:
/*      */         case 87:
/*      */         case 88:
/*      */         case 89:
/*      */         case 90:
/*      */         case 91:
/*      */         case 92:
/*      */         case 93:
/*      */         case 94:
/*      */         case 95:
/*      */         case 96:
/*      */         case 97:
/*      */         case 98:
/*      */         case 99:
/*      */         case 100:
/*      */         case 101:
/*      */         case 102:
/*      */         case 103:
/*      */         case 104:
/*      */         case 105:
/*      */         case 106:
/*      */         case 107:
/*      */         case 108:
/*      */         case 109:
/*      */         case 110:
/*      */         case 111:
/*      */         case 112:
/*      */         case 113:
/*      */         case 114:
/*      */         case 115:
/*      */         case 116:
/*      */         case 117:
/*      */         case 118:
/*      */         case 119:
/*      */         case 120:
/*      */         case 121:
/*      */         case 122:
/*      */         case 123:
/*      */         case 124:
/*      */         case 125:
/*      */         case 126:
/*      */         case 127:
/*      */         case 128:
/*      */         case 129:
/*      */         case 130:
/*      */         case 131:
/*      */         case 133:
/*      */         case 134:
/*      */         case 135:
/*      */         case 136:
/*      */         case 137:
/*      */         case 138:
/*      */         case 139:
/*      */         case 140:
/*      */         case 141:
/*      */         case 142:
/*      */         case 143:
/*      */         case 144:
/*      */         case 145:
/*      */         case 146:
/*      */         case 147:
/*      */         case 148:
/*      */         case 149:
/*      */         case 150:
/*      */         case 151:
/*      */         case 152:
/*      */         case 172:
/*      */         case 173:
/*      */         case 174:
/*      */         case 175:
/*      */         case 176:
/*      */         case 177:
/*      */         case 190:
/*      */         case 191:
/*      */         case 194:
/*      */         case 195:
/* 2213 */           paramMethodVisitor.visitInsn(i9);
/* 2214 */           i++;
/*      */           break;
/*      */         case 26:
/*      */         case 27:
/*      */         case 28:
/*      */         case 29:
/*      */         case 30:
/*      */         case 31:
/*      */         case 32:
/*      */         case 33:
/*      */         case 34:
/*      */         case 35:
/*      */         case 36:
/*      */         case 37:
/*      */         case 38:
/*      */         case 39:
/*      */         case 40:
/*      */         case 41:
/*      */         case 42:
/*      */         case 43:
/*      */         case 44:
/*      */         case 45:
/* 2236 */           i9 -= 26;
/* 2237 */           paramMethodVisitor.visitVarInsn(21 + (i9 >> 2), i9 & 0x3);
/* 2238 */           i++;
/*      */           break;
/*      */         case 59:
/*      */         case 60:
/*      */         case 61:
/*      */         case 62:
/*      */         case 63:
/*      */         case 64:
/*      */         case 65:
/*      */         case 66:
/*      */         case 67:
/*      */         case 68:
/*      */         case 69:
/*      */         case 70:
/*      */         case 71:
/*      */         case 72:
/*      */         case 73:
/*      */         case 74:
/*      */         case 75:
/*      */         case 76:
/*      */         case 77:
/*      */         case 78:
/* 2260 */           i9 -= 59;
/* 2261 */           paramMethodVisitor.visitVarInsn(54 + (i9 >> 2), i9 & 0x3);
/* 2262 */           i++;
/*      */           break;
/*      */         case 153:
/*      */         case 154:
/*      */         case 155:
/*      */         case 156:
/*      */         case 157:
/*      */         case 158:
/*      */         case 159:
/*      */         case 160:
/*      */         case 161:
/*      */         case 162:
/*      */         case 163:
/*      */         case 164:
/*      */         case 165:
/*      */         case 166:
/*      */         case 167:
/*      */         case 168:
/*      */         case 198:
/*      */         case 199:
/* 2282 */           paramMethodVisitor.visitJumpInsn(i9, arrayOfLabel[i6 + 
/* 2283 */                 readShort(i + 1)]);
/* 2284 */           i += 3;
/*      */           break;
/*      */         case 200:
/*      */         case 201:
/* 2288 */           paramMethodVisitor.visitJumpInsn(i9 - paramInt, arrayOfLabel[i6 + 
/*      */                 
/* 2290 */                 readInt(i + 1)]);
/* 2291 */           i += 5;
/*      */           break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 202:
/*      */         case 203:
/*      */         case 204:
/*      */         case 205:
/*      */         case 206:
/*      */         case 207:
/*      */         case 208:
/*      */         case 209:
/*      */         case 210:
/*      */         case 211:
/*      */         case 212:
/*      */         case 213:
/*      */         case 214:
/*      */         case 215:
/*      */         case 216:
/*      */         case 217:
/*      */         case 218:
/*      */         case 219:
/* 2321 */           i9 = (i9 < 218) ? (i9 - 49) : (i9 - 20);
/* 2322 */           label2 = arrayOfLabel[i6 + readUnsignedShort(i + 1)];
/* 2323 */           if (i9 == 167 || i9 == 168) {
/*      */             
/* 2325 */             paramMethodVisitor.visitJumpInsn(i9 + 33, label2);
/*      */           
/*      */           }
/*      */           else {
/*      */             
/* 2330 */             i9 = (i9 < 167) ? ((i9 + 1 ^ 0x1) - 1) : (i9 ^ 0x1);
/* 2331 */             Label label = createLabel(i6 + 3, arrayOfLabel);
/* 2332 */             paramMethodVisitor.visitJumpInsn(i9, label);
/* 2333 */             paramMethodVisitor.visitJumpInsn(200, label2);
/*      */ 
/*      */             
/* 2336 */             bool3 = true;
/*      */           } 
/* 2338 */           i += 3;
/*      */           break;
/*      */ 
/*      */         
/*      */         case 220:
/* 2343 */           paramMethodVisitor.visitJumpInsn(200, arrayOfLabel[i6 + 
/* 2344 */                 readInt(i + 1)]);
/*      */ 
/*      */ 
/*      */           
/* 2348 */           bool3 = true;
/* 2349 */           i += 5;
/*      */           break;
/*      */         
/*      */         case 196:
/* 2353 */           if ((i9 = arrayOfByte[i + 1] & 0xFF) == 132) {
/* 2354 */             paramMethodVisitor.visitIincInsn(
/* 2355 */                 readUnsignedShort(i + 2), readShort(i + 4));
/* 2356 */             i += 6; break;
/*      */           } 
/* 2358 */           paramMethodVisitor.visitVarInsn(i9, readUnsignedShort(i + 2));
/* 2359 */           i += 4;
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 170:
/* 2365 */           i += 4 - (i6 & 0x3);
/*      */           
/* 2367 */           label2 = arrayOfLabel[i6 + readInt(i)];
/* 2368 */           i11 = readInt(i + 4);
/* 2369 */           i12 = readInt(i + 8);
/* 2370 */           i += 12;
/* 2371 */           arrayOfLabel1 = new Label[i12 - i11 + 1];
/* 2372 */           for (b = 0; b < arrayOfLabel1.length; b++) {
/* 2373 */             arrayOfLabel1[b] = arrayOfLabel[i6 + readInt(i)];
/* 2374 */             i += 4;
/*      */           } 
/* 2376 */           paramMethodVisitor.visitTableSwitchInsn(i11, i12, label2, arrayOfLabel1);
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 171:
/* 2382 */           i += 4 - (i6 & 0x3);
/*      */           
/* 2384 */           label2 = arrayOfLabel[i6 + readInt(i)];
/* 2385 */           i11 = readInt(i + 4);
/* 2386 */           i += 8;
/* 2387 */           arrayOfInt = new int[i11];
/* 2388 */           arrayOfLabel1 = new Label[i11];
/* 2389 */           for (b = 0; b < i11; b++) {
/* 2390 */             arrayOfInt[b] = readInt(i);
/* 2391 */             arrayOfLabel1[b] = arrayOfLabel[i6 + readInt(i + 4)];
/* 2392 */             i += 8;
/*      */           } 
/* 2394 */           paramMethodVisitor.visitLookupSwitchInsn(label2, arrayOfInt, arrayOfLabel1);
/*      */           break;
/*      */         
/*      */         case 21:
/*      */         case 22:
/*      */         case 23:
/*      */         case 24:
/*      */         case 25:
/*      */         case 54:
/*      */         case 55:
/*      */         case 56:
/*      */         case 57:
/*      */         case 58:
/*      */         case 169:
/* 2408 */           paramMethodVisitor.visitVarInsn(i9, arrayOfByte[i + 1] & 0xFF);
/* 2409 */           i += 2;
/*      */           break;
/*      */         case 16:
/*      */         case 188:
/* 2413 */           paramMethodVisitor.visitIntInsn(i9, arrayOfByte[i + 1]);
/* 2414 */           i += 2;
/*      */           break;
/*      */         case 17:
/* 2417 */           paramMethodVisitor.visitIntInsn(i9, readShort(i + 1));
/* 2418 */           i += 3;
/*      */           break;
/*      */         case 18:
/* 2421 */           paramMethodVisitor.visitLdcInsn(readConst(arrayOfByte[i + 1] & 0xFF, arrayOfChar));
/* 2422 */           i += 2;
/*      */           break;
/*      */         case 19:
/*      */         case 20:
/* 2426 */           paramMethodVisitor.visitLdcInsn(readConst(readUnsignedShort(i + 1), arrayOfChar));
/* 2427 */           i += 3;
/*      */           break;
/*      */         
/*      */         case 178:
/*      */         case 179:
/*      */         case 180:
/*      */         case 181:
/*      */         case 182:
/*      */         case 183:
/*      */         case 184:
/*      */         case 185:
/* 2438 */           i10 = this.cpInfoOffsets[readUnsignedShort(i + 1)];
/* 2439 */           i11 = this.cpInfoOffsets[readUnsignedShort(i10 + 2)];
/* 2440 */           str1 = readClass(i10, arrayOfChar);
/* 2441 */           str2 = readUTF8(i11, arrayOfChar);
/* 2442 */           str3 = readUTF8(i11 + 2, arrayOfChar);
/* 2443 */           if (i9 < 182) {
/* 2444 */             paramMethodVisitor.visitFieldInsn(i9, str1, str2, str3);
/*      */           } else {
/* 2446 */             boolean bool = (arrayOfByte[i10 - 1] == 11) ? true : false;
/*      */             
/* 2448 */             paramMethodVisitor.visitMethodInsn(i9, str1, str2, str3, bool);
/*      */           } 
/* 2450 */           if (i9 == 185) {
/* 2451 */             i += 5; break;
/*      */           } 
/* 2453 */           i += 3;
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 186:
/* 2459 */           i10 = this.cpInfoOffsets[readUnsignedShort(i + 1)];
/* 2460 */           i11 = this.cpInfoOffsets[readUnsignedShort(i10 + 2)];
/* 2461 */           str1 = readUTF8(i11, arrayOfChar);
/* 2462 */           str2 = readUTF8(i11 + 2, arrayOfChar);
/* 2463 */           i13 = this.bootstrapMethodOffsets[readUnsignedShort(i10)];
/*      */           
/* 2465 */           handle = (Handle)readConst(readUnsignedShort(i13), arrayOfChar);
/*      */           
/* 2467 */           arrayOfObject = new Object[readUnsignedShort(i13 + 2)];
/* 2468 */           i13 += 4;
/* 2469 */           for (i9 = 0; i9 < arrayOfObject.length; i9++) {
/* 2470 */             arrayOfObject[i9] = 
/* 2471 */               readConst(readUnsignedShort(i13), arrayOfChar);
/* 2472 */             i13 += 2;
/*      */           } 
/* 2474 */           paramMethodVisitor.visitInvokeDynamicInsn(str1, str2, handle, arrayOfObject);
/*      */           
/* 2476 */           i += 5;
/*      */           break;
/*      */         
/*      */         case 187:
/*      */         case 189:
/*      */         case 192:
/*      */         case 193:
/* 2483 */           paramMethodVisitor.visitTypeInsn(i9, readClass(i + 1, arrayOfChar));
/* 2484 */           i += 3;
/*      */           break;
/*      */         case 132:
/* 2487 */           paramMethodVisitor.visitIincInsn(arrayOfByte[i + 1] & 0xFF, arrayOfByte[i + 2]);
/*      */           
/* 2489 */           i += 3;
/*      */           break;
/*      */         case 197:
/* 2492 */           paramMethodVisitor.visitMultiANewArrayInsn(
/* 2493 */               readClass(i + 1, arrayOfChar), arrayOfByte[i + 3] & 0xFF);
/* 2494 */           i += 4;
/*      */           break;
/*      */         default:
/* 2497 */           throw new AssertionError();
/*      */       } 
/*      */ 
/*      */       
/* 2501 */       while (arrayOfInt1 != null && b1 < arrayOfInt1.length && i7 <= i6) {
/*      */ 
/*      */         
/* 2504 */         if (i7 == i6) {
/*      */ 
/*      */           
/* 2507 */           i10 = readTypeAnnotationTarget(paramContext, arrayOfInt1[b1]);
/*      */ 
/*      */           
/* 2510 */           String str = readUTF8(i10, arrayOfChar);
/* 2511 */           i10 += 2;
/*      */           
/* 2513 */           readElementValues(paramMethodVisitor
/* 2514 */               .visitInsnAnnotation(paramContext.h, paramContext.i, str, true), i10, true, arrayOfChar);
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2524 */         i7 = getTypeAnnotationBytecodeOffset(arrayOfInt1, ++b1);
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 2529 */       while (arrayOfInt2 != null && b2 < arrayOfInt2.length && i8 <= i6) {
/*      */ 
/*      */         
/* 2532 */         if (i8 == i6) {
/*      */ 
/*      */           
/* 2535 */           i10 = readTypeAnnotationTarget(paramContext, arrayOfInt2[b2]);
/*      */ 
/*      */           
/* 2538 */           String str = readUTF8(i10, arrayOfChar);
/* 2539 */           i10 += 2;
/*      */           
/* 2541 */           readElementValues(paramMethodVisitor
/* 2542 */               .visitInsnAnnotation(paramContext.h, paramContext.i, str, false), i10, true, arrayOfChar);
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2552 */         i8 = getTypeAnnotationBytecodeOffset(arrayOfInt2, ++b2);
/*      */       } 
/*      */     } 
/*      */     
/* 2556 */     if (arrayOfLabel[m] != null) {
/* 2557 */       paramMethodVisitor.visitLabel(arrayOfLabel[m]);
/*      */     }
/*      */ 
/*      */     
/* 2561 */     if (i5 != 0 && (paramContext.b & 0x2) == 0) {
/*      */       
/* 2563 */       int[] arrayOfInt = null;
/* 2564 */       if (i2 != 0) {
/* 2565 */         arrayOfInt = new int[readUnsignedShort(i2) * 3];
/* 2566 */         i = i2 + 2;
/* 2567 */         int i10 = arrayOfInt.length;
/* 2568 */         while (i10 > 0) {
/*      */           
/* 2570 */           arrayOfInt[--i10] = i + 6;
/* 2571 */           arrayOfInt[--i10] = readUnsignedShort(i + 8);
/* 2572 */           arrayOfInt[--i10] = readUnsignedShort(i);
/* 2573 */           i += 10;
/*      */         } 
/*      */       } 
/* 2576 */       int i9 = readUnsignedShort(i5);
/* 2577 */       i = i5 + 2;
/* 2578 */       while (i9-- > 0) {
/* 2579 */         int i10 = readUnsignedShort(i);
/* 2580 */         int i11 = readUnsignedShort(i + 2);
/* 2581 */         String str1 = readUTF8(i + 4, arrayOfChar);
/* 2582 */         String str2 = readUTF8(i + 6, arrayOfChar);
/* 2583 */         int i12 = readUnsignedShort(i + 8);
/* 2584 */         i += 10;
/* 2585 */         String str3 = null;
/* 2586 */         if (arrayOfInt != null) {
/* 2587 */           for (byte b = 0; b < arrayOfInt.length; b += 3) {
/* 2588 */             if (arrayOfInt[b] == i10 && arrayOfInt[b + 1] == i12) {
/* 2589 */               str3 = readUTF8(arrayOfInt[b + 2], arrayOfChar);
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         }
/* 2594 */         paramMethodVisitor.visitLocalVariable(str1, str2, str3, arrayOfLabel[i10], arrayOfLabel[i10 + i11], i12);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2600 */     if (arrayOfInt1 != null) {
/* 2601 */       int[] arrayOfInt; int i9; byte b; for (i9 = (arrayOfInt = arrayOfInt1).length, b = 0; b < i9; ) { int i10 = arrayOfInt[b];
/*      */         int i11;
/* 2603 */         if ((i11 = readByte(i10)) == 64 || i11 == 65) {
/*      */ 
/*      */           
/* 2606 */           i = readTypeAnnotationTarget(paramContext, i10);
/*      */           
/* 2608 */           String str = readUTF8(i, arrayOfChar);
/* 2609 */           i += 2;
/*      */           
/* 2611 */           readElementValues(paramMethodVisitor
/* 2612 */               .visitLocalVariableAnnotation(paramContext.h, paramContext.i, paramContext.j, paramContext.k, paramContext.l, str, true), i, true, arrayOfChar);
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         b++; }
/*      */     
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2628 */     if (arrayOfInt2 != null) {
/* 2629 */       int[] arrayOfInt; int i9; byte b; for (i9 = (arrayOfInt = arrayOfInt2).length, b = 0; b < i9; ) { int i10 = arrayOfInt[b];
/*      */         int i11;
/* 2631 */         if ((i11 = readByte(i10)) == 64 || i11 == 65) {
/*      */ 
/*      */           
/* 2634 */           i = readTypeAnnotationTarget(paramContext, i10);
/*      */           
/* 2636 */           String str = readUTF8(i, arrayOfChar);
/* 2637 */           i += 2;
/*      */           
/* 2639 */           readElementValues(paramMethodVisitor
/* 2640 */               .visitLocalVariableAnnotation(paramContext.h, paramContext.i, paramContext.j, paramContext.k, paramContext.l, str, false), i, true, arrayOfChar);
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         b++; }
/*      */     
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2656 */     while (attribute != null) {
/*      */       
/* 2658 */       Attribute attribute1 = attribute.a;
/* 2659 */       attribute.a = null;
/* 2660 */       paramMethodVisitor.visitAttribute(attribute);
/* 2661 */       attribute = attribute1;
/*      */     } 
/*      */ 
/*      */     
/* 2665 */     paramMethodVisitor.visitMaxs(j, k);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Label readLabel(int paramInt, Label[] paramArrayOfLabel) {
/* 2679 */     if (paramArrayOfLabel[paramInt] == null) {
/* 2680 */       paramArrayOfLabel[paramInt] = new Label();
/*      */     }
/* 2682 */     return paramArrayOfLabel[paramInt];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Label createLabel(int paramInt, Label[] paramArrayOfLabel) {
/*      */     Label label;
/* 2696 */     (label = readLabel(paramInt, paramArrayOfLabel)).b = (short)((label = readLabel(paramInt, paramArrayOfLabel)).b & 0xFFFFFFFE);
/* 2697 */     return label;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void createDebugLabel(int paramInt, Label[] paramArrayOfLabel) {
/* 2709 */     if (paramArrayOfLabel[paramInt] == null) {
/* 2710 */       (readLabel(paramInt, paramArrayOfLabel)).b = (short)((readLabel(paramInt, paramArrayOfLabel)).b | 0x1);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int[] readTypeAnnotations(MethodVisitor paramMethodVisitor, Context paramContext, int paramInt, boolean paramBoolean) {
/* 2737 */     char[] arrayOfChar = paramContext.c;
/* 2738 */     int i = paramInt;
/*      */     
/* 2740 */     int[] arrayOfInt = new int[readUnsignedShort(paramInt)];
/* 2741 */     i += 2;
/*      */     
/* 2743 */     for (byte b = 0; b < arrayOfInt.length; b++) {
/* 2744 */       arrayOfInt[b] = i;
/*      */       
/*      */       int j;
/*      */       
/* 2748 */       switch ((j = readInt(i)) >>> 24) {
/*      */ 
/*      */         
/*      */         case 64:
/*      */         case 65:
/* 2753 */           k = readUnsignedShort(i + 1);
/* 2754 */           i += 3;
/* 2755 */           while (k-- > 0) {
/* 2756 */             int m = readUnsignedShort(i);
/* 2757 */             int n = readUnsignedShort(i + 2);
/*      */             
/* 2759 */             i += 6;
/* 2760 */             createLabel(m, paramContext.g);
/* 2761 */             createLabel(m + n, paramContext.g);
/*      */           } 
/*      */           break;
/*      */         case 71:
/*      */         case 72:
/*      */         case 73:
/*      */         case 74:
/*      */         case 75:
/* 2769 */           i += 4;
/*      */           break;
/*      */         case 16:
/*      */         case 17:
/*      */         case 18:
/*      */         case 23:
/*      */         case 66:
/*      */         case 67:
/*      */         case 68:
/*      */         case 69:
/*      */         case 70:
/* 2780 */           i += 3;
/*      */           break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         default:
/* 2790 */           throw new IllegalArgumentException();
/*      */       } 
/*      */ 
/*      */       
/* 2794 */       int k = readByte(i);
/* 2795 */       if (j >>> 24 == 66) {
/*      */         
/* 2797 */         TypePath typePath = (k == 0) ? null : new TypePath(this.a, i);
/* 2798 */         i += 1 + 2 * k;
/*      */         
/* 2800 */         String str = readUTF8(i, arrayOfChar);
/* 2801 */         i += 2;
/*      */ 
/*      */         
/* 2804 */         i = readElementValues(paramMethodVisitor
/* 2805 */             .visitTryCatchAnnotation(j & 0xFFFFFF00, typePath, str, paramBoolean), i, true, arrayOfChar);
/*      */ 
/*      */ 
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */ 
/*      */         
/* 2814 */         i += 3 + 2 * k;
/*      */ 
/*      */ 
/*      */         
/* 2818 */         i = readElementValues(null, i, true, arrayOfChar);
/*      */       } 
/*      */     } 
/*      */     
/* 2822 */     return arrayOfInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int getTypeAnnotationBytecodeOffset(int[] paramArrayOfint, int paramInt) {
/* 2837 */     if (paramArrayOfint == null || paramInt >= paramArrayOfint.length || 
/*      */       
/* 2839 */       readByte(paramArrayOfint[paramInt]) < 67) {
/* 2840 */       return -1;
/*      */     }
/* 2842 */     return readUnsignedShort(paramArrayOfint[paramInt] + 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int readTypeAnnotationTarget(Context paramContext, int paramInt) {
/*      */     byte b;
/* 2856 */     int i = paramInt;
/*      */     
/*      */     int j;
/* 2859 */     switch ((j = readInt(paramInt)) >>> 24) {
/*      */       case 0:
/*      */       case 1:
/*      */       case 22:
/* 2863 */         j &= 0xFFFF0000;
/* 2864 */         i += 2;
/*      */         break;
/*      */       case 19:
/*      */       case 20:
/*      */       case 21:
/* 2869 */         j &= 0xFF000000;
/* 2870 */         i++;
/*      */         break;
/*      */       case 64:
/*      */       case 65:
/* 2874 */         j &= 0xFF000000;
/* 2875 */         paramInt = readUnsignedShort(paramInt + 1);
/* 2876 */         i += 3;
/* 2877 */         paramContext.j = new Label[paramInt];
/* 2878 */         paramContext.k = new Label[paramInt];
/* 2879 */         paramContext.l = new int[paramInt];
/* 2880 */         for (b = 0; b < paramInt; b++) {
/* 2881 */           int k = readUnsignedShort(i);
/* 2882 */           int m = readUnsignedShort(i + 2);
/* 2883 */           int n = readUnsignedShort(i + 4);
/* 2884 */           i += 6;
/* 2885 */           paramContext.j[b] = 
/* 2886 */             createLabel(k, paramContext.g);
/* 2887 */           paramContext.k[b] = 
/* 2888 */             createLabel(k + m, paramContext.g);
/* 2889 */           paramContext.l[b] = n;
/*      */         } 
/*      */         break;
/*      */       case 71:
/*      */       case 72:
/*      */       case 73:
/*      */       case 74:
/*      */       case 75:
/* 2897 */         j &= 0xFF0000FF;
/* 2898 */         i += 4;
/*      */         break;
/*      */       case 16:
/*      */       case 17:
/*      */       case 18:
/*      */       case 23:
/*      */       case 66:
/* 2905 */         j &= 0xFFFFFF00;
/* 2906 */         i += 3;
/*      */         break;
/*      */       case 67:
/*      */       case 68:
/*      */       case 69:
/*      */       case 70:
/* 2912 */         j &= 0xFF000000;
/* 2913 */         i += 3;
/*      */         break;
/*      */       default:
/* 2916 */         throw new IllegalArgumentException();
/*      */     } 
/* 2918 */     paramContext.h = j;
/*      */     
/* 2920 */     paramInt = readByte(i);
/* 2921 */     paramContext
/* 2922 */       .i = (paramInt == 0) ? null : new TypePath(this.a, i);
/*      */     
/* 2924 */     return i + 1 + 2 * paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void readParameterAnnotations(MethodVisitor paramMethodVisitor, Context paramContext, int paramInt, boolean paramBoolean) {
/* 2943 */     int i = paramInt;
/* 2944 */     i++; paramInt = this.a[paramInt] & 0xFF;
/* 2945 */     paramMethodVisitor.visitAnnotableParameterCount(paramInt, paramBoolean);
/* 2946 */     char[] arrayOfChar = paramContext.c;
/* 2947 */     for (byte b = 0; b < paramInt; b++) {
/* 2948 */       int j = readUnsignedShort(i);
/* 2949 */       i += 2;
/* 2950 */       while (j-- > 0) {
/*      */         
/* 2952 */         String str = readUTF8(i, arrayOfChar);
/* 2953 */         i += 2;
/*      */ 
/*      */         
/* 2956 */         i = readElementValues(paramMethodVisitor
/* 2957 */             .visitParameterAnnotation(b, str, paramBoolean), i, true, arrayOfChar);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int readElementValues(AnnotationVisitor paramAnnotationVisitor, int paramInt, boolean paramBoolean, char[] paramArrayOfchar) {
/* 2984 */     int i = paramInt;
/*      */     
/* 2986 */     paramInt = readUnsignedShort(paramInt);
/* 2987 */     i += 2;
/* 2988 */     if (paramBoolean) {
/*      */       
/* 2990 */       while (paramInt-- > 0) {
/* 2991 */         String str = readUTF8(i, paramArrayOfchar);
/*      */         
/* 2993 */         i = readElementValue(paramAnnotationVisitor, i + 2, str, paramArrayOfchar);
/*      */       } 
/*      */     } else {
/*      */       
/* 2997 */       while (paramInt-- > 0)
/*      */       {
/* 2999 */         i = readElementValue(paramAnnotationVisitor, i, null, paramArrayOfchar);
/*      */       }
/*      */     } 
/* 3002 */     if (paramAnnotationVisitor != null) {
/* 3003 */       paramAnnotationVisitor.visitEnd();
/*      */     }
/* 3005 */     return i;
/*      */   }
/*      */   private int readElementValue(AnnotationVisitor paramAnnotationVisitor, int paramInt, String paramString, char[] paramArrayOfchar) {
/*      */     byte[] arrayOfByte;
/*      */     byte b4;
/*      */     short[] arrayOfShort;
/*      */     byte b3;
/*      */     int[] arrayOfInt;
/*      */     byte b2;
/*      */     float[] arrayOfFloat;
/*      */     byte b1, b8;
/*      */     boolean[] arrayOfBoolean;
/*      */     byte b7;
/*      */     char[] arrayOfChar;
/*      */     byte b6;
/*      */     long[] arrayOfLong;
/*      */     byte b5;
/*      */     double[] arrayOfDouble;
/* 3023 */     int i = paramInt;
/* 3024 */     if (paramAnnotationVisitor == null) {
/* 3025 */       switch (this.a[paramInt] & 0xFF) {
/*      */         case 101:
/* 3027 */           return paramInt + 5;
/*      */         case 64:
/* 3029 */           return readElementValues(null, paramInt + 3, true, paramArrayOfchar);
/*      */         case 91:
/* 3031 */           return readElementValues(null, paramInt + 1, false, paramArrayOfchar);
/*      */       } 
/* 3033 */       return paramInt + 3;
/*      */     } 
/*      */     
/* 3036 */     i++; switch (this.a[paramInt] & 0xFF) {
/*      */       case 66:
/* 3038 */         paramAnnotationVisitor.visit(paramString, 
/* 3039 */             Byte.valueOf((byte)readInt(this.cpInfoOffsets[readUnsignedShort(i)])));
/* 3040 */         i += 2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 3184 */         return i;case 67: paramAnnotationVisitor.visit(paramString, Character.valueOf((char)readInt(this.cpInfoOffsets[readUnsignedShort(i)]))); i += 2; return i;case 68: case 70: case 73: case 74: paramAnnotationVisitor.visit(paramString, readConst(readUnsignedShort(i), paramArrayOfchar)); i += 2; return i;case 83: paramAnnotationVisitor.visit(paramString, Short.valueOf((short)readInt(this.cpInfoOffsets[readUnsignedShort(i)]))); i += 2; return i;case 90: paramAnnotationVisitor.visit(paramString, (readInt(this.cpInfoOffsets[readUnsignedShort(i)]) == 0) ? Boolean.FALSE : Boolean.TRUE); i += 2; return i;case 115: paramAnnotationVisitor.visit(paramString, readUTF8(i, paramArrayOfchar)); i += 2; return i;case 101: paramAnnotationVisitor.visitEnum(paramString, readUTF8(i, paramArrayOfchar), readUTF8(i + 2, paramArrayOfchar)); i += 4; return i;case 99: paramAnnotationVisitor.visit(paramString, Type.getType(readUTF8(i, paramArrayOfchar))); i += 2; return i;case 64: i = readElementValues(paramAnnotationVisitor.visitAnnotation(paramString, readUTF8(i, paramArrayOfchar)), i + 2, true, paramArrayOfchar); return i;case 91: paramInt = readUnsignedShort(i); i += 2; if (paramInt == 0) return readElementValues(paramAnnotationVisitor.visitArray(paramString), i - 2, false, paramArrayOfchar);  switch (this.a[i] & 0xFF) { case 66: arrayOfByte = new byte[paramInt]; for (b8 = 0; b8 < paramInt; b8++) { arrayOfByte[b8] = (byte)readInt(this.cpInfoOffsets[readUnsignedShort(i + 1)]); i += 3; }  paramAnnotationVisitor.visit(paramString, arrayOfByte); return i;case 90: arrayOfBoolean = new boolean[paramInt]; for (b4 = 0; b4 < paramInt; b4++) { arrayOfBoolean[b4] = (readInt(this.cpInfoOffsets[readUnsignedShort(i + 1)]) != 0); i += 3; }  paramAnnotationVisitor.visit(paramString, arrayOfBoolean); return i;case 83: arrayOfShort = new short[paramInt]; for (b7 = 0; b7 < paramInt; b7++) { arrayOfShort[b7] = (short)readInt(this.cpInfoOffsets[readUnsignedShort(i + 1)]); i += 3; }  paramAnnotationVisitor.visit(paramString, arrayOfShort); return i;case 67: arrayOfChar = new char[paramInt]; for (b3 = 0; b3 < paramInt; b3++) { arrayOfChar[b3] = (char)readInt(this.cpInfoOffsets[readUnsignedShort(i + 1)]); i += 3; }  paramAnnotationVisitor.visit(paramString, arrayOfChar); return i;case 73: arrayOfInt = new int[paramInt]; for (b6 = 0; b6 < paramInt; b6++) { arrayOfInt[b6] = readInt(this.cpInfoOffsets[readUnsignedShort(i + 1)]); i += 3; }  paramAnnotationVisitor.visit(paramString, arrayOfInt); return i;case 74: arrayOfLong = new long[paramInt]; for (b2 = 0; b2 < paramInt; b2++) { arrayOfLong[b2] = readLong(this.cpInfoOffsets[readUnsignedShort(i + 1)]); i += 3; }  paramAnnotationVisitor.visit(paramString, arrayOfLong); return i;case 70: arrayOfFloat = new float[paramInt]; for (b5 = 0; b5 < paramInt; b5++) { arrayOfFloat[b5] = Float.intBitsToFloat(readInt(this.cpInfoOffsets[readUnsignedShort(i + 1)])); i += 3; }  paramAnnotationVisitor.visit(paramString, arrayOfFloat); return i;case 68: arrayOfDouble = new double[paramInt]; for (b1 = 0; b1 < paramInt; b1++) { arrayOfDouble[b1] = Double.longBitsToDouble(readLong(this.cpInfoOffsets[readUnsignedShort(i + 1)])); i += 3; }  paramAnnotationVisitor.visit(paramString, arrayOfDouble); return i; }  i = readElementValues(paramAnnotationVisitor.visitArray(paramString), i - 2, false, b1); return i;
/*      */     } 
/*      */     throw new IllegalArgumentException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void computeImplicitFrame(Context paramContext) {
/* 3198 */     String str = paramContext.f;
/* 3199 */     Object[] arrayOfObject = paramContext.q;
/* 3200 */     byte b1 = 0;
/* 3201 */     if ((paramContext.d & 0x8) == 0) {
/* 3202 */       if ("<init>".equals(paramContext.e)) {
/* 3203 */         b1++; arrayOfObject[0] = Opcodes.UNINITIALIZED_THIS;
/*      */       } else {
/* 3205 */         b1++; arrayOfObject[0] = readClass(this.header + 2, paramContext.c);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/* 3210 */     byte b2 = 1;
/*      */     while (true) {
/* 3212 */       byte b = b2;
/* 3213 */       switch (str.charAt(b2++)) {
/*      */         case 'B':
/*      */         case 'C':
/*      */         case 'I':
/*      */         case 'S':
/*      */         case 'Z':
/* 3219 */           arrayOfObject[b1++] = Opcodes.INTEGER;
/*      */           continue;
/*      */         case 'F':
/* 3222 */           arrayOfObject[b1++] = Opcodes.FLOAT;
/*      */           continue;
/*      */         case 'J':
/* 3225 */           arrayOfObject[b1++] = Opcodes.LONG;
/*      */           continue;
/*      */         case 'D':
/* 3228 */           arrayOfObject[b1++] = Opcodes.DOUBLE;
/*      */           continue;
/*      */         case '[':
/* 3231 */           while (str.charAt(b2) == '[') {
/* 3232 */             b2++;
/*      */           }
/* 3234 */           if (str.charAt(b2) == 'L') {
/* 3235 */             b2++;
/* 3236 */             while (str.charAt(b2) != ';') {
/* 3237 */               b2++;
/*      */             }
/*      */           } 
/* 3240 */           arrayOfObject[b1++] = str
/* 3241 */             .substring(b, ++b2);
/*      */           continue;
/*      */         
/*      */         case 'L':
/* 3245 */           while (str.charAt(b2) != ';') {
/* 3246 */             b2++;
/*      */           }
/* 3248 */           arrayOfObject[b1++] = str
/* 3249 */             .substring(b + 1, b2++); continue;
/*      */       } 
/*      */       break;
/*      */     } 
/* 3253 */     paramContext.o = b1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int readStackMapFrame(int paramInt, boolean paramBoolean1, boolean paramBoolean2, Context paramContext) {
/* 3278 */     int i, j = paramInt;
/* 3279 */     char[] arrayOfChar = paramContext.c;
/* 3280 */     Label[] arrayOfLabel = paramContext.g;
/*      */     
/* 3282 */     if (paramBoolean1) {
/*      */       
/* 3284 */       j++; paramInt = this.a[paramInt] & 0xFF;
/*      */     } else {
/* 3286 */       paramInt = 255;
/* 3287 */       paramContext.m = -1;
/*      */     } 
/*      */     
/* 3290 */     paramContext.p = 0;
/* 3291 */     if (paramInt < 64) {
/* 3292 */       i = paramInt;
/* 3293 */       paramContext.n = 3;
/* 3294 */       paramContext.r = 0;
/* 3295 */     } else if (paramInt < 128) {
/* 3296 */       i = paramInt - 64;
/*      */       
/* 3298 */       j = readVerificationTypeInfo(j, paramContext.s, 0, arrayOfChar, arrayOfLabel);
/*      */       
/* 3300 */       paramContext.n = 4;
/* 3301 */       paramContext.r = 1;
/* 3302 */     } else if (paramInt >= 247) {
/* 3303 */       i = readUnsignedShort(j);
/* 3304 */       j += 2;
/* 3305 */       if (paramInt == 247) {
/*      */         
/* 3307 */         j = readVerificationTypeInfo(j, paramContext.s, 0, arrayOfChar, arrayOfLabel);
/*      */         
/* 3309 */         paramContext.n = 4;
/* 3310 */         paramContext.r = 1;
/* 3311 */       } else if (paramInt >= 248 && paramInt < 251) {
/* 3312 */         paramContext.n = 2;
/* 3313 */         paramContext.p = 251 - paramInt;
/* 3314 */         paramContext.o -= paramContext.p;
/* 3315 */         paramContext.r = 0;
/* 3316 */       } else if (paramInt == 251) {
/* 3317 */         paramContext.n = 3;
/* 3318 */         paramContext.r = 0;
/* 3319 */       } else if (paramInt < 255) {
/* 3320 */         paramBoolean2 = paramBoolean2 ? paramContext.o : false;
/* 3321 */         for (int k = paramInt - 251; k > 0; k--)
/*      */         {
/* 3323 */           j = readVerificationTypeInfo(j, paramContext.q, paramBoolean2++, arrayOfChar, arrayOfLabel);
/*      */         }
/*      */         
/* 3326 */         paramContext.n = 1;
/* 3327 */         paramContext.p = paramInt - 251;
/* 3328 */         paramContext.o += paramContext.p;
/* 3329 */         paramContext.r = 0;
/*      */       } else {
/* 3331 */         int k = readUnsignedShort(j);
/* 3332 */         j += 2;
/* 3333 */         paramContext.n = 0;
/* 3334 */         paramContext.p = k;
/* 3335 */         paramContext.o = k; int m;
/* 3336 */         for (m = 0; m < k; m++)
/*      */         {
/* 3338 */           j = readVerificationTypeInfo(j, paramContext.q, m, arrayOfChar, arrayOfLabel);
/*      */         }
/*      */         
/* 3341 */         m = readUnsignedShort(j);
/* 3342 */         j += 2;
/* 3343 */         paramContext.r = m;
/* 3344 */         for (paramInt = 0; paramInt < m; paramInt++)
/*      */         {
/* 3346 */           j = readVerificationTypeInfo(j, paramContext.s, paramInt, arrayOfChar, arrayOfLabel);
/*      */         }
/*      */       } 
/*      */     } else {
/*      */       
/* 3351 */       throw new IllegalArgumentException();
/*      */     } 
/* 3353 */     paramContext.m += i + 1;
/* 3354 */     createLabel(paramContext.m, arrayOfLabel);
/* 3355 */     return j;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int readVerificationTypeInfo(int paramInt1, Object[] paramArrayOfObject, int paramInt2, char[] paramArrayOfchar, Label[] paramArrayOfLabel) {
/* 3378 */     int i = paramInt1;
/* 3379 */     i++;
/* 3380 */     switch (paramInt1 = this.a[paramInt1] & 0xFF) {
/*      */       case 0:
/* 3382 */         paramArrayOfObject[paramInt2] = Opcodes.TOP;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 3413 */         return i;case 1: paramArrayOfObject[paramInt2] = Opcodes.INTEGER; return i;case 2: paramArrayOfObject[paramInt2] = Opcodes.FLOAT; return i;case 3: paramArrayOfObject[paramInt2] = Opcodes.DOUBLE; return i;case 4: paramArrayOfObject[paramInt2] = Opcodes.LONG; return i;case 5: paramArrayOfObject[paramInt2] = Opcodes.NULL; return i;case 6: paramArrayOfObject[paramInt2] = Opcodes.UNINITIALIZED_THIS; return i;case 7: paramArrayOfObject[paramInt2] = readClass(i, paramArrayOfchar); i += 2; return i;case 8: paramArrayOfObject[paramInt2] = createLabel(readUnsignedShort(i), paramArrayOfLabel); i += 2; return i;
/*      */     } 
/*      */     throw new IllegalArgumentException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final int a() {
/* 3430 */     int i = this.header + 8 + (readUnsignedShort(this.header + 6) << 1);
/*      */ 
/*      */     
/* 3433 */     int j = readUnsignedShort(i);
/* 3434 */     i += 2;
/*      */     
/* 3436 */     while (j-- > 0) {
/*      */ 
/*      */ 
/*      */       
/* 3440 */       int m = readUnsignedShort(i + 6);
/* 3441 */       i += 8;
/*      */       
/* 3443 */       while (m-- > 0)
/*      */       {
/*      */ 
/*      */ 
/*      */         
/* 3448 */         i += 6 + readInt(i + 2);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 3453 */     int k = readUnsignedShort(i);
/* 3454 */     i += 2;
/* 3455 */     while (k-- > 0) {
/* 3456 */       j = readUnsignedShort(i + 6);
/* 3457 */       i += 8;
/* 3458 */       while (j-- > 0) {
/* 3459 */         i += 6 + readInt(i + 2);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 3464 */     return i + 2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int[] readBootstrapMethodsAttribute(int paramInt) {
/* 3475 */     char[] arrayOfChar = new char[paramInt];
/* 3476 */     int i = a();
/* 3477 */     for (int j = readUnsignedShort(i - 2); j > 0; j--) {
/*      */       
/* 3479 */       String str = readUTF8(i, arrayOfChar);
/* 3480 */       int k = readInt(i + 2);
/* 3481 */       i += 6;
/* 3482 */       if ("BootstrapMethods".equals(str)) {
/*      */         
/* 3484 */         int[] arrayOfInt = new int[readUnsignedShort(i)];
/*      */         
/* 3486 */         i += 2;
/* 3487 */         for (j = 0; j < arrayOfInt.length; j++) {
/* 3488 */           arrayOfInt[j] = i;
/*      */ 
/*      */           
/* 3491 */           i += 4 + (
/* 3492 */             readUnsignedShort(i + 2) << 1);
/*      */         } 
/* 3494 */         return arrayOfInt;
/*      */       } 
/* 3496 */       i += k;
/*      */     } 
/* 3498 */     throw new IllegalArgumentException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Attribute readAttribute(Attribute[] paramArrayOfAttribute, String paramString, int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3, Label[] paramArrayOfLabel) {
/*      */     int i;
/*      */     byte b;
/* 3529 */     for (i = (paramArrayOfAttribute = paramArrayOfAttribute).length, b = 0; b < i; b++) {
/* 3530 */       Attribute attribute; if ((attribute = paramArrayOfAttribute[b]).type.equals(paramString)) {
/* 3531 */         return attribute.read(this, paramInt1, paramInt2, paramArrayOfchar, paramInt3, paramArrayOfLabel);
/*      */       }
/*      */     } 
/*      */     
/* 3535 */     return (new Attribute(paramString)).read(this, paramInt1, paramInt2, null, -1, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getItemCount() {
/* 3548 */     return this.cpInfoOffsets.length;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getItem(int paramInt) {
/* 3562 */     return this.cpInfoOffsets[paramInt];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxStringLength() {
/* 3573 */     return this.maxStringLength;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int readByte(int paramInt) {
/* 3584 */     return this.a[paramInt] & 0xFF;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int readUnsignedShort(int paramInt) {
/*      */     byte[] arrayOfByte;
/* 3596 */     return ((arrayOfByte = this.a)[paramInt] & 0xFF) << 8 | arrayOfByte[paramInt + 1] & 0xFF;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short readShort(int paramInt) {
/*      */     byte[] arrayOfByte;
/* 3608 */     return (short)(((arrayOfByte = this.a)[paramInt] & 0xFF) << 8 | arrayOfByte[paramInt + 1] & 0xFF);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int readInt(int paramInt) {
/*      */     byte[] arrayOfByte;
/* 3620 */     return ((arrayOfByte = this.a)[paramInt] & 0xFF) << 24 | (arrayOfByte[paramInt + 1] & 0xFF) << 16 | (arrayOfByte[paramInt + 2] & 0xFF) << 8 | arrayOfByte[paramInt + 3] & 0xFF;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long readLong(int paramInt) {
/* 3634 */     long l1 = readInt(paramInt);
/* 3635 */     long l2 = readInt(paramInt + 4) & 0xFFFFFFFFL;
/* 3636 */     return l1 << 32L | l2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String readUTF8(int paramInt, char[] paramArrayOfchar) {
/* 3652 */     int i = readUnsignedShort(paramInt);
/* 3653 */     if (paramInt == 0 || i == 0) {
/* 3654 */       return null;
/*      */     }
/* 3656 */     return a(i, paramArrayOfchar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final String a(int paramInt, char[] paramArrayOfchar) {
/*      */     String str;
/* 3670 */     if ((str = this.constantUtf8Values[paramInt]) != null) {
/* 3671 */       return str;
/*      */     }
/* 3673 */     int i = this.cpInfoOffsets[paramInt];
/* 3674 */     this.constantUtf8Values[paramInt] = 
/* 3675 */       readUtf(i + 2, readUnsignedShort(i), paramArrayOfchar); return readUtf(i + 2, readUnsignedShort(i), paramArrayOfchar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String readUtf(int paramInt1, int paramInt2, char[] paramArrayOfchar) {
/* 3688 */     int i = paramInt1;
/* 3689 */     paramInt1 += paramInt2;
/* 3690 */     paramInt2 = 0;
/* 3691 */     byte[] arrayOfByte = this.a;
/* 3692 */     while (i < paramInt1) {
/*      */       byte b;
/* 3694 */       if (((b = arrayOfByte[i++]) & 0x80) == 0) {
/* 3695 */         paramArrayOfchar[paramInt2++] = (char)(b & Byte.MAX_VALUE); continue;
/* 3696 */       }  if ((b & 0xE0) == 192) {
/* 3697 */         paramArrayOfchar[paramInt2++] = (char)(((b & 0x1F) << 6) + (arrayOfByte[i++] & 0x3F));
/*      */         continue;
/*      */       } 
/* 3700 */       paramArrayOfchar[paramInt2++] = (char)(((b & 0xF) << 12) + ((arrayOfByte[i++] & 0x3F) << 6) + (arrayOfByte[i++] & 0x3F));
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3707 */     return new String(paramArrayOfchar, 0, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String readStringish(int paramInt, char[] paramArrayOfchar) {
/* 3726 */     return readUTF8(this.cpInfoOffsets[readUnsignedShort(paramInt)], paramArrayOfchar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String readClass(int paramInt, char[] paramArrayOfchar) {
/* 3741 */     return readStringish(paramInt, paramArrayOfchar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String readModule(int paramInt, char[] paramArrayOfchar) {
/* 3756 */     return readStringish(paramInt, paramArrayOfchar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String readPackage(int paramInt, char[] paramArrayOfchar) {
/* 3771 */     return readStringish(paramInt, paramArrayOfchar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ConstantDynamic readConstantDynamic(int paramInt, char[] paramArrayOfchar) {
/*      */     ConstantDynamic constantDynamic;
/* 3786 */     if ((constantDynamic = this.constantDynamicValues[paramInt]) != null) {
/* 3787 */       return constantDynamic;
/*      */     }
/* 3789 */     int i = this.cpInfoOffsets[paramInt];
/* 3790 */     int j = this.cpInfoOffsets[readUnsignedShort(i + 2)];
/* 3791 */     String str2 = readUTF8(j, paramArrayOfchar);
/* 3792 */     String str1 = readUTF8(j + 2, paramArrayOfchar);
/* 3793 */     i = this.bootstrapMethodOffsets[readUnsignedShort(i)];
/* 3794 */     Handle handle = (Handle)readConst(readUnsignedShort(i), paramArrayOfchar);
/* 3795 */     Object[] arrayOfObject = new Object[readUnsignedShort(i + 2)];
/* 3796 */     i += 4;
/* 3797 */     for (byte b = 0; b < arrayOfObject.length; b++) {
/* 3798 */       arrayOfObject[b] = readConst(readUnsignedShort(i), paramArrayOfchar);
/* 3799 */       i += 2;
/*      */     } 
/* 3801 */     this.constantDynamicValues[paramInt] = new ConstantDynamic(str2, str1, handle, arrayOfObject); return new ConstantDynamic(str2, str1, handle, arrayOfObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object readConst(int paramInt, char[] paramArrayOfchar) {
/*      */     String str1;
/*      */     int j;
/*      */     String str2, str3;
/* 3820 */     int i = this.cpInfoOffsets[paramInt];
/* 3821 */     switch (this.a[i - 1]) {
/*      */       case 3:
/* 3823 */         return Integer.valueOf(readInt(i));
/*      */       case 4:
/* 3825 */         return Float.valueOf(Float.intBitsToFloat(readInt(i)));
/*      */       case 5:
/* 3827 */         return Long.valueOf(readLong(i));
/*      */       case 6:
/* 3829 */         return Double.valueOf(Double.longBitsToDouble(readLong(i)));
/*      */       case 7:
/* 3831 */         return Type.getObjectType(readUTF8(i, paramArrayOfchar));
/*      */       case 8:
/* 3833 */         return readUTF8(i, paramArrayOfchar);
/*      */       case 16:
/* 3835 */         return Type.getMethodType(readUTF8(i, paramArrayOfchar));
/*      */       case 15:
/* 3837 */         paramInt = readByte(i);
/* 3838 */         i = this.cpInfoOffsets[readUnsignedShort(i + 1)];
/* 3839 */         j = this.cpInfoOffsets[readUnsignedShort(i + 2)];
/* 3840 */         str2 = readClass(i, paramArrayOfchar);
/* 3841 */         str3 = readUTF8(j, paramArrayOfchar);
/* 3842 */         str1 = readUTF8(j + 2, paramArrayOfchar);
/* 3843 */         i = (this.a[i - 1] == 11) ? 1 : 0;
/*      */         
/* 3845 */         return new Handle(paramInt, str2, str3, str1, i);
/*      */       case 17:
/* 3847 */         return readConstantDynamic(paramInt, (char[])str1);
/*      */     } 
/* 3849 */     throw new IllegalArgumentException();
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\ClassReader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */