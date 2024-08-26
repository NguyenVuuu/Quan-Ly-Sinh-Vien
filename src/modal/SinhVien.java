package modal;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class SinhVien implements Serializable{
	private int maSV;
	private String tenSV;
	private TinhThanh queQuan;
	private Date ngaySinh;
	private boolean gioiTinh;
	private float diem1;
	private float diem2;
	private float diem3;

	public SinhVien() {
	}

	public SinhVien(int maSV, String tenSV, TinhThanh queQuan, Date ngaySinh, boolean gioiTinh, float diem1,
			float diem2, float diem3) {
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.queQuan = queQuan;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diem1 = diem1;
		this.diem2 = diem2;
		this.diem3 = diem3;
	}

	/**
	 * @return the maSV
	 */
	public int getMaSV() {
		return maSV;
	}

	/**
	 * @param maSV the maSV to set
	 */
	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}

	/**
	 * @return the tenSV
	 */
	public String getTenSV() {
		return tenSV;
	}

	/**
	 * @param tenSV the tenSV to set
	 */
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	/**
	 * @return the queQuan
	 */
	public TinhThanh getQueQuan() {
		return queQuan;
	}

	/**
	 * @param queQuan the queQuan to set
	 */
	public void setQueQuan(TinhThanh queQuan) {
		this.queQuan = queQuan;
	}

	/**
	 * @return the ngaySinh
	 */
	public Date getNgaySinh() {
		return ngaySinh;
	}

	/**
	 * @param ngaySinh the ngaySinh to set
	 */
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	/**
	 * @return the gioiTinh
	 */
	public boolean isGioiTinh() {
		return gioiTinh;
	}

	/**
	 * @param gioiTinh the gioiTinh to set
	 */
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	/**
	 * @return the diem1
	 */
	public float getDiem1() {
		return diem1;
	}

	/**
	 * @param diem1 the diem1 to set
	 */
	public void setDiem1(float diem1) {
		this.diem1 = diem1;
	}

	/**
	 * @return the diem2
	 */
	public float getDiem2() {
		return diem2;
	}

	/**
	 * @param diem2 the diem2 to set
	 */
	public void setDiem2(float diem2) {
		this.diem2 = diem2;
	}

	/**
	 * @return the diem3
	 */
	public float getDiem3() {
		return diem3;
	}

	/**
	 * @param diem3 the diem3 to set
	 */
	public void setDiem3(float diem3) {
		this.diem3 = diem3;
	}

	@Override
	public String toString() {
		return "SinhVien [maSV=" + maSV + ", tenSV=" + tenSV + ", queQuan=" + queQuan + ", ngaySinh=" + ngaySinh
				+ ", gioiTinh=" + gioiTinh + ", diem1=" + diem1 + ", diem2=" + diem2 + ", diem3=" + diem3 + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(diem1, diem2, diem3, gioiTinh, maSV, ngaySinh, queQuan, tenSV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		return Float.floatToIntBits(diem1) == Float.floatToIntBits(other.diem1)
				&& Float.floatToIntBits(diem2) == Float.floatToIntBits(other.diem2)
				&& Float.floatToIntBits(diem3) == Float.floatToIntBits(other.diem3) && gioiTinh == other.gioiTinh
				&& maSV == other.maSV && Objects.equals(ngaySinh, other.ngaySinh)
				&& Objects.equals(queQuan, other.queQuan) && Objects.equals(tenSV, other.tenSV);
	}

}
