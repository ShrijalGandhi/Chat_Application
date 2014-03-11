import java.io.*;
import java.net.*;

class DataOfReceiver
{
	static DataInputStream input;
 	static DataOutputStream output;
	static InputStreamReader r;
	static BufferedReader br;
	static BufferedWriter writer;
             
	Socket s1=new Socket("116.203.252.110",80);

	DataOfReceiver()throws IOException,InterruptedException
	{
	r=new InputStreamReader(System.in);
	br=new BufferedReader(r);

writer = new BufferedWriter(new OutputStreamWriter(s1.getOutputStream()));

	input= new DataInputStream(s1.getInputStream());
	output= new DataOutputStream(s1.getOutputStream());

	

		start();
	}

	void start()throws IOException,InterruptedException
	{
	String toSend;
	String toReceive;
	boolean flag=true;
		while(true)
		{
		if(flag)
		{
		toSend=br.readLine();
			if(toSend.equals("done"))
			{
			flag=false;
			}
		writer.write(toSend);
        	writer.newLine();
        	writer.flush();
		}
		else
		{
		toReceive=input.readLine();
						
			if(toReceive.equals("done"))
			{
			flag=true;
			}
		System.out.println(toReceive);
		}
		
		}
	}

	synchronized void waitTime()throws InterruptedException
	{
		wait(1000);
		return;
	}

	void sending()throws IOException
	{
		while(true)
		{
		
		}
	}
}

class Receiver
{
	public static void main(String args[])throws IOException,InterruptedException
	{
	DataOfReceiver d=new DataOfReceiver();
	}
}