/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import object.Animal;
import object.Car;
import object.Company;
import object.Computer;
import object.Country;
import object.Culinary;
import object.Motorbike;
import object.Person;
import object.Phone;
import object.R;
import object.University;
import object.Word;
import view.GUI;



/**
 *
 * @author TIENNH
 */
public class Data extends AbstractData {

    @SuppressWarnings("UnusedAssignment")
    @Override
    public void readData(String name, int type) {
        try {
            FileInputStream fi = new FileInputStream(name);
            InputStreamReader isr = new InputStreamReader(fi, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String s;
            switch (type) {
                case -2:
                    while ((s = br.readLine()) != null) {
                        s = s.replace("\ufeff", "");
                        String dt[] = s.split("[\t]");
                        if (dt.length == 3) {
                            Word word = new Word(Integer.parseInt(dt[0]), dt[1], Integer.parseInt(dt[2]));
                            R.hHistory.put(Integer.parseInt(dt[0]), word);
                        }
                    }
                    break;
                case -1:
                    while ((s = br.readLine()) != null) {
                        s = s.replace("\ufeff", "");
                        String dt[] = s.split("[\t]");
                        if (dt.length == 3) {
                            Word word = new Word(Integer.parseInt(dt[0]), dt[1], Integer.parseInt(dt[2]));
                            R.hBookmark.put(Integer.parseInt(dt[0]), word);
                        }
                    }
                    break;
                case 0:
                    while ((s = br.readLine()) != null) {
                        s = s.replace("\ufeff", "");
                        String dt[] = s.split("[\t]");
                        if (dt.length == 3) {

                            Word word = new Word(Integer.parseInt(dt[0]), dt[1], Integer.parseInt(dt[2]));
                            R.hWord.put(Integer.parseInt(dt[0]), word);
                        }
                    }
                    break;
                case 1:
                    while ((s = br.readLine()) != null) {
                        s = s.replace("\ufeff", "");
                        String dt[] = s.split("[\t]");
                        if (dt.length == 8) {
                            Animal animal = new Animal(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), dt[2], dt[3], dt[4], (dt[5]), dt[6], dt[7]);
                            R.hAnimal.put(Integer.parseInt(dt[0]), animal);
                        }
                    }
                    break;
                case 2:
                    while ((s = br.readLine()) != null) {
                        s = s.replace("\ufeff", "");
                        String dt[] = s.split("[\t]");
                        if (dt.length == 7) {
                            Car car = new Car(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), dt[2], dt[3], dt[4], (dt[5]), dt[6]);
                            R.hCar.put(Integer.parseInt(dt[0]), car);
                        }
                    }
                    break;
                case 3:
                    while ((s = br.readLine()) != null) {
                        s = s.replace("\ufeff", "");
                        String dt[] = s.split("[\t]");
                        if (dt.length == 7) {
                            Company company = new Company(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), dt[2], dt[3], dt[4], (dt[5]), dt[6]);
                            R.hCompany.put(Integer.parseInt(dt[0]), company);
                        }
                    }
                    break;
                case 4:
                    while ((s = br.readLine()) != null) {
                        s = s.replace("\ufeff", "");
                        String dt[] = s.split("[\t]");
                        if (dt.length == 9) {
                            Computer computer = new Computer(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), dt[2], dt[3], dt[4], dt[5], (dt[6]), dt[7], dt[8]);
                            R.hComputer.put(Integer.parseInt(dt[0]), computer);
                        }
                    }
                    break;
                case 5:
                    while ((s = br.readLine()) != null) {
                        s = s.replace("\ufeff", "");
                        String dt[] = s.split("[\t]");
                        if (dt.length == 9) {
                            Country country = new Country(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), dt[2], dt[3], dt[4], (dt[5]), (dt[6]), dt[7], dt[8]);
                            R.hCountry.put(Integer.parseInt(dt[0]), country);
                        }
                    }
                    break;
                case 6:
                    while ((s = br.readLine()) != null) {
                        s = s.replace("\ufeff", "");
                        String dt[] = s.split("[\t]");
                        if (dt.length == 7) {
                            Culinary culinary = new Culinary(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), dt[2], dt[3], dt[4], dt[5], (dt[6]));
                            R.hCulinary.put(Integer.parseInt(dt[0]), culinary);
                        }
                    }
                    break;
                case 7:
                    while ((s = br.readLine()) != null) {
                        s = s.replace("\ufeff", "");
                        String dt[] = s.split("[\t]");
                        if (dt.length == 6) {
                            Motorbike motorbike = new Motorbike(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), dt[2], dt[3], dt[4], (dt[5]));
                            R.hMotorbike.put(Integer.parseInt(dt[0]), motorbike);
                        }
                    }
                    break;
                case 8:
                    while ((s = br.readLine()) != null) {
                        s = s.replace("\ufeff", "");
                        String dt[] = s.split("[\t]");
                        if (dt.length == 7) {
                            Person person = new Person(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), dt[2], dt[3], dt[4], dt[5], dt[6]);
                            R.hPerson.put(Integer.parseInt(dt[0]), person);
                        }
                    }
                    break;
                case 9:
                    while ((s = br.readLine()) != null) {
                        s = s.replace("\ufeff", "");
                        String dt[] = s.split("[\t]");
                        if (dt.length == 8) {
                            Phone phone = new Phone(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), dt[2], dt[3], dt[4], dt[5], (dt[6]), dt[7]);
                            R.hPhone.put(Integer.parseInt(dt[0]), phone);
                        }
                    }
                    break;
                case 10:
                    while ((s = br.readLine()) != null) {
                        s = s.replace("\ufeff", "");
                        String dt[] = s.split("[\t]");
                        if (dt.length == 8) {
                            University university = new University(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), dt[2], dt[3], dt[4], dt[5], dt[6], dt[7]);
                            R.hUniversity.put(Integer.parseInt(dt[0]), university);
                        }
                    }
                    break;
                default:
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings({"ConvertToTryWithResources", "override"})
    public void writeData(String fileName, String text) {
        try {
            FileOutputStream fo = new FileOutputStream(fileName);
            OutputStreamWriter osw = new OutputStreamWriter(fo, "utf-8");
            osw.write(text);
            osw.flush();
            fo.close();
        } catch (IOException exc) {
            System.out.println("Có lỗi xảy ra");
        }
    }

    @Override
    public DefaultListModel<Word> searchWord(String ten, int ctrl) {
        DefaultListModel<Word> modelWord = new DefaultListModel<>();
        String temp;
        Collection<Word> words = R.hWord.values();
        switch (ctrl) {
            case 0:
                ten = ten.toLowerCase();
                for (Word word : words) {
                    temp = word.getTen().toLowerCase();
                    if (temp.contains(ten)) {
                        modelWord.addElement(word);
                    }
                }

                break;
            case 1:
                for (Word word : words) {
                    temp = word.getTen();
                    if (temp.equalsIgnoreCase(ten)) {
                        modelWord.addElement(word);
                    }
                }

                break;
        }
        return modelWord;
    }

    @Override
    @SuppressWarnings("SuspiciousIndentAfterControlStatement")
    public void searchInfoWord(int id, int idType) {
        switch (idType) {
            case 1:
                if (R.hAnimal.containsKey(id)) {
                    R.animal = R.hAnimal.get(id);
                }
                return;
            case 2:
                if (R.hCar.containsKey(id)) {
                    R.car = R.hCar.get(id);
                }
                return;
            case 3:
                if (R.hCompany.containsKey(id)) {
                    R.company = R.hCompany.get(id);
                }
                return;
            case 4:
                if (R.hComputer.containsKey(id)) {
                    R.computer = R.hComputer.get(id);
                }
                return;
            case 5:
                if (R.hCountry.containsKey(id)) {
                    R.country = R.hCountry.get(id);
                }
                return;
            case 6:
                if (R.hCulinary.containsKey(id)) {
                    R.culinary = R.hCulinary.get(id);
                }
                return;
            case 7:
                if (R.hMotorbike.containsKey(id)) {
                    R.motorbike = R.hMotorbike.get(id);
                }
                return;
            case 8:
                if (R.hPerson.containsKey(id)) {
                    R.person = R.hPerson.get(id);
                }
                return;
            case 9:
                if (R.hPhone.containsKey(id)) {
                    R.phone = R.hPhone.get(id);
                }
                return;
            case 10:
                if (R.hUniversity.containsKey(id)) {
                    R.university = R.hUniversity.get(id);
                }
            default:
                break;
        }
    }

    @Override
    public Word searchWord(int id) {
        if (R.hWord.containsKey(id)) {
            return R.hWord.get(id);
        }
        return null;
    }

    @Override
    public ArrayList<Integer> searchInterdepend(int idType) {
        ArrayList<Integer> arrInt = new ArrayList<>();
        Collection<Integer> integers;
        Iterator<Integer> it;
        switch (idType) {
            case 1:
                integers = R.hAnimal.keySet();
                for (it = integers.iterator(); it.hasNext();) {
                    int integer = it.next();
                    arrInt.add(integer);
                }
                return arrInt;
            case 2:
                integers = R.hCar.keySet();
                for (it = integers.iterator(); it.hasNext();) {
                    int integer = it.next();
                    arrInt.add(integer);
                }
                return arrInt;
            case 3:
                integers = R.hCompany.keySet();
                for (it = integers.iterator(); it.hasNext();) {
                    int integer = it.next();
                    arrInt.add(integer);
                }
                return arrInt;
            case 4:
                integers = R.hComputer.keySet();
                for (it = integers.iterator(); it.hasNext();) {
                    int integer = it.next();
                    arrInt.add(integer);
                }
                return arrInt;
            case 5:
                integers = R.hCountry.keySet();
                for (it = integers.iterator(); it.hasNext();) {
                    int integer = it.next();
                    arrInt.add(integer);
                }
                return arrInt;
            case 6:
                integers = R.hCulinary.keySet();
                for (it = integers.iterator(); it.hasNext();) {
                    int integer = it.next();
                    arrInt.add(integer);
                }
                return arrInt;
            case 7:
                integers = R.hMotorbike.keySet();
                for (it = integers.iterator(); it.hasNext();) {
                    int integer = it.next();
                    arrInt.add(integer);
                }
                return arrInt;
            case 8:
                integers = R.hPerson.keySet();
                for (it = integers.iterator(); it.hasNext();) {
                    int integer = it.next();
                    arrInt.add(integer);
                }
                return arrInt;
            case 9:
                integers = R.hPhone.keySet();
                for (it = integers.iterator(); it.hasNext();) {
                    int integer = it.next();
                    arrInt.add(integer);
                }
                return arrInt;
            case 10:
                integers = R.hUniversity.keySet();
                for (it = integers.iterator(); it.hasNext();) {
                    int integer = it.next();
                    arrInt.add(integer);
                }
                return arrInt;
            default:
                return null;
        }
    }

    @Override
    public Word searchHistory(String ten) {
        Collection<Word> words = R.hHistory.values();
        String temp;
        ten = ten.toLowerCase();
        for (Word word : words) {
            temp = word.getTen().toLowerCase();
            if (temp.equalsIgnoreCase(ten)) {
                return word;
            }
        }
        return null;
    }

    @Override
    public boolean addHistory(Word word1) {
        if (searchHistory(word1.getTen()) != null) {
            delHistory(word1.getTen());
        }
        @SuppressWarnings("UnusedAssignment")
        FileWriter fw = null;
        try {
            R.hHistory.put(word1.getId(), word1);
            String url = System.getProperty("user.dir", null);
            String urlData = url + "\\data\\text\\history.txt";

            String text;
            text = "";
            Collection<Word> words = R.hHistory.values();
            Iterator<Word> it;
            for (it = words.iterator(); it.hasNext();) {
                Word word = it.next();
                text += String.valueOf(word.getId()) + "\t" + word.getTen() + "\t" + String.valueOf(word.getIdType()) + "\n";
            }
            writeData(urlData, text);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public boolean delHistory(String name) {
        @SuppressWarnings("UnusedAssignment")
        FileWriter fw = null;
        try {
            Word word1 = searchHistory(name);
            R.hHistory.remove(word1.getId(), word1);
            String url = System.getProperty("user.dir", null);
            String urlData = url + "\\data\\text\\history.txt";

            String text = "";
            Iterator<Word> it;
            Collection<Word> words = R.hHistory.values();
            for (it = words.iterator(); it.hasNext();) {
                Word word = it.next();
                text += String.valueOf(word.getId()) + "\t" + word.getTen() + "\t" + String.valueOf(word.getIdType()) + "\n";

            }
            writeData(urlData, text);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Word searchBookmark(String ten) {
        Collection<Word> words = R.hBookmark.values();
        String temp;
        ten = ten.toLowerCase();
        for (Word word : words) {
            temp = word.getTen().toLowerCase();
            if (temp.equalsIgnoreCase(ten)) {
                return word;
            }
        }
        return null;
    }

    @Override
    public boolean addBookmark(Word word1) {

        if (searchBookmark(word1.getTen()) != null) {
            return false;
        }
        @SuppressWarnings("UnusedAssignment")
        FileWriter fw = null;
        try {
            R.hBookmark.put(word1.getId(), word1);
            String url = System.getProperty("user.dir", null);
            String urlData = url + "\\data\\text\\bookmark.txt";

            String text;
            text = "";
            Collection<Word> words = R.hBookmark.values();
            Iterator<Word> it;
            for (it = words.iterator(); it.hasNext();) {
                Word word = it.next();
                text += String.valueOf(word.getId()) + "\t" + word.getTen() + "\t" + String.valueOf(word.getIdType()) + "\n";
            }
            writeData(urlData, text);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delBookmark(String name) {
        @SuppressWarnings("UnusedAssignment")
        FileWriter fw = null;
        try {
            Word word1 = searchBookmark(name);
            R.hBookmark.remove(word1.getId(), word1);
            String url = System.getProperty("user.dir", null);
            String urlData = url + "\\data\\text\\bookmark.txt";

            String text = "";
            Iterator<Word> it;
            Collection<Word> words = R.hBookmark.values();
            for (it = words.iterator(); it.hasNext();) {
                Word word = it.next();
                text += String.valueOf(word.getId()) + "\t" + word.getTen() + "\t" + String.valueOf(word.getIdType()) + "\n";

            }
            writeData(urlData, text);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    @SuppressWarnings({"UnusedAssignment", "ConvertToTryWithResources"})
    public boolean addWord(String word, String info, int idType) {
        try {
            String url = System.getProperty("user.dir", null);
            String urlText = "";
            @SuppressWarnings("MismatchedReadAndWriteOfArray")
            String dt[] = info.split("[\t]");
            int i;
            for (i = 0; i < dt.length; i++) {
                if (dt[i] == null || dt[i].equals("")) {
                    return false;
                }
            }
            Animal animal = null;
            Car car = null;
            Company company = null;
            Computer computer = null;
            Country country = null;
            Culinary culinary = null;
            Motorbike motorbike = null;
            Person person = null;
            Phone phone = null;
            University university = null;
            switch (idType) {
                case 1:
                    urlText = url + "\\data\\text\\animal.txt";
                    animal = new Animal(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), dt[2], dt[3], dt[4], (dt[5]), dt[6], dt[7]);
                    break;
                case 2:
                    urlText = url + "\\data\\text\\car.txt";
                    car = new Car(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), dt[2], dt[3], dt[4], (dt[5]), dt[6]);
                    break;
                case 3:
                    urlText = url + "\\data\\text\\company.txt";
                    company = new Company(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), dt[2], dt[3], dt[4], (dt[5]), dt[6]);
                    break;
                case 4:
                    urlText = url + "\\data\\text\\computer.txt";
                    computer = new Computer(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), dt[2], dt[3], dt[4], dt[5], (dt[6]), dt[7], dt[8]);

                    break;
                case 5:
                    urlText = url + "\\data\\text\\country.txt";
                    country = new Country(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), dt[2], dt[3], dt[4], (dt[5]), (dt[6]), dt[7], dt[8]);

                    break;
                case 6:
                    urlText = url + "\\data\\text\\culinary.txt";
                    culinary = new Culinary(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), dt[2], dt[3], dt[4], dt[5], (dt[6]));

                    break;
                case 7:
                    urlText = url + "\\data\\text\\motorbike.txt";
                    motorbike = new Motorbike(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), dt[2], dt[3], dt[4], dt[5]);

                    break;
                case 8:
                    urlText = url + "\\data\\text\\person.txt";
                    person = new Person(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), dt[2], dt[3], dt[4], dt[5], dt[6]);

                    break;
                case 9:
                    urlText = url + "\\data\\text\\phone.txt";
                    phone = new Phone(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), dt[2], dt[3], dt[4], dt[5], (dt[6]), dt[7]);

                    break;
                case 10:
                    urlText = url + "\\data\\text\\university.txt";
                    university = new University(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), dt[2], dt[3], dt[4], dt[5], dt[6], (dt[7]));
                    break;
                default:
                    break;

            }
            FileOutputStream fo = new FileOutputStream(urlText, true);
            OutputStreamWriter osw = new OutputStreamWriter(fo, "utf-8");
            osw.write(info + "\n");
            osw.flush();
            fo.close();

            switch (idType) {
                case 1:
                    R.hAnimal.put(Integer.parseInt(dt[0]), animal);
                    break;
                case 2:
                    R.hCar.put(Integer.parseInt(dt[0]), car);
                    break;
                case 3:
                    R.hCompany.put(Integer.parseInt(dt[0]), company);

                    break;
                case 4:
                    R.hComputer.put(Integer.parseInt(dt[0]), computer);
                    break;
                case 5:
                    R.hCountry.put(Integer.parseInt(dt[0]), country);
                    break;
                case 6:
                    R.hCulinary.put(Integer.parseInt(dt[0]), culinary);
                    break;
                case 7:
                    R.hMotorbike.put(Integer.parseInt(dt[0]), motorbike);
                    break;
                case 8:
                    R.hPerson.put(Integer.parseInt(dt[0]), person);
                    break;
                case 9:
                    R.hPhone.put(Integer.parseInt(dt[0]), phone);
                    break;
                case 10:
                    R.hUniversity.put(Integer.parseInt(dt[0]), university);
                    break;

            }
            urlText = url + "\\data\\text\\word.txt";
            fo = new FileOutputStream(urlText, true);
            osw = new OutputStreamWriter(fo, "utf-8");
            osw.write(word + "\n");
            osw.flush();
            fo.close();

            dt = word.split("[\t]");
            Word word1 = new Word(Integer.parseInt(dt[0]), dt[1], Integer.parseInt(dt[2]));
            R.hWord.put(Integer.parseInt(dt[0]), word1);

        } catch (IOException | NumberFormatException | NullPointerException e) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }

    @Override
    @SuppressWarnings("null")
    public int getMaxID(String filename) {
        FileInputStream fi = null;
        int max = 0;
        try {
            fi = new FileInputStream(filename);
            InputStreamReader isr = new InputStreamReader(fi, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String s;
            while ((s = br.readLine()) != null) {
                s = s.replace("\ufeff", "");
                String dt[] = s.split("[\t]");
                if (dt.length != 3) {
                } else {
                    max = Integer.parseInt(dt[0]);
                }
            }
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fi.close();
            } catch (IOException ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return max + 1;
    }

    @Override
    public void removeWord(int id, int idType) {
        Word word = searchWord(id);
        Word wordB = searchBookmark(word.getTen());
        if (wordB != null) {
            R.hBookmark.remove(id, wordB);
        }
        R.hWord.remove(id, word);
        switch (idType) {
            case 1:
                R.hAnimal.remove(id);
                break;
            case 2:
                R.hCar.remove(id);
                break;
            case 3:
                R.hCompany.remove(id);
                break;
            case 4:
                R.hComputer.remove(id);
                break;
            case 5:
                R.hCountry.remove(id);
                break;
            case 6:
                R.hCulinary.remove(id);
                break;
            case 7:
                R.hMotorbike.remove(id);
                break;
            case 8:
                R.hPerson.remove(id);
                break;
            case 9:
                R.hPhone.remove(id);
                break;
            case 10:
                R.hUniversity.remove(id);
                break;

        }
    }

    @Override
    public boolean correctWord(String word, String info, int idType) {
        try {
            String dt[] = info.split("[\t]");
            String text = "";
            String url = System.getProperty("user.dir", null);
            String urlData;
            FileWriter fw;

            switch (idType) {
                case 1:
                    R.animal.setAnh(dt[3]);
                    R.animal.setLoai(dt[4]);
                    R.animal.setTrongLuong((dt[5]));
                    R.animal.setThucAn(dt[6]);
                    R.animal.setDacTinh(dt[7]);

                    urlData = url + "\\data\\text\\animal.txt";
                    Collection<Animal> animals = R.hAnimal.values();
                    Iterator<Animal> itAnimal;
                    for (itAnimal = animals.iterator(); itAnimal.hasNext();) {
                        Animal animal = itAnimal.next();
                        text += String.valueOf(animal.getId()) + "\t1\t" + animal.getTen() + "\t" + animal.getAnh()
                                + "\t" + animal.getLoai() + "\t" + String.valueOf(animal.getTrongLuong())
                                + "\t" + animal.getThucAn() + "\t" + animal.getDacTinh() + "\n";

                    }
                    writeData(urlData, text);
                    break;
                case 2:
                    R.car.setAnh(dt[3]);
                    R.car.setHang(dt[4]);
                    R.car.setGia((dt[5]));
                    R.car.setSoGhe(dt[6]);

                    urlData = url + "\\data\\text\\car.txt";
                    Collection<Car> cars = R.hCar.values();

                    Iterator<Car> itCar;
                    for (itCar = cars.iterator(); itCar.hasNext();) {
                        Car car = itCar.next();
                        text += String.valueOf(car.getId()) + "\t2\t" + car.getTen() + "\t" + car.getAnh() + "\t" + car.getHang()
                                + "\t" + car.getGia() + "\t" + car.getSoGhe() + "\n";

                    }
                    writeData(urlData, text);
                    break;
                case 3:
                    R.company.setAnh(dt[3]);
                    R.company.setTGD(dt[4]);
                    R.company.setGia((dt[5]));
                    R.company.setLichSu(dt[6]);

                    urlData = url + "\\data\\text\\company.txt";

                    Collection<Company> companys = R.hCompany.values();

                    Iterator<Company> itCompany;
                    for (itCompany = companys.iterator(); itCompany.hasNext();) {
                        Company company = itCompany.next();
                        text += String.valueOf(company.getId()) + "\t3\t" + company.getTen() + "\t" + company.getAnh() + "\t" + company.getTGD()
                                + "\t" + company.getGia() + "\t" + company.getLichSu() + "\n";

                    }
                    writeData(urlData, text);
                    break;
                case 4:
                    R.computer.setAnh(dt[3]);
                    R.computer.setNSX(dt[4]);
                    R.computer.setModel(dt[5]);
                    R.computer.setGia((dt[6]));
                    R.computer.setHDH(dt[7]);
                    R.computer.setDoHoa(dt[8]);

                    urlData = url + "\\data\\text\\computer.txt";
                    Collection<Computer> computers = R.hComputer.values();
                    Iterator<Computer> itComputer;
                    for (itComputer = computers.iterator(); itComputer.hasNext();) {
                        Computer computer = itComputer.next();
                        text += String.valueOf(computer.getId()) + "\t4\t" + computer.getTen() + "\t" + computer.getAnh() + "\t" + computer.getNSX()
                                + "\t" + computer.getModel() + "\t" + computer.getGia()
                                + "\t" + computer.getHDH() + "\t" + computer.getDoHoa() + "\n";

                    }
                    writeData(urlData, text);
                    break;
                case 5:
                    R.country.setAnh(dt[3]);
                    R.country.setQuocCa(dt[4]);
                    R.country.setDanSo(dt[5]);
                    R.country.setDienTich(dt[6]);
                    R.country.setThuDo(dt[7]);
                    R.country.setLichSu(dt[8]);

                    urlData = url + "\\data\\text\\country.txt";

                    Collection<Country> countrys = R.hCountry.values();
                    Iterator<Country> itCountry;
                    for (itCountry = countrys.iterator(); itCountry.hasNext();) {
                        Country country = itCountry.next();
                        text += String.valueOf(country.getId()) + "\t5\t" + country.getTen() + "\t" + country.getAnh() + "\t" + country.getQuocCa()
                                + "\t" + country.getDanSo() + "\t" + country.getDienTich() + "\t" + country.getThuDo()
                                + "\t" + country.getLichSu() + "\n";

                    }
                    writeData(urlData, text);
                    break;
                case 6:
                    R.culinary.setAnh(dt[3]);
                    R.culinary.setThanhPhan(dt[4]);
                    R.culinary.setDiaDiem(dt[5]);
                    R.culinary.setGia((dt[6]));

                    urlData = url + "\\data\\text\\culinary.txt";
                    Collection<Culinary> culinarys = R.hCulinary.values();
                    Iterator<Culinary> itCulinary;
                    for (itCulinary = culinarys.iterator(); itCulinary.hasNext();) {
                        Culinary culinary = itCulinary.next();
                        text += String.valueOf(culinary.getId()) + "\t6\t" + culinary.getTen() + "\t" + culinary.getAnh() + "\t" + culinary.getThanhPhan()
                                + "\t" + culinary.getDiaDiem() + "\t" + String.valueOf(culinary.getGia())
                                + "\n";

                    }
                    writeData(urlData, text);
                    break;
                case 7:
                    R.motorbike.setAnh(dt[3]);
                    R.motorbike.setHang(dt[4]);
                    R.motorbike.setGia((dt[5]));

                    urlData = url + "\\data\\text\\motorbike.txt";
                    Collection<Motorbike> motorbikes = R.hMotorbike.values();
                    Iterator<Motorbike> itMotorbike;
                    for (itMotorbike = motorbikes.iterator(); itMotorbike.hasNext();) {
                        Motorbike motorbike = itMotorbike.next();
                        text += String.valueOf(motorbike.getId()) + "\t7\t" + motorbike.getTen() + "\t" + motorbike.getAnh() + "\t" + motorbike.getHang()
                                + "\t" + motorbike.getGia()
                                + "\n";

                    }
                    writeData(urlData, text);
                    break;
                case 8:
                    R.person.setAnh(dt[3]);
                    R.person.setNgaySinh(dt[4]);
                    R.person.setQueQuan(dt[5]);
                    R.person.setCongViec(dt[6]);

                    urlData = url + "\\data\\text\\person.txt";
                    Collection<Person> persons = R.hPerson.values();
                    Iterator<Person> itPerson;
                    for (itPerson = persons.iterator(); itPerson.hasNext();) {
                        Person person = itPerson.next();
                        text += String.valueOf(person.getId()) + "\t8\t" + person.getTen() + "\t" + person.getAnh() + "\t" + person.getNgaySinh()
                                + "\t" + person.getQueQuan() + "\t" + person.getCongViec()
                                + "\n";

                    }
                    writeData(urlData, text);
                    break;
                case 9:
                    R.phone.setAnh(dt[3]);
                    R.phone.setNSX(dt[4]);
                    R.phone.setModel(dt[5]);
                    R.phone.setGia((dt[6]));
                    R.phone.setHDH(dt[7]);

                    urlData = url + "\\data\\text\\phone.txt";
                    Collection<Phone> phones = R.hPhone.values();
                    Iterator<Phone> itPhone;
                    for (itPhone = phones.iterator(); itPhone.hasNext();) {
                        Phone phone = itPhone.next();
                        text += String.valueOf(phone.getId()) + "\t9\t" + phone.getTen() + "\t" + phone.getAnh() + "\t" + phone.getNSX()
                                + "\t" + phone.getModel() + "\t" + phone.getGia()
                                + "\t" + phone.getHDH() + "\n";

                    }
                    writeData(urlData, text);
                    break;
                case 10:
                    R.university.setAnh(dt[3]);
                    R.university.setHieuTruong(dt[4]);
                    R.university.setNganh(dt[5]);
                    R.university.setLichSu(dt[6]);
                    R.university.setSoLuongSV(dt[7]);
                    urlData = url + "\\data\\text\\university.txt";
                    Collection<University> universitys = R.hUniversity.values();
                    Iterator<University> itUniversity;
                    for (itUniversity = universitys.iterator(); itUniversity.hasNext();) {
                        University university = itUniversity.next();
                        text += String.valueOf(university.getId()) + "\t10\t" + university.getTen() + "\t" + university.getAnh() + "\t" + university.getHieuTruong()
                                + "\t" + university.getNganh() + "\t" + university.getLichSu()
                                + "\t" + university.getSoLuongSV() + "\n";

                    }
                    writeData(urlData, text);
                    break;
                default:
                    break;

            }
        } catch (Exception ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

}
