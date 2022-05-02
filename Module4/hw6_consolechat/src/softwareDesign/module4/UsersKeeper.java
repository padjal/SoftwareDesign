package softwareDesign.module4;

import java.util.ArrayList;
import java.util.List;

public class UsersKeeper {
    private static List<String> users;

    public static boolean userExists(String user){
        if(users == null){
            users = new ArrayList<>();
        }

        if(users.contains(user)){
            return true;
        }else{
            users.add(user);
            return false;
        }
    }
}
