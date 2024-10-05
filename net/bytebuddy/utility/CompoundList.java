/*     */ package net.bytebuddy.utility;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
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
/*     */ public class CompoundList
/*     */ {
/*     */   private CompoundList() {
/*  31 */     throw new UnsupportedOperationException("This class is a utility class and not supposed to be instantiated");
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
/*     */   public static <S> List<S> of(S paramS, List<? extends S> paramList) {
/*  43 */     if (paramList.isEmpty()) {
/*  44 */       return Collections.singletonList(paramS);
/*     */     }
/*     */     ArrayList<S> arrayList;
/*  47 */     (arrayList = new ArrayList<S>(1 + paramList.size())).add(paramS);
/*  48 */     arrayList.addAll(paramList);
/*  49 */     return arrayList;
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
/*     */   public static <S> List<S> of(List<? extends S> paramList, S paramS) {
/*  62 */     if (paramList.isEmpty()) {
/*  63 */       return Collections.singletonList(paramS);
/*     */     }
/*     */     ArrayList<S> arrayList;
/*  66 */     (arrayList = new ArrayList<S>(paramList.size() + 1)).addAll(paramList);
/*  67 */     arrayList.add(paramS);
/*  68 */     return arrayList;
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
/*     */   public static <S> List<S> of(List<? extends S> paramList1, List<? extends S> paramList2) {
/*     */     ArrayList<S> arrayList;
/*  82 */     (arrayList = new ArrayList<S>(paramList1.size() + paramList2.size())).addAll(paramList1);
/*  83 */     arrayList.addAll(paramList2);
/*  84 */     return arrayList;
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
/*     */   public static <S> List<S> of(List<? extends S> paramList1, List<? extends S> paramList2, List<? extends S> paramList3) {
/*     */     ArrayList<S> arrayList;
/*  99 */     (arrayList = new ArrayList<S>(paramList1.size() + paramList2.size() + paramList3.size())).addAll(paramList1);
/* 100 */     arrayList.addAll(paramList2);
/* 101 */     arrayList.addAll(paramList3);
/* 102 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\CompoundList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */