/*    */ package org.jsoup.parser;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ParseErrorList
/*    */   extends ArrayList<ParseError>
/*    */ {
/*    */   private static final int INITIAL_CAPACITY = 16;
/*    */   private final int initialCapacity;
/*    */   private final int maxSize;
/*    */   
/*    */   ParseErrorList(int paramInt1, int paramInt2) {
/* 16 */     super(paramInt1);
/* 17 */     this.initialCapacity = paramInt1;
/* 18 */     this.maxSize = paramInt2;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   ParseErrorList(ParseErrorList paramParseErrorList) {
/* 26 */     this(paramParseErrorList.initialCapacity, paramParseErrorList.maxSize);
/*    */   }
/*    */   
/*    */   boolean canAddError() {
/* 30 */     return (size() < this.maxSize);
/*    */   }
/*    */   
/*    */   int getMaxSize() {
/* 34 */     return this.maxSize;
/*    */   }
/*    */   
/*    */   public static ParseErrorList noTracking() {
/* 38 */     return new ParseErrorList(0, 0);
/*    */   }
/*    */   
/*    */   public static ParseErrorList tracking(int paramInt) {
/* 42 */     return new ParseErrorList(16, paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Object clone() {
/* 48 */     return super.clone();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\parser\ParseErrorList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */