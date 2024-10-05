/*    */ package com.google.common.base;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Iterator;
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
/*    */ @ElementTypesAreNonnullByDefault
/*    */ final class PairwiseEquivalence<E, T extends E>
/*    */   extends Equivalence<Iterable<T>>
/*    */   implements Serializable
/*    */ {
/*    */   final Equivalence<E> elementEquivalence;
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   PairwiseEquivalence(Equivalence<E> paramEquivalence) {
/* 30 */     this.elementEquivalence = Preconditions.<Equivalence<E>>checkNotNull(paramEquivalence);
/*    */   }
/*    */ 
/*    */   
/*    */   protected final boolean doEquivalent(Iterable<T> paramIterable1, Iterable<T> paramIterable2) {
/* 35 */     Iterator<T> iterator1 = paramIterable1.iterator();
/* 36 */     Iterator<T> iterator2 = paramIterable2.iterator();
/*    */     
/* 38 */     while (iterator1.hasNext() && iterator2.hasNext()) {
/* 39 */       if (!this.elementEquivalence.equivalent((E)iterator1.next(), (E)iterator2.next())) {
/* 40 */         return false;
/*    */       }
/*    */     } 
/*    */     
/* 44 */     return (!iterator1.hasNext() && !iterator2.hasNext());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected final int doHash(Iterable<T> paramIterable) {
/*    */     // Byte code:
/*    */     //   0: ldc 78721
/*    */     //   2: istore_2
/*    */     //   3: aload_1
/*    */     //   4: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   9: astore_1
/*    */     //   10: aload_1
/*    */     //   11: invokeinterface hasNext : ()Z
/*    */     //   16: ifeq -> 44
/*    */     //   19: aload_1
/*    */     //   20: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   25: astore_3
/*    */     //   26: iload_2
/*    */     //   27: sipush #24943
/*    */     //   30: imul
/*    */     //   31: aload_0
/*    */     //   32: getfield elementEquivalence : Lcom/google/common/base/Equivalence;
/*    */     //   35: aload_3
/*    */     //   36: invokevirtual hash : (Ljava/lang/Object;)I
/*    */     //   39: iadd
/*    */     //   40: istore_2
/*    */     //   41: goto -> 10
/*    */     //   44: iload_2
/*    */     //   45: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #49	-> 0
/*    */     //   #50	-> 3
/*    */     //   #51	-> 26
/*    */     //   #52	-> 41
/*    */     //   #53	-> 44
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean equals(Object paramObject) {
/* 58 */     if (paramObject instanceof PairwiseEquivalence) {
/* 59 */       paramObject = paramObject;
/* 60 */       return this.elementEquivalence.equals(((PairwiseEquivalence)paramObject).elementEquivalence);
/*    */     } 
/*    */     
/* 63 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int hashCode() {
/* 68 */     return this.elementEquivalence.hashCode() ^ 0x46A3EB07;
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 73 */     String str = String.valueOf(this.elementEquivalence); return (new StringBuilder(11 + String.valueOf(str).length())).append(str).append(".pairwise()").toString();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\PairwiseEquivalence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */