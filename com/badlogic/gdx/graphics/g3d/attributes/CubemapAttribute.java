/*    */ package com.badlogic.gdx.graphics.g3d.attributes;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Cubemap;
/*    */ import com.badlogic.gdx.graphics.GLTexture;
/*    */ import com.badlogic.gdx.graphics.g3d.Attribute;
/*    */ import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
/*    */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*    */ public class CubemapAttribute
/*    */   extends Attribute
/*    */ {
/*    */   public static final String EnvironmentMapAlias = "environmentCubemap";
/*    */   public static final long EnvironmentMap;
/* 28 */   protected static long Mask = EnvironmentMap = register("environmentCubemap");
/*    */   
/*    */   public static final boolean is(long paramLong) {
/* 31 */     return ((paramLong & Mask) != 0L);
/*    */   }
/*    */   
/*    */   public final TextureDescriptor<Cubemap> textureDescription;
/*    */   
/*    */   public CubemapAttribute(long paramLong) {
/* 37 */     super(paramLong);
/* 38 */     if (!is(paramLong)) throw new GdxRuntimeException("Invalid type specified"); 
/* 39 */     this.textureDescription = new TextureDescriptor();
/*    */   }
/*    */   
/*    */   public <T extends Cubemap> CubemapAttribute(long paramLong, TextureDescriptor<T> paramTextureDescriptor) {
/* 43 */     this(paramLong);
/* 44 */     this.textureDescription.set(paramTextureDescriptor);
/*    */   }
/*    */   
/*    */   public CubemapAttribute(long paramLong, Cubemap paramCubemap) {
/* 48 */     this(paramLong);
/* 49 */     this.textureDescription.texture = (GLTexture)paramCubemap;
/*    */   }
/*    */   
/*    */   public CubemapAttribute(CubemapAttribute paramCubemapAttribute) {
/* 53 */     this(paramCubemapAttribute.type, paramCubemapAttribute.textureDescription);
/*    */   }
/*    */ 
/*    */   
/*    */   public Attribute copy() {
/* 58 */     return new CubemapAttribute(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 63 */     int i = super.hashCode();
/*    */     
/* 65 */     return i = i * 967 + this.textureDescription.hashCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareTo(Attribute paramAttribute) {
/* 70 */     if (this.type != paramAttribute.type) return (int)(this.type - paramAttribute.type); 
/* 71 */     return this.textureDescription.compareTo(((CubemapAttribute)paramAttribute).textureDescription);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\attributes\CubemapAttribute.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */