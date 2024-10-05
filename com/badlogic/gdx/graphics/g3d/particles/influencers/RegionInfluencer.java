/*     */ package com.badlogic.gdx.graphics.g3d.particles.influencers;
/*     */ 
/*     */ import com.badlogic.gdx.assets.AssetManager;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureAtlas;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
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
/*     */ public abstract class RegionInfluencer
/*     */   extends Influencer
/*     */ {
/*     */   public Array<AspectTextureRegion> regions;
/*     */   ParallelArray.FloatChannel regionChannel;
/*     */   public String atlasName;
/*     */   private static final String ASSET_DATA = "atlasAssetData";
/*     */   
/*     */   public static class Single
/*     */     extends RegionInfluencer
/*     */   {
/*     */     public Single() {}
/*     */     
/*     */     public Single(Single param1Single) {
/*  41 */       super(param1Single);
/*     */     }
/*     */     
/*     */     public Single(TextureRegion param1TextureRegion) {
/*  45 */       super(new TextureRegion[] { param1TextureRegion });
/*     */     }
/*     */     
/*     */     public Single(Texture param1Texture) {
/*  49 */       super(param1Texture);
/*     */     }
/*     */ 
/*     */     
/*     */     public void init() {
/*  54 */       RegionInfluencer.AspectTextureRegion aspectTextureRegion = ((RegionInfluencer.AspectTextureRegion[])this.regions.items)[0];
/*  55 */       int i = 0;
/*  56 */       for (int j = this.controller.emitter.maxParticleCount * this.regionChannel.strideSize; i < j; i += this.regionChannel.strideSize) {
/*  57 */         this.regionChannel.data[i] = aspectTextureRegion.u;
/*  58 */         this.regionChannel.data[i + 1] = aspectTextureRegion.v;
/*  59 */         this.regionChannel.data[i + 2] = aspectTextureRegion.u2;
/*  60 */         this.regionChannel.data[i + 3] = aspectTextureRegion.v2;
/*  61 */         this.regionChannel.data[i + 4] = 0.5F;
/*  62 */         this.regionChannel.data[i + 5] = aspectTextureRegion.halfInvAspectRatio;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public Single copy() {
/*  68 */       return new Single(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Random
/*     */     extends RegionInfluencer
/*     */   {
/*     */     public Random() {}
/*     */     
/*     */     public Random(Random param1Random) {
/*  78 */       super(param1Random);
/*     */     }
/*     */     
/*     */     public Random(TextureRegion param1TextureRegion) {
/*  82 */       super(new TextureRegion[] { param1TextureRegion });
/*     */     }
/*     */     
/*     */     public Random(Texture param1Texture) {
/*  86 */       super(param1Texture);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void activateParticles(int param1Int1, int param1Int2) {
/*  92 */       for (param1Int2 = (param1Int1 = param1Int1 * this.regionChannel.strideSize) + param1Int2 * this.regionChannel.strideSize; param1Int1 < param1Int2; param1Int1 += this.regionChannel.strideSize) {
/*  93 */         RegionInfluencer.AspectTextureRegion aspectTextureRegion = (RegionInfluencer.AspectTextureRegion)this.regions.random();
/*  94 */         this.regionChannel.data[param1Int1] = aspectTextureRegion.u;
/*  95 */         this.regionChannel.data[param1Int1 + 1] = aspectTextureRegion.v;
/*  96 */         this.regionChannel.data[param1Int1 + 2] = aspectTextureRegion.u2;
/*  97 */         this.regionChannel.data[param1Int1 + 3] = aspectTextureRegion.v2;
/*  98 */         this.regionChannel.data[param1Int1 + 4] = 0.5F;
/*  99 */         this.regionChannel.data[param1Int1 + 5] = aspectTextureRegion.halfInvAspectRatio;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public Random copy() {
/* 105 */       return new Random(this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Animated
/*     */     extends RegionInfluencer
/*     */   {
/*     */     ParallelArray.FloatChannel lifeChannel;
/*     */     
/*     */     public Animated() {}
/*     */     
/*     */     public Animated(Animated param1Animated) {
/* 118 */       super(param1Animated);
/*     */     }
/*     */     
/*     */     public Animated(TextureRegion param1TextureRegion) {
/* 122 */       super(new TextureRegion[] { param1TextureRegion });
/*     */     }
/*     */     
/*     */     public Animated(Texture param1Texture) {
/* 126 */       super(param1Texture);
/*     */     }
/*     */ 
/*     */     
/*     */     public void allocateChannels() {
/* 131 */       super.allocateChannels();
/* 132 */       this.lifeChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Life);
/*     */     }
/*     */ 
/*     */     
/*     */     public void update() {
/* 137 */       int i = 0, j = 2, k = this.controller.particles.size * this.regionChannel.strideSize;
/* 138 */       for (; i < k; i += this.regionChannel.strideSize, j += this.lifeChannel.strideSize) {
/* 139 */         RegionInfluencer.AspectTextureRegion aspectTextureRegion = (RegionInfluencer.AspectTextureRegion)this.regions.get((int)(this.lifeChannel.data[j] * (this.regions.size - 1)));
/* 140 */         this.regionChannel.data[i] = aspectTextureRegion.u;
/* 141 */         this.regionChannel.data[i + 1] = aspectTextureRegion.v;
/* 142 */         this.regionChannel.data[i + 2] = aspectTextureRegion.u2;
/* 143 */         this.regionChannel.data[i + 3] = aspectTextureRegion.v2;
/* 144 */         this.regionChannel.data[i + 4] = 0.5F;
/* 145 */         this.regionChannel.data[i + 5] = aspectTextureRegion.halfInvAspectRatio;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public Animated copy() {
/* 151 */       return new Animated(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class AspectTextureRegion {
/*     */     public float u;
/*     */     public float v;
/*     */     public float u2;
/*     */     public float v2;
/*     */     public float halfInvAspectRatio;
/*     */     public String imageName;
/*     */     
/*     */     public AspectTextureRegion() {}
/*     */     
/*     */     public AspectTextureRegion(AspectTextureRegion param1AspectTextureRegion) {
/* 166 */       set(param1AspectTextureRegion);
/*     */     }
/*     */     
/*     */     public AspectTextureRegion(TextureRegion param1TextureRegion) {
/* 170 */       set(param1TextureRegion);
/*     */     }
/*     */     
/*     */     public void set(TextureRegion param1TextureRegion) {
/* 174 */       this.u = param1TextureRegion.getU();
/* 175 */       this.v = param1TextureRegion.getV();
/* 176 */       this.u2 = param1TextureRegion.getU2();
/* 177 */       this.v2 = param1TextureRegion.getV2();
/* 178 */       this.halfInvAspectRatio = 0.5F * param1TextureRegion.getRegionHeight() / param1TextureRegion.getRegionWidth();
/* 179 */       if (param1TextureRegion instanceof TextureAtlas.AtlasRegion) {
/* 180 */         this.imageName = ((TextureAtlas.AtlasRegion)param1TextureRegion).name;
/*     */       }
/*     */     }
/*     */     
/*     */     public void set(AspectTextureRegion param1AspectTextureRegion) {
/* 185 */       this.u = param1AspectTextureRegion.u;
/* 186 */       this.v = param1AspectTextureRegion.v;
/* 187 */       this.u2 = param1AspectTextureRegion.u2;
/* 188 */       this.v2 = param1AspectTextureRegion.v2;
/* 189 */       this.halfInvAspectRatio = param1AspectTextureRegion.halfInvAspectRatio;
/* 190 */       this.imageName = param1AspectTextureRegion.imageName;
/*     */     }
/*     */     
/*     */     public void updateUV(TextureAtlas param1TextureAtlas) {
/* 194 */       if (this.imageName == null) {
/*     */         return;
/*     */       }
/* 197 */       TextureAtlas.AtlasRegion atlasRegion = param1TextureAtlas.findRegion(this.imageName);
/* 198 */       this.u = atlasRegion.getU();
/* 199 */       this.v = atlasRegion.getV();
/* 200 */       this.u2 = atlasRegion.getU2();
/* 201 */       this.v2 = atlasRegion.getV2();
/* 202 */       this.halfInvAspectRatio = 0.5F * atlasRegion.getRegionHeight() / atlasRegion.getRegionWidth();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RegionInfluencer(int paramInt) {
/* 211 */     this.regions = new Array(false, paramInt, AspectTextureRegion.class);
/*     */   }
/*     */   
/*     */   public RegionInfluencer() {
/* 215 */     this(1);
/*     */     AspectTextureRegion aspectTextureRegion;
/* 217 */     (aspectTextureRegion = new AspectTextureRegion()).u = aspectTextureRegion.v = 0.0F;
/* 218 */     aspectTextureRegion.u2 = aspectTextureRegion.v2 = 1.0F;
/* 219 */     aspectTextureRegion.halfInvAspectRatio = 0.5F;
/* 220 */     this.regions.add(aspectTextureRegion);
/*     */   }
/*     */ 
/*     */   
/*     */   public RegionInfluencer(TextureRegion... paramVarArgs) {
/* 225 */     setAtlasName((String)null);
/* 226 */     this.regions = new Array(false, paramVarArgs.length, AspectTextureRegion.class);
/* 227 */     add(paramVarArgs);
/*     */   }
/*     */   
/*     */   public RegionInfluencer(Texture paramTexture) {
/* 231 */     this(new TextureRegion[] { new TextureRegion(paramTexture) });
/*     */   }
/*     */   
/*     */   public RegionInfluencer(RegionInfluencer paramRegionInfluencer) {
/* 235 */     this(paramRegionInfluencer.regions.size);
/* 236 */     this.regions.ensureCapacity(paramRegionInfluencer.regions.size);
/* 237 */     for (byte b = 0; b < paramRegionInfluencer.regions.size; b++) {
/* 238 */       this.regions.add(new AspectTextureRegion((AspectTextureRegion)paramRegionInfluencer.regions.get(b)));
/*     */     }
/*     */   }
/*     */   
/*     */   public void setAtlasName(String paramString) {
/* 243 */     this.atlasName = paramString;
/*     */   }
/*     */   
/*     */   public void add(TextureRegion... paramVarArgs) {
/* 247 */     this.regions.ensureCapacity(paramVarArgs.length); int i; byte b;
/* 248 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { TextureRegion textureRegion = paramVarArgs[b];
/* 249 */       this.regions.add(new AspectTextureRegion(textureRegion));
/*     */       b++; }
/*     */   
/*     */   }
/*     */   public void clear() {
/* 254 */     this.atlasName = null;
/* 255 */     this.regions.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(AssetManager paramAssetManager, ResourceData paramResourceData) {
/* 262 */     super.load(paramAssetManager, paramResourceData);
/*     */     ResourceData.SaveData saveData;
/* 264 */     if ((saveData = paramResourceData.getSaveData("atlasAssetData")) == null) {
/*     */       return;
/*     */     }
/*     */     
/* 268 */     TextureAtlas textureAtlas = (TextureAtlas)paramAssetManager.get(saveData.loadAsset());
/* 269 */     for (Array.ArrayIterator<AspectTextureRegion> arrayIterator = this.regions.iterator(); arrayIterator.hasNext();) {
/* 270 */       (aspectTextureRegion = arrayIterator.next()).updateUV(textureAtlas);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(AssetManager paramAssetManager, ResourceData paramResourceData) {
/* 276 */     super.save(paramAssetManager, paramResourceData);
/* 277 */     if (this.atlasName != null) {
/*     */       ResourceData.SaveData saveData;
/* 279 */       if ((saveData = paramResourceData.getSaveData("atlasAssetData")) == null) {
/* 280 */         saveData = paramResourceData.createSaveData("atlasAssetData");
/*     */       }
/* 282 */       saveData.saveAsset(this.atlasName, TextureAtlas.class);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void allocateChannels() {
/* 288 */     this.regionChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.TextureRegion);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(Json paramJson) {
/* 293 */     paramJson.writeValue("regions", this.regions, Array.class, AspectTextureRegion.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Json paramJson, JsonValue paramJsonValue) {
/* 298 */     this.regions.clear();
/* 299 */     this.regions.addAll((Array)paramJson.readValue("regions", Array.class, AspectTextureRegion.class, paramJsonValue));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\influencers\RegionInfluencer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */