
import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;
import java.sql.*;
public class Server {

    private int port = 3456;
    private final ByteBuffer buffer = ByteBuffer.allocate(10);

    public Server() throws IOException {
        go();
    }

    public void go() throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);

        ServerSocket ss = ssc.socket();
        InetSocketAddress isa = new InetSocketAddress("localhost", port);
        ss.bind(isa);

        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("Listening on port " + port);

        while (true) {
            int num = selector.select();
            if (num == 0) {
                continue;
            }
            Set keys = selector.selectedKeys();
            Iterator it = keys.iterator();
            while (it.hasNext()) {
                SelectionKey key = (SelectionKey) it.next();
                if ((key.readyOps() & SelectionKey.OP_ACCEPT)
                        == SelectionKey.OP_ACCEPT) {

                    System.out.println("acc");
                    Socket s = ss.accept();
                    System.out.println("Got connection from " + s);

                    SocketChannel sc = s.getChannel();
                    sc.configureBlocking(false);

                    sc.register(selector, SelectionKey.OP_READ);

                } else if ((key.readyOps() & SelectionKey.OP_READ)
                        == SelectionKey.OP_READ) {

                    SocketChannel sc = null;

                    try {
                        sc = (SocketChannel) key.channel();
                        processInput(sc);

                    } catch (IOException ie) {
                        // On exception, remove this channel from the selector
                        key.cancel();
                        try {
                            sc.close();
                        } catch (IOException ie2) {
                            System.out.println(ie2);
                        }
                        System.out.println("Closed " + sc);
                    }
                }
            }

            keys.clear();
        }

    }

    private boolean processInput(SocketChannel sc) throws IOException {
        buffer.clear();
        sc.read(buffer);
        buffer.flip();

        // If no data, close the connection
        if (buffer.limit() == 0) {
            return false;
        }

        for (int i = 0; i < buffer.limit(); ++i) {
            byte b = buffer.get(i);
            b = (byte) (b + 1);
            buffer.put(i, b);
        }

        sc.write(buffer);
        System.out.println("Processed " + buffer.limit() + " from " + sc);
        return true;
    }

    public static void main(String args[]) throws Exception {
        new Server();
    }
}
