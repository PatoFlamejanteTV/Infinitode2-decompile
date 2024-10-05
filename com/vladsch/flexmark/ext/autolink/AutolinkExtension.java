/*    */ package com.vladsch.flexmark.ext.autolink;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.autolink.internal.AutolinkNodePostProcessor;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.PostProcessorFactory;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AutolinkExtension
/*    */   implements Parser.ParserExtension
/*    */ {
/* 18 */   public static final DataKey<String> IGNORE_LINKS = new DataKey("IGNORE_LINKS", "");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static AutolinkExtension create() {
/* 24 */     return new AutolinkExtension();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void parserOptions(MutableDataHolder paramMutableDataHolder) {}
/*    */ 
/*    */   
/*    */   public void extend(Parser.Builder paramBuilder) {
/* 33 */     paramBuilder.postProcessorFactory((PostProcessorFactory)new AutolinkNodePostProcessor.Factory());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\autolink\AutolinkExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */