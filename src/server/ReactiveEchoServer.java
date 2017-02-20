package server;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

/**
 * Created by vishwasourabh.sahay on 13/02/17.
 */
 class ReactiveEchoServer implements Runnable {

    private final Selector selector;
    private final ServerSocketChannel serverSocketChannel;

    ReactiveEchoServer(int port) throws IOException
    {
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(1023));
        serverSocketChannel.configureBlocking(false);

        SelectionKey selectionKey =serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);


    }

    public void run()
    {
       while(true)
       {

           try
           {
               selector.select();
               Iterator iterator = selector.selectedKeys().iterator();
               while(iterator.hasNext())
               {
                   SelectionKey key = (SelectionKey)(iterator.next());
                   iterator.remove();
                   Runnable r = (Runnable) key.attachment();
                   if(r!=null)
                   {
                       r.run();
                   }
               }
           }
           catch(Exception exception)
           {

           }

       }
    }
}
