/*    */ package net.bytebuddy.utility.privilege;
/*    */ 
/*    */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*    */ import java.lang.reflect.Method;
/*    */ import java.security.PrivilegedAction;
/*    */ import java.util.Arrays;
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
/*    */ public class GetMethodAction
/*    */   implements PrivilegedAction<Method>
/*    */ {
/*    */   private final String type;
/*    */   private final String name;
/*    */   private final Class<?>[] parameter;
/*    */   
/*    */   public GetMethodAction(String paramString1, String paramString2, Class<?>... paramVarArgs) {
/* 55 */     this.type = paramString1;
/* 56 */     this.name = paramString2;
/* 57 */     this.parameter = paramVarArgs;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @MaybeNull
/*    */   @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.")
/*    */   public Method run() {
/*    */     try {
/* 67 */       return Class.forName(this.type).getMethod(this.name, this.parameter);
/* 68 */     } catch (Exception exception) {
/* 69 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!this.type.equals(((GetMethodAction)paramObject).type) ? false : (!this.name.equals(((GetMethodAction)paramObject).name) ? false : (!!Arrays.equals((Object[])this.parameter, (Object[])((GetMethodAction)paramObject).parameter))))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return ((getClass().hashCode() * 31 + this.type.hashCode()) * 31 + this.name.hashCode()) * 31 + Arrays.hashCode((Object[])this.parameter);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\privilege\GetMethodAction.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */