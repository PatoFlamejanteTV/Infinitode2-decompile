/*     */ package net.bytebuddy.dynamic.scaffold.inline;
/*     */ 
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.utility.RandomString;
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
/*     */ public interface MethodNameTransformer
/*     */ {
/*     */   String transform(MethodDescription paramMethodDescription);
/*     */   
/*     */   @Enhance
/*     */   public static class Suffixing
/*     */     implements MethodNameTransformer
/*     */   {
/*     */     private static final String DEFAULT_SUFFIX = "original$";
/*     */     private final String suffix;
/*     */     
/*     */     public static MethodNameTransformer withRandomSuffix() {
/*  60 */       return new Suffixing("original$" + RandomString.make());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Suffixing(String param1String) {
/*  69 */       this.suffix = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String transform(MethodDescription param1MethodDescription) {
/*  76 */       return param1MethodDescription.getInternalName() + "$" + this.suffix;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.suffix.equals(((Suffixing)param1Object).suffix))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.suffix.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Prefixing
/*     */     implements MethodNameTransformer
/*     */   {
/*     */     private static final String DEFAULT_PREFIX = "original";
/*     */     
/*     */     private final String prefix;
/*     */     
/*     */     public Prefixing() {
/* 100 */       this("original");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Prefixing(String param1String) {
/* 109 */       this.prefix = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String transform(MethodDescription param1MethodDescription) {
/* 116 */       return this.prefix + param1MethodDescription.getInternalName();
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.prefix.equals(((Prefixing)param1Object).prefix))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.prefix.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\scaffold\inline\MethodNameTransformer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */