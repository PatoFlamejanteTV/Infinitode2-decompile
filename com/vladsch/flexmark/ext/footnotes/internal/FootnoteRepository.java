/*    */ package com.vladsch.flexmark.ext.footnotes.internal;
/*    */ import com.vladsch.flexmark.ext.footnotes.Footnote;
/*    */ import com.vladsch.flexmark.ext.footnotes.FootnoteBlock;
/*    */ import com.vladsch.flexmark.ext.footnotes.FootnoteExtension;
/*    */ import com.vladsch.flexmark.util.ast.Document;
/*    */ import com.vladsch.flexmark.util.ast.KeepType;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeVisitor;
/*    */ import com.vladsch.flexmark.util.ast.VisitHandler;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class FootnoteRepository extends NodeRepository<FootnoteBlock> {
/* 15 */   private ArrayList<FootnoteBlock> referencedFootnoteBlocks = new ArrayList<>();
/*    */   
/*    */   public static void resolveFootnotes(Document paramDocument) {
/* 18 */     FootnoteRepository footnoteRepository = (FootnoteRepository)FootnoteExtension.FOOTNOTES.get((DataHolder)paramDocument);
/*    */     
/* 20 */     boolean[] arrayOfBoolean = { false };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     NodeVisitor nodeVisitor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 35 */     (nodeVisitor = new NodeVisitor(new VisitHandler[] { new VisitHandler(Footnote.class, paramFootnote -> { FootnoteBlock footnoteBlock; if (!paramFootnote.isDefined() && (footnoteBlock = paramFootnote.getFootnoteBlock(paramFootnoteRepository)) != null) { paramFootnoteRepository.addFootnoteReference(footnoteBlock, paramFootnote); paramFootnote.setFootnoteBlock(footnoteBlock); paramArrayOfboolean[0] = true; }  }) })).visit((Node)paramDocument);
/* 36 */     if (arrayOfBoolean[0]) {
/* 37 */       footnoteRepository.resolveFootnoteOrdinals();
/*    */     }
/*    */   }
/*    */   
/*    */   public void addFootnoteReference(FootnoteBlock paramFootnoteBlock, Footnote paramFootnote) {
/* 42 */     if (!paramFootnoteBlock.isReferenced()) {
/* 43 */       this.referencedFootnoteBlocks.add(paramFootnoteBlock);
/*    */     }
/*    */     
/* 46 */     paramFootnoteBlock.setFirstReferenceOffset(paramFootnote.getStartOffset());
/*    */     
/* 48 */     int i = paramFootnoteBlock.getFootnoteReferences();
/* 49 */     paramFootnoteBlock.setFootnoteReferences(i + 1);
/* 50 */     paramFootnote.setReferenceOrdinal(i);
/*    */   }
/*    */ 
/*    */   
/*    */   public void resolveFootnoteOrdinals() {
/* 55 */     Collections.sort(this.referencedFootnoteBlocks, (paramFootnoteBlock1, paramFootnoteBlock2) -> paramFootnoteBlock1.getFirstReferenceOffset() - paramFootnoteBlock2.getFirstReferenceOffset());
/*    */     
/* 57 */     byte b = 0;
/* 58 */     for (Iterator<FootnoteBlock> iterator = this.referencedFootnoteBlocks.iterator(); iterator.hasNext();) {
/* 59 */       (footnoteBlock = iterator.next()).setFootnoteOrdinal(++b);
/*    */     }
/*    */   }
/*    */   
/*    */   public List<FootnoteBlock> getReferencedFootnoteBlocks() {
/* 64 */     return this.referencedFootnoteBlocks;
/*    */   }
/*    */   
/*    */   public FootnoteRepository(DataHolder paramDataHolder) {
/* 68 */     super((KeepType)FootnoteExtension.FOOTNOTES_KEEP.get(paramDataHolder));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public DataKey<FootnoteRepository> getDataKey() {
/* 74 */     return FootnoteExtension.FOOTNOTES;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public DataKey<KeepType> getKeepDataKey() {
/* 80 */     return FootnoteExtension.FOOTNOTES_KEEP;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<FootnoteBlock> getReferencedElements(Node paramNode) {
/* 86 */     HashSet<FootnoteBlock> hashSet = new HashSet();
/* 87 */     visitNodes(paramNode, paramNode -> { FootnoteBlock footnoteBlock; if (paramNode instanceof Footnote && (footnoteBlock = ((Footnote)paramNode).getReferenceNode(this)) != null) paramHashSet.add(footnoteBlock);  }new Class[] { Footnote.class });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 95 */     return hashSet;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\footnotes\internal\FootnoteRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */