/*     */ package com.badlogic.gdx.graphics.g3d.shaders;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Camera;
/*     */ import com.badlogic.gdx.graphics.VertexAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.Attribute;
/*     */ import com.badlogic.gdx.graphics.g3d.Attributes;
/*     */ import com.badlogic.gdx.graphics.g3d.Environment;
/*     */ import com.badlogic.gdx.graphics.g3d.Renderable;
/*     */ import com.badlogic.gdx.graphics.g3d.Shader;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.CubemapAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.DepthTestAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.DirectionalLightsAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.IntAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.PointLightsAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.SpotLightsAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.environment.AmbientCubemap;
/*     */ import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
/*     */ import com.badlogic.gdx.graphics.g3d.environment.PointLight;
/*     */ import com.badlogic.gdx.graphics.g3d.environment.SpotLight;
/*     */ import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
/*     */ import com.badlogic.gdx.graphics.glutils.ShaderProgram;
/*     */ import com.badlogic.gdx.math.Matrix3;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.Array;
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
/*     */ public class DefaultShader
/*     */   extends BaseShader
/*     */ {
/*     */   public static class Config
/*     */   {
/*  54 */     public String vertexShader = null;
/*     */     
/*  56 */     public String fragmentShader = null;
/*     */     
/*  58 */     public int numDirectionalLights = 2;
/*     */     
/*  60 */     public int numPointLights = 5;
/*     */     
/*  62 */     public int numSpotLights = 0;
/*     */     
/*  64 */     public int numBones = 12;
/*     */     
/*  66 */     public int numBoneWeights = 4;
/*     */     
/*     */     public boolean ignoreUnimplemented = true;
/*     */     
/*  70 */     public int defaultCullFace = -1;
/*     */     
/*  72 */     public int defaultDepthFunc = -1;
/*     */ 
/*     */     
/*     */     public Config() {}
/*     */     
/*     */     public Config(String param1String1, String param1String2) {
/*  78 */       this.vertexShader = param1String1;
/*  79 */       this.fragmentShader = param1String2;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Inputs {
/*  84 */     public static final BaseShader.Uniform projTrans = new BaseShader.Uniform("u_projTrans");
/*  85 */     public static final BaseShader.Uniform viewTrans = new BaseShader.Uniform("u_viewTrans");
/*  86 */     public static final BaseShader.Uniform projViewTrans = new BaseShader.Uniform("u_projViewTrans");
/*  87 */     public static final BaseShader.Uniform cameraPosition = new BaseShader.Uniform("u_cameraPosition");
/*  88 */     public static final BaseShader.Uniform cameraDirection = new BaseShader.Uniform("u_cameraDirection");
/*  89 */     public static final BaseShader.Uniform cameraUp = new BaseShader.Uniform("u_cameraUp");
/*  90 */     public static final BaseShader.Uniform cameraNearFar = new BaseShader.Uniform("u_cameraNearFar");
/*     */     
/*  92 */     public static final BaseShader.Uniform worldTrans = new BaseShader.Uniform("u_worldTrans");
/*  93 */     public static final BaseShader.Uniform viewWorldTrans = new BaseShader.Uniform("u_viewWorldTrans");
/*  94 */     public static final BaseShader.Uniform projViewWorldTrans = new BaseShader.Uniform("u_projViewWorldTrans");
/*  95 */     public static final BaseShader.Uniform normalMatrix = new BaseShader.Uniform("u_normalMatrix");
/*  96 */     public static final BaseShader.Uniform bones = new BaseShader.Uniform("u_bones");
/*     */     
/*  98 */     public static final BaseShader.Uniform shininess = new BaseShader.Uniform("u_shininess", FloatAttribute.Shininess);
/*  99 */     public static final BaseShader.Uniform opacity = new BaseShader.Uniform("u_opacity", BlendingAttribute.Type);
/* 100 */     public static final BaseShader.Uniform diffuseColor = new BaseShader.Uniform("u_diffuseColor", ColorAttribute.Diffuse);
/* 101 */     public static final BaseShader.Uniform diffuseTexture = new BaseShader.Uniform("u_diffuseTexture", TextureAttribute.Diffuse);
/* 102 */     public static final BaseShader.Uniform diffuseUVTransform = new BaseShader.Uniform("u_diffuseUVTransform", TextureAttribute.Diffuse);
/* 103 */     public static final BaseShader.Uniform specularColor = new BaseShader.Uniform("u_specularColor", ColorAttribute.Specular);
/* 104 */     public static final BaseShader.Uniform specularTexture = new BaseShader.Uniform("u_specularTexture", TextureAttribute.Specular);
/* 105 */     public static final BaseShader.Uniform specularUVTransform = new BaseShader.Uniform("u_specularUVTransform", TextureAttribute.Specular);
/* 106 */     public static final BaseShader.Uniform emissiveColor = new BaseShader.Uniform("u_emissiveColor", ColorAttribute.Emissive);
/* 107 */     public static final BaseShader.Uniform emissiveTexture = new BaseShader.Uniform("u_emissiveTexture", TextureAttribute.Emissive);
/* 108 */     public static final BaseShader.Uniform emissiveUVTransform = new BaseShader.Uniform("u_emissiveUVTransform", TextureAttribute.Emissive);
/* 109 */     public static final BaseShader.Uniform reflectionColor = new BaseShader.Uniform("u_reflectionColor", ColorAttribute.Reflection);
/* 110 */     public static final BaseShader.Uniform reflectionTexture = new BaseShader.Uniform("u_reflectionTexture", TextureAttribute.Reflection);
/* 111 */     public static final BaseShader.Uniform reflectionUVTransform = new BaseShader.Uniform("u_reflectionUVTransform", TextureAttribute.Reflection);
/* 112 */     public static final BaseShader.Uniform normalTexture = new BaseShader.Uniform("u_normalTexture", TextureAttribute.Normal);
/* 113 */     public static final BaseShader.Uniform normalUVTransform = new BaseShader.Uniform("u_normalUVTransform", TextureAttribute.Normal);
/* 114 */     public static final BaseShader.Uniform ambientTexture = new BaseShader.Uniform("u_ambientTexture", TextureAttribute.Ambient);
/* 115 */     public static final BaseShader.Uniform ambientUVTransform = new BaseShader.Uniform("u_ambientUVTransform", TextureAttribute.Ambient);
/* 116 */     public static final BaseShader.Uniform alphaTest = new BaseShader.Uniform("u_alphaTest");
/*     */     
/* 118 */     public static final BaseShader.Uniform ambientCube = new BaseShader.Uniform("u_ambientCubemap");
/* 119 */     public static final BaseShader.Uniform dirLights = new BaseShader.Uniform("u_dirLights");
/* 120 */     public static final BaseShader.Uniform pointLights = new BaseShader.Uniform("u_pointLights");
/* 121 */     public static final BaseShader.Uniform spotLights = new BaseShader.Uniform("u_spotLights");
/* 122 */     public static final BaseShader.Uniform environmentCubemap = new BaseShader.Uniform("u_environmentCubemap");
/*     */   }
/*     */   
/*     */   public static class Setters {
/* 126 */     public static final BaseShader.Setter projTrans = new BaseShader.GlobalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 129 */           param2BaseShader.set(param2Int, param2BaseShader.camera.projection);
/*     */         }
/*     */       };
/* 132 */     public static final BaseShader.Setter viewTrans = new BaseShader.GlobalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 135 */           param2BaseShader.set(param2Int, param2BaseShader.camera.view);
/*     */         }
/*     */       };
/* 138 */     public static final BaseShader.Setter projViewTrans = new BaseShader.GlobalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 141 */           param2BaseShader.set(param2Int, param2BaseShader.camera.combined);
/*     */         }
/*     */       };
/* 144 */     public static final BaseShader.Setter cameraPosition = new BaseShader.GlobalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 147 */           param2BaseShader.set(param2Int, param2BaseShader.camera.position.x, param2BaseShader.camera.position.y, param2BaseShader.camera.position.z, 1.1881F / param2BaseShader.camera.far * param2BaseShader.camera.far);
/*     */         }
/*     */       };
/*     */     
/* 151 */     public static final BaseShader.Setter cameraDirection = new BaseShader.GlobalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 154 */           param2BaseShader.set(param2Int, param2BaseShader.camera.direction);
/*     */         }
/*     */       };
/* 157 */     public static final BaseShader.Setter cameraUp = new BaseShader.GlobalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 160 */           param2BaseShader.set(param2Int, param2BaseShader.camera.up);
/*     */         }
/*     */       };
/* 163 */     public static final BaseShader.Setter cameraNearFar = new BaseShader.GlobalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 166 */           param2BaseShader.set(param2Int, param2BaseShader.camera.near, param2BaseShader.camera.far);
/*     */         }
/*     */       };
/* 169 */     public static final BaseShader.Setter worldTrans = new BaseShader.LocalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 172 */           param2BaseShader.set(param2Int, param2Renderable.worldTransform);
/*     */         }
/*     */       };
/* 175 */     public static final BaseShader.Setter viewWorldTrans = new BaseShader.LocalSetter() {
/* 176 */         final Matrix4 temp = new Matrix4();
/*     */ 
/*     */         
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 180 */           param2BaseShader.set(param2Int, this.temp.set(param2BaseShader.camera.view).mul(param2Renderable.worldTransform));
/*     */         }
/*     */       };
/* 183 */     public static final BaseShader.Setter projViewWorldTrans = new BaseShader.LocalSetter() {
/* 184 */         final Matrix4 temp = new Matrix4();
/*     */ 
/*     */         
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 188 */           param2BaseShader.set(param2Int, this.temp.set(param2BaseShader.camera.combined).mul(param2Renderable.worldTransform));
/*     */         }
/*     */       };
/* 191 */     public static final BaseShader.Setter normalMatrix = new BaseShader.LocalSetter() {
/* 192 */         private final Matrix3 tmpM = new Matrix3();
/*     */ 
/*     */         
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 196 */           param2BaseShader.set(param2Int, this.tmpM.set(param2Renderable.worldTransform).inv().transpose());
/*     */         }
/*     */       };
/*     */     
/*     */     public static class Bones extends BaseShader.LocalSetter {
/* 201 */       private static final Matrix4 idtMatrix = new Matrix4();
/*     */       public final float[] bones;
/*     */       
/*     */       public Bones(int param2Int) {
/* 205 */         this.bones = new float[param2Int << 4];
/*     */       }
/*     */ 
/*     */       
/*     */       public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 210 */         for (byte b = 0; b < this.bones.length; b += 16) {
/* 211 */           int i = b / 16;
/* 212 */           if (param2Renderable.bones == null || i >= param2Renderable.bones.length || param2Renderable.bones[i] == null) {
/* 213 */             System.arraycopy(idtMatrix.val, 0, this.bones, b, 16);
/*     */           } else {
/* 215 */             System.arraycopy((param2Renderable.bones[i]).val, 0, this.bones, b, 16);
/*     */           } 
/* 217 */         }  param2BaseShader.program.setUniformMatrix4fv(param2BaseShader.loc(param2Int), this.bones, 0, this.bones.length);
/*     */       }
/*     */     }
/*     */     
/* 221 */     public static final BaseShader.Setter shininess = new BaseShader.LocalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 224 */           param2BaseShader.set(param2Int, ((FloatAttribute)param2Attributes.get(FloatAttribute.Shininess)).value);
/*     */         }
/*     */       };
/* 227 */     public static final BaseShader.Setter diffuseColor = new BaseShader.LocalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 230 */           param2BaseShader.set(param2Int, ((ColorAttribute)param2Attributes.get(ColorAttribute.Diffuse)).color);
/*     */         }
/*     */       };
/* 233 */     public static final BaseShader.Setter diffuseTexture = new BaseShader.LocalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes)
/*     */         {
/* 237 */           int i = param2BaseShader.context.textureBinder.bind(((TextureAttribute)param2Attributes.get(TextureAttribute.Diffuse)).textureDescription);
/* 238 */           param2BaseShader.set(param2Int, i);
/*     */         }
/*     */       };
/* 241 */     public static final BaseShader.Setter diffuseUVTransform = new BaseShader.LocalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 244 */           TextureAttribute textureAttribute = (TextureAttribute)param2Attributes.get(TextureAttribute.Diffuse);
/* 245 */           param2BaseShader.set(param2Int, textureAttribute.offsetU, textureAttribute.offsetV, textureAttribute.scaleU, textureAttribute.scaleV);
/*     */         }
/*     */       };
/* 248 */     public static final BaseShader.Setter specularColor = new BaseShader.LocalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 251 */           param2BaseShader.set(param2Int, ((ColorAttribute)param2Attributes.get(ColorAttribute.Specular)).color);
/*     */         }
/*     */       };
/* 254 */     public static final BaseShader.Setter specularTexture = new BaseShader.LocalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes)
/*     */         {
/* 258 */           int i = param2BaseShader.context.textureBinder.bind(((TextureAttribute)param2Attributes.get(TextureAttribute.Specular)).textureDescription);
/* 259 */           param2BaseShader.set(param2Int, i);
/*     */         }
/*     */       };
/* 262 */     public static final BaseShader.Setter specularUVTransform = new BaseShader.LocalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 265 */           TextureAttribute textureAttribute = (TextureAttribute)param2Attributes.get(TextureAttribute.Specular);
/* 266 */           param2BaseShader.set(param2Int, textureAttribute.offsetU, textureAttribute.offsetV, textureAttribute.scaleU, textureAttribute.scaleV);
/*     */         }
/*     */       };
/* 269 */     public static final BaseShader.Setter emissiveColor = new BaseShader.LocalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 272 */           param2BaseShader.set(param2Int, ((ColorAttribute)param2Attributes.get(ColorAttribute.Emissive)).color);
/*     */         }
/*     */       };
/* 275 */     public static final BaseShader.Setter emissiveTexture = new BaseShader.LocalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes)
/*     */         {
/* 279 */           int i = param2BaseShader.context.textureBinder.bind(((TextureAttribute)param2Attributes.get(TextureAttribute.Emissive)).textureDescription);
/* 280 */           param2BaseShader.set(param2Int, i);
/*     */         }
/*     */       };
/* 283 */     public static final BaseShader.Setter emissiveUVTransform = new BaseShader.LocalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 286 */           TextureAttribute textureAttribute = (TextureAttribute)param2Attributes.get(TextureAttribute.Emissive);
/* 287 */           param2BaseShader.set(param2Int, textureAttribute.offsetU, textureAttribute.offsetV, textureAttribute.scaleU, textureAttribute.scaleV);
/*     */         }
/*     */       };
/* 290 */     public static final BaseShader.Setter reflectionColor = new BaseShader.LocalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 293 */           param2BaseShader.set(param2Int, ((ColorAttribute)param2Attributes.get(ColorAttribute.Reflection)).color);
/*     */         }
/*     */       };
/* 296 */     public static final BaseShader.Setter reflectionTexture = new BaseShader.LocalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes)
/*     */         {
/* 300 */           int i = param2BaseShader.context.textureBinder.bind(((TextureAttribute)param2Attributes.get(TextureAttribute.Reflection)).textureDescription);
/* 301 */           param2BaseShader.set(param2Int, i);
/*     */         }
/*     */       };
/* 304 */     public static final BaseShader.Setter reflectionUVTransform = new BaseShader.LocalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 307 */           TextureAttribute textureAttribute = (TextureAttribute)param2Attributes.get(TextureAttribute.Reflection);
/* 308 */           param2BaseShader.set(param2Int, textureAttribute.offsetU, textureAttribute.offsetV, textureAttribute.scaleU, textureAttribute.scaleV);
/*     */         }
/*     */       };
/* 311 */     public static final BaseShader.Setter normalTexture = new BaseShader.LocalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes)
/*     */         {
/* 315 */           int i = param2BaseShader.context.textureBinder.bind(((TextureAttribute)param2Attributes.get(TextureAttribute.Normal)).textureDescription);
/* 316 */           param2BaseShader.set(param2Int, i);
/*     */         }
/*     */       };
/* 319 */     public static final BaseShader.Setter normalUVTransform = new BaseShader.LocalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 322 */           TextureAttribute textureAttribute = (TextureAttribute)param2Attributes.get(TextureAttribute.Normal);
/* 323 */           param2BaseShader.set(param2Int, textureAttribute.offsetU, textureAttribute.offsetV, textureAttribute.scaleU, textureAttribute.scaleV);
/*     */         }
/*     */       };
/* 326 */     public static final BaseShader.Setter ambientTexture = new BaseShader.LocalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes)
/*     */         {
/* 330 */           int i = param2BaseShader.context.textureBinder.bind(((TextureAttribute)param2Attributes.get(TextureAttribute.Ambient)).textureDescription);
/* 331 */           param2BaseShader.set(param2Int, i);
/*     */         }
/*     */       };
/* 334 */     public static final BaseShader.Setter ambientUVTransform = new BaseShader.LocalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 337 */           TextureAttribute textureAttribute = (TextureAttribute)param2Attributes.get(TextureAttribute.Ambient);
/* 338 */           param2BaseShader.set(param2Int, textureAttribute.offsetU, textureAttribute.offsetV, textureAttribute.scaleU, textureAttribute.scaleV);
/*     */         }
/*     */       };
/*     */     
/*     */     public static class ACubemap extends BaseShader.LocalSetter {
/* 343 */       private static final float[] ones = new float[] { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F };
/* 344 */       private final AmbientCubemap cacheAmbientCubemap = new AmbientCubemap();
/* 345 */       private static final Vector3 tmpV1 = new Vector3();
/*     */       public final int dirLightsOffset;
/*     */       public final int pointLightsOffset;
/*     */       
/*     */       public ACubemap(int param2Int1, int param2Int2) {
/* 350 */         this.dirLightsOffset = param2Int1;
/* 351 */         this.pointLightsOffset = param2Int2;
/*     */       }
/*     */ 
/*     */       
/*     */       public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 356 */         if (param2Renderable.environment == null) {
/* 357 */           param2BaseShader.program.setUniform3fv(param2BaseShader.loc(param2Int), ones, 0, ones.length); return;
/*     */         } 
/* 359 */         param2Renderable.worldTransform.getTranslation(tmpV1);
/* 360 */         if (param2Attributes.has(ColorAttribute.AmbientLight)) {
/* 361 */           this.cacheAmbientCubemap.set(((ColorAttribute)param2Attributes.get(ColorAttribute.AmbientLight)).color);
/*     */         }
/* 363 */         if (param2Attributes.has(DirectionalLightsAttribute.Type)) {
/*     */           
/* 365 */           Array array = ((DirectionalLightsAttribute)param2Attributes.get(DirectionalLightsAttribute.Type)).lights;
/* 366 */           for (int i = this.dirLightsOffset; i < array.size; i++) {
/* 367 */             this.cacheAmbientCubemap.add(((DirectionalLight)array.get(i)).color, ((DirectionalLight)array.get(i)).direction);
/*     */           }
/*     */         } 
/* 370 */         if (param2Attributes.has(PointLightsAttribute.Type)) {
/* 371 */           Array array = ((PointLightsAttribute)param2Attributes.get(PointLightsAttribute.Type)).lights;
/* 372 */           for (int i = this.pointLightsOffset; i < array.size; i++) {
/* 373 */             this.cacheAmbientCubemap.add(((PointLight)array.get(i)).color, ((PointLight)array.get(i)).position, tmpV1, ((PointLight)array.get(i)).intensity);
/*     */           }
/*     */         } 
/* 376 */         this.cacheAmbientCubemap.clamp();
/* 377 */         param2BaseShader.program.setUniform3fv(param2BaseShader.loc(param2Int), this.cacheAmbientCubemap.data, 0, this.cacheAmbientCubemap.data.length);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 382 */     public static final BaseShader.Setter environmentCubemap = new BaseShader.LocalSetter()
/*     */       {
/*     */         public void set(BaseShader param2BaseShader, int param2Int, Renderable param2Renderable, Attributes param2Attributes) {
/* 385 */           if (param2Attributes.has(CubemapAttribute.EnvironmentMap))
/* 386 */             param2BaseShader.set(param2Int, param2BaseShader.context.textureBinder
/* 387 */                 .bind(((CubemapAttribute)param2Attributes.get(CubemapAttribute.EnvironmentMap)).textureDescription)); 
/*     */         }
/*     */       }; } public static class Bones extends BaseShader.LocalSetter { private static final Matrix4 idtMatrix = new Matrix4(); public final float[] bones; public Bones(int param1Int) { this.bones = new float[param1Int << 4]; }
/*     */     public void set(BaseShader param1BaseShader, int param1Int, Renderable param1Renderable, Attributes param1Attributes) { for (byte b = 0; b < this.bones.length; b += 16) { int i = b / 16; if (param1Renderable.bones == null || i >= param1Renderable.bones.length || param1Renderable.bones[i] == null) { System.arraycopy(idtMatrix.val, 0, this.bones, b, 16); } else { System.arraycopy((param1Renderable.bones[i]).val, 0, this.bones, b, 16); }  }  param1BaseShader.program.setUniformMatrix4fv(param1BaseShader.loc(param1Int), this.bones, 0, this.bones.length); } }
/*     */   public static class ACubemap extends BaseShader.LocalSetter { private static final float[] ones = new float[] { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F }; private final AmbientCubemap cacheAmbientCubemap = new AmbientCubemap(); private static final Vector3 tmpV1 = new Vector3(); public final int dirLightsOffset; public final int pointLightsOffset;
/*     */     public ACubemap(int param1Int1, int param1Int2) { this.dirLightsOffset = param1Int1; this.pointLightsOffset = param1Int2; }
/* 393 */     public void set(BaseShader param1BaseShader, int param1Int, Renderable param1Renderable, Attributes param1Attributes) { if (param1Renderable.environment == null) { param1BaseShader.program.setUniform3fv(param1BaseShader.loc(param1Int), ones, 0, ones.length); return; }  param1Renderable.worldTransform.getTranslation(tmpV1); if (param1Attributes.has(ColorAttribute.AmbientLight)) this.cacheAmbientCubemap.set(((ColorAttribute)param1Attributes.get(ColorAttribute.AmbientLight)).color);  if (param1Attributes.has(DirectionalLightsAttribute.Type)) { Array array = ((DirectionalLightsAttribute)param1Attributes.get(DirectionalLightsAttribute.Type)).lights; for (int i = this.dirLightsOffset; i < array.size; i++) this.cacheAmbientCubemap.add(((DirectionalLight)array.get(i)).color, ((DirectionalLight)array.get(i)).direction);  }  if (param1Attributes.has(PointLightsAttribute.Type)) { Array array = ((PointLightsAttribute)param1Attributes.get(PointLightsAttribute.Type)).lights; for (int i = this.pointLightsOffset; i < array.size; i++) this.cacheAmbientCubemap.add(((PointLight)array.get(i)).color, ((PointLight)array.get(i)).position, tmpV1, ((PointLight)array.get(i)).intensity);  }  this.cacheAmbientCubemap.clamp(); param1BaseShader.program.setUniform3fv(param1BaseShader.loc(param1Int), this.cacheAmbientCubemap.data, 0, this.cacheAmbientCubemap.data.length); } } private static String defaultVertexShader = null;
/*     */   
/*     */   public static String getDefaultVertexShader() {
/* 396 */     if (defaultVertexShader == null)
/* 397 */       defaultVertexShader = Gdx.files.classpath("com/badlogic/gdx/graphics/g3d/shaders/default.vertex.glsl").readString(); 
/* 398 */     return defaultVertexShader;
/*     */   }
/*     */   
/* 401 */   private static String defaultFragmentShader = null;
/*     */   
/*     */   public static String getDefaultFragmentShader() {
/* 404 */     if (defaultFragmentShader == null)
/* 405 */       defaultFragmentShader = Gdx.files.classpath("com/badlogic/gdx/graphics/g3d/shaders/default.fragment.glsl").readString(); 
/* 406 */     return defaultFragmentShader;
/*     */   }
/*     */   
/* 409 */   protected static long implementedFlags = BlendingAttribute.Type | TextureAttribute.Diffuse | ColorAttribute.Diffuse | ColorAttribute.Specular | FloatAttribute.Shininess;
/*     */ 
/*     */   
/*     */   @Deprecated
/* 413 */   public static int defaultCullFace = 1029;
/*     */   @Deprecated
/* 415 */   public static int defaultDepthFunc = 515;
/*     */   
/*     */   public final int u_projTrans;
/*     */   
/*     */   public final int u_viewTrans;
/*     */   
/*     */   public final int u_projViewTrans;
/*     */   
/*     */   public final int u_cameraPosition;
/*     */   
/*     */   public final int u_cameraDirection;
/*     */   public final int u_cameraUp;
/*     */   public final int u_cameraNearFar;
/*     */   public final int u_time;
/*     */   public final int u_worldTrans;
/*     */   public final int u_viewWorldTrans;
/*     */   public final int u_projViewWorldTrans;
/*     */   public final int u_normalMatrix;
/*     */   public final int u_bones;
/*     */   public final int u_shininess;
/*     */   public final int u_opacity;
/*     */   public final int u_diffuseColor;
/*     */   public final int u_diffuseTexture;
/*     */   public final int u_diffuseUVTransform;
/*     */   public final int u_specularColor;
/*     */   public final int u_specularTexture;
/*     */   public final int u_specularUVTransform;
/*     */   public final int u_emissiveColor;
/*     */   public final int u_emissiveTexture;
/*     */   public final int u_emissiveUVTransform;
/*     */   public final int u_reflectionColor;
/*     */   public final int u_reflectionTexture;
/*     */   public final int u_reflectionUVTransform;
/*     */   public final int u_normalTexture;
/*     */   public final int u_normalUVTransform;
/*     */   public final int u_ambientTexture;
/*     */   public final int u_ambientUVTransform;
/*     */   public final int u_alphaTest;
/*     */   protected final int u_ambientCubemap;
/*     */   protected final int u_environmentCubemap;
/* 455 */   protected final int u_dirLights0color = register(new BaseShader.Uniform("u_dirLights[0].color"));
/* 456 */   protected final int u_dirLights0direction = register(new BaseShader.Uniform("u_dirLights[0].direction"));
/* 457 */   protected final int u_dirLights1color = register(new BaseShader.Uniform("u_dirLights[1].color"));
/* 458 */   protected final int u_pointLights0color = register(new BaseShader.Uniform("u_pointLights[0].color"));
/* 459 */   protected final int u_pointLights0position = register(new BaseShader.Uniform("u_pointLights[0].position"));
/* 460 */   protected final int u_pointLights0intensity = register(new BaseShader.Uniform("u_pointLights[0].intensity"));
/* 461 */   protected final int u_pointLights1color = register(new BaseShader.Uniform("u_pointLights[1].color"));
/* 462 */   protected final int u_spotLights0color = register(new BaseShader.Uniform("u_spotLights[0].color"));
/* 463 */   protected final int u_spotLights0position = register(new BaseShader.Uniform("u_spotLights[0].position"));
/* 464 */   protected final int u_spotLights0intensity = register(new BaseShader.Uniform("u_spotLights[0].intensity"));
/* 465 */   protected final int u_spotLights0direction = register(new BaseShader.Uniform("u_spotLights[0].direction"));
/* 466 */   protected final int u_spotLights0cutoffAngle = register(new BaseShader.Uniform("u_spotLights[0].cutoffAngle"));
/* 467 */   protected final int u_spotLights0exponent = register(new BaseShader.Uniform("u_spotLights[0].exponent"));
/* 468 */   protected final int u_spotLights1color = register(new BaseShader.Uniform("u_spotLights[1].color"));
/* 469 */   protected final int u_fogColor = register(new BaseShader.Uniform("u_fogColor"));
/* 470 */   protected final int u_shadowMapProjViewTrans = register(new BaseShader.Uniform("u_shadowMapProjViewTrans"));
/* 471 */   protected final int u_shadowTexture = register(new BaseShader.Uniform("u_shadowTexture"));
/* 472 */   protected final int u_shadowPCFOffset = register(new BaseShader.Uniform("u_shadowPCFOffset"));
/*     */   
/*     */   protected int dirLightsLoc;
/*     */   
/*     */   protected int dirLightsColorOffset;
/*     */   
/*     */   protected int dirLightsDirectionOffset;
/*     */   protected int dirLightsSize;
/*     */   protected int pointLightsLoc;
/*     */   protected int pointLightsColorOffset;
/*     */   protected int pointLightsPositionOffset;
/*     */   protected int pointLightsIntensityOffset;
/*     */   protected int pointLightsSize;
/*     */   protected int spotLightsLoc;
/*     */   protected int spotLightsColorOffset;
/*     */   protected int spotLightsPositionOffset;
/*     */   protected int spotLightsDirectionOffset;
/*     */   protected int spotLightsIntensityOffset;
/*     */   protected int spotLightsCutoffAngleOffset;
/*     */   protected int spotLightsExponentOffset;
/*     */   protected int spotLightsSize;
/*     */   protected final boolean lighting;
/*     */   protected final boolean environmentCubemap;
/*     */   protected final boolean shadowMap;
/* 496 */   protected final AmbientCubemap ambientCubemap = new AmbientCubemap();
/*     */   
/*     */   protected final DirectionalLight[] directionalLights;
/*     */   
/*     */   protected final PointLight[] pointLights;
/*     */   
/*     */   protected final SpotLight[] spotLights;
/*     */   
/*     */   private Renderable renderable;
/*     */   protected final long attributesMask;
/*     */   private final long vertexMask;
/*     */   private final int textureCoordinates;
/*     */   private int[] boneWeightsLocations;
/*     */   protected final Config config;
/* 510 */   private static final long optionalAttributes = IntAttribute.CullFace | DepthTestAttribute.Type;
/*     */   
/*     */   public DefaultShader(Renderable paramRenderable) {
/* 513 */     this(paramRenderable, new Config());
/*     */   }
/*     */   
/*     */   public DefaultShader(Renderable paramRenderable, Config paramConfig) {
/* 517 */     this(paramRenderable, paramConfig, createPrefix(paramRenderable, paramConfig));
/*     */   }
/*     */   
/*     */   public DefaultShader(Renderable paramRenderable, Config paramConfig, String paramString) {
/* 521 */     this(paramRenderable, paramConfig, paramString, (paramConfig.vertexShader != null) ? paramConfig.vertexShader : getDefaultVertexShader(), 
/* 522 */         (paramConfig.fragmentShader != null) ? paramConfig.fragmentShader : getDefaultFragmentShader());
/*     */   }
/*     */ 
/*     */   
/*     */   public DefaultShader(Renderable paramRenderable, Config paramConfig, String paramString1, String paramString2, String paramString3) {
/* 527 */     this(paramRenderable, paramConfig, new ShaderProgram(paramString1 + paramString2, paramString1 + paramString3));
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
/*     */   public void init() {
/* 614 */     ShaderProgram shaderProgram = this.program;
/* 615 */     this.program = null;
/* 616 */     init(shaderProgram, this.renderable);
/* 617 */     this.renderable = null;
/*     */     
/* 619 */     this.dirLightsLoc = loc(this.u_dirLights0color);
/* 620 */     this.dirLightsColorOffset = loc(this.u_dirLights0color) - this.dirLightsLoc;
/* 621 */     this.dirLightsDirectionOffset = loc(this.u_dirLights0direction) - this.dirLightsLoc;
/* 622 */     this.dirLightsSize = loc(this.u_dirLights1color) - this.dirLightsLoc;
/* 623 */     if (this.dirLightsSize < 0) this.dirLightsSize = 0;
/*     */     
/* 625 */     this.pointLightsLoc = loc(this.u_pointLights0color);
/* 626 */     this.pointLightsColorOffset = loc(this.u_pointLights0color) - this.pointLightsLoc;
/* 627 */     this.pointLightsPositionOffset = loc(this.u_pointLights0position) - this.pointLightsLoc;
/* 628 */     this.pointLightsIntensityOffset = has(this.u_pointLights0intensity) ? (loc(this.u_pointLights0intensity) - this.pointLightsLoc) : -1;
/* 629 */     this.pointLightsSize = loc(this.u_pointLights1color) - this.pointLightsLoc;
/* 630 */     if (this.pointLightsSize < 0) this.pointLightsSize = 0;
/*     */     
/* 632 */     this.spotLightsLoc = loc(this.u_spotLights0color);
/* 633 */     this.spotLightsColorOffset = loc(this.u_spotLights0color) - this.spotLightsLoc;
/* 634 */     this.spotLightsPositionOffset = loc(this.u_spotLights0position) - this.spotLightsLoc;
/* 635 */     this.spotLightsDirectionOffset = loc(this.u_spotLights0direction) - this.spotLightsLoc;
/* 636 */     this.spotLightsIntensityOffset = has(this.u_spotLights0intensity) ? (loc(this.u_spotLights0intensity) - this.spotLightsLoc) : -1;
/* 637 */     this.spotLightsCutoffAngleOffset = loc(this.u_spotLights0cutoffAngle) - this.spotLightsLoc;
/* 638 */     this.spotLightsExponentOffset = loc(this.u_spotLights0exponent) - this.spotLightsLoc;
/* 639 */     this.spotLightsSize = loc(this.u_spotLights1color) - this.spotLightsLoc;
/* 640 */     if (this.spotLightsSize < 0) this.spotLightsSize = 0;
/*     */     
/* 642 */     if (this.boneWeightsLocations != null) {
/* 643 */       for (byte b = 0; b < this.boneWeightsLocations.length; b++) {
/* 644 */         this.boneWeightsLocations[b] = shaderProgram.getAttributeLocation("a_boneWeight" + b);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static final boolean and(long paramLong1, long paramLong2) {
/* 650 */     return ((paramLong1 & paramLong2) == paramLong2);
/*     */   }
/*     */   
/*     */   private static final boolean or(long paramLong1, long paramLong2) {
/* 654 */     return ((paramLong1 & paramLong2) != 0L);
/*     */   }
/*     */   
/* 657 */   private static final Attributes tmpAttributes = new Attributes(); private final Matrix3 normalMatrix; private float time; private boolean lightsSet;
/*     */   private final Vector3 tmpV1;
/*     */   
/*     */   private static final Attributes combineAttributes(Renderable paramRenderable) {
/* 661 */     tmpAttributes.clear();
/* 662 */     if (paramRenderable.environment != null) tmpAttributes.set((Iterable)paramRenderable.environment); 
/* 663 */     if (paramRenderable.material != null) tmpAttributes.set((Iterable)paramRenderable.material); 
/* 664 */     return tmpAttributes;
/*     */   }
/*     */   
/*     */   private static final long combineAttributeMasks(Renderable paramRenderable) {
/* 668 */     long l = 0L;
/* 669 */     if (paramRenderable.environment != null) l = 0x0L | paramRenderable.environment.getMask(); 
/* 670 */     if (paramRenderable.material != null) l |= paramRenderable.material.getMask(); 
/* 671 */     return l;
/*     */   }
/*     */   
/*     */   public static String createPrefix(Renderable paramRenderable, Config paramConfig) {
/* 675 */     Attributes attributes = combineAttributes(paramRenderable);
/* 676 */     String str = "";
/* 677 */     long l1 = attributes.getMask();
/*     */     long l2;
/* 679 */     if (and(l2 = paramRenderable.meshPart.mesh.getVertexAttributes().getMask(), 1L)) str = str + "#define positionFlag\n"; 
/* 680 */     if (or(l2, 6L)) str = str + "#define colorFlag\n"; 
/* 681 */     if (and(l2, 256L)) str = str + "#define binormalFlag\n"; 
/* 682 */     if (and(l2, 128L)) str = str + "#define tangentFlag\n"; 
/* 683 */     if (and(l2, 8L)) str = str + "#define normalFlag\n"; 
/* 684 */     if ((and(l2, 8L) || and(l2, 384L)) && 
/* 685 */       paramRenderable.environment != null) {
/* 686 */       str = str + "#define lightingFlag\n";
/* 687 */       str = str + "#define ambientCubemapFlag\n";
/* 688 */       str = str + "#define numDirectionalLights " + paramConfig.numDirectionalLights + "\n";
/* 689 */       str = str + "#define numPointLights " + paramConfig.numPointLights + "\n";
/* 690 */       str = str + "#define numSpotLights " + paramConfig.numSpotLights + "\n";
/* 691 */       if (attributes.has(ColorAttribute.Fog)) {
/* 692 */         str = str + "#define fogFlag\n";
/*     */       }
/* 694 */       if (paramRenderable.environment.shadowMap != null) str = str + "#define shadowMapFlag\n"; 
/* 695 */       if (attributes.has(CubemapAttribute.EnvironmentMap)) str = str + "#define environmentCubemapFlag\n";
/*     */     
/*     */     } 
/* 698 */     int i = paramRenderable.meshPart.mesh.getVertexAttributes().size(); byte b;
/* 699 */     for (b = 0; b < i; b++) {
/*     */       VertexAttribute vertexAttribute;
/* 701 */       if ((vertexAttribute = paramRenderable.meshPart.mesh.getVertexAttributes().get(b)).usage == 16) str = str + "#define texCoord" + vertexAttribute.unit + "Flag\n"; 
/*     */     } 
/* 703 */     if (paramRenderable.bones != null) {
/* 704 */       for (b = 0; b < paramConfig.numBoneWeights; b++) {
/* 705 */         str = str + "#define boneWeight" + b + "Flag\n";
/*     */       }
/*     */     }
/* 708 */     if ((l1 & BlendingAttribute.Type) == BlendingAttribute.Type)
/* 709 */       str = str + "#define blendedFlag\n"; 
/* 710 */     if ((l1 & TextureAttribute.Diffuse) == TextureAttribute.Diffuse) {
/* 711 */       str = str + "#define diffuseTextureFlag\n";
/* 712 */       str = str + "#define diffuseTextureCoord texCoord0\n";
/*     */     } 
/* 714 */     if ((l1 & TextureAttribute.Specular) == TextureAttribute.Specular) {
/* 715 */       str = str + "#define specularTextureFlag\n";
/* 716 */       str = str + "#define specularTextureCoord texCoord0\n";
/*     */     } 
/* 718 */     if ((l1 & TextureAttribute.Normal) == TextureAttribute.Normal) {
/* 719 */       str = str + "#define normalTextureFlag\n";
/* 720 */       str = str + "#define normalTextureCoord texCoord0\n";
/*     */     } 
/* 722 */     if ((l1 & TextureAttribute.Emissive) == TextureAttribute.Emissive) {
/* 723 */       str = str + "#define emissiveTextureFlag\n";
/* 724 */       str = str + "#define emissiveTextureCoord texCoord0\n";
/*     */     } 
/* 726 */     if ((l1 & TextureAttribute.Reflection) == TextureAttribute.Reflection) {
/* 727 */       str = str + "#define reflectionTextureFlag\n";
/* 728 */       str = str + "#define reflectionTextureCoord texCoord0\n";
/*     */     } 
/* 730 */     if ((l1 & TextureAttribute.Ambient) == TextureAttribute.Ambient) {
/* 731 */       str = str + "#define ambientTextureFlag\n";
/* 732 */       str = str + "#define ambientTextureCoord texCoord0\n";
/*     */     } 
/* 734 */     if ((l1 & ColorAttribute.Diffuse) == ColorAttribute.Diffuse)
/* 735 */       str = str + "#define diffuseColorFlag\n"; 
/* 736 */     if ((l1 & ColorAttribute.Specular) == ColorAttribute.Specular)
/* 737 */       str = str + "#define specularColorFlag\n"; 
/* 738 */     if ((l1 & ColorAttribute.Emissive) == ColorAttribute.Emissive)
/* 739 */       str = str + "#define emissiveColorFlag\n"; 
/* 740 */     if ((l1 & ColorAttribute.Reflection) == ColorAttribute.Reflection)
/* 741 */       str = str + "#define reflectionColorFlag\n"; 
/* 742 */     if ((l1 & FloatAttribute.Shininess) == FloatAttribute.Shininess)
/* 743 */       str = str + "#define shininessFlag\n"; 
/* 744 */     if ((l1 & FloatAttribute.AlphaTest) == FloatAttribute.AlphaTest)
/* 745 */       str = str + "#define alphaTestFlag\n"; 
/* 746 */     if (paramRenderable.bones != null && paramConfig.numBones > 0) str = str + "#define numBones " + paramConfig.numBones + "\n"; 
/* 747 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canRender(Renderable paramRenderable) {
/* 752 */     if (paramRenderable.bones != null) {
/* 753 */       if (paramRenderable.bones.length > this.config.numBones) return false; 
/* 754 */       if (paramRenderable.meshPart.mesh.getVertexAttributes().getBoneWeights() > this.config.numBoneWeights) return false; 
/*     */     } 
/* 756 */     if (paramRenderable.meshPart.mesh.getVertexAttributes().getTextureCoordinates() != this.textureCoordinates) return false; 
/* 757 */     long l = combineAttributeMasks(paramRenderable);
/* 758 */     if (this.attributesMask == (l | optionalAttributes) && this.vertexMask == paramRenderable.meshPart.mesh
/* 759 */       .getVertexAttributes().getMaskWithSizePacked() && ((paramRenderable.environment != null)) == this.lighting) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */   
/*     */   public int compareTo(Shader paramShader) {
/* 765 */     if (paramShader == null) return -1; 
/* 766 */     if (paramShader == this) return 0; 
/* 767 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 772 */     return (paramObject instanceof DefaultShader && equals((DefaultShader)paramObject));
/*     */   }
/*     */   
/*     */   public boolean equals(DefaultShader paramDefaultShader) {
/* 776 */     return (paramDefaultShader == this);
/*     */   } public void begin(Camera paramCamera, RenderContext paramRenderContext) { super.begin(paramCamera, paramRenderContext); DirectionalLight[] arrayOfDirectionalLight; int i; byte b; for (i = (arrayOfDirectionalLight = this.directionalLights).length, b = 0; b < i; b++) { DirectionalLight directionalLight; (directionalLight = arrayOfDirectionalLight[b]).set(0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F); }  PointLight[] arrayOfPointLight; for (i = (arrayOfPointLight = this.pointLights).length, b = 0; b < i; b++) { PointLight pointLight; (pointLight = arrayOfPointLight[b]).set(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F); }  SpotLight[] arrayOfSpotLight; for (i = (arrayOfSpotLight = this.spotLights).length, b = 0; b < i; b++) { SpotLight spotLight; (spotLight = arrayOfSpotLight[b]).set(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F); }  this.lightsSet = false; if (has(this.u_time))
/*     */       set(this.u_time, this.time += Gdx.graphics.getDeltaTime());  if (this.boneWeightsLocations != null) { int[] arrayOfInt; for (i = (arrayOfInt = this.boneWeightsLocations).length, b = 0; b < i; b++) { int j; if ((j = arrayOfInt[b]) >= 0)
/* 779 */           Gdx.gl.glVertexAttrib2f(j, 0.0F, 0.0F);  }  }  } public DefaultShader(Renderable paramRenderable, Config paramConfig, ShaderProgram paramShaderProgram) { this.normalMatrix = new Matrix3();
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
/* 851 */     this.tmpV1 = new Vector3(); Attributes attributes = combineAttributes(paramRenderable); this.config = paramConfig; this.program = paramShaderProgram; this.lighting = (paramRenderable.environment != null); this.environmentCubemap = (attributes.has(CubemapAttribute.EnvironmentMap) || (this.lighting && attributes.has(CubemapAttribute.EnvironmentMap))); this.shadowMap = (this.lighting && paramRenderable.environment.shadowMap != null); this.renderable = paramRenderable; this.attributesMask = attributes.getMask() | optionalAttributes; this.vertexMask = paramRenderable.meshPart.mesh.getVertexAttributes().getMaskWithSizePacked(); this.textureCoordinates = paramRenderable.meshPart.mesh.getVertexAttributes().getTextureCoordinates(); this.directionalLights = new DirectionalLight[(this.lighting && paramConfig.numDirectionalLights > 0) ? paramConfig.numDirectionalLights : 0]; int i; for (i = 0; i < this.directionalLights.length; i++) this.directionalLights[i] = new DirectionalLight();  this.pointLights = new PointLight[(this.lighting && paramConfig.numPointLights > 0) ? paramConfig.numPointLights : 0]; for (i = 0; i < this.pointLights.length; i++) this.pointLights[i] = new PointLight();  this.spotLights = new SpotLight[(this.lighting && paramConfig.numSpotLights > 0) ? paramConfig.numSpotLights : 0]; for (i = 0; i < this.spotLights.length; i++) this.spotLights[i] = new SpotLight();  if (!paramConfig.ignoreUnimplemented && (implementedFlags & this.attributesMask) != this.attributesMask) throw new GdxRuntimeException("Some attributes not implemented yet (" + this.attributesMask + ")");  if (paramRenderable.bones != null && paramRenderable.bones.length > paramConfig.numBones) throw new GdxRuntimeException("too many bones: " + paramRenderable.bones.length + ", max configured: " + paramConfig.numBones);  if ((i = paramRenderable.meshPart.mesh.getVertexAttributes().getBoneWeights()) > paramConfig.numBoneWeights) throw new GdxRuntimeException("too many bone weights: " + i + ", max configured: " + paramConfig.numBoneWeights);  if (paramRenderable.bones != null) this.boneWeightsLocations = new int[paramConfig.numBoneWeights];  this.u_projTrans = register(Inputs.projTrans, Setters.projTrans); this.u_viewTrans = register(Inputs.viewTrans, Setters.viewTrans); this.u_projViewTrans = register(Inputs.projViewTrans, Setters.projViewTrans); this.u_cameraPosition = register(Inputs.cameraPosition, Setters.cameraPosition); this.u_cameraDirection = register(Inputs.cameraDirection, Setters.cameraDirection); this.u_cameraUp = register(Inputs.cameraUp, Setters.cameraUp); this.u_cameraNearFar = register(Inputs.cameraNearFar, Setters.cameraNearFar); this.u_time = register(new BaseShader.Uniform("u_time")); this.u_worldTrans = register(Inputs.worldTrans, Setters.worldTrans); this.u_viewWorldTrans = register(Inputs.viewWorldTrans, Setters.viewWorldTrans); this.u_projViewWorldTrans = register(Inputs.projViewWorldTrans, Setters.projViewWorldTrans); this.u_normalMatrix = register(Inputs.normalMatrix, Setters.normalMatrix); this.u_bones = (paramRenderable.bones != null && paramConfig.numBones > 0) ? register(Inputs.bones, new Setters.Bones(paramConfig.numBones)) : -1; this.u_shininess = register(Inputs.shininess, Setters.shininess); this.u_opacity = register(Inputs.opacity); this.u_diffuseColor = register(Inputs.diffuseColor, Setters.diffuseColor); this.u_diffuseTexture = register(Inputs.diffuseTexture, Setters.diffuseTexture); this.u_diffuseUVTransform = register(Inputs.diffuseUVTransform, Setters.diffuseUVTransform); this.u_specularColor = register(Inputs.specularColor, Setters.specularColor); this.u_specularTexture = register(Inputs.specularTexture, Setters.specularTexture); this.u_specularUVTransform = register(Inputs.specularUVTransform, Setters.specularUVTransform); this.u_emissiveColor = register(Inputs.emissiveColor, Setters.emissiveColor); this.u_emissiveTexture = register(Inputs.emissiveTexture, Setters.emissiveTexture); this.u_emissiveUVTransform = register(Inputs.emissiveUVTransform, Setters.emissiveUVTransform); this.u_reflectionColor = register(Inputs.reflectionColor, Setters.reflectionColor); this.u_reflectionTexture = register(Inputs.reflectionTexture, Setters.reflectionTexture); this.u_reflectionUVTransform = register(Inputs.reflectionUVTransform, Setters.reflectionUVTransform); this.u_normalTexture = register(Inputs.normalTexture, Setters.normalTexture); this.u_normalUVTransform = register(Inputs.normalUVTransform, Setters.normalUVTransform); this.u_ambientTexture = register(Inputs.ambientTexture, Setters.ambientTexture); this.u_ambientUVTransform = register(Inputs.ambientUVTransform, Setters.ambientUVTransform); this.u_alphaTest = register(Inputs.alphaTest); this.u_ambientCubemap = this.lighting ? register(Inputs.ambientCube, new Setters.ACubemap(paramConfig.numDirectionalLights, paramConfig.numPointLights)) : -1; this.u_environmentCubemap = this.environmentCubemap ? register(Inputs.environmentCubemap, Setters.environmentCubemap) : -1; }
/*     */   public void render(Renderable paramRenderable, Attributes paramAttributes) { if (!paramAttributes.has(BlendingAttribute.Type))
/*     */       this.context.setBlending(false, 770, 771);  bindMaterial(paramAttributes); if (this.lighting)
/* 854 */       bindLights(paramRenderable, paramAttributes);  super.render(paramRenderable, paramAttributes); } protected void bindLights(Renderable paramRenderable, Attributes paramAttributes) { Environment environment = paramRenderable.environment;
/*     */     DirectionalLightsAttribute directionalLightsAttribute;
/* 856 */     Array array1 = ((directionalLightsAttribute = (DirectionalLightsAttribute)paramAttributes.get(DirectionalLightsAttribute.class, DirectionalLightsAttribute.Type)) == null) ? null : directionalLightsAttribute.lights;
/*     */     PointLightsAttribute pointLightsAttribute;
/* 858 */     Array array2 = ((pointLightsAttribute = (PointLightsAttribute)paramAttributes.get(PointLightsAttribute.class, PointLightsAttribute.Type)) == null) ? null : pointLightsAttribute.lights;
/*     */     SpotLightsAttribute spotLightsAttribute;
/* 860 */     Array array3 = ((spotLightsAttribute = (SpotLightsAttribute)paramAttributes.get(SpotLightsAttribute.class, SpotLightsAttribute.Type)) == null) ? null : spotLightsAttribute.lights;
/*     */     
/* 862 */     if (this.dirLightsLoc >= 0)
/* 863 */       for (byte b = 0; b < this.directionalLights.length; b++) {
/* 864 */         if (array1 == null || b >= array1.size)
/* 865 */         { if (!this.lightsSet || (this.directionalLights[b]).color.r != 0.0F || (this.directionalLights[b]).color.g != 0.0F || (this.directionalLights[b]).color.b != 0.0F)
/*     */           
/* 867 */           { (this.directionalLights[b]).color.set(0.0F, 0.0F, 0.0F, 1.0F); } else { continue; }  }
/* 868 */         else if (!this.lightsSet || !this.directionalLights[b].equals((DirectionalLight)array1.get(b)))
/*     */         
/*     */         { 
/* 871 */           this.directionalLights[b].set((DirectionalLight)array1.get(b)); }
/*     */         else { continue; }
/* 873 */          int i = this.dirLightsLoc + b * this.dirLightsSize;
/* 874 */         this.program.setUniformf(i + this.dirLightsColorOffset, (this.directionalLights[b]).color.r, (this.directionalLights[b]).color.g, (this.directionalLights[b]).color.b);
/*     */         
/* 876 */         this.program.setUniformf(i + this.dirLightsDirectionOffset, (this.directionalLights[b]).direction.x, (this.directionalLights[b]).direction.y, (this.directionalLights[b]).direction.z);
/*     */         
/* 878 */         if (this.dirLightsSize > 0) {
/*     */           continue;
/*     */         }
/*     */       }  
/* 882 */     if (this.pointLightsLoc >= 0)
/* 883 */       for (byte b = 0; b < this.pointLights.length; b++) {
/* 884 */         if (array2 == null || b >= array2.size)
/* 885 */         { if (!this.lightsSet || (this.pointLights[b]).intensity != 0.0F)
/* 886 */           { (this.pointLights[b]).intensity = 0.0F; } else { continue; }  }
/* 887 */         else if (!this.lightsSet || !this.pointLights[b].equals((PointLight)array2.get(b)))
/*     */         
/*     */         { 
/* 890 */           this.pointLights[b].set((PointLight)array2.get(b)); }
/*     */         else { continue; }
/* 892 */          int i = this.pointLightsLoc + b * this.pointLightsSize;
/* 893 */         this.program.setUniformf(i + this.pointLightsColorOffset, (this.pointLights[b]).color.r * (this.pointLights[b]).intensity, (this.pointLights[b]).color.g * (this.pointLights[b]).intensity, (this.pointLights[b]).color.b * (this.pointLights[b]).intensity);
/*     */         
/* 895 */         this.program.setUniformf(i + this.pointLightsPositionOffset, (this.pointLights[b]).position.x, (this.pointLights[b]).position.y, (this.pointLights[b]).position.z);
/*     */         
/* 897 */         if (this.pointLightsIntensityOffset >= 0) this.program.setUniformf(i + this.pointLightsIntensityOffset, (this.pointLights[b]).intensity); 
/* 898 */         if (this.pointLightsSize > 0) {
/*     */           continue;
/*     */         }
/*     */       }  
/* 902 */     if (this.spotLightsLoc >= 0)
/* 903 */       for (byte b = 0; b < this.spotLights.length; b++) {
/* 904 */         if (array3 == null || b >= array3.size)
/* 905 */         { if (!this.lightsSet || (this.spotLights[b]).intensity != 0.0F)
/* 906 */           { (this.spotLights[b]).intensity = 0.0F; } else { continue; }  }
/* 907 */         else if (!this.lightsSet || !this.spotLights[b].equals((SpotLight)array3.get(b)))
/*     */         
/*     */         { 
/* 910 */           this.spotLights[b].set((SpotLight)array3.get(b)); }
/*     */         else { continue; }
/* 912 */          int i = this.spotLightsLoc + b * this.spotLightsSize;
/* 913 */         this.program.setUniformf(i + this.spotLightsColorOffset, (this.spotLights[b]).color.r * (this.spotLights[b]).intensity, (this.spotLights[b]).color.g * (this.spotLights[b]).intensity, (this.spotLights[b]).color.b * (this.spotLights[b]).intensity);
/*     */         
/* 915 */         this.program.setUniformf(i + this.spotLightsPositionOffset, (this.spotLights[b]).position);
/* 916 */         this.program.setUniformf(i + this.spotLightsDirectionOffset, (this.spotLights[b]).direction);
/* 917 */         this.program.setUniformf(i + this.spotLightsCutoffAngleOffset, (this.spotLights[b]).cutoffAngle);
/* 918 */         this.program.setUniformf(i + this.spotLightsExponentOffset, (this.spotLights[b]).exponent);
/* 919 */         if (this.spotLightsIntensityOffset >= 0) this.program.setUniformf(i + this.spotLightsIntensityOffset, (this.spotLights[b]).intensity); 
/* 920 */         if (this.spotLightsSize > 0) {
/*     */           continue;
/*     */         }
/*     */       }  
/* 924 */     if (paramAttributes.has(ColorAttribute.Fog)) {
/* 925 */       set(this.u_fogColor, ((ColorAttribute)paramAttributes.get(ColorAttribute.Fog)).color);
/*     */     }
/*     */     
/* 928 */     if (environment != null && environment.shadowMap != null) {
/* 929 */       set(this.u_shadowMapProjViewTrans, environment.shadowMap.getProjViewTrans());
/* 930 */       set(this.u_shadowTexture, environment.shadowMap.getDepthMap());
/* 931 */       set(this.u_shadowPCFOffset, 1.0F / 2.0F * (environment.shadowMap.getDepthMap()).texture.getWidth());
/*     */     } 
/*     */     
/* 934 */     this.lightsSet = true; } public void end() { super.end(); }
/*     */   protected void bindMaterial(Attributes paramAttributes) { int i = (this.config.defaultCullFace == -1) ? defaultCullFace : this.config.defaultCullFace; int j = (this.config.defaultDepthFunc == -1) ? defaultDepthFunc : this.config.defaultDepthFunc; float f1 = 0.0F; float f2 = 1.0F; boolean bool = true; for (Iterator<Attribute> iterator = paramAttributes.iterator(); iterator.hasNext(); ) { Attribute attribute; long l; if (BlendingAttribute.is(l = (attribute = iterator.next()).type)) { this.context.setBlending(true, ((BlendingAttribute)attribute).sourceFunction, ((BlendingAttribute)attribute).destFunction); set(this.u_opacity, ((BlendingAttribute)attribute).opacity); continue; }  if ((l & IntAttribute.CullFace) == IntAttribute.CullFace) { i = ((IntAttribute)attribute).value; continue; }  if ((l & FloatAttribute.AlphaTest) == FloatAttribute.AlphaTest) { set(this.u_alphaTest, ((FloatAttribute)attribute).value); continue; }  if ((l & DepthTestAttribute.Type) == DepthTestAttribute.Type) { DepthTestAttribute depthTestAttribute; j = (depthTestAttribute = (DepthTestAttribute)attribute).depthFunc; f1 = depthTestAttribute.depthRangeNear; f2 = depthTestAttribute.depthRangeFar; bool = depthTestAttribute.depthMask; continue; }
/*     */        if (!this.config.ignoreUnimplemented)
/*     */         throw new GdxRuntimeException("Unknown material attribute: " + attribute.toString());  }
/*     */      this.context.setCullFace(i); this.context.setDepthTest(j, f1, f2); this.context.setDepthMask(bool); }
/* 939 */   public void dispose() { this.program.dispose();
/* 940 */     super.dispose(); }
/*     */ 
/*     */   
/*     */   public int getDefaultCullFace() {
/* 944 */     return (this.config.defaultCullFace == -1) ? defaultCullFace : this.config.defaultCullFace;
/*     */   }
/*     */   
/*     */   public void setDefaultCullFace(int paramInt) {
/* 948 */     this.config.defaultCullFace = paramInt;
/*     */   }
/*     */   
/*     */   public int getDefaultDepthFunc() {
/* 952 */     return (this.config.defaultDepthFunc == -1) ? defaultDepthFunc : this.config.defaultDepthFunc;
/*     */   }
/*     */   
/*     */   public void setDefaultDepthFunc(int paramInt) {
/* 956 */     this.config.defaultDepthFunc = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\shaders\DefaultShader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */