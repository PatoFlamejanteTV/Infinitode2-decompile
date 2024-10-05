/*    */ package com.vladsch.flexmark.ext.enumerated.reference;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.KeepType;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeRepository;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ public class EnumeratedReferenceRepository
/*    */   extends NodeRepository<EnumeratedReferenceBlock>
/*    */ {
/* 17 */   private ArrayList<EnumeratedReferenceBlock> referencedEnumeratedReferenceBlocks = new ArrayList<>();
/*    */   
/*    */   public static String getType(String paramString) {
/*    */     int i;
/* 21 */     if ((i = paramString.lastIndexOf(':')) > 0) {
/* 22 */       return paramString.subSequence(0, i).toString();
/*    */     }
/*    */     
/* 25 */     return "";
/*    */   }
/*    */ 
/*    */   
/*    */   public List<EnumeratedReferenceBlock> getReferencedEnumeratedReferenceBlocks() {
/* 30 */     return this.referencedEnumeratedReferenceBlocks;
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumeratedReferenceRepository(DataHolder paramDataHolder) {
/* 35 */     super((KeepType)EnumeratedReferenceExtension.ENUMERATED_REFERENCES_KEEP.get(paramDataHolder));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public DataKey<EnumeratedReferenceRepository> getDataKey() {
/* 41 */     return EnumeratedReferenceExtension.ENUMERATED_REFERENCES;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public DataKey<KeepType> getKeepDataKey() {
/* 47 */     return EnumeratedReferenceExtension.ENUMERATED_REFERENCES_KEEP;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<EnumeratedReferenceBlock> getReferencedElements(Node paramNode) {
/* 53 */     HashSet<EnumeratedReferenceBlock> hashSet = new HashSet();
/* 54 */     visitNodes(paramNode, paramNode -> { EnumeratedReferenceBlock enumeratedReferenceBlock; if (paramNode instanceof EnumeratedReferenceBase && (enumeratedReferenceBlock = ((EnumeratedReferenceBase)paramNode).getReferenceNode(this)) != null) paramHashSet.add(enumeratedReferenceBlock);  }new Class[] { EnumeratedReferenceText.class, EnumeratedReferenceLink.class });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 62 */     return hashSet;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\enumerated\reference\EnumeratedReferenceRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */