/*    */ package com.prineside.tdi2.serializers;
/*    */ 
/*    */ import com.badlogic.gdx.math.Rectangle;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ public final class RectangleSerializer extends Serializer<Rectangle> {
/*    */   public RectangleSerializer() {
/* 11 */     setAcceptsNull(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput, Rectangle paramRectangle) {
/* 16 */     paramOutput.writeFloat(paramRectangle.x);
/* 17 */     paramOutput.writeFloat(paramRectangle.y);
/* 18 */     paramOutput.writeFloat(paramRectangle.width);
/* 19 */     paramOutput.writeFloat(paramRectangle.height);
/*    */   }
/*    */ 
/*    */   
/*    */   public final Rectangle read(Kryo paramKryo, Input paramInput, Class<? extends Rectangle> paramClass) {
/* 24 */     return new Rectangle(paramInput.readFloat(), paramInput.readFloat(), paramInput.readFloat(), paramInput.readFloat());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\RectangleSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */