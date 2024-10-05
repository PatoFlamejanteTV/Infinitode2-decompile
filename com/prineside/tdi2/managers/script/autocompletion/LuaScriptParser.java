/*     */ package com.prineside.tdi2.managers.script.autocompletion;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.utils.logging.LogLevel;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ public class LuaScriptParser {
/*     */   static {
/*  12 */     TLog.forClass(LuaScriptParser.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private String a;
/*  17 */   public final Block root = new Block();
/*     */   
/*     */   public LuaScriptParser(String paramString) {
/*  20 */     this.a = paramString;
/*     */     
/*  22 */     this.root.end = paramString.length() - 1;
/*     */     
/*  24 */     Block block = this.root;
/*  25 */     for (byte b = 0; b < paramString.length(); b++) {
/*  26 */       char c = paramString.charAt(b);
/*     */       
/*  28 */       if (block.isString() && c == '\\' && b != paramString.length() - 1) {
/*     */         
/*  30 */         b++;
/*     */ 
/*     */       
/*     */       }
/*  34 */       else if (block.isString() && c == block.startChar) {
/*     */         
/*  36 */         block.end = b;
/*  37 */         block = block.parent;
/*     */       
/*     */       }
/*  40 */       else if (!block.isString()) {
/*  41 */         Block block1; switch (c) {
/*     */ 
/*     */           
/*     */           case '"':
/*     */           case '\'':
/*     */           case '(':
/*  47 */             (block1 = new Block()).startChar = c;
/*  48 */             block1.parent = block;
/*  49 */             block1.start = b;
/*  50 */             block1.end = paramString.length() - 1;
/*  51 */             block.children.add(block1);
/*  52 */             block = block1;
/*     */             break;
/*     */ 
/*     */           
/*     */           case ')':
/*  57 */             if (block.startChar == '(') {
/*  58 */               block.end = b;
/*  59 */               block = block.parent; break;
/*     */             } 
/*  61 */             throw new IllegalArgumentException("Invalid char at " + b + " - can not close block of type '" + block.startChar + "' starting at " + block.start + " with ')'");
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/*  71 */     LogLevel.setCurrent((byte)3);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     byte b;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  81 */     for (paramArrayOfString = paramArrayOfString = new String[] { "", "c", "cm", "local a = co" }, b = 0; b < 4; ) { String str = paramArrayOfString[b];
/*  82 */       System.out.println("");
/*  83 */       System.out.println("");
/*  84 */       System.out.println("");
/*  85 */       System.out.println("====" + str + "====");
/*  86 */       LuaScriptParser luaScriptParser = new LuaScriptParser(str);
/*  87 */       System.out.println(luaScriptParser.root.describe(str));
/*     */       
/*  89 */       for (byte b1 = -1; b1 < str.length(); b1++)
/*  90 */         System.out.println("> Cursor pos: " + b1 + " | " + Arrays.toString((Object[])luaScriptParser.getACStringAt(b1))); 
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   private Block a(int paramInt) {
/*     */     Array array;
/*  97 */     (array = new Array()).add(this.root);
/*  98 */     Block block = this.root;
/*  99 */     while (array.size != 0) {
/* 100 */       Block block1 = (Block)array.pop();
/* 101 */       if (paramInt >= block1.start && paramInt <= block1.end) {
/* 102 */         block = block1;
/* 103 */         for (Array.ArrayIterator<Block> arrayIterator = block1.children.iterator(); arrayIterator.hasNext(); ) { Block block2 = arrayIterator.next();
/* 104 */           array.add(block2); }
/*     */       
/*     */       } 
/*     */     } 
/* 108 */     return block;
/*     */   }
/*     */   @Null
/*     */   public String[] getACStringAt(int paramInt) {
/* 112 */     if (paramInt < -1 || paramInt >= this.a.length()) {
/* 113 */       return null;
/*     */     }
/*     */     
/*     */     Block block;
/* 117 */     if ((block = a(paramInt)).isString()) {
/* 118 */       return null;
/*     */     }
/*     */     
/* 121 */     StringBuilder stringBuilder = new StringBuilder();
/* 122 */     for (int i = block.start; i <= paramInt; i++) {
/* 123 */       boolean bool = false;
/* 124 */       for (Array.ArrayIterator<Block> arrayIterator = block.children.iterator(); arrayIterator.hasNext();) {
/* 125 */         if ((block1 = arrayIterator.next()).start <= i && block1.end >= i) {
/* 126 */           bool = true;
/*     */           break;
/*     */         } 
/*     */       } 
/* 130 */       if (bool) {
/* 131 */         stringBuilder.append('%');
/*     */       } else {
/* 133 */         stringBuilder.append(this.a.charAt(i));
/*     */       } 
/*     */     } 
/*     */     
/*     */     String str;
/*     */     
/*     */     int j;
/*     */     
/* 141 */     if ((j = Math.max((str = (str = stringBuilder.toString()).replaceAll("%", "")).lastIndexOf(".."), str.lastIndexOf("="))) != -1) {
/* 142 */       str = str.substring(j + 1);
/*     */     }
/*     */     
/*     */     while (true) {
/*     */       boolean bool;
/* 147 */       if ((bool = (str.length() == 0) ? false : str.charAt(0)) == 32 || bool == 40 || bool == 9 || bool == 10 || bool == 46) {
/* 148 */         str = str.substring(1);
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/*     */       break;
/*     */     } 
/*     */     
/* 156 */     if ((str = str.trim()).contains(")")) {
/* 157 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 161 */     Array array = new Array();
/* 162 */     stringBuilder = new StringBuilder();
/* 163 */     for (byte b = 0; b < str.length(); b++) {
/*     */       
/* 165 */       if ((paramInt = str.charAt(b)) == 58 || paramInt == 46) {
/* 166 */         array.add(stringBuilder.toString());
/* 167 */         stringBuilder.setLength(0);
/*     */       } else {
/* 169 */         stringBuilder.append(paramInt);
/*     */       } 
/*     */     } 
/* 172 */     array.add(stringBuilder.toString());
/* 173 */     return (String[])array.toArray(String.class);
/*     */   }
/*     */   
/*     */   public static final class Block {
/*     */     @Null
/*     */     public Block parent;
/* 179 */     public Array<Block> children = new Array();
/*     */     public char startChar;
/*     */     public int start;
/*     */     public int end;
/*     */     
/*     */     public final boolean isString() {
/* 185 */       return (this.startChar == '\'' || this.startChar == '"');
/*     */     }
/*     */ 
/*     */     
/*     */     public final String describe(String param1String) {
/* 190 */       Array array1 = new Array();
/*     */       Array array2;
/* 192 */       (array2 = new Array()).add(this);
/* 193 */       while (array2.size != 0) {
/* 194 */         Block block = (Block)array2.pop();
/* 195 */         array1.add(block);
/* 196 */         for (int i = block.children.size - 1; i >= 0; i--) {
/* 197 */           array2.add(block.children.get(i));
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 202 */       StringBuilder stringBuilder = new StringBuilder();
/* 203 */       for (Array.ArrayIterator<Block> arrayIterator = array1.iterator(); arrayIterator.hasNext(); ) { Block block = arrayIterator.next(); byte b;
/* 204 */         for (b = 0; b < block.start; b++) {
/* 205 */           stringBuilder.append(' ');
/*     */         }
/* 207 */         stringBuilder.append(block.startChar);
/* 208 */         for (b = 0; b < block.end - block.start; b++) {
/* 209 */           stringBuilder.append('-');
/*     */         }
/* 211 */         for (b = 0; b < param1String.length() - block.end; b++) {
/* 212 */           stringBuilder.append(' ');
/*     */         }
/* 214 */         stringBuilder.append(block.start).append(':').append(block.end);
/* 215 */         stringBuilder.append("\n"); }
/*     */ 
/*     */       
/* 218 */       return param1String + "\n" + stringBuilder;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\script\autocompletion\LuaScriptParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */