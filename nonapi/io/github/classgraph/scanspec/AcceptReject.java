/*     */ package nonapi.io.github.classgraph.scanspec;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Pattern;
/*     */ import nonapi.io.github.classgraph.utils.CollectionUtils;
/*     */ import nonapi.io.github.classgraph.utils.FastPathResolver;
/*     */ import nonapi.io.github.classgraph.utils.FileUtils;
/*     */ import nonapi.io.github.classgraph.utils.JarUtils;
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
/*     */ public abstract class AcceptReject
/*     */ {
/*     */   protected Set<String> accept;
/*     */   protected Set<String> reject;
/*     */   protected Set<String> acceptPrefixesSet;
/*     */   protected List<String> acceptPrefixes;
/*     */   protected List<String> rejectPrefixes;
/*     */   protected Set<String> acceptGlobs;
/*     */   protected Set<String> rejectGlobs;
/*     */   protected transient List<Pattern> acceptPatterns;
/*     */   protected transient List<Pattern> rejectPatterns;
/*     */   protected char separatorChar;
/*     */   
/*     */   public AcceptReject() {}
/*     */   
/*     */   public AcceptReject(char paramChar) {
/*  77 */     this.separatorChar = paramChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class AcceptRejectPrefix
/*     */     extends AcceptReject
/*     */   {
/*     */     public AcceptRejectPrefix() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AcceptRejectPrefix(char param1Char) {
/*  94 */       super(param1Char);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void addToAccept(String param1String) {
/* 105 */       if (param1String.contains("*")) {
/* 106 */         throw new IllegalArgumentException("Cannot use a glob wildcard here: " + param1String);
/*     */       }
/* 108 */       if (this.acceptPrefixesSet == null) {
/* 109 */         this.acceptPrefixesSet = new HashSet<>();
/*     */       }
/* 111 */       this.acceptPrefixesSet.add(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void addToReject(String param1String) {
/* 122 */       if (param1String.contains("*")) {
/* 123 */         throw new IllegalArgumentException("Cannot use a glob wildcard here: " + param1String);
/*     */       }
/* 125 */       if (this.rejectPrefixes == null) {
/* 126 */         this.rejectPrefixes = new ArrayList<>();
/*     */       }
/* 128 */       this.rejectPrefixes.add(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isAcceptedAndNotRejected(String param1String) {
/*     */       boolean bool;
/* 141 */       if (!(bool = (this.acceptPrefixes == null) ? true : false)) {
/* 142 */         for (String str : this.acceptPrefixes) {
/* 143 */           if (param1String.startsWith(str)) {
/* 144 */             bool = true;
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/* 149 */       if (!bool) {
/* 150 */         return false;
/*     */       }
/* 152 */       if (this.rejectPrefixes != null) {
/* 153 */         for (String str : this.rejectPrefixes) {
/* 154 */           if (param1String.startsWith(str)) {
/* 155 */             return false;
/*     */           }
/*     */         } 
/*     */       }
/* 159 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isAccepted(String param1String) {
/*     */       boolean bool;
/* 172 */       if (!(bool = (this.acceptPrefixes == null) ? true : false)) {
/* 173 */         for (String str : this.acceptPrefixes) {
/* 174 */           if (param1String.startsWith(str)) {
/* 175 */             bool = true;
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/* 180 */       return bool;
/*     */     }
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
/*     */     public boolean acceptHasPrefix(String param1String) {
/* 194 */       throw new IllegalArgumentException("Can only find prefixes of whole strings");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isRejected(String param1String) {
/* 206 */       if (this.rejectPrefixes != null) {
/* 207 */         for (String str : this.rejectPrefixes) {
/* 208 */           if (param1String.startsWith(str)) {
/* 209 */             return true;
/*     */           }
/*     */         } 
/*     */       }
/* 213 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class AcceptRejectWholeString
/*     */     extends AcceptReject
/*     */   {
/*     */     public AcceptRejectWholeString() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AcceptRejectWholeString(char param1Char) {
/* 231 */       super(param1Char);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void addToAccept(String param1String) {
/* 242 */       if (param1String.contains("*")) {
/* 243 */         if (this.acceptGlobs == null) {
/* 244 */           this.acceptGlobs = new HashSet<>();
/* 245 */           this.acceptPatterns = new ArrayList<>();
/*     */         } 
/* 247 */         this.acceptGlobs.add(param1String);
/* 248 */         this.acceptPatterns.add(globToPattern(param1String, true));
/*     */       } else {
/* 250 */         if (this.accept == null) {
/* 251 */           this.accept = new HashSet<>();
/*     */         }
/* 253 */         this.accept.add(param1String);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 260 */       if (this.acceptPrefixesSet == null) {
/* 261 */         this.acceptPrefixesSet = new HashSet<>();
/* 262 */         this.acceptPrefixesSet.add("");
/* 263 */         this.acceptPrefixesSet.add("/");
/*     */       } 
/* 265 */       String str = Character.toString(this.separatorChar);
/*     */       
/* 267 */       if ((param1String = param1String).contains("*")) {
/*     */         int i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 274 */         if ((i = (param1String = param1String.substring(0, param1String.indexOf('*'))).lastIndexOf(this.separatorChar)) < 0) {
/* 275 */           param1String = "";
/*     */         } else {
/* 277 */           param1String = param1String.substring(0, param1String.lastIndexOf(this.separatorChar));
/*     */         } 
/*     */       } 
/*     */       
/* 281 */       while (param1String.endsWith(str)) {
/* 282 */         param1String = param1String.substring(0, param1String.length() - 1);
/*     */       }
/*     */       
/* 285 */       for (; !param1String.isEmpty(); param1String = FileUtils.getParentDirPath(param1String, this.separatorChar)) {
/* 286 */         this.acceptPrefixesSet.add(param1String + this.separatorChar);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void addToReject(String param1String) {
/* 298 */       if (param1String.contains("*")) {
/* 299 */         if (this.rejectGlobs == null) {
/* 300 */           this.rejectGlobs = new HashSet<>();
/* 301 */           this.rejectPatterns = new ArrayList<>();
/*     */         } 
/* 303 */         this.rejectGlobs.add(param1String);
/* 304 */         this.rejectPatterns.add(globToPattern(param1String, true)); return;
/*     */       } 
/* 306 */       if (this.reject == null) {
/* 307 */         this.reject = new HashSet<>();
/*     */       }
/* 309 */       this.reject.add(param1String);
/*     */     }
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
/*     */     public boolean isAcceptedAndNotRejected(String param1String) {
/* 322 */       return (isAccepted(param1String) && !isRejected(param1String));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isAccepted(String param1String) {
/* 334 */       if ((this.accept == null && this.acceptPatterns == null) || (this.accept != null && this.accept.contains(param1String)) || AcceptReject
/* 335 */         .matchesPatternList(param1String, this.acceptPatterns)) return true;
/*     */       
/*     */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean acceptHasPrefix(String param1String) {
/* 347 */       if (this.acceptPrefixesSet == null) {
/* 348 */         return false;
/*     */       }
/* 350 */       return this.acceptPrefixesSet.contains(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isRejected(String param1String) {
/* 362 */       return ((this.reject != null && this.reject.contains(param1String)) || AcceptReject.matchesPatternList(param1String, this.rejectPatterns));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class AcceptRejectLeafname
/*     */     extends AcceptRejectWholeString
/*     */   {
/*     */     public AcceptRejectLeafname() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AcceptRejectLeafname(char param1Char) {
/* 380 */       super(param1Char);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void addToAccept(String param1String) {
/* 391 */       super.addToAccept(JarUtils.leafName(param1String));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void addToReject(String param1String) {
/* 402 */       super.addToReject(JarUtils.leafName(param1String));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isAcceptedAndNotRejected(String param1String) {
/* 414 */       return super.isAcceptedAndNotRejected(JarUtils.leafName(param1String));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isAccepted(String param1String) {
/* 426 */       return super.isAccepted(JarUtils.leafName(param1String));
/*     */     }
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
/*     */     public boolean acceptHasPrefix(String param1String) {
/* 440 */       throw new IllegalArgumentException("Can only find prefixes of whole strings");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isRejected(String param1String) {
/* 452 */       return super.isRejected(JarUtils.leafName(param1String));
/*     */     }
/*     */   }
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
/*     */   public static String normalizePath(String paramString) {
/* 516 */     paramString = FastPathResolver.resolve(paramString);
/* 517 */     while (paramString.startsWith("/")) {
/* 518 */       paramString = paramString.substring(1);
/*     */     }
/* 520 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String normalizePackageOrClassName(String paramString) {
/* 531 */     return normalizePath(paramString.replace('.', '/')).replace('/', '.');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String pathToPackageName(String paramString) {
/* 542 */     return paramString.replace('/', '.');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String packageNameToPath(String paramString) {
/* 553 */     return paramString.replace('.', '/');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String classNameToClassfilePath(String paramString) {
/* 564 */     return JarUtils.classNameToClassfilePath(paramString);
/*     */   }
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
/*     */   public static Pattern globToPattern(String paramString, boolean paramBoolean) {
/* 585 */     return Pattern.compile("^" + (paramBoolean ? paramString
/*     */         
/* 587 */         .replace(".", "\\.")
/* 588 */         .replace("*", ".*") : paramString
/* 589 */         .replace(".", "\\.")
/* 590 */         .replace("*", "[^/]*")
/* 591 */         .replace("[^/]*[^/]*", ".*")
/* 592 */         .replace('?', '.')) + "$");
/*     */   }
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
/*     */   private static boolean matchesPatternList(String paramString, List<Pattern> paramList) {
/* 607 */     if (paramList != null) {
/* 608 */       for (Iterator<Pattern> iterator = paramList.iterator(); iterator.hasNext();) {
/* 609 */         if ((pattern = iterator.next()).matcher(paramString).matches()) {
/* 610 */           return true;
/*     */         }
/*     */       } 
/*     */     }
/* 614 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean acceptIsEmpty() {
/* 623 */     return (this.accept == null && this.acceptPrefixes == null && this.acceptGlobs == null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean rejectIsEmpty() {
/* 632 */     return (this.reject == null && this.rejectPrefixes == null && this.rejectGlobs == null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean acceptAndRejectAreEmpty() {
/* 641 */     return (acceptIsEmpty() && rejectIsEmpty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSpecificallyAcceptedAndNotRejected(String paramString) {
/* 653 */     return (!acceptIsEmpty() && isAcceptedAndNotRejected(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSpecificallyAccepted(String paramString) {
/* 665 */     return (!acceptIsEmpty() && isAccepted(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   void sortPrefixes() {
/* 670 */     if (this.acceptPrefixesSet != null) {
/* 671 */       this.acceptPrefixes = new ArrayList<>(this.acceptPrefixesSet);
/*     */     }
/* 673 */     if (this.acceptPrefixes != null) {
/* 674 */       CollectionUtils.sortIfNotEmpty(this.acceptPrefixes);
/*     */     }
/* 676 */     if (this.rejectPrefixes != null) {
/* 677 */       CollectionUtils.sortIfNotEmpty(this.rejectPrefixes);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void quoteList(Collection<String> paramCollection, StringBuilder paramStringBuilder) {
/* 690 */     paramStringBuilder.append('[');
/* 691 */     boolean bool = true;
/* 692 */     for (String str : paramCollection) {
/* 693 */       if (bool) {
/* 694 */         bool = false;
/*     */       } else {
/* 696 */         paramStringBuilder.append(", ");
/*     */       } 
/* 698 */       paramStringBuilder.append('"');
/* 699 */       for (byte b = 0; b < str.length(); b++) {
/*     */         char c;
/* 701 */         if ((c = str.charAt(b)) == '"') {
/* 702 */           paramStringBuilder.append("\\\"");
/*     */         } else {
/* 704 */           paramStringBuilder.append(c);
/*     */         } 
/*     */       } 
/* 707 */       paramStringBuilder.append('"');
/*     */     } 
/* 709 */     paramStringBuilder.append(']');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 717 */     StringBuilder stringBuilder = new StringBuilder();
/* 718 */     if (this.accept != null) {
/* 719 */       stringBuilder.append("accept: ");
/* 720 */       quoteList(this.accept, stringBuilder);
/*     */     } 
/* 722 */     if (this.acceptPrefixes != null) {
/* 723 */       if (stringBuilder.length() > 0) {
/* 724 */         stringBuilder.append("; ");
/*     */       }
/* 726 */       stringBuilder.append("acceptPrefixes: ");
/* 727 */       quoteList(this.acceptPrefixes, stringBuilder);
/*     */     } 
/* 729 */     if (this.acceptGlobs != null) {
/* 730 */       if (stringBuilder.length() > 0) {
/* 731 */         stringBuilder.append("; ");
/*     */       }
/* 733 */       stringBuilder.append("acceptGlobs: ");
/* 734 */       quoteList(this.acceptGlobs, stringBuilder);
/*     */     } 
/* 736 */     if (this.reject != null) {
/* 737 */       if (stringBuilder.length() > 0) {
/* 738 */         stringBuilder.append("; ");
/*     */       }
/* 740 */       stringBuilder.append("reject: ");
/* 741 */       quoteList(this.reject, stringBuilder);
/*     */     } 
/* 743 */     if (this.rejectPrefixes != null) {
/* 744 */       if (stringBuilder.length() > 0) {
/* 745 */         stringBuilder.append("; ");
/*     */       }
/* 747 */       stringBuilder.append("rejectPrefixes: ");
/* 748 */       quoteList(this.rejectPrefixes, stringBuilder);
/*     */     } 
/* 750 */     if (this.rejectGlobs != null) {
/* 751 */       if (stringBuilder.length() > 0) {
/* 752 */         stringBuilder.append("; ");
/*     */       }
/* 754 */       stringBuilder.append("rejectGlobs: ");
/* 755 */       quoteList(this.rejectGlobs, stringBuilder);
/*     */     } 
/* 757 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public abstract void addToAccept(String paramString);
/*     */   
/*     */   public abstract void addToReject(String paramString);
/*     */   
/*     */   public abstract boolean isAcceptedAndNotRejected(String paramString);
/*     */   
/*     */   public abstract boolean isAccepted(String paramString);
/*     */   
/*     */   public abstract boolean acceptHasPrefix(String paramString);
/*     */   
/*     */   public abstract boolean isRejected(String paramString);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\scanspec\AcceptReject.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */