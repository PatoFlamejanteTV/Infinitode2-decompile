/*     */ package com.badlogic.gdx.graphics.g3d.attributes;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.GLTexture;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.graphics.g3d.Attribute;
/*     */ import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.NumberUtils;
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
/*     */ public class TextureAttribute
/*     */   extends Attribute
/*     */ {
/*     */   public static final String DiffuseAlias = "diffuseTexture";
/*  29 */   public static final long Diffuse = register("diffuseTexture");
/*     */   public static final String SpecularAlias = "specularTexture";
/*  31 */   public static final long Specular = register("specularTexture");
/*     */   public static final String BumpAlias = "bumpTexture";
/*  33 */   public static final long Bump = register("bumpTexture");
/*     */   public static final String NormalAlias = "normalTexture";
/*  35 */   public static final long Normal = register("normalTexture");
/*     */   public static final String AmbientAlias = "ambientTexture";
/*  37 */   public static final long Ambient = register("ambientTexture");
/*     */   public static final String EmissiveAlias = "emissiveTexture";
/*  39 */   public static final long Emissive = register("emissiveTexture");
/*     */   public static final String ReflectionAlias = "reflectionTexture";
/*  41 */   public static final long Reflection = register("reflectionTexture");
/*     */   
/*  43 */   protected static long Mask = Diffuse | Specular | Bump | Normal | Ambient | Emissive | Reflection;
/*     */   
/*     */   public static final boolean is(long paramLong) {
/*  46 */     return ((paramLong & Mask) != 0L);
/*     */   }
/*     */   public final TextureDescriptor<Texture> textureDescription;
/*     */   public static TextureAttribute createDiffuse(Texture paramTexture) {
/*  50 */     return new TextureAttribute(Diffuse, paramTexture);
/*     */   }
/*     */   
/*     */   public static TextureAttribute createDiffuse(TextureRegion paramTextureRegion) {
/*  54 */     return new TextureAttribute(Diffuse, paramTextureRegion);
/*     */   }
/*     */   
/*     */   public static TextureAttribute createSpecular(Texture paramTexture) {
/*  58 */     return new TextureAttribute(Specular, paramTexture);
/*     */   }
/*     */   
/*     */   public static TextureAttribute createSpecular(TextureRegion paramTextureRegion) {
/*  62 */     return new TextureAttribute(Specular, paramTextureRegion);
/*     */   }
/*     */   
/*     */   public static TextureAttribute createNormal(Texture paramTexture) {
/*  66 */     return new TextureAttribute(Normal, paramTexture);
/*     */   }
/*     */   
/*     */   public static TextureAttribute createNormal(TextureRegion paramTextureRegion) {
/*  70 */     return new TextureAttribute(Normal, paramTextureRegion);
/*     */   }
/*     */   
/*     */   public static TextureAttribute createBump(Texture paramTexture) {
/*  74 */     return new TextureAttribute(Bump, paramTexture);
/*     */   }
/*     */   
/*     */   public static TextureAttribute createBump(TextureRegion paramTextureRegion) {
/*  78 */     return new TextureAttribute(Bump, paramTextureRegion);
/*     */   }
/*     */   
/*     */   public static TextureAttribute createAmbient(Texture paramTexture) {
/*  82 */     return new TextureAttribute(Ambient, paramTexture);
/*     */   }
/*     */   
/*     */   public static TextureAttribute createAmbient(TextureRegion paramTextureRegion) {
/*  86 */     return new TextureAttribute(Ambient, paramTextureRegion);
/*     */   }
/*     */   
/*     */   public static TextureAttribute createEmissive(Texture paramTexture) {
/*  90 */     return new TextureAttribute(Emissive, paramTexture);
/*     */   }
/*     */   
/*     */   public static TextureAttribute createEmissive(TextureRegion paramTextureRegion) {
/*  94 */     return new TextureAttribute(Emissive, paramTextureRegion);
/*     */   }
/*     */   
/*     */   public static TextureAttribute createReflection(Texture paramTexture) {
/*  98 */     return new TextureAttribute(Reflection, paramTexture);
/*     */   }
/*     */   
/*     */   public static TextureAttribute createReflection(TextureRegion paramTextureRegion) {
/* 102 */     return new TextureAttribute(Reflection, paramTextureRegion);
/*     */   }
/*     */ 
/*     */   
/* 106 */   public float offsetU = 0.0F;
/* 107 */   public float offsetV = 0.0F;
/* 108 */   public float scaleU = 1.0F;
/* 109 */   public float scaleV = 1.0F;
/*     */ 
/*     */ 
/*     */   
/* 113 */   public int uvIndex = 0;
/*     */   
/*     */   public TextureAttribute(long paramLong) {
/* 116 */     super(paramLong);
/* 117 */     if (!is(paramLong)) throw new GdxRuntimeException("Invalid type specified"); 
/* 118 */     this.textureDescription = new TextureDescriptor();
/*     */   }
/*     */   
/*     */   public <T extends Texture> TextureAttribute(long paramLong, TextureDescriptor<T> paramTextureDescriptor) {
/* 122 */     this(paramLong);
/* 123 */     this.textureDescription.set(paramTextureDescriptor);
/*     */   }
/*     */ 
/*     */   
/*     */   public <T extends Texture> TextureAttribute(long paramLong, TextureDescriptor<T> paramTextureDescriptor, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt) {
/* 128 */     this(paramLong, paramTextureDescriptor);
/* 129 */     this.offsetU = paramFloat1;
/* 130 */     this.offsetV = paramFloat2;
/* 131 */     this.scaleU = paramFloat3;
/* 132 */     this.scaleV = paramFloat4;
/* 133 */     this.uvIndex = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public <T extends Texture> TextureAttribute(long paramLong, TextureDescriptor<T> paramTextureDescriptor, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 138 */     this(paramLong, paramTextureDescriptor, paramFloat1, paramFloat2, paramFloat3, paramFloat4, 0);
/*     */   }
/*     */   
/*     */   public TextureAttribute(long paramLong, Texture paramTexture) {
/* 142 */     this(paramLong);
/* 143 */     this.textureDescription.texture = (GLTexture)paramTexture;
/*     */   }
/*     */   
/*     */   public TextureAttribute(long paramLong, TextureRegion paramTextureRegion) {
/* 147 */     this(paramLong);
/* 148 */     set(paramTextureRegion);
/*     */   }
/*     */   
/*     */   public TextureAttribute(TextureAttribute paramTextureAttribute) {
/* 152 */     this(paramTextureAttribute.type, paramTextureAttribute.textureDescription, paramTextureAttribute.offsetU, paramTextureAttribute.offsetV, paramTextureAttribute.scaleU, paramTextureAttribute.scaleV, paramTextureAttribute.uvIndex);
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(TextureRegion paramTextureRegion) {
/* 157 */     this.textureDescription.texture = (GLTexture)paramTextureRegion.getTexture();
/* 158 */     this.offsetU = paramTextureRegion.getU();
/* 159 */     this.offsetV = paramTextureRegion.getV();
/* 160 */     this.scaleU = paramTextureRegion.getU2() - this.offsetU;
/* 161 */     this.scaleV = paramTextureRegion.getV2() - this.offsetV;
/*     */   }
/*     */ 
/*     */   
/*     */   public Attribute copy() {
/* 166 */     return new TextureAttribute(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 171 */     int i = super.hashCode();
/* 172 */     i = i * 991 + this.textureDescription.hashCode();
/* 173 */     i = i * 991 + NumberUtils.floatToRawIntBits(this.offsetU);
/* 174 */     i = i * 991 + NumberUtils.floatToRawIntBits(this.offsetV);
/* 175 */     i = i * 991 + NumberUtils.floatToRawIntBits(this.scaleU);
/* 176 */     i = i * 991 + NumberUtils.floatToRawIntBits(this.scaleV);
/*     */     
/* 178 */     return i = i * 991 + this.uvIndex;
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(Attribute paramAttribute) {
/* 183 */     if (this.type != paramAttribute.type) return (this.type < paramAttribute.type) ? -1 : 1; 
/* 184 */     paramAttribute = paramAttribute;
/*     */     int i;
/* 186 */     if ((i = this.textureDescription.compareTo(((TextureAttribute)paramAttribute).textureDescription)) != 0) return i; 
/* 187 */     if (this.uvIndex != ((TextureAttribute)paramAttribute).uvIndex) return this.uvIndex - ((TextureAttribute)paramAttribute).uvIndex; 
/* 188 */     if (!MathUtils.isEqual(this.scaleU, ((TextureAttribute)paramAttribute).scaleU)) return (this.scaleU > ((TextureAttribute)paramAttribute).scaleU) ? 1 : -1; 
/* 189 */     if (!MathUtils.isEqual(this.scaleV, ((TextureAttribute)paramAttribute).scaleV)) return (this.scaleV > ((TextureAttribute)paramAttribute).scaleV) ? 1 : -1; 
/* 190 */     if (!MathUtils.isEqual(this.offsetU, ((TextureAttribute)paramAttribute).offsetU)) return (this.offsetU > ((TextureAttribute)paramAttribute).offsetU) ? 1 : -1; 
/* 191 */     if (!MathUtils.isEqual(this.offsetV, ((TextureAttribute)paramAttribute).offsetV)) return (this.offsetV > ((TextureAttribute)paramAttribute).offsetV) ? 1 : -1; 
/* 192 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\attributes\TextureAttribute.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */