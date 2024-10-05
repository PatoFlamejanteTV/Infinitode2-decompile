/*     */ package com.badlogic.gdx.assets.loaders;
/*     */ 
/*     */ import com.badlogic.gdx.assets.AssetDescriptor;
/*     */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*     */ import com.badlogic.gdx.assets.AssetManager;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g3d.Model;
/*     */ import com.badlogic.gdx.graphics.g3d.model.data.ModelData;
/*     */ import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
/*     */ import com.badlogic.gdx.graphics.g3d.model.data.ModelTexture;
/*     */ import com.badlogic.gdx.graphics.g3d.utils.TextureProvider;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import java.util.Iterator;
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
/*     */ public abstract class ModelLoader<P extends ModelLoader.ModelParameters>
/*     */   extends AsynchronousAssetLoader<Model, P>
/*     */ {
/*     */   protected Array<ObjectMap.Entry<String, ModelData>> items;
/*     */   protected ModelParameters defaultParameters;
/*     */   
/*     */   public ModelLoader(FileHandleResolver paramFileHandleResolver) {
/*  37 */     super(paramFileHandleResolver);
/*     */ 
/*     */     
/*  40 */     this.items = new Array();
/*  41 */     this.defaultParameters = new ModelParameters();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelData loadModelData(FileHandle paramFileHandle) {
/*  48 */     return loadModelData(paramFileHandle, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public Model loadModel(FileHandle paramFileHandle, TextureProvider paramTextureProvider, P paramP) {
/*     */     ModelData modelData;
/*  54 */     return ((modelData = loadModelData(paramFileHandle, paramP)) == null) ? null : new Model(modelData, paramTextureProvider);
/*     */   }
/*     */ 
/*     */   
/*     */   public Model loadModel(FileHandle paramFileHandle, P paramP) {
/*  59 */     return loadModel(paramFileHandle, (TextureProvider)new TextureProvider.FileTextureProvider(), paramP);
/*     */   }
/*     */ 
/*     */   
/*     */   public Model loadModel(FileHandle paramFileHandle, TextureProvider paramTextureProvider) {
/*  64 */     return loadModel(paramFileHandle, paramTextureProvider, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public Model loadModel(FileHandle paramFileHandle) {
/*  69 */     return loadModel(paramFileHandle, (TextureProvider)new TextureProvider.FileTextureProvider(), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public Array<AssetDescriptor> getDependencies(String paramString, FileHandle paramFileHandle, P paramP) {
/*  74 */     Array<AssetDescriptor> array = new Array();
/*     */     
/*  76 */     if ((null = loadModelData(paramFileHandle, paramP)) == null) return array;
/*     */     
/*     */     ObjectMap.Entry entry;
/*  79 */     (entry = new ObjectMap.Entry()).key = paramString;
/*  80 */     entry.value = null;
/*  81 */     synchronized (this.items) {
/*  82 */       this.items.add(entry);
/*     */     } 
/*     */ 
/*     */     
/*  86 */     TextureLoader.TextureParameter textureParameter = (paramP != null) ? ((ModelParameters)paramP).textureParameter : this.defaultParameters.textureParameter;
/*     */     
/*  88 */     for (Array.ArrayIterator<ModelMaterial> arrayIterator = ((ModelData)paramFileHandle).materials.iterator(); arrayIterator.hasNext();) {
/*  89 */       if ((modelMaterial = arrayIterator.next()).textures != null)
/*  90 */         for (Array.ArrayIterator<ModelTexture> arrayIterator1 = modelMaterial.textures.iterator(); arrayIterator1.hasNext(); ) { ModelTexture modelTexture = arrayIterator1.next();
/*  91 */           array.add(new AssetDescriptor(modelTexture.fileName, Texture.class, textureParameter)); }
/*     */          
/*     */     } 
/*  94 */     return array;
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, P paramP) {}
/*     */ 
/*     */   
/*     */   public Model loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, P paramP) {
/*     */     ModelData modelData;
/* 103 */     paramFileHandle = null;
/* 104 */     synchronized (this.items) {
/* 105 */       for (byte b = 0; b < this.items.size; b++) {
/* 106 */         if (((String)((ObjectMap.Entry)this.items.get(b)).key).equals(paramString)) {
/* 107 */           modelData = (ModelData)((ObjectMap.Entry)this.items.get(b)).value;
/* 108 */           this.items.removeIndex(b);
/*     */         } 
/*     */       } 
/*     */     } 
/* 112 */     if (modelData == null) return null;
/*     */ 
/*     */     
/*     */     Model model;
/* 116 */     Iterator<Disposable> iterator = (model = new Model(modelData, (TextureProvider)new TextureProvider.AssetTextureProvider(paramAssetManager))).getManagedDisposables().iterator();
/* 117 */     while (iterator.hasNext()) {
/*     */       Disposable disposable;
/* 119 */       if (disposable = iterator.next() instanceof Texture) {
/* 120 */         iterator.remove();
/*     */       }
/*     */     } 
/* 123 */     return model;
/*     */   }
/*     */   
/*     */   public abstract ModelData loadModelData(FileHandle paramFileHandle, P paramP);
/*     */   
/*     */   public static class ModelParameters extends AssetLoaderParameters<Model> {
/*     */     public ModelParameters() {
/* 130 */       this.textureParameter = new TextureLoader.TextureParameter();
/* 131 */       this.textureParameter.minFilter = this.textureParameter.magFilter = Texture.TextureFilter.Linear;
/* 132 */       this.textureParameter.wrapU = this.textureParameter.wrapV = Texture.TextureWrap.Repeat;
/*     */     }
/*     */     
/*     */     public TextureLoader.TextureParameter textureParameter;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\assets\loaders\ModelLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */