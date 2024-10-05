/*     */ package com.prineside.tdi2;
/*     */ import com.a.a.c.j.a;
/*     */ import com.a.a.c.m;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.audio.Sound;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.TextureData;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureAtlas;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.IntMap;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.crashinvaders.basisu.gdx.BasisuTextureData;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.ibxm.Module;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.utils.AssetProvider;
/*     */ import com.prineside.tdi2.utils.JsonAssertUtils;
/*     */ import com.prineside.tdi2.utils.JsonHandler;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.errorhandling.CrashHandler;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.IOException;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ 
/*     */ public class ResourcePack implements Disposable {
/*  40 */   private static final TLog a = TLog.forClass(ResourcePack.class);
/*     */   
/*     */   public static final String RESOURCE_PACKS_DIR = "resourcepacks";
/*     */   private boolean b;
/*     */   public final String name;
/*  45 */   public int version = 1;
/*     */   
/*     */   private boolean c;
/*     */   
/*     */   private String d;
/*     */   private Array<String> e;
/*  51 */   public float fontResolution = 32.0F;
/*  52 */   private final IntMap<ResourcePackBitmapFont> f = new IntMap();
/*     */   
/*     */   private ResourcePackBitmapFont g;
/*     */   
/*     */   private boolean h;
/*  57 */   private StaticSound[] i = new StaticSound[StaticSoundType.values.length];
/*     */   
/*     */   private Module j;
/*     */   
/*     */   private boolean k;
/*  62 */   private final ObjectMap<String, AtlasTextureRegion> l = new ObjectMap();
/*  63 */   private final ObjectMap<String, Array<AtlasTextureRegion>> m = new ObjectMap();
/*  64 */   private final Array<TextureAtlas> n = new Array(TextureAtlas.class);
/*     */   
/*     */   private AtlasTextureRegion o;
/*     */   
/*     */   private boolean p;
/*  69 */   private final ObjectMap<String, Color> q = new ObjectMap();
/*     */   
/*     */   private boolean r;
/*     */   
/*  73 */   private final ObjectMap<String, Quad> s = new ObjectMap();
/*     */   private static final Comparator<AtlasTextureRegion> t;
/*     */   
/*     */   static {
/*  77 */     t = ((paramAtlasTextureRegion1, paramAtlasTextureRegion2) -> (paramAtlasTextureRegion1.index == paramAtlasTextureRegion2.index) ? 0 : ((paramAtlasTextureRegion1.index > paramAtlasTextureRegion2.index) ? 1 : -1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResourcePack(String paramString, boolean paramBoolean) {
/*  86 */     this.b = paramBoolean;
/*  87 */     this.name = paramString;
/*     */ 
/*     */     
/*  90 */     if (paramString.matches("[^-_.a-z0-9]+")) {
/*  91 */       throw new ResourcePackLoadingException("Illegal characters in pack name, allowed characters are -_.a-z0-9");
/*     */     }
/*     */ 
/*     */     
/*  95 */     String str = "resourcepacks/" + paramString + "/pack.json";
/*     */     FileHandle fileHandle;
/*  97 */     if (!(fileHandle = this.b ? Gdx.files.internal(str) : Gdx.files.local(str)).exists()) {
/*  98 */       throw new ResourcePackLoadingException("Resource pack config file not found: " + str);
/*     */     }
/*     */ 
/*     */     
/* 102 */     JsonValue jsonValue = (new JsonReader()).parse(fileHandle);
/* 103 */     this.version = jsonValue.getInt("version", 1);
/*     */     
/* 105 */     if (jsonValue.has("atlases")) {
/*     */       
/* 107 */       this.k = true;
/*     */ 
/*     */       
/* 110 */       int i = Config.getMaxTextureSize();
/*     */       
/*     */       JsonValue jsonValue1;
/* 113 */       if ((jsonValue1 = jsonValue.get("atlases")).isArray()) {
/* 114 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue1.iterator(); jsonIterator.hasNext(); ) {
/* 115 */           JsonValue jsonValue2; if ((jsonValue2 = jsonIterator.next()).isArray()) {
/* 116 */             boolean bool = false;
/* 117 */             for (JsonValue.JsonIterator<JsonValue> jsonIterator1 = jsonValue2.iterator(); jsonIterator1.hasNext(); ) {
/*     */               TextureAtlas.TextureAtlasData textureAtlasData;
/*     */ 
/*     */ 
/*     */               
/*     */               JsonValue jsonValue3;
/*     */ 
/*     */               
/*     */               int k;
/*     */ 
/*     */               
/* 128 */               if ((k = (jsonValue3 = jsonIterator1.next()).getInt("textureSize", 256)) > i) {
/* 129 */                 a.i("skipping variant (" + jsonValue3.toJson(JsonWriter.OutputType.json) + ") - texture size not supported (" + k + "/" + i + ")", new Object[0]);
/*     */                 
/*     */                 continue;
/*     */               } 
/*     */               
/*     */               long l1;
/* 135 */               if ((l1 = Runtime.getRuntime().maxMemory()) == Long.MAX_VALUE || l1 <= 0L) {
/* 136 */                 l1 = 1073741824L;
/*     */               }
/* 138 */               Runtime.getRuntime().gc();
/*     */               
/* 140 */               long l2 = Runtime.getRuntime().freeMemory();
/*     */               
/* 142 */               long l3, l4 = (l3 = Runtime.getRuntime().totalMemory()) - l2;
/* 143 */               long l5 = l1 - l4;
/*     */               
/* 145 */               a.i("memory: f " + l2 + " t " + l3 + " m " + l1 + " (assume " + l5 + ")", new Object[0]);
/*     */               int j;
/* 147 */               if ((j = jsonValue3.getInt("ramRequired", 0)) > 0 && (j << 10 << 10) > l5) {
/* 148 */                 a.i("skipping variant (" + jsonValue3.toJson(JsonWriter.OutputType.json) + ") - not enough ram (" + (j << 10 << 10) + "/" + l5 + ")", new Object[0]);
/*     */ 
/*     */                 
/*     */                 continue;
/*     */               } 
/*     */               
/* 154 */               String str1, str2 = (str1 = "resourcepacks/" + paramString + "/" + jsonValue3.getString("atlas")).replace(".atlas", ".basis.atlas");
/* 155 */               String str3 = str1;
/*     */               
/* 157 */               jsonValue3 = null;
/*     */               
/* 159 */               k = 0;
/* 160 */               if (AssetManager.localOrInternalFile(str2).exists()) {
/*     */                 
/* 162 */                 a.i("basis version of atlas exists", new Object[0]);
/* 163 */                 if (Game.i.actionResolver.getInitConfigManager().get(SettingsManager.InitConfig.GRAPHICS_BASIS_TEXTURES) != 0) {
/* 164 */                   a.i("basis textures enabled, trying to load", new Object[0]);
/*     */                   
/*     */                   FileHandle fileHandle1;
/* 167 */                   if (!(fileHandle1 = AssetManager.localOrInternalFile(str2)).exists()) {
/* 168 */                     throw new ResourcePackLoadingException("Texture atlas not found: " + str2);
/*     */                   }
/*     */ 
/*     */ 
/*     */                   
/*     */                   try {
/* 174 */                     Array array1 = (textureAtlasData = new TextureAtlas.TextureAtlasData(fileHandle1, fileHandle1.parent(), false)).getPages();
/* 175 */                     for (byte b = 0; b < array1.size; b++) {
/* 176 */                       TextureAtlas.TextureAtlasData.Page page = (TextureAtlas.TextureAtlasData.Page)array1.get(b);
/*     */                       try {
/* 178 */                         BasisuTextureData basisuTextureData = new BasisuTextureData(page.textureFile);
/* 179 */                         page.texture = new Texture((TextureData)basisuTextureData);
/* 180 */                       } catch (Exception exception) {
/* 181 */                         throw new IllegalStateException("Failed to load Basis Universal texture but we've managed to catch an exception: " + exception.getMessage(), exception);
/*     */                       } 
/*     */                     } 
/* 184 */                     k = 1;
/* 185 */                     str3 = str2;
/* 186 */                   } catch (Exception exception) {
/* 187 */                     a.e("failed to load basis atlas, falling back to png", new Object[] { exception });
/* 188 */                     CrashHandler.report("Failed to load Basis atlas, falling back to PNG", exception); continue;
/*     */                   } 
/*     */                 } 
/*     */               } else {
/* 192 */                 a.i("basis atlas " + str2 + " not found", new Object[0]);
/*     */               } 
/*     */               
/* 195 */               if (k == 0) {
/*     */                 FileHandle fileHandle1;
/*     */                 
/* 198 */                 if (!(fileHandle1 = this.b ? Gdx.files.internal(str1) : Gdx.files.local(str1)).exists()) {
/* 199 */                   throw new ResourcePackLoadingException("Texture atlas not found: " + str1);
/*     */                 }
/*     */ 
/*     */ 
/*     */                 
/* 204 */                 Array array1 = (textureAtlasData = new TextureAtlas.TextureAtlasData(fileHandle1, fileHandle1.parent(), false)).getPages();
/* 205 */                 for (byte b = 0; b < array1.size; b++) {
/*     */                   TextureAtlas.TextureAtlasData.Page page;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/* 216 */                   (page = (TextureAtlas.TextureAtlasData.Page)array1.get(b)).texture = new Texture(page.textureFile, page.format, page.useMipMaps);
/*     */                 } 
/*     */               } 
/*     */ 
/*     */ 
/*     */               
/* 222 */               long l6 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
/* 223 */               a.i("allocated " + ((l6 - l4) / 1024L) + "kb to load the texture", new Object[0]);
/* 224 */               Runtime.getRuntime().gc();
/* 225 */               l2 = Runtime.getRuntime().freeMemory();
/*     */               
/* 227 */               l4 = (l3 = Runtime.getRuntime().totalMemory()) - l2;
/*     */               
/*     */               TextureAtlas textureAtlas;
/* 230 */               Array array = (textureAtlas = new TextureAtlas(textureAtlasData)).getRegions();
/* 231 */               byte b1 = 0; byte b2; int m;
/* 232 */               for (b2 = 0, m = array.size; b2 < m; b2++) {
/* 233 */                 TextureAtlas.AtlasRegion atlasRegion = (TextureAtlas.AtlasRegion)array.get(b2);
/* 234 */                 boolean bool1 = false;
/*     */                 
/* 236 */                 if (!this.l.containsKey(atlasRegion.name) || (atlasRegion.index == 0 && ((AtlasTextureRegion)this.l.get(atlasRegion.name)).index != 0)) {
/*     */                   
/* 238 */                   this.l.put(atlasRegion.name, new AtlasTextureRegion(atlasRegion, textureAtlas));
/* 239 */                   bool1 = true;
/*     */                 } 
/*     */                 
/* 242 */                 if (atlasRegion.index != -1) {
/*     */                   
/* 244 */                   if (!this.m.containsKey(atlasRegion.name)) {
/* 245 */                     this.m.put(atlasRegion.name, new Array());
/*     */                   }
/* 247 */                   if (((Array)this.m.get(atlasRegion.name)).size == 0 || AtlasTextureRegion.a((AtlasTextureRegion)((Array)this.m.get(atlasRegion.name)).get(0)) == textureAtlas) {
/* 248 */                     ((Array)this.m.get(atlasRegion.name)).add(new AtlasTextureRegion(atlasRegion, textureAtlas));
/* 249 */                     bool1 = true;
/*     */                   } 
/*     */                 } 
/* 252 */                 if (bool1) {
/* 253 */                   b1++;
/*     */                 }
/*     */               } 
/* 256 */               if (b1 != 0) {
/*     */                 
/* 258 */                 this.n.add(textureAtlas);
/*     */                 
/* 260 */                 a.i("using atlas '" + str3 + "' with " + b1 + " regions", new Object[0]);
/*     */ 
/*     */ 
/*     */                 
/* 264 */                 for (ObjectSet.ObjectSetIterator<Texture> objectSetIterator = textureAtlas.getTextures().iterator(); objectSetIterator.hasNext(); ) {
/* 265 */                   Texture texture; (texture = objectSetIterator.next()).setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
/* 266 */                   a.i("atlas texture size: " + texture.getWidth() + "x" + texture.getHeight(), new Object[0]);
/*     */                 } 
/*     */               } else {
/*     */                 
/* 270 */                 textureAtlas.dispose();
/*     */                 
/* 272 */                 a.i("skipping atlas '" + str3 + "', no regions used", new Object[0]);
/*     */               } 
/* 274 */               bool = true;
/*     */               
/* 276 */               long l7 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
/* 277 */               a.i("allocated " + ((l7 - l4) / 1024L) + "kb to load the atlas", new Object[0]);
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 282 */             if (!bool)
/* 283 */               throw new ResourcePackLoadingException("Failed to load any variant of atlas: " + jsonValue2.toJson(JsonWriter.OutputType.json)); 
/*     */             continue;
/*     */           } 
/* 286 */           throw new ResourcePackLoadingException("'atlases.atlas' config value must be an array");
/*     */         } 
/*     */       } else {
/*     */         
/* 290 */         throw new ResourcePackLoadingException("'atlases' config value must be an array");
/*     */       } 
/*     */ 
/*     */       
/* 294 */       for (ObjectMap.Entries<ObjectMap.Entry> entries = this.m.iterator(); entries.hasNext();) {
/* 295 */         ((Array)(entry = entries.next()).value).sort(t);
/*     */       }
/*     */ 
/*     */       
/* 299 */       this.o = getTextureRegion("blank");
/* 300 */       if (this.o != null) {
/*     */         
/* 302 */         float f1 = this.o.getU2() - this.o.getU();
/* 303 */         float f2 = this.o.getV2() - this.o.getV();
/* 304 */         this.o.setU(this.o.getU() + f1 * 0.25F);
/* 305 */         this.o.setU2(this.o.getU() + f1 * 0.75F);
/* 306 */         this.o.setV(this.o.getV() + f2 * 0.25F);
/* 307 */         this.o.setV2(this.o.getV() + f2 * 0.75F);
/*     */       } 
/*     */       
/* 310 */       a.i("loaded " + this.n.size + " texture atlases from resource pack '" + paramString + "'", new Object[0]);
/*     */     } 
/*     */     
/* 313 */     if (jsonValue.has("quads")) {
/*     */       
/* 315 */       this.r = true;
/*     */       
/* 317 */       String str1 = "resourcepacks/" + paramString + "/" + jsonValue.get("quads").asString();
/*     */       FileHandle fileHandle1;
/* 319 */       if (!(fileHandle1 = this.b ? Gdx.files.internal(str1) : Gdx.files.local(str1)).exists()) {
/* 320 */         throw new ResourcePackLoadingException("Quads file " + str1 + " not found");
/*     */       }
/*     */       
/*     */       try {
/*     */         m m;
/* 325 */         JsonAssertUtils.checkJsonType(m = JsonHandler.i().getMapper().a(fileHandle1.read()), m.g, "quads");
/* 326 */         Objects.requireNonNull(this.l); preloadQuadRegionSetRecursive(m, null, paramString, this.s, this.l::get);
/* 327 */         a.i("loaded " + this.s.size + " quads", new Object[0]);
/* 328 */       } catch (IOException iOException) {
/* 329 */         throw new RuntimeException("Failed to read json file " + str1, iOException);
/*     */       } 
/*     */     } 
/*     */     
/* 333 */     if (jsonValue.has("font")) {
/*     */       
/* 335 */       this.c = true;
/*     */       
/*     */       JsonValue jsonValue1;
/* 338 */       if ((jsonValue1 = jsonValue.get("font")).has("file") && jsonValue1.has("textures")) {
/* 339 */         this.d = "resourcepacks/" + paramString + "/" + jsonValue1.get("file").asString();
/*     */         
/*     */         FileHandle fileHandle1;
/* 342 */         if (!(fileHandle1 = this.b ? Gdx.files.internal(this.d) : Gdx.files.local(this.d)).exists()) {
/* 343 */           throw new ResourcePackLoadingException("Font file " + this.d + " not found");
/*     */         }
/*     */         
/* 346 */         this.e = new Array(String.class);
/* 347 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue1.get("textures").iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue2 = jsonIterator.next();
/* 348 */           this.e.add(jsonValue2.asString());
/* 349 */           if (getTextureRegion(jsonValue2.asString()) == null) {
/* 350 */             throw new ResourcePackLoadingException("Resource pack '" + paramString + "' has no texture region '" + jsonValue2.asString() + "' for font");
/*     */           } }
/*     */ 
/*     */         
/* 354 */         if (jsonValue1.has("resolution"))
/*     */         {
/* 356 */           this.fontResolution = jsonValue1.get("resolution").asFloat();
/*     */         }
/*     */       } else {
/* 359 */         throw new ResourcePackLoadingException("'font' config value must contain fields 'file' and 'texture'");
/*     */       } 
/*     */     } 
/*     */     
/* 363 */     if (jsonValue.has("soundTracks")) {
/*     */       
/* 365 */       JsonValue jsonValue1 = jsonValue.get("soundTracks");
/* 366 */       byte b = 0;
/* 367 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue1.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue2 = jsonIterator.next();
/*     */         try {
/* 369 */           StaticSoundType staticSoundType = StaticSoundType.valueOf(jsonValue2.name);
/* 370 */           Sound sound = Gdx.audio.newSound(Gdx.files.internal("resourcepacks/" + paramString + "/" + jsonValue2.getString("file")));
/* 371 */           this.i[staticSoundType.ordinal()] = new StaticSound(staticSoundType, sound, jsonValue2.getInt("duration"));
/* 372 */           b++;
/* 373 */         } catch (Exception exception) {
/* 374 */           a.e("failed to load soundTrack '" + jsonValue2.name + "'", new Object[] { exception });
/*     */         }  }
/*     */ 
/*     */       
/* 378 */       if (paramString.equals("default")) {
/* 379 */         if (b == StaticSoundType.values.length) {
/* 380 */           this.h = true;
/* 381 */           a.i("loaded all sound tracks", new Object[0]);
/*     */         } else {
/* 383 */           a.w("loaded only " + b + "/" + StaticSoundType.values.length + " sound tracks", new Object[0]);
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 388 */     if (jsonValue.has("menuXmSoundTrack")) {
/*     */       
/*     */       try {
/* 391 */         this.j = Module.fromZipInputStream(Gdx.files.internal("resourcepacks/" + paramString + "/" + jsonValue.getString("menuXmSoundTrack")).read());
/* 392 */       } catch (Exception exception) {
/* 393 */         throw new ResourcePackLoadingException("failed to load menu xm music '" + jsonValue.getString("menuXmSoundTrack") + "'", exception);
/*     */       } 
/*     */     }
/*     */     
/* 397 */     if (jsonValue.has("colors")) {
/*     */       
/* 399 */       this.p = true;
/*     */       
/* 401 */       for (JsonValue jsonValue1 = (jsonValue.get("colors")).child; jsonValue1 != null; jsonValue1 = jsonValue1.next) {
/* 402 */         String str1 = jsonValue1.name;
/*     */         
/*     */         String str2;
/* 405 */         if ((str2 = jsonValue1.asString()).startsWith("#")) {
/*     */           float f1, f2, f3, f4;
/*     */           
/*     */           String str3;
/* 409 */           if ((str3 = str2.substring(1).toUpperCase()).length() == 6) {
/*     */             
/* 411 */             f1 = Integer.parseInt(str3.substring(0, 2), 16) / 255.0F;
/* 412 */             f2 = Integer.parseInt(str3.substring(2, 4), 16) / 255.0F;
/* 413 */             f3 = Integer.parseInt(str3.substring(4, 6), 16) / 255.0F;
/* 414 */             f4 = 1.0F;
/* 415 */           } else if (str3.length() == 8) {
/*     */             
/* 417 */             f1 = Integer.parseInt(str3.substring(0, 2), 16) / 255.0F;
/* 418 */             f2 = Integer.parseInt(str3.substring(2, 4), 16) / 255.0F;
/* 419 */             f3 = Integer.parseInt(str3.substring(4, 6), 16) / 255.0F;
/* 420 */             f4 = Integer.parseInt(str3.substring(6, 8), 16) / 255.0F;
/*     */           } else {
/* 422 */             throw new ResourcePackLoadingException("Unknown color format: " + str2);
/*     */           } 
/*     */           
/* 425 */           this.q.put(str1, new Color(f1, f2, f3, f4));
/*     */         } else {
/* 427 */           throw new ResourcePackLoadingException("Unknown color format: '" + str2 + "'");
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void preloadQuadRegionSetRecursive(m paramm, String paramString1, String paramString2, ObjectMap<String, Quad> paramObjectMap, AssetProvider<TextureRegion> paramAssetProvider) {
/*     */     Iterator<Map.Entry> iterator;
/* 435 */     if (paramm.c()) {
/* 436 */       for (iterator = paramm.n(); iterator.hasNext();)
/*     */       {
/* 438 */         preloadQuadRegionSetRecursive((entry = iterator.next()).getValue(), (paramString1 == null) ? (String)entry.getKey() : (paramString1 + "." + (String)entry.getKey()), paramString2, paramObjectMap, paramAssetProvider); } 
/*     */       return;
/*     */     } 
/* 441 */     if (paramString1 != null && paramObjectMap.containsKey(paramString1)) {
/* 442 */       a.i("skipped quad '" + paramString1 + "' from " + paramString2, new Object[0]); return;
/*     */     } 
/*     */     try {
/* 445 */       if (paramString1 == null) {
/* 446 */         throw new IllegalArgumentException("No prefix for " + iterator);
/*     */       }
/* 448 */       paramObjectMap.put(paramString1, Quad.fromJson((a)iterator, paramAssetProvider)); return;
/* 449 */     } catch (Exception exception) {
/* 450 */       throw new IllegalArgumentException("Failed to load quad '" + paramString1 + "' from pack '" + paramString2 + "'", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AtlasTextureRegion getBlankWhiteTextureRegion() {
/* 457 */     return this.o;
/*     */   }
/*     */   public AtlasTextureRegion getTextureRegion(String paramString) {
/*     */     String[] arrayOfString;
/* 461 */     if (!this.k) return null;
/*     */ 
/*     */     
/*     */     AtlasTextureRegion atlasTextureRegion;
/* 465 */     if ((atlasTextureRegion = (AtlasTextureRegion)this.l.get(paramString, null)) == null && paramString.contains("@")) {
/*     */       
/* 467 */       arrayOfString = paramString.split("@");
/*     */       AtlasTextureRegion atlasTextureRegion1;
/* 469 */       if ((atlasTextureRegion1 = (AtlasTextureRegion)this.l.get(arrayOfString[0], null)) == null || arrayOfString.length < 2)
/*     */       {
/* 471 */         return null;
/*     */       }
/*     */       
/* 474 */       AtlasTextureRegion atlasTextureRegion2 = new AtlasTextureRegion(atlasTextureRegion1, atlasTextureRegion1.getAtlas());
/* 475 */       switch (arrayOfString[1]) {
/*     */         case "flip-x":
/* 477 */           atlasTextureRegion2.flip(true, false);
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
/* 495 */           a.i("stored modified region: " + paramString, new Object[0]);
/* 496 */           this.l.put(paramString, atlasTextureRegion2);
/*     */           
/* 498 */           return atlasTextureRegion2;case "flip-y": atlasTextureRegion2.flip(false, true); a.i("stored modified region: " + paramString, new Object[0]); this.l.put(paramString, atlasTextureRegion2); return atlasTextureRegion2;case "flip-xy": case "rotate-180": atlasTextureRegion2.flip(true, true); a.i("stored modified region: " + paramString, new Object[0]); this.l.put(paramString, atlasTextureRegion2); return atlasTextureRegion2;
/*     */       }  a.e("region modifier \"" + arrayOfString[1] + "\" is invalid", new Object[0]); return atlasTextureRegion1;
/*     */     } 
/* 501 */     return (AtlasTextureRegion)arrayOfString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Array<AtlasTextureRegion> getTextureRegionSet(String paramString) {
/* 508 */     if (!this.k) return null;
/*     */     
/* 510 */     return (Array<AtlasTextureRegion>)this.m.get(paramString, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectMap<String, AtlasTextureRegion> getTextureRegions() {
/* 517 */     return this.l;
/*     */   }
/*     */   
/*     */   public ObjectMap<String, Array<AtlasTextureRegion>> getTextureRegionSets() {
/* 521 */     return this.m;
/*     */   }
/*     */   
/*     */   public Array<TextureAtlas> getLoadedAtlases() {
/* 525 */     return this.n;
/*     */   }
/*     */   
/*     */   public Color getColor(String paramString) {
/* 529 */     if (!this.p) return null;
/*     */     
/* 531 */     return (Color)this.q.get(paramString, null);
/*     */   }
/*     */   
/*     */   public Quad getQuad(String paramString) {
/* 535 */     if (!this.r) return null;
/*     */     
/* 537 */     return (Quad)this.s.get(paramString, null);
/*     */   }
/*     */   
/*     */   public ResourcePackBitmapFont getFont(int paramInt) {
/* 541 */     return getFontWithMarkup(paramInt, true);
/*     */   }
/*     */   
/*     */   public ResourcePackBitmapFont getFontWithMarkup(int paramInt, boolean paramBoolean) {
/* 545 */     if (!this.c) {
/* 546 */       return null;
/*     */     }
/*     */     
/* 549 */     int i = paramInt;
/* 550 */     if (paramBoolean) {
/* 551 */       i += 10000;
/*     */     }
/*     */     
/* 554 */     if (this.f.containsKey(i)) {
/* 555 */       return (ResourcePackBitmapFont)this.f.get(i);
/*     */     }
/* 557 */     Array<TextureRegion> array = new Array();
/* 558 */     for (Array.ArrayIterator<String> arrayIterator = this.e.iterator(); arrayIterator.hasNext(); ) { String str = arrayIterator.next();
/* 559 */       array.add(getTextureRegion(str)); }
/*     */     
/* 561 */     ResourcePackBitmapFont resourcePackBitmapFont = new ResourcePackBitmapFont(this.b ? Gdx.files.internal(this.d) : Gdx.files.local(this.d), array, false);
/* 562 */     float f = paramInt / this.fontResolution * Game.i.assetManager.getFontScaleMultiplier(paramInt);
/* 563 */     a.i("=== creating new font, size: " + paramInt + ", resolution: " + this.fontResolution + ", multiplier: " + Game.i.assetManager.getFontScaleMultiplier(paramInt) + ", scale: " + f, new Object[0]);
/* 564 */     resourcePackBitmapFont.getData().setScale(f);
/* 565 */     (resourcePackBitmapFont.getData()).markupEnabled = paramBoolean;
/* 566 */     resourcePackBitmapFont.setFixedWidthGlyphs("0123456789");
/* 567 */     Game.i.assetManager.addRegionCharsToFont(resourcePackBitmapFont, (int)this.fontResolution);
/*     */     
/* 569 */     if (this.g == null) {
/* 570 */       this.g = resourcePackBitmapFont;
/*     */     } else {
/*     */       
/* 573 */       for (paramInt = 0; paramInt < (resourcePackBitmapFont.getData()).glyphs.length; paramInt++) {
/* 574 */         (resourcePackBitmapFont.getData()).glyphs[paramInt] = (this.g.getData()).glyphs[paramInt];
/*     */       }
/*     */     } 
/*     */     
/* 578 */     this.f.put(i, resourcePackBitmapFont);
/*     */     
/* 580 */     resourcePackBitmapFont.resourcePack = this;
/*     */ 
/*     */     
/* 583 */     return resourcePackBitmapFont;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasSounds() {
/* 588 */     return this.h;
/*     */   }
/*     */   @Null
/*     */   public StaticSound getSound(StaticSoundType paramStaticSoundType) {
/* 592 */     if (this.h) {
/* 593 */       return this.i[paramStaticSoundType.ordinal()];
/*     */     }
/*     */     
/* 596 */     return null;
/*     */   }
/*     */   
/*     */   public Module getMenuXmSoundTrack() {
/* 600 */     return this.j;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 605 */     for (Array.ArrayIterator<TextureAtlas> arrayIterator = this.n.iterator(); arrayIterator.hasNext();)
/* 606 */       (textureAtlas = arrayIterator.next()).dispose(); 
/*     */   }
/*     */   
/*     */   public static class AtlasTextureRegion
/*     */     extends TextureAtlas.AtlasRegion {
/*     */     private final TextureAtlas a;
/*     */     
/*     */     AtlasTextureRegion(TextureAtlas.AtlasRegion param1AtlasRegion, TextureAtlas param1TextureAtlas) {
/* 614 */       super(param1AtlasRegion);
/*     */       
/* 616 */       this.a = param1TextureAtlas;
/*     */     }
/*     */     
/*     */     public TextureAtlas getAtlas() {
/* 620 */       return this.a;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ResourcePackBitmapFont extends BitmapFont {
/*     */     public ResourcePack resourcePack;
/*     */     
/*     */     public ResourcePackBitmapFont(FileHandle param1FileHandle, Array<TextureRegion> param1Array, boolean param1Boolean) {
/* 628 */       super(new BitmapFont.BitmapFontData(param1FileHandle, param1Boolean), param1Array, false);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ResourcePackLoadingException extends Exception {
/*     */     ResourcePackLoadingException(String param1String) {
/* 634 */       super(param1String);
/*     */     }
/*     */     
/*     */     ResourcePackLoadingException(String param1String, Throwable param1Throwable) {
/* 638 */       super(param1String, param1Throwable);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\ResourcePack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */