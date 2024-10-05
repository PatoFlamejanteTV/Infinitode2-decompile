/*    */ package net.bytebuddy.implementation;
/*    */ 
/*    */ import net.bytebuddy.description.method.MethodDescription;
/*    */ import net.bytebuddy.description.type.TypeDefinition;
/*    */ import net.bytebuddy.dynamic.scaffold.InstrumentedType;
/*    */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*    */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*    */ import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
/*    */ import net.bytebuddy.implementation.bytecode.member.MethodReturn;
/*    */ import net.bytebuddy.jar.asm.MethodVisitor;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum StubMethod
/*    */   implements Implementation.Composable, ByteCodeAppender
/*    */ {
/* 42 */   INSTANCE;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final InstrumentedType prepare(InstrumentedType paramInstrumentedType) {
/* 48 */     return paramInstrumentedType;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final ByteCodeAppender appender(Implementation.Target paramTarget) {
/* 55 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final Implementation andThen(Implementation paramImplementation) {
/* 62 */     return paramImplementation;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final Implementation.Composable andThen(Implementation.Composable paramComposable) {
/* 69 */     return paramComposable;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final ByteCodeAppender.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext, MethodDescription paramMethodDescription) {
/* 81 */     StackManipulation.Size size = (new StackManipulation.Compound(new StackManipulation[] { DefaultValue.of((TypeDefinition)paramMethodDescription.getReturnType()), MethodReturn.of((TypeDefinition)paramMethodDescription.getReturnType()) })).apply(paramMethodVisitor, paramContext);
/* 82 */     return new ByteCodeAppender.Size(size.getMaximalSize(), paramMethodDescription.getStackSize());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\StubMethod.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */