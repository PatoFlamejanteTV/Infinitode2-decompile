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
/*     */ public abstract class ModuleVisitor
/*     */ {
/*     */   protected final int api;
/*     */   protected ModuleVisitor mv;
/*     */   
/*     */   protected ModuleVisitor(int paramInt) {
/*  57 */     this(paramInt, null);
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
/*     */   protected ModuleVisitor(int paramInt, ModuleVisitor paramModuleVisitor) {
/*  69 */     if (paramInt != 589824 && paramInt != 524288 && paramInt != 458752 && paramInt != 393216 && paramInt != 327680 && paramInt != 262144 && paramInt != 17432576)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  76 */       throw new IllegalArgumentException("Unsupported api " + paramInt);
/*     */     }
/*  78 */     if (paramInt == 17432576) {
/*  79 */       Constants.a(this);
/*     */     }
/*  81 */     this.api = paramInt;
/*  82 */     this.mv = paramModuleVisitor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModuleVisitor getDelegate() {
/*  92 */     return this.mv;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitMainClass(String paramString) {
/* 102 */     if (this.mv != null) {
/* 103 */       this.mv.visitMainClass(paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitPackage(String paramString) {
/* 113 */     if (this.mv != null) {
/* 114 */       this.mv.visitPackage(paramString);
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
/*     */   public void visitRequire(String paramString1, int paramInt, String paramString2) {
/* 127 */     if (this.mv != null) {
/* 128 */       this.mv.visitRequire(paramString1, paramInt, paramString2);
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
/*     */   public void visitExport(String paramString, int paramInt, String... paramVarArgs) {
/* 142 */     if (this.mv != null) {
/* 143 */       this.mv.visitExport(paramString, paramInt, paramVarArgs);
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
/*     */   public void visitOpen(String paramString, int paramInt, String... paramVarArgs) {
/* 157 */     if (this.mv != null) {
/* 158 */       this.mv.visitOpen(paramString, paramInt, paramVarArgs);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitUse(String paramString) {
/* 169 */     if (this.mv != null) {
/* 170 */       this.mv.visitUse(paramString);
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
/*     */   public void visitProvide(String paramString, String... paramVarArgs) {
/* 182 */     if (this.mv != null) {
/* 183 */       this.mv.visitProvide(paramString, paramVarArgs);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitEnd() {
/* 192 */     if (this.mv != null)
/* 193 */       this.mv.visitEnd(); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\ModuleVisitor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */