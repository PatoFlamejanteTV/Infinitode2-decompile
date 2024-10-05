/*    */ package net.bytebuddy.matcher;
/*    */ 
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.description.field.FieldDescription;
/*    */ import net.bytebuddy.description.field.FieldList;
/*    */ import net.bytebuddy.description.type.TypeDefinition;
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
/*    */ public class DeclaringFieldMatcher<T extends TypeDefinition>
/*    */   extends ElementMatcher.Junction.ForNonNullValues<T>
/*    */ {
/*    */   private final ElementMatcher<? super FieldList<?>> matcher;
/*    */   
/*    */   public DeclaringFieldMatcher(ElementMatcher<? super FieldList<? extends FieldDescription>> paramElementMatcher) {
/* 42 */     this.matcher = paramElementMatcher;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean doMatch(T paramT) {
/* 49 */     return this.matcher.matches(paramT.getDeclaredFields());
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 54 */     return "declaresFields(" + this.matcher + ")";
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.matcher.equals(((DeclaringFieldMatcher)paramObject).matcher)))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return super.hashCode() * 31 + this.matcher.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\DeclaringFieldMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */