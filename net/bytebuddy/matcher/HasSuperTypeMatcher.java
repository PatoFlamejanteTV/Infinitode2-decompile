/*    */ package net.bytebuddy.matcher;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.HashSet;
/*    */ import java.util.Queue;
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.description.type.TypeDefinition;
/*    */ import net.bytebuddy.description.type.TypeDescription;
/*    */ import net.bytebuddy.utility.QueueFactory;
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
/*    */ public class HasSuperTypeMatcher<T extends TypeDescription>
/*    */   extends ElementMatcher.Junction.ForNonNullValues<T>
/*    */ {
/*    */   private final ElementMatcher<? super TypeDescription.Generic> matcher;
/*    */   
/*    */   public HasSuperTypeMatcher(ElementMatcher<? super TypeDescription.Generic> paramElementMatcher) {
/* 46 */     this.matcher = paramElementMatcher;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean doMatch(T paramT) {
/* 53 */     HashSet<TypeDescription> hashSet = new HashSet();
/* 54 */     for (TypeDefinition typeDefinition : paramT) {
/* 55 */       if (!hashSet.add(typeDefinition.asErasure()))
/* 56 */         return false; 
/* 57 */       if (this.matcher.matches(typeDefinition.asGenericType())) {
/* 58 */         return true;
/*    */       }
/* 60 */       Queue<TypeDefinition> queue = QueueFactory.make((Collection)typeDefinition.getInterfaces());
/* 61 */       while (!queue.isEmpty()) {
/* 62 */         TypeDefinition typeDefinition1 = queue.remove();
/* 63 */         if (hashSet.add(typeDefinition1.asErasure())) {
/* 64 */           if (this.matcher.matches(typeDefinition1.asGenericType())) {
/* 65 */             return true;
/*    */           }
/* 67 */           queue.addAll((Collection<? extends TypeDefinition>)typeDefinition1.getInterfaces());
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 72 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 77 */     return "hasSuperType(" + this.matcher + ")";
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.matcher.equals(((HasSuperTypeMatcher)paramObject).matcher)))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return super.hashCode() * 31 + this.matcher.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\HasSuperTypeMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */