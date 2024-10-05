/*    */ package com.vladsch.flexmark.parser.core.delimiter;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.Text;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
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
/*    */ public class Bracket
/*    */ {
/*    */   private final Text node;
/*    */   private final int index;
/*    */   private final boolean image;
/*    */   private final Bracket previous;
/*    */   private final Delimiter previousDelimiter;
/*    */   private boolean allowed = true;
/*    */   private boolean bracketAfter = false;
/*    */   
/*    */   public boolean isAllowed() {
/* 36 */     return this.allowed;
/*    */   }
/*    */   
/*    */   public void setAllowed(boolean paramBoolean) {
/* 40 */     this.allowed = paramBoolean;
/*    */   }
/*    */   
/*    */   public boolean isBracketAfter() {
/* 44 */     return this.bracketAfter;
/*    */   }
/*    */   
/*    */   public void setBracketAfter(boolean paramBoolean) {
/* 48 */     this.bracketAfter = paramBoolean;
/*    */   }
/*    */   
/*    */   public Bracket getPrevious() {
/* 52 */     return this.previous;
/*    */   }
/*    */   
/*    */   public boolean isImage() {
/* 56 */     return this.image;
/*    */   }
/*    */   
/*    */   public Delimiter getPreviousDelimiter() {
/* 60 */     return this.previousDelimiter;
/*    */   }
/*    */   
/*    */   public int getStartIndex() {
/* 64 */     return this.index;
/*    */   }
/*    */   
/*    */   public int getEndIndex() {
/* 68 */     return this.image ? (this.index + 2) : (this.index + 1);
/*    */   }
/*    */   
/*    */   public Text getNode() {
/* 72 */     return this.node;
/*    */   }
/*    */   
/*    */   public static Bracket link(BasedSequence paramBasedSequence, Text paramText, int paramInt, Bracket paramBracket, Delimiter paramDelimiter) {
/* 76 */     return new Bracket(paramBasedSequence, paramText, paramInt, paramBracket, paramDelimiter, false);
/*    */   }
/*    */   
/*    */   public static Bracket image(BasedSequence paramBasedSequence, Text paramText, int paramInt, Bracket paramBracket, Delimiter paramDelimiter) {
/* 80 */     return new Bracket(paramBasedSequence, paramText, paramInt, paramBracket, paramDelimiter, true);
/*    */   }
/*    */   
/*    */   private Bracket(BasedSequence paramBasedSequence, Text paramText, int paramInt, Bracket paramBracket, Delimiter paramDelimiter, boolean paramBoolean) {
/* 84 */     this.node = paramText;
/* 85 */     this.index = paramInt;
/* 86 */     this.image = paramBoolean;
/* 87 */     this.previous = paramBracket;
/* 88 */     this.previousDelimiter = paramDelimiter;
/*    */   }
/*    */   
/*    */   public boolean isStraddling(BasedSequence paramBasedSequence) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: invokeinterface getStartOffset : ()I
/*    */     //   6: istore_2
/*    */     //   7: aload_1
/*    */     //   8: invokeinterface getEndOffset : ()I
/*    */     //   13: istore_1
/*    */     //   14: aload_0
/*    */     //   15: getfield previousDelimiter : Lcom/vladsch/flexmark/parser/core/delimiter/Delimiter;
/*    */     //   18: ifnonnull -> 25
/*    */     //   21: aconst_null
/*    */     //   22: goto -> 32
/*    */     //   25: aload_0
/*    */     //   26: getfield previousDelimiter : Lcom/vladsch/flexmark/parser/core/delimiter/Delimiter;
/*    */     //   29: invokevirtual getNext : ()Lcom/vladsch/flexmark/parser/core/delimiter/Delimiter;
/*    */     //   32: dup
/*    */     //   33: astore_3
/*    */     //   34: ifnull -> 70
/*    */     //   37: aload_3
/*    */     //   38: invokevirtual getEndIndex : ()I
/*    */     //   41: dup
/*    */     //   42: istore #4
/*    */     //   44: iload_1
/*    */     //   45: if_icmpge -> 70
/*    */     //   48: iload #4
/*    */     //   50: iload_2
/*    */     //   51: if_icmplt -> 63
/*    */     //   54: aload_3
/*    */     //   55: invokevirtual isMatched : ()Z
/*    */     //   58: ifne -> 63
/*    */     //   61: iconst_1
/*    */     //   62: ireturn
/*    */     //   63: aload_3
/*    */     //   64: invokevirtual getNext : ()Lcom/vladsch/flexmark/parser/core/delimiter/Delimiter;
/*    */     //   67: goto -> 32
/*    */     //   70: iconst_0
/*    */     //   71: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #93	-> 0
/*    */     //   #94	-> 7
/*    */     //   #95	-> 14
/*    */     //   #96	-> 33
/*    */     //   #97	-> 37
/*    */     //   #98	-> 42
/*    */     //   #99	-> 48
/*    */     //   #101	-> 54
/*    */     //   #103	-> 63
/*    */     //   #104	-> 67
/*    */     //   #105	-> 70
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\core\delimiter\Bracket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */