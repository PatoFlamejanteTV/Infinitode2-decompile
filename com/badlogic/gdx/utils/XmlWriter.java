/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import java.io.Writer;
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
/*     */ public class XmlWriter
/*     */   extends Writer
/*     */ {
/*     */   private final Writer writer;
/*  44 */   private final Array<String> stack = new Array<>();
/*     */   
/*     */   private String currentElement;
/*     */   private boolean indentNextClose;
/*     */   public int indent;
/*     */   
/*     */   public XmlWriter(Writer paramWriter) {
/*  51 */     this.writer = paramWriter;
/*     */   }
/*     */   
/*     */   private void indent() {
/*  55 */     int i = this.indent;
/*  56 */     if (this.currentElement != null) i++; 
/*  57 */     for (byte b = 0; b < i; b++)
/*  58 */       this.writer.write(9); 
/*     */   }
/*     */   
/*     */   public XmlWriter element(String paramString) {
/*  62 */     if (startElementContent()) this.writer.write(10); 
/*  63 */     indent();
/*  64 */     this.writer.write(60);
/*  65 */     this.writer.write(paramString);
/*  66 */     this.currentElement = paramString;
/*  67 */     return this;
/*     */   }
/*     */   
/*     */   public XmlWriter element(String paramString, Object paramObject) {
/*  71 */     return element(paramString).text(paramObject).pop();
/*     */   }
/*     */   
/*     */   private boolean startElementContent() {
/*  75 */     if (this.currentElement == null) return false; 
/*  76 */     this.indent++;
/*  77 */     this.stack.add(this.currentElement);
/*  78 */     this.currentElement = null;
/*  79 */     this.writer.write(">");
/*  80 */     return true;
/*     */   }
/*     */   
/*     */   public XmlWriter attribute(String paramString, Object paramObject) {
/*  84 */     if (this.currentElement == null) throw new IllegalStateException(); 
/*  85 */     this.writer.write(32);
/*  86 */     this.writer.write(paramString);
/*  87 */     this.writer.write("=\"");
/*  88 */     this.writer.write((paramObject == null) ? "null" : paramObject.toString());
/*  89 */     this.writer.write(34);
/*  90 */     return this;
/*     */   }
/*     */   
/*     */   public XmlWriter text(Object paramObject) {
/*  94 */     startElementContent();
/*  95 */     paramObject = (paramObject == null) ? "null" : paramObject.toString();
/*  96 */     this.indentNextClose = (paramObject.length() > 64);
/*  97 */     if (this.indentNextClose) {
/*  98 */       this.writer.write(10);
/*  99 */       indent();
/*     */     } 
/* 101 */     this.writer.write((String)paramObject);
/* 102 */     if (this.indentNextClose) this.writer.write(10); 
/* 103 */     return this;
/*     */   }
/*     */   
/*     */   public XmlWriter pop() {
/* 107 */     if (this.currentElement != null) {
/* 108 */       this.writer.write("/>\n");
/* 109 */       this.currentElement = null;
/*     */     } else {
/* 111 */       this.indent = Math.max(this.indent - 1, 0);
/* 112 */       if (this.indentNextClose) indent(); 
/* 113 */       this.writer.write("</");
/* 114 */       this.writer.write(this.stack.pop());
/* 115 */       this.writer.write(">\n");
/*     */     } 
/* 117 */     this.indentNextClose = true;
/* 118 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 123 */     while (this.stack.size != 0)
/* 124 */       pop(); 
/* 125 */     this.writer.close();
/*     */   }
/*     */   
/*     */   public void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 129 */     startElementContent();
/* 130 */     this.writer.write(paramArrayOfchar, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void flush() {
/* 134 */     this.writer.flush();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\XmlWriter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */