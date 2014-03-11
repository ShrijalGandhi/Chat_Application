import java.io.*;
import java.net.*;

class DataOfSender
{
	static InputStreamReader r;
	static BufferedReader br;
	static BufferedWriter writer;
	static DataInputStream input;
 	static DataOutputStream output;

	public static ServerSocket s;
	public static Socket s1;

	DataOfSender()throws IOException,InterruptedException
	{
	s=new ServerSocket(80);
	s1=s.accept();
	
	r=new InputStreamReader(System.in);
	br=new BufferedReader(r);
	writer = new BufferedWriter(new OutputStreamWriter(s1.getOutputStream()));
	input= new DataInputStream(s1.getInputStream());
	output= new DataOutputStream(s1.getOutputStream());
	
		start(); 
	}

	void start()throws IOException,InterruptedException
	{
	String toReceive=new String();
	String toSend=new String();
		boolean flag=true;

		while(true)
		{
			if(flag)
			{
			toReceive=input.readLine();

				if(toReceive.equals("done"))
				{
				flag=false;
				}

			System.out.println(toReceive);
			}
			else
			{
			toSend=br.readLine();

				if(toSend.equals("done"))
				{
				flag=true;
				}

			writer.write(toSend);
			writer.newLine();
			writer.flush();
			}
		}
	}

	synchronized void waitTime()throws InterruptedException
	{
		wait(1000);
		return;
	}
}

class Sender
{
	public static void main(String args[])throws IOException,InterruptedException
	{
	DataOfSender d=new DataOfSender();
	}
}