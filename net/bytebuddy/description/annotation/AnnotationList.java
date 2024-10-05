/*     */ package net.bytebuddy.description.annotation;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.description.type.TypeList;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.FilterableList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface AnnotationList
/*     */   extends FilterableList<AnnotationDescription, AnnotationList>
/*     */ {
/*     */   boolean isAnnotationPresent(Class<? extends Annotation> paramClass);
/*     */   
/*     */   boolean isAnnotationPresent(TypeDescription paramTypeDescription);
/*     */   
/*     */   @MaybeNull
/*     */   <T extends Annotation> AnnotationDescription.Loadable<T> ofType(Class<T> paramClass);
/*     */   
/*     */   AnnotationDescription ofType(TypeDescription paramTypeDescription);
/*     */   
/*     */   AnnotationList inherited(Set<? extends TypeDescription> paramSet);
/*     */   
/*     */   AnnotationList visibility(ElementMatcher<? super RetentionPolicy> paramElementMatcher);
/*     */   
/*     */   TypeList asTypeList();
/*     */   
/*     */   public static abstract class AbstractBase
/*     */     extends FilterableList.AbstractBase<AnnotationDescription, AnnotationList>
/*     */     implements AnnotationList
/*     */   {
/*     */     public boolean isAnnotationPresent(Class<? extends Annotation> param1Class) {
/* 104 */       for (Iterator<AnnotationDescription> iterator = iterator(); iterator.hasNext();) {
/* 105 */         if ((annotationDescription = iterator.next()).getAnnotationType().represents(param1Class)) {
/* 106 */           return true;
/*     */         }
/*     */       } 
/* 109 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isAnnotationPresent(TypeDescription param1TypeDescription) {
/* 116 */       for (Iterator<AnnotationDescription> iterator = iterator(); iterator.hasNext();) {
/* 117 */         if ((annotationDescription = iterator.next()).getAnnotationType().equals(param1TypeDescription)) {
/* 118 */           return true;
/*     */         }
/*     */       } 
/* 121 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     public <T extends Annotation> AnnotationDescription.Loadable<T> ofType(Class<T> param1Class) {
/* 130 */       for (Iterator<AnnotationDescription> iterator = iterator(); iterator.hasNext();) {
/* 131 */         if ((annotationDescription = iterator.next()).getAnnotationType().represents(param1Class)) {
/* 132 */           return annotationDescription.prepare(param1Class);
/*     */         }
/*     */       } 
/* 135 */       return (AnnotationDescription.Loadable)AnnotationDescription.UNDEFINED;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     public AnnotationDescription ofType(TypeDescription param1TypeDescription) {
/* 143 */       for (Iterator<AnnotationDescription> iterator = iterator(); iterator.hasNext();) {
/* 144 */         if ((annotationDescription = iterator.next()).getAnnotationType().equals(param1TypeDescription)) {
/* 145 */           return annotationDescription;
/*     */         }
/*     */       } 
/* 148 */       return AnnotationDescription.UNDEFINED;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationList inherited(Set<? extends TypeDescription> param1Set) {
/* 155 */       ArrayList<AnnotationDescription> arrayList = new ArrayList(size());
/* 156 */       for (AnnotationDescription annotationDescription : this) {
/* 157 */         if (!param1Set.contains(annotationDescription.getAnnotationType()) && annotationDescription.isInherited()) {
/* 158 */           arrayList.add(annotationDescription);
/*     */         }
/*     */       } 
/* 161 */       return wrap(arrayList);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationList visibility(ElementMatcher<? super RetentionPolicy> param1ElementMatcher) {
/* 168 */       ArrayList<AnnotationDescription> arrayList = new ArrayList(size());
/* 169 */       for (AnnotationDescription annotationDescription : this) {
/* 170 */         if (param1ElementMatcher.matches(annotationDescription.getRetention())) {
/* 171 */           arrayList.add(annotationDescription);
/*     */         }
/*     */       } 
/* 174 */       return wrap(arrayList);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeList asTypeList() {
/* 181 */       ArrayList<TypeDescription> arrayList = new ArrayList(size());
/* 182 */       for (AnnotationDescription annotationDescription : this) {
/* 183 */         arrayList.add(annotationDescription.getAnnotationType());
/*     */       }
/* 185 */       return (TypeList)new TypeList.Explicit(arrayList);
/*     */     }
/*     */ 
/*     */     
/*     */     protected AnnotationList wrap(List<AnnotationDescription> param1List) {
/* 190 */       return new AnnotationList.Explicit(param1List);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ForLoadedAnnotations
/*     */     extends AbstractBase
/*     */   {
/*     */     private final List<? extends Annotation> annotations;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForLoadedAnnotations(Annotation... param1VarArgs) {
/* 210 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ForLoadedAnnotations(List<? extends Annotation> param1List) {
/* 219 */       this.annotations = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static List<AnnotationList> asList(Annotation[][] param1ArrayOfAnnotation) {
/* 229 */       ArrayList<ForLoadedAnnotations> arrayList = new ArrayList(param1ArrayOfAnnotation.length); int i; byte b;
/* 230 */       for (i = (param1ArrayOfAnnotation = param1ArrayOfAnnotation).length, b = 0; b < i; ) { Annotation[] arrayOfAnnotation = param1ArrayOfAnnotation[b];
/* 231 */         arrayList.add(new ForLoadedAnnotations(arrayOfAnnotation)); b++; }
/*     */       
/* 233 */       return (List)arrayList;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationDescription get(int param1Int) {
/* 240 */       return AnnotationDescription.ForLoadedAnnotation.of(this.annotations.get(param1Int));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 247 */       return this.annotations.size();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Explicit
/*     */     extends AbstractBase
/*     */   {
/*     */     private final List<? extends AnnotationDescription> annotationDescriptions;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Explicit(AnnotationDescription... param1VarArgs) {
/* 267 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Explicit(List<? extends AnnotationDescription> param1List) {
/* 276 */       this.annotationDescriptions = param1List;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static List<AnnotationList> asList(List<? extends List<? extends AnnotationDescription>> param1List) {
/* 286 */       ArrayList<Explicit> arrayList = new ArrayList(param1List.size());
/* 287 */       for (List<? extends AnnotationDescription> list : param1List) {
/* 288 */         arrayList.add(new Explicit(list));
/*     */       }
/* 290 */       return (List)arrayList;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationDescription get(int param1Int) {
/* 297 */       return this.annotationDescriptions.get(param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 304 */       return this.annotationDescriptions.size();
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
/*     */   public static class Empty
/*     */     extends FilterableList.Empty<AnnotationDescription, AnnotationList>
/*     */     implements AnnotationList
/*     */   {
/*     */     public static List<AnnotationList> asList(int param1Int) {
/* 320 */       ArrayList<Empty> arrayList = new ArrayList(param1Int);
/* 321 */       for (byte b = 0; b < param1Int; b++) {
/* 322 */         arrayList.add(new Empty());
/*     */       }
/* 324 */       return (List)arrayList;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isAnnotationPresent(Class<? extends Annotation> param1Class) {
/* 331 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isAnnotationPresent(TypeDescription param1TypeDescription) {
/* 338 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @AlwaysNull
/*     */     public <T extends Annotation> AnnotationDescription.Loadable<T> ofType(Class<T> param1Class) {
/* 347 */       return (AnnotationDescription.Loadable)AnnotationDescription.UNDEFINED;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @AlwaysNull
/*     */     public AnnotationDescription ofType(TypeDescription param1TypeDescription) {
/* 355 */       return AnnotationDescription.UNDEFINED;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationList inherited(Set<? extends TypeDescription> param1Set) {
/* 362 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationList visibility(ElementMatcher<? super RetentionPolicy> param1ElementMatcher) {
/* 369 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TypeList asTypeList() {
/* 376 */       return (TypeList)new TypeList.Empty();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\annotation\AnnotationList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */