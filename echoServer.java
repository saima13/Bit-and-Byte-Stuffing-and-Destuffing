import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class echoServer {

    public static void main(String[] args) throws Exception {
    	SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
		String input = args.length == 0? "12/01/2016" : args[0];
		Date date = new Date();
		date=ft.parse(input);
		
		
		System.out.println("**************echoServer.java**********************");
		System.out.println("Bit and Byte Stuffing/Unstuffing Project");
		System.out.println("Chris Robbins, Saima, Nacool, Nick");
		System.out.println("Team 7");
		System.out.println("CS633");
		System.out.println(date);
		System.out.println("Program Notes: This file must be started before echoClient.java");
		System.out.println("************************************");
		System.out.println();
        // create socket
        int port = 4444;
        ServerSocket serverSocket = new ServerSocket(port);
        System.err.println("Started server on port " + port);

        // repeatedly wait for connections, and process
        while (true) {

            // a "blocking" call which waits until a connection is requested
            Socket clientSocket = serverSocket.accept();
            System.err.println("Accepted connection from client");

            // open up IO streams
            
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            

            // waits for data and reads it in until connection dies
            // readLine() blocks until the server receives a new line from client
            while(true)
            {
            	System.out.println();
		            String fromClient="";
		            int count = 0;
		            String data = "";
		            int select = 0;
		            String flag = "";
		            boolean check = true;
		            while(check){
		            	fromClient = in.readLine();
		            	//System.out.println(fromClient+" count: " + count);
			            if(!fromClient.equals(""))
			            {
			                	switch(count)
			                	{
			                		case 0: data = fromClient;
			                				count++;
			                				break;
			                		case 1: select = Integer.parseInt(fromClient);
			                				/*if(select == 2)
			                				{
			                					count = 0;
			                					check = false;
			                				}*/
			                				count++;
			                				break;
			                		case 2: flag = fromClient;
			                				count = 0;
			                				check = false;
			                				break;
			                	}
			                
			            }
		            fromClient = "";
		        }
		            
		        	
		            	
		            	switch(select)
		                {
		                            case 1: //System.out.print("\nEnter the Flag Stream: ");                                   
		                                        //flag=in.readLine();
		                                        System.out.println("********************************************");
		                                        System.out.print("Data received from client: ");
		                                        System.out.println(ByteStuffing.Byte(data,flag));
		                                        System.out.print("Unstuffed Data from client: ");
		                                        System.out.println(ByteStuffing.ByteUnstuff(ByteStuffing.Byte(data,flag),flag));
		                                        //System.out.print("\nThe Frame after processing: "+ByteStuffing.Byte(data,flag));
		                                        break;
		                            case 2: //flag="01111110";
		                            		System.out.println("********************************************");
		                            		System.out.print("Data received from client: ");
		                            		System.out.println(ByteStuffing.Bit(data,flag));
		                            		System.out.print("Unstuffed Data from client: ");
		                            		System.out.println(ByteStuffing.BitUnstuff(ByteStuffing.Bit(data,flag),flag));
		                                        //System.out.print("\nThe Flag Stream is: "+flag);
		                                       //System.out.print("\n\nThe Frame after processing: "+ByteStuffing.Bit(data,flag));
		                                        break;
		                            case 8: check = true;
		                            		break;
		                            case 9: break;
		                }
		            	/*System.out.println(data);
		            	if(data.equals("close")){
		            		System.out.println("hello");
		            		break;
		            	}
		            	out.println("Echo Back:" + data);
		
		            // close IO streams, then socket
		            if(check){
		            System.err.println("Closing connection with client");
		            out.close();
		            in.close();
		            clientSocket.close();
		            }*/
            }
        }
        
    }
}