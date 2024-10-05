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
/*    */ public class Ktx2TextureLoader
/*    */   extends AsynchronousAssetLoader<Texture, TextureLoader.TextureParameter>
/*    */ {
/*    */   Ktx2TextureData textureData;
/*    */   
/*    */   public Ktx2TextureLoader(FileHandleResolver paramFileHandleResolver) {
/* 28 */     super(paramFileHandleResolver);
/*    */ 
/*    */     
/* 31 */     BasisuGdxUtils.initSupportedGlTextureFormats();
/*    */   }
/*    */   
/*    */   public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, TextureLoader.TextureParameter paramTextureParameter) {
/*    */     Ktx2TextureData ktx2TextureData;
/* 36 */     if (paramTextureParameter instanceof Ktx2TextureParameter) {
/* 37 */       Ktx2TextureParameter ktx2TextureParameter = (Ktx2TextureParameter)paramTextureParameter;
/* 38 */       ktx2TextureData = new Ktx2TextureData(paramFileHandle, ktx2TextureParameter.mipmapLevel);
/* 39 */       if (ktx2TextureParameter.formatSelector != null) {
/* 40 */         ktx2TextureData.setTextureFormatSelector(ktx2TextureParameter.formatSelector);
/*    */       }
/*    */     } else {
/* 43 */       ktx2TextureData = new Ktx2TextureData(paramFileHandle);
/*    */     } 
/* 45 */     ktx2TextureData.prepare();
/* 46 */     this.textureData = ktx2TextureData;
/*    */   }
/*    */   
/*    */   public Texture loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, TextureLoader.TextureParameter paramTextureParameter) {
/* 50 */     Texture texture = new Texture(this.textureData);
/* 51 */     this.textureData = null;
/*    */     
/* 53 */     if (paramTextureParameter != null) {
/* 54 */       texture.setFilter(paramTextureParameter.minFilter, paramTextureParameter.magFilter);
/* 55 */       texture.setWrap(paramTextureParameter.wrapU, paramTextureParameter.wrapV);
/*    */     } 
/*    */     
/* 58 */     return texture;
/*    */   }
/*    */   
/*    */   public Array<AssetDescriptor> getDependencies(String paramString, FileHandle paramFileHandle, TextureLoader.TextureParameter paramTextureParameter) {
/* 62 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Ktx2TextureParameter
/*    */     extends TextureLoader.TextureParameter
/*    */   {
/* 70 */     public int mipmapLevel = 0;
/* 71 */     public BasisuTextureFormatSelector formatSelector = null;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\crashinvaders\basisu\gdx\Ktx2TextureLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */