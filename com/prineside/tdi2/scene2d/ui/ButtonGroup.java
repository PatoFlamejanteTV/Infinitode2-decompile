/*     */ package com.prineside.tdi2.scene2d.ui;
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
/*  28 */   private final Array<T> a = new Array();
/*  29 */   private Array<T> b = new Array(1); private int c;
/*  30 */   private int d = 1;
/*     */   private boolean e = true;
/*     */   private T f;
/*     */   
/*     */   public ButtonGroup() {
/*  35 */     this.c = 1;
/*     */   }
/*     */   
/*     */   public ButtonGroup(T... paramVarArgs) {
/*  39 */     this.c = 0;
/*  40 */     add(paramVarArgs);
/*  41 */     this.c = 1;
/*     */   }
/*     */   
/*     */   public void add(T paramT) {
/*  45 */     if (paramT == null) throw new IllegalArgumentException("button cannot be null."); 
/*  46 */     ((Button)paramT).l = null;
/*  47 */     boolean bool = (paramT.isChecked() || this.a.size < this.c) ? true : false;
/*  48 */     paramT.setChecked(false);
/*  49 */     ((Button)paramT).l = this;
/*  50 */     this.a.add(paramT);
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
/*  62 */     ((Button)paramT).l = null;
/*  63 */     this.a.removeValue(paramT, true);
/*  64 */     this.b.removeValue(paramT, true);
/*     */   }
/*     */   
/*     */   public void remove(T... paramVarArgs) {
/*  68 */     if (paramVarArgs == null) throw new IllegalArgumentException("buttons cannot be null.");  byte b; int i;
/*  69 */     for (b = 0, i = paramVarArgs.length; b < i; b++)
/*  70 */       remove(paramVarArgs[b]); 
/*     */   }
/*     */   
/*     */   public void clear() {
/*  74 */     this.a.clear();
/*  75 */     this.b.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setChecked(String paramString) {
/*  80 */     if (paramString == null) throw new IllegalArgumentException("text cannot be null.");  byte b; int i;
/*  81 */     for (b = 0, i = this.a.size; b < i; b++) {
/*     */       Button button;
/*  83 */       if (button = (Button)this.a.get(b) instanceof TextButton && paramString.contentEquals(((TextButton)button).getText())) {
/*  84 */         button.setChecked(true);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean a(T paramT, boolean paramBoolean) {
/*  94 */     if (((Button)paramT).k == paramBoolean) return false;
/*     */     
/*  96 */     if (!paramBoolean) {
/*     */       
/*  98 */       if (this.b.size <= this.c) return false; 
/*  99 */       this.b.removeValue(paramT, true);
/*     */     } else {
/*     */       
/* 102 */       if (this.d != -1 && this.b.size >= this.d) {
/* 103 */         if (!this.e) return false; 
/* 104 */         byte b = 0; while (true) {
/* 105 */           int i = this.c;
/* 106 */           this.c = 0;
/* 107 */           this.f.setChecked(false);
/* 108 */           this.c = i;
/* 109 */           if (((Button)paramT).k == paramBoolean) return false; 
/* 110 */           if (this.b.size >= this.d) {
/* 111 */             if (b++ > 10) return false;  continue;
/*     */           }  break;
/*     */         } 
/* 114 */       }  this.b.add(paramT);
/* 115 */       this.f = paramT;
/*     */     } 
/*     */     
/* 118 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void uncheckAll() {
/* 123 */     int i = this.c;
/* 124 */     this.c = 0; byte b; int j;
/* 125 */     for (b = 0, j = this.a.size; b < j; b++) {
/*     */       Button button;
/* 127 */       (button = (Button)this.a.get(b)).setChecked(false);
/*     */     } 
/* 129 */     this.c = i;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public T getChecked() {
/* 134 */     if (this.b.size > 0) return (T)this.b.get(0); 
/* 135 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCheckedIndex() {
/* 140 */     if (this.b.size > 0) return this.a.indexOf(this.b.get(0), true); 
/* 141 */     return -1;
/*     */   }
/*     */   
/*     */   public Array<T> getAllChecked() {
/* 145 */     return this.b;
/*     */   }
/*     */   
/*     */   public Array<T> getButtons() {
/* 149 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMinCheckCount(int paramInt) {
/* 154 */     this.c = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaxCheckCount(int paramInt) {
/* 159 */     if (paramInt == 0) paramInt = -1; 
/* 160 */     this.d = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUncheckLast(boolean paramBoolean) {
/* 167 */     this.e = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\ButtonGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */