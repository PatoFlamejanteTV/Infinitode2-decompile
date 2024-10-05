/*    */ package net.bytebuddy.matcher;
/*    */ 
/*    */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*    */ import java.util.Collection;
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
/*    */ @Enhance
/*    */ public class CollectionSizeMatcher<T extends Iterable<?>>
/*    */   extends ElementMatcher.Junction.ForNonNullValues<T>
/*    */ {
/*    */   private final int size;
/*    */   
/*    */   public CollectionSizeMatcher(int paramInt) {
/* 42 */     this.size = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SuppressFBWarnings(value = {"DLS_DEAD_LOCAL_STORE"}, justification = "Iteration required to count size of an iterable.")
/*    */   protected boolean doMatch(T paramT) {
/* 50 */     if (paramT instanceof Collection) {
/* 51 */       return (((Collection)paramT).size() == this.size);
/*    */     }
/* 53 */     byte b = 0;
/* 54 */     for (Iterator iterator = paramT.iterator(); iterator.hasNext(); ) { iterator.next();
/* 55 */       b++; }
/*    */     
/* 57 */     return (b == this.size);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 63 */     return "ofSize(" + this.size + ')';
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!(this.size != ((CollectionSizeMatcher)paramObject).size)))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return super.hashCode() * 31 + this.size;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\CollectionSizeMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */