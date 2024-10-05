/*    */ package com.badlogic.gdx.assets.loaders;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.assets.AssetDescriptor;
/*    */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*    */ import com.badlogic.gdx.assets.AssetManager;
/*    */ import com.badlogic.gdx.audio.Sound;
/*    */ import com.badlogic.gdx.files.FileHandle;
/*    */ import com.badlogic.gdx.utils.Array;
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
/*    */ public class SoundLoader
/*    */   extends AsynchronousAssetLoader<Sound, SoundLoader.SoundParameter>
/*    */ {
/*    */   private Sound sound;
/*    */   
/*    */   public SoundLoader(FileHandleResolver paramFileHandleResolver) {
/* 34 */     super(paramFileHandleResolver);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Sound getLoadedSound() {
/* 41 */     return this.sound;
/*    */   }
/*    */ 
/*    */   
/*    */   public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, SoundParameter paramSoundParameter) {
/* 46 */     this.sound = Gdx.audio.newSound(paramFileHandle);
/*    */   }
/*    */ 
/*    */   
/*    */   public Sound loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, SoundParameter paramSoundParameter) {
/* 51 */     Sound sound = this.sound;
/* 52 */     this.sound = null;
/* 53 */     return sound;
/*    */   }
/*    */ 
/*    */   
/*    */   public Array<AssetDescriptor> getDependencies(String paramString, FileHandle paramFileHandle, SoundParameter paramSoundParameter) {
/* 58 */     return null;
/*    */   }
/*    */   
/*    */   public static class SoundParameter extends AssetLoaderParameters<Sound> {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\assets\loaders\SoundLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */