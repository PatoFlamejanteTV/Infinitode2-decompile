/*     */ package net.bytebuddy.agent.builder;
/*     */ 
/*     */ import java.lang.instrument.ClassFileTransformer;
/*     */ import java.lang.instrument.Instrumentation;
/*     */ import java.security.ProtectionDomain;
/*     */ import java.util.Iterator;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.utility.JavaModule;
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
/*     */ public interface ResettableClassFileTransformer
/*     */   extends ClassFileTransformer
/*     */ {
/*     */   Iterator<AgentBuilder.Transformer> iterator(TypeDescription paramTypeDescription, @MaybeNull ClassLoader paramClassLoader, @MaybeNull JavaModule paramJavaModule, @MaybeNull Class<?> paramClass, ProtectionDomain paramProtectionDomain);
/*     */   
/*     */   boolean reset(Instrumentation paramInstrumentation, AgentBuilder.RedefinitionStrategy paramRedefinitionStrategy);
/*     */   
/*     */   boolean reset(Instrumentation paramInstrumentation, AgentBuilder.RedefinitionStrategy paramRedefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator paramBatchAllocator);
/*     */   
/*     */   boolean reset(Instrumentation paramInstrumentation, AgentBuilder.RedefinitionStrategy paramRedefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy paramDiscoveryStrategy);
/*     */   
/*     */   boolean reset(Instrumentation paramInstrumentation, AgentBuilder.RedefinitionStrategy paramRedefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator paramBatchAllocator, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy paramDiscoveryStrategy);
/*     */   
/*     */   boolean reset(Instrumentation paramInstrumentation, AgentBuilder.RedefinitionStrategy paramRedefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy paramDiscoveryStrategy, AgentBuilder.RedefinitionStrategy.Listener paramListener);
/*     */   
/*     */   boolean reset(Instrumentation paramInstrumentation, AgentBuilder.RedefinitionStrategy paramRedefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator paramBatchAllocator, AgentBuilder.RedefinitionStrategy.Listener paramListener);
/*     */   
/*     */   boolean reset(Instrumentation paramInstrumentation, AgentBuilder.RedefinitionStrategy paramRedefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy paramDiscoveryStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator paramBatchAllocator, AgentBuilder.RedefinitionStrategy.Listener paramListener);
/*     */   
/*     */   boolean reset(Instrumentation paramInstrumentation, ResettableClassFileTransformer paramResettableClassFileTransformer, AgentBuilder.RedefinitionStrategy paramRedefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy paramDiscoveryStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator paramBatchAllocator, AgentBuilder.RedefinitionStrategy.Listener paramListener);
/*     */   
/*     */   public static abstract class AbstractBase
/*     */     implements ResettableClassFileTransformer
/*     */   {
/*     */     public boolean reset(Instrumentation param1Instrumentation, AgentBuilder.RedefinitionStrategy param1RedefinitionStrategy) {
/* 284 */       return reset(param1Instrumentation, param1RedefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator.ForTotal.INSTANCE);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean reset(Instrumentation param1Instrumentation, AgentBuilder.RedefinitionStrategy param1RedefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator param1BatchAllocator) {
/* 295 */       return reset(param1Instrumentation, param1RedefinitionStrategy, param1BatchAllocator, AgentBuilder.RedefinitionStrategy.Listener.NoOp.INSTANCE);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean reset(Instrumentation param1Instrumentation, AgentBuilder.RedefinitionStrategy param1RedefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy param1DiscoveryStrategy) {
/* 307 */       return reset(param1Instrumentation, param1RedefinitionStrategy, param1DiscoveryStrategy, AgentBuilder.RedefinitionStrategy.Listener.NoOp.INSTANCE);
/*     */     }
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
/*     */     public boolean reset(Instrumentation param1Instrumentation, AgentBuilder.RedefinitionStrategy param1RedefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator param1BatchAllocator, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy param1DiscoveryStrategy) {
/* 320 */       return reset(param1Instrumentation, param1RedefinitionStrategy, param1DiscoveryStrategy, param1BatchAllocator, AgentBuilder.RedefinitionStrategy.Listener.NoOp.INSTANCE);
/*     */     }
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
/*     */     public boolean reset(Instrumentation param1Instrumentation, AgentBuilder.RedefinitionStrategy param1RedefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy param1DiscoveryStrategy, AgentBuilder.RedefinitionStrategy.Listener param1Listener) {
/* 334 */       return reset(param1Instrumentation, param1RedefinitionStrategy, param1DiscoveryStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator.ForTotal.INSTANCE, param1Listener);
/*     */     }
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
/*     */     public boolean reset(Instrumentation param1Instrumentation, AgentBuilder.RedefinitionStrategy param1RedefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator param1BatchAllocator, AgentBuilder.RedefinitionStrategy.Listener param1Listener) {
/* 348 */       return reset(param1Instrumentation, param1RedefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.SinglePass.INSTANCE, param1BatchAllocator, param1Listener);
/*     */     }
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
/*     */     public boolean reset(Instrumentation param1Instrumentation, AgentBuilder.RedefinitionStrategy param1RedefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy param1DiscoveryStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator param1BatchAllocator, AgentBuilder.RedefinitionStrategy.Listener param1Listener) {
/* 363 */       return reset(param1Instrumentation, this, param1RedefinitionStrategy, param1DiscoveryStrategy, param1BatchAllocator, param1Listener);
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
/*     */   
/*     */   @Enhance
/*     */   public static abstract class WithDelegation
/*     */     extends AbstractBase
/*     */   {
/*     */     protected final ResettableClassFileTransformer classFileTransformer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected WithDelegation(ResettableClassFileTransformer param1ResettableClassFileTransformer) {
/* 390 */       this.classFileTransformer = param1ResettableClassFileTransformer;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Iterator<AgentBuilder.Transformer> iterator(TypeDescription param1TypeDescription, @MaybeNull ClassLoader param1ClassLoader, @MaybeNull JavaModule param1JavaModule, @MaybeNull Class<?> param1Class, ProtectionDomain param1ProtectionDomain) {
/* 401 */       return this.classFileTransformer.iterator(param1TypeDescription, param1ClassLoader, param1JavaModule, param1Class, param1ProtectionDomain);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean reset(Instrumentation param1Instrumentation, ResettableClassFileTransformer param1ResettableClassFileTransformer, AgentBuilder.RedefinitionStrategy param1RedefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy param1DiscoveryStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator param1BatchAllocator, AgentBuilder.RedefinitionStrategy.Listener param1Listener) {
/* 413 */       return this.classFileTransformer.reset(param1Instrumentation, param1ResettableClassFileTransformer, param1RedefinitionStrategy, param1DiscoveryStrategy, param1BatchAllocator, param1Listener);
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.classFileTransformer.equals(((WithDelegation)param1Object).classFileTransformer))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.classFileTransformer.hashCode();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\agent\builder\ResettableClassFileTransformer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */