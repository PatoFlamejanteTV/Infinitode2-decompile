/*    */ package com.badlogic.gdx.graphics.g3d.environment;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.math.Vector3;
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
/*    */ public class PointLight
/*    */   extends BaseLight<PointLight>
/*    */ {
/* 23 */   public final Vector3 position = new Vector3();
/*    */   public float intensity;
/*    */   
/*    */   public PointLight setPosition(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 27 */     this.position.set(paramFloat1, paramFloat2, paramFloat3);
/* 28 */     return this;
/*    */   }
/*    */   
/*    */   public PointLight setPosition(Vector3 paramVector3) {
/* 32 */     this.position.set(paramVector3);
/* 33 */     return this;
/*    */   }
/*    */   
/*    */   public PointLight setIntensity(float paramFloat) {
/* 37 */     this.intensity = paramFloat;
/* 38 */     return this;
/*    */   }
/*    */   
/*    */   public PointLight set(PointLight paramPointLight) {
/* 42 */     return set(paramPointLight.color, paramPointLight.position, paramPointLight.intensity);
/*    */   }
/*    */   
/*    */   public PointLight set(Color paramColor, Vector3 paramVector3, float paramFloat) {
/* 46 */     if (paramColor != null) this.color.set(paramColor); 
/* 47 */     if (paramVector3 != null) this.position.set(paramVector3); 
/* 48 */     this.intensity = paramFloat;
/* 49 */     return this;
/*    */   }
/*    */   
/*    */   public PointLight set(float paramFloat1, float paramFloat2, float paramFloat3, Vector3 paramVector3, float paramFloat4) {
/* 53 */     this.color.set(paramFloat1, paramFloat2, paramFloat3, 1.0F);
/* 54 */     if (paramVector3 != null) this.position.set(paramVector3); 
/* 55 */     this.intensity = paramFloat4;
/* 56 */     return this;
/*    */   }
/*    */   
/*    */   public PointLight set(Color paramColor, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 60 */     if (paramColor != null) this.color.set(paramColor); 
/* 61 */     this.position.set(paramFloat1, paramFloat2, paramFloat3);
/* 62 */     this.intensity = paramFloat4;
/* 63 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public PointLight set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) {
/* 68 */     this.color.set(paramFloat1, paramFloat2, paramFloat3, 1.0F);
/* 69 */     this.position.set(paramFloat4, paramFloat5, paramFloat6);
/* 70 */     this.intensity = paramFloat7;
/* 71 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 76 */     return (paramObject instanceof PointLight && equals((PointLight)paramObject));
/*    */   }
/*    */   
/*    */   public boolean equals(PointLight paramPointLight) {
/* 80 */     if (paramPointLight != null && (paramPointLight == this || (this.color
/* 81 */       .equals(paramPointLight.color) && this.position.equals(paramPointLight.position) && this.intensity == paramPointLight.intensity))) return true; 
/*    */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\environment\PointLight.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */