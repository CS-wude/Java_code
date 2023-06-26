package FirstDemo.GUITest;

import FirstDemo.bean.Goodsale;
import FirstDemo.dao.GoodsaleDAO;

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

public class UpdateView3 extends JFrame {

    private JPanel contentPane;
    private JTextField idText;
    private JTextField gidText;
    private JTextField gnText;
    private JTextField spidText;
    private JTextField spnText;
    private JTextField nbText;
    private JTextField mnText;

    private GoodsaleDAO goodsDAO = new GoodsaleDAO();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UpdateView3 frame = new UpdateView3("000000");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public UpdateView3(final String sid) throws Exception {
        setTitle("流水记录编辑");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 443, 485);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("流水号：");
        lblNewLabel.setBounds(102, 50, 70, 15);
        contentPane.add(lblNewLabel);

        idText = new JTextField();
        idText.setBounds(151, 47, 160, 21);
        contentPane.add(idText);
        idText.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("货物编号：");
        lblNewLabel_1.setBounds(90, 93, 70, 15);
        contentPane.add(lblNewLabel_1);

        gidText = new JTextField();
        gidText.setBounds(151, 90, 160, 21);
        contentPane.add(gidText);
        gidText.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("货物名称：");
        lblNewLabel_2.setBounds(90, 134, 70, 15);
        contentPane.add(lblNewLabel_2);

        gnText = new JTextField();
        gnText.setBounds(151, 130, 160, 21);
        contentPane.add(gnText);
        gnText.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("职员工号：");
        lblNewLabel_3.setBounds(90, 177, 70, 15);
        contentPane.add(lblNewLabel_3);
        spidText = new JTextField();

        spidText.setBounds(151, 177, 160, 21);
        contentPane.add(spidText);
        spidText.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("职员姓名：");
        lblNewLabel_4.setBounds(90, 220, 70, 15);
        contentPane.add(lblNewLabel_4);

        spnText = new JTextField();
        spnText.setBounds(151, 220, 160, 21);
        contentPane.add(spnText);
        spnText.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("销售数量：");
        lblNewLabel_5.setBounds(90, 263, 70, 15);
        contentPane.add(lblNewLabel_5);

        nbText = new JTextField();
        nbText.setBounds(151, 263, 160, 21);
        contentPane.add(nbText);
        nbText.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("结算支付：");
        lblNewLabel_6.setBounds(90, 306, 70, 15);
        contentPane.add(lblNewLabel_6);

        mnText = new JTextField();
        mnText.setBounds(151, 306, 160, 21);
        contentPane.add(mnText);
        mnText.setColumns(10);

        //保存
        JButton saveBtn = new JButton("保存");
        saveBtn.addActionListener(e -> {

            String tid = idText.getText();
            String tgid = gidText.getText();
            String tgn = gnText.getText();
            String tspid = spidText.getText();
            String tspn = spnText.getText();
            String nb = nbText.getText();
            String mn = mnText.getText();
            if (tid == null || "".equals(tid)) {
                JOptionPane.showMessageDialog(contentPane, "请输入流水号", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (tgid == null || "".equals(tgid)) {
                JOptionPane.showMessageDialog(contentPane, "请输入货物编号", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (tgn == null || "".equals(tgn)) {
                JOptionPane.showMessageDialog(contentPane, "请输入货物名称", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (tspid == null || "".equals(tspid)) {
                JOptionPane.showMessageDialog(contentPane, "请输入职员工号", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (tspn == null || "".equals(tspn)) {
                JOptionPane.showMessageDialog(contentPane, "请输入职员姓名", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (nb == null || "".equals(nb)) {
                JOptionPane.showMessageDialog(contentPane, "请输入销售数量", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (mn == null || "".equals(mn)) {
                JOptionPane.showMessageDialog(contentPane, "请输入结算支付", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Goodsale goods = new Goodsale();
            goods.setId(tid);
            goods.setGoodid(Integer.parseInt(tgid));
            goods.setGoodname(tgn);
            goods.setSalespersonid(Integer.parseInt(tspid));
            goods.setSalespersonname(tspn);
            goods.setSalenumber(Integer.parseInt(nb));
            goods.setMoney(Integer.parseInt(mn));
            goodsDAO.update(goods);
            dispose();
            JOptionPane.showMessageDialog(contentPane, "修改成功，点击查询刷新数据!");

        });
        saveBtn.setBounds(151, 343, 74, 23);
        contentPane.add(saveBtn);

        //取消
        JButton cancelBtn = new JButton("取消");
        cancelBtn.addActionListener(e -> dispose());
        cancelBtn.setBounds(237, 343, 74, 23);
        contentPane.add(cancelBtn);

        //数据回显
        Goodsale goods = GoodsaleDAO.selectByid(sid);
        idText.setText(goods.getId());
        gidText.setText(String.valueOf(goods.getGoodid()));
        gnText.setText(goods.getGoodname());
        spidText.setText(String.valueOf(goods.getSalespersonid()));
        spnText.setText(goods.getSalespersonname());
        nbText.setText(String.valueOf(goods.getSalenumber()));
        mnText.setText(String.valueOf(goods.getMoney()));
    }

}
