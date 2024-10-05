/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.Batch;
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.prineside.tdi2.scene2d.utils.BaseDrawable;
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ import com.prineside.tdi2.scene2d.utils.TransformDrawable;
/*    */ import com.prineside.tdi2.ui.actors.QuadActor;
/*    */ 
/*    */ public final class QuadDrawableStack
/*    */   extends BaseDrawable
/*    */   implements TransformDrawable {
/* 13 */   private Array<QuadActorConfig> a = new Array(QuadActorConfig.class);
/*    */   
/*    */   private float b;
/*    */   
/*    */   private float c;
/*    */   
/*    */   public QuadDrawableStack() {}
/*    */   
/*    */   public QuadDrawableStack(Array<QuadActorConfig> paramArray) {
/* 22 */     setQuadActors(paramArray);
/*    */   }
/*    */   
/*    */   public QuadDrawableStack(QuadDrawableStack paramQuadDrawableStack) {
/* 26 */     super((Drawable)paramQuadDrawableStack);
/* 27 */     setQuadActors(paramQuadDrawableStack.a);
/*    */   }
/*    */ 
/*    */   
/*    */   @IgnoreMethodOverloadLuaDefWarning
/*    */   public final void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 33 */     paramFloat3 /= this.b;
/* 34 */     paramFloat4 /= this.c;
/*    */     
/* 36 */     for (byte b = 0; b < this.a.size; b++) {
/*    */       QuadActorConfig quadActorConfig;
/*    */       
/* 39 */       (quadActorConfig = ((QuadActorConfig[])this.a.items)[b]).actor.setPosition(paramFloat1 + quadActorConfig.x * paramFloat3, paramFloat2 + quadActorConfig.y * paramFloat4);
/* 40 */       quadActorConfig.actor.setSize(quadActorConfig.width * paramFloat3, quadActorConfig.height * paramFloat4);
/* 41 */       quadActorConfig.actor.setColor(paramBatch.getColor());
/* 42 */       quadActorConfig.actor.draw(paramBatch, 1.0F);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @IgnoreMethodOverloadLuaDefWarning
/*    */   public final void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/* 50 */     draw(paramBatch, paramFloat1, paramFloat2, paramFloat5, paramFloat6);
/*    */   }
/*    */   
/*    */   public final void setQuadActors(Array<QuadActorConfig> paramArray) {
/* 54 */     this.a.clear();
/* 55 */     this.a.addAll(paramArray);
/*    */     
/* 57 */     float f1 = 0.0F;
/* 58 */     float f2 = 0.0F;
/* 59 */     for (byte b = 0; b < this.a.size; b++) {
/*    */       QuadActorConfig quadActorConfig;
/*    */       
/* 62 */       float f4 = (quadActorConfig = ((QuadActorConfig[])this.a.items)[b]).width + quadActorConfig.x;
/* 63 */       float f3 = quadActorConfig.height + quadActorConfig.y;
/* 64 */       if (f4 > f1) f1 = f4; 
/* 65 */       if (f3 > f2) f2 = f3;
/*    */     
/*    */     } 
/* 68 */     setMinWidth(f1);
/* 69 */     setMinHeight(f2);
/* 70 */     this.b = f1;
/* 71 */     this.c = f2;
/*    */   }
/*    */   
/*    */   public static class QuadActorConfig {
/*    */     public QuadActor actor;
/*    */     public float x;
/*    */     public float y;
/*    */     public float width;
/*    */     public float height;
/*    */     
/*    */     public QuadActorConfig(QuadActor param1QuadActor, float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/* 82 */       this.actor = param1QuadActor;
/* 83 */       this.x = param1Float1;
/* 84 */       this.y = param1Float2;
/* 85 */       this.width = param1Float3;
/* 86 */       this.height = param1Float4;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\QuadDrawableStack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */