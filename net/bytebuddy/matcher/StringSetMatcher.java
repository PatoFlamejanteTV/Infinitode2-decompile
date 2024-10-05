/*    */ package net.bytebuddy.matcher;
/*    */ 
/*    */ import java.util.Set;
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
/*    */ @Enhance
/*    */ public class StringSetMatcher
/*    */   extends ElementMatcher.Junction.ForNonNullValues<String>
/*    */ {
/*    */   private final Set<String> values;
/*    */   
/*    */   public StringSetMatcher(Set<String> paramSet) {
/* 39 */     this.values = paramSet;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean doMatch(String paramString) {
/* 46 */     return this.values.contains(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 51 */     StringBuilder stringBuilder = new StringBuilder("in(");
/* 52 */     boolean bool = true;
/* 53 */     for (String str : this.values) {
/* 54 */       if (bool) {
/* 55 */         bool = false;
/*    */       } else {
/* 57 */         stringBuilder.append(", ");
/*    */       } 
/* 59 */       stringBuilder.append(str);
/*    */     } 
/* 61 */     return stringBuilder.append(")").toString();
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.values.equals(((StringSetMatcher)paramObject).values)))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return super.hashCode() * 31 + this.values.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\StringSetMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */