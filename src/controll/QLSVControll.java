package controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import modal.SinhVien;
import modal.TinhThanh;
import view.QLSVView;

public class QLSVControll implements ActionListener {

	private QLSVView qlsvView;

	public QLSVControll(QLSVView qlsvView) {
		this.qlsvView = qlsvView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
//		JOptionPane.showMessageDialog(qlsvView, "Bạn vừa nhấn vào: " + src);
		if (src.equals("Thêm")) {
			// nếu nhấn nút thêm thì xóa form
			this.qlsvView.deleteForm();
			this.qlsvView.qlsvModal.setLuaChon("Thêm");
			//
		} else if (src.equals("Lưu")) {
			try {
				this.qlsvView.addSV();
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
		} else if (src.equals("Cập Nhật")) {
			this.qlsvView.showInfoSelect();
		} else if (src.equals("Xóa")) {
			this.qlsvView.deleteSV();
		} else if (src.equals("Hủy Bỏ")) {
			this.qlsvView.deleteForm();
		} else if (src.equals("Tìm Kiếm")) {
			this.qlsvView.searchSV();
		} else if (src.equals("Hủy Tìm Kiếm")) {
			this.qlsvView.cancelSearchSV();
		} else if (src.equals("Open")) {
			this.qlsvView.openFile();
		} else if (src.equals("Save")) {
			this.qlsvView.saveFile();
		} else if (src.equals("Exit")) {
			this.qlsvView.thoatKhoiChuongTrinh();
		}
	}

	private Date Date(String text) {
		// TODO Auto-generated method stub
		return null;
	}

}
