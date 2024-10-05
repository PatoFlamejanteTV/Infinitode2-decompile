/*     */ package com.vladsch.flexmark.ext.autolink.internal;
/*     */ import com.vladsch.flexmark.ast.AutoLink;
/*     */ import com.vladsch.flexmark.ast.MailLink;
/*     */ import com.vladsch.flexmark.ast.Text;
/*     */ import com.vladsch.flexmark.ast.TextBase;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.NodeTracker;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.Escaping;
/*     */ import com.vladsch.flexmark.util.sequence.Range;
/*     */ import com.vladsch.flexmark.util.sequence.ReplacedTextMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.b.a.a;
/*     */ import org.b.a.c;
/*     */ import org.b.a.d;
/*     */ 
/*     */ public class AutolinkNodePostProcessor extends NodePostProcessor {
/*  22 */   private static final Pattern URI_PREFIX = Pattern.compile("\\b([a-z][a-z0-9+.-]*://)(?:\\s|$)");
/*     */   
/*     */   private final Pattern ignoredLinks;
/*     */   
/*     */   private final boolean intellijDummyIdentifier;
/*  27 */   private final a linkExtractor = a.a()
/*  28 */     .a(EnumSet.of(d.a, d.c, d.b))
/*  29 */     .a();
/*     */   
/*     */   public AutolinkNodePostProcessor(Document paramDocument) {
/*  32 */     String str = (String)AutolinkExtension.IGNORE_LINKS.get((DataHolder)paramDocument);
/*  33 */     this.ignoredLinks = str.isEmpty() ? null : Pattern.compile(str);
/*  34 */     this.intellijDummyIdentifier = ((Boolean)Parser.INTELLIJ_DUMMY_IDENTIFIER.get((DataHolder)paramDocument)).booleanValue();
/*     */   }
/*     */   
/*     */   public boolean isIgnoredLinkPrefix(CharSequence paramCharSequence) {
/*  38 */     if (this.ignoredLinks != null) {
/*     */       Matcher matcher;
/*  40 */       return (matcher = this.ignoredLinks.matcher(paramCharSequence)).matches();
/*     */     } 
/*  42 */     return false;
/*     */   }
/*     */   
/*     */   private static class DummyLinkSpan implements c {
/*     */     private final d linkType;
/*     */     private final int beginIndex;
/*     */     private final int endIndex;
/*     */     
/*     */     public DummyLinkSpan(d param1d, int param1Int1, int param1Int2) {
/*  51 */       this.linkType = param1d;
/*  52 */       this.beginIndex = param1Int1;
/*  53 */       this.endIndex = param1Int2;
/*     */     }
/*     */ 
/*     */     
/*     */     public d getType() {
/*  58 */       return this.linkType;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getBeginIndex() {
/*  63 */       return this.beginIndex;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getEndIndex() {
/*  68 */       return this.endIndex;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void process(NodeTracker paramNodeTracker, Node paramNode) {
/*  75 */     if (paramNode.getAncestorOfType(new Class[] { DoNotDecorate.class, DoNotLinkDecorate.class }) != null) {
/*     */       return;
/*     */     }
/*  78 */     BasedSequence basedSequence1 = paramNode.getChars(), basedSequence2 = basedSequence1;
/*  79 */     Node node1 = paramNode;
/*  80 */     Node node2 = paramNode;
/*  81 */     ArrayList<Range> arrayList = new ArrayList();
/*     */     
/*  83 */     if (paramNode.getNext() instanceof com.vladsch.flexmark.util.ast.TypographicText || paramNode.getNext() instanceof com.vladsch.flexmark.ast.HtmlEntity)
/*     */     {
/*  85 */       if (paramNode.getNext().getChars().isContinuationOf(basedSequence1)) {
/*  86 */         Node node = paramNode.getNext();
/*     */         ArrayList<BasedSequence> arrayList2;
/*  88 */         (arrayList2 = new ArrayList<>()).add(basedSequence1);
/*     */         
/*  90 */         while ((node instanceof com.vladsch.flexmark.util.ast.TypographicText || node instanceof com.vladsch.flexmark.ast.HtmlEntity || node instanceof Text) && 
/*  91 */           node.getChars().isContinuationOf(basedSequence1) && !node.getChars().startsWith(" ") && !basedSequence1.endsWith(" ")) {
/*  92 */           basedSequence1 = node.getChars();
/*  93 */           if (node instanceof com.vladsch.flexmark.ast.HtmlEntity) {
/*  94 */             arrayList.add(Range.of(basedSequence1.getStartOffset(), basedSequence1.getEndOffset()));
/*     */           }
/*  96 */           arrayList2.add(basedSequence1);
/*  97 */           node2 = node;
/*  98 */           node = node.getNext();
/*     */         } 
/*     */         
/* 101 */         basedSequence2 = SegmentedSequence.create(paramNode.getChars(), arrayList2);
/*     */       } 
/*     */     }
/*     */     
/* 105 */     ReplacedTextMapper replacedTextMapper = new ReplacedTextMapper(basedSequence2);
/*     */     
/* 107 */     BasedSequence basedSequence3 = basedSequence2;
/*     */     
/* 109 */     if (!arrayList.isEmpty())
/*     */     {
/* 111 */       basedSequence3 = Escaping.unescapeHtml(basedSequence2, arrayList, replacedTextMapper);
/*     */     }
/*     */     
/* 114 */     basedSequence1 = Escaping.unescape(basedSequence3, replacedTextMapper);
/*     */     
/* 116 */     if (this.intellijDummyIdentifier) {
/* 117 */       basedSequence1 = Escaping.removeAll(basedSequence1, "\037", replacedTextMapper);
/*     */     }
/*     */     
/* 120 */     Iterable iterable = this.linkExtractor.a((CharSequence)basedSequence1);
/* 121 */     ArrayList<c> arrayList1 = new ArrayList();
/*     */     
/* 123 */     for (c c : iterable) {
/* 124 */       arrayList1.add(c);
/*     */     }
/*     */     
/* 127 */     Matcher matcher = URI_PREFIX.matcher((CharSequence)basedSequence1);
/* 128 */     while (matcher.find()) {
/* 129 */       int j = matcher.start(1);
/* 130 */       int k = matcher.end(1);
/*     */       
/* 132 */       if (arrayList1.isEmpty()) {
/* 133 */         arrayList1.add(new DummyLinkSpan((d)d.a, j, k)); continue;
/*     */       } 
/* 135 */       int m = arrayList1.size();
/* 136 */       boolean bool = false;
/*     */       
/* 138 */       for (byte b = 0; b < m; b++) {
/* 139 */         c c = arrayList1.get(b);
/* 140 */         if (k < c.getBeginIndex()) {
/*     */           
/* 142 */           arrayList1.add(b, new DummyLinkSpan((d)d.a, j, k));
/* 143 */           bool = true; break;
/*     */         } 
/* 145 */         if (j >= c.getBeginIndex() && k <= c.getEndIndex()) {
/*     */           
/* 147 */           bool = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 152 */       if (!bool) {
/* 153 */         arrayList1.add(new DummyLinkSpan((d)d.a, j, k));
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 158 */     int i = 0;
/*     */     boolean bool1;
/* 160 */     TextBase textBase = ((bool1 = !(paramNode.getParent() instanceof TextBase) ? true : false) || !(paramNode.getParent() instanceof TextBase)) ? null : (TextBase)paramNode.getParent();
/* 161 */     boolean bool2 = false;
/*     */     
/* 163 */     for (c c : arrayList1) {
/* 164 */       BasedSequence basedSequence = (BasedSequence)basedSequence1.subSequence(c.getBeginIndex(), c.getEndIndex()).trimEnd();
/* 165 */       if (!isIgnoredLinkPrefix((CharSequence)basedSequence)) {
/*     */         AutoLink autoLink;
/* 167 */         int j = replacedTextMapper.originalOffset(c.getBeginIndex());
/* 168 */         bool2 = true;
/*     */         
/* 170 */         if (!i && node1 != node2)
/*     */         {
/* 172 */           if (j >= paramNode.getChars().length()) {
/*     */             return;
/*     */           }
/*     */         }
/*     */ 
/*     */         
/* 178 */         if (bool1) {
/* 179 */           bool1 = false;
/* 180 */           textBase = new TextBase(basedSequence2);
/* 181 */           paramNode.insertBefore((Node)textBase);
/* 182 */           paramNodeTracker.nodeAdded((Node)textBase);
/*     */         } 
/*     */         
/* 185 */         if (j > i) {
/* 186 */           BasedSequence basedSequence5 = basedSequence2.subSequence(i, j);
/* 187 */           Text text1 = new Text(basedSequence5);
/* 188 */           if (textBase != null) {
/* 189 */             textBase.appendChild((Node)text1);
/*     */           } else {
/* 191 */             paramNode.insertBefore((Node)text1);
/*     */           } 
/* 193 */           paramNodeTracker.nodeAdded((Node)text1);
/*     */         } 
/*     */         
/* 196 */         BasedSequence basedSequence4 = basedSequence.baseSubSequence(basedSequence.getStartOffset(), basedSequence.getEndOffset());
/* 197 */         Text text = new Text(basedSequence4);
/*     */ 
/*     */         
/* 200 */         if (c.getType() == d.b) {
/*     */           MailLink mailLink;
/* 202 */           (mailLink = new MailLink()).setText(basedSequence4);
/*     */         } else {
/*     */           
/* 205 */           (autoLink = new AutoLink()).setText(basedSequence4);
/* 206 */           autoLink.setUrlChars(basedSequence4);
/*     */         } 
/*     */         
/* 209 */         autoLink.setCharsFromContent();
/* 210 */         autoLink.appendChild((Node)text);
/* 211 */         if (textBase != null) {
/* 212 */           textBase.appendChild((Node)autoLink);
/*     */         } else {
/* 214 */           paramNode.insertBefore((Node)autoLink);
/*     */         } 
/* 216 */         paramNodeTracker.nodeAddedWithChildren((Node)autoLink);
/*     */         
/* 218 */         i = replacedTextMapper.originalOffset(c.getBeginIndex() + basedSequence.length());
/*     */       } 
/*     */     } 
/* 221 */     if (i > 0) {
/* 222 */       if (node1 != node2) {
/*     */         
/* 224 */         Node node = node1.getNext();
/* 225 */         int j = paramNode.getChars().length();
/*     */         
/* 227 */         while (node != null) {
/* 228 */           if (j >= i) {
/*     */             
/* 230 */             basedSequence2 = basedSequence2.subSequence(0, j);
/*     */             
/*     */             break;
/*     */           } 
/* 234 */           j += node.getChars().length();
/* 235 */           Node node3 = node.getNext();
/* 236 */           node.unlink();
/* 237 */           paramNodeTracker.nodeRemoved(node);
/*     */           
/* 239 */           if (node != node2)
/*     */           {
/* 241 */             node = node3;
/*     */           }
/*     */         } 
/*     */       } 
/* 245 */       if (i < basedSequence2.length()) {
/* 246 */         BasedSequence basedSequence = basedSequence2.subSequence(i, basedSequence2.length());
/* 247 */         Text text = new Text(basedSequence);
/* 248 */         if (textBase != null) {
/* 249 */           textBase.appendChild((Node)text);
/*     */         } else {
/* 251 */           paramNode.insertBefore((Node)text);
/*     */         } 
/* 253 */         paramNodeTracker.nodeAdded((Node)text);
/*     */       } 
/*     */     } 
/*     */     
/* 257 */     if (bool2) {
/* 258 */       paramNode.unlink();
/* 259 */       paramNodeTracker.nodeRemoved(paramNode);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class Factory extends NodePostProcessorFactory {
/*     */     public Factory() {
/* 265 */       super(false);
/*     */ 
/*     */       
/* 268 */       addNodes(new Class[] { Text.class });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public NodePostProcessor apply(Document param1Document) {
/* 274 */       return new AutolinkNodePostProcessor(param1Document);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\autolink\internal\AutolinkNodePostProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */