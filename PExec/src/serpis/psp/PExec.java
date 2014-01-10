package serpis.psp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PExec extends JFrame implements ActionListener
{
	    private JButton boton1,boton2,boton3;
	    
	    public PExec() {
	        setLayout(null);
	        boton1=new JButton("1");
	        boton1.setBounds(10,100,90,30);
	        add(boton1);
	        boton1.addActionListener(this);
	        boton2=new JButton("2");
	        boton2.setBounds(110,100,90,30);
	        add(boton2);
	        boton2.addActionListener(this);
	        boton3=new JButton("3");
	        boton3.setBounds(210,100,90,30);
	        add(boton3);
	        boton3.addActionListener(this);        	
	    }
	    
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource()==boton1) {
	            ejecutar("firefox");
	        }
	        if (e.getSource()==boton2) {
	        	ejecutar("cmd");
	        }
	        if (e.getSource()==boton3) {
	        	ejecutar("");
	        }        
	    }
	
	public static void ejecutar(String programa)
	{
		try
		{
		   /* directorio/ejecutable es el path del ejecutable y un nombre */
		   Process p = Runtime.getRuntime().exec(programa);
		}
		catch (Exception e)
		{
		   /* Se lanza una excepción si no se encuentra en ejecutable o el fichero no es ejecutable. */
		}
	}
	
	public static void main(String[] args)
	{
		//Scanner sc = new Scanner(System.in);
		//System.out.println("Qué programa quieres ejecutar");
		//String programa = sc.nextLine();
		PExec formulario1=new PExec();
        formulario1.setBounds(0,0,350,200);
        formulario1.setVisible(true);
		
	}
}
