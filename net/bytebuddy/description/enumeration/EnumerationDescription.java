/*     */ package net.bytebuddy.description.enumeration;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.bytebuddy.build.CachedReturnPlugin.Enhance;
/*     */ import net.bytebuddy.description.NamedElement;
/*     */ import net.bytebuddy.description.type.TypeDescription;
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
/*     */ public interface EnumerationDescription
/*     */   extends NamedElement
/*     */ {
/*     */   String getValue();
/*     */   
/*     */   TypeDescription getEnumerationType();
/*     */   
/*     */   <T extends Enum<T>> T load(Class<T> paramClass);
/*     */   
/*     */   public static abstract class AbstractBase
/*     */     implements EnumerationDescription
/*     */   {
/*     */     public String getActualName() {
/*  64 */       return getValue();
/*     */     } @Enhance("hashCode")
/*     */     public int hashCode() {
/*     */       int j;
/*     */       AbstractBase abstractBase;
/*     */       int i;
/*  70 */       if (!(i = ((j = this.hashCode) != 0) ? 0 : ((abstractBase = this).getValue().hashCode() + 31 * abstractBase.getEnumerationType().hashCode()))) { i = this.hashCode; } else { this.hashCode = i; }  return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*  75 */       if (this == param1Object)
/*  76 */         return true; 
/*  77 */       if (!(param1Object instanceof EnumerationDescription)) {
/*  78 */         return false;
/*     */       }
/*  80 */       param1Object = param1Object;
/*  81 */       return (getEnumerationType().equals(param1Object.getEnumerationType()) && getValue().equals(param1Object.getValue()));
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  86 */       return getValue();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ForLoadedEnumeration
/*     */     extends AbstractBase
/*     */   {
/*     */     private final Enum<?> value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForLoadedEnumeration(Enum<?> param1Enum) {
/* 106 */       this.value = param1Enum;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static List<EnumerationDescription> asList(Enum<?>[] param1ArrayOfEnum) {
/* 116 */       ArrayList<ForLoadedEnumeration> arrayList = new ArrayList(param1ArrayOfEnum.length); int i; byte b;
/* 117 */       for (i = (param1ArrayOfEnum = param1ArrayOfEnum).length, b = 0; b < i; ) { Enum<?> enum_ = param1ArrayOfEnum[b];
/* 118 */         arrayList.add(new ForLoadedEnumeration(enum_)); b++; }
/*     */       
/* 120 */       return (List)arrayList;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getValue() {
/* 127 */       return this.value.name();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeDescription getEnumerationType() {
/* 134 */       return TypeDescription.ForLoadedType.of(this.value.getDeclaringClass());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public <T extends Enum<T>> T load(Class<T> param1Class) {
/* 142 */       return (T)((this.value.getDeclaringClass() == param1Class) ? this.value : 
/*     */         
/* 144 */         (Object)Enum.valueOf(param1Class, this.value.name()));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Latent
/*     */     extends AbstractBase
/*     */   {
/*     */     private final TypeDescription enumerationType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final String value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Latent(TypeDescription param1TypeDescription, String param1String) {
/* 170 */       this.enumerationType = param1TypeDescription;
/* 171 */       this.value = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getValue() {
/* 178 */       return this.value;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeDescription getEnumerationType() {
/* 185 */       return this.enumerationType;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public <T extends Enum<T>> T load(Class<T> param1Class) {
/* 192 */       if (!this.enumerationType.represents(param1Class)) {
/* 193 */         throw new IllegalArgumentException(param1Class + " does not represent " + this.enumerationType);
/*     */       }
/* 195 */       return Enum.valueOf(param1Class, this.value);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\enumeration\EnumerationDescription.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */