/*    */ package com.vladsch.flexmark.util.options;
/*    */ 
/*    */ public enum ParsedOptionStatus {
/*  4 */   VALID(0),
/*  5 */   IGNORED(1),
/*  6 */   WEAK_WARNING(2),
/*  7 */   WARNING(3),
/*  8 */   ERROR(4);
/*    */   
/*    */   private final int level;
/*    */   
/*    */   ParsedOptionStatus(int paramInt1) {
/* 13 */     this.level = paramInt1;
/*    */   }
/*    */   
/*    */   final ParsedOptionStatus escalate(ParsedOptionStatus paramParsedOptionStatus) {
/* 17 */     return (this.level < paramParsedOptionStatus.level) ? paramParsedOptionStatus : this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\options\ParsedOptionStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */