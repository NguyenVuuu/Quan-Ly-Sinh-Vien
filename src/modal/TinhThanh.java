package modal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class TinhThanh implements Serializable{
	private int maTinh;
	private String tenTinh;

	public TinhThanh(int maTinh, String tenTinh) {
		this.maTinh = maTinh;
		this.tenTinh = tenTinh;
	}

	/**
	 * @return the maTinh
	 */
	public int getMaTinh() {
		return maTinh;
	}

	/**
	 * @param maTinh the maTinh to set
	 */
	public void setMaTinh(int maTinh) {
		this.maTinh = maTinh;
	}

	/**
	 * @return the tenTinh
	 */
	public String getTenTinh() {
		return tenTinh;
	}

	/**
	 * @param tenTinh the tenTinh to set
	 */
	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}

	@Override
	public String toString() {
		return "TinhThanh [maTinh=" + maTinh + ", tenTinh=" + tenTinh + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTinh, tenTinh);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TinhThanh other = (TinhThanh) obj;
		return maTinh == other.maTinh && Objects.equals(tenTinh, other.tenTinh);
	}

	public static ArrayList<TinhThanh> getDSTinh() {
		String a_tinh[] = { "Hà Giang", "Cao Bằng", "Lào Cai", "Sơn La", "Lai Châu", "Bắc Kạn", "Lạng Sơn",
				"Tuyên Quang", "Yên Bái", "Thái Nguyên", "Điện Biên", "Phú Thọ", "Vĩnh Phúc", "Bắc Giang", "Bắc Ninh",
				"Hà Nội", "Quảng Ninh", "Hải Dương", "Hải Phòng", "Hòa Bình", "Hưng Yên", "Hà Nam", "Thái Bình",
				"Nam Định", "Ninh Bình", "Thanh Hóa", "Nghệ An", "Hà Tĩnh", "Quảng Bình", "Quảng Trị", "Thừa Thiên Huế",
				"Đà Nẵng", "Quảng Nam", "Quảng Ngãi", "Kon Tum", "Gia Lai", "Bình Định", "Phú Yên", "Đắk Lắk",
				"Khánh Hòa", "Đắk Nông", "Lâm Đồng", "Ninh Thuận", "Bình Phước", "Tây Ninh", "Bình Dương", "Đồng Nai",
				"Bình Thuận", "Thành phố Hồ Chí Minh", "Long An", "Bà Rịa – Vũng Tàu", "Đồng Tháp", "An Giang",
				"Tiền Giang", "Vĩnh Long", "Bến Tre", "Cần Thơ", "Kiên Giang", "Trà Vinh", "Hậu Giang", "Sóc Trăng",
				"Bạc Liêu", "Cà Mau" };

		int i = 0;
		// kết quả lưu trữ giá trị được lưu trữ trong ArrayList<TinhThanh> listTinh
		ArrayList<TinhThanh> listTinh = new ArrayList<TinhThanh>();
		// đi lần lượt từng tỉnh
		for (String tenTinh : a_tinh) {
			// tạo đối tượng tỉnh
			TinhThanh t = new TinhThanh(i, tenTinh);
			// thêm đối tượng tỉnh vào kết quả lưu trữ
			listTinh.add(t);
		}
		return listTinh;
	}

	public static TinhThanh getTinhByID(int queQuan) {
		return TinhThanh.getDSTinh().get(queQuan);
	}

	public static TinhThanh getTinhByTen(String tenTinh) {
		ArrayList<TinhThanh> listTinh = TinhThanh.getDSTinh();
		for (TinhThanh tinh : listTinh) {
			// nếu tenTinh trùng với tenTinh(người ta nhập vào) thì sẽ trả về tỉnh đó
			if (tinh.tenTinh.equals(tenTinh)) {
				return tinh;
			}
		}
		// nếu đi từ đầu đến cuối mà không có thì trả về null
		return null;
	}
}
