
import java.awt.*;
import javax.swing.*;

public class SimpleTodoApp {

    public static void main(String[] args) {

        JFrame frame = new JFrame("To-Do App");
        frame.setSize(350, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextField taskField = new JTextField(15);
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);

        JPanel topPanel = new JPanel();
        topPanel.add(taskField);
        topPanel.add(addButton);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(deleteButton);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Add task
        addButton.addActionListener(e -> {
            String task = taskField.getText();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Enter a task!");
            }
        });

        // Delete task
        deleteButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index != -1) {
                listModel.remove(index);
            } else {
                JOptionPane.showMessageDialog(frame, "Select a task!");
            }
        });

        frame.setVisible(true);
    }
}
