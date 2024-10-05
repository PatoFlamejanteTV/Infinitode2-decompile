/*     */ package com.prineside.tdi2.ui.actors;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Camera;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.PerspectiveCamera;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.PixmapIO;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.graphics.g3d.Attribute;
/*     */ import com.badlogic.gdx.graphics.g3d.Environment;
/*     */ import com.badlogic.gdx.graphics.g3d.Material;
/*     */ import com.badlogic.gdx.graphics.g3d.Model;
/*     */ import com.badlogic.gdx.graphics.g3d.ModelCache;
/*     */ import com.badlogic.gdx.graphics.g3d.ModelInstance;
/*     */ import com.badlogic.gdx.graphics.g3d.RenderableProvider;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
/*     */ import com.badlogic.gdx.graphics.g3d.model.Node;
/*     */ import com.badlogic.gdx.graphics.g3d.model.NodePart;
/*     */ import com.badlogic.gdx.graphics.glutils.FrameBuffer;
/*     */ import com.badlogic.gdx.graphics.glutils.GLFrameBuffer;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.BufferUtils;
/*     */ import com.badlogic.gdx.utils.ScreenUtils;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public class ModelView extends Actor implements Disposable {
/*  33 */   private static final TLog j = TLog.forClass(ModelView.class);
/*     */   
/*     */   public PerspectiveCamera camera;
/*     */   
/*     */   public ModelInstance model;
/*     */   public Environment environment;
/*     */   private FrameBuffer k;
/*     */   private FrameBuffer l;
/*     */   public ModelCache modelCache;
/*     */   private TextureRegion m;
/*     */   private Transformer n;
/*     */   
/*  45 */   public static final Transformer rotateModelAround = new Transformer()
/*     */     {
/*     */       public void transform(ModelView param1ModelView, float param1Float1, float param1Float2) {
/*  48 */         if (param1ModelView.model == null)
/*     */           return; 
/*  50 */         param1ModelView.model.transform.rotate(Vector3.Y, param1Float1 * 30.0F);
/*  51 */         param1ModelView.model.calculateTransforms();
/*     */ 
/*     */         
/*  54 */         param1ModelView.requireModelCacheUpdate();
/*  55 */         param1ModelView.requireRedraw();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public boolean modelCacheUpdateRequired;
/*     */   
/*     */   private boolean o;
/*     */   
/*     */   private float p;
/*     */   
/*     */   private boolean q;
/*     */   
/*     */   private String r;
/*     */   
/*     */   public int width;
/*     */   
/*     */   public int height;
/*     */   private boolean s;
/*     */   
/*     */   public ModelView(int paramInt1, int paramInt2, Transformer paramTransformer, Environment paramEnvironment, boolean paramBoolean) {
/*  76 */     if (paramEnvironment == null) {
/*     */       
/*  78 */       (paramEnvironment = new Environment()).set((Attribute)new ColorAttribute(ColorAttribute.AmbientLight, 0.3F, 0.3F, 0.3F, 1.0F));
/*  79 */       paramEnvironment.add((new DirectionalLight()).set(0.75F, 0.75F, 0.75F, -0.5F, -1.0F, -0.2F));
/*     */     } 
/*     */     
/*  82 */     this.environment = paramEnvironment;
/*  83 */     this.n = paramTransformer;
/*  84 */     this.s = paramBoolean;
/*     */     
/*  86 */     this.modelCache = new ModelCache();
/*     */     
/*  88 */     setSize(paramInt1, paramInt2);
/*     */     
/*  90 */     requireModelCacheUpdate();
/*  91 */     requireRedraw();
/*     */   }
/*     */   
/*     */   public void setSize(int paramInt1, int paramInt2) {
/*  95 */     if (paramInt1 < 32 || paramInt2 < 24) {
/*     */       
/*  97 */       paramInt1 = 32;
/*  98 */       paramInt2 = 32;
/*     */     } 
/* 100 */     if (this.width != paramInt1 || this.height != paramInt2) {
/* 101 */       if (this.l != null) this.l.dispose(); 
/* 102 */       if (this.k != null) this.k.dispose();
/*     */       
/* 104 */       this.height = paramInt2;
/* 105 */       this.width = paramInt1;
/*     */       
/* 107 */       if (!this.s) {
/* 108 */         if (Gdx.graphics.isGL32Available() && Game.i.renderingManager.getMSAASampleCount() > 1) {
/*     */           try {
/* 110 */             this
/*     */ 
/*     */               
/* 113 */               .k = (FrameBuffer)(new GLFrameBuffer.FrameBufferBuilder(paramInt1, paramInt2, Game.i.renderingManager.getMSAASampleCount())).addColorRenderBuffer(32856).addBasicDepthRenderBuffer().build();
/* 114 */           } catch (Exception exception) {
/* 115 */             j.w("Failed to create MSAA buffer, fall back to the regular buffer", new Object[] { exception });
/* 116 */             this.k = null;
/*     */           } 
/*     */         }
/* 119 */         this.l = new FrameBuffer(Pixmap.Format.RGBA8888, paramInt1, paramInt2, true);
/* 120 */         this.m = new TextureRegion((Texture)this.l.getColorBufferTexture());
/* 121 */         this.m.flip(false, true);
/*     */ 
/*     */         
/* 124 */         float f = 1.0F / paramInt2;
/* 125 */         this.m.setU(this.m.getU() + f);
/* 126 */         this.m.setV(this.m.getV() - f);
/* 127 */         this.m.setU2(this.m.getU2() - f);
/* 128 */         this.m.setV2(this.m.getV2() + f);
/* 129 */         this.m.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
/*     */       } 
/*     */       
/* 132 */       this.camera = new PerspectiveCamera(67.0F, paramInt1, paramInt2);
/* 133 */       this.camera.position.set(1.0F, 0.25F, 0.0F);
/* 134 */       this.camera.lookAt(0.0F, 0.0F, 0.0F);
/* 135 */       this.camera.near = 0.01F;
/* 136 */       this.camera.far = 300.0F;
/* 137 */       this.camera.update();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void requireRedraw() {
/* 145 */     this.o = true;
/*     */   }
/*     */   
/*     */   public void requireModelCacheUpdate() {
/* 149 */     this.modelCacheUpdateRequired = true;
/*     */   }
/*     */   
/*     */   public void setTransformer(Transformer paramTransformer) {
/* 153 */     this.n = paramTransformer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnvironment(Environment paramEnvironment) {
/* 162 */     if (paramEnvironment == null) throw new IllegalArgumentException("Environment can't be null");
/*     */     
/* 164 */     this.environment = paramEnvironment;
/* 165 */     requireRedraw();
/*     */   }
/*     */   
/*     */   public void setModel(ModelInstance paramModelInstance, float paramFloat) {
/* 169 */     this.model = paramModelInstance;
/* 170 */     paramModelInstance.transform.setToTranslationAndScaling(new Vector3(0.0F, 0.0F, 0.0F), new Vector3(paramFloat, paramFloat, paramFloat));
/*     */     
/* 172 */     requireModelCacheUpdate();
/* 173 */     requireRedraw();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setModelPart(Model paramModel, String paramString, Material paramMaterial, float paramFloat) {
/*     */     ModelInstance modelInstance;
/*     */     Node node;
/* 180 */     (node = (modelInstance = new ModelInstance(paramModel, paramString, true, true, true)).getNode(paramString)).translation.set(0.0F, 0.0F, 0.0F);
/* 181 */     node.rotation.setFromAxis(Vector3.X, -90.0F);
/* 182 */     if (paramMaterial != null) {
/* 183 */       for (byte b = 0; b < node.parts.size; b++) {
/* 184 */         ((NodePart)node.parts.get(b)).material = paramMaterial;
/*     */       }
/*     */     }
/* 187 */     modelInstance.calculateTransforms();
/*     */     
/* 189 */     setModel(modelInstance, paramFloat);
/*     */   }
/*     */   
/*     */   public void saveScreenshot(String paramString) {
/* 193 */     this.q = true;
/* 194 */     this.r = paramString;
/*     */   }
/*     */   
/*     */   public void updateModelCacheIfRequired() {
/* 198 */     if (this.modelCacheUpdateRequired) {
/* 199 */       if (this.model == null)
/*     */         return; 
/*     */       try {
/* 202 */         this.modelCache.begin();
/* 203 */         this.modelCache.add((RenderableProvider)this.model);
/* 204 */         this.modelCache.end();
/* 205 */       } catch (Exception exception) {
/* 206 */         j.e("failed to update model cache", new Object[] { exception });
/*     */       } 
/* 208 */       this.modelCacheUpdateRequired = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void act(float paramFloat) {
/* 214 */     super.act(paramFloat);
/*     */     
/* 216 */     if (!isVisible())
/*     */       return; 
/* 218 */     this.p += paramFloat;
/* 219 */     if (this.n != null) this.n.transform(this, paramFloat, this.p);
/*     */     
/* 221 */     if (this.s) {
/*     */       
/* 223 */       updateModelCacheIfRequired();
/* 224 */       this.o = false;
/*     */       return;
/*     */     } 
/* 227 */     if ((this.o || this.q) && this.model != null) {
/* 228 */       Game.i.renderingManager.startFBO((this.k == null) ? this.l : this.k, "ModelView");
/*     */       
/* 230 */       Gdx.gl.glClearColor(Config.BACKGROUND_COLOR.r, Config.BACKGROUND_COLOR.g, Config.BACKGROUND_COLOR.b, 0.0F);
/* 231 */       Gdx.gl.glClear(16640);
/*     */       
/* 233 */       Game.i.renderingManager.modelBatch.begin((Camera)this.camera);
/*     */ 
/*     */       
/* 236 */       updateModelCacheIfRequired();
/*     */       
/* 238 */       Game.i.renderingManager.modelBatch.render((RenderableProvider)this.modelCache, this.environment);
/* 239 */       Game.i.renderingManager.modelBatch.end();
/*     */       
/* 241 */       if (this.k != null) {
/* 242 */         this.k.transfer((GLFrameBuffer)this.l);
/*     */       }
/*     */       
/* 245 */       if (this.q) {
/* 246 */         byte[] arrayOfByte = ScreenUtils.getFrameBufferPixels(0, 0, this.l.getWidth(), this.l.getHeight(), true);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 251 */         Pixmap pixmap = new Pixmap(this.l.getWidth(), this.l.getHeight(), Pixmap.Format.RGBA8888);
/* 252 */         BufferUtils.copy(arrayOfByte, 0, pixmap.getPixels(), arrayOfByte.length);
/* 253 */         PixmapIO.writePNG(Gdx.files.local(this.r), pixmap);
/* 254 */         pixmap.dispose();
/*     */         
/* 256 */         this.q = false;
/*     */       } 
/* 258 */       Game.i.renderingManager.endFBO("ModelView");
/*     */       
/* 260 */       this.o = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 267 */     super.draw(paramBatch, paramFloat);
/*     */     
/* 269 */     if (this.model == null)
/*     */       return; 
/* 271 */     if (this.s) {
/* 272 */       paramBatch.end();
/* 273 */       Game.i.renderingManager.modelBatch.begin((Camera)this.camera);
/* 274 */       Game.i.renderingManager.modelBatch.render((RenderableProvider)this.modelCache, this.environment);
/* 275 */       Game.i.renderingManager.modelBatch.end();
/* 276 */       paramBatch.begin(); return;
/*     */     } 
/* 278 */     Color color = getColor();
/* 279 */     paramBatch.setColor(color.r, color.g, color.b, color.a * paramFloat);
/* 280 */     paramBatch.draw(this.m, getX(), getY(), getWidth(), getHeight());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 286 */     if (this.l != null) this.l.dispose(); 
/* 287 */     if (this.k != null) this.k.dispose(); 
/* 288 */     this.modelCache.dispose();
/* 289 */     this.l = null;
/* 290 */     this.k = null;
/*     */   }
/*     */   
/*     */   public static abstract class Transformer {
/*     */     public abstract void transform(ModelView param1ModelView, float param1Float1, float param1Float2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\ModelView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */