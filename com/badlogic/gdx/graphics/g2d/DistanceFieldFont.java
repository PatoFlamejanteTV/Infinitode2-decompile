/*     */ package com.badlogic.gdx.graphics.g2d;
/*     */ 
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.glutils.ShaderProgram;
/*     */ import com.badlogic.gdx.utils.Array;
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
/*     */ public class DistanceFieldFont
/*     */   extends BitmapFont
/*     */ {
/*     */   private float distanceFieldSmoothing;
/*     */   
/*     */   public DistanceFieldFont(BitmapFont.BitmapFontData paramBitmapFontData, Array<TextureRegion> paramArray, boolean paramBoolean) {
/*  40 */     super(paramBitmapFontData, paramArray, paramBoolean);
/*     */   }
/*     */   
/*     */   public DistanceFieldFont(BitmapFont.BitmapFontData paramBitmapFontData, TextureRegion paramTextureRegion, boolean paramBoolean) {
/*  44 */     super(paramBitmapFontData, paramTextureRegion, paramBoolean);
/*     */   }
/*     */   
/*     */   public DistanceFieldFont(FileHandle paramFileHandle, boolean paramBoolean) {
/*  48 */     super(paramFileHandle, paramBoolean);
/*     */   }
/*     */   
/*     */   public DistanceFieldFont(FileHandle paramFileHandle1, FileHandle paramFileHandle2, boolean paramBoolean1, boolean paramBoolean2) {
/*  52 */     super(paramFileHandle1, paramFileHandle2, paramBoolean1, paramBoolean2);
/*     */   }
/*     */   
/*     */   public DistanceFieldFont(FileHandle paramFileHandle1, FileHandle paramFileHandle2, boolean paramBoolean) {
/*  56 */     super(paramFileHandle1, paramFileHandle2, paramBoolean);
/*     */   }
/*     */   
/*     */   public DistanceFieldFont(FileHandle paramFileHandle, TextureRegion paramTextureRegion, boolean paramBoolean) {
/*  60 */     super(paramFileHandle, paramTextureRegion, paramBoolean);
/*     */   }
/*     */   
/*     */   public DistanceFieldFont(FileHandle paramFileHandle, TextureRegion paramTextureRegion) {
/*  64 */     super(paramFileHandle, paramTextureRegion);
/*     */   }
/*     */   
/*     */   public DistanceFieldFont(FileHandle paramFileHandle) {
/*  68 */     super(paramFileHandle);
/*     */   }
/*     */   
/*     */   protected void load(BitmapFont.BitmapFontData paramBitmapFontData) {
/*  72 */     super.load(paramBitmapFontData);
/*     */     
/*     */     Array<TextureRegion> array;
/*     */     
/*  76 */     for (Array.ArrayIterator<TextureRegion> arrayIterator = (array = getRegions()).iterator(); arrayIterator.hasNext();) {
/*  77 */       (textureRegion = arrayIterator.next()).getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
/*     */     }
/*     */   }
/*     */   
/*     */   public BitmapFontCache newFontCache() {
/*  82 */     return new DistanceFieldFontCache(this, this.integer);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getDistanceFieldSmoothing() {
/*  87 */     return this.distanceFieldSmoothing;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDistanceFieldSmoothing(float paramFloat) {
/*  93 */     this.distanceFieldSmoothing = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ShaderProgram createDistanceFieldShader() {
/*  99 */     String str1 = "attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projTrans;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n\tv_color = a_color;\n\tv_color.a = v_color.a * (255.0/254.0);\n\tv_texCoords = a_texCoord0;\n\tgl_Position =  u_projTrans * a_position;\n}\n";
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
/* 113 */     String str2 = "#ifdef GL_ES\n\tprecision mediump float;\n\tprecision mediump int;\n#endif\n\nuniform sampler2D u_texture;\nuniform float u_smoothing;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n\tif (u_smoothing > 0.0) {\n\t\tfloat smoothing = 0.25 / u_smoothing;\n\t\tfloat distance = texture2D(u_texture, v_texCoords).a;\n\t\tfloat alpha = smoothstep(0.5 - smoothing, 0.5 + smoothing, distance);\n\t\tgl_FragColor = vec4(v_color.rgb, alpha * v_color.a);\n\t} else {\n\t\tgl_FragColor = v_color * texture2D(u_texture, v_texCoords);\n\t}\n}\n";
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
/*     */     ShaderProgram shaderProgram;
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
/* 135 */     if (!(shaderProgram = new ShaderProgram(str1, str2)).isCompiled()) throw new IllegalArgumentException("Error compiling distance field shader: " + shaderProgram.getLog()); 
/* 136 */     return shaderProgram;
/*     */   }
/*     */ 
/*     */   
/*     */   private static class DistanceFieldFontCache
/*     */     extends BitmapFontCache
/*     */   {
/*     */     public DistanceFieldFontCache(DistanceFieldFont param1DistanceFieldFont) {
/* 144 */       super(param1DistanceFieldFont, param1DistanceFieldFont.usesIntegerPositions());
/*     */     }
/*     */     
/*     */     public DistanceFieldFontCache(DistanceFieldFont param1DistanceFieldFont, boolean param1Boolean) {
/* 148 */       super(param1DistanceFieldFont, param1Boolean);
/*     */     }
/*     */     
/*     */     private float getSmoothingFactor() {
/*     */       DistanceFieldFont distanceFieldFont;
/* 153 */       return (distanceFieldFont = (DistanceFieldFont)getFont()).getDistanceFieldSmoothing() * distanceFieldFont.getScaleX();
/*     */     }
/*     */     
/*     */     private void setSmoothingUniform(Batch param1Batch, float param1Float) {
/* 157 */       param1Batch.flush();
/* 158 */       param1Batch.getShader().setUniformf("u_smoothing", param1Float);
/*     */     }
/*     */ 
/*     */     
/*     */     public void draw(Batch param1Batch) {
/* 163 */       setSmoothingUniform(param1Batch, getSmoothingFactor());
/* 164 */       super.draw(param1Batch);
/* 165 */       setSmoothingUniform(param1Batch, 0.0F);
/*     */     }
/*     */ 
/*     */     
/*     */     public void draw(Batch param1Batch, int param1Int1, int param1Int2) {
/* 170 */       setSmoothingUniform(param1Batch, getSmoothingFactor());
/* 171 */       super.draw(param1Batch, param1Int1, param1Int2);
/* 172 */       setSmoothingUniform(param1Batch, 0.0F);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\DistanceFieldFont.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */