/*     */ package com.badlogic.gdx.graphics.g3d.particles;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.assets.AssetManager;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.emitters.Emitter;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.influencers.Influencer;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.renderers.ParticleControllerRenderer;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Quaternion;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.math.collision.BoundingBox;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
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
/*     */ public class ParticleController
/*     */   implements ResourceData.Configurable, Json.Serializable
/*     */ {
/*     */   protected static final float DEFAULT_TIME_STEP = 0.016666668F;
/*     */   public String name;
/*     */   public Emitter emitter;
/*     */   public Array<Influencer> influencers;
/*     */   public ParticleControllerRenderer<?, ?> renderer;
/*     */   public ParallelArray particles;
/*     */   public ParticleChannels particleChannels;
/*     */   public Matrix4 transform;
/*     */   public Vector3 scale;
/*     */   protected BoundingBox boundingBox;
/*     */   public float deltaTime;
/*     */   public float deltaTimeSqr;
/*     */   
/*     */   public ParticleController() {
/*  71 */     this.transform = new Matrix4();
/*  72 */     this.scale = new Vector3(1.0F, 1.0F, 1.0F);
/*  73 */     this.influencers = new Array(true, 3, Influencer.class);
/*  74 */     setTimeStep(0.016666668F);
/*     */   }
/*     */ 
/*     */   
/*     */   public ParticleController(String paramString, Emitter paramEmitter, ParticleControllerRenderer<?, ?> paramParticleControllerRenderer, Influencer... paramVarArgs) {
/*  79 */     this();
/*  80 */     this.name = paramString;
/*  81 */     this.emitter = paramEmitter;
/*  82 */     this.renderer = paramParticleControllerRenderer;
/*  83 */     this.particleChannels = new ParticleChannels();
/*  84 */     this.influencers = new Array((Object[])paramVarArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setTimeStep(float paramFloat) {
/*  89 */     this.deltaTime = paramFloat;
/*  90 */     this.deltaTimeSqr = this.deltaTime * this.deltaTime;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransform(Matrix4 paramMatrix4) {
/*  96 */     this.transform.set(paramMatrix4);
/*  97 */     paramMatrix4.getScale(this.scale);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTransform(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {
/* 102 */     this.transform.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat8, paramFloat8);
/* 103 */     this.scale.set(paramFloat8, paramFloat8, paramFloat8);
/*     */   }
/*     */ 
/*     */   
/*     */   public void rotate(Quaternion paramQuaternion) {
/* 108 */     this.transform.rotate(paramQuaternion);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rotate(Vector3 paramVector3, float paramFloat) {
/* 115 */     this.transform.rotate(paramVector3, paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public void translate(Vector3 paramVector3) {
/* 120 */     this.transform.translate(paramVector3);
/*     */   }
/*     */   
/*     */   public void setTranslation(Vector3 paramVector3) {
/* 124 */     this.transform.setTranslation(paramVector3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void scale(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 129 */     this.transform.scale(paramFloat1, paramFloat2, paramFloat3);
/* 130 */     this.transform.getScale(this.scale);
/*     */   }
/*     */ 
/*     */   
/*     */   public void scale(Vector3 paramVector3) {
/* 135 */     scale(paramVector3.x, paramVector3.y, paramVector3.z);
/*     */   }
/*     */ 
/*     */   
/*     */   public void mul(Matrix4 paramMatrix4) {
/* 140 */     this.transform.mul(paramMatrix4);
/* 141 */     this.transform.getScale(this.scale);
/*     */   }
/*     */ 
/*     */   
/*     */   public void getTransform(Matrix4 paramMatrix4) {
/* 146 */     paramMatrix4.set(this.transform);
/*     */   }
/*     */   
/*     */   public boolean isComplete() {
/* 150 */     return this.emitter.isComplete();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init() {
/* 156 */     bind();
/* 157 */     if (this.particles != null) {
/* 158 */       end();
/* 159 */       this.particleChannels.resetIds();
/*     */     } 
/* 161 */     allocateChannels(this.emitter.maxParticleCount);
/*     */     
/* 163 */     this.emitter.init();
/* 164 */     for (Array.ArrayIterator<Influencer> arrayIterator = this.influencers.iterator(); arrayIterator.hasNext();)
/* 165 */       (influencer = arrayIterator.next()).init(); 
/* 166 */     this.renderer.init();
/*     */   }
/*     */   
/*     */   protected void allocateChannels(int paramInt) {
/* 170 */     this.particles = new ParallelArray(paramInt);
/*     */     
/* 172 */     this.emitter.allocateChannels();
/* 173 */     for (Array.ArrayIterator<Influencer> arrayIterator = this.influencers.iterator(); arrayIterator.hasNext();)
/* 174 */       (influencer = arrayIterator.next()).allocateChannels(); 
/* 175 */     this.renderer.allocateChannels();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void bind() {
/* 180 */     this.emitter.set(this);
/* 181 */     for (Array.ArrayIterator<Influencer> arrayIterator = this.influencers.iterator(); arrayIterator.hasNext();)
/* 182 */       (influencer = arrayIterator.next()).set(this); 
/* 183 */     this.renderer.set(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void start() {
/* 188 */     this.emitter.start();
/* 189 */     for (Array.ArrayIterator<Influencer> arrayIterator = this.influencers.iterator(); arrayIterator.hasNext();) {
/* 190 */       (influencer = arrayIterator.next()).start();
/*     */     }
/*     */   }
/*     */   
/*     */   public void reset() {
/* 195 */     end();
/* 196 */     start();
/*     */   }
/*     */ 
/*     */   
/*     */   public void end() {
/* 201 */     for (Array.ArrayIterator<Influencer> arrayIterator = this.influencers.iterator(); arrayIterator.hasNext();)
/* 202 */       (influencer = arrayIterator.next()).end(); 
/* 203 */     this.emitter.end();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void activateParticles(int paramInt1, int paramInt2) {
/* 209 */     this.emitter.activateParticles(paramInt1, paramInt2);
/* 210 */     for (Array.ArrayIterator<Influencer> arrayIterator = this.influencers.iterator(); arrayIterator.hasNext();) {
/* 211 */       (influencer = arrayIterator.next()).activateParticles(paramInt1, paramInt2);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void killParticles(int paramInt1, int paramInt2) {
/* 217 */     this.emitter.killParticles(paramInt1, paramInt2);
/* 218 */     for (Array.ArrayIterator<Influencer> arrayIterator = this.influencers.iterator(); arrayIterator.hasNext();) {
/* 219 */       (influencer = arrayIterator.next()).killParticles(paramInt1, paramInt2);
/*     */     }
/*     */   }
/*     */   
/*     */   public void update() {
/* 224 */     update(Gdx.graphics.getDeltaTime());
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(float paramFloat) {
/* 229 */     setTimeStep(paramFloat);
/* 230 */     this.emitter.update();
/* 231 */     for (Array.ArrayIterator<Influencer> arrayIterator = this.influencers.iterator(); arrayIterator.hasNext();) {
/* 232 */       (influencer = arrayIterator.next()).update();
/*     */     }
/*     */   }
/*     */   
/*     */   public void draw() {
/* 237 */     if (this.particles.size > 0) {
/* 238 */       this.renderer.update();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ParticleController copy() {
/* 244 */     Emitter emitter = (Emitter)this.emitter.copy();
/* 245 */     Influencer[] arrayOfInfluencer = new Influencer[this.influencers.size];
/* 246 */     byte b = 0;
/* 247 */     for (Array.ArrayIterator<Influencer> arrayIterator = this.influencers.iterator(); arrayIterator.hasNext(); ) { Influencer influencer = arrayIterator.next();
/* 248 */       arrayOfInfluencer[b++] = (Influencer)influencer.copy(); }
/*     */     
/* 250 */     return new ParticleController(new String(this.name), emitter, (ParticleControllerRenderer<?, ?>)this.renderer.copy(), arrayOfInfluencer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 255 */     this.emitter.dispose();
/* 256 */     for (Array.ArrayIterator<Influencer> arrayIterator = this.influencers.iterator(); arrayIterator.hasNext();) {
/* 257 */       (influencer = arrayIterator.next()).dispose();
/*     */     }
/*     */   }
/*     */   
/*     */   public BoundingBox getBoundingBox() {
/* 262 */     if (this.boundingBox == null) this.boundingBox = new BoundingBox(); 
/* 263 */     calculateBoundingBox();
/* 264 */     return this.boundingBox;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void calculateBoundingBox() {
/* 269 */     this.boundingBox.clr();
/* 270 */     ParallelArray.FloatChannel floatChannel = this.particles.<ParallelArray.FloatChannel>getChannel(ParticleChannels.Position);
/* 271 */     for (int i = 0, j = floatChannel.strideSize * this.particles.size; i < j; i += floatChannel.strideSize) {
/* 272 */       this.boundingBox.ext(floatChannel.data[i], floatChannel.data[i + 1], floatChannel.data[i + 2]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private <K extends Influencer> int findIndex(Class<K> paramClass) {
/* 279 */     for (byte b = 0; b < this.influencers.size; b++) {
/* 280 */       Influencer influencer = (Influencer)this.influencers.get(b);
/* 281 */       if (ClassReflection.isAssignableFrom(paramClass, influencer.getClass())) {
/* 282 */         return b;
/*     */       }
/*     */     } 
/* 285 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public <K extends Influencer> K findInfluencer(Class<K> paramClass) {
/*     */     int i;
/* 291 */     return (K)(((i = findIndex(paramClass)) >= 0) ? (Influencer)this.influencers.get(i) : null);
/*     */   }
/*     */ 
/*     */   
/*     */   public <K extends Influencer> void removeInfluencer(Class<K> paramClass) {
/*     */     int i;
/* 297 */     if ((i = findIndex(paramClass)) >= 0) this.influencers.removeIndex(i);
/*     */   
/*     */   }
/*     */   
/*     */   public <K extends Influencer> boolean replaceInfluencer(Class<K> paramClass, K paramK) {
/*     */     int i;
/* 303 */     if ((i = findIndex(paramClass)) >= 0) {
/* 304 */       this.influencers.insert(i, paramK);
/* 305 */       this.influencers.removeIndex(i + 1);
/* 306 */       return true;
/*     */     } 
/* 308 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(Json paramJson) {
/* 313 */     paramJson.writeValue("name", this.name);
/* 314 */     paramJson.writeValue("emitter", this.emitter, Emitter.class);
/* 315 */     paramJson.writeValue("influencers", this.influencers, Array.class, Influencer.class);
/* 316 */     paramJson.writeValue("renderer", this.renderer, ParticleControllerRenderer.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Json paramJson, JsonValue paramJsonValue) {
/* 321 */     this.name = (String)paramJson.readValue("name", String.class, paramJsonValue);
/* 322 */     this.emitter = (Emitter)paramJson.readValue("emitter", Emitter.class, paramJsonValue);
/* 323 */     this.influencers.addAll((Array)paramJson.readValue("influencers", Array.class, Influencer.class, paramJsonValue));
/* 324 */     this.renderer = (ParticleControllerRenderer<?, ?>)paramJson.readValue("renderer", ParticleControllerRenderer.class, paramJsonValue);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(AssetManager paramAssetManager, ResourceData paramResourceData) {
/* 329 */     this.emitter.save(paramAssetManager, paramResourceData);
/* 330 */     for (Array.ArrayIterator<Influencer> arrayIterator = this.influencers.iterator(); arrayIterator.hasNext();)
/* 331 */       (influencer = arrayIterator.next()).save(paramAssetManager, paramResourceData); 
/* 332 */     this.renderer.save(paramAssetManager, paramResourceData);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(AssetManager paramAssetManager, ResourceData paramResourceData) {
/* 337 */     this.emitter.load(paramAssetManager, paramResourceData);
/* 338 */     for (Array.ArrayIterator<Influencer> arrayIterator = this.influencers.iterator(); arrayIterator.hasNext();)
/* 339 */       (influencer = arrayIterator.next()).load(paramAssetManager, paramResourceData); 
/* 340 */     this.renderer.load(paramAssetManager, paramResourceData);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\ParticleController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */