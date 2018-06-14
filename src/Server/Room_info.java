package Server;

import java.util.ArrayList;

public class Room_info {
    private String Room_name = "";
    private ArrayList <User_info> Room_User_vc = new ArrayList<>();
    private String Room_Password = "";

    Room_info(String str, User_info u, String Password) {
        this.Room_name = str;
        this.Room_Password = Password;
    }

    public void BroadCast_Room(String str) {
        for (User_info u:Room_User_vc) {
            u.send_message(str);
        }
    }
    public String getRoom_name(){
        return this.Room_name;
    }

    public void Add_User(User_info u, String room_Password) {
        if(room_Password.equals(this.Room_Password)) {
            this.Room_User_vc.add(u);
        }
    }
}

