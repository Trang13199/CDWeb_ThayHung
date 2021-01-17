﻿﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.error {
	color: red;
}
</style>
</head>
<body>


	<!-- Start header section -->
	<jsp:directive.include file="header.jsp" />
	<!-- / header section -->
	<!-- @section jsFooter
{
  <script>
    $('#chonanh').on('click',function(e) {
        e.preventDefault();
      var finder = new CKFinder();
          finder.selectActionFunction = function(url) {
            $('#image').val(url);
          };
              finder.popup();
    })
    
    var editor = CKEDITOR.replace('content',{
        customConfig: '/plugins/ckeditor/config.js',
    })
  </script>

} -->


	<!-- Start Welcome area -->
	<div class="all-content-wrapper">

		<!-- Single pro tab start-->
		<div class="single-product-tab-area mg-b-30">
			<!-- Single pro tab review Start-->
			<div class="single-pro-review-area">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="review-tab-pro-inner">
								<ul id="myTab3" class="tab-review-design">
									<li class="active"><a href="#description"><i
											class="icon nalika-edit" aria-hidden="true"></i> Thêm sản
											phẩm</a></li>
								</ul>
								<div id="myTabContent" class="tab-content custom-product-edit">
									<div class="product-tab-list tab-pane fade active in"
										id="description">
										<div class="row">

											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<form:form action="addProduct" method="POST"
													modelAttribute="books" enctype="multipart/form-data">

													<br /> Hình ảnh:
													<form:input path="hinhAnh" cssClass="form-control" />
													<form:errors path="hinhAnh" cssClass="error" />

													<br /> Tên sách:
													<form:input path="tenSach" cssClass="form-control" />
													<form:errors path="tenSach" cssClass="error" />
													<br /> Thể loại:
													<form:input path="theloaisach" cssClass="form-control" />
													<form:errors path="theloaisach" cssClass="error" />

													<br /> Giá: <input name="gia" type="datetime"
														class="form-control" />
													<form:errors path="gia" cssClass="error" />
													<br /> Tác giả:
													<form:input path="tenTacGia" cssClass="form-control" />
													<form:errors path="tenTacGia" cssClass="error" />
													<br /> Mô tả:
													<form:input path="moTa" cssClass="form-control" />
													<form:errors path="moTa" cssClass="error" />
													<br />
													Khuyến mãi: <input name="khuyenMai" type="datetime"
														class="form-control" />
													<form:errors path="khuyenMai" cssClass="error" />
													<br /> Ngày sản xuất:
													<form:input path="ngayXuatBan" cssClass="form-control" />
													<form:errors path="ngayXuatBan" cssClass="error" />
													<br /> Số lượng:
													<form:input path="soLuong" cssClass="form-control" />
													<form:errors path="soLuong" cssClass="error" />
													<br />
													<br />
													<button type="submit">Lưu</button>
													<!-- <div class="review-content-section">
														<div class="form-group">
															<a id="chonanh" href="#">Chọn ảnh</a> <input
																class="ckeditor form-control" name="hinhAnh" id="image"
																rows="3">
														</div>
														<div class="input-group mg-b-pro-edt">
															<span class="input-group-addon"> <i
																class="icon nalika-edit" aria-hidden="true"></i></span> <input
																type="text" name="tenSach" class="form-control"
																placeholder="Tên">
														</div>
														<div class="input-group mg-b-pro-edt">
															<span class="input-group-addon"> <i
																class="fa fa-usd" aria-hidden="true"></i></span> <input
																type="text" class="form-control" name="gia"
																placeholder="Giá">
														</div>

														<div class="input-group mg-b-pro-edt">
															<span class="input-group-addon"> <i
																class="icon nalika-favorites" aria-hidden="true"></i></span> <input
																type="text" class="form-control" name="loaiSach"
																placeholder="Loại">
														</div>
														<div class="input-group mg-b-pro-edt">
															<span class="input-group-addon"> <i
																class="fa fa-usd" aria-hidden="true"></i></span> <input
																type="text" class="form-control" name="soLuong"
																placeholder="Số lượng">
														</div>
														<div class="form-group">
															<label for="moTa">Mô tả</label>
															<textarea class="ckeditor" runat="server" name="moTa"
																rows="3" id="content"></textarea>
														</div>
														<div class="input-group mg-b-pro-edt">
															<span class="input-group-addon"> <i
																class="fa fa-usd" aria-hidden="true"></i></span> <input
																type="text" class="form-control" name="tenTacGia"
																placeholder="Số lượng">
														</div>
														<div class="form-group">
															<label for="moTa">Mô tả</label>
															<textarea class="ckeditor" runat="server"
																name="ngayXuatBan" rows="3" id="content"></textarea>
														</div>
													</div>
													<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
														<div class="text-center custom-pro-edt-ds">
															<button type="submit"
																class="btn btn-ctl-bt waves-effect waves-light">LƯU
															</button>
														</div>
													</div> -->
												</form:form>
											</div>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--FOOTER -->

	<jsp:directive.include file="footer.jsp" />

	<!-- END FOOTER -->
</body>
</html>