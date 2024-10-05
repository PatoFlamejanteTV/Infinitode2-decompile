/*    */ package com.badlogic.gdx.ai.btree.utils;
/*    */ 
/*    */ import com.badlogic.gdx.ai.btree.BehaviorTree;
/*    */ import com.badlogic.gdx.assets.AssetDescriptor;
/*    */ import com.badlogic.gdx.assets.AssetLoaderParameters;
/*    */ import com.badlogic.gdx.assets.AssetManager;
/*    */ import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
/*    */ import com.badlogic.gdx.assets.loaders.FileHandleResolver;
/*    */ import com.badlogic.gdx.files.FileHandle;
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.StreamUtils;
/*    */ import java.io.Reader;
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
/*    */ public class BehaviorTreeLoader
/*    */   extends AsynchronousAssetLoader<BehaviorTree, BehaviorTreeLoader.BehaviorTreeParameter>
/*    */ {
/*    */   BehaviorTree behaviorTree;
/*    */   
/*    */   public BehaviorTreeLoader(FileHandleResolver paramFileHandleResolver) {
/* 39 */     super(paramFileHandleResolver);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, BehaviorTreeParameter paramBehaviorTreeParameter) {
/*    */     BehaviorTreeParser<Object> behaviorTreeParser;
/*    */     Reader reader;
/* 47 */     this.behaviorTree = null;
/*    */     
/* 49 */     paramAssetManager = null;
/* 50 */     paramString = null;
/* 51 */     if (paramBehaviorTreeParameter != null) {
/* 52 */       null = paramBehaviorTreeParameter.blackboard;
/* 53 */       behaviorTreeParser = paramBehaviorTreeParameter.parser;
/*    */     } 
/*    */     
/* 56 */     if (behaviorTreeParser == null) behaviorTreeParser = new BehaviorTreeParser();
/*    */     
/* 58 */     paramBehaviorTreeParameter = null;
/*    */     try {
/* 60 */       reader = paramFileHandle.reader();
/* 61 */       this.behaviorTree = behaviorTreeParser.parse(reader, null); return;
/*    */     } finally {
/* 63 */       StreamUtils.closeQuietly(reader);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public BehaviorTree loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, BehaviorTreeParameter paramBehaviorTreeParameter) {
/* 69 */     BehaviorTree behaviorTree = this.behaviorTree;
/* 70 */     this.behaviorTree = null;
/* 71 */     return behaviorTree;
/*    */   }
/*    */ 
/*    */   
/*    */   public Array<AssetDescriptor> getDependencies(String paramString, FileHandle paramFileHandle, BehaviorTreeParameter paramBehaviorTreeParameter) {
/* 76 */     return null;
/*    */   }
/*    */   
/*    */   public static class BehaviorTreeParameter extends AssetLoaderParameters<BehaviorTree> {
/*    */     public final Object blackboard;
/*    */     public final BehaviorTreeParser parser;
/*    */     
/*    */     public BehaviorTreeParameter() {
/* 84 */       this(null);
/*    */     }
/*    */     
/*    */     public BehaviorTreeParameter(Object param1Object) {
/* 88 */       this(param1Object, null);
/*    */     }
/*    */     
/*    */     public BehaviorTreeParameter(Object param1Object, BehaviorTreeParser param1BehaviorTreeParser) {
/* 92 */       this.blackboard = param1Object;
/* 93 */       this.parser = param1BehaviorTreeParser;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btre\\utils\BehaviorTreeLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */