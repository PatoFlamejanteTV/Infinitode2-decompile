/*     */ package net.bytebuddy.matcher;
/*     */ 
/*     */ import java.util.AbstractList;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface FilterableList<T, S extends FilterableList<T, S>>
/*     */   extends List<T>
/*     */ {
/*     */   S filter(ElementMatcher<? super T> paramElementMatcher);
/*     */   
/*     */   T getOnly();
/*     */   
/*     */   S subList(int paramInt1, int paramInt2);
/*     */   
/*     */   public static class Empty<T, S extends FilterableList<T, S>>
/*     */     extends AbstractList<T>
/*     */     implements FilterableList<T, S>
/*     */   {
/*     */     public T get(int param1Int) {
/*  65 */       throw new IndexOutOfBoundsException("index = " + param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/*  72 */       return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public T getOnly() {
/*  79 */       throw new IllegalStateException("size = 0");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public S filter(ElementMatcher<? super T> param1ElementMatcher) {
/*  87 */       return (S)this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public S subList(int param1Int1, int param1Int2) {
/*  95 */       if (param1Int1 == param1Int2 && param1Int2 == 0)
/*  96 */         return (S)this; 
/*  97 */       if (param1Int1 > param1Int2) {
/*  98 */         throw new IllegalArgumentException("fromIndex(" + param1Int1 + ") > toIndex(" + param1Int2 + ")");
/*     */       }
/* 100 */       throw new IndexOutOfBoundsException("fromIndex = " + param1Int1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class AbstractBase<T, S extends FilterableList<T, S>>
/*     */     extends AbstractList<T>
/*     */     implements FilterableList<T, S>
/*     */   {
/*     */     private static final int ONLY = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public S filter(ElementMatcher<? super T> param1ElementMatcher) {
/* 123 */       ArrayList<T> arrayList = new ArrayList(size());
/* 124 */       for (T t : this) {
/* 125 */         if (param1ElementMatcher.matches(t)) {
/* 126 */           arrayList.add(t);
/*     */         }
/*     */       } 
/* 129 */       return (S)((arrayList.size() == size()) ? this : (Object)
/*     */         
/* 131 */         wrap(arrayList));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public T getOnly() {
/* 138 */       if (size() != 1) {
/* 139 */         throw new IllegalStateException("size = " + size());
/*     */       }
/* 141 */       return get(0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public S subList(int param1Int1, int param1Int2) {
/* 148 */       return wrap(super.subList(param1Int1, param1Int2));
/*     */     }
/*     */     
/*     */     protected abstract S wrap(List<T> param1List);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\FilterableList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */