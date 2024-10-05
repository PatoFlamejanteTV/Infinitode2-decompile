/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.Sort;
/*    */ import com.prineside.tdi2.utils.logging.TLog;
/*    */ import java.util.Comparator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class FloatSorter
/*    */ {
/*    */   public static final Comparator<Entity> COMPARATOR;
/*    */   private final Sort a;
/*    */   private final Array<Entity> b;
/*    */   
/*    */   static {
/* 25 */     TLog.forClass(FloatSorter.class);
/*    */     
/* 27 */     COMPARATOR = ((paramEntity1, paramEntity2) -> Float.compare(paramEntity1.value, paramEntity2.value));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 34 */   private int c = 0;
/*    */   private boolean d;
/*    */   
/*    */   public FloatSorter() {
/* 38 */     this.b = new Array(true, 1, Entity.class);
/* 39 */     this.a = new Sort();
/*    */   }
/*    */   
/*    */   public FloatSorter(Sort paramSort) {
/* 43 */     this.b = new Array(true, 1, Entity.class);
/* 44 */     this.a = paramSort;
/*    */   }
/*    */   
/*    */   private void a() {
/* 48 */     if (!this.d) throw new IllegalStateException("begin() has not been called yet"); 
/*    */   }
/*    */   
/*    */   public final void begin() {
/* 52 */     if (this.d) throw new IllegalStateException("Previous sorting not finished, call end() before starting another one"); 
/* 53 */     this.b.clear();
/* 54 */     this.d = true;
/*    */   }
/*    */   public final void add(Object paramObject, float paramFloat) {
/*    */     Entity entity;
/* 58 */     a();
/*    */     
/* 60 */     if (this.c > this.b.size) {
/*    */       
/* 62 */       entity = ((Entity[])this.b.items)[this.b.size];
/* 63 */       this.b.size++;
/*    */     } else {
/*    */       
/* 66 */       entity = new Entity();
/* 67 */       this.b.add(entity);
/* 68 */       this.c++;
/*    */     } 
/* 70 */     entity.object = paramObject;
/* 71 */     entity.value = paramFloat;
/*    */   }
/*    */   
/*    */   public final int getCount() {
/* 75 */     return this.b.size;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final Array<Entity> sort() {
/* 82 */     a();
/* 83 */     this.a.sort(this.b.items, COMPARATOR, 0, this.b.size);
/* 84 */     return this.b;
/*    */   }
/*    */   
/*    */   public final void end() {
/* 88 */     a(); byte b; int i;
/* 89 */     for (b = 0, i = this.b.size; b < i; b++) {
/* 90 */       (((Entity[])this.b.items)[b]).object = null;
/*    */     }
/* 92 */     this.b.size = 0;
/* 93 */     this.d = false;
/*    */   }
/*    */   
/*    */   public static final class Entity {
/*    */     public Object object;
/*    */     public float value;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\FloatSorter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */