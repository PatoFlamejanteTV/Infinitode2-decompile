/*    */ package com.vladsch.flexmark.ext.gfm.issues.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.gfm.issues.GfmIssuesExtension;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import com.vladsch.flexmark.util.data.MutableDataSetter;
/*    */ 
/*    */ class GfmIssuesOptions
/*    */   implements MutableDataSetter {
/*    */   public final String gitHubIssuesUrlRoot;
/*    */   public final String gitHubIssueUrlPrefix;
/*    */   public final String gitHubIssueUrlSuffix;
/*    */   public final String gitHubIssueTextPrefix;
/*    */   public final String gitHubIssueTextSuffix;
/*    */   
/*    */   public GfmIssuesOptions(DataHolder paramDataHolder) {
/* 17 */     this.gitHubIssuesUrlRoot = (String)GfmIssuesExtension.GIT_HUB_ISSUES_URL_ROOT.get(paramDataHolder);
/* 18 */     this.gitHubIssueUrlPrefix = (String)GfmIssuesExtension.GIT_HUB_ISSUE_URL_PREFIX.get(paramDataHolder);
/* 19 */     this.gitHubIssueUrlSuffix = (String)GfmIssuesExtension.GIT_HUB_ISSUE_URL_SUFFIX.get(paramDataHolder);
/* 20 */     this.gitHubIssueTextPrefix = (String)GfmIssuesExtension.GIT_HUB_ISSUE_HTML_PREFIX.get(paramDataHolder);
/* 21 */     this.gitHubIssueTextSuffix = (String)GfmIssuesExtension.GIT_HUB_ISSUE_HTML_SUFFIX.get(paramDataHolder);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MutableDataHolder setIn(MutableDataHolder paramMutableDataHolder) {
/* 27 */     paramMutableDataHolder.set(GfmIssuesExtension.GIT_HUB_ISSUES_URL_ROOT, this.gitHubIssuesUrlRoot);
/* 28 */     paramMutableDataHolder.set(GfmIssuesExtension.GIT_HUB_ISSUE_URL_PREFIX, this.gitHubIssueUrlPrefix);
/* 29 */     paramMutableDataHolder.set(GfmIssuesExtension.GIT_HUB_ISSUE_URL_SUFFIX, this.gitHubIssueUrlSuffix);
/* 30 */     paramMutableDataHolder.set(GfmIssuesExtension.GIT_HUB_ISSUE_HTML_PREFIX, this.gitHubIssueTextPrefix);
/* 31 */     paramMutableDataHolder.set(GfmIssuesExtension.GIT_HUB_ISSUE_HTML_SUFFIX, this.gitHubIssueTextSuffix);
/* 32 */     return paramMutableDataHolder;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gfm\issues\internal\GfmIssuesOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */