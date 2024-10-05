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
/*    */ public class DirectionalLight
/*    */   extends BaseLight<DirectionalLight>
/*    */ {
/* 23 */   public final Vector3 direction = new Vector3();
/*    */   
/*    */   public DirectionalLight setDirection(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 26 */     this.direction.set(paramFloat1, paramFloat2, paramFloat3);
/* 27 */     return this;
/*    */   }
/*    */   
/*    */   public DirectionalLight setDirection(Vector3 paramVector3) {
/* 31 */     this.direction.set(paramVector3);
/* 32 */     return this;
/*    */   }
/*    */   
/*    */   public DirectionalLight set(DirectionalLight paramDirectionalLight) {
/* 36 */     return set(paramDirectionalLight.color, paramDirectionalLight.direction);
/*    */   }
/*    */   
/*    */   public DirectionalLight set(Color paramColor, Vector3 paramVector3) {
/* 40 */     if (paramColor != null) this.color.set(paramColor); 
/* 41 */     if (paramVector3 != null) this.direction.set(paramVector3).nor(); 
/* 42 */     return this;
/*    */   }
/*    */   
/*    */   public DirectionalLight set(float paramFloat1, float paramFloat2, float paramFloat3, Vector3 paramVector3) {
/* 46 */     this.color.set(paramFloat1, paramFloat2, paramFloat3, 1.0F);
/* 47 */     if (paramVector3 != null) this.direction.set(paramVector3).nor(); 
/* 48 */     return this;
/*    */   }
/*    */   
/*    */   public DirectionalLight set(Color paramColor, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 52 */     if (paramColor != null) this.color.set(paramColor); 
/* 53 */     this.direction.set(paramFloat1, paramFloat2, paramFloat3).nor();
/* 54 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public DirectionalLight set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 59 */     this.color.set(paramFloat1, paramFloat2, paramFloat3, 1.0F);
/* 60 */     this.direction.set(paramFloat4, paramFloat5, paramFloat6).nor();
/* 61 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 66 */     return (paramObject instanceof DirectionalLight && equals((DirectionalLight)paramObject));
/*    */   }
/*    */   
/*    */   public boolean equals(DirectionalLight paramDirectionalLight) {
/* 70 */     return (paramDirectionalLight != null && (paramDirectionalLight == this || (this.color.equals(paramDirectionalLight.color) && this.direction.equals(paramDirectionalLight.direction))));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\environment\DirectionalLight.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */