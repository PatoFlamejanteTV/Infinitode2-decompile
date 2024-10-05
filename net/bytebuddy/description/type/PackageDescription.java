/*     */ package net.bytebuddy.description.type;
/*     */ 
/*     */ import net.bytebuddy.description.NamedElement;
/*     */ import net.bytebuddy.description.annotation.AnnotationList;
/*     */ import net.bytebuddy.description.annotation.AnnotationSource;
/*     */ import net.bytebuddy.utility.nullability.AlwaysNull;
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
/*     */ public interface PackageDescription
/*     */   extends NamedElement.WithRuntimeName, AnnotationSource
/*     */ {
/*  33 */   public static final PackageDescription DEFAULT = new Simple("");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String PACKAGE_CLASS_NAME = "package-info";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int PACKAGE_MODIFIERS = 5632;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @AlwaysNull
/*  49 */   public static final PackageDescription UNDEFINED = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean contains(TypeDescription paramTypeDescription);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class AbstractBase
/*     */     implements PackageDescription
/*     */   {
/*     */     public String getInternalName() {
/*  75 */       return getName().replace('.', '/');
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getActualName() {
/*  82 */       return getName();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean contains(TypeDescription param1TypeDescription) {
/*  89 */       return equals(param1TypeDescription.getPackage());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isDefault() {
/*  96 */       return getName().equals("");
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 101 */       return getName().hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/* 106 */       return (this == param1Object || (param1Object instanceof PackageDescription && getName().equals(((PackageDescription)param1Object).getName())));
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 111 */       return "package " + getName();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Simple
/*     */     extends AbstractBase
/*     */   {
/*     */     private final String name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Simple(String param1String) {
/* 131 */       this.name = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationList getDeclaredAnnotations() {
/* 138 */       return (AnnotationList)new AnnotationList.Empty();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 145 */       return this.name;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ForLoadedPackage
/*     */     extends AbstractBase
/*     */   {
/*     */     private final Package aPackage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForLoadedPackage(Package param1Package) {
/* 166 */       this.aPackage = param1Package;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationList getDeclaredAnnotations() {
/* 173 */       return (AnnotationList)new AnnotationList.ForLoadedAnnotations(this.aPackage.getDeclaredAnnotations());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 180 */       return this.aPackage.getName();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\type\PackageDescription.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */