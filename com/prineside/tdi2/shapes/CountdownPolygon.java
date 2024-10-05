/*    */ package com.prineside.tdi2.shapes;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.Batch;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.Shape;
/*    */ 
/*    */ public class CountdownPolygon
/*    */   extends Shape {
/* 10 */   private float[] a = new float[0];
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final TextureRegion b;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private CountdownPolygon() {
/* 21 */     this.b = (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion();
/* 22 */     this.b.getU2(); this.b.getU();
/* 23 */     this.b.getV2(); this.b.getV();
/* 24 */     this.b.getU();
/* 25 */     this.b.getV();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setup(float[] paramArrayOffloat) {
/* 32 */     if (paramArrayOffloat.length % 2 == 1) throw new IllegalArgumentException("points must be %2 == 0"); 
/* 33 */     if (paramArrayOffloat.length < 6) throw new IllegalArgumentException("points min length is 6");
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
/*    */ 
/*    */ 
/*    */     
/* 53 */     int i = ((i = paramArrayOffloat.length / 2) + 1) / 2;
/* 54 */     if (this.a.length < i * 20) {
/* 55 */       this.a = new float[i * 20];
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void draw(Batch paramBatch) {
/* 62 */     paramBatch.draw(this.b.getTexture(), this.a, 0, 0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void reset() {}
/*    */ 
/*    */   
/*    */   public void free() {}
/*    */ 
/*    */   
/*    */   public static class CountdownPolygonFactory
/*    */     extends Shape.Factory<CountdownPolygon>
/*    */   {
/*    */     public void setup() {}
/*    */ 
/*    */     
/*    */     private static CountdownPolygon b() {
/* 80 */       return new CountdownPolygon((byte)0);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\shapes\CountdownPolygon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */