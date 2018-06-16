package Network;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
public abstract class AbstractNetwork{
    protected Socket socket;
    private String IP;
    private static final int port = 810;
    protected InputStream is;
    protected OutputStream os;
    protected DataInputStream dis;
    protected DataOutputStream dos;
    public abstract void in_message(String message);
    public abstract void session();
    public abstract void IOError(IOException e);
    public void Connect(){
        try{
            socket = new Socket(IP,port);
            if(socket != null){
                setStream();
                session();
            }
        }catch(IOException e){
            IOError(e);
        }
    }
    protected void send_message(String message){
        try {
            dos.writeUTF(message);
        } catch (IOException e) {
            IOError(e);
        }
    }
    private void setStream(){
        try{
            is = socket.getInputStream();
            dis = new DataInputStream(is);
            os = socket.getOutputStream();
            dos = new DataOutputStream(os);
        }catch (IOException e){
            IOError(e);
        }
    }
    protected void setIP(String ip){
        this.IP = ip;
    }

}
