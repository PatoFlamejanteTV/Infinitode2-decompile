/*     */ package com.badlogic.gdx.graphics.g2d;
/*     */ 
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.math.collision.BoundingBox;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.StreamUtils;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.Writer;
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
/*     */ public class ParticleEffect
/*     */   implements Disposable
/*     */ {
/*     */   private final Array<ParticleEmitter> emitters;
/*     */   private BoundingBox bounds;
/*     */   private boolean ownsTexture;
/*  42 */   protected float xSizeScale = 1.0F;
/*  43 */   protected float ySizeScale = 1.0F;
/*  44 */   protected float motionScale = 1.0F;
/*     */   
/*     */   public ParticleEffect() {
/*  47 */     this.emitters = new Array(8);
/*     */   }
/*     */   
/*     */   public ParticleEffect(ParticleEffect paramParticleEffect) {
/*  51 */     this.emitters = new Array(true, paramParticleEffect.emitters.size); byte b; int i;
/*  52 */     for (b = 0, i = paramParticleEffect.emitters.size; b < i; b++)
/*  53 */       this.emitters.add(newEmitter((ParticleEmitter)paramParticleEffect.emitters.get(b))); 
/*     */   } public void start() {
/*     */     byte b;
/*     */     int i;
/*  57 */     for (b = 0, i = this.emitters.size; b < i; b++) {
/*  58 */       ((ParticleEmitter)this.emitters.get(b)).start();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/*  64 */     reset(true, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset(boolean paramBoolean) {
/*  71 */     reset(paramBoolean, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset(boolean paramBoolean1, boolean paramBoolean2) {
/*     */     byte b;
/*     */     int i;
/*  79 */     for (b = 0, i = this.emitters.size; b < i; b++)
/*  80 */       ((ParticleEmitter)this.emitters.get(b)).reset(paramBoolean2); 
/*  81 */     if (paramBoolean1 && (this.xSizeScale != 1.0F || this.ySizeScale != 1.0F || this.motionScale != 1.0F)) {
/*  82 */       scaleEffect(1.0F / this.xSizeScale, 1.0F / this.ySizeScale, 1.0F / this.motionScale);
/*  83 */       this.xSizeScale = this.ySizeScale = this.motionScale = 1.0F;
/*     */     } 
/*     */   } public void update(float paramFloat) {
/*     */     byte b;
/*     */     int i;
/*  88 */     for (b = 0, i = this.emitters.size; b < i; b++)
/*  89 */       ((ParticleEmitter)this.emitters.get(b)).update(paramFloat); 
/*     */   } public void draw(Batch paramBatch) {
/*     */     byte b;
/*     */     int i;
/*  93 */     for (b = 0, i = this.emitters.size; b < i; b++)
/*  94 */       ((ParticleEmitter)this.emitters.get(b)).draw(paramBatch); 
/*     */   } public void draw(Batch paramBatch, float paramFloat) {
/*     */     byte b;
/*     */     int i;
/*  98 */     for (b = 0, i = this.emitters.size; b < i; b++)
/*  99 */       ((ParticleEmitter)this.emitters.get(b)).draw(paramBatch, paramFloat); 
/*     */   } public void allowCompletion() {
/*     */     byte b;
/*     */     int i;
/* 103 */     for (b = 0, i = this.emitters.size; b < i; b++)
/* 104 */       ((ParticleEmitter)this.emitters.get(b)).allowCompletion(); 
/*     */   } public boolean isComplete() {
/*     */     byte b;
/*     */     int i;
/* 108 */     for (b = 0, i = this.emitters.size; b < i; b++) {
/*     */       ParticleEmitter particleEmitter;
/* 110 */       if (!(particleEmitter = (ParticleEmitter)this.emitters.get(b)).isComplete()) return false; 
/*     */     } 
/* 112 */     return true;
/*     */   } public void setDuration(int paramInt) {
/*     */     byte b;
/*     */     int i;
/* 116 */     for (b = 0, i = this.emitters.size; b < i; b++) {
/*     */       ParticleEmitter particleEmitter;
/* 118 */       (particleEmitter = (ParticleEmitter)this.emitters.get(b)).setContinuous(false);
/* 119 */       particleEmitter.duration = paramInt;
/* 120 */       particleEmitter.durationTimer = 0.0F;
/*     */     } 
/*     */   } public void setPosition(float paramFloat1, float paramFloat2) {
/*     */     byte b;
/*     */     int i;
/* 125 */     for (b = 0, i = this.emitters.size; b < i; b++)
/* 126 */       ((ParticleEmitter)this.emitters.get(b)).setPosition(paramFloat1, paramFloat2); 
/*     */   } public void setFlip(boolean paramBoolean1, boolean paramBoolean2) {
/*     */     byte b;
/*     */     int i;
/* 130 */     for (b = 0, i = this.emitters.size; b < i; b++)
/* 131 */       ((ParticleEmitter)this.emitters.get(b)).setFlip(paramBoolean1, paramBoolean2); 
/*     */   } public void flipY() {
/*     */     byte b;
/*     */     int i;
/* 135 */     for (b = 0, i = this.emitters.size; b < i; b++)
/* 136 */       ((ParticleEmitter)this.emitters.get(b)).flipY(); 
/*     */   }
/*     */   
/*     */   public Array<ParticleEmitter> getEmitters() {
/* 140 */     return this.emitters;
/*     */   }
/*     */   public ParticleEmitter findEmitter(String paramString) {
/*     */     byte b;
/*     */     int i;
/* 145 */     for (b = 0, i = this.emitters.size; b < i; b++) {
/*     */       ParticleEmitter particleEmitter;
/* 147 */       if ((particleEmitter = (ParticleEmitter)this.emitters.get(b)).getName().equals(paramString)) return particleEmitter; 
/*     */     } 
/* 149 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void preAllocateParticles() {
/* 154 */     for (Array.ArrayIterator<ParticleEmitter> arrayIterator = this.emitters.iterator(); arrayIterator.hasNext();) {
/* 155 */       (particleEmitter = arrayIterator.next()).preAllocateParticles();
/*     */     }
/*     */   }
/*     */   
/*     */   public void save(Writer paramWriter) {
/* 160 */     byte b1 = 0; byte b2; int i;
/* 161 */     for (b2 = 0, i = this.emitters.size; b2 < i; b2++) {
/* 162 */       ParticleEmitter particleEmitter = (ParticleEmitter)this.emitters.get(b2);
/* 163 */       if (b1++ > 0) paramWriter.write("\n"); 
/* 164 */       particleEmitter.save(paramWriter);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void load(FileHandle paramFileHandle1, FileHandle paramFileHandle2) {
/* 169 */     loadEmitters(paramFileHandle1);
/* 170 */     loadEmitterImages(paramFileHandle2);
/*     */   }
/*     */   
/*     */   public void load(FileHandle paramFileHandle, TextureAtlas paramTextureAtlas) {
/* 174 */     load(paramFileHandle, paramTextureAtlas, null);
/*     */   }
/*     */   
/*     */   public void load(FileHandle paramFileHandle, TextureAtlas paramTextureAtlas, String paramString) {
/* 178 */     loadEmitters(paramFileHandle);
/* 179 */     loadEmitterImages(paramTextureAtlas, paramString);
/*     */   }
/*     */   
/*     */   public void loadEmitters(FileHandle paramFileHandle) {
/* 183 */     InputStream inputStream = paramFileHandle.read();
/* 184 */     this.emitters.clear();
/* 185 */     BufferedReader bufferedReader = null;
/*     */     try {
/* 187 */       bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 512);
/*     */       while (true)
/* 189 */       { ParticleEmitter particleEmitter = newEmitter(bufferedReader);
/* 190 */         this.emitters.add(particleEmitter);
/* 191 */         if (bufferedReader.readLine() != null)
/*     */           continue;  break; }  return;
/* 193 */     } catch (IOException iOException) {
/* 194 */       throw new GdxRuntimeException("Error loading effect: " + paramFileHandle, iOException);
/*     */     } finally {
/* 196 */       StreamUtils.closeQuietly(bufferedReader);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void loadEmitterImages(TextureAtlas paramTextureAtlas) {
/* 201 */     loadEmitterImages(paramTextureAtlas, null);
/*     */   } public void loadEmitterImages(TextureAtlas paramTextureAtlas, String paramString) {
/*     */     byte b;
/*     */     int i;
/* 205 */     for (b = 0, i = this.emitters.size; b < i; b++) {
/*     */       ParticleEmitter particleEmitter;
/* 207 */       if (((particleEmitter = (ParticleEmitter)this.emitters.get(b)).getImagePaths()).size != 0) {
/* 208 */         Array<Sprite> array = new Array();
/* 209 */         for (Array.ArrayIterator<String> arrayIterator = particleEmitter.getImagePaths().iterator(); arrayIterator.hasNext(); ) { String str = arrayIterator.next();
/*     */           
/*     */           int j;
/* 212 */           if ((j = (str = (new File(str.replace('\\', '/'))).getName()).lastIndexOf('.')) != -1) str = str.substring(0, j); 
/* 213 */           if (paramString != null) str = paramString + str; 
/*     */           Sprite sprite;
/* 215 */           if ((sprite = paramTextureAtlas.createSprite(str)) == null) throw new IllegalArgumentException("Atlas is missing region: " + str); 
/* 216 */           array.add(sprite); }
/*     */         
/* 218 */         particleEmitter.setSprites(array);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public void loadEmitterImages(FileHandle paramFileHandle) {
/* 223 */     this.ownsTexture = true;
/* 224 */     ObjectMap objectMap = new ObjectMap(this.emitters.size); byte b; int i;
/* 225 */     for (b = 0, i = this.emitters.size; b < i; b++) {
/*     */       ParticleEmitter particleEmitter;
/* 227 */       if (((particleEmitter = (ParticleEmitter)this.emitters.get(b)).getImagePaths()).size != 0) {
/* 228 */         Array<Sprite> array = new Array();
/* 229 */         for (Array.ArrayIterator<String> arrayIterator = particleEmitter.getImagePaths().iterator(); arrayIterator.hasNext(); ) { String str = arrayIterator.next();
/* 230 */           str = (new File(str.replace('\\', '/'))).getName();
/*     */           Sprite sprite;
/* 232 */           if ((sprite = (Sprite)objectMap.get(str)) == null) {
/* 233 */             sprite = new Sprite(loadTexture(paramFileHandle.child(str)));
/* 234 */             objectMap.put(str, sprite);
/*     */           } 
/* 236 */           array.add(sprite); }
/*     */         
/* 238 */         particleEmitter.setSprites(array);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   protected ParticleEmitter newEmitter(BufferedReader paramBufferedReader) {
/* 243 */     return new ParticleEmitter(paramBufferedReader);
/*     */   }
/*     */   
/*     */   protected ParticleEmitter newEmitter(ParticleEmitter paramParticleEmitter) {
/* 247 */     return new ParticleEmitter(paramParticleEmitter);
/*     */   }
/*     */   
/*     */   protected Texture loadTexture(FileHandle paramFileHandle) {
/* 251 */     return new Texture(paramFileHandle, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 256 */     if (!this.ownsTexture)
/* 257 */       return;  byte b; int i; for (b = 0, i = this.emitters.size; b < i; b++) {
/*     */       ParticleEmitter particleEmitter;
/* 259 */       for (Array.ArrayIterator<Sprite> arrayIterator = (particleEmitter = (ParticleEmitter)this.emitters.get(b)).getSprites().iterator(); arrayIterator.hasNext();) {
/* 260 */         (sprite = arrayIterator.next()).getTexture().dispose();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public BoundingBox getBoundingBox() {
/* 267 */     if (this.bounds == null) this.bounds = new BoundingBox();
/*     */     
/*     */     BoundingBox boundingBox;
/* 270 */     (boundingBox = this.bounds).inf();
/* 271 */     for (Array.ArrayIterator<ParticleEmitter> arrayIterator = this.emitters.iterator(); arrayIterator.hasNext(); ) { ParticleEmitter particleEmitter = arrayIterator.next();
/* 272 */       boundingBox.ext(particleEmitter.getBoundingBox()); }
/* 273 */      return boundingBox;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void scaleEffect(float paramFloat) {
/* 279 */     scaleEffect(paramFloat, paramFloat, paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void scaleEffect(float paramFloat1, float paramFloat2) {
/* 285 */     scaleEffect(paramFloat1, paramFloat1, paramFloat2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void scaleEffect(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 291 */     this.xSizeScale *= paramFloat1;
/* 292 */     this.ySizeScale *= paramFloat2;
/* 293 */     this.motionScale *= paramFloat3;
/* 294 */     for (Array.ArrayIterator<ParticleEmitter> arrayIterator = this.emitters.iterator(); arrayIterator.hasNext(); ) {
/* 295 */       ParticleEmitter particleEmitter; (particleEmitter = arrayIterator.next()).scaleSize(paramFloat1, paramFloat2);
/* 296 */       particleEmitter.scaleMotion(paramFloat3);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmittersCleanUpBlendFunction(boolean paramBoolean) {
/*     */     byte b;
/*     */     int i;
/* 307 */     for (b = 0, i = this.emitters.size; b < i; b++)
/* 308 */       ((ParticleEmitter)this.emitters.get(b)).setCleansUpBlendFunction(paramBoolean); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\ParticleEffect.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */