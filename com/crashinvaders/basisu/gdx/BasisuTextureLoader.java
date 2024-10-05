/*    */ package com.crashinvaders.basisu.gdx;
/*    */ 
/*    */ import com.badlogic.gdx.assets.AssetDescriptor;
/*    */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*    */ import com.badlogic.gdx.assets.AssetManager;
/*    */ import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
/*    */ import com.badlogic.gdx.assets.loaders.FileHandleResolver;
/*    */ import com.badlogic.gdx.assets.loaders.TextureLoader;
/*    */ import com.badlogic.gdx.files.FileHandle;
/*    */ import com.badlogic.gdx.graphics.Texture;
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
/*    */ public class BasisuTextureLoader
/*    */   extends AsynchronousAssetLoader<Texture, TextureLoader.TextureParameter>
/*    */ {
/*    */   BasisuTextureData textureData;
/*    */   
/*    */   public BasisuTextureLoader(FileHandleResolver paramFileHandleResolver) {
/* 32 */     super(paramFileHandleResolver);
/*    */ 
/*    */     
/* 35 */     BasisuGdxUtils.initSupportedGlTextureFormats();
/*    */   }
/*    */   
/*    */   public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, TextureLoader.TextureParameter paramTextureParameter) {
/*    */     BasisuTextureData basisuTextureData;
/* 40 */     if (paramTextureParameter instanceof BasisuTextureParameter) {
/* 41 */       BasisuTextureParameter basisuTextureParameter = (BasisuTextureParameter)paramTextureParameter;
/* 42 */       basisuTextureData = new BasisuTextureData(paramFileHandle, basisuTextureParameter.imageIndex, basisuTextureParameter.mipmapLevel);
/* 43 */       if (basisuTextureParameter.formatSelector != null) {
/* 44 */         basisuTextureData.setTextureFormatSelector(basisuTextureParameter.formatSelector);
/*    */       }
/*    */     } else {
/* 47 */       basisuTextureData = new BasisuTextureData(paramFileHandle);
/*    */     } 
/* 49 */     basisuTextureData.prepare();
/* 50 */     this.textureData = basisuTextureData;
/*    */   }
/*    */   
/*    */   public Texture loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, TextureLoader.TextureParameter paramTextureParameter) {
/* 54 */     Texture texture = new Texture(this.textureData);
/* 55 */     this.textureData = null;
/*    */     
/* 57 */     if (paramTextureParameter != null) {
/* 58 */       texture.setFilter(paramTextureParameter.minFilter, paramTextureParameter.magFilter);
/* 59 */       texture.setWrap(paramTextureParameter.wrapU, paramTextureParameter.wrapV);
/*    */     } 
/*    */     
/* 62 */     return texture;
/*    */   }
/*    */   
/*    */   public Array<AssetDescriptor> getDependencies(String paramString, FileHandle paramFileHandle, TextureLoader.TextureParameter paramTextureParameter) {
/* 66 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public static class BasisuTextureParameter
/*    */     extends TextureLoader.TextureParameter
/*    */   {
/* 73 */     public int imageIndex = 0;
/* 74 */     public int mipmapLevel = 0;
/* 75 */     public BasisuTextureFormatSelector formatSelector = null;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\crashinvaders\basisu\gdx\BasisuTextureLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */