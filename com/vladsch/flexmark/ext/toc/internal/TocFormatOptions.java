/*    */ package com.vladsch.flexmark.ext.toc.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.toc.SimTocGenerateOnFormat;
/*    */ import com.vladsch.flexmark.ext.toc.TocExtension;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import com.vladsch.flexmark.util.data.MutableDataSetter;
/*    */ 
/*    */ public class TocFormatOptions
/*    */   implements MutableDataSetter {
/*    */   public final SimTocGenerateOnFormat updateOnFormat;
/*    */   public final TocOptions options;
/*    */   
/*    */   public TocFormatOptions() {
/* 15 */     this(null);
/*    */   }
/*    */   
/*    */   public TocFormatOptions(DataHolder paramDataHolder) {
/* 19 */     this.updateOnFormat = (SimTocGenerateOnFormat)TocExtension.FORMAT_UPDATE_ON_FORMAT.get(paramDataHolder);
/* 20 */     this.options = (TocOptions)TocExtension.FORMAT_OPTIONS.get(paramDataHolder);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MutableDataHolder setIn(MutableDataHolder paramMutableDataHolder) {
/* 26 */     paramMutableDataHolder.set(TocExtension.FORMAT_UPDATE_ON_FORMAT, this.updateOnFormat);
/* 27 */     paramMutableDataHolder.set(TocExtension.FORMAT_OPTIONS, this.options);
/* 28 */     return paramMutableDataHolder;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\toc\internal\TocFormatOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */