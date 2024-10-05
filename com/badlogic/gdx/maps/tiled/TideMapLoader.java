/*     */ package com.badlogic.gdx.maps.tiled;
/*     */ 
/*     */ import com.badlogic.gdx.assets.AssetDescriptor;
/*     */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*     */ import com.badlogic.gdx.assets.AssetManager;
/*     */ import com.badlogic.gdx.assets.loaders.FileHandleResolver;
/*     */ import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
/*     */ import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.maps.ImageResolver;
/*     */ import com.badlogic.gdx.maps.MapProperties;
/*     */ import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
/*     */ import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.XmlReader;
/*     */ import java.io.IOException;
/*     */ import java.util.StringTokenizer;
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
/*     */ public class TideMapLoader
/*     */   extends SynchronousAssetLoader<TiledMap, TideMapLoader.Parameters>
/*     */ {
/*     */   public static class Parameters
/*     */     extends AssetLoaderParameters<TiledMap> {}
/*     */   
/*  50 */   private XmlReader xml = new XmlReader();
/*     */   private XmlReader.Element root;
/*     */   
/*     */   public TideMapLoader() {
/*  54 */     super((FileHandleResolver)new InternalFileHandleResolver());
/*     */   }
/*     */   
/*     */   public TideMapLoader(FileHandleResolver paramFileHandleResolver) {
/*  58 */     super(paramFileHandleResolver);
/*     */   }
/*     */   
/*     */   public TiledMap load(String paramString) {
/*     */     try {
/*  63 */       FileHandle fileHandle = resolve(paramString);
/*  64 */       this.root = this.xml.parse(fileHandle);
/*  65 */       ObjectMap objectMap = new ObjectMap();
/*  66 */       for (Array.ArrayIterator<FileHandle> arrayIterator = loadTileSheets(this.root, fileHandle).iterator(); arrayIterator.hasNext(); ) { FileHandle fileHandle1 = arrayIterator.next();
/*  67 */         objectMap.put(fileHandle1.path(), new Texture(fileHandle1)); }
/*     */       
/*  69 */       ImageResolver.DirectImageResolver directImageResolver = new ImageResolver.DirectImageResolver(objectMap);
/*     */       TiledMap tiledMap;
/*  71 */       (tiledMap = loadMap(this.root, fileHandle, (ImageResolver)directImageResolver)).setOwnedResources(objectMap.values().toArray());
/*  72 */       return tiledMap;
/*  73 */     } catch (IOException iOException) {
/*  74 */       throw new GdxRuntimeException("Couldn't load tilemap '" + paramString + "'", iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TiledMap load(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, Parameters paramParameters) {
/*     */     try {
/*  82 */       return loadMap(this.root, paramFileHandle, (ImageResolver)new ImageResolver.AssetManagerImageResolver(paramAssetManager));
/*  83 */     } catch (Exception exception) {
/*  84 */       throw new GdxRuntimeException("Couldn't load tilemap '" + paramString + "'", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Array<AssetDescriptor> getDependencies(String paramString, FileHandle paramFileHandle, Parameters paramParameters) {
/*  90 */     Array<AssetDescriptor> array = new Array();
/*     */     try {
/*  92 */       this.root = this.xml.parse(paramFileHandle);
/*  93 */       for (Array.ArrayIterator<FileHandle> arrayIterator = loadTileSheets(this.root, paramFileHandle).iterator(); arrayIterator.hasNext(); ) { FileHandle fileHandle = arrayIterator.next();
/*  94 */         array.add(new AssetDescriptor(fileHandle.path(), Texture.class)); }
/*     */       
/*  96 */       return array;
/*  97 */     } catch (IOException iOException) {
/*  98 */       throw new GdxRuntimeException("Couldn't load tilemap '" + paramString + "'", iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TiledMap loadMap(XmlReader.Element paramElement, FileHandle paramFileHandle, ImageResolver paramImageResolver) {
/* 108 */     TiledMap tiledMap = new TiledMap();
/*     */     XmlReader.Element element2;
/* 110 */     if ((element2 = paramElement.getChildByName("Properties")) != null) {
/* 111 */       loadProperties(tiledMap.getProperties(), element2);
/*     */     }
/*     */     
/* 114 */     for (Array.ArrayIterator<XmlReader.Element> arrayIterator1 = (element2 = paramElement.getChildByName("TileSheets")).getChildrenByName("TileSheet").iterator(); arrayIterator1.hasNext(); ) { XmlReader.Element element = arrayIterator1.next();
/* 115 */       loadTileSheet(tiledMap, element, paramFileHandle, paramImageResolver); }
/*     */     
/*     */     XmlReader.Element element1;
/* 118 */     for (Array.ArrayIterator<XmlReader.Element> arrayIterator2 = (element1 = paramElement.getChildByName("Layers")).getChildrenByName("Layer").iterator(); arrayIterator2.hasNext(); ) { paramElement = arrayIterator2.next();
/* 119 */       loadLayer(tiledMap, paramElement); }
/*     */     
/* 121 */     return tiledMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Array<FileHandle> loadTileSheets(XmlReader.Element paramElement, FileHandle paramFileHandle) {
/* 129 */     Array<FileHandle> array = new Array();
/*     */     
/* 131 */     for (Array.ArrayIterator<XmlReader.Element> arrayIterator = (paramElement = paramElement.getChildByName("TileSheets")).getChildrenByName("TileSheet").iterator(); arrayIterator.hasNext(); ) {
/* 132 */       XmlReader.Element element = (element = arrayIterator.next()).getChildByName("ImageSource");
/* 133 */       FileHandle fileHandle = getRelativeFileHandle(paramFileHandle, element.getText());
/* 134 */       array.add(fileHandle);
/*     */     } 
/* 136 */     return array;
/*     */   }
/*     */   
/*     */   private void loadTileSheet(TiledMap paramTiledMap, XmlReader.Element paramElement, FileHandle paramFileHandle, ImageResolver paramImageResolver) {
/* 140 */     if (paramElement.getName().equals("TileSheet")) {
/* 141 */       String str1 = paramElement.getAttribute("Id");
/* 142 */       paramElement.getChildByName("Description").getText();
/* 143 */       String str2 = paramElement.getChildByName("ImageSource").getText();
/*     */       
/*     */       XmlReader.Element element1;
/* 146 */       String str3 = (element1 = paramElement.getChildByName("Alignment")).getAttribute("SheetSize");
/* 147 */       String str4 = element1.getAttribute("TileSize");
/* 148 */       String str5 = element1.getAttribute("Margin");
/* 149 */       element1.getAttribute("Spacing");
/*     */       
/*     */       String[] arrayOfString1;
/* 152 */       Integer.parseInt((arrayOfString1 = str3.split(" x "))[0]);
/* 153 */       Integer.parseInt(arrayOfString1[1]);
/*     */ 
/*     */       
/* 156 */       int m = Integer.parseInt((arrayOfString1 = str4.split(" x "))[0]);
/* 157 */       int k = Integer.parseInt(arrayOfString1[1]);
/*     */       
/*     */       String[] arrayOfString2;
/* 160 */       int i2 = Integer.parseInt((arrayOfString2 = str5.split(" x "))[0]);
/* 161 */       int n = Integer.parseInt(arrayOfString2[1]);
/*     */       
/*     */       String[] arrayOfString3;
/* 164 */       int i3 = Integer.parseInt((arrayOfString3 = str5.split(" x "))[0]);
/* 165 */       int i1 = Integer.parseInt(arrayOfString3[1]);
/*     */       
/* 167 */       paramFileHandle = getRelativeFileHandle(paramFileHandle, str2);
/* 168 */       TextureRegion textureRegion = paramImageResolver.getImage(paramFileHandle.path());
/*     */       
/* 170 */       TiledMapTileSets tiledMapTileSets = paramTiledMap.getTileSets();
/* 171 */       int i = 1;
/* 172 */       for (TiledMapTileSet tiledMapTileSet1 : tiledMapTileSets) {
/* 173 */         i += tiledMapTileSet1.size();
/*     */       }
/*     */       
/*     */       TiledMapTileSet tiledMapTileSet;
/* 177 */       (tiledMapTileSet = new TiledMapTileSet()).setName(str1);
/* 178 */       tiledMapTileSet.getProperties().put("firstgid", Integer.valueOf(i));
/* 179 */       int i4 = i;
/*     */       
/* 181 */       i = textureRegion.getRegionWidth() - m;
/* 182 */       int j = textureRegion.getRegionHeight() - k;
/*     */       
/* 184 */       for (n = n; n <= j; n += k + i1) {
/* 185 */         int i5; for (i5 = i2; i5 <= i; i5 += m + i3) {
/*     */           StaticTiledMapTile staticTiledMapTile;
/* 187 */           (staticTiledMapTile = new StaticTiledMapTile(new TextureRegion(textureRegion, i5, n, m, k))).setId(i4);
/* 188 */           tiledMapTileSet.putTile(i4++, (TiledMapTile)staticTiledMapTile);
/*     */         } 
/*     */       } 
/*     */       
/*     */       XmlReader.Element element2;
/* 193 */       if ((element2 = paramElement.getChildByName("Properties")) != null) {
/* 194 */         loadProperties(tiledMapTileSet.getProperties(), element2);
/*     */       }
/*     */       
/* 197 */       tiledMapTileSets.addTileSet(tiledMapTileSet);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void loadLayer(TiledMap paramTiledMap, XmlReader.Element paramElement) {
/* 202 */     if (paramElement.getName().equals("Layer")) {
/* 203 */       String str1 = paramElement.getAttribute("Id");
/* 204 */       String str2 = paramElement.getAttribute("Visible");
/*     */       
/*     */       XmlReader.Element element2;
/* 207 */       String str4 = (element2 = paramElement.getChildByName("Dimensions")).getAttribute("LayerSize");
/* 208 */       String str3 = element2.getAttribute("TileSize");
/*     */       
/*     */       String[] arrayOfString2;
/* 211 */       int k = Integer.parseInt((arrayOfString2 = str4.split(" x "))[0]);
/* 212 */       int j = Integer.parseInt(arrayOfString2[1]);
/*     */       
/*     */       String[] arrayOfString1;
/* 215 */       int m = Integer.parseInt((arrayOfString1 = str3.split(" x "))[0]);
/* 216 */       int i = Integer.parseInt(arrayOfString1[1]);
/*     */       
/*     */       TiledMapTileLayer tiledMapTileLayer;
/* 219 */       (tiledMapTileLayer = new TiledMapTileLayer(k, j, m, i)).setName(str1);
/* 220 */       tiledMapTileLayer.setVisible(str2.equalsIgnoreCase("True"));
/*     */       XmlReader.Element element1;
/* 222 */       Array array = (element1 = paramElement.getChildByName("TileArray")).getChildrenByName("Row");
/* 223 */       TiledMapTileSets tiledMapTileSets = paramTiledMap.getTileSets();
/* 224 */       TiledMapTileSet tiledMapTileSet = null;
/* 225 */       k = 0; byte b;
/*     */       int n;
/* 227 */       for (b = 0, n = array.size; b < n; b++) {
/* 228 */         XmlReader.Element element = (XmlReader.Element)array.get(b);
/* 229 */         int i1 = n - 1 - b;
/* 230 */         m = 0; byte b1; int i2;
/* 231 */         for (b1 = 0, i2 = element.getChildCount(); b1 < i2; b1++) {
/*     */           XmlReader.Element element4;
/*     */           String str;
/* 234 */           if ((str = (element4 = element.getChild(b1)).getName()).equals("TileSheet"))
/*     */           
/* 236 */           { k = ((Integer)(tiledMapTileSet = tiledMapTileSets.getTileSet(element4.getAttribute("Ref"))).getProperties().get("firstgid", Integer.class)).intValue(); }
/* 237 */           else if (str.equals("Null"))
/* 238 */           { m += element4.getIntAttribute("Count"); }
/* 239 */           else { TiledMapTileLayer.Cell cell; if (str.equals("Static")) {
/*     */               
/* 241 */               (cell = new TiledMapTileLayer.Cell()).setTile(tiledMapTileSet.getTile(k + element4.getIntAttribute("Index")));
/* 242 */               tiledMapTileLayer.setCell(m++, i1, cell);
/* 243 */             } else if (cell.equals("Animated")) {
/*     */               
/* 245 */               int i3 = element4.getInt("Interval");
/* 246 */               element4 = element4.getChildByName("Frames");
/* 247 */               Array array1 = new Array(); byte b2; int i4;
/* 248 */               for (b2 = 0, i4 = element4.getChildCount(); b2 < i4; b2++) {
/*     */                 XmlReader.Element element5;
/*     */                 String str5;
/* 251 */                 if ((str5 = (element5 = element4.getChild(b2)).getName()).equals("TileSheet")) {
/*     */                   
/* 253 */                   k = ((Integer)(tiledMapTileSet = tiledMapTileSets.getTileSet(element5.getAttribute("Ref"))).getProperties().get("firstgid", Integer.class)).intValue();
/* 254 */                 } else if (str5.equals("Static")) {
/* 255 */                   array1.add(tiledMapTileSet.getTile(k + element5.getIntAttribute("Index")));
/*     */                 } 
/*     */               } 
/*     */               TiledMapTileLayer.Cell cell1;
/* 259 */               (cell1 = new TiledMapTileLayer.Cell()).setTile((TiledMapTile)new AnimatedTiledMapTile(i3 / 1000.0F, array1));
/* 260 */               tiledMapTileLayer.setCell(m++, i1, cell1);
/*     */             }  }
/*     */         
/*     */         } 
/*     */       } 
/*     */       XmlReader.Element element3;
/* 266 */       if ((element3 = paramElement.getChildByName("Properties")) != null) {
/* 267 */         loadProperties(tiledMapTileLayer.getProperties(), element3);
/*     */       }
/*     */       
/* 270 */       paramTiledMap.getLayers().add(tiledMapTileLayer);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void loadProperties(MapProperties paramMapProperties, XmlReader.Element paramElement) {
/* 275 */     if (paramElement.getName().equals("Properties")) {
/* 276 */       for (Array.ArrayIterator<XmlReader.Element> arrayIterator = paramElement.getChildrenByName("Property").iterator(); arrayIterator.hasNext(); ) {
/* 277 */         XmlReader.Element element; String str2 = (element = arrayIterator.next()).getAttribute("Key", null);
/* 278 */         String str3 = element.getAttribute("Type", null);
/* 279 */         String str1 = element.getText();
/*     */         
/* 281 */         if (str3.equals("Int32")) {
/* 282 */           paramMapProperties.put(str2, Integer.valueOf(Integer.parseInt(str1))); continue;
/* 283 */         }  if (!str3.equals("String"))
/*     */         {
/* 285 */           if (str3.equals("Boolean")) {
/* 286 */             paramMapProperties.put(str2, Boolean.valueOf(str1.equalsIgnoreCase("true"))); continue;
/*     */           }  } 
/* 288 */         paramMapProperties.put(str2, str1);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static FileHandle getRelativeFileHandle(FileHandle paramFileHandle, String paramString) {
/* 295 */     StringTokenizer stringTokenizer = new StringTokenizer(paramString, "\\/");
/* 296 */     paramFileHandle = paramFileHandle.parent();
/* 297 */     while (stringTokenizer.hasMoreElements()) {
/*     */       String str;
/* 299 */       if ((str = stringTokenizer.nextToken()).equals("..")) {
/* 300 */         paramFileHandle = paramFileHandle.parent(); continue;
/*     */       } 
/* 302 */       paramFileHandle = paramFileHandle.child(str);
/*     */     } 
/*     */     
/* 305 */     return paramFileHandle;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\tiled\TideMapLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */