package FirstDemo.GUITest;

import FirstDemo.dao.UserDAO;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * @BelongsProject: javawork
 * @BelongsPackage: FirstDemo.GUITest
 * @FileName: LoginView
 * @Author: wude
 * @Date: 2023/6/11-10:48
 * @Version: 1.0
 * @Description:
 */

public class LoginView extends JFrame {

    private JPanel contentPane;
    private JTextField usernameText;
    //private JTextField passwordText;
    private JPasswordField passwordText;
    private UserDAO userservice = new UserDAO();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LoginView frame = new LoginView();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public LoginView() {
        setTitle("欢迎登录");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 380, 250);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("账号：");
        lblNewLabel.setBounds(92, 50, 50, 15);
        contentPane.add(lblNewLabel);

        usernameText = new JTextField();
        usernameText.setBounds(131, 47, 160, 21);
        contentPane.add(usernameText);
        usernameText.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("密码：");
        lblNewLabel_1.setBounds(92, 93, 43, 15);
        contentPane.add(lblNewLabel_1);

        //passwordText = new JTextField();
        passwordText = new JPasswordField();
        passwordText.setBounds(131, 90, 160, 21);
        contentPane.add(passwordText);
        passwordText.setColumns(10);


        //注册
        JButton registerBtn = new JButton("注册");
        registerBtn.addActionListener(e -> {

            RegisterView view = new RegisterView();
            view.setVisible(true);
            dispose();

        });
        registerBtn.setBounds(210, 150, 74, 23);
        contentPane.add(registerBtn);



        //登录
        JButton LoginBtn = new JButton("登录");
        LoginBtn.addActionListener(e -> {
            try {
                stulogin();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        LoginBtn.setBounds(115, 150, 74, 23);
        contentPane.add(LoginBtn);



    }


    public void stulogin() throws Exception{
        if (userservice.login(usernameText.getText(), passwordText.getText())) {
            JOptionPane.showMessageDialog(null, "登录成功！", "提示消息", JOptionPane.WARNING_MESSAGE);
            //关闭当前界面
            dispose();
            UserListView view = new UserListView();
            view.setVisible(true);
            /*
            一开始想将销售记录表和销售人员表嵌入货物表上，但因为非静态不能调用静态的bug失败
            后来发现在本类下设定一个静态方法，然后使用构造方法和可视化，再货物表中调用就能解决这个问题
            这个和登录的stulogin方法是一样的原理
            SalespersonView pview = new SalespersonView();
            pview.setVisible(true);
            GoodsaleView gview = new GoodsaleView();
            gview.setVisible(true);*/
        } else if (usernameText.getText().isEmpty() && passwordText.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "请输入用户名和密码！", "提示消息", JOptionPane.WARNING_MESSAGE);
        } else if (usernameText.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "请输入用户名！", "提示消息", JOptionPane.WARNING_MESSAGE);
        } else if (passwordText.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "请输入密码！", "提示消息", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "用户名或者密码错误！\n请重新输入", "提示消息", JOptionPane.ERROR_MESSAGE);
            usernameText.setText("");
            passwordText.setText("");
        }
    }

}
