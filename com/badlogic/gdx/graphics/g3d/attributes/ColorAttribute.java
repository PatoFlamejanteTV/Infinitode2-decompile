/*     */ package com.badlogic.gdx.graphics.g3d.attributes;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g3d.Attribute;
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
/*     */ 
/*     */ 
/*     */ public class ColorAttribute
/*     */   extends Attribute
/*     */ {
/*     */   public static final String DiffuseAlias = "diffuseColor";
/*  25 */   public static final long Diffuse = register("diffuseColor");
/*     */   public static final String SpecularAlias = "specularColor";
/*  27 */   public static final long Specular = register("specularColor");
/*     */   public static final String AmbientAlias = "ambientColor";
/*  29 */   public static final long Ambient = register("ambientColor");
/*     */   public static final String EmissiveAlias = "emissiveColor";
/*  31 */   public static final long Emissive = register("emissiveColor");
/*     */   public static final String ReflectionAlias = "reflectionColor";
/*  33 */   public static final long Reflection = register("reflectionColor");
/*     */   public static final String AmbientLightAlias = "ambientLightColor";
/*  35 */   public static final long AmbientLight = register("ambientLightColor");
/*     */   public static final String FogAlias = "fogColor";
/*  37 */   public static final long Fog = register("fogColor");
/*     */   
/*  39 */   protected static long Mask = Ambient | Diffuse | Specular | Emissive | Reflection | AmbientLight | Fog;
/*     */   
/*     */   public static final boolean is(long paramLong) {
/*  42 */     return ((paramLong & Mask) != 0L);
/*     */   }
/*     */   
/*     */   public static final ColorAttribute createAmbient(Color paramColor) {
/*  46 */     return new ColorAttribute(Ambient, paramColor);
/*     */   }
/*     */   
/*     */   public static final ColorAttribute createAmbient(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  50 */     return new ColorAttribute(Ambient, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public static final ColorAttribute createDiffuse(Color paramColor) {
/*  54 */     return new ColorAttribute(Diffuse, paramColor);
/*     */   }
/*     */   
/*     */   public static final ColorAttribute createDiffuse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  58 */     return new ColorAttribute(Diffuse, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public static final ColorAttribute createSpecular(Color paramColor) {
/*  62 */     return new ColorAttribute(Specular, paramColor);
/*     */   }
/*     */   
/*     */   public static final ColorAttribute createSpecular(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  66 */     return new ColorAttribute(Specular, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public static final ColorAttribute createReflection(Color paramColor) {
/*  70 */     return new ColorAttribute(Reflection, paramColor);
/*     */   }
/*     */   
/*     */   public static final ColorAttribute createReflection(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  74 */     return new ColorAttribute(Reflection, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public static final ColorAttribute createEmissive(Color paramColor) {
/*  78 */     return new ColorAttribute(Emissive, paramColor);
/*     */   }
/*     */   
/*     */   public static final ColorAttribute createEmissive(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  82 */     return new ColorAttribute(Emissive, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public static final ColorAttribute createAmbientLight(Color paramColor) {
/*  86 */     return new ColorAttribute(AmbientLight, paramColor);
/*     */   }
/*     */   
/*     */   public static final ColorAttribute createAmbientLight(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  90 */     return new ColorAttribute(AmbientLight, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public static final ColorAttribute createFog(Color paramColor) {
/*  94 */     return new ColorAttribute(Fog, paramColor);
/*     */   }
/*     */   
/*     */   public static final ColorAttribute createFog(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  98 */     return new ColorAttribute(Fog, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/* 101 */   public final Color color = new Color();
/*     */   
/*     */   public ColorAttribute(long paramLong) {
/* 104 */     super(paramLong);
/* 105 */     if (!is(paramLong)) throw new GdxRuntimeException("Invalid type specified"); 
/*     */   }
/*     */   
/*     */   public ColorAttribute(long paramLong, Color paramColor) {
/* 109 */     this(paramLong);
/* 110 */     if (paramColor != null) this.color.set(paramColor); 
/*     */   }
/*     */   
/*     */   public ColorAttribute(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 114 */     this(paramLong);
/* 115 */     this.color.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public ColorAttribute(ColorAttribute paramColorAttribute) {
/* 119 */     this(paramColorAttribute.type, paramColorAttribute.color);
/*     */   }
/*     */ 
/*     */   
/*     */   public Attribute copy() {
/* 124 */     return new ColorAttribute(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 129 */     int i = super.hashCode();
/*     */     
/* 131 */     return i = i * 953 + this.color.toIntBits();
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(Attribute paramAttribute) {
/* 136 */     if (this.type != paramAttribute.type) return (int)(this.type - paramAttribute.type); 
/* 137 */     return ((ColorAttribute)paramAttribute).color.toIntBits() - this.color.toIntBits();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\attributes\ColorAttribute.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */