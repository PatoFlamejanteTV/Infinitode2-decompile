/*     */ package net.bytebuddy.matcher;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.utility.nullability.MaybeNull;
/*     */ import net.bytebuddy.utility.nullability.UnknownNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface ElementMatcher<T>
/*     */ {
/*     */   boolean matches(@UnknownNull T paramT);
/*     */   
/*     */   public static interface Junction<S>
/*     */     extends ElementMatcher<S>
/*     */   {
/*     */     <U extends S> Junction<U> and(ElementMatcher<? super U> param1ElementMatcher);
/*     */     
/*     */     <U extends S> Junction<U> or(ElementMatcher<? super U> param1ElementMatcher);
/*     */     
/*     */     public static abstract class AbstractBase<V>
/*     */       implements Junction<V>
/*     */     {
/*     */       public <U extends V> ElementMatcher.Junction<U> and(ElementMatcher<? super U> param2ElementMatcher) {
/*  89 */         return new ElementMatcher.Junction.Conjunction<U>((ElementMatcher<? super U>[])new ElementMatcher[] { this, param2ElementMatcher });
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public <U extends V> ElementMatcher.Junction<U> or(ElementMatcher<? super U> param2ElementMatcher) {
/*  97 */         return new ElementMatcher.Junction.Disjunction<U>((ElementMatcher<? super U>[])new ElementMatcher[] { this, param2ElementMatcher });
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     public static class Conjunction<W>
/*     */       extends AbstractBase<W>
/*     */     {
/*     */       private final List<ElementMatcher<? super W>> matchers;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Conjunction(ElementMatcher<? super W>... param2VarArgs) {
/* 121 */         this(Arrays.asList(param2VarArgs));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Conjunction(List<ElementMatcher<? super W>> param2List) {
/* 131 */         this.matchers = new ArrayList<ElementMatcher<? super W>>(param2List.size());
/* 132 */         for (Iterator<ElementMatcher<? super W>> iterator = param2List.iterator(); iterator.hasNext(); ) {
/* 133 */           ElementMatcher<? super W> elementMatcher; if (elementMatcher = iterator.next() instanceof Conjunction) {
/* 134 */             this.matchers.addAll(((Conjunction)elementMatcher).matchers); continue;
/*     */           } 
/* 136 */           this.matchers.add(elementMatcher);
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean matches(@UnknownNull W param2W) {
/* 145 */         for (Iterator<ElementMatcher<? super W>> iterator = this.matchers.iterator(); iterator.hasNext();) {
/* 146 */           if (!(elementMatcher = (ElementMatcher)iterator.next()).matches(param2W)) {
/* 147 */             return false;
/*     */           }
/*     */         } 
/* 150 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public String toString() {
/* 155 */         StringBuilder stringBuilder = new StringBuilder("(");
/* 156 */         boolean bool = true;
/* 157 */         for (ElementMatcher<? super W> elementMatcher : this.matchers) {
/* 158 */           if (bool) {
/* 159 */             bool = false;
/*     */           } else {
/* 161 */             stringBuilder.append(" and ");
/*     */           } 
/* 163 */           stringBuilder.append(elementMatcher);
/*     */         } 
/* 165 */         return stringBuilder.append(")").toString();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.matchers.equals(((Conjunction)param2Object).matchers))));
/*     */       }
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.matchers.hashCode();
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     public static class Disjunction<W>
/*     */       extends AbstractBase<W>
/*     */     {
/*     */       private final List<ElementMatcher<? super W>> matchers;
/*     */ 
/*     */       
/*     */       public Disjunction(ElementMatcher<? super W>... param2VarArgs) {
/* 189 */         this(Arrays.asList(param2VarArgs));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Disjunction(List<ElementMatcher<? super W>> param2List) {
/* 199 */         this.matchers = new ArrayList<ElementMatcher<? super W>>(param2List.size());
/* 200 */         for (Iterator<ElementMatcher<? super W>> iterator = param2List.iterator(); iterator.hasNext(); ) {
/* 201 */           ElementMatcher<? super W> elementMatcher; if (elementMatcher = iterator.next() instanceof Disjunction) {
/* 202 */             this.matchers.addAll(((Disjunction)elementMatcher).matchers); continue;
/*     */           } 
/* 204 */           this.matchers.add(elementMatcher);
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean matches(@UnknownNull W param2W) {
/* 213 */         for (Iterator<ElementMatcher<? super W>> iterator = this.matchers.iterator(); iterator.hasNext();) {
/* 214 */           if ((elementMatcher = (ElementMatcher)iterator.next()).matches(param2W)) {
/* 215 */             return true;
/*     */           }
/*     */         } 
/* 218 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public String toString() {
/* 223 */         StringBuilder stringBuilder = new StringBuilder("(");
/* 224 */         boolean bool = true;
/* 225 */         for (ElementMatcher<? super W> elementMatcher : this.matchers) {
/* 226 */           if (bool) {
/* 227 */             bool = false;
/*     */           } else {
/* 229 */             stringBuilder.append(" or ");
/*     */           } 
/* 231 */           stringBuilder.append(elementMatcher);
/*     */         } 
/* 233 */         return stringBuilder.append(")").toString();
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.matchers.equals(((Disjunction)param2Object).matchers))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.matchers.hashCode();
/*     */       }
/*     */     }
/*     */     
/*     */     @Enhance
/*     */     public static abstract class ForNonNullValues<W>
/*     */       extends AbstractBase<W> {
/*     */       public boolean matches(@MaybeNull W param2W) {
/* 249 */         return (param2W != null && doMatch(param2W));
/*     */       }
/*     */       
/*     */       protected abstract boolean doMatch(W param2W);
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : (!(getClass() != param2Object.getClass())));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\ElementMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */