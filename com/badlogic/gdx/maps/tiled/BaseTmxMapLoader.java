/*     */ package com.badlogic.gdx.maps.tiled;
/*     */ import com.badlogic.gdx.assets.AssetDescriptor;
/*     */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*     */ import com.badlogic.gdx.assets.loaders.FileHandleResolver;
/*     */ import com.badlogic.gdx.assets.loaders.TextureLoader;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.maps.ImageResolver;
/*     */ import com.badlogic.gdx.maps.MapGroupLayer;
/*     */ import com.badlogic.gdx.maps.MapLayer;
/*     */ import com.badlogic.gdx.maps.MapLayers;
/*     */ import com.badlogic.gdx.maps.MapObject;
/*     */ import com.badlogic.gdx.maps.MapProperties;
/*     */ import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
/*     */ import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Base64Coder;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.IntMap;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.SerializationException;
/*     */ import com.badlogic.gdx.utils.StreamUtils;
/*     */ import com.badlogic.gdx.utils.XmlReader;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.zip.InflaterInputStream;
/*     */ 
/*     */ public abstract class BaseTmxMapLoader<P extends BaseTmxMapLoader.Parameters> extends AsynchronousAssetLoader<TiledMap, P> {
/*     */   protected static final int FLAG_FLIP_HORIZONTALLY = -2147483648;
/*     */   protected static final int FLAG_FLIP_VERTICALLY = 1073741824;
/*     */   protected static final int FLAG_FLIP_DIAGONALLY = 536870912;
/*     */   protected static final int MASK_CLEAR = -536870912;
/*     */   
/*     */   public static class Parameters extends AssetLoaderParameters<TiledMap> {
/*  41 */     public Texture.TextureFilter textureMinFilter = Texture.TextureFilter.Nearest;
/*     */     public boolean generateMipMaps = false;
/*  43 */     public Texture.TextureFilter textureMagFilter = Texture.TextureFilter.Nearest;
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean convertObjectToTileSpace = false;
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean flipY = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  56 */   protected XmlReader xml = new XmlReader();
/*     */   
/*     */   protected XmlReader.Element root;
/*     */   
/*     */   protected boolean convertObjectToTileSpace;
/*     */   protected boolean flipY = true;
/*     */   protected int mapTileWidth;
/*     */   protected int mapTileHeight;
/*     */   protected int mapWidthInPixels;
/*     */   protected int mapHeightInPixels;
/*     */   protected TiledMap map;
/*     */   protected IntMap<MapObject> idToObject;
/*     */   protected Array<Runnable> runOnEndOfLoadTiled;
/*     */   
/*     */   public BaseTmxMapLoader(FileHandleResolver paramFileHandleResolver) {
/*  71 */     super(paramFileHandleResolver);
/*     */   }
/*     */ 
/*     */   
/*     */   public Array<AssetDescriptor> getDependencies(String paramString, FileHandle paramFileHandle, P paramP) {
/*  76 */     this.root = this.xml.parse(paramFileHandle);
/*     */     
/*  78 */     TextureLoader.TextureParameter textureParameter = new TextureLoader.TextureParameter();
/*  79 */     if (paramP != null) {
/*  80 */       textureParameter.genMipMaps = ((Parameters)paramP).generateMipMaps;
/*  81 */       textureParameter.minFilter = ((Parameters)paramP).textureMinFilter;
/*  82 */       textureParameter.magFilter = ((Parameters)paramP).textureMagFilter;
/*     */     } 
/*     */     
/*  85 */     return getDependencyAssetDescriptors(paramFileHandle, textureParameter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public IntMap<MapObject> getIdToObject() {
/*  94 */     return this.idToObject;
/*     */   }
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
/*     */   protected TiledMap loadTiledMap(FileHandle paramFileHandle, P paramP, ImageResolver paramImageResolver) {
/* 107 */     this.map = new TiledMap();
/* 108 */     this.idToObject = new IntMap();
/* 109 */     this.runOnEndOfLoadTiled = new Array();
/*     */     
/* 111 */     if (paramP != null) {
/* 112 */       this.convertObjectToTileSpace = ((Parameters)paramP).convertObjectToTileSpace;
/* 113 */       this.flipY = ((Parameters)paramP).flipY;
/*     */     } else {
/* 115 */       this.convertObjectToTileSpace = false;
/* 116 */       this.flipY = true;
/*     */     } 
/*     */     
/* 119 */     String str1 = this.root.getAttribute("orientation", null);
/* 120 */     int i = this.root.getIntAttribute("width", 0);
/* 121 */     int j = this.root.getIntAttribute("height", 0);
/* 122 */     int k = this.root.getIntAttribute("tilewidth", 0);
/* 123 */     int m = this.root.getIntAttribute("tileheight", 0);
/* 124 */     int n = this.root.getIntAttribute("hexsidelength", 0);
/* 125 */     String str2 = this.root.getAttribute("staggeraxis", null);
/* 126 */     String str3 = this.root.getAttribute("staggerindex", null);
/* 127 */     String str4 = this.root.getAttribute("backgroundcolor", null);
/*     */     
/* 129 */     MapProperties mapProperties = this.map.getProperties();
/* 130 */     if (str1 != null) {
/* 131 */       mapProperties.put("orientation", str1);
/*     */     }
/* 133 */     mapProperties.put("width", Integer.valueOf(i));
/* 134 */     mapProperties.put("height", Integer.valueOf(j));
/* 135 */     mapProperties.put("tilewidth", Integer.valueOf(k));
/* 136 */     mapProperties.put("tileheight", Integer.valueOf(m));
/* 137 */     mapProperties.put("hexsidelength", Integer.valueOf(n));
/* 138 */     if (str2 != null) {
/* 139 */       mapProperties.put("staggeraxis", str2);
/*     */     }
/* 141 */     if (str3 != null) {
/* 142 */       mapProperties.put("staggerindex", str3);
/*     */     }
/* 144 */     if (str4 != null) {
/* 145 */       mapProperties.put("backgroundcolor", str4);
/*     */     }
/* 147 */     this.mapTileWidth = k;
/* 148 */     this.mapTileHeight = m;
/* 149 */     this.mapWidthInPixels = i * k;
/* 150 */     this.mapHeightInPixels = j * m;
/*     */     
/* 152 */     if (str1 != null && 
/* 153 */       "staggered".equals(str1) && 
/* 154 */       j > 1) {
/* 155 */       this.mapWidthInPixels += k / 2;
/* 156 */       this.mapHeightInPixels = this.mapHeightInPixels / 2 + m / 2;
/*     */     } 
/*     */ 
/*     */     
/*     */     XmlReader.Element element;
/*     */     
/* 162 */     if ((element = this.root.getChildByName("properties")) != null) {
/* 163 */       loadProperties(this.map.getProperties(), element);
/*     */     }
/*     */     
/*     */     Array array2;
/* 167 */     for (Array.ArrayIterator<XmlReader.Element> arrayIterator = (array2 = this.root.getChildrenByName("tileset")).iterator(); arrayIterator.hasNext(); ) { XmlReader.Element element1 = arrayIterator.next();
/* 168 */       loadTileSet(element1, paramFileHandle, paramImageResolver);
/* 169 */       this.root.removeChild(element1); }
/*     */ 
/*     */     
/* 172 */     for (byte b = 0; b < i; b++) {
/* 173 */       XmlReader.Element element1 = this.root.getChild(b);
/* 174 */       loadLayer(this.map, this.map.getLayers(), element1, paramFileHandle, paramImageResolver);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 180 */     Array array1 = this.map.getLayers().getByType(MapGroupLayer.class);
/* 181 */     while (array1.notEmpty()) {
/* 182 */       MapGroupLayer mapGroupLayer = (MapGroupLayer)array1.first();
/* 183 */       array1.removeIndex(0);
/*     */       
/* 185 */       for (Iterator<MapLayer> iterator = mapGroupLayer.getLayers().iterator(); iterator.hasNext(); ) {
/* 186 */         MapLayer mapLayer; (mapLayer = iterator.next()).setParallaxX(mapLayer.getParallaxX() * mapGroupLayer.getParallaxX());
/* 187 */         mapLayer.setParallaxY(mapLayer.getParallaxY() * mapGroupLayer.getParallaxY());
/* 188 */         if (mapLayer instanceof MapGroupLayer)
/*     */         {
/* 190 */           array1.add(mapLayer);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 195 */     for (Array.ArrayIterator<Runnable> arrayIterator1 = this.runOnEndOfLoadTiled.iterator(); arrayIterator1.hasNext();) {
/* 196 */       (runnable = arrayIterator1.next()).run();
/*     */     }
/* 198 */     this.runOnEndOfLoadTiled = null;
/*     */     
/* 200 */     return this.map;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadLayer(TiledMap paramTiledMap, MapLayers paramMapLayers, XmlReader.Element paramElement, FileHandle paramFileHandle, ImageResolver paramImageResolver) {
/*     */     String str;
/* 206 */     if ((str = paramElement.getName()).equals("group")) {
/* 207 */       loadLayerGroup(paramTiledMap, paramMapLayers, paramElement, paramFileHandle, paramImageResolver); return;
/* 208 */     }  if (str.equals("layer")) {
/* 209 */       loadTileLayer(paramTiledMap, paramMapLayers, paramElement); return;
/* 210 */     }  if (str.equals("objectgroup")) {
/* 211 */       loadObjectGroup(paramTiledMap, paramMapLayers, paramElement); return;
/* 212 */     }  if (str.equals("imagelayer")) {
/* 213 */       loadImageLayer(paramTiledMap, paramMapLayers, paramElement, paramFileHandle, paramImageResolver);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadLayerGroup(TiledMap paramTiledMap, MapLayers paramMapLayers, XmlReader.Element paramElement, FileHandle paramFileHandle, ImageResolver paramImageResolver) {
/* 219 */     if (paramElement.getName().equals("group")) {
/* 220 */       MapGroupLayer mapGroupLayer = new MapGroupLayer();
/* 221 */       loadBasicLayerInfo((MapLayer)mapGroupLayer, paramElement);
/*     */       
/*     */       XmlReader.Element element;
/* 224 */       if ((element = paramElement.getChildByName("properties")) != null)
/* 225 */         loadProperties(mapGroupLayer.getProperties(), element); 
/*     */       byte b;
/*     */       int i;
/* 228 */       for (b = 0, i = paramElement.getChildCount(); b < i; b++) {
/* 229 */         XmlReader.Element element1 = paramElement.getChild(b);
/* 230 */         loadLayer(paramTiledMap, mapGroupLayer.getLayers(), element1, paramFileHandle, paramImageResolver);
/*     */       } 
/*     */       
/* 233 */       for (Iterator<MapLayer> iterator = mapGroupLayer.getLayers().iterator(); iterator.hasNext();) {
/* 234 */         (mapLayer = iterator.next()).setParent((MapLayer)mapGroupLayer);
/*     */       }
/*     */       
/* 237 */       paramMapLayers.add((MapLayer)mapGroupLayer);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void loadTileLayer(TiledMap paramTiledMap, MapLayers paramMapLayers, XmlReader.Element paramElement) {
/* 242 */     if (paramElement.getName().equals("layer")) {
/* 243 */       int i = paramElement.getIntAttribute("width", 0);
/* 244 */       int j = paramElement.getIntAttribute("height", 0);
/* 245 */       int k = ((Integer)paramTiledMap.getProperties().get("tilewidth", Integer.class)).intValue();
/* 246 */       int m = ((Integer)paramTiledMap.getProperties().get("tileheight", Integer.class)).intValue();
/* 247 */       TiledMapTileLayer tiledMapTileLayer = new TiledMapTileLayer(i, j, k, m);
/*     */       
/* 249 */       loadBasicLayerInfo(tiledMapTileLayer, paramElement);
/*     */       
/* 251 */       int[] arrayOfInt = getTileIds(paramElement, i, j);
/* 252 */       TiledMapTileSets tiledMapTileSets = paramTiledMap.getTileSets();
/* 253 */       for (byte b = 0; b < j; b++) {
/* 254 */         for (byte b1 = 0; b1 < i; b1++) {
/*     */           int n;
/* 256 */           boolean bool1 = (((n = arrayOfInt[b * i + b1]) & Integer.MIN_VALUE) != 0) ? true : false;
/* 257 */           boolean bool2 = ((n & 0x40000000) != 0) ? true : false;
/* 258 */           boolean bool3 = ((n & 0x20000000) != 0) ? true : false;
/*     */           
/*     */           TiledMapTile tiledMapTile;
/* 261 */           if ((tiledMapTile = tiledMapTileSets.getTile(n & 0x1FFFFFFF)) != null) {
/*     */             TiledMapTileLayer.Cell cell;
/* 263 */             (cell = createTileLayerCell(bool1, bool2, bool3)).setTile(tiledMapTile);
/* 264 */             tiledMapTileLayer.setCell(b1, this.flipY ? (j - 1 - b) : b, cell);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/*     */       XmlReader.Element element;
/* 270 */       if ((element = paramElement.getChildByName("properties")) != null) {
/* 271 */         loadProperties(tiledMapTileLayer.getProperties(), element);
/*     */       }
/* 273 */       paramMapLayers.add(tiledMapTileLayer);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void loadObjectGroup(TiledMap paramTiledMap, MapLayers paramMapLayers, XmlReader.Element paramElement) {
/* 278 */     if (paramElement.getName().equals("objectgroup")) {
/* 279 */       MapLayer mapLayer = new MapLayer();
/* 280 */       loadBasicLayerInfo(mapLayer, paramElement);
/*     */       XmlReader.Element element;
/* 282 */       if ((element = paramElement.getChildByName("properties")) != null) {
/* 283 */         loadProperties(mapLayer.getProperties(), element);
/*     */       }
/*     */       
/* 286 */       for (Array.ArrayIterator<XmlReader.Element> arrayIterator = paramElement.getChildrenByName("object").iterator(); arrayIterator.hasNext(); ) { element = arrayIterator.next();
/* 287 */         loadObject(paramTiledMap, mapLayer, element); }
/*     */ 
/*     */       
/* 290 */       paramMapLayers.add(mapLayer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadImageLayer(TiledMap paramTiledMap, MapLayers paramMapLayers, XmlReader.Element paramElement, FileHandle paramFileHandle, ImageResolver paramImageResolver) {
/* 296 */     if (paramElement.getName().equals("imagelayer")) {
/*     */       float f1, f2;
/*     */       TextureRegion textureRegion;
/* 299 */       if (paramElement.hasAttribute("offsetx")) {
/* 300 */         f1 = Float.parseFloat(paramElement.getAttribute("offsetx", "0"));
/*     */       } else {
/* 302 */         f1 = Float.parseFloat(paramElement.getAttribute("x", "0"));
/*     */       } 
/* 304 */       if (paramElement.hasAttribute("offsety")) {
/* 305 */         f2 = Float.parseFloat(paramElement.getAttribute("offsety", "0"));
/*     */       } else {
/* 307 */         f2 = Float.parseFloat(paramElement.getAttribute("y", "0"));
/*     */       } 
/* 309 */       if (this.flipY) f2 = this.mapHeightInPixels - f2;
/*     */       
/* 311 */       String str = null;
/*     */       
/*     */       XmlReader.Element element2;
/*     */       
/* 315 */       if ((element2 = paramElement.getChildByName("image")) != null) {
/* 316 */         str = element2.getAttribute("source");
/* 317 */         paramFileHandle = getRelativeFileHandle(paramFileHandle, str);
/* 318 */         textureRegion = paramImageResolver.getImage(paramFileHandle.path());
/* 319 */         f2 -= textureRegion.getRegionHeight();
/*     */       } 
/*     */       
/* 322 */       TiledMapImageLayer tiledMapImageLayer = new TiledMapImageLayer(textureRegion, f1, f2);
/*     */       
/* 324 */       loadBasicLayerInfo(tiledMapImageLayer, paramElement);
/*     */       
/*     */       XmlReader.Element element1;
/* 327 */       if ((element1 = paramElement.getChildByName("properties")) != null) {
/* 328 */         loadProperties(tiledMapImageLayer.getProperties(), element1);
/*     */       }
/*     */       
/* 331 */       paramMapLayers.add(tiledMapImageLayer);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void loadBasicLayerInfo(MapLayer paramMapLayer, XmlReader.Element paramElement) {
/* 336 */     String str = paramElement.getAttribute("name", null);
/* 337 */     float f2 = Float.parseFloat(paramElement.getAttribute("opacity", "1.0"));
/* 338 */     boolean bool = (paramElement.getIntAttribute("visible", 1) == 1) ? true : false;
/* 339 */     float f3 = paramElement.getFloatAttribute("offsetx", 0.0F);
/* 340 */     float f4 = paramElement.getFloatAttribute("offsety", 0.0F);
/* 341 */     float f5 = paramElement.getFloatAttribute("parallaxx", 1.0F);
/* 342 */     float f1 = paramElement.getFloatAttribute("parallaxy", 1.0F);
/*     */     
/* 344 */     paramMapLayer.setName(str);
/* 345 */     paramMapLayer.setOpacity(f2);
/* 346 */     paramMapLayer.setVisible(bool);
/* 347 */     paramMapLayer.setOffsetX(f3);
/* 348 */     paramMapLayer.setOffsetY(f4);
/* 349 */     paramMapLayer.setParallaxX(f5);
/* 350 */     paramMapLayer.setParallaxY(f1);
/*     */   }
/*     */   
/*     */   protected void loadObject(TiledMap paramTiledMap, MapLayer paramMapLayer, XmlReader.Element paramElement) {
/* 354 */     loadObject(paramTiledMap, paramMapLayer.getObjects(), paramElement, this.mapHeightInPixels);
/*     */   }
/*     */   
/*     */   protected void loadObject(TiledMap paramTiledMap, TiledMapTile paramTiledMapTile, XmlReader.Element paramElement) {
/* 358 */     loadObject(paramTiledMap, paramTiledMapTile.getObjects(), paramElement, paramTiledMapTile.getTextureRegion().getRegionHeight());
/*     */   }
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
/*     */   protected void loadObject(TiledMap paramTiledMap, MapObjects paramMapObjects, XmlReader.Element paramElement, float paramFloat) {
/*     */     // Byte code:
/*     */     //   0: aload_3
/*     */     //   1: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   4: ldc 'object'
/*     */     //   6: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   9: ifeq -> 953
/*     */     //   12: aconst_null
/*     */     //   13: astore #5
/*     */     //   15: aload_0
/*     */     //   16: getfield convertObjectToTileSpace : Z
/*     */     //   19: ifeq -> 32
/*     */     //   22: fconst_1
/*     */     //   23: aload_0
/*     */     //   24: getfield mapTileWidth : I
/*     */     //   27: i2f
/*     */     //   28: fdiv
/*     */     //   29: goto -> 33
/*     */     //   32: fconst_1
/*     */     //   33: fstore #6
/*     */     //   35: aload_0
/*     */     //   36: getfield convertObjectToTileSpace : Z
/*     */     //   39: ifeq -> 52
/*     */     //   42: fconst_1
/*     */     //   43: aload_0
/*     */     //   44: getfield mapTileHeight : I
/*     */     //   47: i2f
/*     */     //   48: fdiv
/*     */     //   49: goto -> 53
/*     */     //   52: fconst_1
/*     */     //   53: fstore #7
/*     */     //   55: aload_3
/*     */     //   56: ldc 'x'
/*     */     //   58: fconst_0
/*     */     //   59: invokevirtual getFloatAttribute : (Ljava/lang/String;F)F
/*     */     //   62: fload #6
/*     */     //   64: fmul
/*     */     //   65: fstore #8
/*     */     //   67: aload_0
/*     */     //   68: getfield flipY : Z
/*     */     //   71: ifeq -> 87
/*     */     //   74: fload #4
/*     */     //   76: aload_3
/*     */     //   77: ldc 'y'
/*     */     //   79: fconst_0
/*     */     //   80: invokevirtual getFloatAttribute : (Ljava/lang/String;F)F
/*     */     //   83: fsub
/*     */     //   84: goto -> 94
/*     */     //   87: aload_3
/*     */     //   88: ldc 'y'
/*     */     //   90: fconst_0
/*     */     //   91: invokevirtual getFloatAttribute : (Ljava/lang/String;F)F
/*     */     //   94: fload #7
/*     */     //   96: fmul
/*     */     //   97: fstore #4
/*     */     //   99: aload_3
/*     */     //   100: ldc 'width'
/*     */     //   102: fconst_0
/*     */     //   103: invokevirtual getFloatAttribute : (Ljava/lang/String;F)F
/*     */     //   106: fload #6
/*     */     //   108: fmul
/*     */     //   109: fstore #9
/*     */     //   111: aload_3
/*     */     //   112: ldc 'height'
/*     */     //   114: fconst_0
/*     */     //   115: invokevirtual getFloatAttribute : (Ljava/lang/String;F)F
/*     */     //   118: fload #7
/*     */     //   120: fmul
/*     */     //   121: fstore #10
/*     */     //   123: aload_3
/*     */     //   124: invokevirtual getChildCount : ()I
/*     */     //   127: ifle -> 463
/*     */     //   130: aload_3
/*     */     //   131: ldc 'polygon'
/*     */     //   133: invokevirtual getChildByName : (Ljava/lang/String;)Lcom/badlogic/gdx/utils/XmlReader$Element;
/*     */     //   136: dup
/*     */     //   137: astore #11
/*     */     //   139: ifnull -> 276
/*     */     //   142: aload #11
/*     */     //   144: ldc 'points'
/*     */     //   146: invokevirtual getAttribute : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   149: ldc ' '
/*     */     //   151: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*     */     //   154: dup
/*     */     //   155: astore #11
/*     */     //   157: arraylength
/*     */     //   158: iconst_1
/*     */     //   159: ishl
/*     */     //   160: newarray float
/*     */     //   162: astore #12
/*     */     //   164: iconst_0
/*     */     //   165: istore #13
/*     */     //   167: iload #13
/*     */     //   169: aload #11
/*     */     //   171: arraylength
/*     */     //   172: if_icmpge -> 243
/*     */     //   175: aload #11
/*     */     //   177: iload #13
/*     */     //   179: aaload
/*     */     //   180: ldc ','
/*     */     //   182: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*     */     //   185: astore #5
/*     */     //   187: aload #12
/*     */     //   189: iload #13
/*     */     //   191: iconst_1
/*     */     //   192: ishl
/*     */     //   193: aload #5
/*     */     //   195: iconst_0
/*     */     //   196: aaload
/*     */     //   197: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   200: fload #6
/*     */     //   202: fmul
/*     */     //   203: fastore
/*     */     //   204: aload #12
/*     */     //   206: iload #13
/*     */     //   208: iconst_1
/*     */     //   209: ishl
/*     */     //   210: iconst_1
/*     */     //   211: iadd
/*     */     //   212: aload #5
/*     */     //   214: iconst_1
/*     */     //   215: aaload
/*     */     //   216: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   219: fload #7
/*     */     //   221: fmul
/*     */     //   222: aload_0
/*     */     //   223: getfield flipY : Z
/*     */     //   226: ifeq -> 233
/*     */     //   229: iconst_m1
/*     */     //   230: goto -> 234
/*     */     //   233: iconst_1
/*     */     //   234: i2f
/*     */     //   235: fmul
/*     */     //   236: fastore
/*     */     //   237: iinc #13, 1
/*     */     //   240: goto -> 167
/*     */     //   243: new com/badlogic/gdx/math/Polygon
/*     */     //   246: dup
/*     */     //   247: aload #12
/*     */     //   249: invokespecial <init> : ([F)V
/*     */     //   252: dup
/*     */     //   253: astore #13
/*     */     //   255: fload #8
/*     */     //   257: fload #4
/*     */     //   259: invokevirtual setPosition : (FF)V
/*     */     //   262: new com/badlogic/gdx/maps/objects/PolygonMapObject
/*     */     //   265: dup
/*     */     //   266: aload #13
/*     */     //   268: invokespecial <init> : (Lcom/badlogic/gdx/math/Polygon;)V
/*     */     //   271: astore #5
/*     */     //   273: goto -> 463
/*     */     //   276: aload_3
/*     */     //   277: ldc 'polyline'
/*     */     //   279: invokevirtual getChildByName : (Ljava/lang/String;)Lcom/badlogic/gdx/utils/XmlReader$Element;
/*     */     //   282: dup
/*     */     //   283: astore #11
/*     */     //   285: ifnull -> 422
/*     */     //   288: aload #11
/*     */     //   290: ldc 'points'
/*     */     //   292: invokevirtual getAttribute : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   295: ldc ' '
/*     */     //   297: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*     */     //   300: dup
/*     */     //   301: astore #11
/*     */     //   303: arraylength
/*     */     //   304: iconst_1
/*     */     //   305: ishl
/*     */     //   306: newarray float
/*     */     //   308: astore #12
/*     */     //   310: iconst_0
/*     */     //   311: istore #13
/*     */     //   313: iload #13
/*     */     //   315: aload #11
/*     */     //   317: arraylength
/*     */     //   318: if_icmpge -> 389
/*     */     //   321: aload #11
/*     */     //   323: iload #13
/*     */     //   325: aaload
/*     */     //   326: ldc ','
/*     */     //   328: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*     */     //   331: astore #5
/*     */     //   333: aload #12
/*     */     //   335: iload #13
/*     */     //   337: iconst_1
/*     */     //   338: ishl
/*     */     //   339: aload #5
/*     */     //   341: iconst_0
/*     */     //   342: aaload
/*     */     //   343: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   346: fload #6
/*     */     //   348: fmul
/*     */     //   349: fastore
/*     */     //   350: aload #12
/*     */     //   352: iload #13
/*     */     //   354: iconst_1
/*     */     //   355: ishl
/*     */     //   356: iconst_1
/*     */     //   357: iadd
/*     */     //   358: aload #5
/*     */     //   360: iconst_1
/*     */     //   361: aaload
/*     */     //   362: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   365: fload #7
/*     */     //   367: fmul
/*     */     //   368: aload_0
/*     */     //   369: getfield flipY : Z
/*     */     //   372: ifeq -> 379
/*     */     //   375: iconst_m1
/*     */     //   376: goto -> 380
/*     */     //   379: iconst_1
/*     */     //   380: i2f
/*     */     //   381: fmul
/*     */     //   382: fastore
/*     */     //   383: iinc #13, 1
/*     */     //   386: goto -> 313
/*     */     //   389: new com/badlogic/gdx/math/Polyline
/*     */     //   392: dup
/*     */     //   393: aload #12
/*     */     //   395: invokespecial <init> : ([F)V
/*     */     //   398: dup
/*     */     //   399: astore #13
/*     */     //   401: fload #8
/*     */     //   403: fload #4
/*     */     //   405: invokevirtual setPosition : (FF)V
/*     */     //   408: new com/badlogic/gdx/maps/objects/PolylineMapObject
/*     */     //   411: dup
/*     */     //   412: aload #13
/*     */     //   414: invokespecial <init> : (Lcom/badlogic/gdx/math/Polyline;)V
/*     */     //   417: astore #5
/*     */     //   419: goto -> 463
/*     */     //   422: aload_3
/*     */     //   423: ldc 'ellipse'
/*     */     //   425: invokevirtual getChildByName : (Ljava/lang/String;)Lcom/badlogic/gdx/utils/XmlReader$Element;
/*     */     //   428: ifnull -> 463
/*     */     //   431: new com/badlogic/gdx/maps/objects/EllipseMapObject
/*     */     //   434: dup
/*     */     //   435: fload #8
/*     */     //   437: aload_0
/*     */     //   438: getfield flipY : Z
/*     */     //   441: ifeq -> 452
/*     */     //   444: fload #4
/*     */     //   446: fload #10
/*     */     //   448: fsub
/*     */     //   449: goto -> 454
/*     */     //   452: fload #4
/*     */     //   454: fload #9
/*     */     //   456: fload #10
/*     */     //   458: invokespecial <init> : (FFFF)V
/*     */     //   461: astore #5
/*     */     //   463: aload #5
/*     */     //   465: ifnonnull -> 702
/*     */     //   468: aload_3
/*     */     //   469: ldc 'gid'
/*     */     //   471: aconst_null
/*     */     //   472: invokevirtual getAttribute : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   475: dup
/*     */     //   476: astore #11
/*     */     //   478: ifnull -> 670
/*     */     //   481: aload #11
/*     */     //   483: invokestatic parseLong : (Ljava/lang/String;)J
/*     */     //   486: l2i
/*     */     //   487: dup
/*     */     //   488: istore #11
/*     */     //   490: ldc -2147483648
/*     */     //   492: iand
/*     */     //   493: ifeq -> 500
/*     */     //   496: iconst_1
/*     */     //   497: goto -> 501
/*     */     //   500: iconst_0
/*     */     //   501: istore #12
/*     */     //   503: iload #11
/*     */     //   505: ldc 1073741824
/*     */     //   507: iand
/*     */     //   508: ifeq -> 515
/*     */     //   511: iconst_1
/*     */     //   512: goto -> 516
/*     */     //   515: iconst_0
/*     */     //   516: istore #13
/*     */     //   518: aload_1
/*     */     //   519: invokevirtual getTileSets : ()Lcom/badlogic/gdx/maps/tiled/TiledMapTileSets;
/*     */     //   522: iload #11
/*     */     //   524: ldc 536870911
/*     */     //   526: iand
/*     */     //   527: invokevirtual getTile : (I)Lcom/badlogic/gdx/maps/tiled/TiledMapTile;
/*     */     //   530: astore #5
/*     */     //   532: new com/badlogic/gdx/maps/tiled/objects/TiledMapTileMapObject
/*     */     //   535: dup
/*     */     //   536: aload #5
/*     */     //   538: iload #12
/*     */     //   540: iload #13
/*     */     //   542: invokespecial <init> : (Lcom/badlogic/gdx/maps/tiled/TiledMapTile;ZZ)V
/*     */     //   545: dup
/*     */     //   546: astore_1
/*     */     //   547: invokevirtual getTextureRegion : ()Lcom/badlogic/gdx/graphics/g2d/TextureRegion;
/*     */     //   550: astore #5
/*     */     //   552: aload_1
/*     */     //   553: invokevirtual getProperties : ()Lcom/badlogic/gdx/maps/MapProperties;
/*     */     //   556: ldc 'gid'
/*     */     //   558: iload #11
/*     */     //   560: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   563: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)V
/*     */     //   566: aload_1
/*     */     //   567: fload #8
/*     */     //   569: invokevirtual setX : (F)V
/*     */     //   572: aload_1
/*     */     //   573: aload_0
/*     */     //   574: getfield flipY : Z
/*     */     //   577: ifeq -> 585
/*     */     //   580: fload #4
/*     */     //   582: goto -> 590
/*     */     //   585: fload #4
/*     */     //   587: fload #10
/*     */     //   589: fsub
/*     */     //   590: invokevirtual setY : (F)V
/*     */     //   593: aload_3
/*     */     //   594: ldc 'width'
/*     */     //   596: aload #5
/*     */     //   598: invokevirtual getRegionWidth : ()I
/*     */     //   601: i2f
/*     */     //   602: invokevirtual getFloatAttribute : (Ljava/lang/String;F)F
/*     */     //   605: fstore #11
/*     */     //   607: aload_3
/*     */     //   608: ldc 'height'
/*     */     //   610: aload #5
/*     */     //   612: invokevirtual getRegionHeight : ()I
/*     */     //   615: i2f
/*     */     //   616: invokevirtual getFloatAttribute : (Ljava/lang/String;F)F
/*     */     //   619: fstore #12
/*     */     //   621: aload_1
/*     */     //   622: fload #6
/*     */     //   624: fload #11
/*     */     //   626: aload #5
/*     */     //   628: invokevirtual getRegionWidth : ()I
/*     */     //   631: i2f
/*     */     //   632: fdiv
/*     */     //   633: fmul
/*     */     //   634: invokevirtual setScaleX : (F)V
/*     */     //   637: aload_1
/*     */     //   638: fload #7
/*     */     //   640: fload #12
/*     */     //   642: aload #5
/*     */     //   644: invokevirtual getRegionHeight : ()I
/*     */     //   647: i2f
/*     */     //   648: fdiv
/*     */     //   649: fmul
/*     */     //   650: invokevirtual setScaleY : (F)V
/*     */     //   653: aload_1
/*     */     //   654: aload_3
/*     */     //   655: ldc 'rotation'
/*     */     //   657: fconst_0
/*     */     //   658: invokevirtual getFloatAttribute : (Ljava/lang/String;F)F
/*     */     //   661: invokevirtual setRotation : (F)V
/*     */     //   664: aload_1
/*     */     //   665: astore #5
/*     */     //   667: goto -> 702
/*     */     //   670: new com/badlogic/gdx/maps/objects/RectangleMapObject
/*     */     //   673: dup
/*     */     //   674: fload #8
/*     */     //   676: aload_0
/*     */     //   677: getfield flipY : Z
/*     */     //   680: ifeq -> 691
/*     */     //   683: fload #4
/*     */     //   685: fload #10
/*     */     //   687: fsub
/*     */     //   688: goto -> 693
/*     */     //   691: fload #4
/*     */     //   693: fload #9
/*     */     //   695: fload #10
/*     */     //   697: invokespecial <init> : (FFFF)V
/*     */     //   700: astore #5
/*     */     //   702: aload #5
/*     */     //   704: aload_3
/*     */     //   705: ldc 'name'
/*     */     //   707: aconst_null
/*     */     //   708: invokevirtual getAttribute : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   711: invokevirtual setName : (Ljava/lang/String;)V
/*     */     //   714: aload_3
/*     */     //   715: ldc 'rotation'
/*     */     //   717: aconst_null
/*     */     //   718: invokevirtual getAttribute : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   721: dup
/*     */     //   722: astore #11
/*     */     //   724: ifnull -> 745
/*     */     //   727: aload #5
/*     */     //   729: invokevirtual getProperties : ()Lcom/badlogic/gdx/maps/MapProperties;
/*     */     //   732: ldc 'rotation'
/*     */     //   734: aload #11
/*     */     //   736: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   739: invokestatic valueOf : (F)Ljava/lang/Float;
/*     */     //   742: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)V
/*     */     //   745: aload_3
/*     */     //   746: ldc 'type'
/*     */     //   748: aconst_null
/*     */     //   749: invokevirtual getAttribute : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   752: dup
/*     */     //   753: astore #11
/*     */     //   755: ifnull -> 770
/*     */     //   758: aload #5
/*     */     //   760: invokevirtual getProperties : ()Lcom/badlogic/gdx/maps/MapProperties;
/*     */     //   763: ldc 'type'
/*     */     //   765: aload #11
/*     */     //   767: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)V
/*     */     //   770: aload_3
/*     */     //   771: ldc 'id'
/*     */     //   773: iconst_0
/*     */     //   774: invokevirtual getIntAttribute : (Ljava/lang/String;I)I
/*     */     //   777: dup
/*     */     //   778: istore #12
/*     */     //   780: ifeq -> 798
/*     */     //   783: aload #5
/*     */     //   785: invokevirtual getProperties : ()Lcom/badlogic/gdx/maps/MapProperties;
/*     */     //   788: ldc 'id'
/*     */     //   790: iload #12
/*     */     //   792: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   795: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)V
/*     */     //   798: aload #5
/*     */     //   800: invokevirtual getProperties : ()Lcom/badlogic/gdx/maps/MapProperties;
/*     */     //   803: ldc 'x'
/*     */     //   805: fload #8
/*     */     //   807: invokestatic valueOf : (F)Ljava/lang/Float;
/*     */     //   810: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)V
/*     */     //   813: aload #5
/*     */     //   815: instanceof com/badlogic/gdx/maps/tiled/objects/TiledMapTileMapObject
/*     */     //   818: ifeq -> 831
/*     */     //   821: aload #5
/*     */     //   823: invokevirtual getProperties : ()Lcom/badlogic/gdx/maps/MapProperties;
/*     */     //   826: ldc 'y'
/*     */     //   828: goto -> 853
/*     */     //   831: aload #5
/*     */     //   833: invokevirtual getProperties : ()Lcom/badlogic/gdx/maps/MapProperties;
/*     */     //   836: ldc 'y'
/*     */     //   838: aload_0
/*     */     //   839: getfield flipY : Z
/*     */     //   842: ifeq -> 853
/*     */     //   845: fload #4
/*     */     //   847: fload #10
/*     */     //   849: fsub
/*     */     //   850: goto -> 855
/*     */     //   853: fload #4
/*     */     //   855: invokestatic valueOf : (F)Ljava/lang/Float;
/*     */     //   858: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)V
/*     */     //   861: aload #5
/*     */     //   863: invokevirtual getProperties : ()Lcom/badlogic/gdx/maps/MapProperties;
/*     */     //   866: ldc 'width'
/*     */     //   868: fload #9
/*     */     //   870: invokestatic valueOf : (F)Ljava/lang/Float;
/*     */     //   873: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)V
/*     */     //   876: aload #5
/*     */     //   878: invokevirtual getProperties : ()Lcom/badlogic/gdx/maps/MapProperties;
/*     */     //   881: ldc 'height'
/*     */     //   883: fload #10
/*     */     //   885: invokestatic valueOf : (F)Ljava/lang/Float;
/*     */     //   888: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)V
/*     */     //   891: aload #5
/*     */     //   893: aload_3
/*     */     //   894: ldc 'visible'
/*     */     //   896: iconst_1
/*     */     //   897: invokevirtual getIntAttribute : (Ljava/lang/String;I)I
/*     */     //   900: iconst_1
/*     */     //   901: if_icmpne -> 908
/*     */     //   904: iconst_1
/*     */     //   905: goto -> 909
/*     */     //   908: iconst_0
/*     */     //   909: invokevirtual setVisible : (Z)V
/*     */     //   912: aload_3
/*     */     //   913: ldc 'properties'
/*     */     //   915: invokevirtual getChildByName : (Ljava/lang/String;)Lcom/badlogic/gdx/utils/XmlReader$Element;
/*     */     //   918: dup
/*     */     //   919: astore #13
/*     */     //   921: ifnull -> 935
/*     */     //   924: aload_0
/*     */     //   925: aload #5
/*     */     //   927: invokevirtual getProperties : ()Lcom/badlogic/gdx/maps/MapProperties;
/*     */     //   930: aload #13
/*     */     //   932: invokevirtual loadProperties : (Lcom/badlogic/gdx/maps/MapProperties;Lcom/badlogic/gdx/utils/XmlReader$Element;)V
/*     */     //   935: aload_0
/*     */     //   936: getfield idToObject : Lcom/badlogic/gdx/utils/IntMap;
/*     */     //   939: iload #12
/*     */     //   941: aload #5
/*     */     //   943: invokevirtual put : (ILjava/lang/Object;)Ljava/lang/Object;
/*     */     //   946: pop
/*     */     //   947: aload_2
/*     */     //   948: aload #5
/*     */     //   950: invokevirtual add : (Lcom/badlogic/gdx/maps/MapObject;)V
/*     */     //   953: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #362	-> 0
/*     */     //   #363	-> 12
/*     */     //   #365	-> 15
/*     */     //   #366	-> 35
/*     */     //   #368	-> 55
/*     */     //   #369	-> 67
/*     */     //   #371	-> 99
/*     */     //   #372	-> 111
/*     */     //   #374	-> 123
/*     */     //   #376	-> 130
/*     */     //   #377	-> 142
/*     */     //   #378	-> 155
/*     */     //   #379	-> 164
/*     */     //   #380	-> 175
/*     */     //   #381	-> 187
/*     */     //   #382	-> 204
/*     */     //   #379	-> 237
/*     */     //   #384	-> 243
/*     */     //   #385	-> 253
/*     */     //   #386	-> 262
/*     */     //   #387	-> 273
/*     */     //   #388	-> 288
/*     */     //   #389	-> 301
/*     */     //   #390	-> 310
/*     */     //   #391	-> 321
/*     */     //   #392	-> 333
/*     */     //   #393	-> 350
/*     */     //   #390	-> 383
/*     */     //   #395	-> 389
/*     */     //   #396	-> 399
/*     */     //   #397	-> 408
/*     */     //   #398	-> 419
/*     */     //   #399	-> 431
/*     */     //   #402	-> 463
/*     */     //   #404	-> 468
/*     */     //   #405	-> 481
/*     */     //   #406	-> 488
/*     */     //   #407	-> 503
/*     */     //   #409	-> 518
/*     */     //   #410	-> 532
/*     */     //   #411	-> 546
/*     */     //   #412	-> 552
/*     */     //   #413	-> 566
/*     */     //   #414	-> 572
/*     */     //   #415	-> 593
/*     */     //   #416	-> 607
/*     */     //   #417	-> 621
/*     */     //   #418	-> 637
/*     */     //   #419	-> 653
/*     */     //   #420	-> 664
/*     */     //   #421	-> 667
/*     */     //   #422	-> 670
/*     */     //   #425	-> 702
/*     */     //   #426	-> 714
/*     */     //   #427	-> 722
/*     */     //   #428	-> 727
/*     */     //   #430	-> 745
/*     */     //   #431	-> 753
/*     */     //   #432	-> 758
/*     */     //   #434	-> 770
/*     */     //   #435	-> 778
/*     */     //   #436	-> 783
/*     */     //   #438	-> 798
/*     */     //   #440	-> 813
/*     */     //   #441	-> 821
/*     */     //   #443	-> 831
/*     */     //   #445	-> 861
/*     */     //   #446	-> 876
/*     */     //   #447	-> 891
/*     */     //   #448	-> 912
/*     */     //   #449	-> 919
/*     */     //   #450	-> 924
/*     */     //   #452	-> 935
/*     */     //   #453	-> 947
/*     */     //   #455	-> 953
/*     */   }
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
/*     */   protected void loadProperties(final MapProperties properties, XmlReader.Element paramElement) {
/* 458 */     if (paramElement == null)
/* 459 */       return;  if (paramElement.getName().equals("properties")) {
/* 460 */       for (Array.ArrayIterator<XmlReader.Element> arrayIterator = paramElement.getChildrenByName("property").iterator(); arrayIterator.hasNext(); ) {
/* 461 */         XmlReader.Element element; final String name = (element = arrayIterator.next()).getAttribute("name", null);
/* 462 */         String str2 = element.getAttribute("value", null);
/* 463 */         String str3 = element.getAttribute("type", null);
/* 464 */         if (str2 == null) {
/* 465 */           str2 = element.getText();
/*     */         }
/* 467 */         if (str3 != null && str3.equals("object")) {
/*     */ 
/*     */           
/*     */           try {
/* 471 */             final int id = Integer.parseInt(str2);
/*     */             
/* 473 */             Runnable runnable = new Runnable()
/*     */               {
/*     */                 public void run() {
/* 476 */                   MapObject mapObject = (MapObject)BaseTmxMapLoader.this.idToObject.get(id);
/* 477 */                   properties.put(name, mapObject);
/*     */                 }
/*     */               };
/*     */             
/* 481 */             this.runOnEndOfLoadTiled.add(runnable);
/* 482 */           } catch (Exception exception) {
/* 483 */             throw new GdxRuntimeException("Error parsing property [\" + name + \"] of type \"object\" with value: [" + str2 + "]", exception);
/*     */           } 
/*     */           continue;
/*     */         } 
/* 487 */         Object object = castProperty(str1, str2, str3);
/* 488 */         properties.put(str1, object);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected Object castProperty(String paramString1, String paramString2, String paramString3) {
/* 495 */     if (paramString3 == null)
/* 496 */       return paramString2; 
/* 497 */     if (paramString3.equals("int"))
/* 498 */       return Integer.valueOf(paramString2); 
/* 499 */     if (paramString3.equals("float"))
/* 500 */       return Float.valueOf(paramString2); 
/* 501 */     if (paramString3.equals("bool"))
/* 502 */       return Boolean.valueOf(paramString2); 
/* 503 */     if (paramString3.equals("color")) {
/*     */       
/* 505 */       paramString1 = paramString2.substring(3);
/* 506 */       paramString2 = paramString2.substring(1, 3);
/* 507 */       return Color.valueOf(paramString1 + paramString2);
/*     */     } 
/* 509 */     throw new GdxRuntimeException("Wrong type given for property " + paramString1 + ", given : " + paramString3 + ", supported : string, bool, int, float, color");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected TiledMapTileLayer.Cell createTileLayerCell(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 515 */     TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
/* 516 */     if (paramBoolean3) {
/* 517 */       if (paramBoolean1 && paramBoolean2) {
/* 518 */         cell.setFlipHorizontally(true);
/* 519 */         cell.setRotation(3);
/* 520 */       } else if (paramBoolean1) {
/* 521 */         cell.setRotation(3);
/* 522 */       } else if (paramBoolean2) {
/* 523 */         cell.setRotation(1);
/*     */       } else {
/* 525 */         cell.setFlipVertically(true);
/* 526 */         cell.setRotation(3);
/*     */       } 
/*     */     } else {
/* 529 */       cell.setFlipHorizontally(paramBoolean1);
/* 530 */       cell.setFlipVertically(paramBoolean2);
/*     */     } 
/* 532 */     return cell;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int[] getTileIds(XmlReader.Element paramElement, int paramInt1, int paramInt2) {
/*     */     String arrayOfString[], str;
/* 538 */     if ((str = (paramElement = paramElement.getChildByName("data")).getAttribute("encoding", null)) == null) {
/* 539 */       throw new GdxRuntimeException("Unsupported encoding (XML) for TMX Layer Data");
/*     */     }
/* 541 */     int[] arrayOfInt = new int[paramInt1 * paramInt2];
/* 542 */     if (str.equals("csv")) {
/* 543 */       arrayOfString = paramElement.getText().split(",");
/* 544 */       for (byte b = 0; b < arrayOfString.length; b++)
/* 545 */         arrayOfInt[b] = (int)Long.parseLong(arrayOfString[b].trim()); 
/*     */     } else {
/* 547 */       BufferedInputStream bufferedInputStream; if (arrayOfString.equals("base64")) {
/* 548 */         arrayOfString = null;
/*     */         try {
/* 550 */           String str1 = paramElement.getAttribute("compression", null);
/* 551 */           byte[] arrayOfByte = Base64Coder.decode(paramElement.getText());
/* 552 */           if (str1 == null) {
/* 553 */             ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
/* 554 */           } else if (str1.equals("gzip")) {
/* 555 */             bufferedInputStream = new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(arrayOfByte), arrayOfByte.length));
/* 556 */           } else if (str1.equals("zlib")) {
/* 557 */             bufferedInputStream = new BufferedInputStream(new InflaterInputStream(new ByteArrayInputStream(arrayOfByte)));
/*     */           } else {
/* 559 */             throw new GdxRuntimeException("Unrecognised compression (" + str1 + ") for TMX Layer Data");
/*     */           } 
/* 561 */           arrayOfByte = new byte[4];
/* 562 */           for (byte b = 0; b < paramInt2; b++) {
/* 563 */             for (byte b1 = 0; b1 < paramInt1; b1++) {
/* 564 */               int i = bufferedInputStream.read(arrayOfByte); int j;
/* 565 */               while (i < 4 && (
/*     */                 
/* 567 */                 j = bufferedInputStream.read(arrayOfByte, i, 4 - i)) != -1) {
/* 568 */                 i += j;
/*     */               }
/* 570 */               if (i != 4)
/* 571 */                 throw new GdxRuntimeException("Error Reading TMX Layer Data: Premature end of tile data"); 
/* 572 */               arrayOfInt[b * paramInt1 + b1] = unsignedByteToInt(arrayOfByte[0]) | unsignedByteToInt(arrayOfByte[1]) << 8 | 
/* 573 */                 unsignedByteToInt(arrayOfByte[2]) << 16 | unsignedByteToInt(arrayOfByte[3]) << 24;
/*     */             } 
/*     */           } 
/* 576 */         } catch (IOException iOException) {
/* 577 */           throw new GdxRuntimeException("Error Reading TMX Layer Data - IOException: " + iOException.getMessage());
/*     */         } finally {
/* 579 */           StreamUtils.closeQuietly(bufferedInputStream);
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 584 */         throw new GdxRuntimeException("Unrecognised encoding (" + bufferedInputStream + ") for TMX Layer Data");
/*     */       } 
/*     */     } 
/* 587 */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   protected static int unsignedByteToInt(byte paramByte) {
/* 591 */     return paramByte & 0xFF;
/*     */   }
/*     */   
/*     */   protected static FileHandle getRelativeFileHandle(FileHandle paramFileHandle, String paramString) {
/* 595 */     StringTokenizer stringTokenizer = new StringTokenizer(paramString, "\\/");
/* 596 */     paramFileHandle = paramFileHandle.parent();
/* 597 */     while (stringTokenizer.hasMoreElements()) {
/*     */       String str;
/* 599 */       if ((str = stringTokenizer.nextToken()).equals("..")) {
/* 600 */         paramFileHandle = paramFileHandle.parent(); continue;
/*     */       } 
/* 602 */       paramFileHandle = paramFileHandle.child(str);
/*     */     } 
/*     */     
/* 605 */     return paramFileHandle;
/*     */   }
/*     */   
/*     */   protected void loadTileSet(XmlReader.Element paramElement, FileHandle paramFileHandle, ImageResolver paramImageResolver) {
/* 609 */     if (paramElement.getName().equals("tileset")) {
/* 610 */       int i = paramElement.getIntAttribute("firstgid", 1);
/* 611 */       String str1 = "";
/* 612 */       int j = 0;
/* 613 */       int k = 0;
/* 614 */       FileHandle fileHandle = null;
/*     */       
/*     */       String str2;
/* 617 */       if ((str2 = paramElement.getAttribute("source", null)) != null) {
/* 618 */         FileHandle fileHandle1 = getRelativeFileHandle(paramFileHandle, str2);
/*     */         
/*     */         try {
/*     */           XmlReader.Element element;
/* 622 */           if ((element = (paramElement = this.xml.parse(fileHandle1)).getChildByName("image")) != null) {
/* 623 */             str1 = element.getAttribute("source");
/* 624 */             j = element.getIntAttribute("width", 0);
/* 625 */             k = element.getIntAttribute("height", 0);
/* 626 */             fileHandle = getRelativeFileHandle(fileHandle1, str1);
/*     */           } 
/* 628 */         } catch (SerializationException serializationException) {
/* 629 */           throw new GdxRuntimeException("Error parsing external tileset.");
/*     */         } 
/*     */       } else {
/*     */         XmlReader.Element element;
/* 633 */         if ((element = paramElement.getChildByName("image")) != null) {
/* 634 */           str1 = element.getAttribute("source");
/* 635 */           j = element.getIntAttribute("width", 0);
/* 636 */           k = element.getIntAttribute("height", 0);
/* 637 */           fileHandle = getRelativeFileHandle(paramFileHandle, str1);
/*     */         } 
/*     */       } 
/* 640 */       String str3 = paramElement.get("name", null);
/* 641 */       int m = paramElement.getIntAttribute("tilewidth", 0);
/* 642 */       int n = paramElement.getIntAttribute("tileheight", 0);
/* 643 */       int i1 = paramElement.getIntAttribute("spacing", 0);
/* 644 */       int i2 = paramElement.getIntAttribute("margin", 0);
/*     */       
/* 646 */       XmlReader.Element element1 = paramElement.getChildByName("tileoffset");
/* 647 */       int i3 = 0;
/* 648 */       int i4 = 0;
/* 649 */       if (element1 != null) {
/* 650 */         i3 = element1.getIntAttribute("x", 0);
/* 651 */         i4 = element1.getIntAttribute("y", 0);
/*     */       } 
/*     */       
/*     */       TiledMapTileSet tiledMapTileSet;
/*     */       
/* 656 */       (tiledMapTileSet = new TiledMapTileSet()).setName(str3);
/* 657 */       MapProperties mapProperties = tiledMapTileSet.getProperties();
/*     */       XmlReader.Element element2;
/* 659 */       if ((element2 = paramElement.getChildByName("properties")) != null) {
/* 660 */         loadProperties(mapProperties, element2);
/*     */       }
/* 662 */       mapProperties.put("firstgid", Integer.valueOf(i));
/*     */ 
/*     */       
/* 665 */       Array<XmlReader.Element> array1 = paramElement.getChildrenByName("tile");
/*     */       
/* 667 */       addStaticTiles(paramFileHandle, paramImageResolver, tiledMapTileSet, paramElement, array1, str3, i, m, n, i1, i2, str2, i3, i4, str1, j, k, fileHandle);
/*     */ 
/*     */       
/* 670 */       Array array = new Array();
/*     */       Array.ArrayIterator<XmlReader.Element> arrayIterator;
/* 672 */       for (arrayIterator = array1.iterator(); arrayIterator.hasNext(); ) {
/* 673 */         XmlReader.Element element; int i5 = (element = arrayIterator.next()).getIntAttribute("id", 0);
/*     */         TiledMapTile tiledMapTile;
/* 675 */         if ((tiledMapTile = tiledMapTileSet.getTile(i + i5)) != null) {
/*     */           AnimatedTiledMapTile animatedTiledMapTile1, animatedTiledMapTile2;
/* 677 */           if ((animatedTiledMapTile2 = createAnimatedTile(tiledMapTileSet, tiledMapTile, element, i)) != null) {
/* 678 */             array.add(animatedTiledMapTile2);
/* 679 */             animatedTiledMapTile1 = animatedTiledMapTile2;
/*     */           } 
/* 681 */           addTileProperties((TiledMapTile)animatedTiledMapTile1, element);
/* 682 */           addTileObjectGroup((TiledMapTile)animatedTiledMapTile1, element);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 687 */       for (arrayIterator = array.iterator(); arrayIterator.hasNext(); ) { AnimatedTiledMapTile animatedTiledMapTile = (AnimatedTiledMapTile)arrayIterator.next();
/* 688 */         tiledMapTileSet.putTile(animatedTiledMapTile.getId(), (TiledMapTile)animatedTiledMapTile); }
/*     */ 
/*     */       
/* 691 */       this.map.getTileSets().addTileSet(tiledMapTileSet);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addTileProperties(TiledMapTile paramTiledMapTile, XmlReader.Element paramElement) {
/*     */     String str;
/* 701 */     if ((str = paramElement.getAttribute("terrain", null)) != null) {
/* 702 */       paramTiledMapTile.getProperties().put("terrain", str);
/*     */     }
/*     */     
/* 705 */     if ((str = paramElement.getAttribute("probability", null)) != null) {
/* 706 */       paramTiledMapTile.getProperties().put("probability", str);
/*     */     }
/*     */     
/* 709 */     if ((str = paramElement.getAttribute("type", null)) != null) {
/* 710 */       paramTiledMapTile.getProperties().put("type", str);
/*     */     }
/*     */     
/* 713 */     if ((paramElement = paramElement.getChildByName("properties")) != null) {
/* 714 */       loadProperties(paramTiledMapTile.getProperties(), paramElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addTileObjectGroup(TiledMapTile paramTiledMapTile, XmlReader.Element paramElement) {
/* 720 */     if ((paramElement = paramElement.getChildByName("objectgroup")) != null) {
/* 721 */       for (Array.ArrayIterator<XmlReader.Element> arrayIterator = paramElement.getChildrenByName("object").iterator(); arrayIterator.hasNext(); ) { XmlReader.Element element = arrayIterator.next();
/* 722 */         loadObject(this.map, paramTiledMapTile, element); }
/*     */     
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AnimatedTiledMapTile createAnimatedTile(TiledMapTileSet paramTiledMapTileSet, TiledMapTile paramTiledMapTile, XmlReader.Element paramElement, int paramInt) {
/* 730 */     if ((paramElement = paramElement.getChildByName("animation")) != null) {
/* 731 */       Array array = new Array();
/* 732 */       IntArray intArray = new IntArray();
/* 733 */       for (Array.ArrayIterator<XmlReader.Element> arrayIterator = paramElement.getChildrenByName("frame").iterator(); arrayIterator.hasNext(); ) { XmlReader.Element element = arrayIterator.next();
/* 734 */         array.add(paramTiledMapTileSet.getTile(paramInt + element.getIntAttribute("tileid")));
/* 735 */         intArray.add(element.getIntAttribute("duration")); }
/*     */ 
/*     */       
/*     */       AnimatedTiledMapTile animatedTiledMapTile;
/* 739 */       (animatedTiledMapTile = new AnimatedTiledMapTile(intArray, array)).setId(paramTiledMapTile.getId());
/* 740 */       return animatedTiledMapTile;
/*     */     } 
/* 742 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addStaticTiledMapTile(TiledMapTileSet paramTiledMapTileSet, TextureRegion paramTextureRegion, int paramInt, float paramFloat1, float paramFloat2) {
/*     */     StaticTiledMapTile staticTiledMapTile;
/* 748 */     (staticTiledMapTile = new StaticTiledMapTile(paramTextureRegion)).setId(paramInt);
/* 749 */     staticTiledMapTile.setOffsetX(paramFloat1);
/* 750 */     staticTiledMapTile.setOffsetY(this.flipY ? -paramFloat2 : paramFloat2);
/* 751 */     paramTiledMapTileSet.putTile(paramInt, (TiledMapTile)staticTiledMapTile);
/*     */   }
/*     */   
/*     */   protected abstract Array<AssetDescriptor> getDependencyAssetDescriptors(FileHandle paramFileHandle, TextureLoader.TextureParameter paramTextureParameter);
/*     */   
/*     */   protected abstract void addStaticTiles(FileHandle paramFileHandle1, ImageResolver paramImageResolver, TiledMapTileSet paramTiledMapTileSet, XmlReader.Element paramElement, Array<XmlReader.Element> paramArray, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, int paramInt6, int paramInt7, String paramString3, int paramInt8, int paramInt9, FileHandle paramFileHandle2);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\tiled\BaseTmxMapLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */