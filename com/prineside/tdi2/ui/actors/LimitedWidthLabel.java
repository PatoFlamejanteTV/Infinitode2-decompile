/*    */ package com.prineside.tdi2.ui.actors;
/*    */ 
/*    */ import com.badlogic.gdx.utils.IntArray;
/*    */ import com.badlogic.gdx.utils.Null;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.utils.StringFormatter;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LimitedWidthLabel
/*    */   extends Label
/*    */ {
/*    */   private float j;
/*    */   private int[] k;
/* 15 */   private static final IntArray l = new IntArray();
/*    */   
/*    */   public LimitedWidthLabel(CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat) {
/* 18 */     super(paramCharSequence, Game.i.assetManager.getLabelStyle(paramInt1));
/*    */     
/* 20 */     this.j = paramFloat;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 25 */     this.k = a(paramInt2, paramInt1);
/*    */     
/* 27 */     setText(paramCharSequence);
/*    */   }
/*    */   
/*    */   private static int[] a(int paramInt1, int paramInt2) {
/* 31 */     l.clear();
/* 32 */     if (paramInt1 != paramInt2) {
/* 33 */       l.add(paramInt1);
/* 34 */       if (paramInt1 < 18 && paramInt2 > 18) {
/* 35 */         l.add(18);
/*    */       }
/* 37 */       if (paramInt1 < 21 && paramInt2 > 21) {
/* 38 */         l.add(21);
/*    */       }
/* 40 */       if (paramInt1 < 24 && paramInt2 > 24) {
/* 41 */         l.add(24);
/*    */       }
/* 43 */       if (paramInt1 < 30 && paramInt2 > 30) {
/* 44 */         l.add(30);
/*    */       }
/* 46 */       if (paramInt1 < 36 && paramInt2 > 36) {
/* 47 */         l.add(36);
/*    */       }
/* 49 */       if (paramInt1 < 60 && paramInt2 > 60) {
/* 50 */         l.add(60);
/*    */       }
/*    */     } 
/* 53 */     l.add(paramInt2);
/*    */     
/* 55 */     return l.toArray();
/*    */   }
/*    */   
/*    */   private static boolean a(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 59 */     if (paramCharSequence1.length() != paramCharSequence2.length() || (paramCharSequence1
/* 60 */       .length() >= 3 && paramCharSequence1
/* 61 */       .charAt(paramCharSequence1.length() - 3) == '.' && paramCharSequence1
/* 62 */       .charAt(paramCharSequence1.length() - 2) == '.' && paramCharSequence1
/* 63 */       .charAt(paramCharSequence1.length() - 1) == '.')) return true;
/*    */     
/*    */     return false;
/*    */   }
/*    */   
/*    */   public void setText(@Null CharSequence paramCharSequence) {
/* 69 */     if (paramCharSequence == null) paramCharSequence = ""; 
/* 70 */     Label.LabelStyle labelStyle2 = getStyle();
/* 71 */     CharSequence charSequence = paramCharSequence;
/* 72 */     int j = this.k.length - 1;
/* 73 */     int i = this.k[j];
/* 74 */     Label.LabelStyle labelStyle1 = Game.i.assetManager.getLabelStyle(i);
/*    */     
/* 76 */     for (; j >= 0 && a(charSequence = StringFormatter.fitToWidth(paramCharSequence, this.j, labelStyle1.font, "..."), paramCharSequence); j--);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 82 */     if (labelStyle1 != getStyle()) {
/* 83 */       setStyle(labelStyle1);
/*    */     }
/*    */     
/* 86 */     super.setText(charSequence);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\LimitedWidthLabel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */