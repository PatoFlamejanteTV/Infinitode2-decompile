/*     */ package com.vladsch.flexmark.util.ast;
/*     */ 
/*     */ import com.vladsch.flexmark.util.visitor.AstActionHandler;
/*     */ import com.vladsch.flexmark.util.visitor.AstHandler;
/*     */ import java.util.Collection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NodeVisitor
/*     */   extends AstActionHandler<NodeVisitor, Node, Visitor<Node>, VisitHandler<Node>>
/*     */   implements NodeVisitHandler
/*     */ {
/*  67 */   protected static final VisitHandler[] EMPTY_HANDLERS = new VisitHandler[0];
/*     */   
/*     */   public NodeVisitor() {
/*  70 */     super(Node.AST_ADAPTER);
/*     */   }
/*     */   
/*     */   public NodeVisitor(VisitHandler... paramVarArgs) {
/*  74 */     super(Node.AST_ADAPTER);
/*  75 */     addActionHandlers((AstHandler[][])new VisitHandler[][] { paramVarArgs });
/*     */   }
/*     */   
/*     */   public NodeVisitor(VisitHandler[]... paramVarArgs) {
/*  79 */     super(Node.AST_ADAPTER);
/*     */     
/*  81 */     addActionHandlers((AstHandler[][])paramVarArgs);
/*     */   }
/*     */   
/*     */   public NodeVisitor(Collection<VisitHandler> paramCollection) {
/*  85 */     super(Node.AST_ADAPTER);
/*  86 */     addHandlers(paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   public NodeVisitor addTypedHandlers(Collection<VisitHandler<?>> paramCollection) {
/*  91 */     return (NodeVisitor)addActionHandlers((AstHandler[][])new VisitHandler[][] { paramCollection.<VisitHandler>toArray(EMPTY_HANDLERS) });
/*     */   }
/*     */ 
/*     */   
/*     */   public NodeVisitor addHandlers(Collection<VisitHandler> paramCollection) {
/*  96 */     return (NodeVisitor)addActionHandlers((AstHandler[][])new VisitHandler[][] { paramCollection.<VisitHandler>toArray(EMPTY_HANDLERS) });
/*     */   }
/*     */   
/*     */   public NodeVisitor addHandlers(VisitHandler[] paramArrayOfVisitHandler) {
/* 100 */     return (NodeVisitor)addActionHandlers((AstHandler[][])new VisitHandler[][] { paramArrayOfVisitHandler });
/*     */   }
/*     */ 
/*     */   
/*     */   public NodeVisitor addHandlers(VisitHandler[]... paramVarArgs) {
/* 105 */     return (NodeVisitor)addActionHandlers((AstHandler[][])paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public NodeVisitor addHandler(VisitHandler paramVisitHandler) {
/* 111 */     return (NodeVisitor)addActionHandler(paramVisitHandler);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visit(Node paramNode) {
/* 116 */     processNode(paramNode, true, this::visit);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitNodeOnly(Node paramNode) {
/* 121 */     processNode(paramNode, false, this::visit);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitChildren(Node paramNode) {
/* 126 */     processChildren(paramNode, this::visit);
/*     */   }
/*     */   
/*     */   private void visit(Node paramNode, Visitor<Node> paramVisitor) {
/* 130 */     paramVisitor.visit(paramNode);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\NodeVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */