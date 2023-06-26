package FirstDemo.GUITest;

import FirstDemo.bean.Goodsale;
import FirstDemo.dao.GoodsDAO;
import FirstDemo.dao.GoodsaleDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @BelongsProject: javawork
 * @BelongsPackage: FirstDemo.GUITest
 * @FileName: AddView
 * @Author: wude
 * @Date: 2023/6/11-12:53
 * @Version: 1.0
 * @Description:
 */

public class AddView3 extends JFrame {

    private JPanel contentPane;
    private JTextField goodsidText;
    private JTextField goodsnameText;
    private JTextField salepersonidText;
    private JTextField salepersonnameText;
    private JTextField numberText;
    //private JTextField loveSubjText;

    GoodsDAO goodsDAO1 = new GoodsDAO();

    private GoodsaleDAO goodsDAO = new GoodsaleDAO();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AddView3 frame = new AddView3();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    /**
     * Create the frame.
     */
    public AddView3() {
        setTitle("记录添加");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 443, 450);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("货物编号：");
        lblNewLabel.setBounds(90, 50, 70, 15);
        contentPane.add(lblNewLabel);

        goodsidText = new JTextField();
        goodsidText.setBounds(151, 47, 160, 21);
        contentPane.add(goodsidText);
        goodsidText.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("货物名称：");
        lblNewLabel_1.setBounds(90, 93, 70, 15);
        contentPane.add(lblNewLabel_1);

        goodsnameText = new JTextField();
        goodsnameText.setBounds(151, 90, 160, 21);
        contentPane.add(goodsnameText);
        goodsnameText.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("职员工号：");
        lblNewLabel_2.setBounds(90, 134, 70, 15);
        contentPane.add(lblNewLabel_2);

        salepersonidText = new JTextField();
        salepersonidText.setBounds(151, 130, 160, 21);
        contentPane.add(salepersonidText);
        salepersonidText.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("职员姓名：");
        lblNewLabel_3.setBounds(90, 177, 70, 15);
        contentPane.add(lblNewLabel_3);

        salepersonnameText = new JTextField();
        salepersonnameText.setBounds(151, 177, 160, 21);
        contentPane.add(salepersonnameText);
        salepersonnameText.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("销售数量：");
        lblNewLabel_4.setBounds(90, 220, 70, 15);
        contentPane.add(lblNewLabel_4);

        numberText = new JTextField();
        numberText.setBounds(151, 220, 160, 21);
        contentPane.add(numberText);
        numberText.setColumns(10);

        /*JLabel lblNewLabel_5 = new JLabel("结算支付：");
        lblNewLabel_5.setBounds(90, 263, 70, 15);
        contentPane.add(lblNewLabel_5);

        loveSubjText = new JTextField();
        loveSubjText.setBounds(151, 263, 160, 21);
        contentPane.add(loveSubjText);
        loveSubjText.setColumns(10);*/

        //保存
        JButton saveBtn = new JButton("保存");
        saveBtn.addActionListener(e -> {

            String sid = goodsidText.getText();
            String name = goodsnameText.getText();
            String age = salepersonidText.getText();
            String major = salepersonnameText.getText();
            String grade = numberText.getText();
            //String loveSubj = loveSubjText.getText();
            if (sid == null || "".equals(sid)) {
                JOptionPane.showMessageDialog(contentPane, "请输入货物编号", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (name == null || "".equals(name)) {
                JOptionPane.showMessageDialog(contentPane, "请输入货物名称", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (age == null || "".equals(age)) {
                JOptionPane.showMessageDialog(contentPane, "请输入职员工号", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (major == null || "".equals(major)) {
                JOptionPane.showMessageDialog(contentPane, "请输入职员姓名", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (grade == null || "".equals(grade)) {
                JOptionPane.showMessageDialog(contentPane, "请输入销售数量", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            /*if (loveSubj == null || "".equals(loveSubj)) {
                JOptionPane.showMessageDialog(contentPane, "请输入结算支付", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }*/
            Goodsale goods = new Goodsale();

            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String format = dateFormat.format(date);

            goods.setId(format);
            /*这里流水用当前时间转字符串输入*/

            /*
            * 也是定义了一定会不同的主键值，所以这里不会有id主键重复而不能添加的问题
            * 因为每一条数据都是不同的，但其他类的添加方法需要设定一个id重复的提示窗口*/

            goods.setGoodid(Integer.parseInt(sid));
            goods.setGoodname(name);
            goods.setSalespersonid(Integer.parseInt(age));
            goods.setSalespersonname(major);
            goods.setSalenumber(Integer.parseInt(grade));

            int m = goodsDAO1.selectByid(Integer.parseInt(sid)).getPrice();
            int t = Integer.parseInt(grade);
            //这里设置结算自动获取
            String k = String.valueOf(m * t);

            goods.setMoney(Integer.parseInt(k));
            try {
                goodsDAO.add(goods);
                dispose();
                JOptionPane.showMessageDialog(contentPane, "添加成功，点击查询可刷新!");

            }catch (Exception error){
                /*流水号的原因，这个记录存在是不可能的*/
                JOptionPane.showMessageDialog(contentPane, "该记录已存在", "系统提示", JOptionPane.WARNING_MESSAGE);
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
