/*    */ package com.vladsch.flexmark.util.ast;
/*    */ 
/*    */ import java.util.function.Function;
/*    */ 
/*    */ public class NodeClassifier
/*    */   implements Function<Node, Class<?>>
/*    */ {
/*  8 */   public static final NodeClassifier INSTANCE = new NodeClassifier();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<?> apply(Node paramNode) {
/* 15 */     return paramNode.getClass();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\NodeClassifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */