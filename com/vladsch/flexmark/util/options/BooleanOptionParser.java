/*    */ package com.vladsch.flexmark.util.options;
/*    */ 
/*    */ import com.vladsch.flexmark.util.misc.Pair;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ 
/*    */ public abstract class BooleanOptionParser<T>
/*    */   implements OptionParser<T> {
/*    */   public static final String OPTION_0_PARAMETERS_1_IGNORED = "Option {0} does not have any parameters. {1} was ignored";
/*    */   public static final String KEY_OPTION_0_PARAMETERS_1_IGNORED = "options.parser.boolean-option.ignored";
/*    */   private final String optionName;
/*    */   
/*    */   public BooleanOptionParser(String paramString) {
/* 15 */     this.optionName = paramString;
/*    */   }
/*    */   
/*    */   protected abstract T setOptions(T paramT);
/*    */   
/*    */   protected abstract boolean isOptionSet(T paramT);
/*    */   
/*    */   public String getOptionName() {
/* 23 */     return this.optionName;
/*    */   }
/*    */ 
/*    */   
/*    */   public Pair<T, List<ParsedOption<T>>> parseOption(BasedSequence paramBasedSequence, T paramT, MessageProvider paramMessageProvider) {
/* 28 */     if (paramBasedSequence.isEmpty()) {
/* 29 */       return new Pair(setOptions(paramT), Collections.singletonList(new ParsedOption(paramBasedSequence, this, ParsedOptionStatus.VALID)));
/*    */     }
/* 31 */     if (paramMessageProvider == null) paramMessageProvider = MessageProvider.DEFAULT; 
/* 32 */     String str = paramMessageProvider.message("options.parser.boolean-option.ignored", "Option {0} does not have any parameters. {1} was ignored", new Object[] { this.optionName, paramBasedSequence });
/* 33 */     return new Pair(setOptions(paramT), Collections.singletonList(new ParsedOption(paramBasedSequence, this, ParsedOptionStatus.IGNORED, Collections.singletonList(new ParserMessage(paramBasedSequence, ParsedOptionStatus.IGNORED, str)))));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getOptionText(T paramT1, T paramT2) {
/* 39 */     return (isOptionSet(paramT1) && (paramT2 == null || !isOptionSet(paramT2))) ? this.optionName : "";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\options\BooleanOptionParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */