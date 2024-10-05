/*     */ package com.vladsch.flexmark.ext.attributes.internal;
/*     */ import com.vladsch.flexmark.ast.AnchorRefTarget;
/*     */ import com.vladsch.flexmark.ast.FencedCodeBlock;
/*     */ import com.vladsch.flexmark.ast.TextBase;
/*     */ import com.vladsch.flexmark.ext.attributes.AttributeNode;
/*     */ import com.vladsch.flexmark.ext.attributes.AttributesNode;
/*     */ import com.vladsch.flexmark.parser.LightInlineParser;
/*     */ import com.vladsch.flexmark.parser.PostProcessor;
/*     */ import com.vladsch.flexmark.parser.block.NodePostProcessor;
/*     */ import com.vladsch.flexmark.util.ast.BlankLine;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.NodeTracker;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class AttributesNodePostProcessor extends NodePostProcessor {
/*     */   private final NodeAttributeRepository nodeAttributeRepository;
/*     */   private final AttributesOptions myOptions;
/*     */   private LightInlineParser myLightInlineParser;
/*     */   private AttributesInlineParserExtension myParserExtension;
/*     */   
/*     */   public AttributesNodePostProcessor(Document paramDocument) {
/*  26 */     this.nodeAttributeRepository = (NodeAttributeRepository)AttributesExtension.NODE_ATTRIBUTES.get((DataHolder)paramDocument);
/*  27 */     this.myOptions = new AttributesOptions((DataHolder)paramDocument);
/*     */   }
/*     */   
/*     */   public Node getAttributeOwner(NodeTracker paramNodeTracker, AttributesNode paramAttributesNode) {
/*  31 */     Node node1, node2 = paramAttributesNode.getPreviousAnyNot(new Class[] { BlankLine.class, DoNotAttributeDecorate.class });
/*     */     
/*  33 */     Node node3 = paramAttributesNode.getParent();
/*     */     
/*  35 */     if (node2 == null)
/*     */     
/*     */     { 
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
/*  56 */       if (node3 instanceof com.vladsch.flexmark.ast.Paragraph) {
/*  57 */         if (node3.getParent() instanceof com.vladsch.flexmark.ast.ParagraphItemContainer) {
/*     */           Node node;
/*  59 */           if ((node = node3.getPreviousAnyNot(new Class[] { BlankLine.class })) == null) {
/*     */             
/*  61 */             node1 = node3.getGrandParent();
/*     */           }
/*  63 */           else if (paramAttributesNode.getNextAnyNot(new Class[] { AttributesNode.class, BlankLine.class }) == null) {
/*     */             
/*  65 */             node1 = node;
/*     */           } else {
/*     */             
/*  68 */             node1 = node3;
/*     */           }
/*     */         
/*     */         }
/*  72 */         else if (paramAttributesNode.getNextAnyNot(new Class[] { AttributesNode.class, BlankLine.class }) == null) {
/*     */           Node node;
/*  74 */           if ((node = node3.getPreviousAnyNot(new Class[] { BlankLine.class })) == null) {
/*     */             
/*  76 */             node1 = node3.getParent();
/*     */           } else {
/*     */             
/*  79 */             node1 = node;
/*     */           } 
/*     */         } else {
/*     */           
/*  83 */           node1 = node3;
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/*  88 */         node1 = node3;
/*     */       }  }
/*     */     else
/*  91 */     { Node node; if ((!this.myOptions.assignTextAttributes && (node2 instanceof com.vladsch.flexmark.ast.Text || node2 instanceof TextBase)) || node2.getEndOffset() < paramAttributesNode.getStartOffset())
/*     */       
/*     */       { 
/*     */         
/*  95 */         if (this.myOptions.useEmptyImplicitAsSpanDelimiter)
/*     */         {
/*  97 */           node2 = matchDelimitedSpans((NodeTracker)node1, paramAttributesNode, node2);
/*     */         }
/*     */         
/* 100 */         if (!(node2 instanceof TextBase))
/*     */         
/*     */         { 
/* 103 */           if (node3 instanceof com.vladsch.flexmark.ast.Paragraph && node3.getParent() instanceof com.vladsch.flexmark.ast.ParagraphItemContainer) {
/* 104 */             node1 = node3.getParent();
/*     */           } else {
/* 106 */             node1 = node3;
/*     */           } 
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
/* 160 */           return node1; }  } else { TextBase textBase; if (this.myOptions.wrapNonAttributeText) { Node node4 = paramAttributesNode.getPrevious(); node3 = null; boolean bool = false; while (node4 != null && (node4 instanceof com.vladsch.flexmark.ast.Text || node4 instanceof DoNotAttributeDecorate)) { if (node4 instanceof DoNotAttributeDecorate) bool = true;  node3 = node4; node4 = node4.getPrevious(); }  if (bool) { textBase = new TextBase(); textBaseWrap((NodeTracker)node1, node3, (Node)paramAttributesNode, textBase); textBase = textBase; }  }  if (this.myOptions.useEmptyImplicitAsSpanDelimiter) node = matchDelimitedSpans((NodeTracker)node1, paramAttributesNode, (Node)textBase);  if (node instanceof com.vladsch.flexmark.ast.Text) { TextBase textBase2 = new TextBase(node.getChars()); node.insertBefore((Node)textBase2); node.unlink(); node1.nodeRemoved(node); textBase2.appendChild(node); node1.nodeAddedWithChildren((Node)textBase2); TextBase textBase1 = textBase2; } else if (node instanceof com.vladsch.flexmark.ext.attributes.AttributesDelimiter) { node1 = null; } else { if (node instanceof AttributesNode) { node1 = getAttributeOwner((NodeTracker)node1, (AttributesNode)node); return node1; }  node1 = node; }  return node1; }  node1 = node; }  return node1;
/*     */   }
/*     */   
/*     */   static Node matchDelimitedSpans(NodeTracker paramNodeTracker, AttributesNode paramAttributesNode, Node paramNode) {
/* 164 */     Node node = paramAttributesNode.getPrevious();
/*     */     
/* 166 */     ArrayList<Node> arrayList = new ArrayList();
/*     */     
/* 168 */     while (node != null) {
/* 169 */       if (node instanceof com.vladsch.flexmark.ext.attributes.AttributesDelimiter) {
/* 170 */         if (!arrayList.isEmpty()) {
/*     */           
/* 172 */           Node node2 = arrayList.remove(arrayList.size() - 1);
/* 173 */           Node node1 = node.getNext();
/* 174 */           if (node2 != node1) {
/* 175 */             TextBase textBase = new TextBase();
/*     */             
/* 177 */             textBaseWrap(paramNodeTracker, node1, node2, textBase);
/*     */           } else {
/*     */             
/* 180 */             paramNode = node;
/*     */           } 
/*     */         } else {
/*     */           
/* 184 */           TextBase textBase = new TextBase();
/*     */           
/*     */           Node node1;
/* 187 */           if ((node1 = node.getNext()) != paramAttributesNode) {
/* 188 */             textBaseWrap(paramNodeTracker, node1, (Node)paramAttributesNode, textBase);
/* 189 */             TextBase textBase1 = textBase; break;
/*     */           } 
/* 191 */           paramNode = node;
/*     */           
/*     */           break;
/*     */         } 
/* 195 */       } else if (node instanceof AttributesNode) {
/* 196 */         arrayList.add(node);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 201 */       node = node.getPrevious();
/*     */     } 
/*     */     
/* 204 */     if (!arrayList.isEmpty()) {
/*     */       Node node1;
/*     */ 
/*     */       
/* 208 */       if ((node1 = (paramNode = arrayList.get(0)).getNext()) != null && node1 != paramAttributesNode) {
/* 209 */         paramNode = node1;
/*     */       }
/*     */     } 
/*     */     
/* 213 */     return paramNode;
/*     */   }
/*     */   
/*     */   static void textBaseWrap(NodeTracker paramNodeTracker, Node paramNode1, Node paramNode2, TextBase paramTextBase) {
/* 217 */     while (paramNode1 != paramNode2) {
/* 218 */       Node node = paramNode1.getNext();
/* 219 */       paramNode1.unlink();
/* 220 */       paramNodeTracker.nodeRemoved(paramNode1);
/* 221 */       paramTextBase.appendChild(paramNode1);
/* 222 */       paramNode1 = node;
/*     */     } 
/* 224 */     paramTextBase.setCharsFromContent();
/* 225 */     paramNode2.insertBefore((Node)paramTextBase);
/* 226 */     paramNodeTracker.nodeAddedWithDescendants((Node)paramTextBase);
/*     */   }
/*     */ 
/*     */   
/*     */   public void process(NodeTracker paramNodeTracker, Node paramNode) {
/* 231 */     if (paramNode instanceof AttributesNode) {
/*     */       AttributesNode attributesNode;
/*     */ 
/*     */       
/* 235 */       Node node1 = (attributesNode = (AttributesNode)paramNode).getPrevious();
/* 236 */       Node node2 = attributesNode.getNext();
/*     */ 
/*     */ 
/*     */       
/* 240 */       if (node1 == null)
/*     */       {
/* 242 */         if (node2 != null && !(node2 instanceof AttributesNode)) {
/* 243 */           if (node2.getChars().isBlank()) {
/*     */             
/* 245 */             Node node = node2;
/* 246 */             node2 = node2.getNext();
/* 247 */             node.unlink();
/* 248 */             paramNodeTracker.nodeRemoved(node);
/*     */           } else {
/* 250 */             node2.setChars((BasedSequence)node2.getChars().trimStart());
/*     */           } 
/*     */         }
/*     */       }
/*     */       
/* 255 */       if (node2 == null)
/*     */       {
/* 257 */         if (node1 != null && !(node1 instanceof AttributesNode)) {
/* 258 */           if (node1.getChars().isBlank()) {
/*     */             
/* 260 */             Node node = node1;
/* 261 */             node1.getPrevious();
/* 262 */             node.unlink();
/* 263 */             paramNodeTracker.nodeRemoved(node);
/*     */           } else {
/* 265 */             node1.setChars((BasedSequence)node1.getChars().trimEnd());
/*     */           } 
/*     */         }
/*     */       }
/*     */       
/*     */       Node node3;
/* 271 */       if ((node3 = getAttributeOwner(paramNodeTracker, attributesNode)) != null) {
/* 272 */         this.nodeAttributeRepository.put(node3, attributesNode);
/*     */ 
/*     */         
/* 275 */         if (node3 instanceof AnchorRefTarget) {
/* 276 */           for (ReversiblePeekingIterator<Node> reversiblePeekingIterator = attributesNode.getReversedChildren().iterator(); reversiblePeekingIterator.hasNext();) {
/* 277 */             if (node2 = reversiblePeekingIterator.next() instanceof AttributeNode && (
/* 278 */               (AttributeNode)node2).isId()) {
/* 279 */               ((AnchorRefTarget)node3).setAnchorRefId(((AttributeNode)node2).getValue().toString());
/* 280 */               ((AnchorRefTarget)node3).setExplicitAnchorRefId(true);
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 289 */     if (paramNode instanceof FencedCodeBlock && this.myOptions.fencedCodeInfoAttributes) {
/*     */       FencedCodeBlock fencedCodeBlock;
/*     */ 
/*     */       
/* 293 */       BasedSequence basedSequence1 = (fencedCodeBlock = (FencedCodeBlock)paramNode).getInfo();
/* 294 */       BasedSequence basedSequence2 = fencedCodeBlock.getInfoDelimitedByAny(CharPredicate.SPACE_TAB);
/*     */       
/*     */       int i;
/*     */       BasedSequence basedSequence3;
/* 298 */       if ((i = (basedSequence3 = (BasedSequence)((BasedSequence)basedSequence1.subSequence(basedSequence2.length())).trimStart()).indexOf('{')) >= 0) {
/*     */         
/* 300 */         if (this.myLightInlineParser == null) {
/* 301 */           this.myLightInlineParser = (LightInlineParser)new LightInlineParserImpl((DataHolder)paramNode.getDocument());
/* 302 */           this.myParserExtension = new AttributesInlineParserExtension(this.myLightInlineParser);
/*     */         } 
/*     */         
/* 305 */         this.myLightInlineParser.setInput(basedSequence3);
/* 306 */         this.myLightInlineParser.setIndex(i);
/* 307 */         AttributesNode attributesNode = new AttributesNode();
/* 308 */         this.myLightInlineParser.setBlock((Node)attributesNode);
/*     */         
/*     */         while (true) {
/* 311 */           i = this.myLightInlineParser.getIndex();
/* 312 */           boolean bool = this.myParserExtension.parse(this.myLightInlineParser);
/*     */           
/* 314 */           this.myLightInlineParser.spnl();
/* 315 */           int j = this.myLightInlineParser.getIndex() + ((this.myLightInlineParser.getIndex() == i) ? 1 : 0);
/*     */           
/* 317 */           if ((i = basedSequence3.indexOf('{', j)) != -1) {
/*     */             
/* 319 */             if (!bool || !basedSequence3.subSequence(j, i).isBlank())
/*     */             {
/* 321 */               attributesNode.removeChildren();
/*     */             }
/*     */             
/* 324 */             this.myLightInlineParser.setIndex(i); continue;
/*     */           }  break;
/*     */         } 
/* 327 */         if (attributesNode.hasChildren()) {
/*     */           
/* 329 */           Node node = attributesNode.getFirstChild();
/* 330 */           paramNode = attributesNode.getLastChild();
/*     */ 
/*     */           
/* 333 */           fencedCodeBlock.setInfo(fencedCodeBlock.baseSubSequence(basedSequence1.getStartOffset(), node.getStartOffset()));
/* 334 */           fencedCodeBlock.setAttributes(fencedCodeBlock.baseSubSequence(node.getStartOffset(), paramNode.getEndOffset()));
/*     */           
/* 336 */           for (ReversiblePeekingIterator<Node> reversiblePeekingIterator = attributesNode.getChildren().iterator(); reversiblePeekingIterator.hasNext(); ) { node = reversiblePeekingIterator.next();
/* 337 */             if (this.myLightInlineParser.getIndex() >= this.myLightInlineParser.getInput().length()) {
/* 338 */               if (fencedCodeBlock.hasChildren()) {
/* 339 */                 fencedCodeBlock.getLastChild().insertBefore(node);
/*     */               } else {
/* 341 */                 fencedCodeBlock.appendChild(node);
/*     */               } 
/*     */ 
/*     */               
/* 345 */               this.nodeAttributeRepository.put((Node)fencedCodeBlock, (AttributesNode)node);
/*     */             }  }
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class Factory extends NodePostProcessorFactory {
/*     */     public Factory() {
/* 355 */       super(false);
/* 356 */       addNodes(new Class[] { AttributesNode.class, FencedCodeBlock.class });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public NodePostProcessor apply(Document param1Document) {
/* 362 */       return new AttributesNodePostProcessor(param1Document);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\attributes\internal\AttributesNodePostProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */