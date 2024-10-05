/*    */ package net.bytebuddy.utility.privilege;
/*    */ 
/*    */ import java.security.PrivilegedAction;
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.utility.nullability.MaybeNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Enhance
/*    */ public class GetSystemPropertyAction
/*    */   implements PrivilegedAction<String>
/*    */ {
/*    */   private final String key;
/*    */   
/*    */   public GetSystemPropertyAction(String paramString) {
/* 39 */     this.key = paramString;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String run() {
/* 46 */     return System.getProperty(this.key);
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.key.equals(((GetSystemPropertyAction)paramObject).key))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return getClass().hashCode() * 31 + this.key.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\privilege\GetSystemPropertyAction.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */