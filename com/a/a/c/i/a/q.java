/*     */ package com.a.a.c.i.a;
/*     */ 
/*     */ import com.a.a.c.b;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.j;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class q
/*     */ {
/*     */   private static Set<String> a;
/*     */   
/*     */   static {
/*     */     HashSet<String> hashSet;
/*  35 */     (hashSet = new HashSet<>()).add("org.apache.commons.collections.functors.InvokerTransformer");
/*  36 */     hashSet.add("org.apache.commons.collections.functors.InstantiateTransformer");
/*  37 */     hashSet.add("org.apache.commons.collections4.functors.InvokerTransformer");
/*  38 */     hashSet.add("org.apache.commons.collections4.functors.InstantiateTransformer");
/*  39 */     hashSet.add("org.codehaus.groovy.runtime.ConvertedClosure");
/*  40 */     hashSet.add("org.codehaus.groovy.runtime.MethodClosure");
/*  41 */     hashSet.add("org.springframework.beans.factory.ObjectFactory");
/*  42 */     hashSet.add("com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl");
/*  43 */     hashSet.add("org.apache.xalan.xsltc.trax.TemplatesImpl");
/*     */     
/*  45 */     hashSet.add("com.sun.rowset.JdbcRowSetImpl");
/*     */     
/*  47 */     hashSet.add("java.util.logging.FileHandler");
/*  48 */     hashSet.add("java.rmi.server.UnicastRemoteObject");
/*     */ 
/*     */     
/*  51 */     hashSet.add("org.springframework.beans.factory.config.PropertyPathFactoryBean");
/*     */     
/*  53 */     hashSet.add("org.springframework.aop.config.MethodLocatingFactoryBean");
/*  54 */     hashSet.add("org.springframework.beans.factory.config.BeanReferenceFactoryBean");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  59 */     hashSet.add("org.apache.tomcat.dbcp.dbcp2.BasicDataSource");
/*  60 */     hashSet.add("com.sun.org.apache.bcel.internal.util.ClassLoader");
/*     */     
/*  62 */     hashSet.add("org.hibernate.jmx.StatisticsService");
/*  63 */     hashSet.add("org.apache.ibatis.datasource.jndi.JndiDataSourceFactory");
/*     */     
/*  65 */     hashSet.add("org.apache.ibatis.parsing.XPathParser");
/*     */ 
/*     */     
/*  68 */     hashSet.add("jodd.db.connection.DataSourceConnectionProvider");
/*     */ 
/*     */     
/*  71 */     hashSet.add("oracle.jdbc.connector.OracleManagedConnectionFactory");
/*  72 */     hashSet.add("oracle.jdbc.rowset.OracleJDBCRowSet");
/*     */ 
/*     */     
/*  75 */     hashSet.add("org.slf4j.ext.EventData");
/*  76 */     hashSet.add("flex.messaging.util.concurrent.AsynchBeansWorkManagerExecutor");
/*  77 */     hashSet.add("com.sun.deploy.security.ruleset.DRSHelper");
/*  78 */     hashSet.add("org.apache.axis2.jaxws.spi.handler.HandlerResolverImpl");
/*     */ 
/*     */     
/*  81 */     hashSet.add("org.jboss.util.propertyeditor.DocumentEditor");
/*  82 */     hashSet.add("org.apache.openjpa.ee.RegistryManagedRuntime");
/*  83 */     hashSet.add("org.apache.openjpa.ee.JNDIManagedRuntime");
/*  84 */     hashSet.add("org.apache.openjpa.ee.WASRegistryManagedRuntime");
/*  85 */     hashSet.add("org.apache.axis2.transport.jms.JMSOutTransportInfo");
/*     */ 
/*     */     
/*  88 */     hashSet.add("com.mysql.cj.jdbc.admin.MiniAdmin");
/*     */ 
/*     */     
/*  91 */     hashSet.add("ch.qos.logback.core.db.DriverManagerConnectionSource");
/*     */ 
/*     */     
/*  94 */     hashSet.add("org.jdom.transform.XSLTransformer");
/*  95 */     hashSet.add("org.jdom2.transform.XSLTransformer");
/*     */ 
/*     */     
/*  98 */     hashSet.add("net.sf.ehcache.transaction.manager.DefaultTransactionManagerLookup");
/*  99 */     hashSet.add("net.sf.ehcache.hibernate.EhcacheJtaTransactionManagerLookup");
/*     */ 
/*     */     
/* 102 */     hashSet.add("ch.qos.logback.core.db.JNDIConnectionSource");
/*     */ 
/*     */     
/* 105 */     hashSet.add("com.zaxxer.hikari.HikariConfig");
/*     */     
/* 107 */     hashSet.add("com.zaxxer.hikari.HikariDataSource");
/*     */ 
/*     */     
/* 110 */     hashSet.add("org.apache.cxf.jaxrs.provider.XSLTJaxbProvider");
/*     */ 
/*     */     
/* 113 */     hashSet.add("org.apache.commons.configuration.JNDIConfiguration");
/* 114 */     hashSet.add("org.apache.commons.configuration2.JNDIConfiguration");
/*     */ 
/*     */     
/* 117 */     hashSet.add("org.apache.xalan.lib.sql.JNDIConnectionPool");
/*     */     
/* 119 */     hashSet.add("com.sun.org.apache.xalan.internal.lib.sql.JNDIConnectionPool");
/*     */ 
/*     */ 
/*     */     
/* 123 */     hashSet.add("org.apache.commons.dbcp.cpdsadapter.DriverAdapterCPDS");
/* 124 */     hashSet.add("org.apache.commons.dbcp.datasources.PerUserPoolDataSource");
/* 125 */     hashSet.add("org.apache.commons.dbcp.datasources.SharedPoolDataSource");
/*     */     
/* 127 */     hashSet.add("com.p6spy.engine.spy.P6DataSource");
/*     */ 
/*     */     
/* 130 */     hashSet.add("org.apache.log4j.receivers.db.DriverManagerConnectionSource");
/* 131 */     hashSet.add("org.apache.log4j.receivers.db.JNDIConnectionSource");
/*     */ 
/*     */     
/* 134 */     hashSet.add("net.sf.ehcache.transaction.manager.selector.GenericJndiSelector");
/* 135 */     hashSet.add("net.sf.ehcache.transaction.manager.selector.GlassfishSelector");
/*     */ 
/*     */     
/* 138 */     hashSet.add("org.apache.xbean.propertyeditor.JndiConverter");
/*     */ 
/*     */     
/* 141 */     hashSet.add("org.apache.hadoop.shaded.com.zaxxer.hikari.HikariConfig");
/*     */ 
/*     */     
/* 144 */     hashSet.add("com.ibatis.sqlmap.engine.transaction.jta.JtaTransactionConfig");
/* 145 */     hashSet.add("br.com.anteros.dbcp.AnterosDBCPConfig");
/*     */     
/* 147 */     hashSet.add("br.com.anteros.dbcp.AnterosDBCPDataSource");
/*     */ 
/*     */     
/* 150 */     hashSet.add("javax.swing.JEditorPane");
/* 151 */     hashSet.add("javax.swing.JTextPane");
/*     */ 
/*     */     
/* 154 */     hashSet.add("org.apache.shiro.realm.jndi.JndiRealmFactory");
/* 155 */     hashSet.add("org.apache.shiro.jndi.JndiObjectFactory");
/*     */ 
/*     */     
/* 158 */     hashSet.add("org.apache.ignite.cache.jta.jndi.CacheJndiTmLookup");
/* 159 */     hashSet.add("org.apache.ignite.cache.jta.jndi.CacheJndiTmFactory");
/* 160 */     hashSet.add("org.quartz.utils.JNDIConnectionProvider");
/*     */ 
/*     */     
/* 163 */     hashSet.add("org.apache.aries.transaction.jms.internal.XaPooledConnectionFactory");
/* 164 */     hashSet.add("org.apache.aries.transaction.jms.RecoverablePooledConnectionFactory");
/*     */ 
/*     */     
/* 167 */     hashSet.add("com.caucho.config.types.ResourceRef");
/*     */ 
/*     */     
/* 170 */     hashSet.add("org.aoju.bus.proxy.provider.RmiProvider");
/* 171 */     hashSet.add("org.aoju.bus.proxy.provider.remoting.RmiProvider");
/*     */ 
/*     */ 
/*     */     
/* 175 */     hashSet.add("org.apache.activemq.ActiveMQConnectionFactory");
/* 176 */     hashSet.add("org.apache.activemq.ActiveMQXAConnectionFactory");
/* 177 */     hashSet.add("org.apache.activemq.spring.ActiveMQConnectionFactory");
/* 178 */     hashSet.add("org.apache.activemq.spring.ActiveMQXAConnectionFactory");
/* 179 */     hashSet.add("org.apache.activemq.pool.JcaPooledConnectionFactory");
/* 180 */     hashSet.add("org.apache.activemq.pool.PooledConnectionFactory");
/* 181 */     hashSet.add("org.apache.activemq.pool.XaPooledConnectionFactory");
/* 182 */     hashSet.add("org.apache.activemq.jms.pool.XaPooledConnectionFactory");
/* 183 */     hashSet.add("org.apache.activemq.jms.pool.JcaPooledConnectionFactory");
/*     */ 
/*     */     
/* 186 */     hashSet.add("org.apache.commons.proxy.provider.remoting.RmiProvider");
/*     */ 
/*     */     
/* 189 */     hashSet.add("org.apache.commons.jelly.impl.Embedded");
/*     */ 
/*     */     
/* 192 */     hashSet.add("oadd.org.apache.xalan.lib.sql.JNDIConnectionPool");
/* 193 */     hashSet.add("oadd.org.apache.commons.dbcp.cpdsadapter.DriverAdapterCPDS");
/* 194 */     hashSet.add("oadd.org.apache.commons.dbcp.datasources.PerUserPoolDataSource");
/* 195 */     hashSet.add("oadd.org.apache.commons.dbcp.datasources.SharedPoolDataSource");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 200 */     hashSet.add("oracle.jms.AQjmsQueueConnectionFactory");
/* 201 */     hashSet.add("oracle.jms.AQjmsXATopicConnectionFactory");
/* 202 */     hashSet.add("oracle.jms.AQjmsTopicConnectionFactory");
/* 203 */     hashSet.add("oracle.jms.AQjmsXAQueueConnectionFactory");
/* 204 */     hashSet.add("oracle.jms.AQjmsXAConnectionFactory");
/*     */ 
/*     */     
/* 207 */     hashSet.add("org.jsecurity.realm.jndi.JndiRealmFactory");
/*     */ 
/*     */     
/* 210 */     hashSet.add("com.pastdev.httpcomponents.configuration.JndiConfiguration");
/*     */ 
/*     */     
/* 213 */     hashSet.add("com.nqadmin.rowset.JdbcRowSetImpl");
/* 214 */     hashSet.add("org.arrah.framework.rdbms.UpdatableJdbcRowsetImpl");
/*     */ 
/*     */     
/* 217 */     hashSet.add("org.apache.commons.dbcp2.datasources.PerUserPoolDataSource");
/* 218 */     hashSet.add("org.apache.commons.dbcp2.datasources.SharedPoolDataSource");
/* 219 */     hashSet.add("org.apache.commons.dbcp2.cpdsadapter.DriverAdapterCPDS");
/*     */ 
/*     */ 
/*     */     
/* 223 */     hashSet.add("com.newrelic.agent.deps.ch.qos.logback.core.db.JNDIConnectionSource");
/* 224 */     hashSet.add("com.newrelic.agent.deps.ch.qos.logback.core.db.DriverManagerConnectionSource");
/*     */ 
/*     */ 
/*     */     
/* 228 */     hashSet.add("org.apache.tomcat.dbcp.dbcp.cpdsadapter.DriverAdapterCPDS");
/* 229 */     hashSet.add("org.apache.tomcat.dbcp.dbcp.datasources.PerUserPoolDataSource");
/* 230 */     hashSet.add("org.apache.tomcat.dbcp.dbcp.datasources.SharedPoolDataSource");
/*     */ 
/*     */ 
/*     */     
/* 234 */     hashSet.add("org.apache.tomcat.dbcp.dbcp2.cpdsadapter.DriverAdapterCPDS");
/* 235 */     hashSet.add("org.apache.tomcat.dbcp.dbcp2.datasources.PerUserPoolDataSource");
/* 236 */     hashSet.add("org.apache.tomcat.dbcp.dbcp2.datasources.SharedPoolDataSource");
/*     */ 
/*     */ 
/*     */     
/* 240 */     hashSet.add("com.oracle.wls.shaded.org.apache.xalan.lib.sql.JNDIConnectionPool");
/*     */ 
/*     */     
/* 243 */     hashSet.add("org.docx4j.org.apache.xalan.lib.sql.JNDIConnectionPool");
/*     */     
/* 245 */     a = Collections.unmodifiableSet(hashSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 251 */   private Set<String> b = a;
/*     */   
/* 253 */   private static final q c = new q();
/*     */ 
/*     */   
/*     */   public static q a() {
/* 257 */     return c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(g paramg, j paramj, b paramb) {
/*     */     Class<?> clazz;
/* 265 */     String str = (clazz = paramj.b()).getName();
/*     */ 
/*     */ 
/*     */     
/* 269 */     if (!this.b.contains(str))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 276 */       if (!clazz.isInterface()) {
/*     */         
/* 278 */         if (str.startsWith("org.springframework.")) {
/* 279 */           clazz = clazz; while (true) { if (clazz != null && clazz != Object.class) {
/* 280 */               String str1 = clazz.getSimpleName();
/*     */               
/* 282 */               if (!"AbstractPointcutAdvisor".equals(str1) && 
/*     */                 
/* 284 */                 !"AbstractApplicationContext".equals(str1)) { clazz = clazz.getSuperclass(); continue; }
/*     */                break;
/*     */             }  return; }
/*     */         
/* 288 */         } else if (str.startsWith("com.mchange.v2.c3p0.")) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 295 */           if (!str.endsWith("DataSource"))
/*     */             return; 
/*     */         } else {
/*     */           return;
/*     */         } 
/*     */       } else {
/*     */         return;
/* 302 */       }  }  paramg.a(paramb, "Illegal type (%s) to deserialize: prevented for security reasons", new Object[] { str });
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\i\a\q.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */