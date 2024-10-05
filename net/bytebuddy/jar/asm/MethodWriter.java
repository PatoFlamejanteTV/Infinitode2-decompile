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
/*      */ final class MethodWriter
/*      */   extends MethodVisitor
/*      */ {
/*      */   private static final int NA = 0;
/*   81 */   private static final int[] STACK_SIZE_DELTA = new int[] { 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 0, 0, 1, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, -4, -3, -4, -3, -3, -3, -3, -1, -2, 1, 1, 1, 2, 2, 2, 0, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -2, -1, -2, -1, -2, 0, 1, 0, 1, -1, -1, 0, 0, 1, 1, -1, 0, -1, 0, 0, 0, -3, -1, -1, -3, -3, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -2, 0, 1, 0, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, -1, -1, 0, 0 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final SymbolTable symbolTable;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final int accessFlags;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final int nameIndex;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final int descriptorIndex;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final String descriptor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int maxStack;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int maxLocals;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  320 */   private final ByteVector code = new ByteVector();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Handler firstHandler;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Handler lastHandler;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int lineNumberTableLength;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ByteVector lineNumberTable;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int localVariableTableLength;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ByteVector localVariableTable;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int localVariableTypeTableLength;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ByteVector localVariableTypeTable;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int stackMapTableNumberOfEntries;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ByteVector stackMapTableEntries;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AnnotationWriter lastCodeRuntimeVisibleTypeAnnotation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AnnotationWriter lastCodeRuntimeInvisibleTypeAnnotation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Attribute firstCodeAttribute;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final int numberOfExceptions;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final int[] exceptionIndexTable;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final int signatureIndex;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AnnotationWriter lastRuntimeVisibleAnnotation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AnnotationWriter lastRuntimeInvisibleAnnotation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int visibleAnnotableParameterCount;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AnnotationWriter[] lastRuntimeVisibleParameterAnnotations;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int invisibleAnnotableParameterCount;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AnnotationWriter[] lastRuntimeInvisibleParameterAnnotations;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AnnotationWriter lastRuntimeVisibleTypeAnnotation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AnnotationWriter lastRuntimeInvisibleTypeAnnotation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ByteVector defaultValue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int parametersCount;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ByteVector parameters;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Attribute firstAttribute;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final int compute;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Label firstBasicBlock;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Label lastBasicBlock;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Label currentBasicBlock;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int relativeStackSize;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int maxRelativeStackSize;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int currentLocals;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int previousFrameOffset;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int[] previousFrame;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int[] currentFrame;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean hasSubroutines;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean hasAsmInstructions;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int lastBytecodeOffset;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int sourceOffset;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int sourceLength;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   MethodWriter(SymbolTable paramSymbolTable, int paramInt1, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, int paramInt2) {
/*  596 */     super(589824);
/*  597 */     this.symbolTable = paramSymbolTable;
/*  598 */     this.accessFlags = "<init>".equals(paramString1) ? (paramInt1 | 0x40000) : paramInt1;
/*  599 */     this.nameIndex = paramSymbolTable.b(paramString1);
/*  600 */     this.name = paramString1;
/*  601 */     this.descriptorIndex = paramSymbolTable.b(paramString2);
/*  602 */     this.descriptor = paramString2;
/*  603 */     this.signatureIndex = (paramString3 == null) ? 0 : paramSymbolTable.b(paramString3);
/*  604 */     if (paramArrayOfString != null && paramArrayOfString.length > 0) {
/*  605 */       this.numberOfExceptions = paramArrayOfString.length;
/*  606 */       this.exceptionIndexTable = new int[this.numberOfExceptions];
/*  607 */       for (byte b = 0; b < this.numberOfExceptions; b++) {
/*  608 */         this.exceptionIndexTable[b] = (paramSymbolTable.a(paramArrayOfString[b])).a;
/*      */       }
/*      */     } else {
/*  611 */       this.numberOfExceptions = 0;
/*  612 */       this.exceptionIndexTable = null;
/*      */     } 
/*  614 */     this.compute = paramInt2;
/*  615 */     if (paramInt2 != 0) {
/*      */       
/*  617 */       int i = Type.getArgumentsAndReturnSizes(paramString2) >> 2;
/*  618 */       if ((paramInt1 & 0x8) != 0) {
/*  619 */         i--;
/*      */       }
/*  621 */       this.maxLocals = i;
/*  622 */       this.currentLocals = i;
/*      */       
/*  624 */       this.firstBasicBlock = new Label();
/*  625 */       visitLabel(this.firstBasicBlock);
/*      */     } 
/*      */   }
/*      */   
/*      */   final boolean a() {
/*  630 */     return (this.stackMapTableNumberOfEntries > 0);
/*      */   }
/*      */   
/*      */   final boolean b() {
/*  634 */     return this.hasAsmInstructions;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void visitParameter(String paramString, int paramInt) {
/*  643 */     if (this.parameters == null) {
/*  644 */       this.parameters = new ByteVector();
/*      */     }
/*  646 */     this.parametersCount++;
/*  647 */     this.parameters.putShort((paramString == null) ? 0 : this.symbolTable.b(paramString)).putShort(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public final AnnotationVisitor visitAnnotationDefault() {
/*  652 */     this.defaultValue = new ByteVector();
/*  653 */     return new AnnotationWriter(this.symbolTable, false, this.defaultValue, null);
/*      */   }
/*      */ 
/*      */   
/*      */   public final AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean) {
/*  658 */     if (paramBoolean) {
/*  659 */       return this
/*  660 */         .lastRuntimeVisibleAnnotation = AnnotationWriter.a(this.symbolTable, paramString, this.lastRuntimeVisibleAnnotation);
/*      */     }
/*  662 */     return this
/*  663 */       .lastRuntimeInvisibleAnnotation = AnnotationWriter.a(this.symbolTable, paramString, this.lastRuntimeInvisibleAnnotation);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final AnnotationVisitor visitTypeAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
/*  670 */     if (paramBoolean) {
/*  671 */       return this
/*  672 */         .lastRuntimeVisibleTypeAnnotation = AnnotationWriter.a(this.symbolTable, paramInt, paramTypePath, paramString, this.lastRuntimeVisibleTypeAnnotation);
/*      */     }
/*      */     
/*  675 */     return this
/*  676 */       .lastRuntimeInvisibleTypeAnnotation = AnnotationWriter.a(this.symbolTable, paramInt, paramTypePath, paramString, this.lastRuntimeInvisibleTypeAnnotation);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void visitAnnotableParameterCount(int paramInt, boolean paramBoolean) {
/*  683 */     if (paramBoolean) {
/*  684 */       this.visibleAnnotableParameterCount = paramInt; return;
/*      */     } 
/*  686 */     this.invisibleAnnotableParameterCount = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final AnnotationVisitor visitParameterAnnotation(int paramInt, String paramString, boolean paramBoolean) {
/*  693 */     if (paramBoolean) {
/*  694 */       if (this.lastRuntimeVisibleParameterAnnotations == null) {
/*  695 */         this
/*  696 */           .lastRuntimeVisibleParameterAnnotations = new AnnotationWriter[(Type.getArgumentTypes(this.descriptor)).length];
/*      */       }
/*  698 */       this.lastRuntimeVisibleParameterAnnotations[paramInt] = 
/*  699 */         AnnotationWriter.a(this.symbolTable, paramString, this.lastRuntimeVisibleParameterAnnotations[paramInt]); return AnnotationWriter.a(this.symbolTable, paramString, this.lastRuntimeVisibleParameterAnnotations[paramInt]);
/*      */     } 
/*      */     
/*  702 */     if (this.lastRuntimeInvisibleParameterAnnotations == null) {
/*  703 */       this
/*  704 */         .lastRuntimeInvisibleParameterAnnotations = new AnnotationWriter[(Type.getArgumentTypes(this.descriptor)).length];
/*      */     }
/*  706 */     this.lastRuntimeInvisibleParameterAnnotations[paramInt] = 
/*  707 */       AnnotationWriter.a(this.symbolTable, paramString, this.lastRuntimeInvisibleParameterAnnotations[paramInt]); return AnnotationWriter.a(this.symbolTable, paramString, this.lastRuntimeInvisibleParameterAnnotations[paramInt]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void visitAttribute(Attribute paramAttribute) {
/*  717 */     if (paramAttribute.isCodeAttribute()) {
/*  718 */       paramAttribute.a = this.firstCodeAttribute;
/*  719 */       this.firstCodeAttribute = paramAttribute; return;
/*      */     } 
/*  721 */     paramAttribute.a = this.firstAttribute;
/*  722 */     this.firstAttribute = paramAttribute;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void visitCode() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void visitFrame(int paramInt1, int paramInt2, Object[] paramArrayOfObject1, int paramInt3, Object[] paramArrayOfObject2) {
/*  738 */     if (this.compute == 4) {
/*      */       return;
/*      */     }
/*      */     
/*  742 */     if (this.compute == 3) {
/*  743 */       if (this.currentBasicBlock.h == null) {
/*      */ 
/*      */ 
/*      */         
/*  747 */         this.currentBasicBlock.h = new CurrentFrame(this.currentBasicBlock);
/*  748 */         this.currentBasicBlock.h.a(this.symbolTable, this.accessFlags, this.descriptor, paramInt2);
/*      */         
/*  750 */         this.currentBasicBlock.h.a(this);
/*      */       } else {
/*  752 */         if (paramInt1 == -1) {
/*  753 */           this.currentBasicBlock.h.a(this.symbolTable, paramInt2, paramArrayOfObject1, paramInt3, paramArrayOfObject2);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  759 */         this.currentBasicBlock.h.a(this);
/*      */       } 
/*  761 */     } else if (paramInt1 == -1) {
/*  762 */       if (this.previousFrame == null) {
/*  763 */         int j = Type.getArgumentsAndReturnSizes(this.descriptor) >> 2;
/*      */         Frame frame;
/*  765 */         (frame = new Frame(new Label())).a(this.symbolTable, this.accessFlags, this.descriptor, j);
/*      */         
/*  767 */         frame.a(this);
/*      */       } 
/*  769 */       this.currentLocals = paramInt2;
/*  770 */       int i = a(this.code.b, paramInt2, paramInt3);
/*  771 */       for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
/*  772 */         this.currentFrame[i++] = Frame.a(this.symbolTable, paramArrayOfObject1[paramInt1]);
/*      */       }
/*  774 */       for (paramInt1 = 0; paramInt1 < paramInt3; paramInt1++) {
/*  775 */         this.currentFrame[i++] = Frame.a(this.symbolTable, paramArrayOfObject2[paramInt1]);
/*      */       }
/*  777 */       c();
/*      */     } else {
/*  779 */       int i; if (this.symbolTable.b() < 50) {
/*  780 */         throw new IllegalArgumentException("Class versions V1_5 or less must use F_NEW frames.");
/*      */       }
/*      */       
/*  783 */       if (this.stackMapTableEntries == null) {
/*  784 */         this.stackMapTableEntries = new ByteVector();
/*  785 */         i = this.code.b;
/*      */       
/*      */       }
/*  788 */       else if ((i = this.code.b - this.previousFrameOffset - 1) < 0) {
/*  789 */         if (paramInt1 == 3) {
/*      */           return;
/*      */         }
/*  792 */         throw new IllegalStateException();
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  797 */       switch (paramInt1) {
/*      */         case 0:
/*  799 */           this.currentLocals = paramInt2;
/*  800 */           this.stackMapTableEntries.putByte(255).putShort(i).putShort(paramInt2);
/*  801 */           for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
/*  802 */             putFrameType(paramArrayOfObject1[paramInt1]);
/*      */           }
/*  804 */           this.stackMapTableEntries.putShort(paramInt3);
/*  805 */           for (paramInt1 = 0; paramInt1 < paramInt3; paramInt1++) {
/*  806 */             putFrameType(paramArrayOfObject2[paramInt1]);
/*      */           }
/*      */           break;
/*      */         case 1:
/*  810 */           this.currentLocals += paramInt2;
/*  811 */           this.stackMapTableEntries.putByte(paramInt2 + 251).putShort(i);
/*  812 */           for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
/*  813 */             putFrameType(paramArrayOfObject1[paramInt1]);
/*      */           }
/*      */           break;
/*      */         case 2:
/*  817 */           this.currentLocals -= paramInt2;
/*  818 */           this.stackMapTableEntries.putByte(251 - paramInt2).putShort(i);
/*      */           break;
/*      */         case 3:
/*  821 */           if (i < 64) {
/*  822 */             this.stackMapTableEntries.putByte(i); break;
/*      */           } 
/*  824 */           this.stackMapTableEntries.putByte(251).putShort(i);
/*      */           break;
/*      */         
/*      */         case 4:
/*  828 */           if (i < 64) {
/*  829 */             this.stackMapTableEntries.putByte(i + 64);
/*      */           } else {
/*  831 */             this.stackMapTableEntries
/*  832 */               .putByte(247)
/*  833 */               .putShort(i);
/*      */           } 
/*  835 */           putFrameType(paramArrayOfObject2[0]);
/*      */           break;
/*      */         default:
/*  838 */           throw new IllegalArgumentException();
/*      */       } 
/*      */       
/*  841 */       this.previousFrameOffset = this.code.b;
/*  842 */       this.stackMapTableNumberOfEntries++;
/*      */     } 
/*      */     
/*  845 */     if (this.compute == 2) {
/*  846 */       this.relativeStackSize = paramInt3;
/*  847 */       for (byte b = 0; b < paramInt3; b++) {
/*  848 */         if (paramArrayOfObject2[b] == Opcodes.LONG || paramArrayOfObject2[b] == Opcodes.DOUBLE) {
/*  849 */           this.relativeStackSize++;
/*      */         }
/*      */       } 
/*  852 */       if (this.relativeStackSize > this.maxRelativeStackSize) {
/*  853 */         this.maxRelativeStackSize = this.relativeStackSize;
/*      */       }
/*      */     } 
/*      */     
/*  857 */     this.maxStack = Math.max(this.maxStack, paramInt3);
/*  858 */     this.maxLocals = Math.max(this.maxLocals, this.currentLocals);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void visitInsn(int paramInt) {
/*  863 */     this.lastBytecodeOffset = this.code.b;
/*      */     
/*  865 */     this.code.putByte(paramInt);
/*      */     
/*  867 */     if (this.currentBasicBlock != null) {
/*  868 */       if (this.compute == 4 || this.compute == 3) {
/*  869 */         this.currentBasicBlock.h.a(paramInt, 0, (Symbol)null, (SymbolTable)null);
/*      */       } else {
/*      */         int i;
/*  872 */         if ((i = this.relativeStackSize + STACK_SIZE_DELTA[paramInt]) > this.maxRelativeStackSize) {
/*  873 */           this.maxRelativeStackSize = i;
/*      */         }
/*  875 */         this.relativeStackSize = i;
/*      */       } 
/*  877 */       if ((paramInt >= 172 && paramInt <= 177) || paramInt == 191) {
/*  878 */         endCurrentBasicBlockWithNoSuccessor();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final void visitIntInsn(int paramInt1, int paramInt2) {
/*  885 */     this.lastBytecodeOffset = this.code.b;
/*      */     
/*  887 */     if (paramInt1 == 17) {
/*  888 */       this.code.b(paramInt1, paramInt2);
/*      */     } else {
/*  890 */       this.code.a(paramInt1, paramInt2);
/*      */     } 
/*      */     
/*  893 */     if (this.currentBasicBlock != null) {
/*  894 */       if (this.compute == 4 || this.compute == 3) {
/*  895 */         this.currentBasicBlock.h.a(paramInt1, paramInt2, (Symbol)null, (SymbolTable)null); return;
/*  896 */       }  if (paramInt1 != 188) {
/*      */ 
/*      */         
/*  899 */         if ((paramInt1 = this.relativeStackSize + 1) > this.maxRelativeStackSize) {
/*  900 */           this.maxRelativeStackSize = paramInt1;
/*      */         }
/*  902 */         this.relativeStackSize = paramInt1;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final void visitVarInsn(int paramInt1, int paramInt2) {
/*  909 */     this.lastBytecodeOffset = this.code.b;
/*      */     
/*  911 */     if (paramInt2 < 4 && paramInt1 != 169) {
/*      */       int i;
/*  913 */       if (paramInt1 < 54) {
/*  914 */         i = 26 + (paramInt1 - 21 << 2) + paramInt2;
/*      */       } else {
/*  916 */         i = 59 + (paramInt1 - 54 << 2) + paramInt2;
/*      */       } 
/*  918 */       this.code.putByte(i);
/*  919 */     } else if (paramInt2 >= 256) {
/*  920 */       this.code.putByte(196).b(paramInt1, paramInt2);
/*      */     } else {
/*  922 */       this.code.a(paramInt1, paramInt2);
/*      */     } 
/*      */     
/*  925 */     if (this.currentBasicBlock != null) {
/*  926 */       if (this.compute == 4 || this.compute == 3) {
/*  927 */         this.currentBasicBlock.h.a(paramInt1, paramInt2, (Symbol)null, (SymbolTable)null);
/*      */       }
/*  929 */       else if (paramInt1 == 169) {
/*      */         
/*  931 */         this.currentBasicBlock.b = (short)(this.currentBasicBlock.b | 0x40);
/*  932 */         this.currentBasicBlock.e = (short)this.relativeStackSize;
/*  933 */         endCurrentBasicBlockWithNoSuccessor();
/*      */       } else {
/*      */         int i;
/*  936 */         if ((i = this.relativeStackSize + STACK_SIZE_DELTA[paramInt1]) > this.maxRelativeStackSize) {
/*  937 */           this.maxRelativeStackSize = i;
/*      */         }
/*  939 */         this.relativeStackSize = i;
/*      */       } 
/*      */     }
/*      */     
/*  943 */     if (this.compute != 0) {
/*      */       int i;
/*  945 */       if (paramInt1 == 22 || paramInt1 == 24 || paramInt1 == 55 || paramInt1 == 57) {
/*      */ 
/*      */ 
/*      */         
/*  949 */         i = paramInt2 + 2;
/*      */       } else {
/*  951 */         i = paramInt2 + 1;
/*      */       } 
/*  953 */       if (i > this.maxLocals) {
/*  954 */         this.maxLocals = i;
/*      */       }
/*      */     } 
/*  957 */     if (paramInt1 >= 54 && this.compute == 4 && this.firstHandler != null)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  965 */       visitLabel(new Label());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public final void visitTypeInsn(int paramInt, String paramString) {
/*  971 */     this.lastBytecodeOffset = this.code.b;
/*      */     
/*  973 */     Symbol symbol = this.symbolTable.a(paramString);
/*  974 */     this.code.b(paramInt, symbol.a);
/*      */     
/*  976 */     if (this.currentBasicBlock != null) {
/*  977 */       if (this.compute == 4 || this.compute == 3) {
/*  978 */         this.currentBasicBlock.h.a(paramInt, this.lastBytecodeOffset, symbol, this.symbolTable); return;
/*  979 */       }  if (paramInt == 187) {
/*      */ 
/*      */         
/*  982 */         if ((paramInt = this.relativeStackSize + 1) > this.maxRelativeStackSize) {
/*  983 */           this.maxRelativeStackSize = paramInt;
/*      */         }
/*  985 */         this.relativeStackSize = paramInt;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void visitFieldInsn(int paramInt, String paramString1, String paramString2, String paramString3) {
/*  993 */     this.lastBytecodeOffset = this.code.b;
/*      */     
/*  995 */     Symbol symbol = this.symbolTable.a(paramString1, paramString2, paramString3);
/*  996 */     this.code.b(paramInt, symbol.a);
/*      */     
/*  998 */     if (this.currentBasicBlock != null) {
/*  999 */       if (this.compute == 4 || this.compute == 3) {
/* 1000 */         this.currentBasicBlock.h.a(paramInt, 0, symbol, this.symbolTable);
/*      */         return;
/*      */       } 
/* 1003 */       char c = paramString3.charAt(0);
/* 1004 */       switch (paramInt) {
/*      */         case 178:
/* 1006 */           paramInt = this.relativeStackSize + ((c == 'D' || c == 'J') ? 2 : 1);
/*      */           break;
/*      */         case 179:
/* 1009 */           paramInt = this.relativeStackSize + ((c == 'D' || c == 'J') ? -2 : -1);
/*      */           break;
/*      */         case 180:
/* 1012 */           paramInt = this.relativeStackSize + ((c == 'D' || c == 'J') ? 1 : 0);
/*      */           break;
/*      */         
/*      */         default:
/* 1016 */           paramInt = this.relativeStackSize + ((c == 'D' || c == 'J') ? -3 : -2);
/*      */           break;
/*      */       } 
/* 1019 */       if (paramInt > this.maxRelativeStackSize) {
/* 1020 */         this.maxRelativeStackSize = paramInt;
/*      */       }
/* 1022 */       this.relativeStackSize = paramInt;
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
/*      */   public final void visitMethodInsn(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
/* 1034 */     this.lastBytecodeOffset = this.code.b;
/*      */     
/* 1036 */     Symbol symbol = this.symbolTable.a(paramString1, paramString2, paramString3, paramBoolean);
/* 1037 */     if (paramInt == 185) {
/* 1038 */       this.code.b(185, symbol.a)
/* 1039 */         .a(symbol.a() >> 2, 0);
/*      */     } else {
/* 1041 */       this.code.b(paramInt, symbol.a);
/*      */     } 
/*      */     
/* 1044 */     if (this.currentBasicBlock != null) {
/* 1045 */       if (this.compute == 4 || this.compute == 3) {
/* 1046 */         this.currentBasicBlock.h.a(paramInt, 0, symbol, this.symbolTable);
/*      */         return;
/*      */       } 
/* 1049 */       int i = ((i = symbol.a()) & 0x3) - (i >> 2);
/*      */       
/* 1051 */       if (paramInt == 184) {
/* 1052 */         paramInt = this.relativeStackSize + i + 1;
/*      */       } else {
/* 1054 */         paramInt = this.relativeStackSize + i;
/*      */       } 
/* 1056 */       if (paramInt > this.maxRelativeStackSize) {
/* 1057 */         this.maxRelativeStackSize = paramInt;
/*      */       }
/* 1059 */       this.relativeStackSize = paramInt;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void visitInvokeDynamicInsn(String paramString1, String paramString2, Handle paramHandle, Object... paramVarArgs) {
/* 1070 */     this.lastBytecodeOffset = this.code.b;
/*      */ 
/*      */     
/* 1073 */     Symbol symbol = this.symbolTable.b(paramString1, paramString2, paramHandle, paramVarArgs);
/*      */     
/* 1075 */     this.code.b(186, symbol.a);
/* 1076 */     this.code.putShort(0);
/*      */     
/* 1078 */     if (this.currentBasicBlock != null) {
/* 1079 */       if (this.compute == 4 || this.compute == 3) {
/* 1080 */         this.currentBasicBlock.h.a(186, 0, symbol, this.symbolTable);
/*      */         return;
/*      */       } 
/* 1083 */       int i = ((i = symbol.a()) & 0x3) - (i >> 2) + 1;
/*      */       
/* 1085 */       if ((i = this.relativeStackSize + i) > this.maxRelativeStackSize) {
/* 1086 */         this.maxRelativeStackSize = i;
/*      */       }
/* 1088 */       this.relativeStackSize = i;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void visitJumpInsn(int paramInt, Label paramLabel) {
/* 1095 */     this.lastBytecodeOffset = this.code.b;
/*      */ 
/*      */ 
/*      */     
/* 1099 */     int i = (paramInt >= 200) ? (paramInt - 33) : paramInt;
/* 1100 */     boolean bool = false;
/* 1101 */     if ((paramLabel.b & 0x4) != 0 && paramLabel.c - this.code.b < -32768) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1107 */       if (i == 167) {
/* 1108 */         this.code.putByte(200);
/* 1109 */       } else if (i == 168) {
/* 1110 */         this.code.putByte(201);
/*      */       
/*      */       }
/*      */       else {
/*      */         
/* 1115 */         this.code.putByte((i >= 198) ? (i ^ 0x1) : ((i + 1 ^ 0x1) - 1));
/* 1116 */         this.code.putShort(8);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1123 */         this.code.putByte(220);
/* 1124 */         this.hasAsmInstructions = true;
/*      */         
/* 1126 */         bool = true;
/*      */       } 
/* 1128 */       paramLabel.a(this.code, this.code.b - 1, true);
/* 1129 */     } else if (i != paramInt) {
/*      */ 
/*      */       
/* 1132 */       this.code.putByte(paramInt);
/* 1133 */       paramLabel.a(this.code, this.code.b - 1, true);
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 1138 */       this.code.putByte(i);
/* 1139 */       paramLabel.a(this.code, this.code.b - 1, false);
/*      */     } 
/*      */ 
/*      */     
/* 1143 */     if (this.currentBasicBlock != null) {
/* 1144 */       Label label = null;
/* 1145 */       if (this.compute == 4) {
/* 1146 */         this.currentBasicBlock.h.a(i, 0, (Symbol)null, (SymbolTable)null);
/*      */         
/* 1148 */         (paramLabel.a()).b = (short)((paramLabel.a()).b | 0x2);
/*      */         
/* 1150 */         addSuccessorToCurrentBasicBlock(0, paramLabel);
/* 1151 */         if (i != 167)
/*      */         {
/*      */ 
/*      */           
/* 1155 */           label = new Label();
/*      */         }
/* 1157 */       } else if (this.compute == 3) {
/* 1158 */         this.currentBasicBlock.h.a(i, 0, (Symbol)null, (SymbolTable)null);
/* 1159 */       } else if (this.compute == 2) {
/*      */         
/* 1161 */         this.relativeStackSize += STACK_SIZE_DELTA[i];
/*      */       }
/* 1163 */       else if (i == 168) {
/*      */         
/* 1165 */         if ((paramLabel.b & 0x20) == 0) {
/* 1166 */           paramLabel.b = (short)(paramLabel.b | 0x20);
/* 1167 */           this.hasSubroutines = true;
/*      */         } 
/* 1169 */         this.currentBasicBlock.b = (short)(this.currentBasicBlock.b | 0x10);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1176 */         addSuccessorToCurrentBasicBlock(this.relativeStackSize + 1, paramLabel);
/*      */         
/* 1178 */         label = new Label();
/*      */       } else {
/*      */         
/* 1181 */         this.relativeStackSize += STACK_SIZE_DELTA[i];
/* 1182 */         addSuccessorToCurrentBasicBlock(this.relativeStackSize, paramLabel);
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1187 */       if (label != null) {
/* 1188 */         if (bool) {
/* 1189 */           label.b = (short)(label.b | 0x2);
/*      */         }
/* 1191 */         visitLabel(label);
/*      */       } 
/* 1193 */       if (i == 167) {
/* 1194 */         endCurrentBasicBlockWithNoSuccessor();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void visitLabel(Label paramLabel) {
/* 1202 */     this.hasAsmInstructions |= paramLabel.a(this.code.a, this.code.b);
/*      */ 
/*      */     
/* 1205 */     if ((paramLabel.b & 0x1) != 0) {
/*      */       return;
/*      */     }
/* 1208 */     if (this.compute == 4) {
/* 1209 */       if (this.currentBasicBlock != null) {
/* 1210 */         if (paramLabel.c == this.currentBasicBlock.c) {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1215 */           this.currentBasicBlock.b = (short)(this.currentBasicBlock.b | paramLabel.b & 0x2);
/*      */ 
/*      */ 
/*      */           
/* 1219 */           paramLabel.h = this.currentBasicBlock.h;
/*      */ 
/*      */           
/*      */           return;
/*      */         } 
/*      */         
/* 1225 */         addSuccessorToCurrentBasicBlock(0, paramLabel);
/*      */       } 
/*      */       
/* 1228 */       if (this.lastBasicBlock != null) {
/* 1229 */         if (paramLabel.c == this.lastBasicBlock.c) {
/*      */           
/* 1231 */           this.lastBasicBlock.b = (short)(this.lastBasicBlock.b | paramLabel.b & 0x2);
/*      */           
/* 1233 */           paramLabel.h = this.lastBasicBlock.h;
/* 1234 */           this.currentBasicBlock = this.lastBasicBlock;
/*      */           return;
/*      */         } 
/* 1237 */         this.lastBasicBlock.i = paramLabel;
/*      */       } 
/* 1239 */       this.lastBasicBlock = paramLabel;
/*      */       
/* 1241 */       this.currentBasicBlock = paramLabel;
/*      */       
/* 1243 */       paramLabel.h = new Frame(paramLabel); return;
/* 1244 */     }  if (this.compute == 3) {
/* 1245 */       if (this.currentBasicBlock == null) {
/*      */ 
/*      */         
/* 1248 */         this.currentBasicBlock = paramLabel;
/*      */         return;
/*      */       } 
/* 1251 */       this.currentBasicBlock.h.a = paramLabel; return;
/*      */     } 
/* 1253 */     if (this.compute == 1) {
/* 1254 */       if (this.currentBasicBlock != null) {
/*      */         
/* 1256 */         this.currentBasicBlock.f = (short)this.maxRelativeStackSize;
/* 1257 */         addSuccessorToCurrentBasicBlock(this.relativeStackSize, paramLabel);
/*      */       } 
/*      */       
/* 1260 */       this.currentBasicBlock = paramLabel;
/* 1261 */       this.relativeStackSize = 0;
/* 1262 */       this.maxRelativeStackSize = 0;
/*      */       
/* 1264 */       if (this.lastBasicBlock != null) {
/* 1265 */         this.lastBasicBlock.i = paramLabel;
/*      */       }
/* 1267 */       this.lastBasicBlock = paramLabel; return;
/* 1268 */     }  if (this.compute == 2 && this.currentBasicBlock == null)
/*      */     {
/*      */ 
/*      */       
/* 1272 */       this.currentBasicBlock = paramLabel;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public final void visitLdcInsn(Object paramObject) {
/* 1278 */     this.lastBytecodeOffset = this.code.b;
/*      */ 
/*      */     
/* 1281 */     int i = ((Symbol)(paramObject = this.symbolTable.a(paramObject))).a;
/*      */ 
/*      */ 
/*      */     
/*      */     char c;
/*      */ 
/*      */ 
/*      */     
/* 1289 */     if ((c = (((Symbol)paramObject).b == 5 || ((Symbol)paramObject).b == 6 || (((Symbol)paramObject).b == 17 && ((c = ((Symbol)paramObject).e.charAt(0)) == 'J' || c == 'D'))) ? '\001' : Character.MIN_VALUE) != '\000') {
/* 1290 */       this.code.b(20, i);
/* 1291 */     } else if (i >= 256) {
/* 1292 */       this.code.b(19, i);
/*      */     } else {
/* 1294 */       this.code.a(18, i);
/*      */     } 
/*      */     
/* 1297 */     if (this.currentBasicBlock != null) {
/* 1298 */       if (this.compute == 4 || this.compute == 3) {
/* 1299 */         this.currentBasicBlock.h.a(18, 0, (Symbol)paramObject, this.symbolTable); return;
/*      */       } 
/*      */       int j;
/* 1302 */       if ((j = this.relativeStackSize + ((c != '\000') ? 2 : 1)) > this.maxRelativeStackSize) {
/* 1303 */         this.maxRelativeStackSize = j;
/*      */       }
/* 1305 */       this.relativeStackSize = j;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void visitIincInsn(int paramInt1, int paramInt2) {
/* 1312 */     this.lastBytecodeOffset = this.code.b;
/*      */     
/* 1314 */     if (paramInt1 > 255 || paramInt2 > 127 || paramInt2 < -128) {
/* 1315 */       this.code.putByte(196).b(132, paramInt1).putShort(paramInt2);
/*      */     } else {
/* 1317 */       this.code.putByte(132).a(paramInt1, paramInt2);
/*      */     } 
/*      */     
/* 1320 */     if (this.currentBasicBlock != null && (this.compute == 4 || this.compute == 3))
/*      */     {
/* 1322 */       this.currentBasicBlock.h.a(132, paramInt1, (Symbol)null, (SymbolTable)null);
/*      */     }
/* 1324 */     if (this.compute != 0 && (
/*      */       
/* 1326 */       paramInt1 = paramInt1 + 1) > this.maxLocals) {
/* 1327 */       this.maxLocals = paramInt1;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void visitTableSwitchInsn(int paramInt1, int paramInt2, Label paramLabel, Label... paramVarArgs) {
/* 1335 */     this.lastBytecodeOffset = this.code.b;
/*      */     
/* 1337 */     this.code.putByte(170).putByteArray(null, 0, (4 - this.code.b % 4) % 4);
/* 1338 */     paramLabel.a(this.code, this.lastBytecodeOffset, true);
/* 1339 */     this.code.putInt(paramInt1).putInt(paramInt2); Label[] arrayOfLabel; byte b;
/* 1340 */     for (paramInt2 = (arrayOfLabel = paramVarArgs).length, b = 0; b < paramInt2; b++) {
/* 1341 */       Label label; (label = arrayOfLabel[b]).a(this.code, this.lastBytecodeOffset, true);
/*      */     } 
/*      */     
/* 1344 */     visitSwitchInsn(paramLabel, paramVarArgs);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void visitLookupSwitchInsn(Label paramLabel, int[] paramArrayOfint, Label[] paramArrayOfLabel) {
/* 1349 */     this.lastBytecodeOffset = this.code.b;
/*      */     
/* 1351 */     this.code.putByte(171).putByteArray(null, 0, (4 - this.code.b % 4) % 4);
/* 1352 */     paramLabel.a(this.code, this.lastBytecodeOffset, true);
/* 1353 */     this.code.putInt(paramArrayOfLabel.length);
/* 1354 */     for (byte b = 0; b < paramArrayOfLabel.length; b++) {
/* 1355 */       this.code.putInt(paramArrayOfint[b]);
/* 1356 */       paramArrayOfLabel[b].a(this.code, this.lastBytecodeOffset, true);
/*      */     } 
/*      */     
/* 1359 */     visitSwitchInsn(paramLabel, paramArrayOfLabel);
/*      */   }
/*      */   
/*      */   private void visitSwitchInsn(Label paramLabel, Label[] paramArrayOfLabel) {
/* 1363 */     if (this.currentBasicBlock != null) {
/* 1364 */       Label[] arrayOfLabel; int i; if (this.compute == 4) {
/* 1365 */         this.currentBasicBlock.h.a(171, 0, (Symbol)null, (SymbolTable)null);
/*      */         
/* 1367 */         addSuccessorToCurrentBasicBlock(0, paramLabel);
/* 1368 */         (paramLabel.a()).b = (short)((paramLabel.a()).b | 0x2); byte b;
/* 1369 */         for (i = (arrayOfLabel = paramArrayOfLabel).length, b = 0; b < i; ) { Label label = arrayOfLabel[b];
/* 1370 */           addSuccessorToCurrentBasicBlock(0, label);
/* 1371 */           (label.a()).b = (short)((label.a()).b | 0x2); b++; }
/*      */       
/* 1373 */       } else if (this.compute == 1) {
/*      */         
/* 1375 */         this.relativeStackSize--;
/*      */         
/* 1377 */         addSuccessorToCurrentBasicBlock(this.relativeStackSize, (Label)arrayOfLabel); int j; byte b;
/* 1378 */         for (i = (j = i).length, b = 0; b < i; ) { int k = j[b];
/* 1379 */           addSuccessorToCurrentBasicBlock(this.relativeStackSize, k);
/*      */           b++; }
/*      */       
/*      */       } 
/* 1383 */       endCurrentBasicBlockWithNoSuccessor();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final void visitMultiANewArrayInsn(String paramString, int paramInt) {
/* 1389 */     this.lastBytecodeOffset = this.code.b;
/*      */     
/* 1391 */     Symbol symbol = this.symbolTable.a(paramString);
/* 1392 */     this.code.b(197, symbol.a).putByte(paramInt);
/*      */     
/* 1394 */     if (this.currentBasicBlock != null) {
/* 1395 */       if (this.compute == 4 || this.compute == 3) {
/* 1396 */         this.currentBasicBlock.h.a(197, paramInt, symbol, this.symbolTable);
/*      */         
/*      */         return;
/*      */       } 
/* 1400 */       this.relativeStackSize += 1 - paramInt;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final AnnotationVisitor visitInsnAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
/* 1408 */     if (paramBoolean) {
/* 1409 */       return this
/* 1410 */         .lastCodeRuntimeVisibleTypeAnnotation = AnnotationWriter.a(this.symbolTable, paramInt & 0xFF0000FF | this.lastBytecodeOffset << 8, paramTypePath, paramString, this.lastCodeRuntimeVisibleTypeAnnotation);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1417 */     return this
/* 1418 */       .lastCodeRuntimeInvisibleTypeAnnotation = AnnotationWriter.a(this.symbolTable, paramInt & 0xFF0000FF | this.lastBytecodeOffset << 8, paramTypePath, paramString, this.lastCodeRuntimeInvisibleTypeAnnotation);
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
/*      */   public final void visitTryCatchBlock(Label paramLabel1, Label paramLabel2, Label paramLabel3, String paramString) {
/* 1432 */     Handler handler = new Handler(paramLabel1, paramLabel2, paramLabel3, (paramString != null) ? (this.symbolTable.a(paramString)).a : 0, paramString);
/* 1433 */     if (this.firstHandler == null) {
/* 1434 */       this.firstHandler = handler;
/*      */     } else {
/* 1436 */       this.lastHandler.e = handler;
/*      */     } 
/* 1438 */     this.lastHandler = handler;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final AnnotationVisitor visitTryCatchAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
/* 1444 */     if (paramBoolean) {
/* 1445 */       return this
/* 1446 */         .lastCodeRuntimeVisibleTypeAnnotation = AnnotationWriter.a(this.symbolTable, paramInt, paramTypePath, paramString, this.lastCodeRuntimeVisibleTypeAnnotation);
/*      */     }
/*      */     
/* 1449 */     return this
/* 1450 */       .lastCodeRuntimeInvisibleTypeAnnotation = AnnotationWriter.a(this.symbolTable, paramInt, paramTypePath, paramString, this.lastCodeRuntimeInvisibleTypeAnnotation);
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
/*      */   public final void visitLocalVariable(String paramString1, String paramString2, String paramString3, Label paramLabel1, Label paramLabel2, int paramInt) {
/* 1463 */     if (paramString3 != null) {
/* 1464 */       if (this.localVariableTypeTable == null) {
/* 1465 */         this.localVariableTypeTable = new ByteVector();
/*      */       }
/* 1467 */       this.localVariableTypeTableLength++;
/* 1468 */       this.localVariableTypeTable
/* 1469 */         .putShort(paramLabel1.c)
/* 1470 */         .putShort(paramLabel2.c - paramLabel1.c)
/* 1471 */         .putShort(this.symbolTable.b(paramString1))
/* 1472 */         .putShort(this.symbolTable.b(paramString3))
/* 1473 */         .putShort(paramInt);
/*      */     } 
/* 1475 */     if (this.localVariableTable == null) {
/* 1476 */       this.localVariableTable = new ByteVector();
/*      */     }
/* 1478 */     this.localVariableTableLength++;
/* 1479 */     this.localVariableTable
/* 1480 */       .putShort(paramLabel1.c)
/* 1481 */       .putShort(paramLabel2.c - paramLabel1.c)
/* 1482 */       .putShort(this.symbolTable.b(paramString1))
/* 1483 */       .putShort(this.symbolTable.b(paramString2))
/* 1484 */       .putShort(paramInt);
/* 1485 */     if (this.compute != 0) {
/* 1486 */       char c = paramString2.charAt(0);
/*      */       int i;
/* 1488 */       if ((i = paramInt + ((c == 'J' || c == 'D') ? 2 : 1)) > this.maxLocals) {
/* 1489 */         this.maxLocals = i;
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
/*      */   public final AnnotationVisitor visitLocalVariableAnnotation(int paramInt, TypePath paramTypePath, Label[] paramArrayOfLabel1, Label[] paramArrayOfLabel2, int[] paramArrayOfint, String paramString, boolean paramBoolean) {
/*      */     ByteVector byteVector;
/* 1507 */     (byteVector = new ByteVector()).putByte(paramInt >>> 24).putShort(paramArrayOfLabel1.length);
/* 1508 */     for (paramInt = 0; paramInt < paramArrayOfLabel1.length; paramInt++) {
/* 1509 */       byteVector
/* 1510 */         .putShort((paramArrayOfLabel1[paramInt]).c)
/* 1511 */         .putShort((paramArrayOfLabel2[paramInt]).c - (paramArrayOfLabel1[paramInt]).c)
/* 1512 */         .putShort(paramArrayOfint[paramInt]);
/*      */     }
/* 1514 */     TypePath.a(paramTypePath, byteVector);
/*      */     
/* 1516 */     byteVector.putShort(this.symbolTable.b(paramString)).putShort(0);
/* 1517 */     if (paramBoolean) {
/* 1518 */       return this.lastCodeRuntimeVisibleTypeAnnotation = new AnnotationWriter(this.symbolTable, true, byteVector, this.lastCodeRuntimeVisibleTypeAnnotation);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1525 */     return this.lastCodeRuntimeInvisibleTypeAnnotation = new AnnotationWriter(this.symbolTable, true, byteVector, this.lastCodeRuntimeInvisibleTypeAnnotation);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void visitLineNumber(int paramInt, Label paramLabel) {
/* 1536 */     if (this.lineNumberTable == null) {
/* 1537 */       this.lineNumberTable = new ByteVector();
/*      */     }
/* 1539 */     this.lineNumberTableLength++;
/* 1540 */     this.lineNumberTable.putShort(paramLabel.c);
/* 1541 */     this.lineNumberTable.putShort(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void visitMaxs(int paramInt1, int paramInt2) {
/* 1546 */     if (this.compute == 4) {
/* 1547 */       computeAllFrames(); return;
/* 1548 */     }  if (this.compute == 1) {
/* 1549 */       computeMaxStackAndLocal(); return;
/* 1550 */     }  if (this.compute == 2) {
/* 1551 */       this.maxStack = this.maxRelativeStackSize; return;
/*      */     } 
/* 1553 */     this.maxStack = paramInt1;
/* 1554 */     this.maxLocals = paramInt2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void computeAllFrames() {
/* 1561 */     Handler handler = this.firstHandler;
/* 1562 */     while (handler != null) {
/*      */       
/* 1564 */       String str = (handler.d == null) ? "java/lang/Throwable" : handler.d;
/* 1565 */       int j = Frame.a(this.symbolTable, str);
/*      */       
/*      */       Label label3;
/* 1568 */       (label3 = handler.c.a()).b = (short)((label3 = handler.c.a()).b | 0x2);
/*      */       
/* 1570 */       Label label4 = handler.a.a();
/* 1571 */       Label label5 = handler.b.a();
/* 1572 */       while (label4 != label5) {
/* 1573 */         label4.j = new Edge(j, label3, label4.j);
/*      */         
/* 1575 */         label4 = label4.i;
/*      */       } 
/* 1577 */       handler = handler.e;
/*      */     } 
/*      */     
/*      */     Frame frame;
/*      */     
/* 1582 */     (frame = this.firstBasicBlock.h).a(this.symbolTable, this.accessFlags, this.descriptor, this.maxLocals);
/* 1583 */     frame.a(this);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Label label1;
/*      */ 
/*      */ 
/*      */     
/* 1592 */     (label1 = this.firstBasicBlock).k = Label.a;
/* 1593 */     int i = 0;
/* 1594 */     while (label1 != Label.a) {
/*      */       
/* 1596 */       Label label = label1;
/* 1597 */       label1 = label1.k;
/* 1598 */       label.k = null;
/*      */       
/* 1600 */       label.b = (short)(label.b | 0x8);
/*      */       
/*      */       int j;
/* 1603 */       if ((j = label.h.a() + label.f) > i) {
/* 1604 */         i = j;
/*      */       }
/*      */       
/* 1607 */       Edge edge = label.j;
/* 1608 */       while (edge != null) {
/* 1609 */         Label label3 = edge.b.a();
/*      */         
/*      */         boolean bool;
/* 1612 */         if ((bool = label.h.a(this.symbolTable, label3.h, edge.a)) && label3.k == null) {
/*      */ 
/*      */           
/* 1615 */           label3.k = label1;
/* 1616 */           label1 = label3;
/*      */         } 
/* 1618 */         edge = edge.c;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1625 */     Label label2 = this.firstBasicBlock;
/* 1626 */     while (label2 != null) {
/* 1627 */       if ((label2.b & 0xA) == 10)
/*      */       {
/* 1629 */         label2.h.a(this);
/*      */       }
/* 1631 */       if ((label2.b & 0x8) == 0) {
/*      */         
/* 1633 */         Label label = label2.i;
/* 1634 */         int j = label2.c;
/*      */         int k;
/* 1636 */         if ((k = ((label == null) ? this.code.b : label.c) - 1) >= j) {
/*      */           
/* 1638 */           for (int m = j; m < k; m++) {
/* 1639 */             this.code.a[m] = 0;
/*      */           }
/* 1641 */           this.code.a[k] = -65;
/*      */ 
/*      */           
/* 1644 */           a(j, 0, 1);
/* 1645 */           this.currentFrame[3] = 
/* 1646 */             Frame.a(this.symbolTable, "java/lang/Throwable");
/* 1647 */           c();
/*      */           
/* 1649 */           this.firstHandler = Handler.a(this.firstHandler, label2, label);
/*      */           
/* 1651 */           i = Math.max(i, 1);
/*      */         } 
/*      */       } 
/* 1654 */       label2 = label2.i;
/*      */     } 
/*      */     
/* 1657 */     this.maxStack = i;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void computeMaxStackAndLocal() {
/* 1663 */     Handler handler = this.firstHandler;
/* 1664 */     while (handler != null) {
/* 1665 */       Label label1 = handler.c;
/* 1666 */       Label label2 = handler.a;
/* 1667 */       Label label3 = handler.b;
/*      */       
/* 1669 */       while (label2 != label3) {
/* 1670 */         if ((label2.b & 0x10) == 0) {
/* 1671 */           label2.j = new Edge(2147483647, label1, label2.j);
/*      */         
/*      */         }
/*      */         else {
/*      */ 
/*      */           
/* 1677 */           label2.j.c.c = new Edge(2147483647, label1, label2.j.c.c);
/*      */         } 
/*      */ 
/*      */         
/* 1681 */         label2 = label2.i;
/*      */       } 
/* 1683 */       handler = handler.e;
/*      */     } 
/*      */ 
/*      */     
/* 1687 */     if (this.hasSubroutines) {
/*      */ 
/*      */       
/* 1690 */       short s1 = 1;
/* 1691 */       this.firstBasicBlock.a((short)1);
/*      */ 
/*      */       
/* 1694 */       for (short s2 = 1; s2 <= s1; s2 = (short)(s2 + 1)) {
/* 1695 */         Label label2 = this.firstBasicBlock;
/* 1696 */         while (label2 != null) {
/* 1697 */           if ((label2.b & 0x10) != 0 && label2.g == s2) {
/*      */             Label label3;
/*      */             
/* 1700 */             if ((label3 = label2.j.c.b).g == 0)
/*      */             {
/* 1702 */               label3.a(s1 = (short)(s1 + 1));
/*      */             }
/*      */           } 
/* 1705 */           label2 = label2.i;
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1711 */       Label label1 = this.firstBasicBlock;
/* 1712 */       while (label1 != null) {
/* 1713 */         if ((label1.b & 0x10) != 0) {
/*      */           Label label2;
/*      */ 
/*      */           
/* 1717 */           (label2 = label1.j.c.b).a(label1);
/*      */         } 
/* 1719 */         label1 = label1.i;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*      */     Label label;
/*      */ 
/*      */     
/* 1728 */     (label = this.firstBasicBlock).k = Label.a;
/* 1729 */     int i = this.maxStack;
/* 1730 */     while (label != Label.a) {
/*      */ 
/*      */ 
/*      */       
/* 1734 */       Label label1 = label;
/* 1735 */       label = label.k;
/*      */       
/*      */       short s;
/*      */       
/*      */       int j;
/* 1740 */       if ((j = (s = label1.d) + label1.f) > i) {
/* 1741 */         i = j;
/*      */       }
/*      */ 
/*      */       
/* 1745 */       Edge edge = label1.j;
/* 1746 */       if ((label1.b & 0x10) != 0)
/*      */       {
/*      */ 
/*      */ 
/*      */         
/* 1751 */         edge = edge.c;
/*      */       }
/* 1753 */       while (edge != null) {
/*      */         
/* 1755 */         if ((label1 = edge.b).k == null) {
/* 1756 */           label1
/* 1757 */             .d = (short)((edge.a == Integer.MAX_VALUE) ? 1 : (s + edge.a));
/* 1758 */           label1.k = label;
/* 1759 */           label = label1;
/*      */         } 
/* 1761 */         edge = edge.c;
/*      */       } 
/*      */     } 
/* 1764 */     this.maxStack = i;
/*      */   }
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
/*      */   private void addSuccessorToCurrentBasicBlock(int paramInt, Label paramLabel) {
/* 1783 */     this.currentBasicBlock.j = new Edge(paramInt, paramLabel, this.currentBasicBlock.j);
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
/*      */   private void endCurrentBasicBlockWithNoSuccessor() {
/* 1795 */     if (this.compute == 4) {
/*      */       Label label;
/* 1797 */       (label = new Label()).h = new Frame(label);
/* 1798 */       label.a(this.code.a, this.code.b);
/* 1799 */       this.lastBasicBlock.i = label;
/* 1800 */       this.lastBasicBlock = label;
/* 1801 */       this.currentBasicBlock = null; return;
/* 1802 */     }  if (this.compute == 1) {
/* 1803 */       this.currentBasicBlock.f = (short)this.maxRelativeStackSize;
/* 1804 */       this.currentBasicBlock = null;
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
/*      */   final int a(int paramInt1, int paramInt2, int paramInt3) {
/* 1821 */     int i = paramInt2 + 3 + paramInt3;
/* 1822 */     if (this.currentFrame == null || this.currentFrame.length < i) {
/* 1823 */       this.currentFrame = new int[i];
/*      */     }
/* 1825 */     this.currentFrame[0] = paramInt1;
/* 1826 */     this.currentFrame[1] = paramInt2;
/* 1827 */     this.currentFrame[2] = paramInt3;
/* 1828 */     return 3;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final void a(int paramInt1, int paramInt2) {
/* 1838 */     this.currentFrame[paramInt1] = paramInt2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final void c() {
/* 1847 */     if (this.previousFrame != null) {
/* 1848 */       if (this.stackMapTableEntries == null) {
/* 1849 */         this.stackMapTableEntries = new ByteVector();
/*      */       }
/* 1851 */       putFrame();
/* 1852 */       this.stackMapTableNumberOfEntries++;
/*      */     } 
/* 1854 */     this.previousFrame = this.currentFrame;
/* 1855 */     this.currentFrame = null;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void putFrame() {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: getfield currentFrame : [I
/*      */     //   4: iconst_1
/*      */     //   5: iaload
/*      */     //   6: istore_1
/*      */     //   7: aload_0
/*      */     //   8: getfield currentFrame : [I
/*      */     //   11: iconst_2
/*      */     //   12: iaload
/*      */     //   13: istore_2
/*      */     //   14: aload_0
/*      */     //   15: getfield symbolTable : Lnet/bytebuddy/jar/asm/SymbolTable;
/*      */     //   18: invokevirtual b : ()I
/*      */     //   21: bipush #50
/*      */     //   23: if_icmpge -> 74
/*      */     //   26: aload_0
/*      */     //   27: getfield stackMapTableEntries : Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   30: aload_0
/*      */     //   31: getfield currentFrame : [I
/*      */     //   34: iconst_0
/*      */     //   35: iaload
/*      */     //   36: invokevirtual putShort : (I)Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   39: iload_1
/*      */     //   40: invokevirtual putShort : (I)Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   43: pop
/*      */     //   44: aload_0
/*      */     //   45: iconst_3
/*      */     //   46: iload_1
/*      */     //   47: iconst_3
/*      */     //   48: iadd
/*      */     //   49: invokespecial putAbstractTypes : (II)V
/*      */     //   52: aload_0
/*      */     //   53: getfield stackMapTableEntries : Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   56: iload_2
/*      */     //   57: invokevirtual putShort : (I)Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   60: pop
/*      */     //   61: aload_0
/*      */     //   62: iload_1
/*      */     //   63: iconst_3
/*      */     //   64: iadd
/*      */     //   65: iload_1
/*      */     //   66: iconst_3
/*      */     //   67: iadd
/*      */     //   68: iload_2
/*      */     //   69: iadd
/*      */     //   70: invokespecial putAbstractTypes : (II)V
/*      */     //   73: return
/*      */     //   74: aload_0
/*      */     //   75: getfield stackMapTableNumberOfEntries : I
/*      */     //   78: ifne -> 90
/*      */     //   81: aload_0
/*      */     //   82: getfield currentFrame : [I
/*      */     //   85: iconst_0
/*      */     //   86: iaload
/*      */     //   87: goto -> 105
/*      */     //   90: aload_0
/*      */     //   91: getfield currentFrame : [I
/*      */     //   94: iconst_0
/*      */     //   95: iaload
/*      */     //   96: aload_0
/*      */     //   97: getfield previousFrame : [I
/*      */     //   100: iconst_0
/*      */     //   101: iaload
/*      */     //   102: isub
/*      */     //   103: iconst_1
/*      */     //   104: isub
/*      */     //   105: istore_3
/*      */     //   106: aload_0
/*      */     //   107: getfield previousFrame : [I
/*      */     //   110: iconst_1
/*      */     //   111: iaload
/*      */     //   112: istore #4
/*      */     //   114: iload_1
/*      */     //   115: iload #4
/*      */     //   117: isub
/*      */     //   118: istore #5
/*      */     //   120: sipush #255
/*      */     //   123: istore #6
/*      */     //   125: iload_2
/*      */     //   126: ifne -> 205
/*      */     //   129: iload #5
/*      */     //   131: tableswitch default -> 202, -3 -> 172, -2 -> 172, -1 -> 172, 0 -> 178, 1 -> 196, 2 -> 196, 3 -> 196
/*      */     //   172: sipush #248
/*      */     //   175: goto -> 229
/*      */     //   178: iload_3
/*      */     //   179: bipush #64
/*      */     //   181: if_icmpge -> 188
/*      */     //   184: iconst_0
/*      */     //   185: goto -> 191
/*      */     //   188: sipush #251
/*      */     //   191: istore #6
/*      */     //   193: goto -> 231
/*      */     //   196: sipush #252
/*      */     //   199: goto -> 229
/*      */     //   202: goto -> 231
/*      */     //   205: iload #5
/*      */     //   207: ifne -> 231
/*      */     //   210: iload_2
/*      */     //   211: iconst_1
/*      */     //   212: if_icmpne -> 231
/*      */     //   215: iload_3
/*      */     //   216: bipush #63
/*      */     //   218: if_icmpge -> 226
/*      */     //   221: bipush #64
/*      */     //   223: goto -> 229
/*      */     //   226: sipush #247
/*      */     //   229: istore #6
/*      */     //   231: iload #6
/*      */     //   233: sipush #255
/*      */     //   236: if_icmpeq -> 292
/*      */     //   239: iconst_3
/*      */     //   240: istore #7
/*      */     //   242: iconst_0
/*      */     //   243: istore #8
/*      */     //   245: iload #8
/*      */     //   247: iload #4
/*      */     //   249: if_icmpge -> 292
/*      */     //   252: iload #8
/*      */     //   254: iload_1
/*      */     //   255: if_icmpge -> 292
/*      */     //   258: aload_0
/*      */     //   259: getfield currentFrame : [I
/*      */     //   262: iload #7
/*      */     //   264: iaload
/*      */     //   265: aload_0
/*      */     //   266: getfield previousFrame : [I
/*      */     //   269: iload #7
/*      */     //   271: iaload
/*      */     //   272: if_icmpeq -> 283
/*      */     //   275: sipush #255
/*      */     //   278: istore #6
/*      */     //   280: goto -> 292
/*      */     //   283: iinc #7, 1
/*      */     //   286: iinc #8, 1
/*      */     //   289: goto -> 245
/*      */     //   292: iload #6
/*      */     //   294: lookupswitch default -> 476, 0 -> 352, 64 -> 362, 247 -> 385, 248 -> 427, 251 -> 411, 252 -> 446
/*      */     //   352: aload_0
/*      */     //   353: getfield stackMapTableEntries : Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   356: iload_3
/*      */     //   357: invokevirtual putByte : (I)Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   360: pop
/*      */     //   361: return
/*      */     //   362: aload_0
/*      */     //   363: getfield stackMapTableEntries : Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   366: iload_3
/*      */     //   367: bipush #64
/*      */     //   369: iadd
/*      */     //   370: invokevirtual putByte : (I)Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   373: pop
/*      */     //   374: aload_0
/*      */     //   375: iload_1
/*      */     //   376: iconst_3
/*      */     //   377: iadd
/*      */     //   378: iload_1
/*      */     //   379: iconst_4
/*      */     //   380: iadd
/*      */     //   381: invokespecial putAbstractTypes : (II)V
/*      */     //   384: return
/*      */     //   385: aload_0
/*      */     //   386: getfield stackMapTableEntries : Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   389: sipush #247
/*      */     //   392: invokevirtual putByte : (I)Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   395: iload_3
/*      */     //   396: invokevirtual putShort : (I)Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   399: pop
/*      */     //   400: aload_0
/*      */     //   401: iload_1
/*      */     //   402: iconst_3
/*      */     //   403: iadd
/*      */     //   404: iload_1
/*      */     //   405: iconst_4
/*      */     //   406: iadd
/*      */     //   407: invokespecial putAbstractTypes : (II)V
/*      */     //   410: return
/*      */     //   411: aload_0
/*      */     //   412: getfield stackMapTableEntries : Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   415: sipush #251
/*      */     //   418: invokevirtual putByte : (I)Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   421: iload_3
/*      */     //   422: invokevirtual putShort : (I)Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   425: pop
/*      */     //   426: return
/*      */     //   427: aload_0
/*      */     //   428: getfield stackMapTableEntries : Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   431: iload #5
/*      */     //   433: sipush #251
/*      */     //   436: iadd
/*      */     //   437: invokevirtual putByte : (I)Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   440: iload_3
/*      */     //   441: invokevirtual putShort : (I)Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   444: pop
/*      */     //   445: return
/*      */     //   446: aload_0
/*      */     //   447: getfield stackMapTableEntries : Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   450: iload #5
/*      */     //   452: sipush #251
/*      */     //   455: iadd
/*      */     //   456: invokevirtual putByte : (I)Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   459: iload_3
/*      */     //   460: invokevirtual putShort : (I)Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   463: pop
/*      */     //   464: aload_0
/*      */     //   465: iload #4
/*      */     //   467: iconst_3
/*      */     //   468: iadd
/*      */     //   469: iload_1
/*      */     //   470: iconst_3
/*      */     //   471: iadd
/*      */     //   472: invokespecial putAbstractTypes : (II)V
/*      */     //   475: return
/*      */     //   476: aload_0
/*      */     //   477: getfield stackMapTableEntries : Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   480: sipush #255
/*      */     //   483: invokevirtual putByte : (I)Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   486: iload_3
/*      */     //   487: invokevirtual putShort : (I)Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   490: iload_1
/*      */     //   491: invokevirtual putShort : (I)Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   494: pop
/*      */     //   495: aload_0
/*      */     //   496: iconst_3
/*      */     //   497: iload_1
/*      */     //   498: iconst_3
/*      */     //   499: iadd
/*      */     //   500: invokespecial putAbstractTypes : (II)V
/*      */     //   503: aload_0
/*      */     //   504: getfield stackMapTableEntries : Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   507: iload_2
/*      */     //   508: invokevirtual putShort : (I)Lnet/bytebuddy/jar/asm/ByteVector;
/*      */     //   511: pop
/*      */     //   512: aload_0
/*      */     //   513: iload_1
/*      */     //   514: iconst_3
/*      */     //   515: iadd
/*      */     //   516: iload_1
/*      */     //   517: iconst_3
/*      */     //   518: iadd
/*      */     //   519: iload_2
/*      */     //   520: iadd
/*      */     //   521: invokespecial putAbstractTypes : (II)V
/*      */     //   524: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1860	-> 0
/*      */     //   #1861	-> 7
/*      */     //   #1862	-> 14
/*      */     //   #1864	-> 26
/*      */     //   #1865	-> 44
/*      */     //   #1866	-> 52
/*      */     //   #1867	-> 61
/*      */     //   #1868	-> 73
/*      */     //   #1871	-> 74
/*      */     //   #1872	-> 81
/*      */     //   #1873	-> 90
/*      */     //   #1874	-> 106
/*      */     //   #1875	-> 114
/*      */     //   #1876	-> 120
/*      */     //   #1877	-> 125
/*      */     //   #1878	-> 129
/*      */     //   #1882	-> 172
/*      */     //   #1883	-> 175
/*      */     //   #1885	-> 178
/*      */     //   #1886	-> 193
/*      */     //   #1890	-> 196
/*      */     //   #1891	-> 199
/*      */     //   #1894	-> 202
/*      */     //   #1896	-> 205
/*      */     //   #1898	-> 215
/*      */     //   #1899	-> 221
/*      */     //   #1900	-> 226
/*      */     //   #1902	-> 231
/*      */     //   #1904	-> 239
/*      */     //   #1905	-> 242
/*      */     //   #1906	-> 258
/*      */     //   #1907	-> 275
/*      */     //   #1908	-> 280
/*      */     //   #1910	-> 283
/*      */     //   #1905	-> 286
/*      */     //   #1913	-> 292
/*      */     //   #1915	-> 352
/*      */     //   #1916	-> 361
/*      */     //   #1918	-> 362
/*      */     //   #1919	-> 374
/*      */     //   #1920	-> 384
/*      */     //   #1922	-> 385
/*      */     //   #1923	-> 392
/*      */     //   #1924	-> 396
/*      */     //   #1925	-> 400
/*      */     //   #1926	-> 410
/*      */     //   #1928	-> 411
/*      */     //   #1929	-> 426
/*      */     //   #1931	-> 427
/*      */     //   #1932	-> 437
/*      */     //   #1933	-> 441
/*      */     //   #1934	-> 445
/*      */     //   #1936	-> 446
/*      */     //   #1937	-> 456
/*      */     //   #1938	-> 460
/*      */     //   #1939	-> 464
/*      */     //   #1940	-> 475
/*      */     //   #1943	-> 476
/*      */     //   #1944	-> 495
/*      */     //   #1945	-> 503
/*      */     //   #1946	-> 512
/*      */     //   #1949	-> 524
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void putAbstractTypes(int paramInt1, int paramInt2) {
/* 1959 */     for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/* 1960 */       Frame.a(this.symbolTable, this.currentFrame[paramInt1], this.stackMapTableEntries);
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
/*      */   private void putFrameType(Object paramObject) {
/* 1975 */     if (paramObject instanceof Integer) {
/* 1976 */       this.stackMapTableEntries.putByte(((Integer)paramObject).intValue()); return;
/* 1977 */     }  if (paramObject instanceof String) {
/* 1978 */       this.stackMapTableEntries
/* 1979 */         .putByte(7)
/* 1980 */         .putShort((this.symbolTable.a((String)paramObject)).a); return;
/*      */     } 
/* 1982 */     this.stackMapTableEntries
/* 1983 */       .putByte(8)
/* 1984 */       .putShort(((Label)paramObject).c);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final boolean a(ClassReader paramClassReader, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3) {
/* 2027 */     if (paramClassReader != this.symbolTable.a() || paramInt1 != this.descriptorIndex || paramInt2 != this.signatureIndex || paramBoolean2 != (((this.accessFlags & 0x20000) != 0)))
/*      */     {
/*      */ 
/*      */       
/* 2031 */       return false;
/*      */     }
/*      */     
/* 2034 */     paramBoolean2 = (this.symbolTable.b() < 49 && (this.accessFlags & 0x1000) != 0);
/* 2035 */     if (paramBoolean1 != paramBoolean2) {
/* 2036 */       return false;
/*      */     }
/* 2038 */     if (paramInt3 == 0) {
/* 2039 */       if (this.numberOfExceptions != 0) {
/* 2040 */         return false;
/*      */       }
/* 2042 */     } else if (paramClassReader.readUnsignedShort(paramInt3) == this.numberOfExceptions) {
/* 2043 */       int i = paramInt3 + 2;
/* 2044 */       for (paramBoolean2 = false; paramBoolean2 < this.numberOfExceptions; paramBoolean2++) {
/* 2045 */         if (paramClassReader.readUnsignedShort(i) != this.exceptionIndexTable[paramBoolean2]) {
/* 2046 */           return false;
/*      */         }
/* 2048 */         i += 2;
/*      */       } 
/*      */     } 
/* 2051 */     return true;
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
/*      */   final void b(int paramInt1, int paramInt2) {
/* 2066 */     this.sourceOffset = paramInt1 + 6;
/* 2067 */     this.sourceLength = paramInt2 - 6;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final int d() {
/* 2078 */     if (this.sourceOffset != 0)
/*      */     {
/* 2080 */       return 6 + this.sourceLength;
/*      */     }
/*      */     
/* 2083 */     int i = 8;
/*      */     
/* 2085 */     if (this.code.b > 0) {
/* 2086 */       if (this.code.b > 65535) {
/* 2087 */         throw new MethodTooLargeException(this.symbolTable
/* 2088 */             .c(), this.name, this.descriptor, this.code.b);
/*      */       }
/* 2090 */       this.symbolTable.b("Code");
/*      */ 
/*      */       
/* 2093 */       i = 8 + 16 + this.code.b + Handler.a(this.firstHandler);
/* 2094 */       if (this.stackMapTableEntries != null) {
/* 2095 */         boolean bool = (this.symbolTable.b() >= 50) ? true : false;
/* 2096 */         this.symbolTable.b(bool ? "StackMapTable" : "StackMap");
/*      */         
/* 2098 */         i += 8 + this.stackMapTableEntries.b;
/*      */       } 
/* 2100 */       if (this.lineNumberTable != null) {
/* 2101 */         this.symbolTable.b("LineNumberTable");
/*      */         
/* 2103 */         i += 8 + this.lineNumberTable.b;
/*      */       } 
/* 2105 */       if (this.localVariableTable != null) {
/* 2106 */         this.symbolTable.b("LocalVariableTable");
/*      */         
/* 2108 */         i += 8 + this.localVariableTable.b;
/*      */       } 
/* 2110 */       if (this.localVariableTypeTable != null) {
/* 2111 */         this.symbolTable.b("LocalVariableTypeTable");
/*      */         
/* 2113 */         i += 8 + this.localVariableTypeTable.b;
/*      */       } 
/* 2115 */       if (this.lastCodeRuntimeVisibleTypeAnnotation != null) {
/* 2116 */         i += this.lastCodeRuntimeVisibleTypeAnnotation
/* 2117 */           .a("RuntimeVisibleTypeAnnotations");
/*      */       }
/*      */       
/* 2120 */       if (this.lastCodeRuntimeInvisibleTypeAnnotation != null) {
/* 2121 */         i += this.lastCodeRuntimeInvisibleTypeAnnotation
/* 2122 */           .a("RuntimeInvisibleTypeAnnotations");
/*      */       }
/*      */       
/* 2125 */       if (this.firstCodeAttribute != null) {
/* 2126 */         i += this.firstCodeAttribute
/* 2127 */           .a(this.symbolTable, this.code.a, this.code.b, this.maxStack, this.maxLocals);
/*      */       }
/*      */     } 
/*      */     
/* 2131 */     if (this.numberOfExceptions > 0) {
/* 2132 */       this.symbolTable.b("Exceptions");
/* 2133 */       i += 8 + 2 * this.numberOfExceptions;
/*      */     } 
/*      */ 
/*      */     
/* 2137 */     i = (i = i + Attribute.a(this.symbolTable, this.accessFlags, this.signatureIndex)) + AnnotationWriter.a(this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2142 */     if (this.lastRuntimeVisibleParameterAnnotations != null) {
/* 2143 */       i += 
/* 2144 */         AnnotationWriter.a("RuntimeVisibleParameterAnnotations", this.lastRuntimeVisibleParameterAnnotations, 
/*      */ 
/*      */           
/* 2147 */           (this.visibleAnnotableParameterCount == 0) ? 
/* 2148 */           this.lastRuntimeVisibleParameterAnnotations.length : 
/* 2149 */           this.visibleAnnotableParameterCount);
/*      */     }
/* 2151 */     if (this.lastRuntimeInvisibleParameterAnnotations != null) {
/* 2152 */       i += 
/* 2153 */         AnnotationWriter.a("RuntimeInvisibleParameterAnnotations", this.lastRuntimeInvisibleParameterAnnotations, 
/*      */ 
/*      */           
/* 2156 */           (this.invisibleAnnotableParameterCount == 0) ? 
/* 2157 */           this.lastRuntimeInvisibleParameterAnnotations.length : 
/* 2158 */           this.invisibleAnnotableParameterCount);
/*      */     }
/* 2160 */     if (this.defaultValue != null) {
/* 2161 */       this.symbolTable.b("AnnotationDefault");
/* 2162 */       i += 6 + this.defaultValue.b;
/*      */     } 
/* 2164 */     if (this.parameters != null) {
/* 2165 */       this.symbolTable.b("MethodParameters");
/*      */       
/* 2167 */       i += 7 + this.parameters.b;
/*      */     } 
/* 2169 */     if (this.firstAttribute != null) {
/* 2170 */       i += this.firstAttribute.a(this.symbolTable);
/*      */     }
/* 2172 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final void a(ByteVector paramByteVector) {
/* 2183 */     int i, j = (i = (this.symbolTable.b() < 49) ? 1 : 0) ? 4096 : 0;
/* 2184 */     paramByteVector.putShort(this.accessFlags & (j ^ 0xFFFFFFFF)).putShort(this.nameIndex).putShort(this.descriptorIndex);
/*      */     
/* 2186 */     if (this.sourceOffset != 0) {
/* 2187 */       paramByteVector.putByteArray((this.symbolTable.a()).a, this.sourceOffset, this.sourceLength);
/*      */       
/*      */       return;
/*      */     } 
/* 2191 */     j = 0;
/* 2192 */     if (this.code.b > 0) {
/* 2193 */       j++;
/*      */     }
/* 2195 */     if (this.numberOfExceptions > 0) {
/* 2196 */       j++;
/*      */     }
/* 2198 */     if ((this.accessFlags & 0x1000) != 0 && i) {
/* 2199 */       j++;
/*      */     }
/* 2201 */     if (this.signatureIndex != 0) {
/* 2202 */       j++;
/*      */     }
/* 2204 */     if ((this.accessFlags & 0x20000) != 0) {
/* 2205 */       j++;
/*      */     }
/* 2207 */     if (this.lastRuntimeVisibleAnnotation != null) {
/* 2208 */       j++;
/*      */     }
/* 2210 */     if (this.lastRuntimeInvisibleAnnotation != null) {
/* 2211 */       j++;
/*      */     }
/* 2213 */     if (this.lastRuntimeVisibleParameterAnnotations != null) {
/* 2214 */       j++;
/*      */     }
/* 2216 */     if (this.lastRuntimeInvisibleParameterAnnotations != null) {
/* 2217 */       j++;
/*      */     }
/* 2219 */     if (this.lastRuntimeVisibleTypeAnnotation != null) {
/* 2220 */       j++;
/*      */     }
/* 2222 */     if (this.lastRuntimeInvisibleTypeAnnotation != null) {
/* 2223 */       j++;
/*      */     }
/* 2225 */     if (this.defaultValue != null) {
/* 2226 */       j++;
/*      */     }
/* 2228 */     if (this.parameters != null) {
/* 2229 */       j++;
/*      */     }
/* 2231 */     if (this.firstAttribute != null) {
/* 2232 */       j += this.firstAttribute.a();
/*      */     }
/*      */     
/* 2235 */     paramByteVector.putShort(j);
/* 2236 */     if (this.code.b > 0) {
/*      */ 
/*      */       
/* 2239 */       i = 10 + this.code.b + Handler.a(this.firstHandler);
/* 2240 */       j = 0;
/* 2241 */       if (this.stackMapTableEntries != null) {
/*      */         
/* 2243 */         i += 8 + this.stackMapTableEntries.b;
/* 2244 */         j++;
/*      */       } 
/* 2246 */       if (this.lineNumberTable != null) {
/*      */         
/* 2248 */         i += 8 + this.lineNumberTable.b;
/* 2249 */         j++;
/*      */       } 
/* 2251 */       if (this.localVariableTable != null) {
/*      */         
/* 2253 */         i += 8 + this.localVariableTable.b;
/* 2254 */         j++;
/*      */       } 
/* 2256 */       if (this.localVariableTypeTable != null) {
/*      */         
/* 2258 */         i += 8 + this.localVariableTypeTable.b;
/* 2259 */         j++;
/*      */       } 
/* 2261 */       if (this.lastCodeRuntimeVisibleTypeAnnotation != null) {
/* 2262 */         i += this.lastCodeRuntimeVisibleTypeAnnotation
/* 2263 */           .a("RuntimeVisibleTypeAnnotations");
/*      */         
/* 2265 */         j++;
/*      */       } 
/* 2267 */       if (this.lastCodeRuntimeInvisibleTypeAnnotation != null) {
/* 2268 */         i += this.lastCodeRuntimeInvisibleTypeAnnotation
/* 2269 */           .a("RuntimeInvisibleTypeAnnotations");
/*      */         
/* 2271 */         j++;
/*      */       } 
/* 2273 */       if (this.firstCodeAttribute != null) {
/* 2274 */         i += this.firstCodeAttribute
/* 2275 */           .a(this.symbolTable, this.code.a, this.code.b, this.maxStack, this.maxLocals);
/*      */         
/* 2277 */         j += this.firstCodeAttribute.a();
/*      */       } 
/* 2279 */       paramByteVector
/* 2280 */         .putShort(this.symbolTable.b("Code"))
/* 2281 */         .putInt(i)
/* 2282 */         .putShort(this.maxStack)
/* 2283 */         .putShort(this.maxLocals)
/* 2284 */         .putInt(this.code.b)
/* 2285 */         .putByteArray(this.code.a, 0, this.code.b);
/* 2286 */       Handler.a(this.firstHandler, paramByteVector);
/* 2287 */       paramByteVector.putShort(j);
/* 2288 */       if (this.stackMapTableEntries != null) {
/* 2289 */         boolean bool = (this.symbolTable.b() >= 50) ? true : false;
/* 2290 */         paramByteVector
/* 2291 */           .putShort(this.symbolTable
/* 2292 */             .b(
/* 2293 */               bool ? "StackMapTable" : "StackMap"))
/* 2294 */           .putInt(2 + this.stackMapTableEntries.b)
/* 2295 */           .putShort(this.stackMapTableNumberOfEntries)
/* 2296 */           .putByteArray(this.stackMapTableEntries.a, 0, this.stackMapTableEntries.b);
/*      */       } 
/* 2298 */       if (this.lineNumberTable != null) {
/* 2299 */         paramByteVector
/* 2300 */           .putShort(this.symbolTable.b("LineNumberTable"))
/* 2301 */           .putInt(2 + this.lineNumberTable.b)
/* 2302 */           .putShort(this.lineNumberTableLength)
/* 2303 */           .putByteArray(this.lineNumberTable.a, 0, this.lineNumberTable.b);
/*      */       }
/* 2305 */       if (this.localVariableTable != null) {
/* 2306 */         paramByteVector
/* 2307 */           .putShort(this.symbolTable.b("LocalVariableTable"))
/* 2308 */           .putInt(2 + this.localVariableTable.b)
/* 2309 */           .putShort(this.localVariableTableLength)
/* 2310 */           .putByteArray(this.localVariableTable.a, 0, this.localVariableTable.b);
/*      */       }
/* 2312 */       if (this.localVariableTypeTable != null) {
/* 2313 */         paramByteVector
/* 2314 */           .putShort(this.symbolTable.b("LocalVariableTypeTable"))
/* 2315 */           .putInt(2 + this.localVariableTypeTable.b)
/* 2316 */           .putShort(this.localVariableTypeTableLength)
/* 2317 */           .putByteArray(this.localVariableTypeTable.a, 0, this.localVariableTypeTable.b);
/*      */       }
/* 2319 */       if (this.lastCodeRuntimeVisibleTypeAnnotation != null) {
/* 2320 */         this.lastCodeRuntimeVisibleTypeAnnotation.a(this.symbolTable
/* 2321 */             .b("RuntimeVisibleTypeAnnotations"), paramByteVector);
/*      */       }
/* 2323 */       if (this.lastCodeRuntimeInvisibleTypeAnnotation != null) {
/* 2324 */         this.lastCodeRuntimeInvisibleTypeAnnotation.a(this.symbolTable
/* 2325 */             .b("RuntimeInvisibleTypeAnnotations"), paramByteVector);
/*      */       }
/* 2327 */       if (this.firstCodeAttribute != null) {
/* 2328 */         this.firstCodeAttribute.a(this.symbolTable, this.code.a, this.code.b, this.maxStack, this.maxLocals, paramByteVector);
/*      */       }
/*      */     } 
/*      */     
/* 2332 */     if (this.numberOfExceptions > 0) {
/* 2333 */       paramByteVector
/* 2334 */         .putShort(this.symbolTable.b("Exceptions"))
/* 2335 */         .putInt(2 + 2 * this.numberOfExceptions)
/* 2336 */         .putShort(this.numberOfExceptions); int[] arrayOfInt; byte b;
/* 2337 */       for (j = (arrayOfInt = this.exceptionIndexTable).length, b = 0; b < j; ) { int k = arrayOfInt[b];
/* 2338 */         paramByteVector.putShort(k); b++; }
/*      */     
/*      */     } 
/* 2341 */     Attribute.a(this.symbolTable, this.accessFlags, this.signatureIndex, paramByteVector);
/* 2342 */     AnnotationWriter.a(this.symbolTable, this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation, paramByteVector);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2349 */     if (this.lastRuntimeVisibleParameterAnnotations != null) {
/* 2350 */       AnnotationWriter.a(this.symbolTable
/* 2351 */           .b("RuntimeVisibleParameterAnnotations"), this.lastRuntimeVisibleParameterAnnotations, 
/*      */           
/* 2353 */           (this.visibleAnnotableParameterCount == 0) ? 
/* 2354 */           this.lastRuntimeVisibleParameterAnnotations.length : 
/* 2355 */           this.visibleAnnotableParameterCount, paramByteVector);
/*      */     }
/*      */     
/* 2358 */     if (this.lastRuntimeInvisibleParameterAnnotations != null) {
/* 2359 */       AnnotationWriter.a(this.symbolTable
/* 2360 */           .b("RuntimeInvisibleParameterAnnotations"), this.lastRuntimeInvisibleParameterAnnotations, 
/*      */           
/* 2362 */           (this.invisibleAnnotableParameterCount == 0) ? 
/* 2363 */           this.lastRuntimeInvisibleParameterAnnotations.length : 
/* 2364 */           this.invisibleAnnotableParameterCount, paramByteVector);
/*      */     }
/*      */     
/* 2367 */     if (this.defaultValue != null) {
/* 2368 */       paramByteVector
/* 2369 */         .putShort(this.symbolTable.b("AnnotationDefault"))
/* 2370 */         .putInt(this.defaultValue.b)
/* 2371 */         .putByteArray(this.defaultValue.a, 0, this.defaultValue.b);
/*      */     }
/* 2373 */     if (this.parameters != null) {
/* 2374 */       paramByteVector
/* 2375 */         .putShort(this.symbolTable.b("MethodParameters"))
/* 2376 */         .putInt(1 + this.parameters.b)
/* 2377 */         .putByte(this.parametersCount)
/* 2378 */         .putByteArray(this.parameters.a, 0, this.parameters.b);
/*      */     }
/* 2380 */     if (this.firstAttribute != null) {
/* 2381 */       this.firstAttribute.a(this.symbolTable, paramByteVector);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final void a(Attribute.Set paramSet) {
/* 2391 */     paramSet.a(this.firstAttribute);
/* 2392 */     paramSet.a(this.firstCodeAttribute);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\MethodWriter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */