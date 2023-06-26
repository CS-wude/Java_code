package FirstDemo.GUITest;

import FirstDemo.bean.Goods;
import FirstDemo.dao.GoodsDAO;


import java.awt.EventQueue;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 * @BelongsProject: javawork
 * @BelongsPackage: FirstDemo.GUITest
 * @FileName: UserListView
 * @Author: wude
 * @Date: 2023/6/11-12:50
 * @Version: 1.0
 * @Description:
 */

public class UserListView extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField sidText;

    private GoodsDAO goodsDAO = new GoodsDAO();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UserListView frame = new UserListView();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public UserListView() throws Exception {

        setTitle("货物销售管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 341);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 39, 564, 232);
        contentPane.add(scrollPane);

        Object[] columns = {"编号", "名称", "价格", "剩余"};
        Object[][] data = null;
        DefaultTableModel model = new DefaultTableModel(data, columns);
        table = new JTable(model);
        //加载数据
        load1(null);
        scrollPane.setViewportView(table);

        JLabel lblNewLabel = new JLabel("编号");
        lblNewLabel.setBounds(10, 10, 42, 15);
        contentPane.add(lblNewLabel);

        sidText = new JTextField();
        sidText.setBounds(44, 8, 115, 21);
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
                search1(Integer.parseInt(sidText.getText()));
            } catch (NumberFormatException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(contentPane, "不存在该记录", "系统提示", JOptionPane.WARNING_MESSAGE);
            }
            catch (Exception e3) {
                e3.printStackTrace();
            }
        });

        searchBtn1.setBounds(169, 8, 63, 23);
        contentPane.add(searchBtn1);


        //添加销售人员
        JButton saleBtn = new JButton("销售人员");
        saleBtn.addActionListener(e -> {
            try {
                SPview();
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        });
        saleBtn.setBounds(480, 273, 88, 23);

        contentPane.add(saleBtn);

        //添加销售记录
        JButton recordBtn = new JButton("销售记录");
        recordBtn.addActionListener(e -> {
            try {
                GSview();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        recordBtn.setBounds(380, 273, 88, 23);

        contentPane.add(recordBtn);

        //添加按钮
        JButton addBtn = new JButton("添加");
        addBtn.addActionListener(e -> {
            AddView view = new AddView();
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
            int id = Integer.valueOf(table.getValueAt(row, 0).toString());
            UpdateView view = null;
            try {
                view = new UpdateView(id);
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
                int sid = Integer.valueOf(table.getValueAt(row, 0).toString());
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
        List<Goods> list = goodsDAO.selectAll();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        // 填充数据
        for (Goods item : list) {
            String[] arr = new String[4];
            arr[0] = item.getId() + "";
            arr[1] = item.getGoodname();
            arr[2] = String.valueOf(item.getPrice());
            arr[3] = String.valueOf(item.getNumber());
            // 添加数据到表格
            tableModel.addRow(arr);
        }
    }

    public void search1(int sid) throws Exception {
        Goods goods = GoodsDAO.selectByid(sid);
        if (goods != null) {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0);// 清除原有行

            String[] arr = new String[4];

            arr[0] = goods.getId() + "";
            arr[1] = goods.getGoodname();
            arr[2] = String.valueOf(goods.getPrice());
            arr[3] = String.valueOf(goods.getNumber());

            // 添加数据到表格
            tableModel.addRow(arr);
        } else {
            JOptionPane.showMessageDialog(contentPane, "不存在该货物", "系统提示", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void SPview() throws Exception{
        SalespersonView view = new SalespersonView();
        view.setVisible(true);
        /*
        * 设置外置方法体，可以再主类中调用这个外置方法体，从而实现非静态调用静态的bug*/

        /*现在又有个问题需要解决，就是打开了这个窗口如果关闭这个窗口则会导致全部窗口关闭
        * 应该有个参数可以解决
        * 解决方法:setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);*/
    }

    public void GSview() throws Exception{
        GoodsaleView view = new GoodsaleView();
        view.setVisible(true);

    }
}

