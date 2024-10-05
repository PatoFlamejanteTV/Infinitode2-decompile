/*    */ package nonapi.io.github.classgraph.types;
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
/*    */ 
/*    */ 
/*    */ public class ParseException
/*    */   extends Exception
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */   
/*    */   public ParseException(Parser paramParser, String paramString) {
/* 47 */     super((paramParser == null) ? paramString : (paramString + " (" + paramParser.getPositionInfo() + ")"));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\types\ParseException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */