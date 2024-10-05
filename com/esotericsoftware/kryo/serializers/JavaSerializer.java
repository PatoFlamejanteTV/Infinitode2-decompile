/*    */ package com.esotericsoftware.kryo.serializers;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.KryoException;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.esotericsoftware.kryo.util.ObjectMap;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.ObjectInputStream;
/*    */ import java.io.ObjectOutputStream;
/*    */ import java.io.ObjectStreamClass;
/*    */ import java.io.OutputStream;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JavaSerializer
/*    */   extends Serializer
/*    */ {
/*    */   public void write(Kryo paramKryo, Output paramOutput, Object paramObject) {
/*    */     try {
/*    */       ObjectMap objectMap;
/*    */       ObjectOutputStream objectOutputStream;
/* 47 */       if ((objectOutputStream = (ObjectOutputStream)(objectMap = paramKryo.getGraphContext()).get(this)) == null) {
/* 48 */         objectOutputStream = new ObjectOutputStream((OutputStream)paramOutput);
/* 49 */         objectMap.put(this, objectOutputStream);
/*    */       } 
/* 51 */       objectOutputStream.writeObject(paramObject);
/* 52 */       objectOutputStream.flush(); return;
/* 53 */     } catch (Exception exception) {
/* 54 */       throw new KryoException("Error during Java serialization.", exception);
/*    */     } 
/*    */   }
/*    */   
/*    */   public Object read(Kryo paramKryo, Input paramInput, Class paramClass) {
/*    */     try {
/*    */       ObjectMap objectMap;
/*    */       ObjectInputStream objectInputStream;
/* 62 */       if ((objectInputStream = (ObjectInputStream)(objectMap = paramKryo.getGraphContext()).get(this)) == null) {
/* 63 */         objectInputStream = new ObjectInputStreamWithKryoClassLoader((InputStream)paramInput, paramKryo);
/* 64 */         objectMap.put(this, objectInputStream);
/*    */       } 
/* 66 */       return objectInputStream.readObject();
/* 67 */     } catch (Exception exception) {
/* 68 */       throw new KryoException("Error during Java deserialization.", exception);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private static class ObjectInputStreamWithKryoClassLoader
/*    */     extends ObjectInputStream
/*    */   {
/*    */     private final Kryo kryo;
/*    */ 
/*    */     
/*    */     ObjectInputStreamWithKryoClassLoader(InputStream param1InputStream, Kryo param1Kryo) {
/* 80 */       super(param1InputStream);
/* 81 */       this.kryo = param1Kryo;
/*    */     }
/*    */     
/*    */     protected Class resolveClass(ObjectStreamClass param1ObjectStreamClass) {
/*    */       try {
/* 86 */         return Class.forName(param1ObjectStreamClass.getName(), false, this.kryo.getClassLoader());
/* 87 */       } catch (ClassNotFoundException classNotFoundException) {
/*    */         try {
/* 89 */           return super.resolveClass(param1ObjectStreamClass);
/* 90 */         } catch (ClassNotFoundException classNotFoundException1) {
/* 91 */           throw new KryoException("Class not found: " + param1ObjectStreamClass.getName(), classNotFoundException1);
/* 92 */         } catch (IOException iOException) {
/* 93 */           throw new KryoException("Could not load class: " + param1ObjectStreamClass.getName(), iOException);
/*    */         } 
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\JavaSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */