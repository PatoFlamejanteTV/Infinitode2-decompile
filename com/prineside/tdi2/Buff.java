/*    */ package com.prineside.tdi2;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.badlogic.gdx.utils.Disposable;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.KryoSerializable;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public abstract class Buff
/*    */   implements KryoSerializable
/*    */ {
/*    */   public static final float MAX_DURATION_MULTIPLIER = 10.0F;
/*    */   private BuffType a;
/*    */   public float duration;
/*    */   public float maxDuration;
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 29 */     paramKryo.writeObjectOrNull(paramOutput, this.a, BuffType.class);
/* 30 */     paramOutput.writeFloat(this.duration);
/* 31 */     paramOutput.writeFloat(this.maxDuration);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 36 */     this.a = (BuffType)paramKryo.readObjectOrNull(paramInput, BuffType.class);
/* 37 */     this.duration = paramInput.readFloat();
/* 38 */     this.maxDuration = paramInput.readFloat();
/*    */   }
/*    */   
/*    */   protected Buff(BuffType paramBuffType) {
/* 42 */     this.a = paramBuffType;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Buff cpy(float paramFloat) {
/* 50 */     return null;
/*    */   }
/*    */   public void setup(float paramFloat1, float paramFloat2) {
/* 53 */     this.duration = paramFloat1;
/* 54 */     this.maxDuration = paramFloat2;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BuffType getType() {
/* 65 */     return this.a;
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract TextureRegion getHealthBarIcon();
/*    */   
/*    */   public static abstract class Factory<T extends Buff>
/*    */     implements Disposable, EntityFactory
/*    */   {
/*    */     public abstract BuffProcessor<T> createProcessor();
/*    */     
/*    */     public void setup() {
/* 77 */       if (Game.i.assetManager != null)
/* 78 */         setupAssets(); 
/*    */     }
/*    */     
/*    */     public abstract TextureRegion getHealthBarIcon();
/*    */     
/*    */     public void setupAssets() {}
/*    */     
/*    */     public void dispose() {}
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Buff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */