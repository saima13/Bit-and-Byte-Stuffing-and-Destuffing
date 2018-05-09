In order to run team 7's Bit/Byte stuffing/unstuffing code follow the following instructions.

(The following assumes the user is able to run java programs on their computer. To set up Java see the tutorial at http://www.oracle.com/technetwork/topics/newtojava/learn-141096.html)

1) Open two command prompt windows (terminal for mac) and navigate to the directory where echoServer.java echoClient.java ByteStuffing.java are saved.
2) Compile echoServer.java echoClient.java ByteStuffing.java in the same directory.
	-- javac echoServer.java echoClient.java ByteStuffing.java
3) Run echoServer.java in the first command prompt window (terminal for mac).
	-- java echoServer
4) Run echoClient.java in the second command prompt window (terminal for mac).
	-- java echoClient
5) In the second window (echoClient.java) enter the data you wish to send to the server.
6) In the second window (echoClient.java) choose either Byte Stuffing or Bit Stuffing.
7) If you chose Byte Stuffing enter a flag to append to the front and back of the packet. If you chose Bit Stuffing move to step 7.
8) The first window should recieve your data and unstuff it.