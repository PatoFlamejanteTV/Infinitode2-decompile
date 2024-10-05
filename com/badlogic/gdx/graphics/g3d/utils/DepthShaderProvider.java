/*    */ package com.badlogic.gdx.graphics.g3d.utils;
/*    */ 
/*    */ import com.badlogic.gdx.files.FileHandle;
/*    */ import com.badlogic.gdx.graphics.g3d.Renderable;
/*    */ import com.badlogic.gdx.graphics.g3d.Shader;
/*    */ import com.badlogic.gdx.graphics.g3d.shaders.DepthShader;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DepthShaderProvider
/*    */   extends BaseShaderProvider
/*    */ {
/*    */   public final DepthShader.Config config;
/*    */   
/*    */   public DepthShaderProvider(DepthShader.Config paramConfig) {
/* 28 */     this.config = (paramConfig == null) ? new DepthShader.Config() : paramConfig;
/*    */   }
/*    */   
/*    */   public DepthShaderProvider(String paramString1, String paramString2) {
/* 32 */     this(new DepthShader.Config(paramString1, paramString2));
/*    */   }
/*    */   
/*    */   public DepthShaderProvider(FileHandle paramFileHandle1, FileHandle paramFileHandle2) {
/* 36 */     this(paramFileHandle1.readString(), paramFileHandle2.readString());
/*    */   }
/*    */   
/*    */   public DepthShaderProvider() {
/* 40 */     this(null);
/*    */   }
/*    */ 
/*    */   
/*    */   protected Shader createShader(Renderable paramRenderable) {
/* 45 */     return (Shader)new DepthShader(paramRenderable, this.config);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\DepthShaderProvider.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */