package serpis.psp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PExec extends JFrame implements ActionListener,Runnable
{
	    private JButton boton1,boton2,boton3,boton4;
	    String sO=System.getProperty("os.name");//Nos devuelve el SO donde esta corriendo
	    public PExec() 
	    {
	        setLayout(null);
	        boton1=new JButton(new ImageIcon("1.png"));
	        boton1.setBounds(10,100,90,30);
	        add(boton1);
	        boton1.addActionListener(this);
	        boton2=new JButton(new ImageIcon("2.png")); 
	        boton2.setBounds(110,100,90,30);
	        add(boton2);
	        boton2.addActionListener(this);
	        boton3=new JButton(new ImageIcon("3.jpg"));
	        boton3.setBounds(210,100,90,30);
	        add(boton3);
	        boton3.addActionListener(this); 
	        boton4=new JButton("ifconfig"); 
	        boton4.setBounds(110,50,90,30);
	        add(boton4);
	        boton4.addActionListener(this);
	    }
	    
	    public void actionPerformed(ActionEvent e) 
	    {
	        if (e.getSource()==boton1) 
	        {
	            run();
	        }
	        if (e.getSource()==boton2) 
	        {	
	        	
	        	if(sO.indexOf("Windows")!=-1)
	        	{
	        		ejecutar("notepad");//"lsb_release -a"
	        	}
	        	else
	        	{
	        		ejecutar("gedit");
	        	}
	        }
	        if (e.getSource()==boton3) 
	        {
	        	if(sO.indexOf("Windows")!=-1)
	        	{
	        		ejecutar("cmd /c dir");
	        	}
	        	else
	        	{
	        		ejecutar("Terminal");
	        	}
	        }   
	        if (e.getSource()==boton4) 
	        {
	        	if(sO.indexOf("Windows")!=-1)
	        	{
	        		ejecutar("cmd /c ipconfig");
	        	}
	        	else
	        	{
	        		ejecutar("ifconfig");
	        	}
	        }
	    }
	//Este método ejecuta el String que le pasamos por parámetro
	public static void ejecutar(String programa)
	{
		try
		{
		   
		   Process p = Runtime.getRuntime().exec(programa);
		   BufferedReader in = new BufferedReader(  
                   new InputStreamReader(p.getInputStream()));  
			String line = null;  
			while ((line = in.readLine()) != null) {  
			   System.out.println(line);  
			}  
		}
		catch (Exception e)
		{
		   System.out.println("Introduzca un comando valido");
		}
	}
	//Este método ejecuta un array que le pasamos por parámetro
	public static void ejecutarComandoVector(String[] programa)
	{
		try
		{
		   
		   Process p = Runtime.getRuntime().exec(programa);
		   BufferedReader in = new BufferedReader(  
                   new InputStreamReader(p.getInputStream()));  
			String line = null;  
			while ((line = in.readLine()) != null) {  
			   System.out.println(line);  
			}  
		}
		catch (Exception e)
		{
		   System.out.println("Introduzca un comando valido");
		}
	}
	public static void main(String[] args)
	{
		PExec exec=new PExec();
		exec.setBounds(0,0,350,200);
		exec.setVisible(true);
	}

	@Override
	//Creamos un hilo para ejecutar uno de ellos
	public void run() 
	{
		String[] cmd={};//Apagado de windows
		String navegador="C:/Program Files (x86)/Mozilla Firefox/firefox.exe";
		if(sO.indexOf("Windows")!=-1)
    	{
    		ejecutar(navegador);//"lsb_release -a"
    	}
    	else
    	{
    		ejecutar("Firefox");
    	}
	}
}
