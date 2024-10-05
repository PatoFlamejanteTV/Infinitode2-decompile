/*   */ package com.vladsch.flexmark.html2md.converter;
/*   */ 
/*   */ import com.vladsch.flexmark.html2md.converter.internal.HtmlConverterCoreNodeRenderer;
/*   */ import com.vladsch.flexmark.util.data.DataHolder;
/*   */ 
/*   */ public class HtmlConverterCoreNodeRendererFactory
/*   */   implements HtmlNodeRendererFactory {
/*   */   public HtmlNodeRenderer apply(DataHolder paramDataHolder) {
/* 9 */     return (HtmlNodeRenderer)new HtmlConverterCoreNodeRenderer(paramDataHolder);
/*   */   }
/*   */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html2md\converter\HtmlConverterCoreNodeRendererFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */