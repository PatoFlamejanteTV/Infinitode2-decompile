/*     */ package net.bytebuddy.asm;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.field.FieldDescription;
/*     */ import net.bytebuddy.description.field.FieldList;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.method.MethodList;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.jar.asm.ClassVisitor;
/*     */ import net.bytebuddy.jar.asm.FieldVisitor;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.matcher.ElementMatcher;
/*     */ import net.bytebuddy.matcher.ElementMatchers;
/*     */ import net.bytebuddy.pool.TypePool;
/*     */ import net.bytebuddy.utility.CompoundList;
/*     */ import net.bytebuddy.utility.OpenedClassReader;
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
/*     */ @Enhance
/*     */ public class MemberRemoval
/*     */   extends AsmVisitorWrapper.AbstractBase
/*     */ {
/*     */   private final ElementMatcher.Junction<FieldDescription.InDefinedShape> fieldMatcher;
/*     */   private final ElementMatcher.Junction<MethodDescription> methodMatcher;
/*     */   
/*     */   public MemberRemoval() {
/*  73 */     this(ElementMatchers.none(), ElementMatchers.none());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected MemberRemoval(ElementMatcher.Junction<FieldDescription.InDefinedShape> paramJunction, ElementMatcher.Junction<MethodDescription> paramJunction1) {
/*  84 */     this.fieldMatcher = paramJunction;
/*  85 */     this.methodMatcher = paramJunction1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MemberRemoval stripFields(ElementMatcher<? super FieldDescription.InDefinedShape> paramElementMatcher) {
/*  95 */     return new MemberRemoval(this.fieldMatcher.or(paramElementMatcher), this.methodMatcher);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MemberRemoval stripMethods(ElementMatcher<? super MethodDescription> paramElementMatcher) {
/* 106 */     return stripInvokables((ElementMatcher<? super MethodDescription>)ElementMatchers.isMethod().and(paramElementMatcher));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MemberRemoval stripConstructors(ElementMatcher<? super MethodDescription> paramElementMatcher) {
/* 116 */     return stripInvokables((ElementMatcher<? super MethodDescription>)ElementMatchers.isConstructor().and(paramElementMatcher));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MemberRemoval stripInvokables(ElementMatcher<? super MethodDescription> paramElementMatcher) {
/* 127 */     return new MemberRemoval(this.fieldMatcher, this.methodMatcher.or(paramElementMatcher));
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
/*     */   public ClassVisitor wrap(TypeDescription paramTypeDescription, ClassVisitor paramClassVisitor, Implementation.Context paramContext, TypePool paramTypePool, FieldList<FieldDescription.InDefinedShape> paramFieldList, MethodList<?> paramMethodList, int paramInt1, int paramInt2) {
/* 141 */     HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
/* 142 */     for (FieldDescription.InDefinedShape inDefinedShape : paramFieldList) {
/* 143 */       hashMap1.put(inDefinedShape.getInternalName() + inDefinedShape.getDescriptor(), inDefinedShape);
/*     */     }
/* 145 */     HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
/* 146 */     for (MethodDescription methodDescription : CompoundList.of((List)paramMethodList, new MethodDescription.Latent.TypeInitializer(paramTypeDescription))) {
/* 147 */       hashMap2.put(methodDescription.getInternalName() + methodDescription.getDescriptor(), methodDescription);
/*     */     }
/* 149 */     return new MemberRemovingClassVisitor(paramClassVisitor, this.fieldMatcher, this.methodMatcher, (Map)hashMap1, (Map)hashMap2);
/*     */   }
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!this.fieldMatcher.equals(((MemberRemoval)paramObject).fieldMatcher) ? false : (!!this.methodMatcher.equals(((MemberRemoval)paramObject).methodMatcher)))));
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*     */     return (getClass().hashCode() * 31 + this.fieldMatcher.hashCode()) * 31 + this.methodMatcher.hashCode();
/*     */   }
/*     */   
/*     */   protected static class MemberRemovingClassVisitor extends ClassVisitor {
/* 161 */     private static final FieldVisitor REMOVE_FIELD = null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @AlwaysNull
/* 167 */     private static final MethodVisitor REMOVE_METHOD = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final ElementMatcher.Junction<FieldDescription.InDefinedShape> fieldMatcher;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final ElementMatcher.Junction<MethodDescription> methodMatcher;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final Map<String, FieldDescription.InDefinedShape> fields;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final Map<String, MethodDescription> methods;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected MemberRemovingClassVisitor(ClassVisitor param1ClassVisitor, ElementMatcher.Junction<FieldDescription.InDefinedShape> param1Junction, ElementMatcher.Junction<MethodDescription> param1Junction1, Map<String, FieldDescription.InDefinedShape> param1Map, Map<String, MethodDescription> param1Map1) {
/* 203 */       super(OpenedClassReader.ASM_API, param1ClassVisitor);
/* 204 */       this.fieldMatcher = param1Junction;
/* 205 */       this.methodMatcher = param1Junction1;
/* 206 */       this.fields = param1Map;
/* 207 */       this.methods = param1Map1;
/*     */     }
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     public FieldVisitor visitField(int param1Int, String param1String1, String param1String2, @MaybeNull String param1String3, @MaybeNull Object param1Object) {
/*     */       FieldDescription.InDefinedShape inDefinedShape;
/* 214 */       if ((inDefinedShape = this.fields.get(param1String1 + param1String2)) != null && this.fieldMatcher.matches(inDefinedShape)) return REMOVE_FIELD;  return super
/*     */         
/* 216 */         .visitField(param1Int, param1String1, param1String2, param1String3, param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     @MaybeNull
/*     */     public MethodVisitor visitMethod(int param1Int, String param1String1, String param1String2, @MaybeNull String param1String3, @MaybeNull String[] param1ArrayOfString) {
/*     */       MethodDescription methodDescription;
/* 223 */       if ((methodDescription = this.methods.get(param1String1 + param1String2)) != null && this.methodMatcher.matches(methodDescription)) return REMOVE_METHOD;  return super
/*     */         
/* 225 */         .visitMethod(param1Int, param1String1, param1String2, param1String3, param1ArrayOfString);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\asm\MemberRemoval.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */