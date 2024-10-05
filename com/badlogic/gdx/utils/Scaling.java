/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import com.badlogic.gdx.math.Vector2;
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
/*     */ public abstract class Scaling
/*     */ {
/*  24 */   protected static final Vector2 temp = new Vector2();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  32 */   public static final Scaling fit = new Scaling() {
/*     */       public Vector2 apply(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/*  34 */         float f1 = param1Float4 / param1Float3;
/*  35 */         float f2 = param1Float2 / param1Float1;
/*  36 */         param1Float3 = (f1 > f2) ? (param1Float3 / param1Float1) : (param1Float4 / param1Float2);
/*  37 */         temp.x = param1Float1 * param1Float3;
/*  38 */         temp.y = param1Float2 * param1Float3;
/*  39 */         return temp;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*  45 */   public static final Scaling contain = new Scaling() {
/*     */       public Vector2 apply(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/*  47 */         float f1 = param1Float4 / param1Float3;
/*  48 */         float f2 = param1Float2 / param1Float1;
/*     */         
/*  50 */         if ((param1Float3 = (f1 > f2) ? (param1Float3 / param1Float1) : (param1Float4 / param1Float2)) > 1.0F) param1Float3 = 1.0F; 
/*  51 */         temp.x = param1Float1 * param1Float3;
/*  52 */         temp.y = param1Float2 * param1Float3;
/*  53 */         return temp;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*  59 */   public static final Scaling fill = new Scaling() {
/*     */       public Vector2 apply(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/*  61 */         float f1 = param1Float4 / param1Float3;
/*  62 */         float f2 = param1Float2 / param1Float1;
/*  63 */         param1Float3 = (f1 < f2) ? (param1Float3 / param1Float1) : (param1Float4 / param1Float2);
/*  64 */         temp.x = param1Float1 * param1Float3;
/*  65 */         temp.y = param1Float2 * param1Float3;
/*  66 */         return temp;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*  72 */   public static final Scaling fillX = new Scaling() {
/*     */       public Vector2 apply(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/*  74 */         param1Float3 /= param1Float1;
/*  75 */         temp.x = param1Float1 * param1Float3;
/*  76 */         temp.y = param1Float2 * param1Float3;
/*  77 */         return temp;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*  83 */   public static final Scaling fillY = new Scaling() {
/*     */       public Vector2 apply(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/*  85 */         param1Float3 = param1Float4 / param1Float2;
/*  86 */         temp.x = param1Float1 * param1Float3;
/*  87 */         temp.y = param1Float2 * param1Float3;
/*  88 */         return temp;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  93 */   public static final Scaling stretch = new Scaling() {
/*     */       public Vector2 apply(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/*  95 */         temp.x = param1Float3;
/*  96 */         temp.y = param1Float4;
/*  97 */         return temp;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/* 103 */   public static final Scaling stretchX = new Scaling() {
/*     */       public Vector2 apply(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/* 105 */         temp.x = param1Float3;
/* 106 */         temp.y = param1Float2;
/* 107 */         return temp;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/* 113 */   public static final Scaling stretchY = new Scaling() {
/*     */       public Vector2 apply(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/* 115 */         temp.x = param1Float1;
/* 116 */         temp.y = param1Float4;
/* 117 */         return temp;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 122 */   public static final Scaling none = new Scaling() {
/*     */       public Vector2 apply(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/* 124 */         temp.x = param1Float1;
/* 125 */         temp.y = param1Float2;
/* 126 */         return temp;
/*     */       }
/*     */     };
/*     */   
/*     */   public abstract Vector2 apply(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\Scaling.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */