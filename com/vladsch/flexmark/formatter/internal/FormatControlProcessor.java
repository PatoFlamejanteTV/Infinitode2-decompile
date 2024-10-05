/*     */ package com.vladsch.flexmark.formatter.internal;
/*     */ 
/*     */ import com.vladsch.flexmark.formatter.FormatterOptions;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import java.util.regex.Pattern;
/*     */ import java.util.regex.PatternSyntaxException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FormatControlProcessor
/*     */ {
/*     */   public static final String OPEN_COMMENT = "<!--";
/*     */   public static final String CLOSE_COMMENT = "-->";
/*     */   private final String formatterOnTag;
/*     */   private final String formatterOffTag;
/*     */   private final boolean formatterTagsEnabled;
/*     */   private boolean myFormatterOff = false;
/*     */   private boolean justTurnedOffFormatting = false;
/*     */   private boolean justTurnedOnFormatting = false;
/*     */   private boolean formatterTagsAcceptRegexp;
/*     */   private volatile Pattern formatterOffPattern;
/*     */   private volatile Pattern formatterOnPattern;
/*     */   
/*     */   public FormatControlProcessor(Document paramDocument, DataHolder paramDataHolder) {
/*  33 */     FormatterOptions formatterOptions = new FormatterOptions(paramDataHolder);
/*  34 */     this.formatterOnTag = formatterOptions.formatterOnTag;
/*  35 */     this.formatterOffTag = formatterOptions.formatterOffTag;
/*  36 */     this.formatterTagsEnabled = formatterOptions.formatterTagsEnabled;
/*  37 */     this.formatterTagsAcceptRegexp = formatterOptions.formatterTagsAcceptRegexp;
/*     */   }
/*     */   
/*     */   public boolean isFormattingOff() {
/*  41 */     return this.myFormatterOff;
/*     */   }
/*     */ 
/*     */   
/*     */   public Pattern getFormatterOffPattern() {
/*  46 */     if (this.formatterOffPattern == null && this.formatterTagsEnabled && this.formatterTagsAcceptRegexp) {
/*  47 */       this.formatterOffPattern = getPatternOrDisableRegexp(this.formatterOffTag);
/*     */     }
/*     */     
/*  50 */     return this.formatterOffPattern;
/*     */   }
/*     */ 
/*     */   
/*     */   public Pattern getFormatterOnPattern() {
/*  55 */     if (this.formatterOffPattern == null && this.formatterTagsEnabled && this.formatterTagsAcceptRegexp) {
/*  56 */       this.formatterOnPattern = getPatternOrDisableRegexp(this.formatterOnTag);
/*     */     }
/*     */     
/*  59 */     return this.formatterOnPattern;
/*     */   }
/*     */ 
/*     */   
/*     */   private Pattern getPatternOrDisableRegexp(String paramString) {
/*     */     try {
/*  65 */       return Pattern.compile(paramString);
/*  66 */     } catch (PatternSyntaxException patternSyntaxException) {
/*  67 */       this.formatterTagsAcceptRegexp = false;
/*  68 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isFormattingRegion() {
/*  73 */     return !this.myFormatterOff;
/*     */   }
/*     */   
/*     */   public String getFormatterOnTag() {
/*  77 */     return this.formatterOnTag;
/*     */   }
/*     */   
/*     */   public String getFormatterOffTag() {
/*  81 */     return this.formatterOffTag;
/*     */   }
/*     */   
/*     */   public boolean getFormatterTagsEnabled() {
/*  85 */     return this.formatterTagsEnabled;
/*     */   }
/*     */   
/*     */   public boolean getFormatterRegExEnabled() {
/*  89 */     return this.formatterTagsAcceptRegexp;
/*     */   }
/*     */   
/*     */   public boolean isJustTurnedOffFormatting() {
/*  93 */     return this.justTurnedOffFormatting;
/*     */   }
/*     */   
/*     */   public boolean isJustTurnedOnFormatting() {
/*  97 */     return this.justTurnedOnFormatting;
/*     */   }
/*     */ 
/*     */   
/*     */   private Boolean isFormatterOffTag(CharSequence paramCharSequence) {
/* 102 */     if (paramCharSequence == null) return null;
/*     */ 
/*     */     
/* 105 */     paramCharSequence = (paramCharSequence = paramCharSequence.toString().trim()).substring(4, paramCharSequence.length() - 3).trim();
/*     */     
/* 107 */     if (this.formatterTagsAcceptRegexp && this.formatterOffPattern != null && this.formatterOnPattern != null) {
/* 108 */       if (this.formatterOnPattern.matcher(paramCharSequence).matches())
/* 109 */         return Boolean.FALSE; 
/* 110 */       if (this.formatterOffPattern.matcher(paramCharSequence).matches()) {
/* 111 */         return Boolean.TRUE;
/*     */       }
/* 113 */     } else if (this.formatterTagsEnabled) {
/* 114 */       if (paramCharSequence.equals(this.formatterOnTag))
/* 115 */         return Boolean.FALSE; 
/* 116 */       if (paramCharSequence.equals(this.formatterOffTag)) {
/* 117 */         return Boolean.TRUE;
/*     */       }
/*     */     } 
/* 120 */     return null;
/*     */   }
/*     */   
/*     */   public void initializeFrom(Node paramNode) {
/* 124 */     this.myFormatterOff = !isFormattingRegion(paramNode.getStartOffset(), paramNode, true);
/*     */   }
/*     */   
/*     */   public void processFormatControl(Node paramNode) {
/* 128 */     this.justTurnedOffFormatting = false;
/* 129 */     this.justTurnedOnFormatting = false;
/*     */     
/* 131 */     if ((paramNode instanceof com.vladsch.flexmark.ast.HtmlCommentBlock || paramNode instanceof com.vladsch.flexmark.ast.HtmlInnerBlockComment) && this.formatterTagsEnabled) {
/*     */       
/* 133 */       boolean bool1 = this.myFormatterOff;
/*     */       Boolean bool;
/* 135 */       if ((bool = isFormatterOffTag((CharSequence)paramNode.getChars())) == null)
/*     */         return; 
/* 137 */       this.myFormatterOff = bool.booleanValue();
/*     */       
/* 139 */       if (!bool1 && this.myFormatterOff) this.justTurnedOffFormatting = true; 
/* 140 */       if (bool1 && !this.myFormatterOff) this.justTurnedOnFormatting = true; 
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean isFormattingRegion(int paramInt, Node paramNode, boolean paramBoolean) {
/* 145 */     while (paramNode != null) {
/* 146 */       if (paramNode.getStartOffset() <= paramInt) {
/* 147 */         if (paramNode instanceof com.vladsch.flexmark.util.ast.Block && !(paramNode instanceof com.vladsch.flexmark.ast.Paragraph) && paramNode.hasChildren()) {
/*     */           Node node;
/* 149 */           if ((node = paramNode.getLastChild()) != null && isFormattingRegion(paramInt, node, false)) return true;  return false;
/* 150 */         }  Boolean bool; if ((paramNode instanceof com.vladsch.flexmark.ast.HtmlCommentBlock || paramNode instanceof com.vladsch.flexmark.ast.HtmlInnerBlockComment) && (
/*     */           
/* 152 */           bool = isFormatterOffTag((CharSequence)paramNode.getChars())) != null) return !bool.booleanValue();
/*     */       
/*     */       } 
/*     */       
/* 156 */       if (paramNode.getPrevious() == null && paramBoolean) {
/*     */         
/* 158 */         if (!(paramNode = paramNode.getParent() instanceof Document)) {
/* 159 */           if (paramNode != null) paramNode = paramNode.getPrevious();  continue;
/*     */         }  break;
/* 161 */       }  paramNode = paramNode.getPrevious();
/*     */     } 
/*     */     
/* 164 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFormattingRegion(Node paramNode) {
/* 169 */     if (!this.formatterTagsEnabled || paramNode.getStartOffset() == 0) return true; 
/* 170 */     return isFormattingRegion(paramNode.getStartOffset(), paramNode, true);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\formatter\internal\FormatControlProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */