/*    */ package com.vladsch.flexmark.util.options;
/*    */ 
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ParsedOption<T>
/*    */ {
/*    */   protected final BasedSequence source;
/*    */   protected final OptionParser<T> optionParser;
/*    */   protected final ParsedOptionStatus optionResult;
/*    */   protected final List<ParserMessage> messages;
/*    */   
/*    */   public ParsedOption(BasedSequence paramBasedSequence, OptionParser<T> paramOptionParser, ParsedOptionStatus paramParsedOptionStatus) {
/* 16 */     this(paramBasedSequence, paramOptionParser, paramParsedOptionStatus, (List<ParserMessage>)null);
/*    */   }
/*    */   
/*    */   public ParsedOption(BasedSequence paramBasedSequence, OptionParser<T> paramOptionParser, ParsedOptionStatus paramParsedOptionStatus, ParserMessage paramParserMessage) {
/* 20 */     this(paramBasedSequence, paramOptionParser, paramParsedOptionStatus, Collections.singletonList(paramParserMessage));
/*    */   }
/*    */   
/*    */   public ParsedOption(BasedSequence paramBasedSequence, OptionParser<T> paramOptionParser, ParsedOptionStatus paramParsedOptionStatus, List<ParserMessage> paramList) {
/* 24 */     this(paramBasedSequence, paramOptionParser, paramParsedOptionStatus, paramList, null);
/*    */   }
/*    */   
/*    */   public ParsedOption(BasedSequence paramBasedSequence, OptionParser<T> paramOptionParser, ParsedOptionStatus paramParsedOptionStatus, List<ParserMessage> paramList, List<ParsedOption<T>> paramList1) {
/* 28 */     this.source = paramBasedSequence;
/*    */     
/* 30 */     if (paramList1 != null) {
/* 31 */       ArrayList<ParserMessage> arrayList = (paramList != null) ? new ArrayList<>(paramList) : null;
/*    */       
/* 33 */       for (ParsedOption<T> parsedOption : paramList1) {
/* 34 */         paramParsedOptionStatus = paramParsedOptionStatus.escalate(parsedOption.getOptionResult());
/* 35 */         if (parsedOption.getMessages() != null) {
/* 36 */           if (arrayList == null) arrayList = new ArrayList(); 
/* 37 */           arrayList.addAll(parsedOption.getMessages());
/*    */         } 
/*    */       } 
/* 40 */       paramList = arrayList;
/*    */     } 
/*    */     
/* 43 */     this.optionParser = paramOptionParser;
/* 44 */     this.optionResult = paramParsedOptionStatus;
/* 45 */     this.messages = paramList;
/*    */   }
/*    */   
/*    */   public BasedSequence getSource() {
/* 49 */     return this.source;
/*    */   }
/*    */   
/*    */   public OptionParser<T> getOptionParser() {
/* 53 */     return this.optionParser;
/*    */   }
/*    */   
/*    */   public ParsedOptionStatus getOptionResult() {
/* 57 */     return this.optionResult;
/*    */   }
/*    */   
/*    */   public List<ParserMessage> getMessages() {
/* 61 */     return this.messages;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\options\ParsedOption.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */