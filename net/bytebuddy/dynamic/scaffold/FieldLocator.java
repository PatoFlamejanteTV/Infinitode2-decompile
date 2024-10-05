/*     */ package net.bytebuddy.dynamic.scaffold;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.field.FieldList;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
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
/*     */ public interface FieldLocator
/*     */ {
/*     */   Resolution locate(String paramString);
/*     */   
/*     */   Resolution locate(String paramString, TypeDescription paramTypeDescription);
/*     */   
/*     */   public static interface Resolution
/*     */   {
/*     */     boolean isResolved();
/*     */     
/*     */     FieldDescription getField();
/*     */     
/*     */     public enum Illegal
/*     */       implements Resolution
/*     */     {
/*  77 */       INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final boolean isResolved() {
/*  83 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final FieldDescription getField() {
/*  90 */         throw new IllegalStateException("Could not locate field");
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     public static class Simple
/*     */       implements Resolution
/*     */     {
/*     */       private final FieldDescription fieldDescription;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected Simple(FieldDescription param2FieldDescription) {
/* 111 */         this.fieldDescription = param2FieldDescription;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean isResolved() {
/* 118 */         return true;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public FieldDescription getField() {
/* 125 */         return this.fieldDescription;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.fieldDescription.equals(((Simple)param2Object).fieldDescription))));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.fieldDescription.hashCode();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static interface Factory
/*     */   {
/*     */     FieldLocator make(TypeDescription param1TypeDescription);
/*     */   }
/*     */ 
/*     */   
/*     */   public enum NoOp
/*     */     implements FieldLocator, Factory
/*     */   {
/* 152 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final FieldLocator make(TypeDescription param1TypeDescription) {
/* 158 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final FieldLocator.Resolution locate(String param1String) {
/* 165 */       return FieldLocator.Resolution.Illegal.INSTANCE;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final FieldLocator.Resolution locate(String param1String, TypeDescription param1TypeDescription) {
/* 172 */       return FieldLocator.Resolution.Illegal.INSTANCE;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static abstract class AbstractBase
/*     */     implements FieldLocator
/*     */   {
/*     */     protected final TypeDescription accessingType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected AbstractBase(TypeDescription param1TypeDescription) {
/* 193 */       this.accessingType = param1TypeDescription;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FieldLocator.Resolution locate(String param1String) {
/*     */       FieldList<?> fieldList;
/* 201 */       return (FieldLocator.Resolution)(((fieldList = locate((ElementMatcher<? super FieldDescription>)ElementMatchers.named(param1String).and((ElementMatcher)ElementMatchers.isVisibleTo(this.accessingType)))).size() == 1) ? new FieldLocator.Resolution.Simple((FieldDescription)fieldList
/* 202 */           .getOnly()) : FieldLocator.Resolution.Illegal.INSTANCE);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FieldLocator.Resolution locate(String param1String, TypeDescription param1TypeDescription) {
/*     */       FieldList<?> fieldList;
/* 211 */       return (FieldLocator.Resolution)(((fieldList = locate((ElementMatcher<? super FieldDescription>)ElementMatchers.named(param1String).and((ElementMatcher)ElementMatchers.fieldType(param1TypeDescription)).and((ElementMatcher)ElementMatchers.isVisibleTo(this.accessingType)))).size() == 1) ? new FieldLocator.Resolution.Simple((FieldDescription)fieldList
/* 212 */           .getOnly()) : FieldLocator.Resolution.Illegal.INSTANCE);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract FieldList<?> locate(ElementMatcher<? super FieldDescription> param1ElementMatcher);
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.accessingType.equals(((AbstractBase)param1Object).accessingType))));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.accessingType.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class ForExactType
/*     */     extends AbstractBase
/*     */   {
/*     */     private final TypeDescription typeDescription;
/*     */ 
/*     */     
/*     */     public ForExactType(TypeDescription param1TypeDescription) {
/* 242 */       this(param1TypeDescription, param1TypeDescription);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForExactType(TypeDescription param1TypeDescription1, TypeDescription param1TypeDescription2) {
/* 252 */       super(param1TypeDescription2);
/* 253 */       this.typeDescription = param1TypeDescription1;
/*     */     }
/*     */ 
/*     */     
/*     */     protected FieldList<?> locate(ElementMatcher<? super FieldDescription> param1ElementMatcher) {
/* 258 */       return (FieldList)this.typeDescription.getDeclaredFields().filter(param1ElementMatcher);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return !super.equals(param1Object) ? false : ((this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.typeDescription.equals(((ForExactType)param1Object).typeDescription)))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return super.hashCode() * 31 + this.typeDescription.hashCode();
/*     */     }
/*     */     
/*     */     @Enhance
/*     */     public static class Factory
/*     */       implements FieldLocator.Factory
/*     */     {
/*     */       private final TypeDescription typeDescription;
/*     */       
/*     */       public Factory(TypeDescription param2TypeDescription) {
/* 278 */         this.typeDescription = param2TypeDescription;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public FieldLocator make(TypeDescription param2TypeDescription) {
/* 285 */         return new FieldLocator.ForExactType(this.typeDescription, param2TypeDescription);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.typeDescription.equals(((Factory)param2Object).typeDescription))));
/*     */       }
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @Enhance
/*     */   public static class ForClassHierarchy
/*     */     extends AbstractBase
/*     */   {
/*     */     private final TypeDescription typeDescription;
/*     */     
/*     */     public ForClassHierarchy(TypeDescription param1TypeDescription) {
/* 307 */       this(param1TypeDescription, param1TypeDescription);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForClassHierarchy(TypeDescription param1TypeDescription1, TypeDescription param1TypeDescription2) {
/* 317 */       super(param1TypeDescription2);
/* 318 */       this.typeDescription = param1TypeDescription1;
/*     */     } public boolean equals(@MaybeNull Object param1Object) {
/*     */       return !super.equals(param1Object) ? false : ((this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.typeDescription.equals(((ForClassHierarchy)param1Object).typeDescription)))));
/*     */     }
/*     */     protected FieldList<?> locate(ElementMatcher<? super FieldDescription> param1ElementMatcher) {
/* 323 */       for (Iterator<TypeDefinition> iterator = this.typeDescription.iterator(); iterator.hasNext();) {
/*     */         
/* 325 */         if (!(fieldList = (FieldList)(typeDefinition = iterator.next()).getDeclaredFields().filter(param1ElementMatcher)).isEmpty()) {
/* 326 */           return fieldList;
/*     */         }
/*     */       } 
/* 329 */       return (FieldList<?>)new FieldList.Empty();
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return super.hashCode() * 31 + this.typeDescription.hashCode();
/*     */     }
/*     */     
/*     */     public enum Factory
/*     */       implements FieldLocator.Factory
/*     */     {
/* 340 */       INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final FieldLocator make(TypeDescription param2TypeDescription) {
/* 346 */         return new FieldLocator.ForClassHierarchy(param2TypeDescription);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ForTopLevelType
/*     */     extends AbstractBase
/*     */   {
/*     */     protected ForTopLevelType(TypeDescription param1TypeDescription) {
/* 362 */       super(param1TypeDescription);
/*     */     }
/*     */ 
/*     */     
/*     */     protected FieldList<?> locate(ElementMatcher<? super FieldDescription> param1ElementMatcher) {
/* 367 */       return (FieldList)this.accessingType.getDeclaredFields().filter(param1ElementMatcher);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public enum Factory
/*     */       implements FieldLocator.Factory
/*     */     {
/* 378 */       INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final FieldLocator make(TypeDescription param2TypeDescription) {
/* 384 */         return new FieldLocator.ForTopLevelType(param2TypeDescription);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\scaffold\FieldLocator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */