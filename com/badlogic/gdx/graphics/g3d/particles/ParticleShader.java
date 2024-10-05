/*     */ package com.badlogic.gdx.graphics.g3d.particles;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Camera;
/*     */ import com.badlogic.gdx.graphics.g3d.Attribute;
/*     */ import com.badlogic.gdx.graphics.g3d.Attributes;
/*     */ import com.badlogic.gdx.graphics.g3d.Material;
/*     */ import com.badlogic.gdx.graphics.g3d.Renderable;
/*     */ import com.badlogic.gdx.graphics.g3d.Shader;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.DepthTestAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.IntAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.shaders.BaseShader;
/*     */ import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader;
/*     */ import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
/*     */ import com.badlogic.gdx.graphics.glutils.ShaderProgram;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import java.util.Iterator;
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
/*     */ public class ParticleShader
/*     */   extends BaseShader
/*     */ {
/*     */   public enum ParticleType
/*     */   {
/*  45 */     Billboard, Point;
/*     */   }
/*     */   
/*     */   public enum AlignMode {
/*  49 */     Screen, ViewPoint;
/*     */   }
/*     */   
/*     */   public static class Config
/*     */   {
/*  54 */     public String vertexShader = null;
/*     */     
/*  56 */     public String fragmentShader = null;
/*     */     
/*     */     public boolean ignoreUnimplemented = true;
/*  59 */     public int defaultCullFace = -1;
/*     */     
/*  61 */     public int defaultDepthFunc = -1;
/*  62 */     public ParticleShader.AlignMode align = ParticleShader.AlignMode.Screen;
/*  63 */     public ParticleShader.ParticleType type = ParticleShader.ParticleType.Billboard;
/*     */ 
/*     */     
/*     */     public Config() {}
/*     */     
/*     */     public Config(ParticleShader.AlignMode param1AlignMode, ParticleShader.ParticleType param1ParticleType) {
/*  69 */       this.align = param1AlignMode;
/*  70 */       this.type = param1ParticleType;
/*     */     }
/*     */     
/*     */     public Config(ParticleShader.AlignMode param1AlignMode) {
/*  74 */       this.align = param1AlignMode;
/*     */     }
/*     */     
/*     */     public Config(ParticleShader.ParticleType param1ParticleType) {
/*  78 */       this.type = param1ParticleType;
/*     */     }
/*     */     
/*     */     public Config(String param1String1, String param1String2) {
/*  82 */       this.vertexShader = param1String1;
/*  83 */       this.fragmentShader = param1String2;
/*     */     }
/*     */   }
/*     */   
/*  87 */   private static String defaultVertexShader = null;
/*     */   
/*     */   public static String getDefaultVertexShader() {
/*  90 */     if (defaultVertexShader == null)
/*  91 */       defaultVertexShader = Gdx.files.classpath("com/badlogic/gdx/graphics/g3d/particles/particles.vertex.glsl").readString(); 
/*  92 */     return defaultVertexShader;
/*     */   }
/*     */   
/*  95 */   private static String defaultFragmentShader = null;
/*     */   
/*     */   public static String getDefaultFragmentShader() {
/*  98 */     if (defaultFragmentShader == null)
/*  99 */       defaultFragmentShader = Gdx.files.classpath("com/badlogic/gdx/graphics/g3d/particles/particles.fragment.glsl").readString(); 
/* 100 */     return defaultFragmentShader;
/*     */   }
/*     */   
/* 103 */   protected static long implementedFlags = BlendingAttribute.Type | TextureAttribute.Diffuse; private Renderable renderable; private long materialMask;
/*     */   private long vertexMask;
/* 105 */   static final Vector3 TMP_VECTOR3 = new Vector3();
/*     */   protected final Config config;
/*     */   
/* 108 */   public static class Inputs { public static final BaseShader.Uniform cameraRight = new BaseShader.Uniform("u_cameraRight");
/* 109 */     public static final BaseShader.Uniform cameraInvDirection = new BaseShader.Uniform("u_cameraInvDirection");
/* 110 */     public static final BaseShader.Uniform screenWidth = new BaseShader.Uniform("u_screenWidth");
/* 111 */     public static final BaseShader.Uniform regionSize = new BaseShader.Uniform("u_regionSize"); }
/*     */ 
/*     */   
/*     */   public static class Setters {
/* 115 */     public static final BaseShader.Setter cameraRight = new BaseShader.Setter()
/*     */       {
/*     */         public boolean isGlobal(BaseShader param2BaseShader, int param2Int) {
/* 118 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 123 */           param2BaseShader.set(param2Int, ParticleShader.TMP_VECTOR3.set(param2BaseShader.camera.direction).crs(param2BaseShader.camera.up).nor());
/*     */         }
/*     */       };
/*     */     
/* 127 */     public static final BaseShader.Setter cameraUp = new BaseShader.Setter()
/*     */       {
/*     */         public boolean isGlobal(BaseShader param2BaseShader, int param2Int) {
/* 130 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 135 */           param2BaseShader.set(param2Int, ParticleShader.TMP_VECTOR3.set(param2BaseShader.camera.up).nor());
/*     */         }
/*     */       };
/*     */     
/* 139 */     public static final BaseShader.Setter cameraInvDirection = new BaseShader.Setter()
/*     */       {
/*     */         public boolean isGlobal(BaseShader param2BaseShader, int param2Int) {
/* 142 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 147 */           param2BaseShader.set(param2Int, ParticleShader.TMP_VECTOR3
/* 148 */               .set(-param2BaseShader.camera.direction.x, -param2BaseShader.camera.direction.y, -param2BaseShader.camera.direction.z).nor());
/*     */         }
/*     */       };
/* 151 */     public static final BaseShader.Setter cameraPosition = new BaseShader.Setter()
/*     */       {
/*     */         public boolean isGlobal(BaseShader param2BaseShader, int param2Int) {
/* 154 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 159 */           param2BaseShader.set(param2Int, param2BaseShader.camera.position);
/*     */         }
/*     */       };
/* 162 */     public static final BaseShader.Setter screenWidth = new BaseShader.Setter()
/*     */       {
/*     */         public boolean isGlobal(BaseShader param2BaseShader, int param2Int) {
/* 165 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 170 */           param2BaseShader.set(param2Int, Gdx.graphics.getWidth());
/*     */         }
/*     */       };
/* 173 */     public static final BaseShader.Setter worldViewTrans = new BaseShader.Setter() {
/* 174 */         final Matrix4 temp = new Matrix4();
/*     */ 
/*     */         
/*     */         public boolean isGlobal(BaseShader param2BaseShader, int param2Int) {
/* 178 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 183 */           param2BaseShader.set(param2Int, this.temp.set(param2BaseShader.camera.view).mul(param2Renderable.worldTransform));
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 194 */   private static final long optionalAttributes = IntAttribute.CullFace | DepthTestAttribute.Type; Material currentMaterial;
/*     */   
/*     */   public ParticleShader(Renderable paramRenderable) {
/* 197 */     this(paramRenderable, new Config());
/*     */   }
/*     */   
/*     */   public ParticleShader(Renderable paramRenderable, Config paramConfig) {
/* 201 */     this(paramRenderable, paramConfig, createPrefix(paramRenderable, paramConfig));
/*     */   }
/*     */   
/*     */   public ParticleShader(Renderable paramRenderable, Config paramConfig, String paramString) {
/* 205 */     this(paramRenderable, paramConfig, paramString, (paramConfig.vertexShader != null) ? paramConfig.vertexShader : getDefaultVertexShader(), 
/* 206 */         (paramConfig.fragmentShader != null) ? paramConfig.fragmentShader : getDefaultFragmentShader());
/*     */   }
/*     */ 
/*     */   
/*     */   public ParticleShader(Renderable paramRenderable, Config paramConfig, String paramString1, String paramString2, String paramString3) {
/* 211 */     this(paramRenderable, paramConfig, new ShaderProgram(paramString1 + paramString2, paramString1 + paramString3));
/*     */   }
/*     */   
/*     */   public ParticleShader(Renderable paramRenderable, Config paramConfig, ShaderProgram paramShaderProgram) {
/* 215 */     this.config = paramConfig;
/* 216 */     this.program = paramShaderProgram;
/* 217 */     this.renderable = paramRenderable;
/* 218 */     this.materialMask = paramRenderable.material.getMask() | optionalAttributes;
/* 219 */     this.vertexMask = paramRenderable.meshPart.mesh.getVertexAttributes().getMask();
/*     */     
/* 221 */     if (!paramConfig.ignoreUnimplemented && (implementedFlags & this.materialMask) != this.materialMask) {
/* 222 */       throw new GdxRuntimeException("Some attributes not implemented yet (" + this.materialMask + ")");
/*     */     }
/*     */     
/* 225 */     register(DefaultShader.Inputs.viewTrans, DefaultShader.Setters.viewTrans);
/* 226 */     register(DefaultShader.Inputs.projViewTrans, DefaultShader.Setters.projViewTrans);
/* 227 */     register(DefaultShader.Inputs.projTrans, DefaultShader.Setters.projTrans);
/* 228 */     register(Inputs.screenWidth, Setters.screenWidth);
/* 229 */     register(DefaultShader.Inputs.cameraUp, Setters.cameraUp);
/* 230 */     register(Inputs.cameraRight, Setters.cameraRight);
/* 231 */     register(Inputs.cameraInvDirection, Setters.cameraInvDirection);
/* 232 */     register(DefaultShader.Inputs.cameraPosition, Setters.cameraPosition);
/*     */ 
/*     */     
/* 235 */     register(DefaultShader.Inputs.diffuseTexture, DefaultShader.Setters.diffuseTexture);
/*     */   }
/*     */ 
/*     */   
/*     */   public void init() {
/* 240 */     ShaderProgram shaderProgram = this.program;
/* 241 */     this.program = null;
/* 242 */     init(shaderProgram, this.renderable);
/* 243 */     this.renderable = null;
/*     */   }
/*     */   
/*     */   public static String createPrefix(Renderable paramRenderable, Config paramConfig) {
/* 247 */     String str = "";
/* 248 */     if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
/* 249 */       str = str + "#version 120\n";
/*     */     } else {
/* 251 */       str = str + "#version 100\n";
/* 252 */     }  if (paramConfig.type == ParticleType.Billboard) {
/* 253 */       str = str + "#define billboard\n";
/* 254 */       if (paramConfig.align == AlignMode.Screen)
/* 255 */       { str = str + "#define screenFacing\n"; }
/* 256 */       else if (paramConfig.align == AlignMode.ViewPoint) { str = str + "#define viewPointFacing\n"; }
/*     */     
/*     */     } 
/*     */     
/* 260 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canRender(Renderable paramRenderable) {
/* 265 */     if (this.materialMask == (paramRenderable.material.getMask() | optionalAttributes) && this.vertexMask == paramRenderable.meshPart.mesh
/* 266 */       .getVertexAttributes().getMask()) return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public int compareTo(Shader paramShader) {
/* 271 */     if (paramShader == null) return -1; 
/* 272 */     if (paramShader == this) return 0; 
/* 273 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 278 */     return (paramObject instanceof ParticleShader && equals((ParticleShader)paramObject));
/*     */   }
/*     */   
/*     */   public boolean equals(ParticleShader paramParticleShader) {
/* 282 */     return (paramParticleShader == this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void begin(Camera paramCamera, RenderContext paramRenderContext) {
/* 287 */     super.begin(paramCamera, paramRenderContext);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Renderable paramRenderable) {
/* 292 */     if (!paramRenderable.material.has(BlendingAttribute.Type))
/* 293 */       this.context.setBlending(false, 770, 771); 
/* 294 */     bindMaterial(paramRenderable);
/* 295 */     super.render(paramRenderable);
/*     */   }
/*     */ 
/*     */   
/*     */   public void end() {
/* 300 */     this.currentMaterial = null;
/* 301 */     super.end();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void bindMaterial(Renderable paramRenderable) {
/* 307 */     if (this.currentMaterial == paramRenderable.material)
/*     */       return; 
/* 309 */     boolean bool = (this.config.defaultCullFace == -1) ? true : this.config.defaultCullFace;
/* 310 */     int i = (this.config.defaultDepthFunc == -1) ? 515 : this.config.defaultDepthFunc;
/* 311 */     float f1 = 0.0F;
/* 312 */     float f2 = 1.0F;
/* 313 */     boolean bool1 = true;
/*     */     
/* 315 */     this.currentMaterial = paramRenderable.material;
/* 316 */     for (Iterator<Attribute> iterator = this.currentMaterial.iterator(); iterator.hasNext(); ) {
/*     */       Attribute attribute; long l;
/* 318 */       if (BlendingAttribute.is(l = (attribute = iterator.next()).type)) {
/* 319 */         this.context.setBlending(true, ((BlendingAttribute)attribute).sourceFunction, ((BlendingAttribute)attribute).destFunction); continue;
/* 320 */       }  if ((l & DepthTestAttribute.Type) == DepthTestAttribute.Type) {
/*     */         DepthTestAttribute depthTestAttribute;
/* 322 */         i = (depthTestAttribute = (DepthTestAttribute)attribute).depthFunc;
/* 323 */         f1 = depthTestAttribute.depthRangeNear;
/* 324 */         f2 = depthTestAttribute.depthRangeFar;
/* 325 */         bool1 = depthTestAttribute.depthMask; continue;
/* 326 */       }  if (!this.config.ignoreUnimplemented) throw new GdxRuntimeException("Unknown material attribute: " + attribute.toString());
/*     */     
/*     */     } 
/* 329 */     this.context.setCullFace(bool);
/* 330 */     this.context.setDepthTest(i, f1, f2);
/* 331 */     this.context.setDepthMask(bool1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 336 */     this.program.dispose();
/* 337 */     super.dispose();
/*     */   }
/*     */   
/*     */   public int getDefaultCullFace() {
/* 341 */     return (this.config.defaultCullFace == -1) ? 1029 : this.config.defaultCullFace;
/*     */   }
/*     */   
/*     */   public void setDefaultCullFace(int paramInt) {
/* 345 */     this.config.defaultCullFace = paramInt;
/*     */   }
/*     */   
/*     */   public int getDefaultDepthFunc() {
/* 349 */     return (this.config.defaultDepthFunc == -1) ? 515 : this.config.defaultDepthFunc;
/*     */   }
/*     */   
/*     */   public void setDefaultDepthFunc(int paramInt) {
/* 353 */     this.config.defaultDepthFunc = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\ParticleShader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */