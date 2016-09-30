package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


public class MyCaptchaUtils {
	public static enum Level{easy,medium,hard};
	
	public static final char[] easy={'1','2','3','4','5','6','7','8','9','0'};
	
	private static Random random = new Random();

	
	public  Object[] getCaptcha(int width ,int height,int fontsize,int linecount,int pointcount,boolean border,boolean colours,Level level,boolean jampoint,boolean jamline) {
		
		Object[] objects = new Object[2];
		
		StringBuffer sb = new StringBuffer();
		
		int position = 0;
		
		BufferedImage bf = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Graphics graphics = bf.getGraphics();
		
		graphics.fillRect(0, 0, width, height);
		
		graphics.setFont(new Font("Arial",Font.BOLD,fontsize));
		
		graphics.setColor(Color.BLACK);
		
		if(border)graphics.drawRect(0, 0, width-1, height-1);
		
		
		//绘制干扰线
		if(jamline)
		for (int j = 0; j < linecount; j++) {
			graphics.drawLine(random.nextInt(width), random.nextInt(height),random.nextInt(width), random.nextInt(height));
		}
		//绘制干扰点
		if(jampoint)
		for (int k = 0; k < pointcount; k++) {
			graphics.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
		}
		
		for(int i = 0;i<6;i++){
			
			if(colours)graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			
			position = random.nextInt(easy.length);
			
			graphics.drawString(easy[position]+"",(i*((width-10)/6))+5+random.nextInt(((width-10)/6)/2),height/2+random.nextInt(height/2));
			
			sb.append(easy[position]);
		}
		graphics.dispose();
		
		objects[0]=bf;
		objects[1]=sb.toString();
		
		return objects;
	}
	
	public   Object[] getCaptcha2(int width ,int height,int fontsize,int linecount,int pointcount,boolean border,boolean colours,Level level,boolean jampoint,boolean jamline){
		Object[] objects = getCaptcha(width, height, fontsize, linecount, pointcount, border, colours, level, jampoint, jamline);
		byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            BufferedImage challenge = (BufferedImage)objects[0];
            JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(jpegOutputStream);
            jpegEncoder.encode(challenge);
        } catch (Exception e) {
            e.printStackTrace();
        }
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
		objects[0] = captchaChallengeAsJpeg;
		
		return objects;
	}

	public static void main(String[] args) throws IOException {
		/*Object[] obj=getCaptcha(150, 50, 35, 50, 500, true,true, Level.easy,false,true);
		System.out.println("验证码"+obj[1]);
		new File("C:\\test").mkdir();
		ImageIO.write((BufferedImage)obj[0],"jpg",new File("C:\\test\\"+System.currentTimeMillis()+".jpg"));*/
		MyCaptchaUtils utils = new MyCaptchaUtils();
		Object[] object = utils.getCaptcha2(150, 50, 35, 50, 500, true, true, Level.easy, false, true);
		System.out.println(object[0]+"  + +  + + "+object[1].toString());
		
		
		Object[] obj=utils.getCaptcha(150, 50, 35, 50, 500, true,true, Level.easy,false,true);
		System.out.println("验证码"+obj[1]);

	}

}
