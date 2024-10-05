/*    */ package com.esotericsoftware.kryo.serializers;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.KryoException;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
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
/*    */ public class EnumNameSerializer
/*    */   extends ImmutableSerializer<Enum>
/*    */ {
/*    */   private final Class<? extends Enum> enumType;
/*    */   
/*    */   public EnumNameSerializer(Class<? extends Enum> paramClass) {
/* 33 */     this.enumType = paramClass;
/*    */   }
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput, Enum paramEnum) {
/* 37 */     paramOutput.writeString(paramEnum.name());
/*    */   }
/*    */   
/*    */   public Enum read(Kryo paramKryo, Input paramInput, Class paramClass) {
/* 41 */     String str = paramInput.readString();
/*    */     try {
/* 43 */       return Enum.valueOf((Class)this.enumType, str);
/* 44 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 45 */       throw new KryoException("Enum value not found with name: " + str, illegalArgumentException);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\EnumNameSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */