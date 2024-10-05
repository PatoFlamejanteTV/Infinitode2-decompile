/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.Sprite;
/*     */ import com.badlogic.gdx.graphics.g2d.SpriteCache;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ 
/*     */ public final class TextureRegionConfig {
/*     */   public TextureRegion textureRegion;
/*     */   @NAGS
/*     */   private TextureRegionDrawable a;
/*     */   public float x;
/*     */   public float y;
/*  22 */   public Color color = Color.WHITE.cpy(); public float width;
/*     */   public float height;
/*  24 */   private static final Color b = new Color(); public float originX; public float originY;
/*  25 */   private static final Color c = new Color();
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
/*     */   public static TextureRegionConfig fromJson(JsonValue paramJsonValue) {
/*  37 */     String str1 = paramJsonValue.getString("alias");
/*  38 */     float f1 = paramJsonValue.getFloat("x", 0.0F);
/*  39 */     float f2 = paramJsonValue.getFloat("y", 0.0F);
/*  40 */     float f3 = paramJsonValue.getFloat("w", 1.0F);
/*  41 */     float f4 = paramJsonValue.getFloat("h", 1.0F);
/*  42 */     float f5 = paramJsonValue.getFloat("ox", 0.5F);
/*  43 */     float f6 = paramJsonValue.getFloat("oy", 0.5F);
/*     */     
/*     */     float f7;
/*  46 */     if ((f7 = paramJsonValue.getFloat("rs", 0.0F)) != 0.0F) {
/*  47 */       f7 = 1.0F / f7;
/*  48 */       f1 *= f7;
/*  49 */       f2 *= f7;
/*  50 */       f3 *= f7;
/*  51 */       f4 *= f7;
/*  52 */       f5 *= f7;
/*  53 */       f6 *= f7;
/*     */     } 
/*     */     
/*  56 */     String str2 = paramJsonValue.getString("c", null);
/*  57 */     Color color = Color.WHITE;
/*  58 */     if (str2 != null) {
/*  59 */       color = Color.valueOf(str2);
/*     */     }
/*     */     
/*     */     TextureRegionConfig textureRegionConfig;
/*  63 */     (textureRegionConfig = new TextureRegionConfig((TextureRegion)Game.i.assetManager.getTextureRegion(str1))).color.set(color);
/*     */     
/*  65 */     textureRegionConfig.x = f1;
/*  66 */     textureRegionConfig.y = f2;
/*  67 */     textureRegionConfig.originX = f5;
/*  68 */     textureRegionConfig.originY = f6;
/*  69 */     textureRegionConfig.width = f3;
/*  70 */     textureRegionConfig.height = f4;
/*     */     
/*  72 */     return textureRegionConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextureRegionConfig(TextureRegionConfig paramTextureRegionConfig) {
/*  79 */     this.textureRegion = paramTextureRegionConfig.textureRegion;
/*  80 */     this.x = paramTextureRegionConfig.x;
/*  81 */     this.y = paramTextureRegionConfig.y;
/*  82 */     this.width = paramTextureRegionConfig.width;
/*  83 */     this.height = paramTextureRegionConfig.height;
/*  84 */     this.originX = paramTextureRegionConfig.originX;
/*  85 */     this.originY = paramTextureRegionConfig.originY;
/*  86 */     this.color.set(paramTextureRegionConfig.color);
/*     */   }
/*     */   
/*     */   public TextureRegionConfig(TextureRegion paramTextureRegion) {
/*  90 */     this.textureRegion = paramTextureRegion;
/*  91 */     this.x = 0.0F;
/*  92 */     this.y = 0.0F;
/*  93 */     this.width = 1.0F;
/*  94 */     this.height = 1.0F;
/*  95 */     this.originX = 0.5F;
/*  96 */     this.originY = 0.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextureRegionConfig(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 104 */     this.textureRegion = paramTextureRegion;
/* 105 */     this.x = paramFloat1 / paramFloat3;
/* 106 */     this.y = paramFloat2 / paramFloat3;
/* 107 */     this.width = paramTextureRegion.getRegionWidth() / paramFloat3;
/* 108 */     this.height = paramTextureRegion.getRegionHeight() / paramFloat3;
/* 109 */     this.originX = this.width * 0.5F;
/* 110 */     this.originY = this.height * 0.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextureRegionConfig(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 117 */     this.textureRegion = paramTextureRegion;
/* 118 */     this.x = paramFloat1;
/* 119 */     this.y = paramFloat2;
/* 120 */     this.width = paramFloat5;
/* 121 */     this.height = paramFloat6;
/* 122 */     this.originX = paramFloat3;
/* 123 */     this.originY = paramFloat4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextureRegionConfig(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) {
/* 130 */     this.textureRegion = paramTextureRegion;
/* 131 */     float f = 1.0F / paramFloat7;
/* 132 */     this.x = paramFloat1 * f;
/* 133 */     this.y = paramFloat2 * f;
/* 134 */     this.width = paramFloat5 * f;
/* 135 */     this.height = paramFloat6 * f;
/* 136 */     this.originX = paramFloat3 * f;
/* 137 */     this.originY = paramFloat4 * f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextureRegionConfig(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Color paramColor) {
/* 144 */     this(paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
/* 145 */     this.color.set(paramColor);
/*     */   }
/*     */   
/*     */   public TextureRegionConfig(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, Color paramColor) {
/* 149 */     this(paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7);
/* 150 */     this.color.set(paramColor);
/*     */   }
/*     */   
/*     */   public static Quad toQuad(Array<TextureRegionConfig> paramArray) {
/* 154 */     float f1 = 0.0F;
/* 155 */     float f2 = 0.0F;
/* 156 */     for (byte b = 0; b < paramArray.size; b++) {
/* 157 */       TextureRegionConfig textureRegionConfig = (TextureRegionConfig)paramArray.get(b);
/* 158 */       f1 = Math.max(f1, textureRegionConfig.x + textureRegionConfig.width);
/* 159 */       f2 = Math.max(f2, textureRegionConfig.y + textureRegionConfig.height);
/*     */     } 
/*     */     
/* 162 */     return toQuadWithSize(paramArray, f1, f2);
/*     */   }
/*     */   
/*     */   public static Quad toQuadWithSize(Array<TextureRegionConfig> paramArray, float paramFloat1, float paramFloat2) {
/* 166 */     Quad quad = new Quad(paramFloat1, paramFloat2);
/* 167 */     for (byte b = 0; b < paramArray.size; b++) {
/* 168 */       TextureRegionConfig textureRegionConfig = (TextureRegionConfig)paramArray.get(b);
/* 169 */       QuadRegion quadRegion = new QuadRegion((ResourcePack.AtlasTextureRegion)textureRegionConfig.textureRegion, textureRegionConfig.x * paramFloat1, textureRegionConfig.y * paramFloat2, textureRegionConfig.width * paramFloat1, textureRegionConfig.height * paramFloat2, textureRegionConfig.color);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 177 */       quad.addRegion(quadRegion);
/*     */     } 
/* 179 */     quad.setPivot(paramFloat1 * 0.5F, paramFloat2 * 0.5F);
/* 180 */     return quad;
/*     */   }
/*     */   
/*     */   public final Sprite createSprite(float paramFloat) {
/*     */     Sprite sprite;
/* 185 */     (sprite = new Sprite(this.textureRegion)).setSize(paramFloat * this.width, paramFloat * this.height);
/*     */     
/* 187 */     return sprite;
/*     */   }
/*     */   
/*     */   public final Image createImage(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 191 */     if (this.a == null) {
/* 192 */       this.a = new TextureRegionDrawable(this.textureRegion);
/*     */     }
/*     */     
/*     */     Image image;
/* 196 */     (image = new Image((Drawable)this.a)).setPosition(paramFloat1 + this.x * paramFloat3, paramFloat2 + this.y * paramFloat3);
/* 197 */     image.setSize(this.width * paramFloat3, this.height * paramFloat3);
/* 198 */     image.setColor(this.color);
/*     */     
/* 200 */     return image;
/*     */   }
/*     */   
/*     */   public final void drawCache(SpriteCache paramSpriteCache, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 204 */     paramSpriteCache.add(this.textureRegion, paramFloat1 + this.x * paramFloat3, paramFloat2 + this.y * paramFloat3, this.width * paramFloat3, this.height * paramFloat3);
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/* 209 */     c.set(paramBatch.getColor());
/* 210 */     b.set(paramBatch.getColor());
/* 211 */     b.mul(this.color);
/* 212 */     paramBatch.setColor(b);
/* 213 */     if (paramFloat5 == 0.0F && paramFloat4 == 1.0F) {
/* 214 */       paramBatch.draw(this.textureRegion, paramFloat1 + this.x * paramFloat3, paramFloat2 + this.y * paramFloat3, this.width * paramFloat3, this.height * paramFloat3);
/*     */     } else {
/* 216 */       paramBatch.draw(this.textureRegion, paramFloat1 + this.x * paramFloat3, paramFloat2 + this.y * paramFloat3, this.originX * paramFloat3, this.originY * paramFloat3, this.width * paramFloat3, this.height * paramFloat3, paramFloat4, paramFloat4, paramFloat5);
/*     */     } 
/* 218 */     paramBatch.setColor(c);
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 223 */     drawBatch(paramBatch, paramFloat1, paramFloat2, paramFloat3, 1.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public static void drawCache(Array<TextureRegionConfig> paramArray, SpriteCache paramSpriteCache, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 227 */     for (byte b = 0; b < paramArray.size; b++) {
/* 228 */       ((TextureRegionConfig[])paramArray.items)[b].drawCache(paramSpriteCache, paramFloat1, paramFloat2, paramFloat3);
/*     */     }
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static void drawBatch(Array<TextureRegionConfig> paramArray, Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 234 */     for (byte b = 0; b < paramArray.size; b++) {
/* 235 */       ((TextureRegionConfig[])paramArray.items)[b].drawBatch(paramBatch, paramFloat1, paramFloat2, paramFloat3);
/*     */     }
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static void drawBatch(Array<TextureRegionConfig> paramArray, Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/* 241 */     for (byte b = 0; b < paramArray.size; b++)
/* 242 */       ((TextureRegionConfig[])paramArray.items)[b].drawBatch(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\TextureRegionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */