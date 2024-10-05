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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class FieldWriter
/*     */   extends FieldVisitor
/*     */ {
/*     */   private final SymbolTable symbolTable;
/*     */   private final int accessFlags;
/*     */   private final int nameIndex;
/*     */   private final int descriptorIndex;
/*     */   private int signatureIndex;
/*     */   private int constantValueIndex;
/*     */   private AnnotationWriter lastRuntimeVisibleAnnotation;
/*     */   private AnnotationWriter lastRuntimeInvisibleAnnotation;
/*     */   private AnnotationWriter lastRuntimeVisibleTypeAnnotation;
/*     */   private AnnotationWriter lastRuntimeInvisibleTypeAnnotation;
/*     */   private Attribute firstAttribute;
/*     */   
/*     */   FieldWriter(SymbolTable paramSymbolTable, int paramInt, String paramString1, String paramString2, String paramString3, Object paramObject) {
/* 127 */     super(589824);
/* 128 */     this.symbolTable = paramSymbolTable;
/* 129 */     this.accessFlags = paramInt;
/* 130 */     this.nameIndex = paramSymbolTable.b(paramString1);
/* 131 */     this.descriptorIndex = paramSymbolTable.b(paramString2);
/* 132 */     if (paramString3 != null) {
/* 133 */       this.signatureIndex = paramSymbolTable.b(paramString3);
/*     */     }
/* 135 */     if (paramObject != null) {
/* 136 */       this.constantValueIndex = (paramSymbolTable.a(paramObject)).a;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean) {
/* 146 */     if (paramBoolean) {
/* 147 */       return this
/* 148 */         .lastRuntimeVisibleAnnotation = AnnotationWriter.a(this.symbolTable, paramString, this.lastRuntimeVisibleAnnotation);
/*     */     }
/* 150 */     return this
/* 151 */       .lastRuntimeInvisibleAnnotation = AnnotationWriter.a(this.symbolTable, paramString, this.lastRuntimeInvisibleAnnotation);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final AnnotationVisitor visitTypeAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
/* 158 */     if (paramBoolean) {
/* 159 */       return this
/* 160 */         .lastRuntimeVisibleTypeAnnotation = AnnotationWriter.a(this.symbolTable, paramInt, paramTypePath, paramString, this.lastRuntimeVisibleTypeAnnotation);
/*     */     }
/*     */     
/* 163 */     return this
/* 164 */       .lastRuntimeInvisibleTypeAnnotation = AnnotationWriter.a(this.symbolTable, paramInt, paramTypePath, paramString, this.lastRuntimeInvisibleTypeAnnotation);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void visitAttribute(Attribute paramAttribute) {
/* 172 */     paramAttribute.a = this.firstAttribute;
/* 173 */     this.firstAttribute = paramAttribute;
/*     */   }
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
/*     */   final int a() {
/* 193 */     int i = 8;
/*     */     
/* 195 */     if (this.constantValueIndex != 0) {
/*     */       
/* 197 */       this.symbolTable.b("ConstantValue");
/* 198 */       i += 8;
/*     */     } 
/*     */ 
/*     */     
/* 202 */     i = (i = i + Attribute.a(this.symbolTable, this.accessFlags, this.signatureIndex)) + AnnotationWriter.a(this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 207 */     if (this.firstAttribute != null) {
/* 208 */       i += this.firstAttribute.a(this.symbolTable);
/*     */     }
/* 210 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void a(ByteVector paramByteVector) {
/*     */     boolean bool;
/* 222 */     int i = (bool = (this.symbolTable.b() < 49) ? true : false) ? 4096 : 0;
/* 223 */     paramByteVector.putShort(this.accessFlags & (i ^ 0xFFFFFFFF)).putShort(this.nameIndex).putShort(this.descriptorIndex);
/*     */ 
/*     */     
/* 226 */     i = 0;
/* 227 */     if (this.constantValueIndex != 0) {
/* 228 */       i++;
/*     */     }
/* 230 */     if ((this.accessFlags & 0x1000) != 0 && bool) {
/* 231 */       i++;
/*     */     }
/* 233 */     if (this.signatureIndex != 0) {
/* 234 */       i++;
/*     */     }
/* 236 */     if ((this.accessFlags & 0x20000) != 0) {
/* 237 */       i++;
/*     */     }
/* 239 */     if (this.lastRuntimeVisibleAnnotation != null) {
/* 240 */       i++;
/*     */     }
/* 242 */     if (this.lastRuntimeInvisibleAnnotation != null) {
/* 243 */       i++;
/*     */     }
/* 245 */     if (this.lastRuntimeVisibleTypeAnnotation != null) {
/* 246 */       i++;
/*     */     }
/* 248 */     if (this.lastRuntimeInvisibleTypeAnnotation != null) {
/* 249 */       i++;
/*     */     }
/* 251 */     if (this.firstAttribute != null) {
/* 252 */       i += this.firstAttribute.a();
/*     */     }
/* 254 */     paramByteVector.putShort(i);
/*     */ 
/*     */     
/* 257 */     if (this.constantValueIndex != 0) {
/* 258 */       paramByteVector
/* 259 */         .putShort(this.symbolTable.b("ConstantValue"))
/* 260 */         .putInt(2)
/* 261 */         .putShort(this.constantValueIndex);
/*     */     }
/* 263 */     Attribute.a(this.symbolTable, this.accessFlags, this.signatureIndex, paramByteVector);
/* 264 */     AnnotationWriter.a(this.symbolTable, this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation, paramByteVector);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 271 */     if (this.firstAttribute != null) {
/* 272 */       this.firstAttribute.a(this.symbolTable, paramByteVector);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void a(Attribute.Set paramSet) {
/* 282 */     paramSet.a(this.firstAttribute);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\FieldWriter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */