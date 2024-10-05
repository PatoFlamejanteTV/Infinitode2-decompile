/*    */ package com.prineside.tdi2;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Null;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.KryoSerializable;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.utils.REGS;
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
/*    */ @REGS(classOnly = true)
/*    */ public abstract class Registrable
/*    */   implements KryoSerializable
/*    */ {
/*    */   @Null
/*    */   public GameSystemProvider S;
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 33 */     paramKryo.writeObjectOrNull(paramOutput, this.S, GameSystemProvider.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 38 */     this.S = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setRegistered(GameSystemProvider paramGameSystemProvider) {
/* 46 */     this.S = paramGameSystemProvider;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setUnregistered() {
/* 53 */     this.S = null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isRegistered() {
/* 61 */     return (this.S != null);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Registrable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */