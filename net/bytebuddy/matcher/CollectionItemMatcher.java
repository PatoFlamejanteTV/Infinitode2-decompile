/*    */ package net.bytebuddy.matcher;
/*    */ 
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.utility.nullability.MaybeNull;
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
/*    */ @Enhance
/*    */ public class CollectionItemMatcher<T>
/*    */   extends ElementMatcher.Junction.ForNonNullValues<Iterable<? extends T>>
/*    */ {
/*    */   private final ElementMatcher<? super T> matcher;
/*    */   
/*    */   public CollectionItemMatcher(ElementMatcher<? super T> paramElementMatcher) {
/* 40 */     this.matcher = paramElementMatcher;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean doMatch(Iterable<? extends T> paramIterable) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   6: astore_1
/*    */     //   7: aload_1
/*    */     //   8: invokeinterface hasNext : ()Z
/*    */     //   13: ifeq -> 41
/*    */     //   16: aload_1
/*    */     //   17: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   22: astore_2
/*    */     //   23: aload_0
/*    */     //   24: getfield matcher : Lnet/bytebuddy/matcher/ElementMatcher;
/*    */     //   27: aload_2
/*    */     //   28: invokeinterface matches : (Ljava/lang/Object;)Z
/*    */     //   33: ifeq -> 38
/*    */     //   36: iconst_1
/*    */     //   37: ireturn
/*    */     //   38: goto -> 7
/*    */     //   41: iconst_0
/*    */     //   42: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #47	-> 0
/*    */     //   #48	-> 23
/*    */     //   #49	-> 36
/*    */     //   #51	-> 38
/*    */     //   #52	-> 41
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 57 */     return "whereOne(" + this.matcher + ")";
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.matcher.equals(((CollectionItemMatcher)paramObject).matcher)))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return super.hashCode() * 31 + this.matcher.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\CollectionItemMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */