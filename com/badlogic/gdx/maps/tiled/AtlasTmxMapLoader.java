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
/*     */ import com.badlogic.gdx.graphics.g2d.TextureAtlas;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.maps.ImageResolver;
/*     */ import com.badlogic.gdx.maps.MapProperties;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AtlasTmxMapLoader
/*     */   extends BaseTmxMapLoader<AtlasTmxMapLoader.AtlasTiledMapLoaderParameters>
/*     */ {
/*     */   public static class AtlasTiledMapLoaderParameters
/*     */     extends BaseTmxMapLoader.Parameters
/*     */   {
/*     */     public boolean forceTextureFilters = false;
/*     */   }
/*     */   
/*     */   public static class DirectAtlasResolver
/*     */     implements AtlasResolver
/*     */   {
/*     */     private final TextureAtlas atlas;
/*     */     
/*     */     public DirectAtlasResolver(TextureAtlas param1TextureAtlas) {
/*  58 */       this.atlas = param1TextureAtlas;
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureAtlas getAtlas() {
/*  63 */       return this.atlas;
/*     */     }
/*     */     
/*     */     public TextureRegion getImage(String param1String)
/*     */     {
/*  68 */       return (TextureRegion)this.atlas.findRegion(param1String); } } protected static interface AtlasResolver extends ImageResolver { TextureAtlas getAtlas(); public static class DirectAtlasResolver implements AtlasResolver { public TextureRegion getImage(String param2String) { return (TextureRegion)this.atlas.findRegion(param2String); }
/*     */        private final TextureAtlas atlas; public DirectAtlasResolver(TextureAtlas param2TextureAtlas) {
/*     */         this.atlas = param2TextureAtlas;
/*     */       }
/*     */       public TextureAtlas getAtlas() {
/*     */         return this.atlas;
/*     */       } }
/*     */     public static class AssetManagerAtlasResolver implements AtlasResolver { private final AssetManager assetManager; private final String atlasName;
/*     */       public AssetManagerAtlasResolver(AssetManager param2AssetManager, String param2String) {
/*  77 */         this.assetManager = param2AssetManager;
/*  78 */         this.atlasName = param2String;
/*     */       }
/*     */ 
/*     */       
/*     */       public TextureAtlas getAtlas() {
/*  83 */         return (TextureAtlas)this.assetManager.get(this.atlasName, TextureAtlas.class);
/*     */       }
/*     */       
/*     */       public TextureRegion getImage(String param2String)
/*     */       {
/*  88 */         return (TextureRegion)getAtlas().findRegion(param2String); } } } public static class AssetManagerAtlasResolver implements AtlasResolver { private final AssetManager assetManager; private final String atlasName; public TextureRegion getImage(String param1String) { return (TextureRegion)getAtlas().findRegion(param1String); } public AssetManagerAtlasResolver(AssetManager param1AssetManager, String param1String) {
/*     */       this.assetManager = param1AssetManager;
/*     */       this.atlasName = param1String;
/*     */     } public TextureAtlas getAtlas() {
/*     */       return (TextureAtlas)this.assetManager.get(this.atlasName, TextureAtlas.class);
/*  93 */     } } protected Array<Texture> trackedTextures = new Array();
/*     */   
/*     */   protected AtlasResolver atlasResolver;
/*     */   
/*     */   public AtlasTmxMapLoader() {
/*  98 */     super((FileHandleResolver)new InternalFileHandleResolver());
/*     */   }
/*     */   
/*     */   public AtlasTmxMapLoader(FileHandleResolver paramFileHandleResolver) {
/* 102 */     super(paramFileHandleResolver);
/*     */   }
/*     */   
/*     */   public TiledMap load(String paramString) {
/* 106 */     return load(paramString, new AtlasTiledMapLoaderParameters());
/*     */   }
/*     */   
/*     */   public TiledMap load(String paramString, AtlasTiledMapLoaderParameters paramAtlasTiledMapLoaderParameters) {
/* 110 */     FileHandle fileHandle1 = resolve(paramString);
/*     */     
/* 112 */     this.root = this.xml.parse(fileHandle1);
/*     */     
/* 114 */     FileHandle fileHandle2 = getAtlasFileHandle(fileHandle1);
/* 115 */     TextureAtlas textureAtlas = new TextureAtlas(fileHandle2);
/* 116 */     this.atlasResolver = new AtlasResolver.DirectAtlasResolver(textureAtlas);
/*     */     
/*     */     TiledMap tiledMap;
/* 119 */     (tiledMap = loadTiledMap(fileHandle1, paramAtlasTiledMapLoaderParameters, this.atlasResolver)).setOwnedResources(new Array((Object[])new TextureAtlas[] { textureAtlas }));
/* 120 */     setTextureFilters(paramAtlasTiledMapLoaderParameters.textureMinFilter, paramAtlasTiledMapLoaderParameters.textureMagFilter);
/* 121 */     return tiledMap;
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, AtlasTiledMapLoaderParameters paramAtlasTiledMapLoaderParameters) {
/* 126 */     FileHandle fileHandle = getAtlasFileHandle(paramFileHandle);
/* 127 */     this.atlasResolver = new AtlasResolver.AssetManagerAtlasResolver(paramAssetManager, fileHandle.path());
/*     */     
/* 129 */     this.map = loadTiledMap(paramFileHandle, paramAtlasTiledMapLoaderParameters, this.atlasResolver);
/*     */   }
/*     */ 
/*     */   
/*     */   public TiledMap loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, AtlasTiledMapLoaderParameters paramAtlasTiledMapLoaderParameters) {
/* 134 */     if (paramAtlasTiledMapLoaderParameters != null) {
/* 135 */       setTextureFilters(paramAtlasTiledMapLoaderParameters.textureMinFilter, paramAtlasTiledMapLoaderParameters.textureMagFilter);
/*     */     }
/*     */     
/* 138 */     return this.map;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Array<AssetDescriptor> getDependencyAssetDescriptors(FileHandle paramFileHandle, TextureLoader.TextureParameter paramTextureParameter) {
/* 144 */     Array<AssetDescriptor> array = new Array();
/*     */ 
/*     */ 
/*     */     
/* 148 */     if ((paramFileHandle = getAtlasFileHandle(paramFileHandle)) != null) {
/* 149 */       array.add(new AssetDescriptor(paramFileHandle, TextureAtlas.class));
/*     */     }
/*     */     
/* 152 */     return array;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addStaticTiles(FileHandle paramFileHandle1, ImageResolver paramImageResolver, TiledMapTileSet paramTiledMapTileSet, XmlReader.Element paramElement, Array<XmlReader.Element> paramArray, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, int paramInt6, int paramInt7, String paramString3, int paramInt8, int paramInt9, FileHandle paramFileHandle2) {
/* 160 */     TextureAtlas textureAtlas = this.atlasResolver.getAtlas();
/* 161 */     String str = paramString1;
/*     */     
/* 163 */     for (ObjectSet.ObjectSetIterator<Texture> objectSetIterator = textureAtlas.getTextures().iterator(); objectSetIterator.hasNext(); ) { Texture texture = objectSetIterator.next();
/* 164 */       this.trackedTextures.add(texture); }
/*     */ 
/*     */     
/*     */     MapProperties mapProperties;
/* 168 */     (mapProperties = paramTiledMapTileSet.getProperties()).put("imagesource", paramString3);
/* 169 */     mapProperties.put("imagewidth", Integer.valueOf(paramInt8));
/* 170 */     mapProperties.put("imageheight", Integer.valueOf(paramInt9));
/* 171 */     mapProperties.put("tilewidth", Integer.valueOf(paramInt2));
/* 172 */     mapProperties.put("tileheight", Integer.valueOf(paramInt3));
/* 173 */     mapProperties.put("margin", Integer.valueOf(paramInt5));
/* 174 */     mapProperties.put("spacing", Integer.valueOf(paramInt4));
/*     */     
/* 176 */     if (paramString3 != null && paramString3.length() > 0) {
/* 177 */       int i = paramInt1 + paramInt8 / paramInt2 * paramInt9 / paramInt3 - 1;
/* 178 */       for (Array.ArrayIterator<TextureAtlas.AtlasRegion> arrayIterator1 = textureAtlas.findRegions(str).iterator(); arrayIterator1.hasNext();) {
/*     */         
/* 180 */         if ((atlasRegion = arrayIterator1.next()) != null && (
/*     */           
/* 182 */           paramInt2 = paramInt1 + atlasRegion.index) >= paramInt1 && paramInt2 <= i) {
/* 183 */           addStaticTiledMapTile(paramTiledMapTileSet, (TextureRegion)atlasRegion, paramInt2, paramInt6, paramInt7);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 190 */     for (Array.ArrayIterator<XmlReader.Element> arrayIterator = paramArray.iterator(); arrayIterator.hasNext(); ) { XmlReader.Element element = arrayIterator.next();
/* 191 */       int i = paramInt1 + element.getIntAttribute("id", 0);
/*     */       TiledMapTile tiledMapTile;
/* 193 */       if ((tiledMapTile = paramTiledMapTileSet.getTile(i)) == null && (
/*     */         
/* 195 */         element = element.getChildByName("image")) != null) {
/*     */         
/* 197 */         String str1 = (str1 = element.getAttribute("source")).substring(0, str1.lastIndexOf('.'));
/*     */         TextureAtlas.AtlasRegion atlasRegion;
/* 199 */         if ((atlasRegion = textureAtlas.findRegion(str1)) == null) throw new GdxRuntimeException("Tileset atlasRegion not found: " + str1); 
/* 200 */         addStaticTiledMapTile(paramTiledMapTileSet, (TextureRegion)atlasRegion, i, paramInt6, paramInt7);
/*     */       }  }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   protected FileHandle getAtlasFileHandle(FileHandle paramFileHandle) {
/* 207 */     XmlReader.Element element = this.root.getChildByName("properties");
/*     */     
/* 209 */     String str = null;
/* 210 */     if (element != null) {
/* 211 */       for (Array.ArrayIterator<XmlReader.Element> arrayIterator = element.getChildrenByName("property").iterator(); arrayIterator.hasNext();) {
/*     */         
/* 213 */         if ((str1 = (element1 = arrayIterator.next()).getAttribute("name")).startsWith("atlas")) {
/* 214 */           str = element1.getAttribute("value");
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/* 219 */     if (str == null) {
/* 220 */       throw new GdxRuntimeException("The map is missing the 'atlas' property");
/*     */     }
/*     */     FileHandle fileHandle;
/* 223 */     if (!(fileHandle = getRelativeFileHandle(paramFileHandle, str)).exists()) {
/* 224 */       throw new GdxRuntimeException("The 'atlas' file could not be found: '" + str + "'");
/*     */     }
/* 226 */     return fileHandle;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setTextureFilters(Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2) {
/* 231 */     for (Array.ArrayIterator<Texture> arrayIterator = this.trackedTextures.iterator(); arrayIterator.hasNext();) {
/* 232 */       (texture = arrayIterator.next()).setFilter(paramTextureFilter1, paramTextureFilter2);
/*     */     }
/* 234 */     this.trackedTextures.clear();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\tiled\AtlasTmxMapLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */