package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Repository;

import entity.Branch;

@Repository
public class BranchDAOImpl implements BrachDAO {

	@Override
	public List<Branch> findALL() {
		List<Branch> res = new ArrayList<Branch>();
		String path = "D:\\Application\\Data\\sml_branch_local.xlsx";
		res = readBranchXLSX(path);
		return res;
	}

	// doc branch.xlsx
	public List<Branch> readBranchXLSX(String path) {
		List<Branch> res = new ArrayList<Branch>();
		// doc excel
		try {
			// doc file excel
			File file = new File(path);
			FileInputStream inputStream = new FileInputStream(file);
			// doi tuong work book cho file excel
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			// lay sheet dau tien cua workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			// Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
			Iterator<Row> iteratoRow = sheet.iterator();
			Branch br;
			while (iteratoRow.hasNext()) {
				Row row = iteratoRow.next();
				int rowNum = row.getRowNum();
				if (row != null && rowNum > 1) {
					br = new Branch();
					br.setId((int) row.getCell(0).getNumericCellValue());
					br.setMaKhuVuc(row.getCell(1).getStringCellValue());
					br.setTenKhuVuc(row.getCell(2).getStringCellValue());
					br.setMaChiNhanh(row.getCell(3).getStringCellValue());
					br.setTenChiNhanh(row.getCell(4).getStringCellValue());
					br.setMaPhongGD(row.getCell(5).getStringCellValue());
					br.setTenPhongGD(row.getCell(6).getStringCellValue());
					br.setDiaChi(row.getCell(7).getStringCellValue());
					br.setMaSoThue(row.getCell(8).getStringCellValue());
					br.setSoDKKD(row.getCell(9).getStringCellValue());
					br.setNgayCap(row.getCell(10).getStringCellValue());
					br.setNoiCap(row.getCell(11).getStringCellValue());
					br.setSoDienThoai(row.getCell(12).getStringCellValue());
					br.setSoFax(row.getCell(13).getStringCellValue());
					br.setTinhThanh(row.getCell(14).getStringCellValue());
					res.add(br);
				}
			}
			inputStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// end doc excel
		return res;
	}

}
