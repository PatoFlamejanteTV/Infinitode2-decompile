/*    */ package com.badlogic.gdx.graphics.g3d.environment;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
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
/*    */ public abstract class BaseLight<T extends BaseLight<T>>
/*    */ {
/* 22 */   public final Color color = new Color(0.0F, 0.0F, 0.0F, 1.0F);
/*    */   
/*    */   public T setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 25 */     this.color.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 26 */     return (T)this;
/*    */   }
/*    */   
/*    */   public T setColor(Color paramColor) {
/* 30 */     this.color.set(paramColor);
/* 31 */     return (T)this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\environment\BaseLight.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */