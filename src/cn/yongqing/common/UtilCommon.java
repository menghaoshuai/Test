package cn.yongqing.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.security.CodeSource;
import java.security.ProtectionDomain;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

/**
 * <p>Title: 通用工具类</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: yiyaosou.cc</p>
 * @author 董有红
 * @version 1.0
 */
public class UtilCommon {
	
    /**
	 * 判断对象是否为空
	 * 
	 * @param object 被判断的对象
	 * @return 判断结果，空位ture，否则为false
	 */
    public static boolean isNull(Object object) {
        return object == null || object.toString().trim().length() == 0 || object.toString().matches("^[0\\.]+$");
    }
    
    
    /**
	 * 获取类的class文件位置的URL。这个方法是本类最基础的方法，供其它方法调用。
	 * 
	 * @param cls 一个对象的Class属性
	 * @return 返回的URL
	 */
    private static URL getClassLocationURL(Class<?> cls) {
    	if (cls == null)
    		throw new IllegalArgumentException("null input: cls");
    	URL result = null;
    	String clsAsResource = cls.getName().replace('.', '/').concat(".class");
    	ProtectionDomain pd = cls.getProtectionDomain();
    	// java.lang.Class contract does not specify
    	// if 'pd' can ever be null;
    	// it is not the case for Sun's implementations,
    	// but guard against null
    	// just in case:
    	if (pd != null) {
    		CodeSource cs = pd.getCodeSource();
    		// 'cs' can be null depending on
    		// the classloader behavior:
    		if (cs != null)
    			result = cs.getLocation();

    		if (result != null) {
    			// Convert a code source location into
    			// a full class file location
    			// for some common cases:
    			if ("file".equals(result.getProtocol())) {
    				try {
    					if (result.toExternalForm().endsWith(".jar")
    								|| result.toExternalForm().endsWith(".zip"))
    						result = new URL("jar:".concat(result.toExternalForm()).concat("!/")
    								.concat(clsAsResource));
    					else if (new File(result.getFile()).isDirectory())
    						result = new URL(result, clsAsResource);
    				} catch (MalformedURLException ignore) {
    				}
    			}
    		}
    	}

    	if (result == null) {
    		// Try to find 'cls' definition as a resource;
    		// this is not
    		// document．d to be legal, but Sun's
    		// implementations seem to //allow this:
    		ClassLoader clsLoader = cls.getClassLoader();
    		result = clsLoader != null ? clsLoader.getResource(clsAsResource)
    				: ClassLoader.getSystemResource(clsAsResource);
    	}
    	return result;
    }
    
    /**
	 * 获取一个类的class文件所在的绝对路径。 这个类可以是JDK自身的类，也可以是用户自定义的类，或者是第三方开发包里的类。
	 * 只要是在本程序中可以被加载的类，都可以定位到它的class文件的绝对路径。
	 * 
	 * @param cls 一个对象的Class属性
	 * @return 这个类的class文件位置的绝对路径。 如果没有这个类的定义，则返回null。
	 * @exception 若文件不存在，抛出IOException
	 */
    public static String getPathFromClass(Class<?> cls) throws IOException {
    	String path = null;
    	if (cls == null) {
    		throw new NullPointerException();
    	}
    	URL url = getClassLocationURL(cls);
    	if (url != null) {
    		path = url.getPath();
    		if ("jar".equalsIgnoreCase(url.getProtocol())) {
    			try {
    				path = new URL(path).getPath();
    			} catch (MalformedURLException e) {
    			}
    			int location = path.indexOf("!/");
    			if (location != -1) {
    				path = path.substring(0, location);
    			}
    		}
    		File file = new File(path);
    		path = file.getCanonicalPath();
    	}
    	return path;
	}
    
    /**
     * 这个方法可以通过与某个类的class文件的相对路径来获取文件或目录的绝对路径。 通常在程序中很难定位某个相对路径，特别是在B/S应用中。
     * 通过这个方法，我们可以根据我们程序自身的类文件的位置来定位某个相对路径。
     * 比如：某个txt文件相对于程序的Test类文件的路径是../../resource/test.txt，
     * 那么使用本方法Path.getFullPathRelateClass("../../resource/test.txt",Test.class)
     * 得到的结果是txt文件的在系统中的绝对路径。
     *
     * @param relatedPath 相对路径
     * @param cls 用来定位的类
     * @return 相对路径所对应的绝对路径
     * @throws IOException 因为本方法将查询文件系统，所以可能抛出IO异常
     */
    public static String getFullPathRelateClass(String relatedPath, Class<?> cls) {
    	String path = null;
    	if (relatedPath == null) {
    		throw new NullPointerException();
    	}
    	try {
    		String clsPath = getPathFromClass(cls);
    		File clsFile = new File(clsPath);
    		String tempPath = clsFile.getParent() + File.separator + relatedPath;
    		File file = new File(tempPath);
    		path = file.getCanonicalPath();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return path;
    }
    
    /**
     * 读取输入流转，换为 Log4j文档对象
     *
     * @param in 被转换的输入流
     * @return 转换后的文档对象
     * @throws IOException 如果不是xml文档，抛出IOException
     */
    public static Document readDocument(InputStream in) throws IOException {
		Document document = null;
		try {
			SAXReader saxReader = new SAXReader();
			saxReader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			document = saxReader.read(in);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException(e.getMessage());
		} finally {
			in.close();
		}
		return document;
	}
    
    /**
     * 读取文件，转换为 Log4j文档对象
     *
     * @param file 被读取的文件
     * @return 转换后的文档对象
     * @throws IOException 如果文件不存在，抛出IOException
     */
    public static Document readDocument(File file) throws IOException {
		InputStream in = null;
		InputStreamReader reader = null;
		try {
			in = new FileInputStream(file);
			reader = new InputStreamReader(in, "utf-8");
			SAXReader saxReader = new SAXReader();
			saxReader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			return saxReader.read(reader);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException(e.getMessage());
		} finally {
			if (in != null)
				in.close();
			if (reader != null)
				reader.close();
		}
	}
    
    /**
	 * 读取文件的内容
	 * 
	 * @param file 被读取的文件
	 * @return 文件内容
	 * @exception 若文件不存在，抛出IOException
	 */
	public static String readInput(File file) throws IOException {
		FileInputStream in = null;
		FileChannel fc = null;
		StringBuffer buffer = new StringBuffer();
		try {
			in = new FileInputStream(file);
			fc = in.getChannel();
			int length = (int)fc.size();
		    ByteBuffer bf = ByteBuffer.allocate(length);
		    CharBuffer cf = CharBuffer.allocate(length);
		    Charset charSet = Charset.forName("utf-8");
	        CharsetDecoder decoder = charSet.newDecoder();
	        fc.read(bf);
        	bf.flip();
        	decoder.decode(bf, cf, false);  
            cf.flip();
            buffer.append(cf);  
            cf.clear();  
            bf.clear(); 
		} finally {
			if (in != null)
				in.close();
			if (fc != null)
				fc.close();
		}
		return buffer.toString();
	}
    
    /**
	 * 把source写到文件file
	 *
	 * @param source 源头数据
	 * @param file 输出文件
	 * @exception 若被输出的文件不存在，或写入时错误，抛出IOException
	 */
    public static void writeOutput(String source, File file) throws IOException {
    	OutputStreamWriter writer = null;
    	FileOutputStream output = null;
    	try {
    		output = new FileOutputStream(file);
    		writer = new OutputStreamWriter(output, "utf-8");    		
    		writer.write(source);
    		writer.flush();
    	} finally {
    		if (output != null)
				output.close();
			if (writer != null)
				writer.close();
    	}
    }
	
    public static void main(String[] args) throws Exception {
//    	String filename = UtilCommon.getFullPathRelateClass("../../../sql/chace.hbm.xml", UtilCommon.class);
//    	System.out.println(filename);

    	String value = "234\"35";
    	value = value.replaceAll("\"", "\\\\\"");
    	System.out.println(value);
    	
//    	Calendar calendar = Calendar.getInstance();
//		int year = calendar.get(Calendar.YEAR);
//    	String abc = faBuInfoTable("http://qinhuangdao.ohqly.com/2711/2014042390277022v0.html");
    	
//    	System.out.println(year);
	}
    
    public static Double dealNum(Double num){
		Double finalnum=0.0;
		Double intnum=(Double)Math.floor(num);
		BigDecimal bdnum=new BigDecimal(num+"");
		BigDecimal bdintnum=new BigDecimal(intnum+"");
		Double subnum=bdnum.subtract(bdintnum).doubleValue();
		if(subnum<0.3){
			finalnum=intnum;
		}else if(subnum>=0.3&&subnum<=0.7){
			finalnum=intnum+0.5;
		}else if(subnum>0.7){
			finalnum=intnum+1.0;
		}
		return finalnum;
	}
}
