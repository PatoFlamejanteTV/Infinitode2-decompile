/*    */ package com.badlogic.gdx.assets.loaders;
/*    */ 
/*    */ import com.badlogic.gdx.assets.AssetDescriptor;
/*    */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*    */ import com.badlogic.gdx.assets.AssetManager;
/*    */ import com.badlogic.gdx.files.FileHandle;
/*    */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureAtlas;
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ParticleEffectLoader
/*    */   extends SynchronousAssetLoader<ParticleEffect, ParticleEffectLoader.ParticleEffectParameter>
/*    */ {
/*    */   public ParticleEffectLoader(FileHandleResolver paramFileHandleResolver) {
/* 32 */     super(paramFileHandleResolver);
/*    */   }
/*    */ 
/*    */   
/*    */   public ParticleEffect load(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, ParticleEffectParameter paramParticleEffectParameter) {
/* 37 */     ParticleEffect particleEffect = new ParticleEffect();
/* 38 */     if (paramParticleEffectParameter != null && paramParticleEffectParameter.atlasFile != null) {
/* 39 */       particleEffect.load(paramFileHandle, (TextureAtlas)paramAssetManager.get(paramParticleEffectParameter.atlasFile, TextureAtlas.class), paramParticleEffectParameter.atlasPrefix);
/* 40 */     } else if (paramParticleEffectParameter != null && paramParticleEffectParameter.imagesDir != null) {
/* 41 */       particleEffect.load(paramFileHandle, paramParticleEffectParameter.imagesDir);
/*    */     } else {
/* 43 */       particleEffect.load(paramFileHandle, paramFileHandle.parent());
/* 44 */     }  return particleEffect;
/*    */   }
/*    */   
/*    */   public Array<AssetDescriptor> getDependencies(String paramString, FileHandle paramFileHandle, ParticleEffectParameter paramParticleEffectParameter) {
/*    */     Array<AssetDescriptor> array;
/* 49 */     paramString = null;
/* 50 */     if (paramParticleEffectParameter != null && paramParticleEffectParameter.atlasFile != null)
/*    */     {
/* 52 */       (array = new Array()).add(new AssetDescriptor(paramParticleEffectParameter.atlasFile, TextureAtlas.class));
/*    */     }
/* 54 */     return array;
/*    */   }
/*    */   
/*    */   public static class ParticleEffectParameter extends AssetLoaderParameters<ParticleEffect> {
/*    */     public String atlasFile;
/*    */     public String atlasPrefix;
/*    */     public FileHandle imagesDir;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\assets\loaders\ParticleEffectLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */