<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/common/taglib.jsp"%>	
 
 <c:url var="buildingAPI" value="/api/building" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa tòa nhà</title>
</head>
<body>
<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>

							<li>
								<a href="#">More Pages</a>
							</li>
							<li class="active">Inbox</li>
						</ul><!-- /.breadcrumb -->

						
					</div>

					<div class="page-content">
						

						<div class="page-header">
							<h1>
								Inbox
								<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									Mailbox with some customizations as described in docs
								</small>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
                                <form:form class="form-horizontal" commandName="modelSearch" role="form" id="formEdit">
                                    <div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="name"> Tên tòa nhà </label>

										<div class="col-sm-9">
											<form:input path="name" cssClass="form-control"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="managerName"> Người quản lý tòa nhà </label>

										<div class="col-sm-9">
											<form:input path="managerName" cssClass="form-control"/>
										</div>
									</div>
									<!-- <div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="name"> Quận </label>

										<div class="col-sm-9">
											<input type="text" id="name" class="form-control" name="name"/>
										</div>
									</div> -->
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="ward"> Phường </label>

										<div class="col-sm-9">
											<form:input path="ward" cssClass="form-control"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="street"> Đường </label>

										<div class="col-sm-9">
											<form:input path="street" cssClass="form-control"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="structure"> Kết cấu </label>

										<div class="col-sm-9">
											<form:input path="structure" cssClass="form-control"/>
										</div>
									</div>
                                    <div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="numberOfBasement" name="numberOfBasement"> Số tầng hầm </label>

										<div class="col-sm-9">
											<input type="number" id="numberOfBasement" class="form-control" name="numberOfBasement" value="${modelsearch.numberOfBasement}"/>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="floorArea"> Diện tích sàn </label>

										<div class="col-sm-9">
											<form:input path="floorArea" cssClass="form-control"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="direction"> Hướng </label>

										<div class="col-sm-9">
											<form:input path="direction" cssClass="form-control"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="level"> Hạng </label>

										<div class="col-sm-9">
											<form:input path="level" cssClass="form-control"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="areaRent"> Diện tích thuê </label>

										<div class="col-sm-9">
											<input type="text" id="areaRent" class="form-control" name="areaRent" value="${modelsearch.areaRent}"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="rentAreaDescription"> Mô tả diện tích </label>

										<div class="col-sm-9">
											<form:input path="rentAreaDescription" cssClass="form-control"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="costDescription"> Mô tả giá </label>

										<div class="col-sm-9">
											<form:input path="costDescription" cssClass="form-control"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="serviceCost"> Phí dịch vụ </label>

										<div class="col-sm-9">
											<form:input path="serviceCost" cssClass="form-control"/>
										</div>
									</div>
									<!-- <div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="name"> Phí ô tô </label>

										<div class="col-sm-9">
											<input type="text" id="name" class="form-control" name="name"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="name"> Phí mô tô </label>

										<div class="col-sm-9">
											<input type="text" id="name" class="form-control" name="name"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="name"> Phí ngoài giờ </label>

										<div class="col-sm-9">
											<input type="text" id="name" class="form-control" name="name"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="name"> Tiền điện </label>

										<div class="col-sm-9">
											<input type="text" id="name" class="form-control" name="name"/>
										</div>
									</div> -->
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="deposit"> Đặt cọc </label>

										<div class="col-sm-9">
											<form:input path="deposit" cssClass="form-control"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="payment"> Thanh toán </label>

										<div class="col-sm-9">
											<form:input path="payment" cssClass="form-control"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="timeRent"> Thời hạn thuê </label>

										<div class="col-sm-9">
											<form:input path="timeRent" cssClass="form-control"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="timeDecorator"> Thời gian trang trí </label>

										<div class="col-sm-9">
											<form:input path="timeDecorator" cssClass="form-control"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="managerName"> Tên quản lý </label>

										<div class="col-sm-9">
											<form:input path="managerName" cssClass="form-control"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="name"> Số điện thoại quản lý </label>

										<div class="col-sm-9">
											<input type="number" id="managerPhone" class="form-control" name="managerPhone" value="${modelsearch.managerPhone}"/>
										</div>
									</div>
									<!-- <div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="name"> Phí môi giới </label>

										<div class="col-sm-9">
											<input type="text" id="name" class="form-control" name="name"/>
										</div>
									</div> -->
                                    <div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"> Loại tòa nhà </label>

										<div class="col-sm-9">
                                            <label class="checkbox-inline"><input type="checkbox" value="TANG_TRET" id="buildingTypes" name="buildingTypes">Tầng trệt</label>
                                            <label class="checkbox-inline"><input type="checkbox" value="NGUYEN_CAN" id="buildingTypes" name="buildingTypes">Nguyên căn</label>
                                            <label class="checkbox-inline"><input type="checkbox" value="NOI_THAT" id="buildingTypes" name="buildingTypes">Nội thất</label>										
									    </div>
                                    </div>


                                    <div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"> </label>

										<div class="col-sm-9">
											<button type="button" class="btn btn-primary" id="btnAddBuilding">Thêm tòa nhà</button>
                                            <button type="button" class="btn btn-primary">Hủy</button>
										</div>
									</div>
                                </form:form>
                            </div>
						
						</div><!-- /.row -->
						
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->
			
			
<script>
			$('#btnAddBuilding').click(function () {
				e.preventDefault();
				var data = {};
				var buildingTypes = [];
				var formdata = $('#formEdit').serializeArray();
				$.each(formdata, function (index, v) { 
					if(v.name == 'buildingTypes'){
						buildingTypes.push(v.value);
					}else{
						data[""+v.name+""] = v.value;
					}
					 
				});
				
				data['buildingTypes'] = buildingTypes;
                $.ajax({
                    type: 'post',
                    url: 'buildingAPI',
                    data: JSON.stringify(data),
                    dataType: "json",
					contentType: "application/json",
                    success: function (response) {
                        
                    },
					error: function (response) {
                        
                    }
                });
            });
		</script>
</body>
</html>