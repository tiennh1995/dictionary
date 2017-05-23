/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTextPane;

/**
 *
 * @author TIENNH
 */
public class R {

    public static HashMap<Integer, Word> hWord;//0
    public static HashMap<Integer, Word> hBookmark;//-1
    public static HashMap<Integer, Word> hHistory;//-2
    public static HashMap<Integer, Animal> hAnimal;//1
    public static HashMap<Integer, Car> hCar;//2
    public static HashMap<Integer, Company> hCompany;//3
    public static HashMap<Integer, Computer> hComputer;//4
    public static HashMap<Integer, Country> hCountry;//5
    public static HashMap<Integer, Culinary> hCulinary;//6
    public static HashMap<Integer, Motorbike> hMotorbike;//7
    public static HashMap<Integer, Person> hPerson;//8
    public static HashMap<Integer, Phone> hPhone;//9
    public static HashMap<Integer, University> hUniversity;//10

    public static ArrayList<JTextPane> arrayTextPane;

    public static String windowsClassName = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
    public static int sizeList = 18;
    public static int heightPro = 280;
    public static int widthPro = 635;
    public static int sizePro = 24;
    public static int sizeDelta = 400;

    public static BufferedImage bufferedImage;
    public static Animal animal;
    public static Car car;
    public static Company company;
    public static Computer computer;
    public static Country country;
    public static Culinary culinary;
    public static Motorbike motorbike;
    public static Person person;
    public static Phone phone;
    public static University university;
}
