/*     */ package net.bytebuddy.asm;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import net.bytebuddy.ClassFileVersion;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.field.FieldList;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.jar.asm.ClassVisitor;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.jar.asm.Type;
/*     */ import net.bytebuddy.pool.TypePool;
/*     */ import net.bytebuddy.utility.OpenedClassReader;
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
/*     */ public enum TypeConstantAdjustment
/*     */   implements AsmVisitorWrapper
/*     */ {
/*  48 */   INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int mergeWriter(int paramInt) {
/*  54 */     return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int mergeReader(int paramInt) {
/*  61 */     return paramInt;
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
/*     */   public final ClassVisitor wrap(TypeDescription paramTypeDescription, ClassVisitor paramClassVisitor, Implementation.Context paramContext, TypePool paramTypePool, FieldList<FieldDescription.InDefinedShape> paramFieldList, MethodList<?> paramMethodList, int paramInt1, int paramInt2) {
/*  75 */     return new TypeConstantDissolvingClassVisitor(paramClassVisitor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class TypeConstantDissolvingClassVisitor
/*     */     extends ClassVisitor
/*     */   {
/*     */     private boolean supportsTypeConstants;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected TypeConstantDissolvingClassVisitor(ClassVisitor param1ClassVisitor) {
/*  95 */       super(OpenedClassReader.ASM_API, param1ClassVisitor);
/*     */     }
/*     */ 
/*     */     
/*     */     public void visit(int param1Int1, int param1Int2, String param1String1, @MaybeNull String param1String2, @MaybeNull String param1String3, @MaybeNull String[] param1ArrayOfString) {
/* 100 */       this.supportsTypeConstants = ClassFileVersion.ofMinorMajor(param1Int1).isAtLeast(ClassFileVersion.JAVA_V5);
/* 101 */       super.visit(param1Int1, param1Int2, param1String1, param1String2, param1String3, param1ArrayOfString);
/*     */     }
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     public MethodVisitor visitMethod(int param1Int, String param1String1, String param1String2, @MaybeNull String param1String3, @MaybeNull String[] param1ArrayOfString) {
/* 107 */       MethodVisitor methodVisitor = super.visitMethod(param1Int, param1String1, param1String2, param1String3, param1ArrayOfString);
/* 108 */       return (this.supportsTypeConstants || methodVisitor == null) ? methodVisitor : new TypeConstantDissolvingMethodVisitor(methodVisitor);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected static class TypeConstantDissolvingMethodVisitor
/*     */       extends MethodVisitor
/*     */     {
/*     */       private static final String JAVA_LANG_CLASS = "java/lang/Class";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private static final String FOR_NAME = "forName";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private static final String DESCRIPTOR = "(Ljava/lang/String;)Ljava/lang/Class;";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected TypeConstantDissolvingMethodVisitor(MethodVisitor param2MethodVisitor) {
/* 139 */         super(OpenedClassReader.ASM_API, param2MethodVisitor);
/*     */       }
/*     */ 
/*     */       
/*     */       @SuppressFBWarnings(value = {"SF_SWITCH_NO_DEFAULT"}, justification = "Fall through to default case is intentional.")
/*     */       public void visitLdcInsn(Object param2Object) {
/* 145 */         if (param2Object instanceof Type) {
/*     */           Type type;
/* 147 */           switch ((type = (Type)param2Object).getSort()) {
/*     */             case 9:
/*     */             case 10:
/* 150 */               super.visitLdcInsn(type.getInternalName().replace('/', '.'));
/* 151 */               visitMethodInsn(184, "java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false);
/*     */               return;
/*     */           } 
/*     */         } 
/* 155 */         super.visitLdcInsn(param2Object);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\asm\TypeConstantAdjustment.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */