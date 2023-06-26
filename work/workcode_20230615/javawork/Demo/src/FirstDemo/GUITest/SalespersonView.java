package FirstDemo.GUITest;

import FirstDemo.bean.Salesperson;
import FirstDemo.dao.SalepersonDAO;

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
//import java.lang.String;
import java.lang.NumberFormatException;
import java.sql.SQLException;

/**
 * @BelongsProject: javawork
 * @BelongsPackage: FirstDemo.GUITest
 * @FileName: SalespersonView
 * @Author: wude
 * @Date: 2023/6/11-18:41
 * @Version: 1.0
 * @Description:
 */
public class SalespersonView extends JFrame {

    private JPanel contentPane2;
    private JTable table2;
    private JTextField sidText;

    private SalepersonDAO salepersonDAO = new SalepersonDAO();

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            try {
                SalespersonView frame = new SalespersonView();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    public SalespersonView() throws Exception {


        setTitle("销售人员表");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 537);
        setLocationRelativeTo(null);

        contentPane2 = new JPanel();
        contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane2);
        contentPane2.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 39, 364, 432);
        contentPane2.add(scrollPane);

        Object[] columns = {"工号", "姓名", "年龄", "职务"};
        Object[][] data = null;
        DefaultTableModel model = new DefaultTableModel(data, columns);
        table2 = new JTable(model);
        //加载数据
        load2(null);


            scrollPane.setViewportView(table2);

            JLabel lblNewLabel = new JLabel("工号");
            lblNewLabel.setBounds(10, 10, 42, 15);
            contentPane2.add(lblNewLabel);

            sidText = new JTextField();
            sidText.setBounds(44, 8, 115, 21);
            contentPane2.add(sidText);
            sidText.setColumns(10);

            //查看按钮
        JButton searchBtn = new JButton("查询");
        searchBtn.addActionListener(e -> {
            try {
                load2(sidText.getText());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        searchBtn.setBounds(300, 8, 63, 23);
        contentPane2.add(searchBtn);

            //搜索
        JButton searchBtn1 = new JButton("搜索");
        searchBtn1.addActionListener(e -> {
            try {
                search2(Integer.parseInt(sidText.getText()));
                //int ansearch = ((sidText.getText() != "") ? (Integer.parseInt(sidText.getText())) : 0 );
                //search2(ansearch);
            //} catch (Exception e1) {
            } catch (NumberFormatException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(contentPane2, "不存在该记录", "系统提示", JOptionPane.WARNING_MESSAGE);
            }/*catch (SQLException e2) {
                e2.printStackTrace();
                JOptionPane.showMessageDialog(contentPane2, "不存在该记录", "系统提示", JOptionPane.WARNING_MESSAGE);
                查询id输入不正确无法解决提示弹窗，这是个缺陷
            }*/
            catch (Exception e3) {
                e3.printStackTrace();
            }
            /*
            * 搜索有个小bug是若输入搜索的内容为空则会报异常，不会有结果
            * 在这使用一个判断语句，然后在search2方法中需要再次添加判断语句,本以为可以解决了这bug
            * 但依旧有莫名的问题
            * 后来使用了抛出异常下输入弹窗解决了传入空值问题，不过id输入错误依旧不报弹窗*/
        });

        searchBtn1.setBounds(169, 8, 63, 23);
        contentPane2.add(searchBtn1);

            //添加按钮
        JButton addBtn = new JButton("添加");
        addBtn.addActionListener(e -> {
            AddView2 view = new AddView2();
            view.setVisible(true);
        });
        addBtn.setBounds(135, 471, 63, 23);

        contentPane2.add(addBtn);

            //修改按钮
        JButton updateBtn = new JButton("修改");
        updateBtn.addActionListener(e -> {
            // 获取选中行
            int row = table2.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(contentPane2, "请选择一条记录", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            //id是默认第一列，即主键
            int id = Integer.valueOf(table2.getValueAt(row, 0).toString());
            UpdateView2 view = null;
            try {
                view = new UpdateView2(id);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            view.setVisible(true);

        });
        updateBtn.setBounds(215, 471, 63, 23);

            //删除按钮
        JButton deleteBtn = new JButton("删除");
        deleteBtn.addActionListener(e -> {
            // 获取选中行
            int row = table2.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(contentPane2, "请选择一条记录", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int result = JOptionPane.showConfirmDialog(contentPane2, "确认删除该记录吗？", "提示",
                    JOptionPane.YES_NO_OPTION);
            if (result == 0) {
                int sid = Integer.valueOf(table2.getValueAt(row, 0).toString());
                try {
                    salepersonDAO.delete(sid);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(contentPane2, "删除成功!");
                try {
                    load2(null);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        deleteBtn.setBounds(298, 471, 63, 23);
        contentPane2.add(deleteBtn);
        contentPane2.add(updateBtn);

    }

        // 填充表格数据
    public void load2(String sid){
        List<Salesperson> list = salepersonDAO.selectAll();
        DefaultTableModel tableModel = (DefaultTableModel) table2.getModel();
        tableModel.setRowCount(0);
        // 填充数据
        for (Salesperson item : list) {
            String[] arr = new String[4];
            arr[0] = item.getIdcard() + "";
            arr[1] = item.getSalespersonname();
            arr[2] = String.valueOf(item.getAge());
            arr[3] = item.getWorkertype();
            // 添加数据到表格
            tableModel.addRow(arr);

            }
    };

    public void search2(int sid) {

            Salesperson salesperson = SalepersonDAO.selectByid(sid);

            if (salesperson != null) {  //这个判断没有效果,考虑去改调用search地点判断获取字段是否为空
                //if (sid != 0) {
                //Salesperson salesperson = SalepersonDAO.selectByid(sid);
                DefaultTableModel tableModel = (DefaultTableModel) table2.getModel();
                tableModel.setRowCount(0);// 清除原有行

                String[] arr = new String[4];

                arr[0] = salesperson.getIdcard() + "";
                arr[1] = salesperson.getSalespersonname();
                arr[2] = String.valueOf(salesperson.getAge());
                arr[3] = salesperson.getWorkertype();

                // 添加数据到表格
                tableModel.addRow(arr);
            } else {
            /*这有个bug，不会回复提示
            现在我直接放在查询方法中了，会有提示，
            但依旧会报红，不过不会影响操作，勉强能用,勉强解决bug
            注意：这里的else很大可能用不上
            */
                JOptionPane.showMessageDialog(contentPane2, "不存在该记录", "系统提示", JOptionPane.WARNING_MESSAGE);
            }
    }
}
