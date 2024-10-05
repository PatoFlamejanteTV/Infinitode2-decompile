/*    */ package net.bytebuddy.matcher;
/*    */ 
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
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
/*    */ @Enhance
/*    */ public class ClassLoaderParentMatcher<T extends ClassLoader>
/*    */   extends ElementMatcher.Junction.AbstractBase<T>
/*    */ {
/*    */   @MaybeNull
/*    */   @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
/*    */   private final ClassLoader classLoader;
/*    */   
/*    */   public ClassLoaderParentMatcher(@MaybeNull ClassLoader paramClassLoader) {
/* 42 */     this.classLoader = paramClassLoader;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean matches(@MaybeNull T paramT) {
/* 49 */     ClassLoader classLoader = this.classLoader;
/* 50 */     while (classLoader != null) {
/* 51 */       if (classLoader == paramT) {
/* 52 */         return true;
/*    */       }
/* 54 */       classLoader = classLoader.getParent();
/*    */     } 
/* 56 */     return (paramT == null);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 61 */     return "isParentOf(" + this.classLoader + ')';
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     ClassLoader classLoader;
/*    */     if (this == paramObject)
/*    */       return true; 
/*    */     if (paramObject == null)
/*    */       return false; 
/*    */     if (getClass() != paramObject.getClass())
/*    */       return false; 
/*    */     paramObject = ((ClassLoaderParentMatcher)paramObject).classLoader;
/*    */     if (paramObject != null) {
/*    */       if ((classLoader = this.classLoader) != null) {
/*    */         if (!classLoader.equals(paramObject))
/*    */           return false; 
/*    */       } else {
/*    */         return false;
/*    */       } 
/*    */     } else if ((classLoader = this.classLoader) != null) {
/*    */       return false;
/*    */     } 
/*    */     return true;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     ClassLoader classLoader;
/*    */     if ((classLoader = this.classLoader) != null);
/*    */     return getClass().hashCode() * 31 + classLoader.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\ClassLoaderParentMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */