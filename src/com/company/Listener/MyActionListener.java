package com.company.Listener;
import com.company.Interface.Bundle_Page;
import com.company.Interface.Order_Page;
import com.company.Product.ProductDAO;
import com.company.ServiceLayer.*;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Vector;

public class MyActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void Press1(Service service,CheckService checkService){
        Order_Page frame=new Order_Page(service,checkService);
    }
    public void Press2(Service service){
        JFrame frame=new JFrame("Show All Products");
        frame.setSize(800,600);
        JPanel panel=new JPanel();
        panel.setLayout(new BorderLayout());
        JTable jTable=new JTable();
        DefaultTableModel tableModel=new DefaultTableModel();
        jTable.setFillsViewportHeight(true);
        jTable.setRowSelectionAllowed(true);
        jTable.setRowHeight(26);
        jTable.setModel(tableModel);
        String[] head={"ID","Name","Price","Discount","Bundle"};
        tableModel.setColumnIdentifiers(head);
        Map<Integer,ProductDAO> map=service.output();
        for(int key:map.keySet()){
            Vector<Object> temp=new Vector<>();
            temp.add(map.get(key).getId());
            temp.add(map.get(key).getName());
            temp.add(map.get(key).getPrice());
            map.get(key).setDiscountRule();
            temp.add(map.get(key).getDiscountRule());
            temp.add(map.get(key).getBundle());
            tableModel.addRow(temp);
        }
        panel.add(new JScrollPane(jTable));
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
    public void Press3(Service service){
        JFrame frame=new JFrame("Create A Product");
        frame.setSize(800,600);
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JLabel jLabel=new JLabel("Please input the name,price and description of the Product(separate by the comma \",\")");
        JTextField jTextFirle=new JTextField(20);
        jTextFirle.setText("Please input the name,price and description of the Product(separate by the comma \",\")");
        JButton bname=new JButton("SEND");
        bname.addActionListener(new MyActionListener(){
            JTextField temp=jTextFirle;
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductDAO productDao=new ProductDAO();
                String content=temp.getText();
                String[] part=content.split(",");
                String name=part[0];
                String price=part[1];
                String desc=part[2];
                productDao.setName(name);
                double doubleprice=Double.parseDouble(price);
                productDao.setPrice(doubleprice);
                productDao.setDescription(desc);
                String result=service.Add(productDao);
                JOptionPane.showMessageDialog(panel,result);
            }
        });
        panel.add(jLabel);
        panel.add(jTextFirle);
        panel.add(bname);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
    public void Press4(Service service){
        JFrame frame=new JFrame("Remove A product");
        frame.setSize(800,600);
        JPanel panel=new JPanel();
        JLabel jLabel=new JLabel("Please input the name of the Product you want to remove");
        JTextField jTextFirle=new JTextField(20);
        JButton bname=new JButton("SEND");
        bname.addActionListener(new MyActionListener(){
            JTextField temp=jTextFirle;
            @Override
            public void actionPerformed(ActionEvent e) {
                String content=temp.getText();
                String result=service.Remove(content);
                JOptionPane.showMessageDialog(panel,result);
            }
        });
        panel.add(jLabel);
        panel.add(jTextFirle);
        panel.add(bname);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
    public void Press5(Service service){
        JFrame frame=new JFrame("Add Discount Policy");
        frame.setSize(800,600);
        JPanel panel=new JPanel();
        JLabel jLabel=new JLabel("Please input the name of the product you want to give discount:");
        JTextField jTextFirle=new JTextField(20);
        JButton bname=new JButton("SEND");
        bname.addActionListener(new MyActionListener(){
            JTextField temp=jTextFirle;
            @Override
            public void actionPerformed(ActionEvent e) {
                String content=temp.getText();
                String result=service.Discount(content);
                JOptionPane.showMessageDialog(panel,result);
            }
        });
        panel.add(jLabel);
        panel.add(jTextFirle);
        panel.add(bname);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
    public void Press6(Service service){
        Bundle_Page frame=new Bundle_Page(service);
    }
    public void Press7(Service service){
        JFrame frame=new JFrame("Modify the Price/Description of the Product");
        frame.setSize(800,600);
        JPanel panel=new JPanel();
        frame.setContentPane(panel);
        JLabel jLabel=new JLabel("Please input the name of the Product you want to modify");
        JTextField jTextFirle=new JTextField(20);
        JButton bname=new JButton("SEND");
        bname.addActionListener(new MyActionListener(){
            JTextField temp=jTextFirle;
            @Override
            public void actionPerformed(ActionEvent e) {
                String content=temp.getText();
                String result=service.Modify(content);
                JOptionPane.showMessageDialog(panel,result);
            }
        });
        panel.add(jLabel);
        panel.add(jTextFirle);
        panel.add(bname);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
