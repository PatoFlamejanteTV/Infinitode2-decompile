/*    */ package com.vladsch.flexmark.ext.gfm.users.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.gfm.users.GfmUsersExtension;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import com.vladsch.flexmark.util.data.MutableDataSetter;
/*    */ 
/*    */ class GfmUsersOptions
/*    */   implements MutableDataSetter {
/*    */   public final String gitHubIssuesUrlRoot;
/*    */   public final String gitHubIssueUrlPrefix;
/*    */   public final String gitHubIssueUrlSuffix;
/*    */   public final String gitHubUserTextPrefix;
/*    */   public final String gitHubUserTextSuffix;
/*    */   
/*    */   public GfmUsersOptions(DataHolder paramDataHolder) {
/* 17 */     this.gitHubIssuesUrlRoot = (String)GfmUsersExtension.GIT_HUB_USERS_URL_ROOT.get(paramDataHolder);
/* 18 */     this.gitHubIssueUrlPrefix = (String)GfmUsersExtension.GIT_HUB_USER_URL_PREFIX.get(paramDataHolder);
/* 19 */     this.gitHubIssueUrlSuffix = (String)GfmUsersExtension.GIT_HUB_USER_URL_SUFFIX.get(paramDataHolder);
/* 20 */     this.gitHubUserTextPrefix = (String)GfmUsersExtension.GIT_HUB_USER_HTML_PREFIX.get(paramDataHolder);
/* 21 */     this.gitHubUserTextSuffix = (String)GfmUsersExtension.GIT_HUB_USER_HTML_SUFFIX.get(paramDataHolder);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MutableDataHolder setIn(MutableDataHolder paramMutableDataHolder) {
/* 27 */     paramMutableDataHolder.set(GfmUsersExtension.GIT_HUB_USERS_URL_ROOT, this.gitHubIssuesUrlRoot);
/* 28 */     paramMutableDataHolder.set(GfmUsersExtension.GIT_HUB_USER_URL_PREFIX, this.gitHubIssueUrlPrefix);
/* 29 */     paramMutableDataHolder.set(GfmUsersExtension.GIT_HUB_USER_URL_SUFFIX, this.gitHubIssueUrlSuffix);
/* 30 */     paramMutableDataHolder.set(GfmUsersExtension.GIT_HUB_USER_HTML_PREFIX, this.gitHubUserTextPrefix);
/* 31 */     paramMutableDataHolder.set(GfmUsersExtension.GIT_HUB_USER_HTML_SUFFIX, this.gitHubUserTextSuffix);
/* 32 */     return paramMutableDataHolder;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gf\\users\internal\GfmUsersOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */