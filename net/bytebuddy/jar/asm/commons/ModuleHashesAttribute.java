/*     */ package net.bytebuddy.jar.asm.commons;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.jar.asm.Attribute;
/*     */ import net.bytebuddy.jar.asm.ByteVector;
/*     */ import net.bytebuddy.jar.asm.ClassReader;
/*     */ import net.bytebuddy.jar.asm.ClassWriter;
/*     */ import net.bytebuddy.jar.asm.Label;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ModuleHashesAttribute
/*     */   extends Attribute
/*     */ {
/*     */   public String algorithm;
/*     */   public List<String> modules;
/*     */   public List<byte[]> hashes;
/*     */   
/*     */   public ModuleHashesAttribute(String paramString, List<String> paramList, List<byte[]> paramList1) {
/*  64 */     super("ModuleHashes");
/*  65 */     this.algorithm = paramString;
/*  66 */     this.modules = paramList;
/*  67 */     this.hashes = paramList1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModuleHashesAttribute() {
/*  75 */     this(null, null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final Attribute read(ClassReader paramClassReader, int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3, Label[] paramArrayOfLabel) {
/*  86 */     paramInt2 = paramInt1;
/*     */     
/*  88 */     String str = paramClassReader.readUTF8(paramInt1, paramArrayOfchar);
/*  89 */     paramInt2 += 2;
/*     */     
/*  91 */     paramInt3 = paramClassReader.readUnsignedShort(paramInt2);
/*  92 */     paramInt2 += 2;
/*     */     
/*  94 */     ArrayList<String> arrayList = new ArrayList(paramInt3);
/*  95 */     ArrayList<byte[]> arrayList1 = new ArrayList(paramInt3);
/*     */     
/*  97 */     for (byte b = 0; b < paramInt3; b++) {
/*  98 */       String str1 = paramClassReader.readModule(paramInt2, paramArrayOfchar);
/*  99 */       paramInt2 += 2;
/* 100 */       arrayList.add(str1);
/*     */       
/* 102 */       int i = paramClassReader.readUnsignedShort(paramInt2);
/* 103 */       paramInt2 += 2;
/* 104 */       byte[] arrayOfByte = new byte[i];
/* 105 */       for (byte b1 = 0; b1 < i; b1++) {
/* 106 */         arrayOfByte[b1] = (byte)paramClassReader.readByte(paramInt2);
/* 107 */         paramInt2++;
/*     */       } 
/* 109 */       arrayList1.add(arrayOfByte);
/*     */     } 
/* 111 */     return new ModuleHashesAttribute(str, arrayList, (List<byte[]>)arrayList1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final ByteVector write(ClassWriter paramClassWriter, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
/*     */     ByteVector byteVector;
/* 122 */     (byteVector = new ByteVector()).putShort(paramClassWriter.newUTF8(this.algorithm));
/* 123 */     if (this.modules == null) {
/* 124 */       byteVector.putShort(0);
/*     */     } else {
/* 126 */       paramInt1 = this.modules.size();
/* 127 */       byteVector.putShort(paramInt1);
/* 128 */       for (paramInt2 = 0; paramInt2 < paramInt1; paramInt2++) {
/* 129 */         String str = this.modules.get(paramInt2);
/* 130 */         byte[] arrayOfByte = this.hashes.get(paramInt2);
/* 131 */         byteVector
/* 132 */           .putShort(paramClassWriter.newModule(str))
/* 133 */           .putShort(arrayOfByte.length)
/* 134 */           .putByteArray(arrayOfByte, 0, arrayOfByte.length);
/*     */       } 
/*     */     } 
/* 137 */     return byteVector;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\commons\ModuleHashesAttribute.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */