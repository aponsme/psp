package serpis.psp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class TcpClient 
{
//private static final String CONTENT_LENGTH="Content-Length";
private static final String SERVER_IP = "127.0.0.1";
private static final int SERVER_PORT = 12345;

public static void main(String[] args) throws UnknownHostException, IOException
{
	//String serverName="www.google.es";//String serverName="args[0]";
	//int port=80;//int port=Integer.parseInt(args[1]);
	System.out.printf("TcpClient serverName=%s port=%s\n",SERVER_IP,SERVER_PORT);
	
	
	Socket socket=new Socket(SERVER_IP,SERVER_PORT);//Creo el flujo
	String lineOut="Hola";
	
	
	System.out.printf("TcpClient Enviado= '%s'\n",lineOut);
	PrintWriter printWriter=new PrintWriter(socket.getOutputStream());//Para escribir
	printWriter.printf("%s\n",lineOut);
	//printWriter.printf("%s\r\n","GET /Imagen1.png HTTP/1.0");
	//printWriter.printf("%s\r\n","GET / HTTP/1.1");
	//printWriter.printf("%s\r\n","www.google.es");
	//printWriter.printf("\r\n");
	printWriter.flush();
	
	Scanner scanner=new Scanner(socket.getInputStream());//Para leer flujos 
	//constituidos por lineas de texto. No valdria si paso una imagen, sonido...
	//int contentLength=0;
	String lineIn=scanner.nextLine();
	System.out.printf("TcpClient Recibido= '%s'\n",lineIn);
//	while(scanner.hasNextLine())
//	{
//		String line=scanner.nextLine();//lee lineas y una linea en blanco es el final de la petición
//		System.out.printf("[%s]\n",line);	
//		//if(line.startsWith(CONTENT_LENGTH))
//			//contentLength=Integer.parseInt(line.substring(CONTENT_LENGTH.length()));
//		//Mejor que lo anterior poner
//		if(line.equals(""))
//			break;
//	}
	//System.out.printf("%s%s\n",CONTENT_LENGTH,contentLength);
	System.out.printf("TcpClient end.\n");
	socket.close();
	
	
}
}