/*    */ package net.bytebuddy.matcher;
/*    */ 
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.description.NamedElement;
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
/*    */ public class DescriptorMatcher<T extends NamedElement.WithDescriptor>
/*    */   extends ElementMatcher.Junction.ForNonNullValues<T>
/*    */ {
/*    */   private final ElementMatcher<String> matcher;
/*    */   
/*    */   public DescriptorMatcher(ElementMatcher<String> paramElementMatcher) {
/* 40 */     this.matcher = paramElementMatcher;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean doMatch(T paramT) {
/* 47 */     return this.matcher.matches(paramT.getDescriptor());
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 52 */     return "hasDescriptor(" + this.matcher + ")";
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.matcher.equals(((DescriptorMatcher)paramObject).matcher)))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return super.hashCode() * 31 + this.matcher.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\DescriptorMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */