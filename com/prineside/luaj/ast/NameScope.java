/*    */ package com.prineside.luaj.ast;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NameScope
/*    */ {
/* 32 */   private static final Set<String> a = new HashSet<>();
/*    */   
/*    */   static {
/* 35 */     String[] arrayOfString = { "and", "break", "do", "else", "elseif", "end", "false", "for", "function", "if", "in", "local", "nil", "not", "or", "repeat", "return", "then", "true", "until", "while" };
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 40 */     for (byte b = 0; b < 21; b++)
/* 41 */       a.add(arrayOfString[b]); 
/*    */   }
/*    */   
/* 44 */   public final Map<String, Variable> namedVariables = new HashMap<>();
/*    */   
/*    */   public final NameScope outerScope;
/*    */   
/*    */   public int functionNestingCount;
/*    */ 
/*    */   
/*    */   public NameScope() {
/* 52 */     this.outerScope = null;
/* 53 */     this.functionNestingCount = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public NameScope(NameScope paramNameScope) {
/* 58 */     this.outerScope = paramNameScope;
/* 59 */     this.functionNestingCount = (paramNameScope != null) ? paramNameScope.functionNestingCount : 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public Variable find(String paramString) {
/* 64 */     a(paramString);
/* 65 */     for (NameScope nameScope = this; nameScope != null; nameScope = nameScope.outerScope) {
/* 66 */       if (nameScope.namedVariables.containsKey(paramString))
/* 67 */         return nameScope.namedVariables.get(paramString); 
/* 68 */     }  Variable variable = new Variable(paramString);
/* 69 */     this.namedVariables.put(paramString, variable);
/* 70 */     return variable;
/*    */   }
/*    */ 
/*    */   
/*    */   public Variable define(String paramString) {
/* 75 */     a(paramString);
/* 76 */     Variable variable = new Variable(paramString, this);
/* 77 */     this.namedVariables.put(paramString, variable);
/* 78 */     return variable;
/*    */   }
/*    */   
/*    */   private static void a(String paramString) {
/* 82 */     if (a.contains(paramString))
/* 83 */       throw new IllegalArgumentException("name is a keyword: '" + paramString + "'"); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\ast\NameScope.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */