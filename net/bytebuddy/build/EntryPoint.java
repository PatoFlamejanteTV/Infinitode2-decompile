/*     */ package net.bytebuddy.build;
/*     */ 
/*     */ import net.bytebuddy.ByteBuddy;
/*     */ import net.bytebuddy.ClassFileVersion;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.ClassFileLocator;
/*     */ import net.bytebuddy.dynamic.DynamicType;
/*     */ import net.bytebuddy.dynamic.scaffold.MethodGraph;
/*     */ import net.bytebuddy.dynamic.scaffold.TypeValidation;
/*     */ import net.bytebuddy.dynamic.scaffold.inline.MethodNameTransformer;
/*     */ import net.bytebuddy.implementation.Implementation;
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
/*     */ public interface EntryPoint
/*     */ {
/*     */   ByteBuddy byteBuddy(ClassFileVersion paramClassFileVersion);
/*     */   
/*     */   DynamicType.Builder<?> transform(TypeDescription paramTypeDescription, ByteBuddy paramByteBuddy, ClassFileLocator paramClassFileLocator, MethodNameTransformer paramMethodNameTransformer);
/*     */   
/*     */   public enum Default
/*     */     implements EntryPoint
/*     */   {
/*  66 */     REBASE
/*     */     {
/*     */       
/*     */       public final ByteBuddy byteBuddy(ClassFileVersion param2ClassFileVersion)
/*     */       {
/*  71 */         return new ByteBuddy(param2ClassFileVersion);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final DynamicType.Builder<?> transform(TypeDescription param2TypeDescription, ByteBuddy param2ByteBuddy, ClassFileLocator param2ClassFileLocator, MethodNameTransformer param2MethodNameTransformer) {
/*  81 */         return param2ByteBuddy.rebase(param2TypeDescription, param2ClassFileLocator, param2MethodNameTransformer);
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  88 */     REDEFINE
/*     */     {
/*     */       
/*     */       public final ByteBuddy byteBuddy(ClassFileVersion param2ClassFileVersion)
/*     */       {
/*  93 */         return new ByteBuddy(param2ClassFileVersion);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final DynamicType.Builder<?> transform(TypeDescription param2TypeDescription, ByteBuddy param2ByteBuddy, ClassFileLocator param2ClassFileLocator, MethodNameTransformer param2MethodNameTransformer) {
/* 103 */         return param2ByteBuddy.redefine(param2TypeDescription, param2ClassFileLocator);
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     REDEFINE_LOCAL
/*     */     {
/*     */       
/*     */       public final ByteBuddy byteBuddy(ClassFileVersion param2ClassFileVersion)
/*     */       {
/* 116 */         return (new ByteBuddy(param2ClassFileVersion)).with((Implementation.Context.Factory)Implementation.Context.Disabled.Factory.INSTANCE);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final DynamicType.Builder<?> transform(TypeDescription param2TypeDescription, ByteBuddy param2ByteBuddy, ClassFileLocator param2ClassFileLocator, MethodNameTransformer param2MethodNameTransformer) {
/* 126 */         return param2ByteBuddy.redefine(param2TypeDescription, param2ClassFileLocator).ignoreAlso((ElementMatcher)ElementMatchers.not((ElementMatcher)ElementMatchers.isDeclaredBy(param2TypeDescription)));
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 134 */     DECORATE
/*     */     {
/*     */       
/*     */       public final ByteBuddy byteBuddy(ClassFileVersion param2ClassFileVersion)
/*     */       {
/* 139 */         return (new ByteBuddy(param2ClassFileVersion))
/* 140 */           .with((MethodGraph.Compiler)MethodGraph.Compiler.ForDeclaredMethods.INSTANCE)
/* 141 */           .with((Implementation.Context.Factory)Implementation.Context.Disabled.Factory.INSTANCE);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final DynamicType.Builder<?> transform(TypeDescription param2TypeDescription, ByteBuddy param2ByteBuddy, ClassFileLocator param2ClassFileLocator, MethodNameTransformer param2MethodNameTransformer) {
/* 151 */         return param2ByteBuddy.decorate(param2TypeDescription, param2ClassFileLocator);
/*     */       }
/*     */     };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   public static class Unvalidated
/*     */     implements EntryPoint
/*     */   {
/*     */     private final EntryPoint delegate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Unvalidated(EntryPoint param1EntryPoint) {
/* 173 */       this.delegate = param1EntryPoint;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteBuddy byteBuddy(ClassFileVersion param1ClassFileVersion) {
/* 180 */       return this.delegate.byteBuddy(param1ClassFileVersion).with(TypeValidation.DISABLED);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DynamicType.Builder<?> transform(TypeDescription param1TypeDescription, ByteBuddy param1ByteBuddy, ClassFileLocator param1ClassFileLocator, MethodNameTransformer param1MethodNameTransformer) {
/* 190 */       return this.delegate.transform(param1TypeDescription, param1ByteBuddy, param1ClassFileLocator, param1MethodNameTransformer);
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.delegate.equals(((Unvalidated)param1Object).delegate))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.delegate.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\build\EntryPoint.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */