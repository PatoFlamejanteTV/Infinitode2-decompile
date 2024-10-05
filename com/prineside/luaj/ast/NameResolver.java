/*     */ package com.prineside.luaj.ast;
/*     */ 
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NameResolver
/*     */   extends Visitor
/*     */ {
/*  15 */   private NameScope a = null;
/*     */   
/*     */   private void a() {
/*  18 */     this.a = new NameScope(this.a);
/*     */   }
/*     */   private void b() {
/*  21 */     this.a = this.a.outerScope;
/*     */   }
/*     */ 
/*     */   
/*     */   public void visit(NameScope paramNameScope) {}
/*     */   
/*     */   public void visit(Block paramBlock) {
/*  28 */     a();
/*  29 */     paramBlock.scope = this.a;
/*  30 */     super.visit(paramBlock);
/*  31 */     b();
/*     */   }
/*     */   
/*     */   public void visit(FuncBody paramFuncBody) {
/*  35 */     a();
/*  36 */     this.a.functionNestingCount++;
/*  37 */     paramFuncBody.scope = this.a;
/*  38 */     super.visit(paramFuncBody);
/*  39 */     b();
/*     */   }
/*     */   
/*     */   public void visit(Stat.LocalFuncDef paramLocalFuncDef) {
/*  43 */     a(paramLocalFuncDef.name);
/*  44 */     super.visit(paramLocalFuncDef);
/*     */   }
/*     */   
/*     */   public void visit(Stat.NumericFor paramNumericFor) {
/*  48 */     a();
/*  49 */     paramNumericFor.scope = this.a;
/*  50 */     a(paramNumericFor.name);
/*  51 */     super.visit(paramNumericFor);
/*  52 */     b();
/*     */   }
/*     */   
/*     */   public void visit(Stat.GenericFor paramGenericFor) {
/*  56 */     a();
/*  57 */     paramGenericFor.scope = this.a;
/*  58 */     a(paramGenericFor.names);
/*  59 */     super.visit(paramGenericFor);
/*  60 */     b();
/*     */   }
/*     */   
/*     */   public void visit(Exp.NameExp paramNameExp) {
/*  64 */     paramNameExp.name.variable = b(paramNameExp.name);
/*  65 */     super.visit(paramNameExp);
/*     */   }
/*     */   
/*     */   public void visit(Stat.FuncDef paramFuncDef) {
/*  69 */     paramFuncDef.name.name.variable = b(paramFuncDef.name.name);
/*  70 */     paramFuncDef.name.name.variable.hasassignments = true;
/*  71 */     super.visit(paramFuncDef);
/*     */   }
/*     */   
/*     */   public void visit(Stat.Assign paramAssign) {
/*  75 */     super.visit(paramAssign); byte b; int i;
/*  76 */     for (b = 0, i = paramAssign.vars.size(); b < i; b++) {
/*     */       Exp.VarExp varExp;
/*  78 */       (varExp = paramAssign.vars.get(b)).markHasAssignment();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void visit(Stat.LocalAssign paramLocalAssign) {
/*  83 */     visitExps(paramLocalAssign.values);
/*  84 */     a(paramLocalAssign.names);
/*  85 */     int i = paramLocalAssign.names.size();
/*     */     byte b1;
/*  87 */     boolean bool = ((b1 = (paramLocalAssign.values != null) ? paramLocalAssign.values.size() : 0) && b1 < i && ((Exp)paramLocalAssign.values.get(b1 - 1)).isvarargexp()) ? true : false; byte b2;
/*  88 */     for (b2 = 0; b2 < i && b2 < (bool ? (b1 - 1) : b1); b2++) {
/*  89 */       if (paramLocalAssign.values.get(b2) instanceof Exp.Constant)
/*  90 */         ((Name)paramLocalAssign.names.get(b2)).variable.initialValue = ((Exp.Constant)paramLocalAssign.values.get(b2)).value; 
/*  91 */     }  if (!bool)
/*  92 */       for (b2 = b1; b2 < i; b2++)
/*  93 */         ((Name)paramLocalAssign.names.get(b2)).variable.initialValue = LuaValue.NIL;  
/*     */   }
/*     */   
/*     */   public void visit(ParList paramParList) {
/*  97 */     if (paramParList.names != null)
/*  98 */       a(paramParList.names); 
/*  99 */     if (paramParList.isvararg)
/* 100 */       this.a.define("arg"); 
/* 101 */     super.visit(paramParList);
/*     */   } private void a(List<Name> paramList) {
/*     */     byte b;
/*     */     int i;
/* 105 */     for (b = 0, i = paramList.size(); b < i; b++)
/* 106 */       a(paramList.get(b)); 
/*     */   }
/*     */   
/*     */   private void a(Name paramName) {
/* 110 */     paramName.variable = this.a.define(paramName.name);
/*     */   }
/*     */   
/*     */   private Variable b(Name paramName) {
/*     */     Variable variable;
/* 115 */     if ((variable = this.a.find(paramName.name)).isLocal() && this.a.functionNestingCount != variable.definingScope.functionNestingCount)
/* 116 */       variable.isupvalue = true; 
/* 117 */     return variable;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\ast\NameResolver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */