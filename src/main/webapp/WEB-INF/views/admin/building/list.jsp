<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>	
 <c:url var="buildingListURL" value="/admin/building-list" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách tòa nhà</title>
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
								<div class="widget-box">
								
									<div class="widget-header">
														<h4 class="widget-title">Tìm kiếm</h4>

														<div class="widget-toolbar">
															<a href="#" data-action="collapse">
																<i class="ace-icon fa fa-chevron-up"></i>
															</a>
														</div>
									</div>
									<div class="widget-body">
										<div class="widget-main">
										<form:form commandName="modelSearch" action="${buildingListURL}" id="listForm" method="GET">
											<%-- <div class="row">
												<div class="col-xs-12">
													<!-- PAGE CONTENT BEGINS -->
													<div class="col-sm-6">
															<div>
																<label for="name">Tên tòa nhà</label>
																<!-- input type="text" id="name" class="form-control" name="name" value="${modelsearch.name}" -->
																<form:input path="name" cssClass="form-control"/>
															</div>
													</div>
													<div class="col-sm-6">
															<div>
																<label for="floorArea">Diện tích sàn</label>
																<input type="number" id="floorArea" class="form-control" name="floorArea" value="${modelsearch.floorArea}"/>
															</div>
													</div>
												</div><!-- /.col -->
											</div>

											<div class="row">
												<div class="col-xs-12">
													<!-- PAGE CONTENT BEGINS -->
													<div class="col-sm-4">
															<div>
																<label for="district">Quận hiện có</label>
																<select class="form-control" id="district">
																	<option value=""></option>
																	<option value="AL">Alabama</option>
																</select>
															</div>
													</div>
													<div class="col-sm-4">
														<div>
															<label for="ward">Phường</label>
															<form:input path="ward" cssClass="form-control"/>
														</div>
													</div>
													<div class="col-sm-4">
														<div>
															<label for="street">Đường</label>
															<form:input path="street" cssClass="form-control"/>
														</div>
													</div>
												</div><!-- /.col -->
											</div>

											<div class="row">
												<div class="col-xs-12">
													<!-- PAGE CONTENT BEGINS -->
													<div class="col-sm-4">
															<div>
																<label for="numberOfBasement">Số tầng hầm</label>
																<input type="number" id="numberOfBasement" class="form-control" name="numberOfBasement" value="${modelsearch.numberOfBasement}"/>
															</div>
													</div>
													<div class="col-sm-4">
														<div>
															<label for="direction">Hướng</label>
															<form:input path="direction" cssClass="form-control"/>
														</div>
													</div>
													<div class="col-sm-4">
														<div>
															<label for="level">Hạng</label>
															<form:input path="level" cssClass="form-control"/>
														</div>
													</div>
												</div><!-- /.col -->
											</div>
										
											<div class="row">
												<div class="col-xs-12">
													<!-- PAGE CONTENT BEGINS -->
													<div class="col-sm-3">
															<div>
																<label for="areaRentForm">Diện tích từ</label>
																<input type="number" id="areaRentForm" class="form-control" name="areaRentForm" value="${modelsearch.areaRentForm}"/>
															</div>
													</div>
													<div class="col-sm-3">
															<div>
																<label for="areaRentTo">Diện tích đến</label>
																<input type="number" id="areaRentTo" class="form-control" name="areaRentTo" value="${modelsearch.areaRentTo}"/>
															</div>
													</div>
													<div class="col-sm-3">
															<div>
																<label for="costRentFrom">Giá thuê từ</label>
																<input type="number" id="costRentFrom" class="form-control" name="costRentFrom" value="${modelsearch.costRentFrom}"/>
															</div>
													</div>
													<div class="col-sm-3">
															<div>
																<label for="costRentTo">Giá thuê đến</label>
																<input type="number" id="costRentTo" class="form-control" name="costRentTo" value="${modelsearch.costRentTo}"/>
															</div>
													</div>
												</div><!-- /.col -->
											</div>
										
											<div class="row">
												<div class="col-xs-12">
													<!-- PAGE CONTENT BEGINS -->
													
													<div class="col-sm-4">
														<div>
															<label for="managerName">Tên quản lý</label>
															<form:input path="managerName" cssClass="form-control"/>
														</div>
													</div>
													<div class="col-sm-4">
														<div>
															<label for="managerPhone">Điện thoại quản lý</label>
															<input type="number" id="managerPhone" class="form-control" name="managerPhone" value="${modelsearch.managerPhone}"/>
														</div>
													</div>
													<div class="col-sm-4">
														<div>
															<label for="staffId">Chọn nhân viên phụ trách</label>
															<select class="form-control" id="staffId">
																<option value="">--Chọn nhân viên phụ trách--</option>
																<option value="AL">Alabama</option>
															</select>
														</div>
													</div>
												</div><!-- /.col --> --%>
											</div>
											
											<div class="row">
												<div class="col-xs-12">
													<div class="col-sm-9">
														<label class="checkbox-inline"><input type="checkbox" value="TANG_TRET" id="buildingTypes" name="buildingTypes">Tầng trệt</label>
														<label class="checkbox-inline"><input type="checkbox" value="NGUYEN_CAN" id="buildingTypes" name="buildingTypes">Nguyên căn</label>
														<label class="checkbox-inline"><input type="checkbox" value="NOI_THAT" id="buildingTypes" name="buildingTypes">Nội thất</label>										
													</div>
												</div><!-- /.col -->
											</div>

											<br/>
											<div class="row">
												<div class="col-xs-12">
													<div class="col-sm-3">
														<button type="button" class="btn btn-success" id="btnSearch">Tìm kiếm</button>
													</div>	
												</div><!-- /.col -->
											</div>
										</form:form>
											

										</div>
									</div>
								</div>
							</div>
							<div class="pull-right">
								<div class="col-xs-12">
									<button class="btn btn-white btn-info btn-bold" data-toggle="tooltip" title="Thêm tòa nhà">
										<i class="fa fa-plus-circle" aria-hiden="true"></i>
									</button>
									<button class="btn btn-white btn-warning btn-bold" data-toggle="tooltip" title="Xóa tòa nhà" id="btnDeleteBuilding">
										<i class="fa fa-trash" aria-hiden="true"></i>
									</button>
								</div>
							</div>
						
						</div><!-- /.row -->
						
						<br/>
						<div class="row">
							<div class="col-xs-12">
								<table id="buildingList" class="table table-striped table-bordered table-hover">
									<thead>
												<tr>
													<th>
													</th>
													<th>Tên tòa nhà</th>
													<th>Địa chỉ</th>
													<th>Tên quản lý</th>
													<th>Số điện thoại</th>
													<th>Diện tích sàn</th>
													<th>Giá thuê</th>
													<th>Phí dịch vụ</th>
													<th>Thao tác</th>
												</tr>
									</thead>
									<tbody>
									<c:forEach var="item" items="${buildings}">
										<tr>
											<td>
												<input type="checkbox" value="1" id="checkbox_1"/>
											</td>
											<td>
												${item.name}
											</td>
											<td>
												${item.address}
											</td>
											<td>
												${item.managerName}
											</td>
											<td>
												${item.managerPhone}
											</td>
											<td>
												${item.floorArea}
											</td>
											<td>
												${item.areaRent}
											</td>
											<td>
												${item.serviceCost}
											</td>
											<td>
												<button class="btn btn-xs btn-info">
													<i class="ace-icon fa fa-pencil bigger-120"></i>
												</button>
												<button class="btn btn-xs btn-info" data-toggle="tooltip" title="Giao tòa nhà"
																onclick="assignmentBuilding(1)">
													<i class="fa fa-bars" aria-hiden="true"></i>
												</button>
											</td>
										</tr>
																		
									</c:forEach>
										
										
									</tbody>
								</table>
							</div>
						</div>
						
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->
			
			<!-- assingment building Modal -->
		<div class="modal fade" id="assignmentBuildingModel" role="dialog">
			<div class="modal-dialog">
			
			  <!-- Modal content-->
			  <div class="modal-content">
				<div class="modal-header">
				  <button type="button" class="close" data-dismiss="modal">&times;</button>
				  <h4 class="modal-title">Danh sách nhân viên</h4>
				</div>
				<div class="modal-body">
					<table class="table table-bordered" id="staffList">
						<thead>
						  <tr>
							<th>Chọn nhân viên</th>
							<th>Tên nhân viên</th>
						  </tr>
						</thead>
						<tbody>
						  <tr>
							<td><input type="checkbox" value="2" id="checkbox_2"/></td>
							<td>Nguyễn văn B</td>
						  </tr>
						  <tr>
							<td><input type="checkbox" value="3" id="checkbox_3"/></td>
							<td>Nguyễn Văn C</td>
						  </tr>
						  <tr>
							<td><input type="checkbox" value="4" id="checkbox_4"/></td>
							<td>Nguyễn Văn D</td>
						  </tr>
						</tbody>
					</table>
					<input type="hidden" id="buildingId" name="buildingId" value="">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" id="btnAssignBuilding">Giao tòa nhà</button>
				  	<button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
				</div>
			  </div>
			  
			</div>
		</div>

<script>
			function assignmentBuilding(buildingId){
				openModelAssignBuilding();
				$('#buildingId').val(buildingId);
				console.log($('#buildingId').val());
			}

			function openModelAssignBuilding(){
				$('#assignmentBuildingModel').modal();
			}
			$('#btnAssignBuilding').click(function (e) { 
				e.preventDefault();
				var data = {};
				data['buildingId'] = $('#buildingId').val();
				//$('#staffList').find('tbody input[type=checkbox]')
				var staffs = $('#staffList').find('tbody input[type=checkbox]:checked').map(function () {
					return $(this).val();
				}).get();
				data['staffs'] = staffs;
				assignStaff(data);
			});

			function assignStaff(data){
				$.ajax({
                    type: "post",
                    url: "/api-user-assignment",
                    data: JSON.stringify(data),
                    dataType: "json",
					contentType: "application/json",
                    success: function (response) {
                        
                    },
					error: function (response) {
                        
                    }
                });
			}

			$('#btnDeleteBuilding').click(function (e) { 
				e.preventDefault();
				var data = {};
				var buildingIds = $('#buildingList').find('tbody input[type=checkbox]:checked').map(function () {
					return $(this).val();
				}).get();
				data['buildingIds'] = buildingIds;
				deleteBuilding(data);
			});
			function deleteBuilding(data){
				$.ajax({
                    type: "Delete",
                    url: "/api-user-assignment",
                    data: JSON.stringify(data),
                    dataType: "json",
					contentType: "application/json",
                    success: function (response) {
                        
                    },
					error: function (response) {
                        
                    }
                });
			}
			
			$('#btnSearch').click(function (e) { 
				e.preventDefault();
				${'listForm'}.submit();
			});
		</script>
</body>
</html>