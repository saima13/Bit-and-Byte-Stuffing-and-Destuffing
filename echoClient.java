import java.io.*;
import java.net.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;


public class echoClient {
    public static void main(String[] args) throws IOException, ParseException {
		System.out.println("**************echoClient.java**********************");
		System.out.println("Bit and Byte Stuffing/Unstuffing Project");
		System.out.println("Chris Robbins, Saima, Nacool, Nick");
		System.out.println("Team 7");
		System.out.println("CS633");
		System.out.println("12/01/16");
		System.out.println("Program Notes: This file must be started after echoServer.java");
		System.out.println("************************************");
        /*if (args.length != 2) {
            System.err.println(
                "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }*/

        //String hostName = args[0];
        //int portNumber = Integer.parseInt(args[1]);
    	String hostName = "127.0.0.1";
    	int portNumber = 4444;
        try (
            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out =
                new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in =
                new BufferedReader(
                    new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn =
                new BufferedReader(
                    new InputStreamReader(System.in))
        ) {
            String userInput;
            ByteStuffing stuff = new ByteStuffing();
            int select;
            String data;
            String flag = "";
            boolean check = true;
            while (check) {
            	System.out.println();
            	System.out.print("\nEnter the Data Stream: ");
                data= stdIn.readLine();
                out.println(data);
            	System.out.print("\nFraming methods to choose from:\n1) Byte Stuffing\n2)Bit Stuffing\n\nEnter the number for the corresponding Framing technique: ");
                select=Integer.parseInt(stdIn.readLine());
                out.println(select);
                if(select == 1)
                {
                	
                	System.out.print("\nEnter the Flag Stream: ");
                	flag=stdIn.readLine();
                	out.println(flag);
                }
                else if (select == 2)
                {
                	flag="01111110";
                	out.println(flag);
                }
                /*switch(select)
                {
                            case 1: System.out.print("\nEnter the Flag Stream: ");                                   
                                        flag=stdIn.readLine();
                                        out.println("********************************************");
                                        out.print("Data received from client: ");
                                        out.println(ByteStuffing.Byte(data,flag));
                                        out.print("Unstuffed Data from client: ");
                            			out.println(ByteStuffing.ByteUnstuff(ByteStuffing.Byte(data,flag),flag));
                                        //System.out.print("\nThe Frame after processing: "+ByteStuffing.Byte(data,flag));
                                        break;
                            case 2: flag="01111110";
                            			out.println("********************************************");
                            			out.print("Data received from client: ");
                            			out.println(ByteStuffing.Bit(data,flag));
                            			out.print("Unstuffed Data from client: ");
                            			out.println(ByteStuffing.BitUnstuff(ByteStuffing.Bit(data,flag),flag));
                                        //System.out.print("\nThe Flag Stream is: "+flag);
                                       //System.out.print("\n\nThe Frame after processing: "+ByteStuffing.Bit(data,flag));
                                        break;
                }*/
                //out.println(ByteStuffing.Bit(userInput, flag));
                
                String sIn;
                System.out.println();
                System.out.print("Go again (yes/no): ");
                if((sIn = stdIn.readLine()).equals("no")){
                	check = false;
                	for(int i = 0; i < 3; i++)
                	{
                		if(i == 1)out.println(8);
                		else out.println("");
                	}
                	
                }
                //System.out.println("echo: " + in.readLine());
                /*boolean check2 = true;
                while(check2)
                {
                	System.out.println("feedback");
                	if((sIn = in.readLine()) != null)
                	{
                		System.out.println("echo: " + sIn);
                	}
                	else{ 
                		check2 = false;
                		break;
                	}
                }*/
                
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        } 
    }
}