/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.badlogic.gdx.ai.steer.behaviors.FollowFlowField;
/*     */ import com.badlogic.gdx.math.Vector;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ 
/*     */ @REGS(serializer = FlowField.Serializer.class)
/*     */ public final class FlowField implements FollowFlowField.FlowField<Vector2> {
/*     */   private final float[][] a;
/*     */   private final int b;
/*     */   private final int c;
/*     */   private final float d;
/*     */   private final float e;
/*     */   
/*     */   public static class Serializer extends com.esotericsoftware.kryo.Serializer<FlowField> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, FlowField param1FlowField) {
/*  21 */       param1Kryo.writeObject(param1Output, FlowField.a(param1FlowField));
/*  22 */       param1Output.writeVarInt(FlowField.b(param1FlowField), true);
/*  23 */       param1Output.writeVarInt(FlowField.c(param1FlowField), true);
/*  24 */       param1Output.writeFloat(FlowField.d(param1FlowField));
/*     */     }
/*     */ 
/*     */     
/*     */     public FlowField read(Kryo param1Kryo, Input param1Input, Class<? extends FlowField> param1Class) {
/*  29 */       float[][] arrayOfFloat = (float[][])param1Kryo.readObject(param1Input, float[][].class);
/*  30 */       int i = param1Input.readVarInt(true);
/*  31 */       int j = param1Input.readVarInt(true);
/*  32 */       float f = param1Input.readFloat();
/*     */       
/*  34 */       return new FlowField(arrayOfFloat, i, j, f, (byte)0);
/*     */     } }
/*     */   
/*     */   @NAGS
/*  38 */   private final Vector2 f = new Vector2();
/*     */   
/*     */   private FlowField(float[][] paramArrayOffloat, int paramInt1, int paramInt2, float paramFloat) {
/*  41 */     this.a = paramArrayOffloat;
/*  42 */     this.b = paramInt1;
/*  43 */     this.c = paramInt2;
/*  44 */     this.d = paramFloat;
/*  45 */     this.e = 1.0F / paramFloat;
/*     */   }
/*     */   
/*     */   public FlowField(int paramInt1, int paramInt2, float paramFloat) {
/*  49 */     Preconditions.checkArgument((paramInt1 > 0), "width can not be %s", paramInt1);
/*  50 */     Preconditions.checkArgument((paramInt2 > 0), "height can not be %s", paramInt2);
/*  51 */     this.b = paramInt1;
/*  52 */     this.c = paramInt2;
/*  53 */     this.d = paramFloat;
/*  54 */     this.e = 1.0F / paramFloat;
/*  55 */     this.a = new float[paramInt2][paramInt1 << 1];
/*     */   }
/*     */   
/*     */   public final int getHeight() {
/*  59 */     return this.c;
/*     */   }
/*     */   
/*     */   public final int getWidth() {
/*  63 */     return this.b;
/*     */   }
/*     */   
/*     */   public final float getCellSize() {
/*  67 */     return this.d;
/*     */   }
/*     */   
/*     */   public final void setDirection(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2) {
/*  71 */     this.a[paramInt2][paramInt1 << 1] = paramFloat1;
/*  72 */     this.a[paramInt2][(paramInt1 << 1) + 1] = paramFloat2;
/*     */   }
/*     */   
/*     */   public final Vector2 getDirection(int paramInt1, int paramInt2) {
/*  76 */     if (paramInt1 < 0) {
/*  77 */       if (paramInt2 < 0) {
/*  78 */         this.f.set(0.70710677F, 0.70710677F);
/*  79 */       } else if (paramInt2 >= this.c) {
/*  80 */         this.f.set(0.70710677F, -0.70710677F);
/*     */       } else {
/*  82 */         this.f.set(1.0F, 0.0F);
/*     */       } 
/*  84 */     } else if (paramInt1 >= this.b) {
/*  85 */       if (paramInt2 < 0) {
/*  86 */         this.f.set(-0.70710677F, 0.70710677F);
/*  87 */       } else if (paramInt2 >= this.c) {
/*  88 */         this.f.set(-0.70710677F, -0.70710677F);
/*     */       } else {
/*  90 */         this.f.set(-1.0F, 0.0F);
/*     */       }
/*     */     
/*     */     }
/*  94 */     else if (paramInt2 < 0) {
/*  95 */       this.f.set(0.0F, 1.0F);
/*  96 */     } else if (paramInt2 >= this.c) {
/*  97 */       this.f.set(0.0F, -1.0F);
/*     */     } else {
/*     */       
/* 100 */       this.f.x = this.a[paramInt2][paramInt1 << 1];
/* 101 */       this.f.y = this.a[paramInt2][(paramInt1 << 1) + 1];
/*     */     } 
/*     */ 
/*     */     
/* 105 */     return this.f;
/*     */   }
/*     */   
/*     */   private int a(float paramFloat) {
/* 109 */     return (int)(paramFloat * this.e + this.d * 128.0F) - 128;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Vector2 lookup(Vector2 paramVector2) {
/* 114 */     return getDirection(a(paramVector2.x), a(paramVector2.y));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\FlowField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */