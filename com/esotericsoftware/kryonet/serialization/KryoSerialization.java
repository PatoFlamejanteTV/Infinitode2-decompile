/*    */ package com.esotericsoftware.kryonet.serialization;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.ByteBufferInput;
/*    */ import com.esotericsoftware.kryo.io.ByteBufferOutput;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.esotericsoftware.kryonet.Connection;
/*    */ import com.esotericsoftware.kryonet.FrameworkMessage;
/*    */ import java.nio.ByteBuffer;
/*    */ 
/*    */ 
/*    */ public class KryoSerialization
/*    */   implements Serialization
/*    */ {
/*    */   private final Kryo kryo;
/*    */   private final ByteBufferInput input;
/*    */   private final ByteBufferOutput output;
/*    */   
/*    */   public KryoSerialization() {
/* 21 */     this(new Kryo());
/*    */     
/* 23 */     this.kryo.setReferences(false);
/* 24 */     this.kryo.setRegistrationRequired(true);
/*    */   }
/*    */   
/*    */   public KryoSerialization(Kryo paramKryo) {
/* 28 */     this.kryo = paramKryo;
/*    */     
/* 30 */     this.kryo.register(FrameworkMessage.RegisterTCP.class);
/* 31 */     this.kryo.register(FrameworkMessage.RegisterUDP.class);
/* 32 */     this.kryo.register(FrameworkMessage.KeepAlive.class);
/* 33 */     this.kryo.register(FrameworkMessage.DiscoverHost.class);
/* 34 */     this.kryo.register(FrameworkMessage.Ping.class);
/*    */     
/* 36 */     this.input = new ByteBufferInput();
/* 37 */     this.output = new ByteBufferOutput();
/*    */   }
/*    */   
/*    */   public Kryo getKryo() {
/* 41 */     return this.kryo;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public synchronized void write(Connection paramConnection, ByteBuffer paramByteBuffer, Object paramObject) {
/* 47 */     this.output.setBuffer(paramByteBuffer);
/* 48 */     this.kryo.getContext().put("connection", paramConnection);
/* 49 */     this.kryo.writeClassAndObject((Output)this.output, paramObject);
/* 50 */     this.output.flush();
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized Object read(Connection paramConnection, ByteBuffer paramByteBuffer) {
/* 55 */     this.input.setBuffer(paramByteBuffer);
/* 56 */     this.kryo.getContext().put("connection", paramConnection);
/* 57 */     return this.kryo.readClassAndObject((Input)this.input);
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeLength(ByteBuffer paramByteBuffer, int paramInt) {
/* 62 */     paramByteBuffer.putInt(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public int readLength(ByteBuffer paramByteBuffer) {
/* 67 */     return paramByteBuffer.getInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getLengthLength() {
/* 72 */     return 4;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryonet\serialization\KryoSerialization.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */