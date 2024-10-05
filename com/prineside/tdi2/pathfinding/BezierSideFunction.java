/*    */ package com.prineside.tdi2.pathfinding;
/*    */ 
/*    */ import com.badlogic.gdx.math.MathUtils;
/*    */ import com.badlogic.gdx.math.Vector2;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class BezierSideFunction
/*    */   implements SideFunction
/*    */ {
/*    */   private final float a;
/*    */   private final float b;
/*    */   private final float c;
/*    */   private final float d;
/*    */   private final float e;
/*    */   private final float f;
/*    */   private final float g;
/*    */   
/*    */   BezierSideFunction(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) {
/* 21 */     this.a = paramFloat1 * 128.0F;
/* 22 */     this.d = paramFloat2 * 128.0F;
/* 23 */     this.b = paramFloat3 * 128.0F;
/* 24 */     this.e = paramFloat4 * 128.0F;
/* 25 */     this.c = paramFloat5 * 128.0F;
/* 26 */     this.f = paramFloat6 * 128.0F;
/*    */ 
/*    */     
/* 29 */     double d1 = 0.5D + paramFloat7;
/* 30 */     double d2 = d1 * 1.5707963267948966D;
/* 31 */     this.g = (float)(1.0D / d2);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void position(float paramFloat, Vector2 paramVector2) {
/* 36 */     float f = 1.0F - paramFloat;
/* 37 */     paramVector2.x = this.a * f * f + 2.0F * this.b * f * paramFloat + this.c * paramFloat * paramFloat;
/* 38 */     paramVector2.y = this.d * f * f + 2.0F * this.e * f * paramFloat + this.f * paramFloat * paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public final float rotation(float paramFloat) {
/* 43 */     float f1 = paramFloat - 1.0F;
/* 44 */     float f2 = 2.0F * (this.a * f1 - this.b * (paramFloat * 2.0F - 1.0F) + this.c * paramFloat);
/* 45 */     paramFloat = 2.0F * (this.d * f1 - this.e * (paramFloat * 2.0F - 1.0F) + this.f * paramFloat);
/* 46 */     return 57.295776F * MathUtils.atan2(paramFloat, f2) - 90.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public final float speedMultiplier() {
/* 51 */     return this.g;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\pathfinding\BezierSideFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */