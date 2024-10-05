/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Layout;
/*     */ import com.badlogic.gdx.utils.Null;
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
/*  41 */     static final Fixed[] cache = new Fixed[111];
/*     */     
/*     */     private final float value;
/*     */     
/*     */     public Fixed(float param1Float) {
/*  46 */       this.value = param1Float;
/*     */     }
/*     */     
/*     */     public float get(@Null Actor param1Actor) {
/*  50 */       return this.value;
/*     */     }
/*     */     
/*     */     public String toString() {
/*  54 */       return Float.toString(this.value);
/*     */     }
/*     */     
/*     */     public static Fixed valueOf(float param1Float) {
/*  58 */       if (param1Float == 0.0F) return zero; 
/*  59 */       if (param1Float >= -10.0F && param1Float <= 100.0F && param1Float == (int)param1Float) {
/*     */         Fixed fixed;
/*  61 */         if ((fixed = cache[(int)param1Float + 10]) == null) cache[(int)param1Float + 10] = fixed = new Fixed(param1Float); 
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
/*     */   public static Value percentWidth(final float percent) {
/* 119 */     return new Value() {
/*     */         public float get(@Null Actor param1Actor) {
/* 121 */           return param1Actor.getWidth() * percent;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public static Value percentHeight(final float percent) {
/* 128 */     return new Value() {
/*     */         public float get(@Null Actor param1Actor) {
/* 130 */           return param1Actor.getHeight() * percent;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public static Value percentWidth(final float percent, final Actor actor) {
/* 137 */     if (actor == null) throw new IllegalArgumentException("actor cannot be null."); 
/* 138 */     return new Value() {
/*     */         public float get(@Null Actor param1Actor) {
/* 140 */           return actor.getWidth() * percent;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public static Value percentHeight(final float percent, final Actor actor) {
/* 147 */     if (actor == null) throw new IllegalArgumentException("actor cannot be null."); 
/* 148 */     return new Value() {
/*     */         public float get(@Null Actor param1Actor) {
/* 150 */           return actor.getHeight() * percent;
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\Value.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */