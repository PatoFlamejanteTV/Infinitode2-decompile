/*    */ package com.vladsch.flexmark.ast.util;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.ImageRef;
/*    */ import com.vladsch.flexmark.ast.LinkRef;
/*    */ import com.vladsch.flexmark.ast.RefNode;
/*    */ import com.vladsch.flexmark.ast.Reference;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.util.ast.KeepType;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeRepository;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import com.vladsch.flexmark.util.sequence.Escaping;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ public class ReferenceRepository
/*    */   extends NodeRepository<Reference>
/*    */ {
/*    */   public ReferenceRepository(DataHolder paramDataHolder) {
/* 22 */     super((KeepType)Parser.REFERENCES_KEEP.get(paramDataHolder));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public DataKey<ReferenceRepository> getDataKey() {
/* 28 */     return Parser.REFERENCES;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public DataKey<KeepType> getKeepDataKey() {
/* 34 */     return Parser.REFERENCES_KEEP;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String normalizeKey(CharSequence paramCharSequence) {
/* 40 */     return Escaping.normalizeReference(paramCharSequence, true);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<Reference> getReferencedElements(Node paramNode) {
/* 46 */     HashSet<Reference> hashSet = new HashSet();
/* 47 */     visitNodes(paramNode, paramNode -> { Reference reference; if (paramNode instanceof RefNode && (reference = ((RefNode)paramNode).getReferenceNode(this)) != null) paramHashSet.add(reference);  }new Class[] { LinkRef.class, ImageRef.class });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 55 */     return hashSet;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\as\\util\ReferenceRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */