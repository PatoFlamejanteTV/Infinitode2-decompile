/*     */ package com.badlogic.gdx.assets.loaders;
/*     */ 
/*     */ import com.badlogic.gdx.assets.AssetDescriptor;
/*     */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*     */ import com.badlogic.gdx.assets.AssetManager;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Cubemap;
/*     */ import com.badlogic.gdx.graphics.CubemapData;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.glutils.KTXTextureData;
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
/*     */ public class CubemapLoader
/*     */   extends AsynchronousAssetLoader<Cubemap, CubemapLoader.CubemapParameter>
/*     */ {
/*     */   public static class CubemapLoaderInfo
/*     */   {
/*     */     String filename;
/*     */     CubemapData data;
/*     */     Cubemap cubemap;
/*     */   }
/*  44 */   CubemapLoaderInfo info = new CubemapLoaderInfo();
/*     */   
/*     */   public CubemapLoader(FileHandleResolver paramFileHandleResolver) {
/*  47 */     super(paramFileHandleResolver);
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, CubemapParameter paramCubemapParameter) {
/*  52 */     this.info.filename = paramString;
/*  53 */     if (paramCubemapParameter == null || paramCubemapParameter.cubemapData == null) {
/*     */ 
/*     */       
/*  56 */       this.info.cubemap = null;
/*     */       
/*  58 */       if (paramCubemapParameter != null)
/*     */       {
/*  60 */         this.info.cubemap = paramCubemapParameter.cubemap;
/*     */       }
/*     */       
/*  63 */       if (paramString.contains(".ktx") || paramString.contains(".zktx")) {
/*  64 */         this.info.data = (CubemapData)new KTXTextureData(paramFileHandle, false);
/*     */       }
/*     */     } else {
/*  67 */       this.info.data = paramCubemapParameter.cubemapData;
/*  68 */       this.info.cubemap = paramCubemapParameter.cubemap;
/*     */     } 
/*  70 */     if (!this.info.data.isPrepared()) this.info.data.prepare();
/*     */   
/*     */   }
/*     */   
/*     */   public Cubemap loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, CubemapParameter paramCubemapParameter) {
/*  75 */     if (this.info == null) return null; 
/*     */     Cubemap cubemap;
/*  77 */     if ((cubemap = this.info.cubemap) != null) {
/*  78 */       cubemap.load(this.info.data);
/*     */     } else {
/*  80 */       cubemap = new Cubemap(this.info.data);
/*     */     } 
/*  82 */     if (paramCubemapParameter != null) {
/*  83 */       cubemap.setFilter(paramCubemapParameter.minFilter, paramCubemapParameter.magFilter);
/*  84 */       cubemap.setWrap(paramCubemapParameter.wrapU, paramCubemapParameter.wrapV);
/*     */     } 
/*  86 */     return cubemap;
/*     */   }
/*     */ 
/*     */   
/*     */   public Array<AssetDescriptor> getDependencies(String paramString, FileHandle paramFileHandle, CubemapParameter paramCubemapParameter) {
/*  91 */     return null;
/*     */   }
/*     */   
/*     */   public static class CubemapParameter
/*     */     extends AssetLoaderParameters<Cubemap> {
/*  96 */     public Pixmap.Format format = null;
/*     */     
/*  98 */     public Cubemap cubemap = null;
/*     */     
/* 100 */     public CubemapData cubemapData = null;
/* 101 */     public Texture.TextureFilter minFilter = Texture.TextureFilter.Nearest;
/* 102 */     public Texture.TextureFilter magFilter = Texture.TextureFilter.Nearest;
/* 103 */     public Texture.TextureWrap wrapU = Texture.TextureWrap.ClampToEdge;
/* 104 */     public Texture.TextureWrap wrapV = Texture.TextureWrap.ClampToEdge;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\assets\loaders\CubemapLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */