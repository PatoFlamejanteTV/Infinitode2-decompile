/*     */ package com.badlogic.gdx.graphics.g3d.environment;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Camera;
/*     */ import com.badlogic.gdx.graphics.OrthographicCamera;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
/*     */ import com.badlogic.gdx.graphics.glutils.FrameBuffer;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.Disposable;
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
/*     */ public class DirectionalShadowLight
/*     */   extends DirectionalLight
/*     */   implements ShadowMap, Disposable
/*     */ {
/*     */   protected FrameBuffer fbo;
/*     */   protected Camera cam;
/*     */   protected float halfDepth;
/*     */   protected float halfHeight;
/*  37 */   protected final Vector3 tmpV = new Vector3();
/*     */   
/*     */   protected final TextureDescriptor textureDesc;
/*     */   
/*     */   public DirectionalShadowLight(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  42 */     this.fbo = new FrameBuffer(Pixmap.Format.RGBA8888, paramInt1, paramInt2, true);
/*  43 */     this.cam = (Camera)new OrthographicCamera(paramFloat1, paramFloat2);
/*  44 */     this.cam.near = paramFloat3;
/*  45 */     this.cam.far = paramFloat4;
/*  46 */     this.halfHeight = paramFloat2 * 0.5F;
/*  47 */     this.halfDepth = paramFloat3 + 0.5F * (paramFloat4 - paramFloat3);
/*  48 */     this.textureDesc = new TextureDescriptor();
/*  49 */     this.textureDesc.minFilter = this.textureDesc.magFilter = Texture.TextureFilter.Nearest;
/*  50 */     this.textureDesc.uWrap = this.textureDesc.vWrap = Texture.TextureWrap.ClampToEdge;
/*     */   }
/*     */   
/*     */   public void update(Camera paramCamera) {
/*  54 */     update(this.tmpV.set(paramCamera.direction).scl(this.halfHeight), paramCamera.direction);
/*     */   }
/*     */   
/*     */   public void update(Vector3 paramVector31, Vector3 paramVector32) {
/*  58 */     this.cam.position.set(this.direction).scl(-this.halfDepth).add(paramVector31);
/*  59 */     this.cam.direction.set(this.direction).nor();
/*  60 */     this.cam.normalizeUp();
/*  61 */     this.cam.update();
/*     */   }
/*     */   
/*     */   public void begin(Camera paramCamera) {
/*  65 */     update(paramCamera);
/*  66 */     begin();
/*     */   }
/*     */   
/*     */   public void begin(Vector3 paramVector31, Vector3 paramVector32) {
/*  70 */     update(paramVector31, paramVector32);
/*  71 */     begin();
/*     */   }
/*     */   
/*     */   public void begin() {
/*  75 */     int i = this.fbo.getWidth();
/*  76 */     int j = this.fbo.getHeight();
/*  77 */     this.fbo.begin();
/*  78 */     Gdx.gl.glViewport(0, 0, i, j);
/*  79 */     Gdx.gl.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
/*  80 */     Gdx.gl.glClear(16640);
/*  81 */     Gdx.gl.glEnable(3089);
/*  82 */     Gdx.gl.glScissor(1, 1, i - 2, j - 2);
/*     */   }
/*     */   
/*     */   public void end() {
/*  86 */     Gdx.gl.glDisable(3089);
/*  87 */     this.fbo.end();
/*     */   }
/*     */   
/*     */   public FrameBuffer getFrameBuffer() {
/*  91 */     return this.fbo;
/*     */   }
/*     */   
/*     */   public Camera getCamera() {
/*  95 */     return this.cam;
/*     */   }
/*     */ 
/*     */   
/*     */   public Matrix4 getProjViewTrans() {
/* 100 */     return this.cam.combined;
/*     */   }
/*     */ 
/*     */   
/*     */   public TextureDescriptor getDepthMap() {
/* 105 */     this.textureDesc.texture = this.fbo.getColorBufferTexture();
/* 106 */     return this.textureDesc;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 111 */     if (this.fbo != null) this.fbo.dispose(); 
/* 112 */     this.fbo = null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\environment\DirectionalShadowLight.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */