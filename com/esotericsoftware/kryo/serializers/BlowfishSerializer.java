/*    */ package com.esotericsoftware.kryo.serializers;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.KryoException;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ import javax.crypto.Cipher;
/*    */ import javax.crypto.CipherInputStream;
/*    */ import javax.crypto.CipherOutputStream;
/*    */ import javax.crypto.spec.SecretKeySpec;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlowfishSerializer
/*    */   extends Serializer
/*    */ {
/*    */   private final Serializer serializer;
/*    */   private static SecretKeySpec keySpec;
/*    */   
/*    */   public BlowfishSerializer(Serializer paramSerializer, byte[] paramArrayOfbyte) {
/* 42 */     this.serializer = paramSerializer;
/* 43 */     keySpec = new SecretKeySpec(paramArrayOfbyte, "Blowfish");
/*    */   }
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput, Object paramObject) {
/* 47 */     Cipher cipher = getCipher(1);
/* 48 */     CipherOutputStream cipherOutputStream = new CipherOutputStream((OutputStream)paramOutput, cipher);
/* 49 */     Output output = new Output(cipherOutputStream, 256)
/*    */       {
/*    */         public void close() {}
/*    */       };
/*    */     
/* 54 */     this.serializer.write(paramKryo, output, paramObject);
/* 55 */     output.flush();
/*    */     try {
/* 57 */       cipherOutputStream.close(); return;
/* 58 */     } catch (IOException iOException) {
/* 59 */       throw new KryoException(iOException);
/*    */     } 
/*    */   }
/*    */   
/*    */   public Object read(Kryo paramKryo, Input paramInput, Class paramClass) {
/* 64 */     Cipher cipher = getCipher(2);
/* 65 */     CipherInputStream cipherInputStream = new CipherInputStream((InputStream)paramInput, cipher);
/* 66 */     return this.serializer.read(paramKryo, new Input(cipherInputStream, 256), paramClass);
/*    */   }
/*    */   
/*    */   public Object copy(Kryo paramKryo, Object paramObject) {
/* 70 */     return this.serializer.copy(paramKryo, paramObject);
/*    */   }
/*    */   
/*    */   private static Cipher getCipher(int paramInt) {
/*    */     try {
/*    */       Cipher cipher;
/* 76 */       (cipher = Cipher.getInstance("Blowfish")).init(paramInt, keySpec);
/* 77 */       return cipher;
/* 78 */     } catch (Exception exception) {
/* 79 */       throw new KryoException(exception);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\BlowfishSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */