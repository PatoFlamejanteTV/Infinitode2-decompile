/*     */ package com.badlogic.gdx.assets;
/*     */ 
/*     */ import com.badlogic.gdx.assets.loaders.AssetLoader;
/*     */ import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
/*     */ import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.TimeUtils;
/*     */ import com.badlogic.gdx.utils.async.AsyncExecutor;
/*     */ import com.badlogic.gdx.utils.async.AsyncResult;
/*     */ import com.badlogic.gdx.utils.async.AsyncTask;
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
/*     */ class AssetLoadingTask
/*     */   implements AsyncTask<Void>
/*     */ {
/*     */   AssetManager manager;
/*     */   final AssetDescriptor assetDesc;
/*     */   final AssetLoader loader;
/*     */   final AsyncExecutor executor;
/*     */   final long startTime;
/*     */   volatile boolean asyncDone;
/*     */   volatile boolean dependenciesLoaded;
/*     */   volatile Array<AssetDescriptor> dependencies;
/*     */   volatile AsyncResult<Void> depsFuture;
/*     */   volatile AsyncResult<Void> loadFuture;
/*     */   volatile Object asset;
/*     */   volatile boolean cancel;
/*     */   
/*     */   public AssetLoadingTask(AssetManager paramAssetManager, AssetDescriptor paramAssetDescriptor, AssetLoader paramAssetLoader, AsyncExecutor paramAsyncExecutor) {
/*  52 */     this.manager = paramAssetManager;
/*  53 */     this.assetDesc = paramAssetDescriptor;
/*  54 */     this.loader = paramAssetLoader;
/*  55 */     this.executor = paramAsyncExecutor;
/*  56 */     this.startTime = (paramAssetManager.log.getLevel() == 3) ? TimeUtils.nanoTime() : 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Void call() {
/*  62 */     if (this.cancel) return null; 
/*  63 */     AsynchronousAssetLoader asynchronousAssetLoader = (AsynchronousAssetLoader)this.loader;
/*  64 */     if (!this.dependenciesLoaded) {
/*  65 */       this.dependencies = asynchronousAssetLoader.getDependencies(this.assetDesc.fileName, resolve(this.loader, this.assetDesc), this.assetDesc.params);
/*  66 */       if (this.dependencies != null) {
/*  67 */         removeDuplicates(this.dependencies);
/*  68 */         this.manager.injectDependencies(this.assetDesc.fileName, this.dependencies);
/*     */       } else {
/*     */         
/*  71 */         asynchronousAssetLoader.loadAsync(this.manager, this.assetDesc.fileName, resolve(this.loader, this.assetDesc), this.assetDesc.params);
/*  72 */         this.asyncDone = true;
/*     */       } 
/*     */     } else {
/*  75 */       asynchronousAssetLoader.loadAsync(this.manager, this.assetDesc.fileName, resolve(this.loader, this.assetDesc), this.assetDesc.params);
/*  76 */       this.asyncDone = true;
/*     */     } 
/*  78 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean update() {
/*  88 */     if (this.loader instanceof SynchronousAssetLoader) {
/*  89 */       handleSyncLoader();
/*     */     } else {
/*  91 */       handleAsyncLoader();
/*  92 */     }  return (this.asset != null);
/*     */   }
/*     */   
/*     */   private void handleSyncLoader() {
/*  96 */     SynchronousAssetLoader synchronousAssetLoader = (SynchronousAssetLoader)this.loader;
/*  97 */     if (!this.dependenciesLoaded) {
/*  98 */       this.dependenciesLoaded = true;
/*  99 */       this.dependencies = synchronousAssetLoader.getDependencies(this.assetDesc.fileName, resolve(this.loader, this.assetDesc), this.assetDesc.params);
/* 100 */       if (this.dependencies == null) {
/* 101 */         this.asset = synchronousAssetLoader.load(this.manager, this.assetDesc.fileName, resolve(this.loader, this.assetDesc), this.assetDesc.params);
/*     */         return;
/*     */       } 
/* 104 */       removeDuplicates(this.dependencies);
/* 105 */       this.manager.injectDependencies(this.assetDesc.fileName, this.dependencies); return;
/*     */     } 
/* 107 */     this.asset = synchronousAssetLoader.load(this.manager, this.assetDesc.fileName, resolve(this.loader, this.assetDesc), this.assetDesc.params);
/*     */   }
/*     */   
/*     */   private void handleAsyncLoader() {
/* 111 */     AsynchronousAssetLoader asynchronousAssetLoader = (AsynchronousAssetLoader)this.loader;
/* 112 */     if (!this.dependenciesLoaded)
/* 113 */     { if (this.depsFuture == null) {
/* 114 */         this.depsFuture = this.executor.submit(this); return;
/* 115 */       }  if (this.depsFuture.isDone()) {
/*     */         try {
/* 117 */           this.depsFuture.get();
/* 118 */         } catch (Exception exception) {
/* 119 */           throw new GdxRuntimeException("Couldn't load dependencies of asset: " + this.assetDesc.fileName, exception);
/*     */         } 
/* 121 */         this.dependenciesLoaded = true;
/* 122 */         if (this.asyncDone)
/* 123 */         { this.asset = exception.loadSync(this.manager, this.assetDesc.fileName, resolve(this.loader, this.assetDesc), this.assetDesc.params); return; } 
/*     */       }  }
/* 125 */     else { if (this.loadFuture == null && !this.asyncDone) {
/* 126 */         this.loadFuture = this.executor.submit(this); return;
/* 127 */       }  if (this.asyncDone) {
/* 128 */         this.asset = exception.loadSync(this.manager, this.assetDesc.fileName, resolve(this.loader, this.assetDesc), this.assetDesc.params); return;
/* 129 */       }  if (this.loadFuture.isDone()) {
/*     */         try {
/* 131 */           this.loadFuture.get();
/* 132 */         } catch (Exception exception1) {
/* 133 */           throw new GdxRuntimeException("Couldn't load asset: " + this.assetDesc.fileName, exception1);
/*     */         } 
/* 135 */         this.asset = exception1.loadSync(this.manager, this.assetDesc.fileName, resolve(this.loader, this.assetDesc), this.assetDesc.params);
/*     */       }  }
/*     */   
/*     */   }
/*     */   
/*     */   public void unload() {
/* 141 */     if (this.loader instanceof AsynchronousAssetLoader)
/* 142 */       ((AsynchronousAssetLoader)this.loader).unloadAsync(this.manager, this.assetDesc.fileName, resolve(this.loader, this.assetDesc), this.assetDesc.params); 
/*     */   }
/*     */   
/*     */   private FileHandle resolve(AssetLoader paramAssetLoader, AssetDescriptor paramAssetDescriptor) {
/* 146 */     if (paramAssetDescriptor.file == null) paramAssetDescriptor.file = paramAssetLoader.resolve(paramAssetDescriptor.fileName); 
/* 147 */     return paramAssetDescriptor.file;
/*     */   }
/*     */   
/*     */   private void removeDuplicates(Array<AssetDescriptor> paramArray) {
/* 151 */     boolean bool = paramArray.ordered;
/* 152 */     paramArray.ordered = true;
/* 153 */     for (byte b = 0; b < paramArray.size; b++) {
/* 154 */       String str = ((AssetDescriptor)paramArray.get(b)).fileName;
/* 155 */       Class clazz = ((AssetDescriptor)paramArray.get(b)).type;
/* 156 */       for (int i = paramArray.size - 1; i > b; i--) {
/* 157 */         if (clazz == ((AssetDescriptor)paramArray.get(i)).type && str.equals(((AssetDescriptor)paramArray.get(i)).fileName)) paramArray.removeIndex(i); 
/*     */       } 
/* 159 */     }  paramArray.ordered = bool;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\assets\AssetLoadingTask.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */