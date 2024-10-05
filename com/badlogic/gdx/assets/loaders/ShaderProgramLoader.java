/*    */ package com.badlogic.gdx.assets.loaders;
/*    */ 
/*    */ import com.badlogic.gdx.assets.AssetDescriptor;
/*    */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*    */ import com.badlogic.gdx.assets.AssetManager;
/*    */ import com.badlogic.gdx.files.FileHandle;
/*    */ import com.badlogic.gdx.graphics.glutils.ShaderProgram;
/*    */ import com.badlogic.gdx.utils.Array;
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
/*    */ public class ShaderProgramLoader
/*    */   extends AsynchronousAssetLoader<ShaderProgram, ShaderProgramLoader.ShaderProgramParameter>
/*    */ {
/* 38 */   private String vertexFileSuffix = ".vert";
/* 39 */   private String fragmentFileSuffix = ".frag";
/*    */   
/*    */   public ShaderProgramLoader(FileHandleResolver paramFileHandleResolver) {
/* 42 */     super(paramFileHandleResolver);
/*    */   }
/*    */   
/*    */   public ShaderProgramLoader(FileHandleResolver paramFileHandleResolver, String paramString1, String paramString2) {
/* 46 */     super(paramFileHandleResolver);
/* 47 */     this.vertexFileSuffix = paramString1;
/* 48 */     this.fragmentFileSuffix = paramString2;
/*    */   }
/*    */ 
/*    */   
/*    */   public Array<AssetDescriptor> getDependencies(String paramString, FileHandle paramFileHandle, ShaderProgramParameter paramShaderProgramParameter) {
/* 53 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, ShaderProgramParameter paramShaderProgramParameter) {}
/*    */ 
/*    */   
/*    */   public ShaderProgram loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, ShaderProgramParameter paramShaderProgramParameter) {
/* 62 */     String str2 = null, str3 = null;
/* 63 */     if (paramShaderProgramParameter != null) {
/* 64 */       if (paramShaderProgramParameter.vertexFile != null) str2 = paramShaderProgramParameter.vertexFile; 
/* 65 */       if (paramShaderProgramParameter.fragmentFile != null) str3 = paramShaderProgramParameter.fragmentFile; 
/*    */     } 
/* 67 */     if (str2 == null && paramString.endsWith(this.fragmentFileSuffix)) {
/* 68 */       str2 = paramString.substring(0, paramString.length() - this.fragmentFileSuffix.length()) + this.vertexFileSuffix;
/*    */     }
/* 70 */     if (str3 == null && paramString.endsWith(this.vertexFileSuffix)) {
/* 71 */       str3 = paramString.substring(0, paramString.length() - this.vertexFileSuffix.length()) + this.fragmentFileSuffix;
/*    */     }
/* 73 */     FileHandle fileHandle = (str2 == null) ? paramFileHandle : resolve(str2);
/* 74 */     paramFileHandle = (str3 == null) ? paramFileHandle : resolve(str3);
/* 75 */     str3 = fileHandle.readString();
/* 76 */     String str1 = fileHandle.equals(paramFileHandle) ? str3 : paramFileHandle.readString();
/* 77 */     if (paramShaderProgramParameter != null) {
/* 78 */       if (paramShaderProgramParameter.prependVertexCode != null) str3 = paramShaderProgramParameter.prependVertexCode + str3; 
/* 79 */       if (paramShaderProgramParameter.prependFragmentCode != null) str1 = paramShaderProgramParameter.prependFragmentCode + str1;
/*    */     
/*    */     } 
/* 82 */     ShaderProgram shaderProgram = new ShaderProgram(str3, str1);
/* 83 */     if ((paramShaderProgramParameter == null || paramShaderProgramParameter.logOnCompileFailure) && !shaderProgram.isCompiled()) {
/* 84 */       paramAssetManager.getLogger().error("ShaderProgram " + paramString + " failed to compile:\n" + shaderProgram.getLog());
/*    */     }
/*    */     
/* 87 */     return shaderProgram;
/*    */   }
/*    */   
/*    */   public static class ShaderProgramParameter extends AssetLoaderParameters<ShaderProgram> {
/*    */     public String vertexFile;
/*    */     public String fragmentFile;
/*    */     public boolean logOnCompileFailure = true;
/*    */     public String prependVertexCode;
/*    */     public String prependFragmentCode;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\assets\loaders\ShaderProgramLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */