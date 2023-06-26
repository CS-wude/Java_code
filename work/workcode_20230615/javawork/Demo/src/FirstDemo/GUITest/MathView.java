package FirstDemo.GUITest;

import FirstDemo.bean.Goods;
import FirstDemo.bean.Goodsale;
import FirstDemo.dao.GoodsDAO;
import FirstDemo.dao.GoodsaleDAO;

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

/*
*约束条件
* 这里有一个约束条件就是如果goodsale表中的goodid对应goods表的id的number为空的话就会报错，
* 因为现实的表格需要调用goods的内容，而索引又是销售记录表中的，索引goods表需要有那个索引值
* 所以需要有正确的数值表
* 即销售记录需要在货物表中有对应关系*/

/**
 * @BelongsProject: javawork
 * @BelongsPackage: FirstDemo.GUITest
 * @FileName: MathView
 * @Author: wude
 * @Date: 2023/6/12-11:06
 * @Version: 1.0
 * @Description:
 */
public class MathView extends JFrame{
    private JPanel contentPanem;
    private JTable tablem;

    private GoodsDAO goodsdao = new GoodsDAO();
    private GoodsaleDAO goodsaledao = new GoodsaleDAO();

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            try {
                MathView frame = new MathView();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    public MathView() throws Exception {


        setTitle("销售统计表");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 537);
        setLocationRelativeTo(null);

        contentPanem = new JPanel();
        contentPanem.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanem);
        contentPanem.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 39, 364, 432);
        contentPanem.add(scrollPane);

        Object[] columns = {"货物编号", "货物名称", "销售数量", "剩余数量"};
        Object[][] data = null;
        DefaultTableModel model = new DefaultTableModel(data, columns);
        tablem = new JTable(model);
        //加载数据
        loadm();
        scrollPane.setViewportView(tablem);


        //查看按钮
        JButton searchBtn = new JButton("刷新");
        searchBtn.addActionListener(e -> {
            try {
                loadm();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        searchBtn.setBounds(300, 8, 63, 23);
        contentPanem.add(searchBtn);


        //-------------------------------------------------
        /*
        * 这有个缺陷就是由于设定了销售数量和剩余数量的变化，
        * 但如果某一方索取大于持有，那么就会导致出现负值*/


    }

    // 填充表格数据
    public void loadm(){
        List<Goodsale> list = goodsaledao.mathselect();
        //Goods goods = new Goods();
        DefaultTableModel tableModel = (DefaultTableModel) tablem.getModel();
        tableModel.setRowCount(0);
        // 填充数据
        for (Goodsale item : list) {
            String[] arr = new String[4];
            arr[0] = String.valueOf(item.getGoodid());
            arr[1] = item.getGoodname();
            arr[2] = String.valueOf(item.getSalenumber());
            //通过dao方法来获取所需内容
            arr[3] = String.valueOf(goodsdao.selectByid(item.getGoodid()).getNumber());
            // 添加数据到表格
            tableModel.addRow(arr);

        }
    };
}
