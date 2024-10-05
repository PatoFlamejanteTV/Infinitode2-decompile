/*    */ package com.vladsch.flexmark.ext.attributes.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.util.Parsing;
/*    */ import com.vladsch.flexmark.ext.attributes.AttributesExtension;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ 
/*    */ class AttributeParsing
/*    */ {
/*    */   final Parsing myParsing;
/*    */   final Pattern ATTRIBUTES_TAG;
/*    */   final Pattern ATTRIBUTE;
/*    */   
/*    */   public AttributeParsing(Parsing paramParsing) {
/* 15 */     this.myParsing = paramParsing;
/* 16 */     String str = this.myParsing.UNQUOTEDVALUE;
/* 17 */     this.ATTRIBUTE = Pattern.compile("\\s*([#.]" + str + "|" + this.myParsing.ATTRIBUTENAME + ")\\s*(?:=\\s*(" + this.myParsing.ATTRIBUTEVALUE + ")?)?");
/*    */     
/* 19 */     if (((Boolean)AttributesExtension.USE_EMPTY_IMPLICIT_AS_SPAN_DELIMITER.get(paramParsing.options)).booleanValue()) {
/* 20 */       this.ATTRIBUTES_TAG = Pattern.compile("^\\{((?:[#.])|(?:\\s*([#.]" + str + "|" + this.myParsing.ATTRIBUTENAME + ")\\s*(?:=\\s*(" + this.myParsing.ATTRIBUTEVALUE + ")?)?)(?:\\s+([#.]" + str + "|" + this.myParsing.ATTRIBUTENAME + ")\\s*(?:=\\s*(" + this.myParsing.ATTRIBUTEVALUE + ")?)?)*\\s*)\\}");
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 25 */     this.ATTRIBUTES_TAG = Pattern.compile("^\\{((?:\\s*([#.]" + str + "|" + this.myParsing.ATTRIBUTENAME + ")\\s*(?:=\\s*(" + this.myParsing.ATTRIBUTEVALUE + ")?)?)(?:\\s+([#.]" + str + "|" + this.myParsing.ATTRIBUTENAME + ")\\s*(?:=\\s*(" + this.myParsing.ATTRIBUTEVALUE + ")?)?)*\\s*)\\}");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\attributes\internal\AttributeParsing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */