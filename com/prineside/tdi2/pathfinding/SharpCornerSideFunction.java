/*    */ package com.prineside.tdi2.pathfinding;
/*    */ 
/*    */ import com.badlogic.gdx.math.Vector2;
/*    */ import com.prineside.tdi2.utils.PMath;
/*    */ 
/*    */ public final class SharpCornerSideFunction
/*    */   implements SideFunction
/*    */ {
/*    */   private final float a;
/*    */   private final float b;
/*    */   private final float c;
/*    */   private final float d;
/*    */   private final float e;
/*    */   private final float f;
/*    */   private final float g;
/*    */   private final float h;
/*    */   
/*    */   SharpCornerSideFunction(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 19 */     this.a = paramFloat1 * 128.0F;
/* 20 */     this.d = paramFloat2 * 128.0F;
/* 21 */     this.b = paramFloat3 * 128.0F;
/* 22 */     this.e = paramFloat4 * 128.0F;
/* 23 */     this.c = paramFloat5 * 128.0F;
/* 24 */     this.f = paramFloat6 * 128.0F;
/*    */     
/* 26 */     this.g = PMath.getAngleBetweenPoints(paramFloat3, paramFloat4, paramFloat1, paramFloat2);
/* 27 */     this.h = PMath.getAngleBetweenPoints(paramFloat5, paramFloat6, paramFloat3, paramFloat4);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void position(float paramFloat, Vector2 paramVector2) {
/* 32 */     if (paramFloat < 0.5F) {
/* 33 */       paramFloat *= 2.0F;
/* 34 */       paramVector2.set(this.a + (this.b - this.a) * paramFloat, this.d + (this.e - this.d) * paramFloat); return;
/*    */     } 
/* 36 */     paramFloat = (paramFloat - 0.5F) * 2.0F;
/* 37 */     paramVector2.set(this.b + (this.c - this.b) * paramFloat, this.e + (this.f - this.e) * paramFloat);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final float rotation(float paramFloat) {
/* 43 */     return (paramFloat < 0.5F) ? this.g : this.h;
/*    */   }
/*    */ 
/*    */   
/*    */   public final float speedMultiplier() {
/* 48 */     return 0.70710677F;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\pathfinding\SharpCornerSideFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */