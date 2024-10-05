/*    */ package com.esotericsoftware.kryo.serializers;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.esotericsoftware.kryo.util.Util;
/*    */ import java.util.Optional;
/*    */ import java.util.OptionalDouble;
/*    */ import java.util.OptionalInt;
/*    */ import java.util.OptionalLong;
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
/*    */ public final class OptionalSerializers
/*    */ {
/*    */   public static void addDefaultSerializers(Kryo paramKryo) {
/* 38 */     if (Util.isClassAvailable("java.util.Optional")) paramKryo.addDefaultSerializer(Optional.class, OptionalSerializer.class); 
/* 39 */     if (Util.isClassAvailable("java.util.OptionalInt")) paramKryo.addDefaultSerializer(OptionalInt.class, OptionalIntSerializer.class); 
/* 40 */     if (Util.isClassAvailable("java.util.OptionalLong")) paramKryo.addDefaultSerializer(OptionalLong.class, OptionalLongSerializer.class); 
/* 41 */     if (Util.isClassAvailable("java.util.OptionalDouble"))
/* 42 */       paramKryo.addDefaultSerializer(OptionalDouble.class, OptionalDoubleSerializer.class); 
/*    */   }
/*    */   
/*    */   public static class OptionalSerializer extends Serializer<Optional> {
/*    */     public OptionalSerializer() {
/* 47 */       setAcceptsNull(false);
/*    */     }
/*    */     
/*    */     public void write(Kryo param1Kryo, Output param1Output, Optional<T> param1Optional) {
/* 51 */       T t = param1Optional.isPresent() ? param1Optional.get() : null;
/* 52 */       param1Kryo.writeClassAndObject(param1Output, t);
/*    */     }
/*    */     
/*    */     public Optional read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/* 56 */       return Optional.ofNullable(param1Kryo.readClassAndObject(param1Input));
/*    */     }
/*    */     
/*    */     public Optional copy(Kryo param1Kryo, Optional param1Optional) {
/* 60 */       if (param1Optional.isPresent()) {
/* 61 */         return Optional.of(param1Kryo.copy(param1Optional.get()));
/*    */       }
/* 63 */       return param1Optional;
/*    */     }
/*    */   }
/*    */   
/*    */   public static class OptionalIntSerializer extends ImmutableSerializer<OptionalInt> {
/*    */     public void write(Kryo param1Kryo, Output param1Output, OptionalInt param1OptionalInt) {
/* 69 */       param1Output.writeBoolean(param1OptionalInt.isPresent());
/* 70 */       if (param1OptionalInt.isPresent()) param1Output.writeInt(param1OptionalInt.getAsInt()); 
/*    */     }
/*    */     
/*    */     public OptionalInt read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/*    */       boolean bool;
/* 75 */       return (bool = param1Input.readBoolean()) ? OptionalInt.of(param1Input.readInt()) : OptionalInt.empty();
/*    */     }
/*    */   }
/*    */   
/*    */   public static class OptionalLongSerializer extends ImmutableSerializer<OptionalLong> {
/*    */     public void write(Kryo param1Kryo, Output param1Output, OptionalLong param1OptionalLong) {
/* 81 */       param1Output.writeBoolean(param1OptionalLong.isPresent());
/* 82 */       if (param1OptionalLong.isPresent()) param1Output.writeLong(param1OptionalLong.getAsLong()); 
/*    */     }
/*    */     
/*    */     public OptionalLong read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/*    */       boolean bool;
/* 87 */       return (bool = param1Input.readBoolean()) ? OptionalLong.of(param1Input.readLong()) : OptionalLong.empty();
/*    */     }
/*    */   }
/*    */   
/*    */   public static class OptionalDoubleSerializer extends ImmutableSerializer<OptionalDouble> {
/*    */     public void write(Kryo param1Kryo, Output param1Output, OptionalDouble param1OptionalDouble) {
/* 93 */       param1Output.writeBoolean(param1OptionalDouble.isPresent());
/* 94 */       if (param1OptionalDouble.isPresent()) param1Output.writeDouble(param1OptionalDouble.getAsDouble()); 
/*    */     }
/*    */     
/*    */     public OptionalDouble read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/*    */       boolean bool;
/* 99 */       return (bool = param1Input.readBoolean()) ? OptionalDouble.of(param1Input.readDouble()) : OptionalDouble.empty();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\OptionalSerializers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */