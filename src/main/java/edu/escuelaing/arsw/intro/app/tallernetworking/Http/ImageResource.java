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
        
        System.out.println("entra?????? ****final: "+archivoEncontrado);
        System.out.println("ME ENCUENTRO EN IMAGEN Y ESTA ES LA RES: "+res);
		String archivoNombre =  archivoEncontrado.toString().replace(res, "");
		System.out.println("ME ENCUENTRO EN IMAGEN Y ESTA ES LA RES: "+res);
		System.out.println("archivoNombre: "+archivoNombre);
		//File f = new File(archivoNombre+"img/"+res);
        if(res.contains("img/")){
            
            res = res.substring(4,res.length());
            System.out.println("Entro en condicAICIOn: "+res);
        }
		//if(f==null){
		//	System.out.println("ES NULO ESTA PORQUERIA");
		//}
		//else{
		//	String axa=f.toString();
		File f = new File("/app/src/main/resources/img/suzaku.png");
		if(f==null){
			System.out.println("Y TAN LARGO EL RENCOR");
		}
		else{
			System.out.println("Questa e la imagine: "+f.toString());
			System.out.println("Questa e la imagine: "+f);
		}
		//}
		
        //BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir") + "/resources" + "/suzaku.PNG"));
        //BufferedImage image = ImageIO.read(new File("C:\\Users\\Z470\\Documents\\NetBeansProjects\\TallerNetworking\\src\\main\\resources\\img\\"+res)); 
		//BufferedImage image = ImageIO.read(new File(archivoNombre+"img/"+res)); 
		  //BufferedImage image = ImageIO.read(new File("/app/src/main/resources/img/suzaku.png")); 
		//BufferedImage image = ImageIO.read(f); 
		BufferedImage image = ImageIO.read(new File("resources/img/suzaku.PNG")); 
		
		
        //BufferedImage image = ImageIO.read(archivoEncontrado);
        //new File("C:\\Users\\Z470\\Documents\\NetBeansProjects\\TallerNetworking\\src\\main\\resources\\img\\bugs.jpg")
                    //C:\Users\Z470\Documents\NetBeansProjects\TallerNetworking\src\main\resources\img\suzaku.png
        //System.out.println("PASA EL PRIMER LINEA");
		//out.println("Archivoo: "+archivoNombre);
		String xxxx=  image.toString();
        System.out.println("la imagen SE MOSTRARAA: "+xxxx);
		out.println("HTTP/1.1 200 OK");		
        out.println("Content-Type: image/png");
        out.println();
        //out.print("HTTP/1.1 200 OK \r\n");
        //out.print("Content-Type: image/png \r\n");
        //out.print("\r\n\r\n");
        ImageIO.write(image, "PNG", clientSocket);
        
    }
}
