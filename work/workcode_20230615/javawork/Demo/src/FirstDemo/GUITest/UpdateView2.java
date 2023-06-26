package FirstDemo.GUITest;

import FirstDemo.bean.Salesperson;
import FirstDemo.dao.SalepersonDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @BelongsProject: javawork
 * @BelongsPackage: FirstDemo.GUITest
 * @FileName: UpdateView
 * @Author: wude
 * @Date: 2023/6/11-12:52
 * @Version: 1.0
 * @Description:
 */

public class UpdateView2 extends JFrame {

    private JPanel contentPane;
    private JTextField idText;
    private JTextField nameText;
    private JTextField ageText;
    private JTextField worktypeText;

    private SalepersonDAO goodsDAO = new SalepersonDAO();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UpdateView2 frame = new UpdateView2(1);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public UpdateView2(final int sid) throws Exception {
        setTitle("职员信息编辑");
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

            String sid1 = idText.getText();
            String name = nameText.getText();
            String age = ageText.getText();
            String major = worktypeText.getText();

            if (sid1 == null || "".equals(sid1)) {
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
            goods.setIdcard(Integer.parseInt(sid1));
            goods.setSalespersonname(name);
            goods.setAge(Integer.parseInt(age));
            goods.setWorkertype(major);

            goodsDAO.update(goods);
            /*
            *这有个bug
            * update时候如果改不存在的id则会变为添加记录，原本选中的记录不会删除
            * 解决思路：可以考虑在选中改变对象行的时候就删去，再add*/
            dispose();
            JOptionPane.showMessageDialog(contentPane, "修改成功，点击查询刷新数据!");

        });
        saveBtn.setBounds(151, 300, 74, 23);
        contentPane.add(saveBtn);

        //取消
        JButton cancelBtn = new JButton("取消");
        cancelBtn.addActionListener(e -> dispose());
        cancelBtn.setBounds(237, 300, 74, 23);
        contentPane.add(cancelBtn);

        //数据回显
        Salesperson goods = SalepersonDAO.selectByid(sid);
        idText.setText(String.valueOf(goods.getIdcard()));
        nameText.setText(goods.getSalespersonname());
        ageText.setText(String.valueOf(goods.getAge()));
        worktypeText.setText(goods.getWorkertype());
    }

}
