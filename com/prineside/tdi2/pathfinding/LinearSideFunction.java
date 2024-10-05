/*    */ package com.prineside.tdi2.pathfinding;
/*    */ 
/*    */ import com.badlogic.gdx.math.Vector2;
/*    */ import com.prineside.tdi2.utils.PMath;
/*    */ 
/*    */ public final class LinearSideFunction
/*    */   implements SideFunction
/*    */ {
/*    */   private final float a;
/*    */   private final float b;
/*    */   private final float c;
/*    */   private final float d;
/*    */   private final float e;
/*    */   private final float f;
/*    */   
/*    */   LinearSideFunction(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 17 */     this.a = paramFloat1 * 128.0F;
/* 18 */     this.c = paramFloat2 * 128.0F;
/* 19 */     this.b = paramFloat3 * 128.0F;
/* 20 */     this.d = paramFloat4 * 128.0F;
/*    */     
/* 22 */     this.f = PMath.getAngleBetweenPoints(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 23 */     this.e = 1.0F / PMath.getDistanceBetweenPoints(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void position(float paramFloat, Vector2 paramVector2) {
/* 28 */     paramVector2.x = this.a + (this.b - this.a) * paramFloat;
/* 29 */     paramVector2.y = this.c + (this.d - this.c) * paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public final float rotation(float paramFloat) {
/* 34 */     return this.f;
/*    */   }
/*    */ 
/*    */   
/*    */   public final float speedMultiplier() {
/* 39 */     return this.e;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\pathfinding\LinearSideFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */