/*      */ package com.prineside.luaj.parser;
/*      */ 
/*      */ import com.prineside.luaj.ast.Block;
/*      */ import com.prineside.luaj.ast.Exp;
/*      */ import com.prineside.luaj.ast.FuncArgs;
/*      */ import com.prineside.luaj.ast.FuncBody;
/*      */ import com.prineside.luaj.ast.Name;
/*      */ import com.prineside.luaj.ast.ParList;
/*      */ import com.prineside.luaj.ast.Stat;
/*      */ import com.prineside.luaj.ast.SyntaxElement;
/*      */ import com.prineside.luaj.ast.TableField;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ 
/*      */ public class LuaParser implements LuaParserConstants {
/*      */   public LuaParserTokenManager token_source;
/*      */   private SimpleCharStream a;
/*      */   public Token token;
/*      */   public Token jj_nt;
/*      */   private int b;
/*      */   private Token c;
/*      */   private Token d;
/*      */   private int e;
/*      */   private int f;
/*      */   
/*   26 */   static { LuaValue.valueOf(true);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1648 */     au();
/* 1649 */     av();
/* 1650 */     aw(); }
/*      */   public static void main(String[] paramArrayOfString) { LuaParser luaParser; (luaParser = new LuaParser(System.in)).Chunk(); }
/*      */   private static Exp.VarExp a(Exp.PrimaryExp paramPrimaryExp) { if (!paramPrimaryExp.isvarexp()) throw new ParseException("expected variable");  return (Exp.VarExp)paramPrimaryExp; }
/* 1653 */   private static Exp.FuncCall b(Exp.PrimaryExp paramPrimaryExp) { if (!paramPrimaryExp.isfunccall()) throw new ParseException("expected function call");  return (Exp.FuncCall)paramPrimaryExp; } public SimpleCharStream getCharStream() { return this.a; } private long a() { return this.a.getBeginLine() << 32L | this.a.getBeginColumn(); } private void a(SyntaxElement paramSyntaxElement, long paramLong) { paramSyntaxElement.beginLine = (int)(paramLong >> 32L); paramSyntaxElement.beginColumn = (short)(int)paramLong; paramSyntaxElement.endLine = this.token.endLine; paramSyntaxElement.endColumn = (short)this.token.endColumn; } private void a(SyntaxElement paramSyntaxElement, Token paramToken) { paramSyntaxElement.beginLine = paramToken.beginLine; paramSyntaxElement.beginColumn = (short)paramToken.beginColumn; paramSyntaxElement.endLine = this.token.endLine; paramSyntaxElement.endColumn = (short)this.token.endColumn; } public final Chunk Chunk() { Block block2; Chunk chunk2; long l = a(); switch ((this.b == -1) ? ax() : this.b) { case 69: h(69); this.token_source.SwitchTo(1); block2 = Block(); h(0); chunk2 = new Chunk(block2); a((SyntaxElement)chunk2, l); return chunk2; }  this.g[0] = this.f; Block block1 = Block(); h(0); Chunk chunk1 = new Chunk(block1); a((SyntaxElement)chunk1, l); return chunk1; } public final Block Block() { Stat stat; Block block = new Block(); long l = a(); while (true) { switch ((this.b == -1) ? ax() : this.b) { case 30: case 31: case 36: case 37: case 38: case 39: case 41: case 46: case 50: case 51: case 65: case 70: case 75: break;default: this.g[1] = this.f; break; }  Stat stat1 = Stat(); block.add(stat1); }  switch ((this.b == -1) ? ax() : this.b) { case 45: stat = ReturnStat(); block.add(stat); a((SyntaxElement)block, l); return block; }  this.g[2] = this.f; a((SyntaxElement)block, l); return block; } public final Stat Stat() { Stat stat6; Block block4; Stat stat5; Block block3; Stat stat4; Block block2; Stat stat3; Block block1; Stat stat2; FuncName funcName; Stat stat1; Exp exp1; List<Name> list2; FuncBody funcBody; List<Name> list1; List<Exp> list; Token token; Exp exp3 = null; Exp exp2 = null; long l = a(); switch ((this.b == -1) ? ax() : this.b) { case 70: h(70); return null;case 65: stat6 = Label(); a((SyntaxElement)stat6, l); return stat6;case 30: h(30); stat6 = Stat.breakstat(); a((SyntaxElement)stat6, l); return stat6;case 38: h(38); stat6 = Stat.gotostat((token = h(51)).image); a((SyntaxElement)stat6, l); return stat6;case 31: h(31); block4 = Block(); h(34); stat5 = Stat.block(block4); a((SyntaxElement)stat5, l); return stat5;case 50: h(50); exp1 = Exp(); h(31); block3 = Block(); h(34); stat4 = Stat.whiledo(exp1, block3); a((SyntaxElement)stat4, l); return stat4;case 46: h(46); block2 = Block(); h(49); exp1 = Exp(); stat3 = Stat.repeatuntil(block2, exp1); a((SyntaxElement)stat3, l); return stat3;case 39: stat3 = IfThenElse(); a((SyntaxElement)stat3, l); return stat3; }  this.g[5] = this.f; if (a(3)) { Block block6; Stat stat8; h(36); token = h(51); h(71); exp1 = Exp(); h(72); exp2 = Exp(); switch ((this.b == -1) ? ax() : this.b) { case 72: h(72); exp3 = Exp(); h(31); block6 = Block(); h(34); stat8 = Stat.fornumeric(token.image, exp1, exp2, exp3, block6); a((SyntaxElement)stat8, l); return stat8; }  this.g[3] = this.f; h(31); Block block5 = Block(); h(34); Stat stat7 = Stat.fornumeric(token.image, exp1, exp2, exp3, block5); a((SyntaxElement)stat7, l); return stat7; }  switch ((this.b == -1) ? ax() : this.b) { case 36: h(36); list2 = NameList(); h(40); list = ExpList(); h(31); block1 = Block(); h(34); stat2 = Stat.forgeneric(list2, list, block1); a((SyntaxElement)stat2, l); return stat2;case 37: h(37); funcName = FuncName(); funcBody = FuncBody(); stat1 = Stat.functiondef(funcName, funcBody); a((SyntaxElement)stat1, l); return stat1; }  this.g[6] = this.f; if (b(2)) { h(41); h(37); token = h(51); funcBody = FuncBody(); stat1 = Stat.localfunctiondef(token.image, funcBody); a((SyntaxElement)stat1, l); return stat1; }  switch ((this.b == -1) ? ax() : this.b) { case 41: h(41); list1 = NameList(); switch ((this.b == -1) ? ax() : this.b) { case 71: h(71); list = ExpList(); stat1 = Stat.localassignment(list1, list); a((SyntaxElement)stat1, l); return stat1; }  this.g[4] = this.f; stat1 = Stat.localassignment(list1, list); a((SyntaxElement)stat1, l); return stat1;case 51: case 75: stat1 = ExprStat(); a((SyntaxElement)stat1, l); return stat1; }  this.g[7] = this.f; h(-1); throw new ParseException(); } public final Stat IfThenElse() { Block block2 = null; ArrayList<Exp> arrayList = null; ArrayList<Block> arrayList1 = null; h(39); Exp exp = Exp(); h(47); Block block1 = Block(); while (true) { switch ((this.b == -1) ? ax() : this.b) { case 33: break;default: this.g[8] = this.f; break; }  h(33); Exp exp1 = Exp(); h(47); Block block = Block(); if (arrayList == null) arrayList = new ArrayList();  if (arrayList1 == null) arrayList1 = new ArrayList();  arrayList.add(exp1); arrayList1.add(block); }  switch ((this.b == -1) ? ax() : this.b) { case 32: h(32); block2 = Block(); h(34); return Stat.ifthenelse(exp, block1, arrayList, arrayList1, block2); }  this.g[9] = this.f; h(34); return Stat.ifthenelse(exp, block1, arrayList, arrayList1, block2); } public final Stat ReturnStat() { List<Exp> list = null; long l = a(); h(45); switch ((this.b == -1) ? ax() : this.b) { case 23: case 24: case 25: case 26: case 27: case 35: case 37: case 42: case 43: case 48: case 51: case 52: case 61: case 62: case 69: case 75: case 79: case 80: case 83: list = ExpList(); break;default: this.g[10] = this.f; break; }  switch ((this.b == -1) ? ax() : this.b) { case 70: h(70); stat = Stat.returnstat(list); a((SyntaxElement)stat, l); return stat; }  this.g[11] = this.f; Stat stat = Stat.returnstat((List)stat); a((SyntaxElement)stat, l); return stat; } public final Stat Label() { h(65); Token token = h(51); h(65); return Stat.labelstat(token.image); } public final Stat ExprStat() { Stat stat = null; long l = a(); Exp.PrimaryExp primaryExp = PrimaryExp(); switch ((this.b == -1) ? ax() : this.b) { case 71: case 72: stat = Assign(a(primaryExp)); break;default: this.g[12] = this.f; break; }  if (stat == null) stat = Stat.functioncall(b(primaryExp));  a((SyntaxElement)stat, l); return stat; } public final Stat Assign(Exp.VarExp paramVarExp) { ArrayList<Exp.VarExp> arrayList; (arrayList = new ArrayList<>()).add(paramVarExp); long l = a(); while (true) { switch ((this.b == -1) ? ax() : this.b) { case 72: break;default: this.g[13] = this.f; break; }  h(72); paramVarExp = VarExp(); arrayList.add(paramVarExp); }  h(71); List<Exp> list = ExpList(); Stat stat = Stat.assignment(arrayList, list); a((SyntaxElement)stat, l); return stat; } public final Exp.VarExp VarExp() { Exp.PrimaryExp primaryExp; return a(primaryExp = PrimaryExp()); } public final FuncName FuncName() { Token token = h(51); FuncName funcName = new FuncName(token.image); while (true) { switch ((this.b == -1) ? ax() : this.b) { case 73: break;default: this.g[14] = this.f; break; }  h(73); token = h(51); funcName.adddot(token.image); }  switch ((this.b == -1) ? ax() : this.b) { case 74: h(74); token = h(51); funcName.method = token.image; a((SyntaxElement)funcName, token); return funcName; }  this.g[15] = this.f; a((SyntaxElement)funcName, token); return funcName; } public final Exp.PrimaryExp PrefixExp() { Token token; Exp.NameExp nameExp; Exp exp; Exp.ParensExp parensExp; long l = a(); switch ((this.b == -1) ? ax() : this.b) { case 51: nameExp = Exp.nameprefix((token = h(51)).image); a((SyntaxElement)nameExp, l); return (Exp.PrimaryExp)nameExp;case 75: h(75); exp = Exp(); h(76); parensExp = Exp.parensprefix(exp); a((SyntaxElement)parensExp, l); return (Exp.PrimaryExp)parensExp; }  this.g[16] = this.f; h(-1); throw new ParseException(); } public final Exp.PrimaryExp PrimaryExp() { long l = a(); Exp.PrimaryExp primaryExp = PrefixExp(); while (c(2)) primaryExp = PostfixOp(primaryExp);  a((SyntaxElement)primaryExp, l); return primaryExp; } public final Exp.PrimaryExp PostfixOp(Exp.PrimaryExp paramPrimaryExp) { Exp.FieldExp fieldExp; Exp.IndexExp indexExp; Exp.MethodCall methodCall; Exp.FuncCall funcCall; Token token2; Exp exp; Token token1; FuncArgs funcArgs; long l = a(); switch ((this.b == -1) ? ax() : this.b) { case 73: h(73); token2 = h(51); fieldExp = Exp.fieldop(paramPrimaryExp, token2.image); a((SyntaxElement)fieldExp, l); return (Exp.PrimaryExp)fieldExp;case 77: h(77); exp = Exp(); h(78); indexExp = Exp.indexop((Exp.PrimaryExp)fieldExp, exp); a((SyntaxElement)indexExp, l); return (Exp.PrimaryExp)indexExp;case 74: h(74); token1 = h(51); funcArgs = FuncArgs(); methodCall = Exp.methodop((Exp.PrimaryExp)indexExp, token1.image, funcArgs); a((SyntaxElement)methodCall, l); return (Exp.PrimaryExp)methodCall;case 23: case 24: case 25: case 26: case 27: case 61: case 62: case 75: case 80: funcArgs = FuncArgs(); funcCall = Exp.functionop((Exp.PrimaryExp)methodCall, funcArgs); a((SyntaxElement)funcCall, l); return (Exp.PrimaryExp)funcCall; }  this.g[17] = this.f; h(-1); throw new ParseException(); } public final FuncArgs FuncArgs() { FuncArgs funcArgs3; TableConstructor tableConstructor; FuncArgs funcArgs2; LuaString luaString; FuncArgs funcArgs1; List<Exp> list = null; long l = a(); switch ((this.b == -1) ? ax() : this.b) { case 75: h(75); switch ((this.b == -1) ? ax() : this.b) { case 23: case 24: case 25: case 26: case 27: case 35: case 37: case 42: case 43: case 48: case 51: case 52: case 61: case 62: case 69: case 75: case 79: case 80: case 83: list = ExpList(); h(76); funcArgs3 = FuncArgs.explist(list); a((SyntaxElement)funcArgs3, l); return funcArgs3; }  this.g[18] = this.f; h(76); funcArgs3 = FuncArgs.explist((List)funcArgs3); a((SyntaxElement)funcArgs3, l); return funcArgs3;case 80: funcArgs2 = FuncArgs.tableconstructor(tableConstructor = TableConstructor()); a((SyntaxElement)funcArgs2, l); return funcArgs2;case 23: case 24: case 25: case 26: case 27: case 61: case 62: funcArgs1 = FuncArgs.string(luaString = Str()); a((SyntaxElement)funcArgs1, l); return funcArgs1; }  this.g[19] = this.f; h(-1); throw new ParseException(); } public final List<Name> NameList() { ArrayList<Name> arrayList = new ArrayList(); Token token = h(51); arrayList.add(new Name(token.image)); while (d(2)) { h(72); token = h(51); arrayList.add(new Name(token.image)); }  return arrayList; } public final List<Exp> ExpList() { ArrayList<Exp> arrayList = new ArrayList(); Exp exp = Exp(); arrayList.add(exp); while (true) { switch ((this.b == -1) ? ax() : this.b) { case 72: break;default: this.g[20] = this.f; break; }  h(72); exp = Exp(); arrayList.add(exp); }  return arrayList; } public final Exp SimpleExp() { Exp exp5; Token token; Exp exp4; LuaString luaString; Exp exp3; TableConstructor tableConstructor; Exp exp2; FuncBody funcBody; Exp exp1; Exp.PrimaryExp primaryExp; long l = a(); switch ((this.b == -1) ? ax() : this.b) { case 42: h(42); exp5 = Exp.constant(LuaValue.NIL); a((SyntaxElement)exp5, l); return exp5;case 48: h(48); exp5 = Exp.constant((LuaValue)LuaValue.TRUE); a((SyntaxElement)exp5, l); return exp5;case 35: h(35); exp5 = Exp.constant((LuaValue)LuaValue.FALSE); a((SyntaxElement)exp5, l); return exp5;case 52: exp4 = Exp.numberconstant((token = h(52)).image); a((SyntaxElement)exp4, l); return exp4;case 23: case 24: case 25: case 26: case 27: case 61: case 62: exp3 = Exp.constant((LuaValue)(luaString = Str())); a((SyntaxElement)exp3, l); return exp3;case 79: h(79); exp3 = Exp.varargs(); a((SyntaxElement)exp3, l); return exp3;case 80: exp2 = Exp.tableconstructor(tableConstructor = TableConstructor()); a((SyntaxElement)exp2, l); return exp2;case 37: exp1 = Exp.anonymousfunction(funcBody = FunctionCall()); a((SyntaxElement)exp1, l); return exp1;case 51: case 75: return (Exp)(primaryExp = PrimaryExp()); }  this.g[21] = this.f; h(-1); throw new ParseException(); } public final LuaString Str() { switch ((this.b == -1) ? ax() : this.b) { case 61: h(61); return Str.quoteString(this.token.image);case 62: h(62); return Str.charString(this.token.image);case 23: h(23); return Str.longString(this.token.image);case 24: h(24); return Str.longString(this.token.image);case 25: h(25); return Str.longString(this.token.image);case 26: h(26); return Str.longString(this.token.image);case 27: h(27); return Str.longString(this.token.image); }  this.g[22] = this.f; h(-1); throw new ParseException(); } public final Exp Exp() { Exp exp1, exp2; int i; long l = a(); switch ((this.b == -1) ? ax() : this.b) { case 23: case 24: case 25: case 26: case 27: case 35: case 37: case 42: case 48: case 51: case 52: case 61: case 62: case 75: case 79: case 80: exp1 = SimpleExp(); break;case 43: case 69: case 83: i = Unop(); exp2 = Exp(); exp1 = Exp.unaryexp(i, exp2); break;default: this.g[23] = this.f; h(-1); throw new ParseException(); }  while (e(2)) { i = Binop(); exp2 = Exp(); exp1 = Exp.binaryexp(exp1, i, exp2); }  a((SyntaxElement)exp1, l); return exp1; } public final FuncBody FunctionCall() { long l = a(); h(37); FuncBody funcBody = FuncBody(); a((SyntaxElement)funcBody, l); return funcBody; } public final FuncBody FuncBody() { ParList parList = null; long l = a(); h(75); switch ((this.b == -1) ? ax() : this.b) { case 51: case 79: parList = ParList(); h(76); block = Block(); h(34); funcBody = new FuncBody(parList, block); a((SyntaxElement)funcBody, l); return funcBody; }  this.g[24] = this.f; h(76); Block block = Block(); h(34); FuncBody funcBody = new FuncBody((ParList)funcBody, block); a((SyntaxElement)funcBody, l); return funcBody; } public final ParList ParList() { List<Name> list; ParList parList; boolean bool = false; long l = a(); switch ((this.b == -1) ? ax() : this.b) { case 51: list = NameList(); switch ((this.b == -1) ? ax() : this.b) { case 72: h(72); h(79); bool = true; parList = new ParList(list, bool); a((SyntaxElement)parList, l); return parList; }  this.g[25] = this.f; parList = new ParList((List)parList, bool); a((SyntaxElement)parList, l); return parList;case 79: h(79); parList = new ParList(null, true); a((SyntaxElement)parList, l); return parList; }  this.g[26] = this.f; h(-1); throw new ParseException(); } public final TableConstructor TableConstructor() { List<TableField> list; TableConstructor tableConstructor = new TableConstructor(); long l = a(); h(80); switch ((this.b == -1) ? ax() : this.b) { case 23: case 24: case 25: case 26: case 27: case 35: case 37: case 42: case 43: case 48: case 51: case 52: case 61: case 62: case 69: case 75: case 77: case 79: case 80: case 83: list = FieldList(); tableConstructor.fields = list; h(81); a((SyntaxElement)tableConstructor, l); return tableConstructor; }  this.g[27] = this.f; h(81); a((SyntaxElement)tableConstructor, l); return tableConstructor; } public final List<TableField> FieldList() { ArrayList<TableField> arrayList = new ArrayList(); TableField tableField = Field(); arrayList.add(tableField); while (f(2)) { FieldSep(); tableField = Field(); arrayList.add(tableField); }  switch ((this.b == -1) ? ax() : this.b) { case 70: case 72: FieldSep(); return arrayList; }  this.g[28] = this.f; return arrayList; } public final TableField Field() { Exp exp1; TableField tableField; Exp exp2; long l = a(); switch ((this.b == -1) ? ax() : this.b) { case 77: h(77); exp1 = Exp(); h(78); h(71); exp2 = Exp(); tableField = TableField.keyedField(exp1, exp2); a((SyntaxElement)tableField, l); return tableField; }  this.g[29] = this.f; if (g(2)) { Token token = h(51); h(71); exp2 = Exp(); TableField tableField1 = TableField.namedField(token.image, exp2); a((SyntaxElement)tableField1, l); return tableField1; }  switch ((this.b == -1) ? ax() : this.b) { case 23: case 24: case 25: case 26: case 27: case 35: case 37: case 42: case 43: case 48: case 51: case 52: case 61: case 62: case 69: case 75: case 79: case 80: case 83: tableField = TableField.listField(exp2 = Exp()); a((SyntaxElement)tableField, l); return tableField; }  this.g[30] = this.f; h(-1); throw new ParseException(); } public final void FieldSep() { switch ((this.b == -1) ? ax() : this.b) { case 72: h(72); return;case 70: h(70); return; }  this.g[31] = this.f; h(-1); throw new ParseException(); } public final int Binop() { switch ((this.b == -1) ? ax() : this.b) { case 82: h(82); return 13;case 83: h(83); return 14;case 84: h(84); return 15;case 85: h(85); return 16;case 86: h(86); return 18;case 87: h(87); return 17;case 88: h(88); return 22;case 89: h(89); return 25;case 90: h(90); return 26;case 91: h(91); return 63;case 92: h(92); return 62;case 93: h(93); return 24;case 94: h(94); return 61;case 29: h(29); return 60;case 44: h(44); return 59; }  this.g[32] = this.f; h(-1); throw new ParseException(); } public final int Unop() { switch ((this.b == -1) ? ax() : this.b) { case 83: h(83); return 19;case 43: h(43); return 20;case 69: h(69); return 21; }  this.g[33] = this.f; h(-1); throw new ParseException(); } private boolean a(int paramInt) { this.e = 3; this.d = this.c = this.token; try { paramInt = !E() ? 1 : 0; return paramInt; } catch (LookaheadSuccess lookaheadSuccess) { return true; } finally { b(0, 3); }  } private boolean b(int paramInt) { this.e = 2; this.d = this.c = this.token; try { paramInt = !z() ? 1 : 0; return paramInt; } catch (LookaheadSuccess lookaheadSuccess) { return true; } finally { b(1, 2); }  } private boolean c(int paramInt) { this.e = 2; this.d = this.c = this.token; try { paramInt = !f() ? 1 : 0; return paramInt; } catch (LookaheadSuccess lookaheadSuccess) { return true; } finally { b(2, 2); }  } private boolean d(int paramInt) { this.e = 2; this.d = this.c = this.token; try { paramInt = !C() ? 1 : 0; return paramInt; } catch (LookaheadSuccess lookaheadSuccess) { return true; } finally { b(3, 2); }  } private boolean e(int paramInt) { this.e = 2; this.d = this.c = this.token; try { paramInt = !n() ? 1 : 0; return paramInt; } catch (LookaheadSuccess lookaheadSuccess) { return true; } finally { b(4, 2); }  } private boolean f(int paramInt) { this.e = 2; this.d = this.c = this.token; try { paramInt = !Z() ? 1 : 0; return paramInt; } catch (LookaheadSuccess lookaheadSuccess) { return true; } finally { b(5, 2); }  } private boolean g(int paramInt) { this.e = 2; this.d = this.c = this.token; try { paramInt = !am() ? 1 : 0; return paramInt; } catch (LookaheadSuccess lookaheadSuccess) { return true; } finally { b(6, 2); }  } private boolean b() { if (U()) return true;  return false; } private boolean c() { if (as()) return true;  return false; } private boolean d() { if (i(75)) return true;  Token token = this.c; if (at()) this.c = token;  if (i(76)) return true;  return false; } private boolean e() { Token token = this.c; if (d()) { this.c = token; if (c()) { this.c = token; if (b()) return true;  }  }  return false; } private boolean f() { if (l()) return true;  return false; } private boolean g() { if (e()) return true;  return false; } private boolean h() { if (i(74)) return true;  if (i(51)) return true;  return false; } private boolean i() { if (i(77)) return true;  if (u()) return true;  return false; } private boolean j() { if (s()) return true;  return false; } private boolean k() { if (i(73)) return true;  if (i(51)) return true;  return false; } private boolean l() { Token token = this.c; if (k()) { this.c = token; if (i()) { this.c = token; if (h()) { this.c = token; if (g()) return true;  }  }  }  return false; } private boolean m() { if (i(37)) return true;  return false; } private boolean n() { if (Y()) return true;  if (u()) return true;  return false; } private boolean o() { if (y()) return true;  return false; } private boolean p() { if (i(69)) return true;  return false; } private boolean q() { if (i(43)) return true;  return false; } private static void au() { h = new int[] { 0, -1073741824, 0, 0, 0, -1073741824, 0, 0, 0, 0, 260046848, 0, 0, 0, 0, 0, 0, 260046848, 260046848, 260046848, 0, 260046848, 260046848, 260046848, 0, 0, 0, 260046848, 0, 0, 260046848, 0, 536870912, 0 }; }
/*      */   private boolean r() { if (i(83)) return true;  return false; }
/*      */   private boolean s() { Token token = this.c; if (r()) { this.c = token; if (q()) { this.c = token; if (p()) return true;  }  }  return false; }
/* 1656 */   private boolean t() { if (ak()) return true;  return false; } private boolean u() { Token token = this.c; if (t()) { this.c = token; if (j()) return true;  }  return false; } private boolean v() { if (i(75)) return true;  return false; } private boolean w() { if (i(44)) return true;  return false; } private boolean x() { if (i(51)) return true;  return false; } private boolean y() { Token token = this.c; if (x()) { this.c = token; if (v()) return true;  }  return false; } private boolean z() { if (i(41)) return true;  if (i(37)) return true;  return false; } private boolean A() { if (i(29)) return true;  return false; } private boolean B() { if (i(94)) return true;  return false; } private boolean C() { if (i(72)) return true;  if (i(51)) return true;  return false; } private boolean D() { if (i(93)) return true;  return false; } private boolean E() { if (i(36)) return true;  if (i(51)) return true;  if (i(71)) return true;  return false; } private boolean F() { if (i(92)) return true;  return false; } private boolean G() { if (i(91)) return true;  return false; } private boolean H() { if (i(27)) return true;  return false; } private boolean I() { if (i(90)) return true;  return false; } private boolean J() { if (i(26)) return true;  return false; } private boolean K() { if (i(89)) return true;  return false; } private boolean L() { if (i(25)) return true;  return false; } private boolean M() { if (i(88)) return true;  return false; } private boolean N() { if (i(24)) return true;  return false; } private boolean O() { if (i(87)) return true;  return false; } private boolean P() { if (i(23)) return true;  return false; } private boolean Q() { if (i(86)) return true;  return false; } private boolean R() { if (i(62)) return true;  return false; } private boolean S() { if (i(85)) return true;  return false; } private boolean T() { if (i(61)) return true;  return false; } private boolean U() { Token token = this.c; if (T()) { this.c = token; if (R()) { this.c = token; if (P()) { this.c = token; if (N()) { this.c = token; if (L()) { this.c = token; if (J()) { this.c = token; if (H()) return true;  }  }  }  }  }  }  return false; } private boolean V() { if (i(84)) return true;  return false; } private boolean W() { if (i(83)) return true;  return false; } private boolean X() { if (i(82)) return true;  return false; } private boolean Y() { Token token = this.c; if (X()) { this.c = token; if (W()) { this.c = token; if (V()) { this.c = token; if (S()) { this.c = token; if (Q()) { this.c = token; if (O()) { this.c = token; if (M()) { this.c = token; if (K()) { this.c = token; if (I()) { this.c = token; if (G()) { this.c = token; if (F()) { this.c = token; if (D()) { this.c = token; if (B()) { this.c = token; if (A()) { this.c = token; if (w()) return true;  }  }  }  }  }  }  }  }  }  }  }  }  }  }  return false; } private boolean Z() { if (ad()) return true;  if (an()) return true;  return false; } private boolean aa() { if (o()) return true;  return false; } private boolean ab() { if (m()) return true;  return false; } private boolean ac() { if (as()) return true;  return false; } private boolean ad() { Token token = this.c; if (i(72)) { this.c = token; if (i(70)) return true;  }  return false; } private boolean ae() { if (i(79)) return true;  return false; } private boolean af() { if (U()) return true;  return false; } private boolean ag() { if (i(52)) return true;  return false; } private boolean ah() { if (i(35)) return true;  return false; } private boolean ai() { if (i(48)) return true;  return false; } private boolean aj() { if (i(42)) return true;  return false; } private boolean ak() { Token token = this.c; if (aj()) { this.c = token; if (ai()) { this.c = token; if (ah()) { this.c = token; if (ag()) { this.c = token; if (af()) { this.c = token; if (ae()) { this.c = token; if (ac()) { this.c = token; if (ab()) { this.c = token; if (aa()) return true;  }  }  }  }  }  }  }  }  return false; } private boolean al() { if (u()) return true;  return false; } private boolean am() { if (i(51)) return true;  if (i(71)) return true;  return false; } private boolean an() { Token token = this.c; if (ao()) { this.c = token; if (am()) { this.c = token; if (al()) return true;  }  }  return false; } private boolean ao() { if (i(77)) return true;  return false; } private boolean ap() { if (an()) return true;  return false; } private boolean aq() { if (u()) return true;  return false; } private boolean ar() { if (ap()) return true;  return false; } private boolean as() { if (i(80)) return true;  Token token = this.c; if (ar()) this.c = token;  if (i(81)) return true;  return false; } private boolean at() { if (aq()) return true;  return false; } private final int[] g = new int[34]; private static int[] h; private static int[] i; private static int[] j; private static void av() { i = new int[] { 0, 803568, 8192, 0, 0, 278720, 48, 524800, 2, 1, 1612254248, 0, 0, 0, 0, 0, 524288, 1610612736, 1612254248, 1610612736, 0, 1612252200, 1610612736, 1612254248, 524288, 0, 524288, 1612254248, 0, 0, 1612254248, 0, 4096, 2048 }; }
/*      */   
/*      */   private static void aw() {
/* 1659 */     j = new int[] { 32, 2114, 0, 256, 128, 66, 0, 2048, 0, 0, 624672, 64, 384, 256, 512, 1024, 2048, 77312, 624672, 67584, 256, 100352, 0, 624672, 32768, 256, 32768, 632864, 320, 8192, 624672, 320, 2147221504, 524320 };
/*      */   }
/* 1661 */   private final JJCalls[] k = new JJCalls[7];
/*      */   private boolean l = false;
/* 1663 */   private int m = 0; private final LookaheadSuccess n; private List o; private int[] p; private int q; private int[] r;
/*      */   private int s;
/*      */   
/*      */   public LuaParser(InputStream paramInputStream) {
/* 1667 */     this(paramInputStream, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void ReInit(InputStream paramInputStream) {
/* 1682 */     ReInit(paramInputStream, null);
/*      */   }
/*      */   public void ReInit(InputStream paramInputStream, String paramString) {
/*      */     
/* 1686 */     try { this.a.ReInit(paramInputStream, paramString, 1, 1); } catch (UnsupportedEncodingException unsupportedEncodingException) { throw new RuntimeException(unsupportedEncodingException.getMessage()); }
/* 1687 */      this.token_source.ReInit(this.a);
/* 1688 */     this.token = new Token();
/* 1689 */     this.b = -1;
/* 1690 */     this.f = 0; byte b;
/* 1691 */     for (b = 0; b < 34; ) { this.g[b] = -1; b++; }
/* 1692 */      for (b = 0; b < this.k.length; ) { this.k[b] = new JJCalls(); b++; }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void ReInit(Reader paramReader) {
/* 1708 */     this.a.ReInit(paramReader, 1, 1);
/* 1709 */     this.token_source.ReInit(this.a);
/* 1710 */     this.token = new Token();
/* 1711 */     this.b = -1;
/* 1712 */     this.f = 0; byte b;
/* 1713 */     for (b = 0; b < 34; ) { this.g[b] = -1; b++; }
/* 1714 */      for (b = 0; b < this.k.length; ) { this.k[b] = new JJCalls(); b++; }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void ReInit(LuaParserTokenManager paramLuaParserTokenManager) {
/* 1729 */     this.token_source = paramLuaParserTokenManager;
/* 1730 */     this.token = new Token();
/* 1731 */     this.b = -1;
/* 1732 */     this.f = 0; byte b;
/* 1733 */     for (b = 0; b < 34; ) { this.g[b] = -1; b++; }
/* 1734 */      for (b = 0; b < this.k.length; ) { this.k[b] = new JJCalls(); b++; }
/*      */   
/*      */   } private Token h(int paramInt) {
/*      */     JJCalls jJCalls;
/*      */     Token token;
/* 1739 */     if ((token = this.token).next != null) { this.token = this.token.next; }
/* 1740 */     else { this.token = this.token.next = this.token_source.getNextToken(); }
/* 1741 */      this.b = -1;
/* 1742 */     if (this.token.kind == paramInt) {
/* 1743 */       this.f++;
/* 1744 */       if (++this.m > 100) {
/* 1745 */         this.m = 0;
/* 1746 */         for (paramInt = 0; paramInt < this.k.length; paramInt++) {
/* 1747 */           jJCalls = this.k[paramInt];
/* 1748 */           while (jJCalls != null) {
/* 1749 */             if (jJCalls.a < this.f) jJCalls.b = null; 
/* 1750 */             jJCalls = jJCalls.d;
/*      */           } 
/*      */         } 
/*      */       } 
/* 1754 */       return this.token;
/*      */     } 
/* 1756 */     this.token = (Token)jJCalls;
/* 1757 */     this.q = paramInt;
/* 1758 */     throw generateParseException();
/*      */   }
/*      */   private static final class LookaheadSuccess extends Error {
/*      */     private LookaheadSuccess() {} }
/* 1762 */   public LuaParser(InputStream paramInputStream, String paramString) { this.n = new LookaheadSuccess((byte)0);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1811 */     this.o = new ArrayList();
/*      */     
/* 1813 */     this.q = -1;
/* 1814 */     this.r = new int[100]; try { this.a = new SimpleCharStream(paramInputStream, paramString, 1, 1); } catch (UnsupportedEncodingException unsupportedEncodingException) { throw new RuntimeException(unsupportedEncodingException.getMessage()); }  this.token_source = new LuaParserTokenManager(this.a); this.token = new Token(); this.b = -1; this.f = 0; byte b; for (b = 0; b < 34; ) { this.g[b] = -1; b++; }  for (b = 0; b < this.k.length; ) { this.k[b] = new JJCalls(); b++; }  } public LuaParser(Reader paramReader) { this.n = new LookaheadSuccess((byte)0); this.o = new ArrayList(); this.q = -1; this.r = new int[100]; this.a = new SimpleCharStream(paramReader, 1, 1); this.token_source = new LuaParserTokenManager(this.a); this.token = new Token(); this.b = -1; this.f = 0; byte b; for (b = 0; b < 34; ) { this.g[b] = -1; b++; }  for (b = 0; b < this.k.length; ) { this.k[b] = new JJCalls(); b++; }  } public LuaParser(LuaParserTokenManager paramLuaParserTokenManager) { this.n = new LookaheadSuccess((byte)0); this.o = new ArrayList(); this.q = -1; this.r = new int[100]; this.token_source = paramLuaParserTokenManager; this.token = new Token(); this.b = -1; this.f = 0; byte b; for (b = 0; b < 34; ) { this.g[b] = -1; b++; }  for (b = 0; b < this.k.length; ) { this.k[b] = new JJCalls(); b++; }  } private boolean i(int paramInt) { if (this.c == this.d) { this.e--; if (this.c.next == null) { this.d = this.c = this.c.next = this.token_source.getNextToken(); } else { this.d = this.c = this.c.next; }  } else { this.c = this.c.next; }  if (this.l) { byte b = 0; Token token = this.token; while (token != null && token != this.c) { b++; token = token.next; }  if (token != null) a(paramInt, b);  }  if (this.c.kind != paramInt) return true;  if (this.e == 0 && this.c == this.d) throw this.n;  return false; }
/*      */   public final Token getNextToken() { if (this.token.next != null) { this.token = this.token.next; } else { this.token = this.token.next = this.token_source.getNextToken(); }  this.b = -1; this.f++; return this.token; }
/*      */   public final Token getToken(int paramInt) { Token token = this.token; for (byte b = 0; b < paramInt; b++) { if (token.next != null) { token = token.next; } else { token = token.next = this.token_source.getNextToken(); }  }  return token; }
/*      */   private int ax() { if ((this.jj_nt = this.token.next) == null) return this.b = (this.token.next = this.token_source.getNextToken()).kind;  return this.b = this.jj_nt.kind; }
/* 1818 */   private void a(int paramInt1, int paramInt2) { if (paramInt2 >= 100)
/* 1819 */       return;  if (paramInt2 == this.s + 1) {
/* 1820 */       this.r[this.s++] = paramInt1; return;
/* 1821 */     }  if (this.s != 0) {
/* 1822 */       this.p = new int[this.s];
/* 1823 */       for (byte b = 0; b < this.s; b++)
/* 1824 */         this.p[b] = this.r[b]; 
/*      */       Iterator<int[]> iterator;
/* 1826 */       label30: for (iterator = this.o.iterator(); iterator.hasNext();) {
/*      */         
/* 1828 */         if ((arrayOfInt = iterator.next()).length == this.p.length) {
/* 1829 */           for (byte b1 = 0; b1 < this.p.length; ) {
/* 1830 */             if (arrayOfInt[b1] == this.p[b1]) {
/*      */               b1++; continue;
/*      */             }  continue label30;
/*      */           } 
/* 1834 */           this.o.add(this.p);
/*      */           break;
/*      */         } 
/*      */       } 
/* 1838 */       if (paramInt2 != 0) this.r[(this.s = paramInt2) - 1] = paramInt1;
/*      */     
/*      */     }  }
/*      */ 
/*      */   
/*      */   public ParseException generateParseException() {
/* 1844 */     this.o.clear();
/* 1845 */     boolean[] arrayOfBoolean = new boolean[95];
/* 1846 */     if (this.q >= 0) {
/* 1847 */       arrayOfBoolean[this.q] = true;
/* 1848 */       this.q = -1;
/*      */     }  byte b1;
/* 1850 */     for (b1 = 0; b1 < 34; b1++) {
/* 1851 */       if (this.g[b1] == this.f) {
/* 1852 */         for (byte b = 0; b < 32; b++) {
/* 1853 */           if ((h[b1] & 1 << b) != 0) {
/* 1854 */             arrayOfBoolean[b] = true;
/*      */           }
/* 1856 */           if ((i[b1] & 1 << b) != 0) {
/* 1857 */             arrayOfBoolean[b + 32] = true;
/*      */           }
/* 1859 */           if ((j[b1] & 1 << b) != 0) {
/* 1860 */             arrayOfBoolean[b + 64] = true;
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/* 1865 */     for (b1 = 0; b1 < 95; b1++) {
/* 1866 */       if (arrayOfBoolean[b1]) {
/* 1867 */         this.p = new int[1];
/* 1868 */         this.p[0] = b1;
/* 1869 */         this.o.add(this.p);
/*      */       } 
/*      */     } 
/* 1872 */     this.s = 0;
/* 1873 */     ay();
/* 1874 */     a(0, 0);
/* 1875 */     int[][] arrayOfInt = new int[this.o.size()][];
/* 1876 */     for (byte b2 = 0; b2 < this.o.size(); b2++) {
/* 1877 */       arrayOfInt[b2] = this.o.get(b2);
/*      */     }
/* 1879 */     return new ParseException(this.token, arrayOfInt, tokenImage);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void enable_tracing() {}
/*      */ 
/*      */   
/*      */   public final void disable_tracing() {}
/*      */ 
/*      */   
/*      */   private void ay() {
/* 1891 */     this.l = true;
/* 1892 */     for (byte b = 0; b < 7; b++) {
/*      */       try {
/* 1894 */         JJCalls jJCalls = this.k[b];
/*      */         do {
/* 1896 */           if (jJCalls.a <= this.f)
/* 1897 */             continue;  this.e = jJCalls.c; this.d = this.c = jJCalls.b;
/* 1898 */           switch (b) { case 0:
/* 1899 */               E(); break;
/* 1900 */             case 1: z(); break;
/* 1901 */             case 2: f(); break;
/* 1902 */             case 3: C(); break;
/* 1903 */             case 4: n(); break;
/* 1904 */             case 5: Z(); break;
/* 1905 */             case 6: am();
/*      */               break; }
/*      */ 
/*      */         
/* 1909 */         } while ((jJCalls = jJCalls.d) != null);
/* 1910 */       } catch (LookaheadSuccess lookaheadSuccess) {}
/*      */     } 
/* 1912 */     this.l = false;
/*      */   }
/*      */   
/*      */   private void b(int paramInt1, int paramInt2) {
/* 1916 */     JJCalls jJCalls = this.k[paramInt1];
/* 1917 */     while (jJCalls.a > this.f) {
/* 1918 */       if (jJCalls.d == null) { jJCalls = jJCalls.d = new JJCalls(); break; }
/* 1919 */        jJCalls = jJCalls.d;
/*      */     } 
/* 1921 */     jJCalls.a = this.f + paramInt2 - this.e; jJCalls.b = this.token; jJCalls.c = paramInt2;
/*      */   }
/*      */   
/*      */   static final class JJCalls {
/*      */     int a;
/*      */     Token b;
/*      */     int c;
/*      */     JJCalls d;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\parser\LuaParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */