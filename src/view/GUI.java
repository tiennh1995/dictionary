/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import action.SupportGUI;
import action.Data;
import java.awt.BorderLayout;
import object.R;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import object.Word;

/**
 *
 * @author TIENNH
 */
public class GUI extends javax.swing.JFrame {

    public static DefaultListModel<String> model = new DefaultListModel<>();
    public static DefaultListModel<String> modelBookmark = new DefaultListModel<>();
    public static DefaultListModel<String> modelType = new DefaultListModel<>();
    public static DefaultListModel<String> modelInter = new DefaultListModel<>();
    public static DefaultListModel<String> modelHistory = new DefaultListModel<>();
    public static Word defaultWord;
    public static int heightInfo, heightPro, heightImage, widthImage;
    public static BufferedImage bufferedPicture = null;
    public static int heightGUI = 30, widthLB = 90;
    public static String word = "";
    public static String info = "";

    public static JPanel pn = new JPanel();
    Data data = new Data();
    SupportGUI supportGUI = new SupportGUI();

    /**
     * Creates new form Main
     */
    @SuppressWarnings("LeakingThisInConstructor")
    public GUI() {
        initComponents();
        frame = this;

        initGUI();
        initData();

    }

    private void initGUI() {
        try {
            UIManager.setLookAndFeel(R.windowsClassName);
            SwingUtilities.updateComponentTreeUI(this);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            getContentPane().setBackground(new Color(250, 250, 250));
            //setResizable(false);
            setTitle("Từ điển bách khoa toàn thư");

            lbTen.setVisible(false);
            lbTheLoai.setVisible(false);
            btBookMark.setVisible(false);
            btDelBookmark.setVisible(false);
            btCorrect.setVisible(false);
            spImage.setVisible(false);
            spInfo.setViewportView(pnInfo);

            String url = System.getProperty("user.dir", null);
            String urlIcon = url + "\\data\\image\\icon\\title1.png";
            File file = new File(urlIcon);
            BufferedImage bufferedImage = ImageIO.read(file);
            pnTitle = new javax.swing.JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(bufferedImage, 0, 0, pnTitle.getWidth(), pnTitle.getHeight(), null);
                    repaint();
                }
            };
            spTitle.setViewportView(pnTitle);
            tfSearch.setText("Nhập từ cần tìm kiếm");
            urlIcon = url + "\\data\\image\\icon\\search.png";
            lbSearch.setIcon(new javax.swing.ImageIcon(urlIcon));

            urlIcon = url + "\\data\\image\\icon\\bookmark.png";
            btListBookMark.setIcon(new javax.swing.ImageIcon(urlIcon));
            btBookMark.setIcon(new javax.swing.ImageIcon(urlIcon));

            urlIcon = url + "\\data\\image\\icon\\delbookmark.png";
            btDelBookmark.setIcon(new javax.swing.ImageIcon(urlIcon));

            urlIcon = url + "\\data\\image\\icon\\add.png";
            btAdd.setIcon(new javax.swing.ImageIcon(urlIcon));

            urlIcon = url + "\\data\\image\\icon\\history.png";
            btHistory.setIcon(new javax.swing.ImageIcon(urlIcon));

            urlIcon = url + "\\data\\image\\icon\\edit.png";
            btCorrect.setIcon(new javax.swing.ImageIcon(urlIcon));

            setIconImage(Toolkit.getDefaultToolkit().getImage(url + "\\data\\image\\icon\\iconSearch.png"));
            pnInfo.setBackground(new Color(250, 250, 250));

            heightInfo = pnInfo.getHeight();
            heightPro = R.heightPro;
            heightImage = pnImage.getHeight();
            widthImage = pnImage.getWidth();
            lbInter.setVisible(false);
            R.arrayTextPane = new ArrayList<>();
            
            urlIcon = url + "\\data\\image\\icon\\delete.png";
            tfSearch.setLayout(new BorderLayout());
            JLabel lb = new JLabel(new javax.swing.ImageIcon(urlIcon));
            tfSearch.add(lb, BorderLayout.EAST);
            lb.addMouseListener(new MouseListener() 
            {
                @Override
                public void mouseClicked(MouseEvent e) {
                    tfSearch.setText("");
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initData() {

        R.hAnimal = new HashMap<>();
        R.hCar = new HashMap<>();
        R.hCompany = new HashMap<>();
        R.hComputer = new HashMap<>();
        R.hCountry = new HashMap<>();
        R.hCulinary = new HashMap<>();
        R.hMotorbike = new HashMap<>();
        R.hPerson = new HashMap<>();
        R.hPhone = new HashMap<>();
        R.hUniversity = new HashMap<>();
        R.hWord = new HashMap<>();
        R.hBookmark = new HashMap<>();
        R.hHistory = new HashMap<>();

        String url = System.getProperty("user.dir", null);
        String urlData;
        urlData = url + "\\data\\text\\history.txt";
        data.readData(urlData, -2);
        urlData = url + "\\data\\text\\bookmark.txt";
        data.readData(urlData, -1);
        urlData = url + "\\data\\text\\word.txt";
        data.readData(urlData, 0);
        urlData = url + "\\data\\text\\animal.txt";
        data.readData(urlData, 1);
        urlData = url + "\\data\\text\\car.txt";
        data.readData(urlData, 2);
        urlData = url + "\\data\\text\\company.txt";
        data.readData(urlData, 3);
        urlData = url + "\\data\\text\\computer.txt";
        data.readData(urlData, 4);
        urlData = url + "\\data\\text\\country.txt";
        data.readData(urlData, 5);
        urlData = url + "\\data\\text\\culinary.txt";
        data.readData(urlData, 6);
        urlData = url + "\\data\\text\\motorbike.txt";
        data.readData(urlData, 7);
        urlData = url + "\\data\\text\\person.txt";
        data.readData(urlData, 8);
        urlData = url + "\\data\\text\\phone.txt";
        data.readData(urlData, 9);
        urlData = url + "\\data\\text\\university.txt";
        data.readData(urlData, 10);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({"unchecked", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spTitle = new javax.swing.JScrollPane();
        pnTitle = new javax.swing.JPanel()
        ;
        spInfo = new javax.swing.JScrollPane();
        pnInfo = new javax.swing.JPanel();
        tfSearch = new javax.swing.JTextField();
        lbSearch = new javax.swing.JLabel();
        btListBookMark = new javax.swing.JButton();
        btAdd = new javax.swing.JButton();
        btHistory = new javax.swing.JButton();
        spLSearch = new javax.swing.JScrollPane();
        lSearch = new javax.swing.JList<>();
        spLBookmark = new javax.swing.JScrollPane();
        lBookmark = new javax.swing.JList<>();
        spLType = new javax.swing.JScrollPane();
        lType = new javax.swing.JList<>();
        spLHistory = new javax.swing.JScrollPane();
        lHistory = new javax.swing.JList<>();
        spLinter = new javax.swing.JScrollPane();
        lInter = new javax.swing.JList<>();
        spImage = new javax.swing.JScrollPane();
        pnImage = new javax.swing.JPanel();
        btBookMark = new javax.swing.JButton();
        btDelBookmark = new javax.swing.JButton();
        btCorrect = new javax.swing.JButton();
        lbTen = new javax.swing.JLabel();
        lbTheLoai = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbType = new javax.swing.JLabel();
        lbInter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        spTitle.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spTitle.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        pnTitle.setForeground(new java.awt.Color(0, 153, 204));
        pnTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnTitleMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnTitleLayout = new javax.swing.GroupLayout(pnTitle);
        pnTitle.setLayout(pnTitleLayout);
        pnTitleLayout.setHorizontalGroup(
            pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1111, Short.MAX_VALUE)
        );
        pnTitleLayout.setVerticalGroup(
            pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 155, Short.MAX_VALUE)
        );

        spTitle.setViewportView(pnTitle);

        spInfo.setPreferredSize(new java.awt.Dimension(200, 150));

        pnInfo.setPreferredSize(new java.awt.Dimension(200, 150));
        pnInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnInfoMouseClicked(evt);
            }
        });

        tfSearch.setToolTipText("Nhập từ cần tìm");
        tfSearch.setHighlighter(null);
        tfSearch.setMinimumSize(new java.awt.Dimension(608, 38));
        tfSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfSearchMouseClicked(evt);
            }
        });
        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });

        lbSearch.setToolTipText("Tìm kiếm");
        lbSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSearchMouseClicked(evt);
            }
        });

        btListBookMark.setToolTipText("Các từ đánh dấu");
        btListBookMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListBookMarkActionPerformed(evt);
            }
        });

        btAdd.setToolTipText("Thêm từ mới");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btHistory.setToolTipText("Lịch sử tìm kiếm");
        btHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHistoryActionPerformed(evt);
            }
        });

        lSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lSearchMouseClicked(evt);
            }
        });
        lSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lSearchKeyPressed(evt);
            }
        });
        spLSearch.setViewportView(lSearch);

        spLBookmark.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        lBookmark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lBookmarkMouseClicked(evt);
            }
        });
        spLBookmark.setViewportView(lBookmark);

        lType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lTypeMouseClicked(evt);
            }
        });
        spLType.setViewportView(lType);

        spLHistory.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        lHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lHistoryMouseClicked(evt);
            }
        });
        spLHistory.setViewportView(lHistory);

        lInter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lInterMouseClicked(evt);
            }
        });
        spLinter.setViewportView(lInter);

        spImage.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spImage.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        pnImage.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        pnImage.setNextFocusableComponent(lSearch);

        javax.swing.GroupLayout pnImageLayout = new javax.swing.GroupLayout(pnImage);
        pnImage.setLayout(pnImageLayout);
        pnImageLayout.setHorizontalGroup(
            pnImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );
        pnImageLayout.setVerticalGroup(
            pnImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
        );

        spImage.setViewportView(pnImage);

        btBookMark.setToolTipText("Đánh dấu");
        btBookMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBookMarkActionPerformed(evt);
            }
        });

        btDelBookmark.setToolTipText("Bỏ đánh dấu");
        btDelBookmark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDelBookmarkActionPerformed(evt);
            }
        });

        btCorrect.setToolTipText("Chỉnh sửa thông tin từ");
        btCorrect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCorrect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCorrectActionPerformed(evt);
            }
        });

        lbTen.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbTen.setForeground(new java.awt.Color(0, 51, 255));
        lbTen.setText("Tên :");
        lbTen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbTheLoai.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbTheLoai.setForeground(new java.awt.Color(0, 51, 255));
        lbTheLoai.setText("Thể loại :");

        lbName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbType.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        lbInter.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbInter.setForeground(new java.awt.Color(0, 51, 255));
        lbInter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbInter.setText("Các từ liên quan\n (Click để xem)"); // NOI18N
        lbInter.setToolTipText("Click vào để xem từ liên quan");
        lbInter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbInter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbInterMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
        pnInfo.setLayout(pnInfoLayout);
        pnInfoLayout.setHorizontalGroup(
            pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfoLayout.createSequentialGroup()
                .addComponent(tfSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(lbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(spLHistory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnInfoLayout.createSequentialGroup()
                            .addComponent(spLType, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(79, 79, 79)))
                    .addGroup(pnInfoLayout.createSequentialGroup()
                        .addComponent(btListBookMark, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9))
            .addGroup(pnInfoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(spLBookmark, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
            .addGroup(pnInfoLayout.createSequentialGroup()
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spLSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnInfoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(spImage, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnInfoLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(btBookMark, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btDelBookmark, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btCorrect, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnInfoLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(lbTen, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnInfoLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(lbTheLoai)
                                .addGap(34, 34, 34)
                                .addComponent(lbType, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnInfoLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(spLinter)
                                    .addComponent(lbInter, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnInfoLayout.setVerticalGroup(
            pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfoLayout.createSequentialGroup()
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btListBookMark, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnInfoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spLSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnInfoLayout.createSequentialGroup()
                                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btBookMark, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btDelBookmark, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btCorrect, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTen, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbType, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addComponent(lbInter, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(spImage, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spLinter, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnInfoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(spLBookmark, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(spLType, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(spLHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(289, Short.MAX_VALUE))
        );

        spInfo.setViewportView(pnInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE)
            .addComponent(spInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(spTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        spLSearch.setSize(new Dimension(0, 0));
        spLType.setSize(new Dimension(0, 0));
        spLBookmark.setSize(new Dimension(0, 0));
        spLinter.setSize(new Dimension(0, 0));
        spLHistory.setSize(new Dimension(0, 0));
    }//GEN-LAST:event_formMouseClicked

    private void btDelBookmarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDelBookmarkActionPerformed
        if (btDelBookmark.isEnabled()) {
            spLinter.setSize(new Dimension(0, 0));
            if (data.delBookmark(defaultWord.getTen())) {
                JOptionPane.showMessageDialog(null, "Xóa đánh dấu thành công!");
                btBookMark.setEnabled(true);
                btDelBookmark.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Xóa đánh dấu thất bại!");
            }

        }
    }//GEN-LAST:event_btDelBookmarkActionPerformed

    private void lBookmarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lBookmarkMouseClicked

        String text = lBookmark.getSelectedValue();
        tfSearch.setText(text);
        supportGUI.loadDataSearch(text);
        spLBookmark.setSize(0, 0);


    }//GEN-LAST:event_lBookmarkMouseClicked

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        spLBookmark.setSize(new Dimension(0, 0));
        spLSearch.setSize(new Dimension(0, 0));
        modelType.removeAllElements();
        spLinter.setSize(new Dimension(0, 0));
        spLHistory.setSize(new Dimension(0, 0));
        modelType.addElement("Động vật");
        modelType.addElement("Ô tô");
        modelType.addElement("Công ty");
        modelType.addElement("Máy tính");
        modelType.addElement("Quốc gia");
        modelType.addElement("Ẩm thực");
        modelType.addElement("Xe máy");
        modelType.addElement("Con người");
        modelType.addElement("Điện thoại");
        modelType.addElement("Trường học");
         int width =GUI.btListBookMark.getWidth() + GUI.btAdd.getWidth()+GUI.btHistory.getWidth()+10;
        spLType.setSize(width, R.sizeList * modelType.getSize());
        lType.setModel(modelType);
        spLType.setViewportView(lType);

    }//GEN-LAST:event_btAddActionPerformed

    private void btListBookMarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListBookMarkActionPerformed
        supportGUI.setBookmark();

    }//GEN-LAST:event_btListBookMarkActionPerformed

    private void lbSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSearchMouseClicked
        spLSearch.setSize(0, 0);
        spLinter.setSize(new Dimension(0, 0));
        String text = tfSearch.getText();
        supportGUI.loadDataSearch(text);
        data.addHistory(defaultWord);

    }//GEN-LAST:event_lbSearchMouseClicked

    private void lSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lSearchKeyPressed
        tfSearch.setText(lSearch.getSelectedValue());
        String text = tfSearch.getText();
        supportGUI.loadDataSearch(text);
        data.addHistory(defaultWord);
        spLSearch.setSize(0, 0);
    }//GEN-LAST:event_lSearchKeyPressed

    private void lSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lSearchMouseClicked
        tfSearch.setText(lSearch.getSelectedValue());
        String text = tfSearch.getText();
        supportGUI.loadDataSearch(text);
        data.addHistory(defaultWord);
        spLSearch.setSize(0, 0);
    }//GEN-LAST:event_lSearchMouseClicked

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        supportGUI.setDataSearch();
    }//GEN-LAST:event_tfSearchKeyReleased

    private void tfSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = tfSearch.getText();
            supportGUI.loadDataSearch(text);
            data.addHistory(defaultWord);
        }
    }//GEN-LAST:event_tfSearchKeyPressed

    private void tfSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfSearchMouseClicked

        spLinter.setSize(0, 0);
        spLBookmark.setSize(new Dimension(0, 0));
        spLType.setSize(new Dimension(0, 0));
        spLHistory.setSize(new Dimension(0, 0));
    }//GEN-LAST:event_tfSearchMouseClicked

    private void lTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lTypeMouseClicked
        supportGUI.setAddType(lType.getSelectedIndex() + 1, 0);
        setTitle("Thêm từ mới");
    }//GEN-LAST:event_lTypeMouseClicked

    private void lbInterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbInterMouseClicked
        supportGUI.setInter();
    }//GEN-LAST:event_lbInterMouseClicked

    private void pnInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnInfoMouseClicked
        spLSearch.setSize(new Dimension(0, 0));
        spLType.setSize(new Dimension(0, 0));
        spLBookmark.setSize(new Dimension(0, 0));
        spLinter.setSize(new Dimension(0, 0));
        spLHistory.setSize(new Dimension(0, 0));
    }//GEN-LAST:event_pnInfoMouseClicked

    private void pnTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTitleMouseClicked
        spLSearch.setSize(new Dimension(0, 0));
        spLType.setSize(new Dimension(0, 0));
        spLBookmark.setSize(new Dimension(0, 0));
        spLinter.setSize(new Dimension(0, 0));
        spLHistory.setSize(new Dimension(0, 0));
    }//GEN-LAST:event_pnTitleMouseClicked

    private void btCorrectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCorrectActionPerformed
        supportGUI.setAddType(defaultWord.getIdType(), 1);
        setTitle("Chỉnh sửa thông tin");
        setResizable(false);
    }//GEN-LAST:event_btCorrectActionPerformed

    private void btBookMarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBookMarkActionPerformed
        if (btBookMark.isEnabled()) {

            spLinter.setSize(new Dimension(0, 0));
            @SuppressWarnings("UnusedAssignment")
            Word word1 = new Word();
            word1 = defaultWord;
            if (data.addBookmark(word1)) {
                JOptionPane.showMessageDialog(null, "Đánh dấu thành công!");
                btBookMark.setEnabled(false);
                btDelBookmark.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Đánh dấu thất bại!");
            }

        }
    }//GEN-LAST:event_btBookMarkActionPerformed

    private void btHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHistoryActionPerformed
        supportGUI.setHistory();
    }//GEN-LAST:event_btHistoryActionPerformed

    @SuppressWarnings("Convert2Lambda")
    private void lHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lHistoryMouseClicked
        if (evt.getClickCount() == 2) {
            String text = lHistory.getSelectedValue();
            tfSearch.setText(text);
            supportGUI.loadDataSearch(text);
            spLHistory.setSize(0, 0);
        }
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem jmi = new JMenu("Delete");
        jmi.setAutoscrolls(false);
        popupMenu.add(jmi);
        if (SwingUtilities.isRightMouseButton(evt)
                && !lHistory.isSelectionEmpty()
                && lHistory.locationToIndex(evt.getPoint())
                == lHistory.getSelectedIndex()) {
            popupMenu.show(lHistory, evt.getX(), evt.getY());
        }

        jmi.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    if(data.delHistory(lHistory.getSelectedValue())){
                supportGUI.setHistory();
                if(popupMenu.isShowing())
                    popupMenu.setVisible(false);
                }
                    
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

    }//GEN-LAST:event_lHistoryMouseClicked

    private void lInterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lInterMouseClicked
     String text = lInter.getSelectedValue();
        tfSearch.setText(text);
        supportGUI.loadDataSearch(text);
        spLinter.setSize(0, 0);
    }//GEN-LAST:event_lInterMouseClicked

    public static JScrollPane spType;
    public static JPanel pnType;
    public static JScrollPane spPicture;
    public static JPanel pnPicture;

    public static JLabel animalLTen;
    public static JLabel animalLLoai;
    public static JLabel animalLTrongLuong;
    public static JLabel animalLThucAn;
    public static JLabel animalLDacTinh;
    public static JTextField animalTTen;
    public static JTextField animalTLoai;
    public static JTextField animalTTrongLuong;
    public static JTextField animalTThucAn;
    public static JTextField animalTDacTinh;

    public static JLabel carLTen;
    public static JLabel carLHang;
    public static JLabel carLGia;
    public static JLabel carLSoGhe;
    public static JTextField carTTen;
    public static JTextField carTHang;
    public static JTextField carTGia;
    public static JTextField carTSoGhe;

    public static JLabel companyLTen;
    public static JLabel companyLTGD;
    public static JLabel companyLGia;
    public static JLabel companyLLichSu;
    public static JTextField companyTTen;
    public static JTextField companyTTGD;
    public static JTextField companyTGia;
    public static JTextField companyTLichSu;

    public static JLabel computerLTen;
    public static JLabel computerLNSX;
    public static JLabel computerLModel;
    public static JLabel computerLGia;
    public static JLabel computerLHDH;
    public static JLabel computerLDoHoa;
    public static JTextField computerTTen;
    public static JTextField computerTNSX;
    public static JTextField computerTModel;
    public static JTextField computerTGia;
    public static JTextField computerTHDH;
    public static JTextField computerTDoHoa;

    public static JLabel countryLTen;
    public static JLabel countryLQuocCa;
    public static JLabel countryLDanSo;
    public static JLabel countryLDienTich;
    public static JLabel countryLThuDo;
    public static JLabel countryLLichSu;
    public static JTextField countryTTen;
    public static JTextField countryTQuocCa;
    public static JTextField countryTDanSo;
    public static JTextField countryTDienTich;
    public static JTextField countryTThuDo;
    public static JTextField countryTLichSu;

    public static JLabel culinaryLTen;
    public static JLabel culinaryLThanhPhan;
    public static JLabel culinaryLDiaDiem;
    public static JLabel culinaryLGia;
    public static JTextField culinaryTTen;
    public static JTextField culinaryTThanhPhan;
    public static JTextField culinaryTDiaDiem;
    public static JTextField culinaryTGia;

    public static JLabel motorbikeLTen;
    public static JLabel motorbikeLHang;
    public static JLabel motorbikeLGia;
    public static JTextField motorbikeTTen;
    public static JTextField motorbikeTHang;
    public static JTextField motorbikeTGia;

    public static JLabel personLTen;
    public static JLabel personLNgaySinh;
    public static JLabel personLQueQuan;
    public static JLabel personLCongViec;
    public static JTextField personTTen;
    public static JTextField personTNgaySinh;
    public static JTextField personTQueQuan;
    public static JTextField personTCongViec;

    public static JLabel phoneLTen;
    public static JLabel phoneLNSX;
    public static JLabel phoneLModel;
    public static JLabel phoneLGia;
    public static JLabel phoneLHDH;
    public static JTextField phoneTTen;
    public static JTextField phoneTNSX;
    public static JTextField phoneTModel;
    public static JTextField phoneTGia;
    public static JTextField phoneTHDH;

    public static JLabel univerLTen;
    public static JLabel univerLHieuTruong;
    public static JLabel univerLNganh;
    public static JLabel univerLLichSu;
    public static JLabel univerLSoluongSV;
    public static JTextField univerTTen;
    public static JTextField univerTHieuTruong;
    public static JTextField univerTNganh;
    public static JTextField univerTLichSu;
    public static JTextField univerTSoLuongSV;

    public static JFrame frame;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btAdd;
    public static javax.swing.JButton btBookMark;
    public static javax.swing.JButton btCorrect;
    public static javax.swing.JButton btDelBookmark;
    public static javax.swing.JButton btHistory;
    public static javax.swing.JButton btListBookMark;
    public static javax.swing.JList<String> lBookmark;
    public static javax.swing.JList<String> lHistory;
    public static javax.swing.JList<String> lInter;
    public static javax.swing.JList<String> lSearch;
    public static javax.swing.JList<String> lType;
    public static javax.swing.JLabel lbInter;
    public static javax.swing.JLabel lbName;
    public static javax.swing.JLabel lbSearch;
    public static javax.swing.JLabel lbTen;
    public static javax.swing.JLabel lbTheLoai;
    public static javax.swing.JLabel lbType;
    public static javax.swing.JPanel pnImage;
    public static javax.swing.JPanel pnInfo;
    private javax.swing.JPanel pnTitle;
    public static javax.swing.JScrollPane spImage;
    public static javax.swing.JScrollPane spInfo;
    public static javax.swing.JScrollPane spLBookmark;
    public static javax.swing.JScrollPane spLHistory;
    public static javax.swing.JScrollPane spLSearch;
    public static javax.swing.JScrollPane spLType;
    public static javax.swing.JScrollPane spLinter;
    private javax.swing.JScrollPane spTitle;
    public static javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables

}
