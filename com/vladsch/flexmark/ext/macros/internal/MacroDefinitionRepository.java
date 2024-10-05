/*    */ package com.vladsch.flexmark.ext.macros.internal;
/*    */ import com.vladsch.flexmark.ext.macros.MacroDefinitionBlock;
/*    */ import com.vladsch.flexmark.ext.macros.MacroReference;
/*    */ import com.vladsch.flexmark.ext.macros.MacrosExtension;
/*    */ import com.vladsch.flexmark.util.ast.KeepType;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeRepository;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Comparator;
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class MacroDefinitionRepository extends NodeRepository<MacroDefinitionBlock> {
/* 17 */   private final ArrayList<MacroDefinitionBlock> myReferencedMacroDefinitionBlocks = new ArrayList<>();
/*    */   
/*    */   public void addMacrosReference(MacroDefinitionBlock paramMacroDefinitionBlock, MacroReference paramMacroReference) {
/* 20 */     if (!paramMacroDefinitionBlock.isReferenced()) {
/* 21 */       this.myReferencedMacroDefinitionBlocks.add(paramMacroDefinitionBlock);
/*    */     }
/*    */     
/* 24 */     paramMacroDefinitionBlock.setFirstReferenceOffset(paramMacroReference.getStartOffset());
/*    */   }
/*    */ 
/*    */   
/*    */   public void resolveMacrosOrdinals() {
/* 29 */     this.myReferencedMacroDefinitionBlocks.sort(Comparator.comparing(MacroDefinitionBlock::getFirstReferenceOffset));
/* 30 */     byte b = 0;
/* 31 */     for (Iterator<MacroDefinitionBlock> iterator = this.myReferencedMacroDefinitionBlocks.iterator(); iterator.hasNext();) {
/* 32 */       (macroDefinitionBlock = iterator.next()).setOrdinal(++b);
/*    */     }
/*    */   }
/*    */   
/*    */   public List<MacroDefinitionBlock> getReferencedMacroDefinitionBlocks() {
/* 37 */     return this.myReferencedMacroDefinitionBlocks;
/*    */   }
/*    */   
/*    */   public MacroDefinitionRepository(DataHolder paramDataHolder) {
/* 41 */     super((KeepType)MacrosExtension.MACRO_DEFINITIONS_KEEP.get(paramDataHolder));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public DataKey<MacroDefinitionRepository> getDataKey() {
/* 47 */     return MacrosExtension.MACRO_DEFINITIONS;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public DataKey<KeepType> getKeepDataKey() {
/* 53 */     return MacrosExtension.MACRO_DEFINITIONS_KEEP;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<MacroDefinitionBlock> getReferencedElements(Node paramNode) {
/* 59 */     HashSet<MacroDefinitionBlock> hashSet = new HashSet();
/* 60 */     visitNodes(paramNode, paramNode -> { MacroDefinitionBlock macroDefinitionBlock; if (paramNode instanceof MacroReference && (macroDefinitionBlock = ((MacroReference)paramNode).getReferenceNode(this)) != null) paramHashSet.add(macroDefinitionBlock);  }new Class[] { MacroReference.class });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 68 */     return hashSet;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\macros\internal\MacroDefinitionRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */