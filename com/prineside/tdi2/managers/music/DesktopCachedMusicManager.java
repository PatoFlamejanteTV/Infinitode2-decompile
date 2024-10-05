/*    */ package com.prineside.tdi2.managers.music;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.audio.Music;
/*    */ import com.prineside.tdi2.ibxm.Module;
/*    */ import com.prineside.tdi2.managers.MusicManager;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ 
/*    */ @REGS(serializer = MusicManager.Serializer.class)
/*    */ public class DesktopCachedMusicManager
/*    */   extends CachedMusicManager
/*    */ {
/*    */   private Music e;
/*    */   private Music f;
/*    */   
/*    */   protected final void a(Module paramModule) {
/* 19 */     this.b = paramModule.getVolumeMultiplierFromInstrumentNames();
/*    */     
/* 21 */     String str2 = null;
/* 22 */     if (paramModule.restartPos != 0) str2 = a(paramModule, false); 
/* 23 */     String str1 = a(paramModule, true);
/*    */     
/* 25 */     if (str2 == null) {
/*    */       
/* 27 */       this.f = Gdx.audio.newMusic(Gdx.files.local(str1));
/* 28 */       this.f.setVolume(0.0F);
/* 29 */       this.f.setLooping(true);
/* 30 */       this.f.play();
/*    */       return;
/*    */     } 
/* 33 */     this.e = Gdx.audio.newMusic(Gdx.files.local(str2));
/* 34 */     this.e.setVolume(0.0F);
/* 35 */     this.f = Gdx.audio.newMusic(Gdx.files.local(str1));
/* 36 */     this.f.setVolume(0.0F);
/*    */     
/* 38 */     this.e.setOnCompletionListener(paramMusic -> {
/*    */           this.e.stop();
/*    */           
/*    */           this.e.dispose();
/*    */           
/*    */           this.e = null;
/*    */           this.f.setLooping(true);
/*    */           this.f.play();
/*    */         });
/* 47 */     this.f.play();
/* 48 */     this.f.pause();
/*    */     
/* 50 */     this.e.play();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void stopMusic() {
/* 56 */     if (this.e != null) {
/* 57 */       this.e.stop();
/* 58 */       this.e.dispose();
/* 59 */       this.e = null;
/*    */     } 
/* 61 */     if (this.f != null) {
/* 62 */       this.f.stop();
/* 63 */       this.f.dispose();
/* 64 */       this.f = null;
/*    */     } 
/*    */     
/* 67 */     super.stopMusic();
/*    */   }
/*    */ 
/*    */   
/*    */   public void setBackendVolume(float paramFloat) {
/* 72 */     if (this.e != null) {
/* 73 */       this.e.setVolume(paramFloat);
/*    */     }
/* 75 */     if (this.f != null)
/* 76 */       this.f.setVolume(paramFloat); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\music\DesktopCachedMusicManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */