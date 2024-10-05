/*     */ package com.badlogic.gdx.assets.loaders;
/*     */ 
/*     */ import com.badlogic.gdx.assets.AssetDescriptor;
/*     */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*     */ import com.badlogic.gdx.assets.AssetManager;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.TextureData;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TextureLoader
/*     */   extends AsynchronousAssetLoader<Texture, TextureLoader.TextureParameter>
/*     */ {
/*     */   public static class TextureLoaderInfo
/*     */   {
/*     */     String filename;
/*     */     TextureData data;
/*     */     Texture texture;
/*     */   }
/*  42 */   TextureLoaderInfo info = new TextureLoaderInfo();
/*     */   
/*     */   public TextureLoader(FileHandleResolver paramFileHandleResolver) {
/*  45 */     super(paramFileHandleResolver);
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, TextureParameter paramTextureParameter) {
/*  50 */     this.info.filename = paramString;
/*  51 */     if (paramTextureParameter == null || paramTextureParameter.textureData == null) {
/*  52 */       Pixmap.Format format; paramAssetManager = null;
/*  53 */       boolean bool = false;
/*  54 */       this.info.texture = null;
/*     */       
/*  56 */       if (paramTextureParameter != null) {
/*  57 */         format = paramTextureParameter.format;
/*  58 */         bool = paramTextureParameter.genMipMaps;
/*  59 */         this.info.texture = paramTextureParameter.texture;
/*     */       } 
/*     */       
/*  62 */       this.info.data = TextureData.Factory.loadFromFile(paramFileHandle, format, bool);
/*     */     } else {
/*  64 */       this.info.data = paramTextureParameter.textureData;
/*  65 */       this.info.texture = paramTextureParameter.texture;
/*     */     } 
/*  67 */     if (!this.info.data.isPrepared()) this.info.data.prepare();
/*     */   
/*     */   }
/*     */   
/*     */   public Texture loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, TextureParameter paramTextureParameter) {
/*  72 */     if (this.info == null) return null; 
/*     */     Texture texture;
/*  74 */     if ((texture = this.info.texture) != null) {
/*  75 */       texture.load(this.info.data);
/*     */     } else {
/*  77 */       texture = new Texture(this.info.data);
/*     */     } 
/*  79 */     if (paramTextureParameter != null) {
/*  80 */       texture.setFilter(paramTextureParameter.minFilter, paramTextureParameter.magFilter);
/*  81 */       texture.setWrap(paramTextureParameter.wrapU, paramTextureParameter.wrapV);
/*     */     } 
/*  83 */     return texture;
/*     */   }
/*     */ 
/*     */   
/*     */   public Array<AssetDescriptor> getDependencies(String paramString, FileHandle paramFileHandle, TextureParameter paramTextureParameter) {
/*  88 */     return null;
/*     */   }
/*     */   
/*     */   public static class TextureParameter
/*     */     extends AssetLoaderParameters<Texture> {
/*  93 */     public Pixmap.Format format = null;
/*     */     
/*     */     public boolean genMipMaps = false;
/*     */     
/*  97 */     public Texture texture = null;
/*     */     
/*  99 */     public TextureData textureData = null;
/* 100 */     public Texture.TextureFilter minFilter = Texture.TextureFilter.Nearest;
/* 101 */     public Texture.TextureFilter magFilter = Texture.TextureFilter.Nearest;
/* 102 */     public Texture.TextureWrap wrapU = Texture.TextureWrap.ClampToEdge;
/* 103 */     public Texture.TextureWrap wrapV = Texture.TextureWrap.ClampToEdge;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\assets\loaders\TextureLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */