/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import object.Word;

/**
 *
 * @author TIENNH
 */
public abstract class AbstractData {

    public abstract void readData(String name, int type);//Lấy dữ liệu từ file name

    public abstract void writeData(String fileName, String text); // Ghi dữ liệu text vào file name

    public abstract DefaultListModel<Word> searchWord(String ten, int ctrl); // Tìm kiếm từ có tên là ten

    public abstract Word searchWord(int id); // Tìm kiếm từ có mã số là id

    public abstract void searchInfoWord(int id, int idType); // Tìm kiếm thông tin về từ có mã số là id và thuộc thế loại có mã sô idType

    public abstract ArrayList<Integer> searchInterdepend(int idType); // Lấy mã số các từ trong một thể loại có mã idType

    public abstract Word searchBookmark(String ten); // Tìm trong danh sách đánh dấu từ có tên là ten

    public abstract Word searchHistory(String ten); // Tìm trong danh sách lịch sử tra cứu từ có tên là ten

    public abstract boolean addBookmark(Word word); // Thêm từ vào danh sách đánh dấu

    public abstract boolean addHistory(Word word); // Thêm từ vào danh sách lịch sử tra cứu

    public abstract boolean delBookmark(String name); // Xoá từ có tên là name khỏi danh sách đánh dấu

    public abstract boolean delHistory(String name); // Xoá từ có tên là name khỏi lịch sử tra cứu

    public abstract boolean addWord(String word, String info, int idType); // Thêm từ vào thể loại có mã là idType với thông tin từ là word,info

    public abstract int getMaxID(String filename); // Thêm từ vào thể loại có mã là idType

    public abstract void removeWord(int id, int idType); // Xóa từ thuộc thể loại idType có mã là id

    public abstract boolean correctWord(String word, String info, int idType); // Sửa thông tin từ hiện tại

}
