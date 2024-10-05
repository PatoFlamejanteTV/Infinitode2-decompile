/*     */ package com.badlogic.gdx.graphics.g2d;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.badlogic.gdx.utils.StreamUtils;
/*     */ import java.io.BufferedReader;
/*     */ import java.util.Comparator;
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
/*     */ public class TextureAtlas
/*     */   implements Disposable
/*     */ {
/*  44 */   private final ObjectSet<Texture> textures = new ObjectSet(4);
/*  45 */   private final Array<AtlasRegion> regions = new Array();
/*     */ 
/*     */ 
/*     */   
/*     */   public TextureAtlas() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public TextureAtlas(String paramString) {
/*  54 */     this(Gdx.files.internal(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public TextureAtlas(FileHandle paramFileHandle) {
/*  59 */     this(paramFileHandle, paramFileHandle.parent());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TextureAtlas(FileHandle paramFileHandle, boolean paramBoolean) {
/*  65 */     this(paramFileHandle, paramFileHandle.parent(), paramBoolean);
/*     */   }
/*     */   
/*     */   public TextureAtlas(FileHandle paramFileHandle1, FileHandle paramFileHandle2) {
/*  69 */     this(paramFileHandle1, paramFileHandle2, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public TextureAtlas(FileHandle paramFileHandle1, FileHandle paramFileHandle2, boolean paramBoolean) {
/*  74 */     this(new TextureAtlasData(paramFileHandle1, paramFileHandle2, paramBoolean));
/*     */   }
/*     */   
/*     */   public TextureAtlas(TextureAtlasData paramTextureAtlasData) {
/*  78 */     load(paramTextureAtlasData);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(TextureAtlasData paramTextureAtlasData) {
/*  83 */     this.textures.ensureCapacity(paramTextureAtlasData.pages.size); Array.ArrayIterator<TextureAtlasData.Page> arrayIterator;
/*  84 */     for (arrayIterator = paramTextureAtlasData.pages.iterator(); arrayIterator.hasNext(); ) {
/*  85 */       TextureAtlasData.Page page; if ((page = arrayIterator.next()).texture == null) page.texture = new Texture(page.textureFile, page.format, page.useMipMaps); 
/*  86 */       page.texture.setFilter(page.minFilter, page.magFilter);
/*  87 */       page.texture.setWrap(page.uWrap, page.vWrap);
/*  88 */       this.textures.add(page.texture);
/*     */     } 
/*     */     
/*  91 */     this.regions.ensureCapacity(paramTextureAtlasData.regions.size);
/*  92 */     for (arrayIterator = paramTextureAtlasData.regions.iterator(); arrayIterator.hasNext(); ) { TextureAtlasData.Region region = (TextureAtlasData.Region)arrayIterator.next();
/*     */       
/*     */       AtlasRegion atlasRegion;
/*     */       
/*  96 */       (atlasRegion = new AtlasRegion(region.page.texture, region.left, region.top, region.rotate ? region.height : region.width, region.rotate ? region.width : region.height)).index = region.index;
/*  97 */       atlasRegion.name = region.name;
/*  98 */       atlasRegion.offsetX = region.offsetX;
/*  99 */       atlasRegion.offsetY = region.offsetY;
/* 100 */       atlasRegion.originalHeight = region.originalHeight;
/* 101 */       atlasRegion.originalWidth = region.originalWidth;
/* 102 */       atlasRegion.rotate = region.rotate;
/* 103 */       atlasRegion.degrees = region.degrees;
/* 104 */       atlasRegion.names = region.names;
/* 105 */       atlasRegion.values = region.values;
/* 106 */       if (region.flip) atlasRegion.flip(false, true); 
/* 107 */       this.regions.add(atlasRegion); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public AtlasRegion addRegion(String paramString, Texture paramTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 113 */     this.textures.add(paramTexture);
/*     */     AtlasRegion atlasRegion;
/* 115 */     (atlasRegion = new AtlasRegion(paramTexture, paramInt1, paramInt2, paramInt3, paramInt4)).name = paramString;
/* 116 */     this.regions.add(atlasRegion);
/* 117 */     return atlasRegion;
/*     */   }
/*     */ 
/*     */   
/*     */   public AtlasRegion addRegion(String paramString, TextureRegion paramTextureRegion) {
/* 122 */     this.textures.add(paramTextureRegion.texture);
/*     */     
/* 124 */     ((AtlasRegion)(paramTextureRegion = new AtlasRegion(paramTextureRegion))).name = paramString;
/* 125 */     this.regions.add(paramTextureRegion);
/* 126 */     return (AtlasRegion)paramTextureRegion;
/*     */   }
/*     */ 
/*     */   
/*     */   public Array<AtlasRegion> getRegions() {
/* 131 */     return this.regions;
/*     */   }
/*     */   @Null
/*     */   public AtlasRegion findRegion(String paramString) {
/*     */     byte b;
/*     */     int i;
/* 137 */     for (b = 0, i = this.regions.size; b < i; b++) {
/* 138 */       if (((AtlasRegion)this.regions.get(b)).name.equals(paramString)) return (AtlasRegion)this.regions.get(b); 
/* 139 */     }  return null;
/*     */   }
/*     */   @Null
/*     */   public AtlasRegion findRegion(String paramString, int paramInt) {
/*     */     byte b;
/*     */     int i;
/* 145 */     for (b = 0, i = this.regions.size; b < i; b++) {
/*     */       AtlasRegion atlasRegion;
/* 147 */       if ((atlasRegion = (AtlasRegion)this.regions.get(b)).name.equals(paramString) && 
/* 148 */         atlasRegion.index == paramInt)
/* 149 */         return atlasRegion; 
/*     */     } 
/* 151 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Array<AtlasRegion> findRegions(String paramString) {
/* 158 */     Array<AtlasRegion> array = new Array(AtlasRegion.class); byte b; int i;
/* 159 */     for (b = 0, i = this.regions.size; b < i; b++) {
/*     */       AtlasRegion atlasRegion;
/* 161 */       if ((atlasRegion = (AtlasRegion)this.regions.get(b)).name.equals(paramString)) array.add(new AtlasRegion(atlasRegion)); 
/*     */     } 
/* 163 */     return array;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Array<Sprite> createSprites() {
/* 170 */     Array<Sprite> array = new Array(true, this.regions.size, Sprite.class); byte b; int i;
/* 171 */     for (b = 0, i = this.regions.size; b < i; b++)
/* 172 */       array.add(newSprite((AtlasRegion)this.regions.get(b))); 
/* 173 */     return array;
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public Sprite createSprite(String paramString) {
/*     */     byte b;
/*     */     int i;
/* 181 */     for (b = 0, i = this.regions.size; b < i; b++) {
/* 182 */       if (((AtlasRegion)this.regions.get(b)).name.equals(paramString)) return newSprite((AtlasRegion)this.regions.get(b)); 
/* 183 */     }  return null;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public Sprite createSprite(String paramString, int paramInt) {
/*     */     byte b;
/*     */     int i;
/* 190 */     for (b = 0, i = this.regions.size; b < i; b++) {
/*     */       AtlasRegion atlasRegion;
/* 192 */       if ((atlasRegion = (AtlasRegion)this.regions.get(b)).index == paramInt && 
/* 193 */         atlasRegion.name.equals(paramString))
/* 194 */         return newSprite((AtlasRegion)this.regions.get(b)); 
/*     */     } 
/* 196 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Array<Sprite> createSprites(String paramString) {
/* 204 */     Array<Sprite> array = new Array(Sprite.class); byte b; int i;
/* 205 */     for (b = 0, i = this.regions.size; b < i; b++) {
/*     */       AtlasRegion atlasRegion;
/* 207 */       if ((atlasRegion = (AtlasRegion)this.regions.get(b)).name.equals(paramString)) array.add(newSprite(atlasRegion)); 
/*     */     } 
/* 209 */     return array;
/*     */   }
/*     */   
/*     */   private Sprite newSprite(AtlasRegion paramAtlasRegion) {
/* 213 */     if (paramAtlasRegion.packedWidth == paramAtlasRegion.originalWidth && paramAtlasRegion.packedHeight == paramAtlasRegion.originalHeight) {
/* 214 */       if (paramAtlasRegion.rotate) {
/*     */         Sprite sprite;
/* 216 */         (sprite = new Sprite(paramAtlasRegion)).setBounds(0.0F, 0.0F, paramAtlasRegion.getRegionHeight(), paramAtlasRegion.getRegionWidth());
/* 217 */         sprite.rotate90(true);
/* 218 */         return sprite;
/*     */       } 
/* 220 */       return new Sprite(paramAtlasRegion);
/*     */     } 
/* 222 */     return new AtlasSprite(paramAtlasRegion);
/*     */   }
/*     */   
/*     */   @Null
/*     */   public NinePatch createPatch(String paramString) {
/*     */     byte b;
/*     */     int i;
/* 229 */     for (b = 0, i = this.regions.size; b < i; arrayOfInt++) {
/*     */       int[] arrayOfInt; AtlasRegion atlasRegion;
/* 231 */       if ((atlasRegion = (AtlasRegion)this.regions.get(b)).name.equals(paramString)) {
/*     */         
/* 233 */         if ((arrayOfInt = atlasRegion.findValue("split")) == null) throw new IllegalArgumentException("Region does not have ninepatch splits: " + paramString); 
/* 234 */         NinePatch ninePatch = new NinePatch(atlasRegion, arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
/*     */         
/* 236 */         if ((arrayOfInt = atlasRegion.findValue("pad")) != null) ninePatch.setPadding(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]); 
/* 237 */         return ninePatch;
/*     */       } 
/*     */     } 
/* 240 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ObjectSet<Texture> getTextures() {
/* 245 */     return this.textures;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 251 */     for (ObjectSet.ObjectSetIterator<Texture> objectSetIterator = this.textures.iterator(); objectSetIterator.hasNext();)
/* 252 */       (texture = objectSetIterator.next()).dispose(); 
/* 253 */     this.textures.clear(0);
/*     */   }
/*     */   
/*     */   public static class TextureAtlasData {
/* 257 */     final Array<Page> pages = new Array();
/* 258 */     final Array<Region> regions = new Array();
/*     */ 
/*     */     
/*     */     public TextureAtlasData() {}
/*     */     
/*     */     public TextureAtlasData(FileHandle param1FileHandle1, FileHandle param1FileHandle2, boolean param1Boolean) {
/* 264 */       load(param1FileHandle1, param1FileHandle2, param1Boolean);
/*     */     }
/*     */     
/*     */     public void load(FileHandle param1FileHandle1, FileHandle param1FileHandle2, boolean param1Boolean) {
/* 268 */       final String[] entry = new String[5];
/*     */       
/*     */       ObjectMap objectMap1;
/* 271 */       (objectMap1 = new ObjectMap(15, 0.99F)).put("size", new Field<Page>() {
/*     */             public void parse(TextureAtlas.TextureAtlasData.Page param2Page) {
/* 273 */               param2Page.width = Integer.parseInt(entry[1]);
/* 274 */               param2Page.height = Integer.parseInt(entry[2]);
/*     */             }
/*     */           });
/* 277 */       objectMap1.put("format", new Field<Page>() {
/*     */             public void parse(TextureAtlas.TextureAtlasData.Page param2Page) {
/* 279 */               param2Page.format = Pixmap.Format.valueOf(entry[1]);
/*     */             }
/*     */           });
/* 282 */       objectMap1.put("filter", new Field<Page>() {
/*     */             public void parse(TextureAtlas.TextureAtlasData.Page param2Page) {
/* 284 */               param2Page.minFilter = Texture.TextureFilter.valueOf(entry[1]);
/* 285 */               param2Page.magFilter = Texture.TextureFilter.valueOf(entry[2]);
/* 286 */               param2Page.useMipMaps = param2Page.minFilter.isMipMap();
/*     */             }
/*     */           });
/* 289 */       objectMap1.put("repeat", new Field<Page>() {
/*     */             public void parse(TextureAtlas.TextureAtlasData.Page param2Page) {
/* 291 */               if (entry[1].indexOf('x') != -1) param2Page.uWrap = Texture.TextureWrap.Repeat; 
/* 292 */               if (entry[1].indexOf('y') != -1) param2Page.vWrap = Texture.TextureWrap.Repeat; 
/*     */             }
/*     */           });
/* 295 */       objectMap1.put("pma", new Field<Page>() {
/*     */             public void parse(TextureAtlas.TextureAtlasData.Page param2Page) {
/* 297 */               param2Page.pma = entry[1].equals("true");
/*     */             }
/*     */           });
/*     */       
/* 301 */       final boolean[] hasIndexes = { false };
/*     */       ObjectMap objectMap2;
/* 303 */       (objectMap2 = new ObjectMap(127, 0.99F)).put("xy", new Field<Region>() {
/*     */             public void parse(TextureAtlas.TextureAtlasData.Region param2Region) {
/* 305 */               param2Region.left = Integer.parseInt(entry[1]);
/* 306 */               param2Region.top = Integer.parseInt(entry[2]);
/*     */             }
/*     */           });
/* 309 */       objectMap2.put("size", new Field<Region>() {
/*     */             public void parse(TextureAtlas.TextureAtlasData.Region param2Region) {
/* 311 */               param2Region.width = Integer.parseInt(entry[1]);
/* 312 */               param2Region.height = Integer.parseInt(entry[2]);
/*     */             }
/*     */           });
/* 315 */       objectMap2.put("bounds", new Field<Region>() {
/*     */             public void parse(TextureAtlas.TextureAtlasData.Region param2Region) {
/* 317 */               param2Region.left = Integer.parseInt(entry[1]);
/* 318 */               param2Region.top = Integer.parseInt(entry[2]);
/* 319 */               param2Region.width = Integer.parseInt(entry[3]);
/* 320 */               param2Region.height = Integer.parseInt(entry[4]);
/*     */             }
/*     */           });
/* 323 */       objectMap2.put("offset", new Field<Region>() {
/*     */             public void parse(TextureAtlas.TextureAtlasData.Region param2Region) {
/* 325 */               param2Region.offsetX = Integer.parseInt(entry[1]);
/* 326 */               param2Region.offsetY = Integer.parseInt(entry[2]);
/*     */             }
/*     */           });
/* 329 */       objectMap2.put("orig", new Field<Region>() {
/*     */             public void parse(TextureAtlas.TextureAtlasData.Region param2Region) {
/* 331 */               param2Region.originalWidth = Integer.parseInt(entry[1]);
/* 332 */               param2Region.originalHeight = Integer.parseInt(entry[2]);
/*     */             }
/*     */           });
/* 335 */       objectMap2.put("offsets", new Field<Region>() {
/*     */             public void parse(TextureAtlas.TextureAtlasData.Region param2Region) {
/* 337 */               param2Region.offsetX = Integer.parseInt(entry[1]);
/* 338 */               param2Region.offsetY = Integer.parseInt(entry[2]);
/* 339 */               param2Region.originalWidth = Integer.parseInt(entry[3]);
/* 340 */               param2Region.originalHeight = Integer.parseInt(entry[4]);
/*     */             }
/*     */           });
/* 343 */       objectMap2.put("rotate", new Field<Region>() {
/*     */             public void parse(TextureAtlas.TextureAtlasData.Region param2Region) {
/*     */               String str;
/* 346 */               if ((str = entry[1]).equals("true")) {
/* 347 */                 param2Region.degrees = 90;
/* 348 */               } else if (!str.equals("false")) {
/* 349 */                 param2Region.degrees = Integer.parseInt(str);
/* 350 */               }  param2Region.rotate = (param2Region.degrees == 90);
/*     */             }
/*     */           });
/* 353 */       objectMap2.put("index", new Field<Region>() {
/*     */             public void parse(TextureAtlas.TextureAtlasData.Region param2Region) {
/* 355 */               param2Region.index = Integer.parseInt(entry[1]);
/* 356 */               if (param2Region.index != -1) hasIndexes[0] = true;
/*     */             
/*     */             }
/*     */           });
/* 360 */       BufferedReader bufferedReader = param1FileHandle1.reader(1024);
/* 361 */       String str = null;
/*     */       try {
/* 363 */         str = bufferedReader.readLine();
/*     */         
/* 365 */         while (str != null && str.trim().length() == 0) {
/* 366 */           str = bufferedReader.readLine();
/*     */         }
/*     */         
/* 369 */         while (str != null && str.trim().length() != 0 && 
/* 370 */           readEntry(arrayOfString, str) != 0) {
/* 371 */           str = bufferedReader.readLine();
/*     */         }
/*     */         
/* 374 */         Page page = null;
/* 375 */         Array array1 = null, array2 = null;
/*     */         
/* 377 */         while (str != null) {
/* 378 */           if (str.trim().length() == 0) {
/* 379 */             page = null;
/* 380 */             str = bufferedReader.readLine(); continue;
/* 381 */           }  if (page == null) {
/*     */             
/* 383 */             (page = new Page()).name = str;
/* 384 */             page.textureFile = param1FileHandle2.child(str);
/*     */             
/* 386 */             while (readEntry(arrayOfString, str = bufferedReader.readLine()) != 0) {
/*     */               Field<Page> field;
/* 388 */               if ((field = (Field)objectMap1.get(arrayOfString[0])) != null) field.parse(page); 
/*     */             } 
/* 390 */             this.pages.add(page); continue;
/*     */           } 
/*     */           Region region;
/* 393 */           (region = new Region()).page = page;
/* 394 */           region.name = str.trim();
/* 395 */           if (param1Boolean) region.flip = true;
/*     */           
/*     */           int i;
/* 398 */           while ((i = readEntry(arrayOfString, str = bufferedReader.readLine())) != 0) {
/*     */             Field<Region> field;
/* 400 */             if ((field = (Field)objectMap2.get(arrayOfString[0])) != null) {
/* 401 */               field.parse(region); continue;
/*     */             } 
/* 403 */             if (array1 == null) {
/* 404 */               array1 = new Array(8);
/* 405 */               array2 = new Array(8);
/*     */             } 
/* 407 */             array1.add(arrayOfString[0]);
/* 408 */             int[] arrayOfInt = new int[i];
/* 409 */             for (byte b = 0; b < i; b++) {
/*     */               try {
/* 411 */                 arrayOfInt[b] = Integer.parseInt(arrayOfString[b + 1]);
/* 412 */               } catch (NumberFormatException numberFormatException) {}
/*     */             } 
/*     */             
/* 415 */             array2.add(arrayOfInt);
/*     */           } 
/*     */           
/* 418 */           if (region.originalWidth == 0 && region.originalHeight == 0) {
/* 419 */             region.originalWidth = region.width;
/* 420 */             region.originalHeight = region.height;
/*     */           } 
/* 422 */           if (array1 != null && array1.size > 0) {
/* 423 */             region.names = (String[])array1.toArray(String.class);
/* 424 */             region.values = (int[][])array2.toArray(int[].class);
/* 425 */             array1.clear();
/* 426 */             array2.clear();
/*     */           } 
/* 428 */           this.regions.add(region);
/*     */         }
/*     */       
/* 431 */       } catch (Exception exception) {
/* 432 */         throw new GdxRuntimeException("Error reading texture atlas file: " + param1FileHandle1 + (
/* 433 */             (str == null) ? "" : ("\nLine: " + str)), exception);
/*     */       } finally {
/* 435 */         StreamUtils.closeQuietly(bufferedReader);
/*     */       } 
/*     */       
/* 438 */       if (arrayOfBoolean[0]) {
/* 439 */         this.regions.sort(new Comparator<Region>() {
/*     */               public int compare(TextureAtlas.TextureAtlasData.Region param2Region1, TextureAtlas.TextureAtlasData.Region param2Region2) {
/*     */                 int i;
/* 442 */                 if ((i = param2Region1.index) == -1) i = Integer.MAX_VALUE; 
/*     */                 int j;
/* 444 */                 if ((j = param2Region2.index) == -1) j = Integer.MAX_VALUE; 
/* 445 */                 return i - j;
/*     */               }
/*     */             });
/*     */       }
/*     */     }
/*     */     
/*     */     public Array<Page> getPages() {
/* 452 */       return this.pages;
/*     */     }
/*     */     
/*     */     public Array<Region> getRegions() {
/* 456 */       return this.regions;
/*     */     }
/*     */     
/*     */     private static int readEntry(String[] param1ArrayOfString, @Null String param1String) {
/* 460 */       if (param1String == null) return 0;
/*     */       
/* 462 */       if ((param1String = param1String.trim()).length() == 0) return 0; 
/*     */       int i;
/* 464 */       if ((i = param1String.indexOf(':')) == -1) return 0; 
/* 465 */       param1ArrayOfString[0] = param1String.substring(0, i).trim();
/* 466 */       byte b = 1; i++; for (;; b++) {
/*     */         int j;
/* 468 */         if ((j = param1String.indexOf(',', i)) == -1) {
/* 469 */           param1ArrayOfString[b] = param1String.substring(i).trim();
/* 470 */           return b;
/*     */         } 
/* 472 */         param1ArrayOfString[b] = param1String.substring(i, j).trim();
/* 473 */         i = j + 1;
/* 474 */         if (b == 4) return 4; 
/*     */       } 
/*     */     }
/*     */     public static class Page { public String name; @Null
/*     */       public FileHandle textureFile; @Null
/*     */       public Texture texture; public float width;
/*     */       public float height;
/*     */       public boolean useMipMaps;
/*     */       public Pixmap.Format format;
/*     */       public Texture.TextureFilter minFilter;
/*     */       public Texture.TextureFilter magFilter;
/*     */       public Texture.TextureWrap uWrap;
/*     */       public Texture.TextureWrap vWrap;
/*     */       public boolean pma;
/*     */       
/*     */       public Page() {
/* 490 */         this.format = Pixmap.Format.RGBA8888;
/* 491 */         this.minFilter = Texture.TextureFilter.Nearest; this.magFilter = Texture.TextureFilter.Nearest;
/* 492 */         this.uWrap = Texture.TextureWrap.ClampToEdge; this.vWrap = Texture.TextureWrap.ClampToEdge;
/*     */       } }
/*     */     public static class Region { public TextureAtlas.TextureAtlasData.Page page; public String name; public int left;
/*     */       public int top;
/*     */       public int width;
/*     */       public int height;
/*     */       public float offsetX;
/*     */       public float offsetY;
/*     */       public int originalWidth;
/*     */       public int originalHeight;
/*     */       public int degrees;
/*     */       public boolean rotate;
/* 504 */       public int index = -1; @Null
/*     */       public String[] names; @Null
/*     */       public int[][] values;
/*     */       public boolean flip;
/*     */       
/*     */       @Null
/* 510 */       public int[] findValue(String param2String) { if (this.names != null) {
/* 511 */           byte b; int i; for (b = 0, i = this.names.length; b < i; b++) {
/* 512 */             if (param2String.equals(this.names[b])) return this.values[b]; 
/*     */           } 
/* 514 */         }  return null; } } private static interface Field<T> { void parse(T param2T); } } public static class Page { public String name; @Null public FileHandle textureFile; @Null public Texture texture; public float width; public float height; public boolean useMipMaps; public Pixmap.Format format; public Texture.TextureFilter minFilter; public Texture.TextureFilter magFilter; public Texture.TextureWrap uWrap; public Texture.TextureWrap vWrap; public boolean pma; public Page() { this.format = Pixmap.Format.RGBA8888; this.minFilter = Texture.TextureFilter.Nearest; this.magFilter = Texture.TextureFilter.Nearest; this.uWrap = Texture.TextureWrap.ClampToEdge; this.vWrap = Texture.TextureWrap.ClampToEdge; } } public static class Region { public TextureAtlas.TextureAtlasData.Page page; public String name; public int left; public int top; @Null public int[] findValue(String param1String) { if (this.names != null) { byte b; int i; for (b = 0, i = this.names.length; b < i; b++) { if (param1String.equals(this.names[b])) return this.values[b];  }  }  return null; }
/*     */     
/*     */     public int width; public int height; public float offsetX; public float offsetY; public int originalWidth; public int originalHeight; public int degrees; public boolean rotate; public int index; @Null
/*     */     public String[] names;
/*     */     @Null
/*     */     public int[][] values;
/*     */     public boolean flip;
/*     */     
/*     */     public Region() {
/*     */       this.index = -1;
/*     */     } }
/*     */   
/* 526 */   public static class AtlasRegion extends TextureRegion { public int index = -1;
/*     */ 
/*     */ 
/*     */     
/*     */     public String name;
/*     */ 
/*     */ 
/*     */     
/*     */     public float offsetX;
/*     */ 
/*     */     
/*     */     public float offsetY;
/*     */ 
/*     */     
/*     */     public int packedWidth;
/*     */ 
/*     */     
/*     */     public int packedHeight;
/*     */ 
/*     */     
/*     */     public int originalWidth;
/*     */ 
/*     */     
/*     */     public int originalHeight;
/*     */ 
/*     */     
/*     */     public boolean rotate;
/*     */ 
/*     */     
/*     */     public int degrees;
/*     */ 
/*     */     
/*     */     @Null
/*     */     public String[] names;
/*     */ 
/*     */     
/*     */     @Null
/*     */     public int[][] values;
/*     */ 
/*     */ 
/*     */     
/*     */     public AtlasRegion(Texture param1Texture, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 568 */       super(param1Texture, param1Int1, param1Int2, param1Int3, param1Int4);
/* 569 */       this.originalWidth = param1Int3;
/* 570 */       this.originalHeight = param1Int4;
/* 571 */       this.packedWidth = param1Int3;
/* 572 */       this.packedHeight = param1Int4;
/*     */     }
/*     */     
/*     */     public AtlasRegion(AtlasRegion param1AtlasRegion) {
/* 576 */       setRegion(param1AtlasRegion);
/* 577 */       this.index = param1AtlasRegion.index;
/* 578 */       this.name = param1AtlasRegion.name;
/* 579 */       this.offsetX = param1AtlasRegion.offsetX;
/* 580 */       this.offsetY = param1AtlasRegion.offsetY;
/* 581 */       this.packedWidth = param1AtlasRegion.packedWidth;
/* 582 */       this.packedHeight = param1AtlasRegion.packedHeight;
/* 583 */       this.originalWidth = param1AtlasRegion.originalWidth;
/* 584 */       this.originalHeight = param1AtlasRegion.originalHeight;
/* 585 */       this.rotate = param1AtlasRegion.rotate;
/* 586 */       this.degrees = param1AtlasRegion.degrees;
/* 587 */       this.names = param1AtlasRegion.names;
/* 588 */       this.values = param1AtlasRegion.values;
/*     */     }
/*     */     
/*     */     public AtlasRegion(TextureRegion param1TextureRegion) {
/* 592 */       setRegion(param1TextureRegion);
/* 593 */       this.packedWidth = param1TextureRegion.getRegionWidth();
/* 594 */       this.packedHeight = param1TextureRegion.getRegionHeight();
/* 595 */       this.originalWidth = this.packedWidth;
/* 596 */       this.originalHeight = this.packedHeight;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void flip(boolean param1Boolean1, boolean param1Boolean2) {
/* 603 */       super.flip(param1Boolean1, param1Boolean2);
/* 604 */       if (param1Boolean1) this.offsetX = this.originalWidth - this.offsetX - getRotatedPackedWidth(); 
/* 605 */       if (param1Boolean2) this.offsetY = this.originalHeight - this.offsetY - getRotatedPackedHeight();
/*     */     
/*     */     }
/*     */ 
/*     */     
/*     */     public float getRotatedPackedWidth() {
/* 611 */       return this.rotate ? this.packedHeight : this.packedWidth;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public float getRotatedPackedHeight() {
/* 617 */       return this.rotate ? this.packedWidth : this.packedHeight;
/*     */     }
/*     */     @Null
/*     */     public int[] findValue(String param1String) {
/* 621 */       if (this.names != null) {
/* 622 */         byte b; int i; for (b = 0, i = this.names.length; b < i; b++) {
/* 623 */           if (param1String.equals(this.names[b])) return this.values[b]; 
/*     */         } 
/* 625 */       }  return null;
/*     */     }
/*     */     
/*     */     public String toString() {
/* 629 */       return this.name;
/*     */     } }
/*     */ 
/*     */   
/*     */   public static class AtlasSprite
/*     */     extends Sprite {
/*     */     final TextureAtlas.AtlasRegion region;
/*     */     float originalOffsetX;
/*     */     float originalOffsetY;
/*     */     
/*     */     public AtlasSprite(TextureAtlas.AtlasRegion param1AtlasRegion) {
/* 640 */       this.region = new TextureAtlas.AtlasRegion(param1AtlasRegion);
/* 641 */       this.originalOffsetX = param1AtlasRegion.offsetX;
/* 642 */       this.originalOffsetY = param1AtlasRegion.offsetY;
/* 643 */       setRegion(param1AtlasRegion);
/* 644 */       setOrigin(param1AtlasRegion.originalWidth / 2.0F, param1AtlasRegion.originalHeight / 2.0F);
/* 645 */       int i = param1AtlasRegion.getRegionWidth();
/* 646 */       int j = param1AtlasRegion.getRegionHeight();
/* 647 */       if (param1AtlasRegion.rotate) {
/* 648 */         super.rotate90(true);
/* 649 */         super.setBounds(param1AtlasRegion.offsetX, param1AtlasRegion.offsetY, j, i);
/*     */       } else {
/* 651 */         super.setBounds(param1AtlasRegion.offsetX, param1AtlasRegion.offsetY, i, j);
/* 652 */       }  setColor(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     }
/*     */     
/*     */     public AtlasSprite(AtlasSprite param1AtlasSprite) {
/* 656 */       this.region = param1AtlasSprite.region;
/* 657 */       this.originalOffsetX = param1AtlasSprite.originalOffsetX;
/* 658 */       this.originalOffsetY = param1AtlasSprite.originalOffsetY;
/* 659 */       set(param1AtlasSprite);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setPosition(float param1Float1, float param1Float2) {
/* 664 */       super.setPosition(param1Float1 + this.region.offsetX, param1Float2 + this.region.offsetY);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setX(float param1Float) {
/* 669 */       super.setX(param1Float + this.region.offsetX);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setY(float param1Float) {
/* 674 */       super.setY(param1Float + this.region.offsetY);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setBounds(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/* 679 */       param1Float3 /= this.region.originalWidth;
/* 680 */       param1Float4 /= this.region.originalHeight;
/* 681 */       this.region.offsetX = this.originalOffsetX * param1Float3;
/* 682 */       this.region.offsetY = this.originalOffsetY * param1Float4;
/* 683 */       int i = this.region.rotate ? this.region.packedHeight : this.region.packedWidth;
/* 684 */       int j = this.region.rotate ? this.region.packedWidth : this.region.packedHeight;
/* 685 */       super.setBounds(param1Float1 + this.region.offsetX, param1Float2 + this.region.offsetY, i * param1Float3, j * param1Float4);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setSize(float param1Float1, float param1Float2) {
/* 690 */       setBounds(getX(), getY(), param1Float1, param1Float2);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setOrigin(float param1Float1, float param1Float2) {
/* 695 */       super.setOrigin(param1Float1 - this.region.offsetX, param1Float2 - this.region.offsetY);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setOriginCenter() {
/* 700 */       super.setOrigin(this.width / 2.0F - this.region.offsetX, this.height / 2.0F - this.region.offsetY);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void flip(boolean param1Boolean1, boolean param1Boolean2) {
/* 706 */       if (this.region.rotate) {
/* 707 */         super.flip(param1Boolean2, param1Boolean1);
/*     */       } else {
/* 709 */         super.flip(param1Boolean1, param1Boolean2);
/*     */       } 
/* 711 */       float f1 = getOriginX();
/* 712 */       float f2 = getOriginY();
/* 713 */       float f3 = this.region.offsetX;
/* 714 */       float f4 = this.region.offsetY;
/*     */       
/* 716 */       float f5 = getWidthRatio();
/* 717 */       float f6 = getHeightRatio();
/*     */       
/* 719 */       this.region.offsetX = this.originalOffsetX;
/* 720 */       this.region.offsetY = this.originalOffsetY;
/* 721 */       this.region.flip(param1Boolean1, param1Boolean2);
/* 722 */       this.originalOffsetX = this.region.offsetX;
/* 723 */       this.originalOffsetY = this.region.offsetY;
/* 724 */       this.region.offsetX *= f5;
/* 725 */       this.region.offsetY *= f6;
/*     */ 
/*     */       
/* 728 */       translate(this.region.offsetX - f3, this.region.offsetY - f4);
/* 729 */       setOrigin(f1, f2);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void rotate90(boolean param1Boolean) {
/* 735 */       super.rotate90(param1Boolean);
/*     */       
/* 737 */       float f1 = getOriginX();
/* 738 */       float f2 = getOriginY();
/* 739 */       float f3 = this.region.offsetX;
/* 740 */       float f4 = this.region.offsetY;
/*     */       
/* 742 */       float f5 = getWidthRatio();
/* 743 */       float f6 = getHeightRatio();
/*     */       
/* 745 */       if (param1Boolean) {
/* 746 */         this.region.offsetX = f4;
/* 747 */         this.region.offsetY = this.region.originalHeight * f6 - f3 - this.region.packedWidth * f5;
/*     */       } else {
/* 749 */         this.region.offsetX = this.region.originalWidth * f5 - f4 - this.region.packedHeight * f6;
/* 750 */         this.region.offsetY = f3;
/*     */       } 
/*     */ 
/*     */       
/* 754 */       translate(this.region.offsetX - f3, this.region.offsetY - f4);
/* 755 */       setOrigin(f1, f2);
/*     */     }
/*     */ 
/*     */     
/*     */     public float getX() {
/* 760 */       return super.getX() - this.region.offsetX;
/*     */     }
/*     */ 
/*     */     
/*     */     public float getY() {
/* 765 */       return super.getY() - this.region.offsetY;
/*     */     }
/*     */ 
/*     */     
/*     */     public float getOriginX() {
/* 770 */       return super.getOriginX() + this.region.offsetX;
/*     */     }
/*     */ 
/*     */     
/*     */     public float getOriginY() {
/* 775 */       return super.getOriginY() + this.region.offsetY;
/*     */     }
/*     */ 
/*     */     
/*     */     public float getWidth() {
/* 780 */       return super.getWidth() / this.region.getRotatedPackedWidth() * this.region.originalWidth;
/*     */     }
/*     */ 
/*     */     
/*     */     public float getHeight() {
/* 785 */       return super.getHeight() / this.region.getRotatedPackedHeight() * this.region.originalHeight;
/*     */     }
/*     */     
/*     */     public float getWidthRatio() {
/* 789 */       return super.getWidth() / this.region.getRotatedPackedWidth();
/*     */     }
/*     */     
/*     */     public float getHeightRatio() {
/* 793 */       return super.getHeight() / this.region.getRotatedPackedHeight();
/*     */     }
/*     */     
/*     */     public TextureAtlas.AtlasRegion getAtlasRegion() {
/* 797 */       return this.region;
/*     */     }
/*     */     
/*     */     public String toString() {
/* 801 */       return this.region.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\TextureAtlas.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */