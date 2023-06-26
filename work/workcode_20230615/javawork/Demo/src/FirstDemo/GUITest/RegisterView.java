package FirstDemo.GUITest;

import FirstDemo.bean.User;
import FirstDemo.dao.UserDAO;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * @BelongsProject: javawork
 * @BelongsPackage: FirstDemo.GUITest
 * @FileName: RegisterView
 * @Author: wude
 * @Date: 2023/6/11-10:52
 * @Version: 1.0
 * @Description:
 */

public class RegisterView extends JFrame {

    private JPanel contentPane;
    private JTextField usernameText;
    private JTextField passwordText;
    private UserDAO userservice = new UserDAO();


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                RegisterView frame = new RegisterView();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public RegisterView(){
        setTitle("欢迎注册");
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

        passwordText = new JTextField();
        passwordText.setBounds(131, 90, 160, 21);
        contentPane.add(passwordText);
        passwordText.setColumns(10);


        //注册
        JButton registerBtn = new JButton("注册");
        registerBtn.addActionListener(e -> {

            String username = usernameText.getText();
            String password = passwordText.getText();

            if (username == null || "".equals(username)) {
                JOptionPane.showMessageDialog(contentPane, "请输入账号", "系统提示", JOptionPane.WARNING_MESSAGE);
            } else if (password == null || "".equals(password)) { JOptionPane.showMessageDialog(contentPane, "请输入密码", "系统提示", JOptionPane.WARNING_MESSAGE);

            } else try {
                if (userservice.check(username) == true) {
                        if (username.isEmpty() && password.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "请输入用户名和密码！", "提示消息", JOptionPane.WARNING_MESSAGE);
                        } else {
                            User user = new User();
                            user.setUsername(username);
                            user.setPassword(password);
                            userservice.regiser(user);
                            JOptionPane.showMessageDialog(null, "注册成功！", "提示消息", JOptionPane.WARNING_MESSAGE);
                            LoginView view = new LoginView();
                            view.setVisible(true);
                            dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "用户名已存在", "系统提示", JOptionPane.WARNING_MESSAGE);
                        usernameText.setText("");
                        passwordText.setText("");
                    }
            } catch (Exception e1) {
                e1.printStackTrace();
            }


        });
        registerBtn.setBounds(115, 150, 74, 23);
        contentPane.add(registerBtn);

        //这里会检测用户名是否有重复，但发现因为字段默认长度的原因，导致用户名无法对比
        //比如123注册了，但check的时候依旧是显示不重复，应该有个东西可以让字段显示真实长度
        //这样才能解决check
        //这个是必须要解决的，因为不解决这样，还会导致验证登录有问题
        //这里的问题通过判断相等的equal方法解决了


        //重置
        JButton LoginBtn = new JButton("重置");
        LoginBtn.addActionListener(e -> {
            usernameText.setText("");
            passwordText.setText("");
        });
        LoginBtn.setBounds(210, 150, 74, 23);
        contentPane.add(LoginBtn);


        //返回
        JButton returnBtn = new JButton("返回");
        returnBtn.addActionListener(e -> {
            LoginView view = new LoginView();
            view.setVisible(true);
            dispose();
        });
        returnBtn.setBounds(160, 180, 74, 23);
        contentPane.add(returnBtn);


    }


}
