/*    */ package com.prineside.tdi2;
/*    */ 
/*    */ import com.badlogic.gdx.audio.Sound;
/*    */ import com.prineside.tdi2.enums.StaticSoundType;
/*    */ 
/*    */ public class StaticSound {
/*    */   public StaticSoundType type;
/*    */   public Sound sound;
/*    */   public int durationMs;
/*    */   
/*    */   public StaticSound(StaticSoundType paramStaticSoundType, Sound paramSound, int paramInt) {
/* 12 */     this.type = paramStaticSoundType;
/* 13 */     this.sound = paramSound;
/* 14 */     this.durationMs = paramInt;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\StaticSound.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */