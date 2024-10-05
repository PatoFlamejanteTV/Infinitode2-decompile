/*    */ package net.bytebuddy.matcher;
/*    */ 
/*    */ import java.util.List;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Enhance
/*    */ public class CollectionOneToOneMatcher<T>
/*    */   extends ElementMatcher.Junction.ForNonNullValues<Iterable<? extends T>>
/*    */ {
/*    */   private final List<? extends ElementMatcher<? super T>> matchers;
/*    */   
/*    */   public CollectionOneToOneMatcher(List<? extends ElementMatcher<? super T>> paramList) {
/* 47 */     this.matchers = paramList;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean doMatch(Iterable<? extends T> paramIterable) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: instanceof java/util/Collection
/*    */     //   4: ifeq -> 30
/*    */     //   7: aload_1
/*    */     //   8: checkcast java/util/Collection
/*    */     //   11: invokeinterface size : ()I
/*    */     //   16: aload_0
/*    */     //   17: getfield matchers : Ljava/util/List;
/*    */     //   20: invokeinterface size : ()I
/*    */     //   25: if_icmpeq -> 30
/*    */     //   28: iconst_0
/*    */     //   29: ireturn
/*    */     //   30: aload_0
/*    */     //   31: getfield matchers : Ljava/util/List;
/*    */     //   34: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   39: astore_2
/*    */     //   40: aload_1
/*    */     //   41: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   46: astore_1
/*    */     //   47: aload_1
/*    */     //   48: invokeinterface hasNext : ()Z
/*    */     //   53: ifeq -> 95
/*    */     //   56: aload_1
/*    */     //   57: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   62: astore_3
/*    */     //   63: aload_2
/*    */     //   64: invokeinterface hasNext : ()Z
/*    */     //   69: ifeq -> 90
/*    */     //   72: aload_2
/*    */     //   73: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   78: checkcast net/bytebuddy/matcher/ElementMatcher
/*    */     //   81: aload_3
/*    */     //   82: invokeinterface matches : (Ljava/lang/Object;)Z
/*    */     //   87: ifne -> 92
/*    */     //   90: iconst_0
/*    */     //   91: ireturn
/*    */     //   92: goto -> 47
/*    */     //   95: iconst_1
/*    */     //   96: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #54	-> 0
/*    */     //   #55	-> 28
/*    */     //   #57	-> 30
/*    */     //   #58	-> 40
/*    */     //   #59	-> 63
/*    */     //   #60	-> 90
/*    */     //   #62	-> 92
/*    */     //   #63	-> 95
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 68 */     StringBuilder stringBuilder = new StringBuilder("containing(");
/* 69 */     boolean bool = true;
/* 70 */     for (ElementMatcher<? super T> elementMatcher : this.matchers) {
/* 71 */       if (bool) {
/* 72 */         bool = false;
/*    */       } else {
/* 74 */         stringBuilder.append(", ");
/*    */       } 
/* 76 */       stringBuilder.append(elementMatcher);
/*    */     } 
/* 78 */     return stringBuilder.append(')').toString();
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.matchers.equals(((CollectionOneToOneMatcher)paramObject).matchers)))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return super.hashCode() * 31 + this.matchers.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\CollectionOneToOneMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */