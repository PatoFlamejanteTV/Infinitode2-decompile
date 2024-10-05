/*    */ package com.vladsch.flexmark.ext.enumerated.reference.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ 
/*    */ public class EnumeratedReferenceOptions {
/*    */   final int contentIndent;
/*    */   
/*    */   public EnumeratedReferenceOptions(DataHolder paramDataHolder) {
/* 10 */     this.contentIndent = ((Integer)Parser.LISTS_ITEM_INDENT.get(paramDataHolder)).intValue();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\enumerated\reference\internal\EnumeratedReferenceOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */