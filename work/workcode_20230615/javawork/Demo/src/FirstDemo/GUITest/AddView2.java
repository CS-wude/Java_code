package FirstDemo.GUITest;

import FirstDemo.bean.Salesperson;
import FirstDemo.dao.SalepersonDAO;
/*import com.mysql.jdbc.ExceptionInterceptor;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;*/

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @BelongsProject: javawork
 * @BelongsPackage: FirstDemo.GUITest
 * @FileName: AddView
 * @Author: wude
 * @Date: 2023/6/11-12:53
 * @Version: 1.0
 * @Description:
 */

public class AddView2 extends JFrame {

    private JPanel contentPane;
    private JTextField idText;
    private JTextField nameText;
    private JTextField ageText;
    private JTextField worktypeText;

    private SalepersonDAO goodsDAO = new SalepersonDAO();

    //private com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex1 = new com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AddView2 frame = new AddView2();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public AddView2() {
        setTitle("职员添加");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 443, 450);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("工号：");
        lblNewLabel.setBounds(112, 50, 43, 15);
        contentPane.add(lblNewLabel);

        idText = new JTextField();
        idText.setBounds(151, 47, 160, 21);
        contentPane.add(idText);
        idText.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("姓名：");
        lblNewLabel_1.setBounds(112, 93, 43, 15);
        contentPane.add(lblNewLabel_1);

        nameText = new JTextField();
        nameText.setBounds(151, 90, 160, 21);
        contentPane.add(nameText);
        nameText.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("年龄：");
        lblNewLabel_2.setBounds(112, 134, 43, 15);
        contentPane.add(lblNewLabel_2);

        ageText = new JTextField();
        ageText.setBounds(151, 130, 160, 21);
        contentPane.add(ageText);
        ageText.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("职务：");
        lblNewLabel_3.setBounds(112, 177, 43, 15);
        contentPane.add(lblNewLabel_3);

        worktypeText = new JTextField();
        worktypeText.setBounds(151, 177, 160, 21);
        contentPane.add(worktypeText);
        worktypeText.setColumns(10);

        //保存
        JButton saveBtn = new JButton("保存");
        saveBtn.addActionListener(e -> {

            String sid = idText.getText();
            String name = nameText.getText();
            String age = ageText.getText();
            String major = worktypeText.getText();

            if (sid == null || "".equals(sid)) {
                JOptionPane.showMessageDialog(contentPane, "请输入工号", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (name == null || "".equals(name)) {
                JOptionPane.showMessageDialog(contentPane, "请输入姓名", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (age == null || "".equals(age)) {
                JOptionPane.showMessageDialog(contentPane, "请输入年龄", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (major == null || "".equals(major)) {
                JOptionPane.showMessageDialog(contentPane, "请输入职务", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Salesperson goods = new Salesperson();
            goods.setIdcard(Integer.parseInt(sid));
            goods.setSalespersonname(name);
            goods.setAge(Integer.parseInt(age));
            goods.setWorkertype(major);

            try {
                goodsDAO.add(goods);
                dispose();
                JOptionPane.showMessageDialog(contentPane, "添加成功，点击查询可刷新!");

            }catch (Exception error){
                /*这里没用，添加重复id会爆红，不会添加成功，并且一直说添加成功，不catch工号存在*/
                JOptionPane.showMessageDialog(contentPane, "该工号已存在", "系统提示", JOptionPane.WARNING_MESSAGE);

                //这里有个问题就是已经存在的id不能加，不然会爆红，这里要改一下
                //爆红语句Duplicate entry '数字' for key 'PRIMARY'
                //可以删除数据再添加来解决，但这样太强制了，而且这个只用来添加，要改可以去updata
                //所以可以考虑弄一个询问窗口告诉我们是否重复了id，并且告诉我们空闲小id号
                //这里的功能就是用来解决id重复添加，不过这个弹窗需要改一下才能用

                //想改变dao中的add来catch Exception,但这个异常始终不能抛出Exception
                //只会com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException
                //而这个异常我又无法导入，所以这个是个缺陷
            }


        });
        saveBtn.setBounds(151, 300, 74, 23);
        contentPane.add(saveBtn);

        //取消
        JButton cancelBtn = new JButton("取消");
        cancelBtn.addActionListener(e -> dispose());
        cancelBtn.setBounds(237, 300, 74, 23);
        contentPane.add(cancelBtn);
    }

}
