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
/*     */ public final class TypePath
/*     */ {
/*     */   public static final int ARRAY_ELEMENT = 0;
/*     */   public static final int INNER_TYPE = 1;
/*     */   public static final int WILDCARD_BOUND = 2;
/*     */   public static final int TYPE_ARGUMENT = 3;
/*     */   private final byte[] typePathContainer;
/*     */   private final int typePathOffset;
/*     */   
/*     */   TypePath(byte[] paramArrayOfbyte, int paramInt) {
/*  73 */     this.typePathContainer = paramArrayOfbyte;
/*  74 */     this.typePathOffset = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getLength() {
/*  84 */     return this.typePathContainer[this.typePathOffset];
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
/*     */   public final int getStep(int paramInt) {
/*  96 */     return this.typePathContainer[this.typePathOffset + 2 * paramInt + 1];
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
/*     */   public final int getStepArgument(int paramInt) {
/* 108 */     return this.typePathContainer[this.typePathOffset + 2 * paramInt + 2];
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
/*     */   public static TypePath fromString(String paramString) {
/* 120 */     if (paramString == null || paramString.length() == 0) {
/* 121 */       return null;
/*     */     }
/* 123 */     int i = paramString.length();
/*     */     ByteVector byteVector;
/* 125 */     (byteVector = new ByteVector(i)).putByte(0);
/* 126 */     byte b = 0;
/* 127 */     while (b < i) {
/*     */       char c;
/* 129 */       if ((c = paramString.charAt(b++)) == '[') {
/* 130 */         byteVector.a(0, 0); continue;
/* 131 */       }  if (c == '.') {
/* 132 */         byteVector.a(1, 0); continue;
/* 133 */       }  if (c == '*') {
/* 134 */         byteVector.a(2, 0); continue;
/* 135 */       }  if (c >= '0' && c <= '9') {
/* 136 */         int j = c - 48;
/* 137 */         while (b < i) {
/*     */           
/* 139 */           if ((c = paramString.charAt(b++)) >= '0' && c <= '9') {
/* 140 */             j = j * 10 + c - 48; continue;
/* 141 */           }  if (c != ';')
/*     */           {
/*     */             
/* 144 */             throw new IllegalArgumentException();
/*     */           }
/*     */         } 
/* 147 */         byteVector.a(3, j); continue;
/*     */       } 
/* 149 */       throw new IllegalArgumentException();
/*     */     } 
/*     */     
/* 152 */     byteVector.a[0] = (byte)(byteVector.b / 2);
/* 153 */     return new TypePath(byteVector.a, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 163 */     int i = getLength();
/* 164 */     StringBuilder stringBuilder = new StringBuilder(i << 1);
/* 165 */     for (byte b = 0; b < i; b++) {
/* 166 */       switch (getStep(b)) {
/*     */         case 0:
/* 168 */           stringBuilder.append('[');
/*     */           break;
/*     */         case 1:
/* 171 */           stringBuilder.append('.');
/*     */           break;
/*     */         case 2:
/* 174 */           stringBuilder.append('*');
/*     */           break;
/*     */         case 3:
/* 177 */           stringBuilder.append(getStepArgument(b)).append(';');
/*     */           break;
/*     */         default:
/* 180 */           throw new AssertionError();
/*     */       } 
/*     */     } 
/* 183 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void a(TypePath paramTypePath, ByteVector paramByteVector) {
/* 194 */     if (paramTypePath == null) {
/* 195 */       paramByteVector.putByte(0); return;
/*     */     } 
/* 197 */     int i = (paramTypePath.typePathContainer[paramTypePath.typePathOffset] << 1) + 1;
/* 198 */     paramByteVector.putByteArray(paramTypePath.typePathContainer, paramTypePath.typePathOffset, i);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\TypePath.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */