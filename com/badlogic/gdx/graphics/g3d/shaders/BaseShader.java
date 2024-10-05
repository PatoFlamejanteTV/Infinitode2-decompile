/*     */ package com.badlogic.gdx.graphics.g3d.shaders;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Camera;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.GLTexture;
/*     */ import com.badlogic.gdx.graphics.Mesh;
/*     */ import com.badlogic.gdx.graphics.VertexAttribute;
/*     */ import com.badlogic.gdx.graphics.VertexAttributes;
/*     */ import com.badlogic.gdx.graphics.g3d.Attributes;
/*     */ import com.badlogic.gdx.graphics.g3d.Renderable;
/*     */ import com.badlogic.gdx.graphics.g3d.Shader;
/*     */ import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
/*     */ import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
/*     */ import com.badlogic.gdx.graphics.glutils.ShaderProgram;
/*     */ import com.badlogic.gdx.math.Matrix3;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.IntIntMap;
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
/*     */ public abstract class BaseShader
/*     */   implements Shader
/*     */ {
/*     */   public static abstract class GlobalSetter
/*     */     implements Setter
/*     */   {
/*     */     public boolean isGlobal(BaseShader param1BaseShader, int param1Int) {
/*  59 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract class LocalSetter
/*     */     implements Setter {
/*     */     public boolean isGlobal(BaseShader param1BaseShader, int param1Int) {
/*  66 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Uniform implements Validator {
/*     */     public final String alias;
/*     */     public final long materialMask;
/*     */     public final long environmentMask;
/*     */     public final long overallMask;
/*     */     
/*     */     public Uniform(String param1String, long param1Long1, long param1Long2, long param1Long3) {
/*  77 */       this.alias = param1String;
/*  78 */       this.materialMask = param1Long1;
/*  79 */       this.environmentMask = param1Long2;
/*  80 */       this.overallMask = param1Long3;
/*     */     }
/*     */     
/*     */     public Uniform(String param1String, long param1Long1, long param1Long2) {
/*  84 */       this(param1String, param1Long1, param1Long2, 0L);
/*     */     }
/*     */     
/*     */     public Uniform(String param1String, long param1Long) {
/*  88 */       this(param1String, 0L, 0L, param1Long);
/*     */     }
/*     */     
/*     */     public Uniform(String param1String) {
/*  92 */       this(param1String, 0L, 0L);
/*     */     }
/*     */     
/*     */     public boolean validate(BaseShader param1BaseShader, int param1Int, Renderable param1Renderable) {
/*  96 */       long l1 = (param1Renderable != null && param1Renderable.material != null) ? param1Renderable.material.getMask() : 0L;
/*  97 */       long l2 = (param1Renderable != null && param1Renderable.environment != null) ? param1Renderable.environment.getMask() : 0L;
/*  98 */       return ((l1 & this.materialMask) == this.materialMask && (l2 & this.environmentMask) == this.environmentMask && ((l1 | l2) & this.overallMask) == this.overallMask);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/* 103 */   private final Array<String> uniforms = new Array();
/* 104 */   private final Array<Validator> validators = new Array();
/* 105 */   private final Array<Setter> setters = new Array();
/*     */   private int[] locations;
/* 107 */   private final IntArray globalUniforms = new IntArray();
/* 108 */   private final IntArray localUniforms = new IntArray();
/* 109 */   private final IntIntMap attributes = new IntIntMap();
/* 110 */   private final IntIntMap instancedAttributes = new IntIntMap();
/*     */   
/*     */   public ShaderProgram program;
/*     */   
/*     */   public RenderContext context;
/*     */   
/*     */   public Camera camera;
/*     */   private Mesh currentMesh;
/*     */   
/*     */   public int register(String paramString, Validator paramValidator, Setter paramSetter) {
/* 120 */     if (this.locations != null) throw new GdxRuntimeException("Cannot register an uniform after initialization"); 
/*     */     int i;
/* 122 */     if ((i = getUniformID(paramString)) >= 0) {
/* 123 */       this.validators.set(i, paramValidator);
/* 124 */       this.setters.set(i, paramSetter);
/* 125 */       return i;
/*     */     } 
/* 127 */     this.uniforms.add(paramString);
/* 128 */     this.validators.add(paramValidator);
/* 129 */     this.setters.add(paramSetter);
/* 130 */     return this.uniforms.size - 1;
/*     */   }
/*     */   
/*     */   public int register(String paramString, Validator paramValidator) {
/* 134 */     return register(paramString, paramValidator, null);
/*     */   }
/*     */   
/*     */   public int register(String paramString, Setter paramSetter) {
/* 138 */     return register(paramString, null, paramSetter);
/*     */   }
/*     */   
/*     */   public int register(String paramString) {
/* 142 */     return register(paramString, null, null);
/*     */   }
/*     */   
/*     */   public int register(Uniform paramUniform, Setter paramSetter) {
/* 146 */     return register(paramUniform.alias, paramUniform, paramSetter);
/*     */   }
/*     */   
/*     */   public int register(Uniform paramUniform) {
/* 150 */     return register(paramUniform, (Setter)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getUniformID(String paramString) {
/* 155 */     int i = this.uniforms.size;
/* 156 */     for (byte b = 0; b < i; b++) {
/* 157 */       if (((String)this.uniforms.get(b)).equals(paramString)) return b; 
/* 158 */     }  return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUniformAlias(int paramInt) {
/* 163 */     return (String)this.uniforms.get(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void init(ShaderProgram paramShaderProgram, Renderable paramRenderable) {
/* 168 */     if (this.locations != null) throw new GdxRuntimeException("Already initialized"); 
/* 169 */     if (!paramShaderProgram.isCompiled()) throw new GdxRuntimeException(paramShaderProgram.getLog()); 
/* 170 */     this.program = paramShaderProgram;
/*     */     
/* 172 */     int i = this.uniforms.size;
/* 173 */     this.locations = new int[i];
/* 174 */     for (byte b = 0; b < i; b++) {
/* 175 */       String str = (String)this.uniforms.get(b);
/* 176 */       Validator validator = (Validator)this.validators.get(b);
/* 177 */       Setter setter = (Setter)this.setters.get(b);
/* 178 */       if (validator != null && !validator.validate(this, b, paramRenderable)) {
/* 179 */         this.locations[b] = -1;
/*     */       } else {
/* 181 */         this.locations[b] = paramShaderProgram.fetchUniformLocation(str, false);
/* 182 */         if (this.locations[b] >= 0 && setter != null)
/* 183 */           if (setter.isGlobal(this, b)) {
/* 184 */             this.globalUniforms.add(b);
/*     */           } else {
/* 186 */             this.localUniforms.add(b);
/*     */           }  
/*     */       } 
/* 189 */       if (this.locations[b] < 0) {
/* 190 */         this.validators.set(b, null);
/* 191 */         this.setters.set(b, null);
/*     */       } 
/*     */     } 
/* 194 */     if (paramRenderable != null) {
/*     */       VertexAttributes vertexAttributes1;
/* 196 */       int j = (vertexAttributes1 = paramRenderable.meshPart.mesh.getVertexAttributes()).size();
/* 197 */       for (byte b1 = 0; b1 < j; b1++) {
/* 198 */         VertexAttribute vertexAttribute = vertexAttributes1.get(b1);
/*     */         
/* 200 */         if ((i = paramShaderProgram.getAttributeLocation(vertexAttribute.alias)) >= 0) this.attributes.put(vertexAttribute.getKey(), i); 
/*     */       } 
/*     */       VertexAttributes vertexAttributes2;
/* 203 */       if ((vertexAttributes2 = paramRenderable.meshPart.mesh.getInstancedAttributes()) != null) {
/* 204 */         int k = vertexAttributes2.size();
/* 205 */         for (i = 0; i < k; i++) {
/* 206 */           VertexAttribute vertexAttribute = vertexAttributes2.get(i);
/*     */           int m;
/* 208 */           if ((m = paramShaderProgram.getAttributeLocation(vertexAttribute.alias)) >= 0) this.instancedAttributes.put(vertexAttribute.getKey(), m);
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void begin(Camera paramCamera, RenderContext paramRenderContext) {
/* 216 */     this.camera = paramCamera;
/* 217 */     this.context = paramRenderContext;
/* 218 */     this.program.bind();
/* 219 */     this.currentMesh = null;
/* 220 */     for (byte b = 0; b < this.globalUniforms.size; b++) {
/* 221 */       int i; if (this.setters.get(i = this.globalUniforms.get(b)) != null) ((Setter)this.setters.get(i)).set(this, i, null, null); 
/*     */     } 
/*     */   }
/* 224 */   private final IntArray tempArray = new IntArray();
/* 225 */   private final IntArray tempArray2 = new IntArray();
/*     */   
/*     */   private final int[] getAttributeLocations(VertexAttributes paramVertexAttributes) {
/* 228 */     this.tempArray.clear();
/* 229 */     int i = paramVertexAttributes.size();
/* 230 */     for (byte b = 0; b < i; b++) {
/* 231 */       this.tempArray.add(this.attributes.get(paramVertexAttributes.get(b).getKey(), -1));
/*     */     }
/* 233 */     this.tempArray.shrink();
/* 234 */     return this.tempArray.items;
/*     */   }
/*     */ 
/*     */   
/*     */   private final int[] getInstancedAttributeLocations(VertexAttributes paramVertexAttributes) {
/* 239 */     if (paramVertexAttributes == null) return null; 
/* 240 */     this.tempArray2.clear();
/* 241 */     int i = paramVertexAttributes.size();
/* 242 */     for (byte b = 0; b < i; b++) {
/* 243 */       this.tempArray2.add(this.instancedAttributes.get(paramVertexAttributes.get(b).getKey(), -1));
/*     */     }
/* 245 */     this.tempArray2.shrink();
/* 246 */     return this.tempArray2.items;
/*     */   }
/*     */   
/* 249 */   private Attributes combinedAttributes = new Attributes();
/*     */ 
/*     */   
/*     */   public void render(Renderable paramRenderable) {
/* 253 */     if (paramRenderable.worldTransform.det3x3() == 0.0F)
/* 254 */       return;  this.combinedAttributes.clear();
/* 255 */     if (paramRenderable.environment != null) this.combinedAttributes.set((Iterable)paramRenderable.environment); 
/* 256 */     if (paramRenderable.material != null) this.combinedAttributes.set((Iterable)paramRenderable.material); 
/* 257 */     render(paramRenderable, this.combinedAttributes);
/*     */   }
/*     */   
/*     */   public void render(Renderable paramRenderable, Attributes paramAttributes) {
/* 261 */     for (byte b = 0; b < this.localUniforms.size; b++) {
/* 262 */       int i; if (this.setters.get(i = this.localUniforms.get(b)) != null) ((Setter)this.setters.get(i)).set(this, i, paramRenderable, paramAttributes); 
/* 263 */     }  if (this.currentMesh != paramRenderable.meshPart.mesh) {
/* 264 */       if (this.currentMesh != null) this.currentMesh.unbind(this.program, this.tempArray.items, this.tempArray2.items); 
/* 265 */       this.currentMesh = paramRenderable.meshPart.mesh;
/* 266 */       this.currentMesh.bind(this.program, getAttributeLocations(paramRenderable.meshPart.mesh.getVertexAttributes()), 
/* 267 */           getInstancedAttributeLocations(paramRenderable.meshPart.mesh.getInstancedAttributes()));
/*     */     } 
/* 269 */     paramRenderable.meshPart.render(this.program, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void end() {
/* 274 */     if (this.currentMesh != null) {
/* 275 */       this.currentMesh.unbind(this.program, this.tempArray.items, this.tempArray2.items);
/* 276 */       this.currentMesh = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 282 */     this.program = null;
/* 283 */     this.uniforms.clear();
/* 284 */     this.validators.clear();
/* 285 */     this.setters.clear();
/* 286 */     this.localUniforms.clear();
/* 287 */     this.globalUniforms.clear();
/* 288 */     this.locations = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean has(int paramInt) {
/* 293 */     return (paramInt >= 0 && paramInt < this.locations.length && this.locations[paramInt] >= 0);
/*     */   }
/*     */   
/*     */   public final int loc(int paramInt) {
/* 297 */     return (paramInt >= 0 && paramInt < this.locations.length) ? this.locations[paramInt] : -1;
/*     */   }
/*     */   
/*     */   public final boolean set(int paramInt, Matrix4 paramMatrix4) {
/* 301 */     if (this.locations[paramInt] < 0) return false; 
/* 302 */     this.program.setUniformMatrix(this.locations[paramInt], paramMatrix4);
/* 303 */     return true;
/*     */   }
/*     */   
/*     */   public final boolean set(int paramInt, Matrix3 paramMatrix3) {
/* 307 */     if (this.locations[paramInt] < 0) return false; 
/* 308 */     this.program.setUniformMatrix(this.locations[paramInt], paramMatrix3);
/* 309 */     return true;
/*     */   }
/*     */   
/*     */   public final boolean set(int paramInt, Vector3 paramVector3) {
/* 313 */     if (this.locations[paramInt] < 0) return false; 
/* 314 */     this.program.setUniformf(this.locations[paramInt], paramVector3);
/* 315 */     return true;
/*     */   }
/*     */   
/*     */   public final boolean set(int paramInt, Vector2 paramVector2) {
/* 319 */     if (this.locations[paramInt] < 0) return false; 
/* 320 */     this.program.setUniformf(this.locations[paramInt], paramVector2);
/* 321 */     return true;
/*     */   }
/*     */   
/*     */   public final boolean set(int paramInt, Color paramColor) {
/* 325 */     if (this.locations[paramInt] < 0) return false; 
/* 326 */     this.program.setUniformf(this.locations[paramInt], paramColor);
/* 327 */     return true;
/*     */   }
/*     */   
/*     */   public final boolean set(int paramInt, float paramFloat) {
/* 331 */     if (this.locations[paramInt] < 0) return false; 
/* 332 */     this.program.setUniformf(this.locations[paramInt], paramFloat);
/* 333 */     return true;
/*     */   }
/*     */   
/*     */   public final boolean set(int paramInt, float paramFloat1, float paramFloat2) {
/* 337 */     if (this.locations[paramInt] < 0) return false; 
/* 338 */     this.program.setUniformf(this.locations[paramInt], paramFloat1, paramFloat2);
/* 339 */     return true;
/*     */   }
/*     */   
/*     */   public final boolean set(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 343 */     if (this.locations[paramInt] < 0) return false; 
/* 344 */     this.program.setUniformf(this.locations[paramInt], paramFloat1, paramFloat2, paramFloat3);
/* 345 */     return true;
/*     */   }
/*     */   
/*     */   public final boolean set(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 349 */     if (this.locations[paramInt] < 0) return false; 
/* 350 */     this.program.setUniformf(this.locations[paramInt], paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 351 */     return true;
/*     */   }
/*     */   
/*     */   public final boolean set(int paramInt1, int paramInt2) {
/* 355 */     if (this.locations[paramInt1] < 0) return false; 
/* 356 */     this.program.setUniformi(this.locations[paramInt1], paramInt2);
/* 357 */     return true;
/*     */   }
/*     */   
/*     */   public final boolean set(int paramInt1, int paramInt2, int paramInt3) {
/* 361 */     if (this.locations[paramInt1] < 0) return false; 
/* 362 */     this.program.setUniformi(this.locations[paramInt1], paramInt2, paramInt3);
/* 363 */     return true;
/*     */   }
/*     */   
/*     */   public final boolean set(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 367 */     if (this.locations[paramInt1] < 0) return false; 
/* 368 */     this.program.setUniformi(this.locations[paramInt1], paramInt2, paramInt3, paramInt4);
/* 369 */     return true;
/*     */   }
/*     */   
/*     */   public final boolean set(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 373 */     if (this.locations[paramInt1] < 0) return false; 
/* 374 */     this.program.setUniformi(this.locations[paramInt1], paramInt2, paramInt3, paramInt4, paramInt5);
/* 375 */     return true;
/*     */   }
/*     */   
/*     */   public final boolean set(int paramInt, TextureDescriptor paramTextureDescriptor) {
/* 379 */     if (this.locations[paramInt] < 0) return false; 
/* 380 */     this.program.setUniformi(this.locations[paramInt], this.context.textureBinder.bind(paramTextureDescriptor));
/* 381 */     return true;
/*     */   }
/*     */   
/*     */   public final boolean set(int paramInt, GLTexture paramGLTexture) {
/* 385 */     if (this.locations[paramInt] < 0) return false; 
/* 386 */     this.program.setUniformi(this.locations[paramInt], this.context.textureBinder.bind(paramGLTexture));
/* 387 */     return true;
/*     */   }
/*     */   
/*     */   public static interface Setter {
/*     */     boolean isGlobal(BaseShader param1BaseShader, int param1Int);
/*     */     
/*     */     void set(BaseShader param1BaseShader, int param1Int, Renderable param1Renderable, Attributes param1Attributes);
/*     */   }
/*     */   
/*     */   public static interface Validator {
/*     */     boolean validate(BaseShader param1BaseShader, int param1Int, Renderable param1Renderable);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\shaders\BaseShader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */