/*    */ package com.prineside.tdi2.scene2d.utils;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.OrderedSet;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArraySelection<T>
/*    */   extends Selection<T>
/*    */ {
/*    */   private Array<T> e;
/*    */   private boolean f = true;
/*    */   private T g;
/*    */   
/*    */   public ArraySelection(Array<T> paramArray) {
/* 16 */     this.e = paramArray;
/*    */   }
/*    */   public void choose(T paramT) {
/*    */     int i;
/* 20 */     if (paramT == null) throw new IllegalArgumentException("item cannot be null."); 
/* 21 */     if (this.b)
/*    */       return; 
/* 23 */     if (!this.f || !this.c) {
/* 24 */       super.choose(paramT);
/*    */       
/*    */       return;
/*    */     } 
/* 28 */     if (this.a.size > 0 && UIUtils.shift()) {
/*    */       byte b;
/* 30 */       if ((b = (this.g == null) ? -1 : this.e.indexOf(this.g, false)) != -1) {
/* 31 */         T t = this.g;
/* 32 */         b();
/*    */         
/* 34 */         int j = b; i = this.e.indexOf(paramT, false);
/* 35 */         if (b > i) {
/* 36 */           j = i;
/* 37 */           i = b;
/* 38 */           j = j;
/*    */         } 
/* 40 */         if (!UIUtils.ctrl()) this.a.clear(8); 
/* 41 */         for (j = j; j <= i; j++)
/* 42 */           this.a.add(this.e.get(j)); 
/* 43 */         if (fireChangeEvent()) {
/* 44 */           c();
/*    */         } else {
/* 46 */           a();
/* 47 */         }  this.g = t;
/* 48 */         d();
/*    */         return;
/*    */       } 
/*    */     } 
/* 52 */     super.choose(i);
/* 53 */     this.g = i;
/*    */   }
/*    */ 
/*    */   
/*    */   protected final void a() {
/* 58 */     this.g = null;
/*    */   }
/*    */   
/*    */   public boolean getRangeSelect() {
/* 62 */     return this.f;
/*    */   }
/*    */   
/*    */   public void setRangeSelect(boolean paramBoolean) {
/* 66 */     this.f = paramBoolean;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void validate() {
/*    */     Array<T> array;
/* 73 */     if ((array = this.e).size == 0) {
/* 74 */       clear();
/*    */       return;
/*    */     } 
/* 77 */     boolean bool = false;
/* 78 */     for (OrderedSet.OrderedSetIterator<Object> orderedSetIterator = items().iterator(); orderedSetIterator.hasNext(); ) {
/* 79 */       Object object = orderedSetIterator.next();
/* 80 */       if (!array.contains(object, false)) {
/* 81 */         orderedSetIterator.remove();
/* 82 */         bool = true;
/*    */       } 
/*    */     } 
/* 85 */     if (this.d && this.a.size == 0) {
/* 86 */       set((T)array.first()); return;
/* 87 */     }  if (bool)
/* 88 */       a(); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\utils\ArraySelection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */