/*    */ package com.esotericsoftware.kryonet.serialization;
/*    */ 
/*    */ import com.esotericsoftware.jsonbeans.Json;
/*    */ import com.esotericsoftware.jsonbeans.JsonException;
/*    */ import com.esotericsoftware.kryo.io.ByteBufferInputStream;
/*    */ import com.esotericsoftware.kryo.io.ByteBufferOutputStream;
/*    */ import com.esotericsoftware.kryonet.Connection;
/*    */ import com.esotericsoftware.kryonet.FrameworkMessage;
/*    */ import com.esotericsoftware.minlog.Log;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ import java.io.OutputStreamWriter;
/*    */ import java.nio.ByteBuffer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JsonSerialization
/*    */   implements Serialization
/*    */ {
/* 21 */   private final Json json = new Json();
/* 22 */   private final ByteBufferInputStream byteBufferInputStream = new ByteBufferInputStream();
/* 23 */   private final ByteBufferOutputStream byteBufferOutputStream = new ByteBufferOutputStream();
/* 24 */   private final OutputStreamWriter writer = new OutputStreamWriter((OutputStream)this.byteBufferOutputStream);
/*    */   private boolean logging = true;
/*    */   private boolean prettyPrint = true;
/* 27 */   private byte[] logBuffer = new byte[0];
/*    */   
/*    */   public JsonSerialization() {
/* 30 */     this.json.addClassTag("RegisterTCP", FrameworkMessage.RegisterTCP.class);
/* 31 */     this.json.addClassTag("RegisterUDP", FrameworkMessage.RegisterUDP.class);
/* 32 */     this.json.addClassTag("KeepAlive", FrameworkMessage.KeepAlive.class);
/* 33 */     this.json.addClassTag("DiscoverHost", FrameworkMessage.DiscoverHost.class);
/* 34 */     this.json.addClassTag("Ping", FrameworkMessage.Ping.class);
/*    */     
/* 36 */     this.json.setWriter(this.writer);
/*    */   }
/*    */   
/*    */   public void setLogging(boolean paramBoolean1, boolean paramBoolean2) {
/* 40 */     this.logging = paramBoolean1;
/* 41 */     this.prettyPrint = paramBoolean2;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public synchronized void write(Connection paramConnection, ByteBuffer paramByteBuffer, Object paramObject) {
/* 47 */     this.byteBufferOutputStream.setByteBuffer(paramByteBuffer);
/* 48 */     int i = paramByteBuffer.position();
/*    */     try {
/* 50 */       this.json.writeValue(paramObject, Object.class, null);
/* 51 */       this.writer.flush();
/* 52 */     } catch (Exception exception) {
/* 53 */       throw new JsonException("Error writing object: " + paramObject, exception);
/*    */     } 
/* 55 */     if (Log.INFO && this.logging) {
/* 56 */       int j = paramByteBuffer.position();
/* 57 */       paramByteBuffer.position(i);
/* 58 */       paramByteBuffer.limit(j);
/* 59 */       i = j - i;
/* 60 */       if (this.logBuffer.length < i)
/* 61 */         this.logBuffer = new byte[i]; 
/* 62 */       paramByteBuffer.get(this.logBuffer, 0, i);
/* 63 */       paramByteBuffer.position(j);
/* 64 */       paramByteBuffer.limit(paramByteBuffer.capacity());
/* 65 */       String str = new String(this.logBuffer, 0, i);
/* 66 */       if (this.prettyPrint)
/* 67 */         str = this.json.prettyPrint(str); 
/* 68 */       Log.info("Wrote: " + str);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized Object read(Connection paramConnection, ByteBuffer paramByteBuffer) {
/* 74 */     this.byteBufferInputStream.setByteBuffer(paramByteBuffer);
/* 75 */     return this.json.fromJson(Object.class, (InputStream)this.byteBufferInputStream);
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeLength(ByteBuffer paramByteBuffer, int paramInt) {
/* 80 */     paramByteBuffer.putInt(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public int readLength(ByteBuffer paramByteBuffer) {
/* 85 */     return paramByteBuffer.getInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getLengthLength() {
/* 90 */     return 4;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryonet\serialization\JsonSerialization.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */