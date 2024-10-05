/*     */ package com.d.j;
/*     */ 
/*     */ import com.d.m.l;
/*     */ import java.util.logging.Level;
/*     */ import org.xml.sax.ErrorHandler;
/*     */ import org.xml.sax.SAXParseException;
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
/*     */ final class d
/*     */   implements ErrorHandler
/*     */ {
/*     */   d(c paramc) {}
/*     */   
/*     */   public final void error(SAXParseException paramSAXParseException) {
/* 109 */     if (l.b()) {
/* 110 */       l.b(Level.WARNING, paramSAXParseException.getMessage());
/*     */     }
/*     */   }
/*     */   
/*     */   public final void fatalError(SAXParseException paramSAXParseException) {
/* 115 */     if (l.b()) {
/* 116 */       l.b(Level.WARNING, paramSAXParseException.getMessage());
/*     */     }
/*     */   }
/*     */   
/*     */   public final void warning(SAXParseException paramSAXParseException) {
/* 121 */     if (l.b())
/* 122 */       l.b(Level.WARNING, paramSAXParseException.getMessage()); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\j\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */