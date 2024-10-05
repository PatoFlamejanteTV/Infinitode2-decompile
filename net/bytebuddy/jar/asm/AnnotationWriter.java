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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class AnnotationWriter
/*     */   extends AnnotationVisitor
/*     */ {
/*     */   private final SymbolTable symbolTable;
/*     */   private final boolean useNamedValues;
/*     */   private final ByteVector annotation;
/*     */   private final int numElementValuePairsOffset;
/*     */   private int numElementValuePairs;
/*     */   private final AnnotationWriter previousAnnotation;
/*     */   private AnnotationWriter nextAnnotation;
/*     */   
/*     */   AnnotationWriter(SymbolTable paramSymbolTable, boolean paramBoolean, ByteVector paramByteVector, AnnotationWriter paramAnnotationWriter) {
/* 115 */     super(589824);
/* 116 */     this.symbolTable = paramSymbolTable;
/* 117 */     this.useNamedValues = paramBoolean;
/* 118 */     this.annotation = paramByteVector;
/*     */     
/* 120 */     this.numElementValuePairsOffset = (paramByteVector.b == 0) ? -1 : (paramByteVector.b - 2);
/* 121 */     this.previousAnnotation = paramAnnotationWriter;
/* 122 */     if (paramAnnotationWriter != null) {
/* 123 */       paramAnnotationWriter.nextAnnotation = this;
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
/*     */   static AnnotationWriter a(SymbolTable paramSymbolTable, String paramString, AnnotationWriter paramAnnotationWriter) {
/*     */     ByteVector byteVector;
/* 145 */     (byteVector = new ByteVector()).putShort(paramSymbolTable.b(paramString)).putShort(0);
/* 146 */     return new AnnotationWriter(paramSymbolTable, true, byteVector, paramAnnotationWriter);
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
/*     */ 
/*     */   
/*     */   static AnnotationWriter a(SymbolTable paramSymbolTable, int paramInt, TypePath paramTypePath, String paramString, AnnotationWriter paramAnnotationWriter) {
/* 175 */     ByteVector byteVector = new ByteVector();
/*     */     
/* 177 */     TypeReference.a(paramInt, byteVector);
/* 178 */     TypePath.a(paramTypePath, byteVector);
/*     */     
/* 180 */     byteVector.putShort(paramSymbolTable.b(paramString)).putShort(0);
/* 181 */     return new AnnotationWriter(paramSymbolTable, true, byteVector, paramAnnotationWriter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void visit(String paramString, Object paramObject) {
/*     */     int i;
/* 193 */     this.numElementValuePairs++;
/* 194 */     if (this.useNamedValues) {
/* 195 */       this.annotation.putShort(this.symbolTable.b(paramString));
/*     */     }
/* 197 */     if (paramObject instanceof String) {
/* 198 */       this.annotation.b(115, this.symbolTable.b((String)paramObject)); return;
/* 199 */     }  if (paramObject instanceof Byte) {
/* 200 */       this.annotation.b(66, (this.symbolTable.a(((Byte)paramObject).byteValue())).a); return;
/* 201 */     }  if (paramObject instanceof Boolean) {
/* 202 */       boolean bool = ((Boolean)paramObject).booleanValue() ? true : false;
/* 203 */       this.annotation.b(90, (this.symbolTable.a(bool)).a); return;
/* 204 */     }  if (paramObject instanceof Character) {
/* 205 */       this.annotation.b(67, (this.symbolTable.a(((Character)paramObject).charValue())).a); return;
/* 206 */     }  if (paramObject instanceof Short) {
/* 207 */       this.annotation.b(83, (this.symbolTable.a(((Short)paramObject).shortValue())).a); return;
/* 208 */     }  if (paramObject instanceof Type) {
/* 209 */       this.annotation.b(99, this.symbolTable.b(((Type)paramObject).getDescriptor())); return;
/* 210 */     }  if (paramObject instanceof byte[]) {
/* 211 */       byte[] arrayOfByte = (byte[])paramObject;
/* 212 */       this.annotation.b(91, arrayOfByte.length); byte b;
/* 213 */       for (i = (arrayOfByte = arrayOfByte).length, b = 0; b < i; ) { byte b1 = arrayOfByte[b];
/* 214 */         this.annotation.b(66, (this.symbolTable.a(b1)).a); b++; }
/*     */        return;
/* 216 */     }  if (i instanceof boolean[]) {
/* 217 */       boolean[] arrayOfBoolean = (boolean[])i;
/* 218 */       this.annotation.b(91, arrayOfBoolean.length); byte b;
/* 219 */       for (i = (arrayOfBoolean = arrayOfBoolean).length, b = 0; b < i; ) { boolean bool = arrayOfBoolean[b];
/* 220 */         this.annotation.b(90, (this.symbolTable.a(bool ? 1 : 0)).a); b++; }
/*     */        return;
/* 222 */     }  if (i instanceof short[]) {
/* 223 */       short[] arrayOfShort = (short[])i;
/* 224 */       this.annotation.b(91, arrayOfShort.length); byte b;
/* 225 */       for (i = (arrayOfShort = arrayOfShort).length, b = 0; b < i; ) { short s = arrayOfShort[b];
/* 226 */         this.annotation.b(83, (this.symbolTable.a(s)).a); b++; }
/*     */        return;
/* 228 */     }  if (i instanceof char[]) {
/* 229 */       char[] arrayOfChar = (char[])i;
/* 230 */       this.annotation.b(91, arrayOfChar.length); byte b;
/* 231 */       for (i = (arrayOfChar = arrayOfChar).length, b = 0; b < i; ) { char c = arrayOfChar[b];
/* 232 */         this.annotation.b(67, (this.symbolTable.a(c)).a); b++; }
/*     */        return;
/* 234 */     }  if (i instanceof int[]) {
/* 235 */       int[] arrayOfInt = (int[])i;
/* 236 */       this.annotation.b(91, arrayOfInt.length); byte b;
/* 237 */       for (i = (arrayOfInt = arrayOfInt).length, b = 0; b < i; ) { int j = arrayOfInt[b];
/* 238 */         this.annotation.b(73, (this.symbolTable.a(j)).a); b++; }
/*     */        return;
/* 240 */     }  if (i instanceof long[]) {
/* 241 */       long[] arrayOfLong = (long[])i;
/* 242 */       this.annotation.b(91, arrayOfLong.length); byte b;
/* 243 */       for (i = (arrayOfLong = arrayOfLong).length, b = 0; b < i; ) { long l = arrayOfLong[b];
/* 244 */         this.annotation.b(74, (this.symbolTable.a(l)).a); b++; }
/*     */        return;
/* 246 */     }  if (i instanceof float[]) {
/* 247 */       float[] arrayOfFloat = (float[])i;
/* 248 */       this.annotation.b(91, arrayOfFloat.length); byte b;
/* 249 */       for (i = (arrayOfFloat = arrayOfFloat).length, b = 0; b < i; ) { float f = arrayOfFloat[b];
/* 250 */         this.annotation.b(70, (this.symbolTable.a(f)).a); b++; }
/*     */        return;
/* 252 */     }  if (i instanceof double[]) {
/* 253 */       double[] arrayOfDouble = (double[])i;
/* 254 */       this.annotation.b(91, arrayOfDouble.length); byte b;
/* 255 */       for (i = (arrayOfDouble = arrayOfDouble).length, b = 0; b < i; ) { double d = arrayOfDouble[b];
/* 256 */         this.annotation.b(68, (this.symbolTable.a(d)).a); b++; }
/*     */        return;
/*     */     } 
/* 259 */     Symbol symbol = this.symbolTable.a(i);
/* 260 */     this.annotation.b(".s.IFJDCS".charAt(symbol.b), symbol.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void visitEnum(String paramString1, String paramString2, String paramString3) {
/* 268 */     this.numElementValuePairs++;
/* 269 */     if (this.useNamedValues) {
/* 270 */       this.annotation.putShort(this.symbolTable.b(paramString1));
/*     */     }
/* 272 */     this.annotation
/* 273 */       .b(101, this.symbolTable.b(paramString2))
/* 274 */       .putShort(this.symbolTable.b(paramString3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final AnnotationVisitor visitAnnotation(String paramString1, String paramString2) {
/* 281 */     this.numElementValuePairs++;
/* 282 */     if (this.useNamedValues) {
/* 283 */       this.annotation.putShort(this.symbolTable.b(paramString1));
/*     */     }
/*     */     
/* 286 */     this.annotation.b(64, this.symbolTable.b(paramString2)).putShort(0);
/* 287 */     return new AnnotationWriter(this.symbolTable, true, this.annotation, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final AnnotationVisitor visitArray(String paramString) {
/* 294 */     this.numElementValuePairs++;
/* 295 */     if (this.useNamedValues) {
/* 296 */       this.annotation.putShort(this.symbolTable.b(paramString));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 305 */     this.annotation.b(91, 0);
/* 306 */     return new AnnotationWriter(this.symbolTable, false, this.annotation, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitEnd() {
/* 311 */     if (this.numElementValuePairsOffset != -1) {
/*     */       byte[] arrayOfByte;
/* 313 */       (arrayOfByte = this.annotation.a)[this.numElementValuePairsOffset] = (byte)(this.numElementValuePairs >>> 8);
/* 314 */       arrayOfByte[this.numElementValuePairsOffset + 1] = (byte)this.numElementValuePairs;
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
/*     */   final int a(String paramString) {
/* 333 */     if (paramString != null) {
/* 334 */       this.symbolTable.b(paramString);
/*     */     }
/*     */     
/* 337 */     int i = 8;
/* 338 */     AnnotationWriter annotationWriter = this;
/* 339 */     while (annotationWriter != null) {
/* 340 */       i += annotationWriter.annotation.b;
/* 341 */       annotationWriter = annotationWriter.previousAnnotation;
/*     */     } 
/* 343 */     return i;
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
/*     */ 
/*     */   
/*     */   static int a(AnnotationWriter paramAnnotationWriter1, AnnotationWriter paramAnnotationWriter2, AnnotationWriter paramAnnotationWriter3, AnnotationWriter paramAnnotationWriter4) {
/* 372 */     int i = 0;
/* 373 */     if (paramAnnotationWriter1 != null)
/*     */     {
/* 375 */       i = 0 + paramAnnotationWriter1.a("RuntimeVisibleAnnotations");
/*     */     }
/*     */     
/* 378 */     if (paramAnnotationWriter2 != null) {
/* 379 */       i += paramAnnotationWriter2
/* 380 */         .a("RuntimeInvisibleAnnotations");
/*     */     }
/*     */     
/* 383 */     if (paramAnnotationWriter3 != null) {
/* 384 */       i += paramAnnotationWriter3
/* 385 */         .a("RuntimeVisibleTypeAnnotations");
/*     */     }
/*     */     
/* 388 */     if (paramAnnotationWriter4 != null) {
/* 389 */       i += paramAnnotationWriter4
/* 390 */         .a("RuntimeInvisibleTypeAnnotations");
/*     */     }
/*     */     
/* 393 */     return i;
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
/*     */   final void a(int paramInt, ByteVector paramByteVector) {
/* 406 */     int i = 2;
/* 407 */     byte b = 0;
/* 408 */     AnnotationWriter annotationWriter1 = this;
/* 409 */     AnnotationWriter annotationWriter2 = null;
/* 410 */     while (annotationWriter1 != null) {
/*     */       
/* 412 */       annotationWriter1.visitEnd();
/* 413 */       i += annotationWriter1.annotation.b;
/* 414 */       b++;
/* 415 */       annotationWriter2 = annotationWriter1;
/* 416 */       annotationWriter1 = annotationWriter1.previousAnnotation;
/*     */     } 
/* 418 */     paramByteVector.putShort(paramInt);
/* 419 */     paramByteVector.putInt(i);
/* 420 */     paramByteVector.putShort(b);
/* 421 */     annotationWriter1 = annotationWriter2;
/* 422 */     while (annotationWriter1 != null) {
/* 423 */       paramByteVector.putByteArray(annotationWriter1.annotation.a, 0, annotationWriter1.annotation.b);
/* 424 */       annotationWriter1 = annotationWriter1.nextAnnotation;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void a(SymbolTable paramSymbolTable, AnnotationWriter paramAnnotationWriter1, AnnotationWriter paramAnnotationWriter2, AnnotationWriter paramAnnotationWriter3, AnnotationWriter paramAnnotationWriter4, ByteVector paramByteVector) {
/* 455 */     if (paramAnnotationWriter1 != null) {
/* 456 */       paramAnnotationWriter1.a(paramSymbolTable
/* 457 */           .b("RuntimeVisibleAnnotations"), paramByteVector);
/*     */     }
/* 459 */     if (paramAnnotationWriter2 != null) {
/* 460 */       paramAnnotationWriter2.a(paramSymbolTable
/* 461 */           .b("RuntimeInvisibleAnnotations"), paramByteVector);
/*     */     }
/* 463 */     if (paramAnnotationWriter3 != null) {
/* 464 */       paramAnnotationWriter3.a(paramSymbolTable
/* 465 */           .b("RuntimeVisibleTypeAnnotations"), paramByteVector);
/*     */     }
/* 467 */     if (paramAnnotationWriter4 != null) {
/* 468 */       paramAnnotationWriter4.a(paramSymbolTable
/* 469 */           .b("RuntimeInvisibleTypeAnnotations"), paramByteVector);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static int a(String paramString, AnnotationWriter[] paramArrayOfAnnotationWriter, int paramInt) {
/* 496 */     int i = 7 + 2 * paramInt;
/* 497 */     for (byte b = 0; b < paramInt; b++) {
/* 498 */       AnnotationWriter annotationWriter = paramArrayOfAnnotationWriter[b];
/* 499 */       i += 
/* 500 */         (annotationWriter == null) ? 0 : (annotationWriter.a(paramString) - 8);
/*     */     } 
/* 502 */     return i;
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
/*     */   static void a(int paramInt1, AnnotationWriter[] paramArrayOfAnnotationWriter, int paramInt2, ByteVector paramByteVector) {
/* 524 */     int i = 1 + 2 * paramInt2; byte b;
/* 525 */     for (b = 0; b < paramInt2; b++) {
/* 526 */       AnnotationWriter annotationWriter = paramArrayOfAnnotationWriter[b];
/* 527 */       i += 
/* 528 */         (annotationWriter == null) ? 0 : (annotationWriter.a(null) - 8);
/*     */     } 
/* 530 */     paramByteVector.putShort(paramInt1);
/* 531 */     paramByteVector.putInt(i);
/* 532 */     paramByteVector.putByte(paramInt2);
/* 533 */     for (b = 0; b < paramInt2; b++) {
/* 534 */       AnnotationWriter annotationWriter2 = paramArrayOfAnnotationWriter[b];
/* 535 */       AnnotationWriter annotationWriter1 = null;
/* 536 */       i = 0;
/* 537 */       while (annotationWriter2 != null) {
/*     */         
/* 539 */         annotationWriter2.visitEnd();
/* 540 */         i++;
/* 541 */         annotationWriter1 = annotationWriter2;
/* 542 */         annotationWriter2 = annotationWriter2.previousAnnotation;
/*     */       } 
/* 544 */       paramByteVector.putShort(i);
/* 545 */       annotationWriter2 = annotationWriter1;
/* 546 */       while (annotationWriter2 != null) {
/* 547 */         paramByteVector.putByteArray(annotationWriter2.annotation.a, 0, annotationWriter2.annotation.b);
/*     */         
/* 549 */         annotationWriter2 = annotationWriter2.nextAnnotation;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\AnnotationWriter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */