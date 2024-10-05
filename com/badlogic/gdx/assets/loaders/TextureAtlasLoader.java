/*    */ package com.badlogic.gdx.assets.loaders;
/*    */ 
/*    */ import com.badlogic.gdx.assets.AssetDescriptor;
/*    */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*    */ import com.badlogic.gdx.assets.AssetManager;
/*    */ import com.badlogic.gdx.files.FileHandle;
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureAtlas;
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
/*    */ 
/*    */ 
/*    */ public class TextureAtlasLoader
/*    */   extends SynchronousAssetLoader<TextureAtlas, TextureAtlasLoader.TextureAtlasParameter>
/*    */ {
/*    */   TextureAtlas.TextureAtlasData data;
/*    */   
/*    */   public TextureAtlasLoader(FileHandleResolver paramFileHandleResolver) {
/* 36 */     super(paramFileHandleResolver);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TextureAtlas load(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, TextureAtlasParameter paramTextureAtlasParameter) {
/* 43 */     for (Array.ArrayIterator<TextureAtlas.TextureAtlasData.Page> arrayIterator = this.data.getPages().iterator(); arrayIterator.hasNext(); ) { TextureAtlas.TextureAtlasData.Page page = arrayIterator.next();
/* 44 */       Texture texture = (Texture)paramAssetManager.get(page.textureFile.path().replaceAll("\\\\", "/"), Texture.class);
/* 45 */       page.texture = texture; }
/*    */ 
/*    */     
/* 48 */     TextureAtlas textureAtlas = new TextureAtlas(this.data);
/* 49 */     this.data = null;
/* 50 */     return textureAtlas;
/*    */   }
/*    */ 
/*    */   
/*    */   public Array<AssetDescriptor> getDependencies(String paramString, FileHandle paramFileHandle, TextureAtlasParameter paramTextureAtlasParameter) {
/* 55 */     FileHandle fileHandle = paramFileHandle.parent();
/*    */     
/* 57 */     if (paramTextureAtlasParameter != null) {
/* 58 */       this.data = new TextureAtlas.TextureAtlasData(paramFileHandle, fileHandle, paramTextureAtlasParameter.flip);
/*    */     } else {
/* 60 */       this.data = new TextureAtlas.TextureAtlasData(paramFileHandle, fileHandle, false);
/*    */     } 
/*    */     
/* 63 */     Array<AssetDescriptor> array = new Array();
/* 64 */     for (Array.ArrayIterator<TextureAtlas.TextureAtlasData.Page> arrayIterator = this.data.getPages().iterator(); arrayIterator.hasNext(); ) { TextureAtlas.TextureAtlasData.Page page = arrayIterator.next();
/*    */       TextureLoader.TextureParameter textureParameter;
/* 66 */       (textureParameter = new TextureLoader.TextureParameter()).format = page.format;
/* 67 */       textureParameter.genMipMaps = page.useMipMaps;
/* 68 */       textureParameter.minFilter = page.minFilter;
/* 69 */       textureParameter.magFilter = page.magFilter;
/* 70 */       array.add(new AssetDescriptor(page.textureFile, Texture.class, textureParameter)); }
/*    */     
/* 72 */     return array;
/*    */   }
/*    */   
/*    */   public static class TextureAtlasParameter
/*    */     extends AssetLoaderParameters<TextureAtlas>
/*    */   {
/*    */     public boolean flip = false;
/*    */     
/*    */     public TextureAtlasParameter() {}
/*    */     
/*    */     public TextureAtlasParameter(boolean param1Boolean) {
/* 83 */       this.flip = param1Boolean;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\assets\loaders\TextureAtlasLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */