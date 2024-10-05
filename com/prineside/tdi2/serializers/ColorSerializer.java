/*    */ package com.prineside.tdi2.serializers;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ public final class ColorSerializer extends Serializer<Color> {
/*    */   public ColorSerializer() {
/* 11 */     setAcceptsNull(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput, Color paramColor) {
/* 16 */     paramOutput.writeInt(Color.rgba8888(paramColor));
/*    */   }
/*    */ 
/*    */   
/*    */   public final Color read(Kryo paramKryo, Input paramInput, Class<? extends Color> paramClass) {
/* 21 */     return new Color(paramInput.readInt());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\ColorSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */