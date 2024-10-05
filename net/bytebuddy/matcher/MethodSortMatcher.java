/*     */ package net.bytebuddy.matcher;
/*     */ 
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.method.MethodDescription;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Enhance
/*     */ public class MethodSortMatcher<T extends MethodDescription>
/*     */   extends ElementMatcher.Junction.ForNonNullValues<T>
/*     */ {
/*     */   private final Sort sort;
/*     */   
/*     */   public static <T extends MethodDescription> ElementMatcher.Junction<T> of(Sort paramSort) {
/*  39 */     return (ElementMatcher.Junction)paramSort.getMatcher();
/*     */   }
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
/*     */   public MethodSortMatcher(Sort paramSort) {
/*  53 */     this.sort = paramSort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean doMatch(T paramT) {
/*  60 */     return this.sort.isSort((MethodDescription)paramT);
/*     */   } public boolean equals(@MaybeNull Object paramObject) {
/*     */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.sort.equals(((MethodSortMatcher)paramObject).sort)))));
/*     */   }
/*     */   public String toString() {
/*  65 */     return this.sort.getDescription();
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     return super.hashCode() * 31 + this.sort.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public enum Sort
/*     */   {
/*  76 */     METHOD("isMethod()")
/*     */     {
/*     */       protected final boolean isSort(MethodDescription param2MethodDescription) {
/*  79 */         return param2MethodDescription.isMethod();
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  86 */     CONSTRUCTOR("isConstructor()")
/*     */     {
/*     */       protected final boolean isSort(MethodDescription param2MethodDescription) {
/*  89 */         return param2MethodDescription.isConstructor();
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     TYPE_INITIALIZER("isTypeInitializer()")
/*     */     {
/*     */       protected final boolean isSort(MethodDescription param2MethodDescription) {
/*  99 */         return param2MethodDescription.isTypeInitializer();
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     VIRTUAL("isVirtual()")
/*     */     {
/*     */       protected final boolean isSort(MethodDescription param2MethodDescription) {
/* 109 */         return param2MethodDescription.isVirtual();
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 116 */     DEFAULT_METHOD("isDefaultMethod()")
/*     */     {
/*     */       protected final boolean isSort(MethodDescription param2MethodDescription) {
/* 119 */         return param2MethodDescription.isDefaultMethod();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final String description;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final MethodSortMatcher<?> matcher;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Sort(String param1String1) {
/* 139 */       this.description = param1String1;
/* 140 */       this.matcher = new MethodSortMatcher(this);
/*     */     }
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
/*     */     protected String getDescription() {
/* 157 */       return this.description;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected MethodSortMatcher<?> getMatcher() {
/* 166 */       return this.matcher;
/*     */     }
/*     */     
/*     */     protected abstract boolean isSort(MethodDescription param1MethodDescription);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\MethodSortMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */