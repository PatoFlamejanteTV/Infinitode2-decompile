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
/*    */ 
/*    */ @Enhance
/*    */ public class ClassLoaderHierarchyMatcher<T extends ClassLoader>
/*    */   extends ElementMatcher.Junction.AbstractBase<T>
/*    */ {
/*    */   private final ElementMatcher<? super ClassLoader> matcher;
/*    */   
/*    */   public ClassLoaderHierarchyMatcher(ElementMatcher<? super ClassLoader> paramElementMatcher) {
/* 41 */     this.matcher = paramElementMatcher;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean matches(@MaybeNull T paramT) {
/* 48 */     paramT = paramT;
/* 49 */     while (paramT != null) {
/* 50 */       if (this.matcher.matches((ClassLoader)paramT)) {
/* 51 */         return true;
/*    */       }
/* 53 */       ClassLoader classLoader = paramT.getParent();
/*    */     } 
/* 55 */     return this.matcher.matches(null);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 60 */     return "hasChild(" + this.matcher + ')';
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.matcher.equals(((ClassLoaderHierarchyMatcher)paramObject).matcher))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return getClass().hashCode() * 31 + this.matcher.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\ClassLoaderHierarchyMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */