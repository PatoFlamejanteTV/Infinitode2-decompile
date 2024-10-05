/*    */ package net.bytebuddy.implementation.bytecode.constant;
/*    */ 
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.implementation.Implementation;
/*    */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*    */ import net.bytebuddy.implementation.bytecode.StackSize;
/*    */ import net.bytebuddy.jar.asm.MethodVisitor;
/*    */ import net.bytebuddy.utility.nullability.MaybeNull;
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
/*    */ @Enhance
/*    */ public class TextConstant
/*    */   extends StackManipulation.AbstractBase
/*    */ {
/*    */   private final String text;
/*    */   
/*    */   public TextConstant(String paramString) {
/* 41 */     this.text = paramString;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public StackManipulation.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext) {
/* 48 */     paramMethodVisitor.visitLdcInsn(this.text);
/* 49 */     return StackSize.SINGLE.toIncreasingSize();
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.text.equals(((TextConstant)paramObject).text))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return getClass().hashCode() * 31 + this.text.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\constant\TextConstant.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */