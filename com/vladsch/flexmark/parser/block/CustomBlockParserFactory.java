/*    */ package com.vladsch.flexmark.parser.block;
/*    */ 
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.dependency.Dependent;
/*    */ import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInHandler;
/*    */ import java.util.function.Function;
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
/*    */ public interface CustomBlockParserFactory
/*    */   extends Dependent, Function<DataHolder, BlockParserFactory>
/*    */ {
/*    */   default SpecialLeadInHandler getLeadInHandler(DataHolder paramDataHolder) {
/* 23 */     return null;
/*    */   }
/*    */   
/*    */   BlockParserFactory apply(DataHolder paramDataHolder);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\block\CustomBlockParserFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */