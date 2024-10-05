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
/*     */ public class Attribute
/*     */ {
/*     */   public final String type;
/*     */   private byte[] content;
/*     */   Attribute a;
/*     */   
/*     */   protected Attribute(String paramString) {
/*  65 */     this.type = paramString;
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
/*     */   public boolean isUnknown() {
/*  79 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCodeAttribute() {
/*  88 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Label[] getLabels() {
/*  98 */     return new Label[0];
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
/*     */   protected Attribute read(ClassReader paramClassReader, int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3, Label[] paramArrayOfLabel) {
/*     */     Attribute attribute;
/* 129 */     (attribute = new Attribute(this.type)).content = new byte[paramInt2];
/* 130 */     System.arraycopy(paramClassReader.a, paramInt1, attribute.content, 0, paramInt2);
/* 131 */     return attribute;
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
/*     */   protected ByteVector write(ClassWriter paramClassWriter, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
/* 159 */     return new ByteVector(this.content);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final int a() {
/* 168 */     byte b = 0;
/* 169 */     Attribute attribute = this;
/* 170 */     while (attribute != null) {
/* 171 */       b++;
/* 172 */       attribute = attribute.a;
/*     */     } 
/* 174 */     return b;
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
/*     */   final int a(SymbolTable paramSymbolTable) {
/* 187 */     byte[] arrayOfByte = null;
/*     */ 
/*     */ 
/*     */     
/* 191 */     return a(paramSymbolTable, arrayOfByte, 0, -1, -1);
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
/*     */   final int a(SymbolTable paramSymbolTable, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
/* 219 */     ClassWriter classWriter = paramSymbolTable.a;
/* 220 */     int i = 0;
/* 221 */     Attribute attribute = this;
/* 222 */     while (attribute != null) {
/* 223 */       paramSymbolTable.b(attribute.type);
/* 224 */       i += 6 + (attribute.write(classWriter, paramArrayOfbyte, paramInt1, paramInt2, paramInt3)).b;
/* 225 */       attribute = attribute.a;
/*     */     } 
/* 227 */     return i;
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
/*     */   static int a(SymbolTable paramSymbolTable, int paramInt1, int paramInt2) {
/* 244 */     boolean bool = false;
/*     */     
/* 246 */     if ((paramInt1 & 0x1000) != 0 && paramSymbolTable
/* 247 */       .b() < 49) {
/*     */       
/* 249 */       paramSymbolTable.b("Synthetic");
/* 250 */       bool += true;
/*     */     } 
/* 252 */     if (paramInt2 != 0) {
/*     */       
/* 254 */       paramSymbolTable.b("Signature");
/* 255 */       bool += true;
/*     */     } 
/*     */     
/* 258 */     if ((paramInt1 & 0x20000) != 0) {
/*     */       
/* 260 */       paramSymbolTable.b("Deprecated");
/* 261 */       bool += true;
/*     */     } 
/* 263 */     return bool;
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
/*     */   final void a(SymbolTable paramSymbolTable, ByteVector paramByteVector) {
/* 275 */     byte[] arrayOfByte = null;
/*     */ 
/*     */ 
/*     */     
/* 279 */     a(paramSymbolTable, arrayOfByte, 0, -1, -1, paramByteVector);
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
/*     */   final void a(SymbolTable paramSymbolTable, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, ByteVector paramByteVector) {
/* 307 */     ClassWriter classWriter = paramSymbolTable.a;
/* 308 */     Attribute attribute = this;
/* 309 */     while (attribute != null) {
/*     */       
/* 311 */       ByteVector byteVector = attribute.write(classWriter, paramArrayOfbyte, paramInt1, paramInt2, paramInt3);
/*     */       
/* 313 */       paramByteVector.putShort(paramSymbolTable.b(attribute.type)).putInt(byteVector.b);
/* 314 */       paramByteVector.putByteArray(byteVector.a, 0, byteVector.b);
/* 315 */       attribute = attribute.a;
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
/*     */   static void a(SymbolTable paramSymbolTable, int paramInt1, int paramInt2, ByteVector paramByteVector) {
/* 335 */     if ((paramInt1 & 0x1000) != 0 && paramSymbolTable
/* 336 */       .b() < 49) {
/* 337 */       paramByteVector.putShort(paramSymbolTable.b("Synthetic")).putInt(0);
/*     */     }
/* 339 */     if (paramInt2 != 0) {
/* 340 */       paramByteVector
/* 341 */         .putShort(paramSymbolTable.b("Signature"))
/* 342 */         .putInt(2)
/* 343 */         .putShort(paramInt2);
/*     */     }
/* 345 */     if ((paramInt1 & 0x20000) != 0) {
/* 346 */       paramByteVector.putShort(paramSymbolTable.b("Deprecated")).putInt(0);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static final class Set
/*     */   {
/*     */     private static final int SIZE_INCREMENT = 6;
/*     */     
/*     */     private int size;
/* 356 */     private Attribute[] data = new Attribute[6];
/*     */     
/*     */     final void a(Attribute param1Attribute) {
/* 359 */       param1Attribute = param1Attribute;
/* 360 */       while (param1Attribute != null) {
/* 361 */         if (!contains(param1Attribute)) {
/* 362 */           add(param1Attribute);
/*     */         }
/* 364 */         param1Attribute = param1Attribute.a;
/*     */       } 
/*     */     }
/*     */     
/*     */     final Attribute[] a() {
/* 369 */       Attribute[] arrayOfAttribute = new Attribute[this.size];
/* 370 */       System.arraycopy(this.data, 0, arrayOfAttribute, 0, this.size);
/* 371 */       return arrayOfAttribute;
/*     */     }
/*     */     
/*     */     private boolean contains(Attribute param1Attribute) {
/* 375 */       for (byte b = 0; b < this.size; b++) {
/* 376 */         if ((this.data[b]).type.equals(param1Attribute.type)) {
/* 377 */           return true;
/*     */         }
/*     */       } 
/* 380 */       return false;
/*     */     }
/*     */     
/*     */     private void add(Attribute param1Attribute) {
/* 384 */       if (this.size >= this.data.length) {
/* 385 */         Attribute[] arrayOfAttribute = new Attribute[this.data.length + 6];
/* 386 */         System.arraycopy(this.data, 0, arrayOfAttribute, 0, this.size);
/* 387 */         this.data = arrayOfAttribute;
/*     */       } 
/* 389 */       this.data[this.size++] = param1Attribute;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\Attribute.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */