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
/*    */ public abstract class SynchronousAssetLoader<T, P extends AssetLoaderParameters<T>>
/*    */   extends AssetLoader<T, P>
/*    */ {
/*    */   public SynchronousAssetLoader(FileHandleResolver paramFileHandleResolver) {
/* 25 */     super(paramFileHandleResolver);
/*    */   }
/*    */   
/*    */   public abstract T load(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, P paramP);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\assets\loaders\SynchronousAssetLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */