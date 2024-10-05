/*    */ package net.bytebuddy.matcher;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.description.type.TypeDefinition;
/*    */ import net.bytebuddy.description.type.TypeDescription;
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
/*    */ public class CollectionErasureMatcher<T extends Iterable<? extends TypeDefinition>>
/*    */   extends ElementMatcher.Junction.ForNonNullValues<T>
/*    */ {
/*    */   private final ElementMatcher<? super Iterable<? extends TypeDescription>> matcher;
/*    */   
/*    */   public CollectionErasureMatcher(ElementMatcher<? super Iterable<? extends TypeDescription>> paramElementMatcher) {
/* 44 */     this.matcher = paramElementMatcher;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean doMatch(T paramT) {
/* 51 */     ArrayList<TypeDescription> arrayList = new ArrayList();
/* 52 */     for (TypeDefinition typeDefinition : paramT) {
/* 53 */       arrayList.add(typeDefinition.asErasure());
/*    */     }
/* 55 */     return this.matcher.matches(arrayList);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 60 */     return "erasures(" + this.matcher + ')';
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.matcher.equals(((CollectionErasureMatcher)paramObject).matcher)))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return super.hashCode() * 31 + this.matcher.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\CollectionErasureMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */