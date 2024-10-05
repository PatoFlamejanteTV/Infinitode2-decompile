/*     */ package com.badlogic.gdx.graphics.g3d;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.DirectionalLightsAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.PointLightsAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.SpotLightsAttribute;
/*     */ import com.badlogic.gdx.graphics.g3d.environment.BaseLight;
/*     */ import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
/*     */ import com.badlogic.gdx.graphics.g3d.environment.PointLight;
/*     */ import com.badlogic.gdx.graphics.g3d.environment.ShadowMap;
/*     */ import com.badlogic.gdx.graphics.g3d.environment.SpotLight;
/*     */ import com.badlogic.gdx.utils.Array;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Environment
/*     */   extends Attributes
/*     */ {
/*     */   public ShadowMap shadowMap;
/*     */   
/*     */   public Environment add(BaseLight... paramVarArgs) {
/*     */     int i;
/*     */     byte b;
/*  39 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { BaseLight baseLight = paramVarArgs[b];
/*  40 */       add(baseLight); b++; }
/*  41 */      return this;
/*     */   }
/*     */   
/*     */   public Environment add(Array<BaseLight> paramArray) {
/*  45 */     for (Array.ArrayIterator<BaseLight> arrayIterator = paramArray.iterator(); arrayIterator.hasNext(); ) { BaseLight baseLight = arrayIterator.next();
/*  46 */       add(baseLight); }
/*  47 */      return this;
/*     */   }
/*     */   
/*     */   public Environment add(BaseLight paramBaseLight) {
/*  51 */     if (paramBaseLight instanceof DirectionalLight) {
/*  52 */       add((DirectionalLight)paramBaseLight);
/*  53 */     } else if (paramBaseLight instanceof PointLight) {
/*  54 */       add((PointLight)paramBaseLight);
/*  55 */     } else if (paramBaseLight instanceof SpotLight) {
/*  56 */       add((SpotLight)paramBaseLight);
/*     */     } else {
/*  58 */       throw new GdxRuntimeException("Unknown light type");
/*  59 */     }  return this;
/*     */   }
/*     */   
/*     */   public Environment add(DirectionalLight paramDirectionalLight) {
/*     */     DirectionalLightsAttribute directionalLightsAttribute;
/*  64 */     if ((directionalLightsAttribute = (DirectionalLightsAttribute)get(DirectionalLightsAttribute.Type)) == null) set((Attribute)(directionalLightsAttribute = new DirectionalLightsAttribute())); 
/*  65 */     directionalLightsAttribute.lights.add(paramDirectionalLight);
/*  66 */     return this;
/*     */   }
/*     */   
/*     */   public Environment add(PointLight paramPointLight) {
/*     */     PointLightsAttribute pointLightsAttribute;
/*  71 */     if ((pointLightsAttribute = (PointLightsAttribute)get(PointLightsAttribute.Type)) == null) set((Attribute)(pointLightsAttribute = new PointLightsAttribute())); 
/*  72 */     pointLightsAttribute.lights.add(paramPointLight);
/*  73 */     return this;
/*     */   }
/*     */   
/*     */   public Environment add(SpotLight paramSpotLight) {
/*     */     SpotLightsAttribute spotLightsAttribute;
/*  78 */     if ((spotLightsAttribute = (SpotLightsAttribute)get(SpotLightsAttribute.Type)) == null) set((Attribute)(spotLightsAttribute = new SpotLightsAttribute())); 
/*  79 */     spotLightsAttribute.lights.add(paramSpotLight);
/*  80 */     return this;
/*     */   } public Environment remove(BaseLight... paramVarArgs) {
/*     */     int i;
/*     */     byte b;
/*  84 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { BaseLight baseLight = paramVarArgs[b];
/*  85 */       remove(baseLight); b++; }
/*  86 */      return this;
/*     */   }
/*     */   
/*     */   public Environment remove(Array<BaseLight> paramArray) {
/*  90 */     for (Array.ArrayIterator<BaseLight> arrayIterator = paramArray.iterator(); arrayIterator.hasNext(); ) { BaseLight baseLight = arrayIterator.next();
/*  91 */       remove(baseLight); }
/*  92 */      return this;
/*     */   }
/*     */   
/*     */   public Environment remove(BaseLight paramBaseLight) {
/*  96 */     if (paramBaseLight instanceof DirectionalLight) {
/*  97 */       remove((DirectionalLight)paramBaseLight);
/*  98 */     } else if (paramBaseLight instanceof PointLight) {
/*  99 */       remove((PointLight)paramBaseLight);
/* 100 */     } else if (paramBaseLight instanceof SpotLight) {
/* 101 */       remove((SpotLight)paramBaseLight);
/*     */     } else {
/* 103 */       throw new GdxRuntimeException("Unknown light type");
/* 104 */     }  return this;
/*     */   }
/*     */   
/*     */   public Environment remove(DirectionalLight paramDirectionalLight) {
/* 108 */     if (has(DirectionalLightsAttribute.Type)) {
/*     */       DirectionalLightsAttribute directionalLightsAttribute;
/* 110 */       (directionalLightsAttribute = (DirectionalLightsAttribute)get(DirectionalLightsAttribute.Type)).lights.removeValue(paramDirectionalLight, false);
/* 111 */       if (directionalLightsAttribute.lights.size == 0) remove(DirectionalLightsAttribute.Type); 
/*     */     } 
/* 113 */     return this;
/*     */   }
/*     */   
/*     */   public Environment remove(PointLight paramPointLight) {
/* 117 */     if (has(PointLightsAttribute.Type)) {
/*     */       PointLightsAttribute pointLightsAttribute;
/* 119 */       (pointLightsAttribute = (PointLightsAttribute)get(PointLightsAttribute.Type)).lights.removeValue(paramPointLight, false);
/* 120 */       if (pointLightsAttribute.lights.size == 0) remove(PointLightsAttribute.Type); 
/*     */     } 
/* 122 */     return this;
/*     */   }
/*     */   
/*     */   public Environment remove(SpotLight paramSpotLight) {
/* 126 */     if (has(SpotLightsAttribute.Type)) {
/*     */       SpotLightsAttribute spotLightsAttribute;
/* 128 */       (spotLightsAttribute = (SpotLightsAttribute)get(SpotLightsAttribute.Type)).lights.removeValue(paramSpotLight, false);
/* 129 */       if (spotLightsAttribute.lights.size == 0) remove(SpotLightsAttribute.Type); 
/*     */     } 
/* 131 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\Environment.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */