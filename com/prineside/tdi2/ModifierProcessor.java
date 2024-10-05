/*    */ package com.prineside.tdi2;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(arrayLevels = 1)
/*    */ public abstract class ModifierProcessor<T extends Modifier>
/*    */   extends Registrable
/*    */ {
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 13 */     super.write(paramKryo, paramOutput);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 18 */     super.read(paramKryo, paramInput);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\ModifierProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */