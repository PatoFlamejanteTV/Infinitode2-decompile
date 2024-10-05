/*    */ package com.vladsch.flexmark.ext.jekyll.tag.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.util.Parsing;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ class JekyllTagParsing
/*    */ {
/*    */   final Parsing myParsing;
/*    */   final String OPEN_MACROTAG;
/*    */   final Pattern MACRO_OPEN;
/*    */   final Pattern MACRO_TAG;
/*    */   
/*    */   public JekyllTagParsing(Parsing paramParsing) {
/* 14 */     this.myParsing = paramParsing;
/* 15 */     this.OPEN_MACROTAG = "\\{%\\s+(" + this.myParsing.TAGNAME + ")(?:\\s+.+)?\\s+%\\}";
/* 16 */     this.MACRO_OPEN = Pattern.compile("^" + this.OPEN_MACROTAG + "\\s*$", 2);
/* 17 */     this.MACRO_TAG = Pattern.compile(this.OPEN_MACROTAG);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\jekyll\tag\internal\JekyllTagParsing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */