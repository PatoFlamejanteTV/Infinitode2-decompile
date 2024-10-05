/*   */ package com.vladsch.flexmark.ext.toc.internal;
/*   */ import com.vladsch.flexmark.util.options.OptionParser;
/*   */ import com.vladsch.flexmark.util.options.OptionsParser;
/*   */ 
/*   */ public class TocOptionsParser extends OptionsParser<TocOptions> {
/*   */   public TocOptionsParser() {
/* 7 */     super("TocOptions", (OptionParser[])TocOptionTypes.OPTIONS, ' ', '=');
/*   */   }
/*   */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\toc\internal\TocOptionsParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */