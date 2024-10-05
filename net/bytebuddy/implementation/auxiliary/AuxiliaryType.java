/*     */ package net.bytebuddy.implementation.auxiliary;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import net.bytebuddy.ClassFileVersion;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*     */ import net.bytebuddy.description.modifier.ModifierContributor;
/*     */ import net.bytebuddy.description.modifier.SyntheticState;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.DynamicType;
/*     */ import net.bytebuddy.implementation.MethodAccessorFactory;
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
/*     */ public interface AuxiliaryType
/*     */ {
/*     */   @SuppressFBWarnings(value = {"MS_MUTABLE_ARRAY", "MS_OOI_PKGPROTECT"}, justification = "The array is not modified by class contract.")
/*  44 */   public static final ModifierContributor.ForType[] DEFAULT_TYPE_MODIFIER = new ModifierContributor.ForType[] { (ModifierContributor.ForType)SyntheticState.SYNTHETIC };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   DynamicType make(String paramString, ClassFileVersion paramClassFileVersion, MethodAccessorFactory paramMethodAccessorFactory);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getSuffix();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Retention(RetentionPolicy.CLASS)
/*     */   @Target({ElementType.TYPE})
/*     */   public static @interface SignatureRelevant {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface NamingStrategy
/*     */   {
/*     */     String name(TypeDescription param1TypeDescription, AuxiliaryType param1AuxiliaryType);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class Enumerating
/*     */       implements NamingStrategy
/*     */     {
/*     */       private final String suffix;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Enumerating(String param2String) {
/*  96 */         this.suffix = param2String;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public String name(TypeDescription param2TypeDescription, AuxiliaryType param2AuxiliaryType) {
/* 103 */         return param2TypeDescription.getName() + "$" + this.suffix + "$" + RandomString.hashOf(param2AuxiliaryType);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class Suffixing
/*     */       implements NamingStrategy
/*     */     {
/*     */       private final String suffix;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Suffixing(String param2String) {
/* 123 */         this.suffix = param2String;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public String name(TypeDescription param2TypeDescription, AuxiliaryType param2AuxiliaryType) {
/* 130 */         return param2TypeDescription.getName() + "$" + this.suffix + "$" + param2AuxiliaryType.getSuffix();
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     public static class SuffixingRandom
/*     */       implements NamingStrategy
/*     */     {
/*     */       private final String suffix;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
/*     */       private final RandomString randomString;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public SuffixingRandom(String param2String) {
/* 158 */         this.suffix = param2String;
/* 159 */         this.randomString = new RandomString();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public String name(TypeDescription param2TypeDescription, AuxiliaryType param2AuxiliaryType) {
/* 166 */         return param2TypeDescription.getName() + "$" + this.suffix + "$" + this.randomString.nextString();
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.suffix.equals(((SuffixingRandom)param2Object).suffix))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.suffix.hashCode();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\auxiliary\AuxiliaryType.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */