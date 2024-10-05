/*      */ package org.jsoup.helper;
/*      */ 
/*      */ import java.io.BufferedInputStream;
/*      */ import java.io.BufferedWriter;
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.OutputStream;
/*      */ import java.io.OutputStreamWriter;
/*      */ import java.net.CookieManager;
/*      */ import java.net.CookieStore;
/*      */ import java.net.HttpURLConnection;
/*      */ import java.net.InetSocketAddress;
/*      */ import java.net.MalformedURLException;
/*      */ import java.net.Proxy;
/*      */ import java.net.URL;
/*      */ import java.net.URLEncoder;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.charset.Charset;
/*      */ import java.nio.charset.IllegalCharsetNameException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.regex.Pattern;
/*      */ import java.util.zip.GZIPInputStream;
/*      */ import java.util.zip.Inflater;
/*      */ import java.util.zip.InflaterInputStream;
/*      */ import javax.net.ssl.HttpsURLConnection;
/*      */ import javax.net.ssl.SSLSocketFactory;
/*      */ import org.jsoup.Connection;
/*      */ import org.jsoup.HttpStatusException;
/*      */ import org.jsoup.UncheckedIOException;
/*      */ import org.jsoup.UnsupportedMimeTypeException;
/*      */ import org.jsoup.internal.ControllableInputStream;
/*      */ import org.jsoup.internal.Normalizer;
/*      */ import org.jsoup.internal.StringUtil;
/*      */ import org.jsoup.nodes.Document;
/*      */ import org.jsoup.parser.Parser;
/*      */ import org.jsoup.parser.TokenQueue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class HttpConnection
/*      */   implements Connection
/*      */ {
/*      */   public static final String CONTENT_ENCODING = "Content-Encoding";
/*      */   public static final String DEFAULT_UA = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36";
/*      */   private static final String USER_AGENT = "User-Agent";
/*      */   public static final String CONTENT_TYPE = "Content-Type";
/*      */   public static final String MULTIPART_FORM_DATA = "multipart/form-data";
/*      */   public static final String FORM_URL_ENCODED = "application/x-www-form-urlencoded";
/*      */   private static final int HTTP_TEMP_REDIR = 307;
/*      */   private static final String DefaultUploadType = "application/octet-stream";
/*   70 */   private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
/*      */   
/*      */   private Request req;
/*      */   
/*      */   private Connection.Response res;
/*      */ 
/*      */   
/*      */   public static Connection connect(String paramString) {
/*      */     HttpConnection httpConnection;
/*   79 */     (httpConnection = new HttpConnection()).url(paramString);
/*   80 */     return httpConnection;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Connection connect(URL paramURL) {
/*      */     HttpConnection httpConnection;
/*   90 */     (httpConnection = new HttpConnection()).url(paramURL);
/*   91 */     return httpConnection;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HttpConnection() {
/*   98 */     this.req = new Request();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   HttpConnection(Request paramRequest) {
/*  107 */     this.req = new Request(paramRequest);
/*      */   }
/*      */   
/*      */   private static String encodeMimeName(String paramString) {
/*  111 */     return paramString.replace("\"", "%22");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Connection newRequest() {
/*  120 */     return new HttpConnection(this.req);
/*      */   }
/*      */ 
/*      */   
/*      */   private HttpConnection(Request paramRequest, Response paramResponse) {
/*  125 */     this.req = paramRequest;
/*  126 */     this.res = paramResponse;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection url(URL paramURL) {
/*  131 */     this.req.url(paramURL);
/*  132 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection url(String paramString) {
/*  137 */     Validate.notEmptyParam(paramString, "url");
/*      */     try {
/*  139 */       this.req.url(new URL(paramString));
/*  140 */     } catch (MalformedURLException malformedURLException) {
/*  141 */       throw new IllegalArgumentException(String.format("The supplied URL, '%s', is malformed. Make sure it is an absolute URL, and starts with 'http://' or 'https://'. See https://jsoup.org/cookbook/extracting-data/working-with-urls", new Object[] { paramString }), malformedURLException);
/*      */     } 
/*  143 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection proxy(Proxy paramProxy) {
/*  148 */     this.req.proxy(paramProxy);
/*  149 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection proxy(String paramString, int paramInt) {
/*  154 */     this.req.proxy(paramString, paramInt);
/*  155 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection userAgent(String paramString) {
/*  160 */     Validate.notNullParam(paramString, "userAgent");
/*  161 */     this.req.header("User-Agent", paramString);
/*  162 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection timeout(int paramInt) {
/*  167 */     this.req.timeout(paramInt);
/*  168 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection maxBodySize(int paramInt) {
/*  173 */     this.req.maxBodySize(paramInt);
/*  174 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection followRedirects(boolean paramBoolean) {
/*  179 */     this.req.followRedirects(paramBoolean);
/*  180 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection referrer(String paramString) {
/*  185 */     Validate.notNullParam(paramString, "referrer");
/*  186 */     this.req.header("Referer", paramString);
/*  187 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection method(Connection.Method paramMethod) {
/*  192 */     this.req.method(paramMethod);
/*  193 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection ignoreHttpErrors(boolean paramBoolean) {
/*  198 */     this.req.ignoreHttpErrors(paramBoolean);
/*  199 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection ignoreContentType(boolean paramBoolean) {
/*  204 */     this.req.ignoreContentType(paramBoolean);
/*  205 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection data(String paramString1, String paramString2) {
/*  210 */     this.req.data(KeyVal.create(paramString1, paramString2));
/*  211 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection sslSocketFactory(SSLSocketFactory paramSSLSocketFactory) {
/*  216 */     this.req.sslSocketFactory(paramSSLSocketFactory);
/*  217 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection data(String paramString1, String paramString2, InputStream paramInputStream) {
/*  222 */     this.req.data(KeyVal.create(paramString1, paramString2, paramInputStream));
/*  223 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection data(String paramString1, String paramString2, InputStream paramInputStream, String paramString3) {
/*  228 */     this.req.data(KeyVal.create(paramString1, paramString2, paramInputStream).contentType(paramString3));
/*  229 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection data(Map<String, String> paramMap) {
/*  234 */     Validate.notNullParam(paramMap, "data");
/*  235 */     for (Map.Entry<String, String> entry : paramMap.entrySet()) {
/*  236 */       this.req.data(KeyVal.create((String)entry.getKey(), (String)entry.getValue()));
/*      */     }
/*  238 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection data(String... paramVarArgs) {
/*  243 */     Validate.notNullParam(paramVarArgs, "keyvals");
/*  244 */     Validate.isTrue((paramVarArgs.length % 2 == 0), "Must supply an even number of key value pairs");
/*  245 */     for (byte b = 0; b < paramVarArgs.length; b += 2) {
/*  246 */       String str1 = paramVarArgs[b];
/*  247 */       String str2 = paramVarArgs[b + 1];
/*  248 */       Validate.notEmpty(str1, "Data key must not be empty");
/*  249 */       Validate.notNull(str2, "Data value must not be null");
/*  250 */       this.req.data(KeyVal.create(str1, str2));
/*      */     } 
/*  252 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection data(Collection<Connection.KeyVal> paramCollection) {
/*  257 */     Validate.notNullParam(paramCollection, "data");
/*  258 */     for (Connection.KeyVal keyVal : paramCollection) {
/*  259 */       this.req.data(keyVal);
/*      */     }
/*  261 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection.KeyVal data(String paramString) {
/*  266 */     Validate.notEmptyParam(paramString, "key");
/*  267 */     for (Iterator<Connection.KeyVal> iterator = request().data().iterator(); iterator.hasNext();) {
/*  268 */       if ((keyVal = iterator.next()).key().equals(paramString))
/*  269 */         return keyVal; 
/*      */     } 
/*  271 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection requestBody(String paramString) {
/*  276 */     this.req.requestBody(paramString);
/*  277 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection header(String paramString1, String paramString2) {
/*  282 */     this.req.header(paramString1, paramString2);
/*  283 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection headers(Map<String, String> paramMap) {
/*  288 */     Validate.notNullParam(paramMap, "headers");
/*  289 */     for (Map.Entry<String, String> entry : paramMap.entrySet()) {
/*  290 */       this.req.header((String)entry.getKey(), (String)entry.getValue());
/*      */     }
/*  292 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection cookie(String paramString1, String paramString2) {
/*  297 */     this.req.cookie(paramString1, paramString2);
/*  298 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection cookies(Map<String, String> paramMap) {
/*  303 */     Validate.notNullParam(paramMap, "cookies");
/*  304 */     for (Map.Entry<String, String> entry : paramMap.entrySet()) {
/*  305 */       this.req.cookie((String)entry.getKey(), (String)entry.getValue());
/*      */     }
/*  307 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Connection cookieStore(CookieStore paramCookieStore) {
/*  313 */     this.req.cookieManager = new CookieManager(paramCookieStore, null);
/*  314 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public CookieStore cookieStore() {
/*  319 */     return this.req.cookieManager.getCookieStore();
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection parser(Parser paramParser) {
/*  324 */     this.req.parser(paramParser);
/*  325 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Document get() {
/*  330 */     this.req.method(Connection.Method.GET);
/*  331 */     execute();
/*  332 */     Validate.notNull(this.res);
/*  333 */     return this.res.parse();
/*      */   }
/*      */ 
/*      */   
/*      */   public Document post() {
/*  338 */     this.req.method(Connection.Method.POST);
/*  339 */     execute();
/*  340 */     Validate.notNull(this.res);
/*  341 */     return this.res.parse();
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection.Response execute() {
/*  346 */     this.res = Response.execute(this.req);
/*  347 */     return this.res;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection.Request request() {
/*  352 */     return this.req;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection request(Connection.Request paramRequest) {
/*  357 */     this.req = (Request)paramRequest;
/*  358 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection.Response response() {
/*  363 */     if (this.res == null) {
/*  364 */       throw new IllegalArgumentException("You must execute the request before getting a response.");
/*      */     }
/*  366 */     return this.res;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection response(Connection.Response paramResponse) {
/*  371 */     this.res = paramResponse;
/*  372 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Connection postDataCharset(String paramString) {
/*  377 */     this.req.postDataCharset(paramString);
/*  378 */     return this;
/*      */   }
/*      */   
/*      */   public Connection auth(RequestAuthenticator paramRequestAuthenticator) {
/*  382 */     this.req.auth(paramRequestAuthenticator);
/*  383 */     return this;
/*      */   }
/*      */   
/*      */   private static abstract class Base<T extends Connection.Base<T>> implements Connection.Base<T> {
/*      */     private static final URL UnsetUrl;
/*      */     
/*      */     static {
/*      */       try {
/*  391 */         UnsetUrl = new URL("http://undefined/"); return;
/*  392 */       } catch (MalformedURLException malformedURLException) {
/*  393 */         throw new IllegalStateException(malformedURLException);
/*      */       } 
/*      */     }
/*      */     
/*  397 */     URL url = UnsetUrl;
/*  398 */     Connection.Method method = Connection.Method.GET;
/*      */     Map<String, List<String>> headers;
/*      */     Map<String, String> cookies;
/*      */     
/*      */     private Base() {
/*  403 */       this.headers = new LinkedHashMap<>();
/*  404 */       this.cookies = new LinkedHashMap<>();
/*      */     }
/*      */     
/*      */     private Base(Base<T> param1Base) {
/*  408 */       this.url = param1Base.url;
/*  409 */       this.method = param1Base.method;
/*  410 */       this.headers = new LinkedHashMap<>();
/*  411 */       for (Map.Entry<String, List<String>> entry : param1Base.headers.entrySet()) {
/*  412 */         this.headers.put((String)entry.getKey(), new ArrayList<>((Collection<? extends String>)entry.getValue()));
/*      */       }
/*  414 */       this.cookies = new LinkedHashMap<>(); this.cookies.putAll(param1Base.cookies);
/*      */     }
/*      */ 
/*      */     
/*      */     public URL url() {
/*  419 */       if (this.url == UnsetUrl)
/*  420 */         throw new IllegalArgumentException("URL not set. Make sure to call #url(...) before executing the request."); 
/*  421 */       return this.url;
/*      */     }
/*      */ 
/*      */     
/*      */     public T url(URL param1URL) {
/*  426 */       Validate.notNullParam(param1URL, "url");
/*  427 */       this.url = (new UrlBuilder(param1URL)).build();
/*  428 */       return (T)this;
/*      */     }
/*      */ 
/*      */     
/*      */     public Connection.Method method() {
/*  433 */       return this.method;
/*      */     }
/*      */ 
/*      */     
/*      */     public T method(Connection.Method param1Method) {
/*  438 */       Validate.notNullParam(param1Method, "method");
/*  439 */       this.method = param1Method;
/*  440 */       return (T)this;
/*      */     }
/*      */ 
/*      */     
/*      */     public String header(String param1String) {
/*  445 */       Validate.notNullParam(param1String, "name");
/*      */       List<String> list;
/*  447 */       if ((list = getHeadersCaseInsensitive(param1String)).size() > 0)
/*      */       {
/*  449 */         return StringUtil.join(list, ", ");
/*      */       }
/*      */       
/*  452 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public T addHeader(String param1String1, String param1String2) {
/*  457 */       Validate.notEmptyParam(param1String1, "name");
/*      */       
/*  459 */       param1String2 = (param1String2 == null) ? "" : param1String2;
/*      */       
/*      */       List<String> list;
/*  462 */       if ((list = headers(param1String1)).isEmpty()) {
/*  463 */         list = new ArrayList<>();
/*  464 */         this.headers.put(param1String1, list);
/*      */       } 
/*  466 */       list.add(param1String2);
/*      */       
/*  468 */       return (T)this;
/*      */     }
/*      */ 
/*      */     
/*      */     public List<String> headers(String param1String) {
/*  473 */       Validate.notEmptyParam(param1String, "name");
/*  474 */       return getHeadersCaseInsensitive(param1String);
/*      */     }
/*      */ 
/*      */     
/*      */     public T header(String param1String1, String param1String2) {
/*  479 */       Validate.notEmptyParam(param1String1, "name");
/*  480 */       removeHeader(param1String1);
/*  481 */       addHeader(param1String1, param1String2);
/*  482 */       return (T)this;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean hasHeader(String param1String) {
/*  487 */       Validate.notEmptyParam(param1String, "name");
/*  488 */       return !getHeadersCaseInsensitive(param1String).isEmpty();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasHeaderWithValue(String param1String1, String param1String2) {
/*  496 */       Validate.notEmpty(param1String1);
/*  497 */       Validate.notEmpty(param1String2);
/*      */       List<String> list;
/*  499 */       for (String str : list = headers(param1String1)) {
/*  500 */         if (param1String2.equalsIgnoreCase(str))
/*  501 */           return true; 
/*      */       } 
/*  503 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public T removeHeader(String param1String) {
/*  508 */       Validate.notEmptyParam(param1String, "name");
/*      */       Map.Entry<String, List<String>> entry;
/*  510 */       if ((entry = scanHeaders(param1String)) != null)
/*  511 */         this.headers.remove(entry.getKey()); 
/*  512 */       return (T)this;
/*      */     }
/*      */ 
/*      */     
/*      */     public Map<String, String> headers() {
/*  517 */       LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>(this.headers.size());
/*  518 */       for (Iterator<Map.Entry> iterator = this.headers.entrySet().iterator(); iterator.hasNext(); ) {
/*  519 */         Map.Entry<String, ?> entry; String str = (entry = iterator.next()).getKey();
/*      */         List<?> list;
/*  521 */         if ((list = (List)entry.getValue()).size() > 0)
/*  522 */           linkedHashMap.put(str, list.get(0)); 
/*      */       } 
/*  524 */       return (Map)linkedHashMap;
/*      */     }
/*      */ 
/*      */     
/*      */     public Map<String, List<String>> multiHeaders() {
/*  529 */       return this.headers;
/*      */     }
/*      */     
/*      */     private List<String> getHeadersCaseInsensitive(String param1String) {
/*  533 */       Validate.notNull(param1String);
/*      */       
/*  535 */       for (Map.Entry<String, List<String>> entry : this.headers.entrySet()) {
/*  536 */         if (param1String.equalsIgnoreCase((String)entry.getKey())) {
/*  537 */           return (List<String>)entry.getValue();
/*      */         }
/*      */       } 
/*  540 */       return Collections.emptyList();
/*      */     }
/*      */     
/*      */     private Map.Entry<String, List<String>> scanHeaders(String param1String) {
/*  544 */       param1String = Normalizer.lowerCase(param1String);
/*  545 */       for (Iterator<Map.Entry> iterator = this.headers.entrySet().iterator(); iterator.hasNext();) {
/*  546 */         if (Normalizer.lowerCase((entry = iterator.next()).getKey()).equals(param1String))
/*  547 */           return (Map.Entry)entry; 
/*      */       } 
/*  549 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public String cookie(String param1String) {
/*  554 */       Validate.notEmptyParam(param1String, "name");
/*  555 */       return this.cookies.get(param1String);
/*      */     }
/*      */ 
/*      */     
/*      */     public T cookie(String param1String1, String param1String2) {
/*  560 */       Validate.notEmptyParam(param1String1, "name");
/*  561 */       Validate.notNullParam(param1String2, "value");
/*  562 */       this.cookies.put(param1String1, param1String2);
/*  563 */       return (T)this;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean hasCookie(String param1String) {
/*  568 */       Validate.notEmptyParam(param1String, "name");
/*  569 */       return this.cookies.containsKey(param1String);
/*      */     }
/*      */ 
/*      */     
/*      */     public T removeCookie(String param1String) {
/*  574 */       Validate.notEmptyParam(param1String, "name");
/*  575 */       this.cookies.remove(param1String);
/*  576 */       return (T)this;
/*      */     }
/*      */ 
/*      */     
/*      */     public Map<String, String> cookies() {
/*  581 */       return this.cookies;
/*      */     } }
/*      */   
/*      */   public static class Request extends Base<Connection.Request> implements Connection.Request { private Proxy proxy;
/*      */     
/*      */     static {
/*  587 */       System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
/*      */     }
/*      */ 
/*      */     
/*      */     private int timeoutMilliseconds;
/*      */     
/*      */     private int maxBodySizeBytes;
/*      */     private boolean followRedirects;
/*      */     private final Collection<Connection.KeyVal> data;
/*  596 */     private String body = null;
/*      */     private boolean ignoreHttpErrors = false;
/*      */     private boolean ignoreContentType = false;
/*      */     private Parser parser;
/*      */     private boolean parserDefined = false;
/*  601 */     private String postDataCharset = DataUtil.defaultCharsetName;
/*      */     
/*      */     private SSLSocketFactory sslSocketFactory;
/*      */     private CookieManager cookieManager;
/*      */     private RequestAuthenticator authenticator;
/*      */     private volatile boolean executing = false;
/*      */     
/*      */     Request() {
/*  609 */       this.timeoutMilliseconds = 30000;
/*  610 */       this.maxBodySizeBytes = 2097152;
/*  611 */       this.followRedirects = true;
/*  612 */       this.data = new ArrayList<>();
/*  613 */       this.method = Connection.Method.GET;
/*  614 */       addHeader("Accept-Encoding", "gzip");
/*  615 */       addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36");
/*  616 */       this.parser = Parser.htmlParser();
/*  617 */       this.cookieManager = new CookieManager();
/*      */     }
/*      */     
/*      */     Request(Request param1Request) {
/*  621 */       super(param1Request);
/*  622 */       this.proxy = param1Request.proxy;
/*  623 */       this.postDataCharset = param1Request.postDataCharset;
/*  624 */       this.timeoutMilliseconds = param1Request.timeoutMilliseconds;
/*  625 */       this.maxBodySizeBytes = param1Request.maxBodySizeBytes;
/*  626 */       this.followRedirects = param1Request.followRedirects;
/*  627 */       this.data = new ArrayList<>();
/*      */       
/*  629 */       this.ignoreHttpErrors = param1Request.ignoreHttpErrors;
/*  630 */       this.ignoreContentType = param1Request.ignoreContentType;
/*  631 */       this.parser = param1Request.parser.newInstance();
/*  632 */       this.parserDefined = param1Request.parserDefined;
/*  633 */       this.sslSocketFactory = param1Request.sslSocketFactory;
/*  634 */       this.cookieManager = param1Request.cookieManager;
/*  635 */       this.authenticator = param1Request.authenticator;
/*  636 */       this.executing = false;
/*      */     }
/*      */ 
/*      */     
/*      */     public Proxy proxy() {
/*  641 */       return this.proxy;
/*      */     }
/*      */ 
/*      */     
/*      */     public Request proxy(Proxy param1Proxy) {
/*  646 */       this.proxy = param1Proxy;
/*  647 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public Request proxy(String param1String, int param1Int) {
/*  652 */       this.proxy = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(param1String, param1Int));
/*  653 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public int timeout() {
/*  658 */       return this.timeoutMilliseconds;
/*      */     }
/*      */ 
/*      */     
/*      */     public Request timeout(int param1Int) {
/*  663 */       Validate.isTrue((param1Int >= 0), "Timeout milliseconds must be 0 (infinite) or greater");
/*  664 */       this.timeoutMilliseconds = param1Int;
/*  665 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public int maxBodySize() {
/*  670 */       return this.maxBodySizeBytes;
/*      */     }
/*      */ 
/*      */     
/*      */     public Connection.Request maxBodySize(int param1Int) {
/*  675 */       Validate.isTrue((param1Int >= 0), "maxSize must be 0 (unlimited) or larger");
/*  676 */       this.maxBodySizeBytes = param1Int;
/*  677 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean followRedirects() {
/*  682 */       return this.followRedirects;
/*      */     }
/*      */ 
/*      */     
/*      */     public Connection.Request followRedirects(boolean param1Boolean) {
/*  687 */       this.followRedirects = param1Boolean;
/*  688 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean ignoreHttpErrors() {
/*  693 */       return this.ignoreHttpErrors;
/*      */     }
/*      */ 
/*      */     
/*      */     public SSLSocketFactory sslSocketFactory() {
/*  698 */       return this.sslSocketFactory;
/*      */     }
/*      */ 
/*      */     
/*      */     public void sslSocketFactory(SSLSocketFactory param1SSLSocketFactory) {
/*  703 */       this.sslSocketFactory = param1SSLSocketFactory;
/*      */     }
/*      */ 
/*      */     
/*      */     public Connection.Request ignoreHttpErrors(boolean param1Boolean) {
/*  708 */       this.ignoreHttpErrors = param1Boolean;
/*  709 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean ignoreContentType() {
/*  714 */       return this.ignoreContentType;
/*      */     }
/*      */ 
/*      */     
/*      */     public Connection.Request ignoreContentType(boolean param1Boolean) {
/*  719 */       this.ignoreContentType = param1Boolean;
/*  720 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public Request data(Connection.KeyVal param1KeyVal) {
/*  725 */       Validate.notNullParam(param1KeyVal, "keyval");
/*  726 */       this.data.add(param1KeyVal);
/*  727 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public Collection<Connection.KeyVal> data() {
/*  732 */       return this.data;
/*      */     }
/*      */ 
/*      */     
/*      */     public Connection.Request requestBody(String param1String) {
/*  737 */       this.body = param1String;
/*  738 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public String requestBody() {
/*  743 */       return this.body;
/*      */     }
/*      */ 
/*      */     
/*      */     public Request parser(Parser param1Parser) {
/*  748 */       this.parser = param1Parser;
/*  749 */       this.parserDefined = true;
/*  750 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public Parser parser() {
/*  755 */       return this.parser;
/*      */     }
/*      */ 
/*      */     
/*      */     public Connection.Request postDataCharset(String param1String) {
/*  760 */       Validate.notNullParam(param1String, "charset");
/*  761 */       if (!Charset.isSupported(param1String)) throw new IllegalCharsetNameException(param1String); 
/*  762 */       this.postDataCharset = param1String;
/*  763 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public String postDataCharset() {
/*  768 */       return this.postDataCharset;
/*      */     }
/*      */     
/*      */     CookieManager cookieManager() {
/*  772 */       return this.cookieManager;
/*      */     }
/*      */     
/*      */     public Connection.Request auth(RequestAuthenticator param1RequestAuthenticator) {
/*  776 */       this.authenticator = param1RequestAuthenticator;
/*  777 */       return this;
/*      */     }
/*      */     
/*      */     public RequestAuthenticator auth() {
/*  781 */       return this.authenticator;
/*      */     } }
/*      */ 
/*      */   
/*      */   public static class Response extends Base<Connection.Response> implements Connection.Response {
/*      */     private static final int MAX_REDIRECTS = 20;
/*      */     private static final String LOCATION = "Location";
/*      */     private final int statusCode;
/*      */     private final String statusMessage;
/*      */     private ByteBuffer byteData;
/*      */     private ControllableInputStream bodyStream;
/*      */     private HttpURLConnection conn;
/*      */     private String charset;
/*      */     private final String contentType;
/*      */     private boolean executed = false;
/*      */     private boolean inputStreamRead = false;
/*  797 */     private int numRedirects = 0;
/*      */ 
/*      */     
/*      */     private final HttpConnection.Request req;
/*      */ 
/*      */     
/*  803 */     private static final Pattern xmlContentTypeRxp = Pattern.compile("(\\w+)/\\w*\\+?xml.*");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Response() {
/*  811 */       this.statusCode = 400;
/*  812 */       this.statusMessage = "Request not made";
/*  813 */       this.req = new HttpConnection.Request();
/*  814 */       this.contentType = null;
/*      */     }
/*      */     
/*      */     static Response execute(HttpConnection.Request param1Request) {
/*  818 */       return execute(param1Request, (Response)null);
/*      */     }
/*      */     
/*      */     static Response execute(HttpConnection.Request param1Request, Response param1Response) {
/*  822 */       synchronized (param1Request) {
/*  823 */         Validate.isFalse(param1Request.executing, "Multiple threads were detected trying to execute the same request concurrently. Make sure to use Connection#newRequest() and do not share an executing request between threads.");
/*  824 */         param1Request.executing = true;
/*      */       } 
/*  826 */       Validate.notNullParam(param1Request, "req");
/*      */       URL uRL;
/*  828 */       Validate.notNull(uRL = param1Request.url(), "URL must be specified to connect");
/*      */       String str1;
/*  830 */       if (!(str1 = uRL.getProtocol()).equals("http") && !str1.equals("https"))
/*  831 */         throw new MalformedURLException("Only http & https protocols supported"); 
/*  832 */       boolean bool = param1Request.method().hasBody();
/*  833 */       boolean bool1 = (param1Request.requestBody() != null) ? true : false;
/*  834 */       if (!bool) {
/*  835 */         Validate.isFalse(bool1, "Cannot set a request body for HTTP method " + param1Request.method());
/*      */       }
/*      */       
/*  838 */       String str2 = null;
/*  839 */       if (param1Request.data().size() > 0 && (!bool || bool1)) {
/*  840 */         serialiseRequestUrl(param1Request);
/*  841 */       } else if (bool) {
/*  842 */         str2 = setOutputContentType(param1Request);
/*      */       } 
/*  844 */       long l = System.nanoTime();
/*  845 */       HttpURLConnection httpURLConnection = createConnection(param1Request);
/*  846 */       Response response = null;
/*      */       try {
/*  848 */         httpURLConnection.connect();
/*  849 */         if (httpURLConnection.getDoOutput()) {
/*  850 */           OutputStream outputStream = httpURLConnection.getOutputStream(); 
/*  851 */           try { writePost(param1Request, outputStream, str2); }
/*  852 */           catch (IOException iOException) { httpURLConnection.disconnect(); throw iOException; }
/*  853 */           finally { outputStream.close(); }
/*      */         
/*      */         } 
/*  856 */         int i = httpURLConnection.getResponseCode();
/*      */ 
/*      */ 
/*      */         
/*  860 */         if ((response = new Response(httpURLConnection, param1Request, param1Response)).hasHeader("Location") && param1Request.followRedirects()) {
/*  861 */           if (i != 307) {
/*  862 */             param1Request.method(Connection.Method.GET);
/*  863 */             param1Request.data().clear();
/*  864 */             param1Request.requestBody(null);
/*  865 */             param1Request.removeHeader("Content-Type");
/*      */           } 
/*      */           
/*      */           String str3;
/*  869 */           Validate.notNull(str3 = response.header("Location"));
/*  870 */           if (str3.startsWith("http:/") && str3.charAt(6) != '/')
/*  871 */             str3 = str3.substring(6); 
/*  872 */           URL uRL1 = StringUtil.resolve(param1Request.url(), str3);
/*  873 */           param1Request.url(uRL1);
/*      */           
/*  875 */           param1Request.executing = false;
/*  876 */           return execute(param1Request, response);
/*      */         } 
/*  878 */         if ((i < 200 || i >= 400) && !param1Request.ignoreHttpErrors()) {
/*  879 */           throw new HttpStatusException("HTTP error fetching URL", i, param1Request.url().toString());
/*      */         }
/*      */         
/*      */         String str;
/*  883 */         if ((str = response.contentType()) != null && 
/*  884 */           !param1Request.ignoreContentType() && 
/*  885 */           !str.startsWith("text/") && 
/*  886 */           !xmlContentTypeRxp.matcher(str).matches())
/*      */         {
/*  888 */           throw new UnsupportedMimeTypeException("Unhandled content type. Must be text/*, */xml, or */*+xml", str, param1Request
/*  889 */               .url().toString());
/*      */         }
/*      */         
/*  892 */         if (str != null && xmlContentTypeRxp.matcher(str).matches() && 
/*  893 */           !param1Request.parserDefined) param1Request.parser(Parser.xmlParser());
/*      */ 
/*      */         
/*  896 */         response.charset = DataUtil.getCharsetFromContentType(response.contentType);
/*  897 */         if (httpURLConnection.getContentLength() != 0 && param1Request.method() != Connection.Method.HEAD) {
/*  898 */           InputStream inputStream = (httpURLConnection.getErrorStream() != null) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
/*  899 */           if (response.hasHeaderWithValue("Content-Encoding", "gzip")) {
/*  900 */             inputStream = new GZIPInputStream(inputStream);
/*  901 */           } else if (response.hasHeaderWithValue("Content-Encoding", "deflate")) {
/*  902 */             inputStream = new InflaterInputStream(inputStream, new Inflater(true));
/*      */           } 
/*  904 */           response
/*      */             
/*  906 */             .bodyStream = ControllableInputStream.wrap(inputStream, 32768, param1Request.maxBodySize()).timeout(l, param1Request.timeout());
/*      */         } else {
/*  908 */           response.byteData = DataUtil.emptyByteBuffer();
/*      */         } 
/*  910 */       } catch (IOException iOException) {
/*  911 */         if (response != null) response.safeClose(); 
/*  912 */         throw iOException;
/*      */       } finally {
/*  914 */         param1Request.executing = false;
/*      */ 
/*      */         
/*  917 */         if (param1Request.authenticator != null) {
/*  918 */           AuthenticationHandler.handler.remove();
/*      */         }
/*      */       } 
/*  921 */       response.executed = true;
/*  922 */       return response;
/*      */     }
/*      */ 
/*      */     
/*      */     public int statusCode() {
/*  927 */       return this.statusCode;
/*      */     }
/*      */ 
/*      */     
/*      */     public String statusMessage() {
/*  932 */       return this.statusMessage;
/*      */     }
/*      */ 
/*      */     
/*      */     public String charset() {
/*  937 */       return this.charset;
/*      */     }
/*      */ 
/*      */     
/*      */     public Response charset(String param1String) {
/*  942 */       this.charset = param1String;
/*  943 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public String contentType() {
/*  948 */       return this.contentType;
/*      */     }
/*      */     public Document parse() {
/*      */       ByteArrayInputStream byteArrayInputStream;
/*  952 */       Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before parsing response");
/*  953 */       ControllableInputStream controllableInputStream = this.bodyStream;
/*  954 */       if (this.byteData != null) {
/*  955 */         byteArrayInputStream = new ByteArrayInputStream(this.byteData.array());
/*  956 */         this.inputStreamRead = false;
/*      */       } 
/*  958 */       Validate.isFalse(this.inputStreamRead, "Input stream already read and parsed, cannot re-read.");
/*      */       Document document;
/*  960 */       (document = DataUtil.parseInputStream(byteArrayInputStream, this.charset, this.url.toExternalForm(), this.req.parser())).connection(new HttpConnection(this.req, this));
/*  961 */       this.charset = document.outputSettings().charset().name();
/*  962 */       this.inputStreamRead = true;
/*  963 */       safeClose();
/*  964 */       return document;
/*      */     }
/*      */     
/*      */     private void prepareByteData() {
/*  968 */       Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
/*  969 */       if (this.bodyStream != null && this.byteData == null) {
/*  970 */         Validate.isFalse(this.inputStreamRead, "Request has already been read (with .parse())");
/*      */         try {
/*  972 */           this.byteData = DataUtil.readToByteBuffer((InputStream)this.bodyStream, this.req.maxBodySize()); return;
/*  973 */         } catch (IOException iOException) {
/*  974 */           throw new UncheckedIOException(iOException);
/*      */         } finally {
/*  976 */           this.inputStreamRead = true;
/*  977 */           safeClose();
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public String body() {
/*  984 */       prepareByteData();
/*  985 */       Validate.notNull(this.byteData);
/*      */ 
/*      */       
/*  988 */       String str = ((this.charset == null) ? DataUtil.UTF_8 : Charset.forName(this.charset)).decode(this.byteData).toString();
/*  989 */       this.byteData.rewind();
/*  990 */       return str;
/*      */     }
/*      */ 
/*      */     
/*      */     public byte[] bodyAsBytes() {
/*  995 */       prepareByteData();
/*  996 */       Validate.notNull(this.byteData);
/*  997 */       return this.byteData.array();
/*      */     }
/*      */ 
/*      */     
/*      */     public Connection.Response bufferUp() {
/* 1002 */       prepareByteData();
/* 1003 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public BufferedInputStream bodyStream() {
/* 1008 */       Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
/*      */ 
/*      */       
/* 1011 */       if (this.byteData != null) {
/* 1012 */         return new BufferedInputStream(new ByteArrayInputStream(this.byteData.array()), 32768);
/*      */       }
/*      */       
/* 1015 */       Validate.isFalse(this.inputStreamRead, "Request has already been read");
/* 1016 */       Validate.notNull(this.bodyStream);
/* 1017 */       this.inputStreamRead = true;
/* 1018 */       return this.bodyStream.inputStream();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static HttpURLConnection createConnection(HttpConnection.Request param1Request) {
/*      */       Proxy proxy;
/*      */       HttpURLConnection httpURLConnection;
/* 1030 */       (httpURLConnection = ((proxy = param1Request.proxy()) == null) ? (HttpURLConnection)param1Request.url().openConnection() : (HttpURLConnection)param1Request.url().openConnection(proxy)).setRequestMethod(param1Request.method().name());
/* 1031 */       httpURLConnection.setInstanceFollowRedirects(false);
/* 1032 */       httpURLConnection.setConnectTimeout(param1Request.timeout());
/* 1033 */       httpURLConnection.setReadTimeout(param1Request.timeout() / 2);
/*      */       
/* 1035 */       if (param1Request.sslSocketFactory() != null && httpURLConnection instanceof HttpsURLConnection)
/* 1036 */         ((HttpsURLConnection)httpURLConnection).setSSLSocketFactory(param1Request.sslSocketFactory()); 
/* 1037 */       if (param1Request.authenticator != null)
/* 1038 */         AuthenticationHandler.handler.enable(param1Request.authenticator, httpURLConnection); 
/* 1039 */       if (param1Request.method().hasBody())
/* 1040 */         httpURLConnection.setDoOutput(true); 
/* 1041 */       CookieUtil.applyCookiesToRequest(param1Request, httpURLConnection);
/* 1042 */       for (Iterator<Map.Entry> iterator = param1Request.multiHeaders().entrySet().iterator(); iterator.hasNext();) {
/* 1043 */         for (String str : (entry = iterator.next()).getValue()) {
/* 1044 */           httpURLConnection.addRequestProperty((String)entry.getKey(), str);
/*      */         }
/*      */       } 
/* 1047 */       return httpURLConnection;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void safeClose() {
/* 1055 */       if (this.bodyStream != null) {
/*      */         try {
/* 1057 */           this.bodyStream.close();
/* 1058 */         } catch (IOException iOException) {
/*      */         
/*      */         } finally {
/* 1061 */           this.bodyStream = null;
/*      */         } 
/*      */       }
/* 1064 */       if (this.conn != null) {
/* 1065 */         this.conn.disconnect();
/* 1066 */         this.conn = null;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     private Response(HttpURLConnection param1HttpURLConnection, HttpConnection.Request param1Request, Response param1Response) {
/* 1072 */       this.conn = param1HttpURLConnection;
/* 1073 */       this.req = param1Request;
/* 1074 */       this.method = Connection.Method.valueOf(param1HttpURLConnection.getRequestMethod());
/* 1075 */       this.url = param1HttpURLConnection.getURL();
/* 1076 */       this.statusCode = param1HttpURLConnection.getResponseCode();
/* 1077 */       this.statusMessage = param1HttpURLConnection.getResponseMessage();
/* 1078 */       this.contentType = param1HttpURLConnection.getContentType();
/*      */       
/* 1080 */       LinkedHashMap<String, List<String>> linkedHashMap = createHeaderMap(param1HttpURLConnection);
/* 1081 */       processResponseHeaders(linkedHashMap);
/* 1082 */       CookieUtil.storeCookies(this.req, this.url, linkedHashMap);
/*      */       
/* 1084 */       if (param1Response != null) {
/*      */         
/* 1086 */         for (Map.Entry entry : param1Response.cookies().entrySet()) {
/* 1087 */           if (!hasCookie((String)entry.getKey()))
/* 1088 */             cookie((String)entry.getKey(), (String)entry.getValue()); 
/*      */         } 
/* 1090 */         param1Response.safeClose();
/*      */ 
/*      */         
/* 1093 */         param1Response.numRedirects++;
/* 1094 */         if (this.numRedirects >= 20) {
/* 1095 */           throw new IOException(String.format("Too many redirects occurred trying to load URL %s", new Object[] { param1Response.url() }));
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/*      */     private static LinkedHashMap<String, List<String>> createHeaderMap(HttpURLConnection param1HttpURLConnection) {
/* 1101 */       LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/* 1102 */       byte b = 0;
/*      */       while (true) {
/* 1104 */         String str1 = param1HttpURLConnection.getHeaderFieldKey(b);
/* 1105 */         String str2 = param1HttpURLConnection.getHeaderField(b);
/* 1106 */         if (str1 != null || str2 != null) {
/*      */           
/* 1108 */           b++;
/* 1109 */           if (str1 != null && str2 != null) {
/*      */ 
/*      */             
/* 1112 */             if (linkedHashMap.containsKey(str1)) {
/* 1113 */               ((List<String>)linkedHashMap.get(str1)).add(str2); continue;
/*      */             } 
/*      */             ArrayList<String> arrayList;
/* 1116 */             (arrayList = new ArrayList<>()).add(str2);
/* 1117 */             linkedHashMap.put(str1, arrayList);
/*      */           }  continue;
/*      */         }  break;
/* 1120 */       }  return (LinkedHashMap)linkedHashMap;
/*      */     }
/*      */     
/*      */     void processResponseHeaders(Map<String, List<String>> param1Map) {
/* 1124 */       for (Iterator<Map.Entry> iterator = param1Map.entrySet().iterator(); iterator.hasNext();) {
/*      */         
/* 1126 */         if ((str = (entry = iterator.next()).getKey()) != null) {
/*      */ 
/*      */           
/* 1129 */           List list = (List)entry.getValue();
/* 1130 */           if (str.equalsIgnoreCase("Set-Cookie"))
/* 1131 */             for (Iterator<String> iterator1 = list.iterator(); iterator1.hasNext();) {
/* 1132 */               if ((str1 = iterator1.next()) != null) {
/*      */                 TokenQueue tokenQueue;
/*      */                 
/* 1135 */                 String str3 = (tokenQueue = new TokenQueue(str1)).chompTo("=").trim();
/* 1136 */                 String str2 = tokenQueue.consumeTo(";").trim();
/*      */ 
/*      */                 
/* 1139 */                 if (str3.length() > 0 && !this.cookies.containsKey(str3))
/* 1140 */                   cookie(str3, str2); 
/*      */               } 
/*      */             }  
/* 1143 */           for (String str1 : list) {
/* 1144 */             addHeader(str, fixHeaderEncoding(str1));
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static String fixHeaderEncoding(String param1String) {
/* 1157 */       if (param1String == null) return param1String; 
/*      */       byte[] arrayOfByte;
/* 1159 */       if (looksLikeUtf8(arrayOfByte = param1String.getBytes(HttpConnection.ISO_8859_1))) {
/* 1160 */         return new String(arrayOfByte, DataUtil.UTF_8);
/*      */       }
/* 1162 */       return param1String;
/*      */     }
/*      */     
/*      */     private static boolean looksLikeUtf8(byte[] param1ArrayOfbyte) {
/* 1166 */       byte b = 0;
/*      */       
/* 1168 */       if (param1ArrayOfbyte.length >= 3 && (param1ArrayOfbyte[0] & 0xFF) == 239 && (param1ArrayOfbyte[1] & 0xFF) == 187 && (param1ArrayOfbyte[2] & 0xFF) == 191)
/*      */       {
/*      */ 
/*      */         
/* 1172 */         b = 3;
/*      */       }
/*      */ 
/*      */       
/* 1176 */       boolean bool = false;
/* 1177 */       for (int i = param1ArrayOfbyte.length; b < i; b++) {
/*      */         byte b1;
/* 1179 */         if (((b1 = param1ArrayOfbyte[b]) & 0x80) != 0) {
/*      */           int j;
/*      */           
/* 1182 */           bool = true;
/*      */ 
/*      */           
/* 1185 */           if ((b1 & 0xE0) == 192) {
/* 1186 */             j = b + 1;
/* 1187 */           } else if ((b1 & 0xF0) == 224) {
/* 1188 */             j = b + 2;
/* 1189 */           } else if ((b1 & 0xF8) == 240) {
/* 1190 */             j = b + 3;
/*      */           } else {
/* 1192 */             return false;
/*      */           } 
/*      */           
/* 1195 */           if (j >= param1ArrayOfbyte.length) {
/* 1196 */             return false;
/*      */           }
/* 1198 */           while (b < j) {
/* 1199 */             b++;
/*      */             
/* 1201 */             if (((b1 = param1ArrayOfbyte[b]) & 0xC0) != 128)
/* 1202 */               return false; 
/*      */           } 
/*      */         } 
/*      */       } 
/* 1206 */       return bool;
/*      */     }
/*      */     
/*      */     private static String setOutputContentType(Connection.Request param1Request) {
/* 1210 */       String str1 = param1Request.header("Content-Type");
/* 1211 */       String str2 = null;
/* 1212 */       if (str1 != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1217 */         if (str1.contains("multipart/form-data") && !str1.contains("boundary")) {
/* 1218 */           str2 = DataUtil.mimeBoundary();
/* 1219 */           param1Request.header("Content-Type", "multipart/form-data; boundary=" + str2);
/*      */         }
/*      */       
/*      */       }
/* 1223 */       else if (HttpConnection.needsMultipart(param1Request)) {
/* 1224 */         str2 = DataUtil.mimeBoundary();
/* 1225 */         param1Request.header("Content-Type", "multipart/form-data; boundary=" + str2);
/*      */       } else {
/* 1227 */         param1Request.header("Content-Type", "application/x-www-form-urlencoded; charset=" + param1Request.postDataCharset());
/*      */       } 
/* 1229 */       return str2;
/*      */     }
/*      */     private static void writePost(Connection.Request param1Request, OutputStream param1OutputStream, String param1String) {
/*      */       InputStream inputStream;
/* 1233 */       Collection collection = param1Request.data();
/* 1234 */       BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(param1OutputStream, Charset.forName(param1Request.postDataCharset())));
/*      */       
/* 1236 */       if (param1String != null) {
/*      */         
/* 1238 */         for (Connection.KeyVal keyVal : collection) {
/* 1239 */           bufferedWriter.write("--");
/* 1240 */           bufferedWriter.write(param1String);
/* 1241 */           bufferedWriter.write("\r\n");
/* 1242 */           bufferedWriter.write("Content-Disposition: form-data; name=\"");
/* 1243 */           bufferedWriter.write(HttpConnection.encodeMimeName(keyVal.key()));
/* 1244 */           bufferedWriter.write("\"");
/*      */           
/* 1246 */           if ((inputStream = keyVal.inputStream()) != null) {
/* 1247 */             bufferedWriter.write("; filename=\"");
/* 1248 */             bufferedWriter.write(HttpConnection.encodeMimeName(keyVal.value()));
/* 1249 */             bufferedWriter.write("\"\r\nContent-Type: ");
/* 1250 */             String str = keyVal.contentType();
/* 1251 */             bufferedWriter.write((str != null) ? str : "application/octet-stream");
/* 1252 */             bufferedWriter.write("\r\n\r\n");
/* 1253 */             bufferedWriter.flush();
/* 1254 */             DataUtil.crossStreams(inputStream, param1OutputStream);
/* 1255 */             param1OutputStream.flush();
/*      */           } else {
/* 1257 */             bufferedWriter.write("\r\n\r\n");
/* 1258 */             bufferedWriter.write(keyVal.value());
/*      */           } 
/* 1260 */           bufferedWriter.write("\r\n");
/*      */         } 
/* 1262 */         bufferedWriter.write("--");
/* 1263 */         bufferedWriter.write(param1String);
/* 1264 */         bufferedWriter.write("--");
/*      */       } else {
/*      */         String str;
/* 1267 */         if ((str = param1Request.requestBody()) != null) {
/*      */           
/* 1269 */           bufferedWriter.write(str);
/*      */         }
/*      */         else {
/*      */           
/* 1273 */           boolean bool = true;
/* 1274 */           for (Connection.KeyVal keyVal : inputStream) {
/* 1275 */             if (!bool) {
/* 1276 */               bufferedWriter.append('&');
/*      */             } else {
/* 1278 */               bool = false;
/*      */             } 
/* 1280 */             bufferedWriter.write(URLEncoder.encode(keyVal.key(), param1Request.postDataCharset()));
/* 1281 */             bufferedWriter.write(61);
/* 1282 */             bufferedWriter.write(URLEncoder.encode(keyVal.value(), param1Request.postDataCharset()));
/*      */           } 
/*      */         } 
/*      */       } 
/* 1286 */       bufferedWriter.close();
/*      */     }
/*      */ 
/*      */     
/*      */     private static void serialiseRequestUrl(Connection.Request param1Request) {
/* 1291 */       UrlBuilder urlBuilder = new UrlBuilder(param1Request.url());
/*      */       
/* 1293 */       for (Iterator<Connection.KeyVal> iterator = param1Request.data().iterator(); iterator.hasNext(); ) {
/* 1294 */         Connection.KeyVal keyVal; Validate.isFalse((keyVal = iterator.next()).hasInputStream(), "InputStream data not supported in URL query string.");
/* 1295 */         urlBuilder.appendKeyVal(keyVal);
/*      */       } 
/* 1297 */       param1Request.url(urlBuilder.build());
/* 1298 */       param1Request.data().clear();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean needsMultipart(Connection.Request paramRequest) {
/* 1304 */     for (Iterator<Connection.KeyVal> iterator = paramRequest.data().iterator(); iterator.hasNext();) {
/* 1305 */       if ((keyVal = iterator.next()).hasInputStream())
/* 1306 */         return true; 
/*      */     } 
/* 1308 */     return false;
/*      */   }
/*      */   
/*      */   public static class KeyVal implements Connection.KeyVal {
/*      */     private String key;
/*      */     private String value;
/*      */     private InputStream stream;
/*      */     private String contentType;
/*      */     
/*      */     public static KeyVal create(String param1String1, String param1String2) {
/* 1318 */       return new KeyVal(param1String1, param1String2);
/*      */     }
/*      */     
/*      */     public static KeyVal create(String param1String1, String param1String2, InputStream param1InputStream) {
/* 1322 */       return (new KeyVal(param1String1, param1String2))
/* 1323 */         .inputStream(param1InputStream);
/*      */     }
/*      */     
/*      */     private KeyVal(String param1String1, String param1String2) {
/* 1327 */       Validate.notEmptyParam(param1String1, "key");
/* 1328 */       Validate.notNullParam(param1String2, "value");
/* 1329 */       this.key = param1String1;
/* 1330 */       this.value = param1String2;
/*      */     }
/*      */ 
/*      */     
/*      */     public KeyVal key(String param1String) {
/* 1335 */       Validate.notEmptyParam(param1String, "key");
/* 1336 */       this.key = param1String;
/* 1337 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public String key() {
/* 1342 */       return this.key;
/*      */     }
/*      */ 
/*      */     
/*      */     public KeyVal value(String param1String) {
/* 1347 */       Validate.notNullParam(param1String, "value");
/* 1348 */       this.value = param1String;
/* 1349 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public String value() {
/* 1354 */       return this.value;
/*      */     }
/*      */     
/*      */     public KeyVal inputStream(InputStream param1InputStream) {
/* 1358 */       Validate.notNullParam(this.value, "inputStream");
/* 1359 */       this.stream = param1InputStream;
/* 1360 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public InputStream inputStream() {
/* 1365 */       return this.stream;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean hasInputStream() {
/* 1370 */       return (this.stream != null);
/*      */     }
/*      */ 
/*      */     
/*      */     public Connection.KeyVal contentType(String param1String) {
/* 1375 */       Validate.notEmpty(param1String);
/* 1376 */       this.contentType = param1String;
/* 1377 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public String contentType() {
/* 1382 */       return this.contentType;
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1387 */       return this.key + "=" + this.value;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\helper\HttpConnection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */