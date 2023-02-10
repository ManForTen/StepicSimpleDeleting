import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    static JFrame frame = new JFrame();
    static int width = 500, height = 500;
    static JLayeredPane panel = new JLayeredPane();

    public static void add(MouseEvent e){ // Метод добавления объекта по клику
        if (e.getButton()==1){ // Если кнопка левая
            JLabel label = new JLabel("X:"+e.getX()+" Y:"+e.getY()); // Создаем метку и указываем текст
            label.setBounds(e.getX(),e.getY(),100,20); // Устанавливаем на определённую точку
            label.addMouseListener(new MouseAdapter() { // Добавляем слушателя мыши на метку
                public void mouseClicked(MouseEvent e) {
                    delete(e);
                }
            });
            panel.add(label);
        }
    }

    public static void delete(MouseEvent e) { // Метод удаления объекта по клику колесика
        if (e.getButton()==2){ // Если кнопка колесико
            panel.remove((JLabel) e.getSource());
            panel.repaint(); // Обновляем панель, иначе изменения не отобразятся
        }
    }

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Добавление и удаление мышкой");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        panel.setFocusable(true); // Делаем у панели возможность принимать фокус, иначе она не сможет отловить события клавиатуры
        frame.add(panel);
        panel.addMouseListener(new MouseAdapter() { // Добавляем слушателя мыши на панель
            public void mouseClicked(MouseEvent e) {
                add(e);
            }
        });
        frame.setVisible(true);
    }
}