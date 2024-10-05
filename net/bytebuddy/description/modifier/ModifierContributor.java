/*     */ package net.bytebuddy.description.modifier;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
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
/*     */ public interface ModifierContributor
/*     */ {
/*     */   public static final int EMPTY_MASK = 0;
/*     */   
/*     */   int getMask();
/*     */   
/*     */   int getRange();
/*     */   
/*     */   boolean isDefault();
/*     */   
/*     */   @Enhance
/*     */   public static class Resolver<T extends ModifierContributor>
/*     */   {
/*     */     private final Collection<? extends T> modifierContributors;
/*     */     
/*     */     protected Resolver(Collection<? extends T> param1Collection) {
/* 132 */       this.modifierContributors = param1Collection;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static Resolver<ModifierContributor.ForType> of(ModifierContributor.ForType... param1VarArgs) {
/* 142 */       return of(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static Resolver<ModifierContributor.ForField> of(ModifierContributor.ForField... param1VarArgs) {
/* 152 */       return of(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static Resolver<ModifierContributor.ForMethod> of(ModifierContributor.ForMethod... param1VarArgs) {
/* 162 */       return of(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static Resolver<ModifierContributor.ForParameter> of(ModifierContributor.ForParameter... param1VarArgs) {
/* 172 */       return of(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static <S extends ModifierContributor> Resolver<S> of(Collection<? extends S> param1Collection) {
/* 183 */       return new Resolver<S>(param1Collection);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int resolve() {
/* 192 */       return resolve(0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int resolve(int param1Int) {
/* 202 */       for (ModifierContributor modifierContributor : this.modifierContributors) {
/* 203 */         param1Int = param1Int & (modifierContributor.getRange() ^ 0xFFFFFFFF) | modifierContributor.getMask();
/*     */       }
/* 205 */       return param1Int;
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.modifierContributors.equals(((Resolver)param1Object).modifierContributors))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.modifierContributors.hashCode();
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface ForParameter extends ModifierContributor {
/*     */     public static final int MASK = 36880;
/*     */   }
/*     */   
/*     */   public static interface ForMethod extends ModifierContributor {
/*     */     public static final int MASK = 7679;
/*     */   }
/*     */   
/*     */   public static interface ForField extends ModifierContributor {
/*     */     public static final int MASK = 151775;
/*     */   }
/*     */   
/*     */   public static interface ForType extends ModifierContributor {
/*     */     public static final int MASK = 161311;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\modifier\ModifierContributor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */