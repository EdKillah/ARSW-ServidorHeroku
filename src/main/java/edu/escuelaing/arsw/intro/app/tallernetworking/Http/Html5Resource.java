package edu.escuelaing.arsw.intro.app.tallernetworking.Http;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Class with the responsibility of return HTML5 elements
 * @author Eduard Jimenez
 */
public class Html5Resource {

    /**
     * Write HTML5 components on the clientSocket
     * @param clientSocket
     * @param out
     * @param archivoEncontrado
     * @param type
     * @throws IOException 
     */
    public void writeText(OutputStream clientSocket, PrintWriter out, File archivoEncontrado,String type) throws IOException {
        StringBuilder cadena = new StringBuilder();
        String line = null;
		System.out.println("Creando el archivo lector en writeText");
        FileReader prueba = new FileReader(archivoEncontrado);
		System.out.println("Pruebaa creada: "+prueba);
        BufferedReader reader = new BufferedReader(prueba);
		System.out.println("el reader see creo ok : "+reader);
        while ((line = reader.readLine()) != null) {

            cadena.append(line);
        }
		//System.out.println("SUPERO TODO: "+cadena);
        out.println("HTTP/1.1 200 OK");		
        out.println("Content-Type: "+type);

		out.println();
        out.println(cadena);

    }

}
