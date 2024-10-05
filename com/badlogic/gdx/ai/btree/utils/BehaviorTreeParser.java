/*     */ package com.badlogic.gdx.ai.btree.utils;
/*     */ 
/*     */ import com.badlogic.gdx.ai.GdxAI;
/*     */ import com.badlogic.gdx.ai.btree.BehaviorTree;
/*     */ import com.badlogic.gdx.ai.btree.Task;
/*     */ import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
/*     */ import com.badlogic.gdx.ai.btree.annotation.TaskConstraint;
/*     */ import com.badlogic.gdx.ai.btree.branch.DynamicGuardSelector;
/*     */ import com.badlogic.gdx.ai.btree.branch.Parallel;
/*     */ import com.badlogic.gdx.ai.btree.branch.RandomSelector;
/*     */ import com.badlogic.gdx.ai.btree.branch.RandomSequence;
/*     */ import com.badlogic.gdx.ai.btree.branch.Selector;
/*     */ import com.badlogic.gdx.ai.btree.branch.Sequence;
/*     */ import com.badlogic.gdx.ai.btree.decorator.AlwaysFail;
/*     */ import com.badlogic.gdx.ai.btree.decorator.AlwaysSucceed;
/*     */ import com.badlogic.gdx.ai.btree.decorator.Include;
/*     */ import com.badlogic.gdx.ai.btree.decorator.Invert;
/*     */ import com.badlogic.gdx.ai.btree.decorator.Random;
/*     */ import com.badlogic.gdx.ai.btree.decorator.Repeat;
/*     */ import com.badlogic.gdx.ai.btree.decorator.SemaphoreGuard;
/*     */ import com.badlogic.gdx.ai.btree.decorator.UntilFail;
/*     */ import com.badlogic.gdx.ai.btree.decorator.UntilSuccess;
/*     */ import com.badlogic.gdx.ai.btree.leaf.Failure;
/*     */ import com.badlogic.gdx.ai.btree.leaf.Success;
/*     */ import com.badlogic.gdx.ai.btree.leaf.Wait;
/*     */ import com.badlogic.gdx.ai.utils.random.Distribution;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.badlogic.gdx.utils.reflect.Annotation;
/*     */ import com.badlogic.gdx.utils.reflect.ClassReflection;
/*     */ import com.badlogic.gdx.utils.reflect.Field;
/*     */ import com.badlogic.gdx.utils.reflect.ReflectionException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
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
/*     */ public class BehaviorTreeParser<E>
/*     */ {
/*     */   public static final int DEBUG_NONE = 0;
/*     */   public static final int DEBUG_LOW = 1;
/*     */   public static final int DEBUG_HIGH = 2;
/*     */   private static final String TAG = "BehaviorTreeParser";
/*     */   public int debugLevel;
/*     */   public DistributionAdapters distributionAdapters;
/*     */   private DefaultBehaviorTreeReader<E> btReader;
/*     */   
/*     */   public BehaviorTreeParser() {
/*  76 */     this(0);
/*     */   }
/*     */   
/*     */   public BehaviorTreeParser(DistributionAdapters paramDistributionAdapters) {
/*  80 */     this(paramDistributionAdapters, 0);
/*     */   }
/*     */   
/*     */   public BehaviorTreeParser(int paramInt) {
/*  84 */     this(new DistributionAdapters(), paramInt);
/*     */   }
/*     */   
/*     */   public BehaviorTreeParser(DistributionAdapters paramDistributionAdapters, int paramInt) {
/*  88 */     this(paramDistributionAdapters, paramInt, null);
/*     */   }
/*     */   
/*     */   public BehaviorTreeParser(DistributionAdapters paramDistributionAdapters, int paramInt, DefaultBehaviorTreeReader<E> paramDefaultBehaviorTreeReader) {
/*  92 */     this.distributionAdapters = paramDistributionAdapters;
/*  93 */     this.debugLevel = paramInt;
/*  94 */     this.btReader = (paramDefaultBehaviorTreeReader == null) ? new DefaultBehaviorTreeReader<>() : paramDefaultBehaviorTreeReader;
/*  95 */     this.btReader.setParser(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BehaviorTree<E> parse(String paramString, E paramE) {
/* 104 */     this.btReader.parse(paramString);
/* 105 */     return createBehaviorTree(this.btReader.root, paramE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BehaviorTree<E> parse(InputStream paramInputStream, E paramE) {
/* 114 */     this.btReader.parse(paramInputStream);
/* 115 */     return createBehaviorTree(this.btReader.root, paramE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BehaviorTree<E> parse(FileHandle paramFileHandle, E paramE) {
/* 124 */     this.btReader.parse(paramFileHandle);
/* 125 */     return createBehaviorTree(this.btReader.root, paramE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BehaviorTree<E> parse(Reader paramReader, E paramE) {
/* 134 */     this.btReader.parse(paramReader);
/* 135 */     return createBehaviorTree(this.btReader.root, paramE);
/*     */   }
/*     */   
/*     */   protected BehaviorTree<E> createBehaviorTree(Task<E> paramTask, E paramE) {
/* 139 */     if (this.debugLevel > 1) printTree(paramTask, 0); 
/* 140 */     return new BehaviorTree(paramTask, paramE);
/*     */   }
/*     */   protected static <E> void printTree(Task<E> paramTask, int paramInt) {
/*     */     byte b;
/* 144 */     for (b = 0; b < paramInt; b++)
/* 145 */       System.out.print(' '); 
/* 146 */     if (paramTask.getGuard() != null) {
/* 147 */       System.out.println("Guard");
/* 148 */       paramInt += 2;
/* 149 */       printTree(paramTask.getGuard(), paramInt);
/* 150 */       for (b = 0; b < paramInt; b++)
/* 151 */         System.out.print(' '); 
/*     */     } 
/* 153 */     System.out.println(paramTask.getClass().getSimpleName());
/* 154 */     for (b = 0; b < paramTask.getChildCount(); b++)
/* 155 */       printTree(paramTask.getChild(b), paramInt + 2); 
/*     */   }
/*     */   
/*     */   public static class DefaultBehaviorTreeReader<E>
/*     */     extends BehaviorTreeReader
/*     */   {
/* 161 */     private static final ObjectMap<String, String> DEFAULT_IMPORTS = new ObjectMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected BehaviorTreeParser<E> btParser;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/*     */       Class[] arrayOfClass;
/*     */       byte b;
/* 183 */       for (arrayOfClass = arrayOfClass = new Class[] { AlwaysFail.class, AlwaysSucceed.class, DynamicGuardSelector.class, Failure.class, Include.class, Invert.class, Parallel.class, Random.class, RandomSelector.class, RandomSequence.class, Repeat.class, Selector.class, SemaphoreGuard.class, Sequence.class, Success.class, UntilFail.class, UntilSuccess.class, Wait.class }, b = 0; b < 18; b++) {
/* 184 */         Class<?> clazz; String str2 = (clazz = arrayOfClass[b]).getName();
/* 185 */         String str1 = clazz.getSimpleName();
/* 186 */         str1 = Character.toLowerCase(str1.charAt(0)) + ((str1.length() > 1) ? str1.substring(1) : "");
/* 187 */         DEFAULT_IMPORTS.put(str1, str2);
/*     */       } 
/*     */     }
/*     */     
/*     */     enum Statement {
/* 192 */       Import("import")
/*     */       {
/*     */         protected final <E> void enter(BehaviorTreeParser.DefaultBehaviorTreeReader<E> param3DefaultBehaviorTreeReader, String param3String, boolean param3Boolean) {}
/*     */ 
/*     */ 
/*     */         
/*     */         protected final <E> boolean attribute(BehaviorTreeParser.DefaultBehaviorTreeReader<E> param3DefaultBehaviorTreeReader, String param3String, Object param3Object) {
/* 199 */           if (!(param3Object instanceof String)) param3DefaultBehaviorTreeReader.throwAttributeTypeException(this.name, param3String, "String"); 
/* 200 */           param3DefaultBehaviorTreeReader.addImport(param3String, (String)param3Object);
/* 201 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected final <E> void exit(BehaviorTreeParser.DefaultBehaviorTreeReader<E> param3DefaultBehaviorTreeReader) {}
/*     */       },
/* 209 */       Subtree("subtree")
/*     */       {
/*     */         protected final <E> void enter(BehaviorTreeParser.DefaultBehaviorTreeReader<E> param3DefaultBehaviorTreeReader, String param3String, boolean param3Boolean) {}
/*     */ 
/*     */ 
/*     */         
/*     */         protected final <E> boolean attribute(BehaviorTreeParser.DefaultBehaviorTreeReader<E> param3DefaultBehaviorTreeReader, String param3String, Object param3Object) {
/* 216 */           if (!param3String.equals("name")) param3DefaultBehaviorTreeReader.throwAttributeNameException(this.name, param3String, "name"); 
/* 217 */           if (!(param3Object instanceof String)) param3DefaultBehaviorTreeReader.throwAttributeTypeException(this.name, param3String, "String"); 
/* 218 */           if ("".equals(param3Object)) throw new GdxRuntimeException(this.name + ": the name connot be empty"); 
/* 219 */           if (param3DefaultBehaviorTreeReader.subtreeName != null)
/* 220 */             throw new GdxRuntimeException(this.name + ": the name has been already specified"); 
/* 221 */           param3DefaultBehaviorTreeReader.subtreeName = (String)param3Object;
/* 222 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         protected final <E> void exit(BehaviorTreeParser.DefaultBehaviorTreeReader<E> param3DefaultBehaviorTreeReader) {
/* 227 */           if (param3DefaultBehaviorTreeReader.subtreeName == null)
/* 228 */             throw new GdxRuntimeException(this.name + ": the name has not been specified"); 
/* 229 */           param3DefaultBehaviorTreeReader.switchToNewTree(param3DefaultBehaviorTreeReader.subtreeName);
/* 230 */           param3DefaultBehaviorTreeReader.subtreeName = null;
/*     */         }
/*     */       },
/* 233 */       Root("root")
/*     */       {
/*     */         protected final <E> void enter(BehaviorTreeParser.DefaultBehaviorTreeReader<E> param3DefaultBehaviorTreeReader, String param3String, boolean param3Boolean) {
/* 236 */           param3DefaultBehaviorTreeReader.subtreeName = "";
/*     */         }
/*     */ 
/*     */         
/*     */         protected final <E> boolean attribute(BehaviorTreeParser.DefaultBehaviorTreeReader<E> param3DefaultBehaviorTreeReader, String param3String, Object param3Object) {
/* 241 */           param3DefaultBehaviorTreeReader.throwAttributeTypeException(this.name, param3String, (String)null);
/* 242 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         protected final <E> void exit(BehaviorTreeParser.DefaultBehaviorTreeReader<E> param3DefaultBehaviorTreeReader) {
/* 247 */           param3DefaultBehaviorTreeReader.switchToNewTree(param3DefaultBehaviorTreeReader.subtreeName);
/* 248 */           param3DefaultBehaviorTreeReader.subtreeName = null;
/*     */         }
/*     */       },
/* 251 */       TreeTask(null)
/*     */       {
/*     */         protected final <E> void enter(BehaviorTreeParser.DefaultBehaviorTreeReader<E> param3DefaultBehaviorTreeReader, String param3String, boolean param3Boolean)
/*     */         {
/* 255 */           if (param3DefaultBehaviorTreeReader.currentTree == null) {
/* 256 */             param3DefaultBehaviorTreeReader.switchToNewTree("");
/* 257 */             param3DefaultBehaviorTreeReader.subtreeName = null;
/*     */           } 
/*     */           
/* 260 */           param3DefaultBehaviorTreeReader.openTask(param3String, param3Boolean);
/*     */         }
/*     */ 
/*     */         
/*     */         protected final <E> boolean attribute(BehaviorTreeParser.DefaultBehaviorTreeReader<E> param3DefaultBehaviorTreeReader, String param3String, Object param3Object) {
/*     */           BehaviorTreeParser.DefaultBehaviorTreeReader.StackedTask<E> stackedTask;
/*     */           BehaviorTreeParser.DefaultBehaviorTreeReader.AttrInfo attrInfo;
/* 267 */           if ((attrInfo = (BehaviorTreeParser.DefaultBehaviorTreeReader.AttrInfo)(stackedTask = param3DefaultBehaviorTreeReader.getCurrentTask()).metadata.attributes.get(param3String)) == null) return false; 
/*     */           boolean bool;
/* 269 */           if (!(bool = param3DefaultBehaviorTreeReader.encounteredAttributes.add(param3String))) throw param3DefaultBehaviorTreeReader.stackedTaskException(stackedTask, "attribute '" + param3String + "' specified more than once"); 
/* 270 */           Field field = param3DefaultBehaviorTreeReader.getField(stackedTask.task.getClass(), attrInfo.fieldName);
/* 271 */           param3DefaultBehaviorTreeReader.setField(field, stackedTask.task, param3Object);
/* 272 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         protected final <E> void exit(BehaviorTreeParser.DefaultBehaviorTreeReader<E> param3DefaultBehaviorTreeReader) {
/* 277 */           if (!param3DefaultBehaviorTreeReader.isSubtreeRef) {
/* 278 */             param3DefaultBehaviorTreeReader.checkRequiredAttributes(param3DefaultBehaviorTreeReader.getCurrentTask());
/* 279 */             param3DefaultBehaviorTreeReader.encounteredAttributes.clear();
/*     */           } 
/*     */         }
/*     */       };
/*     */       
/*     */       String name;
/*     */       
/*     */       Statement(String param2String1) {
/* 287 */         this.name = param2String1;
/*     */       }
/*     */ 
/*     */       
/*     */       protected abstract <E> void enter(BehaviorTreeParser.DefaultBehaviorTreeReader<E> param2DefaultBehaviorTreeReader, String param2String, boolean param2Boolean);
/*     */ 
/*     */       
/*     */       protected abstract <E> boolean attribute(BehaviorTreeParser.DefaultBehaviorTreeReader<E> param2DefaultBehaviorTreeReader, String param2String, Object param2Object);
/*     */       
/*     */       protected abstract <E> void exit(BehaviorTreeParser.DefaultBehaviorTreeReader<E> param2DefaultBehaviorTreeReader);
/*     */     }
/* 298 */     ObjectMap<Class<?>, Metadata> metadataCache = new ObjectMap(); Task<E> root; String subtreeName; Statement statement; private int indent; ObjectMap<String, String> userImports; ObjectMap<String, Subtree<E>> subtrees; Subtree<E> currentTree; int currentTreeStartIndent; int currentDepth; int step; boolean isSubtreeRef;
/*     */     protected StackedTask<E> prevTask;
/*     */     protected StackedTask<E> guardChain;
/*     */     protected Array<StackedTask<E>> stack;
/*     */     ObjectSet<String> encounteredAttributes;
/*     */     boolean isGuard;
/*     */     
/*     */     public DefaultBehaviorTreeReader() {
/* 306 */       this(false);
/*     */     }
/*     */     
/*     */     public DefaultBehaviorTreeReader(boolean param1Boolean) {
/* 310 */       super(param1Boolean);
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
/* 641 */       this.userImports = new ObjectMap();
/*     */       
/* 643 */       this.subtrees = new ObjectMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 652 */       this.stack = new Array();
/* 653 */       this.encounteredAttributes = new ObjectSet();
/*     */     } public BehaviorTreeParser<E> getParser() { return this.btParser; } public void setParser(BehaviorTreeParser<E> param1BehaviorTreeParser) { this.btParser = param1BehaviorTreeParser; } public void parse(char[] param1ArrayOfchar, int param1Int1, int param1Int2) { this.debug = (this.btParser.debugLevel > 0); this.root = null; clear(); super.parse(param1ArrayOfchar, param1Int1, param1Int2); popAndCheckMinChildren(0); Subtree subtree; if ((subtree = (Subtree)this.subtrees.get("")) == null) throw new GdxRuntimeException("Missing root tree");  this.root = subtree.rootTask; if (this.root == null) throw new GdxRuntimeException("The tree must have at least the root task");  clear(); } protected void startLine(int param1Int) { if (this.btParser.debugLevel > 1) GdxAI.getLogger().debug("BehaviorTreeParser", this.lineNumber + ": <" + param1Int + ">");  this.indent = param1Int; } private Statement checkStatement(String param1String) { if (param1String.equals(Statement.Import.name)) return Statement.Import;  if (param1String.equals(Statement.Subtree.name)) return Statement.Subtree;  if (param1String.equals(Statement.Root.name)) return Statement.Root;  return Statement.TreeTask; } protected void startStatement(String param1String, boolean param1Boolean1, boolean param1Boolean2) { if (this.btParser.debugLevel > 1) GdxAI.getLogger().debug("BehaviorTreeParser", (param1Boolean2 ? " guard" : " task") + " name '" + param1String + "'");  this.isSubtreeRef = param1Boolean1; this.statement = param1Boolean1 ? Statement.TreeTask : checkStatement(param1String); if (param1Boolean2 && this.statement != Statement.TreeTask) throw new GdxRuntimeException(param1String + ": only tree's tasks can be guarded");  this.statement.enter(this, param1String, param1Boolean2); } protected void attribute(String param1String, Object param1Object) { if (this.btParser.debugLevel > 1) GdxAI.getLogger().debug("BehaviorTreeParser", this.lineNumber + ": attribute '" + param1String + " : " + param1Object + "'");  boolean bool; if (!(bool = this.statement.attribute(this, param1String, param1Object))) { if (this.statement == Statement.TreeTask) throw stackedTaskException(getCurrentTask(), "unknown attribute '" + param1String + "'");  throw new GdxRuntimeException(this.statement.name + ": unknown attribute '" + param1String + "'"); }  } private Field getField(Class<?> param1Class, String param1String) { try { return ClassReflection.getField(param1Class, param1String); } catch (ReflectionException reflectionException) { throw new GdxRuntimeException(reflectionException); }  }
/*     */     private void setField(Field param1Field, Task<E> param1Task, Object param1Object) { param1Field.setAccessible(true); if ((param1Object = castValue(param1Field, param1Object)) == null) throwAttributeTypeException((getCurrentTask()).name, param1Field.getName(), param1Field.getType().getSimpleName());  try { param1Field.set(param1Task, param1Object); return; } catch (ReflectionException reflectionException) { throw new GdxRuntimeException(reflectionException); }  }
/*     */     protected Object castValue(Field param1Field, Object param1Object) { Object object; Class<int> clazz = param1Field.getType(); Integer integer = null; if (param1Object instanceof Number) { Number number = (Number)param1Object; if (clazz == int.class || clazz == Integer.class) { integer = Integer.valueOf(number.intValue()); } else if (clazz == float.class || clazz == Float.class) { Float float_ = Float.valueOf(number.floatValue()); } else if (clazz == long.class || clazz == Long.class) { Long long_ = Long.valueOf(number.longValue()); } else if (clazz == double.class || clazz == Double.class) { Double double_ = Double.valueOf(number.doubleValue()); } else if (clazz == short.class || clazz == Short.class) { Short short_ = Short.valueOf(number.shortValue()); } else if (clazz == byte.class || clazz == Byte.class) { Byte byte_ = Byte.valueOf(number.byteValue()); } else if (ClassReflection.isAssignableFrom(Distribution.class, clazz)) { clazz = clazz; integer = this.btParser.distributionAdapters.toDistribution("constant," + number, (Class)clazz); }  } else if (param1Object instanceof Boolean) { if (clazz == boolean.class || clazz == Boolean.class) object = param1Object;  } else if (param1Object instanceof String) { String str = (String)param1Object; if (clazz == String.class) { object = param1Object; } else if (clazz == char.class || clazz == Character.class) { if (str.length() != 1) throw new GdxRuntimeException("Invalid character '" + param1Object + "'");  object = Character.valueOf(str.charAt(0)); } else if (ClassReflection.isAssignableFrom(Distribution.class, clazz)) { clazz = clazz; integer = this.btParser.distributionAdapters.toDistribution(str, (Class)clazz); } else if (ClassReflection.isAssignableFrom(Enum.class, clazz)) { Enum[] arrayOfEnum = (Enum[])clazz.getEnumConstants(); byte b; int i; for (b = 0, i = arrayOfEnum.length; b < i; b++) { Enum<Enum> enum_; if ((enum_ = arrayOfEnum[b]).name().equalsIgnoreCase(str)) { object = enum_; break; }  }  }  }  return object; }
/* 657 */     StackedTask<E> getLastStackedTask() { return (StackedTask<E>)this.stack.peek(); }
/*     */     private void throwAttributeNameException(String param1String1, String param1String2, String param1String3) { String str = " no attribute expected"; if (param1String3 != null) str = "expected '" + param1String3 + "' instead";  throw new GdxRuntimeException(param1String1 + ": attribute '" + param1String2 + "' unknown; " + str); }
/*     */     private void throwAttributeTypeException(String param1String1, String param1String2, String param1String3) { throw new GdxRuntimeException(param1String1 + ": attribute '" + param1String2 + "' must be of type " + param1String3); }
/*     */     protected void endLine() {}
/* 661 */     protected void endStatement() { this.statement.exit(this); } private void openTask(String param1String, boolean param1Boolean) { try { Task<E> task; if (this.isSubtreeRef) { task = subtreeRootTaskInstance(param1String); } else { String str; if ((str = getImport(param1String)) == null) str = param1String;  Task task1 = (Task)ClassReflection.newInstance(ClassReflection.forName(str)); }  if (!this.currentTree.inited()) { initCurrentTree(task, this.indent); this.indent = 0; } else if (!param1Boolean) { StackedTask<E> stackedTask = getPrevTask(); this.indent -= this.currentTreeStartIndent; if (stackedTask.task == this.currentTree.rootTask) this.step = this.indent;  if (this.indent > this.currentDepth) { this.stack.add(stackedTask); } else if (this.indent <= this.currentDepth) { int j = (this.currentDepth - this.indent) / this.step; popAndCheckMinChildren(this.stack.size - j); }  int i = (stackedTask = (StackedTask<E>)this.stack.peek()).metadata.maxChildren; if (stackedTask.task.getChildCount() >= i) throw stackedTaskException(stackedTask, "max number of children exceeded (" + (stackedTask.task.getChildCount() + 1) + " > " + i + ")");  stackedTask.task.addChild(task); }  updateCurrentTask(createStackedTask(param1String, task), this.indent, param1Boolean); return; } catch (ReflectionException reflectionException) { throw new GdxRuntimeException("Cannot parse behavior tree!!!", reflectionException); }  } StackedTask<E> getPrevTask() { return this.prevTask; } private StackedTask<E> createStackedTask(String param1String, Task<E> param1Task) { Metadata metadata; if ((metadata = findMetadata(param1Task.getClass())) == null) throw new GdxRuntimeException(param1String + ": @TaskConstraint annotation not found in '" + param1Task.getClass().getSimpleName() + "' class hierarchy");  return new StackedTask<>(this.lineNumber, param1String, param1Task, metadata); } private Metadata findMetadata(Class<?> param1Class) { Metadata metadata; Annotation annotation; if ((metadata = (Metadata)this.metadataCache.get(param1Class)) == null && (annotation = ClassReflection.getAnnotation(param1Class, TaskConstraint.class)) != null) { TaskConstraint taskConstraint = (TaskConstraint)annotation.getAnnotation(TaskConstraint.class); ObjectMap<String, AttrInfo> objectMap = new ObjectMap(); Field[] arrayOfField; int i; byte b; for (i = (arrayOfField = arrayOfField = ClassReflection.getFields(param1Class)).length, b = 0; b < i; b++) { Field field; Annotation annotation1; if ((annotation1 = (field = arrayOfField[b]).getDeclaredAnnotation(TaskAttribute.class)) != null) { AttrInfo attrInfo = new AttrInfo(field.getName(), (TaskAttribute)annotation1.getAnnotation(TaskAttribute.class)); objectMap.put(attrInfo.name, attrInfo); }  }  metadata = new Metadata(taskConstraint.minChildren(), taskConstraint.maxChildren(), objectMap); this.metadataCache.put(param1Class, metadata); }  return metadata; } protected static class StackedTask<E> {
/*     */       public int lineNumber; public String name; public Task<E> task; public BehaviorTreeParser.DefaultBehaviorTreeReader.Metadata metadata; StackedTask(int param2Int, String param2String, Task<E> param2Task, BehaviorTreeParser.DefaultBehaviorTreeReader.Metadata param2Metadata) { this.lineNumber = param2Int; this.name = param2String; this.task = param2Task; this.metadata = param2Metadata; } } private static class Metadata {
/*     */       int minChildren; int maxChildren; ObjectMap<String, BehaviorTreeParser.DefaultBehaviorTreeReader.AttrInfo> attributes; Metadata(int param2Int1, int param2Int2, ObjectMap<String, BehaviorTreeParser.DefaultBehaviorTreeReader.AttrInfo> param2ObjectMap) { this.minChildren = (param2Int1 < 0) ? 0 : param2Int1; this.maxChildren = (param2Int2 < 0) ? Integer.MAX_VALUE : param2Int2; this.attributes = param2ObjectMap; } } private static class AttrInfo {
/*     */       String name; String fieldName; boolean required; AttrInfo(String param2String, TaskAttribute param2TaskAttribute) { this(param2TaskAttribute.name(), param2String, param2TaskAttribute.required()); } AttrInfo(String param2String1, String param2String2, boolean param2Boolean) { this.name = (param2String1 == null || param2String1.length() == 0) ? param2String2 : param2String1; this.fieldName = param2String2; this.required = param2Boolean; } } protected static class Subtree<E> {
/* 665 */       String name; Task<E> rootTask; int referenceCount; Subtree() { this(null); } Subtree(String param2String) { this.name = param2String; this.rootTask = null; this.referenceCount = 0; } public void init(Task<E> param2Task) { this.rootTask = param2Task; } public boolean inited() { return (this.rootTask != null); } public boolean isRootTree() { return (this.name == null || "".equals(this.name)); } public Task<E> rootTaskInstance() { if (this.referenceCount++ == 0) return this.rootTask;  return this.rootTask.cloneTask(); } } StackedTask<E> getCurrentTask() { return this.isGuard ? this.guardChain : this.prevTask; }
/*     */ 
/*     */     
/*     */     void updateCurrentTask(StackedTask<E> param1StackedTask, int param1Int, boolean param1Boolean) {
/* 669 */       this.isGuard = param1Boolean;
/* 670 */       param1StackedTask.task.setGuard((this.guardChain == null) ? null : this.guardChain.task);
/* 671 */       if (param1Boolean) {
/* 672 */         this.guardChain = param1StackedTask;
/*     */         return;
/*     */       } 
/* 675 */       this.prevTask = param1StackedTask;
/* 676 */       this.guardChain = null;
/* 677 */       this.currentDepth = param1Int;
/*     */     }
/*     */ 
/*     */     
/*     */     void clear() {
/* 682 */       this.prevTask = null;
/* 683 */       this.guardChain = null;
/* 684 */       this.currentTree = null;
/* 685 */       this.userImports.clear();
/* 686 */       this.subtrees.clear();
/* 687 */       this.stack.clear();
/* 688 */       this.encounteredAttributes.clear();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void switchToNewTree(String param1String) {
/* 697 */       popAndCheckMinChildren(0);
/*     */       
/* 699 */       this.currentTree = new Subtree<>(param1String);
/*     */       Subtree subtree;
/* 701 */       if ((subtree = (Subtree)this.subtrees.put(param1String, this.currentTree)) != null)
/* 702 */         throw new GdxRuntimeException("A subtree named '" + param1String + "' is already defined"); 
/*     */     }
/*     */     
/*     */     void initCurrentTree(Task<E> param1Task, int param1Int) {
/* 706 */       this.currentDepth = -1;
/* 707 */       this.step = 1;
/* 708 */       this.currentTreeStartIndent = param1Int;
/* 709 */       this.currentTree.init(param1Task);
/* 710 */       this.prevTask = null;
/*     */     }
/*     */     
/*     */     Task<E> subtreeRootTaskInstance(String param1String) {
/*     */       Subtree<E> subtree;
/* 715 */       if ((subtree = (Subtree)this.subtrees.get(param1String)) == null)
/* 716 */         throw new GdxRuntimeException("Undefined subtree with name '" + param1String + "'"); 
/* 717 */       return subtree.rootTaskInstance();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void addImport(String param1String1, String param1String2) {
/* 725 */       if (param1String2 == null) throw new GdxRuntimeException("import: missing task class name."); 
/* 726 */       if (param1String1 == null) {
/*     */         Class clazz;
/*     */         try {
/* 729 */           clazz = ClassReflection.forName(param1String2);
/* 730 */         } catch (ReflectionException reflectionException) {
/* 731 */           throw new GdxRuntimeException("import: class not found '" + param1String2 + "'");
/*     */         } 
/* 733 */         param1String1 = clazz.getSimpleName();
/*     */       } 
/*     */       String str;
/* 736 */       if ((str = getImport(param1String1)) != null) throw new GdxRuntimeException("import: alias '" + param1String1 + "' previously defined already."); 
/* 737 */       this.userImports.put(param1String1, param1String2);
/*     */     }
/*     */     
/*     */     String getImport(String param1String) {
/*     */       String str;
/* 742 */       return ((str = (String)DEFAULT_IMPORTS.get(param1String)) != null) ? str : (String)this.userImports.get(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void popAndCheckMinChildren(int param1Int) {
/* 751 */       if (this.prevTask != null) checkMinChildren(this.prevTask);
/*     */ 
/*     */       
/* 754 */       while (this.stack.size > param1Int) {
/* 755 */         StackedTask<E> stackedTask = (StackedTask)this.stack.pop();
/* 756 */         checkMinChildren(stackedTask);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private void checkMinChildren(StackedTask<E> param1StackedTask) {
/* 762 */       int i = param1StackedTask.metadata.minChildren;
/* 763 */       if (param1StackedTask.task.getChildCount() < i) {
/* 764 */         throw stackedTaskException(param1StackedTask, "not enough children (" + param1StackedTask.task.getChildCount() + " < " + i + ")");
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     private void checkRequiredAttributes(StackedTask<E> param1StackedTask) {
/* 770 */       ObjectMap.Entries entries = param1StackedTask.metadata.attributes.iterator();
/* 771 */       while (entries.hasNext()) {
/*     */         ObjectMap.Entry entry;
/* 773 */         if (((AttrInfo)(entry = entries.next()).value).required && !this.encounteredAttributes.contains(entry.key))
/* 774 */           throw stackedTaskException(param1StackedTask, "missing required attribute '" + (String)entry.key + "'"); 
/*     */       } 
/*     */     }
/*     */     
/*     */     private GdxRuntimeException stackedTaskException(StackedTask<E> param1StackedTask, String param1String) {
/* 779 */       return new GdxRuntimeException(param1StackedTask.name + " at line " + param1StackedTask.lineNumber + ": " + param1String);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btre\\utils\BehaviorTreeParser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */