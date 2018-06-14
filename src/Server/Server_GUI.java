package Server;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

class Server_GUI extends JFrame {
    private JPanel contentPane = new JPanel();
    private JTextArea textArea = new JTextArea();
    private JButton server_launch_btn = new JButton("서버 실행");
    private JButton server_stop_btn = new JButton("서버 중지");


    private void init() {// 화면구성
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 325, 377);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 10, 285, 232);
        contentPane.add(scrollPane);

        scrollPane.setViewportView(textArea);
        textArea.setEditable(false);

        server_launch_btn.setBounds(12, 295, 139, 23);
        contentPane.add(server_launch_btn);

        server_stop_btn.setBounds(150, 295, 147, 23);
        contentPane.add(server_stop_btn);
        server_stop_btn.setEnabled(false);

        this.setVisible(true);
    }
}
