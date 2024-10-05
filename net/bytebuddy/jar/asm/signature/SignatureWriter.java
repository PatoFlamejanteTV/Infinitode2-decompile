/*     */ package net.bytebuddy.jar.asm.signature;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SignatureWriter
/*     */   extends SignatureVisitor
/*     */ {
/*     */   private final StringBuilder stringBuilder;
/*     */   private boolean hasFormals;
/*     */   private boolean hasParameters;
/*  70 */   private int argumentStack = 1;
/*     */ 
/*     */   
/*     */   public SignatureWriter() {
/*  74 */     this(new StringBuilder());
/*     */   }
/*     */   
/*     */   private SignatureWriter(StringBuilder paramStringBuilder) {
/*  78 */     super(589824);
/*  79 */     this.stringBuilder = paramStringBuilder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitFormalTypeParameter(String paramString) {
/*  88 */     if (!this.hasFormals) {
/*  89 */       this.hasFormals = true;
/*  90 */       this.stringBuilder.append('<');
/*     */     } 
/*  92 */     this.stringBuilder.append(paramString);
/*  93 */     this.stringBuilder.append(':');
/*     */   }
/*     */ 
/*     */   
/*     */   public SignatureVisitor visitClassBound() {
/*  98 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SignatureVisitor visitInterfaceBound() {
/* 103 */     this.stringBuilder.append(':');
/* 104 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SignatureVisitor visitSuperclass() {
/* 109 */     endFormals();
/* 110 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SignatureVisitor visitInterface() {
/* 115 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SignatureVisitor visitParameterType() {
/* 120 */     endFormals();
/* 121 */     if (!this.hasParameters) {
/* 122 */       this.hasParameters = true;
/* 123 */       this.stringBuilder.append('(');
/*     */     } 
/* 125 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SignatureVisitor visitReturnType() {
/* 130 */     endFormals();
/* 131 */     if (!this.hasParameters) {
/* 132 */       this.stringBuilder.append('(');
/*     */     }
/* 134 */     this.stringBuilder.append(')');
/* 135 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SignatureVisitor visitExceptionType() {
/* 140 */     this.stringBuilder.append('^');
/* 141 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitBaseType(char paramChar) {
/* 146 */     this.stringBuilder.append(paramChar);
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitTypeVariable(String paramString) {
/* 151 */     this.stringBuilder.append('T');
/* 152 */     this.stringBuilder.append(paramString);
/* 153 */     this.stringBuilder.append(';');
/*     */   }
/*     */ 
/*     */   
/*     */   public SignatureVisitor visitArrayType() {
/* 158 */     this.stringBuilder.append('[');
/* 159 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitClassType(String paramString) {
/* 164 */     this.stringBuilder.append('L');
/* 165 */     this.stringBuilder.append(paramString);
/*     */ 
/*     */     
/* 168 */     this.argumentStack <<= 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitInnerClassType(String paramString) {
/* 173 */     endArguments();
/* 174 */     this.stringBuilder.append('.');
/* 175 */     this.stringBuilder.append(paramString);
/*     */ 
/*     */     
/* 178 */     this.argumentStack <<= 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitTypeArgument() {
/* 186 */     if ((this.argumentStack & 0x1) == 0) {
/* 187 */       this.argumentStack |= 0x1;
/* 188 */       this.stringBuilder.append('<');
/*     */     } 
/* 190 */     this.stringBuilder.append('*');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SignatureVisitor visitTypeArgument(char paramChar) {
/* 198 */     if ((this.argumentStack & 0x1) == 0) {
/* 199 */       this.argumentStack |= 0x1;
/* 200 */       this.stringBuilder.append('<');
/*     */     } 
/* 202 */     if (paramChar != '=') {
/* 203 */       this.stringBuilder.append(paramChar);
/*     */     }
/*     */     
/* 206 */     return ((this.argumentStack & Integer.MIN_VALUE) == 0) ? this : new SignatureWriter(this.stringBuilder);
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitEnd() {
/* 211 */     endArguments();
/* 212 */     this.stringBuilder.append(';');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 222 */     return this.stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void endFormals() {
/* 231 */     if (this.hasFormals) {
/* 232 */       this.hasFormals = false;
/* 233 */       this.stringBuilder.append('>');
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void endArguments() {
/* 242 */     if ((this.argumentStack & 0x1) == 1) {
/* 243 */       this.stringBuilder.append('>');
/*     */     }
/* 245 */     this.argumentStack >>>= 1;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\signature\SignatureWriter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */