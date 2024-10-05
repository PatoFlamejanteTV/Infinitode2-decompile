/*     */ package com.vladsch.flexmark.util.html;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.BitFieldSet;
/*     */ import com.vladsch.flexmark.util.misc.Utils;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.Escaping;
/*     */ import com.vladsch.flexmark.util.sequence.LineAppendable;
/*     */ import com.vladsch.flexmark.util.sequence.LineAppendableImpl;
/*     */ import com.vladsch.flexmark.util.sequence.LineInfo;
/*     */ import com.vladsch.flexmark.util.sequence.RepeatedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Stack;
/*     */ 
/*     */ public class HtmlAppendableBase<T extends HtmlAppendableBase<T>>
/*     */   implements HtmlAppendable {
/*     */   private final LineAppendable appendable;
/*     */   private MutableAttributes currentAttributes;
/*     */   private boolean indentOnFirstEol = false;
/*  23 */   private final Stack<String> openTags = new Stack<>(); private boolean lineOnChildText = false; private boolean withAttributes = false; private boolean suppressOpenTagLine = false; private boolean suppressCloseTagLine = false;
/*     */   
/*     */   public HtmlAppendableBase(LineAppendable paramLineAppendable, boolean paramBoolean) {
/*  26 */     this((Appendable)paramLineAppendable, paramBoolean ? paramLineAppendable.getIndentPrefix().length() : 0, paramLineAppendable.getOptions());
/*     */   }
/*     */   
/*     */   public HtmlAppendableBase(int paramInt1, int paramInt2) {
/*  30 */     this(null, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public HtmlAppendableBase(Appendable paramAppendable, int paramInt1, int paramInt2) {
/*  34 */     this.appendable = (LineAppendable)new LineAppendableImpl(paramAppendable, paramInt2);
/*  35 */     this.appendable.setIndentPrefix(RepeatedSequence.repeatOf(" ", paramInt1).toString());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HtmlAppendable getEmptyAppendable() {
/*  41 */     return new HtmlAppendableBase((Appendable)this.appendable, this.appendable.getIndentPrefix().length(), this.appendable.getOptions());
/*     */   }
/*     */   
/*     */   public boolean isSuppressOpenTagLine() {
/*  45 */     return this.suppressOpenTagLine;
/*     */   }
/*     */   
/*     */   public void setSuppressOpenTagLine(boolean paramBoolean) {
/*  49 */     this.suppressOpenTagLine = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isSuppressCloseTagLine() {
/*  53 */     return this.suppressCloseTagLine;
/*     */   }
/*     */ 
/*     */   
/*     */   public T setSuppressCloseTagLine(boolean paramBoolean) {
/*  58 */     this.suppressCloseTagLine = paramBoolean;
/*  59 */     return (T)this;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  64 */     return this.appendable.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public T openPre() {
/*  69 */     this.appendable.openPreFormatted(true);
/*  70 */     return (T)this;
/*     */   }
/*     */ 
/*     */   
/*     */   public T closePre() {
/*  75 */     this.appendable.closePreFormatted();
/*  76 */     return (T)this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean inPre() {
/*  81 */     return this.appendable.isPreFormatted();
/*     */   }
/*     */   
/*     */   private boolean haveOptions(int paramInt) {
/*  85 */     return ((this.appendable.getOptions() & paramInt) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public T raw(CharSequence paramCharSequence) {
/*  90 */     this.appendable.append(paramCharSequence);
/*  91 */     return (T)this;
/*     */   }
/*     */   
/*     */   public T raw(CharSequence paramCharSequence, int paramInt) {
/*  95 */     paramInt = paramInt;
/*  96 */     for (; paramInt-- > 0; this.appendable.append(paramCharSequence));
/*  97 */     return (T)this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T rawPre(CharSequence paramCharSequence) {
/* 105 */     if (this.appendable.getPendingEOL() == 0 && paramCharSequence.length() > 0 && paramCharSequence.charAt(0) == '\n') {
/* 106 */       this.appendable.line();
/* 107 */       paramCharSequence = paramCharSequence.subSequence(1, paramCharSequence.length());
/*     */     } 
/*     */     
/* 110 */     this.appendable.openPreFormatted(true)
/* 111 */       .append(paramCharSequence)
/* 112 */       .closePreFormatted();
/* 113 */     return (T)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T rawIndentedPre(CharSequence paramCharSequence) {
/* 119 */     this.appendable.openPreFormatted(true)
/* 120 */       .append(paramCharSequence)
/* 121 */       .closePreFormatted();
/* 122 */     return (T)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T text(CharSequence paramCharSequence) {
/* 128 */     this.appendable.append(Escaping.escapeHtml(paramCharSequence, false));
/* 129 */     return (T)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T attr(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 135 */     if (this.currentAttributes == null) {
/* 136 */       this.currentAttributes = new MutableAttributes();
/*     */     }
/* 138 */     this.currentAttributes.addValue(paramCharSequence1, paramCharSequence2);
/* 139 */     return (T)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T attr(Attribute... paramVarArgs) {
/* 145 */     if (this.currentAttributes == null)
/* 146 */       this.currentAttributes = new MutableAttributes();  int i;
/*     */     byte b;
/* 148 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { Attribute attribute = paramVarArgs[b];
/* 149 */       this.currentAttributes.addValue(attribute.getName(), attribute.getValue()); b++; }
/*     */     
/* 151 */     return (T)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T attr(Attributes paramAttributes) {
/* 157 */     if (!paramAttributes.isEmpty()) {
/* 158 */       if (this.currentAttributes == null) {
/* 159 */         this.currentAttributes = new MutableAttributes(paramAttributes);
/*     */       } else {
/* 161 */         this.currentAttributes.addValues(paramAttributes);
/*     */       } 
/*     */     }
/* 164 */     return (T)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T withAttr() {
/* 170 */     this.withAttributes = true;
/* 171 */     return (T)this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Attributes getAttributes() {
/* 176 */     return this.currentAttributes;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T setAttributes(Attributes paramAttributes) {
/* 182 */     this.currentAttributes = paramAttributes.toMutable();
/* 183 */     return (T)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T withCondLineOnChildText() {
/* 189 */     this.lineOnChildText = true;
/* 190 */     return (T)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T withCondIndent() {
/* 196 */     this.indentOnFirstEol = true;
/* 197 */     return (T)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T tag(CharSequence paramCharSequence) {
/* 203 */     return tag(paramCharSequence, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T tag(CharSequence paramCharSequence, Runnable paramRunnable) {
/* 209 */     return tag(paramCharSequence, false, false, paramRunnable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T tagVoid(CharSequence paramCharSequence) {
/* 215 */     return tag(paramCharSequence, true);
/*     */   }
/*     */   
/*     */   protected String getOpenTagText() {
/* 219 */     return Utils.splice(this.openTags, ", ", true);
/*     */   }
/*     */   
/*     */   protected void pushTag(CharSequence paramCharSequence) {
/* 223 */     this.openTags.push(String.valueOf(paramCharSequence));
/*     */   }
/*     */   
/*     */   protected void popTag(CharSequence paramCharSequence) {
/* 227 */     if (this.openTags.isEmpty()) throw new IllegalStateException("Close tag '" + paramCharSequence + "' with no tags open"); 
/*     */     String str;
/* 229 */     if (!(str = this.openTags.peek()).equals(String.valueOf(paramCharSequence)))
/* 230 */       throw new IllegalStateException("Close tag '" + paramCharSequence + "' does not match '" + str + "' in " + getOpenTagText()); 
/* 231 */     this.openTags.pop();
/*     */   }
/*     */   
/*     */   protected void tagOpened(CharSequence paramCharSequence) {
/* 235 */     pushTag(paramCharSequence);
/*     */   }
/*     */   
/*     */   protected void tagClosed(CharSequence paramCharSequence) {
/* 239 */     popTag(paramCharSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Stack<String> getOpenTags() {
/* 245 */     return this.openTags;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getOpenTagsAfterLast(CharSequence paramCharSequence) {
/* 251 */     if (this.openTags.isEmpty()) return Collections.EMPTY_LIST;
/*     */ 
/*     */     
/*     */     ArrayList<String> arrayList;
/* 255 */     int i = (arrayList = new ArrayList<>(this.openTags)).size(), j = i;
/* 256 */     paramCharSequence = String.valueOf(paramCharSequence);
/* 257 */     for (int k = i; k-- > 0;) {
/* 258 */       if (((String)arrayList.get(k)).equals(paramCharSequence)) {
/* 259 */         j = k + 1;
/*     */         break;
/*     */       } 
/*     */     } 
/* 263 */     return arrayList.subList(j, i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T tag(CharSequence paramCharSequence, boolean paramBoolean) {
/* 269 */     if (paramCharSequence.length() == 0 || paramCharSequence.charAt(0) == '/') return closeTag(paramCharSequence);
/*     */     
/* 271 */     MutableAttributes mutableAttributes = null;
/*     */     
/* 273 */     if (this.withAttributes) {
/* 274 */       mutableAttributes = this.currentAttributes;
/* 275 */       this.currentAttributes = null;
/* 276 */       this.withAttributes = false;
/*     */     } 
/*     */     
/* 279 */     this.appendable.append("<");
/* 280 */     this.appendable.append(paramCharSequence);
/*     */     
/* 282 */     if (mutableAttributes != null && !mutableAttributes.isEmpty()) {
/* 283 */       for (Iterator<Attribute> iterator = mutableAttributes.values().iterator(); iterator.hasNext(); ) {
/* 284 */         Attribute attribute; String str = (attribute = iterator.next()).getValue();
/*     */         
/* 286 */         if (!attribute.isNonRendering()) {
/*     */           
/* 288 */           this.appendable.append(" ");
/* 289 */           this.appendable.append(Escaping.escapeHtml(attribute.getName(), true));
/* 290 */           this.appendable.append("=\"");
/* 291 */           this.appendable.append(Escaping.escapeHtml(str, true));
/* 292 */           this.appendable.append("\"");
/*     */         } 
/*     */       } 
/*     */     }
/* 296 */     if (paramBoolean) {
/* 297 */       this.appendable.append(" />");
/*     */     } else {
/* 299 */       this.appendable.append(">");
/* 300 */       tagOpened(paramCharSequence);
/*     */     } 
/*     */     
/* 303 */     return (T)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T closeTag(CharSequence paramCharSequence) {
/* 309 */     if (paramCharSequence.length() == 0) throw new IllegalStateException("closeTag called with tag:'" + paramCharSequence + "'");
/*     */     
/* 311 */     if (paramCharSequence.charAt(0) == '/') {
/* 312 */       this.appendable.append("<").append(paramCharSequence).append(">");
/* 313 */       tagClosed(paramCharSequence.subSequence(1, paramCharSequence.length()));
/*     */     } else {
/* 315 */       this.appendable.append("</").append(paramCharSequence).append(">");
/* 316 */       tagClosed(paramCharSequence);
/*     */     } 
/* 318 */     return (T)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T tag(CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2, Runnable paramRunnable) {
/* 324 */     boolean bool1 = this.lineOnChildText;
/* 325 */     boolean bool2 = this.indentOnFirstEol;
/* 326 */     this.lineOnChildText = false;
/* 327 */     this.indentOnFirstEol = false;
/*     */     
/* 329 */     if (paramBoolean1 && !this.suppressOpenTagLine) {
/* 330 */       this.appendable.line();
/*     */     }
/*     */     
/* 333 */     tag(paramCharSequence, false);
/*     */     
/* 335 */     if (paramBoolean1 && !bool2) this.appendable.indent();
/*     */     
/* 337 */     if ((this.appendable.getOptions() & F_PASS_THROUGH) != 0) {
/* 338 */       paramRunnable.run();
/*     */     } else {
/*     */       boolean[] arrayOfBoolean;
/* 341 */       Runnable runnable = () -> paramArrayOfboolean[0] = true;
/*     */       
/* 343 */       if (bool1) this.appendable.setLineOnFirstText();
/*     */       
/* 345 */       if (bool2) {
/* 346 */         this.appendable.addIndentOnFirstEOL(runnable);
/*     */       }
/*     */       
/* 349 */       paramRunnable.run();
/*     */       
/* 351 */       if (bool1) this.appendable.clearLineOnFirstText();
/*     */       
/* 353 */       if (arrayOfBoolean[0]) {
/* 354 */         this.appendable.unIndentNoEol();
/*     */       } else {
/* 356 */         this.appendable.removeIndentOnFirstEOL(runnable);
/*     */       } 
/*     */     } 
/*     */     
/* 360 */     if (paramBoolean1 && !bool2) this.appendable.unIndent();
/*     */ 
/*     */     
/* 363 */     if (paramBoolean2 && !this.suppressCloseTagLine) this.appendable.line();
/*     */     
/* 365 */     closeTag(paramCharSequence);
/*     */     
/* 367 */     if (paramBoolean1 && !this.suppressCloseTagLine) {
/* 368 */       this.appendable.line();
/*     */     }
/*     */     
/* 371 */     return (T)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T tagVoidLine(CharSequence paramCharSequence) {
/* 377 */     lineIf(!this.suppressOpenTagLine).tagVoid(paramCharSequence).lineIf(!this.suppressCloseTagLine);
/* 378 */     return (T)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T tagLine(CharSequence paramCharSequence) {
/* 384 */     lineIf(!this.suppressOpenTagLine).tag(paramCharSequence).lineIf(!this.suppressCloseTagLine);
/* 385 */     return (T)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T tagLine(CharSequence paramCharSequence, boolean paramBoolean) {
/* 391 */     lineIf(!this.suppressOpenTagLine).tag(paramCharSequence, paramBoolean).lineIf(!this.suppressCloseTagLine);
/* 392 */     return (T)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T tagLine(CharSequence paramCharSequence, Runnable paramRunnable) {
/* 398 */     lineIf(!this.suppressOpenTagLine).tag(paramCharSequence, false, false, paramRunnable).lineIf(!this.suppressCloseTagLine);
/* 399 */     return (T)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T tagIndent(CharSequence paramCharSequence, Runnable paramRunnable) {
/* 405 */     tag(paramCharSequence, true, false, paramRunnable);
/* 406 */     return (T)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T tagLineIndent(CharSequence paramCharSequence, Runnable paramRunnable) {
/* 412 */     tag(paramCharSequence, true, true, paramRunnable);
/* 413 */     return (T)this;
/*     */   }
/*     */   
/*     */   public Iterator<LineInfo> iterator()
/*     */   {
/* 418 */     return this.appendable.iterator();
/* 419 */   } public Iterable<BasedSequence> getLines(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) { return this.appendable.getLines(paramInt1, paramInt2, paramInt3, true); }
/* 420 */   public Iterable<LineInfo> getLinesInfo(int paramInt1, int paramInt2, int paramInt3) { return this.appendable.getLinesInfo(paramInt1, paramInt2, paramInt3); }
/* 421 */   public void setPrefixLength(int paramInt1, int paramInt2) { this.appendable.setPrefixLength(paramInt1, paramInt2); }
/* 422 */   public void insertLine(int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2) { this.appendable.insertLine(paramInt, paramCharSequence1, paramCharSequence2); }
/* 423 */   public void setLine(int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2) { this.appendable.setLine(paramInt, paramCharSequence1, paramCharSequence2); }
/* 424 */   public <T extends Appendable> T appendTo(T paramT, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) { return (T)this.appendable.appendTo((Appendable)paramT, paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4); }
/* 425 */   public boolean endsWithEOL() { return this.appendable.endsWithEOL(); }
/* 426 */   public boolean isPendingSpace() { return this.appendable.isPendingSpace(); }
/* 427 */   public boolean isPreFormatted() { return this.appendable.isPreFormatted(); }
/* 428 */   public int getTrailingBlankLines(int paramInt) { return this.appendable.getTrailingBlankLines(paramInt); }
/* 429 */   public int column() { return this.appendable.column(); }
/* 430 */   public int getLineCount() { return this.appendable.getLineCount(); }
/* 431 */   public int getLineCountWithPending() { return this.appendable.getLineCountWithPending(); }
/* 432 */   public int getOptions() { return this.appendable.getOptions(); }
/* 433 */   public int getPendingSpace() { return this.appendable.getPendingSpace(); }
/* 434 */   public int getPendingEOL() { return this.appendable.getPendingEOL(); }
/* 435 */   public int offset() { return this.appendable.offset(); }
/* 436 */   public int offsetWithPending() { return this.appendable.offsetWithPending(); }
/* 437 */   public int getAfterEolPrefixDelta() { return this.appendable.getAfterEolPrefixDelta(); }
/* 438 */   public ISequenceBuilder<?, ?> getBuilder() { return this.appendable.getBuilder(); }
/* 439 */   public BasedSequence getPrefix() { return this.appendable.getPrefix(); }
/* 440 */   public BasedSequence getBeforeEolPrefix() { return this.appendable.getBeforeEolPrefix(); }
/* 441 */   public LineInfo getLineInfo(int paramInt) { return this.appendable.getLineInfo(paramInt); }
/* 442 */   public BasedSequence getLine(int paramInt) { return this.appendable.getLine(paramInt); }
/* 443 */   public BasedSequence getIndentPrefix() { return this.appendable.getIndentPrefix(); }
/* 444 */   public CharSequence toSequence(int paramInt1, int paramInt2, boolean paramBoolean) { return this.appendable.toSequence(paramInt1, paramInt2, paramBoolean); }
/* 445 */   public String toString(int paramInt1, int paramInt2, boolean paramBoolean) { return this.appendable.toString(paramInt1, paramInt2, paramBoolean); }
/* 446 */   public BitFieldSet<LineAppendable.Options> getOptionSet() { return this.appendable.getOptionSet(); }
/* 447 */   public T removeExtraBlankLines(int paramInt1, int paramInt2, int paramInt3, int paramInt4) { this.appendable.removeExtraBlankLines(paramInt1, paramInt2, paramInt3, paramInt4); return (T)this; }
/* 448 */   public T removeLines(int paramInt1, int paramInt2) { this.appendable.removeLines(paramInt1, paramInt2); return (T)this; }
/* 449 */   public T pushOptions() { this.appendable.pushOptions(); return (T)this; }
/* 450 */   public T popOptions() { this.appendable.popOptions(); return (T)this; }
/* 451 */   public T changeOptions(int paramInt1, int paramInt2) { this.appendable.changeOptions(paramInt1, paramInt2); return (T)this; }
/* 452 */   public T addIndentOnFirstEOL(Runnable paramRunnable) { this.appendable.addIndentOnFirstEOL(paramRunnable); return (T)this; }
/* 453 */   public T addPrefix(CharSequence paramCharSequence) { this.appendable.addPrefix(paramCharSequence); return (T)this; }
/* 454 */   public T addPrefix(CharSequence paramCharSequence, boolean paramBoolean) { this.appendable.addPrefix(paramCharSequence, paramBoolean); return (T)this; }
/* 455 */   public T append(char paramChar) { this.appendable.append(paramChar); return (T)this; }
/* 456 */   public T append(CharSequence paramCharSequence) { this.appendable.append(paramCharSequence); return (T)this; }
/* 457 */   public T append(CharSequence paramCharSequence, int paramInt1, int paramInt2) { this.appendable.append(paramCharSequence, paramInt1, paramInt2); return (T)this; }
/* 458 */   public T append(LineAppendable paramLineAppendable, int paramInt1, int paramInt2, boolean paramBoolean) { this.appendable.append(paramLineAppendable, paramInt1, paramInt2, paramBoolean); return (T)this; }
/* 459 */   public T blankLine() { this.appendable.blankLine(); return (T)this; }
/* 460 */   public T blankLine(int paramInt) { this.appendable.blankLine(paramInt); return (T)this; }
/* 461 */   public T blankLineIf(boolean paramBoolean) { this.appendable.blankLineIf(paramBoolean); return (T)this; }
/* 462 */   public T closePreFormatted() { this.appendable.closePreFormatted(); return (T)this; }
/* 463 */   public T indent() { this.appendable.indent(); return (T)this; }
/* 464 */   public T line() { this.appendable.line(); return (T)this; }
/* 465 */   public T lineIf(boolean paramBoolean) { this.appendable.lineIf(paramBoolean); return (T)this; }
/* 466 */   public T lineOnFirstText(boolean paramBoolean) { this.appendable.lineOnFirstText(paramBoolean); return (T)this; }
/* 467 */   public T lineWithTrailingSpaces(int paramInt) { this.appendable.lineWithTrailingSpaces(paramInt); return (T)this; }
/* 468 */   public T openPreFormatted(boolean paramBoolean) { this.appendable.openPreFormatted(paramBoolean); return (T)this; }
/* 469 */   public T popPrefix() { this.appendable.popPrefix(); return (T)this; }
/* 470 */   public T popPrefix(boolean paramBoolean) { this.appendable.popPrefix(paramBoolean); return (T)this; }
/* 471 */   public T pushPrefix() { this.appendable.pushPrefix(); return (T)this; }
/* 472 */   public T removeIndentOnFirstEOL(Runnable paramRunnable) { this.appendable.removeIndentOnFirstEOL(paramRunnable); return (T)this; }
/* 473 */   public T append(char paramChar, int paramInt) { this.appendable.append(paramChar, paramInt); return (T)this; }
/* 474 */   public T setIndentPrefix(CharSequence paramCharSequence) { this.appendable.setIndentPrefix(paramCharSequence); return (T)this; }
/* 475 */   public T setOptions(int paramInt) { this.appendable.setOptions(paramInt); return (T)this; }
/* 476 */   public T setPrefix(CharSequence paramCharSequence) { this.appendable.setPrefix(paramCharSequence); return (T)this; }
/* 477 */   public T setPrefix(CharSequence paramCharSequence, boolean paramBoolean) { this.appendable.setPrefix(paramCharSequence, paramBoolean); return (T)this; }
/* 478 */   public T unIndent() { this.appendable.unIndent(); return (T)this; } public T unIndentNoEol() {
/* 479 */     this.appendable.unIndentNoEol(); return (T)this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\html\HtmlAppendableBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */