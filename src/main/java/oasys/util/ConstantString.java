package oasys.util;

import java.awt.*;

public interface ConstantString {
   Color COLOR_BLUE = new Color(0,162,232);
   Color COLOR_WHITE = new Color(255,255,255);
   Color COLOR_DARK_GRAY = new Color(64,64,64);
   // DATABASE CONNECTION
   String URL = "jdbc:mysql://localhost:3306/student_management";
   String USER = "root";
   String PASS = "09212440633a";
   // IMAGE PATH
   String MAIL_RED = "src/main/resources/images/mail_red.png";
   String MAIL_GREEN = "src/main/resources/images/mail_green.png";
   String LOGOUT_BLUE = "src/main/resources/images/logout_blue.png";
   String LOGOUT_RED = "src/main/resources/images/logout_red.png";
   String POST_GREEN = "src/main/resources/images/new_post_green.png";
   String POST_RED = "src/main/resources/images/new_post_red.png";
   String DELETE_WHITE = "src/main/resources/images/delete_white.png";
   String DELETE_BLUE = "src/main/resources/images/delete_blue.png";
}
