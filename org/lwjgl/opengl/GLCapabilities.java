/*       */ package org.lwjgl.opengl;
/*       */ 
/*       */ import java.util.Set;
/*       */ import java.util.function.IntFunction;
/*       */ import org.lwjgl.PointerBuffer;
/*       */ import org.lwjgl.system.Checks;
/*       */ import org.lwjgl.system.FunctionProvider;
/*       */ import org.lwjgl.system.ThreadLocalUtil;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ public final class GLCapabilities
/*       */ {
/*       */   static final int ADDRESS_BUFFER_SIZE = 2228;
/*       */   public final long glEnable;
/*       */   public final long glDisable;
/*       */   public final long glAccum;
/*       */   public final long glAlphaFunc;
/*       */   public final long glAreTexturesResident;
/*       */   public final long glArrayElement;
/*       */   public final long glBegin;
/*       */   public final long glBindTexture;
/*       */   public final long glBitmap;
/*       */   public final long glBlendFunc;
/*       */   public final long glCallList;
/*       */   public final long glCallLists;
/*       */   public final long glClear;
/*       */   public final long glClearAccum;
/*       */   public final long glClearColor;
/*       */   public final long glClearDepth;
/*       */   public final long glClearIndex;
/*       */   public final long glClearStencil;
/*       */   public final long glClipPlane;
/*       */   public final long glColor3b;
/*       */   public final long glColor3s;
/*       */   public final long glColor3i;
/*       */   public final long glColor3f;
/*       */   public final long glColor3d;
/*       */   public final long glColor3ub;
/*       */   public final long glColor3us;
/*       */   public final long glColor3ui;
/*       */   public final long glColor3bv;
/*       */   public final long glColor3sv;
/*       */   public final long glColor3iv;
/*       */   public final long glColor3fv;
/*       */   public final long glColor3dv;
/*       */   public final long glColor3ubv;
/*       */   public final long glColor3usv;
/*       */   public final long glColor3uiv;
/*       */   public final long glColor4b;
/*       */   public final long glColor4s;
/*       */   public final long glColor4i;
/*       */   public final long glColor4f;
/*       */   public final long glColor4d;
/*       */   public final long glColor4ub;
/*       */   public final long glColor4us;
/*       */   public final long glColor4ui;
/*       */   public final long glColor4bv;
/*       */   public final long glColor4sv;
/*       */   public final long glColor4iv;
/*       */   public final long glColor4fv;
/*       */   public final long glColor4dv;
/*       */   public final long glColor4ubv;
/*       */   public final long glColor4usv;
/*       */   public final long glColor4uiv;
/*       */   public final long glColorMask;
/*       */   public final long glColorMaterial;
/*       */   public final long glColorPointer;
/*       */   public final long glCopyPixels;
/*       */   public final long glCullFace;
/*       */   public final long glDeleteLists;
/*       */   public final long glDepthFunc;
/*       */   public final long glDepthMask;
/*       */   public final long glDepthRange;
/*       */   public final long glDisableClientState;
/*       */   public final long glDrawArrays;
/*       */   public final long glDrawBuffer;
/*       */   public final long glDrawElements;
/*       */   public final long glDrawPixels;
/*       */   public final long glEdgeFlag;
/*       */   public final long glEdgeFlagv;
/*       */   public final long glEdgeFlagPointer;
/*       */   public final long glEnableClientState;
/*       */   public final long glEnd;
/*       */   public final long glEvalCoord1f;
/*       */   public final long glEvalCoord1fv;
/*       */   public final long glEvalCoord1d;
/*       */   public final long glEvalCoord1dv;
/*       */   public final long glEvalCoord2f;
/*       */   public final long glEvalCoord2fv;
/*       */   public final long glEvalCoord2d;
/*       */   public final long glEvalCoord2dv;
/*       */   public final long glEvalMesh1;
/*       */   public final long glEvalMesh2;
/*       */   public final long glEvalPoint1;
/*       */   public final long glEvalPoint2;
/*       */   public final long glFeedbackBuffer;
/*       */   public final long glFinish;
/*       */   public final long glFlush;
/*       */   public final long glFogi;
/*       */   public final long glFogiv;
/*       */   public final long glFogf;
/*       */   public final long glFogfv;
/*       */   public final long glFrontFace;
/*       */   public final long glGenLists;
/*       */   public final long glGenTextures;
/*       */   public final long glDeleteTextures;
/*       */   public final long glGetClipPlane;
/*       */   public final long glGetBooleanv;
/*       */   public final long glGetFloatv;
/*       */   public final long glGetIntegerv;
/*       */   public final long glGetDoublev;
/*       */   public final long glGetError;
/*       */   public final long glGetLightiv;
/*       */   public final long glGetLightfv;
/*       */   public final long glGetMapiv;
/*       */   public final long glGetMapfv;
/*       */   public final long glGetMapdv;
/*       */   public final long glGetMaterialiv;
/*       */   public final long glGetMaterialfv;
/*       */   public final long glGetPixelMapfv;
/*       */   public final long glGetPixelMapusv;
/*       */   public final long glGetPixelMapuiv;
/*       */   public final long glGetPointerv;
/*       */   public final long glGetPolygonStipple;
/*       */   public final long glGetString;
/*       */   public final long glGetTexEnviv;
/*       */   public final long glGetTexEnvfv;
/*       */   public final long glGetTexGeniv;
/*       */   public final long glGetTexGenfv;
/*       */   public final long glGetTexGendv;
/*       */   public final long glGetTexImage;
/*       */   public final long glGetTexLevelParameteriv;
/*       */   public final long glGetTexLevelParameterfv;
/*       */   public final long glGetTexParameteriv;
/*       */   public final long glGetTexParameterfv;
/*       */   public final long glHint;
/*       */   public final long glIndexi;
/*       */   public final long glIndexub;
/*       */   public final long glIndexs;
/*       */   public final long glIndexf;
/*       */   public final long glIndexd;
/*       */   public final long glIndexiv;
/*       */   public final long glIndexubv;
/*       */   public final long glIndexsv;
/*       */   public final long glIndexfv;
/*       */   public final long glIndexdv;
/*       */   public final long glIndexMask;
/*       */   public final long glIndexPointer;
/*       */   public final long glInitNames;
/*       */   public final long glInterleavedArrays;
/*       */   public final long glIsEnabled;
/*       */   public final long glIsList;
/*       */   public final long glIsTexture;
/*       */   public final long glLightModeli;
/*       */   public final long glLightModelf;
/*       */   public final long glLightModeliv;
/*       */   public final long glLightModelfv;
/*       */   public final long glLighti;
/*       */   public final long glLightf;
/*       */   public final long glLightiv;
/*       */   public final long glLightfv;
/*       */   public final long glLineStipple;
/*       */   public final long glLineWidth;
/*       */   public final long glListBase;
/*       */   public final long glLoadMatrixf;
/*       */   public final long glLoadMatrixd;
/*       */   public final long glLoadIdentity;
/*       */   public final long glLoadName;
/*       */   public final long glLogicOp;
/*       */   public final long glMap1f;
/*       */   public final long glMap1d;
/*       */   public final long glMap2f;
/*       */   public final long glMap2d;
/*       */   public final long glMapGrid1f;
/*       */   public final long glMapGrid1d;
/*       */   public final long glMapGrid2f;
/*       */   public final long glMapGrid2d;
/*       */   public final long glMateriali;
/*       */   public final long glMaterialf;
/*       */   public final long glMaterialiv;
/*       */   public final long glMaterialfv;
/*       */   public final long glMatrixMode;
/*       */   public final long glMultMatrixf;
/*       */   public final long glMultMatrixd;
/*       */   public final long glFrustum;
/*       */   public final long glNewList;
/*       */   public final long glEndList;
/*       */   public final long glNormal3f;
/*       */   public final long glNormal3b;
/*       */   public final long glNormal3s;
/*       */   public final long glNormal3i;
/*       */   public final long glNormal3d;
/*       */   public final long glNormal3fv;
/*       */   public final long glNormal3bv;
/*       */   public final long glNormal3sv;
/*       */   public final long glNormal3iv;
/*       */   public final long glNormal3dv;
/*       */   public final long glNormalPointer;
/*       */   public final long glOrtho;
/*       */   public final long glPassThrough;
/*       */   public final long glPixelMapfv;
/*       */   public final long glPixelMapusv;
/*       */   public final long glPixelMapuiv;
/*       */   public final long glPixelStorei;
/*       */   public final long glPixelStoref;
/*       */   public final long glPixelTransferi;
/*       */   public final long glPixelTransferf;
/*       */   public final long glPixelZoom;
/*       */   public final long glPointSize;
/*       */   public final long glPolygonMode;
/*       */   public final long glPolygonOffset;
/*       */   public final long glPolygonStipple;
/*       */   public final long glPushAttrib;
/*       */   public final long glPushClientAttrib;
/*       */   public final long glPopAttrib;
/*       */   public final long glPopClientAttrib;
/*       */   public final long glPopMatrix;
/*       */   public final long glPopName;
/*       */   public final long glPrioritizeTextures;
/*       */   public final long glPushMatrix;
/*       */   public final long glPushName;
/*       */   public final long glRasterPos2i;
/*       */   public final long glRasterPos2s;
/*       */   public final long glRasterPos2f;
/*       */   public final long glRasterPos2d;
/*       */   public final long glRasterPos2iv;
/*       */   public final long glRasterPos2sv;
/*       */   public final long glRasterPos2fv;
/*       */   public final long glRasterPos2dv;
/*       */   public final long glRasterPos3i;
/*       */   public final long glRasterPos3s;
/*       */   public final long glRasterPos3f;
/*       */   public final long glRasterPos3d;
/*       */   public final long glRasterPos3iv;
/*       */   public final long glRasterPos3sv;
/*       */   public final long glRasterPos3fv;
/*       */   public final long glRasterPos3dv;
/*       */   public final long glRasterPos4i;
/*       */   public final long glRasterPos4s;
/*       */   public final long glRasterPos4f;
/*       */   public final long glRasterPos4d;
/*       */   public final long glRasterPos4iv;
/*       */   public final long glRasterPos4sv;
/*       */   public final long glRasterPos4fv;
/*       */   public final long glRasterPos4dv;
/*       */   public final long glReadBuffer;
/*       */   public final long glReadPixels;
/*       */   public final long glRecti;
/*       */   public final long glRects;
/*       */   public final long glRectf;
/*       */   public final long glRectd;
/*       */   public final long glRectiv;
/*       */   public final long glRectsv;
/*       */   public final long glRectfv;
/*       */   public final long glRectdv;
/*       */   public final long glRenderMode;
/*       */   public final long glRotatef;
/*       */   public final long glRotated;
/*       */   public final long glScalef;
/*       */   public final long glScaled;
/*       */   public final long glScissor;
/*       */   public final long glSelectBuffer;
/*       */   public final long glShadeModel;
/*       */   public final long glStencilFunc;
/*       */   public final long glStencilMask;
/*       */   public final long glStencilOp;
/*       */   public final long glTexCoord1f;
/*       */   public final long glTexCoord1s;
/*       */   public final long glTexCoord1i;
/*       */   public final long glTexCoord1d;
/*       */   public final long glTexCoord1fv;
/*       */   public final long glTexCoord1sv;
/*       */   public final long glTexCoord1iv;
/*       */   public final long glTexCoord1dv;
/*       */   public final long glTexCoord2f;
/*       */   public final long glTexCoord2s;
/*       */   public final long glTexCoord2i;
/*       */   public final long glTexCoord2d;
/*       */   public final long glTexCoord2fv;
/*       */   public final long glTexCoord2sv;
/*       */   public final long glTexCoord2iv;
/*       */   public final long glTexCoord2dv;
/*       */   public final long glTexCoord3f;
/*       */   public final long glTexCoord3s;
/*       */   public final long glTexCoord3i;
/*       */   public final long glTexCoord3d;
/*       */   public final long glTexCoord3fv;
/*       */   public final long glTexCoord3sv;
/*       */   public final long glTexCoord3iv;
/*       */   public final long glTexCoord3dv;
/*       */   public final long glTexCoord4f;
/*       */   public final long glTexCoord4s;
/*       */   public final long glTexCoord4i;
/*       */   public final long glTexCoord4d;
/*       */   public final long glTexCoord4fv;
/*       */   public final long glTexCoord4sv;
/*       */   public final long glTexCoord4iv;
/*       */   public final long glTexCoord4dv;
/*       */   public final long glTexCoordPointer;
/*       */   public final long glTexEnvi;
/*       */   public final long glTexEnviv;
/*       */   public final long glTexEnvf;
/*       */   public final long glTexEnvfv;
/*       */   public final long glTexGeni;
/*       */   public final long glTexGeniv;
/*       */   public final long glTexGenf;
/*       */   public final long glTexGenfv;
/*       */   public final long glTexGend;
/*       */   public final long glTexGendv;
/*       */   public final long glTexImage1D;
/*       */   public final long glTexImage2D;
/*       */   public final long glCopyTexImage1D;
/*       */   public final long glCopyTexImage2D;
/*       */   public final long glCopyTexSubImage1D;
/*       */   public final long glCopyTexSubImage2D;
/*       */   public final long glTexParameteri;
/*       */   public final long glTexParameteriv;
/*       */   public final long glTexParameterf;
/*       */   public final long glTexParameterfv;
/*       */   public final long glTexSubImage1D;
/*       */   public final long glTexSubImage2D;
/*       */   public final long glTranslatef;
/*       */   public final long glTranslated;
/*       */   public final long glVertex2f;
/*       */   public final long glVertex2s;
/*       */   public final long glVertex2i;
/*       */   public final long glVertex2d;
/*       */   public final long glVertex2fv;
/*       */   public final long glVertex2sv;
/*       */   public final long glVertex2iv;
/*       */   public final long glVertex2dv;
/*       */   public final long glVertex3f;
/*       */   public final long glVertex3s;
/*       */   public final long glVertex3i;
/*       */   public final long glVertex3d;
/*       */   public final long glVertex3fv;
/*       */   public final long glVertex3sv;
/*       */   public final long glVertex3iv;
/*       */   public final long glVertex3dv;
/*       */   public final long glVertex4f;
/*       */   public final long glVertex4s;
/*       */   public final long glVertex4i;
/*       */   public final long glVertex4d;
/*       */   public final long glVertex4fv;
/*       */   public final long glVertex4sv;
/*       */   public final long glVertex4iv;
/*       */   public final long glVertex4dv;
/*       */   public final long glVertexPointer;
/*       */   public final long glViewport;
/*       */   public final long glTexImage3D;
/*       */   public final long glTexSubImage3D;
/*       */   public final long glCopyTexSubImage3D;
/*       */   public final long glDrawRangeElements;
/*       */   public final long glCompressedTexImage3D;
/*       */   public final long glCompressedTexImage2D;
/*       */   public final long glCompressedTexImage1D;
/*       */   public final long glCompressedTexSubImage3D;
/*       */   public final long glCompressedTexSubImage2D;
/*       */   public final long glCompressedTexSubImage1D;
/*       */   public final long glGetCompressedTexImage;
/*       */   public final long glSampleCoverage;
/*       */   public final long glActiveTexture;
/*       */   public final long glClientActiveTexture;
/*       */   public final long glMultiTexCoord1f;
/*       */   public final long glMultiTexCoord1s;
/*       */   public final long glMultiTexCoord1i;
/*       */   public final long glMultiTexCoord1d;
/*       */   public final long glMultiTexCoord1fv;
/*       */   public final long glMultiTexCoord1sv;
/*       */   public final long glMultiTexCoord1iv;
/*       */   public final long glMultiTexCoord1dv;
/*       */   public final long glMultiTexCoord2f;
/*       */   public final long glMultiTexCoord2s;
/*       */   public final long glMultiTexCoord2i;
/*       */   public final long glMultiTexCoord2d;
/*       */   public final long glMultiTexCoord2fv;
/*       */   public final long glMultiTexCoord2sv;
/*       */   public final long glMultiTexCoord2iv;
/*       */   public final long glMultiTexCoord2dv;
/*       */   public final long glMultiTexCoord3f;
/*       */   public final long glMultiTexCoord3s;
/*       */   public final long glMultiTexCoord3i;
/*       */   public final long glMultiTexCoord3d;
/*       */   public final long glMultiTexCoord3fv;
/*       */   public final long glMultiTexCoord3sv;
/*       */   public final long glMultiTexCoord3iv;
/*       */   public final long glMultiTexCoord3dv;
/*       */   public final long glMultiTexCoord4f;
/*       */   public final long glMultiTexCoord4s;
/*       */   public final long glMultiTexCoord4i;
/*       */   public final long glMultiTexCoord4d;
/*       */   public final long glMultiTexCoord4fv;
/*       */   public final long glMultiTexCoord4sv;
/*       */   public final long glMultiTexCoord4iv;
/*       */   public final long glMultiTexCoord4dv;
/*       */   public final long glLoadTransposeMatrixf;
/*       */   public final long glLoadTransposeMatrixd;
/*       */   public final long glMultTransposeMatrixf;
/*       */   public final long glMultTransposeMatrixd;
/*       */   public final long glBlendColor;
/*       */   public final long glBlendEquation;
/*       */   public final long glFogCoordf;
/*       */   public final long glFogCoordd;
/*       */   public final long glFogCoordfv;
/*       */   public final long glFogCoorddv;
/*       */   public final long glFogCoordPointer;
/*       */   public final long glMultiDrawArrays;
/*       */   public final long glMultiDrawElements;
/*       */   public final long glPointParameterf;
/*       */   public final long glPointParameteri;
/*       */   public final long glPointParameterfv;
/*       */   public final long glPointParameteriv;
/*       */   public final long glSecondaryColor3b;
/*       */   public final long glSecondaryColor3s;
/*       */   public final long glSecondaryColor3i;
/*       */   public final long glSecondaryColor3f;
/*       */   public final long glSecondaryColor3d;
/*       */   public final long glSecondaryColor3ub;
/*       */   public final long glSecondaryColor3us;
/*       */   public final long glSecondaryColor3ui;
/*       */   public final long glSecondaryColor3bv;
/*       */   public final long glSecondaryColor3sv;
/*       */   public final long glSecondaryColor3iv;
/*       */   public final long glSecondaryColor3fv;
/*       */   public final long glSecondaryColor3dv;
/*       */   public final long glSecondaryColor3ubv;
/*       */   public final long glSecondaryColor3usv;
/*       */   public final long glSecondaryColor3uiv;
/*       */   public final long glSecondaryColorPointer;
/*       */   public final long glBlendFuncSeparate;
/*       */   public final long glWindowPos2i;
/*       */   public final long glWindowPos2s;
/*       */   public final long glWindowPos2f;
/*       */   public final long glWindowPos2d;
/*       */   public final long glWindowPos2iv;
/*       */   public final long glWindowPos2sv;
/*       */   public final long glWindowPos2fv;
/*       */   public final long glWindowPos2dv;
/*       */   public final long glWindowPos3i;
/*       */   public final long glWindowPos3s;
/*       */   public final long glWindowPos3f;
/*       */   public final long glWindowPos3d;
/*       */   public final long glWindowPos3iv;
/*       */   public final long glWindowPos3sv;
/*       */   public final long glWindowPos3fv;
/*       */   public final long glWindowPos3dv;
/*       */   public final long glBindBuffer;
/*       */   public final long glDeleteBuffers;
/*       */   public final long glGenBuffers;
/*       */   public final long glIsBuffer;
/*       */   public final long glBufferData;
/*       */   public final long glBufferSubData;
/*       */   public final long glGetBufferSubData;
/*       */   public final long glMapBuffer;
/*       */   public final long glUnmapBuffer;
/*       */   public final long glGetBufferParameteriv;
/*       */   public final long glGetBufferPointerv;
/*       */   public final long glGenQueries;
/*       */   public final long glDeleteQueries;
/*       */   public final long glIsQuery;
/*       */   public final long glBeginQuery;
/*       */   public final long glEndQuery;
/*       */   public final long glGetQueryiv;
/*       */   public final long glGetQueryObjectiv;
/*       */   public final long glGetQueryObjectuiv;
/*       */   public final long glCreateProgram;
/*       */   public final long glDeleteProgram;
/*       */   public final long glIsProgram;
/*       */   public final long glCreateShader;
/*       */   public final long glDeleteShader;
/*       */   public final long glIsShader;
/*       */   public final long glAttachShader;
/*       */   public final long glDetachShader;
/*       */   public final long glShaderSource;
/*       */   public final long glCompileShader;
/*       */   public final long glLinkProgram;
/*       */   public final long glUseProgram;
/*       */   public final long glValidateProgram;
/*       */   public final long glUniform1f;
/*       */   public final long glUniform2f;
/*       */   public final long glUniform3f;
/*       */   public final long glUniform4f;
/*       */   public final long glUniform1i;
/*       */   public final long glUniform2i;
/*       */   public final long glUniform3i;
/*       */   public final long glUniform4i;
/*       */   public final long glUniform1fv;
/*       */   public final long glUniform2fv;
/*       */   public final long glUniform3fv;
/*       */   public final long glUniform4fv;
/*       */   public final long glUniform1iv;
/*       */   public final long glUniform2iv;
/*       */   public final long glUniform3iv;
/*       */   public final long glUniform4iv;
/*       */   public final long glUniformMatrix2fv;
/*       */   public final long glUniformMatrix3fv;
/*       */   public final long glUniformMatrix4fv;
/*       */   public final long glGetShaderiv;
/*       */   public final long glGetProgramiv;
/*       */   public final long glGetShaderInfoLog;
/*       */   public final long glGetProgramInfoLog;
/*       */   public final long glGetAttachedShaders;
/*       */   public final long glGetUniformLocation;
/*       */   public final long glGetActiveUniform;
/*       */   public final long glGetUniformfv;
/*       */   public final long glGetUniformiv;
/*       */   public final long glGetShaderSource;
/*       */   public final long glVertexAttrib1f;
/*       */   public final long glVertexAttrib1s;
/*       */   public final long glVertexAttrib1d;
/*       */   public final long glVertexAttrib2f;
/*       */   public final long glVertexAttrib2s;
/*       */   public final long glVertexAttrib2d;
/*       */   public final long glVertexAttrib3f;
/*       */   public final long glVertexAttrib3s;
/*       */   public final long glVertexAttrib3d;
/*       */   public final long glVertexAttrib4f;
/*       */   public final long glVertexAttrib4s;
/*       */   public final long glVertexAttrib4d;
/*       */   public final long glVertexAttrib4Nub;
/*       */   public final long glVertexAttrib1fv;
/*       */   public final long glVertexAttrib1sv;
/*       */   public final long glVertexAttrib1dv;
/*       */   public final long glVertexAttrib2fv;
/*       */   public final long glVertexAttrib2sv;
/*       */   public final long glVertexAttrib2dv;
/*       */   public final long glVertexAttrib3fv;
/*       */   public final long glVertexAttrib3sv;
/*       */   public final long glVertexAttrib3dv;
/*       */   public final long glVertexAttrib4fv;
/*       */   public final long glVertexAttrib4sv;
/*       */   public final long glVertexAttrib4dv;
/*       */   public final long glVertexAttrib4iv;
/*       */   public final long glVertexAttrib4bv;
/*       */   public final long glVertexAttrib4ubv;
/*       */   public final long glVertexAttrib4usv;
/*       */   public final long glVertexAttrib4uiv;
/*       */   public final long glVertexAttrib4Nbv;
/*       */   public final long glVertexAttrib4Nsv;
/*       */   public final long glVertexAttrib4Niv;
/*       */   public final long glVertexAttrib4Nubv;
/*       */   public final long glVertexAttrib4Nusv;
/*       */   public final long glVertexAttrib4Nuiv;
/*       */   public final long glVertexAttribPointer;
/*       */   public final long glEnableVertexAttribArray;
/*       */   public final long glDisableVertexAttribArray;
/*       */   public final long glBindAttribLocation;
/*       */   public final long glGetActiveAttrib;
/*       */   public final long glGetAttribLocation;
/*       */   public final long glGetVertexAttribiv;
/*       */   public final long glGetVertexAttribfv;
/*       */   public final long glGetVertexAttribdv;
/*       */   public final long glGetVertexAttribPointerv;
/*       */   public final long glDrawBuffers;
/*       */   public final long glBlendEquationSeparate;
/*       */   public final long glStencilOpSeparate;
/*       */   public final long glStencilFuncSeparate;
/*       */   public final long glStencilMaskSeparate;
/*       */   public final long glUniformMatrix2x3fv;
/*       */   public final long glUniformMatrix3x2fv;
/*       */   public final long glUniformMatrix2x4fv;
/*       */   public final long glUniformMatrix4x2fv;
/*       */   public final long glUniformMatrix3x4fv;
/*       */   public final long glUniformMatrix4x3fv;
/*       */   public final long glGetStringi;
/*       */   public final long glClearBufferiv;
/*       */   public final long glClearBufferuiv;
/*       */   public final long glClearBufferfv;
/*       */   public final long glClearBufferfi;
/*       */   public final long glVertexAttribI1i;
/*       */   public final long glVertexAttribI2i;
/*       */   public final long glVertexAttribI3i;
/*       */   public final long glVertexAttribI4i;
/*       */   public final long glVertexAttribI1ui;
/*       */   public final long glVertexAttribI2ui;
/*       */   public final long glVertexAttribI3ui;
/*       */   public final long glVertexAttribI4ui;
/*       */   public final long glVertexAttribI1iv;
/*       */   public final long glVertexAttribI2iv;
/*       */   public final long glVertexAttribI3iv;
/*       */   public final long glVertexAttribI4iv;
/*       */   public final long glVertexAttribI1uiv;
/*       */   public final long glVertexAttribI2uiv;
/*       */   public final long glVertexAttribI3uiv;
/*       */   public final long glVertexAttribI4uiv;
/*       */   public final long glVertexAttribI4bv;
/*       */   public final long glVertexAttribI4sv;
/*       */   public final long glVertexAttribI4ubv;
/*       */   public final long glVertexAttribI4usv;
/*       */   public final long glVertexAttribIPointer;
/*       */   public final long glGetVertexAttribIiv;
/*       */   public final long glGetVertexAttribIuiv;
/*       */   public final long glUniform1ui;
/*       */   public final long glUniform2ui;
/*       */   public final long glUniform3ui;
/*       */   public final long glUniform4ui;
/*       */   public final long glUniform1uiv;
/*       */   public final long glUniform2uiv;
/*       */   public final long glUniform3uiv;
/*       */   public final long glUniform4uiv;
/*       */   public final long glGetUniformuiv;
/*       */   public final long glBindFragDataLocation;
/*       */   public final long glGetFragDataLocation;
/*       */   public final long glBeginConditionalRender;
/*       */   public final long glEndConditionalRender;
/*       */   public final long glMapBufferRange;
/*       */   public final long glFlushMappedBufferRange;
/*       */   public final long glClampColor;
/*       */   public final long glIsRenderbuffer;
/*       */   public final long glBindRenderbuffer;
/*       */   public final long glDeleteRenderbuffers;
/*       */   public final long glGenRenderbuffers;
/*       */   public final long glRenderbufferStorage;
/*       */   public final long glRenderbufferStorageMultisample;
/*       */   public final long glGetRenderbufferParameteriv;
/*       */   public final long glIsFramebuffer;
/*       */   public final long glBindFramebuffer;
/*       */   public final long glDeleteFramebuffers;
/*       */   public final long glGenFramebuffers;
/*       */   public final long glCheckFramebufferStatus;
/*       */   public final long glFramebufferTexture1D;
/*       */   public final long glFramebufferTexture2D;
/*       */   public final long glFramebufferTexture3D;
/*       */   public final long glFramebufferTextureLayer;
/*       */   public final long glFramebufferRenderbuffer;
/*       */   public final long glGetFramebufferAttachmentParameteriv;
/*       */   public final long glBlitFramebuffer;
/*       */   public final long glGenerateMipmap;
/*       */   public final long glTexParameterIiv;
/*       */   public final long glTexParameterIuiv;
/*       */   public final long glGetTexParameterIiv;
/*       */   public final long glGetTexParameterIuiv;
/*       */   public final long glColorMaski;
/*       */   public final long glGetBooleani_v;
/*       */   public final long glGetIntegeri_v;
/*       */   public final long glEnablei;
/*       */   public final long glDisablei;
/*       */   public final long glIsEnabledi;
/*       */   public final long glBindBufferRange;
/*       */   public final long glBindBufferBase;
/*       */   public final long glBeginTransformFeedback;
/*       */   public final long glEndTransformFeedback;
/*       */   public final long glTransformFeedbackVaryings;
/*       */   public final long glGetTransformFeedbackVarying;
/*       */   public final long glBindVertexArray;
/*       */   public final long glDeleteVertexArrays;
/*       */   public final long glGenVertexArrays;
/*       */   public final long glIsVertexArray;
/*       */   public final long glDrawArraysInstanced;
/*       */   public final long glDrawElementsInstanced;
/*       */   public final long glCopyBufferSubData;
/*       */   public final long glPrimitiveRestartIndex;
/*       */   public final long glTexBuffer;
/*       */   public final long glGetUniformIndices;
/*       */   public final long glGetActiveUniformsiv;
/*       */   public final long glGetActiveUniformName;
/*       */   public final long glGetUniformBlockIndex;
/*       */   public final long glGetActiveUniformBlockiv;
/*       */   public final long glGetActiveUniformBlockName;
/*       */   public final long glUniformBlockBinding;
/*       */   public final long glGetBufferParameteri64v;
/*       */   public final long glDrawElementsBaseVertex;
/*       */   public final long glDrawRangeElementsBaseVertex;
/*       */   public final long glDrawElementsInstancedBaseVertex;
/*       */   public final long glMultiDrawElementsBaseVertex;
/*       */   public final long glProvokingVertex;
/*       */   public final long glTexImage2DMultisample;
/*       */   public final long glTexImage3DMultisample;
/*       */   public final long glGetMultisamplefv;
/*       */   public final long glSampleMaski;
/*       */   public final long glFramebufferTexture;
/*       */   public final long glFenceSync;
/*       */   public final long glIsSync;
/*       */   public final long glDeleteSync;
/*       */   public final long glClientWaitSync;
/*       */   public final long glWaitSync;
/*       */   public final long glGetInteger64v;
/*       */   public final long glGetInteger64i_v;
/*       */   public final long glGetSynciv;
/*       */   public final long glBindFragDataLocationIndexed;
/*       */   public final long glGetFragDataIndex;
/*       */   public final long glGenSamplers;
/*       */   public final long glDeleteSamplers;
/*       */   public final long glIsSampler;
/*       */   public final long glBindSampler;
/*       */   public final long glSamplerParameteri;
/*       */   public final long glSamplerParameterf;
/*       */   public final long glSamplerParameteriv;
/*       */   public final long glSamplerParameterfv;
/*       */   public final long glSamplerParameterIiv;
/*       */   public final long glSamplerParameterIuiv;
/*       */   public final long glGetSamplerParameteriv;
/*       */   public final long glGetSamplerParameterfv;
/*       */   public final long glGetSamplerParameterIiv;
/*       */   public final long glGetSamplerParameterIuiv;
/*       */   public final long glQueryCounter;
/*       */   public final long glGetQueryObjecti64v;
/*       */   public final long glGetQueryObjectui64v;
/*       */   public final long glVertexAttribDivisor;
/*       */   public final long glVertexP2ui;
/*       */   public final long glVertexP3ui;
/*       */   public final long glVertexP4ui;
/*       */   public final long glVertexP2uiv;
/*       */   public final long glVertexP3uiv;
/*       */   public final long glVertexP4uiv;
/*       */   public final long glTexCoordP1ui;
/*       */   public final long glTexCoordP2ui;
/*       */   public final long glTexCoordP3ui;
/*       */   public final long glTexCoordP4ui;
/*       */   public final long glTexCoordP1uiv;
/*       */   public final long glTexCoordP2uiv;
/*       */   public final long glTexCoordP3uiv;
/*       */   public final long glTexCoordP4uiv;
/*       */   public final long glMultiTexCoordP1ui;
/*       */   public final long glMultiTexCoordP2ui;
/*       */   public final long glMultiTexCoordP3ui;
/*       */   public final long glMultiTexCoordP4ui;
/*       */   public final long glMultiTexCoordP1uiv;
/*       */   public final long glMultiTexCoordP2uiv;
/*       */   public final long glMultiTexCoordP3uiv;
/*       */   public final long glMultiTexCoordP4uiv;
/*       */   public final long glNormalP3ui;
/*       */   public final long glNormalP3uiv;
/*       */   public final long glColorP3ui;
/*       */   public final long glColorP4ui;
/*       */   public final long glColorP3uiv;
/*       */   public final long glColorP4uiv;
/*       */   public final long glSecondaryColorP3ui;
/*       */   public final long glSecondaryColorP3uiv;
/*       */   public final long glVertexAttribP1ui;
/*       */   public final long glVertexAttribP2ui;
/*       */   public final long glVertexAttribP3ui;
/*       */   public final long glVertexAttribP4ui;
/*       */   public final long glVertexAttribP1uiv;
/*       */   public final long glVertexAttribP2uiv;
/*       */   public final long glVertexAttribP3uiv;
/*       */   public final long glVertexAttribP4uiv;
/*       */   public final long glBlendEquationi;
/*       */   public final long glBlendEquationSeparatei;
/*       */   public final long glBlendFunci;
/*       */   public final long glBlendFuncSeparatei;
/*       */   public final long glDrawArraysIndirect;
/*       */   public final long glDrawElementsIndirect;
/*       */   public final long glUniform1d;
/*       */   public final long glUniform2d;
/*       */   public final long glUniform3d;
/*       */   public final long glUniform4d;
/*       */   public final long glUniform1dv;
/*       */   public final long glUniform2dv;
/*       */   public final long glUniform3dv;
/*       */   public final long glUniform4dv;
/*       */   public final long glUniformMatrix2dv;
/*       */   public final long glUniformMatrix3dv;
/*       */   public final long glUniformMatrix4dv;
/*       */   public final long glUniformMatrix2x3dv;
/*       */   public final long glUniformMatrix2x4dv;
/*       */   public final long glUniformMatrix3x2dv;
/*       */   public final long glUniformMatrix3x4dv;
/*       */   public final long glUniformMatrix4x2dv;
/*       */   public final long glUniformMatrix4x3dv;
/*       */   public final long glGetUniformdv;
/*       */   public final long glMinSampleShading;
/*       */   public final long glGetSubroutineUniformLocation;
/*       */   public final long glGetSubroutineIndex;
/*       */   public final long glGetActiveSubroutineUniformiv;
/*       */   public final long glGetActiveSubroutineUniformName;
/*       */   public final long glGetActiveSubroutineName;
/*       */   public final long glUniformSubroutinesuiv;
/*       */   public final long glGetUniformSubroutineuiv;
/*       */   public final long glGetProgramStageiv;
/*       */   public final long glPatchParameteri;
/*       */   public final long glPatchParameterfv;
/*       */   public final long glBindTransformFeedback;
/*       */   public final long glDeleteTransformFeedbacks;
/*       */   public final long glGenTransformFeedbacks;
/*       */   public final long glIsTransformFeedback;
/*       */   public final long glPauseTransformFeedback;
/*       */   public final long glResumeTransformFeedback;
/*       */   public final long glDrawTransformFeedback;
/*       */   public final long glDrawTransformFeedbackStream;
/*       */   public final long glBeginQueryIndexed;
/*       */   public final long glEndQueryIndexed;
/*       */   public final long glGetQueryIndexediv;
/*       */   public final long glReleaseShaderCompiler;
/*       */   public final long glShaderBinary;
/*       */   public final long glGetShaderPrecisionFormat;
/*       */   public final long glDepthRangef;
/*       */   public final long glClearDepthf;
/*       */   public final long glGetProgramBinary;
/*       */   public final long glProgramBinary;
/*       */   public final long glProgramParameteri;
/*       */   public final long glUseProgramStages;
/*       */   public final long glActiveShaderProgram;
/*       */   public final long glCreateShaderProgramv;
/*       */   public final long glBindProgramPipeline;
/*       */   public final long glDeleteProgramPipelines;
/*       */   public final long glGenProgramPipelines;
/*       */   public final long glIsProgramPipeline;
/*       */   public final long glGetProgramPipelineiv;
/*       */   public final long glProgramUniform1i;
/*       */   public final long glProgramUniform2i;
/*       */   public final long glProgramUniform3i;
/*       */   public final long glProgramUniform4i;
/*       */   public final long glProgramUniform1ui;
/*       */   public final long glProgramUniform2ui;
/*       */   public final long glProgramUniform3ui;
/*       */   public final long glProgramUniform4ui;
/*       */   public final long glProgramUniform1f;
/*       */   public final long glProgramUniform2f;
/*       */   public final long glProgramUniform3f;
/*       */   public final long glProgramUniform4f;
/*       */   public final long glProgramUniform1d;
/*       */   public final long glProgramUniform2d;
/*       */   public final long glProgramUniform3d;
/*       */   public final long glProgramUniform4d;
/*       */   public final long glProgramUniform1iv;
/*       */   public final long glProgramUniform2iv;
/*       */   public final long glProgramUniform3iv;
/*       */   public final long glProgramUniform4iv;
/*       */   public final long glProgramUniform1uiv;
/*       */   public final long glProgramUniform2uiv;
/*       */   public final long glProgramUniform3uiv;
/*       */   public final long glProgramUniform4uiv;
/*       */   public final long glProgramUniform1fv;
/*       */   public final long glProgramUniform2fv;
/*       */   public final long glProgramUniform3fv;
/*       */   public final long glProgramUniform4fv;
/*       */   public final long glProgramUniform1dv;
/*       */   public final long glProgramUniform2dv;
/*       */   public final long glProgramUniform3dv;
/*       */   public final long glProgramUniform4dv;
/*       */   public final long glProgramUniformMatrix2fv;
/*       */   public final long glProgramUniformMatrix3fv;
/*       */   public final long glProgramUniformMatrix4fv;
/*       */   public final long glProgramUniformMatrix2dv;
/*       */   public final long glProgramUniformMatrix3dv;
/*       */   public final long glProgramUniformMatrix4dv;
/*       */   public final long glProgramUniformMatrix2x3fv;
/*       */   public final long glProgramUniformMatrix3x2fv;
/*       */   public final long glProgramUniformMatrix2x4fv;
/*       */   public final long glProgramUniformMatrix4x2fv;
/*       */   public final long glProgramUniformMatrix3x4fv;
/*       */   public final long glProgramUniformMatrix4x3fv;
/*       */   public final long glProgramUniformMatrix2x3dv;
/*       */   public final long glProgramUniformMatrix3x2dv;
/*       */   public final long glProgramUniformMatrix2x4dv;
/*       */   public final long glProgramUniformMatrix4x2dv;
/*       */   public final long glProgramUniformMatrix3x4dv;
/*       */   public final long glProgramUniformMatrix4x3dv;
/*       */   public final long glValidateProgramPipeline;
/*       */   public final long glGetProgramPipelineInfoLog;
/*       */   public final long glVertexAttribL1d;
/*       */   public final long glVertexAttribL2d;
/*       */   public final long glVertexAttribL3d;
/*       */   public final long glVertexAttribL4d;
/*       */   public final long glVertexAttribL1dv;
/*       */   public final long glVertexAttribL2dv;
/*       */   public final long glVertexAttribL3dv;
/*       */   public final long glVertexAttribL4dv;
/*       */   public final long glVertexAttribLPointer;
/*       */   public final long glGetVertexAttribLdv;
/*       */   public final long glViewportArrayv;
/*       */   public final long glViewportIndexedf;
/*       */   public final long glViewportIndexedfv;
/*       */   public final long glScissorArrayv;
/*       */   public final long glScissorIndexed;
/*       */   public final long glScissorIndexedv;
/*       */   public final long glDepthRangeArrayv;
/*       */   public final long glDepthRangeIndexed;
/*       */   public final long glGetFloati_v;
/*       */   public final long glGetDoublei_v;
/*       */   public final long glGetActiveAtomicCounterBufferiv;
/*       */   public final long glTexStorage1D;
/*       */   public final long glTexStorage2D;
/*       */   public final long glTexStorage3D;
/*       */   public final long glDrawTransformFeedbackInstanced;
/*       */   public final long glDrawTransformFeedbackStreamInstanced;
/*       */   public final long glDrawArraysInstancedBaseInstance;
/*       */   public final long glDrawElementsInstancedBaseInstance;
/*       */   public final long glDrawElementsInstancedBaseVertexBaseInstance;
/*       */   public final long glBindImageTexture;
/*       */   public final long glMemoryBarrier;
/*       */   public final long glGetInternalformativ;
/*       */   public final long glClearBufferData;
/*       */   public final long glClearBufferSubData;
/*       */   public final long glDispatchCompute;
/*       */   public final long glDispatchComputeIndirect;
/*       */   public final long glCopyImageSubData;
/*       */   public final long glDebugMessageControl;
/*       */   public final long glDebugMessageInsert;
/*       */   public final long glDebugMessageCallback;
/*       */   public final long glGetDebugMessageLog;
/*       */   public final long glPushDebugGroup;
/*       */   public final long glPopDebugGroup;
/*       */   public final long glObjectLabel;
/*       */   public final long glGetObjectLabel;
/*       */   public final long glObjectPtrLabel;
/*       */   public final long glGetObjectPtrLabel;
/*       */   public final long glFramebufferParameteri;
/*       */   public final long glGetFramebufferParameteriv;
/*       */   public final long glGetInternalformati64v;
/*       */   public final long glInvalidateTexSubImage;
/*       */   public final long glInvalidateTexImage;
/*       */   public final long glInvalidateBufferSubData;
/*       */   public final long glInvalidateBufferData;
/*       */   public final long glInvalidateFramebuffer;
/*       */   public final long glInvalidateSubFramebuffer;
/*       */   public final long glMultiDrawArraysIndirect;
/*       */   public final long glMultiDrawElementsIndirect;
/*       */   public final long glGetProgramInterfaceiv;
/*       */   public final long glGetProgramResourceIndex;
/*       */   public final long glGetProgramResourceName;
/*       */   public final long glGetProgramResourceiv;
/*       */   public final long glGetProgramResourceLocation;
/*       */   public final long glGetProgramResourceLocationIndex;
/*       */   public final long glShaderStorageBlockBinding;
/*       */   public final long glTexBufferRange;
/*       */   public final long glTexStorage2DMultisample;
/*       */   public final long glTexStorage3DMultisample;
/*       */   public final long glTextureView;
/*       */   public final long glBindVertexBuffer;
/*       */   public final long glVertexAttribFormat;
/*       */   public final long glVertexAttribIFormat;
/*       */   public final long glVertexAttribLFormat;
/*       */   public final long glVertexAttribBinding;
/*       */   public final long glVertexBindingDivisor;
/*       */   public final long glBufferStorage;
/*       */   public final long glClearTexSubImage;
/*       */   public final long glClearTexImage;
/*       */   public final long glBindBuffersBase;
/*       */   public final long glBindBuffersRange;
/*       */   public final long glBindTextures;
/*       */   public final long glBindSamplers;
/*       */   public final long glBindImageTextures;
/*       */   public final long glBindVertexBuffers;
/*       */   public final long glClipControl;
/*       */   public final long glCreateTransformFeedbacks;
/*       */   public final long glTransformFeedbackBufferBase;
/*       */   public final long glTransformFeedbackBufferRange;
/*       */   public final long glGetTransformFeedbackiv;
/*       */   public final long glGetTransformFeedbacki_v;
/*       */   public final long glGetTransformFeedbacki64_v;
/*       */   public final long glCreateBuffers;
/*       */   public final long glNamedBufferStorage;
/*       */   public final long glNamedBufferData;
/*       */   public final long glNamedBufferSubData;
/*       */   public final long glCopyNamedBufferSubData;
/*       */   public final long glClearNamedBufferData;
/*       */   public final long glClearNamedBufferSubData;
/*       */   public final long glMapNamedBuffer;
/*       */   public final long glMapNamedBufferRange;
/*       */   public final long glUnmapNamedBuffer;
/*       */   public final long glFlushMappedNamedBufferRange;
/*       */   public final long glGetNamedBufferParameteriv;
/*       */   public final long glGetNamedBufferParameteri64v;
/*       */   public final long glGetNamedBufferPointerv;
/*       */   public final long glGetNamedBufferSubData;
/*       */   public final long glCreateFramebuffers;
/*       */   public final long glNamedFramebufferRenderbuffer;
/*       */   public final long glNamedFramebufferParameteri;
/*       */   public final long glNamedFramebufferTexture;
/*       */   public final long glNamedFramebufferTextureLayer;
/*       */   public final long glNamedFramebufferDrawBuffer;
/*       */   public final long glNamedFramebufferDrawBuffers;
/*       */   public final long glNamedFramebufferReadBuffer;
/*       */   public final long glInvalidateNamedFramebufferData;
/*       */   public final long glInvalidateNamedFramebufferSubData;
/*       */   public final long glClearNamedFramebufferiv;
/*       */   public final long glClearNamedFramebufferuiv;
/*       */   public final long glClearNamedFramebufferfv;
/*       */   public final long glClearNamedFramebufferfi;
/*       */   public final long glBlitNamedFramebuffer;
/*       */   public final long glCheckNamedFramebufferStatus;
/*       */   public final long glGetNamedFramebufferParameteriv;
/*       */   public final long glGetNamedFramebufferAttachmentParameteriv;
/*       */   public final long glCreateRenderbuffers;
/*       */   public final long glNamedRenderbufferStorage;
/*       */   public final long glNamedRenderbufferStorageMultisample;
/*       */   public final long glGetNamedRenderbufferParameteriv;
/*       */   public final long glCreateTextures;
/*       */   public final long glTextureBuffer;
/*       */   public final long glTextureBufferRange;
/*       */   public final long glTextureStorage1D;
/*       */   public final long glTextureStorage2D;
/*       */   public final long glTextureStorage3D;
/*       */   public final long glTextureStorage2DMultisample;
/*       */   public final long glTextureStorage3DMultisample;
/*       */   public final long glTextureSubImage1D;
/*       */   public final long glTextureSubImage2D;
/*       */   public final long glTextureSubImage3D;
/*       */   public final long glCompressedTextureSubImage1D;
/*       */   public final long glCompressedTextureSubImage2D;
/*       */   public final long glCompressedTextureSubImage3D;
/*       */   public final long glCopyTextureSubImage1D;
/*       */   public final long glCopyTextureSubImage2D;
/*       */   public final long glCopyTextureSubImage3D;
/*       */   public final long glTextureParameterf;
/*       */   public final long glTextureParameterfv;
/*       */   public final long glTextureParameteri;
/*       */   public final long glTextureParameterIiv;
/*       */   public final long glTextureParameterIuiv;
/*       */   public final long glTextureParameteriv;
/*       */   public final long glGenerateTextureMipmap;
/*       */   public final long glBindTextureUnit;
/*       */   public final long glGetTextureImage;
/*       */   public final long glGetCompressedTextureImage;
/*       */   public final long glGetTextureLevelParameterfv;
/*       */   public final long glGetTextureLevelParameteriv;
/*       */   public final long glGetTextureParameterfv;
/*       */   public final long glGetTextureParameterIiv;
/*       */   public final long glGetTextureParameterIuiv;
/*       */   public final long glGetTextureParameteriv;
/*       */   public final long glCreateVertexArrays;
/*       */   public final long glDisableVertexArrayAttrib;
/*       */   public final long glEnableVertexArrayAttrib;
/*       */   public final long glVertexArrayElementBuffer;
/*       */   public final long glVertexArrayVertexBuffer;
/*       */   public final long glVertexArrayVertexBuffers;
/*       */   public final long glVertexArrayAttribFormat;
/*       */   public final long glVertexArrayAttribIFormat;
/*       */   public final long glVertexArrayAttribLFormat;
/*       */   public final long glVertexArrayAttribBinding;
/*       */   public final long glVertexArrayBindingDivisor;
/*       */   public final long glGetVertexArrayiv;
/*       */   public final long glGetVertexArrayIndexediv;
/*       */   public final long glGetVertexArrayIndexed64iv;
/*       */   public final long glCreateSamplers;
/*       */   public final long glCreateProgramPipelines;
/*       */   public final long glCreateQueries;
/*       */   public final long glGetQueryBufferObjectiv;
/*       */   public final long glGetQueryBufferObjectuiv;
/*       */   public final long glGetQueryBufferObjecti64v;
/*       */   public final long glGetQueryBufferObjectui64v;
/*       */   public final long glMemoryBarrierByRegion;
/*       */   public final long glGetTextureSubImage;
/*       */   public final long glGetCompressedTextureSubImage;
/*       */   public final long glTextureBarrier;
/*       */   public final long glGetGraphicsResetStatus;
/*       */   public final long glGetnMapdv;
/*       */   public final long glGetnMapfv;
/*       */   public final long glGetnMapiv;
/*       */   public final long glGetnPixelMapfv;
/*       */   public final long glGetnPixelMapuiv;
/*       */   public final long glGetnPixelMapusv;
/*       */   public final long glGetnPolygonStipple;
/*       */   public final long glGetnTexImage;
/*       */   public final long glReadnPixels;
/*       */   public final long glGetnColorTable;
/*       */   public final long glGetnConvolutionFilter;
/*       */   public final long glGetnSeparableFilter;
/*       */   public final long glGetnHistogram;
/*       */   public final long glGetnMinmax;
/*       */   public final long glGetnCompressedTexImage;
/*       */   public final long glGetnUniformfv;
/*       */   public final long glGetnUniformdv;
/*       */   public final long glGetnUniformiv;
/*       */   public final long glGetnUniformuiv;
/*       */   public final long glMultiDrawArraysIndirectCount;
/*       */   public final long glMultiDrawElementsIndirectCount;
/*       */   public final long glPolygonOffsetClamp;
/*       */   public final long glSpecializeShader;
/*       */   public final long glDebugMessageEnableAMD;
/*       */   public final long glDebugMessageInsertAMD;
/*       */   public final long glDebugMessageCallbackAMD;
/*       */   public final long glGetDebugMessageLogAMD;
/*       */   public final long glBlendFuncIndexedAMD;
/*       */   public final long glBlendFuncSeparateIndexedAMD;
/*       */   public final long glBlendEquationIndexedAMD;
/*       */   public final long glBlendEquationSeparateIndexedAMD;
/*       */   public final long glRenderbufferStorageMultisampleAdvancedAMD;
/*       */   public final long glNamedRenderbufferStorageMultisampleAdvancedAMD;
/*       */   public final long glUniform1i64NV;
/*       */   public final long glUniform2i64NV;
/*       */   public final long glUniform3i64NV;
/*       */   public final long glUniform4i64NV;
/*       */   public final long glUniform1i64vNV;
/*       */   public final long glUniform2i64vNV;
/*       */   public final long glUniform3i64vNV;
/*       */   public final long glUniform4i64vNV;
/*       */   public final long glUniform1ui64NV;
/*       */   public final long glUniform2ui64NV;
/*       */   public final long glUniform3ui64NV;
/*       */   public final long glUniform4ui64NV;
/*       */   public final long glUniform1ui64vNV;
/*       */   public final long glUniform2ui64vNV;
/*       */   public final long glUniform3ui64vNV;
/*       */   public final long glUniform4ui64vNV;
/*       */   public final long glGetUniformi64vNV;
/*       */   public final long glGetUniformui64vNV;
/*       */   public final long glProgramUniform1i64NV;
/*       */   public final long glProgramUniform2i64NV;
/*       */   public final long glProgramUniform3i64NV;
/*       */   public final long glProgramUniform4i64NV;
/*       */   public final long glProgramUniform1i64vNV;
/*       */   public final long glProgramUniform2i64vNV;
/*       */   public final long glProgramUniform3i64vNV;
/*       */   public final long glProgramUniform4i64vNV;
/*       */   public final long glProgramUniform1ui64NV;
/*       */   public final long glProgramUniform2ui64NV;
/*       */   public final long glProgramUniform3ui64NV;
/*       */   public final long glProgramUniform4ui64NV;
/*       */   public final long glProgramUniform1ui64vNV;
/*       */   public final long glProgramUniform2ui64vNV;
/*       */   public final long glProgramUniform3ui64vNV;
/*       */   public final long glProgramUniform4ui64vNV;
/*       */   public final long glVertexAttribParameteriAMD;
/*       */   public final long glQueryObjectParameteruiAMD;
/*       */   public final long glGetPerfMonitorGroupsAMD;
/*       */   public final long glGetPerfMonitorCountersAMD;
/*       */   public final long glGetPerfMonitorGroupStringAMD;
/*       */   public final long glGetPerfMonitorCounterStringAMD;
/*       */   public final long glGetPerfMonitorCounterInfoAMD;
/*       */   public final long glGenPerfMonitorsAMD;
/*       */   public final long glDeletePerfMonitorsAMD;
/*       */   public final long glSelectPerfMonitorCountersAMD;
/*       */   public final long glBeginPerfMonitorAMD;
/*       */   public final long glEndPerfMonitorAMD;
/*       */   public final long glGetPerfMonitorCounterDataAMD;
/*       */   public final long glSetMultisamplefvAMD;
/*       */   public final long glTexStorageSparseAMD;
/*       */   public final long glTextureStorageSparseAMD;
/*       */   public final long glStencilOpValueAMD;
/*       */   public final long glTessellationFactorAMD;
/*       */   public final long glTessellationModeAMD;
/*       */   public final long glGetTextureHandleARB;
/*       */   public final long glGetTextureSamplerHandleARB;
/*       */   public final long glMakeTextureHandleResidentARB;
/*       */   public final long glMakeTextureHandleNonResidentARB;
/*       */   public final long glGetImageHandleARB;
/*       */   public final long glMakeImageHandleResidentARB;
/*       */   public final long glMakeImageHandleNonResidentARB;
/*       */   public final long glUniformHandleui64ARB;
/*       */   public final long glUniformHandleui64vARB;
/*       */   public final long glProgramUniformHandleui64ARB;
/*       */   public final long glProgramUniformHandleui64vARB;
/*       */   public final long glIsTextureHandleResidentARB;
/*       */   public final long glIsImageHandleResidentARB;
/*       */   public final long glVertexAttribL1ui64ARB;
/*       */   public final long glVertexAttribL1ui64vARB;
/*       */   public final long glGetVertexAttribLui64vARB;
/*       */   public final long glNamedBufferStorageEXT;
/*       */   public final long glCreateSyncFromCLeventARB;
/*       */   public final long glClearNamedBufferDataEXT;
/*       */   public final long glClearNamedBufferSubDataEXT;
/*       */   public final long glClampColorARB;
/*       */   public final long glDispatchComputeGroupSizeARB;
/*       */   public final long glDebugMessageControlARB;
/*       */   public final long glDebugMessageInsertARB;
/*       */   public final long glDebugMessageCallbackARB;
/*       */   public final long glGetDebugMessageLogARB;
/*       */   public final long glDrawBuffersARB;
/*       */   public final long glBlendEquationiARB;
/*       */   public final long glBlendEquationSeparateiARB;
/*       */   public final long glBlendFunciARB;
/*       */   public final long glBlendFuncSeparateiARB;
/*       */   public final long glDrawArraysInstancedARB;
/*       */   public final long glDrawElementsInstancedARB;
/*       */   public final long glPrimitiveBoundingBoxARB;
/*       */   public final long glNamedFramebufferParameteriEXT;
/*       */   public final long glGetNamedFramebufferParameterivEXT;
/*       */   public final long glProgramParameteriARB;
/*       */   public final long glFramebufferTextureARB;
/*       */   public final long glFramebufferTextureLayerARB;
/*       */   public final long glFramebufferTextureFaceARB;
/*       */   public final long glSpecializeShaderARB;
/*       */   public final long glProgramUniform1dEXT;
/*       */   public final long glProgramUniform2dEXT;
/*       */   public final long glProgramUniform3dEXT;
/*       */   public final long glProgramUniform4dEXT;
/*       */   public final long glProgramUniform1dvEXT;
/*       */   public final long glProgramUniform2dvEXT;
/*       */   public final long glProgramUniform3dvEXT;
/*       */   public final long glProgramUniform4dvEXT;
/*       */   public final long glProgramUniformMatrix2dvEXT;
/*       */   public final long glProgramUniformMatrix3dvEXT;
/*       */   public final long glProgramUniformMatrix4dvEXT;
/*       */   public final long glProgramUniformMatrix2x3dvEXT;
/*       */   public final long glProgramUniformMatrix2x4dvEXT;
/*       */   public final long glProgramUniformMatrix3x2dvEXT;
/*       */   public final long glProgramUniformMatrix3x4dvEXT;
/*       */   public final long glProgramUniformMatrix4x2dvEXT;
/*       */   public final long glProgramUniformMatrix4x3dvEXT;
/*       */   public final long glUniform1i64ARB;
/*       */   public final long glUniform1i64vARB;
/*       */   public final long glProgramUniform1i64ARB;
/*       */   public final long glProgramUniform1i64vARB;
/*       */   public final long glUniform2i64ARB;
/*       */   public final long glUniform2i64vARB;
/*       */   public final long glProgramUniform2i64ARB;
/*       */   public final long glProgramUniform2i64vARB;
/*       */   public final long glUniform3i64ARB;
/*       */   public final long glUniform3i64vARB;
/*       */   public final long glProgramUniform3i64ARB;
/*       */   public final long glProgramUniform3i64vARB;
/*       */   public final long glUniform4i64ARB;
/*       */   public final long glUniform4i64vARB;
/*       */   public final long glProgramUniform4i64ARB;
/*       */   public final long glProgramUniform4i64vARB;
/*       */   public final long glUniform1ui64ARB;
/*       */   public final long glUniform1ui64vARB;
/*       */   public final long glProgramUniform1ui64ARB;
/*       */   public final long glProgramUniform1ui64vARB;
/*       */   public final long glUniform2ui64ARB;
/*       */   public final long glUniform2ui64vARB;
/*       */   public final long glProgramUniform2ui64ARB;
/*       */   public final long glProgramUniform2ui64vARB;
/*       */   public final long glUniform3ui64ARB;
/*       */   public final long glUniform3ui64vARB;
/*       */   public final long glProgramUniform3ui64ARB;
/*       */   public final long glProgramUniform3ui64vARB;
/*       */   public final long glUniform4ui64ARB;
/*       */   public final long glUniform4ui64vARB;
/*       */   public final long glProgramUniform4ui64ARB;
/*       */   public final long glProgramUniform4ui64vARB;
/*       */   public final long glGetUniformi64vARB;
/*       */   public final long glGetUniformui64vARB;
/*       */   public final long glGetnUniformi64vARB;
/*       */   public final long glGetnUniformui64vARB;
/*       */   public final long glColorTable;
/*       */   public final long glCopyColorTable;
/*       */   public final long glColorTableParameteriv;
/*       */   public final long glColorTableParameterfv;
/*       */   public final long glGetColorTable;
/*       */   public final long glGetColorTableParameteriv;
/*       */   public final long glGetColorTableParameterfv;
/*       */   public final long glColorSubTable;
/*       */   public final long glCopyColorSubTable;
/*       */   public final long glConvolutionFilter1D;
/*       */   public final long glConvolutionFilter2D;
/*       */   public final long glCopyConvolutionFilter1D;
/*       */   public final long glCopyConvolutionFilter2D;
/*       */   public final long glGetConvolutionFilter;
/*       */   public final long glSeparableFilter2D;
/*       */   public final long glGetSeparableFilter;
/*       */   public final long glConvolutionParameteri;
/*       */   public final long glConvolutionParameteriv;
/*       */   public final long glConvolutionParameterf;
/*       */   public final long glConvolutionParameterfv;
/*       */   public final long glGetConvolutionParameteriv;
/*       */   public final long glGetConvolutionParameterfv;
/*       */   public final long glHistogram;
/*       */   public final long glResetHistogram;
/*       */   public final long glGetHistogram;
/*       */   public final long glGetHistogramParameteriv;
/*       */   public final long glGetHistogramParameterfv;
/*       */   public final long glMinmax;
/*       */   public final long glResetMinmax;
/*       */   public final long glGetMinmax;
/*       */   public final long glGetMinmaxParameteriv;
/*       */   public final long glGetMinmaxParameterfv;
/*       */   public final long glMultiDrawArraysIndirectCountARB;
/*       */   public final long glMultiDrawElementsIndirectCountARB;
/*       */   public final long glVertexAttribDivisorARB;
/*       */   public final long glVertexArrayVertexAttribDivisorEXT;
/*       */   public final long glCurrentPaletteMatrixARB;
/*       */   public final long glMatrixIndexuivARB;
/*       */   public final long glMatrixIndexubvARB;
/*       */   public final long glMatrixIndexusvARB;
/*       */   public final long glMatrixIndexPointerARB;
/*       */   public final long glSampleCoverageARB;
/*       */   public final long glActiveTextureARB;
/*       */   public final long glClientActiveTextureARB;
/*       */   public final long glMultiTexCoord1fARB;
/*       */   public final long glMultiTexCoord1sARB;
/*       */   public final long glMultiTexCoord1iARB;
/*       */   public final long glMultiTexCoord1dARB;
/*       */   public final long glMultiTexCoord1fvARB;
/*       */   public final long glMultiTexCoord1svARB;
/*       */   public final long glMultiTexCoord1ivARB;
/*       */   public final long glMultiTexCoord1dvARB;
/*       */   public final long glMultiTexCoord2fARB;
/*       */   public final long glMultiTexCoord2sARB;
/*       */   public final long glMultiTexCoord2iARB;
/*       */   public final long glMultiTexCoord2dARB;
/*       */   public final long glMultiTexCoord2fvARB;
/*       */   public final long glMultiTexCoord2svARB;
/*       */   public final long glMultiTexCoord2ivARB;
/*       */   public final long glMultiTexCoord2dvARB;
/*       */   public final long glMultiTexCoord3fARB;
/*       */   public final long glMultiTexCoord3sARB;
/*       */   public final long glMultiTexCoord3iARB;
/*       */   public final long glMultiTexCoord3dARB;
/*       */   public final long glMultiTexCoord3fvARB;
/*       */   public final long glMultiTexCoord3svARB;
/*       */   public final long glMultiTexCoord3ivARB;
/*       */   public final long glMultiTexCoord3dvARB;
/*       */   public final long glMultiTexCoord4fARB;
/*       */   public final long glMultiTexCoord4sARB;
/*       */   public final long glMultiTexCoord4iARB;
/*       */   public final long glMultiTexCoord4dARB;
/*       */   public final long glMultiTexCoord4fvARB;
/*       */   public final long glMultiTexCoord4svARB;
/*       */   public final long glMultiTexCoord4ivARB;
/*       */   public final long glMultiTexCoord4dvARB;
/*       */   public final long glGenQueriesARB;
/*       */   public final long glDeleteQueriesARB;
/*       */   public final long glIsQueryARB;
/*       */   public final long glBeginQueryARB;
/*       */   public final long glEndQueryARB;
/*       */   public final long glGetQueryivARB;
/*       */   public final long glGetQueryObjectivARB;
/*       */   public final long glGetQueryObjectuivARB;
/*       */   public final long glMaxShaderCompilerThreadsARB;
/*       */   public final long glPointParameterfARB;
/*       */   public final long glPointParameterfvARB;
/*       */   public final long glGetGraphicsResetStatusARB;
/*       */   public final long glGetnMapdvARB;
/*       */   public final long glGetnMapfvARB;
/*       */   public final long glGetnMapivARB;
/*       */   public final long glGetnPixelMapfvARB;
/*       */   public final long glGetnPixelMapuivARB;
/*       */   public final long glGetnPixelMapusvARB;
/*       */   public final long glGetnPolygonStippleARB;
/*       */   public final long glGetnTexImageARB;
/*       */   public final long glReadnPixelsARB;
/*       */   public final long glGetnColorTableARB;
/*       */   public final long glGetnConvolutionFilterARB;
/*       */   public final long glGetnSeparableFilterARB;
/*       */   public final long glGetnHistogramARB;
/*       */   public final long glGetnMinmaxARB;
/*       */   public final long glGetnCompressedTexImageARB;
/*       */   public final long glGetnUniformfvARB;
/*       */   public final long glGetnUniformivARB;
/*       */   public final long glGetnUniformuivARB;
/*       */   public final long glGetnUniformdvARB;
/*       */   public final long glFramebufferSampleLocationsfvARB;
/*       */   public final long glNamedFramebufferSampleLocationsfvARB;
/*       */   public final long glEvaluateDepthValuesARB;
/*       */   public final long glMinSampleShadingARB;
/*       */   public final long glDeleteObjectARB;
/*       */   public final long glGetHandleARB;
/*       */   public final long glDetachObjectARB;
/*       */   public final long glCreateShaderObjectARB;
/*       */   public final long glShaderSourceARB;
/*       */   public final long glCompileShaderARB;
/*       */   public final long glCreateProgramObjectARB;
/*       */   public final long glAttachObjectARB;
/*       */   public final long glLinkProgramARB;
/*       */   public final long glUseProgramObjectARB;
/*       */   public final long glValidateProgramARB;
/*       */   public final long glUniform1fARB;
/*       */   public final long glUniform2fARB;
/*       */   public final long glUniform3fARB;
/*       */   public final long glUniform4fARB;
/*       */   public final long glUniform1iARB;
/*       */   public final long glUniform2iARB;
/*       */   public final long glUniform3iARB;
/*       */   public final long glUniform4iARB;
/*       */   public final long glUniform1fvARB;
/*       */   public final long glUniform2fvARB;
/*       */   public final long glUniform3fvARB;
/*       */   public final long glUniform4fvARB;
/*       */   public final long glUniform1ivARB;
/*       */   public final long glUniform2ivARB;
/*       */   public final long glUniform3ivARB;
/*       */   public final long glUniform4ivARB;
/*       */   public final long glUniformMatrix2fvARB;
/*       */   public final long glUniformMatrix3fvARB;
/*       */   public final long glUniformMatrix4fvARB;
/*       */   public final long glGetObjectParameterfvARB;
/*       */   public final long glGetObjectParameterivARB;
/*       */   public final long glGetInfoLogARB;
/*       */   public final long glGetAttachedObjectsARB;
/*       */   public final long glGetUniformLocationARB;
/*       */   public final long glGetActiveUniformARB;
/*       */   public final long glGetUniformfvARB;
/*       */   public final long glGetUniformivARB;
/*       */   public final long glGetShaderSourceARB;
/*       */   public final long glNamedStringARB;
/*       */   public final long glDeleteNamedStringARB;
/*       */   public final long glCompileShaderIncludeARB;
/*       */   public final long glIsNamedStringARB;
/*       */   public final long glGetNamedStringARB;
/*       */   public final long glGetNamedStringivARB;
/*       */   public final long glBufferPageCommitmentARB;
/*       */   public final long glNamedBufferPageCommitmentEXT;
/*       */   public final long glNamedBufferPageCommitmentARB;
/*       */   public final long glTexPageCommitmentARB;
/*       */   public final long glTexturePageCommitmentEXT;
/*       */   public final long glTexBufferARB;
/*       */   public final long glTextureBufferRangeEXT;
/*       */   public final long glCompressedTexImage3DARB;
/*       */   public final long glCompressedTexImage2DARB;
/*       */   public final long glCompressedTexImage1DARB;
/*       */   public final long glCompressedTexSubImage3DARB;
/*       */   public final long glCompressedTexSubImage2DARB;
/*       */   public final long glCompressedTexSubImage1DARB;
/*       */   public final long glGetCompressedTexImageARB;
/*       */   public final long glTextureStorage1DEXT;
/*       */   public final long glTextureStorage2DEXT;
/*       */   public final long glTextureStorage3DEXT;
/*       */   public final long glTextureStorage2DMultisampleEXT;
/*       */   public final long glTextureStorage3DMultisampleEXT;
/*       */   public final long glLoadTransposeMatrixfARB;
/*       */   public final long glLoadTransposeMatrixdARB;
/*       */   public final long glMultTransposeMatrixfARB;
/*       */   public final long glMultTransposeMatrixdARB;
/*       */   public final long glVertexArrayVertexAttribLOffsetEXT;
/*       */   public final long glVertexArrayBindVertexBufferEXT;
/*       */   public final long glVertexArrayVertexAttribFormatEXT;
/*       */   public final long glVertexArrayVertexAttribIFormatEXT;
/*       */   public final long glVertexArrayVertexAttribLFormatEXT;
/*       */   public final long glVertexArrayVertexAttribBindingEXT;
/*       */   public final long glVertexArrayVertexBindingDivisorEXT;
/*       */   public final long glWeightfvARB;
/*       */   public final long glWeightbvARB;
/*       */   public final long glWeightubvARB;
/*       */   public final long glWeightsvARB;
/*       */   public final long glWeightusvARB;
/*       */   public final long glWeightivARB;
/*       */   public final long glWeightuivARB;
/*       */   public final long glWeightdvARB;
/*       */   public final long glWeightPointerARB;
/*       */   public final long glVertexBlendARB;
/*       */   public final long glBindBufferARB;
/*       */   public final long glDeleteBuffersARB;
/*       */   public final long glGenBuffersARB;
/*       */   public final long glIsBufferARB;
/*       */   public final long glBufferDataARB;
/*       */   public final long glBufferSubDataARB;
/*       */   public final long glGetBufferSubDataARB;
/*       */   public final long glMapBufferARB;
/*       */   public final long glUnmapBufferARB;
/*       */   public final long glGetBufferParameterivARB;
/*       */   public final long glGetBufferPointervARB;
/*       */   public final long glVertexAttrib1sARB;
/*       */   public final long glVertexAttrib1fARB;
/*       */   public final long glVertexAttrib1dARB;
/*       */   public final long glVertexAttrib2sARB;
/*       */   public final long glVertexAttrib2fARB;
/*       */   public final long glVertexAttrib2dARB;
/*       */   public final long glVertexAttrib3sARB;
/*       */   public final long glVertexAttrib3fARB;
/*       */   public final long glVertexAttrib3dARB;
/*       */   public final long glVertexAttrib4sARB;
/*       */   public final long glVertexAttrib4fARB;
/*       */   public final long glVertexAttrib4dARB;
/*       */   public final long glVertexAttrib4NubARB;
/*       */   public final long glVertexAttrib1svARB;
/*       */   public final long glVertexAttrib1fvARB;
/*       */   public final long glVertexAttrib1dvARB;
/*       */   public final long glVertexAttrib2svARB;
/*       */   public final long glVertexAttrib2fvARB;
/*       */   public final long glVertexAttrib2dvARB;
/*       */   public final long glVertexAttrib3svARB;
/*       */   public final long glVertexAttrib3fvARB;
/*       */   public final long glVertexAttrib3dvARB;
/*       */   public final long glVertexAttrib4fvARB;
/*       */   public final long glVertexAttrib4bvARB;
/*       */   public final long glVertexAttrib4svARB;
/*       */   public final long glVertexAttrib4ivARB;
/*       */   public final long glVertexAttrib4ubvARB;
/*       */   public final long glVertexAttrib4usvARB;
/*       */   public final long glVertexAttrib4uivARB;
/*       */   public final long glVertexAttrib4dvARB;
/*       */   public final long glVertexAttrib4NbvARB;
/*       */   public final long glVertexAttrib4NsvARB;
/*       */   public final long glVertexAttrib4NivARB;
/*       */   public final long glVertexAttrib4NubvARB;
/*       */   public final long glVertexAttrib4NusvARB;
/*       */   public final long glVertexAttrib4NuivARB;
/*       */   public final long glVertexAttribPointerARB;
/*       */   public final long glEnableVertexAttribArrayARB;
/*       */   public final long glDisableVertexAttribArrayARB;
/*       */   public final long glProgramStringARB;
/*       */   public final long glBindProgramARB;
/*       */   public final long glDeleteProgramsARB;
/*       */   public final long glGenProgramsARB;
/*       */   public final long glProgramEnvParameter4dARB;
/*       */   public final long glProgramEnvParameter4dvARB;
/*       */   public final long glProgramEnvParameter4fARB;
/*       */   public final long glProgramEnvParameter4fvARB;
/*       */   public final long glProgramLocalParameter4dARB;
/*       */   public final long glProgramLocalParameter4dvARB;
/*       */   public final long glProgramLocalParameter4fARB;
/*       */   public final long glProgramLocalParameter4fvARB;
/*       */   public final long glGetProgramEnvParameterfvARB;
/*       */   public final long glGetProgramEnvParameterdvARB;
/*       */   public final long glGetProgramLocalParameterfvARB;
/*       */   public final long glGetProgramLocalParameterdvARB;
/*       */   public final long glGetProgramivARB;
/*       */   public final long glGetProgramStringARB;
/*       */   public final long glGetVertexAttribfvARB;
/*       */   public final long glGetVertexAttribdvARB;
/*       */   public final long glGetVertexAttribivARB;
/*       */   public final long glGetVertexAttribPointervARB;
/*       */   public final long glIsProgramARB;
/*       */   public final long glBindAttribLocationARB;
/*       */   public final long glGetActiveAttribARB;
/*       */   public final long glGetAttribLocationARB;
/*       */   public final long glWindowPos2iARB;
/*       */   public final long glWindowPos2sARB;
/*       */   public final long glWindowPos2fARB;
/*       */   public final long glWindowPos2dARB;
/*       */   public final long glWindowPos2ivARB;
/*       */   public final long glWindowPos2svARB;
/*       */   public final long glWindowPos2fvARB;
/*       */   public final long glWindowPos2dvARB;
/*       */   public final long glWindowPos3iARB;
/*       */   public final long glWindowPos3sARB;
/*       */   public final long glWindowPos3fARB;
/*       */   public final long glWindowPos3dARB;
/*       */   public final long glWindowPos3ivARB;
/*       */   public final long glWindowPos3svARB;
/*       */   public final long glWindowPos3fvARB;
/*       */   public final long glWindowPos3dvARB;
/*       */   public final long glUniformBufferEXT;
/*       */   public final long glGetUniformBufferSizeEXT;
/*       */   public final long glGetUniformOffsetEXT;
/*       */   public final long glBlendColorEXT;
/*       */   public final long glBlendEquationSeparateEXT;
/*       */   public final long glBlendFuncSeparateEXT;
/*       */   public final long glBlendEquationEXT;
/*       */   public final long glLockArraysEXT;
/*       */   public final long glUnlockArraysEXT;
/*       */   public final long glLabelObjectEXT;
/*       */   public final long glGetObjectLabelEXT;
/*       */   public final long glInsertEventMarkerEXT;
/*       */   public final long glPushGroupMarkerEXT;
/*       */   public final long glPopGroupMarkerEXT;
/*       */   public final long glDepthBoundsEXT;
/*       */   public final long glClientAttribDefaultEXT;
/*       */   public final long glPushClientAttribDefaultEXT;
/*       */   public final long glMatrixLoadfEXT;
/*       */   public final long glMatrixLoaddEXT;
/*       */   public final long glMatrixMultfEXT;
/*       */   public final long glMatrixMultdEXT;
/*       */   public final long glMatrixLoadIdentityEXT;
/*       */   public final long glMatrixRotatefEXT;
/*       */   public final long glMatrixRotatedEXT;
/*       */   public final long glMatrixScalefEXT;
/*       */   public final long glMatrixScaledEXT;
/*       */   public final long glMatrixTranslatefEXT;
/*       */   public final long glMatrixTranslatedEXT;
/*       */   public final long glMatrixOrthoEXT;
/*       */   public final long glMatrixFrustumEXT;
/*       */   public final long glMatrixPushEXT;
/*       */   public final long glMatrixPopEXT;
/*       */   public final long glTextureParameteriEXT;
/*       */   public final long glTextureParameterivEXT;
/*       */   public final long glTextureParameterfEXT;
/*       */   public final long glTextureParameterfvEXT;
/*       */   public final long glTextureImage1DEXT;
/*       */   public final long glTextureImage2DEXT;
/*       */   public final long glTextureSubImage1DEXT;
/*       */   public final long glTextureSubImage2DEXT;
/*       */   public final long glCopyTextureImage1DEXT;
/*       */   public final long glCopyTextureImage2DEXT;
/*       */   public final long glCopyTextureSubImage1DEXT;
/*       */   public final long glCopyTextureSubImage2DEXT;
/*       */   public final long glGetTextureImageEXT;
/*       */   public final long glGetTextureParameterfvEXT;
/*       */   public final long glGetTextureParameterivEXT;
/*       */   public final long glGetTextureLevelParameterfvEXT;
/*       */   public final long glGetTextureLevelParameterivEXT;
/*       */   public final long glTextureImage3DEXT;
/*       */   public final long glTextureSubImage3DEXT;
/*       */   public final long glCopyTextureSubImage3DEXT;
/*       */   public final long glBindMultiTextureEXT;
/*       */   public final long glMultiTexCoordPointerEXT;
/*       */   public final long glMultiTexEnvfEXT;
/*       */   public final long glMultiTexEnvfvEXT;
/*       */   public final long glMultiTexEnviEXT;
/*       */   public final long glMultiTexEnvivEXT;
/*       */   public final long glMultiTexGendEXT;
/*       */   public final long glMultiTexGendvEXT;
/*       */   public final long glMultiTexGenfEXT;
/*       */   public final long glMultiTexGenfvEXT;
/*       */   public final long glMultiTexGeniEXT;
/*       */   public final long glMultiTexGenivEXT;
/*       */   public final long glGetMultiTexEnvfvEXT;
/*       */   public final long glGetMultiTexEnvivEXT;
/*       */   public final long glGetMultiTexGendvEXT;
/*       */   public final long glGetMultiTexGenfvEXT;
/*       */   public final long glGetMultiTexGenivEXT;
/*       */   public final long glMultiTexParameteriEXT;
/*       */   public final long glMultiTexParameterivEXT;
/*       */   public final long glMultiTexParameterfEXT;
/*       */   public final long glMultiTexParameterfvEXT;
/*       */   public final long glMultiTexImage1DEXT;
/*       */   public final long glMultiTexImage2DEXT;
/*       */   public final long glMultiTexSubImage1DEXT;
/*       */   public final long glMultiTexSubImage2DEXT;
/*       */   public final long glCopyMultiTexImage1DEXT;
/*       */   public final long glCopyMultiTexImage2DEXT;
/*       */   public final long glCopyMultiTexSubImage1DEXT;
/*       */   public final long glCopyMultiTexSubImage2DEXT;
/*       */   public final long glGetMultiTexImageEXT;
/*       */   public final long glGetMultiTexParameterfvEXT;
/*       */   public final long glGetMultiTexParameterivEXT;
/*       */   public final long glGetMultiTexLevelParameterfvEXT;
/*       */   public final long glGetMultiTexLevelParameterivEXT;
/*       */   public final long glMultiTexImage3DEXT;
/*       */   public final long glMultiTexSubImage3DEXT;
/*       */   public final long glCopyMultiTexSubImage3DEXT;
/*       */   public final long glEnableClientStateIndexedEXT;
/*       */   public final long glDisableClientStateIndexedEXT;
/*       */   public final long glEnableClientStateiEXT;
/*       */   public final long glDisableClientStateiEXT;
/*       */   public final long glGetFloatIndexedvEXT;
/*       */   public final long glGetDoubleIndexedvEXT;
/*       */   public final long glGetPointerIndexedvEXT;
/*       */   public final long glGetFloati_vEXT;
/*       */   public final long glGetDoublei_vEXT;
/*       */   public final long glGetPointeri_vEXT;
/*       */   public final long glEnableIndexedEXT;
/*       */   public final long glDisableIndexedEXT;
/*       */   public final long glIsEnabledIndexedEXT;
/*       */   public final long glGetIntegerIndexedvEXT;
/*       */   public final long glGetBooleanIndexedvEXT;
/*       */   public final long glNamedProgramStringEXT;
/*       */   public final long glNamedProgramLocalParameter4dEXT;
/*       */   public final long glNamedProgramLocalParameter4dvEXT;
/*       */   public final long glNamedProgramLocalParameter4fEXT;
/*       */   public final long glNamedProgramLocalParameter4fvEXT;
/*       */   public final long glGetNamedProgramLocalParameterdvEXT;
/*       */   public final long glGetNamedProgramLocalParameterfvEXT;
/*       */   public final long glGetNamedProgramivEXT;
/*       */   public final long glGetNamedProgramStringEXT;
/*       */   public final long glCompressedTextureImage3DEXT;
/*       */   public final long glCompressedTextureImage2DEXT;
/*       */   public final long glCompressedTextureImage1DEXT;
/*       */   public final long glCompressedTextureSubImage3DEXT;
/*       */   public final long glCompressedTextureSubImage2DEXT;
/*       */   public final long glCompressedTextureSubImage1DEXT;
/*       */   public final long glGetCompressedTextureImageEXT;
/*       */   public final long glCompressedMultiTexImage3DEXT;
/*       */   public final long glCompressedMultiTexImage2DEXT;
/*       */   public final long glCompressedMultiTexImage1DEXT;
/*       */   public final long glCompressedMultiTexSubImage3DEXT;
/*       */   public final long glCompressedMultiTexSubImage2DEXT;
/*       */   public final long glCompressedMultiTexSubImage1DEXT;
/*       */   public final long glGetCompressedMultiTexImageEXT;
/*       */   public final long glMatrixLoadTransposefEXT;
/*       */   public final long glMatrixLoadTransposedEXT;
/*       */   public final long glMatrixMultTransposefEXT;
/*       */   public final long glMatrixMultTransposedEXT;
/*       */   public final long glNamedBufferDataEXT;
/*       */   public final long glNamedBufferSubDataEXT;
/*       */   public final long glMapNamedBufferEXT;
/*       */   public final long glUnmapNamedBufferEXT;
/*       */   public final long glGetNamedBufferParameterivEXT;
/*       */   public final long glGetNamedBufferSubDataEXT;
/*       */   public final long glProgramUniform1fEXT;
/*       */   public final long glProgramUniform2fEXT;
/*       */   public final long glProgramUniform3fEXT;
/*       */   public final long glProgramUniform4fEXT;
/*       */   public final long glProgramUniform1iEXT;
/*       */   public final long glProgramUniform2iEXT;
/*       */   public final long glProgramUniform3iEXT;
/*       */   public final long glProgramUniform4iEXT;
/*       */   public final long glProgramUniform1fvEXT;
/*       */   public final long glProgramUniform2fvEXT;
/*       */   public final long glProgramUniform3fvEXT;
/*       */   public final long glProgramUniform4fvEXT;
/*       */   public final long glProgramUniform1ivEXT;
/*       */   public final long glProgramUniform2ivEXT;
/*       */   public final long glProgramUniform3ivEXT;
/*       */   public final long glProgramUniform4ivEXT;
/*       */   public final long glProgramUniformMatrix2fvEXT;
/*       */   public final long glProgramUniformMatrix3fvEXT;
/*       */   public final long glProgramUniformMatrix4fvEXT;
/*       */   public final long glProgramUniformMatrix2x3fvEXT;
/*       */   public final long glProgramUniformMatrix3x2fvEXT;
/*       */   public final long glProgramUniformMatrix2x4fvEXT;
/*       */   public final long glProgramUniformMatrix4x2fvEXT;
/*       */   public final long glProgramUniformMatrix3x4fvEXT;
/*       */   public final long glProgramUniformMatrix4x3fvEXT;
/*       */   public final long glTextureBufferEXT;
/*       */   public final long glMultiTexBufferEXT;
/*       */   public final long glTextureParameterIivEXT;
/*       */   public final long glTextureParameterIuivEXT;
/*       */   public final long glGetTextureParameterIivEXT;
/*       */   public final long glGetTextureParameterIuivEXT;
/*       */   public final long glMultiTexParameterIivEXT;
/*       */   public final long glMultiTexParameterIuivEXT;
/*       */   public final long glGetMultiTexParameterIivEXT;
/*       */   public final long glGetMultiTexParameterIuivEXT;
/*       */   public final long glProgramUniform1uiEXT;
/*       */   public final long glProgramUniform2uiEXT;
/*       */   public final long glProgramUniform3uiEXT;
/*       */   public final long glProgramUniform4uiEXT;
/*       */   public final long glProgramUniform1uivEXT;
/*       */   public final long glProgramUniform2uivEXT;
/*       */   public final long glProgramUniform3uivEXT;
/*       */   public final long glProgramUniform4uivEXT;
/*       */   public final long glNamedProgramLocalParameters4fvEXT;
/*       */   public final long glNamedProgramLocalParameterI4iEXT;
/*       */   public final long glNamedProgramLocalParameterI4ivEXT;
/*       */   public final long glNamedProgramLocalParametersI4ivEXT;
/*       */   public final long glNamedProgramLocalParameterI4uiEXT;
/*       */   public final long glNamedProgramLocalParameterI4uivEXT;
/*       */   public final long glNamedProgramLocalParametersI4uivEXT;
/*       */   public final long glGetNamedProgramLocalParameterIivEXT;
/*       */   public final long glGetNamedProgramLocalParameterIuivEXT;
/*       */   public final long glNamedRenderbufferStorageEXT;
/*       */   public final long glGetNamedRenderbufferParameterivEXT;
/*       */   public final long glNamedRenderbufferStorageMultisampleEXT;
/*       */   public final long glNamedRenderbufferStorageMultisampleCoverageEXT;
/*       */   public final long glCheckNamedFramebufferStatusEXT;
/*       */   public final long glNamedFramebufferTexture1DEXT;
/*       */   public final long glNamedFramebufferTexture2DEXT;
/*       */   public final long glNamedFramebufferTexture3DEXT;
/*       */   public final long glNamedFramebufferRenderbufferEXT;
/*       */   public final long glGetNamedFramebufferAttachmentParameterivEXT;
/*       */   public final long glGenerateTextureMipmapEXT;
/*       */   public final long glGenerateMultiTexMipmapEXT;
/*       */   public final long glFramebufferDrawBufferEXT;
/*       */   public final long glFramebufferDrawBuffersEXT;
/*       */   public final long glFramebufferReadBufferEXT;
/*       */   public final long glGetFramebufferParameterivEXT;
/*       */   public final long glNamedCopyBufferSubDataEXT;
/*       */   public final long glNamedFramebufferTextureEXT;
/*       */   public final long glNamedFramebufferTextureLayerEXT;
/*       */   public final long glNamedFramebufferTextureFaceEXT;
/*       */   public final long glTextureRenderbufferEXT;
/*       */   public final long glMultiTexRenderbufferEXT;
/*       */   public final long glVertexArrayVertexOffsetEXT;
/*       */   public final long glVertexArrayColorOffsetEXT;
/*       */   public final long glVertexArrayEdgeFlagOffsetEXT;
/*       */   public final long glVertexArrayIndexOffsetEXT;
/*       */   public final long glVertexArrayNormalOffsetEXT;
/*       */   public final long glVertexArrayTexCoordOffsetEXT;
/*       */   public final long glVertexArrayMultiTexCoordOffsetEXT;
/*       */   public final long glVertexArrayFogCoordOffsetEXT;
/*       */   public final long glVertexArraySecondaryColorOffsetEXT;
/*       */   public final long glVertexArrayVertexAttribOffsetEXT;
/*       */   public final long glVertexArrayVertexAttribIOffsetEXT;
/*       */   public final long glEnableVertexArrayEXT;
/*       */   public final long glDisableVertexArrayEXT;
/*       */   public final long glEnableVertexArrayAttribEXT;
/*       */   public final long glDisableVertexArrayAttribEXT;
/*       */   public final long glGetVertexArrayIntegervEXT;
/*       */   public final long glGetVertexArrayPointervEXT;
/*       */   public final long glGetVertexArrayIntegeri_vEXT;
/*       */   public final long glGetVertexArrayPointeri_vEXT;
/*       */   public final long glMapNamedBufferRangeEXT;
/*       */   public final long glFlushMappedNamedBufferRangeEXT;
/*       */   public final long glColorMaskIndexedEXT;
/*       */   public final long glDrawArraysInstancedEXT;
/*       */   public final long glDrawElementsInstancedEXT;
/*       */   public final long glEGLImageTargetTexStorageEXT;
/*       */   public final long glEGLImageTargetTextureStorageEXT;
/*       */   public final long glBufferStorageExternalEXT;
/*       */   public final long glNamedBufferStorageExternalEXT;
/*       */   public final long glBlitFramebufferEXT;
/*       */   public final long glBlitFramebufferLayersEXT;
/*       */   public final long glBlitFramebufferLayerEXT;
/*       */   public final long glRenderbufferStorageMultisampleEXT;
/*       */   public final long glIsRenderbufferEXT;
/*       */   public final long glBindRenderbufferEXT;
/*       */   public final long glDeleteRenderbuffersEXT;
/*       */   public final long glGenRenderbuffersEXT;
/*       */   public final long glRenderbufferStorageEXT;
/*       */   public final long glGetRenderbufferParameterivEXT;
/*       */   public final long glIsFramebufferEXT;
/*       */   public final long glBindFramebufferEXT;
/*       */   public final long glDeleteFramebuffersEXT;
/*       */   public final long glGenFramebuffersEXT;
/*       */   public final long glCheckFramebufferStatusEXT;
/*       */   public final long glFramebufferTexture1DEXT;
/*       */   public final long glFramebufferTexture2DEXT;
/*       */   public final long glFramebufferTexture3DEXT;
/*       */   public final long glFramebufferRenderbufferEXT;
/*       */   public final long glGetFramebufferAttachmentParameterivEXT;
/*       */   public final long glGenerateMipmapEXT;
/*       */   public final long glProgramParameteriEXT;
/*       */   public final long glFramebufferTextureEXT;
/*       */   public final long glFramebufferTextureLayerEXT;
/*       */   public final long glFramebufferTextureFaceEXT;
/*       */   public final long glProgramEnvParameters4fvEXT;
/*       */   public final long glProgramLocalParameters4fvEXT;
/*       */   public final long glVertexAttribI1iEXT;
/*       */   public final long glVertexAttribI2iEXT;
/*       */   public final long glVertexAttribI3iEXT;
/*       */   public final long glVertexAttribI4iEXT;
/*       */   public final long glVertexAttribI1uiEXT;
/*       */   public final long glVertexAttribI2uiEXT;
/*       */   public final long glVertexAttribI3uiEXT;
/*       */   public final long glVertexAttribI4uiEXT;
/*       */   public final long glVertexAttribI1ivEXT;
/*       */   public final long glVertexAttribI2ivEXT;
/*       */   public final long glVertexAttribI3ivEXT;
/*       */   public final long glVertexAttribI4ivEXT;
/*       */   public final long glVertexAttribI1uivEXT;
/*       */   public final long glVertexAttribI2uivEXT;
/*       */   public final long glVertexAttribI3uivEXT;
/*       */   public final long glVertexAttribI4uivEXT;
/*       */   public final long glVertexAttribI4bvEXT;
/*       */   public final long glVertexAttribI4svEXT;
/*       */   public final long glVertexAttribI4ubvEXT;
/*       */   public final long glVertexAttribI4usvEXT;
/*       */   public final long glVertexAttribIPointerEXT;
/*       */   public final long glGetVertexAttribIivEXT;
/*       */   public final long glGetVertexAttribIuivEXT;
/*       */   public final long glGetUniformuivEXT;
/*       */   public final long glBindFragDataLocationEXT;
/*       */   public final long glGetFragDataLocationEXT;
/*       */   public final long glUniform1uiEXT;
/*       */   public final long glUniform2uiEXT;
/*       */   public final long glUniform3uiEXT;
/*       */   public final long glUniform4uiEXT;
/*       */   public final long glUniform1uivEXT;
/*       */   public final long glUniform2uivEXT;
/*       */   public final long glUniform3uivEXT;
/*       */   public final long glUniform4uivEXT;
/*       */   public final long glGetUnsignedBytevEXT;
/*       */   public final long glGetUnsignedBytei_vEXT;
/*       */   public final long glDeleteMemoryObjectsEXT;
/*       */   public final long glIsMemoryObjectEXT;
/*       */   public final long glCreateMemoryObjectsEXT;
/*       */   public final long glMemoryObjectParameterivEXT;
/*       */   public final long glGetMemoryObjectParameterivEXT;
/*       */   public final long glTexStorageMem2DEXT;
/*       */   public final long glTexStorageMem2DMultisampleEXT;
/*       */   public final long glTexStorageMem3DEXT;
/*       */   public final long glTexStorageMem3DMultisampleEXT;
/*       */   public final long glBufferStorageMemEXT;
/*       */   public final long glTextureStorageMem2DEXT;
/*       */   public final long glTextureStorageMem2DMultisampleEXT;
/*       */   public final long glTextureStorageMem3DEXT;
/*       */   public final long glTextureStorageMem3DMultisampleEXT;
/*       */   public final long glNamedBufferStorageMemEXT;
/*       */   public final long glTexStorageMem1DEXT;
/*       */   public final long glTextureStorageMem1DEXT;
/*       */   public final long glImportMemoryFdEXT;
/*       */   public final long glImportMemoryWin32HandleEXT;
/*       */   public final long glImportMemoryWin32NameEXT;
/*       */   public final long glPointParameterfEXT;
/*       */   public final long glPointParameterfvEXT;
/*       */   public final long glPolygonOffsetClampEXT;
/*       */   public final long glProvokingVertexEXT;
/*       */   public final long glRasterSamplesEXT;
/*       */   public final long glSecondaryColor3bEXT;
/*       */   public final long glSecondaryColor3sEXT;
/*       */   public final long glSecondaryColor3iEXT;
/*       */   public final long glSecondaryColor3fEXT;
/*       */   public final long glSecondaryColor3dEXT;
/*       */   public final long glSecondaryColor3ubEXT;
/*       */   public final long glSecondaryColor3usEXT;
/*       */   public final long glSecondaryColor3uiEXT;
/*       */   public final long glSecondaryColor3bvEXT;
/*       */   public final long glSecondaryColor3svEXT;
/*       */   public final long glSecondaryColor3ivEXT;
/*       */   public final long glSecondaryColor3fvEXT;
/*       */   public final long glSecondaryColor3dvEXT;
/*       */   public final long glSecondaryColor3ubvEXT;
/*       */   public final long glSecondaryColor3usvEXT;
/*       */   public final long glSecondaryColor3uivEXT;
/*       */   public final long glSecondaryColorPointerEXT;
/*       */   public final long glGenSemaphoresEXT;
/*       */   public final long glDeleteSemaphoresEXT;
/*       */   public final long glIsSemaphoreEXT;
/*       */   public final long glSemaphoreParameterui64vEXT;
/*       */   public final long glGetSemaphoreParameterui64vEXT;
/*       */   public final long glWaitSemaphoreEXT;
/*       */   public final long glSignalSemaphoreEXT;
/*       */   public final long glImportSemaphoreFdEXT;
/*       */   public final long glImportSemaphoreWin32HandleEXT;
/*       */   public final long glImportSemaphoreWin32NameEXT;
/*       */   public final long glUseShaderProgramEXT;
/*       */   public final long glActiveProgramEXT;
/*       */   public final long glCreateShaderProgramEXT;
/*       */   public final long glFramebufferFetchBarrierEXT;
/*       */   public final long glBindImageTextureEXT;
/*       */   public final long glMemoryBarrierEXT;
/*       */   public final long glStencilClearTagEXT;
/*       */   public final long glActiveStencilFaceEXT;
/*       */   public final long glTexBufferEXT;
/*       */   public final long glClearColorIiEXT;
/*       */   public final long glClearColorIuiEXT;
/*       */   public final long glTexParameterIivEXT;
/*       */   public final long glTexParameterIuivEXT;
/*       */   public final long glGetTexParameterIivEXT;
/*       */   public final long glGetTexParameterIuivEXT;
/*       */   public final long glTexStorage1DEXT;
/*       */   public final long glTexStorage2DEXT;
/*       */   public final long glTexStorage3DEXT;
/*       */   public final long glGetQueryObjecti64vEXT;
/*       */   public final long glGetQueryObjectui64vEXT;
/*       */   public final long glBindBufferRangeEXT;
/*       */   public final long glBindBufferOffsetEXT;
/*       */   public final long glBindBufferBaseEXT;
/*       */   public final long glBeginTransformFeedbackEXT;
/*       */   public final long glEndTransformFeedbackEXT;
/*       */   public final long glTransformFeedbackVaryingsEXT;
/*       */   public final long glGetTransformFeedbackVaryingEXT;
/*       */   public final long glVertexAttribL1dEXT;
/*       */   public final long glVertexAttribL2dEXT;
/*       */   public final long glVertexAttribL3dEXT;
/*       */   public final long glVertexAttribL4dEXT;
/*       */   public final long glVertexAttribL1dvEXT;
/*       */   public final long glVertexAttribL2dvEXT;
/*       */   public final long glVertexAttribL3dvEXT;
/*       */   public final long glVertexAttribL4dvEXT;
/*       */   public final long glVertexAttribLPointerEXT;
/*       */   public final long glGetVertexAttribLdvEXT;
/*       */   public final long glAcquireKeyedMutexWin32EXT;
/*       */   public final long glReleaseKeyedMutexWin32EXT;
/*       */   public final long glWindowRectanglesEXT;
/*       */   public final long glImportSyncEXT;
/*       */   public final long glFrameTerminatorGREMEDY;
/*       */   public final long glStringMarkerGREMEDY;
/*       */   public final long glApplyFramebufferAttachmentCMAAINTEL;
/*       */   public final long glSyncTextureINTEL;
/*       */   public final long glUnmapTexture2DINTEL;
/*       */   public final long glMapTexture2DINTEL;
/*       */   public final long glBeginPerfQueryINTEL;
/*       */   public final long glCreatePerfQueryINTEL;
/*       */   public final long glDeletePerfQueryINTEL;
/*       */   public final long glEndPerfQueryINTEL;
/*       */   public final long glGetFirstPerfQueryIdINTEL;
/*       */   public final long glGetNextPerfQueryIdINTEL;
/*       */   public final long glGetPerfCounterInfoINTEL;
/*       */   public final long glGetPerfQueryDataINTEL;
/*       */   public final long glGetPerfQueryIdByNameINTEL;
/*       */   public final long glGetPerfQueryInfoINTEL;
/*       */   public final long glBlendBarrierKHR;
/*       */   public final long glMaxShaderCompilerThreadsKHR;
/*       */   public final long glFramebufferParameteriMESA;
/*       */   public final long glGetFramebufferParameterivMESA;
/*       */   public final long glAlphaToCoverageDitherControlNV;
/*       */   public final long glMultiDrawArraysIndirectBindlessNV;
/*       */   public final long glMultiDrawElementsIndirectBindlessNV;
/*       */   public final long glMultiDrawArraysIndirectBindlessCountNV;
/*       */   public final long glMultiDrawElementsIndirectBindlessCountNV;
/*       */   public final long glGetTextureHandleNV;
/*       */   public final long glGetTextureSamplerHandleNV;
/*       */   public final long glMakeTextureHandleResidentNV;
/*       */   public final long glMakeTextureHandleNonResidentNV;
/*       */   public final long glGetImageHandleNV;
/*       */   public final long glMakeImageHandleResidentNV;
/*       */   public final long glMakeImageHandleNonResidentNV;
/*       */   public final long glUniformHandleui64NV;
/*       */   public final long glUniformHandleui64vNV;
/*       */   public final long glProgramUniformHandleui64NV;
/*       */   public final long glProgramUniformHandleui64vNV;
/*       */   public final long glIsTextureHandleResidentNV;
/*       */   public final long glIsImageHandleResidentNV;
/*       */   public final long glBlendParameteriNV;
/*       */   public final long glBlendBarrierNV;
/*       */   public final long glViewportPositionWScaleNV;
/*       */   public final long glCreateStatesNV;
/*       */   public final long glDeleteStatesNV;
/*       */   public final long glIsStateNV;
/*       */   public final long glStateCaptureNV;
/*       */   public final long glGetCommandHeaderNV;
/*       */   public final long glGetStageIndexNV;
/*       */   public final long glDrawCommandsNV;
/*       */   public final long glDrawCommandsAddressNV;
/*       */   public final long glDrawCommandsStatesNV;
/*       */   public final long glDrawCommandsStatesAddressNV;
/*       */   public final long glCreateCommandListsNV;
/*       */   public final long glDeleteCommandListsNV;
/*       */   public final long glIsCommandListNV;
/*       */   public final long glListDrawCommandsStatesClientNV;
/*       */   public final long glCommandListSegmentsNV;
/*       */   public final long glCompileCommandListNV;
/*       */   public final long glCallCommandListNV;
/*       */   public final long glBeginConditionalRenderNV;
/*       */   public final long glEndConditionalRenderNV;
/*       */   public final long glSubpixelPrecisionBiasNV;
/*       */   public final long glConservativeRasterParameterfNV;
/*       */   public final long glConservativeRasterParameteriNV;
/*       */   public final long glCopyImageSubDataNV;
/*       */   public final long glDepthRangedNV;
/*       */   public final long glClearDepthdNV;
/*       */   public final long glDepthBoundsdNV;
/*       */   public final long glDrawTextureNV;
/*       */   public final long glDrawVkImageNV;
/*       */   public final long glGetVkProcAddrNV;
/*       */   public final long glWaitVkSemaphoreNV;
/*       */   public final long glSignalVkSemaphoreNV;
/*       */   public final long glSignalVkFenceNV;
/*       */   public final long glGetMultisamplefvNV;
/*       */   public final long glSampleMaskIndexedNV;
/*       */   public final long glTexRenderbufferNV;
/*       */   public final long glDeleteFencesNV;
/*       */   public final long glGenFencesNV;
/*       */   public final long glIsFenceNV;
/*       */   public final long glTestFenceNV;
/*       */   public final long glGetFenceivNV;
/*       */   public final long glFinishFenceNV;
/*       */   public final long glSetFenceNV;
/*       */   public final long glFragmentCoverageColorNV;
/*       */   public final long glCoverageModulationTableNV;
/*       */   public final long glGetCoverageModulationTableNV;
/*       */   public final long glCoverageModulationNV;
/*       */   public final long glRenderbufferStorageMultisampleCoverageNV;
/*       */   public final long glRenderGpuMaskNV;
/*       */   public final long glMulticastBufferSubDataNV;
/*       */   public final long glMulticastCopyBufferSubDataNV;
/*       */   public final long glMulticastCopyImageSubDataNV;
/*       */   public final long glMulticastBlitFramebufferNV;
/*       */   public final long glMulticastFramebufferSampleLocationsfvNV;
/*       */   public final long glMulticastBarrierNV;
/*       */   public final long glMulticastWaitSyncNV;
/*       */   public final long glMulticastGetQueryObjectivNV;
/*       */   public final long glMulticastGetQueryObjectuivNV;
/*       */   public final long glMulticastGetQueryObjecti64vNV;
/*       */   public final long glMulticastGetQueryObjectui64vNV;
/*       */   public final long glVertex2hNV;
/*       */   public final long glVertex2hvNV;
/*       */   public final long glVertex3hNV;
/*       */   public final long glVertex3hvNV;
/*       */   public final long glVertex4hNV;
/*       */   public final long glVertex4hvNV;
/*       */   public final long glNormal3hNV;
/*       */   public final long glNormal3hvNV;
/*       */   public final long glColor3hNV;
/*       */   public final long glColor3hvNV;
/*       */   public final long glColor4hNV;
/*       */   public final long glColor4hvNV;
/*       */   public final long glTexCoord1hNV;
/*       */   public final long glTexCoord1hvNV;
/*       */   public final long glTexCoord2hNV;
/*       */   public final long glTexCoord2hvNV;
/*       */   public final long glTexCoord3hNV;
/*       */   public final long glTexCoord3hvNV;
/*       */   public final long glTexCoord4hNV;
/*       */   public final long glTexCoord4hvNV;
/*       */   public final long glMultiTexCoord1hNV;
/*       */   public final long glMultiTexCoord1hvNV;
/*       */   public final long glMultiTexCoord2hNV;
/*       */   public final long glMultiTexCoord2hvNV;
/*       */   public final long glMultiTexCoord3hNV;
/*       */   public final long glMultiTexCoord3hvNV;
/*       */   public final long glMultiTexCoord4hNV;
/*       */   public final long glMultiTexCoord4hvNV;
/*       */   public final long glFogCoordhNV;
/*       */   public final long glFogCoordhvNV;
/*       */   public final long glSecondaryColor3hNV;
/*       */   public final long glSecondaryColor3hvNV;
/*       */   public final long glVertexWeighthNV;
/*       */   public final long glVertexWeighthvNV;
/*       */   public final long glVertexAttrib1hNV;
/*       */   public final long glVertexAttrib1hvNV;
/*       */   public final long glVertexAttrib2hNV;
/*       */   public final long glVertexAttrib2hvNV;
/*       */   public final long glVertexAttrib3hNV;
/*       */   public final long glVertexAttrib3hvNV;
/*       */   public final long glVertexAttrib4hNV;
/*       */   public final long glVertexAttrib4hvNV;
/*       */   public final long glVertexAttribs1hvNV;
/*       */   public final long glVertexAttribs2hvNV;
/*       */   public final long glVertexAttribs3hvNV;
/*       */   public final long glVertexAttribs4hvNV;
/*       */   public final long glGetInternalformatSampleivNV;
/*       */   public final long glGetMemoryObjectDetachedResourcesuivNV;
/*       */   public final long glResetMemoryObjectParameterNV;
/*       */   public final long glTexAttachMemoryNV;
/*       */   public final long glBufferAttachMemoryNV;
/*       */   public final long glTextureAttachMemoryNV;
/*       */   public final long glNamedBufferAttachMemoryNV;
/*       */   public final long glBufferPageCommitmentMemNV;
/*       */   public final long glNamedBufferPageCommitmentMemNV;
/*       */   public final long glTexPageCommitmentMemNV;
/*       */   public final long glTexturePageCommitmentMemNV;
/*       */   public final long glDrawMeshTasksNV;
/*       */   public final long glDrawMeshTasksIndirectNV;
/*       */   public final long glMultiDrawMeshTasksIndirectNV;
/*       */   public final long glMultiDrawMeshTasksIndirectCountNV;
/*       */   public final long glPathCommandsNV;
/*       */   public final long glPathCoordsNV;
/*       */   public final long glPathSubCommandsNV;
/*       */   public final long glPathSubCoordsNV;
/*       */   public final long glPathStringNV;
/*       */   public final long glPathGlyphsNV;
/*       */   public final long glPathGlyphRangeNV;
/*       */   public final long glPathGlyphIndexArrayNV;
/*       */   public final long glPathMemoryGlyphIndexArrayNV;
/*       */   public final long glCopyPathNV;
/*       */   public final long glWeightPathsNV;
/*       */   public final long glInterpolatePathsNV;
/*       */   public final long glTransformPathNV;
/*       */   public final long glPathParameterivNV;
/*       */   public final long glPathParameteriNV;
/*       */   public final long glPathParameterfvNV;
/*       */   public final long glPathParameterfNV;
/*       */   public final long glPathDashArrayNV;
/*       */   public final long glGenPathsNV;
/*       */   public final long glDeletePathsNV;
/*       */   public final long glIsPathNV;
/*       */   public final long glPathStencilFuncNV;
/*       */   public final long glPathStencilDepthOffsetNV;
/*       */   public final long glStencilFillPathNV;
/*       */   public final long glStencilStrokePathNV;
/*       */   public final long glStencilFillPathInstancedNV;
/*       */   public final long glStencilStrokePathInstancedNV;
/*       */   public final long glPathCoverDepthFuncNV;
/*       */   public final long glPathColorGenNV;
/*       */   public final long glPathTexGenNV;
/*       */   public final long glPathFogGenNV;
/*       */   public final long glCoverFillPathNV;
/*       */   public final long glCoverStrokePathNV;
/*       */   public final long glCoverFillPathInstancedNV;
/*       */   public final long glCoverStrokePathInstancedNV;
/*       */   public final long glStencilThenCoverFillPathNV;
/*       */   public final long glStencilThenCoverStrokePathNV;
/*       */   public final long glStencilThenCoverFillPathInstancedNV;
/*       */   public final long glStencilThenCoverStrokePathInstancedNV;
/*       */   public final long glPathGlyphIndexRangeNV;
/*       */   public final long glProgramPathFragmentInputGenNV;
/*       */   public final long glGetPathParameterivNV;
/*       */   public final long glGetPathParameterfvNV;
/*       */   public final long glGetPathCommandsNV;
/*       */   public final long glGetPathCoordsNV;
/*       */   public final long glGetPathDashArrayNV;
/*       */   public final long glGetPathMetricsNV;
/*       */   public final long glGetPathMetricRangeNV;
/*       */   public final long glGetPathSpacingNV;
/*       */   public final long glGetPathColorGenivNV;
/*       */   public final long glGetPathColorGenfvNV;
/*       */   public final long glGetPathTexGenivNV;
/*       */   public final long glGetPathTexGenfvNV;
/*       */   public final long glIsPointInFillPathNV;
/*       */   public final long glIsPointInStrokePathNV;
/*       */   public final long glGetPathLengthNV;
/*       */   public final long glPointAlongPathNV;
/*       */   public final long glMatrixLoad3x2fNV;
/*       */   public final long glMatrixLoad3x3fNV;
/*       */   public final long glMatrixLoadTranspose3x3fNV;
/*       */   public final long glMatrixMult3x2fNV;
/*       */   public final long glMatrixMult3x3fNV;
/*       */   public final long glMatrixMultTranspose3x3fNV;
/*       */   public final long glGetProgramResourcefvNV;
/*       */   public final long glPixelDataRangeNV;
/*       */   public final long glFlushPixelDataRangeNV;
/*       */   public final long glPointParameteriNV;
/*       */   public final long glPointParameterivNV;
/*       */   public final long glPrimitiveRestartNV;
/*       */   public final long glPrimitiveRestartIndexNV;
/*       */   public final long glQueryResourceNV;
/*       */   public final long glGenQueryResourceTagNV;
/*       */   public final long glDeleteQueryResourceTagNV;
/*       */   public final long glQueryResourceTagNV;
/*       */   public final long glFramebufferSampleLocationsfvNV;
/*       */   public final long glNamedFramebufferSampleLocationsfvNV;
/*       */   public final long glResolveDepthValuesNV;
/*       */   public final long glScissorExclusiveArrayvNV;
/*       */   public final long glScissorExclusiveNV;
/*       */   public final long glMakeBufferResidentNV;
/*       */   public final long glMakeBufferNonResidentNV;
/*       */   public final long glIsBufferResidentNV;
/*       */   public final long glMakeNamedBufferResidentNV;
/*       */   public final long glMakeNamedBufferNonResidentNV;
/*       */   public final long glIsNamedBufferResidentNV;
/*       */   public final long glGetBufferParameterui64vNV;
/*       */   public final long glGetNamedBufferParameterui64vNV;
/*       */   public final long glGetIntegerui64vNV;
/*       */   public final long glUniformui64NV;
/*       */   public final long glUniformui64vNV;
/*       */   public final long glProgramUniformui64NV;
/*       */   public final long glProgramUniformui64vNV;
/*       */   public final long glBindShadingRateImageNV;
/*       */   public final long glShadingRateImagePaletteNV;
/*       */   public final long glGetShadingRateImagePaletteNV;
/*       */   public final long glShadingRateImageBarrierNV;
/*       */   public final long glShadingRateSampleOrderNV;
/*       */   public final long glShadingRateSampleOrderCustomNV;
/*       */   public final long glGetShadingRateSampleLocationivNV;
/*       */   public final long glTextureBarrierNV;
/*       */   public final long glTexImage2DMultisampleCoverageNV;
/*       */   public final long glTexImage3DMultisampleCoverageNV;
/*       */   public final long glTextureImage2DMultisampleNV;
/*       */   public final long glTextureImage3DMultisampleNV;
/*       */   public final long glTextureImage2DMultisampleCoverageNV;
/*       */   public final long glTextureImage3DMultisampleCoverageNV;
/*       */   public final long glCreateSemaphoresNV;
/*       */   public final long glSemaphoreParameterivNV;
/*       */   public final long glGetSemaphoreParameterivNV;
/*       */   public final long glBeginTransformFeedbackNV;
/*       */   public final long glEndTransformFeedbackNV;
/*       */   public final long glTransformFeedbackAttribsNV;
/*       */   public final long glBindBufferRangeNV;
/*       */   public final long glBindBufferOffsetNV;
/*       */   public final long glBindBufferBaseNV;
/*       */   public final long glTransformFeedbackVaryingsNV;
/*       */   public final long glActiveVaryingNV;
/*       */   public final long glGetVaryingLocationNV;
/*       */   public final long glGetActiveVaryingNV;
/*       */   public final long glGetTransformFeedbackVaryingNV;
/*       */   public final long glTransformFeedbackStreamAttribsNV;
/*       */   public final long glBindTransformFeedbackNV;
/*       */   public final long glDeleteTransformFeedbacksNV;
/*       */   public final long glGenTransformFeedbacksNV;
/*       */   public final long glIsTransformFeedbackNV;
/*       */   public final long glPauseTransformFeedbackNV;
/*       */   public final long glResumeTransformFeedbackNV;
/*       */   public final long glDrawTransformFeedbackNV;
/*       */   public final long glVertexArrayRangeNV;
/*       */   public final long glFlushVertexArrayRangeNV;
/*       */   public final long glVertexAttribL1i64NV;
/*       */   public final long glVertexAttribL2i64NV;
/*       */   public final long glVertexAttribL3i64NV;
/*       */   public final long glVertexAttribL4i64NV;
/*       */   public final long glVertexAttribL1i64vNV;
/*       */   public final long glVertexAttribL2i64vNV;
/*       */   public final long glVertexAttribL3i64vNV;
/*       */   public final long glVertexAttribL4i64vNV;
/*       */   public final long glVertexAttribL1ui64NV;
/*       */   public final long glVertexAttribL2ui64NV;
/*       */   public final long glVertexAttribL3ui64NV;
/*       */   public final long glVertexAttribL4ui64NV;
/*       */   public final long glVertexAttribL1ui64vNV;
/*       */   public final long glVertexAttribL2ui64vNV;
/*       */   public final long glVertexAttribL3ui64vNV;
/*       */   public final long glVertexAttribL4ui64vNV;
/*       */   public final long glGetVertexAttribLi64vNV;
/*       */   public final long glGetVertexAttribLui64vNV;
/*       */   public final long glVertexAttribLFormatNV;
/*       */   public final long glBufferAddressRangeNV;
/*       */   public final long glVertexFormatNV;
/*       */   public final long glNormalFormatNV;
/*       */   public final long glColorFormatNV;
/*       */   public final long glIndexFormatNV;
/*       */   public final long glTexCoordFormatNV;
/*       */   public final long glEdgeFlagFormatNV;
/*       */   public final long glSecondaryColorFormatNV;
/*       */   public final long glFogCoordFormatNV;
/*       */   public final long glVertexAttribFormatNV;
/*       */   public final long glVertexAttribIFormatNV;
/*       */   public final long glGetIntegerui64i_vNV;
/*       */   public final long glViewportSwizzleNV;
/*       */   public final long glBeginConditionalRenderNVX;
/*       */   public final long glEndConditionalRenderNVX;
/*       */   public final long glAsyncCopyImageSubDataNVX;
/*       */   public final long glAsyncCopyBufferSubDataNVX;
/*       */   public final long glUploadGpuMaskNVX;
/*       */   public final long glMulticastViewportArrayvNVX;
/*       */   public final long glMulticastScissorArrayvNVX;
/*       */   public final long glMulticastViewportPositionWScaleNVX;
/*       */   public final long glCreateProgressFenceNVX;
/*       */   public final long glSignalSemaphoreui64NVX;
/*       */   public final long glWaitSemaphoreui64NVX;
/*       */   public final long glClientWaitSemaphoreui64NVX;
/*       */   public final long glFramebufferTextureMultiviewOVR;
/*       */   public final long glNamedFramebufferTextureMultiviewOVR;
/*       */   public final boolean OpenGL11;
/*       */   public final boolean OpenGL12;
/*       */   public final boolean OpenGL13;
/*       */   public final boolean OpenGL14;
/*       */   public final boolean OpenGL15;
/*       */   public final boolean OpenGL20;
/*       */   public final boolean OpenGL21;
/*       */   public final boolean OpenGL30;
/*       */   public final boolean OpenGL31;
/*       */   public final boolean OpenGL32;
/*       */   public final boolean OpenGL33;
/*       */   public final boolean OpenGL40;
/*       */   public final boolean OpenGL41;
/*       */   public final boolean OpenGL42;
/*       */   public final boolean OpenGL43;
/*       */   public final boolean OpenGL44;
/*       */   public final boolean OpenGL45;
/*       */   public final boolean OpenGL46;
/*       */   public final boolean GL_3DFX_texture_compression_FXT1;
/*       */   public final boolean GL_AMD_blend_minmax_factor;
/*       */   public final boolean GL_AMD_conservative_depth;
/*       */   public final boolean GL_AMD_debug_output;
/*       */   public final boolean GL_AMD_depth_clamp_separate;
/*       */   public final boolean GL_AMD_draw_buffers_blend;
/*       */   public final boolean GL_AMD_framebuffer_multisample_advanced;
/*       */   public final boolean GL_AMD_gcn_shader;
/*       */   public final boolean GL_AMD_gpu_shader_half_float;
/*       */   public final boolean GL_AMD_gpu_shader_half_float_fetch;
/*       */   public final boolean GL_AMD_gpu_shader_int16;
/*       */   public final boolean GL_AMD_gpu_shader_int64;
/*       */   public final boolean GL_AMD_interleaved_elements;
/*       */   public final boolean GL_AMD_occlusion_query_event;
/*       */   public final boolean GL_AMD_performance_monitor;
/*       */   public final boolean GL_AMD_pinned_memory;
/*       */   public final boolean GL_AMD_query_buffer_object;
/*       */   public final boolean GL_AMD_sample_positions;
/*       */   public final boolean GL_AMD_seamless_cubemap_per_texture;
/*       */   public final boolean GL_AMD_shader_atomic_counter_ops;
/*       */   public final boolean GL_AMD_shader_ballot;
/*       */   public final boolean GL_AMD_shader_explicit_vertex_parameter;
/*       */   public final boolean GL_AMD_shader_image_load_store_lod;
/*       */   public final boolean GL_AMD_shader_stencil_export;
/*       */   public final boolean GL_AMD_shader_trinary_minmax;
/*       */   public final boolean GL_AMD_sparse_texture;
/*       */   public final boolean GL_AMD_stencil_operation_extended;
/*       */   public final boolean GL_AMD_texture_gather_bias_lod;
/*       */   public final boolean GL_AMD_texture_texture4;
/*       */   public final boolean GL_AMD_transform_feedback3_lines_triangles;
/*       */   public final boolean GL_AMD_transform_feedback4;
/*       */   public final boolean GL_AMD_vertex_shader_layer;
/*       */   public final boolean GL_AMD_vertex_shader_tessellator;
/*       */   public final boolean GL_AMD_vertex_shader_viewport_index;
/*       */   public final boolean GL_ARB_arrays_of_arrays;
/*       */   public final boolean GL_ARB_base_instance;
/*       */   public final boolean GL_ARB_bindless_texture;
/*       */   public final boolean GL_ARB_blend_func_extended;
/*       */   public final boolean GL_ARB_buffer_storage;
/*       */   public final boolean GL_ARB_cl_event;
/*       */   public final boolean GL_ARB_clear_buffer_object;
/*       */   public final boolean GL_ARB_clear_texture;
/*       */   public final boolean GL_ARB_clip_control;
/*       */   public final boolean GL_ARB_color_buffer_float;
/*       */   public final boolean GL_ARB_compatibility;
/*       */   public final boolean GL_ARB_compressed_texture_pixel_storage;
/*       */   public final boolean GL_ARB_compute_shader;
/*       */   public final boolean GL_ARB_compute_variable_group_size;
/*       */   public final boolean GL_ARB_conditional_render_inverted;
/*       */   public final boolean GL_ARB_conservative_depth;
/*       */   public final boolean GL_ARB_copy_buffer;
/*       */   public final boolean GL_ARB_copy_image;
/*       */   public final boolean GL_ARB_cull_distance;
/*       */   public final boolean GL_ARB_debug_output;
/*       */   public final boolean GL_ARB_depth_buffer_float;
/*       */   public final boolean GL_ARB_depth_clamp;
/*       */   public final boolean GL_ARB_depth_texture;
/*       */   public final boolean GL_ARB_derivative_control;
/*       */   public final boolean GL_ARB_direct_state_access;
/*       */   public final boolean GL_ARB_draw_buffers;
/*       */   public final boolean GL_ARB_draw_buffers_blend;
/*       */   public final boolean GL_ARB_draw_elements_base_vertex;
/*       */   public final boolean GL_ARB_draw_indirect;
/*       */   public final boolean GL_ARB_draw_instanced;
/*       */   public final boolean GL_ARB_enhanced_layouts;
/*       */   public final boolean GL_ARB_ES2_compatibility;
/*       */   public final boolean GL_ARB_ES3_1_compatibility;
/*       */   public final boolean GL_ARB_ES3_2_compatibility;
/*       */   public final boolean GL_ARB_ES3_compatibility;
/*       */   public final boolean GL_ARB_explicit_attrib_location;
/*       */   public final boolean GL_ARB_explicit_uniform_location;
/*       */   public final boolean GL_ARB_fragment_coord_conventions;
/*       */   public final boolean GL_ARB_fragment_layer_viewport;
/*       */   public final boolean GL_ARB_fragment_program;
/*       */   public final boolean GL_ARB_fragment_program_shadow;
/*       */   public final boolean GL_ARB_fragment_shader;
/*       */   public final boolean GL_ARB_fragment_shader_interlock;
/*       */   public final boolean GL_ARB_framebuffer_no_attachments;
/*       */   public final boolean GL_ARB_framebuffer_object;
/*       */   public final boolean GL_ARB_framebuffer_sRGB;
/*       */   public final boolean GL_ARB_geometry_shader4;
/*       */   public final boolean GL_ARB_get_program_binary;
/*       */   public final boolean GL_ARB_get_texture_sub_image;
/*       */   public final boolean GL_ARB_gl_spirv;
/*       */   public final boolean GL_ARB_gpu_shader5;
/*       */   public final boolean GL_ARB_gpu_shader_fp64;
/*       */   public final boolean GL_ARB_gpu_shader_int64;
/*       */   public final boolean GL_ARB_half_float_pixel;
/*       */   public final boolean GL_ARB_half_float_vertex;
/*       */   public final boolean GL_ARB_imaging;
/*       */   public final boolean GL_ARB_indirect_parameters;
/*       */   public final boolean GL_ARB_instanced_arrays;
/*       */   public final boolean GL_ARB_internalformat_query;
/*       */   public final boolean GL_ARB_internalformat_query2;
/*       */   public final boolean GL_ARB_invalidate_subdata;
/*       */   public final boolean GL_ARB_map_buffer_alignment;
/*       */   public final boolean GL_ARB_map_buffer_range;
/*       */   public final boolean GL_ARB_matrix_palette;
/*       */   public final boolean GL_ARB_multi_bind;
/*       */   public final boolean GL_ARB_multi_draw_indirect;
/*       */   public final boolean GL_ARB_multisample;
/*       */   public final boolean GL_ARB_multitexture;
/*       */   public final boolean GL_ARB_occlusion_query;
/*       */   public final boolean GL_ARB_occlusion_query2;
/*       */   public final boolean GL_ARB_parallel_shader_compile;
/*       */   public final boolean GL_ARB_pipeline_statistics_query;
/*       */   public final boolean GL_ARB_pixel_buffer_object;
/*       */   public final boolean GL_ARB_point_parameters;
/*       */   public final boolean GL_ARB_point_sprite;
/*       */   public final boolean GL_ARB_polygon_offset_clamp;
/*       */   public final boolean GL_ARB_post_depth_coverage;
/*       */   public final boolean GL_ARB_program_interface_query;
/*       */   public final boolean GL_ARB_provoking_vertex;
/*       */   public final boolean GL_ARB_query_buffer_object;
/*       */   public final boolean GL_ARB_robust_buffer_access_behavior;
/*       */   public final boolean GL_ARB_robustness;
/*       */   public final boolean GL_ARB_robustness_application_isolation;
/*       */   public final boolean GL_ARB_robustness_share_group_isolation;
/*       */   public final boolean GL_ARB_sample_locations;
/*       */   public final boolean GL_ARB_sample_shading;
/*       */   public final boolean GL_ARB_sampler_objects;
/*       */   public final boolean GL_ARB_seamless_cube_map;
/*       */   public final boolean GL_ARB_seamless_cubemap_per_texture;
/*       */   public final boolean GL_ARB_separate_shader_objects;
/*       */   public final boolean GL_ARB_shader_atomic_counter_ops;
/*       */   public final boolean GL_ARB_shader_atomic_counters;
/*       */   public final boolean GL_ARB_shader_ballot;
/*       */   public final boolean GL_ARB_shader_bit_encoding;
/*       */   public final boolean GL_ARB_shader_clock;
/*       */   public final boolean GL_ARB_shader_draw_parameters;
/*       */   public final boolean GL_ARB_shader_group_vote;
/*       */   public final boolean GL_ARB_shader_image_load_store;
/*       */   public final boolean GL_ARB_shader_image_size;
/*       */   public final boolean GL_ARB_shader_objects;
/*       */   public final boolean GL_ARB_shader_precision;
/*       */   public final boolean GL_ARB_shader_stencil_export;
/*       */   public final boolean GL_ARB_shader_storage_buffer_object;
/*       */   public final boolean GL_ARB_shader_subroutine;
/*       */   public final boolean GL_ARB_shader_texture_image_samples;
/*       */   public final boolean GL_ARB_shader_texture_lod;
/*       */   public final boolean GL_ARB_shader_viewport_layer_array;
/*       */   public final boolean GL_ARB_shading_language_100;
/*       */   public final boolean GL_ARB_shading_language_420pack;
/*       */   public final boolean GL_ARB_shading_language_include;
/*       */   public final boolean GL_ARB_shading_language_packing;
/*       */   public final boolean GL_ARB_shadow;
/*       */   public final boolean GL_ARB_shadow_ambient;
/*       */   public final boolean GL_ARB_sparse_buffer;
/*       */   public final boolean GL_ARB_sparse_texture;
/*       */   public final boolean GL_ARB_sparse_texture2;
/*       */   public final boolean GL_ARB_sparse_texture_clamp;
/*       */   public final boolean GL_ARB_spirv_extensions;
/*       */   public final boolean GL_ARB_stencil_texturing;
/*       */   public final boolean GL_ARB_sync;
/*       */   public final boolean GL_ARB_tessellation_shader;
/*       */   public final boolean GL_ARB_texture_barrier;
/*       */   public final boolean GL_ARB_texture_border_clamp;
/*       */   public final boolean GL_ARB_texture_buffer_object;
/*       */   public final boolean GL_ARB_texture_buffer_object_rgb32;
/*       */   public final boolean GL_ARB_texture_buffer_range;
/*       */   public final boolean GL_ARB_texture_compression;
/*       */   public final boolean GL_ARB_texture_compression_bptc;
/*       */   public final boolean GL_ARB_texture_compression_rgtc;
/*       */   public final boolean GL_ARB_texture_cube_map;
/*       */   public final boolean GL_ARB_texture_cube_map_array;
/*       */   public final boolean GL_ARB_texture_env_add;
/*       */   public final boolean GL_ARB_texture_env_combine;
/*       */   public final boolean GL_ARB_texture_env_crossbar;
/*       */   public final boolean GL_ARB_texture_env_dot3;
/*       */   public final boolean GL_ARB_texture_filter_anisotropic;
/*       */   public final boolean GL_ARB_texture_filter_minmax;
/*       */   public final boolean GL_ARB_texture_float;
/*       */   public final boolean GL_ARB_texture_gather;
/*       */   public final boolean GL_ARB_texture_mirror_clamp_to_edge;
/*       */   public final boolean GL_ARB_texture_mirrored_repeat;
/*       */   public final boolean GL_ARB_texture_multisample;
/*       */   public final boolean GL_ARB_texture_non_power_of_two;
/*       */   public final boolean GL_ARB_texture_query_levels;
/*       */   public final boolean GL_ARB_texture_query_lod;
/*       */   public final boolean GL_ARB_texture_rectangle;
/*       */   public final boolean GL_ARB_texture_rg;
/*       */   public final boolean GL_ARB_texture_rgb10_a2ui;
/*       */   public final boolean GL_ARB_texture_stencil8;
/*       */   public final boolean GL_ARB_texture_storage;
/*       */   public final boolean GL_ARB_texture_storage_multisample;
/*       */   public final boolean GL_ARB_texture_swizzle;
/*       */   public final boolean GL_ARB_texture_view;
/*       */   public final boolean GL_ARB_timer_query;
/*       */   public final boolean GL_ARB_transform_feedback2;
/*       */   public final boolean GL_ARB_transform_feedback3;
/*       */   public final boolean GL_ARB_transform_feedback_instanced;
/*       */   public final boolean GL_ARB_transform_feedback_overflow_query;
/*       */   public final boolean GL_ARB_transpose_matrix;
/*       */   public final boolean GL_ARB_uniform_buffer_object;
/*       */   public final boolean GL_ARB_vertex_array_bgra;
/*       */   public final boolean GL_ARB_vertex_array_object;
/*       */   public final boolean GL_ARB_vertex_attrib_64bit;
/*       */   public final boolean GL_ARB_vertex_attrib_binding;
/*       */   public final boolean GL_ARB_vertex_blend;
/*       */   public final boolean GL_ARB_vertex_buffer_object;
/*       */   public final boolean GL_ARB_vertex_program;
/*       */   public final boolean GL_ARB_vertex_shader;
/*       */   public final boolean GL_ARB_vertex_type_10f_11f_11f_rev;
/*       */   public final boolean GL_ARB_vertex_type_2_10_10_10_rev;
/*       */   public final boolean GL_ARB_viewport_array;
/*       */   public final boolean GL_ARB_window_pos;
/*       */   public final boolean GL_ATI_meminfo;
/*       */   public final boolean GL_ATI_shader_texture_lod;
/*       */   public final boolean GL_ATI_texture_compression_3dc;
/*       */   public final boolean GL_EXT_422_pixels;
/*       */   public final boolean GL_EXT_abgr;
/*       */   public final boolean GL_EXT_bgra;
/*       */   public final boolean GL_EXT_bindable_uniform;
/*       */   public final boolean GL_EXT_blend_color;
/*       */   public final boolean GL_EXT_blend_equation_separate;
/*       */   public final boolean GL_EXT_blend_func_separate;
/*       */   public final boolean GL_EXT_blend_minmax;
/*       */   public final boolean GL_EXT_blend_subtract;
/*       */   public final boolean GL_EXT_clip_volume_hint;
/*       */   public final boolean GL_EXT_compiled_vertex_array;
/*       */   public final boolean GL_EXT_debug_label;
/*       */   public final boolean GL_EXT_debug_marker;
/*       */   public final boolean GL_EXT_depth_bounds_test;
/*       */   public final boolean GL_EXT_direct_state_access;
/*       */   public final boolean GL_EXT_draw_buffers2;
/*       */   public final boolean GL_EXT_draw_instanced;
/*       */   public final boolean GL_EXT_EGL_image_storage;
/*       */   public final boolean GL_EXT_EGL_sync;
/*       */   public final boolean GL_EXT_external_buffer;
/*       */   public final boolean GL_EXT_framebuffer_blit;
/*       */   public final boolean GL_EXT_framebuffer_blit_layers;
/*       */   public final boolean GL_EXT_framebuffer_multisample;
/*       */   public final boolean GL_EXT_framebuffer_multisample_blit_scaled;
/*       */   public final boolean GL_EXT_framebuffer_object;
/*       */   public final boolean GL_EXT_framebuffer_sRGB;
/*       */   public final boolean GL_EXT_geometry_shader4;
/*       */   public final boolean GL_EXT_gpu_program_parameters;
/*       */   public final boolean GL_EXT_gpu_shader4;
/*       */   public final boolean GL_EXT_memory_object;
/*       */   public final boolean GL_EXT_memory_object_fd;
/*       */   public final boolean GL_EXT_memory_object_win32;
/*       */   public final boolean GL_EXT_multiview_tessellation_geometry_shader;
/*       */   public final boolean GL_EXT_multiview_texture_multisample;
/*       */   public final boolean GL_EXT_multiview_timer_query;
/*       */   public final boolean GL_EXT_packed_depth_stencil;
/*       */   public final boolean GL_EXT_packed_float;
/*       */   public final boolean GL_EXT_pixel_buffer_object;
/*       */   public final boolean GL_EXT_point_parameters;
/*       */   public final boolean GL_EXT_polygon_offset_clamp;
/*       */   public final boolean GL_EXT_post_depth_coverage;
/*       */   public final boolean GL_EXT_provoking_vertex;
/*       */   public final boolean GL_EXT_raster_multisample;
/*       */   public final boolean GL_EXT_secondary_color;
/*       */   public final boolean GL_EXT_semaphore;
/*       */   public final boolean GL_EXT_semaphore_fd;
/*       */   public final boolean GL_EXT_semaphore_win32;
/*       */   public final boolean GL_EXT_separate_shader_objects;
/*       */   public final boolean GL_EXT_shader_framebuffer_fetch;
/*       */   public final boolean GL_EXT_shader_framebuffer_fetch_non_coherent;
/*       */   public final boolean GL_EXT_shader_image_load_formatted;
/*       */   public final boolean GL_EXT_shader_image_load_store;
/*       */   public final boolean GL_EXT_shader_integer_mix;
/*       */   public final boolean GL_EXT_shader_samples_identical;
/*       */   public final boolean GL_EXT_shadow_funcs;
/*       */   public final boolean GL_EXT_shared_texture_palette;
/*       */   public final boolean GL_EXT_sparse_texture2;
/*       */   public final boolean GL_EXT_stencil_clear_tag;
/*       */   public final boolean GL_EXT_stencil_two_side;
/*       */   public final boolean GL_EXT_stencil_wrap;
/*       */   public final boolean GL_EXT_texture_array;
/*       */   public final boolean GL_EXT_texture_buffer_object;
/*       */   public final boolean GL_EXT_texture_compression_latc;
/*       */   public final boolean GL_EXT_texture_compression_rgtc;
/*       */   public final boolean GL_EXT_texture_compression_s3tc;
/*       */   public final boolean GL_EXT_texture_filter_anisotropic;
/*       */   public final boolean GL_EXT_texture_filter_minmax;
/*       */   public final boolean GL_EXT_texture_integer;
/*       */   public final boolean GL_EXT_texture_mirror_clamp;
/*       */   public final boolean GL_EXT_texture_shadow_lod;
/*       */   public final boolean GL_EXT_texture_shared_exponent;
/*       */   public final boolean GL_EXT_texture_snorm;
/*       */   public final boolean GL_EXT_texture_sRGB;
/*       */   public final boolean GL_EXT_texture_sRGB_decode;
/*       */   public final boolean GL_EXT_texture_sRGB_R8;
/*       */   public final boolean GL_EXT_texture_sRGB_RG8;
/*       */   public final boolean GL_EXT_texture_storage;
/*       */   public final boolean GL_EXT_texture_swizzle;
/*       */   public final boolean GL_EXT_timer_query;
/*       */   public final boolean GL_EXT_transform_feedback;
/*       */   public final boolean GL_EXT_vertex_array_bgra;
/*       */   public final boolean GL_EXT_vertex_attrib_64bit;
/*       */   public final boolean GL_EXT_win32_keyed_mutex;
/*       */   public final boolean GL_EXT_window_rectangles;
/*       */   public final boolean GL_EXT_x11_sync_object;
/*       */   public final boolean GL_GREMEDY_frame_terminator;
/*       */   public final boolean GL_GREMEDY_string_marker;
/*       */   public final boolean GL_INTEL_blackhole_render;
/*       */   public final boolean GL_INTEL_conservative_rasterization;
/*       */   public final boolean GL_INTEL_fragment_shader_ordering;
/*       */   public final boolean GL_INTEL_framebuffer_CMAA;
/*       */   public final boolean GL_INTEL_map_texture;
/*       */   public final boolean GL_INTEL_performance_query;
/*       */   public final boolean GL_INTEL_shader_integer_functions2;
/*       */   public final boolean GL_KHR_blend_equation_advanced;
/*       */   public final boolean GL_KHR_blend_equation_advanced_coherent;
/*       */   public final boolean GL_KHR_context_flush_control;
/*       */   public final boolean GL_KHR_debug;
/*       */   public final boolean GL_KHR_no_error;
/*       */   public final boolean GL_KHR_parallel_shader_compile;
/*       */   public final boolean GL_KHR_robust_buffer_access_behavior;
/*       */   public final boolean GL_KHR_robustness;
/*       */   public final boolean GL_KHR_shader_subgroup;
/*       */   public final boolean GL_KHR_texture_compression_astc_hdr;
/*       */   public final boolean GL_KHR_texture_compression_astc_ldr;
/*       */   public final boolean GL_KHR_texture_compression_astc_sliced_3d;
/*       */   public final boolean GL_MESA_framebuffer_flip_x;
/*       */   public final boolean GL_MESA_framebuffer_flip_y;
/*       */   public final boolean GL_MESA_framebuffer_swap_xy;
/*       */   public final boolean GL_MESA_tile_raster_order;
/*       */   public final boolean GL_NV_alpha_to_coverage_dither_control;
/*       */   public final boolean GL_NV_bindless_multi_draw_indirect;
/*       */   public final boolean GL_NV_bindless_multi_draw_indirect_count;
/*       */   public final boolean GL_NV_bindless_texture;
/*       */   public final boolean GL_NV_blend_equation_advanced;
/*       */   public final boolean GL_NV_blend_equation_advanced_coherent;
/*       */   public final boolean GL_NV_blend_minmax_factor;
/*       */   public final boolean GL_NV_blend_square;
/*       */   public final boolean GL_NV_clip_space_w_scaling;
/*       */   public final boolean GL_NV_command_list;
/*       */   public final boolean GL_NV_compute_shader_derivatives;
/*       */   public final boolean GL_NV_conditional_render;
/*       */   public final boolean GL_NV_conservative_raster;
/*       */   public final boolean GL_NV_conservative_raster_dilate;
/*       */   public final boolean GL_NV_conservative_raster_pre_snap;
/*       */   public final boolean GL_NV_conservative_raster_pre_snap_triangles;
/*       */   public final boolean GL_NV_conservative_raster_underestimation;
/*       */   public final boolean GL_NV_copy_depth_to_color;
/*       */   public final boolean GL_NV_copy_image;
/*       */   public final boolean GL_NV_deep_texture3D;
/*       */   public final boolean GL_NV_depth_buffer_float;
/*       */   public final boolean GL_NV_depth_clamp;
/*       */   public final boolean GL_NV_draw_texture;
/*       */   public final boolean GL_NV_draw_vulkan_image;
/*       */   public final boolean GL_NV_ES3_1_compatibility;
/*       */   public final boolean GL_NV_explicit_multisample;
/*       */   public final boolean GL_NV_fence;
/*       */   public final boolean GL_NV_fill_rectangle;
/*       */   public final boolean GL_NV_float_buffer;
/*       */   public final boolean GL_NV_fog_distance;
/*       */   public final boolean GL_NV_fragment_coverage_to_color;
/*       */   public final boolean GL_NV_fragment_program4;
/*       */   public final boolean GL_NV_fragment_program_option;
/*       */   public final boolean GL_NV_fragment_shader_barycentric;
/*       */   public final boolean GL_NV_fragment_shader_interlock;
/*       */   public final boolean GL_NV_framebuffer_mixed_samples;
/*       */   public final boolean GL_NV_framebuffer_multisample_coverage;
/*       */   public final boolean GL_NV_geometry_shader4;
/*       */   public final boolean GL_NV_geometry_shader_passthrough;
/*       */   public final boolean GL_NV_gpu_multicast;
/*       */   public final boolean GL_NV_gpu_shader5;
/*       */   public final boolean GL_NV_half_float;
/*       */   public final boolean GL_NV_internalformat_sample_query;
/*       */   public final boolean GL_NV_light_max_exponent;
/*       */   public final boolean GL_NV_memory_attachment;
/*       */   public final boolean GL_NV_memory_object_sparse;
/*       */   public final boolean GL_NV_mesh_shader;
/*       */   public final boolean GL_NV_multisample_coverage;
/*       */   public final boolean GL_NV_multisample_filter_hint;
/*       */   public final boolean GL_NV_packed_depth_stencil;
/*       */   public final boolean GL_NV_path_rendering;
/*       */   public final boolean GL_NV_path_rendering_shared_edge;
/*       */   public final boolean GL_NV_pixel_data_range;
/*       */   public final boolean GL_NV_point_sprite;
/*       */   public final boolean GL_NV_primitive_restart;
/*       */   public final boolean GL_NV_primitive_shading_rate;
/*       */   public final boolean GL_NV_query_resource;
/*       */   public final boolean GL_NV_query_resource_tag;
/*       */   public final boolean GL_NV_representative_fragment_test;
/*       */   public final boolean GL_NV_robustness_video_memory_purge;
/*       */   public final boolean GL_NV_sample_locations;
/*       */   public final boolean GL_NV_sample_mask_override_coverage;
/*       */   public final boolean GL_NV_scissor_exclusive;
/*       */   public final boolean GL_NV_shader_atomic_float;
/*       */   public final boolean GL_NV_shader_atomic_float64;
/*       */   public final boolean GL_NV_shader_atomic_fp16_vector;
/*       */   public final boolean GL_NV_shader_atomic_int64;
/*       */   public final boolean GL_NV_shader_buffer_load;
/*       */   public final boolean GL_NV_shader_buffer_store;
/*       */   public final boolean GL_NV_shader_subgroup_partitioned;
/*       */   public final boolean GL_NV_shader_texture_footprint;
/*       */   public final boolean GL_NV_shader_thread_group;
/*       */   public final boolean GL_NV_shader_thread_shuffle;
/*       */   public final boolean GL_NV_shading_rate_image;
/*       */   public final boolean GL_NV_stereo_view_rendering;
/*       */   public final boolean GL_NV_texgen_reflection;
/*       */   public final boolean GL_NV_texture_barrier;
/*       */   public final boolean GL_NV_texture_compression_vtc;
/*       */   public final boolean GL_NV_texture_multisample;
/*       */   public final boolean GL_NV_texture_rectangle_compressed;
/*       */   public final boolean GL_NV_texture_shader;
/*       */   public final boolean GL_NV_texture_shader2;
/*       */   public final boolean GL_NV_texture_shader3;
/*       */   public final boolean GL_NV_timeline_semaphore;
/*       */   public final boolean GL_NV_transform_feedback;
/*       */   public final boolean GL_NV_transform_feedback2;
/*       */   public final boolean GL_NV_uniform_buffer_std430_layout;
/*       */   public final boolean GL_NV_uniform_buffer_unified_memory;
/*       */   public final boolean GL_NV_vertex_array_range;
/*       */   public final boolean GL_NV_vertex_array_range2;
/*       */   public final boolean GL_NV_vertex_attrib_integer_64bit;
/*       */   public final boolean GL_NV_vertex_buffer_unified_memory;
/*       */   public final boolean GL_NV_viewport_array2;
/*       */   public final boolean GL_NV_viewport_swizzle;
/*       */   public final boolean GL_NVX_blend_equation_advanced_multi_draw_buffers;
/*       */   public final boolean GL_NVX_conditional_render;
/*       */   public final boolean GL_NVX_gpu_memory_info;
/*       */   public final boolean GL_NVX_gpu_multicast2;
/*       */   public final boolean GL_NVX_progress_fence;
/*       */   public final boolean GL_OVR_multiview;
/*       */   public final boolean GL_OVR_multiview2;
/*       */   public final boolean GL_S3_s3tc;
/*       */   public final boolean forwardCompatible;
/*       */   final PointerBuffer addresses;
/*       */   
/*       */   GLCapabilities(FunctionProvider paramFunctionProvider, Set<String> paramSet, boolean paramBoolean, IntFunction<PointerBuffer> paramIntFunction) {
/*  4840 */     this.forwardCompatible = paramBoolean;
/*       */     
/*  4842 */     PointerBuffer pointerBuffer = paramIntFunction.apply(2228);
/*       */     
/*  4844 */     this.OpenGL11 = check_GL11(paramFunctionProvider, pointerBuffer, paramSet, paramBoolean);
/*  4845 */     this.OpenGL12 = check_GL12(paramFunctionProvider, pointerBuffer, paramSet);
/*  4846 */     this.OpenGL13 = check_GL13(paramFunctionProvider, pointerBuffer, paramSet, paramBoolean);
/*  4847 */     this.OpenGL14 = check_GL14(paramFunctionProvider, pointerBuffer, paramSet, paramBoolean);
/*  4848 */     this.OpenGL15 = check_GL15(paramFunctionProvider, pointerBuffer, paramSet);
/*  4849 */     this.OpenGL20 = check_GL20(paramFunctionProvider, pointerBuffer, paramSet);
/*  4850 */     this.OpenGL21 = check_GL21(paramFunctionProvider, pointerBuffer, paramSet);
/*  4851 */     this.OpenGL30 = check_GL30(paramFunctionProvider, pointerBuffer, paramSet);
/*  4852 */     this.OpenGL31 = check_GL31(paramFunctionProvider, pointerBuffer, paramSet);
/*  4853 */     this.OpenGL32 = check_GL32(paramFunctionProvider, pointerBuffer, paramSet);
/*  4854 */     this.OpenGL33 = check_GL33(paramFunctionProvider, pointerBuffer, paramSet, paramBoolean);
/*  4855 */     this.OpenGL40 = check_GL40(paramFunctionProvider, pointerBuffer, paramSet);
/*  4856 */     this.OpenGL41 = check_GL41(paramFunctionProvider, pointerBuffer, paramSet);
/*  4857 */     this.OpenGL42 = check_GL42(paramFunctionProvider, pointerBuffer, paramSet);
/*  4858 */     this.OpenGL43 = check_GL43(paramFunctionProvider, pointerBuffer, paramSet);
/*  4859 */     this.OpenGL44 = check_GL44(paramFunctionProvider, pointerBuffer, paramSet);
/*  4860 */     this.OpenGL45 = check_GL45(paramFunctionProvider, pointerBuffer, paramSet);
/*  4861 */     this.OpenGL46 = check_GL46(paramFunctionProvider, pointerBuffer, paramSet);
/*  4862 */     this.GL_3DFX_texture_compression_FXT1 = paramSet.contains("GL_3DFX_texture_compression_FXT1");
/*  4863 */     this.GL_AMD_blend_minmax_factor = paramSet.contains("GL_AMD_blend_minmax_factor");
/*  4864 */     this.GL_AMD_conservative_depth = paramSet.contains("GL_AMD_conservative_depth");
/*  4865 */     this.GL_AMD_debug_output = check_AMD_debug_output(paramFunctionProvider, pointerBuffer, paramSet);
/*  4866 */     this.GL_AMD_depth_clamp_separate = paramSet.contains("GL_AMD_depth_clamp_separate");
/*  4867 */     this.GL_AMD_draw_buffers_blend = check_AMD_draw_buffers_blend(paramFunctionProvider, pointerBuffer, paramSet);
/*  4868 */     this.GL_AMD_framebuffer_multisample_advanced = check_AMD_framebuffer_multisample_advanced(paramFunctionProvider, pointerBuffer, paramSet);
/*  4869 */     this.GL_AMD_gcn_shader = paramSet.contains("GL_AMD_gcn_shader");
/*  4870 */     this.GL_AMD_gpu_shader_half_float = paramSet.contains("GL_AMD_gpu_shader_half_float");
/*  4871 */     this.GL_AMD_gpu_shader_half_float_fetch = paramSet.contains("GL_AMD_gpu_shader_half_float_fetch");
/*  4872 */     this.GL_AMD_gpu_shader_int16 = paramSet.contains("GL_AMD_gpu_shader_int16");
/*  4873 */     this.GL_AMD_gpu_shader_int64 = check_AMD_gpu_shader_int64(paramFunctionProvider, pointerBuffer, paramSet);
/*  4874 */     this.GL_AMD_interleaved_elements = check_AMD_interleaved_elements(paramFunctionProvider, pointerBuffer, paramSet);
/*  4875 */     this.GL_AMD_occlusion_query_event = check_AMD_occlusion_query_event(paramFunctionProvider, pointerBuffer, paramSet);
/*  4876 */     this.GL_AMD_performance_monitor = check_AMD_performance_monitor(paramFunctionProvider, pointerBuffer, paramSet);
/*  4877 */     this.GL_AMD_pinned_memory = paramSet.contains("GL_AMD_pinned_memory");
/*  4878 */     this.GL_AMD_query_buffer_object = paramSet.contains("GL_AMD_query_buffer_object");
/*  4879 */     this.GL_AMD_sample_positions = check_AMD_sample_positions(paramFunctionProvider, pointerBuffer, paramSet);
/*  4880 */     this.GL_AMD_seamless_cubemap_per_texture = paramSet.contains("GL_AMD_seamless_cubemap_per_texture");
/*  4881 */     this.GL_AMD_shader_atomic_counter_ops = paramSet.contains("GL_AMD_shader_atomic_counter_ops");
/*  4882 */     this.GL_AMD_shader_ballot = paramSet.contains("GL_AMD_shader_ballot");
/*  4883 */     this.GL_AMD_shader_explicit_vertex_parameter = paramSet.contains("GL_AMD_shader_explicit_vertex_parameter");
/*  4884 */     this.GL_AMD_shader_image_load_store_lod = paramSet.contains("GL_AMD_shader_image_load_store_lod");
/*  4885 */     this.GL_AMD_shader_stencil_export = paramSet.contains("GL_AMD_shader_stencil_export");
/*  4886 */     this.GL_AMD_shader_trinary_minmax = paramSet.contains("GL_AMD_shader_trinary_minmax");
/*  4887 */     this.GL_AMD_sparse_texture = check_AMD_sparse_texture(paramFunctionProvider, pointerBuffer, paramSet);
/*  4888 */     this.GL_AMD_stencil_operation_extended = check_AMD_stencil_operation_extended(paramFunctionProvider, pointerBuffer, paramSet);
/*  4889 */     this.GL_AMD_texture_gather_bias_lod = paramSet.contains("GL_AMD_texture_gather_bias_lod");
/*  4890 */     this.GL_AMD_texture_texture4 = paramSet.contains("GL_AMD_texture_texture4");
/*  4891 */     this.GL_AMD_transform_feedback3_lines_triangles = paramSet.contains("GL_AMD_transform_feedback3_lines_triangles");
/*  4892 */     this.GL_AMD_transform_feedback4 = paramSet.contains("GL_AMD_transform_feedback4");
/*  4893 */     this.GL_AMD_vertex_shader_layer = paramSet.contains("GL_AMD_vertex_shader_layer");
/*  4894 */     this.GL_AMD_vertex_shader_tessellator = check_AMD_vertex_shader_tessellator(paramFunctionProvider, pointerBuffer, paramSet);
/*  4895 */     this.GL_AMD_vertex_shader_viewport_index = paramSet.contains("GL_AMD_vertex_shader_viewport_index");
/*  4896 */     this.GL_ARB_arrays_of_arrays = paramSet.contains("GL_ARB_arrays_of_arrays");
/*  4897 */     this.GL_ARB_base_instance = check_ARB_base_instance(paramFunctionProvider, pointerBuffer, paramSet);
/*  4898 */     this.GL_ARB_bindless_texture = check_ARB_bindless_texture(paramFunctionProvider, pointerBuffer, paramSet);
/*  4899 */     this.GL_ARB_blend_func_extended = check_ARB_blend_func_extended(paramFunctionProvider, pointerBuffer, paramSet);
/*  4900 */     this.GL_ARB_buffer_storage = check_ARB_buffer_storage(paramFunctionProvider, pointerBuffer, paramSet);
/*  4901 */     this.GL_ARB_cl_event = check_ARB_cl_event(paramFunctionProvider, pointerBuffer, paramSet);
/*  4902 */     this.GL_ARB_clear_buffer_object = check_ARB_clear_buffer_object(paramFunctionProvider, pointerBuffer, paramSet);
/*  4903 */     this.GL_ARB_clear_texture = check_ARB_clear_texture(paramFunctionProvider, pointerBuffer, paramSet);
/*  4904 */     this.GL_ARB_clip_control = check_ARB_clip_control(paramFunctionProvider, pointerBuffer, paramSet);
/*  4905 */     this.GL_ARB_color_buffer_float = check_ARB_color_buffer_float(paramFunctionProvider, pointerBuffer, paramSet);
/*  4906 */     this.GL_ARB_compatibility = paramSet.contains("GL_ARB_compatibility");
/*  4907 */     this.GL_ARB_compressed_texture_pixel_storage = paramSet.contains("GL_ARB_compressed_texture_pixel_storage");
/*  4908 */     this.GL_ARB_compute_shader = check_ARB_compute_shader(paramFunctionProvider, pointerBuffer, paramSet);
/*  4909 */     this.GL_ARB_compute_variable_group_size = check_ARB_compute_variable_group_size(paramFunctionProvider, pointerBuffer, paramSet);
/*  4910 */     this.GL_ARB_conditional_render_inverted = paramSet.contains("GL_ARB_conditional_render_inverted");
/*  4911 */     this.GL_ARB_conservative_depth = paramSet.contains("GL_ARB_conservative_depth");
/*  4912 */     this.GL_ARB_copy_buffer = check_ARB_copy_buffer(paramFunctionProvider, pointerBuffer, paramSet);
/*  4913 */     this.GL_ARB_copy_image = check_ARB_copy_image(paramFunctionProvider, pointerBuffer, paramSet);
/*  4914 */     this.GL_ARB_cull_distance = paramSet.contains("GL_ARB_cull_distance");
/*  4915 */     this.GL_ARB_debug_output = check_ARB_debug_output(paramFunctionProvider, pointerBuffer, paramSet);
/*  4916 */     this.GL_ARB_depth_buffer_float = paramSet.contains("GL_ARB_depth_buffer_float");
/*  4917 */     this.GL_ARB_depth_clamp = paramSet.contains("GL_ARB_depth_clamp");
/*  4918 */     this.GL_ARB_depth_texture = paramSet.contains("GL_ARB_depth_texture");
/*  4919 */     this.GL_ARB_derivative_control = paramSet.contains("GL_ARB_derivative_control");
/*  4920 */     this.GL_ARB_direct_state_access = check_ARB_direct_state_access(paramFunctionProvider, pointerBuffer, paramSet);
/*  4921 */     this.GL_ARB_draw_buffers = check_ARB_draw_buffers(paramFunctionProvider, pointerBuffer, paramSet);
/*  4922 */     this.GL_ARB_draw_buffers_blend = check_ARB_draw_buffers_blend(paramFunctionProvider, pointerBuffer, paramSet);
/*  4923 */     this.GL_ARB_draw_elements_base_vertex = check_ARB_draw_elements_base_vertex(paramFunctionProvider, pointerBuffer, paramSet);
/*  4924 */     this.GL_ARB_draw_indirect = check_ARB_draw_indirect(paramFunctionProvider, pointerBuffer, paramSet);
/*  4925 */     this.GL_ARB_draw_instanced = check_ARB_draw_instanced(paramFunctionProvider, pointerBuffer, paramSet);
/*  4926 */     this.GL_ARB_enhanced_layouts = paramSet.contains("GL_ARB_enhanced_layouts");
/*  4927 */     this.GL_ARB_ES2_compatibility = check_ARB_ES2_compatibility(paramFunctionProvider, pointerBuffer, paramSet);
/*  4928 */     this.GL_ARB_ES3_1_compatibility = check_ARB_ES3_1_compatibility(paramFunctionProvider, pointerBuffer, paramSet);
/*  4929 */     this.GL_ARB_ES3_2_compatibility = check_ARB_ES3_2_compatibility(paramFunctionProvider, pointerBuffer, paramSet);
/*  4930 */     this.GL_ARB_ES3_compatibility = paramSet.contains("GL_ARB_ES3_compatibility");
/*  4931 */     this.GL_ARB_explicit_attrib_location = paramSet.contains("GL_ARB_explicit_attrib_location");
/*  4932 */     this.GL_ARB_explicit_uniform_location = paramSet.contains("GL_ARB_explicit_uniform_location");
/*  4933 */     this.GL_ARB_fragment_coord_conventions = paramSet.contains("GL_ARB_fragment_coord_conventions");
/*  4934 */     this.GL_ARB_fragment_layer_viewport = paramSet.contains("GL_ARB_fragment_layer_viewport");
/*  4935 */     this.GL_ARB_fragment_program = paramSet.contains("GL_ARB_fragment_program");
/*  4936 */     this.GL_ARB_fragment_program_shadow = paramSet.contains("GL_ARB_fragment_program_shadow");
/*  4937 */     this.GL_ARB_fragment_shader = paramSet.contains("GL_ARB_fragment_shader");
/*  4938 */     this.GL_ARB_fragment_shader_interlock = paramSet.contains("GL_ARB_fragment_shader_interlock");
/*  4939 */     this.GL_ARB_framebuffer_no_attachments = check_ARB_framebuffer_no_attachments(paramFunctionProvider, pointerBuffer, paramSet);
/*  4940 */     this.GL_ARB_framebuffer_object = check_ARB_framebuffer_object(paramFunctionProvider, pointerBuffer, paramSet);
/*  4941 */     this.GL_ARB_framebuffer_sRGB = paramSet.contains("GL_ARB_framebuffer_sRGB");
/*  4942 */     this.GL_ARB_geometry_shader4 = check_ARB_geometry_shader4(paramFunctionProvider, pointerBuffer, paramSet);
/*  4943 */     this.GL_ARB_get_program_binary = check_ARB_get_program_binary(paramFunctionProvider, pointerBuffer, paramSet);
/*  4944 */     this.GL_ARB_get_texture_sub_image = check_ARB_get_texture_sub_image(paramFunctionProvider, pointerBuffer, paramSet);
/*  4945 */     this.GL_ARB_gl_spirv = check_ARB_gl_spirv(paramFunctionProvider, pointerBuffer, paramSet);
/*  4946 */     this.GL_ARB_gpu_shader5 = paramSet.contains("GL_ARB_gpu_shader5");
/*  4947 */     this.GL_ARB_gpu_shader_fp64 = check_ARB_gpu_shader_fp64(paramFunctionProvider, pointerBuffer, paramSet);
/*  4948 */     this.GL_ARB_gpu_shader_int64 = check_ARB_gpu_shader_int64(paramFunctionProvider, pointerBuffer, paramSet);
/*  4949 */     this.GL_ARB_half_float_pixel = paramSet.contains("GL_ARB_half_float_pixel");
/*  4950 */     this.GL_ARB_half_float_vertex = paramSet.contains("GL_ARB_half_float_vertex");
/*  4951 */     this.GL_ARB_imaging = check_ARB_imaging(paramFunctionProvider, pointerBuffer, paramSet, paramBoolean);
/*  4952 */     this.GL_ARB_indirect_parameters = check_ARB_indirect_parameters(paramFunctionProvider, pointerBuffer, paramSet);
/*  4953 */     this.GL_ARB_instanced_arrays = check_ARB_instanced_arrays(paramFunctionProvider, pointerBuffer, paramSet);
/*  4954 */     this.GL_ARB_internalformat_query = check_ARB_internalformat_query(paramFunctionProvider, pointerBuffer, paramSet);
/*  4955 */     this.GL_ARB_internalformat_query2 = check_ARB_internalformat_query2(paramFunctionProvider, pointerBuffer, paramSet);
/*  4956 */     this.GL_ARB_invalidate_subdata = check_ARB_invalidate_subdata(paramFunctionProvider, pointerBuffer, paramSet);
/*  4957 */     this.GL_ARB_map_buffer_alignment = paramSet.contains("GL_ARB_map_buffer_alignment");
/*  4958 */     this.GL_ARB_map_buffer_range = check_ARB_map_buffer_range(paramFunctionProvider, pointerBuffer, paramSet);
/*  4959 */     this.GL_ARB_matrix_palette = check_ARB_matrix_palette(paramFunctionProvider, pointerBuffer, paramSet);
/*  4960 */     this.GL_ARB_multi_bind = check_ARB_multi_bind(paramFunctionProvider, pointerBuffer, paramSet);
/*  4961 */     this.GL_ARB_multi_draw_indirect = check_ARB_multi_draw_indirect(paramFunctionProvider, pointerBuffer, paramSet);
/*  4962 */     this.GL_ARB_multisample = check_ARB_multisample(paramFunctionProvider, pointerBuffer, paramSet);
/*  4963 */     this.GL_ARB_multitexture = check_ARB_multitexture(paramFunctionProvider, pointerBuffer, paramSet);
/*  4964 */     this.GL_ARB_occlusion_query = check_ARB_occlusion_query(paramFunctionProvider, pointerBuffer, paramSet);
/*  4965 */     this.GL_ARB_occlusion_query2 = paramSet.contains("GL_ARB_occlusion_query2");
/*  4966 */     this.GL_ARB_parallel_shader_compile = check_ARB_parallel_shader_compile(paramFunctionProvider, pointerBuffer, paramSet);
/*  4967 */     this.GL_ARB_pipeline_statistics_query = paramSet.contains("GL_ARB_pipeline_statistics_query");
/*  4968 */     this.GL_ARB_pixel_buffer_object = paramSet.contains("GL_ARB_pixel_buffer_object");
/*  4969 */     this.GL_ARB_point_parameters = check_ARB_point_parameters(paramFunctionProvider, pointerBuffer, paramSet);
/*  4970 */     this.GL_ARB_point_sprite = paramSet.contains("GL_ARB_point_sprite");
/*  4971 */     this.GL_ARB_polygon_offset_clamp = check_ARB_polygon_offset_clamp(paramFunctionProvider, pointerBuffer, paramSet);
/*  4972 */     this.GL_ARB_post_depth_coverage = paramSet.contains("GL_ARB_post_depth_coverage");
/*  4973 */     this.GL_ARB_program_interface_query = check_ARB_program_interface_query(paramFunctionProvider, pointerBuffer, paramSet);
/*  4974 */     this.GL_ARB_provoking_vertex = check_ARB_provoking_vertex(paramFunctionProvider, pointerBuffer, paramSet);
/*  4975 */     this.GL_ARB_query_buffer_object = paramSet.contains("GL_ARB_query_buffer_object");
/*  4976 */     this.GL_ARB_robust_buffer_access_behavior = paramSet.contains("GL_ARB_robust_buffer_access_behavior");
/*  4977 */     this.GL_ARB_robustness = check_ARB_robustness(paramFunctionProvider, pointerBuffer, paramSet);
/*  4978 */     this.GL_ARB_robustness_application_isolation = paramSet.contains("GL_ARB_robustness_application_isolation");
/*  4979 */     this.GL_ARB_robustness_share_group_isolation = paramSet.contains("GL_ARB_robustness_share_group_isolation");
/*  4980 */     this.GL_ARB_sample_locations = check_ARB_sample_locations(paramFunctionProvider, pointerBuffer, paramSet);
/*  4981 */     this.GL_ARB_sample_shading = check_ARB_sample_shading(paramFunctionProvider, pointerBuffer, paramSet);
/*  4982 */     this.GL_ARB_sampler_objects = check_ARB_sampler_objects(paramFunctionProvider, pointerBuffer, paramSet);
/*  4983 */     this.GL_ARB_seamless_cube_map = paramSet.contains("GL_ARB_seamless_cube_map");
/*  4984 */     this.GL_ARB_seamless_cubemap_per_texture = paramSet.contains("GL_ARB_seamless_cubemap_per_texture");
/*  4985 */     this.GL_ARB_separate_shader_objects = check_ARB_separate_shader_objects(paramFunctionProvider, pointerBuffer, paramSet);
/*  4986 */     this.GL_ARB_shader_atomic_counter_ops = paramSet.contains("GL_ARB_shader_atomic_counter_ops");
/*  4987 */     this.GL_ARB_shader_atomic_counters = check_ARB_shader_atomic_counters(paramFunctionProvider, pointerBuffer, paramSet);
/*  4988 */     this.GL_ARB_shader_ballot = paramSet.contains("GL_ARB_shader_ballot");
/*  4989 */     this.GL_ARB_shader_bit_encoding = paramSet.contains("GL_ARB_shader_bit_encoding");
/*  4990 */     this.GL_ARB_shader_clock = paramSet.contains("GL_ARB_shader_clock");
/*  4991 */     this.GL_ARB_shader_draw_parameters = paramSet.contains("GL_ARB_shader_draw_parameters");
/*  4992 */     this.GL_ARB_shader_group_vote = paramSet.contains("GL_ARB_shader_group_vote");
/*  4993 */     this.GL_ARB_shader_image_load_store = check_ARB_shader_image_load_store(paramFunctionProvider, pointerBuffer, paramSet);
/*  4994 */     this.GL_ARB_shader_image_size = paramSet.contains("GL_ARB_shader_image_size");
/*  4995 */     this.GL_ARB_shader_objects = check_ARB_shader_objects(paramFunctionProvider, pointerBuffer, paramSet);
/*  4996 */     this.GL_ARB_shader_precision = paramSet.contains("GL_ARB_shader_precision");
/*  4997 */     this.GL_ARB_shader_stencil_export = paramSet.contains("GL_ARB_shader_stencil_export");
/*  4998 */     this.GL_ARB_shader_storage_buffer_object = check_ARB_shader_storage_buffer_object(paramFunctionProvider, pointerBuffer, paramSet);
/*  4999 */     this.GL_ARB_shader_subroutine = check_ARB_shader_subroutine(paramFunctionProvider, pointerBuffer, paramSet);
/*  5000 */     this.GL_ARB_shader_texture_image_samples = paramSet.contains("GL_ARB_shader_texture_image_samples");
/*  5001 */     this.GL_ARB_shader_texture_lod = paramSet.contains("GL_ARB_shader_texture_lod");
/*  5002 */     this.GL_ARB_shader_viewport_layer_array = paramSet.contains("GL_ARB_shader_viewport_layer_array");
/*  5003 */     this.GL_ARB_shading_language_100 = paramSet.contains("GL_ARB_shading_language_100");
/*  5004 */     this.GL_ARB_shading_language_420pack = paramSet.contains("GL_ARB_shading_language_420pack");
/*  5005 */     this.GL_ARB_shading_language_include = check_ARB_shading_language_include(paramFunctionProvider, pointerBuffer, paramSet);
/*  5006 */     this.GL_ARB_shading_language_packing = paramSet.contains("GL_ARB_shading_language_packing");
/*  5007 */     this.GL_ARB_shadow = paramSet.contains("GL_ARB_shadow");
/*  5008 */     this.GL_ARB_shadow_ambient = paramSet.contains("GL_ARB_shadow_ambient");
/*  5009 */     this.GL_ARB_sparse_buffer = check_ARB_sparse_buffer(paramFunctionProvider, pointerBuffer, paramSet);
/*  5010 */     this.GL_ARB_sparse_texture = check_ARB_sparse_texture(paramFunctionProvider, pointerBuffer, paramSet);
/*  5011 */     this.GL_ARB_sparse_texture2 = paramSet.contains("GL_ARB_sparse_texture2");
/*  5012 */     this.GL_ARB_sparse_texture_clamp = paramSet.contains("GL_ARB_sparse_texture_clamp");
/*  5013 */     this.GL_ARB_spirv_extensions = paramSet.contains("GL_ARB_spirv_extensions");
/*  5014 */     this.GL_ARB_stencil_texturing = paramSet.contains("GL_ARB_stencil_texturing");
/*  5015 */     this.GL_ARB_sync = check_ARB_sync(paramFunctionProvider, pointerBuffer, paramSet);
/*  5016 */     this.GL_ARB_tessellation_shader = check_ARB_tessellation_shader(paramFunctionProvider, pointerBuffer, paramSet);
/*  5017 */     this.GL_ARB_texture_barrier = check_ARB_texture_barrier(paramFunctionProvider, pointerBuffer, paramSet);
/*  5018 */     this.GL_ARB_texture_border_clamp = paramSet.contains("GL_ARB_texture_border_clamp");
/*  5019 */     this.GL_ARB_texture_buffer_object = check_ARB_texture_buffer_object(paramFunctionProvider, pointerBuffer, paramSet);
/*  5020 */     this.GL_ARB_texture_buffer_object_rgb32 = paramSet.contains("GL_ARB_texture_buffer_object_rgb32");
/*  5021 */     this.GL_ARB_texture_buffer_range = check_ARB_texture_buffer_range(paramFunctionProvider, pointerBuffer, paramSet);
/*  5022 */     this.GL_ARB_texture_compression = check_ARB_texture_compression(paramFunctionProvider, pointerBuffer, paramSet);
/*  5023 */     this.GL_ARB_texture_compression_bptc = paramSet.contains("GL_ARB_texture_compression_bptc");
/*  5024 */     this.GL_ARB_texture_compression_rgtc = paramSet.contains("GL_ARB_texture_compression_rgtc");
/*  5025 */     this.GL_ARB_texture_cube_map = paramSet.contains("GL_ARB_texture_cube_map");
/*  5026 */     this.GL_ARB_texture_cube_map_array = paramSet.contains("GL_ARB_texture_cube_map_array");
/*  5027 */     this.GL_ARB_texture_env_add = paramSet.contains("GL_ARB_texture_env_add");
/*  5028 */     this.GL_ARB_texture_env_combine = paramSet.contains("GL_ARB_texture_env_combine");
/*  5029 */     this.GL_ARB_texture_env_crossbar = paramSet.contains("GL_ARB_texture_env_crossbar");
/*  5030 */     this.GL_ARB_texture_env_dot3 = paramSet.contains("GL_ARB_texture_env_dot3");
/*  5031 */     this.GL_ARB_texture_filter_anisotropic = paramSet.contains("GL_ARB_texture_filter_anisotropic");
/*  5032 */     this.GL_ARB_texture_filter_minmax = paramSet.contains("GL_ARB_texture_filter_minmax");
/*  5033 */     this.GL_ARB_texture_float = paramSet.contains("GL_ARB_texture_float");
/*  5034 */     this.GL_ARB_texture_gather = paramSet.contains("GL_ARB_texture_gather");
/*  5035 */     this.GL_ARB_texture_mirror_clamp_to_edge = paramSet.contains("GL_ARB_texture_mirror_clamp_to_edge");
/*  5036 */     this.GL_ARB_texture_mirrored_repeat = paramSet.contains("GL_ARB_texture_mirrored_repeat");
/*  5037 */     this.GL_ARB_texture_multisample = check_ARB_texture_multisample(paramFunctionProvider, pointerBuffer, paramSet);
/*  5038 */     this.GL_ARB_texture_non_power_of_two = paramSet.contains("GL_ARB_texture_non_power_of_two");
/*  5039 */     this.GL_ARB_texture_query_levels = paramSet.contains("GL_ARB_texture_query_levels");
/*  5040 */     this.GL_ARB_texture_query_lod = paramSet.contains("GL_ARB_texture_query_lod");
/*  5041 */     this.GL_ARB_texture_rectangle = paramSet.contains("GL_ARB_texture_rectangle");
/*  5042 */     this.GL_ARB_texture_rg = paramSet.contains("GL_ARB_texture_rg");
/*  5043 */     this.GL_ARB_texture_rgb10_a2ui = paramSet.contains("GL_ARB_texture_rgb10_a2ui");
/*  5044 */     this.GL_ARB_texture_stencil8 = paramSet.contains("GL_ARB_texture_stencil8");
/*  5045 */     this.GL_ARB_texture_storage = check_ARB_texture_storage(paramFunctionProvider, pointerBuffer, paramSet);
/*  5046 */     this.GL_ARB_texture_storage_multisample = check_ARB_texture_storage_multisample(paramFunctionProvider, pointerBuffer, paramSet);
/*  5047 */     this.GL_ARB_texture_swizzle = paramSet.contains("GL_ARB_texture_swizzle");
/*  5048 */     this.GL_ARB_texture_view = check_ARB_texture_view(paramFunctionProvider, pointerBuffer, paramSet);
/*  5049 */     this.GL_ARB_timer_query = check_ARB_timer_query(paramFunctionProvider, pointerBuffer, paramSet);
/*  5050 */     this.GL_ARB_transform_feedback2 = check_ARB_transform_feedback2(paramFunctionProvider, pointerBuffer, paramSet);
/*  5051 */     this.GL_ARB_transform_feedback3 = check_ARB_transform_feedback3(paramFunctionProvider, pointerBuffer, paramSet);
/*  5052 */     this.GL_ARB_transform_feedback_instanced = check_ARB_transform_feedback_instanced(paramFunctionProvider, pointerBuffer, paramSet);
/*  5053 */     this.GL_ARB_transform_feedback_overflow_query = paramSet.contains("GL_ARB_transform_feedback_overflow_query");
/*  5054 */     this.GL_ARB_transpose_matrix = check_ARB_transpose_matrix(paramFunctionProvider, pointerBuffer, paramSet);
/*  5055 */     this.GL_ARB_uniform_buffer_object = check_ARB_uniform_buffer_object(paramFunctionProvider, pointerBuffer, paramSet);
/*  5056 */     this.GL_ARB_vertex_array_bgra = paramSet.contains("GL_ARB_vertex_array_bgra");
/*  5057 */     this.GL_ARB_vertex_array_object = check_ARB_vertex_array_object(paramFunctionProvider, pointerBuffer, paramSet);
/*  5058 */     this.GL_ARB_vertex_attrib_64bit = check_ARB_vertex_attrib_64bit(paramFunctionProvider, pointerBuffer, paramSet);
/*  5059 */     this.GL_ARB_vertex_attrib_binding = check_ARB_vertex_attrib_binding(paramFunctionProvider, pointerBuffer, paramSet);
/*  5060 */     this.GL_ARB_vertex_blend = check_ARB_vertex_blend(paramFunctionProvider, pointerBuffer, paramSet);
/*  5061 */     this.GL_ARB_vertex_buffer_object = check_ARB_vertex_buffer_object(paramFunctionProvider, pointerBuffer, paramSet);
/*  5062 */     this.GL_ARB_vertex_program = check_ARB_vertex_program(paramFunctionProvider, pointerBuffer, paramSet);
/*  5063 */     this.GL_ARB_vertex_shader = check_ARB_vertex_shader(paramFunctionProvider, pointerBuffer, paramSet);
/*  5064 */     this.GL_ARB_vertex_type_10f_11f_11f_rev = paramSet.contains("GL_ARB_vertex_type_10f_11f_11f_rev");
/*  5065 */     this.GL_ARB_vertex_type_2_10_10_10_rev = check_ARB_vertex_type_2_10_10_10_rev(paramFunctionProvider, pointerBuffer, paramSet, paramBoolean);
/*  5066 */     this.GL_ARB_viewport_array = check_ARB_viewport_array(paramFunctionProvider, pointerBuffer, paramSet);
/*  5067 */     this.GL_ARB_window_pos = check_ARB_window_pos(paramFunctionProvider, pointerBuffer, paramSet);
/*  5068 */     this.GL_ATI_meminfo = paramSet.contains("GL_ATI_meminfo");
/*  5069 */     this.GL_ATI_shader_texture_lod = paramSet.contains("GL_ATI_shader_texture_lod");
/*  5070 */     this.GL_ATI_texture_compression_3dc = paramSet.contains("GL_ATI_texture_compression_3dc");
/*  5071 */     this.GL_EXT_422_pixels = paramSet.contains("GL_EXT_422_pixels");
/*  5072 */     this.GL_EXT_abgr = paramSet.contains("GL_EXT_abgr");
/*  5073 */     this.GL_EXT_bgra = paramSet.contains("GL_EXT_bgra");
/*  5074 */     this.GL_EXT_bindable_uniform = check_EXT_bindable_uniform(paramFunctionProvider, pointerBuffer, paramSet);
/*  5075 */     this.GL_EXT_blend_color = check_EXT_blend_color(paramFunctionProvider, pointerBuffer, paramSet);
/*  5076 */     this.GL_EXT_blend_equation_separate = check_EXT_blend_equation_separate(paramFunctionProvider, pointerBuffer, paramSet);
/*  5077 */     this.GL_EXT_blend_func_separate = check_EXT_blend_func_separate(paramFunctionProvider, pointerBuffer, paramSet);
/*  5078 */     this.GL_EXT_blend_minmax = check_EXT_blend_minmax(paramFunctionProvider, pointerBuffer, paramSet);
/*  5079 */     this.GL_EXT_blend_subtract = paramSet.contains("GL_EXT_blend_subtract");
/*  5080 */     this.GL_EXT_clip_volume_hint = paramSet.contains("GL_EXT_clip_volume_hint");
/*  5081 */     this.GL_EXT_compiled_vertex_array = check_EXT_compiled_vertex_array(paramFunctionProvider, pointerBuffer, paramSet);
/*  5082 */     this.GL_EXT_debug_label = check_EXT_debug_label(paramFunctionProvider, pointerBuffer, paramSet);
/*  5083 */     this.GL_EXT_debug_marker = check_EXT_debug_marker(paramFunctionProvider, pointerBuffer, paramSet);
/*  5084 */     this.GL_EXT_depth_bounds_test = check_EXT_depth_bounds_test(paramFunctionProvider, pointerBuffer, paramSet);
/*  5085 */     this.GL_EXT_direct_state_access = check_EXT_direct_state_access(paramFunctionProvider, pointerBuffer, paramSet);
/*  5086 */     this.GL_EXT_draw_buffers2 = check_EXT_draw_buffers2(paramFunctionProvider, pointerBuffer, paramSet);
/*  5087 */     this.GL_EXT_draw_instanced = check_EXT_draw_instanced(paramFunctionProvider, pointerBuffer, paramSet);
/*  5088 */     this.GL_EXT_EGL_image_storage = check_EXT_EGL_image_storage(paramFunctionProvider, pointerBuffer, paramSet);
/*  5089 */     this.GL_EXT_EGL_sync = paramSet.contains("GL_EXT_EGL_sync");
/*  5090 */     this.GL_EXT_external_buffer = check_EXT_external_buffer(paramFunctionProvider, pointerBuffer, paramSet);
/*  5091 */     this.GL_EXT_framebuffer_blit = check_EXT_framebuffer_blit(paramFunctionProvider, pointerBuffer, paramSet);
/*  5092 */     this.GL_EXT_framebuffer_blit_layers = check_EXT_framebuffer_blit_layers(paramFunctionProvider, pointerBuffer, paramSet);
/*  5093 */     this.GL_EXT_framebuffer_multisample = check_EXT_framebuffer_multisample(paramFunctionProvider, pointerBuffer, paramSet);
/*  5094 */     this.GL_EXT_framebuffer_multisample_blit_scaled = paramSet.contains("GL_EXT_framebuffer_multisample_blit_scaled");
/*  5095 */     this.GL_EXT_framebuffer_object = check_EXT_framebuffer_object(paramFunctionProvider, pointerBuffer, paramSet);
/*  5096 */     this.GL_EXT_framebuffer_sRGB = paramSet.contains("GL_EXT_framebuffer_sRGB");
/*  5097 */     this.GL_EXT_geometry_shader4 = check_EXT_geometry_shader4(paramFunctionProvider, pointerBuffer, paramSet);
/*  5098 */     this.GL_EXT_gpu_program_parameters = check_EXT_gpu_program_parameters(paramFunctionProvider, pointerBuffer, paramSet);
/*  5099 */     this.GL_EXT_gpu_shader4 = check_EXT_gpu_shader4(paramFunctionProvider, pointerBuffer, paramSet);
/*  5100 */     this.GL_EXT_memory_object = check_EXT_memory_object(paramFunctionProvider, pointerBuffer, paramSet);
/*  5101 */     this.GL_EXT_memory_object_fd = check_EXT_memory_object_fd(paramFunctionProvider, pointerBuffer, paramSet);
/*  5102 */     this.GL_EXT_memory_object_win32 = check_EXT_memory_object_win32(paramFunctionProvider, pointerBuffer, paramSet);
/*  5103 */     this.GL_EXT_multiview_tessellation_geometry_shader = paramSet.contains("GL_EXT_multiview_tessellation_geometry_shader");
/*  5104 */     this.GL_EXT_multiview_texture_multisample = paramSet.contains("GL_EXT_multiview_texture_multisample");
/*  5105 */     this.GL_EXT_multiview_timer_query = paramSet.contains("GL_EXT_multiview_timer_query");
/*  5106 */     this.GL_EXT_packed_depth_stencil = paramSet.contains("GL_EXT_packed_depth_stencil");
/*  5107 */     this.GL_EXT_packed_float = paramSet.contains("GL_EXT_packed_float");
/*  5108 */     this.GL_EXT_pixel_buffer_object = paramSet.contains("GL_EXT_pixel_buffer_object");
/*  5109 */     this.GL_EXT_point_parameters = check_EXT_point_parameters(paramFunctionProvider, pointerBuffer, paramSet);
/*  5110 */     this.GL_EXT_polygon_offset_clamp = check_EXT_polygon_offset_clamp(paramFunctionProvider, pointerBuffer, paramSet);
/*  5111 */     this.GL_EXT_post_depth_coverage = paramSet.contains("GL_EXT_post_depth_coverage");
/*  5112 */     this.GL_EXT_provoking_vertex = check_EXT_provoking_vertex(paramFunctionProvider, pointerBuffer, paramSet);
/*  5113 */     this.GL_EXT_raster_multisample = check_EXT_raster_multisample(paramFunctionProvider, pointerBuffer, paramSet);
/*  5114 */     this.GL_EXT_secondary_color = check_EXT_secondary_color(paramFunctionProvider, pointerBuffer, paramSet);
/*  5115 */     this.GL_EXT_semaphore = check_EXT_semaphore(paramFunctionProvider, pointerBuffer, paramSet);
/*  5116 */     this.GL_EXT_semaphore_fd = check_EXT_semaphore_fd(paramFunctionProvider, pointerBuffer, paramSet);
/*  5117 */     this.GL_EXT_semaphore_win32 = check_EXT_semaphore_win32(paramFunctionProvider, pointerBuffer, paramSet);
/*  5118 */     this.GL_EXT_separate_shader_objects = check_EXT_separate_shader_objects(paramFunctionProvider, pointerBuffer, paramSet);
/*  5119 */     this.GL_EXT_shader_framebuffer_fetch = paramSet.contains("GL_EXT_shader_framebuffer_fetch");
/*  5120 */     this.GL_EXT_shader_framebuffer_fetch_non_coherent = check_EXT_shader_framebuffer_fetch_non_coherent(paramFunctionProvider, pointerBuffer, paramSet);
/*  5121 */     this.GL_EXT_shader_image_load_formatted = paramSet.contains("GL_EXT_shader_image_load_formatted");
/*  5122 */     this.GL_EXT_shader_image_load_store = check_EXT_shader_image_load_store(paramFunctionProvider, pointerBuffer, paramSet);
/*  5123 */     this.GL_EXT_shader_integer_mix = paramSet.contains("GL_EXT_shader_integer_mix");
/*  5124 */     this.GL_EXT_shader_samples_identical = paramSet.contains("GL_EXT_shader_samples_identical");
/*  5125 */     this.GL_EXT_shadow_funcs = paramSet.contains("GL_EXT_shadow_funcs");
/*  5126 */     this.GL_EXT_shared_texture_palette = paramSet.contains("GL_EXT_shared_texture_palette");
/*  5127 */     this.GL_EXT_sparse_texture2 = paramSet.contains("GL_EXT_sparse_texture2");
/*  5128 */     this.GL_EXT_stencil_clear_tag = check_EXT_stencil_clear_tag(paramFunctionProvider, pointerBuffer, paramSet);
/*  5129 */     this.GL_EXT_stencil_two_side = check_EXT_stencil_two_side(paramFunctionProvider, pointerBuffer, paramSet);
/*  5130 */     this.GL_EXT_stencil_wrap = paramSet.contains("GL_EXT_stencil_wrap");
/*  5131 */     this.GL_EXT_texture_array = check_EXT_texture_array(paramFunctionProvider, pointerBuffer, paramSet);
/*  5132 */     this.GL_EXT_texture_buffer_object = check_EXT_texture_buffer_object(paramFunctionProvider, pointerBuffer, paramSet);
/*  5133 */     this.GL_EXT_texture_compression_latc = paramSet.contains("GL_EXT_texture_compression_latc");
/*  5134 */     this.GL_EXT_texture_compression_rgtc = paramSet.contains("GL_EXT_texture_compression_rgtc");
/*  5135 */     this.GL_EXT_texture_compression_s3tc = paramSet.contains("GL_EXT_texture_compression_s3tc");
/*  5136 */     this.GL_EXT_texture_filter_anisotropic = paramSet.contains("GL_EXT_texture_filter_anisotropic");
/*  5137 */     this.GL_EXT_texture_filter_minmax = paramSet.contains("GL_EXT_texture_filter_minmax");
/*  5138 */     this.GL_EXT_texture_integer = check_EXT_texture_integer(paramFunctionProvider, pointerBuffer, paramSet);
/*  5139 */     this.GL_EXT_texture_mirror_clamp = paramSet.contains("GL_EXT_texture_mirror_clamp");
/*  5140 */     this.GL_EXT_texture_shadow_lod = paramSet.contains("GL_EXT_texture_shadow_lod");
/*  5141 */     this.GL_EXT_texture_shared_exponent = paramSet.contains("GL_EXT_texture_shared_exponent");
/*  5142 */     this.GL_EXT_texture_snorm = paramSet.contains("GL_EXT_texture_snorm");
/*  5143 */     this.GL_EXT_texture_sRGB = paramSet.contains("GL_EXT_texture_sRGB");
/*  5144 */     this.GL_EXT_texture_sRGB_decode = paramSet.contains("GL_EXT_texture_sRGB_decode");
/*  5145 */     this.GL_EXT_texture_sRGB_R8 = paramSet.contains("GL_EXT_texture_sRGB_R8");
/*  5146 */     this.GL_EXT_texture_sRGB_RG8 = paramSet.contains("GL_EXT_texture_sRGB_RG8");
/*  5147 */     this.GL_EXT_texture_storage = check_EXT_texture_storage(paramFunctionProvider, pointerBuffer, paramSet);
/*  5148 */     this.GL_EXT_texture_swizzle = paramSet.contains("GL_EXT_texture_swizzle");
/*  5149 */     this.GL_EXT_timer_query = check_EXT_timer_query(paramFunctionProvider, pointerBuffer, paramSet);
/*  5150 */     this.GL_EXT_transform_feedback = check_EXT_transform_feedback(paramFunctionProvider, pointerBuffer, paramSet);
/*  5151 */     this.GL_EXT_vertex_array_bgra = paramSet.contains("GL_EXT_vertex_array_bgra");
/*  5152 */     this.GL_EXT_vertex_attrib_64bit = check_EXT_vertex_attrib_64bit(paramFunctionProvider, pointerBuffer, paramSet);
/*  5153 */     this.GL_EXT_win32_keyed_mutex = check_EXT_win32_keyed_mutex(paramFunctionProvider, pointerBuffer, paramSet);
/*  5154 */     this.GL_EXT_window_rectangles = check_EXT_window_rectangles(paramFunctionProvider, pointerBuffer, paramSet);
/*  5155 */     this.GL_EXT_x11_sync_object = check_EXT_x11_sync_object(paramFunctionProvider, pointerBuffer, paramSet);
/*  5156 */     this.GL_GREMEDY_frame_terminator = check_GREMEDY_frame_terminator(paramFunctionProvider, pointerBuffer, paramSet);
/*  5157 */     this.GL_GREMEDY_string_marker = check_GREMEDY_string_marker(paramFunctionProvider, pointerBuffer, paramSet);
/*  5158 */     this.GL_INTEL_blackhole_render = paramSet.contains("GL_INTEL_blackhole_render");
/*  5159 */     this.GL_INTEL_conservative_rasterization = paramSet.contains("GL_INTEL_conservative_rasterization");
/*  5160 */     this.GL_INTEL_fragment_shader_ordering = paramSet.contains("GL_INTEL_fragment_shader_ordering");
/*  5161 */     this.GL_INTEL_framebuffer_CMAA = check_INTEL_framebuffer_CMAA(paramFunctionProvider, pointerBuffer, paramSet);
/*  5162 */     this.GL_INTEL_map_texture = check_INTEL_map_texture(paramFunctionProvider, pointerBuffer, paramSet);
/*  5163 */     this.GL_INTEL_performance_query = check_INTEL_performance_query(paramFunctionProvider, pointerBuffer, paramSet);
/*  5164 */     this.GL_INTEL_shader_integer_functions2 = paramSet.contains("GL_INTEL_shader_integer_functions2");
/*  5165 */     this.GL_KHR_blend_equation_advanced = check_KHR_blend_equation_advanced(paramFunctionProvider, pointerBuffer, paramSet);
/*  5166 */     this.GL_KHR_blend_equation_advanced_coherent = paramSet.contains("GL_KHR_blend_equation_advanced_coherent");
/*  5167 */     this.GL_KHR_context_flush_control = paramSet.contains("GL_KHR_context_flush_control");
/*  5168 */     this.GL_KHR_debug = check_KHR_debug(paramFunctionProvider, pointerBuffer, paramSet);
/*  5169 */     this.GL_KHR_no_error = paramSet.contains("GL_KHR_no_error");
/*  5170 */     this.GL_KHR_parallel_shader_compile = check_KHR_parallel_shader_compile(paramFunctionProvider, pointerBuffer, paramSet);
/*  5171 */     this.GL_KHR_robust_buffer_access_behavior = paramSet.contains("GL_KHR_robust_buffer_access_behavior");
/*  5172 */     this.GL_KHR_robustness = check_KHR_robustness(paramFunctionProvider, pointerBuffer, paramSet);
/*  5173 */     this.GL_KHR_shader_subgroup = paramSet.contains("GL_KHR_shader_subgroup");
/*  5174 */     this.GL_KHR_texture_compression_astc_hdr = paramSet.contains("GL_KHR_texture_compression_astc_hdr");
/*  5175 */     this.GL_KHR_texture_compression_astc_ldr = paramSet.contains("GL_KHR_texture_compression_astc_ldr");
/*  5176 */     this.GL_KHR_texture_compression_astc_sliced_3d = paramSet.contains("GL_KHR_texture_compression_astc_sliced_3d");
/*  5177 */     this.GL_MESA_framebuffer_flip_x = paramSet.contains("GL_MESA_framebuffer_flip_x");
/*  5178 */     this.GL_MESA_framebuffer_flip_y = check_MESA_framebuffer_flip_y(paramFunctionProvider, pointerBuffer, paramSet);
/*  5179 */     this.GL_MESA_framebuffer_swap_xy = paramSet.contains("GL_MESA_framebuffer_swap_xy");
/*  5180 */     this.GL_MESA_tile_raster_order = paramSet.contains("GL_MESA_tile_raster_order");
/*  5181 */     this.GL_NV_alpha_to_coverage_dither_control = check_NV_alpha_to_coverage_dither_control(paramFunctionProvider, pointerBuffer, paramSet);
/*  5182 */     this.GL_NV_bindless_multi_draw_indirect = check_NV_bindless_multi_draw_indirect(paramFunctionProvider, pointerBuffer, paramSet);
/*  5183 */     this.GL_NV_bindless_multi_draw_indirect_count = check_NV_bindless_multi_draw_indirect_count(paramFunctionProvider, pointerBuffer, paramSet);
/*  5184 */     this.GL_NV_bindless_texture = check_NV_bindless_texture(paramFunctionProvider, pointerBuffer, paramSet);
/*  5185 */     this.GL_NV_blend_equation_advanced = check_NV_blend_equation_advanced(paramFunctionProvider, pointerBuffer, paramSet);
/*  5186 */     this.GL_NV_blend_equation_advanced_coherent = paramSet.contains("GL_NV_blend_equation_advanced_coherent");
/*  5187 */     this.GL_NV_blend_minmax_factor = paramSet.contains("GL_NV_blend_minmax_factor");
/*  5188 */     this.GL_NV_blend_square = paramSet.contains("GL_NV_blend_square");
/*  5189 */     this.GL_NV_clip_space_w_scaling = check_NV_clip_space_w_scaling(paramFunctionProvider, pointerBuffer, paramSet);
/*  5190 */     this.GL_NV_command_list = check_NV_command_list(paramFunctionProvider, pointerBuffer, paramSet);
/*  5191 */     this.GL_NV_compute_shader_derivatives = paramSet.contains("GL_NV_compute_shader_derivatives");
/*  5192 */     this.GL_NV_conditional_render = check_NV_conditional_render(paramFunctionProvider, pointerBuffer, paramSet);
/*  5193 */     this.GL_NV_conservative_raster = check_NV_conservative_raster(paramFunctionProvider, pointerBuffer, paramSet);
/*  5194 */     this.GL_NV_conservative_raster_dilate = check_NV_conservative_raster_dilate(paramFunctionProvider, pointerBuffer, paramSet);
/*  5195 */     this.GL_NV_conservative_raster_pre_snap = paramSet.contains("GL_NV_conservative_raster_pre_snap");
/*  5196 */     this.GL_NV_conservative_raster_pre_snap_triangles = check_NV_conservative_raster_pre_snap_triangles(paramFunctionProvider, pointerBuffer, paramSet);
/*  5197 */     this.GL_NV_conservative_raster_underestimation = paramSet.contains("GL_NV_conservative_raster_underestimation");
/*  5198 */     this.GL_NV_copy_depth_to_color = paramSet.contains("GL_NV_copy_depth_to_color");
/*  5199 */     this.GL_NV_copy_image = check_NV_copy_image(paramFunctionProvider, pointerBuffer, paramSet);
/*  5200 */     this.GL_NV_deep_texture3D = paramSet.contains("GL_NV_deep_texture3D");
/*  5201 */     this.GL_NV_depth_buffer_float = check_NV_depth_buffer_float(paramFunctionProvider, pointerBuffer, paramSet);
/*  5202 */     this.GL_NV_depth_clamp = paramSet.contains("GL_NV_depth_clamp");
/*  5203 */     this.GL_NV_draw_texture = check_NV_draw_texture(paramFunctionProvider, pointerBuffer, paramSet);
/*  5204 */     this.GL_NV_draw_vulkan_image = check_NV_draw_vulkan_image(paramFunctionProvider, pointerBuffer, paramSet);
/*  5205 */     this.GL_NV_ES3_1_compatibility = paramSet.contains("GL_NV_ES3_1_compatibility");
/*  5206 */     this.GL_NV_explicit_multisample = check_NV_explicit_multisample(paramFunctionProvider, pointerBuffer, paramSet);
/*  5207 */     this.GL_NV_fence = check_NV_fence(paramFunctionProvider, pointerBuffer, paramSet);
/*  5208 */     this.GL_NV_fill_rectangle = paramSet.contains("GL_NV_fill_rectangle");
/*  5209 */     this.GL_NV_float_buffer = paramSet.contains("GL_NV_float_buffer");
/*  5210 */     this.GL_NV_fog_distance = paramSet.contains("GL_NV_fog_distance");
/*  5211 */     this.GL_NV_fragment_coverage_to_color = check_NV_fragment_coverage_to_color(paramFunctionProvider, pointerBuffer, paramSet);
/*  5212 */     this.GL_NV_fragment_program4 = paramSet.contains("GL_NV_fragment_program4");
/*  5213 */     this.GL_NV_fragment_program_option = paramSet.contains("GL_NV_fragment_program_option");
/*  5214 */     this.GL_NV_fragment_shader_barycentric = paramSet.contains("GL_NV_fragment_shader_barycentric");
/*  5215 */     this.GL_NV_fragment_shader_interlock = paramSet.contains("GL_NV_fragment_shader_interlock");
/*  5216 */     this.GL_NV_framebuffer_mixed_samples = check_NV_framebuffer_mixed_samples(paramFunctionProvider, pointerBuffer, paramSet);
/*  5217 */     this.GL_NV_framebuffer_multisample_coverage = check_NV_framebuffer_multisample_coverage(paramFunctionProvider, pointerBuffer, paramSet);
/*  5218 */     this.GL_NV_geometry_shader4 = paramSet.contains("GL_NV_geometry_shader4");
/*  5219 */     this.GL_NV_geometry_shader_passthrough = paramSet.contains("GL_NV_geometry_shader_passthrough");
/*  5220 */     this.GL_NV_gpu_multicast = check_NV_gpu_multicast(paramFunctionProvider, pointerBuffer, paramSet);
/*  5221 */     this.GL_NV_gpu_shader5 = check_NV_gpu_shader5(paramFunctionProvider, pointerBuffer, paramSet);
/*  5222 */     this.GL_NV_half_float = check_NV_half_float(paramFunctionProvider, pointerBuffer, paramSet);
/*  5223 */     this.GL_NV_internalformat_sample_query = check_NV_internalformat_sample_query(paramFunctionProvider, pointerBuffer, paramSet);
/*  5224 */     this.GL_NV_light_max_exponent = paramSet.contains("GL_NV_light_max_exponent");
/*  5225 */     this.GL_NV_memory_attachment = check_NV_memory_attachment(paramFunctionProvider, pointerBuffer, paramSet);
/*  5226 */     this.GL_NV_memory_object_sparse = check_NV_memory_object_sparse(paramFunctionProvider, pointerBuffer, paramSet);
/*  5227 */     this.GL_NV_mesh_shader = check_NV_mesh_shader(paramFunctionProvider, pointerBuffer, paramSet);
/*  5228 */     this.GL_NV_multisample_coverage = paramSet.contains("GL_NV_multisample_coverage");
/*  5229 */     this.GL_NV_multisample_filter_hint = paramSet.contains("GL_NV_multisample_filter_hint");
/*  5230 */     this.GL_NV_packed_depth_stencil = paramSet.contains("GL_NV_packed_depth_stencil");
/*  5231 */     this.GL_NV_path_rendering = check_NV_path_rendering(paramFunctionProvider, pointerBuffer, paramSet);
/*  5232 */     this.GL_NV_path_rendering_shared_edge = paramSet.contains("GL_NV_path_rendering_shared_edge");
/*  5233 */     this.GL_NV_pixel_data_range = check_NV_pixel_data_range(paramFunctionProvider, pointerBuffer, paramSet);
/*  5234 */     this.GL_NV_point_sprite = check_NV_point_sprite(paramFunctionProvider, pointerBuffer, paramSet);
/*  5235 */     this.GL_NV_primitive_restart = check_NV_primitive_restart(paramFunctionProvider, pointerBuffer, paramSet);
/*  5236 */     this.GL_NV_primitive_shading_rate = paramSet.contains("GL_NV_primitive_shading_rate");
/*  5237 */     this.GL_NV_query_resource = check_NV_query_resource(paramFunctionProvider, pointerBuffer, paramSet);
/*  5238 */     this.GL_NV_query_resource_tag = check_NV_query_resource_tag(paramFunctionProvider, pointerBuffer, paramSet);
/*  5239 */     this.GL_NV_representative_fragment_test = paramSet.contains("GL_NV_representative_fragment_test");
/*  5240 */     this.GL_NV_robustness_video_memory_purge = paramSet.contains("GL_NV_robustness_video_memory_purge");
/*  5241 */     this.GL_NV_sample_locations = check_NV_sample_locations(paramFunctionProvider, pointerBuffer, paramSet);
/*  5242 */     this.GL_NV_sample_mask_override_coverage = paramSet.contains("GL_NV_sample_mask_override_coverage");
/*  5243 */     this.GL_NV_scissor_exclusive = check_NV_scissor_exclusive(paramFunctionProvider, pointerBuffer, paramSet);
/*  5244 */     this.GL_NV_shader_atomic_float = paramSet.contains("GL_NV_shader_atomic_float");
/*  5245 */     this.GL_NV_shader_atomic_float64 = paramSet.contains("GL_NV_shader_atomic_float64");
/*  5246 */     this.GL_NV_shader_atomic_fp16_vector = paramSet.contains("GL_NV_shader_atomic_fp16_vector");
/*  5247 */     this.GL_NV_shader_atomic_int64 = paramSet.contains("GL_NV_shader_atomic_int64");
/*  5248 */     this.GL_NV_shader_buffer_load = check_NV_shader_buffer_load(paramFunctionProvider, pointerBuffer, paramSet);
/*  5249 */     this.GL_NV_shader_buffer_store = paramSet.contains("GL_NV_shader_buffer_store");
/*  5250 */     this.GL_NV_shader_subgroup_partitioned = paramSet.contains("GL_NV_shader_subgroup_partitioned");
/*  5251 */     this.GL_NV_shader_texture_footprint = paramSet.contains("GL_NV_shader_texture_footprint");
/*  5252 */     this.GL_NV_shader_thread_group = paramSet.contains("GL_NV_shader_thread_group");
/*  5253 */     this.GL_NV_shader_thread_shuffle = paramSet.contains("GL_NV_shader_thread_shuffle");
/*  5254 */     this.GL_NV_shading_rate_image = check_NV_shading_rate_image(paramFunctionProvider, pointerBuffer, paramSet);
/*  5255 */     this.GL_NV_stereo_view_rendering = paramSet.contains("GL_NV_stereo_view_rendering");
/*  5256 */     this.GL_NV_texgen_reflection = paramSet.contains("GL_NV_texgen_reflection");
/*  5257 */     this.GL_NV_texture_barrier = check_NV_texture_barrier(paramFunctionProvider, pointerBuffer, paramSet);
/*  5258 */     this.GL_NV_texture_compression_vtc = paramSet.contains("GL_NV_texture_compression_vtc");
/*  5259 */     this.GL_NV_texture_multisample = check_NV_texture_multisample(paramFunctionProvider, pointerBuffer, paramSet);
/*  5260 */     this.GL_NV_texture_rectangle_compressed = paramSet.contains("GL_NV_texture_rectangle_compressed");
/*  5261 */     this.GL_NV_texture_shader = paramSet.contains("GL_NV_texture_shader");
/*  5262 */     this.GL_NV_texture_shader2 = paramSet.contains("GL_NV_texture_shader2");
/*  5263 */     this.GL_NV_texture_shader3 = paramSet.contains("GL_NV_texture_shader3");
/*  5264 */     this.GL_NV_timeline_semaphore = check_NV_timeline_semaphore(paramFunctionProvider, pointerBuffer, paramSet);
/*  5265 */     this.GL_NV_transform_feedback = check_NV_transform_feedback(paramFunctionProvider, pointerBuffer, paramSet);
/*  5266 */     this.GL_NV_transform_feedback2 = check_NV_transform_feedback2(paramFunctionProvider, pointerBuffer, paramSet);
/*  5267 */     this.GL_NV_uniform_buffer_std430_layout = paramSet.contains("GL_NV_uniform_buffer_std430_layout");
/*  5268 */     this.GL_NV_uniform_buffer_unified_memory = paramSet.contains("GL_NV_uniform_buffer_unified_memory");
/*  5269 */     this.GL_NV_vertex_array_range = check_NV_vertex_array_range(paramFunctionProvider, pointerBuffer, paramSet);
/*  5270 */     this.GL_NV_vertex_array_range2 = paramSet.contains("GL_NV_vertex_array_range2");
/*  5271 */     this.GL_NV_vertex_attrib_integer_64bit = check_NV_vertex_attrib_integer_64bit(paramFunctionProvider, pointerBuffer, paramSet);
/*  5272 */     this.GL_NV_vertex_buffer_unified_memory = check_NV_vertex_buffer_unified_memory(paramFunctionProvider, pointerBuffer, paramSet);
/*  5273 */     this.GL_NV_viewport_array2 = paramSet.contains("GL_NV_viewport_array2");
/*  5274 */     this.GL_NV_viewport_swizzle = check_NV_viewport_swizzle(paramFunctionProvider, pointerBuffer, paramSet);
/*  5275 */     this.GL_NVX_blend_equation_advanced_multi_draw_buffers = paramSet.contains("GL_NVX_blend_equation_advanced_multi_draw_buffers");
/*  5276 */     this.GL_NVX_conditional_render = check_NVX_conditional_render(paramFunctionProvider, pointerBuffer, paramSet);
/*  5277 */     this.GL_NVX_gpu_memory_info = paramSet.contains("GL_NVX_gpu_memory_info");
/*  5278 */     this.GL_NVX_gpu_multicast2 = check_NVX_gpu_multicast2(paramFunctionProvider, pointerBuffer, paramSet);
/*  5279 */     this.GL_NVX_progress_fence = check_NVX_progress_fence(paramFunctionProvider, pointerBuffer, paramSet);
/*  5280 */     this.GL_OVR_multiview = check_OVR_multiview(paramFunctionProvider, pointerBuffer, paramSet);
/*  5281 */     this.GL_OVR_multiview2 = paramSet.contains("GL_OVR_multiview2");
/*  5282 */     this.GL_S3_s3tc = paramSet.contains("GL_S3_s3tc");
/*       */     
/*  5284 */     this.glEnable = pointerBuffer.get(0);
/*  5285 */     this.glDisable = pointerBuffer.get(1);
/*  5286 */     this.glAccum = pointerBuffer.get(2);
/*  5287 */     this.glAlphaFunc = pointerBuffer.get(3);
/*  5288 */     this.glAreTexturesResident = pointerBuffer.get(4);
/*  5289 */     this.glArrayElement = pointerBuffer.get(5);
/*  5290 */     this.glBegin = pointerBuffer.get(6);
/*  5291 */     this.glBindTexture = pointerBuffer.get(7);
/*  5292 */     this.glBitmap = pointerBuffer.get(8);
/*  5293 */     this.glBlendFunc = pointerBuffer.get(9);
/*  5294 */     this.glCallList = pointerBuffer.get(10);
/*  5295 */     this.glCallLists = pointerBuffer.get(11);
/*  5296 */     this.glClear = pointerBuffer.get(12);
/*  5297 */     this.glClearAccum = pointerBuffer.get(13);
/*  5298 */     this.glClearColor = pointerBuffer.get(14);
/*  5299 */     this.glClearDepth = pointerBuffer.get(15);
/*  5300 */     this.glClearIndex = pointerBuffer.get(16);
/*  5301 */     this.glClearStencil = pointerBuffer.get(17);
/*  5302 */     this.glClipPlane = pointerBuffer.get(18);
/*  5303 */     this.glColor3b = pointerBuffer.get(19);
/*  5304 */     this.glColor3s = pointerBuffer.get(20);
/*  5305 */     this.glColor3i = pointerBuffer.get(21);
/*  5306 */     this.glColor3f = pointerBuffer.get(22);
/*  5307 */     this.glColor3d = pointerBuffer.get(23);
/*  5308 */     this.glColor3ub = pointerBuffer.get(24);
/*  5309 */     this.glColor3us = pointerBuffer.get(25);
/*  5310 */     this.glColor3ui = pointerBuffer.get(26);
/*  5311 */     this.glColor3bv = pointerBuffer.get(27);
/*  5312 */     this.glColor3sv = pointerBuffer.get(28);
/*  5313 */     this.glColor3iv = pointerBuffer.get(29);
/*  5314 */     this.glColor3fv = pointerBuffer.get(30);
/*  5315 */     this.glColor3dv = pointerBuffer.get(31);
/*  5316 */     this.glColor3ubv = pointerBuffer.get(32);
/*  5317 */     this.glColor3usv = pointerBuffer.get(33);
/*  5318 */     this.glColor3uiv = pointerBuffer.get(34);
/*  5319 */     this.glColor4b = pointerBuffer.get(35);
/*  5320 */     this.glColor4s = pointerBuffer.get(36);
/*  5321 */     this.glColor4i = pointerBuffer.get(37);
/*  5322 */     this.glColor4f = pointerBuffer.get(38);
/*  5323 */     this.glColor4d = pointerBuffer.get(39);
/*  5324 */     this.glColor4ub = pointerBuffer.get(40);
/*  5325 */     this.glColor4us = pointerBuffer.get(41);
/*  5326 */     this.glColor4ui = pointerBuffer.get(42);
/*  5327 */     this.glColor4bv = pointerBuffer.get(43);
/*  5328 */     this.glColor4sv = pointerBuffer.get(44);
/*  5329 */     this.glColor4iv = pointerBuffer.get(45);
/*  5330 */     this.glColor4fv = pointerBuffer.get(46);
/*  5331 */     this.glColor4dv = pointerBuffer.get(47);
/*  5332 */     this.glColor4ubv = pointerBuffer.get(48);
/*  5333 */     this.glColor4usv = pointerBuffer.get(49);
/*  5334 */     this.glColor4uiv = pointerBuffer.get(50);
/*  5335 */     this.glColorMask = pointerBuffer.get(51);
/*  5336 */     this.glColorMaterial = pointerBuffer.get(52);
/*  5337 */     this.glColorPointer = pointerBuffer.get(53);
/*  5338 */     this.glCopyPixels = pointerBuffer.get(54);
/*  5339 */     this.glCullFace = pointerBuffer.get(55);
/*  5340 */     this.glDeleteLists = pointerBuffer.get(56);
/*  5341 */     this.glDepthFunc = pointerBuffer.get(57);
/*  5342 */     this.glDepthMask = pointerBuffer.get(58);
/*  5343 */     this.glDepthRange = pointerBuffer.get(59);
/*  5344 */     this.glDisableClientState = pointerBuffer.get(60);
/*  5345 */     this.glDrawArrays = pointerBuffer.get(61);
/*  5346 */     this.glDrawBuffer = pointerBuffer.get(62);
/*  5347 */     this.glDrawElements = pointerBuffer.get(63);
/*  5348 */     this.glDrawPixels = pointerBuffer.get(64);
/*  5349 */     this.glEdgeFlag = pointerBuffer.get(65);
/*  5350 */     this.glEdgeFlagv = pointerBuffer.get(66);
/*  5351 */     this.glEdgeFlagPointer = pointerBuffer.get(67);
/*  5352 */     this.glEnableClientState = pointerBuffer.get(68);
/*  5353 */     this.glEnd = pointerBuffer.get(69);
/*  5354 */     this.glEvalCoord1f = pointerBuffer.get(70);
/*  5355 */     this.glEvalCoord1fv = pointerBuffer.get(71);
/*  5356 */     this.glEvalCoord1d = pointerBuffer.get(72);
/*  5357 */     this.glEvalCoord1dv = pointerBuffer.get(73);
/*  5358 */     this.glEvalCoord2f = pointerBuffer.get(74);
/*  5359 */     this.glEvalCoord2fv = pointerBuffer.get(75);
/*  5360 */     this.glEvalCoord2d = pointerBuffer.get(76);
/*  5361 */     this.glEvalCoord2dv = pointerBuffer.get(77);
/*  5362 */     this.glEvalMesh1 = pointerBuffer.get(78);
/*  5363 */     this.glEvalMesh2 = pointerBuffer.get(79);
/*  5364 */     this.glEvalPoint1 = pointerBuffer.get(80);
/*  5365 */     this.glEvalPoint2 = pointerBuffer.get(81);
/*  5366 */     this.glFeedbackBuffer = pointerBuffer.get(82);
/*  5367 */     this.glFinish = pointerBuffer.get(83);
/*  5368 */     this.glFlush = pointerBuffer.get(84);
/*  5369 */     this.glFogi = pointerBuffer.get(85);
/*  5370 */     this.glFogiv = pointerBuffer.get(86);
/*  5371 */     this.glFogf = pointerBuffer.get(87);
/*  5372 */     this.glFogfv = pointerBuffer.get(88);
/*  5373 */     this.glFrontFace = pointerBuffer.get(89);
/*  5374 */     this.glGenLists = pointerBuffer.get(90);
/*  5375 */     this.glGenTextures = pointerBuffer.get(91);
/*  5376 */     this.glDeleteTextures = pointerBuffer.get(92);
/*  5377 */     this.glGetClipPlane = pointerBuffer.get(93);
/*  5378 */     this.glGetBooleanv = pointerBuffer.get(94);
/*  5379 */     this.glGetFloatv = pointerBuffer.get(95);
/*  5380 */     this.glGetIntegerv = pointerBuffer.get(96);
/*  5381 */     this.glGetDoublev = pointerBuffer.get(97);
/*  5382 */     this.glGetError = pointerBuffer.get(98);
/*  5383 */     this.glGetLightiv = pointerBuffer.get(99);
/*  5384 */     this.glGetLightfv = pointerBuffer.get(100);
/*  5385 */     this.glGetMapiv = pointerBuffer.get(101);
/*  5386 */     this.glGetMapfv = pointerBuffer.get(102);
/*  5387 */     this.glGetMapdv = pointerBuffer.get(103);
/*  5388 */     this.glGetMaterialiv = pointerBuffer.get(104);
/*  5389 */     this.glGetMaterialfv = pointerBuffer.get(105);
/*  5390 */     this.glGetPixelMapfv = pointerBuffer.get(106);
/*  5391 */     this.glGetPixelMapusv = pointerBuffer.get(107);
/*  5392 */     this.glGetPixelMapuiv = pointerBuffer.get(108);
/*  5393 */     this.glGetPointerv = pointerBuffer.get(109);
/*  5394 */     this.glGetPolygonStipple = pointerBuffer.get(110);
/*  5395 */     this.glGetString = pointerBuffer.get(111);
/*  5396 */     this.glGetTexEnviv = pointerBuffer.get(112);
/*  5397 */     this.glGetTexEnvfv = pointerBuffer.get(113);
/*  5398 */     this.glGetTexGeniv = pointerBuffer.get(114);
/*  5399 */     this.glGetTexGenfv = pointerBuffer.get(115);
/*  5400 */     this.glGetTexGendv = pointerBuffer.get(116);
/*  5401 */     this.glGetTexImage = pointerBuffer.get(117);
/*  5402 */     this.glGetTexLevelParameteriv = pointerBuffer.get(118);
/*  5403 */     this.glGetTexLevelParameterfv = pointerBuffer.get(119);
/*  5404 */     this.glGetTexParameteriv = pointerBuffer.get(120);
/*  5405 */     this.glGetTexParameterfv = pointerBuffer.get(121);
/*  5406 */     this.glHint = pointerBuffer.get(122);
/*  5407 */     this.glIndexi = pointerBuffer.get(123);
/*  5408 */     this.glIndexub = pointerBuffer.get(124);
/*  5409 */     this.glIndexs = pointerBuffer.get(125);
/*  5410 */     this.glIndexf = pointerBuffer.get(126);
/*  5411 */     this.glIndexd = pointerBuffer.get(127);
/*  5412 */     this.glIndexiv = pointerBuffer.get(128);
/*  5413 */     this.glIndexubv = pointerBuffer.get(129);
/*  5414 */     this.glIndexsv = pointerBuffer.get(130);
/*  5415 */     this.glIndexfv = pointerBuffer.get(131);
/*  5416 */     this.glIndexdv = pointerBuffer.get(132);
/*  5417 */     this.glIndexMask = pointerBuffer.get(133);
/*  5418 */     this.glIndexPointer = pointerBuffer.get(134);
/*  5419 */     this.glInitNames = pointerBuffer.get(135);
/*  5420 */     this.glInterleavedArrays = pointerBuffer.get(136);
/*  5421 */     this.glIsEnabled = pointerBuffer.get(137);
/*  5422 */     this.glIsList = pointerBuffer.get(138);
/*  5423 */     this.glIsTexture = pointerBuffer.get(139);
/*  5424 */     this.glLightModeli = pointerBuffer.get(140);
/*  5425 */     this.glLightModelf = pointerBuffer.get(141);
/*  5426 */     this.glLightModeliv = pointerBuffer.get(142);
/*  5427 */     this.glLightModelfv = pointerBuffer.get(143);
/*  5428 */     this.glLighti = pointerBuffer.get(144);
/*  5429 */     this.glLightf = pointerBuffer.get(145);
/*  5430 */     this.glLightiv = pointerBuffer.get(146);
/*  5431 */     this.glLightfv = pointerBuffer.get(147);
/*  5432 */     this.glLineStipple = pointerBuffer.get(148);
/*  5433 */     this.glLineWidth = pointerBuffer.get(149);
/*  5434 */     this.glListBase = pointerBuffer.get(150);
/*  5435 */     this.glLoadMatrixf = pointerBuffer.get(151);
/*  5436 */     this.glLoadMatrixd = pointerBuffer.get(152);
/*  5437 */     this.glLoadIdentity = pointerBuffer.get(153);
/*  5438 */     this.glLoadName = pointerBuffer.get(154);
/*  5439 */     this.glLogicOp = pointerBuffer.get(155);
/*  5440 */     this.glMap1f = pointerBuffer.get(156);
/*  5441 */     this.glMap1d = pointerBuffer.get(157);
/*  5442 */     this.glMap2f = pointerBuffer.get(158);
/*  5443 */     this.glMap2d = pointerBuffer.get(159);
/*  5444 */     this.glMapGrid1f = pointerBuffer.get(160);
/*  5445 */     this.glMapGrid1d = pointerBuffer.get(161);
/*  5446 */     this.glMapGrid2f = pointerBuffer.get(162);
/*  5447 */     this.glMapGrid2d = pointerBuffer.get(163);
/*  5448 */     this.glMateriali = pointerBuffer.get(164);
/*  5449 */     this.glMaterialf = pointerBuffer.get(165);
/*  5450 */     this.glMaterialiv = pointerBuffer.get(166);
/*  5451 */     this.glMaterialfv = pointerBuffer.get(167);
/*  5452 */     this.glMatrixMode = pointerBuffer.get(168);
/*  5453 */     this.glMultMatrixf = pointerBuffer.get(169);
/*  5454 */     this.glMultMatrixd = pointerBuffer.get(170);
/*  5455 */     this.glFrustum = pointerBuffer.get(171);
/*  5456 */     this.glNewList = pointerBuffer.get(172);
/*  5457 */     this.glEndList = pointerBuffer.get(173);
/*  5458 */     this.glNormal3f = pointerBuffer.get(174);
/*  5459 */     this.glNormal3b = pointerBuffer.get(175);
/*  5460 */     this.glNormal3s = pointerBuffer.get(176);
/*  5461 */     this.glNormal3i = pointerBuffer.get(177);
/*  5462 */     this.glNormal3d = pointerBuffer.get(178);
/*  5463 */     this.glNormal3fv = pointerBuffer.get(179);
/*  5464 */     this.glNormal3bv = pointerBuffer.get(180);
/*  5465 */     this.glNormal3sv = pointerBuffer.get(181);
/*  5466 */     this.glNormal3iv = pointerBuffer.get(182);
/*  5467 */     this.glNormal3dv = pointerBuffer.get(183);
/*  5468 */     this.glNormalPointer = pointerBuffer.get(184);
/*  5469 */     this.glOrtho = pointerBuffer.get(185);
/*  5470 */     this.glPassThrough = pointerBuffer.get(186);
/*  5471 */     this.glPixelMapfv = pointerBuffer.get(187);
/*  5472 */     this.glPixelMapusv = pointerBuffer.get(188);
/*  5473 */     this.glPixelMapuiv = pointerBuffer.get(189);
/*  5474 */     this.glPixelStorei = pointerBuffer.get(190);
/*  5475 */     this.glPixelStoref = pointerBuffer.get(191);
/*  5476 */     this.glPixelTransferi = pointerBuffer.get(192);
/*  5477 */     this.glPixelTransferf = pointerBuffer.get(193);
/*  5478 */     this.glPixelZoom = pointerBuffer.get(194);
/*  5479 */     this.glPointSize = pointerBuffer.get(195);
/*  5480 */     this.glPolygonMode = pointerBuffer.get(196);
/*  5481 */     this.glPolygonOffset = pointerBuffer.get(197);
/*  5482 */     this.glPolygonStipple = pointerBuffer.get(198);
/*  5483 */     this.glPushAttrib = pointerBuffer.get(199);
/*  5484 */     this.glPushClientAttrib = pointerBuffer.get(200);
/*  5485 */     this.glPopAttrib = pointerBuffer.get(201);
/*  5486 */     this.glPopClientAttrib = pointerBuffer.get(202);
/*  5487 */     this.glPopMatrix = pointerBuffer.get(203);
/*  5488 */     this.glPopName = pointerBuffer.get(204);
/*  5489 */     this.glPrioritizeTextures = pointerBuffer.get(205);
/*  5490 */     this.glPushMatrix = pointerBuffer.get(206);
/*  5491 */     this.glPushName = pointerBuffer.get(207);
/*  5492 */     this.glRasterPos2i = pointerBuffer.get(208);
/*  5493 */     this.glRasterPos2s = pointerBuffer.get(209);
/*  5494 */     this.glRasterPos2f = pointerBuffer.get(210);
/*  5495 */     this.glRasterPos2d = pointerBuffer.get(211);
/*  5496 */     this.glRasterPos2iv = pointerBuffer.get(212);
/*  5497 */     this.glRasterPos2sv = pointerBuffer.get(213);
/*  5498 */     this.glRasterPos2fv = pointerBuffer.get(214);
/*  5499 */     this.glRasterPos2dv = pointerBuffer.get(215);
/*  5500 */     this.glRasterPos3i = pointerBuffer.get(216);
/*  5501 */     this.glRasterPos3s = pointerBuffer.get(217);
/*  5502 */     this.glRasterPos3f = pointerBuffer.get(218);
/*  5503 */     this.glRasterPos3d = pointerBuffer.get(219);
/*  5504 */     this.glRasterPos3iv = pointerBuffer.get(220);
/*  5505 */     this.glRasterPos3sv = pointerBuffer.get(221);
/*  5506 */     this.glRasterPos3fv = pointerBuffer.get(222);
/*  5507 */     this.glRasterPos3dv = pointerBuffer.get(223);
/*  5508 */     this.glRasterPos4i = pointerBuffer.get(224);
/*  5509 */     this.glRasterPos4s = pointerBuffer.get(225);
/*  5510 */     this.glRasterPos4f = pointerBuffer.get(226);
/*  5511 */     this.glRasterPos4d = pointerBuffer.get(227);
/*  5512 */     this.glRasterPos4iv = pointerBuffer.get(228);
/*  5513 */     this.glRasterPos4sv = pointerBuffer.get(229);
/*  5514 */     this.glRasterPos4fv = pointerBuffer.get(230);
/*  5515 */     this.glRasterPos4dv = pointerBuffer.get(231);
/*  5516 */     this.glReadBuffer = pointerBuffer.get(232);
/*  5517 */     this.glReadPixels = pointerBuffer.get(233);
/*  5518 */     this.glRecti = pointerBuffer.get(234);
/*  5519 */     this.glRects = pointerBuffer.get(235);
/*  5520 */     this.glRectf = pointerBuffer.get(236);
/*  5521 */     this.glRectd = pointerBuffer.get(237);
/*  5522 */     this.glRectiv = pointerBuffer.get(238);
/*  5523 */     this.glRectsv = pointerBuffer.get(239);
/*  5524 */     this.glRectfv = pointerBuffer.get(240);
/*  5525 */     this.glRectdv = pointerBuffer.get(241);
/*  5526 */     this.glRenderMode = pointerBuffer.get(242);
/*  5527 */     this.glRotatef = pointerBuffer.get(243);
/*  5528 */     this.glRotated = pointerBuffer.get(244);
/*  5529 */     this.glScalef = pointerBuffer.get(245);
/*  5530 */     this.glScaled = pointerBuffer.get(246);
/*  5531 */     this.glScissor = pointerBuffer.get(247);
/*  5532 */     this.glSelectBuffer = pointerBuffer.get(248);
/*  5533 */     this.glShadeModel = pointerBuffer.get(249);
/*  5534 */     this.glStencilFunc = pointerBuffer.get(250);
/*  5535 */     this.glStencilMask = pointerBuffer.get(251);
/*  5536 */     this.glStencilOp = pointerBuffer.get(252);
/*  5537 */     this.glTexCoord1f = pointerBuffer.get(253);
/*  5538 */     this.glTexCoord1s = pointerBuffer.get(254);
/*  5539 */     this.glTexCoord1i = pointerBuffer.get(255);
/*  5540 */     this.glTexCoord1d = pointerBuffer.get(256);
/*  5541 */     this.glTexCoord1fv = pointerBuffer.get(257);
/*  5542 */     this.glTexCoord1sv = pointerBuffer.get(258);
/*  5543 */     this.glTexCoord1iv = pointerBuffer.get(259);
/*  5544 */     this.glTexCoord1dv = pointerBuffer.get(260);
/*  5545 */     this.glTexCoord2f = pointerBuffer.get(261);
/*  5546 */     this.glTexCoord2s = pointerBuffer.get(262);
/*  5547 */     this.glTexCoord2i = pointerBuffer.get(263);
/*  5548 */     this.glTexCoord2d = pointerBuffer.get(264);
/*  5549 */     this.glTexCoord2fv = pointerBuffer.get(265);
/*  5550 */     this.glTexCoord2sv = pointerBuffer.get(266);
/*  5551 */     this.glTexCoord2iv = pointerBuffer.get(267);
/*  5552 */     this.glTexCoord2dv = pointerBuffer.get(268);
/*  5553 */     this.glTexCoord3f = pointerBuffer.get(269);
/*  5554 */     this.glTexCoord3s = pointerBuffer.get(270);
/*  5555 */     this.glTexCoord3i = pointerBuffer.get(271);
/*  5556 */     this.glTexCoord3d = pointerBuffer.get(272);
/*  5557 */     this.glTexCoord3fv = pointerBuffer.get(273);
/*  5558 */     this.glTexCoord3sv = pointerBuffer.get(274);
/*  5559 */     this.glTexCoord3iv = pointerBuffer.get(275);
/*  5560 */     this.glTexCoord3dv = pointerBuffer.get(276);
/*  5561 */     this.glTexCoord4f = pointerBuffer.get(277);
/*  5562 */     this.glTexCoord4s = pointerBuffer.get(278);
/*  5563 */     this.glTexCoord4i = pointerBuffer.get(279);
/*  5564 */     this.glTexCoord4d = pointerBuffer.get(280);
/*  5565 */     this.glTexCoord4fv = pointerBuffer.get(281);
/*  5566 */     this.glTexCoord4sv = pointerBuffer.get(282);
/*  5567 */     this.glTexCoord4iv = pointerBuffer.get(283);
/*  5568 */     this.glTexCoord4dv = pointerBuffer.get(284);
/*  5569 */     this.glTexCoordPointer = pointerBuffer.get(285);
/*  5570 */     this.glTexEnvi = pointerBuffer.get(286);
/*  5571 */     this.glTexEnviv = pointerBuffer.get(287);
/*  5572 */     this.glTexEnvf = pointerBuffer.get(288);
/*  5573 */     this.glTexEnvfv = pointerBuffer.get(289);
/*  5574 */     this.glTexGeni = pointerBuffer.get(290);
/*  5575 */     this.glTexGeniv = pointerBuffer.get(291);
/*  5576 */     this.glTexGenf = pointerBuffer.get(292);
/*  5577 */     this.glTexGenfv = pointerBuffer.get(293);
/*  5578 */     this.glTexGend = pointerBuffer.get(294);
/*  5579 */     this.glTexGendv = pointerBuffer.get(295);
/*  5580 */     this.glTexImage1D = pointerBuffer.get(296);
/*  5581 */     this.glTexImage2D = pointerBuffer.get(297);
/*  5582 */     this.glCopyTexImage1D = pointerBuffer.get(298);
/*  5583 */     this.glCopyTexImage2D = pointerBuffer.get(299);
/*  5584 */     this.glCopyTexSubImage1D = pointerBuffer.get(300);
/*  5585 */     this.glCopyTexSubImage2D = pointerBuffer.get(301);
/*  5586 */     this.glTexParameteri = pointerBuffer.get(302);
/*  5587 */     this.glTexParameteriv = pointerBuffer.get(303);
/*  5588 */     this.glTexParameterf = pointerBuffer.get(304);
/*  5589 */     this.glTexParameterfv = pointerBuffer.get(305);
/*  5590 */     this.glTexSubImage1D = pointerBuffer.get(306);
/*  5591 */     this.glTexSubImage2D = pointerBuffer.get(307);
/*  5592 */     this.glTranslatef = pointerBuffer.get(308);
/*  5593 */     this.glTranslated = pointerBuffer.get(309);
/*  5594 */     this.glVertex2f = pointerBuffer.get(310);
/*  5595 */     this.glVertex2s = pointerBuffer.get(311);
/*  5596 */     this.glVertex2i = pointerBuffer.get(312);
/*  5597 */     this.glVertex2d = pointerBuffer.get(313);
/*  5598 */     this.glVertex2fv = pointerBuffer.get(314);
/*  5599 */     this.glVertex2sv = pointerBuffer.get(315);
/*  5600 */     this.glVertex2iv = pointerBuffer.get(316);
/*  5601 */     this.glVertex2dv = pointerBuffer.get(317);
/*  5602 */     this.glVertex3f = pointerBuffer.get(318);
/*  5603 */     this.glVertex3s = pointerBuffer.get(319);
/*  5604 */     this.glVertex3i = pointerBuffer.get(320);
/*  5605 */     this.glVertex3d = pointerBuffer.get(321);
/*  5606 */     this.glVertex3fv = pointerBuffer.get(322);
/*  5607 */     this.glVertex3sv = pointerBuffer.get(323);
/*  5608 */     this.glVertex3iv = pointerBuffer.get(324);
/*  5609 */     this.glVertex3dv = pointerBuffer.get(325);
/*  5610 */     this.glVertex4f = pointerBuffer.get(326);
/*  5611 */     this.glVertex4s = pointerBuffer.get(327);
/*  5612 */     this.glVertex4i = pointerBuffer.get(328);
/*  5613 */     this.glVertex4d = pointerBuffer.get(329);
/*  5614 */     this.glVertex4fv = pointerBuffer.get(330);
/*  5615 */     this.glVertex4sv = pointerBuffer.get(331);
/*  5616 */     this.glVertex4iv = pointerBuffer.get(332);
/*  5617 */     this.glVertex4dv = pointerBuffer.get(333);
/*  5618 */     this.glVertexPointer = pointerBuffer.get(334);
/*  5619 */     this.glViewport = pointerBuffer.get(335);
/*  5620 */     this.glTexImage3D = pointerBuffer.get(336);
/*  5621 */     this.glTexSubImage3D = pointerBuffer.get(337);
/*  5622 */     this.glCopyTexSubImage3D = pointerBuffer.get(338);
/*  5623 */     this.glDrawRangeElements = pointerBuffer.get(339);
/*  5624 */     this.glCompressedTexImage3D = pointerBuffer.get(340);
/*  5625 */     this.glCompressedTexImage2D = pointerBuffer.get(341);
/*  5626 */     this.glCompressedTexImage1D = pointerBuffer.get(342);
/*  5627 */     this.glCompressedTexSubImage3D = pointerBuffer.get(343);
/*  5628 */     this.glCompressedTexSubImage2D = pointerBuffer.get(344);
/*  5629 */     this.glCompressedTexSubImage1D = pointerBuffer.get(345);
/*  5630 */     this.glGetCompressedTexImage = pointerBuffer.get(346);
/*  5631 */     this.glSampleCoverage = pointerBuffer.get(347);
/*  5632 */     this.glActiveTexture = pointerBuffer.get(348);
/*  5633 */     this.glClientActiveTexture = pointerBuffer.get(349);
/*  5634 */     this.glMultiTexCoord1f = pointerBuffer.get(350);
/*  5635 */     this.glMultiTexCoord1s = pointerBuffer.get(351);
/*  5636 */     this.glMultiTexCoord1i = pointerBuffer.get(352);
/*  5637 */     this.glMultiTexCoord1d = pointerBuffer.get(353);
/*  5638 */     this.glMultiTexCoord1fv = pointerBuffer.get(354);
/*  5639 */     this.glMultiTexCoord1sv = pointerBuffer.get(355);
/*  5640 */     this.glMultiTexCoord1iv = pointerBuffer.get(356);
/*  5641 */     this.glMultiTexCoord1dv = pointerBuffer.get(357);
/*  5642 */     this.glMultiTexCoord2f = pointerBuffer.get(358);
/*  5643 */     this.glMultiTexCoord2s = pointerBuffer.get(359);
/*  5644 */     this.glMultiTexCoord2i = pointerBuffer.get(360);
/*  5645 */     this.glMultiTexCoord2d = pointerBuffer.get(361);
/*  5646 */     this.glMultiTexCoord2fv = pointerBuffer.get(362);
/*  5647 */     this.glMultiTexCoord2sv = pointerBuffer.get(363);
/*  5648 */     this.glMultiTexCoord2iv = pointerBuffer.get(364);
/*  5649 */     this.glMultiTexCoord2dv = pointerBuffer.get(365);
/*  5650 */     this.glMultiTexCoord3f = pointerBuffer.get(366);
/*  5651 */     this.glMultiTexCoord3s = pointerBuffer.get(367);
/*  5652 */     this.glMultiTexCoord3i = pointerBuffer.get(368);
/*  5653 */     this.glMultiTexCoord3d = pointerBuffer.get(369);
/*  5654 */     this.glMultiTexCoord3fv = pointerBuffer.get(370);
/*  5655 */     this.glMultiTexCoord3sv = pointerBuffer.get(371);
/*  5656 */     this.glMultiTexCoord3iv = pointerBuffer.get(372);
/*  5657 */     this.glMultiTexCoord3dv = pointerBuffer.get(373);
/*  5658 */     this.glMultiTexCoord4f = pointerBuffer.get(374);
/*  5659 */     this.glMultiTexCoord4s = pointerBuffer.get(375);
/*  5660 */     this.glMultiTexCoord4i = pointerBuffer.get(376);
/*  5661 */     this.glMultiTexCoord4d = pointerBuffer.get(377);
/*  5662 */     this.glMultiTexCoord4fv = pointerBuffer.get(378);
/*  5663 */     this.glMultiTexCoord4sv = pointerBuffer.get(379);
/*  5664 */     this.glMultiTexCoord4iv = pointerBuffer.get(380);
/*  5665 */     this.glMultiTexCoord4dv = pointerBuffer.get(381);
/*  5666 */     this.glLoadTransposeMatrixf = pointerBuffer.get(382);
/*  5667 */     this.glLoadTransposeMatrixd = pointerBuffer.get(383);
/*  5668 */     this.glMultTransposeMatrixf = pointerBuffer.get(384);
/*  5669 */     this.glMultTransposeMatrixd = pointerBuffer.get(385);
/*  5670 */     this.glBlendColor = pointerBuffer.get(386);
/*  5671 */     this.glBlendEquation = pointerBuffer.get(387);
/*  5672 */     this.glFogCoordf = pointerBuffer.get(388);
/*  5673 */     this.glFogCoordd = pointerBuffer.get(389);
/*  5674 */     this.glFogCoordfv = pointerBuffer.get(390);
/*  5675 */     this.glFogCoorddv = pointerBuffer.get(391);
/*  5676 */     this.glFogCoordPointer = pointerBuffer.get(392);
/*  5677 */     this.glMultiDrawArrays = pointerBuffer.get(393);
/*  5678 */     this.glMultiDrawElements = pointerBuffer.get(394);
/*  5679 */     this.glPointParameterf = pointerBuffer.get(395);
/*  5680 */     this.glPointParameteri = pointerBuffer.get(396);
/*  5681 */     this.glPointParameterfv = pointerBuffer.get(397);
/*  5682 */     this.glPointParameteriv = pointerBuffer.get(398);
/*  5683 */     this.glSecondaryColor3b = pointerBuffer.get(399);
/*  5684 */     this.glSecondaryColor3s = pointerBuffer.get(400);
/*  5685 */     this.glSecondaryColor3i = pointerBuffer.get(401);
/*  5686 */     this.glSecondaryColor3f = pointerBuffer.get(402);
/*  5687 */     this.glSecondaryColor3d = pointerBuffer.get(403);
/*  5688 */     this.glSecondaryColor3ub = pointerBuffer.get(404);
/*  5689 */     this.glSecondaryColor3us = pointerBuffer.get(405);
/*  5690 */     this.glSecondaryColor3ui = pointerBuffer.get(406);
/*  5691 */     this.glSecondaryColor3bv = pointerBuffer.get(407);
/*  5692 */     this.glSecondaryColor3sv = pointerBuffer.get(408);
/*  5693 */     this.glSecondaryColor3iv = pointerBuffer.get(409);
/*  5694 */     this.glSecondaryColor3fv = pointerBuffer.get(410);
/*  5695 */     this.glSecondaryColor3dv = pointerBuffer.get(411);
/*  5696 */     this.glSecondaryColor3ubv = pointerBuffer.get(412);
/*  5697 */     this.glSecondaryColor3usv = pointerBuffer.get(413);
/*  5698 */     this.glSecondaryColor3uiv = pointerBuffer.get(414);
/*  5699 */     this.glSecondaryColorPointer = pointerBuffer.get(415);
/*  5700 */     this.glBlendFuncSeparate = pointerBuffer.get(416);
/*  5701 */     this.glWindowPos2i = pointerBuffer.get(417);
/*  5702 */     this.glWindowPos2s = pointerBuffer.get(418);
/*  5703 */     this.glWindowPos2f = pointerBuffer.get(419);
/*  5704 */     this.glWindowPos2d = pointerBuffer.get(420);
/*  5705 */     this.glWindowPos2iv = pointerBuffer.get(421);
/*  5706 */     this.glWindowPos2sv = pointerBuffer.get(422);
/*  5707 */     this.glWindowPos2fv = pointerBuffer.get(423);
/*  5708 */     this.glWindowPos2dv = pointerBuffer.get(424);
/*  5709 */     this.glWindowPos3i = pointerBuffer.get(425);
/*  5710 */     this.glWindowPos3s = pointerBuffer.get(426);
/*  5711 */     this.glWindowPos3f = pointerBuffer.get(427);
/*  5712 */     this.glWindowPos3d = pointerBuffer.get(428);
/*  5713 */     this.glWindowPos3iv = pointerBuffer.get(429);
/*  5714 */     this.glWindowPos3sv = pointerBuffer.get(430);
/*  5715 */     this.glWindowPos3fv = pointerBuffer.get(431);
/*  5716 */     this.glWindowPos3dv = pointerBuffer.get(432);
/*  5717 */     this.glBindBuffer = pointerBuffer.get(433);
/*  5718 */     this.glDeleteBuffers = pointerBuffer.get(434);
/*  5719 */     this.glGenBuffers = pointerBuffer.get(435);
/*  5720 */     this.glIsBuffer = pointerBuffer.get(436);
/*  5721 */     this.glBufferData = pointerBuffer.get(437);
/*  5722 */     this.glBufferSubData = pointerBuffer.get(438);
/*  5723 */     this.glGetBufferSubData = pointerBuffer.get(439);
/*  5724 */     this.glMapBuffer = pointerBuffer.get(440);
/*  5725 */     this.glUnmapBuffer = pointerBuffer.get(441);
/*  5726 */     this.glGetBufferParameteriv = pointerBuffer.get(442);
/*  5727 */     this.glGetBufferPointerv = pointerBuffer.get(443);
/*  5728 */     this.glGenQueries = pointerBuffer.get(444);
/*  5729 */     this.glDeleteQueries = pointerBuffer.get(445);
/*  5730 */     this.glIsQuery = pointerBuffer.get(446);
/*  5731 */     this.glBeginQuery = pointerBuffer.get(447);
/*  5732 */     this.glEndQuery = pointerBuffer.get(448);
/*  5733 */     this.glGetQueryiv = pointerBuffer.get(449);
/*  5734 */     this.glGetQueryObjectiv = pointerBuffer.get(450);
/*  5735 */     this.glGetQueryObjectuiv = pointerBuffer.get(451);
/*  5736 */     this.glCreateProgram = pointerBuffer.get(452);
/*  5737 */     this.glDeleteProgram = pointerBuffer.get(453);
/*  5738 */     this.glIsProgram = pointerBuffer.get(454);
/*  5739 */     this.glCreateShader = pointerBuffer.get(455);
/*  5740 */     this.glDeleteShader = pointerBuffer.get(456);
/*  5741 */     this.glIsShader = pointerBuffer.get(457);
/*  5742 */     this.glAttachShader = pointerBuffer.get(458);
/*  5743 */     this.glDetachShader = pointerBuffer.get(459);
/*  5744 */     this.glShaderSource = pointerBuffer.get(460);
/*  5745 */     this.glCompileShader = pointerBuffer.get(461);
/*  5746 */     this.glLinkProgram = pointerBuffer.get(462);
/*  5747 */     this.glUseProgram = pointerBuffer.get(463);
/*  5748 */     this.glValidateProgram = pointerBuffer.get(464);
/*  5749 */     this.glUniform1f = pointerBuffer.get(465);
/*  5750 */     this.glUniform2f = pointerBuffer.get(466);
/*  5751 */     this.glUniform3f = pointerBuffer.get(467);
/*  5752 */     this.glUniform4f = pointerBuffer.get(468);
/*  5753 */     this.glUniform1i = pointerBuffer.get(469);
/*  5754 */     this.glUniform2i = pointerBuffer.get(470);
/*  5755 */     this.glUniform3i = pointerBuffer.get(471);
/*  5756 */     this.glUniform4i = pointerBuffer.get(472);
/*  5757 */     this.glUniform1fv = pointerBuffer.get(473);
/*  5758 */     this.glUniform2fv = pointerBuffer.get(474);
/*  5759 */     this.glUniform3fv = pointerBuffer.get(475);
/*  5760 */     this.glUniform4fv = pointerBuffer.get(476);
/*  5761 */     this.glUniform1iv = pointerBuffer.get(477);
/*  5762 */     this.glUniform2iv = pointerBuffer.get(478);
/*  5763 */     this.glUniform3iv = pointerBuffer.get(479);
/*  5764 */     this.glUniform4iv = pointerBuffer.get(480);
/*  5765 */     this.glUniformMatrix2fv = pointerBuffer.get(481);
/*  5766 */     this.glUniformMatrix3fv = pointerBuffer.get(482);
/*  5767 */     this.glUniformMatrix4fv = pointerBuffer.get(483);
/*  5768 */     this.glGetShaderiv = pointerBuffer.get(484);
/*  5769 */     this.glGetProgramiv = pointerBuffer.get(485);
/*  5770 */     this.glGetShaderInfoLog = pointerBuffer.get(486);
/*  5771 */     this.glGetProgramInfoLog = pointerBuffer.get(487);
/*  5772 */     this.glGetAttachedShaders = pointerBuffer.get(488);
/*  5773 */     this.glGetUniformLocation = pointerBuffer.get(489);
/*  5774 */     this.glGetActiveUniform = pointerBuffer.get(490);
/*  5775 */     this.glGetUniformfv = pointerBuffer.get(491);
/*  5776 */     this.glGetUniformiv = pointerBuffer.get(492);
/*  5777 */     this.glGetShaderSource = pointerBuffer.get(493);
/*  5778 */     this.glVertexAttrib1f = pointerBuffer.get(494);
/*  5779 */     this.glVertexAttrib1s = pointerBuffer.get(495);
/*  5780 */     this.glVertexAttrib1d = pointerBuffer.get(496);
/*  5781 */     this.glVertexAttrib2f = pointerBuffer.get(497);
/*  5782 */     this.glVertexAttrib2s = pointerBuffer.get(498);
/*  5783 */     this.glVertexAttrib2d = pointerBuffer.get(499);
/*  5784 */     this.glVertexAttrib3f = pointerBuffer.get(500);
/*  5785 */     this.glVertexAttrib3s = pointerBuffer.get(501);
/*  5786 */     this.glVertexAttrib3d = pointerBuffer.get(502);
/*  5787 */     this.glVertexAttrib4f = pointerBuffer.get(503);
/*  5788 */     this.glVertexAttrib4s = pointerBuffer.get(504);
/*  5789 */     this.glVertexAttrib4d = pointerBuffer.get(505);
/*  5790 */     this.glVertexAttrib4Nub = pointerBuffer.get(506);
/*  5791 */     this.glVertexAttrib1fv = pointerBuffer.get(507);
/*  5792 */     this.glVertexAttrib1sv = pointerBuffer.get(508);
/*  5793 */     this.glVertexAttrib1dv = pointerBuffer.get(509);
/*  5794 */     this.glVertexAttrib2fv = pointerBuffer.get(510);
/*  5795 */     this.glVertexAttrib2sv = pointerBuffer.get(511);
/*  5796 */     this.glVertexAttrib2dv = pointerBuffer.get(512);
/*  5797 */     this.glVertexAttrib3fv = pointerBuffer.get(513);
/*  5798 */     this.glVertexAttrib3sv = pointerBuffer.get(514);
/*  5799 */     this.glVertexAttrib3dv = pointerBuffer.get(515);
/*  5800 */     this.glVertexAttrib4fv = pointerBuffer.get(516);
/*  5801 */     this.glVertexAttrib4sv = pointerBuffer.get(517);
/*  5802 */     this.glVertexAttrib4dv = pointerBuffer.get(518);
/*  5803 */     this.glVertexAttrib4iv = pointerBuffer.get(519);
/*  5804 */     this.glVertexAttrib4bv = pointerBuffer.get(520);
/*  5805 */     this.glVertexAttrib4ubv = pointerBuffer.get(521);
/*  5806 */     this.glVertexAttrib4usv = pointerBuffer.get(522);
/*  5807 */     this.glVertexAttrib4uiv = pointerBuffer.get(523);
/*  5808 */     this.glVertexAttrib4Nbv = pointerBuffer.get(524);
/*  5809 */     this.glVertexAttrib4Nsv = pointerBuffer.get(525);
/*  5810 */     this.glVertexAttrib4Niv = pointerBuffer.get(526);
/*  5811 */     this.glVertexAttrib4Nubv = pointerBuffer.get(527);
/*  5812 */     this.glVertexAttrib4Nusv = pointerBuffer.get(528);
/*  5813 */     this.glVertexAttrib4Nuiv = pointerBuffer.get(529);
/*  5814 */     this.glVertexAttribPointer = pointerBuffer.get(530);
/*  5815 */     this.glEnableVertexAttribArray = pointerBuffer.get(531);
/*  5816 */     this.glDisableVertexAttribArray = pointerBuffer.get(532);
/*  5817 */     this.glBindAttribLocation = pointerBuffer.get(533);
/*  5818 */     this.glGetActiveAttrib = pointerBuffer.get(534);
/*  5819 */     this.glGetAttribLocation = pointerBuffer.get(535);
/*  5820 */     this.glGetVertexAttribiv = pointerBuffer.get(536);
/*  5821 */     this.glGetVertexAttribfv = pointerBuffer.get(537);
/*  5822 */     this.glGetVertexAttribdv = pointerBuffer.get(538);
/*  5823 */     this.glGetVertexAttribPointerv = pointerBuffer.get(539);
/*  5824 */     this.glDrawBuffers = pointerBuffer.get(540);
/*  5825 */     this.glBlendEquationSeparate = pointerBuffer.get(541);
/*  5826 */     this.glStencilOpSeparate = pointerBuffer.get(542);
/*  5827 */     this.glStencilFuncSeparate = pointerBuffer.get(543);
/*  5828 */     this.glStencilMaskSeparate = pointerBuffer.get(544);
/*  5829 */     this.glUniformMatrix2x3fv = pointerBuffer.get(545);
/*  5830 */     this.glUniformMatrix3x2fv = pointerBuffer.get(546);
/*  5831 */     this.glUniformMatrix2x4fv = pointerBuffer.get(547);
/*  5832 */     this.glUniformMatrix4x2fv = pointerBuffer.get(548);
/*  5833 */     this.glUniformMatrix3x4fv = pointerBuffer.get(549);
/*  5834 */     this.glUniformMatrix4x3fv = pointerBuffer.get(550);
/*  5835 */     this.glGetStringi = pointerBuffer.get(551);
/*  5836 */     this.glClearBufferiv = pointerBuffer.get(552);
/*  5837 */     this.glClearBufferuiv = pointerBuffer.get(553);
/*  5838 */     this.glClearBufferfv = pointerBuffer.get(554);
/*  5839 */     this.glClearBufferfi = pointerBuffer.get(555);
/*  5840 */     this.glVertexAttribI1i = pointerBuffer.get(556);
/*  5841 */     this.glVertexAttribI2i = pointerBuffer.get(557);
/*  5842 */     this.glVertexAttribI3i = pointerBuffer.get(558);
/*  5843 */     this.glVertexAttribI4i = pointerBuffer.get(559);
/*  5844 */     this.glVertexAttribI1ui = pointerBuffer.get(560);
/*  5845 */     this.glVertexAttribI2ui = pointerBuffer.get(561);
/*  5846 */     this.glVertexAttribI3ui = pointerBuffer.get(562);
/*  5847 */     this.glVertexAttribI4ui = pointerBuffer.get(563);
/*  5848 */     this.glVertexAttribI1iv = pointerBuffer.get(564);
/*  5849 */     this.glVertexAttribI2iv = pointerBuffer.get(565);
/*  5850 */     this.glVertexAttribI3iv = pointerBuffer.get(566);
/*  5851 */     this.glVertexAttribI4iv = pointerBuffer.get(567);
/*  5852 */     this.glVertexAttribI1uiv = pointerBuffer.get(568);
/*  5853 */     this.glVertexAttribI2uiv = pointerBuffer.get(569);
/*  5854 */     this.glVertexAttribI3uiv = pointerBuffer.get(570);
/*  5855 */     this.glVertexAttribI4uiv = pointerBuffer.get(571);
/*  5856 */     this.glVertexAttribI4bv = pointerBuffer.get(572);
/*  5857 */     this.glVertexAttribI4sv = pointerBuffer.get(573);
/*  5858 */     this.glVertexAttribI4ubv = pointerBuffer.get(574);
/*  5859 */     this.glVertexAttribI4usv = pointerBuffer.get(575);
/*  5860 */     this.glVertexAttribIPointer = pointerBuffer.get(576);
/*  5861 */     this.glGetVertexAttribIiv = pointerBuffer.get(577);
/*  5862 */     this.glGetVertexAttribIuiv = pointerBuffer.get(578);
/*  5863 */     this.glUniform1ui = pointerBuffer.get(579);
/*  5864 */     this.glUniform2ui = pointerBuffer.get(580);
/*  5865 */     this.glUniform3ui = pointerBuffer.get(581);
/*  5866 */     this.glUniform4ui = pointerBuffer.get(582);
/*  5867 */     this.glUniform1uiv = pointerBuffer.get(583);
/*  5868 */     this.glUniform2uiv = pointerBuffer.get(584);
/*  5869 */     this.glUniform3uiv = pointerBuffer.get(585);
/*  5870 */     this.glUniform4uiv = pointerBuffer.get(586);
/*  5871 */     this.glGetUniformuiv = pointerBuffer.get(587);
/*  5872 */     this.glBindFragDataLocation = pointerBuffer.get(588);
/*  5873 */     this.glGetFragDataLocation = pointerBuffer.get(589);
/*  5874 */     this.glBeginConditionalRender = pointerBuffer.get(590);
/*  5875 */     this.glEndConditionalRender = pointerBuffer.get(591);
/*  5876 */     this.glMapBufferRange = pointerBuffer.get(592);
/*  5877 */     this.glFlushMappedBufferRange = pointerBuffer.get(593);
/*  5878 */     this.glClampColor = pointerBuffer.get(594);
/*  5879 */     this.glIsRenderbuffer = pointerBuffer.get(595);
/*  5880 */     this.glBindRenderbuffer = pointerBuffer.get(596);
/*  5881 */     this.glDeleteRenderbuffers = pointerBuffer.get(597);
/*  5882 */     this.glGenRenderbuffers = pointerBuffer.get(598);
/*  5883 */     this.glRenderbufferStorage = pointerBuffer.get(599);
/*  5884 */     this.glRenderbufferStorageMultisample = pointerBuffer.get(600);
/*  5885 */     this.glGetRenderbufferParameteriv = pointerBuffer.get(601);
/*  5886 */     this.glIsFramebuffer = pointerBuffer.get(602);
/*  5887 */     this.glBindFramebuffer = pointerBuffer.get(603);
/*  5888 */     this.glDeleteFramebuffers = pointerBuffer.get(604);
/*  5889 */     this.glGenFramebuffers = pointerBuffer.get(605);
/*  5890 */     this.glCheckFramebufferStatus = pointerBuffer.get(606);
/*  5891 */     this.glFramebufferTexture1D = pointerBuffer.get(607);
/*  5892 */     this.glFramebufferTexture2D = pointerBuffer.get(608);
/*  5893 */     this.glFramebufferTexture3D = pointerBuffer.get(609);
/*  5894 */     this.glFramebufferTextureLayer = pointerBuffer.get(610);
/*  5895 */     this.glFramebufferRenderbuffer = pointerBuffer.get(611);
/*  5896 */     this.glGetFramebufferAttachmentParameteriv = pointerBuffer.get(612);
/*  5897 */     this.glBlitFramebuffer = pointerBuffer.get(613);
/*  5898 */     this.glGenerateMipmap = pointerBuffer.get(614);
/*  5899 */     this.glTexParameterIiv = pointerBuffer.get(615);
/*  5900 */     this.glTexParameterIuiv = pointerBuffer.get(616);
/*  5901 */     this.glGetTexParameterIiv = pointerBuffer.get(617);
/*  5902 */     this.glGetTexParameterIuiv = pointerBuffer.get(618);
/*  5903 */     this.glColorMaski = pointerBuffer.get(619);
/*  5904 */     this.glGetBooleani_v = pointerBuffer.get(620);
/*  5905 */     this.glGetIntegeri_v = pointerBuffer.get(621);
/*  5906 */     this.glEnablei = pointerBuffer.get(622);
/*  5907 */     this.glDisablei = pointerBuffer.get(623);
/*  5908 */     this.glIsEnabledi = pointerBuffer.get(624);
/*  5909 */     this.glBindBufferRange = pointerBuffer.get(625);
/*  5910 */     this.glBindBufferBase = pointerBuffer.get(626);
/*  5911 */     this.glBeginTransformFeedback = pointerBuffer.get(627);
/*  5912 */     this.glEndTransformFeedback = pointerBuffer.get(628);
/*  5913 */     this.glTransformFeedbackVaryings = pointerBuffer.get(629);
/*  5914 */     this.glGetTransformFeedbackVarying = pointerBuffer.get(630);
/*  5915 */     this.glBindVertexArray = pointerBuffer.get(631);
/*  5916 */     this.glDeleteVertexArrays = pointerBuffer.get(632);
/*  5917 */     this.glGenVertexArrays = pointerBuffer.get(633);
/*  5918 */     this.glIsVertexArray = pointerBuffer.get(634);
/*  5919 */     this.glDrawArraysInstanced = pointerBuffer.get(635);
/*  5920 */     this.glDrawElementsInstanced = pointerBuffer.get(636);
/*  5921 */     this.glCopyBufferSubData = pointerBuffer.get(637);
/*  5922 */     this.glPrimitiveRestartIndex = pointerBuffer.get(638);
/*  5923 */     this.glTexBuffer = pointerBuffer.get(639);
/*  5924 */     this.glGetUniformIndices = pointerBuffer.get(640);
/*  5925 */     this.glGetActiveUniformsiv = pointerBuffer.get(641);
/*  5926 */     this.glGetActiveUniformName = pointerBuffer.get(642);
/*  5927 */     this.glGetUniformBlockIndex = pointerBuffer.get(643);
/*  5928 */     this.glGetActiveUniformBlockiv = pointerBuffer.get(644);
/*  5929 */     this.glGetActiveUniformBlockName = pointerBuffer.get(645);
/*  5930 */     this.glUniformBlockBinding = pointerBuffer.get(646);
/*  5931 */     this.glGetBufferParameteri64v = pointerBuffer.get(647);
/*  5932 */     this.glDrawElementsBaseVertex = pointerBuffer.get(648);
/*  5933 */     this.glDrawRangeElementsBaseVertex = pointerBuffer.get(649);
/*  5934 */     this.glDrawElementsInstancedBaseVertex = pointerBuffer.get(650);
/*  5935 */     this.glMultiDrawElementsBaseVertex = pointerBuffer.get(651);
/*  5936 */     this.glProvokingVertex = pointerBuffer.get(652);
/*  5937 */     this.glTexImage2DMultisample = pointerBuffer.get(653);
/*  5938 */     this.glTexImage3DMultisample = pointerBuffer.get(654);
/*  5939 */     this.glGetMultisamplefv = pointerBuffer.get(655);
/*  5940 */     this.glSampleMaski = pointerBuffer.get(656);
/*  5941 */     this.glFramebufferTexture = pointerBuffer.get(657);
/*  5942 */     this.glFenceSync = pointerBuffer.get(658);
/*  5943 */     this.glIsSync = pointerBuffer.get(659);
/*  5944 */     this.glDeleteSync = pointerBuffer.get(660);
/*  5945 */     this.glClientWaitSync = pointerBuffer.get(661);
/*  5946 */     this.glWaitSync = pointerBuffer.get(662);
/*  5947 */     this.glGetInteger64v = pointerBuffer.get(663);
/*  5948 */     this.glGetInteger64i_v = pointerBuffer.get(664);
/*  5949 */     this.glGetSynciv = pointerBuffer.get(665);
/*  5950 */     this.glBindFragDataLocationIndexed = pointerBuffer.get(666);
/*  5951 */     this.glGetFragDataIndex = pointerBuffer.get(667);
/*  5952 */     this.glGenSamplers = pointerBuffer.get(668);
/*  5953 */     this.glDeleteSamplers = pointerBuffer.get(669);
/*  5954 */     this.glIsSampler = pointerBuffer.get(670);
/*  5955 */     this.glBindSampler = pointerBuffer.get(671);
/*  5956 */     this.glSamplerParameteri = pointerBuffer.get(672);
/*  5957 */     this.glSamplerParameterf = pointerBuffer.get(673);
/*  5958 */     this.glSamplerParameteriv = pointerBuffer.get(674);
/*  5959 */     this.glSamplerParameterfv = pointerBuffer.get(675);
/*  5960 */     this.glSamplerParameterIiv = pointerBuffer.get(676);
/*  5961 */     this.glSamplerParameterIuiv = pointerBuffer.get(677);
/*  5962 */     this.glGetSamplerParameteriv = pointerBuffer.get(678);
/*  5963 */     this.glGetSamplerParameterfv = pointerBuffer.get(679);
/*  5964 */     this.glGetSamplerParameterIiv = pointerBuffer.get(680);
/*  5965 */     this.glGetSamplerParameterIuiv = pointerBuffer.get(681);
/*  5966 */     this.glQueryCounter = pointerBuffer.get(682);
/*  5967 */     this.glGetQueryObjecti64v = pointerBuffer.get(683);
/*  5968 */     this.glGetQueryObjectui64v = pointerBuffer.get(684);
/*  5969 */     this.glVertexAttribDivisor = pointerBuffer.get(685);
/*  5970 */     this.glVertexP2ui = pointerBuffer.get(686);
/*  5971 */     this.glVertexP3ui = pointerBuffer.get(687);
/*  5972 */     this.glVertexP4ui = pointerBuffer.get(688);
/*  5973 */     this.glVertexP2uiv = pointerBuffer.get(689);
/*  5974 */     this.glVertexP3uiv = pointerBuffer.get(690);
/*  5975 */     this.glVertexP4uiv = pointerBuffer.get(691);
/*  5976 */     this.glTexCoordP1ui = pointerBuffer.get(692);
/*  5977 */     this.glTexCoordP2ui = pointerBuffer.get(693);
/*  5978 */     this.glTexCoordP3ui = pointerBuffer.get(694);
/*  5979 */     this.glTexCoordP4ui = pointerBuffer.get(695);
/*  5980 */     this.glTexCoordP1uiv = pointerBuffer.get(696);
/*  5981 */     this.glTexCoordP2uiv = pointerBuffer.get(697);
/*  5982 */     this.glTexCoordP3uiv = pointerBuffer.get(698);
/*  5983 */     this.glTexCoordP4uiv = pointerBuffer.get(699);
/*  5984 */     this.glMultiTexCoordP1ui = pointerBuffer.get(700);
/*  5985 */     this.glMultiTexCoordP2ui = pointerBuffer.get(701);
/*  5986 */     this.glMultiTexCoordP3ui = pointerBuffer.get(702);
/*  5987 */     this.glMultiTexCoordP4ui = pointerBuffer.get(703);
/*  5988 */     this.glMultiTexCoordP1uiv = pointerBuffer.get(704);
/*  5989 */     this.glMultiTexCoordP2uiv = pointerBuffer.get(705);
/*  5990 */     this.glMultiTexCoordP3uiv = pointerBuffer.get(706);
/*  5991 */     this.glMultiTexCoordP4uiv = pointerBuffer.get(707);
/*  5992 */     this.glNormalP3ui = pointerBuffer.get(708);
/*  5993 */     this.glNormalP3uiv = pointerBuffer.get(709);
/*  5994 */     this.glColorP3ui = pointerBuffer.get(710);
/*  5995 */     this.glColorP4ui = pointerBuffer.get(711);
/*  5996 */     this.glColorP3uiv = pointerBuffer.get(712);
/*  5997 */     this.glColorP4uiv = pointerBuffer.get(713);
/*  5998 */     this.glSecondaryColorP3ui = pointerBuffer.get(714);
/*  5999 */     this.glSecondaryColorP3uiv = pointerBuffer.get(715);
/*  6000 */     this.glVertexAttribP1ui = pointerBuffer.get(716);
/*  6001 */     this.glVertexAttribP2ui = pointerBuffer.get(717);
/*  6002 */     this.glVertexAttribP3ui = pointerBuffer.get(718);
/*  6003 */     this.glVertexAttribP4ui = pointerBuffer.get(719);
/*  6004 */     this.glVertexAttribP1uiv = pointerBuffer.get(720);
/*  6005 */     this.glVertexAttribP2uiv = pointerBuffer.get(721);
/*  6006 */     this.glVertexAttribP3uiv = pointerBuffer.get(722);
/*  6007 */     this.glVertexAttribP4uiv = pointerBuffer.get(723);
/*  6008 */     this.glBlendEquationi = pointerBuffer.get(724);
/*  6009 */     this.glBlendEquationSeparatei = pointerBuffer.get(725);
/*  6010 */     this.glBlendFunci = pointerBuffer.get(726);
/*  6011 */     this.glBlendFuncSeparatei = pointerBuffer.get(727);
/*  6012 */     this.glDrawArraysIndirect = pointerBuffer.get(728);
/*  6013 */     this.glDrawElementsIndirect = pointerBuffer.get(729);
/*  6014 */     this.glUniform1d = pointerBuffer.get(730);
/*  6015 */     this.glUniform2d = pointerBuffer.get(731);
/*  6016 */     this.glUniform3d = pointerBuffer.get(732);
/*  6017 */     this.glUniform4d = pointerBuffer.get(733);
/*  6018 */     this.glUniform1dv = pointerBuffer.get(734);
/*  6019 */     this.glUniform2dv = pointerBuffer.get(735);
/*  6020 */     this.glUniform3dv = pointerBuffer.get(736);
/*  6021 */     this.glUniform4dv = pointerBuffer.get(737);
/*  6022 */     this.glUniformMatrix2dv = pointerBuffer.get(738);
/*  6023 */     this.glUniformMatrix3dv = pointerBuffer.get(739);
/*  6024 */     this.glUniformMatrix4dv = pointerBuffer.get(740);
/*  6025 */     this.glUniformMatrix2x3dv = pointerBuffer.get(741);
/*  6026 */     this.glUniformMatrix2x4dv = pointerBuffer.get(742);
/*  6027 */     this.glUniformMatrix3x2dv = pointerBuffer.get(743);
/*  6028 */     this.glUniformMatrix3x4dv = pointerBuffer.get(744);
/*  6029 */     this.glUniformMatrix4x2dv = pointerBuffer.get(745);
/*  6030 */     this.glUniformMatrix4x3dv = pointerBuffer.get(746);
/*  6031 */     this.glGetUniformdv = pointerBuffer.get(747);
/*  6032 */     this.glMinSampleShading = pointerBuffer.get(748);
/*  6033 */     this.glGetSubroutineUniformLocation = pointerBuffer.get(749);
/*  6034 */     this.glGetSubroutineIndex = pointerBuffer.get(750);
/*  6035 */     this.glGetActiveSubroutineUniformiv = pointerBuffer.get(751);
/*  6036 */     this.glGetActiveSubroutineUniformName = pointerBuffer.get(752);
/*  6037 */     this.glGetActiveSubroutineName = pointerBuffer.get(753);
/*  6038 */     this.glUniformSubroutinesuiv = pointerBuffer.get(754);
/*  6039 */     this.glGetUniformSubroutineuiv = pointerBuffer.get(755);
/*  6040 */     this.glGetProgramStageiv = pointerBuffer.get(756);
/*  6041 */     this.glPatchParameteri = pointerBuffer.get(757);
/*  6042 */     this.glPatchParameterfv = pointerBuffer.get(758);
/*  6043 */     this.glBindTransformFeedback = pointerBuffer.get(759);
/*  6044 */     this.glDeleteTransformFeedbacks = pointerBuffer.get(760);
/*  6045 */     this.glGenTransformFeedbacks = pointerBuffer.get(761);
/*  6046 */     this.glIsTransformFeedback = pointerBuffer.get(762);
/*  6047 */     this.glPauseTransformFeedback = pointerBuffer.get(763);
/*  6048 */     this.glResumeTransformFeedback = pointerBuffer.get(764);
/*  6049 */     this.glDrawTransformFeedback = pointerBuffer.get(765);
/*  6050 */     this.glDrawTransformFeedbackStream = pointerBuffer.get(766);
/*  6051 */     this.glBeginQueryIndexed = pointerBuffer.get(767);
/*  6052 */     this.glEndQueryIndexed = pointerBuffer.get(768);
/*  6053 */     this.glGetQueryIndexediv = pointerBuffer.get(769);
/*  6054 */     this.glReleaseShaderCompiler = pointerBuffer.get(770);
/*  6055 */     this.glShaderBinary = pointerBuffer.get(771);
/*  6056 */     this.glGetShaderPrecisionFormat = pointerBuffer.get(772);
/*  6057 */     this.glDepthRangef = pointerBuffer.get(773);
/*  6058 */     this.glClearDepthf = pointerBuffer.get(774);
/*  6059 */     this.glGetProgramBinary = pointerBuffer.get(775);
/*  6060 */     this.glProgramBinary = pointerBuffer.get(776);
/*  6061 */     this.glProgramParameteri = pointerBuffer.get(777);
/*  6062 */     this.glUseProgramStages = pointerBuffer.get(778);
/*  6063 */     this.glActiveShaderProgram = pointerBuffer.get(779);
/*  6064 */     this.glCreateShaderProgramv = pointerBuffer.get(780);
/*  6065 */     this.glBindProgramPipeline = pointerBuffer.get(781);
/*  6066 */     this.glDeleteProgramPipelines = pointerBuffer.get(782);
/*  6067 */     this.glGenProgramPipelines = pointerBuffer.get(783);
/*  6068 */     this.glIsProgramPipeline = pointerBuffer.get(784);
/*  6069 */     this.glGetProgramPipelineiv = pointerBuffer.get(785);
/*  6070 */     this.glProgramUniform1i = pointerBuffer.get(786);
/*  6071 */     this.glProgramUniform2i = pointerBuffer.get(787);
/*  6072 */     this.glProgramUniform3i = pointerBuffer.get(788);
/*  6073 */     this.glProgramUniform4i = pointerBuffer.get(789);
/*  6074 */     this.glProgramUniform1ui = pointerBuffer.get(790);
/*  6075 */     this.glProgramUniform2ui = pointerBuffer.get(791);
/*  6076 */     this.glProgramUniform3ui = pointerBuffer.get(792);
/*  6077 */     this.glProgramUniform4ui = pointerBuffer.get(793);
/*  6078 */     this.glProgramUniform1f = pointerBuffer.get(794);
/*  6079 */     this.glProgramUniform2f = pointerBuffer.get(795);
/*  6080 */     this.glProgramUniform3f = pointerBuffer.get(796);
/*  6081 */     this.glProgramUniform4f = pointerBuffer.get(797);
/*  6082 */     this.glProgramUniform1d = pointerBuffer.get(798);
/*  6083 */     this.glProgramUniform2d = pointerBuffer.get(799);
/*  6084 */     this.glProgramUniform3d = pointerBuffer.get(800);
/*  6085 */     this.glProgramUniform4d = pointerBuffer.get(801);
/*  6086 */     this.glProgramUniform1iv = pointerBuffer.get(802);
/*  6087 */     this.glProgramUniform2iv = pointerBuffer.get(803);
/*  6088 */     this.glProgramUniform3iv = pointerBuffer.get(804);
/*  6089 */     this.glProgramUniform4iv = pointerBuffer.get(805);
/*  6090 */     this.glProgramUniform1uiv = pointerBuffer.get(806);
/*  6091 */     this.glProgramUniform2uiv = pointerBuffer.get(807);
/*  6092 */     this.glProgramUniform3uiv = pointerBuffer.get(808);
/*  6093 */     this.glProgramUniform4uiv = pointerBuffer.get(809);
/*  6094 */     this.glProgramUniform1fv = pointerBuffer.get(810);
/*  6095 */     this.glProgramUniform2fv = pointerBuffer.get(811);
/*  6096 */     this.glProgramUniform3fv = pointerBuffer.get(812);
/*  6097 */     this.glProgramUniform4fv = pointerBuffer.get(813);
/*  6098 */     this.glProgramUniform1dv = pointerBuffer.get(814);
/*  6099 */     this.glProgramUniform2dv = pointerBuffer.get(815);
/*  6100 */     this.glProgramUniform3dv = pointerBuffer.get(816);
/*  6101 */     this.glProgramUniform4dv = pointerBuffer.get(817);
/*  6102 */     this.glProgramUniformMatrix2fv = pointerBuffer.get(818);
/*  6103 */     this.glProgramUniformMatrix3fv = pointerBuffer.get(819);
/*  6104 */     this.glProgramUniformMatrix4fv = pointerBuffer.get(820);
/*  6105 */     this.glProgramUniformMatrix2dv = pointerBuffer.get(821);
/*  6106 */     this.glProgramUniformMatrix3dv = pointerBuffer.get(822);
/*  6107 */     this.glProgramUniformMatrix4dv = pointerBuffer.get(823);
/*  6108 */     this.glProgramUniformMatrix2x3fv = pointerBuffer.get(824);
/*  6109 */     this.glProgramUniformMatrix3x2fv = pointerBuffer.get(825);
/*  6110 */     this.glProgramUniformMatrix2x4fv = pointerBuffer.get(826);
/*  6111 */     this.glProgramUniformMatrix4x2fv = pointerBuffer.get(827);
/*  6112 */     this.glProgramUniformMatrix3x4fv = pointerBuffer.get(828);
/*  6113 */     this.glProgramUniformMatrix4x3fv = pointerBuffer.get(829);
/*  6114 */     this.glProgramUniformMatrix2x3dv = pointerBuffer.get(830);
/*  6115 */     this.glProgramUniformMatrix3x2dv = pointerBuffer.get(831);
/*  6116 */     this.glProgramUniformMatrix2x4dv = pointerBuffer.get(832);
/*  6117 */     this.glProgramUniformMatrix4x2dv = pointerBuffer.get(833);
/*  6118 */     this.glProgramUniformMatrix3x4dv = pointerBuffer.get(834);
/*  6119 */     this.glProgramUniformMatrix4x3dv = pointerBuffer.get(835);
/*  6120 */     this.glValidateProgramPipeline = pointerBuffer.get(836);
/*  6121 */     this.glGetProgramPipelineInfoLog = pointerBuffer.get(837);
/*  6122 */     this.glVertexAttribL1d = pointerBuffer.get(838);
/*  6123 */     this.glVertexAttribL2d = pointerBuffer.get(839);
/*  6124 */     this.glVertexAttribL3d = pointerBuffer.get(840);
/*  6125 */     this.glVertexAttribL4d = pointerBuffer.get(841);
/*  6126 */     this.glVertexAttribL1dv = pointerBuffer.get(842);
/*  6127 */     this.glVertexAttribL2dv = pointerBuffer.get(843);
/*  6128 */     this.glVertexAttribL3dv = pointerBuffer.get(844);
/*  6129 */     this.glVertexAttribL4dv = pointerBuffer.get(845);
/*  6130 */     this.glVertexAttribLPointer = pointerBuffer.get(846);
/*  6131 */     this.glGetVertexAttribLdv = pointerBuffer.get(847);
/*  6132 */     this.glViewportArrayv = pointerBuffer.get(848);
/*  6133 */     this.glViewportIndexedf = pointerBuffer.get(849);
/*  6134 */     this.glViewportIndexedfv = pointerBuffer.get(850);
/*  6135 */     this.glScissorArrayv = pointerBuffer.get(851);
/*  6136 */     this.glScissorIndexed = pointerBuffer.get(852);
/*  6137 */     this.glScissorIndexedv = pointerBuffer.get(853);
/*  6138 */     this.glDepthRangeArrayv = pointerBuffer.get(854);
/*  6139 */     this.glDepthRangeIndexed = pointerBuffer.get(855);
/*  6140 */     this.glGetFloati_v = pointerBuffer.get(856);
/*  6141 */     this.glGetDoublei_v = pointerBuffer.get(857);
/*  6142 */     this.glGetActiveAtomicCounterBufferiv = pointerBuffer.get(858);
/*  6143 */     this.glTexStorage1D = pointerBuffer.get(859);
/*  6144 */     this.glTexStorage2D = pointerBuffer.get(860);
/*  6145 */     this.glTexStorage3D = pointerBuffer.get(861);
/*  6146 */     this.glDrawTransformFeedbackInstanced = pointerBuffer.get(862);
/*  6147 */     this.glDrawTransformFeedbackStreamInstanced = pointerBuffer.get(863);
/*  6148 */     this.glDrawArraysInstancedBaseInstance = pointerBuffer.get(864);
/*  6149 */     this.glDrawElementsInstancedBaseInstance = pointerBuffer.get(865);
/*  6150 */     this.glDrawElementsInstancedBaseVertexBaseInstance = pointerBuffer.get(866);
/*  6151 */     this.glBindImageTexture = pointerBuffer.get(867);
/*  6152 */     this.glMemoryBarrier = pointerBuffer.get(868);
/*  6153 */     this.glGetInternalformativ = pointerBuffer.get(869);
/*  6154 */     this.glClearBufferData = pointerBuffer.get(870);
/*  6155 */     this.glClearBufferSubData = pointerBuffer.get(871);
/*  6156 */     this.glDispatchCompute = pointerBuffer.get(872);
/*  6157 */     this.glDispatchComputeIndirect = pointerBuffer.get(873);
/*  6158 */     this.glCopyImageSubData = pointerBuffer.get(874);
/*  6159 */     this.glDebugMessageControl = pointerBuffer.get(875);
/*  6160 */     this.glDebugMessageInsert = pointerBuffer.get(876);
/*  6161 */     this.glDebugMessageCallback = pointerBuffer.get(877);
/*  6162 */     this.glGetDebugMessageLog = pointerBuffer.get(878);
/*  6163 */     this.glPushDebugGroup = pointerBuffer.get(879);
/*  6164 */     this.glPopDebugGroup = pointerBuffer.get(880);
/*  6165 */     this.glObjectLabel = pointerBuffer.get(881);
/*  6166 */     this.glGetObjectLabel = pointerBuffer.get(882);
/*  6167 */     this.glObjectPtrLabel = pointerBuffer.get(883);
/*  6168 */     this.glGetObjectPtrLabel = pointerBuffer.get(884);
/*  6169 */     this.glFramebufferParameteri = pointerBuffer.get(885);
/*  6170 */     this.glGetFramebufferParameteriv = pointerBuffer.get(886);
/*  6171 */     this.glGetInternalformati64v = pointerBuffer.get(887);
/*  6172 */     this.glInvalidateTexSubImage = pointerBuffer.get(888);
/*  6173 */     this.glInvalidateTexImage = pointerBuffer.get(889);
/*  6174 */     this.glInvalidateBufferSubData = pointerBuffer.get(890);
/*  6175 */     this.glInvalidateBufferData = pointerBuffer.get(891);
/*  6176 */     this.glInvalidateFramebuffer = pointerBuffer.get(892);
/*  6177 */     this.glInvalidateSubFramebuffer = pointerBuffer.get(893);
/*  6178 */     this.glMultiDrawArraysIndirect = pointerBuffer.get(894);
/*  6179 */     this.glMultiDrawElementsIndirect = pointerBuffer.get(895);
/*  6180 */     this.glGetProgramInterfaceiv = pointerBuffer.get(896);
/*  6181 */     this.glGetProgramResourceIndex = pointerBuffer.get(897);
/*  6182 */     this.glGetProgramResourceName = pointerBuffer.get(898);
/*  6183 */     this.glGetProgramResourceiv = pointerBuffer.get(899);
/*  6184 */     this.glGetProgramResourceLocation = pointerBuffer.get(900);
/*  6185 */     this.glGetProgramResourceLocationIndex = pointerBuffer.get(901);
/*  6186 */     this.glShaderStorageBlockBinding = pointerBuffer.get(902);
/*  6187 */     this.glTexBufferRange = pointerBuffer.get(903);
/*  6188 */     this.glTexStorage2DMultisample = pointerBuffer.get(904);
/*  6189 */     this.glTexStorage3DMultisample = pointerBuffer.get(905);
/*  6190 */     this.glTextureView = pointerBuffer.get(906);
/*  6191 */     this.glBindVertexBuffer = pointerBuffer.get(907);
/*  6192 */     this.glVertexAttribFormat = pointerBuffer.get(908);
/*  6193 */     this.glVertexAttribIFormat = pointerBuffer.get(909);
/*  6194 */     this.glVertexAttribLFormat = pointerBuffer.get(910);
/*  6195 */     this.glVertexAttribBinding = pointerBuffer.get(911);
/*  6196 */     this.glVertexBindingDivisor = pointerBuffer.get(912);
/*  6197 */     this.glBufferStorage = pointerBuffer.get(913);
/*  6198 */     this.glClearTexSubImage = pointerBuffer.get(914);
/*  6199 */     this.glClearTexImage = pointerBuffer.get(915);
/*  6200 */     this.glBindBuffersBase = pointerBuffer.get(916);
/*  6201 */     this.glBindBuffersRange = pointerBuffer.get(917);
/*  6202 */     this.glBindTextures = pointerBuffer.get(918);
/*  6203 */     this.glBindSamplers = pointerBuffer.get(919);
/*  6204 */     this.glBindImageTextures = pointerBuffer.get(920);
/*  6205 */     this.glBindVertexBuffers = pointerBuffer.get(921);
/*  6206 */     this.glClipControl = pointerBuffer.get(922);
/*  6207 */     this.glCreateTransformFeedbacks = pointerBuffer.get(923);
/*  6208 */     this.glTransformFeedbackBufferBase = pointerBuffer.get(924);
/*  6209 */     this.glTransformFeedbackBufferRange = pointerBuffer.get(925);
/*  6210 */     this.glGetTransformFeedbackiv = pointerBuffer.get(926);
/*  6211 */     this.glGetTransformFeedbacki_v = pointerBuffer.get(927);
/*  6212 */     this.glGetTransformFeedbacki64_v = pointerBuffer.get(928);
/*  6213 */     this.glCreateBuffers = pointerBuffer.get(929);
/*  6214 */     this.glNamedBufferStorage = pointerBuffer.get(930);
/*  6215 */     this.glNamedBufferData = pointerBuffer.get(931);
/*  6216 */     this.glNamedBufferSubData = pointerBuffer.get(932);
/*  6217 */     this.glCopyNamedBufferSubData = pointerBuffer.get(933);
/*  6218 */     this.glClearNamedBufferData = pointerBuffer.get(934);
/*  6219 */     this.glClearNamedBufferSubData = pointerBuffer.get(935);
/*  6220 */     this.glMapNamedBuffer = pointerBuffer.get(936);
/*  6221 */     this.glMapNamedBufferRange = pointerBuffer.get(937);
/*  6222 */     this.glUnmapNamedBuffer = pointerBuffer.get(938);
/*  6223 */     this.glFlushMappedNamedBufferRange = pointerBuffer.get(939);
/*  6224 */     this.glGetNamedBufferParameteriv = pointerBuffer.get(940);
/*  6225 */     this.glGetNamedBufferParameteri64v = pointerBuffer.get(941);
/*  6226 */     this.glGetNamedBufferPointerv = pointerBuffer.get(942);
/*  6227 */     this.glGetNamedBufferSubData = pointerBuffer.get(943);
/*  6228 */     this.glCreateFramebuffers = pointerBuffer.get(944);
/*  6229 */     this.glNamedFramebufferRenderbuffer = pointerBuffer.get(945);
/*  6230 */     this.glNamedFramebufferParameteri = pointerBuffer.get(946);
/*  6231 */     this.glNamedFramebufferTexture = pointerBuffer.get(947);
/*  6232 */     this.glNamedFramebufferTextureLayer = pointerBuffer.get(948);
/*  6233 */     this.glNamedFramebufferDrawBuffer = pointerBuffer.get(949);
/*  6234 */     this.glNamedFramebufferDrawBuffers = pointerBuffer.get(950);
/*  6235 */     this.glNamedFramebufferReadBuffer = pointerBuffer.get(951);
/*  6236 */     this.glInvalidateNamedFramebufferData = pointerBuffer.get(952);
/*  6237 */     this.glInvalidateNamedFramebufferSubData = pointerBuffer.get(953);
/*  6238 */     this.glClearNamedFramebufferiv = pointerBuffer.get(954);
/*  6239 */     this.glClearNamedFramebufferuiv = pointerBuffer.get(955);
/*  6240 */     this.glClearNamedFramebufferfv = pointerBuffer.get(956);
/*  6241 */     this.glClearNamedFramebufferfi = pointerBuffer.get(957);
/*  6242 */     this.glBlitNamedFramebuffer = pointerBuffer.get(958);
/*  6243 */     this.glCheckNamedFramebufferStatus = pointerBuffer.get(959);
/*  6244 */     this.glGetNamedFramebufferParameteriv = pointerBuffer.get(960);
/*  6245 */     this.glGetNamedFramebufferAttachmentParameteriv = pointerBuffer.get(961);
/*  6246 */     this.glCreateRenderbuffers = pointerBuffer.get(962);
/*  6247 */     this.glNamedRenderbufferStorage = pointerBuffer.get(963);
/*  6248 */     this.glNamedRenderbufferStorageMultisample = pointerBuffer.get(964);
/*  6249 */     this.glGetNamedRenderbufferParameteriv = pointerBuffer.get(965);
/*  6250 */     this.glCreateTextures = pointerBuffer.get(966);
/*  6251 */     this.glTextureBuffer = pointerBuffer.get(967);
/*  6252 */     this.glTextureBufferRange = pointerBuffer.get(968);
/*  6253 */     this.glTextureStorage1D = pointerBuffer.get(969);
/*  6254 */     this.glTextureStorage2D = pointerBuffer.get(970);
/*  6255 */     this.glTextureStorage3D = pointerBuffer.get(971);
/*  6256 */     this.glTextureStorage2DMultisample = pointerBuffer.get(972);
/*  6257 */     this.glTextureStorage3DMultisample = pointerBuffer.get(973);
/*  6258 */     this.glTextureSubImage1D = pointerBuffer.get(974);
/*  6259 */     this.glTextureSubImage2D = pointerBuffer.get(975);
/*  6260 */     this.glTextureSubImage3D = pointerBuffer.get(976);
/*  6261 */     this.glCompressedTextureSubImage1D = pointerBuffer.get(977);
/*  6262 */     this.glCompressedTextureSubImage2D = pointerBuffer.get(978);
/*  6263 */     this.glCompressedTextureSubImage3D = pointerBuffer.get(979);
/*  6264 */     this.glCopyTextureSubImage1D = pointerBuffer.get(980);
/*  6265 */     this.glCopyTextureSubImage2D = pointerBuffer.get(981);
/*  6266 */     this.glCopyTextureSubImage3D = pointerBuffer.get(982);
/*  6267 */     this.glTextureParameterf = pointerBuffer.get(983);
/*  6268 */     this.glTextureParameterfv = pointerBuffer.get(984);
/*  6269 */     this.glTextureParameteri = pointerBuffer.get(985);
/*  6270 */     this.glTextureParameterIiv = pointerBuffer.get(986);
/*  6271 */     this.glTextureParameterIuiv = pointerBuffer.get(987);
/*  6272 */     this.glTextureParameteriv = pointerBuffer.get(988);
/*  6273 */     this.glGenerateTextureMipmap = pointerBuffer.get(989);
/*  6274 */     this.glBindTextureUnit = pointerBuffer.get(990);
/*  6275 */     this.glGetTextureImage = pointerBuffer.get(991);
/*  6276 */     this.glGetCompressedTextureImage = pointerBuffer.get(992);
/*  6277 */     this.glGetTextureLevelParameterfv = pointerBuffer.get(993);
/*  6278 */     this.glGetTextureLevelParameteriv = pointerBuffer.get(994);
/*  6279 */     this.glGetTextureParameterfv = pointerBuffer.get(995);
/*  6280 */     this.glGetTextureParameterIiv = pointerBuffer.get(996);
/*  6281 */     this.glGetTextureParameterIuiv = pointerBuffer.get(997);
/*  6282 */     this.glGetTextureParameteriv = pointerBuffer.get(998);
/*  6283 */     this.glCreateVertexArrays = pointerBuffer.get(999);
/*  6284 */     this.glDisableVertexArrayAttrib = pointerBuffer.get(1000);
/*  6285 */     this.glEnableVertexArrayAttrib = pointerBuffer.get(1001);
/*  6286 */     this.glVertexArrayElementBuffer = pointerBuffer.get(1002);
/*  6287 */     this.glVertexArrayVertexBuffer = pointerBuffer.get(1003);
/*  6288 */     this.glVertexArrayVertexBuffers = pointerBuffer.get(1004);
/*  6289 */     this.glVertexArrayAttribFormat = pointerBuffer.get(1005);
/*  6290 */     this.glVertexArrayAttribIFormat = pointerBuffer.get(1006);
/*  6291 */     this.glVertexArrayAttribLFormat = pointerBuffer.get(1007);
/*  6292 */     this.glVertexArrayAttribBinding = pointerBuffer.get(1008);
/*  6293 */     this.glVertexArrayBindingDivisor = pointerBuffer.get(1009);
/*  6294 */     this.glGetVertexArrayiv = pointerBuffer.get(1010);
/*  6295 */     this.glGetVertexArrayIndexediv = pointerBuffer.get(1011);
/*  6296 */     this.glGetVertexArrayIndexed64iv = pointerBuffer.get(1012);
/*  6297 */     this.glCreateSamplers = pointerBuffer.get(1013);
/*  6298 */     this.glCreateProgramPipelines = pointerBuffer.get(1014);
/*  6299 */     this.glCreateQueries = pointerBuffer.get(1015);
/*  6300 */     this.glGetQueryBufferObjectiv = pointerBuffer.get(1016);
/*  6301 */     this.glGetQueryBufferObjectuiv = pointerBuffer.get(1017);
/*  6302 */     this.glGetQueryBufferObjecti64v = pointerBuffer.get(1018);
/*  6303 */     this.glGetQueryBufferObjectui64v = pointerBuffer.get(1019);
/*  6304 */     this.glMemoryBarrierByRegion = pointerBuffer.get(1020);
/*  6305 */     this.glGetTextureSubImage = pointerBuffer.get(1021);
/*  6306 */     this.glGetCompressedTextureSubImage = pointerBuffer.get(1022);
/*  6307 */     this.glTextureBarrier = pointerBuffer.get(1023);
/*  6308 */     this.glGetGraphicsResetStatus = pointerBuffer.get(1024);
/*  6309 */     this.glGetnMapdv = pointerBuffer.get(1025);
/*  6310 */     this.glGetnMapfv = pointerBuffer.get(1026);
/*  6311 */     this.glGetnMapiv = pointerBuffer.get(1027);
/*  6312 */     this.glGetnPixelMapfv = pointerBuffer.get(1028);
/*  6313 */     this.glGetnPixelMapuiv = pointerBuffer.get(1029);
/*  6314 */     this.glGetnPixelMapusv = pointerBuffer.get(1030);
/*  6315 */     this.glGetnPolygonStipple = pointerBuffer.get(1031);
/*  6316 */     this.glGetnTexImage = pointerBuffer.get(1032);
/*  6317 */     this.glReadnPixels = pointerBuffer.get(1033);
/*  6318 */     this.glGetnColorTable = pointerBuffer.get(1034);
/*  6319 */     this.glGetnConvolutionFilter = pointerBuffer.get(1035);
/*  6320 */     this.glGetnSeparableFilter = pointerBuffer.get(1036);
/*  6321 */     this.glGetnHistogram = pointerBuffer.get(1037);
/*  6322 */     this.glGetnMinmax = pointerBuffer.get(1038);
/*  6323 */     this.glGetnCompressedTexImage = pointerBuffer.get(1039);
/*  6324 */     this.glGetnUniformfv = pointerBuffer.get(1040);
/*  6325 */     this.glGetnUniformdv = pointerBuffer.get(1041);
/*  6326 */     this.glGetnUniformiv = pointerBuffer.get(1042);
/*  6327 */     this.glGetnUniformuiv = pointerBuffer.get(1043);
/*  6328 */     this.glMultiDrawArraysIndirectCount = pointerBuffer.get(1044);
/*  6329 */     this.glMultiDrawElementsIndirectCount = pointerBuffer.get(1045);
/*  6330 */     this.glPolygonOffsetClamp = pointerBuffer.get(1046);
/*  6331 */     this.glSpecializeShader = pointerBuffer.get(1047);
/*  6332 */     this.glDebugMessageEnableAMD = pointerBuffer.get(1048);
/*  6333 */     this.glDebugMessageInsertAMD = pointerBuffer.get(1049);
/*  6334 */     this.glDebugMessageCallbackAMD = pointerBuffer.get(1050);
/*  6335 */     this.glGetDebugMessageLogAMD = pointerBuffer.get(1051);
/*  6336 */     this.glBlendFuncIndexedAMD = pointerBuffer.get(1052);
/*  6337 */     this.glBlendFuncSeparateIndexedAMD = pointerBuffer.get(1053);
/*  6338 */     this.glBlendEquationIndexedAMD = pointerBuffer.get(1054);
/*  6339 */     this.glBlendEquationSeparateIndexedAMD = pointerBuffer.get(1055);
/*  6340 */     this.glRenderbufferStorageMultisampleAdvancedAMD = pointerBuffer.get(1056);
/*  6341 */     this.glNamedRenderbufferStorageMultisampleAdvancedAMD = pointerBuffer.get(1057);
/*  6342 */     this.glUniform1i64NV = pointerBuffer.get(1058);
/*  6343 */     this.glUniform2i64NV = pointerBuffer.get(1059);
/*  6344 */     this.glUniform3i64NV = pointerBuffer.get(1060);
/*  6345 */     this.glUniform4i64NV = pointerBuffer.get(1061);
/*  6346 */     this.glUniform1i64vNV = pointerBuffer.get(1062);
/*  6347 */     this.glUniform2i64vNV = pointerBuffer.get(1063);
/*  6348 */     this.glUniform3i64vNV = pointerBuffer.get(1064);
/*  6349 */     this.glUniform4i64vNV = pointerBuffer.get(1065);
/*  6350 */     this.glUniform1ui64NV = pointerBuffer.get(1066);
/*  6351 */     this.glUniform2ui64NV = pointerBuffer.get(1067);
/*  6352 */     this.glUniform3ui64NV = pointerBuffer.get(1068);
/*  6353 */     this.glUniform4ui64NV = pointerBuffer.get(1069);
/*  6354 */     this.glUniform1ui64vNV = pointerBuffer.get(1070);
/*  6355 */     this.glUniform2ui64vNV = pointerBuffer.get(1071);
/*  6356 */     this.glUniform3ui64vNV = pointerBuffer.get(1072);
/*  6357 */     this.glUniform4ui64vNV = pointerBuffer.get(1073);
/*  6358 */     this.glGetUniformi64vNV = pointerBuffer.get(1074);
/*  6359 */     this.glGetUniformui64vNV = pointerBuffer.get(1075);
/*  6360 */     this.glProgramUniform1i64NV = pointerBuffer.get(1076);
/*  6361 */     this.glProgramUniform2i64NV = pointerBuffer.get(1077);
/*  6362 */     this.glProgramUniform3i64NV = pointerBuffer.get(1078);
/*  6363 */     this.glProgramUniform4i64NV = pointerBuffer.get(1079);
/*  6364 */     this.glProgramUniform1i64vNV = pointerBuffer.get(1080);
/*  6365 */     this.glProgramUniform2i64vNV = pointerBuffer.get(1081);
/*  6366 */     this.glProgramUniform3i64vNV = pointerBuffer.get(1082);
/*  6367 */     this.glProgramUniform4i64vNV = pointerBuffer.get(1083);
/*  6368 */     this.glProgramUniform1ui64NV = pointerBuffer.get(1084);
/*  6369 */     this.glProgramUniform2ui64NV = pointerBuffer.get(1085);
/*  6370 */     this.glProgramUniform3ui64NV = pointerBuffer.get(1086);
/*  6371 */     this.glProgramUniform4ui64NV = pointerBuffer.get(1087);
/*  6372 */     this.glProgramUniform1ui64vNV = pointerBuffer.get(1088);
/*  6373 */     this.glProgramUniform2ui64vNV = pointerBuffer.get(1089);
/*  6374 */     this.glProgramUniform3ui64vNV = pointerBuffer.get(1090);
/*  6375 */     this.glProgramUniform4ui64vNV = pointerBuffer.get(1091);
/*  6376 */     this.glVertexAttribParameteriAMD = pointerBuffer.get(1092);
/*  6377 */     this.glQueryObjectParameteruiAMD = pointerBuffer.get(1093);
/*  6378 */     this.glGetPerfMonitorGroupsAMD = pointerBuffer.get(1094);
/*  6379 */     this.glGetPerfMonitorCountersAMD = pointerBuffer.get(1095);
/*  6380 */     this.glGetPerfMonitorGroupStringAMD = pointerBuffer.get(1096);
/*  6381 */     this.glGetPerfMonitorCounterStringAMD = pointerBuffer.get(1097);
/*  6382 */     this.glGetPerfMonitorCounterInfoAMD = pointerBuffer.get(1098);
/*  6383 */     this.glGenPerfMonitorsAMD = pointerBuffer.get(1099);
/*  6384 */     this.glDeletePerfMonitorsAMD = pointerBuffer.get(1100);
/*  6385 */     this.glSelectPerfMonitorCountersAMD = pointerBuffer.get(1101);
/*  6386 */     this.glBeginPerfMonitorAMD = pointerBuffer.get(1102);
/*  6387 */     this.glEndPerfMonitorAMD = pointerBuffer.get(1103);
/*  6388 */     this.glGetPerfMonitorCounterDataAMD = pointerBuffer.get(1104);
/*  6389 */     this.glSetMultisamplefvAMD = pointerBuffer.get(1105);
/*  6390 */     this.glTexStorageSparseAMD = pointerBuffer.get(1106);
/*  6391 */     this.glTextureStorageSparseAMD = pointerBuffer.get(1107);
/*  6392 */     this.glStencilOpValueAMD = pointerBuffer.get(1108);
/*  6393 */     this.glTessellationFactorAMD = pointerBuffer.get(1109);
/*  6394 */     this.glTessellationModeAMD = pointerBuffer.get(1110);
/*  6395 */     this.glGetTextureHandleARB = pointerBuffer.get(1111);
/*  6396 */     this.glGetTextureSamplerHandleARB = pointerBuffer.get(1112);
/*  6397 */     this.glMakeTextureHandleResidentARB = pointerBuffer.get(1113);
/*  6398 */     this.glMakeTextureHandleNonResidentARB = pointerBuffer.get(1114);
/*  6399 */     this.glGetImageHandleARB = pointerBuffer.get(1115);
/*  6400 */     this.glMakeImageHandleResidentARB = pointerBuffer.get(1116);
/*  6401 */     this.glMakeImageHandleNonResidentARB = pointerBuffer.get(1117);
/*  6402 */     this.glUniformHandleui64ARB = pointerBuffer.get(1118);
/*  6403 */     this.glUniformHandleui64vARB = pointerBuffer.get(1119);
/*  6404 */     this.glProgramUniformHandleui64ARB = pointerBuffer.get(1120);
/*  6405 */     this.glProgramUniformHandleui64vARB = pointerBuffer.get(1121);
/*  6406 */     this.glIsTextureHandleResidentARB = pointerBuffer.get(1122);
/*  6407 */     this.glIsImageHandleResidentARB = pointerBuffer.get(1123);
/*  6408 */     this.glVertexAttribL1ui64ARB = pointerBuffer.get(1124);
/*  6409 */     this.glVertexAttribL1ui64vARB = pointerBuffer.get(1125);
/*  6410 */     this.glGetVertexAttribLui64vARB = pointerBuffer.get(1126);
/*  6411 */     this.glNamedBufferStorageEXT = pointerBuffer.get(1127);
/*  6412 */     this.glCreateSyncFromCLeventARB = pointerBuffer.get(1128);
/*  6413 */     this.glClearNamedBufferDataEXT = pointerBuffer.get(1129);
/*  6414 */     this.glClearNamedBufferSubDataEXT = pointerBuffer.get(1130);
/*  6415 */     this.glClampColorARB = pointerBuffer.get(1131);
/*  6416 */     this.glDispatchComputeGroupSizeARB = pointerBuffer.get(1132);
/*  6417 */     this.glDebugMessageControlARB = pointerBuffer.get(1133);
/*  6418 */     this.glDebugMessageInsertARB = pointerBuffer.get(1134);
/*  6419 */     this.glDebugMessageCallbackARB = pointerBuffer.get(1135);
/*  6420 */     this.glGetDebugMessageLogARB = pointerBuffer.get(1136);
/*  6421 */     this.glDrawBuffersARB = pointerBuffer.get(1137);
/*  6422 */     this.glBlendEquationiARB = pointerBuffer.get(1138);
/*  6423 */     this.glBlendEquationSeparateiARB = pointerBuffer.get(1139);
/*  6424 */     this.glBlendFunciARB = pointerBuffer.get(1140);
/*  6425 */     this.glBlendFuncSeparateiARB = pointerBuffer.get(1141);
/*  6426 */     this.glDrawArraysInstancedARB = pointerBuffer.get(1142);
/*  6427 */     this.glDrawElementsInstancedARB = pointerBuffer.get(1143);
/*  6428 */     this.glPrimitiveBoundingBoxARB = pointerBuffer.get(1144);
/*  6429 */     this.glNamedFramebufferParameteriEXT = pointerBuffer.get(1145);
/*  6430 */     this.glGetNamedFramebufferParameterivEXT = pointerBuffer.get(1146);
/*  6431 */     this.glProgramParameteriARB = pointerBuffer.get(1147);
/*  6432 */     this.glFramebufferTextureARB = pointerBuffer.get(1148);
/*  6433 */     this.glFramebufferTextureLayerARB = pointerBuffer.get(1149);
/*  6434 */     this.glFramebufferTextureFaceARB = pointerBuffer.get(1150);
/*  6435 */     this.glSpecializeShaderARB = pointerBuffer.get(1151);
/*  6436 */     this.glProgramUniform1dEXT = pointerBuffer.get(1152);
/*  6437 */     this.glProgramUniform2dEXT = pointerBuffer.get(1153);
/*  6438 */     this.glProgramUniform3dEXT = pointerBuffer.get(1154);
/*  6439 */     this.glProgramUniform4dEXT = pointerBuffer.get(1155);
/*  6440 */     this.glProgramUniform1dvEXT = pointerBuffer.get(1156);
/*  6441 */     this.glProgramUniform2dvEXT = pointerBuffer.get(1157);
/*  6442 */     this.glProgramUniform3dvEXT = pointerBuffer.get(1158);
/*  6443 */     this.glProgramUniform4dvEXT = pointerBuffer.get(1159);
/*  6444 */     this.glProgramUniformMatrix2dvEXT = pointerBuffer.get(1160);
/*  6445 */     this.glProgramUniformMatrix3dvEXT = pointerBuffer.get(1161);
/*  6446 */     this.glProgramUniformMatrix4dvEXT = pointerBuffer.get(1162);
/*  6447 */     this.glProgramUniformMatrix2x3dvEXT = pointerBuffer.get(1163);
/*  6448 */     this.glProgramUniformMatrix2x4dvEXT = pointerBuffer.get(1164);
/*  6449 */     this.glProgramUniformMatrix3x2dvEXT = pointerBuffer.get(1165);
/*  6450 */     this.glProgramUniformMatrix3x4dvEXT = pointerBuffer.get(1166);
/*  6451 */     this.glProgramUniformMatrix4x2dvEXT = pointerBuffer.get(1167);
/*  6452 */     this.glProgramUniformMatrix4x3dvEXT = pointerBuffer.get(1168);
/*  6453 */     this.glUniform1i64ARB = pointerBuffer.get(1169);
/*  6454 */     this.glUniform1i64vARB = pointerBuffer.get(1170);
/*  6455 */     this.glProgramUniform1i64ARB = pointerBuffer.get(1171);
/*  6456 */     this.glProgramUniform1i64vARB = pointerBuffer.get(1172);
/*  6457 */     this.glUniform2i64ARB = pointerBuffer.get(1173);
/*  6458 */     this.glUniform2i64vARB = pointerBuffer.get(1174);
/*  6459 */     this.glProgramUniform2i64ARB = pointerBuffer.get(1175);
/*  6460 */     this.glProgramUniform2i64vARB = pointerBuffer.get(1176);
/*  6461 */     this.glUniform3i64ARB = pointerBuffer.get(1177);
/*  6462 */     this.glUniform3i64vARB = pointerBuffer.get(1178);
/*  6463 */     this.glProgramUniform3i64ARB = pointerBuffer.get(1179);
/*  6464 */     this.glProgramUniform3i64vARB = pointerBuffer.get(1180);
/*  6465 */     this.glUniform4i64ARB = pointerBuffer.get(1181);
/*  6466 */     this.glUniform4i64vARB = pointerBuffer.get(1182);
/*  6467 */     this.glProgramUniform4i64ARB = pointerBuffer.get(1183);
/*  6468 */     this.glProgramUniform4i64vARB = pointerBuffer.get(1184);
/*  6469 */     this.glUniform1ui64ARB = pointerBuffer.get(1185);
/*  6470 */     this.glUniform1ui64vARB = pointerBuffer.get(1186);
/*  6471 */     this.glProgramUniform1ui64ARB = pointerBuffer.get(1187);
/*  6472 */     this.glProgramUniform1ui64vARB = pointerBuffer.get(1188);
/*  6473 */     this.glUniform2ui64ARB = pointerBuffer.get(1189);
/*  6474 */     this.glUniform2ui64vARB = pointerBuffer.get(1190);
/*  6475 */     this.glProgramUniform2ui64ARB = pointerBuffer.get(1191);
/*  6476 */     this.glProgramUniform2ui64vARB = pointerBuffer.get(1192);
/*  6477 */     this.glUniform3ui64ARB = pointerBuffer.get(1193);
/*  6478 */     this.glUniform3ui64vARB = pointerBuffer.get(1194);
/*  6479 */     this.glProgramUniform3ui64ARB = pointerBuffer.get(1195);
/*  6480 */     this.glProgramUniform3ui64vARB = pointerBuffer.get(1196);
/*  6481 */     this.glUniform4ui64ARB = pointerBuffer.get(1197);
/*  6482 */     this.glUniform4ui64vARB = pointerBuffer.get(1198);
/*  6483 */     this.glProgramUniform4ui64ARB = pointerBuffer.get(1199);
/*  6484 */     this.glProgramUniform4ui64vARB = pointerBuffer.get(1200);
/*  6485 */     this.glGetUniformi64vARB = pointerBuffer.get(1201);
/*  6486 */     this.glGetUniformui64vARB = pointerBuffer.get(1202);
/*  6487 */     this.glGetnUniformi64vARB = pointerBuffer.get(1203);
/*  6488 */     this.glGetnUniformui64vARB = pointerBuffer.get(1204);
/*  6489 */     this.glColorTable = pointerBuffer.get(1205);
/*  6490 */     this.glCopyColorTable = pointerBuffer.get(1206);
/*  6491 */     this.glColorTableParameteriv = pointerBuffer.get(1207);
/*  6492 */     this.glColorTableParameterfv = pointerBuffer.get(1208);
/*  6493 */     this.glGetColorTable = pointerBuffer.get(1209);
/*  6494 */     this.glGetColorTableParameteriv = pointerBuffer.get(1210);
/*  6495 */     this.glGetColorTableParameterfv = pointerBuffer.get(1211);
/*  6496 */     this.glColorSubTable = pointerBuffer.get(1212);
/*  6497 */     this.glCopyColorSubTable = pointerBuffer.get(1213);
/*  6498 */     this.glConvolutionFilter1D = pointerBuffer.get(1214);
/*  6499 */     this.glConvolutionFilter2D = pointerBuffer.get(1215);
/*  6500 */     this.glCopyConvolutionFilter1D = pointerBuffer.get(1216);
/*  6501 */     this.glCopyConvolutionFilter2D = pointerBuffer.get(1217);
/*  6502 */     this.glGetConvolutionFilter = pointerBuffer.get(1218);
/*  6503 */     this.glSeparableFilter2D = pointerBuffer.get(1219);
/*  6504 */     this.glGetSeparableFilter = pointerBuffer.get(1220);
/*  6505 */     this.glConvolutionParameteri = pointerBuffer.get(1221);
/*  6506 */     this.glConvolutionParameteriv = pointerBuffer.get(1222);
/*  6507 */     this.glConvolutionParameterf = pointerBuffer.get(1223);
/*  6508 */     this.glConvolutionParameterfv = pointerBuffer.get(1224);
/*  6509 */     this.glGetConvolutionParameteriv = pointerBuffer.get(1225);
/*  6510 */     this.glGetConvolutionParameterfv = pointerBuffer.get(1226);
/*  6511 */     this.glHistogram = pointerBuffer.get(1227);
/*  6512 */     this.glResetHistogram = pointerBuffer.get(1228);
/*  6513 */     this.glGetHistogram = pointerBuffer.get(1229);
/*  6514 */     this.glGetHistogramParameteriv = pointerBuffer.get(1230);
/*  6515 */     this.glGetHistogramParameterfv = pointerBuffer.get(1231);
/*  6516 */     this.glMinmax = pointerBuffer.get(1232);
/*  6517 */     this.glResetMinmax = pointerBuffer.get(1233);
/*  6518 */     this.glGetMinmax = pointerBuffer.get(1234);
/*  6519 */     this.glGetMinmaxParameteriv = pointerBuffer.get(1235);
/*  6520 */     this.glGetMinmaxParameterfv = pointerBuffer.get(1236);
/*  6521 */     this.glMultiDrawArraysIndirectCountARB = pointerBuffer.get(1237);
/*  6522 */     this.glMultiDrawElementsIndirectCountARB = pointerBuffer.get(1238);
/*  6523 */     this.glVertexAttribDivisorARB = pointerBuffer.get(1239);
/*  6524 */     this.glVertexArrayVertexAttribDivisorEXT = pointerBuffer.get(1240);
/*  6525 */     this.glCurrentPaletteMatrixARB = pointerBuffer.get(1241);
/*  6526 */     this.glMatrixIndexuivARB = pointerBuffer.get(1242);
/*  6527 */     this.glMatrixIndexubvARB = pointerBuffer.get(1243);
/*  6528 */     this.glMatrixIndexusvARB = pointerBuffer.get(1244);
/*  6529 */     this.glMatrixIndexPointerARB = pointerBuffer.get(1245);
/*  6530 */     this.glSampleCoverageARB = pointerBuffer.get(1246);
/*  6531 */     this.glActiveTextureARB = pointerBuffer.get(1247);
/*  6532 */     this.glClientActiveTextureARB = pointerBuffer.get(1248);
/*  6533 */     this.glMultiTexCoord1fARB = pointerBuffer.get(1249);
/*  6534 */     this.glMultiTexCoord1sARB = pointerBuffer.get(1250);
/*  6535 */     this.glMultiTexCoord1iARB = pointerBuffer.get(1251);
/*  6536 */     this.glMultiTexCoord1dARB = pointerBuffer.get(1252);
/*  6537 */     this.glMultiTexCoord1fvARB = pointerBuffer.get(1253);
/*  6538 */     this.glMultiTexCoord1svARB = pointerBuffer.get(1254);
/*  6539 */     this.glMultiTexCoord1ivARB = pointerBuffer.get(1255);
/*  6540 */     this.glMultiTexCoord1dvARB = pointerBuffer.get(1256);
/*  6541 */     this.glMultiTexCoord2fARB = pointerBuffer.get(1257);
/*  6542 */     this.glMultiTexCoord2sARB = pointerBuffer.get(1258);
/*  6543 */     this.glMultiTexCoord2iARB = pointerBuffer.get(1259);
/*  6544 */     this.glMultiTexCoord2dARB = pointerBuffer.get(1260);
/*  6545 */     this.glMultiTexCoord2fvARB = pointerBuffer.get(1261);
/*  6546 */     this.glMultiTexCoord2svARB = pointerBuffer.get(1262);
/*  6547 */     this.glMultiTexCoord2ivARB = pointerBuffer.get(1263);
/*  6548 */     this.glMultiTexCoord2dvARB = pointerBuffer.get(1264);
/*  6549 */     this.glMultiTexCoord3fARB = pointerBuffer.get(1265);
/*  6550 */     this.glMultiTexCoord3sARB = pointerBuffer.get(1266);
/*  6551 */     this.glMultiTexCoord3iARB = pointerBuffer.get(1267);
/*  6552 */     this.glMultiTexCoord3dARB = pointerBuffer.get(1268);
/*  6553 */     this.glMultiTexCoord3fvARB = pointerBuffer.get(1269);
/*  6554 */     this.glMultiTexCoord3svARB = pointerBuffer.get(1270);
/*  6555 */     this.glMultiTexCoord3ivARB = pointerBuffer.get(1271);
/*  6556 */     this.glMultiTexCoord3dvARB = pointerBuffer.get(1272);
/*  6557 */     this.glMultiTexCoord4fARB = pointerBuffer.get(1273);
/*  6558 */     this.glMultiTexCoord4sARB = pointerBuffer.get(1274);
/*  6559 */     this.glMultiTexCoord4iARB = pointerBuffer.get(1275);
/*  6560 */     this.glMultiTexCoord4dARB = pointerBuffer.get(1276);
/*  6561 */     this.glMultiTexCoord4fvARB = pointerBuffer.get(1277);
/*  6562 */     this.glMultiTexCoord4svARB = pointerBuffer.get(1278);
/*  6563 */     this.glMultiTexCoord4ivARB = pointerBuffer.get(1279);
/*  6564 */     this.glMultiTexCoord4dvARB = pointerBuffer.get(1280);
/*  6565 */     this.glGenQueriesARB = pointerBuffer.get(1281);
/*  6566 */     this.glDeleteQueriesARB = pointerBuffer.get(1282);
/*  6567 */     this.glIsQueryARB = pointerBuffer.get(1283);
/*  6568 */     this.glBeginQueryARB = pointerBuffer.get(1284);
/*  6569 */     this.glEndQueryARB = pointerBuffer.get(1285);
/*  6570 */     this.glGetQueryivARB = pointerBuffer.get(1286);
/*  6571 */     this.glGetQueryObjectivARB = pointerBuffer.get(1287);
/*  6572 */     this.glGetQueryObjectuivARB = pointerBuffer.get(1288);
/*  6573 */     this.glMaxShaderCompilerThreadsARB = pointerBuffer.get(1289);
/*  6574 */     this.glPointParameterfARB = pointerBuffer.get(1290);
/*  6575 */     this.glPointParameterfvARB = pointerBuffer.get(1291);
/*  6576 */     this.glGetGraphicsResetStatusARB = pointerBuffer.get(1292);
/*  6577 */     this.glGetnMapdvARB = pointerBuffer.get(1293);
/*  6578 */     this.glGetnMapfvARB = pointerBuffer.get(1294);
/*  6579 */     this.glGetnMapivARB = pointerBuffer.get(1295);
/*  6580 */     this.glGetnPixelMapfvARB = pointerBuffer.get(1296);
/*  6581 */     this.glGetnPixelMapuivARB = pointerBuffer.get(1297);
/*  6582 */     this.glGetnPixelMapusvARB = pointerBuffer.get(1298);
/*  6583 */     this.glGetnPolygonStippleARB = pointerBuffer.get(1299);
/*  6584 */     this.glGetnTexImageARB = pointerBuffer.get(1300);
/*  6585 */     this.glReadnPixelsARB = pointerBuffer.get(1301);
/*  6586 */     this.glGetnColorTableARB = pointerBuffer.get(1302);
/*  6587 */     this.glGetnConvolutionFilterARB = pointerBuffer.get(1303);
/*  6588 */     this.glGetnSeparableFilterARB = pointerBuffer.get(1304);
/*  6589 */     this.glGetnHistogramARB = pointerBuffer.get(1305);
/*  6590 */     this.glGetnMinmaxARB = pointerBuffer.get(1306);
/*  6591 */     this.glGetnCompressedTexImageARB = pointerBuffer.get(1307);
/*  6592 */     this.glGetnUniformfvARB = pointerBuffer.get(1308);
/*  6593 */     this.glGetnUniformivARB = pointerBuffer.get(1309);
/*  6594 */     this.glGetnUniformuivARB = pointerBuffer.get(1310);
/*  6595 */     this.glGetnUniformdvARB = pointerBuffer.get(1311);
/*  6596 */     this.glFramebufferSampleLocationsfvARB = pointerBuffer.get(1312);
/*  6597 */     this.glNamedFramebufferSampleLocationsfvARB = pointerBuffer.get(1313);
/*  6598 */     this.glEvaluateDepthValuesARB = pointerBuffer.get(1314);
/*  6599 */     this.glMinSampleShadingARB = pointerBuffer.get(1315);
/*  6600 */     this.glDeleteObjectARB = pointerBuffer.get(1316);
/*  6601 */     this.glGetHandleARB = pointerBuffer.get(1317);
/*  6602 */     this.glDetachObjectARB = pointerBuffer.get(1318);
/*  6603 */     this.glCreateShaderObjectARB = pointerBuffer.get(1319);
/*  6604 */     this.glShaderSourceARB = pointerBuffer.get(1320);
/*  6605 */     this.glCompileShaderARB = pointerBuffer.get(1321);
/*  6606 */     this.glCreateProgramObjectARB = pointerBuffer.get(1322);
/*  6607 */     this.glAttachObjectARB = pointerBuffer.get(1323);
/*  6608 */     this.glLinkProgramARB = pointerBuffer.get(1324);
/*  6609 */     this.glUseProgramObjectARB = pointerBuffer.get(1325);
/*  6610 */     this.glValidateProgramARB = pointerBuffer.get(1326);
/*  6611 */     this.glUniform1fARB = pointerBuffer.get(1327);
/*  6612 */     this.glUniform2fARB = pointerBuffer.get(1328);
/*  6613 */     this.glUniform3fARB = pointerBuffer.get(1329);
/*  6614 */     this.glUniform4fARB = pointerBuffer.get(1330);
/*  6615 */     this.glUniform1iARB = pointerBuffer.get(1331);
/*  6616 */     this.glUniform2iARB = pointerBuffer.get(1332);
/*  6617 */     this.glUniform3iARB = pointerBuffer.get(1333);
/*  6618 */     this.glUniform4iARB = pointerBuffer.get(1334);
/*  6619 */     this.glUniform1fvARB = pointerBuffer.get(1335);
/*  6620 */     this.glUniform2fvARB = pointerBuffer.get(1336);
/*  6621 */     this.glUniform3fvARB = pointerBuffer.get(1337);
/*  6622 */     this.glUniform4fvARB = pointerBuffer.get(1338);
/*  6623 */     this.glUniform1ivARB = pointerBuffer.get(1339);
/*  6624 */     this.glUniform2ivARB = pointerBuffer.get(1340);
/*  6625 */     this.glUniform3ivARB = pointerBuffer.get(1341);
/*  6626 */     this.glUniform4ivARB = pointerBuffer.get(1342);
/*  6627 */     this.glUniformMatrix2fvARB = pointerBuffer.get(1343);
/*  6628 */     this.glUniformMatrix3fvARB = pointerBuffer.get(1344);
/*  6629 */     this.glUniformMatrix4fvARB = pointerBuffer.get(1345);
/*  6630 */     this.glGetObjectParameterfvARB = pointerBuffer.get(1346);
/*  6631 */     this.glGetObjectParameterivARB = pointerBuffer.get(1347);
/*  6632 */     this.glGetInfoLogARB = pointerBuffer.get(1348);
/*  6633 */     this.glGetAttachedObjectsARB = pointerBuffer.get(1349);
/*  6634 */     this.glGetUniformLocationARB = pointerBuffer.get(1350);
/*  6635 */     this.glGetActiveUniformARB = pointerBuffer.get(1351);
/*  6636 */     this.glGetUniformfvARB = pointerBuffer.get(1352);
/*  6637 */     this.glGetUniformivARB = pointerBuffer.get(1353);
/*  6638 */     this.glGetShaderSourceARB = pointerBuffer.get(1354);
/*  6639 */     this.glNamedStringARB = pointerBuffer.get(1355);
/*  6640 */     this.glDeleteNamedStringARB = pointerBuffer.get(1356);
/*  6641 */     this.glCompileShaderIncludeARB = pointerBuffer.get(1357);
/*  6642 */     this.glIsNamedStringARB = pointerBuffer.get(1358);
/*  6643 */     this.glGetNamedStringARB = pointerBuffer.get(1359);
/*  6644 */     this.glGetNamedStringivARB = pointerBuffer.get(1360);
/*  6645 */     this.glBufferPageCommitmentARB = pointerBuffer.get(1361);
/*  6646 */     this.glNamedBufferPageCommitmentEXT = pointerBuffer.get(1362);
/*  6647 */     this.glNamedBufferPageCommitmentARB = pointerBuffer.get(1363);
/*  6648 */     this.glTexPageCommitmentARB = pointerBuffer.get(1364);
/*  6649 */     this.glTexturePageCommitmentEXT = pointerBuffer.get(1365);
/*  6650 */     this.glTexBufferARB = pointerBuffer.get(1366);
/*  6651 */     this.glTextureBufferRangeEXT = pointerBuffer.get(1367);
/*  6652 */     this.glCompressedTexImage3DARB = pointerBuffer.get(1368);
/*  6653 */     this.glCompressedTexImage2DARB = pointerBuffer.get(1369);
/*  6654 */     this.glCompressedTexImage1DARB = pointerBuffer.get(1370);
/*  6655 */     this.glCompressedTexSubImage3DARB = pointerBuffer.get(1371);
/*  6656 */     this.glCompressedTexSubImage2DARB = pointerBuffer.get(1372);
/*  6657 */     this.glCompressedTexSubImage1DARB = pointerBuffer.get(1373);
/*  6658 */     this.glGetCompressedTexImageARB = pointerBuffer.get(1374);
/*  6659 */     this.glTextureStorage1DEXT = pointerBuffer.get(1375);
/*  6660 */     this.glTextureStorage2DEXT = pointerBuffer.get(1376);
/*  6661 */     this.glTextureStorage3DEXT = pointerBuffer.get(1377);
/*  6662 */     this.glTextureStorage2DMultisampleEXT = pointerBuffer.get(1378);
/*  6663 */     this.glTextureStorage3DMultisampleEXT = pointerBuffer.get(1379);
/*  6664 */     this.glLoadTransposeMatrixfARB = pointerBuffer.get(1380);
/*  6665 */     this.glLoadTransposeMatrixdARB = pointerBuffer.get(1381);
/*  6666 */     this.glMultTransposeMatrixfARB = pointerBuffer.get(1382);
/*  6667 */     this.glMultTransposeMatrixdARB = pointerBuffer.get(1383);
/*  6668 */     this.glVertexArrayVertexAttribLOffsetEXT = pointerBuffer.get(1384);
/*  6669 */     this.glVertexArrayBindVertexBufferEXT = pointerBuffer.get(1385);
/*  6670 */     this.glVertexArrayVertexAttribFormatEXT = pointerBuffer.get(1386);
/*  6671 */     this.glVertexArrayVertexAttribIFormatEXT = pointerBuffer.get(1387);
/*  6672 */     this.glVertexArrayVertexAttribLFormatEXT = pointerBuffer.get(1388);
/*  6673 */     this.glVertexArrayVertexAttribBindingEXT = pointerBuffer.get(1389);
/*  6674 */     this.glVertexArrayVertexBindingDivisorEXT = pointerBuffer.get(1390);
/*  6675 */     this.glWeightfvARB = pointerBuffer.get(1391);
/*  6676 */     this.glWeightbvARB = pointerBuffer.get(1392);
/*  6677 */     this.glWeightubvARB = pointerBuffer.get(1393);
/*  6678 */     this.glWeightsvARB = pointerBuffer.get(1394);
/*  6679 */     this.glWeightusvARB = pointerBuffer.get(1395);
/*  6680 */     this.glWeightivARB = pointerBuffer.get(1396);
/*  6681 */     this.glWeightuivARB = pointerBuffer.get(1397);
/*  6682 */     this.glWeightdvARB = pointerBuffer.get(1398);
/*  6683 */     this.glWeightPointerARB = pointerBuffer.get(1399);
/*  6684 */     this.glVertexBlendARB = pointerBuffer.get(1400);
/*  6685 */     this.glBindBufferARB = pointerBuffer.get(1401);
/*  6686 */     this.glDeleteBuffersARB = pointerBuffer.get(1402);
/*  6687 */     this.glGenBuffersARB = pointerBuffer.get(1403);
/*  6688 */     this.glIsBufferARB = pointerBuffer.get(1404);
/*  6689 */     this.glBufferDataARB = pointerBuffer.get(1405);
/*  6690 */     this.glBufferSubDataARB = pointerBuffer.get(1406);
/*  6691 */     this.glGetBufferSubDataARB = pointerBuffer.get(1407);
/*  6692 */     this.glMapBufferARB = pointerBuffer.get(1408);
/*  6693 */     this.glUnmapBufferARB = pointerBuffer.get(1409);
/*  6694 */     this.glGetBufferParameterivARB = pointerBuffer.get(1410);
/*  6695 */     this.glGetBufferPointervARB = pointerBuffer.get(1411);
/*  6696 */     this.glVertexAttrib1sARB = pointerBuffer.get(1412);
/*  6697 */     this.glVertexAttrib1fARB = pointerBuffer.get(1413);
/*  6698 */     this.glVertexAttrib1dARB = pointerBuffer.get(1414);
/*  6699 */     this.glVertexAttrib2sARB = pointerBuffer.get(1415);
/*  6700 */     this.glVertexAttrib2fARB = pointerBuffer.get(1416);
/*  6701 */     this.glVertexAttrib2dARB = pointerBuffer.get(1417);
/*  6702 */     this.glVertexAttrib3sARB = pointerBuffer.get(1418);
/*  6703 */     this.glVertexAttrib3fARB = pointerBuffer.get(1419);
/*  6704 */     this.glVertexAttrib3dARB = pointerBuffer.get(1420);
/*  6705 */     this.glVertexAttrib4sARB = pointerBuffer.get(1421);
/*  6706 */     this.glVertexAttrib4fARB = pointerBuffer.get(1422);
/*  6707 */     this.glVertexAttrib4dARB = pointerBuffer.get(1423);
/*  6708 */     this.glVertexAttrib4NubARB = pointerBuffer.get(1424);
/*  6709 */     this.glVertexAttrib1svARB = pointerBuffer.get(1425);
/*  6710 */     this.glVertexAttrib1fvARB = pointerBuffer.get(1426);
/*  6711 */     this.glVertexAttrib1dvARB = pointerBuffer.get(1427);
/*  6712 */     this.glVertexAttrib2svARB = pointerBuffer.get(1428);
/*  6713 */     this.glVertexAttrib2fvARB = pointerBuffer.get(1429);
/*  6714 */     this.glVertexAttrib2dvARB = pointerBuffer.get(1430);
/*  6715 */     this.glVertexAttrib3svARB = pointerBuffer.get(1431);
/*  6716 */     this.glVertexAttrib3fvARB = pointerBuffer.get(1432);
/*  6717 */     this.glVertexAttrib3dvARB = pointerBuffer.get(1433);
/*  6718 */     this.glVertexAttrib4fvARB = pointerBuffer.get(1434);
/*  6719 */     this.glVertexAttrib4bvARB = pointerBuffer.get(1435);
/*  6720 */     this.glVertexAttrib4svARB = pointerBuffer.get(1436);
/*  6721 */     this.glVertexAttrib4ivARB = pointerBuffer.get(1437);
/*  6722 */     this.glVertexAttrib4ubvARB = pointerBuffer.get(1438);
/*  6723 */     this.glVertexAttrib4usvARB = pointerBuffer.get(1439);
/*  6724 */     this.glVertexAttrib4uivARB = pointerBuffer.get(1440);
/*  6725 */     this.glVertexAttrib4dvARB = pointerBuffer.get(1441);
/*  6726 */     this.glVertexAttrib4NbvARB = pointerBuffer.get(1442);
/*  6727 */     this.glVertexAttrib4NsvARB = pointerBuffer.get(1443);
/*  6728 */     this.glVertexAttrib4NivARB = pointerBuffer.get(1444);
/*  6729 */     this.glVertexAttrib4NubvARB = pointerBuffer.get(1445);
/*  6730 */     this.glVertexAttrib4NusvARB = pointerBuffer.get(1446);
/*  6731 */     this.glVertexAttrib4NuivARB = pointerBuffer.get(1447);
/*  6732 */     this.glVertexAttribPointerARB = pointerBuffer.get(1448);
/*  6733 */     this.glEnableVertexAttribArrayARB = pointerBuffer.get(1449);
/*  6734 */     this.glDisableVertexAttribArrayARB = pointerBuffer.get(1450);
/*  6735 */     this.glProgramStringARB = pointerBuffer.get(1451);
/*  6736 */     this.glBindProgramARB = pointerBuffer.get(1452);
/*  6737 */     this.glDeleteProgramsARB = pointerBuffer.get(1453);
/*  6738 */     this.glGenProgramsARB = pointerBuffer.get(1454);
/*  6739 */     this.glProgramEnvParameter4dARB = pointerBuffer.get(1455);
/*  6740 */     this.glProgramEnvParameter4dvARB = pointerBuffer.get(1456);
/*  6741 */     this.glProgramEnvParameter4fARB = pointerBuffer.get(1457);
/*  6742 */     this.glProgramEnvParameter4fvARB = pointerBuffer.get(1458);
/*  6743 */     this.glProgramLocalParameter4dARB = pointerBuffer.get(1459);
/*  6744 */     this.glProgramLocalParameter4dvARB = pointerBuffer.get(1460);
/*  6745 */     this.glProgramLocalParameter4fARB = pointerBuffer.get(1461);
/*  6746 */     this.glProgramLocalParameter4fvARB = pointerBuffer.get(1462);
/*  6747 */     this.glGetProgramEnvParameterfvARB = pointerBuffer.get(1463);
/*  6748 */     this.glGetProgramEnvParameterdvARB = pointerBuffer.get(1464);
/*  6749 */     this.glGetProgramLocalParameterfvARB = pointerBuffer.get(1465);
/*  6750 */     this.glGetProgramLocalParameterdvARB = pointerBuffer.get(1466);
/*  6751 */     this.glGetProgramivARB = pointerBuffer.get(1467);
/*  6752 */     this.glGetProgramStringARB = pointerBuffer.get(1468);
/*  6753 */     this.glGetVertexAttribfvARB = pointerBuffer.get(1469);
/*  6754 */     this.glGetVertexAttribdvARB = pointerBuffer.get(1470);
/*  6755 */     this.glGetVertexAttribivARB = pointerBuffer.get(1471);
/*  6756 */     this.glGetVertexAttribPointervARB = pointerBuffer.get(1472);
/*  6757 */     this.glIsProgramARB = pointerBuffer.get(1473);
/*  6758 */     this.glBindAttribLocationARB = pointerBuffer.get(1474);
/*  6759 */     this.glGetActiveAttribARB = pointerBuffer.get(1475);
/*  6760 */     this.glGetAttribLocationARB = pointerBuffer.get(1476);
/*  6761 */     this.glWindowPos2iARB = pointerBuffer.get(1477);
/*  6762 */     this.glWindowPos2sARB = pointerBuffer.get(1478);
/*  6763 */     this.glWindowPos2fARB = pointerBuffer.get(1479);
/*  6764 */     this.glWindowPos2dARB = pointerBuffer.get(1480);
/*  6765 */     this.glWindowPos2ivARB = pointerBuffer.get(1481);
/*  6766 */     this.glWindowPos2svARB = pointerBuffer.get(1482);
/*  6767 */     this.glWindowPos2fvARB = pointerBuffer.get(1483);
/*  6768 */     this.glWindowPos2dvARB = pointerBuffer.get(1484);
/*  6769 */     this.glWindowPos3iARB = pointerBuffer.get(1485);
/*  6770 */     this.glWindowPos3sARB = pointerBuffer.get(1486);
/*  6771 */     this.glWindowPos3fARB = pointerBuffer.get(1487);
/*  6772 */     this.glWindowPos3dARB = pointerBuffer.get(1488);
/*  6773 */     this.glWindowPos3ivARB = pointerBuffer.get(1489);
/*  6774 */     this.glWindowPos3svARB = pointerBuffer.get(1490);
/*  6775 */     this.glWindowPos3fvARB = pointerBuffer.get(1491);
/*  6776 */     this.glWindowPos3dvARB = pointerBuffer.get(1492);
/*  6777 */     this.glUniformBufferEXT = pointerBuffer.get(1493);
/*  6778 */     this.glGetUniformBufferSizeEXT = pointerBuffer.get(1494);
/*  6779 */     this.glGetUniformOffsetEXT = pointerBuffer.get(1495);
/*  6780 */     this.glBlendColorEXT = pointerBuffer.get(1496);
/*  6781 */     this.glBlendEquationSeparateEXT = pointerBuffer.get(1497);
/*  6782 */     this.glBlendFuncSeparateEXT = pointerBuffer.get(1498);
/*  6783 */     this.glBlendEquationEXT = pointerBuffer.get(1499);
/*  6784 */     this.glLockArraysEXT = pointerBuffer.get(1500);
/*  6785 */     this.glUnlockArraysEXT = pointerBuffer.get(1501);
/*  6786 */     this.glLabelObjectEXT = pointerBuffer.get(1502);
/*  6787 */     this.glGetObjectLabelEXT = pointerBuffer.get(1503);
/*  6788 */     this.glInsertEventMarkerEXT = pointerBuffer.get(1504);
/*  6789 */     this.glPushGroupMarkerEXT = pointerBuffer.get(1505);
/*  6790 */     this.glPopGroupMarkerEXT = pointerBuffer.get(1506);
/*  6791 */     this.glDepthBoundsEXT = pointerBuffer.get(1507);
/*  6792 */     this.glClientAttribDefaultEXT = pointerBuffer.get(1508);
/*  6793 */     this.glPushClientAttribDefaultEXT = pointerBuffer.get(1509);
/*  6794 */     this.glMatrixLoadfEXT = pointerBuffer.get(1510);
/*  6795 */     this.glMatrixLoaddEXT = pointerBuffer.get(1511);
/*  6796 */     this.glMatrixMultfEXT = pointerBuffer.get(1512);
/*  6797 */     this.glMatrixMultdEXT = pointerBuffer.get(1513);
/*  6798 */     this.glMatrixLoadIdentityEXT = pointerBuffer.get(1514);
/*  6799 */     this.glMatrixRotatefEXT = pointerBuffer.get(1515);
/*  6800 */     this.glMatrixRotatedEXT = pointerBuffer.get(1516);
/*  6801 */     this.glMatrixScalefEXT = pointerBuffer.get(1517);
/*  6802 */     this.glMatrixScaledEXT = pointerBuffer.get(1518);
/*  6803 */     this.glMatrixTranslatefEXT = pointerBuffer.get(1519);
/*  6804 */     this.glMatrixTranslatedEXT = pointerBuffer.get(1520);
/*  6805 */     this.glMatrixOrthoEXT = pointerBuffer.get(1521);
/*  6806 */     this.glMatrixFrustumEXT = pointerBuffer.get(1522);
/*  6807 */     this.glMatrixPushEXT = pointerBuffer.get(1523);
/*  6808 */     this.glMatrixPopEXT = pointerBuffer.get(1524);
/*  6809 */     this.glTextureParameteriEXT = pointerBuffer.get(1525);
/*  6810 */     this.glTextureParameterivEXT = pointerBuffer.get(1526);
/*  6811 */     this.glTextureParameterfEXT = pointerBuffer.get(1527);
/*  6812 */     this.glTextureParameterfvEXT = pointerBuffer.get(1528);
/*  6813 */     this.glTextureImage1DEXT = pointerBuffer.get(1529);
/*  6814 */     this.glTextureImage2DEXT = pointerBuffer.get(1530);
/*  6815 */     this.glTextureSubImage1DEXT = pointerBuffer.get(1531);
/*  6816 */     this.glTextureSubImage2DEXT = pointerBuffer.get(1532);
/*  6817 */     this.glCopyTextureImage1DEXT = pointerBuffer.get(1533);
/*  6818 */     this.glCopyTextureImage2DEXT = pointerBuffer.get(1534);
/*  6819 */     this.glCopyTextureSubImage1DEXT = pointerBuffer.get(1535);
/*  6820 */     this.glCopyTextureSubImage2DEXT = pointerBuffer.get(1536);
/*  6821 */     this.glGetTextureImageEXT = pointerBuffer.get(1537);
/*  6822 */     this.glGetTextureParameterfvEXT = pointerBuffer.get(1538);
/*  6823 */     this.glGetTextureParameterivEXT = pointerBuffer.get(1539);
/*  6824 */     this.glGetTextureLevelParameterfvEXT = pointerBuffer.get(1540);
/*  6825 */     this.glGetTextureLevelParameterivEXT = pointerBuffer.get(1541);
/*  6826 */     this.glTextureImage3DEXT = pointerBuffer.get(1542);
/*  6827 */     this.glTextureSubImage3DEXT = pointerBuffer.get(1543);
/*  6828 */     this.glCopyTextureSubImage3DEXT = pointerBuffer.get(1544);
/*  6829 */     this.glBindMultiTextureEXT = pointerBuffer.get(1545);
/*  6830 */     this.glMultiTexCoordPointerEXT = pointerBuffer.get(1546);
/*  6831 */     this.glMultiTexEnvfEXT = pointerBuffer.get(1547);
/*  6832 */     this.glMultiTexEnvfvEXT = pointerBuffer.get(1548);
/*  6833 */     this.glMultiTexEnviEXT = pointerBuffer.get(1549);
/*  6834 */     this.glMultiTexEnvivEXT = pointerBuffer.get(1550);
/*  6835 */     this.glMultiTexGendEXT = pointerBuffer.get(1551);
/*  6836 */     this.glMultiTexGendvEXT = pointerBuffer.get(1552);
/*  6837 */     this.glMultiTexGenfEXT = pointerBuffer.get(1553);
/*  6838 */     this.glMultiTexGenfvEXT = pointerBuffer.get(1554);
/*  6839 */     this.glMultiTexGeniEXT = pointerBuffer.get(1555);
/*  6840 */     this.glMultiTexGenivEXT = pointerBuffer.get(1556);
/*  6841 */     this.glGetMultiTexEnvfvEXT = pointerBuffer.get(1557);
/*  6842 */     this.glGetMultiTexEnvivEXT = pointerBuffer.get(1558);
/*  6843 */     this.glGetMultiTexGendvEXT = pointerBuffer.get(1559);
/*  6844 */     this.glGetMultiTexGenfvEXT = pointerBuffer.get(1560);
/*  6845 */     this.glGetMultiTexGenivEXT = pointerBuffer.get(1561);
/*  6846 */     this.glMultiTexParameteriEXT = pointerBuffer.get(1562);
/*  6847 */     this.glMultiTexParameterivEXT = pointerBuffer.get(1563);
/*  6848 */     this.glMultiTexParameterfEXT = pointerBuffer.get(1564);
/*  6849 */     this.glMultiTexParameterfvEXT = pointerBuffer.get(1565);
/*  6850 */     this.glMultiTexImage1DEXT = pointerBuffer.get(1566);
/*  6851 */     this.glMultiTexImage2DEXT = pointerBuffer.get(1567);
/*  6852 */     this.glMultiTexSubImage1DEXT = pointerBuffer.get(1568);
/*  6853 */     this.glMultiTexSubImage2DEXT = pointerBuffer.get(1569);
/*  6854 */     this.glCopyMultiTexImage1DEXT = pointerBuffer.get(1570);
/*  6855 */     this.glCopyMultiTexImage2DEXT = pointerBuffer.get(1571);
/*  6856 */     this.glCopyMultiTexSubImage1DEXT = pointerBuffer.get(1572);
/*  6857 */     this.glCopyMultiTexSubImage2DEXT = pointerBuffer.get(1573);
/*  6858 */     this.glGetMultiTexImageEXT = pointerBuffer.get(1574);
/*  6859 */     this.glGetMultiTexParameterfvEXT = pointerBuffer.get(1575);
/*  6860 */     this.glGetMultiTexParameterivEXT = pointerBuffer.get(1576);
/*  6861 */     this.glGetMultiTexLevelParameterfvEXT = pointerBuffer.get(1577);
/*  6862 */     this.glGetMultiTexLevelParameterivEXT = pointerBuffer.get(1578);
/*  6863 */     this.glMultiTexImage3DEXT = pointerBuffer.get(1579);
/*  6864 */     this.glMultiTexSubImage3DEXT = pointerBuffer.get(1580);
/*  6865 */     this.glCopyMultiTexSubImage3DEXT = pointerBuffer.get(1581);
/*  6866 */     this.glEnableClientStateIndexedEXT = pointerBuffer.get(1582);
/*  6867 */     this.glDisableClientStateIndexedEXT = pointerBuffer.get(1583);
/*  6868 */     this.glEnableClientStateiEXT = pointerBuffer.get(1584);
/*  6869 */     this.glDisableClientStateiEXT = pointerBuffer.get(1585);
/*  6870 */     this.glGetFloatIndexedvEXT = pointerBuffer.get(1586);
/*  6871 */     this.glGetDoubleIndexedvEXT = pointerBuffer.get(1587);
/*  6872 */     this.glGetPointerIndexedvEXT = pointerBuffer.get(1588);
/*  6873 */     this.glGetFloati_vEXT = pointerBuffer.get(1589);
/*  6874 */     this.glGetDoublei_vEXT = pointerBuffer.get(1590);
/*  6875 */     this.glGetPointeri_vEXT = pointerBuffer.get(1591);
/*  6876 */     this.glEnableIndexedEXT = pointerBuffer.get(1592);
/*  6877 */     this.glDisableIndexedEXT = pointerBuffer.get(1593);
/*  6878 */     this.glIsEnabledIndexedEXT = pointerBuffer.get(1594);
/*  6879 */     this.glGetIntegerIndexedvEXT = pointerBuffer.get(1595);
/*  6880 */     this.glGetBooleanIndexedvEXT = pointerBuffer.get(1596);
/*  6881 */     this.glNamedProgramStringEXT = pointerBuffer.get(1597);
/*  6882 */     this.glNamedProgramLocalParameter4dEXT = pointerBuffer.get(1598);
/*  6883 */     this.glNamedProgramLocalParameter4dvEXT = pointerBuffer.get(1599);
/*  6884 */     this.glNamedProgramLocalParameter4fEXT = pointerBuffer.get(1600);
/*  6885 */     this.glNamedProgramLocalParameter4fvEXT = pointerBuffer.get(1601);
/*  6886 */     this.glGetNamedProgramLocalParameterdvEXT = pointerBuffer.get(1602);
/*  6887 */     this.glGetNamedProgramLocalParameterfvEXT = pointerBuffer.get(1603);
/*  6888 */     this.glGetNamedProgramivEXT = pointerBuffer.get(1604);
/*  6889 */     this.glGetNamedProgramStringEXT = pointerBuffer.get(1605);
/*  6890 */     this.glCompressedTextureImage3DEXT = pointerBuffer.get(1606);
/*  6891 */     this.glCompressedTextureImage2DEXT = pointerBuffer.get(1607);
/*  6892 */     this.glCompressedTextureImage1DEXT = pointerBuffer.get(1608);
/*  6893 */     this.glCompressedTextureSubImage3DEXT = pointerBuffer.get(1609);
/*  6894 */     this.glCompressedTextureSubImage2DEXT = pointerBuffer.get(1610);
/*  6895 */     this.glCompressedTextureSubImage1DEXT = pointerBuffer.get(1611);
/*  6896 */     this.glGetCompressedTextureImageEXT = pointerBuffer.get(1612);
/*  6897 */     this.glCompressedMultiTexImage3DEXT = pointerBuffer.get(1613);
/*  6898 */     this.glCompressedMultiTexImage2DEXT = pointerBuffer.get(1614);
/*  6899 */     this.glCompressedMultiTexImage1DEXT = pointerBuffer.get(1615);
/*  6900 */     this.glCompressedMultiTexSubImage3DEXT = pointerBuffer.get(1616);
/*  6901 */     this.glCompressedMultiTexSubImage2DEXT = pointerBuffer.get(1617);
/*  6902 */     this.glCompressedMultiTexSubImage1DEXT = pointerBuffer.get(1618);
/*  6903 */     this.glGetCompressedMultiTexImageEXT = pointerBuffer.get(1619);
/*  6904 */     this.glMatrixLoadTransposefEXT = pointerBuffer.get(1620);
/*  6905 */     this.glMatrixLoadTransposedEXT = pointerBuffer.get(1621);
/*  6906 */     this.glMatrixMultTransposefEXT = pointerBuffer.get(1622);
/*  6907 */     this.glMatrixMultTransposedEXT = pointerBuffer.get(1623);
/*  6908 */     this.glNamedBufferDataEXT = pointerBuffer.get(1624);
/*  6909 */     this.glNamedBufferSubDataEXT = pointerBuffer.get(1625);
/*  6910 */     this.glMapNamedBufferEXT = pointerBuffer.get(1626);
/*  6911 */     this.glUnmapNamedBufferEXT = pointerBuffer.get(1627);
/*  6912 */     this.glGetNamedBufferParameterivEXT = pointerBuffer.get(1628);
/*  6913 */     this.glGetNamedBufferSubDataEXT = pointerBuffer.get(1629);
/*  6914 */     this.glProgramUniform1fEXT = pointerBuffer.get(1630);
/*  6915 */     this.glProgramUniform2fEXT = pointerBuffer.get(1631);
/*  6916 */     this.glProgramUniform3fEXT = pointerBuffer.get(1632);
/*  6917 */     this.glProgramUniform4fEXT = pointerBuffer.get(1633);
/*  6918 */     this.glProgramUniform1iEXT = pointerBuffer.get(1634);
/*  6919 */     this.glProgramUniform2iEXT = pointerBuffer.get(1635);
/*  6920 */     this.glProgramUniform3iEXT = pointerBuffer.get(1636);
/*  6921 */     this.glProgramUniform4iEXT = pointerBuffer.get(1637);
/*  6922 */     this.glProgramUniform1fvEXT = pointerBuffer.get(1638);
/*  6923 */     this.glProgramUniform2fvEXT = pointerBuffer.get(1639);
/*  6924 */     this.glProgramUniform3fvEXT = pointerBuffer.get(1640);
/*  6925 */     this.glProgramUniform4fvEXT = pointerBuffer.get(1641);
/*  6926 */     this.glProgramUniform1ivEXT = pointerBuffer.get(1642);
/*  6927 */     this.glProgramUniform2ivEXT = pointerBuffer.get(1643);
/*  6928 */     this.glProgramUniform3ivEXT = pointerBuffer.get(1644);
/*  6929 */     this.glProgramUniform4ivEXT = pointerBuffer.get(1645);
/*  6930 */     this.glProgramUniformMatrix2fvEXT = pointerBuffer.get(1646);
/*  6931 */     this.glProgramUniformMatrix3fvEXT = pointerBuffer.get(1647);
/*  6932 */     this.glProgramUniformMatrix4fvEXT = pointerBuffer.get(1648);
/*  6933 */     this.glProgramUniformMatrix2x3fvEXT = pointerBuffer.get(1649);
/*  6934 */     this.glProgramUniformMatrix3x2fvEXT = pointerBuffer.get(1650);
/*  6935 */     this.glProgramUniformMatrix2x4fvEXT = pointerBuffer.get(1651);
/*  6936 */     this.glProgramUniformMatrix4x2fvEXT = pointerBuffer.get(1652);
/*  6937 */     this.glProgramUniformMatrix3x4fvEXT = pointerBuffer.get(1653);
/*  6938 */     this.glProgramUniformMatrix4x3fvEXT = pointerBuffer.get(1654);
/*  6939 */     this.glTextureBufferEXT = pointerBuffer.get(1655);
/*  6940 */     this.glMultiTexBufferEXT = pointerBuffer.get(1656);
/*  6941 */     this.glTextureParameterIivEXT = pointerBuffer.get(1657);
/*  6942 */     this.glTextureParameterIuivEXT = pointerBuffer.get(1658);
/*  6943 */     this.glGetTextureParameterIivEXT = pointerBuffer.get(1659);
/*  6944 */     this.glGetTextureParameterIuivEXT = pointerBuffer.get(1660);
/*  6945 */     this.glMultiTexParameterIivEXT = pointerBuffer.get(1661);
/*  6946 */     this.glMultiTexParameterIuivEXT = pointerBuffer.get(1662);
/*  6947 */     this.glGetMultiTexParameterIivEXT = pointerBuffer.get(1663);
/*  6948 */     this.glGetMultiTexParameterIuivEXT = pointerBuffer.get(1664);
/*  6949 */     this.glProgramUniform1uiEXT = pointerBuffer.get(1665);
/*  6950 */     this.glProgramUniform2uiEXT = pointerBuffer.get(1666);
/*  6951 */     this.glProgramUniform3uiEXT = pointerBuffer.get(1667);
/*  6952 */     this.glProgramUniform4uiEXT = pointerBuffer.get(1668);
/*  6953 */     this.glProgramUniform1uivEXT = pointerBuffer.get(1669);
/*  6954 */     this.glProgramUniform2uivEXT = pointerBuffer.get(1670);
/*  6955 */     this.glProgramUniform3uivEXT = pointerBuffer.get(1671);
/*  6956 */     this.glProgramUniform4uivEXT = pointerBuffer.get(1672);
/*  6957 */     this.glNamedProgramLocalParameters4fvEXT = pointerBuffer.get(1673);
/*  6958 */     this.glNamedProgramLocalParameterI4iEXT = pointerBuffer.get(1674);
/*  6959 */     this.glNamedProgramLocalParameterI4ivEXT = pointerBuffer.get(1675);
/*  6960 */     this.glNamedProgramLocalParametersI4ivEXT = pointerBuffer.get(1676);
/*  6961 */     this.glNamedProgramLocalParameterI4uiEXT = pointerBuffer.get(1677);
/*  6962 */     this.glNamedProgramLocalParameterI4uivEXT = pointerBuffer.get(1678);
/*  6963 */     this.glNamedProgramLocalParametersI4uivEXT = pointerBuffer.get(1679);
/*  6964 */     this.glGetNamedProgramLocalParameterIivEXT = pointerBuffer.get(1680);
/*  6965 */     this.glGetNamedProgramLocalParameterIuivEXT = pointerBuffer.get(1681);
/*  6966 */     this.glNamedRenderbufferStorageEXT = pointerBuffer.get(1682);
/*  6967 */     this.glGetNamedRenderbufferParameterivEXT = pointerBuffer.get(1683);
/*  6968 */     this.glNamedRenderbufferStorageMultisampleEXT = pointerBuffer.get(1684);
/*  6969 */     this.glNamedRenderbufferStorageMultisampleCoverageEXT = pointerBuffer.get(1685);
/*  6970 */     this.glCheckNamedFramebufferStatusEXT = pointerBuffer.get(1686);
/*  6971 */     this.glNamedFramebufferTexture1DEXT = pointerBuffer.get(1687);
/*  6972 */     this.glNamedFramebufferTexture2DEXT = pointerBuffer.get(1688);
/*  6973 */     this.glNamedFramebufferTexture3DEXT = pointerBuffer.get(1689);
/*  6974 */     this.glNamedFramebufferRenderbufferEXT = pointerBuffer.get(1690);
/*  6975 */     this.glGetNamedFramebufferAttachmentParameterivEXT = pointerBuffer.get(1691);
/*  6976 */     this.glGenerateTextureMipmapEXT = pointerBuffer.get(1692);
/*  6977 */     this.glGenerateMultiTexMipmapEXT = pointerBuffer.get(1693);
/*  6978 */     this.glFramebufferDrawBufferEXT = pointerBuffer.get(1694);
/*  6979 */     this.glFramebufferDrawBuffersEXT = pointerBuffer.get(1695);
/*  6980 */     this.glFramebufferReadBufferEXT = pointerBuffer.get(1696);
/*  6981 */     this.glGetFramebufferParameterivEXT = pointerBuffer.get(1697);
/*  6982 */     this.glNamedCopyBufferSubDataEXT = pointerBuffer.get(1698);
/*  6983 */     this.glNamedFramebufferTextureEXT = pointerBuffer.get(1699);
/*  6984 */     this.glNamedFramebufferTextureLayerEXT = pointerBuffer.get(1700);
/*  6985 */     this.glNamedFramebufferTextureFaceEXT = pointerBuffer.get(1701);
/*  6986 */     this.glTextureRenderbufferEXT = pointerBuffer.get(1702);
/*  6987 */     this.glMultiTexRenderbufferEXT = pointerBuffer.get(1703);
/*  6988 */     this.glVertexArrayVertexOffsetEXT = pointerBuffer.get(1704);
/*  6989 */     this.glVertexArrayColorOffsetEXT = pointerBuffer.get(1705);
/*  6990 */     this.glVertexArrayEdgeFlagOffsetEXT = pointerBuffer.get(1706);
/*  6991 */     this.glVertexArrayIndexOffsetEXT = pointerBuffer.get(1707);
/*  6992 */     this.glVertexArrayNormalOffsetEXT = pointerBuffer.get(1708);
/*  6993 */     this.glVertexArrayTexCoordOffsetEXT = pointerBuffer.get(1709);
/*  6994 */     this.glVertexArrayMultiTexCoordOffsetEXT = pointerBuffer.get(1710);
/*  6995 */     this.glVertexArrayFogCoordOffsetEXT = pointerBuffer.get(1711);
/*  6996 */     this.glVertexArraySecondaryColorOffsetEXT = pointerBuffer.get(1712);
/*  6997 */     this.glVertexArrayVertexAttribOffsetEXT = pointerBuffer.get(1713);
/*  6998 */     this.glVertexArrayVertexAttribIOffsetEXT = pointerBuffer.get(1714);
/*  6999 */     this.glEnableVertexArrayEXT = pointerBuffer.get(1715);
/*  7000 */     this.glDisableVertexArrayEXT = pointerBuffer.get(1716);
/*  7001 */     this.glEnableVertexArrayAttribEXT = pointerBuffer.get(1717);
/*  7002 */     this.glDisableVertexArrayAttribEXT = pointerBuffer.get(1718);
/*  7003 */     this.glGetVertexArrayIntegervEXT = pointerBuffer.get(1719);
/*  7004 */     this.glGetVertexArrayPointervEXT = pointerBuffer.get(1720);
/*  7005 */     this.glGetVertexArrayIntegeri_vEXT = pointerBuffer.get(1721);
/*  7006 */     this.glGetVertexArrayPointeri_vEXT = pointerBuffer.get(1722);
/*  7007 */     this.glMapNamedBufferRangeEXT = pointerBuffer.get(1723);
/*  7008 */     this.glFlushMappedNamedBufferRangeEXT = pointerBuffer.get(1724);
/*  7009 */     this.glColorMaskIndexedEXT = pointerBuffer.get(1725);
/*  7010 */     this.glDrawArraysInstancedEXT = pointerBuffer.get(1726);
/*  7011 */     this.glDrawElementsInstancedEXT = pointerBuffer.get(1727);
/*  7012 */     this.glEGLImageTargetTexStorageEXT = pointerBuffer.get(1728);
/*  7013 */     this.glEGLImageTargetTextureStorageEXT = pointerBuffer.get(1729);
/*  7014 */     this.glBufferStorageExternalEXT = pointerBuffer.get(1730);
/*  7015 */     this.glNamedBufferStorageExternalEXT = pointerBuffer.get(1731);
/*  7016 */     this.glBlitFramebufferEXT = pointerBuffer.get(1732);
/*  7017 */     this.glBlitFramebufferLayersEXT = pointerBuffer.get(1733);
/*  7018 */     this.glBlitFramebufferLayerEXT = pointerBuffer.get(1734);
/*  7019 */     this.glRenderbufferStorageMultisampleEXT = pointerBuffer.get(1735);
/*  7020 */     this.glIsRenderbufferEXT = pointerBuffer.get(1736);
/*  7021 */     this.glBindRenderbufferEXT = pointerBuffer.get(1737);
/*  7022 */     this.glDeleteRenderbuffersEXT = pointerBuffer.get(1738);
/*  7023 */     this.glGenRenderbuffersEXT = pointerBuffer.get(1739);
/*  7024 */     this.glRenderbufferStorageEXT = pointerBuffer.get(1740);
/*  7025 */     this.glGetRenderbufferParameterivEXT = pointerBuffer.get(1741);
/*  7026 */     this.glIsFramebufferEXT = pointerBuffer.get(1742);
/*  7027 */     this.glBindFramebufferEXT = pointerBuffer.get(1743);
/*  7028 */     this.glDeleteFramebuffersEXT = pointerBuffer.get(1744);
/*  7029 */     this.glGenFramebuffersEXT = pointerBuffer.get(1745);
/*  7030 */     this.glCheckFramebufferStatusEXT = pointerBuffer.get(1746);
/*  7031 */     this.glFramebufferTexture1DEXT = pointerBuffer.get(1747);
/*  7032 */     this.glFramebufferTexture2DEXT = pointerBuffer.get(1748);
/*  7033 */     this.glFramebufferTexture3DEXT = pointerBuffer.get(1749);
/*  7034 */     this.glFramebufferRenderbufferEXT = pointerBuffer.get(1750);
/*  7035 */     this.glGetFramebufferAttachmentParameterivEXT = pointerBuffer.get(1751);
/*  7036 */     this.glGenerateMipmapEXT = pointerBuffer.get(1752);
/*  7037 */     this.glProgramParameteriEXT = pointerBuffer.get(1753);
/*  7038 */     this.glFramebufferTextureEXT = pointerBuffer.get(1754);
/*  7039 */     this.glFramebufferTextureLayerEXT = pointerBuffer.get(1755);
/*  7040 */     this.glFramebufferTextureFaceEXT = pointerBuffer.get(1756);
/*  7041 */     this.glProgramEnvParameters4fvEXT = pointerBuffer.get(1757);
/*  7042 */     this.glProgramLocalParameters4fvEXT = pointerBuffer.get(1758);
/*  7043 */     this.glVertexAttribI1iEXT = pointerBuffer.get(1759);
/*  7044 */     this.glVertexAttribI2iEXT = pointerBuffer.get(1760);
/*  7045 */     this.glVertexAttribI3iEXT = pointerBuffer.get(1761);
/*  7046 */     this.glVertexAttribI4iEXT = pointerBuffer.get(1762);
/*  7047 */     this.glVertexAttribI1uiEXT = pointerBuffer.get(1763);
/*  7048 */     this.glVertexAttribI2uiEXT = pointerBuffer.get(1764);
/*  7049 */     this.glVertexAttribI3uiEXT = pointerBuffer.get(1765);
/*  7050 */     this.glVertexAttribI4uiEXT = pointerBuffer.get(1766);
/*  7051 */     this.glVertexAttribI1ivEXT = pointerBuffer.get(1767);
/*  7052 */     this.glVertexAttribI2ivEXT = pointerBuffer.get(1768);
/*  7053 */     this.glVertexAttribI3ivEXT = pointerBuffer.get(1769);
/*  7054 */     this.glVertexAttribI4ivEXT = pointerBuffer.get(1770);
/*  7055 */     this.glVertexAttribI1uivEXT = pointerBuffer.get(1771);
/*  7056 */     this.glVertexAttribI2uivEXT = pointerBuffer.get(1772);
/*  7057 */     this.glVertexAttribI3uivEXT = pointerBuffer.get(1773);
/*  7058 */     this.glVertexAttribI4uivEXT = pointerBuffer.get(1774);
/*  7059 */     this.glVertexAttribI4bvEXT = pointerBuffer.get(1775);
/*  7060 */     this.glVertexAttribI4svEXT = pointerBuffer.get(1776);
/*  7061 */     this.glVertexAttribI4ubvEXT = pointerBuffer.get(1777);
/*  7062 */     this.glVertexAttribI4usvEXT = pointerBuffer.get(1778);
/*  7063 */     this.glVertexAttribIPointerEXT = pointerBuffer.get(1779);
/*  7064 */     this.glGetVertexAttribIivEXT = pointerBuffer.get(1780);
/*  7065 */     this.glGetVertexAttribIuivEXT = pointerBuffer.get(1781);
/*  7066 */     this.glGetUniformuivEXT = pointerBuffer.get(1782);
/*  7067 */     this.glBindFragDataLocationEXT = pointerBuffer.get(1783);
/*  7068 */     this.glGetFragDataLocationEXT = pointerBuffer.get(1784);
/*  7069 */     this.glUniform1uiEXT = pointerBuffer.get(1785);
/*  7070 */     this.glUniform2uiEXT = pointerBuffer.get(1786);
/*  7071 */     this.glUniform3uiEXT = pointerBuffer.get(1787);
/*  7072 */     this.glUniform4uiEXT = pointerBuffer.get(1788);
/*  7073 */     this.glUniform1uivEXT = pointerBuffer.get(1789);
/*  7074 */     this.glUniform2uivEXT = pointerBuffer.get(1790);
/*  7075 */     this.glUniform3uivEXT = pointerBuffer.get(1791);
/*  7076 */     this.glUniform4uivEXT = pointerBuffer.get(1792);
/*  7077 */     this.glGetUnsignedBytevEXT = pointerBuffer.get(1793);
/*  7078 */     this.glGetUnsignedBytei_vEXT = pointerBuffer.get(1794);
/*  7079 */     this.glDeleteMemoryObjectsEXT = pointerBuffer.get(1795);
/*  7080 */     this.glIsMemoryObjectEXT = pointerBuffer.get(1796);
/*  7081 */     this.glCreateMemoryObjectsEXT = pointerBuffer.get(1797);
/*  7082 */     this.glMemoryObjectParameterivEXT = pointerBuffer.get(1798);
/*  7083 */     this.glGetMemoryObjectParameterivEXT = pointerBuffer.get(1799);
/*  7084 */     this.glTexStorageMem2DEXT = pointerBuffer.get(1800);
/*  7085 */     this.glTexStorageMem2DMultisampleEXT = pointerBuffer.get(1801);
/*  7086 */     this.glTexStorageMem3DEXT = pointerBuffer.get(1802);
/*  7087 */     this.glTexStorageMem3DMultisampleEXT = pointerBuffer.get(1803);
/*  7088 */     this.glBufferStorageMemEXT = pointerBuffer.get(1804);
/*  7089 */     this.glTextureStorageMem2DEXT = pointerBuffer.get(1805);
/*  7090 */     this.glTextureStorageMem2DMultisampleEXT = pointerBuffer.get(1806);
/*  7091 */     this.glTextureStorageMem3DEXT = pointerBuffer.get(1807);
/*  7092 */     this.glTextureStorageMem3DMultisampleEXT = pointerBuffer.get(1808);
/*  7093 */     this.glNamedBufferStorageMemEXT = pointerBuffer.get(1809);
/*  7094 */     this.glTexStorageMem1DEXT = pointerBuffer.get(1810);
/*  7095 */     this.glTextureStorageMem1DEXT = pointerBuffer.get(1811);
/*  7096 */     this.glImportMemoryFdEXT = pointerBuffer.get(1812);
/*  7097 */     this.glImportMemoryWin32HandleEXT = pointerBuffer.get(1813);
/*  7098 */     this.glImportMemoryWin32NameEXT = pointerBuffer.get(1814);
/*  7099 */     this.glPointParameterfEXT = pointerBuffer.get(1815);
/*  7100 */     this.glPointParameterfvEXT = pointerBuffer.get(1816);
/*  7101 */     this.glPolygonOffsetClampEXT = pointerBuffer.get(1817);
/*  7102 */     this.glProvokingVertexEXT = pointerBuffer.get(1818);
/*  7103 */     this.glRasterSamplesEXT = pointerBuffer.get(1819);
/*  7104 */     this.glSecondaryColor3bEXT = pointerBuffer.get(1820);
/*  7105 */     this.glSecondaryColor3sEXT = pointerBuffer.get(1821);
/*  7106 */     this.glSecondaryColor3iEXT = pointerBuffer.get(1822);
/*  7107 */     this.glSecondaryColor3fEXT = pointerBuffer.get(1823);
/*  7108 */     this.glSecondaryColor3dEXT = pointerBuffer.get(1824);
/*  7109 */     this.glSecondaryColor3ubEXT = pointerBuffer.get(1825);
/*  7110 */     this.glSecondaryColor3usEXT = pointerBuffer.get(1826);
/*  7111 */     this.glSecondaryColor3uiEXT = pointerBuffer.get(1827);
/*  7112 */     this.glSecondaryColor3bvEXT = pointerBuffer.get(1828);
/*  7113 */     this.glSecondaryColor3svEXT = pointerBuffer.get(1829);
/*  7114 */     this.glSecondaryColor3ivEXT = pointerBuffer.get(1830);
/*  7115 */     this.glSecondaryColor3fvEXT = pointerBuffer.get(1831);
/*  7116 */     this.glSecondaryColor3dvEXT = pointerBuffer.get(1832);
/*  7117 */     this.glSecondaryColor3ubvEXT = pointerBuffer.get(1833);
/*  7118 */     this.glSecondaryColor3usvEXT = pointerBuffer.get(1834);
/*  7119 */     this.glSecondaryColor3uivEXT = pointerBuffer.get(1835);
/*  7120 */     this.glSecondaryColorPointerEXT = pointerBuffer.get(1836);
/*  7121 */     this.glGenSemaphoresEXT = pointerBuffer.get(1837);
/*  7122 */     this.glDeleteSemaphoresEXT = pointerBuffer.get(1838);
/*  7123 */     this.glIsSemaphoreEXT = pointerBuffer.get(1839);
/*  7124 */     this.glSemaphoreParameterui64vEXT = pointerBuffer.get(1840);
/*  7125 */     this.glGetSemaphoreParameterui64vEXT = pointerBuffer.get(1841);
/*  7126 */     this.glWaitSemaphoreEXT = pointerBuffer.get(1842);
/*  7127 */     this.glSignalSemaphoreEXT = pointerBuffer.get(1843);
/*  7128 */     this.glImportSemaphoreFdEXT = pointerBuffer.get(1844);
/*  7129 */     this.glImportSemaphoreWin32HandleEXT = pointerBuffer.get(1845);
/*  7130 */     this.glImportSemaphoreWin32NameEXT = pointerBuffer.get(1846);
/*  7131 */     this.glUseShaderProgramEXT = pointerBuffer.get(1847);
/*  7132 */     this.glActiveProgramEXT = pointerBuffer.get(1848);
/*  7133 */     this.glCreateShaderProgramEXT = pointerBuffer.get(1849);
/*  7134 */     this.glFramebufferFetchBarrierEXT = pointerBuffer.get(1850);
/*  7135 */     this.glBindImageTextureEXT = pointerBuffer.get(1851);
/*  7136 */     this.glMemoryBarrierEXT = pointerBuffer.get(1852);
/*  7137 */     this.glStencilClearTagEXT = pointerBuffer.get(1853);
/*  7138 */     this.glActiveStencilFaceEXT = pointerBuffer.get(1854);
/*  7139 */     this.glTexBufferEXT = pointerBuffer.get(1855);
/*  7140 */     this.glClearColorIiEXT = pointerBuffer.get(1856);
/*  7141 */     this.glClearColorIuiEXT = pointerBuffer.get(1857);
/*  7142 */     this.glTexParameterIivEXT = pointerBuffer.get(1858);
/*  7143 */     this.glTexParameterIuivEXT = pointerBuffer.get(1859);
/*  7144 */     this.glGetTexParameterIivEXT = pointerBuffer.get(1860);
/*  7145 */     this.glGetTexParameterIuivEXT = pointerBuffer.get(1861);
/*  7146 */     this.glTexStorage1DEXT = pointerBuffer.get(1862);
/*  7147 */     this.glTexStorage2DEXT = pointerBuffer.get(1863);
/*  7148 */     this.glTexStorage3DEXT = pointerBuffer.get(1864);
/*  7149 */     this.glGetQueryObjecti64vEXT = pointerBuffer.get(1865);
/*  7150 */     this.glGetQueryObjectui64vEXT = pointerBuffer.get(1866);
/*  7151 */     this.glBindBufferRangeEXT = pointerBuffer.get(1867);
/*  7152 */     this.glBindBufferOffsetEXT = pointerBuffer.get(1868);
/*  7153 */     this.glBindBufferBaseEXT = pointerBuffer.get(1869);
/*  7154 */     this.glBeginTransformFeedbackEXT = pointerBuffer.get(1870);
/*  7155 */     this.glEndTransformFeedbackEXT = pointerBuffer.get(1871);
/*  7156 */     this.glTransformFeedbackVaryingsEXT = pointerBuffer.get(1872);
/*  7157 */     this.glGetTransformFeedbackVaryingEXT = pointerBuffer.get(1873);
/*  7158 */     this.glVertexAttribL1dEXT = pointerBuffer.get(1874);
/*  7159 */     this.glVertexAttribL2dEXT = pointerBuffer.get(1875);
/*  7160 */     this.glVertexAttribL3dEXT = pointerBuffer.get(1876);
/*  7161 */     this.glVertexAttribL4dEXT = pointerBuffer.get(1877);
/*  7162 */     this.glVertexAttribL1dvEXT = pointerBuffer.get(1878);
/*  7163 */     this.glVertexAttribL2dvEXT = pointerBuffer.get(1879);
/*  7164 */     this.glVertexAttribL3dvEXT = pointerBuffer.get(1880);
/*  7165 */     this.glVertexAttribL4dvEXT = pointerBuffer.get(1881);
/*  7166 */     this.glVertexAttribLPointerEXT = pointerBuffer.get(1882);
/*  7167 */     this.glGetVertexAttribLdvEXT = pointerBuffer.get(1883);
/*  7168 */     this.glAcquireKeyedMutexWin32EXT = pointerBuffer.get(1884);
/*  7169 */     this.glReleaseKeyedMutexWin32EXT = pointerBuffer.get(1885);
/*  7170 */     this.glWindowRectanglesEXT = pointerBuffer.get(1886);
/*  7171 */     this.glImportSyncEXT = pointerBuffer.get(1887);
/*  7172 */     this.glFrameTerminatorGREMEDY = pointerBuffer.get(1888);
/*  7173 */     this.glStringMarkerGREMEDY = pointerBuffer.get(1889);
/*  7174 */     this.glApplyFramebufferAttachmentCMAAINTEL = pointerBuffer.get(1890);
/*  7175 */     this.glSyncTextureINTEL = pointerBuffer.get(1891);
/*  7176 */     this.glUnmapTexture2DINTEL = pointerBuffer.get(1892);
/*  7177 */     this.glMapTexture2DINTEL = pointerBuffer.get(1893);
/*  7178 */     this.glBeginPerfQueryINTEL = pointerBuffer.get(1894);
/*  7179 */     this.glCreatePerfQueryINTEL = pointerBuffer.get(1895);
/*  7180 */     this.glDeletePerfQueryINTEL = pointerBuffer.get(1896);
/*  7181 */     this.glEndPerfQueryINTEL = pointerBuffer.get(1897);
/*  7182 */     this.glGetFirstPerfQueryIdINTEL = pointerBuffer.get(1898);
/*  7183 */     this.glGetNextPerfQueryIdINTEL = pointerBuffer.get(1899);
/*  7184 */     this.glGetPerfCounterInfoINTEL = pointerBuffer.get(1900);
/*  7185 */     this.glGetPerfQueryDataINTEL = pointerBuffer.get(1901);
/*  7186 */     this.glGetPerfQueryIdByNameINTEL = pointerBuffer.get(1902);
/*  7187 */     this.glGetPerfQueryInfoINTEL = pointerBuffer.get(1903);
/*  7188 */     this.glBlendBarrierKHR = pointerBuffer.get(1904);
/*  7189 */     this.glMaxShaderCompilerThreadsKHR = pointerBuffer.get(1905);
/*  7190 */     this.glFramebufferParameteriMESA = pointerBuffer.get(1906);
/*  7191 */     this.glGetFramebufferParameterivMESA = pointerBuffer.get(1907);
/*  7192 */     this.glAlphaToCoverageDitherControlNV = pointerBuffer.get(1908);
/*  7193 */     this.glMultiDrawArraysIndirectBindlessNV = pointerBuffer.get(1909);
/*  7194 */     this.glMultiDrawElementsIndirectBindlessNV = pointerBuffer.get(1910);
/*  7195 */     this.glMultiDrawArraysIndirectBindlessCountNV = pointerBuffer.get(1911);
/*  7196 */     this.glMultiDrawElementsIndirectBindlessCountNV = pointerBuffer.get(1912);
/*  7197 */     this.glGetTextureHandleNV = pointerBuffer.get(1913);
/*  7198 */     this.glGetTextureSamplerHandleNV = pointerBuffer.get(1914);
/*  7199 */     this.glMakeTextureHandleResidentNV = pointerBuffer.get(1915);
/*  7200 */     this.glMakeTextureHandleNonResidentNV = pointerBuffer.get(1916);
/*  7201 */     this.glGetImageHandleNV = pointerBuffer.get(1917);
/*  7202 */     this.glMakeImageHandleResidentNV = pointerBuffer.get(1918);
/*  7203 */     this.glMakeImageHandleNonResidentNV = pointerBuffer.get(1919);
/*  7204 */     this.glUniformHandleui64NV = pointerBuffer.get(1920);
/*  7205 */     this.glUniformHandleui64vNV = pointerBuffer.get(1921);
/*  7206 */     this.glProgramUniformHandleui64NV = pointerBuffer.get(1922);
/*  7207 */     this.glProgramUniformHandleui64vNV = pointerBuffer.get(1923);
/*  7208 */     this.glIsTextureHandleResidentNV = pointerBuffer.get(1924);
/*  7209 */     this.glIsImageHandleResidentNV = pointerBuffer.get(1925);
/*  7210 */     this.glBlendParameteriNV = pointerBuffer.get(1926);
/*  7211 */     this.glBlendBarrierNV = pointerBuffer.get(1927);
/*  7212 */     this.glViewportPositionWScaleNV = pointerBuffer.get(1928);
/*  7213 */     this.glCreateStatesNV = pointerBuffer.get(1929);
/*  7214 */     this.glDeleteStatesNV = pointerBuffer.get(1930);
/*  7215 */     this.glIsStateNV = pointerBuffer.get(1931);
/*  7216 */     this.glStateCaptureNV = pointerBuffer.get(1932);
/*  7217 */     this.glGetCommandHeaderNV = pointerBuffer.get(1933);
/*  7218 */     this.glGetStageIndexNV = pointerBuffer.get(1934);
/*  7219 */     this.glDrawCommandsNV = pointerBuffer.get(1935);
/*  7220 */     this.glDrawCommandsAddressNV = pointerBuffer.get(1936);
/*  7221 */     this.glDrawCommandsStatesNV = pointerBuffer.get(1937);
/*  7222 */     this.glDrawCommandsStatesAddressNV = pointerBuffer.get(1938);
/*  7223 */     this.glCreateCommandListsNV = pointerBuffer.get(1939);
/*  7224 */     this.glDeleteCommandListsNV = pointerBuffer.get(1940);
/*  7225 */     this.glIsCommandListNV = pointerBuffer.get(1941);
/*  7226 */     this.glListDrawCommandsStatesClientNV = pointerBuffer.get(1942);
/*  7227 */     this.glCommandListSegmentsNV = pointerBuffer.get(1943);
/*  7228 */     this.glCompileCommandListNV = pointerBuffer.get(1944);
/*  7229 */     this.glCallCommandListNV = pointerBuffer.get(1945);
/*  7230 */     this.glBeginConditionalRenderNV = pointerBuffer.get(1946);
/*  7231 */     this.glEndConditionalRenderNV = pointerBuffer.get(1947);
/*  7232 */     this.glSubpixelPrecisionBiasNV = pointerBuffer.get(1948);
/*  7233 */     this.glConservativeRasterParameterfNV = pointerBuffer.get(1949);
/*  7234 */     this.glConservativeRasterParameteriNV = pointerBuffer.get(1950);
/*  7235 */     this.glCopyImageSubDataNV = pointerBuffer.get(1951);
/*  7236 */     this.glDepthRangedNV = pointerBuffer.get(1952);
/*  7237 */     this.glClearDepthdNV = pointerBuffer.get(1953);
/*  7238 */     this.glDepthBoundsdNV = pointerBuffer.get(1954);
/*  7239 */     this.glDrawTextureNV = pointerBuffer.get(1955);
/*  7240 */     this.glDrawVkImageNV = pointerBuffer.get(1956);
/*  7241 */     this.glGetVkProcAddrNV = pointerBuffer.get(1957);
/*  7242 */     this.glWaitVkSemaphoreNV = pointerBuffer.get(1958);
/*  7243 */     this.glSignalVkSemaphoreNV = pointerBuffer.get(1959);
/*  7244 */     this.glSignalVkFenceNV = pointerBuffer.get(1960);
/*  7245 */     this.glGetMultisamplefvNV = pointerBuffer.get(1961);
/*  7246 */     this.glSampleMaskIndexedNV = pointerBuffer.get(1962);
/*  7247 */     this.glTexRenderbufferNV = pointerBuffer.get(1963);
/*  7248 */     this.glDeleteFencesNV = pointerBuffer.get(1964);
/*  7249 */     this.glGenFencesNV = pointerBuffer.get(1965);
/*  7250 */     this.glIsFenceNV = pointerBuffer.get(1966);
/*  7251 */     this.glTestFenceNV = pointerBuffer.get(1967);
/*  7252 */     this.glGetFenceivNV = pointerBuffer.get(1968);
/*  7253 */     this.glFinishFenceNV = pointerBuffer.get(1969);
/*  7254 */     this.glSetFenceNV = pointerBuffer.get(1970);
/*  7255 */     this.glFragmentCoverageColorNV = pointerBuffer.get(1971);
/*  7256 */     this.glCoverageModulationTableNV = pointerBuffer.get(1972);
/*  7257 */     this.glGetCoverageModulationTableNV = pointerBuffer.get(1973);
/*  7258 */     this.glCoverageModulationNV = pointerBuffer.get(1974);
/*  7259 */     this.glRenderbufferStorageMultisampleCoverageNV = pointerBuffer.get(1975);
/*  7260 */     this.glRenderGpuMaskNV = pointerBuffer.get(1976);
/*  7261 */     this.glMulticastBufferSubDataNV = pointerBuffer.get(1977);
/*  7262 */     this.glMulticastCopyBufferSubDataNV = pointerBuffer.get(1978);
/*  7263 */     this.glMulticastCopyImageSubDataNV = pointerBuffer.get(1979);
/*  7264 */     this.glMulticastBlitFramebufferNV = pointerBuffer.get(1980);
/*  7265 */     this.glMulticastFramebufferSampleLocationsfvNV = pointerBuffer.get(1981);
/*  7266 */     this.glMulticastBarrierNV = pointerBuffer.get(1982);
/*  7267 */     this.glMulticastWaitSyncNV = pointerBuffer.get(1983);
/*  7268 */     this.glMulticastGetQueryObjectivNV = pointerBuffer.get(1984);
/*  7269 */     this.glMulticastGetQueryObjectuivNV = pointerBuffer.get(1985);
/*  7270 */     this.glMulticastGetQueryObjecti64vNV = pointerBuffer.get(1986);
/*  7271 */     this.glMulticastGetQueryObjectui64vNV = pointerBuffer.get(1987);
/*  7272 */     this.glVertex2hNV = pointerBuffer.get(1988);
/*  7273 */     this.glVertex2hvNV = pointerBuffer.get(1989);
/*  7274 */     this.glVertex3hNV = pointerBuffer.get(1990);
/*  7275 */     this.glVertex3hvNV = pointerBuffer.get(1991);
/*  7276 */     this.glVertex4hNV = pointerBuffer.get(1992);
/*  7277 */     this.glVertex4hvNV = pointerBuffer.get(1993);
/*  7278 */     this.glNormal3hNV = pointerBuffer.get(1994);
/*  7279 */     this.glNormal3hvNV = pointerBuffer.get(1995);
/*  7280 */     this.glColor3hNV = pointerBuffer.get(1996);
/*  7281 */     this.glColor3hvNV = pointerBuffer.get(1997);
/*  7282 */     this.glColor4hNV = pointerBuffer.get(1998);
/*  7283 */     this.glColor4hvNV = pointerBuffer.get(1999);
/*  7284 */     this.glTexCoord1hNV = pointerBuffer.get(2000);
/*  7285 */     this.glTexCoord1hvNV = pointerBuffer.get(2001);
/*  7286 */     this.glTexCoord2hNV = pointerBuffer.get(2002);
/*  7287 */     this.glTexCoord2hvNV = pointerBuffer.get(2003);
/*  7288 */     this.glTexCoord3hNV = pointerBuffer.get(2004);
/*  7289 */     this.glTexCoord3hvNV = pointerBuffer.get(2005);
/*  7290 */     this.glTexCoord4hNV = pointerBuffer.get(2006);
/*  7291 */     this.glTexCoord4hvNV = pointerBuffer.get(2007);
/*  7292 */     this.glMultiTexCoord1hNV = pointerBuffer.get(2008);
/*  7293 */     this.glMultiTexCoord1hvNV = pointerBuffer.get(2009);
/*  7294 */     this.glMultiTexCoord2hNV = pointerBuffer.get(2010);
/*  7295 */     this.glMultiTexCoord2hvNV = pointerBuffer.get(2011);
/*  7296 */     this.glMultiTexCoord3hNV = pointerBuffer.get(2012);
/*  7297 */     this.glMultiTexCoord3hvNV = pointerBuffer.get(2013);
/*  7298 */     this.glMultiTexCoord4hNV = pointerBuffer.get(2014);
/*  7299 */     this.glMultiTexCoord4hvNV = pointerBuffer.get(2015);
/*  7300 */     this.glFogCoordhNV = pointerBuffer.get(2016);
/*  7301 */     this.glFogCoordhvNV = pointerBuffer.get(2017);
/*  7302 */     this.glSecondaryColor3hNV = pointerBuffer.get(2018);
/*  7303 */     this.glSecondaryColor3hvNV = pointerBuffer.get(2019);
/*  7304 */     this.glVertexWeighthNV = pointerBuffer.get(2020);
/*  7305 */     this.glVertexWeighthvNV = pointerBuffer.get(2021);
/*  7306 */     this.glVertexAttrib1hNV = pointerBuffer.get(2022);
/*  7307 */     this.glVertexAttrib1hvNV = pointerBuffer.get(2023);
/*  7308 */     this.glVertexAttrib2hNV = pointerBuffer.get(2024);
/*  7309 */     this.glVertexAttrib2hvNV = pointerBuffer.get(2025);
/*  7310 */     this.glVertexAttrib3hNV = pointerBuffer.get(2026);
/*  7311 */     this.glVertexAttrib3hvNV = pointerBuffer.get(2027);
/*  7312 */     this.glVertexAttrib4hNV = pointerBuffer.get(2028);
/*  7313 */     this.glVertexAttrib4hvNV = pointerBuffer.get(2029);
/*  7314 */     this.glVertexAttribs1hvNV = pointerBuffer.get(2030);
/*  7315 */     this.glVertexAttribs2hvNV = pointerBuffer.get(2031);
/*  7316 */     this.glVertexAttribs3hvNV = pointerBuffer.get(2032);
/*  7317 */     this.glVertexAttribs4hvNV = pointerBuffer.get(2033);
/*  7318 */     this.glGetInternalformatSampleivNV = pointerBuffer.get(2034);
/*  7319 */     this.glGetMemoryObjectDetachedResourcesuivNV = pointerBuffer.get(2035);
/*  7320 */     this.glResetMemoryObjectParameterNV = pointerBuffer.get(2036);
/*  7321 */     this.glTexAttachMemoryNV = pointerBuffer.get(2037);
/*  7322 */     this.glBufferAttachMemoryNV = pointerBuffer.get(2038);
/*  7323 */     this.glTextureAttachMemoryNV = pointerBuffer.get(2039);
/*  7324 */     this.glNamedBufferAttachMemoryNV = pointerBuffer.get(2040);
/*  7325 */     this.glBufferPageCommitmentMemNV = pointerBuffer.get(2041);
/*  7326 */     this.glNamedBufferPageCommitmentMemNV = pointerBuffer.get(2042);
/*  7327 */     this.glTexPageCommitmentMemNV = pointerBuffer.get(2043);
/*  7328 */     this.glTexturePageCommitmentMemNV = pointerBuffer.get(2044);
/*  7329 */     this.glDrawMeshTasksNV = pointerBuffer.get(2045);
/*  7330 */     this.glDrawMeshTasksIndirectNV = pointerBuffer.get(2046);
/*  7331 */     this.glMultiDrawMeshTasksIndirectNV = pointerBuffer.get(2047);
/*  7332 */     this.glMultiDrawMeshTasksIndirectCountNV = pointerBuffer.get(2048);
/*  7333 */     this.glPathCommandsNV = pointerBuffer.get(2049);
/*  7334 */     this.glPathCoordsNV = pointerBuffer.get(2050);
/*  7335 */     this.glPathSubCommandsNV = pointerBuffer.get(2051);
/*  7336 */     this.glPathSubCoordsNV = pointerBuffer.get(2052);
/*  7337 */     this.glPathStringNV = pointerBuffer.get(2053);
/*  7338 */     this.glPathGlyphsNV = pointerBuffer.get(2054);
/*  7339 */     this.glPathGlyphRangeNV = pointerBuffer.get(2055);
/*  7340 */     this.glPathGlyphIndexArrayNV = pointerBuffer.get(2056);
/*  7341 */     this.glPathMemoryGlyphIndexArrayNV = pointerBuffer.get(2057);
/*  7342 */     this.glCopyPathNV = pointerBuffer.get(2058);
/*  7343 */     this.glWeightPathsNV = pointerBuffer.get(2059);
/*  7344 */     this.glInterpolatePathsNV = pointerBuffer.get(2060);
/*  7345 */     this.glTransformPathNV = pointerBuffer.get(2061);
/*  7346 */     this.glPathParameterivNV = pointerBuffer.get(2062);
/*  7347 */     this.glPathParameteriNV = pointerBuffer.get(2063);
/*  7348 */     this.glPathParameterfvNV = pointerBuffer.get(2064);
/*  7349 */     this.glPathParameterfNV = pointerBuffer.get(2065);
/*  7350 */     this.glPathDashArrayNV = pointerBuffer.get(2066);
/*  7351 */     this.glGenPathsNV = pointerBuffer.get(2067);
/*  7352 */     this.glDeletePathsNV = pointerBuffer.get(2068);
/*  7353 */     this.glIsPathNV = pointerBuffer.get(2069);
/*  7354 */     this.glPathStencilFuncNV = pointerBuffer.get(2070);
/*  7355 */     this.glPathStencilDepthOffsetNV = pointerBuffer.get(2071);
/*  7356 */     this.glStencilFillPathNV = pointerBuffer.get(2072);
/*  7357 */     this.glStencilStrokePathNV = pointerBuffer.get(2073);
/*  7358 */     this.glStencilFillPathInstancedNV = pointerBuffer.get(2074);
/*  7359 */     this.glStencilStrokePathInstancedNV = pointerBuffer.get(2075);
/*  7360 */     this.glPathCoverDepthFuncNV = pointerBuffer.get(2076);
/*  7361 */     this.glPathColorGenNV = pointerBuffer.get(2077);
/*  7362 */     this.glPathTexGenNV = pointerBuffer.get(2078);
/*  7363 */     this.glPathFogGenNV = pointerBuffer.get(2079);
/*  7364 */     this.glCoverFillPathNV = pointerBuffer.get(2080);
/*  7365 */     this.glCoverStrokePathNV = pointerBuffer.get(2081);
/*  7366 */     this.glCoverFillPathInstancedNV = pointerBuffer.get(2082);
/*  7367 */     this.glCoverStrokePathInstancedNV = pointerBuffer.get(2083);
/*  7368 */     this.glStencilThenCoverFillPathNV = pointerBuffer.get(2084);
/*  7369 */     this.glStencilThenCoverStrokePathNV = pointerBuffer.get(2085);
/*  7370 */     this.glStencilThenCoverFillPathInstancedNV = pointerBuffer.get(2086);
/*  7371 */     this.glStencilThenCoverStrokePathInstancedNV = pointerBuffer.get(2087);
/*  7372 */     this.glPathGlyphIndexRangeNV = pointerBuffer.get(2088);
/*  7373 */     this.glProgramPathFragmentInputGenNV = pointerBuffer.get(2089);
/*  7374 */     this.glGetPathParameterivNV = pointerBuffer.get(2090);
/*  7375 */     this.glGetPathParameterfvNV = pointerBuffer.get(2091);
/*  7376 */     this.glGetPathCommandsNV = pointerBuffer.get(2092);
/*  7377 */     this.glGetPathCoordsNV = pointerBuffer.get(2093);
/*  7378 */     this.glGetPathDashArrayNV = pointerBuffer.get(2094);
/*  7379 */     this.glGetPathMetricsNV = pointerBuffer.get(2095);
/*  7380 */     this.glGetPathMetricRangeNV = pointerBuffer.get(2096);
/*  7381 */     this.glGetPathSpacingNV = pointerBuffer.get(2097);
/*  7382 */     this.glGetPathColorGenivNV = pointerBuffer.get(2098);
/*  7383 */     this.glGetPathColorGenfvNV = pointerBuffer.get(2099);
/*  7384 */     this.glGetPathTexGenivNV = pointerBuffer.get(2100);
/*  7385 */     this.glGetPathTexGenfvNV = pointerBuffer.get(2101);
/*  7386 */     this.glIsPointInFillPathNV = pointerBuffer.get(2102);
/*  7387 */     this.glIsPointInStrokePathNV = pointerBuffer.get(2103);
/*  7388 */     this.glGetPathLengthNV = pointerBuffer.get(2104);
/*  7389 */     this.glPointAlongPathNV = pointerBuffer.get(2105);
/*  7390 */     this.glMatrixLoad3x2fNV = pointerBuffer.get(2106);
/*  7391 */     this.glMatrixLoad3x3fNV = pointerBuffer.get(2107);
/*  7392 */     this.glMatrixLoadTranspose3x3fNV = pointerBuffer.get(2108);
/*  7393 */     this.glMatrixMult3x2fNV = pointerBuffer.get(2109);
/*  7394 */     this.glMatrixMult3x3fNV = pointerBuffer.get(2110);
/*  7395 */     this.glMatrixMultTranspose3x3fNV = pointerBuffer.get(2111);
/*  7396 */     this.glGetProgramResourcefvNV = pointerBuffer.get(2112);
/*  7397 */     this.glPixelDataRangeNV = pointerBuffer.get(2113);
/*  7398 */     this.glFlushPixelDataRangeNV = pointerBuffer.get(2114);
/*  7399 */     this.glPointParameteriNV = pointerBuffer.get(2115);
/*  7400 */     this.glPointParameterivNV = pointerBuffer.get(2116);
/*  7401 */     this.glPrimitiveRestartNV = pointerBuffer.get(2117);
/*  7402 */     this.glPrimitiveRestartIndexNV = pointerBuffer.get(2118);
/*  7403 */     this.glQueryResourceNV = pointerBuffer.get(2119);
/*  7404 */     this.glGenQueryResourceTagNV = pointerBuffer.get(2120);
/*  7405 */     this.glDeleteQueryResourceTagNV = pointerBuffer.get(2121);
/*  7406 */     this.glQueryResourceTagNV = pointerBuffer.get(2122);
/*  7407 */     this.glFramebufferSampleLocationsfvNV = pointerBuffer.get(2123);
/*  7408 */     this.glNamedFramebufferSampleLocationsfvNV = pointerBuffer.get(2124);
/*  7409 */     this.glResolveDepthValuesNV = pointerBuffer.get(2125);
/*  7410 */     this.glScissorExclusiveArrayvNV = pointerBuffer.get(2126);
/*  7411 */     this.glScissorExclusiveNV = pointerBuffer.get(2127);
/*  7412 */     this.glMakeBufferResidentNV = pointerBuffer.get(2128);
/*  7413 */     this.glMakeBufferNonResidentNV = pointerBuffer.get(2129);
/*  7414 */     this.glIsBufferResidentNV = pointerBuffer.get(2130);
/*  7415 */     this.glMakeNamedBufferResidentNV = pointerBuffer.get(2131);
/*  7416 */     this.glMakeNamedBufferNonResidentNV = pointerBuffer.get(2132);
/*  7417 */     this.glIsNamedBufferResidentNV = pointerBuffer.get(2133);
/*  7418 */     this.glGetBufferParameterui64vNV = pointerBuffer.get(2134);
/*  7419 */     this.glGetNamedBufferParameterui64vNV = pointerBuffer.get(2135);
/*  7420 */     this.glGetIntegerui64vNV = pointerBuffer.get(2136);
/*  7421 */     this.glUniformui64NV = pointerBuffer.get(2137);
/*  7422 */     this.glUniformui64vNV = pointerBuffer.get(2138);
/*  7423 */     this.glProgramUniformui64NV = pointerBuffer.get(2139);
/*  7424 */     this.glProgramUniformui64vNV = pointerBuffer.get(2140);
/*  7425 */     this.glBindShadingRateImageNV = pointerBuffer.get(2141);
/*  7426 */     this.glShadingRateImagePaletteNV = pointerBuffer.get(2142);
/*  7427 */     this.glGetShadingRateImagePaletteNV = pointerBuffer.get(2143);
/*  7428 */     this.glShadingRateImageBarrierNV = pointerBuffer.get(2144);
/*  7429 */     this.glShadingRateSampleOrderNV = pointerBuffer.get(2145);
/*  7430 */     this.glShadingRateSampleOrderCustomNV = pointerBuffer.get(2146);
/*  7431 */     this.glGetShadingRateSampleLocationivNV = pointerBuffer.get(2147);
/*  7432 */     this.glTextureBarrierNV = pointerBuffer.get(2148);
/*  7433 */     this.glTexImage2DMultisampleCoverageNV = pointerBuffer.get(2149);
/*  7434 */     this.glTexImage3DMultisampleCoverageNV = pointerBuffer.get(2150);
/*  7435 */     this.glTextureImage2DMultisampleNV = pointerBuffer.get(2151);
/*  7436 */     this.glTextureImage3DMultisampleNV = pointerBuffer.get(2152);
/*  7437 */     this.glTextureImage2DMultisampleCoverageNV = pointerBuffer.get(2153);
/*  7438 */     this.glTextureImage3DMultisampleCoverageNV = pointerBuffer.get(2154);
/*  7439 */     this.glCreateSemaphoresNV = pointerBuffer.get(2155);
/*  7440 */     this.glSemaphoreParameterivNV = pointerBuffer.get(2156);
/*  7441 */     this.glGetSemaphoreParameterivNV = pointerBuffer.get(2157);
/*  7442 */     this.glBeginTransformFeedbackNV = pointerBuffer.get(2158);
/*  7443 */     this.glEndTransformFeedbackNV = pointerBuffer.get(2159);
/*  7444 */     this.glTransformFeedbackAttribsNV = pointerBuffer.get(2160);
/*  7445 */     this.glBindBufferRangeNV = pointerBuffer.get(2161);
/*  7446 */     this.glBindBufferOffsetNV = pointerBuffer.get(2162);
/*  7447 */     this.glBindBufferBaseNV = pointerBuffer.get(2163);
/*  7448 */     this.glTransformFeedbackVaryingsNV = pointerBuffer.get(2164);
/*  7449 */     this.glActiveVaryingNV = pointerBuffer.get(2165);
/*  7450 */     this.glGetVaryingLocationNV = pointerBuffer.get(2166);
/*  7451 */     this.glGetActiveVaryingNV = pointerBuffer.get(2167);
/*  7452 */     this.glGetTransformFeedbackVaryingNV = pointerBuffer.get(2168);
/*  7453 */     this.glTransformFeedbackStreamAttribsNV = pointerBuffer.get(2169);
/*  7454 */     this.glBindTransformFeedbackNV = pointerBuffer.get(2170);
/*  7455 */     this.glDeleteTransformFeedbacksNV = pointerBuffer.get(2171);
/*  7456 */     this.glGenTransformFeedbacksNV = pointerBuffer.get(2172);
/*  7457 */     this.glIsTransformFeedbackNV = pointerBuffer.get(2173);
/*  7458 */     this.glPauseTransformFeedbackNV = pointerBuffer.get(2174);
/*  7459 */     this.glResumeTransformFeedbackNV = pointerBuffer.get(2175);
/*  7460 */     this.glDrawTransformFeedbackNV = pointerBuffer.get(2176);
/*  7461 */     this.glVertexArrayRangeNV = pointerBuffer.get(2177);
/*  7462 */     this.glFlushVertexArrayRangeNV = pointerBuffer.get(2178);
/*  7463 */     this.glVertexAttribL1i64NV = pointerBuffer.get(2179);
/*  7464 */     this.glVertexAttribL2i64NV = pointerBuffer.get(2180);
/*  7465 */     this.glVertexAttribL3i64NV = pointerBuffer.get(2181);
/*  7466 */     this.glVertexAttribL4i64NV = pointerBuffer.get(2182);
/*  7467 */     this.glVertexAttribL1i64vNV = pointerBuffer.get(2183);
/*  7468 */     this.glVertexAttribL2i64vNV = pointerBuffer.get(2184);
/*  7469 */     this.glVertexAttribL3i64vNV = pointerBuffer.get(2185);
/*  7470 */     this.glVertexAttribL4i64vNV = pointerBuffer.get(2186);
/*  7471 */     this.glVertexAttribL1ui64NV = pointerBuffer.get(2187);
/*  7472 */     this.glVertexAttribL2ui64NV = pointerBuffer.get(2188);
/*  7473 */     this.glVertexAttribL3ui64NV = pointerBuffer.get(2189);
/*  7474 */     this.glVertexAttribL4ui64NV = pointerBuffer.get(2190);
/*  7475 */     this.glVertexAttribL1ui64vNV = pointerBuffer.get(2191);
/*  7476 */     this.glVertexAttribL2ui64vNV = pointerBuffer.get(2192);
/*  7477 */     this.glVertexAttribL3ui64vNV = pointerBuffer.get(2193);
/*  7478 */     this.glVertexAttribL4ui64vNV = pointerBuffer.get(2194);
/*  7479 */     this.glGetVertexAttribLi64vNV = pointerBuffer.get(2195);
/*  7480 */     this.glGetVertexAttribLui64vNV = pointerBuffer.get(2196);
/*  7481 */     this.glVertexAttribLFormatNV = pointerBuffer.get(2197);
/*  7482 */     this.glBufferAddressRangeNV = pointerBuffer.get(2198);
/*  7483 */     this.glVertexFormatNV = pointerBuffer.get(2199);
/*  7484 */     this.glNormalFormatNV = pointerBuffer.get(2200);
/*  7485 */     this.glColorFormatNV = pointerBuffer.get(2201);
/*  7486 */     this.glIndexFormatNV = pointerBuffer.get(2202);
/*  7487 */     this.glTexCoordFormatNV = pointerBuffer.get(2203);
/*  7488 */     this.glEdgeFlagFormatNV = pointerBuffer.get(2204);
/*  7489 */     this.glSecondaryColorFormatNV = pointerBuffer.get(2205);
/*  7490 */     this.glFogCoordFormatNV = pointerBuffer.get(2206);
/*  7491 */     this.glVertexAttribFormatNV = pointerBuffer.get(2207);
/*  7492 */     this.glVertexAttribIFormatNV = pointerBuffer.get(2208);
/*  7493 */     this.glGetIntegerui64i_vNV = pointerBuffer.get(2209);
/*  7494 */     this.glViewportSwizzleNV = pointerBuffer.get(2210);
/*  7495 */     this.glBeginConditionalRenderNVX = pointerBuffer.get(2211);
/*  7496 */     this.glEndConditionalRenderNVX = pointerBuffer.get(2212);
/*  7497 */     this.glAsyncCopyImageSubDataNVX = pointerBuffer.get(2213);
/*  7498 */     this.glAsyncCopyBufferSubDataNVX = pointerBuffer.get(2214);
/*  7499 */     this.glUploadGpuMaskNVX = pointerBuffer.get(2215);
/*  7500 */     this.glMulticastViewportArrayvNVX = pointerBuffer.get(2216);
/*  7501 */     this.glMulticastScissorArrayvNVX = pointerBuffer.get(2217);
/*  7502 */     this.glMulticastViewportPositionWScaleNVX = pointerBuffer.get(2218);
/*  7503 */     this.glCreateProgressFenceNVX = pointerBuffer.get(2219);
/*  7504 */     this.glSignalSemaphoreui64NVX = pointerBuffer.get(2220);
/*  7505 */     this.glWaitSemaphoreui64NVX = pointerBuffer.get(2221);
/*  7506 */     this.glClientWaitSemaphoreui64NVX = pointerBuffer.get(2222);
/*  7507 */     this.glFramebufferTextureMultiviewOVR = pointerBuffer.get(2223);
/*  7508 */     this.glNamedFramebufferTextureMultiviewOVR = pointerBuffer.get(2224);
/*       */     
/*  7510 */     this.addresses = ThreadLocalUtil.setupAddressBuffer(pointerBuffer);
/*       */   }
/*       */ 
/*       */   
/*       */   public final PointerBuffer getAddressBuffer() {
/*  7515 */     return this.addresses;
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   public static void initialize() {}
/*       */ 
/*       */   
/*       */   private static boolean check_GL11(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet, boolean paramBoolean) {
/*  7524 */     if (!paramSet.contains("OpenGL11")) {
/*  7525 */       return false;
/*       */     }
/*       */     
/*  7528 */     byte b = (!paramBoolean || paramSet.contains("GL_NV_vertex_buffer_unified_memory")) ? 0 : -2147483648;
/*       */     
/*  7530 */     if (((paramBoolean || Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2, 3, 4, 5, 6, 8, 10, 11, 13, 16, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 52, 53, 54, 56, 64, 65, 66, 67, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 85, 86, 87, 88, 90, 93, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 110, 112, 113, 114, 115, 116, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 138, 140, 141, 142, 143, 144, 145, 146, 147, 148, 150, 151, 152, 153, 154, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 192, 193, 194, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 248, 249, 253, 254, 255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272, 273, 274, 275, 276, 277, 278, 279, 280, 281, 282, 283, 284, 285, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 308, 309, 310, 311, 312, 313, 314, 315, 316, 317, 318, 319, 320, 321, 322, 323, 324, 325, 326, 327, 328, 329, 330, 331, 332, 333, 334 }, new String[] { "glAccum", "glAlphaFunc", "glAreTexturesResident", "glArrayElement", "glBegin", "glBitmap", "glCallList", "glCallLists", "glClearAccum", "glClearIndex", "glClipPlane", "glColor3b", "glColor3s", "glColor3i", "glColor3f", "glColor3d", "glColor3ub", "glColor3us", "glColor3ui", "glColor3bv", "glColor3sv", "glColor3iv", "glColor3fv", "glColor3dv", "glColor3ubv", "glColor3usv", "glColor3uiv", "glColor4b", "glColor4s", "glColor4i", "glColor4f", "glColor4d", "glColor4ub", "glColor4us", "glColor4ui", "glColor4bv", "glColor4sv", "glColor4iv", "glColor4fv", "glColor4dv", "glColor4ubv", "glColor4usv", "glColor4uiv", "glColorMaterial", "glColorPointer", "glCopyPixels", "glDeleteLists", "glDrawPixels", "glEdgeFlag", "glEdgeFlagv", "glEdgeFlagPointer", "glEnd", "glEvalCoord1f", "glEvalCoord1fv", "glEvalCoord1d", "glEvalCoord1dv", "glEvalCoord2f", "glEvalCoord2fv", "glEvalCoord2d", "glEvalCoord2dv", "glEvalMesh1", "glEvalMesh2", "glEvalPoint1", "glEvalPoint2", "glFeedbackBuffer", "glFogi", "glFogiv", "glFogf", "glFogfv", "glGenLists", "glGetClipPlane", "glGetLightiv", "glGetLightfv", "glGetMapiv", "glGetMapfv", "glGetMapdv", "glGetMaterialiv", "glGetMaterialfv", "glGetPixelMapfv", "glGetPixelMapusv", "glGetPixelMapuiv", "glGetPolygonStipple", "glGetTexEnviv", "glGetTexEnvfv", "glGetTexGeniv", "glGetTexGenfv", "glGetTexGendv", "glIndexi", "glIndexub", "glIndexs", "glIndexf", "glIndexd", "glIndexiv", "glIndexubv", "glIndexsv", "glIndexfv", "glIndexdv", "glIndexMask", "glIndexPointer", "glInitNames", "glInterleavedArrays", "glIsList", "glLightModeli", "glLightModelf", "glLightModeliv", "glLightModelfv", "glLighti", "glLightf", "glLightiv", "glLightfv", "glLineStipple", "glListBase", "glLoadMatrixf", "glLoadMatrixd", "glLoadIdentity", "glLoadName", "glMap1f", "glMap1d", "glMap2f", "glMap2d", "glMapGrid1f", "glMapGrid1d", "glMapGrid2f", "glMapGrid2d", "glMateriali", "glMaterialf", "glMaterialiv", "glMaterialfv", "glMatrixMode", "glMultMatrixf", "glMultMatrixd", "glFrustum", "glNewList", "glEndList", "glNormal3f", "glNormal3b", "glNormal3s", "glNormal3i", "glNormal3d", "glNormal3fv", "glNormal3bv", "glNormal3sv", "glNormal3iv", "glNormal3dv", "glNormalPointer", "glOrtho", "glPassThrough", "glPixelMapfv", "glPixelMapusv", "glPixelMapuiv", "glPixelTransferi", "glPixelTransferf", "glPixelZoom", "glPolygonStipple", "glPushAttrib", "glPushClientAttrib", "glPopAttrib", "glPopClientAttrib", "glPopMatrix", "glPopName", "glPrioritizeTextures", "glPushMatrix", "glPushName", "glRasterPos2i", "glRasterPos2s", "glRasterPos2f", "glRasterPos2d", "glRasterPos2iv", "glRasterPos2sv", "glRasterPos2fv", "glRasterPos2dv", "glRasterPos3i", "glRasterPos3s", "glRasterPos3f", "glRasterPos3d", "glRasterPos3iv", "glRasterPos3sv", "glRasterPos3fv", "glRasterPos3dv", "glRasterPos4i", "glRasterPos4s", "glRasterPos4f", "glRasterPos4d", "glRasterPos4iv", "glRasterPos4sv", "glRasterPos4fv", "glRasterPos4dv", "glRecti", "glRects", "glRectf", "glRectd", "glRectiv", "glRectsv", "glRectfv", "glRectdv", "glRenderMode", "glRotatef", "glRotated", "glScalef", "glScaled", "glSelectBuffer", "glShadeModel", "glTexCoord1f", "glTexCoord1s", "glTexCoord1i", "glTexCoord1d", "glTexCoord1fv", "glTexCoord1sv", "glTexCoord1iv", "glTexCoord1dv", "glTexCoord2f", "glTexCoord2s", "glTexCoord2i", "glTexCoord2d", "glTexCoord2fv", "glTexCoord2sv", "glTexCoord2iv", "glTexCoord2dv", "glTexCoord3f", "glTexCoord3s", "glTexCoord3i", "glTexCoord3d", "glTexCoord3fv", "glTexCoord3sv", "glTexCoord3iv", "glTexCoord3dv", "glTexCoord4f", "glTexCoord4s", "glTexCoord4i", "glTexCoord4d", "glTexCoord4fv", "glTexCoord4sv", "glTexCoord4iv", "glTexCoord4dv", "glTexCoordPointer", "glTexEnvi", "glTexEnviv", "glTexEnvf", "glTexEnvfv", "glTexGeni", "glTexGeniv", "glTexGenf", "glTexGenfv", "glTexGend", "glTexGendv", "glTranslatef", "glTranslated", "glVertex2f", "glVertex2s", "glVertex2i", "glVertex2d", "glVertex2fv", "glVertex2sv", "glVertex2iv", "glVertex2dv", "glVertex3f", "glVertex3s", "glVertex3i", "glVertex3d", "glVertex3fv", "glVertex3sv", "glVertex3iv", "glVertex3dv", "glVertex4f", "glVertex4s", "glVertex4i", "glVertex4d", "glVertex4fv", "glVertex4sv", "glVertex4iv", "glVertex4dv", "glVertexPointer"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  7571 */         })) && Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 0, 1, 7, 9, 12, 14, 15, 17, 51, 55, 
/*       */           57, 58, 59, b + 60, 61, 62, 63, b + 68, 83, 84, 
/*       */           89, 91, 92, 94, 95, 96, 97, 98, 109, 111, 
/*       */           117, 118, 119, 120, 121, 122, 137, 139, 149, 155, 
/*       */           190, 191, 195, 196, 197, 232, 233, 247, 250, 251, 
/*       */           252, 296, 297, 298, 299, 300, 301, 302, 303, 304, 
/*       */           305, 306, 307, 335 }, new String[] { 
/*       */           "glEnable", "glDisable", "glBindTexture", "glBlendFunc", "glClear", "glClearColor", "glClearDepth", "glClearStencil", "glColorMask", "glCullFace", 
/*       */           "glDepthFunc", "glDepthMask", "glDepthRange", "glDisableClientState", "glDrawArrays", "glDrawBuffer", "glDrawElements", "glEnableClientState", "glFinish", "glFlush", 
/*       */           "glFrontFace", "glGenTextures", "glDeleteTextures", "glGetBooleanv", "glGetFloatv", "glGetIntegerv", "glGetDoublev", "glGetError", "glGetPointerv", "glGetString", 
/*       */           "glGetTexImage", "glGetTexLevelParameteriv", "glGetTexLevelParameterfv", "glGetTexParameteriv", "glGetTexParameterfv", "glHint", "glIsEnabled", "glIsTexture", "glLineWidth", "glLogicOp", 
/*       */           "glPixelStorei", "glPixelStoref", "glPointSize", "glPolygonMode", "glPolygonOffset", "glReadBuffer", "glReadPixels", "glScissor", "glStencilFunc", "glStencilMask", 
/*       */           "glStencilOp", "glTexImage1D", "glTexImage2D", "glCopyTexImage1D", "glCopyTexImage2D", "glCopyTexSubImage1D", "glCopyTexSubImage2D", "glTexParameteri", "glTexParameteriv", "glTexParameterf", 
/*  7584 */           "glTexParameterfv", "glTexSubImage1D", "glTexSubImage2D", "glViewport" })) || Checks.reportMissing("GL", "OpenGL11")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_GL12(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  7588 */     if (!paramSet.contains("OpenGL12")) {
/*  7589 */       return false;
/*       */     }
/*       */     
/*  7592 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 336, 337, 338, 339 }, new String[] { "glTexImage3D", "glTexSubImage3D", "glCopyTexSubImage3D", "glDrawRangeElements"
/*       */ 
/*       */ 
/*       */         
/*  7596 */         }) || Checks.reportMissing("GL", "OpenGL12")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_GL13(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet, boolean paramBoolean) {
/*  7600 */     if (!paramSet.contains("OpenGL13")) {
/*  7601 */       return false;
/*       */     }
/*       */     
/*  7604 */     if (((paramBoolean || Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360, 361, 362, 363, 364, 365, 366, 367, 368, 369, 370, 371, 372, 373, 374, 375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385 }, new String[] { "glClientActiveTexture", "glMultiTexCoord1f", "glMultiTexCoord1s", "glMultiTexCoord1i", "glMultiTexCoord1d", "glMultiTexCoord1fv", "glMultiTexCoord1sv", "glMultiTexCoord1iv", "glMultiTexCoord1dv", "glMultiTexCoord2f", "glMultiTexCoord2s", "glMultiTexCoord2i", "glMultiTexCoord2d", "glMultiTexCoord2fv", "glMultiTexCoord2sv", "glMultiTexCoord2iv", "glMultiTexCoord2dv", "glMultiTexCoord3f", "glMultiTexCoord3s", "glMultiTexCoord3i", "glMultiTexCoord3d", "glMultiTexCoord3fv", "glMultiTexCoord3sv", "glMultiTexCoord3iv", "glMultiTexCoord3dv", "glMultiTexCoord4f", "glMultiTexCoord4s", "glMultiTexCoord4i", "glMultiTexCoord4d", "glMultiTexCoord4fv", "glMultiTexCoord4sv", "glMultiTexCoord4iv", "glMultiTexCoord4dv", "glLoadTransposeMatrixf", "glLoadTransposeMatrixd", "glMultTransposeMatrixf", "glMultTransposeMatrixd"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  7615 */         })) && Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] {
/*       */           340, 341, 342, 343, 344, 345, 346, 347, 348 }, new String[] {
/*       */           
/*       */           "glCompressedTexImage3D", "glCompressedTexImage2D", "glCompressedTexImage1D", "glCompressedTexSubImage3D", "glCompressedTexSubImage2D", "glCompressedTexSubImage1D", "glGetCompressedTexImage", "glSampleCoverage", "glActiveTexture"
/*       */         
/*  7620 */         })) || Checks.reportMissing("GL", "OpenGL13")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_GL14(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet, boolean paramBoolean) {
/*  7624 */     if (!paramSet.contains("OpenGL14")) {
/*  7625 */       return false;
/*       */     }
/*       */     
/*  7628 */     if (((paramBoolean || Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 388, 389, 390, 391, 392, 399, 400, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 415, 417, 418, 419, 420, 421, 422, 423, 424, 425, 426, 427, 428, 429, 430, 431, 432 }, new String[] { "glFogCoordf", "glFogCoordd", "glFogCoordfv", "glFogCoorddv", "glFogCoordPointer", "glSecondaryColor3b", "glSecondaryColor3s", "glSecondaryColor3i", "glSecondaryColor3f", "glSecondaryColor3d", "glSecondaryColor3ub", "glSecondaryColor3us", "glSecondaryColor3ui", "glSecondaryColor3bv", "glSecondaryColor3sv", "glSecondaryColor3iv", "glSecondaryColor3fv", "glSecondaryColor3dv", "glSecondaryColor3ubv", "glSecondaryColor3usv", "glSecondaryColor3uiv", "glSecondaryColorPointer", "glWindowPos2i", "glWindowPos2s", "glWindowPos2f", "glWindowPos2d", "glWindowPos2iv", "glWindowPos2sv", "glWindowPos2fv", "glWindowPos2dv", "glWindowPos3i", "glWindowPos3s", "glWindowPos3f", "glWindowPos3d", "glWindowPos3iv", "glWindowPos3sv", "glWindowPos3fv", "glWindowPos3dv"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  7638 */         })) && Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] {
/*       */           386, 387, 393, 394, 395, 396, 397, 398, 416 }, new String[] {
/*       */           
/*       */           "glBlendColor", "glBlendEquation", "glMultiDrawArrays", "glMultiDrawElements", "glPointParameterf", "glPointParameteri", "glPointParameterfv", "glPointParameteriv", "glBlendFuncSeparate"
/*       */         
/*  7643 */         })) || Checks.reportMissing("GL", "OpenGL14")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_GL15(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  7647 */     if (!paramSet.contains("OpenGL15")) {
/*  7648 */       return false;
/*       */     }
/*       */     
/*  7651 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 433, 434, 435, 436, 437, 438, 439, 440, 441, 442, 443, 444, 445, 446, 447, 448, 449, 450, 451 }, new String[] { "glBindBuffer", "glDeleteBuffers", "glGenBuffers", "glIsBuffer", "glBufferData", "glBufferSubData", "glGetBufferSubData", "glMapBuffer", "glUnmapBuffer", "glGetBufferParameteriv", "glGetBufferPointerv", "glGenQueries", "glDeleteQueries", "glIsQuery", "glBeginQuery", "glEndQuery", "glGetQueryiv", "glGetQueryObjectiv", "glGetQueryObjectuiv"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  7657 */         }) || Checks.reportMissing("GL", "OpenGL15")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_GL20(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  7661 */     if (!paramSet.contains("OpenGL20")) {
/*  7662 */       return false;
/*       */     }
/*       */     
/*  7665 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 452, 453, 454, 455, 456, 457, 458, 459, 460, 461, 462, 463, 464, 465, 466, 467, 468, 469, 470, 471, 472, 473, 474, 475, 476, 477, 478, 479, 480, 481, 482, 483, 484, 485, 486, 487, 488, 489, 490, 491, 492, 493, 494, 495, 496, 497, 498, 499, 500, 501, 502, 503, 504, 505, 506, 507, 508, 509, 510, 511, 512, 513, 514, 515, 516, 517, 518, 519, 520, 521, 522, 523, 524, 525, 526, 527, 528, 529, 530, 531, 532, 533, 534, 535, 536, 537, 538, 539, 540, 541, 542, 543, 544 }, new String[] { "glCreateProgram", "glDeleteProgram", "glIsProgram", "glCreateShader", "glDeleteShader", "glIsShader", "glAttachShader", "glDetachShader", "glShaderSource", "glCompileShader", "glLinkProgram", "glUseProgram", "glValidateProgram", "glUniform1f", "glUniform2f", "glUniform3f", "glUniform4f", "glUniform1i", "glUniform2i", "glUniform3i", "glUniform4i", "glUniform1fv", "glUniform2fv", "glUniform3fv", "glUniform4fv", "glUniform1iv", "glUniform2iv", "glUniform3iv", "glUniform4iv", "glUniformMatrix2fv", "glUniformMatrix3fv", "glUniformMatrix4fv", "glGetShaderiv", "glGetProgramiv", "glGetShaderInfoLog", "glGetProgramInfoLog", "glGetAttachedShaders", "glGetUniformLocation", "glGetActiveUniform", "glGetUniformfv", "glGetUniformiv", "glGetShaderSource", "glVertexAttrib1f", "glVertexAttrib1s", "glVertexAttrib1d", "glVertexAttrib2f", "glVertexAttrib2s", "glVertexAttrib2d", "glVertexAttrib3f", "glVertexAttrib3s", "glVertexAttrib3d", "glVertexAttrib4f", "glVertexAttrib4s", "glVertexAttrib4d", "glVertexAttrib4Nub", "glVertexAttrib1fv", "glVertexAttrib1sv", "glVertexAttrib1dv", "glVertexAttrib2fv", "glVertexAttrib2sv", "glVertexAttrib2dv", "glVertexAttrib3fv", "glVertexAttrib3sv", "glVertexAttrib3dv", "glVertexAttrib4fv", "glVertexAttrib4sv", "glVertexAttrib4dv", "glVertexAttrib4iv", "glVertexAttrib4bv", "glVertexAttrib4ubv", "glVertexAttrib4usv", "glVertexAttrib4uiv", "glVertexAttrib4Nbv", "glVertexAttrib4Nsv", "glVertexAttrib4Niv", "glVertexAttrib4Nubv", "glVertexAttrib4Nusv", "glVertexAttrib4Nuiv", "glVertexAttribPointer", "glEnableVertexAttribArray", "glDisableVertexAttribArray", "glBindAttribLocation", "glGetActiveAttrib", "glGetAttribLocation", "glGetVertexAttribiv", "glGetVertexAttribfv", "glGetVertexAttribdv", "glGetVertexAttribPointerv", "glDrawBuffers", "glBlendEquationSeparate", "glStencilOpSeparate", "glStencilFuncSeparate", "glStencilMaskSeparate"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  7685 */         }) || Checks.reportMissing("GL", "OpenGL20")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_GL21(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  7689 */     if (!paramSet.contains("OpenGL21")) {
/*  7690 */       return false;
/*       */     }
/*       */     
/*  7693 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 545, 546, 547, 548, 549, 550 }, new String[] { "glUniformMatrix2x3fv", "glUniformMatrix3x2fv", "glUniformMatrix2x4fv", "glUniformMatrix4x2fv", "glUniformMatrix3x4fv", "glUniformMatrix4x3fv"
/*       */ 
/*       */ 
/*       */         
/*  7697 */         }) || Checks.reportMissing("GL", "OpenGL21")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_GL30(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  7701 */     if (!paramSet.contains("OpenGL30")) {
/*  7702 */       return false;
/*       */     }
/*       */     
/*  7705 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 551, 552, 553, 554, 555, 556, 557, 558, 559, 560, 561, 562, 563, 564, 565, 566, 567, 568, 569, 570, 571, 572, 573, 574, 575, 576, 577, 578, 579, 580, 581, 582, 583, 584, 585, 586, 587, 588, 589, 590, 591, 592, 593, 594, 595, 596, 597, 598, 599, 600, 601, 602, 603, 604, 605, 606, 607, 608, 609, 610, 611, 612, 613, 614, 615, 616, 617, 618, 619, 620, 621, 622, 623, 624, 625, 626, 627, 628, 629, 630, 631, 632, 633, 634 }, new String[] { "glGetStringi", "glClearBufferiv", "glClearBufferuiv", "glClearBufferfv", "glClearBufferfi", "glVertexAttribI1i", "glVertexAttribI2i", "glVertexAttribI3i", "glVertexAttribI4i", "glVertexAttribI1ui", "glVertexAttribI2ui", "glVertexAttribI3ui", "glVertexAttribI4ui", "glVertexAttribI1iv", "glVertexAttribI2iv", "glVertexAttribI3iv", "glVertexAttribI4iv", "glVertexAttribI1uiv", "glVertexAttribI2uiv", "glVertexAttribI3uiv", "glVertexAttribI4uiv", "glVertexAttribI4bv", "glVertexAttribI4sv", "glVertexAttribI4ubv", "glVertexAttribI4usv", "glVertexAttribIPointer", "glGetVertexAttribIiv", "glGetVertexAttribIuiv", "glUniform1ui", "glUniform2ui", "glUniform3ui", "glUniform4ui", "glUniform1uiv", "glUniform2uiv", "glUniform3uiv", "glUniform4uiv", "glGetUniformuiv", "glBindFragDataLocation", "glGetFragDataLocation", "glBeginConditionalRender", "glEndConditionalRender", "glMapBufferRange", "glFlushMappedBufferRange", "glClampColor", "glIsRenderbuffer", "glBindRenderbuffer", "glDeleteRenderbuffers", "glGenRenderbuffers", "glRenderbufferStorage", "glRenderbufferStorageMultisample", "glGetRenderbufferParameteriv", "glIsFramebuffer", "glBindFramebuffer", "glDeleteFramebuffers", "glGenFramebuffers", "glCheckFramebufferStatus", "glFramebufferTexture1D", "glFramebufferTexture2D", "glFramebufferTexture3D", "glFramebufferTextureLayer", "glFramebufferRenderbuffer", "glGetFramebufferAttachmentParameteriv", "glBlitFramebuffer", "glGenerateMipmap", "glTexParameterIiv", "glTexParameterIuiv", "glGetTexParameterIiv", "glGetTexParameterIuiv", "glColorMaski", "glGetBooleani_v", "glGetIntegeri_v", "glEnablei", "glDisablei", "glIsEnabledi", "glBindBufferRange", "glBindBufferBase", "glBeginTransformFeedback", "glEndTransformFeedback", "glTransformFeedbackVaryings", "glGetTransformFeedbackVarying", "glBindVertexArray", "glDeleteVertexArrays", "glGenVertexArrays", "glIsVertexArray"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  7724 */         }) || Checks.reportMissing("GL", "OpenGL30")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_GL31(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  7728 */     if (!paramSet.contains("OpenGL31")) {
/*  7729 */       return false;
/*       */     }
/*       */     
/*  7732 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 635, 636, 637, 638, 639, 640, 641, 642, 643, 644, 645, 646 }, new String[] { "glDrawArraysInstanced", "glDrawElementsInstanced", "glCopyBufferSubData", "glPrimitiveRestartIndex", "glTexBuffer", "glGetUniformIndices", "glGetActiveUniformsiv", "glGetActiveUniformName", "glGetUniformBlockIndex", "glGetActiveUniformBlockiv", "glGetActiveUniformBlockName", "glUniformBlockBinding"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  7738 */         }) || Checks.reportMissing("GL", "OpenGL31")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_GL32(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  7742 */     if (!paramSet.contains("OpenGL32")) {
/*  7743 */       return false;
/*       */     }
/*       */     
/*  7746 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 647, 648, 649, 650, 651, 652, 653, 654, 655, 656, 657, 658, 659, 660, 661, 662, 663, 664, 665 }, new String[] { "glGetBufferParameteri64v", "glDrawElementsBaseVertex", "glDrawRangeElementsBaseVertex", "glDrawElementsInstancedBaseVertex", "glMultiDrawElementsBaseVertex", "glProvokingVertex", "glTexImage2DMultisample", "glTexImage3DMultisample", "glGetMultisamplefv", "glSampleMaski", "glFramebufferTexture", "glFenceSync", "glIsSync", "glDeleteSync", "glClientWaitSync", "glWaitSync", "glGetInteger64v", "glGetInteger64i_v", "glGetSynciv"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  7753 */         }) || Checks.reportMissing("GL", "OpenGL32")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_GL33(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet, boolean paramBoolean) {
/*  7757 */     if (!paramSet.contains("OpenGL33")) {
/*  7758 */       return false;
/*       */     }
/*       */     
/*  7761 */     if (((paramBoolean || Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 686, 687, 688, 689, 690, 691, 692, 693, 694, 695, 696, 697, 698, 699, 700, 701, 702, 703, 704, 705, 706, 707, 708, 709, 710, 711, 712, 713, 714, 715 }, new String[] { "glVertexP2ui", "glVertexP3ui", "glVertexP4ui", "glVertexP2uiv", "glVertexP3uiv", "glVertexP4uiv", "glTexCoordP1ui", "glTexCoordP2ui", "glTexCoordP3ui", "glTexCoordP4ui", "glTexCoordP1uiv", "glTexCoordP2uiv", "glTexCoordP3uiv", "glTexCoordP4uiv", "glMultiTexCoordP1ui", "glMultiTexCoordP2ui", "glMultiTexCoordP3ui", "glMultiTexCoordP4ui", "glMultiTexCoordP1uiv", "glMultiTexCoordP2uiv", "glMultiTexCoordP3uiv", "glMultiTexCoordP4uiv", "glNormalP3ui", "glNormalP3uiv", "glColorP3ui", "glColorP4ui", "glColorP3uiv", "glColorP4uiv", "glSecondaryColorP3ui", "glSecondaryColorP3uiv"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  7770 */         })) && Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 
/*       */           666, 667, 668, 669, 670, 671, 672, 673, 674, 675,
/*       */           
/*       */           676, 677, 678, 679, 680, 681, 682, 683, 684, 685, 
/*       */           716, 717, 718, 719, 720, 721, 722, 723
/*       */         }, new String[] { 
/*       */           "glBindFragDataLocationIndexed", "glGetFragDataIndex", "glGenSamplers", "glDeleteSamplers", "glIsSampler", "glBindSampler", "glSamplerParameteri", "glSamplerParameterf", "glSamplerParameteriv", "glSamplerParameterfv", 
/*       */           "glSamplerParameterIiv", "glSamplerParameterIuiv", "glGetSamplerParameteriv", "glGetSamplerParameterfv", "glGetSamplerParameterIiv", "glGetSamplerParameterIuiv", "glQueryCounter", "glGetQueryObjecti64v", "glGetQueryObjectui64v", "glVertexAttribDivisor", 
/*  7778 */           "glVertexAttribP1ui", "glVertexAttribP2ui", "glVertexAttribP3ui", "glVertexAttribP4ui", "glVertexAttribP1uiv", "glVertexAttribP2uiv", "glVertexAttribP3uiv", "glVertexAttribP4uiv" })) || Checks.reportMissing("GL", "OpenGL33")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_GL40(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  7782 */     if (!paramSet.contains("OpenGL40")) {
/*  7783 */       return false;
/*       */     }
/*       */     
/*  7786 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 724, 725, 726, 727, 728, 729, 730, 731, 732, 733, 734, 735, 736, 737, 738, 739, 740, 741, 742, 743, 744, 745, 746, 747, 748, 749, 750, 751, 752, 753, 754, 755, 756, 757, 758, 759, 760, 761, 762, 763, 764, 765, 766, 767, 768, 769 }, new String[] { "glBlendEquationi", "glBlendEquationSeparatei", "glBlendFunci", "glBlendFuncSeparatei", "glDrawArraysIndirect", "glDrawElementsIndirect", "glUniform1d", "glUniform2d", "glUniform3d", "glUniform4d", "glUniform1dv", "glUniform2dv", "glUniform3dv", "glUniform4dv", "glUniformMatrix2dv", "glUniformMatrix3dv", "glUniformMatrix4dv", "glUniformMatrix2x3dv", "glUniformMatrix2x4dv", "glUniformMatrix3x2dv", "glUniformMatrix3x4dv", "glUniformMatrix4x2dv", "glUniformMatrix4x3dv", "glGetUniformdv", "glMinSampleShading", "glGetSubroutineUniformLocation", "glGetSubroutineIndex", "glGetActiveSubroutineUniformiv", "glGetActiveSubroutineUniformName", "glGetActiveSubroutineName", "glUniformSubroutinesuiv", "glGetUniformSubroutineuiv", "glGetProgramStageiv", "glPatchParameteri", "glPatchParameterfv", "glBindTransformFeedback", "glDeleteTransformFeedbacks", "glGenTransformFeedbacks", "glIsTransformFeedback", "glPauseTransformFeedback", "glResumeTransformFeedback", "glDrawTransformFeedback", "glDrawTransformFeedbackStream", "glBeginQueryIndexed", "glEndQueryIndexed", "glGetQueryIndexediv"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  7798 */         }) || Checks.reportMissing("GL", "OpenGL40")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_GL41(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  7802 */     if (!paramSet.contains("OpenGL41")) {
/*  7803 */       return false;
/*       */     }
/*       */     
/*  7806 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 770, 771, 772, 773, 774, 775, 776, 777, 778, 779, 780, 781, 782, 783, 784, 785, 786, 787, 788, 789, 790, 791, 792, 793, 794, 795, 796, 797, 798, 799, 800, 801, 802, 803, 804, 805, 806, 807, 808, 809, 810, 811, 812, 813, 814, 815, 816, 817, 818, 819, 820, 821, 822, 823, 824, 825, 826, 827, 828, 829, 830, 831, 832, 833, 834, 835, 836, 837, 838, 839, 840, 841, 842, 843, 844, 845, 846, 847, 848, 849, 850, 851, 852, 853, 854, 855, 856, 857 }, new String[] { "glReleaseShaderCompiler", "glShaderBinary", "glGetShaderPrecisionFormat", "glDepthRangef", "glClearDepthf", "glGetProgramBinary", "glProgramBinary", "glProgramParameteri", "glUseProgramStages", "glActiveShaderProgram", "glCreateShaderProgramv", "glBindProgramPipeline", "glDeleteProgramPipelines", "glGenProgramPipelines", "glIsProgramPipeline", "glGetProgramPipelineiv", "glProgramUniform1i", "glProgramUniform2i", "glProgramUniform3i", "glProgramUniform4i", "glProgramUniform1ui", "glProgramUniform2ui", "glProgramUniform3ui", "glProgramUniform4ui", "glProgramUniform1f", "glProgramUniform2f", "glProgramUniform3f", "glProgramUniform4f", "glProgramUniform1d", "glProgramUniform2d", "glProgramUniform3d", "glProgramUniform4d", "glProgramUniform1iv", "glProgramUniform2iv", "glProgramUniform3iv", "glProgramUniform4iv", "glProgramUniform1uiv", "glProgramUniform2uiv", "glProgramUniform3uiv", "glProgramUniform4uiv", "glProgramUniform1fv", "glProgramUniform2fv", "glProgramUniform3fv", "glProgramUniform4fv", "glProgramUniform1dv", "glProgramUniform2dv", "glProgramUniform3dv", "glProgramUniform4dv", "glProgramUniformMatrix2fv", "glProgramUniformMatrix3fv", "glProgramUniformMatrix4fv", "glProgramUniformMatrix2dv", "glProgramUniformMatrix3dv", "glProgramUniformMatrix4dv", "glProgramUniformMatrix2x3fv", "glProgramUniformMatrix3x2fv", "glProgramUniformMatrix2x4fv", "glProgramUniformMatrix4x2fv", "glProgramUniformMatrix3x4fv", "glProgramUniformMatrix4x3fv", "glProgramUniformMatrix2x3dv", "glProgramUniformMatrix3x2dv", "glProgramUniformMatrix2x4dv", "glProgramUniformMatrix4x2dv", "glProgramUniformMatrix3x4dv", "glProgramUniformMatrix4x3dv", "glValidateProgramPipeline", "glGetProgramPipelineInfoLog", "glVertexAttribL1d", "glVertexAttribL2d", "glVertexAttribL3d", "glVertexAttribL4d", "glVertexAttribL1dv", "glVertexAttribL2dv", "glVertexAttribL3dv", "glVertexAttribL4dv", "glVertexAttribLPointer", "glGetVertexAttribLdv", "glViewportArrayv", "glViewportIndexedf", "glViewportIndexedfv", "glScissorArrayv", "glScissorIndexed", "glScissorIndexedv", "glDepthRangeArrayv", "glDepthRangeIndexed", "glGetFloati_v", "glGetDoublei_v"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  7828 */         }) || Checks.reportMissing("GL", "OpenGL41")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_GL42(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  7832 */     if (!paramSet.contains("OpenGL42")) {
/*  7833 */       return false;
/*       */     }
/*       */     
/*  7836 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 858, 859, 860, 861, 862, 863, 864, 865, 866, 867, 868, 869 }, new String[] { "glGetActiveAtomicCounterBufferiv", "glTexStorage1D", "glTexStorage2D", "glTexStorage3D", "glDrawTransformFeedbackInstanced", "glDrawTransformFeedbackStreamInstanced", "glDrawArraysInstancedBaseInstance", "glDrawElementsInstancedBaseInstance", "glDrawElementsInstancedBaseVertexBaseInstance", "glBindImageTexture", "glMemoryBarrier", "glGetInternalformativ"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  7842 */         }) || Checks.reportMissing("GL", "OpenGL42")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_GL43(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  7846 */     if (!paramSet.contains("OpenGL43")) {
/*  7847 */       return false;
/*       */     }
/*       */     
/*  7850 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 870, 871, 872, 873, 874, 875, 876, 877, 878, 879, 880, 881, 882, 883, 884, 885, 886, 887, 888, 889, 890, 891, 892, 893, 894, 895, 896, 897, 898, 899, 900, 901, 902, 903, 904, 905, 906, 907, 908, 909, 910, 911, 912 }, new String[] { "glClearBufferData", "glClearBufferSubData", "glDispatchCompute", "glDispatchComputeIndirect", "glCopyImageSubData", "glDebugMessageControl", "glDebugMessageInsert", "glDebugMessageCallback", "glGetDebugMessageLog", "glPushDebugGroup", "glPopDebugGroup", "glObjectLabel", "glGetObjectLabel", "glObjectPtrLabel", "glGetObjectPtrLabel", "glFramebufferParameteri", "glGetFramebufferParameteriv", "glGetInternalformati64v", "glInvalidateTexSubImage", "glInvalidateTexImage", "glInvalidateBufferSubData", "glInvalidateBufferData", "glInvalidateFramebuffer", "glInvalidateSubFramebuffer", "glMultiDrawArraysIndirect", "glMultiDrawElementsIndirect", "glGetProgramInterfaceiv", "glGetProgramResourceIndex", "glGetProgramResourceName", "glGetProgramResourceiv", "glGetProgramResourceLocation", "glGetProgramResourceLocationIndex", "glShaderStorageBlockBinding", "glTexBufferRange", "glTexStorage2DMultisample", "glTexStorage3DMultisample", "glTextureView", "glBindVertexBuffer", "glVertexAttribFormat", "glVertexAttribIFormat", "glVertexAttribLFormat", "glVertexAttribBinding", "glVertexBindingDivisor"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  7862 */         }) || Checks.reportMissing("GL", "OpenGL43")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_GL44(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  7866 */     if (!paramSet.contains("OpenGL44")) {
/*  7867 */       return false;
/*       */     }
/*       */     
/*  7870 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 913, 914, 915, 916, 917, 918, 919, 920, 921 }, new String[] { "glBufferStorage", "glClearTexSubImage", "glClearTexImage", "glBindBuffersBase", "glBindBuffersRange", "glBindTextures", "glBindSamplers", "glBindImageTextures", "glBindVertexBuffers"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  7875 */         }) || Checks.reportMissing("GL", "OpenGL44")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_GL45(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  7879 */     if (!paramSet.contains("OpenGL45")) {
/*  7880 */       return false;
/*       */     }
/*       */     
/*  7883 */     paramFunctionProvider.getFunctionAddress("glGetMapdv");
/*  7884 */     paramFunctionProvider.getFunctionAddress("glGetMapfv");
/*  7885 */     paramFunctionProvider.getFunctionAddress("glGetMapiv");
/*  7886 */     paramFunctionProvider.getFunctionAddress("glGetPixelMapfv");
/*  7887 */     paramFunctionProvider.getFunctionAddress("glGetPixelMapuiv");
/*  7888 */     paramFunctionProvider.getFunctionAddress("glGetPixelMapusv");
/*  7889 */     paramFunctionProvider.getFunctionAddress("glGetPolygonStipple");
/*  7890 */     if (paramSet.contains("GL_ARB_imaging")) paramFunctionProvider.getFunctionAddress("glGetColorTable"); 
/*  7891 */     if (paramSet.contains("GL_ARB_imaging")) paramFunctionProvider.getFunctionAddress("glGetConvolutionFilter"); 
/*  7892 */     if (paramSet.contains("GL_ARB_imaging")) paramFunctionProvider.getFunctionAddress("glGetSeparableFilter"); 
/*  7893 */     if (paramSet.contains("GL_ARB_imaging")) paramFunctionProvider.getFunctionAddress("glGetHistogram"); 
/*  7894 */     if (paramSet.contains("GL_ARB_imaging")) paramFunctionProvider.getFunctionAddress("glGetMinmax");
/*       */     
/*  7896 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 922, 923, 924, 925, 926, 927, 928, 929, 930, 931, 932, 933, 934, 935, 936, 937, 938, 939, 940, 941, 942, 943, 944, 945, 946, 947, 948, 949, 950, 951, 952, 953, 954, 955, 956, 957, 958, 959, 960, 961, 962, 963, 964, 965, 966, 967, 968, 969, 970, 971, 972, 973, 974, 975, 976, 977, 978, 979, 980, 981, 982, 983, 984, 985, 986, 987, 988, 989, 990, 991, 992, 993, 994, 995, 996, 997, 998, 999, 1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010, 1011, 1012, 1013, 1014, 1015, 1016, 1017, 1018, 1019, 1020, 1021, 1022, 1023, 1024, 1033, 1040, 1042, 1043 }, new String[] { "glClipControl", "glCreateTransformFeedbacks", "glTransformFeedbackBufferBase", "glTransformFeedbackBufferRange", "glGetTransformFeedbackiv", "glGetTransformFeedbacki_v", "glGetTransformFeedbacki64_v", "glCreateBuffers", "glNamedBufferStorage", "glNamedBufferData", "glNamedBufferSubData", "glCopyNamedBufferSubData", "glClearNamedBufferData", "glClearNamedBufferSubData", "glMapNamedBuffer", "glMapNamedBufferRange", "glUnmapNamedBuffer", "glFlushMappedNamedBufferRange", "glGetNamedBufferParameteriv", "glGetNamedBufferParameteri64v", "glGetNamedBufferPointerv", "glGetNamedBufferSubData", "glCreateFramebuffers", "glNamedFramebufferRenderbuffer", "glNamedFramebufferParameteri", "glNamedFramebufferTexture", "glNamedFramebufferTextureLayer", "glNamedFramebufferDrawBuffer", "glNamedFramebufferDrawBuffers", "glNamedFramebufferReadBuffer", "glInvalidateNamedFramebufferData", "glInvalidateNamedFramebufferSubData", "glClearNamedFramebufferiv", "glClearNamedFramebufferuiv", "glClearNamedFramebufferfv", "glClearNamedFramebufferfi", "glBlitNamedFramebuffer", "glCheckNamedFramebufferStatus", "glGetNamedFramebufferParameteriv", "glGetNamedFramebufferAttachmentParameteriv", "glCreateRenderbuffers", "glNamedRenderbufferStorage", "glNamedRenderbufferStorageMultisample", "glGetNamedRenderbufferParameteriv", "glCreateTextures", "glTextureBuffer", "glTextureBufferRange", "glTextureStorage1D", "glTextureStorage2D", "glTextureStorage3D", "glTextureStorage2DMultisample", "glTextureStorage3DMultisample", "glTextureSubImage1D", "glTextureSubImage2D", "glTextureSubImage3D", "glCompressedTextureSubImage1D", "glCompressedTextureSubImage2D", "glCompressedTextureSubImage3D", "glCopyTextureSubImage1D", "glCopyTextureSubImage2D", "glCopyTextureSubImage3D", "glTextureParameterf", "glTextureParameterfv", "glTextureParameteri", "glTextureParameterIiv", "glTextureParameterIuiv", "glTextureParameteriv", "glGenerateTextureMipmap", "glBindTextureUnit", "glGetTextureImage", "glGetCompressedTextureImage", "glGetTextureLevelParameterfv", "glGetTextureLevelParameteriv", "glGetTextureParameterfv", "glGetTextureParameterIiv", "glGetTextureParameterIuiv", "glGetTextureParameteriv", "glCreateVertexArrays", "glDisableVertexArrayAttrib", "glEnableVertexArrayAttrib", "glVertexArrayElementBuffer", "glVertexArrayVertexBuffer", "glVertexArrayVertexBuffers", "glVertexArrayAttribFormat", "glVertexArrayAttribIFormat", "glVertexArrayAttribLFormat", "glVertexArrayAttribBinding", "glVertexArrayBindingDivisor", "glGetVertexArrayiv", "glGetVertexArrayIndexediv", "glGetVertexArrayIndexed64iv", "glCreateSamplers", "glCreateProgramPipelines", "glCreateQueries", "glGetQueryBufferObjectiv", "glGetQueryBufferObjectuiv", "glGetQueryBufferObjecti64v", "glGetQueryBufferObjectui64v", "glMemoryBarrierByRegion", "glGetTextureSubImage", "glGetCompressedTextureSubImage", "glTextureBarrier", "glGetGraphicsResetStatus", "glReadnPixels", "glGetnUniformfv", "glGetnUniformiv", "glGetnUniformuiv"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  7924 */         }) || Checks.reportMissing("GL", "OpenGL45")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_GL46(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  7928 */     if (!paramSet.contains("OpenGL46")) {
/*  7929 */       return false;
/*       */     }
/*       */     
/*  7932 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1044, 1045, 1046, 1047 }, new String[] { "glMultiDrawArraysIndirectCount", "glMultiDrawElementsIndirectCount", "glPolygonOffsetClamp", "glSpecializeShader"
/*       */ 
/*       */ 
/*       */         
/*  7936 */         }) || Checks.reportMissing("GL", "OpenGL46")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_AMD_debug_output(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  7940 */     if (!paramSet.contains("GL_AMD_debug_output")) {
/*  7941 */       return false;
/*       */     }
/*       */     
/*  7944 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1048, 1049, 1050, 1051 }, new String[] { "glDebugMessageEnableAMD", "glDebugMessageInsertAMD", "glDebugMessageCallbackAMD", "glGetDebugMessageLogAMD"
/*       */ 
/*       */ 
/*       */         
/*  7948 */         }) || Checks.reportMissing("GL", "GL_AMD_debug_output")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_AMD_draw_buffers_blend(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  7952 */     if (!paramSet.contains("GL_AMD_draw_buffers_blend")) {
/*  7953 */       return false;
/*       */     }
/*       */     
/*  7956 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1052, 1053, 1054, 1055 }, new String[] { "glBlendFuncIndexedAMD", "glBlendFuncSeparateIndexedAMD", "glBlendEquationIndexedAMD", "glBlendEquationSeparateIndexedAMD"
/*       */ 
/*       */ 
/*       */         
/*  7960 */         }) || Checks.reportMissing("GL", "GL_AMD_draw_buffers_blend")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_AMD_framebuffer_multisample_advanced(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  7964 */     if (!paramSet.contains("GL_AMD_framebuffer_multisample_advanced")) {
/*  7965 */       return false;
/*       */     }
/*       */     
/*  7968 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1056, 1057 }, new String[] { "glRenderbufferStorageMultisampleAdvancedAMD", "glNamedRenderbufferStorageMultisampleAdvancedAMD"
/*       */ 
/*       */ 
/*       */         
/*  7972 */         }) || Checks.reportMissing("GL", "GL_AMD_framebuffer_multisample_advanced")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_AMD_gpu_shader_int64(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  7976 */     if (!paramSet.contains("GL_AMD_gpu_shader_int64")) {
/*  7977 */       return false;
/*       */     }
/*       */     
/*  7980 */     byte b = paramSet.contains("GL_EXT_direct_state_access") ? 0 : -2147483648;
/*       */     
/*  7982 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1058, 1059, 1060, 1061, 1062, 1063, 1064, 1065, 1066, 1067, 1068, 1069, 1070, 1071, 1072, 1073, 1074, 1075, b + 1076, b + 1077, b + 1078, b + 1079, b + 1080, b + 1081, b + 1082, b + 1083, b + 1084, b + 1085, b + 1086, b + 1087, b + 1088, b + 1089, b + 1090, b + 1091 }, new String[] { "glUniform1i64NV", "glUniform2i64NV", "glUniform3i64NV", "glUniform4i64NV", "glUniform1i64vNV", "glUniform2i64vNV", "glUniform3i64vNV", "glUniform4i64vNV", "glUniform1ui64NV", "glUniform2ui64NV", "glUniform3ui64NV", "glUniform4ui64NV", "glUniform1ui64vNV", "glUniform2ui64vNV", "glUniform3ui64vNV", "glUniform4ui64vNV", "glGetUniformi64vNV", "glGetUniformui64vNV", "glProgramUniform1i64NV", "glProgramUniform2i64NV", "glProgramUniform3i64NV", "glProgramUniform4i64NV", "glProgramUniform1i64vNV", "glProgramUniform2i64vNV", "glProgramUniform3i64vNV", "glProgramUniform4i64vNV", "glProgramUniform1ui64NV", "glProgramUniform2ui64NV", "glProgramUniform3ui64NV", "glProgramUniform4ui64NV", "glProgramUniform1ui64vNV", "glProgramUniform2ui64vNV", "glProgramUniform3ui64vNV", "glProgramUniform4ui64vNV"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  7993 */         }) || Checks.reportMissing("GL", "GL_AMD_gpu_shader_int64")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_AMD_interleaved_elements(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  7997 */     if (!paramSet.contains("GL_AMD_interleaved_elements")) {
/*  7998 */       return false;
/*       */     }
/*       */     
/*  8001 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1092 }, new String[] { "glVertexAttribParameteriAMD"
/*       */ 
/*       */ 
/*       */         
/*  8005 */         }) || Checks.reportMissing("GL", "GL_AMD_interleaved_elements")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_AMD_occlusion_query_event(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8009 */     if (!paramSet.contains("GL_AMD_occlusion_query_event")) {
/*  8010 */       return false;
/*       */     }
/*       */     
/*  8013 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1093 }, new String[] { "glQueryObjectParameteruiAMD"
/*       */ 
/*       */ 
/*       */         
/*  8017 */         }) || Checks.reportMissing("GL", "GL_AMD_occlusion_query_event")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_AMD_performance_monitor(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8021 */     if (!paramSet.contains("GL_AMD_performance_monitor")) {
/*  8022 */       return false;
/*       */     }
/*       */     
/*  8025 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1094, 1095, 1096, 1097, 1098, 1099, 1100, 1101, 1102, 1103, 1104 }, new String[] { "glGetPerfMonitorGroupsAMD", "glGetPerfMonitorCountersAMD", "glGetPerfMonitorGroupStringAMD", "glGetPerfMonitorCounterStringAMD", "glGetPerfMonitorCounterInfoAMD", "glGenPerfMonitorsAMD", "glDeletePerfMonitorsAMD", "glSelectPerfMonitorCountersAMD", "glBeginPerfMonitorAMD", "glEndPerfMonitorAMD", "glGetPerfMonitorCounterDataAMD"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8031 */         }) || Checks.reportMissing("GL", "GL_AMD_performance_monitor")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_AMD_sample_positions(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8035 */     if (!paramSet.contains("GL_AMD_sample_positions")) {
/*  8036 */       return false;
/*       */     }
/*       */     
/*  8039 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1105 }, new String[] { "glSetMultisamplefvAMD"
/*       */ 
/*       */ 
/*       */         
/*  8043 */         }) || Checks.reportMissing("GL", "GL_AMD_sample_positions")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_AMD_sparse_texture(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8047 */     if (!paramSet.contains("GL_AMD_sparse_texture")) {
/*  8048 */       return false;
/*       */     }
/*       */     
/*  8051 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1106, 1107 }, new String[] { "glTexStorageSparseAMD", "glTextureStorageSparseAMD"
/*       */ 
/*       */ 
/*       */         
/*  8055 */         }) || Checks.reportMissing("GL", "GL_AMD_sparse_texture")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_AMD_stencil_operation_extended(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8059 */     if (!paramSet.contains("GL_AMD_stencil_operation_extended")) {
/*  8060 */       return false;
/*       */     }
/*       */     
/*  8063 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1108 }, new String[] { "glStencilOpValueAMD"
/*       */ 
/*       */ 
/*       */         
/*  8067 */         }) || Checks.reportMissing("GL", "GL_AMD_stencil_operation_extended")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_AMD_vertex_shader_tessellator(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8071 */     if (!paramSet.contains("GL_AMD_vertex_shader_tessellator")) {
/*  8072 */       return false;
/*       */     }
/*       */     
/*  8075 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1109, 1110 }, new String[] { "glTessellationFactorAMD", "glTessellationModeAMD"
/*       */ 
/*       */ 
/*       */         
/*  8079 */         }) || Checks.reportMissing("GL", "GL_AMD_vertex_shader_tessellator")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_base_instance(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8083 */     if (!paramSet.contains("GL_ARB_base_instance")) {
/*  8084 */       return false;
/*       */     }
/*       */     
/*  8087 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 864, 865, 866 }, new String[] { "glDrawArraysInstancedBaseInstance", "glDrawElementsInstancedBaseInstance", "glDrawElementsInstancedBaseVertexBaseInstance"
/*       */ 
/*       */ 
/*       */         
/*  8091 */         }) || Checks.reportMissing("GL", "GL_ARB_base_instance")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_bindless_texture(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8095 */     if (!paramSet.contains("GL_ARB_bindless_texture")) {
/*  8096 */       return false;
/*       */     }
/*       */     
/*  8099 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1111, 1112, 1113, 1114, 1115, 1116, 1117, 1118, 1119, 1120, 1121, 1122, 1123, 1124, 1125, 1126 }, new String[] { "glGetTextureHandleARB", "glGetTextureSamplerHandleARB", "glMakeTextureHandleResidentARB", "glMakeTextureHandleNonResidentARB", "glGetImageHandleARB", "glMakeImageHandleResidentARB", "glMakeImageHandleNonResidentARB", "glUniformHandleui64ARB", "glUniformHandleui64vARB", "glProgramUniformHandleui64ARB", "glProgramUniformHandleui64vARB", "glIsTextureHandleResidentARB", "glIsImageHandleResidentARB", "glVertexAttribL1ui64ARB", "glVertexAttribL1ui64vARB", "glGetVertexAttribLui64vARB"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8106 */         }) || Checks.reportMissing("GL", "GL_ARB_bindless_texture")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_blend_func_extended(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8110 */     if (!paramSet.contains("GL_ARB_blend_func_extended")) {
/*  8111 */       return false;
/*       */     }
/*       */     
/*  8114 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 666, 667 }, new String[] { "glBindFragDataLocationIndexed", "glGetFragDataIndex"
/*       */ 
/*       */ 
/*       */         
/*  8118 */         }) || Checks.reportMissing("GL", "GL_ARB_blend_func_extended")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_buffer_storage(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8122 */     if (!paramSet.contains("GL_ARB_buffer_storage")) {
/*  8123 */       return false;
/*       */     }
/*       */     
/*  8126 */     byte b = paramSet.contains("GL_EXT_direct_state_access") ? 0 : -2147483648;
/*       */     
/*  8128 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 913, b + 1127 }, new String[] { "glBufferStorage", "glNamedBufferStorageEXT"
/*       */ 
/*       */ 
/*       */         
/*  8132 */         }) || Checks.reportMissing("GL", "GL_ARB_buffer_storage")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_cl_event(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8136 */     if (!paramSet.contains("GL_ARB_cl_event")) {
/*  8137 */       return false;
/*       */     }
/*       */     
/*  8140 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1128 }, new String[] { "glCreateSyncFromCLeventARB"
/*       */ 
/*       */ 
/*       */         
/*  8144 */         }) || Checks.reportMissing("GL", "GL_ARB_cl_event")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_clear_buffer_object(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8148 */     if (!paramSet.contains("GL_ARB_clear_buffer_object")) {
/*  8149 */       return false;
/*       */     }
/*       */     
/*  8152 */     byte b = paramSet.contains("GL_EXT_direct_state_access") ? 0 : -2147483648;
/*       */     
/*  8154 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 870, 871, b + 1129, b + 1130 }, new String[] { "glClearBufferData", "glClearBufferSubData", "glClearNamedBufferDataEXT", "glClearNamedBufferSubDataEXT"
/*       */ 
/*       */ 
/*       */         
/*  8158 */         }) || Checks.reportMissing("GL", "GL_ARB_clear_buffer_object")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_clear_texture(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8162 */     if (!paramSet.contains("GL_ARB_clear_texture")) {
/*  8163 */       return false;
/*       */     }
/*       */     
/*  8166 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 914, 915 }, new String[] { "glClearTexSubImage", "glClearTexImage"
/*       */ 
/*       */ 
/*       */         
/*  8170 */         }) || Checks.reportMissing("GL", "GL_ARB_clear_texture")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_clip_control(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8174 */     if (!paramSet.contains("GL_ARB_clip_control")) {
/*  8175 */       return false;
/*       */     }
/*       */     
/*  8178 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 922 }, new String[] { "glClipControl"
/*       */ 
/*       */ 
/*       */         
/*  8182 */         }) || Checks.reportMissing("GL", "GL_ARB_clip_control")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_color_buffer_float(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8186 */     if (!paramSet.contains("GL_ARB_color_buffer_float")) {
/*  8187 */       return false;
/*       */     }
/*       */     
/*  8190 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1131 }, new String[] { "glClampColorARB"
/*       */ 
/*       */ 
/*       */         
/*  8194 */         }) || Checks.reportMissing("GL", "GL_ARB_color_buffer_float")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_compute_shader(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8198 */     if (!paramSet.contains("GL_ARB_compute_shader")) {
/*  8199 */       return false;
/*       */     }
/*       */     
/*  8202 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 872, 873 }, new String[] { "glDispatchCompute", "glDispatchComputeIndirect"
/*       */ 
/*       */ 
/*       */         
/*  8206 */         }) || Checks.reportMissing("GL", "GL_ARB_compute_shader")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_compute_variable_group_size(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8210 */     if (!paramSet.contains("GL_ARB_compute_variable_group_size")) {
/*  8211 */       return false;
/*       */     }
/*       */     
/*  8214 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1132 }, new String[] { "glDispatchComputeGroupSizeARB"
/*       */ 
/*       */ 
/*       */         
/*  8218 */         }) || Checks.reportMissing("GL", "GL_ARB_compute_variable_group_size")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_copy_buffer(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8222 */     if (!paramSet.contains("GL_ARB_copy_buffer")) {
/*  8223 */       return false;
/*       */     }
/*       */     
/*  8226 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 637 }, new String[] { "glCopyBufferSubData"
/*       */ 
/*       */ 
/*       */         
/*  8230 */         }) || Checks.reportMissing("GL", "GL_ARB_copy_buffer")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_copy_image(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8234 */     if (!paramSet.contains("GL_ARB_copy_image")) {
/*  8235 */       return false;
/*       */     }
/*       */     
/*  8238 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 874 }, new String[] { "glCopyImageSubData"
/*       */ 
/*       */ 
/*       */         
/*  8242 */         }) || Checks.reportMissing("GL", "GL_ARB_copy_image")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_debug_output(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8246 */     if (!paramSet.contains("GL_ARB_debug_output")) {
/*  8247 */       return false;
/*       */     }
/*       */     
/*  8250 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1133, 1134, 1135, 1136 }, new String[] { "glDebugMessageControlARB", "glDebugMessageInsertARB", "glDebugMessageCallbackARB", "glGetDebugMessageLogARB"
/*       */ 
/*       */ 
/*       */         
/*  8254 */         }) || Checks.reportMissing("GL", "GL_ARB_debug_output")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_direct_state_access(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8258 */     if (!paramSet.contains("GL_ARB_direct_state_access")) {
/*  8259 */       return false;
/*       */     }
/*       */     
/*  8262 */     byte b2 = ARB_transform_feedback2(paramSet) ? 0 : -2147483648;
/*  8263 */     byte b3 = ARB_uniform_buffer_object(paramSet) ? 0 : -2147483648;
/*  8264 */     byte b4 = ARB_buffer_storage(paramSet) ? 0 : -2147483648;
/*  8265 */     byte b5 = ARB_copy_buffer(paramSet) ? 0 : -2147483648;
/*  8266 */     byte b6 = ARB_clear_texture(paramSet) ? 0 : -2147483648;
/*  8267 */     byte b7 = ARB_map_buffer_range(paramSet) ? 0 : -2147483648;
/*  8268 */     byte b8 = ARB_framebuffer_object(paramSet) ? 0 : -2147483648;
/*  8269 */     byte b9 = ARB_framebuffer_no_attachments(paramSet) ? 0 : -2147483648;
/*  8270 */     byte b10 = ARB_invalidate_subdata(paramSet) ? 0 : -2147483648;
/*  8271 */     byte b11 = ARB_texture_buffer_object(paramSet) ? 0 : -2147483648;
/*  8272 */     byte b12 = ARB_texture_buffer_range(paramSet) ? 0 : -2147483648;
/*  8273 */     byte b13 = ARB_texture_storage(paramSet) ? 0 : -2147483648;
/*  8274 */     byte b14 = ARB_texture_storage_multisample(paramSet) ? 0 : -2147483648;
/*  8275 */     byte b15 = ARB_vertex_array_object(paramSet) ? 0 : -2147483648;
/*  8276 */     byte b16 = ARB_vertex_attrib_binding(paramSet) ? 0 : -2147483648;
/*  8277 */     byte b17 = ARB_multi_bind(paramSet) ? 0 : -2147483648;
/*  8278 */     byte b18 = ARB_sampler_objects(paramSet) ? 0 : -2147483648;
/*  8279 */     byte b19 = ARB_separate_shader_objects(paramSet) ? 0 : -2147483648;
/*  8280 */     byte b1 = ARB_query_buffer_object(paramSet) ? 0 : -2147483648;
/*       */     
/*  8282 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { b2 + 923, b3 + 924, b3 + 925, b2 + 926, b2 + 927, b2 + 928, 929, b4 + 930, 931, 932, b5 + 933, b6 + 934, b6 + 935, 936, b7 + 937, 938, b7 + 939, 940, 941, 942, 943, b8 + 944, b8 + 945, b9 + 946, b8 + 947, b8 + 948, b8 + 949, b8 + 950, b8 + 951, b10 + 952, b10 + 953, b8 + 954, b8 + 955, b8 + 956, b8 + 957, b8 + 958, b8 + 959, b9 + 960, b8 + 961, b8 + 962, b8 + 963, b8 + 964, b8 + 965, 966, b11 + 967, b12 + 968, b13 + 969, b13 + 970, b13 + 971, b14 + 972, b14 + 973, 974, 975, 976, 977, 978, 979, 980, 981, 982, 983, 984, 985, 986, 987, 988, b8 + 989, 990, 991, 992, 993, 994, 995, 996, 997, 998, b15 + 999, b15 + 1000, b15 + 1001, b15 + 1002, b16 + 1003, b17 + 1004, b16 + 1005, b16 + 1006, b16 + 1007, b16 + 1008, b16 + 1009, b15 + 1010, b15 + 1011, b15 + 1012, b18 + 1013, b19 + 1014, 1015, b1 + 1018, b1 + 1016, b1 + 1019, b1 + 1017 }, new String[] { "glCreateTransformFeedbacks", "glTransformFeedbackBufferBase", "glTransformFeedbackBufferRange", "glGetTransformFeedbackiv", "glGetTransformFeedbacki_v", "glGetTransformFeedbacki64_v", "glCreateBuffers", "glNamedBufferStorage", "glNamedBufferData", "glNamedBufferSubData", "glCopyNamedBufferSubData", "glClearNamedBufferData", "glClearNamedBufferSubData", "glMapNamedBuffer", "glMapNamedBufferRange", "glUnmapNamedBuffer", "glFlushMappedNamedBufferRange", "glGetNamedBufferParameteriv", "glGetNamedBufferParameteri64v", "glGetNamedBufferPointerv", "glGetNamedBufferSubData", "glCreateFramebuffers", "glNamedFramebufferRenderbuffer", "glNamedFramebufferParameteri", "glNamedFramebufferTexture", "glNamedFramebufferTextureLayer", "glNamedFramebufferDrawBuffer", "glNamedFramebufferDrawBuffers", "glNamedFramebufferReadBuffer", "glInvalidateNamedFramebufferData", "glInvalidateNamedFramebufferSubData", "glClearNamedFramebufferiv", "glClearNamedFramebufferuiv", "glClearNamedFramebufferfv", "glClearNamedFramebufferfi", "glBlitNamedFramebuffer", "glCheckNamedFramebufferStatus", "glGetNamedFramebufferParameteriv", "glGetNamedFramebufferAttachmentParameteriv", "glCreateRenderbuffers", "glNamedRenderbufferStorage", "glNamedRenderbufferStorageMultisample", "glGetNamedRenderbufferParameteriv", "glCreateTextures", "glTextureBuffer", "glTextureBufferRange", "glTextureStorage1D", "glTextureStorage2D", "glTextureStorage3D", "glTextureStorage2DMultisample", "glTextureStorage3DMultisample", "glTextureSubImage1D", "glTextureSubImage2D", "glTextureSubImage3D", "glCompressedTextureSubImage1D", "glCompressedTextureSubImage2D", "glCompressedTextureSubImage3D", "glCopyTextureSubImage1D", "glCopyTextureSubImage2D", "glCopyTextureSubImage3D", "glTextureParameterf", "glTextureParameterfv", "glTextureParameteri", "glTextureParameterIiv", "glTextureParameterIuiv", "glTextureParameteriv", "glGenerateTextureMipmap", "glBindTextureUnit", "glGetTextureImage", "glGetCompressedTextureImage", "glGetTextureLevelParameterfv", "glGetTextureLevelParameteriv", "glGetTextureParameterfv", "glGetTextureParameterIiv", "glGetTextureParameterIuiv", "glGetTextureParameteriv", "glCreateVertexArrays", "glDisableVertexArrayAttrib", "glEnableVertexArrayAttrib", "glVertexArrayElementBuffer", "glVertexArrayVertexBuffer", "glVertexArrayVertexBuffers", "glVertexArrayAttribFormat", "glVertexArrayAttribIFormat", "glVertexArrayAttribLFormat", "glVertexArrayAttribBinding", "glVertexArrayBindingDivisor", "glGetVertexArrayiv", "glGetVertexArrayIndexediv", "glGetVertexArrayIndexed64iv", "glCreateSamplers", "glCreateProgramPipelines", "glCreateQueries", "glGetQueryBufferObjecti64v", "glGetQueryBufferObjectiv", "glGetQueryBufferObjectui64v", "glGetQueryBufferObjectuiv"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8313 */         }) || Checks.reportMissing("GL", "GL_ARB_direct_state_access")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_draw_buffers(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8317 */     if (!paramSet.contains("GL_ARB_draw_buffers")) {
/*  8318 */       return false;
/*       */     }
/*       */     
/*  8321 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1137 }, new String[] { "glDrawBuffersARB"
/*       */ 
/*       */ 
/*       */         
/*  8325 */         }) || Checks.reportMissing("GL", "GL_ARB_draw_buffers")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_draw_buffers_blend(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8329 */     if (!paramSet.contains("GL_ARB_draw_buffers_blend")) {
/*  8330 */       return false;
/*       */     }
/*       */     
/*  8333 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1138, 1139, 1140, 1141 }, new String[] { "glBlendEquationiARB", "glBlendEquationSeparateiARB", "glBlendFunciARB", "glBlendFuncSeparateiARB"
/*       */ 
/*       */ 
/*       */         
/*  8337 */         }) || Checks.reportMissing("GL", "GL_ARB_draw_buffers_blend")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_draw_elements_base_vertex(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8341 */     if (!paramSet.contains("GL_ARB_draw_elements_base_vertex")) {
/*  8342 */       return false;
/*       */     }
/*       */     
/*  8345 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 648, 649, 650, 651 }, new String[] { "glDrawElementsBaseVertex", "glDrawRangeElementsBaseVertex", "glDrawElementsInstancedBaseVertex", "glMultiDrawElementsBaseVertex"
/*       */ 
/*       */ 
/*       */         
/*  8349 */         }) || Checks.reportMissing("GL", "GL_ARB_draw_elements_base_vertex")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_draw_indirect(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8353 */     if (!paramSet.contains("GL_ARB_draw_indirect")) {
/*  8354 */       return false;
/*       */     }
/*       */     
/*  8357 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 728, 729 }, new String[] { "glDrawArraysIndirect", "glDrawElementsIndirect"
/*       */ 
/*       */ 
/*       */         
/*  8361 */         }) || Checks.reportMissing("GL", "GL_ARB_draw_indirect")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_draw_instanced(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8365 */     if (!paramSet.contains("GL_ARB_draw_instanced")) {
/*  8366 */       return false;
/*       */     }
/*       */     
/*  8369 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1142, 1143 }, new String[] { "glDrawArraysInstancedARB", "glDrawElementsInstancedARB"
/*       */ 
/*       */ 
/*       */         
/*  8373 */         }) || Checks.reportMissing("GL", "GL_ARB_draw_instanced")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_ES2_compatibility(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8377 */     if (!paramSet.contains("GL_ARB_ES2_compatibility")) {
/*  8378 */       return false;
/*       */     }
/*       */     
/*  8381 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 770, 771, 772, 773, 774 }, new String[] { "glReleaseShaderCompiler", "glShaderBinary", "glGetShaderPrecisionFormat", "glDepthRangef", "glClearDepthf"
/*       */ 
/*       */ 
/*       */         
/*  8385 */         }) || Checks.reportMissing("GL", "GL_ARB_ES2_compatibility")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_ES3_1_compatibility(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8389 */     if (!paramSet.contains("GL_ARB_ES3_1_compatibility")) {
/*  8390 */       return false;
/*       */     }
/*       */     
/*  8393 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1020 }, new String[] { "glMemoryBarrierByRegion"
/*       */ 
/*       */ 
/*       */         
/*  8397 */         }) || Checks.reportMissing("GL", "GL_ARB_ES3_1_compatibility")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_ES3_2_compatibility(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8401 */     if (!paramSet.contains("GL_ARB_ES3_2_compatibility")) {
/*  8402 */       return false;
/*       */     }
/*       */     
/*  8405 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1144 }, new String[] { "glPrimitiveBoundingBoxARB"
/*       */ 
/*       */ 
/*       */         
/*  8409 */         }) || Checks.reportMissing("GL", "GL_ARB_ES3_2_compatibility")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_framebuffer_no_attachments(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8413 */     if (!paramSet.contains("GL_ARB_framebuffer_no_attachments")) {
/*  8414 */       return false;
/*       */     }
/*       */     
/*  8417 */     byte b = paramSet.contains("GL_EXT_direct_state_access") ? 0 : -2147483648;
/*       */     
/*  8419 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 885, 886, b + 1145, b + 1146 }, new String[] { "glFramebufferParameteri", "glGetFramebufferParameteriv", "glNamedFramebufferParameteriEXT", "glGetNamedFramebufferParameterivEXT"
/*       */ 
/*       */ 
/*       */         
/*  8423 */         }) || Checks.reportMissing("GL", "GL_ARB_framebuffer_no_attachments")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_framebuffer_object(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8427 */     if (!paramSet.contains("GL_ARB_framebuffer_object")) {
/*  8428 */       return false;
/*       */     }
/*       */     
/*  8431 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 595, 596, 597, 598, 599, 600, 601, 602, 603, 604, 605, 606, 607, 608, 609, 610, 611, 612, 613, 614 }, new String[] { "glIsRenderbuffer", "glBindRenderbuffer", "glDeleteRenderbuffers", "glGenRenderbuffers", "glRenderbufferStorage", "glRenderbufferStorageMultisample", "glGetRenderbufferParameteriv", "glIsFramebuffer", "glBindFramebuffer", "glDeleteFramebuffers", "glGenFramebuffers", "glCheckFramebufferStatus", "glFramebufferTexture1D", "glFramebufferTexture2D", "glFramebufferTexture3D", "glFramebufferTextureLayer", "glFramebufferRenderbuffer", "glGetFramebufferAttachmentParameteriv", "glBlitFramebuffer", "glGenerateMipmap"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8438 */         }) || Checks.reportMissing("GL", "GL_ARB_framebuffer_object")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_geometry_shader4(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8442 */     if (!paramSet.contains("GL_ARB_geometry_shader4")) {
/*  8443 */       return false;
/*       */     }
/*       */     
/*  8446 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1147, 1148, 1149, 1150 }, new String[] { "glProgramParameteriARB", "glFramebufferTextureARB", "glFramebufferTextureLayerARB", "glFramebufferTextureFaceARB"
/*       */ 
/*       */ 
/*       */         
/*  8450 */         }) || Checks.reportMissing("GL", "GL_ARB_geometry_shader4")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_get_program_binary(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8454 */     if (!paramSet.contains("GL_ARB_get_program_binary")) {
/*  8455 */       return false;
/*       */     }
/*       */     
/*  8458 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 775, 776, 777 }, new String[] { "glGetProgramBinary", "glProgramBinary", "glProgramParameteri"
/*       */ 
/*       */ 
/*       */         
/*  8462 */         }) || Checks.reportMissing("GL", "GL_ARB_get_program_binary")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_get_texture_sub_image(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8466 */     if (!paramSet.contains("GL_ARB_get_texture_sub_image")) {
/*  8467 */       return false;
/*       */     }
/*       */     
/*  8470 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1021, 1022 }, new String[] { "glGetTextureSubImage", "glGetCompressedTextureSubImage"
/*       */ 
/*       */ 
/*       */         
/*  8474 */         }) || Checks.reportMissing("GL", "GL_ARB_get_texture_sub_image")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_gl_spirv(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8478 */     if (!paramSet.contains("GL_ARB_gl_spirv")) {
/*  8479 */       return false;
/*       */     }
/*       */     
/*  8482 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1151 }, new String[] { "glSpecializeShaderARB"
/*       */ 
/*       */ 
/*       */         
/*  8486 */         }) || Checks.reportMissing("GL", "GL_ARB_gl_spirv")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_gpu_shader_fp64(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8490 */     if (!paramSet.contains("GL_ARB_gpu_shader_fp64")) {
/*  8491 */       return false;
/*       */     }
/*       */     
/*  8494 */     paramSet.contains("GL_EXT_direct_state_access");
/*       */     
/*  8496 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 730, 731, 732, 733, 734, 735, 736, 737, 738, 739, 740, 741, 742, 743, 744, 745, 746, 747 }, new String[] { "glUniform1d", "glUniform2d", "glUniform3d", "glUniform4d", "glUniform1dv", "glUniform2dv", "glUniform3dv", "glUniform4dv", "glUniformMatrix2dv", "glUniformMatrix3dv", "glUniformMatrix4dv", "glUniformMatrix2x3dv", "glUniformMatrix2x4dv", "glUniformMatrix3x2dv", "glUniformMatrix3x4dv", "glUniformMatrix4x2dv", "glUniformMatrix4x3dv", "glGetUniformdv"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8502 */         }) || Checks.reportMissing("GL", "GL_ARB_gpu_shader_fp64")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_gpu_shader_int64(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8506 */     if (!paramSet.contains("GL_ARB_gpu_shader_int64")) {
/*  8507 */       return false;
/*       */     }
/*       */     
/*  8510 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1169, 1170, 1171, 1172, 1173, 1174, 1175, 1176, 1177, 1178, 1179, 1180, 1181, 1182, 1183, 1184, 1185, 1186, 1187, 1188, 1189, 1190, 1191, 1192, 1193, 1194, 1195, 1196, 1197, 1198, 1199, 1200, 1201, 1202, 1203, 1204 }, new String[] { "glUniform1i64ARB", "glUniform1i64vARB", "glProgramUniform1i64ARB", "glProgramUniform1i64vARB", "glUniform2i64ARB", "glUniform2i64vARB", "glProgramUniform2i64ARB", "glProgramUniform2i64vARB", "glUniform3i64ARB", "glUniform3i64vARB", "glProgramUniform3i64ARB", "glProgramUniform3i64vARB", "glUniform4i64ARB", "glUniform4i64vARB", "glProgramUniform4i64ARB", "glProgramUniform4i64vARB", "glUniform1ui64ARB", "glUniform1ui64vARB", "glProgramUniform1ui64ARB", "glProgramUniform1ui64vARB", "glUniform2ui64ARB", "glUniform2ui64vARB", "glProgramUniform2ui64ARB", "glProgramUniform2ui64vARB", "glUniform3ui64ARB", "glUniform3ui64vARB", "glProgramUniform3ui64ARB", "glProgramUniform3ui64vARB", "glUniform4ui64ARB", "glUniform4ui64vARB", "glProgramUniform4ui64ARB", "glProgramUniform4ui64vARB", "glGetUniformi64vARB", "glGetUniformui64vARB", "glGetnUniformi64vARB", "glGetnUniformui64vARB"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8521 */         }) || Checks.reportMissing("GL", "GL_ARB_gpu_shader_int64")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_imaging(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet, boolean paramBoolean) {
/*  8525 */     if (!paramSet.contains("GL_ARB_imaging")) {
/*  8526 */       return false;
/*       */     }
/*       */     
/*  8529 */     if (((paramBoolean || Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1205, 1206, 1207, 1208, 1209, 1210, 1211, 1212, 1213, 1214, 1215, 1216, 1217, 1218, 1219, 1220, 1221, 1222, 1223, 1224, 1225, 1226, 1227, 1228, 1229, 1230, 1231, 1232, 1233, 1234, 1235, 1236 }, new String[] { "glColorTable", "glCopyColorTable", "glColorTableParameteriv", "glColorTableParameterfv", "glGetColorTable", "glGetColorTableParameteriv", "glGetColorTableParameterfv", "glColorSubTable", "glCopyColorSubTable", "glConvolutionFilter1D", "glConvolutionFilter2D", "glCopyConvolutionFilter1D", "glCopyConvolutionFilter2D", "glGetConvolutionFilter", "glSeparableFilter2D", "glGetSeparableFilter", "glConvolutionParameteri", "glConvolutionParameteriv", "glConvolutionParameterf", "glConvolutionParameterfv", "glGetConvolutionParameteriv", "glGetConvolutionParameterfv", "glHistogram", "glResetHistogram", "glGetHistogram", "glGetHistogramParameteriv", "glGetHistogramParameterfv", "glMinmax", "glResetMinmax", "glGetMinmax", "glGetMinmaxParameteriv", "glGetMinmaxParameterfv"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8539 */         })) && Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] {
/*       */           386, 387 }, new String[] {
/*       */           "glBlendColor", "glBlendEquation"
/*       */         
/*  8543 */         })) || Checks.reportMissing("GL", "GL_ARB_imaging")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_indirect_parameters(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8547 */     if (!paramSet.contains("GL_ARB_indirect_parameters")) {
/*  8548 */       return false;
/*       */     }
/*       */     
/*  8551 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1237, 1238 }, new String[] { "glMultiDrawArraysIndirectCountARB", "glMultiDrawElementsIndirectCountARB"
/*       */ 
/*       */ 
/*       */         
/*  8555 */         }) || Checks.reportMissing("GL", "GL_ARB_indirect_parameters")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_instanced_arrays(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8559 */     if (!paramSet.contains("GL_ARB_instanced_arrays")) {
/*  8560 */       return false;
/*       */     }
/*       */     
/*  8563 */     paramSet.contains("GL_EXT_direct_state_access");
/*       */     
/*  8565 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1239 }, new String[] { "glVertexAttribDivisorARB"
/*       */ 
/*       */ 
/*       */         
/*  8569 */         }) || Checks.reportMissing("GL", "GL_ARB_instanced_arrays")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_internalformat_query(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8573 */     if (!paramSet.contains("GL_ARB_internalformat_query")) {
/*  8574 */       return false;
/*       */     }
/*       */     
/*  8577 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 869 }, new String[] { "glGetInternalformativ"
/*       */ 
/*       */ 
/*       */         
/*  8581 */         }) || Checks.reportMissing("GL", "GL_ARB_internalformat_query")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_internalformat_query2(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8585 */     if (!paramSet.contains("GL_ARB_internalformat_query2")) {
/*  8586 */       return false;
/*       */     }
/*       */     
/*  8589 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 887 }, new String[] { "glGetInternalformati64v"
/*       */ 
/*       */ 
/*       */         
/*  8593 */         }) || Checks.reportMissing("GL", "GL_ARB_internalformat_query2")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_invalidate_subdata(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8597 */     if (!paramSet.contains("GL_ARB_invalidate_subdata")) {
/*  8598 */       return false;
/*       */     }
/*       */     
/*  8601 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 888, 889, 890, 891, 892, 893 }, new String[] { "glInvalidateTexSubImage", "glInvalidateTexImage", "glInvalidateBufferSubData", "glInvalidateBufferData", "glInvalidateFramebuffer", "glInvalidateSubFramebuffer"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8606 */         }) || Checks.reportMissing("GL", "GL_ARB_invalidate_subdata")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_map_buffer_range(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8610 */     if (!paramSet.contains("GL_ARB_map_buffer_range")) {
/*  8611 */       return false;
/*       */     }
/*       */     
/*  8614 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 592, 593 }, new String[] { "glMapBufferRange", "glFlushMappedBufferRange"
/*       */ 
/*       */ 
/*       */         
/*  8618 */         }) || Checks.reportMissing("GL", "GL_ARB_map_buffer_range")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_matrix_palette(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8622 */     if (!paramSet.contains("GL_ARB_matrix_palette")) {
/*  8623 */       return false;
/*       */     }
/*       */     
/*  8626 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1241, 1242, 1243, 1244, 1245 }, new String[] { "glCurrentPaletteMatrixARB", "glMatrixIndexuivARB", "glMatrixIndexubvARB", "glMatrixIndexusvARB", "glMatrixIndexPointerARB"
/*       */ 
/*       */ 
/*       */         
/*  8630 */         }) || Checks.reportMissing("GL", "GL_ARB_matrix_palette")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_multi_bind(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8634 */     if (!paramSet.contains("GL_ARB_multi_bind")) {
/*  8635 */       return false;
/*       */     }
/*       */     
/*  8638 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 916, 917, 918, 919, 920, 921 }, new String[] { "glBindBuffersBase", "glBindBuffersRange", "glBindTextures", "glBindSamplers", "glBindImageTextures", "glBindVertexBuffers"
/*       */ 
/*       */ 
/*       */         
/*  8642 */         }) || Checks.reportMissing("GL", "GL_ARB_multi_bind")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_multi_draw_indirect(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8646 */     if (!paramSet.contains("GL_ARB_multi_draw_indirect")) {
/*  8647 */       return false;
/*       */     }
/*       */     
/*  8650 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 894, 895 }, new String[] { "glMultiDrawArraysIndirect", "glMultiDrawElementsIndirect"
/*       */ 
/*       */ 
/*       */         
/*  8654 */         }) || Checks.reportMissing("GL", "GL_ARB_multi_draw_indirect")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_multisample(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8658 */     if (!paramSet.contains("GL_ARB_multisample")) {
/*  8659 */       return false;
/*       */     }
/*       */     
/*  8662 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1246 }, new String[] { "glSampleCoverageARB"
/*       */ 
/*       */ 
/*       */         
/*  8666 */         }) || Checks.reportMissing("GL", "GL_ARB_multisample")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_multitexture(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8670 */     if (!paramSet.contains("GL_ARB_multitexture")) {
/*  8671 */       return false;
/*       */     }
/*       */     
/*  8674 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1247, 1248, 1249, 1250, 1251, 1252, 1253, 1254, 1255, 1256, 1257, 1258, 1259, 1260, 1261, 1262, 1263, 1264, 1265, 1266, 1267, 1268, 1269, 1270, 1271, 1272, 1273, 1274, 1275, 1276, 1277, 1278, 1279, 1280 }, new String[] { "glActiveTextureARB", "glClientActiveTextureARB", "glMultiTexCoord1fARB", "glMultiTexCoord1sARB", "glMultiTexCoord1iARB", "glMultiTexCoord1dARB", "glMultiTexCoord1fvARB", "glMultiTexCoord1svARB", "glMultiTexCoord1ivARB", "glMultiTexCoord1dvARB", "glMultiTexCoord2fARB", "glMultiTexCoord2sARB", "glMultiTexCoord2iARB", "glMultiTexCoord2dARB", "glMultiTexCoord2fvARB", "glMultiTexCoord2svARB", "glMultiTexCoord2ivARB", "glMultiTexCoord2dvARB", "glMultiTexCoord3fARB", "glMultiTexCoord3sARB", "glMultiTexCoord3iARB", "glMultiTexCoord3dARB", "glMultiTexCoord3fvARB", "glMultiTexCoord3svARB", "glMultiTexCoord3ivARB", "glMultiTexCoord3dvARB", "glMultiTexCoord4fARB", "glMultiTexCoord4sARB", "glMultiTexCoord4iARB", "glMultiTexCoord4dARB", "glMultiTexCoord4fvARB", "glMultiTexCoord4svARB", "glMultiTexCoord4ivARB", "glMultiTexCoord4dvARB"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8684 */         }) || Checks.reportMissing("GL", "GL_ARB_multitexture")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_occlusion_query(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8688 */     if (!paramSet.contains("GL_ARB_occlusion_query")) {
/*  8689 */       return false;
/*       */     }
/*       */     
/*  8692 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1281, 1282, 1283, 1284, 1285, 1286, 1287, 1288 }, new String[] { "glGenQueriesARB", "glDeleteQueriesARB", "glIsQueryARB", "glBeginQueryARB", "glEndQueryARB", "glGetQueryivARB", "glGetQueryObjectivARB", "glGetQueryObjectuivARB"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8697 */         }) || Checks.reportMissing("GL", "GL_ARB_occlusion_query")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_parallel_shader_compile(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8701 */     if (!paramSet.contains("GL_ARB_parallel_shader_compile")) {
/*  8702 */       return false;
/*       */     }
/*       */     
/*  8705 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1289 }, new String[] { "glMaxShaderCompilerThreadsARB"
/*       */ 
/*       */ 
/*       */         
/*  8709 */         }) || Checks.reportMissing("GL", "GL_ARB_parallel_shader_compile")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_point_parameters(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8713 */     if (!paramSet.contains("GL_ARB_point_parameters")) {
/*  8714 */       return false;
/*       */     }
/*       */     
/*  8717 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1290, 1291 }, new String[] { "glPointParameterfARB", "glPointParameterfvARB"
/*       */ 
/*       */ 
/*       */         
/*  8721 */         }) || Checks.reportMissing("GL", "GL_ARB_point_parameters")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_polygon_offset_clamp(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8725 */     if (!paramSet.contains("GL_ARB_polygon_offset_clamp")) {
/*  8726 */       return false;
/*       */     }
/*       */     
/*  8729 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1046 }, new String[] { "glPolygonOffsetClamp"
/*       */ 
/*       */ 
/*       */         
/*  8733 */         }) || Checks.reportMissing("GL", "GL_ARB_polygon_offset_clamp")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_program_interface_query(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8737 */     if (!paramSet.contains("GL_ARB_program_interface_query")) {
/*  8738 */       return false;
/*       */     }
/*       */     
/*  8741 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 896, 897, 898, 899, 900, 901 }, new String[] { "glGetProgramInterfaceiv", "glGetProgramResourceIndex", "glGetProgramResourceName", "glGetProgramResourceiv", "glGetProgramResourceLocation", "glGetProgramResourceLocationIndex"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8746 */         }) || Checks.reportMissing("GL", "GL_ARB_program_interface_query")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_provoking_vertex(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8750 */     if (!paramSet.contains("GL_ARB_provoking_vertex")) {
/*  8751 */       return false;
/*       */     }
/*       */     
/*  8754 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 652 }, new String[] { "glProvokingVertex"
/*       */ 
/*       */ 
/*       */         
/*  8758 */         }) || Checks.reportMissing("GL", "GL_ARB_provoking_vertex")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_robustness(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8762 */     if (!paramSet.contains("GL_ARB_robustness")) {
/*  8763 */       return false;
/*       */     }
/*       */     
/*  8766 */     byte b2 = (paramFunctionProvider.getFunctionAddress("glGetMapdv") != 0L) ? 0 : -2147483648;
/*  8767 */     byte b3 = (paramFunctionProvider.getFunctionAddress("glGetMapfv") != 0L) ? 0 : -2147483648;
/*  8768 */     byte b4 = (paramFunctionProvider.getFunctionAddress("glGetMapiv") != 0L) ? 0 : -2147483648;
/*  8769 */     byte b5 = (paramFunctionProvider.getFunctionAddress("glGetPixelMapfv") != 0L) ? 0 : -2147483648;
/*  8770 */     byte b6 = (paramFunctionProvider.getFunctionAddress("glGetPixelMapuiv") != 0L) ? 0 : -2147483648;
/*  8771 */     byte b7 = (paramFunctionProvider.getFunctionAddress("glGetPixelMapusv") != 0L) ? 0 : -2147483648;
/*  8772 */     byte b8 = (paramFunctionProvider.getFunctionAddress("glGetPolygonStipple") != 0L) ? 0 : -2147483648;
/*  8773 */     byte b9 = (paramSet.contains("GL_ARB_imaging") && paramFunctionProvider.getFunctionAddress("glGetColorTable") != 0L) ? 0 : -2147483648;
/*  8774 */     byte b10 = (paramSet.contains("GL_ARB_imaging") && paramFunctionProvider.getFunctionAddress("glGetConvolutionFilter") != 0L) ? 0 : -2147483648;
/*  8775 */     byte b11 = (paramSet.contains("GL_ARB_imaging") && paramFunctionProvider.getFunctionAddress("glGetSeparableFilter") != 0L) ? 0 : -2147483648;
/*  8776 */     byte b12 = (paramSet.contains("GL_ARB_imaging") && paramFunctionProvider.getFunctionAddress("glGetHistogram") != 0L) ? 0 : -2147483648;
/*  8777 */     byte b13 = (paramSet.contains("GL_ARB_imaging") && paramFunctionProvider.getFunctionAddress("glGetMinmax") != 0L) ? 0 : -2147483648;
/*  8778 */     byte b14 = paramSet.contains("OpenGL13") ? 0 : -2147483648;
/*  8779 */     byte b15 = paramSet.contains("OpenGL20") ? 0 : -2147483648;
/*  8780 */     byte b16 = paramSet.contains("OpenGL30") ? 0 : -2147483648;
/*  8781 */     byte b1 = paramSet.contains("OpenGL40") ? 0 : -2147483648;
/*       */     
/*  8783 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1292, b2 + 1293, b3 + 1294, b4 + 1295, b5 + 1296, b6 + 1297, b7 + 1298, b8 + 1299, 1300, 1301, b9 + 1302, b10 + 1303, b11 + 1304, b12 + 1305, b13 + 1306, b14 + 1307, b15 + 1308, b15 + 1309, b16 + 1310, b1 + 1311 }, new String[] { "glGetGraphicsResetStatusARB", "glGetnMapdvARB", "glGetnMapfvARB", "glGetnMapivARB", "glGetnPixelMapfvARB", "glGetnPixelMapuivARB", "glGetnPixelMapusvARB", "glGetnPolygonStippleARB", "glGetnTexImageARB", "glReadnPixelsARB", "glGetnColorTableARB", "glGetnConvolutionFilterARB", "glGetnSeparableFilterARB", "glGetnHistogramARB", "glGetnMinmaxARB", "glGetnCompressedTexImageARB", "glGetnUniformfvARB", "glGetnUniformivARB", "glGetnUniformuivARB", "glGetnUniformdvARB"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8791 */         }) || Checks.reportMissing("GL", "GL_ARB_robustness")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_sample_locations(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8795 */     if (!paramSet.contains("GL_ARB_sample_locations")) {
/*  8796 */       return false;
/*       */     }
/*       */     
/*  8799 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1312, 1313, 1314 }, new String[] { "glFramebufferSampleLocationsfvARB", "glNamedFramebufferSampleLocationsfvARB", "glEvaluateDepthValuesARB"
/*       */ 
/*       */ 
/*       */         
/*  8803 */         }) || Checks.reportMissing("GL", "GL_ARB_sample_locations")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_sample_shading(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8807 */     if (!paramSet.contains("GL_ARB_sample_shading")) {
/*  8808 */       return false;
/*       */     }
/*       */     
/*  8811 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1315 }, new String[] { "glMinSampleShadingARB"
/*       */ 
/*       */ 
/*       */         
/*  8815 */         }) || Checks.reportMissing("GL", "GL_ARB_sample_shading")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_sampler_objects(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8819 */     if (!paramSet.contains("GL_ARB_sampler_objects")) {
/*  8820 */       return false;
/*       */     }
/*       */     
/*  8823 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 668, 669, 670, 671, 672, 673, 674, 675, 676, 677, 678, 679, 680, 681 }, new String[] { "glGenSamplers", "glDeleteSamplers", "glIsSampler", "glBindSampler", "glSamplerParameteri", "glSamplerParameterf", "glSamplerParameteriv", "glSamplerParameterfv", "glSamplerParameterIiv", "glSamplerParameterIuiv", "glGetSamplerParameteriv", "glGetSamplerParameterfv", "glGetSamplerParameterIiv", "glGetSamplerParameterIuiv"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8829 */         }) || Checks.reportMissing("GL", "GL_ARB_sampler_objects")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_separate_shader_objects(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8833 */     if (!paramSet.contains("GL_ARB_separate_shader_objects")) {
/*  8834 */       return false;
/*       */     }
/*       */     
/*  8837 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 778, 779, 780, 781, 782, 783, 784, 777, 785, 786, 787, 788, 789, 790, 791, 792, 793, 794, 795, 796, 797, 798, 799, 800, 801, 802, 803, 804, 805, 806, 807, 808, 809, 810, 811, 812, 813, 814, 815, 816, 817, 818, 819, 820, 821, 822, 823, 824, 825, 826, 827, 828, 829, 830, 831, 832, 833, 834, 835, 836, 837 }, new String[] { "glUseProgramStages", "glActiveShaderProgram", "glCreateShaderProgramv", "glBindProgramPipeline", "glDeleteProgramPipelines", "glGenProgramPipelines", "glIsProgramPipeline", "glProgramParameteri", "glGetProgramPipelineiv", "glProgramUniform1i", "glProgramUniform2i", "glProgramUniform3i", "glProgramUniform4i", "glProgramUniform1ui", "glProgramUniform2ui", "glProgramUniform3ui", "glProgramUniform4ui", "glProgramUniform1f", "glProgramUniform2f", "glProgramUniform3f", "glProgramUniform4f", "glProgramUniform1d", "glProgramUniform2d", "glProgramUniform3d", "glProgramUniform4d", "glProgramUniform1iv", "glProgramUniform2iv", "glProgramUniform3iv", "glProgramUniform4iv", "glProgramUniform1uiv", "glProgramUniform2uiv", "glProgramUniform3uiv", "glProgramUniform4uiv", "glProgramUniform1fv", "glProgramUniform2fv", "glProgramUniform3fv", "glProgramUniform4fv", "glProgramUniform1dv", "glProgramUniform2dv", "glProgramUniform3dv", "glProgramUniform4dv", "glProgramUniformMatrix2fv", "glProgramUniformMatrix3fv", "glProgramUniformMatrix4fv", "glProgramUniformMatrix2dv", "glProgramUniformMatrix3dv", "glProgramUniformMatrix4dv", "glProgramUniformMatrix2x3fv", "glProgramUniformMatrix3x2fv", "glProgramUniformMatrix2x4fv", "glProgramUniformMatrix4x2fv", "glProgramUniformMatrix3x4fv", "glProgramUniformMatrix4x3fv", "glProgramUniformMatrix2x3dv", "glProgramUniformMatrix3x2dv", "glProgramUniformMatrix2x4dv", "glProgramUniformMatrix4x2dv", "glProgramUniformMatrix3x4dv", "glProgramUniformMatrix4x3dv", "glValidateProgramPipeline", "glGetProgramPipelineInfoLog"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8854 */         }) || Checks.reportMissing("GL", "GL_ARB_separate_shader_objects")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_shader_atomic_counters(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8858 */     if (!paramSet.contains("GL_ARB_shader_atomic_counters")) {
/*  8859 */       return false;
/*       */     }
/*       */     
/*  8862 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 858 }, new String[] { "glGetActiveAtomicCounterBufferiv"
/*       */ 
/*       */ 
/*       */         
/*  8866 */         }) || Checks.reportMissing("GL", "GL_ARB_shader_atomic_counters")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_shader_image_load_store(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8870 */     if (!paramSet.contains("GL_ARB_shader_image_load_store")) {
/*  8871 */       return false;
/*       */     }
/*       */     
/*  8874 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 867, 868 }, new String[] { "glBindImageTexture", "glMemoryBarrier"
/*       */ 
/*       */ 
/*       */         
/*  8878 */         }) || Checks.reportMissing("GL", "GL_ARB_shader_image_load_store")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_shader_objects(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8882 */     if (!paramSet.contains("GL_ARB_shader_objects")) {
/*  8883 */       return false;
/*       */     }
/*       */     
/*  8886 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1316, 1317, 1318, 1319, 1320, 1321, 1322, 1323, 1324, 1325, 1326, 1327, 1328, 1329, 1330, 1331, 1332, 1333, 1334, 1335, 1336, 1337, 1338, 1339, 1340, 1341, 1342, 1343, 1344, 1345, 1346, 1347, 1348, 1349, 1350, 1351, 1352, 1353, 1354 }, new String[] { "glDeleteObjectARB", "glGetHandleARB", "glDetachObjectARB", "glCreateShaderObjectARB", "glShaderSourceARB", "glCompileShaderARB", "glCreateProgramObjectARB", "glAttachObjectARB", "glLinkProgramARB", "glUseProgramObjectARB", "glValidateProgramARB", "glUniform1fARB", "glUniform2fARB", "glUniform3fARB", "glUniform4fARB", "glUniform1iARB", "glUniform2iARB", "glUniform3iARB", "glUniform4iARB", "glUniform1fvARB", "glUniform2fvARB", "glUniform3fvARB", "glUniform4fvARB", "glUniform1ivARB", "glUniform2ivARB", "glUniform3ivARB", "glUniform4ivARB", "glUniformMatrix2fvARB", "glUniformMatrix3fvARB", "glUniformMatrix4fvARB", "glGetObjectParameterfvARB", "glGetObjectParameterivARB", "glGetInfoLogARB", "glGetAttachedObjectsARB", "glGetUniformLocationARB", "glGetActiveUniformARB", "glGetUniformfvARB", "glGetUniformivARB", "glGetShaderSourceARB"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8897 */         }) || Checks.reportMissing("GL", "GL_ARB_shader_objects")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_shader_storage_buffer_object(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8901 */     if (!paramSet.contains("GL_ARB_shader_storage_buffer_object")) {
/*  8902 */       return false;
/*       */     }
/*       */     
/*  8905 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 902 }, new String[] { "glShaderStorageBlockBinding"
/*       */ 
/*       */ 
/*       */         
/*  8909 */         }) || Checks.reportMissing("GL", "GL_ARB_shader_storage_buffer_object")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_shader_subroutine(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8913 */     if (!paramSet.contains("GL_ARB_shader_subroutine")) {
/*  8914 */       return false;
/*       */     }
/*       */     
/*  8917 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 749, 750, 751, 752, 753, 754, 755, 756 }, new String[] { "glGetSubroutineUniformLocation", "glGetSubroutineIndex", "glGetActiveSubroutineUniformiv", "glGetActiveSubroutineUniformName", "glGetActiveSubroutineName", "glUniformSubroutinesuiv", "glGetUniformSubroutineuiv", "glGetProgramStageiv"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8922 */         }) || Checks.reportMissing("GL", "GL_ARB_shader_subroutine")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_shading_language_include(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8926 */     if (!paramSet.contains("GL_ARB_shading_language_include")) {
/*  8927 */       return false;
/*       */     }
/*       */     
/*  8930 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1355, 1356, 1357, 1358, 1359, 1360 }, new String[] { "glNamedStringARB", "glDeleteNamedStringARB", "glCompileShaderIncludeARB", "glIsNamedStringARB", "glGetNamedStringARB", "glGetNamedStringivARB"
/*       */ 
/*       */ 
/*       */         
/*  8934 */         }) || Checks.reportMissing("GL", "GL_ARB_shading_language_include")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_sparse_buffer(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8938 */     if (!paramSet.contains("GL_ARB_sparse_buffer")) {
/*  8939 */       return false;
/*       */     }
/*       */     
/*  8942 */     paramSet.contains("GL_EXT_direct_state_access");
/*  8943 */     paramSet.contains("GL_ARB_direct_state_access");
/*       */     
/*  8945 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1361 }, new String[] { "glBufferPageCommitmentARB"
/*       */ 
/*       */ 
/*       */         
/*  8949 */         }) || Checks.reportMissing("GL", "GL_ARB_sparse_buffer")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_sparse_texture(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8953 */     if (!paramSet.contains("GL_ARB_sparse_texture")) {
/*  8954 */       return false;
/*       */     }
/*       */     
/*  8957 */     byte b = paramSet.contains("GL_EXT_direct_state_access") ? 0 : -2147483648;
/*       */     
/*  8959 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1364, b + 1365 }, new String[] { "glTexPageCommitmentARB", "glTexturePageCommitmentEXT"
/*       */ 
/*       */ 
/*       */         
/*  8963 */         }) || Checks.reportMissing("GL", "GL_ARB_sparse_texture")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_sync(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8967 */     if (!paramSet.contains("GL_ARB_sync")) {
/*  8968 */       return false;
/*       */     }
/*       */     
/*  8971 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 658, 659, 660, 661, 662, 663, 665 }, new String[] { "glFenceSync", "glIsSync", "glDeleteSync", "glClientWaitSync", "glWaitSync", "glGetInteger64v", "glGetSynciv"
/*       */ 
/*       */ 
/*       */         
/*  8975 */         }) || Checks.reportMissing("GL", "GL_ARB_sync")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_tessellation_shader(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8979 */     if (!paramSet.contains("GL_ARB_tessellation_shader")) {
/*  8980 */       return false;
/*       */     }
/*       */     
/*  8983 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 757, 758 }, new String[] { "glPatchParameteri", "glPatchParameterfv"
/*       */ 
/*       */ 
/*       */         
/*  8987 */         }) || Checks.reportMissing("GL", "GL_ARB_tessellation_shader")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_texture_barrier(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  8991 */     if (!paramSet.contains("GL_ARB_texture_barrier")) {
/*  8992 */       return false;
/*       */     }
/*       */     
/*  8995 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1023 }, new String[] { "glTextureBarrier"
/*       */ 
/*       */ 
/*       */         
/*  8999 */         }) || Checks.reportMissing("GL", "GL_ARB_texture_barrier")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_texture_buffer_object(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9003 */     if (!paramSet.contains("GL_ARB_texture_buffer_object")) {
/*  9004 */       return false;
/*       */     }
/*       */     
/*  9007 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1366 }, new String[] { "glTexBufferARB"
/*       */ 
/*       */ 
/*       */         
/*  9011 */         }) || Checks.reportMissing("GL", "GL_ARB_texture_buffer_object")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_texture_buffer_range(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9015 */     if (!paramSet.contains("GL_ARB_texture_buffer_range")) {
/*  9016 */       return false;
/*       */     }
/*       */     
/*  9019 */     byte b = paramSet.contains("GL_EXT_direct_state_access") ? 0 : -2147483648;
/*       */     
/*  9021 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 903, b + 1367 }, new String[] { "glTexBufferRange", "glTextureBufferRangeEXT"
/*       */ 
/*       */ 
/*       */         
/*  9025 */         }) || Checks.reportMissing("GL", "GL_ARB_texture_buffer_range")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_texture_compression(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9029 */     if (!paramSet.contains("GL_ARB_texture_compression")) {
/*  9030 */       return false;
/*       */     }
/*       */     
/*  9033 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1368, 1369, 1370, 1371, 1372, 1373, 1374 }, new String[] { "glCompressedTexImage3DARB", "glCompressedTexImage2DARB", "glCompressedTexImage1DARB", "glCompressedTexSubImage3DARB", "glCompressedTexSubImage2DARB", "glCompressedTexSubImage1DARB", "glGetCompressedTexImageARB"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  9038 */         }) || Checks.reportMissing("GL", "GL_ARB_texture_compression")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_texture_multisample(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9042 */     if (!paramSet.contains("GL_ARB_texture_multisample")) {
/*  9043 */       return false;
/*       */     }
/*       */     
/*  9046 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 653, 654, 655, 656 }, new String[] { "glTexImage2DMultisample", "glTexImage3DMultisample", "glGetMultisamplefv", "glSampleMaski"
/*       */ 
/*       */ 
/*       */         
/*  9050 */         }) || Checks.reportMissing("GL", "GL_ARB_texture_multisample")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_texture_storage(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9054 */     if (!paramSet.contains("GL_ARB_texture_storage")) {
/*  9055 */       return false;
/*       */     }
/*       */     
/*  9058 */     byte b = paramSet.contains("GL_EXT_direct_state_access") ? 0 : -2147483648;
/*       */     
/*  9060 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 859, 860, 861, b + 1375, b + 1376, b + 1377 }, new String[] { "glTexStorage1D", "glTexStorage2D", "glTexStorage3D", "glTextureStorage1DEXT", "glTextureStorage2DEXT", "glTextureStorage3DEXT"
/*       */ 
/*       */ 
/*       */         
/*  9064 */         }) || Checks.reportMissing("GL", "GL_ARB_texture_storage")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_texture_storage_multisample(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9068 */     if (!paramSet.contains("GL_ARB_texture_storage_multisample")) {
/*  9069 */       return false;
/*       */     }
/*       */     
/*  9072 */     byte b = paramSet.contains("GL_EXT_direct_state_access") ? 0 : -2147483648;
/*       */     
/*  9074 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 904, 905, b + 1378, b + 1379 }, new String[] { "glTexStorage2DMultisample", "glTexStorage3DMultisample", "glTextureStorage2DMultisampleEXT", "glTextureStorage3DMultisampleEXT"
/*       */ 
/*       */ 
/*       */         
/*  9078 */         }) || Checks.reportMissing("GL", "GL_ARB_texture_storage_multisample")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_texture_view(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9082 */     if (!paramSet.contains("GL_ARB_texture_view")) {
/*  9083 */       return false;
/*       */     }
/*       */     
/*  9086 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 906 }, new String[] { "glTextureView"
/*       */ 
/*       */ 
/*       */         
/*  9090 */         }) || Checks.reportMissing("GL", "GL_ARB_texture_view")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_timer_query(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9094 */     if (!paramSet.contains("GL_ARB_timer_query")) {
/*  9095 */       return false;
/*       */     }
/*       */     
/*  9098 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 682, 683, 684 }, new String[] { "glQueryCounter", "glGetQueryObjecti64v", "glGetQueryObjectui64v"
/*       */ 
/*       */ 
/*       */         
/*  9102 */         }) || Checks.reportMissing("GL", "GL_ARB_timer_query")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_transform_feedback2(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9106 */     if (!paramSet.contains("GL_ARB_transform_feedback2")) {
/*  9107 */       return false;
/*       */     }
/*       */     
/*  9110 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 759, 760, 761, 762, 763, 764, 765 }, new String[] { "glBindTransformFeedback", "glDeleteTransformFeedbacks", "glGenTransformFeedbacks", "glIsTransformFeedback", "glPauseTransformFeedback", "glResumeTransformFeedback", "glDrawTransformFeedback"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  9115 */         }) || Checks.reportMissing("GL", "GL_ARB_transform_feedback2")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_transform_feedback3(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9119 */     if (!paramSet.contains("GL_ARB_transform_feedback3")) {
/*  9120 */       return false;
/*       */     }
/*       */     
/*  9123 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 766, 767, 768, 769 }, new String[] { "glDrawTransformFeedbackStream", "glBeginQueryIndexed", "glEndQueryIndexed", "glGetQueryIndexediv"
/*       */ 
/*       */ 
/*       */         
/*  9127 */         }) || Checks.reportMissing("GL", "GL_ARB_transform_feedback3")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_transform_feedback_instanced(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9131 */     if (!paramSet.contains("GL_ARB_transform_feedback_instanced")) {
/*  9132 */       return false;
/*       */     }
/*       */     
/*  9135 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 862, 863 }, new String[] { "glDrawTransformFeedbackInstanced", "glDrawTransformFeedbackStreamInstanced"
/*       */ 
/*       */ 
/*       */         
/*  9139 */         }) || Checks.reportMissing("GL", "GL_ARB_transform_feedback_instanced")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_transpose_matrix(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9143 */     if (!paramSet.contains("GL_ARB_transpose_matrix")) {
/*  9144 */       return false;
/*       */     }
/*       */     
/*  9147 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1380, 1381, 1382, 1383 }, new String[] { "glLoadTransposeMatrixfARB", "glLoadTransposeMatrixdARB", "glMultTransposeMatrixfARB", "glMultTransposeMatrixdARB"
/*       */ 
/*       */ 
/*       */         
/*  9151 */         }) || Checks.reportMissing("GL", "GL_ARB_transpose_matrix")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_uniform_buffer_object(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9155 */     if (!paramSet.contains("GL_ARB_uniform_buffer_object")) {
/*  9156 */       return false;
/*       */     }
/*       */     
/*  9159 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 640, 641, 642, 643, 644, 645, 625, 626, 621, 646 }, new String[] { "glGetUniformIndices", "glGetActiveUniformsiv", "glGetActiveUniformName", "glGetUniformBlockIndex", "glGetActiveUniformBlockiv", "glGetActiveUniformBlockName", "glBindBufferRange", "glBindBufferBase", "glGetIntegeri_v", "glUniformBlockBinding"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  9164 */         }) || Checks.reportMissing("GL", "GL_ARB_uniform_buffer_object")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_vertex_array_object(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9168 */     if (!paramSet.contains("GL_ARB_vertex_array_object")) {
/*  9169 */       return false;
/*       */     }
/*       */     
/*  9172 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 631, 632, 633, 634 }, new String[] { "glBindVertexArray", "glDeleteVertexArrays", "glGenVertexArrays", "glIsVertexArray"
/*       */ 
/*       */ 
/*       */         
/*  9176 */         }) || Checks.reportMissing("GL", "GL_ARB_vertex_array_object")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_vertex_attrib_64bit(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9180 */     if (!paramSet.contains("GL_ARB_vertex_attrib_64bit")) {
/*  9181 */       return false;
/*       */     }
/*       */     
/*  9184 */     byte b = paramSet.contains("GL_EXT_direct_state_access") ? 0 : -2147483648;
/*       */     
/*  9186 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 838, 839, 840, 841, 842, 843, 844, 845, 846, 847, b + 1384 }, new String[] { "glVertexAttribL1d", "glVertexAttribL2d", "glVertexAttribL3d", "glVertexAttribL4d", "glVertexAttribL1dv", "glVertexAttribL2dv", "glVertexAttribL3dv", "glVertexAttribL4dv", "glVertexAttribLPointer", "glGetVertexAttribLdv", "glVertexArrayVertexAttribLOffsetEXT"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  9191 */         }) || Checks.reportMissing("GL", "GL_ARB_vertex_attrib_64bit")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_vertex_attrib_binding(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9195 */     if (!paramSet.contains("GL_ARB_vertex_attrib_binding")) {
/*  9196 */       return false;
/*       */     }
/*       */     
/*  9199 */     byte b = paramSet.contains("GL_EXT_direct_state_access") ? 0 : -2147483648;
/*       */     
/*  9201 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 907, 908, 909, 910, 911, 912, b + 1385, b + 1386, b + 1387, b + 1388, b + 1389, b + 1390 }, new String[] { "glBindVertexBuffer", "glVertexAttribFormat", "glVertexAttribIFormat", "glVertexAttribLFormat", "glVertexAttribBinding", "glVertexBindingDivisor", "glVertexArrayBindVertexBufferEXT", "glVertexArrayVertexAttribFormatEXT", "glVertexArrayVertexAttribIFormatEXT", "glVertexArrayVertexAttribLFormatEXT", "glVertexArrayVertexAttribBindingEXT", "glVertexArrayVertexBindingDivisorEXT"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  9207 */         }) || Checks.reportMissing("GL", "GL_ARB_vertex_attrib_binding")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_vertex_blend(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9211 */     if (!paramSet.contains("GL_ARB_vertex_blend")) {
/*  9212 */       return false;
/*       */     }
/*       */     
/*  9215 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1391, 1392, 1393, 1394, 1395, 1396, 1397, 1398, 1399, 1400 }, new String[] { "glWeightfvARB", "glWeightbvARB", "glWeightubvARB", "glWeightsvARB", "glWeightusvARB", "glWeightivARB", "glWeightuivARB", "glWeightdvARB", "glWeightPointerARB", "glVertexBlendARB"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  9220 */         }) || Checks.reportMissing("GL", "GL_ARB_vertex_blend")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_vertex_buffer_object(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9224 */     if (!paramSet.contains("GL_ARB_vertex_buffer_object")) {
/*  9225 */       return false;
/*       */     }
/*       */     
/*  9228 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1401, 1402, 1403, 1404, 1405, 1406, 1407, 1408, 1409, 1410, 1411 }, new String[] { "glBindBufferARB", "glDeleteBuffersARB", "glGenBuffersARB", "glIsBufferARB", "glBufferDataARB", "glBufferSubDataARB", "glGetBufferSubDataARB", "glMapBufferARB", "glUnmapBufferARB", "glGetBufferParameterivARB", "glGetBufferPointervARB"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  9233 */         }) || Checks.reportMissing("GL", "GL_ARB_vertex_buffer_object")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_vertex_program(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9237 */     if (!paramSet.contains("GL_ARB_vertex_program")) {
/*  9238 */       return false;
/*       */     }
/*       */     
/*  9241 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1412, 1413, 1414, 1415, 1416, 1417, 1418, 1419, 1420, 1421, 1422, 1423, 1424, 1425, 1426, 1427, 1428, 1429, 1430, 1431, 1432, 1433, 1434, 1435, 1436, 1437, 1438, 1439, 1440, 1441, 1442, 1443, 1444, 1445, 1446, 1447, 1448, 1449, 1450, 1451, 1452, 1453, 1454, 1455, 1456, 1457, 1458, 1459, 1460, 1461, 1462, 1463, 1464, 1465, 1466, 1467, 1468, 1469, 1470, 1471, 1472, 1473 }, new String[] { "glVertexAttrib1sARB", "glVertexAttrib1fARB", "glVertexAttrib1dARB", "glVertexAttrib2sARB", "glVertexAttrib2fARB", "glVertexAttrib2dARB", "glVertexAttrib3sARB", "glVertexAttrib3fARB", "glVertexAttrib3dARB", "glVertexAttrib4sARB", "glVertexAttrib4fARB", "glVertexAttrib4dARB", "glVertexAttrib4NubARB", "glVertexAttrib1svARB", "glVertexAttrib1fvARB", "glVertexAttrib1dvARB", "glVertexAttrib2svARB", "glVertexAttrib2fvARB", "glVertexAttrib2dvARB", "glVertexAttrib3svARB", "glVertexAttrib3fvARB", "glVertexAttrib3dvARB", "glVertexAttrib4fvARB", "glVertexAttrib4bvARB", "glVertexAttrib4svARB", "glVertexAttrib4ivARB", "glVertexAttrib4ubvARB", "glVertexAttrib4usvARB", "glVertexAttrib4uivARB", "glVertexAttrib4dvARB", "glVertexAttrib4NbvARB", "glVertexAttrib4NsvARB", "glVertexAttrib4NivARB", "glVertexAttrib4NubvARB", "glVertexAttrib4NusvARB", "glVertexAttrib4NuivARB", "glVertexAttribPointerARB", "glEnableVertexAttribArrayARB", "glDisableVertexAttribArrayARB", "glProgramStringARB", "glBindProgramARB", "glDeleteProgramsARB", "glGenProgramsARB", "glProgramEnvParameter4dARB", "glProgramEnvParameter4dvARB", "glProgramEnvParameter4fARB", "glProgramEnvParameter4fvARB", "glProgramLocalParameter4dARB", "glProgramLocalParameter4dvARB", "glProgramLocalParameter4fARB", "glProgramLocalParameter4fvARB", "glGetProgramEnvParameterfvARB", "glGetProgramEnvParameterdvARB", "glGetProgramLocalParameterfvARB", "glGetProgramLocalParameterdvARB", "glGetProgramivARB", "glGetProgramStringARB", "glGetVertexAttribfvARB", "glGetVertexAttribdvARB", "glGetVertexAttribivARB", "glGetVertexAttribPointervARB", "glIsProgramARB"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  9258 */         }) || Checks.reportMissing("GL", "GL_ARB_vertex_program")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_vertex_shader(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9262 */     if (!paramSet.contains("GL_ARB_vertex_shader")) {
/*  9263 */       return false;
/*       */     }
/*       */     
/*  9266 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1413, 1412, 1414, 1416, 1415, 1417, 1419, 1418, 1420, 1422, 1421, 1423, 1424, 1426, 1425, 1427, 1429, 1428, 1430, 1432, 1431, 1433, 1434, 1436, 1441, 1437, 1435, 1438, 1439, 1440, 1442, 1443, 1444, 1445, 1446, 1447, 1448, 1449, 1450, 1474, 1475, 1476, 1471, 1469, 1470, 1472 }, new String[] { "glVertexAttrib1fARB", "glVertexAttrib1sARB", "glVertexAttrib1dARB", "glVertexAttrib2fARB", "glVertexAttrib2sARB", "glVertexAttrib2dARB", "glVertexAttrib3fARB", "glVertexAttrib3sARB", "glVertexAttrib3dARB", "glVertexAttrib4fARB", "glVertexAttrib4sARB", "glVertexAttrib4dARB", "glVertexAttrib4NubARB", "glVertexAttrib1fvARB", "glVertexAttrib1svARB", "glVertexAttrib1dvARB", "glVertexAttrib2fvARB", "glVertexAttrib2svARB", "glVertexAttrib2dvARB", "glVertexAttrib3fvARB", "glVertexAttrib3svARB", "glVertexAttrib3dvARB", "glVertexAttrib4fvARB", "glVertexAttrib4svARB", "glVertexAttrib4dvARB", "glVertexAttrib4ivARB", "glVertexAttrib4bvARB", "glVertexAttrib4ubvARB", "glVertexAttrib4usvARB", "glVertexAttrib4uivARB", "glVertexAttrib4NbvARB", "glVertexAttrib4NsvARB", "glVertexAttrib4NivARB", "glVertexAttrib4NubvARB", "glVertexAttrib4NusvARB", "glVertexAttrib4NuivARB", "glVertexAttribPointerARB", "glEnableVertexAttribArrayARB", "glDisableVertexAttribArrayARB", "glBindAttribLocationARB", "glGetActiveAttribARB", "glGetAttribLocationARB", "glGetVertexAttribivARB", "glGetVertexAttribfvARB", "glGetVertexAttribdvARB", "glGetVertexAttribPointervARB"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  9279 */         }) || Checks.reportMissing("GL", "GL_ARB_vertex_shader")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_vertex_type_2_10_10_10_rev(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet, boolean paramBoolean) {
/*  9283 */     if (!paramSet.contains("GL_ARB_vertex_type_2_10_10_10_rev")) {
/*  9284 */       return false;
/*       */     }
/*       */     
/*  9287 */     if (((paramBoolean || Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 686, 687, 688, 689, 690, 691, 692, 693, 694, 695, 696, 697, 698, 699, 700, 701, 702, 703, 704, 705, 706, 707, 708, 709, 710, 711, 712, 713, 714, 715 }, new String[] { "glVertexP2ui", "glVertexP3ui", "glVertexP4ui", "glVertexP2uiv", "glVertexP3uiv", "glVertexP4uiv", "glTexCoordP1ui", "glTexCoordP2ui", "glTexCoordP3ui", "glTexCoordP4ui", "glTexCoordP1uiv", "glTexCoordP2uiv", "glTexCoordP3uiv", "glTexCoordP4uiv", "glMultiTexCoordP1ui", "glMultiTexCoordP2ui", "glMultiTexCoordP3ui", "glMultiTexCoordP4ui", "glMultiTexCoordP1uiv", "glMultiTexCoordP2uiv", "glMultiTexCoordP3uiv", "glMultiTexCoordP4uiv", "glNormalP3ui", "glNormalP3uiv", "glColorP3ui", "glColorP4ui", "glColorP3uiv", "glColorP4uiv", "glSecondaryColorP3ui", "glSecondaryColorP3uiv"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  9296 */         })) && Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] {
/*       */           716, 717, 718, 719, 720, 721, 722, 723 }, new String[] {
/*       */           
/*       */           "glVertexAttribP1ui", "glVertexAttribP2ui", "glVertexAttribP3ui", "glVertexAttribP4ui", "glVertexAttribP1uiv", "glVertexAttribP2uiv", "glVertexAttribP3uiv", "glVertexAttribP4uiv"
/*       */         
/*  9301 */         })) || Checks.reportMissing("GL", "GL_ARB_vertex_type_2_10_10_10_rev")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_viewport_array(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9305 */     if (!paramSet.contains("GL_ARB_viewport_array")) {
/*  9306 */       return false;
/*       */     }
/*       */     
/*  9309 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 848, 849, 850, 851, 852, 853, 854, 855, 856, 857 }, new String[] { "glViewportArrayv", "glViewportIndexedf", "glViewportIndexedfv", "glScissorArrayv", "glScissorIndexed", "glScissorIndexedv", "glDepthRangeArrayv", "glDepthRangeIndexed", "glGetFloati_v", "glGetDoublei_v"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  9314 */         }) || Checks.reportMissing("GL", "GL_ARB_viewport_array")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_ARB_window_pos(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9318 */     if (!paramSet.contains("GL_ARB_window_pos")) {
/*  9319 */       return false;
/*       */     }
/*       */     
/*  9322 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1477, 1478, 1479, 1480, 1481, 1482, 1483, 1484, 1485, 1486, 1487, 1488, 1489, 1490, 1491, 1492 }, new String[] { "glWindowPos2iARB", "glWindowPos2sARB", "glWindowPos2fARB", "glWindowPos2dARB", "glWindowPos2ivARB", "glWindowPos2svARB", "glWindowPos2fvARB", "glWindowPos2dvARB", "glWindowPos3iARB", "glWindowPos3sARB", "glWindowPos3fARB", "glWindowPos3dARB", "glWindowPos3ivARB", "glWindowPos3svARB", "glWindowPos3fvARB", "glWindowPos3dvARB"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  9328 */         }) || Checks.reportMissing("GL", "GL_ARB_window_pos")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_bindable_uniform(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9332 */     if (!paramSet.contains("GL_EXT_bindable_uniform")) {
/*  9333 */       return false;
/*       */     }
/*       */     
/*  9336 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1493, 1494, 1495 }, new String[] { "glUniformBufferEXT", "glGetUniformBufferSizeEXT", "glGetUniformOffsetEXT"
/*       */ 
/*       */ 
/*       */         
/*  9340 */         }) || Checks.reportMissing("GL", "GL_EXT_bindable_uniform")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_blend_color(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9344 */     if (!paramSet.contains("GL_EXT_blend_color")) {
/*  9345 */       return false;
/*       */     }
/*       */     
/*  9348 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1496 }, new String[] { "glBlendColorEXT"
/*       */ 
/*       */ 
/*       */         
/*  9352 */         }) || Checks.reportMissing("GL", "GL_EXT_blend_color")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_blend_equation_separate(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9356 */     if (!paramSet.contains("GL_EXT_blend_equation_separate")) {
/*  9357 */       return false;
/*       */     }
/*       */     
/*  9360 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1497 }, new String[] { "glBlendEquationSeparateEXT"
/*       */ 
/*       */ 
/*       */         
/*  9364 */         }) || Checks.reportMissing("GL", "GL_EXT_blend_equation_separate")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_blend_func_separate(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9368 */     if (!paramSet.contains("GL_EXT_blend_func_separate")) {
/*  9369 */       return false;
/*       */     }
/*       */     
/*  9372 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1498 }, new String[] { "glBlendFuncSeparateEXT"
/*       */ 
/*       */ 
/*       */         
/*  9376 */         }) || Checks.reportMissing("GL", "GL_EXT_blend_func_separate")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_blend_minmax(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9380 */     if (!paramSet.contains("GL_EXT_blend_minmax")) {
/*  9381 */       return false;
/*       */     }
/*       */     
/*  9384 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1499 }, new String[] { "glBlendEquationEXT"
/*       */ 
/*       */ 
/*       */         
/*  9388 */         }) || Checks.reportMissing("GL", "GL_EXT_blend_minmax")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_compiled_vertex_array(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9392 */     if (!paramSet.contains("GL_EXT_compiled_vertex_array")) {
/*  9393 */       return false;
/*       */     }
/*       */     
/*  9396 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1500, 1501 }, new String[] { "glLockArraysEXT", "glUnlockArraysEXT"
/*       */ 
/*       */ 
/*       */         
/*  9400 */         }) || Checks.reportMissing("GL", "GL_EXT_compiled_vertex_array")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_debug_label(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9404 */     if (!paramSet.contains("GL_EXT_debug_label")) {
/*  9405 */       return false;
/*       */     }
/*       */     
/*  9408 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1502, 1503 }, new String[] { "glLabelObjectEXT", "glGetObjectLabelEXT"
/*       */ 
/*       */ 
/*       */         
/*  9412 */         }) || Checks.reportMissing("GL", "GL_EXT_debug_label")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_debug_marker(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9416 */     if (!paramSet.contains("GL_EXT_debug_marker")) {
/*  9417 */       return false;
/*       */     }
/*       */     
/*  9420 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1504, 1505, 1506 }, new String[] { "glInsertEventMarkerEXT", "glPushGroupMarkerEXT", "glPopGroupMarkerEXT"
/*       */ 
/*       */ 
/*       */         
/*  9424 */         }) || Checks.reportMissing("GL", "GL_EXT_debug_marker")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_depth_bounds_test(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9428 */     if (!paramSet.contains("GL_EXT_depth_bounds_test")) {
/*  9429 */       return false;
/*       */     }
/*       */     
/*  9432 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1507 }, new String[] { "glDepthBoundsEXT"
/*       */ 
/*       */ 
/*       */         
/*  9436 */         }) || Checks.reportMissing("GL", "GL_EXT_depth_bounds_test")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_direct_state_access(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9440 */     if (!paramSet.contains("GL_EXT_direct_state_access")) {
/*  9441 */       return false;
/*       */     }
/*       */     
/*  9444 */     byte b2 = paramSet.contains("OpenGL12") ? 0 : -2147483648;
/*  9445 */     byte b3 = paramSet.contains("OpenGL13") ? 0 : -2147483648;
/*  9446 */     byte b4 = paramSet.contains("OpenGL30") ? 0 : -2147483648;
/*  9447 */     byte b5 = paramSet.contains("GL_ARB_vertex_program") ? 0 : -2147483648;
/*  9448 */     byte b6 = paramSet.contains("OpenGL15") ? 0 : -2147483648;
/*  9449 */     byte b7 = paramSet.contains("OpenGL20") ? 0 : -2147483648;
/*  9450 */     byte b8 = paramSet.contains("OpenGL21") ? 0 : -2147483648;
/*  9451 */     byte b9 = paramSet.contains("GL_EXT_texture_buffer_object") ? 0 : -2147483648;
/*  9452 */     byte b10 = paramSet.contains("GL_EXT_texture_integer") ? 0 : -2147483648;
/*  9453 */     byte b11 = paramSet.contains("GL_EXT_gpu_shader4") ? 0 : -2147483648;
/*  9454 */     byte b12 = paramSet.contains("GL_EXT_gpu_program_parameters") ? 0 : -2147483648;
/*  9455 */     byte b13 = paramSet.contains("GL_NV_gpu_program4") ? 0 : -2147483648;
/*  9456 */     byte b14 = paramSet.contains("GL_NV_framebuffer_multisample_coverage") ? 0 : -2147483648;
/*  9457 */     byte b15 = (paramSet.contains("GL_EXT_geometry_shader4") || paramSet.contains("GL_NV_gpu_program4")) ? 0 : -2147483648;
/*  9458 */     byte b1 = paramSet.contains("GL_NV_explicit_multisample") ? 0 : -2147483648;
/*       */     
/*  9460 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1508, 1509, 1510, 1511, 1512, 1513, 1514, 1515, 1516, 1517, 1518, 1519, 1520, 1521, 1522, 1523, 1524, 1525, 1526, 1527, 1528, 1529, 1530, 1531, 1532, 1533, 1534, 1535, 1536, 1537, 1538, 1539, 1540, 1541, b2 + 1542, b2 + 1543, b2 + 1544, b3 + 1545, b3 + 1546, b3 + 1547, b3 + 1548, b3 + 1549, b3 + 1550, b3 + 1551, b3 + 1552, b3 + 1553, b3 + 1554, b3 + 1555, b3 + 1556, b3 + 1557, b3 + 1558, b3 + 1559, b3 + 1560, b3 + 1561, b3 + 1562, b3 + 1563, b3 + 1564, b3 + 1565, b3 + 1566, b3 + 1567, b3 + 1568, b3 + 1569, b3 + 1570, b3 + 1571, b3 + 1572, b3 + 1573, b3 + 1574, b3 + 1575, b3 + 1576, b3 + 1577, b3 + 1578, b3 + 1579, b3 + 1580, b3 + 1581, b3 + 1582, b3 + 1583, b3 + 1586, b3 + 1587, b3 + 1588, b3 + 1592, b3 + 1593, b3 + 1594, b3 + 1595, b3 + 1596, b5 + 1597, b5 + 1598, b5 + 1599, b5 + 1600, b5 + 1601, b5 + 1602, b5 + 1603, b5 + 1604, b5 + 1605, b3 + 1606, b3 + 1607, b3 + 1608, b3 + 1609, b3 + 1610, b3 + 1611, b3 + 1612, b3 + 1613, b3 + 1614, b3 + 1615, b3 + 1616, b3 + 1617, b3 + 1618, b3 + 1619, b3 + 1620, b3 + 1621, b3 + 1622, b3 + 1623, b6 + 1624, b6 + 1625, b6 + 1626, b6 + 1627, b6 + 1628, b6 + 1629, b7 + 1630, b7 + 1631, b7 + 1632, b7 + 1633, b7 + 1634, b7 + 1635, b7 + 1636, b7 + 1637, b7 + 1638, b7 + 1639, b7 + 1640, b7 + 1641, b7 + 1642, b7 + 1643, b7 + 1644, b7 + 1645, b7 + 1646, b7 + 1647, b7 + 1648, b8 + 1649, b8 + 1650, b8 + 1651, b8 + 1652, b8 + 1653, b8 + 1654, b9 + 1655, b9 + 1656, b10 + 1657, b10 + 1658, b10 + 1659, b10 + 1660, b10 + 1661, b10 + 1662, b10 + 1663, b10 + 1664, b11 + 1665, b11 + 1666, b11 + 1667, b11 + 1668, b11 + 1669, b11 + 1670, b11 + 1671, b11 + 1672, b12 + 1673, b13 + 1674, b13 + 1675, b13 + 1676, b13 + 1677, b13 + 1678, b13 + 1679, b13 + 1680, b13 + 1681, b4 + 1682, b4 + 1683, b4 + 1684, b14 + 1685, b4 + 1686, b4 + 1687, b4 + 1688, b4 + 1689, b4 + 1690, b4 + 1691, b4 + 1692, b4 + 1693, b4 + 1694, b4 + 1695, b4 + 1696, b4 + 1697, b4 + 1698, b15 + 1699, b15 + 1700, b15 + 1701, b1 + 1702, b1 + 1703, b4 + 1704, b4 + 1705, b4 + 1706, b4 + 1707, b4 + 1708, b4 + 1709, b4 + 1710, b4 + 1711, b4 + 1712, b4 + 1713, b4 + 1714, b4 + 1715, b4 + 1716, b4 + 1717, b4 + 1718, b4 + 1719, b4 + 1720, b4 + 1721, b4 + 1722, b4 + 1723, b4 + 1724 }, new String[] { "glClientAttribDefaultEXT", "glPushClientAttribDefaultEXT", "glMatrixLoadfEXT", "glMatrixLoaddEXT", "glMatrixMultfEXT", "glMatrixMultdEXT", "glMatrixLoadIdentityEXT", "glMatrixRotatefEXT", "glMatrixRotatedEXT", "glMatrixScalefEXT", "glMatrixScaledEXT", "glMatrixTranslatefEXT", "glMatrixTranslatedEXT", "glMatrixOrthoEXT", "glMatrixFrustumEXT", "glMatrixPushEXT", "glMatrixPopEXT", "glTextureParameteriEXT", "glTextureParameterivEXT", "glTextureParameterfEXT", "glTextureParameterfvEXT", "glTextureImage1DEXT", "glTextureImage2DEXT", "glTextureSubImage1DEXT", "glTextureSubImage2DEXT", "glCopyTextureImage1DEXT", "glCopyTextureImage2DEXT", "glCopyTextureSubImage1DEXT", "glCopyTextureSubImage2DEXT", "glGetTextureImageEXT", "glGetTextureParameterfvEXT", "glGetTextureParameterivEXT", "glGetTextureLevelParameterfvEXT", "glGetTextureLevelParameterivEXT", "glTextureImage3DEXT", "glTextureSubImage3DEXT", "glCopyTextureSubImage3DEXT", "glBindMultiTextureEXT", "glMultiTexCoordPointerEXT", "glMultiTexEnvfEXT", "glMultiTexEnvfvEXT", "glMultiTexEnviEXT", "glMultiTexEnvivEXT", "glMultiTexGendEXT", "glMultiTexGendvEXT", "glMultiTexGenfEXT", "glMultiTexGenfvEXT", "glMultiTexGeniEXT", "glMultiTexGenivEXT", "glGetMultiTexEnvfvEXT", "glGetMultiTexEnvivEXT", "glGetMultiTexGendvEXT", "glGetMultiTexGenfvEXT", "glGetMultiTexGenivEXT", "glMultiTexParameteriEXT", "glMultiTexParameterivEXT", "glMultiTexParameterfEXT", "glMultiTexParameterfvEXT", "glMultiTexImage1DEXT", "glMultiTexImage2DEXT", "glMultiTexSubImage1DEXT", "glMultiTexSubImage2DEXT", "glCopyMultiTexImage1DEXT", "glCopyMultiTexImage2DEXT", "glCopyMultiTexSubImage1DEXT", "glCopyMultiTexSubImage2DEXT", "glGetMultiTexImageEXT", "glGetMultiTexParameterfvEXT", "glGetMultiTexParameterivEXT", "glGetMultiTexLevelParameterfvEXT", "glGetMultiTexLevelParameterivEXT", "glMultiTexImage3DEXT", "glMultiTexSubImage3DEXT", "glCopyMultiTexSubImage3DEXT", "glEnableClientStateIndexedEXT", "glDisableClientStateIndexedEXT", "glGetFloatIndexedvEXT", "glGetDoubleIndexedvEXT", "glGetPointerIndexedvEXT", "glEnableIndexedEXT", "glDisableIndexedEXT", "glIsEnabledIndexedEXT", "glGetIntegerIndexedvEXT", "glGetBooleanIndexedvEXT", "glNamedProgramStringEXT", "glNamedProgramLocalParameter4dEXT", "glNamedProgramLocalParameter4dvEXT", "glNamedProgramLocalParameter4fEXT", "glNamedProgramLocalParameter4fvEXT", "glGetNamedProgramLocalParameterdvEXT", "glGetNamedProgramLocalParameterfvEXT", "glGetNamedProgramivEXT", "glGetNamedProgramStringEXT", "glCompressedTextureImage3DEXT", "glCompressedTextureImage2DEXT", "glCompressedTextureImage1DEXT", "glCompressedTextureSubImage3DEXT", "glCompressedTextureSubImage2DEXT", "glCompressedTextureSubImage1DEXT", "glGetCompressedTextureImageEXT", "glCompressedMultiTexImage3DEXT", "glCompressedMultiTexImage2DEXT", "glCompressedMultiTexImage1DEXT", "glCompressedMultiTexSubImage3DEXT", "glCompressedMultiTexSubImage2DEXT", "glCompressedMultiTexSubImage1DEXT", "glGetCompressedMultiTexImageEXT", "glMatrixLoadTransposefEXT", "glMatrixLoadTransposedEXT", "glMatrixMultTransposefEXT", "glMatrixMultTransposedEXT", "glNamedBufferDataEXT", "glNamedBufferSubDataEXT", "glMapNamedBufferEXT", "glUnmapNamedBufferEXT", "glGetNamedBufferParameterivEXT", "glGetNamedBufferSubDataEXT", "glProgramUniform1fEXT", "glProgramUniform2fEXT", "glProgramUniform3fEXT", "glProgramUniform4fEXT", "glProgramUniform1iEXT", "glProgramUniform2iEXT", "glProgramUniform3iEXT", "glProgramUniform4iEXT", "glProgramUniform1fvEXT", "glProgramUniform2fvEXT", "glProgramUniform3fvEXT", "glProgramUniform4fvEXT", "glProgramUniform1ivEXT", "glProgramUniform2ivEXT", "glProgramUniform3ivEXT", "glProgramUniform4ivEXT", "glProgramUniformMatrix2fvEXT", "glProgramUniformMatrix3fvEXT", "glProgramUniformMatrix4fvEXT", "glProgramUniformMatrix2x3fvEXT", "glProgramUniformMatrix3x2fvEXT", "glProgramUniformMatrix2x4fvEXT", "glProgramUniformMatrix4x2fvEXT", "glProgramUniformMatrix3x4fvEXT", "glProgramUniformMatrix4x3fvEXT", "glTextureBufferEXT", "glMultiTexBufferEXT", "glTextureParameterIivEXT", "glTextureParameterIuivEXT", "glGetTextureParameterIivEXT", "glGetTextureParameterIuivEXT", "glMultiTexParameterIivEXT", "glMultiTexParameterIuivEXT", "glGetMultiTexParameterIivEXT", "glGetMultiTexParameterIuivEXT", "glProgramUniform1uiEXT", "glProgramUniform2uiEXT", "glProgramUniform3uiEXT", "glProgramUniform4uiEXT", "glProgramUniform1uivEXT", "glProgramUniform2uivEXT", "glProgramUniform3uivEXT", "glProgramUniform4uivEXT", "glNamedProgramLocalParameters4fvEXT", "glNamedProgramLocalParameterI4iEXT", "glNamedProgramLocalParameterI4ivEXT", "glNamedProgramLocalParametersI4ivEXT", "glNamedProgramLocalParameterI4uiEXT", "glNamedProgramLocalParameterI4uivEXT", "glNamedProgramLocalParametersI4uivEXT", "glGetNamedProgramLocalParameterIivEXT", "glGetNamedProgramLocalParameterIuivEXT", "glNamedRenderbufferStorageEXT", "glGetNamedRenderbufferParameterivEXT", "glNamedRenderbufferStorageMultisampleEXT", "glNamedRenderbufferStorageMultisampleCoverageEXT", "glCheckNamedFramebufferStatusEXT", "glNamedFramebufferTexture1DEXT", "glNamedFramebufferTexture2DEXT", "glNamedFramebufferTexture3DEXT", "glNamedFramebufferRenderbufferEXT", "glGetNamedFramebufferAttachmentParameterivEXT", "glGenerateTextureMipmapEXT", "glGenerateMultiTexMipmapEXT", "glFramebufferDrawBufferEXT", "glFramebufferDrawBuffersEXT", "glFramebufferReadBufferEXT", "glGetFramebufferParameterivEXT", "glNamedCopyBufferSubDataEXT", "glNamedFramebufferTextureEXT", "glNamedFramebufferTextureLayerEXT", "glNamedFramebufferTextureFaceEXT", "glTextureRenderbufferEXT", "glMultiTexRenderbufferEXT", "glVertexArrayVertexOffsetEXT", "glVertexArrayColorOffsetEXT", "glVertexArrayEdgeFlagOffsetEXT", "glVertexArrayIndexOffsetEXT", "glVertexArrayNormalOffsetEXT", "glVertexArrayTexCoordOffsetEXT", "glVertexArrayMultiTexCoordOffsetEXT", "glVertexArrayFogCoordOffsetEXT", "glVertexArraySecondaryColorOffsetEXT", "glVertexArrayVertexAttribOffsetEXT", "glVertexArrayVertexAttribIOffsetEXT", "glEnableVertexArrayEXT", "glDisableVertexArrayEXT", "glEnableVertexArrayAttribEXT", "glDisableVertexArrayAttribEXT", "glGetVertexArrayIntegervEXT", "glGetVertexArrayPointervEXT", "glGetVertexArrayIntegeri_vEXT", "glGetVertexArrayPointeri_vEXT", "glMapNamedBufferRangeEXT", "glFlushMappedNamedBufferRangeEXT"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  9531 */         }) || Checks.reportMissing("GL", "GL_EXT_direct_state_access")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_draw_buffers2(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9535 */     if (!paramSet.contains("GL_EXT_draw_buffers2")) {
/*  9536 */       return false;
/*       */     }
/*       */     
/*  9539 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1725, 1596, 1595, 1592, 1593, 1594 }, new String[] { "glColorMaskIndexedEXT", "glGetBooleanIndexedvEXT", "glGetIntegerIndexedvEXT", "glEnableIndexedEXT", "glDisableIndexedEXT", "glIsEnabledIndexedEXT"
/*       */ 
/*       */ 
/*       */         
/*  9543 */         }) || Checks.reportMissing("GL", "GL_EXT_draw_buffers2")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_draw_instanced(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9547 */     if (!paramSet.contains("GL_EXT_draw_instanced")) {
/*  9548 */       return false;
/*       */     }
/*       */     
/*  9551 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1726, 1727 }, new String[] { "glDrawArraysInstancedEXT", "glDrawElementsInstancedEXT"
/*       */ 
/*       */ 
/*       */         
/*  9555 */         }) || Checks.reportMissing("GL", "GL_EXT_draw_instanced")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_EGL_image_storage(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9559 */     if (!paramSet.contains("GL_EXT_EGL_image_storage")) {
/*  9560 */       return false;
/*       */     }
/*       */     
/*  9563 */     byte b = hasDSA(paramSet) ? 0 : -2147483648;
/*       */     
/*  9565 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1728, b + 1729 }, new String[] { "glEGLImageTargetTexStorageEXT", "glEGLImageTargetTextureStorageEXT"
/*       */ 
/*       */ 
/*       */         
/*  9569 */         }) || Checks.reportMissing("GL", "GL_EXT_EGL_image_storage")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_external_buffer(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9573 */     if (!paramSet.contains("GL_EXT_external_buffer")) {
/*  9574 */       return false;
/*       */     }
/*       */     
/*  9577 */     byte b = hasDSA(paramSet) ? 0 : -2147483648;
/*       */     
/*  9579 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1730, b + 1731 }, new String[] { "glBufferStorageExternalEXT", "glNamedBufferStorageExternalEXT"
/*       */ 
/*       */ 
/*       */         
/*  9583 */         }) || Checks.reportMissing("GL", "GL_EXT_external_buffer")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_framebuffer_blit(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9587 */     if (!paramSet.contains("GL_EXT_framebuffer_blit")) {
/*  9588 */       return false;
/*       */     }
/*       */     
/*  9591 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1732 }, new String[] { "glBlitFramebufferEXT"
/*       */ 
/*       */ 
/*       */         
/*  9595 */         }) || Checks.reportMissing("GL", "GL_EXT_framebuffer_blit")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_framebuffer_blit_layers(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9599 */     if (!paramSet.contains("GL_EXT_framebuffer_blit_layers")) {
/*  9600 */       return false;
/*       */     }
/*       */     
/*  9603 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1733, 1734 }, new String[] { "glBlitFramebufferLayersEXT", "glBlitFramebufferLayerEXT"
/*       */ 
/*       */ 
/*       */         
/*  9607 */         }) || Checks.reportMissing("GL", "GL_EXT_framebuffer_blit_layers")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_framebuffer_multisample(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9611 */     if (!paramSet.contains("GL_EXT_framebuffer_multisample")) {
/*  9612 */       return false;
/*       */     }
/*       */     
/*  9615 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1735 }, new String[] { "glRenderbufferStorageMultisampleEXT"
/*       */ 
/*       */ 
/*       */         
/*  9619 */         }) || Checks.reportMissing("GL", "GL_EXT_framebuffer_multisample")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_framebuffer_object(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9623 */     if (!paramSet.contains("GL_EXT_framebuffer_object")) {
/*  9624 */       return false;
/*       */     }
/*       */     
/*  9627 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1736, 1737, 1738, 1739, 1740, 1741, 1742, 1743, 1744, 1745, 1746, 1747, 1748, 1749, 1750, 1751, 1752 }, new String[] { "glIsRenderbufferEXT", "glBindRenderbufferEXT", "glDeleteRenderbuffersEXT", "glGenRenderbuffersEXT", "glRenderbufferStorageEXT", "glGetRenderbufferParameterivEXT", "glIsFramebufferEXT", "glBindFramebufferEXT", "glDeleteFramebuffersEXT", "glGenFramebuffersEXT", "glCheckFramebufferStatusEXT", "glFramebufferTexture1DEXT", "glFramebufferTexture2DEXT", "glFramebufferTexture3DEXT", "glFramebufferRenderbufferEXT", "glGetFramebufferAttachmentParameterivEXT", "glGenerateMipmapEXT"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  9634 */         }) || Checks.reportMissing("GL", "GL_EXT_framebuffer_object")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_geometry_shader4(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9638 */     if (!paramSet.contains("GL_EXT_geometry_shader4")) {
/*  9639 */       return false;
/*       */     }
/*       */     
/*  9642 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1753, 1754, 1755, 1756 }, new String[] { "glProgramParameteriEXT", "glFramebufferTextureEXT", "glFramebufferTextureLayerEXT", "glFramebufferTextureFaceEXT"
/*       */ 
/*       */ 
/*       */         
/*  9646 */         }) || Checks.reportMissing("GL", "GL_EXT_geometry_shader4")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_gpu_program_parameters(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9650 */     if (!paramSet.contains("GL_EXT_gpu_program_parameters")) {
/*  9651 */       return false;
/*       */     }
/*       */     
/*  9654 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1757, 1758 }, new String[] { "glProgramEnvParameters4fvEXT", "glProgramLocalParameters4fvEXT"
/*       */ 
/*       */ 
/*       */         
/*  9658 */         }) || Checks.reportMissing("GL", "GL_EXT_gpu_program_parameters")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_gpu_shader4(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9662 */     if (!paramSet.contains("GL_EXT_gpu_shader4")) {
/*  9663 */       return false;
/*       */     }
/*       */     
/*  9666 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1759, 1760, 1761, 1762, 1763, 1764, 1765, 1766, 1767, 1768, 1769, 1770, 1771, 1772, 1773, 1774, 1775, 1776, 1777, 1778, 1779, 1780, 1781, 1782, 1783, 1784, 1785, 1786, 1787, 1788, 1789, 1790, 1791, 1792 }, new String[] { "glVertexAttribI1iEXT", "glVertexAttribI2iEXT", "glVertexAttribI3iEXT", "glVertexAttribI4iEXT", "glVertexAttribI1uiEXT", "glVertexAttribI2uiEXT", "glVertexAttribI3uiEXT", "glVertexAttribI4uiEXT", "glVertexAttribI1ivEXT", "glVertexAttribI2ivEXT", "glVertexAttribI3ivEXT", "glVertexAttribI4ivEXT", "glVertexAttribI1uivEXT", "glVertexAttribI2uivEXT", "glVertexAttribI3uivEXT", "glVertexAttribI4uivEXT", "glVertexAttribI4bvEXT", "glVertexAttribI4svEXT", "glVertexAttribI4ubvEXT", "glVertexAttribI4usvEXT", "glVertexAttribIPointerEXT", "glGetVertexAttribIivEXT", "glGetVertexAttribIuivEXT", "glGetUniformuivEXT", "glBindFragDataLocationEXT", "glGetFragDataLocationEXT", "glUniform1uiEXT", "glUniform2uiEXT", "glUniform3uiEXT", "glUniform4uiEXT", "glUniform1uivEXT", "glUniform2uivEXT", "glUniform3uivEXT", "glUniform4uivEXT"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  9677 */         }) || Checks.reportMissing("GL", "GL_EXT_gpu_shader4")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_memory_object(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9681 */     if (!paramSet.contains("GL_EXT_memory_object")) {
/*  9682 */       return false;
/*       */     }
/*       */     
/*  9685 */     byte b = hasDSA(paramSet) ? 0 : -2147483648;
/*       */     
/*  9687 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1793, 1794, 1795, 1796, 1797, 1798, 1799, 1800, 1801, 1802, 1803, 1804, b + 1805, b + 1806, b + 1807, b + 1808, b + 1809, 1810, b + 1811 }, new String[] { "glGetUnsignedBytevEXT", "glGetUnsignedBytei_vEXT", "glDeleteMemoryObjectsEXT", "glIsMemoryObjectEXT", "glCreateMemoryObjectsEXT", "glMemoryObjectParameterivEXT", "glGetMemoryObjectParameterivEXT", "glTexStorageMem2DEXT", "glTexStorageMem2DMultisampleEXT", "glTexStorageMem3DEXT", "glTexStorageMem3DMultisampleEXT", "glBufferStorageMemEXT", "glTextureStorageMem2DEXT", "glTextureStorageMem2DMultisampleEXT", "glTextureStorageMem3DEXT", "glTextureStorageMem3DMultisampleEXT", "glNamedBufferStorageMemEXT", "glTexStorageMem1DEXT", "glTextureStorageMem1DEXT"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  9696 */         }) || Checks.reportMissing("GL", "GL_EXT_memory_object")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_memory_object_fd(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9700 */     if (!paramSet.contains("GL_EXT_memory_object_fd")) {
/*  9701 */       return false;
/*       */     }
/*       */     
/*  9704 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1812 }, new String[] { "glImportMemoryFdEXT"
/*       */ 
/*       */ 
/*       */         
/*  9708 */         }) || Checks.reportMissing("GL", "GL_EXT_memory_object_fd")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_memory_object_win32(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9712 */     if (!paramSet.contains("GL_EXT_memory_object_win32")) {
/*  9713 */       return false;
/*       */     }
/*       */     
/*  9716 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1813, 1814 }, new String[] { "glImportMemoryWin32HandleEXT", "glImportMemoryWin32NameEXT"
/*       */ 
/*       */ 
/*       */         
/*  9720 */         }) || Checks.reportMissing("GL", "GL_EXT_memory_object_win32")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_point_parameters(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9724 */     if (!paramSet.contains("GL_EXT_point_parameters")) {
/*  9725 */       return false;
/*       */     }
/*       */     
/*  9728 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1815, 1816 }, new String[] { "glPointParameterfEXT", "glPointParameterfvEXT"
/*       */ 
/*       */ 
/*       */         
/*  9732 */         }) || Checks.reportMissing("GL", "GL_EXT_point_parameters")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_polygon_offset_clamp(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9736 */     if (!paramSet.contains("GL_EXT_polygon_offset_clamp")) {
/*  9737 */       return false;
/*       */     }
/*       */     
/*  9740 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1817 }, new String[] { "glPolygonOffsetClampEXT"
/*       */ 
/*       */ 
/*       */         
/*  9744 */         }) || Checks.reportMissing("GL", "GL_EXT_polygon_offset_clamp")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_provoking_vertex(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9748 */     if (!paramSet.contains("GL_EXT_provoking_vertex")) {
/*  9749 */       return false;
/*       */     }
/*       */     
/*  9752 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1818 }, new String[] { "glProvokingVertexEXT"
/*       */ 
/*       */ 
/*       */         
/*  9756 */         }) || Checks.reportMissing("GL", "GL_EXT_provoking_vertex")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_raster_multisample(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9760 */     if (!paramSet.contains("GL_EXT_raster_multisample")) {
/*  9761 */       return false;
/*       */     }
/*       */     
/*  9764 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1819 }, new String[] { "glRasterSamplesEXT"
/*       */ 
/*       */ 
/*       */         
/*  9768 */         }) || Checks.reportMissing("GL", "GL_EXT_raster_multisample")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_secondary_color(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9772 */     if (!paramSet.contains("GL_EXT_secondary_color")) {
/*  9773 */       return false;
/*       */     }
/*       */     
/*  9776 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1820, 1821, 1822, 1823, 1824, 1825, 1826, 1827, 1828, 1829, 1830, 1831, 1832, 1833, 1834, 1835, 1836 }, new String[] { "glSecondaryColor3bEXT", "glSecondaryColor3sEXT", "glSecondaryColor3iEXT", "glSecondaryColor3fEXT", "glSecondaryColor3dEXT", "glSecondaryColor3ubEXT", "glSecondaryColor3usEXT", "glSecondaryColor3uiEXT", "glSecondaryColor3bvEXT", "glSecondaryColor3svEXT", "glSecondaryColor3ivEXT", "glSecondaryColor3fvEXT", "glSecondaryColor3dvEXT", "glSecondaryColor3ubvEXT", "glSecondaryColor3usvEXT", "glSecondaryColor3uivEXT", "glSecondaryColorPointerEXT"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  9783 */         }) || Checks.reportMissing("GL", "GL_EXT_secondary_color")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_semaphore(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9787 */     if (!paramSet.contains("GL_EXT_semaphore")) {
/*  9788 */       return false;
/*       */     }
/*       */     
/*  9791 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1793, 1794, 1837, 1838, 1839, 1840, 1841, 1842, 1843 }, new String[] { "glGetUnsignedBytevEXT", "glGetUnsignedBytei_vEXT", "glGenSemaphoresEXT", "glDeleteSemaphoresEXT", "glIsSemaphoreEXT", "glSemaphoreParameterui64vEXT", "glGetSemaphoreParameterui64vEXT", "glWaitSemaphoreEXT", "glSignalSemaphoreEXT"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  9796 */         }) || Checks.reportMissing("GL", "GL_EXT_semaphore")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_semaphore_fd(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9800 */     if (!paramSet.contains("GL_EXT_semaphore_fd")) {
/*  9801 */       return false;
/*       */     }
/*       */     
/*  9804 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1844 }, new String[] { "glImportSemaphoreFdEXT"
/*       */ 
/*       */ 
/*       */         
/*  9808 */         }) || Checks.reportMissing("GL", "GL_EXT_semaphore_fd")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_semaphore_win32(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9812 */     if (!paramSet.contains("GL_EXT_semaphore_win32")) {
/*  9813 */       return false;
/*       */     }
/*       */     
/*  9816 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1845, 1846 }, new String[] { "glImportSemaphoreWin32HandleEXT", "glImportSemaphoreWin32NameEXT"
/*       */ 
/*       */ 
/*       */         
/*  9820 */         }) || Checks.reportMissing("GL", "GL_EXT_semaphore_win32")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_separate_shader_objects(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9824 */     if (!paramSet.contains("GL_EXT_separate_shader_objects")) {
/*  9825 */       return false;
/*       */     }
/*       */     
/*  9828 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1847, 1848, 1849 }, new String[] { "glUseShaderProgramEXT", "glActiveProgramEXT", "glCreateShaderProgramEXT"
/*       */ 
/*       */ 
/*       */         
/*  9832 */         }) || Checks.reportMissing("GL", "GL_EXT_separate_shader_objects")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_shader_framebuffer_fetch_non_coherent(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9836 */     if (!paramSet.contains("GL_EXT_shader_framebuffer_fetch_non_coherent")) {
/*  9837 */       return false;
/*       */     }
/*       */     
/*  9840 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1850 }, new String[] { "glFramebufferFetchBarrierEXT"
/*       */ 
/*       */ 
/*       */         
/*  9844 */         }) || Checks.reportMissing("GL", "GL_EXT_shader_framebuffer_fetch_non_coherent")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_shader_image_load_store(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9848 */     if (!paramSet.contains("GL_EXT_shader_image_load_store")) {
/*  9849 */       return false;
/*       */     }
/*       */     
/*  9852 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1851, 1852 }, new String[] { "glBindImageTextureEXT", "glMemoryBarrierEXT"
/*       */ 
/*       */ 
/*       */         
/*  9856 */         }) || Checks.reportMissing("GL", "GL_EXT_shader_image_load_store")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_stencil_clear_tag(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9860 */     if (!paramSet.contains("GL_EXT_stencil_clear_tag")) {
/*  9861 */       return false;
/*       */     }
/*       */     
/*  9864 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1853 }, new String[] { "glStencilClearTagEXT"
/*       */ 
/*       */ 
/*       */         
/*  9868 */         }) || Checks.reportMissing("GL", "GL_EXT_stencil_clear_tag")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_stencil_two_side(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9872 */     if (!paramSet.contains("GL_EXT_stencil_two_side")) {
/*  9873 */       return false;
/*       */     }
/*       */     
/*  9876 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1854 }, new String[] { "glActiveStencilFaceEXT"
/*       */ 
/*       */ 
/*       */         
/*  9880 */         }) || Checks.reportMissing("GL", "GL_EXT_stencil_two_side")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_texture_array(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9884 */     if (!paramSet.contains("GL_EXT_texture_array")) {
/*  9885 */       return false;
/*       */     }
/*       */     
/*  9888 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1755 }, new String[] { "glFramebufferTextureLayerEXT"
/*       */ 
/*       */ 
/*       */         
/*  9892 */         }) || Checks.reportMissing("GL", "GL_EXT_texture_array")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_texture_buffer_object(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9896 */     if (!paramSet.contains("GL_EXT_texture_buffer_object")) {
/*  9897 */       return false;
/*       */     }
/*       */     
/*  9900 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1855 }, new String[] { "glTexBufferEXT"
/*       */ 
/*       */ 
/*       */         
/*  9904 */         }) || Checks.reportMissing("GL", "GL_EXT_texture_buffer_object")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_texture_integer(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9908 */     if (!paramSet.contains("GL_EXT_texture_integer")) {
/*  9909 */       return false;
/*       */     }
/*       */     
/*  9912 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1856, 1857, 1858, 1859, 1860, 1861 }, new String[] { "glClearColorIiEXT", "glClearColorIuiEXT", "glTexParameterIivEXT", "glTexParameterIuivEXT", "glGetTexParameterIivEXT", "glGetTexParameterIuivEXT"
/*       */ 
/*       */ 
/*       */         
/*  9916 */         }) || Checks.reportMissing("GL", "GL_EXT_texture_integer")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_texture_storage(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9920 */     if (!paramSet.contains("GL_EXT_texture_storage")) {
/*  9921 */       return false;
/*       */     }
/*       */     
/*  9924 */     byte b = hasDSA(paramSet) ? 0 : -2147483648;
/*       */     
/*  9926 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1862, 1863, 1864, b + 1375, b + 1376, b + 1377 }, new String[] { "glTexStorage1DEXT", "glTexStorage2DEXT", "glTexStorage3DEXT", "glTextureStorage1DEXT", "glTextureStorage2DEXT", "glTextureStorage3DEXT"
/*       */ 
/*       */ 
/*       */         
/*  9930 */         }) || Checks.reportMissing("GL", "GL_EXT_texture_storage")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_timer_query(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9934 */     if (!paramSet.contains("GL_EXT_timer_query")) {
/*  9935 */       return false;
/*       */     }
/*       */     
/*  9938 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1865, 1866 }, new String[] { "glGetQueryObjecti64vEXT", "glGetQueryObjectui64vEXT"
/*       */ 
/*       */ 
/*       */         
/*  9942 */         }) || Checks.reportMissing("GL", "GL_EXT_timer_query")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_transform_feedback(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9946 */     if (!paramSet.contains("GL_EXT_transform_feedback")) {
/*  9947 */       return false;
/*       */     }
/*       */     
/*  9950 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1867, 1868, 1869, 1870, 1871, 1872, 1873, 1595, 1596 }, new String[] { "glBindBufferRangeEXT", "glBindBufferOffsetEXT", "glBindBufferBaseEXT", "glBeginTransformFeedbackEXT", "glEndTransformFeedbackEXT", "glTransformFeedbackVaryingsEXT", "glGetTransformFeedbackVaryingEXT", "glGetIntegerIndexedvEXT", "glGetBooleanIndexedvEXT"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  9955 */         }) || Checks.reportMissing("GL", "GL_EXT_transform_feedback")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_vertex_attrib_64bit(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9959 */     if (!paramSet.contains("GL_EXT_vertex_attrib_64bit")) {
/*  9960 */       return false;
/*       */     }
/*       */     
/*  9963 */     byte b = paramSet.contains("GL_EXT_direct_state_access") ? 0 : -2147483648;
/*       */     
/*  9965 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1874, 1875, 1876, 1877, 1878, 1879, 1880, 1881, 1882, 1883, b + 1384 }, new String[] { "glVertexAttribL1dEXT", "glVertexAttribL2dEXT", "glVertexAttribL3dEXT", "glVertexAttribL4dEXT", "glVertexAttribL1dvEXT", "glVertexAttribL2dvEXT", "glVertexAttribL3dvEXT", "glVertexAttribL4dvEXT", "glVertexAttribLPointerEXT", "glGetVertexAttribLdvEXT", "glVertexArrayVertexAttribLOffsetEXT"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  9970 */         }) || Checks.reportMissing("GL", "GL_EXT_vertex_attrib_64bit")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_win32_keyed_mutex(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9974 */     if (!paramSet.contains("GL_EXT_win32_keyed_mutex")) {
/*  9975 */       return false;
/*       */     }
/*       */     
/*  9978 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1884, 1885 }, new String[] { "glAcquireKeyedMutexWin32EXT", "glReleaseKeyedMutexWin32EXT"
/*       */ 
/*       */ 
/*       */         
/*  9982 */         }) || Checks.reportMissing("GL", "GL_EXT_win32_keyed_mutex")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_window_rectangles(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9986 */     if (!paramSet.contains("GL_EXT_window_rectangles")) {
/*  9987 */       return false;
/*       */     }
/*       */     
/*  9990 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1886 }, new String[] { "glWindowRectanglesEXT"
/*       */ 
/*       */ 
/*       */         
/*  9994 */         }) || Checks.reportMissing("GL", "GL_EXT_window_rectangles")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_EXT_x11_sync_object(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/*  9998 */     if (!paramSet.contains("GL_EXT_x11_sync_object")) {
/*  9999 */       return false;
/*       */     }
/*       */     
/* 10002 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1887 }, new String[] { "glImportSyncEXT"
/*       */ 
/*       */ 
/*       */         
/* 10006 */         }) || Checks.reportMissing("GL", "GL_EXT_x11_sync_object")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_GREMEDY_frame_terminator(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10010 */     if (!paramSet.contains("GL_GREMEDY_frame_terminator")) {
/* 10011 */       return false;
/*       */     }
/*       */     
/* 10014 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1888 }, new String[] { "glFrameTerminatorGREMEDY"
/*       */ 
/*       */ 
/*       */         
/* 10018 */         }) || Checks.reportMissing("GL", "GL_GREMEDY_frame_terminator")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_GREMEDY_string_marker(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10022 */     if (!paramSet.contains("GL_GREMEDY_string_marker")) {
/* 10023 */       return false;
/*       */     }
/*       */     
/* 10026 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1889 }, new String[] { "glStringMarkerGREMEDY"
/*       */ 
/*       */ 
/*       */         
/* 10030 */         }) || Checks.reportMissing("GL", "GL_GREMEDY_string_marker")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_INTEL_framebuffer_CMAA(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10034 */     if (!paramSet.contains("GL_INTEL_framebuffer_CMAA")) {
/* 10035 */       return false;
/*       */     }
/*       */     
/* 10038 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1890 }, new String[] { "glApplyFramebufferAttachmentCMAAINTEL"
/*       */ 
/*       */ 
/*       */         
/* 10042 */         }) || Checks.reportMissing("GL", "GL_INTEL_framebuffer_CMAA")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_INTEL_map_texture(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10046 */     if (!paramSet.contains("GL_INTEL_map_texture")) {
/* 10047 */       return false;
/*       */     }
/*       */     
/* 10050 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1891, 1892, 1893 }, new String[] { "glSyncTextureINTEL", "glUnmapTexture2DINTEL", "glMapTexture2DINTEL"
/*       */ 
/*       */ 
/*       */         
/* 10054 */         }) || Checks.reportMissing("GL", "GL_INTEL_map_texture")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_INTEL_performance_query(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10058 */     if (!paramSet.contains("GL_INTEL_performance_query")) {
/* 10059 */       return false;
/*       */     }
/*       */     
/* 10062 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1894, 1895, 1896, 1897, 1898, 1899, 1900, 1901, 1902, 1903 }, new String[] { "glBeginPerfQueryINTEL", "glCreatePerfQueryINTEL", "glDeletePerfQueryINTEL", "glEndPerfQueryINTEL", "glGetFirstPerfQueryIdINTEL", "glGetNextPerfQueryIdINTEL", "glGetPerfCounterInfoINTEL", "glGetPerfQueryDataINTEL", "glGetPerfQueryIdByNameINTEL", "glGetPerfQueryInfoINTEL"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 10067 */         }) || Checks.reportMissing("GL", "GL_INTEL_performance_query")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_KHR_blend_equation_advanced(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10071 */     if (!paramSet.contains("GL_KHR_blend_equation_advanced")) {
/* 10072 */       return false;
/*       */     }
/*       */     
/* 10075 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1904 }, new String[] { "glBlendBarrierKHR"
/*       */ 
/*       */ 
/*       */         
/* 10079 */         }) || Checks.reportMissing("GL", "GL_KHR_blend_equation_advanced")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_KHR_debug(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10083 */     if (!paramSet.contains("GL_KHR_debug")) {
/* 10084 */       return false;
/*       */     }
/*       */     
/* 10087 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 875, 876, 877, 878, 879, 880, 881, 882, 883, 884 }, new String[] { "glDebugMessageControl", "glDebugMessageInsert", "glDebugMessageCallback", "glGetDebugMessageLog", "glPushDebugGroup", "glPopDebugGroup", "glObjectLabel", "glGetObjectLabel", "glObjectPtrLabel", "glGetObjectPtrLabel"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 10092 */         }) || Checks.reportMissing("GL", "GL_KHR_debug")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_KHR_parallel_shader_compile(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10096 */     if (!paramSet.contains("GL_KHR_parallel_shader_compile")) {
/* 10097 */       return false;
/*       */     }
/*       */     
/* 10100 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1905 }, new String[] { "glMaxShaderCompilerThreadsKHR"
/*       */ 
/*       */ 
/*       */         
/* 10104 */         }) || Checks.reportMissing("GL", "GL_KHR_parallel_shader_compile")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_KHR_robustness(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10108 */     if (!paramSet.contains("GL_KHR_robustness")) {
/* 10109 */       return false;
/*       */     }
/*       */     
/* 10112 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1024, 1033, 1040, 1042, 1043 }, new String[] { "glGetGraphicsResetStatus", "glReadnPixels", "glGetnUniformfv", "glGetnUniformiv", "glGetnUniformuiv"
/*       */ 
/*       */ 
/*       */         
/* 10116 */         }) || Checks.reportMissing("GL", "GL_KHR_robustness")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_MESA_framebuffer_flip_y(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10120 */     if (!paramSet.contains("GL_MESA_framebuffer_flip_y")) {
/* 10121 */       return false;
/*       */     }
/*       */     
/* 10124 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1906, 1907 }, new String[] { "glFramebufferParameteriMESA", "glGetFramebufferParameterivMESA"
/*       */ 
/*       */ 
/*       */         
/* 10128 */         }) || Checks.reportMissing("GL", "GL_MESA_framebuffer_flip_y")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_alpha_to_coverage_dither_control(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10132 */     if (!paramSet.contains("GL_NV_alpha_to_coverage_dither_control")) {
/* 10133 */       return false;
/*       */     }
/*       */     
/* 10136 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1908 }, new String[] { "glAlphaToCoverageDitherControlNV"
/*       */ 
/*       */ 
/*       */         
/* 10140 */         }) || Checks.reportMissing("GL", "GL_NV_alpha_to_coverage_dither_control")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_bindless_multi_draw_indirect(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10144 */     if (!paramSet.contains("GL_NV_bindless_multi_draw_indirect")) {
/* 10145 */       return false;
/*       */     }
/*       */     
/* 10148 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1909, 1910 }, new String[] { "glMultiDrawArraysIndirectBindlessNV", "glMultiDrawElementsIndirectBindlessNV"
/*       */ 
/*       */ 
/*       */         
/* 10152 */         }) || Checks.reportMissing("GL", "GL_NV_bindless_multi_draw_indirect")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_bindless_multi_draw_indirect_count(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10156 */     if (!paramSet.contains("GL_NV_bindless_multi_draw_indirect_count")) {
/* 10157 */       return false;
/*       */     }
/*       */     
/* 10160 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1911, 1912 }, new String[] { "glMultiDrawArraysIndirectBindlessCountNV", "glMultiDrawElementsIndirectBindlessCountNV"
/*       */ 
/*       */ 
/*       */         
/* 10164 */         }) || Checks.reportMissing("GL", "GL_NV_bindless_multi_draw_indirect_count")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_bindless_texture(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10168 */     if (!paramSet.contains("GL_NV_bindless_texture")) {
/* 10169 */       return false;
/*       */     }
/*       */     
/* 10172 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1913, 1914, 1915, 1916, 1917, 1918, 1919, 1920, 1921, 1922, 1923, 1924, 1925 }, new String[] { "glGetTextureHandleNV", "glGetTextureSamplerHandleNV", "glMakeTextureHandleResidentNV", "glMakeTextureHandleNonResidentNV", "glGetImageHandleNV", "glMakeImageHandleResidentNV", "glMakeImageHandleNonResidentNV", "glUniformHandleui64NV", "glUniformHandleui64vNV", "glProgramUniformHandleui64NV", "glProgramUniformHandleui64vNV", "glIsTextureHandleResidentNV", "glIsImageHandleResidentNV"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 10178 */         }) || Checks.reportMissing("GL", "GL_NV_bindless_texture")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_blend_equation_advanced(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10182 */     if (!paramSet.contains("GL_NV_blend_equation_advanced")) {
/* 10183 */       return false;
/*       */     }
/*       */     
/* 10186 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1926, 1927 }, new String[] { "glBlendParameteriNV", "glBlendBarrierNV"
/*       */ 
/*       */ 
/*       */         
/* 10190 */         }) || Checks.reportMissing("GL", "GL_NV_blend_equation_advanced")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_clip_space_w_scaling(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10194 */     if (!paramSet.contains("GL_NV_clip_space_w_scaling")) {
/* 10195 */       return false;
/*       */     }
/*       */     
/* 10198 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1928 }, new String[] { "glViewportPositionWScaleNV"
/*       */ 
/*       */ 
/*       */         
/* 10202 */         }) || Checks.reportMissing("GL", "GL_NV_clip_space_w_scaling")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_command_list(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10206 */     if (!paramSet.contains("GL_NV_command_list")) {
/* 10207 */       return false;
/*       */     }
/*       */     
/* 10210 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1929, 1930, 1931, 1932, 1933, 1934, 1935, 1936, 1937, 1938, 1939, 1940, 1941, 1942, 1943, 1944, 1945 }, new String[] { "glCreateStatesNV", "glDeleteStatesNV", "glIsStateNV", "glStateCaptureNV", "glGetCommandHeaderNV", "glGetStageIndexNV", "glDrawCommandsNV", "glDrawCommandsAddressNV", "glDrawCommandsStatesNV", "glDrawCommandsStatesAddressNV", "glCreateCommandListsNV", "glDeleteCommandListsNV", "glIsCommandListNV", "glListDrawCommandsStatesClientNV", "glCommandListSegmentsNV", "glCompileCommandListNV", "glCallCommandListNV"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 10216 */         }) || Checks.reportMissing("GL", "GL_NV_command_list")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_conditional_render(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10220 */     if (!paramSet.contains("GL_NV_conditional_render")) {
/* 10221 */       return false;
/*       */     }
/*       */     
/* 10224 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1946, 1947 }, new String[] { "glBeginConditionalRenderNV", "glEndConditionalRenderNV"
/*       */ 
/*       */ 
/*       */         
/* 10228 */         }) || Checks.reportMissing("GL", "GL_NV_conditional_render")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_conservative_raster(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10232 */     if (!paramSet.contains("GL_NV_conservative_raster")) {
/* 10233 */       return false;
/*       */     }
/*       */     
/* 10236 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1948 }, new String[] { "glSubpixelPrecisionBiasNV"
/*       */ 
/*       */ 
/*       */         
/* 10240 */         }) || Checks.reportMissing("GL", "GL_NV_conservative_raster")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_conservative_raster_dilate(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10244 */     if (!paramSet.contains("GL_NV_conservative_raster_dilate")) {
/* 10245 */       return false;
/*       */     }
/*       */     
/* 10248 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1949 }, new String[] { "glConservativeRasterParameterfNV"
/*       */ 
/*       */ 
/*       */         
/* 10252 */         }) || Checks.reportMissing("GL", "GL_NV_conservative_raster_dilate")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_conservative_raster_pre_snap_triangles(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10256 */     if (!paramSet.contains("GL_NV_conservative_raster_pre_snap_triangles")) {
/* 10257 */       return false;
/*       */     }
/*       */     
/* 10260 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1950 }, new String[] { "glConservativeRasterParameteriNV"
/*       */ 
/*       */ 
/*       */         
/* 10264 */         }) || Checks.reportMissing("GL", "GL_NV_conservative_raster_pre_snap_triangles")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_copy_image(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10268 */     if (!paramSet.contains("GL_NV_copy_image")) {
/* 10269 */       return false;
/*       */     }
/*       */     
/* 10272 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1951 }, new String[] { "glCopyImageSubDataNV"
/*       */ 
/*       */ 
/*       */         
/* 10276 */         }) || Checks.reportMissing("GL", "GL_NV_copy_image")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_depth_buffer_float(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10280 */     if (!paramSet.contains("GL_NV_depth_buffer_float")) {
/* 10281 */       return false;
/*       */     }
/*       */     
/* 10284 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1952, 1953, 1954 }, new String[] { "glDepthRangedNV", "glClearDepthdNV", "glDepthBoundsdNV"
/*       */ 
/*       */ 
/*       */         
/* 10288 */         }) || Checks.reportMissing("GL", "GL_NV_depth_buffer_float")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_draw_texture(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10292 */     if (!paramSet.contains("GL_NV_draw_texture")) {
/* 10293 */       return false;
/*       */     }
/*       */     
/* 10296 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1955 }, new String[] { "glDrawTextureNV"
/*       */ 
/*       */ 
/*       */         
/* 10300 */         }) || Checks.reportMissing("GL", "GL_NV_draw_texture")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_draw_vulkan_image(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10304 */     if (!paramSet.contains("GL_NV_draw_vulkan_image")) {
/* 10305 */       return false;
/*       */     }
/*       */     
/* 10308 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1956, 1957, 1958, 1959, 1960 }, new String[] { "glDrawVkImageNV", "glGetVkProcAddrNV", "glWaitVkSemaphoreNV", "glSignalVkSemaphoreNV", "glSignalVkFenceNV"
/*       */ 
/*       */ 
/*       */         
/* 10312 */         }) || Checks.reportMissing("GL", "GL_NV_draw_vulkan_image")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_explicit_multisample(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10316 */     if (!paramSet.contains("GL_NV_explicit_multisample")) {
/* 10317 */       return false;
/*       */     }
/*       */     
/* 10320 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1961, 1962, 1963 }, new String[] { "glGetMultisamplefvNV", "glSampleMaskIndexedNV", "glTexRenderbufferNV"
/*       */ 
/*       */ 
/*       */         
/* 10324 */         }) || Checks.reportMissing("GL", "GL_NV_explicit_multisample")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_fence(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10328 */     if (!paramSet.contains("GL_NV_fence")) {
/* 10329 */       return false;
/*       */     }
/*       */     
/* 10332 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1964, 1965, 1966, 1967, 1968, 1969, 1970 }, new String[] { "glDeleteFencesNV", "glGenFencesNV", "glIsFenceNV", "glTestFenceNV", "glGetFenceivNV", "glFinishFenceNV", "glSetFenceNV"
/*       */ 
/*       */ 
/*       */         
/* 10336 */         }) || Checks.reportMissing("GL", "GL_NV_fence")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_fragment_coverage_to_color(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10340 */     if (!paramSet.contains("GL_NV_fragment_coverage_to_color")) {
/* 10341 */       return false;
/*       */     }
/*       */     
/* 10344 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1971 }, new String[] { "glFragmentCoverageColorNV"
/*       */ 
/*       */ 
/*       */         
/* 10348 */         }) || Checks.reportMissing("GL", "GL_NV_fragment_coverage_to_color")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_framebuffer_mixed_samples(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10352 */     if (!paramSet.contains("GL_NV_framebuffer_mixed_samples")) {
/* 10353 */       return false;
/*       */     }
/*       */     
/* 10356 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1819, 1972, 1973, 1974 }, new String[] { "glRasterSamplesEXT", "glCoverageModulationTableNV", "glGetCoverageModulationTableNV", "glCoverageModulationNV"
/*       */ 
/*       */ 
/*       */         
/* 10360 */         }) || Checks.reportMissing("GL", "GL_NV_framebuffer_mixed_samples")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_framebuffer_multisample_coverage(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10364 */     if (!paramSet.contains("GL_NV_framebuffer_multisample_coverage")) {
/* 10365 */       return false;
/*       */     }
/*       */     
/* 10368 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1975 }, new String[] { "glRenderbufferStorageMultisampleCoverageNV"
/*       */ 
/*       */ 
/*       */         
/* 10372 */         }) || Checks.reportMissing("GL", "GL_NV_framebuffer_multisample_coverage")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_gpu_multicast(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10376 */     if (!paramSet.contains("GL_NV_gpu_multicast")) {
/* 10377 */       return false;
/*       */     }
/*       */     
/* 10380 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1976, 1977, 1978, 1979, 1980, 1981, 1982, 1983, 1984, 1985, 1986, 1987 }, new String[] { "glRenderGpuMaskNV", "glMulticastBufferSubDataNV", "glMulticastCopyBufferSubDataNV", "glMulticastCopyImageSubDataNV", "glMulticastBlitFramebufferNV", "glMulticastFramebufferSampleLocationsfvNV", "glMulticastBarrierNV", "glMulticastWaitSyncNV", "glMulticastGetQueryObjectivNV", "glMulticastGetQueryObjectuivNV", "glMulticastGetQueryObjecti64vNV", "glMulticastGetQueryObjectui64vNV"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 10386 */         }) || Checks.reportMissing("GL", "GL_NV_gpu_multicast")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_gpu_shader5(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10390 */     if (!paramSet.contains("GL_NV_gpu_shader5")) {
/* 10391 */       return false;
/*       */     }
/*       */     
/* 10394 */     byte b = paramSet.contains("GL_EXT_direct_state_access") ? 0 : -2147483648;
/*       */     
/* 10396 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1058, 1059, 1060, 1061, 1062, 1063, 1064, 1065, 1066, 1067, 1068, 1069, 1070, 1071, 1072, 1073, 1074, 1075, b + 1076, b + 1077, b + 1078, b + 1079, b + 1080, b + 1081, b + 1082, b + 1083, b + 1084, b + 1085, b + 1086, b + 1087, b + 1088, b + 1089, b + 1090, b + 1091 }, new String[] { "glUniform1i64NV", "glUniform2i64NV", "glUniform3i64NV", "glUniform4i64NV", "glUniform1i64vNV", "glUniform2i64vNV", "glUniform3i64vNV", "glUniform4i64vNV", "glUniform1ui64NV", "glUniform2ui64NV", "glUniform3ui64NV", "glUniform4ui64NV", "glUniform1ui64vNV", "glUniform2ui64vNV", "glUniform3ui64vNV", "glUniform4ui64vNV", "glGetUniformi64vNV", "glGetUniformui64vNV", "glProgramUniform1i64NV", "glProgramUniform2i64NV", "glProgramUniform3i64NV", "glProgramUniform4i64NV", "glProgramUniform1i64vNV", "glProgramUniform2i64vNV", "glProgramUniform3i64vNV", "glProgramUniform4i64vNV", "glProgramUniform1ui64NV", "glProgramUniform2ui64NV", "glProgramUniform3ui64NV", "glProgramUniform4ui64NV", "glProgramUniform1ui64vNV", "glProgramUniform2ui64vNV", "glProgramUniform3ui64vNV", "glProgramUniform4ui64vNV"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 10407 */         }) || Checks.reportMissing("GL", "GL_NV_gpu_shader5")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_half_float(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10411 */     if (!paramSet.contains("GL_NV_half_float")) {
/* 10412 */       return false;
/*       */     }
/*       */     
/* 10415 */     byte b2 = paramSet.contains("GL_EXT_fog_coord") ? 0 : -2147483648;
/* 10416 */     byte b3 = paramSet.contains("GL_EXT_secondary_color") ? 0 : -2147483648;
/* 10417 */     byte b4 = paramSet.contains("GL_EXT_vertex_weighting") ? 0 : -2147483648;
/* 10418 */     byte b1 = paramSet.contains("GL_NV_vertex_program") ? 0 : -2147483648;
/*       */     
/* 10420 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 1988, 1989, 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, b2 + 2016, b2 + 2017, b3 + 2018, b3 + 2019, b4 + 2020, b4 + 2021, b1 + 2022, b1 + 2023, b1 + 2024, b1 + 2025, b1 + 2026, b1 + 2027, b1 + 2028, b1 + 2029, b1 + 2030, b1 + 2031, b1 + 2032, b1 + 2033 }, new String[] { "glVertex2hNV", "glVertex2hvNV", "glVertex3hNV", "glVertex3hvNV", "glVertex4hNV", "glVertex4hvNV", "glNormal3hNV", "glNormal3hvNV", "glColor3hNV", "glColor3hvNV", "glColor4hNV", "glColor4hvNV", "glTexCoord1hNV", "glTexCoord1hvNV", "glTexCoord2hNV", "glTexCoord2hvNV", "glTexCoord3hNV", "glTexCoord3hvNV", "glTexCoord4hNV", "glTexCoord4hvNV", "glMultiTexCoord1hNV", "glMultiTexCoord1hvNV", "glMultiTexCoord2hNV", "glMultiTexCoord2hvNV", "glMultiTexCoord3hNV", "glMultiTexCoord3hvNV", "glMultiTexCoord4hNV", "glMultiTexCoord4hvNV", "glFogCoordhNV", "glFogCoordhvNV", "glSecondaryColor3hNV", "glSecondaryColor3hvNV", "glVertexWeighthNV", "glVertexWeighthvNV", "glVertexAttrib1hNV", "glVertexAttrib1hvNV", "glVertexAttrib2hNV", "glVertexAttrib2hvNV", "glVertexAttrib3hNV", "glVertexAttrib3hvNV", "glVertexAttrib4hNV", "glVertexAttrib4hvNV", "glVertexAttribs1hvNV", "glVertexAttribs2hvNV", "glVertexAttribs3hvNV", "glVertexAttribs4hvNV"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 10432 */         }) || Checks.reportMissing("GL", "GL_NV_half_float")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_internalformat_sample_query(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10436 */     if (!paramSet.contains("GL_NV_internalformat_sample_query")) {
/* 10437 */       return false;
/*       */     }
/*       */     
/* 10440 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2034 }, new String[] { "glGetInternalformatSampleivNV"
/*       */ 
/*       */ 
/*       */         
/* 10444 */         }) || Checks.reportMissing("GL", "GL_NV_internalformat_sample_query")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_memory_attachment(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10448 */     if (!paramSet.contains("GL_NV_memory_attachment")) {
/* 10449 */       return false;
/*       */     }
/*       */     
/* 10452 */     byte b = hasDSA(paramSet) ? 0 : -2147483648;
/*       */     
/* 10454 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2035, 2036, 2037, 2038, b + 2039, b + 2040 }, new String[] { "glGetMemoryObjectDetachedResourcesuivNV", "glResetMemoryObjectParameterNV", "glTexAttachMemoryNV", "glBufferAttachMemoryNV", "glTextureAttachMemoryNV", "glNamedBufferAttachMemoryNV"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 10459 */         }) || Checks.reportMissing("GL", "GL_NV_memory_attachment")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_memory_object_sparse(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10463 */     if (!paramSet.contains("GL_NV_memory_object_sparse")) {
/* 10464 */       return false;
/*       */     }
/*       */     
/* 10467 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2041, 2042, 2043, 2044 }, new String[] { "glBufferPageCommitmentMemNV", "glNamedBufferPageCommitmentMemNV", "glTexPageCommitmentMemNV", "glTexturePageCommitmentMemNV"
/*       */ 
/*       */ 
/*       */         
/* 10471 */         }) || Checks.reportMissing("GL", "GL_NV_memory_object_sparse")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_mesh_shader(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10475 */     if (!paramSet.contains("GL_NV_mesh_shader")) {
/* 10476 */       return false;
/*       */     }
/*       */     
/* 10479 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2045, 2046, 2047, 2048 }, new String[] { "glDrawMeshTasksNV", "glDrawMeshTasksIndirectNV", "glMultiDrawMeshTasksIndirectNV", "glMultiDrawMeshTasksIndirectCountNV"
/*       */ 
/*       */ 
/*       */         
/* 10483 */         }) || Checks.reportMissing("GL", "GL_NV_mesh_shader")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_path_rendering(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10487 */     if (!paramSet.contains("GL_NV_path_rendering")) {
/* 10488 */       return false;
/*       */     }
/*       */     
/* 10491 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2049, 2050, 2051, 2052, 2053, 2054, 2055, 2058, 2060, 2061, 2062, 2063, 2064, 2065, 2066, 2067, 2068, 2069, 2070, 2071, 2072, 2073, 2074, 2075, 2076, 2080, 2081, 2082, 2083, 2090, 2091, 2092, 2093, 2094, 2095, 2096, 2097, 2102, 2103, 2104, 2105 }, new String[] { "glPathCommandsNV", "glPathCoordsNV", "glPathSubCommandsNV", "glPathSubCoordsNV", "glPathStringNV", "glPathGlyphsNV", "glPathGlyphRangeNV", "glCopyPathNV", "glInterpolatePathsNV", "glTransformPathNV", "glPathParameterivNV", "glPathParameteriNV", "glPathParameterfvNV", "glPathParameterfNV", "glPathDashArrayNV", "glGenPathsNV", "glDeletePathsNV", "glIsPathNV", "glPathStencilFuncNV", "glPathStencilDepthOffsetNV", "glStencilFillPathNV", "glStencilStrokePathNV", "glStencilFillPathInstancedNV", "glStencilStrokePathInstancedNV", "glPathCoverDepthFuncNV", "glCoverFillPathNV", "glCoverStrokePathNV", "glCoverFillPathInstancedNV", "glCoverStrokePathInstancedNV", "glGetPathParameterivNV", "glGetPathParameterfvNV", "glGetPathCommandsNV", "glGetPathCoordsNV", "glGetPathDashArrayNV", "glGetPathMetricsNV", "glGetPathMetricRangeNV", "glGetPathSpacingNV", "glIsPointInFillPathNV", "glIsPointInStrokePathNV", "glGetPathLengthNV", "glPointAlongPathNV"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 10502 */         }) || Checks.reportMissing("GL", "GL_NV_path_rendering")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_pixel_data_range(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10506 */     if (!paramSet.contains("GL_NV_pixel_data_range")) {
/* 10507 */       return false;
/*       */     }
/*       */     
/* 10510 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2113, 2114 }, new String[] { "glPixelDataRangeNV", "glFlushPixelDataRangeNV"
/*       */ 
/*       */ 
/*       */         
/* 10514 */         }) || Checks.reportMissing("GL", "GL_NV_pixel_data_range")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_point_sprite(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10518 */     if (!paramSet.contains("GL_NV_point_sprite")) {
/* 10519 */       return false;
/*       */     }
/*       */     
/* 10522 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2115, 2116 }, new String[] { "glPointParameteriNV", "glPointParameterivNV"
/*       */ 
/*       */ 
/*       */         
/* 10526 */         }) || Checks.reportMissing("GL", "GL_NV_point_sprite")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_primitive_restart(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10530 */     if (!paramSet.contains("GL_NV_primitive_restart")) {
/* 10531 */       return false;
/*       */     }
/*       */     
/* 10534 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2117, 2118 }, new String[] { "glPrimitiveRestartNV", "glPrimitiveRestartIndexNV"
/*       */ 
/*       */ 
/*       */         
/* 10538 */         }) || Checks.reportMissing("GL", "GL_NV_primitive_restart")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_query_resource(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10542 */     if (!paramSet.contains("GL_NV_query_resource")) {
/* 10543 */       return false;
/*       */     }
/*       */     
/* 10546 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2119 }, new String[] { "glQueryResourceNV"
/*       */ 
/*       */ 
/*       */         
/* 10550 */         }) || Checks.reportMissing("GL", "GL_NV_query_resource")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_query_resource_tag(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10554 */     if (!paramSet.contains("GL_NV_query_resource_tag")) {
/* 10555 */       return false;
/*       */     }
/*       */     
/* 10558 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2120, 2121, 2122 }, new String[] { "glGenQueryResourceTagNV", "glDeleteQueryResourceTagNV", "glQueryResourceTagNV"
/*       */ 
/*       */ 
/*       */         
/* 10562 */         }) || Checks.reportMissing("GL", "GL_NV_query_resource_tag")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_sample_locations(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10566 */     if (!paramSet.contains("GL_NV_sample_locations")) {
/* 10567 */       return false;
/*       */     }
/*       */     
/* 10570 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2123, 2124, 2125 }, new String[] { "glFramebufferSampleLocationsfvNV", "glNamedFramebufferSampleLocationsfvNV", "glResolveDepthValuesNV"
/*       */ 
/*       */ 
/*       */         
/* 10574 */         }) || Checks.reportMissing("GL", "GL_NV_sample_locations")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_scissor_exclusive(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10578 */     if (!paramSet.contains("GL_NV_scissor_exclusive")) {
/* 10579 */       return false;
/*       */     }
/*       */     
/* 10582 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2126, 2127 }, new String[] { "glScissorExclusiveArrayvNV", "glScissorExclusiveNV"
/*       */ 
/*       */ 
/*       */         
/* 10586 */         }) || Checks.reportMissing("GL", "GL_NV_scissor_exclusive")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_shader_buffer_load(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10590 */     if (!paramSet.contains("GL_NV_shader_buffer_load")) {
/* 10591 */       return false;
/*       */     }
/*       */     
/* 10594 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2128, 2129, 2130, 2131, 2132, 2133, 2134, 2135, 2136, 2137, 2138, 1075, 2139, 2140 }, new String[] { "glMakeBufferResidentNV", "glMakeBufferNonResidentNV", "glIsBufferResidentNV", "glMakeNamedBufferResidentNV", "glMakeNamedBufferNonResidentNV", "glIsNamedBufferResidentNV", "glGetBufferParameterui64vNV", "glGetNamedBufferParameterui64vNV", "glGetIntegerui64vNV", "glUniformui64NV", "glUniformui64vNV", "glGetUniformui64vNV", "glProgramUniformui64NV", "glProgramUniformui64vNV"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 10600 */         }) || Checks.reportMissing("GL", "GL_NV_shader_buffer_load")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_shading_rate_image(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10604 */     if (!paramSet.contains("GL_NV_shading_rate_image")) {
/* 10605 */       return false;
/*       */     }
/*       */     
/* 10608 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2141, 2142, 2143, 2144, 2145, 2146, 2147 }, new String[] { "glBindShadingRateImageNV", "glShadingRateImagePaletteNV", "glGetShadingRateImagePaletteNV", "glShadingRateImageBarrierNV", "glShadingRateSampleOrderNV", "glShadingRateSampleOrderCustomNV", "glGetShadingRateSampleLocationivNV"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 10613 */         }) || Checks.reportMissing("GL", "GL_NV_shading_rate_image")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_texture_barrier(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10617 */     if (!paramSet.contains("GL_NV_texture_barrier")) {
/* 10618 */       return false;
/*       */     }
/*       */     
/* 10621 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2148 }, new String[] { "glTextureBarrierNV"
/*       */ 
/*       */ 
/*       */         
/* 10625 */         }) || Checks.reportMissing("GL", "GL_NV_texture_barrier")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_texture_multisample(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10629 */     if (!paramSet.contains("GL_NV_texture_multisample")) {
/* 10630 */       return false;
/*       */     }
/*       */     
/* 10633 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2149, 2150, 2151, 2152, 2153, 2154 }, new String[] { "glTexImage2DMultisampleCoverageNV", "glTexImage3DMultisampleCoverageNV", "glTextureImage2DMultisampleNV", "glTextureImage3DMultisampleNV", "glTextureImage2DMultisampleCoverageNV", "glTextureImage3DMultisampleCoverageNV"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 10638 */         }) || Checks.reportMissing("GL", "GL_NV_texture_multisample")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_timeline_semaphore(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10642 */     if (!paramSet.contains("GL_NV_timeline_semaphore")) {
/* 10643 */       return false;
/*       */     }
/*       */     
/* 10646 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2155, 2156, 2157 }, new String[] { "glCreateSemaphoresNV", "glSemaphoreParameterivNV", "glGetSemaphoreParameterivNV"
/*       */ 
/*       */ 
/*       */         
/* 10650 */         }) || Checks.reportMissing("GL", "GL_NV_timeline_semaphore")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_transform_feedback(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10654 */     if (!paramSet.contains("GL_NV_transform_feedback")) {
/* 10655 */       return false;
/*       */     }
/*       */     
/* 10658 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2158, 2159, 2160, 2161, 2162, 2163, 2164, 2165, 2166, 2167, 2168, 2169 }, new String[] { "glBeginTransformFeedbackNV", "glEndTransformFeedbackNV", "glTransformFeedbackAttribsNV", "glBindBufferRangeNV", "glBindBufferOffsetNV", "glBindBufferBaseNV", "glTransformFeedbackVaryingsNV", "glActiveVaryingNV", "glGetVaryingLocationNV", "glGetActiveVaryingNV", "glGetTransformFeedbackVaryingNV", "glTransformFeedbackStreamAttribsNV"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 10664 */         }) || Checks.reportMissing("GL", "GL_NV_transform_feedback")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_transform_feedback2(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10668 */     if (!paramSet.contains("GL_NV_transform_feedback2")) {
/* 10669 */       return false;
/*       */     }
/*       */     
/* 10672 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2170, 2171, 2172, 2173, 2174, 2175, 2176 }, new String[] { "glBindTransformFeedbackNV", "glDeleteTransformFeedbacksNV", "glGenTransformFeedbacksNV", "glIsTransformFeedbackNV", "glPauseTransformFeedbackNV", "glResumeTransformFeedbackNV", "glDrawTransformFeedbackNV"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 10677 */         }) || Checks.reportMissing("GL", "GL_NV_transform_feedback2")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_vertex_array_range(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10681 */     if (!paramSet.contains("GL_NV_vertex_array_range")) {
/* 10682 */       return false;
/*       */     }
/*       */     
/* 10685 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2177, 2178 }, new String[] { "glVertexArrayRangeNV", "glFlushVertexArrayRangeNV"
/*       */ 
/*       */ 
/*       */         
/* 10689 */         }) || Checks.reportMissing("GL", "GL_NV_vertex_array_range")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_vertex_attrib_integer_64bit(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10693 */     if (!paramSet.contains("GL_NV_vertex_attrib_integer_64bit")) {
/* 10694 */       return false;
/*       */     }
/*       */     
/* 10697 */     byte b = paramSet.contains("GL_NV_vertex_buffer_unified_memory") ? 0 : -2147483648;
/*       */     
/* 10699 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2179, 2180, 2181, 2182, 2183, 2184, 2185, 2186, 2187, 2188, 2189, 2190, 2191, 2192, 2193, 2194, 2195, 2196, b + 2197 }, new String[] { "glVertexAttribL1i64NV", "glVertexAttribL2i64NV", "glVertexAttribL3i64NV", "glVertexAttribL4i64NV", "glVertexAttribL1i64vNV", "glVertexAttribL2i64vNV", "glVertexAttribL3i64vNV", "glVertexAttribL4i64vNV", "glVertexAttribL1ui64NV", "glVertexAttribL2ui64NV", "glVertexAttribL3ui64NV", "glVertexAttribL4ui64NV", "glVertexAttribL1ui64vNV", "glVertexAttribL2ui64vNV", "glVertexAttribL3ui64vNV", "glVertexAttribL4ui64vNV", "glGetVertexAttribLi64vNV", "glGetVertexAttribLui64vNV", "glVertexAttribLFormatNV"
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 10706 */         }) || Checks.reportMissing("GL", "GL_NV_vertex_attrib_integer_64bit")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_vertex_buffer_unified_memory(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10710 */     if (!paramSet.contains("GL_NV_vertex_buffer_unified_memory")) {
/* 10711 */       return false;
/*       */     }
/*       */     
/* 10714 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2198, 2199, 2200, 2201, 2202, 2203, 2204, 2205, 2206, 2207, 2208, 2209 }, new String[] { "glBufferAddressRangeNV", "glVertexFormatNV", "glNormalFormatNV", "glColorFormatNV", "glIndexFormatNV", "glTexCoordFormatNV", "glEdgeFlagFormatNV", "glSecondaryColorFormatNV", "glFogCoordFormatNV", "glVertexAttribFormatNV", "glVertexAttribIFormatNV", "glGetIntegerui64i_vNV"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 10719 */         }) || Checks.reportMissing("GL", "GL_NV_vertex_buffer_unified_memory")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NV_viewport_swizzle(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10723 */     if (!paramSet.contains("GL_NV_viewport_swizzle")) {
/* 10724 */       return false;
/*       */     }
/*       */     
/* 10727 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2210 }, new String[] { "glViewportSwizzleNV"
/*       */ 
/*       */ 
/*       */         
/* 10731 */         }) || Checks.reportMissing("GL", "GL_NV_viewport_swizzle")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NVX_conditional_render(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10735 */     if (!paramSet.contains("GL_NVX_conditional_render")) {
/* 10736 */       return false;
/*       */     }
/*       */     
/* 10739 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2211, 2212 }, new String[] { "glBeginConditionalRenderNVX", "glEndConditionalRenderNVX"
/*       */ 
/*       */ 
/*       */         
/* 10743 */         }) || Checks.reportMissing("GL", "GL_NVX_conditional_render")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NVX_gpu_multicast2(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10747 */     if (!paramSet.contains("GL_NVX_gpu_multicast2")) {
/* 10748 */       return false;
/*       */     }
/*       */     
/* 10751 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2213, 2214, 2215, 2216, 2217, 2218 }, new String[] { "glAsyncCopyImageSubDataNVX", "glAsyncCopyBufferSubDataNVX", "glUploadGpuMaskNVX", "glMulticastViewportArrayvNVX", "glMulticastScissorArrayvNVX", "glMulticastViewportPositionWScaleNVX"
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 10756 */         }) || Checks.reportMissing("GL", "GL_NVX_gpu_multicast2")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_NVX_progress_fence(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10760 */     if (!paramSet.contains("GL_NVX_progress_fence")) {
/* 10761 */       return false;
/*       */     }
/*       */     
/* 10764 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2219, 2220, 2221, 2222 }, new String[] { "glCreateProgressFenceNVX", "glSignalSemaphoreui64NVX", "glWaitSemaphoreui64NVX", "glClientWaitSemaphoreui64NVX"
/*       */ 
/*       */ 
/*       */         
/* 10768 */         }) || Checks.reportMissing("GL", "GL_NVX_progress_fence")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean check_OVR_multiview(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, Set<String> paramSet) {
/* 10772 */     if (!paramSet.contains("GL_OVR_multiview")) {
/* 10773 */       return false;
/*       */     }
/*       */     
/* 10776 */     byte b = hasDSA(paramSet) ? 0 : -2147483648;
/*       */     
/* 10778 */     if (Checks.checkFunctions(paramFunctionProvider, paramPointerBuffer, new int[] { 2223, b + 2224 }, new String[] { "glFramebufferTextureMultiviewOVR", "glNamedFramebufferTextureMultiviewOVR"
/*       */ 
/*       */ 
/*       */         
/* 10782 */         }) || Checks.reportMissing("GL", "GL_OVR_multiview")) return true; 
/*       */     return false;
/*       */   }
/*       */   private static boolean hasDSA(Set<String> paramSet) {
/* 10786 */     return (paramSet.contains("GL45") || paramSet.contains("GL_ARB_direct_state_access") || paramSet.contains("GL_EXT_direct_state_access"));
/*       */   }
/*       */   
/* 10789 */   private static boolean ARB_framebuffer_object(Set<String> paramSet) { return (paramSet.contains("OpenGL30") || paramSet.contains("GL_ARB_framebuffer_object")); }
/* 10790 */   private static boolean ARB_map_buffer_range(Set<String> paramSet) { return (paramSet.contains("OpenGL30") || paramSet.contains("GL_ARB_map_buffer_range")); }
/* 10791 */   private static boolean ARB_vertex_array_object(Set<String> paramSet) { return (paramSet.contains("OpenGL30") || paramSet.contains("GL_ARB_vertex_array_object")); }
/* 10792 */   private static boolean ARB_copy_buffer(Set<String> paramSet) { return (paramSet.contains("OpenGL31") || paramSet.contains("GL_ARB_copy_buffer")); }
/* 10793 */   private static boolean ARB_texture_buffer_object(Set<String> paramSet) { return (paramSet.contains("OpenGL31") || paramSet.contains("GL_ARB_texture_buffer_object")); }
/* 10794 */   private static boolean ARB_uniform_buffer_object(Set<String> paramSet) { return (paramSet.contains("OpenGL31") || paramSet.contains("GL_ARB_uniform_buffer_object")); }
/* 10795 */   private static boolean ARB_instanced_arrays(Set<String> paramSet) { return (paramSet.contains("OpenGL33") || paramSet.contains("GL_ARB_instanced_arrays")); }
/* 10796 */   private static boolean ARB_sampler_objects(Set<String> paramSet) { return (paramSet.contains("OpenGL33") || paramSet.contains("GL_ARB_sampler_objects")); }
/* 10797 */   private static boolean ARB_transform_feedback2(Set<String> paramSet) { return (paramSet.contains("OpenGL40") || paramSet.contains("GL_ARB_transform_feedback2")); }
/* 10798 */   private static boolean ARB_vertex_attrib_64bit(Set<String> paramSet) { return (paramSet.contains("OpenGL41") || paramSet.contains("GL_ARB_vertex_attrib_64bit")); }
/* 10799 */   private static boolean ARB_separate_shader_objects(Set<String> paramSet) { return (paramSet.contains("OpenGL41") || paramSet.contains("GL_ARB_separate_shader_objects")); }
/* 10800 */   private static boolean ARB_texture_storage(Set<String> paramSet) { return (paramSet.contains("OpenGL42") || paramSet.contains("GL_ARB_texture_storage")); }
/* 10801 */   private static boolean ARB_texture_storage_multisample(Set<String> paramSet) { return (paramSet.contains("OpenGL43") || paramSet.contains("GL_ARB_texture_storage_multisample")); }
/* 10802 */   private static boolean ARB_vertex_attrib_binding(Set<String> paramSet) { return (paramSet.contains("OpenGL43") || paramSet.contains("GL_ARB_vertex_attrib_binding")); }
/* 10803 */   private static boolean ARB_invalidate_subdata(Set<String> paramSet) { return (paramSet.contains("OpenGL43") || paramSet.contains("GL_ARB_invalidate_subdata")); }
/* 10804 */   private static boolean ARB_texture_buffer_range(Set<String> paramSet) { return (paramSet.contains("OpenGL43") || paramSet.contains("GL_ARB_texture_buffer_range")); }
/* 10805 */   private static boolean ARB_clear_buffer_object(Set<String> paramSet) { return (paramSet.contains("OpenGL43") || paramSet.contains("GL_ARB_clear_buffer_object")); }
/* 10806 */   private static boolean ARB_framebuffer_no_attachments(Set<String> paramSet) { return (paramSet.contains("OpenGL43") || paramSet.contains("GL_ARB_framebuffer_no_attachments")); }
/* 10807 */   private static boolean ARB_buffer_storage(Set<String> paramSet) { return (paramSet.contains("OpenGL44") || paramSet.contains("GL_ARB_buffer_storage")); }
/* 10808 */   private static boolean ARB_clear_texture(Set<String> paramSet) { return (paramSet.contains("OpenGL44") || paramSet.contains("GL_ARB_clear_texture")); }
/* 10809 */   private static boolean ARB_multi_bind(Set<String> paramSet) { return (paramSet.contains("OpenGL44") || paramSet.contains("GL_ARB_multi_bind")); } private static boolean ARB_query_buffer_object(Set<String> paramSet) {
/* 10810 */     return (paramSet.contains("OpenGL44") || paramSet.contains("GL_ARB_query_buffer_object"));
/*       */   }
/*       */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLCapabilities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */