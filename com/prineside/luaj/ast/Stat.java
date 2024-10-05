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
/*     */ public abstract class Stat
/*     */   extends SyntaxElement
/*     */ {
/*     */   public abstract void accept(Visitor paramVisitor);
/*     */   
/*     */   public static Stat block(Block paramBlock) {
/*  31 */     return paramBlock;
/*     */   }
/*     */   
/*     */   public static Stat whiledo(Exp paramExp, Block paramBlock) {
/*  35 */     return new WhileDo(paramExp, paramBlock);
/*     */   }
/*     */   
/*     */   public static Stat repeatuntil(Block paramBlock, Exp paramExp) {
/*  39 */     return new RepeatUntil(paramBlock, paramExp);
/*     */   }
/*     */   
/*     */   public static Stat breakstat() {
/*  43 */     return new Break();
/*     */   }
/*     */   
/*     */   public static Stat returnstat(List<Exp> paramList) {
/*  47 */     return new Return(paramList);
/*     */   }
/*     */   
/*     */   public static Stat assignment(List<Exp.VarExp> paramList, List<Exp> paramList1) {
/*  51 */     return new Assign(paramList, paramList1);
/*     */   }
/*     */   
/*     */   public static Stat functioncall(Exp.FuncCall paramFuncCall) {
/*  55 */     return new FuncCallStat(paramFuncCall);
/*     */   }
/*     */   
/*     */   public static Stat localfunctiondef(String paramString, FuncBody paramFuncBody) {
/*  59 */     return new LocalFuncDef(paramString, paramFuncBody);
/*     */   }
/*     */   
/*     */   public static Stat fornumeric(String paramString, Exp paramExp1, Exp paramExp2, Exp paramExp3, Block paramBlock) {
/*  63 */     return new NumericFor(paramString, paramExp1, paramExp2, paramExp3, paramBlock);
/*     */   }
/*     */   
/*     */   public static Stat functiondef(FuncName paramFuncName, FuncBody paramFuncBody) {
/*  67 */     return new FuncDef(paramFuncName, paramFuncBody);
/*     */   }
/*     */   
/*     */   public static Stat forgeneric(List<Name> paramList, List<Exp> paramList1, Block paramBlock) {
/*  71 */     return new GenericFor(paramList, paramList1, paramBlock);
/*     */   }
/*     */   
/*     */   public static Stat localassignment(List<Name> paramList, List<Exp> paramList1) {
/*  75 */     return new LocalAssign(paramList, paramList1);
/*     */   }
/*     */   
/*     */   public static Stat ifthenelse(Exp paramExp, Block paramBlock1, List<Exp> paramList, List<Block> paramList1, Block paramBlock2) {
/*  79 */     return new IfThenElse(paramExp, paramBlock1, paramList, paramList1, paramBlock2);
/*     */   }
/*     */   
/*     */   public static Stat gotostat(String paramString) {
/*  83 */     return new Goto(paramString);
/*     */   }
/*     */   
/*     */   public static Stat labelstat(String paramString) {
/*  87 */     return new Label(paramString);
/*     */   }
/*     */   
/*     */   public static class Goto extends Stat { public final String name;
/*     */     
/*     */     public Goto(String param1String) {
/*  93 */       this.name = param1String;
/*     */     }
/*     */     public void accept(Visitor param1Visitor) {
/*  96 */       param1Visitor.visit(this);
/*     */     } }
/*     */   
/*     */   public static class Label extends Stat {
/*     */     public final String name;
/*     */     
/*     */     public Label(String param1String) {
/* 103 */       this.name = param1String;
/*     */     }
/*     */     public void accept(Visitor param1Visitor) {
/* 106 */       param1Visitor.visit(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Assign extends Stat {
/*     */     public final List<Exp.VarExp> vars;
/*     */     public final List<Exp> exps;
/*     */     
/*     */     public Assign(List<Exp.VarExp> param1List, List<Exp> param1List1) {
/* 115 */       this.vars = param1List;
/* 116 */       this.exps = param1List1;
/*     */     }
/*     */     
/*     */     public void accept(Visitor param1Visitor) {
/* 120 */       param1Visitor.visit(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class WhileDo extends Stat {
/*     */     public final Exp exp;
/*     */     public final Block block;
/*     */     
/*     */     public WhileDo(Exp param1Exp, Block param1Block) {
/* 129 */       this.exp = param1Exp;
/* 130 */       this.block = param1Block;
/*     */     }
/*     */     public void accept(Visitor param1Visitor) {
/* 133 */       param1Visitor.visit(this);
/*     */     } }
/*     */   
/*     */   public static class RepeatUntil extends Stat {
/*     */     public final Block block;
/*     */     public final Exp exp;
/*     */     
/*     */     public RepeatUntil(Block param1Block, Exp param1Exp) {
/* 141 */       this.block = param1Block;
/* 142 */       this.exp = param1Exp;
/*     */     }
/*     */     public void accept(Visitor param1Visitor) {
/* 145 */       param1Visitor.visit(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Break extends Stat {
/*     */     public void accept(Visitor param1Visitor) {
/* 151 */       param1Visitor.visit(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Return extends Stat { public final List<Exp> values;
/*     */     
/*     */     public Return(List<Exp> param1List) {
/* 158 */       this.values = param1List;
/*     */     }
/*     */     
/*     */     public void accept(Visitor param1Visitor) {
/* 162 */       param1Visitor.visit(this);
/*     */     }
/*     */     
/*     */     public int nreturns() {
/*     */       byte b;
/* 167 */       if ((b = (this.values != null) ? this.values.size() : 0) && ((Exp)this.values.get(b - 1)).isvarargexp())
/* 168 */         b = -1; 
/* 169 */       return b;
/*     */     } }
/*     */   
/*     */   public static class FuncCallStat extends Stat {
/*     */     public final Exp.FuncCall funccall;
/*     */     
/*     */     public FuncCallStat(Exp.FuncCall param1FuncCall) {
/* 176 */       this.funccall = param1FuncCall;
/*     */     }
/*     */     
/*     */     public void accept(Visitor param1Visitor) {
/* 180 */       param1Visitor.visit(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class LocalFuncDef extends Stat { public final Name name;
/*     */     public final FuncBody body;
/*     */     
/*     */     public LocalFuncDef(String param1String, FuncBody param1FuncBody) {
/* 188 */       this.name = new Name(param1String);
/* 189 */       this.body = param1FuncBody;
/*     */     }
/*     */     
/*     */     public void accept(Visitor param1Visitor) {
/* 193 */       param1Visitor.visit(this);
/*     */     } }
/*     */   
/*     */   public static class FuncDef extends Stat {
/*     */     public final FuncName name;
/*     */     public final FuncBody body;
/*     */     
/*     */     public FuncDef(FuncName param1FuncName, FuncBody param1FuncBody) {
/* 201 */       this.name = param1FuncName;
/* 202 */       this.body = param1FuncBody;
/*     */     }
/*     */     
/*     */     public void accept(Visitor param1Visitor) {
/* 206 */       param1Visitor.visit(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class GenericFor extends Stat { public List<Name> names;
/*     */     public List<Exp> exps;
/*     */     public Block block;
/*     */     public NameScope scope;
/*     */     
/*     */     public GenericFor(List<Name> param1List, List<Exp> param1List1, Block param1Block) {
/* 216 */       this.names = param1List;
/* 217 */       this.exps = param1List1;
/* 218 */       this.block = param1Block;
/*     */     }
/*     */     
/*     */     public void accept(Visitor param1Visitor) {
/* 222 */       param1Visitor.visit(this);
/*     */     } }
/*     */ 
/*     */   
/*     */   public static class NumericFor extends Stat {
/*     */     public final Name name;
/*     */     public final Exp initial;
/*     */     public final Exp limit;
/*     */     
/*     */     public NumericFor(String param1String, Exp param1Exp1, Exp param1Exp2, Exp param1Exp3, Block param1Block) {
/* 232 */       this.name = new Name(param1String);
/* 233 */       this.initial = param1Exp1;
/* 234 */       this.limit = param1Exp2;
/* 235 */       this.step = param1Exp3;
/* 236 */       this.block = param1Block;
/*     */     }
/*     */     public final Exp step; public final Block block; public NameScope scope;
/*     */     public void accept(Visitor param1Visitor) {
/* 240 */       param1Visitor.visit(this);
/*     */     } }
/*     */   
/*     */   public static class LocalAssign extends Stat {
/*     */     public final List<Name> names;
/*     */     public final List<Exp> values;
/*     */     
/*     */     public LocalAssign(List<Name> param1List, List<Exp> param1List1) {
/* 248 */       this.names = param1List;
/* 249 */       this.values = param1List1;
/*     */     }
/*     */     
/*     */     public void accept(Visitor param1Visitor) {
/* 253 */       param1Visitor.visit(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class IfThenElse extends Stat {
/*     */     public final Exp ifexp;
/*     */     public final Block ifblock;
/*     */     public final List<Exp> elseifexps;
/*     */     public final List<Block> elseifblocks;
/*     */     public final Block elseblock;
/*     */     
/*     */     public IfThenElse(Exp param1Exp, Block param1Block1, List<Exp> param1List, List<Block> param1List1, Block param1Block2) {
/* 265 */       this.ifexp = param1Exp;
/* 266 */       this.ifblock = param1Block1;
/* 267 */       this.elseifexps = param1List;
/* 268 */       this.elseifblocks = param1List1;
/* 269 */       this.elseblock = param1Block2;
/*     */     }
/*     */     
/*     */     public void accept(Visitor param1Visitor) {
/* 273 */       param1Visitor.visit(this);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\ast\Stat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */