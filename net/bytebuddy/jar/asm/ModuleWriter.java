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
/*     */ final class ModuleWriter
/*     */   extends ModuleVisitor
/*     */ {
/*     */   private final SymbolTable symbolTable;
/*     */   private final int moduleNameIndex;
/*     */   private final int moduleFlags;
/*     */   private final int moduleVersionIndex;
/*     */   private int requiresCount;
/*     */   private final ByteVector requires;
/*     */   private int exportsCount;
/*     */   private final ByteVector exports;
/*     */   private int opensCount;
/*     */   private final ByteVector opens;
/*     */   private int usesCount;
/*     */   private final ByteVector usesIndex;
/*     */   private int providesCount;
/*     */   private final ByteVector provides;
/*     */   private int packageCount;
/*     */   private final ByteVector packageIndex;
/*     */   private int mainClassIndex;
/*     */   
/*     */   ModuleWriter(SymbolTable paramSymbolTable, int paramInt1, int paramInt2, int paramInt3) {
/*  97 */     super(589824);
/*  98 */     this.symbolTable = paramSymbolTable;
/*  99 */     this.moduleNameIndex = paramInt1;
/* 100 */     this.moduleFlags = paramInt2;
/* 101 */     this.moduleVersionIndex = paramInt3;
/* 102 */     this.requires = new ByteVector();
/* 103 */     this.exports = new ByteVector();
/* 104 */     this.opens = new ByteVector();
/* 105 */     this.usesIndex = new ByteVector();
/* 106 */     this.provides = new ByteVector();
/* 107 */     this.packageIndex = new ByteVector();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitMainClass(String paramString) {
/* 112 */     this.mainClassIndex = (this.symbolTable.a(paramString)).a;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitPackage(String paramString) {
/* 117 */     this.packageIndex.putShort((this.symbolTable.e(paramString)).a);
/* 118 */     this.packageCount++;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitRequire(String paramString1, int paramInt, String paramString2) {
/* 123 */     this.requires
/* 124 */       .putShort((this.symbolTable.d(paramString1)).a)
/* 125 */       .putShort(paramInt)
/* 126 */       .putShort((paramString2 == null) ? 0 : this.symbolTable.b(paramString2));
/* 127 */     this.requiresCount++;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitExport(String paramString, int paramInt, String... paramVarArgs) {
/* 132 */     this.exports.putShort((this.symbolTable.e(paramString)).a).putShort(paramInt);
/* 133 */     if (paramVarArgs == null) {
/* 134 */       this.exports.putShort(0);
/*     */     } else {
/* 136 */       this.exports.putShort(paramVarArgs.length); String[] arrayOfString; byte b;
/* 137 */       for (paramInt = (arrayOfString = paramVarArgs).length, b = 0; b < paramInt; ) { String str = arrayOfString[b];
/* 138 */         this.exports.putShort((this.symbolTable.d(str)).a); b++; }
/*     */     
/*     */     } 
/* 141 */     this.exportsCount++;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitOpen(String paramString, int paramInt, String... paramVarArgs) {
/* 146 */     this.opens.putShort((this.symbolTable.e(paramString)).a).putShort(paramInt);
/* 147 */     if (paramVarArgs == null) {
/* 148 */       this.opens.putShort(0);
/*     */     } else {
/* 150 */       this.opens.putShort(paramVarArgs.length); String[] arrayOfString; byte b;
/* 151 */       for (paramInt = (arrayOfString = paramVarArgs).length, b = 0; b < paramInt; ) { String str = arrayOfString[b];
/* 152 */         this.opens.putShort((this.symbolTable.d(str)).a); b++; }
/*     */     
/*     */     } 
/* 155 */     this.opensCount++;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitUse(String paramString) {
/* 160 */     this.usesIndex.putShort((this.symbolTable.a(paramString)).a);
/* 161 */     this.usesCount++;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitProvide(String paramString, String... paramVarArgs) {
/* 166 */     this.provides.putShort((this.symbolTable.a(paramString)).a);
/* 167 */     this.provides.putShort(paramVarArgs.length); String[] arrayOfString; int i; byte b;
/* 168 */     for (i = (arrayOfString = paramVarArgs).length, b = 0; b < i; ) { String str = arrayOfString[b];
/* 169 */       this.provides.putShort((this.symbolTable.a(str)).a); b++; }
/*     */     
/* 171 */     this.providesCount++;
/*     */   }
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
/*     */   final int a() {
/* 186 */     return 1 + ((this.packageCount > 0) ? 1 : 0) + ((this.mainClassIndex > 0) ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final int b() {
/* 196 */     this.symbolTable.b("Module");
/*     */     
/* 198 */     int i = 22 + this.requires.b + this.exports.b + this.opens.b + this.usesIndex.b + this.provides.b;
/*     */     
/* 200 */     if (this.packageCount > 0) {
/* 201 */       this.symbolTable.b("ModulePackages");
/*     */       
/* 203 */       i += 8 + this.packageIndex.b;
/*     */     } 
/* 205 */     if (this.mainClassIndex > 0) {
/* 206 */       this.symbolTable.b("ModuleMainClass");
/*     */       
/* 208 */       i += 8;
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
/* 221 */     int i = 16 + this.requires.b + this.exports.b + this.opens.b + this.usesIndex.b + this.provides.b;
/*     */     
/* 223 */     paramByteVector
/* 224 */       .putShort(this.symbolTable.b("Module"))
/* 225 */       .putInt(i)
/* 226 */       .putShort(this.moduleNameIndex)
/* 227 */       .putShort(this.moduleFlags)
/* 228 */       .putShort(this.moduleVersionIndex)
/* 229 */       .putShort(this.requiresCount)
/* 230 */       .putByteArray(this.requires.a, 0, this.requires.b)
/* 231 */       .putShort(this.exportsCount)
/* 232 */       .putByteArray(this.exports.a, 0, this.exports.b)
/* 233 */       .putShort(this.opensCount)
/* 234 */       .putByteArray(this.opens.a, 0, this.opens.b)
/* 235 */       .putShort(this.usesCount)
/* 236 */       .putByteArray(this.usesIndex.a, 0, this.usesIndex.b)
/* 237 */       .putShort(this.providesCount)
/* 238 */       .putByteArray(this.provides.a, 0, this.provides.b);
/* 239 */     if (this.packageCount > 0) {
/* 240 */       paramByteVector
/* 241 */         .putShort(this.symbolTable.b("ModulePackages"))
/* 242 */         .putInt(2 + this.packageIndex.b)
/* 243 */         .putShort(this.packageCount)
/* 244 */         .putByteArray(this.packageIndex.a, 0, this.packageIndex.b);
/*     */     }
/* 246 */     if (this.mainClassIndex > 0)
/* 247 */       paramByteVector
/* 248 */         .putShort(this.symbolTable.b("ModuleMainClass"))
/* 249 */         .putInt(2)
/* 250 */         .putShort(this.mainClassIndex); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\ModuleWriter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */