/*     */ package net.bytebuddy.jar.asm.commons;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.bytebuddy.jar.asm.AnnotationVisitor;
/*     */ import net.bytebuddy.jar.asm.Attribute;
/*     */ import net.bytebuddy.jar.asm.ClassVisitor;
/*     */ import net.bytebuddy.jar.asm.FieldVisitor;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.jar.asm.ModuleVisitor;
/*     */ import net.bytebuddy.jar.asm.RecordComponentVisitor;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClassRemapper
/*     */   extends ClassVisitor
/*     */ {
/*     */   protected final Remapper remapper;
/*     */   protected String className;
/*     */   
/*     */   public ClassRemapper(ClassVisitor paramClassVisitor, Remapper paramRemapper) {
/*  77 */     this(589824, paramClassVisitor, paramRemapper);
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
/*     */   protected ClassRemapper(int paramInt, ClassVisitor paramClassVisitor, Remapper paramRemapper) {
/*  89 */     super(paramInt, paramClassVisitor);
/*  90 */     this.remapper = paramRemapper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visit(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString) {
/* 101 */     this.className = paramString1;
/* 102 */     super.visit(paramInt1, paramInt2, this.remapper
/*     */ 
/*     */         
/* 105 */         .mapType(paramString1), this.remapper
/* 106 */         .mapSignature(paramString2, false), this.remapper
/* 107 */         .mapType(paramString3), 
/* 108 */         (paramArrayOfString == null) ? null : this.remapper.mapTypes(paramArrayOfString));
/*     */   }
/*     */ 
/*     */   
/*     */   public ModuleVisitor visitModule(String paramString1, int paramInt, String paramString2) {
/*     */     ModuleVisitor moduleVisitor;
/* 114 */     return ((moduleVisitor = super.visitModule(this.remapper.mapModuleName(paramString1), paramInt, paramString2)) == null) ? null : createModuleRemapper(moduleVisitor);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean) {
/*     */     AnnotationVisitor annotationVisitor;
/* 121 */     if ((annotationVisitor = super.visitAnnotation(this.remapper.mapDesc(paramString), paramBoolean)) == null)
/* 122 */       return null; 
/* 123 */     return createAnnotationRemapper(paramString, annotationVisitor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationVisitor visitTypeAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
/*     */     AnnotationVisitor annotationVisitor;
/* 131 */     if ((annotationVisitor = super.visitTypeAnnotation(paramInt, paramTypePath, this.remapper.mapDesc(paramString), paramBoolean)) == null)
/* 132 */       return null; 
/* 133 */     return createAnnotationRemapper(paramString, annotationVisitor);
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitAttribute(Attribute paramAttribute) {
/* 138 */     if (paramAttribute instanceof ModuleHashesAttribute) {
/*     */       ModuleHashesAttribute moduleHashesAttribute;
/* 140 */       List<String> list = (moduleHashesAttribute = (ModuleHashesAttribute)paramAttribute).modules;
/* 141 */       for (byte b = 0; b < list.size(); b++) {
/* 142 */         list.set(b, this.remapper.mapModuleName(list.get(b)));
/*     */       }
/*     */     } 
/* 145 */     super.visitAttribute(paramAttribute);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RecordComponentVisitor visitRecordComponent(String paramString1, String paramString2, String paramString3) {
/*     */     RecordComponentVisitor recordComponentVisitor;
/* 156 */     if ((recordComponentVisitor = super.visitRecordComponent(this.remapper.mapRecordComponentName(this.className, paramString1, paramString2), this.remapper.mapDesc(paramString2), this.remapper.mapSignature(paramString3, true))) == null)
/* 157 */       return null; 
/* 158 */     return createRecordComponentRemapper(recordComponentVisitor);
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
/*     */   public FieldVisitor visitField(int paramInt, String paramString1, String paramString2, String paramString3, Object paramObject) {
/*     */     FieldVisitor fieldVisitor;
/* 175 */     return ((fieldVisitor = super.visitField(paramInt, this.remapper.mapFieldName(this.className, paramString1, paramString2), this.remapper.mapDesc(paramString2), this.remapper.mapSignature(paramString3, true), (paramObject == null) ? null : this.remapper.mapValue(paramObject))) == null) ? null : createFieldRemapper(fieldVisitor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MethodVisitor visitMethod(int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString) {
/* 185 */     String str = this.remapper.mapMethodDesc(paramString2);
/*     */ 
/*     */ 
/*     */     
/*     */     MethodVisitor methodVisitor;
/*     */ 
/*     */ 
/*     */     
/* 193 */     return ((methodVisitor = super.visitMethod(paramInt, this.remapper.mapMethodName(this.className, paramString1, paramString2), str, this.remapper.mapSignature(paramString3, false), (paramArrayOfString == null) ? null : this.remapper.mapTypes(paramArrayOfString))) == null) ? null : createMethodRemapper(methodVisitor);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitInnerClass(String paramString1, String paramString2, String paramString3, int paramInt) {
/* 199 */     super.visitInnerClass(this.remapper
/* 200 */         .mapType(paramString1), 
/* 201 */         (paramString2 == null) ? null : this.remapper.mapType(paramString2), 
/* 202 */         (paramString3 == null) ? null : this.remapper.mapInnerClassName(paramString1, paramString2, paramString3), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitOuterClass(String paramString1, String paramString2, String paramString3) {
/* 208 */     super.visitOuterClass(this.remapper
/* 209 */         .mapType(paramString1), 
/* 210 */         (paramString2 == null) ? null : this.remapper.mapMethodName(paramString1, paramString2, paramString3), 
/* 211 */         (paramString3 == null) ? null : this.remapper.mapMethodDesc(paramString3));
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitNestHost(String paramString) {
/* 216 */     super.visitNestHost(this.remapper.mapType(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitNestMember(String paramString) {
/* 221 */     super.visitNestMember(this.remapper.mapType(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitPermittedSubclass(String paramString) {
/* 226 */     super.visitPermittedSubclass(this.remapper.mapType(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected FieldVisitor createFieldRemapper(FieldVisitor paramFieldVisitor) {
/* 237 */     return new FieldRemapper(this.api, paramFieldVisitor, this.remapper);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected MethodVisitor createMethodRemapper(MethodVisitor paramMethodVisitor) {
/* 248 */     return new MethodRemapper(this.api, paramMethodVisitor, this.remapper);
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
/* 261 */     return new AnnotationRemapper(this.api, null, paramAnnotationVisitor, this.remapper);
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
/* 274 */     return (new AnnotationRemapper(this.api, paramString, paramAnnotationVisitor, this.remapper))
/* 275 */       .a(createAnnotationRemapper(paramAnnotationVisitor));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ModuleVisitor createModuleRemapper(ModuleVisitor paramModuleVisitor) {
/* 286 */     return new ModuleRemapper(this.api, paramModuleVisitor, this.remapper);
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
/*     */   protected RecordComponentVisitor createRecordComponentRemapper(RecordComponentVisitor paramRecordComponentVisitor) {
/* 298 */     return new RecordComponentRemapper(this.api, paramRecordComponentVisitor, this.remapper);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\commons\ClassRemapper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */