package modal;

import java.util.ArrayList;

public class QLSVModal {
	private ArrayList<SinhVien> dsSV;
	private String luaChon;
	private String tenFile;

	public QLSVModal() {
		this.dsSV = new ArrayList<SinhVien>();
		this.luaChon = "";
		this.tenFile = "";
	}

	public QLSVModal(ArrayList<SinhVien> dsSV) {
		this.dsSV = dsSV;
	}

	/**
	 * @return the dsSV
	 */
	public ArrayList<SinhVien> getDsSV() {
		return dsSV;
	}

	/**
	 * @param dsSV the dsSV to set
	 */
	public void setDsSV(ArrayList<SinhVien> dsSV) {
		this.dsSV = dsSV;
	}

	/**
	 * @return the luaChon
	 */
	public String getLuaChon() {
		return luaChon;
	}

	/**
	 * @param luaChon the luaChon to set
	 */
	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	/**
	 * @return the tenFile
	 */
	public String getTenFile() {
		return tenFile;
	}

	/**
	 * @param tenFile the tenFile to set
	 */
	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	// hàm nhập sinh viên mới
	public void insert(SinhVien sinhVien) {
		this.dsSV.add(sinhVien);
	}

	// hàm xóa sinh viên
	public void delete(SinhVien sinhVien) {
		this.dsSV.remove(sinhVien);
	}

	// hàm cập nhật sinh viên
	// thực hiện bằng cách xóa bạn đó đi và thêm lại bạn đó như 1 bạn mới
	public void update(SinhVien sinhVien) {
		this.dsSV.remove(sinhVien);
		this.dsSV.add(sinhVien);
	}

	public boolean kiemTraTonTai(SinhVien sv) {
		// đã có sv có mã đó thì trả về true không thì trả về false
		for (SinhVien sinhVien : dsSV) {
			if (sinhVien.getMaSV() == sv.getMaSV()) {
				return true;
			}
		}
		return false;
	}

}
