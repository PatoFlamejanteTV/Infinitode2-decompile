/*    */ package com.esotericsoftware.kryo.serializers;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.KryoException;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.InputChunked;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.esotericsoftware.kryo.io.OutputChunked;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ import java.util.zip.Deflater;
/*    */ import java.util.zip.DeflaterOutputStream;
/*    */ import java.util.zip.Inflater;
/*    */ import java.util.zip.InflaterInputStream;
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
/*    */ public class DeflateSerializer
/*    */   extends Serializer
/*    */ {
/*    */   private final Serializer serializer;
/*    */   private boolean noHeaders = true;
/* 39 */   private int compressionLevel = 4;
/*    */   
/*    */   public DeflateSerializer(Serializer paramSerializer) {
/* 42 */     this.serializer = paramSerializer;
/*    */   }
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput, Object paramObject) {
/* 46 */     OutputChunked outputChunked = new OutputChunked((OutputStream)paramOutput, 256);
/* 47 */     Deflater deflater = new Deflater(this.compressionLevel, this.noHeaders);
/*    */     try {
/* 49 */       DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream((OutputStream)outputChunked, deflater);
/* 50 */       Output output = new Output(deflaterOutputStream, 256);
/* 51 */       this.serializer.write(paramKryo, output, paramObject);
/* 52 */       output.flush();
/* 53 */       deflaterOutputStream.finish();
/* 54 */     } catch (IOException iOException) {
/* 55 */       throw new KryoException(iOException);
/*    */     } finally {
/* 57 */       deflater.end();
/*    */     } 
/* 59 */     outputChunked.endChunk();
/*    */   }
/*    */ 
/*    */   
/*    */   public Object read(Kryo paramKryo, Input paramInput, Class paramClass) {
/* 64 */     Inflater inflater = new Inflater(this.noHeaders);
/*    */     try {
/* 66 */       InflaterInputStream inflaterInputStream = new InflaterInputStream((InputStream)new InputChunked((InputStream)paramInput, 256), inflater);
/* 67 */       return this.serializer.read(paramKryo, new Input(inflaterInputStream, 256), paramClass);
/*    */     } finally {
/* 69 */       inflater.end();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setNoHeaders(boolean paramBoolean) {
/* 74 */     this.noHeaders = paramBoolean;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setCompressionLevel(int paramInt) {
/* 80 */     this.compressionLevel = paramInt;
/*    */   }
/*    */   
/*    */   public Object copy(Kryo paramKryo, Object paramObject) {
/* 84 */     return this.serializer.copy(paramKryo, paramObject);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\DeflateSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */