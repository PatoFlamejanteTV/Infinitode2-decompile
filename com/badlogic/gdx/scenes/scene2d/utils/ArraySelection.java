/*    */ package com.badlogic.gdx.scenes.scene2d.utils;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.OrderedSet;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArraySelection<T>
/*    */   extends Selection<T>
/*    */ {
/*    */   private Array<T> array;
/*    */   private boolean rangeSelect = true;
/*    */   private T rangeStart;
/*    */   
/*    */   public ArraySelection(Array<T> paramArray) {
/* 16 */     this.array = paramArray;
/*    */   }
/*    */   public void choose(T paramT) {
/*    */     int i;
/* 20 */     if (paramT == null) throw new IllegalArgumentException("item cannot be null."); 
/* 21 */     if (this.isDisabled)
/*    */       return; 
/* 23 */     if (!this.rangeSelect || !this.multiple) {
/* 24 */       super.choose(paramT);
/*    */       
/*    */       return;
/*    */     } 
/* 28 */     if (this.selected.size > 0 && UIUtils.shift()) {
/*    */       byte b;
/* 30 */       if ((b = (this.rangeStart == null) ? -1 : this.array.indexOf(this.rangeStart, false)) != -1) {
/* 31 */         T t = this.rangeStart;
/* 32 */         snapshot();
/*    */         
/* 34 */         int j = b; i = this.array.indexOf(paramT, false);
/* 35 */         if (b > i) {
/* 36 */           j = i;
/* 37 */           i = b;
/* 38 */           j = j;
/*    */         } 
/* 40 */         if (!UIUtils.ctrl()) this.selected.clear(8); 
/* 41 */         for (j = j; j <= i; j++)
/* 42 */           this.selected.add(this.array.get(j)); 
/* 43 */         if (fireChangeEvent()) {
/* 44 */           revert();
/*    */         } else {
/* 46 */           changed();
/* 47 */         }  this.rangeStart = t;
/* 48 */         cleanup();
/*    */         return;
/*    */       } 
/*    */     } 
/* 52 */     super.choose(i);
/* 53 */     this.rangeStart = i;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void changed() {
/* 58 */     this.rangeStart = null;
/*    */   }
/*    */   
/*    */   public boolean getRangeSelect() {
/* 62 */     return this.rangeSelect;
/*    */   }
/*    */   
/*    */   public void setRangeSelect(boolean paramBoolean) {
/* 66 */     this.rangeSelect = paramBoolean;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void validate() {
/*    */     Array<T> array;
/* 73 */     if ((array = this.array).size == 0) {
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
/* 85 */     if (this.required && this.selected.size == 0) {
/* 86 */       set((T)array.first()); return;
/* 87 */     }  if (bool)
/* 88 */       changed(); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\utils\ArraySelection.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */