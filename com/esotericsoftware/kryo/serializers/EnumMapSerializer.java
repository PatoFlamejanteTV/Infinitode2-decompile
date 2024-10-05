/*    */ package com.esotericsoftware.kryo.serializers;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import java.util.EnumMap;
/*    */ import java.util.Map;
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
/*    */ public class EnumMapSerializer
/*    */   extends MapSerializer<EnumMap>
/*    */ {
/*    */   private final Class<? extends Enum> enumType;
/*    */   
/*    */   public EnumMapSerializer(Class<? extends Enum> paramClass) {
/* 32 */     this.enumType = paramClass;
/*    */   }
/*    */   
/*    */   protected EnumMap create(Kryo paramKryo, Input paramInput, Class<? extends EnumMap> paramClass, int paramInt) {
/* 36 */     return new EnumMap<>(this.enumType);
/*    */   }
/*    */   
/*    */   protected EnumMap createCopy(Kryo paramKryo, EnumMap<Enum, ?> paramEnumMap) {
/* 40 */     return new EnumMap<>(paramEnumMap);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\EnumMapSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */