/*     */ package com.vladsch.flexmark.profile.pegdown;
/*     */ 
/*     */ import com.vladsch.flexmark.ext.abbreviation.AbbreviationExtension;
/*     */ import com.vladsch.flexmark.ext.anchorlink.AnchorLinkExtension;
/*     */ import com.vladsch.flexmark.ext.autolink.AutolinkExtension;
/*     */ import com.vladsch.flexmark.ext.definition.DefinitionExtension;
/*     */ import com.vladsch.flexmark.ext.escaped.character.EscapedCharacterExtension;
/*     */ import com.vladsch.flexmark.ext.footnotes.FootnoteExtension;
/*     */ import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
/*     */ import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughSubscriptExtension;
/*     */ import com.vladsch.flexmark.ext.gfm.strikethrough.SubscriptExtension;
/*     */ import com.vladsch.flexmark.ext.gfm.tasklist.TaskListExtension;
/*     */ import com.vladsch.flexmark.ext.ins.InsExtension;
/*     */ import com.vladsch.flexmark.ext.superscript.SuperscriptExtension;
/*     */ import com.vladsch.flexmark.ext.tables.TablesExtension;
/*     */ import com.vladsch.flexmark.ext.toc.SimTocExtension;
/*     */ import com.vladsch.flexmark.ext.toc.TocExtension;
/*     */ import com.vladsch.flexmark.ext.toc.internal.TocOptions;
/*     */ import com.vladsch.flexmark.ext.typographic.TypographicExtension;
/*     */ import com.vladsch.flexmark.ext.wikilink.WikiLinkExtension;
/*     */ import com.vladsch.flexmark.html.HtmlRenderer;
/*     */ import com.vladsch.flexmark.parser.Parser;
/*     */ import com.vladsch.flexmark.parser.ParserEmulationProfile;
/*     */ import com.vladsch.flexmark.util.ast.KeepType;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.DataKey;
/*     */ import com.vladsch.flexmark.util.data.MutableDataSet;
/*     */ import com.vladsch.flexmark.util.data.MutableDataSetter;
/*     */ import com.vladsch.flexmark.util.misc.Extension;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ public class PegdownOptionsAdapter
/*     */ {
/*  36 */   public static final DataKey<Integer> PEGDOWN_EXTENSIONS = ParserEmulationProfile.PEGDOWN_EXTENSIONS;
/*     */   
/*     */   private final MutableDataSet myOptions;
/*  39 */   private int myPegdownExtensions = 0;
/*     */   private boolean myIsUpdateNeeded = false;
/*     */   
/*     */   public PegdownOptionsAdapter() {
/*  43 */     this.myOptions = new MutableDataSet();
/*     */   }
/*     */   
/*     */   public PegdownOptionsAdapter(DataHolder paramDataHolder) {
/*  47 */     this.myOptions = new MutableDataSet(paramDataHolder);
/*     */   }
/*     */   
/*     */   public PegdownOptionsAdapter(int paramInt) {
/*  51 */     this.myOptions = new MutableDataSet();
/*  52 */     this.myPegdownExtensions = paramInt;
/*  53 */     this.myIsUpdateNeeded = true;
/*     */   }
/*     */   
/*     */   public static DataHolder flexmarkOptions(int paramInt, Extension... paramVarArgs) {
/*  57 */     return flexmarkOptions(false, paramInt, paramVarArgs);
/*     */   }
/*     */   
/*     */   public static DataHolder flexmarkOptions(boolean paramBoolean, int paramInt, Extension... paramVarArgs) {
/*     */     PegdownOptionsAdapter pegdownOptionsAdapter;
/*  62 */     return (pegdownOptionsAdapter = new PegdownOptionsAdapter(paramInt)).getFlexmarkOptions(paramBoolean, paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean haveAnyExtensions(int paramInt) {
/*  72 */     return ParserEmulationProfile.haveAny(this.myPegdownExtensions, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean haveAllExtensions(int paramInt) {
/*  82 */     return ParserEmulationProfile.haveAll(this.myPegdownExtensions, paramInt);
/*     */   }
/*     */   
/*     */   public DataHolder getFlexmarkOptions(Extension... paramVarArgs) {
/*  86 */     return getFlexmarkOptions(false, paramVarArgs);
/*     */   }
/*     */   
/*     */   public DataHolder getFlexmarkOptions(boolean paramBoolean, Extension... paramVarArgs) {
/*  90 */     if (this.myIsUpdateNeeded) {
/*  91 */       this.myIsUpdateNeeded = false;
/*  92 */       MutableDataSet mutableDataSet = this.myOptions;
/*  93 */       ArrayList<EscapedCharacterExtension> arrayList = new ArrayList(Arrays.asList((Object[])paramVarArgs));
/*     */       
/*  95 */       mutableDataSet.clear();
/*     */ 
/*     */       
/*  98 */       mutableDataSet.set(ParserEmulationProfile.PEGDOWN_EXTENSIONS, Integer.valueOf(this.myPegdownExtensions));
/*     */ 
/*     */       
/* 101 */       mutableDataSet.setFrom(paramBoolean ? (MutableDataSetter)ParserEmulationProfile.PEGDOWN_STRICT : (MutableDataSetter)ParserEmulationProfile.PEGDOWN);
/*     */       
/* 103 */       mutableDataSet.set(HtmlRenderer.SUPPRESS_HTML_BLOCKS, Boolean.valueOf(haveAnyExtensions(65536)));
/* 104 */       mutableDataSet.set(HtmlRenderer.SUPPRESS_INLINE_HTML, Boolean.valueOf(haveAnyExtensions(131072)));
/*     */ 
/*     */       
/* 107 */       arrayList.add(EscapedCharacterExtension.create());
/*     */       
/* 109 */       if (haveAnyExtensions(4)) {
/* 110 */         arrayList.add(AbbreviationExtension.create());
/* 111 */         mutableDataSet.set(AbbreviationExtension.ABBREVIATIONS_KEEP, KeepType.LAST);
/*     */       } 
/*     */       
/* 114 */       if (haveAnyExtensions(4195328)) {
/* 115 */         mutableDataSet.set(HtmlRenderer.RENDER_HEADER_ID, Boolean.FALSE);
/* 116 */         arrayList.add(AnchorLinkExtension.create());
/* 117 */         if (haveAnyExtensions(4194304)) {
/* 118 */           mutableDataSet.set(AnchorLinkExtension.ANCHORLINKS_WRAP_TEXT, Boolean.FALSE);
/* 119 */         } else if (haveAnyExtensions(1024)) {
/* 120 */           mutableDataSet.set(AnchorLinkExtension.ANCHORLINKS_WRAP_TEXT, Boolean.TRUE);
/*     */         } 
/*     */       } 
/*     */       
/* 124 */       if (haveAnyExtensions(16)) {
/* 125 */         arrayList.add(AutolinkExtension.create());
/*     */       }
/*     */       
/* 128 */       if (haveAnyExtensions(64))
/*     */       {
/* 130 */         arrayList.add(DefinitionExtension.create());
/*     */       }
/*     */       
/* 133 */       if (!haveAnyExtensions(128)) {
/*     */         
/* 135 */         mutableDataSet.set(Parser.FENCED_CODE_BLOCK_PARSER, Boolean.FALSE);
/*     */       } else {
/* 137 */         mutableDataSet.set(Parser.MATCH_CLOSING_FENCE_CHARACTERS, Boolean.FALSE);
/*     */       } 
/*     */       
/* 140 */       if (haveAnyExtensions(268435456))
/*     */       {
/* 142 */         mutableDataSet.set(Parser.LISTS_LOOSE_WHEN_HAS_NON_LIST_CHILDREN, Boolean.TRUE);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 147 */       if (haveAnyExtensions(8)) {
/* 148 */         mutableDataSet.set(HtmlRenderer.SOFT_BREAK, "<br />\n");
/* 149 */         mutableDataSet.set(HtmlRenderer.HARD_BREAK, "<br />\n");
/*     */       } 
/*     */       
/* 152 */       if (!haveAnyExtensions(262144)) {
/* 153 */         mutableDataSet.set(Parser.HEADING_NO_ATX_SPACE, Boolean.TRUE);
/*     */       }
/*     */       
/* 156 */       if (haveAnyExtensions(3)) {
/*     */         
/* 158 */         arrayList.add(TypographicExtension.create());
/* 159 */         mutableDataSet.set(TypographicExtension.ENABLE_SMARTS, Boolean.valueOf(haveAnyExtensions(1)));
/* 160 */         mutableDataSet.set(TypographicExtension.ENABLE_QUOTES, Boolean.valueOf(haveAnyExtensions(2)));
/*     */       } 
/*     */       
/* 163 */       if (!haveAnyExtensions(1048576)) {
/* 164 */         mutableDataSet.set(Parser.THEMATIC_BREAK_RELAXED_START, Boolean.FALSE);
/*     */       }
/*     */       
/* 167 */       if (haveAnyExtensions(32)) {
/* 168 */         arrayList.add(TablesExtension.create());
/* 169 */         mutableDataSet.set(TablesExtension.TRIM_CELL_WHITESPACE, Boolean.FALSE);
/* 170 */         mutableDataSet.set(TablesExtension.HEADER_SEPARATOR_COLUMN_MATCH, Boolean.FALSE);
/*     */       } 
/*     */       
/* 173 */       if (haveAnyExtensions(2097152)) {
/* 174 */         arrayList.add(TaskListExtension.create());
/*     */       }
/*     */       
/* 177 */       if (haveAnyExtensions(256)) {
/* 178 */         arrayList.add(WikiLinkExtension.create());
/*     */         
/* 180 */         mutableDataSet.set(WikiLinkExtension.LINK_FIRST_SYNTAX, Boolean.FALSE);
/* 181 */         mutableDataSet.set(WikiLinkExtension.ALLOW_ANCHORS, Boolean.TRUE);
/*     */       } 
/*     */       
/* 184 */       if (haveAnyExtensions(524288) && haveAnyExtensions(512)) {
/*     */         
/* 186 */         arrayList.add(StrikethroughSubscriptExtension.create());
/* 187 */       } else if (haveAnyExtensions(512)) {
/* 188 */         arrayList.add(StrikethroughExtension.create());
/* 189 */       } else if (haveAnyExtensions(524288)) {
/* 190 */         arrayList.add(SubscriptExtension.create());
/*     */       } 
/*     */       
/* 193 */       if (haveAnyExtensions(134217728)) {
/* 194 */         arrayList.add(SuperscriptExtension.create());
/*     */       }
/*     */       
/* 197 */       if (haveAnyExtensions(1073741824)) {
/* 198 */         arrayList.add(InsExtension.create());
/*     */       }
/*     */       
/* 201 */       if (haveAnyExtensions(33554432)) {
/* 202 */         arrayList.add(SimTocExtension.create());
/* 203 */         mutableDataSet.set(TocExtension.BLANK_LINE_SPACER, Boolean.TRUE);
/*     */         
/* 205 */         arrayList.add(TocExtension.create());
/* 206 */         mutableDataSet.set(TocExtension.LEVELS, Integer.valueOf(TocOptions.getLevels(new int[] { 2, 3 })));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 214 */       if (haveAnyExtensions(67108864)) {
/* 215 */         mutableDataSet.set(Parser.PARSE_MULTI_LINE_IMAGE_URLS, Boolean.TRUE);
/*     */       }
/*     */       
/* 218 */       if (haveAnyExtensions(16777216)) {
/* 219 */         arrayList.add(FootnoteExtension.create());
/* 220 */         mutableDataSet.set(FootnoteExtension.FOOTNOTES_KEEP, KeepType.LAST);
/*     */       } 
/*     */       
/* 223 */       this.myOptions.set(Parser.EXTENSIONS, arrayList);
/*     */     } 
/*     */     
/* 226 */     return (DataHolder)this.myOptions.toImmutable();
/*     */   }
/*     */   
/*     */   public PegdownOptionsAdapter setPegdownExtensions(int paramInt) {
/* 230 */     this.myPegdownExtensions = paramInt;
/* 231 */     this.myIsUpdateNeeded = true;
/* 232 */     return this;
/*     */   }
/*     */   
/*     */   public PegdownOptionsAdapter addPegdownExtensions(int paramInt) {
/* 236 */     this.myPegdownExtensions |= paramInt;
/* 237 */     this.myIsUpdateNeeded = true;
/* 238 */     return this;
/*     */   }
/*     */   
/*     */   public PegdownOptionsAdapter removePegdownExtensions(int paramInt) {
/* 242 */     this.myPegdownExtensions &= paramInt ^ 0xFFFFFFFF;
/* 243 */     this.myIsUpdateNeeded = true;
/* 244 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\profile\pegdown\PegdownOptionsAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */