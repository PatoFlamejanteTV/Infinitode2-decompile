/*     */ package net.bytebuddy.matcher;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.util.Iterator;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*     */ import net.bytebuddy.utility.nullability.MaybeNull;
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
/*     */ @Enhance(permitSubclassEquality = true)
/*     */ public class CachingMatcher<T>
/*     */   extends ElementMatcher.Junction.AbstractBase<T>
/*     */ {
/*  36 */   private static final Object NULL_VALUE = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ElementMatcher<? super T> matcher;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
/*     */   protected final ConcurrentMap<? super T, Boolean> map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CachingMatcher(ElementMatcher<? super T> paramElementMatcher, ConcurrentMap<? super T, Boolean> paramConcurrentMap) {
/*  57 */     this.matcher = paramElementMatcher;
/*  58 */     this.map = paramConcurrentMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(@MaybeNull T paramT) {
/*     */     Boolean bool;
/*  68 */     if ((bool = this.map.get((paramT == null) ? NULL_VALUE : paramT)) == null) {
/*  69 */       bool = Boolean.valueOf(onCacheMiss(paramT));
/*     */     }
/*  71 */     return bool.booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean onCacheMiss(@MaybeNull T paramT) {
/*  82 */     boolean bool = this.matcher.matches(paramT);
/*  83 */     this.map.put((paramT == null) ? (T)NULL_VALUE : paramT, 
/*     */         
/*  85 */         Boolean.valueOf(bool));
/*  86 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  91 */     return "cached(" + this.matcher + ")";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return (this == paramObject) ? true : (!(paramObject instanceof CachingMatcher) ? false : (!!this.matcher.equals(((CachingMatcher)paramObject).matcher)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     return CachingMatcher.class.hashCode() * 31 + this.matcher.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SuppressFBWarnings(value = {"EQ_DOESNT_OVERRIDE_EQUALS"}, justification = "Equality does not consider eviction size.")
/*     */   public static class WithInlineEviction<S>
/*     */     extends CachingMatcher<S>
/*     */   {
/*     */     private final int evictionSize;
/*     */ 
/*     */     
/*     */     public WithInlineEviction(ElementMatcher<? super S> param1ElementMatcher, ConcurrentMap<? super S, Boolean> param1ConcurrentMap, int param1Int) {
/* 116 */       super(param1ElementMatcher, param1ConcurrentMap);
/* 117 */       this.evictionSize = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean onCacheMiss(@MaybeNull S param1S) {
/* 124 */       if (this.map.size() >= this.evictionSize) {
/*     */         Iterator<?> iterator;
/* 126 */         (iterator = this.map.entrySet().iterator()).next();
/* 127 */         iterator.remove();
/*     */       } 
/* 129 */       return super.onCacheMiss(param1S);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\CachingMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */