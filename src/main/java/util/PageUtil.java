package util;

import constant.GlobalConstant;

public class PageUtil {

	// lấy vị trí dữ liệu (phân trang)
	public static int getOffset(int page) {
		return (page - 1) * GlobalConstant.TOTAL_ROW;
	}

	// đếm tổng số trang
	public static int getTotalPage(int totalRow) {
		return (int) Math.ceil((float) totalRow / GlobalConstant.TOTAL_ROW);
	}

}
