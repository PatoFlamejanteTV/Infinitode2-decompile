/*     */ package com.badlogic.gdx.graphics.g3d;
/*     */ 
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Camera;
/*     */ import com.badlogic.gdx.graphics.g3d.utils.DefaultRenderableSorter;
/*     */ import com.badlogic.gdx.graphics.g3d.utils.DefaultShaderProvider;
/*     */ import com.badlogic.gdx.graphics.g3d.utils.DefaultTextureBinder;
/*     */ import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
/*     */ import com.badlogic.gdx.graphics.g3d.utils.RenderableSorter;
/*     */ import com.badlogic.gdx.graphics.g3d.utils.ShaderProvider;
/*     */ import com.badlogic.gdx.graphics.g3d.utils.TextureBinder;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.FlushablePool;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*     */ public class ModelBatch
/*     */   implements Disposable
/*     */ {
/*     */   protected Camera camera;
/*     */   
/*     */   protected static class RenderablePool
/*     */     extends FlushablePool<Renderable>
/*     */   {
/*     */     protected Renderable newObject() {
/*  47 */       return new Renderable();
/*     */     }
/*     */ 
/*     */     
/*     */     public Renderable obtain() {
/*     */       Renderable renderable;
/*  53 */       (renderable = (Renderable)super.obtain()).environment = null;
/*  54 */       renderable.material = null;
/*  55 */       renderable.meshPart.set("", null, 0, 0, 0);
/*  56 */       renderable.shader = null;
/*  57 */       renderable.userData = null;
/*  58 */       return renderable;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*  63 */   protected final RenderablePool renderablesPool = new RenderablePool();
/*     */   
/*  65 */   protected final Array<Renderable> renderables = new Array();
/*     */ 
/*     */   
/*     */   protected final RenderContext context;
/*     */ 
/*     */   
/*     */   private final boolean ownContext;
/*     */ 
/*     */   
/*     */   protected final ShaderProvider shaderProvider;
/*     */   
/*     */   protected final RenderableSorter sorter;
/*     */ 
/*     */   
/*     */   public ModelBatch(RenderContext paramRenderContext, ShaderProvider paramShaderProvider, RenderableSorter paramRenderableSorter) {
/*  80 */     this.sorter = (paramRenderableSorter == null) ? (RenderableSorter)new DefaultRenderableSorter() : paramRenderableSorter;
/*  81 */     this.ownContext = (paramRenderContext == null);
/*  82 */     this.context = (paramRenderContext == null) ? new RenderContext((TextureBinder)new DefaultTextureBinder(1, 1)) : paramRenderContext;
/*  83 */     this.shaderProvider = (paramShaderProvider == null) ? (ShaderProvider)new DefaultShaderProvider() : paramShaderProvider;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelBatch(RenderContext paramRenderContext, ShaderProvider paramShaderProvider) {
/*  91 */     this(paramRenderContext, paramShaderProvider, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelBatch(RenderContext paramRenderContext, RenderableSorter paramRenderableSorter) {
/*  99 */     this(paramRenderContext, null, paramRenderableSorter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelBatch(RenderContext paramRenderContext) {
/* 106 */     this(paramRenderContext, null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelBatch(ShaderProvider paramShaderProvider, RenderableSorter paramRenderableSorter) {
/* 113 */     this(null, paramShaderProvider, paramRenderableSorter);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelBatch(RenderableSorter paramRenderableSorter) {
/* 119 */     this(null, null, paramRenderableSorter);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelBatch(ShaderProvider paramShaderProvider) {
/* 125 */     this(null, paramShaderProvider, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelBatch(FileHandle paramFileHandle1, FileHandle paramFileHandle2) {
/* 133 */     this(null, (ShaderProvider)new DefaultShaderProvider(paramFileHandle1, paramFileHandle2), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelBatch(String paramString1, String paramString2) {
/* 141 */     this(null, (ShaderProvider)new DefaultShaderProvider(paramString1, paramString2), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelBatch() {
/* 146 */     this(null, null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void begin(Camera paramCamera) {
/* 154 */     if (this.camera != null) throw new GdxRuntimeException("Call end() first."); 
/* 155 */     this.camera = paramCamera;
/* 156 */     if (this.ownContext) this.context.begin();
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCamera(Camera paramCamera) {
/* 163 */     if (this.camera == null) throw new GdxRuntimeException("Call begin() first."); 
/* 164 */     if (this.renderables.size > 0) flush(); 
/* 165 */     this.camera = paramCamera;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Camera getCamera() {
/* 172 */     return this.camera;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean ownsRenderContext() {
/* 180 */     return this.ownContext;
/*     */   }
/*     */ 
/*     */   
/*     */   public RenderContext getRenderContext() {
/* 185 */     return this.context;
/*     */   }
/*     */ 
/*     */   
/*     */   public ShaderProvider getShaderProvider() {
/* 190 */     return this.shaderProvider;
/*     */   }
/*     */ 
/*     */   
/*     */   public RenderableSorter getRenderableSorter() {
/* 195 */     return this.sorter;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() {
/* 201 */     this.sorter.sort(this.camera, this.renderables);
/* 202 */     Shader shader = null;
/* 203 */     for (byte b = 0; b < this.renderables.size; b++) {
/* 204 */       Renderable renderable = (Renderable)this.renderables.get(b);
/* 205 */       if (shader != renderable.shader) {
/* 206 */         if (shader != null) shader.end();
/*     */         
/* 208 */         (shader = renderable.shader).begin(this.camera, this.context);
/*     */       } 
/* 210 */       shader.render(renderable);
/*     */     } 
/* 212 */     if (shader != null) shader.end(); 
/* 213 */     this.renderablesPool.flush();
/* 214 */     this.renderables.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void end() {
/* 221 */     flush();
/* 222 */     if (this.ownContext) this.context.end(); 
/* 223 */     this.camera = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderable paramRenderable) {
/* 230 */     paramRenderable.shader = this.shaderProvider.getShader(paramRenderable);
/* 231 */     this.renderables.add(paramRenderable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(RenderableProvider paramRenderableProvider) {
/* 238 */     int j = this.renderables.size;
/* 239 */     paramRenderableProvider.getRenderables(this.renderables, (Pool<Renderable>)this.renderablesPool);
/* 240 */     for (int i = j; i < this.renderables.size; i++) {
/*     */       Renderable renderable;
/* 242 */       (renderable = (Renderable)this.renderables.get(i)).shader = this.shaderProvider.getShader(renderable);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends RenderableProvider> void render(Iterable<T> paramIterable) {
/* 250 */     for (RenderableProvider renderableProvider : paramIterable) {
/* 251 */       render(renderableProvider);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(RenderableProvider paramRenderableProvider, Environment paramEnvironment) {
/* 260 */     int j = this.renderables.size;
/* 261 */     paramRenderableProvider.getRenderables(this.renderables, (Pool<Renderable>)this.renderablesPool);
/* 262 */     for (int i = j; i < this.renderables.size; i++) {
/*     */       Renderable renderable;
/* 264 */       (renderable = (Renderable)this.renderables.get(i)).environment = paramEnvironment;
/* 265 */       renderable.shader = this.shaderProvider.getShader(renderable);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends RenderableProvider> void render(Iterable<T> paramIterable, Environment paramEnvironment) {
/* 275 */     for (RenderableProvider renderableProvider : paramIterable) {
/* 276 */       render(renderableProvider, paramEnvironment);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(RenderableProvider paramRenderableProvider, Shader paramShader) {
/* 285 */     int j = this.renderables.size;
/* 286 */     paramRenderableProvider.getRenderables(this.renderables, (Pool<Renderable>)this.renderablesPool);
/* 287 */     for (int i = j; i < this.renderables.size; i++) {
/*     */       Renderable renderable;
/* 289 */       (renderable = (Renderable)this.renderables.get(i)).shader = paramShader;
/* 290 */       renderable.shader = this.shaderProvider.getShader(renderable);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends RenderableProvider> void render(Iterable<T> paramIterable, Shader paramShader) {
/* 300 */     for (RenderableProvider renderableProvider : paramIterable) {
/* 301 */       render(renderableProvider, paramShader);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(RenderableProvider paramRenderableProvider, Environment paramEnvironment, Shader paramShader) {
/* 312 */     int j = this.renderables.size;
/* 313 */     paramRenderableProvider.getRenderables(this.renderables, (Pool<Renderable>)this.renderablesPool);
/* 314 */     for (int i = j; i < this.renderables.size; i++) {
/*     */       Renderable renderable;
/* 316 */       (renderable = (Renderable)this.renderables.get(i)).environment = paramEnvironment;
/* 317 */       renderable.shader = paramShader;
/* 318 */       renderable.shader = this.shaderProvider.getShader(renderable);
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
/*     */   public <T extends RenderableProvider> void render(Iterable<T> paramIterable, Environment paramEnvironment, Shader paramShader) {
/* 331 */     for (RenderableProvider renderableProvider : paramIterable) {
/* 332 */       render(renderableProvider, paramEnvironment, paramShader);
/*     */     }
/*     */   }
/*     */   
/*     */   public void dispose() {
/* 337 */     this.shaderProvider.dispose();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\ModelBatch.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */