/*    */ package com.badlogic.gdx.assets.loaders;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.assets.AssetDescriptor;
/*    */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*    */ import com.badlogic.gdx.assets.AssetManager;
/*    */ import com.badlogic.gdx.audio.Music;
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
/*    */ public class MusicLoader
/*    */   extends AsynchronousAssetLoader<Music, MusicLoader.MusicParameter>
/*    */ {
/*    */   private Music music;
/*    */   
/*    */   public MusicLoader(FileHandleResolver paramFileHandleResolver) {
/* 34 */     super(paramFileHandleResolver);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Music getLoadedMusic() {
/* 41 */     return this.music;
/*    */   }
/*    */ 
/*    */   
/*    */   public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, MusicParameter paramMusicParameter) {
/* 46 */     this.music = Gdx.audio.newMusic(paramFileHandle);
/*    */   }
/*    */ 
/*    */   
/*    */   public Music loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, MusicParameter paramMusicParameter) {
/* 51 */     Music music = this.music;
/* 52 */     this.music = null;
/* 53 */     return music;
/*    */   }
/*    */ 
/*    */   
/*    */   public Array<AssetDescriptor> getDependencies(String paramString, FileHandle paramFileHandle, MusicParameter paramMusicParameter) {
/* 58 */     return null;
/*    */   }
/*    */   
/*    */   public static class MusicParameter extends AssetLoaderParameters<Music> {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\assets\loaders\MusicLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */