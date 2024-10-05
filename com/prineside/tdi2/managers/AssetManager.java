/*      */ package com.prineside.tdi2.managers;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.Net;
/*      */ import com.badlogic.gdx.files.FileHandle;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.Colors;
/*      */ import com.badlogic.gdx.graphics.Pixmap;
/*      */ import com.badlogic.gdx.graphics.PixmapIO;
/*      */ import com.badlogic.gdx.graphics.Texture;
/*      */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureAtlas;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.graphics.g3d.Attribute;
/*      */ import com.badlogic.gdx.graphics.g3d.Material;
/*      */ import com.badlogic.gdx.graphics.g3d.Model;
/*      */ import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
/*      */ import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
/*      */ import com.badlogic.gdx.graphics.g3d.attributes.DepthTestAttribute;
/*      */ import com.badlogic.gdx.graphics.g3d.attributes.IntAttribute;
/*      */ import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
/*      */ import com.badlogic.gdx.graphics.g3d.model.data.ModelData;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.BaseJsonReader;
/*      */ import com.badlogic.gdx.utils.IntArray;
/*      */ import com.badlogic.gdx.utils.IntMap;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.ObjectMap;
/*      */ import com.badlogic.gdx.utils.ObjectSet;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.badlogic.gdx.utils.UBJsonReader;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.Manager;
/*      */ import com.prineside.tdi2.ResourcePack;
/*      */ import com.prineside.tdi2.StaticSound;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.ibxm.Module;
/*      */ import com.prineside.tdi2.scene2d.ui.List;
/*      */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*      */ import com.prineside.tdi2.scene2d.ui.SelectBox;
/*      */ import com.prineside.tdi2.scene2d.ui.TextField;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*      */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.Window;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.ObjectConsumer;
/*      */ import com.prineside.tdi2.utils.PMath;
/*      */ import com.prineside.tdi2.utils.PackColor;
/*      */ import com.prineside.tdi2.utils.Quad;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.errorhandling.CrashHandler;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.lang.ref.SoftReference;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ 
/*      */ @REGS(serializer = AssetManager.Serializer.class)
/*      */ public class AssetManager
/*      */   extends Manager.ManagerAdapter {
/*   66 */   private static final TLog a = TLog.forClass(AssetManager.class);
/*      */   public static final String BLANK_REGION_NAME = "blank";
/*      */   
/*      */   public static class Serializer extends SingletonSerializer<AssetManager> { public AssetManager read() {
/*   70 */       return Game.i.assetManager;
/*      */     } }
/*      */   public static final class TextureRegions { private static TextureRegions a; public ResourcePack.AtlasTextureRegion blank; public ResourcePack.AtlasTextureRegion tileOutlineActive; public ResourcePack.AtlasTextureRegion tileOutlineHover; public ResourcePack.AtlasTextureRegion gateOutlineVerticalActive; public ResourcePack.AtlasTextureRegion gateOutlineVerticalHover;
/*      */     public ResourcePack.AtlasTextureRegion gateOutlineHorizontalActive;
/*      */     public ResourcePack.AtlasTextureRegion gateOutlineHorizontalHover;
/*      */     public ResourcePack.AtlasTextureRegion crosshairSmall;
/*      */     public ResourcePack.AtlasTextureRegion muzzleFlash1;
/*      */     public ResourcePack.AtlasTextureRegion muzzleFlash2;
/*      */     public ResourcePack.AtlasTextureRegion muzzleFlashCompensator1;
/*      */     public ResourcePack.AtlasTextureRegion muzzleFlashCompensator2;
/*      */     
/*      */     public static TextureRegions i() {
/*   82 */       return a;
/*      */     }
/*      */ 
/*      */     
/*      */     public ResourcePack.AtlasTextureRegion muzzleFlashSmall;
/*      */     
/*      */     public ResourcePack.AtlasTextureRegion flyingPaper100_1;
/*      */     
/*      */     public ResourcePack.AtlasTextureRegion flyingPaper20_1;
/*      */     
/*      */     public ResourcePack.AtlasTextureRegion flyingPaper5_1;
/*      */     
/*      */     public ResourcePack.AtlasTextureRegion flyingPaper1_1;
/*      */     
/*      */     public ResourcePack.AtlasTextureRegion flyingPaper1_2;
/*      */     
/*      */     public ResourcePack.AtlasTextureRegion flyingPaper1_3;
/*      */     
/*      */     public ResourcePack.AtlasTextureRegion flyingPaper1_4;
/*      */     
/*      */     public ResourcePack.AtlasTextureRegion smallCircle;
/*      */     
/*      */     public ResourcePack.AtlasTextureRegion roundedSmallRect;
/*      */     
/*      */     public ResourcePack.AtlasTextureRegion particlePentagon;
/*      */     
/*      */     public ResourcePack.AtlasTextureRegion iconSmokeBomb;
/*      */     
/*      */     public ResourcePack.AtlasTextureRegion enemyDialog;
/*      */     
/*      */     public ResourcePack.AtlasTextureRegion iconOrgan;
/*      */     
/*      */     public ResourcePack.AtlasTextureRegion iconPickaxe;
/*      */     
/*      */     public ResourcePack.AtlasTextureRegion iconLoop;
/*      */     
/*      */     public ResourcePack.AtlasTextureRegion bulletTraceThin;
/*      */     public ResourcePack.AtlasTextureRegion buffHealthBarIconPoison;
/*      */     public ResourcePack.AtlasTextureRegion buffHealthBarIconPoisonTwo;
/*      */     public ResourcePack.AtlasTextureRegion buffHealthBarIconPoisonThree;
/*      */     public ResourcePack.AtlasTextureRegion buffHealthBarIconFreezing;
/*      */     public ResourcePack.AtlasTextureRegion buffHealthBarIconBurn;
/*      */     public ResourcePack.AtlasTextureRegion buffHealthBarIconBlizzard;
/*      */     public ResourcePack.AtlasTextureRegion buffHealthBarIconArmor;
/*      */     public ResourcePack.AtlasTextureRegion buffHealthBarIconSnowball;
/*      */     public ResourcePack.AtlasTextureRegion buffHealthBarIconRegeneration;
/*      */     public ResourcePack.AtlasTextureRegion buffHealthBarIconBlastThrowBack;
/*      */     public ResourcePack.AtlasTextureRegion buffHealthBarIconStun;
/*      */     public ResourcePack.AtlasTextureRegion buffHealthBarIconBonusCoins;
/*      */     public ResourcePack.AtlasTextureRegion buffHealthBarIconBonusXp;
/*      */     public ResourcePack.AtlasTextureRegion buffHealthBarIconDeathExplosion;
/*      */     public ResourcePack.AtlasTextureRegion buffHealthBarIconChainReaction;
/*      */     public ResourcePack.AtlasTextureRegion buffHealthBarIconVulnerability;
/*      */     public ResourcePack.AtlasTextureRegion buffHealthBarIconInvulnerability;
/*      */     public ResourcePack.AtlasTextureRegion buffHealthBarIconSlipping;
/*      */     public ResourcePack.AtlasTextureRegion buffHealthBarIconNoDamage;
/*      */     public ResourcePack.AtlasTextureRegion buffHealthBarIconNoBonusSystemPoints;
/*      */     public ResourcePack.AtlasTextureRegion overloadImpulseA;
/*      */     public ResourcePack.AtlasTextureRegion overloadImpulseB;
/*      */     public ResourcePack.AtlasTextureRegion overloadImpulseC;
/*      */     public ResourcePack.AtlasTextureRegion overloadImpulseD; }
/*      */   
/*  144 */   private final Array<ResourcePack> b = new Array(ResourcePack.class);
/*      */   
/*  146 */   private final ObjectMap<String, TextureRegionDrawable> c = new ObjectMap();
/*  147 */   private final IntMap<Label.LabelStyle> d = new IntMap();
/*      */   
/*      */   private Label.LabelStyle e;
/*      */   
/*      */   private Label.LabelStyle f;
/*      */   
/*      */   private Model g;
/*      */   
/*      */   public Material normalMaterial;
/*      */   
/*      */   public Material blendedMaterial;
/*      */   private BitmapFont h;
/*      */   private BitmapFont i;
/*      */   private BitmapFont j;
/*      */   private BitmapFont k;
/*      */   private BitmapFont l;
/*      */   private BitmapFont m;
/*      */   private BitmapFont n;
/*      */   private BitmapFont o;
/*      */   private BitmapFont p;
/*      */   private Texture q;
/*  168 */   private final ConcurrentHashMap<String, Model> r = new ConcurrentHashMap<>(); private final RegionAliasCharPair[] s;
/*      */   
/*      */   private static class RegionAliasCharPair {
/*      */     char a;
/*      */     TextureRegion b;
/*      */     
/*      */     private RegionAliasCharPair() {} }
/*  175 */   private final IntMap<RegionAliasCharPair> t = new IntMap();
/*  176 */   private final ObjectMap<String, ParticleEffectPool> u = new ObjectMap();
/*      */ 
/*      */   
/*  179 */   private final ObjectMap<String, SoftReference<WebTextureRegion>> v = new ObjectMap();
/*      */   
/*  181 */   private static final StringBuilder w = new StringBuilder();
/*      */ 
/*      */ 
/*      */   
/*      */   public AssetManager() {
/*  186 */     this.c.clear();
/*      */ 
/*      */     
/*      */     try {
/*  190 */       this.b.add(new ResourcePack("default", true));
/*  191 */     } catch (com.prineside.tdi2.ResourcePack.ResourcePackLoadingException resourcePackLoadingException) {
/*  192 */       throw new RuntimeException("Failed to load default resource pack: " + resourcePackLoadingException.getMessage(), resourcePackLoadingException);
/*      */     } 
/*      */     
/*      */     FileHandle fileHandle;
/*      */     
/*  197 */     if (!(fileHandle = Gdx.files.local("resourcepacks")).exists()) {
/*  198 */       a.i("External resource packs dir not found", new Object[0]);
/*      */     } else {
/*  200 */       a.i("External resource packs dir found", new Object[0]);
/*  201 */       FileHandle[] arrayOfFileHandle1 = fileHandle.list();
/*      */ 
/*      */       
/*  204 */       for (byte b5 = 0; b5 < arrayOfFileHandle1.length; b5++) {
/*  205 */         for (int k = b5 + 1; k < arrayOfFileHandle1.length; k++) {
/*  206 */           if (arrayOfFileHandle1[b5].name().compareTo(arrayOfFileHandle1[k].name()) < 0) {
/*  207 */             FileHandle fileHandle1 = arrayOfFileHandle1[b5];
/*  208 */             arrayOfFileHandle1[b5] = arrayOfFileHandle1[k];
/*  209 */             arrayOfFileHandle1[k] = fileHandle1;
/*      */           } 
/*      */         } 
/*      */       }  FileHandle[] arrayOfFileHandle2; int j;
/*      */       byte b6;
/*  214 */       for (j = (arrayOfFileHandle2 = arrayOfFileHandle1).length, b6 = 0; b6 < j; ) {
/*  215 */         FileHandle fileHandle1; if (!(fileHandle1 = arrayOfFileHandle2[b6]).name().equals("default") && fileHandle1.isDirectory())
/*      */           
/*      */           try {
/*  218 */             this.b.add(new ResourcePack(fileHandle1.name(), false));
/*  219 */             a.i("Loaded resource pack: " + fileHandle1.name(), new Object[0]);
/*  220 */           } catch (Exception exception) {
/*  221 */             a.e("Failed to load resource pack: " + fileHandle1.name(), new Object[] { exception });
/*      */           }   b6++;
/*      */       } 
/*      */     }  MaterialColor.Colors[] arrayOfColors;
/*      */     int i;
/*      */     byte b1;
/*  227 */     for (i = (arrayOfColors = MaterialColor.Colors.values).length, b1 = 0; b1 < i; b1++) {
/*      */       MaterialColor.Colors colors;
/*  229 */       Colors.put((colors = arrayOfColors[b1]).name(), MaterialColor.allColors[colors.ordinal()][MaterialColor.Variants.P500.ordinal()].cpy()); byte b; MaterialColor.Variants[] arrayOfVariants; int j;
/*  230 */       for (j = (arrayOfVariants = MaterialColor.Variants.values).length, b = 0; b < j; ) { MaterialColor.Variants variants = arrayOfVariants[b];
/*  231 */         if ((MaterialColor.allColors[colors.ordinal()]).length > variants.ordinal())
/*      */         {
/*  233 */           Colors.put(colors.name() + "_" + variants.name(), MaterialColor.allColors[colors.ordinal()][variants.ordinal()].cpy());
/*      */         }
/*      */         
/*      */         b++; }
/*      */     
/*      */     } 
/*  239 */     ResourcePack resourcePack = (ResourcePack)this.b.first();
/*      */ 
/*      */     
/*  242 */     i = 207;
/*  243 */     b1 = 0;
/*      */     
/*  245 */     for (byte b2 = 1; b2 < this.b.size; b2++) {
/*      */       ResourcePack resourcePack1;
/*  247 */       if (((resourcePack1 = (ResourcePack)this.b.get(b2)).getLoadedAtlases()).size != 0) {
/*  248 */         b1 = 1;
/*      */         
/*  250 */         i = (i = i * 31 + PMath.hash(resourcePack1.name)) * 31 + PMath.hash(resourcePack1.version);
/*      */       } 
/*      */     } 
/*      */     
/*  254 */     if (b1 != 0) {
/*      */       
/*  256 */       Pixmap pixmap = null;
/*      */       
/*  258 */       long l = Game.getRealTickCount();
/*  259 */       FileHandle fileHandle1 = Gdx.files.local("cache/atlas-merged.dat");
/*  260 */       FileHandle fileHandle2 = Gdx.files.local("cache/atlas-merged-hash.txt");
/*      */       
/*  262 */       b1 = 1;
/*      */       try {
/*  264 */         if (fileHandle1.exists() && fileHandle2.exists()) {
/*      */           int j;
/*      */           
/*  267 */           if ((j = Integer.parseInt(fileHandle2.readString())) == i) {
/*      */             
/*  269 */             pixmap = PixmapIO.readCIM(fileHandle1);
/*  270 */             b1 = 0;
/*  271 */             a.i("loaded merged atlas from cache", new Object[0]);
/*      */           } else {
/*  273 */             a.i("cached atlas hash mismatch: " + j + ", need " + i, new Object[0]);
/*      */           } 
/*      */         } else {
/*  276 */           a.i("cached atlas not found", new Object[0]);
/*      */         } 
/*  278 */       } catch (Exception exception) {
/*  279 */         a.e("failed to load cached merged atlas", new Object[] { exception });
/*      */       } 
/*      */       
/*  282 */       if (b1 != 0) {
/*      */         Texture texture;
/*      */ 
/*      */         
/*  286 */         if (!(texture = (Texture)((TextureAtlas)resourcePack.getLoadedAtlases().first()).getTextures().first()).getTextureData().isPrepared()) {
/*  287 */           texture.getTextureData().prepare();
/*      */         }
/*  289 */         (pixmap = texture.getTextureData().consumePixmap()).setBlending(Pixmap.Blending.None);
/*  290 */         pixmap.setFilter(Pixmap.Filter.BiLinear);
/*      */         
/*  292 */         ((TextureAtlas)resourcePack.getLoadedAtlases().first()).getTextures().remove(texture);
/*  293 */         texture.dispose();
/*      */         
/*  295 */         a.i("loaded old main pixmap at " + ((float)(Game.getRealTickCount() - l) * 0.001F) + "ms", new Object[0]);
/*      */         
/*  297 */         for (byte b5 = 1; b5 < this.b.size; b5++) {
/*      */           ResourcePack resourcePack1;
/*  299 */           if (((resourcePack1 = (ResourcePack)this.b.get(b5)).getLoadedAtlases()).size != 0) {
/*      */             Texture texture1;
/*  301 */             if (!(texture1 = (Texture)((TextureAtlas)resourcePack1.getLoadedAtlases().first()).getTextures().first()).getTextureData().isPrepared())
/*  302 */               texture1.getTextureData().prepare(); 
/*      */             Pixmap pixmap1;
/*  304 */             (pixmap1 = texture1.getTextureData().consumePixmap()).setBlending(Pixmap.Blending.None);
/*      */             
/*      */             ObjectMap objectMap;
/*  307 */             for (ObjectMap.Entries<ObjectMap.Entry> entries = (objectMap = resourcePack1.getTextureRegions()).iterator(); entries.hasNext(); ) {
/*  308 */               ObjectMap.Entry entry; ResourcePack.AtlasTextureRegion atlasTextureRegion2 = (ResourcePack.AtlasTextureRegion)(entry = entries.next()).value;
/*  309 */               ResourcePack.AtlasTextureRegion atlasTextureRegion1 = resourcePack.getTextureRegion((String)entry.key);
/*      */               
/*  311 */               pixmap.drawPixmap(pixmap1, atlasTextureRegion2.getRegionX(), atlasTextureRegion2.getRegionY(), atlasTextureRegion2.getRegionWidth(), atlasTextureRegion2.getRegionHeight(), atlasTextureRegion1.getRegionX(), atlasTextureRegion1.getRegionY(), atlasTextureRegion1.getRegionWidth(), atlasTextureRegion1.getRegionHeight());
/*      */             } 
/*      */             
/*  314 */             pixmap1.dispose();
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/*  319 */         PixmapIO.writeCIM(fileHandle1, pixmap);
/*  320 */         fileHandle2.writeString(i, false, "UTF-8");
/*  321 */         a.i("cache saved at " + ((float)(Game.getRealTickCount() - l) * 0.001F) + "ms", new Object[0]);
/*      */       } 
/*      */       
/*  324 */       if (pixmap != null) {
/*      */         Texture texture;
/*      */         
/*  327 */         (texture = new Texture(pixmap, Pixmap.Format.RGBA8888, false)).setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
/*  328 */         ((TextureAtlas)resourcePack.getLoadedAtlases().first()).getTextures().add(texture); ObjectMap.Entries<ObjectMap.Entry> entries;
/*  329 */         for (entries = resourcePack.getTextureRegions().iterator(); entries.hasNext();) {
/*  330 */           ((ResourcePack.AtlasTextureRegion)(entry = entries.next()).value).setTexture(texture);
/*      */         }
/*  332 */         for (entries = resourcePack.getTextureRegionSets().iterator(); entries.hasNext();) {
/*  333 */           for (Array.ArrayIterator<TextureRegion> arrayIterator = ((Array)(entry = entries.next()).value).iterator(); arrayIterator.hasNext();) {
/*  334 */             (textureRegion = arrayIterator.next()).setTexture(texture);
/*      */           }
/*      */         } 
/*      */         
/*  338 */         pixmap.dispose();
/*      */       } 
/*      */       
/*  341 */       a.i("merged resource pack atlasses in " + ((float)(Game.getRealTickCount() - l) * 0.001F) + "ms", new Object[0]);
/*      */ 
/*      */       
/*  344 */       for (byte b = 1; b < this.b.size; b++) {
/*  345 */         ((ResourcePack)this.b.get(b)).dispose();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  350 */     ObjectSet objectSet = new ObjectSet();
/*  351 */     byte b3 = 0; byte b4;
/*  352 */     for (b4 = 0; b4 < this.b.size; b4++) {
/*      */       ObjectMap objectMap;
/*  354 */       if ((objectMap = ((ResourcePack[])this.b.items)[b4].getTextureRegions()) != null) {
/*  355 */         for (ObjectMap.Entries<ObjectMap.Entry> entries = objectMap.iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = entries.next();
/*  356 */           if (objectSet.add(entry.key)) {
/*  357 */             b3++;
/*      */           } }
/*      */       
/*      */       }
/*      */     } 
/*  362 */     this.s = new RegionAliasCharPair[b3];
/*  363 */     b4 = 0;
/*  364 */     char c = '';
/*  365 */     for (ObjectSet.ObjectSetIterator<String> objectSetIterator = objectSet.iterator(); objectSetIterator.hasNext(); ) { String str = objectSetIterator.next();
/*  366 */       RegionAliasCharPair regionAliasCharPair = new RegionAliasCharPair((byte)0);
/*  367 */       this.s[b4++] = regionAliasCharPair;
/*  368 */       regionAliasCharPair.a = c = (char)(c + 1);
/*      */       
/*  370 */       regionAliasCharPair.b = (TextureRegion)getTextureRegion(str);
/*      */       
/*  372 */       int j = a(str);
/*  373 */       if (this.t.containsKey(j)) {
/*  374 */         a.e("already has region hash: " + str, new Object[0]);
/*      */       }
/*  376 */       this.t.put(j, regionAliasCharPair); }
/*      */ 
/*      */     
/*      */     TextureRegions textureRegions;
/*      */     
/*  381 */     (textureRegions = new TextureRegions()).blank = getTextureRegion("blank");
/*  382 */     textureRegions.tileOutlineActive = getTextureRegion("tile-outline-active");
/*  383 */     textureRegions.tileOutlineHover = getTextureRegion("tile-outline-hover");
/*  384 */     textureRegions.gateOutlineVerticalActive = getTextureRegion("gate-outline-vertical-active");
/*  385 */     textureRegions.gateOutlineVerticalHover = getTextureRegion("gate-outline-vertical-hover");
/*  386 */     textureRegions.gateOutlineHorizontalActive = getTextureRegion("gate-outline-horizontal-active");
/*  387 */     textureRegions.gateOutlineHorizontalHover = getTextureRegion("gate-outline-horizontal-hover");
/*  388 */     textureRegions.crosshairSmall = getTextureRegion("crosshair-small");
/*  389 */     textureRegions.muzzleFlash1 = getTextureRegion("muzzle-flash-1");
/*  390 */     textureRegions.muzzleFlash2 = getTextureRegion("muzzle-flash-2");
/*  391 */     textureRegions.muzzleFlashCompensator1 = getTextureRegion("muzzle-flash-compensator-1");
/*  392 */     textureRegions.muzzleFlashCompensator2 = getTextureRegion("muzzle-flash-compensator-2");
/*  393 */     textureRegions.muzzleFlashSmall = getTextureRegion("muzzle-flash-small");
/*  394 */     textureRegions.flyingPaper1_1 = getTextureRegion("flying-paper-1-1");
/*  395 */     textureRegions.flyingPaper1_2 = getTextureRegion("flying-paper-1-2");
/*  396 */     textureRegions.flyingPaper1_3 = getTextureRegion("flying-paper-1-3");
/*  397 */     textureRegions.flyingPaper1_4 = getTextureRegion("flying-paper-1-4");
/*  398 */     textureRegions.flyingPaper5_1 = getTextureRegion("flying-paper-5-1");
/*  399 */     textureRegions.flyingPaper20_1 = getTextureRegion("flying-paper-20-1");
/*  400 */     textureRegions.flyingPaper100_1 = getTextureRegion("flying-paper-100-1");
/*  401 */     textureRegions.smallCircle = getTextureRegion("small-circle");
/*  402 */     textureRegions.roundedSmallRect = getTextureRegion("rounded-small-rect");
/*  403 */     textureRegions.particlePentagon = getTextureRegion("particle-pentagon");
/*  404 */     textureRegions.iconSmokeBomb = getTextureRegion("icon-smoke-bomb");
/*  405 */     textureRegions.enemyDialog = getTextureRegion("enemy-dialog");
/*  406 */     textureRegions.iconOrgan = getTextureRegion("icon-organ");
/*  407 */     textureRegions.iconPickaxe = getTextureRegion("icon-pickaxe");
/*  408 */     textureRegions.iconLoop = getTextureRegion("icon-loop");
/*  409 */     textureRegions.bulletTraceThin = getTextureRegion("bullet-trace-thin");
/*  410 */     textureRegions.buffHealthBarIconPoison = getTextureRegion("buff-health-bar-icon-poison");
/*  411 */     textureRegions.buffHealthBarIconPoisonTwo = getTextureRegion("buff-health-bar-icon-poison-two");
/*  412 */     textureRegions.buffHealthBarIconPoisonThree = getTextureRegion("buff-health-bar-icon-poison-three");
/*  413 */     textureRegions.buffHealthBarIconFreezing = getTextureRegion("buff-health-bar-icon-freezing");
/*  414 */     textureRegions.buffHealthBarIconBurn = getTextureRegion("buff-health-bar-icon-burn");
/*  415 */     textureRegions.buffHealthBarIconBlizzard = getTextureRegion("buff-health-bar-icon-blizzard");
/*  416 */     textureRegions.buffHealthBarIconArmor = getTextureRegion("buff-health-bar-icon-armor");
/*  417 */     textureRegions.buffHealthBarIconSnowball = getTextureRegion("buff-health-bar-icon-snowball");
/*  418 */     textureRegions.buffHealthBarIconRegeneration = getTextureRegion("buff-health-bar-icon-regeneration");
/*  419 */     textureRegions.buffHealthBarIconBlastThrowBack = getTextureRegion("buff-health-bar-icon-blast-throw-back");
/*  420 */     textureRegions.buffHealthBarIconStun = getTextureRegion("buff-health-bar-icon-stun");
/*  421 */     textureRegions.buffHealthBarIconBonusCoins = getTextureRegion("buff-health-bar-icon-bonus-coins");
/*  422 */     textureRegions.buffHealthBarIconBonusXp = getTextureRegion("buff-health-bar-icon-bonus-xp");
/*  423 */     textureRegions.buffHealthBarIconDeathExplosion = getTextureRegion("buff-health-bar-icon-death-explosion");
/*  424 */     textureRegions.buffHealthBarIconChainReaction = getTextureRegion("buff-health-bar-icon-chain-reaction");
/*  425 */     textureRegions.buffHealthBarIconVulnerability = getTextureRegion("buff-health-bar-icon-vulnerability");
/*  426 */     textureRegions.buffHealthBarIconInvulnerability = getTextureRegion("buff-health-bar-icon-invulnerability");
/*  427 */     textureRegions.buffHealthBarIconSlipping = getTextureRegion("buff-health-bar-icon-slipping");
/*  428 */     textureRegions.buffHealthBarIconNoDamage = getTextureRegion("buff-health-bar-icon-no-damage");
/*  429 */     textureRegions.buffHealthBarIconNoBonusSystemPoints = getTextureRegion("buff-health-bar-icon-no-bonus-system-points");
/*  430 */     textureRegions.overloadImpulseA = getTextureRegion("overload-impulse-a");
/*  431 */     textureRegions.overloadImpulseB = getTextureRegion("overload-impulse-b");
/*  432 */     textureRegions.overloadImpulseC = getTextureRegion("overload-impulse-c");
/*  433 */     textureRegions.overloadImpulseD = getTextureRegion("overload-impulse-d");
/*  434 */     TextureRegions.a(textureRegions);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ParticleEffectPool getParticleEffectPool(String paramString) {
/*      */     ParticleEffectPool particleEffectPool;
/*  448 */     if ((particleEffectPool = (ParticleEffectPool)this.u.get(paramString, null)) == null) {
/*      */       ParticleEffect particleEffect;
/*  450 */       (particleEffect = new ParticleEffect()).load(Gdx.files.internal("particles/" + paramString), getBlankWhiteTextureRegion().getAtlas());
/*  451 */       particleEffect.setEmittersCleanUpBlendFunction(false);
/*      */       
/*  453 */       particleEffectPool = new ParticleEffectPool(particleEffect, 1, 512);
/*  454 */       this.u.put(paramString, particleEffectPool);
/*      */     } 
/*      */     
/*  457 */     return particleEffectPool;
/*      */   }
/*      */   
/*      */   public ParticleEffectPool getParticleEffectPoolWithTemplate(String paramString, ParticleEffect paramParticleEffect) {
/*      */     ParticleEffectPool particleEffectPool;
/*  462 */     if ((particleEffectPool = (ParticleEffectPool)this.u.get(paramString, null)) == null) {
/*  463 */       paramParticleEffect.setEmittersCleanUpBlendFunction(false);
/*      */       
/*  465 */       particleEffectPool = new ParticleEffectPool(paramParticleEffect, 1, 512);
/*  466 */       this.u.put(paramString, particleEffectPool);
/*      */     } 
/*      */     
/*  469 */     return particleEffectPool;
/*      */   }
/*      */   
/*      */   public static void clearCacheDir() {
/*      */     FileHandle fileHandle;
/*  474 */     if ((fileHandle = Gdx.files.local("cache")).isDirectory()) {
/*  475 */       fileHandle.deleteDirectory();
/*  476 */       a.i("cache dir removed", new Object[0]);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static FileHandle localOrInternalFile(String paramString) {
/*      */     FileHandle fileHandle;
/*  482 */     if ((fileHandle = Gdx.files.local(paramString)).exists()) return fileHandle;
/*      */     
/*  484 */     return Gdx.files.internal(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void a(WebTextureRegion paramWebTextureRegion, byte[] paramArrayOfbyte) {
/*  492 */     if (paramArrayOfbyte.length != 0) {
/*  493 */       a.i("got response " + paramArrayOfbyte.length + " " + paramWebTextureRegion.src, new Object[0]);
/*      */       
/*      */       Pixmap pixmap1;
/*  496 */       int i = (pixmap1 = new Pixmap(paramArrayOfbyte, 0, paramArrayOfbyte.length)).getWidth();
/*  497 */       int j = pixmap1.getHeight();
/*  498 */       int k = pixmap1.getWidth();
/*  499 */       int m = pixmap1.getHeight();
/*  500 */       if (!MathUtils.isPowerOfTwo(k)) {
/*  501 */         k = MathUtils.nextPowerOfTwo(k);
/*      */       }
/*  503 */       if (!MathUtils.isPowerOfTwo(m)) {
/*  504 */         m = MathUtils.nextPowerOfTwo(m);
/*      */       }
/*  506 */       if (k != pixmap1.getWidth() || m != pixmap1.getHeight()) {
/*  507 */         a.i("texture is not pot", new Object[0]);
/*      */         Pixmap pixmap;
/*  509 */         (pixmap = new Pixmap(k, m, Pixmap.Format.RGBA8888)).drawPixmap(pixmap1, 0, 0, pixmap1
/*  510 */             .getWidth(), pixmap1.getHeight(), 0, 0, pixmap1
/*  511 */             .getWidth(), pixmap1.getHeight());
/*      */         
/*  513 */         pixmap1.dispose();
/*  514 */         pixmap1 = pixmap;
/*      */       } 
/*  516 */       Pixmap pixmap2 = pixmap1;
/*  517 */       Threads.i().runOnMainThread(() -> {
/*      */             long l = Game.getRealTickCount();
/*      */             Texture texture = new Texture(paramPixmap, false);
/*      */             paramWebTextureRegion.setTexture(texture);
/*      */             paramWebTextureRegion.textureLoaded = true;
/*      */             paramWebTextureRegion.setRegion(0, 0, paramInt1, paramInt2);
/*      */             paramPixmap.dispose();
/*      */             texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
/*      */             if (Game.i.debugManager != null)
/*      */               Game.i.debugManager.registerFrameJob("WebTextureConstruct", Game.getRealTickCount() - l); 
/*      */           });
/*      */     } 
/*      */   }
/*      */   public WebTextureRegion loadWebTexture(String paramString) {
/*  531 */     return loadWebTexture(paramString, false);
/*      */   }
/*      */   public WebTextureRegion loadWebTexture(String paramString, boolean paramBoolean) {
/*      */     SoftReference<WebTextureRegion> softReference;
/*      */     WebTextureRegion webTextureRegion;
/*  536 */     if ((softReference = (SoftReference)this.v.get(paramString, null)) != null && (
/*      */       
/*  538 */       webTextureRegion = softReference.get()) != null) {
/*  539 */       return webTextureRegion;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  544 */     (webTextureRegion = new WebTextureRegion()).src = paramString;
/*  545 */     webTextureRegion.setRegion((TextureRegion)getTextureRegion("placeholder"));
/*  546 */     this.v.put(paramString, new SoftReference<>(webTextureRegion));
/*      */ 
/*      */     
/*  549 */     long l = 0L;
/*  550 */     String str = "cache/webtxt/" + StringFormatter.md5Hash(paramString);
/*  551 */     if (!paramBoolean) {
/*      */       
/*      */       try {
/*      */         
/*  555 */         l = Gdx.files.local(str).exists() ? Gdx.files.local(str).file().lastModified() : 0L;
/*  556 */       } catch (Exception exception) {}
/*      */     }
/*      */     
/*  559 */     if (Game.getTimestampMillis() - l < 172800000L) {
/*      */       Thread thread;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  574 */       (thread = new Thread(() -> { try { a(paramWebTextureRegion, Gdx.files.local(paramString1).readBytes()); return; } catch (Exception exception) { a.e("failed to load web texture from local cache - " + paramString1 + ", " + paramString2 + ", re-downloading", new Object[] { exception }); try { Gdx.files.local(paramString1).delete(); loadWebTexture(paramString2); return; } catch (Exception exception1) { a.e("failed to delete local cache file - " + paramString1, new Object[] { exception }); return; }  }  })).setDaemon(true);
/*  575 */       thread.start();
/*  576 */       CrashHandler.handleThreadExceptionsForgiving(thread);
/*      */     } else {
/*      */       
/*  579 */       Throwable throwable = new Throwable();
/*  580 */       Game.i.httpManager.get(paramString)
/*  581 */         .listener((paramBoolean1, paramHttpResponse, paramBoolean2, paramThrowable2) -> {
/*      */             if (paramBoolean1) {
/*      */               byte[] arrayOfByte = paramHttpResponse.getResult();
/*      */               try {
/*      */                 a(paramWebTextureRegion, arrayOfByte);
/*      */                 Gdx.files.local(paramString1).writeBytes(arrayOfByte, false);
/*  587 */               } catch (Exception exception) {
/*      */                 a.e("failed to create web texture from " + paramString2, new Object[] { exception });
/*      */                 a.e("Request stacktrace for " + paramString2, new Object[] { paramThrowable1 });
/*      */                 return;
/*      */               } 
/*      */             } else {
/*      */               if (paramThrowable2 != null) {
/*      */                 a.e("request error", new Object[] { paramThrowable2 });
/*      */               }
/*      */               a.e("failed to load web texture " + paramString2, new Object[] { paramThrowable1 });
/*      */             } 
/*  598 */           }).send();
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  603 */     return webTextureRegion;
/*      */   }
/*      */   
/*      */   public void getModel(String paramString, ObjectConsumer<Model> paramObjectConsumer) {
/*      */     Model model;
/*  608 */     if ((model = this.r.get(paramString)) != null) {
/*  609 */       paramObjectConsumer.accept(model);
/*      */     }
/*      */     
/*  612 */     Threads.i().runAsync(() -> {
/*      */           a.i("loading model " + paramString + " on " + Thread.currentThread().getName(), new Object[0]);
/*      */ 
/*      */           
/*      */           try {
/*      */             UBJsonReader uBJsonReader = new UBJsonReader();
/*      */ 
/*      */             
/*      */             G3dModelLoader g3dModelLoader;
/*      */ 
/*      */             
/*      */             ModelData modelData = (g3dModelLoader = new G3dModelLoader((BaseJsonReader)uBJsonReader)).loadModelData(Gdx.files.internal(paramString), null);
/*      */ 
/*      */             
/*      */             Threads.i().runOnMainThread(());
/*      */             
/*      */             return;
/*  629 */           } catch (Exception exception) {
/*      */             a.e("failed loading " + paramString, new Object[] { exception });
/*      */             paramObjectConsumer.accept(null);
/*      */             return;
/*      */           } 
/*      */         });
/*      */   }
/*      */   public Model getSceneModelIfLoaded() {
/*  637 */     return this.g;
/*      */   }
/*      */   
/*      */   public void getSceneModel(ObjectConsumer<Model> paramObjectConsumer) {
/*  641 */     if (this.g == null) {
/*  642 */       if (!Game.i.settingsManager.isThreeDeeModelsEnabled()) {
/*  643 */         paramObjectConsumer.accept(null); return;
/*      */       } 
/*  645 */       getModel("models/scene.g3db", paramModel -> {
/*      */             for (byte b = 0; b < paramModel.materials.size; b++) {
/*      */               Material material;
/*      */               
/*      */               if ((material = (Material)paramModel.materials.get(b)).id.equals("normal")) {
/*      */                 this.normalMaterial = material;
/*      */               } else if (material.id.equals("blended")) {
/*      */                 this.blendedMaterial = material;
/*      */               } 
/*      */               
/*      */               material.remove(ColorAttribute.Emissive);
/*      */             } 
/*      */             
/*      */             if (this.normalMaterial != null) {
/*      */               this.normalMaterial.set((Attribute)new IntAttribute(IntAttribute.CullFace, 0));
/*      */             }
/*      */             
/*      */             this.blendedMaterial.set((Attribute)new BlendingAttribute(770, 1));
/*      */             
/*      */             this.blendedMaterial.set((Attribute)new DepthTestAttribute(false));
/*      */             this.blendedMaterial.set((Attribute)new IntAttribute(IntAttribute.CullFace, 0));
/*      */             this.blendedMaterial.set((Attribute)new ColorAttribute(ColorAttribute.Specular, 0.0F, 0.0F, 0.0F, 0.0F));
/*      */             this.blendedMaterial.set((Attribute)new ColorAttribute(ColorAttribute.Emissive, 0.1F, 0.1F, 0.1F, 1.0F));
/*      */             this.blendedMaterial.set((Attribute)ColorAttribute.createAmbient(0.0F, 1.0F, 0.0F, 1.0F));
/*      */             this.g = paramModel;
/*      */             paramObjectConsumer.accept(this.g);
/*      */           });
/*      */       return;
/*      */     } 
/*  674 */     paramObjectConsumer.accept(this.g);
/*      */   }
/*      */ 
/*      */   
/*      */   private int a(CharSequence paramCharSequence) {
/*  679 */     return a(paramCharSequence, 0, paramCharSequence.length());
/*      */   }
/*      */ 
/*      */   
/*      */   private static int a(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  684 */     int i = 1;
/*  685 */     for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/*  686 */       i = i * 31 + paramCharSequence.charAt(paramInt1);
/*      */     }
/*      */     
/*  689 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CharSequence replaceRegionAliasesWithChars(CharSequence paramCharSequence) {
/*  696 */     boolean bool = false;
/*      */     
/*  698 */     w.setLength(0);
/*  699 */     int i = 0;
/*  700 */     for (int j = 0, k = paramCharSequence.length(); j < k; j++) {
/*      */       char c;
/*  702 */       if ((c = paramCharSequence.charAt(j)) == '<') {
/*  703 */         i = 1;
/*      */       } else {
/*  705 */         int m; if (i) {
/*  706 */           if (c == '@') {
/*      */             
/*  708 */             i = j + 1;
/*  709 */             m = -1; int n;
/*  710 */             for (n = i; n < k; n++) {
/*      */               char c1;
/*  712 */               if ((c1 = paramCharSequence.charAt(n)) == '>') {
/*      */                 
/*  714 */                 m = n;
/*      */                 break;
/*      */               } 
/*      */             } 
/*  718 */             if (m != -1) {
/*      */               
/*  720 */               n = a(paramCharSequence, i, m);
/*      */               RegionAliasCharPair regionAliasCharPair;
/*  722 */               if ((regionAliasCharPair = (RegionAliasCharPair)this.t.get(n)) != null) {
/*      */                 
/*  724 */                 w.append(regionAliasCharPair.a);
/*  725 */                 j = m;
/*      */                 
/*  727 */                 bool = true;
/*      */               } else {
/*      */                 
/*  730 */                 w.append("<@");
/*      */               } 
/*      */             } else {
/*      */               
/*  734 */               w.append("<@");
/*      */             } 
/*      */           } else {
/*      */             
/*  738 */             w.append('<').append(m);
/*      */           } 
/*      */         } else {
/*  741 */           w.append(m);
/*      */         } 
/*      */         
/*  744 */         i = 0;
/*      */       } 
/*      */     } 
/*      */     
/*  748 */     if (!bool) return paramCharSequence;
/*      */     
/*  750 */     return (CharSequence)w;
/*      */   }
/*      */   
/*      */   public void addRegionCharsToFont(BitmapFont paramBitmapFont, int paramInt) {
/*      */     RegionAliasCharPair[] arrayOfRegionAliasCharPair;
/*      */     int i;
/*      */     byte b;
/*  757 */     for (i = (arrayOfRegionAliasCharPair = this.s).length, b = 0; b < i; ) { RegionAliasCharPair regionAliasCharPair = arrayOfRegionAliasCharPair[b];
/*      */ 
/*      */       
/*      */       BitmapFont.Glyph glyph;
/*      */       
/*  762 */       (glyph = new BitmapFont.Glyph()).id = regionAliasCharPair.a;
/*  763 */       glyph.srcX = 0;
/*  764 */       glyph.srcY = 0;
/*  765 */       glyph.width = regionAliasCharPair.b.getRegionWidth();
/*  766 */       glyph.height = regionAliasCharPair.b.getRegionHeight();
/*  767 */       paramBitmapFont.getData().setGlyph(regionAliasCharPair.a, glyph);
/*  768 */       paramBitmapFont.getData().setGlyphRegion(glyph, regionAliasCharPair.b);
/*  769 */       glyph.width = paramInt;
/*  770 */       glyph.height = paramInt;
/*  771 */       glyph.xadvance = paramInt + 2 + 4;
/*  772 */       glyph.yoffset = (paramBitmapFont.getData().getFirstGlyph()).yoffset;
/*  773 */       glyph.xoffset = 2;
/*      */       b++; }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b() {
/*      */     IntArray intArray;
/*  785 */     (intArray = new IntArray()).add(21, 24, 30, 36);
/*  786 */     intArray.add(60);
/*  787 */     for (byte b = 0; b < intArray.size; b++) {
/*  788 */       int i = intArray.items[b];
/*  789 */       ResourcePack.ResourcePackBitmapFont resourcePackBitmapFont = getFont(i);
/*  790 */       float f = i / resourcePackBitmapFont.resourcePack.fontResolution * Game.i.assetManager.getFontScaleMultiplier(i);
/*  791 */       if ((resourcePackBitmapFont.getData()).scaleX != f) {
/*  792 */         a.i("=== fixing font scale of size " + i + ", changing font scale from " + (resourcePackBitmapFont.getData()).scaleX + " to " + f, new Object[0]);
/*  793 */         resourcePackBitmapFont.getData().setScale(f);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setup() {
/*  800 */     Game.i.settingsManager.addListener(new SettingsManager.SettingsManagerListener.SettingsManagerListenerAdapter(this)
/*      */         {
/*      */           public void settingsChanged() {
/*  803 */             AssetManager.a(this.a);
/*      */           }
/*      */         });
/*  806 */     b();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float getFontScaleMultiplier(int paramInt) {
/*  813 */     if (Game.i.settingsManager.isLargeFontsEnabled()) {
/*  814 */       if (paramInt <= 21)
/*  815 */         return 1.33F; 
/*  816 */       if (paramInt <= 24) {
/*  817 */         return 1.2F;
/*      */       }
/*  819 */       return 1.1F;
/*      */     } 
/*      */     
/*  822 */     return 1.0F;
/*      */   }
/*      */ 
/*      */   
/*      */   public Color getColor(String paramString) {
/*  827 */     for (int i = this.b.size - 1; i >= 0; i--) {
/*      */       Color color;
/*  829 */       if ((color = ((ResourcePack[])this.b.items)[i].getColor(paramString)) != null) return color;
/*      */     
/*      */     } 
/*  832 */     throw new IllegalArgumentException("Color '" + paramString + "' was not found in any of loaded resource packs");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Quad getQuad(String paramString) {
/*  839 */     for (int i = this.b.size - 1; i >= 0; i--) {
/*      */       Quad quad;
/*  841 */       if ((quad = ((ResourcePack[])this.b.items)[i].getQuad(paramString)) != null) return quad; 
/*      */     } 
/*  843 */     return Quad.getNoQuad();
/*      */   }
/*      */   @Null
/*      */   public Quad getQuadOrNull(String paramString) {
/*      */     Quad quad;
/*  848 */     if ((quad = getQuad(paramString)) == Quad.getNoQuad()) {
/*  849 */       return null;
/*      */     }
/*  851 */     return quad;
/*      */   }
/*      */ 
/*      */   
/*      */   public ResourcePack.AtlasTextureRegion getTextureRegion(String paramString) {
/*  856 */     return getTextureRegionSetThrowing(paramString, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResourcePack.AtlasTextureRegion getTextureRegionSetThrowing(String paramString, boolean paramBoolean) {
/*      */     ResourcePack.AtlasTextureRegion atlasTextureRegion;
/*  865 */     if ((atlasTextureRegion = ((ResourcePack)this.b.first()).getTextureRegion(paramString)) != null) {
/*  866 */       return atlasTextureRegion;
/*      */     }
/*      */     
/*  869 */     if (paramBoolean) {
/*  870 */       throw new IllegalArgumentException("Texture region '" + paramString + "' was not found in any of loaded resource packs");
/*      */     }
/*  872 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Array<ResourcePack.AtlasTextureRegion> getTextureRegions(String paramString) {
/*      */     Array<ResourcePack.AtlasTextureRegion> array;
/*  882 */     if ((array = ((ResourcePack)this.b.first()).getTextureRegionSet(paramString)) != null) {
/*  883 */       return array;
/*      */     }
/*      */     
/*  886 */     throw new IllegalArgumentException("Texture region '" + paramString + "' was not found in any of loaded resource packs");
/*      */   }
/*      */   
/*      */   public Label.LabelStyle getLabelStyle(int paramInt) {
/*  890 */     if (this.d.containsKey(paramInt)) {
/*  891 */       return (Label.LabelStyle)this.d.get(paramInt);
/*      */     }
/*  893 */     Label.LabelStyle labelStyle = new Label.LabelStyle((BitmapFont)getFont(paramInt), Color.WHITE);
/*  894 */     this.d.put(paramInt, labelStyle);
/*      */     
/*  896 */     return labelStyle;
/*      */   }
/*      */ 
/*      */   
/*      */   public Window.WindowStyle createDefaultWindowStyle() {
/*      */     Window.WindowStyle windowStyle;
/*  902 */     (windowStyle = new Window.WindowStyle()).catchAllTouches = true;
/*  903 */     windowStyle.background = (Drawable)getQuad("ui.window.default.background");
/*  904 */     windowStyle.headerBackground = (Drawable)getQuad("ui.window.default.header");
/*  905 */     windowStyle.scrollPaneStyle = null;
/*      */     Label.LabelStyle labelStyle;
/*  907 */     (labelStyle = new Label.LabelStyle(getLabelStyle(21))).fontColor = new Color(1.0F, 1.0F, 1.0F, 0.78F);
/*  908 */     windowStyle.titleLabelStyle = labelStyle;
/*  909 */     windowStyle.resizeable = false;
/*  910 */     windowStyle.draggable = true;
/*  911 */     windowStyle.resizeHasMinSize = true;
/*  912 */     windowStyle.alwaysOnTop = false;
/*  913 */     windowStyle.inheritWidgetMinSize = true;
/*  914 */     windowStyle.closeButton = (Drawable)getQuad("ui.window.default.closeButton");
/*  915 */     windowStyle.closeButtonColor = PackColor.fromColors(new Color[] { Color.WHITE, MaterialColor.RED.P500, MaterialColor.RED.P700 });
/*      */     
/*      */     Drawable drawable1;
/*  918 */     (drawable1 = (new TextureRegionDrawable((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).tint(new Color(0.0F, 0.0F, 0.0F, 0.28F))).setMinWidth(12.0F);
/*  919 */     drawable1.setMinHeight(12.0F);
/*      */     Drawable drawable2;
/*  921 */     (drawable2 = (new TextureRegionDrawable((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).tint(new Color(1044266751))).setMinWidth(12.0F);
/*  922 */     drawable2.setMinHeight(12.0F);
/*  923 */     windowStyle.scrollPaneStyle = new ScrollPane.ScrollPaneStyle(null, drawable1, drawable2, drawable1, drawable2);
/*      */     
/*  925 */     return windowStyle;
/*      */   }
/*      */   
/*      */   public TextField.TextFieldStyle getTextFieldStyle(int paramInt) {
/*  929 */     return getTextFieldStyleWithFontAndVariant((BitmapFont)getFontWithMarkup(paramInt, false), true);
/*      */   }
/*      */   
/*      */   public TextField.TextFieldStyle getTextFieldStyleWithVariant(int paramInt, boolean paramBoolean) {
/*  933 */     return getTextFieldStyleWithFontAndVariant((BitmapFont)getFontWithMarkup(paramInt, false), paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextField.TextFieldStyle getTextFieldStyleWithFontAndVariant(BitmapFont paramBitmapFont, boolean paramBoolean) {
/*      */     TextField.TextFieldStyle textFieldStyle;
/*  944 */     (textFieldStyle = new TextField.TextFieldStyle(paramBitmapFont, Color.BLACK, (new TextureRegionDrawable((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).tint(Color.BLACK), (new TextureRegionDrawable((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).tint(MaterialColor.BLUE.P400), (Drawable)new Quad(getQuad(paramBoolean ? "ui.textField.lowPolyA.background" : "ui.textField.lowPolyB.background"), true))).cursor.setMinWidth(2.0F);
/*  945 */     textFieldStyle.background.setLeftWidth(textFieldStyle.background.getLeftWidth() + 14.0F);
/*  946 */     textFieldStyle.background.setRightWidth(textFieldStyle.background.getRightWidth() + 14.0F);
/*  947 */     textFieldStyle.background.setBottomHeight(textFieldStyle.background.getBottomHeight() + 8.0F);
/*  948 */     textFieldStyle.background.setTopHeight(textFieldStyle.background.getTopHeight() + 8.0F);
/*      */     
/*  950 */     return textFieldStyle;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SelectBox.SelectBoxStyle getSelectBoxStyle(BitmapFont paramBitmapFont, boolean paramBoolean) {
/*      */     List.ListStyle listStyle;
/*  960 */     (listStyle = new List.ListStyle(paramBitmapFont, Color.WHITE, new Color(1.0F, 1.0F, 1.0F, 0.78F), (Drawable)new Quad(Game.i.assetManager.getQuad("ui.selectBox.selection"), true))).down = (Drawable)new Quad(Game.i.assetManager.getQuad("ui.selectBox.down"), true);
/*  961 */     listStyle.over = (Drawable)new Quad(Game.i.assetManager.getQuad("ui.selectBox.over"), true);
/*  962 */     listStyle.background = (Drawable)new Quad(Game.i.assetManager.getQuad("ui.selectBox.listBackground"), true);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     SelectBox.SelectBoxStyle selectBoxStyle;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  978 */     return selectBoxStyle = new SelectBox.SelectBoxStyle(paramBitmapFont, Color.BLACK, (Drawable)new Quad(getQuad(paramBoolean ? "ui.selectBox.lowPolyA.background" : "ui.selectBox.lowPolyB.background"), true), new ScrollPane.ScrollPaneStyle((Drawable)new Quad(Game.i.assetManager.getQuad("ui.selectBox.background"), true), (Drawable)new Quad(Game.i.assetManager.getQuad("ui.selectBox.hScroll"), true), (Drawable)new Quad(Game.i.assetManager.getQuad("ui.selectBox.hScrollKnob"), true), (Drawable)new Quad(Game.i.assetManager.getQuad("ui.selectBox.vScroll"), true), (Drawable)new Quad(Game.i.assetManager.getQuad("ui.selectBox.vScrollKnob"), true)), listStyle);
/*      */   }
/*      */   
/*      */   public Label.LabelStyle getDebugLabelStyle() {
/*  982 */     if (this.e == null) {
/*  983 */       this.e = new Label.LabelStyle(getDebugFont(true), Color.WHITE);
/*      */     }
/*      */     
/*  986 */     return this.e;
/*      */   }
/*      */   
/*      */   public Label.LabelStyle getSmallDebugLabelStyle() {
/*  990 */     if (this.f == null) {
/*  991 */       this.f = new Label.LabelStyle(getSmallDebugFont(), Color.WHITE);
/*      */     }
/*      */     
/*  994 */     return this.f;
/*      */   }
/*      */   
/*      */   public ScrollPane.ScrollPaneStyle getScrollPaneStyle(float paramFloat) {
/*      */     Drawable drawable1;
/*  999 */     (drawable1 = (new TextureRegionDrawable((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).tint(new Color(0.0F, 0.0F, 0.0F, 0.28F))).setMinWidth(paramFloat);
/*      */     Drawable drawable2;
/* 1001 */     (drawable2 = (new TextureRegionDrawable((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).tint(new Color(1044266751))).setMinWidth(paramFloat);
/* 1002 */     return new ScrollPane.ScrollPaneStyle(null, null, null, drawable1, drawable2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TextureRegionDrawable getDrawable(String paramString) {
/* 1009 */     if (this.c.containsKey(paramString)) {
/* 1010 */       return (TextureRegionDrawable)this.c.get(paramString);
/*      */     }
/* 1012 */     TextureRegionDrawable textureRegionDrawable = new TextureRegionDrawable((TextureRegion)getTextureRegion(paramString));
/* 1013 */     this.c.put(paramString, textureRegionDrawable);
/*      */     
/* 1015 */     return textureRegionDrawable;
/*      */   }
/*      */ 
/*      */   
/*      */   public Drawable getOverlayBackground() {
/* 1020 */     return (new TextureRegionDrawable((TextureRegion)getBlankWhiteTextureRegion())).tint(new Color(387389354));
/*      */   }
/*      */   
/*      */   public ResourcePack.AtlasTextureRegion getBlankWhiteTextureRegion() {
/* 1024 */     for (int i = this.b.size - 1; i >= 0; i--) {
/*      */       ResourcePack.AtlasTextureRegion atlasTextureRegion;
/* 1026 */       if ((atlasTextureRegion = ((ResourcePack[])this.b.items)[i].getBlankWhiteTextureRegion()) != null) return atlasTextureRegion;
/*      */     
/*      */     } 
/* 1029 */     throw new IllegalArgumentException("Blank texture was not found in any of loaded resource packs");
/*      */   }
/*      */   
/*      */   public BitmapFont getDamageNumbersOverTimeFont() {
/* 1033 */     if (this.o == null) {
/* 1034 */       this.o = new BitmapFont(Gdx.files.internal("resourcepacks/default/font-damage-over-time.fnt"), (TextureRegion)getTextureRegion("font-damage-over-time"));
/*      */     }
/* 1036 */     return this.o;
/*      */   }
/*      */   
/*      */   public BitmapFont getDamageNumbersEspeciallyEffectiveFont() {
/* 1040 */     if (this.p == null) {
/* 1041 */       this.p = new BitmapFont(Gdx.files.internal("resourcepacks/default/font-damage-especially-effective.fnt"), (TextureRegion)getTextureRegion("font-damage-especially-effective"));
/*      */     }
/* 1043 */     return this.p;
/*      */   }
/*      */   
/*      */   public BitmapFont getDamageNumbersFont() {
/* 1047 */     if (this.n == null) {
/* 1048 */       this.n = new BitmapFont(Gdx.files.internal("resourcepacks/default/font-damage-regular.fnt"), (TextureRegion)getTextureRegion("font-damage-regular"));
/*      */     }
/* 1050 */     return this.n;
/*      */   }
/*      */   
/*      */   public BitmapFont getDebugFont(boolean paramBoolean) {
/* 1054 */     if (paramBoolean) {
/* 1055 */       if (this.h == null) {
/* 1056 */         this.h = new BitmapFont(Gdx.files.internal("resourcepacks/default/debug.fnt"), (TextureRegion)getTextureRegion("font-debug"));
/* 1057 */         (this.h.getData()).markupEnabled = true;
/* 1058 */         this.h.setFixedWidthGlyphs("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_-=+[]\\/?.,`:;'\"<>| ");
/*      */       } 
/*      */       
/* 1061 */       return this.h;
/*      */     } 
/* 1063 */     if (this.i == null) {
/* 1064 */       this.i = new BitmapFont(Gdx.files.internal("resourcepacks/default/debug.fnt"), (TextureRegion)getTextureRegion("font-debug"));
/* 1065 */       (this.i.getData()).markupEnabled = false;
/* 1066 */       this.i.setFixedWidthGlyphs("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_-=+[]\\/?.,`:;'\"<>| ");
/*      */     } 
/*      */     
/* 1069 */     return this.i;
/*      */   }
/*      */ 
/*      */   
/*      */   public BitmapFont getLargeDebugFont(boolean paramBoolean) {
/* 1074 */     if (paramBoolean) {
/* 1075 */       if (this.j == null) {
/* 1076 */         this.j = new BitmapFont(Gdx.files.internal("resourcepacks/default/debug.fnt"), (TextureRegion)getTextureRegion("font-debug"));
/* 1077 */         (this.j.getData()).markupEnabled = true;
/* 1078 */         this.j.setFixedWidthGlyphs("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_-=+[]\\/?.,`:;'\"<>| ");
/* 1079 */         this.j.getData().setScale(1.15F);
/* 1080 */         this.j.setUseIntegerPositions(false);
/*      */       } 
/*      */       
/* 1083 */       return this.j;
/*      */     } 
/* 1085 */     if (this.k == null) {
/* 1086 */       this.k = new BitmapFont(Gdx.files.internal("resourcepacks/default/debug.fnt"), (TextureRegion)getTextureRegion("font-debug"));
/* 1087 */       (this.k.getData()).markupEnabled = false;
/* 1088 */       this.k.setFixedWidthGlyphs("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_-=+[]\\/?.,`:;'\"<>| ");
/* 1089 */       this.k.getData().setScale(1.15F);
/* 1090 */       this.k.setUseIntegerPositions(false);
/*      */     } 
/*      */     
/* 1093 */     return this.k;
/*      */   }
/*      */ 
/*      */   
/*      */   public BitmapFont getSmallDebugFont() {
/* 1098 */     if (this.l == null) {
/* 1099 */       BitmapFont bitmapFont = getDebugFont(true);
/*      */       
/* 1101 */       this.l = new BitmapFont(Gdx.files.internal("resourcepacks/default/debug.fnt"), (TextureRegion)getTextureRegion("font-debug"));
/* 1102 */       this.l.getData().setScale(0.6667F);
/* 1103 */       (this.l.getData()).markupEnabled = true;
/* 1104 */       this.l.setUseIntegerPositions(false);
/*      */       
/* 1106 */       for (byte b = 0; b < (bitmapFont.getData()).glyphs.length; b++) {
/* 1107 */         (this.l.getData()).glyphs[b] = (bitmapFont.getData()).glyphs[b];
/*      */       }
/*      */     } 
/*      */     
/* 1111 */     return this.l;
/*      */   }
/*      */   
/*      */   public BitmapFont getSmallDebugFontNoMarkup() {
/* 1115 */     if (this.m == null) {
/* 1116 */       BitmapFont bitmapFont = getDebugFont(false);
/*      */       
/* 1118 */       this.m = new BitmapFont(Gdx.files.internal("resourcepacks/default/debug.fnt"), (TextureRegion)getTextureRegion("font-debug"));
/* 1119 */       this.m.getData().setScale(0.6667F);
/* 1120 */       (this.m.getData()).markupEnabled = false;
/* 1121 */       this.m.setUseIntegerPositions(false);
/*      */       
/* 1123 */       for (byte b = 0; b < (bitmapFont.getData()).glyphs.length; b++) {
/* 1124 */         (this.m.getData()).glyphs[b] = (bitmapFont.getData()).glyphs[b];
/*      */       }
/*      */     } 
/*      */     
/* 1128 */     return this.m;
/*      */   }
/*      */   
/*      */   public Texture getBannerTexture() {
/* 1132 */     if (this.q == null) {
/* 1133 */       this.q = new Texture(Gdx.files.internal("res/get-banner.png"), Pixmap.Format.RGBA8888, false);
/* 1134 */       this.q.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
/*      */     } 
/*      */     
/* 1137 */     return this.q;
/*      */   }
/*      */   
/*      */   public ResourcePack.ResourcePackBitmapFont getFont(int paramInt) {
/* 1141 */     return getFontWithMarkup(paramInt, true);
/*      */   }
/*      */   
/*      */   public ResourcePack.ResourcePackBitmapFont getFontWithMarkup(int paramInt, boolean paramBoolean) {
/* 1145 */     for (int i = this.b.size - 1; i >= 0; i--) {
/*      */       ResourcePack.ResourcePackBitmapFont resourcePackBitmapFont;
/* 1147 */       if ((resourcePackBitmapFont = ((ResourcePack[])this.b.items)[i].getFontWithMarkup(paramInt, paramBoolean)) != null) return resourcePackBitmapFont;
/*      */     
/*      */     } 
/* 1150 */     throw new IllegalArgumentException("Font with size " + paramInt + " was not found in any of loaded resource packs");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public StaticSound getSound(StaticSoundType paramStaticSoundType) {
/* 1157 */     for (int i = this.b.size - 1; i >= 0; i--) {
/*      */       ResourcePack resourcePack;
/* 1159 */       if ((resourcePack = ((ResourcePack[])this.b.items)[i]).hasSounds()) {
/* 1160 */         return resourcePack.getSound(paramStaticSoundType);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1165 */     return null;
/*      */   }
/*      */   
/*      */   public Module getMenuXmSoundTrack() {
/* 1169 */     for (int i = this.b.size - 1; i >= 0; i--) {
/*      */       ResourcePack resourcePack;
/*      */       Module module;
/* 1172 */       if ((module = (resourcePack = ((ResourcePack[])this.b.items)[i]).getMenuXmSoundTrack()) != null) {
/* 1173 */         return module;
/*      */       }
/*      */     } 
/*      */     
/* 1177 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void test() {}
/*      */ 
/*      */ 
/*      */   
/*      */   public void dispose() {
/* 1187 */     for (Array.ArrayIterator<ResourcePack> arrayIterator = this.b.iterator(); arrayIterator.hasNext();)
/* 1188 */       (resourcePack = arrayIterator.next()).dispose(); 
/*      */   }
/*      */   
/*      */   public static class WebTextureRegion
/*      */     extends TextureRegion
/*      */   {
/*      */     public String src;
/*      */     public boolean textureLoaded;
/*      */     
/*      */     public void finalize() {
/* 1198 */       super.finalize();
/*      */       
/* 1200 */       if (this.textureLoaded)
/*      */         try {
/* 1202 */           AssetManager.a().i("finalizing web texture", new Object[0]);
/* 1203 */           if (Game.i.isInMainThread()) {
/* 1204 */             AssetManager.a().i("disposing texture on main thread", new Object[0]);
/* 1205 */             getTexture().dispose();
/*      */           } else {
/* 1207 */             AssetManager.a().i("pushing runnable to dispose texture on main thread", new Object[0]);
/* 1208 */             Texture texture = getTexture();
/* 1209 */             Threads.i().runOnMainThread(() -> {
/*      */                   try {
/*      */                     param1Texture.dispose(); AssetManager.a().i("disposed web texture", new Object[0]);
/*      */                     return;
/* 1213 */                   } catch (Exception exception) {
/*      */                     AssetManager.a().e("failed to dispose texture in runnable", new Object[] { exception }); return;
/*      */                   } 
/*      */                 }); return;
/*      */           } 
/* 1218 */         } catch (Exception exception) {
/* 1219 */           AssetManager.a().e("failed to finalize web texture", new Object[] { exception });
/*      */         }  
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\AssetManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */