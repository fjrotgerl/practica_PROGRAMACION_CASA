import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by pnegre on 29/05/17.
 */
public class porva {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String st = "ABCDEABCABCABCABC";
        String s1 = "ABC";
        String s2 = "X";
        int cont = 0;

        for (int i = 0; i < st.length(); i++) {
            if(st.charAt(i) == s1.charAt(cont)) {
                for (int j = 0; j < s1.length(); j++) {
                    if (st.charAt(i+cont) == s1.charAt(cont)) {
                        cont++;
                        if (cont == s1.length()) {
                            sb.append(s2);
                            i = i+cont;
                        }
                    }
                }
            }
            cont = 0;
            sb.append(st.charAt(i));
        }
        System.out.println(sb.toString());
    }
}

