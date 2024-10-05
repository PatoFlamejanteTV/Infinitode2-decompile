/*    */ package com.badlogic.gdx.assets.loaders;
/*    */ 
/*    */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*    */ import com.badlogic.gdx.assets.AssetManager;
/*    */ import com.badlogic.gdx.files.FileHandle;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AsynchronousAssetLoader<T, P extends AssetLoaderParameters<T>>
/*    */   extends AssetLoader<T, P>
/*    */ {
/*    */   public AsynchronousAssetLoader(FileHandleResolver paramFileHandleResolver) {
/* 32 */     super(paramFileHandleResolver);
/*    */   }
/*    */   
/*    */   public abstract void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, P paramP);
/*    */   
/*    */   public void unloadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, P paramP) {}
/*    */   
/*    */   public abstract T loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, P paramP);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\assets\loaders\AsynchronousAssetLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */