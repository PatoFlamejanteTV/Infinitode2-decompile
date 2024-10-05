/*     */ package com.badlogic.gdx.assets;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.assets.loaders.AssetLoader;
/*     */ import com.badlogic.gdx.assets.loaders.BitmapFontLoader;
/*     */ import com.badlogic.gdx.assets.loaders.CubemapLoader;
/*     */ import com.badlogic.gdx.assets.loaders.FileHandleResolver;
/*     */ import com.badlogic.gdx.assets.loaders.I18NBundleLoader;
/*     */ import com.badlogic.gdx.assets.loaders.MusicLoader;
/*     */ import com.badlogic.gdx.assets.loaders.ParticleEffectLoader;
/*     */ import com.badlogic.gdx.assets.loaders.PixmapLoader;
/*     */ import com.badlogic.gdx.assets.loaders.ShaderProgramLoader;
/*     */ import com.badlogic.gdx.assets.loaders.SkinLoader;
/*     */ import com.badlogic.gdx.assets.loaders.SoundLoader;
/*     */ import com.badlogic.gdx.assets.loaders.TextureAtlasLoader;
/*     */ import com.badlogic.gdx.assets.loaders.TextureLoader;
/*     */ import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
/*     */ import com.badlogic.gdx.audio.Music;
/*     */ import com.badlogic.gdx.audio.Sound;
/*     */ import com.badlogic.gdx.graphics.Cubemap;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.PolygonRegion;
/*     */ import com.badlogic.gdx.graphics.g2d.PolygonRegionLoader;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureAtlas;
/*     */ import com.badlogic.gdx.graphics.g3d.Model;
/*     */ import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
/*     */ import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleEffectLoader;
/*     */ import com.badlogic.gdx.graphics.glutils.ShaderProgram;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Skin;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.BaseJsonReader;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.I18NBundle;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.Logger;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectIntMap;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.badlogic.gdx.utils.TimeUtils;
/*     */ import com.badlogic.gdx.utils.UBJsonReader;
/*     */ import com.badlogic.gdx.utils.async.AsyncExecutor;
/*     */ import com.badlogic.gdx.utils.async.ThreadUtils;
/*     */ import com.badlogic.gdx.utils.reflect.ClassReflection;
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
/*     */ public class AssetManager
/*     */   implements Disposable
/*     */ {
/*  70 */   final ObjectMap<Class, ObjectMap<String, RefCountedContainer>> assets = new ObjectMap();
/*  71 */   final ObjectMap<String, Class> assetTypes = new ObjectMap();
/*  72 */   final ObjectMap<String, Array<String>> assetDependencies = new ObjectMap();
/*  73 */   final ObjectSet<String> injected = new ObjectSet();
/*     */   
/*  75 */   final ObjectMap<Class, ObjectMap<String, AssetLoader>> loaders = new ObjectMap();
/*  76 */   final Array<AssetDescriptor> loadQueue = new Array();
/*     */   
/*     */   final AsyncExecutor executor;
/*  79 */   final Array<AssetLoadingTask> tasks = new Array();
/*     */   
/*     */   AssetErrorListener listener;
/*     */   
/*     */   int loaded;
/*     */   int toLoad;
/*     */   int peakTasks;
/*     */   final FileHandleResolver resolver;
/*  87 */   Logger log = new Logger("AssetManager", 0);
/*     */ 
/*     */   
/*     */   public AssetManager() {
/*  91 */     this((FileHandleResolver)new InternalFileHandleResolver());
/*     */   }
/*     */ 
/*     */   
/*     */   public AssetManager(FileHandleResolver paramFileHandleResolver) {
/*  96 */     this(paramFileHandleResolver, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AssetManager(FileHandleResolver paramFileHandleResolver, boolean paramBoolean) {
/* 103 */     this.resolver = paramFileHandleResolver;
/* 104 */     if (paramBoolean) {
/* 105 */       setLoader(BitmapFont.class, (AssetLoader<BitmapFont, AssetLoaderParameters<BitmapFont>>)new BitmapFontLoader(paramFileHandleResolver));
/* 106 */       setLoader(Music.class, (AssetLoader<Music, AssetLoaderParameters<Music>>)new MusicLoader(paramFileHandleResolver));
/* 107 */       setLoader(Pixmap.class, (AssetLoader<Pixmap, AssetLoaderParameters<Pixmap>>)new PixmapLoader(paramFileHandleResolver));
/* 108 */       setLoader(Sound.class, (AssetLoader<Sound, AssetLoaderParameters<Sound>>)new SoundLoader(paramFileHandleResolver));
/* 109 */       setLoader(TextureAtlas.class, (AssetLoader<TextureAtlas, AssetLoaderParameters<TextureAtlas>>)new TextureAtlasLoader(paramFileHandleResolver));
/* 110 */       setLoader(Texture.class, (AssetLoader<Texture, AssetLoaderParameters<Texture>>)new TextureLoader(paramFileHandleResolver));
/* 111 */       setLoader(Skin.class, (AssetLoader<Skin, AssetLoaderParameters<Skin>>)new SkinLoader(paramFileHandleResolver));
/* 112 */       setLoader(ParticleEffect.class, (AssetLoader<ParticleEffect, AssetLoaderParameters<ParticleEffect>>)new ParticleEffectLoader(paramFileHandleResolver));
/* 113 */       setLoader(ParticleEffect.class, (AssetLoader<ParticleEffect, AssetLoaderParameters<ParticleEffect>>)new ParticleEffectLoader(paramFileHandleResolver));
/*     */       
/* 115 */       setLoader(PolygonRegion.class, (AssetLoader<PolygonRegion, AssetLoaderParameters<PolygonRegion>>)new PolygonRegionLoader(paramFileHandleResolver));
/* 116 */       setLoader(I18NBundle.class, (AssetLoader<I18NBundle, AssetLoaderParameters<I18NBundle>>)new I18NBundleLoader(paramFileHandleResolver));
/* 117 */       setLoader(Model.class, ".g3dj", (AssetLoader<Model, AssetLoaderParameters<Model>>)new G3dModelLoader((BaseJsonReader)new JsonReader(), paramFileHandleResolver));
/* 118 */       setLoader(Model.class, ".g3db", (AssetLoader<Model, AssetLoaderParameters<Model>>)new G3dModelLoader((BaseJsonReader)new UBJsonReader(), paramFileHandleResolver));
/* 119 */       setLoader(Model.class, ".obj", (AssetLoader<Model, AssetLoaderParameters<Model>>)new ObjLoader(paramFileHandleResolver));
/* 120 */       setLoader(ShaderProgram.class, (AssetLoader<ShaderProgram, AssetLoaderParameters<ShaderProgram>>)new ShaderProgramLoader(paramFileHandleResolver));
/* 121 */       setLoader(Cubemap.class, (AssetLoader<Cubemap, AssetLoaderParameters<Cubemap>>)new CubemapLoader(paramFileHandleResolver));
/*     */     } 
/* 123 */     this.executor = new AsyncExecutor(1, "AssetManager");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FileHandleResolver getFileHandleResolver() {
/* 129 */     return this.resolver;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized <T> T get(String paramString) {
/* 136 */     return get(paramString, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized <T> T get(String paramString, Class<T> paramClass) {
/* 144 */     return get(paramString, paramClass, true);
/*     */   }
/*     */   
/*     */   @Null
/*     */   public synchronized <T> T get(String paramString, boolean paramBoolean) {
/*     */     Class clazz;
/*     */     RefCountedContainer refCountedContainer;
/*     */     ObjectMap objectMap;
/* 152 */     if ((clazz = (Class)this.assetTypes.get(paramString)) != null && (
/*     */       
/* 154 */       objectMap = (ObjectMap)this.assets.get(clazz)) != null && (
/*     */       
/* 156 */       refCountedContainer = (RefCountedContainer)objectMap.get(paramString)) != null) return (T)refCountedContainer.object;
/*     */ 
/*     */     
/* 159 */     if (paramBoolean) throw new GdxRuntimeException("Asset not loaded: " + paramString); 
/* 160 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public synchronized <T> T get(String paramString, Class<T> paramClass, boolean paramBoolean) {
/*     */     ObjectMap objectMap;
/*     */     RefCountedContainer refCountedContainer;
/* 169 */     if ((objectMap = (ObjectMap)this.assets.get(paramClass)) != null && (
/*     */       
/* 171 */       refCountedContainer = (RefCountedContainer)objectMap.get(paramString)) != null) return (T)refCountedContainer.object;
/*     */     
/* 173 */     if (paramBoolean) throw new GdxRuntimeException("Asset not loaded: " + paramString); 
/* 174 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized <T> T get(AssetDescriptor<T> paramAssetDescriptor) {
/* 181 */     return get(paramAssetDescriptor.fileName, paramAssetDescriptor.type, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized <T> Array<T> getAll(Class<T> paramClass, Array<T> paramArray) {
/*     */     ObjectMap objectMap;
/* 188 */     if ((objectMap = (ObjectMap)this.assets.get(paramClass)) != null)
/* 189 */       for (ObjectMap.Values<RefCountedContainer> values = objectMap.values().iterator(); values.hasNext(); ) { RefCountedContainer refCountedContainer = values.next();
/* 190 */         paramArray.add(refCountedContainer.object); }
/*     */        
/* 192 */     return paramArray;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized boolean contains(String paramString) {
/* 197 */     if (this.tasks.size > 0 && ((AssetLoadingTask)this.tasks.first()).assetDesc.fileName.equals(paramString)) return true;
/*     */     
/* 199 */     for (byte b = 0; b < this.loadQueue.size; b++) {
/* 200 */       if (((AssetDescriptor)this.loadQueue.get(b)).fileName.equals(paramString)) return true; 
/*     */     } 
/* 202 */     return isLoaded(paramString);
/*     */   }
/*     */   
/*     */   public synchronized boolean contains(String paramString, Class<?> paramClass) {
/*     */     AssetDescriptor assetDescriptor;
/* 207 */     if (this.tasks.size > 0 && 
/*     */       
/* 209 */       (assetDescriptor = ((AssetLoadingTask)this.tasks.first()).assetDesc).type == paramClass && assetDescriptor.fileName.equals(paramString)) return true;
/*     */ 
/*     */     
/* 212 */     for (byte b = 0; b < this.loadQueue.size; b++) {
/*     */       AssetDescriptor assetDescriptor1;
/* 214 */       if ((assetDescriptor1 = (AssetDescriptor)this.loadQueue.get(b)).type == paramClass && assetDescriptor1.fileName.equals(paramString)) return true;
/*     */     
/*     */     } 
/* 217 */     return isLoaded(paramString, paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void unload(String paramString) {
/*     */     AssetLoadingTask assetLoadingTask;
/* 224 */     if (this.tasks.size > 0 && 
/*     */       
/* 226 */       (assetLoadingTask = (AssetLoadingTask)this.tasks.first()).assetDesc.fileName.equals(paramString)) {
/* 227 */       this.log.info("Unload (from tasks): " + paramString);
/* 228 */       assetLoadingTask.cancel = true;
/* 229 */       assetLoadingTask.unload();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 234 */     Class clazz = (Class)this.assetTypes.get(paramString);
/*     */ 
/*     */     
/* 237 */     byte b = -1;
/* 238 */     for (byte b1 = 0; b1 < this.loadQueue.size; b1++) {
/* 239 */       if (((AssetDescriptor)this.loadQueue.get(b1)).fileName.equals(paramString)) {
/* 240 */         b = b1;
/*     */         break;
/*     */       } 
/*     */     } 
/* 244 */     if (b != -1) {
/* 245 */       this.toLoad--;
/* 246 */       AssetDescriptor assetDescriptor = (AssetDescriptor)this.loadQueue.removeIndex(b);
/* 247 */       this.log.info("Unload (from queue): " + paramString);
/*     */ 
/*     */       
/* 250 */       if (clazz != null && assetDescriptor.params != null && assetDescriptor.params.loadedCallback != null) {
/* 251 */         assetDescriptor.params.loadedCallback.finishedLoading(this, assetDescriptor.fileName, assetDescriptor.type);
/*     */       }
/*     */       return;
/*     */     } 
/* 255 */     if (clazz == null) throw new GdxRuntimeException("Asset not loaded: " + paramString);
/*     */ 
/*     */     
/*     */     RefCountedContainer refCountedContainer;
/*     */     
/* 260 */     (refCountedContainer = (RefCountedContainer)((ObjectMap)this.assets.get(clazz)).get(paramString)).refCount--;
/* 261 */     if (refCountedContainer.refCount <= 0) {
/* 262 */       this.log.info("Unload (dispose): " + paramString);
/*     */ 
/*     */       
/* 265 */       if (refCountedContainer.object instanceof Disposable) ((Disposable)refCountedContainer.object).dispose();
/*     */ 
/*     */       
/* 268 */       this.assetTypes.remove(paramString);
/* 269 */       ((ObjectMap)this.assets.get(clazz)).remove(paramString);
/*     */     } else {
/* 271 */       this.log.info("Unload (decrement): " + paramString);
/*     */     } 
/*     */     
/*     */     Array array;
/* 275 */     if ((array = (Array)this.assetDependencies.get(paramString)) != null)
/* 276 */       for (Array.ArrayIterator<String> arrayIterator = array.iterator(); arrayIterator.hasNext(); ) { String str = arrayIterator.next();
/* 277 */         if (isLoaded(str)) unload(str);
/*     */          }
/*     */        
/* 280 */     if (refCountedContainer.refCount <= 0) this.assetDependencies.remove(paramString);
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized <T> boolean containsAsset(T paramT) {
/*     */     ObjectMap objectMap;
/* 287 */     if ((objectMap = (ObjectMap)this.assets.get(paramT.getClass())) == null) return false; 
/* 288 */     for (ObjectMap.Values<RefCountedContainer> values = objectMap.values().iterator(); values.hasNext();) {
/* 289 */       if ((refCountedContainer = values.next()).object == paramT || paramT.equals(refCountedContainer.object)) return true; 
/* 290 */     }  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized <T> String getAssetFileName(T paramT) {
/* 296 */     for (ObjectMap.Keys<Class<?>> keys = this.assets.keys().iterator(); keys.hasNext(); ) { Class clazz = keys.next();
/*     */       ObjectMap objectMap;
/* 298 */       for (ObjectMap.Entries<ObjectMap.Entry> entries = (objectMap = (ObjectMap)this.assets.get(clazz)).iterator(); entries.hasNext();) {
/*     */         
/* 300 */         if ((object = ((RefCountedContainer)(entry = entries.next()).value).object) == paramT || paramT.equals(object)) return (String)entry.key; 
/*     */       }  }
/*     */     
/* 303 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized boolean isLoaded(AssetDescriptor paramAssetDescriptor) {
/* 309 */     return isLoaded(paramAssetDescriptor.fileName);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized boolean isLoaded(String paramString) {
/* 315 */     if (paramString == null) return false; 
/* 316 */     return this.assetTypes.containsKey(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized boolean isLoaded(String paramString, Class paramClass) {
/*     */     ObjectMap objectMap;
/* 323 */     if ((objectMap = (ObjectMap)this.assets.get(paramClass)) == null) return false; 
/* 324 */     return (objectMap.get(paramString) != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> AssetLoader getLoader(Class<T> paramClass) {
/* 331 */     return getLoader(paramClass, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> AssetLoader getLoader(Class<T> paramClass, String paramString) {
/*     */     ObjectMap objectMap;
/* 341 */     if ((objectMap = (ObjectMap)this.loaders.get(paramClass)) == null || objectMap.size <= 0) return null; 
/* 342 */     if (paramString == null) return (AssetLoader)objectMap.get(""); 
/* 343 */     AssetLoader assetLoader = null;
/* 344 */     int i = -1;
/* 345 */     for (ObjectMap.Entries<ObjectMap.Entry> entries = objectMap.entries().iterator(); entries.hasNext();) {
/* 346 */       if (((String)(entry = entries.next()).key).length() > i && paramString.endsWith((String)entry.key)) {
/* 347 */         assetLoader = (AssetLoader)entry.value;
/* 348 */         i = ((String)entry.key).length();
/*     */       } 
/*     */     } 
/* 351 */     return assetLoader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized <T> void load(String paramString, Class<T> paramClass) {
/* 358 */     load(paramString, paramClass, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized <T> void load(String paramString, Class<T> paramClass, AssetLoaderParameters<T> paramAssetLoaderParameters) {
/*     */     AssetLoader assetLoader;
/* 367 */     if ((assetLoader = getLoader(paramClass, paramString)) == null) throw new GdxRuntimeException("No loader for type: " + ClassReflection.getSimpleName(paramClass));
/*     */ 
/*     */     
/* 370 */     if (this.loadQueue.size == 0) {
/* 371 */       this.loaded = 0;
/* 372 */       this.toLoad = 0;
/* 373 */       this.peakTasks = 0;
/*     */     } 
/*     */ 
/*     */     
/*     */     byte b;
/*     */     
/* 379 */     for (b = 0; b < this.loadQueue.size; b++) {
/*     */       AssetDescriptor assetDescriptor1;
/* 381 */       if ((assetDescriptor1 = (AssetDescriptor)this.loadQueue.get(b)).fileName.equals(paramString) && !assetDescriptor1.type.equals(paramClass)) throw new GdxRuntimeException("Asset with name '" + paramString + "' already in preload queue, but has different type (expected: " + 
/*     */             
/* 383 */             ClassReflection.getSimpleName(paramClass) + ", found: " + ClassReflection.getSimpleName(assetDescriptor1.type) + ")");
/*     */     
/*     */     } 
/*     */     
/* 387 */     for (b = 0; b < this.tasks.size; b++) {
/*     */       AssetDescriptor assetDescriptor1;
/* 389 */       if ((assetDescriptor1 = ((AssetLoadingTask)this.tasks.get(b)).assetDesc).fileName.equals(paramString) && !assetDescriptor1.type.equals(paramClass)) throw new GdxRuntimeException("Asset with name '" + paramString + "' already in task list, but has different type (expected: " + 
/*     */             
/* 391 */             ClassReflection.getSimpleName(paramClass) + ", found: " + ClassReflection.getSimpleName(assetDescriptor1.type) + ")");
/*     */     
/*     */     } 
/*     */     
/*     */     Class clazz;
/* 396 */     if ((clazz = (Class)this.assetTypes.get(paramString)) != null && !clazz.equals(paramClass)) {
/* 397 */       throw new GdxRuntimeException("Asset with name '" + paramString + "' already loaded, but has different type (expected: " + 
/* 398 */           ClassReflection.getSimpleName(paramClass) + ", found: " + ClassReflection.getSimpleName(clazz) + ")");
/*     */     }
/* 400 */     this.toLoad++;
/* 401 */     AssetDescriptor<T> assetDescriptor = new AssetDescriptor<>(paramString, paramClass, paramAssetLoaderParameters);
/* 402 */     this.loadQueue.add(assetDescriptor);
/* 403 */     this.log.debug("Queued: " + assetDescriptor);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void load(AssetDescriptor paramAssetDescriptor) {
/* 409 */     load(paramAssetDescriptor.fileName, paramAssetDescriptor.type, paramAssetDescriptor.params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized boolean update() {
/*     */     try {
/* 417 */       if (this.tasks.size == 0) {
/*     */         
/* 419 */         while (this.loadQueue.size != 0 && this.tasks.size == 0) {
/* 420 */           nextTask();
/*     */         }
/* 422 */         if (this.tasks.size == 0) return true; 
/*     */       } 
/* 424 */       return (updateTask() && this.loadQueue.size == 0 && this.tasks.size == 0);
/* 425 */     } catch (Throwable throwable) {
/* 426 */       handleTaskError(throwable);
/* 427 */       return (this.loadQueue.size == 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean update(int paramInt) {
/* 437 */     if (Gdx.app.getType() == Application.ApplicationType.WebGL) return update(); 
/* 438 */     long l = TimeUtils.millis() + paramInt;
/*     */     while (true) {
/*     */       boolean bool;
/* 441 */       if ((bool = update()) || TimeUtils.millis() > l) return bool; 
/* 442 */       ThreadUtils.yield();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized boolean isFinished() {
/* 449 */     return (this.loadQueue.size == 0 && this.tasks.size == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void finishLoading() {
/* 454 */     this.log.debug("Waiting for loading to complete...");
/* 455 */     while (!update())
/* 456 */       ThreadUtils.yield(); 
/* 457 */     this.log.debug("Loading complete.");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T finishLoadingAsset(AssetDescriptor paramAssetDescriptor) {
/* 463 */     return finishLoadingAsset(paramAssetDescriptor.fileName);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T finishLoadingAsset(String paramString) {
/* 469 */     this.log.debug("Waiting for asset to be loaded: " + paramString);
/*     */     while (true) {
/* 471 */       synchronized (this) {
/*     */         ObjectMap objectMap; Class clazz; RefCountedContainer refCountedContainer;
/* 473 */         if ((clazz = (Class)this.assetTypes.get(paramString)) != null && (
/*     */           
/* 475 */           objectMap = (ObjectMap)this.assets.get(clazz)) != null && (
/*     */           
/* 477 */           refCountedContainer = (RefCountedContainer)objectMap.get(paramString)) != null) {
/* 478 */           this.log.debug("Asset loaded: " + paramString);
/* 479 */           return (T)refCountedContainer.object;
/*     */         } 
/*     */ 
/*     */         
/* 483 */         update();
/*     */       } 
/* 485 */       ThreadUtils.yield();
/*     */     } 
/*     */   }
/*     */   
/*     */   synchronized void injectDependencies(String paramString, Array<AssetDescriptor> paramArray) {
/* 490 */     ObjectSet<String> objectSet = this.injected;
/* 491 */     for (Array.ArrayIterator<AssetDescriptor> arrayIterator = paramArray.iterator(); arrayIterator.hasNext(); ) { AssetDescriptor assetDescriptor = arrayIterator.next();
/* 492 */       if (!objectSet.contains(assetDescriptor.fileName)) {
/* 493 */         objectSet.add(assetDescriptor.fileName);
/* 494 */         injectDependency(paramString, assetDescriptor);
/*     */       }  }
/* 496 */      objectSet.clear(32);
/*     */   }
/*     */ 
/*     */   
/*     */   private synchronized void injectDependency(String paramString, AssetDescriptor paramAssetDescriptor) {
/*     */     Array array;
/* 502 */     if ((array = (Array)this.assetDependencies.get(paramString)) == null) {
/* 503 */       array = new Array();
/* 504 */       this.assetDependencies.put(paramString, array);
/*     */     } 
/* 506 */     array.add(paramAssetDescriptor.fileName);
/*     */ 
/*     */     
/* 509 */     if (isLoaded(paramAssetDescriptor.fileName)) {
/* 510 */       this.log.debug("Dependency already loaded: " + paramAssetDescriptor);
/* 511 */       Class clazz = (Class)this.assetTypes.get(paramAssetDescriptor.fileName);
/*     */       RefCountedContainer refCountedContainer;
/* 513 */       (refCountedContainer = (RefCountedContainer)((ObjectMap)this.assets.get(clazz)).get(paramAssetDescriptor.fileName)).refCount++;
/* 514 */       incrementRefCountedDependencies(paramAssetDescriptor.fileName);
/*     */       return;
/*     */     } 
/* 517 */     this.log.info("Loading dependency: " + paramAssetDescriptor);
/* 518 */     addTask(paramAssetDescriptor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void nextTask() {
/* 525 */     AssetDescriptor assetDescriptor = (AssetDescriptor)this.loadQueue.removeIndex(0);
/*     */ 
/*     */     
/* 528 */     if (isLoaded(assetDescriptor.fileName)) {
/* 529 */       this.log.debug("Already loaded: " + assetDescriptor);
/* 530 */       Class clazz = (Class)this.assetTypes.get(assetDescriptor.fileName);
/*     */       RefCountedContainer refCountedContainer;
/* 532 */       (refCountedContainer = (RefCountedContainer)((ObjectMap)this.assets.get(clazz)).get(assetDescriptor.fileName)).refCount++;
/* 533 */       incrementRefCountedDependencies(assetDescriptor.fileName);
/* 534 */       if (assetDescriptor.params != null && assetDescriptor.params.loadedCallback != null)
/* 535 */         assetDescriptor.params.loadedCallback.finishedLoading(this, assetDescriptor.fileName, assetDescriptor.type); 
/* 536 */       this.loaded++;
/*     */       return;
/*     */     } 
/* 539 */     this.log.info("Loading: " + assetDescriptor);
/* 540 */     addTask(assetDescriptor);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void addTask(AssetDescriptor paramAssetDescriptor) {
/*     */     AssetLoader assetLoader;
/* 547 */     if ((assetLoader = getLoader(paramAssetDescriptor.type, paramAssetDescriptor.fileName)) == null) throw new GdxRuntimeException("No loader for type: " + ClassReflection.getSimpleName(paramAssetDescriptor.type)); 
/* 548 */     this.tasks.add(new AssetLoadingTask(this, paramAssetDescriptor, assetLoader, this.executor));
/* 549 */     this.peakTasks++;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected <T> void addAsset(String paramString, Class<T> paramClass, T paramT) {
/* 555 */     this.assetTypes.put(paramString, paramClass);
/*     */     
/*     */     ObjectMap objectMap;
/*     */     
/* 559 */     if ((objectMap = (ObjectMap)this.assets.get(paramClass)) == null) {
/* 560 */       objectMap = new ObjectMap();
/* 561 */       this.assets.put(paramClass, objectMap);
/*     */     } 
/*     */     RefCountedContainer refCountedContainer;
/* 564 */     (refCountedContainer = new RefCountedContainer()).object = paramT;
/* 565 */     objectMap.put(paramString, refCountedContainer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean updateTask() {
/* 571 */     AssetLoadingTask assetLoadingTask = (AssetLoadingTask)this.tasks.peek();
/*     */     
/* 573 */     boolean bool = true;
/*     */     try {
/* 575 */       bool = (assetLoadingTask.cancel || assetLoadingTask.update()) ? true : false;
/* 576 */     } catch (RuntimeException runtimeException) {
/* 577 */       assetLoadingTask.cancel = true;
/* 578 */       taskFailed(assetLoadingTask.assetDesc, runtimeException);
/*     */     } 
/*     */ 
/*     */     
/* 582 */     if (bool) {
/*     */       
/* 584 */       if (this.tasks.size == 1) {
/* 585 */         this.loaded++;
/* 586 */         this.peakTasks = 0;
/*     */       } 
/* 588 */       this.tasks.pop();
/*     */       
/* 590 */       if (assetLoadingTask.cancel) return true;
/*     */       
/* 592 */       addAsset(assetLoadingTask.assetDesc.fileName, assetLoadingTask.assetDesc.type, assetLoadingTask.asset);
/*     */ 
/*     */       
/* 595 */       if (assetLoadingTask.assetDesc.params != null && assetLoadingTask.assetDesc.params.loadedCallback != null) {
/* 596 */         assetLoadingTask.assetDesc.params.loadedCallback.finishedLoading(this, assetLoadingTask.assetDesc.fileName, assetLoadingTask.assetDesc.type);
/*     */       }
/* 598 */       long l = TimeUtils.nanoTime();
/* 599 */       this.log.debug("Loaded: " + ((float)(l - assetLoadingTask.startTime) / 1000000.0F) + "ms " + assetLoadingTask.assetDesc);
/*     */       
/* 601 */       return true;
/*     */     } 
/* 603 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void taskFailed(AssetDescriptor paramAssetDescriptor, RuntimeException paramRuntimeException) {
/* 609 */     throw paramRuntimeException;
/*     */   }
/*     */   
/*     */   private void incrementRefCountedDependencies(String paramString) {
/*     */     Array array;
/* 614 */     if ((array = (Array)this.assetDependencies.get(paramString)) == null)
/*     */       return; 
/* 616 */     for (Array.ArrayIterator<String> arrayIterator = array.iterator(); arrayIterator.hasNext(); ) { String str = arrayIterator.next();
/* 617 */       Class clazz = (Class)this.assetTypes.get(str);
/*     */       RefCountedContainer refCountedContainer;
/* 619 */       (refCountedContainer = (RefCountedContainer)((ObjectMap)this.assets.get(clazz)).get(str)).refCount++;
/* 620 */       incrementRefCountedDependencies(str); }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void handleTaskError(Throwable paramThrowable) {
/* 627 */     this.log.error("Error loading asset.", paramThrowable);
/*     */     
/* 629 */     if (this.tasks.isEmpty()) throw new GdxRuntimeException(paramThrowable);
/*     */ 
/*     */     
/*     */     AssetLoadingTask assetLoadingTask;
/* 633 */     AssetDescriptor assetDescriptor = (assetLoadingTask = (AssetLoadingTask)this.tasks.pop()).assetDesc;
/*     */ 
/*     */     
/* 636 */     if (assetLoadingTask.dependenciesLoaded && assetLoadingTask.dependencies != null) {
/* 637 */       for (Array.ArrayIterator<AssetDescriptor> arrayIterator = assetLoadingTask.dependencies.iterator(); arrayIterator.hasNext(); ) { AssetDescriptor assetDescriptor1 = arrayIterator.next();
/* 638 */         unload(assetDescriptor1.fileName); }
/*     */     
/*     */     }
/*     */     
/* 642 */     this.tasks.clear();
/*     */ 
/*     */     
/* 645 */     if (this.listener != null) {
/* 646 */       this.listener.error(assetDescriptor, paramThrowable); return;
/*     */     } 
/* 648 */     throw new GdxRuntimeException(paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized <T, P extends AssetLoaderParameters<T>> void setLoader(Class<T> paramClass, AssetLoader<T, P> paramAssetLoader) {
/* 655 */     setLoader(paramClass, null, paramAssetLoader);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized <T, P extends AssetLoaderParameters<T>> void setLoader(Class<T> paramClass, String paramString, AssetLoader<T, P> paramAssetLoader) {
/* 664 */     if (paramClass == null) throw new IllegalArgumentException("type cannot be null."); 
/* 665 */     if (paramAssetLoader == null) throw new IllegalArgumentException("loader cannot be null."); 
/* 666 */     this.log.debug("Loader set: " + ClassReflection.getSimpleName(paramClass) + " -> " + ClassReflection.getSimpleName(paramAssetLoader.getClass()));
/*     */     ObjectMap objectMap;
/* 668 */     if ((objectMap = (ObjectMap)this.loaders.get(paramClass)) == null) this.loaders.put(paramClass, objectMap = new ObjectMap()); 
/* 669 */     objectMap.put((paramString == null) ? "" : paramString, paramAssetLoader);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized int getLoadedAssets() {
/* 674 */     return this.assetTypes.size;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized int getQueuedAssets() {
/* 679 */     return this.loadQueue.size + this.tasks.size;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized float getProgress() {
/* 684 */     if (this.toLoad == 0) return 1.0F; 
/* 685 */     float f = this.loaded;
/* 686 */     if (this.peakTasks > 0) {
/* 687 */       f += (this.peakTasks - this.tasks.size) / this.peakTasks;
/*     */     }
/* 689 */     return Math.min(1.0F, f / this.toLoad);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void setErrorListener(AssetErrorListener paramAssetErrorListener) {
/* 695 */     this.listener = paramAssetErrorListener;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 701 */     this.log.debug("Disposing.");
/* 702 */     clear();
/* 703 */     this.executor.dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 708 */     synchronized (this) {
/* 709 */       this.loadQueue.clear();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 715 */     finishLoading();
/*     */     
/* 717 */     synchronized (this) {
/* 718 */       ObjectIntMap objectIntMap = new ObjectIntMap();
/* 719 */       while (this.assetTypes.size > 0) {
/*     */         
/* 721 */         objectIntMap.clear(51); Array array;
/*     */         Array.ArrayIterator<String> arrayIterator;
/* 723 */         for (arrayIterator = (array = this.assetTypes.keys().toArray()).iterator(); arrayIterator.hasNext(); ) { String str = arrayIterator.next();
/*     */           Array array1;
/* 725 */           if ((array1 = (Array)this.assetDependencies.get(str)) != null) {
/* 726 */             for (Array.ArrayIterator<String> arrayIterator1 = array1.iterator(); arrayIterator1.hasNext(); ) { String str1 = arrayIterator1.next();
/* 727 */               objectIntMap.getAndIncrement(str1, 0, 1); }
/*     */           
/*     */           } }
/*     */         
/* 731 */         for (arrayIterator = array.iterator(); arrayIterator.hasNext(); ) { String str = arrayIterator.next();
/* 732 */           if (objectIntMap.get(str, 0) == 0) unload(str);  }
/*     */       
/*     */       } 
/* 735 */       this.assets.clear(51);
/* 736 */       this.assetTypes.clear(51);
/* 737 */       this.assetDependencies.clear(51);
/* 738 */       this.loaded = 0;
/* 739 */       this.toLoad = 0;
/* 740 */       this.peakTasks = 0;
/* 741 */       this.loadQueue.clear();
/* 742 */       this.tasks.clear();
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public Logger getLogger() {
/* 748 */     return this.log;
/*     */   }
/*     */   
/*     */   public void setLogger(Logger paramLogger) {
/* 752 */     this.log = paramLogger;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized int getReferenceCount(String paramString) {
/*     */     Class clazz;
/* 759 */     if ((clazz = (Class)this.assetTypes.get(paramString)) == null) throw new GdxRuntimeException("Asset not loaded: " + paramString); 
/* 760 */     return ((RefCountedContainer)((ObjectMap)this.assets.get(clazz)).get(paramString)).refCount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void setReferenceCount(String paramString, int paramInt) {
/*     */     Class clazz;
/* 767 */     if ((clazz = (Class)this.assetTypes.get(paramString)) == null) throw new GdxRuntimeException("Asset not loaded: " + paramString); 
/* 768 */     ((RefCountedContainer)((ObjectMap)this.assets.get(clazz)).get(paramString)).refCount = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized String getDiagnostics() {
/* 773 */     StringBuilder stringBuilder = new StringBuilder(256);
/* 774 */     for (ObjectMap.Entries<ObjectMap.Entry> entries = this.assetTypes.iterator(); entries.hasNext(); ) {
/* 775 */       ObjectMap.Entry entry; String str = (String)(entry = entries.next()).key;
/* 776 */       Class clazz = (Class)entry.value;
/*     */       
/* 778 */       if (stringBuilder.length() > 0) stringBuilder.append('\n'); 
/* 779 */       stringBuilder.append(str);
/* 780 */       stringBuilder.append(", ");
/* 781 */       stringBuilder.append(ClassReflection.getSimpleName(clazz));
/* 782 */       stringBuilder.append(", refs: ");
/* 783 */       stringBuilder.append(((RefCountedContainer)((ObjectMap)this.assets.get(clazz)).get(str)).refCount);
/*     */       
/*     */       Array array;
/* 786 */       if ((array = (Array)this.assetDependencies.get(str)) != null) {
/* 787 */         stringBuilder.append(", deps: [");
/* 788 */         for (Array.ArrayIterator<String> arrayIterator = array.iterator(); arrayIterator.hasNext(); ) { str = arrayIterator.next();
/* 789 */           stringBuilder.append(str);
/* 790 */           stringBuilder.append(','); }
/*     */         
/* 792 */         stringBuilder.append(']');
/*     */       } 
/*     */     } 
/* 795 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized Array<String> getAssetNames() {
/* 800 */     return this.assetTypes.keys().toArray();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized Array<String> getDependencies(String paramString) {
/* 805 */     return (Array<String>)this.assetDependencies.get(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized Class getAssetType(String paramString) {
/* 810 */     return (Class)this.assetTypes.get(paramString);
/*     */   }
/*     */   
/*     */   static class RefCountedContainer {
/*     */     Object object;
/* 815 */     int refCount = 1;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\assets\AssetManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */