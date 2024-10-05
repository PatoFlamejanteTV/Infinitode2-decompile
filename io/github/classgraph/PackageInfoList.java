/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.util.Collection;
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
/*     */ public class PackageInfoList
/*     */   extends MappableInfoList<PackageInfo>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   PackageInfoList() {}
/*     */   
/*     */   PackageInfoList(int paramInt) {
/*  52 */     super(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PackageInfoList(Collection<PackageInfo> paramCollection) {
/*  62 */     super(paramCollection);
/*     */   }
/*     */ 
/*     */   
/*  66 */   static final PackageInfoList EMPTY_LIST = new PackageInfoList()
/*     */     {
/*     */       private static final long serialVersionUID = 1L;
/*     */ 
/*     */       
/*     */       public final boolean add(PackageInfo param1PackageInfo) {
/*  72 */         throw new IllegalArgumentException("List is immutable");
/*     */       }
/*     */ 
/*     */       
/*     */       public final void add(int param1Int, PackageInfo param1PackageInfo) {
/*  77 */         throw new IllegalArgumentException("List is immutable");
/*     */       }
/*     */ 
/*     */       
/*     */       public final boolean remove(Object param1Object) {
/*  82 */         throw new IllegalArgumentException("List is immutable");
/*     */       }
/*     */ 
/*     */       
/*     */       public final PackageInfo remove(int param1Int) {
/*  87 */         throw new IllegalArgumentException("List is immutable");
/*     */       }
/*     */ 
/*     */       
/*     */       public final boolean addAll(Collection<? extends PackageInfo> param1Collection) {
/*  92 */         throw new IllegalArgumentException("List is immutable");
/*     */       }
/*     */ 
/*     */       
/*     */       public final boolean addAll(int param1Int, Collection<? extends PackageInfo> param1Collection) {
/*  97 */         throw new IllegalArgumentException("List is immutable");
/*     */       }
/*     */ 
/*     */       
/*     */       public final boolean removeAll(Collection<?> param1Collection) {
/* 102 */         throw new IllegalArgumentException("List is immutable");
/*     */       }
/*     */ 
/*     */       
/*     */       public final boolean retainAll(Collection<?> param1Collection) {
/* 107 */         throw new IllegalArgumentException("List is immutable");
/*     */       }
/*     */ 
/*     */       
/*     */       public final void clear() {
/* 112 */         throw new IllegalArgumentException("List is immutable");
/*     */       }
/*     */ 
/*     */       
/*     */       public final PackageInfo set(int param1Int, PackageInfo param1PackageInfo) {
/* 117 */         throw new IllegalArgumentException("List is immutable");
/*     */       }
/*     */     };
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
/*     */   @FunctionalInterface
/*     */   public static interface PackageInfoFilter
/*     */   {
/*     */     boolean accept(PackageInfo param1PackageInfo);
/*     */   }
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
/*     */   public PackageInfoList filter(PackageInfoFilter paramPackageInfoFilter) {
/* 149 */     PackageInfoList packageInfoList = new PackageInfoList();
/* 150 */     for (PackageInfo packageInfo : this) {
/* 151 */       if (paramPackageInfoFilter.accept(packageInfo)) {
/* 152 */         packageInfoList.add(packageInfo);
/*     */       }
/*     */     } 
/* 155 */     return packageInfoList;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\PackageInfoList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */