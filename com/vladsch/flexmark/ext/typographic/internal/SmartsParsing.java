/*    */ package com.vladsch.flexmark.ext.typographic.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.util.Parsing;
/*    */ 
/*    */ class SmartsParsing {
/*    */   final Parsing myParsing;
/*    */   final String ELIPSIS;
/*    */   final String ELIPSIS_SPACED;
/*    */   final String EN_DASH;
/*    */   final String EM_DASH;
/*    */   
/*    */   public SmartsParsing(Parsing paramParsing) {
/* 13 */     this.myParsing = paramParsing;
/* 14 */     this.ELIPSIS = "...";
/* 15 */     this.ELIPSIS_SPACED = ". . .";
/* 16 */     this.EN_DASH = "--";
/* 17 */     this.EM_DASH = "---";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\typographic\internal\SmartsParsing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */