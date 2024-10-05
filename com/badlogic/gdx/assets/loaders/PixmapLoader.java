/*    */ package com.badlogic.gdx.assets.loaders;
/*    */ 
/*    */ import com.badlogic.gdx.assets.AssetDescriptor;
/*    */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*    */ import com.badlogic.gdx.assets.AssetManager;
/*    */ import com.badlogic.gdx.files.FileHandle;
/*    */ import com.badlogic.gdx.graphics.Pixmap;
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
/*    */ public class PixmapLoader
/*    */   extends AsynchronousAssetLoader<Pixmap, PixmapLoader.PixmapParameter>
/*    */ {
/*    */   Pixmap pixmap;
/*    */   
/*    */   public PixmapLoader(FileHandleResolver paramFileHandleResolver) {
/* 30 */     super(paramFileHandleResolver);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, PixmapParameter paramPixmapParameter) {
/* 37 */     this.pixmap = null;
/* 38 */     this.pixmap = new Pixmap(paramFileHandle);
/*    */   }
/*    */ 
/*    */   
/*    */   public Pixmap loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, PixmapParameter paramPixmapParameter) {
/* 43 */     Pixmap pixmap = this.pixmap;
/* 44 */     this.pixmap = null;
/* 45 */     return pixmap;
/*    */   }
/*    */ 
/*    */   
/*    */   public Array<AssetDescriptor> getDependencies(String paramString, FileHandle paramFileHandle, PixmapParameter paramPixmapParameter) {
/* 50 */     return null;
/*    */   }
/*    */   
/*    */   public static class PixmapParameter extends AssetLoaderParameters<Pixmap> {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\assets\loaders\PixmapLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */