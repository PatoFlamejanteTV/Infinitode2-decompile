/*    */ package com.vladsch.flexmark.ext.abbreviation.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.abbreviation.Abbreviation;
/*    */ import com.vladsch.flexmark.ext.abbreviation.AbbreviationBlock;
/*    */ import com.vladsch.flexmark.ext.abbreviation.AbbreviationExtension;
/*    */ import com.vladsch.flexmark.util.ast.KeepType;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeRepository;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AbbreviationRepository
/*    */   extends NodeRepository<AbbreviationBlock>
/*    */ {
/*    */   public AbbreviationRepository(DataHolder paramDataHolder) {
/* 20 */     super((KeepType)AbbreviationExtension.ABBREVIATIONS_KEEP.get(paramDataHolder));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public DataKey<AbbreviationRepository> getDataKey() {
/* 26 */     return AbbreviationExtension.ABBREVIATIONS;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public DataKey<KeepType> getKeepDataKey() {
/* 32 */     return AbbreviationExtension.ABBREVIATIONS_KEEP;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<AbbreviationBlock> getReferencedElements(Node paramNode) {
/* 38 */     HashSet<AbbreviationBlock> hashSet = new HashSet();
/* 39 */     visitNodes(paramNode, paramNode -> { AbbreviationBlock abbreviationBlock; if (paramNode instanceof Abbreviation && (abbreviationBlock = ((Abbreviation)paramNode).getReferenceNode(this)) != null) paramHashSet.add(abbreviationBlock);  }new Class[] { Abbreviation.class });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 47 */     return hashSet;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\abbreviation\internal\AbbreviationRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */