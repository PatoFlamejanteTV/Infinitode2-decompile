/*     */ package com.badlogic.gdx.graphics.g3d.particles;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.assets.AssetDescriptor;
/*     */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*     */ import com.badlogic.gdx.assets.AssetManager;
/*     */ import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
/*     */ import com.badlogic.gdx.assets.loaders.FileHandleResolver;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
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
/*     */ public class ParticleEffectLoader
/*     */   extends AsynchronousAssetLoader<ParticleEffect, ParticleEffectLoader.ParticleEffectLoadParameter>
/*     */ {
/*  44 */   protected Array<ObjectMap.Entry<String, ResourceData<ParticleEffect>>> items = new Array();
/*     */   
/*     */   public ParticleEffectLoader(FileHandleResolver paramFileHandleResolver) {
/*  47 */     super(paramFileHandleResolver);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, ParticleEffectLoadParameter paramParticleEffectLoadParameter) {}
/*     */ 
/*     */   
/*     */   public Array<AssetDescriptor> getDependencies(String paramString, FileHandle paramFileHandle, ParticleEffectLoadParameter paramParticleEffectLoadParameter) {
/*     */     Json json;
/*  57 */     ResourceData resourceData = (ResourceData)(json = new Json()).fromJson(ResourceData.class, paramFileHandle);
/*     */     
/*  59 */     synchronized (this.items) {
/*     */       ObjectMap.Entry entry;
/*  61 */       (entry = new ObjectMap.Entry()).key = paramString;
/*  62 */       entry.value = resourceData;
/*  63 */       this.items.add(entry);
/*  64 */       Array<ResourceData.AssetData> array1 = resourceData.getAssets();
/*     */     } 
/*     */     
/*  67 */     Array<AssetDescriptor> array = new Array();
/*  68 */     for (Array.ArrayIterator<ResourceData.AssetData> arrayIterator = paramString.iterator(); arrayIterator.hasNext(); ) { ResourceData.AssetData assetData = arrayIterator.next();
/*     */ 
/*     */       
/*  71 */       if (!resolve(assetData.filename).exists()) {
/*  72 */         assetData.filename = paramFileHandle.parent().child(Gdx.files.internal(assetData.filename).name()).path();
/*     */       }
/*     */       
/*  75 */       if (assetData.type == ParticleEffect.class) {
/*  76 */         array.add(new AssetDescriptor(assetData.filename, assetData.type, paramParticleEffectLoadParameter)); continue;
/*     */       } 
/*  78 */       array.add(new AssetDescriptor(assetData.filename, assetData.type)); }
/*     */ 
/*     */     
/*  81 */     return array;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(ParticleEffect paramParticleEffect, ParticleEffectSaveParameter paramParticleEffectSaveParameter) {
/*  87 */     ResourceData<ParticleEffect> resourceData = new ResourceData<>(paramParticleEffect);
/*     */ 
/*     */     
/*  90 */     paramParticleEffect.save(paramParticleEffectSaveParameter.manager, resourceData);
/*     */ 
/*     */     
/*  93 */     if (paramParticleEffectSaveParameter.batches != null) {
/*  94 */       for (Array.ArrayIterator<ParticleBatch> arrayIterator = paramParticleEffectSaveParameter.batches.iterator(); arrayIterator.hasNext(); ) { ParticleBatch particleBatch = arrayIterator.next();
/*  95 */         boolean bool = false;
/*  96 */         for (Array.ArrayIterator<ParticleController> arrayIterator1 = paramParticleEffect.getControllers().iterator(); arrayIterator1.hasNext();) {
/*  97 */           if ((particleController = arrayIterator1.next()).renderer.isCompatible(particleBatch)) {
/*  98 */             bool = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 103 */         if (bool) particleBatch.save(paramParticleEffectSaveParameter.manager, resourceData);
/*     */          }
/*     */     
/*     */     }
/*     */     
/* 108 */     Json json = new Json(paramParticleEffectSaveParameter.jsonOutputType);
/* 109 */     if (paramParticleEffectSaveParameter.prettyPrint) {
/* 110 */       String str = json.prettyPrint(resourceData);
/* 111 */       paramParticleEffectSaveParameter.file.writeString(str, false); return;
/*     */     } 
/* 113 */     json.toJson(resourceData, paramParticleEffectSaveParameter.file);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ParticleEffect loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, ParticleEffectLoadParameter paramParticleEffectLoadParameter) {
/*     */     ResourceData resourceData;
/* 120 */     paramFileHandle = null;
/* 121 */     synchronized (this.items) {
/* 122 */       for (byte b = 0; b < this.items.size; b++) {
/*     */         ObjectMap.Entry entry;
/* 124 */         if (((String)(entry = (ObjectMap.Entry)this.items.get(b)).key).equals(paramString)) {
/* 125 */           resourceData = (ResourceData)entry.value;
/* 126 */           this.items.removeIndex(b);
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 132 */     ((ParticleEffect)resourceData.resource).load(paramAssetManager, resourceData);
/* 133 */     if (paramParticleEffectLoadParameter != null) {
/* 134 */       if (paramParticleEffectLoadParameter.batches != null) {
/* 135 */         for (Array.ArrayIterator<ParticleBatch> arrayIterator = paramParticleEffectLoadParameter.batches.iterator(); arrayIterator.hasNext();) {
/* 136 */           (particleBatch = arrayIterator.next()).load(paramAssetManager, resourceData);
/*     */         }
/*     */       }
/* 139 */       ((ParticleEffect)resourceData.resource).setBatch(paramParticleEffectLoadParameter.batches);
/*     */     } 
/* 141 */     return (ParticleEffect)resourceData.resource;
/*     */   }
/*     */   
/*     */   private <T> T find(Array<?> paramArray, Class<T> paramClass) {
/* 145 */     for (Array.ArrayIterator<Object> arrayIterator = paramArray.iterator(); arrayIterator.hasNext(); ) { T t = (T)arrayIterator.next();
/* 146 */       if (ClassReflection.isAssignableFrom(paramClass, t.getClass())) return t;  }
/*     */     
/* 148 */     return null;
/*     */   }
/*     */   
/*     */   public static class ParticleEffectLoadParameter extends AssetLoaderParameters<ParticleEffect> {
/*     */     Array<ParticleBatch<?>> batches;
/*     */     
/*     */     public ParticleEffectLoadParameter(Array<ParticleBatch<?>> param1Array) {
/* 155 */       this.batches = param1Array;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class ParticleEffectSaveParameter
/*     */     extends AssetLoaderParameters<ParticleEffect>
/*     */   {
/*     */     Array<ParticleBatch<?>> batches;
/*     */     FileHandle file;
/*     */     AssetManager manager;
/*     */     JsonWriter.OutputType jsonOutputType;
/*     */     boolean prettyPrint;
/*     */     
/*     */     public ParticleEffectSaveParameter(FileHandle param1FileHandle, AssetManager param1AssetManager, Array<ParticleBatch<?>> param1Array) {
/* 170 */       this(param1FileHandle, param1AssetManager, param1Array, JsonWriter.OutputType.minimal, false);
/*     */     }
/*     */ 
/*     */     
/*     */     public ParticleEffectSaveParameter(FileHandle param1FileHandle, AssetManager param1AssetManager, Array<ParticleBatch<?>> param1Array, JsonWriter.OutputType param1OutputType, boolean param1Boolean) {
/* 175 */       this.batches = param1Array;
/* 176 */       this.file = param1FileHandle;
/* 177 */       this.manager = param1AssetManager;
/* 178 */       this.jsonOutputType = param1OutputType;
/* 179 */       this.prettyPrint = param1Boolean;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\ParticleEffectLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */