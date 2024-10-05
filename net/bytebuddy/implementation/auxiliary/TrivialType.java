/*    */ package net.bytebuddy.implementation.auxiliary;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import net.bytebuddy.ByteBuddy;
/*    */ import net.bytebuddy.ClassFileVersion;
/*    */ import net.bytebuddy.description.annotation.AnnotationDescription;
/*    */ import net.bytebuddy.dynamic.DynamicType;
/*    */ import net.bytebuddy.dynamic.scaffold.MethodGraph;
/*    */ import net.bytebuddy.dynamic.scaffold.TypeValidation;
/*    */ import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
/*    */ import net.bytebuddy.implementation.MethodAccessorFactory;
/*    */ import net.bytebuddy.utility.RandomString;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum TrivialType
/*    */   implements AuxiliaryType
/*    */ {
/* 39 */   SIGNATURE_RELEVANT(true),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 44 */   PLAIN(false);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final boolean eager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   TrivialType(boolean paramBoolean) {
/* 57 */     this.eager = paramBoolean;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final String getSuffix() {
/* 64 */     return RandomString.hashOf(name().hashCode());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final DynamicType make(String paramString, ClassFileVersion paramClassFileVersion, MethodAccessorFactory paramMethodAccessorFactory) {
/* 73 */     return (DynamicType)(new ByteBuddy(paramClassFileVersion))
/* 74 */       .with(TypeValidation.DISABLED)
/* 75 */       .with((MethodGraph.Compiler)MethodGraph.Empty.INSTANCE)
/* 76 */       .subclass(Object.class, (ConstructorStrategy)ConstructorStrategy.Default.NO_CONSTRUCTORS)
/* 77 */       .annotateType(this.eager ? 
/* 78 */         Collections.<AnnotationDescription>singletonList(AnnotationDescription.Builder.ofType(AuxiliaryType.SignatureRelevant.class).build(false)) : 
/* 79 */         Collections.emptyList())
/* 80 */       .name(paramString)
/* 81 */       .modifiers(DEFAULT_TYPE_MODIFIER)
/* 82 */       .make();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\auxiliary\TrivialType.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */