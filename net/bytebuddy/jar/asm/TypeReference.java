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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TypeReference
/*     */ {
/*     */   public static final int CLASS_TYPE_PARAMETER = 0;
/*     */   public static final int METHOD_TYPE_PARAMETER = 1;
/*     */   public static final int CLASS_EXTENDS = 16;
/*     */   public static final int CLASS_TYPE_PARAMETER_BOUND = 17;
/*     */   public static final int METHOD_TYPE_PARAMETER_BOUND = 18;
/*     */   public static final int FIELD = 19;
/*     */   public static final int METHOD_RETURN = 20;
/*     */   public static final int METHOD_RECEIVER = 21;
/*     */   public static final int METHOD_FORMAL_PARAMETER = 22;
/*     */   public static final int THROWS = 23;
/*     */   public static final int LOCAL_VARIABLE = 64;
/*     */   public static final int RESOURCE_VARIABLE = 65;
/*     */   public static final int EXCEPTION_PARAMETER = 66;
/*     */   public static final int INSTANCEOF = 67;
/*     */   public static final int NEW = 68;
/*     */   public static final int CONSTRUCTOR_REFERENCE = 69;
/*     */   public static final int METHOD_REFERENCE = 70;
/*     */   public static final int CAST = 71;
/*     */   public static final int CONSTRUCTOR_INVOCATION_TYPE_ARGUMENT = 72;
/*     */   public static final int METHOD_INVOCATION_TYPE_ARGUMENT = 73;
/*     */   public static final int CONSTRUCTOR_REFERENCE_TYPE_ARGUMENT = 74;
/*     */   public static final int METHOD_REFERENCE_TYPE_ARGUMENT = 75;
/*     */   private final int targetTypeAndInfo;
/*     */   
/*     */   public TypeReference(int paramInt) {
/* 194 */     this.targetTypeAndInfo = paramInt;
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
/*     */   public static TypeReference newTypeReference(int paramInt) {
/* 206 */     return new TypeReference(paramInt << 24);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeReference newTypeParameterReference(int paramInt1, int paramInt2) {
/* 217 */     return new TypeReference(paramInt1 << 24 | paramInt2 << 16);
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
/*     */   public static TypeReference newTypeParameterBoundReference(int paramInt1, int paramInt2, int paramInt3) {
/* 230 */     return new TypeReference(paramInt1 << 24 | paramInt2 << 16 | paramInt3 << 8);
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
/*     */   public static TypeReference newSuperTypeReference(int paramInt) {
/* 242 */     return new TypeReference(0x10000000 | (paramInt & 0xFFFF) << 8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeReference newFormalParameterReference(int paramInt) {
/* 252 */     return new TypeReference(0x16000000 | paramInt << 16);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeReference newExceptionReference(int paramInt) {
/* 262 */     return new TypeReference(0x17000000 | paramInt << 8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeReference newTryCatchReference(int paramInt) {
/* 273 */     return new TypeReference(0x42000000 | paramInt << 8);
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
/*     */   public static TypeReference newTypeArgumentReference(int paramInt1, int paramInt2) {
/* 287 */     return new TypeReference(paramInt1 << 24 | paramInt2);
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
/*     */   public int getSort() {
/* 303 */     return this.targetTypeAndInfo >>> 24;
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
/*     */   public int getTypeParameterIndex() {
/* 315 */     return this.targetTypeAndInfo >> 16 & 0xFF;
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
/*     */   public int getTypeParameterBoundIndex() {
/* 327 */     return this.targetTypeAndInfo >> 8 & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSuperTypeIndex() {
/* 338 */     return (short)((this.targetTypeAndInfo & 0xFFFF00) >> 8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFormalParameterIndex() {
/* 348 */     return this.targetTypeAndInfo >> 16 & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getExceptionIndex() {
/* 359 */     return (this.targetTypeAndInfo & 0xFFFF00) >> 8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTryCatchBlockIndex() {
/* 370 */     return (this.targetTypeAndInfo & 0xFFFF00) >> 8;
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
/*     */   public int getTypeArgumentIndex() {
/* 382 */     return this.targetTypeAndInfo & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getValue() {
/* 392 */     return this.targetTypeAndInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void a(int paramInt, ByteVector paramByteVector) {
/* 403 */     switch (paramInt >>> 24) {
/*     */       case 0:
/*     */       case 1:
/*     */       case 22:
/* 407 */         paramByteVector.putShort(paramInt >>> 16);
/*     */         return;
/*     */       case 19:
/*     */       case 20:
/*     */       case 21:
/* 412 */         paramByteVector.putByte(paramInt >>> 24);
/*     */         return;
/*     */       case 71:
/*     */       case 72:
/*     */       case 73:
/*     */       case 74:
/*     */       case 75:
/* 419 */         paramByteVector.putInt(paramInt);
/*     */         return;
/*     */       case 16:
/*     */       case 17:
/*     */       case 18:
/*     */       case 23:
/*     */       case 66:
/*     */       case 67:
/*     */       case 68:
/*     */       case 69:
/*     */       case 70:
/* 430 */         paramByteVector.b(paramInt >>> 24, (paramInt & 0xFFFF00) >> 8);
/*     */         return;
/*     */     } 
/* 433 */     throw new IllegalArgumentException();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\TypeReference.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */