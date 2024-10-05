/*    */ package net.bytebuddy.matcher;
/*    */ 
/*    */ import java.util.Iterator;
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
/*    */ public class CollectionElementMatcher<T>
/*    */   extends ElementMatcher.Junction.ForNonNullValues<Iterable<? extends T>>
/*    */ {
/*    */   private final int index;
/*    */   private final ElementMatcher<? super T> matcher;
/*    */   
/*    */   public CollectionElementMatcher(int paramInt, ElementMatcher<? super T> paramElementMatcher) {
/* 48 */     this.index = paramInt;
/* 49 */     this.matcher = paramElementMatcher;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean doMatch(Iterable<? extends T> paramIterable) {
/* 56 */     Iterator<? extends T> iterator = paramIterable.iterator();
/* 57 */     for (byte b = 0; b < this.index; b++) {
/* 58 */       if (iterator.hasNext()) {
/* 59 */         iterator.next();
/*    */       } else {
/* 61 */         return false;
/*    */       } 
/*    */     } 
/* 64 */     return (iterator.hasNext() && this.matcher.matches(iterator.next()));
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 69 */     return "with(" + this.index + " matches " + this.matcher + ")";
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : ((this.index != ((CollectionElementMatcher)paramObject).index) ? false : (!!this.matcher.equals(((CollectionElementMatcher)paramObject).matcher))))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return (super.hashCode() * 31 + this.index) * 31 + this.matcher.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\CollectionElementMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */