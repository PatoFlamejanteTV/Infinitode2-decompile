/*     */ package com.badlogic.gdx.graphics.g3d.particles.batches;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.assets.AssetManager;
/*     */ import com.badlogic.gdx.graphics.GLTexture;
/*     */ import com.badlogic.gdx.graphics.Mesh;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.VertexAttribute;
/*     */ import com.badlogic.gdx.graphics.VertexAttributes;
/*     */ import com.badlogic.gdx.graphics.g3d.Attribute;
/*     */ import com.badlogic.gdx.graphics.g3d.Material;
/*     */ import com.badlogic.gdx.graphics.g3d.Renderable;
/*     */ import com.badlogic.gdx.graphics.g3d.Shader;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.DepthTestAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleShader;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.renderers.PointSpriteControllerRenderData;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Pool;
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
/*     */ public class PointSpriteParticleBatch
/*     */   extends BufferedParticleBatch<PointSpriteControllerRenderData>
/*     */ {
/*     */   private static boolean pointSpritesEnabled = false;
/*  49 */   protected static final Vector3 TMP_V1 = new Vector3();
/*     */ 
/*     */   
/*     */   protected static final int sizeAndRotationUsage = 512;
/*     */   
/*     */   protected static final VertexAttributes CPU_ATTRIBUTES;
/*     */   
/*  56 */   protected static final int CPU_VERTEX_SIZE = (short)((CPU_ATTRIBUTES = new VertexAttributes(new VertexAttribute[] { new VertexAttribute(1, 3, "a_position"), new VertexAttribute(2, 4, "a_color"), new VertexAttribute(16, 4, "a_region"), new VertexAttribute(512, 3, "a_sizeAndRotation") })).vertexSize / 4);
/*  57 */   protected static final int CPU_POSITION_OFFSET = (short)((CPU_ATTRIBUTES.findByUsage(1)).offset / 4);
/*  58 */   protected static final int CPU_COLOR_OFFSET = (short)((CPU_ATTRIBUTES.findByUsage(2)).offset / 4);
/*  59 */   protected static final int CPU_REGION_OFFSET = (short)((CPU_ATTRIBUTES.findByUsage(16)).offset / 4);
/*  60 */   protected static final int CPU_SIZE_AND_ROTATION_OFFSET = (short)((CPU_ATTRIBUTES.findByUsage(512)).offset / 4);
/*     */   
/*     */   private static void enablePointSprites() {
/*  63 */     Gdx.gl.glEnable(34370);
/*  64 */     if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
/*  65 */       Gdx.gl.glEnable(34913);
/*     */     }
/*  67 */     pointSpritesEnabled = true;
/*     */   }
/*     */   
/*     */   private float[] vertices;
/*     */   Renderable renderable;
/*     */   protected BlendingAttribute blendingAttribute;
/*     */   protected DepthTestAttribute depthTestAttribute;
/*     */   
/*     */   public PointSpriteParticleBatch() {
/*  76 */     this(1000);
/*     */   }
/*     */   
/*     */   public PointSpriteParticleBatch(int paramInt) {
/*  80 */     this(paramInt, new ParticleShader.Config(ParticleShader.ParticleType.Point));
/*     */   }
/*     */   
/*     */   public PointSpriteParticleBatch(int paramInt, ParticleShader.Config paramConfig) {
/*  84 */     this(paramInt, paramConfig, (BlendingAttribute)null, (DepthTestAttribute)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public PointSpriteParticleBatch(int paramInt, ParticleShader.Config paramConfig, BlendingAttribute paramBlendingAttribute, DepthTestAttribute paramDepthTestAttribute) {
/*  89 */     super(PointSpriteControllerRenderData.class);
/*     */     
/*  91 */     if (!pointSpritesEnabled) enablePointSprites();
/*     */     
/*  93 */     this.blendingAttribute = paramBlendingAttribute;
/*  94 */     this.depthTestAttribute = paramDepthTestAttribute;
/*     */     
/*  96 */     if (this.blendingAttribute == null)
/*  97 */       this.blendingAttribute = new BlendingAttribute(1, 771, 1.0F); 
/*  98 */     if (this.depthTestAttribute == null) this.depthTestAttribute = new DepthTestAttribute(515, false);
/*     */     
/* 100 */     allocRenderable();
/* 101 */     ensureCapacity(paramInt);
/* 102 */     this.renderable.shader = (Shader)new ParticleShader(this.renderable, paramConfig);
/* 103 */     this.renderable.shader.init();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void allocParticlesData(int paramInt) {
/* 108 */     this.vertices = new float[paramInt * CPU_VERTEX_SIZE];
/* 109 */     if (this.renderable.meshPart.mesh != null) this.renderable.meshPart.mesh.dispose(); 
/* 110 */     this.renderable.meshPart.mesh = new Mesh(false, paramInt, 0, CPU_ATTRIBUTES);
/*     */   }
/*     */   
/*     */   protected void allocRenderable() {
/* 114 */     this.renderable = new Renderable();
/* 115 */     this.renderable.meshPart.primitiveType = 0;
/* 116 */     this.renderable.meshPart.offset = 0;
/* 117 */     this.renderable.material = new Material(new Attribute[] { (Attribute)this.blendingAttribute, (Attribute)this.depthTestAttribute, (Attribute)TextureAttribute.createDiffuse((Texture)null) });
/*     */   }
/*     */   
/*     */   public void setTexture(Texture paramTexture) {
/*     */     TextureAttribute textureAttribute;
/* 122 */     (textureAttribute = (TextureAttribute)this.renderable.material.get(TextureAttribute.Diffuse)).textureDescription.texture = (GLTexture)paramTexture;
/*     */   }
/*     */   
/*     */   public Texture getTexture() {
/*     */     TextureAttribute textureAttribute;
/* 127 */     return (Texture)(textureAttribute = (TextureAttribute)this.renderable.material.get(TextureAttribute.Diffuse)).textureDescription.texture;
/*     */   }
/*     */   
/*     */   public BlendingAttribute getBlendingAttribute() {
/* 131 */     return this.blendingAttribute;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void flush(int[] paramArrayOfint) {
/* 136 */     byte b = 0;
/* 137 */     for (Array.ArrayIterator<PointSpriteControllerRenderData> arrayIterator = this.renderData.iterator(); arrayIterator.hasNext(); ) {
/* 138 */       PointSpriteControllerRenderData pointSpriteControllerRenderData; ParallelArray.FloatChannel floatChannel1 = (pointSpriteControllerRenderData = arrayIterator.next()).scaleChannel;
/* 139 */       ParallelArray.FloatChannel floatChannel2 = pointSpriteControllerRenderData.regionChannel;
/* 140 */       ParallelArray.FloatChannel floatChannel3 = pointSpriteControllerRenderData.positionChannel;
/* 141 */       ParallelArray.FloatChannel floatChannel4 = pointSpriteControllerRenderData.colorChannel;
/* 142 */       ParallelArray.FloatChannel floatChannel5 = pointSpriteControllerRenderData.rotationChannel;
/*     */       
/* 144 */       for (byte b1 = 0; b1 < pointSpriteControllerRenderData.controller.particles.size; b1++, b++) {
/* 145 */         int i = paramArrayOfint[b] * CPU_VERTEX_SIZE;
/* 146 */         int j = b1 * floatChannel2.strideSize;
/* 147 */         int k = b1 * floatChannel3.strideSize;
/* 148 */         int m = b1 * floatChannel4.strideSize;
/* 149 */         int n = b1 * floatChannel5.strideSize;
/*     */         
/* 151 */         this.vertices[i + CPU_POSITION_OFFSET] = floatChannel3.data[k];
/* 152 */         this.vertices[i + CPU_POSITION_OFFSET + 1] = floatChannel3.data[k + 1];
/* 153 */         this.vertices[i + CPU_POSITION_OFFSET + 2] = floatChannel3.data[k + 2];
/* 154 */         this.vertices[i + CPU_COLOR_OFFSET] = floatChannel4.data[m];
/* 155 */         this.vertices[i + CPU_COLOR_OFFSET + 1] = floatChannel4.data[m + 1];
/* 156 */         this.vertices[i + CPU_COLOR_OFFSET + 2] = floatChannel4.data[m + 2];
/* 157 */         this.vertices[i + CPU_COLOR_OFFSET + 3] = floatChannel4.data[m + 3];
/* 158 */         this.vertices[i + CPU_SIZE_AND_ROTATION_OFFSET] = floatChannel1.data[b1 * floatChannel1.strideSize];
/* 159 */         this.vertices[i + CPU_SIZE_AND_ROTATION_OFFSET + 1] = floatChannel5.data[n];
/*     */         
/* 161 */         this.vertices[i + CPU_SIZE_AND_ROTATION_OFFSET + 2] = floatChannel5.data[n + 1];
/*     */         
/* 163 */         this.vertices[i + CPU_REGION_OFFSET] = floatChannel2.data[j];
/* 164 */         this.vertices[i + CPU_REGION_OFFSET + 1] = floatChannel2.data[j + 1];
/* 165 */         this.vertices[i + CPU_REGION_OFFSET + 2] = floatChannel2.data[j + 2];
/* 166 */         this.vertices[i + CPU_REGION_OFFSET + 3] = floatChannel2.data[j + 3];
/*     */       } 
/*     */     } 
/*     */     
/* 170 */     this.renderable.meshPart.size = this.bufferedParticlesCount;
/* 171 */     this.renderable.meshPart.mesh.setVertices(this.vertices, 0, this.bufferedParticlesCount * CPU_VERTEX_SIZE);
/* 172 */     this.renderable.meshPart.update();
/*     */   }
/*     */ 
/*     */   
/*     */   public void getRenderables(Array<Renderable> paramArray, Pool<Renderable> paramPool) {
/* 177 */     if (this.bufferedParticlesCount > 0) paramArray.add(((Renderable)paramPool.obtain()).set(this.renderable));
/*     */   
/*     */   }
/*     */   
/*     */   public void save(AssetManager paramAssetManager, ResourceData paramResourceData) {
/*     */     ResourceData.SaveData saveData;
/* 183 */     (saveData = paramResourceData.createSaveData("pointSpriteBatch")).saveAsset(paramAssetManager.getAssetFileName(getTexture()), Texture.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(AssetManager paramAssetManager, ResourceData paramResourceData) {
/*     */     ResourceData.SaveData saveData;
/* 189 */     if ((saveData = paramResourceData.getSaveData("pointSpriteBatch")) != null) setTexture((Texture)paramAssetManager.get(saveData.loadAsset())); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\batches\PointSpriteParticleBatch.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */