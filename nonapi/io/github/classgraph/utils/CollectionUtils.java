/*    */ package nonapi.io.github.classgraph.utils;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Collections;
/*    */ import java.util.Comparator;
/*    */ import java.util.List;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class CollectionUtils
/*    */ {
/*    */   public static <T extends Comparable<? super T>> void sortIfNotEmpty(List<T> paramList) {
/* 58 */     if (paramList.size() > 1) {
/* 59 */       Collections.sort(paramList);
/*    */     }
/*    */   }
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
/*    */ 
/*    */   
/*    */   public static <T> void sortIfNotEmpty(List<T> paramList, Comparator<? super T> paramComparator) {
/* 76 */     if (paramList.size() > 1) {
/* 77 */       Collections.sort(paramList, paramComparator);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T extends Comparable<T>> List<T> sortCopy(Collection<T> paramCollection) {
/* 90 */     if ((paramCollection = new ArrayList<>(paramCollection)).size() > 1) {
/* 91 */       Collections.sort((List<Comparable>)paramCollection);
/*    */     }
/* 93 */     return (List<T>)paramCollection;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgrap\\utils\CollectionUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */