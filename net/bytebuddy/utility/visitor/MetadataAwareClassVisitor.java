/*     */ package net.bytebuddy.utility.visitor;
/*     */ 
/*     */ import net.bytebuddy.jar.asm.AnnotationVisitor;
/*     */ import net.bytebuddy.jar.asm.Attribute;
/*     */ import net.bytebuddy.jar.asm.ClassVisitor;
/*     */ import net.bytebuddy.jar.asm.FieldVisitor;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.jar.asm.RecordComponentVisitor;
/*     */ import net.bytebuddy.jar.asm.TypePath;
/*     */ import net.bytebuddy.utility.nullability.MaybeNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class MetadataAwareClassVisitor
/*     */   extends ClassVisitor
/*     */ {
/*     */   private boolean triggerNestHost;
/*     */   private boolean triggerOuterClass;
/*     */   private boolean triggerAttributes;
/*     */   
/*     */   protected MetadataAwareClassVisitor(int paramInt, ClassVisitor paramClassVisitor) {
/*  48 */     super(paramInt, paramClassVisitor);
/*  49 */     this.triggerNestHost = true;
/*  50 */     this.triggerOuterClass = true;
/*  51 */     this.triggerAttributes = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onNestHost() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onOuterType() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onAfterAttributes() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void considerTriggerNestHost() {
/*  79 */     if (this.triggerNestHost) {
/*  80 */       this.triggerNestHost = false;
/*  81 */       onNestHost();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void considerTriggerOuterClass() {
/*  89 */     if (this.triggerOuterClass) {
/*  90 */       this.triggerOuterClass = false;
/*  91 */       onOuterType();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void considerTriggerAfterAttributes() {
/*  99 */     if (this.triggerAttributes) {
/* 100 */       this.triggerAttributes = false;
/* 101 */       onAfterAttributes();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitNestHost(String paramString) {
/* 107 */     this.triggerNestHost = false;
/* 108 */     onVisitNestHost(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onVisitNestHost(String paramString) {
/* 117 */     super.visitNestHost(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitOuterClass(String paramString1, @MaybeNull String paramString2, @MaybeNull String paramString3) {
/* 122 */     considerTriggerNestHost();
/* 123 */     this.triggerOuterClass = false;
/* 124 */     onVisitOuterClass(paramString1, paramString2, paramString3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onVisitOuterClass(String paramString1, @MaybeNull String paramString2, @MaybeNull String paramString3) {
/* 135 */     super.visitOuterClass(paramString1, paramString2, paramString3);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitPermittedSubclass(String paramString) {
/* 140 */     considerTriggerNestHost();
/* 141 */     considerTriggerOuterClass();
/* 142 */     considerTriggerAfterAttributes();
/* 143 */     onVisitPermittedSubclass(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onVisitPermittedSubclass(String paramString) {
/* 152 */     super.visitPermittedSubclass(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   @MaybeNull
/*     */   public RecordComponentVisitor visitRecordComponent(String paramString1, String paramString2, @MaybeNull String paramString3) {
/* 158 */     considerTriggerNestHost();
/* 159 */     considerTriggerOuterClass();
/* 160 */     considerTriggerAfterAttributes();
/* 161 */     return onVisitRecordComponent(paramString1, paramString2, paramString3);
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
/*     */   @MaybeNull
/*     */   protected RecordComponentVisitor onVisitRecordComponent(String paramString1, String paramString2, @MaybeNull String paramString3) {
/* 174 */     return super.visitRecordComponent(paramString1, paramString2, paramString3);
/*     */   }
/*     */ 
/*     */   
/*     */   @MaybeNull
/*     */   public final AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean) {
/* 180 */     considerTriggerNestHost();
/* 181 */     considerTriggerOuterClass();
/* 182 */     return onVisitAnnotation(paramString, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @MaybeNull
/*     */   protected AnnotationVisitor onVisitAnnotation(String paramString, boolean paramBoolean) {
/* 194 */     return super.visitAnnotation(paramString, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   @MaybeNull
/*     */   public final AnnotationVisitor visitTypeAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
/* 200 */     considerTriggerNestHost();
/* 201 */     considerTriggerOuterClass();
/* 202 */     return onVisitTypeAnnotation(paramInt, paramTypePath, paramString, paramBoolean);
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
/*     */   @MaybeNull
/*     */   protected AnnotationVisitor onVisitTypeAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
/* 216 */     return super.visitTypeAnnotation(paramInt, paramTypePath, paramString, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitAttribute(Attribute paramAttribute) {
/* 221 */     considerTriggerNestHost();
/* 222 */     considerTriggerOuterClass();
/* 223 */     onVisitAttribute(paramAttribute);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onVisitAttribute(Attribute paramAttribute) {
/* 232 */     super.visitAttribute(paramAttribute);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitNestMember(String paramString) {
/* 237 */     considerTriggerNestHost();
/* 238 */     considerTriggerOuterClass();
/* 239 */     considerTriggerAfterAttributes();
/* 240 */     onVisitNestMember(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onVisitNestMember(String paramString) {
/* 249 */     super.visitNestMember(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitInnerClass(String paramString1, @MaybeNull String paramString2, @MaybeNull String paramString3, int paramInt) {
/* 254 */     considerTriggerNestHost();
/* 255 */     considerTriggerOuterClass();
/* 256 */     considerTriggerAfterAttributes();
/* 257 */     onVisitInnerClass(paramString1, paramString2, paramString3, paramInt);
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
/*     */   protected void onVisitInnerClass(String paramString1, @MaybeNull String paramString2, @MaybeNull String paramString3, int paramInt) {
/* 269 */     super.visitInnerClass(paramString1, paramString2, paramString3, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @MaybeNull
/*     */   public final FieldVisitor visitField(int paramInt, String paramString1, String paramString2, @MaybeNull String paramString3, @MaybeNull Object paramObject) {
/* 275 */     considerTriggerNestHost();
/* 276 */     considerTriggerOuterClass();
/* 277 */     considerTriggerAfterAttributes();
/* 278 */     return onVisitField(paramInt, paramString1, paramString2, paramString3, paramObject);
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
/*     */   @MaybeNull
/*     */   protected FieldVisitor onVisitField(int paramInt, String paramString1, String paramString2, @MaybeNull String paramString3, @MaybeNull Object paramObject) {
/* 293 */     return super.visitField(paramInt, paramString1, paramString2, paramString3, paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   @MaybeNull
/*     */   public final MethodVisitor visitMethod(int paramInt, String paramString1, String paramString2, @MaybeNull String paramString3, @MaybeNull String[] paramArrayOfString) {
/* 299 */     considerTriggerNestHost();
/* 300 */     considerTriggerOuterClass();
/* 301 */     considerTriggerAfterAttributes();
/* 302 */     return onVisitMethod(paramInt, paramString1, paramString2, paramString3, paramArrayOfString);
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
/*     */   @MaybeNull
/*     */   protected MethodVisitor onVisitMethod(int paramInt, String paramString1, String paramString2, @MaybeNull String paramString3, @MaybeNull String[] paramArrayOfString) {
/* 317 */     return super.visitMethod(paramInt, paramString1, paramString2, paramString3, paramArrayOfString);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitEnd() {
/* 322 */     considerTriggerNestHost();
/* 323 */     considerTriggerOuterClass();
/* 324 */     considerTriggerAfterAttributes();
/* 325 */     onVisitEnd();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onVisitEnd() {
/* 332 */     super.visitEnd();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\visitor\MetadataAwareClassVisitor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */