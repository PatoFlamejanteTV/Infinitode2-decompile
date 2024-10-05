/*     */ package com.badlogic.gdx.graphics.g3d.shaders;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Camera;
/*     */ import com.badlogic.gdx.graphics.g3d.Attribute;
/*     */ import com.badlogic.gdx.graphics.g3d.Attributes;
/*     */ import com.badlogic.gdx.graphics.g3d.Renderable;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
/*     */ import com.badlogic.gdx.graphics.glutils.ShaderProgram;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DepthShader
/*     */   extends DefaultShader
/*     */ {
/*     */   public static class Config
/*     */     extends DefaultShader.Config
/*     */   {
/*     */     public boolean depthBufferOnly = false;
/*  34 */     public float defaultAlphaTest = 0.5F;
/*     */ 
/*     */     
/*     */     public Config() {
/*  38 */       this.defaultCullFace = 1028;
/*     */     }
/*     */     
/*     */     public Config(String param1String1, String param1String2) {
/*  42 */       super(param1String1, param1String2);
/*     */     }
/*     */   }
/*     */   
/*  46 */   private static String defaultVertexShader = null;
/*     */   
/*     */   public static final String getDefaultVertexShader() {
/*  49 */     if (defaultVertexShader == null)
/*  50 */       defaultVertexShader = Gdx.files.classpath("com/badlogic/gdx/graphics/g3d/shaders/depth.vertex.glsl").readString(); 
/*  51 */     return defaultVertexShader;
/*     */   }
/*     */   
/*  54 */   private static String defaultFragmentShader = null; public final int numBones;
/*     */   
/*     */   public static final String getDefaultFragmentShader() {
/*  57 */     if (defaultFragmentShader == null)
/*  58 */       defaultFragmentShader = Gdx.files.classpath("com/badlogic/gdx/graphics/g3d/shaders/depth.fragment.glsl").readString(); 
/*  59 */     return defaultFragmentShader;
/*     */   }
/*     */   private final FloatAttribute alphaTestAttribute;
/*     */   public static String createPrefix(Renderable paramRenderable, Config paramConfig) {
/*  63 */     String str = DefaultShader.createPrefix(paramRenderable, paramConfig);
/*  64 */     if (!paramConfig.depthBufferOnly) str = str + "#define PackedDepthFlag\n"; 
/*  65 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DepthShader(Renderable paramRenderable) {
/*  72 */     this(paramRenderable, new Config());
/*     */   }
/*     */   
/*     */   public DepthShader(Renderable paramRenderable, Config paramConfig) {
/*  76 */     this(paramRenderable, paramConfig, createPrefix(paramRenderable, paramConfig));
/*     */   }
/*     */   
/*     */   public DepthShader(Renderable paramRenderable, Config paramConfig, String paramString) {
/*  80 */     this(paramRenderable, paramConfig, paramString, (paramConfig.vertexShader != null) ? paramConfig.vertexShader : getDefaultVertexShader(), 
/*  81 */         (paramConfig.fragmentShader != null) ? paramConfig.fragmentShader : getDefaultFragmentShader());
/*     */   }
/*     */ 
/*     */   
/*     */   public DepthShader(Renderable paramRenderable, Config paramConfig, String paramString1, String paramString2, String paramString3) {
/*  86 */     this(paramRenderable, paramConfig, new ShaderProgram(paramString1 + paramString2, paramString1 + paramString3));
/*     */   }
/*     */   
/*     */   public DepthShader(Renderable paramRenderable, Config paramConfig, ShaderProgram paramShaderProgram) {
/*  90 */     super(paramRenderable, paramConfig, paramShaderProgram);
/*  91 */     combineAttributes(paramRenderable);
/*     */     
/*  93 */     if (paramRenderable.bones != null && paramRenderable.bones.length > paramConfig.numBones) {
/*  94 */       throw new GdxRuntimeException("too many bones: " + paramRenderable.bones.length + ", max configured: " + paramConfig.numBones);
/*     */     }
/*     */     
/*  97 */     this.numBones = (paramRenderable.bones == null) ? 0 : paramConfig.numBones;
/*     */     int i;
/*  99 */     if ((i = paramRenderable.meshPart.mesh.getVertexAttributes().getBoneWeights()) > paramConfig.numBoneWeights) {
/* 100 */       throw new GdxRuntimeException("too many bone weights: " + i + ", max configured: " + paramConfig.numBoneWeights);
/*     */     }
/* 102 */     this.alphaTestAttribute = new FloatAttribute(FloatAttribute.AlphaTest, paramConfig.defaultAlphaTest);
/*     */   }
/*     */ 
/*     */   
/*     */   public void begin(Camera paramCamera, RenderContext paramRenderContext) {
/* 107 */     super.begin(paramCamera, paramRenderContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void end() {
/* 114 */     super.end();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canRender(Renderable paramRenderable) {
/* 120 */     if (paramRenderable.bones != null) {
/* 121 */       if (paramRenderable.bones.length > this.config.numBones) return false; 
/* 122 */       if (paramRenderable.meshPart.mesh.getVertexAttributes().getBoneWeights() > this.config.numBoneWeights) return false; 
/*     */     } 
/*     */     Attributes attributes;
/* 125 */     if ((attributes = combineAttributes(paramRenderable)).has(BlendingAttribute.Type)) {
/* 126 */       if ((this.attributesMask & BlendingAttribute.Type) != BlendingAttribute.Type) return false; 
/* 127 */       if (attributes
/* 128 */         .has(TextureAttribute.Diffuse) != (((this.attributesMask & TextureAttribute.Diffuse) == TextureAttribute.Diffuse)))
/* 129 */         return false; 
/*     */     } 
/* 131 */     return (((paramRenderable.bones != null) ? true : false) == ((this.numBones > 0) ? true : false));
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Renderable paramRenderable, Attributes paramAttributes) {
/* 136 */     if (paramAttributes.has(BlendingAttribute.Type)) {
/* 137 */       BlendingAttribute blendingAttribute = (BlendingAttribute)paramAttributes.get(BlendingAttribute.Type);
/* 138 */       paramAttributes.remove(BlendingAttribute.Type);
/*     */       boolean bool;
/* 140 */       if (!(bool = paramAttributes.has(FloatAttribute.AlphaTest))) paramAttributes.set((Attribute)this.alphaTestAttribute); 
/* 141 */       if (blendingAttribute.opacity >= ((FloatAttribute)paramAttributes.get(FloatAttribute.AlphaTest)).value)
/* 142 */         super.render(paramRenderable, paramAttributes); 
/* 143 */       if (!bool) paramAttributes.remove(FloatAttribute.AlphaTest); 
/* 144 */       paramAttributes.set((Attribute)blendingAttribute); return;
/*     */     } 
/* 146 */     super.render(paramRenderable, paramAttributes);
/*     */   }
/*     */   
/* 149 */   private static final Attributes tmpAttributes = new Attributes();
/*     */ 
/*     */   
/*     */   private static final Attributes combineAttributes(Renderable paramRenderable) {
/* 153 */     tmpAttributes.clear();
/* 154 */     if (paramRenderable.environment != null) tmpAttributes.set((Iterable)paramRenderable.environment); 
/* 155 */     if (paramRenderable.material != null) tmpAttributes.set((Iterable)paramRenderable.material); 
/* 156 */     return tmpAttributes;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\shaders\DepthShader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */