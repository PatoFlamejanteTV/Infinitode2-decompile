/*     */ package com.vladsch.flexmark.util.visitor;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.function.BiConsumer;
/*     */ import java.util.function.BiFunction;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AstActionHandler<C extends AstActionHandler<C, N, A, H>, N, A extends AstAction<N>, H extends AstHandler<N, A>>
/*     */ {
/*  21 */   private final Map<Class<? extends N>, H> customHandlersMap = new HashMap<>();
/*     */   private final AstNode<N> astAdapter;
/*     */   
/*     */   public AstActionHandler(AstNode<N> paramAstNode) {
/*  25 */     this.astAdapter = paramAstNode;
/*     */   } @SafeVarargs
/*     */   protected final C addActionHandlers(H[]... paramVarArgs) {
/*     */     int i;
/*     */     byte b;
/*  30 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/*  31 */       H[] arrayOfH; int j; byte b1; for (j = (arrayOfH = arrayOfH = paramVarArgs[b]).length, b1 = 0; b1 < j; ) { H h = arrayOfH[b1];
/*  32 */         this.customHandlersMap.put(h.getNodeType(), h);
/*     */         b1++; }
/*     */     
/*     */     } 
/*  36 */     return (C)this;
/*     */   }
/*     */   
/*     */   protected C addActionHandler(H paramH) {
/*  40 */     this.customHandlersMap.put(paramH.getNodeType(), paramH);
/*     */     
/*  42 */     return (C)this;
/*     */   }
/*     */   
/*     */   private A getAction(H paramH) {
/*  46 */     return (A)((paramH == null) ? null : paramH.getAdapter());
/*     */   }
/*     */   
/*     */   public A getAction(N paramN) {
/*  50 */     return getAction(this.customHandlersMap.get(paramN.getClass()));
/*     */   }
/*     */   
/*     */   public A getAction(Class<?> paramClass) {
/*  54 */     return getAction(this.customHandlersMap.get(paramClass));
/*     */   }
/*     */   
/*     */   protected H getHandler(N paramN) {
/*  58 */     return this.customHandlersMap.get(paramN.getClass());
/*     */   }
/*     */   
/*     */   protected H getHandler(Class<?> paramClass) {
/*  62 */     return this.customHandlersMap.get(paramClass);
/*     */   }
/*     */   
/*     */   public Set<Class<? extends N>> getNodeClasses() {
/*  66 */     return this.customHandlersMap.keySet();
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
/*     */   protected void processNode(N paramN, boolean paramBoolean, BiConsumer<N, A> paramBiConsumer) {
/*     */     A a;
/*  80 */     if ((a = getAction(paramN)) != null) {
/*  81 */       paramBiConsumer.accept(paramN, a); return;
/*  82 */     }  if (paramBoolean) {
/*  83 */       processChildren(paramN, paramBiConsumer);
/*     */     }
/*     */   }
/*     */   
/*     */   protected final void processChildren(N paramN, BiConsumer<N, A> paramBiConsumer) {
/*  88 */     paramN = this.astAdapter.getFirstChild(paramN);
/*  89 */     while (paramN != null) {
/*     */ 
/*     */       
/*  92 */       N n = this.astAdapter.getNext(paramN);
/*  93 */       processNode(paramN, true, paramBiConsumer);
/*  94 */       paramN = n;
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
/*     */   
/*     */   protected final <R> R processNodeOnly(N paramN, R paramR, BiFunction<N, A, R> paramBiFunction) {
/* 108 */     Object[] arrayOfObject = { paramR };
/* 109 */     processNode(paramN, false, (paramObject, paramAstAction) -> paramArrayOfObject[0] = paramBiFunction.apply(paramObject, paramAstAction));
/*     */     
/* 111 */     return (R)arrayOfObject[0];
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\visitor\AstActionHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */