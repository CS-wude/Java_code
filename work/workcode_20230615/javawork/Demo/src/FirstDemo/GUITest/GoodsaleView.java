package FirstDemo.GUITest;

import FirstDemo.bean.Goodsale;
import FirstDemo.dao.GoodsaleDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * @BelongsProject: javawork
 * @BelongsPackage: FirstDemo.GUITest
 * @FileName: UserListView
 * @Author: wude
 * @Date: 2023/6/11-12:50
 * @Version: 1.0
 * @Description:由于设置了货物编号和职员工号两个外键，所以这个记录输入的时候必须依赖于其他两个表的记录，
 * 就是会有一个异常com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException
 * 而这个异常我没办法抛出，所以给不出提示，他的插入弹窗也依旧会提示成功
 * 所以这里设定了约束条件输入销售记录中货物编号和职员工号需要在另两个表中包含
 */

public class GoodsaleView extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField sidText;

    private GoodsaleDAO goodsDAO = new GoodsaleDAO();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GoodsaleView frame = new GoodsaleView();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public GoodsaleView() throws Exception {

        setTitle("货物销售记录表");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 337);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 39, 564, 232);
        contentPane.add(scrollPane);

        Object[] columns = {"流水号", "货物编号", "货物名称", "职员工号","职员姓名","销售数量","结算支付"};
        Object[][] data = null;
        DefaultTableModel model = new DefaultTableModel(data, columns);
        table = new JTable(model);
        //加载数据
        load1(null);
        scrollPane.setViewportView(table);

        JLabel lblNewLabel = new JLabel("流水号");
        lblNewLabel.setBounds(10, 10, 42, 15);
        contentPane.add(lblNewLabel);

        sidText = new JTextField();
        sidText.setBounds(60, 8, 115, 21);
        contentPane.add(sidText);
        sidText.setColumns(10);

        //查看按钮
        JButton searchBtn = new JButton("查询");
        searchBtn.addActionListener(e -> {
            try {
                load1(sidText.getText());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        searchBtn.setBounds(300, 8, 63, 23);
        contentPane.add(searchBtn);

        //搜索
        JButton searchBtn1 = new JButton("搜索");
        searchBtn1.addActionListener(e -> {
            try {
                /*if(sidText.getText() != ""){
                    search1(sidText.getText());
                }else{
                    JOptionPane.showMessageDialog(contentPane, "不存在该记录", "系统提示", JOptionPane.WARNING_MESSAGE);
                }
                这里我猜测是它会有一个默认的尾缀导致""这个没有值的字符串无法判断为空，可能是默认长度什么的*/
                search1(sidText.getText());

            } /*catch (NumberFormatException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(contentPane, "不存在该记录", "系统提示", JOptionPane.WARNING_MESSAGE);
            }
            这里的解决不了，可能是因为这个流水号是String，所以归类在了查询数值输入异常上
            这是个缺陷，不过要是能解决SQLException这个数值传入错误的异常，这些问题都能解决*/
            catch (Exception e3) {
                e3.printStackTrace();
            }
        });

        searchBtn1.setBounds(185, 8, 63, 23);
        contentPane.add(searchBtn1);


        //添加统计方法
        JButton mathBtn = new JButton("信息统计");
        mathBtn.addActionListener(e -> {
            MathView view = null;
            try {
                view = new MathView();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            view.setVisible(true);
        });
        mathBtn.setBounds(480, 273, 88, 23);

        contentPane.add(mathBtn);

        //添加按钮
        JButton addBtn = new JButton("添加");
        addBtn.addActionListener(e -> {
            AddView3 view = new AddView3();
            view.setVisible(true);
        });
        addBtn.setBounds(365, 8, 63, 23);

        contentPane.add(addBtn);

        //修改按钮
        JButton updateBtn = new JButton("修改");
        updateBtn.addActionListener(e -> {
            // 获取选中行
            int row = table.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(contentPane, "请选择一条记录", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            //int id = Integer.valueOf(table.getValueAt(row, 0).toString());
            String id = table.getValueAt(row, 0).toString();
            UpdateView3 view = null;
            try {
                view = new UpdateView3(id);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            view.setVisible(true);

        });
        updateBtn.setBounds(438, 8, 63, 23);

        //删除按钮
        JButton deleteBtn = new JButton("删除");
        deleteBtn.addActionListener(e -> {
            // 获取选中行
            int row = table.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(contentPane, "请选择一条记录", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int result = JOptionPane.showConfirmDialog(contentPane, "确认删除该货物吗？", "提示",
                    JOptionPane.YES_NO_OPTION);
            if (result == 0) {
                //int sid = Integer.valueOf(table.getValueAt(row, 0).toString());
                String sid = table.getValueAt(row, 0).toString();
                try {
                    goodsDAO.delete(sid);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(contentPane, "删除成功!");
                try {
                    load1(null);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        deleteBtn.setBounds(511, 8, 63, 23);
        contentPane.add(deleteBtn);
        contentPane.add(updateBtn);
    }

    // 填充表格数据
    public void load1(String sid) throws Exception {
        List<Goodsale> list = goodsDAO.selectAll();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        // 填充数据
        for (Goodsale item : list) {
            String[] arr = new String[7];
            arr[0] = item.getId() + "";
            arr[1] = String.valueOf(item.getGoodid());
            arr[2] = item.getGoodname();
            arr[3] = String.valueOf(item.getSalespersonid());
            arr[4] = item.getSalespersonname();
            arr[5] = String.valueOf(item.getSalenumber());
            arr[6] = String.valueOf(item.getMoney());
            // 添加数据到表格
            tableModel.addRow(arr);
        }
    }

    public void search1(String sid) throws Exception {
        Goodsale goods = GoodsaleDAO.selectByid(sid);
        if (goods != null) {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0);// 清除原有行

            String[] arr = new String[7];

            arr[0] = goods.getId() + "";
            arr[1] = String.valueOf(goods.getGoodid());
            arr[2] = goods.getGoodname();
            arr[3] = String.valueOf(goods.getSalespersonid());
            arr[4] = goods.getSalespersonname();
            arr[5] = String.valueOf(goods.getSalenumber());
            arr[6] = String.valueOf(goods.getMoney());

            // 添加数据到表格
            tableModel.addRow(arr);
        } else {
            JOptionPane.showMessageDialog(contentPane, "不存在该记录", "系统提示", JOptionPane.WARNING_MESSAGE);
        }
    }
}

