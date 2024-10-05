/*     */ package net.bytebuddy.jar.asm.commons;
/*     */ 
/*     */ import net.bytebuddy.jar.asm.AnnotationVisitor;
/*     */ import net.bytebuddy.jar.asm.Handle;
/*     */ import net.bytebuddy.jar.asm.Label;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.jar.asm.TypePath;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MethodRemapper
/*     */   extends MethodVisitor
/*     */ {
/*     */   protected final Remapper remapper;
/*     */   
/*     */   public MethodRemapper(MethodVisitor paramMethodVisitor, Remapper paramRemapper) {
/*  56 */     this(589824, paramMethodVisitor, paramRemapper);
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
/*     */   protected MethodRemapper(int paramInt, MethodVisitor paramMethodVisitor, Remapper paramRemapper) {
/*  69 */     super(paramInt, paramMethodVisitor);
/*  70 */     this.remapper = paramRemapper;
/*     */   }
/*     */ 
/*     */   
/*     */   public AnnotationVisitor visitAnnotationDefault() {
/*     */     AnnotationVisitor annotationVisitor;
/*  76 */     if ((annotationVisitor = super.visitAnnotationDefault()) == null)
/*  77 */       return annotationVisitor; 
/*  78 */     return createAnnotationRemapper(null, annotationVisitor);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean) {
/*     */     AnnotationVisitor annotationVisitor;
/*  85 */     if ((annotationVisitor = super.visitAnnotation(this.remapper.mapDesc(paramString), paramBoolean)) == null)
/*  86 */       return annotationVisitor; 
/*  87 */     return createAnnotationRemapper(paramString, annotationVisitor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationVisitor visitTypeAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
/*     */     AnnotationVisitor annotationVisitor;
/*  95 */     if ((annotationVisitor = super.visitTypeAnnotation(paramInt, paramTypePath, this.remapper.mapDesc(paramString), paramBoolean)) == null)
/*  96 */       return annotationVisitor; 
/*  97 */     return createAnnotationRemapper(paramString, annotationVisitor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationVisitor visitParameterAnnotation(int paramInt, String paramString, boolean paramBoolean) {
/*     */     AnnotationVisitor annotationVisitor;
/* 105 */     if ((annotationVisitor = super.visitParameterAnnotation(paramInt, this.remapper.mapDesc(paramString), paramBoolean)) == null)
/* 106 */       return annotationVisitor; 
/* 107 */     return createAnnotationRemapper(paramString, annotationVisitor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitFrame(int paramInt1, int paramInt2, Object[] paramArrayOfObject1, int paramInt3, Object[] paramArrayOfObject2) {
/* 117 */     super.visitFrame(paramInt1, paramInt2, 
/*     */ 
/*     */         
/* 120 */         remapFrameTypes(paramInt2, paramArrayOfObject1), paramInt3, 
/*     */         
/* 122 */         remapFrameTypes(paramInt3, paramArrayOfObject2));
/*     */   }
/*     */   
/*     */   private Object[] remapFrameTypes(int paramInt, Object[] paramArrayOfObject) {
/* 126 */     if (paramArrayOfObject == null) {
/* 127 */       return paramArrayOfObject;
/*     */     }
/* 129 */     Object[] arrayOfObject = null;
/* 130 */     for (byte b = 0; b < paramInt; b++) {
/* 131 */       if (paramArrayOfObject[b] instanceof String) {
/* 132 */         if (arrayOfObject == null) {
/* 133 */           arrayOfObject = new Object[paramInt];
/* 134 */           System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
/*     */         } 
/* 136 */         arrayOfObject[b] = this.remapper.mapType((String)paramArrayOfObject[b]);
/*     */       } 
/*     */     } 
/* 139 */     return (arrayOfObject == null) ? paramArrayOfObject : arrayOfObject;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitFieldInsn(int paramInt, String paramString1, String paramString2, String paramString3) {
/* 145 */     super.visitFieldInsn(paramInt, this.remapper
/*     */         
/* 147 */         .mapType(paramString1), this.remapper
/* 148 */         .mapFieldName(paramString1, paramString2, paramString3), this.remapper
/* 149 */         .mapDesc(paramString3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitMethodInsn(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
/* 159 */     if (this.api < 327680 && (paramInt & 0x100) == 0) {
/*     */       
/* 161 */       super.visitMethodInsn(paramInt, paramString1, paramString2, paramString3, paramBoolean);
/*     */       return;
/*     */     } 
/* 164 */     super.visitMethodInsn(paramInt, this.remapper
/*     */         
/* 166 */         .mapType(paramString1), this.remapper
/* 167 */         .mapMethodName(paramString1, paramString2, paramString3), this.remapper
/* 168 */         .mapMethodDesc(paramString3), paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitInvokeDynamicInsn(String paramString1, String paramString2, Handle paramHandle, Object... paramVarArgs) {
/* 178 */     Object[] arrayOfObject = new Object[paramVarArgs.length];
/* 179 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/* 180 */       arrayOfObject[b] = this.remapper.mapValue(paramVarArgs[b]);
/*     */     }
/* 182 */     super.visitInvokeDynamicInsn(this.remapper
/* 183 */         .mapInvokeDynamicMethodName(paramString1, paramString2), this.remapper
/* 184 */         .mapMethodDesc(paramString2), (Handle)this.remapper
/* 185 */         .mapValue(paramHandle), arrayOfObject);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitTypeInsn(int paramInt, String paramString) {
/* 191 */     super.visitTypeInsn(paramInt, this.remapper.mapType(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitLdcInsn(Object paramObject) {
/* 196 */     super.visitLdcInsn(this.remapper.mapValue(paramObject));
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitMultiANewArrayInsn(String paramString, int paramInt) {
/* 201 */     super.visitMultiANewArrayInsn(this.remapper.mapDesc(paramString), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationVisitor visitInsnAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
/*     */     AnnotationVisitor annotationVisitor;
/* 209 */     if ((annotationVisitor = super.visitInsnAnnotation(paramInt, paramTypePath, this.remapper.mapDesc(paramString), paramBoolean)) == null)
/* 210 */       return annotationVisitor; 
/* 211 */     return createAnnotationRemapper(paramString, annotationVisitor);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitTryCatchBlock(Label paramLabel1, Label paramLabel2, Label paramLabel3, String paramString) {
/* 217 */     super.visitTryCatchBlock(paramLabel1, paramLabel2, paramLabel3, (paramString == null) ? null : this.remapper.mapType(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationVisitor visitTryCatchAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
/*     */     AnnotationVisitor annotationVisitor;
/* 225 */     if ((annotationVisitor = super.visitTryCatchAnnotation(paramInt, paramTypePath, this.remapper.mapDesc(paramString), paramBoolean)) == null)
/* 226 */       return annotationVisitor; 
/* 227 */     return createAnnotationRemapper(paramString, annotationVisitor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitLocalVariable(String paramString1, String paramString2, String paramString3, Label paramLabel1, Label paramLabel2, int paramInt) {
/* 238 */     super.visitLocalVariable(paramString1, this.remapper
/*     */         
/* 240 */         .mapDesc(paramString2), this.remapper
/* 241 */         .mapSignature(paramString3, true), paramLabel1, paramLabel2, paramInt);
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
/*     */   public AnnotationVisitor visitLocalVariableAnnotation(int paramInt, TypePath paramTypePath, Label[] paramArrayOfLabel1, Label[] paramArrayOfLabel2, int[] paramArrayOfint, String paramString, boolean paramBoolean) {
/*     */     AnnotationVisitor annotationVisitor;
/* 259 */     if ((annotationVisitor = super.visitLocalVariableAnnotation(paramInt, paramTypePath, paramArrayOfLabel1, paramArrayOfLabel2, paramArrayOfint, this.remapper.mapDesc(paramString), paramBoolean)) == null)
/* 260 */       return annotationVisitor; 
/* 261 */     return createAnnotationRemapper(paramString, annotationVisitor);
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
/*     */   @Deprecated
/*     */   protected AnnotationVisitor createAnnotationRemapper(AnnotationVisitor paramAnnotationVisitor) {
/* 274 */     return new AnnotationRemapper(this.api, null, paramAnnotationVisitor, this.remapper);
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
/*     */   protected AnnotationVisitor createAnnotationRemapper(String paramString, AnnotationVisitor paramAnnotationVisitor) {
/* 287 */     return (new AnnotationRemapper(this.api, paramString, paramAnnotationVisitor, this.remapper))
/* 288 */       .a(createAnnotationRemapper(paramAnnotationVisitor));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\commons\MethodRemapper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */