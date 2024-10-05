/*     */ package net.bytebuddy.jar.asm;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class RecordComponentWriter
/*     */   extends RecordComponentVisitor
/*     */ {
/*     */   private final SymbolTable symbolTable;
/*     */   private final int nameIndex;
/*     */   private final int descriptorIndex;
/*     */   private int signatureIndex;
/*     */   private AnnotationWriter lastRuntimeVisibleAnnotation;
/*     */   private AnnotationWriter lastRuntimeInvisibleAnnotation;
/*     */   private AnnotationWriter lastRuntimeVisibleTypeAnnotation;
/*     */   private AnnotationWriter lastRuntimeInvisibleTypeAnnotation;
/*     */   private Attribute firstAttribute;
/*     */   
/*     */   RecordComponentWriter(SymbolTable paramSymbolTable, String paramString1, String paramString2, String paramString3) {
/*  97 */     super(589824);
/*  98 */     this.symbolTable = paramSymbolTable;
/*  99 */     this.nameIndex = paramSymbolTable.b(paramString1);
/* 100 */     this.descriptorIndex = paramSymbolTable.b(paramString2);
/* 101 */     if (paramString3 != null) {
/* 102 */       this.signatureIndex = paramSymbolTable.b(paramString3);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean) {
/* 112 */     if (paramBoolean) {
/* 113 */       return this
/* 114 */         .lastRuntimeVisibleAnnotation = AnnotationWriter.a(this.symbolTable, paramString, this.lastRuntimeVisibleAnnotation);
/*     */     }
/* 116 */     return this
/* 117 */       .lastRuntimeInvisibleAnnotation = AnnotationWriter.a(this.symbolTable, paramString, this.lastRuntimeInvisibleAnnotation);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final AnnotationVisitor visitTypeAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
/* 124 */     if (paramBoolean) {
/* 125 */       return this
/* 126 */         .lastRuntimeVisibleTypeAnnotation = AnnotationWriter.a(this.symbolTable, paramInt, paramTypePath, paramString, this.lastRuntimeVisibleTypeAnnotation);
/*     */     }
/*     */     
/* 129 */     return this
/* 130 */       .lastRuntimeInvisibleTypeAnnotation = AnnotationWriter.a(this.symbolTable, paramInt, paramTypePath, paramString, this.lastRuntimeInvisibleTypeAnnotation);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void visitAttribute(Attribute paramAttribute) {
/* 138 */     paramAttribute.a = this.firstAttribute;
/* 139 */     this.firstAttribute = paramAttribute;
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
/*     */   public final void visitEnd() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final int a() {
/* 163 */     int i = (i = 6 + Attribute.a(this.symbolTable, 0, this.signatureIndex)) + AnnotationWriter.a(this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 168 */     if (this.firstAttribute != null) {
/* 169 */       i += this.firstAttribute.a(this.symbolTable);
/*     */     }
/* 171 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void a(ByteVector paramByteVector) {
/* 181 */     paramByteVector.putShort(this.nameIndex).putShort(this.descriptorIndex);
/*     */ 
/*     */     
/* 184 */     int i = 0;
/* 185 */     if (this.signatureIndex != 0) {
/* 186 */       i++;
/*     */     }
/* 188 */     if (this.lastRuntimeVisibleAnnotation != null) {
/* 189 */       i++;
/*     */     }
/* 191 */     if (this.lastRuntimeInvisibleAnnotation != null) {
/* 192 */       i++;
/*     */     }
/* 194 */     if (this.lastRuntimeVisibleTypeAnnotation != null) {
/* 195 */       i++;
/*     */     }
/* 197 */     if (this.lastRuntimeInvisibleTypeAnnotation != null) {
/* 198 */       i++;
/*     */     }
/* 200 */     if (this.firstAttribute != null) {
/* 201 */       i += this.firstAttribute.a();
/*     */     }
/* 203 */     paramByteVector.putShort(i);
/* 204 */     Attribute.a(this.symbolTable, 0, this.signatureIndex, paramByteVector);
/* 205 */     AnnotationWriter.a(this.symbolTable, this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation, paramByteVector);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 212 */     if (this.firstAttribute != null) {
/* 213 */       this.firstAttribute.a(this.symbolTable, paramByteVector);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void a(Attribute.Set paramSet) {
/* 223 */     paramSet.a(this.firstAttribute);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\RecordComponentWriter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */