# Assignment – Multithreaded Client Server App
----------
## How to run the application:

1. Go to App.main
2. Set the desired listening port at <i>Main.serverPort</i>.
3. Choose the servermode at <i>Main.singleThreadMode</i>:
   * <i>true</i>: Single-Threaded server
   * <i>false</i>: Multi-Threaded server
4. Run <i>App.main(args)</i>.
5. Send HTTP GET requests on localhost:port



## Single-Threaded and Multi-Threaded timings

* Single-Threaded:
  * Time: 20.01s
  * Status: 200 OK
  * Size: 157B
* Multi-Threaded:
  * Time: 10.01s
  * Status: 200 OK
  * Size: 157B

We noticed that when a client sends a HTTP GET request, there are two data transmissions from the client to the server. The first message is empty, because this is the initial step of the three-way-handshake with TCP. The second message is the actual HTTP GET request.<br>

When running the application in single-threaded mode, Postman uses double the amount of time to receive the packets, compared to multi-threaded mode. This is because the packets contains two messages, and in single-threaded mode you have to read one packet at a time. Our thread.sleep function makes the packet readings take 10 seconds per message. In multi-threaded mode, the packets are read in parallell, reducing the amount of time in half. From approximately 20 seconds for both messages, to 10 seconds in total.
