/*     */ package com.vladsch.flexmark.util.ast;
/*     */ 
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterable;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
/*     */ import com.vladsch.flexmark.util.misc.Pair;
/*     */ import com.vladsch.flexmark.util.misc.Utils;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.Range;
/*     */ import com.vladsch.flexmark.util.sequence.SegmentedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
/*     */ import com.vladsch.flexmark.util.visitor.AstNode;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ public abstract class Node
/*     */ {
/*  18 */   public static final BasedSequence[] EMPTY_SEGMENTS = BasedSequence.EMPTY_ARRAY;
/*     */   public static final String SPLICE = " … ";
/*     */   
/*  21 */   public static final AstNode<Node> AST_ADAPTER = new AstNode<Node>()
/*     */     {
/*     */       public final Node getFirstChild(Node param1Node) {
/*  24 */         return param1Node.firstChild;
/*     */       }
/*     */ 
/*     */       
/*     */       public final Node getNext(Node param1Node) {
/*  29 */         return param1Node.next;
/*     */       }
/*     */     };
/*     */   
/*  33 */   private Node parent = null;
/*  34 */   Node firstChild = null;
/*  35 */   private Node lastChild = null;
/*  36 */   private Node prev = null;
/*  37 */   Node next = null;
/*  38 */   private BasedSequence chars = BasedSequence.NULL;
/*     */ 
/*     */   
/*     */   public Node() {}
/*     */   
/*     */   public Node(BasedSequence paramBasedSequence) {
/*  44 */     this.chars = paramBasedSequence;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getStartOffset() {
/*  51 */     return this.chars.getStartOffset();
/*  52 */   } public int getEndOffset() { return this.chars.getEndOffset(); }
/*  53 */   public int getTextLength() { return this.chars.length(); }
/*  54 */   public BasedSequence getBaseSequence() { return this.chars.getBaseSequence(); }
/*  55 */   public Range getSourceRange() { return this.chars.getSourceRange(); }
/*  56 */   public BasedSequence baseSubSequence(int paramInt1, int paramInt2) { return this.chars.baseSubSequence(paramInt1, paramInt2); }
/*  57 */   public BasedSequence baseSubSequence(int paramInt) { return this.chars.baseSubSequence(paramInt); }
/*  58 */   public BasedSequence getEmptyPrefix() { return this.chars.getEmptyPrefix(); } public BasedSequence getEmptySuffix() {
/*  59 */     return this.chars.getEmptySuffix();
/*     */   }
/*  61 */   public int getStartOfLine() { return this.chars.baseStartOfLine(); }
/*  62 */   public int getEndOfLine() { return this.chars.baseEndOfLine(); }
/*  63 */   public int startOfLine(int paramInt) { return this.chars.baseStartOfLine(paramInt); }
/*  64 */   public int endOfLine(int paramInt) { return this.chars.baseEndOfLine(paramInt); }
/*  65 */   public Pair<Integer, Integer> lineColumnAtIndex(int paramInt) { return this.chars.baseLineColumnAtIndex(paramInt); }
/*  66 */   public Pair<Integer, Integer> lineColumnAtStart() { return this.chars.baseLineColumnAtStart(); } public Pair<Integer, Integer> getLineColumnAtEnd() {
/*  67 */     return this.chars.baseLineColumnAtEnd();
/*     */   }
/*     */   
/*     */   public Node getAncestorOfType(Class<?>... paramVarArgs) {
/*  71 */     Node node = getParent();
/*  72 */     while (node != null) {
/*  73 */       Class<?>[] arrayOfClass; int i; byte b; for (i = (arrayOfClass = paramVarArgs).length, b = 0; b < i; b++) {
/*  74 */         Class<?> clazz; if ((clazz = arrayOfClass[b]).isInstance(node)) return node; 
/*     */       } 
/*  76 */       node = node.getParent();
/*     */     } 
/*  78 */     return null;
/*     */   }
/*     */   
/*     */   public int countAncestorsOfType(Class<?>... paramVarArgs) {
/*  82 */     Node node = getParent();
/*  83 */     byte b = 0;
/*  84 */     while (node != null) {
/*  85 */       Class<?>[] arrayOfClass; int i; byte b1; for (i = (arrayOfClass = paramVarArgs).length, b1 = 0; b1 < i; b1++) {
/*  86 */         Class<?> clazz; if ((clazz = arrayOfClass[b1]).isInstance(node)) {
/*  87 */           b++;
/*     */           break;
/*     */         } 
/*     */       } 
/*  91 */       node = node.getParent();
/*     */     } 
/*  93 */     return b;
/*     */   }
/*     */   
/*     */   public int countDirectAncestorsOfType(Class<?> paramClass, Class<?>... paramVarArgs) {
/*  97 */     Node node = getParent();
/*  98 */     byte b = 0;
/*  99 */     while (node != null) {
/* 100 */       boolean bool = false; Class<?>[] arrayOfClass; int i; byte b1;
/* 101 */       for (i = (arrayOfClass = paramVarArgs).length, b1 = 0; b1 < i; b1++) {
/* 102 */         Class<?> clazz; if ((clazz = arrayOfClass[b1]).isInstance(node)) {
/* 103 */           b++;
/* 104 */           bool = true;
/*     */           break;
/*     */         } 
/* 107 */         if (paramClass != null && paramClass.isInstance(node)) {
/* 108 */           bool = true;
/*     */           break;
/*     */         } 
/*     */       } 
/* 112 */       if (bool)
/*     */       {
/*     */         
/* 115 */         node = node.getParent(); } 
/*     */     } 
/* 117 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node getOldestAncestorOfTypeAfter(Class<?> paramClass1, Class<?> paramClass2) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokevirtual getParent : ()Lcom/vladsch/flexmark/util/ast/Node;
/*     */     //   4: astore_3
/*     */     //   5: aconst_null
/*     */     //   6: astore #4
/*     */     //   8: aload_3
/*     */     //   9: ifnull -> 42
/*     */     //   12: aload_1
/*     */     //   13: aload_3
/*     */     //   14: invokevirtual isInstance : (Ljava/lang/Object;)Z
/*     */     //   17: ifeq -> 26
/*     */     //   20: aload_3
/*     */     //   21: astore #4
/*     */     //   23: goto -> 34
/*     */     //   26: aload_2
/*     */     //   27: aload_3
/*     */     //   28: invokevirtual isInstance : (Ljava/lang/Object;)Z
/*     */     //   31: ifne -> 42
/*     */     //   34: aload_3
/*     */     //   35: invokevirtual getParent : ()Lcom/vladsch/flexmark/util/ast/Node;
/*     */     //   38: astore_3
/*     */     //   39: goto -> 8
/*     */     //   42: aload #4
/*     */     //   44: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #121	-> 0
/*     */     //   #122	-> 5
/*     */     //   #123	-> 8
/*     */     //   #124	-> 12
/*     */     //   #125	-> 26
/*     */     //   #126	-> 34
/*     */     //   #128	-> 42
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node getChildOfType(Class<?>... paramVarArgs) {
/* 132 */     Node node = getFirstChild();
/* 133 */     while (node != null) {
/* 134 */       Class<?>[] arrayOfClass; int i; byte b; for (i = (arrayOfClass = paramVarArgs).length, b = 0; b < i; b++) {
/* 135 */         Class<?> clazz; if ((clazz = arrayOfClass[b]).isInstance(node)) return node; 
/*     */       } 
/* 137 */       node = node.getNext();
/*     */     } 
/* 139 */     return null;
/*     */   }
/*     */   
/*     */   public static int getNodeOfTypeIndex(Node paramNode, Class<?>... paramVarArgs) {
/* 143 */     byte b1 = 0; int i; byte b2;
/* 144 */     for (i = (paramVarArgs = paramVarArgs).length, b2 = 0; b2 < i; b2++) {
/* 145 */       Class<?> clazz; if ((clazz = paramVarArgs[b2]).isInstance(paramNode)) return b1; 
/* 146 */       b1++;
/*     */     } 
/* 148 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOrDescendantOfType(Class<?>... paramVarArgs) {
/* 153 */     Node node = this;
/* 154 */     while (node != null) {
/* 155 */       if (node.getNodeOfTypeIndex(paramVarArgs) != -1) return true; 
/* 156 */       node = node.getParent();
/*     */     } 
/* 158 */     return false;
/*     */   }
/*     */   
/*     */   public int getNodeOfTypeIndex(Class<?>... paramVarArgs) {
/* 162 */     return getNodeOfTypeIndex(this, paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node getLastBlankLineChild() {
/* 171 */     return null;
/*     */   }
/*     */   
/*     */   public ReversiblePeekingIterable<Node> getChildren() {
/* 175 */     if (this.firstChild == null) {
/* 176 */       return NodeIterable.EMPTY;
/*     */     }
/* 178 */     return new NodeIterable(this.firstChild, this.lastChild, false);
/*     */   }
/*     */   
/*     */   public ReversiblePeekingIterable<Node> getReversedChildren() {
/* 182 */     if (this.firstChild == null) {
/* 183 */       return NodeIterable.EMPTY;
/*     */     }
/* 185 */     return new NodeIterable(this.firstChild, this.lastChild, true);
/*     */   }
/*     */   
/*     */   public ReversiblePeekingIterable<Node> getDescendants() {
/* 189 */     if (this.firstChild == null) {
/* 190 */       return NodeIterable.EMPTY;
/*     */     }
/* 192 */     return new DescendantNodeIterable(getChildren());
/*     */   }
/*     */   
/*     */   public ReversiblePeekingIterable<Node> getReversedDescendants() {
/* 196 */     if (this.firstChild == null) {
/* 197 */       return NodeIterable.EMPTY;
/*     */     }
/* 199 */     return new DescendantNodeIterable(getReversedChildren());
/*     */   }
/*     */   
/*     */   public ReversiblePeekingIterator<Node> getChildIterator() {
/* 203 */     if (this.firstChild == null) {
/* 204 */       return NodeIterator.EMPTY;
/*     */     }
/* 206 */     return new NodeIterator(this.firstChild, this.lastChild, false);
/*     */   }
/*     */   
/*     */   public ReversiblePeekingIterator<Node> getReversedChildIterator() {
/* 210 */     if (this.firstChild == null) {
/* 211 */       return NodeIterator.EMPTY;
/*     */     }
/* 213 */     return new NodeIterator(this.firstChild, this.lastChild, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public BasedSequence getChars() {
/* 218 */     return this.chars;
/*     */   }
/*     */   
/*     */   public void removeChildren() {
/* 222 */     Node node = this.firstChild;
/* 223 */     while (node != null) {
/* 224 */       Node node1 = node.getNext();
/* 225 */       node.unlink();
/* 226 */       node = node1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean hasChildren() {
/* 231 */     return (this.firstChild != null);
/*     */   }
/*     */   
/*     */   public boolean hasOrMoreChildren(int paramInt) {
/* 235 */     if (this.firstChild != null) {
/* 236 */       byte b = 0;
/* 237 */       for (ReversiblePeekingIterator reversiblePeekingIterator = getChildren().iterator(); reversiblePeekingIterator.hasNext(); ) { reversiblePeekingIterator.next();
/* 238 */         b++;
/* 239 */         if (b >= paramInt) return true;  }
/*     */     
/*     */     } 
/* 242 */     return false;
/*     */   }
/*     */   
/*     */   public Document getDocument() {
/* 246 */     Node node = this;
/* 247 */     while (node != null && !(node instanceof Document)) {
/* 248 */       node = node.getParent();
/*     */     }
/* 250 */     assert node != null : "Node should always have Document ancestor";
/* 251 */     return (Document)node;
/*     */   }
/*     */   
/*     */   public void setChars(BasedSequence paramBasedSequence) {
/* 255 */     this.chars = paramBasedSequence;
/*     */   }
/*     */ 
/*     */   
/*     */   public Node getNext() {
/* 260 */     return this.next;
/*     */   }
/*     */ 
/*     */   
/*     */   public Node getLastInChain() {
/* 265 */     Node node = this;
/* 266 */     for (; getClass().isInstance(node.getNext()); node = node.getNext());
/* 267 */     return node;
/*     */   }
/*     */   
/*     */   public Node getPrevious() {
/* 271 */     return this.prev;
/*     */   }
/*     */   
/*     */   public void extractToFirstInChain(Node paramNode) {
/* 275 */     getFirstInChain().extractChainTo(paramNode);
/*     */   }
/*     */   
/*     */   public void extractChainTo(Node paramNode) {
/* 279 */     Node node = this;
/*     */     do {
/* 281 */       Node node1 = node.getNext();
/* 282 */       paramNode.appendChild(node);
/* 283 */       node = node1;
/* 284 */     } while (getClass().isInstance(node));
/*     */   }
/*     */   
/*     */   public Node getFirstInChain() {
/* 288 */     Node node = this;
/* 289 */     for (; getClass().isInstance(node.getPrevious()); node = node.getPrevious());
/* 290 */     return node;
/*     */   }
/*     */   
/*     */   public Node getPreviousAnyNot(Class<?>... paramVarArgs) {
/* 294 */     Node node = this.prev;
/* 295 */     if (paramVarArgs.length > 0) {
/* 296 */       while (node != null && getNodeOfTypeIndex(node, paramVarArgs) != -1) {
/* 297 */         node = node.prev;
/*     */       }
/*     */     }
/* 300 */     return node;
/*     */   }
/*     */   
/*     */   public Node getPreviousAny(Class<?>... paramVarArgs) {
/* 304 */     Node node = this.prev;
/* 305 */     if (paramVarArgs.length > 0) {
/* 306 */       while (node != null && getNodeOfTypeIndex(node, paramVarArgs) == -1) {
/* 307 */         node = node.prev;
/*     */       }
/*     */     }
/* 310 */     return node;
/*     */   }
/*     */   
/*     */   public Node getNextAnyNot(Class<?>... paramVarArgs) {
/* 314 */     Node node = this.next;
/* 315 */     if (paramVarArgs.length > 0) {
/* 316 */       while (node != null && getNodeOfTypeIndex(node, paramVarArgs) != -1) {
/* 317 */         node = node.next;
/*     */       }
/*     */     }
/* 320 */     return node;
/*     */   }
/*     */   
/*     */   public Node getNextAny(Class<?>... paramVarArgs) {
/* 324 */     Node node = this.next;
/* 325 */     if (paramVarArgs.length > 0) {
/* 326 */       while (node != null && getNodeOfTypeIndex(node, paramVarArgs) == -1) {
/* 327 */         node = node.next;
/*     */       }
/*     */     }
/* 330 */     return node;
/*     */   }
/*     */   
/*     */   public Node getFirstChild() {
/* 334 */     return this.firstChild;
/*     */   }
/*     */   
/*     */   public Node getFirstChildAnyNot(Class<?>... paramVarArgs) {
/* 338 */     Node node = this.firstChild;
/* 339 */     if (paramVarArgs.length > 0) {
/* 340 */       while (node != null && getNodeOfTypeIndex(node, paramVarArgs) != -1) {
/* 341 */         node = node.next;
/*     */       }
/*     */     }
/* 344 */     return node;
/*     */   }
/*     */   
/*     */   public Node getFirstChildAny(Class<?>... paramVarArgs) {
/* 348 */     Node node = this.firstChild;
/* 349 */     if (paramVarArgs.length > 0) {
/* 350 */       while (node != null && getNodeOfTypeIndex(node, paramVarArgs) == -1) {
/* 351 */         node = node.next;
/*     */       }
/*     */     }
/* 354 */     return node;
/*     */   }
/*     */   
/*     */   public Node getLastChild() {
/* 358 */     return this.lastChild;
/*     */   }
/*     */   
/*     */   public Node getLastChildAnyNot(Class<?>... paramVarArgs) {
/* 362 */     Node node = this.lastChild;
/* 363 */     if (paramVarArgs.length > 0) {
/* 364 */       while (node != null && getNodeOfTypeIndex(node, paramVarArgs) != -1) {
/* 365 */         node = node.prev;
/*     */       }
/*     */     }
/* 368 */     return node;
/*     */   }
/*     */   
/*     */   public Node getLastChildAny(Class<?>... paramVarArgs) {
/* 372 */     Node node = this.lastChild;
/* 373 */     if (paramVarArgs.length > 0) {
/* 374 */       while (node != null && getNodeOfTypeIndex(node, paramVarArgs) == -1) {
/* 375 */         node = node.prev;
/*     */       }
/*     */     }
/* 378 */     return node;
/*     */   }
/*     */   
/*     */   public Node getParent() {
/* 382 */     return this.parent;
/*     */   }
/*     */   
/*     */   public Node getGrandParent() {
/* 386 */     return (this.parent == null) ? null : this.parent.getParent();
/*     */   }
/*     */   
/*     */   protected void setParent(Node paramNode) {
/* 390 */     this.parent = paramNode;
/*     */   }
/*     */   
/*     */   public void appendChild(Node paramNode) {
/* 394 */     paramNode.unlink();
/* 395 */     paramNode.setParent(this);
/* 396 */     if (this.lastChild != null) {
/* 397 */       this.lastChild.next = paramNode;
/* 398 */       paramNode.prev = this.lastChild;
/* 399 */       this.lastChild = paramNode; return;
/*     */     } 
/* 401 */     this.firstChild = paramNode;
/* 402 */     this.lastChild = paramNode;
/*     */   }
/*     */ 
/*     */   
/*     */   public void prependChild(Node paramNode) {
/* 407 */     paramNode.unlink();
/* 408 */     paramNode.setParent(this);
/* 409 */     if (this.firstChild != null) {
/* 410 */       this.firstChild.prev = paramNode;
/* 411 */       paramNode.next = this.firstChild;
/* 412 */       this.firstChild = paramNode; return;
/*     */     } 
/* 414 */     this.firstChild = paramNode;
/* 415 */     this.lastChild = paramNode;
/*     */   }
/*     */ 
/*     */   
/*     */   public void unlink() {
/* 420 */     if (this.prev != null) {
/* 421 */       this.prev.next = this.next;
/* 422 */     } else if (this.parent != null) {
/* 423 */       this.parent.firstChild = this.next;
/*     */     } 
/* 425 */     if (this.next != null) {
/* 426 */       this.next.prev = this.prev;
/* 427 */     } else if (this.parent != null) {
/* 428 */       this.parent.lastChild = this.prev;
/*     */     } 
/* 430 */     this.parent = null;
/* 431 */     this.next = null;
/* 432 */     this.prev = null;
/*     */   }
/*     */   
/*     */   public void insertAfter(Node paramNode) {
/* 436 */     paramNode.unlink();
/*     */     
/* 438 */     paramNode.next = this.next;
/* 439 */     if (paramNode.next != null) {
/* 440 */       paramNode.next.prev = paramNode;
/*     */     }
/*     */     
/* 443 */     paramNode.prev = this;
/* 444 */     this.next = paramNode;
/* 445 */     paramNode.parent = this.parent;
/* 446 */     if (paramNode.next == null) {
/* 447 */       assert paramNode.parent != null;
/* 448 */       paramNode.parent.lastChild = paramNode;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insertBefore(Node paramNode) {
/* 453 */     paramNode.unlink();
/* 454 */     paramNode.prev = this.prev;
/* 455 */     if (paramNode.prev != null) {
/* 456 */       paramNode.prev.next = paramNode;
/*     */     }
/* 458 */     paramNode.next = this;
/* 459 */     this.prev = paramNode;
/* 460 */     paramNode.parent = this.parent;
/* 461 */     if (paramNode.prev == null) {
/* 462 */       assert paramNode.parent != null;
/* 463 */       paramNode.parent.firstChild = paramNode;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 469 */     return getClass().getName().substring(getClass().getPackage().getName().length() + 1) + "{" + toStringAttributes() + "}";
/*     */   }
/*     */ 
/*     */   
/*     */   public void getAstExtra(StringBuilder paramStringBuilder) {}
/*     */ 
/*     */   
/*     */   public void astExtraChars(StringBuilder paramStringBuilder) {
/* 477 */     if (getChars().length() > 0) {
/* 478 */       if (getChars().length() <= 10) {
/* 479 */         segmentSpanChars(paramStringBuilder, getChars(), "chars");
/*     */         return;
/*     */       } 
/* 482 */       segmentSpanChars(paramStringBuilder, getChars().getStartOffset(), getChars().getEndOffset(), "chars", getChars().subSequence(0, 5).toVisibleWhitespaceString(), " … ", ((BasedSequence)getChars().subSequence(getChars().length() - 5)).toVisibleWhitespaceString());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void astChars(StringBuilder paramStringBuilder, CharSequence paramCharSequence, String paramString) {
/* 488 */     if (paramCharSequence.length() > 0) {
/* 489 */       if (paramCharSequence.length() <= 10) {
/* 490 */         paramStringBuilder.append(' ').append(paramString).append(" \"").append(paramCharSequence).append("\"");
/*     */         return;
/*     */       } 
/* 493 */       paramStringBuilder.append(' ').append(paramString).append(" \"").append(paramCharSequence.subSequence(0, 5)).append(" … ").append(paramCharSequence.subSequence(paramCharSequence.length() - 5, paramCharSequence.length())).append("\"");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String toStringAttributes() {
/* 500 */     return "";
/*     */   }
/*     */   
/*     */   public abstract BasedSequence[] getSegments();
/*     */   
/*     */   public static BasedSequence getLeadSegment(BasedSequence[] paramArrayOfBasedSequence) {
/*     */     int i;
/*     */     byte b;
/* 508 */     for (i = (paramArrayOfBasedSequence = paramArrayOfBasedSequence).length, b = 0; b < i; b++) {
/* 509 */       BasedSequence basedSequence; if ((basedSequence = paramArrayOfBasedSequence[b]) != BasedSequence.NULL) return basedSequence;
/*     */     
/*     */     } 
/* 512 */     return BasedSequence.NULL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BasedSequence getTrailSegment(BasedSequence[] paramArrayOfBasedSequence) {
/* 519 */     for (int i = paramArrayOfBasedSequence.length; i-- > 0;) {
/*     */       
/* 521 */       if ((basedSequence = paramArrayOfBasedSequence[i]) != BasedSequence.NULL) return basedSequence;
/*     */     
/*     */     } 
/* 524 */     return BasedSequence.NULL;
/*     */   }
/*     */ 
/*     */   
/*     */   public static BasedSequence spanningChars(BasedSequence... paramVarArgs) {
/* 529 */     int i = Integer.MAX_VALUE;
/* 530 */     int j = -1;
/* 531 */     BasedSequence basedSequence1 = null;
/* 532 */     BasedSequence basedSequence2 = null; int k; byte b;
/* 533 */     for (k = (paramVarArgs = paramVarArgs).length, b = 0; b < k; b++) {
/* 534 */       BasedSequence basedSequence; if ((basedSequence = paramVarArgs[b]) != BasedSequence.NULL) {
/* 535 */         if (i > basedSequence.getStartOffset()) {
/* 536 */           i = basedSequence.getStartOffset();
/* 537 */           basedSequence1 = basedSequence;
/*     */         } 
/*     */         
/* 540 */         if (j <= basedSequence.getEndOffset()) {
/* 541 */           j = basedSequence.getEndOffset();
/* 542 */           basedSequence2 = basedSequence;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 547 */     if (basedSequence1 != null && basedSequence2 != null) {
/* 548 */       return basedSequence1.baseSubSequence(basedSequence1.getStartOffset(), basedSequence2.getEndOffset());
/*     */     }
/* 550 */     return BasedSequence.NULL;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCharsFromContentOnly() {
/* 555 */     this.chars = BasedSequence.NULL;
/* 556 */     setCharsFromContent();
/*     */   }
/*     */   
/*     */   public void setCharsFromContent() {
/* 560 */     BasedSequence[] arrayOfBasedSequence = getSegments();
/* 561 */     BasedSequence basedSequence = null;
/*     */     
/* 563 */     if (arrayOfBasedSequence.length > 0) {
/* 564 */       BasedSequence arrayOfBasedSequence1[], basedSequence2 = getLeadSegment(arrayOfBasedSequence);
/* 565 */       BasedSequence basedSequence1 = getTrailSegment(arrayOfBasedSequence);
/*     */       
/* 567 */       if (this.firstChild == null || this.lastChild == null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 573 */         basedSequence = spanningChars(arrayOfBasedSequence1 = new BasedSequence[] { basedSequence2, basedSequence1 });
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */ 
/*     */         
/* 582 */         basedSequence = spanningChars(arrayOfBasedSequence1 = new BasedSequence[] { basedSequence2, (BasedSequence)arrayOfBasedSequence1, this.firstChild.chars, this.lastChild.chars });
/*     */       } 
/* 584 */     } else if (this.firstChild != null && this.lastChild != null) {
/*     */       BasedSequence[] arrayOfBasedSequence1;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 590 */       basedSequence = spanningChars(arrayOfBasedSequence1 = new BasedSequence[] { this.firstChild.chars, this.lastChild.chars });
/*     */     } 
/*     */     
/* 593 */     if (basedSequence != null) {
/*     */       
/* 595 */       if (this.chars.isNull()) {
/* 596 */         setChars(basedSequence); return;
/*     */       } 
/* 598 */       int j = Utils.min(this.chars.getStartOffset(), new int[] { basedSequence.getStartOffset() });
/* 599 */       int i = Utils.max(this.chars.getEndOffset(), new int[] { basedSequence.getEndOffset() });
/* 600 */       setChars(this.chars.baseSubSequence(j, i));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void segmentSpan(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, String paramString) {
/* 606 */     if (paramString != null && !paramString.trim().isEmpty()) paramStringBuilder.append(" ").append(paramString).append(":"); 
/* 607 */     paramStringBuilder.append("[").append(paramInt1).append(", ").append(paramInt2).append("]");
/*     */   }
/*     */   
/*     */   public static void segmentSpanChars(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, String paramString1, String paramString2) {
/* 611 */     segmentSpanChars(paramStringBuilder, paramInt1, paramInt2, paramString1, paramString2, "", "");
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
/*     */   public static void segmentSpanChars(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4) {
/* 623 */     if (paramString1 != null && !paramString1.trim().isEmpty()) paramStringBuilder.append(" ").append(paramString1).append(":"); 
/* 624 */     paramStringBuilder.append("[").append(paramInt1).append(", ").append(paramInt2);
/* 625 */     if (!paramString2.isEmpty() || !paramString4.isEmpty()) {
/* 626 */       paramStringBuilder.append(", \"");
/* 627 */       Utils.escapeJavaString(paramStringBuilder, paramString2);
/* 628 */       paramStringBuilder.append(paramString3);
/* 629 */       Utils.escapeJavaString(paramStringBuilder, paramString4);
/* 630 */       paramStringBuilder.append("\"");
/*     */     } 
/* 632 */     paramStringBuilder.append("]");
/*     */   }
/*     */   
/*     */   public static void segmentSpan(StringBuilder paramStringBuilder, BasedSequence paramBasedSequence, String paramString) {
/* 636 */     if (paramBasedSequence.isNotNull()) segmentSpan(paramStringBuilder, paramBasedSequence.getStartOffset(), paramBasedSequence.getEndOffset(), paramString); 
/*     */   }
/*     */   
/*     */   public static void segmentSpanChars(StringBuilder paramStringBuilder, BasedSequence paramBasedSequence, String paramString) {
/* 640 */     if (paramBasedSequence.isNotNull())
/* 641 */       segmentSpanChars(paramStringBuilder, paramBasedSequence.getStartOffset(), paramBasedSequence.getEndOffset(), paramString, paramBasedSequence.toString()); 
/*     */   }
/*     */   
/*     */   public static void segmentSpanCharsToVisible(StringBuilder paramStringBuilder, BasedSequence paramBasedSequence, String paramString) {
/* 645 */     if (paramBasedSequence.isNotNull()) {
/* 646 */       if (paramBasedSequence.length() <= 10) {
/* 647 */         segmentSpanChars(paramStringBuilder, paramBasedSequence.getStartOffset(), paramBasedSequence.getEndOffset(), paramString, paramBasedSequence.toVisibleWhitespaceString());
/*     */         return;
/*     */       } 
/* 650 */       segmentSpanChars(paramStringBuilder, paramBasedSequence.getStartOffset(), paramBasedSequence.getEndOffset(), paramString, paramBasedSequence.subSequence(0, 5).toVisibleWhitespaceString(), " … ", ((BasedSequence)paramBasedSequence.endSequence(paramBasedSequence.length() - 5)).toVisibleWhitespaceString());
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
/*     */   public static void delimitedSegmentSpan(StringBuilder paramStringBuilder, BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, String paramString) {
/* 662 */     segmentSpanChars(paramStringBuilder, paramBasedSequence1.getStartOffset(), paramBasedSequence1.getEndOffset(), paramString + "Open", paramBasedSequence1.toString());
/* 663 */     if (paramBasedSequence2.length() <= 10) {
/* 664 */       segmentSpanChars(paramStringBuilder, paramBasedSequence2.getStartOffset(), paramBasedSequence2.getEndOffset(), paramString, paramBasedSequence2.toVisibleWhitespaceString());
/*     */     } else {
/*     */       
/* 667 */       segmentSpanChars(paramStringBuilder, paramBasedSequence2.getStartOffset(), paramBasedSequence2.getEndOffset(), paramString, paramBasedSequence2.subSequence(0, 5).toVisibleWhitespaceString(), " … ", ((BasedSequence)paramBasedSequence2.endSequence(paramBasedSequence2.length() - 5)).toVisibleWhitespaceString());
/*     */     } 
/* 669 */     segmentSpanChars(paramStringBuilder, paramBasedSequence3.getStartOffset(), paramBasedSequence3.getEndOffset(), paramString + "Close", paramBasedSequence3.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void delimitedSegmentSpanChars(StringBuilder paramStringBuilder, BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, String paramString) {
/* 679 */     if (paramBasedSequence1.isNotNull())
/* 680 */       segmentSpanChars(paramStringBuilder, paramBasedSequence1.getStartOffset(), paramBasedSequence1.getEndOffset(), paramString + "Open", paramBasedSequence1.toString()); 
/* 681 */     if (paramBasedSequence2.isNotNull())
/* 682 */       segmentSpanChars(paramStringBuilder, paramBasedSequence2.getStartOffset(), paramBasedSequence2.getEndOffset(), paramString, paramBasedSequence2.toVisibleWhitespaceString()); 
/* 683 */     if (paramBasedSequence3.isNotNull())
/* 684 */       segmentSpanChars(paramStringBuilder, paramBasedSequence3.getStartOffset(), paramBasedSequence3.getEndOffset(), paramString + "Close", paramBasedSequence3.toString()); 
/*     */   }
/*     */   
/*     */   public void takeChildren(Node paramNode) {
/* 688 */     if (paramNode.firstChild != null) {
/* 689 */       Node node1 = paramNode.firstChild;
/* 690 */       Node node2 = paramNode.lastChild;
/* 691 */       assert node2 != null;
/*     */       
/* 693 */       if (node2 != node1) {
/* 694 */         paramNode.firstChild = null;
/* 695 */         paramNode.lastChild = null;
/*     */         
/* 697 */         node1.parent = this;
/* 698 */         node2.parent = this;
/*     */         
/* 700 */         if (this.lastChild != null) {
/* 701 */           this.lastChild.next = node1;
/* 702 */           node1.prev = this.lastChild;
/*     */         } else {
/* 704 */           this.firstChild = node1;
/*     */         } 
/*     */         
/* 707 */         this.lastChild = node2;
/*     */         return;
/*     */       } 
/* 710 */       appendChild(node1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getNodeName() {
/* 716 */     return getClass().getName().substring(getClass().getPackage().getName().length() + 1);
/*     */   }
/*     */   
/*     */   public void astString(StringBuilder paramStringBuilder, boolean paramBoolean) {
/* 720 */     paramStringBuilder.append(getNodeName());
/* 721 */     paramStringBuilder.append("[").append(getStartOffset()).append(", ").append(getEndOffset()).append("]");
/* 722 */     if (paramBoolean) getAstExtra(paramStringBuilder); 
/*     */   }
/*     */   
/*     */   public String toAstString(boolean paramBoolean) {
/* 726 */     StringBuilder stringBuilder = new StringBuilder();
/* 727 */     astString(stringBuilder, paramBoolean);
/* 728 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static String toSegmentSpan(BasedSequence paramBasedSequence, String paramString) {
/*     */     StringBuilder stringBuilder;
/* 733 */     segmentSpan(stringBuilder = new StringBuilder(), paramBasedSequence, paramString);
/* 734 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public BasedSequence getChildChars() {
/* 738 */     if (this.firstChild == null || this.lastChild == null) {
/* 739 */       return BasedSequence.NULL;
/*     */     }
/*     */     
/* 742 */     return this.firstChild.baseSubSequence(this.firstChild.getStartOffset(), this.lastChild.getEndOffset());
/*     */   }
/*     */   
/*     */   public BasedSequence getExactChildChars() {
/* 746 */     if (this.firstChild == null || this.lastChild == null) {
/* 747 */       return BasedSequence.NULL;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 752 */     Node node = getFirstChild();
/* 753 */     SequenceBuilder sequenceBuilder = SequenceBuilder.emptyBuilder(getChars());
/*     */     
/* 755 */     while (node != null) {
/* 756 */       node.getChars().addSegments((IBasedSegmentBuilder)sequenceBuilder.getSegmentBuilder());
/* 757 */       node = node.getNext();
/*     */     } 
/*     */     
/* 760 */     return sequenceBuilder.toSequence();
/*     */   }
/*     */ 
/*     */   
/*     */   public Node getBlankLineSibling() {
/* 765 */     assert this.parent != null;
/*     */     
/* 767 */     Node node1 = this.parent;
/* 768 */     Node node2 = this;
/* 769 */     Node node3 = this;
/*     */     
/* 771 */     while (node1.parent != null) {
/*     */       boolean bool;
/* 773 */       if (bool = (node1 == node1.parent.getLastChildAnyNot(new Class[] { BlankLine.class })) ? true : false) {
/*     */         
/* 775 */         node2 = node3;
/* 776 */         if (node1 instanceof BlankLineContainer) {
/* 777 */           node3 = node1;
/*     */         }
/*     */ 
/*     */         
/* 781 */         if ((node1 = node1.parent) != null);
/*     */       } 
/*     */     } 
/* 784 */     return node2;
/*     */   }
/*     */   
/*     */   public void moveTrailingBlankLines() {
/*     */     Node node;
/* 789 */     if (node = getLastChild() instanceof BlankLine) {
/* 790 */       Node node1 = getBlankLineSibling();
/* 791 */       node = node.getFirstInChain();
/* 792 */       node1.insertChainAfter(node);
/*     */       
/* 794 */       node = this;
/*     */       do {
/* 796 */         node.setCharsFromContentOnly();
/*     */       
/*     */       }
/* 799 */       while ((node = node.parent) != null && node != node1.getParent());
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getLineNumber() {
/* 804 */     return getStartLineNumber();
/*     */   }
/*     */   
/*     */   public int getStartLineNumber() {
/* 808 */     return getDocument().getLineNumber(this.chars.getStartOffset());
/*     */   }
/*     */   
/*     */   public int getEndLineNumber() {
/* 812 */     int i = this.chars.getEndOffset();
/* 813 */     return getDocument().getLineNumber((i > 0) ? (i - 1) : i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence[] getSegmentsForChars() {
/* 824 */     return getSegments();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence getCharsFromSegments() {
/*     */     BasedSequence[] arrayOfBasedSequence;
/* 836 */     return ((arrayOfBasedSequence = getSegmentsForChars()).length == 0) ? BasedSequence.NULL : SegmentedSequence.create(arrayOfBasedSequence[0], Arrays.asList(arrayOfBasedSequence));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCharsFromSegments() {
/* 845 */     setChars(getCharsFromSegments());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendChain(Node paramNode) {
/* 854 */     paramNode = paramNode;
/* 855 */     while (paramNode != null) {
/* 856 */       Node node = paramNode.next;
/* 857 */       appendChild(paramNode);
/* 858 */       paramNode = node;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertChainAfter(Node paramNode) {
/* 868 */     Node node = this;
/* 869 */     paramNode = paramNode;
/* 870 */     while (paramNode != null) {
/* 871 */       Node node1 = paramNode.next;
/* 872 */       node.insertAfter(paramNode);
/* 873 */       node = paramNode;
/* 874 */       paramNode = node1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertChainBefore(Node paramNode) {
/* 884 */     Node node = this;
/* 885 */     paramNode = paramNode;
/* 886 */     while (paramNode != null) {
/* 887 */       Node node1 = paramNode.next;
/* 888 */       node.insertBefore(paramNode);
/* 889 */       paramNode = node1;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\Node.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */