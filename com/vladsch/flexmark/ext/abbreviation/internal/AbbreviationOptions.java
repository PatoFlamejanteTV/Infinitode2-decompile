/*    */ package com.vladsch.flexmark.ext.abbreviation.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.abbreviation.AbbreviationExtension;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ 
/*    */ public class AbbreviationOptions {
/*    */   protected final boolean useLinks;
/*    */   
/*    */   public AbbreviationOptions(DataHolder paramDataHolder) {
/* 10 */     this.useLinks = ((Boolean)AbbreviationExtension.USE_LINKS.get(paramDataHolder)).booleanValue();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\abbreviation\internal\AbbreviationOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */