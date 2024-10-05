/*     */ package com.prineside.tdi2.enums;
/*     */ 
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ 
/*     */ public enum InterpolationType {
/*   6 */   linear,
/*   7 */   smooth,
/*   8 */   smooth2,
/*   9 */   smoother,
/*  10 */   fade,
/*  11 */   pow2,
/*  12 */   slowFast,
/*  13 */   fastSlow,
/*  14 */   pow2InInverse,
/*  15 */   pow2OutInverse,
/*  16 */   pow3,
/*  17 */   pow3In,
/*  18 */   pow3Out,
/*  19 */   pow3InInverse,
/*  20 */   pow3OutInverse,
/*  21 */   pow4,
/*  22 */   pow4In,
/*  23 */   pow4Out,
/*  24 */   pow5,
/*  25 */   pow5In,
/*  26 */   pow5Out,
/*  27 */   sine,
/*  28 */   sineIn,
/*  29 */   sineOut,
/*  30 */   exp10,
/*  31 */   exp10In,
/*  32 */   exp10Out,
/*  33 */   exp5,
/*  34 */   exp5In,
/*  35 */   exp5Out,
/*  36 */   circle,
/*  37 */   circleIn,
/*  38 */   circleOut,
/*  39 */   elastic,
/*  40 */   elasticIn,
/*  41 */   elasticOut,
/*  42 */   swing,
/*  43 */   swingIn,
/*  44 */   swingOut,
/*  45 */   bounce,
/*  46 */   bounceIn,
/*  47 */   bounceOut;
/*     */   
/*     */   public static final InterpolationType[] values;
/*     */   public static final Interpolation[] objects;
/*     */   
/*     */   static {
/*  53 */     (objects = new Interpolation[(values = values()).length])[linear.ordinal()] = Interpolation.linear;
/*  54 */     objects[smooth.ordinal()] = Interpolation.smooth;
/*  55 */     objects[smooth2.ordinal()] = Interpolation.smooth2;
/*  56 */     objects[smoother.ordinal()] = Interpolation.smoother;
/*  57 */     objects[fade.ordinal()] = Interpolation.fade;
/*  58 */     objects[pow2.ordinal()] = (Interpolation)Interpolation.pow2;
/*  59 */     objects[slowFast.ordinal()] = (Interpolation)Interpolation.slowFast;
/*  60 */     objects[fastSlow.ordinal()] = (Interpolation)Interpolation.fastSlow;
/*  61 */     objects[pow2InInverse.ordinal()] = Interpolation.pow2InInverse;
/*  62 */     objects[pow2OutInverse.ordinal()] = Interpolation.pow2OutInverse;
/*  63 */     objects[pow3.ordinal()] = (Interpolation)Interpolation.pow3;
/*  64 */     objects[pow3In.ordinal()] = (Interpolation)Interpolation.pow3In;
/*  65 */     objects[pow3Out.ordinal()] = (Interpolation)Interpolation.pow3Out;
/*  66 */     objects[pow3InInverse.ordinal()] = Interpolation.pow3InInverse;
/*  67 */     objects[pow3OutInverse.ordinal()] = Interpolation.pow3OutInverse;
/*  68 */     objects[pow4.ordinal()] = (Interpolation)Interpolation.pow4;
/*  69 */     objects[pow4In.ordinal()] = (Interpolation)Interpolation.pow4In;
/*  70 */     objects[pow4Out.ordinal()] = (Interpolation)Interpolation.pow4Out;
/*  71 */     objects[pow5.ordinal()] = (Interpolation)Interpolation.pow5;
/*  72 */     objects[pow5In.ordinal()] = (Interpolation)Interpolation.pow5In;
/*  73 */     objects[pow5Out.ordinal()] = (Interpolation)Interpolation.pow5Out;
/*  74 */     objects[sine.ordinal()] = Interpolation.sine;
/*  75 */     objects[sineIn.ordinal()] = Interpolation.sineIn;
/*  76 */     objects[sineOut.ordinal()] = Interpolation.sineOut;
/*  77 */     objects[exp10.ordinal()] = (Interpolation)Interpolation.exp10;
/*  78 */     objects[exp10In.ordinal()] = (Interpolation)Interpolation.exp10In;
/*  79 */     objects[exp10Out.ordinal()] = (Interpolation)Interpolation.exp10Out;
/*  80 */     objects[exp5.ordinal()] = (Interpolation)Interpolation.exp5;
/*  81 */     objects[exp5In.ordinal()] = (Interpolation)Interpolation.exp5In;
/*  82 */     objects[exp5Out.ordinal()] = (Interpolation)Interpolation.exp5Out;
/*  83 */     objects[circle.ordinal()] = Interpolation.circle;
/*  84 */     objects[circleIn.ordinal()] = Interpolation.circleIn;
/*  85 */     objects[circleOut.ordinal()] = Interpolation.circleOut;
/*  86 */     objects[elastic.ordinal()] = (Interpolation)Interpolation.elastic;
/*  87 */     objects[elasticIn.ordinal()] = (Interpolation)Interpolation.elasticIn;
/*  88 */     objects[elasticOut.ordinal()] = (Interpolation)Interpolation.elasticOut;
/*  89 */     objects[swing.ordinal()] = (Interpolation)Interpolation.swing;
/*  90 */     objects[swingIn.ordinal()] = (Interpolation)Interpolation.swingIn;
/*  91 */     objects[swingOut.ordinal()] = (Interpolation)Interpolation.swingOut;
/*  92 */     objects[bounce.ordinal()] = (Interpolation)Interpolation.bounce;
/*  93 */     objects[bounceIn.ordinal()] = (Interpolation)Interpolation.bounceIn;
/*  94 */     objects[bounceOut.ordinal()] = (Interpolation)Interpolation.bounceOut;
/*     */   }
/*     */   
/*     */   public static Interpolation getObject(InterpolationType paramInterpolationType) {
/*  98 */     return objects[paramInterpolationType.ordinal()];
/*     */   }
/*     */   
/*     */   public static InterpolationType getType(Interpolation paramInterpolation) {
/* 102 */     for (byte b = 0; b < objects.length; b++) {
/* 103 */       if (objects[b] == paramInterpolation) {
/* 104 */         return values[b];
/*     */       }
/*     */     } 
/*     */     
/* 108 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enums\InterpolationType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */