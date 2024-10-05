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
/*     */ public abstract class ClassVisitor
/*     */ {
/*     */   protected final int api;
/*     */   protected ClassVisitor cv;
/*     */   
/*     */   protected ClassVisitor(int paramInt) {
/*  58 */     this(paramInt, null);
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
/*     */   protected ClassVisitor(int paramInt, ClassVisitor paramClassVisitor) {
/*  70 */     if (paramInt != 589824 && paramInt != 524288 && paramInt != 458752 && paramInt != 393216 && paramInt != 327680 && paramInt != 262144 && paramInt != 17432576)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  77 */       throw new IllegalArgumentException("Unsupported api " + paramInt);
/*     */     }
/*  79 */     if (paramInt == 17432576) {
/*  80 */       Constants.a(this);
/*     */     }
/*  82 */     this.api = paramInt;
/*  83 */     this.cv = paramClassVisitor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassVisitor getDelegate() {
/*  92 */     return this.cv;
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
/*     */   public void visit(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString) {
/* 119 */     if (this.api < 524288 && (paramInt2 & 0x10000) != 0) {
/* 120 */       throw new UnsupportedOperationException("Records requires ASM8");
/*     */     }
/* 122 */     if (this.cv != null) {
/* 123 */       this.cv.visit(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramArrayOfString);
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
/*     */   public void visitSource(String paramString1, String paramString2) {
/* 136 */     if (this.cv != null) {
/* 137 */       this.cv.visitSource(paramString1, paramString2);
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
/*     */   public ModuleVisitor visitModule(String paramString1, int paramInt, String paramString2) {
/* 152 */     if (this.api < 393216) {
/* 153 */       throw new UnsupportedOperationException("Module requires ASM6");
/*     */     }
/* 155 */     if (this.cv != null) {
/* 156 */       return this.cv.visitModule(paramString1, paramInt, paramString2);
/*     */     }
/* 158 */     return null;
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
/*     */   public void visitNestHost(String paramString) {
/* 173 */     if (this.api < 458752) {
/* 174 */       throw new UnsupportedOperationException("NestHost requires ASM7");
/*     */     }
/* 176 */     if (this.cv != null) {
/* 177 */       this.cv.visitNestHost(paramString);
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
/*     */   public void visitOuterClass(String paramString1, String paramString2, String paramString3) {
/* 197 */     if (this.cv != null) {
/* 198 */       this.cv.visitOuterClass(paramString1, paramString2, paramString3);
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
/*     */   public AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean) {
/* 211 */     if (this.cv != null) {
/* 212 */       return this.cv.visitAnnotation(paramString, paramBoolean);
/*     */     }
/* 214 */     return null;
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
/*     */   public AnnotationVisitor visitTypeAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
/* 234 */     if (this.api < 327680) {
/* 235 */       throw new UnsupportedOperationException("TypeAnnotation requires ASM5");
/*     */     }
/* 237 */     if (this.cv != null) {
/* 238 */       return this.cv.visitTypeAnnotation(paramInt, paramTypePath, paramString, paramBoolean);
/*     */     }
/* 240 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitAttribute(Attribute paramAttribute) {
/* 249 */     if (this.cv != null) {
/* 250 */       this.cv.visitAttribute(paramAttribute);
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
/*     */   public void visitNestMember(String paramString) {
/* 264 */     if (this.api < 458752) {
/* 265 */       throw new UnsupportedOperationException("NestMember requires ASM7");
/*     */     }
/* 267 */     if (this.cv != null) {
/* 268 */       this.cv.visitNestMember(paramString);
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
/*     */   public void visitPermittedSubclass(String paramString) {
/* 280 */     if (this.api < 589824) {
/* 281 */       throw new UnsupportedOperationException("PermittedSubclasses requires ASM9");
/*     */     }
/* 283 */     if (this.cv != null) {
/* 284 */       this.cv.visitPermittedSubclass(paramString);
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
/*     */   public void visitInnerClass(String paramString1, String paramString2, String paramString3, int paramInt) {
/* 305 */     if (this.cv != null) {
/* 306 */       this.cv.visitInnerClass(paramString1, paramString2, paramString3, paramInt);
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
/*     */   public RecordComponentVisitor visitRecordComponent(String paramString1, String paramString2, String paramString3) {
/* 322 */     if (this.api < 524288) {
/* 323 */       throw new UnsupportedOperationException("Record requires ASM8");
/*     */     }
/* 325 */     if (this.cv != null) {
/* 326 */       return this.cv.visitRecordComponent(paramString1, paramString2, paramString3);
/*     */     }
/* 328 */     return null;
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
/*     */   public FieldVisitor visitField(int paramInt, String paramString1, String paramString2, String paramString3, Object paramObject) {
/* 355 */     if (this.cv != null) {
/* 356 */       return this.cv.visitField(paramInt, paramString1, paramString2, paramString3, paramObject);
/*     */     }
/* 358 */     return null;
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
/*     */   public MethodVisitor visitMethod(int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString) {
/* 383 */     if (this.cv != null) {
/* 384 */       return this.cv.visitMethod(paramInt, paramString1, paramString2, paramString3, paramArrayOfString);
/*     */     }
/* 386 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitEnd() {
/* 394 */     if (this.cv != null)
/* 395 */       this.cv.visitEnd(); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\ClassVisitor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */