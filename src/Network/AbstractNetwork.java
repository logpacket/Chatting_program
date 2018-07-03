package Network;

import java.io.*;
import java.net.Socket;

public abstract class AbstractNetwork{
    protected Socket socket;
    public String IP;
    private static final int port = 810;
    protected InputStream is;
    protected OutputStream os;
    protected DataInputStream dis;
    protected DataOutputStream dos;
    public abstract void in_message(String message);
    public abstract void IOError(IOException e);
    protected void Connect(){
        try{
            socket = new Socket(IP,port);
            setStream();
        }catch(IOException e){
            IOError(e);
        }
    }
    public void send_message(String message){
        try {
            dos.writeUTF(message);
        } catch (IOException e) {
            IOError(e);
        }
    }
    protected void setStream(){
        try{
            is = socket.getInputStream();
            dis = new DataInputStream(is);
            os = socket.getOutputStream();
            dos = new DataOutputStream(os);
        }catch (IOException e){
            IOError(e);
        }
    }
}
