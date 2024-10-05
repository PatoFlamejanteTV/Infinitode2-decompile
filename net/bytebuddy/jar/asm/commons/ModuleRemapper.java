/*     */ package net.bytebuddy.jar.asm.commons;
/*     */ 
/*     */ import net.bytebuddy.jar.asm.ModuleVisitor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModuleRemapper
/*     */   extends ModuleVisitor
/*     */ {
/*     */   protected final Remapper remapper;
/*     */   
/*     */   public ModuleRemapper(ModuleVisitor paramModuleVisitor, Remapper paramRemapper) {
/*  52 */     this(589824, paramModuleVisitor, paramRemapper);
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
/*     */   protected ModuleRemapper(int paramInt, ModuleVisitor paramModuleVisitor, Remapper paramRemapper) {
/*  65 */     super(paramInt, paramModuleVisitor);
/*  66 */     this.remapper = paramRemapper;
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitMainClass(String paramString) {
/*  71 */     super.visitMainClass(this.remapper.mapType(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitPackage(String paramString) {
/*  76 */     super.visitPackage(this.remapper.mapPackageName(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitRequire(String paramString1, int paramInt, String paramString2) {
/*  81 */     super.visitRequire(this.remapper.mapModuleName(paramString1), paramInt, paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitExport(String paramString, int paramInt, String... paramVarArgs) {
/*  86 */     String[] arrayOfString = null;
/*  87 */     if (paramVarArgs != null) {
/*  88 */       arrayOfString = new String[paramVarArgs.length];
/*  89 */       for (byte b = 0; b < paramVarArgs.length; b++) {
/*  90 */         arrayOfString[b] = this.remapper.mapModuleName(paramVarArgs[b]);
/*     */       }
/*     */     } 
/*  93 */     super.visitExport(this.remapper.mapPackageName(paramString), paramInt, arrayOfString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitOpen(String paramString, int paramInt, String... paramVarArgs) {
/*  98 */     String[] arrayOfString = null;
/*  99 */     if (paramVarArgs != null) {
/* 100 */       arrayOfString = new String[paramVarArgs.length];
/* 101 */       for (byte b = 0; b < paramVarArgs.length; b++) {
/* 102 */         arrayOfString[b] = this.remapper.mapModuleName(paramVarArgs[b]);
/*     */       }
/*     */     } 
/* 105 */     super.visitOpen(this.remapper.mapPackageName(paramString), paramInt, arrayOfString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitUse(String paramString) {
/* 110 */     super.visitUse(this.remapper.mapType(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitProvide(String paramString, String... paramVarArgs) {
/* 115 */     String[] arrayOfString = new String[paramVarArgs.length];
/* 116 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/* 117 */       arrayOfString[b] = this.remapper.mapType(paramVarArgs[b]);
/*     */     }
/* 119 */     super.visitProvide(this.remapper.mapType(paramString), arrayOfString);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\commons\ModuleRemapper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */