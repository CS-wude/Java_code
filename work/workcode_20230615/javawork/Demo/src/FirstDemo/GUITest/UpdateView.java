package FirstDemo.GUITest;

import FirstDemo.bean.Goods;
import FirstDemo.dao.GoodsDAO;
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
 * @FileName: UpdateView
 * @Author: wude
 * @Date: 2023/6/11-12:52
 * @Version: 1.0
 * @Description:
 */

public class UpdateView extends JFrame {

    private JPanel contentPane;
    private JTextField idText;
    private JTextField goodsnameText;
    private JTextField priceText;
    private JTextField numberText;

    private GoodsDAO goodsDAO = new GoodsDAO();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UpdateView frame = new UpdateView(1);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public UpdateView(final int sid) throws Exception {
        setTitle("货物编辑");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 443, 450);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("编号：");
        lblNewLabel.setBounds(112, 50, 43, 15);
        contentPane.add(lblNewLabel);

        idText = new JTextField();
        idText.setBounds(151, 47, 160, 21);
        contentPane.add(idText);
        idText.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("名称：");
        lblNewLabel_1.setBounds(112, 93, 43, 15);
        contentPane.add(lblNewLabel_1);

        goodsnameText = new JTextField();
        goodsnameText.setBounds(151, 90, 160, 21);
        contentPane.add(goodsnameText);
        goodsnameText.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("价格：");
        lblNewLabel_2.setBounds(112, 134, 43, 15);
        contentPane.add(lblNewLabel_2);

        priceText = new JTextField();
        priceText.setBounds(151, 130, 160, 21);
        contentPane.add(priceText);
        priceText.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("剩余：");
        lblNewLabel_3.setBounds(112, 177, 43, 15);
        contentPane.add(lblNewLabel_3);
        numberText = new JTextField();

        numberText.setBounds(151, 177, 160, 21);
        contentPane.add(numberText);
        numberText.setColumns(10);

        //保存
        JButton saveBtn = new JButton("保存");
        saveBtn.addActionListener(e -> {

            String sid1 = idText.getText();
            String name = goodsnameText.getText();
            String age = priceText.getText();
            String major = numberText.getText();

            if (sid1 == null || "".equals(sid1)) {
                JOptionPane.showMessageDialog(contentPane, "请输入编号", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (name == null || "".equals(name)) {
                JOptionPane.showMessageDialog(contentPane, "请输入货物名称", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (age == null || "".equals(age)) {
                JOptionPane.showMessageDialog(contentPane, "请输入价格", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (major == null || "".equals(major)) {
                JOptionPane.showMessageDialog(contentPane, "请输入剩余数量", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Goods goods = new Goods();
            goods.setId(Integer.parseInt(sid1));
            goods.setGoodname(name);
            goods.setPrice(Integer.parseInt(age));
            goods.setNumber(Integer.parseInt(major));

            goodsDAO.update(goods);
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
        Goods goods = GoodsDAO.selectByid(sid);
        idText.setText(String.valueOf(goods.getId()));
        goodsnameText.setText(goods.getGoodname());
        priceText.setText(String.valueOf(goods.getPrice()));
        numberText.setText(String.valueOf(goods.getNumber()));

    }
}
