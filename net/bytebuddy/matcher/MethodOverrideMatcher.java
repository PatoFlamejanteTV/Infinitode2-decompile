/*     */ package net.bytebuddy.matcher;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.type.TypeDefinition;
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
/*     */ @Enhance
/*     */ public class MethodOverrideMatcher<T extends MethodDescription>
/*     */   extends ElementMatcher.Junction.ForNonNullValues<T>
/*     */ {
/*     */   private final ElementMatcher<? super TypeDescription.Generic> matcher;
/*     */   
/*     */   public MethodOverrideMatcher(ElementMatcher<? super TypeDescription.Generic> paramElementMatcher) {
/*  48 */     this.matcher = paramElementMatcher;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean doMatch(T paramT) {
/*  55 */     HashSet<TypeDescription> hashSet = new HashSet();
/*  56 */     for (TypeDefinition typeDefinition : paramT.getDeclaringType()) {
/*  57 */       if (matches((MethodDescription)paramT, typeDefinition) || matches((MethodDescription)paramT, (List<? extends TypeDefinition>)typeDefinition.getInterfaces(), hashSet)) {
/*  58 */         return true;
/*     */       }
/*     */     } 
/*  61 */     return false;
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
/*     */   private boolean matches(MethodDescription paramMethodDescription, List<? extends TypeDefinition> paramList, Set<TypeDescription> paramSet) {
/*  73 */     for (TypeDefinition typeDefinition : paramList) {
/*  74 */       if (paramSet.add(typeDefinition.asErasure()) && (matches(paramMethodDescription, typeDefinition) || matches(paramMethodDescription, (List<? extends TypeDefinition>)typeDefinition.getInterfaces(), paramSet))) {
/*  75 */         return true;
/*     */       }
/*     */     } 
/*  78 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean matches(MethodDescription paramMethodDescription, TypeDefinition paramTypeDefinition) {
/*  89 */     for (Iterator<MethodDescription> iterator = ((MethodList)paramTypeDefinition.getDeclaredMethods().filter(ElementMatchers.isVirtual())).iterator(); iterator.hasNext();) {
/*  90 */       if ((methodDescription = iterator.next()).asSignatureToken().equals(paramMethodDescription.asSignatureToken())) {
/*  91 */         if (this.matcher.matches(paramTypeDefinition.asGenericType())) {
/*  92 */           return true;
/*     */         }
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*  98 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 103 */     return "isOverriddenFrom(" + this.matcher + ")";
/*     */   }
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return !super.equals(paramObject) ? false : ((this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.matcher.equals(((MethodOverrideMatcher)paramObject).matcher)))));
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*     */     return super.hashCode() * 31 + this.matcher.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\matcher\MethodOverrideMatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */