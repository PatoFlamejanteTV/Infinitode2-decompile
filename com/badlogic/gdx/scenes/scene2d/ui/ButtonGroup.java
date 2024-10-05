/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
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
/*     */ 
/*     */ public class ButtonGroup<T extends Button>
/*     */ {
/*  28 */   private final Array<T> buttons = new Array();
/*  29 */   private Array<T> checkedButtons = new Array(1); private int minCheckCount;
/*  30 */   private int maxCheckCount = 1;
/*     */   private boolean uncheckLast = true;
/*     */   private T lastChecked;
/*     */   
/*     */   public ButtonGroup() {
/*  35 */     this.minCheckCount = 1;
/*     */   }
/*     */   
/*     */   public ButtonGroup(T... paramVarArgs) {
/*  39 */     this.minCheckCount = 0;
/*  40 */     add(paramVarArgs);
/*  41 */     this.minCheckCount = 1;
/*     */   }
/*     */   
/*     */   public void add(T paramT) {
/*  45 */     if (paramT == null) throw new IllegalArgumentException("button cannot be null."); 
/*  46 */     ((Button)paramT).buttonGroup = null;
/*  47 */     boolean bool = (paramT.isChecked() || this.buttons.size < this.minCheckCount) ? true : false;
/*  48 */     paramT.setChecked(false);
/*  49 */     ((Button)paramT).buttonGroup = this;
/*  50 */     this.buttons.add(paramT);
/*  51 */     paramT.setChecked(bool);
/*     */   }
/*     */   
/*     */   public void add(T... paramVarArgs) {
/*  55 */     if (paramVarArgs == null) throw new IllegalArgumentException("buttons cannot be null.");  byte b; int i;
/*  56 */     for (b = 0, i = paramVarArgs.length; b < i; b++)
/*  57 */       add(paramVarArgs[b]); 
/*     */   }
/*     */   
/*     */   public void remove(T paramT) {
/*  61 */     if (paramT == null) throw new IllegalArgumentException("button cannot be null."); 
/*  62 */     ((Button)paramT).buttonGroup = null;
/*  63 */     this.buttons.removeValue(paramT, true);
/*  64 */     this.checkedButtons.removeValue(paramT, true);
/*     */   }
/*     */   
/*     */   public void remove(T... paramVarArgs) {
/*  68 */     if (paramVarArgs == null) throw new IllegalArgumentException("buttons cannot be null.");  byte b; int i;
/*  69 */     for (b = 0, i = paramVarArgs.length; b < i; b++)
/*  70 */       remove(paramVarArgs[b]); 
/*     */   }
/*     */   
/*     */   public void clear() {
/*  74 */     this.buttons.clear();
/*  75 */     this.checkedButtons.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setChecked(String paramString) {
/*  80 */     if (paramString == null) throw new IllegalArgumentException("text cannot be null.");  byte b; int i;
/*  81 */     for (b = 0, i = this.buttons.size; b < i; b++) {
/*     */       Button button;
/*  83 */       if (button = (Button)this.buttons.get(b) instanceof TextButton && paramString.contentEquals(((TextButton)button).getText())) {
/*  84 */         button.setChecked(true);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canCheck(T paramT, boolean paramBoolean) {
/*  94 */     if (((Button)paramT).isChecked == paramBoolean) return false;
/*     */     
/*  96 */     if (!paramBoolean) {
/*     */       
/*  98 */       if (this.checkedButtons.size <= this.minCheckCount) return false; 
/*  99 */       this.checkedButtons.removeValue(paramT, true);
/*     */     } else {
/*     */       
/* 102 */       if (this.maxCheckCount != -1 && this.checkedButtons.size >= this.maxCheckCount) {
/* 103 */         if (!this.uncheckLast) return false; 
/* 104 */         byte b = 0; while (true) {
/* 105 */           int i = this.minCheckCount;
/* 106 */           this.minCheckCount = 0;
/* 107 */           this.lastChecked.setChecked(false);
/* 108 */           this.minCheckCount = i;
/* 109 */           if (((Button)paramT).isChecked == paramBoolean) return false; 
/* 110 */           if (this.checkedButtons.size >= this.maxCheckCount) {
/* 111 */             if (b++ > 10) return false;  continue;
/*     */           }  break;
/*     */         } 
/* 114 */       }  this.checkedButtons.add(paramT);
/* 115 */       this.lastChecked = paramT;
/*     */     } 
/*     */     
/* 118 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void uncheckAll() {
/* 123 */     int i = this.minCheckCount;
/* 124 */     this.minCheckCount = 0; byte b; int j;
/* 125 */     for (b = 0, j = this.buttons.size; b < j; b++) {
/*     */       Button button;
/* 127 */       (button = (Button)this.buttons.get(b)).setChecked(false);
/*     */     } 
/* 129 */     this.minCheckCount = i;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public T getChecked() {
/* 134 */     if (this.checkedButtons.size > 0) return (T)this.checkedButtons.get(0); 
/* 135 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCheckedIndex() {
/* 140 */     if (this.checkedButtons.size > 0) return this.buttons.indexOf(this.checkedButtons.get(0), true); 
/* 141 */     return -1;
/*     */   }
/*     */   
/*     */   public Array<T> getAllChecked() {
/* 145 */     return this.checkedButtons;
/*     */   }
/*     */   
/*     */   public Array<T> getButtons() {
/* 149 */     return this.buttons;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMinCheckCount(int paramInt) {
/* 154 */     this.minCheckCount = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaxCheckCount(int paramInt) {
/* 159 */     if (paramInt == 0) paramInt = -1; 
/* 160 */     this.maxCheckCount = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUncheckLast(boolean paramBoolean) {
/* 167 */     this.uncheckLast = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\ButtonGroup.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */