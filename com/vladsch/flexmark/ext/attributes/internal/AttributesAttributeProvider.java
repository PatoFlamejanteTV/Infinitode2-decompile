/*    */ package com.vladsch.flexmark.ext.attributes.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.attributes.AttributesExtension;
/*    */ import com.vladsch.flexmark.html.AttributeProvider;
/*    */ import com.vladsch.flexmark.html.IndependentAttributeProviderFactory;
/*    */ import com.vladsch.flexmark.html.renderer.AttributablePart;
/*    */ import com.vladsch.flexmark.html.renderer.LinkResolverContext;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.html.MutableAttributes;
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
/*    */ public class AttributesAttributeProvider
/*    */   implements AttributeProvider
/*    */ {
/*    */   private final NodeAttributeRepository nodeAttributeRepository;
/*    */   private final AttributesOptions attributeOptions;
/*    */   
/*    */   public AttributesAttributeProvider(LinkResolverContext paramLinkResolverContext) {
/* 28 */     DataHolder dataHolder = paramLinkResolverContext.getOptions();
/* 29 */     this.attributeOptions = new AttributesOptions(dataHolder);
/* 30 */     this.nodeAttributeRepository = (NodeAttributeRepository)AttributesExtension.NODE_ATTRIBUTES.get(dataHolder);
/*    */   }
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setAttributes(Node paramNode, AttributablePart paramAttributablePart, MutableAttributes paramMutableAttributes) {
/*    */     // Byte code:
/*    */     //   0: aload_2
/*    */     //   1: getstatic com/vladsch/flexmark/html/renderer/CoreNodeRenderer.CODE_CONTENT : Lcom/vladsch/flexmark/html/renderer/AttributablePart;
/*    */     //   4: if_acmpne -> 23
/*    */     //   7: aload_0
/*    */     //   8: getfield attributeOptions : Lcom/vladsch/flexmark/ext/attributes/internal/AttributesOptions;
/*    */     //   11: getfield fencedCodeAddAttributes : Lcom/vladsch/flexmark/ext/attributes/FencedCodeAddType;
/*    */     //   14: getfield addToCode : Z
/*    */     //   17: ifeq -> 262
/*    */     //   20: goto -> 36
/*    */     //   23: aload_0
/*    */     //   24: getfield attributeOptions : Lcom/vladsch/flexmark/ext/attributes/internal/AttributesOptions;
/*    */     //   27: getfield fencedCodeAddAttributes : Lcom/vladsch/flexmark/ext/attributes/FencedCodeAddType;
/*    */     //   30: getfield addToPre : Z
/*    */     //   33: ifeq -> 262
/*    */     //   36: aload_0
/*    */     //   37: getfield nodeAttributeRepository : Lcom/vladsch/flexmark/ext/attributes/internal/NodeAttributeRepository;
/*    */     //   40: aload_1
/*    */     //   41: invokevirtual get : (Ljava/lang/Object;)Ljava/util/ArrayList;
/*    */     //   44: dup
/*    */     //   45: astore_2
/*    */     //   46: ifnull -> 262
/*    */     //   49: aload_2
/*    */     //   50: invokevirtual iterator : ()Ljava/util/Iterator;
/*    */     //   53: astore_2
/*    */     //   54: aload_2
/*    */     //   55: invokeinterface hasNext : ()Z
/*    */     //   60: ifeq -> 262
/*    */     //   63: aload_2
/*    */     //   64: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   69: checkcast com/vladsch/flexmark/ext/attributes/AttributesNode
/*    */     //   72: dup
/*    */     //   73: astore #4
/*    */     //   75: invokevirtual getChildren : ()Lcom/vladsch/flexmark/util/collection/iteration/ReversiblePeekingIterable;
/*    */     //   78: invokeinterface iterator : ()Lcom/vladsch/flexmark/util/collection/iteration/ReversiblePeekingIterator;
/*    */     //   83: astore #4
/*    */     //   85: aload #4
/*    */     //   87: invokeinterface hasNext : ()Z
/*    */     //   92: ifeq -> 259
/*    */     //   95: aload #4
/*    */     //   97: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   102: checkcast com/vladsch/flexmark/util/ast/Node
/*    */     //   105: dup
/*    */     //   106: astore #5
/*    */     //   108: instanceof com/vladsch/flexmark/ext/attributes/AttributeNode
/*    */     //   111: ifeq -> 85
/*    */     //   114: aload #5
/*    */     //   116: checkcast com/vladsch/flexmark/ext/attributes/AttributeNode
/*    */     //   119: dup
/*    */     //   120: astore #5
/*    */     //   122: invokevirtual isImplicitName : ()Z
/*    */     //   125: ifne -> 186
/*    */     //   128: aload #5
/*    */     //   130: invokevirtual getName : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*    */     //   133: dup
/*    */     //   134: astore #6
/*    */     //   136: invokeinterface isNotNull : ()Z
/*    */     //   141: ifeq -> 183
/*    */     //   144: aload #6
/*    */     //   146: invokeinterface isBlank : ()Z
/*    */     //   151: ifne -> 183
/*    */     //   154: aload #6
/*    */     //   156: ldc 'class'
/*    */     //   158: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   161: ifne -> 171
/*    */     //   164: aload_3
/*    */     //   165: aload #6
/*    */     //   167: invokevirtual remove : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/html/Attribute;
/*    */     //   170: pop
/*    */     //   171: aload_3
/*    */     //   172: aload #6
/*    */     //   174: aload #5
/*    */     //   176: invokevirtual getValue : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*    */     //   179: invokevirtual addValue : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/html/Attribute;
/*    */     //   182: pop
/*    */     //   183: goto -> 85
/*    */     //   186: aload #5
/*    */     //   188: invokevirtual isClass : ()Z
/*    */     //   191: ifeq -> 209
/*    */     //   194: aload_3
/*    */     //   195: ldc 'class'
/*    */     //   197: aload #5
/*    */     //   199: invokevirtual getValue : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*    */     //   202: invokevirtual addValue : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/html/Attribute;
/*    */     //   205: pop
/*    */     //   206: goto -> 85
/*    */     //   209: aload #5
/*    */     //   211: invokevirtual isId : ()Z
/*    */     //   214: ifeq -> 246
/*    */     //   217: aload_1
/*    */     //   218: instanceof com/vladsch/flexmark/ast/AnchorRefTarget
/*    */     //   221: ifne -> 256
/*    */     //   224: aload_3
/*    */     //   225: ldc 'id'
/*    */     //   227: invokevirtual remove : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/html/Attribute;
/*    */     //   230: pop
/*    */     //   231: aload_3
/*    */     //   232: ldc 'id'
/*    */     //   234: aload #5
/*    */     //   236: invokevirtual getValue : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*    */     //   239: invokevirtual addValue : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/html/Attribute;
/*    */     //   242: pop
/*    */     //   243: goto -> 85
/*    */     //   246: new java/lang/IllegalStateException
/*    */     //   249: dup
/*    */     //   250: ldc 'Implicit attribute yet not class or id'
/*    */     //   252: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   255: athrow
/*    */     //   256: goto -> 85
/*    */     //   259: goto -> 54
/*    */     //   262: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #36	-> 0
/*    */     //   #37	-> 36
/*    */     //   #38	-> 45
/*    */     //   #40	-> 49
/*    */     //   #41	-> 73
/*    */     //   #42	-> 106
/*    */     //   #44	-> 114
/*    */     //   #45	-> 120
/*    */     //   #46	-> 128
/*    */     //   #47	-> 134
/*    */     //   #48	-> 154
/*    */     //   #49	-> 164
/*    */     //   #51	-> 171
/*    */     //   #55	-> 183
/*    */     //   #57	-> 186
/*    */     //   #58	-> 194
/*    */     //   #59	-> 209
/*    */     //   #60	-> 217
/*    */     //   #63	-> 224
/*    */     //   #64	-> 231
/*    */     //   #68	-> 246
/*    */     //   #71	-> 256
/*    */     //   #72	-> 259
/*    */     //   #75	-> 262
/*    */   }
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Factory
/*    */     extends IndependentAttributeProviderFactory
/*    */   {
/*    */     public AttributeProvider apply(LinkResolverContext param1LinkResolverContext) {
/* 96 */       return new AttributesAttributeProvider(param1LinkResolverContext);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\attributes\internal\AttributesAttributeProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */