/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.utils.Layout;
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
/*     */ public abstract class Value
/*     */ {
/*     */   public float get() {
/*  29 */     return get(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  36 */   public static final Fixed zero = new Fixed(0.0F);
/*     */   
/*     */   public static class Fixed
/*     */     extends Value
/*     */   {
/*  41 */     private static Fixed[] a = new Fixed[111];
/*     */     
/*     */     private final float b;
/*     */     
/*     */     public Fixed(float param1Float) {
/*  46 */       this.b = param1Float;
/*     */     }
/*     */     
/*     */     public float get(@Null Actor param1Actor) {
/*  50 */       return this.b;
/*     */     }
/*     */     
/*     */     public String toString() {
/*  54 */       return Float.toString(this.b);
/*     */     }
/*     */     
/*     */     public static Fixed valueOf(float param1Float) {
/*  58 */       if (param1Float == 0.0F) return zero; 
/*  59 */       if (param1Float >= -10.0F && param1Float <= 100.0F && param1Float == (int)param1Float) {
/*     */         Fixed fixed;
/*  61 */         if ((fixed = a[(int)param1Float + 10]) == null) a[(int)param1Float + 10] = fixed = new Fixed(param1Float); 
/*  62 */         return fixed;
/*     */       } 
/*  64 */       return new Fixed(param1Float);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*  69 */   public static Value minWidth = new Value() {
/*     */       public float get(@Null Actor param1Actor) {
/*  71 */         if (param1Actor instanceof Layout) return ((Layout)param1Actor).getMinWidth(); 
/*  72 */         return (param1Actor == null) ? 0.0F : param1Actor.getWidth();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  77 */   public static Value minHeight = new Value() {
/*     */       public float get(@Null Actor param1Actor) {
/*  79 */         if (param1Actor instanceof Layout) return ((Layout)param1Actor).getMinHeight(); 
/*  80 */         return (param1Actor == null) ? 0.0F : param1Actor.getHeight();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  85 */   public static Value prefWidth = new Value() {
/*     */       public float get(@Null Actor param1Actor) {
/*  87 */         if (param1Actor instanceof Layout) return ((Layout)param1Actor).getPrefWidth(); 
/*  88 */         return (param1Actor == null) ? 0.0F : param1Actor.getWidth();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*  94 */   public static Value prefHeight = new Value() {
/*     */       public float get(@Null Actor param1Actor) {
/*  96 */         if (param1Actor instanceof Layout) return ((Layout)param1Actor).getPrefHeight(); 
/*  97 */         return (param1Actor == null) ? 0.0F : param1Actor.getHeight();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 102 */   public static Value maxWidth = new Value() {
/*     */       public float get(@Null Actor param1Actor) {
/* 104 */         if (param1Actor instanceof Layout) return ((Layout)param1Actor).getMaxWidth(); 
/* 105 */         return (param1Actor == null) ? 0.0F : param1Actor.getWidth();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 110 */   public static Value maxHeight = new Value() {
/*     */       public float get(@Null Actor param1Actor) {
/* 112 */         if (param1Actor instanceof Layout) return ((Layout)param1Actor).getMaxHeight(); 
/* 113 */         return (param1Actor == null) ? 0.0F : param1Actor.getHeight();
/*     */       }
/*     */     };
/*     */   public abstract float get(@Null Actor paramActor);
/*     */   
/*     */   public static Value percentWidth(float paramFloat) {
/* 119 */     return new Value(paramFloat) {
/*     */         public float get(@Null Actor param1Actor) {
/* 121 */           return param1Actor.getWidth() * this.a;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public static Value percentHeight(float paramFloat) {
/* 128 */     return new Value(paramFloat) {
/*     */         public float get(@Null Actor param1Actor) {
/* 130 */           return param1Actor.getHeight() * this.a;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public static Value percentWidth(float paramFloat, Actor paramActor) {
/* 137 */     if (paramActor == null) throw new IllegalArgumentException("actor cannot be null."); 
/* 138 */     return new Value(paramActor, paramFloat) {
/*     */         public float get(@Null Actor param1Actor) {
/* 140 */           return this.a.getWidth() * this.b;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public static Value percentHeight(float paramFloat, Actor paramActor) {
/* 147 */     if (paramActor == null) throw new IllegalArgumentException("actor cannot be null."); 
/* 148 */     return new Value(paramActor, paramFloat) {
/*     */         public float get(@Null Actor param1Actor) {
/* 150 */           return this.a.getHeight() * this.b;
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\Value.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */