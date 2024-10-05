/*    */ package org.jsoup.parser;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ParseError
/*    */ {
/*    */   private final int pos;
/*    */   private final String cursorPos;
/*    */   private final String errorMsg;
/*    */   
/*    */   ParseError(CharacterReader paramCharacterReader, String paramString) {
/* 12 */     this.pos = paramCharacterReader.pos();
/* 13 */     this.cursorPos = paramCharacterReader.posLineCol();
/* 14 */     this.errorMsg = paramString;
/*    */   }
/*    */   
/*    */   ParseError(CharacterReader paramCharacterReader, String paramString, Object... paramVarArgs) {
/* 18 */     this.pos = paramCharacterReader.pos();
/* 19 */     this.cursorPos = paramCharacterReader.posLineCol();
/* 20 */     this.errorMsg = String.format(paramString, paramVarArgs);
/*    */   }
/*    */   
/*    */   ParseError(int paramInt, String paramString) {
/* 24 */     this.pos = paramInt;
/* 25 */     this.cursorPos = String.valueOf(paramInt);
/* 26 */     this.errorMsg = paramString;
/*    */   }
/*    */   
/*    */   ParseError(int paramInt, String paramString, Object... paramVarArgs) {
/* 30 */     this.pos = paramInt;
/* 31 */     this.cursorPos = String.valueOf(paramInt);
/* 32 */     this.errorMsg = String.format(paramString, paramVarArgs);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getErrorMessage() {
/* 40 */     return this.errorMsg;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getPosition() {
/* 48 */     return this.pos;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getCursorPos() {
/* 56 */     return this.cursorPos;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 61 */     return "<" + this.cursorPos + ">: " + this.errorMsg;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\parser\ParseError.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */