/*    */ package com.vladsch.flexmark.util.options;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ParserParams {
/*  7 */   public List<ParserMessage> messages = null;
/*    */   public boolean skip = false;
/*  9 */   public ParsedOptionStatus status = ParsedOptionStatus.VALID;
/*    */   
/*    */   public ParserParams add(ParserMessage paramParserMessage) {
/* 12 */     if (this.messages == null) this.messages = new ArrayList<>(); 
/* 13 */     this.messages.add(paramParserMessage);
/* 14 */     escalate(paramParserMessage.getStatus());
/* 15 */     return this;
/*    */   }
/*    */   
/*    */   public ParserParams escalate(ParsedOptionStatus paramParsedOptionStatus) {
/* 19 */     this.status = this.status.escalate(paramParsedOptionStatus);
/* 20 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\options\ParserParams.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */