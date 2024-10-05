/*    */ package net.bytebuddy.utility.visitor;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.bytebuddy.dynamic.DynamicType;
/*    */ import net.bytebuddy.implementation.LoadedTypeInitializer;
/*    */ import net.bytebuddy.jar.asm.ClassVisitor;
/*    */ import net.bytebuddy.utility.OpenedClassReader;
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
/*    */ public abstract class ContextClassVisitor
/*    */   extends ClassVisitor
/*    */ {
/*    */   private boolean active;
/*    */   
/*    */   protected ContextClassVisitor(ClassVisitor paramClassVisitor) {
/* 42 */     super(OpenedClassReader.ASM_API, paramClassVisitor);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ContextClassVisitor active() {
/* 51 */     this.active = true;
/* 52 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract List<DynamicType> getAuxiliaryTypes();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract LoadedTypeInitializer getLoadedTypeInitializer();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void visitEnd() {
/* 71 */     super.visitEnd();
/* 72 */     if (!this.active && (!getAuxiliaryTypes().isEmpty() || getLoadedTypeInitializer().isAlive()))
/* 73 */       throw new IllegalStateException(this + " is not defined 'active' but defines auxiliary types or an alive type initializer"); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\visitor\ContextClassVisitor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */