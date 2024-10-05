/*      */ package net.bytebuddy.jar.asm;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ClassWriter
/*      */   extends ClassVisitor
/*      */ {
/*      */   public static final int COMPUTE_MAXS = 1;
/*      */   public static final int COMPUTE_FRAMES = 2;
/*      */   private final int flags;
/*      */   private int version;
/*      */   private final SymbolTable symbolTable;
/*      */   private int accessFlags;
/*      */   private int thisClass;
/*      */   private int superClass;
/*      */   private int interfaceCount;
/*      */   private int[] interfaces;
/*      */   private FieldWriter firstField;
/*      */   private FieldWriter lastField;
/*      */   private MethodWriter firstMethod;
/*      */   private MethodWriter lastMethod;
/*      */   private int numberOfInnerClasses;
/*      */   private ByteVector innerClasses;
/*      */   private int enclosingClassIndex;
/*      */   private int enclosingMethodIndex;
/*      */   private int signatureIndex;
/*      */   private int sourceFileIndex;
/*      */   private ByteVector debugExtension;
/*      */   private AnnotationWriter lastRuntimeVisibleAnnotation;
/*      */   private AnnotationWriter lastRuntimeInvisibleAnnotation;
/*      */   private AnnotationWriter lastRuntimeVisibleTypeAnnotation;
/*      */   private AnnotationWriter lastRuntimeInvisibleTypeAnnotation;
/*      */   private ModuleWriter moduleWriter;
/*      */   private int nestHostClassIndex;
/*      */   private int numberOfNestMemberClasses;
/*      */   private ByteVector nestMemberClasses;
/*      */   private int numberOfPermittedSubclasses;
/*      */   private ByteVector permittedSubclasses;
/*      */   private RecordComponentWriter firstRecordComponent;
/*      */   private RecordComponentWriter lastRecordComponent;
/*      */   private Attribute firstAttribute;
/*      */   private int compute;
/*      */   
/*      */   public ClassWriter(int paramInt) {
/*  235 */     this(null, paramInt);
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
/*      */   public ClassWriter(ClassReader paramClassReader, int paramInt) {
/*  263 */     super(589824);
/*  264 */     this.flags = paramInt;
/*  265 */     this.symbolTable = (paramClassReader == null) ? new SymbolTable(this) : new SymbolTable(this, paramClassReader);
/*  266 */     if ((paramInt & 0x2) != 0) {
/*  267 */       this.compute = 4; return;
/*  268 */     }  if ((paramInt & 0x1) != 0) {
/*  269 */       this.compute = 1; return;
/*      */     } 
/*  271 */     this.compute = 0;
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
/*      */   public boolean hasFlags(int paramInt) {
/*  287 */     return ((this.flags & paramInt) == paramInt);
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
/*      */   public final void visit(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString) {
/*  302 */     this.version = paramInt1;
/*  303 */     this.accessFlags = paramInt2;
/*  304 */     this.thisClass = this.symbolTable.a(paramInt1 & 0xFFFF, paramString1);
/*  305 */     if (paramString2 != null) {
/*  306 */       this.signatureIndex = this.symbolTable.b(paramString2);
/*      */     }
/*  308 */     this.superClass = (paramString3 == null) ? 0 : (this.symbolTable.a(paramString3)).a;
/*  309 */     if (paramArrayOfString != null && paramArrayOfString.length > 0) {
/*  310 */       this.interfaceCount = paramArrayOfString.length;
/*  311 */       this.interfaces = new int[this.interfaceCount];
/*  312 */       for (paramInt2 = 0; paramInt2 < this.interfaceCount; paramInt2++) {
/*  313 */         this.interfaces[paramInt2] = (this.symbolTable.a(paramArrayOfString[paramInt2])).a;
/*      */       }
/*      */     } 
/*  316 */     if (this.compute == 1 && (paramInt1 & 0xFFFF) >= 51) {
/*  317 */       this.compute = 2;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public final void visitSource(String paramString1, String paramString2) {
/*  323 */     if (paramString1 != null) {
/*  324 */       this.sourceFileIndex = this.symbolTable.b(paramString1);
/*      */     }
/*  326 */     if (paramString2 != null) {
/*  327 */       this.debugExtension = (new ByteVector()).a(paramString2, 0, 2147483647);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final ModuleVisitor visitModule(String paramString1, int paramInt, String paramString2) {
/*  334 */     return this
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  339 */       .moduleWriter = new ModuleWriter(this.symbolTable, (this.symbolTable.d(paramString1)).a, paramInt, (paramString2 == null) ? 0 : this.symbolTable.b(paramString2));
/*      */   }
/*      */ 
/*      */   
/*      */   public final void visitNestHost(String paramString) {
/*  344 */     this.nestHostClassIndex = (this.symbolTable.a(paramString)).a;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void visitOuterClass(String paramString1, String paramString2, String paramString3) {
/*  350 */     this.enclosingClassIndex = (this.symbolTable.a(paramString1)).a;
/*  351 */     if (paramString2 != null && paramString3 != null) {
/*  352 */       this.enclosingMethodIndex = this.symbolTable.a(paramString2, paramString3);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public final AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean) {
/*  358 */     if (paramBoolean) {
/*  359 */       return this
/*  360 */         .lastRuntimeVisibleAnnotation = AnnotationWriter.a(this.symbolTable, paramString, this.lastRuntimeVisibleAnnotation);
/*      */     }
/*  362 */     return this
/*  363 */       .lastRuntimeInvisibleAnnotation = AnnotationWriter.a(this.symbolTable, paramString, this.lastRuntimeInvisibleAnnotation);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final AnnotationVisitor visitTypeAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
/*  370 */     if (paramBoolean) {
/*  371 */       return this
/*  372 */         .lastRuntimeVisibleTypeAnnotation = AnnotationWriter.a(this.symbolTable, paramInt, paramTypePath, paramString, this.lastRuntimeVisibleTypeAnnotation);
/*      */     }
/*      */     
/*  375 */     return this
/*  376 */       .lastRuntimeInvisibleTypeAnnotation = AnnotationWriter.a(this.symbolTable, paramInt, paramTypePath, paramString, this.lastRuntimeInvisibleTypeAnnotation);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void visitAttribute(Attribute paramAttribute) {
/*  384 */     paramAttribute.a = this.firstAttribute;
/*  385 */     this.firstAttribute = paramAttribute;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void visitNestMember(String paramString) {
/*  390 */     if (this.nestMemberClasses == null) {
/*  391 */       this.nestMemberClasses = new ByteVector();
/*      */     }
/*  393 */     this.numberOfNestMemberClasses++;
/*  394 */     this.nestMemberClasses.putShort((this.symbolTable.a(paramString)).a);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void visitPermittedSubclass(String paramString) {
/*  399 */     if (this.permittedSubclasses == null) {
/*  400 */       this.permittedSubclasses = new ByteVector();
/*      */     }
/*  402 */     this.numberOfPermittedSubclasses++;
/*  403 */     this.permittedSubclasses.putShort((this.symbolTable.a(paramString)).a);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void visitInnerClass(String paramString1, String paramString2, String paramString3, int paramInt) {
/*  409 */     if (this.innerClasses == null) {
/*  410 */       this.innerClasses = new ByteVector();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     Symbol symbol;
/*      */ 
/*      */ 
/*      */     
/*  419 */     if ((symbol = this.symbolTable.a(paramString1)).g == 0) {
/*  420 */       this.numberOfInnerClasses++;
/*  421 */       this.innerClasses.putShort(symbol.a);
/*  422 */       this.innerClasses.putShort((paramString2 == null) ? 0 : (this.symbolTable.a(paramString2)).a);
/*  423 */       this.innerClasses.putShort((paramString3 == null) ? 0 : this.symbolTable.b(paramString3));
/*  424 */       this.innerClasses.putShort(paramInt);
/*  425 */       symbol.g = this.numberOfInnerClasses;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final RecordComponentVisitor visitRecordComponent(String paramString1, String paramString2, String paramString3) {
/*  434 */     RecordComponentWriter recordComponentWriter = new RecordComponentWriter(this.symbolTable, paramString1, paramString2, paramString3);
/*      */     
/*  436 */     if (this.firstRecordComponent == null) {
/*  437 */       this.firstRecordComponent = recordComponentWriter;
/*      */     } else {
/*  439 */       this.lastRecordComponent.delegate = recordComponentWriter;
/*      */     } 
/*  441 */     return this.lastRecordComponent = recordComponentWriter;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final FieldVisitor visitField(int paramInt, String paramString1, String paramString2, String paramString3, Object paramObject) {
/*  451 */     FieldWriter fieldWriter = new FieldWriter(this.symbolTable, paramInt, paramString1, paramString2, paramString3, paramObject);
/*      */     
/*  453 */     if (this.firstField == null) {
/*  454 */       this.firstField = fieldWriter;
/*      */     } else {
/*  456 */       this.lastField.fv = fieldWriter;
/*      */     } 
/*  458 */     return this.lastField = fieldWriter;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final MethodVisitor visitMethod(int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString) {
/*  468 */     MethodWriter methodWriter = new MethodWriter(this.symbolTable, paramInt, paramString1, paramString2, paramString3, paramArrayOfString, this.compute);
/*      */     
/*  470 */     if (this.firstMethod == null) {
/*  471 */       this.firstMethod = methodWriter;
/*      */     } else {
/*  473 */       this.lastMethod.mv = methodWriter;
/*      */     } 
/*  475 */     return this.lastMethod = methodWriter;
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
/*      */   public final void visitEnd() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] toByteArray() {
/*      */     boolean bool1, bool2;
/*  499 */     int i = 24 + 2 * this.interfaceCount;
/*  500 */     byte b1 = 0;
/*  501 */     FieldWriter fieldWriter2 = this.firstField;
/*  502 */     while (fieldWriter2 != null) {
/*  503 */       b1++;
/*  504 */       i += fieldWriter2.a();
/*  505 */       fieldWriter2 = (FieldWriter)fieldWriter2.fv;
/*      */     } 
/*  507 */     byte b2 = 0;
/*  508 */     MethodWriter methodWriter2 = this.firstMethod;
/*  509 */     while (methodWriter2 != null) {
/*  510 */       b2++;
/*  511 */       i += methodWriter2.d();
/*  512 */       methodWriter2 = (MethodWriter)methodWriter2.mv;
/*      */     } 
/*      */ 
/*      */     
/*  516 */     int k = 0;
/*  517 */     if (this.innerClasses != null) {
/*  518 */       k++;
/*  519 */       i += 8 + this.innerClasses.b;
/*  520 */       this.symbolTable.b("InnerClasses");
/*      */     } 
/*  522 */     if (this.enclosingClassIndex != 0) {
/*  523 */       k++;
/*  524 */       i += 10;
/*  525 */       this.symbolTable.b("EnclosingMethod");
/*      */     } 
/*  527 */     if ((this.accessFlags & 0x1000) != 0 && (this.version & 0xFFFF) < 49) {
/*  528 */       k++;
/*  529 */       i += 6;
/*  530 */       this.symbolTable.b("Synthetic");
/*      */     } 
/*  532 */     if (this.signatureIndex != 0) {
/*  533 */       k++;
/*  534 */       i += 8;
/*  535 */       this.symbolTable.b("Signature");
/*      */     } 
/*  537 */     if (this.sourceFileIndex != 0) {
/*  538 */       k++;
/*  539 */       i += 8;
/*  540 */       this.symbolTable.b("SourceFile");
/*      */     } 
/*  542 */     if (this.debugExtension != null) {
/*  543 */       k++;
/*  544 */       i += 6 + this.debugExtension.b;
/*  545 */       this.symbolTable.b("SourceDebugExtension");
/*      */     } 
/*  547 */     if ((this.accessFlags & 0x20000) != 0) {
/*  548 */       k++;
/*  549 */       i += 6;
/*  550 */       this.symbolTable.b("Deprecated");
/*      */     } 
/*  552 */     if (this.lastRuntimeVisibleAnnotation != null) {
/*  553 */       k++;
/*  554 */       i += this.lastRuntimeVisibleAnnotation
/*  555 */         .a("RuntimeVisibleAnnotations");
/*      */     } 
/*      */     
/*  558 */     if (this.lastRuntimeInvisibleAnnotation != null) {
/*  559 */       k++;
/*  560 */       i += this.lastRuntimeInvisibleAnnotation
/*  561 */         .a("RuntimeInvisibleAnnotations");
/*      */     } 
/*      */     
/*  564 */     if (this.lastRuntimeVisibleTypeAnnotation != null) {
/*  565 */       k++;
/*  566 */       i += this.lastRuntimeVisibleTypeAnnotation
/*  567 */         .a("RuntimeVisibleTypeAnnotations");
/*      */     } 
/*      */     
/*  570 */     if (this.lastRuntimeInvisibleTypeAnnotation != null) {
/*  571 */       k++;
/*  572 */       i += this.lastRuntimeInvisibleTypeAnnotation
/*  573 */         .a("RuntimeInvisibleTypeAnnotations");
/*      */     } 
/*      */     
/*  576 */     if (this.symbolTable.f() > 0) {
/*  577 */       k++;
/*  578 */       i += this.symbolTable.f();
/*      */     } 
/*  580 */     if (this.moduleWriter != null) {
/*  581 */       k += this.moduleWriter.a();
/*  582 */       i += this.moduleWriter.b();
/*      */     } 
/*  584 */     if (this.nestHostClassIndex != 0) {
/*  585 */       k++;
/*  586 */       i += 8;
/*  587 */       this.symbolTable.b("NestHost");
/*      */     } 
/*  589 */     if (this.nestMemberClasses != null) {
/*  590 */       k++;
/*  591 */       i += 8 + this.nestMemberClasses.b;
/*  592 */       this.symbolTable.b("NestMembers");
/*      */     } 
/*  594 */     if (this.permittedSubclasses != null) {
/*  595 */       k++;
/*  596 */       i += 8 + this.permittedSubclasses.b;
/*  597 */       this.symbolTable.b("PermittedSubclasses");
/*      */     } 
/*  599 */     byte b3 = 0;
/*  600 */     int m = 0;
/*  601 */     if ((this.accessFlags & 0x10000) != 0 || this.firstRecordComponent != null) {
/*  602 */       RecordComponentWriter recordComponentWriter = this.firstRecordComponent;
/*  603 */       while (recordComponentWriter != null) {
/*  604 */         b3++;
/*  605 */         m += recordComponentWriter.a();
/*  606 */         recordComponentWriter = (RecordComponentWriter)recordComponentWriter.delegate;
/*      */       } 
/*  608 */       k++;
/*  609 */       i += m + 8;
/*  610 */       this.symbolTable.b("Record");
/*      */     } 
/*  612 */     if (this.firstAttribute != null) {
/*  613 */       k += this.firstAttribute.a();
/*  614 */       i += this.firstAttribute.a(this.symbolTable);
/*      */     } 
/*      */ 
/*      */     
/*  618 */     i += this.symbolTable.e();
/*      */     int j;
/*  620 */     if ((j = this.symbolTable.d()) > 65535) {
/*  621 */       throw new ClassTooLargeException(this.symbolTable.c(), j);
/*      */     }
/*      */ 
/*      */     
/*      */     ByteVector byteVector;
/*      */     
/*  627 */     (byteVector = new ByteVector(i)).putInt(-889275714).putInt(this.version);
/*  628 */     this.symbolTable.a(byteVector);
/*  629 */     j = ((this.version & 0xFFFF) < 49) ? 4096 : 0;
/*  630 */     byteVector.putShort(this.accessFlags & (j ^ 0xFFFFFFFF)).putShort(this.thisClass).putShort(this.superClass);
/*  631 */     byteVector.putShort(this.interfaceCount); byte b4;
/*  632 */     for (b4 = 0; b4 < this.interfaceCount; b4++) {
/*  633 */       byteVector.putShort(this.interfaces[b4]);
/*      */     }
/*  635 */     byteVector.putShort(b1);
/*  636 */     FieldWriter fieldWriter1 = this.firstField;
/*  637 */     while (fieldWriter1 != null) {
/*  638 */       fieldWriter1.a(byteVector);
/*  639 */       fieldWriter1 = (FieldWriter)fieldWriter1.fv;
/*      */     } 
/*  641 */     byteVector.putShort(b2);
/*  642 */     b4 = 0;
/*  643 */     b1 = 0;
/*  644 */     MethodWriter methodWriter1 = this.firstMethod;
/*  645 */     while (methodWriter1 != null) {
/*  646 */       bool2 = b4 | methodWriter1.a();
/*  647 */       bool1 = b1 | methodWriter1.b();
/*  648 */       methodWriter1.a(byteVector);
/*  649 */       methodWriter1 = (MethodWriter)methodWriter1.mv;
/*      */     } 
/*      */     
/*  652 */     byteVector.putShort(k);
/*  653 */     if (this.innerClasses != null) {
/*  654 */       byteVector
/*  655 */         .putShort(this.symbolTable.b("InnerClasses"))
/*  656 */         .putInt(this.innerClasses.b + 2)
/*  657 */         .putShort(this.numberOfInnerClasses)
/*  658 */         .putByteArray(this.innerClasses.a, 0, this.innerClasses.b);
/*      */     }
/*  660 */     if (this.enclosingClassIndex != 0) {
/*  661 */       byteVector
/*  662 */         .putShort(this.symbolTable.b("EnclosingMethod"))
/*  663 */         .putInt(4)
/*  664 */         .putShort(this.enclosingClassIndex)
/*  665 */         .putShort(this.enclosingMethodIndex);
/*      */     }
/*  667 */     if ((this.accessFlags & 0x1000) != 0 && (this.version & 0xFFFF) < 49) {
/*  668 */       byteVector.putShort(this.symbolTable.b("Synthetic")).putInt(0);
/*      */     }
/*  670 */     if (this.signatureIndex != 0) {
/*  671 */       byteVector
/*  672 */         .putShort(this.symbolTable.b("Signature"))
/*  673 */         .putInt(2)
/*  674 */         .putShort(this.signatureIndex);
/*      */     }
/*  676 */     if (this.sourceFileIndex != 0) {
/*  677 */       byteVector
/*  678 */         .putShort(this.symbolTable.b("SourceFile"))
/*  679 */         .putInt(2)
/*  680 */         .putShort(this.sourceFileIndex);
/*      */     }
/*  682 */     if (this.debugExtension != null) {
/*  683 */       int n = this.debugExtension.b;
/*  684 */       byteVector
/*  685 */         .putShort(this.symbolTable.b("SourceDebugExtension"))
/*  686 */         .putInt(n)
/*  687 */         .putByteArray(this.debugExtension.a, 0, n);
/*      */     } 
/*  689 */     if ((this.accessFlags & 0x20000) != 0) {
/*  690 */       byteVector.putShort(this.symbolTable.b("Deprecated")).putInt(0);
/*      */     }
/*  692 */     AnnotationWriter.a(this.symbolTable, this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation, byteVector);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  699 */     this.symbolTable.b(byteVector);
/*  700 */     if (this.moduleWriter != null) {
/*  701 */       this.moduleWriter.a(byteVector);
/*      */     }
/*  703 */     if (this.nestHostClassIndex != 0) {
/*  704 */       byteVector
/*  705 */         .putShort(this.symbolTable.b("NestHost"))
/*  706 */         .putInt(2)
/*  707 */         .putShort(this.nestHostClassIndex);
/*      */     }
/*  709 */     if (this.nestMemberClasses != null) {
/*  710 */       byteVector
/*  711 */         .putShort(this.symbolTable.b("NestMembers"))
/*  712 */         .putInt(this.nestMemberClasses.b + 2)
/*  713 */         .putShort(this.numberOfNestMemberClasses)
/*  714 */         .putByteArray(this.nestMemberClasses.a, 0, this.nestMemberClasses.b);
/*      */     }
/*  716 */     if (this.permittedSubclasses != null) {
/*  717 */       byteVector
/*  718 */         .putShort(this.symbolTable.b("PermittedSubclasses"))
/*  719 */         .putInt(this.permittedSubclasses.b + 2)
/*  720 */         .putShort(this.numberOfPermittedSubclasses)
/*  721 */         .putByteArray(this.permittedSubclasses.a, 0, this.permittedSubclasses.b);
/*      */     }
/*  723 */     if ((this.accessFlags & 0x10000) != 0 || this.firstRecordComponent != null) {
/*  724 */       byteVector
/*  725 */         .putShort(this.symbolTable.b("Record"))
/*  726 */         .putInt(m + 2)
/*  727 */         .putShort(b3);
/*  728 */       RecordComponentWriter recordComponentWriter = this.firstRecordComponent;
/*  729 */       while (recordComponentWriter != null) {
/*  730 */         recordComponentWriter.a(byteVector);
/*  731 */         recordComponentWriter = (RecordComponentWriter)recordComponentWriter.delegate;
/*      */       } 
/*      */     } 
/*  734 */     if (this.firstAttribute != null) {
/*  735 */       this.firstAttribute.a(this.symbolTable, byteVector);
/*      */     }
/*      */ 
/*      */     
/*  739 */     if (bool1) {
/*  740 */       return replaceAsmInstructions(byteVector.a, bool2);
/*      */     }
/*  742 */     return byteVector.a;
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
/*      */   private byte[] replaceAsmInstructions(byte[] paramArrayOfbyte, boolean paramBoolean) {
/*  757 */     Attribute[] arrayOfAttribute = getAttributePrototypes();
/*  758 */     this.firstField = null;
/*  759 */     this.lastField = null;
/*  760 */     this.firstMethod = null;
/*  761 */     this.lastMethod = null;
/*  762 */     this.lastRuntimeVisibleAnnotation = null;
/*  763 */     this.lastRuntimeInvisibleAnnotation = null;
/*  764 */     this.lastRuntimeVisibleTypeAnnotation = null;
/*  765 */     this.lastRuntimeInvisibleTypeAnnotation = null;
/*  766 */     this.moduleWriter = null;
/*  767 */     this.nestHostClassIndex = 0;
/*  768 */     this.numberOfNestMemberClasses = 0;
/*  769 */     this.nestMemberClasses = null;
/*  770 */     this.numberOfPermittedSubclasses = 0;
/*  771 */     this.permittedSubclasses = null;
/*  772 */     this.firstRecordComponent = null;
/*  773 */     this.lastRecordComponent = null;
/*  774 */     this.firstAttribute = null;
/*  775 */     this.compute = paramBoolean ? 3 : 0;
/*  776 */     (new ClassReader(paramArrayOfbyte, 0, false))
/*  777 */       .accept(this, arrayOfAttribute, (
/*      */ 
/*      */         
/*  780 */         paramBoolean ? 8 : 0) | 0x100);
/*  781 */     return toByteArray();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Attribute[] getAttributePrototypes() {
/*      */     Attribute.Set set;
/*  791 */     (set = new Attribute.Set()).a(this.firstAttribute);
/*  792 */     FieldWriter fieldWriter = this.firstField;
/*  793 */     while (fieldWriter != null) {
/*  794 */       fieldWriter.a(set);
/*  795 */       fieldWriter = (FieldWriter)fieldWriter.fv;
/*      */     } 
/*  797 */     MethodWriter methodWriter = this.firstMethod;
/*  798 */     while (methodWriter != null) {
/*  799 */       methodWriter.a(set);
/*  800 */       methodWriter = (MethodWriter)methodWriter.mv;
/*      */     } 
/*  802 */     RecordComponentWriter recordComponentWriter = this.firstRecordComponent;
/*  803 */     while (recordComponentWriter != null) {
/*  804 */       recordComponentWriter.a(set);
/*  805 */       recordComponentWriter = (RecordComponentWriter)recordComponentWriter.delegate;
/*      */     } 
/*  807 */     return set.a();
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
/*      */   public int newConst(Object paramObject) {
/*  824 */     return (this.symbolTable.a(paramObject)).a;
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
/*      */   public int newUTF8(String paramString) {
/*  837 */     return this.symbolTable.b(paramString);
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
/*      */   public int newClass(String paramString) {
/*  849 */     return (this.symbolTable.a(paramString)).a;
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
/*      */   public int newMethodType(String paramString) {
/*  861 */     return (this.symbolTable.c(paramString)).a;
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
/*      */   public int newModule(String paramString) {
/*  873 */     return (this.symbolTable.d(paramString)).a;
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
/*      */   public int newPackage(String paramString) {
/*  885 */     return (this.symbolTable.e(paramString)).a;
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
/*      */   @Deprecated
/*      */   public int newHandle(int paramInt, String paramString1, String paramString2, String paramString3) {
/*  908 */     return newHandle(paramInt, paramString1, paramString2, paramString3, (paramInt == 9));
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
/*      */   public int newHandle(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
/*  933 */     return (this.symbolTable.a(paramInt, paramString1, paramString2, paramString3, paramBoolean)).a;
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
/*      */   public int newConstantDynamic(String paramString1, String paramString2, Handle paramHandle, Object... paramVarArgs) {
/*  952 */     return (this.symbolTable.a(paramString1, paramString2, paramHandle, paramVarArgs)).a;
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
/*      */   public int newInvokeDynamic(String paramString1, String paramString2, Handle paramHandle, Object... paramVarArgs) {
/*  973 */     return (this.symbolTable.b(paramString1, paramString2, paramHandle, paramVarArgs)).a;
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
/*      */   public int newField(String paramString1, String paramString2, String paramString3) {
/*  989 */     return (this.symbolTable.a(paramString1, paramString2, paramString3)).a;
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
/*      */   public int newMethod(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
/* 1006 */     return (this.symbolTable.a(paramString1, paramString2, paramString3, paramBoolean)).a;
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
/*      */   public int newNameType(String paramString1, String paramString2) {
/* 1019 */     return this.symbolTable.a(paramString1, paramString2);
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
/*      */   protected String getCommonSuperClass(String paramString1, String paramString2) {
/*      */     Class<?> clazz1;
/* 1040 */     ClassLoader classLoader = getClassLoader();
/*      */     
/*      */     try {
/* 1043 */       clazz2 = Class.forName(paramString1.replace('/', '.'), false, classLoader);
/* 1044 */     } catch (ClassNotFoundException classNotFoundException2) {
/* 1045 */       throw new TypeNotPresentException(paramString1, classNotFoundException2);
/*      */     } 
/*      */     
/*      */     try {
/* 1049 */       clazz1 = Class.forName(paramString2.replace('/', '.'), false, (ClassLoader)classNotFoundException2);
/* 1050 */     } catch (ClassNotFoundException classNotFoundException1) {
/* 1051 */       throw new TypeNotPresentException(paramString2, classNotFoundException1);
/*      */     } 
/* 1053 */     if (clazz2.isAssignableFrom(clazz1)) {
/* 1054 */       return (String)classNotFoundException1;
/*      */     }
/* 1056 */     if (clazz1.isAssignableFrom(clazz2)) {
/* 1057 */       return paramString2;
/*      */     }
/* 1059 */     if (clazz2.isInterface() || clazz1.isInterface())
/* 1060 */       return "java/lang/Object"; 
/*      */     Class<?> clazz2;
/*      */     do {
/*      */     
/* 1064 */     } while (!(clazz2 = clazz2.getSuperclass()).isAssignableFrom(clazz1));
/* 1065 */     return clazz2.getName().replace('.', '/');
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
/*      */   protected ClassLoader getClassLoader() {
/* 1077 */     return getClass().getClassLoader();
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\ClassWriter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */