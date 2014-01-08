package serpis.psp;


import java.io.IOException;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServer 
{
	private static final int puerto = 12345;//Puerto en el que va a escuchar el servidor
	
	
	public static void main(String[] args) throws IOException 
	{
		
	ServerSocket serverSocket = new ServerSocket(puerto);//El Servidor se pone a escuchar posibles peticiones
	
	System.out.printf("El ServerSocket se ha unido con éxito al puerto TcpServer port=%s\n",puerto);

	Socket socket = serverSocket.accept();//El servidor acepta la conexion del cliente
	//Cuando accept recoge la conexion se lo asigna a la variable socket
	
	Scanner scanner = new Scanner(socket.getInputStream());//Leo la peticion de cliente
	String lineIn=scanner.nextLine();
	System.out.printf("TcpClient Recibido= '%s'\n",lineIn);
	String lineOut=lineIn.toUpperCase();
	
	PrintWriter printWriter=new PrintWriter(socket.getOutputStream());//Para escribir
	printWriter.printf("%s\n",lineOut);
	printWriter.flush();
	System.out.printf("TcpServer end.\n");
	socket.close();
					
	}
}
