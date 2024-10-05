/*     */ package com.badlogic.gdx.graphics.g3d.particles.batches;
/*     */ 
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
/*     */ import com.badlogic.gdx.graphics.g3d.particles.renderers.BillboardControllerRenderData;
/*     */ import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Matrix3;
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
/*     */ 
/*     */ public class BillboardParticleBatch
/*     */   extends BufferedParticleBatch<BillboardControllerRenderData>
/*     */ {
/*  50 */   protected static final Vector3 TMP_V1 = new Vector3(), TMP_V2 = new Vector3(), TMP_V3 = new Vector3(), TMP_V4 = new Vector3();
/*  51 */   protected static final Vector3 TMP_V5 = new Vector3(); protected static final Vector3 TMP_V6 = new Vector3();
/*  52 */   protected static final Matrix3 TMP_M3 = new Matrix3();
/*     */   protected static final int sizeAndRotationUsage = 512;
/*     */   protected static final int directionUsage = 1024;
/*  55 */   private static final VertexAttributes GPU_ATTRIBUTES = new VertexAttributes(new VertexAttribute[] { new VertexAttribute(1, 3, "a_position"), new VertexAttribute(16, 2, "a_texCoord0"), new VertexAttribute(2, 4, "a_color"), new VertexAttribute(512, 4, "a_sizeAndRotation") });
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
/*  66 */   private static final VertexAttributes CPU_ATTRIBUTES = new VertexAttributes(new VertexAttribute[] { new VertexAttribute(1, 3, "a_position"), new VertexAttribute(16, 2, "a_texCoord0"), new VertexAttribute(2, 4, "a_color") });
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   private static final int GPU_POSITION_OFFSET = (short)((GPU_ATTRIBUTES.findByUsage(1)).offset / 4);
/*  72 */   private static final int GPU_UV_OFFSET = (short)((GPU_ATTRIBUTES.findByUsage(16)).offset / 4);
/*  73 */   private static final int GPU_SIZE_ROTATION_OFFSET = (short)((GPU_ATTRIBUTES.findByUsage(512)).offset / 4);
/*  74 */   private static final int GPU_COLOR_OFFSET = (short)((GPU_ATTRIBUTES.findByUsage(2)).offset / 4);
/*  75 */   private static final int GPU_VERTEX_SIZE = GPU_ATTRIBUTES.vertexSize / 4;
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
/*  87 */   private static final int CPU_POSITION_OFFSET = (short)((CPU_ATTRIBUTES.findByUsage(1)).offset / 4);
/*  88 */   private static final int CPU_UV_OFFSET = (short)((CPU_ATTRIBUTES.findByUsage(16)).offset / 4);
/*  89 */   private static final int CPU_COLOR_OFFSET = (short)((CPU_ATTRIBUTES.findByUsage(2)).offset / 4);
/*  90 */   private static final int CPU_VERTEX_SIZE = CPU_ATTRIBUTES.vertexSize / 4;
/*     */   private static final int MAX_PARTICLES_PER_MESH = 8191;
/*     */   private static final int MAX_VERTICES_PER_MESH = 32764;
/*     */   private RenderablePool renderablePool;
/*     */   private Array<Renderable> renderables;
/*     */   private float[] vertices;
/*     */   private short[] indices;
/*     */   
/*     */   private class RenderablePool extends Pool<Renderable> { public Renderable newObject() {
/*  99 */       return BillboardParticleBatch.this.allocRenderable();
/*     */     } }
/*     */ 
/*     */   
/*     */   public static class Config
/*     */   {
/*     */     boolean useGPU;
/*     */     
/*     */     public Config(boolean param1Boolean, ParticleShader.AlignMode param1AlignMode) {
/* 108 */       this.useGPU = param1Boolean;
/* 109 */       this.mode = param1AlignMode;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     ParticleShader.AlignMode mode;
/*     */ 
/*     */     
/*     */     public Config() {}
/*     */   }
/*     */   
/* 120 */   private int currentVertexSize = 0;
/*     */   private VertexAttributes currentAttributes;
/*     */   protected boolean useGPU = false;
/* 123 */   protected ParticleShader.AlignMode mode = ParticleShader.AlignMode.Screen;
/*     */ 
/*     */   
/*     */   protected Texture texture;
/*     */ 
/*     */   
/*     */   protected BlendingAttribute blendingAttribute;
/*     */   
/*     */   protected DepthTestAttribute depthTestAttribute;
/*     */   
/*     */   Shader shader;
/*     */ 
/*     */   
/*     */   public BillboardParticleBatch(ParticleShader.AlignMode paramAlignMode, boolean paramBoolean, int paramInt, BlendingAttribute paramBlendingAttribute, DepthTestAttribute paramDepthTestAttribute) {
/* 137 */     super(BillboardControllerRenderData.class);
/* 138 */     this.renderables = new Array();
/* 139 */     this.renderablePool = new RenderablePool();
/* 140 */     this.blendingAttribute = paramBlendingAttribute;
/* 141 */     this.depthTestAttribute = paramDepthTestAttribute;
/*     */     
/* 143 */     if (this.blendingAttribute == null)
/* 144 */       this.blendingAttribute = new BlendingAttribute(1, 771, 1.0F); 
/* 145 */     if (this.depthTestAttribute == null) this.depthTestAttribute = new DepthTestAttribute(515, false);
/*     */     
/* 147 */     allocIndices();
/* 148 */     initRenderData();
/* 149 */     ensureCapacity(paramInt);
/* 150 */     setUseGpu(paramBoolean);
/* 151 */     setAlignMode(paramAlignMode);
/*     */   }
/*     */   
/*     */   public BillboardParticleBatch(ParticleShader.AlignMode paramAlignMode, boolean paramBoolean, int paramInt) {
/* 155 */     this(paramAlignMode, paramBoolean, paramInt, (BlendingAttribute)null, (DepthTestAttribute)null);
/*     */   }
/*     */   
/*     */   public BillboardParticleBatch() {
/* 159 */     this(ParticleShader.AlignMode.Screen, false, 100);
/*     */   }
/*     */   
/*     */   public BillboardParticleBatch(int paramInt) {
/* 163 */     this(ParticleShader.AlignMode.Screen, false, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void allocParticlesData(int paramInt) {
/* 168 */     this.vertices = new float[(this.currentVertexSize << 2) * paramInt];
/* 169 */     allocRenderables(paramInt);
/*     */   }
/*     */   
/*     */   protected Renderable allocRenderable() {
/*     */     Renderable renderable;
/* 174 */     (renderable = new Renderable()).meshPart.primitiveType = 4;
/* 175 */     renderable.meshPart.offset = 0;
/* 176 */     renderable
/* 177 */       .material = new Material(new Attribute[] { (Attribute)this.blendingAttribute, (Attribute)this.depthTestAttribute, (Attribute)TextureAttribute.createDiffuse(this.texture) });
/* 178 */     renderable.meshPart.mesh = new Mesh(false, 32764, 49146, this.currentAttributes);
/* 179 */     renderable.meshPart.mesh.setIndices(this.indices);
/* 180 */     renderable.shader = this.shader;
/* 181 */     return renderable;
/*     */   }
/*     */ 
/*     */   
/*     */   private void allocIndices() {
/* 186 */     this.indices = new short[49146];
/* 187 */     for (byte b1 = 0, b2 = 0; b1 < '뿺'; b1 += 6, b2 += 4) {
/* 188 */       this.indices[b1] = (short)b2;
/* 189 */       this.indices[b1 + 1] = (short)(b2 + 1);
/* 190 */       this.indices[b1 + 2] = (short)(b2 + 2);
/* 191 */       this.indices[b1 + 3] = (short)(b2 + 2);
/* 192 */       this.indices[b1 + 4] = (short)(b2 + 3);
/* 193 */       this.indices[b1 + 5] = (short)b2;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void allocRenderables(int paramInt) {
/* 199 */     paramInt = MathUtils.ceil((paramInt / 8191)); int i;
/* 200 */     if ((i = this.renderablePool.getFree()) < paramInt) {
/* 201 */       for (byte b = 0; b < paramInt; b++) {
/* 202 */         this.renderablePool.free(this.renderablePool.newObject());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   protected Shader getShader(Renderable paramRenderable) {
/* 208 */     (paramRenderable = this.useGPU ? (Renderable)new ParticleShader(paramRenderable, new ParticleShader.Config(this.mode)) : (Renderable)new DefaultShader(paramRenderable)).init();
/* 209 */     return (Shader)paramRenderable;
/*     */   }
/*     */   
/*     */   private void allocShader() {
/* 213 */     Renderable renderable = allocRenderable();
/* 214 */     this.shader = renderable.shader = getShader(renderable);
/* 215 */     this.renderablePool.free(renderable);
/*     */   }
/*     */   
/*     */   private void clearRenderablesPool() {
/* 219 */     this.renderablePool.freeAll(this.renderables); byte b; int i;
/* 220 */     for (b = 0, i = this.renderablePool.getFree(); b < i; b++) {
/*     */       Renderable renderable;
/* 222 */       (renderable = (Renderable)this.renderablePool.obtain()).meshPart.mesh.dispose();
/*     */     } 
/* 224 */     this.renderables.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVertexData() {
/* 229 */     if (this.useGPU) {
/* 230 */       this.currentAttributes = GPU_ATTRIBUTES;
/* 231 */       this.currentVertexSize = GPU_VERTEX_SIZE;
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 237 */     this.currentAttributes = CPU_ATTRIBUTES;
/* 238 */     this.currentVertexSize = CPU_VERTEX_SIZE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initRenderData() {
/* 245 */     setVertexData();
/* 246 */     clearRenderablesPool();
/* 247 */     allocShader();
/* 248 */     resetCapacity();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAlignMode(ParticleShader.AlignMode paramAlignMode) {
/* 253 */     if (paramAlignMode != this.mode) {
/* 254 */       this.mode = paramAlignMode;
/* 255 */       if (this.useGPU) {
/* 256 */         initRenderData();
/* 257 */         allocRenderables(this.bufferedParticlesCount);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public ParticleShader.AlignMode getAlignMode() {
/* 263 */     return this.mode;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUseGpu(boolean paramBoolean) {
/* 268 */     if (this.useGPU != paramBoolean) {
/* 269 */       this.useGPU = paramBoolean;
/* 270 */       initRenderData();
/* 271 */       allocRenderables(this.bufferedParticlesCount);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isUseGPU() {
/* 276 */     return this.useGPU;
/*     */   }
/*     */   
/*     */   public void setTexture(Texture paramTexture) {
/* 280 */     this.renderablePool.freeAll(this.renderables);
/* 281 */     this.renderables.clear(); byte b; int i;
/* 282 */     for (b = 0, i = this.renderablePool.getFree(); b < i; b++) {
/*     */       TextureAttribute textureAttribute;
/*     */       Renderable renderable;
/* 285 */       (textureAttribute = (TextureAttribute)(renderable = (Renderable)this.renderablePool.obtain()).material.get(TextureAttribute.Diffuse)).textureDescription.texture = (GLTexture)paramTexture;
/*     */     } 
/* 287 */     this.texture = paramTexture;
/*     */   }
/*     */   
/*     */   public Texture getTexture() {
/* 291 */     return this.texture;
/*     */   }
/*     */   
/*     */   public BlendingAttribute getBlendingAttribute() {
/* 295 */     return this.blendingAttribute;
/*     */   }
/*     */ 
/*     */   
/*     */   public void begin() {
/* 300 */     super.begin();
/* 301 */     this.renderablePool.freeAll(this.renderables);
/* 302 */     this.renderables.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void putVertex(float[] paramArrayOffloat, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13) {
/* 310 */     paramArrayOffloat[paramInt + GPU_POSITION_OFFSET] = paramFloat1;
/* 311 */     paramArrayOffloat[paramInt + GPU_POSITION_OFFSET + 1] = paramFloat2;
/* 312 */     paramArrayOffloat[paramInt + GPU_POSITION_OFFSET + 2] = paramFloat3;
/*     */     
/* 314 */     paramArrayOffloat[paramInt + GPU_UV_OFFSET] = paramFloat4;
/* 315 */     paramArrayOffloat[paramInt + GPU_UV_OFFSET + 1] = paramFloat5;
/*     */     
/* 317 */     paramArrayOffloat[paramInt + GPU_SIZE_ROTATION_OFFSET] = paramFloat6;
/* 318 */     paramArrayOffloat[paramInt + GPU_SIZE_ROTATION_OFFSET + 1] = paramFloat7;
/* 319 */     paramArrayOffloat[paramInt + GPU_SIZE_ROTATION_OFFSET + 2] = paramFloat8;
/* 320 */     paramArrayOffloat[paramInt + GPU_SIZE_ROTATION_OFFSET + 3] = paramFloat9;
/*     */     
/* 322 */     paramArrayOffloat[paramInt + GPU_COLOR_OFFSET] = paramFloat10;
/* 323 */     paramArrayOffloat[paramInt + GPU_COLOR_OFFSET + 1] = paramFloat11;
/* 324 */     paramArrayOffloat[paramInt + GPU_COLOR_OFFSET + 2] = paramFloat12;
/* 325 */     paramArrayOffloat[paramInt + GPU_COLOR_OFFSET + 3] = paramFloat13;
/*     */   }
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
/*     */   private static void putVertex(float[] paramArrayOffloat, int paramInt, Vector3 paramVector3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 345 */     paramArrayOffloat[paramInt + CPU_POSITION_OFFSET] = paramVector3.x;
/* 346 */     paramArrayOffloat[paramInt + CPU_POSITION_OFFSET + 1] = paramVector3.y;
/* 347 */     paramArrayOffloat[paramInt + CPU_POSITION_OFFSET + 2] = paramVector3.z;
/*     */     
/* 349 */     paramArrayOffloat[paramInt + CPU_UV_OFFSET] = paramFloat1;
/* 350 */     paramArrayOffloat[paramInt + CPU_UV_OFFSET + 1] = paramFloat2;
/*     */     
/* 352 */     paramArrayOffloat[paramInt + CPU_COLOR_OFFSET] = paramFloat3;
/* 353 */     paramArrayOffloat[paramInt + CPU_COLOR_OFFSET + 1] = paramFloat4;
/* 354 */     paramArrayOffloat[paramInt + CPU_COLOR_OFFSET + 2] = paramFloat5;
/* 355 */     paramArrayOffloat[paramInt + CPU_COLOR_OFFSET + 3] = paramFloat6;
/*     */   }
/*     */   
/*     */   private void fillVerticesGPU(int[] paramArrayOfint) {
/* 359 */     byte b = 0;
/* 360 */     for (Array.ArrayIterator<BillboardControllerRenderData> arrayIterator = this.renderData.iterator(); arrayIterator.hasNext(); ) {
/* 361 */       BillboardControllerRenderData billboardControllerRenderData; ParallelArray.FloatChannel floatChannel1 = (billboardControllerRenderData = arrayIterator.next()).scaleChannel;
/* 362 */       ParallelArray.FloatChannel floatChannel2 = billboardControllerRenderData.regionChannel;
/* 363 */       ParallelArray.FloatChannel floatChannel3 = billboardControllerRenderData.positionChannel;
/* 364 */       ParallelArray.FloatChannel floatChannel4 = billboardControllerRenderData.colorChannel;
/* 365 */       ParallelArray.FloatChannel floatChannel5 = billboardControllerRenderData.rotationChannel; int i; byte b1;
/* 366 */       for (b1 = 0, i = billboardControllerRenderData.controller.particles.size; b1 < i; b1++, b++) {
/* 367 */         int j = paramArrayOfint[b] * this.currentVertexSize << 2;
/* 368 */         float f1 = floatChannel1.data[b1 * floatChannel1.strideSize];
/* 369 */         int k = b1 * floatChannel2.strideSize;
/* 370 */         int m = b1 * floatChannel3.strideSize;
/* 371 */         int n = b1 * floatChannel4.strideSize;
/* 372 */         int i1 = b1 * floatChannel5.strideSize;
/* 373 */         float f6 = floatChannel3.data[m];
/* 374 */         float f7 = floatChannel3.data[m + 1];
/* 375 */         float f3 = floatChannel3.data[m + 2];
/* 376 */         float f8 = floatChannel2.data[k];
/* 377 */         float f9 = floatChannel2.data[k + 1];
/* 378 */         float f10 = floatChannel2.data[k + 2];
/* 379 */         float f11 = floatChannel2.data[k + 3];
/* 380 */         float f12 = floatChannel2.data[k + 4] * f1;
/* 381 */         f1 = floatChannel2.data[k + 5] * f1;
/* 382 */         float f2 = floatChannel4.data[n];
/* 383 */         float f13 = floatChannel4.data[n + 1];
/* 384 */         float f14 = floatChannel4.data[n + 2];
/* 385 */         float f4 = floatChannel4.data[n + 3];
/* 386 */         float f15 = floatChannel5.data[i1];
/* 387 */         float f5 = floatChannel5.data[i1 + 1];
/*     */ 
/*     */         
/* 390 */         putVertex(this.vertices, j, f6, f7, f3, f8, f11, -f12, -f1, f15, f5, f2, f13, f14, f4);
/* 391 */         j += this.currentVertexSize;
/* 392 */         putVertex(this.vertices, j, f6, f7, f3, f10, f11, f12, -f1, f15, f5, f2, f13, f14, f4);
/* 393 */         j += this.currentVertexSize;
/* 394 */         putVertex(this.vertices, j, f6, f7, f3, f10, f9, f12, f1, f15, f5, f2, f13, f14, f4);
/* 395 */         j += this.currentVertexSize;
/* 396 */         putVertex(this.vertices, j, f6, f7, f3, f8, f9, -f12, f1, f15, f5, f2, f13, f14, f4);
/*     */       } 
/*     */     } 
/*     */   }
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
/*     */   private void fillVerticesToViewPointCPU(int[] paramArrayOfint) {
/* 475 */     byte b = 0;
/* 476 */     for (Array.ArrayIterator<BillboardControllerRenderData> arrayIterator = this.renderData.iterator(); arrayIterator.hasNext(); ) {
/* 477 */       BillboardControllerRenderData billboardControllerRenderData; ParallelArray.FloatChannel floatChannel1 = (billboardControllerRenderData = arrayIterator.next()).scaleChannel;
/* 478 */       ParallelArray.FloatChannel floatChannel2 = billboardControllerRenderData.regionChannel;
/* 479 */       ParallelArray.FloatChannel floatChannel3 = billboardControllerRenderData.positionChannel;
/* 480 */       ParallelArray.FloatChannel floatChannel4 = billboardControllerRenderData.colorChannel;
/* 481 */       ParallelArray.FloatChannel floatChannel5 = billboardControllerRenderData.rotationChannel; int i;
/*     */       byte b1;
/* 483 */       for (b1 = 0, i = billboardControllerRenderData.controller.particles.size; b1 < i; b1++, b++) {
/* 484 */         int j = paramArrayOfint[b] * this.currentVertexSize << 2;
/* 485 */         float f1 = floatChannel1.data[b1 * floatChannel1.strideSize];
/* 486 */         int k = b1 * floatChannel2.strideSize;
/* 487 */         int m = b1 * floatChannel3.strideSize;
/* 488 */         int n = b1 * floatChannel4.strideSize;
/* 489 */         int i1 = b1 * floatChannel5.strideSize;
/* 490 */         float f6 = floatChannel3.data[m];
/* 491 */         float f7 = floatChannel3.data[m + 1];
/* 492 */         float f3 = floatChannel3.data[m + 2];
/* 493 */         float f8 = floatChannel2.data[k];
/* 494 */         float f9 = floatChannel2.data[k + 1];
/* 495 */         float f10 = floatChannel2.data[k + 2];
/* 496 */         float f11 = floatChannel2.data[k + 3];
/* 497 */         float f12 = floatChannel2.data[k + 4] * f1;
/* 498 */         f1 = floatChannel2.data[k + 5] * f1;
/* 499 */         float f2 = floatChannel4.data[n];
/* 500 */         float f13 = floatChannel4.data[n + 1];
/* 501 */         float f14 = floatChannel4.data[n + 2];
/* 502 */         float f4 = floatChannel4.data[n + 3];
/* 503 */         float f15 = floatChannel5.data[i1];
/* 504 */         float f5 = floatChannel5.data[i1 + 1];
/* 505 */         Vector3 vector31 = TMP_V3.set(this.camera.position).sub(f6, f7, f3).nor();
/* 506 */         Vector3 vector32 = TMP_V1.set(this.camera.up).crs(vector31).nor();
/* 507 */         Vector3 vector33 = TMP_V2.set(vector31).crs(vector32);
/* 508 */         vector32.scl(f12);
/* 509 */         vector33.scl(f1);
/*     */         
/* 511 */         if (f15 != 1.0F) {
/* 512 */           TMP_M3.setToRotation(vector31, f15, f5);
/* 513 */           putVertex(this.vertices, j, TMP_V6
/* 514 */               .set(-TMP_V1.x - TMP_V2.x, -TMP_V1.y - TMP_V2.y, -TMP_V1.z - TMP_V2.z).mul(TMP_M3).add(f6, f7, f3), f8, f11, f2, f13, f14, f4);
/*     */           
/* 516 */           j += this.currentVertexSize;
/* 517 */           putVertex(this.vertices, j, TMP_V6
/* 518 */               .set(TMP_V1.x - TMP_V2.x, TMP_V1.y - TMP_V2.y, TMP_V1.z - TMP_V2.z).mul(TMP_M3).add(f6, f7, f3), f10, f11, f2, f13, f14, f4);
/*     */           
/* 520 */           j += this.currentVertexSize;
/* 521 */           putVertex(this.vertices, j, TMP_V6
/* 522 */               .set(TMP_V1.x + TMP_V2.x, TMP_V1.y + TMP_V2.y, TMP_V1.z + TMP_V2.z).mul(TMP_M3).add(f6, f7, f3), f10, f9, f2, f13, f14, f4);
/*     */           
/* 524 */           j += this.currentVertexSize;
/* 525 */           putVertex(this.vertices, j, TMP_V6
/* 526 */               .set(-TMP_V1.x + TMP_V2.x, -TMP_V1.y + TMP_V2.y, -TMP_V1.z + TMP_V2.z).mul(TMP_M3).add(f6, f7, f3), f8, f9, f2, f13, f14, f4);
/*     */         } else {
/*     */           
/* 529 */           putVertex(this.vertices, j, TMP_V6
/* 530 */               .set(-TMP_V1.x - TMP_V2.x + f6, -TMP_V1.y - TMP_V2.y + f7, -TMP_V1.z - TMP_V2.z + f3), f8, f11, f2, f13, f14, f4);
/* 531 */           j += this.currentVertexSize;
/* 532 */           putVertex(this.vertices, j, TMP_V6
/* 533 */               .set(TMP_V1.x - TMP_V2.x + f6, TMP_V1.y - TMP_V2.y + f7, TMP_V1.z - TMP_V2.z + f3), f10, f11, f2, f13, f14, f4);
/* 534 */           j += this.currentVertexSize;
/* 535 */           putVertex(this.vertices, j, TMP_V6
/* 536 */               .set(TMP_V1.x + TMP_V2.x + f6, TMP_V1.y + TMP_V2.y + f7, TMP_V1.z + TMP_V2.z + f3), f10, f9, f2, f13, f14, f4);
/* 537 */           j += this.currentVertexSize;
/* 538 */           putVertex(this.vertices, j, TMP_V6
/* 539 */               .set(-TMP_V1.x + TMP_V2.x + f6, -TMP_V1.y + TMP_V2.y + f7, -TMP_V1.z + TMP_V2.z + f3), f8, f9, f2, f13, f14, f4);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void fillVerticesToScreenCPU(int[] paramArrayOfint) {
/* 546 */     Vector3 vector31 = TMP_V3.set(this.camera.direction).scl(-1.0F);
/* 547 */     Vector3 vector32 = TMP_V4.set(this.camera.up).crs(vector31).nor();
/* 548 */     Vector3 vector33 = this.camera.up;
/*     */     
/* 550 */     byte b = 0;
/* 551 */     for (Array.ArrayIterator<BillboardControllerRenderData> arrayIterator = this.renderData.iterator(); arrayIterator.hasNext(); ) {
/* 552 */       BillboardControllerRenderData billboardControllerRenderData; ParallelArray.FloatChannel floatChannel1 = (billboardControllerRenderData = arrayIterator.next()).scaleChannel;
/* 553 */       ParallelArray.FloatChannel floatChannel2 = billboardControllerRenderData.regionChannel;
/* 554 */       ParallelArray.FloatChannel floatChannel3 = billboardControllerRenderData.positionChannel;
/* 555 */       ParallelArray.FloatChannel floatChannel4 = billboardControllerRenderData.colorChannel;
/* 556 */       ParallelArray.FloatChannel floatChannel5 = billboardControllerRenderData.rotationChannel; int i;
/*     */       byte b1;
/* 558 */       for (b1 = 0, i = billboardControllerRenderData.controller.particles.size; b1 < i; b1++, b++) {
/* 559 */         int j = paramArrayOfint[b] * this.currentVertexSize << 2;
/* 560 */         float f1 = floatChannel1.data[b1 * floatChannel1.strideSize];
/* 561 */         int k = b1 * floatChannel2.strideSize;
/* 562 */         int m = b1 * floatChannel3.strideSize;
/* 563 */         int n = b1 * floatChannel4.strideSize;
/* 564 */         int i1 = b1 * floatChannel5.strideSize;
/* 565 */         float f6 = floatChannel3.data[m];
/* 566 */         float f7 = floatChannel3.data[m + 1];
/* 567 */         float f3 = floatChannel3.data[m + 2];
/* 568 */         float f8 = floatChannel2.data[k];
/* 569 */         float f9 = floatChannel2.data[k + 1];
/* 570 */         float f10 = floatChannel2.data[k + 2];
/* 571 */         float f11 = floatChannel2.data[k + 3];
/* 572 */         float f12 = floatChannel2.data[k + 4] * f1;
/* 573 */         f1 = floatChannel2.data[k + 5] * f1;
/* 574 */         float f2 = floatChannel4.data[n];
/* 575 */         float f13 = floatChannel4.data[n + 1];
/* 576 */         float f14 = floatChannel4.data[n + 2];
/* 577 */         float f4 = floatChannel4.data[n + 3];
/* 578 */         float f15 = floatChannel5.data[i1];
/* 579 */         float f5 = floatChannel5.data[i1 + 1];
/* 580 */         TMP_V1.set(vector32).scl(f12);
/* 581 */         TMP_V2.set(vector33).scl(f1);
/*     */         
/* 583 */         if (f15 != 1.0F) {
/* 584 */           TMP_M3.setToRotation(vector31, f15, f5);
/* 585 */           putVertex(this.vertices, j, TMP_V6
/* 586 */               .set(-TMP_V1.x - TMP_V2.x, -TMP_V1.y - TMP_V2.y, -TMP_V1.z - TMP_V2.z).mul(TMP_M3).add(f6, f7, f3), f8, f11, f2, f13, f14, f4);
/*     */           
/* 588 */           j += this.currentVertexSize;
/* 589 */           putVertex(this.vertices, j, TMP_V6
/* 590 */               .set(TMP_V1.x - TMP_V2.x, TMP_V1.y - TMP_V2.y, TMP_V1.z - TMP_V2.z).mul(TMP_M3).add(f6, f7, f3), f10, f11, f2, f13, f14, f4);
/*     */           
/* 592 */           j += this.currentVertexSize;
/* 593 */           putVertex(this.vertices, j, TMP_V6
/* 594 */               .set(TMP_V1.x + TMP_V2.x, TMP_V1.y + TMP_V2.y, TMP_V1.z + TMP_V2.z).mul(TMP_M3).add(f6, f7, f3), f10, f9, f2, f13, f14, f4);
/*     */           
/* 596 */           j += this.currentVertexSize;
/* 597 */           putVertex(this.vertices, j, TMP_V6
/* 598 */               .set(-TMP_V1.x + TMP_V2.x, -TMP_V1.y + TMP_V2.y, -TMP_V1.z + TMP_V2.z).mul(TMP_M3).add(f6, f7, f3), f8, f9, f2, f13, f14, f4);
/*     */         } else {
/*     */           
/* 601 */           putVertex(this.vertices, j, TMP_V6
/* 602 */               .set(-TMP_V1.x - TMP_V2.x + f6, -TMP_V1.y - TMP_V2.y + f7, -TMP_V1.z - TMP_V2.z + f3), f8, f11, f2, f13, f14, f4);
/* 603 */           j += this.currentVertexSize;
/* 604 */           putVertex(this.vertices, j, TMP_V6
/* 605 */               .set(TMP_V1.x - TMP_V2.x + f6, TMP_V1.y - TMP_V2.y + f7, TMP_V1.z - TMP_V2.z + f3), f10, f11, f2, f13, f14, f4);
/* 606 */           j += this.currentVertexSize;
/* 607 */           putVertex(this.vertices, j, TMP_V6
/* 608 */               .set(TMP_V1.x + TMP_V2.x + f6, TMP_V1.y + TMP_V2.y + f7, TMP_V1.z + TMP_V2.z + f3), f10, f9, f2, f13, f14, f4);
/* 609 */           j += this.currentVertexSize;
/* 610 */           putVertex(this.vertices, j, TMP_V6
/* 611 */               .set(-TMP_V1.x + TMP_V2.x + f6, -TMP_V1.y + TMP_V2.y + f7, -TMP_V1.z + TMP_V2.z + f3), f8, f9, f2, f13, f14, f4);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void flush(int[] paramArrayOfint) {
/* 621 */     if (this.useGPU)
/*     */     
/* 623 */     { fillVerticesGPU(paramArrayOfint);
/*     */       
/*     */        }
/*     */     
/* 627 */     else if (this.mode == ParticleShader.AlignMode.Screen)
/* 628 */     { fillVerticesToScreenCPU(paramArrayOfint); }
/* 629 */     else if (this.mode == ParticleShader.AlignMode.ViewPoint) { fillVerticesToViewPointCPU(paramArrayOfint); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 636 */     int i = this.bufferedParticlesCount << 2;
/* 637 */     for (int j = 0; j < i; j += k) {
/* 638 */       int k = Math.min(i - j, 32764);
/*     */       Renderable renderable;
/* 640 */       (renderable = (Renderable)this.renderablePool.obtain()).meshPart.size = k / 4 * 6;
/* 641 */       renderable.meshPart.mesh.setVertices(this.vertices, this.currentVertexSize * j, this.currentVertexSize * k);
/* 642 */       renderable.meshPart.update();
/* 643 */       this.renderables.add(renderable);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void getRenderables(Array<Renderable> paramArray, Pool<Renderable> paramPool) {
/* 649 */     for (Array.ArrayIterator<Renderable> arrayIterator = this.renderables.iterator(); arrayIterator.hasNext(); ) { Renderable renderable = arrayIterator.next();
/* 650 */       paramArray.add(((Renderable)paramPool.obtain()).set(renderable)); }
/*     */   
/*     */   }
/*     */   
/*     */   public void save(AssetManager paramAssetManager, ResourceData paramResourceData) {
/*     */     ResourceData.SaveData saveData;
/* 656 */     (saveData = paramResourceData.createSaveData("billboardBatch")).save("cfg", new Config(this.useGPU, this.mode));
/* 657 */     saveData.saveAsset(paramAssetManager.getAssetFileName(this.texture), Texture.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(AssetManager paramAssetManager, ResourceData paramResourceData) {
/*     */     ResourceData.SaveData saveData;
/* 663 */     if ((saveData = paramResourceData.getSaveData("billboardBatch")) != null) {
/* 664 */       setTexture((Texture)paramAssetManager.get(saveData.loadAsset()));
/* 665 */       Config config = (Config)saveData.load("cfg");
/* 666 */       setUseGpu(config.useGPU);
/* 667 */       setAlignMode(config.mode);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\batches\BillboardParticleBatch.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */