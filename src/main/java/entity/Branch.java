package entity;

public class Branch {
	private int id;
	private String maKhuVuc;
	private String tenKhuVuc;
	private String maChiNhanh;
	private String tenChiNhanh;
	private String maPhongGD;
	private String tenPhongGD;
	private String diaChi;
	private String maSoThue;
	private String soDKKD;
	private String ngayCap;
	private String noiCap;
	private String soDienThoai;
	private String soFax;
	private String tinhThanh;

	public Branch() {
		super();
	}

	public Branch(int id, String maKhuVuc, String tenKhuVuc, String maChiNhanh, String tenChiNhanh, String maPhongGD,
			String tenPhongGD, String diaChi, String maSoThue, String soDKKD, String ngayCap, String noiCap,
			String soDienThoai, String soFax, String tinhThanh) {
		super();
		this.id = id;
		this.maKhuVuc = maKhuVuc;
		this.tenKhuVuc = tenKhuVuc;
		this.maChiNhanh = maChiNhanh;
		this.tenChiNhanh = tenChiNhanh;
		this.maPhongGD = maPhongGD;
		this.tenPhongGD = tenPhongGD;
		this.diaChi = diaChi;
		this.maSoThue = maSoThue;
		this.soDKKD = soDKKD;
		this.ngayCap = ngayCap;
		this.noiCap = noiCap;
		this.soDienThoai = soDienThoai;
		this.soFax = soFax;
		this.tinhThanh = tinhThanh;
	}

	public Branch(BranchForm branchForm) {
		super();
		this.id = branchForm.getId();
		this.maKhuVuc = branchForm.getMaKhuVuc();
		this.tenKhuVuc = branchForm.getTenKhuVuc();
		this.maChiNhanh = branchForm.getMaChiNhanh();
		this.tenChiNhanh = branchForm.getTenChiNhanh();
		this.maPhongGD = branchForm.getMaPhongGD();
		this.tenPhongGD = branchForm.getTenPhongGD();
		this.diaChi = branchForm.getDiaChi();
		this.maSoThue = branchForm.getMaSoThue();
		this.soDKKD = branchForm.getSoDKKD();
		this.ngayCap = branchForm.getNgayCap();
		this.noiCap = branchForm.getNoiCap();
		this.soDienThoai = branchForm.getSoDienThoai();
		this.soFax = branchForm.getSoFax();
		this.tinhThanh = branchForm.getTinhThanh();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaKhuVuc() {
		return maKhuVuc;
	}

	public void setMaKhuVuc(String maKhuVuc) {
		this.maKhuVuc = maKhuVuc;
	}

	public String getTenKhuVuc() {
		return tenKhuVuc;
	}

	public void setTenKhuVuc(String tenKhuVuc) {
		this.tenKhuVuc = tenKhuVuc;
	}

	public String getMaChiNhanh() {
		return maChiNhanh;
	}

	public void setMaChiNhanh(String maChiNhanh) {
		this.maChiNhanh = maChiNhanh;
	}

	public String getTenChiNhanh() {
		return tenChiNhanh;
	}

	public void setTenChiNhanh(String tenChiNhanh) {
		this.tenChiNhanh = tenChiNhanh;
	}

	public String getMaPhongGD() {
		return maPhongGD;
	}

	public void setMaPhongGD(String maPhongGD) {
		this.maPhongGD = maPhongGD;
	}

	public String getTenPhongGD() {
		return tenPhongGD;
	}

	public void setTenPhongGD(String tenPhongGD) {
		this.tenPhongGD = tenPhongGD;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public String getSoDKKD() {
		return soDKKD;
	}

	public void setSoDKKD(String soDKKD) {
		this.soDKKD = soDKKD;
	}

	public String getNgayCap() {
		return ngayCap;
	}

	public void setNgayCap(String ngayCap) {
		this.ngayCap = ngayCap;
	}

	public String getNoiCap() {
		return noiCap;
	}

	public void setNoiCap(String noiCap) {
		this.noiCap = noiCap;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getSoFax() {
		return soFax;
	}

	public void setSoFax(String soFax) {
		this.soFax = soFax;
	}

	public String getTinhThanh() {
		return tinhThanh;
	}

	public void setTinhThanh(String tinhThanh) {
		this.tinhThanh = tinhThanh;
	}

}
