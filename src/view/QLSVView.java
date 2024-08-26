package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modal.QLSVModal;
import modal.SinhVien;
import modal.TinhThanh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controll.QLSVControll;

import javax.swing.JRadioButton;

public class QLSVView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public QLSVModal qlsvModal;
	public JTextField textField_maSVTimKiem;
	public JTable table;
	public JTextField textField_ID;
	public JTextField textField_hoTen;
	public JTextField textField_ngaySinh;
	public JTextField textField_diem1;
	public JTextField textField_diem2;
	public JTextField textField_diem3;
	public ButtonGroup btnGroup_gioiTinh;
	public JComboBox comboBox_queQuan_info;
	public JRadioButton rdbtn_nam;
	public JRadioButton rdbtn_nu;
	private JComboBox comboBox_queQuanTimKiem;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		this.qlsvModal = new QLSVModal();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1022, 679);
		setLocationRelativeTo(null);

		ActionListener ac = new QLSVControll(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuFile);

		JMenuItem menuItemOpen = new JMenuItem("Open");
		menuItemOpen.addActionListener(ac);
		menuItemOpen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuItemOpen);

		JMenuItem menuItemSave = new JMenuItem("Save");
		menuItemSave.addActionListener(ac);
		menuItemSave.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuItemSave);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuItemExit = new JMenuItem("Exit");
		menuItemExit.addActionListener(ac);
		menuItemExit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuItemExit);

		JMenu menuAbout = new JMenu("About");
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuAbout);

		JMenuItem menuAboutMe = new JMenuItem("About me");
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label_queQuan = new JLabel("Quê Quán");
		label_queQuan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_queQuan.setBounds(22, 11, 101, 47);
		contentPane.add(label_queQuan);

		JLabel label_maSV = new JLabel("Mã Sinh Viên");
		label_maSV.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_maSV.setBounds(357, 11, 101, 47);
		contentPane.add(label_maSV);

		textField_maSVTimKiem = new JTextField();
		textField_maSVTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_maSVTimKiem.setColumns(10);
		textField_maSVTimKiem.setBounds(468, 11, 204, 47);
		contentPane.add(textField_maSVTimKiem);

		JButton btn_search = new JButton("Tìm Kiếm");
		btn_search.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_search.setBounds(717, 11, 124, 47);
		btn_search.addActionListener(ac);
		contentPane.add(btn_search);

		JButton btn_cancelSearch = new JButton("Hủy Tìm Kiếm");
		btn_cancelSearch.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_cancelSearch.setBounds(851, 11, 141, 47);
		btn_cancelSearch.addActionListener(ac);
		contentPane.add(btn_cancelSearch);

		comboBox_queQuanTimKiem = new JComboBox();
		// add các tỉnh thành vào comboBox_queQuan
		ArrayList<TinhThanh> listTinh = TinhThanh.getDSTinh();
		// add 1 chuỗi rỗng trước khi người dùng click vào
		comboBox_queQuanTimKiem.addItem("");
		for (TinhThanh tinhThanh : listTinh) {
			// add các item vào comboBox_queQuan
			comboBox_queQuanTimKiem.addItem(tinhThanh.getTenTinh());
		}
		comboBox_queQuanTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox_queQuanTimKiem.setBounds(122, 11, 204, 47);
		contentPane.add(comboBox_queQuanTimKiem);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 69, 993, 2);
		contentPane.add(separator_1);

		JLabel label_queQuan_1 = new JLabel("Danh sách sinh viên");
		label_queQuan_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_queQuan_1.setBounds(10, 69, 157, 47);
		contentPane.add(label_queQuan_1);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 Sinh Vi\u00EAn", "H\u1ECD T\u00EAn", "Qu\u00EA Qu\u00E1n", "Ng\u00E0y Sinh",
						"Giới Tính", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3" }));

		table.setRowHeight(30);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 108, 972, 199);
		contentPane.add(scrollPane);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 318, 993, 2);
		contentPane.add(separator_1_1);

		JLabel label_queQuan_2 = new JLabel("Thông Tin Sinh Viên");
		label_queQuan_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_queQuan_2.setBounds(10, 318, 157, 47);
		contentPane.add(label_queQuan_2);

		JLabel label_maSV_1 = new JLabel("Mã Sinh Viên");
		label_maSV_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_maSV_1.setBounds(22, 361, 101, 35);
		contentPane.add(label_maSV_1);

		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_ID.setColumns(10);
		textField_ID.setBounds(177, 361, 261, 35);
		contentPane.add(textField_ID);

		JLabel label_hoTen = new JLabel("Họ Và Tên");
		label_hoTen.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_hoTen.setBounds(22, 407, 101, 35);
		contentPane.add(label_hoTen);

		textField_hoTen = new JTextField();
		textField_hoTen.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_hoTen.setColumns(10);
		textField_hoTen.setBounds(177, 407, 261, 35);
		contentPane.add(textField_hoTen);

		JLabel label_queQuan_3 = new JLabel("Quê Quán");
		label_queQuan_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_queQuan_3.setBounds(22, 453, 101, 35);
		contentPane.add(label_queQuan_3);

		comboBox_queQuan_info = new JComboBox();
		// add các tỉnh thành vào comboBox_queQuan
		ArrayList<TinhThanh> listTinh1 = TinhThanh.getDSTinh();
		comboBox_queQuan_info.addItem("");
		for (TinhThanh tinhThanh : listTinh1) {
			// add các item vào comboBox_queQuan
			comboBox_queQuan_info.addItem(tinhThanh.getTenTinh());
		}
		comboBox_queQuan_info.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox_queQuan_info.setBounds(177, 453, 261, 35);
		contentPane.add(comboBox_queQuan_info);

		JLabel label_ngaySinh = new JLabel("Ngày Sinh");
		label_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_ngaySinh.setBounds(22, 499, 101, 35);
		contentPane.add(label_ngaySinh);

		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_ngaySinh.setColumns(10);
		textField_ngaySinh.setBounds(177, 499, 261, 35);
		contentPane.add(textField_ngaySinh);

		JLabel label_gioiTinh = new JLabel("Giới Tính");
		label_gioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_gioiTinh.setBounds(544, 355, 101, 47);
		contentPane.add(label_gioiTinh);

		rdbtn_nam = new JRadioButton("Nam");
		rdbtn_nam.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtn_nam.setBounds(694, 367, 111, 23);
		contentPane.add(rdbtn_nam);

		rdbtn_nu = new JRadioButton("Nữ");
		rdbtn_nu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtn_nu.setBounds(850, 367, 111, 23);
		contentPane.add(rdbtn_nu);

		btnGroup_gioiTinh = new ButtonGroup();
		btnGroup_gioiTinh.add(rdbtn_nam);
		btnGroup_gioiTinh.add(rdbtn_nu);

		JLabel label_diem1 = new JLabel("Điểm Môn 1");
		label_diem1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_diem1.setBounds(544, 407, 101, 35);
		contentPane.add(label_diem1);

		textField_diem1 = new JTextField();
		textField_diem1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_diem1.setColumns(10);
		textField_diem1.setBounds(699, 407, 261, 35);
		contentPane.add(textField_diem1);

		JLabel label_diem2 = new JLabel("Điểm Môn 2");
		label_diem2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_diem2.setBounds(545, 453, 101, 35);
		contentPane.add(label_diem2);

		textField_diem2 = new JTextField();
		textField_diem2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_diem2.setColumns(10);
		textField_diem2.setBounds(700, 453, 261, 35);
		contentPane.add(textField_diem2);

		JLabel label_diem3 = new JLabel("Điểm Môn 3");
		label_diem3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_diem3.setBounds(544, 499, 101, 35);
		contentPane.add(label_diem3);

		textField_diem3 = new JTextField();
		textField_diem3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_diem3.setColumns(10);
		textField_diem3.setBounds(699, 499, 261, 35);
		contentPane.add(textField_diem3);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 542, 993, 2);
		contentPane.add(separator_2);

		JButton btn_add = new JButton("Thêm");
		btn_add.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_add.setBounds(32, 553, 124, 47);
		btn_add.addActionListener(ac);
		contentPane.add(btn_add);

		JButton btn_delete = new JButton("Xóa");
		btn_delete.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_delete.setBounds(240, 553, 124, 47);
		btn_delete.addActionListener(ac);
		contentPane.add(btn_delete);

		JButton btn_update = new JButton("Cập Nhật");
		btn_update.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_update.setBounds(441, 553, 124, 47);
		btn_update.addActionListener(ac);
		contentPane.add(btn_update);

		JButton btn_save = new JButton("Lưu");
		btn_save.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_save.setBounds(656, 553, 124, 47);
		btn_save.addActionListener(ac);
		contentPane.add(btn_save);

		JButton btn_cancel = new JButton("Hủy Bỏ");
		btn_cancel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_cancel.setBounds(850, 553, 124, 47);
		btn_cancel.addActionListener(ac);
		contentPane.add(btn_cancel);

		setVisible(true);
	}

	// đưa các form về rỗng bằng cách setText cho chúng 1 chuỗi rỗng
	public void deleteForm() {
		textField_ID.setText("");
		textField_hoTen.setText("");
		textField_maSVTimKiem.setText("");
		textField_ngaySinh.setText("");
		// xóa dữ liệu nhập
		comboBox_queQuan_info.setSelectedIndex(-1);

		textField_diem1.setText("");
		textField_diem2.setText("");
		textField_diem3.setText("");
		btnGroup_gioiTinh.clearSelection();
	}

	// hàm thêm sv vào bảng
	public void addSVToTable(SinhVien sv) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		defaultTableModel.addRow(new Object[] { sv.getMaSV() + "", sv.getTenSV(), sv.getQueQuan().getTenTinh(),
				df.format(sv.getNgaySinh()), sv.isGioiTinh() ? "Nam" : "Nữ", sv.getDiem1(), sv.getDiem2(),
				sv.getDiem3() });
	}

	public void addOrUpdateSinhVien(SinhVien sv) {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		// nếu bạn sv chưa từng tồn tại thì add vào
		if (!this.qlsvModal.kiemTraTonTai(sv)) {
			this.qlsvModal.insert(sv);
			// thêm dữ liệu vào bảng
			this.addSVToTable(sv);
		} else {
			this.qlsvModal.update(sv);
			// đắp dữ liệu mới lên cho sv đã tồn tại
			int soLuongDong = defaultTableModel.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				/*
				 * lấy masv ở từng dòng ra, sau đó nếu id dòng đó trùng với id thí sinh thì cập
				 * nhật dữ liệu ở dòng đó thôi
				 */
				String id = defaultTableModel.getValueAt(i, 0) + "";
				if (id.equals(sv.getMaSV() + "")) {
					defaultTableModel.setValueAt(sv.getMaSV() + "", i, 0);
					defaultTableModel.setValueAt(sv.getTenSV(), i, 1);
					defaultTableModel.setValueAt(sv.getQueQuan().getTenTinh(), i, 2);
					defaultTableModel.setValueAt(df.format(sv.getNgaySinh()), i, 3);
					defaultTableModel.setValueAt(sv.isGioiTinh() ? "Nam" : "Nữ", i, 4);
					defaultTableModel.setValueAt(sv.getDiem1(), i, 5);
					defaultTableModel.setValueAt(sv.getDiem2(), i, 6);
					defaultTableModel.setValueAt(sv.getDiem3(), i, 7);
				}
			}
		}
	}

	// hàm lấy thông tin sinh viên đang chọn
	public SinhVien getSVSelect() {
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		// lấy ra thứ tự của dòng
		int i_row = table.getSelectedRow();
		// lấy ra 1 dòng

		// dữ liệu
		int maSV = Integer.valueOf(defaultTableModel.getValueAt(i_row, 0) + "");
		String tenSV = String.valueOf(defaultTableModel.getValueAt(i_row, 1));
		TinhThanh tinh = TinhThanh.getTinhByTen(defaultTableModel.getValueAt(i_row, 2) + "");
		String s_ngaySinh = defaultTableModel.getValueAt(i_row, 3) + "";
		Date ngaySinh = new Date(s_ngaySinh);
		String textGT = defaultTableModel.getValueAt(i_row, 4) + "";
		boolean gioiTinh = textGT.equals("Nam");
		float diem1 = Float.valueOf(defaultTableModel.getValueAt(i_row, 5) + "");
		float diem2 = Float.valueOf(defaultTableModel.getValueAt(i_row, 6) + "");
		float diem3 = Float.valueOf(defaultTableModel.getValueAt(i_row, 7) + "");

		SinhVien sv = new SinhVien(maSV, tenSV, tinh, ngaySinh, gioiTinh, diem1, diem2, diem3);
		return sv;
	}

	// hàm hiển thị thông tin sinh viên đang chọn xuông textfield
	public void showInfoSelect() {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		SinhVien sv = getSVSelect();

		// gắn dữ liệu cho từng textfield
		this.textField_ID.setText(sv.getMaSV() + "");
		this.textField_hoTen.setText(sv.getTenSV() + "");
		this.comboBox_queQuan_info.setSelectedItem(sv.getQueQuan().getTenTinh());
		String s_ngaySinh = df.format(sv.getNgaySinh());
		this.textField_ngaySinh.setText(s_ngaySinh + "");
		if (sv.isGioiTinh()) {
			this.rdbtn_nam.setSelected(true);
			;
		} else {
			this.rdbtn_nu.setSelected(true);
		}
		this.textField_diem1.setText(sv.getDiem1() + "");
		this.textField_diem2.setText(sv.getDiem2() + "");
		this.textField_diem3.setText(sv.getDiem3() + "");
	}

	// hàm xóa sinh viên đang chọn
	public void deleteSV() {
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa dòng này");
		// nếu chọn yes sẽ thực hiện đoạn code trong if
		if (luaChon == JOptionPane.YES_OPTION) {
			// tạo đối tượng sv và gán thông tin từ hàm getSVSelect()
			SinhVien sv = getSVSelect();
			// gọi hàm xóa sv bên qlsvModal
			this.qlsvModal.delete(sv);
			// xóa sv khỏi bảng
			defaultTableModel.removeRow(i_row);
		}
	}

	public void addSV() {
		// lấy dữ liệu cho sinh viên mới
		int maSV = Integer.valueOf(this.textField_ID.getText());
		String tenSV = String.valueOf(this.textField_hoTen.getText());
		int queQuan = this.comboBox_queQuan_info.getSelectedIndex() - 1;
		TinhThanh tinh = TinhThanh.getTinhByID(queQuan);
		Date ngaySinh = new Date(this.textField_ngaySinh.getText());
		boolean gioiTinh = true;
		if (this.rdbtn_nam.isSelected()) {
			gioiTinh = true;
		} else if (this.rdbtn_nu.isSelected()) {
			gioiTinh = false;
		}
		float diem1 = Float.valueOf(this.textField_diem1.getText());
		float diem2 = Float.valueOf(this.textField_diem2.getText());
		float diem3 = Float.valueOf(this.textField_diem3.getText());

		// tạo sinh viên mới
		SinhVien sv = new SinhVien(maSV, tenSV, tinh, ngaySinh, gioiTinh, diem1, diem2, diem3);
		this.addOrUpdateSinhVien(sv);
	}

	// hàm tìm kiếm sv
	public void searchSV() {
		// hủy tìm kiếm để mọi thứ về ban đầu
		this.cancelSearchSV();
		// tìm kiếm
		int queQuan = this.comboBox_queQuanTimKiem.getSelectedIndex() - 1;
		String maSVTimKiem = this.textField_maSVTimKiem.getText();
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		int soLuongDong = defaultTableModel.getRowCount();
		Set<Integer> IDCanXoa = new TreeSet<Integer>();
		// nếu queQuan >=0 nghĩa là người ta có thực hiện chọn
		if (queQuan >= 0) {
			// thì lấy tinh ra
			TinhThanh tinhDaChon = TinhThanh.getTinhByID(queQuan);
			for (int i = 0; i < soLuongDong; i++) {
				String tenTinh = defaultTableModel.getValueAt(i, 2) + "";
				String id = defaultTableModel.getValueAt(i, 0) + "";
				// nếu tenTinh và tinhDaChon khác nhau thì xóa dòng đó đi
				if (!tenTinh.equals(tinhDaChon.getTenTinh())) {
					// nếu sv nào có tỉnh không trùng với đã chọn thì xóa đi
					IDCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		// nếu maSVTimKiem >0 nghĩa là người dùng có nhập
		if (maSVTimKiem.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = defaultTableModel.getValueAt(i, 0) + "";
				// nếu masv trong table khác masv tìm kiếm thì xóa đi
				if (!id.equals(maSVTimKiem)) {
					IDCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		// so sánh khác nhau để xóa
		for (Integer idCanXoa : IDCanXoa) {
			soLuongDong = defaultTableModel.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = defaultTableModel.getValueAt(i, 0) + "";
				if (idTrongTable.equals(idCanXoa.toString())) {
					try {
						defaultTableModel.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	/*
	 * đi vào model lấy tất cả sv ra và add ngược lại vào table
	 */
	public void cancelSearchSV() {
		while (true) {
			DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
			int soLuongDong = defaultTableModel.getRowCount();
			// nếu số lượng dòng = 0 thì thoát khỏi vòng lặp
			if (soLuongDong == 0) {
				break;
			} else {
				try {
					// xóa đi dòng số 0 đến khi không còn gì và thoát vòng lặp
					defaultTableModel.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		// thêm sinh viên vào lại table
		for (SinhVien sv : this.qlsvModal.getDsSV()) {
			this.addSVToTable(sv);
		}
	}

	public void thoatKhoiChuongTrinh() {
		int luachon = JOptionPane.showConfirmDialog(this, "Bạn có muôn thoát khỏi chương trình?", "Exit",
				JOptionPane.YES_NO_OPTION);
		if (luachon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void openFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(fc);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File file =fc.getSelectedFile();
			open(file);
			cancelSearchSV();
		}
	}

	public void open(File file) {
		ArrayList<SinhVien> ds = new ArrayList<SinhVien>();
		try {
			this.qlsvModal.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file.getAbsolutePath());
			ObjectInputStream ois = new ObjectInputStream(fis);
			SinhVien sv = null;
			while ((sv = (SinhVien) ois.readObject())!= null) {
				ds.add(sv);
			}
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.qlsvModal.setDsSV(ds);
	}
	public void save(String path) {
		try {
			this.qlsvModal.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			// dùng để lưu 1 đối tượng file xuống
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (SinhVien sv : this.qlsvModal.getDsSV()) {
				//ghi sv xuống
				oos.writeObject(sv);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveFile() {
		//tenfile > 0 là có file đó
		if(this.qlsvModal.getTenFile().length() >0) {
			save(this.qlsvModal.getTenFile());
		}else {
			//hiển thị dialog
			JFileChooser fc = new JFileChooser();
			int returnVal =fc.showSaveDialog(this);
			if(returnVal ==JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				save(file.getAbsolutePath());
			}
		}
	}
}
