package edu.escuelaing.arsw.intro.app.tallernetworking.Http;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import javax.imageio.ImageIO;

/**
 *
 * @author Eduard Jimenez
 */
public class ImageResource {

    public void drawImage(OutputStream  clientSocket,PrintWriter out ,String res, File archivoEncontrado) throws IOException {
        
		
			try{
			String archivoNombre =  archivoEncontrado.toString().replace(res, "");
			System.out.println("IMAGEEEEN: "+archivoEncontrado);
			System.out.println("archivoNombre sin res : "+archivoNombre);
			if(res.contains("img/")){
				res = res.substring(4,res.length());
				System.out.println("Entro en condicion de tener img/: "+res);
			}
		
			System.out.println("ImagenResource: res"+res);
			System.out.println("Path del archivo: "+System.getProperty("user.dir")+ "/resources/" + res);
			
			File variable = new File(System.getProperty("user.dir")+ "/resources/" + res);
			System.out.println("File creado: "+variable);
			//BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+ "/resources/" + res));
			BufferedImage image = ImageIO.read(new File("/app/src/main/resources/img/bugs.jpg"));
            ByteArrayOutputStream ArrBytes = new ByteArrayOutputStream();
            DataOutputStream writeImg = new DataOutputStream(clientSocket);
            ImageIO.write(image, "PNG", ArrBytes);
            writeImg.writeBytes("HTTP/1.1 200 OK \r\n");
            writeImg.writeBytes("Content-Type: image/png \r\n");
            writeImg.writeBytes("\r\n");
            writeImg.write(ArrBytes.toByteArray());
            System.out.println("Ruta de archivo: "+System.getProperty("user.dir") + res);
			}
			catch(javax.imageio.IIOException ex){
				HttpServer.error("","Mensaje de error: "+ex,out);
				System.out.println("Capturando en no puedo crear la imagen "+ex);
			}
        
    }
}
