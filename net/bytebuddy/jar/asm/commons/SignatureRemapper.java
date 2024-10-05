/*     */ package net.bytebuddy.jar.asm.commons;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import net.bytebuddy.jar.asm.signature.SignatureVisitor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SignatureRemapper
/*     */   extends SignatureVisitor
/*     */ {
/*     */   private final SignatureVisitor signatureVisitor;
/*     */   private final Remapper remapper;
/*  46 */   private ArrayList<String> classNames = new ArrayList<String>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SignatureRemapper(SignatureVisitor paramSignatureVisitor, Remapper paramRemapper) {
/*  56 */     this(589824, paramSignatureVisitor, paramRemapper);
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
/*     */   protected SignatureRemapper(int paramInt, SignatureVisitor paramSignatureVisitor, Remapper paramRemapper) {
/*  69 */     super(paramInt);
/*  70 */     this.signatureVisitor = paramSignatureVisitor;
/*  71 */     this.remapper = paramRemapper;
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitClassType(String paramString) {
/*  76 */     this.classNames.add(paramString);
/*  77 */     this.signatureVisitor.visitClassType(this.remapper.mapType(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitInnerClassType(String paramString) {
/*  82 */     String str = this.classNames.remove(this.classNames.size() - 1);
/*  83 */     paramString = str + '$' + paramString;
/*  84 */     this.classNames.add(paramString);
/*  85 */     str = this.remapper.mapType(str) + '$';
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  90 */     int i = (paramString = this.remapper.mapType(paramString)).startsWith(str) ? str.length() : (paramString.lastIndexOf('$') + 1);
/*  91 */     this.signatureVisitor.visitInnerClassType(paramString.substring(i));
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitFormalTypeParameter(String paramString) {
/*  96 */     this.signatureVisitor.visitFormalTypeParameter(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitTypeVariable(String paramString) {
/* 101 */     this.signatureVisitor.visitTypeVariable(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public SignatureVisitor visitArrayType() {
/* 106 */     this.signatureVisitor.visitArrayType();
/* 107 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitBaseType(char paramChar) {
/* 112 */     this.signatureVisitor.visitBaseType(paramChar);
/*     */   }
/*     */ 
/*     */   
/*     */   public SignatureVisitor visitClassBound() {
/* 117 */     this.signatureVisitor.visitClassBound();
/* 118 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SignatureVisitor visitExceptionType() {
/* 123 */     this.signatureVisitor.visitExceptionType();
/* 124 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SignatureVisitor visitInterface() {
/* 129 */     this.signatureVisitor.visitInterface();
/* 130 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SignatureVisitor visitInterfaceBound() {
/* 135 */     this.signatureVisitor.visitInterfaceBound();
/* 136 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SignatureVisitor visitParameterType() {
/* 141 */     this.signatureVisitor.visitParameterType();
/* 142 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SignatureVisitor visitReturnType() {
/* 147 */     this.signatureVisitor.visitReturnType();
/* 148 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SignatureVisitor visitSuperclass() {
/* 153 */     this.signatureVisitor.visitSuperclass();
/* 154 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitTypeArgument() {
/* 159 */     this.signatureVisitor.visitTypeArgument();
/*     */   }
/*     */ 
/*     */   
/*     */   public SignatureVisitor visitTypeArgument(char paramChar) {
/* 164 */     this.signatureVisitor.visitTypeArgument(paramChar);
/* 165 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitEnd() {
/* 170 */     this.signatureVisitor.visitEnd();
/* 171 */     this.classNames.remove(this.classNames.size() - 1);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\commons\SignatureRemapper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */