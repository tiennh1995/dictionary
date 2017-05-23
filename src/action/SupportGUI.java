/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import object.R;
import object.Word;
import view.FileChooser;
import view.GUI;



/**
 *
 * @author TIENNH
 */
public class SupportGUI extends Data {

    public void setDataSearch() {
        @SuppressWarnings("UnusedAssignment")
        DefaultListModel<Word> modelWord = new DefaultListModel<>();
        String text = GUI.tfSearch.getText();
        GUI.model.removeAllElements();
        if (text == null || text.equals("") == true) {
            GUI.spLSearch.setSize(0, 0);
            if (R.bufferedImage != null) {
                GUI.spImage.setVisible(true);
            }

        } else {
            modelWord = searchWord(text, 0);
            if (modelWord.isEmpty()) {
                GUI.spLSearch.setSize(0, 0);
                return;
            }
            for (int i = 0; i < modelWord.getSize(); i++) {
                GUI.model.addElement(modelWord.get(i).getTen());
            }

            int size = R.sizeList * GUI.model.getSize();
            if (size > 150) {
                size = 150;
            }

            GUI.spImage.setVisible(false);

            GUI.lSearch.setModel(GUI.model);
            GUI.spLSearch.setSize(GUI.tfSearch.getWidth(), size);
            GUI.spLSearch.setViewportView(GUI.lSearch);

        }
    }

    @SuppressWarnings("UnusedAssignment")
    public void loadDataSearch(String text) {
        @SuppressWarnings("UnusedAssignment")
        DefaultListModel<Word> modelWord = new DefaultListModel<>();
        if (text != null && text.equals("") == false) {
            try {
                modelWord = searchWord(text, 1);
                if (modelWord.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy từ khóa : \'" + text + "\' !");
                    return;
                }
                GUI.defaultWord = new Word(0, null, 0);
                GUI.defaultWord = modelWord.get(0);
                searchInfoWord(modelWord.get(0).getId(), modelWord.get(0).getIdType());
                File file;
                String url = System.getProperty("user.dir", null);
                resetProperties();
                switch (modelWord.get(0).getIdType()) {
                    case 1:
                        file = new File(url + R.animal.getAnh());
                        R.bufferedImage = ImageIO.read(file);
                        setImage(R.bufferedImage);
                        GUI.lbType.setText(R.animal.getTen());
                        String loai = "",
                         trongluong = "",
                         thucan = "",
                         dactinh = "";
                        loai = String.format("<html><font color=\"blue\" size = +1 <b> Loài : </b>  </font>" + R.animal.getLoai() + "<br/><br/>", loai);
                        trongluong = String.format("<font color=\"blue\" size = +1 <b> Trọng lượng : </b>  </font>" + R.animal.getTrongLuong() + "<br/><br/>", trongluong);
                        thucan = String.format("<font color=\"blue\" size = +1 <b> Thức ăn : </b>  </font>" + R.animal.getThucAn() + "<br/><br/>", thucan);
                        dactinh = String.format("<font color=\"blue\" size = +1 <b> Đặc tính : </b>  </font>" + R.animal.getDacTinh() + "<br/><br/></html>", dactinh);
                        text = loai + trongluong + thucan + dactinh;
                        setProperties("", text);
                        /*setProperties("Loài : ", R.animal.getLoai());
                        setProperties("Trọng lượng trung bình : ", String.valueOf(R.animal.getTrongLuong()) + " (KG)");
                        setProperties("Thức ăn : ", R.animal.getThucAn());
                        setProperties("Đặc tính : ", R.animal.getDacTinh());*/

                        GUI.heightPro = R.heightPro;
                        break;
                    case 2:
                        file = new File(url + R.car.getAnh());
                        R.bufferedImage = ImageIO.read(file);
                        setImage(R.bufferedImage);
                        GUI.lbType.setText(R.car.getTen());
                        String hang = "",
                         gia = "",
                         ghe = "";
                        hang = String.format("<html><font color=\"blue\" size = +1 <b> Hãng : </b>  </font>" + R.car.getHang() + "<br/><br/>", hang);
                        gia = String.format("<font color=\"blue\" size = +1 <b> Gía : </b>  </font>" + R.car.getGia() + "<br/><br/>", gia);
                        ghe = String.format("<font color=\"blue\" size = +1 <b> Số ghế : </b>  </font>" + R.car.getSoGhe() + "<br/><br/></html>", ghe);
                        text = hang + gia + ghe;
                        setProperties("", text);
//                        setProperties("Hãng : ", R.car.getHang());
//                        setProperties("Gía : ", R.car.getGia());
//                        setProperties("Số ghế : ", R.car.getSoGhe());
                        GUI.heightPro = R.heightPro;
                        break;
                    case 3:
                        file = new File(url + R.company.getAnh());
                        R.bufferedImage = ImageIO.read(file);
                        setImage(R.bufferedImage);
                        GUI.lbType.setText(R.company.getTen());
                        String tgd = "",
                         gia1 = "",
                         ls = "";
                        tgd = String.format("<html><font color=\"blue\" size = +1 <b> Tổng giám đốc : </b>  </font>" + R.company.getTGD() + "<br/><br/>", tgd);
                        ls = String.format("<font color=\"blue\" size = +1 <b> Lịch sử : </b>  </font>" + R.company.getLichSu() + "<br/><br/>", ls);
                        gia1 = String.format("<font color=\"blue\" size = +1 <b> Gía : </b>  </font>" + R.company.getGia() + "<br/><br/></html>", gia1);
                        text = tgd + ls + gia1;
                        setProperties("", text);

//                        setProperties("Tổng giám đốc : ", R.company.getTGD());
//                        setProperties("Gía : ", R.company.getGia());
//                        setProperties("Lịch sử : ", R.company.getLichSu());
                        GUI.heightPro = R.heightPro;
                        break;
                    case 4:
                        file = new File(url + R.computer.getAnh());
                        R.bufferedImage = ImageIO.read(file);
                        setImage(R.bufferedImage);
                        GUI.lbType.setText(R.computer.getTen());

                        String nsx = "",
                         model = "",
                         gia2 = "",
                         hdh = "",
                         dohoa = "";
                        nsx = String.format("<html><font color=\"blue\" size = +1 <b> Nhà sản xuất : </b>  </font>" + R.computer.getNSX() + "<br/><br/>", nsx);
                        model = String.format("<font color=\"blue\" size = +1 <b> Model : </b>  </font>" + R.computer.getModel() + "<br/><br/>", model);
                        gia2 = String.format("<font color=\"blue\" size = +1 <b> Gía : </b>  </font>" + R.computer.getGia() + "<br/><br/>", gia2);
                        hdh = String.format("<font color=\"blue\" size = +1 <b> Hệ điều hành : </b>  </font>" + R.computer.getHDH() + "<br/><br/>", hdh);
                        dohoa = String.format("<font color=\"blue\" size = +1 <b> Đồ họa : </b>  </font>" + R.computer.getDoHoa() + "<br/><br/></html>", dohoa);
                        text = nsx + model + gia2 + hdh + dohoa;
                        setProperties("", text);

//                        setProperties("Nhà sản xuất : ", R.computer.getNSX());
//                        setProperties("Model : ", R.computer.getModel());
//                        setProperties("Gía : ", R.computer.getGia());
//                        setProperties("Hệ điều hành : ", R.computer.getHDH());
//                        setProperties("Đồ họa : ", R.computer.getDoHoa());
                        GUI.heightPro = R.heightPro;
                        break;
                    case 5:
                        file = new File(url + R.country.getAnh());
                        R.bufferedImage = ImageIO.read(file);
                        setImage(R.bufferedImage);
                        GUI.lbType.setText(R.country.getTen());

                        String qc = "",
                         ds = "",
                         dt = "",
                         td = "",
                         ls1 = "";
                        qc = String.format("<html><font color=\"blue\" size = +1 <b> Quốc ca : </b>  </font>" + R.country.getQuocCa() + "<br/><br/>", qc);
                        ds = String.format("<font color=\"blue\" size = +1 <b> Dân số : </b>  </font>" + R.country.getDanSo() + "<br/><br/>", ds);
                        dt = String.format("<font color=\"blue\" size = +1 <b> Diện tích : </b>  </font>" + R.country.getDienTich() + "<br/><br/>", dt);
                        td = String.format("<font color=\"blue\" size = +1 <b> Thủ đô : </b>  </font>" + R.country.getThuDo() + "<br/><br/>", td);
                        ls1 = String.format("<font color=\"blue\" size = +1 <b> Lịch sử : </b>  </font>" + R.country.getLichSu() + "<br/><br/></html>", ls1);
                        text = qc + ds + dt + td + ls1;
                        setProperties("", text);

//                        setProperties("Quốc ca : ", R.country.getQuocCa());
//                        setProperties("Dân số : ", String.valueOf(R.country.getDanSo()));
//                        setProperties("Diện tích : ", String.valueOf(R.country.getDienTich()));
//                        setProperties("Thủ đô : ", R.country.getThuDo());
//                        setProperties("Lịch sử : ", R.country.getLichSu());
                        GUI.heightPro = R.heightPro;
                        break;
                    case 6:
                        file = new File(url + R.culinary.getAnh());
                        R.bufferedImage = ImageIO.read(file);
                        setImage(R.bufferedImage);
                        GUI.lbType.setText(R.culinary.getTen());

                        String tp1 = "",
                         dd = "",
                         gia3 = "";
                        tp1 = String.format("<html><font color=\"blue\" size = +1 <b> Thành phần : </b>  </font>" + R.culinary.getThanhPhan() + "<br/><br/>", tp1);
                        dd = String.format("<font color=\"blue\" size = +1 <b> Địa điểm : </b>  </font>" + R.culinary.getDiaDiem() + "<br/><br/>", dd);
                        gia3 = String.format("<font color=\"blue\" size = +1 <b> Gía : </b>  </font>" + R.culinary.getGia() + "<br/><br/></html>", gia3);
                        text = tp1 + dd + gia3;
                        setProperties("", text);

//                        setProperties("Thành phần : ", R.culinary.getThanhPhan());
//                        setProperties("Địa điểm : ", R.culinary.getDiaDiem());
//                        setProperties("Gía : ", R.culinary.getGia());
                        GUI.heightPro = R.heightPro;
                        break;
                    case 7:
                        file = new File(url + R.motorbike.getAnh());
                        R.bufferedImage = ImageIO.read(file);
                        setImage(R.bufferedImage);
                        GUI.lbType.setText(R.motorbike.getTen());

                        String han = "",
                         gia4 = "";
                        han = String.format("<html><font color=\"blue\" size = +1 <b> Hãng : </b>  </font>" + R.motorbike.getHang() + "<br/><br/>", han);
                        gia4 = String.format("<font color=\"blue\" size = +1 <b> Gía : </b>  </font>" + R.motorbike.getGia() + "<br/><br/></html>", gia4);
                        text = han + gia4;
                        setProperties("", text);

//                        setProperties("Hãng : ", R.motorbike.getHang());
//                        setProperties("Gía : ", R.motorbike.getGia());
                        GUI.heightPro = R.heightPro;
                        break;
                    case 8:
                        file = new File(url + R.person.getAnh());
                        R.bufferedImage = ImageIO.read(file);
                        setImage(R.bufferedImage);
                        GUI.lbType.setText(R.person.getTen());

                        String ns = "",
                         qq = "",
                         cv = "";
                        ns = String.format("<html><font color=\"blue\" size = +1 <b> Ngày sinh : </b>  </font>" + R.person.getNgaySinh() + "<br/><br/>", ns);
                        qq = String.format("<html><font color=\"blue\" size = +1 <b> Quê quán: </b>  </font>" + R.person.getQueQuan() + "<br/><br/>", qq);
                        cv = String.format("<font color=\"blue\" size = +1 <b> Công việc : </b>  </font>" + R.person.getCongViec() + "<br/><br/></html>", cv);
                        text = ns + qq + cv;
                        setProperties("", text);

//                        setProperties("Ngày sinh : ", R.person.getNgaySinh());
//                        setProperties("Quê quán : ", R.person.getQueQuan());
//                        setProperties("Công việc : ", R.person.getCongViec());
                        GUI.heightPro = R.heightPro;
                        break;
                    case 9:
                        file = new File(url + R.phone.getAnh());
                        R.bufferedImage = ImageIO.read(file);
                        setImage(R.bufferedImage);
                        GUI.lbType.setText(R.phone.getTen());
                        String nsx2 = "",
                         model2 = "",
                         gia5 = "",
                         hdh2 = "";
                        nsx2 = String.format("<html><font color=\"blue\" size = +1 <b> Ngày sinh : </b>  </font>" + R.phone.getNSX() + "<br/><br/>", nsx2);
                        model2 = String.format("<html><font color=\"blue\" size = +1 <b> Quê quán: </b>  </font>" + R.phone.getModel() + "<br/><br/>", model2);
                        gia5 = String.format("<html><font color=\"blue\" size = +1 <b> Gía: </b>  </font>" + R.phone.getGia() + "<br/><br/>", gia5);
                        hdh2 = String.format("<font color=\"blue\" size = +1 <b> Hệ điều hành : </b>  </font>" + R.phone.getHDH() + "<br/><br/></html>", hdh2);
                        text = nsx2 + model2 + gia5 + hdh2;
                        setProperties("", text);

//                        setProperties("Nhà sản xuất : ", R.phone.getNSX());
//                        setProperties("Model : ", R.phone.getModel());
//                        setProperties("Gía : ", R.phone.getGia());
//                        setProperties("Hệ điều hành : ", R.phone.getHDH());
                        GUI.heightPro = R.heightPro;
                        break;
                    case 10:
                        file = new File(url + R.university.getAnh());
                        R.bufferedImage = ImageIO.read(file);
                        setImage(R.bufferedImage);
                        GUI.lbType.setText(R.university.getTen());
                        String ht = "",
                         nganh = "",
                         ls2 = "",
                         sv = "";
                        ht = String.format("<html><font color=\"blue\" size = +1 <b> Hiệu trưởng : </b>  </font>" + R.university.getHieuTruong() + "<br/><br/>", ht);
                        nganh = String.format("<font color=\"blue\" size = +1 <b> Ngành : </b>  </font>" + R.university.getNganh() + "<br/><br/>", nganh);
                        ls2 = String.format("<font color=\"blue\" size = +1 <b> Lịch sử : </b>  </font>" + R.university.getLichSu() + "<br/><br/>", ls2);
                        sv = String.format("<font color=\"blue\" size = +1 <b> Số lượng SV : </b>  </font>" + R.university.getSoLuongSV() + "<br/><br/></html>", sv);
                        text = ht + nganh + ls2 + sv;
                        setProperties("", text);
//                        setProperties("Hiệu trưởng : ", R.university.getHieuTruong());
//                        setProperties("Ngành : ", R.university.getNganh());
//                        setProperties("Lịch sử : ", R.university.getLichSu());
//                        setProperties("Số lượng sinh viên : ", String.valueOf(R.university.getSoLuongSV()));
                        GUI.heightPro = R.heightPro;
                        break;
                    default:
                        break;

                }

                GUI.lbTen.setVisible(true);
                GUI.lbTheLoai.setVisible(true);

                GUI.btBookMark.setVisible(true);
                GUI.btDelBookmark.setVisible(true);
                GUI.btCorrect.setVisible(true);
                GUI.pnImage.setVisible(true);
                GUI.lbName.setText(modelWord.get(0).getTen());
                if (searchBookmark(modelWord.get(0).getTen()) == null) {
                    GUI.btDelBookmark.setEnabled(false);
                    GUI.btBookMark.setEnabled(true);
                } else {
                    GUI.btBookMark.setEnabled(false);
                    GUI.btDelBookmark.setEnabled(true);
                }
                GUI.lbInter.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void setProperties(String title, String text) {
        JTextPane lbMsg = new JTextPane();
        lbMsg.setContentType("text/html");
        lbMsg.setEditable(false);
        lbMsg.setBackground(null);
        lbMsg.setBorder(null);
        lbMsg.setAutoscrolls(true);
        //  text = String.format("<html><font color=\"blue\" size = +1 <b>" + title + "</b>  </font>" + text + "</html>", text);
        text = String.format("<html><div style=\"width:%dpx;\">%s</div><html>", R.widthPro, text);
        int count = text.length() / 170;
        if (count != 0) {
        } else {
            count = 1;
        }
        String dt[] = text.split("<br/>");
        count += dt.length;
        lbMsg.setText(text);
        lbMsg.setLocation(10, GUI.heightPro);
        lbMsg.setPreferredSize(new Dimension(R.widthPro + R.sizeDelta, R.sizePro * count));
        lbMsg.setSize(lbMsg.getPreferredSize());
        GUI.pnInfo.add(lbMsg);
        GUI.heightPro += lbMsg.getHeight() + 10;
        if (GUI.heightPro > GUI.heightInfo) {
            GUI.pnInfo.setPreferredSize(new Dimension(GUI.pnInfo.getPreferredSize().width,
                    GUI.heightPro));
            GUI.spLSearch.setSize(new Dimension(0, 0));
            GUI.spLType.setSize(new Dimension(0, 0));
            GUI.spLBookmark.setSize(new Dimension(0, 0));
        } else {
            GUI.pnInfo.setPreferredSize(new Dimension(GUI.pnInfo.getPreferredSize().width,
                    GUI.heightPro));

        }
        GUI.spInfo.setViewportView(GUI.pnInfo);
        JScrollBar vertical = GUI.spInfo.getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());
        R.arrayTextPane.add(lbMsg);

    }

    public void resetProperties() {
        for (int i = 0; i < R.arrayTextPane.size(); i++) {
            GUI.pnInfo.remove(R.arrayTextPane.get(i));
            GUI.pnInfo.revalidate();
            GUI.pnInfo.repaint();

        }

        GUI.spInfo.setViewportView(GUI.pnInfo);
        R.arrayTextPane.clear();

    }

    public void setImage(BufferedImage bufferedImage) {
        GUI.pnImage = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bufferedImage, 0, 0, GUI.pnImage.getWidth(), GUI.pnImage.getHeight(), null);
                repaint();
            }
        };

        GUI.spImage.setViewportView(GUI.pnImage);
        GUI.spImage.setVisible(true);
    }

    public void setBookmark() {
        GUI.spLSearch.setSize(new Dimension(0, 0));
        GUI.spLType.setSize(new Dimension(0, 0));
        GUI.spLinter.setSize(0, 0);
        GUI.spLHistory.setSize(0, 0);
        if (!R.hBookmark.isEmpty()) {
            GUI.modelBookmark.removeAllElements();
            Collection<Word> words = R.hBookmark.values();
            Iterator<Word> it;
            for (it = words.iterator(); it.hasNext();) {
                Word word = it.next();
                GUI.modelBookmark.addElement(word.getTen());
            }

            int size = R.sizeList * GUI.modelBookmark.getSize();
            if (size > 150) {
                size = 150;
            }
            int width = GUI.btListBookMark.getWidth() + GUI.btAdd.getWidth() + GUI.btHistory.getWidth() + 10;
            GUI.spLBookmark.setSize(width, size);
            GUI.lBookmark.setModel(GUI.modelBookmark);
            GUI.spLBookmark.setViewportView(GUI.lBookmark);

        } else {
            JOptionPane.showMessageDialog(null, "Chưa có từ nào được đánh dấu!");
        }
    }

    public void setHistory() {
        GUI.spLSearch.setSize(new Dimension(0, 0));
        GUI.spLType.setSize(new Dimension(0, 0));
        GUI.spLinter.setSize(0, 0);
        GUI.spLBookmark.setSize(0, 0);
        GUI.spLHistory.setSize(new Dimension(0, 0));
        if (!R.hHistory.isEmpty()) {
            GUI.modelHistory.removeAllElements();
            Collection<Word> words = R.hHistory.values();
            Iterator<Word> it;
            for (it = words.iterator(); it.hasNext();) {
                Word word = it.next();
                GUI.modelHistory.addElement(word.getTen());
            }

            int size = R.sizeList * GUI.modelHistory.getSize();
            if (size > 150) {
                size = 150;
            }
            int width = GUI.btListBookMark.getWidth() + GUI.btAdd.getWidth() + GUI.btHistory.getWidth() + 10;
            GUI.spLHistory.setSize(width, size);
            GUI.lHistory.setModel(GUI.modelHistory);
            GUI.spLHistory.setViewportView(GUI.lHistory);

        }

    }

    public void setInter() {
        GUI.modelInter.removeAllElements();
        @SuppressWarnings("UnusedAssignment")
        ArrayList<Integer> arrInt = new ArrayList<>();
        arrInt = searchInterdepend(GUI.defaultWord.getIdType());
        if (arrInt.size() <= 1) {
            GUI.spLinter.setSize(0, 0);
            JOptionPane.showMessageDialog(null, "Không có từ liên quan!");
            return;
        }
        int i;
        for (i = 0; i < arrInt.size(); i++) {
            if (arrInt.get(i) != GUI.defaultWord.getId()) {
                GUI.modelInter.addElement(searchWord(arrInt.get(i)).getTen());
            }
        }

        int size = R.sizeList * GUI.modelInter.getSize();
        if (size > 150) {
            size = 150;
        }
        GUI.lInter.setModel(GUI.modelInter);
        GUI.spLinter.setSize(new Dimension(GUI.lbInter.getWidth(), size));
        GUI.spLinter.setViewportView(GUI.lInter);

    }

    @SuppressWarnings({"Convert2Lambda", "UnusedAssignment"})
    public void setAddType(int idType, int ctrl) {
        GUI.frame.setResizable(false);
        int height = 0;
        int widthTF = GUI.pnInfo.getWidth() - GUI.widthLB - GUI.heightGUI;

        GUI.spType = new JScrollPane();
        GUI.spType.setSize(GUI.spInfo.getWidth(), GUI.spInfo.getHeight());
        GUI.pnType = new JPanel(null, true);
        GUI.pnType.setSize(GUI.spInfo.getWidth(), GUI.spInfo.getHeight());
        GUI.spType.add(GUI.pnType);

        JLabel lbCancel = new JLabel("Trở lại", JLabel.NORTH_EAST);
        lbCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbCancel.setBounds(GUI.pnType.getWidth() - 50, 0, 60, 30);

        GUI.pnType.add(lbCancel);
        GUI.pnType.setBackground(new Color(250, 250, 250));

        lbCancel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                GUI.spInfo.setViewportView(GUI.pnInfo);
                GUI.frame.setResizable(true);
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }

        });

        GUI.spPicture = new JScrollPane();
        GUI.spPicture.setBounds(5 + GUI.widthLB, 30, 200, 150);
        GUI.pnPicture = new JPanel(null, true);

        JButton btPicture = new JButton("Ảnh");
        btPicture.setBounds(10 + GUI.spPicture.getWidth() + GUI.widthLB, GUI.spPicture.getLocation().y, 60, 30);
        height += GUI.spPicture.getHeight();
        if (ctrl == 1) {
            GUI.bufferedPicture = R.bufferedImage;
        } else {
            GUI.bufferedPicture = null;
        }
        btPicture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FileChooser fc = new FileChooser("Open file", FileChooser.FILE_OPEN, "png, jpg, jpeg, gif", "Select a photo (*png, *jpg)");
                if (fc.isSuccess()) {
                    File file = fc.getFile();
                    GUI.bufferedPicture = loadImage(file);

                }
            }
        });
        GUI.pnPicture = new JPanel(null, true) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(GUI.bufferedPicture, 0, 0, GUI.pnPicture.getWidth(), GUI.pnPicture.getHeight(), null);
                repaint();
            }
        };

        GUI.spPicture.setViewportView(GUI.pnPicture);
        GUI.pnType.add(btPicture);
        JLabel lbTy = new JLabel();
        lbTy.setFont(new Font("tahoma", Font.BOLD, 14));
        lbTy.setBounds(GUI.spPicture.getLocation().x + GUI.spPicture.getWidth() + 10, btPicture.getLocation().y + btPicture.getHeight() + 40, 200, 30);

        switch (idType) {
            case 1:
                lbTy.setText("Thể loại : Động vật");
                height = setAddAnimal(height, ctrl);
                break;
            case 2:
                lbTy.setText("Thể loại : Ô tô");
                height = setAddCar(height, ctrl);

                break;
            case 3:
                lbTy.setText("Thể loại : Công ty");
                height = setAddCompany(height, ctrl);
                break;
            case 4:
                lbTy.setText("Thể loại : Máy tính");
                height = setAddComputer(height, ctrl);
                break;
            case 5:
                lbTy.setText("Thể loại : Quốc gia");
                height = setAddCountry(height, ctrl);

                break;
            case 6:
                lbTy.setText("Thể loại : Ẩm thực");
                height = setAddCulinary(height, ctrl);

                break;
            case 7:
                lbTy.setText("Thể loại : Xe máy");
                height = setAddMotorbike(height, ctrl);

                break;
            case 8:
                lbTy.setText("Thể loại : Con người");
                height = setAddPerson(height, ctrl);
                break;
            case 9:
                lbTy.setText("Thể loại : Điện thoại");
                height = setAddPhone(height, ctrl);

                break;
            case 10:
                lbTy.setText("Thể loại : Trường học");
                height = setAddUniver(height, ctrl);

                break;
            default:
                break;

        }
        GUI.pnType.add(lbTy);
        JButton bt = new JButton();
        if (ctrl == 0) {
            bt.setText("Thêm");
        } else {
            bt.setText("Cập nhật");
        }
        bt.setBounds(widthTF + GUI.widthLB - 75, height + 10, 80, 30);
        GUI.pnType.add(bt);
        if (height >= GUI.pnType.getPreferredSize().height) {
            height += GUI.heightGUI;
            GUI.pnType.setPreferredSize(new Dimension(GUI.pnType.getPreferredSize().width, height + GUI.heightGUI + 20));
        }

        GUI.spInfo.setViewportView(GUI.pnType);
        JScrollBar vertical = GUI.spInfo.getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String fileName;
                fileName = getInfo(idType);
                GUI.word = GUI.word.replaceAll("%", "%%");
                GUI.info = GUI.info.replaceAll("%", "%%");
                if (fileName == null) {
                    JOptionPane.showMessageDialog(null, "                                Đã có lỗi xảy ra!\n Chú ý: Hãy chắc bạn đã nhập liệu đầy đủ và đúng định dạng!");
                } else if (ctrl == 0) {
                    String dt[] = GUI.word.split("[\t]");
                    if (!searchWord(dt[1], 1).isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Từ đã có trong từ điển!");
                        return;
                    }

                    if (addWord(GUI.word, GUI.info, idType)) {
                        saveImage(fileName, GUI.bufferedPicture);
                        JOptionPane.showMessageDialog(null, "Thêm từ thành công!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Thêm từ thất bại!");
                    }
                } else {
                    String url = getUrlImage(idType, String.valueOf(GUI.defaultWord.getId()));
                    saveImage(url, GUI.bufferedPicture);
                    @SuppressWarnings("MismatchedReadAndWriteOfArray")
                    String dtInfo[] = GUI.info.split("[\t]");
                    dtInfo[3] = url;
                    GUI.info = "";
                    for (int i = 0; i < dtInfo.length; i++) {
                        if (i != dtInfo.length - 1) {
                            GUI.info += dtInfo[i] + "\t";
                        } else {
                            GUI.info += dtInfo[i];
                        }
                    }

                    if (correctWord(GUI.word, GUI.info, idType)) {
                        JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cập nhật thất bại!");
                    }
                }
            }
        });

    }

    public int setAddAnimal(int height, int ctrl) {
        int widthTF = GUI.pnInfo.getWidth() - GUI.widthLB - GUI.heightGUI;

        GUI.animalLTen = new JLabel("Tên");
        GUI.animalLLoai = new JLabel("Loài");
        GUI.animalLTrongLuong = new JLabel("Trọng lượng");
        GUI.animalLThucAn = new JLabel("Thức ăn");
        GUI.animalLDacTinh = new JLabel("Đặc tính");

        GUI.animalTTen = new JTextField();
        GUI.animalTLoai = new JTextField();
        GUI.animalTTrongLuong = new JTextField();
        GUI.animalTThucAn = new JTextField();
        GUI.animalTDacTinh = new JTextField();
        if (ctrl == 1) {
            GUI.animalTTen.setText(GUI.defaultWord.getTen());
            GUI.animalTTen.setEditable(false);
            GUI.animalTLoai.setText(R.animal.getLoai());
            GUI.animalTTrongLuong.setText(String.valueOf(R.animal.getTrongLuong()));
            GUI.animalTThucAn.setText(R.animal.getThucAn());
            GUI.animalTDacTinh.setText(R.animal.getDacTinh());

        }

        height += GUI.heightGUI;
        GUI.animalLTen.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.animalTTen.setBounds(GUI.animalLTen.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.animalLTen.getHeight() + GUI.heightGUI;

        GUI.animalLLoai.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.animalTLoai.setBounds(GUI.animalLLoai.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.animalLLoai.getHeight() + GUI.heightGUI;

        GUI.animalLTrongLuong.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.animalTTrongLuong.setBounds(GUI.animalLTrongLuong.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.animalLTrongLuong.getHeight() + GUI.heightGUI;

        GUI.animalLThucAn.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.animalTThucAn.setBounds(GUI.animalLThucAn.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.animalLThucAn.getHeight() + GUI.heightGUI;

        GUI.animalLDacTinh.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.animalTDacTinh.setBounds(GUI.animalLDacTinh.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.animalLDacTinh.getHeight() + GUI.heightGUI;

        if (height >= GUI.pnType.getPreferredSize().height) {
            height += GUI.heightGUI;
            GUI.pnType.setPreferredSize(new Dimension(GUI.pnType.getPreferredSize().width, height));
        }

        GUI.pnType.add(GUI.spPicture);

        GUI.pnType.add(GUI.animalLTen);
        GUI.pnType.add(GUI.animalLLoai);
        GUI.pnType.add(GUI.animalLTrongLuong);
        GUI.pnType.add(GUI.animalLThucAn);
        GUI.pnType.add(GUI.animalLDacTinh);

        GUI.pnType.add(GUI.animalTTen);
        GUI.pnType.add(GUI.animalTLoai);
        GUI.pnType.add(GUI.animalTTrongLuong);
        GUI.pnType.add(GUI.animalTThucAn);
        GUI.pnType.add(GUI.animalTDacTinh);

        return height;
    }

    public int setAddCar(int height, int ctrl) {
        int widthTF = GUI.pnInfo.getWidth() - GUI.widthLB - GUI.heightGUI;

        GUI.carLTen = new JLabel("Tên");
        GUI.carLHang = new JLabel("Hãng");
        GUI.carLGia = new JLabel("Gía");
        GUI.carLSoGhe = new JLabel("Số ghế");

        GUI.carTTen = new JTextField();
        GUI.carTHang = new JTextField();
        GUI.carTGia = new JTextField();
        GUI.carTSoGhe = new JTextField();
        if (ctrl == 1) {
            GUI.carTTen.setText(GUI.defaultWord.getTen());
            GUI.carTTen.setEditable(false);
            GUI.carTHang.setText(R.car.getHang());
            GUI.carTGia.setText(String.valueOf(R.car.getGia()));
            GUI.carTSoGhe.setText(String.valueOf(R.car.getSoGhe()));
        }

        height += GUI.heightGUI;
        GUI.carLTen.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.carTTen.setBounds(GUI.carLTen.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.carLTen.getHeight() + GUI.heightGUI;

        GUI.carLHang.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.carTHang.setBounds(GUI.carLHang.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.carLHang.getHeight() + GUI.heightGUI;

        GUI.carLGia.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.carTGia.setBounds(GUI.carLGia.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.carLGia.getHeight() + GUI.heightGUI;

        GUI.carLSoGhe.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.carTSoGhe.setBounds(GUI.carLSoGhe.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.carLSoGhe.getHeight() + GUI.heightGUI;

        if (height >= GUI.pnType.getPreferredSize().height) {
            height += GUI.heightGUI;
            GUI.pnType.setPreferredSize(new Dimension(GUI.pnType.getPreferredSize().width, height));
        }

        GUI.pnType.add(GUI.spPicture);

        GUI.pnType.add(GUI.carLTen);
        GUI.pnType.add(GUI.carLHang);
        GUI.pnType.add(GUI.carLGia);
        GUI.pnType.add(GUI.carLSoGhe);
        GUI.pnType.add(GUI.carTTen);
        GUI.pnType.add(GUI.carTHang);
        GUI.pnType.add(GUI.carTGia);
        GUI.pnType.add(GUI.carTSoGhe);

        return height;
    }

    public int setAddCompany(int height, int ctrl) {
        int widthTF = GUI.pnInfo.getWidth() - GUI.widthLB - GUI.heightGUI;

        GUI.companyLTen = new JLabel("Tên");
        GUI.companyLTGD = new JLabel("Tổng giám đốc");
        GUI.companyLGia = new JLabel("Gía");
        GUI.companyLLichSu = new JLabel("Lịch sử");

        GUI.companyTTen = new JTextField();
        GUI.companyTTGD = new JTextField();
        GUI.companyTGia = new JTextField();
        GUI.companyTLichSu = new JTextField();
        if (ctrl == 1) {
            GUI.companyTTen.setText(GUI.defaultWord.getTen());
            GUI.companyTTen.setEditable(false);
            GUI.companyTTGD.setText(R.company.getTGD());
            GUI.companyTGia.setText(String.valueOf(R.company.getGia()));
            GUI.companyTLichSu.setText(R.company.getLichSu());
        }
        height += GUI.heightGUI;
        GUI.companyLTen.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.companyTTen.setBounds(GUI.companyLTen.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.companyLTen.getHeight() + GUI.heightGUI;

        GUI.companyLTGD.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.companyTTGD.setBounds(GUI.companyLTGD.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.companyLTGD.getHeight() + GUI.heightGUI;

        GUI.companyLGia.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.companyTGia.setBounds(GUI.companyLGia.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.companyLGia.getHeight() + GUI.heightGUI;

        GUI.companyLLichSu.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.companyTLichSu.setBounds(GUI.companyLLichSu.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.companyLLichSu.getHeight() + GUI.heightGUI;

        if (height >= GUI.pnType.getPreferredSize().height) {
            height += GUI.heightGUI;
            GUI.pnType.setPreferredSize(new Dimension(GUI.pnType.getPreferredSize().width, height));
        }

        GUI.pnType.add(GUI.spPicture);

        GUI.pnType.add(GUI.companyLTen);
        GUI.pnType.add(GUI.companyLTGD);
        GUI.pnType.add(GUI.companyLGia);
        GUI.pnType.add(GUI.companyLLichSu);
        GUI.pnType.add(GUI.companyTTen);
        GUI.pnType.add(GUI.companyTTGD);
        GUI.pnType.add(GUI.companyTGia);
        GUI.pnType.add(GUI.companyTLichSu);
        return height;
    }

    public int setAddComputer(int height, int ctrl) {

        int widthTF = GUI.pnInfo.getWidth() - GUI.widthLB - GUI.heightGUI;

        GUI.computerLTen = new JLabel("Tên");
        GUI.computerLNSX = new JLabel("Nhà sản xuất");
        GUI.computerLModel = new JLabel("Model");
        GUI.computerLGia = new JLabel("Gía");
        GUI.computerLHDH = new JLabel("Hệ điều hành");
        GUI.computerLDoHoa = new JLabel("Đồ họa");

        GUI.computerTTen = new JTextField();
        GUI.computerTNSX = new JTextField();
        GUI.computerTModel = new JTextField();
        GUI.computerTGia = new JTextField();
        GUI.computerTHDH = new JTextField();
        GUI.computerTDoHoa = new JTextField();
        if (ctrl == 1) {
            GUI.computerTTen.setText(GUI.defaultWord.getTen());
            GUI.computerTTen.setEditable(false);
            GUI.computerTNSX.setText(R.computer.getNSX());
            GUI.computerTModel.setText(R.computer.getModel());
            GUI.computerTGia.setText(String.valueOf(R.computer.getGia()));
            GUI.computerTHDH.setText(R.computer.getHDH());
            GUI.computerTDoHoa.setText(R.computer.getDoHoa());

        }
        height += GUI.heightGUI;
        GUI.computerLTen.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.computerTTen.setBounds(GUI.computerLTen.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.computerLTen.getHeight() + GUI.heightGUI;

        GUI.computerLNSX.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.computerTNSX.setBounds(GUI.computerLNSX.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.computerLNSX.getHeight() + GUI.heightGUI;

        GUI.computerLModel.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.computerTModel.setBounds(GUI.computerLModel.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.computerLModel.getHeight() + GUI.heightGUI;

        GUI.computerLGia.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.computerTGia.setBounds(GUI.computerLGia.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.computerLGia.getHeight() + GUI.heightGUI;

        GUI.computerLHDH.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.computerTHDH.setBounds(GUI.computerLHDH.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.computerLHDH.getHeight() + GUI.heightGUI;

        GUI.computerLDoHoa.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.computerTDoHoa.setBounds(GUI.computerLDoHoa.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.computerLDoHoa.getHeight() + GUI.heightGUI;

        if (height >= GUI.pnType.getPreferredSize().height) {
            height += 10;
            GUI.pnType.setPreferredSize(new Dimension(GUI.pnType.getPreferredSize().width, height));
        }

        GUI.pnType.add(GUI.spPicture);

        GUI.pnType.add(GUI.computerLTen);
        GUI.pnType.add(GUI.computerLNSX);
        GUI.pnType.add(GUI.computerLModel);
        GUI.pnType.add(GUI.computerLGia);
        GUI.pnType.add(GUI.computerLHDH);
        GUI.pnType.add(GUI.computerLDoHoa);
        GUI.pnType.add(GUI.computerTTen);
        GUI.pnType.add(GUI.computerTNSX);
        GUI.pnType.add(GUI.computerTModel);
        GUI.pnType.add(GUI.computerTGia);
        GUI.pnType.add(GUI.computerTHDH);
        GUI.pnType.add(GUI.computerTDoHoa);

        return height;

    }

    public int setAddCountry(int height, int ctrl) {
        int widthTF = GUI.pnInfo.getWidth() - GUI.widthLB - GUI.heightGUI;

        GUI.countryLTen = new JLabel("Tên");
        GUI.countryLQuocCa = new JLabel("Quốc ca");
        GUI.countryLDanSo = new JLabel("Dân số");
        GUI.countryLDienTich = new JLabel("Diện tích ");
        GUI.countryLThuDo = new JLabel("Thủ đô");
        GUI.countryLLichSu = new JLabel("Lịch sử");

        GUI.countryTTen = new JTextField();
        GUI.countryTQuocCa = new JTextField();
        GUI.countryTDanSo = new JTextField();
        GUI.countryTDienTich = new JTextField();
        GUI.countryTThuDo = new JTextField();
        GUI.countryTLichSu = new JTextField();
        if (ctrl == 1) {
            GUI.countryTTen.setText(GUI.defaultWord.getTen());
            GUI.countryTTen.setEditable(false);
            GUI.countryTQuocCa.setText(R.country.getQuocCa());
            GUI.countryTDanSo.setText(String.valueOf(R.country.getDanSo()));
            GUI.countryTDienTich.setText(String.valueOf(R.country.getDienTich()));
            GUI.countryTThuDo.setText(R.country.getThuDo());
            GUI.countryTLichSu.setText(R.country.getLichSu());

        }

        height += GUI.heightGUI;
        GUI.countryLTen.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.countryTTen.setBounds(GUI.countryLTen.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.countryLTen.getHeight() + GUI.heightGUI;

        GUI.countryLQuocCa.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.countryTQuocCa.setBounds(GUI.countryLQuocCa.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.countryLQuocCa.getHeight() + GUI.heightGUI;

        GUI.countryLDanSo.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.countryTDanSo.setBounds(GUI.countryLDanSo.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.countryLDanSo.getHeight() + GUI.heightGUI;

        GUI.countryLDienTich.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.countryTDienTich.setBounds(GUI.countryLDienTich.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.countryLDienTich.getHeight() + GUI.heightGUI;

        GUI.countryLThuDo.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.countryTThuDo.setBounds(GUI.countryLThuDo.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.countryLThuDo.getHeight() + GUI.heightGUI;

        GUI.countryLLichSu.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.countryTLichSu.setBounds(GUI.countryLLichSu.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.countryLLichSu.getHeight() + GUI.heightGUI;

        if (height >= GUI.pnType.getPreferredSize().height) {
            height += GUI.heightGUI;
            GUI.pnType.setPreferredSize(new Dimension(GUI.pnType.getPreferredSize().width, height));
        }

        GUI.pnType.add(GUI.spPicture);

        GUI.pnType.add(GUI.countryLTen);
        GUI.pnType.add(GUI.countryLQuocCa);
        GUI.pnType.add(GUI.countryLDanSo);
        GUI.pnType.add(GUI.countryLDienTich);
        GUI.pnType.add(GUI.countryLThuDo);
        GUI.pnType.add(GUI.countryLLichSu);
        GUI.pnType.add(GUI.countryTTen);
        GUI.pnType.add(GUI.countryTQuocCa);
        GUI.pnType.add(GUI.countryTDanSo);
        GUI.pnType.add(GUI.countryTDienTich);
        GUI.pnType.add(GUI.countryTThuDo);
        GUI.pnType.add(GUI.countryTLichSu);

        return height;

    }

    public int setAddCulinary(int height, int ctrl) {
        int widthTF = GUI.pnInfo.getWidth() - GUI.widthLB - GUI.heightGUI;

        GUI.culinaryLTen = new JLabel("Tên");
        GUI.culinaryLThanhPhan = new JLabel("Thành phần");
        GUI.culinaryLDiaDiem = new JLabel("Địa điểm");
        GUI.culinaryLGia = new JLabel("Gía");

        GUI.culinaryTTen = new JTextField();
        GUI.culinaryTThanhPhan = new JTextField();
        GUI.culinaryTDiaDiem = new JTextField();
        GUI.culinaryTGia = new JTextField();
        if (ctrl == 1) {
            GUI.culinaryTTen.setText(GUI.defaultWord.getTen());
            GUI.culinaryTTen.setEditable(false);
            GUI.culinaryTThanhPhan.setText(R.culinary.getThanhPhan());
            GUI.culinaryTDiaDiem.setText(R.culinary.getDiaDiem());
            GUI.culinaryTGia.setText(String.valueOf(R.culinary.getGia()));
        }

        height += GUI.heightGUI;
        GUI.culinaryLTen.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.culinaryTTen.setBounds(GUI.culinaryLTen.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.culinaryLTen.getHeight() + GUI.heightGUI;

        GUI.culinaryLThanhPhan.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.culinaryTThanhPhan.setBounds(GUI.culinaryLThanhPhan.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.culinaryLThanhPhan.getHeight() + GUI.heightGUI;

        GUI.culinaryLDiaDiem.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.culinaryTDiaDiem.setBounds(GUI.culinaryLDiaDiem.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.culinaryLDiaDiem.getHeight() + GUI.heightGUI;

        GUI.culinaryLGia.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.culinaryTGia.setBounds(GUI.culinaryLGia.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.culinaryLGia.getHeight() + GUI.heightGUI;

        if (height >= GUI.pnType.getPreferredSize().height) {
            height += GUI.heightGUI;
            GUI.pnType.setPreferredSize(new Dimension(GUI.pnType.getPreferredSize().width, height));
        }

        GUI.pnType.add(GUI.spPicture);

        GUI.pnType.add(GUI.culinaryLTen);
        GUI.pnType.add(GUI.culinaryLThanhPhan);
        GUI.pnType.add(GUI.culinaryLDiaDiem);
        GUI.pnType.add(GUI.culinaryLGia);

        GUI.pnType.add(GUI.culinaryTTen);
        GUI.pnType.add(GUI.culinaryTThanhPhan);
        GUI.pnType.add(GUI.culinaryTDiaDiem);
        GUI.pnType.add(GUI.culinaryTGia);

        return height;
    }

    public int setAddMotorbike(int height, int ctrl) {
        int widthTF = GUI.pnInfo.getWidth() - GUI.widthLB - GUI.heightGUI;

        GUI.motorbikeLTen = new JLabel("Tên");
        GUI.motorbikeLHang = new JLabel("Hãng");
        GUI.motorbikeLGia = new JLabel("Gía");

        GUI.motorbikeTTen = new JTextField();
        GUI.motorbikeTHang = new JTextField();
        GUI.motorbikeTGia = new JTextField();

        if (ctrl == 1) {
            GUI.motorbikeTTen.setText(GUI.defaultWord.getTen());
            GUI.motorbikeTTen.setEditable(false);
            GUI.motorbikeTHang.setText(R.motorbike.getHang());
            GUI.motorbikeTGia.setText(String.valueOf(R.motorbike.getGia()));

        }

        height += GUI.heightGUI;
        GUI.motorbikeLTen.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.motorbikeTTen.setBounds(GUI.motorbikeLTen.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.motorbikeLTen.getHeight() + GUI.heightGUI;

        GUI.motorbikeLHang.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.motorbikeTHang.setBounds(GUI.motorbikeLHang.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.motorbikeLHang.getHeight() + GUI.heightGUI;

        GUI.motorbikeLGia.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.motorbikeTGia.setBounds(GUI.motorbikeLGia.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.motorbikeLGia.getHeight() + GUI.heightGUI;

        if (height >= GUI.pnType.getPreferredSize().height) {
            height += GUI.heightGUI;
            GUI.pnType.setPreferredSize(new Dimension(GUI.pnType.getPreferredSize().width, height));
        }

        GUI.pnType.add(GUI.spPicture);

        GUI.pnType.add(GUI.motorbikeLTen);
        GUI.pnType.add(GUI.motorbikeLHang);
        GUI.pnType.add(GUI.motorbikeLGia);

        GUI.pnType.add(GUI.motorbikeTTen);
        GUI.pnType.add(GUI.motorbikeTHang);
        GUI.pnType.add(GUI.motorbikeTGia);

        return height;

    }

    public int setAddPerson(int height, int ctrl) {

        int widthTF = GUI.pnInfo.getWidth() - GUI.widthLB - GUI.heightGUI;

        GUI.personLTen = new JLabel("Tên");
        GUI.personLNgaySinh = new JLabel("Ngày sinh");
        GUI.personLQueQuan = new JLabel("Quê quán");
        GUI.personLCongViec = new JLabel("Công việc");

        GUI.personTTen = new JTextField();
        GUI.personTNgaySinh = new JTextField();
        GUI.personTQueQuan = new JTextField();
        GUI.personTCongViec = new JTextField();
        if (ctrl == 1) {
            GUI.personTTen.setText(GUI.defaultWord.getTen());
            GUI.personTTen.setEditable(false);
            GUI.personTNgaySinh.setText(R.person.getNgaySinh());
            GUI.personTQueQuan.setText(R.person.getQueQuan());
            GUI.personTCongViec.setText(R.person.getCongViec());
        }

        height += GUI.heightGUI;
        GUI.personLTen.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.personTTen.setBounds(GUI.personLTen.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.personLTen.getHeight() + GUI.heightGUI;

        GUI.personLNgaySinh.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.personTNgaySinh.setBounds(GUI.personLNgaySinh.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.personLNgaySinh.getHeight() + GUI.heightGUI;

        GUI.personLQueQuan.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.personTQueQuan.setBounds(GUI.personLQueQuan.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.personLQueQuan.getHeight() + GUI.heightGUI;

        GUI.personLCongViec.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.personTCongViec.setBounds(GUI.personLCongViec.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.personLCongViec.getHeight() + GUI.heightGUI;

        if (height >= GUI.pnType.getPreferredSize().height) {
            height += GUI.heightGUI;
            GUI.pnType.setPreferredSize(new Dimension(GUI.pnType.getPreferredSize().width, height));
        }

        GUI.pnType.add(GUI.spPicture);

        GUI.pnType.add(GUI.personLTen);
        GUI.pnType.add(GUI.personLQueQuan);
        GUI.pnType.add(GUI.personLNgaySinh);
        GUI.pnType.add(GUI.personLCongViec);
        GUI.pnType.add(GUI.personTTen);
        GUI.pnType.add(GUI.personTQueQuan);
        GUI.pnType.add(GUI.personTNgaySinh);
        GUI.pnType.add(GUI.personTCongViec);

        return height;

    }

    public int setAddPhone(int height, int ctrl) {

        int widthTF = GUI.pnInfo.getWidth() - GUI.widthLB - GUI.heightGUI;

        GUI.phoneLTen = new JLabel("Tên");
        GUI.phoneLNSX = new JLabel("Nhà sản xuất");
        GUI.phoneLModel = new JLabel("Model");
        GUI.phoneLGia = new JLabel("Gía");
        GUI.phoneLHDH = new JLabel("Hệ điều hành");

        GUI.phoneTTen = new JTextField();
        GUI.phoneTNSX = new JTextField();
        GUI.phoneTModel = new JTextField();
        GUI.phoneTGia = new JTextField();
        GUI.phoneTHDH = new JTextField();
        if (ctrl == 1) {
            GUI.phoneTTen.setText(GUI.defaultWord.getTen());
            GUI.phoneTTen.setEditable(false);
            GUI.phoneTNSX.setText(R.phone.getNSX());
            GUI.phoneTModel.setText(R.phone.getModel());
            GUI.phoneTGia.setText(String.valueOf(R.phone.getGia()));
            GUI.phoneTHDH.setText(R.phone.getHDH());
        }
        height += GUI.heightGUI;
        GUI.phoneLTen.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.phoneTTen.setBounds(GUI.phoneLTen.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.phoneLTen.getHeight() + GUI.heightGUI;

        GUI.phoneLNSX.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.phoneTNSX.setBounds(GUI.phoneLNSX.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.phoneLNSX.getHeight() + GUI.heightGUI;

        GUI.phoneLModel.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.phoneTModel.setBounds(GUI.phoneLModel.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.phoneLModel.getHeight() + GUI.heightGUI;

        GUI.phoneLGia.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.phoneTGia.setBounds(GUI.phoneLGia.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.phoneLGia.getHeight() + GUI.heightGUI;

        GUI.phoneLHDH.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.phoneTHDH.setBounds(GUI.phoneLHDH.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.phoneLHDH.getHeight() + GUI.heightGUI;

        if (height >= GUI.pnType.getPreferredSize().height) {
            height += GUI.heightGUI;
            GUI.pnType.setPreferredSize(new Dimension(GUI.pnType.getPreferredSize().width, height));
        }

        GUI.pnType.add(GUI.spPicture);

        GUI.pnType.add(GUI.phoneLTen);
        GUI.pnType.add(GUI.phoneLNSX);
        GUI.pnType.add(GUI.phoneLModel);
        GUI.pnType.add(GUI.phoneLGia);

        GUI.pnType.add(GUI.phoneLHDH);
        GUI.pnType.add(GUI.phoneTTen);
        GUI.pnType.add(GUI.phoneTNSX);
        GUI.pnType.add(GUI.phoneTModel);
        GUI.pnType.add(GUI.phoneTGia);

        GUI.pnType.add(GUI.phoneTHDH);

        return height;

    }

    public int setAddUniver(int height, int ctrl) {

        int widthTF = GUI.pnInfo.getWidth() - GUI.widthLB - GUI.heightGUI;

        GUI.univerLTen = new JLabel("Tên");
        GUI.univerLHieuTruong = new JLabel("Hiệu trưởng");
        GUI.univerLNganh = new JLabel("Ngành");
        GUI.univerLLichSu = new JLabel("Lịch sử");
        GUI.univerLSoluongSV = new JLabel("Số lượng SV");

        GUI.univerTTen = new JTextField();
        GUI.univerTHieuTruong = new JTextField();
        GUI.univerTNganh = new JTextField();
        GUI.univerTLichSu = new JTextField();
        GUI.univerTSoLuongSV = new JTextField();
        if (ctrl == 1) {
            GUI.univerTTen.setText(GUI.defaultWord.getTen());
            GUI.univerTTen.setEditable(false);
            GUI.univerTHieuTruong.setText(R.university.getHieuTruong());
            GUI.univerTNganh.setText(R.university.getNganh());
            GUI.univerTLichSu.setText(R.university.getLichSu());
            GUI.univerTSoLuongSV.setText(String.valueOf(R.university.getSoLuongSV()));

        }

        height += GUI.heightGUI;
        GUI.univerLTen.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.univerTTen.setBounds(GUI.univerLTen.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.univerLTen.getHeight() + GUI.heightGUI;

        GUI.univerLHieuTruong.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.univerTHieuTruong.setBounds(GUI.univerLHieuTruong.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.univerLHieuTruong.getHeight() + GUI.heightGUI;

        GUI.univerLNganh.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.univerTNganh.setBounds(GUI.univerLNganh.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.univerLNganh.getHeight() + GUI.heightGUI;

        GUI.univerLLichSu.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.univerTLichSu.setBounds(GUI.univerLLichSu.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.univerLLichSu.getHeight() + GUI.heightGUI;

        GUI.univerLSoluongSV.setBounds(5, height + GUI.heightGUI, GUI.widthLB, GUI.heightGUI);
        GUI.univerTSoLuongSV.setBounds(GUI.univerLSoluongSV.getWidth() + 5, height + GUI.heightGUI, widthTF, GUI.heightGUI);
        height += GUI.univerLSoluongSV.getHeight() + GUI.heightGUI;

        if (height >= GUI.pnType.getPreferredSize().height) {
            height += GUI.heightGUI;
            GUI.pnType.setPreferredSize(new Dimension(GUI.pnType.getPreferredSize().width, height));
        }

        GUI.pnType.add(GUI.spPicture);

        GUI.pnType.add(GUI.univerLTen);
        GUI.pnType.add(GUI.univerLHieuTruong);
        GUI.pnType.add(GUI.univerLNganh);
        GUI.pnType.add(GUI.univerLLichSu);
        GUI.pnType.add(GUI.univerLSoluongSV);

        GUI.pnType.add(GUI.univerTTen);
        GUI.pnType.add(GUI.univerTHieuTruong);
        GUI.pnType.add(GUI.univerTNganh);
        GUI.pnType.add(GUI.univerTLichSu);
        GUI.pnType.add(GUI.univerTSoLuongSV);

        return height;

    }

    public String getInfo(int idType) {

        String urlSys = System.getProperty("user.dir", null);
        String urlText = urlSys + "\\data\\text\\word.txt";
        String maxID = String.valueOf(getMaxID(urlText));
        String url = "\\data\\image";
        try {
            switch (idType) {
                case 1:
                    url += "\\animal\\" + maxID + ".jpg";
                    GUI.word = maxID + "\t" + GUI.animalTTen.getText() + "\t" + String.valueOf(idType);
                    GUI.info = maxID + "\t" + String.valueOf(idType) + "\tĐộng vật\t" + url + "\t" + GUI.animalTLoai.getText() + "\t" + GUI.animalTTrongLuong.getText() + "\t"
                            + GUI.animalTThucAn.getText() + "\t" + GUI.animalTDacTinh.getText();
                    break;
                case 2:
                    url += "\\car\\" + maxID + ".jpg";
                    GUI.word = maxID + "\t" + GUI.carTTen.getText() + "\t" + String.valueOf(idType);
                    GUI.info = maxID + "\t" + String.valueOf(idType) + "\tÔ tô\t" + url + "\t" + GUI.carTHang.getText() + "\t" + GUI.carTGia.getText()
                            + "\t" + GUI.carTSoGhe.getText();
                    break;
                case 3:
                    url += "\\company\\" + maxID + ".jpg";
                    GUI.word = maxID + "\t" + GUI.companyTTen.getText() + "\t" + String.valueOf(idType);
                    GUI.info = maxID + "\t" + String.valueOf(idType) + "\tCông ty\t" + url + "\t" + GUI.companyTTGD.getText() + "\t" + GUI.companyTGia.getText()
                            + "\t" + GUI.companyTLichSu.getText();
                    break;
                case 4:
                    url += "\\computer\\" + maxID + ".jpg";
                    GUI.word = maxID + "\t" + GUI.computerTTen.getText() + "\t" + String.valueOf(idType);
                    GUI.info = maxID + "\t" + String.valueOf(idType) + "\tMáy tính\t" + url + "\t" + GUI.computerTNSX.getText() + "\t" + GUI.computerTModel.getText() + "\t"
                            + GUI.computerTGia.getText() + "\t" + GUI.computerTHDH.getText() + "\t" + GUI.computerTDoHoa.getText();
                    break;
                case 5:
                    url += "\\country\\" + maxID + ".jpg";
                    GUI.word = maxID + "\t" + GUI.countryTTen.getText() + "\t" + String.valueOf(idType);
                    GUI.info = maxID + "\t" + String.valueOf(idType) + "\tQuốc gia\t" + url + "\t" + GUI.countryTQuocCa.getText() + "\t" + GUI.countryTDanSo.getText() + "\t"
                            + GUI.countryTDienTich.getText() + "\t" + GUI.countryTThuDo.getText() + "\t" + GUI.countryTLichSu.getText();
                    break;
                case 6:
                    url += "\\culinary\\" + maxID + ".jpg";
                    GUI.word = maxID + "\t" + GUI.culinaryTTen.getText() + "\t" + String.valueOf(idType);
                    GUI.info = maxID + "\t" + String.valueOf(idType) + "\tẨm thực\t" + url + "\t" + GUI.culinaryTThanhPhan.getText() + "\t" + GUI.culinaryTDiaDiem.getText() + "\t"
                            + GUI.culinaryTGia.getText();
                    break;
                case 7:
                    url += "\\motorbike\\" + maxID + ".jpg";
                    GUI.word = maxID + "\t" + GUI.motorbikeTTen.getText() + "\t" + String.valueOf(idType);
                    GUI.info = maxID + "\t" + String.valueOf(idType) + "\tXe máy\t" + url + "\t" + GUI.motorbikeTHang.getText() + "\t" + GUI.motorbikeTGia.getText();
                    break;
                case 8:
                    url += "\\person\\" + maxID + ".jpg";
                    GUI.word = maxID + "\t" + GUI.personTTen.getText() + "\t" + String.valueOf(idType);
                    GUI.info = maxID + "\t" + String.valueOf(idType) + "\tCon người\t" + url + "\t" + GUI.personTNgaySinh.getText() + "\t" + GUI.personTQueQuan.getText() + "\t"
                            + GUI.personTCongViec.getText();
                    break;
                case 9:
                    url += "\\phone\\" + maxID + ".jpg";
                    GUI.word = maxID + "\t" + GUI.phoneTTen.getText() + "\t" + String.valueOf(idType);
                    GUI.info = maxID + "\t" + String.valueOf(idType) + "\tĐiện thoại\t" + url + "\t" + GUI.phoneTNSX.getText() + "\t" + GUI.phoneTModel.getText() + "\t"
                            + GUI.phoneTGia.getText() + "\t" + GUI.phoneTHDH.getText();
                    break;
                case 10:
                    url += "\\university\\" + maxID + ".jpg";
                    GUI.word = maxID + "\t" + GUI.univerTTen.getText() + "\t" + String.valueOf(idType);
                    GUI.info = maxID + "\t" + String.valueOf(idType) + "\tTrường học\t" + url + "\t" + GUI.univerTHieuTruong.getText() + "\t" + GUI.univerTNganh.getText() + "\t"
                            + GUI.univerTLichSu.getText() + "\t" + GUI.univerTSoLuongSV.getText();
                    break;
                default:
                    break;

            }

            String dt[] = GUI.info.split("[\t]");
            int i;
            for (i = 0; i < dt.length; i++) {
                if (dt[i] == null || dt[i].equals("")) {
                    return null;
                }
            }

            if (GUI.bufferedPicture == null) {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        return url;

    }

    public String getUrlImage(int idType, String id) {
        String url = "";
        url += "\\data\\image\\";
        switch (idType) {
            case 1:
                url += "animal\\" + id;
                R.animal.setAnh(url);
                break;
            case 2:
                url += "car\\" + id;
                R.car.setAnh(url);
                break;
            case 3:
                url += "company\\" + id;
                R.company.setAnh(url);
                break;
            case 4:
                url += "computer\\" + id;
                R.computer.setAnh(url);
                break;
            case 5:
                url += "country\\" + id;
                R.country.setAnh(url);
                break;
            case 6:
                url += "culinary\\" + id;
                R.culinary.setAnh(url);
                break;
            case 7:
                url += "motorbike\\" + id;
                R.motorbike.setAnh(url);
                break;
            case 8:
                url += "person\\" + id;
                R.person.setAnh(url);
                break;
            case 9:
                url += "phone\\" + id;
                R.phone.setAnh(url);
                break;
            case 10:
                url += "university\\" + id;
                R.university.setAnh(url);
                break;

        }
        return url + ".jpg";
    }

    public BufferedImage loadImage(File file) {
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            return bufferedImage;
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void saveImage(String fileName, BufferedImage bufferedImage) {
        if (bufferedImage != null) {
            String url = System.getProperty("user.dir", null);
            fileName = url + fileName;
            File file = new File(fileName);
            if (file.exists()) {
                file.delete();
            }
            try {
                ImageIO.write(bufferedImage, "jpg", file);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
