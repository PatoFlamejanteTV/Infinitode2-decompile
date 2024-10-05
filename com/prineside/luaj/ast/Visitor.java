/*     */ package com.prineside.luaj.ast;
/*     */ 
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Visitor
/*     */ {
/*     */   public void visit(Chunk paramChunk) {
/*  28 */     paramChunk.block.accept(this);
/*     */   }
/*     */   public void visit(Block paramBlock) {
/*  31 */     visit(paramBlock.scope);
/*  32 */     if (paramBlock.stats != null) {
/*  33 */       byte b; int i; for (b = 0, i = paramBlock.stats.size(); b < i; b++)
/*  34 */         ((Stat)paramBlock.stats.get(b)).accept(this); 
/*     */     } 
/*     */   } public void visit(Stat.Assign paramAssign) {
/*  37 */     visitVars(paramAssign.vars);
/*  38 */     visitExps(paramAssign.exps);
/*     */   }
/*     */   public void visit(Stat.Break paramBreak) {}
/*     */   
/*     */   public void visit(Stat.FuncCallStat paramFuncCallStat) {
/*  43 */     paramFuncCallStat.funccall.accept(this);
/*     */   }
/*     */   public void visit(Stat.FuncDef paramFuncDef) {
/*  46 */     paramFuncDef.body.accept(this);
/*     */   }
/*     */   public void visit(Stat.GenericFor paramGenericFor) {
/*  49 */     visit(paramGenericFor.scope);
/*  50 */     visitNames(paramGenericFor.names);
/*  51 */     visitExps(paramGenericFor.exps);
/*  52 */     paramGenericFor.block.accept(this);
/*     */   }
/*     */   public void visit(Stat.IfThenElse paramIfThenElse) {
/*  55 */     paramIfThenElse.ifexp.accept(this);
/*  56 */     paramIfThenElse.ifblock.accept(this);
/*  57 */     if (paramIfThenElse.elseifblocks != null) {
/*  58 */       byte b; int i; for (b = 0, i = paramIfThenElse.elseifblocks.size(); b < i; b++) {
/*  59 */         ((Exp)paramIfThenElse.elseifexps.get(b)).accept(this);
/*  60 */         ((Block)paramIfThenElse.elseifblocks.get(b)).accept(this);
/*     */       } 
/*  62 */     }  if (paramIfThenElse.elseblock != null)
/*  63 */       visit(paramIfThenElse.elseblock); 
/*     */   }
/*     */   public void visit(Stat.LocalAssign paramLocalAssign) {
/*  66 */     visitNames(paramLocalAssign.names);
/*  67 */     visitExps(paramLocalAssign.values);
/*     */   }
/*     */   public void visit(Stat.LocalFuncDef paramLocalFuncDef) {
/*  70 */     visit(paramLocalFuncDef.name);
/*  71 */     paramLocalFuncDef.body.accept(this);
/*     */   }
/*     */   public void visit(Stat.NumericFor paramNumericFor) {
/*  74 */     visit(paramNumericFor.scope);
/*  75 */     visit(paramNumericFor.name);
/*  76 */     paramNumericFor.initial.accept(this);
/*  77 */     paramNumericFor.limit.accept(this);
/*  78 */     if (paramNumericFor.step != null)
/*  79 */       paramNumericFor.step.accept(this); 
/*  80 */     paramNumericFor.block.accept(this);
/*     */   }
/*     */   public void visit(Stat.RepeatUntil paramRepeatUntil) {
/*  83 */     paramRepeatUntil.block.accept(this);
/*  84 */     paramRepeatUntil.exp.accept(this);
/*     */   }
/*     */   public void visit(Stat.Return paramReturn) {
/*  87 */     visitExps(paramReturn.values);
/*     */   }
/*     */   public void visit(Stat.WhileDo paramWhileDo) {
/*  90 */     paramWhileDo.exp.accept(this);
/*  91 */     paramWhileDo.block.accept(this);
/*     */   }
/*     */   public void visit(FuncBody paramFuncBody) {
/*  94 */     visit(paramFuncBody.scope);
/*  95 */     paramFuncBody.parlist.accept(this);
/*  96 */     paramFuncBody.block.accept(this);
/*     */   }
/*     */   public void visit(FuncArgs paramFuncArgs) {
/*  99 */     visitExps(paramFuncArgs.exps);
/*     */   }
/*     */   public void visit(TableField paramTableField) {
/* 102 */     if (paramTableField.name != null)
/* 103 */       visit(paramTableField.name); 
/* 104 */     if (paramTableField.index != null)
/* 105 */       paramTableField.index.accept(this); 
/* 106 */     paramTableField.rhs.accept(this);
/*     */   }
/*     */   public void visit(Exp.AnonFuncDef paramAnonFuncDef) {
/* 109 */     paramAnonFuncDef.body.accept(this);
/*     */   }
/*     */   public void visit(Exp.BinopExp paramBinopExp) {
/* 112 */     paramBinopExp.lhs.accept(this);
/* 113 */     paramBinopExp.rhs.accept(this);
/*     */   }
/*     */   public void visit(Exp.Constant paramConstant) {}
/*     */   
/*     */   public void visit(Exp.FieldExp paramFieldExp) {
/* 118 */     paramFieldExp.lhs.accept(this);
/* 119 */     visit(paramFieldExp.name);
/*     */   }
/*     */   public void visit(Exp.FuncCall paramFuncCall) {
/* 122 */     paramFuncCall.lhs.accept(this);
/* 123 */     paramFuncCall.args.accept(this);
/*     */   }
/*     */   public void visit(Exp.IndexExp paramIndexExp) {
/* 126 */     paramIndexExp.lhs.accept(this);
/* 127 */     paramIndexExp.exp.accept(this);
/*     */   }
/*     */   public void visit(Exp.MethodCall paramMethodCall) {
/* 130 */     paramMethodCall.lhs.accept(this);
/* 131 */     visit(paramMethodCall.name);
/* 132 */     paramMethodCall.args.accept(this);
/*     */   }
/*     */   public void visit(Exp.NameExp paramNameExp) {
/* 135 */     visit(paramNameExp.name);
/*     */   }
/*     */   public void visit(Exp.ParensExp paramParensExp) {
/* 138 */     paramParensExp.exp.accept(this);
/*     */   }
/*     */   public void visit(Exp.UnopExp paramUnopExp) {
/* 141 */     paramUnopExp.rhs.accept(this);
/*     */   }
/*     */   public void visit(Exp.VarargsExp paramVarargsExp) {}
/*     */   
/*     */   public void visit(ParList paramParList) {
/* 146 */     visitNames(paramParList.names);
/*     */   }
/*     */   public void visit(TableConstructor paramTableConstructor) {
/* 149 */     if (paramTableConstructor.fields != null) {
/* 150 */       byte b; int i; for (b = 0, i = paramTableConstructor.fields.size(); b < i; b++)
/* 151 */         ((TableField)paramTableConstructor.fields.get(b)).accept(this); 
/*     */     } 
/*     */   } public void visitVars(List<Exp.VarExp> paramList) {
/* 154 */     if (paramList != null) {
/* 155 */       byte b; int i; for (b = 0, i = paramList.size(); b < i; b++)
/* 156 */         ((Exp.VarExp)paramList.get(b)).accept(this); 
/*     */     } 
/*     */   } public void visitExps(List<Exp> paramList) {
/* 159 */     if (paramList != null) {
/* 160 */       byte b; int i; for (b = 0, i = paramList.size(); b < i; b++)
/* 161 */         ((Exp)paramList.get(b)).accept(this); 
/*     */     } 
/*     */   } public void visitNames(List<Name> paramList) {
/* 164 */     if (paramList != null) {
/* 165 */       byte b; int i; for (b = 0, i = paramList.size(); b < i; b++)
/* 166 */         visit(paramList.get(b)); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void visit(Name paramName) {}
/*     */   
/*     */   public void visit(String paramString) {}
/*     */   
/*     */   public void visit(NameScope paramNameScope) {}
/*     */   
/*     */   public void visit(Stat.Goto paramGoto) {}
/*     */   
/*     */   public void visit(Stat.Label paramLabel) {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\ast\Visitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */