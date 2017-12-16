package cn.yongqing.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;


/**
 * <p>Title: 处理 图片工具类</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: yiyaosou.cc</p>
 * @author 董有红
 * @version 1.0
 */
public class UtilImage {
	
	private static int WIDTH = 60;
	private static int HEIGHT = 20;
	private static String[] CODES = {"2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","J","K","L","M","N","P","Q","R","S","T","U","V","W","X","Y","Z"};  
	private static Random RANDOM = new Random();
	private static byte[] huiYuan_center_default;
	
	public static String zifu() {
		StringBuffer zifu = new StringBuffer();
		for(int i=0;i<4; i++) {
			String str = CODES[RANDOM.nextInt(CODES.length)];  
		    zifu.append(str);  
		}
		return zifu.toString();
	}
	
	private static Color getRandColor(int fc, int bc) {
		if(fc>255)
			fc=255;
		if(bc>255)
			bc=255;
	    int r = fc + RANDOM.nextInt(bc - fc);
	    int g = fc + RANDOM.nextInt(bc - fc);
	    int b = fc + RANDOM.nextInt(bc - fc);
	    return new Color(r,g,b);
	}  
	
	/**
     * 生成随机图片
     * 
     * @param zifu 随机字符
     * @return 生成的随机图片
     */
	public static BufferedImage randomImage(String zifu) { 
	    //在内存中创建图像
	    BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	    //获取图形上下文
	    Graphics g = image.getGraphics();
	    //设定背景 
	    g.setColor(getRandColor(200, 250));
	    g.fillRect(0, 0, WIDTH, HEIGHT);
	    //设定字体 
	    g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    //随机产生干扰线 
	    g.setColor(getRandColor(160, 200));  
	    for (int i = 0; i < 100; i++) {     
	    	int x = RANDOM.nextInt(WIDTH); 
	    	int y = RANDOM.nextInt(HEIGHT); 
	    	int xl = RANDOM.nextInt(12); 
	    	int yl = RANDOM.nextInt(12);  
	    	g.drawLine(x, y, x + xl, y + yl);  
	    }    
	    for(int i=0; i<zifu.length(); i++) {
	    	// 将认证码显示到图象中  
	    	g.setColor(new Color(20 + RANDOM.nextInt(110), 20 + RANDOM.nextInt(110), 20 + RANDOM.nextInt(110)));  
	    	//调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成     
	    	g.drawString(String.valueOf(zifu.charAt(i)), 13 * i + 6, 16);     
	    } 
	    // 图象生效     
	    g.dispose();     
	    return image;
	}
	
	public static BufferedImage scaleToMediumIcon(byte[] b) throws IOException {
		BufferedImage image = ImageIO.read(new ByteArrayInputStream(b));
		BufferedImage tag = new BufferedImage(160, 160, BufferedImage.TYPE_INT_RGB);
		Graphics g = tag.getGraphics();
		g.drawImage(image, 0, 0, tag.getWidth(), tag.getHeight(), null); // 绘制缩小后的图
		g.dispose();
		return tag;
	}
	
	public static BufferedImage scaleToHundredWidth(byte[] b) throws IOException {
		BufferedImage image = ImageIO.read(new ByteArrayInputStream(b));
		int width = image.getWidth();
		int height = image.getHeight();
		int _height = 100*height/width;
		int _width = 100;
		BufferedImage tag = new BufferedImage(_width, _height, BufferedImage.TYPE_INT_RGB);
		Graphics g = tag.getGraphics();
		g.drawImage(image, 0, 0, tag.getWidth(), tag.getHeight(), null); // 绘制缩小后的图
		g.dispose();
		return tag;
	}
	
	public static byte[] imageToBytes(BufferedImage image) throws IOException {
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		ImageOutputStream out = ImageIO.createImageOutputStream(bs);
		ImageIO.write(image, "jpg", out);
		return bs.toByteArray();
	}
	
	public static byte[] huiYuanCenterDefault() {
		if (huiYuan_center_default != null)
			return huiYuan_center_default;
		String filename = UtilCommon.getFullPathRelateClass("huiYuan_center_default.png", UtilImage.class);
		File file = new File(filename);
		try {
			BufferedImage image = ImageIO.read(file);
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			ImageOutputStream out = ImageIO.createImageOutputStream(bs);
			ImageIO.write(image, "png", out);
			huiYuan_center_default = bs.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			huiYuan_center_default = new byte[0];
		}
		return huiYuan_center_default;
	}
}