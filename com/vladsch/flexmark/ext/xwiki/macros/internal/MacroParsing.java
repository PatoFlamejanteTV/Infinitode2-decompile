/*    */ package com.vladsch.flexmark.ext.xwiki.macros.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.util.Parsing;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ class MacroParsing
/*    */ {
/*    */   final Parsing myParsing;
/*    */   final String OPEN_MACROTAG;
/*    */   final String CLOSE_MACROTAG;
/*    */   final String MACROTAG;
/*    */   final Pattern MACRO_OPEN;
/*    */   final Pattern MACRO_CLOSE;
/*    */   final Pattern MACRO_CLOSE_END;
/*    */   final Pattern MACRO_ATTRIBUTE;
/*    */   final Pattern MACRO_TAG;
/*    */   
/*    */   public MacroParsing(Parsing paramParsing) {
/* 19 */     this.myParsing = paramParsing;
/* 20 */     this.OPEN_MACROTAG = "\\{\\{(" + this.myParsing.TAGNAME + ")" + this.myParsing.ATTRIBUTE + "*\\s*/?\\}\\}";
/* 21 */     this.CLOSE_MACROTAG = "\\{\\{/(" + this.myParsing.TAGNAME + ")\\s*\\}\\}";
/* 22 */     this.MACRO_OPEN = Pattern.compile("^" + this.OPEN_MACROTAG, 2);
/* 23 */     this.MACRO_CLOSE = Pattern.compile("^" + this.CLOSE_MACROTAG + "\\s*$", 2);
/* 24 */     this.MACRO_CLOSE_END = Pattern.compile(this.CLOSE_MACROTAG + "\\s*$", 2);
/* 25 */     this.MACRO_ATTRIBUTE = Pattern.compile("\\s*(" + this.myParsing.ATTRIBUTENAME + ")\\s*(?:=\\s*(" + this.myParsing.ATTRIBUTEVALUE + ")?)?");
/*    */     
/* 27 */     this.MACROTAG = "(?:" + this.OPEN_MACROTAG + ")|(?:" + this.CLOSE_MACROTAG + ")";
/* 28 */     this.MACRO_TAG = Pattern.compile(this.MACROTAG);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\xwiki\macros\internal\MacroParsing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */