/*     */ package com.badlogic.gdx.math;
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
/*     */ 
/*     */ 
/*     */ public abstract class Interpolation
/*     */ {
/*     */   public abstract float apply(float paramFloat);
/*     */   
/*     */   public float apply(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  27 */     return paramFloat1 + (paramFloat2 - paramFloat1) * apply(paramFloat3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  32 */   public static final Interpolation linear = new Interpolation() {
/*     */       public float apply(float param1Float) {
/*  34 */         return param1Float;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   public static final Interpolation smooth = new Interpolation() {
/*     */       public float apply(float param1Float) {
/*  43 */         return param1Float * param1Float * (3.0F - param1Float * 2.0F);
/*     */       }
/*     */     };
/*  46 */   public static final Interpolation smooth2 = new Interpolation()
/*     */     {
/*     */       public float apply(float param1Float) {
/*  49 */         return (param1Float = param1Float * param1Float * (3.0F - param1Float * 2.0F)) * param1Float * (3.0F - param1Float * 2.0F);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   public static final Interpolation smoother;
/*     */ 
/*     */ 
/*     */   
/*  59 */   public static final Interpolation fade = smoother = new Interpolation() { public float apply(float param1Float) {
/*     */         return param1Float * param1Float * param1Float * (param1Float * (param1Float * 6.0F - 15.0F) + 10.0F);
/*     */       } }
/*     */   ;
/*  63 */   public static final Pow pow2 = new Pow(2);
/*     */   
/*     */   public static final PowIn pow2In;
/*  66 */   public static final PowIn slowFast = pow2In = new PowIn(2);
/*     */   
/*     */   public static final PowOut pow2Out;
/*  69 */   public static final PowOut fastSlow = pow2Out = new PowOut(2);
/*  70 */   public static final Interpolation pow2InInverse = new Interpolation() {
/*     */       public float apply(float param1Float) {
/*  72 */         if (param1Float < 1.0E-6F) return 0.0F; 
/*  73 */         return (float)Math.sqrt(param1Float);
/*     */       }
/*     */     };
/*  76 */   public static final Interpolation pow2OutInverse = new Interpolation() {
/*     */       public float apply(float param1Float) {
/*  78 */         if (param1Float < 1.0E-6F) return 0.0F; 
/*  79 */         if (param1Float > 1.0F) return 1.0F; 
/*  80 */         return 1.0F - (float)Math.sqrt(-(param1Float - 1.0F));
/*     */       }
/*     */     };
/*     */   
/*  84 */   public static final Pow pow3 = new Pow(3);
/*  85 */   public static final PowIn pow3In = new PowIn(3);
/*  86 */   public static final PowOut pow3Out = new PowOut(3);
/*  87 */   public static final Interpolation pow3InInverse = new Interpolation() {
/*     */       public float apply(float param1Float) {
/*  89 */         return (float)Math.cbrt(param1Float);
/*     */       }
/*     */     };
/*  92 */   public static final Interpolation pow3OutInverse = new Interpolation() {
/*     */       public float apply(float param1Float) {
/*  94 */         return 1.0F - (float)Math.cbrt(-(param1Float - 1.0F));
/*     */       }
/*     */     };
/*     */   
/*  98 */   public static final Pow pow4 = new Pow(4);
/*  99 */   public static final PowIn pow4In = new PowIn(4);
/* 100 */   public static final PowOut pow4Out = new PowOut(4);
/*     */   
/* 102 */   public static final Pow pow5 = new Pow(5);
/* 103 */   public static final PowIn pow5In = new PowIn(5);
/* 104 */   public static final PowOut pow5Out = new PowOut(5);
/*     */   
/* 106 */   public static final Interpolation sine = new Interpolation() {
/*     */       public float apply(float param1Float) {
/* 108 */         return (1.0F - MathUtils.cos(param1Float * 3.1415927F)) / 2.0F;
/*     */       }
/*     */     };
/*     */   
/* 112 */   public static final Interpolation sineIn = new Interpolation() {
/*     */       public float apply(float param1Float) {
/* 114 */         return 1.0F - MathUtils.cos(param1Float * 1.5707964F);
/*     */       }
/*     */     };
/*     */   
/* 118 */   public static final Interpolation sineOut = new Interpolation() {
/*     */       public float apply(float param1Float) {
/* 120 */         return MathUtils.sin(param1Float * 1.5707964F);
/*     */       }
/*     */     };
/*     */   
/* 124 */   public static final Exp exp10 = new Exp(2.0F, 10.0F);
/* 125 */   public static final ExpIn exp10In = new ExpIn(2.0F, 10.0F);
/* 126 */   public static final ExpOut exp10Out = new ExpOut(2.0F, 10.0F);
/*     */   
/* 128 */   public static final Exp exp5 = new Exp(2.0F, 5.0F);
/* 129 */   public static final ExpIn exp5In = new ExpIn(2.0F, 5.0F);
/* 130 */   public static final ExpOut exp5Out = new ExpOut(2.0F, 5.0F);
/*     */   
/* 132 */   public static final Interpolation circle = new Interpolation() {
/*     */       public float apply(float param1Float) {
/* 134 */         if (param1Float <= 0.5F) {
/* 135 */           param1Float *= 2.0F;
/* 136 */           return (1.0F - (float)Math.sqrt((1.0F - param1Float * param1Float))) / 2.0F;
/*     */         } 
/*     */         
/* 139 */         param1Float = (param1Float = param1Float - 1.0F) * 2.0F;
/* 140 */         return ((float)Math.sqrt((1.0F - param1Float * param1Float)) + 1.0F) / 2.0F;
/*     */       }
/*     */     };
/*     */   
/* 144 */   public static final Interpolation circleIn = new Interpolation() {
/*     */       public float apply(float param1Float) {
/* 146 */         return 1.0F - (float)Math.sqrt((1.0F - param1Float * param1Float));
/*     */       }
/*     */     };
/*     */   
/* 150 */   public static final Interpolation circleOut = new Interpolation() {
/*     */       public float apply(float param1Float) {
/* 152 */         param1Float--;
/* 153 */         return (float)Math.sqrt((1.0F - param1Float * param1Float));
/*     */       }
/*     */     };
/*     */   
/* 157 */   public static final Elastic elastic = new Elastic(2.0F, 10.0F, 7, 1.0F);
/* 158 */   public static final ElasticIn elasticIn = new ElasticIn(2.0F, 10.0F, 6, 1.0F);
/* 159 */   public static final ElasticOut elasticOut = new ElasticOut(2.0F, 10.0F, 7, 1.0F);
/*     */   
/* 161 */   public static final Swing swing = new Swing(1.5F);
/* 162 */   public static final SwingIn swingIn = new SwingIn(2.0F);
/* 163 */   public static final SwingOut swingOut = new SwingOut(2.0F);
/*     */   
/* 165 */   public static final Bounce bounce = new Bounce(4);
/* 166 */   public static final BounceIn bounceIn = new BounceIn(4);
/* 167 */   public static final BounceOut bounceOut = new BounceOut(4);
/*     */   
/*     */   public static class Pow
/*     */     extends Interpolation
/*     */   {
/*     */     final int power;
/*     */     
/*     */     public Pow(int param1Int) {
/* 175 */       this.power = param1Int;
/*     */     }
/*     */     
/*     */     public float apply(float param1Float) {
/* 179 */       if (param1Float <= 0.5F) return (float)Math.pow((param1Float * 2.0F), this.power) / 2.0F; 
/* 180 */       return (float)Math.pow(((param1Float - 1.0F) * 2.0F), this.power) / ((this.power % 2 == 0) ? -2 : 2) + 1.0F;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class PowIn extends Pow {
/*     */     public PowIn(int param1Int) {
/* 186 */       super(param1Int);
/*     */     }
/*     */     
/*     */     public float apply(float param1Float) {
/* 190 */       return (float)Math.pow(param1Float, this.power);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class PowOut extends Pow {
/*     */     public PowOut(int param1Int) {
/* 196 */       super(param1Int);
/*     */     }
/*     */     
/*     */     public float apply(float param1Float) {
/* 200 */       return (float)Math.pow((param1Float - 1.0F), this.power) * ((this.power % 2 == 0) ? -1 : true) + 1.0F;
/*     */     } }
/*     */   
/*     */   public static class Exp extends Interpolation {
/*     */     final float value;
/*     */     final float power;
/*     */     final float min;
/*     */     final float scale;
/*     */     
/*     */     public Exp(float param1Float1, float param1Float2) {
/* 210 */       this.value = param1Float1;
/* 211 */       this.power = param1Float2;
/* 212 */       this.min = (float)Math.pow(param1Float1, -param1Float2);
/* 213 */       this.scale = 1.0F / (1.0F - this.min);
/*     */     }
/*     */     
/*     */     public float apply(float param1Float) {
/* 217 */       if (param1Float <= 0.5F) return ((float)Math.pow(this.value, (this.power * (param1Float * 2.0F - 1.0F))) - this.min) * this.scale / 2.0F; 
/* 218 */       return (2.0F - ((float)Math.pow(this.value, (-this.power * (param1Float * 2.0F - 1.0F))) - this.min) * this.scale) / 2.0F;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ExpIn extends Exp {
/*     */     public ExpIn(float param1Float1, float param1Float2) {
/* 224 */       super(param1Float1, param1Float2);
/*     */     }
/*     */     
/*     */     public float apply(float param1Float) {
/* 228 */       return ((float)Math.pow(this.value, (this.power * (param1Float - 1.0F))) - this.min) * this.scale;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ExpOut extends Exp {
/*     */     public ExpOut(float param1Float1, float param1Float2) {
/* 234 */       super(param1Float1, param1Float2);
/*     */     }
/*     */     
/*     */     public float apply(float param1Float) {
/* 238 */       return 1.0F - ((float)Math.pow(this.value, (-this.power * param1Float)) - this.min) * this.scale;
/*     */     } }
/*     */   
/*     */   public static class Elastic extends Interpolation {
/*     */     final float value;
/*     */     final float power;
/*     */     final float scale;
/*     */     final float bounces;
/*     */     
/*     */     public Elastic(float param1Float1, float param1Float2, int param1Int, float param1Float3) {
/* 248 */       this.value = param1Float1;
/* 249 */       this.power = param1Float2;
/* 250 */       this.scale = param1Float3;
/* 251 */       this.bounces = param1Int * 3.1415927F * ((param1Int % 2 == 0) ? true : -1);
/*     */     }
/*     */     
/*     */     public float apply(float param1Float) {
/* 255 */       if (param1Float <= 0.5F) {
/* 256 */         param1Float *= 2.0F;
/* 257 */         return (float)Math.pow(this.value, (this.power * (param1Float - 1.0F))) * MathUtils.sin(param1Float * this.bounces) * this.scale / 2.0F;
/*     */       } 
/*     */       
/* 260 */       param1Float = (param1Float = 1.0F - param1Float) * 2.0F;
/* 261 */       return 1.0F - (float)Math.pow(this.value, (this.power * (param1Float - 1.0F))) * MathUtils.sin(param1Float * this.bounces) * this.scale / 2.0F;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ElasticIn extends Elastic {
/*     */     public ElasticIn(float param1Float1, float param1Float2, int param1Int, float param1Float3) {
/* 267 */       super(param1Float1, param1Float2, param1Int, param1Float3);
/*     */     }
/*     */     
/*     */     public float apply(float param1Float) {
/* 271 */       if (param1Float >= 0.99D) return 1.0F; 
/* 272 */       return (float)Math.pow(this.value, (this.power * (param1Float - 1.0F))) * MathUtils.sin(param1Float * this.bounces) * this.scale;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ElasticOut extends Elastic {
/*     */     public ElasticOut(float param1Float1, float param1Float2, int param1Int, float param1Float3) {
/* 278 */       super(param1Float1, param1Float2, param1Int, param1Float3);
/*     */     }
/*     */     
/*     */     public float apply(float param1Float) {
/* 282 */       if (param1Float == 0.0F) return 0.0F; 
/* 283 */       param1Float = 1.0F - param1Float;
/* 284 */       return 1.0F - (float)Math.pow(this.value, (this.power * (param1Float - 1.0F))) * MathUtils.sin(param1Float * this.bounces) * this.scale;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Bounce
/*     */     extends BounceOut
/*     */   {
/*     */     public Bounce(float[] param1ArrayOffloat1, float[] param1ArrayOffloat2) {
/* 292 */       super(param1ArrayOffloat1, param1ArrayOffloat2);
/*     */     }
/*     */     
/*     */     public Bounce(int param1Int) {
/* 296 */       super(param1Int);
/*     */     }
/*     */     
/*     */     private float out(float param1Float) {
/*     */       float f;
/* 301 */       if ((f = param1Float + this.widths[0] / 2.0F) < this.widths[0]) return f / this.widths[0] / 2.0F - 1.0F; 
/* 302 */       return super.apply(param1Float);
/*     */     }
/*     */     
/*     */     public float apply(float param1Float) {
/* 306 */       if (param1Float <= 0.5F) return (1.0F - out(1.0F - param1Float * 2.0F)) / 2.0F; 
/* 307 */       return out(param1Float * 2.0F - 1.0F) / 2.0F + 0.5F;
/*     */     } }
/*     */   
/*     */   public static class BounceOut extends Interpolation {
/*     */     final float[] widths;
/*     */     final float[] heights;
/*     */     
/*     */     public BounceOut(float[] param1ArrayOffloat1, float[] param1ArrayOffloat2) {
/* 315 */       if (param1ArrayOffloat1.length != param1ArrayOffloat2.length)
/* 316 */         throw new IllegalArgumentException("Must be the same number of widths and heights."); 
/* 317 */       this.widths = param1ArrayOffloat1;
/* 318 */       this.heights = param1ArrayOffloat2;
/*     */     }
/*     */     
/*     */     public BounceOut(int param1Int) {
/* 322 */       if (param1Int < 2 || param1Int > 5) throw new IllegalArgumentException("bounces cannot be < 2 or > 5: " + param1Int); 
/* 323 */       this.widths = new float[param1Int];
/* 324 */       this.heights = new float[param1Int];
/* 325 */       this.heights[0] = 1.0F;
/* 326 */       switch (param1Int) {
/*     */         case 2:
/* 328 */           this.widths[0] = 0.6F;
/* 329 */           this.widths[1] = 0.4F;
/* 330 */           this.heights[1] = 0.33F;
/*     */           break;
/*     */         case 3:
/* 333 */           this.widths[0] = 0.4F;
/* 334 */           this.widths[1] = 0.4F;
/* 335 */           this.widths[2] = 0.2F;
/* 336 */           this.heights[1] = 0.33F;
/* 337 */           this.heights[2] = 0.1F;
/*     */           break;
/*     */         case 4:
/* 340 */           this.widths[0] = 0.34F;
/* 341 */           this.widths[1] = 0.34F;
/* 342 */           this.widths[2] = 0.2F;
/* 343 */           this.widths[3] = 0.15F;
/* 344 */           this.heights[1] = 0.26F;
/* 345 */           this.heights[2] = 0.11F;
/* 346 */           this.heights[3] = 0.03F;
/*     */           break;
/*     */         case 5:
/* 349 */           this.widths[0] = 0.3F;
/* 350 */           this.widths[1] = 0.3F;
/* 351 */           this.widths[2] = 0.2F;
/* 352 */           this.widths[3] = 0.1F;
/* 353 */           this.widths[4] = 0.1F;
/* 354 */           this.heights[1] = 0.45F;
/* 355 */           this.heights[2] = 0.3F;
/* 356 */           this.heights[3] = 0.15F;
/* 357 */           this.heights[4] = 0.06F;
/*     */           break;
/*     */       } 
/* 360 */       this.widths[0] = this.widths[0] * 2.0F;
/*     */     }
/*     */     
/*     */     public float apply(float param1Float) {
/* 364 */       if (param1Float == 1.0F) return 1.0F; 
/* 365 */       param1Float += this.widths[0] / 2.0F;
/* 366 */       float f1 = 0.0F, f2 = 0.0F; byte b; int i;
/* 367 */       for (b = 0, i = this.widths.length; b < i; b++) {
/* 368 */         f1 = this.widths[b];
/* 369 */         if (param1Float <= f1) {
/* 370 */           f2 = this.heights[b];
/*     */           break;
/*     */         } 
/* 373 */         param1Float -= f1;
/*     */       } 
/* 375 */       param1Float /= f1;
/* 376 */       float f3 = 4.0F / f1 * f2 * param1Float;
/* 377 */       return 1.0F - (f3 - f3 * param1Float) * f1;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class BounceIn extends BounceOut {
/*     */     public BounceIn(float[] param1ArrayOffloat1, float[] param1ArrayOffloat2) {
/* 383 */       super(param1ArrayOffloat1, param1ArrayOffloat2);
/*     */     }
/*     */     
/*     */     public BounceIn(int param1Int) {
/* 387 */       super(param1Int);
/*     */     }
/*     */     
/*     */     public float apply(float param1Float) {
/* 391 */       return 1.0F - super.apply(1.0F - param1Float);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Swing
/*     */     extends Interpolation
/*     */   {
/*     */     private final float scale;
/*     */     
/*     */     public Swing(float param1Float) {
/* 401 */       this.scale = param1Float * 2.0F;
/*     */     }
/*     */     
/*     */     public float apply(float param1Float) {
/* 405 */       if (param1Float <= 0.5F)
/*     */       {
/* 407 */         return (param1Float = param1Float * 2.0F) * param1Float * ((this.scale + 1.0F) * param1Float - this.scale) / 2.0F;
/*     */       }
/*     */ 
/*     */       
/* 411 */       return (param1Float = (param1Float = param1Float - 1.0F) * 2.0F) * param1Float * ((this.scale + 1.0F) * param1Float + this.scale) / 2.0F + 1.0F;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class SwingOut extends Interpolation {
/*     */     private final float scale;
/*     */     
/*     */     public SwingOut(float param1Float) {
/* 419 */       this.scale = param1Float;
/*     */     }
/*     */ 
/*     */     
/*     */     public float apply(float param1Float) {
/* 424 */       return (param1Float = param1Float - 1.0F) * param1Float * ((this.scale + 1.0F) * param1Float + this.scale) + 1.0F;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class SwingIn extends Interpolation {
/*     */     private final float scale;
/*     */     
/*     */     public SwingIn(float param1Float) {
/* 432 */       this.scale = param1Float;
/*     */     }
/*     */     
/*     */     public float apply(float param1Float) {
/* 436 */       return param1Float * param1Float * ((this.scale + 1.0F) * param1Float - this.scale);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\Interpolation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */