/*     */ package com.badlogic.gdx.ai.btree.utils;
/*     */ 
/*     */ import com.badlogic.gdx.Files;
/*     */ import com.badlogic.gdx.ai.GdxAI;
/*     */ import com.badlogic.gdx.ai.btree.BehaviorTree;
/*     */ import com.badlogic.gdx.ai.btree.Task;
/*     */ import com.badlogic.gdx.assets.AssetManager;
/*     */ import com.badlogic.gdx.assets.loaders.FileHandleResolver;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BehaviorTreeLibrary
/*     */ {
/*     */   protected ObjectMap<String, BehaviorTree<?>> repository;
/*     */   protected FileHandleResolver resolver;
/*     */   protected BehaviorTreeParser<?> parser;
/*     */   
/*     */   public BehaviorTreeLibrary() {
/*  45 */     this(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BehaviorTreeLibrary(int paramInt) {
/*  52 */     this(GdxAI.getFileSystem().newResolver(Files.FileType.Internal), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BehaviorTreeLibrary(FileHandleResolver paramFileHandleResolver) {
/*  58 */     this(paramFileHandleResolver, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BehaviorTreeLibrary(FileHandleResolver paramFileHandleResolver, int paramInt) {
/*  65 */     this(paramFileHandleResolver, null, paramInt);
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
/*     */   private BehaviorTreeLibrary(FileHandleResolver paramFileHandleResolver, AssetManager paramAssetManager, int paramInt) {
/*  78 */     this.resolver = paramFileHandleResolver;
/*     */     
/*  80 */     this.repository = new ObjectMap();
/*  81 */     this.parser = new BehaviorTreeParser(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> Task<T> createRootTask(String paramString) {
/*  91 */     return retrieveArchetypeTree(paramString).getChild(0).cloneTask();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> BehaviorTree<T> createBehaviorTree(String paramString) {
/* 100 */     return createBehaviorTree(paramString, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> BehaviorTree<T> createBehaviorTree(String paramString, T paramT) {
/*     */     BehaviorTree<T> behaviorTree;
/* 112 */     (behaviorTree = (BehaviorTree)retrieveArchetypeTree(paramString).cloneTask()).setObject(paramT);
/* 113 */     return behaviorTree;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BehaviorTree<?> retrieveArchetypeTree(String paramString) {
/*     */     BehaviorTree<?> behaviorTree;
/* 123 */     if ((behaviorTree = (BehaviorTree)this.repository.get(paramString)) == null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 130 */       behaviorTree = this.parser.parse(this.resolver.resolve(paramString), (Object)null);
/* 131 */       registerArchetypeTree(paramString, behaviorTree);
/*     */     } 
/* 133 */     return behaviorTree;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerArchetypeTree(String paramString, BehaviorTree<?> paramBehaviorTree) {
/* 142 */     if (paramBehaviorTree == null) {
/* 143 */       throw new IllegalArgumentException("The registered archetype must not be null.");
/*     */     }
/* 145 */     this.repository.put(paramString, paramBehaviorTree);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasArchetypeTree(String paramString) {
/* 152 */     return this.repository.containsKey(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void disposeBehaviorTree(String paramString, BehaviorTree<?> paramBehaviorTree) {
/* 161 */     if (Task.TASK_CLONER != null)
/* 162 */       Task.TASK_CLONER.freeTask((Task)paramBehaviorTree); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btre\\utils\BehaviorTreeLibrary.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */