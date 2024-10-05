/*     */ package com.badlogic.gdx.assets.loaders;
/*     */ 
/*     */ import com.badlogic.gdx.assets.AssetDescriptor;
/*     */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*     */ import com.badlogic.gdx.assets.AssetManager;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureAtlas;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*     */ public class BitmapFontLoader
/*     */   extends AsynchronousAssetLoader<BitmapFont, BitmapFontLoader.BitmapFontParameter>
/*     */ {
/*     */   BitmapFont.BitmapFontData data;
/*     */   
/*     */   public BitmapFontLoader(FileHandleResolver paramFileHandleResolver) {
/*  40 */     super(paramFileHandleResolver);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Array<AssetDescriptor> getDependencies(String paramString, FileHandle paramFileHandle, BitmapFontParameter paramBitmapFontParameter) {
/*  47 */     Array<AssetDescriptor> array = new Array();
/*  48 */     if (paramBitmapFontParameter != null && paramBitmapFontParameter.bitmapFontData != null) {
/*  49 */       this.data = paramBitmapFontParameter.bitmapFontData;
/*  50 */       return array;
/*     */     } 
/*     */     
/*  53 */     this.data = new BitmapFont.BitmapFontData(paramFileHandle, (paramBitmapFontParameter != null && paramBitmapFontParameter.flip));
/*  54 */     if (paramBitmapFontParameter != null && paramBitmapFontParameter.atlasName != null) {
/*  55 */       array.add(new AssetDescriptor(paramBitmapFontParameter.atlasName, TextureAtlas.class));
/*     */     } else {
/*  57 */       for (byte b = 0; b < (this.data.getImagePaths()).length; b++) {
/*  58 */         String str = this.data.getImagePath(b);
/*  59 */         FileHandle fileHandle = resolve(str);
/*     */         
/*  61 */         TextureLoader.TextureParameter textureParameter = new TextureLoader.TextureParameter();
/*     */         
/*  63 */         if (paramBitmapFontParameter != null) {
/*  64 */           textureParameter.genMipMaps = paramBitmapFontParameter.genMipMaps;
/*  65 */           textureParameter.minFilter = paramBitmapFontParameter.minFilter;
/*  66 */           textureParameter.magFilter = paramBitmapFontParameter.magFilter;
/*     */         } 
/*     */         
/*  69 */         AssetDescriptor assetDescriptor = new AssetDescriptor(fileHandle, Texture.class, textureParameter);
/*  70 */         array.add(assetDescriptor);
/*     */       } 
/*     */     } 
/*     */     
/*  74 */     return array;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, BitmapFontParameter paramBitmapFontParameter) {}
/*     */ 
/*     */   
/*     */   public BitmapFont loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, BitmapFontParameter paramBitmapFontParameter) {
/*  83 */     if (paramBitmapFontParameter != null && paramBitmapFontParameter.atlasName != null) {
/*  84 */       TextureAtlas textureAtlas = (TextureAtlas)paramAssetManager.get(paramBitmapFontParameter.atlasName, TextureAtlas.class);
/*  85 */       String str = paramFileHandle.sibling(this.data.imagePaths[0]).nameWithoutExtension().toString();
/*     */       
/*     */       TextureAtlas.AtlasRegion atlasRegion;
/*  88 */       if ((atlasRegion = textureAtlas.findRegion(str)) == null)
/*  89 */         throw new GdxRuntimeException("Could not find font region " + str + " in atlas " + paramBitmapFontParameter.atlasName); 
/*  90 */       return new BitmapFont(paramFileHandle, (TextureRegion)atlasRegion);
/*     */     } 
/*  92 */     int i = (this.data.getImagePaths()).length;
/*  93 */     Array array = new Array(i);
/*  94 */     for (byte b = 0; b < i; b++) {
/*  95 */       array.add(new TextureRegion((Texture)paramAssetManager.get(this.data.getImagePath(b), Texture.class)));
/*     */     }
/*  97 */     return new BitmapFont(this.data, array, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class BitmapFontParameter
/*     */     extends AssetLoaderParameters<BitmapFont>
/*     */   {
/*     */     public boolean flip = false;
/*     */ 
/*     */     
/*     */     public boolean genMipMaps = false;
/*     */ 
/*     */     
/* 112 */     public Texture.TextureFilter minFilter = Texture.TextureFilter.Nearest;
/*     */ 
/*     */     
/* 115 */     public Texture.TextureFilter magFilter = Texture.TextureFilter.Nearest;
/*     */ 
/*     */ 
/*     */     
/* 119 */     public BitmapFont.BitmapFontData bitmapFontData = null;
/*     */ 
/*     */ 
/*     */     
/* 123 */     public String atlasName = null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\assets\loaders\BitmapFontLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */