/*     */ package com.prineside.luaj.ast;
/*     */ 
/*     */ import com.prineside.luaj.LuaValue;
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
/*     */ 
/*     */ public abstract class Exp
/*     */   extends SyntaxElement
/*     */ {
/*     */   public abstract void accept(Visitor paramVisitor);
/*     */   
/*     */   public static Exp constant(LuaValue paramLuaValue) {
/*  32 */     return new Constant(paramLuaValue);
/*     */   }
/*     */   
/*     */   public static Exp numberconstant(String paramString) {
/*  36 */     return new Constant(LuaValue.valueOf(paramString).tonumber());
/*     */   }
/*     */   
/*     */   public static Exp varargs() {
/*  40 */     return new VarargsExp();
/*     */   }
/*     */   
/*     */   public static Exp tableconstructor(TableConstructor paramTableConstructor) {
/*  44 */     return paramTableConstructor;
/*     */   }
/*     */   
/*     */   public static Exp unaryexp(int paramInt, Exp paramExp) {
/*  48 */     if (paramExp instanceof BinopExp) {
/*  49 */       BinopExp binopExp = (BinopExp)paramExp;
/*  50 */       if (b(paramInt) > b(binopExp.op))
/*  51 */         return binaryexp(unaryexp(paramInt, binopExp.lhs), binopExp.op, binopExp.rhs); 
/*     */     } 
/*  53 */     return new UnopExp(paramInt, paramExp);
/*     */   }
/*     */   
/*     */   public static Exp binaryexp(Exp paramExp1, int paramInt, Exp paramExp2) {
/*  57 */     if (paramExp1 instanceof UnopExp) {
/*  58 */       UnopExp unopExp = (UnopExp)paramExp1;
/*  59 */       if (b(paramInt) > b(unopExp.op)) {
/*  60 */         return unaryexp(unopExp.op, binaryexp(unopExp.rhs, paramInt, paramExp2));
/*     */       }
/*     */     } 
/*     */     
/*  64 */     if (paramExp1 instanceof BinopExp) {
/*  65 */       BinopExp binopExp = (BinopExp)paramExp1;
/*  66 */       if (b(paramInt) > b(binopExp.op) || (
/*  67 */         b(paramInt) == b(binopExp.op) && a(paramInt)))
/*  68 */         return binaryexp(binopExp.lhs, binopExp.op, binaryexp(binopExp.rhs, paramInt, paramExp2)); 
/*     */     } 
/*  70 */     if (paramExp2 instanceof BinopExp) {
/*  71 */       BinopExp binopExp = (BinopExp)paramExp2;
/*  72 */       if (b(paramInt) > b(binopExp.op) || (
/*  73 */         b(paramInt) == b(binopExp.op) && !a(paramInt)))
/*  74 */         return binaryexp(binaryexp(paramExp1, paramInt, binopExp.lhs), binopExp.op, binopExp.rhs); 
/*     */     } 
/*  76 */     return new BinopExp(paramExp1, paramInt, paramExp2);
/*     */   }
/*     */   
/*     */   private static boolean a(int paramInt) {
/*  80 */     switch (paramInt) { case 18:
/*     */       case 22:
/*  82 */         return true; }
/*  83 */      return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int b(int paramInt) {
/*  88 */     switch (paramInt) { case 59:
/*  89 */         return 0;
/*  90 */       case 60: return 1;
/*  91 */       case 24: case 25: case 26: case 61: case 62: case 63: return 2;
/*  92 */       case 22: return 3;
/*  93 */       case 13: case 14: return 4;
/*  94 */       case 15: case 16: case 17: return 5;
/*  95 */       case 19: case 20: case 21: return 6;
/*  96 */       case 18: return 7; }
/*  97 */      throw new IllegalStateException("precedence of bad op " + paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Exp anonymousfunction(FuncBody paramFuncBody) {
/* 102 */     return new AnonFuncDef(paramFuncBody);
/*     */   }
/*     */ 
/*     */   
/*     */   public static NameExp nameprefix(String paramString) {
/* 107 */     return new NameExp(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ParensExp parensprefix(Exp paramExp) {
/* 112 */     return new ParensExp(paramExp);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IndexExp indexop(PrimaryExp paramPrimaryExp, Exp paramExp) {
/* 117 */     return new IndexExp(paramPrimaryExp, paramExp);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FieldExp fieldop(PrimaryExp paramPrimaryExp, String paramString) {
/* 122 */     return new FieldExp(paramPrimaryExp, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FuncCall functionop(PrimaryExp paramPrimaryExp, FuncArgs paramFuncArgs) {
/* 127 */     return new FuncCall(paramPrimaryExp, paramFuncArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MethodCall methodop(PrimaryExp paramPrimaryExp, String paramString, FuncArgs paramFuncArgs) {
/* 132 */     return new MethodCall(paramPrimaryExp, paramString, paramFuncArgs);
/*     */   }
/*     */   
/*     */   public boolean isvarexp() {
/* 136 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isfunccall() {
/* 140 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isvarargexp() {
/* 144 */     return false;
/*     */   }
/*     */   
/*     */   public static abstract class PrimaryExp extends Exp {
/*     */     public boolean isvarexp() {
/* 149 */       return false;
/*     */     }
/*     */     public boolean isfunccall() {
/* 152 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract class VarExp extends PrimaryExp {
/*     */     public boolean isvarexp() {
/* 158 */       return true;
/*     */     }
/*     */     
/*     */     public void markHasAssignment() {}
/*     */   }
/*     */   
/*     */   public static class NameExp extends VarExp { public final Name name;
/*     */     
/*     */     public NameExp(String param1String) {
/* 167 */       this.name = new Name(param1String);
/*     */     }
/*     */     public void markHasAssignment() {
/* 170 */       this.name.variable.hasassignments = true;
/*     */     }
/*     */     public void accept(Visitor param1Visitor) {
/* 173 */       param1Visitor.visit(this);
/*     */     } }
/*     */   
/*     */   public static class ParensExp extends PrimaryExp {
/*     */     public final Exp exp;
/*     */     
/*     */     public ParensExp(Exp param1Exp) {
/* 180 */       this.exp = param1Exp;
/*     */     }
/*     */     
/*     */     public void accept(Visitor param1Visitor) {
/* 184 */       param1Visitor.visit(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class FieldExp extends VarExp { public final Exp.PrimaryExp lhs;
/*     */     public final Name name;
/*     */     
/*     */     public FieldExp(Exp.PrimaryExp param1PrimaryExp, String param1String) {
/* 192 */       this.lhs = param1PrimaryExp;
/* 193 */       this.name = new Name(param1String);
/*     */     }
/*     */     
/*     */     public void accept(Visitor param1Visitor) {
/* 197 */       param1Visitor.visit(this);
/*     */     } }
/*     */   
/*     */   public static class IndexExp extends VarExp {
/*     */     public final Exp.PrimaryExp lhs;
/*     */     public final Exp exp;
/*     */     
/*     */     public IndexExp(Exp.PrimaryExp param1PrimaryExp, Exp param1Exp) {
/* 205 */       this.lhs = param1PrimaryExp;
/* 206 */       this.exp = param1Exp;
/*     */     }
/*     */     
/*     */     public void accept(Visitor param1Visitor) {
/* 210 */       param1Visitor.visit(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class FuncCall extends PrimaryExp {
/*     */     public final Exp.PrimaryExp lhs;
/*     */     public final FuncArgs args;
/*     */     
/*     */     public FuncCall(Exp.PrimaryExp param1PrimaryExp, FuncArgs param1FuncArgs) {
/* 219 */       this.lhs = param1PrimaryExp;
/* 220 */       this.args = param1FuncArgs;
/*     */     }
/*     */     
/*     */     public boolean isfunccall() {
/* 224 */       return true;
/*     */     }
/*     */     
/*     */     public void accept(Visitor param1Visitor) {
/* 228 */       param1Visitor.visit(this);
/*     */     }
/*     */     
/*     */     public boolean isvarargexp() {
/* 232 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class MethodCall extends FuncCall {
/*     */     public final String name;
/*     */     
/*     */     public MethodCall(Exp.PrimaryExp param1PrimaryExp, String param1String, FuncArgs param1FuncArgs) {
/* 240 */       super(param1PrimaryExp, param1FuncArgs);
/* 241 */       this.name = new String(param1String);
/*     */     }
/*     */     
/*     */     public boolean isfunccall() {
/* 245 */       return true;
/*     */     }
/*     */     
/*     */     public void accept(Visitor param1Visitor) {
/* 249 */       param1Visitor.visit(this);
/*     */     } }
/*     */   
/*     */   public static class Constant extends Exp {
/*     */     public final LuaValue value;
/*     */     
/*     */     public Constant(LuaValue param1LuaValue) {
/* 256 */       this.value = param1LuaValue;
/*     */     }
/*     */     
/*     */     public void accept(Visitor param1Visitor) {
/* 260 */       param1Visitor.visit(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class VarargsExp
/*     */     extends Exp {
/*     */     public void accept(Visitor param1Visitor) {
/* 267 */       param1Visitor.visit(this);
/*     */     }
/*     */     
/*     */     public boolean isvarargexp() {
/* 271 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class UnopExp extends Exp { public final int op;
/*     */     public final Exp rhs;
/*     */     
/*     */     public UnopExp(int param1Int, Exp param1Exp) {
/* 279 */       this.op = param1Int;
/* 280 */       this.rhs = param1Exp;
/*     */     }
/*     */     
/*     */     public void accept(Visitor param1Visitor) {
/* 284 */       param1Visitor.visit(this);
/*     */     } }
/*     */   
/*     */   public static class BinopExp extends Exp { public final Exp lhs;
/*     */     public final Exp rhs;
/*     */     public final int op;
/*     */     
/*     */     public BinopExp(Exp param1Exp1, int param1Int, Exp param1Exp2) {
/* 292 */       this.lhs = param1Exp1;
/* 293 */       this.op = param1Int;
/* 294 */       this.rhs = param1Exp2;
/*     */     }
/*     */     
/*     */     public void accept(Visitor param1Visitor) {
/* 298 */       param1Visitor.visit(this);
/*     */     } }
/*     */   
/*     */   public static class AnonFuncDef extends Exp {
/*     */     public final FuncBody body;
/*     */     
/*     */     public AnonFuncDef(FuncBody param1FuncBody) {
/* 305 */       this.body = param1FuncBody;
/*     */     }
/*     */     
/*     */     public void accept(Visitor param1Visitor) {
/* 309 */       param1Visitor.visit(this);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\ast\Exp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */