/*     */ package com.badlogic.gdx.maps.tiled;
/*     */ 
/*     */ import com.badlogic.gdx.assets.AssetDescriptor;
/*     */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*     */ import com.badlogic.gdx.assets.AssetManager;
/*     */ import com.badlogic.gdx.assets.loaders.FileHandleResolver;
/*     */ import com.badlogic.gdx.assets.loaders.TextureLoader;
/*     */ import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.maps.ImageResolver;
/*     */ import com.badlogic.gdx.maps.MapProperties;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.XmlReader;
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
/*     */ public class TmxMapLoader
/*     */   extends BaseTmxMapLoader<TmxMapLoader.Parameters>
/*     */ {
/*     */   public static class Parameters
/*     */     extends BaseTmxMapLoader.Parameters {}
/*     */   
/*     */   public TmxMapLoader() {
/*  43 */     super((FileHandleResolver)new InternalFileHandleResolver());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TmxMapLoader(FileHandleResolver paramFileHandleResolver) {
/*  50 */     super(paramFileHandleResolver);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TiledMap load(String paramString) {
/*  59 */     return load(paramString, new Parameters());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TiledMap load(String paramString, Parameters paramParameters) {
/*  68 */     FileHandle fileHandle = resolve(paramString);
/*     */     
/*  70 */     this.root = this.xml.parse(fileHandle);
/*     */     
/*  72 */     ObjectMap objectMap = new ObjectMap();
/*     */     
/*     */     Array<FileHandle> array;
/*  75 */     for (Array.ArrayIterator<FileHandle> arrayIterator = (array = getDependencyFileHandles(fileHandle)).iterator(); arrayIterator.hasNext(); ) { FileHandle fileHandle1 = arrayIterator.next();
/*     */       Texture texture;
/*  77 */       (texture = new Texture(fileHandle1, paramParameters.generateMipMaps)).setFilter(paramParameters.textureMinFilter, paramParameters.textureMagFilter);
/*  78 */       objectMap.put(fileHandle1.path(), texture); }
/*     */ 
/*     */     
/*     */     TiledMap tiledMap;
/*  82 */     (tiledMap = loadTiledMap(fileHandle, paramParameters, (ImageResolver)new ImageResolver.DirectImageResolver(objectMap))).setOwnedResources(objectMap.values().toArray());
/*  83 */     return tiledMap;
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, Parameters paramParameters) {
/*  88 */     this.map = loadTiledMap(paramFileHandle, paramParameters, (ImageResolver)new ImageResolver.AssetManagerImageResolver(paramAssetManager));
/*     */   }
/*     */ 
/*     */   
/*     */   public TiledMap loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, Parameters paramParameters) {
/*  93 */     return this.map;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Array<AssetDescriptor> getDependencyAssetDescriptors(FileHandle paramFileHandle, TextureLoader.TextureParameter paramTextureParameter) {
/*  99 */     Array<AssetDescriptor> array1 = new Array();
/*     */     
/*     */     Array<FileHandle> array;
/* 102 */     for (Array.ArrayIterator<FileHandle> arrayIterator = (array = getDependencyFileHandles(paramFileHandle)).iterator(); arrayIterator.hasNext(); ) { FileHandle fileHandle = arrayIterator.next();
/* 103 */       array1.add(new AssetDescriptor(fileHandle, Texture.class, (AssetLoaderParameters)paramTextureParameter)); }
/*     */ 
/*     */     
/* 106 */     return array1;
/*     */   }
/*     */   
/*     */   protected Array<FileHandle> getDependencyFileHandles(FileHandle paramFileHandle) {
/* 110 */     Array<FileHandle> array = new Array();
/*     */     
/*     */     Array.ArrayIterator<XmlReader.Element> arrayIterator;
/* 113 */     for (arrayIterator = this.root.getChildrenByName("tileset").iterator(); arrayIterator.hasNext(); ) {
/*     */       Array.ArrayIterator<XmlReader.Element> arrayIterator1; FileHandle fileHandle; XmlReader.Element element1; String str;
/* 115 */       if ((str = (element1 = arrayIterator.next()).getAttribute("source", null)) != null) {
/* 116 */         String str1; FileHandle fileHandle1 = getRelativeFileHandle(paramFileHandle, str);
/*     */         
/*     */         XmlReader.Element element;
/* 119 */         if ((element = (element1 = this.xml.parse(fileHandle1)).getChildByName("image")) != null) {
/* 120 */           str1 = element1.getChildByName("image").getAttribute("source");
/* 121 */           FileHandle fileHandle2 = getRelativeFileHandle(fileHandle1, str1);
/* 122 */           array.add(fileHandle2); continue;
/*     */         } 
/* 124 */         for (arrayIterator1 = str1.getChildrenByName("tile").iterator(); arrayIterator1.hasNext(); ) {
/* 125 */           XmlReader.Element element3; String str2 = (element3 = arrayIterator1.next()).getChildByName("image").getAttribute("source");
/* 126 */           FileHandle fileHandle2 = getRelativeFileHandle(fileHandle1, str2);
/* 127 */           array.add(fileHandle2);
/*     */         } 
/*     */         continue;
/*     */       } 
/*     */       XmlReader.Element element2;
/* 132 */       if ((element2 = arrayIterator1.getChildByName("image")) != null) {
/* 133 */         String str1 = arrayIterator1.getChildByName("image").getAttribute("source");
/* 134 */         fileHandle = getRelativeFileHandle(paramFileHandle, str1);
/* 135 */         array.add(fileHandle); continue;
/*     */       } 
/* 137 */       for (Array.ArrayIterator<XmlReader.Element> arrayIterator2 = fileHandle.getChildrenByName("tile").iterator(); arrayIterator2.hasNext(); ) {
/* 138 */         XmlReader.Element element; String str1 = (element = arrayIterator2.next()).getChildByName("image").getAttribute("source");
/* 139 */         FileHandle fileHandle1 = getRelativeFileHandle(paramFileHandle, str1);
/* 140 */         array.add(fileHandle1);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 147 */     for (arrayIterator = this.root.getChildrenByName("imagelayer").iterator(); arrayIterator.hasNext();) {
/*     */ 
/*     */ 
/*     */       
/* 151 */       if ((str = (element2 = (element1 = arrayIterator.next()).getChildByName("image")).getAttribute("source", null)) != null) {
/* 152 */         FileHandle fileHandle = getRelativeFileHandle(paramFileHandle, str);
/* 153 */         array.add(fileHandle);
/*     */       } 
/*     */     } 
/*     */     
/* 157 */     return array;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addStaticTiles(FileHandle paramFileHandle1, ImageResolver paramImageResolver, TiledMapTileSet paramTiledMapTileSet, XmlReader.Element paramElement, Array<XmlReader.Element> paramArray, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, int paramInt6, int paramInt7, String paramString3, int paramInt8, int paramInt9, FileHandle paramFileHandle2) {
/*     */     int i;
/*     */     TextureRegion textureRegion1, textureRegion2;
/* 165 */     MapProperties mapProperties = paramTiledMapTileSet.getProperties();
/* 166 */     if (paramFileHandle2 != null) {
/*     */       
/* 168 */       textureRegion2 = paramImageResolver.getImage(paramFileHandle2.path());
/*     */       
/* 170 */       mapProperties.put("imagesource", paramString3);
/* 171 */       mapProperties.put("imagewidth", Integer.valueOf(paramInt8));
/* 172 */       mapProperties.put("imageheight", Integer.valueOf(paramInt9));
/* 173 */       mapProperties.put("tilewidth", Integer.valueOf(paramInt2));
/* 174 */       mapProperties.put("tileheight", Integer.valueOf(paramInt3));
/* 175 */       mapProperties.put("margin", Integer.valueOf(paramInt5));
/* 176 */       mapProperties.put("spacing", Integer.valueOf(paramInt4));
/*     */       
/* 178 */       int j = textureRegion2.getRegionWidth() - paramInt2;
/* 179 */       int k = textureRegion2.getRegionHeight() - paramInt3;
/*     */       
/* 181 */       int m = paramInt1;
/*     */       
/* 183 */       for (paramInt8 = paramInt5; paramInt8 <= k; paramInt8 += paramInt3 + paramInt4) {
/* 184 */         for (i = paramInt5; i <= j; i += paramInt2 + paramInt4) {
/* 185 */           textureRegion1 = new TextureRegion(textureRegion2, i, paramInt8, paramInt2, paramInt3);
/* 186 */           paramInt1 = m++;
/* 187 */           addStaticTiledMapTile(paramTiledMapTileSet, textureRegion1, paramInt1, paramInt6, paramInt7);
/*     */         } 
/*     */       } 
/*     */       return;
/*     */     } 
/* 192 */     for (Array.ArrayIterator<XmlReader.Element> arrayIterator = textureRegion2.iterator(); arrayIterator.hasNext(); ) {
/*     */       XmlReader.Element element1, element2;
/* 194 */       if ((element2 = (element1 = arrayIterator.next()).getChildByName("image")) != null) {
/* 195 */         paramString3 = element2.getAttribute("source");
/*     */         
/* 197 */         if (paramString2 != null) {
/* 198 */           paramFileHandle2 = getRelativeFileHandle(getRelativeFileHandle(i, paramString2), paramString3);
/*     */         } else {
/* 200 */           paramFileHandle2 = getRelativeFileHandle(i, paramString3);
/*     */         } 
/*     */       } 
/* 203 */       TextureRegion textureRegion = textureRegion1.getImage(paramFileHandle2.path());
/* 204 */       paramInt8 = paramInt1 + element1.getIntAttribute("id");
/* 205 */       addStaticTiledMapTile(paramTiledMapTileSet, textureRegion, paramInt8, paramInt6, paramInt7);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\tiled\TmxMapLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */