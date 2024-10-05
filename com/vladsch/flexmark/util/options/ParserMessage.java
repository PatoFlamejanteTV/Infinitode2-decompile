/*    */ package com.vladsch.flexmark.util.options;
/*    */ 
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ public class ParserMessage {
/*    */   protected final BasedSequence source;
/*    */   protected final ParsedOptionStatus status;
/*    */   protected final String message;
/*    */   
/*    */   public ParserMessage(BasedSequence paramBasedSequence, ParsedOptionStatus paramParsedOptionStatus, String paramString) {
/* 11 */     this.source = paramBasedSequence;
/* 12 */     this.status = paramParsedOptionStatus;
/* 13 */     this.message = paramString;
/*    */   }
/*    */   
/*    */   public BasedSequence getSource() {
/* 17 */     return this.source;
/*    */   }
/*    */   
/*    */   public ParsedOptionStatus getStatus() {
/* 21 */     return this.status;
/*    */   }
/*    */   
/*    */   public String getMessage() {
/* 25 */     return this.message;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\options\ParserMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */