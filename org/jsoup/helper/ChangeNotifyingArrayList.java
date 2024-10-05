/*    */ package org.jsoup.helper;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ 
/*    */ 
/*    */ public abstract class ChangeNotifyingArrayList<E>
/*    */   extends ArrayList<E>
/*    */ {
/*    */   public ChangeNotifyingArrayList(int paramInt) {
/* 11 */     super(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract void onContentsChanged();
/*    */   
/*    */   public E set(int paramInt, E paramE) {
/* 18 */     onContentsChanged();
/* 19 */     return super.set(paramInt, paramE);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean add(E paramE) {
/* 24 */     onContentsChanged();
/* 25 */     return super.add(paramE);
/*    */   }
/*    */ 
/*    */   
/*    */   public void add(int paramInt, E paramE) {
/* 30 */     onContentsChanged();
/* 31 */     super.add(paramInt, paramE);
/*    */   }
/*    */ 
/*    */   
/*    */   public E remove(int paramInt) {
/* 36 */     onContentsChanged();
/* 37 */     return super.remove(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean remove(Object paramObject) {
/* 42 */     onContentsChanged();
/* 43 */     return super.remove(paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 48 */     onContentsChanged();
/* 49 */     super.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean addAll(Collection<? extends E> paramCollection) {
/* 54 */     onContentsChanged();
/* 55 */     return super.addAll(paramCollection);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
/* 60 */     onContentsChanged();
/* 61 */     return super.addAll(paramInt, paramCollection);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void removeRange(int paramInt1, int paramInt2) {
/* 66 */     onContentsChanged();
/* 67 */     super.removeRange(paramInt1, paramInt2);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean removeAll(Collection<?> paramCollection) {
/* 72 */     onContentsChanged();
/* 73 */     return super.removeAll(paramCollection);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean retainAll(Collection<?> paramCollection) {
/* 78 */     onContentsChanged();
/* 79 */     return super.retainAll(paramCollection);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\helper\ChangeNotifyingArrayList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */