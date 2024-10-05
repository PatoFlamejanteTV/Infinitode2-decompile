/*    */ package com.vladsch.flexmark.parser.block;
/*    */ import com.vladsch.flexmark.parser.PostProcessor;
/*    */ import com.vladsch.flexmark.parser.PostProcessorFactory;
/*    */ import com.vladsch.flexmark.util.ast.Document;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import java.util.Arrays;
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.Set;
/*    */ 
/*    */ public abstract class NodePostProcessorFactory implements PostProcessorFactory {
/* 12 */   private final HashMap<Class<?>, Set<Class<?>>> NODE_MAP = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<Class<?>> getAfterDependents() {
/* 21 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<Class<?>> getBeforeDependents() {
/* 27 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean affectsGlobalScope() {
/* 32 */     return false;
/*    */   }
/*    */   
/*    */   protected final void addNodeWithExclusions(Class<? extends Node> paramClass, Class<?>... paramVarArgs) {
/* 36 */     if (paramVarArgs.length > 0) {
/* 37 */       this.NODE_MAP.put(paramClass, new HashSet<>(Arrays.asList(paramVarArgs))); return;
/*    */     } 
/* 39 */     addNodes(new Class[] { paramClass });
/*    */   }
/*    */   protected final void addNodes(Class<?>... paramVarArgs) {
/*    */     int i;
/*    */     byte b;
/* 44 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { Class<?> clazz = paramVarArgs[b];
/*    */       
/* 46 */       this.NODE_MAP.put(clazz, Collections.EMPTY_SET);
/*    */       b++; }
/*    */   
/*    */   }
/*    */   
/*    */   public final Map<Class<?>, Set<Class<?>>> getNodeTypes() {
/* 52 */     return this.NODE_MAP;
/*    */   }
/*    */   
/*    */   public NodePostProcessorFactory(boolean paramBoolean) {}
/*    */   
/*    */   public abstract NodePostProcessor apply(Document paramDocument);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\block\NodePostProcessorFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */